package com.kingroot.sdk;

import java.util.ArrayList;
import java.util.List;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.cq */
public class C0717cq extends C0716ga {
    /* renamed from: eh */
    private RootShell f1728eh;

    public C0717cq(RootShell rootShell) {
        this.f1728eh = rootShell;
    }

    /* renamed from: K */
    public C0836fz mo5683K(String str) {
        ShellResult executeCommand2 = this.f1728eh.executeCommand2(str);
        return new C0836fz(str, Integer.valueOf(executeCommand2.ret), executeCommand2.stdout, "");
    }

    /* renamed from: f */
    public boolean mo5684f(boolean z) {
        return this.f1728eh != null;
    }

    /* renamed from: i */
    public List<C0836fz> mo5685i(List<String> list) {
        List<C0836fz> arrayList = new ArrayList();
        for (String K : list) {
            arrayList.add(mo5683K(K));
        }
        return arrayList;
    }
}
