package com.shuame.rootgenius.p110g;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.p014os.SystemProperties;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.changefontmanager.sdk.ChangeFontManager;
import com.example.myfontsdk.C0446c;
import com.example.myfontsdk.C0454k;
import com.example.myfontsdk.Font;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.manager.AppManager;
import com.shuame.rootgenius.common.manager.AppManager.C1318c;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.qqdownload.C1319h;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.dialog.C1549b;
import com.shuame.rootgenius.p115ui.dialog.MyActivityDialog;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.shuame.rootgenius.g.c */
public class C1440c implements C1318c, C1319h {
    /* renamed from: a */
    public static boolean f3951a = false;
    /* renamed from: b */
    public static boolean f3952b = false;
    /* renamed from: c */
    private static C1440c f3953c;
    /* renamed from: d */
    private static final String f3954d = C1440c.class.getSimpleName();
    /* renamed from: e */
    private HashMap<Integer, Font> f3955e = new HashMap();
    /* renamed from: f */
    private Handler f3956f = new C1438b();
    /* renamed from: g */
    private HandlerThread f3957g = new HandlerThread("AppManagerHandlerThread");
    /* renamed from: h */
    private C1439c f3958h;
    /* renamed from: i */
    private Handler f3959i;
    /* renamed from: j */
    private Context f3960j = RootGeniusApp.m3523a();
    /* renamed from: k */
    private Map<Integer, C1437a> f3961k = new ConcurrentHashMap();
    /* renamed from: l */
    private Font f3962l;

    /* renamed from: com.shuame.rootgenius.g.c$a */
    public class C1437a {
        /* renamed from: b */
        private Font f3946b;
        /* renamed from: c */
        private int f3947c;
        /* renamed from: d */
        private boolean f3948d = false;

        public C1437a(Font font, int i) {
            this.f3946b = font;
            this.f3947c = i;
        }

        /* renamed from: a */
        public final Font mo7156a() {
            return this.f3946b;
        }

        /* renamed from: b */
        public final int mo7157b() {
            return this.f3947c;
        }

        /* renamed from: c */
        public final void mo7158c() {
            this.f3948d = true;
        }

        /* renamed from: d */
        public final boolean mo7159d() {
            return this.f3948d;
        }
    }

    /* renamed from: com.shuame.rootgenius.g.c$b */
    class C1438b extends Handler {
        C1438b() {
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Intent intent = new Intent(C1440c.this.f3960j, MyActivityDialog.class);
                    intent.addFlags(268435456);
                    intent.putExtra("fontName", C1440c.m3984a().mo7174e());
                    C1440c.this.f3960j;
                    int c = C1440c.m3987c();
                    if (c != 1) {
                        if (c == 0) {
                            intent.putExtra("type", 0);
                            C1440c.this.f3960j.startActivity(intent);
                            break;
                        }
                    }
                    intent.putExtra("type", 1);
                    C1440c.this.f3960j.startActivity(intent);
                    break;
                    break;
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.shuame.rootgenius.g.c$c */
    private class C1439c extends Handler {
        public C1439c(Looper looper) {
            super(looper);
        }

        public final void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    C1440c.m3986a(C1440c.this, message);
                    return;
                default:
                    return;
            }
        }
    }

    private C1440c() {
        this.f3957g.start();
        this.f3958h = new C1439c(this.f3957g.getLooper());
    }

    /* renamed from: a */
    public static C1440c m3984a() {
        if (f3953c == null) {
            synchronized (C1440c.class) {
                if (f3953c == null) {
                    f3953c = new C1440c();
                }
            }
        }
        return f3953c;
    }

    /* renamed from: a */
    private void m3985a(int i, int i2, int i3, long j) {
        Message obtainMessage = this.f3959i.obtainMessage(i);
        obtainMessage.arg1 = i2;
        obtainMessage.arg2 = i3;
        this.f3959i.sendMessageDelayed(obtainMessage, j);
    }

    /* renamed from: c */
    public static int m3987c() {
        float floatValue;
        float floatValue2;
        float floatValue3;
        int i = 0;
        int i2 = 1;
        String str = Build.MANUFACTURER;
        int i3 = VERSION.SDK_INT;
        String str2 = Build.MODEL;
        String str3 = Build.DISPLAY;
        String str4 = Build.BRAND;
        int i4 = (str2.equals("H30-U") && str.contains("huawei")) ? 1 : 0;
        if ((Build.BRAND.equals("Huawei") & new File("/data/skin/fonts").exists()) == 0) {
            i = i4;
        }
        String toLowerCase = str2.trim().toLowerCase();
        i4 = (str == null || !str.trim().contains("samsung") || i3 < 9 || (str2 != null && (toLowerCase.contains("google") || toLowerCase.contains("nexus")))) ? i : 3;
        if ((str3 != null && str3.toLowerCase().contains("miui")) || str4.equals("Xiaomi")) {
            i4 = 1;
        }
        switch (C1440c.m3989f()) {
            case 1:
            case 2:
                break;
            default:
                i2 = i4;
                break;
        }
        toLowerCase = SystemProperties.get("ro.build.sense.version");
        String str5 = SystemProperties.get("ro.oppo.theme.version");
        String str6 = SystemProperties.get("ro.theme.version");
        try {
            floatValue = Float.valueOf(toLowerCase).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            floatValue = 0.0f;
        }
        try {
            floatValue2 = Float.valueOf(str5).floatValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            floatValue2 = 0.0f;
        }
        try {
            floatValue3 = Float.valueOf(str6).floatValue();
        } catch (Exception e22) {
            e22.printStackTrace();
            floatValue3 = 0.0f;
        }
        return (((double) floatValue) >= 6.0d || floatValue2 >= 6.0f || floatValue3 >= 4.0f) ? 3 : i2;
    }

