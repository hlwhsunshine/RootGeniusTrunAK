package com.shuame.rootgenius.p115ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.C1029c;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.C1033d;
import com.nostra13.universalimageloader.core.p066b.C1022b;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.manager.AppManager;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.p101b.C1321b;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.view.TextProgressBar;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.shuame.rootgenius.ui.adapter.b */
public class C1509b extends BaseAdapter {
    /* renamed from: a */
    private static final String f4295a = C1509b.class.getSimpleName();
    /* renamed from: b */
    private ArrayList<Item> f4296b;
    /* renamed from: c */
    private C1029c f4297c;
    /* renamed from: d */
    private ListView f4298d;
    /* renamed from: e */
    private HashMap<Integer, Item> f4299e;
    /* renamed from: f */
    private Properties f4300f = new Properties();
    /* renamed from: g */
    private C1324a f4301g = C1324a.m3722a(RootGeniusApp.m3523a());
    /* renamed from: h */
    private C1508b f4302h = new C1508b(this, (byte) 0);
    /* renamed from: i */
    private Handler f4303i = new Handler(new C1510c(this));
    /* renamed from: j */
    private C1320a f4304j = new C1511d(this);

    /* renamed from: com.shuame.rootgenius.ui.adapter.b$a */
    private class C1507a extends RelativeLayout {
        /* renamed from: a */
        public ImageView f4289a;
        /* renamed from: b */
        public TextView f4290b;
        /* renamed from: c */
        public TextView f4291c;
        /* renamed from: d */
        public TextProgressBar f4292d = ((TextProgressBar) findViewById(C1450R.id.tpb_progress));

