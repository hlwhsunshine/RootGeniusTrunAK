package com.shuame.rootgenius.appmanager.p091b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.TextView;
import com.shuame.rootgenius.appmanager.p094d.C1266a;
import com.shuame.rootgenius.appmanager.p096ui.view.SwipeDismissListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* renamed from: com.shuame.rootgenius.appmanager.b.d */
public final class C1259d {
    /* renamed from: A */
    private static Button f3353A;
    /* renamed from: B */
    private static Boolean f3354B = Boolean.valueOf(false);
    /* renamed from: C */
    private static Queue<C1254a> f3355C = new LinkedList();
    /* renamed from: D */
    private static Boolean f3356D = Boolean.valueOf(false);
    /* renamed from: E */
    private static Queue<C1254a> f3357E = new LinkedList();
    /* renamed from: F */
    private static Boolean f3358F = Boolean.valueOf(false);
    /* renamed from: a */
    public static TextView f3359a;
    /* renamed from: b */
    public static String f3360b;
    /* renamed from: c */
    public static String f3361c;
    /* renamed from: d */
    public static Boolean f3362d = Boolean.valueOf(false);
    /* renamed from: e */
    public static Boolean f3363e = Boolean.valueOf(false);
    /* renamed from: f */
    public static Boolean f3364f = Boolean.valueOf(false);
    /* renamed from: g */
    public static Boolean f3365g = Boolean.valueOf(false);
    /* renamed from: h */
    public static Boolean f3366h = Boolean.valueOf(false);
    /* renamed from: i */
    public static Boolean f3367i = Boolean.valueOf(false);
    /* renamed from: j */
    public static long f3368j = 0;
    /* renamed from: k */
    public static long f3369k = 0;
    /* renamed from: l */
    public static long f3370l = 0;
    /* renamed from: m */
    public static boolean f3371m = true;
    /* renamed from: n */
    private static C1259d f3372n = null;
    /* renamed from: x */
    private static SwipeDismissListView f3373x;
    /* renamed from: y */
    private static SwipeDismissListView f3374y;
    /* renamed from: z */
    private static SwipeDismissListView f3375z;
    /* renamed from: o */
    private C1257a f3376o;
    /* renamed from: p */
    private SQLiteDatabase f3377p;
    /* renamed from: q */
    private List<C1254a> f3378q;
    /* renamed from: r */
    private List<C1254a> f3379r;
    /* renamed from: s */
    private List<C1254a> f3380s;
    /* renamed from: t */
    private List<C1254a> f3381t;
    /* renamed from: u */
    private Boolean f3382u = Boolean.valueOf(true);
    /* renamed from: v */
    private int f3383v;
    /* renamed from: w */
    private List<C1258b> f3384w;

    /* renamed from: com.shuame.rootgenius.appmanager.b.d$a */
    public class C1257a extends SQLiteOpenHelper {
        /* renamed from: b */
        private final String f3352b = C1257a.class.getSimpleName();

