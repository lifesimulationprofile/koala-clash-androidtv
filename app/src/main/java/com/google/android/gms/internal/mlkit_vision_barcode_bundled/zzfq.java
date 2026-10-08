package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.compose.ui.unit.Density;
import com.google.android.gms.internal.mlkit_vision_common.zzle;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.FileSystemException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzfq implements zzge {
    public final zzcq zza;
    public final zzea zzb;
    public final boolean zzc;

    public zzfq(zzea zzeaVar, zzcq zzcqVar) {
        zzea zzeaVar2 = zzdv.zza;
        this.zzb = zzeaVar;
        this.zzc = zzcqVar instanceof zzed;
        this.zza = zzcqVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(zzcq zzcqVar) {
        zzgt zzgtVar = ((zzeh) zzcqVar).zzc;
        int iM = zzgtVar.zze;
        if (iM == -1) {
            iM = 0;
            for (int i = 0; i < zzgtVar.zzb; i++) {
                int i2 = zzgtVar.zzc[i] >>> 3;
                zzdf zzdfVar = (zzdf) zzgtVar.zzd[i];
                int iZzA = zzdk.zzA(8);
                int iZzA2 = zzdk.zzA(i2) + zzdk.zzA(16);
                int iZzA3 = zzdk.zzA(24);
                int iZzd = zzdfVar.zzd();
                iM += iZzA + iZzA + iZzA2 + Density.CC.m(iZzd, iZzd, iZzA3);
            }
            zzgtVar.zze = iM;
        }
        if (!this.zzc) {
            return iM;
        }
        zzgh zzghVar = ((zzed) zzcqVar).zzb.zza;
        int i3 = zzghVar.zzb;
        int iZzo = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iZzo += zzdx.zzo(zzghVar.zzg(i4));
        }
        Iterator it = zzghVar.zzd().iterator();
        while (it.hasNext()) {
            iZzo += zzdx.zzo((Map.Entry) it.next());
        }
        return iM + iZzo;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(zzeh zzehVar) {
        int iHashCode = zzehVar.zzc.hashCode();
        if (!this.zzc) {
            return iHashCode;
        }
        return ((zzed) zzehVar).zzb.zza.hashCode() + (iHashCode * 53);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        zzcq zzcqVar = this.zza;
        return zzcqVar instanceof zzeh ? (zzeh) ((zzeh) zzcqVar).zzg(4, null) : ((zzeb) ((zzeh) zzcqVar).zzg(5, null)).zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        this.zzb.getClass();
        zzgt zzgtVar = ((zzeh) obj).zzc;
        if (zzgtVar.zzf) {
            zzgtVar.zzf = false;
        }
        zzea zzeaVar = zzdv.zza;
        ((zzed) obj).zzb.zzg();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzgg.zzp(obj, obj2);
        if (this.zzc) {
            zzea zzeaVar = zzdv.zza;
            zzgg.zzo(obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0093  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzcu zzcuVar) throws zzer {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVarZzf = zzehVar.zzc;
        if (zzgtVarZzf == zzgt.zza) {
            zzgtVarZzf = zzgt.zzf();
            zzehVar.zzc = zzgtVarZzf;
        }
        zzgt zzgtVar = zzgtVarZzf;
        zzed zzedVar = (zzed) obj;
        zzdx zzdxVar = zzedVar.zzb;
        if (zzdxVar.zzc) {
            zzedVar.zzb = zzdxVar.clone();
        }
        while (i < i2) {
            int iZzj = zzle.zzj(bArr, i, zzcuVar);
            int i3 = zzcuVar.zza;
            zzds zzdsVar = zzcuVar.zzd;
            zzcq zzcqVar = this.zza;
            if (i3 == 11) {
                int i4 = i2;
                zzcu zzcuVar2 = zzcuVar;
                int i5 = 0;
                zzdf zzdfVar = null;
                while (true) {
                    if (iZzj >= i4) {
                        i = iZzj;
                        break;
                    }
                    int iZzj2 = zzle.zzj(bArr, iZzj, zzcuVar2);
                    int i6 = zzcuVar2.zza;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 == 2) {
                        if (i8 != 0) {
                            if (i6 != 12) {
                                i = iZzj2;
                                break;
                            }
                            iZzj = zzle.zzp(i6, bArr, iZzj2, i4, zzcuVar2);
                        } else {
                            iZzj = zzle.zzj(bArr, iZzj2, zzcuVar2);
                            i5 = zzcuVar2.zza;
                            zzdsVar.getClass();
                        }
                    } else if (i7 != 3 || i8 != 2) {
                        if (i6 != 12) {
                            i = iZzj2;
                            break;
                        }
                        iZzj = zzle.zzp(i6, bArr, iZzj2, i4, zzcuVar2);
                    } else {
                        iZzj = zzle.zza(bArr, iZzj2, zzcuVar2);
                        zzdfVar = (zzdf) zzcuVar2.zzc;
                    }
                }
                if (zzdfVar != null) {
                    zzgtVar.zzj((i5 << 3) | 2, zzdfVar);
                }
                i2 = i4;
                zzcuVar = zzcuVar2;
            } else if ((i3 & 7) == 2) {
                zzdsVar.getClass();
                i = zzle.zzi(i3, bArr, iZzj, i2, zzgtVar, zzcuVar);
            } else {
                i = zzle.zzp(i3, bArr, iZzj, i2, zzcuVar);
            }
        }
        if (i != i2) {
            throw new zzer("Failed to parse the message.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzfe zzfeVar) throws FileSystemException {
        Iterator itZzf = ((zzed) obj).zzb.zzf();
        if (itZzf.hasNext()) {
            ((zzee) ((Map.Entry) itZzf.next()).getKey()).getClass();
            throw null;
        }
        zzgt zzgtVar = ((zzeh) obj).zzc;
        for (int i = 0; i < zzgtVar.zzb; i++) {
            int i2 = zzgtVar.zzc[i] >>> 3;
            Object obj2 = zzgtVar.zzd[i];
            zzdk zzdkVar = (zzdk) zzfeVar.zzb;
            if (obj2 instanceof zzdf) {
                zzdkVar.zzt(11);
                zzdkVar.zzs(2, i2);
                zzdkVar.zze(3, (zzdf) obj2);
                zzdkVar.zzt(12);
            } else {
                zzdkVar.zzt(11);
                zzdkVar.zzs(2, i2);
                zzdkVar.zzt(26);
                zzeh zzehVar = (zzeh) ((zzcq) obj2);
                zzdkVar.zzt(zzehVar.zzF());
                zzehVar.zzab(zzdkVar);
                zzdkVar.zzt(12);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(zzeh zzehVar, zzeh zzehVar2) {
        if (!zzehVar.zzc.equals(zzehVar2.zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzed) zzehVar).zzb.equals(((zzed) zzehVar2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        return ((zzed) obj).zzb.zzk();
    }
}
