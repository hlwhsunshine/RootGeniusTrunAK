package com.p070qq.p071e.comm.managers.plugin;

import android.content.Context;
import com.p070qq.p071e.comm.util.C1080a;
import com.p070qq.p071e.comm.util.FileUtil;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.Md5Util;
import com.p070qq.p071e.comm.util.StringUtil;
import java.io.File;

/* renamed from: com.qq.e.comm.managers.plugin.c */
class C1065c {
    /* renamed from: a */
    private final File f2785a;
    /* renamed from: b */
    private final File f2786b;
    /* renamed from: c */
    private String f2787c;
    /* renamed from: d */
    private int f2788d;

    public C1065c(File file, File file2) {
        this.f2785a = file;
        this.f2786b = file2;
    }

    /* renamed from: a */
    static File m3086a(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar");
    }

    /* renamed from: b */
    static File m3087b(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.next");
    }

    /* renamed from: c */
    static File m3088c(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar.sig");
    }

    /* renamed from: d */
    static File m3089d(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.next.sig");
    }

    /* renamed from: a */
    final boolean mo6468a() {
        try {
            if (!this.f2786b.exists() || !this.f2785a.exists()) {
                return false;
            }
            String[] split = StringUtil.readAll(this.f2786b).split("#####");
            if (split.length != 2) {
                return false;
            }
            String str = split[1];
            int parseInteger = StringUtil.parseInteger(split[0], 0);
            C1080a a = C1080a.m3136a();
            File file = this.f2785a;
            boolean b = (file == null || !file.exists()) ? false : a.mo6629b(str, Md5Util.encode(file));
            if (!b) {
                return false;
            }
            this.f2787c = str;
            this.f2788d = parseInteger;
            return true;
        } catch (Throwable th) {
            GDTLogger.report("Exception while checking plugin", th);
            return false;
        }
    }

    /* renamed from: a */
    final boolean mo6469a(File file, File file2) {
        return (file == null || file2 == null) ? false : (file.equals(this.f2785a) || FileUtil.renameTo(this.f2785a, file)) ? file2.equals(this.f2786b) || FileUtil.renameTo(this.f2786b, file2) : false;
    }

    /* renamed from: b */
    final int mo6470b() {
        return this.f2788d;
    }

    /* renamed from: c */
    final String mo6471c() {
        return this.f2787c;
    }
}
