package com.shuame.rootgenius.p110g;

import android.content.Context;
import com.google.gson.C0479d;
import com.shuame.rootgenius.pojo.FeedBackBean;
import com.shuame.rootgenius.pojo.FeedBackBean.FeedBackInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* renamed from: com.shuame.rootgenius.g.a */
public class C1435a {
    /* renamed from: a */
    private static final String f3940a = C1435a.class.getSimpleName();
    /* renamed from: b */
    private static C1435a f3941b = null;
    /* renamed from: c */
    private Context f3942c;
    /* renamed from: d */
    private FeedBackBean f3943d;

    private C1435a(Context context) {
        this.f3942c = context;
    }

    /* renamed from: a */
    public static C1435a m3973a(Context context) {
        if (f3941b == null) {
            f3941b = new C1435a(context);
        }
        return f3941b;
    }

    /* renamed from: a */
    private static String m3974a(String str, Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(str)));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str2;
                }
                str2 = str2 + readLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private static int m3975b(FeedBackBean feedBackBean) {
        return feedBackBean.feedbacks.size();
    }

    /* renamed from: a */
    public final int mo7153a(FeedBackBean feedBackBean, int i) {
        return i < C1435a.m3975b(this.f3943d) ? ((FeedBackInfo) feedBackBean.feedbacks.get(i)).f4000b : 0;
    }

    /* renamed from: a */
    public final FeedBackBean mo7154a() {
        if (this.f3943d == null) {
            this.f3943d = (FeedBackBean) new C0479d().mo5384a(C1435a.m3974a("quick_feedback_model.json", this.f3942c), new C1436b(this).mo5372b());
        }
        return this.f3943d;
    }

    /* renamed from: a */
    public final String[] mo7155a(FeedBackBean feedBackBean) {
        String[] strArr = new String[(C1435a.m3975b(feedBackBean) - 1)];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                StringBuilder append = new StringBuilder().append(i2 + 1).append(". ");
                i = i2 + 1;
                strArr[i2] = append.append(i < C1435a.m3975b(this.f3943d) ? ((FeedBackInfo) feedBackBean.feedbacks.get(i)).f3999a : "").toString();
                i = i2 + 1;
            } else {
                new StringBuilder("bean.feedbacks.size():").append(feedBackBean.feedbacks.size());
                return strArr;
            }
        }
    }
}
