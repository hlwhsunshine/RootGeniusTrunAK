package com.kingroot.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p013pm.ActivityInfo;
import android.content.p013pm.FeatureInfo;
import android.content.p013pm.InstrumentationInfo;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.p013pm.PermissionGroupInfo;
import android.content.p013pm.PermissionInfo;
import android.content.p013pm.ProviderInfo;
import android.content.p013pm.ResolveInfo;
import android.content.p013pm.ServiceInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import java.util.List;

/* renamed from: com.kingroot.sdk.gg */
public class C0843gg extends PackageManager {
    /* renamed from: jD */
    private static volatile C0843gg f2098jD = null;

    private C0843gg() {
    }

    /* renamed from: cf */
    public static C0843gg m2186cf() {
        if (f2098jD == null) {
            synchronized (C0843gg.class) {
                if (f2098jD == null) {
                    f2098jD = new C0843gg();
                }
            }
        }
        return f2098jD;
    }

    private PackageManager getPackageManager() {
        return C0823fo.m2083bR().getPackageManager();
    }

    public void addPackageToPreferred(String str) {
        try {
            getPackageManager().addPackageToPreferred(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
        }
    }

    public boolean addPermission(PermissionInfo permissionInfo) {
        try {
            return getPackageManager().addPermission(permissionInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (!(th instanceof SecurityException)) {
                return false;
            }
            SecurityException securityException = (SecurityException) th;
        }
    }

    public boolean addPermissionAsync(PermissionInfo permissionInfo) {
        try {
            return getPackageManager().addPermissionAsync(permissionInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (!(th instanceof SecurityException)) {
                return false;
            }
            SecurityException securityException = (SecurityException) th;
        }
    }

    public void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
        try {
            getPackageManager().addPreferredActivity(intentFilter, i, componentNameArr, componentName);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
        }
    }

    public String[] canonicalToCurrentPackageNames(String[] strArr) {
        String[] strArr2 = null;
        try {
            return getPackageManager().canonicalToCurrentPackageNames(strArr);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return strArr2;
        }
    }

    public int checkPermission(String str, String str2) {
        try {
            return getPackageManager().checkPermission(str, str2);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return -9999;
        }
    }

    public int checkSignatures(int i, int i2) {
        try {
            return getPackageManager().checkSignatures(i, i2);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return -9999;
        }
    }

    public int checkSignatures(String str, String str2) {
        try {
            return getPackageManager().checkSignatures(str, str2);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return -9999;
        }
    }

    public void clearPackagePreferredActivities(String str) {
        try {
            getPackageManager().clearPackagePreferredActivities(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
        }
    }

    public String[] currentToCanonicalPackageNames(String[] strArr) {
        String[] strArr2 = null;
        try {
            return getPackageManager().currentToCanonicalPackageNames(strArr);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return strArr2;
        }
    }

    public Drawable getActivityIcon(ComponentName componentName) {
        Drawable activityIcon;
        try {
            activityIcon = getPackageManager().getActivityIcon(componentName);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                activityIcon = null;
            }
        }
        if (activityIcon != null) {
            return activityIcon;
        }
        throw new NameNotFoundException();
    }

    public Drawable getActivityIcon(Intent intent) {
        Drawable activityIcon;
        try {
            activityIcon = getPackageManager().getActivityIcon(intent);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                activityIcon = null;
            }
        }
        if (activityIcon != null) {
            return activityIcon;
        }
        throw new NameNotFoundException();
    }

    public ActivityInfo getActivityInfo(ComponentName componentName, int i) {
        ActivityInfo activityInfo;
        try {
            activityInfo = getPackageManager().getActivityInfo(componentName, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                activityInfo = null;
            }
        }
        if (activityInfo != null) {
            return activityInfo;
        }
        throw new NameNotFoundException();
    }

    public Drawable getActivityLogo(ComponentName componentName) {
        Drawable activityLogo;
        try {
            activityLogo = getPackageManager().getActivityLogo(componentName);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                activityLogo = null;
            }
        }
        if (activityLogo != null) {
            return activityLogo;
        }
        throw new NameNotFoundException();
    }

