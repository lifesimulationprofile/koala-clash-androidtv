package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzcc extends AbstractSet {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzci zza;

    public /* synthetic */ zzcc(zzci zzciVar, int i) {
        this.$r8$classId = i;
        this.zza = zzciVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                this.zza.clear();
                break;
            default:
                this.zza.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                zzci zzciVar = this.zza;
                Map mapZzl = zzciVar.zzl();
                if (mapZzl != null) {
                    return mapZzl.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int iZzw = zzciVar.zzw(entry.getKey());
                    if (iZzw != -1 && com.google.android.gms.internal.mlkit_vision_common.zzkv.zza(zzciVar.zzC()[iZzw], entry.getValue())) {
                        return true;
                    }
                }
                return false;
            default:
                return this.zza.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                zzci zzciVar = this.zza;
                Map mapZzl = zzciVar.zzl();
                return mapZzl != null ? mapZzl.entrySet().iterator() : new zzbz(zzciVar, 1);
            default:
                zzci zzciVar2 = this.zza;
                Map mapZzl2 = zzciVar2.zzl();
                return mapZzl2 != null ? mapZzl2.keySet().iterator() : new zzbz(zzciVar2, 0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                zzci zzciVar = this.zza;
                Map mapZzl = zzciVar.zzl();
                if (mapZzl != null) {
                    return mapZzl.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!zzciVar.zzr()) {
                        int iZzv = zzciVar.zzv();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object obj2 = zzciVar.zze;
                        Objects.requireNonNull(obj2);
                        int iZzb = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzb(key, value, iZzv, obj2, zzciVar.zzA(), zzciVar.zzB(), zzciVar.zzC());
                        if (iZzb != -1) {
                            zzciVar.zzq(iZzb, iZzv);
                            zzciVar.zzg--;
                            zzciVar.zzf += 32;
                            return true;
                        }
                    }
                }
                return false;
            default:
                zzci zzciVar2 = this.zza;
                Map mapZzl2 = zzciVar2.zzl();
                if (mapZzl2 != null) {
                    return mapZzl2.keySet().remove(obj);
                }
                return zzciVar2.zzy(obj) != zzci.zzd;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.zza.size();
    }
}
