package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;
import java.util.Arrays;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new FragmentState.AnonymousClass1(18);
    public final int zzb;
    public final String zzc;
    public final PendingIntent zzd;
    public final ConnectionResult zze;

    public Status(int i, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = i;
        this.zzc = str;
        this.zzd = pendingIntent;
        this.zze = connectionResult;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzb == status.zzb && zzah.equal(this.zzc, status.zzc) && zzah.equal(this.zzd, status.zzd) && zzah.equal(this.zze, status.zze);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze});
    }

    public final String toString() {
        CacheStrategy cacheStrategy = new CacheStrategy(this);
        String strM = this.zzc;
        if (strM == null) {
            int i = this.zzb;
            switch (i) {
                case -1:
                    strM = "SUCCESS_CACHE";
                    break;
                case 0:
                    strM = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strM = ImageAnalysis$$ExternalSyntheticLambda1.m("unknown status code: ", i);
                    break;
                case 2:
                    strM = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strM = "SERVICE_DISABLED";
                    break;
                case 4:
                    strM = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strM = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strM = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strM = "NETWORK_ERROR";
                    break;
                case 8:
                    strM = "INTERNAL_ERROR";
                    break;
                case 10:
                    strM = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strM = "ERROR";
                    break;
                case 14:
                    strM = "INTERRUPTED";
                    break;
                case 15:
                    strM = "TIMEOUT";
                    break;
                case 16:
                    strM = "CANCELED";
                    break;
                case 17:
                    strM = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strM = "DEAD_CLIENT";
                    break;
                case 19:
                    strM = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strM = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strM = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strM = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        cacheStrategy.add(strM, "statusCode");
        cacheStrategy.add(this.zzd, "resolution");
        return cacheStrategy.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zzb);
        zzkp.writeString(parcel, 2, this.zzc);
        zzkp.writeParcelable(parcel, 3, this.zzd, i);
        zzkp.writeParcelable(parcel, 4, this.zze, i);
        zzkp.zzb(parcel, iZza);
    }
}
