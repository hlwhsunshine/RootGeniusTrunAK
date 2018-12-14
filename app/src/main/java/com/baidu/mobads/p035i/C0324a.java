package com.baidu.mobads.p035i;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.p021j.C0338m;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.baidu.mobads.i.a */
public class C0324a {
    /* renamed from: d */
    private static Method f614d = null;
    /* renamed from: e */
    private static Method f615e = null;
    /* renamed from: f */
    private static Method f616f = null;
    /* renamed from: g */
    private static Class<?> f617g = null;
    /* renamed from: n */
    private static char[] f618n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    /* renamed from: a */
    private Context f619a = null;
    /* renamed from: b */
    private TelephonyManager f620b = null;
    /* renamed from: c */
    private C0322a f621c = new C0322a();
    /* renamed from: h */
    private WifiManager f622h = null;
    /* renamed from: i */
    private C0323b f623i = null;
    /* renamed from: j */
    private long f624j = 0;
    /* renamed from: k */
    private String f625k = null;
    /* renamed from: l */
    private int f626l = 0;
    /* renamed from: m */
    private String f627m = null;

    /* renamed from: com.baidu.mobads.i.a$a */
    private class C0322a {
        /* renamed from: a */
        public int f605a;
        /* renamed from: b */
        public int f606b;
        /* renamed from: c */
        public int f607c;
        /* renamed from: d */
        public int f608d;
        /* renamed from: e */
        public char f609e;

        private C0322a() {
            this.f605a = -1;
            this.f606b = -1;
            this.f607c = -1;
            this.f608d = -1;
            this.f609e = 0;
        }

        /* renamed from: b */
        private boolean m488b() {
            return this.f605a >= 0 && this.f606b > 0;
        }

        /* renamed from: a */
        public String mo4528a() {
            if (!m488b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.f609e);
            stringBuffer.append(IXAdRequestInfo.HEIGHT);
            if (this.f607c != 460) {
                stringBuffer.append(this.f607c);
            }
            stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", new Object[]{Integer.valueOf(this.f608d), Integer.valueOf(this.f605a), Integer.valueOf(this.f606b)}));
            return stringBuffer.toString();
        }
    }

    /* renamed from: com.baidu.mobads.i.a$b */
    protected class C0323b {
        /* renamed from: a */
        public List<ScanResult> f611a = null;
        /* renamed from: c */
        private long f613c = 0;

        public C0323b(List<ScanResult> list) {
            this.f611a = list;
            this.f613c = System.currentTimeMillis();
            m491b();
        }

