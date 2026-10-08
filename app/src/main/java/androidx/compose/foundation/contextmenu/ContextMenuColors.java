package androidx.compose.foundation.contextmenu;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContextMenuColors {
    public final long backgroundColor;
    public final long disabledIconColor;
    public final long disabledTextColor;
    public final long iconColor;
    public final long textColor;

    public ContextMenuColors(long j, long j2, long j3, long j4, long j5) {
        this.backgroundColor = j;
        this.textColor = j2;
        this.iconColor = j3;
        this.disabledTextColor = j4;
        this.disabledIconColor = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContextMenuColors)) {
            return false;
        }
        ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
        return Color.m435equalsimpl0(this.backgroundColor, contextMenuColors.backgroundColor) && Color.m435equalsimpl0(this.textColor, contextMenuColors.textColor) && Color.m435equalsimpl0(this.iconColor, contextMenuColors.iconColor) && Color.m435equalsimpl0(this.disabledTextColor, contextMenuColors.disabledTextColor) && Color.m435equalsimpl0(this.disabledIconColor, contextMenuColors.disabledIconColor);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m831hashCodeimpl(this.disabledIconColor) + ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ULong.m831hashCodeimpl(this.backgroundColor) * 31, 31, this.textColor), 31, this.iconColor), 31, this.disabledTextColor);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ContextMenuColors(backgroundColor=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.backgroundColor, sb, ", textColor=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.textColor, sb, ", iconColor=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.iconColor, sb, ", disabledTextColor=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.disabledTextColor, sb, ", disabledIconColor=");
        sb.append((Object) Color.m441toStringimpl(this.disabledIconColor));
        sb.append(')');
        return sb.toString();
    }
}
