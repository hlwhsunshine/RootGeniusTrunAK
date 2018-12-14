package com.shuame.rootgenius.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import java.util.ArrayList;

public class DownLoadFont implements Parcelable {
    public String brandIconUrl = "";
    public String currentVersionName = "";
    public long downloadCount;
    public long downloadSize;
    public String extraUuid = "";
    public String intro = "";
    public boolean isFinishDownload;
    public boolean isSpecial;
    public boolean isUpdate;
    public ArrayList<String> largeImageUrls = new ArrayList();
    public String mAndroidVersion = "";
    public String mAuthor = "";
    public long mDownTime;
    public String mUiTypeName;
    public String mUpgradeTip = "";
    public String md5 = "";
    public String name = "";
    public String path = "";
    public ArrayList<String> thumbImageUrls = new ArrayList();
    public long totalSize;
    public String updateVersionName = "";
    public String url = "";
    public int uuid = 0;

    public DownLoadFont(String str, long j, String str2, String str3) {
        this.url = str;
        this.totalSize = j;
        this.path = str2;
        this.md5 = str3;
    }

    public int describeContents() {
        return 0;
    }

    public QQDownloadFile toQQDownloadFile() {
        QQDownloadFile qQDownloadFile = new QQDownloadFile();
        qQDownloadFile.f3721b = this.uuid;
        qQDownloadFile.f3723d = this.extraUuid;
        qQDownloadFile.f3724e = this.url;
        qQDownloadFile.f3726g = this.md5;
        qQDownloadFile.f3727h = this.totalSize;
        qQDownloadFile.f3730k = this.mDownTime;
        qQDownloadFile.f3725f = this.path;
        try {
            qQDownloadFile.f3728i = (int) (((double) (this.downloadSize / this.totalSize)) * 1000.0d);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        qQDownloadFile.f3731l = this.name;
        qQDownloadFile.f3734o = Type.FONT;
        qQDownloadFile.f3736q = this.uuid;
        qQDownloadFile.f3737r = this.name;
        qQDownloadFile.f3738s = this.brandIconUrl;
        qQDownloadFile.f3742w = this.downloadCount;
        qQDownloadFile.f3743x = this.isUpdate ? 1 : 0;
        return qQDownloadFile;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
