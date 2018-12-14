package com.shuame.rootgenius.sdk;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: com.shuame.rootgenius.sdk.a */
final class C1466a implements FileFilter {
    C1466a() {
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
