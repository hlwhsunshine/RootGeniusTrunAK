package com.baidu.mobads.p021j;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;

/* renamed from: com.baidu.mobads.j.b */
public class C0327b implements IXAdActivityUtils {
    public Boolean isFullScreen(Activity activity) {
        if (activity == null) {
            return Boolean.valueOf(false);
        }
        try {
            return Boolean.valueOf((activity.getWindow().getAttributes().flags & 1024) == 1024);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    public void showAlertDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (activity != null) {
            try {
                new Builder(activity).setCancelable(z).setTitle(str).setMessage(str2).setPositiveButton(str3, onClickListener).setNegativeButton(str4, onClickListener2).create().show();
            } catch (Throwable e) {
                C0338m.m569a().mo5033f().mo4924d(e);
            }
        }
    }
}
