package com;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Environment;

import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.JniHelper;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.a.a;
import com.shuame.rootgenius.sdk.a.c;
import com.shuame.rootgenius.sdk.proto.ProtoBase;
import com.shuame.rootgenius.sdk.proto.ProtoData;
import com.shuame.rootgenius.sdk.proto.ProtoData$DeviceSolution;
import com.shuame.rootgenius.sdk.proto.ProtoData$QueryRootingResult;
import com.shuame.rootgenius.sdk.proto.ProtoData$RootResult;
import com.shuame.rootgenius.sdk.proto.ProtoData$RootSolution;
import com.shuame.rootgenius.sdk.proto.ProtoData$RootingDev;
import com.shuame.rootgenius.sdk.proto.ProtoData$ServerConf;
import com.shuame.rootgenius.sdk.proto.ProtoData$Tried;
import com.shuame.rootgenius.sdk.proto.ProtoData$UnrootResult;
import com.shuame.rootgenius.sdk.proto.b;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@SuppressLint(value = {"DefaultLocale"})
public class d {
    private static final String a;
    private ProtoData.RootingDev b;
    private ProtoData.RootResult c;
    private ProtoData.UnrootResult d;
    private ProtoData.ServerConf e;
    private static SoftReference f;
    private static String g;
    private static String h;
    private int i;
    private boolean j;
    private boolean k;
    private long l;
    private boolean m;
    private c n;
    private static d o;
    private a p;
    private String q;
    private g r;
    private ProtoData.QueryRootingResult s;
    private boolean t;
    private static HashMap u;
    private static BroadcastReceiver v;

    static {
        d.a = d.class.getSimpleName();
        d.f = null;
        d.g = null;
        d.h = null;
        d.o = new d();
        d.u = new HashMap();
        d.v = new e();
    }

    private d() {
        super();
        this.b = new ProtoData.RootingDev();
        this.c = new RootResult();
        this.d = new UnrootResult();
        this.e = new ServerConf();
        this.i = 0;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = new ProtoData.QueryRootingResult();
        this.t = false;
    }

    private com.shuame.rootgenius.sdk.c a(ProtoData.RootSolution arg12, Data arg13, boolean arg14) {
        int v0_8;
        String v3_4;
        Object v2_3;
        Object v0_6;
        StringBuilder v3;
        com.shuame.rootgenius.sdk.c v1 = new com.shuame.rootgenius.sdk.c(-1, 0);
        String v2 = "";
        h.c(d.a, "[tryRootingBy] start id:" + arg12.id + ",md5:" + arg12.md5 + ",url:" + arg12.url + ",type:" + arg12.type);
        ProtoData.Tried v4 = new ProtoData.Tried();
        long v6 = System.currentTimeMillis();
        arg13.field.put("solutionPath", arg13.field.get("workDir") + "Data/Sol/" + arg12.id);
        arg13.field.put("solutionParam", arg12.param);
        arg13.field.put("lastError", "");
        arg13.field.put("id", Integer.toString(arg12.id));
        arg13.field.put("solutionType", arg12.type);
        if (arg12.type.equals("so")) {
            arg13.field.put("soluWorkDir", i.a(arg12.id));
        }

        i v0 = new i();
        try {
            v3 = new StringBuilder();
            if (!v0.a(arg12, v3)) {//下载和解压文件的操作
                goto label_185;
            }

            d.a(arg12.id);//sp操作
            try {
                h.b(d.a, "suspendStatReport entry");
                ByteArrayOutputStream v0_5 = new ByteArrayOutputStream();
                ObjectOutputStream v3_1 = new ObjectOutputStream(((OutputStream) v0_5));
                v3_1.writeObject(this.c);//this.c 是RootResult
                v3_1.close();
                File v3_2 = new File(d.b().getFilesDir().getAbsolutePath() + "/stat");
                if (v3_2.exists()) {
                    v3_2.delete();
                }

                RandomAccessFile v5 = new RandomAccessFile(v3_2, "rwd");
                v5.write(v0_5.toByteArray());
                v5.close();
                goto label_106;
            } catch (IOException v0_3) {
                try {
                    v0_3.printStackTrace();
                    label_106:
                    h.c(d.a, "[tryRootingBy]entry rgMain");
                    v1.a = JniHelper.rgMain(arg13);
                    h.c(d.a, "[tryRootingBy]finish rgMain result:" + v1.a);
                    if (v1.a == 2) {
                        v1.a = -1;
                    }

                    v0_6 = arg13.field.get("lastError");
                    if (!arg14) {
                        goto label_128;
                    }

                    goto label_322;
                } catch (Exception v0_1) {
                    goto label_163;
                } catch (Throwable v0_2) {
                    goto label_171;
                }
            } catch (FileNotFoundException v0_4) {
                try {
                    v0_4.printStackTrace();
                    goto label_106;
                } catch (Exception v0_1) {
                    goto label_163;
                } catch (Throwable v0_2) {
                    goto label_171;
                }
            }
        } catch (Exception v0_1) {
            goto label_163;
        } catch (Throwable v0_2) {
            goto label_171;
        }

        label_128:
        try {
            v1.b = 0;
            if (v1.a == 0) {
                if (!arg12.type.equals("lua") && !this.p.d()) {
                    goto label_322;
                }

                v1.a = 1;
                if (!this.p.c) {
                    goto label_322;
                }

                v1.a = 2;
                if (this.g()) {
                    if (v1.b == 8) {
                        v1.b = 0;
                    }

                    v1.a = 1;
                    v2_3 = v0_6;
                    goto label_156;
                }

                if (!new File("/system/xbin/su").exists()) {
                    v1.a = -14;
                }

                goto label_183;
            }

            goto label_322;
        } catch (Throwable v2_1) {
            Object v3_3 = v0_6;
            goto label_173;
        } catch (Exception v2_2) {
            Exception v10 = v2_2;
            v2_3 = v0_6;
            v0_1 = v10;
            goto label_163;
        }

        label_183:
        v2_3 = v0_6;
        goto label_156;
        label_322:
        v2_3 = v0_6;
        goto label_156;
        try {
            label_185:
            v2 = v2 + v3.toString();
            goto label_156;
        } catch (Throwable v0_2) {
            label_171:
            v3_4 = v2;
            v2_1 = v0_2;
        } catch (Exception v0_1) {
            try {
                label_163:
                v0_1.printStackTrace();
                if (!arg14) {
                    goto label_234;
                }
            } catch (Throwable v0_2) {
                goto label_171;
            }

            com.shuame.rootgenius.sdk.c v0_7 = v1;
            return v0_7;
            label_234:
            v4.id = arg12.id;
            v0_8 = v1.a == 1 || v1.a == 2 ? 1 : v1.a;
            v4.result = v0_8;
            v4.timeUsed = ((int) (System.currentTimeMillis() - v6));
            v4.description = v2;
            if (v1.a == 2) {
                v4.description = "[need_reboot]" + v4.description;
            }

            this.c.triedSolutions.triedList.add(v4);
            h.c(d.a, "[tryRootingBy]done,result:" + v1.a);
            return v1;
        }

        label_173:
        if (arg14) {
            return v1;
        }

        v4.id = arg12.id;
        v0_8 = v1.a == 1 || v1.a == 2 ? 1 : v1.a;
        v4.result = v0_8;
        v4.timeUsed = ((int) (System.currentTimeMillis() - v6));
        v4.description = v3_4;
        if (v1.a == 2) {
            v4.description = "[need_reboot]" + v4.description;
        }

        this.c.triedSolutions.triedList.add(v4);
        h.c(d.a, "[tryRootingBy]done,result:" + v1.a);
        throw v2_1;
        label_156:
        if (arg14) {
            return v1;
        }

        v4.id = arg12.id;
        v0_8 = v1.a == 1 || v1.a == 2 ? 1 : v1.a;
        v4.result = v0_8;
        v4.timeUsed = ((int) (System.currentTimeMillis() - v6));
        v4.description = v2;
        if (v1.a == 2) {
            v4.description = "[need_reboot]" + v4.description;
        }

        this.c.triedSolutions.triedList.add(v4);
        h.c(d.a, "[tryRootingBy]done,result:" + v1.a);
        return v1;
    }

