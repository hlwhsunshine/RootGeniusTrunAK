package com.google.gson;

public enum LongSerializationPolicy {
    DEFAULT {
        public final C0591m serialize(Long l) {
            return new C0595p((Number) l);
        }
    },
    STRING {
        public final C0591m serialize(Long l) {
            return new C0595p(String.valueOf(l));
        }
    };

    public abstract C0591m serialize(Long l);
}
