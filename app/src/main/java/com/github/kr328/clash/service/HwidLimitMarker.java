package com.github.kr328.clash.service;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HwidLimitMarker {
    public final String supportURL;

    public HwidLimitMarker(String str) {
        this.supportURL = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HwidLimitMarker) && Intrinsics.areEqual(this.supportURL, ((HwidLimitMarker) obj).supportURL);
    }

    public final int hashCode() {
        String str = this.supportURL;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m$1("HwidLimitMarker(supportURL=", this.supportURL, ")");
    }
}
