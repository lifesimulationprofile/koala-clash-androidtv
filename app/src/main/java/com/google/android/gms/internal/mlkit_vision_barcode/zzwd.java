package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzwd {
    public final String zza;
    public final int zzc;

    public zzwd(String str, int i) {
        this.zza = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzwd)) {
            return false;
        }
        zzwd zzwdVar = (zzwd) obj;
        return this.zza.equals(zzwdVar.zza) && this.zzc == zzwdVar.zzc;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ 1231) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MLKitLoggingOptions{libraryName=");
        sb.append(this.zza);
        sb.append(", enableFirelog=true, firelogEventType=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.zzc, "}");
    }
}
