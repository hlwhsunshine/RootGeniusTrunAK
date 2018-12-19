package com.shuame.rootgenius.sdk.p114a;

import com.shuame.rootgenius.sdk.C1473h;
import com.shuame.rootgenius.sdk.CommUtils;

/* renamed from: com.shuame.rootgenius.sdk.a.b */
public class C1464b extends C1463a {
    /* renamed from: d */
    private static final String f4031d = C1464b.class.getSimpleName();
    /* renamed from: e */
    private String f4032e = "";

    public C1464b(String str) {
        super(str);
    }

    /* renamed from: a */
    public final String mo7258a(String str) {
        return this.f4032e + str;
    }


    /**
     *
     * @param str getFileDir()+Data/download+super的文件名
     * @param str2 md5码
     * @return
     */
    /* renamed from: a */
    public final boolean mo7264a(String str, String str2) {
        C1473h.m4104c(f4031d, "try to load superuser file :" + str);
        if (str == null) {
            return false;
        }
        //md5码等于null 或者str文件路径的文件md5 和传入进来的md5相同
        if (str2 == null || CommUtils.calcFileMd5(str).compareToIgnoreCase(str2) == 0) {
            //mo7257a()  =  getFileDir()
            this.f4032e = mo7257a() + "Data/sutmp/";
            //解压文件，str-NewSuperSU的文件路径
            if (CommUtils.unzip(str, this.f4032e, "cdf283818fda91abb904873e7125055e")) {
                //从getFileDir()+"Data/sutmp/"+"info"读取文件
                String readFrom = CommUtils.readFrom(mo7258a("info"));
                if (readFrom != null) {
                    this.f4027a = CommUtils.StringSplitToHash(readFrom, ':', 10);
                }
                readFrom = mo7257a() + "Data/Bin/";
                //a getFileDir()+Data/sutmp/
                String a = mo7258a("install");
                StringBuilder append = new StringBuilder().append(mo7257a());
                getClass();
                //读取info文件替换
                readFrom = CommUtils.readFrom(a).replace("bb=/data/local/tmp/busybox", "bb=" + readFrom + "busybox").replace("/data/local/tmp/superuser", append.append("Data/sutmp").toString()).replace("/data/local/tmp/", mo7257a() + "Data/");
                C1473h.m4102a("RootSuite", "install_script:" + readFrom);
                CommUtils.writeTo(readFrom, a);//重新写入install
                C1473h.m4104c(f4031d, "try to load superuser success");
                return true;
            }
            C1473h.m4106e(f4031d, "unzip fail");
            return false;
        }
        C1473h.m4106e(f4031d, "error md5 unmatch:" + str2 + " file md5:" + CommUtils.calcFileMd5(str));
        return false;
    }

    /* renamed from: e */
    public final String mo7261e() {
        return mo7258a("install");
    }
}
