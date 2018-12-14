package net.tsz.afinal.p121db.sqlite;

import java.util.LinkedList;

/* renamed from: net.tsz.afinal.db.sqlite.SqlInfo */
public class SqlInfo {
    private LinkedList<Object> bindArgs;
    private String sql;

    public void addValue(Object obj) {
        if (this.bindArgs == null) {
            this.bindArgs = new LinkedList();
        }
        this.bindArgs.add(obj);
    }

    public LinkedList<Object> getBindArgs() {
        return this.bindArgs;
    }

    public Object[] getBindArgsAsArray() {
        return this.bindArgs != null ? this.bindArgs.toArray() : null;
    }

    public String[] getBindArgsAsStringArray() {
        if (this.bindArgs == null) {
            return null;
        }
        String[] strArr = new String[this.bindArgs.size()];
        for (int i = 0; i < this.bindArgs.size(); i++) {
            strArr[i] = this.bindArgs.get(i).toString();
        }
        return strArr;
    }

    public String getSql() {
        return this.sql;
    }

    public void setBindArgs(LinkedList<Object> linkedList) {
        this.bindArgs = linkedList;
    }

    public void setSql(String str) {
        this.sql = str;
    }
}
