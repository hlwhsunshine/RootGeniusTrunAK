package com.baidu.mobads.p034h;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Base64;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p034h.C0307g.C0304a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FilenameFilter;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.baidu.mobads.h.b */
public class C0298b extends File {
    /* renamed from: a */
    private C0302e f544a;
    /* renamed from: b */
    private Class<?> f545b;
    /* renamed from: c */
    private Context f546c;
    /* renamed from: d */
    private PublicKey f547d;
    /* renamed from: e */
    private IXAdLogger f548e;

    /* renamed from: com.baidu.mobads.h.b$a */
    class C0297a implements FilenameFilter {
        C0297a() {
        }

        public boolean accept(File file, String str) {
            return true;
        }
    }

    public C0298b(String str, Context context) {
        this(str, context, null);
    }

    public C0298b(String str, Context context, C0302e c0302e) {
        super(str);
        this.f545b = null;
        this.f546c = null;
        this.f548e = C0338m.m569a().mo5033f();
        this.f546c = context;
        this.f544a = c0302e;
        if (c0302e != null) {
            try {
                this.f547d = C0298b.m410c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception e) {
                this.f547d = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c A:{SYNTHETIC, Splitter: B:29:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081 A:{SYNTHETIC, Splitter: B:22:0x0081} */
    /* renamed from: a */
    private java.lang.String m407a(java.io.File r11) {
        /*
        r10 = this;
        r9 = 2;
        r8 = 1;
        r3 = 0;
        r2 = 0;
        r0 = "";
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0067, all -> 0x0098 }
        r1.<init>(r11);	 Catch:{ Exception -> 0x0067, all -> 0x0098 }
        r2 = "MD5";
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ Exception -> 0x00b5 }
        r4 = new java.security.DigestInputStream;	 Catch:{ Exception -> 0x00b5 }
        r4.<init>(r1, r2);	 Catch:{ Exception -> 0x00b5 }
        r5 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x00b5 }
    L_0x001a:
        r6 = r4.read(r5);	 Catch:{ Exception -> 0x00b5 }
        r7 = -1;
        if (r6 != r7) goto L_0x001a;
    L_0x0021:
        r5 = r2.digest();	 Catch:{ Exception -> 0x00b5 }
        r2 = r3;
    L_0x0026:
        r4 = r5.length;	 Catch:{ Exception -> 0x00b5 }
        if (r2 >= r4) goto L_0x0050;
    L_0x0029:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b5 }
        r4.<init>();	 Catch:{ Exception -> 0x00b5 }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r4 = r5[r2];	 Catch:{ Exception -> 0x00b5 }
        r4 = r4 & 255;
        r4 = r4 + 256;
        r6 = 16;
        r4 = java.lang.Integer.toString(r4, r6);	 Catch:{ Exception -> 0x00b5 }
        r6 = 1;
        r4 = r4.substring(r6);	 Catch:{ Exception -> 0x00b5 }
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x00b5 }
        r4 = r0.toString();	 Catch:{ Exception -> 0x00b5 }
        r0 = r2 + 1;
        r2 = r0;
        r0 = r4;
        goto L_0x0026;
    L_0x0050:
        r1.close();	 Catch:{ Exception -> 0x0054 }
    L_0x0053:
        return r0;
    L_0x0054:
        r1 = move-exception;
        r2 = r10.f548e;
        r4 = new java.lang.Object[r9];
        r5 = "XAdLocalApkFile";
        r4[r3] = r5;
        r1 = r1.getMessage();
        r4[r8] = r1;
        r2.mo4929e(r4);
        goto L_0x0053;
    L_0x0067:
        r0 = move-exception;
        r1 = r2;
    L_0x0069:
        r2 = r10.f548e;	 Catch:{ all -> 0x00b3 }
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00b3 }
        r5 = 0;
        r6 = "XAdLocalApkFile";
        r4[r5] = r6;	 Catch:{ all -> 0x00b3 }
        r5 = 1;
        r0 = r0.getMessage();	 Catch:{ all -> 0x00b3 }
        r4[r5] = r0;	 Catch:{ all -> 0x00b3 }
        r2.mo4929e(r4);	 Catch:{ all -> 0x00b3 }
        r0 = "";
        if (r1 == 0) goto L_0x0053;
    L_0x0081:
        r1.close();	 Catch:{ Exception -> 0x0085 }
        goto L_0x0053;
    L_0x0085:
        r1 = move-exception;
        r2 = r10.f548e;
        r4 = new java.lang.Object[r9];
        r5 = "XAdLocalApkFile";
        r4[r3] = r5;
        r1 = r1.getMessage();
        r4[r8] = r1;
        r2.mo4929e(r4);
        goto L_0x0053;
    L_0x0098:
        r0 = move-exception;
        r1 = r2;
    L_0x009a:
        if (r1 == 0) goto L_0x009f;
    L_0x009c:
        r1.close();	 Catch:{ Exception -> 0x00a0 }
    L_0x009f:
        throw r0;
    L_0x00a0:
        r1 = move-exception;
        r2 = r10.f548e;
        r4 = new java.lang.Object[r9];
        r5 = "XAdLocalApkFile";
        r4[r3] = r5;
        r1 = r1.getMessage();
        r4[r8] = r1;
        r2.mo4929e(r4);
        goto L_0x009f;
    L_0x00b3:
        r0 = move-exception;
        goto L_0x009a;
    L_0x00b5:
        r0 = move-exception;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.h.b.a(java.io.File):java.lang.String");
    }

    @TargetApi(14)
    /* renamed from: b */
    private Class<?> m408b(File file) {
        Class<?> cls;
        this.f548e.mo4922d("XAdLocalApkFile", "Android version:" + VERSION.RELEASE);
        String absolutePath;
        try {
            synchronized (C0307g.class) {
                absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.f546c.getFilesDir().getAbsolutePath();
                ClassLoader dexClassLoader = new DexClassLoader(absolutePath, absolutePath2, null, classLoader);
                this.f548e.mo4931i("XAdLocalApkFile", "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", loader=" + dexClassLoader + ", len=" + file.length() + ", list=" + file.list());
                cls = Class.forName("com.baidu.mobads.container.AllInOneXAdContainerFactory", true, dexClassLoader);
            }
            m411d();
        } catch (Exception e) {
            try {
                absolutePath = e.getMessage();
                this.f548e.mo4929e("XAdLocalApkFile", absolutePath);
                cls = null;
            } finally {
                m411d();
            }
        }
        this.f548e.mo4931i("XAdLocalApkFile", "jar.path=" + file.getAbsolutePath() + ", clz=" + cls);
        return cls;
    }

    /* renamed from: b */
    private String m409b(String str) {
        if (this.f547d != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                instance.init(2, this.f547d);
                return new String(instance.doFinal(decode), "UTF-8").trim();
            } catch (Throwable e) {
                this.f548e.mo4927e("ErrorWhileVerifySigNature", e);
            }
        }
        return null;
    }

    /* renamed from: c */
    private static PublicKey m410c(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException e2) {
            throw new Exception("InvalidKeySpecException");
        } catch (NullPointerException e3) {
            throw new Exception("NullPointerException");
        }
    }

    /* renamed from: d */
    private void m411d() {
        File[] listFiles = this.f546c.getFilesDir().listFiles(new C0297a());
        int i = 0;
        while (listFiles != null && i < listFiles.length) {
            if (listFiles[i].getAbsolutePath().contains("__xadsdk__remote__final__")) {
                new StringBuilder("clearDexCacheFiles-->").append(i).append("--").append(listFiles[i].getAbsolutePath());
                listFiles[i].delete();
            }
            i++;
        }
    }

    /* renamed from: a */
    protected void mo4482a() {
        if (this.f544a != null) {
            String a = m407a(new File(getAbsolutePath()));
            String b = m409b(this.f544a.mo4493d());
            if (!b.equalsIgnoreCase(a)) {
                throw new C0304a("doCheckApkIntegrity failed, md5sum: " + a + ", checksum in json info: " + b);
            }
        }
    }

    /* renamed from: a */
    protected void mo4483a(String str) {
        renameTo(new File(str));
    }

    /* renamed from: b */
    protected Class<?> mo4484b() {
        if (this.f545b == null) {
            File file = new File(getAbsolutePath());
            try {
                this.f545b = m408b(file);
            } finally {
                file.delete();
            }
        }
        return this.f545b;
    }

    /* renamed from: c */
    protected double mo4485c() {
        return this.f544a == null ? 0.0d : this.f544a.mo4491b();
    }
}
