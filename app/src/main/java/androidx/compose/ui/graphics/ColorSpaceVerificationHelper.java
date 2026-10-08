package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import android.os.Build;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.Rgb$eotf$1;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSpaceVerificationHelper {
    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace colorSpace2;
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Srgb)) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Aces)) {
            return ColorSpace.get(ColorSpace.Named.ACES);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Acescg)) {
            return ColorSpace.get(ColorSpace.Named.ACESCG);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.AdobeRgb)) {
            return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Bt2020)) {
            return ColorSpace.get(ColorSpace.Named.BT2020);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Bt709)) {
            return ColorSpace.get(ColorSpace.Named.BT709);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.CieLab)) {
            return ColorSpace.get(ColorSpace.Named.CIE_LAB);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.CieXyz)) {
            return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.DciP3)) {
            return ColorSpace.get(ColorSpace.Named.DCI_P3);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.DisplayP3)) {
            return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.ExtendedSrgb)) {
            return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.LinearExtendedSrgb)) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.LinearSrgb)) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Ntsc1953)) {
            return ColorSpace.get(ColorSpace.Named.NTSC_1953);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.ProPhotoRgb)) {
            return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.SmpteC)) {
            return ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        if (Build.VERSION.SDK_INT >= 34) {
            if (Intrinsics.areEqual(colorSpace, ColorSpaces.Bt2020Hlg)) {
                colorSpace2 = ColorSpace.get(ColorSpace.Named.BT2020_HLG);
            } else {
                colorSpace2 = Intrinsics.areEqual(colorSpace, ColorSpaces.Bt2020Pq) ? ColorSpace.get(ColorSpace.Named.BT2020_PQ) : null;
            }
            if (colorSpace2 != null) {
                return colorSpace2;
            }
        }
        if (!(colorSpace instanceof Rgb)) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        String str = colorSpace.name;
        Rgb rgb = (Rgb) colorSpace;
        float[] xyz$ui_graphics = rgb.whitePoint.toXyz$ui_graphics();
        TransferParameters transferParameters = rgb.transferParameters;
        ColorSpace.Rgb.TransferParameters transferParameters2 = transferParameters != null ? new ColorSpace.Rgb.TransferParameters(transferParameters.a, transferParameters.b, transferParameters.c, transferParameters.d, transferParameters.e, transferParameters.f, transferParameters.gamma) : null;
        float[] fArr = rgb.transform;
        if (transferParameters2 != null) {
            ColorSpace.Rgb rgb2 = new ColorSpace.Rgb(str, rgb.primaries, xyz$ui_graphics, transferParameters2);
            return (Float.isNaN(fArr[0]) || Arrays.equals(rgb2.getTransform(), fArr)) ? rgb2 : new ColorSpace.Rgb(str, fArr, transferParameters2);
        }
        float[] fArr2 = rgb.primaries;
        final Rgb$eotf$1 rgb$eotf$1 = rgb.oetf;
        final int i = 0;
        DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda0
            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d) {
                switch (i) {
                    case 0:
                        break;
                }
                return ((Number) rgb$eotf$1.invoke(Double.valueOf(d))).doubleValue();
            }
        };
        final Rgb$eotf$1 rgb$eotf$2 = rgb.eotf;
        final int i2 = 1;
        return new ColorSpace.Rgb(str, fArr2, xyz$ui_graphics, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda0
            @Override // java.util.function.DoubleUnaryOperator
            public final double applyAsDouble(double d) {
                switch (i2) {
                    case 0:
                        break;
                }
                return ((Number) rgb$eotf$2.invoke(Double.valueOf(d))).doubleValue();
            }
        }, rgb.min, rgb.max);
    }
}
