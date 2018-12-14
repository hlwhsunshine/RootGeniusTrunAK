package com.baidu.mobads.openad.p020d;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.openad.d.b */
public class C0232b implements IOAdEvent {
    public static final String COMPLETE = "complete";
    public static final String EVENT_MESSAGE = "message";
    /* renamed from: a */
    private final String f269a;
    /* renamed from: b */
    private final HashMap<String, Object> f270b;
    /* renamed from: c */
    private final int f271c;
    /* renamed from: d */
    private Object f272d;

    public C0232b(String str) {
        this(str, 0, new HashMap());
    }

    public C0232b(String str, int i) {
        this(str, i, new HashMap());
    }

    public C0232b(String str, int i, String str2) {
        this(str, i, new HashMap());
        this.f270b.put(EVENT_MESSAGE, str2);
    }

    public C0232b(String str, int i, HashMap<String, Object> hashMap) {
        this.f269a = str;
        this.f271c = i;
        this.f270b = hashMap;
    }

    public C0232b(String str, String str2) {
        this(str, 0, str2);
    }

    public C0232b(String str, HashMap<String, Object> hashMap) {
        this(str, 0, (HashMap) hashMap);
    }

    public int getCode() {
        return this.f271c;
    }

    public HashMap<String, Object> getData() {
        return this.f270b;
    }

    public String getMessage() {
        try {
            return (String) this.f270b.get(EVENT_MESSAGE);
        } catch (Exception e) {
            return "";
        }
    }

    public Object getTarget() {
        return this.f272d;
    }

    public String getType() {
        return this.f269a;
    }

    public void setTarget(Object obj) {
        this.f272d = obj;
    }
}