    public Drawable getActivityLogo(Intent intent) {
        Drawable activityLogo;
        try {
            activityLogo = getPackageManager().getActivityLogo(intent);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                activityLogo = null;
            }
        }
        if (activityLogo != null) {
            return activityLogo;
        }
        throw new NameNotFoundException();
    }

    public List<PermissionGroupInfo> getAllPermissionGroups(int i) {
        List<PermissionGroupInfo> list = null;
        try {
            return getPackageManager().getAllPermissionGroups(i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return list;
        }
    }

    public int getApplicationEnabledSetting(String str) {
        try {
            return getPackageManager().getApplicationEnabledSetting(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (!(th instanceof IllegalArgumentException)) {
                return -9999;
            }
            IllegalArgumentException illegalArgumentException = (IllegalArgumentException) th;
        }
    }

    public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
        try {
            return getPackageManager().getApplicationIcon(applicationInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public Drawable getApplicationIcon(String str) {
        Drawable applicationIcon;
        try {
            applicationIcon = getPackageManager().getApplicationIcon(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                applicationIcon = null;
            }
        }
        if (applicationIcon != null) {
            return applicationIcon;
        }
        throw new NameNotFoundException();
    }

    public ApplicationInfo getApplicationInfo(String str, int i) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = getPackageManager().getApplicationInfo(str, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                applicationInfo = null;
            }
        }
        if (applicationInfo != null) {
            return applicationInfo;
        }
        throw new NameNotFoundException();
    }

    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        try {
            return getPackageManager().getApplicationLabel(applicationInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public Drawable getApplicationLogo(ApplicationInfo applicationInfo) {
        Drawable drawable = null;
        try {
            return getPackageManager().getApplicationLogo(applicationInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return drawable;
        }
    }

    public Drawable getApplicationLogo(String str) {
        Drawable applicationLogo;
        try {
            applicationLogo = getPackageManager().getApplicationLogo(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                applicationLogo = null;
            }
        }
        if (applicationLogo != null) {
            return applicationLogo;
        }
        throw new NameNotFoundException();
    }

    public int getComponentEnabledSetting(ComponentName componentName) {
        try {
            return getPackageManager().getComponentEnabledSetting(componentName);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return -9999;
        }
    }

    public Drawable getDefaultActivityIcon() {
        try {
            return getPackageManager().getDefaultActivityIcon();
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public Drawable getDrawable(String str, int i, ApplicationInfo applicationInfo) {
        try {
            return getPackageManager().getDrawable(str, i, applicationInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public List<ApplicationInfo> getInstalledApplications(int i) {
        List<ApplicationInfo> list = null;
        try {
            return getPackageManager().getInstalledApplications(i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return list;
        }
    }

    public List<PackageInfo> getInstalledPackages(int i) {
        List<PackageInfo> list = null;
        try {
            return getPackageManager().getInstalledPackages(i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return list;
        }
    }

    public String getInstallerPackageName(String str) {
        try {
            return getPackageManager().getInstallerPackageName(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) {
        try {
            return getPackageManager().getInstrumentationInfo(componentName, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public Intent getLaunchIntentForPackage(String str) {
        Intent intent = null;
        try {
            return getPackageManager().getLaunchIntentForPackage(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return intent;
        }
    }

    public String getNameForUid(int i) {
        String str = null;
        try {
            return getPackageManager().getNameForUid(i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return str;
        }
    }

    public int[] getPackageGids(String str) {
        int[] packageGids;
        try {
            packageGids = getPackageManager().getPackageGids(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                packageGids = null;
            }
        }
        if (packageGids != null) {
            return packageGids;
        }
        throw new NameNotFoundException();
    }

    public PackageInfo getPackageInfo(String str, int i) {
        PackageInfo packageInfo;
        try {
            packageInfo = getPackageManager().getPackageInfo(str, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                packageInfo = null;
            }
        }
        if (packageInfo != null) {
            return packageInfo;
        }
        throw new NameNotFoundException();
    }

    public String[] getPackagesForUid(int i) {
        try {
            return getPackageManager().getPackagesForUid(i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public PermissionGroupInfo getPermissionGroupInfo(String str, int i) {
        PermissionGroupInfo permissionGroupInfo;
        try {
            permissionGroupInfo = getPackageManager().getPermissionGroupInfo(str, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                permissionGroupInfo = null;
            }
        }
        if (permissionGroupInfo != null) {
            return permissionGroupInfo;
        }
        throw new NameNotFoundException();
    }

    public PermissionInfo getPermissionInfo(String str, int i) {
        PermissionInfo permissionInfo;
        try {
            permissionInfo = getPackageManager().getPermissionInfo(str, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                permissionInfo = null;
            }
        }
        if (permissionInfo != null) {
            return permissionInfo;
        }
        throw new NameNotFoundException();
    }

    public int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str) {
        try {
            return getPackageManager().getPreferredActivities(list, list2, str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return 0;
        }
    }

    public List<PackageInfo> getPreferredPackages(int i) {
        try {
            return getPackageManager().getPreferredPackages(i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public ProviderInfo getProviderInfo(ComponentName componentName, int i) {
        ProviderInfo providerInfo;
        try {
            providerInfo = getPackageManager().getProviderInfo(componentName, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                providerInfo = null;
            }
        }
        if (providerInfo != null) {
            return providerInfo;
        }
        throw new NameNotFoundException();
    }

    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) {
        ActivityInfo receiverInfo;
        try {
            receiverInfo = getPackageManager().getReceiverInfo(componentName, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                receiverInfo = null;
            }
        }
        if (receiverInfo != null) {
            return receiverInfo;
        }
        throw new NameNotFoundException();
    }

    public Resources getResourcesForActivity(ComponentName componentName) {
        Resources resourcesForActivity;
        try {
            resourcesForActivity = getPackageManager().getResourcesForActivity(componentName);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                resourcesForActivity = null;
            }
        }
        if (resourcesForActivity != null) {
            return resourcesForActivity;
        }
        throw new NameNotFoundException();
    }

    public Resources getResourcesForApplication(ApplicationInfo applicationInfo) {
        Resources resourcesForApplication;
        try {
            resourcesForApplication = getPackageManager().getResourcesForApplication(applicationInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                resourcesForApplication = null;
            }
        }
        if (resourcesForApplication != null) {
            return resourcesForApplication;
        }
        throw new NameNotFoundException();
    }

    public Resources getResourcesForApplication(String str) {
        Resources resourcesForApplication;
        try {
            resourcesForApplication = getPackageManager().getResourcesForApplication(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                resourcesForApplication = null;
            }
        }
        if (resourcesForApplication != null) {
            return resourcesForApplication;
        }
        throw new NameNotFoundException();
    }

    public ServiceInfo getServiceInfo(ComponentName componentName, int i) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = getPackageManager().getServiceInfo(componentName, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                serviceInfo = null;
            }
        }
        if (serviceInfo != null) {
            return serviceInfo;
        }
        throw new NameNotFoundException();
    }

    public FeatureInfo[] getSystemAvailableFeatures() {
        FeatureInfo[] featureInfoArr = null;
        try {
            return getPackageManager().getSystemAvailableFeatures();
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return featureInfoArr;
        }
    }

    public String[] getSystemSharedLibraryNames() {
        String[] strArr = null;
        try {
            return getPackageManager().getSystemSharedLibraryNames();
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return strArr;
        }
    }

    public CharSequence getText(String str, int i, ApplicationInfo applicationInfo) {
        try {
            return getPackageManager().getText(str, i, applicationInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public XmlResourceParser getXml(String str, int i, ApplicationInfo applicationInfo) {
        try {
            return getPackageManager().getXml(str, i, applicationInfo);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public boolean hasSystemFeature(String str) {
        try {
            return getPackageManager().hasSystemFeature(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return false;
        }
    }

    public boolean isSafeMode() {
        try {
            return getPackageManager().isSafeMode();
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return false;
        }
    }

    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        List<ResolveInfo> list = null;
        try {
            return getPackageManager().queryBroadcastReceivers(intent, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return list;
        }
    }

    public List<ProviderInfo> queryContentProviders(String str, int i, int i2) {
        try {
            return getPackageManager().queryContentProviders(str, i, i2);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public List<InstrumentationInfo> queryInstrumentation(String str, int i) {
        try {
            return getPackageManager().queryInstrumentation(str, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        List<ResolveInfo> list = null;
        try {
            return getPackageManager().queryIntentActivities(intent, i);
        } catch (Throwable th) {
            C0825fq.m2101r("KPackageManager", "（╯‵□′）╯︵┴─┴ PM may died ...");
            C0825fq.m2097b("KPackageManager", th);
            return list;
        }
    }

    public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
        List<ResolveInfo> list = null;
        try {
            return getPackageManager().queryIntentActivityOptions(componentName, intentArr, intent, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return list;
        }
    }

    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        List<ResolveInfo> list = null;
        try {
            return getPackageManager().queryIntentServices(intent, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return list;
        }
    }

    public List<PermissionInfo> queryPermissionsByGroup(String str, int i) {
        List<PermissionInfo> queryPermissionsByGroup;
        try {
            queryPermissionsByGroup = getPackageManager().queryPermissionsByGroup(str, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof NameNotFoundException) {
                NameNotFoundException nameNotFoundException = (NameNotFoundException) th;
            } else {
                queryPermissionsByGroup = null;
            }
        }
        if (queryPermissionsByGroup != null) {
            return queryPermissionsByGroup;
        }
        throw new NameNotFoundException();
    }

    public void removePackageFromPreferred(String str) {
        try {
            getPackageManager().removePackageFromPreferred(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
        }
    }

    public void removePermission(String str) {
        try {
            getPackageManager().removePermission(str);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            if (th instanceof SecurityException) {
                SecurityException securityException = (SecurityException) th;
            }
        }
    }

    public ResolveInfo resolveActivity(Intent intent, int i) {
        ResolveInfo resolveInfo = null;
        try {
            return getPackageManager().resolveActivity(intent, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return resolveInfo;
        }
    }

    public ProviderInfo resolveContentProvider(String str, int i) {
        try {
            return getPackageManager().resolveContentProvider(str, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return null;
        }
    }

    public ResolveInfo resolveService(Intent intent, int i) {
        ResolveInfo resolveInfo = null;
        try {
            return getPackageManager().resolveService(intent, i);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
            return resolveInfo;
        }
    }

    public void setApplicationEnabledSetting(String str, int i, int i2) {
        try {
            getPackageManager().setApplicationEnabledSetting(str, i, i2);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
        }
    }

    public void setComponentEnabledSetting(ComponentName componentName, int i, int i2) {
        try {
            getPackageManager().setComponentEnabledSetting(componentName, i, i2);
        } catch (Throwable th) {
            C0825fq.m2097b("KPackageManager", th);
        }
    }
}
