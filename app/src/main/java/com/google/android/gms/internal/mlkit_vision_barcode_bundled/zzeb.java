package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzeb implements Cloneable, zzfn {
    public zzeh zza;
    public final zzeh zzb;

    public zzeb(zzeh zzehVar) {
        this.zzb = zzehVar;
        if (zzehVar.zzY()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (zzeh) zzehVar.zzg(4, null);
    }

    public final Object clone() {
        zzeb zzebVar = (zzeb) this.zzb.zzg(5, null);
        zzebVar.zza = zzi();
        return zzebVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    public final boolean zzad() {
        return zzeh.zzX(this.zza, false);
    }

    public final zzeh zzh() {
        zzeh zzehVarZzi = zzi();
        if (zzeh.zzX(zzehVarZzi, true)) {
            return zzehVarZzi;
        }
        throw new zzgr();
    }

    public zzeh zzi() {
        if (!this.zza.zzY()) {
            return this.zza;
        }
        zzeh zzehVar = this.zza;
        zzehVar.getClass();
        zzfu.zzb.zzb(zzehVar.getClass()).zzf(zzehVar);
        zzehVar.zzU();
        return this.zza;
    }

    public /* bridge */ zzcq zzk() {
        return zzi();
    }

    public final void zzm() {
        if (this.zza.zzY()) {
            return;
        }
        zzn();
    }

    public void zzn() {
        zzeh zzehVar = (zzeh) this.zzb.zzg(4, null);
        zzfu.zzb.zzb(zzehVar.getClass()).zzg(zzehVar, this.zza);
        this.zza = zzehVar;
    }
}
