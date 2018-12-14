package com.shuame.rootgenius.common.qqdownload;

import android.os.Handler;
import android.text.TextUtils;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.shuame.rootgenius.common.util.C1405o;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import java.io.File;
import java.util.List;
import java.util.Map;

/* renamed from: com.shuame.rootgenius.common.qqdownload.i */
public class C1367i implements C1319h {
    /* renamed from: a */
    private static final String f3787a = C1367i.class.getSimpleName();
    /* renamed from: b */
    private List<C1319h> f3788b;
    /* renamed from: c */
    private Map<Integer, C1319h> f3789c;
    /* renamed from: d */
    private Map<Integer, QQDownloadFile> f3790d;
    /* renamed from: e */
    private Map<Integer, Integer> f3791e;
    /* renamed from: f */
    private C1360a f3792f;
    /* renamed from: g */
    private Handler f3793g;

    public C1367i(List<C1319h> list, Map<Integer, C1319h> map, Map<Integer, QQDownloadFile> map2, Map<Integer, Integer> map3, C1360a c1360a, Handler handler) {
        this.f3788b = list;
        this.f3789c = map;
        this.f3790d = map2;
        this.f3791e = map3;
        this.f3792f = c1360a;
        this.f3793g = handler;
    }

    /* renamed from: a */
    public final void mo7081a() {
        QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3790d.get(Integer.valueOf(0));
        if (qQDownloadFile != null) {
            qQDownloadFile.f3730k = System.currentTimeMillis();
            new StringBuilder("statStartDownload taskId:0;downTime:").append(qQDownloadFile.f3730k);
        }
    }

