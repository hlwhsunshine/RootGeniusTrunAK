package com.changefontmanager.sdk;

import android.app.Activity;
import android.os.Bundle;
import com.example.myfontsdk.Font;

public class MainActivity extends Activity {

    /* renamed from: com.changefontmanager.sdk.MainActivity$1 */
    class C04431 extends Thread {
        C04431() {
        }

        public void run() {
            Font font = new Font();
            font.setEnLocalPath("/mnt/sdcard/font/17da6ca4cbcf8f0ece758171824e5b34-en.ttf");
            font.setZhLocalPath("/mnt/sdcard/font/17da6ca4cbcf8f0ece758171824e5b34-zh.ttf /system/fonts/temp.ttf");
            new StringBuilder("ret = ").append(ChangeFontManager.getInstance().getChangefont(MainActivity.this).changeFont(MainActivity.this.getApplicationContext(), font));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new C04431().start();
    }
}
