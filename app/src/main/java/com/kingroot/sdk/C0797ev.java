package com.kingroot.sdk;

import android.text.TextUtils;
import com.kingroot.sdk.C0831fu.C0795a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.ev */
public class C0797ev extends C0793et {
    /* renamed from: iD */
    private boolean f2012iD = true;
    /* renamed from: iE */
    private int f2013iE = 0;
    /* renamed from: iF */
    private C0800ey f2014iF;
    /* renamed from: iG */
    private WeakReference<C0801ez> f2015iG;

    /* renamed from: com.kingroot.sdk.ev$1 */
    class C07961 implements C0795a<Boolean> {
        C07961() {
        }

        /* renamed from: a */
        public Boolean mo5806b(C0716ga c0716ga, List<Object> list) {
            if (c0716ga.mo5684f(true)) {
                List arrayList = new ArrayList();
                switch (C0797ev.this.f2014iF.f2025iK) {
                    case 1:
                        arrayList.add(C0821fm.f2064jm);
                        break;
                    case 2:
                        arrayList.add(C0821fm.f2063jl);
                        break;
                }
                arrayList.add(C0820fl.m2077b(C0797ev.this.f2014iF.f2029iO, false));
                if (C0797ev.this.f2014iF.f2029iO.length() > 1 && C0797ev.this.f2014iF.f2029iO.endsWith(File.separator)) {
                    C0797ev.this.f2014iF.f2029iO = C0797ev.this.f2014iF.f2029iO.substring(0, C0797ev.this.f2014iF.f2029iO.length() - 1);
                }
                int i = 0;
                while (true) {
                    i = C0797ev.this.f2014iF.f2029iO.indexOf(File.separatorChar, i + 1);
                    if (i == -1) {
                        if (!C0797ev.this.f2012iD) {
                            C0825fq.m2099g("check_su_files", "repair " + C0797ev.this.f2014iF.f2029iO + "...cat");
                            arrayList.add("rm " + C0797ev.this.f2014iF.f2029iO);
                            arrayList.add(String.format("cat %s > %s", new Object[]{C0797ev.this.f2014iF.f2028iN, C0797ev.this.f2014iF.f2029iO}));
                        }
                        if (C0819fk.m2076c(C0797ev.this.f2013iE, 1)) {
                            C0825fq.m2099g("check_su_files", "repair " + C0797ev.this.f2014iF.f2029iO + "...chown");
                            arrayList.add(String.format("chown %d.%d %s", new Object[]{Integer.valueOf(C0797ev.this.f2014iF.f2020dZ), Integer.valueOf(C0797ev.this.f2014iF.f2021ea), C0797ev.this.f2014iF.f2029iO}));
                            C0797ev c0797ev = C0797ev.this;
                            c0797ev.f2013iE = c0797ev.f2013iE | 2;
                        }
                        if (C0819fk.m2076c(C0797ev.this.f2013iE, 2)) {
                            C0825fq.m2099g("check_su_files", "repair " + C0797ev.this.f2014iF.f2029iO + "...chmod");
                            arrayList.add(String.format("chmod 0%o %s", new Object[]{Integer.valueOf(C0797ev.this.f2014iF.mode), C0797ev.this.f2014iF.f2029iO}));
                        }
                        if (C0819fk.m2076c(C0797ev.this.f2013iE, 8)) {
                            C0825fq.m2099g("check_su_files", "repair " + C0797ev.this.f2014iF.f2029iO + "...chcon");
                            arrayList.add(String.format("chcon %s %s", new Object[]{C0797ev.this.f2014iF.f2022eb, C0797ev.this.f2014iF.f2029iO}));
                        }
                        if (C0797ev.this.f2014iF.f2027iM) {
                            arrayList.add(C0820fl.m2077b(C0797ev.this.f2014iF.f2029iO, true));
                        }
                        c0716ga.mo5685i(arrayList);
                    } else {
                        File file = new File(C0797ev.this.f2014iF.f2029iO.substring(0, i));
                        if (!(file.getAbsolutePath().equals("/system") || file.getAbsolutePath().equals("/system/bin") || file.getAbsolutePath().equals("/system/xbin") || file.getAbsolutePath().equals("/data"))) {
                            if (!file.exists()) {
                                C0825fq.m2099g("check_su_files", "repair " + C0797ev.this.f2014iF.f2029iO + "...create" + file.getAbsolutePath());
                                arrayList.add("mkdir " + file.getAbsolutePath());
                                arrayList.add("chown 0.0 " + file.getAbsolutePath());
                                arrayList.add("chmod 0755 " + file.getAbsolutePath());
                                arrayList.add("chcon u:object_r:system_file:s0 " + file.getAbsolutePath());
                            } else if (file.isDirectory()) {
                                C0799ex c0799ex = new C0799ex();
                                c0799ex.f2019ec = 493;
                                c0799ex.f2018eb = "u:object_r:system_file:s0";
                                if (C0809fd.m2035a(c0716ga, file.getAbsolutePath(), c0799ex) != 0) {
                                    C0825fq.m2099g("check_su_files", "repair " + C0797ev.this.f2014iF.f2029iO + "...chmod,chcon" + file.getAbsolutePath());
                                    arrayList.add(C0820fl.m2077b(file.getAbsolutePath(), false));
                                    arrayList.add("chmod 0755 " + file.getAbsolutePath());
                                    arrayList.add("chcon u:object_r:system_file:s0 " + file.getAbsolutePath());
                                }
                            } else {
                                C0825fq.m2099g("check_su_files", "repair " + C0797ev.this.f2014iF.f2029iO + "...recreate" + file.getAbsolutePath());
                                arrayList.add(C0820fl.m2077b(file.getAbsolutePath(), false));
                                arrayList.add("rm " + file.getAbsolutePath());
                                arrayList.add("mkdir " + file.getAbsolutePath());
                                arrayList.add("chown 0.0 " + file.getAbsolutePath());
                                arrayList.add("chmod 0755 " + file.getAbsolutePath());
                                arrayList.add("chcon u:object_r:system_file:s0 " + file.getAbsolutePath());
                            }
                        }
                    }
                }
            }
            return Boolean.valueOf(true);
        }
    }

