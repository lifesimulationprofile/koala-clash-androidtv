package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzci extends AbstractMap implements Serializable {
    public static final Object zzd = new Object();
    public transient int[] zza;
    public transient Object[] zzb;
    public transient Object[] zzc;
    public transient Object zze;
    public transient int zzf = Math.min(Math.max(12, 1), 1073741823);
    public transient int zzg;
    public transient zzcc zzh;
    public transient zzcc zzi;
    public transient zzch zzj;

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzr()) {
            return;
        }
        this.zzf += 32;
        Map mapZzl = zzl();
        if (mapZzl != null) {
            this.zzf = Math.min(Math.max(size(), 3), 1073741823);
            mapZzl.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzB(), 0, this.zzg, (Object) null);
        Arrays.fill(zzC(), 0, this.zzg, (Object) null);
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(zzA(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.containsKey(obj);
        }
        return zzw(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (com.google.android.gms.internal.mlkit_vision_common.zzkv.zza(obj, zzC()[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzcc zzccVar = this.zzi;
        if (zzccVar != null) {
            return zzccVar;
        }
        zzcc zzccVar2 = new zzcc(this, 0);
        this.zzi = zzccVar2;
        return zzccVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.get(obj);
        }
        int iZzw = zzw(obj);
        if (iZzw == -1) {
            return null;
        }
        return zzC()[iZzw];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzcc zzccVar = this.zzh;
        if (zzccVar != null) {
            return zzccVar;
        }
        zzcc zzccVar2 = new zzcc(this, 1);
        this.zzh = zzccVar2;
        return zzccVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i;
        int i2 = 32;
        if (zzr()) {
            com.google.android.gms.internal.mlkit_vision_common.zzkw.zzf("Arrays already allocated", zzr());
            int i3 = this.zzf;
            int iMax = Math.max(i3 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzd(iMax2);
            this.zzf = ((32 - Integer.numberOfLeadingZeros(iMax2 - 1)) & 31) | (this.zzf & (-32));
            this.zza = new int[i3];
            this.zzb = new Object[i3];
            this.zzc = new Object[i3];
        }
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.put(obj, obj2);
        }
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int i4 = this.zzg;
        int i5 = i4 + 1;
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzlc.zza(obj);
        int iZzv = zzv();
        int i6 = iZza & iZzv;
        Object obj3 = this.zze;
        Objects.requireNonNull(obj3);
        int iZzc = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzc(i6, obj3);
        if (iZzc == 0) {
            if (i5 > iZzv) {
                iZzv = zzx(iZzv, (iZzv + 1) * (iZzv < 32 ? 4 : 2), iZza, i4);
            } else {
                Object obj4 = this.zze;
                Objects.requireNonNull(obj4);
                com.google.android.gms.internal.mlkit_vision_common.zzlb.zze(i6, i5, obj4);
            }
            i = 1;
        } else {
            int i7 = ~iZzv;
            int i8 = iZza & i7;
            int i9 = 0;
            while (true) {
                int i10 = iZzc - 1;
                int i11 = iArrZzA[i10];
                i = 1;
                int i12 = i11 & i7;
                int i13 = i2;
                if (i12 == i8 && com.google.android.gms.internal.mlkit_vision_common.zzkv.zza(obj, objArrZzB[i10])) {
                    Object obj5 = objArrZzC[i10];
                    objArrZzC[i10] = obj2;
                    return obj5;
                }
                int i14 = i11 & iZzv;
                int i15 = i9 + 1;
                if (i14 == 0) {
                    if (i15 < 9) {
                        if (i5 <= iZzv) {
                            iArrZzA[i10] = (i5 & iZzv) | i12;
                            break;
                        }
                        iZzv = zzx(iZzv, (iZzv + 1) * (iZzv < i13 ? 4 : 2), iZza, i4);
                        break;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                    int i16 = isEmpty() ? -1 : 0;
                    while (i16 >= 0) {
                        linkedHashMap.put(zzB()[i16], zzC()[i16]);
                        int i17 = i16 + 1;
                        i16 = i17 < this.zzg ? i17 : -1;
                    }
                    this.zze = linkedHashMap;
                    this.zza = null;
                    this.zzb = null;
                    this.zzc = null;
                    this.zzf += 32;
                    return linkedHashMap.put(obj, obj2);
                }
                i9 = i15;
                iZzc = i14;
                i2 = i13;
            }
        }
        int length = zzA().length;
        if (i5 > length) {
            int i18 = i;
            int iMin = Math.min(1073741823, (Math.max(i18, length >>> 1) + length) | i18);
            if (iMin != length) {
                this.zza = Arrays.copyOf(zzA(), iMin);
                this.zzb = Arrays.copyOf(zzB(), iMin);
                this.zzc = Arrays.copyOf(zzC(), iMin);
            }
        }
        zzA()[i4] = (~iZzv) & iZza;
        zzB()[i4] = obj;
        zzC()[i4] = obj2;
        this.zzg = i5;
        this.zzf += 32;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.remove(obj);
        }
        Object objZzy = zzy(obj);
        if (objZzy == zzd) {
            return null;
        }
        return objZzy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzl = zzl();
        return mapZzl != null ? mapZzl.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        zzch zzchVar = this.zzj;
        if (zzchVar != null) {
            return zzchVar;
        }
        zzch zzchVar2 = new zzch(this);
        this.zzj = zzchVar2;
        return zzchVar2;
    }

    public final int[] zzA() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] zzB() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object[] zzC() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzq(int i, int i2) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrZzB[i] = null;
            objArrZzC[i] = null;
            iArrZzA[i] = 0;
            return;
        }
        int i4 = i + 1;
        Object obj2 = objArrZzB[i3];
        objArrZzB[i] = obj2;
        objArrZzC[i] = objArrZzC[i3];
        objArrZzB[i3] = null;
        objArrZzC[i3] = null;
        iArrZzA[i] = iArrZzA[i3];
        iArrZzA[i3] = 0;
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzlc.zza(obj2) & i2;
        int iZzc = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzc(iZza, obj);
        if (iZzc == size) {
            com.google.android.gms.internal.mlkit_vision_common.zzlb.zze(iZza, i4, obj);
            return;
        }
        while (true) {
            int i5 = iZzc - 1;
            int i6 = iArrZzA[i5];
            int i7 = i6 & i2;
            if (i7 == size) {
                iArrZzA[i5] = (i6 & (~i2)) | (i2 & i4);
                return;
            }
            iZzc = i7;
        }
    }

    public final boolean zzr() {
        return this.zze == null;
    }

    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    public final int zzw(Object obj) {
        if (zzr()) {
            return -1;
        }
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzlc.zza(obj);
        int iZzv = zzv();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int iZzc = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzc(iZza & iZzv, obj2);
        if (iZzc != 0) {
            int i = ~iZzv;
            int i2 = iZza & i;
            do {
                int i3 = iZzc - 1;
                int i4 = zzA()[i3];
                if ((i4 & i) == i2 && com.google.android.gms.internal.mlkit_vision_common.zzkv.zza(obj, zzB()[i3])) {
                    return i3;
                }
                iZzc = i4 & iZzv;
            } while (iZzc != 0);
        }
        return -1;
    }

    public final int zzx(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object objZzd = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzd(i2);
        if (i4 != 0) {
            com.google.android.gms.internal.mlkit_vision_common.zzlb.zze(i3 & i5, i4 + 1, objZzd);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        for (int i6 = 0; i6 <= i; i6++) {
            int iZzc = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzc(i6, obj);
            while (iZzc != 0) {
                int i7 = iZzc - 1;
                int i8 = iArrZzA[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iZzc2 = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzc(i10, objZzd);
                com.google.android.gms.internal.mlkit_vision_common.zzlb.zze(i10, iZzc, objZzd);
                iArrZzA[i7] = ((~i5) & i9) | (iZzc2 & i5);
                iZzc = i8 & i;
            }
        }
        this.zze = objZzd;
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i5)) & 31) | (this.zzf & (-32));
        return i5;
    }

    public final Object zzy(Object obj) {
        if (!zzr()) {
            int iZzv = zzv();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int iZzb = com.google.android.gms.internal.mlkit_vision_common.zzlb.zzb(obj, null, iZzv, obj2, zzA(), zzB(), null);
            if (iZzb != -1) {
                Object obj3 = zzC()[iZzb];
                zzq(iZzb, iZzv);
                this.zzg--;
                this.zzf += 32;
                return obj3;
            }
        }
        return zzd;
    }
}
