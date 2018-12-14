package com.tencent.xuanfeng.downloadsdkkernel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.SoftReference;

class NetworkChangeReceiver extends BroadcastReceiver {
    private static final int MSG_NETWORK_CHANGE = 1000;
    private static final String TAG = "NetworkChangeReceiver";
    Handler NetworkChangeHandler = new C17691();
    private SoftReference<Context> mSoftReferenceContext;

    /* renamed from: com.tencent.xuanfeng.downloadsdkkernel.NetworkChangeReceiver$1 */
    class C17691 extends Handler {
        C17691() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case NetworkChangeReceiver.MSG_NETWORK_CHANGE /*1000*/:
                    if (NetworkChangeReceiver.this.mSoftReferenceContext.get() != null) {
                        NetCallUntl.netEnvChange((Context) NetworkChangeReceiver.this.mSoftReferenceContext.get());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    NetworkChangeReceiver() {
    }

    public void onReceive(Context context, Intent intent) {
        if (getResultCode() == -1 && context.getSharedPreferences("com.example.downloadsdktest", 0).getBoolean("toggle_net_env_change", true)) {
            this.mSoftReferenceContext = new SoftReference(context);
            this.NetworkChangeHandler.removeMessages(MSG_NETWORK_CHANGE);
            this.NetworkChangeHandler.sendEmptyMessageDelayed(MSG_NETWORK_CHANGE, 1000);
        }
    }
}
