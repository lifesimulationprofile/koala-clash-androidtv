package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CheckboxColors {
    public final long checkedBorderColor;
    public final long checkedBoxColor;
    public final long checkedCheckmarkColor;
    public final long disabledBorderColor;
    public final long disabledCheckedBoxColor;
    public final long disabledCheckmarkColor;
    public final long disabledIndeterminateBorderColor;
    public final long disabledIndeterminateBoxColor;
    public final long disabledUncheckedBorderColor;
    public final long disabledUncheckedBoxColor;
    public final long uncheckedBorderColor;
    public final long uncheckedBoxColor;
    public final long uncheckedCheckmarkColor;

    public CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        this.checkedCheckmarkColor = j;
        this.uncheckedCheckmarkColor = j2;
        this.checkedBoxColor = j3;
        this.uncheckedBoxColor = j4;
        this.disabledCheckedBoxColor = j5;
        this.disabledUncheckedBoxColor = j6;
        this.disabledIndeterminateBoxColor = j7;
        this.checkedBorderColor = j8;
        this.uncheckedBorderColor = j9;
        this.disabledBorderColor = j10;
        this.disabledUncheckedBorderColor = j11;
        this.disabledIndeterminateBorderColor = j12;
        this.disabledCheckmarkColor = j13;
    }

    public static FiniteAnimationSpec colorAnimationSpecForState(ToggleableState toggleableState, GapComposer gapComposer) {
        if (toggleableState == ToggleableState.Off) {
            gapComposer.startReplaceGroup(1539238463);
            FiniteAnimationSpec finiteAnimationSpecValue = ScrimKt.value(5, gapComposer);
            gapComposer.end(false);
            return finiteAnimationSpecValue;
        }
        gapComposer.startReplaceGroup(1539331773);
        FiniteAnimationSpec finiteAnimationSpecValue2 = ScrimKt.value(4, gapComposer);
        gapComposer.end(false);
        return finiteAnimationSpecValue2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) obj;
        return Color.m435equalsimpl0(this.checkedCheckmarkColor, checkboxColors.checkedCheckmarkColor) && Color.m435equalsimpl0(this.uncheckedCheckmarkColor, checkboxColors.uncheckedCheckmarkColor) && Color.m435equalsimpl0(this.disabledCheckmarkColor, checkboxColors.disabledCheckmarkColor) && Color.m435equalsimpl0(this.checkedBoxColor, checkboxColors.checkedBoxColor) && Color.m435equalsimpl0(this.uncheckedBoxColor, checkboxColors.uncheckedBoxColor) && Color.m435equalsimpl0(this.disabledCheckedBoxColor, checkboxColors.disabledCheckedBoxColor) && Color.m435equalsimpl0(this.disabledUncheckedBoxColor, checkboxColors.disabledUncheckedBoxColor) && Color.m435equalsimpl0(this.disabledIndeterminateBoxColor, checkboxColors.disabledIndeterminateBoxColor) && Color.m435equalsimpl0(this.checkedBorderColor, checkboxColors.checkedBorderColor) && Color.m435equalsimpl0(this.uncheckedBorderColor, checkboxColors.uncheckedBorderColor) && Color.m435equalsimpl0(this.disabledBorderColor, checkboxColors.disabledBorderColor) && Color.m435equalsimpl0(this.disabledUncheckedBorderColor, checkboxColors.disabledUncheckedBorderColor) && Color.m435equalsimpl0(this.disabledIndeterminateBorderColor, checkboxColors.disabledIndeterminateBorderColor);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m831hashCodeimpl(this.disabledIndeterminateBorderColor) + ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ULong.m831hashCodeimpl(this.checkedCheckmarkColor) * 31, 31, this.uncheckedCheckmarkColor), 31, this.disabledCheckmarkColor), 31, this.checkedBoxColor), 31, this.uncheckedBoxColor), 31, this.disabledCheckedBoxColor), 31, this.disabledUncheckedBoxColor), 31, this.disabledIndeterminateBoxColor), 31, this.checkedBorderColor), 31, this.uncheckedBorderColor), 31, this.disabledBorderColor), 31, this.disabledUncheckedBorderColor);
    }
}