    private static void a(int arg4) {
        Context v0 = d.b();
        if (v0 != null) {
            SharedPreferences$Editor v0_1 = v0.getSharedPreferences("rgpref", 0).edit();
            v0_1.putInt("reboot_tried", arg4);
            if (arg4 != -1) {
                v0_1.putLong("reboot_tried_at", System.currentTimeMillis());
            } else {
                v0_1.putLong("reboot_tried_at", -1);
            }

            v0_1.commit();
        }
    }

    public static d a() {
        return d.o;
    }

    //root结束后的操作
    private void a(com.shuame.rootgenius.sdk.c arg7, RootGenius.RootListener arg8) {
        int v0 = -1;
        h.b(d.a, "[onRootFinish]entry");
        if (arg7.a == 1 && (this.p.b) && !this.p.f().isEmpty()) {
            this.r.a(this.p.f(), true);
        }

        this.c.totalTimeUsed = ((int) (System.currentTimeMillis() - this.l));
        com.shuame.rootgenius.sdk.proto.e.a().a(this.c, this.p.g());
        d.a(v0);
        File v1 = new File(d.g + "stat");
        if (v1.exists()) {
            v1.delete();
        }

        if (arg8 != null) {
            arg8.onProgress(100);//进度100
            if (arg7.a != -6) {
                v0 = arg7.a;
            }

            arg8.onResult(v0);
            arg8.onProcess(arg7.b);
        }

        h.b(d.a, "[onRootFinish]finish");
    }

    static void a(d arg0, Context arg1) {
        arg0.c(arg1);
    }

    private static void a(boolean arg3) {
        if (arg3) {
            IntentFilter v0 = new IntentFilter();
            v0.addAction("android.intent.action.PACKAGE_ADDED");
            v0.addAction("android.intent.action.PACKAGE_REPLACED");
            v0.addDataScheme("package");
            d.b().registerReceiver(d.v, v0);
        } else {
            d.u.clear();
            d.b().unregisterReceiver(d.v);
        }
    }

