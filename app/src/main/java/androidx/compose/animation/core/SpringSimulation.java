package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SpringSimulation {
    public float dampingRatio;
    public float finalPosition;
    public double naturalFreq;

    /* JADX INFO: renamed from: updateValues-IJZedt4$animation_core, reason: not valid java name */
    public final long m29updateValuesIJZedt4$animation_core(float f, float f2, long j) {
        double dSin;
        double dCos;
        double dExp;
        double dExp2;
        float f3 = f - this.finalPosition;
        double d = j / 1000.0d;
        float f4 = this.dampingRatio;
        double d2 = ((double) f4) * ((double) f4);
        double d3 = this.naturalFreq;
        double d4 = ((double) (-f4)) * d3;
        if (f4 <= 1.0f) {
            if (f4 == 1.0f) {
                double d5 = f3;
                double d6 = (d3 * d5) + ((double) f2);
                double d7 = (-d3) * d;
                double d8 = (d * d6) + d5;
                dSin = Math.exp(d7) * d8;
                dExp = Math.exp(d7) * d8 * (-this.naturalFreq);
                dExp2 = Math.exp(d7) * d6;
            } else {
                double d9 = 1;
                double dSqrt = Math.sqrt(d9 - d2) * d3;
                double d10 = f3;
                double d11 = (((-d4) * d10) + ((double) f2)) * (d9 / dSqrt);
                double d12 = dSqrt * d;
                double d13 = d * d4;
                dSin = ((Math.sin(d12) * d11) + (Math.cos(d12) * d10)) * Math.exp(d13);
                dCos = (((Math.cos(d12) * dSqrt * d11) + (Math.sin(d12) * (-dSqrt) * d10)) * Math.exp(d13)) + (d4 * dSin);
            }
            return (((long) Float.floatToRawIntBits((float) dCos)) & 4294967295L) | (Float.floatToRawIntBits((float) (dSin + ((double) this.finalPosition))) << 32);
        }
        double dSqrt2 = Math.sqrt(d2 - ((double) 1)) * d3;
        double d14 = d4 + dSqrt2;
        double d15 = d4 - dSqrt2;
        double d16 = f3;
        double d17 = ((d15 * d16) - ((double) f2)) / (d15 - d14);
        double d18 = d16 - d17;
        double d19 = d15 * d;
        double d20 = d * d14;
        dSin = (Math.exp(d20) * d17) + (Math.exp(d19) * d18);
        dExp = Math.exp(d19) * d18 * d15;
        dExp2 = Math.exp(d20) * d17 * d14;
        dCos = dExp2 + dExp;
        return (((long) Float.floatToRawIntBits((float) dCos)) & 4294967295L) | (Float.floatToRawIntBits((float) (dSin + ((double) this.finalPosition))) << 32);
    }
}
