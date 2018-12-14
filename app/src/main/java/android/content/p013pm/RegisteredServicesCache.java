package android.content.p013pm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import android.support.p015v4.content.IntentCompat;
import android.util.AtomicFile;
import android.util.AttributeSet;
import android.util.SparseArray;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.content.pm.RegisteredServicesCache */
public abstract class RegisteredServicesCache<V> {
    private static final boolean DEBUG = false;
    private static final String TAG = "PackageManager";
    private final String mAttributesName;
    public final Context mContext;
    private final BroadcastReceiver mExternalReceiver = new C00492();
    private Handler mHandler;
    private final String mInterfaceName;
    private RegisteredServicesCacheListener<V> mListener;
    private final String mMetaDataName;
    private final BroadcastReceiver mPackageReceiver = new C00481();
    private final AtomicFile mPersistentServicesFile;
    private boolean mPersistentServicesFileDidNotExist;
    private final XmlSerializerAndParser<V> mSerializerAndParser;
    private final Object mServicesLock = new Object();
    private final SparseArray<UserServices<V>> mUserServices = new SparseArray();

    /* renamed from: android.content.pm.RegisteredServicesCache$1 */
    class C00481 extends BroadcastReceiver {
        C00481() {
        }

        public void onReceive(Context context, Intent intent) {
            intent.getIntExtra("android.intent.extra.UID", -1);
        }
    }

    /* renamed from: android.content.pm.RegisteredServicesCache$2 */
    class C00492 extends BroadcastReceiver {
        C00492() {
        }

        public void onReceive(Context context, Intent intent) {
        }
    }

    /* renamed from: android.content.pm.RegisteredServicesCache$ServiceInfo */
    public static class ServiceInfo<V> {
        public final ComponentName componentName;
        public final V type;
        public final int uid;

        public ServiceInfo(V v, ComponentName componentName, int i) {
            this.type = v;
            this.componentName = componentName;
            this.uid = i;
        }

        public String toString() {
            return "ServiceInfo: " + this.type + ", " + this.componentName + ", uid " + this.uid;
        }
    }

    /* renamed from: android.content.pm.RegisteredServicesCache$UserServices */
    private static class UserServices<V> {
        public Map<V, ServiceInfo<V>> services;

        private UserServices() {
            this.services = null;
        }

        /* synthetic */ UserServices(UserServices userServices) {
            this();
        }
    }

    public RegisteredServicesCache(Context context, String str, String str2, String str3, XmlSerializerAndParser<V> xmlSerializerAndParser) {
        this.mContext = context;
        this.mInterfaceName = str;
        this.mMetaDataName = str2;
        this.mAttributesName = str3;
        this.mSerializerAndParser = xmlSerializerAndParser;
        this.mPersistentServicesFile = new AtomicFile(new File(new File(new File(Environment.getDataDirectory(), "system"), "registered_services"), new StringBuilder(String.valueOf(str)).append(".xml").toString()));
        readPersistentServicesLocked();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        intentFilter = new IntentFilter();
        intentFilter.addAction(IntentCompat.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
        intentFilter.addAction(IntentCompat.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
        this.mContext.registerReceiver(this.mExternalReceiver, intentFilter);
    }

    private boolean containsType(ArrayList<ServiceInfo<V>> arrayList, V v) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((ServiceInfo) arrayList.get(i)).type.equals(v)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsTypeAndUid(ArrayList<ServiceInfo<V>> arrayList, V v, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ServiceInfo serviceInfo = (ServiceInfo) arrayList.get(i2);
            if (serviceInfo.type.equals(v) && serviceInfo.uid == i) {
                return true;
            }
        }
        return false;
    }

    private UserServices<V> findOrCreateUserLocked(int i) {
        UserServices<V> userServices = (UserServices) this.mUserServices.get(i);
        if (userServices != null) {
            return userServices;
        }
        userServices = new UserServices();
        this.mUserServices.put(i, userServices);
        return userServices;
    }

    private void generateServicesMap(int i) {
        PackageManager packageManager = this.mContext.getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServicesAsUser(new Intent(this.mInterfaceName), 128, i)) {
            try {
                ServiceInfo parseServiceInfo = parseServiceInfo(resolveInfo);
                if (parseServiceInfo == null) {
                    new StringBuilder("Unable to load service info ").append(resolveInfo.toString());
                } else {
                    arrayList.add(parseServiceInfo);
                }
            } catch (XmlPullParserException e) {
                new StringBuilder("Unable to load service info ").append(resolveInfo.toString());
            } catch (IOException e2) {
                new StringBuilder("Unable to load service info ").append(resolveInfo.toString());
            }
        }
        synchronized (this.mServicesLock) {
            UserServices findOrCreateUserLocked = findOrCreateUserLocked(i);
            if ((findOrCreateUserLocked.services == null ? 1 : null) == null) {
                findOrCreateUserLocked.services.clear();
            }
            StringBuilder stringBuilder = new StringBuilder();
        }
    }

