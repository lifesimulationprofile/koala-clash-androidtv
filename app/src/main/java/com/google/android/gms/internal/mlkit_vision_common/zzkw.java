package com.google.android.gms.internal.mlkit_vision_common;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkw {
    public static void zza(int i, int i2) {
        String strZzb;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strZzb = zzkx.zzb("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("negative size: ", i2));
                }
                strZzb = zzkx.zzb("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strZzb);
        }
    }

    public static void zze(int i, int i2, int i3) {
        String strZzg;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZzg = zzg(i, i3, "start index");
            } else {
                strZzg = (i2 < 0 || i2 > i3) ? zzg(i2, i3, "end index") : zzkx.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZzg);
        }
    }

    public static void zzf(String str, boolean z) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static String zzg(int i, int i2, String str) {
        if (i < 0) {
            return zzkx.zzb("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzkx.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("negative size: ", i2));
    }
}
