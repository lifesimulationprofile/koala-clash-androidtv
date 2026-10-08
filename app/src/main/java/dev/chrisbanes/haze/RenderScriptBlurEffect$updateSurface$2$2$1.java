package dev.chrisbanes.haze;

import android.renderscript.Allocation;
import android.renderscript.ScriptIntrinsicBlur;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptBlurEffect$updateSurface$2$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ float $blurRadius;
    public final /* synthetic */ RenderScriptContext $rs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderScriptBlurEffect$updateSurface$2$2$1(RenderScriptContext renderScriptContext, float f, Continuation continuation) {
        super(2, continuation);
        this.$rs = renderScriptContext;
        this.$blurRadius = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RenderScriptBlurEffect$updateSurface$2$2$1(this.$rs, this.$blurRadius, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((RenderScriptBlurEffect$updateSurface$2$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        RenderScriptContext renderScriptContext = this.$rs;
        Allocation allocation = renderScriptContext.outputAlloc;
        ScriptIntrinsicBlur scriptIntrinsicBlur = renderScriptContext.blurScript;
        if (!renderScriptContext.isDestroyed) {
            float f = this.$blurRadius;
            if (f > 25.0f) {
                f = 25.0f;
            }
            scriptIntrinsicBlur.setRadius(f);
            scriptIntrinsicBlur.forEach(allocation);
            if (!renderScriptContext.isDestroyed) {
                allocation.copyTo(renderScriptContext.outputBitmap);
            }
        }
        return Unit.INSTANCE;
    }
}
