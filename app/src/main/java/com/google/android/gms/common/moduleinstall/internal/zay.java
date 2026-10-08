package com.google.android.gms.common.moduleinstall.internal;

import coil.memory.MemoryCacheService;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.tasks.zzw;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.util.Arrays;
import okhttp3.internal.cache.CacheStrategy;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zay extends GoogleApi {
    public static final CacheStrategy zae = new CacheStrategy("ModuleInstall.API", new zaa(2), new Path.Companion());

    public final zzw areModulesAvailable(OptionalModuleApi... optionalModuleApiArr) {
        zzah.checkArgument("Please provide at least one OptionalModuleApi.", optionalModuleApiArr.length > 0);
        for (OptionalModuleApi optionalModuleApi : optionalModuleApiArr) {
            zzah.checkNotNull(optionalModuleApi, "Requested API must not be null.");
        }
        ApiFeatureRequest apiFeatureRequestZaa = ApiFeatureRequest.zaa(Arrays.asList(optionalModuleApiArr), false);
        if (apiFeatureRequestZaa.zab.isEmpty()) {
            ModuleAvailabilityResponse moduleAvailabilityResponse = new ModuleAvailabilityResponse(0, true);
            zzw zzwVar = new zzw();
            zzwVar.zzb(moduleAvailabilityResponse);
            return zzwVar;
        }
        MinimalEncoder minimalEncoder = new MinimalEncoder();
        minimalEncoder.encoders = new Feature[]{com.google.android.gms.internal.base.zaf.zaa$1};
        minimalEncoder.ecLevel = 27301;
        minimalEncoder.isGS1 = false;
        minimalEncoder.stringToEncode = new MemoryCacheService(this, apiFeatureRequestZaa);
        return zae(0, minimalEncoder.build());
    }
}
