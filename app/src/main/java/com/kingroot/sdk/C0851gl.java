package com.kingroot.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

/* renamed from: com.kingroot.sdk.gl */
public class C0851gl {
    /* renamed from: cg */
    private final Object f2110cg = new Object();
    /* renamed from: ch */
    private final Object f2111ch = new Object();
    /* renamed from: ci */
    private Process f2112ci;
    /* renamed from: cj */
    private DataOutputStream f2113cj;
    /* renamed from: cm */
    private ByteArrayOutputStream f2114cm = new ByteArrayOutputStream();
    /* renamed from: cn */
    private ByteArrayOutputStream f2115cn = new ByteArrayOutputStream();
    /* renamed from: jK */
    private C0848a f2116jK;
    /* renamed from: jL */
    private C0848a f2117jL;

    /* renamed from: com.kingroot.sdk.gl$a */
    public class C0848a extends Thread {
        /* renamed from: co */
        InputStream f2100co;
        /* renamed from: cp */
        ByteArrayOutputStream f2101cp;

        public C0848a(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            this.f2100co = inputStream;
            this.f2101cp = byteArrayOutputStream;
        }

        public void run() {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = this.f2100co.read(bArr);
                    if (read < 0) {
                        synchronized (C0851gl.this.f2111ch) {
                            this.f2101cp.write(":RET=EOF".getBytes());
                            this.f2101cp.flush();
                        }
                        synchronized (C0851gl.this.f2110cg) {
                            C0851gl.this.f2110cg.notifyAll();
                        }
                        return;
                    } else if (read > 0) {
                        synchronized (C0851gl.this.f2111ch) {
                            this.f2101cp.write(bArr, 0, read);
                            this.f2101cp.flush();
                        }
                        synchronized (C0851gl.this.f2110cg) {
                            C0851gl.this.f2110cg.notifyAll();
                        }
                    }
                }
                while (true) {
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.kingroot.sdk.gl$b */
    public static class C0849b {
        /* renamed from: cr */
        public final String f2103cr;
        /* renamed from: cs */
        public final String f2104cs;
        /* renamed from: ct */
        public final String f2105ct;
        /* renamed from: cu */
        public final Integer f2106cu;

        public C0849b(String str, Integer num, String str2, String str3) {
            this.f2103cr = str;
            this.f2106cu = num;
            this.f2104cs = str2;
            this.f2105ct = str3;
        }

        public boolean success() {
            return this.f2106cu != null && this.f2106cu.intValue() == 0;
        }
    }

    /* renamed from: com.kingroot.sdk.gl$c */
    public static class C0850c {
        /* renamed from: cr */
        public final String f2107cr;
        /* renamed from: cv */
        public final String f2108cv;
        /* renamed from: cw */
        public final long f2109cw;

        public C0850c(String str, String str2, long j) {
            this.f2107cr = str;
            this.f2108cv = str2;
            this.f2109cw = j;
        }

        public boolean isEmpty() {
            return this.f2107cr == null || this.f2107cr.length() <= 0 || this.f2108cv == null || this.f2108cv.length() <= 0;
        }
    }

    public C0851gl(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        } else if (!str.startsWith("/") || new File(str).exists()) {
            Object obj;
            this.f2112ci = Runtime.getRuntime().exec(str);
            synchronized (this.f2110cg) {
                this.f2110cg.wait(10);
            }
            try {
                this.f2112ci.exitValue();
                obj = 1;
            } catch (Exception e) {
                obj = null;
            }
            if (obj != null) {
                throw new IOException();
            }
            this.f2113cj = new DataOutputStream(this.f2112ci.getOutputStream());
            this.f2116jK = new C0848a("StrReader", this.f2112ci.getInputStream(), this.f2114cm);
            this.f2117jL = new C0848a("ErrReader", this.f2112ci.getErrorStream(), this.f2115cn);
            synchronized (this.f2110cg) {
                this.f2110cg.wait(10);
            }
            this.f2116jK.start();
            this.f2117jL.start();
        } else {
            throw new FileNotFoundException();
        }
    }

    /* renamed from: K */
    private void m2199K() {
        Object obj = null;
        try {
            this.f2113cj.writeBytes("exit\n");
            this.f2113cj.flush();
            this.f2112ci.wait(100);
            obj = 1;
        } catch (Exception e) {
        }
        if (this.f2116jK != null) {
            this.f2116jK.interrupt();
            this.f2116jK = null;
        }
        if (this.f2117jL != null) {
            this.f2117jL.interrupt();
            this.f2117jL = null;
        }
        if (this.f2112ci != null) {
            if (obj == null) {
                this.f2112ci.destroy();
            }
            this.f2112ci = null;
        }
    }

    /* renamed from: a */
    private C0849b m2200a(C0850c c0850c, long j) {
        Object obj = null;
        synchronized (this.f2110cg) {
            synchronized (this.f2111ch) {
                if (new String(this.f2114cm.toByteArray()).lastIndexOf(":RET=") == -1) {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.f2110cg.wait(j);
            }
        }
        synchronized (this.f2111ch) {
            byte[] toByteArray = this.f2114cm.toByteArray();
            byte[] toByteArray2 = this.f2115cn.toByteArray();
            String str = new String(toByteArray);
            String str2 = new String(toByteArray2);
            if (str.lastIndexOf(":RET=") != -1) {
                this.f2114cm.reset();
                this.f2115cn.reset();
                C0849b c0849b;
                if (str.lastIndexOf(":RET=0") != -1) {
                    c0849b = new C0849b(c0850c.f2107cr, Integer.valueOf(0), new String(str.substring(0, str.lastIndexOf(":RET="))), str2);
                    return c0849b;
                }
                int i = (str.lastIndexOf(":RET=EOF") == -1 && str2.lastIndexOf(":RET=EOF") == -1) ? 1 : 2;
                c0849b = new C0849b(c0850c.f2107cr, Integer.valueOf(i), new String(str.substring(0, str.lastIndexOf(":RET="))), str2);
                return c0849b;
            }
            return null;
        }
    }

    /* renamed from: a */
    public synchronized C0849b mo5854a(C0850c c0850c) {
        C0849b a;
        if (c0850c != null) {
            if (!c0850c.isEmpty() && c0850c.f2109cw >= 0) {
                synchronized (this.f2111ch) {
                    this.f2114cm.reset();
                    this.f2115cn.reset();
                }
                this.f2113cj.writeBytes(c0850c.f2108cv + "\n");
                this.f2113cj.flush();
                synchronized (this.f2110cg) {
                    this.f2110cg.wait(10);
                }
                this.f2113cj.writeBytes("echo :RET=$?\n");
                this.f2113cj.flush();
                long nanoTime = System.nanoTime();
                long j = 0;
                do {
                    if (c0850c.f2109cw != 0) {
                        j = c0850c.f2109cw - ((System.nanoTime() - nanoTime) / 1000000);
                        if (j <= 0) {
                            throw new TimeoutException("Exec Timeout");
                        }
                    }
                    a = m2200a(c0850c, j);
                } while (a == null);
            }
        }
        throw new IllegalArgumentException("Cmd Argument Invalid");
        return a;
    }

    /* renamed from: c */
    public synchronized C0849b mo5855c(String str, long j) {
        return mo5854a(new C0850c(str, str, j));
    }

    protected void finalize() {
        shutdown();
        super.finalize();
    }

    public void shutdown() {
        try {
            m2199K();
        } catch (Throwable th) {
        }
    }
}
