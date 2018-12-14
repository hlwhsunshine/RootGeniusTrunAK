package p000a.p001a.p002a.p003a;

import android.support.p015v4.internal.view.SupportMenu;
import com.shuame.rootgenius.sdk.C1468c;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import p000a.p001a.p002a.p007c.C0010a;
import p000a.p001a.p002a.p009e.C0015a;
import p000a.p001a.p002a.p009e.C0016b;
import p000a.p001a.p002a.p009e.C0017c;
import p000a.p001a.p002a.p009e.C0018d;
import p000a.p001a.p002a.p009e.C0019e;
import p000a.p001a.p002a.p009e.C0020f;
import p000a.p001a.p002a.p009e.C0021g;
import p000a.p001a.p002a.p009e.C0023i;
import p000a.p001a.p002a.p009e.C0024j;
import p000a.p001a.p002a.p009e.C0025k;
import p000a.p001a.p002a.p009e.C0026l;

/* renamed from: a.a.a.a.a */
public final class C0000a {
    /* renamed from: a */
    private RandomAccessFile f0a = null;
    /* renamed from: b */
    private C0026l f1b;

    public C0000a(RandomAccessFile randomAccessFile) {
        this.f0a = randomAccessFile;
    }

    /* renamed from: a */
    private static C0015a m0a(ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        int i = 0;
        while (i < arrayList.size()) {
            C0019e c0019e = (C0019e) arrayList.get(i);
            if (c0019e == null || c0019e.mo50a() != 39169) {
                i++;
            } else if (c0019e.mo55c() == null) {
                throw new C0010a("corrput AES extra data records");
            } else {
                C0015a c0015a = new C0015a();
                Object c = c0019e.mo55c();
                Object obj = new byte[2];
                System.arraycopy(c, 2, obj, 0, 2);
                String str = new String(obj);
                c0015a.mo39a(c[4] & 255);
                c0015a.mo41b(C1468c.m4058b(c, 5));
                return c0015a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C0025k m1a(ArrayList arrayList, long j, long j2, long j3, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                break;
            }
            C0019e c0019e = (C0019e) arrayList.get(i3);
            if (c0019e == null || c0019e.mo50a() != 1) {
                i2 = i3 + 1;
            } else {
                C0025k c0025k = new C0025k();
                Object c = c0019e.mo55c();
                if (c0019e.mo54b() > 0) {
                    Object obj;
                    byte[] bArr = new byte[8];
                    Object obj2 = new byte[4];
                    int i4 = 0;
                    Object obj3 = null;
                    if ((65535 & j) == 65535 && c0019e.mo54b() > 0) {
                        System.arraycopy(c, 0, bArr, 0, 8);
                        c0025k.mo134b(C1468c.m4049a(bArr, 0));
                        i4 = 8;
                        obj3 = 1;
                    }
                    if ((65535 & j2) == 65535 && i4 < c0019e.mo54b()) {
                        System.arraycopy(c, i4, bArr, 0, 8);
                        c0025k.mo132a(C1468c.m4049a(bArr, 0));
                        i4 += 8;
                        obj3 = 1;
                    }
                    if ((65535 & j3) == 65535 && i4 < c0019e.mo54b()) {
                        System.arraycopy(c, i4, bArr, 0, 8);
                        c0025k.mo136c(C1468c.m4049a(bArr, 0));
                        i4 += 8;
                        obj3 = 1;
                    }
                    if ((SupportMenu.USER_MASK & i) != SupportMenu.USER_MASK || i4 >= c0019e.mo54b()) {
                        obj = obj3;
                    } else {
                        System.arraycopy(c, i4, obj2, 0, 4);
                        c0025k.mo131a(C1468c.m4063d(obj2, 0));
                        obj = 1;
                    }
                    if (obj != null) {
                        return c0025k;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private ArrayList m2a(int i) {
        int i2 = 0;
        if (i <= 0) {
            return null;
        }
        try {
            Object obj = new byte[i];
            this.f0a.read(obj);
            ArrayList arrayList = new ArrayList();
            while (i2 < i) {
                C0019e c0019e = new C0019e();
                c0019e.mo52a((long) C1468c.m4058b(obj, i2));
                int i3 = i2 + 2;
                i2 = C1468c.m4058b(obj, i3);
                if (i2 + 2 > i) {
                    i2 = C1468c.m4061c(obj, i3);
                    if (i2 + 2 > i) {
                        break;
                    }
                }
                c0019e.mo51a(i2);
                i3 += 2;
                if (i2 > 0) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(obj, i3, bArr, 0, i2);
                    c0019e.mo53a(bArr);
                }
                i2 += i3;
                arrayList.add(c0019e);
            }
            return arrayList.size() > 0 ? arrayList : null;
        } catch (Throwable e) {
            throw new C0010a(e);
        }
    }

    /* renamed from: a */
    private static void m3a(C0021g c0021g) {
        if (c0021g.mo117l() != null && c0021g.mo117l().size() > 0) {
            C0025k a = C0000a.m1a(c0021g.mo117l(), c0021g.mo108d(), c0021g.mo105c(), -1, -1);
            if (a != null) {
                if (a.mo133b() != -1) {
                    c0021g.mo107c(a.mo133b());
                }
                if (a.mo130a() != -1) {
                    c0021g.mo104b(a.mo130a());
                }
            }
        }
    }

    /* renamed from: a */
    private static byte[] m4a(RandomAccessFile randomAccessFile, byte[] bArr) {
        try {
            if (randomAccessFile.read(bArr, 0, bArr.length) != -1) {
                return bArr;
            }
            throw new C0010a("unexpected end of file when reading short buff");
        } catch (Throwable e) {
            throw new C0010a("IOException when reading short buff", e);
        }
    }

    /* renamed from: a */
    private static byte[] m5a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = bArr[0];
        bArr2[1] = bArr[1];
        bArr2[2] = bArr[2];
        bArr2[3] = bArr[3];
        return bArr2;
    }

    /* renamed from: b */
    private C0018d m6b() {
        int i = 0;
        if (this.f0a == null) {
            throw new C0010a("random access file was null", 3);
        }
        try {
            byte[] bArr = new byte[4];
            long length = this.f0a.length() - 22;
            C0018d c0018d = new C0018d();
            while (true) {
                long j = length - 1;
                this.f0a.seek(length);
                i++;
                if (((long) C1468c.m4048a(this.f0a, bArr)) != 101010256 && i <= 3000) {
                    length = j;
                }
            }
            if (((long) C1468c.m4063d(bArr, 0)) != 101010256) {
                throw new C0010a("zip headers not found. probably not a zip file");
            }
            byte[] bArr2 = new byte[4];
            bArr = new byte[2];
            C0000a.m4a(this.f0a, bArr);
            c0018d.mo45a(C1468c.m4058b(bArr, 0));
            C0000a.m4a(this.f0a, bArr);
            C0000a.m4a(this.f0a, bArr);
            C0000a.m4a(this.f0a, bArr);
            c0018d.mo48b(C1468c.m4058b(bArr, 0));
            C0000a.m4a(this.f0a, bArr2);
            C0000a.m4a(this.f0a, bArr2);
            c0018d.mo46a(C1468c.m4049a(C0000a.m5a(bArr2), 0));
            C0000a.m4a(this.f0a, bArr);
            i = C1468c.m4058b(bArr, 0);
            if (i > 0) {
                bArr2 = new byte[i];
                C0000a.m4a(this.f0a, bArr2);
                String str = new String(bArr2);
            }
            if (c0018d.mo44a() > 0) {
                this.f1b.mo144a(true);
            } else {
                this.f1b.mo144a(false);
            }
            return c0018d;
        } catch (Throwable e) {
            throw new C0010a("Probably not a zip file or a corrupted zip file", e, 4);
        }
    }

    /* renamed from: c */
    private C0016b m7c() {
        if (this.f0a == null) {
            throw new C0010a("random access file was null", 3);
        } else if (this.f1b.mo145b() == null) {
            throw new C0010a("EndCentralRecord was null, maybe a corrupt zip file");
        } else {
            try {
                int c;
                int f;
                byte[] bArr;
                String str;
                C0016b c0016b = new C0016b();
                ArrayList arrayList = new ArrayList();
                C0018d b = this.f1b.mo145b();
                long c2 = b.mo49c();
                int b2 = b.mo47b();
                if (this.f1b.mo152g()) {
                    c2 = this.f1b.mo151f().mo129d();
                    c = (int) this.f1b.mo151f().mo127c();
                } else {
                    c = b2;
                }
                this.f0a.seek(c2);
                byte[] bArr2 = new byte[4];
                byte[] bArr3 = new byte[2];
                for (int i = 0; i < c; i++) {
                    C0020f c0020f = new C0020f();
                    C0000a.m4a(this.f0a, bArr2);
                    if (((long) C1468c.m4063d(bArr2, 0)) != 33639248) {
                        throw new C0010a(new StringBuffer("Expected central directory entry not found (#").append(i + 1).append(")").toString());
                    }
                    C0000a.m4a(this.f0a, bArr3);
                    C0000a.m4a(this.f0a, bArr3);
                    C0000a.m4a(this.f0a, bArr3);
                    c0020f.mo69b((C1468c.m4058b(bArr3, 0) & 2048) != 0);
                    if ((bArr3[0] & 1) != 0) {
                        c0020f.mo85m();
                    }
                    bArr3.clone();
                    C0000a.m4a(this.f0a, bArr3);
                    c0020f.mo57a(C1468c.m4058b(bArr3, 0));
                    C0000a.m4a(this.f0a, bArr2);
                    c0020f.mo67b(C1468c.m4063d(bArr2, 0));
                    C0000a.m4a(this.f0a, bArr2);
                    c0020f.mo58a((long) C1468c.m4063d(bArr2, 0));
                    c0020f.mo70b((byte[]) bArr2.clone());
                    C0000a.m4a(this.f0a, bArr2);
                    c0020f.mo68b(C1468c.m4049a(C0000a.m5a(bArr2), 0));
                    C0000a.m4a(this.f0a, bArr2);
                    c0020f.mo73c(C1468c.m4049a(C0000a.m5a(bArr2), 0));
                    C0000a.m4a(this.f0a, bArr3);
                    int b3 = C1468c.m4058b(bArr3, 0);
                    C0000a.m4a(this.f0a, bArr3);
                    c0020f.mo72c(C1468c.m4058b(bArr3, 0));
                    C0000a.m4a(this.f0a, bArr3);
                    int b4 = C1468c.m4058b(bArr3, 0);
                    String str2 = new String(bArr3);
                    C0000a.m4a(this.f0a, bArr3);
                    c0020f.mo75d(C1468c.m4058b(bArr3, 0));
                    C0000a.m4a(this.f0a, bArr3);
                    bArr3.clone();
                    C0000a.m4a(this.f0a, bArr2);
                    c0020f.mo64a((byte[]) bArr2.clone());
                    C0000a.m4a(this.f0a, bArr2);
                    c0020f.mo76d(C1468c.m4049a(C0000a.m5a(bArr2), 0) & 4294967295L);
                    if (b3 > 0) {
                        byte[] bArr4 = new byte[b3];
                        C0000a.m4a(this.f0a, bArr4);
                        str2 = C1468c.m4056a(this.f1b.mo153h()) ? new String(bArr4, this.f1b.mo153h()) : C1468c.m4051a(bArr4, c0020f.mo93u());
                        if (str2 == null) {
                            throw new C0010a("fileName is null when reading central directory");
                        }
                        if (str2.indexOf(new StringBuffer(":").append(System.getProperty("file.separator")).toString()) >= 0) {
                            str2 = str2.substring(str2.indexOf(new StringBuffer(":").append(System.getProperty("file.separator")).toString()) + 2);
                        }
                        c0020f.mo61a(str2);
                        boolean z = str2.endsWith("/") || str2.endsWith("\\");
                        c0020f.mo63a(z);
                    } else {
                        c0020f.mo61a(null);
                    }
                    if (this.f0a == null) {
                        throw new C0010a("invalid file handler when trying to read extra data record");
                    }
                    f = c0020f.mo78f();
                    if (f > 0) {
                        c0020f.mo62a(m2a(f));
                    }
                    if (c0020f.mo90r() != null && c0020f.mo90r().size() > 0) {
                        C0025k a = C0000a.m1a(c0020f.mo90r(), c0020f.mo77e(), c0020f.mo74d(), c0020f.mo81i(), c0020f.mo79g());
                        if (a != null) {
                            c0020f.mo60a(a);
                            if (a.mo133b() != -1) {
                                c0020f.mo73c(a.mo133b());
                            }
                            if (a.mo130a() != -1) {
                                c0020f.mo68b(a.mo130a());
                            }
                            if (a.mo135c() != -1) {
                                c0020f.mo76d(a.mo135c());
                            }
                            if (a.mo137d() != -1) {
                                c0020f.mo75d(a.mo137d());
                            }
                        }
                    }
                    if (c0020f.mo90r() != null && c0020f.mo90r().size() > 0) {
                        C0015a a2 = C0000a.m0a(c0020f.mo90r());
                        if (a2 != null) {
                            c0020f.mo59a(a2);
                            c0020f.mo87o();
                        }
                    }
                    if (b4 > 0) {
                        bArr = new byte[b4];
                        C0000a.m4a(this.f0a, bArr);
                        str = new String(bArr);
                    }
                    arrayList.add(c0020f);
                }
                c0016b.mo43a(arrayList);
                C0017c c0017c = new C0017c();
                C0000a.m4a(this.f0a, bArr2);
                if (((long) C1468c.m4063d(bArr2, 0)) != 84233040) {
                    return c0016b;
                }
                C0000a.m4a(this.f0a, bArr3);
                f = C1468c.m4058b(bArr3, 0);
                if (f > 0) {
                    bArr = new byte[f];
                    C0000a.m4a(this.f0a, bArr);
                    str = new String(bArr);
                }
                return c0016b;
            } catch (Throwable e) {
                throw new C0010a(e);
            }
        }
    }

    /* renamed from: d */
    private C0023i m8d() {
        if (this.f0a == null) {
            throw new C0010a("invalid file handler when trying to read Zip64EndCentralDirLocator");
        }
        try {
            C0023i c0023i = new C0023i();
            byte[] bArr = new byte[4];
            long length = this.f0a.length() - 22;
            while (true) {
                long j = length - 1;
                this.f0a.seek(length);
                if (((long) C1468c.m4048a(this.f0a, bArr)) == 101010256) {
                    break;
                }
                length = j;
            }
            this.f0a.seek(((((this.f0a.getFilePointer() - 4) - 4) - 8) - 4) - 4);
            bArr = new byte[4];
            byte[] bArr2 = new byte[8];
            C0000a.m4a(this.f0a, bArr);
            if (((long) C1468c.m4063d(bArr, 0)) == 117853008) {
                this.f1b.mo146b(true);
                C0000a.m4a(this.f0a, bArr);
                C0000a.m4a(this.f0a, bArr2);
                c0023i.mo121a(C1468c.m4049a(bArr2, 0));
                C0000a.m4a(this.f0a, bArr);
                return c0023i;
            }
            this.f1b.mo146b(false);
            return null;
        } catch (Throwable e) {
            throw new C0010a(e);
        } catch (Throwable e2) {
            throw new C0010a(e2);
        }
    }

    /* renamed from: e */
    private C0024j m9e() {
        if (this.f1b.mo150e() == null) {
            throw new C0010a("invalid zip64 end of central directory locator");
        }
        long a = this.f1b.mo150e().mo120a();
        if (a < 0) {
            throw new C0010a("invalid offset for start of end of central directory record");
        }
        try {
            this.f0a.seek(a);
            C0024j c0024j = new C0024j();
            byte[] bArr = new byte[2];
            byte[] bArr2 = new byte[4];
            byte[] bArr3 = new byte[8];
            C0000a.m4a(this.f0a, bArr2);
            if (((long) C1468c.m4063d(bArr2, 0)) != 101075792) {
                throw new C0010a("invalid signature for zip64 end of central directory record");
            }
            C0000a.m4a(this.f0a, bArr3);
            c0024j.mo124a(C1468c.m4049a(bArr3, 0));
            C0000a.m4a(this.f0a, bArr);
            C0000a.m4a(this.f0a, bArr);
            C0000a.m4a(this.f0a, bArr2);
            c0024j.mo123a(C1468c.m4063d(bArr2, 0));
            C0000a.m4a(this.f0a, bArr2);
            C0000a.m4a(this.f0a, bArr3);
            C0000a.m4a(this.f0a, bArr3);
            c0024j.mo126b(C1468c.m4049a(bArr3, 0));
            C0000a.m4a(this.f0a, bArr3);
            C0000a.m4a(this.f0a, bArr3);
            c0024j.mo128c(C1468c.m4049a(bArr3, 0));
            long a2 = c0024j.mo122a() - 44;
            if (a2 > 0) {
                C0000a.m4a(this.f0a, new byte[((int) a2)]);
            }
            return c0024j;
        } catch (Throwable e) {
            throw new C0010a(e);
        }
    }

    /* renamed from: a */
    public final C0021g mo1a(C0020f c0020f) {
        if (c0020f == null || this.f0a == null) {
            throw new C0010a("invalid read parameters for local header");
        }
        long i = (c0020f.mo91s() == null || c0020f.mo91s().mo135c() <= 0) ? c0020f.mo81i() : c0020f.mo81i();
        if (i < 0) {
            throw new C0010a("invalid local header offset");
        }
        try {
            this.f0a.seek(i);
            C0021g c0021g = new C0021g();
            byte[] bArr = new byte[2];
            byte[] bArr2 = new byte[4];
            C0000a.m4a(this.f0a, bArr2);
            if (((long) C1468c.m4063d(bArr2, 0)) != 67324752) {
                throw new C0010a(new StringBuffer("invalid local header signature for file: ").append(c0020f.mo82j()).toString());
            }
            C0000a.m4a(this.f0a, bArr);
            C0000a.m4a(this.f0a, bArr);
            c0021g.mo100a((C1468c.m4058b(bArr, 0) & 2048) != 0);
            byte b = bArr[0];
            if ((b & 1) != 0) {
                c0021g.mo114i();
            }
            String toBinaryString = Integer.toBinaryString(b);
            if (toBinaryString.length() >= 4) {
                toBinaryString.charAt(3);
            }
            C0000a.m4a(this.f0a, bArr);
            c0021g.mo95a(C1468c.m4058b(bArr, 0));
            C0000a.m4a(this.f0a, bArr2);
            C0000a.m4a(this.f0a, bArr2);
            c0021g.mo96a((long) C1468c.m4063d(bArr2, 0));
            bArr2.clone();
            C0000a.m4a(this.f0a, bArr2);
            c0021g.mo104b(C1468c.m4049a(C0000a.m5a(bArr2), 0));
            C0000a.m4a(this.f0a, bArr2);
            c0021g.mo107c(C1468c.m4049a(C0000a.m5a(bArr2), 0));
            C0000a.m4a(this.f0a, bArr);
            int b2 = C1468c.m4058b(bArr, 0);
            C0000a.m4a(this.f0a, bArr);
            int b3 = C1468c.m4058b(bArr, 0);
            c0021g.mo103b(b3);
            int i2 = 30;
            if (b2 > 0) {
                byte[] bArr3 = new byte[b2];
                C0000a.m4a(this.f0a, bArr3);
                toBinaryString = C1468c.m4051a(bArr3, c0021g.mo119n());
                if (toBinaryString == null) {
                    throw new C0010a("file name is null, cannot assign file name to local file header");
                }
                if (toBinaryString.indexOf(new StringBuffer(":").append(System.getProperty("file.separator")).toString()) >= 0) {
                    toBinaryString = toBinaryString.substring(toBinaryString.indexOf(new StringBuffer(":").append(System.getProperty("file.separator")).toString()) + 2);
                }
                c0021g.mo98a(toBinaryString);
                i2 = b2 + 30;
            } else {
                c0021g.mo98a(null);
            }
            if (this.f0a == null) {
                throw new C0010a("invalid file handler when trying to read extra data record");
            }
            b2 = c0021g.mo110e();
            if (b2 > 0) {
                c0021g.mo99a(m2a(b2));
            }
            c0021g.mo109d(i + ((long) (i2 + b3)));
            c0021g.mo101a(c0020f.mo88p());
            C0000a.m3a(c0021g);
            if (c0021g.mo117l() != null && c0021g.mo117l().size() > 0) {
                C0015a a = C0000a.m0a(c0021g.mo117l());
                if (a != null) {
                    c0021g.mo97a(a);
                    c0021g.mo106c(99);
                }
            }
            if (c0021g.mo113h() && c0021g.mo115j() != 99) {
                if ((b & 64) == 64) {
                    c0021g.mo106c(1);
                } else {
                    c0021g.mo106c(0);
                }
            }
            if (c0021g.mo102b() <= 0) {
                c0021g.mo96a(c0020f.mo71c());
            }
            if (c0021g.mo105c() <= 0) {
                c0021g.mo104b(c0020f.mo74d());
            }
            if (c0021g.mo108d() <= 0) {
                c0021g.mo107c(c0020f.mo77e());
            }
            return c0021g;
        } catch (Throwable e) {
            throw new C0010a(e);
        }
    }

    /* renamed from: a */
    public final C0026l mo2a() {
        this.f1b = new C0026l();
        this.f1b.mo154i();
        this.f1b.mo140a(m6b());
        this.f1b.mo141a(m8d());
        if (this.f1b.mo152g()) {
            this.f1b.mo142a(m9e());
            if (this.f1b.mo151f() == null || this.f1b.mo151f().mo125b() <= 0) {
                this.f1b.mo144a(false);
            } else {
                this.f1b.mo144a(true);
            }
        }
        this.f1b.mo139a(m7c());
        return this.f1b;
    }
}
