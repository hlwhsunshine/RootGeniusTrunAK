package net.tsz.afinal.p121db.table;

import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: net.tsz.afinal.db.table.KeyValue */
public class KeyValue {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String key;
    private Object value;

    public KeyValue(String str, Object obj) {
        this.key = str;
        this.value = obj;
    }

    public String getKey() {
        return this.key;
    }

    public Object getValue() {
        return ((this.value instanceof Date) || (this.value instanceof java.sql.Date)) ? sdf.format(this.value) : this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
