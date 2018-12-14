package krsdk;

import java.util.List;

public interface RootShell extends IShell {

    public static class ShellResult {
        public int ret = -1;
        public String stdout;

        public ShellResult(int i, String str) {
            this.ret = i;
            this.stdout = str;
        }

        public boolean success() {
            return this.ret == 0;
        }
    }

    void close();

    List<ShellResult> executeCommand2(List<String> list);

    ShellResult executeCommand2(String str);

    ShellResult executeCommand2(String str, long j);

    int getShellType();

    String getSrcSid();

    boolean isKuInstalled();

    boolean isSuShell();
}
