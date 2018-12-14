package com.baidu.mobads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.p015v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.baidu.mobads.command.C0271a;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.openad.p029c.C0359b;
import com.baidu.mobads.openad.p029c.C0361d;
import com.baidu.mobads.p021j.C0329d;
import com.baidu.mobads.p021j.C0336j;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p033g.C0286a;
import com.baidu.mobads.p033g.C0291d;
import com.baidu.mobads.p040vo.p050a.C0435c;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppActivity extends Activity {
    protected static final int ACTIONBAR_VIEW_ID = 1001;
    public static final String EXTRA_DATA = "EXTRA_DATA";
    /* renamed from: G */
    private static int f155G = 39;
    /* renamed from: J */
    private static ActionBarColorTheme f156J = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    /* renamed from: o */
    private static final String f157o = AppActivity.class.getSimpleName();
    /* renamed from: p */
    private static AtomicBoolean f158p = new AtomicBoolean(false);
    /* renamed from: A */
    private C0435c f159A;
    /* renamed from: B */
    private XAdLandingPageExtraInfo f160B;
    /* renamed from: C */
    private View f161C;
    /* renamed from: D */
    private final IXAdLogger f162D = C0338m.m569a().mo5033f();
    /* renamed from: E */
    private IXAdCommonUtils f163E;
    /* renamed from: F */
    private boolean f164F = true;
    /* renamed from: H */
    private PageFinishedListener f165H;
    /* renamed from: I */
    private boolean f166I = true;
    /* renamed from: a */
    float f167a = 1.0f;
    public Handler actionBarHandler;
    /* renamed from: b */
    float f168b = 1.0f;
    /* renamed from: c */
    C0286a f169c = null;
    public C0246ac curWebview;
    /* renamed from: d */
    RelativeLayout f170d;
    /* renamed from: e */
    int f171e = 0;
    /* renamed from: f */
    int f172f = 0;
    /* renamed from: g */
    int f173g = -1;
    /* renamed from: h */
    int f174h = 0;
    /* renamed from: i */
    int f175i = 0;
    /* renamed from: j */
    int f176j = 1;
    /* renamed from: k */
    String f177k = "barC";
    /* renamed from: l */
    String f178l = "";
    /* renamed from: m */
    View f179m = null;
    protected C0291d mBottomView;
    protected boolean mBottomViewIsShowing = false;
    /* renamed from: n */
    HandlerThread f180n = new HandlerThread("handler_thread");
    /* renamed from: q */
    private Handler f181q = null;
    /* renamed from: r */
    private int f182r = 0;
    /* renamed from: s */
    private long f183s = 0;
    /* renamed from: t */
    private String f184t;
    /* renamed from: u */
    private boolean f185u = false;
    /* renamed from: v */
    private int f186v = 1;
    /* renamed from: w */
    private int f187w = 0;
    /* renamed from: x */
    private int f188x = -1;
    /* renamed from: y */
    private boolean f189y = false;
    /* renamed from: z */
    private boolean f190z = false;

    public static class ActionBarColorTheme {
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
        /* renamed from: a */
        private int f191a;
        /* renamed from: b */
        private int f192b;
        /* renamed from: c */
        private int f193c;
        /* renamed from: d */
        private int f194d;

        public ActionBarColorTheme(int i, int i2, int i3, int i4) {
            this.f191a = i;
            this.f192b = i2;
            this.f193c = i3;
            this.f194d = i4;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.f191a = actionBarColorTheme.f191a;
            this.f192b = actionBarColorTheme.f192b;
            this.f193c = actionBarColorTheme.f193c;
            this.f194d = actionBarColorTheme.f194d;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return this.f194d == actionBarColorTheme.f194d && this.f192b == actionBarColorTheme.f192b && this.f191a == actionBarColorTheme.f191a && this.f193c == actionBarColorTheme.f193c;
        }

        public int getBackgroundColor() {
            return this.f194d;
        }

        public int getCloseColor() {
            return this.f191a;
        }

        public int getProgressColor() {
            return this.f193c;
        }

        public int getTitleColor() {
            return this.f192b;
        }

        public void setBackgroundColor(int i) {
            this.f194d = i;
        }

        public void setCloseColor(int i) {
            this.f191a = i;
        }

        public void setProgressColor(int i) {
            this.f193c = i;
        }

        public void setTitleColor(int i) {
            this.f192b = i;
        }
    }

    public interface PageFinishedListener {
        void onPageFinished(WebView webView);
    }

    /* renamed from: com.baidu.mobads.AppActivity$a */
    class C0222a extends View {
        /* renamed from: b */
        private Paint f196b = new Paint();
        /* renamed from: c */
        private int f197c = 0;
        /* renamed from: d */
        private int f198d = 0;

        public C0222a(Context context) {
            super(context);
            this.f196b.setColor(AppActivity.f156J.getProgressColor());
            this.f198d = AppActivity.this.f163E.getScreenRect(AppActivity.this.getApplicationContext()).width();
        }

        /* renamed from: a */
        public void mo4054a(int i) {
            if (i != this.f197c) {
                this.f197c = i;
                postInvalidate();
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, (float) ((this.f198d * this.f197c) / 100), (float) getLayoutParams().height, this.f196b);
        }
    }

    /* renamed from: com.baidu.mobads.AppActivity$b */
    class C0223b {
        /* renamed from: a */
        boolean f199a = false;
        /* renamed from: b */
        String f200b = "";
        /* renamed from: c */
        boolean f201c = false;
        /* renamed from: d */
        boolean f202d = true;

        C0223b() {
        }
    }

    @TargetApi(3)
    /* renamed from: a */
    private RelativeLayout m209a(String str) {
        View c0222a = new C0222a(this);
        this.curWebview = new C0246ac(this, true, true);
        C0223b c0223b = new C0223b();
        this.curWebview.f399a = str;
        this.curWebview.getSettings().setUseWideViewPort(true);
        this.curWebview.getSettings().setBuiltInZoomControls(true);
        try {
            WebSettings.class.getMethod("setDisplayZoomControls", new Class[]{Boolean.TYPE}).invoke(this.curWebview.getSettings(), new Object[]{Boolean.valueOf(false)});
        } catch (Exception e) {
            this.f162D.mo4922d(f157o, e.getMessage());
        }
        this.curWebview.setWebChromeClient(new C0277d(this, c0222a));
        this.curWebview.setOnTouchListener(new C0325i(this));
        this.curWebview.setWebViewClient(new C0345j(this, c0223b));
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f179m = m227d();
        relativeLayout.addView(this.f179m);
        relativeLayout.addView(this.curWebview, new LayoutParams(-1, -1));
        relativeLayout.addView(c0222a, new LayoutParams(-1, this.f163E.getPixel(getApplicationContext(), 2)));
        return relativeLayout;
    }

    @TargetApi(12)
    /* renamed from: a */
    private void m212a(View view) {
        try {
            view.animate().setDuration(700);
            view.setTranslationX((float) view.getWidth());
            view.animate().setDuration(700).translationX(0.0f);
        } catch (Throwable e) {
            this.f162D.mo4928e(e);
        }
    }

    /* renamed from: a */
    private void m213a(WebView webView, String str, Runnable runnable, Runnable runnable2) {
        try {
            C0329d m = C0338m.m569a().mo5040m();
            if (this.f164F ? C0246ac.m311a(str) : C0246ac.m313b(str)) {
                Intent intent;
                if (C0246ac.m321i(str)) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(str), "audio/*");
                    webView.getContext().startActivity(intent);
                } else if (C0246ac.m320h(str)) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(str), "video/*");
                    webView.getContext().startActivity(intent);
                } else {
                    m.browserOutside(webView.getContext(), str);
                }
                if (runnable != null) {
                    runnable.run();
                }
            } else if (runnable2 != null) {
                runnable2.run();
            }
        } catch (Exception e) {
            this.f162D.mo4922d(f157o, e.getMessage());
        }
    }

    /* renamed from: a */
    private void m214a(WebView webView, String str, boolean z, String str2) {
        if (webView != null) {
            C0329d m = C0338m.m569a().mo5040m();
            if (this.f190z) {
                this.f172f++;
                this.f159A.f1085r.decrementAndGet();
                this.f190z = false;
            }
            if (z && str2.equals("ignore")) {
                try {
                    this.curWebview.loadUrl(str);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            try {
                Map hashMap = new HashMap();
                if (str2.equals("ignore")) {
                    hashMap.put("Referer", "http://mobads.baidu.com/" + m.getAppPackage(this));
                } else {
                    hashMap.put("Referer", str2);
                }
                this.curWebview.getClass().getMethod("loadUrl", new Class[]{String.class, Map.class}).invoke(this.curWebview, new Object[]{str, hashMap});
            } catch (Exception e2) {
                try {
                    this.curWebview.loadUrl(str);
                } catch (Exception e3) {
                    this.f162D.mo4922d(f157o, e2.getMessage());
                }
            }
        }
    }

    /* renamed from: b */
    private void m220b(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable e) {
                this.f162D.mo4928e(e);
            }
        }
    }

    /* renamed from: b */
    private void m223b(String str) {
        this.f170d = new RelativeLayout(this);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, C0338m.m569a().mo5040m().getPixel(this, 46));
        layoutParams.addRule(10);
        this.f169c.setId(1001);
        this.f170d.addView(this.f169c, layoutParams);
        View a = m209a(str);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        layoutParams2.addRule(3, 1001);
        this.f170d.addView(a, layoutParams2);
        if (this.f185u && canSupportAnimate()) {
            this.f170d.getViewTreeObserver().addOnPreDrawListener(new C0374p(this));
        }
    }

    /* renamed from: d */
    private View m227d() {
        View c0248ae = new C0248ae(this);
        int pixel = C0338m.m569a().mo5040m().getPixel(this, 38);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(pixel, pixel);
        layoutParams.addRule(13);
        c0248ae.setLayoutParams(layoutParams);
        return c0248ae;
    }

    /* renamed from: e */
    private void m229e() {
        m232f();
        initBottomView();
        this.f170d.addView(this.f161C);
        this.f170d.addView(this.mBottomView);
        if (canSupportAnimate()) {
            this.mBottomView.getViewTreeObserver().addOnPreDrawListener(new C0428r(this));
        }
    }

    @TargetApi(11)
    /* renamed from: f */
    private void m232f() {
        this.f161C = new View(this);
        this.f161C.setOnClickListener(new C0429s(this));
        if (canSupportAnimate()) {
            this.f161C.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.f161C.setAlpha(0.0f);
        }
        this.f161C.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    /* renamed from: g */
    private void m234g() {
        if (this.curWebview != null) {
            this.curWebview.reload();
        }
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return f156J;
    }

    @TargetApi(16)
    /* renamed from: h */
    private void m236h() {
        if (canSupportAnimate()) {
            try {
                View view = this.f170d;
                if (this.f185u) {
                    view.setTranslationX(0.0f);
                    ViewPropertyAnimator translationX = view.animate().setDuration(300).translationX((float) view.getWidth());
                    if (VERSION.SDK_INT >= 16) {
                        translationX.withEndAction(new C0281f(this));
                        return;
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new C0295g(this), 300);
                        return;
                    }
                }
                finish();
                return;
            } catch (Throwable e) {
                this.f162D.mo4928e(e);
                return;
            }
        }
        finish();
    }

    /* renamed from: i */
    private void m238i() {
        if (this.f179m != null) {
            m220b(this.f179m);
            this.f179m = null;
        }
    }

    public static boolean isAppActivityOpening() {
        return f158p.get();
    }

    /* renamed from: j */
    private int m239j() {
        try {
            Method method = Context.class.getMethod("getThemeResId", new Class[0]);
            method.setAccessible(true);
            return ((Integer) method.invoke(this, new Object[0])).intValue();
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
            return -1;
        }
    }

    /* renamed from: k */
    private boolean m242k() {
        try {
            return 16973840 == m239j();
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
            return false;
        }
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            f156J = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    protected boolean canSupportAnimate() {
        try {
            return VERSION.SDK_INT >= 12;
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
            return false;
        }
    }

    @TargetApi(11)
    protected void copyCurrentPageUrl() {
        if (VERSION.SDK_INT < 11) {
            Toast.makeText(this, "系统版本不支持", 0).show();
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.curWebview.getUrl())) {
                ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("网页链接", this.curWebview.getUrl()));
                Toast.makeText(this, "已复制到剪切板", 0).show();
            }
        } catch (Throwable e) {
            this.f162D.mo4928e(e);
        }
    }

    protected void initActionBar() {
        this.f169c = new C0286a(this, f156J);
        this.f169c.setId(1001);
        this.f169c.mo4465a(new C0427q(this));
    }

    @TargetApi(11)
    protected void initBottomView() {
        this.mBottomView = new C0291d(this);
        this.mBottomView.mo4474a(new C0430t(this));
        if (canSupportAnimate()) {
            this.mBottomView.setAlpha(0.0f);
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mBottomView.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f158p.set(true);
        this.f185u = m242k();
        this.f163E = C0338m.m569a().mo5040m();
        Intent intent = getIntent();
        String stringExtra;
        if (intent.getBooleanExtra("dealWithDownload", false)) {
            try {
                int intExtra = intent.getIntExtra("status", -1);
                String stringExtra2 = intent.getStringExtra(IXAdRequestInfo.PACKAGE);
                IOAdDownloader adsApkDownloader = C0361d.m637a(getApplicationContext()).getAdsApkDownloader(stringExtra2);
                this.f162D.mo4922d(f157o, "dealWithDownload now: status=" + intExtra + ";pk=" + stringExtra2 + ";downloader=" + adsApkDownloader);
                if (intExtra == DownloadStatus.COMPLETED.getCode()) {
                    stringExtra = intent.getStringExtra("localApkPath");
                    if (C0338m.m569a().mo5039l().isInstalled(this, stringExtra2)) {
                        C0338m.m569a().mo5039l().openApp(this, stringExtra2);
                    } else {
                        File file = new File(stringExtra);
                        if (!file.exists() || file.length() <= 0) {
                            this.f162D.mo4931i(f157o, "文件[" + stringExtra + "] 已经被删除");
                        } else {
                            startActivity(C0338m.m569a().mo5039l().getInstallIntent(stringExtra));
                        }
                    }
                } else if (intExtra == DownloadStatus.ERROR.getCode() || intExtra == DownloadStatus.PAUSED.getCode()) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 0) {
                        C0359b a = C0359b.m626a(stringExtra2);
                        if (a != null) {
                            C0271a a2 = a.mo5083a();
                            if (a2 != null) {
                                a2.f481r = true;
                            }
                        }
                    }
                    if (adsApkDownloader != null) {
                        adsApkDownloader.resume();
                    }
                }
            } catch (Throwable e) {
                this.f162D.mo4923d(f157o, e);
            }
            finish();
            return;
        }
        this.f164F = intent.getBooleanExtra("canOpenAppForAPO", this.f164F);
        C0329d m = C0338m.m569a().mo5040m();
        this.f160B = (XAdLandingPageExtraInfo) getIntent().getParcelableExtra(EXTRA_DATA);
        this.f159A = new C0435c(this.f160B);
        Rect windowRect = m.getWindowRect(this);
        this.f168b = (float) ((((double) windowRect.width()) * 1.0d) / 640.0d);
        this.f167a = (float) ((((double) windowRect.height()) * 1.0d) / 960.0d);
        requestWindowFeature(1);
        this.f184t = this.f160B.title;
        if (this.f160B.orientation == 1) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        this.f183s = System.currentTimeMillis();
        try {
            if (this.f160B.isFullScreen) {
                getWindow().setFlags(1024, 1024);
            }
        } catch (Exception e2) {
            this.f162D.mo4922d(f157o, "exception when getIntent");
        }
        this.f171e = this.f160B.from;
        stringExtra = this.f160B.url;
        if (C0246ac.m311a(stringExtra)) {
            this.f162D.mo4922d(f157o, "AppActivity.browser external");
            Intent intent2;
            if (C0246ac.m321i(stringExtra)) {
                intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse(stringExtra), "audio/*");
                startActivity(intent2);
            } else if (C0246ac.m320h(stringExtra)) {
                intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse(stringExtra), "video/*");
                startActivity(intent2);
            } else {
                m.browserOutside(this, stringExtra);
            }
            finish();
            return;
        }
        this.f181q = startUrlHandler(this);
        initActionBar();
        m223b(stringExtra);
        m214a(this.curWebview, stringExtra, false, "http://mobads.baidu.com/" + m.getAppPackage(this));
        this.f170d.setBackgroundColor(-1);
        setContentView(this.f170d);
    }

    public void onDestroy() {
        int i = 0;
        super.onDestroy();
        f158p.set(false);
        if (this.f181q != null) {
            this.f159A.f1081n = this.f177k;
            C0435c c0435c = this.f159A;
            int i2 = this.f182r;
            this.f182r = i2 + 1;
            c0435c.f1082o = i2;
            this.f159A.f1083p = this.curWebview != null ? this.curWebview.getContentHeight() : 0;
            c0435c = this.f159A;
            if (this.curWebview != null) {
                i = this.curWebview.getProgress();
            }
            c0435c.f1084q = i;
            this.f159A.f1086s = this.f172f;
            this.f159A.f1087t = this.f173g;
            this.f159A.f1088u = System.currentTimeMillis() - this.f183s;
            this.f159A.f1089v = this.f186v;
            this.f159A.f1090w = this.f187w;
            this.f159A.f1091x = this.f171e;
            this.f159A.f1092y = this.f176j;
            Message obtain = Message.obtain();
            obtain.what = f155G;
            obtain.obj = this.f159A;
            this.f181q.sendMessage(obtain);
            try {
                this.curWebview.setVisibility(8);
                this.f162D.mo4922d(f157o, "onDestroy");
                this.curWebview.stopLoading();
                this.curWebview.destroy();
            } catch (Exception e) {
                this.f162D.mo4922d(f157o, e.getMessage());
            }
        }
        m238i();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.mBottomViewIsShowing) {
                    runBottomViewExitAnimation(this.f161C, this.mBottomView);
                } else if (this.curWebview.canGoBack()) {
                    this.curWebview.goBack();
                } else {
                    this.f177k = "backC";
                    m236h();
                }
                C0435c c0435c = this.f159A;
                c0435c.f1079G++;
                return true;
            } catch (Exception e) {
                this.f162D.mo4922d(f157o, e.getMessage());
            }
        } else {
            if (i == 46) {
                this.curWebview.reload();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.f166I) {
            this.f166I = false;
            return;
        }
        C0435c c0435c = this.f159A;
        c0435c.f1080H++;
    }

    @TargetApi(12)
    protected void runBottomViewEnterAnimation(View view, View view2) {
        this.mBottomViewIsShowing = true;
        try {
            view.animate().setDuration(500).alpha(0.5f);
            view2.setTranslationY((float) view2.getHeight());
            view2.animate().setDuration(500).alpha(1.0f).translationY(0.0f);
        } catch (Throwable e) {
            this.f162D.mo4928e(e);
        }
    }

    @TargetApi(16)
    protected void runBottomViewExitAnimation(View view, View view2) {
        this.mBottomViewIsShowing = false;
        if (canSupportAnimate()) {
            try {
                view.clearAnimation();
                view.animate().setDuration(250).alpha(0.0f);
                view2.setTranslationY(0.0f);
                ViewPropertyAnimator translationY = view2.animate().setDuration(250).alpha(0.0f).translationY((float) view2.getHeight());
                if (VERSION.SDK_INT >= 16) {
                    translationY.withEndAction(new C0431u(this, view2, view));
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new C0279e(this, view2, view), 250);
                    return;
                }
            } catch (Throwable e) {
                this.f162D.mo4928e(e);
                return;
            }
        }
        m220b(view2);
        m220b(view);
    }

    public void setPageFinishedListener(PageFinishedListener pageFinishedListener) {
        this.f165H = pageFinishedListener;
    }

    public Handler startUrlHandler(Context context) {
        this.f180n.start();
        return new C0320h(this, this.f180n.getLooper());
    }
}
