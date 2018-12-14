package com.shuame.rootgenius.p115ui.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.changefontmanager.sdk.ChangeFontManager;
import com.example.myfontsdk.C0446c;
import com.example.myfontsdk.C0454k;
import com.example.myfontsdk.Font;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.qqdownload.C1319h;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.shuame.rootgenius.common.util.C1411s;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.common.util.NetworkUtils.NetworkType;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.model.DownLoadFont;
import com.shuame.rootgenius.p110g.C1440c;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.p115ui.dialog.C1549b;
import com.shuame.rootgenius.p115ui.dialog.MyActivityDialog;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/* renamed from: com.shuame.rootgenius.ui.adapter.FontListAdapter */
public class FontListAdapter extends BaseAdapter implements C1319h {
    /* renamed from: e */
    private static final String f4272e = FontListAdapter.class.getSimpleName();
    /* renamed from: a */
    boolean f4273a = false;
    /* renamed from: b */
    Properties f4274b = new Properties();
    /* renamed from: c */
    C1324a f4275c = C1324a.m3722a(RootGeniusApp.m3523a());
    /* renamed from: d */
    BroadcastReceiver f4276d = new C1513f(this);
    /* renamed from: f */
    private ArrayList<Font> f4277f = new ArrayList();
    /* renamed from: g */
    private HashMap<Integer, Font> f4278g = new HashMap();
    /* renamed from: h */
    private Context f4279h;
    /* renamed from: i */
    private ListView f4280i;
    /* renamed from: j */
    private final Handler f4281j = new MyHandler();
    /* renamed from: k */
    private boolean f4282k;

    /* renamed from: com.shuame.rootgenius.ui.adapter.FontListAdapter$MyHandler */
    class MyHandler extends Handler implements Serializable {
        ViewHolder holder;
        int taskId;
        View view;

