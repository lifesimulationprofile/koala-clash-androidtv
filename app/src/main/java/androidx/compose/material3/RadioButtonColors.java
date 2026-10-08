package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RadioButtonColors {
    public final long disabledSelectedColor;
    public final long disabledUnselectedColor;
    public final long selectedColor;
    public final long unselectedColor;

    public RadioButtonColors(long j, long j2, long j3, long j4) {
        this.selectedColor = j;
        this.unselectedColor = j2;
        this.disabledSelectedColor = j3;
        this.disabledUnselectedColor = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RadioButtonColors)) {
            return false;
        }
        RadioButtonColors radioButtonColors = (RadioButtonColors) obj;
        return Color.m435equalsimpl0(this.selectedColor, radioButtonColors.selectedColor) && Color.m435equalsimpl0(this.unselectedColor, radioButtonColors.unselectedColor) && Color.m435equalsimpl0(this.disabledSelectedColor, radioButtonColors.disabledSelectedColor) && Color.m435equalsimpl0(this.disabledUnselectedColor, radioButtonColors.disabledUnselectedColor);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m831hashCodeimpl(this.disabledUnselectedColor) + ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ULong.m831hashCodeimpl(this.selectedColor) * 31, 31, this.unselectedColor), 31, this.disabledSelectedColor);
    }
}
