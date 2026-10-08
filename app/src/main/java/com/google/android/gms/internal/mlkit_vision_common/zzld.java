package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_barcode.zzbg;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzld {
    public static int zza(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static boolean zzc(zzbg zzbgVar, Collection collection) {
        collection.getClass();
        if (collection instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzdi) {
            collection = ((com.google.android.gms.internal.mlkit_vision_barcode.zzdi) collection).zza();
        }
        boolean zRemove = false;
        if (!(collection instanceof Set) || collection.size() <= zzbgVar.size()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                zRemove |= zzbgVar.remove(it.next());
            }
            return zRemove;
        }
        Iterator<E> it2 = zzbgVar.iterator();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                zRemove = true;
            }
        }
        return zRemove;
    }
}
