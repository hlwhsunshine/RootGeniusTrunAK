package net.tsz.afinal;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import java.lang.reflect.Field;
import net.tsz.afinal.annotation.view.EventListener;
import net.tsz.afinal.annotation.view.Select;
import net.tsz.afinal.annotation.view.ViewInject;

public class FinalActivity extends Activity {
    public static void initInjectedView(Activity activity) {
        initInjectedView(activity, activity.getWindow().getDecorView());
    }

    public static void initInjectedView(Object obj, View view) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                ViewInject viewInject = (ViewInject) field.getAnnotation(ViewInject.class);
                if (viewInject != null) {
                    int id = viewInject.mo8340id();
                    try {
                        field.setAccessible(true);
                        field.set(obj, view.findViewById(id));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Object click = viewInject.click();
                    if (!TextUtils.isEmpty(click)) {
                        setViewClickListener(view, field, click);
                    }
                    click = viewInject.longClick();
                    if (!TextUtils.isEmpty(click)) {
                        setViewLongClickListener(view, field, click);
                    }
                    click = viewInject.itemClick();
                    if (!TextUtils.isEmpty(click)) {
                        setItemClickListener(view, field, click);
                    }
                    click = viewInject.itemLongClick();
                    if (!TextUtils.isEmpty(click)) {
                        setItemLongClickListener(view, field, click);
                    }
                    Select select = viewInject.select();
                    if (!TextUtils.isEmpty(select.selected())) {
                        setViewSelectListener(view, field, select.selected(), select.noSelected());
                    }
                }
            }
        }
    }

    private static void setItemClickListener(Object obj, Field field, String str) {
        try {
            Object obj2 = field.get(obj);
            if (obj2 instanceof AbsListView) {
                ((AbsListView) obj2).setOnItemClickListener(new EventListener(obj).itemClick(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setItemLongClickListener(Object obj, Field field, String str) {
        try {
            Object obj2 = field.get(obj);
            if (obj2 instanceof AbsListView) {
                ((AbsListView) obj2).setOnItemLongClickListener(new EventListener(obj).itemLongClick(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setViewClickListener(Object obj, Field field, String str) {
        try {
            Object obj2 = field.get(obj);
            if (obj2 instanceof View) {
                ((View) obj2).setOnClickListener(new EventListener(obj).click(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setViewLongClickListener(Object obj, Field field, String str) {
        try {
            Object obj2 = field.get(obj);
            if (obj2 instanceof View) {
                ((View) obj2).setOnLongClickListener(new EventListener(obj).longClick(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setViewSelectListener(Object obj, Field field, String str, String str2) {
        try {
            Object obj2 = field.get(obj);
            if (obj2 instanceof View) {
                ((AbsListView) obj2).setOnItemSelectedListener(new EventListener(obj).select(str).noSelect(str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        initInjectedView(this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        initInjectedView(this);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        initInjectedView(this);
    }
}
