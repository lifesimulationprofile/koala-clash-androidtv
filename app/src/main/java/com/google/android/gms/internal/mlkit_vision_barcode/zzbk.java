package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgd;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzbk implements Iterator {
    public final /* synthetic */ int $r8$classId = 0;
    public Object zza;
    public Object zzb;

    public zzbk(zzbg zzbgVar, Iterator it) {
        this.zzb = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.$r8$classId) {
            case 0:
                return ((Iterator) this.zzb).hasNext();
            default:
                return ((zzde) this.zzb) != null;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                Map.Entry entry = (Map.Entry) ((Iterator) this.zzb).next();
                this.zza = entry;
                return entry.getKey();
            default:
                return zza();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                com.google.android.gms.internal.mlkit_vision_common.zzkw.zzf("no calls to next() since the last call to remove()", ((Map.Entry) this.zza) != null);
                Collection collection = (Collection) ((Map.Entry) this.zza).getValue();
                ((Iterator) this.zzb).remove();
                collection.size();
                collection.clear();
                this.zza = null;
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public zzde zza() {
        zzde zzdeVar;
        ArrayDeque arrayDeque = (ArrayDeque) this.zza;
        zzde zzdeVar2 = (zzde) this.zzb;
        if (zzdeVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            zzdeVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzdf zzdfVar = ((zzgd) arrayDeque.pop()).zze;
            while (zzdfVar instanceof zzgd) {
                zzgd zzgdVar = (zzgd) zzdfVar;
                arrayDeque.push(zzgdVar);
                zzdfVar = zzgdVar.zzd;
            }
            zzdeVar = (zzde) zzdfVar;
        } while (zzdeVar.zzd() == 0);
        this.zzb = zzdeVar;
        return zzdeVar2;
    }

    public zzbk(zzdf zzdfVar) {
        if (!(zzdfVar instanceof zzgd)) {
            this.zza = null;
            this.zzb = (zzde) zzdfVar;
            return;
        }
        zzgd zzgdVar = (zzgd) zzdfVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzgdVar.zzg);
        this.zza = arrayDeque;
        arrayDeque.push(zzgdVar);
        zzdf zzdfVar2 = zzgdVar.zzd;
        while (zzdfVar2 instanceof zzgd) {
            zzgd zzgdVar2 = (zzgd) zzdfVar2;
            ((ArrayDeque) this.zza).push(zzgdVar2);
            zzdfVar2 = zzgdVar2.zzd;
        }
        this.zzb = (zzde) zzdfVar2;
    }
}
