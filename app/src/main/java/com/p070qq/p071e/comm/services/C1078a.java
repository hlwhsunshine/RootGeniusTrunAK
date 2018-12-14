package com.p070qq.p071e.comm.services;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.constants.Constants.KEYS;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.managers.plugin.C1061PM;
import com.p070qq.p071e.comm.managers.setting.C1066SM;
import com.p070qq.p071e.comm.managers.status.APPStatus;
import com.p070qq.p071e.comm.managers.status.DeviceStatus;
import com.p070qq.p071e.comm.net.NetworkCallBack;
import com.p070qq.p071e.comm.net.NetworkClient.Priority;
import com.p070qq.p071e.comm.net.NetworkClientImpl;
import com.p070qq.p071e.comm.net.p072rr.Request;
import com.p070qq.p071e.comm.net.p072rr.Response;
import com.p070qq.p071e.comm.net.p072rr.S2SSRequest;
import com.p070qq.p071e.comm.services.RetCodeService.RetCodeInfo;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.services.a */
public final class C1078a {
    /* renamed from: a */
    private static final C1078a f2870a = new C1078a();
    /* renamed from: b */
    private volatile Boolean f2871b = Boolean.valueOf(false);

    /* renamed from: a */
    public static C1078a m3125a() {
        return f2870a;
    }

