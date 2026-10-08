package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzbz implements Iterator {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzci zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public final /* synthetic */ zzci zze;

    public zzbz(zzci zzciVar, int i) {
        this.$r8$classId = i;
        this.zza = zzciVar;
        this.zze = zzciVar;
        this.zzb = zzciVar.zzf;
        this.zzc = zzciVar.isEmpty() ? -1 : 0;
        this.zzd = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object zzcgVar;
        zzci zzciVar = this.zze;
        if (zzciVar.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzc;
        this.zzd = i;
        int i2 = this.$r8$classId;
        zzci zzciVar2 = this.zza;
        switch (i2) {
            case 0:
                Object obj = zzci.zzd;
                zzcgVar = zzciVar2.zzB()[i];
                break;
            case 1:
                zzcgVar = new zzcg(zzciVar2, i);
                break;
            default:
                Object obj2 = zzci.zzd;
                zzcgVar = zzciVar2.zzC()[i];
                break;
        }
        int i3 = this.zzc + 1;
        if (i3 >= zzciVar.zzg) {
            i3 = -1;
        }
        this.zzc = i3;
        return zzcgVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzci zzciVar = this.zze;
        if (zzciVar.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
        com.google.android.gms.internal.mlkit_vision_common.zzkw.zzf("no calls to next() since the last call to remove()", this.zzd >= 0);
        this.zzb += 32;
        zzciVar.remove(zzciVar.zzB()[this.zzd]);
        this.zzc--;
        this.zzd = -1;
    }
}
