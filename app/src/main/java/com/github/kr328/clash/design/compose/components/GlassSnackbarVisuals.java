package com.github.kr328.clash.design.compose.components;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GlassSnackbarVisuals {
    public final int duration;
    public final String message;
    public final int type;
    public final boolean withDismissAction;

    public GlassSnackbarVisuals(int i, int i2, String str, boolean z) {
        this.message = str;
        this.type = i;
        this.withDismissAction = z;
        this.duration = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassSnackbarVisuals)) {
            return false;
        }
        GlassSnackbarVisuals glassSnackbarVisuals = (GlassSnackbarVisuals) obj;
        return Intrinsics.areEqual(this.message, glassSnackbarVisuals.message) && this.type == glassSnackbarVisuals.type && this.withDismissAction == glassSnackbarVisuals.withDismissAction && this.duration == glassSnackbarVisuals.duration;
    }

    public final int hashCode() {
        return CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.duration) + ((ImageAnalysis$$ExternalSyntheticLambda1.m(this.type, this.message.hashCode() * 31, 961) + (this.withDismissAction ? 1231 : 1237)) * 31);
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("GlassSnackbarVisuals(message=", this.message, ", type=");
        int i = this.type;
        if (i == 1) {
            str = "Success";
        } else if (i == 2) {
            str = "Error";
        } else if (i != 3) {
            str = i != 4 ? "null" : "Info";
        } else {
            str = "Warning";
        }
        sbM16m.append(str);
        sbM16m.append(", actionLabel=null, withDismissAction=");
        sbM16m.append(this.withDismissAction);
        sbM16m.append(", duration=");
        int i2 = this.duration;
        if (i2 == 1) {
            str2 = "Short";
        } else if (i2 != 2) {
            str2 = i2 != 3 ? "null" : "Indefinite";
        } else {
            str2 = "Long";
        }
        sbM16m.append(str2);
        sbM16m.append(")");
        return sbM16m.toString();
    }
}
