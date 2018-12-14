package com.kingroot.sdk;

import android.content.p013pm.PermissionInfo;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.kingroot.sdk.gw */
public final class C0863gw {
    /* renamed from: kn */
    private ByteBuffer f2148kn;
    /* renamed from: ko */
    protected String f2149ko = "GBK";

    /* renamed from: com.kingroot.sdk.gw$a */
    public static class C0862a {
        /* renamed from: kp */
        public byte f2147kp;
        public int tag;
    }

    public C0863gw(byte[] bArr) {
        this.f2148kn = ByteBuffer.wrap(bArr);
    }

    public C0863gw(byte[] bArr, int i) {
        this.f2148kn = ByteBuffer.wrap(bArr);
        this.f2148kn.position(i);
    }

    /* renamed from: a */
    public static int m2251a(C0862a c0862a, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c0862a.f2147kp = (byte) (b & 15);
        c0862a.tag = (b & PermissionInfo.PROTECTION_MASK_FLAGS) >> 4;
        if (c0862a.tag != 15) {
            return 1;
        }
        c0862a.tag = byteBuffer.get() & 255;
        return 2;
    }

    /* renamed from: a */
    private <K, V> Map<K, V> m2252a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 8:
                    int a = mo5893a(0, 0, true);
                    if (a < 0) {
                        throw new C0859gt("size invalid: " + a);
                    }
                    for (int i2 = 0; i2 < a; i2++) {
                        map.put(mo5911b(key, 0, true), mo5911b(value, 1, true));
                    }
                    return map;
                case (byte) 11:
                    return map;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return map;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    private void m2253a(byte b) {
        int i = 0;
        int a;
        switch (b) {
            case (byte) 0:
                skip(1);
                return;
            case (byte) 1:
                skip(2);
                return;
            case (byte) 2:
                skip(4);
                return;
            case (byte) 3:
                skip(8);
                return;
            case (byte) 4:
                skip(4);
                return;
            case (byte) 5:
                skip(8);
                return;
            case (byte) 6:
                i = this.f2148kn.get();
                if (i < 0) {
                    i += 256;
                }
                skip(i);
                return;
            case (byte) 7:
                skip(this.f2148kn.getInt());
                return;
            case (byte) 8:
                a = mo5893a(0, 0, true);
                while (i < a * 2) {
                    m2256cp();
                    i++;
                }
                return;
            case (byte) 9:
                a = mo5893a(0, 0, true);
                while (i < a) {
                    m2256cp();
                    i++;
                }
                return;
            case (byte) 10:
                mo5912co();
                return;
            case (byte) 11:
            case (byte) 12:
                return;
            case (byte) 13:
                C0862a c0862a = new C0862a();
                mo5900a(c0862a);
                if (c0862a.f2147kp != (byte) 0) {
                    throw new C0859gt("skipField with invalid type, type value: " + b + ", " + c0862a.f2147kp);
                }
                skip(mo5893a(0, 0, true));
                return;
            default:
                throw new C0859gt("invalid type.");
        }
    }

    /* renamed from: a */
    private <T> T[] m2254a(T t, int i, boolean z) {
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 9:
                    int a = mo5893a(0, 0, true);
                    if (a < 0) {
                        throw new C0859gt("size invalid: " + a);
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = mo5911b(t, 0, true);
                    }
                    return objArr;
                case (byte) 11:
                    break;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (z) {
            throw new C0859gt("require field not exist.");
        }
        return null;
    }

    /* renamed from: b */
    private int m2255b(C0862a c0862a) {
        return C0863gw.m2251a(c0862a, this.f2148kn.duplicate());
    }

    /* renamed from: cp */
    private void m2256cp() {
        C0862a c0862a = new C0862a();
        mo5900a(c0862a);
        m2253a(c0862a.f2147kp);
    }

    private void skip(int i) {
        this.f2148kn.position(this.f2148kn.position() + i);
    }

    /* renamed from: K */
    public final boolean mo5889K(int i) {
        try {
            C0862a c0862a = new C0862a();
            while (true) {
                int b = m2255b(c0862a);
                if (i > c0862a.tag && c0862a.f2147kp != (byte) 11) {
                    skip(b);
                    m2253a(c0862a.f2147kp);
                }
            }
            return i == c0862a.tag;
        } catch (C0859gt e) {
            return false;
        } catch (BufferUnderflowException e2) {
            return false;
        }
    }