        /* renamed from: b */
        private void m491b() {
            if (mo4529a() > 0) {
                Object obj = 1;
                for (int size = this.f611a.size() - 1; size > 0 && obj != null; size--) {
                    int i = 0;
                    obj = null;
                    while (i < size) {
                        Object obj2;
                        if (((ScanResult) this.f611a.get(i)).level < ((ScanResult) this.f611a.get(i + 1)).level) {
                            ScanResult scanResult = (ScanResult) this.f611a.get(i + 1);
                            this.f611a.set(i + 1, this.f611a.get(i));
                            this.f611a.set(i, scanResult);
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                }
            }
        }

        /* renamed from: c */
        private boolean m492c() {
            long currentTimeMillis = System.currentTimeMillis() - this.f613c;
            return currentTimeMillis < 0 || currentTimeMillis > 500;
        }

        /* renamed from: a */
        public int mo4529a() {
            return this.f611a == null ? 0 : this.f611a.size();
        }

        /* renamed from: a */
        public String mo4530a(int i) {
            if (mo4529a() <= 0) {
                return null;
            }
            Object obj;
            int obj2;
            Object obj3;
            boolean a = C0324a.this.m506c();
            if (a) {
                i--;
                obj2 = null;
            } else {
                obj2 = 1;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.f611a.size();
            int i2 = 0;
            int i3 = 0;
            Object obj4 = 1;
            Object obj5 = obj2;
            while (i2 < size) {
                if (((ScanResult) this.f611a.get(i2)).level != 0) {
                    String str = ((ScanResult) this.f611a.get(i2)).BSSID;
                    obj2 = ((ScanResult) this.f611a.get(i2)).level;
                    str = str.replace(":", "");
                    if (C0324a.this.f625k == null || !str.equals(C0324a.this.f625k)) {
                        if (i3 < i) {
                            stringBuffer.append(IXAdRequestInfo.HEIGHT);
                            stringBuffer.append(str);
                            stringBuffer.append("m");
                            stringBuffer.append(StrictMath.abs(obj2));
                            obj2 = i3 + 1;
                            obj3 = null;
                        } else {
                            obj2 = i3;
                            obj3 = obj4;
                        }
                        if (obj2 > i && obj5 != null) {
                            break;
                        }
                        obj4 = obj5;
                    } else {
                        C0324a.this.f626l = StrictMath.abs(obj2);
                        obj2 = i3;
                        obj3 = obj4;
                        obj4 = 1;
                    }
                } else {
                    obj2 = i3;
                    obj3 = obj4;
                    obj4 = obj5;
                }
                i2++;
                obj5 = obj4;
                obj4 = obj3;
                i3 = obj2;
            }
            obj3 = obj4;
            String stringBuilder = a ? new StringBuilder(IXAdRequestInfo.HEIGHT).append(C0324a.this.f625k).append("km").append(C0324a.this.f626l).toString() : null;
            return obj3 == null ? stringBuilder + stringBuffer.toString() : stringBuilder;
        }
    }

    public C0324a(Context context) {
        String str;
        this.f619a = context.getApplicationContext();
        String packageName = this.f619a.getPackageName();
        try {
            this.f620b = (TelephonyManager) this.f619a.getSystemService("phone");
            str = (String) C0338m.m569a().mo5040m().mo5011a(this.f620b, C0338m.m569a().mo5032e().decodeStr("uvNYwANvpyP-iyfb"), new Object[0]);
        } catch (Exception e) {
            str = null;
        }
        this.f627m = "&" + packageName + "&" + str;
        this.f622h = (WifiManager) this.f619a.getSystemService(IXAdSystemUtils.NT_WIFI);
    }

    /* renamed from: a */
    private C0322a m496a(CellInfo cellInfo) {
        int intValue = Integer.valueOf(VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        C0322a c0322a = new C0322a();
        Object obj = null;
        int obj2;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            c0322a.f607c = m502b(cellIdentity.getMcc());
            c0322a.f608d = m502b(cellIdentity.getMnc());
            c0322a.f605a = m502b(cellIdentity.getLac());
            c0322a.f606b = m502b(cellIdentity.getCid());
            c0322a.f609e = 'g';
            obj2 = 1;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            c0322a.f608d = m502b(cellIdentity2.getSystemId());
            c0322a.f605a = m502b(cellIdentity2.getNetworkId());
            c0322a.f606b = m502b(cellIdentity2.getBasestationId());
            c0322a.f609e = 'w';
            obj2 = 1;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            c0322a.f607c = m502b(cellIdentity3.getMcc());
            c0322a.f608d = m502b(cellIdentity3.getMnc());
            c0322a.f605a = m502b(cellIdentity3.getTac());
            c0322a.f606b = m502b(cellIdentity3.getCi());
            c0322a.f609e = 'g';
            obj2 = 1;
        }
        if (intValue >= 18 && obj2 == null) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    c0322a.f607c = m502b(cellIdentity4.getMcc());
                    c0322a.f608d = m502b(cellIdentity4.getMnc());
                    c0322a.f605a = m502b(cellIdentity4.getLac());
                    c0322a.f606b = m502b(cellIdentity4.getCid());
                    c0322a.f609e = 'g';
                }
            } catch (Exception e) {
            }
        }
        return c0322a;
    }

    /* renamed from: a */
    private String m497a(int i) {
        String a;
        String a2;
        if (i < 3) {
            i = 3;
        }
        try {
            C0322a b = m503b();
            if (b == null || !b.m488b()) {
                m500a(this.f620b.getCellLocation());
            } else {
                this.f621c = b;
            }
            a = this.f621c.mo4528a();
        } catch (Exception e) {
            a = null;
        }
        if (a == null) {
            a = "Z";
        }
        try {
            if (this.f623i == null || this.f623i.m492c()) {
                this.f623i = new C0323b(this.f622h.getScanResults());
            }
            a2 = this.f623i.mo4530a(i);
        } catch (Exception e2) {
            a2 = null;
        }
        if (a2 != null) {
            a = a + a2;
        }
        return a.equals("Z") ? null : C0324a.m498a(a + "t" + System.currentTimeMillis() + this.f627m);
    }

