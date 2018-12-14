package com.nostra13.universalimageloader.core.assist.deque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements C1015a<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient C1019d<E> first;
    transient C1019d<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* renamed from: com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque$a */
    private abstract class C1016a implements Iterator<E> {
        /* renamed from: a */
        C1019d<E> f2528a;
        /* renamed from: b */
        E f2529b;
        /* renamed from: d */
        private C1019d<E> f2531d;

        C1016a() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.f2528a = mo6229a();
                this.f2529b = this.f2528a == null ? null : this.f2528a.f2534a;
            } finally {
                reentrantLock.unlock();
            }
        }

        /* renamed from: b */
        private void m2878b() {
            Object obj = null;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                C1019d c1019d = this.f2528a;
                while (true) {
                    C1019d c1019d2 = c1019d;
                    c1019d = mo6230a(c1019d2);
                    if (c1019d == null) {
                        c1019d = null;
                        break;
                    } else if (c1019d.f2534a != null) {
                        break;
                    } else if (c1019d == c1019d2) {
                        c1019d = mo6229a();
                        break;
                    }
                }
                this.f2528a = c1019d;
                if (this.f2528a != null) {
                    obj = this.f2528a.f2534a;
                }
                this.f2529b = obj;
            } finally {
                reentrantLock.unlock();
            }
        }

        /* renamed from: a */
        abstract C1019d<E> mo6229a();

        /* renamed from: a */
        abstract C1019d<E> mo6230a(C1019d<E> c1019d);

        public boolean hasNext() {
            return this.f2528a != null;
        }

        public E next() {
            if (this.f2528a == null) {
                throw new NoSuchElementException();
            }
            this.f2531d = this.f2528a;
            E e = this.f2529b;
            m2878b();
            return e;
        }

        public void remove() {
            C1019d c1019d = this.f2531d;
            if (c1019d == null) {
                throw new IllegalStateException();
            }
            this.f2531d = null;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                if (c1019d.f2534a != null) {
                    LinkedBlockingDeque.this.unlink(c1019d);
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
            }
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque$b */
    private class C1017b extends C1016a {
        private C1017b() {
            super();
        }

        /* synthetic */ C1017b(LinkedBlockingDeque linkedBlockingDeque, byte b) {
            this();
        }

        /* renamed from: a */
        final C1019d<E> mo6229a() {
            return LinkedBlockingDeque.this.last;
        }

        /* renamed from: a */
        final C1019d<E> mo6230a(C1019d<E> c1019d) {
            return c1019d.f2535b;
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque$c */
    private class C1018c extends C1016a {
        private C1018c() {
            super();
        }

        /* synthetic */ C1018c(LinkedBlockingDeque linkedBlockingDeque, byte b) {
            this();
        }

        /* renamed from: a */
        final C1019d<E> mo6229a() {
            return LinkedBlockingDeque.this.first;
        }

        /* renamed from: a */
        final C1019d<E> mo6230a(C1019d<E> c1019d) {
            return c1019d.f2536c;
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque$d */
    static final class C1019d<E> {
        /* renamed from: a */
        E f2534a;
        /* renamed from: b */
        C1019d<E> f2535b;
        /* renamed from: c */
        C1019d<E> f2536c;

        C1019d(E e) {
            this.f2534a = e;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int i) {
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Object next : collection) {
                if (next == null) {
                    throw new NullPointerException();
                } else if (!linkLast(new C1019d(next))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean linkFirst(C1019d<E> c1019d) {
        if (this.count >= this.capacity) {
            return false;
        }
        C1019d c1019d2 = this.first;
        c1019d.f2536c = c1019d2;
        this.first = c1019d;
        if (this.last == null) {
            this.last = c1019d;
        } else {
            c1019d2.f2535b = c1019d;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(C1019d<E> c1019d) {
        if (this.count >= this.capacity) {
            return false;
        }
        C1019d c1019d2 = this.last;
        c1019d.f2535b = c1019d2;
        this.last = c1019d;
        if (this.first == null) {
            this.first = c1019d;
        } else {
            c1019d2.f2536c = c1019d;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private E unlinkFirst() {
        C1019d c1019d = this.first;
        if (c1019d == null) {
            return null;
        }
        C1019d c1019d2 = c1019d.f2536c;
        E e = c1019d.f2534a;
        c1019d.f2534a = null;
        c1019d.f2536c = c1019d;
        this.first = c1019d2;
        if (c1019d2 == null) {
            this.last = null;
        } else {
            c1019d2.f2535b = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        C1019d c1019d = this.last;
        if (c1019d == null) {
            return null;
        }
        C1019d c1019d2 = c1019d.f2535b;
        E e = c1019d.f2534a;
        c1019d.f2534a = null;
        c1019d.f2535b = c1019d;
        this.last = c1019d2;
        if (c1019d2 == null) {
            this.first = null;
        } else {
            c1019d2.f2536c = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (C1019d c1019d = this.first; c1019d != null; c1019d = c1019d.f2536c) {
                objectOutputStream.writeObject(c1019d.f2534a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            C1019d c1019d = this.first;
            while (c1019d != null) {
                c1019d.f2534a = null;
                C1019d c1019d2 = c1019d.f2536c;
                c1019d.f2535b = null;
                c1019d.f2536c = null;
                c1019d = c1019d2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (C1019d c1019d = this.first; c1019d != null; c1019d = c1019d.f2536c) {
                if (obj.equals(c1019d.f2534a)) {
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> descendingIterator() {
        return new C1017b(this, (byte) 0);
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection == this) {
            throw new IllegalArgumentException();
        } else {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.count);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.first.f2534a);
                    unlinkFirst();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new C1018c(this, (byte) 0);
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return offerLast(e, j, timeUnit);
    }

    public boolean offerFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1019d c1019d = new C1019d(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean linkFirst = linkFirst(c1019d);
            return linkFirst;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerFirst(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1019d c1019d = new C1019d(e);
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!linkFirst(c1019d)) {
            try {
                if (toNanos <= 0) {
                    return false;
                }
                toNanos = this.notFull.awaitNanos(toNanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public boolean offerLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1019d c1019d = new C1019d(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean linkLast = linkLast(c1019d);
            return linkLast;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerLast(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1019d c1019d = new C1019d(e);
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!linkLast(c1019d)) {
            try {
                if (toNanos <= 0) {
                    return false;
                }
                toNanos = this.notFull.awaitNanos(toNanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            E e = this.first == null ? null : this.first.f2534a;
            reentrantLock.unlock();
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            E e = this.last == null ? null : this.last.f2534a;
            reentrantLock.unlock();
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public E poll() {
        return pollFirst();
    }

    public E poll(long j, TimeUnit timeUnit) {
        return pollFirst(j, timeUnit);
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            E unlinkFirst = unlinkFirst();
            return unlinkFirst;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollFirst(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = toNanos;
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    reentrantLock.unlock();
                    return unlinkFirst;
                } else if (j2 <= 0) {
                    break;
                } else {
                    toNanos = this.notEmpty.awaitNanos(j2);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return null;
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            E unlinkLast = unlinkLast();
            return unlinkLast;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = toNanos;
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    reentrantLock.unlock();
                    return unlinkLast;
                } else if (j2 <= 0) {
                    break;
                } else {
                    toNanos = this.notEmpty.awaitNanos(j2);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return null;
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e) {
        addFirst(e);
    }

    public void put(E e) {
        putLast(e);
    }

    public void putFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1019d c1019d = new C1019d(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(c1019d)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void putLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1019d c1019d = new C1019d(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(c1019d)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.capacity - this.count;
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E remove() {
        return removeFirst();
    }

    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (C1019d c1019d = this.first; c1019d != null; c1019d = c1019d.f2536c) {
                if (obj.equals(c1019d.f2534a)) {
                    unlink(c1019d);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (C1019d c1019d = this.last; c1019d != null; c1019d = c1019d.f2535b) {
                if (obj.equals(c1019d.f2534a)) {
                    unlink(c1019d);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        return takeFirst();
    }

    public E takeFirst() {
        E unlinkFirst;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    break;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        return unlinkFirst;
    }

    public E takeLast() {
        E unlinkLast;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    break;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        return unlinkLast;
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            C1019d c1019d = this.first;
            while (c1019d != null) {
                int i2 = i + 1;
                objArr[i] = c1019d.f2534a;
                c1019d = c1019d.f2536c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count);
            }
            int i = 0;
            C1019d c1019d = this.first;
            while (c1019d != null) {
                int i2 = i + 1;
                tArr[i] = c1019d.f2534a;
                c1019d = c1019d.f2536c;
                i = i2;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            reentrantLock.unlock();
            return tArr;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            String str;
            C1019d c1019d = this.first;
            if (c1019d == null) {
                str = "[]";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('[');
                while (true) {
                    C1019d c1019d2 = c1019d;
                    Object obj = c1019d2.f2534a;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    stringBuilder.append(obj);
                    c1019d = c1019d2.f2536c;
                    if (c1019d == null) {
                        str = stringBuilder.append(']').toString();
                        reentrantLock.unlock();
                        break;
                    }
                    stringBuilder.append(',').append(' ');
                }
            }
            return str;
        } finally {
            reentrantLock.unlock();
        }
    }

    void unlink(C1019d<E> c1019d) {
        C1019d c1019d2 = c1019d.f2535b;
        C1019d c1019d3 = c1019d.f2536c;
        if (c1019d2 == null) {
            unlinkFirst();
        } else if (c1019d3 == null) {
            unlinkLast();
        } else {
            c1019d2.f2536c = c1019d3;
            c1019d3.f2535b = c1019d2;
            c1019d.f2534a = null;
            this.count--;
            this.notFull.signal();
        }
    }
}
