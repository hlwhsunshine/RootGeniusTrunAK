package android.content.p013pm;

import java.util.HashSet;

/* renamed from: android.content.pm.PackageUserState */
public class PackageUserState {
    public HashSet<String> disabledComponents;
    public int enabled;
    public HashSet<String> enabledComponents;
    public boolean installed;
    public boolean notLaunched;
    public boolean privacyGuard;
    public boolean stopped;

    public PackageUserState() {
        this.installed = true;
        this.enabled = 0;
        this.privacyGuard = false;
    }

    public PackageUserState(PackageUserState packageUserState) {
        HashSet hashSet = null;
        this.installed = packageUserState.installed;
        this.stopped = packageUserState.stopped;
        this.notLaunched = packageUserState.notLaunched;
        this.enabled = packageUserState.enabled;
        this.privacyGuard = packageUserState.privacyGuard;
        this.disabledComponents = packageUserState.disabledComponents != null ? new HashSet(packageUserState.disabledComponents) : null;
        if (packageUserState.enabledComponents != null) {
            hashSet = new HashSet(packageUserState.enabledComponents);
        }
        this.enabledComponents = hashSet;
    }
}
