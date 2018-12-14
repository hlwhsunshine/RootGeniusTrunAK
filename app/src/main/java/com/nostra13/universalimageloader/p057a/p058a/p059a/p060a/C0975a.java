package com.nostra13.universalimageloader.p057a.p058a.p059a.p060a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.nostra13.universalimageloader.a.a.a.a.a */
final class C0975a implements Closeable {
    /* renamed from: a */
    static final Pattern f2433a = Pattern.compile("[a-z0-9_-]{1,64}");
    /* renamed from: r */
    private static final OutputStream f2434r = new C0977c();
    /* renamed from: b */
    final ThreadPoolExecutor f2435b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: c */
    private final File f2436c;
    /* renamed from: d */
    private final File f2437d;
    /* renamed from: e */
    private final File f2438e;
    /* renamed from: f */
    private final File f2439f;
    /* renamed from: g */
    private final int f2440g;
    /* renamed from: h */
    private long f2441h;
    /* renamed from: i */
    private int f2442i;
    /* renamed from: j */
    private final int f2443j;
    /* renamed from: k */
    private long f2444k = 0;
    /* renamed from: l */
    private int f2445l = 0;
    /* renamed from: m */
    private Writer f2446m;
    /* renamed from: n */
    private final LinkedHashMap<String, C0973b> f2447n = new LinkedHashMap(0, 0.75f, true);
    /* renamed from: o */
    private int f2448o;
    /* renamed from: p */
    private long f2449p = 0;
    /* renamed from: q */
    private final Callable<Void> f2450q = new C0976b(this);

    /* renamed from: com.nostra13.universalimageloader.a.a.a.a.a$a */
    public final class C0972a {
        /* renamed from: b */
        private final C0973b f2417b;
        /* renamed from: c */
        private final boolean[] f2418c;
        /* renamed from: d */
        private boolean f2419d;
        /* renamed from: e */
        private boolean f2420e;

