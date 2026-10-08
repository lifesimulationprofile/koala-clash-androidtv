package androidx.compose.animation.core;

import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FloatSpringSpec implements FloatAnimationSpec {
    public final SpringSimulation spring;
    public final float visibilityThreshold;

    public FloatSpringSpec(float f, float f2, float f3) {
        this.visibilityThreshold = f3;
        SpringSimulation springSimulation = new SpringSimulation();
        springSimulation.finalPosition = 1.0f;
        springSimulation.naturalFreq = Math.sqrt(50.0d);
        springSimulation.dampingRatio = 1.0f;
        if (f < 0.0f) {
            PreconditionsKt.throwIllegalArgumentException("Damping ratio must be non-negative");
        }
        springSimulation.dampingRatio = f;
        double d = springSimulation.naturalFreq;
        if (((float) (d * d)) <= 0.0f) {
            PreconditionsKt.throwIllegalArgumentException("Spring stiffness constant must be positive.");
        }
        springSimulation.naturalFreq = Math.sqrt(f2);
        this.spring = springSimulation;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0100  */
    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final long getDurationNanos(float f, float f2, float f3) {
        double dLog;
        long j;
        SpringSimulation springSimulation = this.spring;
        double d = springSimulation.naturalFreq;
        float f4 = (float) (d * d);
        float f5 = springSimulation.dampingRatio;
        float f6 = this.visibilityThreshold;
        float f7 = (f - f2) / f6;
        float f8 = f3 / f6;
        if (f5 == 0.0f) {
            j = 9223372036854L;
        } else {
            double d2 = f4;
            double d3 = f5;
            double d4 = f8;
            double d5 = f7;
            double d6 = 1.0f;
            double dSqrt = d3 * 2.0d * Math.sqrt(d2);
            double d7 = (dSqrt * dSqrt) - (d2 * 4.0d);
            double dSqrt2 = d7 < 0.0d ? 0.0d : Math.sqrt(d7);
            double d8 = -dSqrt;
            double d9 = (d8 + dSqrt2) * 0.5d;
            double dSqrt3 = (d7 < 0.0d ? Math.sqrt(Math.abs(d7)) : 0.0d) * 0.5d;
            double d10 = (d8 - dSqrt2) * 0.5d;
            if (d5 == 0.0d && d4 == 0.0d) {
                j = 0;
            } else {
                if (d5 < 0.0d) {
                    d4 = -d4;
                }
                double dAbs = Math.abs(d5);
                double dAbs2 = Double.MAX_VALUE;
                if (d3 > 1.0d) {
                    double d11 = (d9 * dAbs) - d4;
                    double d12 = d9 - d10;
                    double d13 = d11 / d12;
                    double d14 = dAbs - d13;
                    dLog = Math.log(Math.abs(d6 / d14)) / d9;
                    double dLog2 = Math.log(Math.abs(d6 / d13)) / d10;
                    if ((Double.doubleToRawLongBits(dLog) & Long.MAX_VALUE) >= 9218868437227405312L) {
                        dLog = dLog2;
                    } else if ((Double.doubleToRawLongBits(dLog2) & Long.MAX_VALUE) < 9218868437227405312L) {
                        dLog = Math.max(dLog, dLog2);
                    }
                    double d15 = d14 * d9;
                    double dLog3 = Math.log(d15 / ((-d13) * d10)) / (d10 - d9);
                    if (Double.isNaN(dLog3) || dLog3 <= 0.0d) {
                        d6 = -d6;
                    } else if (dLog3 <= 0.0d) {
                        dLog = Math.log((-((d13 * d10) * d10)) / (d15 * d9)) / d12;
                    } else if ((-((Math.exp(dLog3 * d10) * d13) + (Math.exp(d9 * dLog3) * d14))) < d6) {
                        d6 = -d6;
                        dLog = (d13 <= 0.0d || d14 >= 0.0d) ? dLog : 0.0d;
                    } else {
                        dLog = Math.log((-((d13 * d10) * d10)) / (d15 * d9)) / d12;
                    }
                    double d16 = d13 * d10;
                    if (Math.abs((Math.exp(d10 * dLog) * d16) + (Math.exp(d9 * dLog) * d15)) >= 1.0E-4d) {
                        int i = 0;
                        while (dAbs2 > 0.001d && i < 100) {
                            i++;
                            double d17 = d9 * dLog;
                            double d18 = d10 * dLog;
                            double dExp = dLog - ((((Math.exp(d18) * d13) + (Math.exp(d17) * d14)) + d6) / ((Math.exp(d18) * d16) + (Math.exp(d17) * d15)));
                            dAbs2 = Math.abs(dLog - dExp);
                            dLog = dExp;
                        }
                    }
                } else if (d3 < 1.0d) {
                    double d19 = (d4 - (d9 * dAbs)) / dSqrt3;
                    dLog = Math.log(d6 / Math.sqrt((d19 * d19) + (dAbs * dAbs))) / d9;
                } else {
                    double d20 = d9 * dAbs;
                    double d21 = d4 - d20;
                    double dLog4 = Math.log(Math.abs(d6 / dAbs)) / d9;
                    double dLog5 = Math.log(Math.abs(d6 / d21));
                    double dLog6 = dLog5;
                    for (int i2 = 0; i2 < 6; i2++) {
                        dLog6 = dLog5 - Math.log(Math.abs(dLog6 / d9));
                    }
                    double d22 = dLog6 / d9;
                    if ((Double.doubleToRawLongBits(dLog4) & Long.MAX_VALUE) >= 9218868437227405312L) {
                        dLog4 = d22;
                    } else if ((Double.doubleToRawLongBits(d22) & Long.MAX_VALUE) < 9218868437227405312L) {
                        dLog4 = Math.max(dLog4, d22);
                    }
                    double d23 = (-(d20 + d21)) / (d9 * d21);
                    double d24 = d9 * d23;
                    double dExp2 = (Math.exp(d24) * d21 * d23) + (Math.exp(d24) * dAbs);
                    if (Double.isNaN(d23) || d23 <= 0.0d) {
                        d6 = -d6;
                    } else if (d23 <= 0.0d || (-dExp2) >= d6) {
                        dLog4 = (-(2.0d / d9)) - (dAbs / d21);
                    } else {
                        if (d21 < 0.0d && dAbs > 0.0d) {
                            dLog4 = 0.0d;
                        }
                        d6 = -d6;
                    }
                    dLog = dLog4;
                    int i3 = 0;
                    while (dAbs2 > 0.001d && i3 < 100) {
                        i3++;
                        double d25 = d9 * dLog;
                        double dExp3 = dLog - (((Math.exp(d25) * ((d21 * dLog) + dAbs)) + d6) / (Math.exp(d25) * (((((double) 1) + d25) * d21) + d20)));
                        dAbs2 = Math.abs(dLog - dExp3);
                        dLog = dExp3;
                    }
                }
                j = (long) (dLog * 1000.0d);
            }
        }
        return j * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getEndVelocity(float f, float f2, float f3) {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getValueFromNanos(long j, float f, float f2, float f3) {
        SpringSimulation springSimulation = this.spring;
        springSimulation.finalPosition = f2;
        return Float.intBitsToFloat((int) (springSimulation.m29updateValuesIJZedt4$animation_core(f, f3, j / 1000000) >> 32));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getVelocityFromNanos(long j, float f, float f2, float f3) {
        SpringSimulation springSimulation = this.spring;
        springSimulation.finalPosition = f2;
        return Float.intBitsToFloat((int) (springSimulation.m29updateValuesIJZedt4$animation_core(f, f3, j / 1000000) & 4294967295L));
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new Dispatcher(this);
    }
}