    public C0797ev(C0800ey c0800ey) {
        this.f2014iF = c0800ey;
    }

    /* renamed from: bI */
    private C0801ez m1999bI() {
        return this.f2015iG != null ? (C0801ez) this.f2015iG.get() : null;
    }

    /* renamed from: a */
    public boolean mo5804a(C0716ga c0716ga) {
        this.f2012iD = true;
        this.f2013iE = 0;
        if (this.f2014iF == null || TextUtils.isEmpty(this.f2014iF.f2028iN)) {
            return true;
        }
        if (this.f2014iF.f2026iL && !C0826fr.m2103bY()) {
            return true;
        }
        if (this.f2014iF.f2023iI != -1 && C0846gi.m2195I() < this.f2014iF.f2023iI) {
            return true;
        }
        if (this.f2014iF.f2024iJ != -1 && C0846gi.m2195I() > this.f2014iF.f2024iJ) {
            return true;
        }
        this.f2012iD = C0809fd.m2040i(this.f2014iF.f2028iN, this.f2014iF.f2029iO) == 0;
        if (this.f2012iD) {
            C0799ex c0799ex = new C0799ex();
            c0799ex.f2016dZ = this.f2014iF.f2020dZ;
            c0799ex.f2017ea = this.f2014iF.f2021ea;
            c0799ex.mode = this.f2014iF.mode;
            c0799ex.f2018eb = this.f2014iF.f2022eb;
            this.f2013iE = C0809fd.m2035a(c0716ga, this.f2014iF.f2029iO, c0799ex);
        } else {
            this.f2013iE = 15;
        }
        return this.f2012iD && this.f2013iE == 0;
    }

    /* renamed from: b */
    public boolean mo5805b(C0716ga c0716ga) {
        int i = 1;
        if (this.f2014iF == null) {
            return true;
        }
        C0825fq.m2099g("check_su_files", "repair " + this.f2014iF.f2029iO);
        boolean booleanValue = ((Boolean) C0831fu.m2119a(c0716ga, new C07961(), new Object[0])).booleanValue();
        C0825fq.m2099g("check_su_files", "repair " + this.f2014iF.f2029iO + "..." + booleanValue);
        try {
            C0801ez bI = m1999bI();
            if (bI == null) {
                return booleanValue;
            }
            if (!booleanValue) {
                i = 0;
            }
            bI.mo5808D(i);
            return booleanValue;
        } catch (Exception e) {
            return booleanValue;
        }
    }
}
