package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class zzbh implements Iterator {
    public final /* synthetic */ int $r8$classId = 0;
    public final Iterator zza;
    public Collection zzb;
    public final /* synthetic */ Object zzc;

    public zzbh(zzbq zzbqVar, ListIterator listIterator) {
        this.zzc = zzbqVar;
        this.zzb = zzbqVar.zzb;
        this.zza = listIterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.$r8$classId) {
            case 0:
                break;
            default:
                zza();
                break;
        }
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                Map.Entry entry = (Map.Entry) this.zza.next();
                this.zzb = (Collection) entry.getValue();
                Object key = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                zzbw zzbwVar = ((zzbi) this.zzc).zzb;
                zzbwVar.getClass();
                List list = (List) collection;
                return new zzco(key, list instanceof RandomAccess ? new zzbm(zzbwVar, key, list, null) : new zzbq(zzbwVar, key, list, null));
            default:
                zza();
                return this.zza.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                com.google.android.gms.internal.mlkit_vision_common.zzkw.zzf("no calls to next() since the last call to remove()", this.zzb != null);
                this.zza.remove();
                ((zzbi) this.zzc).zzb.getClass();
                this.zzb.size();
                this.zzb.clear();
                this.zzb = null;
                break;
            default:
                this.zza.remove();
                ((zzbq) this.zzc).zzc();
                break;
        }
    }

    public void zza() {
        zzbq zzbqVar = (zzbq) this.zzc;
        zzbqVar.zzb();
        if (zzbqVar.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public zzbh(zzbi zzbiVar) {
        this.zzc = zzbiVar;
        this.zza = zzbiVar.zza.entrySet().iterator();
    }

    public zzbh(zzbq zzbqVar) {
        Iterator it;
        this.zzc = zzbqVar;
        Collection collection = zzbqVar.zzb;
        this.zzb = collection;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }
}
