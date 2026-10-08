package com.github.kr328.clash.common.constants;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.github.kr328.clash.common.util.GlobalKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Authorities {
    public static final String FILES_PROVIDER;
    public static final String SETTINGS_PROVIDER;
    public static final String STATUS_PROVIDER;

    static {
        String str = GlobalKt.packageName;
        STATUS_PROVIDER = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".status");
        SETTINGS_PROVIDER = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".settings");
        FILES_PROVIDER = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".files");
    }
}
