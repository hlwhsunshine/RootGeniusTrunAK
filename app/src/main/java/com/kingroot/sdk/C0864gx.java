package com.kingroot.sdk;

import android.content.p013pm.PermissionInfo;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.kingroot.sdk.gx */
public class C0864gx {
    /* renamed from: kn */
    private ByteBuffer f2150kn;
    /* renamed from: ko */
    protected String f2151ko;

    public C0864gx() {
        this(128);
    }

    public C0864gx(int i) {
        this.f2151ko = "GBK";
        this.f2150kn = ByteBuffer.allocate(i);
    }

    /* renamed from: a */
    private void m2282a(Object[] objArr, int i) {
        mo5914L(8);
        mo5915a((byte) 9, i);
        mo5936f(objArr.length, 0);
        for (Object a : objArr) {
            mo5920a(a, 0);
        }
    }

    /* renamed from: L */
    public void mo5914L(int i) {
        if (this.f2150kn.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f2150kn.capacity() + i) * 2);
            allocate.put(this.f2150kn.array(), 0, this.f2150kn.position());
            this.f2150kn = allocate;
        }
    }

    /* renamed from: a */
    public void mo5915a(byte b, int i) {
        if (i < 15) {
            this.f2150kn.put((byte) ((i << 4) | b));
        } else if (i < 256) {
            this.f2150kn.put((byte) (b | PermissionInfo.PROTECTION_MASK_FLAGS));
            this.f2150kn.put((byte) i);
        } else {
            throw new C0861gv("tag is too large: " + i);
        }
    }

    /* renamed from: a */
    public void mo5916a(double d, int i) {
        mo5914L(10);
        mo5915a((byte) 5, i);
        this.f2150kn.putDouble(d);
    }

    /* renamed from: a */
    public void mo5917a(float f, int i) {
        mo5914L(6);
        mo5915a((byte) 4, i);
        this.f2150kn.putFloat(f);
    }

    /* renamed from: a */
    public void mo5918a(long j, int i) {
        mo5914L(10);
        if (j < -2147483648L || j > 2147483647L) {
            mo5915a((byte) 3, i);
            this.f2150kn.putLong(j);
            return;
        }
        mo5936f((int) j, i);
    }

    /* renamed from: a */
    public void mo5919a(C0597gy c0597gy, int i) {
        mo5914L(2);
        mo5915a((byte) 10, i);
        c0597gy.mo5570a(this);
        mo5914L(2);
        mo5915a((byte) 11, 0);
    }

    /* renamed from: a */
    public void mo5920a(Object obj, int i) {
        if (obj instanceof Byte) {
            mo5933b(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            mo5924a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            mo5923a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            mo5936f(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            mo5918a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            mo5917a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            mo5916a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            mo5935d((String) obj, i);
        } else if (obj instanceof Map) {
            mo5922a((Map) obj, i);
        } else if (obj instanceof List) {
            mo5921a((List) obj, i);
        } else if (obj instanceof C0597gy) {
            mo5919a((C0597gy) obj, i);
        } else if (obj instanceof byte[]) {
            mo5925a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            mo5931a((boolean[]) obj, i);
        } else if (obj instanceof short[]) {
            mo5930a((short[]) obj, i);
        } else if (obj instanceof int[]) {
            mo5928a((int[]) obj, i);
        } else if (obj instanceof long[]) {
            mo5929a((long[]) obj, i);
        } else if (obj instanceof float[]) {
            mo5927a((float[]) obj, i);
        } else if (obj instanceof double[]) {
            mo5926a((double[]) obj, i);
        } else if (obj.getClass().isArray()) {
            m2282a((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            mo5921a((Collection) obj, i);
        } else {
            throw new C0861gv("write object error: unsupport type. " + obj.getClass());
        }
    }

    /* renamed from: a */
    public <T> void mo5921a(Collection<T> collection, int i) {
        mo5914L(8);
        mo5915a((byte) 9, i);
        mo5936f(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T a : collection) {
                mo5920a((Object) a, 0);
            }
        }
    }

    /* renamed from: a */
    public <K, V> void mo5922a(Map<K, V> map, int i) {
        mo5914L(8);
        mo5915a((byte) 8, i);
        mo5936f(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                mo5920a(entry.getKey(), 0);
                mo5920a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    public void mo5923a(short s, int i) {
        mo5914L(4);
        if (s < (short) -128 || s > (short) 127) {
            mo5915a((byte) 1, i);
            this.f2150kn.putShort(s);
            return;
        }
        mo5933b((byte) s, i);
    }

    /* renamed from: a */
    public void mo5924a(boolean z, int i) {
        mo5933b((byte) (z ? 1 : 0), i);
    }

    /* renamed from: a */
    public void mo5925a(byte[] bArr, int i) {
        mo5914L(bArr.length + 8);
        mo5915a((byte) 13, i);
        mo5915a((byte) 0, 0);
        mo5936f(bArr.length, 0);
        this.f2150kn.put(bArr);
    }

    /* renamed from: a */
    public void mo5926a(double[] dArr, int i) {
        mo5914L(8);
        mo5915a((byte) 9, i);
        mo5936f(dArr.length, 0);
        for (double a : dArr) {
            mo5916a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo5927a(float[] fArr, int i) {
        mo5914L(8);
        mo5915a((byte) 9, i);
        mo5936f(fArr.length, 0);
        for (float a : fArr) {
            mo5917a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo5928a(int[] iArr, int i) {
        mo5914L(8);
        mo5915a((byte) 9, i);
        mo5936f(iArr.length, 0);
        for (int f : iArr) {
            mo5936f(f, 0);
        }
    }

    /* renamed from: a */
    public void mo5929a(long[] jArr, int i) {
        mo5914L(8);
        mo5915a((byte) 9, i);
        mo5936f(jArr.length, 0);
        for (long a : jArr) {
            mo5918a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo5930a(short[] sArr, int i) {
        mo5914L(8);
        mo5915a((byte) 9, i);
        mo5936f(sArr.length, 0);
        for (short a : sArr) {
            mo5923a(a, 0);
        }
    }

    /* renamed from: a */
    public void mo5931a(boolean[] zArr, int i) {
        mo5914L(8);
        mo5915a((byte) 9, i);
        mo5936f(zArr.length, 0);
        for (boolean a : zArr) {
            mo5924a(a, 0);
        }
    }

    /* renamed from: au */
    public int mo5932au(String str) {
        this.f2151ko = str;
        return 0;
    }

    /* renamed from: b */
    public void mo5933b(byte b, int i) {
        mo5914L(3);
        if (b == (byte) 0) {
            mo5915a((byte) 12, i);
            return;
        }
        mo5915a((byte) 0, i);
        this.f2150kn.put(b);
    }

    /* renamed from: cq */
    public ByteBuffer mo5934cq() {
        return this.f2150kn;
    }

    /* renamed from: d */
    public void mo5935d(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f2151ko);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        mo5914L(bytes.length + 10);
        if (bytes.length > 255) {
            mo5915a((byte) 7, i);
            this.f2150kn.putInt(bytes.length);
            this.f2150kn.put(bytes);
            return;
        }
        mo5915a((byte) 6, i);
        this.f2150kn.put((byte) bytes.length);
        this.f2150kn.put(bytes);
    }

    /* renamed from: f */
    public void mo5936f(int i, int i2) {
        mo5914L(6);
        if (i < -32768 || i > 32767) {
            mo5915a((byte) 2, i2);
            this.f2150kn.putInt(i);
            return;
        }
        mo5923a((short) i, i2);
    }

    public byte[] toByteArray() {
        Object obj = new byte[this.f2150kn.position()];
        System.arraycopy(this.f2150kn.array(), 0, obj, 0, this.f2150kn.position());
        return obj;
    }
}
