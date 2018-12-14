package com.p070qq.p071e.comm.managers.status;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.Md5Util;
import com.p070qq.p071e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.qq.e.comm.managers.status.DeviceStatus */
public class DeviceStatus {
    /* renamed from: a */
    private String f2809a;
    /* renamed from: b */
    private String f2810b;
    /* renamed from: c */
    private int f2811c;
    /* renamed from: d */
    private int f2812d;
    /* renamed from: e */
    private int f2813e;
    /* renamed from: f */
    private String f2814f;
    /* renamed from: g */
    private String f2815g;
    /* renamed from: h */
    private String f2816h;
    /* renamed from: i */
    private String f2817i;
    /* renamed from: j */
    private String f2818j;
    /* renamed from: k */
    private volatile String f2819k;
    /* renamed from: l */
    private volatile String f2820l;
    /* renamed from: m */
    private volatile float f2821m;
    public final String model = Build.MODEL;
    /* renamed from: n */
    private Context f2822n;

    public DeviceStatus(Context context) {
        this.f2822n = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f2813e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.f2811c = getVersion() > 3 ? m3111a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.f2812d = getVersion() > 3 ? m3111a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        try {
            final LocationManager locationManager = (LocationManager) this.f2822n.getSystemService("location");
            if (locationManager != null) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(2);
                criteria.setAltitudeRequired(false);
                criteria.setBearingRequired(false);
                criteria.setCostAllowed(true);
                criteria.setPowerRequirement(1);
                try {
                    String bestProvider = locationManager.getBestProvider(criteria, true);
                    Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                    if (lastKnownLocation != null) {
                        this.f2819k = lastKnownLocation.getLatitude();
                        this.f2820l = lastKnownLocation.getLongitude();
                        this.f2821m = lastKnownLocation.getAccuracy();
                        return;
                    }
                    try {
                        locationManager.requestLocationUpdates(bestProvider, 2000, 7000.0f, new LocationListener() {
                            public void onLocationChanged(Location location) {
                                try {
                                    DeviceStatus.this.f2819k = location.getLatitude();
                                    DeviceStatus.this.f2820l = location.getLongitude();
                                    locationManager.removeUpdates(this);
                                } catch (Throwable th) {
                                }
                            }

                            public void onProviderDisabled(String str) {
                            }

                            public void onProviderEnabled(String str) {
                            }

                            public void onStatusChanged(String str, int i, Bundle bundle) {
                            }
                        });
                    } catch (Throwable th) {
                    }
                } catch (Throwable th2) {
                }
            }
        } catch (Throwable th3) {
        }
    }

    /* renamed from: a */
    private int m3111a(float f, int i) {
        return (this.f2822n.getApplicationInfo().flags & 8192) != 0 ? (int) (((float) i) / f) : i;
    }

    public Carrier getCarrier() {
        String operator = getOperator();
        if (operator != null) {
            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007") || operator.equals("46020")) {
                return Carrier.CMCC;
            }
            if (operator.equals("46001") || operator.equals("46006")) {
                return Carrier.UNICOM;
            }
            if (operator.equals("46003") || operator.equals("46005")) {
                return Carrier.TELECOM;
            }
        }
        return Carrier.UNKNOWN;
    }

    public String getDataNet() {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.f2822n.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        String str;
        switch (activeNetworkInfo.getType()) {
            case 0:
                str = "ed";
                break;
            case 1:
                str = IXAdRequestInfo.WIFI;
                break;
            default:
                str = "unknow";
                break;
        }
        this.f2817i = str;
        return this.f2817i;
    }

    public int getDeviceDensity() {
        return this.f2813e;
    }

    public int getDeviceHeight() {
        return this.f2812d;
    }

    public int getDeviceWidth() {
        return this.f2811c;
    }

    public String getDid() {
        String plainDid = getPlainDid();
        return StringUtil.isEmpty(plainDid) ? "" : Md5Util.encode(plainDid);
    }

    public Map<String, String> getLacAndCeilId() {
        int i = 0;
        String operator = getOperator();
        Map<String, String> hashMap = new HashMap();
        if (!(StringUtil.isEmpty(operator) || "null".equalsIgnoreCase(operator))) {
            try {
                int parseInt = Integer.parseInt(operator.substring(0, 3));
                int parseInt2 = Integer.parseInt(operator.substring(3));
                if (parseInt == 460) {
                    int baseStationId;
                    TelephonyManager telephonyManager = (TelephonyManager) this.f2822n.getSystemService("phone");
                    if (parseInt2 == 3 || parseInt2 == 5) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                        i = cdmaCellLocation.getNetworkId();
                        baseStationId = cdmaCellLocation.getBaseStationId();
                    } else {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                        if (gsmCellLocation != null) {
                            i = gsmCellLocation.getLac();
                            baseStationId = gsmCellLocation.getCid();
                        } else {
                            baseStationId = 0;
                        }
                    }
                    hashMap.put("lac", String.valueOf(i));
                    hashMap.put("cellid", String.valueOf(baseStationId));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    public String getLanguage() {
        if (this.f2810b == null) {
            this.f2810b = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            if (this.f2810b.length() == 0) {
                this.f2810b = "en";
            }
        }
        return this.f2810b;
    }

    public String getLat() {
        return this.f2819k;
    }

    public String getLng() {
        return this.f2820l;
    }

    public float getLocationAccuracy() {
        return this.f2821m;
    }

    public NetworkType getNetworkType() {
        int parseInt;
        String dataNet = getDataNet();
        try {
            parseInt = Integer.parseInt(getPhoneNet());
        } catch (NumberFormatException e) {
            parseInt = 0;
        }
        if (dataNet != null && dataNet.equals(IXAdRequestInfo.WIFI)) {
            return NetworkType.WIFI;
        }
        switch (parseInt) {
            case 1:
            case 2:
                return NetworkType.NET_2G;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
                return NetworkType.NET_3G;
            case 13:
            case 15:
                return NetworkType.NET_4G;
            default:
                return NetworkType.UNKNOWN;
        }
    }

    public String getOperator() {
        try {
            this.f2815g = ((TelephonyManager) this.f2822n.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e) {
        }
        return this.f2815g;
    }

    public String getPhoneNet() {
        try {
            this.f2816h = ((TelephonyManager) this.f2822n.getSystemService("phone")).getNetworkType();
        } catch (Exception e) {
        }
        return this.f2816h;
    }

    public String getPlainDid() {
        if (!StringUtil.isEmpty(this.f2818j)) {
            return this.f2818j;
        }
        try {
            this.f2818j = ((TelephonyManager) this.f2822n.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            GDTLogger.m3130d("Get imei encounter error: " + e.getMessage());
        }
        return StringUtil.isEmpty(this.f2818j) ? "" : this.f2818j;
    }

    public String getScreenOrientation() {
        if (this.f2822n.getResources().getConfiguration().orientation == 2) {
            this.f2814f = "l";
        } else if (this.f2822n.getResources().getConfiguration().orientation == 1) {
            this.f2814f = "p";
        }
        return this.f2814f;
    }

    public String getUid() {
        if (this.f2809a == null) {
            String string = Secure.getString(this.f2822n.getContentResolver(), "android_id");
            this.f2809a = string == null ? Md5Util.encode("emulator") : Md5Util.encode(string);
        }
        return this.f2809a;
    }

    public int getVersion() {
        try {
            return VERSION.SDK_INT;
        } catch (Exception e) {
            return 3;
        }
    }
}
