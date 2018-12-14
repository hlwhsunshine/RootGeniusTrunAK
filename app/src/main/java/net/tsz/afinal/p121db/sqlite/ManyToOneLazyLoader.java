package net.tsz.afinal.p121db.sqlite;

import net.tsz.afinal.FinalDb;

/* renamed from: net.tsz.afinal.db.sqlite.ManyToOneLazyLoader */
public class ManyToOneLazyLoader<M, O> {
    /* renamed from: db */
    FinalDb f5204db;
    boolean hasLoaded = false;
    Class<M> manyClazz;
    M manyEntity;
    Class<O> oneClazz;
    O oneEntity;

    public ManyToOneLazyLoader(M m, Class<M> cls, Class<O> cls2, FinalDb finalDb) {
        this.manyEntity = m;
        this.manyClazz = cls;
        this.oneClazz = cls2;
        this.f5204db = finalDb;
    }

    public O get() {
        if (this.oneEntity == null && !this.hasLoaded) {
            this.f5204db.loadManyToOne(this.manyEntity, this.manyClazz, this.oneClazz);
            this.hasLoaded = true;
        }
        return this.oneEntity;
    }

    public void set(O o) {
        this.oneEntity = o;
    }
}
