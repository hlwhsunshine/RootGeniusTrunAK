package com.shuame.rootgenius.p115ui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.example.myfontsdk.Font;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p110g.C1440c;

/* renamed from: com.shuame.rootgenius.ui.dialog.MyActivityDialog */
public class MyActivityDialog extends Activity {
    /* renamed from: b */
    private static final String f4365b = MyActivityDialog.class.getSimpleName();
    /* renamed from: a */
    OnClickListener f4366a = new C1548a(this);
    /* renamed from: c */
    private ImageView f4367c;
    /* renamed from: d */
    private TextView f4368d;
    /* renamed from: e */
    private Button f4369e;
    /* renamed from: f */
    private Button f4370f;
    /* renamed from: g */
    private int f4371g;

    /* renamed from: d */
    static /* synthetic */ void m4363d(MyActivityDialog myActivityDialog) {
        Font font = (Font) myActivityDialog.getIntent().getExtras().getSerializable("font");
        C1440c.m3984a().mo7165a(font, myActivityDialog.getIntent().getExtras().getInt("taskId"));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.alert_dialog);
        this.f4367c = (ImageView) findViewById(C1450R.id.icon);
        this.f4368d = (TextView) findViewById(C1450R.id.message);
        this.f4369e = (Button) findViewById(C1450R.id.cancel);
        this.f4370f = (Button) findViewById(C1450R.id.ok);
        int i = getIntent().getExtras().getInt("type");
        this.f4371g = i;
        if (i == 1) {
            this.f4370f.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(C1450R.dimen.alert_dialog_btn_height)));
            this.f4368d.setText(C1450R.string.text_font_dialog_message);
            this.f4370f.setText(C1450R.string.txt_sure);
            this.f4369e.setVisibility(8);
        } else if (i == 0) {
            String string = getIntent().getExtras().getString("fontName");
            this.f4368d.setText(String.format(getResources().getString(C1450R.string.text_font_dialog_restart), new Object[]{string}));
            this.f4370f.setText(C1450R.string.text_restart_now);
            this.f4369e.setText(C1450R.string.text_restart_delay);
        } else if (i == 2) {
            this.f4368d.setText(C1450R.string.text_font_reboot_alert);
            this.f4370f.setText(C1450R.string.text_font_continue_replace);
            this.f4369e.setText(C1450R.string.update_later);
        }
        this.f4370f.setOnClickListener(this.f4366a);
        this.f4369e.setOnClickListener(this.f4366a);
    }
}
