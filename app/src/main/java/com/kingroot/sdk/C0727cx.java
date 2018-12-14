package com.kingroot.sdk;

import com.kingroot.sdk.C0729cy.C0728a;
import com.kingroot.sdk.util.C0886f;

/* renamed from: com.kingroot.sdk.cx */
public class C0727cx extends C0719cs {
    /* renamed from: eI */
    private Class f1757eI;
    /* renamed from: eJ */
    private Object f1758eJ;
    /* renamed from: eK */
    private Object f1759eK;
    /* renamed from: eL */
    private C0728a f1760eL;

    C0727cx(Class cls, Object obj, Object obj2, C0728a c0728a) {
        this.f1757eI = cls;
        this.f1758eJ = obj;
        this.f1759eK = obj2;
        this.f1760eL = c0728a;
    }

    public void close() {
        try {
            this.f1757eI.getMethod(this.f1760eL.f1771eX, this.f1760eL.f1772eY).invoke(this.f1758eJ, new Object[]{this.f1759eK});
        } catch (Throwable th) {
            C0633at.m1458a("调用JavaShell的close()方法异常!", th);
        }
    }

    public String executeCommand(String str) {
        String str2;
        C0886f.clean();
        C0747dj.m1814N(str);
        try {
            str2 = (String) this.f1757eI.getMethod(this.f1760eL.f1769eV, this.f1760eL.f1770eW).invoke(this.f1758eJ, new Object[]{this.f1759eK, str});
        } catch (Throwable th) {
            C0633at.m1458a("调用JavaShell的executeCommand()方法异常!", th);
            C0886f.set(7016, "jshell throw exception", th);
            str2 = null;
        }
        C0633at.m1464h("cmd: " + str + ", ret: " + str2);
        return str2;
    }
}
