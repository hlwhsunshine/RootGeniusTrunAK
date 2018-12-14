package android.content.p013pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.content.pm.IPackageManager */
public interface IPackageManager extends IInterface {

    /* renamed from: android.content.pm.IPackageManager$Stub */
    public static abstract class Stub extends Binder implements IPackageManager {
        private static final String DESCRIPTOR = "android.content.pm.IPackageManager";
        static final int TRANSACTION_addPackageToPreferred = 46;
        static final int TRANSACTION_addPermission = 17;
        static final int TRANSACTION_addPermissionAsync = 77;
        static final int TRANSACTION_addPreferredActivity = 49;
        static final int TRANSACTION_canonicalToCurrentPackageNames = 5;
        static final int TRANSACTION_checkPermission = 15;
        static final int TRANSACTION_checkSignatures = 22;
        static final int TRANSACTION_checkUidPermission = 16;
        static final int TRANSACTION_checkUidSignatures = 23;
        static final int TRANSACTION_clearApplicationUserData = 63;
        static final int TRANSACTION_clearPackagePreferredActivities = 51;
        static final int TRANSACTION_currentToCanonicalPackageNames = 4;
        static final int TRANSACTION_deleteApplicationCacheFiles = 62;
        static final int TRANSACTION_deletePackage = 44;
        static final int TRANSACTION_enterSafeMode = 68;
        static final int TRANSACTION_extendVerificationTimeout = 84;
        static final int TRANSACTION_finishPackageInstall = 42;
        static final int TRANSACTION_freeStorage = 61;
        static final int TRANSACTION_freeStorageAndNotify = 60;
        static final int TRANSACTION_getActivityInfo = 11;
        static final int TRANSACTION_getAllPermissionGroups = 9;
        static final int TRANSACTION_getApplicationEnabledSetting = 58;
        static final int TRANSACTION_getApplicationInfo = 10;
        static final int TRANSACTION_getComponentEnabledSetting = 56;
        static final int TRANSACTION_getInstallLocation = 79;
        static final int TRANSACTION_getInstalledApplications = 34;
        static final int TRANSACTION_getInstalledPackages = 33;
        static final int TRANSACTION_getInstallerPackageName = 45;
        static final int TRANSACTION_getInstrumentationInfo = 39;
        static final int TRANSACTION_getNameForUid = 25;
        static final int TRANSACTION_getPackageGids = 3;
        static final int TRANSACTION_getPackageInfo = 1;
        static final int TRANSACTION_getPackageSizeInfo = 64;
        static final int TRANSACTION_getPackageUid = 2;
        static final int TRANSACTION_getPackagesForUid = 24;
        static final int TRANSACTION_getPermissionGroupInfo = 8;
        static final int TRANSACTION_getPermissionInfo = 6;
        static final int TRANSACTION_getPersistentApplications = 35;
        static final int TRANSACTION_getPreferredActivities = 52;
        static final int TRANSACTION_getPreferredPackages = 48;
        static final int TRANSACTION_getPrivacyGuardSetting = 53;
        static final int TRANSACTION_getProviderInfo = 14;
        static final int TRANSACTION_getReceiverInfo = 12;
        static final int TRANSACTION_getServiceInfo = 13;
        static final int TRANSACTION_getSystemAvailableFeatures = 66;
        static final int TRANSACTION_getSystemSharedLibraryNames = 65;
        static final int TRANSACTION_getUidForSharedUser = 26;
        static final int TRANSACTION_getVerifierDeviceIdentity = 85;
        static final int TRANSACTION_grantPermission = 19;
        static final int TRANSACTION_hasSystemFeature = 67;
        static final int TRANSACTION_hasSystemUidErrors = 71;
        static final int TRANSACTION_installExistingPackage = 82;
        static final int TRANSACTION_installPackage = 41;
        static final int TRANSACTION_installPackageWithVerification = 80;
        static final int TRANSACTION_installPackageWithVerificationAndEncryption = 81;
        static final int TRANSACTION_isFirstBoot = 86;
        static final int TRANSACTION_isOnlyCoreApps = 87;
        static final int TRANSACTION_isPermissionEnforced = 89;
        static final int TRANSACTION_isProtectedBroadcast = 21;
        static final int TRANSACTION_isSafeMode = 69;
        static final int TRANSACTION_isStorageLow = 90;
        static final int TRANSACTION_movePackage = 76;
        static final int TRANSACTION_nextPackageToClean = 75;
        static final int TRANSACTION_performBootDexOpt = 72;
        static final int TRANSACTION_performDexOpt = 73;
        static final int TRANSACTION_queryContentProviders = 38;
        static final int TRANSACTION_queryInstrumentation = 40;
        static final int TRANSACTION_queryIntentActivities = 28;
        static final int TRANSACTION_queryIntentActivityOptions = 29;
        static final int TRANSACTION_queryIntentReceivers = 30;
        static final int TRANSACTION_queryIntentServices = 32;
        static final int TRANSACTION_queryPermissionsByGroup = 7;
        static final int TRANSACTION_querySyncProviders = 37;
        static final int TRANSACTION_removePackageFromPreferred = 47;
        static final int TRANSACTION_removePermission = 18;
        static final int TRANSACTION_replacePreferredActivity = 50;
        static final int TRANSACTION_resolveContentProvider = 36;
        static final int TRANSACTION_resolveIntent = 27;
        static final int TRANSACTION_resolveService = 31;
        static final int TRANSACTION_revokePermission = 20;
        static final int TRANSACTION_setApplicationEnabledSetting = 57;
        static final int TRANSACTION_setComponentEnabledSetting = 55;
        static final int TRANSACTION_setInstallLocation = 78;
        static final int TRANSACTION_setInstallerPackageName = 43;
        static final int TRANSACTION_setPackageStoppedState = 59;
        static final int TRANSACTION_setPermissionEnforced = 88;
        static final int TRANSACTION_setPrivacyGuardSetting = 54;
        static final int TRANSACTION_systemReady = 70;
        static final int TRANSACTION_updateExternalMediaStatus = 74;
        static final int TRANSACTION_verifyPendingInstall = 83;

