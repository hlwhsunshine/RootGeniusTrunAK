package net.tsz.afinal.http.entityhandler;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.HttpEntity;

public class StringEntityHandler {
    public Object handleEntity(HttpEntity httpEntity, EntityCallBack entityCallBack, String str) {
        if (httpEntity == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        long contentLength = httpEntity.getContentLength();
        long j = 0;
        InputStream content = httpEntity.getContent();
        while (true) {
            int read = content.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
            j += (long) read;
            if (entityCallBack != null) {
                entityCallBack.callBack(contentLength, j, false);
            }
        }
        if (entityCallBack != null) {
            entityCallBack.callBack(contentLength, j, true);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        content.close();
        return new String(toByteArray, str);
    }
}
