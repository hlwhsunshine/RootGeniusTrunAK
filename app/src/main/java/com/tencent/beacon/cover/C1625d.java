package com.tencent.beacon.cover;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.beacon.cover.d */
public final class C1625d {
    /* renamed from: c */
    private static C1625d f4606c = null;
    /* renamed from: a */
    private Context f4607a = null;
    /* renamed from: b */
    private Map<String, FileChannel> f4608b = null;

    private C1625d(Context context) {
        this.f4607a = context;
        this.f4608b = new HashMap(5);
    }

    /* renamed from: a */
    public static synchronized C1625d m4410a(Context context) {
        C1625d c1625d;
        synchronized (C1625d.class) {
            if (f4606c == null) {
                f4606c = new C1625d(context);
            }
            c1625d = f4606c;
        }
        return c1625d;
    }

    /* renamed from: c */
    private synchronized File m4411c(String str) {
        File file;
        this.f4607a.getFilesDir();
        try {
            file = new File(this.f4607a.getFilesDir(), "beacon_cover_" + str + ".lock");
            if (!file.exists()) {
                C1627f.m4428a("D", " create lock file: %s", file.getAbsolutePath());
                file.createNewFile();
            }
        } catch (IOException e) {
            C1627f.m4428a("W", "create lock file error.", new Object[0]);
            file = null;
        }
        return file;
    }

    /* renamed from: a */
    public final synchronized boolean mo7600a(String str) {
        boolean z;
        if (str.trim().length() <= 0) {
            z = false;
        } else if (this.f4608b.containsKey(str)) {
            z = true;
        } else {
            File c = m4411c(str);
            if (c == null) {
                z = true;
            } else {
                try {
                    FileChannel fileChannel = (FileChannel) this.f4608b.get(str);
                    if (fileChannel == null || !fileChannel.isOpen()) {
                        fileChannel = new FileOutputStream(c).getChannel();
                        this.f4608b.put(str, fileChannel);
                    }
                    FileLock lock = fileChannel.lock();
                    if (lock != null && lock.isValid()) {
                        z = true;
                    }
                } catch (Throwable th) {
                    C1627f.m4428a("W", "lock task error.", new Object[0]);
                    th.printStackTrace();
                }
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized void mo7601b(String str) {
        if (str.trim().length() > 0) {
            FileChannel fileChannel = (FileChannel) this.f4608b.get(str);
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Throwable th) {
                    C1627f.m4428a("W", "release task error.", new Object[0]);
                    th.printStackTrace();
                }
            }
        }
        return;
    }
}
