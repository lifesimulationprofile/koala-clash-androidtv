package com.google.mlkit.vision.common;

import android.graphics.Bitmap;
import android.media.Image;
import com.google.android.gms.common.internal.zzah;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InputImage {
    public volatile Bitmap zza;
    public volatile Headers.Builder zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;

    public InputImage(Bitmap bitmap) {
        zzah.checkNotNull(bitmap);
        this.zza = bitmap;
        this.zzd = bitmap.getWidth();
        this.zze = bitmap.getHeight();
        zza(0);
        this.zzf = 0;
        this.zzg = -1;
    }

    public static void zza(int i) {
        boolean z = true;
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            z = false;
        }
        zzah.checkArgument("Invalid rotation. Only 0, 90, 180, 270 are supported currently.", z);
    }

    public final Image.Plane[] getPlanes() {
        if (this.zzc == null) {
            return null;
        }
        return ((Image) this.zzc.namesAndValues).getPlanes();
    }

    public InputImage(Image image, int i, int i2, int i3) {
        this.zzc = new Headers.Builder(15, image);
        this.zzd = i;
        this.zze = i2;
        zza(i3);
        this.zzf = i3;
        this.zzg = 35;
    }
}
