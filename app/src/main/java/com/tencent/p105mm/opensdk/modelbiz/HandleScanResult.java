package com.tencent.p105mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p105mm.opensdk.modelbase.BaseReq;
import com.tencent.p105mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.opensdk.modelbiz.HandleScanResult */
public class HandleScanResult {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.HandleScanResult$Req */
    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String scanResult;

        public boolean checkArgs() {
            return this.scanResult != null && this.scanResult.length() >= 0 && this.scanResult.length() <= MAX_URL_LENGHT;
        }

        public int getType() {
            return 17;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_scan_qrcode_result", URLEncoder.encode(this.scanResult));
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.HandleScanResult$Resp */
    public static class Resp extends BaseResp {
        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        public int getType() {
            return 17;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }
}
