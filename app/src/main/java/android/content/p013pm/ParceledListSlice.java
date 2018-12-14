package android.content.p013pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

/* renamed from: android.content.pm.ParceledListSlice */
public class ParceledListSlice<T extends Parcelable> implements Parcelable {
    public static final Creator<ParceledListSlice> CREATOR = new C00431();
    private static final int MAX_IPC_SIZE = 262144;
    private boolean mIsLastSlice;
    private int mNumItems;
    private Parcel mParcel;

    /* renamed from: android.content.pm.ParceledListSlice$1 */
    class C00431 implements Creator<ParceledListSlice> {
        C00431() {
        }

        public ParceledListSlice createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() == 1;
            if (readInt <= 0) {
                return new ParceledListSlice();
            }
            int readInt2 = parcel.readInt();
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(dataPosition + readInt2);
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            obtain.appendFrom(parcel, dataPosition, readInt2);
            obtain.setDataPosition(0);
            return new ParceledListSlice(obtain, readInt, z, null);
        }

        public ParceledListSlice[] newArray(int i) {
            return new ParceledListSlice[i];
        }
    }

    public ParceledListSlice() {
        this.mParcel = Parcel.obtain();
    }

    private ParceledListSlice(Parcel parcel, int i, boolean z) {
        this.mParcel = parcel;
        this.mNumItems = i;
        this.mIsLastSlice = z;
    }

    /* synthetic */ ParceledListSlice(Parcel parcel, int i, boolean z, ParceledListSlice parceledListSlice) {
        this(parcel, i, z);
    }

    public boolean append(T t) {
        if (this.mParcel == null) {
            throw new IllegalStateException("ParceledListSlice has already been recycled");
        }
        t.writeToParcel(this.mParcel, 1);
        this.mNumItems++;
        return this.mParcel.dataSize() > 262144;
    }

    public int describeContents() {
        return 0;
    }

    public boolean isLastSlice() {
        return this.mIsLastSlice;
    }

    public T populateList(List<T> list, Creator<T> creator) {
        this.mParcel.setDataPosition(0);
        T t = null;
        for (int i = 0; i < this.mNumItems; i++) {
            Parcelable t2 = (Parcelable) creator.createFromParcel(this.mParcel);
            list.add(t2);
        }
        this.mParcel.recycle();
        this.mParcel = null;
        return t2;
    }

    public void setLastSlice(boolean z) {
        this.mIsLastSlice = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mNumItems);
        parcel.writeInt(this.mIsLastSlice ? 1 : 0);
        if (this.mNumItems > 0) {
            int dataSize = this.mParcel.dataSize();
            parcel.writeInt(dataSize);
            parcel.appendFrom(this.mParcel, 0, dataSize);
        }
        this.mNumItems = 0;
        this.mParcel.recycle();
        this.mParcel = null;
    }
}
