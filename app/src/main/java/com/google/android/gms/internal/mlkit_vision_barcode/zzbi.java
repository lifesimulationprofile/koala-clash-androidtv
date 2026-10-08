package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzbi extends AbstractMap {
    public final transient Map zza;
    public transient zzbg zza$1;
    public final /* synthetic */ zzbw zzb;
    public transient zzch zzc;

    public zzbi(zzbw zzbwVar, Map map) {
        this.zzb = zzbwVar;
        this.zza = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map map = this.zza;
        zzbw zzbwVar = this.zzb;
        if (map != zzbwVar.zza) {
            zzbh zzbhVar = new zzbh(this);
            while (zzbhVar.hasNext()) {
                zzbhVar.next();
                zzbhVar.remove();
            }
            return;
        }
        zzci zzciVar = zzbwVar.zza;
        Iterator it = zzciVar.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        zzciVar.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.zza;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzbg zzbgVar = this.zza$1;
        if (zzbgVar != null) {
            return zzbgVar;
        }
        zzbg zzbgVar2 = new zzbg(this);
        this.zza$1 = zzbgVar2;
        return zzbgVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Map map = this.zza;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        zzbw zzbwVar = this.zzb;
        zzbwVar.getClass();
        List list = (List) collection;
        return list instanceof RandomAccess ? new zzbm(zzbwVar, obj, list, null) : new zzbq(zzbwVar, obj, list, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.zzb.zzw();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        this.zzb.getClass();
        ArrayList arrayList = new ArrayList(3);
        arrayList.addAll(collection);
        collection.size();
        collection.clear();
        return arrayList;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.zza.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        zzch zzchVar = this.zzc;
        if (zzchVar != null) {
            return zzchVar;
        }
        zzch zzchVar2 = new zzch(this);
        this.zzc = zzchVar2;
        return zzchVar2;
    }
}