    public final int a(RootListener listener) {
        Throwable v11_1;
        Exception v1_1;
        Exception v11;
        Data data;
        Object v0_5;
        ProtoData.QueryRootingResult v5;
        ProtoData.QueryRootingResult v0_4;
        com.shuame.rootgenius.sdk.c v0_3;//关于文件操作的东西
        Object v3 = null;
        int v4 = -1;
        int v2 = 0;
        if (this.t) {
            this.c.flag |= 8;
            this.t = false;
        } else {
            this.c.flag &= -9;
        }

        com.shuame.rootgenius.sdk.c cVar = new com.shuame.rootgenius.sdk.c(v4, 0);//v4 为-1
        h.c(d.a, "[startRoot]begining");
        this.c.triedSolutions.triedList.clear();
        this.l = System.currentTimeMillis();
        Context context = d.b();
        this.p.c();// CommUtils.delete(new File(this.f4030d + "Data/.rootgenius"));删除文件
        if (context == null) {
            this.a(cVar, listener);//onRootFinish的一些操作
            throw new Exception("context is null.should call initialize first.");
        }

        try {
            h.b(d.a, "[startRoot]verifying");
            if (!d.e(context)) {//验证
                h.b(d.a, "[startRoot]verify fail");
                v0_3 = cVar;
            } else {
                if (listener != null) {
                    try {
                        listener.onProgress(1);
                        label_59:
                        if ((ProtoBase.isSuccess(this.s.result)) && this.s.su != null) {//为true
                            this.g(this.s.su.md5);//解压NewSuperSU
                        }

                        if (listener != null) {
                            listener.onProcess(7);
                        }

                        if (ProtoBase.isSuccess(this.s.result)) {
                            v0_4 = this.s;
                            h.c(d.a, "[startRoot]use pre request solution");//使用预请求解决方案
                            v5 = v0_4;
                        } else {
                            h.c(d.a, "[startRoot]none pre request, request solution now...");//请求方案
                            v0_4 = new ProtoData.QueryRootingResult();
                            new b().a(this.b, v0_4);//下载方案，并且把数据放入v0_4中
                            h.c(d.a, "[startRoot]request solution finish qrRes.result:" + v0_4.result);
                            v5 = v0_4;
                        }

                        if (!ProtoBase.isSuccess(v5.result)) {//请求方案失败
                            h.d(d.a, "[startRoot]request solution fail");
                            this.b.phoneInfo.productId = "query-failed:" + String.valueOf(v5.result);
                            cVar.a = -11;
                            v0_3 = cVar;
                            this.a(v0_3, listener);//root结束一些操作
                            h.c(d.a, "[startRoot]done,result:" + v0_3.a);
                            return v0_3.a;//v0_3.a为-1
                        }

                        //this.b 机型等信息
                        this.b.phoneInfo.productId = !v5.productId.isEmpty() ? v5.productId : "query-empty";
                        h.c(d.a, "[startRoot]request solution success, product_id:" + this.b.phoneInfo.productId);
                        if (this.k) {//arg6.startsWith("R:")) 在scanfragment中调用如果  如果有"R:"这里为ture
                            h.b(d.a, "[startRoot]mRemoteTest is true");
                            v4 = 0;

                            while (ture) {
                                if (v4 < v5.solus.size()) {
                                    v0_5 = v5.solus.get(v4);
                                    if (((RootSolution) v0_5).id != this.i) {
                                        ++v4;
                                    }
                                } else {
                                    v0_5 = v3;
                                }
                            }
                        }

                        v5.solus.clear();
                        if (v0_5 != null) {
                            v5.solus.add(v0_5);
                        }


                        if ((ProtoBase.isSuccess(this.s.result)) && this.s.su != null) {
                            this.g(this.s.su.md5);
                        }

                        if (this.j) {//arg6.startsWith("L:")) 在scanfragment中调用如果  如果有"L:"这里为ture
                            h.b(d.a, "[startRoot]mLocalTest is true, use local id:" + this.i);
                            this.b.phoneInfo.productId = "local-test";
                            v5.solus.clear();
                            ArrayList v0_6 = v5.solus;
                            v4 = this.i;
                            RootSolution v7 = new RootSolution();
                            v7.id = v4;
                            v7.type = "lua";
                            v0_6.add(v7);
                        }

                        if (v5.solus.size() != 0) {
                            data = new JniHelper.Data();
                            data.cntx = d.b();
                            data.field = new HashMap();
                            //d.g getFilesDir().getAbsolutePath() + "/";
                            //d.h Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/"
                            data.field.put("callFunc", "main");
                            data.field.put("executePath", d.g + "Data/Bin/");
                            data.field.put("rootgeniusVer", Integer.toString(84));
                            data.field.put("androidSdkVer", Integer.toString(Build$VERSION.SDK_INT));
                            data.field.put("productId", v5.productId);
                            data.field.put("androidVer", this.b.phoneInfo.androidVersion);
                            data.field.put("buildDescription", this.b.phoneInfo.buildDescription);
                            data.field.put("coreVer", this.b.phoneInfo.kernel);
                            data.field.put("serial", this.b.phoneInfo.adb.serial);
                            data.field.put("macAddr", this.b.phoneId.mac);
                            data.field.put("workDir", d.g);
                            data.field.put("tempDir", d.h);
                            data.field.put("installScript", this.p.e());
                            data.field.put("instSuScript", CommUtils.readFrom(this.p.e()).replace("#!/system/bin/sh", ""));
                            data.field.put("tempRoot", "false");
                            data.field.put("IMEI", this.b.phoneId.phimei);
                            data.field.put("IMSI", this.b.phoneId.imsi);
                            data.field.put("rid", this.b.phoneId.rid);
                            data.field.put("productModel", this.b.phoneInfo.productModel);
                            data.field.put("productDevice", this.b.phoneInfo.productDevice);
                            data.field.put("roHardware", this.b.phoneInfo.phoneHardware);
                            data.field.put("neo", v5.neo);
                            data.field.put("phoneId", this.b.phoneInfo.phoneId);
                            data.field.put("versionName", RgsdkConfig.sChVersionName);
                            if (v5.rootEngine != null) {
                                data.field.put("rootEngineUrl", v5.rootEngine.url);
                                data.field.put("rootEngineMd5", v5.rootEngine.md5);
                            }

                            data.field.put("phoneId", this.b.phoneInfo.phoneId);
                            i.a = d.g + "Data/Sol/";
                            int v6 = d.l();//sp操作
                            d.a(-1);//sp操作
                        }

                        h.d(d.a, "[startRoot]query result not support");
                        cVar.a = -4;
                        v0_3 = cVar;
                        this.a(v0_3, listener);


                        if ((ProtoBase.isSuccess(this.s.result)) && this.s.su != null) {
                            this.g(this.s.su.md5);
                        }

                    } catch (Throwable v0_1) {
                    }
                }

                if ((ProtoBase.isSuccess(this.s.result)) && this.s.su != null) {
                    this.g(this.s.su.md5);
                }
            }

            this.a(v0_3, listener);
            h.c(d.a, "[startRoot]done,result:" + v0_3.a);
            return v0_3.a;
        } catch (Throwable v0_1) {
        }


        label_56:
        if (listener != null) {
            try {
                listener.onProgress(1);
                label_59:
                if ((ProtoBase.isSuccess(this.s.result)) && this.s.su != null) {
                    this.g(this.s.su.md5);
                }

                if (listener != null) {
                    listener.onProcess(7);
                }

                if (ProtoBase.isSuccess(this.s.result)) {
                    v0_4 = this.s;
                    h.c(d.a, "[startRoot]use pre request solution");
                    v5 = v0_4;
                } else {
                    h.c(d.a, "[startRoot]none pre request, request solution now...");
                    v0_4 = new QueryRootingResult();
                    new b().a(this.b, v0_4);
                    h.c(d.a, "[startRoot]request solution finish qrRes.result:" + v0_4.result);
                    v5 = v0_4;
                }

                if (!ProtoBase.isSuccess(v5.result)) {
                    h.d(d.a, "[startRoot]request solution fail");
                    this.b.phoneInfo.productId = "query-failed:" + String.valueOf(v5.result);
                    cVar.a = -11;
                    v0_3 = cVar;
                    h.c(d.a, "[startRoot]done,result:" + v0_3.a);
                    return v0_3.a;
                }

                this.b.phoneInfo.productId = !v5.productId.isEmpty() ? v5.productId : "query-empty";
                h.c(d.a, "[startRoot]request solution success, product_id:" + this.b.phoneInfo.productId);
                if (this.k) {//arg6.startsWith("R:")) 在scanfragment中调用如果  如果有"R:"这里为ture
                    h.b(d.a, "[startRoot]mRemoteTest is true");
                    v4 = 0;
                    while (true) {
                        label_108:
                        if (v4 < v5.solus.size()) {
                            v0_5 = v5.solus.get(v4);
                            if (((RootSolution) v0_5).id != this.i) {
                                ++v4;
                            }
                        } else {
                            v0_5 = v3;
                        }

                        label_116:
                        v5.solus.clear();
                        if (v0_5 != null) {
                            v5.solus.add(v0_5);
                        }

                        label_121:
                        if ((ProtoBase.isSuccess(this.s.result)) && this.s.su != null) {
                            this.g(this.s.su.md5);
                        }

                        if (this.j) {
                            h.b(d.a, "[startRoot]mLocalTest is true, use local id:" + this.i);
                            this.b.phoneInfo.productId = "local-test";
                            v5.solus.clear();
                            ArrayList v0_6 = v5.solus;
                            v4 = this.i;
                            RootSolution v7 = new RootSolution();
                            v7.id = v4;
                            v7.type = "lua";
                            v0_6.add(v7);
                        }

                        if (v5.solus.size() != 0) {
                            data = new Data();
                            data.cntx = d.b();
                            data.field = new HashMap();
                            data.field.put("callFunc", "main");
                            data.field.put("executePath", d.g + "Data/Bin/");
                            data.field.put("rootgeniusVer", Integer.toString(84));
                            data.field.put("androidSdkVer", Integer.toString(Build$VERSION.SDK_INT));
                            data.field.put("productId", v5.productId);
                            data.field.put("androidVer", this.b.phoneInfo.androidVersion);
                            data.field.put("buildDescription", this.b.phoneInfo.buildDescription);
                            data.field.put("coreVer", this.b.phoneInfo.kernel);
                            data.field.put("serial", this.b.phoneInfo.adb.serial);
                            data.field.put("macAddr", this.b.phoneId.mac);
                            data.field.put("workDir", d.g);
                            data.field.put("tempDir", d.h);
                            data.field.put("installScript", this.p.e());
                            data.field.put("instSuScript", CommUtils.readFrom(this.p.e()).replace("#!/system/bin/sh", ""));
                            data.field.put("tempRoot", "false");
                            data.field.put("IMEI", this.b.phoneId.phimei);
                            data.field.put("IMSI", this.b.phoneId.imsi);
                            data.field.put("rid", this.b.phoneId.rid);
                            data.field.put("productModel", this.b.phoneInfo.productModel);
                            data.field.put("productDevice", this.b.phoneInfo.productDevice);
                            data.field.put("roHardware", this.b.phoneInfo.phoneHardware);
                            data.field.put("neo", v5.neo);
                            data.field.put("phoneId", this.b.phoneInfo.phoneId);
                            data.field.put("versionName", RgsdkConfig.sChVersionName);
                            if (v5.rootEngine != null) {
                                data.field.put("rootEngineUrl", v5.rootEngine.url);
                                data.field.put("rootEngineMd5", v5.rootEngine.md5);
                            }

                            data.field.put("phoneId", this.b.phoneInfo.phoneId);
                            i.a = d.g + "Data/Sol/";
                            int v6 = d.l();
                            d.a(-1);
                        }

                        h.d(d.a, "[startRoot]query result not support");
                        cVar.a = -4;
                        v0_3 = cVar;
                        this.a(v0_3, listener);
                        h.c(d.a, "[startRoot]done,result:" + v0_3.a);
                        return v0_3.a;
                    }
                }

                if ((ProtoBase.isSuccess(this.s.result)) && this.s.su != null) {
                    this.g(this.s.su.md5);
                }

            } catch (Throwable v0_1) {
                goto label_439;
            } catch (Exception v0_2) {
                goto label_191;
            }
        }

        goto label_59;


        label_197:
        ++v4;
        goto label_108;
        label_458:
        v0_5 = v3;
        try {
            label_116:
            v5.solus.clear();
            if (v0_5 != null) {
                v5.solus.add(v0_5);
            }

            label_121:
            if ((ProtoBase.isSuccess(this.s.result)) && this.s.su != null) {
                this.g(this.s.su.md5);
            }

            if (this.j) {
                h.b(d.a, "[startRoot]mLocalTest is true, use local id:" + this.i);
                this.b.phoneInfo.productId = "local-test";
                v5.solus.clear();
                ArrayList v0_6 = v5.solus;
                v4 = this.i;
                RootSolution v7 = new RootSolution();
                v7.id = v4;
                v7.type = "lua";
                v0_6.add(v7);
            }

            if (v5.solus.size() != 0) {
                goto label_217;
            }

            h.d(d.a, "[startRoot]query result not support");
            cVar.a = -4;
            v0_3 = cVar;
            this.a(v0_3, listener);
            h.c(d.a, "[startRoot]done,result:" + v0_3.a);
            return v0_3.a;
        } catch (Throwable v0_1) {
            goto label_439;
        } catch (Exception v0_2) {
            goto label_191;
        }


        try {
            label_217:
            data = new Data();
            data.cntx = d.b();
            data.field = new HashMap();
            data.field.put("callFunc", "main");
            data.field.put("executePath", d.g + "Data/Bin/");
            data.field.put("rootgeniusVer", Integer.toString(84));
            data.field.put("androidSdkVer", Integer.toString(Build$VERSION.SDK_INT));
            data.field.put("productId", v5.productId);
            data.field.put("androidVer", this.b.phoneInfo.androidVersion);
            data.field.put("buildDescription", this.b.phoneInfo.buildDescription);
            data.field.put("coreVer", this.b.phoneInfo.kernel);
            data.field.put("serial", this.b.phoneInfo.adb.serial);
            data.field.put("macAddr", this.b.phoneId.mac);
            data.field.put("workDir", d.g);
            data.field.put("tempDir", d.h);
            data.field.put("installScript", this.p.e());
            data.field.put("instSuScript", CommUtils.readFrom(this.p.e()).replace("#!/system/bin/sh", ""));
            data.field.put("tempRoot", "false");
            data.field.put("IMEI", this.b.phoneId.phimei);
            data.field.put("IMSI", this.b.phoneId.imsi);
            data.field.put("rid", this.b.phoneId.rid);
            data.field.put("productModel", this.b.phoneInfo.productModel);
            data.field.put("productDevice", this.b.phoneInfo.productDevice);
            data.field.put("roHardware", this.b.phoneInfo.phoneHardware);
            data.field.put("neo", v5.neo);
            data.field.put("phoneId", this.b.phoneInfo.phoneId);
            data.field.put("versionName", RgsdkConfig.sChVersionName);
            if (v5.rootEngine != null) {
                data.field.put("rootEngineUrl", v5.rootEngine.url);
                data.field.put("rootEngineMd5", v5.rootEngine.md5);
            }

            data.field.put("phoneId", this.b.phoneInfo.phoneId);
            i.a = d.g + "Data/Sol/";
            int v6 = d.l();
            d.a(-1);


            while (true) {
                if (v2 >= v5.solus.size()) {
                    v0_3 = cVar;
                    this.a(v0_3, listener);
                    label_46:
                    h.c(d.a, "[startRoot]done,result:" + v0_3.a);
                    return v0_3.a;

                }
                int v0_7 = (v2 + 1) * 75 / (v5.solus.size() + 1) + 15;
                if (listener != null) {
                    listener.onProgress(v0_7);
                }

                v0_5 = v5.solus.get(v2);
                if (((ProtoData.RootSolution) v0_5).id == 1000) {
                    v3 = v0_5;
                }

                if (((ProtoData.RootSolution) v0_5).id != v6) {
                    v0_3 = this.a(((ProtoData.RootSolution) v0_5), data, false);
                } else if (v2 + 1 < v5.solus.size()) {
                    break;
                } else {
                    v0_3 = this.a(((ProtoData.RootSolution) v0_5), data, false);
                }

                if (v0_3.a != 1 && v0_3.a != 2) {
                    ++v2;
                    continue;
                }

                if (v3 == null) {
                    goto label_45;
                }

                if ((this.e.val & 1) != 0) {
                    goto label_45;
                }

                data.field.put("callFunc", "install_rgs");
                this.a(((RootSolution) v3), data, true);
                goto label_45;
            }


        } catch (Exception v0_2) {
            goto label_191;
        }

        try {
            while (true) {
                label_388:
                if (v2 >= v5.solus.size()) {
                    goto label_456;
                }

                int v0_7 = (v2 + 1) * 75 / (v5.solus.size() + 1) + 15;
                if (listener != null) {
                    listener.onProgress(v0_7);
                }

                v0_5 = v5.solus.get(v2);
                if (((RootSolution) v0_5).id == 1000) {
                    v3 = v0_5;
                }

                if (((RootSolution) v0_5).id != v6) {
                    goto label_412;
                } else if (v2 + 1 < v5.solus.size()) {
                    break;
                } else {
                    goto label_412;
                }
            }
        } catch (Exception v0_2) {
            goto label_452;
        }

        v0_3 = cVar;
        goto label_434;
        try {
            label_412:
            v0_3 = this.a(((RootSolution) v0_5), data, false);
        } catch (Exception v0_2) {
            label_452:
            v11 = v0_2;
            v0_3 = cVar;
            v1_1 = v11;
            goto label_194;
        }

        try {
            if (v0_3.a != 1 && v0_3.a != 2) {
                goto label_434;
            }

            goto label_419;
        } catch (Throwable v1_2) {
            goto label_442;
        } catch (Exception v1_1) {
            goto label_432;
        }

        label_434:
        ++v2;
        cVar = v0_3;
        goto label_388;
        try {
            label_419:
            if (v3 == null) {
                goto label_45;
            }

            if ((this.e.val & 1) != 0) {
                goto label_45;
            }

            data.field.put("callFunc", "install_rgs");
            this.a(((RootSolution) v3), data, true);
            goto label_45;
        } catch (Throwable v1_2) {
            label_442:
            v11_1 = v1_2;
            cVar = v0_3;
            v0_1 = v11_1;
            goto label_439;
        } catch (Exception v1_1) {
            label_432:
            goto label_194;
        }

        label_456:
        v0_3 = cVar;
        goto label_45;
        try {
            label_200:
            h.d(d.a, "[startRoot]request solution fail");
            this.b.phoneInfo.productId = "query-failed:" + String.valueOf(v5.result);
            cVar.a = -11;
            v0_3 = cVar;
            goto label_45;
        } catch (Exception v0_2) {
            label_191:
            v11 = v0_2;
            v0_3 = cVar;
            v1_1 = v11;
        }

        try {
            label_194:
            v1_1.printStackTrace();
        } catch (Throwable v1_2) {
            v11_1 = v1_2;
            cVar = v0_3;
            v0_1 = v11_1;
            goto label_439;
        }

        this.a(v0_3, listener);
        goto label_46;
        label_439:
        this.a(cVar, listener);
        throw v0_1;
        label_45:
        this.a(v0_3, listener);
        label_46:
        h.c(d.a, "[startRoot]done,result:" + v0_3.a);
        return v0_3.a;
    }

