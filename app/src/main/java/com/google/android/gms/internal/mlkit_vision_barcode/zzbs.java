package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbs implements Map.Entry {
    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (com.google.android.gms.internal.mlkit_vision_common.zzkv.zza(getKey(), entry.getKey()) && com.google.android.gms.internal.mlkit_vision_common.zzkv.zza(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(String.valueOf(getKey()), "=", String.valueOf(getValue()));
    }
}
