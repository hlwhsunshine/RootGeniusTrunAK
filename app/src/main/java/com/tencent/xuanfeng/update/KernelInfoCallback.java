package com.tencent.xuanfeng.update;

public interface KernelInfoCallback {
    public static final int DOWNLOAD_ERROR_MD5_FAILED = 32;
    public static final int DOWNLOAD_ERROR_MD5_RESPONSE = 33;
    public static final int DOWNLOAD_SUCCESSED = 0;
    public static final int QUERY_ERROR_RESPONSE = 2;
    public static final int QUERY_ERROR_TIMEOUT = 1;
    public static final int QUERY_ERROR_UnsupportedEncodingException = 3;
    public static final int QUERY_SUCCESSED = 0;
    public static final int QUERY_SUCCESSED_NEEDUPDATE = 257;
    public static final int QUERY_SUCCESSED_NONEEDUPDATE = 256;

    void DownloadUpdateError(int i);

    void DownloadUpdateSucess(KernelModuleInfo kernelModuleInfo);

    void QueryUpadteNoUpdate();

    void QueryUpdateError(int i);

    void QueryUpdateNeedUpdate(KernelModuleInfo kernelModuleInfo);
}
