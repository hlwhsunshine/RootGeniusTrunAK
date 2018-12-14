package com.tencent.stat.event;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.d */
public class C1740d {
    /* renamed from: a */
    public String f5113a;
    /* renamed from: b */
    public JSONArray f5114b;
    /* renamed from: c */
    public JSONObject f5115c = null;

    public C1740d(String str, String[] strArr, Properties properties) {
        this.f5113a = str;
        if (properties != null) {
            this.f5115c = new JSONObject(properties);
        } else if (strArr != null) {
            this.f5114b = new JSONArray();
            for (Object put : strArr) {
                this.f5114b.put(put);
            }
        } else {
            this.f5115c = new JSONObject();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1740d)) {
            return false;
        }
        return toString().equals(((C1740d) obj).toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.f5113a).append(",");
        if (this.f5114b != null) {
            stringBuilder.append(this.f5114b.toString());
        }
        if (this.f5115c != null) {
            stringBuilder.append(this.f5115c.toString());
        }
        return stringBuilder.toString();
    }
}
