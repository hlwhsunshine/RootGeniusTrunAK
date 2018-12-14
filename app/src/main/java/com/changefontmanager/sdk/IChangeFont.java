package com.changefontmanager.sdk;

import android.content.Context;
import com.example.myfontsdk.Font;

public interface IChangeFont {
    public static final int CHANGE_FONT_FAILED = -1;
    public static final int CHANGE_FONT_NOROOT = 2;
    public static final int CHANGE_FONT_SUCCESS = 1;
    public static final int CHANGE_FONT_SUCCESS_EN = 4;
    public static final int CHANGE_FONT_SUCCESS_ZH = 3;

    int changeFont(Context context, Font font);

    void changeSuccessed(Context context);
}
