package com.shuame.p075ad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.shuame.utils.C1620d;
import java.io.File;

/* renamed from: com.shuame.ad.x */
public class C1121x extends C1107n {
    /* renamed from: f */
    private static final String f3006f = C1121x.class.getSimpleName();
    /* renamed from: g */
    private Handler f3007g = new Handler(Looper.getMainLooper());
    /* renamed from: h */
    private OnClickListener f3008h = new C1086ac(this);

    /* renamed from: a */
    private void m3255a(int i) {
        this.f3007g.postDelayed(new C1122y(this), (long) i);
    }

    /* renamed from: a */
    private void m3256a(ImageView imageView, Bitmap bitmap) {
        this.f3007g.post(new C1084aa(this, imageView, bitmap));
    }

    /* renamed from: a */
    private void m3258a(String str) {
        this.f3007g.post(new C1085ab(this, str));
    }

    /* renamed from: a */
    static /* synthetic */ boolean m3259a(C1121x c1121x, String str, ImageView imageView) {
        File b = c1121x.m3260b(str);
        if (!b.exists() || b.length() <= 0) {
            return false;
        }
        c1121x.m3256a(imageView, BitmapFactory.decodeFile(b.getAbsolutePath(), new Options()));
        return true;
    }

    /* renamed from: b */
    private File m3260b(String str) {
        File file = new File(this.f2968c.getCacheDir(), "image");
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = new File(Environment.getExternalStorageDirectory(), "Android/data/" + this.f2968c.getPackageName() + "/image");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, C1620d.m4391a(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f A:{SYNTHETIC, Splitter: B:17:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A:{SYNTHETIC, Splitter: B:22:0x0058} */
    /* renamed from: b */
    static /* synthetic */ void m3261b(com.shuame.p075ad.C1121x r5, java.lang.String r6, android.widget.ImageView r7) {
        /*
        r0 = new okhttp3.v;
        r0.<init>();
        r1 = new okhttp3.y$a;
        r1.<init>();
        r1 = r1.mo8956a(r6);
        r1 = r1.mo8961a();
        r0 = r0.mo8935a(r1);	 Catch:{ IOException -> 0x005c }
        r0 = r0.mo8666a();	 Catch:{ IOException -> 0x005c }
        r1 = r0.mo8631c();	 Catch:{ IOException -> 0x005c }
        if (r1 == 0) goto L_0x0063;
    L_0x0020:
        r0 = r0.mo8635f();	 Catch:{ IOException -> 0x005c }
        r0 = r0.mo8643c();	 Catch:{ IOException -> 0x005c }
        r0 = r0.mo9030f();	 Catch:{ IOException -> 0x005c }
        r2 = android.graphics.BitmapFactory.decodeStream(r0);	 Catch:{ IOException -> 0x005c }
        r3 = r5.m3260b(r6);	 Catch:{ IOException -> 0x005c }
        r1 = 0;
        r0 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x004b, all -> 0x0055 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x004b, all -> 0x0055 }
        r1 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Exception -> 0x0081, all -> 0x007c }
        r3 = 100;
        r2.compress(r1, r3, r0);	 Catch:{ Exception -> 0x0081, all -> 0x007c }
        r0.flush();	 Catch:{ Exception -> 0x0081, all -> 0x007c }
        r0.close();	 Catch:{ IOException -> 0x0078 }
    L_0x0047:
        r5.m3256a(r7, r2);	 Catch:{ IOException -> 0x005c }
    L_0x004a:
        return;
    L_0x004b:
        r0 = move-exception;
        r0 = r1;
    L_0x004d:
        if (r0 == 0) goto L_0x0047;
    L_0x004f:
        r0.close();	 Catch:{ IOException -> 0x0053 }
        goto L_0x0047;
    L_0x0053:
        r0 = move-exception;
        goto L_0x0047;
    L_0x0055:
        r0 = move-exception;
    L_0x0056:
        if (r1 == 0) goto L_0x005b;
    L_0x0058:
        r1.close();	 Catch:{ IOException -> 0x007a }
    L_0x005b:
        throw r0;	 Catch:{ IOException -> 0x005c }
    L_0x005c:
        r0 = move-exception;
        r0 = "IOException";
        r5.m3258a(r0);
        goto L_0x004a;
    L_0x0063:
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005c }
        r1.<init>();	 Catch:{ IOException -> 0x005c }
        r0 = r0.mo8630b();	 Catch:{ IOException -> 0x005c }
        r0 = r1.append(r0);	 Catch:{ IOException -> 0x005c }
        r0 = r0.toString();	 Catch:{ IOException -> 0x005c }
        r5.m3258a(r0);	 Catch:{ IOException -> 0x005c }
        goto L_0x004a;
    L_0x0078:
        r0 = move-exception;
        goto L_0x0047;
    L_0x007a:
        r1 = move-exception;
        goto L_0x005b;
    L_0x007c:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0056;
    L_0x0081:
        r1 = move-exception;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.ad.x.b(com.shuame.ad.x, java.lang.String, android.widget.ImageView):void");
    }

    /* renamed from: a */
    protected final View mo6708a() {
        View j = mo6719j();
        View imageView = new ImageView(this.f2968c);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setOnClickListener(this.f3008h);
        if (this.f2967b == null || TextUtils.isEmpty(this.f2967b.imageUrl)) {
            m3255a(0);
        } else {
            C1094ae.m3178a().mo6680a(new C1123z(this, this.f2967b.imageUrl, imageView));
        }
        j.addView(imageView, new LayoutParams(-1, -1));
        return j;
    }

    /* renamed from: a */
    final void mo6711a(FragmentBuildContext fragmentBuildContext) {
        if (this.f2967b != null) {
            this.f2970e = this.f2967b.closeBtn;
        }
    }

    /* renamed from: b */
    protected final View mo6712b() {
        return new TextView(this.f2968c);
    }
}