    private boolean inSystemImage(int i) {
        String[] packagesForUid = this.mContext.getPackageManager().getPackagesForUid(i);
        int length = packagesForUid.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                if ((this.mContext.getPackageManager().getPackageInfo(packagesForUid[i2], 0).applicationInfo.flags & 1) != 0) {
                    return true;
                }
                i2++;
            } catch (NameNotFoundException e) {
                return false;
            }
        }
        return false;
    }

    private void notifyListener(V v, int i, boolean z) {
        final RegisteredServicesCacheListener registeredServicesCacheListener;
        Handler handler;
        synchronized (this) {
            registeredServicesCacheListener = this.mListener;
            handler = this.mHandler;
        }
        if (registeredServicesCacheListener != null) {
            final V v2 = v;
            final int i2 = i;
            final boolean z2 = z;
            handler.post(new Runnable() {
                public void run() {
                    registeredServicesCacheListener.onServiceChanged(v2, i2, z2);
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    private android.content.p013pm.RegisteredServicesCache.ServiceInfo<V> parseServiceInfo(android.content.p013pm.ResolveInfo r10) {
        /*
        r9 = this;
        r0 = 0;
        r2 = r10.serviceInfo;
        r3 = new android.content.ComponentName;
        r1 = r2.packageName;
        r4 = r2.name;
        r3.<init>(r1, r4);
        r1 = r9.mContext;
        r4 = r1.getPackageManager();
        r1 = r9.mMetaDataName;	 Catch:{ NameNotFoundException -> 0x00bd, all -> 0x00b8 }
        r1 = r2.loadXmlMetaData(r4, r1);	 Catch:{ NameNotFoundException -> 0x00bd, all -> 0x00b8 }
        if (r1 != 0) goto L_0x005a;
    L_0x001a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r3 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r4 = "No ";
        r3.<init>(r4);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r4 = r9.mMetaDataName;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r3 = r3.append(r4);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r4 = " meta-data";
        r3 = r3.append(r4);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r3 = r3.toString();	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r0.<init>(r3);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        throw r0;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
    L_0x0037:
        r0 = move-exception;
        r0 = r1;
    L_0x0039:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ all -> 0x0050 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0050 }
        r4 = "Unable to load resources for pacakge ";
        r3.<init>(r4);	 Catch:{ all -> 0x0050 }
        r2 = r2.packageName;	 Catch:{ all -> 0x0050 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0050 }
        r2 = r2.toString();	 Catch:{ all -> 0x0050 }
        r1.<init>(r2);	 Catch:{ all -> 0x0050 }
        throw r1;	 Catch:{ all -> 0x0050 }
    L_0x0050:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0054:
        if (r1 == 0) goto L_0x0059;
    L_0x0056:
        r1.close();
    L_0x0059:
        throw r0;
    L_0x005a:
        r5 = android.util.Xml.asAttributeSet(r1);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
    L_0x005e:
        r6 = r1.next();	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r7 = 1;
        if (r6 == r7) goto L_0x0068;
    L_0x0065:
        r7 = 2;
        if (r6 != r7) goto L_0x005e;
    L_0x0068:
        r6 = r1.getName();	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r7 = r9.mAttributesName;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r6 = r7.equals(r6);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        if (r6 != 0) goto L_0x0093;
    L_0x0074:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r3 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r4 = "Meta-data does not start with ";
        r3.<init>(r4);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r4 = r9.mAttributesName;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r3 = r3.append(r4);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r4 = " tag";
        r3 = r3.append(r4);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r3 = r3.toString();	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r0.<init>(r3);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        throw r0;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
    L_0x0091:
        r0 = move-exception;
        goto L_0x0054;
    L_0x0093:
        r6 = r2.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r4 = r4.getResourcesForApplication(r6);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r6 = r2.packageName;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r4 = r9.parseServiceAttributes(r4, r6, r5);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        if (r4 != 0) goto L_0x00a7;
    L_0x00a1:
        if (r1 == 0) goto L_0x00a6;
    L_0x00a3:
        r1.close();
    L_0x00a6:
        return r0;
    L_0x00a7:
        r0 = r10.serviceInfo;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r0 = r0.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r5 = r0.uid;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r0 = new android.content.pm.RegisteredServicesCache$ServiceInfo;	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        r0.<init>(r4, r3, r5);	 Catch:{ NameNotFoundException -> 0x0037, all -> 0x0091 }
        if (r1 == 0) goto L_0x00a6;
    L_0x00b4:
        r1.close();
        goto L_0x00a6;
    L_0x00b8:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0054;
    L_0x00bd:
        r1 = move-exception;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.RegisteredServicesCache.parseServiceInfo(android.content.pm.ResolveInfo):android.content.pm.RegisteredServicesCache$ServiceInfo<V>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f A:{ExcHandler: java.lang.Exception (e java.lang.Exception), Splitter: B:2:0x000d} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:34:0x0080, code:
            if (r0 != null) goto L_0x0082;
     */
    /* JADX WARNING: Missing block: B:36:?, code:
            r0.close();
     */
    /* JADX WARNING: Missing block: B:45:0x0094, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:46:0x0095, code:
            r6 = r1;
            r1 = r0;
            r0 = r6;
     */
    /* JADX WARNING: Missing block: B:55:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:58:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:59:?, code:
            return;
     */
    private void readPersistentServicesLocked() {
        /*
        r7 = this;
        r2 = 1;
        r0 = 0;
        r5 = 2;
        r1 = r7.mUserServices;
        r1.clear();
        r1 = r7.mSerializerAndParser;
        if (r1 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r1 = r7.mPersistentServicesFile;	 Catch:{ Exception -> 0x007f, all -> 0x0088 }
        r1 = r1.getBaseFile();	 Catch:{ Exception -> 0x007f, all -> 0x0088 }
        r1 = r1.exists();	 Catch:{ Exception -> 0x007f, all -> 0x0088 }
        if (r1 == 0) goto L_0x0078;
    L_0x0019:
        r1 = 0;
    L_0x001a:
        r7.mPersistentServicesFileDidNotExist = r1;	 Catch:{ Exception -> 0x007f, all -> 0x0088 }
        r1 = r7.mPersistentServicesFileDidNotExist;	 Catch:{ Exception -> 0x007f, all -> 0x0088 }
        if (r1 != 0) goto L_0x000c;
    L_0x0020:
        r1 = r7.mPersistentServicesFile;	 Catch:{ Exception -> 0x007f, all -> 0x0088 }
        r0 = r1.openRead();	 Catch:{ Exception -> 0x007f, all -> 0x0088 }
        r3 = android.util.Xml.newPullParser();	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        r1 = 0;
        r3.setInput(r0, r1);	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        r1 = r3.getEventType();	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
    L_0x0032:
        if (r1 != r5) goto L_0x007a;
    L_0x0034:
        r1 = r3.getName();	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        r4 = "services";
        r1 = r4.equals(r1);	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        if (r1 == 0) goto L_0x0070;
    L_0x0040:
        r1 = r3.next();	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
    L_0x0044:
        if (r1 != r5) goto L_0x006a;
    L_0x0046:
        r1 = r3.getDepth();	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        if (r1 != r5) goto L_0x006a;
    L_0x004c:
        r1 = r3.getName();	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        r4 = "service";
        r1 = r4.equals(r1);	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        if (r1 == 0) goto L_0x006a;
    L_0x0058:
        r1 = r7.mSerializerAndParser;	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        r1 = r1.createFromXml(r3);	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        if (r1 == 0) goto L_0x0070;
    L_0x0060:
        r1 = 0;
        r4 = "uid";
        r1 = r3.getAttributeValue(r1, r4);	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
    L_0x006a:
        r1 = r3.next();	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        if (r1 != r2) goto L_0x0044;
    L_0x0070:
        if (r0 == 0) goto L_0x000c;
    L_0x0072:
        r0.close();	 Catch:{ IOException -> 0x0076 }
        goto L_0x000c;
    L_0x0076:
        r0 = move-exception;
        goto L_0x000c;
    L_0x0078:
        r1 = r2;
        goto L_0x001a;
    L_0x007a:
        r1 = r3.next();	 Catch:{ Exception -> 0x007f, all -> 0x0094 }
        goto L_0x0032;
    L_0x007f:
        r1 = move-exception;
        if (r0 == 0) goto L_0x000c;
    L_0x0082:
        r0.close();	 Catch:{ IOException -> 0x0086 }
        goto L_0x000c;
    L_0x0086:
        r0 = move-exception;
        goto L_0x000c;
    L_0x0088:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x008c:
        if (r1 == 0) goto L_0x0091;
    L_0x008e:
        r1.close();	 Catch:{ IOException -> 0x0092 }
    L_0x0091:
        throw r0;
    L_0x0092:
        r1 = move-exception;
        goto L_0x0091;
    L_0x0094:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x008c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.RegisteredServicesCache.readPersistentServicesLocked():void");
    }

    private void writePersistentServicesLocked() {
        if (this.mSerializerAndParser != null) {
            try {
                this.mPersistentServicesFile.startWrite();
            } catch (IOException e) {
            }
        }
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr, int i) {
        synchronized (this.mServicesLock) {
            UserServices findOrCreateUserLocked = findOrCreateUserLocked(i);
            if (findOrCreateUserLocked.services != null) {
                printWriter.println("RegisteredServicesCache: " + findOrCreateUserLocked.services.size() + " services");
                for (ServiceInfo serviceInfo : findOrCreateUserLocked.services.values()) {
                    printWriter.println("  " + serviceInfo);
                }
            } else {
                printWriter.println("RegisteredServicesCache: services not loaded");
            }
        }
    }

    public Collection<ServiceInfo<V>> getAllServices(int i) {
        Collection<ServiceInfo<V>> unmodifiableCollection;
        synchronized (this.mServicesLock) {
            UserServices findOrCreateUserLocked = findOrCreateUserLocked(i);
            if (findOrCreateUserLocked.services == null) {
                generateServicesMap(i);
            }
            unmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(findOrCreateUserLocked.services.values()));
        }
        return unmodifiableCollection;
    }

    public RegisteredServicesCacheListener<V> getListener() {
        RegisteredServicesCacheListener<V> registeredServicesCacheListener;
        synchronized (this) {
            registeredServicesCacheListener = this.mListener;
        }
        return registeredServicesCacheListener;
    }

    public ServiceInfo<V> getServiceInfo(V v, int i) {
        ServiceInfo<V> serviceInfo;
        synchronized (this.mServicesLock) {
            UserServices findOrCreateUserLocked = findOrCreateUserLocked(i);
            if (findOrCreateUserLocked.services == null) {
                generateServicesMap(i);
            }
            serviceInfo = (ServiceInfo) findOrCreateUserLocked.services.get(v);
        }
        return serviceInfo;
    }

    public void invalidateCache(int i) {
        synchronized (this.mServicesLock) {
            findOrCreateUserLocked(i).services = null;
        }
    }

    public abstract V parseServiceAttributes(Resources resources, String str, AttributeSet attributeSet);

    public void setListener(RegisteredServicesCacheListener<V> registeredServicesCacheListener, Handler handler) {
        if (handler == null) {
            handler = new Handler(this.mContext.getMainLooper());
        }
        synchronized (this) {
            this.mHandler = handler;
            this.mListener = registeredServicesCacheListener;
        }
    }
}