    public final void a(Context arg5) {//目前还不知道哪里执行的，可以打log
        if (d.b() == null) {
            d.f = new SoftReference(arg5);
            ProtoBase.setChannel(arg5.getPackageName());
            d.g = d.b().getFilesDir().getAbsolutePath() + "/";
            d.h = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/";
            new File(d.h).mkdirs();
            new File(d.g).mkdirs();
            new File(d.g + "Data/").mkdirs();
            new File(d.g + "Data/Bin").mkdirs();
            AssetManager v0 = d.b().getAssets();
            try {
                InputStream v0_2 = v0.open("rgsdk");
                if (v0_2 == null) {
                    goto label_63;
                }

                CommUtils.unzip(v0_2, d.g);//解压rgsdk到getFilesDir()
                v0_2.close();
            } catch (IOException v0_1) {
                v0_1.printStackTrace();
            }

            label_63:
            this.n = new c(d.g);
            this.n.h();//解压KingUser.zip，来自rgsdk.zip
            this.p = this.n;
            this.r = new g(d.g);
            File v0_3 = new File(d.g + "Data/Sol/1000");
            if (!v0_3.exists()) {//如果不存在 f4040g + "Data/Bin/rgs 命名成"Data/Sol/1000"
                new File(d.g + "Data/Bin/rgs").renameTo(v0_3);
            }

            if (this.b.inited) {
                goto label_117;
            }

            this.b = CommUtils.parseRootingDev(d.b());//获取手机参数
            this.c.phoneId = this.b.phoneId;
            this.c.phoneInfo = this.b.phoneInfo;
            this.d.phoneId = this.b.phoneId;
            this.b.inited = true;
        }

        label_117:
        h.b(d.a, "[perpare]workDir:" + d.g + ",tempDir:" + d.h);
        this.d(arg5);//stat的文件操作
        if (d.e(arg5)) {//verify验证
            com.shuame.rootgenius.sdk.proto.c.a().a(this.e);//拼接一个默认的xml请求服务器,并且把结果放入this.e中
        }
    }

