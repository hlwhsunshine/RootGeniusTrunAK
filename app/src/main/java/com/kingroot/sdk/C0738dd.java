package com.kingroot.sdk;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;

/* renamed from: com.kingroot.sdk.dd */
public class C0738dd extends ContextWrapper {
    /* renamed from: ff */
    private String f1799ff;
    /* renamed from: fg */
    private AssetManager f1800fg;
    /* renamed from: fh */
    private Resources f1801fh;
    /* renamed from: fi */
    private Theme f1802fi;

    public C0738dd(Context context, String str) {
        super(context);
        this.f1799ff = str;
        mo5731aK();
    }

    /* renamed from: aK */
    protected void mo5731aK() {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{this.f1799ff});
            this.f1800fg = assetManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Resources resources = super.getResources();
        this.f1801fh = new Resources(this.f1800fg, resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1802fi = this.f1801fh.newTheme();
        this.f1802fi.setTo(super.getTheme());
    }

    public AssetManager getAssets() {
        return this.f1800fg;
    }

    public Resources getResources() {
        return this.f1801fh;
    }
}
