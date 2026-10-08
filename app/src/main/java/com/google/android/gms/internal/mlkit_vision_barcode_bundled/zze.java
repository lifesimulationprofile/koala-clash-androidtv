package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zze extends zzeb implements zzfn {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zze(int i, zzeh zzehVar) {
        super(zzehVar);
        this.$r8$classId = i;
    }

    public zzed zza() {
        if (!((zzed) this.zza).zzY()) {
            return (zzed) this.zza;
        }
        ((zzed) this.zza).zzb.zzg();
        return (zzed) super.zzi();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb
    public /* bridge */ /* synthetic */ zzeh zzi() {
        switch (this.$r8$classId) {
            case 1:
                return zza();
            default:
                return super.zzi();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb
    public /* bridge */ /* synthetic */ zzcq zzk() {
        switch (this.$r8$classId) {
            case 1:
                return zza();
            default:
                return super.zzk();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb
    public void zzn() {
        switch (this.$r8$classId) {
            case 1:
                super.zzn();
                zzeh zzehVar = this.zza;
                if (((zzed) zzehVar).zzb != zzdx.zzb) {
                    zzed zzedVar = (zzed) zzehVar;
                    zzedVar.zzb = zzedVar.zzb.clone();
                }
                break;
            default:
                super.zzn();
                break;
        }
    }
}
