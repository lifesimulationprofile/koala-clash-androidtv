package com.github.kr328.clash.compose.settings;

import android.content.Context;
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
public final class SettingsScreenKt$SettingsScreen$5$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ SnackbarHostState $glassSnackbar;
    public final /* synthetic */ int $r8$classId;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SettingsScreenKt$SettingsScreen$5$1$1(SnackbarHostState snackbarHostState, Context context, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$glassSnackbar = snackbarHostState;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SettingsScreenKt$SettingsScreen$5$1$1(this.$glassSnackbar, this.$context, continuation, 0);
            case 1:
                return new SettingsScreenKt$SettingsScreen$5$1$1(this.$glassSnackbar, this.$context, continuation, 1);
            default:
                return new SettingsScreenKt$SettingsScreen$5$1$1(this.$glassSnackbar, this.$context, continuation, 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((SettingsScreenKt$SettingsScreen$5$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        String string = this.$context.getString(R.string.update_downloading);
                        this.label = 1;
                        obj = GlassSnackbarKt.showGlassSnackbar$default(snackbarHostState, string, 1, this, 28);
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
            case 1:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String string2 = this.$context.getString(R.string.update_successfully);
                    this.label = 1;
                    Object objShowGlassSnackbar$default = GlassSnackbarKt.showGlassSnackbar$default(this.$glassSnackbar, string2, 1, this, 28);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objShowGlassSnackbar$default == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String string3 = this.$context.getString(R.string.update_successfully);
                    this.label = 1;
                    Object objShowGlassSnackbar$default2 = GlassSnackbarKt.showGlassSnackbar$default(this.$glassSnackbar, string3, 1, this, 28);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objShowGlassSnackbar$default2 == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
