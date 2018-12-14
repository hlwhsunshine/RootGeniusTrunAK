package com.tencent.xuanfeng.libInterface;

import com.p070qq.p071e.comm.constants.ErrorCode.OtherError;
import org.json.JSONException;
import org.json.JSONObject;

public class SpeedLimitInfo {
    static int interval = OtherError.CONTAINER_INVISIBLE_ERROR;
    static int retcode;
    static int strategy;
    static int urlspeed;

    SpeedLimitInfo() {
    }

    public static void parseJson(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt("retcode");
                int i2 = jSONObject.getInt("interval");
                int i3 = jSONObject.getInt("strategy");
                int i4 = jSONObject.getInt("urlspeed");
                if (i == 0) {
                    retcode = i;
                    interval = i2 * 60;
                    strategy = i3;
                    urlspeed = i4;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
