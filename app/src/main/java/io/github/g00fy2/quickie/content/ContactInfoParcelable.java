package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContactInfoParcelable implements Parcelable {
    public static final Parcelable.Creator<ContactInfoParcelable> CREATOR = new zzb(13);
    public final Object addressParcelables;
    public final Object emailParcelables;
    public final PersonNameParcelable nameParcelable;
    public final String organization;
    public final Object phoneParcelables;
    public final String title;
    public final List urls;

    public ContactInfoParcelable(List list, List list2, PersonNameParcelable personNameParcelable, String str, List list3, String str2, List list4) {
        this.addressParcelables = list;
        this.emailParcelables = list2;
        this.nameParcelable = personNameParcelable;
        this.organization = str;
        this.phoneParcelables = list3;
        this.title = str2;
        this.urls = list4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.List] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ?? r0 = this.addressParcelables;
        parcel.writeInt(r0.size());
        Iterator it = r0.iterator();
        while (it.hasNext()) {
            ((AddressParcelable) it.next()).writeToParcel(parcel, i);
        }
        ?? r1 = this.emailParcelables;
        parcel.writeInt(r1.size());
        Iterator it2 = r1.iterator();
        while (it2.hasNext()) {
            ((EmailParcelable) it2.next()).writeToParcel(parcel, i);
        }
        this.nameParcelable.writeToParcel(parcel, i);
        parcel.writeString(this.organization);
        ?? r2 = this.phoneParcelables;
        parcel.writeInt(r2.size());
        Iterator it3 = r2.iterator();
        while (it3.hasNext()) {
            ((PhoneParcelable) it3.next()).writeToParcel(parcel, i);
        }
        parcel.writeString(this.title);
        parcel.writeStringList(this.urls);
    }
}
