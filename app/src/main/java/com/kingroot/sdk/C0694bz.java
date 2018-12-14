package com.kingroot.sdk;

import android.content.Context;
import java.io.File;

/* renamed from: com.kingroot.sdk.bz */
public class C0694bz<T extends C0688cb> {
    /* renamed from: dE */
    private Context f1700dE;
    /* renamed from: dF */
    private T f1701dF;
    /* renamed from: dG */
    private C0697ca<T> f1702dG;
    /* renamed from: dH */
    private final Object f1703dH = new Object();
    /* renamed from: dI */
    private String f1704dI;
    /* renamed from: dJ */
    private C0690cc<T> f1705dJ = null;
    /* renamed from: dK */
    C0690cc<T> f1706dK = new C06931();

    /* renamed from: com.kingroot.sdk.bz$1 */
    class C06931 extends C0690cc<T> {
        C06931() {
        }

        /* renamed from: a */
        public void mo5659a(T t) {
            if (C0694bz.this.f1705dJ != null) {
                C0694bz.this.f1705dJ.mo5659a(t);
            }
        }

        /* renamed from: b */
        public void mo5660b(T t) {
            C0694bz.this.m1662ah();
            if (C0694bz.this.f1705dJ != null) {
                C0694bz.this.f1705dJ.mo5660b(t);
            }
        }

        /* renamed from: c */
        public void mo5661c(T t) {
            if (C0694bz.this.f1705dJ != null) {
                C0694bz.this.f1705dJ.mo5661c(t);
            }
        }

        /* renamed from: d */
        public void mo5662d(T t) {
            if (C0694bz.this.f1705dJ != null) {
                C0694bz.this.f1705dJ.mo5662d(t);
            }
        }

        /* renamed from: e */
        public void mo5663e(T t) {
            if (C0694bz.this.f1705dJ != null) {
                C0694bz.this.f1705dJ.mo5663e(t);
            }
        }
    }

    public C0694bz(Context context, T t) {
        this.f1700dE = context;
        this.f1701dF = t;
    }

    /* renamed from: ah */
    private void m1662ah() {
        m1663ai();
    }

    /* renamed from: ai */
    private void m1663ai() {
        String str = this.f1701dF.f1690dT + File.separator + this.f1701dF.mName;
        File file = new File(str + ".tmp");
        File file2 = new File(str);
        if (file.exists()) {
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
        }
    }

    /* renamed from: C */
    public void mo5668C(String str) {
        this.f1704dI = str;
        File file = new File(this.f1704dI);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* renamed from: a */
    public void mo5669a(C0690cc<T> c0690cc) {
        this.f1705dJ = c0690cc;
    }

    /* renamed from: ag */
    public void mo5670ag() {
        this.f1706dK.mo5661c(this.f1701dF);
        synchronized (this.f1703dH) {
            if (this.f1702dG != null) {
                this.f1702dG.mo5676al();
                this.f1702dG = null;
            }
        }
        String str = this.f1704dI + File.separator + this.f1701dF.mName;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        str = str + ".tmp";
        file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (Throwable e) {
            C0633at.m1459a(e);
        }
        synchronized (this.f1703dH) {
            this.f1702dG = new C0697ca(this.f1700dE, this.f1701dF, str);
            this.f1702dG.mo5675a(this.f1706dK);
            this.f1701dF.f1692dV = this.f1702dG;
            this.f1701dF.f1690dT = this.f1704dI;
            this.f1702dG.mo5632j(true);
        }
    }
}
