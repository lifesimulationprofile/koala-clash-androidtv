package androidx.compose.ui.graphics.colorspace;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ColorSpaces {
    public static final Rgb Aces;
    public static final Rgb Acescg;
    public static final Rgb AdobeRgb;
    public static final Rgb Bt2020;
    public static final Rgb Bt2020Hlg;
    public static final TransferParameters Bt2020HlgTransferParameters;
    public static final Rgb Bt2020Pq;
    public static final TransferParameters Bt2020PqTransferParameters;
    public static final Rgb Bt709;
    public static final Lab CieLab;
    public static final Lab CieXyz;
    public static final ColorSpace[] ColorSpacesArray;
    public static final Rgb DciP3;
    public static final Rgb DisplayP3;
    public static final Rgb ExtendedSrgb;
    public static final Rgb LinearExtendedSrgb;
    public static final Rgb LinearSrgb;
    public static final Rgb Ntsc1953;
    public static final float[] Ntsc1953Primaries;
    public static final Oklab Oklab;
    public static final Rgb ProPhotoRgb;
    public static final Rgb SmpteC;
    public static final Rgb Srgb;
    public static final float[] SrgbPrimaries;
    public static final Rgb Unspecified;

    static {
        float[] fArr = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        SrgbPrimaries = fArr;
        float[] fArr2 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        Ntsc1953Primaries = fArr2;
        float[] fArr3 = {0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f};
        TransferParameters transferParameters = new TransferParameters(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d);
        TransferParameters transferParameters2 = new TransferParameters(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d);
        TransferParameters transferParameters3 = new TransferParameters(-3.0d, 2.0d, 2.0d, 5.591816309728916d, 0.28466892d, 0.55991073d, -0.685490157d);
        Bt2020HlgTransferParameters = transferParameters3;
        TransferParameters transferParameters4 = new TransferParameters(-2.0d, -1.555223d, 1.860454d, 0.012683313515655966d, 18.8515625d, -18.6875d, 6.277394636015326d);
        Bt2020PqTransferParameters = transferParameters4;
        WhitePoint whitePoint = Illuminant.D65;
        Rgb rgb = new Rgb("sRGB IEC61966-2.1", fArr, whitePoint, transferParameters, 0);
        Srgb = rgb;
        Rgb rgb2 = new Rgb("sRGB IEC61966-2.1 (Linear)", fArr, whitePoint, 1.0d, 0.0f, 1.0f, 1);
        LinearSrgb = rgb2;
        Rgb rgb3 = new Rgb("scRGB-nl IEC 61966-2-2:2003", fArr, whitePoint, null, new ZslControlImpl$$ExternalSyntheticLambda0(9), new ZslControlImpl$$ExternalSyntheticLambda0(10), -0.799f, 2.399f, transferParameters, 2);
        ExtendedSrgb = rgb3;
        Rgb rgb4 = new Rgb("scRGB IEC 61966-2-2:2003", fArr, whitePoint, 1.0d, -0.5f, 7.499f, 3);
        LinearExtendedSrgb = rgb4;
        Rgb rgb5 = new Rgb("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, whitePoint, new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d), 4);
        Bt709 = rgb5;
        Rgb rgb6 = new Rgb("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, whitePoint, new TransferParameters(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d), 5);
        Bt2020 = rgb6;
        Rgb rgb7 = new Rgb("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new WhitePoint(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        DciP3 = rgb7;
        Rgb rgb8 = new Rgb("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, whitePoint, transferParameters, 7);
        DisplayP3 = rgb8;
        Rgb rgb9 = new Rgb("NTSC (1953)", fArr2, Illuminant.C, new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d), 8);
        Ntsc1953 = rgb9;
        Rgb rgb10 = new Rgb("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, whitePoint, new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d), 9);
        SmpteC = rgb10;
        Rgb rgb11 = new Rgb("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, whitePoint, 2.2d, 0.0f, 1.0f, 10);
        AdobeRgb = rgb11;
        Rgb rgb12 = new Rgb("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, Illuminant.D50, new TransferParameters(1.8d, 1.0d, 0.0d, 0.0625d, 0.031248d), 11);
        ProPhotoRgb = rgb12;
        WhitePoint whitePoint2 = Illuminant.D60;
        Rgb rgb13 = new Rgb("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, whitePoint2, 1.0d, -65504.0f, 65504.0f, 12);
        Aces = rgb13;
        Rgb rgb14 = new Rgb("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, whitePoint2, 1.0d, -65504.0f, 65504.0f, 13);
        Acescg = rgb14;
        Lab lab = new Lab(14, 1, ColorModel.Xyz, "Generic XYZ");
        CieXyz = lab;
        long j = ColorModel.Lab;
        Lab lab2 = new Lab(15, 0, j, "Generic L*a*b*");
        CieLab = lab2;
        Rgb rgb15 = new Rgb("None", fArr, whitePoint, transferParameters2, 16);
        Unspecified = rgb15;
        Rgb rgb16 = new Rgb("Hybrid Log Gamma encoding", fArr3, whitePoint, null, new ZslControlImpl$$ExternalSyntheticLambda0(11), new ZslControlImpl$$ExternalSyntheticLambda0(12), 0.0f, 1.0f, transferParameters3, 17);
        Bt2020Hlg = rgb16;
        Rgb rgb17 = new Rgb("Perceptual Quantizer encoding", fArr3, whitePoint, null, new ZslControlImpl$$ExternalSyntheticLambda0(13), new ZslControlImpl$$ExternalSyntheticLambda0(14), 0.0f, 1.0f, transferParameters4, 18);
        Bt2020Pq = rgb17;
        Oklab oklab = new Oklab(19, j, "Oklab");
        Oklab = oklab;
        ColorSpacesArray = new ColorSpace[]{rgb, rgb2, rgb3, rgb4, rgb5, rgb6, rgb7, rgb8, rgb9, rgb10, rgb11, rgb12, rgb13, rgb14, lab, lab2, rgb15, rgb16, rgb17, oklab};
    }

    public static double transferHlgEotf$ui_graphics(TransferParameters transferParameters, double d) {
        double d2 = d < 0.0d ? -1.0d : 1.0d;
        double d3 = d * d2;
        double d4 = transferParameters.a;
        double d5 = transferParameters.b;
        double d6 = transferParameters.c;
        double d7 = transferParameters.d;
        double d8 = transferParameters.e;
        double d9 = d4 * d3;
        return (transferParameters.f + 1.0d) * d2 * (d9 <= 1.0d ? Math.pow(d9, d5) : Math.exp((d3 - d8) * d6) + d7);
    }

    public static double transferHlgOetf$ui_graphics(TransferParameters transferParameters, double d) {
        double d2 = d < 0.0d ? -1.0d : 1.0d;
        double d3 = 1.0d / transferParameters.a;
        double d4 = 1.0d / transferParameters.b;
        double d5 = 1.0d / transferParameters.c;
        double d6 = transferParameters.d;
        double d7 = transferParameters.e;
        double d8 = (d * d2) / (transferParameters.f + 1.0d);
        return d2 * (d8 <= 1.0d ? Math.pow(d8, d4) * d3 : (Math.log(d8 - d6) * d5) + d7);
    }

    public static double transferSt2048Eotf$ui_graphics(TransferParameters transferParameters, double d) {
        double d2 = d < 0.0d ? -1.0d : 1.0d;
        double d3 = d * d2;
        double d4 = transferParameters.a;
        double d5 = transferParameters.c;
        double dPow = (Math.pow(d3, d5) * transferParameters.b) + d4;
        return Math.pow((dPow >= 0.0d ? dPow : 0.0d) / ((Math.pow(d3, d5) * transferParameters.e) + transferParameters.d), transferParameters.f) * d2;
    }

    public static double transferSt2048Oetf$ui_graphics(TransferParameters transferParameters, double d) {
        double d2 = d < 0.0d ? -1.0d : 1.0d;
        double d3 = d * d2;
        double d4 = -transferParameters.a;
        double d5 = transferParameters.d;
        double d6 = 1.0d / transferParameters.f;
        return Math.pow(Math.max((Math.pow(d3, d6) * d5) + d4, 0.0d) / ((Math.pow(d3, d6) * (-transferParameters.e)) + transferParameters.b), 1.0d / transferParameters.c) * d2;
    }
}
