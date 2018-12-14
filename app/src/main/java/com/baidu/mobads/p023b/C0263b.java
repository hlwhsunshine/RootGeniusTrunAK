package com.baidu.mobads.p023b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p024a.C0262d;
import com.baidu.mobads.p021j.C0338m;
import java.io.File;

/* renamed from: com.baidu.mobads.b.b */
public class C0263b extends C0262d {
    /* renamed from: a */
    protected final IXAdLogger f436a = C0338m.m569a().mo5033f();
    /* renamed from: d */
    private C0260a f437d;
    /* renamed from: e */
    private String f438e;
    /* renamed from: f */
    private File f439f;
    /* renamed from: g */
    private Boolean f440g;

    public C0263b(Context context, String str, File file, boolean z) {
        super(context);
        this.f438e = str;
        this.f439f = file;
        this.f440g = Boolean.valueOf(z);
    }

    /* renamed from: a */
    public void mo4390a() {
        try {
            if (this.f440g.booleanValue() && this.f438e != null) {
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                this.f435b.registerReceiver(this.f437d, intentFilter);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.fromFile(this.f439f), "application/vnd.android.package-archive");
            this.f435b.startActivity(intent);
        } catch (Exception e) {
            this.f436a.mo4929e("XAdInstallController", "");
        }
    }

    /* renamed from: a */
    public void mo4391a(BroadcastReceiver broadcastReceiver) {
        this.f437d = (C0260a) broadcastReceiver;
    }
}
