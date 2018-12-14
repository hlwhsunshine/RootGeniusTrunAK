package com.shuame.rootgenius.common.qqdownload;

import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.tencent.xuanfeng.libInterface.OnFileDownloadListener;

/* renamed from: com.shuame.rootgenius.common.qqdownload.h */
public interface C1319h extends OnFileDownloadListener {
    void onStatusChanged(int i, Status status);
}
