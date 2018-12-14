package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!LinkedHashTreeMap.class.desiredAssertionStatus());
    private static final Comparator<Comparable> NATURAL_ORDER = new C0582r();
    Comparator<? super K> comparator;
    private C0489c entrySet;
    final C0492f<K, V> header;
    private C0490d keySet;
    int modCount;
    int size;
    C0492f<K, V>[] table;
    int threshold;

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$a */
    static final class C0487a<K, V> {
        /* renamed from: a */
        private C0492f<K, V> f1246a;
        /* renamed from: b */
        private int f1247b;
        /* renamed from: c */
        private int f1248c;
        /* renamed from: d */
        private int f1249d;

        C0487a() {
        }

        /* renamed from: a */
        final C0492f<K, V> mo5409a() {
            C0492f<K, V> c0492f = this.f1246a;
            if (c0492f.f1257a == null) {
                return c0492f;
            }
            throw new IllegalStateException();
        }

        /* renamed from: a */
        final void mo5410a(int i) {
            this.f1247b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.f1249d = 0;
            this.f1248c = 0;
            this.f1246a = null;
        }

        /* renamed from: a */
        final void mo5411a(C0492f<K, V> c0492f) {
            c0492f.f1259c = null;
            c0492f.f1257a = null;
            c0492f.f1258b = null;
            c0492f.f1265i = 1;
            if (this.f1247b > 0 && (this.f1249d & 1) == 0) {
                this.f1249d++;
                this.f1247b--;
                this.f1248c++;
            }
            c0492f.f1257a = this.f1246a;
            this.f1246a = c0492f;
            this.f1249d++;
            if (this.f1247b > 0 && (this.f1249d & 1) == 0) {
                this.f1249d++;
                this.f1247b--;
                this.f1248c++;
            }
            for (int i = 4; (this.f1249d & (i - 1)) == i - 1; i *= 2) {
                C0492f c0492f2;
                C0492f c0492f3;
                if (this.f1248c == 0) {
                    c0492f2 = this.f1246a;
                    c0492f3 = c0492f2.f1257a;
                    C0492f c0492f4 = c0492f3.f1257a;
                    c0492f3.f1257a = c0492f4.f1257a;
                    this.f1246a = c0492f3;
                    c0492f3.f1258b = c0492f4;
                    c0492f3.f1259c = c0492f2;
                    c0492f3.f1265i = c0492f2.f1265i + 1;
                    c0492f4.f1257a = c0492f3;
                    c0492f2.f1257a = c0492f3;
                } else if (this.f1248c == 1) {
                    c0492f2 = this.f1246a;
                    c0492f3 = c0492f2.f1257a;
                    this.f1246a = c0492f3;
                    c0492f3.f1259c = c0492f2;
                    c0492f3.f1265i = c0492f2.f1265i + 1;
                    c0492f2.f1257a = c0492f3;
                    this.f1248c = 0;
                } else if (this.f1248c == 2) {
                    this.f1248c = 0;
                }
            }
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$b */
    static class C0488b<K, V> {
        /* renamed from: a */
        private C0492f<K, V> f1250a;

        C0488b() {
        }

        /* renamed from: a */
        public final C0492f<K, V> mo5412a() {
            C0492f<K, V> c0492f = this.f1250a;
            if (c0492f == null) {
                return null;
            }
            C0492f c0492f2 = c0492f.f1257a;
            c0492f.f1257a = null;
            for (C0492f c0492f3 = c0492f.f1259c; c0492f3 != null; c0492f3 = c0492f3.f1258b) {
                c0492f3.f1257a = c0492f2;
                c0492f2 = c0492f3;
            }
            this.f1250a = c0492f2;
            return c0492f;
        }

        /* renamed from: a */
        final void mo5413a(C0492f<K, V> c0492f) {
            C0492f c0492f2 = null;
            for (C0492f c0492f3 = c0492f; c0492f3 != null; c0492f3 = c0492f3.f1258b) {
                c0492f3.f1257a = c0492f2;
                c0492f2 = c0492f3;
            }
            this.f1250a = c0492f2;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$c */
    final class C0489c extends AbstractSet<Entry<K, V>> {
        C0489c() {
        }

        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public final boolean contains(Object obj) {
            return (obj instanceof Entry) && LinkedHashTreeMap.this.findByEntry((Entry) obj) != null;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new C0583s(this);
        }

        public final boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            C0492f findByEntry = LinkedHashTreeMap.this.findByEntry((Entry) obj);
            if (findByEntry == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public final int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$d */
    final class C0490d extends AbstractSet<K> {
        C0490d() {
        }

        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public final boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public final Iterator<K> iterator() {
            return new C0584t(this);
        }

        public final boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        public final int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$e */
    private abstract class C0491e<T> implements Iterator<T> {
        /* renamed from: b */
        C0492f<K, V> f1253b;
        /* renamed from: c */
        C0492f<K, V> f1254c;
        /* renamed from: d */
        int f1255d;

        private C0491e() {
            this.f1253b = LinkedHashTreeMap.this.header.f1260d;
            this.f1254c = null;
            this.f1255d = LinkedHashTreeMap.this.modCount;
        }

        /* synthetic */ C0491e(LinkedHashTreeMap linkedHashTreeMap, byte b) {
            this();
        }

        /* renamed from: a */
        final C0492f<K, V> mo5424a() {
            C0492f<K, V> c0492f = this.f1253b;
            if (c0492f == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            } else if (LinkedHashTreeMap.this.modCount != this.f1255d) {
                throw new ConcurrentModificationException();
            } else {
                this.f1253b = c0492f.f1260d;
                this.f1254c = c0492f;
                return c0492f;
            }
        }

        public final boolean hasNext() {
            return this.f1253b != LinkedHashTreeMap.this.header;
        }

        public final void remove() {
            if (this.f1254c == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(this.f1254c, true);
            this.f1254c = null;
            this.f1255d = LinkedHashTreeMap.this.modCount;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$f */
    static final class C0492f<K, V> implements Entry<K, V> {
        /* renamed from: a */
        C0492f<K, V> f1257a;
        /* renamed from: b */
        C0492f<K, V> f1258b;
        /* renamed from: c */
        C0492f<K, V> f1259c;
        /* renamed from: d */
        C0492f<K, V> f1260d;
        /* renamed from: e */
        C0492f<K, V> f1261e;
        /* renamed from: f */
        final K f1262f;
        /* renamed from: g */
        final int f1263g;
        /* renamed from: h */
        V f1264h;
        /* renamed from: i */
        int f1265i;

        C0492f() {
            this.f1262f = null;
            this.f1263g = -1;
            this.f1261e = this;
            this.f1260d = this;
        }

        C0492f(C0492f<K, V> c0492f, K k, int i, C0492f<K, V> c0492f2, C0492f<K, V> c0492f3) {
            this.f1257a = c0492f;
            this.f1262f = k;
            this.f1263g = i;
            this.f1265i = 1;
            this.f1260d = c0492f2;
            this.f1261e = c0492f3;
            c0492f3.f1260d = this;
            c0492f2.f1261e = this;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f1262f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f1262f.equals(entry.getKey())) {
                return false;
            }
            if (this.f1264h == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.f1264h.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public final K getKey() {
            return this.f1262f;
        }

        public final V getValue() {
            return this.f1264h;
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = this.f1262f == null ? 0 : this.f1262f.hashCode();
            if (this.f1264h != null) {
                i = this.f1264h.hashCode();
            }
            return hashCode ^ i;
        }

        public final V setValue(V v) {
            V v2 = this.f1264h;
            this.f1264h = v;
            return v2;
        }

        public final String toString() {
            return this.f1262f + "=" + this.f1264h;
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        Comparator comparator2;
        this.size = 0;
        this.modCount = 0;
        if (comparator2 == null) {
            comparator2 = NATURAL_ORDER;
        }
        this.comparator = comparator2;
        this.header = new C0492f();
        this.table = new C0492f[16];
        this.threshold = (this.table.length / 2) + (this.table.length / 4);
    }

    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        this.threshold = (this.table.length / 2) + (this.table.length / 4);
    }

    static <K, V> C0492f<K, V>[] doubleCapacity(C0492f<K, V>[] c0492fArr) {
        int length = c0492fArr.length;
        C0492f<K, V>[] c0492fArr2 = new C0492f[(length * 2)];
        C0488b c0488b = new C0488b();
        C0487a c0487a = new C0487a();
        C0487a c0487a2 = new C0487a();
        for (int i = 0; i < length; i++) {
            C0492f c0492f = c0492fArr[i];
            if (c0492f != null) {
                c0488b.mo5413a(c0492f);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    C0492f a = c0488b.mo5412a();
                    if (a == null) {
                        break;
                    } else if ((a.f1263g & length) == 0) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
                c0487a.mo5410a(i3);
                c0487a2.mo5410a(i2);
                c0488b.mo5413a(c0492f);
                while (true) {
                    c0492f = c0488b.mo5412a();
                    if (c0492f == null) {
                        break;
                    } else if ((c0492f.f1263g & length) == 0) {
                        c0487a.mo5411a(c0492f);
                    } else {
                        c0487a2.mo5411a(c0492f);
                    }
                }
                c0492fArr2[i] = i3 > 0 ? c0487a.mo5409a() : null;
                c0492fArr2[i + length] = i2 > 0 ? c0487a2.mo5409a() : null;
            }
        }
        return c0492fArr2;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(C0492f<K, V> c0492f, boolean z) {
        C0492f c0492f2;
        while (c0492f2 != null) {
            C0492f c0492f3 = c0492f2.f1258b;
            C0492f c0492f4 = c0492f2.f1259c;
            int i = c0492f3 != null ? c0492f3.f1265i : 0;
            int i2 = c0492f4 != null ? c0492f4.f1265i : 0;
            int i3 = i - i2;
            C0492f c0492f5;
            if (i3 == -2) {
                c0492f3 = c0492f4.f1258b;
                c0492f5 = c0492f4.f1259c;
                i2 = (c0492f3 != null ? c0492f3.f1265i : 0) - (c0492f5 != null ? c0492f5.f1265i : 0);
                if (i2 == -1 || (i2 == 0 && !z)) {
                    rotateLeft(c0492f2);
                } else if ($assertionsDisabled || i2 == 1) {
                    rotateRight(c0492f4);
                    rotateLeft(c0492f2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                c0492f4 = c0492f3.f1258b;
                c0492f5 = c0492f3.f1259c;
                i2 = (c0492f4 != null ? c0492f4.f1265i : 0) - (c0492f5 != null ? c0492f5.f1265i : 0);
                if (i2 == 1 || (i2 == 0 && !z)) {
                    rotateRight(c0492f2);
                } else if ($assertionsDisabled || i2 == -1) {
                    rotateLeft(c0492f3);
                    rotateRight(c0492f2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c0492f2.f1265i = i + 1;
                if (z) {
                    return;
                }
            } else if ($assertionsDisabled || i3 == -1 || i3 == 1) {
                c0492f2.f1265i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            c0492f2 = c0492f2.f1257a;
        }
    }

    private void replaceInParent(C0492f<K, V> c0492f, C0492f<K, V> c0492f2) {
        C0492f c0492f3 = c0492f.f1257a;
        c0492f.f1257a = null;
        if (c0492f2 != null) {
            c0492f2.f1257a = c0492f3;
        }
        if (c0492f3 == null) {
            this.table[c0492f.f1263g & (this.table.length - 1)] = c0492f2;
        } else if (c0492f3.f1258b == c0492f) {
            c0492f3.f1258b = c0492f2;
        } else if ($assertionsDisabled || c0492f3.f1259c == c0492f) {
            c0492f3.f1259c = c0492f2;
        } else {
            throw new AssertionError();
        }
    }

    private void rotateLeft(C0492f<K, V> c0492f) {
        int i = 0;
        C0492f c0492f2 = c0492f.f1258b;
        C0492f c0492f3 = c0492f.f1259c;
        C0492f c0492f4 = c0492f3.f1258b;
        C0492f c0492f5 = c0492f3.f1259c;
        c0492f.f1259c = c0492f4;
        if (c0492f4 != null) {
            c0492f4.f1257a = c0492f;
        }
        replaceInParent(c0492f, c0492f3);
        c0492f3.f1258b = c0492f;
        c0492f.f1257a = c0492f3;
        c0492f.f1265i = Math.max(c0492f2 != null ? c0492f2.f1265i : 0, c0492f4 != null ? c0492f4.f1265i : 0) + 1;
        int i2 = c0492f.f1265i;
        if (c0492f5 != null) {
            i = c0492f5.f1265i;
        }
        c0492f3.f1265i = Math.max(i2, i) + 1;
    }

    private void rotateRight(C0492f<K, V> c0492f) {
        int i = 0;
        C0492f c0492f2 = c0492f.f1258b;
        C0492f c0492f3 = c0492f.f1259c;
        C0492f c0492f4 = c0492f2.f1258b;
        C0492f c0492f5 = c0492f2.f1259c;
        c0492f.f1258b = c0492f5;
        if (c0492f5 != null) {
            c0492f5.f1257a = c0492f;
        }
        replaceInParent(c0492f, c0492f2);
        c0492f2.f1259c = c0492f;
        c0492f.f1257a = c0492f2;
        c0492f.f1265i = Math.max(c0492f3 != null ? c0492f3.f1265i : 0, c0492f5 != null ? c0492f5.f1265i : 0) + 1;
        int i2 = c0492f.f1265i;
        if (c0492f4 != null) {
            i = c0492f4.f1265i;
        }
        c0492f2.f1265i = Math.max(i2, i) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = ((i >>> 20) ^ (i >>> 12)) ^ i;
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public final void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        this.modCount++;
        C0492f c0492f = this.header;
        C0492f c0492f2 = c0492f.f1260d;
        while (c0492f2 != c0492f) {
            C0492f c0492f3 = c0492f2.f1260d;
            c0492f2.f1261e = null;
            c0492f2.f1260d = null;
            c0492f2 = c0492f3;
        }
        c0492f.f1261e = c0492f;
        c0492f.f1260d = c0492f;
    }

    public final boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public final Set<Entry<K, V>> entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        set = new C0489c();
        this.entrySet = set;
        return set;
    }

    final C0492f<K, V> find(K k, boolean z) {
        int i;
        Comparator comparator = this.comparator;
        C0492f[] c0492fArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = secondaryHash & (c0492fArr.length - 1);
        C0492f c0492f = c0492fArr[length];
        if (c0492f != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(c0492f.f1262f) : comparator.compare(k, c0492f.f1262f);
                if (compareTo != 0) {
                    C0492f c0492f2 = compareTo < 0 ? c0492f.f1258b : c0492f.f1259c;
                    if (c0492f2 == null) {
                        i = compareTo;
                        break;
                    }
                    c0492f = c0492f2;
                } else {
                    return c0492f;
                }
            }
        }
        i = 0;
        if (!z) {
            return null;
        }
        C0492f<K, V> c0492f3;
        C0492f c0492f4 = this.header;
        if (c0492f != null) {
            c0492f3 = new C0492f(c0492f, k, secondaryHash, c0492f4, c0492f4.f1261e);
            if (i < 0) {
                c0492f.f1258b = c0492f3;
            } else {
                c0492f.f1259c = c0492f3;
            }
            rebalance(c0492f, true);
        } else if (comparator != NATURAL_ORDER || (k instanceof Comparable)) {
            c0492f3 = new C0492f(c0492f, k, secondaryHash, c0492f4, c0492f4.f1261e);
            c0492fArr[length] = c0492f3;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return c0492f3;
    }

    final C0492f<K, V> findByEntry(Entry<?, ?> entry) {
        C0492f<K, V> findByObject = findByObject(entry.getKey());
        Object obj = (findByObject == null || !equal(findByObject.f1264h, entry.getValue())) ? null : 1;
        return obj != null ? findByObject : null;
    }

    final C0492f<K, V> findByObject(Object obj) {
        C0492f<K, V> c0492f = null;
        if (obj == null) {
            return c0492f;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException e) {
            return c0492f;
        }
    }

    public final V get(Object obj) {
        C0492f findByObject = findByObject(obj);
        return findByObject != null ? findByObject.f1264h : null;
    }

    public final Set<K> keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        set = new C0490d();
        this.keySet = set;
        return set;
    }

    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C0492f find = find(k, true);
        V v2 = find.f1264h;
        find.f1264h = v;
        return v2;
    }

    public final V remove(Object obj) {
        C0492f removeInternalByKey = removeInternalByKey(obj);
        return removeInternalByKey != null ? removeInternalByKey.f1264h : null;
    }

    final void removeInternal(C0492f<K, V> c0492f, boolean z) {
        int i = 0;
        if (z) {
            c0492f.f1261e.f1260d = c0492f.f1260d;
            c0492f.f1260d.f1261e = c0492f.f1261e;
            c0492f.f1261e = null;
            c0492f.f1260d = null;
        }
        C0492f c0492f2 = c0492f.f1258b;
        C0492f c0492f3 = c0492f.f1259c;
        C0492f c0492f4 = c0492f.f1257a;
        if (c0492f2 == null || c0492f3 == null) {
            if (c0492f2 != null) {
                replaceInParent(c0492f, c0492f2);
                c0492f.f1258b = null;
            } else if (c0492f3 != null) {
                replaceInParent(c0492f, c0492f3);
                c0492f.f1259c = null;
            } else {
                replaceInParent(c0492f, null);
            }
            rebalance(c0492f4, false);
            this.size--;
            this.modCount++;
            return;
        }
        int i2;
        if (c0492f2.f1265i > c0492f3.f1265i) {
            c0492f3 = c0492f2;
            for (c0492f2 = c0492f2.f1259c; c0492f2 != null; c0492f2 = c0492f2.f1259c) {
                c0492f3 = c0492f2;
            }
        } else {
            while (true) {
                c0492f2 = c0492f3.f1258b;
                if (c0492f2 == null) {
                    break;
                }
                c0492f3 = c0492f2;
            }
        }
        removeInternal(c0492f3, false);
        c0492f4 = c0492f.f1258b;
        if (c0492f4 != null) {
            i2 = c0492f4.f1265i;
            c0492f3.f1258b = c0492f4;
            c0492f4.f1257a = c0492f3;
            c0492f.f1258b = null;
        } else {
            i2 = 0;
        }
        c0492f4 = c0492f.f1259c;
        if (c0492f4 != null) {
            i = c0492f4.f1265i;
            c0492f3.f1259c = c0492f4;
            c0492f4.f1257a = c0492f3;
            c0492f.f1259c = null;
        }
        c0492f3.f1265i = Math.max(i2, i) + 1;
        replaceInParent(c0492f, c0492f3);
    }

    final C0492f<K, V> removeInternalByKey(Object obj) {
        C0492f<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public final int size() {
        return this.size;
    }
}
