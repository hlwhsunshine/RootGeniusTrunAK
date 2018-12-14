package com.tencent.xuanfeng.libInterface;

import java.util.ArrayList;

public class TASKINFO {
    public long ailableSize;
    public boolean bOnlySrcUrl;
    public boolean callbackLinkInfo;
    public String cookie = "";
    public long fileSize;
    public int iMaxOrgSpeed;
    public int iProjectModel;
    public ArrayList<LinkStruct> list = new ArrayList();
    public int netDownloadType;
    public int priority;
    public String referer = "";
    public String strFileName;
    public String strPathName;
    public String strUrl;
    public int timeoutSecond;
    private int uiCustomId = P2PInitParam.uiCustomId;
    public int uiTaskID;
    public String xf_fid;
}