        MyHandler() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!C1455a.m4026a(false)) {
                        this.taskId = message.arg2;
                        this.view = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(this.taskId));
                        if (this.view != null) {
                            this.holder = (ViewHolder) this.view.getTag(C1450R.id.tag_font_holder);
                            this.holder.mDownLoadButton.setTextColor(Color.parseColor("#ffffff"));
                            this.holder.mDownLoadButton.setText(C1450R.string.text_btn_onekey_replace);
                            this.holder.mProgress.setVisibility(0);
                        }
                        C1440c.m3984a();
                        FontListAdapter.this.f4279h;
                        int c = C1440c.m3987c();
                        Intent intent = new Intent(FontListAdapter.this.f4279h, MyActivityDialog.class);
                        intent.putExtra("fontName", C1440c.m3984a().mo7174e());
                        if (c != 1) {
                            if (c == 0) {
                                intent.putExtra("type", 0);
                                FontListAdapter.this.f4279h.startActivity(intent);
                                break;
                            }
                        }
                        intent.putExtra("type", 1);
                        FontListAdapter.this.f4279h.startActivity(intent);
                        break;
                    }
                    break;
                case 2:
                    this.taskId = message.arg2;
                    this.view = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(this.taskId));
                    if (this.view != null) {
                        this.holder = (ViewHolder) this.view.getTag(C1450R.id.tag_font_holder);
                        FontListAdapter.m4308b(this.holder, (int) C1450R.string.font_download_error, Color.parseColor("#ff6d3c"), 100, (int) C1450R.string.text_btn_onekey_replace);
                        break;
                    }
                    break;
                case 3:
                    this.taskId = message.arg2;
                    this.view = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(this.taskId));
                    if (this.view != null) {
                        this.holder = (ViewHolder) this.view.getTag(C1450R.id.tag_font_holder);
                        if (!C1440c.m3984a().mo7169b()) {
                            FontListAdapter.m4308b(this.holder, (int) C1450R.string.downloaded_rom, -1, -1, (int) C1450R.string.text_waiting_replace_font);
                            break;
                        } else {
                            FontListAdapter.m4308b(this.holder, (int) C1450R.string.downloaded_rom, -1, -1, (int) C1450R.string.text_font_replaceing);
                            break;
                        }
                    }
                    break;
                case 4:
                    this.taskId = message.arg2;
                    this.view = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(this.taskId));
                    if (this.view != null) {
                        this.holder = (ViewHolder) this.view.getTag(C1450R.id.tag_font_holder);
                        FontListAdapter.m4308b(this.holder, -1, -1, message.arg1 / 10, (int) C1450R.string.text_downloading);
                        break;
                    }
                    break;
                case 5:
                    int intValue = ((Integer) message.obj).intValue();
                    if (C1440c.m3984a().mo7171c(intValue) != null) {
                        this.view = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(intValue));
                        if (this.view != null) {
                            this.holder = (ViewHolder) this.view.getTag(C1450R.id.tag_font_holder);
                        }
                        if (!C1440c.m3984a().mo7171c(intValue).mo7159d()) {
                            FontListAdapter.m4308b(this.holder, -1, -1, 100, (int) C1450R.string.text_waiting_replace_font);
                            break;
                        } else {
                            FontListAdapter.m4308b(this.holder, -1, -1, 100, (int) C1450R.string.text_font_replaceing);
                            break;
                        }
                    }
                    break;
                case 7:
                    this.taskId = message.arg2;
                    this.view = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(this.taskId));
                    if (this.view != null) {
                        this.holder = (ViewHolder) this.view.getTag(C1450R.id.tag_font_holder);
                        FontListAdapter.m4308b(this.holder, (int) C1450R.string.text_replace_error_font, Color.parseColor("#ff6d3c"), 100, (int) C1450R.string.text_btn_onekey_replace);
                        break;
                    }
                    break;
                case 8:
                    this.taskId = message.arg2;
                    this.view = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(this.taskId));
                    if (this.view != null) {
                        this.holder = (ViewHolder) this.view.getTag(C1450R.id.tag_font_holder);
                        this.holder.mDownLoadButton.setText(C1450R.string.text_font_replace_finish);
                        this.holder.mDownLoadButton.setTextColor(Color.parseColor("#4aaa00"));
                        this.holder.mProgress.setVisibility(4);
                        break;
                    }
                    break;
                case 9:
                    this.taskId = message.arg2;
                    this.view = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(this.taskId));
                    if (this.view != null) {
                        this.holder = (ViewHolder) this.view.getTag(C1450R.id.tag_font_holder);
                        FontListAdapter.m4308b(this.holder, -1, -1, 100, (int) C1450R.string.text_btn_onekey_replace);
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.adapter.FontListAdapter$ViewHolder */
    public static class ViewHolder implements Parcelable {
        Button mDownLoadButton;
        ProgressBar mProgress;
        TextView mTextFontSize;
        TextView mTextTitle;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
        }
    }

    /* renamed from: com.shuame.rootgenius.ui.adapter.FontListAdapter$a */
    public class C1504a implements OnClickListener {
        /* renamed from: b */
        private ViewHolder f4270b;
        /* renamed from: c */
        private Font f4271c;

        public C1504a(ViewHolder viewHolder, Font font) {
            this.f4270b = viewHolder;
            this.f4271c = font;
        }

        public final void onClick(View view) {
            if (!C1455a.m4025a()) {
                FontListAdapter.f4272e;
                int a = C1361b.m3815a(this.f4271c.getDownloadUr());
                if (!C1440c.m3984a().mo7170b(a)) {
                    if (C1323b.m3698d()) {
                        FontListAdapter.this.f4273a = true;
                    } else {
                        C1440c.m3984a().mo7163a(FontListAdapter.this.f4279h);
                        FontListAdapter.this.f4273a = false;
                    }
                    if (FontListAdapter.this.f4273a) {
                        View findViewWithTag = FontListAdapter.this.f4280i.findViewWithTag(Integer.valueOf(a));
                        FontListAdapter.f4272e;
                        new StringBuilder("onclick view taskId == ").append(a).append("; view == ").append(findViewWithTag);
                        QQDownloadFile a2 = C1361b.m3817a().mo7068a(a);
                        if (a2 == null) {
                            a2 = new DownLoadFont(this.f4271c.getDownloadUr(), this.f4271c.getFontSize(), C0446c.m988b() + C0454k.m992a(this.f4271c.getDownloadUr()) + ".apk", this.f4271c.getMD5()).toQQDownloadFile();
                        }
                        FontListAdapter.f4272e;
                        new StringBuilder("downloadFile.path:").append(a2.f3725f);
                        FontListAdapter.f4272e;
                        new StringBuilder("fileSize == ").append(a2.f3727h).append(" || AvailableSize == ").append(C1411s.m3926b(a2.f3725f));
                        FontListAdapter.this.f4274b.clear();
                        FontListAdapter.this.f4274b.setProperty("DownloadAPP", "下载(外):" + this.f4271c.getFontName());
                        C1324a c1324a = FontListAdapter.this.f4275c;
                        C1324a.m3723a("ChangeFont", FontListAdapter.this.f4274b);
                        if (a2.f3725f.startsWith("/font")) {
                            Object b = C1411s.m3928b(true);
                            if (TextUtils.isEmpty(b)) {
                                b = C1411s.m3923a(true);
                            }
                            if (TextUtils.isEmpty(b)) {
                                C1440c.m3984a().mo7173d(FontListAdapter.this.f4279h);
                                return;
                            }
                            a2.f3725f = C0446c.m988b() + C0454k.m992a(this.f4271c.getDownloadUr()) + ".apk";
                            if (a2.f3725f.startsWith("/font")) {
                                a2.f3725f = b + a2.f3725f;
                            }
                        }
                        FontListAdapter.f4272e;
                        new StringBuilder("downloadFile.status == ").append(a2.f3719C).append("; downloadFile.path == ").append(a2.f3725f);
                        if (a2.f3727h < C1411s.m3926b(a2.f3725f)) {
                            switch (C1518k.f4320a[a2.f3719C.ordinal()]) {
                                case 1:
                                case 2:
                                    C1361b.m3817a().mo7073b(a);
                                    FontListAdapter.m4308b(this.f4270b, -1, -1, 100, (int) C1450R.string.text_btn_onekey_replace);
                                    return;
                                case 3:
                                    C1361b.m3817a().mo7073b(a);
                                    FontListAdapter.m4308b(this.f4270b, -1, -1, 100, (int) C1450R.string.text_btn_onekey_replace);
                                    return;
                                case 4:
                                case 5:
                                case 6:
                                    if (FontListAdapter.m4305a(FontListAdapter.this, findViewWithTag, a2, this.f4271c)) {
                                        C1361b.m3817a().mo7067a(a2, null);
                                        this.f4270b.mTextFontSize.setText(((double) ((this.f4271c.getFontSize() / 1024) / 1024)) + "MB");
                                        this.f4270b.mTextFontSize.setTextColor(Color.parseColor("#666666"));
                                        this.f4270b.mProgress.setProgress(a2.f3728i / 10);
                                        if (a2.f3719C == Status.PENDING) {
                                            FontListAdapter.m4309b(this.f4270b, ((double) ((this.f4271c.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), a2.f3728i / 10, (int) C1450R.string.text_pending);
                                            return;
                                        } else {
                                            FontListAdapter.m4309b(this.f4270b, ((double) ((this.f4271c.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), a2.f3728i / 10, (int) C1450R.string.text_downloading);
                                            return;
                                        }
                                    }
                                    return;
                                case 8:
                                    C1440c.m3984a().mo7164a(FontListAdapter.this.f4281j);
                                    ChangeFontManager.getInstance().checkPhoneType(FontListAdapter.this.f4279h);
                                    C1440c.m3984a();
                                    if (C1440c.m3988d()) {
                                        Intent intent = new Intent(FontListAdapter.this.f4279h, MyActivityDialog.class);
                                        intent.putExtra("type", 2);
                                        intent.putExtra("taskId", a);
                                        intent.putExtra("font", this.f4271c);
                                        FontListAdapter.this.f4279h.startActivity(intent);
                                        return;
                                    }
                                    C1440c.m3984a().mo7165a(this.f4271c, a);
                                    if (C1440c.m3984a().mo7171c(a).mo7159d()) {
                                        FontListAdapter.m4308b(this.f4270b, -1, -1, -1, (int) C1450R.string.text_font_replaceing);
                                        return;
                                    } else {
                                        FontListAdapter.m4308b(this.f4270b, -1, -1, -1, (int) C1450R.string.text_waiting_replace_font);
                                        return;
                                    }
                                default:
                                    if (FontListAdapter.m4305a(FontListAdapter.this, findViewWithTag, a2, this.f4271c)) {
                                        C1361b.m3817a().mo7067a(a2, null);
                                        this.f4270b.mTextFontSize.setText(((double) ((this.f4271c.getFontSize() / 1024) / 1024)) + "MB");
                                        this.f4270b.mTextFontSize.setTextColor(Color.parseColor("#666666"));
                                        this.f4270b.mProgress.setProgress(a2.f3728i / 10);
                                        if (a2.f3719C == Status.PENDING) {
                                            FontListAdapter.m4309b(this.f4270b, ((double) ((this.f4271c.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), a2.f3728i / 10, (int) C1450R.string.text_pending);
                                            return;
                                        } else {
                                            FontListAdapter.m4309b(this.f4270b, ((double) ((this.f4271c.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), a2.f3728i / 10, (int) C1450R.string.text_downloading);
                                            return;
                                        }
                                    }
                                    return;
                            }
                        } else if (C1411s.m3922a(a2.f3725f) == -1) {
                            C1440c.m3984a().mo7173d(FontListAdapter.this.f4279h);
                        } else {
                            C1440c.m3984a().mo7172c(FontListAdapter.this.f4279h);
                        }
                    }
                } else if (!C1440c.m3984a().mo7171c(a).mo7159d()) {
                    C1440c.m3984a().mo7166a(C1440c.m3984a().mo7171c(a));
                    C1440c.m3984a().mo7162a(a);
                    this.f4270b.mDownLoadButton.setText(C1450R.string.text_btn_onekey_replace);
                }
            }
        }
    }

    public FontListAdapter(Context context, ListView listView) {
        this.f4279h = context;
        this.f4280i = listView;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(this.f4276d, intentFilter);
    }

    /* renamed from: a */
    private void m4301a(int i, int i2, int i3) {
        Message obtainMessage = this.f4281j.obtainMessage(i);
        obtainMessage.arg1 = i2;
        obtainMessage.arg2 = i3;
        this.f4281j.sendMessageDelayed(obtainMessage, 0);
    }

    /* renamed from: a */
    private boolean m4304a(Font font, TextView textView) {
        if (new File(font.getThumbnailLocalPath()).exists()) {
            try {
                textView.setTypeface(Typeface.createFromFile(font.getThumbnailLocalPath()));
                textView.setText(font.getFontName());
            } catch (Exception e) {
                e.printStackTrace();
                textView.setTypeface(Typeface.DEFAULT);
            }
            return true;
        }
        textView.setTypeface(Typeface.DEFAULT);
        C0446c.m984a(new C1517j(this, textView), font);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m4305a(FontListAdapter fontListAdapter, View view, QQDownloadFile qQDownloadFile, Font font) {
        NetworkType c = NetworkUtils.m3853c();
        if (c == NetworkType.NONE) {
            C1440c.m3984a().mo7168b(fontListAdapter.f4279h);
            return false;
        } else if (c != NetworkType.MOBILE) {
            return true;
        } else {
            C1549b c1549b = new C1549b(fontListAdapter.f4279h);
            c1549b.mo7449a(C1450R.string.alert_dialog_msg_download_mobile_network);
            c1549b.mo7450a(C1450R.string.alert_dialog_cancel, new C1514g(fontListAdapter, c1549b));
            c1549b.mo7451b(C1450R.string.update_all_app_resum, new C1515h(fontListAdapter, qQDownloadFile, view, font, c1549b));
            c1549b.show();
            return false;
        }
    }

    /* renamed from: b */
    private static void m4308b(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        if (i != -1) {
            viewHolder.mTextFontSize.setText(i);
        }
        if (i2 != -1) {
            viewHolder.mTextFontSize.setTextColor(i2);
        }
        if (i3 != -1) {
            viewHolder.mProgress.setProgress(i3);
        }
        if (i4 != -1) {
            viewHolder.mDownLoadButton.setText(i4);
        }
    }

    /* renamed from: b */
    private static void m4309b(ViewHolder viewHolder, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence != null) {
            viewHolder.mTextFontSize.setText(charSequence);
        }
        if (i != -1) {
            viewHolder.mTextFontSize.setTextColor(i);
        }
        if (i2 != -1) {
            viewHolder.mProgress.setProgress(i2);
        }
        if (i3 != -1) {
            viewHolder.mDownLoadButton.setText(i3);
        }
    }

    /* renamed from: a */
    public final void mo7397a() {
        this.f4279h.unregisterReceiver(this.f4276d);
    }

    /* renamed from: a */
    public final void mo7398a(List<Font> list) {
        if (list != null) {
            this.f4277f = (ArrayList) list;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f4277f.size()) {
                    this.f4278g.put(Integer.valueOf(C1361b.m3815a(((Font) list.get(i2)).getDownloadUr())), list.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
        this.f4277f.clear();
    }

    /* renamed from: a */
    public final void mo7399a(boolean z) {
        this.f4282k = z;
    }

    public int getCount() {
        return this.f4277f.size();
    }

    public Object getItem(int i) {
        return this.f4277f.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Font font = (Font) this.f4277f.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f4279h).inflate(C1450R.layout.font_listitem, null);
            ViewHolder viewHolder2 = new ViewHolder();
            viewHolder2.mTextTitle = (TextView) view.findViewById(C1450R.id.font_name);
            viewHolder2.mDownLoadButton = (Button) view.findViewById(C1450R.id.use);
            viewHolder2.mTextFontSize = (TextView) view.findViewById(C1450R.id.font_size);
            viewHolder2.mProgress = (ProgressBar) view.findViewById(C1450R.id.progress);
            view.setTag(C1450R.id.tag_font_holder, viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag(C1450R.id.tag_font_holder);
        }
        Object fontName = font.getFontName();
        viewHolder.mTextTitle.setText(fontName);
        m4304a(font, viewHolder.mTextTitle);
        int a = C1361b.m3815a(font.getDownloadUr());
        view.setTag(Integer.valueOf(a));
        QQDownloadFile a2 = C1361b.m3817a().mo7068a(a);
        if (a2 != null) {
            new StringBuilder("font name == ").append(fontName).append("; downloadFile.status == ").append(a2.f3719C);
            switch (C1518k.f4320a[a2.f3719C.ordinal()]) {
                case 1:
                case 2:
                    FontListAdapter.m4309b(viewHolder, ((double) ((font.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), a2.f3728i / 10, (int) C1450R.string.text_downloading);
                    C1361b.m3817a().mo7067a(a2, null);
                    break;
                case 3:
                    FontListAdapter.m4309b(viewHolder, ((double) ((font.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), a2.f3728i / 10, (int) C1450R.string.text_pending);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    FontListAdapter.m4309b(viewHolder, ((double) ((font.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), 100, (int) C1450R.string.text_btn_onekey_replace);
                    break;
                case 8:
                    if (C1440c.m3984a().mo7170b(a)) {
                        if (!C1440c.m3984a().mo7171c(a).mo7159d()) {
                            FontListAdapter.m4308b(viewHolder, (int) C1450R.string.text_downloaded, Color.parseColor("#666666"), 100, (int) C1450R.string.text_waiting_replace_font);
                            break;
                        }
                        FontListAdapter.m4308b(viewHolder, (int) C1450R.string.text_downloaded, Color.parseColor("#666666"), 100, (int) C1450R.string.text_font_replaceing);
                        break;
                    }
                    FontListAdapter.m4308b(viewHolder, (int) C1450R.string.text_downloaded, Color.parseColor("#666666"), 100, (int) C1450R.string.text_btn_onekey_replace);
                    break;
            }
        }
        FontListAdapter.m4309b(viewHolder, ((double) ((font.getFontSize() / 1024) / 1024)) + "MB", Color.parseColor("#666666"), 100, (int) C1450R.string.text_btn_onekey_replace);
        viewHolder.mDownLoadButton.setOnClickListener(new C1504a(viewHolder, font));
        return view;
    }

    public void onComplete(int i, long j) {
        Font font = (Font) this.f4278g.get(Integer.valueOf(i));
        if (C1361b.m3817a().mo7068a(i).f3734o != Type.FONT) {
            return;
        }
        if (j == 0) {
            m4301a(3, 0, i);
            C0446c.m983a(font);
            C1440c.m3984a().mo7164a(this.f4281j);
            if (!C1440c.m3984a().mo7170b(i) && this.f4282k) {
                ChangeFontManager.getInstance().checkPhoneType(this.f4279h);
                C1440c.m3984a();
                if (C1440c.m3988d()) {
                    Intent intent = new Intent(this.f4279h, MyActivityDialog.class);
                    intent.putExtra("type", 2);
                    intent.putExtra("taskId", i);
                    intent.putExtra("font", font);
                    this.f4279h.startActivity(intent);
                    return;
                }
                this.f4279h.getSharedPreferences("pack", 0).edit().putString("name", this.f4279h.getPackageManager().getPackageArchiveInfo(C0446c.m988b() + C0454k.m992a(font.getDownloadUr()) + ".apk", 1).packageName).commit();
                C1440c.m3984a().mo7165a(font, i);
            }
        } else if (j == 1) {
            m4301a(9, 0, i);
        } else {
            m4301a(2, 0, i);
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

    public void onStorageErrorInfo(int i, int i2, String str) {
    }

    public void onTaskInfo(int i, int i2, int i3) {
        QQDownloadFile a = C1361b.m3817a().mo7068a(i);
        if (a != null && a.f3734o == Type.FONT) {
            m4301a(4, i2, i);
        }
    }

    public void onWaitStart(int i) {
    }
}
