package androidx.compose.animation.core;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ArcSpline$Arc {
    public final float arcDistance;
    public final float arcVelocity;
    public final float ellipseA;
    public final float ellipseB;
    public final float ellipseCenterX;
    public final float ellipseCenterY;
    public final boolean isLinear;
    public final float[] lut;
    public final float oneOverDeltaTime;
    public final float time1;
    public final float time2;
    public float tmpCosAngle;
    public float tmpSinAngle;
    public final float vertical;
    public final float x1;
    public final float x2;
    public final float y1;
    public final float y2;

    public ArcSpline$Arc(int i, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z;
        int i2;
        float f7;
        float f8;
        this.time1 = f;
        this.time2 = f2;
        this.x1 = f3;
        this.y1 = f4;
        this.x2 = f5;
        this.y2 = f6;
        float f9 = f5 - f3;
        float f10 = f6 - f4;
        float f11 = 0.0f;
        int i3 = 1;
        boolean z2 = i == 1 || (i == 4 ? f10 > 0.0f : !(i != 5 || f10 >= 0.0f));
        float f12 = z2 ? -1.0f : 1.0f;
        this.vertical = f12;
        float f13 = 1 / (f2 - f);
        this.oneOverDeltaTime = f13;
        float[] fArr = new float[101];
        this.lut = fArr;
        boolean z3 = i == 3;
        if (z3 || Math.abs(f9) < 0.001f || Math.abs(f10) < 0.001f) {
            float fHypot = (float) Math.hypot(f10, f9);
            this.arcDistance = fHypot;
            this.arcVelocity = fHypot * f13;
            this.ellipseCenterX = f9 * f13;
            this.ellipseCenterY = f10 * f13;
            this.ellipseA = Float.NaN;
            this.ellipseB = Float.NaN;
            z = true;
        } else {
            this.ellipseA = f9 * f12;
            this.ellipseB = f10 * (-f12);
            this.ellipseCenterX = z2 ? f5 : f3;
            this.ellipseCenterY = z2 ? f4 : f6;
            float f14 = f5 - f3;
            float f15 = f4 - f6;
            float[] fArr2 = ArcSplineKt.OurPercentCache;
            int i4 = 90;
            float f16 = 90;
            float f17 = f15;
            float fHypot2 = 0.0f;
            float f18 = 0.0f;
            int i5 = 1;
            while (true) {
                i2 = i3;
                f7 = f11;
                double d = (float) (((((double) i5) * 90.0d) / ((double) i4)) * 0.017453292519943295d);
                float fSin = ((float) Math.sin(d)) * f14;
                float fCos = ((float) Math.cos(d)) * f15;
                float f19 = fSin - f18;
                f8 = f16;
                fHypot2 += (float) Math.hypot(f19, fCos - f17);
                fArr2[i5] = fHypot2;
                i4 = 90;
                if (i5 == 90) {
                    break;
                }
                i5++;
                f17 = fCos;
                f16 = f8;
                f11 = f7;
                f18 = fSin;
                i3 = i2;
            }
            this.arcDistance = fHypot2;
            int i6 = i2;
            while (true) {
                fArr2[i6] = fArr2[i6] / fHypot2;
                if (i6 == 90) {
                    break;
                } else {
                    i6++;
                }
            }
            int length = fArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                float f20 = i7 / 100.0f;
                int iBinarySearch = Arrays.binarySearch(fArr2, 0, 91, f20);
                if (iBinarySearch >= 0) {
                    fArr[i7] = iBinarySearch / f8;
                } else if (iBinarySearch == -1) {
                    fArr[i7] = f7;
                } else {
                    int i8 = -iBinarySearch;
                    int i9 = i8 - 2;
                    float f21 = i9;
                    float f22 = fArr2[i9];
                    fArr[i7] = (((f20 - f22) / (fArr2[i8 - 1] - f22)) + f21) / f8;
                }
            }
            this.arcVelocity = this.arcDistance * this.oneOverDeltaTime;
            z = z3;
        }
        this.isLinear = z;
    }

    public final float calcDX() {
        float f = this.ellipseA * this.tmpCosAngle;
        return f * this.vertical * (this.arcVelocity / ((float) Math.hypot(f, (-this.ellipseB) * this.tmpSinAngle)));
    }

    public final float calcDY() {
        float f = this.ellipseA * this.tmpCosAngle;
        float f2 = (-this.ellipseB) * this.tmpSinAngle;
        return f2 * this.vertical * (this.arcVelocity / ((float) Math.hypot(f, f2)));
    }

    public final void setPoint(float f) {
        float f2 = (this.vertical == -1.0f ? this.time2 - f : f - this.time1) * this.oneOverDeltaTime;
        float fM = 0.0f;
        if (f2 > 0.0f) {
            fM = 1.0f;
            if (f2 < 1.0f) {
                float f3 = f2 * 100;
                int i = (int) f3;
                float[] fArr = this.lut;
                float f4 = fArr[i];
                fM = ImageAnalysis$$ExternalSyntheticLambda1.m(fArr[i + 1], f4, f3 - i, f4);
            }
        }
        double d = fM * 1.5707964f;
        this.tmpSinAngle = (float) Math.sin(d);
        this.tmpCosAngle = (float) Math.cos(d);
    }
}