    /* renamed from: a */
    public final byte mo5890a(byte b, int i, boolean z) {
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 0:
                    return this.f2148kn.get();
                case (byte) 11:
                    return b;
                case (byte) 12:
                    return (byte) 0;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return b;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    public final double mo5891a(double d, int i, boolean z) {
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 4:
                    return (double) this.f2148kn.getFloat();
                case (byte) 5:
                    return this.f2148kn.getDouble();
                case (byte) 11:
                    return d;
                case (byte) 12:
                    return 0.0d;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return d;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    public final float mo5892a(float f, int i, boolean z) {
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 4:
                    return this.f2148kn.getFloat();
                case (byte) 11:
                    return f;
                case (byte) 12:
                    return 0.0f;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return f;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    public final int mo5893a(int i, int i2, boolean z) {
        if (mo5889K(i2)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 0:
                    return this.f2148kn.get();
                case (byte) 1:
                    return this.f2148kn.getShort();
                case (byte) 2:
                    return this.f2148kn.getInt();
                case (byte) 11:
                    return i;
                case (byte) 12:
                    return 0;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return i;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    public final long mo5894a(long j, int i, boolean z) {
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 0:
                    return (long) this.f2148kn.get();
                case (byte) 1:
                    return (long) this.f2148kn.getShort();
                case (byte) 2:
                    return (long) this.f2148kn.getInt();
                case (byte) 3:
                    return this.f2148kn.getLong();
                case (byte) 12:
                    return 0;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return j;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    public final C0597gy mo5895a(C0597gy c0597gy, int i, boolean z) {
        C0597gy c0597gy2 = null;
        if (mo5889K(i)) {
            try {
                c0597gy2 = (C0597gy) c0597gy.getClass().newInstance();
                C0862a c0862a = new C0862a();
                mo5900a(c0862a);
                if (c0862a.f2147kp != (byte) 10) {
                    throw new C0859gt("type mismatch.");
                }
                c0597gy2.mo5569a(this);
                mo5912co();
            } catch (Exception e) {
                throw new C0859gt(e.getMessage());
            }
        } else if (z) {
            throw new C0859gt("require field not exist.");
        }
        return c0597gy2;
    }

    /* renamed from: a */
    public final String mo5896a(int i, boolean z) {
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            int i2;
            byte[] bArr;
            switch (c0862a.f2147kp) {
                case (byte) 6:
                    i2 = this.f2148kn.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.f2148kn.get(bArr);
                    try {
                        return new String(bArr, this.f2149ko);
                    } catch (UnsupportedEncodingException e) {
                        return new String(bArr);
                    }
                case (byte) 7:
                    i2 = this.f2148kn.getInt();
                    if (i2 > 104857600 || i2 < 0) {
                        throw new C0859gt("String too long: " + i2);
                    }
                    bArr = new byte[i2];
                    this.f2148kn.get(bArr);
                    try {
                        return new String(bArr, this.f2149ko);
                    } catch (UnsupportedEncodingException e2) {
                        return new String(bArr);
                    }
                case (byte) 11:
                    return null;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    public final <K, V> HashMap<K, V> mo5897a(Map<K, V> map, int i, boolean z) {
        return (HashMap) m2252a(new HashMap(), map, i, z);
    }

    /* renamed from: a */
    public final <T> List<T> mo5898a(List<T> list, int i, boolean z) {
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] a = m2254a(list.get(0), i, z);
        if (a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < a.length) {
            arrayList.add(a[i2]);
            i2++;
        }
        return arrayList;
    }

    /* renamed from: a */
    public final short mo5899a(short s, int i, boolean z) {
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 0:
                    return (short) this.f2148kn.get();
                case (byte) 1:
                    return this.f2148kn.getShort();
                case (byte) 11:
                    return s;
                case (byte) 12:
                    return (short) 0;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return s;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    public final void mo5900a(C0862a c0862a) {
        C0863gw.m2251a(c0862a, this.f2148kn);
    }

    /* renamed from: a */
    public final boolean mo5901a(boolean z, int i, boolean z2) {
        return mo5890a((byte) 0, i, z2) != (byte) 0;
    }

    /* renamed from: a */
    public final byte[] mo5902a(byte[] bArr, int i, boolean z) {
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            byte[] bArr2;
            switch (c0862a.f2147kp) {
                case (byte) 9:
                    int a = mo5893a(0, 0, true);
                    if (a < 0) {
                        throw new C0859gt("size invalid: " + a);
                    }
                    bArr2 = new byte[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        bArr2[i2] = mo5890a(bArr2[0], 0, true);
                    }
                    return bArr2;
                case (byte) 11:
                    return null;
                case (byte) 13:
                    C0862a c0862a2 = new C0862a();
                    mo5900a(c0862a2);
                    if (c0862a2.f2147kp != (byte) 0) {
                        throw new C0859gt("type mismatch, tag: " + i + ", type: " + c0862a.f2147kp + ", " + c0862a2.f2147kp);
                    }
                    int a2 = mo5893a(0, 0, true);
                    if (a2 < 0) {
                        throw new C0859gt("invalid size, tag: " + i + ", type: " + c0862a.f2147kp + ", " + c0862a2.f2147kp + ", size: " + a2);
                    }
                    bArr2 = new byte[a2];
                    this.f2148kn.get(bArr2);
                    return bArr2;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0859gt("require field not exist.");
        }
    }

    /* renamed from: a */
    public final double[] mo5903a(double[] dArr, int i, boolean z) {
        double[] dArr2 = null;
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 9:
                    int a = mo5893a(0, 0, true);
                    if (a >= 0) {
                        dArr2 = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr2[i2] = mo5891a(dArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new C0859gt("size invalid: " + a);
                case (byte) 11:
                    break;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (z) {
            throw new C0859gt("require field not exist.");
        }
        return dArr2;
    }

    /* renamed from: a */
    public final float[] mo5904a(float[] fArr, int i, boolean z) {
        float[] fArr2 = null;
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 9:
                    int a = mo5893a(0, 0, true);
                    if (a >= 0) {
                        fArr2 = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr2[i2] = mo5892a(fArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new C0859gt("size invalid: " + a);
                case (byte) 11:
                    break;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (z) {
            throw new C0859gt("require field not exist.");
        }
        return fArr2;
    }

    /* renamed from: a */
    public final int[] mo5905a(int[] iArr, int i, boolean z) {
        int[] iArr2 = null;
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 9:
                    int a = mo5893a(0, 0, true);
                    if (a >= 0) {
                        iArr2 = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr2[i2] = mo5893a(iArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new C0859gt("size invalid: " + a);
                case (byte) 11:
                    break;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (z) {
            throw new C0859gt("require field not exist.");
        }
        return iArr2;
    }

    /* renamed from: a */
    public final long[] mo5906a(long[] jArr, int i, boolean z) {
        long[] jArr2 = null;
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 9:
                    int a = mo5893a(0, 0, true);
                    if (a >= 0) {
                        jArr2 = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr2[i2] = mo5894a(jArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new C0859gt("size invalid: " + a);
                case (byte) 11:
                    break;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (z) {
            throw new C0859gt("require field not exist.");
        }
        return jArr2;
    }

    /* renamed from: a */
    public final <T> T[] mo5907a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return m2254a(tArr[0], i, z);
        }
        throw new C0859gt("unable to get type of key and value.");
    }

    /* renamed from: a */
    public final short[] mo5908a(short[] sArr, int i, boolean z) {
        short[] sArr2 = null;
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 9:
                    int a = mo5893a(0, 0, true);
                    if (a >= 0) {
                        sArr2 = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr2[i2] = mo5899a(sArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new C0859gt("size invalid: " + a);
                case (byte) 11:
                    break;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (z) {
            throw new C0859gt("require field not exist.");
        }
        return sArr2;
    }

    /* renamed from: a */
    public final boolean[] mo5909a(boolean[] zArr, int i, boolean z) {
        boolean[] zArr2 = null;
        if (mo5889K(i)) {
            C0862a c0862a = new C0862a();
            mo5900a(c0862a);
            switch (c0862a.f2147kp) {
                case (byte) 9:
                    int a = mo5893a(0, 0, true);
                    if (a >= 0) {
                        zArr2 = new boolean[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            zArr2[i2] = mo5901a(zArr2[0], 0, true);
                        }
                        break;
                    }
                    throw new C0859gt("size invalid: " + a);
                case (byte) 11:
                    break;
                default:
                    throw new C0859gt("type mismatch.");
            }
        } else if (z) {
            throw new C0859gt("require field not exist.");
        }
        return zArr2;
    }

    /* renamed from: au */
    public final int mo5910au(String str) {
        this.f2149ko = str;
        return 0;
    }

    /* renamed from: b */
    public final <T> Object mo5911b(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(mo5890a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(mo5901a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(mo5899a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(mo5893a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(mo5894a(0, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(mo5892a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(mo5891a(0.0d, i, z));
        }
        if (t instanceof String) {
            return mo5896a(i, z);
        }
        if (t instanceof Map) {
            return mo5897a((Map) t, i, z);
        }
        if (t instanceof List) {
            return mo5898a((List) t, i, z);
        }
        if (t instanceof C0597gy) {
            return mo5895a((C0597gy) t, i, z);
        }
        if (t.getClass().isArray()) {
            return ((t instanceof byte[]) || (t instanceof Byte[])) ? mo5902a(null, i, z) : t instanceof boolean[] ? mo5909a(null, i, z) : t instanceof short[] ? mo5908a(null, i, z) : t instanceof int[] ? mo5905a(null, i, z) : t instanceof long[] ? mo5906a(null, i, z) : t instanceof float[] ? mo5904a(null, i, z) : t instanceof double[] ? mo5903a(null, i, z) : mo5907a((Object[]) t, i, z);
        } else {
            throw new C0859gt("read object error: unsupport type.");
        }
    }

    /* renamed from: co */
    public final void mo5912co() {
        C0862a c0862a = new C0862a();
        while (this.f2148kn.remaining() != 0) {
            mo5900a(c0862a);
            m2253a(c0862a.f2147kp);
            if (c0862a.f2147kp == (byte) 11) {
                return;
            }
        }
    }

    /* renamed from: o */
    public final void mo5913o(byte[] bArr) {
        this.f2148kn = ByteBuffer.wrap(bArr);
    }
}
