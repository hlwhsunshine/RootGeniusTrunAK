package com.tencent.p105mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p105mm.opensdk.modelbase.BaseReq;
import com.tencent.p105mm.opensdk.modelbase.BaseResp;
import com.tencent.p105mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage */
public class ChooseCardFromWXCardPackage {
    private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";

    /* renamed from: com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage$Req */
    public static class Req extends BaseReq {
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
        public String timeStamp;

        public boolean checkArgs() {
            return this.appId != null && this.appId.length() > 0 && this.signType != null && this.signType.length() > 0 && this.cardSign != null && this.cardSign.length() > 0;
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
            bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
            bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
            bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
            bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
            bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage$Resp */
    public static class Resp extends BaseResp {
        public String cardItemList;

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return (this.cardItemList == null || this.cardItemList.length() == 0) ? false : true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
            if (string == null || string.length() <= 0) {
                Log.m4581i(ChooseCardFromWXCardPackage.TAG, "cardItemList is empty!");
            } else {
                this.cardItemList = string;
            }
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
        }
    }
}
