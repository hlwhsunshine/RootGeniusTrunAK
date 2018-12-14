package net.tsz.afinal.annotation.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import java.lang.reflect.Method;
import net.tsz.afinal.exception.ViewException;

public class EventListener implements OnClickListener, OnLongClickListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    private String clickMethod;
    private Object handler;
    private String itemClickMethod;
    private String itemLongClickMehtod;
    private String itemSelectMethod;
    private String longClickMethod;
    private String nothingSelectedMethod;

    public EventListener(Object obj) {
        this.handler = obj;
    }

    private static Object invokeClickMethod(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[]{View.class});
            if (declaredMethod != null) {
                return declaredMethod.invoke(obj, objArr);
            }
            throw new ViewException("no such method:" + str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object invokeItemClickMethod(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE});
            if (declaredMethod != null) {
                return declaredMethod.invoke(obj, objArr);
            }
            throw new ViewException("no such method:" + str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean invokeItemLongClickMethod(Object obj, String str, Object... objArr) {
        if (obj == null) {
            throw new ViewException("invokeItemLongClickMethod: handler is null :");
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE});
            if (declaredMethod != null) {
                Object invoke = declaredMethod.invoke(obj, objArr);
                return Boolean.valueOf(invoke == null ? false : Boolean.valueOf(invoke.toString()).booleanValue()).booleanValue();
            }
            throw new ViewException("no such method:" + str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Object invokeItemSelectMethod(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE});
            if (declaredMethod != null) {
                return declaredMethod.invoke(obj, objArr);
            }
            throw new ViewException("no such method:" + str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean invokeLongClickMethod(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return false;
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[]{View.class});
            if (declaredMethod != null) {
                Object invoke = declaredMethod.invoke(obj, objArr);
                return invoke != null ? Boolean.valueOf(invoke.toString()).booleanValue() : false;
            } else {
                throw new ViewException("no such method:" + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Object invokeNoSelectMethod(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[]{AdapterView.class});
            if (declaredMethod != null) {
                return declaredMethod.invoke(obj, objArr);
            }
            throw new ViewException("no such method:" + str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public EventListener click(String str) {
        this.clickMethod = str;
        return this;
    }

    public EventListener itemClick(String str) {
        this.itemClickMethod = str;
        return this;
    }

    public EventListener itemLongClick(String str) {
        this.itemLongClickMehtod = str;
        return this;
    }

    public EventListener longClick(String str) {
        this.longClickMethod = str;
        return this;
    }

    public EventListener noSelect(String str) {
        this.nothingSelectedMethod = str;
        return this;
    }

    public void onClick(View view) {
        invokeClickMethod(this.handler, this.clickMethod, view);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        invokeItemClickMethod(this.handler, this.itemClickMethod, adapterView, view, Integer.valueOf(i), Long.valueOf(j));
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return invokeItemLongClickMethod(this.handler, this.itemLongClickMehtod, adapterView, view, Integer.valueOf(i), Long.valueOf(j));
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        invokeItemSelectMethod(this.handler, this.itemSelectMethod, adapterView, view, Integer.valueOf(i), Long.valueOf(j));
    }

    public boolean onLongClick(View view) {
        return invokeLongClickMethod(this.handler, this.longClickMethod, view);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        invokeNoSelectMethod(this.handler, this.nothingSelectedMethod, adapterView);
    }

    public EventListener select(String str) {
        this.itemSelectMethod = str;
        return this;
    }
}
