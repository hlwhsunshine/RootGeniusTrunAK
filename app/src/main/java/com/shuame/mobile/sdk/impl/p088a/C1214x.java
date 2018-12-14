package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.RomScanner;
import com.shuame.mobile.sdk.impl.utils.RomScanner.ScanResult;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.x */
public class C1214x extends C1185a {
    /* renamed from: b */
    private static /* synthetic */ int[] f3200b;
    /* renamed from: a */
    private LuaObject f3201a;

    public C1214x(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: d */
    static /* synthetic */ int[] m3433d() {
        int[] iArr = f3200b;
        if (iArr == null) {
            iArr = new int[ScanResult.values().length];
            try {
                iArr[ScanResult.CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ScanResult.ERROR_JSON.ordinal()] = 8;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ScanResult.ERROR_SERVER.ordinal()] = 9;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ScanResult.ERROR_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ScanResult.LOWRISK_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ScanResult.MIDRISK_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ScanResult.SAFE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ScanResult.UNKNOWN_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ScanResult.VIRUS_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            f3200b = iArr;
        }
        return iArr;
    }

    /* renamed from: a */
    public String mo6833a() {
        return "scan_rom";
    }

    public int execute() {
        int i = 0;
        int i2 = -1;
        try {
            ScanResult scan;
            String luaState = this.f3172L.toString(2);
            this.f3201a = this.f3172L.getLuaObject(3);
            ScanResult scanResult = ScanResult.UNKNOWN_TYPE;
            try {
                scan = RomScanner.scan(luaState, new C1215y(this));
            } catch (Exception e) {
                e.printStackTrace();
                scan = scanResult;
            }
            switch (C1214x.m3433d()[scan.ordinal()]) {
                case 2:
                    i = 1;
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            i = i2;
        }
        this.f3172L.pushInteger(i);
        return 1;
    }
}
