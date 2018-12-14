package com.kingroot.sdk;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.kingroot.sdk.gu */
public final class C0860gu {
    /* renamed from: kl */
    private StringBuilder f2145kl;
    /* renamed from: km */
    private int f2146km = 0;

    public C0860gu(StringBuilder stringBuilder, int i) {
        this.f2145kl = stringBuilder;
        this.f2146km = i;
    }

    /* renamed from: at */
    private void m2230at(String str) {
        for (int i = 0; i < this.f2146km; i++) {
            this.f2145kl.append(9);
        }
        if (str != null) {
            this.f2145kl.append(str).append(": ");
        }
    }

    /* renamed from: a */
    public final C0860gu mo5869a(byte b, String str) {
        m2230at(str);
        this.f2145kl.append(b).append(10);
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5870a(char c, String str) {
        m2230at(str);
        this.f2145kl.append(c).append(10);
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5871a(double d, String str) {
        m2230at(str);
        this.f2145kl.append(d).append(10);
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5872a(float f, String str) {
        m2230at(str);
        this.f2145kl.append(f).append(10);
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5873a(long j, String str) {
        m2230at(str);
        this.f2145kl.append(j).append(10);
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5874a(C0597gy c0597gy, String str) {
        mo5870a('{', str);
        if (c0597gy == null) {
            this.f2145kl.append(9).append("null");
        } else {
            c0597gy.mo5571a(this.f2145kl, this.f2146km + 1);
        }
        mo5870a('}', null);
        return this;
    }

    /* renamed from: a */
    public final <T> C0860gu mo5875a(Collection<T> collection, String str) {
        if (collection != null) {
            return mo5883a(collection.toArray(), str);
        }
        m2230at(str);
        this.f2145kl.append("null\t");
        return this;
    }

    /* renamed from: a */
    public final <K, V> C0860gu mo5876a(Map<K, V> map, String str) {
        m2230at(str);
        if (map == null) {
            this.f2145kl.append("null\n");
        } else if (map.isEmpty()) {
            this.f2145kl.append(map.size()).append(", {}\n");
        } else {
            this.f2145kl.append(map.size()).append(", {\n");
            C0860gu c0860gu = new C0860gu(this.f2145kl, this.f2146km + 1);
            C0860gu c0860gu2 = new C0860gu(this.f2145kl, this.f2146km + 2);
            for (Entry entry : map.entrySet()) {
                c0860gu.mo5870a('(', null);
                c0860gu2.mo5885b(entry.getKey(), null);
                c0860gu2.mo5885b(entry.getValue(), null);
                c0860gu.mo5870a(')', null);
            }
            mo5870a('}', null);
        }
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5877a(short s, String str) {
        m2230at(str);
        this.f2145kl.append(s).append(10);
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5878a(boolean z, String str) {
        m2230at(str);
        this.f2145kl.append(z ? 'T' : 'F').append(10);
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5879a(double[] dArr, String str) {
        m2230at(str);
        if (dArr == null) {
            this.f2145kl.append("null\n");
        } else if (dArr.length == 0) {
            this.f2145kl.append(dArr.length).append(", []\n");
        } else {
            this.f2145kl.append(dArr.length).append(", [\n");
            C0860gu c0860gu = new C0860gu(this.f2145kl, this.f2146km + 1);
            for (double a : dArr) {
                c0860gu.mo5871a(a, null);
            }
            mo5870a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5880a(float[] fArr, String str) {
        m2230at(str);
        if (fArr == null) {
            this.f2145kl.append("null\n");
        } else if (fArr.length == 0) {
            this.f2145kl.append(fArr.length).append(", []\n");
        } else {
            this.f2145kl.append(fArr.length).append(", [\n");
            C0860gu c0860gu = new C0860gu(this.f2145kl, this.f2146km + 1);
            for (float a : fArr) {
                c0860gu.mo5872a(a, null);
            }
            mo5870a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5881a(int[] iArr, String str) {
        m2230at(str);
        if (iArr == null) {
            this.f2145kl.append("null\n");
        } else if (iArr.length == 0) {
            this.f2145kl.append(iArr.length).append(", []\n");
        } else {
            this.f2145kl.append(iArr.length).append(", [\n");
            C0860gu c0860gu = new C0860gu(this.f2145kl, this.f2146km + 1);
            for (int d : iArr) {
                c0860gu.mo5887d(d, null);
            }
            mo5870a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5882a(long[] jArr, String str) {
        m2230at(str);
        if (jArr == null) {
            this.f2145kl.append("null\n");
        } else if (jArr.length == 0) {
            this.f2145kl.append(jArr.length).append(", []\n");
        } else {
            this.f2145kl.append(jArr.length).append(", [\n");
            C0860gu c0860gu = new C0860gu(this.f2145kl, this.f2146km + 1);
            for (long a : jArr) {
                c0860gu.mo5873a(a, null);
            }
            mo5870a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public final <T> C0860gu mo5883a(T[] tArr, String str) {
        m2230at(str);
        if (tArr == null) {
            this.f2145kl.append("null\n");
        } else if (tArr.length == 0) {
            this.f2145kl.append(tArr.length).append(", []\n");
        } else {
            this.f2145kl.append(tArr.length).append(", [\n");
            C0860gu c0860gu = new C0860gu(this.f2145kl, this.f2146km + 1);
            for (Object b : tArr) {
                c0860gu.mo5885b(b, null);
            }
            mo5870a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public final C0860gu mo5884a(short[] sArr, String str) {
        m2230at(str);
        if (sArr == null) {
            this.f2145kl.append("null\n");
        } else if (sArr.length == 0) {
            this.f2145kl.append(sArr.length).append(", []\n");
        } else {
            this.f2145kl.append(sArr.length).append(", [\n");
            C0860gu c0860gu = new C0860gu(this.f2145kl, this.f2146km + 1);
            for (short a : sArr) {
                c0860gu.mo5877a(a, null);
            }
            mo5870a(']', null);
        }
        return this;
    }

    /* renamed from: b */
    public final <T> C0860gu mo5885b(T t, String str) {
        if (t == null) {
            this.f2145kl.append("null\n");
        } else if (t instanceof Byte) {
            mo5869a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            mo5878a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            mo5877a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            mo5887d(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            mo5873a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            mo5872a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            mo5871a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            mo5888u((String) t, str);
        } else if (t instanceof Map) {
            mo5876a((Map) t, str);
        } else if (t instanceof List) {
            mo5875a((List) t, str);
        } else if (t instanceof C0597gy) {
            mo5874a((C0597gy) t, str);
        } else if (t instanceof byte[]) {
            mo5886c((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            mo5885b((boolean[]) t, str);
        } else if (t instanceof short[]) {
            mo5884a((short[]) t, str);
        } else if (t instanceof int[]) {
            mo5881a((int[]) t, str);
        } else if (t instanceof long[]) {
            mo5882a((long[]) t, str);
        } else if (t instanceof float[]) {
            mo5880a((float[]) t, str);
        } else if (t instanceof double[]) {
            mo5879a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            mo5883a((Object[]) t, str);
        } else {
            throw new C0861gv("write object error: unsupport type.");
        }
        return this;
    }

    /* renamed from: c */
    public final C0860gu mo5886c(byte[] bArr, String str) {
        m2230at(str);
        if (bArr == null) {
            this.f2145kl.append("null\n");
        } else if (bArr.length == 0) {
            this.f2145kl.append(bArr.length).append(", []\n");
        } else {
            this.f2145kl.append(bArr.length).append(", [\n");
            C0860gu c0860gu = new C0860gu(this.f2145kl, this.f2146km + 1);
            for (byte a : bArr) {
                c0860gu.mo5869a(a, null);
            }
            mo5870a(']', null);
        }
        return this;
    }

    /* renamed from: d */
    public final C0860gu mo5887d(int i, String str) {
        m2230at(str);
        this.f2145kl.append(i).append(10);
        return this;
    }

    /* renamed from: u */
    public final C0860gu mo5888u(String str, String str2) {
        m2230at(str2);
        if (str == null) {
            this.f2145kl.append("null\n");
        } else {
            this.f2145kl.append(str).append(10);
        }
        return this;
    }
}
