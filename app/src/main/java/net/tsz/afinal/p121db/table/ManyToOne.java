package net.tsz.afinal.p121db.table;

/* renamed from: net.tsz.afinal.db.table.ManyToOne */
public class ManyToOne extends Property {
    private Class<?> manyClass;

    public Class<?> getManyClass() {
        return this.manyClass;
    }

    public void setManyClass(Class<?> cls) {
        this.manyClass = cls;
    }
}
