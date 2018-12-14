package net.tsz.afinal.http.entityhandler;

import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

public class FileEntityHandler {
    private boolean mStop = false;

    public Object handleEntity(HttpEntity httpEntity, EntityCallBack entityCallBack, String str, boolean z) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (this.mStop) {
            return file;
        }
        FileOutputStream fileOutputStream;
        long j = 0;
        if (z) {
            j = file.length();
            fileOutputStream = new FileOutputStream(str, true);
        } else {
            fileOutputStream = new FileOutputStream(str);
        }
        if (this.mStop) {
            return file;
        }
        InputStream content = httpEntity.getContent();
        long contentLength = httpEntity.getContentLength() + j;
        if (j >= contentLength || this.mStop) {
            return file;
        }
        byte[] bArr = new byte[1024];
        long j2 = j;
        while (!this.mStop && j2 < contentLength) {
            int read = content.read(bArr, 0, 1024);
            if (read <= 0) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
            j2 += (long) read;
            entityCallBack.callBack(contentLength, j2, false);
        }
        entityCallBack.callBack(contentLength, j2, true);
        if (!this.mStop || j2 >= contentLength) {
            return file;
        }
        throw new IOException("user stop download thread");
    }

    public boolean isStop() {
        return this.mStop;
    }

    public void setStop(boolean z) {
        this.mStop = z;
    }
}
