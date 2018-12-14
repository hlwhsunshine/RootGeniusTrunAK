package com.baidu.mobads.openad.p038f;

import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer.EventHandler;
import com.baidu.mobads.p021j.C0338m;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.baidu.mobads.openad.f.a */
public class C0372a implements IOAdTimer {
    /* renamed from: c */
    private static String f800c = "OAdTimer";
    /* renamed from: a */
    protected int f801a;
    /* renamed from: b */
    private EventHandler f802b;
    /* renamed from: d */
    private int f803d;
    /* renamed from: e */
    private int f804e;
    /* renamed from: f */
    private int f805f;
    /* renamed from: g */
    private Timer f806g;
    /* renamed from: h */
    private AtomicInteger f807h;

    public C0372a(int i) {
        this(i, InitError.INIT_AD_ERROR);
    }

    public C0372a(int i, int i2) {
        this.f801a = InitError.INIT_AD_ERROR;
        this.f801a = i2;
        int i3 = i / this.f801a;
        C0338m.m569a().mo5033f().mo4931i(f800c, "RendererTimer(duration=" + i3 + ")");
        this.f803d = i3;
        this.f804e = i3;
        this.f806g = new Timer();
        this.f807h = new AtomicInteger(-1);
    }

    public int getCurrentCount() {
        return this.f805f;
    }

    public int getRepeatCount() {
        return this.f803d;
    }

    public void pause() {
        C0338m.m569a().mo5033f().mo4931i(f800c, "pause");
        this.f807h.set(1);
    }

    public void reset() {
        C0338m.m569a().mo5033f().mo4931i(f800c, "reset");
        this.f807h.set(-1);
        this.f804e = this.f803d;
    }

    public void resume() {
        C0338m.m569a().mo5033f().mo4931i(f800c, "resume");
        this.f807h.set(0);
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.f802b = eventHandler;
    }

    public void start() {
        C0338m.m569a().mo5033f().mo4931i(f800c, "start");
        this.f807h.set(0);
        this.f806g.scheduleAtFixedRate(new C0373b(this), 0, (long) this.f801a);
    }

    public void stop() {
        C0338m.m569a().mo5033f().mo4931i(f800c, "stop");
        this.f807h.set(2);
        if (this.f806g != null) {
            this.f806g.purge();
            this.f806g.cancel();
            this.f806g = null;
        }
    }
}
