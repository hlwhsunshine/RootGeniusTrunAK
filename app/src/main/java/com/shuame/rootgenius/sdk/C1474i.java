package com.shuame.rootgenius.sdk;

import com.shuame.rootgenius.sdk.proto.ProtoData.RootSolution;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.shuame.rootgenius.sdk.i */
public final class C1474i {
    /* renamed from: a */
    public static String f4065a = "";

    /* renamed from: a */
    public static String m4107a(int i) {
        return f4065a + "id-" + i + "/";
    }

    /* renamed from: a */
    private boolean m4108a(RootSolution rootSolution, boolean z) {
        boolean a;
        IOException e;
        try {
            String str = f4065a + rootSolution.f4068id;
            a = C1474i.m4109a(str, rootSolution, true);
            if (a) {
                return a;
            }
            try {
                CommUtils.unzip(C1469d.m4073b().getAssets().open(RgsdkConfig.AZ_RGSDK), "Data/Sol/" + rootSolution.f4068id, str);
                return C1474i.m4109a(str, rootSolution, true);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            a = false;
            e = iOException;
        }
        e.printStackTrace();
        return a;
    }

    /* renamed from: a */
    private static boolean m4109a(String str, RootSolution rootSolution, boolean z) {
        boolean z2 = false;
        String a = C1474i.m4107a(rootSolution.f4068id);
        try {
            InputStream fileInputStream = new FileInputStream(str);
            if (!z || rootSolution.md5.isEmpty() || CommUtils.checkFileMd5(str, rootSolution.md5)) {
                z2 = true;
                CommUtils.unzip(fileInputStream, a);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return z2;
    }

    /* renamed from: a */
    public final boolean mo7288a(RootSolution rootSolution, StringBuilder stringBuilder) {
        String str;
        boolean z;
        String str2 = "";
        if (m4108a(rootSolution, true)) {
            str = str2;
            z = true;
        } else {
            String str3 = f4065a + rootSolution.f4068id;
            new File(str3).getParentFile().mkdirs();
            for (int i = 2; i > 0; i--) {

                int download = CommUtils.download(rootSolution.url, str3);//下载的操作
                if (download == 0) {
                    String calcFileMd5 = CommUtils.calcFileMd5(str3);
                    if (calcFileMd5.equalsIgnoreCase(rootSolution.md5)) {
                        String a = C1474i.m4107a(rootSolution.f4068id);
                        if (rootSolution.type.equals("lua") || (rootSolution.type.equals("so") && CommUtils.unzip(str3, a))) {
                            str = str2;
                            z = true;
                        } else if (rootSolution.type.equals("lua") || rootSolution.type.equals("so")) {
                            str = "[rgsdk]unzip solution fail,error:" + download + ",md5 error,net md5:" + rootSolution.md5 + "url:" + rootSolution.url + " calc md5:" + calcFileMd5;
                            z = false;
                        } else {
                            str = "[rgsdk]unsupport solution type";
                            z = false;
                        }
                    } else {
                        str2 = "[rgsdk]download solution fail,error:" + download + ",md5 error,net md5:" + rootSolution.md5 + "url:" + rootSolution.url + " calc md5:" + calcFileMd5;
                    }
                } else {
                    str2 = "[rgsdk]download solution fail,error:" + download + ",url:" + rootSolution.url;
                }
            }
            str = str2;
            z = false;
        }
        if (stringBuilder != null) {
            stringBuilder.append(str);
        }
        return z;
    }
}
