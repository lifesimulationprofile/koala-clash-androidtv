package com.github.kr328.clash.compose;

import androidx.compose.material3.SnackbarHostState;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HwidLimitDialogKt$HwidLimitDialog$2$1$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ SnackbarHostState $glassSnackbar;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String $supportURL;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HwidLimitDialogKt$HwidLimitDialog$2$1$1$2(SnackbarHostState snackbarHostState, String str, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$glassSnackbar = snackbarHostState;
        this.$supportURL = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new HwidLimitDialogKt$HwidLimitDialog$2$1$1$2(this.$glassSnackbar, this.$supportURL, continuation, 0);
            default:
                return new HwidLimitDialogKt$HwidLimitDialog$2$1$1$2(this.$glassSnackbar, this.$supportURL, continuation, 1);
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
        return ((HwidLimitDialogKt$HwidLimitDialog$2$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SnackbarHostState snackbarHostState = this.$glassSnackbar;
                    if (snackbarHostState != null) {
                        this.label = 1;
                        obj = GlassSnackbarKt.showGlassSnackbar$default(snackbarHostState, this.$supportURL, 4, this, 28);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    SnackbarHostState snackbarHostState2 = this.$glassSnackbar;
                    if (snackbarHostState2 != null) {
                        this.label = 1;
                        obj = GlassSnackbarKt.showGlassSnackbar$default(snackbarHostState2, this.$supportURL, 4, this, 28);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
        }
    }
}
