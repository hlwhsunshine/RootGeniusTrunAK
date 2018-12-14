package com.tencent.beacon.cover;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.beacon.cover.g */
public final class C1628g implements Runnable {
    /* renamed from: a */
    public static String f4617a = null;
    /* renamed from: b */
    public static String f4618b = null;
    /* renamed from: e */
    private static C1628g f4619e = null;
    /* renamed from: c */
    private Context f4620c;
    /* renamed from: d */
    private List<C1622a> f4621d = new ArrayList();

    private C1628g(Context context) {
        if (context == null) {
            C1627f.m4428a("W", "context is null!", new Object[0]);
        } else {
            this.f4620c = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    private static long m4447a(String str) {
        long j = 0;
        try {
            return Long.parseLong(str.replaceAll("\\.", ""));
        } catch (Exception e) {
            return j;
        }
    }

    /* renamed from: a */
    public static C1628g m4448a(Context context) {
        if (f4619e == null) {
            f4619e = new C1628g(context);
        }
        return f4619e;
    }

    /* renamed from: a */
    private List<C1622a> m4449a(List<C1622a> list) {
        List<C1622a> arrayList = new ArrayList();
        for (C1622a c1622a : list) {
            Object obj = null;
            Object obj2 = null;
            for (C1622a c1622a2 : this.f4621d) {
                Object obj3;
                if (c1622a.f4588a != c1622a2.f4588a) {
                    obj3 = obj;
                    obj = obj2;
                } else if (C1628g.m4447a(c1622a.f4589b) > C1628g.m4447a(c1622a2.f4589b)) {
                    obj3 = 1;
                    obj = 1;
                } else {
                    int obj32 = 1;
                    obj = obj2;
                }
                obj2 = obj;
                obj = obj32;
            }
            if (obj2 != null || obj == null) {
                arrayList.add(c1622a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m4450a(C1622a c1622a) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.f4621d.size()) {
                i = -1;
                break;
            }
            if (c1622a.f4588a == ((C1622a) this.f4621d.get(i)).f4588a) {
                break;
            }
            i2 = i + 1;
        }
        if (i >= 0) {
            this.f4621d.remove(i);
        }
        this.f4621d.add(c1622a);
    }

    /* renamed from: a */
    private boolean m4451a(long j) {
        long j2 = 0;
        try {
            j2 = Long.valueOf(C1627f.m4435b(this.f4620c, "LAST_UPDATE_TIME", "0")).longValue();
        } catch (Exception e) {
        }
        return j - j2 > 86400000;
    }

    /* renamed from: b */
    private List<String> m4452b() {
        File file = new File(this.f4620c.getFilesDir(), "beacon/comp");
        List<String> list = null;
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                list = new ArrayList();
                for (File file2 : listFiles) {
                    list.add(file2.getName() + "," + file2.length() + "," + C1627f.m4421a(file2));
                }
            }
        }
        return list;
    }

    /* renamed from: c */
    private String m4453c() {
        List<C1622a> a = m4449a(C1627f.m4436b(C1627f.m4420a(this.f4620c, "beaconcomp" + File.separator + "comp_list")));
        byte[] bArr = new byte[2048];
        String str = this.f4620c.getFilesDir().getAbsolutePath() + File.separator + "beacon/comp";
        for (C1622a c1622a : a) {
            boolean a2;
            new StringBuilder("needUpdateComps: ").append(c1622a.f4588a).append(" - ").append(c1622a.f4591d);
            String str2 = "beaconcomp" + File.separator + c1622a.f4591d;
            if (c1622a.f4590c == C1627f.f4615b) {
                c1622a.f4591d += ".jar";
                a2 = C1627f.m4430a(this.f4620c, str2, str, c1622a.f4591d, (long) c1622a.f4593f, bArr);
            } else {
                a2 = false;
            }
            if (c1622a.f4590c == C1627f.f4616c && c1622a.f4595h.equals(C1627f.m4433b())) {
                c1622a.f4591d = c1622a.f4591d.substring(0, c1622a.f4591d.lastIndexOf("."));
                a2 = C1627f.m4430a(this.f4620c, str2, str, c1622a.f4591d, (long) c1622a.f4593f, bArr);
            }
            if (a2) {
                m4450a(c1622a);
            }
        }
        if (a.size() <= 0) {
            return "";
        }
        String a3 = C1627f.m4424a(this.f4621d);
        C1627f.m4429a(this.f4620c, "COMP_INFO", a3);
        return a3;
    }

    /* renamed from: a */
    final List<C1622a> mo7605a() {
        return this.f4621d;
    }

    public final void run() {
        int i = 1;
        String str = "check";
        if (C1625d.m4410a(this.f4620c).mo7600a(str)) {
            int i2;
            File file = new File(this.f4620c.getFilesDir(), "beacon/comp");
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(this.f4620c.getFilesDir(), "beacon/odex");
            if (!file.exists()) {
                file.mkdirs();
            }
            List<C1622a> b = C1627f.m4436b(C1627f.m4435b(this.f4620c, "COMP_INFO", ""));
            String c = C1627f.m4439c(this.f4620c);
            if (!C1627f.m4435b(this.f4620c, "APP_VER", "").equals(c)) {
                m4453c();
                C1627f.m4429a(this.f4620c, "APP_VER", c);
            }
            if (b.size() == 0) {
                C1627f.m4428a("W", "comp config has error!", new Object[0]);
            }
            List<String> b2 = m4452b();
            if (b2 == null || b2.size() == 0) {
                C1627f.m4428a("W", "local comps has error!", new Object[0]);
                i2 = 0;
            } else {
                i2 = 1;
                for (C1622a c1622a : b) {
                    if (c1622a != null) {
                        int i3;
                        for (String c2 : b2) {
                            String[] split = c2.split(",");
                            if (split.length == 3 && c1622a.f4591d.equals(split[0]) && String.valueOf(c1622a.f4593f).equals(split[1]) && c1622a.f4594g.equals(split[2])) {
                                this.f4621d.add(c1622a);
                                i3 = 1;
                                break;
                            }
                        }
                        i3 = 0;
                        if (i3 == 0) {
                            C1627f.m4428a("W", "the config is not match local comp!", new Object[0]);
                            i3 = 0;
                        } else {
                            i3 = i2;
                        }
                        i2 = i3;
                    }
                }
            }
            if (i2 != 0) {
                C1627f.m4428a("W", "start thread to load component.", new Object[0]);
                new Thread(C1623b.m4400a(this.f4620c, this.f4621d)).start();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!(i2 == 0 || m4451a(currentTimeMillis))) {
                i = 0;
            }
            if (i != 0) {
                new Thread(new C1629h(this.f4620c, this.f4621d)).start();
                C1627f.m4429a(this.f4620c, "LAST_UPDATE_TIME", String.valueOf(currentTimeMillis));
            }
            C1625d.m4410a(this.f4620c).mo7601b(str);
        }
    }
}
