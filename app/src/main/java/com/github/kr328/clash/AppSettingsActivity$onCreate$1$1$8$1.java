package com.github.kr328.clash;

import androidx.compose.material3.SnackbarHostState;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppSettingsActivity$onCreate$1$1$8$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SnackbarHostState $snackbarHostState;
    public final /* synthetic */ String $unavailableMessage;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppSettingsActivity$onCreate$1$1$8$1(SnackbarHostState snackbarHostState, String str, Continuation continuation, int i) {
        super(1, continuation);
        this.$r8$classId = i;
        this.$snackbarHostState = snackbarHostState;
        this.$unavailableMessage = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Continuation continuation = (Continuation) obj;
        switch (this.$r8$classId) {
            case 0:
                return new AppSettingsActivity$onCreate$1$1$8$1(this.$snackbarHostState, this.$unavailableMessage, continuation, 0).invokeSuspend(Unit.INSTANCE);
            default:
                return new AppSettingsActivity$onCreate$1$1$8$1(this.$snackbarHostState, this.$unavailableMessage, continuation, 1).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objShowGlassSnackbar$default = GlassSnackbarKt.showGlassSnackbar$default(this.$snackbarHostState, this.$unavailableMessage, 3, this, 4);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objShowGlassSnackbar$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objShowGlassSnackbar$default2 = GlassSnackbarKt.showGlassSnackbar$default(this.$snackbarHostState, this.$unavailableMessage, 3, this, 4);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objShowGlassSnackbar$default2 == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
