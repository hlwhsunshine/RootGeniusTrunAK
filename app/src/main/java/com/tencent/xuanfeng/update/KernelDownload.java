package com.tencent.xuanfeng.update;

import java.net.HttpURLConnection;

public class KernelDownload {
    private HttpURLConnection connection = null;
    private KernelInfoCallback downloadCallBack = null;
    private Thread downloadThread = null;
    private String kernelName = null;
    private String kernelSaveDir = null;
    private KernelModuleInfo moduleInfo = null;

    class DownloadThread implements Runnable {
        DownloadThread() {
        }

        public void run() {
            KernelDownload.this.downloadKernel(KernelDownload.this.moduleInfo.kernelUpdateUrl);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081 A:{SYNTHETIC, Splitter: B:18:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    private void downloadKernel(java.lang.String r11) {
        /*
        r10 = this;
        r1 = 0;
        r2 = 33;
        r4 = 0;
        r0 = new java.net.URL;	 Catch:{ IOException -> 0x00b1 }
        r0.<init>(r11);	 Catch:{ IOException -> 0x00b1 }
        r0 = r0.openConnection();	 Catch:{ IOException -> 0x00b1 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x00b1 }
        r10.connection = r0;	 Catch:{ IOException -> 0x00b1 }
        r0 = r10.connection;	 Catch:{ IOException -> 0x00b1 }
        r3 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        r0.setConnectTimeout(r3);	 Catch:{ IOException -> 0x00b1 }
        r0 = r10.connection;	 Catch:{ IOException -> 0x00b1 }
        r3 = 1;
        r0.setDoInput(r3);	 Catch:{ IOException -> 0x00b1 }
        r0 = r10.connection;	 Catch:{ IOException -> 0x00b1 }
        r0 = r0.getInputStream();	 Catch:{ IOException -> 0x00b1 }
        r3 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
        r5 = new byte[r3];	 Catch:{ IOException -> 0x009b }
        r6 = new java.io.File;	 Catch:{ IOException -> 0x009b }
        r3 = r10.kernelSaveDir;	 Catch:{ IOException -> 0x009b }
        r7 = r10.kernelName;	 Catch:{ IOException -> 0x009b }
        r6.<init>(r3, r7);	 Catch:{ IOException -> 0x009b }
        r3 = r6.exists();	 Catch:{ IOException -> 0x009b }
        if (r3 == 0) goto L_0x003c;
    L_0x0039:
        r6.delete();	 Catch:{ IOException -> 0x009b }
    L_0x003c:
        r6.createNewFile();	 Catch:{ IOException -> 0x009b }
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x009b }
        r3.<init>(r6);	 Catch:{ IOException -> 0x009b }
        r7 = r10.connection;	 Catch:{ IOException -> 0x009b }
        r7 = r7.getResponseCode();	 Catch:{ IOException -> 0x009b }
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 != r8) goto L_0x009e;
    L_0x004e:
        r7 = 0;
        r8 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
        r7 = r0.read(r5, r7, r8);	 Catch:{ IOException -> 0x009b }
        r8 = -1;
        if (r7 != r8) goto L_0x0096;
    L_0x0059:
        r3.flush();	 Catch:{ IOException -> 0x009b }
        r3.close();	 Catch:{ IOException -> 0x009b }
        r3 = com.tencent.xuanfeng.update.UpdateUtility.getFileMD5(r6);	 Catch:{ IOException -> 0x009b }
        r3 = r3.toLowerCase();	 Catch:{ IOException -> 0x009b }
        r5 = r10.moduleInfo;	 Catch:{ IOException -> 0x009b }
        r5 = r5.kernelMD5;	 Catch:{ IOException -> 0x009b }
        r5 = r5.toLowerCase();	 Catch:{ IOException -> 0x009b }
        r3 = r3.equals(r5);	 Catch:{ IOException -> 0x009b }
        if (r3 == 0) goto L_0x0090;
    L_0x0075:
        r3 = r1;
        r1 = r4;
    L_0x0077:
        if (r3 == 0) goto L_0x007f;
    L_0x0079:
        r3.flush();	 Catch:{ IOException -> 0x009b }
        r3.close();	 Catch:{ IOException -> 0x009b }
    L_0x007f:
        if (r0 == 0) goto L_0x0084;
    L_0x0081:
        r0.close();	 Catch:{ IOException -> 0x00a0 }
    L_0x0084:
        if (r1 == 0) goto L_0x00a5;
    L_0x0086:
        r0 = r10.downloadCallBack;
        if (r0 == 0) goto L_0x00a5;
    L_0x008a:
        r0 = r10.downloadCallBack;
        r0.DownloadUpdateError(r1);
    L_0x008f:
        return;
    L_0x0090:
        r3 = 32;
        r9 = r1;
        r1 = r3;
        r3 = r9;
        goto L_0x0077;
    L_0x0096:
        r8 = 0;
        r3.write(r5, r8, r7);	 Catch:{ IOException -> 0x009b }
        goto L_0x004e;
    L_0x009b:
        r1 = move-exception;
    L_0x009c:
        r1 = r2;
        goto L_0x007f;
    L_0x009e:
        r1 = r2;
        goto L_0x0077;
    L_0x00a0:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0084;
    L_0x00a5:
        r0 = r10.downloadCallBack;
        if (r0 == 0) goto L_0x008f;
    L_0x00a9:
        r0 = r10.downloadCallBack;
        r1 = r10.moduleInfo;
        r0.DownloadUpdateSucess(r1);
        goto L_0x008f;
    L_0x00b1:
        r0 = move-exception;
        r0 = r1;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xuanfeng.update.KernelDownload.downloadKernel(java.lang.String):void");
    }

    public void setKernelInfoCallback(KernelInfoCallback kernelInfoCallback) {
        this.downloadCallBack = kernelInfoCallback;
    }

    public boolean startDownloadKernel(KernelModuleInfo kernelModuleInfo, String str, String str2) {
        if (this.downloadThread != null && this.downloadThread.isAlive()) {
            return false;
        }
        stopDownloadUpdate();
        this.moduleInfo = kernelModuleInfo;
        this.kernelSaveDir = str;
        this.kernelName = str2;
        this.downloadThread = new Thread(new DownloadThread());
        this.downloadThread.start();
        return true;
    }

    public void stopDownloadUpdate() {
        if (this.connection != null) {
            this.connection.disconnect();
            this.connection = null;
        }
        if (this.downloadThread == null) {
            return;
        }
        if (this.downloadThread.isAlive()) {
            try {
                this.downloadThread.wait(2000);
                this.downloadThread = null;
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        this.downloadThread = null;
    }
}
