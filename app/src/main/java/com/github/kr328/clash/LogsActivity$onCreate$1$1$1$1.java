package com.github.kr328.clash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogsActivity$onCreate$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $logs$delegate;
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ LogsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogsActivity$onCreate$1$1$1$1(LogsActivity logsActivity, MutableState mutableState, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = logsActivity;
        this.$logs$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new LogsActivity$onCreate$1$1$1$1(this.this$0, this.$logs$delegate, continuation, 0);
            default:
                return new LogsActivity$onCreate$1$1$1$1(this.this$0, this.$logs$delegate, continuation, 1);
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
        return ((LogsActivity$onCreate$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.$r8$classId;
        Continuation continuation = null;
        LogsActivity logsActivity = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        MutableState mutableState = this.$logs$delegate;
        int i2 = 1;
        switch (i) {
            case 0:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    LifecycleRegistry lifecycleRegistry = logsActivity.lifecycleRegistry;
                    NavHostKt$NavHost$28$1 navHostKt$NavHost$28$1 = new NavHostKt$NavHost$28$1((AppCompatActivity) logsActivity, mutableState, continuation, 26);
                    this.label = 1;
                    if (ViewModelKt.repeatOnLifecycle(lifecycleRegistry, Lifecycle.State.STARTED, navHostKt$NavHost$28$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i4 = this.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    LogsActivity$onCreate$1$1$1$1$1$1 logsActivity$onCreate$1$1$1$1$1$1 = new LogsActivity$onCreate$1$1$1$1$1$1(logsActivity, continuation, i2);
                    this.label = 1;
                    if (JobKt.withContext(defaultIoScheduler, logsActivity$onCreate$1$1$1$1$1$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                mutableState.setValue(Integer.valueOf(((Number) mutableState.getValue()).intValue() + 1));
                return Unit.INSTANCE;
        }
    }
}
