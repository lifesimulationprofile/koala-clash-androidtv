package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zar extends com.google.android.gms.internal.base.zab implements zae {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TaskCompletionSource zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zar(TaskCompletionSource taskCompletionSource, int i) {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks", 0);
        this.$r8$classId = i;
        this.zaa = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            Status status = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleAvailabilityResponse.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            zae(status, moduleAvailabilityResponse);
            return true;
        }
        if (i == 2) {
            Status status2 = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleInstallResponse.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            zad(status2, moduleInstallResponse);
            return true;
        }
        if (i == 3) {
            com.google.android.gms.internal.base.zac.zab(parcel);
            throw new UnsupportedOperationException();
        }
        if (i != 4) {
            return false;
        }
        com.google.android.gms.internal.base.zac.zab(parcel);
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zae
    public void zad(Status status, ModuleInstallResponse moduleInstallResponse) {
        switch (this.$r8$classId) {
            case 1:
                TaskUtil.trySetResultOrApiException(status, moduleInstallResponse, this.zaa);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zae
    public void zae(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse) {
        switch (this.$r8$classId) {
            case 0:
                TaskUtil.trySetResultOrApiException(status, moduleAvailabilityResponse, this.zaa);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
