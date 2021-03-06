package net.tsz.afinal.core;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

public class Arrays {
    static final /* synthetic */ boolean $assertionsDisabled = (!Arrays.class.desiredAssertionStatus());

    private static class ArrayList<E> extends AbstractList<E> implements Serializable, List<E>, RandomAccess {
        private static final long serialVersionUID = -2764017481108945198L;
        /* renamed from: a */
        private final E[] f5203a;

        ArrayList(E[] eArr) {
            if (eArr == null) {
                throw new NullPointerException();
            }
            this.f5203a = eArr;
        }

        public boolean contains(Object obj) {
            if (obj != null) {
                for (Object equals : this.f5203a) {
                    if (obj.equals(equals)) {
                        return true;
                    }
                }
            } else {
                for (Object equals2 : this.f5203a) {
                    if (equals2 == null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public E get(int i) {
            try {
                return this.f5203a[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw e;
            }
        }

        public int indexOf(Object obj) {
            int i = 0;
            if (obj != null) {
                while (i < this.f5203a.length) {
                    if (obj.equals(this.f5203a[i])) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < this.f5203a.length) {
                    if (this.f5203a[i] == null) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            int length;
            if (obj != null) {
                for (length = this.f5203a.length - 1; length >= 0; length--) {
                    if (obj.equals(this.f5203a[length])) {
                        return length;
                    }
                }
            } else {
                for (length = this.f5203a.length - 1; length >= 0; length--) {
                    if (this.f5203a[length] == null) {
                        return length;
                    }
                }
            }
            return -1;
        }

        public E set(int i, E e) {
            E e2 = this.f5203a[i];
            this.f5203a[i] = e;
            return e2;
        }

        public int size() {
            return this.f5203a.length;
        }

        public Object[] toArray() {
            return (Object[]) this.f5203a.clone();
        }

        public <T> T[] toArray(T[] tArr) {
            int size = size();
            Object obj = size > tArr.length ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size) : tArr;
            System.arraycopy(this.f5203a, 0, obj, 0, size);
            if (size < obj.length) {
                obj[size] = null;
            }
            return obj;
        }
    }

    private Arrays() {
    }

    public static <T> List<T> asList(T... tArr) {
        return new ArrayList(tArr);
    }

    public static int binarySearch(byte[] bArr, byte b) {
        return binarySearch(bArr, 0, bArr.length, b);
    }

    public static int binarySearch(byte[] bArr, int i, int i2, byte b) {
        checkBinarySearchBounds(i, i2, bArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            byte b2 = bArr[i4];
            if (b2 < b) {
                i = i4 + 1;
            } else if (b2 <= b) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i ^ -1;
    }

    public static int binarySearch(char[] cArr, char c) {
        return binarySearch(cArr, 0, cArr.length, c);
    }

    public static int binarySearch(char[] cArr, int i, int i2, char c) {
        checkBinarySearchBounds(i, i2, cArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            char c2 = cArr[i4];
            if (c2 < c) {
                i = i4 + 1;
            } else if (c2 <= c) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i ^ -1;
    }

    public static int binarySearch(double[] dArr, double d) {
        return binarySearch(dArr, 0, dArr.length, d);
    }

    public static int binarySearch(double[] dArr, int i, int i2, double d) {
        checkBinarySearchBounds(i, i2, dArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            double d2 = dArr[i4];
            if (d2 < d) {
                i = i4 + 1;
            } else if (d2 > d) {
                i3 = i4 - 1;
            } else if (d2 != 0.0d && d2 == d) {
                return i4;
            } else {
                long doubleToLongBits = Double.doubleToLongBits(d2);
                long doubleToLongBits2 = Double.doubleToLongBits(d);
                if (doubleToLongBits < doubleToLongBits2) {
                    i = i4 + 1;
                } else if (doubleToLongBits <= doubleToLongBits2) {
                    return i4;
                } else {
                    i3 = i4 - 1;
                }
            }
        }
        return i ^ -1;
    }

    public static int binarySearch(float[] fArr, float f) {
        return binarySearch(fArr, 0, fArr.length, f);
    }

    public static int binarySearch(float[] fArr, int i, int i2, float f) {
        checkBinarySearchBounds(i, i2, fArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            float f2 = fArr[i4];
            if (f2 < f) {
                i = i4 + 1;
            } else if (f2 > f) {
                i3 = i4 - 1;
            } else if (f2 != 0.0f && f2 == f) {
                return i4;
            } else {
                int floatToIntBits = Float.floatToIntBits(f2);
                int floatToIntBits2 = Float.floatToIntBits(f);
                if (floatToIntBits < floatToIntBits2) {
                    i = i4 + 1;
                } else if (floatToIntBits <= floatToIntBits2) {
                    return i4;
                } else {
                    i3 = i4 - 1;
                }
            }
        }
        return i ^ -1;
    }

    public static int binarySearch(int[] iArr, int i) {
        return binarySearch(iArr, 0, iArr.length, i);
    }

    public static int binarySearch(int[] iArr, int i, int i2, int i3) {
        checkBinarySearchBounds(i, i2, iArr.length);
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i3) {
                i = i5 + 1;
            } else if (i6 <= i3) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i ^ -1;
    }

    public static int binarySearch(long[] jArr, int i, int i2, long j) {
        checkBinarySearchBounds(i, i2, jArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i = i4 + 1;
            } else if (j2 <= j) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i ^ -1;
    }

    public static int binarySearch(long[] jArr, long j) {
        return binarySearch(jArr, 0, jArr.length, j);
    }

    public static int binarySearch(Object[] objArr, int i, int i2, Object obj) {
        checkBinarySearchBounds(i, i2, objArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compareTo = ((Comparable) objArr[i4]).compareTo(obj);
            if (compareTo < 0) {
                i = i4 + 1;
            } else if (compareTo <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i ^ -1;
    }

    public static <T> int binarySearch(T[] tArr, int i, int i2, T t, Comparator<? super T> comparator) {
        if (comparator == null) {
            return binarySearch((Object[]) tArr, i, i2, (Object) t);
        }
        checkBinarySearchBounds(i, i2, tArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compare = comparator.compare(tArr[i4], t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i ^ -1;
    }

    public static int binarySearch(Object[] objArr, Object obj) {
        return binarySearch(objArr, 0, objArr.length, obj);
    }

    public static <T> int binarySearch(T[] tArr, T t, Comparator<? super T> comparator) {
        return binarySearch(tArr, 0, tArr.length, t, comparator);
    }

    public static int binarySearch(short[] sArr, int i, int i2, short s) {
        checkBinarySearchBounds(i, i2, sArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            short s2 = sArr[i4];
            if (s2 < s) {
                i = i4 + 1;
            } else if (s2 <= s) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i ^ -1;
    }

    public static int binarySearch(short[] sArr, short s) {
        return binarySearch(sArr, 0, sArr.length, s);
    }

    private static void checkBinarySearchBounds(int i, int i2, int i3) {
        if (i > i2) {
            throw new IllegalArgumentException();
        } else if (i < 0 || i2 > i3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static byte[] copyOf(byte[] bArr, int i) {
        if (i >= 0) {
            return copyOfRange(bArr, 0, i);
        }
        throw new NegativeArraySizeException();
    }

    public static char[] copyOf(char[] cArr, int i) {
        if (i >= 0) {
            return copyOfRange(cArr, 0, i);
        }
        throw new NegativeArraySizeException();
    }

    public static double[] copyOf(double[] dArr, int i) {
        if (i >= 0) {
            return copyOfRange(dArr, 0, i);
        }
        throw new NegativeArraySizeException();
    }

    public static float[] copyOf(float[] fArr, int i) {
        if (i >= 0) {
            return copyOfRange(fArr, 0, i);
        }
        throw new NegativeArraySizeException();
    }

    public static int[] copyOf(int[] iArr, int i) {
        if (i >= 0) {
            return copyOfRange(iArr, 0, i);
        }
        throw new NegativeArraySizeException();
    }

    public static long[] copyOf(long[] jArr, int i) {
        if (i >= 0) {
            return copyOfRange(jArr, 0, i);
        }
        throw new NegativeArraySizeException();
    }

    public static <T> T[] copyOf(T[] tArr, int i) {
        if (tArr == null) {
            throw new NullPointerException();
        } else if (i >= 0) {
            return copyOfRange((Object[]) tArr, 0, i);
        } else {
            throw new NegativeArraySizeException();
        }
    }

    public static <T, U> T[] copyOf(U[] uArr, int i, Class<? extends T[]> cls) {
        if (i >= 0) {
            return copyOfRange(uArr, 0, i, cls);
        }
        throw new NegativeArraySizeException();
    }

    public static short[] copyOf(short[] sArr, int i) {
        if (i >= 0) {
            return copyOfRange(sArr, 0, i);
        }
        throw new NegativeArraySizeException();
    }

    public static boolean[] copyOf(boolean[] zArr, int i) {
        if (i >= 0) {
            return copyOfRange(zArr, 0, i);
        }
        throw new NegativeArraySizeException();
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new byte[i3];
        System.arraycopy(bArr, i, obj, 0, length);
        return obj;
    }

    public static char[] copyOfRange(char[] cArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = cArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new char[i3];
        System.arraycopy(cArr, i, obj, 0, length);
        return obj;
    }

    public static double[] copyOfRange(double[] dArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = dArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new double[i3];
        System.arraycopy(dArr, i, obj, 0, length);
        return obj;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new float[i3];
        System.arraycopy(fArr, i, obj, 0, length);
        return obj;
    }

    public static int[] copyOfRange(int[] iArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = iArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new int[i3];
        System.arraycopy(iArr, i, obj, 0, length);
        return obj;
    }

    public static long[] copyOfRange(long[] jArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = jArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new long[i3];
        System.arraycopy(jArr, i, obj, 0, length);
        return obj;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        } else if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3);
            System.arraycopy(tArr, i, objArr, 0, min);
            return objArr;
        }
    }

    public static <T, U> T[] copyOfRange(U[] uArr, int i, int i2, Class<? extends T[]> cls) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = uArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        Object[] objArr = (Object[]) Array.newInstance(cls.getComponentType(), i3);
        System.arraycopy(uArr, i, objArr, 0, min);
        return objArr;
    }

    public static short[] copyOfRange(short[] sArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = sArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new short[i3];
        System.arraycopy(sArr, i, obj, 0, length);
        return obj;
    }

    public static boolean[] copyOfRange(boolean[] zArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = zArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new boolean[i3];
        System.arraycopy(zArr, i, obj, 0, length);
        return obj;
    }

    public static boolean deepEquals(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (!deepEqualsElements(objArr[i], objArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean deepEqualsElements(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        Class componentType = obj.getClass().getComponentType();
        return componentType == obj2.getClass().getComponentType() ? componentType == null ? obj.equals(obj2) : !componentType.isPrimitive() ? deepEquals((Object[]) obj, (Object[]) obj2) : componentType.equals(Integer.TYPE) ? equals((int[]) obj, (int[]) obj2) : componentType.equals(Character.TYPE) ? equals((char[]) obj, (char[]) obj2) : componentType.equals(Boolean.TYPE) ? equals((boolean[]) obj, (boolean[]) obj2) : componentType.equals(Byte.TYPE) ? equals((byte[]) obj, (byte[]) obj2) : componentType.equals(Long.TYPE) ? equals((long[]) obj, (long[]) obj2) : componentType.equals(Float.TYPE) ? equals((float[]) obj, (float[]) obj2) : componentType.equals(Double.TYPE) ? equals((double[]) obj, (double[]) obj2) : equals((short[]) obj, (short[]) obj2) : false;
    }

    public static int deepHashCode(Object[] objArr) {
        int i = 0;
        if (objArr != null) {
            i = 1;
            int i2 = 0;
            while (i2 < objArr.length) {
                int deepHashCodeElement = deepHashCodeElement(objArr[i2]) + (i * 31);
                i2++;
                i = deepHashCodeElement;
            }
        }
        return i;
    }

    private static int deepHashCodeElement(Object obj) {
        if (obj == null) {
            return 0;
        }
        Class componentType = obj.getClass().getComponentType();
        return componentType == null ? obj.hashCode() : !componentType.isPrimitive() ? deepHashCode((Object[]) obj) : componentType.equals(Integer.TYPE) ? hashCode((int[]) obj) : componentType.equals(Character.TYPE) ? hashCode((char[]) obj) : componentType.equals(Boolean.TYPE) ? hashCode((boolean[]) obj) : componentType.equals(Byte.TYPE) ? hashCode((byte[]) obj) : componentType.equals(Long.TYPE) ? hashCode((long[]) obj) : componentType.equals(Float.TYPE) ? hashCode((float[]) obj) : componentType.equals(Double.TYPE) ? hashCode((double[]) obj) : hashCode((short[]) obj);
    }

    public static String deepToString(Object[] objArr) {
        if (objArr == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder(objArr.length * 9);
        deepToStringImpl(objArr, new Object[]{objArr}, stringBuilder);
        return stringBuilder.toString();
    }

    private static void deepToStringImpl(Object[] objArr, Object[] objArr2, StringBuilder stringBuilder) {
        if (objArr == null) {
            stringBuilder.append("null");
            return;
        }
        stringBuilder.append('[');
        for (int i = 0; i < objArr.length; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            Object obj = objArr[i];
            if (obj == null) {
                stringBuilder.append("null");
            } else {
                Class cls = obj.getClass();
                if (cls.isArray()) {
                    cls = cls.getComponentType();
                    if (cls.isPrimitive()) {
                        if (Boolean.TYPE.equals(cls)) {
                            stringBuilder.append(toString((boolean[]) obj));
                        } else if (Byte.TYPE.equals(cls)) {
                            stringBuilder.append(toString((byte[]) obj));
                        } else if (Character.TYPE.equals(cls)) {
                            stringBuilder.append(toString((char[]) obj));
                        } else if (Double.TYPE.equals(cls)) {
                            stringBuilder.append(toString((double[]) obj));
                        } else if (Float.TYPE.equals(cls)) {
                            stringBuilder.append(toString((float[]) obj));
                        } else if (Integer.TYPE.equals(cls)) {
                            stringBuilder.append(toString((int[]) obj));
                        } else if (Long.TYPE.equals(cls)) {
                            stringBuilder.append(toString((long[]) obj));
                        } else if (Short.TYPE.equals(cls)) {
                            stringBuilder.append(toString((short[]) obj));
                        } else {
                            throw new AssertionError();
                        }
                    } else if (!$assertionsDisabled && !(obj instanceof Object[])) {
                        throw new AssertionError();
                    } else if (deepToStringImplContains(objArr2, obj)) {
                        stringBuilder.append("[...]");
                    } else {
                        Object[] objArr3 = (Object[]) obj;
                        Object obj2 = new Object[(objArr2.length + 1)];
                        System.arraycopy(objArr2, 0, obj2, 0, objArr2.length);
                        obj2[objArr2.length] = objArr3;
                        deepToStringImpl(objArr3, obj2, stringBuilder);
                    }
                } else {
                    stringBuilder.append(objArr[i]);
                }
            }
        }
        stringBuilder.append(']');
    }

    private static boolean deepToStringImplContains(Object[] objArr, Object obj) {
        if (objArr == null || objArr.length == 0) {
            return false;
        }
        for (Object obj2 : objArr) {
            if (obj2 == obj) {
                return true;
            }
        }
        return false;
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(char[] cArr, char[] cArr2) {
        if (cArr == cArr2) {
            return true;
        }
        if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
            return false;
        }
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] != cArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(double[] dArr, double[] dArr2) {
        if (dArr == dArr2) {
            return true;
        }
        if (dArr == null || dArr2 == null || dArr.length != dArr2.length) {
            return false;
        }
        for (int i = 0; i < dArr.length; i++) {
            if (Double.doubleToLongBits(dArr[i]) != Double.doubleToLongBits(dArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        if (fArr == null || fArr2 == null || fArr.length != fArr2.length) {
            return false;
        }
        for (int i = 0; i < fArr.length; i++) {
            if (Float.floatToIntBits(fArr[i]) != Float.floatToIntBits(fArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr == iArr2) {
            return true;
        }
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return false;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        if (jArr == jArr2) {
            return true;
        }
        if (jArr == null || jArr2 == null || jArr.length != jArr2.length) {
            return false;
        }
        for (int i = 0; i < jArr.length; i++) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            Object obj2 = objArr2[i];
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(short[] sArr, short[] sArr2) {
        if (sArr == sArr2) {
            return true;
        }
        if (sArr == null || sArr2 == null || sArr.length != sArr2.length) {
            return false;
        }
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != sArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        if (zArr == zArr2) {
            return true;
        }
        if (zArr == null || zArr2 == null || zArr.length != zArr2.length) {
            return false;
        }
        for (int i = 0; i < zArr.length; i++) {
            if (zArr[i] != zArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void fill(byte[] bArr, byte b) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = b;
        }
    }

    public static void fill(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = i;
        }
    }

    public static void fill(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = obj;
        }
    }

    public static void fill(boolean[] zArr, boolean z) {
        for (int i = 0; i < zArr.length; i++) {
            zArr[i] = z;
        }
    }

    public static int hashCode(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            i = 1;
            int i2 = 0;
            while (i2 < bArr.length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public static int hashCode(char[] cArr) {
        int i = 0;
        if (cArr != null) {
            i = 1;
            int i2 = 0;
            while (i2 < cArr.length) {
                int i3 = cArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public static int hashCode(double[] dArr) {
        int i = 0;
        if (dArr != null) {
            i = 1;
            for (double doubleToLongBits : dArr) {
                long doubleToLongBits2 = Double.doubleToLongBits(doubleToLongBits);
                i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
            }
        }
        return i;
    }

    public static int hashCode(float[] fArr) {
        int i = 0;
        if (fArr != null) {
            i = 1;
            int i2 = 0;
            while (i2 < fArr.length) {
                int floatToIntBits = Float.floatToIntBits(fArr[i2]) + (i * 31);
                i2++;
                i = floatToIntBits;
            }
        }
        return i;
    }

    public static int hashCode(int[] iArr) {
        int i = 0;
        if (iArr != null) {
            i = 1;
            int i2 = 0;
            while (i2 < iArr.length) {
                int i3 = iArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public static int hashCode(long[] jArr) {
        int i = 0;
        if (jArr != null) {
            i = 1;
            for (long j : jArr) {
                i = (i * 31) + ((int) (j ^ (j >>> 32)));
            }
        }
        return i;
    }

    public static int hashCode(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        int i = 1;
        for (Object obj : objArr) {
            i = (i * 31) + (obj == null ? 0 : obj.hashCode());
        }
        return i;
    }

    public static int hashCode(short[] sArr) {
        int i = 0;
        if (sArr != null) {
            i = 1;
            int i2 = 0;
            while (i2 < sArr.length) {
                int i3 = sArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public static int hashCode(boolean[] zArr) {
        int i = 0;
        if (zArr != null) {
            i = 1;
            int i2 = 0;
            while (i2 < zArr.length) {
                i2++;
                i = (i * 31) + (zArr[i2] ? 1231 : 1237);
            }
        }
        return i;
    }

    public static String toString(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        if (bArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 6);
        stringBuilder.append('[');
        stringBuilder.append(bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(bArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(char[] cArr) {
        if (cArr == null) {
            return "null";
        }
        if (cArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(cArr.length * 3);
        stringBuilder.append('[');
        stringBuilder.append(cArr[0]);
        for (int i = 1; i < cArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(cArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(double[] dArr) {
        if (dArr == null) {
            return "null";
        }
        if (dArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(dArr.length * 7);
        stringBuilder.append('[');
        stringBuilder.append(dArr[0]);
        for (int i = 1; i < dArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(dArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(float[] fArr) {
        if (fArr == null) {
            return "null";
        }
        if (fArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(fArr.length * 7);
        stringBuilder.append('[');
        stringBuilder.append(fArr[0]);
        for (int i = 1; i < fArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(fArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(int[] iArr) {
        if (iArr == null) {
            return "null";
        }
        if (iArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(iArr.length * 6);
        stringBuilder.append('[');
        stringBuilder.append(iArr[0]);
        for (int i = 1; i < iArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(iArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(long[] jArr) {
        if (jArr == null) {
            return "null";
        }
        if (jArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(jArr.length * 6);
        stringBuilder.append('[');
        stringBuilder.append(jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(jArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(Object[] objArr) {
        if (objArr == null) {
            return "null";
        }
        if (objArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(objArr.length * 7);
        stringBuilder.append('[');
        stringBuilder.append(objArr[0]);
        for (int i = 1; i < objArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(objArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(short[] sArr) {
        if (sArr == null) {
            return "null";
        }
        if (sArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(sArr.length * 6);
        stringBuilder.append('[');
        stringBuilder.append(sArr[0]);
        for (int i = 1; i < sArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(sArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String toString(boolean[] zArr) {
        if (zArr == null) {
            return "null";
        }
        if (zArr.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(zArr.length * 7);
        stringBuilder.append('[');
        stringBuilder.append(zArr[0]);
        for (int i = 1; i < zArr.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(zArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
