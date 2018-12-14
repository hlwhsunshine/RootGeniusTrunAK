package com.shuame.rootgenius.common.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.event.C1336a;
import com.shuame.rootgenius.common.event.C1337b;
import com.shuame.rootgenius.common.p101b.C1320a;
import com.shuame.rootgenius.common.qqdownload.C1319h;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.util.C1383a;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppManager implements C1319h {
    /* renamed from: c */
    protected static boolean f3686c = false;
    /* renamed from: e */
    private static final String f3687e = AppManager.class.getSimpleName();
    /* renamed from: f */
    private static AppManager f3688f;
    /* renamed from: a */
    public Map<Integer, C1348b> f3689a = new HashMap();
    /* renamed from: b */
    public Map<Integer, C1348b> f3690b = new HashMap();
    /* renamed from: d */
    public C1318c f3691d = new C1356a(this);
    /* renamed from: g */
    private HandlerThread f3692g = new HandlerThread("AppManagerHandlerThread");
    /* renamed from: h */
    private C1349d f3693h;
    /* renamed from: i */
    private Map<Integer, C1318c> f3694i;
    /* renamed from: j */
    private Map<Integer, C1348b> f3695j;
    /* renamed from: k */
    private C1347a f3696k;
    /* renamed from: l */
    private C1320a f3697l;
    /* renamed from: m */
    private Handler f3698m = new Handler(Looper.getMainLooper());

    /* renamed from: com.shuame.rootgenius.common.manager.AppManager$c */
    public interface C1318c {
        void onStatusChanged(C1348b c1348b);
    }

    public enum ApkType {
        FONT,
        APP
    }

    public enum AppStatus {
        PENDING_INSTALL,
        SIGN_CHECKING,
        SIGN_NOT_SAME,
        PENDING_UNINSTALL,
        CANCELLED_PENDING_INSTALL,
        CANCELLED_PENDING_UNINSTALL,
        SILENT_INSTALLING,
        SILENT_INSTALL_SUCCESS,
        SILENT_INSTALL_FAILURE,
        SILENT_UNINSTALLING,
        SILENT_UNINSTALL_SUCCESS,
        SILENT_UNINSTALL_FAILURE,
        SYSTEM_INSTALL,
        SYSTEM_UNINSTALL,
        SYSTEM_INSTALL_SUCCESS,
        SYSTEM_UNINSTALL_SUCCESS
    }

    public enum HandleType {
        AUTO,
        SILENT,
        SYSTEM,
        SILENT_THEN_SYSTEM
    }

    public enum InstallLocation {
        AUTO,
        SDCARD,
        FLASH
    }

    public enum Type {
        INSTALL,
        UNINSTALL
    }

    /* renamed from: com.shuame.rootgenius.common.manager.AppManager$a */
    private class C1347a extends BroadcastReceiver {
        private C1347a() {
        }

        /* synthetic */ C1347a(AppManager appManager, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (AppManager.this.f3693h != null) {
                String dataString = intent.getDataString();
                if (!TextUtils.isEmpty(dataString)) {
                    dataString = dataString.substring(dataString.lastIndexOf(58) + 1);
                    String action = intent.getAction();
                    AppManager.f3687e;
                    Message obtainMessage;
                    if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) {
                        obtainMessage = AppManager.this.f3693h.obtainMessage(3);
                        obtainMessage.obj = dataString;
                        AppManager.this.f3693h.sendMessage(obtainMessage);
                    } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                        obtainMessage = AppManager.this.f3693h.obtainMessage(4);
                        obtainMessage.obj = dataString;
                        AppManager.this.f3693h.sendMessage(obtainMessage);
                    }
                }
            }
        }
    }

    /* renamed from: com.shuame.rootgenius.common.manager.AppManager$b */
    public static class C1348b {
        /* renamed from: a */
        public int f3676a;
        /* renamed from: b */
        public String f3677b;
        /* renamed from: c */
        public String f3678c;
        /* renamed from: d */
        public AppStatus f3679d;
        /* renamed from: e */
        public Type f3680e;
        /* renamed from: f */
        public int f3681f;
        /* renamed from: g */
        public HandleType f3682g = HandleType.AUTO;
        /* renamed from: h */
        public ApkType f3683h = ApkType.FONT;
        /* renamed from: i */
        public InstallLocation f3684i = InstallLocation.AUTO;
    }

    /* renamed from: com.shuame.rootgenius.common.manager.AppManager$d */
    private class C1349d extends Handler {
        public C1349d(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        private void m3764a(Message message) {
            C1348b c1348b;
            String str = (String) message.obj;
            synchronized (AppManager.this.f3695j) {
                for (C1348b c1348b2 : AppManager.this.f3695j.values()) {
                    if (c1348b2 != null && c1348b2.f3678c != null && c1348b2.f3678c.equals(str) && c1348b2.f3679d == AppStatus.SYSTEM_INSTALL) {
                        break;
                    }
                }
                c1348b2 = null;
            }
            if (c1348b2 != null) {
                C1318c c1318c = (C1318c) AppManager.this.f3694i.get(Integer.valueOf(c1348b2.f3676a));
                c1348b2.f3679d = AppStatus.SYSTEM_INSTALL_SUCCESS;
                AppManager.this.m3780b(c1348b2, c1318c);
                AppManager.this.f3695j.remove(Integer.valueOf(c1348b2.f3676a));
                AppManager.this.f3694i.remove(Integer.valueOf(c1348b2.f3676a));
            }
        }

        /* renamed from: a */
        private void m3765a(C1348b c1348b, C1318c c1318c) {
            c1348b.f3679d = AppStatus.SILENT_INSTALLING;
            AppManager.this.m3780b(c1348b, c1318c);
            AppManager.f3687e;
            new StringBuilder("silentInstall begin taskId:").append(c1348b.f3676a);
            String str = "";
            if (c1348b.f3684i == InstallLocation.SDCARD) {
                str = "-s";
            } else if (c1348b.f3684i == InstallLocation.FLASH) {
                str = "-f";
            }
            int a = C1383a.m3856a(c1348b.f3677b, str);
            AppManager.f3687e;
            new StringBuilder("silentInstall end taskId:").append(c1348b.f3676a).append(";result:").append(a);
            c1348b.f3681f = a;
            c1348b.f3679d = a == 1 ? AppStatus.SILENT_INSTALL_SUCCESS : AppStatus.SILENT_INSTALL_FAILURE;
            AppManager.this.f3695j.remove(Integer.valueOf(c1348b.f3676a));
            AppManager.this.f3694i.remove(Integer.valueOf(c1348b.f3676a));
            AppManager.this.m3780b(c1348b, c1318c);
        }

        /* renamed from: b */
        private void m3766b(Message message) {
            C1348b c1348b;
            String str = (String) message.obj;
            synchronized (AppManager.this.f3695j) {
                for (C1348b c1348b2 : AppManager.this.f3695j.values()) {
                    if (c1348b2 != null && c1348b2.f3678c != null && c1348b2.f3678c.equals(str) && c1348b2.f3679d == AppStatus.SYSTEM_UNINSTALL) {
                        break;
                    }
                }
                c1348b2 = null;
            }
            if (c1348b2 != null) {
                C1318c c1318c = (C1318c) AppManager.this.f3694i.get(Integer.valueOf(c1348b2.f3676a));
                AppManager.this.f3695j.remove(Integer.valueOf(c1348b2.f3676a));
                AppManager.this.f3694i.remove(Integer.valueOf(c1348b2.f3676a));
                c1348b2.f3679d = AppStatus.SYSTEM_UNINSTALL_SUCCESS;
                AppManager.this.m3780b(c1348b2, c1318c);
            }
        }

        /* renamed from: b */
        private void m3767b(C1348b c1348b, C1318c c1318c) {
            AppManager.f3687e;
            new StringBuilder("systemInstall begin taskId:").append(c1348b.f3676a);
            C1383a.m3858a(C1325c.m3724a(), c1348b.f3677b);
            AppManager.f3687e;
            new StringBuilder("systemInstall end taskId:").append(c1348b.f3676a);
            c1348b.f3679d = AppStatus.SYSTEM_INSTALL;
            AppManager.this.m3780b(c1348b, c1318c);
        }

        /* renamed from: c */
        private void m3768c(C1348b c1348b, C1318c c1318c) {
            c1348b.f3679d = AppStatus.SILENT_UNINSTALLING;
            AppManager.this.m3780b(c1348b, c1318c);
            AppManager.f3687e;
            new StringBuilder("silentUninstall begin taskId:").append(c1348b.f3676a);
            int a = C1383a.m3855a(c1348b.f3678c);
            AppManager.f3687e;
            new StringBuilder("silentUninstall end taskId:").append(c1348b.f3676a).append(";result:").append(a);
            c1348b.f3681f = a;
            c1348b.f3679d = a == 1 ? AppStatus.SILENT_UNINSTALL_SUCCESS : AppStatus.SILENT_UNINSTALL_FAILURE;
            AppManager.this.f3695j.remove(Integer.valueOf(c1348b.f3676a));
            AppManager.this.f3694i.remove(Integer.valueOf(c1348b.f3676a));
            AppManager.this.m3780b(c1348b, c1318c);
        }

        /* renamed from: d */
        private void m3769d(C1348b c1348b, C1318c c1318c) {
            AppManager.f3687e;
            new StringBuilder("systemUninstall begin taskId:").append(c1348b.f3676a);
            C1383a.m3860b(C1325c.m3724a(), c1348b.f3678c);
            AppManager.f3687e;
            new StringBuilder("systemUninstall end taskId:").append(c1348b.f3676a);
            c1348b.f3679d = AppStatus.SYSTEM_UNINSTALL;
            AppManager.this.m3780b(c1348b, c1318c);
        }

        public final void dispatchMessage(Message message) {
            int i;
            C1348b c1348b;
            C1318c c1318c;
            int a;
            switch (message.what) {
                case 1:
                    AppManager.f3687e;
                    i = message.arg1;
                    c1348b = (C1348b) AppManager.this.f3695j.get(Integer.valueOf(i));
                    if (c1348b != null) {
                        c1318c = (C1318c) AppManager.this.f3694i.get(Integer.valueOf(i));
                        if (c1348b.f3683h == ApkType.APP) {
                            c1348b.f3679d = AppStatus.SIGN_CHECKING;
                            AppManager.this.m3780b(c1348b, c1318c);
                            AppManager.f3687e;
                            if (AppManager.this.f3690b.containsKey(Integer.valueOf(c1348b.f3676a))) {
                                c1348b.f3682g = HandleType.SYSTEM;
                            }
                        }
                        if (c1348b.f3682g == HandleType.AUTO) {
                            AppManager.f3687e;
                            new StringBuilder("autoInstall check canSilent taskId:").append(c1348b.f3676a);
                            if (C1383a.m3857a(C1325c.m3724a())) {
                                m3765a(c1348b, c1318c);
                                return;
                            } else {
                                m3767b(c1348b, c1318c);
                                return;
                            }
                        } else if (c1348b.f3682g == HandleType.SILENT) {
                            m3765a(c1348b, c1318c);
                            return;
                        } else if (c1348b.f3682g == HandleType.SYSTEM) {
                            m3767b(c1348b, c1318c);
                            return;
                        } else if (c1348b.f3682g == HandleType.SILENT_THEN_SYSTEM) {
                            AppManager.f3687e;
                            new StringBuilder("silentThenSystemInstall check canSilent taskId:").append(c1348b.f3676a);
                            if (C1383a.m3857a(C1325c.m3724a())) {
                                c1348b.f3679d = AppStatus.SILENT_INSTALLING;
                                AppManager.this.m3780b(c1348b, c1318c);
                                AppManager.f3687e;
                                new StringBuilder("silentThenSystemInstall silentInstall begin taskId:").append(c1348b.f3676a);
                                String str = "";
                                if (c1348b.f3684i == InstallLocation.SDCARD) {
                                    str = "-s";
                                } else if (c1348b.f3684i == InstallLocation.FLASH) {
                                    str = "-f";
                                }
                                a = C1383a.m3856a(c1348b.f3677b, str);
                                AppManager.f3687e;
                                new StringBuilder("silentThenSystemInstall silentInstall end taskId:").append(c1348b.f3676a).append(";result:").append(a);
                                c1348b.f3681f = a;
                                c1348b.f3679d = a == 1 ? AppStatus.SILENT_INSTALL_SUCCESS : AppStatus.SILENT_INSTALL_FAILURE;
                                if (a == 1) {
                                    AppManager.this.f3695j.remove(Integer.valueOf(c1348b.f3676a));
                                    AppManager.this.f3694i.remove(Integer.valueOf(c1348b.f3676a));
                                    AppManager.this.m3780b(c1348b, c1318c);
                                    return;
                                } else if (c1348b.f3683h == ApkType.APP) {
                                    c1348b.f3682g = HandleType.SYSTEM;
                                    c1348b.f3679d = AppStatus.SILENT_INSTALL_FAILURE;
                                    AppManager.this.m3780b(c1348b, AppManager.this.f3691d);
                                    c1348b.f3679d = AppStatus.SYSTEM_INSTALL;
                                    C1383a.m3858a(C1325c.m3724a(), c1348b.f3677b);
                                    return;
                                } else {
                                    m3767b(c1348b, c1318c);
                                    return;
                                }
                            }
                            m3767b(c1348b, c1318c);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 2:
                    i = message.arg1;
                    c1348b = (C1348b) AppManager.this.f3695j.get(Integer.valueOf(i));
                    if (c1348b != null) {
                        c1318c = (C1318c) AppManager.this.f3694i.get(Integer.valueOf(i));
                        if (c1348b.f3682g == HandleType.AUTO) {
                            AppManager.f3687e;
                            new StringBuilder("autoUninstall check canSilent taskId:").append(c1348b.f3676a);
                            if (C1383a.m3857a(C1325c.m3724a())) {
                                m3768c(c1348b, c1318c);
                                return;
                            } else {
                                m3769d(c1348b, c1318c);
                                return;
                            }
                        } else if (c1348b.f3682g == HandleType.SILENT) {
                            m3768c(c1348b, c1318c);
                            return;
                        } else if (c1348b.f3682g == HandleType.SYSTEM) {
                            m3769d(c1348b, c1318c);
                            return;
                        } else if (c1348b.f3682g == HandleType.SILENT_THEN_SYSTEM) {
                            AppManager.f3687e;
                            new StringBuilder("silentThenSystemUninstall check canSilent taskId:").append(c1348b.f3676a);
                            if (C1383a.m3857a(C1325c.m3724a())) {
                                c1348b.f3679d = AppStatus.SILENT_UNINSTALLING;
                                AppManager.this.m3780b(c1348b, c1318c);
                                AppManager.f3687e;
                                new StringBuilder("silentThenSystemUninstall silentUninstall begin taskId:").append(c1348b.f3676a);
                                a = C1383a.m3855a(c1348b.f3678c);
                                AppManager.f3687e;
                                new StringBuilder("silentThenSystemUninstall silentUninstall end taskId:").append(c1348b.f3676a).append(";result:").append(a);
                                c1348b.f3681f = a;
                                c1348b.f3679d = a == 1 ? AppStatus.SILENT_UNINSTALL_SUCCESS : AppStatus.SILENT_UNINSTALL_FAILURE;
                                if (a != -3) {
                                    AppManager.this.f3695j.remove(Integer.valueOf(c1348b.f3676a));
                                    AppManager.this.f3694i.remove(Integer.valueOf(c1348b.f3676a));
                                    AppManager.this.m3780b(c1348b, c1318c);
                                    return;
                                }
                            }
                            m3769d(c1348b, c1318c);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 3:
                    m3764a(message);
                    return;
                case 4:
                    m3766b(message);
                    return;
                default:
                    return;
            }
        }
    }

    private AppManager() {
        this.f3692g.start();
        this.f3693h = new C1349d(this.f3692g.getLooper());
        this.f3694i = new ConcurrentHashMap();
        this.f3695j = new ConcurrentHashMap();
        this.f3696k = new C1347a(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        C1325c.m3724a().registerReceiver(this.f3696k, intentFilter);
    }

    /* renamed from: a */
    public static AppManager m3771a() {
        if (f3688f == null) {
            synchronized (AppManager.class) {
                if (f3688f == null) {
                    f3688f = new AppManager();
                }
            }
        }
        return f3688f;
    }

    /* renamed from: a */
    public static void m3776a(QQDownloadFile qQDownloadFile) {
        m3782b(qQDownloadFile);
    }

    /* renamed from: b */
    private void m3780b(C1348b c1348b, C1318c c1318c) {
        if (c1348b.f3683h == ApkType.APP) {
            this.f3689a.put(Integer.valueOf(c1348b.f3676a), c1348b);
        }
        if (c1318c != null) {
            c1318c.onStatusChanged(c1348b);
        }
    }

    /* renamed from: b */
    private static void m3782b(QQDownloadFile qQDownloadFile) {
        C1348b c1348b = new C1348b();
        c1348b.f3682g = HandleType.SILENT_THEN_SYSTEM;
        c1348b.f3683h = ApkType.APP;
        c1348b.f3676a = qQDownloadFile.f3722c;
        c1348b.f3678c = qQDownloadFile.f3739t;
        new StringBuilder("updateApp :  appInfo.packageName =").append(c1348b.f3678c);
        c1348b.f3677b = qQDownloadFile.f3725f;
        m3771a().mo7031a(c1348b, m3771a().f3691d);
    }

    /* renamed from: a */
    public final int mo7031a(C1348b c1348b, C1318c c1318c) {
        new StringBuilder("startInstall taskId:").append(c1348b.f3676a).append(";path:").append(c1348b.f3677b);
        ApkType apkType = ApkType.APP;
        c1348b.f3679d = AppStatus.PENDING_INSTALL;
        c1348b.f3680e = Type.INSTALL;
        if (c1318c != null) {
            m3780b(c1348b, c1318c);
            this.f3694i.put(Integer.valueOf(c1348b.f3676a), c1318c);
        }
        this.f3695j.put(Integer.valueOf(c1348b.f3676a), c1348b);
        Message obtainMessage = this.f3693h.obtainMessage(1);
        obtainMessage.arg1 = c1348b.f3676a;
        obtainMessage.obj = c1348b;
        this.f3693h.sendMessage(obtainMessage);
        return c1348b.f3676a;
    }

    /* renamed from: a */
    public final void mo7032a(int i) {
        C1348b c1348b = (C1348b) this.f3695j.get(Integer.valueOf(i));
        if (c1348b != null) {
            C1318c c1318c = (C1318c) this.f3694i.get(Integer.valueOf(i));
            c1348b.f3679d = AppStatus.CANCELLED_PENDING_INSTALL;
            m3780b(c1348b, c1318c);
            this.f3695j.remove(Integer.valueOf(i));
            this.f3694i.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    public final void mo7033a(C1320a c1320a) {
        this.f3697l = c1320a;
    }

    public void onComplete(int i, long j) {
        if (this.f3697l != null) {
            this.f3697l.onComplete(i, j);
        }
        QQDownloadFile a = C1361b.m3817a().mo7068a(i);
        if (a == null || a.f3734o == com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type.APK) {
            switch ((int) j) {
                case 0:
                    QQDownloadFile a2 = C1361b.m3817a().mo7068a(i);
                    if (!(a2 == null || TextUtils.isEmpty(a2.f3741v))) {
                        new StringBuilder("reportDownloadSucc projectName:").append(a2.f3741v);
                        C1336a c1336a = new C1336a();
                        c1336a.f3616g = a2.f3739t;
                        c1336a.f3610a = a2.f3741v;
                        c1336a.f3611b = "download";
                        c1336a.f3612c = "true";
                        c1336a.f3615f = 1;
                        c1336a.f3613d = "下载成功";
                        C1337b.m3738a().mo7007c(c1336a);
                    }
                    m3782b(a);
                    return;
                case 1:
                    return;
                default:
                    a = C1361b.m3817a().mo7068a(i);
                    if (a != null && !TextUtils.isEmpty(a.f3741v)) {
                        new StringBuilder("reportDownloadFail projectName:").append(a.f3741v);
                        C1336a c1336a2 = new C1336a();
                        c1336a2.f3616g = a.f3739t;
                        c1336a2.f3610a = a.f3741v;
                        c1336a2.f3611b = "download";
                        c1336a2.f3612c = "false";
                        c1336a2.f3615f = 1;
                        c1336a2.f3613d = "下载失败--ResultCode:" + j + "--url:" + a.f3724e;
                        C1337b.m3738a().mo7007c(c1336a2);
                        return;
                    }
                    return;
            }
        }
    }

    public void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
    }

    public void onFileName(int i, String str) {
    }

    public void onOnlySrcUrl(int i) {
    }

    public void onStatusChanged(int i, Status status) {
        if (this.f3697l != null) {
            this.f3697l.onStatusChanged(i, status);
        }
    }

    public void onStorageErrorInfo(int i, int i2, String str) {
    }

    public void onTaskInfo(int i, int i2, int i3) {
        QQDownloadFile a = C1361b.m3817a().mo7068a(i);
        if (a != null) {
            new StringBuilder("downloadFile.type=").append(a.f3734o);
        }
        if (this.f3697l != null) {
            this.f3697l.onTaskInfo(i, i2, i3);
        }
    }

    public void onWaitStart(int i) {
    }
}
