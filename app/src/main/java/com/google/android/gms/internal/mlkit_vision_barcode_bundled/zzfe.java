package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Arrays;
import kotlin.io.FileSystemException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzfe implements zzfk {
    public static final zzea zza = new zzea(3);
    public final Object zzb;

    public zzfe(zzfk... zzfkVarArr) {
        this.zzb = zzfkVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public zzfw zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzfk zzfkVar = ((zzfk[]) this.zzb)[i];
            if (zzfkVar.zzc(cls)) {
                return zzfkVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((zzfk[]) this.zzb)[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    public void zzq(int i, Object obj, zzge zzgeVar) throws FileSystemException {
        zzdk zzdkVar = (zzdk) this.zzb;
        zzdkVar.zzr(i, 3);
        zzgeVar.zzi((zzcq) obj, zzdkVar.zza);
        zzdkVar.zzr(i, 4);
    }

    public void zzv(int i, Object obj, zzge zzgeVar) throws FileSystemException {
        zzcq zzcqVar = (zzcq) obj;
        zzdk zzdkVar = (zzdk) this.zzb;
        zzdkVar.zzt((i << 3) | 2);
        zzdkVar.zzt(zzcqVar.zzB(zzgeVar));
        zzgeVar.zzi(zzcqVar, zzdkVar.zza);
    }

    public zzfe(int i) {
        switch (i) {
            case 3:
                this.zzb = new ArrayDeque();
                break;
            default:
                zzfu zzfuVar = zzfu.zzb;
                zzfe zzfeVar = new zzfe(zzea.zza, zza);
                Charset charset = zzep.zza;
                this.zzb = zzfeVar;
                break;
        }
    }

    public void zzb(zzdf zzdfVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.zzb;
        if (zzdfVar.zzh()) {
            int iBinarySearch = Arrays.binarySearch(zzgd.zza, zzdfVar.zzd());
            if (iBinarySearch < 0) {
                iBinarySearch = (-(iBinarySearch + 1)) - 1;
            }
            int iZzc = zzgd.zzc(iBinarySearch + 1);
            if (!arrayDeque.isEmpty() && ((zzdf) arrayDeque.peek()).zzd() < iZzc) {
                int iZzc2 = zzgd.zzc(iBinarySearch);
                zzdf zzgdVar = (zzdf) arrayDeque.pop();
                while (!arrayDeque.isEmpty() && ((zzdf) arrayDeque.peek()).zzd() < iZzc2) {
                    zzgdVar = new zzgd((zzdf) arrayDeque.pop(), zzgdVar);
                }
                zzgd zzgdVar2 = new zzgd(zzgdVar, zzdfVar);
                while (!arrayDeque.isEmpty()) {
                    int iBinarySearch2 = Arrays.binarySearch(zzgd.zza, zzgdVar2.zzc);
                    if (iBinarySearch2 < 0) {
                        iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
                    }
                    if (((zzdf) arrayDeque.peek()).zzd() >= zzgd.zzc(iBinarySearch2 + 1)) {
                        break;
                    } else {
                        zzgdVar2 = new zzgd((zzdf) arrayDeque.pop(), zzgdVar2);
                    }
                }
                arrayDeque.push(zzgdVar2);
                return;
            }
            arrayDeque.push(zzdfVar);
            return;
        }
        if (zzdfVar instanceof zzgd) {
            zzgd zzgdVar3 = (zzgd) zzdfVar;
            zzb(zzgdVar3.zzd);
            zzb(zzgdVar3.zze);
            return;
        }
        throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzdfVar.getClass())));
    }

    public zzfe(zzdk zzdkVar) {
        Charset charset = zzep.zza;
        this.zzb = zzdkVar;
        zzdkVar.zza = this;
    }
}
