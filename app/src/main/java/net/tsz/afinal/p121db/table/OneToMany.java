package net.tsz.afinal.p121db.table;

/* renamed from: net.tsz.afinal.db.table.OneToMany */
public class OneToMany extends Property {
    private Class<?> oneClass;

    public Class<?> getOneClass() {
        return this.oneClass;
    }

    public void setOneClass(Class<?> cls) {
        this.oneClass = cls;
    }
}
