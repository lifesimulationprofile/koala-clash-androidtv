package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.core.view.MenuHostHelper;
import coil.request.Parameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThumbNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId = 2;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ float f$2;

    public /* synthetic */ ThumbNode$$ExternalSyntheticLambda0(float f, AndroidImageBitmap androidImageBitmap, BlendModeColorFilter blendModeColorFilter) {
        this.f$2 = f;
        this.f$0 = androidImageBitmap;
        this.f$1 = blendModeColorFilter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Placeable placeable = (Placeable) this.f$0;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                Animatable animatable = ((ThumbNode) this.f$1).offsetAnim;
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (int) (animatable != null ? ((Number) animatable.getValue()).floatValue() : this.f$2), 0);
                return Unit.INSTANCE;
            case 1:
                UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) this.f$0;
                Function1 function1 = (Function1) this.f$1;
                long jLongValue = ((Long) obj).longValue();
                if (updatableAnimationState.lastFrameTime == Long.MIN_VALUE) {
                    updatableAnimationState.lastFrameTime = jLongValue;
                }
                float f = updatableAnimationState.value;
                AnimationVector1D animationVector1D = new AnimationVector1D(f);
                float f2 = this.f$2;
                AnimationVector1D animationVector1D2 = UpdatableAnimationState.ZeroVector;
                long durationNanos = f2 == 0.0f ? updatableAnimationState.vectorizedSpec.getDurationNanos(new AnimationVector1D(f), animationVector1D2, updatableAnimationState.lastVelocity) : MathKt.roundToLong((jLongValue - updatableAnimationState.lastFrameTime) / f2);
                float f3 = ((AnimationVector1D) updatableAnimationState.vectorizedSpec.getValueFromNanos(durationNanos, animationVector1D, animationVector1D2, updatableAnimationState.lastVelocity)).value;
                updatableAnimationState.lastVelocity = (AnimationVector1D) updatableAnimationState.vectorizedSpec.getVelocityFromNanos(durationNanos, animationVector1D, animationVector1D2, updatableAnimationState.lastVelocity);
                updatableAnimationState.lastFrameTime = jLongValue;
                float f4 = updatableAnimationState.value - f3;
                updatableAnimationState.value = f3;
                function1.invoke(Float.valueOf(f4));
                return Unit.INSTANCE;
            default:
                float f5 = this.f$2;
                AndroidImageBitmap androidImageBitmap = (AndroidImageBitmap) this.f$0;
                BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                MenuHostHelper menuHostHelper = layoutNodeDrawScope.canvasDrawScope.drawContext;
                long jM756getSizeNHjbRc = menuHostHelper.m756getSizeNHjbRc();
                menuHostHelper.getCanvas().save();
                try {
                    Parameters.Builder builder = (Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback;
                    builder.translate(f5, 0.0f);
                    builder.m791rotateUv8p0NA(45.0f, 0L);
                    Modifier.CC.m310drawImagegbVJVH8$default(layoutNodeDrawScope, androidImageBitmap, 0L, 0.0f, blendModeColorFilter, 0, 46);
                    return Unit.INSTANCE;
                } finally {
                    ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, jM756getSizeNHjbRc);
                }
        }
    }

    public /* synthetic */ ThumbNode$$ExternalSyntheticLambda0(UpdatableAnimationState updatableAnimationState, float f, Function1 function1) {
        this.f$0 = updatableAnimationState;
        this.f$2 = f;
        this.f$1 = function1;
    }

    public /* synthetic */ ThumbNode$$ExternalSyntheticLambda0(Placeable placeable, ThumbNode thumbNode, float f) {
        this.f$0 = placeable;
        this.f$1 = thumbNode;
        this.f$2 = f;
    }
}
