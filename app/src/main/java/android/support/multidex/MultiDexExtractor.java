package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private static Method sApplyMethod;

    static {
        try {
            sApplyMethod = Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException e) {
            sApplyMethod = null;
        }
    }

    MultiDexExtractor() {
    }

    private static void apply(Editor editor) {
        if (sApplyMethod != null) {
            try {
                sApplyMethod.invoke(editor, new Object[0]);
                return;
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        }
        editor.commit();
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Closeable inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(str, EXTRACTED_SUFFIX, file.getParentFile());
        new StringBuilder("Extracting ").append(createTempFile.getPath());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            new StringBuilder("Renaming to ").append(file.getPath());
            if (createTempFile.renameTo(file)) {
                closeQuietly(inputStream);
                createTempFile.delete();
                return;
            }
            throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } catch (Throwable th) {
            closeQuietly(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    private static boolean isModified(Context context, File file, long j) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        return (multiDexPreferences.getLong(KEY_TIME_STAMP, -1) == getTimeStamp(file) && multiDexPreferences.getLong(KEY_CRC, -1) == j) ? false : true;
    }

    static List<File> load(Context context, ApplicationInfo applicationInfo, File file, boolean z) {
        List<File> loadExistingExtractions;
        new StringBuilder("MultiDexExtractor.load(").append(applicationInfo.sourceDir).append(", ").append(z).append(")");
        File file2 = new File(applicationInfo.sourceDir);
        long zipCrc = getZipCrc(file2);
        if (!(z || isModified(context, file2, zipCrc))) {
            try {
                loadExistingExtractions = loadExistingExtractions(context, file2, file);
            } catch (IOException e) {
            }
            new StringBuilder("load found ").append(loadExistingExtractions.size()).append(" secondary dex files");
            return loadExistingExtractions;
        }
        loadExistingExtractions = performExtractions(file2, file);
        putStoredApkInfo(context, getTimeStamp(file2), zipCrc, loadExistingExtractions.size() + 1);
        new StringBuilder("load found ").append(loadExistingExtractions.size()).append(" secondary dex files");
        return loadExistingExtractions;
    }

    private static List<File> loadExistingExtractions(Context context, File file, File file2) {
        String str = file.getName() + EXTRACTED_NAME_EXT;
        int i = getMultiDexPreferences(context).getInt(KEY_DEX_NUMBER, 1);
        List<File> arrayList = new ArrayList(i);
        int i2 = 2;
        while (i2 <= i) {
            File file3 = new File(file2, str + i2 + EXTRACTED_SUFFIX);
            if (file3.isFile()) {
                arrayList.add(file3);
                if (verifyZipFile(file3)) {
                    i2++;
                } else {
                    new StringBuilder("Invalid zip file: ").append(file3);
                    throw new IOException("Invalid ZIP file.");
                }
            }
            throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
        }
        return arrayList;
    }

    private static void mkdirChecked(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                new StringBuilder("Failed to create dir ").append(file.getPath()).append(". Parent file is null.");
            } else {
                new StringBuilder("Failed to create dir ").append(file.getPath()).append(". parent file is a dir ").append(parentFile.isDirectory()).append(", a file ").append(parentFile.isFile()).append(", exists ").append(parentFile.exists()).append(", readable ").append(parentFile.canRead()).append(", writable ").append(parentFile.canWrite());
            }
            throw new IOException("Failed to create cache directory " + file.getPath());
        }
    }

    private static List<File> performExtractions(File file, File file2) {
        String str = file.getName() + EXTRACTED_NAME_EXT;
        prepareDexDir(file2, str);
        List<File> arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i = 2;
            while (entry != null) {
                File file3 = new File(file2, str + i + EXTRACTED_SUFFIX);
                arrayList.add(file3);
                new StringBuilder("Extraction is needed for file ").append(file3);
                boolean z = false;
                int i2 = 0;
                while (i2 < 3 && !z) {
                    int i3 = i2 + 1;
                    extract(zipFile, entry, file3, str);
                    boolean verifyZipFile = verifyZipFile(file3);
                    new StringBuilder("Extraction ").append(verifyZipFile ? "success" : "failed").append(" - length ").append(file3.getAbsolutePath()).append(": ").append(file3.length());
                    if (!verifyZipFile) {
                        file3.delete();
                        if (file3.exists()) {
                            new StringBuilder("Failed to delete corrupted secondary dex '").append(file3.getPath()).append("'");
                            z = verifyZipFile;
                            i2 = i3;
                        }
                    }
                    z = verifyZipFile;
                    i2 = i3;
                }
                if (z) {
                    i2 = i + 1;
                    entry = zipFile.getEntry(new StringBuilder(DEX_PREFIX).append(i2).append(DEX_SUFFIX).toString());
                    i = i2;
                } else {
                    throw new IOException("Could not create zip file " + file3.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    private static void prepareDexDir(File file, final String str) {
        mkdirChecked(file.getParentFile());
        mkdirChecked(file);
        File[] listFiles = file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                return !file.getName().startsWith(str);
            }
        });
        if (listFiles == null) {
            new StringBuilder("Failed to list secondary dex dir content (").append(file.getPath()).append(").");
            return;
        }
        for (File file2 : listFiles) {
            new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
            if (file2.delete()) {
                new StringBuilder("Deleted old file ").append(file2.getPath());
            } else {
                new StringBuilder("Failed to delete old file ").append(file2.getPath());
            }
        }
    }

    private static void putStoredApkInfo(Context context, long j, long j2, int i) {
        Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(KEY_TIME_STAMP, j);
        edit.putLong(KEY_CRC, j2);
        edit.putInt(KEY_DEX_NUMBER, i);
        apply(edit);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A:{ExcHandler: java.util.zip.ZipException (e java.util.zip.ZipException), Splitter: B:0:0x0000} */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A:{ExcHandler: java.util.zip.ZipException (e java.util.zip.ZipException), Splitter: B:0:0x0000} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:7:?, code:
            new java.lang.StringBuilder("Failed to close zip file: ").append(r2.getAbsolutePath());
     */
    /* JADX WARNING: Missing block: B:10:0x001c, code:
            new java.lang.StringBuilder("File ").append(r2.getAbsolutePath()).append(" is not a valid zip file.");
     */
    static boolean verifyZipFile(java.io.File r2) {
        /*
        r0 = new java.util.zip.ZipFile;	 Catch:{ ZipException -> 0x001b, IOException -> 0x0031 }
        r0.<init>(r2);	 Catch:{ ZipException -> 0x001b, IOException -> 0x0031 }
        r0.close();	 Catch:{ IOException -> 0x000a, ZipException -> 0x001b }
        r0 = 1;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = move-exception;
        r0 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x001b, IOException -> 0x0031 }
        r1 = "Failed to close zip file: ";
        r0.<init>(r1);	 Catch:{ ZipException -> 0x001b, IOException -> 0x0031 }
        r1 = r2.getAbsolutePath();	 Catch:{ ZipException -> 0x001b, IOException -> 0x0031 }
        r0.append(r1);	 Catch:{ ZipException -> 0x001b, IOException -> 0x0031 }
    L_0x0019:
        r0 = 0;
        goto L_0x0009;
    L_0x001b:
        r0 = move-exception;
        r0 = new java.lang.StringBuilder;
        r1 = "File ";
        r0.<init>(r1);
        r1 = r2.getAbsolutePath();
        r0 = r0.append(r1);
        r1 = " is not a valid zip file.";
        r0.append(r1);
        goto L_0x0019;
    L_0x0031:
        r0 = move-exception;
        r0 = new java.lang.StringBuilder;
        r1 = "Got an IOException trying to open zip file: ";
        r0.<init>(r1);
        r1 = r2.getAbsolutePath();
        r0.append(r1);
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDexExtractor.verifyZipFile(java.io.File):boolean");
    }
}
