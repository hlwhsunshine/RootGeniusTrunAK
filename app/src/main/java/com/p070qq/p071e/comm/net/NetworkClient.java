package com.p070qq.p071e.comm.net;

import com.p070qq.p071e.comm.net.p072rr.Request;
import com.p070qq.p071e.comm.net.p072rr.Response;
import java.util.concurrent.Future;

/* renamed from: com.qq.e.comm.net.NetworkClient */
public interface NetworkClient {

    /* renamed from: com.qq.e.comm.net.NetworkClient$Priority */
    public enum Priority {
        High(1),
        Mid(2),
        Low(3);
        
        /* renamed from: a */
        private int f2827a;

        private Priority(int i) {
            this.f2827a = i;
        }

        public final int value() {
            return this.f2827a;
        }
    }

    Future<Response> submit(Request request);

    Future<Response> submit(Request request, Priority priority);

    void submit(Request request, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack);
}
