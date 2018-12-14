package com.shuame.rootgenius.pojo;

import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import java.io.Serializable;

public class OptimizeInfo implements Serializable, Comparable<OptimizeInfo> {
    public static final int ERROR_CODE_DOWNLOAD_FAIL = 1;
    public static final int ERROR_CODE_INSTALL_FAIL = 2;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int TRIGER_ONE_KEY_OPTIMIZE = 1;
    public static final int TRIGER_SINGLE_CLICKED = 2;
    public static final int TRIGER_SKIP = 0;
    private static final long serialVersionUID = 1;
    public String appInfo;
    public String appType;
    public String btnText;
    public boolean isCanOptimizeItem;
    public boolean isOptimized;
    public String md5;
    public String pkgName;
    public String reportDesc;
    public int reportErrorCode = -1;
    public int reportTriger = 0;
    public int score;
    public String similarPkgs;
    public long size;
    public String threatDesc;
    public String url;

    public void addChildXml(StringBuilder stringBuilder) {
        stringBuilder.append("<item>");
        if (this.appType != null) {
            stringBuilder.append("<type>").append(this.appType).append("</type>");
        }
        if (this.pkgName != null) {
            stringBuilder.append("<package>").append(this.pkgName).append("</package>");
        }
        stringBuilder.append("<available>").append(this.isCanOptimizeItem).append("</available>");
        stringBuilder.append("<triger>").append(this.reportTriger).append("</triger>");
        stringBuilder.append("<error_code>").append(this.reportErrorCode).append("</error_code>");
        if (this.reportDesc != null) {
            stringBuilder.append("<desc>").append(this.reportDesc).append("</desc>");
        }
        stringBuilder.append("</item>");
    }

    public int compareTo(OptimizeInfo optimizeInfo) {
        return this.score > optimizeInfo.score ? -1 : this.score < optimizeInfo.score ? 1 : 0;
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
        OptimizeInfo optimizeInfo = (OptimizeInfo) obj;
        return this.pkgName == null ? optimizeInfo.pkgName == null : this.pkgName.equals(optimizeInfo.pkgName);
    }

    public int getTaskId() {
        return C1361b.m3815a(this.url);
    }

    public int hashCode() {
        return (this.pkgName == null ? 0 : this.pkgName.hashCode()) + 31;
    }

    public void revertReportParam() {
        this.isOptimized = false;
        this.isCanOptimizeItem = false;
        this.reportTriger = 0;
        this.reportErrorCode = -1;
        this.reportDesc = null;
    }

    public QQDownloadFile toQQDownloadFile() {
        QQDownloadFile qQDownloadFile = new QQDownloadFile();
        qQDownloadFile.f3722c = getTaskId();
        qQDownloadFile.f3724e = this.url;
        qQDownloadFile.f3727h = this.size;
        qQDownloadFile.f3726g = this.md5;
        qQDownloadFile.f3734o = Type.APK;
        qQDownloadFile.f3739t = this.pkgName;
        return qQDownloadFile;
    }

    public String toString() {
        return "OptimizeInfo [isOptimized=" + this.isOptimized + ", isCanOptimizeItem=" + this.isCanOptimizeItem + ", appName=" + this.appInfo + ", pkgName=" + this.pkgName + ", url=" + this.url + ", md5=" + this.md5 + ", size=" + this.size + ", appType=" + this.appType + ", similarPkgs=" + this.similarPkgs + ", threatDesc=" + this.threatDesc + ", btnText=" + this.btnText + ", score=" + this.score + ", reportTriger=" + this.reportTriger + ", reportErrorCode=" + this.reportErrorCode + ", reportDesc=" + this.reportDesc + "]";
    }
}
