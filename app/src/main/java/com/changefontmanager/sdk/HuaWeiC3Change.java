package com.changefontmanager.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.changefontmanager.sdk.utils.ActivityJumpController;
import com.changefontmanager.sdk.utils.FileUtils;
import com.example.myfontsdk.Font;

public class HuaWeiC3Change implements IChangeFont {
    /* renamed from: a */
    private static Uri m918a(Context context, Font font) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.huawei.android.thememanager.ContentProvider/theme");
        ContentValues contentValues = new ContentValues();
        contentValues.put("Title", font.getFontName());
        contentValues.put("CNTitle", font.getFontName());
        contentValues.put("name", "/HWFonts/" + font.getFontName());
        contentValues.put("status", Integer.valueOf(200));
        contentValues.put("version", "2.0");
        contentValues.put("type", Integer.valueOf(1));
        return contentResolver.insert(parse, contentValues);
    }

    public int changeFont(Context context, Font font) {
        try {
            FileUtils.m966e(font.getZhLocalPath(), "/sdcard/HWThemes/HWFonts/" + font.getFontName());
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.huawei.android.thememanager.ContentProvider/theme");
            ContentValues contentValues = new ContentValues();
            contentValues.put("Title", font.getFontName());
            contentValues.put("CNTitle", font.getFontName());
            contentValues.put("name", "/HWFonts/" + font.getFontName());
            contentValues.put("status", Integer.valueOf(200));
            contentValues.put("version", "2.0");
            contentValues.put("type", Integer.valueOf(1));
            return contentResolver.insert(parse, contentValues) != null ? 1 : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void changeSuccessed(Context context) {
        ActivityJumpController.m948c(context);
    }
}
