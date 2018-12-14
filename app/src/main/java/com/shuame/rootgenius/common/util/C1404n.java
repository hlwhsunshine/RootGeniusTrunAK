package com.shuame.rootgenius.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.shuame.rootgenius.common.util.n */
public class C1404n {
    /* renamed from: a */
    private static final String f3888a = C1404n.class.getSimpleName();

    /* renamed from: a */
    public static Map<String, ArrayList<String>> m3906a(JSONObject jSONObject) {
        Map<String, ArrayList<String>> hashMap = new HashMap();
        if (jSONObject.optInt("result") == 1) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ArrayList arrayList = new ArrayList();
                        JSONObject jSONObject2 = (JSONObject) jSONArray.opt(i);
                        String optString = jSONObject2.optString("id");
                        JSONArray optJSONArray = jSONObject2.optJSONArray("url");
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.opt(i2).toString());
                        }
                        hashMap.put(optString, arrayList);
                    }
                    return hashMap;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
