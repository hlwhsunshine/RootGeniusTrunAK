package com.p070qq.p071e.comm.util;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.qq.e.comm.util.a */
public class C1080a {
    /* renamed from: a */
    private PublicKey f2874a;
    /* renamed from: b */
    private final boolean f2875b;

    /* renamed from: com.qq.e.comm.util.a$a */
    static final class C1079a {
        /* renamed from: a */
        public static final C1080a f2873a = new C1080a();
    }

    private C1080a() {
        boolean z;
        try {
            this.f2874a = C1080a.m3138b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable th) {
            z = false;
        }
        this.f2875b = z;
    }

    /* synthetic */ C1080a(byte b) {
        this();
    }

    /* renamed from: a */
    public static C1080a m3136a() {
        return C1079a.f2873a;
    }

    /* renamed from: a */
    private String m3137a(String str) {
        if (this.f2874a != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                instance.init(2, this.f2874a);
                return new String(instance.doFinal(decode), "UTF-8").trim();
            } catch (Throwable th) {
                GDTLogger.m3132e("ErrorWhileVerifySigNature", th);
            }
        }
        return null;
    }

    /* renamed from: b */
    private static PublicKey m3138b(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e3) {
            throw new Exception("公钥数据为空");
        }
    }

    /* renamed from: a */
    public final boolean mo6628a(String str, String str2) {
        return mo6629b(str, Md5Util.encode(str2));
    }

    /* renamed from: b */
    public final boolean mo6629b(String str, String str2) {
        if (StringUtil.isEmpty(str2)) {
            return false;
        }
        if (!this.f2875b) {
            return true;
        }
        String a = m3137a(str);
        boolean equals = str2.equals(a);
        GDTLogger.m3130d("Verify Result" + equals + "src=" + str2 + " & target=" + a);
        return equals;
    }
}
