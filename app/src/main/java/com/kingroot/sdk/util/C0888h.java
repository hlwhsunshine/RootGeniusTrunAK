package com.kingroot.sdk.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.kingroot.sdk.util.h */
public class C0888h<E> implements Queue<E> {
    /* renamed from: gk */
    private int f2215gk;
    /* renamed from: gl */
    Queue<E> f2216gl = new LinkedList();

    public C0888h(int i) {
        this.f2215gk = i;
    }

    public boolean add(E e) {
        return this.f2216gl.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return this.f2216gl.addAll(collection);
    }

    public void clear() {
        this.f2216gl.clear();
    }

    public boolean contains(Object obj) {
        return this.f2216gl.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f2216gl.containsAll(collection);
    }

    public E element() {
        return this.f2216gl.element();
    }

    public boolean isEmpty() {
        return this.f2216gl.size() == 0;
    }

    public Iterator<E> iterator() {
        return this.f2216gl.iterator();
    }

    public boolean offer(E e) {
        if (this.f2216gl.size() >= this.f2215gk) {
            this.f2216gl.poll();
        }
        return this.f2216gl.offer(e);
    }

    public E peek() {
        return this.f2216gl.peek();
    }

    public E poll() {
        return this.f2216gl.poll();
    }

    public E remove() {
        return this.f2216gl.remove();
    }

    public boolean remove(Object obj) {
        return this.f2216gl.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.f2216gl.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.f2216gl.retainAll(collection);
    }

    public int size() {
        return this.f2216gl.size();
    }

    public Object[] toArray() {
        return this.f2216gl.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f2216gl.toArray(tArr);
    }
}
