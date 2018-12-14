package com.shuame.rootgenius.sdk;

public class RgsdkConfig {
    public static final String AZ_RGSDK = "rgsdk";
    public static final String RGSDK_PREF = "rgpref";
    public static final String SCHEME = "http://";
    public static final String SERV_PREFIX = "/v2/m";
    public static final String SERV_STAT_PREFIX = "/v2/stat/m";
    public static final boolean TEMP_ROOT = false;
    public static boolean TEST = false;
    public static final int sChVersionCode = 84;
    public static String sChVersionName = "general_mobile";
    public static String sServer;
    public static String sServerStat;

    static {
        if (TEST) {
            sServer = "api1.shuame.org";
            sServerStat = "api.shuame.org";
            return;
        }
        sServer = "api1.rootjl.com";
        sServerStat = "api2.rootjl.com";
    }

    public static void SetTest(boolean z) {
        TEST = z;
        if (z) {
            sServer = "api1.shuame.org";
            sServerStat = "api.shuame.org";
            return;
        }
        sServer = "api1.rootjl.com";
        sServerStat = "api2.rootjl.com";
    }

    public static void SetVersionName(String str) {
        sChVersionName = str;
    }
}
