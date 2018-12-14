package com.shuame.rootgenius.pojo;

import android.text.TextUtils;
import java.io.Serializable;

public class BbxPopInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public int dbId;
    public boolean isShowed;
    public String name;
    public int option;
    public String pic;
    public String text;
    public String title;

    public void clear() {
        this.dbId = 0;
        this.option = 0;
        this.name = null;
        this.title = null;
        this.text = null;
        this.pic = null;
        this.isShowed = false;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.name);
    }

    public String toString() {
        return "BbxPopInfo [dbId=" + this.dbId + ", option=" + this.option + ", name=" + this.name + ", title=" + this.title + ", text=" + this.text + ", pic=" + this.pic + ", isShowed=" + this.isShowed + "]";
    }
}
