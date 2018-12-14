package com.shuame.rootgenius.pojo;

import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class BbxCategoryInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String displayName;
    public String iconUrl;
    public int index = -1;
    public boolean isRemind = false;
    public ArrayList<Item> items = new ArrayList();
    public String name;

    public static class Item implements Serializable {
        private static final long serialVersionUID = 1;
        public String cName;
        public String description;
        public String displayName;
        public String iconUrl;
        public int index = -1;
        public String md5;
        public String name;
        public String packageName;
        public ArrayList<String> screenshots = new ArrayList();
        public long size;
        public Type type;
        public String url;

        public enum Type {
            APK,
            URL,
            MINI_OS;

            public static Type toType(String str) {
                return "apk".equalsIgnoreCase(str) ? APK : "url".equalsIgnoreCase(str) ? URL : "mini_os".equals(str) ? MINI_OS : null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Item item = (Item) obj;
            return this.name == null ? item.name == null : this.name.equals(item.name);
        }

        public int getTaskId() {
            return C1361b.m3815a(this.url);
        }

        public int hashCode() {
            return (this.name == null ? 0 : this.name.hashCode()) + 31;
        }

        public QQDownloadFile toQQDownloadFile() {
            QQDownloadFile qQDownloadFile = new QQDownloadFile();
            qQDownloadFile.f3722c = getTaskId();
            qQDownloadFile.f3724e = this.url;
            qQDownloadFile.f3727h = this.size;
            qQDownloadFile.f3726g = this.md5;
            qQDownloadFile.f3734o = com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type.APK;
            qQDownloadFile.f3739t = this.packageName;
            qQDownloadFile.f3741v = this.name;
            return qQDownloadFile;
        }

        public String toString() {
            return "Item [index=" + this.index + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", displayName=" + this.displayName + ", description=" + this.description + ", screenshots=" + this.screenshots + ", type=" + this.type + ", packageName=" + this.packageName + ", url=" + this.url + ", md5=" + this.md5 + ", size=" + this.size + "]";
        }
    }

    /* renamed from: com.shuame.rootgenius.pojo.BbxCategoryInfo$a */
    public static class C1456a implements Comparator<BbxCategoryInfo> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            BbxCategoryInfo bbxCategoryInfo = (BbxCategoryInfo) obj;
            BbxCategoryInfo bbxCategoryInfo2 = (BbxCategoryInfo) obj2;
            return bbxCategoryInfo.index < bbxCategoryInfo2.index ? -1 : bbxCategoryInfo.index > bbxCategoryInfo2.index ? 1 : 0;
        }
    }

    /* renamed from: com.shuame.rootgenius.pojo.BbxCategoryInfo$b */
    public static class C1457b implements Comparator<Item> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Item item = (Item) obj;
            Item item2 = (Item) obj2;
            return item.index < item2.index ? -1 : item.index > item2.index ? 1 : 0;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BbxCategoryInfo bbxCategoryInfo = (BbxCategoryInfo) obj;
        return this.name == null ? bbxCategoryInfo.name == null : this.name.equals(bbxCategoryInfo.name);
    }

    public int hashCode() {
        return (this.name == null ? 0 : this.name.hashCode()) + 31;
    }

    public String toString() {
        return "BbxCategoryInfo [index=" + this.index + ", name=" + this.name + ", displayName=" + this.displayName + ", iconUrl=" + this.iconUrl + ", items=" + this.items + "]";
    }
}
