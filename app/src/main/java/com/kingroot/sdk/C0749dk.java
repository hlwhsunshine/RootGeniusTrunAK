package com.kingroot.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0885e;
import com.kingroot.sdk.util.C0886f;
import com.kingroot.sdk.util.C0897q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import krsdk.C1774c;
import krsdk.RootConfig;
import org.json.JSONObject;

/* renamed from: com.kingroot.sdk.dk */
public class C0749dk {
    /* renamed from: fF */
    public static boolean f1835fF = false;
    /* renamed from: fG */
    private static Object f1836fG = new Object();
    /* renamed from: fH */
    private static C0748a f1837fH;

    /* renamed from: com.kingroot.sdk.dk$a */
    public static class C0748a extends Thread {
        /* renamed from: bK */
        String f1832bK;
        /* renamed from: fI */
        Context f1833fI;
        /* renamed from: fJ */
        WeakReference<C0720dh> f1834fJ;
        Handler handler;

        public C0748a(Context context, Handler handler, String str, WeakReference<C0720dh> weakReference) {
            this.f1833fI = context;
            this.handler = handler;
            this.f1832bK = str;
            this.f1834fJ = weakReference;
        }

        public void run() {
            long j = C0741dg.m1804aL().f1806em.solutionTimeout / 2000;
            long j2 = 0;
            while (j2 < j) {
                C0633at.m1464h("打点：" + j2);
                try {
                    Thread.sleep(2000);
                    C0726cw.m1752r(this.f1833fI);
                    j2++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    C0633at.m1464h("被打断");
                    C0726cw.m1752r(this.f1833fI);
                    return;
                }
            }
            if (this.f1834fJ != null) {
                C0720dh c0720dh = (C0720dh) this.f1834fJ.get();
                if (c0720dh != null) {
                    C0633at.m1465i("Solution Timeout");
                    C0760dt.m1855E(this.f1833fI).mo5759a("SOLUTION_TIMEOUT", 1, "7052", "", this.handler, this.f1832bK);
                    c0720dh.destroy();
                    return;
                }
            }
            C0633at.m1465i("Solution Timeout, no solution");
        }
    }

