package net.tsz.afinal.core;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> extends AbstractCollection<E> implements Serializable, Cloneable, Deque<E> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ArrayDeque.class.desiredAssertionStatus());
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;
    private transient E[] elements;
    private transient int head;
    private transient int tail;

    private class DeqIterator implements Iterator<E> {
        private int cursor;
        private int fence;
        private int lastRet;

        private DeqIterator() {
            this.cursor = ArrayDeque.this.head;
            this.fence = ArrayDeque.this.tail;
            this.lastRet = -1;
        }

        /* synthetic */ DeqIterator(ArrayDeque arrayDeque, DeqIterator deqIterator) {
            this();
        }

        public boolean hasNext() {
            return this.cursor != this.fence;
        }

        public E next() {
            if (this.cursor == this.fence) {
                throw new NoSuchElementException();
            }
            E e = ArrayDeque.this.elements[this.cursor];
            if (ArrayDeque.this.tail != this.fence || e == null) {
                throw new ConcurrentModificationException();
            }
            this.lastRet = this.cursor;
            this.cursor = (this.cursor + 1) & (ArrayDeque.this.elements.length - 1);
            return e;
        }

        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            if (ArrayDeque.this.delete(this.lastRet)) {
                this.cursor = (this.cursor - 1) & (ArrayDeque.this.elements.length - 1);
                this.fence = ArrayDeque.this.tail;
            }
            this.lastRet = -1;
        }
    }

    private class DescendingIterator implements Iterator<E> {
        private int cursor;
        private int fence;
        private int lastRet;

        private DescendingIterator() {
            this.cursor = ArrayDeque.this.tail;
            this.fence = ArrayDeque.this.head;
            this.lastRet = -1;
        }

        /* synthetic */ DescendingIterator(ArrayDeque arrayDeque, DescendingIterator descendingIterator) {
            this();
        }

        public boolean hasNext() {
            return this.cursor != this.fence;
        }

        public E next() {
            if (this.cursor == this.fence) {
                throw new NoSuchElementException();
            }
            this.cursor = (this.cursor - 1) & (ArrayDeque.this.elements.length - 1);
            E e = ArrayDeque.this.elements[this.cursor];
            if (ArrayDeque.this.head != this.fence || e == null) {
                throw new ConcurrentModificationException();
            }
            this.lastRet = this.cursor;
            return e;
        }

        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            if (!ArrayDeque.this.delete(this.lastRet)) {
                this.cursor = (this.cursor + 1) & (ArrayDeque.this.elements.length - 1);
                this.fence = ArrayDeque.this.head;
            }
            this.lastRet = -1;
        }
    }

    public ArrayDeque() {
        this.elements = new Object[16];
    }

    public ArrayDeque(int i) {
        allocateElements(i);
    }

    public ArrayDeque(Collection<? extends E> collection) {
        allocateElements(collection.size());
        addAll(collection);
    }

    private void allocateElements(int i) {
        int i2 = 8;
        if (i >= 8) {
            i2 = (i >>> 1) | i;
            i2 |= i2 >>> 2;
            i2 |= i2 >>> 4;
            i2 |= i2 >>> 8;
            i2 = (i2 | (i2 >>> 16)) + 1;
            if (i2 < 0) {
                i2 >>>= 1;
            }
        }
        this.elements = new Object[i2];
    }

    private void checkInvariants() {
        if (!$assertionsDisabled && this.elements[this.tail] != null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && (!this.head != this.tail ? this.elements[this.head] != null : this.elements[this.head] == null || this.elements[(this.tail - 1) & (this.elements.length - 1)] == null)) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && this.elements[(this.head - 1) & (this.elements.length - 1)] != null) {
            throw new AssertionError();
        }
    }

    private <T> T[] copyElements(T[] tArr) {
        if (this.head < this.tail) {
            System.arraycopy(this.elements, this.head, tArr, 0, size());
        } else if (this.head > this.tail) {
            int length = this.elements.length - this.head;
            System.arraycopy(this.elements, this.head, tArr, 0, length);
            System.arraycopy(this.elements, 0, tArr, length, this.tail);
        }
        return tArr;
    }

    private boolean delete(int i) {
        checkInvariants();
        Object obj = this.elements;
        int length = obj.length - 1;
        int i2 = this.head;
        int i3 = this.tail;
        int i4 = (i - i2) & length;
        int i5 = (i3 - i) & length;
        if (i4 >= ((i3 - i2) & length)) {
            throw new ConcurrentModificationException();
        } else if (i4 < i5) {
            if (i2 <= i) {
                System.arraycopy(obj, i2, obj, i2 + 1, i4);
            } else {
                System.arraycopy(obj, 0, obj, 1, i);
                obj[0] = obj[length];
                System.arraycopy(obj, i2, obj, i2 + 1, length - i2);
            }
            obj[i2] = null;
            this.head = (i2 + 1) & length;
            return false;
        } else {
            if (i < i3) {
                System.arraycopy(obj, i + 1, obj, i, i5);
                this.tail = i3 - 1;
            } else {
                System.arraycopy(obj, i + 1, obj, i, length - i);
                obj[length] = obj[0];
                System.arraycopy(obj, 1, obj, 0, i3);
                this.tail = (i3 - 1) & length;
            }
            return true;
        }
    }

    private void doubleCapacity() {
        if ($assertionsDisabled || this.head == this.tail) {
            int i = this.head;
            int length = this.elements.length;
            int i2 = length - i;
            int i3 = length << 1;
            if (i3 < 0) {
                throw new IllegalStateException("Sorry, deque too big");
            }
            Object obj = new Object[i3];
            System.arraycopy(this.elements, i, obj, 0, i2);
            System.arraycopy(this.elements, 0, obj, i2, i);
            this.elements = obj;
            this.head = 0;
            this.tail = length;
            return;
        }
        throw new AssertionError();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int i = 0;
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        allocateElements(readInt);
        this.head = 0;
        this.tail = readInt;
        while (i < readInt) {
            this.elements[i] = objectInputStream.readObject();
            i++;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        int length = this.elements.length - 1;
        for (int i = this.head; i != this.tail; i = (i + 1) & length) {
            objectOutputStream.writeObject(this.elements[i]);
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Object[] objArr = this.elements;
        int length = (this.head - 1) & (this.elements.length - 1);
        this.head = length;
        objArr[length] = e;
        if (this.head == this.tail) {
            doubleCapacity();
        }
    }

    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        this.elements[this.tail] = e;
        int length = (this.tail + 1) & (this.elements.length - 1);
        this.tail = length;
        if (length == this.head) {
            doubleCapacity();
        }
    }

    public void clear() {
        int i = this.head;
        int i2 = this.tail;
        if (i != i2) {
            this.tail = 0;
            this.head = 0;
            int length = this.elements.length - 1;
            do {
                this.elements[i] = null;
                i = (i + 1) & length;
            } while (i != i2);
        }
    }

    public ArrayDeque<E> clone() {
        try {
            ArrayDeque<E> arrayDeque = (ArrayDeque) super.clone();
            arrayDeque.elements = Arrays.copyOf(this.elements, this.elements.length);
            return arrayDeque;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.elements.length - 1;
        int i = this.head;
        while (true) {
            Object obj2 = this.elements[i];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                return true;
            }
            i = (i + 1) & length;
        }
    }

    public Iterator<E> descendingIterator() {
        return new DescendingIterator(this, null);
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E e = this.elements[this.head];
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E e = this.elements[(this.tail - 1) & (this.elements.length - 1)];
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public Iterator<E> iterator() {
        return new DeqIterator(this, null);
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        return this.elements[this.head];
    }

    public E peekLast() {
        return this.elements[(this.tail - 1) & (this.elements.length - 1)];
    }

    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {
        int i = this.head;
        E e = this.elements[i];
        if (e == null) {
            return null;
        }
        this.elements[i] = null;
        this.head = (i + 1) & (this.elements.length - 1);
        return e;
    }

    public E pollLast() {
        int length = (this.elements.length - 1) & (this.tail - 1);
        E e = this.elements[length];
        if (e == null) {
            return null;
        }
        this.elements[length] = null;
        this.tail = length;
        return e;
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e) {
        addFirst(e);
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
        int length = this.elements.length - 1;
        int i = this.head;
        while (true) {
            Object obj2 = this.elements[i];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                delete(i);
                return true;
            }
            i = (i + 1) & length;
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
        int length = this.elements.length - 1;
        int i = this.tail;
        while (true) {
            i = (i - 1) & length;
            Object obj2 = this.elements[i];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                delete(i);
                return true;
            }
        }
    }

    public int size() {
        return (this.tail - this.head) & (this.elements.length - 1);
    }

    public Object[] toArray() {
        return copyElements(new Object[size()]);
    }

    public <T> T[] toArray(T[] tArr) {
        int size = size();
        T[] tArr2 = tArr.length < size ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size) : tArr;
        copyElements(tArr2);
        if (tArr2.length > size) {
            tArr2[size] = null;
        }
        return tArr2;
    }
}
