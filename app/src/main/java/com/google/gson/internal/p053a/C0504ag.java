package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.util.BitSet;

/* renamed from: com.google.gson.internal.a.ag */
final class C0504ag extends C0477r<BitSet> {
    C0504ag() {
    }

    /* renamed from: b */
    private static BitSet m1067b(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        BitSet bitSet = new BitSet();
        c0531a.mo5483a();
        JsonToken f = c0531a.mo5490f();
        int i = 0;
        while (f != JsonToken.END_ARRAY) {
            boolean z;
            switch (f) {
                case NUMBER:
                    if (c0531a.mo5497m() == 0) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case BOOLEAN:
                    z = c0531a.mo5493i();
                    break;
                case STRING:
                    String h = c0531a.mo5492h();
                    try {
                        if (Integer.parseInt(h) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + h);
                    }
                default:
                    throw new JsonSyntaxException("Invalid bitset value type: " + f);
            }
            if (z) {
                bitSet.set(i);
            }
            i++;
            f = c0531a.mo5490f();
        }
        c0531a.mo5485b();
        return bitSet;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        BitSet bitSet = (BitSet) obj;
        if (bitSet == null) {
            c0534c.mo5519f();
            return;
        }
        c0534c.mo5509b();
        for (int i = 0; i < bitSet.length(); i++) {
            c0534c.mo5505a((long) (bitSet.get(i) ? 1 : 0));
        }
        c0534c.mo5512c();
    }
}
