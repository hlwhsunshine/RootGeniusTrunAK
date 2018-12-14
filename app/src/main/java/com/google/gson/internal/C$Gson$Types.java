package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/* renamed from: com.google.gson.internal.$Gson$Types */
public final class C$Gson$Types {
    /* renamed from: a */
    static final Type[] f1245a = new Type[0];

    /* renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = C$Gson$Types.m1031a(type);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C$Gson$Types.m1035a((Type) this, (GenericArrayType) obj);
        }

        public final Type getGenericComponentType() {
            return this.componentType;
        }

        public final int hashCode() {
            return this.componentType.hashCode();
        }

        public final String toString() {
            return C$Gson$Types.m1039c(this.componentType) + "[]";
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                int i2 = (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null) ? 1 : 0;
                boolean z = (type == null && i2 == 0) ? false : true;
                C0559a.m1262a(z);
            }
            this.ownerType = type == null ? null : C$Gson$Types.m1031a(type);
            this.rawType = C$Gson$Types.m1031a(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            while (i < this.typeArguments.length) {
                C0559a.m1261a(this.typeArguments[i]);
                C$Gson$Types.m1041e(this.typeArguments[i]);
                this.typeArguments[i] = C$Gson$Types.m1031a(this.typeArguments[i]);
                i++;
            }
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C$Gson$Types.m1035a((Type) this, (ParameterizedType) obj);
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public final Type getOwnerType() {
            return this.ownerType;
        }

        public final Type getRawType() {
            return this.rawType;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C$Gson$Types.m1030a(this.ownerType);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder((this.typeArguments.length + 1) * 30);
            stringBuilder.append(C$Gson$Types.m1039c(this.rawType));
            if (this.typeArguments.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<").append(C$Gson$Types.m1039c(this.typeArguments[0]));
            for (int i = 1; i < this.typeArguments.length; i++) {
                stringBuilder.append(", ").append(C$Gson$Types.m1039c(this.typeArguments[i]));
            }
            return stringBuilder.append(">").toString();
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    private static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            C0559a.m1262a(typeArr2.length <= 1);
            C0559a.m1262a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C0559a.m1261a(typeArr2[0]);
                C$Gson$Types.m1041e(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z = false;
                }
                C0559a.m1262a(z);
                this.lowerBound = C$Gson$Types.m1031a(typeArr2[0]);
                this.upperBound = Object.class;
                return;
            }
            C0559a.m1261a(typeArr[0]);
            C$Gson$Types.m1041e(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.m1031a(typeArr[0]);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C$Gson$Types.m1035a((Type) this, (WildcardType) obj);
        }

        public final Type[] getLowerBounds() {
            if (this.lowerBound == null) {
                return C$Gson$Types.f1245a;
            }
            return new Type[]{this.lowerBound};
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public final int hashCode() {
            return (this.lowerBound != null ? this.lowerBound.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public final String toString() {
            return this.lowerBound != null ? "? super " + C$Gson$Types.m1039c(this.lowerBound) : this.upperBound == Object.class ? "?" : "? extends " + C$Gson$Types.m1039c(this.upperBound);
        }
    }

    /* renamed from: a */
    public static Type m1031a(Type type) {
        if (type instanceof Class) {
            GenericArrayTypeImpl genericArrayTypeImpl;
            Class cls = (Class) type;
            if (cls.isArray()) {
                genericArrayTypeImpl = new GenericArrayTypeImpl(C$Gson$Types.m1031a(cls.getComponentType()));
            } else {
                Object genericArrayTypeImpl2 = cls;
            }
            return genericArrayTypeImpl2;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    /* renamed from: a */
    public static Type m1032a(Type type, Class<?> cls) {
        Type b = C$Gson$Types.m1037b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        return b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments()[0] : Object.class;
    }

    /* renamed from: a */
    private static Type m1033a(Type type, Class<?> cls, Class<?> cls2) {
        Class cls3 = cls;
        Type type2 = type;
        while (cls2 != cls3) {
            if (cls2.isInterface()) {
                Class[] interfaces = cls3.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls3.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        type = cls3.getGenericInterfaces()[i];
                        cls3 = interfaces[i];
                        type2 = type;
                        break;
                    }
                }
            }
            if (cls3.isInterface()) {
                return cls2;
            }
            while (cls3 != Object.class) {
                Class<?> superclass = cls3.getSuperclass();
                if (superclass == cls2) {
                    return cls3.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    type = cls3.getGenericSuperclass();
                    cls3 = superclass;
                    type2 = type;
                } else {
                    Class<?> cls4 = superclass;
                }
            }
            return cls2;
        }
        return type2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0039 A:{SYNTHETIC} */
    /* renamed from: a */
    public static java.lang.reflect.Type m1034a(java.lang.reflect.Type r9, java.lang.Class<?> r10, java.lang.reflect.Type r11) {
        /*
        r4 = 1;
        r3 = 0;
        r0 = r11;
    L_0x0003:
        r1 = r0 instanceof java.lang.reflect.TypeVariable;
        if (r1 == 0) goto L_0x0048;
    L_0x0007:
        r1 = r0;
        r1 = (java.lang.reflect.TypeVariable) r1;
        r0 = r1.getGenericDeclaration();
        r2 = r0 instanceof java.lang.Class;
        if (r2 == 0) goto L_0x003a;
    L_0x0012:
        r0 = (java.lang.Class) r0;
        r2 = r0;
    L_0x0015:
        if (r2 == 0) goto L_0x0046;
    L_0x0017:
        r0 = com.google.gson.internal.C$Gson$Types.m1033a(r9, r10, r2);
        r5 = r0 instanceof java.lang.reflect.ParameterizedType;
        if (r5 == 0) goto L_0x0046;
    L_0x001f:
        r5 = r2.getTypeParameters();
        r2 = r3;
    L_0x0024:
        r6 = r5.length;
        if (r2 >= r6) goto L_0x0040;
    L_0x0027:
        r6 = r5[r2];
        r6 = r1.equals(r6);
        if (r6 == 0) goto L_0x003d;
    L_0x002f:
        r0 = (java.lang.reflect.ParameterizedType) r0;
        r0 = r0.getActualTypeArguments();
        r0 = r0[r2];
    L_0x0037:
        if (r0 != r1) goto L_0x0003;
    L_0x0039:
        return r0;
    L_0x003a:
        r0 = 0;
        r2 = r0;
        goto L_0x0015;
    L_0x003d:
        r2 = r2 + 1;
        goto L_0x0024;
    L_0x0040:
        r0 = new java.util.NoSuchElementException;
        r0.<init>();
        throw r0;
    L_0x0046:
        r0 = r1;
        goto L_0x0037;
    L_0x0048:
        r1 = r0 instanceof java.lang.Class;
        if (r1 == 0) goto L_0x0066;
    L_0x004c:
        r1 = r0;
        r1 = (java.lang.Class) r1;
        r1 = r1.isArray();
        if (r1 == 0) goto L_0x0066;
    L_0x0055:
        r0 = (java.lang.Class) r0;
        r1 = r0.getComponentType();
        r2 = com.google.gson.internal.C$Gson$Types.m1034a(r9, r10, r1);
        if (r1 == r2) goto L_0x0039;
    L_0x0061:
        r0 = com.google.gson.internal.C$Gson$Types.m1042f(r2);
        goto L_0x0039;
    L_0x0066:
        r1 = r0 instanceof java.lang.reflect.GenericArrayType;
        if (r1 == 0) goto L_0x007b;
    L_0x006a:
        r0 = (java.lang.reflect.GenericArrayType) r0;
        r1 = r0.getGenericComponentType();
        r2 = com.google.gson.internal.C$Gson$Types.m1034a(r9, r10, r1);
        if (r1 == r2) goto L_0x0039;
    L_0x0076:
        r0 = com.google.gson.internal.C$Gson$Types.m1042f(r2);
        goto L_0x0039;
    L_0x007b:
        r1 = r0 instanceof java.lang.reflect.ParameterizedType;
        if (r1 == 0) goto L_0x00ba;
    L_0x007f:
        r0 = (java.lang.reflect.ParameterizedType) r0;
        r1 = r0.getOwnerType();
        r5 = com.google.gson.internal.C$Gson$Types.m1034a(r9, r10, r1);
        if (r5 == r1) goto L_0x00ac;
    L_0x008b:
        r1 = r4;
    L_0x008c:
        r2 = r0.getActualTypeArguments();
        r6 = r2.length;
    L_0x0091:
        if (r3 >= r6) goto L_0x00ae;
    L_0x0093:
        r7 = r2[r3];
        r7 = com.google.gson.internal.C$Gson$Types.m1034a(r9, r10, r7);
        r8 = r2[r3];
        if (r7 == r8) goto L_0x00a9;
    L_0x009d:
        if (r1 != 0) goto L_0x00a7;
    L_0x009f:
        r1 = r2.clone();
        r1 = (java.lang.reflect.Type[]) r1;
        r2 = r1;
        r1 = r4;
    L_0x00a7:
        r2[r3] = r7;
    L_0x00a9:
        r3 = r3 + 1;
        goto L_0x0091;
    L_0x00ac:
        r1 = r3;
        goto L_0x008c;
    L_0x00ae:
        if (r1 == 0) goto L_0x0039;
    L_0x00b0:
        r1 = r0.getRawType();
        r0 = new com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl;
        r0.<init>(r5, r1, r2);
        goto L_0x0039;
    L_0x00ba:
        r1 = r0 instanceof java.lang.reflect.WildcardType;
        if (r1 == 0) goto L_0x0039;
    L_0x00be:
        r0 = (java.lang.reflect.WildcardType) r0;
        r1 = r0.getLowerBounds();
        r2 = r0.getUpperBounds();
        r5 = r1.length;
        if (r5 != r4) goto L_0x00e6;
    L_0x00cb:
        r2 = r1[r3];
        r2 = com.google.gson.internal.C$Gson$Types.m1034a(r9, r10, r2);
        r1 = r1[r3];
        if (r2 == r1) goto L_0x0039;
    L_0x00d5:
        r0 = new com.google.gson.internal.$Gson$Types$WildcardTypeImpl;
        r1 = new java.lang.reflect.Type[r4];
        r5 = java.lang.Object.class;
        r1[r3] = r5;
        r4 = new java.lang.reflect.Type[r4];
        r4[r3] = r2;
        r0.<init>(r1, r4);
        goto L_0x0039;
    L_0x00e6:
        r1 = r2.length;
        if (r1 != r4) goto L_0x0039;
    L_0x00e9:
        r1 = r2[r3];
        r1 = com.google.gson.internal.C$Gson$Types.m1034a(r9, r10, r1);
        r2 = r2[r3];
        if (r1 == r2) goto L_0x0039;
    L_0x00f3:
        r0 = new com.google.gson.internal.$Gson$Types$WildcardTypeImpl;
        r2 = new java.lang.reflect.Type[r4];
        r2[r3] = r1;
        r1 = f1245a;
        r0.<init>(r2, r1);
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.$Gson$Types.a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    /* renamed from: a */
    public static boolean m1035a(Type type, Type type2) {
        Object obj = type2;
        Object obj2 = type;
        while (obj2 != obj) {
            if (obj2 instanceof Class) {
                return obj2.equals(obj);
            }
            if (obj2 instanceof ParameterizedType) {
                if (!(obj instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) obj2;
                ParameterizedType parameterizedType2 = (ParameterizedType) obj;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                Object obj3 = (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) ? 1 : null;
                return obj3 != null && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            } else if (obj2 instanceof GenericArrayType) {
                if (!(obj instanceof GenericArrayType)) {
                    return false;
                }
                GenericArrayType genericArrayType = (GenericArrayType) obj;
                obj2 = ((GenericArrayType) obj2).getGenericComponentType();
                obj = genericArrayType.getGenericComponentType();
            } else if (obj2 instanceof WildcardType) {
                if (!(obj instanceof WildcardType)) {
                    return false;
                }
                WildcardType wildcardType = (WildcardType) obj2;
                WildcardType wildcardType2 = (WildcardType) obj;
                return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
            } else if (!(obj2 instanceof TypeVariable)) {
                return false;
            } else {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj2;
                TypeVariable typeVariable2 = (TypeVariable) obj;
                return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
            }
        }
        return true;
    }

    /* renamed from: b */
    public static Class<?> m1036b(Type type) {
        Object obj = type;
        while (!(obj instanceof Class)) {
            if (obj instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) obj).getRawType();
                C0559a.m1262a(rawType instanceof Class);
                return (Class) rawType;
            } else if (obj instanceof GenericArrayType) {
                return Array.newInstance(C$Gson$Types.m1036b(((GenericArrayType) obj).getGenericComponentType()), 0).getClass();
            } else {
                if (obj instanceof TypeVariable) {
                    return Object.class;
                }
                if (obj instanceof WildcardType) {
                    obj = ((WildcardType) obj).getUpperBounds()[0];
                } else {
                    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + obj + "> is of type " + (obj == null ? "null" : obj.getClass().getName()));
                }
            }
        }
        return (Class) obj;
    }

    /* renamed from: b */
    private static Type m1037b(Type type, Class<?> cls, Class<?> cls2) {
        C0559a.m1262a(cls2.isAssignableFrom(cls));
        return C$Gson$Types.m1034a(type, (Class) cls, C$Gson$Types.m1033a(type, (Class) cls, (Class) cls2));
    }

    /* renamed from: b */
    public static Type[] m1038b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = C$Gson$Types.m1037b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    /* renamed from: c */
    public static String m1039c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: d */
    public static Type m1040d(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    /* renamed from: e */
    static /* synthetic */ void m1041e(Type type) {
        boolean z = ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
        C0559a.m1262a(z);
    }

    /* renamed from: f */
    private static GenericArrayType m1042f(Type type) {
        return new GenericArrayTypeImpl(type);
    }
}
