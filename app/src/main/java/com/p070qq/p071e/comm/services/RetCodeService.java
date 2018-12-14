package com.p070qq.p071e.comm.services;

import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.managers.status.SDKStatus;
import com.p070qq.p071e.comm.net.NetworkClient.Priority;
import com.p070qq.p071e.comm.net.NetworkClientImpl;
import com.p070qq.p071e.comm.net.p072rr.PlainRequest;
import com.p070qq.p071e.comm.net.p072rr.Request;
import com.p070qq.p071e.comm.net.p072rr.Request.Method;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Random;

/* renamed from: com.qq.e.comm.services.RetCodeService */
public class RetCodeService {
    /* renamed from: a */
    private final Random f2866a;

    /* renamed from: com.qq.e.comm.services.RetCodeService$Holder */
    static class Holder {
        /* renamed from: a */
        static final RetCodeService f2854a = new RetCodeService();

        private Holder() {
        }
    }

    /* renamed from: com.qq.e.comm.services.RetCodeService$RetCodeInfo */
    public static class RetCodeInfo {
        /* renamed from: a */
        final String f2855a;
        /* renamed from: b */
        final String f2856b;
        /* renamed from: c */
        final String f2857c;
        /* renamed from: d */
        final int f2858d;
        /* renamed from: e */
        final int f2859e;
        /* renamed from: f */
        final int f2860f;
        /* renamed from: g */
        final int f2861g;
        /* renamed from: h */
        final int f2862h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f2855a = str;
            this.f2856b = str2;
            this.f2857c = str3;
            this.f2858d = i;
            this.f2859e = i2;
            this.f2860f = i3;
            this.f2861g = i4;
            this.f2862h = i5;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f2855a + ", commandid=" + this.f2856b + ", releaseversion=" + this.f2857c + ", resultcode=" + this.f2858d + ", tmcost=" + this.f2859e + ", reqsize=" + this.f2860f + ", rspsize=" + this.f2861g + "]";
        }
    }

    /* renamed from: com.qq.e.comm.services.RetCodeService$SendTask */
    class SendTask implements Runnable {
        /* renamed from: a */
        private RetCodeInfo f2863a;
        /* renamed from: b */
        private int f2864b = 100;

        SendTask(RetCodeInfo retCodeInfo) {
            this.f2863a = retCodeInfo;
        }

        public void run() {
            RetCodeService.m3123a(RetCodeService.this, this.f2863a, this.f2864b);
        }
    }

    private RetCodeService() {
        this.f2866a = new Random(System.currentTimeMillis());
    }

    /* synthetic */ RetCodeService(byte b) {
        this();
    }

    /* renamed from: a */
    private static String m3122a(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return "0.0.0.0";
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3123a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i) {
        Request plainRequest;
        if (retCodeService.m3124a(i)) {
            plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Method.GET, null);
            plainRequest.addQuery("appid", "1000162");
            plainRequest.addQuery("apn", String.valueOf(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue()));
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f2858d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f2859e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f2860f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f2861g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                String encode = URLEncoder.encode(GDTADManager.getInstance().getDeviceStatus().model, "utf-8");
                plainRequest.addQuery("deviceinfo", encode);
                plainRequest.addQuery("device", encode);
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f2856b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f2857c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(RetCodeService.m3122a(retCodeInfo.f2855a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, Priority.Low);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (retCodeService.m3124a(i)) {
            plainRequest = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Method.GET, null);
            plainRequest.addQuery("domain", retCodeInfo.f2855a);
            plainRequest.addQuery("cgi", retCodeInfo.f2856b);
            plainRequest.addQuery("type", String.valueOf(retCodeInfo.f2862h));
            plainRequest.addQuery("code", String.valueOf(retCodeInfo.f2858d));
            plainRequest.addQuery("time", String.valueOf(retCodeInfo.f2859e));
            plainRequest.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest, Priority.Low);
        }
    }

    /* renamed from: a */
    private boolean m3124a(int i) {
        return this.f2866a.nextDouble() < 1.0d / ((double) i);
    }

    public static RetCodeService getInstance() {
        return Holder.f2854a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo)).start();
    }
}
