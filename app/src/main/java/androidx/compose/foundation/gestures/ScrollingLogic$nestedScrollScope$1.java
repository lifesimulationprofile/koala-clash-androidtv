package androidx.compose.foundation.gestures;

import android.widget.EdgeEffect;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.AndroidOverscroll_androidKt;
import androidx.compose.foundation.EdgeEffectWrapper;
import androidx.compose.foundation.GlowEdgeEffectCompat;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic$nestedScrollScope$1 {
    public final /* synthetic */ ScrollingLogic this$0;

    public ScrollingLogic$nestedScrollScope$1(ScrollingLogic scrollingLogic) {
        this.this$0 = scrollingLogic;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0212  */
    /* JADX WARN: Code duplicated, block: B:109:0x0221  */
    /* JADX WARN: Code duplicated, block: B:111:0x0226  */
    /* JADX WARN: Code duplicated, block: B:113:0x022e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0232  */
    /* JADX WARN: Code duplicated, block: B:117:0x023e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0243  */
    /* JADX WARN: Code duplicated, block: B:121:0x024b  */
    /* JADX WARN: Code duplicated, block: B:122:0x024f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0252 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x0258  */
    /* JADX WARN: Code duplicated, block: B:130:0x0260  */
    /* JADX WARN: Code duplicated, block: B:132:0x0268  */
    /* JADX WARN: Code duplicated, block: B:141:0x029b  */
    /* JADX WARN: Code duplicated, block: B:144:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:148:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:150:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:151:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:157:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:160:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:164:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:166:0x030b  */
    /* JADX WARN: Code duplicated, block: B:167:0x030f  */
    /* JADX WARN: Code duplicated, block: B:169:0x0314  */
    /* JADX WARN: Code duplicated, block: B:173:0x031f  */
    /* JADX WARN: Code duplicated, block: B:176:0x0328  */
    /* JADX WARN: Code duplicated, block: B:180:0x033c  */
    /* JADX WARN: Code duplicated, block: B:182:0x034d  */
    /* JADX WARN: Code duplicated, block: B:183:0x0351  */
    /* JADX WARN: Code duplicated, block: B:185:0x0356  */
    /* JADX WARN: Code duplicated, block: B:189:0x0361  */
    /* JADX WARN: Code duplicated, block: B:191:0x0364 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:194:0x0369  */
    /* JADX WARN: Code duplicated, block: B:197:0x036d  */
    /* JADX WARN: Code duplicated, block: B:60:0x011c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0121  */
    /* JADX WARN: Code duplicated, block: B:72:0x0156 A[PHI: r8 r20
      0x0156: PHI (r8v26 float) = (r8v24 float), (r8v30 float) binds: [B:81:0x0186, B:70:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0156: PHI (r20v1 char) = (r20v0 char), (r20v2 char) binds: [B:81:0x0186, B:70:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x0158  */
    /* JADX WARN: Code duplicated, block: B:75:0x0162  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:91:0x01d5  */
    /* JADX INFO: renamed from: scrollByWithOverscroll-OzD1aCk, reason: not valid java name */
    public final long m110scrollByWithOverscrollOzD1aCk(int i, long j) {
        long j2;
        float fIntBitsToFloat;
        int i2;
        char c;
        float fM43pullRightk4lQ0M;
        float fIntBitsToFloat2;
        long jFloatToRawIntBits;
        long jM372minusMKHz9U;
        long jM372minusMKHz9U2;
        boolean z;
        boolean zIsAnimating;
        boolean z2;
        EdgeEffect orCreateBottomEffect;
        float fIntBitsToFloat3;
        GlowEdgeEffectCompat glowEdgeEffectCompat;
        float f;
        EdgeEffect orCreateTopEffect;
        float fIntBitsToFloat4;
        GlowEdgeEffectCompat glowEdgeEffectCompat2;
        float f2;
        EdgeEffect orCreateRightEffect;
        float fIntBitsToFloat5;
        GlowEdgeEffectCompat glowEdgeEffectCompat3;
        float f3;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        ScrollingLogic scrollingLogic = this.this$0;
        scrollingLogic.latestScrollSource = i;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = scrollingLogic.overscrollEffect;
        if (androidEdgeEffectOverscrollEffect == null || !(scrollingLogic.scrollableState.getCanScrollForward() || scrollingLogic.scrollableState.getCanScrollBackward())) {
            return scrollingLogic.m105performScroll3eAAhYA(scrollingLogic.outerStateScope, j, i);
        }
        int i5 = scrollingLogic.latestScrollSource;
        Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = scrollingLogic.performScrollForOverscroll;
        EdgeEffectWrapper edgeEffectWrapper = androidEdgeEffectOverscrollEffect.edgeEffectWrapper;
        if (Size.m388isEmptyimpl(androidEdgeEffectOverscrollEffect.containerSize)) {
            return ((Offset) recomposer$$ExternalSyntheticLambda0.invoke(new Offset(j))).packedValue;
        }
        if (!androidEdgeEffectOverscrollEffect.scrollCycleInProgress) {
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect)) {
                androidEdgeEffectOverscrollEffect.m42pullLeftk4lQ0M(0L);
            }
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                androidEdgeEffectOverscrollEffect.m43pullRightk4lQ0M(0L);
            }
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect)) {
                androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(0L);
            }
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect)) {
                androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(0L);
            }
            androidEdgeEffectOverscrollEffect.scrollCycleInProgress = true;
        }
        int i6 = AndroidOverscroll_androidKt.$r8$clinit;
        float f4 = i5 == 2 ? 4.0f : 1.0f;
        long jM374timestuRUvjQ = Offset.m374timestuRUvjQ(f4, j);
        int i7 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i7) != 0.0f) {
            if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect) || Float.intBitsToFloat(i7) >= 0.0f) {
                j2 = 4294967295L;
                if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect) && Float.intBitsToFloat(i7) > 0.0f) {
                    float fM41pullBottomk4lQ0M = androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM374timestuRUvjQ);
                    if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect)) {
                        edgeEffectWrapper.getOrCreateBottomEffect().finish();
                    }
                    f4 = f4;
                    fIntBitsToFloat = fM41pullBottomk4lQ0M == Float.intBitsToFloat((int) (jM374timestuRUvjQ & 4294967295L)) ? Float.intBitsToFloat(i7) : fM41pullBottomk4lQ0M / f4;
                }
            } else {
                float fM44pullTopk4lQ0M = androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM374timestuRUvjQ);
                j2 = 4294967295L;
                if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect)) {
                    edgeEffectWrapper.getOrCreateTopEffect().finish();
                }
                fIntBitsToFloat = fM44pullTopk4lQ0M == Float.intBitsToFloat((int) (jM374timestuRUvjQ & 4294967295L)) ? Float.intBitsToFloat(i7) : fM44pullTopk4lQ0M / f4;
                f4 = f4;
            }
            float f5 = fIntBitsToFloat;
            i2 = (int) (j >> 32);
            if (Float.intBitsToFloat(i2) == 0.0f) {
                if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect) || Float.intBitsToFloat(i2) >= 0.0f) {
                    c = ' ';
                    if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect) && Float.intBitsToFloat(i2) > 0.0f) {
                        fM43pullRightk4lQ0M = androidEdgeEffectOverscrollEffect.m43pullRightk4lQ0M(jM374timestuRUvjQ);
                        if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                            edgeEffectWrapper.getOrCreateRightEffect().finish();
                        }
                        if (fM43pullRightk4lQ0M == Float.intBitsToFloat((int) (jM374timestuRUvjQ >> 32))) {
                            fIntBitsToFloat2 = Float.intBitsToFloat(i2);
                        } else {
                            fIntBitsToFloat2 = fM43pullRightk4lQ0M / f4;
                        }
                    }
                } else {
                    fM43pullRightk4lQ0M = androidEdgeEffectOverscrollEffect.m42pullLeftk4lQ0M(jM374timestuRUvjQ);
                    c = ' ';
                    if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect)) {
                        edgeEffectWrapper.getOrCreateLeftEffect().finish();
                    }
                    if (fM43pullRightk4lQ0M == Float.intBitsToFloat((int) (jM374timestuRUvjQ >> 32))) {
                        fIntBitsToFloat2 = Float.intBitsToFloat(i2);
                    } else {
                        fIntBitsToFloat2 = fM43pullRightk4lQ0M / f4;
                    }
                }
                jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << c) | (((long) Float.floatToRawIntBits(f5)) & j2);
                if (!Offset.m369equalsimpl0(jFloatToRawIntBits, 0L)) {
                    androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
                }
                jM372minusMKHz9U = Offset.m372minusMKHz9U(j, jFloatToRawIntBits);
                long j3 = ((Offset) recomposer$$ExternalSyntheticLambda0.invoke(new Offset(jM372minusMKHz9U))).packedValue;
                jM372minusMKHz9U2 = Offset.m372minusMKHz9U(jM372minusMKHz9U, j3);
                if ((Float.intBitsToFloat((int) (jM372minusMKHz9U >> c)) == 0.0f || Float.intBitsToFloat((int) (jM372minusMKHz9U & j2)) != 0.0f) && ((Float.intBitsToFloat((int) (j3 >> c)) != 0.0f || Float.intBitsToFloat((int) (j3 & j2)) != 0.0f) && (EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect)))) {
                    androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
                }
                if (i5 == 1) {
                    i3 = (int) (jM372minusMKHz9U2 >> c);
                    if (Float.intBitsToFloat(i3) > 0.5f) {
                        androidEdgeEffectOverscrollEffect.m42pullLeftk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        if (Float.intBitsToFloat(i3) < -0.5f) {
                            androidEdgeEffectOverscrollEffect.m43pullRightk4lQ0M(jM372minusMKHz9U2);
                        } else {
                            z3 = false;
                        }
                        i4 = (int) (jM372minusMKHz9U2 & j2);
                        if (Float.intBitsToFloat(i4) > 0.5f) {
                            androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM372minusMKHz9U2);
                        } else {
                            if (Float.intBitsToFloat(i4) < -0.5f) {
                                androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM372minusMKHz9U2);
                            } else {
                                z4 = false;
                            }
                            if (!z3 || z4) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        z4 = true;
                        if (z3) {
                        }
                        z = true;
                    }
                    z3 = true;
                    i4 = (int) (jM372minusMKHz9U2 & j2);
                    if (Float.intBitsToFloat(i4) > 0.5f) {
                        androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        if (Float.intBitsToFloat(i4) < -0.5f) {
                            androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM372minusMKHz9U2);
                        } else {
                            z4 = false;
                        }
                        if (z3) {
                        }
                        z = true;
                    }
                    z4 = true;
                    if (z3) {
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (!Offset.m369equalsimpl0(jM372minusMKHz9U, 0L)) {
                    if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect) || Float.intBitsToFloat(i2) >= 0.0f) {
                        zIsAnimating = false;
                    } else {
                        EdgeEffect orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
                        float fIntBitsToFloat6 = Float.intBitsToFloat(i2);
                        if (orCreateLeftEffect instanceof GlowEdgeEffectCompat) {
                            GlowEdgeEffectCompat glowEdgeEffectCompat4 = (GlowEdgeEffectCompat) orCreateLeftEffect;
                            float f6 = glowEdgeEffectCompat4.oppositeReleaseDelta + fIntBitsToFloat6;
                            glowEdgeEffectCompat4.oppositeReleaseDelta = f6;
                            if (Math.abs(f6) > glowEdgeEffectCompat4.oppositeReleaseDeltaThreshold) {
                                glowEdgeEffectCompat4.onRelease();
                            }
                        } else {
                            orCreateLeftEffect.onRelease();
                        }
                        zIsAnimating = EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect);
                    }
                    if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect) && Float.intBitsToFloat(i2) > 0.0f) {
                        orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                        fIntBitsToFloat5 = Float.intBitsToFloat(i2);
                        if (orCreateRightEffect instanceof GlowEdgeEffectCompat) {
                            glowEdgeEffectCompat3 = (GlowEdgeEffectCompat) orCreateRightEffect;
                            f3 = glowEdgeEffectCompat3.oppositeReleaseDelta + fIntBitsToFloat5;
                            glowEdgeEffectCompat3.oppositeReleaseDelta = f3;
                            if (Math.abs(f3) > glowEdgeEffectCompat3.oppositeReleaseDeltaThreshold) {
                                glowEdgeEffectCompat3.onRelease();
                            }
                        } else {
                            orCreateRightEffect.onRelease();
                        }
                        if (!zIsAnimating || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
                            zIsAnimating = true;
                        } else {
                            zIsAnimating = false;
                        }
                    }
                    if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect) && Float.intBitsToFloat(i7) < 0.0f) {
                        orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                        fIntBitsToFloat4 = Float.intBitsToFloat(i7);
                        if (orCreateTopEffect instanceof GlowEdgeEffectCompat) {
                            glowEdgeEffectCompat2 = (GlowEdgeEffectCompat) orCreateTopEffect;
                            f2 = glowEdgeEffectCompat2.oppositeReleaseDelta + fIntBitsToFloat4;
                            glowEdgeEffectCompat2.oppositeReleaseDelta = f2;
                            if (Math.abs(f2) > glowEdgeEffectCompat2.oppositeReleaseDeltaThreshold) {
                                glowEdgeEffectCompat2.onRelease();
                            }
                        } else {
                            orCreateTopEffect.onRelease();
                        }
                        if (!zIsAnimating || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
                            zIsAnimating = true;
                        } else {
                            zIsAnimating = false;
                        }
                    }
                    if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect) && Float.intBitsToFloat(i7) > 0.0f) {
                        orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                        fIntBitsToFloat3 = Float.intBitsToFloat(i7);
                        if (orCreateBottomEffect instanceof GlowEdgeEffectCompat) {
                            glowEdgeEffectCompat = (GlowEdgeEffectCompat) orCreateBottomEffect;
                            f = glowEdgeEffectCompat.oppositeReleaseDelta + fIntBitsToFloat3;
                            glowEdgeEffectCompat.oppositeReleaseDelta = f;
                            if (Math.abs(f) > glowEdgeEffectCompat.oppositeReleaseDeltaThreshold) {
                                glowEdgeEffectCompat.onRelease();
                            }
                        } else {
                            orCreateBottomEffect.onRelease();
                        }
                        if (!zIsAnimating || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
                            zIsAnimating = true;
                        } else {
                            zIsAnimating = false;
                        }
                    }
                    if (!zIsAnimating || z) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z = z2;
                }
                if (z) {
                    androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
                }
                return Offset.m373plusMKHz9U(jFloatToRawIntBits, j3);
            }
            c = ' ';
            fIntBitsToFloat2 = 0.0f;
            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << c) | (((long) Float.floatToRawIntBits(f5)) & j2);
            if (!Offset.m369equalsimpl0(jFloatToRawIntBits, 0L)) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
            }
            jM372minusMKHz9U = Offset.m372minusMKHz9U(j, jFloatToRawIntBits);
            long j4 = ((Offset) recomposer$$ExternalSyntheticLambda0.invoke(new Offset(jM372minusMKHz9U))).packedValue;
            jM372minusMKHz9U2 = Offset.m372minusMKHz9U(jM372minusMKHz9U, j4);
            if (Float.intBitsToFloat((int) (jM372minusMKHz9U >> c)) == 0.0f) {
                androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
            } else {
                androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
            }
            if (i5 == 1) {
                i3 = (int) (jM372minusMKHz9U2 >> c);
                if (Float.intBitsToFloat(i3) > 0.5f) {
                    androidEdgeEffectOverscrollEffect.m42pullLeftk4lQ0M(jM372minusMKHz9U2);
                } else {
                    if (Float.intBitsToFloat(i3) < -0.5f) {
                        androidEdgeEffectOverscrollEffect.m43pullRightk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        z3 = false;
                    }
                    i4 = (int) (jM372minusMKHz9U2 & j2);
                    if (Float.intBitsToFloat(i4) > 0.5f) {
                        androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        if (Float.intBitsToFloat(i4) < -0.5f) {
                            androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM372minusMKHz9U2);
                        } else {
                            z4 = false;
                        }
                        if (z3) {
                        }
                        z = true;
                    }
                    z4 = true;
                    if (z3) {
                    }
                    z = true;
                }
                z3 = true;
                i4 = (int) (jM372minusMKHz9U2 & j2);
                if (Float.intBitsToFloat(i4) > 0.5f) {
                    androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM372minusMKHz9U2);
                } else {
                    if (Float.intBitsToFloat(i4) < -0.5f) {
                        androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        z4 = false;
                    }
                    if (z3) {
                    }
                    z = true;
                }
                z4 = true;
                if (z3) {
                }
                z = true;
            } else {
                z = false;
            }
            if (!Offset.m369equalsimpl0(jM372minusMKHz9U, 0L)) {
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect)) {
                    zIsAnimating = false;
                } else {
                    zIsAnimating = false;
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
                    orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                    fIntBitsToFloat5 = Float.intBitsToFloat(i2);
                    if (orCreateRightEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat3 = (GlowEdgeEffectCompat) orCreateRightEffect;
                        f3 = glowEdgeEffectCompat3.oppositeReleaseDelta + fIntBitsToFloat5;
                        glowEdgeEffectCompat3.oppositeReleaseDelta = f3;
                        if (Math.abs(f3) > glowEdgeEffectCompat3.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat3.onRelease();
                        }
                    } else {
                        orCreateRightEffect.onRelease();
                    }
                    if (zIsAnimating) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = true;
                    }
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
                    orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                    fIntBitsToFloat4 = Float.intBitsToFloat(i7);
                    if (orCreateTopEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat2 = (GlowEdgeEffectCompat) orCreateTopEffect;
                        f2 = glowEdgeEffectCompat2.oppositeReleaseDelta + fIntBitsToFloat4;
                        glowEdgeEffectCompat2.oppositeReleaseDelta = f2;
                        if (Math.abs(f2) > glowEdgeEffectCompat2.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat2.onRelease();
                        }
                    } else {
                        orCreateTopEffect.onRelease();
                    }
                    if (zIsAnimating) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = true;
                    }
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
                    orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                    fIntBitsToFloat3 = Float.intBitsToFloat(i7);
                    if (orCreateBottomEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat = (GlowEdgeEffectCompat) orCreateBottomEffect;
                        f = glowEdgeEffectCompat.oppositeReleaseDelta + fIntBitsToFloat3;
                        glowEdgeEffectCompat.oppositeReleaseDelta = f;
                        if (Math.abs(f) > glowEdgeEffectCompat.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat.onRelease();
                        }
                    } else {
                        orCreateBottomEffect.onRelease();
                    }
                    if (zIsAnimating) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = true;
                    }
                }
                if (zIsAnimating) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                z = z2;
            }
            if (z) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
            }
            return Offset.m373plusMKHz9U(jFloatToRawIntBits, j4);
        }
        j2 = 4294967295L;
        fIntBitsToFloat = 0.0f;
        float f7 = fIntBitsToFloat;
        i2 = (int) (j >> 32);
        if (Float.intBitsToFloat(i2) == 0.0f) {
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect)) {
                c = ' ';
                if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                }
            } else {
                c = ' ';
                if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                }
            }
            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << c) | (((long) Float.floatToRawIntBits(f7)) & j2);
            if (!Offset.m369equalsimpl0(jFloatToRawIntBits, 0L)) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
            }
            jM372minusMKHz9U = Offset.m372minusMKHz9U(j, jFloatToRawIntBits);
            long j5 = ((Offset) recomposer$$ExternalSyntheticLambda0.invoke(new Offset(jM372minusMKHz9U))).packedValue;
            jM372minusMKHz9U2 = Offset.m372minusMKHz9U(jM372minusMKHz9U, j5);
            if (Float.intBitsToFloat((int) (jM372minusMKHz9U >> c)) == 0.0f) {
                androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
            } else {
                androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
            }
            if (i5 == 1) {
                i3 = (int) (jM372minusMKHz9U2 >> c);
                if (Float.intBitsToFloat(i3) > 0.5f) {
                    androidEdgeEffectOverscrollEffect.m42pullLeftk4lQ0M(jM372minusMKHz9U2);
                } else {
                    if (Float.intBitsToFloat(i3) < -0.5f) {
                        androidEdgeEffectOverscrollEffect.m43pullRightk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        z3 = false;
                    }
                    i4 = (int) (jM372minusMKHz9U2 & j2);
                    if (Float.intBitsToFloat(i4) > 0.5f) {
                        androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        if (Float.intBitsToFloat(i4) < -0.5f) {
                            androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM372minusMKHz9U2);
                        } else {
                            z4 = false;
                        }
                        if (z3) {
                        }
                        z = true;
                    }
                    z4 = true;
                    if (z3) {
                    }
                    z = true;
                }
                z3 = true;
                i4 = (int) (jM372minusMKHz9U2 & j2);
                if (Float.intBitsToFloat(i4) > 0.5f) {
                    androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM372minusMKHz9U2);
                } else {
                    if (Float.intBitsToFloat(i4) < -0.5f) {
                        androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        z4 = false;
                    }
                    if (z3) {
                    }
                    z = true;
                }
                z4 = true;
                if (z3) {
                }
                z = true;
            } else {
                z = false;
            }
            if (!Offset.m369equalsimpl0(jM372minusMKHz9U, 0L)) {
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect)) {
                    zIsAnimating = false;
                } else {
                    zIsAnimating = false;
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
                    orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                    fIntBitsToFloat5 = Float.intBitsToFloat(i2);
                    if (orCreateRightEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat3 = (GlowEdgeEffectCompat) orCreateRightEffect;
                        f3 = glowEdgeEffectCompat3.oppositeReleaseDelta + fIntBitsToFloat5;
                        glowEdgeEffectCompat3.oppositeReleaseDelta = f3;
                        if (Math.abs(f3) > glowEdgeEffectCompat3.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat3.onRelease();
                        }
                    } else {
                        orCreateRightEffect.onRelease();
                    }
                    if (zIsAnimating) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = true;
                    }
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
                    orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                    fIntBitsToFloat4 = Float.intBitsToFloat(i7);
                    if (orCreateTopEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat2 = (GlowEdgeEffectCompat) orCreateTopEffect;
                        f2 = glowEdgeEffectCompat2.oppositeReleaseDelta + fIntBitsToFloat4;
                        glowEdgeEffectCompat2.oppositeReleaseDelta = f2;
                        if (Math.abs(f2) > glowEdgeEffectCompat2.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat2.onRelease();
                        }
                    } else {
                        orCreateTopEffect.onRelease();
                    }
                    if (zIsAnimating) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = true;
                    }
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
                    orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                    fIntBitsToFloat3 = Float.intBitsToFloat(i7);
                    if (orCreateBottomEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat = (GlowEdgeEffectCompat) orCreateBottomEffect;
                        f = glowEdgeEffectCompat.oppositeReleaseDelta + fIntBitsToFloat3;
                        glowEdgeEffectCompat.oppositeReleaseDelta = f;
                        if (Math.abs(f) > glowEdgeEffectCompat.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat.onRelease();
                        }
                    } else {
                        orCreateBottomEffect.onRelease();
                    }
                    if (zIsAnimating) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = true;
                    }
                }
                if (zIsAnimating) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                z = z2;
            }
            if (z) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
            }
            return Offset.m373plusMKHz9U(jFloatToRawIntBits, j5);
        }
        c = ' ';
        fIntBitsToFloat2 = 0.0f;
        jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << c) | (((long) Float.floatToRawIntBits(f7)) & j2);
        if (!Offset.m369equalsimpl0(jFloatToRawIntBits, 0L)) {
            androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
        }
        jM372minusMKHz9U = Offset.m372minusMKHz9U(j, jFloatToRawIntBits);
        long j6 = ((Offset) recomposer$$ExternalSyntheticLambda0.invoke(new Offset(jM372minusMKHz9U))).packedValue;
        jM372minusMKHz9U2 = Offset.m372minusMKHz9U(jM372minusMKHz9U, j6);
        if (Float.intBitsToFloat((int) (jM372minusMKHz9U >> c)) == 0.0f) {
            androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
        } else {
            androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
        }
        if (i5 == 1) {
            i3 = (int) (jM372minusMKHz9U2 >> c);
            if (Float.intBitsToFloat(i3) > 0.5f) {
                androidEdgeEffectOverscrollEffect.m42pullLeftk4lQ0M(jM372minusMKHz9U2);
            } else {
                if (Float.intBitsToFloat(i3) < -0.5f) {
                    androidEdgeEffectOverscrollEffect.m43pullRightk4lQ0M(jM372minusMKHz9U2);
                } else {
                    z3 = false;
                }
                i4 = (int) (jM372minusMKHz9U2 & j2);
                if (Float.intBitsToFloat(i4) > 0.5f) {
                    androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM372minusMKHz9U2);
                } else {
                    if (Float.intBitsToFloat(i4) < -0.5f) {
                        androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM372minusMKHz9U2);
                    } else {
                        z4 = false;
                    }
                    if (z3) {
                    }
                    z = true;
                }
                z4 = true;
                if (z3) {
                }
                z = true;
            }
            z3 = true;
            i4 = (int) (jM372minusMKHz9U2 & j2);
            if (Float.intBitsToFloat(i4) > 0.5f) {
                androidEdgeEffectOverscrollEffect.m44pullTopk4lQ0M(jM372minusMKHz9U2);
            } else {
                if (Float.intBitsToFloat(i4) < -0.5f) {
                    androidEdgeEffectOverscrollEffect.m41pullBottomk4lQ0M(jM372minusMKHz9U2);
                } else {
                    z4 = false;
                }
                if (z3) {
                }
                z = true;
            }
            z4 = true;
            if (z3) {
            }
            z = true;
        } else {
            z = false;
        }
        if (!Offset.m369equalsimpl0(jM372minusMKHz9U, 0L)) {
            if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect)) {
                zIsAnimating = false;
            } else {
                zIsAnimating = false;
            }
            if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
                orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                fIntBitsToFloat5 = Float.intBitsToFloat(i2);
                if (orCreateRightEffect instanceof GlowEdgeEffectCompat) {
                    glowEdgeEffectCompat3 = (GlowEdgeEffectCompat) orCreateRightEffect;
                    f3 = glowEdgeEffectCompat3.oppositeReleaseDelta + fIntBitsToFloat5;
                    glowEdgeEffectCompat3.oppositeReleaseDelta = f3;
                    if (Math.abs(f3) > glowEdgeEffectCompat3.oppositeReleaseDeltaThreshold) {
                        glowEdgeEffectCompat3.onRelease();
                    }
                } else {
                    orCreateRightEffect.onRelease();
                }
                if (zIsAnimating) {
                    zIsAnimating = true;
                } else {
                    zIsAnimating = true;
                }
            }
            if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
                orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                fIntBitsToFloat4 = Float.intBitsToFloat(i7);
                if (orCreateTopEffect instanceof GlowEdgeEffectCompat) {
                    glowEdgeEffectCompat2 = (GlowEdgeEffectCompat) orCreateTopEffect;
                    f2 = glowEdgeEffectCompat2.oppositeReleaseDelta + fIntBitsToFloat4;
                    glowEdgeEffectCompat2.oppositeReleaseDelta = f2;
                    if (Math.abs(f2) > glowEdgeEffectCompat2.oppositeReleaseDeltaThreshold) {
                        glowEdgeEffectCompat2.onRelease();
                    }
                } else {
                    orCreateTopEffect.onRelease();
                }
                if (zIsAnimating) {
                    zIsAnimating = true;
                } else {
                    zIsAnimating = true;
                }
            }
            if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
                orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                fIntBitsToFloat3 = Float.intBitsToFloat(i7);
                if (orCreateBottomEffect instanceof GlowEdgeEffectCompat) {
                    glowEdgeEffectCompat = (GlowEdgeEffectCompat) orCreateBottomEffect;
                    f = glowEdgeEffectCompat.oppositeReleaseDelta + fIntBitsToFloat3;
                    glowEdgeEffectCompat.oppositeReleaseDelta = f;
                    if (Math.abs(f) > glowEdgeEffectCompat.oppositeReleaseDeltaThreshold) {
                        glowEdgeEffectCompat.onRelease();
                    }
                } else {
                    orCreateBottomEffect.onRelease();
                }
                if (zIsAnimating) {
                    zIsAnimating = true;
                } else {
                    zIsAnimating = true;
                }
            }
            if (zIsAnimating) {
                z2 = true;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (z) {
            androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
        }
        return Offset.m373plusMKHz9U(jFloatToRawIntBits, j6);
    }
}
