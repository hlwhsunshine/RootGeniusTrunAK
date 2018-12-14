package com.nostra13.universalimageloader.core.p065a;

import com.nostra13.universalimageloader.core.assist.C1013c;
import com.nostra13.universalimageloader.p064b.C0998b;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.nostra13.universalimageloader.core.a.a */
public final class C1007a implements C1006b {
    /* renamed from: a */
    protected final boolean f2510a;

    /* renamed from: com.nostra13.universalimageloader.core.a.a$a */
    protected static class C1004a {
        /* renamed from: a */
        public final int f2506a;
        /* renamed from: b */
        public final boolean f2507b;

        protected C1004a() {
            this.f2506a = 0;
            this.f2507b = false;
        }

        protected C1004a(int i, boolean z) {
            this.f2506a = i;
            this.f2507b = z;
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.a.a$b */
    protected static class C1005b {
        /* renamed from: a */
        public final C1013c f2508a;
        /* renamed from: b */
        public final C1004a f2509b;

        protected C1005b(C1013c c1013c, C1004a c1004a) {
            this.f2508a = c1013c;
            this.f2509b = c1004a;
        }
    }

    public C1007a(boolean z) {
        this.f2510a = z;
    }

    /* JADX WARNING: Missing block: B:8:0x001f, code:
            r1 = 90;
     */
    /* JADX WARNING: Missing block: B:10:0x0023, code:
            r1 = 180;
     */
    /* JADX WARNING: Missing block: B:12:0x0027, code:
            r1 = 270;
     */
    /* renamed from: a */
    private static com.nostra13.universalimageloader.core.p065a.C1007a.C1004a m2857a(java.lang.String r5) {
        /*
        r1 = 0;
        r0 = 1;
        r2 = new android.media.ExifInterface;	 Catch:{ IOException -> 0x002a }
        r3 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE;	 Catch:{ IOException -> 0x002a }
        r3 = r3.crop(r5);	 Catch:{ IOException -> 0x002a }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002a }
        r3 = "Orientation";
        r4 = 1;
        r2 = r2.getAttributeInt(r3, r4);	 Catch:{ IOException -> 0x002a }
        switch(r2) {
            case 1: goto L_0x0017;
            case 2: goto L_0x0018;
            case 3: goto L_0x0022;
            case 4: goto L_0x0023;
            case 5: goto L_0x0027;
            case 6: goto L_0x001e;
            case 7: goto L_0x001f;
            case 8: goto L_0x0026;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r1;
    L_0x0018:
        r2 = new com.nostra13.universalimageloader.core.a.a$a;
        r2.<init>(r1, r0);
        return r2;
    L_0x001e:
        r0 = r1;
    L_0x001f:
        r1 = 90;
        goto L_0x0018;
    L_0x0022:
        r0 = r1;
    L_0x0023:
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        goto L_0x0018;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        r1 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        goto L_0x0018;
    L_0x002a:
        r2 = move-exception;
        r2 = "Can't read EXIF tags from file [%s]";
        r0 = new java.lang.Object[r0];
        r0[r1] = r5;
        com.nostra13.universalimageloader.p064b.C0999c.m2835c(r2, r0);
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.a.a.a(java.lang.String):com.nostra13.universalimageloader.core.a.a$a");
    }

    /* renamed from: a */
    private static InputStream m2858a(InputStream inputStream, C1008c c1008c) {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException e) {
            C0998b.m2827a(inputStream);
            return C1007a.m2859b(c1008c);
        }
    }

    /* renamed from: b */
    private static InputStream m2859b(C1008c c1008c) {
        return c1008c.mo6163f().mo6290a(c1008c.mo6159b(), c1008c.mo6164g());
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00aa A:{SYNTHETIC, Splitter: B:28:0x00aa} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057 A:{Catch:{ all -> 0x00a4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008e  */
    /* renamed from: a */
    public final android.graphics.Bitmap mo6157a(com.nostra13.universalimageloader.core.p065a.C1008c r15) {
        /*
        r14 = this;
        r13 = 3;
        r12 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r11 = 2;
        r1 = 0;
        r6 = 1;
        r2 = com.nostra13.universalimageloader.core.p065a.C1007a.m2859b(r15);
        r3 = new android.graphics.BitmapFactory$Options;	 Catch:{ all -> 0x00a4 }
        r3.<init>();	 Catch:{ all -> 0x00a4 }
        r0 = 1;
        r3.inJustDecodeBounds = r0;	 Catch:{ all -> 0x00a4 }
        r0 = 0;
        android.graphics.BitmapFactory.decodeStream(r2, r0, r3);	 Catch:{ all -> 0x00a4 }
        r4 = r15.mo6159b();	 Catch:{ all -> 0x00a4 }
        r0 = r15.mo6165h();	 Catch:{ all -> 0x00a4 }
        if (r0 == 0) goto L_0x009e;
    L_0x0020:
        r0 = r3.outMimeType;	 Catch:{ all -> 0x00a4 }
        r5 = "image/jpeg";
        r0 = r5.equalsIgnoreCase(r0);	 Catch:{ all -> 0x00a4 }
        if (r0 == 0) goto L_0x009c;
    L_0x002a:
        r0 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(r4);	 Catch:{ all -> 0x00a4 }
        r5 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE;	 Catch:{ all -> 0x00a4 }
        if (r0 != r5) goto L_0x009c;
    L_0x0032:
        r0 = r6;
    L_0x0033:
        if (r0 == 0) goto L_0x009e;
    L_0x0035:
        r0 = com.nostra13.universalimageloader.core.p065a.C1007a.m2857a(r4);	 Catch:{ all -> 0x00a4 }
    L_0x0039:
        r4 = new com.nostra13.universalimageloader.core.a.a$b;	 Catch:{ all -> 0x00a4 }
        r5 = new com.nostra13.universalimageloader.core.assist.c;	 Catch:{ all -> 0x00a4 }
        r7 = r3.outWidth;	 Catch:{ all -> 0x00a4 }
        r3 = r3.outHeight;	 Catch:{ all -> 0x00a4 }
        r8 = r0.f2506a;	 Catch:{ all -> 0x00a4 }
        r5.<init>(r7, r3, r8);	 Catch:{ all -> 0x00a4 }
        r4.<init>(r5, r0);	 Catch:{ all -> 0x00a4 }
        r2 = com.nostra13.universalimageloader.core.p065a.C1007a.m2858a(r2, r15);	 Catch:{ all -> 0x00a4 }
        r3 = r4.f2508a;	 Catch:{ all -> 0x00a4 }
        r0 = r15.mo6161d();	 Catch:{ all -> 0x00a4 }
        r5 = com.nostra13.universalimageloader.core.assist.ImageScaleType.NONE;	 Catch:{ all -> 0x00a4 }
        if (r0 != r5) goto L_0x00aa;
    L_0x0057:
        r0 = r6;
    L_0x0058:
        if (r0 <= r6) goto L_0x007e;
    L_0x005a:
        r5 = r14.f2510a;	 Catch:{ all -> 0x00a4 }
        if (r5 == 0) goto L_0x007e;
    L_0x005e:
        r5 = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
        r7 = 4;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00a4 }
        r8 = 0;
        r7[r8] = r3;	 Catch:{ all -> 0x00a4 }
        r8 = 1;
        r3 = r3.mo6179a(r0);	 Catch:{ all -> 0x00a4 }
        r7[r8] = r3;	 Catch:{ all -> 0x00a4 }
        r3 = 2;
        r8 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00a4 }
        r7[r3] = r8;	 Catch:{ all -> 0x00a4 }
        r3 = 3;
        r8 = r15.mo6158a();	 Catch:{ all -> 0x00a4 }
        r7[r3] = r8;	 Catch:{ all -> 0x00a4 }
        com.nostra13.universalimageloader.p064b.C0999c.m2831a(r5, r7);	 Catch:{ all -> 0x00a4 }
    L_0x007e:
        r3 = r15.mo6166i();	 Catch:{ all -> 0x00a4 }
        r3.inSampleSize = r0;	 Catch:{ all -> 0x00a4 }
        r0 = 0;
        r0 = android.graphics.BitmapFactory.decodeStream(r2, r0, r3);	 Catch:{ all -> 0x00a4 }
        com.nostra13.universalimageloader.p064b.C0998b.m2827a(r2);
        if (r0 != 0) goto L_0x00c7;
    L_0x008e:
        r2 = "Image can't be decoded [%s]";
        r3 = new java.lang.Object[r6];
        r4 = r15.mo6158a();
        r3[r1] = r4;
        com.nostra13.universalimageloader.p064b.C0999c.m2836d(r2, r3);
    L_0x009b:
        return r0;
    L_0x009c:
        r0 = r1;
        goto L_0x0033;
    L_0x009e:
        r0 = new com.nostra13.universalimageloader.core.a.a$a;	 Catch:{ all -> 0x00a4 }
        r0.<init>();	 Catch:{ all -> 0x00a4 }
        goto L_0x0039;
    L_0x00a4:
        r0 = move-exception;
        r1 = r2;
        com.nostra13.universalimageloader.p064b.C0998b.m2827a(r1);
        throw r0;
    L_0x00aa:
        r5 = com.nostra13.universalimageloader.core.assist.ImageScaleType.NONE_SAFE;	 Catch:{ all -> 0x00a4 }
        if (r0 != r5) goto L_0x00b3;
    L_0x00ae:
        r0 = com.nostra13.universalimageloader.p064b.C0996a.m2822a(r3);	 Catch:{ all -> 0x00a4 }
        goto L_0x0058;
    L_0x00b3:
        r5 = r15.mo6160c();	 Catch:{ all -> 0x00a4 }
        r7 = com.nostra13.universalimageloader.core.assist.ImageScaleType.IN_SAMPLE_POWER_OF_2;	 Catch:{ all -> 0x00a4 }
        if (r0 != r7) goto L_0x00c5;
    L_0x00bb:
        r0 = r6;
    L_0x00bc:
        r7 = r15.mo6162e();	 Catch:{ all -> 0x00a4 }
        r0 = com.nostra13.universalimageloader.p064b.C0996a.m2823a(r3, r5, r7, r0);	 Catch:{ all -> 0x00a4 }
        goto L_0x0058;
    L_0x00c5:
        r0 = r1;
        goto L_0x00bc;
    L_0x00c7:
        r2 = r4.f2509b;
        r3 = r2.f2506a;
        r2 = r4.f2509b;
        r4 = r2.f2507b;
        r5 = new android.graphics.Matrix;
        r5.<init>();
        r2 = r15.mo6161d();
        r7 = com.nostra13.universalimageloader.core.assist.ImageScaleType.EXACTLY;
        if (r2 == r7) goto L_0x00e0;
    L_0x00dc:
        r7 = com.nostra13.universalimageloader.core.assist.ImageScaleType.EXACTLY_STRETCHED;
        if (r2 != r7) goto L_0x0127;
    L_0x00e0:
        r7 = new com.nostra13.universalimageloader.core.assist.c;
        r8 = r0.getWidth();
        r9 = r0.getHeight();
        r7.<init>(r8, r9, r3);
        r8 = r15.mo6160c();
        r9 = r15.mo6162e();
        r10 = com.nostra13.universalimageloader.core.assist.ImageScaleType.EXACTLY_STRETCHED;
        if (r2 != r10) goto L_0x0171;
    L_0x00f9:
        r2 = r6;
    L_0x00fa:
        r2 = com.nostra13.universalimageloader.p064b.C0996a.m2825b(r7, r8, r9, r2);
        r8 = java.lang.Float.compare(r2, r12);
        if (r8 == 0) goto L_0x0127;
    L_0x0104:
        r5.setScale(r2, r2);
        r8 = r14.f2510a;
        if (r8 == 0) goto L_0x0127;
    L_0x010b:
        r8 = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r9[r1] = r7;
        r7 = r7.mo6178a(r2);
        r9[r6] = r7;
        r2 = java.lang.Float.valueOf(r2);
        r9[r11] = r2;
        r2 = r15.mo6158a();
        r9[r13] = r2;
        com.nostra13.universalimageloader.p064b.C0999c.m2831a(r8, r9);
    L_0x0127:
        if (r4 == 0) goto L_0x013f;
    L_0x0129:
        r2 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r5.postScale(r2, r12);
        r2 = r14.f2510a;
        if (r2 == 0) goto L_0x013f;
    L_0x0132:
        r2 = "Flip image horizontally [%s]";
        r4 = new java.lang.Object[r6];
        r7 = r15.mo6158a();
        r4[r1] = r7;
        com.nostra13.universalimageloader.p064b.C0999c.m2831a(r2, r4);
    L_0x013f:
        if (r3 == 0) goto L_0x015c;
    L_0x0141:
        r2 = (float) r3;
        r5.postRotate(r2);
        r2 = r14.f2510a;
        if (r2 == 0) goto L_0x015c;
    L_0x0149:
        r2 = "Rotate image on %1$d° [%2$s]";
        r4 = new java.lang.Object[r11];
        r3 = java.lang.Integer.valueOf(r3);
        r4[r1] = r3;
        r3 = r15.mo6158a();
        r4[r6] = r3;
        com.nostra13.universalimageloader.p064b.C0999c.m2831a(r2, r4);
    L_0x015c:
        r3 = r0.getWidth();
        r4 = r0.getHeight();
        r2 = r1;
        r1 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6);
        if (r1 == r0) goto L_0x016e;
    L_0x016b:
        r0.recycle();
    L_0x016e:
        r0 = r1;
        goto L_0x009b;
    L_0x0171:
        r2 = r1;
        goto L_0x00fa;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.a.a.a(com.nostra13.universalimageloader.core.a.c):android.graphics.Bitmap");
    }
}
