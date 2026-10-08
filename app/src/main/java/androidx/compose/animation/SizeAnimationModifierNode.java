package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.github.kr328.clash.common.util.TickerKt$ticker$1;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SizeAnimationModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    public TweenSpec animationSpec;
    public boolean lookaheadConstraintsAvailable;
    public long lookaheadSize = AnimationModifierKt.InvalidSize;
    public long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
    public final ParcelableSnapshotMutableState animData$delegate = Stack.mutableStateOf$default(null);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnimData {
        public final Animatable anim;
        public long startSize;

        public AnimData(Animatable animatable, long j) {
            this.anim = animatable;
            this.startSize = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnimData)) {
                return false;
            }
            AnimData animData = (AnimData) obj;
            return this.anim.equals(animData.anim) && IntSize.m720equalsimpl0(this.startSize, animData.startSize);
        }

        public final int hashCode() {
            int iHashCode = this.anim.hashCode() * 31;
            long j = this.startSize;
            return ((int) (j ^ (j >>> 32))) + iHashCode;
        }

        public final String toString() {
            return "AnimData(anim=" + this.anim + ", startSize=" + ((Object) IntSize.m721toStringimpl(this.startSize)) + ')';
        }
    }

    public SizeAnimationModifierNode(TweenSpec tweenSpec) {
        this.animationSpec = tweenSpec;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo517measureBRTryo0;
        char c;
        AnimData animData;
        long jM689constrain4WqzIAM;
        AnimData animData2;
        if (measureScope.isLookingAhead()) {
            this.lookaheadConstraints = j;
            this.lookaheadConstraintsAvailable = true;
            placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(j);
        } else {
            placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(this.lookaheadConstraintsAvailable ? this.lookaheadConstraints : j);
        }
        final Placeable placeable = placeableMo517measureBRTryo0;
        long j2 = (((long) placeable.height) & 4294967295L) | (((long) placeable.width) << 32);
        if (measureScope.isLookingAhead()) {
            this.lookaheadSize = j2;
            c = ' ';
            jM689constrain4WqzIAM = j2;
            j2 = jM689constrain4WqzIAM;
        } else {
            long j3 = !IntSize.m720equalsimpl0(this.lookaheadSize, AnimationModifierKt.InvalidSize) ? this.lookaheadSize : j2;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.animData$delegate;
            AnimData animData3 = (AnimData) parcelableSnapshotMutableState.getValue();
            if (animData3 != null) {
                Animatable animatable = animData3.anim;
                c = ' ';
                boolean z = (IntSize.m720equalsimpl0(j3, ((IntSize) animatable.getValue()).packedValue) || ((Boolean) animatable.isRunning$delegate.getValue()).booleanValue()) ? false : true;
                if (!IntSize.m720equalsimpl0(j3, ((IntSize) animatable.targetValue$delegate.getValue()).packedValue) || z) {
                    animData3.startSize = ((IntSize) animatable.getValue()).packedValue;
                    animData2 = animData3;
                    JobKt.launch$default(getCoroutineScope(), null, new TickerKt$ticker$1(animData2, j3, this, null), 3);
                } else {
                    animData2 = animData3;
                }
                animData = animData2;
            } else {
                c = ' ';
                long j4 = 1;
                animData = new AnimData(new Animatable(new IntSize(j3), ArcSplineKt.IntSizeToVector, new IntSize((j4 << 32) | (j4 & 4294967295L)), 8), j3);
            }
            parcelableSnapshotMutableState.setValue(animData);
            jM689constrain4WqzIAM = ConstraintsKt.m689constrain4WqzIAM(j, ((IntSize) animData.anim.getValue()).packedValue);
        }
        final int i = (int) (jM689constrain4WqzIAM >> c);
        final int i2 = (int) (jM689constrain4WqzIAM & 4294967295L);
        final long j5 = j2;
        return measureScope.layout(i, i2, EmptyMap.INSTANCE, new Function1(this) { // from class: androidx.compose.animation.SizeAnimationModifierNode$measure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                long j6 = (((long) i) << 32) | (((long) i2) & 4294967295L);
                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                long j7 = j5;
                float f = (((int) (j6 >> 32)) - ((int) (j7 >> 32))) / 2.0f;
                float f2 = (((int) (j6 & 4294967295L)) - ((int) (j7 & 4294967295L))) / 2.0f;
                float f3 = layoutDirection == LayoutDirection.Ltr ? -1.0f : (-1) * (-1.0f);
                float f4 = 1;
                float f5 = (f3 + f4) * f;
                Placeable.PlacementScope.m536place70tqf50$default(placementScope, placeable, (((long) Math.round((f4 - 1.0f) * f2)) & 4294967295L) | (((long) Math.round(f5)) << 32));
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.lookaheadSize = AnimationModifierKt.InvalidSize;
        this.lookaheadConstraintsAvailable = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        this.animData$delegate.setValue(null);
    }
}
