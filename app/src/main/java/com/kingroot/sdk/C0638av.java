package com.kingroot.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

/* renamed from: com.kingroot.sdk.av */
public class C0638av {
    /* renamed from: cg */
    private final Object f1591cg = new Object();
    /* renamed from: ch */
    private final Object f1592ch = new Object();
    /* renamed from: ci */
    private Process f1593ci;
    /* renamed from: cj */
    private DataOutputStream f1594cj;
    /* renamed from: ck */
    private C0635a f1595ck;
    /* renamed from: cl */
    private C0635a f1596cl;
    /* renamed from: cm */
    private ByteArrayOutputStream f1597cm = new ByteArrayOutputStream();
    /* renamed from: cn */
    private ByteArrayOutputStream f1598cn = new ByteArrayOutputStream();

    /* renamed from: com.kingroot.sdk.av$a */
    public class C0635a extends Thread {
        /* renamed from: co */
        InputStream f1581co;
        /* renamed from: cp */
        ByteArrayOutputStream f1582cp;

        public C0635a(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            this.f1581co = inputStream;
            this.f1582cp = byteArrayOutputStream;
        }

        public void run() {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = this.f1581co.read(bArr);
                    if (read < 0) {
                        synchronized (C0638av.this.f1592ch) {
                            this.f1582cp.write(":RET=EOF".getBytes());
                            this.f1582cp.flush();
                        }
                        synchronized (C0638av.this.f1591cg) {
                            C0638av.this.f1591cg.notifyAll();
                        }
                        return;
                    } else if (read > 0) {
                        synchronized (C0638av.this.f1592ch) {
                            this.f1582cp.write(bArr, 0, read);
                            this.f1582cp.flush();
                        }
                        synchronized (C0638av.this.f1591cg) {
                            C0638av.this.f1591cg.notifyAll();
                        }
                    }
                }
                while (true) {
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.kingroot.sdk.av$b */
    public static class C0636b {
        /* renamed from: cr */
        public final String f1584cr;
        /* renamed from: cs */
        public final String f1585cs;
        /* renamed from: ct */
        public final String f1586ct;
        /* renamed from: cu */
        public final Integer f1587cu;

        public C0636b(String str, Integer num, String str2, String str3) {
            this.f1584cr = str;
            this.f1587cu = num;
            this.f1585cs = str2;
            this.f1586ct = str3;
        }

        public boolean success() {
            return this.f1587cu != null && this.f1587cu.intValue() == 0;
        }
    }

    /* renamed from: com.kingroot.sdk.av$c */
    public static class C0637c {
        /* renamed from: cr */
        public final String f1588cr;
        /* renamed from: cv */
        public final String f1589cv;
        /* renamed from: cw */
        public final long f1590cw;

        public C0637c(String str, String str2, long j) {
            this.f1588cr = str;
            this.f1589cv = str2;
            this.f1590cw = j;
        }

        public boolean isEmpty() {
            return this.f1588cr == null || this.f1588cr.length() <= 0 || this.f1589cv == null || this.f1589cv.length() <= 0;
        }
    }

    public C0638av(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        } else if (!str.startsWith("/") || new File(str).exists()) {
            Object obj;
            this.f1593ci = new ProcessBuilder(Arrays.asList(str.split(" "))).start();
            synchronized (this.f1591cg) {
                this.f1591cg.wait(10);
            }
            try {
                this.f1593ci.exitValue();
                obj = 1;
            } catch (Exception e) {
                obj = null;
            }
            if (obj != null) {
                throw new IOException();
            }
            this.f1594cj = new DataOutputStream(this.f1593ci.getOutputStream());
            this.f1595ck = new C0635a("KRSDK.StrReader", this.f1593ci.getInputStream(), this.f1597cm);
            this.f1596cl = new C0635a("KRSDK.ErrReader", this.f1593ci.getErrorStream(), this.f1598cn);
            synchronized (this.f1591cg) {
                this.f1591cg.wait(10);
            }
            this.f1595ck.start();
            this.f1596cl.start();
        } else {
            throw new FileNotFoundException();
        }
    }

