package android.support.p015v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat */
public class AccessibilityWindowInfoCompat {
    private static final AccessibilityWindowInfoImpl IMPL;
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private Object mInfo;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoImpl */
    private interface AccessibilityWindowInfoImpl {
        void getBoundsInScreen(Object obj, Rect rect);

        Object getChild(Object obj, int i);

        int getChildCount(Object obj);

        int getId(Object obj);

        int getLayer(Object obj);

        Object getParent(Object obj);

        Object getRoot(Object obj);

        int getType(Object obj);

        boolean isAccessibilityFocused(Object obj);

        boolean isActive(Object obj);

        boolean isFocused(Object obj);

        Object obtain();

        Object obtain(Object obj);

        void recycle(Object obj);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoStubImpl */
    private static class AccessibilityWindowInfoStubImpl implements AccessibilityWindowInfoImpl {
        private AccessibilityWindowInfoStubImpl() {
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
        }

        public Object getChild(Object obj, int i) {
            return null;
        }

        public int getChildCount(Object obj) {
            return 0;
        }

        public int getId(Object obj) {
            return -1;
        }

        public int getLayer(Object obj) {
            return -1;
        }

        public Object getParent(Object obj) {
            return null;
        }

        public Object getRoot(Object obj) {
            return null;
        }

        public int getType(Object obj) {
            return -1;
        }

        public boolean isAccessibilityFocused(Object obj) {
            return true;
        }

        public boolean isActive(Object obj) {
            return true;
        }

        public boolean isFocused(Object obj) {
            return true;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(Object obj) {
            return null;
        }

        public void recycle(Object obj) {
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoApi21Impl */
    private static class AccessibilityWindowInfoApi21Impl extends AccessibilityWindowInfoStubImpl {
        private AccessibilityWindowInfoApi21Impl() {
            super();
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
            AccessibilityWindowInfoCompatApi21.getBoundsInScreen(obj, rect);
        }

        public Object getChild(Object obj, int i) {
            return AccessibilityWindowInfoCompatApi21.getChild(obj, i);
        }

        public int getChildCount(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getChildCount(obj);
        }

        public int getId(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getId(obj);
        }

        public int getLayer(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getLayer(obj);
        }

        public Object getParent(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getParent(obj);
        }

        public Object getRoot(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getRoot(obj);
        }

        public int getType(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getType(obj);
        }

        public boolean isAccessibilityFocused(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isAccessibilityFocused(obj);
        }

        public boolean isActive(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isActive(obj);
        }

        public boolean isFocused(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isFocused(obj);
        }

        public Object obtain() {
            return AccessibilityWindowInfoCompatApi21.obtain();
        }

        public Object obtain(Object obj) {
            return AccessibilityWindowInfoCompatApi21.obtain(obj);
        }

        public void recycle(Object obj) {
            AccessibilityWindowInfoCompatApi21.recycle(obj);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            IMPL = new AccessibilityWindowInfoApi21Impl();
        } else {
            IMPL = new AccessibilityWindowInfoStubImpl();
        }
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.obtain(accessibilityWindowInfoCompat.mInfo));
    }

    private static String typeToString(int i) {
        switch (i) {
            case 1:
                return "TYPE_APPLICATION";
            case 2:
                return "TYPE_INPUT_METHOD";
            case 3:
                return "TYPE_SYSTEM";
            case 4:
                return "TYPE_ACCESSIBILITY_OVERLAY";
            default:
                return "<UNKNOWN>";
        }
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object obj) {
        return obj != null ? new AccessibilityWindowInfoCompat(obj) : null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        return this.mInfo == null ? accessibilityWindowInfoCompat.mInfo == null : this.mInfo.equals(accessibilityWindowInfoCompat.mInfo);
    }

    public void getBoundsInScreen(Rect rect) {
        IMPL.getBoundsInScreen(this.mInfo, rect);
    }

    public AccessibilityWindowInfoCompat getChild(int i) {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getChild(this.mInfo, i));
    }

    public int getChildCount() {
        return IMPL.getChildCount(this.mInfo);
    }

    public int getId() {
        return IMPL.getId(this.mInfo);
    }

    public int getLayer() {
        return IMPL.getLayer(this.mInfo);
    }

    public AccessibilityWindowInfoCompat getParent() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getParent(this.mInfo));
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getRoot(this.mInfo));
    }

    public int getType() {
        return IMPL.getType(this.mInfo);
    }

    public int hashCode() {
        return this.mInfo == null ? 0 : this.mInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isActive() {
        return IMPL.isActive(this.mInfo);
    }

    public boolean isFocused() {
        return IMPL.isFocused(this.mInfo);
    }

    public void recycle() {
        IMPL.recycle(this.mInfo);
    }

    public String toString() {
        boolean z = true;
        StringBuilder stringBuilder = new StringBuilder();
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        stringBuilder.append("AccessibilityWindowInfo[");
        stringBuilder.append("id=").append(getId());
        stringBuilder.append(", type=").append(AccessibilityWindowInfoCompat.typeToString(getType()));
        stringBuilder.append(", layer=").append(getLayer());
        stringBuilder.append(", bounds=").append(rect);
        stringBuilder.append(", focused=").append(isFocused());
        stringBuilder.append(", active=").append(isActive());
        stringBuilder.append(", hasParent=").append(getParent() != null);
        StringBuilder append = stringBuilder.append(", hasChildren=");
        if (getChildCount() <= 0) {
            z = false;
        }
        append.append(z);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
