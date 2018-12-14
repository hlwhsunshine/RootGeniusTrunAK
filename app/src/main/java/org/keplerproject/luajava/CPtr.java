package org.keplerproject.luajava;

public class CPtr {
    private long peer;

    CPtr() {
    }

    public boolean equals(Object obj) {
        return obj == null ? false : obj == this ? true : CPtr.class == obj.getClass() && this.peer == ((CPtr) obj).peer;
    }

    protected long getPeer() {
        return this.peer;
    }
}