    /* renamed from: a */
    private static String m498a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[(bytes.length + 2)];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2 = i3;
        }
        i = i2 + 1;
        bArr[i2] = nextInt;
        bArr[i] = nextInt2;
        return C0324a.m499a(bArr);
    }

    /* renamed from: a */
    private static String m499a(byte[] bArr) {
        char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            Object obj;
            Object obj2;
            int i3 = (bArr[i2] & 255) << 8;
            if (i2 + 1 < bArr.length) {
                i3 |= bArr[i2 + 1] & 255;
                obj = 1;
            } else {
                obj = null;
            }
            i3 <<= 8;
            if (i2 + 2 < bArr.length) {
                i3 |= bArr[i2 + 2] & 255;
                obj2 = 1;
            } else {
                obj2 = null;
            }
            cArr[i + 3] = f618n[obj2 != null ? 63 - (i3 & 63) : 64];
            int i4 = i3 >> 6;
            cArr[i + 2] = f618n[obj != null ? 63 - (i4 & 63) : 64];
            i3 = i4 >> 6;
            cArr[i + 1] = f618n[63 - (i3 & 63)];
            cArr[i + 0] = f618n[63 - ((i3 >> 6) & 63)];
            i2 += 3;
            i += 4;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    private void m500a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.f620b != null) {
            C0322a c0322a = new C0322a();
            String networkOperator = this.f620b.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.f621c.f607c;
                        }
                        c0322a.f607c = intValue;
                    }
                    String substring = networkOperator.substring(3);
                    if (substring != null) {
                        char[] toCharArray = substring.toCharArray();
                        while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                            i++;
                        }
                    }
                    i = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (i < 0) {
                        i = this.f621c.f608d;
                    }
                    c0322a.f608d = i;
                } catch (Exception e) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                c0322a.f605a = ((GsmCellLocation) cellLocation).getLac();
                c0322a.f606b = ((GsmCellLocation) cellLocation).getCid();
                c0322a.f609e = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                c0322a.f609e = 'w';
                if (f617g == null) {
                    try {
                        Class cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        f617g = cls;
                        f614d = cls.getMethod("getBaseStationId", new Class[0]);
                        f615e = f617g.getMethod("getNetworkId", new Class[0]);
                        f616f = f617g.getMethod("getSystemId", new Class[0]);
                    } catch (Exception e2) {
                        f617g = null;
                        return;
                    }
                }
                if (f617g != null && f617g.isInstance(cellLocation)) {
                    try {
                        i = ((Integer) f616f.invoke(cellLocation, new Object[0])).intValue();
                        if (i < 0) {
                            i = this.f621c.f608d;
                        }
                        c0322a.f608d = i;
                        c0322a.f606b = ((Integer) f614d.invoke(cellLocation, new Object[0])).intValue();
                        c0322a.f605a = ((Integer) f615e.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e3) {
                        return;
                    }
                }
            }
            if (c0322a.m488b()) {
                this.f621c = c0322a;
            }
        }
    }

    /* renamed from: b */
    private int m502b(int i) {
        return i == Integer.MAX_VALUE ? -1 : i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A:{ExcHandler: java.lang.NoSuchMethodError (e java.lang.NoSuchMethodError), Splitter: B:2:0x0010} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A:{ExcHandler: java.lang.NoSuchMethodError (e java.lang.NoSuchMethodError), Splitter: B:2:0x0010} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:37:?, code:
            return r2;
     */
    /* JADX WARNING: Missing block: B:38:?, code:
            return r0;
     */
    /* JADX WARNING: Missing block: B:40:?, code:
            return null;
     */
    /* renamed from: b */
    private com.baidu.mobads.p035i.C0324a.C0322a m503b() {
        /*
        r5 = this;
        r1 = 0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r2 = 17;
        if (r0 >= r2) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r5.f620b;	 Catch:{ Exception -> 0x0046, NoSuchMethodError -> 0x0044 }
        r0 = r0.getAllCellInfo();	 Catch:{ Exception -> 0x0046, NoSuchMethodError -> 0x0044 }
        if (r0 == 0) goto L_0x000f;
    L_0x0018:
        r2 = r0.size();	 Catch:{ Exception -> 0x0046, NoSuchMethodError -> 0x0044 }
        if (r2 <= 0) goto L_0x000f;
    L_0x001e:
        r3 = r0.iterator();	 Catch:{ Exception -> 0x0046, NoSuchMethodError -> 0x0044 }
        r2 = r1;
    L_0x0023:
        r0 = r3.hasNext();	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0044 }
        if (r0 == 0) goto L_0x0050;
    L_0x0029:
        r0 = r3.next();	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0044 }
        r0 = (android.telephony.CellInfo) r0;	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0044 }
        r4 = r0.isRegistered();	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0044 }
        if (r4 == 0) goto L_0x0023;
    L_0x0035:
        r0 = r5.m496a(r0);	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0044 }
        if (r0 == 0) goto L_0x004e;
    L_0x003b:
        r2 = r0.m488b();	 Catch:{ Exception -> 0x004b, NoSuchMethodError -> 0x0044 }
        if (r2 != 0) goto L_0x0042;
    L_0x0041:
        r0 = r1;
    L_0x0042:
        r1 = r0;
        goto L_0x000f;
    L_0x0044:
        r0 = move-exception;
        goto L_0x000f;
    L_0x0046:
        r0 = move-exception;
        goto L_0x000f;
    L_0x0048:
        r0 = move-exception;
        r1 = r2;
        goto L_0x000f;
    L_0x004b:
        r1 = move-exception;
        r1 = r0;
        goto L_0x000f;
    L_0x004e:
        r2 = r0;
        goto L_0x0023;
    L_0x0050:
        r1 = r2;
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.i.a.b():com.baidu.mobads.i.a$a");
    }

    /* renamed from: c */
    private boolean m506c() {
        String str = null;
        this.f625k = null;
        this.f626l = 0;
        WifiInfo connectionInfo = this.f622h.getConnectionInfo();
        if (connectionInfo == null) {
            return false;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                str = bssid.replace(":", "");
            }
            if (str.length() != 12) {
                return false;
            }
            this.f625k = new String(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public String mo4531a() {
        try {
            return m497a(10);
        } catch (Exception e) {
            return null;
        }
    }
}
