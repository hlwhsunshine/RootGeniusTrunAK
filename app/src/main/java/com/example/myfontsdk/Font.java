package com.example.myfontsdk;

import java.io.Serializable;

public class Font implements Serializable {
    private static final long serialVersionUID = 1;
    private String MD5;
    private String backUpUrl;
    private long downloadDate;
    private int downloadProgress;
    private String downloadUr;
    private String enLocalPath = "";
    private String flag;
    private int fontId;
    private String fontLocalPath = "";
    private String fontName;
    private long fontSize;
    private boolean isDownloaded;
    private boolean isHot;
    private boolean isNew;
    private boolean isUsed;
    private String lauguage;
    private String thumbnailLocalPath = "";
    private String thumbnailUrl;
    private String userName;
    private String zhLocalPath = "";

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
        return this.fontId == ((Font) obj).fontId;
    }

    public String getBackUpUrl() {
        return this.backUpUrl;
    }

    public long getDownloadDate() {
        return this.downloadDate;
    }

    public int getDownloadProgress() {
        return this.downloadProgress;
    }

    public String getDownloadUr() {
        return this.downloadUr;
    }

    public String getEnLocalPath() {
        return this.enLocalPath;
    }

    public String getFlag() {
        return this.flag;
    }

    public int getFontId() {
        return this.fontId;
    }

    public String getFontLocalPath() {
        return this.fontLocalPath;
    }

    public String getFontName() {
        return this.fontName;
    }

    public long getFontSize() {
        return this.fontSize;
    }

    public String getLauguage() {
        return this.lauguage;
    }

    public String getMD5() {
        return this.MD5;
    }

    public String getThumbnailLocalPath() {
        return this.thumbnailLocalPath;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getZhLocalPath() {
        return this.zhLocalPath;
    }

    public int hashCode() {
        return this.fontId + 31;
    }

    public boolean isDownloaded() {
        return this.isDownloaded;
    }

    public boolean isHot() {
        return this.isHot;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public boolean isUsed() {
        return this.isUsed;
    }

    public void setBackUpUrl(String str) {
        this.backUpUrl = str;
    }

    public void setDownloadDate(long j) {
        this.downloadDate = j;
    }

    public void setDownloadProgress(int i) {
        this.downloadProgress = i;
    }

    public void setDownloadUr(String str) {
        this.downloadUr = str;
    }

    public void setDownloaded(boolean z) {
        this.isDownloaded = z;
    }

    public void setEnLocalPath(String str) {
        this.enLocalPath = str;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public void setFontId(int i) {
        this.fontId = i;
    }

    public void setFontLocalPath(String str) {
        this.fontLocalPath = str;
    }

    public void setFontName(String str) {
        this.fontName = str;
    }

    public void setFontSize(long j) {
        this.fontSize = j;
    }

    public void setHot(boolean z) {
        this.isHot = z;
    }

    public void setLauguage(String str) {
        this.lauguage = str;
    }

    public void setMD5(String str) {
        this.MD5 = str;
    }

    public void setNew(boolean z) {
        this.isNew = z;
    }

    public void setThumbnailLocalPath(String str) {
        this.thumbnailLocalPath = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void setUsed(boolean z) {
        this.isUsed = z;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setZhLocalPath(String str) {
        this.zhLocalPath = str;
    }

    public String toString() {
        return "Font [fontId=" + this.fontId + ", fontName=" + this.fontName + ", fontSize=" + this.fontSize + ", userName=" + this.userName + ", downloadUr=" + this.downloadUr + ", backUpUrl=" + this.backUpUrl + ", thumbnailUrl=" + this.thumbnailUrl + ", isHot=" + this.isHot + ", isNew=" + this.isNew + ", downloadDate=" + this.downloadDate + ", fontLocalPath=" + this.fontLocalPath + ", zhLocalPath=" + this.zhLocalPath + ", enLocalPath=" + this.enLocalPath + ", thumbnailLocalPath=" + this.thumbnailLocalPath + "]";
    }
}
