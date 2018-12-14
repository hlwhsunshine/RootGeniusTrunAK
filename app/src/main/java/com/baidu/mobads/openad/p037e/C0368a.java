package com.baidu.mobads.openad.p037e;

import com.baidu.mobads.openad.p020d.C0257c;
import com.baidu.mobads.openad.p036b.C0353a;
import com.baidu.mobads.openad.p036b.C0354b;
import com.baidu.mobads.openad.p036b.C0356d;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.openad.e.a */
public class C0368a extends C0257c {
    /* renamed from: a */
    public static int f783a = 1024;
    /* renamed from: b */
    protected static C0353a f784b;
    /* renamed from: d */
    private String f785d;
    /* renamed from: e */
    private AtomicBoolean f786e;
    /* renamed from: f */
    private Boolean f787f;
    /* renamed from: g */
    private HttpURLConnection f788g;
    /* renamed from: h */
    private AtomicBoolean f789h;

    static {
        try {
            f784b = new C0354b();
        } catch (ClassNotFoundException e) {
            f784b = new C0356d();
        }
        f784b.mo5066a();
    }

    public C0368a() {
        this(null);
    }

    public C0368a(String str) {
        this.f786e = new AtomicBoolean(false);
        this.f787f = Boolean.valueOf(false);
        this.f789h = new AtomicBoolean();
        this.f785d = str;
    }

    /* renamed from: b */
    private static String m658b(InputStream inputStream) {
        String str = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return str;
            }
            str = str + readLine + "\n";
        }
    }

    /* renamed from: a */
    public void mo5114a() {
        new Thread(new C0370c(this)).start();
    }

    /* renamed from: a */
    public void mo5115a(C0353a c0353a) {
        f784b = c0353a;
    }

    /* renamed from: a */
    public void mo5116a(C0371d c0371d) {
        mo5117a(c0371d, 20000.0d);
    }

    /* renamed from: a */
    public void mo5117a(C0371d c0371d, double d) {
        new C0369b(this, c0371d, d).start();
    }

    /* renamed from: a */
    public void mo5118a(C0371d c0371d, Boolean bool) {
        this.f787f = bool;
        mo5117a(c0371d, 20000.0d);
    }

    public void dispose() {
        this.f789h.set(true);
        mo5114a();
        super.dispose();
    }
}
