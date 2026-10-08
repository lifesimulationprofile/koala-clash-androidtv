package com.github.kr328.clash.design.compose.theme;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppColors {
    public final long accentBorder;
    public final long accentFill;
    public final long appBackground;
    public final long buttonActiveEnd;
    public final long buttonActiveStart;
    public final long buttonColor;
    public final long buttonInactiveBorder;
    public final long buttonInactiveEnd;
    public final long buttonInactiveStart;
    public final long cardBackground;
    public final long cardBorder;
    public final long destructive;
    public final long networkTcp;
    public final long networkUdp;
    public final long statusActive;
    public final long statusClosed;
    public final long textPrimary;
    public final long textSecondary;

    public AppColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        this.appBackground = j;
        this.cardBackground = j2;
        this.cardBorder = j3;
        this.accentBorder = j4;
        this.accentFill = j5;
        this.buttonActiveStart = j6;
        this.buttonActiveEnd = j7;
        this.buttonInactiveStart = j8;
        this.buttonInactiveEnd = j9;
        this.buttonInactiveBorder = j10;
        this.buttonColor = j11;
        this.textPrimary = j12;
        this.textSecondary = j13;
        this.statusActive = j14;
        this.statusClosed = j15;
        this.networkTcp = j16;
        this.networkUdp = j17;
        this.destructive = j18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppColors)) {
            return false;
        }
        AppColors appColors = (AppColors) obj;
        return Color.m435equalsimpl0(this.appBackground, appColors.appBackground) && Color.m435equalsimpl0(this.cardBackground, appColors.cardBackground) && Color.m435equalsimpl0(this.cardBorder, appColors.cardBorder) && Color.m435equalsimpl0(this.accentBorder, appColors.accentBorder) && Color.m435equalsimpl0(this.accentFill, appColors.accentFill) && Color.m435equalsimpl0(this.buttonActiveStart, appColors.buttonActiveStart) && Color.m435equalsimpl0(this.buttonActiveEnd, appColors.buttonActiveEnd) && Color.m435equalsimpl0(this.buttonInactiveStart, appColors.buttonInactiveStart) && Color.m435equalsimpl0(this.buttonInactiveEnd, appColors.buttonInactiveEnd) && Color.m435equalsimpl0(this.buttonInactiveBorder, appColors.buttonInactiveBorder) && Color.m435equalsimpl0(this.buttonColor, appColors.buttonColor) && Color.m435equalsimpl0(this.textPrimary, appColors.textPrimary) && Color.m435equalsimpl0(this.textSecondary, appColors.textSecondary) && Color.m435equalsimpl0(this.statusActive, appColors.statusActive) && Color.m435equalsimpl0(this.statusClosed, appColors.statusClosed) && Color.m435equalsimpl0(this.networkTcp, appColors.networkTcp) && Color.m435equalsimpl0(this.networkUdp, appColors.networkUdp) && Color.m435equalsimpl0(this.destructive, appColors.destructive);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m831hashCodeimpl(this.destructive) + ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ULong.m831hashCodeimpl(this.appBackground) * 31, 31, this.cardBackground), 31, this.cardBorder), 31, this.accentBorder), 31, this.accentFill), 31, this.buttonActiveStart), 31, this.buttonActiveEnd), 31, this.buttonInactiveStart), 31, this.buttonInactiveEnd), 31, this.buttonInactiveBorder), 31, this.buttonColor), 31, this.textPrimary), 31, this.textSecondary), 31, this.statusActive), 31, this.statusClosed), 31, this.networkTcp), 31, this.networkUdp);
    }

    public final String toString() {
        String strM441toStringimpl = Color.m441toStringimpl(this.appBackground);
        String strM441toStringimpl2 = Color.m441toStringimpl(this.cardBackground);
        String strM441toStringimpl3 = Color.m441toStringimpl(this.cardBorder);
        String strM441toStringimpl4 = Color.m441toStringimpl(this.accentBorder);
        String strM441toStringimpl5 = Color.m441toStringimpl(this.accentFill);
        String strM441toStringimpl6 = Color.m441toStringimpl(this.buttonActiveStart);
        String strM441toStringimpl7 = Color.m441toStringimpl(this.buttonActiveEnd);
        String strM441toStringimpl8 = Color.m441toStringimpl(this.buttonInactiveStart);
        String strM441toStringimpl9 = Color.m441toStringimpl(this.buttonInactiveEnd);
        String strM441toStringimpl10 = Color.m441toStringimpl(this.buttonInactiveBorder);
        String strM441toStringimpl11 = Color.m441toStringimpl(this.buttonColor);
        String strM441toStringimpl12 = Color.m441toStringimpl(this.textPrimary);
        String strM441toStringimpl13 = Color.m441toStringimpl(this.textSecondary);
        String strM441toStringimpl14 = Color.m441toStringimpl(this.statusActive);
        String strM441toStringimpl15 = Color.m441toStringimpl(this.statusClosed);
        String strM441toStringimpl16 = Color.m441toStringimpl(this.networkTcp);
        String strM441toStringimpl17 = Color.m441toStringimpl(this.networkUdp);
        String strM441toStringimpl18 = Color.m441toStringimpl(this.destructive);
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("AppColors(appBackground=", strM441toStringimpl, ", cardBackground=", strM441toStringimpl2, ", cardBorder=");
        Density.CC.m(sbM, strM441toStringimpl3, ", accentBorder=", strM441toStringimpl4, ", accentFill=");
        Density.CC.m(sbM, strM441toStringimpl5, ", buttonActiveStart=", strM441toStringimpl6, ", buttonActiveEnd=");
        Density.CC.m(sbM, strM441toStringimpl7, ", buttonInactiveStart=", strM441toStringimpl8, ", buttonInactiveEnd=");
        Density.CC.m(sbM, strM441toStringimpl9, ", buttonInactiveBorder=", strM441toStringimpl10, ", buttonColor=");
        Density.CC.m(sbM, strM441toStringimpl11, ", textPrimary=", strM441toStringimpl12, ", textSecondary=");
        Density.CC.m(sbM, strM441toStringimpl13, ", statusActive=", strM441toStringimpl14, ", statusClosed=");
        Density.CC.m(sbM, strM441toStringimpl15, ", networkTcp=", strM441toStringimpl16, ", networkUdp=");
        sbM.append(strM441toStringimpl17);
        sbM.append(", destructive=");
        sbM.append(strM441toStringimpl18);
        sbM.append(")");
        return sbM.toString();
    }
}
