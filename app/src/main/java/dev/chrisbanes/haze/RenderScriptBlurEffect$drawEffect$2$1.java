package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptBlurEffect$drawEffect$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Ref$FloatRef $blurRadiusPx;
    public final /* synthetic */ GraphicsLayer $layer;
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ RenderScriptBlurEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RenderScriptBlurEffect$drawEffect$2$1(RenderScriptBlurEffect renderScriptBlurEffect, GraphicsLayer graphicsLayer, Ref$FloatRef ref$FloatRef, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = renderScriptBlurEffect;
        this.$layer = graphicsLayer;
        this.$blurRadiusPx = ref$FloatRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new RenderScriptBlurEffect$drawEffect$2$1(this.this$0, this.$layer, this.$blurRadiusPx, continuation, 0);
            default:
                return new RenderScriptBlurEffect$drawEffect$2$1(this.this$0, this.$layer, this.$blurRadiusPx, continuation, 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((RenderScriptBlurEffect$drawEffect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                GraphicsLayer graphicsLayer = this.$layer;
                RenderScriptBlurEffect renderScriptBlurEffect = this.this$0;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    float f = this.$blurRadiusPx.element;
                    this.label = 1;
                    Object objAccess$updateSurface = RenderScriptBlurEffect.access$updateSurface(renderScriptBlurEffect, graphicsLayer, f, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAccess$updateSurface == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((GraphicsContext) HitTestResultKt.currentValueOf(renderScriptBlurEffect.node, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(graphicsLayer);
                return Unit.INSTANCE;
            default:
                RenderScriptBlurEffect renderScriptBlurEffect2 = this.this$0;
                HazeEffectNode hazeEffectNode = renderScriptBlurEffect2.node;
                int i2 = this.label;
                GraphicsLayer graphicsLayer2 = this.$layer;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    float f2 = this.$blurRadiusPx.element;
                    this.label = 1;
                    Object objAccess$updateSurface2 = RenderScriptBlurEffect.access$updateSurface(renderScriptBlurEffect2, graphicsLayer2, f2, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAccess$updateSurface2 == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(graphicsLayer2);
                if (renderScriptBlurEffect2.drawSkipped) {
                    HitTestResultKt.invalidateDraw(hazeEffectNode);
                }
                return Unit.INSTANCE;
        }
    }
}
