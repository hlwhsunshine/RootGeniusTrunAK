package com.kingroot.sdk.util;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.kingroot.sdk.C0633at;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.kingroot.sdk.util.b */
public class C0882b implements Runnable {
    /* renamed from: es */
    private boolean f2210es = true;
    /* renamed from: gf */
    private String f2211gf;
    /* renamed from: gg */
    private int f2212gg = -1;

    public C0882b(String str) {
        this.f2211gf = str;
    }

    /* renamed from: a */
    private void m2384a(final Process process) {
        new Thread() {
            public void run() {
                try {
                    C0882b.this.f2212gg = process.waitFor();
                    C0633at.m1465i("[ExeRunner] process exit: " + C0882b.this.f2212gg);
                } catch (Throwable e) {
                    C0633at.m1458a("[ExeRunner] waitFor throw e", e);
                } catch (Throwable e2) {
                    C0633at.m1458a("[ExeRunner] waitFor throw e2", e2);
                }
                C0882b.this.f2210es = false;
            }
        }.start();
    }

    /* renamed from: bg */
    public int mo5967bg() {
        return this.f2212gg;
    }

    public void run() {
        IOException e;
        Throwable th;
        Closeable closeable = null;
        C0633at.m1464h("[ExeRunner]3 " + this.f2211gf);
        Closeable bufferedReader;
        Closeable dataOutputStream;
        try {
            Process start = new ProcessBuilder(new String[]{IXAdRequestInfo.SCREEN_HEIGHT}).redirectErrorStream(true).start();
            m2384a(start);
            bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            try {
                dataOutputStream = new DataOutputStream(start.getOutputStream());
                try {
                    dataOutputStream.write((this.f2211gf + "\n").getBytes());
                    dataOutputStream.write("exit\n".getBytes());
                    dataOutputStream.flush();
                    while (true) {
                        boolean ready = bufferedReader.ready();
                        if (!ready && !this.f2210es) {
                            break;
                        } else if (ready) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                C0633at.m1464h("[ExeRunner] " + readLine.trim());
                            }
                        } else {
                            C0889i.m2429f(500);
                        }
                    }
                    C0885e.m2419a(bufferedReader);
                    C0885e.m2419a(dataOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    closeable = bufferedReader;
                    try {
                        e.printStackTrace();
                        C0885e.m2419a(closeable);
                        C0885e.m2419a(dataOutputStream);
                        C0633at.m1464h("[ExeRunner] ret = " + this.f2212gg);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = closeable;
                        C0885e.m2419a(bufferedReader);
                        C0885e.m2419a(dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    C0885e.m2419a(bufferedReader);
                    C0885e.m2419a(dataOutputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                dataOutputStream = null;
                closeable = bufferedReader;
                e.printStackTrace();
                C0885e.m2419a(closeable);
                C0885e.m2419a(dataOutputStream);
                C0633at.m1464h("[ExeRunner] ret = " + this.f2212gg);
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
                C0885e.m2419a(bufferedReader);
                C0885e.m2419a(dataOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            dataOutputStream = null;
            e.printStackTrace();
            C0885e.m2419a(closeable);
            C0885e.m2419a(dataOutputStream);
            C0633at.m1464h("[ExeRunner] ret = " + this.f2212gg);
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream = null;
            bufferedReader = null;
            C0885e.m2419a(bufferedReader);
            C0885e.m2419a(dataOutputStream);
            throw th;
        }
        C0633at.m1464h("[ExeRunner] ret = " + this.f2212gg);
    }
}
