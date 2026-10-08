package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AddressParcelable implements Parcelable {
    public static final Parcelable.Creator<AddressParcelable> CREATOR = new zzb(10);
    public final List addressLines;
    public final int type;

    public AddressParcelable(int i, List list) {
        this.addressLines = list;
        this.type = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.addressLines);
        parcel.writeInt(this.type);
    }
}
