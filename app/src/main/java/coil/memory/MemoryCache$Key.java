package coil.memory;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MemoryCache$Key implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<MemoryCache$Key> CREATOR = new FragmentState.AnonymousClass1(14);
    public final Map extras;
    public final String key;

    public MemoryCache$Key(String str, Map map) {
        this.key = str;
        this.extras = map;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemoryCache$Key)) {
            return false;
        }
        MemoryCache$Key memoryCache$Key = (MemoryCache$Key) obj;
        return Intrinsics.areEqual(this.key, memoryCache$Key.key) && Intrinsics.areEqual(this.extras, memoryCache$Key.extras);
    }

    public final int hashCode() {
        return this.extras.hashCode() + (this.key.hashCode() * 31);
    }

    public final String toString() {
        return "Key(key=" + this.key + ", extras=" + this.extras + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        Map map = this.extras;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            parcel.writeString(str);
            parcel.writeString(str2);
        }
    }
}
