package p000a.p001a.p002a.p011g;

import com.shuame.rootgenius.sdk.C1468c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.CRC32;
import p000a.p001a.p002a.p003a.C0000a;
import p000a.p001a.p002a.p004b.C0005b;
import p000a.p001a.p002a.p004b.C0006a;
import p000a.p001a.p002a.p004b.C0009c;
import p000a.p001a.p002a.p007c.C0010a;
import p000a.p001a.p002a.p008d.C0012c;
import p000a.p001a.p002a.p008d.C0013b;
import p000a.p001a.p002a.p008d.C0014d;
import p000a.p001a.p002a.p009e.C0015a;
import p000a.p001a.p002a.p009e.C0020f;
import p000a.p001a.p002a.p009e.C0021g;
import p000a.p001a.p002a.p009e.C0026l;
import p000a.p001a.p002a.p010f.C0027a;

/* renamed from: a.a.a.g.b */
public final class C0029b {
    /* renamed from: a */
    private C0026l f124a;
    /* renamed from: b */
    private C0020f f125b;
    /* renamed from: c */
    private int f126c = 0;
    /* renamed from: d */
    private C0021g f127d;
    /* renamed from: e */
    private C0005b f128e;
    /* renamed from: f */
    private CRC32 f129f;

    public C0029b(C0026l c0026l, C0020f c0020f) {
        if (c0026l == null || c0020f == null) {
            throw new C0010a("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        }
        this.f124a = c0026l;
        this.f125b = c0020f;
        this.f129f = new CRC32();
    }

    /* renamed from: a */
    private RandomAccessFile m171a(String str) {
        if (this.f124a == null || !C1468c.m4056a(this.f124a.mo149d())) {
            throw new C0010a("input parameter is null in getFilePointer");
        }
        try {
            return this.f124a.mo147c() ? m180i() : new RandomAccessFile(new File(this.f124a.mo149d()), str);
        } catch (Throwable e) {
            throw new C0010a(e);
        } catch (Throwable e2) {
            throw new C0010a(e2);
        }
    }

    /* renamed from: a */
    private String m172a(String str, String str2) {
        if (!C1468c.m4056a(null)) {
            str2 = this.f125b.mo82j();
        }
        return new StringBuffer(String.valueOf(str)).append(System.getProperty("file.separator")).append(str2).toString();
    }

    /* renamed from: a */
    private static void m173a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                if (C1468c.m4056a(e.getMessage()) && e.getMessage().indexOf(" - Wrong Password?") >= 0) {
                    throw new C0010a(e.getMessage());
                } else if (outputStream != null) {
                    try {
                        outputStream.close();
                        return;
                    } catch (IOException e2) {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e4) {
            }
        }
    }

    /* renamed from: a */
    private byte[] m174a(RandomAccessFile randomAccessFile) {
        try {
            byte[] bArr = new byte[12];
            randomAccessFile.seek(this.f127d.mo112g());
            randomAccessFile.read(bArr, 0, 12);
            return bArr;
        } catch (Throwable e) {
            throw new C0010a(e);
        } catch (Throwable e2) {
            throw new C0010a(e2);
        }
    }

    /* renamed from: b */
    private FileOutputStream m175b(String str) {
        if (C1468c.m4056a(str)) {
            try {
                File file = new File(m172a(str, null));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                return new FileOutputStream(file);
            } catch (Throwable e) {
                throw new C0010a(e);
            }
        }
        throw new C0010a("invalid output path");
    }

    /* renamed from: b */
    private byte[] m176b(RandomAccessFile randomAccessFile) {
        if (this.f127d.mo118m() == null) {
            return null;
        }
        try {
            C0015a m = this.f127d.mo118m();
            if (m == null) {
                throw new C0010a("unable to determine salt length: AESExtraDataRecord is null");
            }
            int i;
            switch (m.mo38a()) {
                case 1:
                    i = 8;
                    break;
                case 2:
                    i = 12;
                    break;
                case 3:
                    i = 16;
                    break;
                default:
                    throw new C0010a("unable to determine salt length: invalid aes key strength");
            }
            byte[] bArr = new byte[i];
            randomAccessFile.seek(this.f127d.mo112g());
            randomAccessFile.read(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0010a(e);
        }
    }

    /* renamed from: c */
    private static byte[] m177c(RandomAccessFile randomAccessFile) {
        try {
            byte[] bArr = new byte[2];
            randomAccessFile.read(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0010a(e);
        }
    }

    /* renamed from: g */
    private C0014d m178g() {
        if (this.f125b == null) {
            throw new C0010a("file header is null, cannot get inputstream");
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = m171a("r");
            String str = "local header and file header do not match";
            if (!m179h()) {
                throw new C0010a(str);
            } else if (this.f127d == null) {
                throw new C0010a("local file header is null, cannot initialize input stream");
            } else if (this.f127d == null) {
                throw new C0010a("local file header is null, cannot init decrypter");
            } else {
                if (this.f127d.mo113h()) {
                    if (this.f127d.mo115j() == 0) {
                        this.f128e = new C0009c(this.f125b, m174a(randomAccessFile));
                    } else if (this.f127d.mo115j() == 99) {
                        this.f128e = new C0006a(this.f127d, m176b(randomAccessFile), C0029b.m177c(randomAccessFile));
                    } else {
                        throw new C0010a("unsupported encryption method");
                    }
                }
                long c = this.f127d.mo105c();
                long g = this.f127d.mo112g();
                if (this.f127d.mo113h()) {
                    if (this.f127d.mo115j() == 99) {
                        if (this.f128e instanceof C0006a) {
                            c -= (long) ((((C0006a) this.f128e).mo16a() + 2) + 10);
                            g += (long) (((C0006a) this.f128e).mo16a() + 2);
                        } else {
                            throw new C0010a(new StringBuffer("invalid decryptor when trying to calculate compressed size for AES encrypted file: ").append(this.f125b.mo82j()).toString());
                        }
                    } else if (this.f127d.mo115j() == 0) {
                        c -= 12;
                        g += 12;
                    }
                }
                int a = this.f125b.mo56a();
                if (this.f125b.mo86n() == 99) {
                    if (this.f125b.mo92t() != null) {
                        a = this.f125b.mo92t().mo40b();
                    } else {
                        throw new C0010a(new StringBuffer("AESExtraDataRecord does not exist for AES encrypted file: ").append(this.f125b.mo82j()).toString());
                    }
                }
                randomAccessFile.seek(g);
                switch (a) {
                    case 0:
                        return new C0014d(new C0012c(randomAccessFile, c, this));
                    case 8:
                        return new C0014d(new C0013b(randomAccessFile, c, this));
                    default:
                        throw new C0010a("compression type not supported");
                }
            }
        } catch (C0010a e) {
            throw e;
        } catch (Throwable e2) {
            throw new C0010a(e2);
        } catch (C0010a e3) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e4) {
                }
            }
            throw e3;
        } catch (Throwable e22) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e5) {
                }
            }
            throw new C0010a(e22);
        }
    }

    /* renamed from: h */
    private boolean m179h() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = m180i();
            if (randomAccessFile == null) {
                randomAccessFile = new RandomAccessFile(new File(this.f124a.mo149d()), "r");
            }
            this.f127d = new C0000a(randomAccessFile).mo1a(this.f125b);
            if (this.f127d == null) {
                throw new C0010a("error reading local file header. Is this a valid zip file?");
            } else if (this.f127d.mo94a() != this.f125b.mo56a()) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                    } catch (Exception e2) {
                    }
                }
                return false;
            } else {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e3) {
                    } catch (Exception e4) {
                    }
                }
                return true;
            }
        } catch (Throwable e5) {
            throw new C0010a(e5);
        } catch (Throwable th) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e6) {
                } catch (Exception e7) {
                }
            }
        }
    }

    /* renamed from: i */
    private RandomAccessFile m180i() {
        if (!this.f124a.mo147c()) {
            return null;
        }
        int g = this.f125b.mo79g();
        this.f126c = g + 1;
        String d = this.f124a.mo149d();
        d = g == this.f124a.mo145b().mo44a() ? this.f124a.mo149d() : g >= 9 ? new StringBuffer(String.valueOf(d.substring(0, d.lastIndexOf(".")))).append(".z").append(g + 1).toString() : new StringBuffer(String.valueOf(d.substring(0, d.lastIndexOf(".")))).append(".z0").append(g + 1).toString();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(d, "r");
            if (this.f126c != 1) {
                return randomAccessFile;
            }
            byte[] bArr = new byte[4];
            randomAccessFile.read(bArr);
            if (((long) C1468c.m4063d(bArr, 0)) == 134695760) {
                return randomAccessFile;
            }
            throw new C0010a("invalid first part split file signature");
        } catch (Throwable e) {
            throw new C0010a(e);
        } catch (Throwable e2) {
            throw new C0010a(e2);
        }
    }

    /* renamed from: a */
    public final void mo161a() {
        if (this.f125b == null) {
            return;
        }
        if (this.f125b.mo86n() == 99) {
            if (this.f128e != null && (this.f128e instanceof C0006a)) {
                Object b = ((C0006a) this.f128e).mo18b();
                byte[] c = ((C0006a) this.f128e).mo19c();
                Object obj = new byte[10];
                if (c == null) {
                    throw new C0010a(new StringBuffer("CRC (MAC) check failed for ").append(this.f125b.mo82j()).toString());
                }
                System.arraycopy(b, 0, obj, 0, 10);
                if (!Arrays.equals(obj, c)) {
                    throw new C0010a(new StringBuffer("invalid CRC (MAC) for file: ").append(this.f125b.mo82j()).toString());
                }
            }
        } else if ((this.f129f.getValue() & 4294967295L) != this.f125b.mo71c()) {
            String stringBuffer = new StringBuffer("invalid CRC for file: ").append(this.f125b.mo82j()).toString();
            if (this.f127d.mo113h() && this.f127d.mo115j() == 0) {
                stringBuffer = new StringBuffer(String.valueOf(stringBuffer)).append(" - Wrong Password?").toString();
            }
            throw new C0010a(stringBuffer);
        }
    }

    /* renamed from: a */
    public final void mo162a(int i) {
        this.f129f.update(i);
    }

    /* renamed from: a */
    public final void mo163a(C0027a c0027a, String str) {
        InputStream g;
        Throwable e;
        OutputStream outputStream = null;
        if (this.f124a == null || this.f125b == null || !C1468c.m4056a(str)) {
            throw new C0010a("Invalid parameters passed during unzipping file. One or more of the parameters were null");
        }
        try {
            byte[] bArr = new byte[4096];
            g = m178g();
            try {
                outputStream = m175b(str);
                while (true) {
                    int read = g.read(bArr);
                    if (read == -1) {
                        C0029b.m173a(g, outputStream);
                        C1468c.m4053a(this.f125b, new File(m172a(str, null)), null);
                        C0029b.m173a(g, outputStream);
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                    c0027a.mo158b((long) read);
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            g = null;
        } catch (Exception e5) {
            e = e5;
            g = null;
            throw new C0010a(e);
        } catch (Throwable th) {
            e = th;
            g = null;
            C0029b.m173a(g, outputStream);
            throw e;
        }
        try {
            throw new C0010a(e);
        } catch (Throwable th2) {
            e = th2;
            C0029b.m173a(g, outputStream);
            throw e;
        }
    }

    /* renamed from: a */
    public final void mo164a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            this.f129f.update(bArr, i, i2);
        }
    }

    /* renamed from: b */
    public final RandomAccessFile mo165b() {
        String d = this.f124a.mo149d();
        d = this.f126c == this.f124a.mo145b().mo44a() ? this.f124a.mo149d() : this.f126c >= 9 ? new StringBuffer(String.valueOf(d.substring(0, d.lastIndexOf(".")))).append(".z").append(this.f126c + 1).toString() : new StringBuffer(String.valueOf(d.substring(0, d.lastIndexOf(".")))).append(".z0").append(this.f126c + 1).toString();
        this.f126c++;
        try {
            if (C1468c.m4064d(d)) {
                return new RandomAccessFile(d, "r");
            }
            throw new IOException(new StringBuffer("zip split file does not exist: ").append(d).toString());
        } catch (C0010a e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: c */
    public final C0020f mo166c() {
        return this.f125b;
    }

    /* renamed from: d */
    public final C0005b mo167d() {
        return this.f128e;
    }

    /* renamed from: e */
    public final C0026l mo168e() {
        return this.f124a;
    }

    /* renamed from: f */
    public final C0021g mo169f() {
        return this.f127d;
    }
}
