package net.tsz.afinal.core;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<E> implements Collection<E> {
    protected AbstractCollection() {
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object add : collection) {
            if (add(add)) {
                z = true;
            }
        }
        return z;
    }

    public void clear() {
        Iterator it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public boolean contains(Object obj) {
        Iterator it = iterator();
        if (obj != null) {
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    return true;
                }
            }
        }
        while (it.hasNext()) {
            if (it.next() == null) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract Iterator<E> iterator();

    public boolean remove(Object obj) {
        Iterator it = iterator();
        if (obj != null) {
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public abstract int size();

    public Object[] toArray() {
        int size = size();
        int i = 0;
        Iterator it = iterator();
        Object[] objArr = new Object[size];
        while (i < size) {
            int i2 = i + 1;
            objArr[i] = it.next();
            i = i2;
        }
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        int size = size();
        int i = 0;
        if (size > tArr.length) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            tArr[i] = it.next();
            i = i2;
        }
        if (i < tArr.length) {
            tArr[i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(size() * 16);
        stringBuilder.append('[');
        Iterator it = iterator();
        while (it.hasNext()) {
            AbstractCollection next = it.next();
            if (next != this) {
                stringBuilder.append(next);
            } else {
                stringBuilder.append("(this Collection)");
            }
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
