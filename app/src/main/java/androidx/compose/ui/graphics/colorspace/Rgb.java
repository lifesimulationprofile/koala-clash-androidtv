package androidx.compose.ui.graphics.colorspace;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.BrushKt;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Rgb extends ColorSpace {
    public static final ZslControlImpl$$ExternalSyntheticLambda0 DoubleIdentity = new ZslControlImpl$$ExternalSyntheticLambda0(15);
    public final Rgb$eotf$1 eotf;
    public final Rgb$$ExternalSyntheticLambda0 eotfFunc;
    public final DoubleFunction eotfOrig;
    public final float[] inverseTransform;
    public final boolean isSrgb;
    public final float max;
    public final float min;
    public final Rgb$eotf$1 oetf;
    public final Rgb$$ExternalSyntheticLambda0 oetfFunc;
    public final DoubleFunction oetfOrig;
    public final float[] primaries;
    public final TransferParameters transferParameters;
    public final float[] transform;
    public final WhitePoint whitePoint;

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final TransferParameters transferParameters, int i) {
        DoubleFunction doubleFunction;
        DoubleFunction doubleFunction2;
        double d = transferParameters.gamma;
        boolean z = d == -3.0d;
        double d2 = transferParameters.f;
        double d3 = transferParameters.e;
        if (z) {
            final int i2 = 4;
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d4) {
                    int i3 = i2;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (i3) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d4);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d4);
                        case 2:
                            double d5 = transferParameters2.a;
                            return d4 >= transferParameters2.d ? Math.pow((d5 * d4) + transferParameters2.b, transferParameters2.gamma) : d4 * transferParameters2.c;
                        case 3:
                            double d6 = transferParameters2.a;
                            double d7 = transferParameters2.b;
                            double d8 = transferParameters2.c;
                            return d4 >= transferParameters2.d ? Math.pow((d6 * d4) + d7, transferParameters2.gamma) + transferParameters2.e : (d8 * d4) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d4);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d4);
                        case 6:
                            double d9 = transferParameters2.a;
                            double d10 = transferParameters2.b;
                            double d11 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d11 ? (Math.pow(d4, 1.0d / transferParameters2.gamma) - d10) / d9 : d4 / d11;
                        default:
                            double d12 = transferParameters2.a;
                            double d13 = transferParameters2.b;
                            double d14 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d14 ? (Math.pow(d4 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d13) / d12 : (d4 - transferParameters2.f) / d14;
                    }
                }
            };
        } else if (d == -2.0d) {
            final int i3 = 5;
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d4) {
                    int i4 = i3;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (i4) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d4);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d4);
                        case 2:
                            double d5 = transferParameters2.a;
                            return d4 >= transferParameters2.d ? Math.pow((d5 * d4) + transferParameters2.b, transferParameters2.gamma) : d4 * transferParameters2.c;
                        case 3:
                            double d6 = transferParameters2.a;
                            double d7 = transferParameters2.b;
                            double d8 = transferParameters2.c;
                            return d4 >= transferParameters2.d ? Math.pow((d6 * d4) + d7, transferParameters2.gamma) + transferParameters2.e : (d8 * d4) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d4);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d4);
                        case 6:
                            double d9 = transferParameters2.a;
                            double d10 = transferParameters2.b;
                            double d11 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d11 ? (Math.pow(d4, 1.0d / transferParameters2.gamma) - d10) / d9 : d4 / d11;
                        default:
                            double d12 = transferParameters2.a;
                            double d13 = transferParameters2.b;
                            double d14 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d14 ? (Math.pow(d4 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d13) / d12 : (d4 - transferParameters2.f) / d14;
                    }
                }
            };
        } else if (d3 == 0.0d && d2 == 0.0d) {
            final int i4 = 6;
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d4) {
                    int i5 = i4;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (i5) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d4);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d4);
                        case 2:
                            double d5 = transferParameters2.a;
                            return d4 >= transferParameters2.d ? Math.pow((d5 * d4) + transferParameters2.b, transferParameters2.gamma) : d4 * transferParameters2.c;
                        case 3:
                            double d6 = transferParameters2.a;
                            double d7 = transferParameters2.b;
                            double d8 = transferParameters2.c;
                            return d4 >= transferParameters2.d ? Math.pow((d6 * d4) + d7, transferParameters2.gamma) + transferParameters2.e : (d8 * d4) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d4);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d4);
                        case 6:
                            double d9 = transferParameters2.a;
                            double d10 = transferParameters2.b;
                            double d11 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d11 ? (Math.pow(d4, 1.0d / transferParameters2.gamma) - d10) / d9 : d4 / d11;
                        default:
                            double d12 = transferParameters2.a;
                            double d13 = transferParameters2.b;
                            double d14 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d14 ? (Math.pow(d4 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d13) / d12 : (d4 - transferParameters2.f) / d14;
                    }
                }
            };
        } else {
            final int i5 = 7;
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d4) {
                    int i6 = i5;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (i6) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d4);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d4);
                        case 2:
                            double d5 = transferParameters2.a;
                            return d4 >= transferParameters2.d ? Math.pow((d5 * d4) + transferParameters2.b, transferParameters2.gamma) : d4 * transferParameters2.c;
                        case 3:
                            double d6 = transferParameters2.a;
                            double d7 = transferParameters2.b;
                            double d8 = transferParameters2.c;
                            return d4 >= transferParameters2.d ? Math.pow((d6 * d4) + d7, transferParameters2.gamma) + transferParameters2.e : (d8 * d4) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d4);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d4);
                        case 6:
                            double d9 = transferParameters2.a;
                            double d10 = transferParameters2.b;
                            double d11 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d11 ? (Math.pow(d4, 1.0d / transferParameters2.gamma) - d10) / d9 : d4 / d11;
                        default:
                            double d12 = transferParameters2.a;
                            double d13 = transferParameters2.b;
                            double d14 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d14 ? (Math.pow(d4 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d13) / d12 : (d4 - transferParameters2.f) / d14;
                    }
                }
            };
        }
        if (d == -3.0d) {
            final int i6 = 0;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d4) {
                    int i7 = i6;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (i7) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d4);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d4);
                        case 2:
                            double d5 = transferParameters2.a;
                            return d4 >= transferParameters2.d ? Math.pow((d5 * d4) + transferParameters2.b, transferParameters2.gamma) : d4 * transferParameters2.c;
                        case 3:
                            double d6 = transferParameters2.a;
                            double d7 = transferParameters2.b;
                            double d8 = transferParameters2.c;
                            return d4 >= transferParameters2.d ? Math.pow((d6 * d4) + d7, transferParameters2.gamma) + transferParameters2.e : (d8 * d4) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d4);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d4);
                        case 6:
                            double d9 = transferParameters2.a;
                            double d10 = transferParameters2.b;
                            double d11 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d11 ? (Math.pow(d4, 1.0d / transferParameters2.gamma) - d10) / d9 : d4 / d11;
                        default:
                            double d12 = transferParameters2.a;
                            double d13 = transferParameters2.b;
                            double d14 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d14 ? (Math.pow(d4 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d13) / d12 : (d4 - transferParameters2.f) / d14;
                    }
                }
            };
        } else if (d == -2.0d) {
            final int i7 = 1;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d4) {
                    int i8 = i7;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (i8) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d4);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d4);
                        case 2:
                            double d5 = transferParameters2.a;
                            return d4 >= transferParameters2.d ? Math.pow((d5 * d4) + transferParameters2.b, transferParameters2.gamma) : d4 * transferParameters2.c;
                        case 3:
                            double d6 = transferParameters2.a;
                            double d7 = transferParameters2.b;
                            double d8 = transferParameters2.c;
                            return d4 >= transferParameters2.d ? Math.pow((d6 * d4) + d7, transferParameters2.gamma) + transferParameters2.e : (d8 * d4) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d4);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d4);
                        case 6:
                            double d9 = transferParameters2.a;
                            double d10 = transferParameters2.b;
                            double d11 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d11 ? (Math.pow(d4, 1.0d / transferParameters2.gamma) - d10) / d9 : d4 / d11;
                        default:
                            double d12 = transferParameters2.a;
                            double d13 = transferParameters2.b;
                            double d14 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d14 ? (Math.pow(d4 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d13) / d12 : (d4 - transferParameters2.f) / d14;
                    }
                }
            };
        } else if (d3 == 0.0d && d2 == 0.0d) {
            final int i8 = 2;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d4) {
                    int i9 = i8;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (i9) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d4);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d4);
                        case 2:
                            double d5 = transferParameters2.a;
                            return d4 >= transferParameters2.d ? Math.pow((d5 * d4) + transferParameters2.b, transferParameters2.gamma) : d4 * transferParameters2.c;
                        case 3:
                            double d6 = transferParameters2.a;
                            double d7 = transferParameters2.b;
                            double d8 = transferParameters2.c;
                            return d4 >= transferParameters2.d ? Math.pow((d6 * d4) + d7, transferParameters2.gamma) + transferParameters2.e : (d8 * d4) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d4);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d4);
                        case 6:
                            double d9 = transferParameters2.a;
                            double d10 = transferParameters2.b;
                            double d11 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d11 ? (Math.pow(d4, 1.0d / transferParameters2.gamma) - d10) / d9 : d4 / d11;
                        default:
                            double d12 = transferParameters2.a;
                            double d13 = transferParameters2.b;
                            double d14 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d14 ? (Math.pow(d4 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d13) / d12 : (d4 - transferParameters2.f) / d14;
                    }
                }
            };
        } else {
            final int i9 = 3;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d4) {
                    int i10 = i9;
                    TransferParameters transferParameters2 = transferParameters;
                    switch (i10) {
                        case 0:
                            float[] fArr2 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgEotf$ui_graphics(transferParameters2, d4);
                        case 1:
                            float[] fArr3 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Eotf$ui_graphics(transferParameters2, d4);
                        case 2:
                            double d5 = transferParameters2.a;
                            return d4 >= transferParameters2.d ? Math.pow((d5 * d4) + transferParameters2.b, transferParameters2.gamma) : d4 * transferParameters2.c;
                        case 3:
                            double d6 = transferParameters2.a;
                            double d7 = transferParameters2.b;
                            double d8 = transferParameters2.c;
                            return d4 >= transferParameters2.d ? Math.pow((d6 * d4) + d7, transferParameters2.gamma) + transferParameters2.e : (d8 * d4) + transferParameters2.f;
                        case 4:
                            float[] fArr4 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferHlgOetf$ui_graphics(transferParameters2, d4);
                        case 5:
                            float[] fArr5 = ColorSpaces.SrgbPrimaries;
                            return ColorSpaces.transferSt2048Oetf$ui_graphics(transferParameters2, d4);
                        case 6:
                            double d9 = transferParameters2.a;
                            double d10 = transferParameters2.b;
                            double d11 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d11 ? (Math.pow(d4, 1.0d / transferParameters2.gamma) - d10) / d9 : d4 / d11;
                        default:
                            double d12 = transferParameters2.a;
                            double d13 = transferParameters2.b;
                            double d14 = transferParameters2.c;
                            return d4 >= transferParameters2.d * d14 ? (Math.pow(d4 - transferParameters2.e, 1.0d / transferParameters2.gamma) - d13) / d12 : (d4 - transferParameters2.f) / d14;
                    }
                }
            };
        }
        this(str, fArr, whitePoint, null, doubleFunction, doubleFunction2, 0.0f, 1.0f, transferParameters, i);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rgb.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        TransferParameters transferParameters = rgb.transferParameters;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual(this.whitePoint, rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            return Intrinsics.areEqual(transferParameters2, transferParameters);
        }
        if (transferParameters == null) {
            return true;
        }
        if (Intrinsics.areEqual(this.oetfOrig, rgb.oetfOrig)) {
            return Intrinsics.areEqual(this.eotfOrig, rgb.eotfOrig);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMaxValue(int i) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMinValue(int i) {
        return this.min;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final int hashCode() {
        int iHashCode = (Arrays.hashCode(this.primaries) + ((this.whitePoint.hashCode() + (super.hashCode() * 31)) * 31)) * 31;
        float f = this.min;
        int iFloatToIntBits = (iHashCode + (f == 0.0f ? 0 : Float.floatToIntBits(f))) * 31;
        float f2 = this.max;
        int iFloatToIntBits2 = (iFloatToIntBits + (f2 == 0.0f ? 0 : Float.floatToIntBits(f2))) * 31;
        TransferParameters transferParameters = this.transferParameters;
        int iHashCode2 = iFloatToIntBits2 + (transferParameters != null ? transferParameters.hashCode() : 0);
        if (transferParameters == null) {
            return this.eotfOrig.hashCode() + ((this.oetfOrig.hashCode() + (iHashCode2 * 31)) * 31);
        }
        return iHashCode2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final boolean isSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final long toXy$ui_graphics(float f, float f2, float f3) {
        double d = f;
        Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda0 = this.eotfFunc;
        float fInvoke = (float) rgb$$ExternalSyntheticLambda0.invoke(d);
        float fInvoke2 = (float) rgb$$ExternalSyntheticLambda0.invoke(f2);
        float fInvoke3 = (float) rgb$$ExternalSyntheticLambda0.invoke(f3);
        float[] fArr = this.transform;
        if (fArr.length < 9) {
            return 0L;
        }
        float f4 = (fArr[6] * fInvoke3) + (fArr[3] * fInvoke2) + (fArr[0] * fInvoke);
        return (((long) Float.floatToRawIntBits((fArr[7] * fInvoke3) + (fArr[4] * fInvoke2) + (fArr[1] * fInvoke))) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float toZ$ui_graphics(float f, float f2, float f3) {
        double d = f;
        Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda0 = this.eotfFunc;
        float fInvoke = (float) rgb$$ExternalSyntheticLambda0.invoke(d);
        float fInvoke2 = (float) rgb$$ExternalSyntheticLambda0.invoke(f2);
        float fInvoke3 = (float) rgb$$ExternalSyntheticLambda0.invoke(f3);
        float[] fArr = this.transform;
        return (fArr[8] * fInvoke3) + (fArr[5] * fInvoke2) + (fArr[2] * fInvoke);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics */
    public final long mo457xyzaToColorJlNiLsg$ui_graphics(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float[] fArr = this.inverseTransform;
        float f5 = (fArr[6] * f3) + (fArr[3] * f2) + (fArr[0] * f);
        float f6 = (fArr[7] * f3) + (fArr[4] * f2) + (fArr[1] * f);
        float f7 = (fArr[8] * f3) + (fArr[5] * f2) + (fArr[2] * f);
        Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda0 = this.oetfFunc;
        return BrushKt.Color((float) rgb$$ExternalSyntheticLambda0.invoke(f5), (float) rgb$$ExternalSyntheticLambda0.invoke(f6), (float) rgb$$ExternalSyntheticLambda0.invoke(f7), f4, colorSpace);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:45:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:47:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:53:0x0214  */
    /* JADX WARN: Code duplicated, block: B:56:0x021d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0231  */
    /* JADX WARN: Code duplicated, block: B:65:0x0249  */
    /* JADX WARN: Code duplicated, block: B:68:0x0263 A[EDGE_INSN: B:68:0x0263->B:69:0x0265 BREAK  A[LOOP:1: B:61:0x022b->B:67:0x025c]] */
    /* JADX WARN: Code duplicated, block: B:76:0x0214 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0263 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.ui.graphics.colorspace.Rgb$eotf$1] */
    /* JADX WARN: Type inference failed for: r9v4, types: [androidx.compose.ui.graphics.colorspace.Rgb$eotf$1] */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, float[] fArr2, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f, float f2, TransferParameters transferParameters, int i) {
        int i2;
        float f3;
        float f4;
        float[] fArr3;
        Rgb rgb;
        double d;
        int i3;
        super(i, ColorModel.Rgb, str);
        this.whitePoint = whitePoint;
        this.min = f;
        this.max = f2;
        this.transferParameters = transferParameters;
        this.oetfOrig = doubleFunction;
        boolean z = 1;
        z = 1;
        final int i4 = z ? 1 : 0;
        this.oetf = new Function1(this) { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            public final /* synthetic */ Rgb this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                switch (i4) {
                    case 0:
                        double dDoubleValue = ((Number) obj).doubleValue();
                        Rgb rgb2 = this.this$0;
                        return Double.valueOf(rgb2.eotfOrig.invoke(RangesKt.coerceIn(dDoubleValue, rgb2.min, rgb2.max)));
                    default:
                        double dDoubleValue2 = ((Number) obj).doubleValue();
                        Rgb rgb3 = this.this$0;
                        return Double.valueOf(RangesKt.coerceIn(rgb3.oetfOrig.invoke(dDoubleValue2), rgb3.min, rgb3.max));
                }
            }
        };
        final int i5 = 0;
        this.oetfFunc = new Rgb$$ExternalSyntheticLambda0(this, 0);
        this.eotfOrig = doubleFunction2;
        this.eotf = new Function1(this) { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            public final /* synthetic */ Rgb this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                switch (i5) {
                    case 0:
                        double dDoubleValue = ((Number) obj).doubleValue();
                        Rgb rgb2 = this.this$0;
                        return Double.valueOf(rgb2.eotfOrig.invoke(RangesKt.coerceIn(dDoubleValue, rgb2.min, rgb2.max)));
                    default:
                        double dDoubleValue2 = ((Number) obj).doubleValue();
                        Rgb rgb3 = this.this$0;
                        return Double.valueOf(RangesKt.coerceIn(rgb3.oetfOrig.invoke(dDoubleValue2), rgb3.min, rgb3.max));
                }
            }
        };
        this.eotfFunc = new Rgb$$ExternalSyntheticLambda0(this, 1);
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f < f2) {
            float[] fArr4 = new float[6];
            if (fArr.length == 9) {
                float f5 = fArr[0];
                float f6 = fArr[1];
                float f7 = f5 + f6 + fArr[2];
                fArr4[0] = f5 / f7;
                fArr4[1] = f6 / f7;
                float f8 = fArr[3];
                float f9 = fArr[4];
                float f10 = f8 + f9 + fArr[5];
                fArr4[2] = f8 / f10;
                fArr4[3] = f9 / f10;
                float f11 = fArr[6];
                float f12 = fArr[7];
                float f13 = f11 + f12 + fArr[8];
                fArr4[4] = f11 / f13;
                fArr4[5] = f12 / f13;
            } else {
                System.arraycopy(fArr, 0, fArr4, 0, 6);
            }
            this.primaries = fArr4;
            if (fArr2 == null) {
                float f14 = fArr4[0];
                float f15 = fArr4[1];
                float f16 = fArr4[2];
                float f17 = fArr4[3];
                float f18 = fArr4[4];
                float f19 = fArr4[5];
                f3 = 1.0f;
                float f20 = whitePoint.x;
                i2 = 0;
                float f21 = whitePoint.y;
                float f22 = 1;
                float f23 = (f22 - f14) / f15;
                float f24 = (f22 - f16) / f17;
                float f25 = (f22 - f18) / f19;
                float f26 = (f22 - f20) / f21;
                float f27 = f14 / f15;
                float f28 = (f16 / f17) - f27;
                float f29 = (f20 / f21) - f27;
                float f30 = f24 - f23;
                float f31 = (f18 / f19) - f27;
                float f32 = (((f26 - f23) * f28) - (f29 * f30)) / (((f25 - f23) * f28) - (f30 * f31));
                float f33 = (f29 - (f31 * f32)) / f28;
                float f34 = (1.0f - f33) - f32;
                float f35 = f34 / f15;
                float f36 = f33 / f17;
                float f37 = f32 / f19;
                this.transform = new float[]{f35 * f14, f34, ((1.0f - f14) - f15) * f35, f36 * f16, f33, ((1.0f - f16) - f17) * f36, f37 * f18, f32, ((1.0f - f18) - f19) * f37};
            } else {
                i2 = 0;
                f3 = 1.0f;
                if (fArr2.length == 9) {
                    this.transform = fArr2;
                } else {
                    throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
                }
            }
            this.inverseTransform = Illuminant.inverse3x3(this.transform);
            float fArea = Illuminant.area(fArr4);
            float[] fArr5 = ColorSpaces.SrgbPrimaries;
            if (fArea / Illuminant.area(ColorSpaces.Ntsc1953Primaries) > 0.9f) {
                float[] fArr6 = ColorSpaces.SrgbPrimaries;
                float f38 = fArr4[i2];
                float f39 = fArr6[i2];
                float f40 = fArr4[1];
                float f41 = fArr6[1];
                float f42 = fArr4[2];
                float f43 = fArr6[2];
                float f44 = fArr4[3];
                float f45 = fArr6[3];
                float f46 = fArr4[4];
                float f47 = fArr6[4];
                float f48 = fArr4[5];
                float f49 = fArr6[5];
                f4 = 0.0f;
                float[] fArr7 = new float[6];
                fArr7[i2] = f38 - f39;
                fArr7[1] = f40 - f41;
                fArr7[2] = f42 - f43;
                fArr7[3] = f44 - f45;
                fArr7[4] = f46 - f47;
                fArr7[5] = f48 - f49;
                float f50 = fArr7[i2];
                float f51 = fArr7[1];
                if (((f41 - f49) * f50) - ((f39 - f47) * f51) >= 0.0f && ((f39 - f43) * f51) - ((f41 - f45) * f50) >= 0.0f) {
                    float f52 = fArr7[2];
                    float f53 = fArr7[3];
                    if (((f45 - f41) * f52) - ((f43 - f39) * f53) >= 0.0f && ((f43 - f47) * f53) - ((f45 - f49) * f52) >= 0.0f) {
                        float f54 = fArr7[4];
                        float f55 = fArr7[5];
                        if (((f49 - f45) * f54) - ((f47 - f43) * f55) < 0.0f || ((f47 - f39) * f55) - ((f49 - f41) * f54) < 0.0f) {
                        }
                    }
                }
                if (i != 0) {
                    fArr3 = ColorSpaces.SrgbPrimaries;
                    if (fArr4 == fArr3) {
                        i3 = i2;
                        while (true) {
                            if (i3 < 6) {
                                if (Float.compare(fArr4[i3], fArr3[i3]) != 0 || Math.abs(fArr4[i3] - fArr3[i3]) <= 0.001f) {
                                    i3++;
                                }
                            } else {
                                if (Illuminant.compare(whitePoint, Illuminant.D65)) {
                                    break;
                                }
                                float[] fArr8 = ColorSpaces.SrgbPrimaries;
                                rgb = ColorSpaces.Srgb;
                                while (d <= 1.0d) {
                                    if (Math.abs(doubleFunction.invoke(d) - rgb.oetfOrig.invoke(d)) <= 0.001d) {
                                    }
                                }
                            }
                            z = i2;
                            break;
                        }
                    }
                    if (Illuminant.compare(whitePoint, Illuminant.D65) || f != f4 || f2 != f3) {
                        z = i2;
                        break;
                    }
                    float[] fArr9 = ColorSpaces.SrgbPrimaries;
                    rgb = ColorSpaces.Srgb;
                    for (d = 0.0d; d <= 1.0d; d += 0.00392156862745098d) {
                        if (Math.abs(doubleFunction.invoke(d) - rgb.oetfOrig.invoke(d)) <= 0.001d || Math.abs(doubleFunction2.invoke(d) - rgb.eotfOrig.invoke(d)) > 0.001d) {
                            z = i2;
                            break;
                        }
                    }
                }
                this.isSrgb = z;
                return;
            }
            f4 = 0.0f;
            int i6 = (f > f4 ? 1 : (f == f4 ? 0 : -1));
            if (i != 0) {
                fArr3 = ColorSpaces.SrgbPrimaries;
                if (fArr4 == fArr3) {
                    i3 = i2;
                    while (true) {
                        if (i3 < 6) {
                            if (Float.compare(fArr4[i3], fArr3[i3]) != 0) {
                            }
                            i3++;
                        } else {
                            if (Illuminant.compare(whitePoint, Illuminant.D65)) {
                                break;
                            }
                            float[] fArr10 = ColorSpaces.SrgbPrimaries;
                            rgb = ColorSpaces.Srgb;
                            while (d <= 1.0d) {
                                if (Math.abs(doubleFunction.invoke(d) - rgb.oetfOrig.invoke(d)) <= 0.001d) {
                                }
                            }
                        }
                        z = i2;
                        break;
                    }
                }
                if (Illuminant.compare(whitePoint, Illuminant.D65)) {
                    z = i2;
                    break;
                }
                float[] fArr11 = ColorSpaces.SrgbPrimaries;
                rgb = ColorSpaces.Srgb;
                while (d <= 1.0d) {
                    if (Math.abs(doubleFunction.invoke(d) - rgb.oetfOrig.invoke(d)) <= 0.001d) {
                    }
                    z = i2;
                }
            }
            this.isSrgb = z;
            return;
        }
        throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f2 + "; min must be strictly < max");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final double d, float f, float f2, int i) {
        DoubleFunction doubleFunction;
        DoubleFunction doubleFunction2 = DoubleIdentity;
        if (d == 1.0d) {
            doubleFunction = doubleFunction2;
        } else {
            final int i2 = 0;
            doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d2) {
                    switch (i2) {
                        case 0:
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                            return Math.pow(d2, 1.0d / d);
                        default:
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                            return Math.pow(d2, d);
                    }
                }
            };
        }
        if (d != 1.0d) {
            final int i3 = 1;
            doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d2) {
                    switch (i3) {
                        case 0:
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                            return Math.pow(d2, 1.0d / d);
                        default:
                            if (d2 < 0.0d) {
                                d2 = 0.0d;
                            }
                            return Math.pow(d2, d);
                    }
                }
            };
        }
        this(str, fArr, whitePoint, null, doubleFunction, doubleFunction2, f, f2, new TransferParameters(d, 1.0d, 0.0d, 0.0d, 0.0d), i);
    }
}