    /* renamed from: a */
    private static String m3126a(Context context) {
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m3127a(C1066SM c1066sm, C1061PM c1061pm, DeviceStatus deviceStatus, APPStatus aPPStatus, Context context, long j) {
        JSONObject a;
        Throwable e;
        JSONObject jSONObject = new JSONObject();
        try {
            a = C1058a.m3067a(c1066sm);
            try {
                String str = "sig";
                JSONObject jSONObject2 = new JSONObject();
                if (c1066sm != null) {
                    jSONObject2.putOpt("app", c1066sm.getDevCloudSettingSig());
                    jSONObject2.putOpt("sdk", c1066sm.getSdkCloudSettingSig());
                }
                if (c1061pm != null) {
                    jSONObject2.putOpt("jar", c1061pm.getLocalSig());
                    jSONObject2.putOpt(KEYS.PLUGIN_VERSION, Integer.valueOf(c1061pm.getPluginVersion()));
                }
                a.put(str, jSONObject2);
                str = "dev";
                jSONObject2 = new JSONObject();
                if (deviceStatus != null) {
                    jSONObject2.putOpt("did", deviceStatus.getPlainDid());
                    jSONObject2.putOpt(IXAdRequestInfo.TEST_MODE, deviceStatus.model);
                    jSONObject2.putOpt("lg", deviceStatus.getLanguage());
                    jSONObject2.putOpt(IXAdRequestInfo.WIDTH, Integer.valueOf(deviceStatus.getDeviceWidth()));
                    jSONObject2.putOpt(IXAdRequestInfo.HEIGHT, Integer.valueOf(deviceStatus.getDeviceHeight()));
                    jSONObject2.putOpt("dd", Integer.valueOf(deviceStatus.getDeviceDensity()));
                    jSONObject2.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
                    jSONObject2.putOpt(IXAdRequestInfo.f648OS, "android");
                    jSONObject2.putOpt("op", deviceStatus.getOperator());
                    jSONObject2.putOpt("mf", Build.MANUFACTURER);
                }
                a.put(str, jSONObject2);
                a.put("app", C1058a.m3068a(aPPStatus));
                jSONObject = C1058a.m3069a(deviceStatus);
                jSONObject.putOpt("process", C1078a.m3126a(context));
                a.put("c", jSONObject);
                a.put("sdk", C1058a.m3066a(c1061pm));
                jSONObject = new JSONObject();
                jSONObject2 = new JSONObject();
                jSONObject2.put("sdk_init_time", (System.nanoTime() - j) / 1000000);
                jSONObject.put("performance", jSONObject2);
                a.put(KEYS.BIZ, jSONObject);
            } catch (JSONException e2) {
                e = e2;
                GDTLogger.m3132e("JSONException while build init req", e);
                return a.toString();
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            a = jSONObject;
            e = th;
        }
        return a.toString();
    }

    /* renamed from: a */
    public static void m3128a(String str, Throwable th) {
        if (GDTADManager.getInstance() == null || !GDTADManager.getInstance().isInitialized()) {
            GDTLogger.m3134w("Report Not Work while  ADManager  not Inited");
            return;
        }
        try {
            JSONObject a = C1058a.m3067a(GDTADManager.getInstance().getSM());
            a.put("c", C1058a.m3069a(GDTADManager.getInstance().getDeviceStatus()));
            a.put("app", C1058a.m3068a(GDTADManager.getInstance().getAppStatus()));
            Map hashMap = new HashMap();
            if (th != null) {
                hashMap.put("extype", th.getClass().getName());
                hashMap.put("ext", str + "\r" + th.getMessage() + "\r" + Arrays.toString(th.getStackTrace()));
            } else {
                hashMap.put("extype", "");
                hashMap.put("ex", str);
            }
            a.put(KEYS.BIZ, new JSONObject(hashMap));
            NetworkClientImpl.getInstance().submit(new S2SSRequest("http://sdk.e.qq.com/err", a.toString().getBytes()));
        } catch (Throwable th2) {
            GDTLogger.m3135w("Exception While build s2ss error report req", th2);
        }
    }

    /* renamed from: a */
    public final void mo6627a(Context context, final C1066SM c1066sm, final C1061PM c1061pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j) {
        if (!this.f2871b.booleanValue()) {
            synchronized (this.f2871b) {
                if (this.f2871b.booleanValue()) {
                    return;
                }
                String a = C1078a.m3127a(c1066sm, c1061pm, deviceStatus, aPPStatus, context, j);
                String str = "http://sdk.e.qq.com/activate";
                if (!StringUtil.isEmpty(c1066sm.getSuid())) {
                    str = "http://sdk.e.qq.com/launch";
                }
                final long currentTimeMillis = System.currentTimeMillis();
                NetworkCallBack c10771 = new NetworkCallBack() {
                    public final void onException(Exception exception) {
                        GDTLogger.m3132e("ActivateError", exception);
                        RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", "", -1, (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1));
                    }

                    public final void onResponse(Request request, Response response) {
                        try {
                            if (response.getStatusCode() == 200) {
                                String stringContent = response.getStringContent();
                                GDTLogger.m3130d("ACTIVERESPONSE:" + stringContent);
                                if (StringUtil.isEmpty(stringContent)) {
                                    GDTLogger.report("SDK Server response empty string,maybe zip or tea format error");
                                    RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1));
                                    return;
                                }
                                JSONObject jSONObject = new JSONObject(stringContent);
                                int i = -1;
                                if (jSONObject.has(KEYS.RET)) {
                                    i = jSONObject.getInt(KEYS.RET);
                                }
                                if (i != 0) {
                                    GDTLogger.m3131e("Response Error,retCode=" + i);
                                } else {
                                    if (jSONObject.has("suid")) {
                                        stringContent = jSONObject.getString("suid");
                                        if (!StringUtil.isEmpty(stringContent)) {
                                            c1066sm.updateSUID(stringContent);
                                        }
                                    }
                                    if (jSONObject.has("sid")) {
                                        stringContent = jSONObject.getString("sid");
                                        if (!StringUtil.isEmpty(stringContent)) {
                                            c1066sm.updateSID(stringContent);
                                        }
                                    }
                                    if (jSONObject.has("sig")) {
                                        JSONObject jSONObject2 = jSONObject.getJSONObject("sig");
                                        if (jSONObject.has("setting")) {
                                            String string;
                                            jSONObject = jSONObject.getJSONObject("setting");
                                            if (jSONObject.has("app") && jSONObject2.has("app")) {
                                                string = jSONObject.getString("app");
                                                c1066sm.updateDEVCloudSetting(jSONObject2.getString("app"), string);
                                            }
                                            if (jSONObject.has("sdk") && jSONObject2.has("sdk")) {
                                                string = jSONObject.getString("sdk");
                                                c1066sm.updateSDKCloudSetting(jSONObject2.getString("sdk"), string);
                                            }
                                            if (jSONObject.has("c")) {
                                                c1066sm.updateContextSetting(jSONObject.getString("c"));
                                            } else {
                                                c1066sm.updateContextSetting(null);
                                            }
                                        }
                                        if (jSONObject2.has("jar") && jSONObject2.has("url")) {
                                            c1061pm.update(jSONObject2.getString("jar"), jSONObject2.getString("url"));
                                        }
                                    }
                                }
                            } else {
                                GDTLogger.m3131e("SDK server response code error while launch or activate,code:" + response.getStatusCode());
                            }
                            RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1));
                        } catch (Throwable e) {
                            GDTLogger.m3132e("ActivateError", e);
                            RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1));
                        } catch (Throwable e2) {
                            GDTLogger.m3132e("Parse Active or launch response exception", e2);
                            RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1));
                        } catch (Throwable e22) {
                            Throwable th = e22;
                            RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1));
                        }
                    }
                };
                NetworkClientImpl.getInstance().submit(new S2SSRequest(str, a.getBytes()), Priority.High, c10771);
                this.f2871b = Boolean.valueOf(true);
            }
        }
    }
}
