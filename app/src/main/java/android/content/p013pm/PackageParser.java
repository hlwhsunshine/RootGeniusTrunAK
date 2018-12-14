package android.content.p013pm;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.shuame.mobile.sdk.FlashEngine.FlashResult;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.content.pm.PackageParser */
public class PackageParser {
    private static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    private static final String ANDROID_RESOURCES = "http://schemas.android.com/apk/res/android";
    private static final boolean DEBUG_BACKUP = false;
    private static final boolean DEBUG_JAR = false;
    private static final boolean DEBUG_PARSER = false;
    public static final NewPermissionInfo[] NEW_PERMISSIONS = new NewPermissionInfo[]{new NewPermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", 4, 0), new NewPermissionInfo("android.permission.READ_PHONE_STATE", 4, 0)};
    public static final int PARSE_CHATTY = 2;
    private static final int PARSE_DEFAULT_INSTALL_LOCATION = -1;
    public static final int PARSE_FORWARD_LOCK = 16;
    public static final int PARSE_IGNORE_PROCESSES = 8;
    public static final int PARSE_IS_SYSTEM = 1;
    public static final int PARSE_IS_SYSTEM_DIR = 64;
    public static final int PARSE_MUST_BE_APK = 4;
    public static final int PARSE_ON_SDCARD = 32;
    private static final boolean RIGID_PARSER = false;
    private static final String SDK_CODENAME = ("REL".equals(VERSION.CODENAME) ? null : VERSION.CODENAME);
    private static final int SDK_VERSION = VERSION.SDK_INT;
    public static final SplitPermissionInfo[] SPLIT_PERMISSIONS;
    private static final String TAG = "PackageParser";
    private static WeakReference<byte[]> mReadBuffer;
    private static final Object mSync = new Object();
    private static boolean sCompatibilityModeEnabled = true;
    private String mArchiveSourcePath;
    private boolean mOnlyCoreApps;
    private ParseComponentArgs mParseActivityAliasArgs;
    private ParseComponentArgs mParseActivityArgs;
    private int mParseError = 1;
    private ParsePackageItemArgs mParseInstrumentationArgs;
    private ParseComponentArgs mParseProviderArgs;
    private ParseComponentArgs mParseServiceArgs;
    private String[] mSeparateProcesses;

    /* renamed from: android.content.pm.PackageParser$Component */
    public static class Component<II extends IntentInfo> {
        public final String className;
        ComponentName componentName;
        String componentShortName;
        public final ArrayList<II> intents;
        public Bundle metaData;
        public final Package owner;

        public Component(Component<II> component) {
            this.owner = component.owner;
            this.intents = component.intents;
            this.className = component.className;
            this.componentName = component.componentName;
            this.componentShortName = component.componentShortName;
        }

        public Component(Package packageR) {
            this.owner = packageR;
            this.intents = null;
            this.className = null;
        }

        public Component(ParseComponentArgs parseComponentArgs, ComponentInfo componentInfo) {
            this((ParsePackageItemArgs) parseComponentArgs, (PackageItemInfo) componentInfo);
            if (parseComponentArgs.outError[0] == null) {
                if (parseComponentArgs.processRes != 0) {
                    componentInfo.processName = PackageParser.buildProcessName(this.owner.applicationInfo.packageName, this.owner.applicationInfo.processName, this.owner.applicationInfo.targetSdkVersion >= 8 ? "" : parseComponentArgs.f131sa.getNonResourceString(parseComponentArgs.processRes), parseComponentArgs.flags, parseComponentArgs.sepProcesses, parseComponentArgs.outError);
                }
                if (parseComponentArgs.descriptionRes != 0) {
                    componentInfo.descriptionRes = parseComponentArgs.f131sa.getResourceId(parseComponentArgs.descriptionRes, 0);
                }
                componentInfo.enabled = parseComponentArgs.f131sa.getBoolean(parseComponentArgs.enabledRes, true);
            }
        }

        public Component(ParsePackageItemArgs parsePackageItemArgs, PackageItemInfo packageItemInfo) {
            this.owner = parsePackageItemArgs.owner;
            this.intents = new ArrayList(0);
            packageItemInfo.name = PackageParser.buildClassName(this.owner.applicationInfo.packageName, "", parsePackageItemArgs.outError);
            if (packageItemInfo.name == null) {
                this.className = null;
                parsePackageItemArgs.outError[0] = parsePackageItemArgs.tag + " does not have valid android:name";
                return;
            }
            this.className = packageItemInfo.name;
            int resourceId = parsePackageItemArgs.f131sa.getResourceId(parsePackageItemArgs.iconRes, 0);
            if (resourceId != 0) {
                packageItemInfo.icon = resourceId;
                packageItemInfo.nonLocalizedLabel = null;
            }
            resourceId = parsePackageItemArgs.f131sa.getResourceId(parsePackageItemArgs.logoRes, 0);
            if (resourceId != 0) {
                packageItemInfo.logo = resourceId;
            }
            TypedValue peekValue = parsePackageItemArgs.f131sa.peekValue(parsePackageItemArgs.labelRes);
            if (peekValue != null) {
                int i = peekValue.resourceId;
                packageItemInfo.labelRes = i;
                if (i == 0) {
                    packageItemInfo.nonLocalizedLabel = peekValue.coerceToString();
                }
            }
            packageItemInfo.packageName = this.owner.packageName;
        }

        public ComponentName getComponentName() {
            if (this.componentName != null) {
                return this.componentName;
            }
            if (this.className != null) {
                this.componentName = new ComponentName(this.owner.applicationInfo.packageName, this.className);
            }
            return this.componentName;
        }

        public String getComponentShortName() {
            if (this.componentShortName != null) {
                return this.componentShortName;
            }
            ComponentName componentName = getComponentName();
            if (componentName != null) {
                this.componentShortName = componentName.flattenToShortString();
            }
            return this.componentShortName;
        }

        public void setPackageName(String str) {
            this.componentName = null;
            this.componentShortName = null;
        }
    }

    /* renamed from: android.content.pm.PackageParser$Activity */
    public static final class Activity extends Component<ActivityIntentInfo> {
        public final ActivityInfo info;

        public Activity(ParseComponentArgs parseComponentArgs, ActivityInfo activityInfo) {
            super(parseComponentArgs, (ComponentInfo) activityInfo);
            this.info = activityInfo;
            this.info.applicationInfo = parseComponentArgs.owner.applicationInfo;
        }

        public final void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public final String toString() {
            return "Activity{" + Integer.toHexString(System.identityHashCode(this)) + " " + getComponentShortName() + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$IntentInfo */
    public static class IntentInfo extends IntentFilter {
        public boolean hasDefault;
        public int icon;
        public int labelRes;
        public int logo;
        public CharSequence nonLocalizedLabel;
    }

    /* renamed from: android.content.pm.PackageParser$ActivityIntentInfo */
    public static final class ActivityIntentInfo extends IntentInfo {
        public final Activity activity;

        public ActivityIntentInfo(Activity activity) {
            this.activity = activity;
        }

        public final String toString() {
            return "ActivityIntentInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.activity.info.name + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$Instrumentation */
    public static final class Instrumentation extends Component {
        public final InstrumentationInfo info;

        public Instrumentation(ParsePackageItemArgs parsePackageItemArgs, InstrumentationInfo instrumentationInfo) {
            super(parsePackageItemArgs, (PackageItemInfo) instrumentationInfo);
            this.info = instrumentationInfo;
        }

        public final void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public final String toString() {
            return "Instrumentation{" + Integer.toHexString(System.identityHashCode(this)) + " " + getComponentShortName() + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$NewPermissionInfo */
    public static class NewPermissionInfo {
        public final int fileVersion;
        public final String name;
        public final int sdkVersion;

        public NewPermissionInfo(String str, int i, int i2) {
            this.name = str;
            this.sdkVersion = i;
            this.fileVersion = i2;
        }
    }

    /* renamed from: android.content.pm.PackageParser$Package */
    public static final class Package {
        public final ArrayList<Activity> activities = new ArrayList(0);
        public final ApplicationInfo applicationInfo = new ApplicationInfo();
        public final ArrayList<ConfigurationInfo> configPreferences = new ArrayList();
        public int installLocation;
        public final ArrayList<Instrumentation> instrumentation = new ArrayList(0);
        public ArrayList<String> mAdoptPermissions = null;
        public Bundle mAppMetaData = null;
        public boolean mDidDexOpt;
        public Object mExtras;
        public boolean mIsThemeApk = false;
        public boolean mOperationPending;
        public ArrayList<String> mOriginalPackages = null;
        public String mPath;
        public int mPreferredOrder = 0;
        public String mRealPackage = null;
        public String mScanPath;
        public String mSharedUserId;
        public int mSharedUserLabel;
        public Signature[] mSignatures;
        public final ArrayList<ThemeInfo> mThemeInfos = new ArrayList(0);
        public int mVersionCode;
        public String mVersionName;
        public ManifestDigest manifestDigest;
        public String packageName;
        public final ArrayList<PermissionGroup> permissionGroups = new ArrayList(0);
        public final ArrayList<Permission> permissions = new ArrayList(0);
        public ArrayList<String> protectedBroadcasts;
        public final ArrayList<Provider> providers = new ArrayList(0);
        public final ArrayList<Activity> receivers = new ArrayList(0);
        public ArrayList<FeatureInfo> reqFeatures = null;
        public final ArrayList<String> requestedPermissions = new ArrayList();
        public final ArrayList<Boolean> requestedPermissionsRequired = new ArrayList();
        public final ArrayList<Service> services = new ArrayList(0);
        public ArrayList<String> usesLibraries = null;
        public String[] usesLibraryFiles = null;
        public ArrayList<String> usesOptionalLibraries = null;

        public Package(String str) {
            this.packageName = str;
            this.applicationInfo.packageName = str;
            this.applicationInfo.uid = -1;
        }

        public final boolean hasComponentClassName(String str) {
            int size;
            for (size = this.activities.size() - 1; size >= 0; size--) {
                if (str.equals(((Activity) this.activities.get(size)).className)) {
                    return true;
                }
            }
            for (size = this.receivers.size() - 1; size >= 0; size--) {
                if (str.equals(((Activity) this.receivers.get(size)).className)) {
                    return true;
                }
            }
            for (size = this.providers.size() - 1; size >= 0; size--) {
                if (str.equals(((Provider) this.providers.get(size)).className)) {
                    return true;
                }
            }
            for (size = this.services.size() - 1; size >= 0; size--) {
                if (str.equals(((Service) this.services.get(size)).className)) {
                    return true;
                }
            }
            for (size = this.instrumentation.size() - 1; size >= 0; size--) {
                if (str.equals(((Instrumentation) this.instrumentation.get(size)).className)) {
                    return true;
                }
            }
            return false;
        }

        public final void setPackageName(String str) {
            int size;
            this.packageName = str;
            this.applicationInfo.packageName = str;
            for (size = this.permissions.size() - 1; size >= 0; size--) {
                ((Permission) this.permissions.get(size)).setPackageName(str);
            }
            for (size = this.permissionGroups.size() - 1; size >= 0; size--) {
                ((PermissionGroup) this.permissionGroups.get(size)).setPackageName(str);
            }
            for (size = this.activities.size() - 1; size >= 0; size--) {
                ((Activity) this.activities.get(size)).setPackageName(str);
            }
            for (size = this.receivers.size() - 1; size >= 0; size--) {
                ((Activity) this.receivers.get(size)).setPackageName(str);
            }
            for (size = this.providers.size() - 1; size >= 0; size--) {
                ((Provider) this.providers.get(size)).setPackageName(str);
            }
            for (size = this.services.size() - 1; size >= 0; size--) {
                ((Service) this.services.get(size)).setPackageName(str);
            }
            for (size = this.instrumentation.size() - 1; size >= 0; size--) {
                ((Instrumentation) this.instrumentation.get(size)).setPackageName(str);
            }
        }

        public final String toString() {
            return "Package{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$PackageLite */
    public static class PackageLite {
        public final int installLocation;
        public final String packageName;
        public final VerifierInfo[] verifiers;
        public final int versionCode;

        public PackageLite(String str, int i, int i2, List<VerifierInfo> list) {
            this.packageName = str;
            this.versionCode = i;
            this.installLocation = i2;
            this.verifiers = (VerifierInfo[]) list.toArray(new VerifierInfo[list.size()]);
        }
    }

    /* renamed from: android.content.pm.PackageParser$ParsePackageItemArgs */
    static class ParsePackageItemArgs {
        final int iconRes;
        final int labelRes;
        final int logoRes;
        final int nameRes;
        final String[] outError;
        final Package owner;
        /* renamed from: sa */
        TypedArray f131sa;
        String tag;

        ParsePackageItemArgs(Package packageR, String[] strArr, int i, int i2, int i3, int i4) {
            this.owner = packageR;
            this.outError = strArr;
            this.nameRes = i;
            this.labelRes = i2;
            this.iconRes = i3;
            this.logoRes = i4;
        }
    }

    /* renamed from: android.content.pm.PackageParser$ParseComponentArgs */
    static class ParseComponentArgs extends ParsePackageItemArgs {
        final int descriptionRes;
        final int enabledRes;
        int flags;
        final int processRes;
        final String[] sepProcesses;

        ParseComponentArgs(Package packageR, String[] strArr, int i, int i2, int i3, int i4, String[] strArr2, int i5, int i6, int i7) {
            super(packageR, strArr, i, i2, i3, i4);
            this.sepProcesses = strArr2;
            this.processRes = i5;
            this.descriptionRes = i6;
            this.enabledRes = i7;
        }
    }

    /* renamed from: android.content.pm.PackageParser$Permission */
    public static final class Permission extends Component<IntentInfo> {
        public PermissionGroup group;
        public final PermissionInfo info;
        public boolean tree;

        public Permission(Package packageR) {
            super(packageR);
            this.info = new PermissionInfo();
        }

        public Permission(Package packageR, PermissionInfo permissionInfo) {
            super(packageR);
            this.info = permissionInfo;
        }

        public final void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public final String toString() {
            return "Permission{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.info.name + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$PermissionGroup */
    public static final class PermissionGroup extends Component<IntentInfo> {
        public final PermissionGroupInfo info;

        public PermissionGroup(Package packageR) {
            super(packageR);
            this.info = new PermissionGroupInfo();
        }

        public PermissionGroup(Package packageR, PermissionGroupInfo permissionGroupInfo) {
            super(packageR);
            this.info = permissionGroupInfo;
        }

        public final void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public final String toString() {
            return "PermissionGroup{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.info.name + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$Provider */
    public static final class Provider extends Component {
        public final ProviderInfo info;
        public boolean syncable;

        public Provider(ParseComponentArgs parseComponentArgs, ProviderInfo providerInfo) {
            super(parseComponentArgs, (ComponentInfo) providerInfo);
            this.info = providerInfo;
            this.info.applicationInfo = parseComponentArgs.owner.applicationInfo;
            this.syncable = false;
        }

        public Provider(Provider provider) {
            super((Component) provider);
            this.info = provider.info;
            this.syncable = provider.syncable;
        }

        public final void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public final String toString() {
            return "Provider{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.info.name + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$Service */
    public static final class Service extends Component<ServiceIntentInfo> {
        public final ServiceInfo info;

        public Service(ParseComponentArgs parseComponentArgs, ServiceInfo serviceInfo) {
            super(parseComponentArgs, (ComponentInfo) serviceInfo);
            this.info = serviceInfo;
            this.info.applicationInfo = parseComponentArgs.owner.applicationInfo;
        }

        public final void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public final String toString() {
            return "Service{" + Integer.toHexString(System.identityHashCode(this)) + " " + getComponentShortName() + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$ServiceIntentInfo */
    public static final class ServiceIntentInfo extends IntentInfo {
        public final Service service;

        public ServiceIntentInfo(Service service) {
            this.service = service;
        }

        public final String toString() {
            return "ServiceIntentInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.service.info.name + "}";
        }
    }

    /* renamed from: android.content.pm.PackageParser$SplitPermissionInfo */
    public static class SplitPermissionInfo {
        public final String[] newPerms;
        public final String rootPerm;
        public final int targetSdk;

        public SplitPermissionInfo(String str, String[] strArr, int i) {
            this.rootPerm = str;
            this.newPerms = strArr;
            this.targetSdk = i;
        }
    }

    static {
        r0 = new SplitPermissionInfo[3];
        r0[0] = new SplitPermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, FlashResult.ERROR_UNKONW);
        r0[1] = new SplitPermissionInfo("android.permission.READ_CONTACTS", new String[]{"android.permission.READ_CALL_LOG"}, 16);
        r0[2] = new SplitPermissionInfo("android.permission.WRITE_CONTACTS", new String[]{"android.permission.WRITE_CALL_LOG"}, 16);
        SPLIT_PERMISSIONS = r0;
    }

    public PackageParser(String str) {
        this.mArchiveSourcePath = str;
    }

    private static String buildClassName(String str, CharSequence charSequence, String[] strArr) {
        if (charSequence == null || charSequence.length() <= 0) {
            strArr[0] = "Empty class name in package " + str;
            return null;
        }
        String charSequence2 = charSequence.toString();
        char charAt = charSequence2.charAt(0);
        if (charAt == '.') {
            return new StringBuilder(String.valueOf(str)).append(charSequence2).toString().intern();
        }
        if (charSequence2.indexOf(46) < 0) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('.');
            stringBuilder.append(charSequence2);
            return stringBuilder.toString().intern();
        } else if (charAt >= 'a' && charAt <= 'z') {
            return charSequence2.intern();
        } else {
            strArr[0] = "Bad class name " + charSequence2 + " in package " + str;
            return null;
        }
    }

    private static String buildCompoundName(String str, CharSequence charSequence, String str2, String[] strArr) {
        String charSequence2 = charSequence.toString();
        char charAt = charSequence2.charAt(0);
        String validateName;
        if (str == null || charAt != ':') {
            validateName = PackageParser.validateName(charSequence2, true);
            if (validateName == null || "system".equals(charSequence2)) {
                return charSequence2.intern();
            }
            strArr[0] = "Invalid " + str2 + " name " + charSequence2 + " in package " + str + ": " + validateName;
            return null;
        } else if (charSequence2.length() < 2) {
            strArr[0] = "Bad " + str2 + " name " + charSequence2 + " in package " + str + ": must be at least two characters";
            return null;
        } else {
            validateName = PackageParser.validateName(charSequence2.substring(1), false);
            if (validateName == null) {
                return new StringBuilder(String.valueOf(str)).append(charSequence2).toString().intern();
            }
            strArr[0] = "Invalid " + str2 + " name " + charSequence2 + " in package " + str + ": " + validateName;
            return null;
        }
    }

    private static String buildProcessName(String str, String str2, CharSequence charSequence, int i, String[] strArr, String[] strArr2) {
        if ((i & 8) != 0 && !"system".equals(charSequence)) {
            return str2 != null ? str2 : str;
        } else {
            if (strArr != null) {
                for (int length = strArr.length - 1; length >= 0; length--) {
                    String str3 = strArr[length];
                    if (str3.equals(str) || str3.equals(str2) || str3.equals(charSequence)) {
                        return str;
                    }
                }
            }
            return (charSequence == null || charSequence.length() <= 0) ? str2 : PackageParser.buildCompoundName(str, charSequence, "process", strArr2);
        }
    }

    private static String buildTaskAffinityName(String str, String str2, CharSequence charSequence, String[] strArr) {
        return charSequence == null ? str2 : charSequence.length() <= 0 ? null : PackageParser.buildCompoundName(str, charSequence, "taskAffinity", strArr);
    }

    private static boolean checkUseInstalled(int i, PackageUserState packageUserState) {
        return packageUserState.installed || (i & 8192) != 0;
    }

    private static boolean copyNeeded(int i, Package packageR, PackageUserState packageUserState, Bundle bundle, int i2) {
        if (i2 != 0) {
            return true;
        }
        if (packageUserState.enabled != 0) {
            if (packageR.applicationInfo.enabled != (packageUserState.enabled == 1)) {
                return true;
            }
        }
        return (!packageUserState.installed || packageUserState.stopped) ? true : ((i & 128) == 0 || (bundle == null && packageR.mAppMetaData == null)) ? ((i & 1024) == 0 || packageR.usesLibraryFiles == null) ? false : true : true;
    }

    public static final ActivityInfo generateActivityInfo(Activity activity, int i, PackageUserState packageUserState, int i2) {
        if (activity == null || !PackageParser.checkUseInstalled(i, packageUserState)) {
            return null;
        }
        if (!PackageParser.copyNeeded(i, activity.owner, packageUserState, activity.metaData, i2)) {
            return activity.info;
        }
        ActivityInfo activityInfo = new ActivityInfo(activity.info);
        activityInfo.metaData = activity.metaData;
        activityInfo.applicationInfo = PackageParser.generateApplicationInfo(activity.owner, i, packageUserState, i2);
        return activityInfo;
    }

    public static ApplicationInfo generateApplicationInfo(Package packageR, int i, PackageUserState packageUserState) {
        return null;
    }

    public static ApplicationInfo generateApplicationInfo(Package packageR, int i, PackageUserState packageUserState, int i2) {
        return null;
    }

    public static final InstrumentationInfo generateInstrumentationInfo(Instrumentation instrumentation, int i) {
        if (instrumentation == null) {
            return null;
        }
        if ((i & 128) == 0) {
            return instrumentation.info;
        }
        InstrumentationInfo instrumentationInfo = new InstrumentationInfo(instrumentation.info);
        instrumentationInfo.metaData = instrumentation.metaData;
        return instrumentationInfo;
    }

    public static PackageInfo generatePackageInfo(Package packageR, int[] iArr, int i, long j, long j2, HashSet<String> hashSet, PackageUserState packageUserState) {
        return null;
    }

    public static PackageInfo generatePackageInfo(Package packageR, int[] iArr, int i, long j, long j2, HashSet<String> hashSet, PackageUserState packageUserState, int i2) {
        if (!PackageParser.checkUseInstalled(i, packageUserState)) {
            return null;
        }
        int size;
        int i3;
        int size2;
        int size3;
        int i4;
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = packageR.packageName;
        packageInfo.versionCode = packageR.mVersionCode;
        packageInfo.versionName = packageR.mVersionName;
        packageInfo.sharedUserId = packageR.mSharedUserId;
        packageInfo.sharedUserLabel = packageR.mSharedUserLabel;
        packageInfo.isThemeApk = packageR.mIsThemeApk;
        packageInfo.setDrmProtectedThemeApk(false);
        if (packageInfo.isThemeApk) {
            size = packageR.mThemeInfos.size();
            if (size > 0) {
                packageInfo.themeInfos = new ThemeInfo[size];
                for (i3 = 0; i3 < size; i3++) {
                    packageInfo.themeInfos[i3] = (ThemeInfo) packageR.mThemeInfos.get(i3);
                    boolean z = packageInfo.isDrmProtectedThemeApk() || packageInfo.themeInfos[i3].isDrmProtected;
                    packageInfo.setDrmProtectedThemeApk(z);
                }
                if (packageInfo.isDrmProtectedThemeApk()) {
                    packageInfo.setLockedZipFilePath(PackageParser.getLockedZipFilePath(packageR.mPath));
                }
            }
        }
        packageInfo.applicationInfo = PackageParser.generateApplicationInfo(packageR, i, packageUserState, i2);
        packageInfo.installLocation = packageR.installLocation;
        packageInfo.firstInstallTime = j;
        packageInfo.lastUpdateTime = j2;
        if ((i & 256) != 0) {
            packageInfo.gids = iArr;
        }
        if ((i & 16384) != 0) {
            size2 = packageR.configPreferences.size();
            if (size2 > 0) {
                packageInfo.configPreferences = new ConfigurationInfo[size2];
                packageR.configPreferences.toArray(packageInfo.configPreferences);
            }
            size2 = packageR.reqFeatures != null ? packageR.reqFeatures.size() : 0;
            if (size2 > 0) {
                packageInfo.reqFeatures = new FeatureInfo[size2];
                packageR.reqFeatures.toArray(packageInfo.reqFeatures);
            }
        }
        if ((i & 1) != 0) {
            size3 = packageR.activities.size();
            if (size3 > 0) {
                if ((i & 512) != 0) {
                    packageInfo.activities = new ActivityInfo[size3];
                } else {
                    i3 = 0;
                    size = 0;
                    while (size < size3) {
                        size2 = ((Activity) packageR.activities.get(size)).info.enabled ? i3 + 1 : i3;
                        size++;
                        i3 = size2;
                    }
                    packageInfo.activities = new ActivityInfo[i3];
                }
                i3 = 0;
                i4 = 0;
                while (i4 < size3) {
                    if (((Activity) packageR.activities.get(i4)).info.enabled || (i & 512) != 0) {
                        size = i3 + 1;
                        packageInfo.activities[i3] = PackageParser.generateActivityInfo((Activity) packageR.activities.get(i4), i, packageUserState, i2);
                        size2 = size;
                    } else {
                        size2 = i3;
                    }
                    i4++;
                    i3 = size2;
                }
            }
        }
        if ((i & 2) != 0) {
            size3 = packageR.receivers.size();
            if (size3 > 0) {
                if ((i & 512) != 0) {
                    packageInfo.receivers = new ActivityInfo[size3];
                } else {
                    i3 = 0;
                    size = 0;
                    while (size < size3) {
                        size2 = ((Activity) packageR.receivers.get(size)).info.enabled ? i3 + 1 : i3;
                        size++;
                        i3 = size2;
                    }
                    packageInfo.receivers = new ActivityInfo[i3];
                }
                i3 = 0;
                i4 = 0;
                while (i4 < size3) {
                    if (((Activity) packageR.receivers.get(i4)).info.enabled || (i & 512) != 0) {
                        size = i3 + 1;
                        packageInfo.receivers[i3] = PackageParser.generateActivityInfo((Activity) packageR.receivers.get(i4), i, packageUserState, i2);
                        size2 = size;
                    } else {
                        size2 = i3;
                    }
                    i4++;
                    i3 = size2;
                }
            }
        }
        if ((i & 4) != 0) {
            size3 = packageR.services.size();
            if (size3 > 0) {
                if ((i & 512) != 0) {
                    packageInfo.services = new ServiceInfo[size3];
                } else {
                    i3 = 0;
                    size = 0;
                    while (size < size3) {
                        size2 = ((Service) packageR.services.get(size)).info.enabled ? i3 + 1 : i3;
                        size++;
                        i3 = size2;
                    }
                    packageInfo.services = new ServiceInfo[i3];
                }
                i3 = 0;
                i4 = 0;
                while (i4 < size3) {
                    if (((Service) packageR.services.get(i4)).info.enabled || (i & 512) != 0) {
                        size = i3 + 1;
                        packageInfo.services[i3] = PackageParser.generateServiceInfo((Service) packageR.services.get(i4), i, packageUserState, i2);
                        size2 = size;
                    } else {
                        size2 = i3;
                    }
                    i4++;
                    i3 = size2;
                }
            }
        }
        if ((i & 8) != 0) {
            size3 = packageR.providers.size();
            if (size3 > 0) {
                if ((i & 512) != 0) {
                    packageInfo.providers = new ProviderInfo[size3];
                } else {
                    i3 = 0;
                    size = 0;
                    while (size < size3) {
                        size2 = ((Provider) packageR.providers.get(size)).info.enabled ? i3 + 1 : i3;
                        size++;
                        i3 = size2;
                    }
                    packageInfo.providers = new ProviderInfo[i3];
                }
                i3 = 0;
                i4 = 0;
                while (i4 < size3) {
                    if (((Provider) packageR.providers.get(i4)).info.enabled || (i & 512) != 0) {
                        size = i3 + 1;
                        packageInfo.providers[i3] = PackageParser.generateProviderInfo((Provider) packageR.providers.get(i4), i, packageUserState, i2);
                        size2 = size;
                    } else {
                        size2 = i3;
                    }
                    i4++;
                    i3 = size2;
                }
            }
        }
        if ((i & 16) != 0) {
            size = packageR.instrumentation.size();
            if (size > 0) {
                packageInfo.instrumentation = new InstrumentationInfo[size];
                for (i3 = 0; i3 < size; i3++) {
                    packageInfo.instrumentation[i3] = PackageParser.generateInstrumentationInfo((Instrumentation) packageR.instrumentation.get(i3), i);
                }
            }
        }
        if ((i & 4096) != 0) {
            size = packageR.permissions.size();
            if (size > 0) {
                packageInfo.permissions = new PermissionInfo[size];
                for (i3 = 0; i3 < size; i3++) {
                    packageInfo.permissions[i3] = PackageParser.generatePermissionInfo((Permission) packageR.permissions.get(i3), i);
                }
            }
            i4 = packageR.requestedPermissions.size();
            if (i4 > 0) {
                packageInfo.requestedPermissions = new String[i4];
                packageInfo.requestedPermissionsFlags = new int[i4];
                for (size = 0; size < i4; size++) {
                    String str = (String) packageR.requestedPermissions.get(size);
                    packageInfo.requestedPermissions[size] = str;
                    if (((Boolean) packageR.requestedPermissionsRequired.get(size)).booleanValue()) {
                        int[] iArr2 = packageInfo.requestedPermissionsFlags;
                        iArr2[size] = iArr2[size] | 1;
                    }
                    if (hashSet != null && hashSet.contains(str)) {
                        int[] iArr3 = packageInfo.requestedPermissionsFlags;
                        iArr3[size] = iArr3[size] | 2;
                    }
                }
            }
        }
        if ((i & 64) != 0) {
            size2 = packageR.mSignatures != null ? packageR.mSignatures.length : 0;
            if (size2 > 0) {
                packageInfo.signatures = new Signature[size2];
                System.arraycopy(packageR.mSignatures, 0, packageInfo.signatures, 0, size2);
            }
        }
        return packageInfo;
    }

    public static final PermissionGroupInfo generatePermissionGroupInfo(PermissionGroup permissionGroup, int i) {
        if (permissionGroup == null) {
            return null;
        }
        if ((i & 128) == 0) {
            return permissionGroup.info;
        }
        PermissionGroupInfo permissionGroupInfo = new PermissionGroupInfo(permissionGroup.info);
        permissionGroupInfo.metaData = permissionGroup.metaData;
        return permissionGroupInfo;
    }

    public static final PermissionInfo generatePermissionInfo(Permission permission, int i) {
        if (permission == null) {
            return null;
        }
        if ((i & 128) == 0) {
            return permission.info;
        }
        PermissionInfo permissionInfo = new PermissionInfo(permission.info);
        permissionInfo.metaData = permission.metaData;
        return permissionInfo;
    }

    public static final ProviderInfo generateProviderInfo(Provider provider, int i, PackageUserState packageUserState, int i2) {
        if (provider == null || !PackageParser.checkUseInstalled(i, packageUserState)) {
            return null;
        }
        if (!PackageParser.copyNeeded(i, provider.owner, packageUserState, provider.metaData, i2) && ((i & 2048) != 0 || provider.info.uriPermissionPatterns == null)) {
            return provider.info;
        }
        ProviderInfo providerInfo = new ProviderInfo(provider.info);
        providerInfo.metaData = provider.metaData;
        if ((i & 2048) == 0) {
            providerInfo.uriPermissionPatterns = null;
        }
        providerInfo.applicationInfo = PackageParser.generateApplicationInfo(provider.owner, i, packageUserState, i2);
        return providerInfo;
    }

    public static final ServiceInfo generateServiceInfo(Service service, int i, PackageUserState packageUserState, int i2) {
        if (service == null || !PackageParser.checkUseInstalled(i, packageUserState)) {
            return null;
        }
        if (!PackageParser.copyNeeded(i, service.owner, packageUserState, service.metaData, i2)) {
            return service.info;
        }
        ServiceInfo serviceInfo = new ServiceInfo(service.info);
        serviceInfo.metaData = service.metaData;
        serviceInfo.applicationInfo = PackageParser.generateApplicationInfo(service.owner, i, packageUserState, i2);
        return serviceInfo;
    }

    public static String getLockedZipFilePath(String str) {
        return str == null ? null : PackageParser.isPackageFilename(str) ? str.substring(0, str.length() - 4) + ".locked.zip" : new StringBuilder(String.valueOf(str)).append(".locked.zip").toString();
    }

    private static final boolean isPackageFilename(String str) {
        return str.endsWith(".apk");
    }

    private Certificate[] loadCertificates(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        try {
            InputStream bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
            } while (bufferedInputStream.read(bArr, 0, bArr.length) != -1);
            bufferedInputStream.close();
            return jarEntry != null ? jarEntry.getCertificates() : null;
        } catch (IOException e) {
            return null;
        } catch (RuntimeException e2) {
            return null;
        }
    }

    private Activity parseActivity(Package packageR, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr, boolean z, boolean z2) {
        return null;
    }

    private Activity parseActivityAlias(Package packageR, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) {
        return null;
    }

    private void parseActivityThemeAttributes(XmlPullParser xmlPullParser, AttributeSet attributeSet, ActivityInfo activityInfo) {
    }

    private boolean parseAllMetaData(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String str, Component component, String[] strArr) {
        return true;
    }

    private boolean parseApplication(Package packageR, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) {
        return true;
    }

    private void parseApplicationThemeAttributes(XmlPullParser xmlPullParser, AttributeSet attributeSet, ApplicationInfo applicationInfo) {
    }

    private Instrumentation parseInstrumentation(Package packageR, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String[] strArr) {
        return null;
    }

    private boolean parseIntent(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, IntentInfo intentInfo, String[] strArr, boolean z) {
        return true;
    }

    private Bundle parseMetaData(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Bundle bundle, String[] strArr) {
        return null;
    }

    private Package parsePackage(Resources resources, XmlResourceParser xmlResourceParser, int i, String[] strArr) {
        return null;
    }

    private boolean parsePackageItemInfo(Package packageR, PackageItemInfo packageItemInfo, String[] strArr, String str, TypedArray typedArray, int i, int i2, int i3, int i4) {
        return true;
    }

    private static PackageLite parsePackageLite(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            strArr[0] = "No start tag found";
            return null;
        } else if (xmlPullParser.getName().equals("manifest")) {
            String attributeValue = attributeSet.getAttributeValue(null, "package");
            if (attributeValue == null || attributeValue.length() == 0) {
                strArr[0] = "<manifest> does not specify package";
                return null;
            }
            String validateName = PackageParser.validateName(attributeValue, true);
            if (validateName == null || "android".equals(attributeValue)) {
                int i2;
                next = 0;
                int i3 = -1;
                int i4 = 0;
                for (i2 = 0; i2 < attributeSet.getAttributeCount(); i2++) {
                    String attributeName = attributeSet.getAttributeName(i2);
                    if (attributeName.equals("installLocation")) {
                        i3 = attributeSet.getAttributeIntValue(i2, -1);
                        i4++;
                    } else if (attributeName.equals("versionCode")) {
                        next = attributeSet.getAttributeIntValue(i2, 0);
                        i4++;
                    }
                    if (i4 >= 2) {
                        break;
                    }
                }
                i2 = xmlPullParser.getDepth() + 1;
                List arrayList = new ArrayList();
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 != 1 && (next2 != 3 || xmlPullParser.getDepth() >= i2)) {
                        if (next2 != 3 && next2 != 4 && xmlPullParser.getDepth() == i2 && "package-verifier".equals(xmlPullParser.getName())) {
                            VerifierInfo parseVerifier = PackageParser.parseVerifier(resources, xmlPullParser, attributeSet, i, strArr);
                            if (parseVerifier != null) {
                                arrayList.add(parseVerifier);
                            }
                        }
                    }
                }
                return new PackageLite(attributeValue.intern(), next, i3, arrayList);
            }
            strArr[0] = "<manifest> specifies bad package name \"" + attributeValue + "\": " + validateName;
            return null;
        } else {
            strArr[0] = "No <manifest> tag";
            return null;
        }
    }

    public static PackageLite parsePackageLite(String str, int i) {
        try {
            PackageLite parsePackageLite;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            try {
                parsePackageLite = PackageParser.parsePackageLite(new Resources(null, displayMetrics, null), null, null, i, new String[1]);
            } catch (IOException e) {
                parsePackageLite = null;
            } catch (XmlPullParserException e2) {
                parsePackageLite = null;
            }
            return parsePackageLite == null ? null : parsePackageLite;
        } catch (Exception e3) {
            return null;
        }
    }

    private static String parsePackageName(XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            strArr[0] = "No start tag found";
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "package");
        if (attributeValue == null || attributeValue.length() == 0) {
            strArr[0] = "<manifest> does not specify package";
            return null;
        }
        String validateName = PackageParser.validateName(attributeValue, true);
        if (validateName == null || "android".equals(attributeValue)) {
            return attributeValue.intern();
        }
        strArr[0] = "<manifest> specifies bad package name \"" + attributeValue + "\": " + validateName;
        return null;
    }

    private Permission parsePermission(Package packageR, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String[] strArr) {
        Permission permission = new Permission(packageR);
        return null;
    }

    private PermissionGroup parsePermissionGroup(Package packageR, int i, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String[] strArr) {
        return new PermissionGroup(packageR);
    }

    private Permission parsePermissionTree(Package packageR, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String[] strArr) {
        Permission permission = new Permission(packageR);
        return null;
    }

    private Provider parseProvider(Package packageR, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) {
        return null;
    }

    private boolean parseProviderTags(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Provider provider, String[] strArr) {
        return true;
    }

    private Service parseService(Package packageR, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) {
        return null;
    }

    private static VerifierInfo parseVerifier(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) {
        return null;
    }

    public static void setCompatibilityModeEnabled(boolean z) {
        sCompatibilityModeEnabled = z;
    }

    public static Signature stringToSignature(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return new Signature(bArr);
    }

    private static String validateName(String str, boolean z) {
        int length = str.length();
        Object obj = 1;
        Object obj2 = null;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                obj = null;
            } else if (obj != null || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                if (charAt != '.') {
                    return "bad character '" + charAt + "'";
                }
                int obj3 = 1;
                int obj22 = 1;
            }
        }
        return (obj22 == null && z) ? "must have at least one '.' separator" : null;
    }

    public boolean collectCertificates(Package packageR, int i) {
        Object obj;
        byte[] bArr;
        WeakReference weakReference;
        packageR.mSignatures = null;
        byte[] bArr2 = null;
        synchronized (mSync) {
            WeakReference weakReference2 = mReadBuffer;
            if (weakReference2 != null) {
                mReadBuffer = null;
                bArr2 = (byte[]) weakReference2.get();
            }
            if (bArr2 == null) {
                obj = new byte[8192];
                bArr = obj;
                weakReference = new WeakReference(obj);
            } else {
                bArr = bArr2;
                weakReference = weakReference2;
            }
        }
        try {
            int i2;
            int i3;
            JarFile jarFile = new JarFile(this.mArchiveSourcePath);
            Certificate[] certificateArr = null;
            if ((i & 1) != 0) {
                Certificate[] loadCertificates = loadCertificates(jarFile, jarFile.getJarEntry(ANDROID_MANIFEST_FILENAME), bArr);
                if (loadCertificates == null) {
                    jarFile.close();
                    this.mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                    return false;
                }
                certificateArr = loadCertificates;
            } else {
                Enumeration entries = jarFile.entries();
                Manifest manifest = jarFile.getManifest();
                loop1:
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) entries.nextElement();
                    if (!jarEntry.isDirectory()) {
                        String name = jarEntry.getName();
                        if (name.startsWith("META-INF/")) {
                            continue;
                        } else {
                            if (ANDROID_MANIFEST_FILENAME.equals(name)) {
                                packageR.manifestDigest = ManifestDigest.fromAttributes(manifest.getAttributes(name));
                            }
                            Certificate[] loadCertificates2 = loadCertificates(jarFile, jarEntry, bArr);
                            if (loadCertificates2 == null) {
                                jarFile.close();
                                this.mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                                return false;
                            } else if (certificateArr == null) {
                                certificateArr = loadCertificates2;
                            } else {
                                i2 = 0;
                                while (true) {
                                    int i4 = i2;
                                    if (i4 >= certificateArr.length) {
                                        continue;
                                        break;
                                    }
                                    obj = null;
                                    i3 = 0;
                                    while (i3 < loadCertificates2.length) {
                                        if (certificateArr[i4] != null && certificateArr[i4].equals(loadCertificates2[i3])) {
                                            obj = 1;
                                            break;
                                        }
                                        i3++;
                                    }
                                    if (obj == null || certificateArr.length != loadCertificates2.length) {
                                        jarFile.close();
                                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES;
                                    } else {
                                        i2 = i4 + 1;
                                    }
                                }
                                jarFile.close();
                                this.mParseError = PackageManager.INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES;
                                return false;
                            }
                        }
                    }
                }
            }
            jarFile.close();
            synchronized (mSync) {
                mReadBuffer = weakReference;
            }
            if (certificateArr != null) {
                if (certificateArr.length > 0) {
                    i3 = certificateArr.length;
                    packageR.mSignatures = new Signature[certificateArr.length];
                    for (i2 = 0; i2 < i3; i2++) {
                        packageR.mSignatures[i2] = new Signature(certificateArr[i2].getEncoded());
                    }
                    return true;
                }
            }
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
            return false;
        } catch (CertificateEncodingException e) {
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
            return false;
        } catch (IOException e2) {
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
            return false;
        } catch (RuntimeException e3) {
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION;
            return false;
        }
    }

    public int getParseError() {
        return this.mParseError;
    }

    public Package parsePackage(File file, String str, DisplayMetrics displayMetrics, int i) {
        this.mParseError = 1;
        this.mArchiveSourcePath = file.getPath();
        if (!file.isFile()) {
            this.mParseError = -100;
        } else if (PackageParser.isPackageFilename(file.getName()) || (i & 4) == 0) {
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST;
        } else {
            this.mParseError = -100;
        }
        return null;
    }

    public void setOnlyCoreApps(boolean z) {
        this.mOnlyCoreApps = z;
    }

    public void setSeparateProcesses(String[] strArr) {
        this.mSeparateProcesses = strArr;
    }
}
