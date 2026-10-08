package dev.chrisbanes.haze;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HazeTint {
    public final int blendMode;
    public final Brush brush;
    public final long color;
    public static final HazeTint Unspecified = new HazeTint(Color.Unspecified, 3, null);
    public static final int DefaultBlendMode = 3;

    public HazeTint(long j, int i, Brush brush) {
        this.color = j;
        this.blendMode = i;
        this.brush = brush;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HazeTint)) {
            return false;
        }
        HazeTint hazeTint = (HazeTint) obj;
        return Color.m435equalsimpl0(this.color, hazeTint.color) && this.blendMode == hazeTint.blendMode && Intrinsics.areEqual(this.brush, hazeTint.brush);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        int iM831hashCodeimpl = ((ULong.m831hashCodeimpl(this.color) * 31) + this.blendMode) * 31;
        Brush brush = this.brush;
        return iM831hashCodeimpl + (brush == null ? 0 : brush.hashCode());
    }

    public final boolean isSpecified() {
        return (this.color == 16 && this.brush == null) ? false : true;
    }

    public final String toString() {
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("HazeTint(color=", Color.m441toStringimpl(this.color), ", blendMode=", BrushKt.m429toStringimpl(this.blendMode), ", brush=");
        sbM.append(this.brush);
        sbM.append(")");
        return sbM.toString();
    }

    public HazeTint(long j) {
        this(j, DefaultBlendMode, null);
    }
}
