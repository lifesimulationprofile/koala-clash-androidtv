package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.util.SparseArray;
import coil.memory.MemoryCacheService;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzb {
    public static final AtomicReference zza;
    public static final SparseArray zzb;
    public static final SparseArray zzc;
    public static final HashMap zzd;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        SparseArray sparseArray2 = new SparseArray();
        zzc = sparseArray2;
        zza = new AtomicReference();
        sparseArray.put(-1, zzrn.zza);
        sparseArray.put(1, zzrn.zzb);
        sparseArray.put(2, zzrn.zzc);
        sparseArray.put(4, zzrn.zzd);
        sparseArray.put(8, zzrn.zze);
        sparseArray.put(16, zzrn.zzf);
        sparseArray.put(32, zzrn.zzg);
        sparseArray.put(64, zzrn.zzh);
        sparseArray.put(128, zzrn.zzi);
        sparseArray.put(256, zzrn.zzj);
        sparseArray.put(512, zzrn.zzk);
        sparseArray.put(1024, zzrn.zzl);
        sparseArray.put(2048, zzrn.zzm);
        sparseArray.put(4096, zzrn.zzn);
        sparseArray2.put(0, zzro.zza);
        sparseArray2.put(1, zzro.zzb);
        sparseArray2.put(2, zzro.zzc);
        sparseArray2.put(3, zzro.zzd);
        sparseArray2.put(4, zzro.zze);
        sparseArray2.put(5, zzro.zzf);
        sparseArray2.put(6, zzro.zzg);
        sparseArray2.put(7, zzro.zzh);
        sparseArray2.put(8, zzro.zzi);
        sparseArray2.put(9, zzro.zzj);
        sparseArray2.put(10, zzro.zzk);
        sparseArray2.put(11, zzro.zzl);
        sparseArray2.put(12, zzro.zzm);
        HashMap map = new HashMap();
        zzd = map;
        map.put(1, zzvw.zzb);
        map.put(2, zzvw.zzc);
        map.put(4, zzvw.zzd);
        map.put(8, zzvw.zze);
        map.put(16, zzvw.zzf);
        map.put(32, zzvw.zzg);
        map.put(64, zzvw.zzh);
        map.put(128, zzvw.zzi);
        map.put(256, zzvw.zzj);
        map.put(512, zzvw.zzk);
        map.put(1024, zzvw.zzl);
        map.put(2048, zzvw.zzm);
        map.put(4096, zzvw.zzn);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0036  */
    /* JADX WARN: Code duplicated, block: B:13:0x0040 A[LOOP:0: B:11:0x003a->B:13:0x0040, LOOP_END] */
    public static zzvz zzc(BarcodeScannerOptions barcodeScannerOptions) {
        Iterator it;
        int i = barcodeScannerOptions.zza;
        zzcp zzcpVar = new zzcp();
        HashMap map = zzd;
        if (i == 0) {
            Collection collectionValues = map.values();
            if (collectionValues instanceof Collection) {
                Collection collection = collectionValues;
                zzcpVar.zzd(collection.size() + zzcpVar.zzb);
                if (collection instanceof zzcn) {
                    zzcpVar.zzb = ((zzcn) collection).zza(zzcpVar.zzb, (Object[]) zzcpVar.zza);
                } else {
                    it = collectionValues.iterator();
                    while (it.hasNext()) {
                        zzcpVar.zza$com$google$android$gms$internal$mlkit_vision_barcode$zzcl(it.next());
                    }
                }
            } else {
                it = collectionValues.iterator();
                while (it.hasNext()) {
                    zzcpVar.zza$com$google$android$gms$internal$mlkit_vision_barcode$zzcl(it.next());
                }
            }
        } else {
            for (Map.Entry entry : map.entrySet()) {
                if ((((Integer) entry.getKey()).intValue() & i) != 0) {
                    zzcpVar.zza$com$google$android$gms$internal$mlkit_vision_barcode$zzcl((zzvw) entry.getValue());
                }
            }
        }
        MemoryCacheService memoryCacheService = new MemoryCacheService(29, false);
        memoryCacheService.imageLoader = zzcpVar.zzf();
        return new zzvz(memoryCacheService);
    }

    public static void zze(zzwp zzwpVar, zzrb zzrbVar) {
        zza zzaVar = new zza();
        zzaVar.zza = zzrbVar;
        zzwpVar.zzf(zzaVar, zzrc.zzm);
    }

    public static boolean zzf() {
        AtomicReference atomicReference = zza;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        Context applicationContext = MlKitContext.getInstance().getApplicationContext();
        zzdk zzdkVar = zzo.zza;
        boolean z = DynamiteModule.getLocalVersion(applicationContext, ModuleDescriptor.MODULE_ID) > 0;
        atomicReference.set(Boolean.valueOf(z));
        return z;
    }
}
