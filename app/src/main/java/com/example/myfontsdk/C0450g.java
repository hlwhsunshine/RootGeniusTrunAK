package com.example.myfontsdk;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.example.myfontsdk.g */
final class C0450g implements FilenameFilter {
    C0450g() {
    }

    public final boolean accept(File file, String str) {
        return str.endsWith(".meta");
    }
}
