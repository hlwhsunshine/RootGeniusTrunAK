package com.tencent.p105mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p105mm.opensdk.modelbase.BaseReq;
import com.tencent.p105mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.opensdk.modelbiz.OpenWebview */
public class OpenWebview {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.OpenWebview$Req */
    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String url;

        public boolean checkArgs() {
            return this.url != null && this.url.length() >= 0 && this.url.length() <= MAX_URL_LENGHT;
        }

        public int getType() {
            return 12;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.OpenWebview$Resp */
    public static class Resp extends BaseResp {
        public String result;

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.result = bundle.getString("_wxapi_open_webview_result");
        }

        public int getType() {
            return 12;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_webview_result", this.result);
        }
    }
}
