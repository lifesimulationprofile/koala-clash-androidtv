package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BlendModeColorFilter {
    public final int blendMode;
    public final long color;
    public final ColorFilter nativeColorFilter;

    public BlendModeColorFilter(int i, long j) {
        ColorFilter porterDuffColorFilter;
        if (Build.VERSION.SDK_INT >= 29) {
            CanvasZHelper$$ExternalSyntheticApiModelOutline0.m432m();
            porterDuffColorFilter = CanvasZHelper$$ExternalSyntheticApiModelOutline0.m(BrushKt.m426toArgb8_81llA(j), BrushKt.m424toAndroidBlendModes9anfk8(i));
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(BrushKt.m426toArgb8_81llA(j), BrushKt.m428toPorterDuffModes9anfk8(i));
        }
        this.nativeColorFilter = porterDuffColorFilter;
        this.color = j;
        this.blendMode = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlendModeColorFilter)) {
            return false;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj;
        return Color.m435equalsimpl0(this.color, blendModeColorFilter.color) && this.blendMode == blendModeColorFilter.blendMode;
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return (ULong.m831hashCodeimpl(this.color) * 31) + this.blendMode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BlendModeColorFilter(color=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.color, sb, ", blendMode=");
        sb.append((Object) BrushKt.m429toStringimpl(this.blendMode));
        sb.append(')');
        return sb.toString();
    }
}
