package com.shuame.rootgenius.p115ui.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.manager.AppManager;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.p101b.C1321b;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.homepage.listeners.IOptimizeItemListener;
import com.shuame.rootgenius.p115ui.view.OptimizeCircleProgressBar;
import com.shuame.rootgenius.pojo.OptimizeInfo;
import com.shuame.rootgenius.service.C1493k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.shuame.rootgenius.ui.adapter.n */
public class C1523n extends BaseAdapter {
    /* renamed from: a */
    private static final String f4331a = C1523n.class.getSimpleName();
    /* renamed from: b */
    private ListView f4332b;
    /* renamed from: c */
    private HashMap<Integer, OptimizeInfo> f4333c;
    /* renamed from: d */
    private ArrayList<OptimizeInfo> f4334d;
    /* renamed from: e */
    private HashMap<Integer, Boolean> f4335e;
    /* renamed from: f */
    private IOptimizeItemListener f4336f;
    /* renamed from: g */
    private C1521a f4337g = new C1521a(this, (byte) 0);
    /* renamed from: h */
    private Handler f4338h = new Handler(new C1524o(this));
    /* renamed from: i */
    private C1320a f4339i = new C1525p(this);

    /* renamed from: com.shuame.rootgenius.ui.adapter.n$a */
    private class C1521a implements OnClickListener {
        private C1521a() {
        }

        /* synthetic */ C1521a(C1523n c1523n, byte b) {
            this();
        }

        /* renamed from: a */
        private void m4335a(OptimizeInfo optimizeInfo) {
            if (optimizeInfo != null) {
                C1523n.f4331a;
                if (optimizeInfo.isOptimized) {
                    C1523n.this.m4340a(optimizeInfo.getTaskId()).mo7426c();
                    return;
                }
                QQDownloadFile a = C1361b.m3817a().mo7068a(optimizeInfo.getTaskId());
                if (a != null) {
                    C1523n.f4331a;
                    new StringBuilder("downloadFile.status == ").append(a.f3719C).append("; downloadFile.path == ").append(a.f3725f);
                    switch (C1526q.f4342a[a.f3719C.ordinal()]) {
                        case 1:
                        case 2:
                        case 8:
                            C1361b.m3817a().mo7073b(optimizeInfo.getTaskId());
                            return;
                        case 3:
                            C1523n.f4331a;
                            return;
                        case 4:
                        case 5:
                        case 6:
                            C1523n.m4347a(C1523n.this, a);
                            return;
                        case 7:
                            C1523n.f4331a;
                            a = C1361b.m3817a().mo7068a(optimizeInfo.getTaskId());
                            if (optimizeInfo.isOptimized) {
                                C1523n.this.m4340a(optimizeInfo.getTaskId()).mo7426c();
                                return;
                            } else if (new File(a.f3725f).exists()) {
                                AppManager.m3776a(a);
                                return;
                            } else {
                                C1361b.m3817a().mo7076d(optimizeInfo.getTaskId());
                                optimizeInfo.isOptimized = false;
                                C1523n.this.m4340a(optimizeInfo.getTaskId()).mo7424a();
                                return;
                            }
                        default:
                            return;
                    }
                }
                a = optimizeInfo.toQQDownloadFile();
                a.f3725f = C1397j.m3897a(a);
                C1523n.m4347a(C1523n.this, a);
            }
        }