    //设置权限
    public final void a(String arg6) {
        h.c(d.a, "[setTestMode]entry");
        if (arg6 != null) {
            if (arg6.startsWith("L:")) {
                this.j = true;
            } else if (arg6.startsWith("R:")) {
                this.k = true;
            } else {
                return;
            }

            h.c(d.a, "[setTestMode]mLocalTest " + this.j);
            String v0 = arg6.substring(2);
            if (v0 == null) {
                return;
            }

            if (v0.isEmpty()) {
                return;
            }

            if (!d.e(d.b())) {
                return;
            }

            h.c(d.a, "[setTestMode]JniRoot ");
            int v0_1 = Integer.parseInt(v0);
            h.c(d.a, "[setTestMode]JniRoot soluId:" + v0_1);
            if (v0_1 > 0) {
                this.i = v0_1;
                v0 = "mkdir " + d.g + "Data/Sol/\nchmod 777 " + d.g + "Data/Sol/";
            } else {
                this.i = 0;
                this.j = false;
                this.k = false;
                v0 = "mkdir " + d.g + "Data/Sol/\nchmod 755 " + d.g + "Data/Sol/";
            }

            CommUtils.execCmd(v0);
        }
    }

    //升级root组件
    public final void a(String arg11, RootListener arg12) {
        boolean v0_5;
        com.shuame.rootgenius.sdk.a.b v1 = new com.shuame.rootgenius.sdk.a.b(d.g);
        com.shuame.rootgenius.sdk.c v2 = new com.shuame.rootgenius.sdk.c(-1, 0);
        if (!v1.a(arg11, null)) {
            v2.a = -5;
            this.a(v2, arg12);
            return;
        }

        this.c.triedSolutions.triedList.clear();
        this.l = System.currentTimeMillis();
        Context v0 = d.b();
        if (v0 == null) {
            this.a(v2, arg12);
            throw new Exception("context is null.should call initialize first.");
        }

        try {
            if (d.e(v0)) {
                if (arg12 != null) {
                    arg12.onProgress(1);
                }

                long v4 = System.currentTimeMillis();
                String v3 = v1.e();
                StringBuilder v7 = new StringBuilder("chmod 755 ").append(v3).append("\nsu -c \"");
                String v0_3 = "";
                if (!v1.f().isEmpty()) {
                    v0_3 = this.r.a(v1.f(), false);
                }

                if (!v0_3.endsWith("\n")) {
                    v0_3 = v0_3 + "\n";
                }

                v0_3 = CommUtils.execCmd(false, v7.append("bb=" + d.g + "Data/Bin/busybox \nchmod 755 $bb\n" + v0_3).append(v3).append("\"").toString());
                h.c(d.a, "[updateSU]descrip:" + v0_3);
                Tried v1_1 = new Tried();
                v1_1.id = 1002;
                v1_1.result = 1;
                v1_1.timeUsed = ((int) (System.currentTimeMillis() - v4));
                v1_1.description = v0_3;
                this.c.triedSolutions.triedList.add(v1_1);
                if (!a.b()) {
                    goto label_110;
                }

                v2.a = 1;
            }

            goto label_99;
        } catch (Exception v0_1) {
            goto label_114;
        } catch (Throwable v0_2) {
            goto label_127;
        }

        label_110:
        int v0_4 = 2;
        try {
            v2.a = v0_4;
        } catch (Throwable v0_2) {
            label_127:
            boolean v1_2 = this.p.b;
            this.p.b = false;
            this.a(v2, arg12);
            this.p.b = v1_2;
            throw v0_2;
        } catch (Exception v0_1) {
            try {
                label_114:
                v0_1.printStackTrace();
                v2.a = -1;
            } catch (Throwable v0_2) {
                goto label_127;
            }

            v0_5 = this.p.b;
            this.p.b = false;
            this.a(v2, arg12);
            this.p.b = v0_5;
            goto label_106;
        }

        label_99:
        v0_5 = this.p.b;
        this.p.b = false;
        this.a(v2, arg12);
        this.p.b = v0_5;
        label_106:
        h.b(d.a, "[updateSU]finish");
    }

