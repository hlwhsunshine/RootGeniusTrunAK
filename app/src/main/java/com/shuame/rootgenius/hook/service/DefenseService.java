package com.shuame.rootgenius.hook.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.shuame.p079ij.IIjBridge.Stub;
import com.shuame.rootgenius.hook.p112ui.UninstallWarnActivity;

public class DefenseService extends Service {
    public static final int MSG_USER_DEFENSE_READY = 1;
    private static final String TAG = DefenseService.class.getSimpleName();
    private boolean _allow = false;
    private Object _lock = new Object();
    private boolean _ready = false;
    /* renamed from: h */
    private Handler f3983h = new Handler(new C14531());
    private DefenseServiceStub stub = new DefenseServiceStub(this, null);

    /* renamed from: com.shuame.rootgenius.hook.service.DefenseService$1 */
    class C14531 implements Callback {
        C14531() {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                DefenseService.TAG;
                synchronized (DefenseService.this._lock) {
                    DefenseService.this._allow = message.getData().getBoolean("allow");
                    DefenseService.this._ready = true;
                    DefenseService.this._lock.notifyAll();
                }
            }
            return false;
        }
    }

    private class DefenseServiceStub extends Stub {
        private DefenseServiceStub() {
        }

        /* synthetic */ DefenseServiceStub(DefenseService defenseService, C14531 c14531) {
            this();
        }

        public boolean defense() {
            DefenseService.TAG;
            Intent intent = new Intent(DefenseService.this, UninstallWarnActivity.class);
            intent.addFlags(268435456);
            DefenseService.this.startActivity(intent);
            synchronized (DefenseService.this._lock) {
                while (!DefenseService.this._ready) {
                    try {
                        DefenseService.this._lock.wait();
                    } catch (InterruptedException e) {
                        DefenseService.TAG;
                    }
                }
            }
            DefenseService.TAG;
            return DefenseService.this._allow;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.stub;
    }

    public void onCreate() {
        super.onCreate();
        DefenseHolder.getInstance().setServiceHandler(this.f3983h);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
