package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

/* renamed from: com.baidu.mobads.ao */
class C0259ao extends RelativeLayout {
    /* renamed from: a */
    private C0242a f432a;

    /* renamed from: com.baidu.mobads.ao$a */
    public interface C0242a {
        @SuppressLint({"MissingSuperCall"})
        /* renamed from: a */
        void mo4248a();

        /* renamed from: a */
        void mo4249a(int i);

        /* renamed from: a */
        void mo4250a(int i, int i2);

        /* renamed from: a */
        void mo4251a(boolean z);

        /* renamed from: a */
        boolean mo4252a(int i, KeyEvent keyEvent);

        /* renamed from: b */
        void mo4253b();
    }

    public C0259ao(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo4382a(C0242a c0242a) {
        this.f432a = c0242a;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f432a != null) {
            this.f432a.mo4253b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f432a != null) {
            this.f432a.mo4248a();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f432a != null) {
            return this.f432a.mo4252a(i, keyEvent);
        }
        super.onKeyDown(i, keyEvent);
        return false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.f432a != null) {
            this.f432a.mo4250a(getWidth(), getHeight());
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f432a != null) {
            this.f432a.mo4251a(z);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f432a != null) {
            this.f432a.mo4249a(i);
        }
    }
}
