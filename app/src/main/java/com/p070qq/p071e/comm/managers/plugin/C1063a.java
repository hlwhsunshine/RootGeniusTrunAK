package com.p070qq.p071e.comm.managers.plugin;

import android.content.Context;
import com.p070qq.p071e.comm.constants.Constants.PLUGIN;
import com.p070qq.p071e.comm.net.NetworkCallBack;
import com.p070qq.p071e.comm.net.NetworkClient.Priority;
import com.p070qq.p071e.comm.net.NetworkClientImpl;
import com.p070qq.p071e.comm.net.p072rr.PlainRequest;
import com.p070qq.p071e.comm.net.p072rr.Request;
import com.p070qq.p071e.comm.net.p072rr.Request.Method;
import com.p070qq.p071e.comm.net.p072rr.Response;
import com.p070qq.p071e.comm.util.C1080a;
import com.p070qq.p071e.comm.util.FileUtil;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.Md5Util;
import com.p070qq.p071e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.qq.e.comm.managers.plugin.a */
final class C1063a {
    /* renamed from: a */
    private static final Pattern f2783a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    /* renamed from: b */
    private final Context f2784b;

    /* renamed from: com.qq.e.comm.managers.plugin.a$a */
    class C1062a implements NetworkCallBack {
        /* renamed from: a */
        private final String f2780a;
        /* renamed from: b */
        private final int f2781b;

        public C1062a(String str, int i) {
            this.f2780a = str;
            this.f2781b = i;
        }

        /* renamed from: a */
        private static String m3082a(Response response, File file) {
            InputStream streamContent;
            OutputStream fileOutputStream;
            Throwable e;
            Object obj;
            Throwable th;
            String str = null;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                streamContent = response.getStreamContent();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    obj = str;
                    try {
                        GDTLogger.m3132e("IOException While Update Plugin", e);
                        FileUtil.tryClose(streamContent);
                        FileUtil.tryClose(fileOutputStream);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        FileUtil.tryClose(streamContent);
                        FileUtil.tryClose(fileOutputStream);
                        throw th;
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    obj = str;
                    GDTLogger.m3132e("MD5SUMException While Update Plugin", e);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return str;
                } catch (Throwable e4) {
                    obj = str;
                    th = e4;
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = streamContent.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                        fileOutputStream.write(bArr, 0, read);
                    }
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    str = Md5Util.byteArrayToHexString(instance.digest());
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                } catch (IOException e5) {
                    e4 = e5;
                    GDTLogger.m3132e("IOException While Update Plugin", e4);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return str;
                } catch (NoSuchAlgorithmException e6) {
                    e4 = e6;
                    GDTLogger.m3132e("MD5SUMException While Update Plugin", e4);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return str;
                }
            } catch (IOException e7) {
                e4 = e7;
                obj = str;
                Object obj2 = str;
            } catch (NoSuchAlgorithmException e8) {
                e4 = e8;
                fileOutputStream = str;
                streamContent = str;
                GDTLogger.m3132e("MD5SUMException While Update Plugin", e4);
                FileUtil.tryClose(streamContent);
                FileUtil.tryClose(fileOutputStream);
                return str;
            } catch (Throwable e42) {
                fileOutputStream = str;
                streamContent = str;
                th = e42;
                FileUtil.tryClose(streamContent);
                FileUtil.tryClose(fileOutputStream);
                throw th;
            }
            return str;
        }

        /* renamed from: a */
        private boolean m3083a(File file) {
            try {
                StringUtil.writeTo(this.f2781b + "#####" + this.f2780a, file);
                return true;
            } catch (Throwable e) {
                GDTLogger.m3132e("IOException While Update Plugin", e);
                return false;
            }
        }

        public final void onException(Exception exception) {
            GDTLogger.m3135w("Exception While Update Plugin", exception);
        }

        public final void onResponse(Request request, Response response) {
            if (response.getStatusCode() == 200) {
                try {
                    File file = new File(C1063a.this.f2784b.getDir("e_qq_com_plugin", 0), "gdt_plugin.tmp");
                    File file2 = new File(C1063a.this.f2784b.getDir("e_qq_com_plugin", 0), "gdt_plugin.tmp.sig");
                    if (!C1080a.m3136a().mo6629b(this.f2780a, C1062a.m3082a(response, file))) {
                        file.delete();
                        GDTLogger.report(String.format("Fail to update plugin while verifying,sig=%s,md5=%s", new Object[]{this.f2780a, r0}));
                    } else if (m3083a(file2) && FileUtil.renameTo(file, C1065c.m3087b(C1063a.this.f2784b))) {
                        FileUtil.renameTo(file2, C1065c.m3089d(C1063a.this.f2784b));
                    }
                    GDTLogger.m3130d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.f2780a);
                    return;
                } catch (Throwable th) {
                    GDTLogger.m3130d("TIMESTAMP_AFTER_DOWNPLUGIN:" + System.nanoTime() + ";sig=" + this.f2780a);
                    throw th;
                }
            }
            GDTLogger.report("DownLoad Plugin Jar Status error,response status code=" + response.getStatusCode());
        }
    }

    public C1063a(Context context) {
        this.f2784b = context.getApplicationContext();
    }

    /* renamed from: a */
    public final void mo6467a(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            int i;
            String str3 = "0";
            Matcher matcher = f2783a.matcher(str2);
            if (matcher.matches()) {
                str3 = matcher.group(1);
            }
            int parseInteger = StringUtil.parseInteger(str3, 0);
            if (parseInteger < PLUGIN.ASSET_PLUGIN_VERSION) {
                GDTLogger.m3133i("online plugin version is smaller than asset plugin version" + parseInteger + ",535.download give up");
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Method.GET, null), Priority.High, new C1062a(str, parseInteger));
            }
        }
    }
}
