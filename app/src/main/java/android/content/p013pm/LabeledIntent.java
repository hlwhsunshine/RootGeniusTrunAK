package android.content.p013pm;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: android.content.pm.LabeledIntent */
public class LabeledIntent extends Intent {
    public static final Creator<LabeledIntent> CREATOR = new C00371();
    private int mIcon;
    private int mLabelRes;
    private CharSequence mNonLocalizedLabel;
    private String mSourcePackage;

    /* renamed from: android.content.pm.LabeledIntent$1 */
    class C00371 implements Creator<LabeledIntent> {
        C00371() {
        }

        public LabeledIntent createFromParcel(Parcel parcel) {
            return new LabeledIntent(parcel);
        }

        public LabeledIntent[] newArray(int i) {
            return new LabeledIntent[i];
        }
    }

    public LabeledIntent(Intent intent, String str, int i, int i2) {
        super(intent);
        this.mSourcePackage = str;
        this.mLabelRes = i;
        this.mNonLocalizedLabel = null;
        this.mIcon = i2;
    }

    public LabeledIntent(Intent intent, String str, CharSequence charSequence, int i) {
        super(intent);
        this.mSourcePackage = str;
        this.mLabelRes = 0;
        this.mNonLocalizedLabel = charSequence;
        this.mIcon = i;
    }

    protected LabeledIntent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public LabeledIntent(String str, int i, int i2) {
        this.mSourcePackage = str;
        this.mLabelRes = i;
        this.mNonLocalizedLabel = null;
        this.mIcon = i2;
    }

    public LabeledIntent(String str, CharSequence charSequence, int i) {
        this.mSourcePackage = str;
        this.mLabelRes = 0;
        this.mNonLocalizedLabel = charSequence;
        this.mIcon = i;
    }

    public int getIconResource() {
        return this.mIcon;
    }

    public int getLabelResource() {
        return this.mLabelRes;
    }

    public CharSequence getNonLocalizedLabel() {
        return this.mNonLocalizedLabel;
    }

    public String getSourcePackage() {
        return this.mSourcePackage;
    }

    public Drawable loadIcon(PackageManager packageManager) {
        if (!(this.mIcon == 0 || this.mSourcePackage == null)) {
            Drawable drawable = packageManager.getDrawable(this.mSourcePackage, this.mIcon, null);
            if (drawable != null) {
                return drawable;
            }
        }
        return null;
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        if (this.mNonLocalizedLabel != null) {
            return this.mNonLocalizedLabel;
        }
        if (!(this.mLabelRes == 0 || this.mSourcePackage == null)) {
            CharSequence text = packageManager.getText(this.mSourcePackage, this.mLabelRes, null);
            if (text != null) {
                return text;
            }
        }
        return null;
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mSourcePackage = parcel.readString();
        this.mLabelRes = parcel.readInt();
        this.mNonLocalizedLabel = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mIcon = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSourcePackage);
        parcel.writeInt(this.mLabelRes);
        TextUtils.writeToParcel(this.mNonLocalizedLabel, parcel, i);
        parcel.writeInt(this.mIcon);
    }
}
