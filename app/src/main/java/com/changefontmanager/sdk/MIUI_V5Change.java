package com.changefontmanager.sdk;

import android.content.Context;
import com.changefontmanager.sdk.utils.ActivityJumpController;
import com.example.myfontsdk.Font;

public class MIUI_V5Change implements IChangeFont {
    public int changeFont(Context context, Font font) {
        return MIUIChangeFont.m925a(context, font.getFontName(), font.getZhLocalPath());
    }

    public void changeSuccessed(Context context) {
        ActivityJumpController.m946a(context);
    }
}