        public C1257a(Context context) {
            super(context, "sysAppInfo.db", null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recyclebin(appName String,packageName String,apkBackupPath String,sourcedir String,appIcon String,packageSize String,flag int,appDesc String)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS backgroundinfo(packageName String,desc String)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS appHidelist(packageName String,desc String)");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* renamed from: com.shuame.rootgenius.appmanager.b.d$b */
    public interface C1258b {
        /* renamed from: a */
        void mo6895a();
    }

    private C1259d(Context context) {
        this.f3376o = new C1257a(context);
        this.f3377p = this.f3376o.getWritableDatabase();
        this.f3378q = new ArrayList();
        this.f3379r = new ArrayList();
        this.f3381t = new ArrayList();
        this.f3380s = new ArrayList();
        this.f3384w = new ArrayList();
    }

    /* renamed from: a */
    public static synchronized C1259d m3554a(Context context) {
        C1259d c1259d;
        synchronized (C1259d.class) {
            if (f3372n == null) {
                f3372n = new C1259d(context);
            }
            c1259d = f3372n;
        }
        return c1259d;
    }

    /* renamed from: a */
    public static void m3555a(Cursor cursor, C1254a c1254a) {
        c1254a.f3339c = cursor.getString(0);
        c1254a.f3337a = cursor.getString(1);
        c1254a.f3341e = cursor.getString(2);
        c1254a.f3340d = cursor.getString(3);
        c1254a.f3338b = (Drawable) C1260e.m3592a(cursor.getString(4));
        c1254a.f3342f = cursor.getString(5);
        c1254a.f3345i = cursor.getInt(6);
        c1254a.f3343g = cursor.getString(7);
    }

    /* renamed from: a */
    public static void m3556a(Cursor cursor, C1266a c1266a) {
        c1266a.f3392a = cursor.getString(0);
        c1266a.f3393b = cursor.getString(1);
    }

    /* renamed from: a */
    public static void m3557a(Button button) {
        f3353A = button;
    }

    /* renamed from: a */
    public static void m3558a(TextView textView) {
        f3359a = textView;
    }

    /* renamed from: a */
    public static void m3559a(SwipeDismissListView swipeDismissListView) {
        f3373x = swipeDismissListView;
    }

    /* renamed from: b */
    public static void m3560b(SwipeDismissListView swipeDismissListView) {
        f3374y = swipeDismissListView;
    }

    /* renamed from: b */
    public static void m3561b(Boolean bool) {
        f3354B = bool;
    }

    /* renamed from: c */
    public static void m3562c(SwipeDismissListView swipeDismissListView) {
        f3375z = swipeDismissListView;
    }

    /* renamed from: c */
    public static void m3563c(Boolean bool) {
        f3356D = bool;
    }

    /* renamed from: c */
    public static void m3564c(String str) {
        f3360b = str;
    }

    /* renamed from: d */
    public static void m3565d(String str) {
        f3361c = str;
    }

    /* renamed from: i */
    public static String m3566i() {
        return f3360b;
    }

    /* renamed from: j */
    public static SwipeDismissListView m3567j() {
        return f3373x;
    }

    /* renamed from: k */
    public static SwipeDismissListView m3568k() {
        return f3374y;
    }

    /* renamed from: l */
    public static TextView m3569l() {
        return f3359a;
    }

    /* renamed from: m */
    public static String m3570m() {
        return f3361c;
    }

    /* renamed from: n */
    public static Queue<C1254a> m3571n() {
        return f3355C;
    }

    /* renamed from: o */
    public static Boolean m3572o() {
        return f3356D;
    }

    /* renamed from: p */
    public static Button m3573p() {
        return f3353A;
    }

    /* renamed from: q */
    public static SwipeDismissListView m3574q() {
        return f3375z;
    }

    /* renamed from: a */
    public final long mo6896a(String str) {
        Cursor rawQuery = this.f3377p.rawQuery("select count(*) from " + str, null);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            return 0;
        }
        Long valueOf = Long.valueOf(rawQuery.getLong(0));
        rawQuery.close();
        return valueOf.longValue();
    }

    /* renamed from: a */
    public final void mo6897a() {
        for (C1258b a : this.f3384w) {
            a.mo6895a();
        }
    }

    /* renamed from: a */
    public final void mo6898a(int i) {
        this.f3383v = i;
    }

    /* renamed from: a */
    public final void mo6899a(C1254a c1254a) {
        String a = C1260e.m3594a(c1254a.f3338b);
        this.f3377p.execSQL("delete from recyclebin where packageName=?", new Object[]{c1254a.f3337a});
        this.f3377p.execSQL("insert into recyclebin(appName,packageName,apkBackupPath,sourcedir,appIcon,packageSize,flag,appDesc) values(?,?,?,?,?,?,?,?)", new Object[]{c1254a.f3339c, c1254a.f3337a, c1254a.f3341e, c1254a.f3340d, a, c1254a.f3342f, Integer.valueOf(c1254a.f3345i), c1254a.f3343g});
        if (this.f3382u.booleanValue()) {
            if (c1254a.f3342f.equals("系统组件")) {
                this.f3380s.remove(c1254a);
                this.f3379r.remove(c1254a);
            } else {
                this.f3380s.remove(c1254a);
                this.f3383v--;
            }
            if (!this.f3378q.contains(c1254a)) {
                this.f3378q.add(c1254a);
            }
            if (((C1254a) this.f3380s.get(0)).f3345i == 2) {
                f3359a.setVisibility(0);
                return;
            }
            return;
        }
        this.f3379r.remove(c1254a);
        if (!this.f3378q.contains(c1254a)) {
            this.f3378q.add(c1254a);
        }
    }

    /* renamed from: a */
    public final void mo6900a(C1258b c1258b) {
        this.f3384w.add(c1258b);
    }

    /* renamed from: a */
    public final void mo6901a(C1266a c1266a) {
        this.f3377p.execSQL("insert into backgroundinfo(packageName,desc) values(?,?)", new Object[]{c1266a.f3392a, c1266a.f3393b});
    }

    /* renamed from: a */
    public final void mo6902a(Boolean bool) {
        this.f3382u = bool;
    }

    /* renamed from: b */
    public final Cursor mo6903b(String str) {
        return this.f3377p.rawQuery("select * from " + str, null);
    }

    /* renamed from: b */
    public final Boolean mo6904b() {
        return this.f3382u;
    }

    /* renamed from: b */
    public final void mo6905b(C1254a c1254a) {
        this.f3377p.execSQL("delete from recyclebin where packageName=?", new Object[]{c1254a.f3337a});
        c1254a.f3346j = Boolean.valueOf(false);
        if (!this.f3382u.booleanValue()) {
            if (!this.f3379r.contains(c1254a)) {
                this.f3379r.add(c1254a);
            }
            this.f3378q.remove(c1254a);
        } else if (c1254a.f3342f.equals("系统组件")) {
            if (f3354B.booleanValue()) {
                if (!this.f3380s.contains(c1254a)) {
                    this.f3380s.add(this.f3383v + 1, c1254a);
                }
                if (!this.f3379r.contains(c1254a)) {
                    this.f3379r.add(0, c1254a);
                }
            } else if (!this.f3379r.contains(c1254a)) {
                this.f3379r.add(0, c1254a);
            }
            this.f3378q.remove(c1254a);
        } else {
            if (((C1254a) this.f3380s.get(0)).f3345i == 2) {
                f3359a.setVisibility(8);
            }
            if (!this.f3380s.contains(c1254a)) {
                this.f3380s.add(0, c1254a);
            }
            this.f3383v++;
            this.f3378q.remove(c1254a);
        }
    }

    /* renamed from: b */
    public final void mo6906b(C1266a c1266a) {
        this.f3377p.execSQL("insert into appHidelist(packageName,desc) values(?,?)", new Object[]{c1266a.f3392a, c1266a.f3393b});
    }

    /* renamed from: c */
    public final void mo6907c() {
        C1257a c1257a = this.f3376o;
        try {
            C1259d.this.f3377p.execSQL("DROP TABLE IF EXISTS recyclebin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1257a.onCreate(C1259d.this.f3377p);
        this.f3378q.clear();
    }

    /* renamed from: d */
    public final List<C1254a> mo6908d() {
        return this.f3379r;
    }

    /* renamed from: e */
    public final List<C1254a> mo6909e() {
        return this.f3381t;
    }

    /* renamed from: f */
    public final List<C1254a> mo6910f() {
        return this.f3378q;
    }

    /* renamed from: g */
    public final List<C1254a> mo6911g() {
        return this.f3380s;
    }

    /* renamed from: h */
    public final int mo6912h() {
        return this.f3383v;
    }
}
