package com.shuame.rootgenius.sdk.proto;

import java.io.Serializable;
import java.util.ArrayList;

public class ProtoData {

    public static class ActExit {
        public int code;
        public String mac = "";
    }

    public static class AdbInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public String pid = "";
        public String prot = "";
        public String serial = "";
        public String vid = "";
    }

    public static class Asset {
        public String md5 = "";
        public int size = 0;
        public String url = "";
    }

    public static class CpuInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public String arch = "";
        public int cores = 1;
        public String hardware = "";
        public String processor = "";
    }

    public static class DeviceSolution {
        public String productId = "";
        public String productName = "";
        /* renamed from: su */
        public Asset f4066su;
        public String suPath = "";
        public boolean support = true;
    }

    public static class PhoneId implements Serializable {
        private static final long serialVersionUID = 1;
        public String imsi = "";
        public String mac = "";
        public String packageName = "";
        public String phimei = "";
        public String phimeiex = "";
        public String phsn = "";
        public String qimei = "";
        public String rid = "";
    }

    public static class PhoneInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public AdbInfo adb = new AdbInfo();
        public String androidVersion = "";
        public String buildDescription = "";
        public String buildFingerPrint = "";
        public String buildId = "";
        public String buildVersionSdk = "";
        public CpuInfo cpuInfo = new CpuInfo();
        public String hardware = "";
        public String kernel = "";
        public String phoneHardware = "";
        public String phoneId = "";
        public String productBoard = "";
        public String productBrand = "";
        public String productDevice = "";
        public String productId = "";
        public String productManufacturer = "";
        public String productModel = "";
        public String region = "";
        public String resolution = "";
    }

    public static class QueryRootingResult {
        public String neo = "";
        public String productId = "";
        public String productName = "";
        public int result = 0;
        public Asset rootEngine;
        public ArrayList solus = new ArrayList();
        /* renamed from: su */
        public Asset f4067su;
    }

    public enum QuerySupportResult {
        Support,
        Unsupport,
        Fail
    }

    public static class RootResult implements Serializable {
        public static final int FLAG_ROOT_BY_SUPPORT_TIP = 8;
        private static final long serialVersionUID = 1;
        public int flag = 0;
        public PhoneId phoneId = new PhoneId();
        public PhoneInfo phoneInfo = new PhoneInfo();
        public int totalTimeUsed;
        public TriedSolutions triedSolutions = new TriedSolutions();
    }

    public static class RootSolution {
        /* renamed from: id */
        public int f4068id;
        public String md5 = "";
        public String param = "";
        public String type = "lua";
        public String url = "";
    }

    public static class RootingDev {
        public boolean inited = false;
        public PhoneId phoneId = new PhoneId();
        public PhoneInfo phoneInfo = new PhoneInfo();
    }

    public static class ServerConf {
        public int val;
    }

    public static class Tried implements Serializable {
        private static final long serialVersionUID = 1;
        public String description = "";
        /* renamed from: id */
        public int f4069id;
        public int result;
        public int timeUsed;
    }

    public static class TriedSolutions implements Serializable {
        private static final long serialVersionUID = 1;
        public boolean rooted;
        public ArrayList triedList = new ArrayList();
    }

    public static class UnrootResult {
        public String description = "";
        public PhoneId phoneId = new PhoneId();
        public int result;
    }

    public static class UpdateReq {
        public String mac = "";
        public String osArch = "";
        public String osName = "";
    }

    public static class UpdateResp {
        public boolean isSuccess;
        public String kinguserMd5 = "";
        public String kinguserUrl = "";
        public String md5 = "";
        public int size;
        public String suPackageName = "";
        public String url = "";
        public int versionCode;
        public String versionName = "";
    }
}
