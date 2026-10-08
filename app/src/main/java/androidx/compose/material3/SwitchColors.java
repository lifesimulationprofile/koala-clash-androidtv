package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SwitchColors {
    public final long checkedBorderColor;
    public final long checkedIconColor;
    public final long checkedThumbColor;
    public final long checkedTrackColor;
    public final long disabledCheckedBorderColor;
    public final long disabledCheckedIconColor;
    public final long disabledCheckedThumbColor;
    public final long disabledCheckedTrackColor;
    public final long disabledUncheckedBorderColor;
    public final long disabledUncheckedIconColor;
    public final long disabledUncheckedThumbColor;
    public final long disabledUncheckedTrackColor;
    public final long uncheckedBorderColor;
    public final long uncheckedIconColor;
    public final long uncheckedThumbColor;
    public final long uncheckedTrackColor;

    public SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        this.checkedThumbColor = j;
        this.checkedTrackColor = j2;
        this.checkedBorderColor = j3;
        this.checkedIconColor = j4;
        this.uncheckedThumbColor = j5;
        this.uncheckedTrackColor = j6;
        this.uncheckedBorderColor = j7;
        this.uncheckedIconColor = j8;
        this.disabledCheckedThumbColor = j9;
        this.disabledCheckedTrackColor = j10;
        this.disabledCheckedBorderColor = j11;
        this.disabledCheckedIconColor = j12;
        this.disabledUncheckedThumbColor = j13;
        this.disabledUncheckedTrackColor = j14;
        this.disabledUncheckedBorderColor = j15;
        this.disabledUncheckedIconColor = j16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) obj;
        return Color.m435equalsimpl0(this.checkedThumbColor, switchColors.checkedThumbColor) && Color.m435equalsimpl0(this.checkedTrackColor, switchColors.checkedTrackColor) && Color.m435equalsimpl0(this.checkedBorderColor, switchColors.checkedBorderColor) && Color.m435equalsimpl0(this.checkedIconColor, switchColors.checkedIconColor) && Color.m435equalsimpl0(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Color.m435equalsimpl0(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Color.m435equalsimpl0(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Color.m435equalsimpl0(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Color.m435equalsimpl0(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Color.m435equalsimpl0(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Color.m435equalsimpl0(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Color.m435equalsimpl0(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Color.m435equalsimpl0(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Color.m435equalsimpl0(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Color.m435equalsimpl0(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Color.m435equalsimpl0(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m831hashCodeimpl(this.disabledUncheckedIconColor) + ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ULong.m831hashCodeimpl(this.checkedThumbColor) * 31, 31, this.checkedTrackColor), 31, this.checkedBorderColor), 31, this.checkedIconColor), 31, this.uncheckedThumbColor), 31, this.uncheckedTrackColor), 31, this.uncheckedBorderColor), 31, this.uncheckedIconColor), 31, this.disabledCheckedThumbColor), 31, this.disabledCheckedTrackColor), 31, this.disabledCheckedBorderColor), 31, this.disabledCheckedIconColor), 31, this.disabledUncheckedThumbColor), 31, this.disabledUncheckedTrackColor), 31, this.disabledUncheckedBorderColor);
    }
}
