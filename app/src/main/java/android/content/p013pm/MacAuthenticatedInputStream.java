package android.content.p013pm;

import java.io.FilterInputStream;
import java.io.InputStream;
import javax.crypto.Mac;

/* renamed from: android.content.pm.MacAuthenticatedInputStream */
public class MacAuthenticatedInputStream extends FilterInputStream {
    private final Mac mMac;

    public MacAuthenticatedInputStream(InputStream inputStream, Mac mac) {
        super(inputStream);
        this.mMac = mac;
    }

    public boolean isTagEqual(byte[] bArr) {
        byte[] doFinal = this.mMac.doFinal();
        if (bArr == null || doFinal == null || bArr.length != doFinal.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ doFinal[i2];
        }
        return i == 0;
    }

    public int read() {
        int read = super.read();
        if (read >= 0) {
            this.mMac.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.mMac.update(bArr, i, read);
        }
        return read;
    }
}
