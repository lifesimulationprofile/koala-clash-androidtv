package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzbg extends AbstractSet {
    public final /* synthetic */ int $r8$classId = 0;
    public final Map zza;

    public zzbg(zzbi zzbiVar) {
        this.zza = zzbiVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                ((zzbi) this.zza).clear();
                break;
            default:
                Iterator it = iterator();
                while (true) {
                    zzbk zzbkVar = (zzbk) it;
                    if (zzbkVar.hasNext()) {
                        zzbkVar.next();
                        zzbkVar.remove();
                    }
                    break;
                }
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Set setEntrySet = ((zzbi) this.zza).zza.entrySet();
                setEntrySet.getClass();
                try {
                    return setEntrySet.contains(obj);
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            default:
                return this.zza.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.$r8$classId) {
            case 1:
                return this.zza.keySet().containsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                return this == obj || this.zza.keySet().equals(obj);
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        switch (this.$r8$classId) {
            case 1:
                return this.zza.keySet().hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.$r8$classId) {
            case 0:
                return ((zzbi) this.zza).isEmpty();
            default:
                return this.zza.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new zzbh((zzbi) this.zza);
            default:
                return new zzbk(this, this.zza.entrySet().iterator());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Object objRemove;
        switch (this.$r8$classId) {
            case 0:
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                zzbi zzbiVar = (zzbi) this.zza;
                try {
                    objRemove = zzbiVar.zzb.zza.remove(entry.getKey());
                    break;
                } catch (ClassCastException | NullPointerException unused) {
                    objRemove = null;
                }
                Collection collection = (Collection) objRemove;
                if (collection != null) {
                    collection.size();
                    collection.clear();
                }
                return true;
            default:
                Collection collection2 = (Collection) this.zza.remove(obj);
                if (collection2 != null) {
                    int size = collection2.size();
                    collection2.clear();
                    if (size > 0) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                try {
                    if (collection != null) {
                        return com.google.android.gms.internal.mlkit_vision_common.zzld.zzc(this, collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    Iterator it = collection.iterator();
                    boolean zRemove = false;
                    while (it.hasNext()) {
                        zRemove |= remove(it.next());
                    }
                    return zRemove;
                }
            default:
                return removeAll$com$google$android$gms$internal$mlkit_vision_barcode$zzdr(collection);
        }
    }

    public final boolean removeAll$com$google$android$gms$internal$mlkit_vision_barcode$zzdr(Collection collection) {
        return com.google.android.gms.internal.mlkit_vision_common.zzld.zzc(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        int iCeil;
        switch (this.$r8$classId) {
            case 0:
                try {
                    if (collection != null) {
                        return retainAll$com$google$android$gms$internal$mlkit_vision_barcode$zzdr(collection);
                    }
                    throw null;
                } catch (UnsupportedOperationException unused) {
                    int size = collection.size();
                    if (size >= 3) {
                        iCeil = size < 1073741824 ? (int) Math.ceil(((double) size) / 0.75d) : Integer.MAX_VALUE;
                    } else {
                        if (size < 0) {
                            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("expectedSize cannot be negative but was: ", size));
                        }
                        iCeil = size + 1;
                    }
                    HashSet hashSet = new HashSet(iCeil);
                    for (Object obj : collection) {
                        if (contains(obj) && (obj instanceof Map.Entry)) {
                            hashSet.add(((Map.Entry) obj).getKey());
                        }
                    }
                    return ((zzbg) ((zzbi) this.zza).zzb.zzw()).retainAll(hashSet);
                }
            default:
                return retainAll$com$google$android$gms$internal$mlkit_vision_barcode$zzdr(collection);
        }
    }

    public final boolean retainAll$com$google$android$gms$internal$mlkit_vision_barcode$zzdr(Collection collection) {
        collection.getClass();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.$r8$classId) {
            case 0:
                return ((zzbi) this.zza).zza.size();
            default:
                return this.zza.size();
        }
    }

    public zzbg(zzbw zzbwVar, Map map) {
        this.zza = map;
    }
}