    public final void a(String arg2, String arg3, String arg4) {
        this.b.phoneId.phimei = arg2;
        this.b.phoneId.imsi = arg3;
        this.b.phoneId.qimei = arg4;
    }

    public final void a(String[] arg2) {
        this.r.a(arg2);
    }

    public static Context b() {
        Object v0;
        if (d.f != null) {
            v0 = d.f.get();
        } else {
            Context v0_1 = null;
        }

        return ((Context) v0);
    }

    //install什么的
    public static int b(String arg8) {
        int v3_2;
        int v0;
        int v2 = -1;
        PackageInfo v3 = d.b().getPackageManager().getPackageArchiveInfo(arg8, 0);
        d.a(true);
        if (v3 != null) {
            v0 = 20000;
            String v4 = v3.applicationInfo.packageName;
            if (d.f(v4) < v3.versionCode) {
                Intent v3_1 = new Intent("android.intent.action.VIEW");
                v3_1.setDataAndType(Uri.fromFile(new File(arg8)), "application/vnd.android.package-archive");
                v3_1.setFlags(268435456);
                d.b().startActivity(v3_1);
                while (true) {
                    long v6 = 3000;
                    try {
                        Thread.sleep(v6);
                        v3_2 = v0 - 3000;
                        if (v4 != null && d.f(v4) > 0 && (d.u.containsKey(v4))) {
                            if (!d.u.get(v4).booleanValue()) {
                                goto label_46;
                            }

                            goto label_39;
                        }

                        goto label_46;
                    } catch (InterruptedException v0_1) {
                        v0_1.printStackTrace();
                        return v2;
                    }

                    label_39:
                    v0 = 0;
                    break;
                    label_46:
                    if (v3_2 <= 0) {
                        v0 = v2;
                        break;
                    }

                    v0 = v3_2;
                }
            } else {
                d.a(false);
                return 0;
            }
        } else {
            v0 = v2;
        }

        d.a(false);
        return v0;
    }

