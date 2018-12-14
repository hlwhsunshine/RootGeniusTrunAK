package android.support.multidex;

import android.content.Context;
import android.content.p013pm.PackageManager;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class MultiDex {
    private static final boolean IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
    private static final int MAX_SUPPORTED_SDK_VERSION = 20;
    private static final int MIN_SDK_VERSION = 4;
    private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
    private static final String SECONDARY_FOLDER_NAME = ("code_cache" + File.separator + OLD_SECONDARY_FOLDER_NAME);
    static final String TAG = "MultiDex";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
    private static final Set<String> installedApk = new HashSet();

    private static final class V14 {
        private V14() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) {
            Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
            MultiDex.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file));
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file) {
            return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
        }
    }

    private static final class V19 {
        private V19() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) {
            Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                Field access$300 = MultiDex.findField(classLoader, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr = (IOException[]) access$300.get(classLoader);
                if (iOExceptionArr == null) {
                    obj = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    Object obj2 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                    arrayList.toArray(obj2);
                    System.arraycopy(iOExceptionArr, 0, obj2, arrayList.size(), iOExceptionArr.length);
                    obj = obj2;
                }
                access$300.set(classLoader, obj);
            }
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    /* renamed from: android.support.multidex.MultiDex$V4 */
    private static final class C0059V4 {
        private C0059V4() {
        }

        private static void install(ClassLoader classLoader, List<File> list) {
            int size = list.size();
            Field access$300 = MultiDex.findField(classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) access$300.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            access$300.set(classLoader, stringBuilder.toString());
            MultiDex.expandFieldArray(classLoader, "mPaths", strArr);
            MultiDex.expandFieldArray(classLoader, "mFiles", fileArr);
            MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr);
            MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr);
        }
    }

    private MultiDex() {
    }

    private static boolean checkValidZipFiles(List<File> list) {
        for (File verifyZipFile : list) {
            if (!MultiDexExtractor.verifyZipFile(verifyZipFile)) {
                return false;
            }
        }
        return true;
    }

    private static void clearOldDexDir(Context context) {
        File file = new File(context.getFilesDir(), OLD_SECONDARY_FOLDER_NAME);
        if (file.isDirectory()) {
            new StringBuilder("Clearing old secondary dex dir (").append(file.getPath()).append(").");
            File[] listFiles = file.listFiles();
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
            if (file.delete()) {
                new StringBuilder("Deleted old secondary dex dir ").append(file.getPath());
            } else {
                new StringBuilder("Failed to delete secondary dex dir ").append(file.getPath());
            }
        }
    }

    private static void expandFieldArray(Object obj, String str, Object[] objArr) {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
    }

    private static Field findField(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method findMethod(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static ApplicationInfo getApplicationInfo(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            return (packageManager == null || packageName == null) ? null : packageManager.getApplicationInfo(packageName, 128);
        } catch (RuntimeException e) {
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:51:?, code:
            return;
     */
    public static void install(android.content.Context r6) {
        /*
        r0 = IS_VM_MULTIDEX_CAPABLE;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 4;
        if (r0 >= r1) goto L_0x0027;
    L_0x000a:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Multi dex installation failed. SDK ";
        r1.<init>(r2);
        r2 = android.os.Build.VERSION.SDK_INT;
        r1 = r1.append(r2);
        r2 = " is unsupported. Min SDK version is 4.";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0027:
        r0 = getApplicationInfo(r6);	 Catch:{ Exception -> 0x003f }
        if (r0 == 0) goto L_0x0004;
    L_0x002d:
        r1 = installedApk;	 Catch:{ Exception -> 0x003f }
        monitor-enter(r1);	 Catch:{ Exception -> 0x003f }
        r2 = r0.sourceDir;	 Catch:{ all -> 0x003c }
        r3 = installedApk;	 Catch:{ all -> 0x003c }
        r3 = r3.contains(r2);	 Catch:{ all -> 0x003c }
        if (r3 == 0) goto L_0x005f;
    L_0x003a:
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        goto L_0x0004;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        throw r0;	 Catch:{ Exception -> 0x003f }
    L_0x003f:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Multi dex installation failed (";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r2 = ").";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x005f:
        r3 = installedApk;	 Catch:{ all -> 0x003c }
        r3.add(r2);	 Catch:{ all -> 0x003c }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x003c }
        r3 = 20;
        if (r2 <= r3) goto L_0x008c;
    L_0x006a:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003c }
        r3 = "MultiDex is not guaranteed to work in SDK version ";
        r2.<init>(r3);	 Catch:{ all -> 0x003c }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x003c }
        r2 = r2.append(r3);	 Catch:{ all -> 0x003c }
        r3 = ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003c }
        r3 = "java.vm.version";
        r3 = java.lang.System.getProperty(r3);	 Catch:{ all -> 0x003c }
        r2 = r2.append(r3);	 Catch:{ all -> 0x003c }
        r3 = "\"";
        r2.append(r3);	 Catch:{ all -> 0x003c }
    L_0x008c:
        r2 = r6.getClassLoader();	 Catch:{ RuntimeException -> 0x0095 }
        if (r2 != 0) goto L_0x0099;
    L_0x0092:
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        goto L_0x0004;
    L_0x0095:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        goto L_0x0004;
    L_0x0099:
        clearOldDexDir(r6);	 Catch:{ Throwable -> 0x00cd }
    L_0x009c:
        r3 = new java.io.File;	 Catch:{ all -> 0x003c }
        r4 = r0.dataDir;	 Catch:{ all -> 0x003c }
        r5 = SECONDARY_FOLDER_NAME;	 Catch:{ all -> 0x003c }
        r3.<init>(r4, r5);	 Catch:{ all -> 0x003c }
        r4 = 0;
        r4 = android.support.multidex.MultiDexExtractor.load(r6, r0, r3, r4);	 Catch:{ all -> 0x003c }
        r5 = checkValidZipFiles(r4);	 Catch:{ all -> 0x003c }
        if (r5 == 0) goto L_0x00b6;
    L_0x00b0:
        installSecondaryDexes(r2, r3, r4);	 Catch:{ all -> 0x003c }
    L_0x00b3:
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        goto L_0x0004;
    L_0x00b6:
        r4 = 1;
        r0 = android.support.multidex.MultiDexExtractor.load(r6, r0, r3, r4);	 Catch:{ all -> 0x003c }
        r4 = checkValidZipFiles(r0);	 Catch:{ all -> 0x003c }
        if (r4 == 0) goto L_0x00c5;
    L_0x00c1:
        installSecondaryDexes(r2, r3, r0);	 Catch:{ all -> 0x003c }
        goto L_0x00b3;
    L_0x00c5:
        r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x003c }
        r2 = "Zip files were not valid.";
        r0.<init>(r2);	 Catch:{ all -> 0x003c }
        throw r0;	 Catch:{ all -> 0x003c }
    L_0x00cd:
        r3 = move-exception;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDex.install(android.content.Context):void");
    }

    private static void installSecondaryDexes(ClassLoader classLoader, File file, List<File> list) {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                V19.install(classLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                V14.install(classLoader, list, file);
            } else {
                C0059V4.install(classLoader, list);
            }
        }
    }

    static boolean isVMMultidexCapable(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        new StringBuilder("VM with version ").append(str).append(z ? " has multidex support" : " does not have multidex support");
        return z;
    }
}
