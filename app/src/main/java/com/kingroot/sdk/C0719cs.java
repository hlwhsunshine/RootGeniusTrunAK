package com.kingroot.sdk;

import android.text.TextUtils;
import com.kingroot.sdk.util.C0886f;
import java.util.ArrayList;
import java.util.List;
import krsdk.C1773a;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.cs */
public abstract class C0719cs implements RootShell {
    /* renamed from: ej */
    protected int f1730ej;
    /* renamed from: ek */
    protected String f1731ek = "0";

    /* renamed from: L */
    public static boolean m1731L(String str) {
        C0886f.clean();
        boolean z = false;
        C0633at.m1464h("id = " + str);
        if (!TextUtils.isEmpty(str) && str.contains("uid=0(root)")) {
            z = true;
        }
        C0633at.m1464h("isFullyRoot|id: " + str + ", isRoot: " + z);
        if (!z) {
            C0886f.set(7012, "id=" + str);
        }
        return z;
    }

    /* renamed from: b */
    public static int m1732b(RootShell rootShell) {
        return rootShell != null ? rootShell instanceof C0719cs ? ((C0719cs) rootShell).getShellType() : -1 : 0;
    }

    /* renamed from: M */
    public void mo5696M(String str) {
        this.f1731ek = str;
    }

    public List<ShellResult> executeCommand2(List<String> list) {
        List<ShellResult> arrayList = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            arrayList.add(executeCommand2((String) list.get(i2)));
            i = i2 + 1;
        }
    }

    public ShellResult executeCommand2(String str) {
        ShellResult shellResult;
        String executeCommand = executeCommand(str + ";echo $?");
        if (executeCommand != null) {
            int lastIndexOf = executeCommand.lastIndexOf("\n", executeCommand.length() - 2);
            int lastIndexOf2 = executeCommand.lastIndexOf("\n");
            if (lastIndexOf >= 0 && lastIndexOf2 > 0) {
                try {
                    shellResult = new ShellResult(Integer.parseInt(executeCommand.substring(lastIndexOf + 1, lastIndexOf2)), executeCommand.substring(0, lastIndexOf));
                } catch (Throwable e) {
                    C0633at.m1458a("executeCommand2 exception.", e);
                    shellResult = null;
                }
            } else if (lastIndexOf == -1) {
                try {
                    shellResult = new ShellResult(Integer.parseInt(executeCommand.trim()), "");
                } catch (Throwable e2) {
                    C0633at.m1458a("executeCommand2 exception.", e2);
                    shellResult = null;
                }
            } else {
                shellResult = null;
            }
            if (shellResult == null) {
                shellResult = new ShellResult(-1, executeCommand);
            }
        } else {
            shellResult = new ShellResult(-1, C0886f.getMsgAndCause());
        }
        if (shellResult.ret == 0) {
            C0633at.m1464h("cmd: " + str + ", ret: " + shellResult.ret + ", stdout = " + shellResult.stdout);
        } else {
            C0633at.m1465i("cmd: " + str + ", ret: " + shellResult.ret + ", stdout = " + shellResult.stdout);
        }
        return shellResult;
    }

    public ShellResult executeCommand2(String str, long j) {
        C0633at.m1465i("executeCommand2() Not sopport timeout parameter.");
        return executeCommand2(str);
    }

    public int getShellType() {
        return this.f1730ej;
    }

    public String getSrcSid() {
        return this.f1731ek;
    }

    public boolean isKuInstalled() {
        return C1773a.m4825cr();
    }

    public boolean isSuShell() {
        return this.f1730ej == 4 || this.f1730ej == 3;
    }
}
