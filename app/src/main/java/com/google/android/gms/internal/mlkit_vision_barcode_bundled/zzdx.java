package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.collection.ArrayMap;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzdx {
    public static final zzdx zzb = new zzdx(0);
    public final zzgh zza = new zzgh();
    public boolean zzc;

    public zzdx() {
    }

    public static int zza(zzee zzeeVar, Object obj) {
        zzeeVar.getClass();
        zzdk.zzA(0 << 3);
        if (zzhf.zzj == null) {
            Charset charset = zzep.zza;
        }
        zzhg zzhgVar = zzhg.zza;
        throw null;
    }

    public static boolean zzn(Map.Entry entry) {
        ((zzee) entry.getKey()).getClass();
        throw null;
    }

    public static final int zzo(Map.Entry entry) {
        zzee zzeeVar = (zzee) entry.getKey();
        entry.getValue();
        zzeeVar.getClass();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdx) {
            return this.zza.equals(((zzdx) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzdx clone() {
        zzdx zzdxVar = new zzdx();
        zzgh zzghVar = this.zza;
        int i = zzghVar.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            zzgi zzgiVarZzg = zzghVar.zzg(i2);
            zzdxVar.zzi((zzee) zzgiVarZzg.zzb, zzgiVarZzg.zzc);
        }
        for (Map.Entry entry : zzghVar.zzd()) {
            zzdxVar.zzi((zzee) entry.getKey(), entry.getValue());
        }
        return zzdxVar;
    }

    public final Iterator zzf() {
        zzgh zzghVar = this.zza;
        return zzghVar.isEmpty() ? Collections.emptyIterator() : ((ArrayMap.EntrySet) zzghVar.entrySet()).iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzgh zzghVar = this.zza;
        int i = zzghVar.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = zzghVar.zzg(i2).zzc;
            if (obj instanceof zzeh) {
                zzeh zzehVar = (zzeh) obj;
                zzehVar.getClass();
                zzfu.zzb.zzb(zzehVar.getClass()).zzf(zzehVar);
                zzehVar.zzU();
            }
        }
        if (!zzghVar.zzd) {
            for (int i3 = 0; i3 < zzghVar.zzb; i3++) {
                ((zzee) zzghVar.zzg(i3).zzb).getClass();
            }
            Iterator it = zzghVar.zzd().iterator();
            while (it.hasNext()) {
                ((zzee) ((Map.Entry) it.next()).getKey()).getClass();
            }
        }
        if (!zzghVar.zzd) {
            zzghVar.zzc = zzghVar.zzc.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(zzghVar.zzc);
            zzghVar.zzf = zzghVar.zzf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(zzghVar.zzf);
            zzghVar.zzd = true;
        }
        this.zzc = true;
    }

    public final void zzi(zzee zzeeVar, Object obj) {
        zzeeVar.getClass();
        Charset charset = zzep.zza;
        obj.getClass();
        zzhf zzhfVar = zzhf.zzj;
        zzhg zzhgVar = zzhg.zza;
        throw null;
    }

    public final boolean zzk() {
        zzgh zzghVar = this.zza;
        int i = zzghVar.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzn(zzghVar.zzg(i2))) {
                return false;
            }
        }
        Iterator it = zzghVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzn((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void zzm(Map.Entry entry) {
        zzee zzeeVar = (zzee) entry.getKey();
        entry.getValue();
        zzeeVar.getClass();
        throw null;
    }

    public zzdx(int i) {
        zzg();
        zzg();
    }
}
