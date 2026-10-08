package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbv {
    public transient zzbg zzb;
    public transient zzbi zzc;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbv) {
            return zzv().equals(((zzbv) obj).zzv());
        }
        return false;
    }

    public final int hashCode() {
        return ((zzbi) zzv()).zza.hashCode();
    }

    public final String toString() {
        return ((zzbi) zzv()).zza.toString();
    }

    public final Map zzv() {
        zzbi zzbiVar = this.zzc;
        if (zzbiVar != null) {
            return zzbiVar;
        }
        zzbw zzbwVar = (zzbw) this;
        zzbi zzbiVar2 = new zzbi(zzbwVar, zzbwVar.zza);
        this.zzc = zzbiVar2;
        return zzbiVar2;
    }

    public final Set zzw() {
        zzbg zzbgVar = this.zzb;
        if (zzbgVar != null) {
            return zzbgVar;
        }
        zzbw zzbwVar = (zzbw) this;
        zzbg zzbgVar2 = new zzbg(zzbwVar, zzbwVar.zza);
        this.zzb = zzbgVar2;
        return zzbgVar2;
    }
}
