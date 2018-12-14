package net.tsz.afinal.bitmap.download;

import java.io.File;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class SimpleDownloader implements Downloader {
    private static final int IO_BUFFER_SIZE = 8192;
    private static final String TAG = SimpleDownloader.class.getSimpleName();

    public class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }

        public long skip(long j) {
            long j2 = 0;
            while (j2 < j) {
                long skip = this.in.skip(j - j2);
                if (skip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    skip = 1;
                }
                j2 = skip + j2;
            }
            return j2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a A:{SYNTHETIC, Splitter: B:27:0x004a} */
    private byte[] getFromFile(java.io.File r7) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        r2.<init>(r7);	 Catch:{ Exception -> 0x0052, all -> 0x0045 }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0028 }
        r1.<init>();	 Catch:{ Exception -> 0x0028 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = new byte[r3];	 Catch:{ Exception -> 0x0028 }
    L_0x0012:
        r4 = r2.read(r3);	 Catch:{ Exception -> 0x0028 }
        r5 = -1;
        if (r4 != r5) goto L_0x0023;
    L_0x0019:
        r0 = r1.toByteArray();	 Catch:{ Exception -> 0x0028 }
        r2.close();	 Catch:{ IOException -> 0x0021 }
        goto L_0x0003;
    L_0x0021:
        r1 = move-exception;
        goto L_0x0003;
    L_0x0023:
        r5 = 0;
        r1.write(r3, r5, r4);	 Catch:{ Exception -> 0x0028 }
        goto L_0x0012;
    L_0x0028:
        r1 = move-exception;
    L_0x0029:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0050 }
        r4 = "Error in read from file - ";
        r3.<init>(r4);	 Catch:{ all -> 0x0050 }
        r3 = r3.append(r7);	 Catch:{ all -> 0x0050 }
        r4 = " : ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0050 }
        r3.append(r1);	 Catch:{ all -> 0x0050 }
        if (r2 == 0) goto L_0x0003;
    L_0x003f:
        r2.close();	 Catch:{ IOException -> 0x0043 }
        goto L_0x0003;
    L_0x0043:
        r1 = move-exception;
        goto L_0x0003;
    L_0x0045:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0048:
        if (r2 == 0) goto L_0x004d;
    L_0x004a:
        r2.close();	 Catch:{ IOException -> 0x004e }
    L_0x004d:
        throw r0;
    L_0x004e:
        r1 = move-exception;
        goto L_0x004d;
    L_0x0050:
        r0 = move-exception;
        goto L_0x0048;
    L_0x0052:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.tsz.afinal.bitmap.download.SimpleDownloader.getFromFile(java.io.File):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A:{SYNTHETIC, Splitter: B:25:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0068 A:{SYNTHETIC, Splitter: B:33:0x0068} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0068 A:{SYNTHETIC, Splitter: B:33:0x0068} */
    private byte[] getFromHttp(java.lang.String r8) {
        /*
        r7 = this;
        r1 = 0;
        r0 = new java.net.URL;	 Catch:{ IOException -> 0x007f, all -> 0x005f }
        r0.<init>(r8);	 Catch:{ IOException -> 0x007f, all -> 0x005f }
        r0 = r0.openConnection();	 Catch:{ IOException -> 0x007f, all -> 0x005f }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x007f, all -> 0x005f }
        r3 = new net.tsz.afinal.bitmap.download.SimpleDownloader$FlushedInputStream;	 Catch:{ IOException -> 0x0083, all -> 0x0072 }
        r2 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0083, all -> 0x0072 }
        r4 = r0.getInputStream();	 Catch:{ IOException -> 0x0083, all -> 0x0072 }
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r2.<init>(r4, r5);	 Catch:{ IOException -> 0x0083, all -> 0x0072 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x0083, all -> 0x0072 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x003a, all -> 0x0076 }
        r2.<init>();	 Catch:{ IOException -> 0x003a, all -> 0x0076 }
    L_0x0021:
        r4 = r3.read();	 Catch:{ IOException -> 0x003a, all -> 0x0076 }
        r5 = -1;
        if (r4 != r5) goto L_0x0036;
    L_0x0028:
        r1 = r2.toByteArray();	 Catch:{ IOException -> 0x003a, all -> 0x0076 }
        if (r0 == 0) goto L_0x0031;
    L_0x002e:
        r0.disconnect();
    L_0x0031:
        r3.close();	 Catch:{ IOException -> 0x006c }
    L_0x0034:
        r0 = r1;
    L_0x0035:
        return r0;
    L_0x0036:
        r2.write(r4);	 Catch:{ IOException -> 0x003a, all -> 0x0076 }
        goto L_0x0021;
    L_0x003a:
        r2 = move-exception;
        r6 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r6;
    L_0x003f:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007c }
        r5 = "Error in downloadBitmap - ";
        r4.<init>(r5);	 Catch:{ all -> 0x007c }
        r4 = r4.append(r8);	 Catch:{ all -> 0x007c }
        r5 = " : ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x007c }
        r4.append(r0);	 Catch:{ all -> 0x007c }
        if (r3 == 0) goto L_0x0058;
    L_0x0055:
        r3.disconnect();
    L_0x0058:
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        r2.close();	 Catch:{ IOException -> 0x006e }
    L_0x005d:
        r0 = r1;
        goto L_0x0035;
    L_0x005f:
        r0 = move-exception;
        r3 = r1;
    L_0x0061:
        if (r3 == 0) goto L_0x0066;
    L_0x0063:
        r3.disconnect();
    L_0x0066:
        if (r1 == 0) goto L_0x006b;
    L_0x0068:
        r1.close();	 Catch:{ IOException -> 0x0070 }
    L_0x006b:
        throw r0;
    L_0x006c:
        r0 = move-exception;
        goto L_0x0034;
    L_0x006e:
        r0 = move-exception;
        goto L_0x005d;
    L_0x0070:
        r1 = move-exception;
        goto L_0x006b;
    L_0x0072:
        r2 = move-exception;
        r3 = r0;
        r0 = r2;
        goto L_0x0061;
    L_0x0076:
        r1 = move-exception;
        r6 = r1;
        r1 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x0061;
    L_0x007c:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0061;
    L_0x007f:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        goto L_0x003f;
    L_0x0083:
        r2 = move-exception;
        r3 = r0;
        r0 = r2;
        r2 = r1;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.tsz.afinal.bitmap.download.SimpleDownloader.getFromHttp(java.lang.String):byte[]");
    }

    public byte[] download(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().toLowerCase().startsWith("http")) {
            return getFromHttp(str);
        }
        File file;
        if (str.trim().toLowerCase().startsWith("file:")) {
            try {
                file = new File(new URI(str));
                return (file.exists() && file.canRead()) ? getFromFile(file) : null;
            } catch (URISyntaxException e) {
                new StringBuilder("Error in read from file - ").append(str).append(" : ").append(e);
                return null;
            }
        }
        file = new File(str);
        return (file.exists() && file.canRead()) ? getFromFile(file) : null;
    }
}
