package com.changefontmanager.sdk;

import android.content.Context;
import com.changefontmanager.sdk.utils.RootUtils;
import com.example.myfontsdk.Font;

public class HuaweiChange implements IChangeFont {
    public int changeFont(Context context, Font font) {
        HuaweiChangeFont huaweiChangeFont = new HuaweiChangeFont();
        String zhLocalPath = font.getZhLocalPath();
        boolean a = HuaweiChangeFont.m920a(font.getEnLocalPath());
        boolean b = HuaweiChangeFont.m922b(zhLocalPath);
        return (b && a) ? 1 : (!b || a) ? (b || !a) ? -1 : 4 : 3;
    }

    public void changeSuccessed(Context context) {
        RootUtils.m975p();
    }
}