        public final void onClick(View view) {
            C1523n.f4331a;
            OptimizeInfo b = C1523n.this.m4350b(((Integer) view.getTag()).intValue());
            if (b != null) {
                b.reportTriger = 2;
                m4335a(b);
            }
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.adapter.n$b */
    private class C1522b extends LinearLayout {
        /* renamed from: a */
        public TextView f4324a;
        /* renamed from: b */
        public TextView f4325b;
        /* renamed from: c */
        public Button f4326c;
        /* renamed from: d */
        public OptimizeCircleProgressBar f4327d = ((OptimizeCircleProgressBar) findViewById(C1450R.id.ocpb_progress));
        /* renamed from: e */
        public View f4328e;
        /* renamed from: f */
        public View f4329f;

        public C1522b(Context context) {
            super(context);
            View inflate = LayoutInflater.from(context).inflate(C1450R.layout.view_optimize_list_item, this);
            this.f4324a = (TextView) inflate.findViewById(C1450R.id.tv_appinfo);
            this.f4325b = (TextView) inflate.findViewById(C1450R.id.tv_description);
            this.f4326c = (Button) inflate.findViewById(C1450R.id.btn_download);
            this.f4328e = inflate.findViewById(C1450R.id.v_installing);
            this.f4329f = inflate.findViewById(C1450R.id.v_done);
        }

        /* renamed from: a */
        public final void mo7424a() {
            C1523n.f4331a;
            if (this.f4326c.getVisibility() != 0) {
                this.f4326c.setVisibility(0);
                this.f4327d.setVisibility(8);
                this.f4328e.setVisibility(8);
                this.f4329f.setVisibility(8);
            }
            if (getTag() != null) {
                C1523n.m4345a(C1523n.this, ((Integer) getTag()).intValue(), false);
            }
        }

        /* renamed from: b */
        public final void mo7425b() {
            C1523n.f4331a;
            if (this.f4327d.getVisibility() != 0) {
                this.f4326c.setVisibility(8);
                this.f4327d.setVisibility(0);
                this.f4328e.setVisibility(8);
                this.f4329f.setVisibility(8);
            }
            if (getTag() != null) {
                QQDownloadFile a = C1361b.m3817a().mo7068a(((Integer) getTag()).intValue());
                if (a == null) {
                    return;
                }
                if (a.f3719C == Status.PENDING || a.f3719C == Status.DOWNLOADING || a.f3719C == Status.FINISHED || a.f3719C == Status.VALIDATING) {
                    C1523n.m4345a(C1523n.this, ((Integer) getTag()).intValue(), true);
                } else {
                    C1523n.m4345a(C1523n.this, ((Integer) getTag()).intValue(), false);
                }
            }
        }

        /* renamed from: c */
        public final void mo7426c() {
            C1523n.f4331a;
            if (this.f4329f.getVisibility() != 0) {
                this.f4326c.setVisibility(8);
                this.f4327d.setVisibility(8);
                this.f4328e.setVisibility(8);
                this.f4329f.setVisibility(0);
            }
            if (getTag() != null) {
                int intValue = ((Integer) getTag()).intValue();
                C1523n.m4345a(C1523n.this, intValue, true);
                OptimizeInfo b = C1523n.this.m4350b(intValue);
                this.f4325b.setText(RootGeniusApp.m3523a().getResources().getString(C1450R.string.optimize_item_desc_text_prefix, new Object[]{b.appType}));
                this.f4324a.setVisibility(4);
            }
        }
    }

    public C1523n(ListView listView) {
        this.f4332b = listView;
        this.f4334d = C1493k.m4179a().mo7322c();
        this.f4333c = new HashMap();
        this.f4335e = new HashMap();
        Iterator it = this.f4334d.iterator();
        while (it.hasNext()) {
            OptimizeInfo optimizeInfo = (OptimizeInfo) it.next();
            this.f4333c.put(Integer.valueOf(optimizeInfo.getTaskId()), optimizeInfo);
            this.f4335e.put(Integer.valueOf(optimizeInfo.getTaskId()), Boolean.valueOf(optimizeInfo.isOptimized));
        }
    }

    /* renamed from: a */
    private C1522b m4340a(int i) {
        return (C1522b) this.f4332b.findViewWithTag(Integer.valueOf(i));
    }

    /* renamed from: a */
    private void m4344a(C1348b c1348b, C1522b c1522b) {
        if (c1348b != null) {
            OptimizeInfo b = m4350b(c1348b.f3676a);
            new StringBuilder("---install--initInstallStatus----status=").append(c1348b.f3679d);
            switch (C1526q.f4343b[c1348b.f3679d.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (c1522b.f4328e.getVisibility() != 0) {
                        c1522b.f4326c.setVisibility(8);
                        c1522b.f4327d.setVisibility(8);
                        c1522b.f4328e.setVisibility(0);
                        c1522b.f4329f.setVisibility(8);
                    }
                    if (c1522b.getTag() != null) {
                        C1523n.m4345a(C1523n.this, ((Integer) c1522b.getTag()).intValue(), true);
                        return;
                    }
                    return;
                case 4:
                case 5:
                    b.reportErrorCode = 2;
                    b.reportDesc = "安装失败---resultCode:" + c1348b.f3681f + "---app_path:" + c1348b.f3677b;
                    c1522b.mo7424a();
                    return;
                case 6:
                case 7:
                    b.reportErrorCode = 0;
                    b.reportDesc = null;
                    b = m4350b(c1348b.f3676a);
                    b.isOptimized = true;
                    c1522b.mo7426c();
                    if (this.f4336f != null) {
                        this.f4336f.onItemOptimized(b);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private static void m4348a(boolean z, OptimizeCircleProgressBar optimizeCircleProgressBar, OptimizeInfo optimizeInfo) {
        if (optimizeCircleProgressBar != null) {
            QQDownloadFile a = C1361b.m3817a().mo7068a(optimizeInfo.getTaskId());
            optimizeCircleProgressBar.setPaused(z);
            optimizeCircleProgressBar.setProgress(a.f3728i / 10);
        }
    }

    /* renamed from: b */
    private OptimizeInfo m4350b(int i) {
        return (OptimizeInfo) this.f4333c.get(Integer.valueOf(i));
    }

    /* renamed from: b */
    static /* synthetic */ void m4352b(C1523n c1523n, Message message, C1522b c1522b) {
        if (c1522b != null) {
            C1348b c1348b = (C1348b) message.obj;
            new StringBuilder("---install--onStatusChanged----status=").append(c1348b.f3679d);
            c1523n.m4344a(c1348b, c1522b);
        }
    }

    /* renamed from: e */
    private synchronized void m4354e() {
        boolean z = false;
        synchronized (this) {
            int size = this.f4334d.size();
            Iterator it = this.f4334d.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                boolean z2;
                OptimizeInfo optimizeInfo = (OptimizeInfo) it.next();
                if (((Boolean) this.f4335e.get(Integer.valueOf(optimizeInfo.getTaskId()))).booleanValue()) {
                    i2 = i + 1;
                    z2 = !optimizeInfo.isOptimized ? true : z;
                } else {
                    z2 = z;
                    i2 = i;
                }
                z = z2;
                i = i2;
            }
            this.f4336f.onOptimizedItemCountChanged(size, i, z);
        }
    }

    /* renamed from: a */
    public final void mo7427a() {
        Iterator it = this.f4334d.iterator();
        while (it.hasNext()) {
            OptimizeInfo optimizeInfo = (OptimizeInfo) it.next();
            if (!(((Boolean) this.f4335e.get(Integer.valueOf(optimizeInfo.getTaskId()))).booleanValue() || optimizeInfo == null)) {
                optimizeInfo.reportTriger = 1;
                this.f4337g.m4335a(optimizeInfo);
            }
        }
    }

    /* renamed from: a */
    public final void mo7428a(IOptimizeItemListener iOptimizeItemListener) {
        this.f4336f = iOptimizeItemListener;
    }

    /* renamed from: b */
    public final void mo7429b() {
        C1321b.m3685a().mo6990a(this.f4339i);
    }

    /* renamed from: c */
    public final void mo7430c() {
        C1321b.m3685a().mo6991b(this.f4339i);
    }

    public int getCount() {
        return this.f4334d.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        OptimizeInfo optimizeInfo = (OptimizeInfo) this.f4334d.get(i);
        C1522b c1522b = view == null ? new C1522b(RootGeniusApp.m3523a()) : (C1522b) view;
        c1522b.f4324a.setText(RootGeniusApp.m3523a().getResources().getString(C1450R.string.optimize_item_btn_text_prefix, new Object[]{optimizeInfo.appInfo}));
        c1522b.f4325b.setText(optimizeInfo.threatDesc);
        c1522b.f4326c.setText(optimizeInfo.btnText);
        c1522b.f4326c.setOnClickListener(this.f4337g);
        c1522b.f4326c.setTag(Integer.valueOf(optimizeInfo.getTaskId()));
        c1522b.f4327d.setOnClickListener(this.f4337g);
        c1522b.f4327d.setTag(Integer.valueOf(optimizeInfo.getTaskId()));
        c1522b.setTag(Integer.valueOf(optimizeInfo.getTaskId()));
        if (c1522b != null) {
            if (optimizeInfo.isOptimized) {
                c1522b.mo7426c();
            } else {
                QQDownloadFile a = C1361b.m3817a().mo7068a(optimizeInfo.getTaskId());
                if (a == null) {
                    c1522b.mo7424a();
                } else if (a.f3719C == Status.FINISHED) {
                    C1348b c1348b = (C1348b) AppManager.m3771a().f3689a.get(Integer.valueOf(a.f3722c));
                    if (c1348b != null) {
                        m4344a(c1348b, c1522b);
                    } else if (optimizeInfo.isOptimized) {
                        c1522b.mo7426c();
                    } else if (new File(a.f3725f).exists()) {
                        c1522b.mo7424a();
                    } else {
                        C1361b.m3817a().mo7076d(optimizeInfo.getTaskId());
                        optimizeInfo.isOptimized = false;
                        c1522b.mo7424a();
                    }
                } else {
                    c1522b.mo7424a();
                }
            }
        }
        return c1522b;
    }
}