    /* renamed from: C */
    public static Object[] m1820C(Context context) {
        Object[] objArr = null;
        synchronized (f1836fG) {
            if (f1835fF) {
            } else {
                String p = C0739de.m1802p(context, "executing_sid_time");
                if (p != null) {
                    int indexOf = p.indexOf("\t");
                    if (indexOf > 0) {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = p.substring(0, indexOf);
                        try {
                            objArr2[1] = Long.valueOf(Long.parseLong(p.substring(indexOf + 1)));
                            objArr = objArr2;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                C0739de.m1801o(context, "executing_sid_time");
            }
        }
        return objArr;
    }

    /* renamed from: P */
    public static void m1821P(String str) {
        C0883c.deleteFile(C0741dg.m1804aL().f1806em.mo8167a("jars", str));
        C0883c.deleteFile(C0741dg.m1804aL().f1806em.mo8167a("xmls", str));
    }

    /* renamed from: a */
    public static C0720dh m1822a(Context context, Handler handler, RootConfig rootConfig, C0626ap c0626ap) {
        C0886f.clean();
        switch (c0626ap.f1561bP) {
            case 1:
                return new C0729cy(context, handler, rootConfig, c0626ap);
            case 3:
            case 4:
            case 6:
                return new C0724cv(context, handler, rootConfig, c0626ap);
            case 5:
                return new C0736db(context, handler, rootConfig, c0626ap);
            default:
                C0886f.set(7003, "interface_type=" + c0626ap.f1561bP);
                return null;
        }
    }

    /* renamed from: a */
    public static C1774c m1823a(Context context, RootConfig rootConfig, int i) {
        String str;
        C1774c c1774c;
        int i2;
        C0886f.clean();
        File file = new File(rootConfig.mo8167a("xmls"));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(rootConfig.mo8167a("jars"));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String p = C0739de.m1802p(context, "next_execute_solution_id");
        if ((i & 1) == 1) {
            str = null;
        } else if ((i & 2) == 2 && p == null) {
            c1774c = new C1774c();
            c1774c.f5199kA = 0;
            C0749dk.m1836b(rootConfig, c1774c);
            return c1774c;
        } else {
            str = p;
        }
        if ((i & 4) == 4) {
            c1774c = C0749dk.m1824a(context, rootConfig, file, file2);
            if (c1774c != null) {
                return c1774c;
            }
        }
        c1774c = str == null ? C0749dk.m1835b(context, rootConfig, file, file2) : C0749dk.m1825a(context, rootConfig, file, file2, str);
        C0626ap[] c0626apArr = c1774c.f5200kB;
        if (file2.isDirectory()) {
            File[] listFiles = file2.listFiles();
            if (listFiles != null) {
                for (File name : listFiles) {
                    String name2 = name.getName();
                    if (!name2.equals("131")) {
                        if (c0626apArr != null && c0626apArr.length > 0) {
                            for (C0626ap c0626ap : c0626apArr) {
                                if (c0626ap.f1556bK.equals(name2)) {
                                    i2 = 1;
                                    break;
                                }
                            }
                        }
                        i2 = 0;
                        if (i2 == 0) {
                            C0749dk.m1821P(name2);
                        }
                    }
                }
            }
        }
        Object p2 = C0739de.m1802p(context, "solution_success_id");
        if (!TextUtils.isEmpty(p2)) {
            File file3 = new File(file, p2);
            if (file3.exists()) {
                CharSequence Y = C0883c.m2389Y(file3.getAbsolutePath());
                if (!TextUtils.isEmpty(Y)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Y);
                    try {
                        C0626ap[] e = C0623am.m1422e(arrayList);
                        if (e != null && e.length > 0) {
                            for (C0626ap c0626ap2 : e) {
                                c0626ap2.f1563bR = file2.getAbsolutePath() + File.separator + c0626ap2.f1556bK;
                            }
                            c0626apArr = C0749dk.m1834a(e, c0626apArr);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (c0626apArr == null) {
            c0626apArr = new C0626ap[0];
        }
        c1774c.f5200kB = c0626apArr;
        return c1774c;
    }

    /* renamed from: a */
    private static C1774c m1824a(Context context, RootConfig rootConfig, File file, File file2) {
        Object p = C0739de.m1802p(context, "solution_success_id");
        if (!TextUtils.isEmpty(p)) {
            File file3 = new File(file, p);
            if (file3.exists()) {
                CharSequence Y = C0883c.m2389Y(file3.getAbsolutePath());
                if (!TextUtils.isEmpty(Y)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Y);
                    try {
                        C0626ap[] e = C0623am.m1422e(arrayList);
                        if (e != null && e.length > 0) {
                            for (C0626ap c0626ap : e) {
                                c0626ap.f1563bR = file2.getAbsolutePath() + File.separator + c0626ap.f1556bK;
                            }
                            C1774c c1774c = new C1774c();
                            c1774c.f5200kB = e;
                            C0749dk.m1836b(rootConfig, c1774c);
                            C0633at.m1464h("有成功方案，只取成功方案");
                            return c1774c;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C1774c m1825a(Context context, RootConfig rootConfig, File file, File file2, String str) {
        C1774c c1774c = new C1774c();
        C0633at.m1464h("云端拉取方案失败/手机重启");
        Object p = C0739de.m1802p(context, "solution_id_list");
        if (!TextUtils.isEmpty(p)) {
            String[] split = TextUtils.split(p, ",");
            ArrayList arrayList = new ArrayList();
            if (split != null && split.length > 0) {
                p = null;
                for (String str2 : split) {
                    if (str != null && r0 == null) {
                        if (str2.equals(str)) {
                            p = 1;
                        }
                        if (p == null) {
                        }
                    }
                    File file3 = new File(file, str2);
                    if (file3.exists()) {
                        CharSequence Y = C0883c.m2389Y(file3.getAbsolutePath());
                        if (!TextUtils.isEmpty(Y)) {
                            arrayList.add(Y);
                        }
                    }
                }
            }
            try {
                C0626ap[] e = C0623am.m1422e(arrayList);
                if (e != null) {
                    for (C0626ap c0626ap : e) {
                        c0626ap.f1563bR = file2.getAbsolutePath() + File.separator + c0626ap.f1556bK;
                    }
                    c1774c.f5200kB = e;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        C0749dk.m1836b(rootConfig, c1774c);
        return c1774c;
    }

    /* renamed from: a */
    public static void m1826a(Context context, Handler handler, String str, WeakReference<C0720dh> weakReference, boolean z) {
        synchronized (f1836fG) {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            C0633at.m1465i("bootTime = " + currentTimeMillis);
            if (z) {
                C0739de.m1795a(context, "executing_sid_time", str + "\t" + currentTimeMillis);
            }
            f1835fF = true;
        }
        if (f1837fH != null) {
            f1837fH.interrupt();
            f1837fH = null;
        }
        C0748a c0748a = new C0748a(context, handler, str, weakReference);
        f1837fH = c0748a;
        c0748a.start();
    }

    /* renamed from: a */
    public static void m1827a(Context context, boolean z, String str) {
        synchronized (f1836fG) {
            if (z) {
                C0739de.m1801o(context, "executing_sid_time");
            }
            f1835fF = false;
        }
        if (f1837fH != null) {
            f1837fH.interrupt();
            f1837fH = null;
        }
        if (z) {
            C0739de.m1796a(context, "runned_sids", str, ",");
            C0739de.m1796a(context, "apptime_runned_sids", str, ",");
        }
    }

    /* renamed from: a */
    private static void m1828a(RootConfig rootConfig, C1774c c1774c) {
        File file = new File(rootConfig.mo8167a("yis_cfg.txt"));
        file.delete();
        if (c1774c == null || c1774c.f5197hh == null || c1774c.f5198hi == null) {
            C0633at.m1465i("后台数据不完整，不存储YIS！");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("canRoot", c1774c.f5197hh.f1936hI);
            jSONObject2.put("useTime", c1774c.f5197hh.f1937hJ);
            jSONObject2.put("succUsers", c1774c.f5197hh.f1938hK);
            jSONObject2.put("succRate", c1774c.f5197hh.f1939hL);
            jSONObject2.put("subitUsers", c1774c.f5197hh.f1940hM);
            jSONObject3.put("canRoot", c1774c.f5198hi.f1936hI);
            jSONObject3.put("useTime", c1774c.f5198hi.f1937hJ);
            jSONObject3.put("succUsers", c1774c.f5198hi.f1938hK);
            jSONObject3.put("succRate", c1774c.f5198hi.f1939hL);
            jSONObject3.put("subitUsers", c1774c.f5198hi.f1940hM);
            jSONObject.put("pcRootInfo", jSONObject2);
            jSONObject.put("mobileRootInfo", jSONObject3);
            C0633at.m1464h("saveRootExtInfo.json = " + jSONObject.toString());
            C0885e.m2421a(file, r0);
        } catch (Exception e) {
            e.printStackTrace();
            file.delete();
        }
    }

    /* renamed from: a */
    public static boolean m1829a(Context context, C0626ap c0626ap) {
        C0886f.clean();
        if (C0751dm.m1842aS()) {
            return C0751dm.m1843b(context, c0626ap);
        }
        File file = new File(c0626ap.f1563bR);
        if (file.exists() && file.isFile() && C0749dk.m1832a(c0626ap, 0)) {
            C0633at.m1464h("本地已存在该方案文件，不用下载");
            return true;
        }
        try {
            boolean b = C0769dy.m1924b(context, c0626ap);
            if (b) {
                return b;
            }
            C0886f.set(7005, "download jar fail");
            return b;
        } catch (Throwable th) {
            C0886f.set(7005, "download jar exception", th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1830a(Context context, C0626ap c0626ap, RootConfig rootConfig) {
        C0886f.clean();
        if (!C0749dk.m1831a(c0626ap)) {
            C0886f.set(7003, "interface_type=" + c0626ap.f1561bP);
            return false;
        } else if (rootConfig.markCrashSolution && C0739de.m1799c(context, "solution_crash_" + c0626ap.f1556bK) == 1) {
            C0886f.set(7004, "sid=" + c0626ap.f1556bK);
            return false;
        } else {
            int c = C0739de.m1799c(context, "solution_fail_count_" + c0626ap.f1556bK);
            if (c < rootConfig.allowFailTimes) {
                return true;
            }
            C0886f.set(7059, "sid = " + c0626ap.f1556bK + ", failcount=" + c);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1831a(C0626ap c0626ap) {
        return C0722cu.m1743a(c0626ap.f1561bP, 0, 1, 2, 3, 4, 5, 6);
    }

    /* renamed from: a */
    public static boolean m1832a(C0626ap c0626ap, int i) {
        Throwable e;
        C0886f.clean();
        if (C0751dm.m1842aS()) {
            return true;
        }
        File file = new File(c0626ap.f1563bR);
        if (!file.exists()) {
            C0886f.set(7006, file.getAbsolutePath() + " not exist");
            return false;
        } else if (file.length() != c0626ap.size) {
            C0886f.set(7006, file.getAbsolutePath() + " size not format " + file.length() + "/" + c0626ap.size);
            return false;
        } else {
            Closeable fileInputStream;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    }
                    String c = C0897q.m2465c(instance.digest());
                    if (c.compareToIgnoreCase(c0626ap.f1554O) != 0) {
                        C0886f.set(7006, file.getAbsolutePath() + " md5 not format " + c + "/" + c0626ap.f1554O);
                        C0885e.m2419a(fileInputStream);
                        return false;
                    }
                    C0885e.m2419a(fileInputStream);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        C0886f.set(7006, file.getAbsolutePath() + " check throw exception", e);
                        C0885e.m2419a(fileInputStream);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        C0885e.m2419a(fileInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                e.printStackTrace();
                C0886f.set(7006, file.getAbsolutePath() + " check throw exception", e);
                C0885e.m2419a(fileInputStream);
                return false;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                C0885e.m2419a(fileInputStream);
                throw e;
            }
        }
    }

    /* renamed from: a */
    public static boolean m1833a(C0626ap c0626ap, String str) {
        C0886f.clean();
        if (C0722cu.m1743a(c0626ap.f1561bP, 0, 1, 3, 4, 6)) {
            if (!C0883c.m2396a(new File(c0626ap.f1563bR), str, "777")) {
                return false;
            }
            if (c0626ap.f1561bP == 1) {
                File file = new File(str + File.separator + "classes.dex");
                if (!file.exists()) {
                    C0886f.set(7007, file.getAbsolutePath() + " not exist");
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static C0626ap[] m1834a(C0626ap[] c0626apArr, C0626ap[] c0626apArr2) {
        Object c0626apArr3;
        Object c0626apArr22;
        if (c0626apArr3 == null) {
            c0626apArr3 = new C0626ap[0];
        }
        if (c0626apArr22 == null) {
            c0626apArr22 = new C0626ap[0];
        }
        Object obj = new C0626ap[(c0626apArr3.length + c0626apArr22.length)];
        System.arraycopy(c0626apArr3, 0, obj, 0, c0626apArr3.length);
        System.arraycopy(c0626apArr22, 0, obj, c0626apArr3.length, c0626apArr22.length);
        return obj;
    }

    /* renamed from: b */
    private static C1774c m1835b(Context context, RootConfig rootConfig, File file, File file2) {
        C0633at.m1464h("联网下发方案列表");
        C1774c D = C0751dm.m1842aS() ? C0751dm.m1841D(context) : C0769dy.m1906D(context);
        C0626ap[] c0626apArr = D.f5200kB;
        if (c0626apArr != null && c0626apArr.length > 0) {
            String[] strArr = new String[c0626apArr.length];
            int length = c0626apArr.length;
            for (int i = 0; i < length; i++) {
                C0626ap c0626ap = c0626apArr[i];
                try {
                    C0883c.m2393a(c0626ap.f1562bQ.getBytes(), new File(file, c0626ap.f1556bK).getAbsolutePath());
                    strArr[i] = c0626ap.f1556bK;
                } catch (Throwable e) {
                    e.printStackTrace();
                    C0886f.set(7002, "", e);
                }
                c0626ap.f1563bR = file2.getAbsolutePath() + File.separator + c0626ap.f1556bK;
            }
            if (strArr.length != 0) {
                C0633at.m1464h("存储方案下发顺序列表");
                C0739de.m1795a(context, "solution_id_list", TextUtils.join(",", strArr));
            }
        }
        C0749dk.m1828a(rootConfig, D);
        return D;
    }

    /* renamed from: b */
    private static void m1836b(RootConfig rootConfig, C1774c c1774c) {
        File file = new File(rootConfig.mo8167a("yis_cfg.txt"));
        if (file.exists()) {
            c1774c.f5197hh = new C0787eo();
            c1774c.f5198hi = new C0787eo();
            String Y = C0883c.m2389Y(file.getAbsolutePath());
            if (Y != null && Y.trim().length() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(Y);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("pcRootInfo");
                    jSONObject = jSONObject.getJSONObject("mobileRootInfo");
                    c1774c.f5197hh.f1936hI = jSONObject2.getInt("canRoot");
                    c1774c.f5197hh.f1937hJ = jSONObject2.getInt("useTime");
                    c1774c.f5197hh.f1938hK = jSONObject2.getInt("succUsers");
                    c1774c.f5197hh.f1939hL = jSONObject2.getInt("succRate");
                    try {
                        c1774c.f5197hh.f1940hM = (long) jSONObject2.getInt("subitUsers");
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    c1774c.f5198hi.f1936hI = jSONObject.getInt("canRoot");
                    c1774c.f5198hi.f1937hJ = jSONObject.getInt("useTime");
                    c1774c.f5198hi.f1938hK = jSONObject.getInt("succUsers");
                    c1774c.f5198hi.f1939hL = jSONObject.getInt("succRate");
                    try {
                        c1774c.f5198hi.f1940hM = (long) jSONObject.getInt("subitUsers");
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    file.delete();
                }
            }
        }
    }

    /* renamed from: r */
    public static void m1837r(Context context, String str) {
        int c = C0739de.m1799c(context, "solution_fail_count_" + str) + 1;
        C0633at.m1464h("sid = " + str + ", failCount = " + c);
        C0739de.m1798b(context, "solution_fail_count_" + str, c);
    }
}