    /* renamed from: d */
    public static boolean m3988d() {
        ChangeFontManager instance = ChangeFontManager.getInstance();
        return instance.isLenovoLenovo() || instance.isIsnexus() || instance.isOPPO();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0079 A:{SYNTHETIC, Splitter: B:38:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070 A:{SYNTHETIC, Splitter: B:32:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0079 A:{SYNTHETIC, Splitter: B:38:0x0079} */
    /* renamed from: f */
    private static int m3989f() {
        /*
        r0 = 1;
        r2 = -1;
        r1 = 0;
        r3 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = "getprop ";
        r4 = r3.exec(r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r3 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r5 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = r4.getInputStream();	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r5.<init>(r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3.<init>(r5, r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r1 = r2;
    L_0x001e:
        r4 = r3.readLine();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r4 == 0) goto L_0x0062;
    L_0x0024:
        r5 = "ro.miui.ui.version.code";
        r5 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r5 == 0) goto L_0x0050;
    L_0x002c:
        r1 = ":";
        r1 = r4.indexOf(r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r5 = r1 + 3;
        r1 = r1 + 4;
        r1 = r4.substring(r5, r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r1 = r1.intValue();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r2 = 3;
        if (r1 < r2) goto L_0x004a;
    L_0x0045:
        r3.close();	 Catch:{ IOException -> 0x007d }
    L_0x0048:
        r0 = 2;
    L_0x0049:
        return r0;
    L_0x004a:
        r3.close();	 Catch:{ IOException -> 0x004e }
        goto L_0x0049;
    L_0x004e:
        r1 = move-exception;
        goto L_0x0049;
    L_0x0050:
        r5 = "miui";
        r5 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r5 != 0) goto L_0x0060;
    L_0x0058:
        r5 = "MIUI";
        r4 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r4 == 0) goto L_0x001e;
    L_0x0060:
        r1 = r0;
        goto L_0x001e;
    L_0x0062:
        r3.close();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r3.close();	 Catch:{ IOException -> 0x007f }
    L_0x0068:
        r0 = r1;
        goto L_0x0049;
    L_0x006a:
        r0 = move-exception;
    L_0x006b:
        r0.printStackTrace();	 Catch:{ all -> 0x0087 }
        if (r1 == 0) goto L_0x0073;
    L_0x0070:
        r1.close();	 Catch:{ IOException -> 0x0081 }
    L_0x0073:
        r0 = r2;
        goto L_0x0049;
    L_0x0075:
        r0 = move-exception;
        r3 = r1;
    L_0x0077:
        if (r3 == 0) goto L_0x007c;
    L_0x0079:
        r3.close();	 Catch:{ IOException -> 0x0083 }
    L_0x007c:
        throw r0;
    L_0x007d:
        r0 = move-exception;
        goto L_0x0048;
    L_0x007f:
        r0 = move-exception;
        goto L_0x0068;
    L_0x0081:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0083:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0085:
        r0 = move-exception;
        goto L_0x0077;
    L_0x0087:
        r0 = move-exception;
        r3 = r1;
        goto L_0x0077;
    L_0x008a:
        r0 = move-exception;
        r1 = r3;
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.g.c.f():int");
    }

    /* renamed from: a */
    public final void mo7162a(int i) {
        this.f3961k.remove(Integer.valueOf(i));
    }

    /* renamed from: a */
    public final void mo7163a(Context context) {
        C1549b c1549b = new C1549b(context);
        c1549b.mo7449a(C1450R.string.txt_tip_not_root_font);
        c1549b.mo7450a(C1450R.string.later_to_say, new C1441d(this, c1549b));
        c1549b.mo7451b(C1450R.string.onekeyroot, new C1442e(this, context, c1549b));
        c1549b.show();
    }

    /* renamed from: a */
    public final void mo7164a(Handler handler) {
        this.f3959i = handler;
    }

    /* renamed from: a */
    public final void mo7165a(Font font, int i) {
        if (this.f3958h != null) {
            Message obtainMessage = this.f3958h.obtainMessage(1);
            obtainMessage.obj = new C1437a(font, i);
            this.f3961k.put(Integer.valueOf(i), (C1437a) obtainMessage.obj);
            this.f3958h.sendMessage(obtainMessage);
        }
    }

    /* renamed from: a */
    public final void mo7166a(C1437a c1437a) {
        this.f3958h.removeMessages(1, c1437a);
    }

    /* renamed from: a */
    public final void mo7167a(List<Font> list) {
        if (list != null) {
            if (this.f3955e != null && this.f3955e.size() > 0) {
                this.f3955e.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    this.f3955e.put(Integer.valueOf(C1361b.m3815a(((Font) list.get(i2)).getDownloadUr())), list.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo7168b(Context context) {
        C1549b c1549b = new C1549b(context);
        ((Button) c1549b.findViewById(C1450R.id.ok)).setLayoutParams(new LayoutParams(-1, context.getResources().getDimensionPixelSize(C1450R.dimen.alert_dialog_btn_height)));
        c1549b.mo7449a(C1450R.string.alert_dialog_msg_not_network);
        c1549b.mo7451b(C1450R.string.alert_dialog_setting, new C1443f(this, context, c1549b));
        c1549b.show();
    }

    /* renamed from: b */
    public final boolean mo7169b() {
        return this.f3961k.isEmpty();
    }

    /* renamed from: b */
    public final boolean mo7170b(int i) {
        return this.f3961k.containsKey(Integer.valueOf(i));
    }

    /* renamed from: c */
    public final C1437a mo7171c(int i) {
        return (C1437a) this.f3961k.get(Integer.valueOf(i));
    }

    /* renamed from: c */
    public final void mo7172c(Context context) {
        C1549b c1549b = new C1549b(context);
        ((Button) c1549b.findViewById(C1450R.id.ok)).setLayoutParams(new LayoutParams(-1, context.getResources().getDimensionPixelSize(C1450R.dimen.alert_dialog_btn_height)));
        c1549b.mo7449a(C1450R.string.text_font_not_storage);
        c1549b.mo7451b(C1450R.string.alert_dialog_setting, new C1444g(this, context, c1549b));
        c1549b.show();
    }

    /* renamed from: d */
    public final void mo7173d(Context context) {
        C1549b c1549b = new C1549b(context);
        ((Button) c1549b.findViewById(C1450R.id.ok)).setLayoutParams(new LayoutParams(-1, context.getResources().getDimensionPixelSize(C1450R.dimen.alert_dialog_btn_height)));
        c1549b.mo7449a(C1450R.string.text_error_sdcard_not_mounted_font);
        c1549b.mo7451b(C1450R.string.txt_sure, new C1445h(this, c1549b));
        c1549b.show();
    }

    /* renamed from: e */
    public final String mo7174e() {
        return this.f3962l != null ? this.f3962l.getFontName() : "";
    }

    public void onComplete(int i, long j) {
        QQDownloadFile a = C1361b.m3817a().mo7068a(i);
        Font font = (Font) this.f3955e.get(Integer.valueOf(i));
        new StringBuilder("downloadFile.type == ").append(a.f3734o);
        if (j != 0) {
            return;
        }
        if (Type.FONT_MANAGER == a.f3734o) {
            new StringBuilder("manager onComplete downloadFile.long5 == ").append(a.f3717A);
            if (a.f3717A == 1) {
                C1348b c1348b = new C1348b();
                c1348b.f3677b = a.f3725f;
                AppManager.m3771a().mo7031a(c1348b, null);
            }
        } else if (Type.FONT == a.f3734o && f3951a) {
            C0446c.m983a(font);
            this.f3960j.getSharedPreferences("pack", 0).edit().putString("name", this.f3960j.getPackageManager().getPackageArchiveInfo(C0446c.m988b() + C0454k.m992a(font.getDownloadUr()) + ".apk", 1).packageName).commit();
            C1440c.m3984a().f3959i = this.f3956f;
            ChangeFontManager.getInstance().checkPhoneType(this.f3960j);
            C1440c.m3984a();
            if (C1440c.m3988d()) {
                new StringBuilder("isBusy == ").append(C1455a.m4026a(false));
                if (!C1455a.m4026a(false)) {
                    Intent intent = new Intent(this.f3960j, MyActivityDialog.class);
                    intent.putExtra("type", 2);
                    intent.putExtra("taskId", i);
                    intent.putExtra("font", font);
                    this.f3960j.startActivity(intent);
                    return;
                }
                return;
            }
            new StringBuilder("isBusy == ").append(C1455a.m4026a(false));
            if (!C1455a.m4026a(false)) {
                C1440c.m3984a().mo7165a(font, i);
            }
        }
    }

    public void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
    }

    public void onFileName(int i, String str) {
    }

    public void onOnlySrcUrl(int i) {
    }

    public void onStatusChanged(int i, Status status) {
    }

    public void onStatusChanged(C1348b c1348b) {
        if (c1348b.f3681f == 1) {
            ChangeFontManager.getInstance().getChangefont(this.f3960j).changeSuccessed(this.f3960j);
        }
    }

    public void onStorageErrorInfo(int i, int i2, String str) {
    }

    public void onTaskInfo(int i, int i2, int i3) {
    }

    public void onWaitStart(int i) {
    }
}