    public final void b(Context arg1) {
        this.d(arg1);
    }

    private void c(Context arg10) {
        int v1_2;
        Object v1_1;
        boolean v7;
        int v6;
        Object v0_2;
        File v5;
        int v8 = -1;
        __monitor_enter(this);
        try {
            v5 = new File(arg10.getFilesDir().getAbsolutePath() + "/stat");
            h.c(d.a, "sendStatReport,file size:" + v5.length());
            if (!v5.exists()) {
                goto label_103;
            }

            ObjectInputStream v1 = new ObjectInputStream(new FileInputStream(v5));
            v0_2 = v1.readObject();
            v1.close();
            if (v0_2 == null) {
                h.d(d.a, "sendStatReport,read object null");
                goto label_34;
            }

            v6 = d.l();
            if (v6 != v8) {
                v7 = a.b();
                Iterator v4 = ((RootResult) v0_2).triedSolutions.triedList.iterator();
                do {
                    if (v4.hasNext()) {
                        v1_1 = v4.next();
                        if (((Tried) v1_1).id != v6) {
                            continue;
                        }

                        break;
                    } else {
                        goto label_107;
                    }
                }
                while (true);

                int data = v7 ? 1 : 0;
                ((Tried) v1_1).result = data;
                v1_2 = 1;
                goto label_51;
            }

            goto label_63;
        } catch (Throwable v0) {
            goto label_99;
        } catch (Exception v0_1) {
            goto label_96;
        }

        label_107:
        v1_2 = 0;
        try {
            label_51:
            if (v1_2 == 0) {
                Tried v4_2 = new Tried();
                v4_2.id = v6;
                v1_2 = v7 ? 1 : 0;
                v4_2.result = v1_2;
                v4_2.description = "[rebooted-checking-root]";
                ((RootResult) v0_2).triedSolutions.triedList.add(v4_2);
            }

            label_63:
            if (CommUtils.checkActiveNetworkConnected(arg10, 30000)) {
                for (v1_2 = 2; v1_2 > 0; --v1_2) {
                    if (ProtoBase.isSuccess(com.shuame.rootgenius.sdk.proto.e.a().b(((RootResult) v0_2), this.p.g()))) {
                        break;
                    }
                }

                v5.delete();
                d.a(-1);
            }

            h.c(d.a, "sendStatReport,id " + v6 + ",result:" + this.m);
            goto label_34;
            label_103:
            h.c(d.a, "sendStatReport stat file not exists!");
        } catch (Throwable v0) {
        } catch (Exception v0_1) {
            try {
                label_96:
                v0_1.printStackTrace();
            } catch (Throwable v0) {
                try {
                    label_99:
                    throw v0;
                } catch (Throwable v0) {
                    __monitor_exit(this);
                    throw v0;
                }
            }
        }

        label_34:
        __monitor_exit(this);
    }

