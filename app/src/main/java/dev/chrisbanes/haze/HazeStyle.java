package dev.chrisbanes.haze;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import java.util.Collections;
import java.util.List;
import kotlin.ULong;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HazeStyle {
    public static final HazeStyle Unspecified = new HazeStyle(Color.Unspecified, EmptyList.INSTANCE, Float.NaN, -1.0f, HazeTint.Unspecified);
    public final long backgroundColor;
    public final float blurRadius;
    public final HazeTint fallbackTint;
    public final float noiseFactor;
    public final List tints;

    public HazeStyle(long j, List list, float f, float f2, HazeTint hazeTint) {
        this.backgroundColor = j;
        this.tints = list;
        this.blurRadius = f;
        this.noiseFactor = f2;
        this.fallbackTint = hazeTint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HazeStyle)) {
            return false;
        }
        HazeStyle hazeStyle = (HazeStyle) obj;
        return Color.m435equalsimpl0(this.backgroundColor, hazeStyle.backgroundColor) && Intrinsics.areEqual(this.tints, hazeStyle.tints) && Dp.m704equalsimpl0(this.blurRadius, hazeStyle.blurRadius) && Float.compare(this.noiseFactor, hazeStyle.noiseFactor) == 0 && Intrinsics.areEqual(this.fallbackTint, hazeStyle.fallbackTint);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return this.fallbackTint.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.noiseFactor, ImageAnalysis$$ExternalSyntheticLambda1.m(this.blurRadius, (this.tints.hashCode() + (ULong.m831hashCodeimpl(this.backgroundColor) * 31)) * 31, 31), 31);
    }

    public final String toString() {
        return "HazeStyle(backgroundColor=" + Color.m441toStringimpl(this.backgroundColor) + ", tints=" + this.tints + ", blurRadius=" + Dp.m705toStringimpl(this.blurRadius) + ", noiseFactor=" + this.noiseFactor + ", fallbackTint=" + this.fallbackTint + ")";
    }

    public HazeStyle(long j, HazeTint hazeTint, float f, int i) {
        this(j, Collections.singletonList(hazeTint), f, (i & 8) != 0 ? -1.0f : 0.15f, HazeTint.Unspecified);
    }
}
