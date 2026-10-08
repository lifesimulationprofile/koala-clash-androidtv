package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class zzlx implements Closeable {
    public static final HashMap zza = new HashMap();
    public int zzc;
    public long zze;
    public long zzf;
    public long zzg = 2147483647L;
    public long zzh = -2147483648L;

    public zzlx(String str) {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.zze;
        if (j == 0) {
            throw new IllegalStateException("Did you forget to call start()?");
        }
        zzd(j);
    }

    public void zzb() {
        this.zze = SystemClock.elapsedRealtimeNanos() / 1000;
    }

    public void zzc(long j) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j2 = this.zzf;
        if (j2 != 0 && jElapsedRealtimeNanos - j2 >= 1000000) {
            this.zzc = 0;
            this.zze = 0L;
            this.zzg = 2147483647L;
            this.zzh = -2147483648L;
        }
        this.zzf = jElapsedRealtimeNanos;
        this.zzc++;
        this.zzg = Math.min(this.zzg, j);
        this.zzh = Math.max(this.zzh, j);
        if (this.zzc % 50 == 0) {
            Locale locale = Locale.US;
            zzmw.zza();
        }
        if (this.zzc % 500 == 0) {
            this.zzc = 0;
            this.zze = 0L;
            this.zzg = 2147483647L;
            this.zzh = -2147483648L;
        }
    }

    public void zzd(long j) {
        zzc((SystemClock.elapsedRealtimeNanos() / 1000) - j);
    }
}
