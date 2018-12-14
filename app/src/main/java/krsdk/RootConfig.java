package krsdk;

import com.kingroot.sdk.C0627aq;
import java.io.File;

public class RootConfig {
    public static String soFileName = ("libkrsdk" + C0627aq.m1444B() + ".so");
    public int allowFailTimes = 3;
    public boolean enable64so = true;
    /* renamed from: ku */
    public int f5189ku = 0;
    /* renamed from: kv */
    public boolean f5190kv = false;
    /* renamed from: kw */
    public String f5191kw = "0";
    /* renamed from: kx */
    public boolean f5192kx = true;
    /* renamed from: ky */
    public boolean f5193ky = false;
    /* renamed from: kz */
    public String f5194kz = "";
    public boolean logSwitchOn = false;
    public boolean markCrashSolution = false;
    public String resFileName = "krsdk.res";
    public long solutionTimeout = 120000;
    public boolean useTestServer = false;
    public File workingDir;

    /* renamed from: a */
    public String mo8167a(String... strArr) {
        String absolutePath = this.workingDir.getAbsolutePath();
        for (String str : strArr) {
            absolutePath = absolutePath + File.separator + str;
        }
        return absolutePath;
    }
}
