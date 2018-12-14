package com.kingroot.sdk;

import android.content.Context;
import android.content.p013pm.PackageInfo;
import android.content.res.AssetManager;
import android.util.Base64;
import com.kingroot.sdk.util.C0885e;
import com.kingroot.sdk.util.C0890j;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.kingroot.sdk.y */
public class C0904y {
    /* renamed from: aq */
    private static RSAPublicKey f2229aq;
    /* renamed from: ar */
    private Properties f2230ar;

    static {
        try {
            f2229aq = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCTrqGfyNYDKZEFfvXuYOu9mSCNu6ri10PMG2xJ5sBuUN2OFBT1W5n/dyUkR+Xgnd6w9arSFnU/8fpiP4DRZPL7pkmgzJvjoPqrreXO4nGRQtVbp6sD/gWCKsTlJ9bk01W32gfSOrCNch8BQJO8nE01ffnWmyRiqVTbuh9KEGgcwIDAQAB", 0)));
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            f2229aq = null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            f2229aq = null;
        }
    }

    private C0904y(Properties properties) {
        this.f2230ar = properties;
    }

    /* renamed from: a */
    private static int m2483a(InputStream inputStream) {
        return ((inputStream.read() | (inputStream.read() << 8)) | (inputStream.read() << 16)) | (inputStream.read() << 24);
    }

    /* renamed from: a */
    public static C0904y m2484a(AssetManager assetManager, String str) {
        Throwable th;
        C0633at.m1464h("KRSDKCertificate loadFromAsset >>>>>>>>>>");
        InputStream open = assetManager.open(str, 1);
        Closeable closeable = null;
        try {
            if (C0904y.m2483a(open) != 1413698123) {
                throw new DataFormatException("Not a kingroot sdk certification file");
            }
            int a = C0904y.m2483a(open);
            byte[] bArr = new byte[C0904y.m2483a(open)];
            byte[] bArr2 = new byte[a];
            open.read(bArr);
            Inflater inflater = new Inflater();
            inflater.setInput(bArr);
            if (a != inflater.inflate(bArr2)) {
                throw new DataFormatException("Unexpected data length");
            }
            inflater.end();
            Properties properties = new Properties();
            Closeable byteArrayInputStream = new ByteArrayInputStream(bArr2);
            try {
                properties.loadFromXML(byteArrayInputStream);
                byte[] bArr3 = new byte[C0904y.m2483a(open)];
                open.read(bArr3);
                Signature instance = Signature.getInstance("SHA1WithRSA");
                instance.initVerify(f2229aq);
                instance.update(bArr);
                if (instance.verify(bArr3)) {
                    C0904y c0904y = new C0904y(properties);
                    C0885e.m2419a(byteArrayInputStream);
                    C0885e.m2419a(open);
                    return c0904y;
                }
                throw new SignatureException("Bad signature");
            } catch (Throwable th2) {
                th = th2;
                closeable = byteArrayInputStream;
                C0885e.m2419a(closeable);
                C0885e.m2419a(open);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C0885e.m2419a(closeable);
            C0885e.m2419a(open);
            throw th;
        }
    }

    /* renamed from: b */
    private static String m2485b(Context context) {
        PackageInfo a = C0905z.m2489a(context, context.getPackageName(), 64);
        if (a == null) {
            return null;
        }
        Closeable byteArrayInputStream = new ByteArrayInputStream(a.signatures[0].toByteArray());
        String f;
        try {
            f = C0890j.m2433f(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream)).getEncoded());
            return f;
        } catch (CertificateException e) {
            f = e;
            f.printStackTrace();
            return null;
        } finally {
            C0885e.m2419a(byteArrayInputStream);
        }
    }

    /* renamed from: a */
    public boolean mo5998a(Context context) {
        String b = C0904y.m2485b(context);
        if (b == null) {
            return false;
        }
        if (!context.getPackageName().equals(getPackageName())) {
            C0633at.m1465i("Certifacate Fail, PackageName wrong: " + context.getPackageName());
            return false;
        } else if (b.equals(mo6000c())) {
            C0633at.m1464h("Certifacate Succeed.");
            return true;
        } else {
            C0633at.m1465i("Certifacate Fail, PackageMD5 wrong: " + b);
            return false;
        }
    }

    /* renamed from: b */
    public String mo5999b() {
        return this.f2230ar.getProperty("channel_id");
    }

    /* renamed from: c */
    public String mo6000c() {
        return this.f2230ar.getProperty("cert_md5");
    }

    public String getPackageName() {
        return this.f2230ar.getProperty("package_name");
    }
}
