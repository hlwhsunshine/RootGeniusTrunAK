package com.changefontmanager.sdk.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamGobbler extends Thread {
    /* renamed from: Z */
    private InputStream f1179Z;
    /* renamed from: aa */
    private OutputStream f1180aa;

    private StreamGobbler(InputStream inputStream, OutputStream outputStream) {
        this.f1179Z = inputStream;
        this.f1180aa = null;
    }

    public StreamGobbler(InputStream inputStream, String str) {
        this(inputStream, null);
    }

    public void run() {
        PrintWriter printWriter;
        InputStreamReader inputStreamReader;
        IOException e;
        InputStreamReader inputStreamReader2;
        PrintWriter printWriter2;
        Throwable th;
        BufferedReader bufferedReader = null;
        try {
            printWriter = this.f1180aa != null ? new PrintWriter(this.f1180aa) : null;
            try {
                inputStreamReader = new InputStreamReader(this.f1179Z);
            } catch (IOException e2) {
                e = e2;
                inputStreamReader2 = null;
                printWriter2 = printWriter;
                try {
                    e.printStackTrace();
                    try {
                        bufferedReader.close();
                        inputStreamReader2.close();
                        printWriter2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printWriter = printWriter2;
                    inputStreamReader = inputStreamReader2;
                    try {
                        bufferedReader.close();
                        inputStreamReader.close();
                        printWriter.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                bufferedReader.close();
                inputStreamReader.close();
                printWriter.close();
                throw th;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        } else if (this.f1180aa != null) {
                            printWriter.write(readLine);
                        }
                    } catch (IOException e5) {
                        e3 = e5;
                        bufferedReader = bufferedReader2;
                        inputStreamReader2 = inputStreamReader;
                        printWriter2 = printWriter;
                        e3.printStackTrace();
                        bufferedReader.close();
                        inputStreamReader2.close();
                        printWriter2.close();
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = bufferedReader2;
                        bufferedReader.close();
                        inputStreamReader.close();
                        printWriter.close();
                        throw th;
                    }
                }
                if (this.f1180aa != null) {
                    printWriter.flush();
                }
                try {
                    bufferedReader2.close();
                    inputStreamReader.close();
                    printWriter.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            } catch (IOException e6) {
                e32 = e6;
                inputStreamReader2 = inputStreamReader;
                printWriter2 = printWriter;
                e32.printStackTrace();
                bufferedReader.close();
                inputStreamReader2.close();
                printWriter2.close();
            } catch (Throwable th5) {
                th = th5;
                bufferedReader.close();
                inputStreamReader.close();
                printWriter.close();
                throw th;
            }
        } catch (IOException e7) {
            e32 = e7;
            inputStreamReader2 = null;
            printWriter2 = null;
            e32.printStackTrace();
            bufferedReader.close();
            inputStreamReader2.close();
            printWriter2.close();
        } catch (Throwable th6) {
            th = th6;
            inputStreamReader = null;
            printWriter = null;
            bufferedReader.close();
            inputStreamReader.close();
            printWriter.close();
            throw th;
        }
    }
}
