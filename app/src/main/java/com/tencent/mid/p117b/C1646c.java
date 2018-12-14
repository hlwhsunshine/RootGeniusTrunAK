package com.tencent.mid.p117b;

import android.content.Context;
import android.os.Environment;
import com.tencent.mid.util.Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* renamed from: com.tencent.mid.b.c */
public class C1646c extends C1645f {
    public C1646c(Context context) {
        super(context);
    }

    /* renamed from: a */
    public int mo7645a() {
        return 2;
    }

    /* renamed from: a */
    protected void mo7647a(C1643a c1643a) {
    }

    /* renamed from: a */
    protected void mo7648a(String str) {
        synchronized (this) {
            Util.logInfo("write mid to InternalStorage");
            C1644b.m4494a(Environment.getExternalStorageDirectory() + "/" + C1645f.m4497f());
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), C1645f.m4498g())));
                bufferedWriter.write(mo7659l() + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Throwable e) {
                Util.logWarn(e);
            }
        }
    }

    /* renamed from: b */
    protected boolean mo7651b() {
        return Util.checkPermission(this.f4694a, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: c */
    protected String mo7652c() {
        String str;
        synchronized (this) {
            Util.logInfo("read mid from InternalStorage");
            try {
                for (String str2 : C1644b.m4495a(new File(Environment.getExternalStorageDirectory(), C1645f.m4498g()))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(mo7659l())) {
                        Util.logInfo("read mid from InternalStorage:" + split[1]);
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (Throwable e) {
                Util.logWarn(e);
                str2 = null;
            }
        }
        return str2;
    }

    /* renamed from: d */
    protected void mo7654d() {
        synchronized (this) {
            C1644b.m4494a(Environment.getExternalStorageDirectory() + "/" + C1645f.m4497f());
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), C1645f.m4498g())));
                bufferedWriter.write("");
                bufferedWriter.close();
            } catch (Throwable e) {
                Util.logWarn(e);
            }
        }
    }

    /* renamed from: e */
    protected C1643a mo7655e() {
        return null;
    }
}
