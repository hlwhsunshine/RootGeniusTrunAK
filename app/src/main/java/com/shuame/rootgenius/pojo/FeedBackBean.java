package com.shuame.rootgenius.pojo;

import com.google.gson.p051a.C0471c;
import com.shuame.rootgenius.common.annotation.GsonObject;
import java.util.List;

@GsonObject
public class FeedBackBean {
    @C0471c(a = "feedbacks")
    public List<FeedBackInfo> feedbacks;

    public static class FeedBackInfo {
        @C0471c(a = "problem_desc")
        /* renamed from: a */
        public String f3999a;
        @C0471c(a = "problem_id")
        /* renamed from: b */
        public int f4000b;
        @C0471c(a = "forms")
        /* renamed from: c */
        public List<FeedBackForm> f4001c;

        public static class FeedBackForm {
            @C0471c(a = "type")
            /* renamed from: a */
            public FeedBackType f3992a;
            @C0471c(a = "prompt")
            /* renamed from: b */
            public String f3993b;
            @C0471c(a = "required")
            /* renamed from: c */
            public boolean f3994c;
            @C0471c(a = "report_fail")
            /* renamed from: d */
            public String f3995d;
            @C0471c(a = "hint")
            /* renamed from: e */
            public String f3996e;
            @C0471c(a = "max_len")
            /* renamed from: f */
            public int f3997f;
            @C0471c(a = "items")
            /* renamed from: g */
            public List<C1458a> f3998g;

            public enum FeedBackType {
                single_select,
                multi_select,
                texts
            }

            /* renamed from: com.shuame.rootgenius.pojo.FeedBackBean$FeedBackInfo$FeedBackForm$a */
            public static class C1458a {
                @C0471c(a = "select_desc")
                /* renamed from: a */
                public String f3990a;
                @C0471c(a = "select_id")
                /* renamed from: b */
                public int f3991b;
            }
        }
    }
}
