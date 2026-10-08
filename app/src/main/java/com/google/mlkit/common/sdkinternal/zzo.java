package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.OptionalModuleApi;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzo implements OptionalModuleApi {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Feature[] zza;

    public /* synthetic */ zzo(Feature[] featureArr, int i) {
        this.$r8$classId = i;
        this.zza = featureArr;
    }

    @Override // com.google.android.gms.common.api.OptionalModuleApi
    public final Feature[] getOptionalFeatures() {
        int i = this.$r8$classId;
        Feature[] featureArr = this.zza;
        switch (i) {
            case 0:
                Feature[] featureArr2 = OptionalModuleUtils.EMPTY_FEATURES;
                break;
            default:
                Feature[] featureArr3 = OptionalModuleUtils.EMPTY_FEATURES;
                break;
        }
        return featureArr;
    }
}
