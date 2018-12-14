package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Video.Thumbnails;
import com.nostra13.universalimageloader.core.assist.C1011a;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.p064b.C0998b;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.nostra13.universalimageloader.core.download.a */
public final class C1035a implements ImageDownloader {
    /* renamed from: a */
    protected final Context f2599a;
    /* renamed from: b */
    protected final int f2600b = 5000;
    /* renamed from: c */
    protected final int f2601c = 20000;

    public C1035a(Context context) {
        this.f2599a = context.getApplicationContext();
    }

    /* renamed from: a */
    private InputStream m2991a(String str) {
        int i = 0;
        HttpURLConnection b = m2992b(str);
        while (b.getResponseCode() / 100 == 3 && i < 5) {
            b = m2992b(b.getHeaderField("Location"));
            i++;
        }
        try {
            return new C1011a(new BufferedInputStream(b.getInputStream(), 32768), b.getContentLength());
        } catch (Object e) {
            Closeable errorStream = b.getErrorStream();
            while (true) {
                try {
                    if (errorStream.read(new byte[32768], 0, 32768) == -1) {
                        break;
                    }
                } catch (IOException e2) {
                    throw e;
                } finally {
                    C0998b.m2827a(errorStream);
                }
            }
            throw e;
        }
    }

    /* renamed from: b */
    private HttpURLConnection m2992b(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.f2600b);
        httpURLConnection.setReadTimeout(this.f2601c);
        return httpURLConnection;
    }

    /* renamed from: a */
    public final InputStream mo6290a(String str, Object obj) {
        switch (Scheme.ofUri(str)) {
            case HTTP:
            case HTTPS:
                return m2991a(str);
            case FILE:
                String crop = Scheme.FILE.crop(str);
                return new C1011a(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
            case CONTENT:
                ContentResolver contentResolver = this.f2599a.getContentResolver();
                Uri parse = Uri.parse(str);
                String type = this.f2599a.getContentResolver().getType(parse);
                if (type == null ? false : type.startsWith("video/")) {
                    Bitmap thumbnail = Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
                    if (thumbnail != null) {
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        thumbnail.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
                        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    }
                } else if (str.startsWith("content://com.android.contacts/")) {
                    return Contacts.openContactPhotoInputStream(contentResolver, parse);
                }
                return contentResolver.openInputStream(parse);
            case ASSETS:
                return this.f2599a.getAssets().open(Scheme.ASSETS.crop(str));
            case DRAWABLE:
                return this.f2599a.getResources().openRawResource(Integer.parseInt(Scheme.DRAWABLE.crop(str)));
            default:
                throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[]{str}));
        }
    }
}
