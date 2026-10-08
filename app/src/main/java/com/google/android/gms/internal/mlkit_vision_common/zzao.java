package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzao implements ValueEncoderContext {
    public final /* synthetic */ int $r8$classId;
    public boolean zza = false;
    public boolean zzb = false;
    public FieldDescriptor zzc;
    public final ObjectEncoderContext zzd;

    public /* synthetic */ zzao(ObjectEncoderContext objectEncoderContext, int i) {
        this.$r8$classId = i;
        this.zzd = objectEncoderContext;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) {
        switch (this.$r8$classId) {
            case 0:
                if (this.zza) {
                    throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
                }
                this.zza = true;
                ((zzak) this.zzd).zzc(this.zzc, str, this.zzb);
                return this;
            default:
                if (this.zza) {
                    throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
                }
                this.zza = true;
                ((com.google.android.gms.internal.mlkit_vision_barcode.zzfg) this.zzd).zzc(this.zzc, str, this.zzb);
                return this;
        }
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) {
        switch (this.$r8$classId) {
            case 0:
                if (!this.zza) {
                    this.zza = true;
                    ((zzak) this.zzd).zzd$1(this.zzc, z ? 1 : 0, this.zzb);
                    return this;
                }
                throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
            default:
                if (!this.zza) {
                    this.zza = true;
                    ((com.google.android.gms.internal.mlkit_vision_barcode.zzfg) this.zzd).zzd(this.zzc, z ? 1 : 0, this.zzb);
                    return this;
                }
                throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
    }
}
