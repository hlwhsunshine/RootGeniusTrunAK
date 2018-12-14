package com.baidu.mobads.p021j;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.p036b.C0354b;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p022a.C0239b;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.baidu.mobads.j.r */
class C0343r implements IXAdURIUitls {
    /* renamed from: a */
    private C0354b f713a;

    C0343r() {
    }

    /* renamed from: a */
    private C0354b m594a() {
        if (this.f713a == null) {
            try {
                this.f713a = new C0354b();
            } catch (ClassNotFoundException e) {
            }
        }
        return this.f713a;
    }

    /* renamed from: a */
    private Boolean m595a(String str, String str2) {
        boolean z = str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0;
        return Boolean.valueOf(z);
    }

    /* renamed from: a */
    public Boolean mo5050a(String str) {
        boolean z = m595a(str, "sms:").booleanValue() || m595a(str, "smsto:").booleanValue() || m595a(str, "mms:").booleanValue();
        return Boolean.valueOf(z);
    }

    @Deprecated
    public String addParameter(String str, String str2, String str3) {
        String fixedString = getFixedString(str);
        String queryString = getQueryString(str);
        return fixedString + "?" + (!C0338m.m569a().mo5040m().isStringAvailable(queryString) ? str2 + "=" + str3 : queryString + "&" + str2 + "=" + str3);
    }

    public String addParameters(String str, HashMap<String, String> hashMap) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (hashMap == null || hashMap.isEmpty()) {
            return stringBuilder.toString();
        }
        stringBuilder.append("?");
        for (Entry entry : hashMap.entrySet()) {
            try {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
                stringBuilder.append("&");
            } catch (Throwable e) {
                C0336j.m550a().mo4928e(e);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2.substring(0, stringBuilder2.length() - 1);
    }

    public String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public HashMap<String, String> getAllQueryParameters(String str) {
        HashMap<String, String> hashMap = new HashMap();
        Uri parse = Uri.parse(str);
        for (String str2 : getQueryParameterNames(parse)) {
            if (str2 != null && str2.length() > 0) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
        }
        return hashMap;
    }

    public String getFileName(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException e) {
            return "";
        }
    }

    public String getFixedString(String str) {
        return str == null ? null : (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public HttpURLConnection getHttpURLConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        C0354b a = m594a();
        if (a != null) {
            String a2 = a.mo5065a(url.toString());
            if (a2 != null && a2.length() > 0) {
                httpURLConnection.setRequestProperty("Cookie", a2);
            }
        }
        return httpURLConnection;
    }

    @SuppressLint({"NewApi"})
    public Set<String> getQueryParameterNames(Uri uri) {
        try {
            if (VERSION.SDK_INT >= 11) {
                return uri.getQueryParameterNames();
            }
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return Collections.emptySet();
            }
            Set linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (true) {
                int i2 = i;
                int indexOf = encodedQuery.indexOf(38, i2);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                i = encodedQuery.indexOf(61, i2);
                if (i > indexOf || i == -1) {
                    i = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i2, i)));
                i = indexOf + 1;
                if (i >= encodedQuery.length()) {
                    return Collections.unmodifiableSet(linkedHashSet);
                }
            }
        } catch (Exception e) {
            return new HashSet();
        }
    }

    public String getQueryString(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?") : null;
        return (split == null || split.length < 2) ? null : split[1];
    }

    public String getRequestAdUrl(String str, HashMap<String, String> hashMap) {
        String str2;
        C0338m a = C0338m.m569a();
        StringBuilder stringBuilder = new StringBuilder();
        if (hashMap != null) {
            int i = 0;
            for (String str3 : hashMap.keySet()) {
                int i2 = i + 1;
                str2 = (String) hashMap.get(str3);
                if (i2 == 1) {
                    stringBuilder.append(str3).append("=").append(str2);
                    i = i2;
                } else {
                    stringBuilder.append("&").append(str3).append("=").append(str2);
                    i = i2;
                }
            }
        }
        if (!C0239b.f385a.booleanValue()) {
            return str + "?code2=" + a.mo5032e().encode(stringBuilder.toString());
        }
        if (hashMap != null) {
            for (String str32 : hashMap.keySet()) {
                try {
                    str2 = (String) hashMap.get(str32);
                    if (str2 != null) {
                        hashMap.put(str32, URLEncoder.encode(str2, "UTF-8"));
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return a.mo5036i().addParameters(str, hashMap);
    }

    public Boolean isHttpProtocol(String str) {
        return m595a(str, "http:");
    }

    public Boolean isHttpsProtocol(String str) {
        return m595a(str, "https:");
    }

    public void pintHttpInNewThread(String str) {
        C0368a c0368a = new C0368a();
        C0371d c0371d = new C0371d(str, "");
        c0371d.f798e = 1;
        c0368a.mo5118a(c0371d, Boolean.valueOf(true));
    }
}
