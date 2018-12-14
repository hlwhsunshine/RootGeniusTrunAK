package com.tencent.xuanfeng.libInterface;

public interface OnFileDownloadListener {
    void onComplete(int i, long j);

    void onDonwloadInfo(int i, LinkStruct[] linkStructArr);

    void onFileName(int i, String str);

    void onOnlySrcUrl(int i);

    void onStorageErrorInfo(int i, int i2, String str);

    void onTaskInfo(int i, int i2, int i3);

    void onWaitStart(int i);
}
