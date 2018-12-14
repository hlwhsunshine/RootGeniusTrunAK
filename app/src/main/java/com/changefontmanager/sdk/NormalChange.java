package com.changefontmanager.sdk;

import android.content.Context;
import com.changefontmanager.sdk.utils.CmdUtils;
import com.changefontmanager.sdk.utils.RootUtils;
import com.example.myfontsdk.Font;

public class NormalChange implements IChangeFont {
    public int changeFont(Context context, Font font) {
        NormalChangeFont3 normalChangeFont3 = new NormalChangeFont3();
        String zhLocalPath = font.getZhLocalPath();
        String enLocalPath = font.getEnLocalPath();
        int i = (CmdUtils.m960h(new StringBuilder(String.valueOf(CmdUtils.f1158G)).append(" ").append(CmdUtils.f1156E).toString()) || CmdUtils.m960h(CmdUtils.f1155D) || CmdUtils.m960h(CmdUtils.f1156E) || CmdUtils.m960h(CmdUtils.f1157F)) ? 1 : 0;
        if (i == 0) {
            return 2;
        }
        boolean a = normalChangeFont3.mo5303a(enLocalPath);
        boolean b = normalChangeFont3.mo5304b(zhLocalPath);
        return (b && a) ? 1 : (!b || a) ? (b || !a) ? -1 : 4 : 3;
    }

    public void changeSuccessed(Context context) {
        RootUtils.m975p();
    }
}
