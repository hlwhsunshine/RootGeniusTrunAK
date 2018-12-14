package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!LinkedTreeMap.class.desiredAssertionStatus());
    private static final Comparator<Comparable> NATURAL_ORDER = new C0585u();
    Comparator<? super K> comparator;
    private C0493a entrySet;
    final C0496d<K, V> header;
    private C0494b keySet;
    int modCount;
    C0496d<K, V> root;
    int size;

    /* renamed from: com.google.gson.internal.LinkedTreeMap$a */
    class C0493a extends AbstractSet<Entry<K, V>> {
        C0493a() {
        }

        public final void clear() {
            LinkedTreeMap.this.clear();
        }

        public final boolean contains(Object obj) {
            return (obj instanceof Entry) && LinkedTreeMap.this.findByEntry((Entry) obj) != null;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new C0586v(this);
        }

        public final boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            C0496d findByEntry = LinkedTreeMap.this.findByEntry((Entry) obj);
            if (findByEntry == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public final int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap$b */
    final class C0494b extends AbstractSet<K> {
        C0494b() {
        }

        public final void clear() {
            LinkedTreeMap.this.clear();
        }

        public final boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public final Iterator<K> iterator() {
            return new C0587w(this);
        }

        public final boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        public final int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap$c */
    private abstract class C0495c<T> implements Iterator<T> {
        /* renamed from: b */
        C0496d<K, V> f1268b;
        /* renamed from: c */
        C0496d<K, V> f1269c;
        /* renamed from: d */
        int f1270d;

        private C0495c() {
            this.f1268b = LinkedTreeMap.this.header.f1275d;
            this.f1269c = null;
            this.f1270d = LinkedTreeMap.this.modCount;
        }

        /* synthetic */ C0495c(LinkedTreeMap linkedTreeMap, byte b) {
            this();
        }

        /* renamed from: a */
        final C0496d<K, V> mo5456a() {
            C0496d<K, V> c0496d = this.f1268b;
            if (c0496d == LinkedTreeMap.this.header) {
                throw new NoSuchElementException();
            } else if (LinkedTreeMap.this.modCount != this.f1270d) {
                throw new ConcurrentModificationException();
            } else {
                this.f1268b = c0496d.f1275d;
                this.f1269c = c0496d;
                return c0496d;
            }
        }

        public final boolean hasNext() {
            return this.f1268b != LinkedTreeMap.this.header;
        }

        public final void remove() {
            if (this.f1269c == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.removeInternal(this.f1269c, true);
            this.f1269c = null;
            this.f1270d = LinkedTreeMap.this.modCount;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap$d */
    static final class C0496d<K, V> implements Entry<K, V> {
        /* renamed from: a */
        C0496d<K, V> f1272a;
        /* renamed from: b */
        C0496d<K, V> f1273b;
        /* renamed from: c */
        C0496d<K, V> f1274c;
        /* renamed from: d */
        C0496d<K, V> f1275d;
        /* renamed from: e */
        C0496d<K, V> f1276e;
        /* renamed from: f */
        final K f1277f;
        /* renamed from: g */
        V f1278g;
        /* renamed from: h */
        int f1279h;

        C0496d() {
            this.f1277f = null;
            this.f1276e = this;
            this.f1275d = this;
        }

        C0496d(C0496d<K, V> c0496d, K k, C0496d<K, V> c0496d2, C0496d<K, V> c0496d3) {
            this.f1272a = c0496d;
            this.f1277f = k;
            this.f1279h = 1;
            this.f1275d = c0496d2;
            this.f1276e = c0496d3;
            c0496d3.f1275d = this;
            c0496d2.f1276e = this;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f1277f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f1277f.equals(entry.getKey())) {
                return false;
            }
            if (this.f1278g == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.f1278g.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public final K getKey() {
            return this.f1277f;
        }

        public final V getValue() {
            return this.f1278g;
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = this.f1277f == null ? 0 : this.f1277f.hashCode();
            if (this.f1278g != null) {
                i = this.f1278g.hashCode();
            }
            return hashCode ^ i;
        }

        public final V setValue(V v) {
            V v2 = this.f1278g;
            this.f1278g = v;
            return v2;
        }

        public final String toString() {
            return this.f1277f + "=" + this.f1278g;
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        Comparator comparator2;
        this.size = 0;
        this.modCount = 0;
        this.header = new C0496d();
        if (comparator2 == null) {
            comparator2 = NATURAL_ORDER;
        }
        this.comparator = comparator2;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(C0496d<K, V> c0496d, boolean z) {
        C0496d c0496d2;
        while (c0496d2 != null) {
            C0496d c0496d3 = c0496d2.f1273b;
            C0496d c0496d4 = c0496d2.f1274c;
            int i = c0496d3 != null ? c0496d3.f1279h : 0;
            int i2 = c0496d4 != null ? c0496d4.f1279h : 0;
            int i3 = i - i2;
            C0496d c0496d5;
            if (i3 == -2) {
                c0496d3 = c0496d4.f1273b;
                c0496d5 = c0496d4.f1274c;
                i2 = (c0496d3 != null ? c0496d3.f1279h : 0) - (c0496d5 != null ? c0496d5.f1279h : 0);
                if (i2 == -1 || (i2 == 0 && !z)) {
                    rotateLeft(c0496d2);
                } else if ($assertionsDisabled || i2 == 1) {
                    rotateRight(c0496d4);
                    rotateLeft(c0496d2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                c0496d4 = c0496d3.f1273b;
                c0496d5 = c0496d3.f1274c;
                i2 = (c0496d4 != null ? c0496d4.f1279h : 0) - (c0496d5 != null ? c0496d5.f1279h : 0);
                if (i2 == 1 || (i2 == 0 && !z)) {
                    rotateRight(c0496d2);
                } else if ($assertionsDisabled || i2 == -1) {
                    rotateLeft(c0496d3);
                    rotateRight(c0496d2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c0496d2.f1279h = i + 1;
                if (z) {
                    return;
                }
            } else if ($assertionsDisabled || i3 == -1 || i3 == 1) {
                c0496d2.f1279h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            c0496d2 = c0496d2.f1272a;
        }
    }

    private void replaceInParent(C0496d<K, V> c0496d, C0496d<K, V> c0496d2) {
        C0496d c0496d3 = c0496d.f1272a;
        c0496d.f1272a = null;
        if (c0496d2 != null) {
            c0496d2.f1272a = c0496d3;
        }
        if (c0496d3 == null) {
            this.root = c0496d2;
        } else if (c0496d3.f1273b == c0496d) {
            c0496d3.f1273b = c0496d2;
        } else if ($assertionsDisabled || c0496d3.f1274c == c0496d) {
            c0496d3.f1274c = c0496d2;
        } else {
            throw new AssertionError();
        }
    }

    private void rotateLeft(C0496d<K, V> c0496d) {
        int i = 0;
        C0496d c0496d2 = c0496d.f1273b;
        C0496d c0496d3 = c0496d.f1274c;
        C0496d c0496d4 = c0496d3.f1273b;
        C0496d c0496d5 = c0496d3.f1274c;
        c0496d.f1274c = c0496d4;
        if (c0496d4 != null) {
            c0496d4.f1272a = c0496d;
        }
        replaceInParent(c0496d, c0496d3);
        c0496d3.f1273b = c0496d;
        c0496d.f1272a = c0496d3;
        c0496d.f1279h = Math.max(c0496d2 != null ? c0496d2.f1279h : 0, c0496d4 != null ? c0496d4.f1279h : 0) + 1;
        int i2 = c0496d.f1279h;
        if (c0496d5 != null) {
            i = c0496d5.f1279h;
        }
        c0496d3.f1279h = Math.max(i2, i) + 1;
    }

    private void rotateRight(C0496d<K, V> c0496d) {
        int i = 0;
        C0496d c0496d2 = c0496d.f1273b;
        C0496d c0496d3 = c0496d.f1274c;
        C0496d c0496d4 = c0496d2.f1273b;
        C0496d c0496d5 = c0496d2.f1274c;
        c0496d.f1273b = c0496d5;
        if (c0496d5 != null) {
            c0496d5.f1272a = c0496d;
        }
        replaceInParent(c0496d, c0496d2);
        c0496d2.f1274c = c0496d;
        c0496d.f1272a = c0496d2;
        c0496d.f1279h = Math.max(c0496d3 != null ? c0496d3.f1279h : 0, c0496d5 != null ? c0496d5.f1279h : 0) + 1;
        int i2 = c0496d.f1279h;
        if (c0496d4 != null) {
            i = c0496d4.f1279h;
        }
        c0496d2.f1279h = Math.max(i2, i) + 1;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public final void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        C0496d c0496d = this.header;
        c0496d.f1276e = c0496d;
        c0496d.f1275d = c0496d;
    }

    public final boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public final Set<Entry<K, V>> entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        set = new C0493a();
        this.entrySet = set;
        return set;
    }

    final C0496d<K, V> find(K k, boolean z) {
        C0496d c0496d;
        int i;
        Comparator comparator = this.comparator;
        C0496d<K, V> c0496d2 = this.root;
        if (c0496d2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(c0496d2.f1277f) : comparator.compare(k, c0496d2.f1277f);
                if (compareTo != 0) {
                    C0496d<K, V> c0496d3 = compareTo < 0 ? c0496d2.f1273b : c0496d2.f1274c;
                    if (c0496d3 == null) {
                        int i2 = compareTo;
                        c0496d = c0496d2;
                        i = i2;
                        break;
                    }
                    c0496d2 = c0496d3;
                } else {
                    return c0496d2;
                }
            }
        }
        C0496d<K, V> c0496d4 = c0496d2;
        i = 0;
        if (!z) {
            return null;
        }
        C0496d<K, V> c0496d5;
        C0496d c0496d6 = this.header;
        if (c0496d4 != null) {
            c0496d5 = new C0496d(c0496d4, k, c0496d6, c0496d6.f1276e);
            if (i < 0) {
                c0496d4.f1273b = c0496d5;
            } else {
                c0496d4.f1274c = c0496d5;
            }
            rebalance(c0496d4, true);
        } else if (comparator != NATURAL_ORDER || (k instanceof Comparable)) {
            c0496d5 = new C0496d(c0496d4, k, c0496d6, c0496d6.f1276e);
            this.root = c0496d5;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.size++;
        this.modCount++;
        return c0496d5;
    }

    final C0496d<K, V> findByEntry(Entry<?, ?> entry) {
        C0496d<K, V> findByObject = findByObject(entry.getKey());
        Object obj = (findByObject == null || !equal(findByObject.f1278g, entry.getValue())) ? null : 1;
        return obj != null ? findByObject : null;
    }

    final C0496d<K, V> findByObject(Object obj) {
        C0496d<K, V> c0496d = null;
        if (obj == null) {
            return c0496d;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException e) {
            return c0496d;
        }
    }

    public final V get(Object obj) {
        C0496d findByObject = findByObject(obj);
        return findByObject != null ? findByObject.f1278g : null;
    }

    public final Set<K> keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        set = new C0494b();
        this.keySet = set;
        return set;
    }

    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C0496d find = find(k, true);
        V v2 = find.f1278g;
        find.f1278g = v;
        return v2;
    }

    public final V remove(Object obj) {
        C0496d removeInternalByKey = removeInternalByKey(obj);
        return removeInternalByKey != null ? removeInternalByKey.f1278g : null;
    }

    final void removeInternal(C0496d<K, V> c0496d, boolean z) {
        int i = 0;
        if (z) {
            c0496d.f1276e.f1275d = c0496d.f1275d;
            c0496d.f1275d.f1276e = c0496d.f1276e;
        }
        C0496d c0496d2 = c0496d.f1273b;
        C0496d c0496d3 = c0496d.f1274c;
        C0496d c0496d4 = c0496d.f1272a;
        if (c0496d2 == null || c0496d3 == null) {
            if (c0496d2 != null) {
                replaceInParent(c0496d, c0496d2);
                c0496d.f1273b = null;
            } else if (c0496d3 != null) {
                replaceInParent(c0496d, c0496d3);
                c0496d.f1274c = null;
            } else {
                replaceInParent(c0496d, null);
            }
            rebalance(c0496d4, false);
            this.size--;
            this.modCount++;
            return;
        }
        int i2;
        if (c0496d2.f1279h > c0496d3.f1279h) {
            c0496d3 = c0496d2;
            for (c0496d2 = c0496d2.f1274c; c0496d2 != null; c0496d2 = c0496d2.f1274c) {
                c0496d3 = c0496d2;
            }
        } else {
            while (true) {
                c0496d2 = c0496d3.f1273b;
                if (c0496d2 == null) {
                    break;
                }
                c0496d3 = c0496d2;
            }
        }
        removeInternal(c0496d3, false);
        c0496d4 = c0496d.f1273b;
        if (c0496d4 != null) {
            i2 = c0496d4.f1279h;
            c0496d3.f1273b = c0496d4;
            c0496d4.f1272a = c0496d3;
            c0496d.f1273b = null;
        } else {
            i2 = 0;
        }
        c0496d4 = c0496d.f1274c;
        if (c0496d4 != null) {
            i = c0496d4.f1279h;
            c0496d3.f1274c = c0496d4;
            c0496d4.f1272a = c0496d3;
            c0496d.f1274c = null;
        }
        c0496d3.f1279h = Math.max(i2, i) + 1;
        replaceInParent(c0496d, c0496d3);
    }

    final C0496d<K, V> removeInternalByKey(Object obj) {
        C0496d<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public final int size() {
        return this.size;
    }
}
