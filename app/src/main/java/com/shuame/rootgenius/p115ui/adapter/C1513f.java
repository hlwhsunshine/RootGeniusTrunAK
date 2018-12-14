package com.shuame.rootgenius.p115ui.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.changefontmanager.sdk.ChangeFontManager;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.adapter.f */
final class C1513f extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ FontListAdapter f4309a;

    C1513f(FontListAdapter fontListAdapter) {
        this.f4309a = fontListAdapter;
    }

    public final void onReceive(Context context, Intent intent) {
        String dataString = intent.getDataString();
        CharSequence string = context.getSharedPreferences("pack", 0).getString("name", "-1");
        if (dataString != null && dataString.trim().contains(string)) {
            ChangeFontManager.getInstance().getChangefont(this.f4309a.f4279h).changeSuccessed(this.f4309a.f4279h);
            Toast.makeText(this.f4309a.f4279h, this.f4309a.f4279h.getResources().getString(C1450R.string.text_font_dialog_htc_message), 0).show();
        }
    }
}
