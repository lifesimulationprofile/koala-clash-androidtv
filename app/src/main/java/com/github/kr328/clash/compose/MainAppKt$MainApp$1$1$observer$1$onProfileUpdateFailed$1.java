package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.material3.SnackbarHostState;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.koala.clash.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ SnackbarHostState $snackbarHostState;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1(Context context, String str, SnackbarHostState snackbarHostState, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$context = context;
        this.$reason = str;
        this.$snackbarHostState = snackbarHostState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1(this.$context, this.$reason, this.$snackbarHostState, continuation, 0);
            default:
                return new MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1(this.$context, this.$reason, this.$snackbarHostState, continuation, 1);
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
        return ((MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String string = this.$context.getString(R.string.update_failure);
                    String str = this.$reason;
                    if (str != null) {
                        string = ImageAnalysis$$ExternalSyntheticLambda1.m(string, ": ", str);
                    }
                    this.label = 1;
                    Object objShowGlassSnackbar$default = GlassSnackbarKt.showGlassSnackbar$default(this.$snackbarHostState, string, 2, this, 28);
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
                    String string2 = this.$context.getString(R.string.update_failure);
                    String str2 = this.$reason;
                    if (str2 != null) {
                        string2 = ImageAnalysis$$ExternalSyntheticLambda1.m(string2, ": ", str2);
                    }
                    this.label = 1;
                    Object objShowGlassSnackbar$default2 = GlassSnackbarKt.showGlassSnackbar$default(this.$snackbarHostState, string2, 2, this, 28);
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
