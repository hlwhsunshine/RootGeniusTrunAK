package net.tsz.afinal.p121db.sqlite;

import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDb;

/* renamed from: net.tsz.afinal.db.sqlite.OneToManyLazyLoader */
public class OneToManyLazyLoader<O, M> {
    /* renamed from: db */
    FinalDb f5205db;
    List<M> entities;
    Class<M> listItemClazz;
    Class<O> ownerClazz;
    O ownerEntity;

    public OneToManyLazyLoader(O o, Class<O> cls, Class<M> cls2, FinalDb finalDb) {
        this.ownerEntity = o;
        this.ownerClazz = cls;
        this.listItemClazz = cls2;
        this.f5205db = finalDb;
    }

    public List<M> getList() {
        if (this.entities == null) {
            this.f5205db.loadOneToMany(this.ownerEntity, this.ownerClazz, this.listItemClazz);
        }
        if (this.entities == null) {
            this.entities = new ArrayList();
        }
        return this.entities;
    }

    public void setList(List<M> list) {
        this.entities = list;
    }
}
