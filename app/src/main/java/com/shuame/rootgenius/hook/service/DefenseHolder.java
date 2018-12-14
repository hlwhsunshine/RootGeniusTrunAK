package com.shuame.rootgenius.hook.service;

import android.os.Handler;

public class DefenseHolder {
    private Handler _service_handler;

    private static class DefenseHolderH {
        private static DefenseHolder _instance = new DefenseHolder();

        private DefenseHolderH() {
        }
    }

    private DefenseHolder() {
    }

    public static DefenseHolder getInstance() {
        return DefenseHolderH._instance;
    }

    public Handler getServiceHandler() {
        return this._service_handler;
    }

    public void setServiceHandler(Handler handler) {
        this._service_handler = handler;
    }
}
