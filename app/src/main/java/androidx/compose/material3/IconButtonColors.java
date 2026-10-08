package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IconButtonColors {
    public final long containerColor;
    public final long contentColor;
    public final long disabledContainerColor;
    public final long disabledContentColor;

    public IconButtonColors(long j, long j2, long j3, long j4) {
        this.containerColor = j;
        this.contentColor = j2;
        this.disabledContainerColor = j3;
        this.disabledContentColor = j4;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final IconButtonColors m246copyjRlVdoo(long j, long j2, long j3, long j4) {
        if (j == 16) {
            j = this.containerColor;
        }
        return new IconButtonColors(j, j2 != 16 ? j2 : this.contentColor, j3 != 16 ? j3 : this.disabledContainerColor, j4 != 16 ? j4 : this.disabledContentColor);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IconButtonColors)) {
            return false;
        }
        IconButtonColors iconButtonColors = (IconButtonColors) obj;
        return Color.m435equalsimpl0(this.containerColor, iconButtonColors.containerColor) && Color.m435equalsimpl0(this.contentColor, iconButtonColors.contentColor) && Color.m435equalsimpl0(this.disabledContainerColor, iconButtonColors.disabledContainerColor) && Color.m435equalsimpl0(this.disabledContentColor, iconButtonColors.disabledContentColor);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m831hashCodeimpl(this.disabledContentColor) + ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ULong.m831hashCodeimpl(this.containerColor) * 31, 31, this.contentColor), 31, this.disabledContainerColor);
    }
}
