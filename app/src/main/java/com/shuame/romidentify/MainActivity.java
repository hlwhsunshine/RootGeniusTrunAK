package com.shuame.romidentify;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.shuame.p076b.p077a.C1140o;
import java.util.Iterator;
import java.util.Map.Entry;

public class MainActivity extends Activity {
    /* renamed from: a */
    TextView f3300a = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.f3300a = (TextView) findViewById(R.id.tv_content);
        C1140o.m3287a().mo6730a(this);
        String str = "";
        Iterator it = C1140o.m3287a().mo6731b().entrySet().iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                Object key = entry.getKey();
                str = new StringBuilder(String.valueOf(str2)).append(key).append("=").append(entry.getValue()).append("\n").toString();
            } else {
                this.f3300a.setText(str2);
                return;
            }
        }
    }
}
