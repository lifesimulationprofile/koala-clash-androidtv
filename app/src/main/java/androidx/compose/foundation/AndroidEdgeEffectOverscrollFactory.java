package androidx.compose.foundation;

import android.content.Context;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollFactory {
    public final Context context;
    public final Density density;
    public final long glowColor;
    public final PaddingValues glowDrawPadding;

    public AndroidEdgeEffectOverscrollFactory(Context context, Density density, long j, PaddingValues paddingValues) {
        this.context = context;
        this.density = density;
        this.glowColor = j;
        this.glowDrawPadding = paddingValues;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AndroidEdgeEffectOverscrollFactory.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        AndroidEdgeEffectOverscrollFactory androidEdgeEffectOverscrollFactory = (AndroidEdgeEffectOverscrollFactory) obj;
        return Intrinsics.areEqual(this.context, androidEdgeEffectOverscrollFactory.context) && Intrinsics.areEqual(this.density, androidEdgeEffectOverscrollFactory.density) && Color.m435equalsimpl0(this.glowColor, androidEdgeEffectOverscrollFactory.glowColor) && Intrinsics.areEqual(this.glowDrawPadding, androidEdgeEffectOverscrollFactory.glowDrawPadding);
    }

    public final int hashCode() {
        int iHashCode = (this.density.hashCode() + (this.context.hashCode() * 31)) * 31;
        int i = Color.$r8$clinit;
        return this.glowDrawPadding.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(iHashCode, 31, this.glowColor);
    }
}
