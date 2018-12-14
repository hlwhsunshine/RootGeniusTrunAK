package com.kingroot.sdk;

import java.io.File;
import java.io.FileFilter;

/* renamed from: com.kingroot.sdk.fi */
public class C0817fi implements FileFilter {
    public boolean accept(File file) {
        return file.isDirectory() || file.getName().endsWith(".apk");
    }
}
