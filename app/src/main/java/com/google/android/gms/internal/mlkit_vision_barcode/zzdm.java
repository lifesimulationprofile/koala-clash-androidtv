package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_common.zzz;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzdm extends zzcv {
    public final transient zzz zza;
    public final transient Object[] zzb;
    public final transient int zzc = 1;

    public zzdm(zzz zzzVar, Object[] objArr) {
        this.zza = zzzVar;
        this.zzb = objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzcs zzdlVar = super.zza;
        if (zzdlVar == null) {
            zzdlVar = new zzdl(this);
            super.zza = zzdlVar;
        }
        return zzdlVar.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zza(int i, Object[] objArr) {
        zzcs zzdlVar = super.zza;
        if (zzdlVar == null) {
            zzdlVar = new zzdl(this);
            super.zza = zzdlVar;
        }
        return zzdlVar.zza(i, objArr);
    }
}
