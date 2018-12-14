package android.support.p015v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p015v4.app.BackStackRecord.C0069Op;
import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.BackStackState */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C00701();
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    /* renamed from: android.support.v4.app.BackStackState$1 */
    final class C00701 implements Creator<BackStackState> {
        C00701() {
        }

        public final BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public final BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int i = 0;
        for (C0069Op c0069Op = backStackRecord.mHead; c0069Op != null; c0069Op = c0069Op.next) {
            if (c0069Op.removed != null) {
                i += c0069Op.removed.size();
            }
        }
        this.mOps = new int[(i + (backStackRecord.mNumOp * 7))];
        if (backStackRecord.mAddToBackStack) {
            i = 0;
            for (C0069Op c0069Op2 = backStackRecord.mHead; c0069Op2 != null; c0069Op2 = c0069Op2.next) {
                int i2 = i + 1;
                this.mOps[i] = c0069Op2.cmd;
                int i3 = i2 + 1;
                this.mOps[i2] = c0069Op2.fragment != null ? c0069Op2.fragment.mIndex : -1;
                int i4 = i3 + 1;
                this.mOps[i3] = c0069Op2.enterAnim;
                i2 = i4 + 1;
                this.mOps[i4] = c0069Op2.exitAnim;
                i4 = i2 + 1;
                this.mOps[i2] = c0069Op2.popEnterAnim;
                i2 = i4 + 1;
                this.mOps[i4] = c0069Op2.popExitAnim;
                if (c0069Op2.removed != null) {
                    int size = c0069Op2.removed.size();
                    i4 = i2 + 1;
                    this.mOps[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.mOps[i4] = ((Fragment) c0069Op2.removed.get(i2)).mIndex;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.mOps[i2] = 0;
                }
            }
            this.mTransition = backStackRecord.mTransition;
            this.mTransitionStyle = backStackRecord.mTransitionStyle;
            this.mName = backStackRecord.mName;
            this.mIndex = backStackRecord.mIndex;
            this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
            this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public final int describeContents() {
        return 0;
    }

    public final BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i2 < this.mOps.length) {
            C0069Op c0069Op = new C0069Op();
            int i3 = i2 + 1;
            c0069Op.cmd = this.mOps[i2];
            if (FragmentManagerImpl.DEBUG) {
                new StringBuilder("Instantiate ").append(backStackRecord).append(" op #").append(i).append(" base fragment #").append(this.mOps[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.mOps[i3];
            if (i2 >= 0) {
                c0069Op.fragment = (Fragment) fragmentManagerImpl.mActive.get(i2);
            } else {
                c0069Op.fragment = null;
            }
            i3 = i4 + 1;
            c0069Op.enterAnim = this.mOps[i4];
            i4 = i3 + 1;
            c0069Op.exitAnim = this.mOps[i3];
            i3 = i4 + 1;
            c0069Op.popEnterAnim = this.mOps[i4];
            int i5 = i3 + 1;
            c0069Op.popExitAnim = this.mOps[i3];
            i4 = i5 + 1;
            int i6 = this.mOps[i5];
            if (i6 > 0) {
                c0069Op.removed = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (FragmentManagerImpl.DEBUG) {
                        new StringBuilder("Instantiate ").append(backStackRecord).append(" set remove fragment #").append(this.mOps[i4]);
                    }
                    i5 = i4 + 1;
                    c0069Op.removed.add((Fragment) fragmentManagerImpl.mActive.get(this.mOps[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            backStackRecord.mEnterAnim = c0069Op.enterAnim;
            backStackRecord.mExitAnim = c0069Op.exitAnim;
            backStackRecord.mPopEnterAnim = c0069Op.popEnterAnim;
            backStackRecord.mPopExitAnim = c0069Op.popExitAnim;
            backStackRecord.addOp(c0069Op);
            i++;
            i2 = i4;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mTransitionStyle = this.mTransitionStyle;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
    }
}
