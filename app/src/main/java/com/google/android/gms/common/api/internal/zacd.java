package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.zzw;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zacd implements OnCompleteListener {
    public final GoogleApiManager zaa;
    public final int zab;
    public final ApiKey zac;
    public final long zad;
    public final long zae;

    public zacd(GoogleApiManager googleApiManager, int i, ApiKey apiKey, long j, long j2) {
        this.zaa = googleApiManager;
        this.zab = i;
        this.zac = apiKey;
        this.zad = j;
        this.zae = j2;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0031 A[RETURN] */
    public static ConnectionTelemetryConfiguration zab(zabq zabqVar, GmsClient gmsClient, int i) {
        zzk zzkVar = gmsClient.zzD;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar == null ? null : zzkVar.zzd;
        if (connectionTelemetryConfiguration != null && connectionTelemetryConfiguration.zzb) {
            int[] iArr = connectionTelemetryConfiguration.zzd;
            int i2 = 0;
            if (iArr == null) {
                int[] iArr2 = connectionTelemetryConfiguration.zzf;
                if (iArr2 != null) {
                    while (i2 < iArr2.length) {
                        if (iArr2[i2] != i) {
                            i2++;
                        }
                    }
                    if (zabqVar.zam < connectionTelemetryConfiguration.zze) {
                        return connectionTelemetryConfiguration;
                    }
                } else if (zabqVar.zam < connectionTelemetryConfiguration.zze) {
                    return connectionTelemetryConfiguration;
                }
            } else {
                while (i2 < iArr.length) {
                    if (iArr[i2] != i) {
                        i2++;
                    } else if (zabqVar.zam < connectionTelemetryConfiguration.zze) {
                        return connectionTelemetryConfiguration;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086 A[PHI: r10
      0x0086: PHI (r10v3 int) = (r10v0 int), (r10v2 int) binds: [B:38:0x0084, B:44:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(zzw zzwVar) {
        int i;
        int i2;
        int i3;
        int i4;
        long j;
        long j2;
        if (this.zaa.zaD()) {
            RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) com.google.android.gms.common.internal.zah.getInstance().zaa;
            if (rootTelemetryConfiguration == null || rootTelemetryConfiguration.zzb) {
                zabq zabqVar = (zabq) this.zaa.zan.get(this.zac);
                if (zabqVar != null) {
                    Api$Client api$Client = zabqVar.zac;
                    if (api$Client instanceof GmsClient) {
                        GmsClient gmsClient = (GmsClient) api$Client;
                        int i5 = 0;
                        boolean z = this.zad > 0;
                        int i6 = gmsClient.zzy;
                        int i7 = 100;
                        if (rootTelemetryConfiguration != null) {
                            z &= rootTelemetryConfiguration.zzc;
                            int i8 = rootTelemetryConfiguration.zzd;
                            int i9 = rootTelemetryConfiguration.zze;
                            i = rootTelemetryConfiguration.zza;
                            if (gmsClient.zzD != null && !gmsClient.isConnecting()) {
                                ConnectionTelemetryConfiguration connectionTelemetryConfigurationZab = zab(zabqVar, gmsClient, this.zab);
                                if (connectionTelemetryConfigurationZab == null) {
                                    return;
                                }
                                boolean z2 = connectionTelemetryConfigurationZab.zzc && this.zad > 0;
                                i9 = connectionTelemetryConfigurationZab.zze;
                                z = z2;
                            }
                            i3 = i8;
                            i2 = i9;
                        } else {
                            i = 0;
                            i2 = 100;
                            i3 = 5000;
                        }
                        GoogleApiManager googleApiManager = this.zaa;
                        int iElapsedRealtime = -1;
                        if (zzwVar.isSuccessful()) {
                            i4 = 0;
                        } else if (zzwVar.zzd) {
                            i4 = i7;
                            i5 = -1;
                        } else {
                            Exception exception = zzwVar.getException();
                            if (exception instanceof ApiException) {
                                Status status = ((ApiException) exception).mStatus;
                                i7 = status.zzb;
                                ConnectionResult connectionResult = status.zze;
                                if (connectionResult == null) {
                                    i4 = i7;
                                    i5 = -1;
                                } else {
                                    i5 = connectionResult.zzb;
                                    i4 = i7;
                                }
                            } else {
                                i4 = 101;
                                i5 = -1;
                            }
                        }
                        if (z) {
                            long j3 = this.zad;
                            long j4 = this.zae;
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j4);
                            j2 = jCurrentTimeMillis;
                            j = j3;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        zace zaceVar = new zace(new MethodInvocation(this.zab, i4, i5, j, j2, null, null, i6, iElapsedRealtime), i, i3, i2);
                        zau zauVar = googleApiManager.zar;
                        zauVar.sendMessage(zauVar.obtainMessage(18, zaceVar));
                    }
                }
            }
        }
    }
}
