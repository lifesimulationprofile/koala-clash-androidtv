package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ScrimKt$Scrim$dismissModifier$1$1;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect {
    public long containerSize;
    public final Density density;
    public final EdgeEffectWrapper edgeEffectWrapper;
    public final boolean invalidationEnabled;
    public final DelegatingNode node;
    public long pointerId;
    public long pointerPosition = 9205357640488583168L;
    public final ParcelableSnapshotMutableState redrawSignal;
    public boolean scrollCycleInProgress;

    public AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues) {
        this.density = density;
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, BrushKt.m426toArgb8_81llA(j));
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.redrawSignal = new ParcelableSnapshotMutableState(Unit.INSTANCE, NeverEqualPolicy.INSTANCE);
        this.invalidationEnabled = true;
        this.containerSize = 0L;
        this.pointerId = -1L;
        ScrimKt$Scrim$dismissModifier$1$1 scrimKt$Scrim$dismissModifier$1$1 = new ScrimKt$Scrim$dismissModifier$1$1(1, this);
        PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = new SuspendingPointerInputModifierNodeImpl(null, null, scrimKt$Scrim$dismissModifier$1$1);
        this.node = Build.VERSION.SDK_INT >= 31 ? new GlowOverscrollNode(suspendingPointerInputModifierNodeImpl, this, edgeEffectWrapper) : new GlowOverscrollNode(suspendingPointerInputModifierNodeImpl, this, edgeEffectWrapper, paddingValues);
    }

    public final void animateToReleaseIfNeeded() {
        boolean z;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        boolean z2 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = !edgeEffect.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z = !edgeEffect2.isFinished() || z;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z = !edgeEffect3.isFinished() || z;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            invalidateOverscroll$foundation();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        if (r20.invoke(r4, r5) == r6) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0128, code lost:
    
        if (r4 == r6) goto L51;
     */
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m39applyToFlingBMRW4eQ(long r18, kotlin.jvm.functions.Function2 r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m39applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX INFO: renamed from: displacement-F1C5BW0$foundation, reason: not valid java name */
    public final long m40displacementF1C5BW0$foundation() {
        long jM391getCenteruvyYCjk = this.pointerPosition;
        if ((9223372034707292159L & jM391getCenteruvyYCjk) == 9205357640488583168L) {
            jM391getCenteruvyYCjk = SizeKt.m391getCenteruvyYCjk(this.containerSize);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM391getCenteruvyYCjk >> 32)) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jM391getCenteruvyYCjk & 4294967295L)) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public final void invalidateOverscroll$foundation() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    public final float m41pullBottomk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m40displacementF1C5BW0$foundation() >> 32));
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        float fOnPullDistance = -fIntBitsToFloat2;
        float f = 1 - fIntBitsToFloat;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fOnPullDistance = Api31Impl.onPullDistance(orCreateBottomEffect, fOnPullDistance, f);
        } else {
            orCreateBottomEffect.onPull(fOnPullDistance, f);
        }
        return (i2 >= 31 ? Api31Impl.getDistance(orCreateBottomEffect) : 0.0f) == 0.0f ? Float.intBitsToFloat((int) (4294967295L & this.containerSize)) * (-fOnPullDistance) : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    public final float m42pullLeftk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m40displacementF1C5BW0$foundation() & 4294967295L));
        int i = (int) (j >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        float f = 1 - fIntBitsToFloat;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fIntBitsToFloat2 = Api31Impl.onPullDistance(orCreateLeftEffect, fIntBitsToFloat2, f);
        } else {
            orCreateLeftEffect.onPull(fIntBitsToFloat2, f);
        }
        return (i2 >= 31 ? Api31Impl.getDistance(orCreateLeftEffect) : 0.0f) == 0.0f ? Float.intBitsToFloat((int) (this.containerSize >> 32)) * fIntBitsToFloat2 : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    public final float m43pullRightk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m40displacementF1C5BW0$foundation() & 4294967295L));
        int i = (int) (j >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        float fOnPullDistance = -fIntBitsToFloat2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fOnPullDistance = Api31Impl.onPullDistance(orCreateRightEffect, fOnPullDistance, fIntBitsToFloat);
        } else {
            orCreateRightEffect.onPull(fOnPullDistance, fIntBitsToFloat);
        }
        return (i2 >= 31 ? Api31Impl.getDistance(orCreateRightEffect) : 0.0f) == 0.0f ? Float.intBitsToFloat((int) (this.containerSize >> 32)) * (-fOnPullDistance) : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    public final float m44pullTopk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m40displacementF1C5BW0$foundation() >> 32));
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            fIntBitsToFloat2 = Api31Impl.onPullDistance(orCreateTopEffect, fIntBitsToFloat2, fIntBitsToFloat);
        } else {
            orCreateTopEffect.onPull(fIntBitsToFloat2, fIntBitsToFloat);
        }
        return (i2 >= 31 ? Api31Impl.getDistance(orCreateTopEffect) : 0.0f) == 0.0f ? Float.intBitsToFloat((int) (4294967295L & this.containerSize)) * fIntBitsToFloat2 : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: updateSize-uvyYCjk$foundation, reason: not valid java name */
    public final void m45updateSizeuvyYCjk$foundation(long j) {
        boolean zM384equalsimpl0 = Size.m384equalsimpl0(this.containerSize, 0L);
        boolean zM384equalsimpl1 = Size.m384equalsimpl0(j, this.containerSize);
        this.containerSize = j;
        if (!zM384equalsimpl1) {
            int iRoundToInt = MathKt.roundToInt(Float.intBitsToFloat((int) (j >> 32)));
            long jRoundToInt = (((long) MathKt.roundToInt(Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iRoundToInt) << 32);
            EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
            edgeEffectWrapper.size = jRoundToInt;
            EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
            if (edgeEffect != null) {
                edgeEffect.setSize((int) (jRoundToInt >> 32), (int) (jRoundToInt & 4294967295L));
            }
            EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
            if (edgeEffect2 != null) {
                edgeEffect2.setSize((int) (jRoundToInt >> 32), (int) (jRoundToInt & 4294967295L));
            }
            EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
            if (edgeEffect3 != null) {
                edgeEffect3.setSize((int) (jRoundToInt & 4294967295L), (int) (jRoundToInt >> 32));
            }
            EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
            if (edgeEffect4 != null) {
                edgeEffect4.setSize((int) (jRoundToInt & 4294967295L), (int) (jRoundToInt >> 32));
            }
            EdgeEffect edgeEffect5 = edgeEffectWrapper.topEffectNegation;
            if (edgeEffect5 != null) {
                edgeEffect5.setSize((int) (jRoundToInt >> 32), (int) (jRoundToInt & 4294967295L));
            }
            EdgeEffect edgeEffect6 = edgeEffectWrapper.bottomEffectNegation;
            if (edgeEffect6 != null) {
                edgeEffect6.setSize((int) (jRoundToInt >> 32), (int) (jRoundToInt & 4294967295L));
            }
            EdgeEffect edgeEffect7 = edgeEffectWrapper.leftEffectNegation;
            if (edgeEffect7 != null) {
                edgeEffect7.setSize((int) (jRoundToInt & 4294967295L), (int) (jRoundToInt >> 32));
            }
            EdgeEffect edgeEffect8 = edgeEffectWrapper.rightEffectNegation;
            if (edgeEffect8 != null) {
                edgeEffect8.setSize((int) (4294967295L & jRoundToInt), (int) (jRoundToInt >> 32));
            }
        }
        if (zM384equalsimpl0 || zM384equalsimpl1) {
            return;
        }
        animateToReleaseIfNeeded();
    }
}