        /* renamed from: com.nostra13.universalimageloader.a.a.a.a.a$a$a */
        private class C0971a extends FilterOutputStream {
            private C0971a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0971a(C0972a c0972a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            public final void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C0972a.this.f2419d = true;
                }
            }

            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C0972a.this.f2419d = true;
                }
            }

            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C0972a.this.f2419d = true;
                }
            }

            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C0972a.this.f2419d = true;
                }
            }
        }

        private C0972a(C0973b c0973b) {
            this.f2417b = c0973b;
            this.f2418c = c0973b.f2424d ? null : new boolean[C0975a.this.f2443j];
        }

        /* synthetic */ C0972a(C0975a c0975a, C0973b c0973b, byte b) {
            this(c0973b);
        }

        /* renamed from: a */
        public final OutputStream mo6126a() {
            OutputStream a;
            synchronized (C0975a.this) {
                if (this.f2417b.f2425e != this) {
                    throw new IllegalStateException();
                }
                OutputStream fileOutputStream;
                if (!this.f2417b.f2424d) {
                    this.f2418c[0] = true;
                }
                File b = this.f2417b.mo6131b(0);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e) {
                    C0975a.this.f2436c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        a = C0975a.f2434r;
                    }
                }
                a = new C0971a(this, fileOutputStream, (byte) 0);
            }
            return a;
        }

        /* renamed from: b */
        public final void mo6127b() {
            if (this.f2419d) {
                C0975a.this.m2753a(this, false);
                C0975a.this.mo6136c(this.f2417b.f2422b);
            } else {
                C0975a.this.m2753a(this, true);
            }
            this.f2420e = true;
        }

        /* renamed from: c */
        public final void mo6128c() {
            C0975a.this.m2753a(this, false);
        }
    }

    /* renamed from: com.nostra13.universalimageloader.a.a.a.a.a$b */
    private final class C0973b {
        /* renamed from: b */
        private final String f2422b;
        /* renamed from: c */
        private final long[] f2423c;
        /* renamed from: d */
        private boolean f2424d;
        /* renamed from: e */
        private C0972a f2425e;
        /* renamed from: f */
        private long f2426f;

        private C0973b(String str) {
            this.f2422b = str;
            this.f2423c = new long[C0975a.this.f2443j];
        }

        /* synthetic */ C0973b(C0975a c0975a, String str, byte b) {
            this(str);
        }

        /* renamed from: a */
        private static IOException m2738a(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public final File mo6129a(int i) {
            return new File(C0975a.this.f2436c, this.f2422b + "." + i);
        }

        /* renamed from: a */
        public final String mo6130a() {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f2423c) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        /* renamed from: b */
        public final File mo6131b(int i) {
            return new File(C0975a.this.f2436c, this.f2422b + "." + i + ".tmp");
        }
    }

    /* renamed from: com.nostra13.universalimageloader.a.a.a.a.a$c */
    public final class C0974c implements Closeable {
        /* renamed from: b */
        private final String f2428b;
        /* renamed from: c */
        private final long f2429c;
        /* renamed from: d */
        private File[] f2430d;
        /* renamed from: e */
        private final InputStream[] f2431e;
        /* renamed from: f */
        private final long[] f2432f;

        private C0974c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.f2428b = str;
            this.f2429c = j;
            this.f2430d = fileArr;
            this.f2431e = inputStreamArr;
            this.f2432f = jArr;
        }

        /* synthetic */ C0974c(C0975a c0975a, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        /* renamed from: a */
        public final File mo6132a() {
            return this.f2430d[0];
        }

        public final void close() {
            for (Closeable a : this.f2431e) {
                C0983g.m2788a(a);
            }
        }
    }

    private C0975a(File file, long j, int i) {
        this.f2436c = file;
        this.f2440g = 1;
        this.f2437d = new File(file, "journal");
        this.f2438e = new File(file, "journal.tmp");
        this.f2439f = new File(file, "journal.bkp");
        this.f2443j = 1;
        this.f2441h = j;
        this.f2442i = i;
    }

    /* renamed from: a */
    public static C0975a m2750a(File file, long j, int i) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    C0975a.m2756a(file2, file3, false);
                }
            }
            C0975a c0975a = new C0975a(file, j, i);
            if (c0975a.f2437d.exists()) {
                try {
                    c0975a.m2757b();
                    c0975a.m2759c();
                    c0975a.f2446m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c0975a.f2437d, true), C0983g.f2465a));
                    return c0975a;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    c0975a.close();
                    C0983g.m2789a(c0975a.f2436c);
                }
            }
            file.mkdirs();
            c0975a = new C0975a(file, j, i);
            c0975a.m2762d();
            return c0975a;
        }
    }

    /* renamed from: a */
    private synchronized void m2753a(C0972a c0972a, boolean z) {
        int i = 0;
        synchronized (this) {
            C0973b a = c0972a.f2417b;
            if (a.f2425e != c0972a) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f2424d) {
                    int i2 = 0;
                    while (i2 < this.f2443j) {
                        if (!c0972a.f2418c[i2]) {
                            c0972a.mo6128c();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.mo6131b(i2).exists()) {
                            c0972a.mo6128c();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f2443j) {
                File b = a.mo6131b(i);
                if (!z) {
                    C0975a.m2755a(b);
                } else if (b.exists()) {
                    File a2 = a.mo6129a(i);
                    b.renameTo(a2);
                    long j = a.f2423c[i];
                    long length = a2.length();
                    a.f2423c[i] = length;
                    this.f2444k = (this.f2444k - j) + length;
                    this.f2445l++;
                }
                i++;
            }
            this.f2448o++;
            a.f2425e = null;
            if ((a.f2424d | z) != 0) {
                a.f2424d = true;
                this.f2446m.write("CLEAN " + a.f2422b + a.mo6130a() + 10);
                if (z) {
                    long j2 = this.f2449p;
                    this.f2449p = 1 + j2;
                    a.f2426f = j2;
                }
            } else {
                this.f2447n.remove(a.f2422b);
                this.f2446m.write("REMOVE " + a.f2422b + 10);
            }
            this.f2446m.flush();
            if (this.f2444k > this.f2441h || this.f2445l > this.f2442i || m2766e()) {
                this.f2435b.submit(this.f2450q);
            }
        }
    }

    /* renamed from: a */
    private static void m2755a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m2756a(File file, File file2, boolean z) {
        if (z) {
            C0975a.m2755a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f5 A:{Catch:{ EOFException -> 0x00b5, all -> 0x008e }} */
    /* renamed from: b */
    private void m2757b() {
        /*
        r10 = this;
        r9 = 5;
        r0 = 0;
        r8 = -1;
        r3 = new com.nostra13.universalimageloader.a.a.a.a.e;
        r1 = new java.io.FileInputStream;
        r2 = r10.f2437d;
        r1.<init>(r2);
        r2 = com.nostra13.universalimageloader.p057a.p058a.p059a.p060a.C0983g.f2465a;
        r3.<init>(r1, r2);
        r1 = r3.mo6143a();	 Catch:{ all -> 0x008e }
        r2 = r3.mo6143a();	 Catch:{ all -> 0x008e }
        r4 = r3.mo6143a();	 Catch:{ all -> 0x008e }
        r5 = r3.mo6143a();	 Catch:{ all -> 0x008e }
        r6 = r3.mo6143a();	 Catch:{ all -> 0x008e }
        r7 = "libcore.io.DiskLruCache";
        r7 = r7.equals(r1);	 Catch:{ all -> 0x008e }
        if (r7 == 0) goto L_0x0055;
    L_0x002d:
        r7 = "1";
        r7 = r7.equals(r2);	 Catch:{ all -> 0x008e }
        if (r7 == 0) goto L_0x0055;
    L_0x0035:
        r7 = r10.f2440g;	 Catch:{ all -> 0x008e }
        r7 = java.lang.Integer.toString(r7);	 Catch:{ all -> 0x008e }
        r4 = r7.equals(r4);	 Catch:{ all -> 0x008e }
        if (r4 == 0) goto L_0x0055;
    L_0x0041:
        r4 = r10.f2443j;	 Catch:{ all -> 0x008e }
        r4 = java.lang.Integer.toString(r4);	 Catch:{ all -> 0x008e }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x008e }
        if (r4 == 0) goto L_0x0055;
    L_0x004d:
        r4 = "";
        r4 = r4.equals(r6);	 Catch:{ all -> 0x008e }
        if (r4 != 0) goto L_0x0093;
    L_0x0055:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x008e }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r7 = "unexpected journal header: [";
        r4.<init>(r7);	 Catch:{ all -> 0x008e }
        r1 = r4.append(r1);	 Catch:{ all -> 0x008e }
        r4 = ", ";
        r1 = r1.append(r4);	 Catch:{ all -> 0x008e }
        r1 = r1.append(r2);	 Catch:{ all -> 0x008e }
        r2 = ", ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x008e }
        r1 = r1.append(r5);	 Catch:{ all -> 0x008e }
        r2 = ", ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x008e }
        r1 = r1.append(r6);	 Catch:{ all -> 0x008e }
        r2 = "]";
        r1 = r1.append(r2);	 Catch:{ all -> 0x008e }
        r1 = r1.toString();	 Catch:{ all -> 0x008e }
        r0.<init>(r1);	 Catch:{ all -> 0x008e }
        throw r0;	 Catch:{ all -> 0x008e }
    L_0x008e:
        r0 = move-exception;
        com.nostra13.universalimageloader.p057a.p058a.p059a.p060a.C0983g.m2788a(r3);
        throw r0;
    L_0x0093:
        r1 = r0;
    L_0x0094:
        r4 = r3.mo6143a();	 Catch:{ EOFException -> 0x00b5 }
        r0 = 32;
        r5 = r4.indexOf(r0);	 Catch:{ EOFException -> 0x00b5 }
        if (r5 != r8) goto L_0x00c4;
    L_0x00a0:
        r0 = new java.io.IOException;	 Catch:{ EOFException -> 0x00b5 }
        r2 = new java.lang.StringBuilder;	 Catch:{ EOFException -> 0x00b5 }
        r5 = "unexpected journal line: ";
        r2.<init>(r5);	 Catch:{ EOFException -> 0x00b5 }
        r2 = r2.append(r4);	 Catch:{ EOFException -> 0x00b5 }
        r2 = r2.toString();	 Catch:{ EOFException -> 0x00b5 }
        r0.<init>(r2);	 Catch:{ EOFException -> 0x00b5 }
        throw r0;	 Catch:{ EOFException -> 0x00b5 }
    L_0x00b5:
        r0 = move-exception;
        r0 = r10.f2447n;	 Catch:{ all -> 0x008e }
        r0 = r0.size();	 Catch:{ all -> 0x008e }
        r0 = r1 - r0;
        r10.f2448o = r0;	 Catch:{ all -> 0x008e }
        com.nostra13.universalimageloader.p057a.p058a.p059a.p060a.C0983g.m2788a(r3);
        return;
    L_0x00c4:
        r0 = r5 + 1;
        r2 = 32;
        r6 = r4.indexOf(r2, r0);	 Catch:{ EOFException -> 0x00b5 }
        if (r6 != r8) goto L_0x00e6;
    L_0x00ce:
        r0 = r4.substring(r0);	 Catch:{ EOFException -> 0x00b5 }
        r2 = 6;
        if (r5 != r2) goto L_0x015b;
    L_0x00d5:
        r2 = "REMOVE";
        r2 = r4.startsWith(r2);	 Catch:{ EOFException -> 0x00b5 }
        if (r2 == 0) goto L_0x015b;
    L_0x00dd:
        r2 = r10.f2447n;	 Catch:{ EOFException -> 0x00b5 }
        r2.remove(r0);	 Catch:{ EOFException -> 0x00b5 }
    L_0x00e2:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0094;
    L_0x00e6:
        r0 = r4.substring(r0, r6);	 Catch:{ EOFException -> 0x00b5 }
        r2 = r0;
    L_0x00eb:
        r0 = r10.f2447n;	 Catch:{ EOFException -> 0x00b5 }
        r0 = r0.get(r2);	 Catch:{ EOFException -> 0x00b5 }
        r0 = (com.nostra13.universalimageloader.p057a.p058a.p059a.p060a.C0975a.C0973b) r0;	 Catch:{ EOFException -> 0x00b5 }
        if (r0 != 0) goto L_0x0100;
    L_0x00f5:
        r0 = new com.nostra13.universalimageloader.a.a.a.a.a$b;	 Catch:{ EOFException -> 0x00b5 }
        r7 = 0;
        r0.<init>(r10, r2, r7);	 Catch:{ EOFException -> 0x00b5 }
        r7 = r10.f2447n;	 Catch:{ EOFException -> 0x00b5 }
        r7.put(r2, r0);	 Catch:{ EOFException -> 0x00b5 }
    L_0x0100:
        if (r6 == r8) goto L_0x0123;
    L_0x0102:
        if (r5 != r9) goto L_0x0123;
    L_0x0104:
        r2 = "CLEAN";
        r2 = r4.startsWith(r2);	 Catch:{ EOFException -> 0x00b5 }
        if (r2 == 0) goto L_0x0123;
    L_0x010c:
        r2 = r6 + 1;
        r2 = r4.substring(r2);	 Catch:{ EOFException -> 0x00b5 }
        r4 = " ";
        r2 = r2.split(r4);	 Catch:{ EOFException -> 0x00b5 }
        r0.f2424d = true;	 Catch:{ EOFException -> 0x00b5 }
        r4 = 0;
        r0.f2425e = r4;	 Catch:{ EOFException -> 0x00b5 }
        com.nostra13.universalimageloader.p057a.p058a.p059a.p060a.C0975a.C0973b.m2739a(r0, r2);	 Catch:{ EOFException -> 0x00b5 }
        goto L_0x00e2;
    L_0x0123:
        if (r6 != r8) goto L_0x0139;
    L_0x0125:
        if (r5 != r9) goto L_0x0139;
    L_0x0127:
        r2 = "DIRTY";
        r2 = r4.startsWith(r2);	 Catch:{ EOFException -> 0x00b5 }
        if (r2 == 0) goto L_0x0139;
    L_0x012f:
        r2 = new com.nostra13.universalimageloader.a.a.a.a.a$a;	 Catch:{ EOFException -> 0x00b5 }
        r4 = 0;
        r2.<init>(r10, r0, r4);	 Catch:{ EOFException -> 0x00b5 }
        r0.f2425e = r2;	 Catch:{ EOFException -> 0x00b5 }
        goto L_0x00e2;
    L_0x0139:
        if (r6 != r8) goto L_0x0146;
    L_0x013b:
        r0 = 4;
        if (r5 != r0) goto L_0x0146;
    L_0x013e:
        r0 = "READ";
        r0 = r4.startsWith(r0);	 Catch:{ EOFException -> 0x00b5 }
        if (r0 != 0) goto L_0x00e2;
    L_0x0146:
        r0 = new java.io.IOException;	 Catch:{ EOFException -> 0x00b5 }
        r2 = new java.lang.StringBuilder;	 Catch:{ EOFException -> 0x00b5 }
        r5 = "unexpected journal line: ";
        r2.<init>(r5);	 Catch:{ EOFException -> 0x00b5 }
        r2 = r2.append(r4);	 Catch:{ EOFException -> 0x00b5 }
        r2 = r2.toString();	 Catch:{ EOFException -> 0x00b5 }
        r0.<init>(r2);	 Catch:{ EOFException -> 0x00b5 }
        throw r0;	 Catch:{ EOFException -> 0x00b5 }
    L_0x015b:
        r2 = r0;
        goto L_0x00eb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.a.a.a.a.a.b():void");
    }

    /* renamed from: c */
    private void m2759c() {
        C0975a.m2755a(this.f2438e);
        Iterator it = this.f2447n.values().iterator();
        while (it.hasNext()) {
            C0973b c0973b = (C0973b) it.next();
            int i;
            if (c0973b.f2425e == null) {
                for (i = 0; i < this.f2443j; i++) {
                    this.f2444k += c0973b.f2423c[i];
                    this.f2445l++;
                }
            } else {
                c0973b.f2425e = null;
                for (i = 0; i < this.f2443j; i++) {
                    C0975a.m2755a(c0973b.mo6129a(i));
                    C0975a.m2755a(c0973b.mo6131b(i));
                }
                it.remove();
            }
        }
    }

    /* renamed from: d */
    private synchronized C0972a m2761d(String str) {
        C0972a c0972a;
        m2768f();
        C0975a.m2765e(str);
        C0973b c0973b = (C0973b) this.f2447n.get(str);
        if (-1 == -1 || (c0973b != null && c0973b.f2426f == -1)) {
            C0973b c0973b2;
            if (c0973b == null) {
                c0973b = new C0973b(this, str, (byte) 0);
                this.f2447n.put(str, c0973b);
                c0973b2 = c0973b;
            } else if (c0973b.f2425e != null) {
                c0972a = null;
            } else {
                c0973b2 = c0973b;
            }
            c0972a = new C0972a(this, c0973b2, (byte) 0);
            c0973b2.f2425e = c0972a;
            this.f2446m.write("DIRTY " + str + 10);
            this.f2446m.flush();
        } else {
            c0972a = null;
        }
        return c0972a;
    }

    /* renamed from: d */
    private synchronized void m2762d() {
        if (this.f2446m != null) {
            this.f2446m.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2438e), C0983g.f2465a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2440g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2443j));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C0973b c0973b : this.f2447n.values()) {
                if (c0973b.f2425e != null) {
                    bufferedWriter.write("DIRTY " + c0973b.f2422b + 10);
                } else {
                    bufferedWriter.write("CLEAN " + c0973b.f2422b + c0973b.mo6130a() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f2437d.exists()) {
                C0975a.m2756a(this.f2437d, this.f2439f, true);
            }
            C0975a.m2756a(this.f2438e, this.f2437d, false);
            this.f2439f.delete();
            this.f2446m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2437d, true), C0983g.f2465a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    /* renamed from: e */
    private static void m2765e(String str) {
        if (!f2433a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    /* renamed from: e */
    private boolean m2766e() {
        return this.f2448o >= 2000 && this.f2448o >= this.f2447n.size();
    }

    /* renamed from: f */
    private void m2768f() {
        if (this.f2446m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: g */
    private void m2770g() {
        while (this.f2444k > this.f2441h) {
            mo6136c((String) ((Entry) this.f2447n.entrySet().iterator().next()).getKey());
        }
    }

    /* renamed from: h */
    private void m2772h() {
        while (this.f2445l > this.f2442i) {
            mo6136c((String) ((Entry) this.f2447n.entrySet().iterator().next()).getKey());
        }
    }

    /* renamed from: a */
    public final synchronized C0974c mo6134a(String str) {
        C0974c c0974c = null;
        synchronized (this) {
            m2768f();
            C0975a.m2765e(str);
            C0973b c0973b = (C0973b) this.f2447n.get(str);
            if (c0973b != null) {
                if (c0973b.f2424d) {
                    File[] fileArr = new File[this.f2443j];
                    InputStream[] inputStreamArr = new InputStream[this.f2443j];
                    int i = 0;
                    while (i < this.f2443j) {
                        try {
                            File a = c0973b.mo6129a(i);
                            fileArr[i] = a;
                            inputStreamArr[i] = new FileInputStream(a);
                            i++;
                        } catch (FileNotFoundException e) {
                            int i2 = 0;
                            while (i2 < this.f2443j && inputStreamArr[i2] != null) {
                                C0983g.m2788a(inputStreamArr[i2]);
                                i2++;
                            }
                        }
                    }
                    this.f2448o++;
                    this.f2446m.append("READ " + str + 10);
                    if (m2766e()) {
                        this.f2435b.submit(this.f2450q);
                    }
                    c0974c = new C0974c(this, str, c0973b.f2426f, fileArr, inputStreamArr, c0973b.f2423c, (byte) 0);
                }
            }
        }
        return c0974c;
    }

    /* renamed from: b */
    public final C0972a mo6135b(String str) {
        return m2761d(str);
    }

    /* renamed from: c */
    public final synchronized boolean mo6136c(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            m2768f();
            C0975a.m2765e(str);
            C0973b c0973b = (C0973b) this.f2447n.get(str);
            if (c0973b == null || c0973b.f2425e != null) {
                z = false;
            } else {
                while (i < this.f2443j) {
                    File a = c0973b.mo6129a(i);
                    if (!a.exists() || a.delete()) {
                        this.f2444k -= c0973b.f2423c[i];
                        this.f2445l--;
                        c0973b.f2423c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f2448o++;
                this.f2446m.append("REMOVE " + str + 10);
                this.f2447n.remove(str);
                if (m2766e()) {
                    this.f2435b.submit(this.f2450q);
                }
                z = true;
            }
        }
        return z;
    }

    public final synchronized void close() {
        if (this.f2446m != null) {
            Iterator it = new ArrayList(this.f2447n.values()).iterator();
            while (it.hasNext()) {
                C0973b c0973b = (C0973b) it.next();
                if (c0973b.f2425e != null) {
                    c0973b.f2425e.mo6128c();
                }
            }
            m2770g();
            m2772h();
            this.f2446m.close();
            this.f2446m = null;
        }
    }
}
