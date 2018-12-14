package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: com.nostra13.universalimageloader.core.assist.b */
public final class C1012b extends FilterInputStream {
    public C1012b(InputStream inputStream) {
        super(inputStream);
    }

    public final long skip(long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = this.in.skip(j - j2);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j2 = skip + j2;
        }
        return j2;
    }
}
