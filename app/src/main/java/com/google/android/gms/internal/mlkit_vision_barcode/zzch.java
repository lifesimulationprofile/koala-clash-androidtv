package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzch extends AbstractCollection {
    public final /* synthetic */ int $r8$classId = 1;
    public final AbstractMap zza;

    public zzch(zzbi zzbiVar) {
        this.zza = zzbiVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                ((zzci) this.zza).clear();
                break;
            default:
                ((zzbi) this.zza).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                return ((zzbi) this.zza).containsValue(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.$r8$classId) {
            case 1:
                return ((zzbi) this.zza).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                zzci zzciVar = (zzci) this.zza;
                Map mapZzl = zzciVar.zzl();
                return mapZzl != null ? mapZzl.values().iterator() : new zzbz(zzciVar, 2);
            default:
                return new zzda(((zzbi) this.zza).entrySet().iterator());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                zzbi zzbiVar = (zzbi) this.zza;
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    for (Map.Entry entry : zzbiVar.entrySet()) {
                        if (com.google.android.gms.internal.mlkit_vision_common.zzkv.zza(obj, entry.getValue())) {
                            zzbiVar.remove(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.$r8$classId) {
            case 1:
                zzbi zzbiVar = (zzbi) this.zza;
                try {
                    if (collection != null) {
                        return super.removeAll(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : zzbiVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return zzbiVar.zzb.zzw().removeAll(hashSet);
                }
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.$r8$classId) {
            case 1:
                zzbi zzbiVar = (zzbi) this.zza;
                try {
                    if (collection != null) {
                        return super.retainAll(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : zzbiVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return zzbiVar.zzb.zzw().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.$r8$classId) {
            case 0:
                return ((zzci) this.zza).size();
            default:
                return ((zzbi) this.zza).zza.size();
        }
    }

    public zzch(zzci zzciVar) {
        this.zza = zzciVar;
    }
}
