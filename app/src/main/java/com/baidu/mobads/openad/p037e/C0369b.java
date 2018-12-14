package com.baidu.mobads.openad.p037e;

import android.os.Build.VERSION;
import com.baidu.mobads.openad.p020d.C0367d;
import com.baidu.mobads.p021j.C0338m;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* renamed from: com.baidu.mobads.openad.e.b */
class C0369b extends Thread {
    /* renamed from: a */
    final /* synthetic */ C0371d f790a;
    /* renamed from: b */
    final /* synthetic */ double f791b;
    /* renamed from: c */
    final /* synthetic */ C0368a f792c;

    C0369b(C0368a c0368a, C0371d c0371d, double d) {
        this.f792c = c0368a;
        this.f790a = c0371d;
        this.f791b = d;
    }

    public void run() {
        InputStream inputStream = null;
        try {
            String str;
            if (this.f790a.f796c > 0) {
                Thread.sleep(this.f790a.f796c);
            }
            this.f792c.f786e.set(true);
            this.f792c.f788g = (HttpURLConnection) new URL(this.f790a.f794a).openConnection();
            this.f792c.f788g.setConnectTimeout((int) this.f791b);
            this.f792c.f788g.setUseCaches(false);
            if (this.f790a.f795b != null && this.f790a.f795b.length() > 0) {
                this.f792c.f788g.setRequestProperty("User-Agent", this.f790a.f795b);
            }
            this.f792c.f788g.setRequestProperty("Content-type", this.f790a.f797d);
            this.f792c.f788g.setRequestProperty("Connection", "keep-alive");
            this.f792c.f788g.setRequestProperty("Cache-Control", "no-cache");
            if (Integer.parseInt(VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            if (C0368a.f784b != null) {
                str = "";
                if (this.f792c.f785d != null) {
                    str = this.f792c.f785d;
                }
                String a = C0368a.f784b.mo5065a(this.f790a.f794a);
                if (a != null) {
                    str = str + "," + a;
                }
                if (str.length() > 0) {
                    this.f792c.f788g.setRequestProperty("Cookie", str);
                }
            }
            if (this.f790a.f798e == 1) {
                this.f792c.f788g.setRequestMethod("GET");
                this.f792c.f788g.connect();
                inputStream = this.f792c.f788g.getInputStream();
                Map headerFields = this.f792c.f788g.getHeaderFields();
                if (headerFields.containsKey("Set-Cookie")) {
                    List<String> list = (List) headerFields.get("Set-Cookie");
                    if (list != null) {
                        for (String str2 : list) {
                            C0368a.f784b.mo5067a(this.f790a.f794a, str2);
                        }
                    }
                }
                if (!this.f792c.f787f.booleanValue()) {
                    this.f792c.dispatchEvent(new C0367d("URLLoader.Load.Complete", C0368a.m658b(inputStream), this.f790a.mo5121a()));
                }
            } else if (this.f790a.f798e == 0) {
                this.f792c.f788g.setRequestMethod("POST");
                this.f792c.f788g.setDoInput(true);
                this.f792c.f788g.setDoOutput(true);
                if (this.f790a.mo5124b() != null) {
                    str2 = this.f790a.mo5124b().build().getEncodedQuery();
                    OutputStream outputStream = this.f792c.f788g.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }
                this.f792c.f788g.connect();
                this.f792c.f788g.getResponseCode();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    C0338m.m569a().mo5033f().mo4929e("OAdURLLoader", e.getMessage());
                }
                try {
                    this.f792c.f788g.disconnect();
                } catch (Exception e2) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    C0338m.m569a().mo5033f().mo4929e("OAdURLLoader", e3.getMessage());
                }
                try {
                    this.f792c.f788g.disconnect();
                } catch (Exception e4) {
                }
            }
        }
    }
}
