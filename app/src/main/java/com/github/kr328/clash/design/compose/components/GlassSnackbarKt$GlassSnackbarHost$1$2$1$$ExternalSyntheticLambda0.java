package com.github.kr328.clash.design.compose.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.gestures.DefaultFlingBehavior;
import androidx.compose.material3.BottomSheetKt$BottomSheet$settleToDismiss$1$1$2;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ Animatable f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ PointerInputScope f$2;
    public final /* synthetic */ CoroutineScope f$3;
    public final /* synthetic */ Animatable f$4;
    public final /* synthetic */ SnackbarHostState.SnackbarDataImpl f$5;

    public /* synthetic */ GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0(Animatable animatable, float f, PointerInputScope pointerInputScope, CoroutineScope coroutineScope, Animatable animatable2, SnackbarHostState.SnackbarDataImpl snackbarDataImpl) {
        this.f$0 = animatable;
        this.f$1 = f;
        this.f$2 = pointerInputScope;
        this.f$3 = coroutineScope;
        this.f$4 = animatable2;
        this.f$5 = snackbarDataImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Animatable animatable = this.f$0;
        float fAbs = Math.abs(((Number) animatable.getValue()).floatValue());
        float f = this.f$1;
        CoroutineScope coroutineScope = this.f$3;
        if (fAbs > f) {
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            PointerInputScope pointerInputScope = this.f$2;
            JobKt.launch$default(coroutineScope, null, new DefaultFlingBehavior.AnonymousClass2(this.f$4, this.f$5, animatable, (fFloatValue > 0.0f ? (int) (((SuspendingPointerInputModifierNodeImpl) pointerInputScope).boundsSize >> 32) : -((int) (((SuspendingPointerInputModifierNodeImpl) pointerInputScope).boundsSize >> 32))) * 1.5f, (Continuation) null), 3);
        } else {
            JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(animatable, null, 3), 3);
        }
        return Unit.INSTANCE;
    }
}
