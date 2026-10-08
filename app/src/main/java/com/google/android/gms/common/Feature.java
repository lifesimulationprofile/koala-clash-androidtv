package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;
import java.util.Arrays;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb(1);
    public final String zza;
    public final int zzb;
    public final long zzc;

    public Feature(int i, long j, String str) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = feature.zza;
            String str2 = this.zza;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public final long getVersion() {
        long j = this.zzc;
        return j == -1 ? this.zzb : j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(getVersion())});
    }

    public final String toString() {
        CacheStrategy cacheStrategy = new CacheStrategy(this);
        cacheStrategy.add(this.zza, "name");
        cacheStrategy.add(Long.valueOf(getVersion()), "version");
        return cacheStrategy.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.writeString(parcel, 1, this.zza);
        zzkp.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        long version = getVersion();
        zzkp.zzc(parcel, 3, 8);
        parcel.writeLong(version);
        zzkp.zzb(parcel, iZza);
    }

    public Feature(String str, long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }
}
