package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new FragmentState.AnonymousClass1(20);
    public final int zaa;
    public final int zab;
    public final int zac;
    public final long zad;
    public final long zae;
    public final String zaf;
    public final String zag;
    public final int zah;
    public final int zai;

    public MethodInvocation(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.zaa = i;
        this.zab = i2;
        this.zac = i3;
        this.zad = j;
        this.zae = j2;
        this.zaf = str;
        this.zag = str2;
        this.zah = i4;
        this.zai = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(this.zab);
        zzkp.zzc(parcel, 3, 4);
        parcel.writeInt(this.zac);
        zzkp.zzc(parcel, 4, 8);
        parcel.writeLong(this.zad);
        zzkp.zzc(parcel, 5, 8);
        parcel.writeLong(this.zae);
        zzkp.writeString(parcel, 6, this.zaf);
        zzkp.writeString(parcel, 7, this.zag);
        zzkp.zzc(parcel, 8, 4);
        parcel.writeInt(this.zah);
        zzkp.zzc(parcel, 9, 4);
        parcel.writeInt(this.zai);
        zzkp.zzb(parcel, iZza);
    }
}
