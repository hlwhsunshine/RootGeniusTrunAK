package com.nostra13.universalimageloader.p064b;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* renamed from: com.nostra13.universalimageloader.b.f */
public final class C1002f {
    /* renamed from: a */
    private static File m2838a(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists()) {
            return file;
        }
        if (file.mkdirs()) {
            try {
                new File(file, ".nomedia").createNewFile();
                return file;
            } catch (IOException e) {
                C0999c.m2834b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                return file;
            }
        }
        C0999c.m2835c("Unable to create external cache directory", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static File m2839a(Context context, boolean z) {
        File file = null;
        Object externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException e) {
            externalStorageState = "";
        }
        if (z && "mounted".equals(externalStorageState)) {
            if ((context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 ? 1 : 0) != 0) {
                file = C1002f.m2838a(context);
            }
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        C0999c.m2835c("Can't define system cache directory! '%s' will be used.", "/data/data/" + context.getPackageName() + "/cache/");
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }
}
