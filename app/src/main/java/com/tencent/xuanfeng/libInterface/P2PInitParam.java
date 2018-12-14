package com.tencent.xuanfeng.libInterface;

public class P2PInitParam {
    static int uiCustomId;
    public String szPerformanceConfigFile = "";
    private String szUUID = "";

    public P2PInitParam(int i, String str) {
        uiCustomId = i;
        if (str != null) {
            this.szUUID = str;
        }
    }
}