    /* renamed from: K */
    private void m1470K() {
        if (this.f1595ck != null) {
            this.f1595ck.interrupt();
            this.f1595ck = null;
        }
        if (this.f1596cl != null) {
            this.f1596cl.interrupt();
            this.f1596cl = null;
        }
        if (this.f1593ci != null) {
            this.f1593ci.destroy();
            this.f1593ci = null;
        }
    }

    /* renamed from: a */
    private C0636b m1471a(C0637c c0637c, long j) {
        int i = 2;
        int i2 = 0;
        synchronized (this.f1591cg) {
            int i3;
            synchronized (this.f1592ch) {
                i3 = new String(this.f1597cm.toByteArray()).lastIndexOf(":RET=") == -1 ? 1 : 0;
            }
            if (i3 != 0) {
                this.f1591cg.wait(j);
            }
        }
        synchronized (this.f1592ch) {
            StringBuilder[] stringBuilderArr = new StringBuilder[]{new StringBuilder(), new StringBuilder()};
            ByteArrayOutputStream[] byteArrayOutputStreamArr = new ByteArrayOutputStream[]{this.f1597cm, this.f1598cn};
            while (i2 < 2) {
                stringBuilderArr[i2].append(new String(byteArrayOutputStreamArr[i2].toByteArray()));
                i2++;
            }
            String stringBuilder = stringBuilderArr[0].toString();
            String stringBuilder2 = stringBuilderArr[1].toString();
            if (stringBuilder.lastIndexOf(":RET=") != -1) {
                this.f1597cm.reset();
                this.f1598cn.reset();
                C0636b c0636b;
                if (stringBuilder.lastIndexOf(":RET=0") != -1) {
                    c0636b = new C0636b(c0637c.f1588cr, Integer.valueOf(0), new String(stringBuilder.substring(0, stringBuilder.lastIndexOf(":RET="))), stringBuilder2);
                    return c0636b;
                }
                if (stringBuilder.lastIndexOf(":RET=EOF") == -1 && stringBuilder2.lastIndexOf(":RET=EOF") == -1) {
                    i = 1;
                }
                c0636b = new C0636b(c0637c.f1588cr, Integer.valueOf(i), new String(stringBuilder.substring(0, stringBuilder.lastIndexOf(":RET="))), stringBuilder2);
                return c0636b;
            }
            return null;
        }
    }

    /* renamed from: a */
    public synchronized C0636b mo5604a(C0637c c0637c) {
        C0636b a;
        if (c0637c != null) {
            if (!c0637c.isEmpty() && c0637c.f1590cw >= 0) {
                synchronized (this.f1592ch) {
                    this.f1597cm.reset();
                    this.f1598cn.reset();
                }
                this.f1594cj.write((c0637c.f1589cv + "\n").getBytes());
                this.f1594cj.flush();
                synchronized (this.f1591cg) {
                    this.f1591cg.wait(10);
                }
                this.f1594cj.writeBytes("echo :RET=$?\n");
                this.f1594cj.flush();
                long nanoTime = System.nanoTime();
                long j = 0;
                do {
                    if (c0637c.f1590cw != 0) {
                        j = c0637c.f1590cw - ((System.nanoTime() - nanoTime) / 1000000);
                        if (j <= 0) {
                            throw new TimeoutException("Exec Timeout");
                        }
                    }
                    a = m1471a(c0637c, j);
                } while (a == null);
            }
        }
        throw new IllegalArgumentException("Cmd Argument Invalid");
        return a;
    }

    /* renamed from: a */
    public synchronized C0636b mo5605a(String str, boolean z) {
        return mo5604a(new C0637c(str, str, z ? 120000 : 0));
    }

    /* renamed from: b */
    public synchronized C0636b mo5606b(String str, long j) {
        return mo5604a(new C0637c(str, str, j));
    }

    protected void finalize() {
        shutdown();
        super.finalize();
    }

    public void shutdown() {
        try {
            m1470K();
        } catch (Throwable th) {
        }
    }

    /* renamed from: t */
    public synchronized C0636b mo5609t(String str) {
        return mo5605a(str, true);
    }
}
