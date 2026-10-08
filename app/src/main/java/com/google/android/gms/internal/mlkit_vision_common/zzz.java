package com.google.android.gms.internal.mlkit_vision_common;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzz implements Map, Serializable {
    public final /* synthetic */ int $r8$classId;
    public transient AbstractCollection zza;
    public final transient Object[] zzb;
    public transient AbstractCollection zzb$1;
    public transient AbstractCollection zzc;

    public /* synthetic */ zzz(int i, Object[] objArr) {
        this.$r8$classId = i;
        this.zzb = objArr;
    }

    @Override // java.util.Map
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return get(obj) != null;
            default:
                return get(obj) != null;
        }
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                zzy zzyVar = (zzy) this.zzc;
                if (zzyVar == null) {
                    zzyVar = new zzy(1, this.zzb);
                    this.zzc = zzyVar;
                }
                return zzyVar.contains(obj);
            default:
                com.google.android.gms.internal.mlkit_vision_barcode.zzdo zzdoVar = (com.google.android.gms.internal.mlkit_vision_barcode.zzdo) this.zzc;
                if (zzdoVar == null) {
                    zzdoVar = new com.google.android.gms.internal.mlkit_vision_barcode.zzdo(1, this.zzb);
                    this.zzc = zzdoVar;
                }
                return zzdoVar.contains(obj);
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        switch (this.$r8$classId) {
            case 0:
                zzw zzwVar = (zzw) this.zza;
                if (zzwVar != null) {
                    return zzwVar;
                }
                zzw zzwVar2 = new zzw(this, this.zzb);
                this.zza = zzwVar2;
                return zzwVar2;
            default:
                com.google.android.gms.internal.mlkit_vision_barcode.zzdm zzdmVar = (com.google.android.gms.internal.mlkit_vision_barcode.zzdm) this.zza;
                if (zzdmVar != null) {
                    return zzdmVar;
                }
                com.google.android.gms.internal.mlkit_vision_barcode.zzdm zzdmVar2 = new com.google.android.gms.internal.mlkit_vision_barcode.zzdm(this, this.zzb);
                this.zza = zzdmVar2;
                return zzdmVar2;
        }
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Map) {
                    return entrySet().equals(((Map) obj).entrySet());
                }
                return false;
            default:
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Map) {
                    return entrySet().equals(((Map) obj).entrySet());
                }
                return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0026  */
    /* JADX WARN: Code duplicated, block: B:6:0x0008  */
    @Override // java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Object obj3;
        switch (this.$r8$classId) {
            case 0:
                if (obj == null) {
                    obj2 = null;
                } else {
                    Object[] objArr = this.zzb;
                    Object obj4 = objArr[0];
                    obj4.getClass();
                    if (obj4.equals(obj)) {
                        obj2 = objArr[1];
                        obj2.getClass();
                    } else {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    return null;
                }
                return obj2;
            default:
                if (obj == null) {
                    obj3 = null;
                } else {
                    Object[] objArr2 = this.zzb;
                    Object obj5 = objArr2[0];
                    Objects.requireNonNull(obj5);
                    if (obj5.equals(obj)) {
                        obj3 = objArr2[1];
                        Objects.requireNonNull(obj3);
                    } else {
                        obj3 = null;
                    }
                }
                if (obj3 == null) {
                    return null;
                }
                return obj3;
        }
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Object obj3 = get(obj);
                return obj3 != null ? obj3 : obj2;
            default:
                Object obj4 = get(obj);
                return obj4 != null ? obj4 : obj2;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        switch (this.$r8$classId) {
            case 0:
                zzw zzwVar = (zzw) this.zza;
                if (zzwVar == null) {
                    zzwVar = new zzw(this, this.zzb);
                    this.zza = zzwVar;
                }
                Iterator it = zzwVar.iterator();
                int iHashCode = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    iHashCode += next != null ? next.hashCode() : 0;
                }
                return iHashCode;
            default:
                com.google.android.gms.internal.mlkit_vision_barcode.zzdm zzdmVar = (com.google.android.gms.internal.mlkit_vision_barcode.zzdm) this.zza;
                if (zzdmVar == null) {
                    zzdmVar = new com.google.android.gms.internal.mlkit_vision_barcode.zzdm(this, this.zzb);
                    this.zza = zzdmVar;
                }
                return zzld.zza(zzdmVar);
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        switch (this.$r8$classId) {
        }
        return false;
    }

    @Override // java.util.Map
    public final Set keySet() {
        switch (this.$r8$classId) {
            case 0:
                zzx zzxVar = (zzx) this.zzb$1;
                if (zzxVar != null) {
                    return zzxVar;
                }
                zzx zzxVar2 = new zzx(this, new zzy(0, this.zzb));
                this.zzb$1 = zzxVar2;
                return zzxVar2;
            default:
                com.google.android.gms.internal.mlkit_vision_barcode.zzdn zzdnVar = (com.google.android.gms.internal.mlkit_vision_barcode.zzdn) this.zzb$1;
                if (zzdnVar != null) {
                    return zzdnVar;
                }
                com.google.android.gms.internal.mlkit_vision_barcode.zzdn zzdnVar2 = new com.google.android.gms.internal.mlkit_vision_barcode.zzdn(this, new com.google.android.gms.internal.mlkit_vision_barcode.zzdo(0, this.zzb));
                this.zzb$1 = zzdnVar2;
                return zzdnVar2;
        }
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final int size() {
        switch (this.$r8$classId) {
        }
        return 1;
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                boolean z = true;
                StringBuilder sb = new StringBuilder((int) Math.min(((long) 1) * 8, 1073741824L));
                sb.append('{');
                for (Map.Entry entry : (zzw) entrySet()) {
                    if (!z) {
                        sb.append(", ");
                    }
                    sb.append(entry.getKey());
                    sb.append('=');
                    sb.append(entry.getValue());
                    z = false;
                }
                sb.append('}');
                return sb.toString();
            default:
                boolean z2 = true;
                StringBuilder sb2 = new StringBuilder((int) Math.min(((long) 1) * 8, 1073741824L));
                sb2.append('{');
                for (Map.Entry entry2 : (com.google.android.gms.internal.mlkit_vision_barcode.zzdm) entrySet()) {
                    if (!z2) {
                        sb2.append(", ");
                    }
                    sb2.append(entry2.getKey());
                    sb2.append('=');
                    sb2.append(entry2.getValue());
                    z2 = false;
                }
                sb2.append('}');
                return sb2.toString();
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        switch (this.$r8$classId) {
            case 0:
                zzy zzyVar = (zzy) this.zzc;
                if (zzyVar != null) {
                    return zzyVar;
                }
                zzy zzyVar2 = new zzy(1, this.zzb);
                this.zzc = zzyVar2;
                return zzyVar2;
            default:
                com.google.android.gms.internal.mlkit_vision_barcode.zzdo zzdoVar = (com.google.android.gms.internal.mlkit_vision_barcode.zzdo) this.zzc;
                if (zzdoVar != null) {
                    return zzdoVar;
                }
                com.google.android.gms.internal.mlkit_vision_barcode.zzdo zzdoVar2 = new com.google.android.gms.internal.mlkit_vision_barcode.zzdo(1, this.zzb);
                this.zzc = zzdoVar2;
                return zzdoVar2;
        }
    }
}
