package androidx.compose.ui.graphics;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Offset;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Shadow {
    public static final Shadow None = new Shadow(BrushKt.Color(4278190080L), 0, 0.0f);
    public final float blurRadius;
    public final long color;
    public final long offset;

    public Shadow(long j, long j2, float f) {
        this.color = j;
        this.offset = j2;
        this.blurRadius = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        return Color.m435equalsimpl0(this.color, shadow.color) && Offset.m369equalsimpl0(this.offset, shadow.offset) && this.blurRadius == shadow.blurRadius;
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return Float.floatToIntBits(this.blurRadius) + ((Offset.m371hashCodeimpl(this.offset) + (ULong.m831hashCodeimpl(this.color) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Shadow(color=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.color, sb, ", offset=");
        sb.append((Object) Offset.m375toStringimpl(this.offset));
        sb.append(", blurRadius=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.blurRadius, ')');
    }
}
