package com.tencent.p105mm.opensdk.diffdev.p119a;

import com.p070qq.p071e.comm.constants.ErrorCode.AdError;
import com.p070qq.p071e.comm.constants.ErrorCode.NetWorkError;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.g */
public enum C1671g {
    UUID_EXPIRED(NetWorkError.RETRY_TIME_NATIVE_ERROR),
    UUID_CANCELED(NetWorkError.HTTP_STATUS_ERROR),
    UUID_SCANED(NetWorkError.TIME_OUT_ERROR),
    UUID_CONFIRM(NetWorkError.RESOURCE_LOAD_FAIL_ERROR),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(AdError.PLACEMENT_ERROR);
    
    private int code;

    private C1671g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
