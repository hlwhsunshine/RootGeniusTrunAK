package android.support.p015v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v4.media.RatingCompat */
public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C01301();
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    /* renamed from: android.support.v4.media.RatingCompat$1 */
    final class C01301 implements Creator<RatingCompat> {
        C01301() {
        }

        public final RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat(), null);
        }

        public final RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.RatingCompat$StarStyle */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.RatingCompat$Style */
    public @interface Style {
    }

    private RatingCompat(int i, float f) {
        this.mRatingStyle = i;
        this.mRatingValue = f;
    }

    /* synthetic */ RatingCompat(int i, float f, C01301 c01301) {
        this(i, f);
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && VERSION.SDK_INT >= 21) {
            int ratingStyle = RatingCompatApi21.getRatingStyle(obj);
            if (RatingCompatApi21.isRated(obj)) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = RatingCompat.newHeartRating(RatingCompatApi21.hasHeart(obj));
                        break;
                    case 2:
                        ratingCompat = RatingCompat.newThumbRating(RatingCompatApi21.isThumbUp(obj));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = RatingCompat.newStarRating(ratingStyle, RatingCompatApi21.getStarRating(obj));
                        break;
                    case 6:
                        ratingCompat = RatingCompat.newPercentageRating(RatingCompatApi21.getPercentRating(obj));
                        break;
                }
            }
            ratingCompat = RatingCompat.newUnratedRating(ratingStyle);
            ratingCompat.mRatingObj = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newPercentageRating(float f) {
        return (f < 0.0f || f > 100.0f) ? null : new RatingCompat(6, f);
    }

    public static RatingCompat newStarRating(int i, float f) {
        float f2;
        switch (i) {
            case 3:
                f2 = 3.0f;
                break;
            case 4:
                f2 = 4.0f;
                break;
            case 5:
                f2 = 5.0f;
                break;
            default:
                new StringBuilder("Invalid rating style (").append(i).append(") for a star rating");
                return null;
        }
        return (f < 0.0f || f > f2) ? null : new RatingCompat(i, f);
    }

    public static RatingCompat newThumbRating(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newUnratedRating(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, RATING_NOT_RATED);
            default:
                return null;
        }
    }

    public final int describeContents() {
        return this.mRatingStyle;
    }

    public final float getPercentRating() {
        return (this.mRatingStyle == 6 && isRated()) ? this.mRatingValue : RATING_NOT_RATED;
    }

    /* JADX WARNING: Missing block: B:17:?, code:
            return null;
     */
    public final java.lang.Object getRating() {
        /*
        r2 = this;
        r0 = r2.mRatingObj;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x000d;
    L_0x000a:
        r0 = r2.mRatingObj;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r2.isRated();
        if (r0 == 0) goto L_0x004a;
    L_0x0013:
        r0 = r2.mRatingStyle;
        switch(r0) {
            case 1: goto L_0x001a;
            case 2: goto L_0x0027;
            case 3: goto L_0x0032;
            case 4: goto L_0x0032;
            case 5: goto L_0x0032;
            case 6: goto L_0x003f;
            default: goto L_0x0018;
        };
    L_0x0018:
        r0 = 0;
        goto L_0x000c;
    L_0x001a:
        r0 = r2.hasHeart();
        r0 = android.support.p015v4.media.RatingCompatApi21.newHeartRating(r0);
        r2.mRatingObj = r0;
    L_0x0024:
        r0 = r2.mRatingObj;
        goto L_0x000c;
    L_0x0027:
        r0 = r2.isThumbUp();
        r0 = android.support.p015v4.media.RatingCompatApi21.newThumbRating(r0);
        r2.mRatingObj = r0;
        goto L_0x0024;
    L_0x0032:
        r0 = r2.mRatingStyle;
        r1 = r2.getStarRating();
        r0 = android.support.p015v4.media.RatingCompatApi21.newStarRating(r0, r1);
        r2.mRatingObj = r0;
        goto L_0x0024;
    L_0x003f:
        r0 = r2.getPercentRating();
        r0 = android.support.p015v4.media.RatingCompatApi21.newPercentageRating(r0);
        r2.mRatingObj = r0;
        goto L_0x0018;
    L_0x004a:
        r0 = r2.mRatingStyle;
        r0 = android.support.p015v4.media.RatingCompatApi21.newUnratedRating(r0);
        r2.mRatingObj = r0;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.RatingCompat.getRating():java.lang.Object");
    }

    public final int getRatingStyle() {
        return this.mRatingStyle;
    }

    public final float getStarRating() {
        switch (this.mRatingStyle) {
            case 3:
            case 4:
            case 5:
                if (isRated()) {
                    return this.mRatingValue;
                }
                break;
        }
        return RATING_NOT_RATED;
    }

    public final boolean hasHeart() {
        return this.mRatingStyle == 1 && this.mRatingValue == 1.0f;
    }

    public final boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public final boolean isThumbUp() {
        return this.mRatingStyle == 2 && this.mRatingValue == 1.0f;
    }

    public final String toString() {
        return "Rating:style=" + this.mRatingStyle + " rating=" + (this.mRatingValue < 0.0f ? "unrated" : String.valueOf(this.mRatingValue));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
