package com.shuame;

import com.shuame.rootgenius.sdk.JniHelper;
import com.shuame.rootgenius.sdk.RgsdkConfig;
import com.shuame.rootgenius.sdk.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public abstract class ProtoBase {
    private static final String TAG;

    static {
        ProtoBase.TAG = ProtoBase.class.getSimpleName();
    }

    public ProtoBase() {
        super();
    }

    public static byte[] DecodeBytes(byte[] arg5) {
        int v0 = 0;
        int v2 = arg5.length;
        h.a(ProtoBase.TAG, "DecodeBytes len:" + v2);
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            arg5[v1] = ((byte)(arg5[v1] ^ 107));
        }

        while(v0 < v2 / 2) {
            byte v1_1 = arg5[v0];
            arg5[v0] = arg5[v2 - v0 - 1];
            arg5[v2 - v0 - 1] = v1_1;
            ++v0;
        }

        return arg5;
    }

    public abstract void OnResponse(int arg1, String arg2);

    public void asyncPosReq(String arg3) {
        new Thread(new a(this, arg3)).start();
    }

    public abstract String getServant();

    protected String getServant(boolean arg3, String arg4) {
        String v0 = arg3 ? "http://" + RgsdkConfig.sServerStat + "/v2/stat/m" + arg4 : "http://" + RgsdkConfig.sServer + "/v2/m" + arg4;
        return v0;
    }

    public static boolean isSuccess(int arg1) {
        boolean v0 = arg1 == 200 || arg1 == 206 ? true : false;
        return v0;
    }

    public static byte[] postReq(String arg10, String arg11) {
        URLConnection v1_2;
        byte[] v2_6;
        URLConnection v0_5;
        URLConnection v2;
        URLConnection v3_1;
        int v2_1;
        URL v4;
        byte[] v1 = null;
        int v3 = -1;
        try {
            h.c(ProtoBase.TAG, "posting url:" + arg10);
            v4 = new URL(arg10);
        }
        catch(Throwable v0) {
            v4 = ((URL)v1);
            goto label_126;
        }
        catch(IOException v0_1) {
            v2 = ((URLConnection)v1);
            v4 = ((URL)v1);
            goto label_106;
        }
        catch(UnknownHostException v0_2) {
            v2_1 = v3;
            v4 = ((URL)v1);
            v3_1 = ((URLConnection)v1);
            goto label_146;
        }
        catch(ConnectException v0_3) {
            v2 = ((URLConnection)v1);
            v4 = ((URL)v1);
            goto label_51;
        }
        catch(SocketTimeoutException v0_4) {
            v2 = ((URLConnection)v1);
            v4 = ((URL)v1);
            goto label_51;
        }

        try {
            v0_5 = v4.openConnection();
        }
        catch(Throwable v0) {
            goto label_126;
        }
        catch(IOException v0_1) {
            v2 = ((URLConnection)v1);
            goto label_106;
        }
        catch(UnknownHostException v0_2) {
            v2_1 = v3;
            v3_1 = ((URLConnection)v1);
            goto label_146;
        }
        catch(ConnectException v0_3) {
            v2 = ((URLConnection)v1);
            goto label_51;
        }
        catch(SocketTimeoutException v0_4) {
            v2 = ((URLConnection)v1);
            goto label_51;
        }

        try {
            ((HttpURLConnection)v0_5).setDoOutput(true);
            ((HttpURLConnection)v0_5).setRequestMethod("POST");
            ((HttpURLConnection)v0_5).setRequestProperty("Connection", "Close");
            ((HttpURLConnection)v0_5).setRequestProperty("Content-Type", "text/plain");
            ((HttpURLConnection)v0_5).setConnectTimeout(10000);
            if(arg11 != null && arg11.length() > 0) {
                v2_6 = JniHelper.encrypt(ProtoBase.DecodeBytes(arg11.getBytes()));
                OutputStream v5 = ((HttpURLConnection)v0_5).getOutputStream();
                v5.write(v2_6);
                v5.close();
            }

            v3 = ((HttpURLConnection)v0_5).getResponseCode();
            if(ProtoBase.isSuccess(v3)) {
                ByteArrayOutputStream v2_7 = new ByteArrayOutputStream(8192);
                byte[] v5_1 = new byte[2048];
                InputStream v6 = ((HttpURLConnection)v0_5).getInputStream();
                while(true) {
                    int v7 = v6.read(v5_1);
                    if(v7 <= 0) {
                        break;
                    }

                    v2_7.write(v5_1, 0, v7);
                }

                v6.close();
                v2_6 = v2_7.toByteArray();
                if(v2_6 != null && v2_6.length > 0) {
                    v1 = ProtoBase.DecodeBytes(JniHelper.decrypt(v2_6));
                }
            }

            goto label_86;
        }
        catch(Throwable v1_1) {
            Throwable v9_5 = v1_1;
            v1_2 = v0_5;
            v0 = v9_5;
        }
        catch(IOException v2_2) {
            IOException v9_4 = v2_2;
            v2 = v0_5;
            v0_1 = v9_4;
            try {
            label_106:
                v0_1.printStackTrace();
                if(v2 == null) {
                    goto label_109;
                }
            }
            catch(Throwable v0) {
            label_158:
                v1_2 = v2;
                goto label_126;
            }

            ((HttpURLConnection)v2).disconnect();
        label_109:
            h.c(ProtoBase.TAG, "[PostReq]url:" + v4.getHost() + v4.getFile() + ",response:" + v3);
            return v1;
        }
        catch(UnknownHostException v2_3) {
            UnknownHostException v9_2 = v2_3;
            v2_1 = v3;
            v3_1 = v0_5;
            v0_2 = v9_2;
        label_146:
            int v9_3 = v2_1;
            v2 = v3_1;
            v3 = v9_3;
            try {
            label_51:
                h.e(ProtoBase.TAG, "post url " + arg10 + " fail by time out" + ((IOException)v0_2).getMessage());
                if(v2 != null) {
                    goto label_63;
                }

                goto label_64;
            }
            catch(Throwable v0) {
                goto label_158;
            }

        label_63:
            ((HttpURLConnection)v2).disconnect();
        label_64:
            h.c(ProtoBase.TAG, "[PostReq]url:" + v4.getHost() + v4.getFile() + ",response:" + v3);
            byte[] v0_6 = v1;
            return v0_6;
        }
        catch(ConnectException v2_4) {
            ConnectException v9_1 = v2_4;
            v2 = v0_5;
            v0_3 = v9_1;
            goto label_51;
        }
        catch(SocketTimeoutException v2_5) {
            SocketTimeoutException v9 = v2_5;
            v2 = v0_5;
            v0_4 = v9;
            goto label_51;
        }

    label_126:
        if(v1_2 != null) {
            ((HttpURLConnection)v1_2).disconnect();
        }

        h.c(ProtoBase.TAG, "[PostReq]url:" + v4.getHost() + v4.getFile() + ",response:" + v3);
        throw v0;
    label_86:
        if(v0_5 != null) {
            ((HttpURLConnection)v0_5).disconnect();
        }

        h.c(ProtoBase.TAG, "[PostReq]url:" + v4.getHost() + v4.getFile() + ",response:" + v3);
        return v1;
    }

    public int postReq(String arg13) {
        String v11_6;
        URLConnection v11_3;
        URLConnection v0_8;
        int v5_1;
        URL v4_1;
        URLConnection v2_1;
        int v4_2;
        URLConnection v1_1;
        String v0_7;
        IOException v5_2;
        IllegalStateException v5_3;
        Exception v5_4;
        URL v2;
        String v1;
        URLConnection v4 = null;
        int v6 = -1;
        String v3 = "";
        int v7 = 0;
        URL v5 = ((URL)v4);
        try {
            while(true) {
            label_7:
                v1 = this.getServant();
                h.c(ProtoBase.TAG, "posting url:" + v1);
                v2 = new URL(v1);
                break;
            }
        }
        catch(Throwable v0) {
            v1_1 = v4;
            v2 = v5;
            goto label_197;
        }
        catch(Exception v0_1) {
            v2 = v5;
            v5_4 = v0_1;
            v0_7 = v1;
            v1_1 = v4;
            v4_2 = v6;
            goto label_177;
        }
        catch(IllegalStateException v0_2) {
            v2 = v5;
            v5_3 = v0_2;
            v0_7 = v1;
            v1_1 = v4;
            v4_2 = v6;
            goto label_154;
        }
        catch(IOException v0_3) {
            v2 = v5;
            v5_2 = v0_3;
            v0_7 = v1;
            v1_1 = v4;
            v4_2 = v6;
            goto label_131;
        }
        catch(UnknownHostException v0_4) {
            v2_1 = v4;
            v4_1 = v5;
            v5_1 = v6;
            goto label_224;
        }
        catch(ConnectException v0_5) {
            v2 = v5;
            goto label_215;
        }
        catch(SocketTimeoutException v0_6) {
            v2 = v5;
            goto label_59;
        }

        try {
            v0_8 = v2.openConnection();
            v4 = null;
        }
        catch(Throwable v0) {
            v1_1 = v4;
            goto label_197;
        }
        catch(Exception v0_1) {
            v5_4 = v0_1;
            v0_7 = v1;
            v1_1 = v4;
            v4_2 = v6;
            goto label_177;
        }
        catch(IllegalStateException v0_2) {
            v5_3 = v0_2;
            v0_7 = v1;
            v1_1 = v4;
            v4_2 = v6;
            goto label_154;
        }
        catch(IOException v0_3) {
            v5_2 = v0_3;
            v0_7 = v1;
            v1_1 = v4;
            v4_2 = v6;
            goto label_131;
        }
        catch(UnknownHostException v0_4) {
            v5_1 = v6;
            URL v11 = v2;
            v2_1 = v4;
            v4_1 = v11;
            goto label_224;
        }
        catch(ConnectException v0_5) {
            goto label_215;
        }
        catch(SocketTimeoutException v0_6) {
            goto label_59;
        }

        try {
            ((HttpURLConnection)v0_8).setDoOutput(true);
            ((HttpURLConnection)v0_8).setRequestMethod("POST");
            ((HttpURLConnection)v0_8).setRequestProperty("Connection", "Close");
            ((HttpURLConnection)v0_8).setRequestProperty("Content-Type", "text/plain");
            ((HttpURLConnection)v0_8).setConnectTimeout(20000);
            ((HttpURLConnection)v0_8).setReadTimeout(20000);
            if(arg13 != null && arg13.length() > 0) {
                byte[] v4_9 = JniHelper.encrypt(ProtoBase.DecodeBytes(arg13.getBytes()));
                OutputStream v5_5 = ((HttpURLConnection)v0_8).getOutputStream();
                v5_5.write(v4_9);
                v5_5.close();
            }

            v4_2 = ((HttpURLConnection)v0_8).getResponseCode();
        }
        catch(Throwable v1_2) {
            Throwable v11_4 = v1_2;
            v1_1 = v0_8;
            v0 = v11_4;
            goto label_197;
        }
        catch(Exception v4_3) {
            v5_4 = v4_3;
            v4_2 = v6;
            v11_3 = v0_8;
            v0_7 = v1;
            v1_1 = v11_3;
            goto label_177;
        }
        catch(IllegalStateException v4_4) {
            v5_3 = v4_4;
            v4_2 = v6;
            v11_3 = v0_8;
            v0_7 = v1;
            v1_1 = v11_3;
            goto label_154;
        }
        catch(IOException v4_5) {
            v5_2 = v4_5;
            v4_2 = v6;
            v11_3 = v0_8;
            v0_7 = v1;
            v1_1 = v11_3;
            goto label_131;
        }
        catch(UnknownHostException v4_6) {
            v5_1 = v6;
            v11_3 = v0_8;
            v0_4 = v4_6;
            v4_1 = v2;
            v2_1 = v11_3;
            goto label_224;
        }
        catch(ConnectException v4_7) {
            ConnectException v11_2 = v4_7;
            v4 = v0_8;
            v0_5 = v11_2;
            goto label_215;
        }
        catch(SocketTimeoutException v4_8) {
            SocketTimeoutException v11_1 = v4_8;
            v4 = v0_8;
            v0_6 = v11_1;
            goto label_59;
        }

        try {
            if(ProtoBase.isSuccess(v4_2)) {
                ByteArrayOutputStream v5_9 = new ByteArrayOutputStream(8192);
                byte[] v6_1 = new byte[2048];
                InputStream v8 = ((HttpURLConnection)v0_8).getInputStream();
                while(true) {
                    int v9 = v8.read(v6_1);
                    if(v9 <= 0) {
                        break;
                    }

                    v5_9.write(v6_1, 0, v9);
                }

                v8.close();
                v6_1 = v5_9.toByteArray();
                if(v6_1 != null && v6_1.length > 0) {
                    v3 = new String(ProtoBase.DecodeBytes(JniHelper.decrypt(v6_1)));
                }
            }

            goto label_106;
        }
        catch(Throwable v1_2) {
            v6 = v4_2;
            v11_3 = v0_8;
            v0 = v1_2;
            v1_1 = v11_3;
        }
        catch(Exception v5_4) {
            v11_6 = v1;
            v1_1 = v0_8;
            v0_7 = v11_6;
            try {
            label_177:
                v5_4.printStackTrace();
                if(v1_1 == null) {
                    goto label_180;
                }
            }
            catch(Throwable v0) {
            label_246:
                v6 = v4_2;
                goto label_197;
            }

            ((HttpURLConnection)v1_1).disconnect();
        label_180:
            h.c(ProtoBase.TAG, "[PostReq]url:" + v2.getHost() + v2.getFile() + ",response:" + v4_2);
            goto label_89;
        }
        catch(IllegalStateException v5_3) {
            v11_6 = v1;
            v1_1 = v0_8;
            v0_7 = v11_6;
            try {
            label_154:
                v5_3.printStackTrace();
                if(v1_1 != null) {
                    goto label_156;
                }

                goto label_157;
            }
            catch(Throwable v0) {
                goto label_246;
            }

        label_156:
            ((HttpURLConnection)v1_1).disconnect();
        label_157:
            h.c(ProtoBase.TAG, "[PostReq]url:" + v2.getHost() + v2.getFile() + ",response:" + v4_2);
            goto label_89;
        }
        catch(IOException v5_2) {
            v11_6 = v1;
            v1_1 = v0_8;
            v0_7 = v11_6;
            try {
            label_131:
                v5_2.printStackTrace();
                if(v1_1 != null) {
                    goto label_133;
                }

                goto label_134;
            }
            catch(Throwable v0) {
                goto label_246;
            }

        label_133:
            ((HttpURLConnection)v1_1).disconnect();
        label_134:
            h.c(ProtoBase.TAG, "[PostReq]url:" + v2.getHost() + v2.getFile() + ",response:" + v4_2);
            goto label_89;
        }
        catch(UnknownHostException v5_6) {
            UnknownHostException v11_5 = v5_6;
            v5_1 = v4_2;
            v4_1 = v2;
            v2_1 = v0_8;
            v0_4 = v11_5;
        label_224:
            v11_5 = v0_4;
            v0_7 = v1;
            v1_1 = v2_1;
            v2 = v4_1;
            v4_2 = v5_1;
            v5_6 = v11_5;
            try {
            label_63:
                h.e(ProtoBase.TAG, "post url " + v0_7 + " fail by time out" + ((IOException)v5_7).getMessage());
                if(v1_1 != null) {
                    goto label_75;
                }

                goto label_76;
            }
            catch(Throwable v0) {
                goto label_246;
            }

        label_75:
            ((HttpURLConnection)v1_1).disconnect();
        label_76:
            h.c(ProtoBase.TAG, "[PostReq]url:" + v2.getHost() + v2.getFile() + ",response:" + v4_2);
            goto label_89;
        }
        catch(ConnectException v5_7) {
            v6 = v4_2;
            v4 = v0_8;
            v0_5 = v5_7;
        label_215:
            v5_7 = v0_5;
            v0_7 = v1;
            v1_1 = v4;
            v4_2 = v6;
            goto label_63;
        }
        catch(SocketTimeoutException v5_8) {
            v6 = v4_2;
            v4 = v0_8;
            v0_6 = v5_8;
        label_59:
            v5_8 = v0_6;
            v0_7 = v1;
            v1_1 = v4;
            v4_2 = v6;
            goto label_63;
        }

    label_197:
        if(v1_1 != null) {
            ((HttpURLConnection)v1_1).disconnect();
        }

        h.c(ProtoBase.TAG, "[PostReq]url:" + v2.getHost() + v2.getFile() + ",response:" + v6);
        throw v0;
    label_106:
        if(v0_8 != null) {
            ((HttpURLConnection)v0_8).disconnect();
        }

        h.c(ProtoBase.TAG, "[PostReq]url:" + v2.getHost() + v2.getFile() + ",response:" + v4_2);
        v11_6 = v1;
        v1_1 = v0_8;
        v0_7 = v11_6;
    label_89:
        v5_1 = v7 + 1;
        if(!ProtoBase.isSuccess(v4_2) && v5_1 < 3) {
            v7 = v5_1;
            v6 = v4_2;
            v4 = v1_1;
            v5 = v2;
            goto label_7;
        }

        this.OnResponse(v4_2, v3);
        return v4_2;
    }

    public static void setChannel(String arg0) {
    }
}