        /* renamed from: android.content.pm.IPackageManager$Stub$Proxy */
        private static class Proxy implements IPackageManager {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void addPackageToPreferred(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean addPermission(PermissionInfo permissionInfo) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (permissionInfo != null) {
                        obtain.writeInt(1);
                        permissionInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean addPermissionAsync(PermissionInfo permissionInfo) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (permissionInfo != null) {
                        obtain.writeInt(1);
                        permissionInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_addPermissionAsync, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intentFilter != null) {
                        obtain.writeInt(1);
                        intentFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeTypedArray(componentNameArr, 0);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    this.mRemote.transact(Stub.TRANSACTION_addPreferredActivity, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String[] canonicalToCurrentPackageNames(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int checkPermission(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int checkSignatures(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int checkUidPermission(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int checkUidSignatures(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearApplicationUserData(String str, IPackageDataObserver iPackageDataObserver, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPackageDataObserver != null ? iPackageDataObserver.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearPackagePreferredActivities(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_clearPackagePreferredActivities, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String[] currentToCanonicalPackageNames(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deleteApplicationCacheFiles(String str, IPackageDataObserver iPackageDataObserver) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPackageDataObserver != null ? iPackageDataObserver.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_deleteApplicationCacheFiles, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deletePackage(String str, IPackageDeleteObserver iPackageDeleteObserver, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPackageDeleteObserver != null ? iPackageDeleteObserver.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enterSafeMode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_enterSafeMode, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void extendVerificationTimeout(int i, int i2, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.mRemote.transact(84, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void finishPackageInstall(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void freeStorage(long j, IntentSender intentSender) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    if (intentSender != null) {
                        obtain.writeInt(1);
                        intentSender.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_freeStorage, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void freeStorageAndNotify(long j, IPackageDataObserver iPackageDataObserver) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeStrongBinder(iPackageDataObserver != null ? iPackageDataObserver.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_freeStorageAndNotify, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ActivityInfo getActivityInfo(ComponentName componentName, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    ActivityInfo activityInfo = obtain2.readInt() != 0 ? (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return activityInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<PermissionGroupInfo> getAllPermissionGroups(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    List<PermissionGroupInfo> createTypedArrayList = obtain2.createTypedArrayList(PermissionGroupInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getApplicationEnabledSetting(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_getApplicationEnabledSetting, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ApplicationInfo getApplicationInfo(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    ApplicationInfo applicationInfo = obtain2.readInt() != 0 ? (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return applicationInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getComponentEnabledSetting(ComponentName componentName, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_getComponentEnabledSetting, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getInstallLocation() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getInstallLocation, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParceledListSlice getInstalledApplications(int i, String str, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    ParceledListSlice parceledListSlice = obtain2.readInt() != 0 ? (ParceledListSlice) ParceledListSlice.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parceledListSlice;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParceledListSlice getInstalledPackages(int i, String str, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    ParceledListSlice parceledListSlice = obtain2.readInt() != 0 ? (ParceledListSlice) ParceledListSlice.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parceledListSlice;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInstallerPackageName(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    InstrumentationInfo instrumentationInfo = obtain2.readInt() != 0 ? (InstrumentationInfo) InstrumentationInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return instrumentationInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public String getNameForUid(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int[] getPackageGids(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PackageInfo getPackageInfo(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    PackageInfo packageInfo = obtain2.readInt() != 0 ? (PackageInfo) PackageInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return packageInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getPackageSizeInfo(String str, int i, IPackageStatsObserver iPackageStatsObserver) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iPackageStatsObserver != null ? iPackageStatsObserver.asBinder() : null);
                    this.mRemote.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPackageUid(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String[] getPackagesForUid(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PermissionGroupInfo getPermissionGroupInfo(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    PermissionGroupInfo permissionGroupInfo = obtain2.readInt() != 0 ? (PermissionGroupInfo) PermissionGroupInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return permissionGroupInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PermissionInfo getPermissionInfo(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    PermissionInfo permissionInfo = obtain2.readInt() != 0 ? (PermissionInfo) PermissionInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return permissionInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<ApplicationInfo> getPersistentApplications(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    List<ApplicationInfo> createTypedArrayList = obtain2.createTypedArrayList(ApplicationInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_getPreferredActivities, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readTypedList(list, IntentFilter.CREATOR);
                    obtain2.readTypedList(list2, ComponentName.CREATOR);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<PackageInfo> getPreferredPackages(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_getPreferredPackages, obtain, obtain2, 0);
                    obtain2.readException();
                    List<PackageInfo> createTypedArrayList = obtain2.createTypedArrayList(PackageInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getPrivacyGuardSetting(String str, int i) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_getPrivacyGuardSetting, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ProviderInfo getProviderInfo(ComponentName componentName, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    ProviderInfo providerInfo = obtain2.readInt() != 0 ? (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return providerInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ActivityInfo getReceiverInfo(ComponentName componentName, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    ActivityInfo activityInfo = obtain2.readInt() != 0 ? (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return activityInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ServiceInfo getServiceInfo(ComponentName componentName, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    ServiceInfo serviceInfo = obtain2.readInt() != 0 ? (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return serviceInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public FeatureInfo[] getSystemAvailableFeatures() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSystemAvailableFeatures, obtain, obtain2, 0);
                    obtain2.readException();
                    FeatureInfo[] featureInfoArr = (FeatureInfo[]) obtain2.createTypedArray(FeatureInfo.CREATOR);
                    return featureInfoArr;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String[] getSystemSharedLibraryNames() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSystemSharedLibraryNames, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getUidForSharedUser(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public VerifierDeviceIdentity getVerifierDeviceIdentity() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVerifierDeviceIdentity, obtain, obtain2, 0);
                    obtain2.readException();
                    VerifierDeviceIdentity verifierDeviceIdentity = obtain2.readInt() != 0 ? (VerifierDeviceIdentity) VerifierDeviceIdentity.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return verifierDeviceIdentity;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void grantPermission(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasSystemFeature(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_hasSystemFeature, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasSystemUidErrors() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_hasSystemUidErrors, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int installExistingPackage(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_installExistingPackage, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void installPackage(Uri uri, IPackageInstallObserver iPackageInstallObserver, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPackageInstallObserver != null ? iPackageInstallObserver.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void installPackageWithVerification(Uri uri, IPackageInstallObserver iPackageInstallObserver, int i, String str, Uri uri2, ManifestDigest manifestDigest, ContainerEncryptionParams containerEncryptionParams) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPackageInstallObserver != null ? iPackageInstallObserver.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (manifestDigest != null) {
                        obtain.writeInt(1);
                        manifestDigest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (containerEncryptionParams != null) {
                        obtain.writeInt(1);
                        containerEncryptionParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(80, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void installPackageWithVerificationAndEncryption(Uri uri, IPackageInstallObserver iPackageInstallObserver, int i, String str, VerificationParams verificationParams, ContainerEncryptionParams containerEncryptionParams) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPackageInstallObserver != null ? iPackageInstallObserver.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (verificationParams != null) {
                        obtain.writeInt(1);
                        verificationParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (containerEncryptionParams != null) {
                        obtain.writeInt(1);
                        containerEncryptionParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_installPackageWithVerificationAndEncryption, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isFirstBoot() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isFirstBoot, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isOnlyCoreApps() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isOnlyCoreApps, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isPermissionEnforced(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_isPermissionEnforced, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isProtectedBroadcast(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isSafeMode() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isSafeMode, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isStorageLow() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isStorageLow, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void movePackage(String str, IPackageMoveObserver iPackageMoveObserver, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPackageMoveObserver != null ? iPackageMoveObserver.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_movePackage, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PackageCleanItem nextPackageToClean(PackageCleanItem packageCleanItem) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (packageCleanItem != null) {
                        obtain.writeInt(1);
                        packageCleanItem.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_nextPackageToClean, obtain, obtain2, 0);
                    obtain2.readException();
                    PackageCleanItem packageCleanItem2 = obtain2.readInt() != 0 ? (PackageCleanItem) PackageCleanItem.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return packageCleanItem2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void performBootDexOpt() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_performBootDexOpt, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean performDexOpt(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_performDexOpt, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<ProviderInfo> queryContentProviders(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    List<ProviderInfo> createTypedArrayList = obtain2.createTypedArrayList(ProviderInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<InstrumentationInfo> queryInstrumentation(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                    List<InstrumentationInfo> createTypedArrayList = obtain2.createTypedArrayList(InstrumentationInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<ResolveInfo> queryIntentActivities(Intent intent, String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(Stub.TRANSACTION_queryIntentActivities, obtain, obtain2, 0);
                    obtain2.readException();
                    List<ResolveInfo> createTypedArrayList = obtain2.createTypedArrayList(ResolveInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, String[] strArr, Intent intent, String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedArray(intentArr, 0);
                    obtain.writeStringArray(strArr);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(Stub.TRANSACTION_queryIntentActivityOptions, obtain, obtain2, 0);
                    obtain2.readException();
                    List<ResolveInfo> createTypedArrayList = obtain2.createTypedArrayList(ResolveInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<ResolveInfo> queryIntentReceivers(Intent intent, String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    List<ResolveInfo> createTypedArrayList = obtain2.createTypedArrayList(ResolveInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<ResolveInfo> queryIntentServices(Intent intent, String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    List<ResolveInfo> createTypedArrayList = obtain2.createTypedArrayList(ResolveInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<PermissionInfo> queryPermissionsByGroup(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    List<PermissionInfo> createTypedArrayList = obtain2.createTypedArrayList(PermissionInfo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void querySyncProviders(List<String> list, List<ProviderInfo> list2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    obtain.writeTypedList(list2);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.readStringList(list);
                    obtain2.readTypedList(list2, ProviderInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removePackageFromPreferred(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removePermission(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void replacePreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intentFilter != null) {
                        obtain.writeInt(1);
                        intentFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeTypedArray(componentNameArr, 0);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_replacePreferredActivity, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ProviderInfo resolveContentProvider(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    ProviderInfo providerInfo = obtain2.readInt() != 0 ? (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return providerInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ResolveInfo resolveIntent(Intent intent, String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    ResolveInfo resolveInfo = obtain2.readInt() != 0 ? (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return resolveInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ResolveInfo resolveService(Intent intent, String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    ResolveInfo resolveInfo = obtain2.readInt() != 0 ? (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return resolveInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void revokePermission(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setApplicationEnabledSetting(String str, int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.mRemote.transact(Stub.TRANSACTION_setApplicationEnabledSetting, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setComponentEnabledSetting(ComponentName componentName, int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.mRemote.transact(Stub.TRANSACTION_setComponentEnabledSetting, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setInstallLocation(int i) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setInstallLocation, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setInstallerPackageName(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPackageStoppedState(String str, boolean z, int i) {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setPackageStoppedState, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPermissionEnforced(String str, boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setPermissionEnforced, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPrivacyGuardSetting(String str, boolean z, int i) {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setPrivacyGuardSetting, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void systemReady() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_systemReady, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateExternalMediaStatus(boolean z, boolean z2) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_updateExternalMediaStatus, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void verifyPendingInstall(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(Stub.TRANSACTION_verifyPendingInstall, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPackageManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPackageManager)) ? new Proxy(iBinder) : (IPackageManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ContainerEncryptionParams containerEncryptionParams = null;
            int i3 = 0;
            int packageUid;
            String[] currentToCanonicalPackageNames;
            List queryPermissionsByGroup;
            ActivityInfo activityInfo;
            ProviderInfo providerInfo;
            boolean addPermission;
            String nameForUid;
            ResolveInfo resolveIntent;
            ParceledListSlice installedPackages;
            List createTypedArrayList;
            boolean z;
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    PackageInfo packageInfo = getPackageInfo(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (packageInfo != null) {
                        parcel2.writeInt(1);
                        packageInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = getPackageUid(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int[] packageGids = getPackageGids(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeIntArray(packageGids);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    currentToCanonicalPackageNames = currentToCanonicalPackageNames(parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(currentToCanonicalPackageNames);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    currentToCanonicalPackageNames = canonicalToCurrentPackageNames(parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(currentToCanonicalPackageNames);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    PermissionInfo permissionInfo = getPermissionInfo(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (permissionInfo != null) {
                        parcel2.writeInt(1);
                        permissionInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = queryPermissionsByGroup(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    PermissionGroupInfo permissionGroupInfo = getPermissionGroupInfo(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (permissionGroupInfo != null) {
                        parcel2.writeInt(1);
                        permissionGroupInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = getAllPermissionGroups(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    ApplicationInfo applicationInfo = getApplicationInfo(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (applicationInfo != null) {
                        parcel2.writeInt(1);
                        applicationInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    activityInfo = getActivityInfo(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (activityInfo != null) {
                        parcel2.writeInt(1);
                        activityInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    activityInfo = getReceiverInfo(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (activityInfo != null) {
                        parcel2.writeInt(1);
                        activityInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    ServiceInfo serviceInfo = getServiceInfo(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (serviceInfo != null) {
                        parcel2.writeInt(1);
                        serviceInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    providerInfo = getProviderInfo(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (providerInfo != null) {
                        parcel2.writeInt(1);
                        providerInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = checkPermission(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = checkUidPermission(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = addPermission(parcel.readInt() != 0 ? (PermissionInfo) PermissionInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(addPermission ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    removePermission(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    grantPermission(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    revokePermission(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = isProtectedBroadcast(parcel.readString());
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = checkSignatures(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = checkUidSignatures(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    currentToCanonicalPackageNames = getPackagesForUid(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(currentToCanonicalPackageNames);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    nameForUid = getNameForUid(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(nameForUid);
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = getUidForSharedUser(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    resolveIntent = resolveIntent(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (resolveIntent != null) {
                        parcel2.writeInt(1);
                        resolveIntent.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case TRANSACTION_queryIntentActivities /*28*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = queryIntentActivities(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case TRANSACTION_queryIntentActivityOptions /*29*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = queryIntentActivityOptions(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, (Intent[]) parcel.createTypedArray(Intent.CREATOR), parcel.createStringArray(), parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = queryIntentReceivers(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    resolveIntent = resolveService(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (resolveIntent != null) {
                        parcel2.writeInt(1);
                        resolveIntent.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = queryIntentServices(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    installedPackages = getInstalledPackages(parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (installedPackages != null) {
                        parcel2.writeInt(1);
                        installedPackages.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    installedPackages = getInstalledApplications(parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (installedPackages != null) {
                        parcel2.writeInt(1);
                        installedPackages.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = getPersistentApplications(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    providerInfo = resolveContentProvider(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (providerInfo != null) {
                        parcel2.writeInt(1);
                        providerInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = parcel.createStringArrayList();
                    createTypedArrayList = parcel.createTypedArrayList(ProviderInfo.CREATOR);
                    querySyncProviders(queryPermissionsByGroup, createTypedArrayList);
                    parcel2.writeNoException();
                    parcel2.writeStringList(queryPermissionsByGroup);
                    parcel2.writeTypedList(createTypedArrayList);
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = queryContentProviders(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    InstrumentationInfo instrumentationInfo = getInstrumentationInfo(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    if (instrumentationInfo != null) {
                        parcel2.writeInt(1);
                        instrumentationInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = queryInstrumentation(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    installPackage(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, android.content.p013pm.IPackageInstallObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    finishPackageInstall(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    setInstallerPackageName(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    deletePackage(parcel.readString(), android.content.p013pm.IPackageDeleteObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    nameForUid = getInstallerPackageName(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(nameForUid);
                    return true;
                case 46:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPackageToPreferred(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface(DESCRIPTOR);
                    removePackageFromPreferred(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getPreferredPackages /*48*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = getPreferredPackages(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    return true;
                case TRANSACTION_addPreferredActivity /*49*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPreferredActivity(parcel.readInt() != 0 ? (IntentFilter) IntentFilter.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), (ComponentName[]) parcel.createTypedArray(ComponentName.CREATOR), parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_replacePreferredActivity /*50*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    replacePreferredActivity(parcel.readInt() != 0 ? (IntentFilter) IntentFilter.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), (ComponentName[]) parcel.createTypedArray(ComponentName.CREATOR), parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_clearPackagePreferredActivities /*51*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearPackagePreferredActivities(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getPreferredActivities /*52*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    queryPermissionsByGroup = new ArrayList();
                    createTypedArrayList = new ArrayList();
                    int preferredActivities = getPreferredActivities(queryPermissionsByGroup, createTypedArrayList, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(preferredActivities);
                    parcel2.writeTypedList(queryPermissionsByGroup);
                    parcel2.writeTypedList(createTypedArrayList);
                    return true;
                case TRANSACTION_getPrivacyGuardSetting /*53*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = getPrivacyGuardSetting(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_setPrivacyGuardSetting /*54*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    nameForUid = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setPrivacyGuardSetting(nameForUid, z, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_setComponentEnabledSetting /*55*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    setComponentEnabledSetting(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getComponentEnabledSetting /*56*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = getComponentEnabledSetting(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case TRANSACTION_setApplicationEnabledSetting /*57*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    setApplicationEnabledSetting(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getApplicationEnabledSetting /*58*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = getApplicationEnabledSetting(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case TRANSACTION_setPackageStoppedState /*59*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    nameForUid = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setPackageStoppedState(nameForUid, z, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_freeStorageAndNotify /*60*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    freeStorageAndNotify(parcel.readLong(), android.content.p013pm.IPackageDataObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_freeStorage /*61*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    freeStorage(parcel.readLong(), parcel.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_deleteApplicationCacheFiles /*62*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    deleteApplicationCacheFiles(parcel.readString(), android.content.p013pm.IPackageDataObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 63:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearApplicationUserData(parcel.readString(), android.content.p013pm.IPackageDataObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 64:
                    parcel.enforceInterface(DESCRIPTOR);
                    getPackageSizeInfo(parcel.readString(), parcel.readInt(), android.content.p013pm.IPackageStatsObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getSystemSharedLibraryNames /*65*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    currentToCanonicalPackageNames = getSystemSharedLibraryNames();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(currentToCanonicalPackageNames);
                    return true;
                case TRANSACTION_getSystemAvailableFeatures /*66*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    Parcelable[] systemAvailableFeatures = getSystemAvailableFeatures();
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(systemAvailableFeatures, 1);
                    return true;
                case TRANSACTION_hasSystemFeature /*67*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = hasSystemFeature(parcel.readString());
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_enterSafeMode /*68*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    enterSafeMode();
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_isSafeMode /*69*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = isSafeMode();
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_systemReady /*70*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    systemReady();
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_hasSystemUidErrors /*71*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = hasSystemUidErrors();
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_performBootDexOpt /*72*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    performBootDexOpt();
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_performDexOpt /*73*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = performDexOpt(parcel.readString());
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_updateExternalMediaStatus /*74*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    updateExternalMediaStatus(addPermission, z);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_nextPackageToClean /*75*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    PackageCleanItem nextPackageToClean = nextPackageToClean(parcel.readInt() != 0 ? (PackageCleanItem) PackageCleanItem.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (nextPackageToClean != null) {
                        parcel2.writeInt(1);
                        nextPackageToClean.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case TRANSACTION_movePackage /*76*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    movePackage(parcel.readString(), android.content.p013pm.IPackageMoveObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_addPermissionAsync /*77*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = addPermissionAsync(parcel.readInt() != 0 ? (PermissionInfo) PermissionInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_setInstallLocation /*78*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = setInstallLocation(parcel.readInt());
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_getInstallLocation /*79*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = getInstallLocation();
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case 80:
                    parcel.enforceInterface(DESCRIPTOR);
                    Uri uri = parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null;
                    IPackageInstallObserver asInterface = android.content.p013pm.IPackageInstallObserver.Stub.asInterface(parcel.readStrongBinder());
                    int readInt = parcel.readInt();
                    String readString = parcel.readString();
                    Uri uri2 = parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null;
                    ManifestDigest manifestDigest = parcel.readInt() != 0 ? (ManifestDigest) ManifestDigest.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        containerEncryptionParams = (ContainerEncryptionParams) ContainerEncryptionParams.CREATOR.createFromParcel(parcel);
                    }
                    installPackageWithVerification(uri, asInterface, readInt, readString, uri2, manifestDigest, containerEncryptionParams);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_installPackageWithVerificationAndEncryption /*81*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    installPackageWithVerificationAndEncryption(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, android.content.p013pm.IPackageInstallObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (VerificationParams) VerificationParams.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ContainerEncryptionParams) ContainerEncryptionParams.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_installExistingPackage /*82*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    packageUid = installExistingPackage(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(packageUid);
                    return true;
                case TRANSACTION_verifyPendingInstall /*83*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    verifyPendingInstall(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 84:
                    parcel.enforceInterface(DESCRIPTOR);
                    extendVerificationTimeout(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getVerifierDeviceIdentity /*85*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    VerifierDeviceIdentity verifierDeviceIdentity = getVerifierDeviceIdentity();
                    parcel2.writeNoException();
                    if (verifierDeviceIdentity != null) {
                        parcel2.writeInt(1);
                        verifierDeviceIdentity.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case TRANSACTION_isFirstBoot /*86*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = isFirstBoot();
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_isOnlyCoreApps /*87*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = isOnlyCoreApps();
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_setPermissionEnforced /*88*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    nameForUid = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setPermissionEnforced(nameForUid, z);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_isPermissionEnforced /*89*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = isPermissionEnforced(parcel.readString());
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case TRANSACTION_isStorageLow /*90*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPermission = isStorageLow();
                    parcel2.writeNoException();
                    if (addPermission) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void addPackageToPreferred(String str);

    boolean addPermission(PermissionInfo permissionInfo);

    boolean addPermissionAsync(PermissionInfo permissionInfo);

    void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName, int i2);

    String[] canonicalToCurrentPackageNames(String[] strArr);

    int checkPermission(String str, String str2);

    int checkSignatures(String str, String str2);

    int checkUidPermission(String str, int i);

    int checkUidSignatures(int i, int i2);

    void clearApplicationUserData(String str, IPackageDataObserver iPackageDataObserver, int i);

    void clearPackagePreferredActivities(String str);

    String[] currentToCanonicalPackageNames(String[] strArr);

    void deleteApplicationCacheFiles(String str, IPackageDataObserver iPackageDataObserver);

    void deletePackage(String str, IPackageDeleteObserver iPackageDeleteObserver, int i);

    void enterSafeMode();

    void extendVerificationTimeout(int i, int i2, long j);

    void finishPackageInstall(int i);

    void freeStorage(long j, IntentSender intentSender);

    void freeStorageAndNotify(long j, IPackageDataObserver iPackageDataObserver);

    ActivityInfo getActivityInfo(ComponentName componentName, int i, int i2);

    List<PermissionGroupInfo> getAllPermissionGroups(int i);

    int getApplicationEnabledSetting(String str, int i);

    ApplicationInfo getApplicationInfo(String str, int i, int i2);

    int getComponentEnabledSetting(ComponentName componentName, int i);

    int getInstallLocation();

    ParceledListSlice getInstalledApplications(int i, String str, int i2);

    ParceledListSlice getInstalledPackages(int i, String str, int i2);

    String getInstallerPackageName(String str);

    InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i);

    String getNameForUid(int i);

    int[] getPackageGids(String str);

    PackageInfo getPackageInfo(String str, int i, int i2);

    void getPackageSizeInfo(String str, int i, IPackageStatsObserver iPackageStatsObserver);

    int getPackageUid(String str, int i);

    String[] getPackagesForUid(int i);

    PermissionGroupInfo getPermissionGroupInfo(String str, int i);

    PermissionInfo getPermissionInfo(String str, int i);

    List<ApplicationInfo> getPersistentApplications(int i);

    int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str);

    List<PackageInfo> getPreferredPackages(int i);

    boolean getPrivacyGuardSetting(String str, int i);

    ProviderInfo getProviderInfo(ComponentName componentName, int i, int i2);

    ActivityInfo getReceiverInfo(ComponentName componentName, int i, int i2);

    ServiceInfo getServiceInfo(ComponentName componentName, int i, int i2);

    FeatureInfo[] getSystemAvailableFeatures();

    String[] getSystemSharedLibraryNames();

    int getUidForSharedUser(String str);

    VerifierDeviceIdentity getVerifierDeviceIdentity();

    void grantPermission(String str, String str2);

    boolean hasSystemFeature(String str);

    boolean hasSystemUidErrors();

    int installExistingPackage(String str);

    void installPackage(Uri uri, IPackageInstallObserver iPackageInstallObserver, int i, String str);

    void installPackageWithVerification(Uri uri, IPackageInstallObserver iPackageInstallObserver, int i, String str, Uri uri2, ManifestDigest manifestDigest, ContainerEncryptionParams containerEncryptionParams);

    void installPackageWithVerificationAndEncryption(Uri uri, IPackageInstallObserver iPackageInstallObserver, int i, String str, VerificationParams verificationParams, ContainerEncryptionParams containerEncryptionParams);

    boolean isFirstBoot();

    boolean isOnlyCoreApps();

    boolean isPermissionEnforced(String str);

    boolean isProtectedBroadcast(String str);

    boolean isSafeMode();

    boolean isStorageLow();

    void movePackage(String str, IPackageMoveObserver iPackageMoveObserver, int i);

    PackageCleanItem nextPackageToClean(PackageCleanItem packageCleanItem);

    void performBootDexOpt();

    boolean performDexOpt(String str);

    List<ProviderInfo> queryContentProviders(String str, int i, int i2);

    List<InstrumentationInfo> queryInstrumentation(String str, int i);

    List<ResolveInfo> queryIntentActivities(Intent intent, String str, int i, int i2);

    List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, String[] strArr, Intent intent, String str, int i, int i2);

    List<ResolveInfo> queryIntentReceivers(Intent intent, String str, int i, int i2);

    List<ResolveInfo> queryIntentServices(Intent intent, String str, int i, int i2);

    List<PermissionInfo> queryPermissionsByGroup(String str, int i);

    void querySyncProviders(List<String> list, List<ProviderInfo> list2);

    void removePackageFromPreferred(String str);

    void removePermission(String str);

    void replacePreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName);

    ProviderInfo resolveContentProvider(String str, int i, int i2);

    ResolveInfo resolveIntent(Intent intent, String str, int i, int i2);

    ResolveInfo resolveService(Intent intent, String str, int i, int i2);

    void revokePermission(String str, String str2);

    void setApplicationEnabledSetting(String str, int i, int i2, int i3);

    void setComponentEnabledSetting(ComponentName componentName, int i, int i2, int i3);

    boolean setInstallLocation(int i);

    void setInstallerPackageName(String str, String str2);

    void setPackageStoppedState(String str, boolean z, int i);

    void setPermissionEnforced(String str, boolean z);

    void setPrivacyGuardSetting(String str, boolean z, int i);

    void systemReady();

    void updateExternalMediaStatus(boolean z, boolean z2);

    void verifyPendingInstall(int i, int i2);
}
