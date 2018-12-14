package com.baidu.mobads.p021j;

import android.content.Context;
import com.baidu.mobads.C0255am;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.p029c.C0361d;
import com.baidu.mobads.p031e.C0278a;

/* renamed from: com.baidu.mobads.j.m */
public class C0338m {
    /* renamed from: o */
    private static final C0338m f679o = new C0338m();
    /* renamed from: a */
    private C0333g f680a;
    /* renamed from: b */
    private C0233l f681b = new C0233l();
    /* renamed from: c */
    private IBase64 f682c = new C0326a();
    /* renamed from: d */
    private IXAdLogger f683d = C0336j.m550a();
    /* renamed from: e */
    private IXAdViewUtils f684e = new C0344s();
    /* renamed from: f */
    private IXAdBitmapUtils f685f = new C0328c();
    /* renamed from: g */
    private IXAdURIUitls f686g = new C0343r();
    /* renamed from: h */
    private IXAdIOUtils f687h = new C0335i();
    /* renamed from: i */
    private IXAdPackageUtils f688i = new C0337k();
    /* renamed from: j */
    private IXAdActivityUtils f689j = new C0327b();
    /* renamed from: k */
    private IXAdSystemUtils f690k = new C0339n();
    /* renamed from: l */
    private C0329d f691l = new C0329d();
    /* renamed from: m */
    private IXAdConstants f692m = new C0255am();
    /* renamed from: n */
    private IXAdErrorCode f693n = new C0278a(this.f683d);
    /* renamed from: p */
    private Context f694p;
    /* renamed from: q */
    private IXAdContainerFactory f695q;

    private C0338m() {
    }

    /* renamed from: a */
    public static C0338m m569a() {
        return f679o;
    }

    /* renamed from: a */
    public void mo5026a(Context context) {
        if (this.f694p == null) {
            this.f694p = context;
        }
        this.f680a = new C0333g(this.f694p);
    }

    /* renamed from: a */
    public void mo5027a(IXAdContainerFactory iXAdContainerFactory) {
        if (iXAdContainerFactory == null) {
            this.f695q = iXAdContainerFactory;
        }
    }

    /* renamed from: b */
    public C0333g mo5028b() {
        return this.f680a;
    }

    /* renamed from: b */
    public IOAdDownloaderManager mo5029b(Context context) {
        return C0361d.m637a(context);
    }

    /* renamed from: c */
    public IXAdContainerFactory mo5030c() {
        return this.f695q;
    }

    /* renamed from: d */
    public Context mo5031d() {
        return this.f694p;
    }

    /* renamed from: e */
    public IBase64 mo5032e() {
        return this.f682c;
    }

    /* renamed from: f */
    public IXAdLogger mo5033f() {
        return this.f683d;
    }

    /* renamed from: g */
    public C0233l mo5034g() {
        return this.f681b;
    }

    /* renamed from: h */
    public IXAdBitmapUtils mo5035h() {
        return this.f685f;
    }

    /* renamed from: i */
    public IXAdURIUitls mo5036i() {
        return this.f686g;
    }

    /* renamed from: j */
    public IXAdViewUtils mo5037j() {
        return this.f684e;
    }

    /* renamed from: k */
    public IXAdIOUtils mo5038k() {
        return this.f687h;
    }

    /* renamed from: l */
    public IXAdPackageUtils mo5039l() {
        return this.f688i;
    }

    /* renamed from: m */
    public C0329d mo5040m() {
        return this.f691l;
    }

    /* renamed from: n */
    public IXAdSystemUtils mo5041n() {
        return this.f690k;
    }

    /* renamed from: o */
    public IXAdActivityUtils mo5042o() {
        return this.f689j;
    }

    /* renamed from: p */
    public IXAdConstants mo5043p() {
        return this.f692m;
    }

    /* renamed from: q */
    public IXAdErrorCode mo5044q() {
        return this.f693n;
    }
}