        public C1507a(Context context) {
            super(context);
            View inflate = LayoutInflater.from(context).inflate(C1450R.layout.view_bbx_list_item, this);
            this.f4289a = (ImageView) inflate.findViewById(C1450R.id.iv_logo);
            this.f4290b = (TextView) inflate.findViewById(C1450R.id.tv_name);
            this.f4291c = (TextView) inflate.findViewById(C1450R.id.tv_description);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.adapter.b$b */
    private class C1508b implements OnClickListener {
        private C1508b() {
        }

        /* synthetic */ C1508b(C1509b c1509b, byte b) {
            this();
        }

        public final void onClick(View view) {
            C1509b.f4295a;
            Item item = (Item) view.getTag(C1450R.string.auto_boot_item_note_start);
            QQDownloadFile a = C1361b.m3817a().mo7068a(item.getTaskId());
            if (C1387ad.m3871b(item.packageName)) {
                C1387ad.m3868a(RootGeniusApp.m3523a(), item.packageName);
                C1509b.m4322a(a);
                C1509b.this.f4300f.clear();
                C1509b.this.f4300f.setProperty("StartAPP", "(外)打开" + item.displayName);
                C1509b.this.f4301g;
                C1324a.m3723a(item.cName, C1509b.this.f4300f);
                return;
            }
            TextProgressBar textProgressBar = (TextProgressBar) view;
            if (a != null) {
                C1509b.f4295a;
                new StringBuilder("downloadFile.status == ").append(a.f3719C).append("; downloadFile.path == ").append(a.f3725f);
                switch (C1512e.f4307a[a.f3719C.ordinal()]) {
                    case 1:
                    case 2:
                    case 8:
                        C1361b.m3817a().mo7073b(item.getTaskId());
                        return;
                    case 3:
                        C1509b.f4295a;
                        return;
                    case 4:
                    case 5:
                    case 6:
                        C1509b.m4326b(a);
                        return;
                    case 7:
                        C1509b.f4295a;
                        int taskId = item.getTaskId();
                        QQDownloadFile a2 = C1361b.m3817a().mo7068a(taskId);
                        String text = textProgressBar.getText();
                        if (text.equals(RootGeniusApp.m3523a().getString(C1450R.string.status_lanch))) {
                            if (C1387ad.m3868a(RootGeniusApp.m3523a(), a2.f3739t)) {
                                C1509b.m4322a(a2);
                                return;
                            }
                            textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
                            C1509b.m4318a((int) C1450R.string.list_status_download, true, textProgressBar);
                            return;
                        } else if (text.equals(RootGeniusApp.m3523a().getString(C1450R.string.status_install_pending))) {
                            AppManager.m3771a().mo7032a(taskId);
                            return;
                        } else if (!text.equals(RootGeniusApp.m3523a().getString(C1450R.string.list_status_download))) {
                            C1509b.f4295a;
                            return;
                        } else if (new File(a2.f3725f).exists()) {
                            AppManager.m3776a(a2);
                            return;
                        } else {
                            C1361b.m3817a().mo7076d(taskId);
                            a = item.toQQDownloadFile();
                            a.f3725f = C1397j.m3897a(a);
                            C1509b.m4326b(a);
                            C1509b.this.f4300f.clear();
                            C1509b.this.f4300f.setProperty("DownloadAPP", "(外)下载" + item.displayName);
                            C1509b.this.f4301g;
                            C1324a.m3723a(item.cName, C1509b.this.f4300f);
                            return;
                        }
                    default:
                        return;
                }
            }
            a = item.toQQDownloadFile();
            a.f3725f = C1397j.m3897a(a);
            C1509b.m4326b(a);
            C1509b.this.f4300f.clear();
            C1509b.this.f4300f.setProperty("DownloadAPP", "(外)下载" + item.displayName);
            C1509b.this.f4301g;
            C1324a.m3723a(item.cName, C1509b.this.f4300f);
        }
    }

    public C1509b(ListView listView) {
        this.f4298d = listView;
        this.f4299e = new HashMap();
        this.f4297c = new C1025a().mo6247a(true).mo6241a().mo6242a((int) C1450R.drawable.bbx_item_def_ico).mo6248b((int) C1450R.drawable.bbx_item_def_ico).mo6250c((int) C1450R.drawable.bbx_item_def_ico).mo6245a(new C1022b(20)).mo6249b();
    }

    /* renamed from: a */
    private static void m4318a(int i, boolean z, TextProgressBar textProgressBar) {
        if (textProgressBar != null) {
            if (C1450R.string.list_status_download == i) {
                textProgressBar.setText(RootGeniusApp.m3523a().getString(i));
            } else {
                textProgressBar.setText(i);
            }
            textProgressBar.setEnabled(z);
        }
    }

    /* renamed from: a */
    private static void m4320a(C1348b c1348b, TextProgressBar textProgressBar) {
        if (c1348b != null) {
            new StringBuilder("---install--initInstallStatus----status=").append(c1348b.f3679d);
            switch (C1512e.f4308b[c1348b.f3679d.ordinal()]) {
                case 1:
                    C1509b.m4318a((int) C1450R.string.status_install_pending, true, textProgressBar);
                    return;
                case 2:
                    C1509b.m4318a((int) C1450R.string.list_status_download, true, textProgressBar);
                    return;
                case 3:
                    C1509b.m4318a((int) C1450R.string.status_installing, false, textProgressBar);
                    return;
                case 4:
                    C1509b.m4318a((int) C1450R.string.list_status_download, true, textProgressBar);
                    return;
                case 5:
                    C1509b.m4318a((int) C1450R.string.status_installing, false, textProgressBar);
                    return;
                case 6:
                    C1509b.m4318a((int) C1450R.string.status_lanch, true, textProgressBar);
                    textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.selector_app_lanch_button));
                    return;
                case 7:
                    C1509b.m4318a((int) C1450R.string.list_status_download, true, textProgressBar);
                    return;
                case 8:
                    C1509b.m4318a((int) C1450R.string.list_status_download, true, textProgressBar);
                    return;
                case 9:
                    C1509b.m4318a((int) C1450R.string.status_lanch, true, textProgressBar);
                    textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.selector_app_lanch_button));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private static void m4321a(Status status, TextProgressBar textProgressBar, Item item) {
        if (textProgressBar != null) {
            new StringBuilder("initTextProgressBarByStatus = ").append(status);
            QQDownloadFile a = C1361b.m3817a().mo7068a(item.getTaskId());
            textProgressBar.setProgress(a.f3728i / 10);
            switch (C1512e.f4307a[a.f3719C.ordinal()]) {
                case 1:
                    C1509b.m4318a((int) C1450R.string.status_download_pending, true, textProgressBar);
                    textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                    return;
                case 2:
                    textProgressBar.setText(RootGeniusApp.m3523a().getString(C1450R.string.list_status_downloading, new Object[]{Integer.valueOf(a.f3728i / 10)}));
                    textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                    return;
                case 3:
                    C1509b.m4318a((int) C1450R.string.status_pausing, true, textProgressBar);
                    textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                    return;
                case 4:
                case 5:
                case 6:
                    C1509b.m4318a((int) C1450R.string.status_resume, true, textProgressBar);
                    textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.app_detail_progressbar));
                    return;
                case 7:
                    C1348b c1348b = (C1348b) AppManager.m3771a().f3689a.get(Integer.valueOf(a.f3722c));
                    if (c1348b != null) {
                        C1509b.m4320a(c1348b, textProgressBar);
                    } else if (C1387ad.m3871b(item.packageName)) {
                        C1509b.m4318a((int) C1450R.string.status_lanch, true, textProgressBar);
                        textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.selector_app_lanch_button));
                    } else if (new File(a.f3725f).exists()) {
                        C1509b.m4318a((int) C1450R.string.list_status_download, true, textProgressBar);
                    } else {
                        C1361b.m3817a().mo7076d(item.getTaskId());
                        C1509b.m4318a((int) C1450R.string.list_status_download, true, textProgressBar);
                    }
                    textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m4327b(C1509b c1509b, Message message, TextProgressBar textProgressBar) {
        if (textProgressBar != null) {
            C1348b c1348b = (C1348b) message.obj;
            new StringBuilder("---install--onStatusChanged----status=").append(c1348b.f3679d);
            c1509b.f4299e.get(Integer.valueOf(message.arg1));
            C1509b.m4320a(c1348b, textProgressBar);
        }
    }

