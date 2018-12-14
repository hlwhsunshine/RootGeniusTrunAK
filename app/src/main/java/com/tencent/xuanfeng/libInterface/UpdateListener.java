package com.tencent.xuanfeng.libInterface;

public interface UpdateListener {
    public static final int ERROR_UPDATE = 16;
    public static final int ERROR_UPDATE_NEXT_TIME = 17;
    public static final int STATUS_QUERYING = 0;
    public static final int STAUTS_DOWNLOADING = 1;

    void UpdateError(int i);

    void UpdateStatus(int i);

    void UpdateSuccess();
}
