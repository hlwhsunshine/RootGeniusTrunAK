package com.shuame.rootgenius.common.qqdownload;

import android.text.TextUtils;
import java.lang.reflect.Field;

public final class QQDownloadFile {
    /* renamed from: A */
    public long f3717A;
    /* renamed from: B */
    public long f3718B;
    /* renamed from: C */
    public Status f3719C = Status.STOPED;
    /* renamed from: a */
    public int f3720a;
    /* renamed from: b */
    public int f3721b;
    /* renamed from: c */
    public int f3722c;
    /* renamed from: d */
    public String f3723d = "";
    /* renamed from: e */
    public String f3724e;
    /* renamed from: f */
    public String f3725f;
    /* renamed from: g */
    public String f3726g;
    /* renamed from: h */
    public long f3727h;
    /* renamed from: i */
    public int f3728i;
    /* renamed from: j */
    public int f3729j;
    /* renamed from: k */
    public long f3730k;
    /* renamed from: l */
    public String f3731l;
    /* renamed from: m */
    public boolean f3732m;
    /* renamed from: n */
    public int f3733n = -2;
    /* renamed from: o */
    public Type f3734o;
    /* renamed from: p */
    public String f3735p;
    /* renamed from: q */
    public String f3736q;
    /* renamed from: r */
    public String f3737r;
    /* renamed from: s */
    public String f3738s;
    /* renamed from: t */
    public String f3739t;
    /* renamed from: u */
    public String f3740u;
    /* renamed from: v */
    public String f3741v;
    /* renamed from: w */
    public long f3742w;
    /* renamed from: x */
    public long f3743x;
    /* renamed from: y */
    public long f3744y;
    /* renamed from: z */
    public long f3745z;

    public enum Status {
        PENDING(1),
        DOWNLOADING(2),
        STOPED(3),
        FINISHED(4),
        STARTING(5),
        STOPING(6),
        PENDING_STOPED(7),
        ERROR_STOPED(8),
        VALIDATING(9),
        STARTING_OR_DOWNLOADING(10),
        STOPING_OR_STOPED(11),
        NOT_FINISHED(12);
        
        private int value;

        private Status(int i) {
            this.value = i;
        }

        public static Status fromValue(int i) {
            switch (i) {
                case 1:
                    return PENDING;
                case 2:
                    return DOWNLOADING;
                case 3:
                    return STOPED;
                case 4:
                    return FINISHED;
                case 5:
                    return STARTING;
                case 6:
                    return STOPING;
                case 7:
                    return PENDING_STOPED;
                case 8:
                    return ERROR_STOPED;
                case 9:
                    return VALIDATING;
                case 10:
                    return STARTING_OR_DOWNLOADING;
                case 11:
                    return STOPING_OR_STOPED;
                case 12:
                    return NOT_FINISHED;
                default:
                    return null;
            }
        }

        public final int getValue() {
            return this.value;
        }
    }

    public enum Type {
        ROM(1),
        APK(2),
        FONT(3),
        FONT_MANAGER(4);
        
        private int value;

        private Type(int i) {
            this.value = i;
        }

        public static Type fromValue(int i) {
            switch (i) {
                case 1:
                    return ROM;
                case 2:
                    return APK;
                case 3:
                    return FONT;
                case 4:
                    return FONT_MANAGER;
                default:
                    return null;
            }
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* renamed from: a */
    public final String mo7051a() {
        return !TextUtils.isEmpty(this.f3725f) ? this.f3725f + ".tmp" : null;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Field field : getClass().getFields()) {
            String name = field.getName();
            Object obj = "";
            try {
                obj = field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
            stringBuffer.append(name + "=" + obj + ";");
        }
        return stringBuffer.toString();
    }
}
