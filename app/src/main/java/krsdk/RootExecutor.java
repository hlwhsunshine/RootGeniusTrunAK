package krsdk;

public interface RootExecutor extends IRootConst {

    /* renamed from: krsdk.RootExecutor$a */
    public interface C0733a {
        /* renamed from: a */
        void mo5722a(int i, int i2, int i3, String str);
    }

    int checkAndPrepare();

    int checkAndPrepare(int i);

    int checkCanRoot();

    int checkCanRoot(int i);

    RootShell execute();

    RootShell getHoldShell();

    RootShell getShell();

    int prepare();
}