    public static int c(String arg3) {
        d.b().startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + arg3)));
        return 0;
    }

    public final RootingDev c() {
        return this.b;
    }

    private void d(Context arg3) {
        new Thread(new f(this, arg3)).start();
    }

    public final DeviceSolution d() {
        DeviceSolution v0_3;
        b v0 = new b();
        h.c(d.a, "[preQueryRoot]start");
        v0.a(this.b, this.s);//网络请求下载，并且把下载的参数放入this.s
        h.c(d.a, "[preQueryRoot]product_id:" + this.s.productId);
        if (ProtoBase.isSuccess(this.s.result)) {
            ProtoData.DeviceSolution v2 = new DeviceSolution();
            v2.productId = this.s.productId;
            v2.productName = this.s.productName;
            boolean v0_1 = this.s.solus.size() > 0 ? true : false;
            v2.support = v0_1;
            if (this.s.su == null || this.s.su.md5.compareToIgnoreCase(this.n.i()) == 0) {
                h.c(d.a, "[preQueryRoot] no need update su ");
            } else {
                v2.su = this.s.su;
                StringBuilder v3 = new StringBuilder().append(d.g).append("Data/download/");
                String v0_2 = CommUtils.getFileNameFromUrl(this.s.su.url);//切割url获取文件名
                int v4 = v0_2.indexOf(45);
                int v5 = v0_2.lastIndexOf(46);
                if (v5 >= 0 && v4 >= 0) {
                    v0_2 = v0_2.substring(0, v4) + v0_2.substring(v5);
                }

                v2.suPath = v3.append(v0_2).toString();
                this.q = v2.suPath;
                h.c(d.a, "[preQueryRoot] need update su url:" + v2.su.url + " md5:" + v2.su.md5 + " size:" + v2.su.size + " path:" + v2.suPath);
            }

            v0_3 = v2;
        } else {
            v0_3 = null;
        }

        return v0_3;
    }

    //执行su的
    public final String d(String arg2) {
        String v0 = a.b() ? CommUtils.execCmd(true, arg2) : "permission denied";
        return v0;
    }

    public static int e() {
        return 0;
    }

    public static void e(String arg2) {
        CommUtils.execCmd(arg2 + " ln -s " + arg2 + " " + d.g + "Data/Bin/busybox");
    }

    private static boolean e(Context arg4) {
        boolean v0 = false;
        if (arg4 != null) {
            v0 = JniHelper.verify(arg4);
            h.c(d.a, "[verify]result..." + v0);
        }

        if (!v0) {
            h.c(d.a, "[verify]fail...");
        }

        return v0;
    }

    private static int f(String arg3) {
        int v0 = 0;
        PackageManager v1 = d.b().getPackageManager();
        try {
            PackageInfo v1_2 = v1.getPackageInfo(arg3, 0);
            if (arg3 == null) {
                return v0;
            }

            if (v1_2 == null) {
                return v0;
            }

            v0 = v1_2.versionCode;
        } catch (NameNotFoundException v1_1) {
        }

        return v0;
    }

    //removeRoot一些东西
    public final int f() {
        int v0 = 1;
        int v1 = -1;
        Context v2 = d.b();
        if (v2 == null) {
            throw new Exception("context is null.should call initialize first.");
        }

        if (d.e(v2)) {
            this.d.description = this.r.a();
            if (!this.g()) {
                this.d.result = 1;
            } else {
                this.d.result = 0;
                v0 = v1;
            }

            com.shuame.rootgenius.sdk.proto.f.a().a(this.d);
            v1 = v0;
        }

        return v1;
    }

    public final boolean g() {
        this.m = a.b();
        return this.m;
    }

    /**
     *
     * @param arg4 MD5
     * @return
     */
    private boolean g(String arg4) {
        boolean v0_1;
        if (this.q == null || this.p != this.n) {
            label_23:
            v0_1 = false;
        } else {
            h.c(d.a, "[startRoot] try to unzip superuser from download");
            com.shuame.rootgenius.sdk.a.b v0 = new com.shuame.rootgenius.sdk.a.b(d.g);
            //this.q  getFileDir()+Data/download+super的文件名
            if (v0.a(this.q, arg4)) {//解压NewSuperSU
                h.c(d.a, "[startRoot] unzip superuser success");
                this.p = ((a) v0);
                v0_1 = true;
            } else {
                h.c(d.a, "[startRoot] unzip superuser fail");
                goto label_23;
            }
        }

        return v0_1;
    }

    public final String h() {
        String v0 = this.n != null ? this.n.i() : "";
        return v0;
    }

    public final void i() {
        this.t = true;
    }

    static String j() {
        return d.a;
    }

    static HashMap k() {
        return d.u;
    }

    private static int l() {
        int v0 = -1;
        Context v1 = d.b();
        if (v1 != null) {
            SharedPreferences v1_1 = v1.getSharedPreferences("rgpref", 0);
            if (System.currentTimeMillis() - v1_1.getLong("reboot_tried_at", -1) <= 600000) {
                v0 = v1_1.getInt("reboot_tried", v0);
            }
        }

        return v0;
    }
}