    public void onComplete(int i, long j) {
        Object obj = 1;
        try {
            QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3790d.get(Integer.valueOf(i));
            if (qQDownloadFile != null && j == 0) {
                Object obj2 = !TextUtils.isEmpty(qQDownloadFile.f3726g) ? 1 : null;
                if (qQDownloadFile.f3734o != Type.ROM) {
                    obj = null;
                }
                if (!(obj2 == null && obj == null)) {
                    qQDownloadFile.f3719C = Status.VALIDATING;
                    onStatusChanged(qQDownloadFile.f3722c, qQDownloadFile.f3719C);
                }
                if (obj2 != null) {
                    File file = new File(qQDownloadFile.f3725f);
                    if (file.exists()) {
                        new StringBuilder("start md5File:").append(qQDownloadFile.f3725f);
                        String a = C1405o.m3907a(file);
                        new StringBuilder("end md5File:").append(qQDownloadFile.f3725f);
                        if (!qQDownloadFile.f3726g.equalsIgnoreCase(a)) {
                            new StringBuilder("md5File not same, server md5:").append(qQDownloadFile.f3726g).append(";local md5:").append(a);
                            j = 10000;
                        }
                    }
                }
                if (obj != null) {
                    new File(qQDownloadFile.f3725f).exists();
                }
            }
            long j2 = j;
            if (j2 == 10000 || j2 == 10001) {
                qQDownloadFile.f3728i = 0;
                new File(qQDownloadFile.f3725f).delete();
            }
            if (qQDownloadFile != null) {
                if (j2 == 0) {
                    qQDownloadFile.f3728i = 1000;
                    qQDownloadFile.f3719C = Status.FINISHED;
                } else if (j2 == 1) {
                    qQDownloadFile.f3719C = Status.STOPED;
                } else {
                    qQDownloadFile.f3719C = Status.ERROR_STOPED;
                }
                qQDownloadFile.f3729j = 0;
                qQDownloadFile.f3733n = (int) j2;
                qQDownloadFile.f3718B += System.currentTimeMillis() - qQDownloadFile.f3730k;
                onStatusChanged(qQDownloadFile.f3722c, qQDownloadFile.f3719C);
                this.f3793g.post(new C1368j(this, qQDownloadFile, i, j2));
            }
            C1319h c1319h = (C1319h) this.f3789c.get(Integer.valueOf(i));
            this.f3789c.remove(Integer.valueOf(i));
            if (c1319h != null) {
                try {
                    c1319h.onComplete(i, j2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.f3788b) {
                for (C1319h c1319h2 : this.f3788b) {
                    if (c1319h2 != null) {
                        try {
                            c1319h2.onComplete(i, j2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            try {
                if (this.f3791e.containsKey(Integer.valueOf(i))) {
                    Integer num = (Integer) this.f3791e.get(Integer.valueOf(i));
                    new StringBuilder("onComplete taskId:").append(i).append("; resultCode:").append(j2).append("; reportTypeId:").append(num);
                    if (num != null) {
                        this.f3790d.get(Integer.valueOf(i));
                    }
                    this.f3791e.remove(Integer.valueOf(i));
                }
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        } catch (Exception e222) {
            e222.printStackTrace();
        }
    }

    public void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
        try {
            C1319h c1319h = (C1319h) this.f3789c.get(Integer.valueOf(i));
            if (c1319h != null) {
                try {
                    c1319h.onDonwloadInfo(i, linkStructArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.f3788b) {
                for (C1319h c1319h2 : this.f3788b) {
                    if (c1319h2 != null) {
                        try {
                            c1319h2.onDonwloadInfo(i, linkStructArr);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    public void onFileName(int i, String str) {
        try {
            QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3790d.get(Integer.valueOf(i));
            if (!(qQDownloadFile == null || TextUtils.isEmpty(str))) {
                qQDownloadFile.f3725f = str;
                qQDownloadFile.f3719C = Status.DOWNLOADING;
                onStatusChanged(qQDownloadFile.f3722c, qQDownloadFile.f3719C);
                this.f3793g.post(new C1369k(this, i, str));
            }
            C1319h c1319h = (C1319h) this.f3789c.get(Integer.valueOf(i));
            if (c1319h != null) {
                try {
                    c1319h.onFileName(i, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.f3788b) {
                for (C1319h c1319h2 : this.f3788b) {
                    if (c1319h2 != null) {
                        try {
                            c1319h2.onFileName(i, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    public void onOnlySrcUrl(int i) {
        try {
            QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3790d.get(Integer.valueOf(i));
            if (qQDownloadFile != null) {
                qQDownloadFile.f3732m = true;
                this.f3793g.post(new C1370l(this, i));
            }
            C1319h c1319h = (C1319h) this.f3789c.get(Integer.valueOf(i));
            if (c1319h != null) {
                try {
                    c1319h.onOnlySrcUrl(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.f3788b) {
                for (C1319h c1319h2 : this.f3788b) {
                    if (c1319h2 != null) {
                        try {
                            c1319h2.onOnlySrcUrl(i);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    public void onStatusChanged(int i, Status status) {
        try {
            QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3790d.get(Integer.valueOf(i));
            if (qQDownloadFile != null) {
                qQDownloadFile.f3719C = status;
            }
            C1319h c1319h = (C1319h) this.f3789c.get(Integer.valueOf(i));
            if (c1319h != null) {
                try {
                    c1319h.onStatusChanged(i, status);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.f3788b) {
                for (C1319h c1319h2 : this.f3788b) {
                    if (c1319h2 != null) {
                        try {
                            c1319h2.onStatusChanged(i, status);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    public void onStorageErrorInfo(int i, int i2, String str) {
        try {
            QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3790d.get(Integer.valueOf(i));
            if (!(qQDownloadFile == null || TextUtils.isEmpty(str))) {
                qQDownloadFile.f3725f = str;
                this.f3793g.post(new C1372n(this, i, str));
            }
            C1319h c1319h = (C1319h) this.f3789c.get(Integer.valueOf(i));
            if (c1319h != null) {
                try {
                    c1319h.onStorageErrorInfo(i, i2, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.f3788b) {
                for (C1319h c1319h2 : this.f3788b) {
                    if (c1319h2 != null) {
                        try {
                            c1319h2.onStorageErrorInfo(i, i2, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    public void onTaskInfo(int i, int i2, int i3) {
        try {
            QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3790d.get(Integer.valueOf(i));
            if (qQDownloadFile != null) {
                int i4 = qQDownloadFile.f3728i;
                if (qQDownloadFile.f3728i < i2) {
                    qQDownloadFile.f3728i = i2;
                }
                qQDownloadFile.f3729j = i3;
                if (i2 == 0 && i3 == 0) {
                    i2 = qQDownloadFile.f3728i;
                }
                if (i2 - i4 > 0 || i2 == 1000) {
                    this.f3793g.post(new C1371m(this, i, i3, i2));
                }
            }
            C1319h c1319h = (C1319h) this.f3789c.get(Integer.valueOf(i));
            if (c1319h != null) {
                try {
                    c1319h.onTaskInfo(i, i2, i3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.f3788b) {
                for (C1319h c1319h2 : this.f3788b) {
                    if (c1319h2 != null) {
                        try {
                            c1319h2.onTaskInfo(i, i2, i3);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    public void onWaitStart(int i) {
    }
}
