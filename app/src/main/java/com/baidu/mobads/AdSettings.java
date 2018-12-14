package com.baidu.mobads;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdSettings {
    /* renamed from: a */
    private static HashSet<String> f330a = new HashSet();
    /* renamed from: b */
    private static JSONArray f331b = new JSONArray();
    /* renamed from: c */
    private static String f332c;
    /* renamed from: d */
    private static String f333d;
    /* renamed from: e */
    private static String f334e;
    /* renamed from: f */
    private static String f335f;
    /* renamed from: g */
    private static String f336g;
    /* renamed from: h */
    private static String f337h;
    /* renamed from: i */
    private static String f338i;
    /* renamed from: j */
    private static HashSet<String> f339j = new HashSet();
    /* renamed from: k */
    private static JSONArray f340k = new JSONArray();
    /* renamed from: l */
    private static JSONObject f341l = new JSONObject();

    /* renamed from: com.baidu.mobads.AdSettings$a */
    public enum C0234a {
        PRIMARY(0),
        JUNIOR(1),
        SENIOR(2),
        SPECIALTY(3),
        BACHELOR(4),
        MASTER(5),
        DOCTOR(6);
        
        /* renamed from: h */
        private int f310h;

        private C0234a(int i) {
            this.f310h = i;
        }

        /* renamed from: a */
        public final int mo4192a() {
            return this.f310h;
        }
    }

    /* renamed from: com.baidu.mobads.AdSettings$b */
    public enum C0235b {
        F0T1k(0),
        F1kT2k(1),
        F2kT3k(2),
        F3kT4k(3),
        F4kT5k(4),
        F5kT6k(5),
        F6kT7k(6),
        F7kT8k(7),
        F8kT9k(8),
        F9kT10k(9),
        F10kT15k(10),
        F15kT20k(11),
        F20(12);
        
        /* renamed from: n */
        private int f325n;

        private C0235b(int i) {
            this.f325n = i;
        }

        /* renamed from: a */
        public final int mo4193a() {
            return this.f325n;
        }
    }

    /* renamed from: com.baidu.mobads.AdSettings$c */
    public enum C0236c {
        MALE(0),
        FEMALE(1);
        
        /* renamed from: c */
        private int f329c;

        private C0236c(int i) {
            this.f329c = i;
        }

        /* renamed from: a */
        public final int mo4194a() {
            return this.f329c;
        }
    }

    protected static JSONObject getAttr() {
        JSONObject jSONObject = new JSONObject();
        Iterator it = f330a.iterator();
        f331b = new JSONArray();
        while (it.hasNext()) {
            f331b.put(it.next());
        }
        it = f339j.iterator();
        f340k = new JSONArray();
        while (it.hasNext()) {
            f340k.put(it.next());
        }
        try {
            jSONObject.putOpt("KEY", f331b);
            jSONObject.putOpt("SEX", f332c);
            jSONObject.putOpt("BIR", f333d);
            jSONObject.putOpt("CITY", f334e);
            jSONObject.putOpt("ZIP", f335f);
            jSONObject.putOpt("JOB", f336g);
            jSONObject.putOpt("EDU", f337h);
            jSONObject.putOpt("SAL", f338i);
            jSONObject.putOpt("HOB", f340k);
            jSONObject.putOpt("R", f341l);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static void setBirthday(Calendar calendar) {
        if (calendar != null) {
            int i = calendar.get(1);
            int i2 = calendar.get(2) + 1;
            int i3 = calendar.get(5);
            f333d = String.valueOf(i);
            if (i2 <= 0 || i2 >= 10) {
                f333d += i2;
            } else {
                f333d += "0" + i2;
            }
            if (i3 <= 0 || i3 >= 10) {
                f333d += i3;
            } else {
                f333d += "0" + i3;
            }
        }
    }

    public static void setCity(String str) {
        f334e = str;
    }

    public static void setEducation(C0234a c0234a) {
        if (c0234a != null) {
            f337h = c0234a.mo4192a();
        }
    }

    public static void setHob(List<String> list) {
        f339j.addAll(list);
    }

    public static void setHob(String[] strArr) {
        for (Object add : strArr) {
            f339j.add(add);
        }
    }

    public static void setJob(String str) {
        f336g = str;
    }

    public static void setKey(List<String> list) {
        f330a.addAll(list);
    }

    public static void setKey(String[] strArr) {
        for (Object add : strArr) {
            f330a.add(add);
        }
    }

    public static void setSalary(C0235b c0235b) {
        if (c0235b != null) {
            f338i = c0235b.mo4193a();
        }
    }

    public static void setSex(C0236c c0236c) {
        if (c0236c != null) {
            f332c = c0236c.mo4194a();
        }
    }

    public static void setUserAttr(String str, String str2) {
        try {
            f341l.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public static void setZip(String str) {
        f335f = str;
    }
}