    /* renamed from: a */
    public final void mo7411a() {
        C1321b.m3685a().mo6990a(this.f4304j);
    }

    /* renamed from: a */
    public final void mo7412a(ArrayList<Item> arrayList) {
        ArrayList arrayList2;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        this.f4296b = arrayList2;
        Iterator it = this.f4296b.iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            this.f4299e.put(Integer.valueOf(item.getTaskId()), item);
        }
    }

    /* renamed from: b */
    public final void mo7413b() {
        C1321b.m3685a().mo6991b(this.f4304j);
    }

    public int getCount() {
        return this.f4296b.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Item item = (Item) this.f4296b.get(i);
        if (view == null) {
            view = new C1507a(RootGeniusApp.m3523a());
        } else {
            C1507a c1507a = (C1507a) view;
        }
        view.f4290b.setText(item.displayName);
        view.f4291c.setText(item.description);
        C1033d.m2984a().mo6286a(item.iconUrl, view.f4289a, this.f4297c, null);
        TextProgressBar textProgressBar = view.f4292d;
        if (textProgressBar != null) {
            if (C1387ad.m3871b(item.packageName)) {
                C1509b.m4318a((int) C1450R.string.status_lanch, true, textProgressBar);
                textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.selector_app_lanch_button));
            } else {
                QQDownloadFile a = C1361b.m3817a().mo7068a(item.getTaskId());
                if (a != null) {
                    C1509b.m4321a(a.f3719C, textProgressBar, item);
                } else {
                    textProgressBar.setProgressDrawable(RootGeniusApp.m3523a().getResources().getDrawable(C1450R.drawable.selector_app_detail_button));
                    C1509b.m4318a((int) C1450R.string.list_status_download, true, textProgressBar);
                }
            }
        }
        view.f4292d.setOnClickListener(this.f4302h);
        view.f4292d.setTag(C1450R.string.auto_boot_item_note_start, item);
        view.f4292d.setTag(Integer.valueOf(item.getTaskId()));
        return view;
    }
}
