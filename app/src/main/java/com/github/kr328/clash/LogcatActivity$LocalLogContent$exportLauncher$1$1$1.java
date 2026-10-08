package com.github.kr328.clash;

import android.net.Uri;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.model.LogFile;
import com.koala.clash.R;
import java.util.List;
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
public final class LogcatActivity$LocalLogContent$exportLauncher$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ LogFile $file;
    public final /* synthetic */ MutableState $messages$delegate;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ LogcatActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogcatActivity$LocalLogContent$exportLauncher$1$1$1(LogcatActivity logcatActivity, LogFile logFile, Uri uri, MutableState mutableState, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = logcatActivity;
        this.$file = logFile;
        this.$uri = uri;
        this.$messages$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new LogcatActivity$LocalLogContent$exportLauncher$1$1$1(this.this$0, this.$file, this.$uri, this.$messages$delegate, continuation, 0);
            default:
                return new LogcatActivity$LocalLogContent$exportLauncher$1$1$1(this.this$0, this.$file, this.$uri, this.$messages$delegate, continuation, 1);
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
        return ((LogcatActivity$LocalLogContent$exportLauncher$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objShowGlassSnackbar$default;
        Object objShowGlassSnackbar$default2;
        int i = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i) {
            case 0:
                LogcatActivity logcatActivity = this.this$0;
                SnackbarHostState snackbarHostState = logcatActivity.snackbarHostState;
                int i2 = this.label;
                try {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                objShowGlassSnackbar$default = obj;
                                return Unit.INSTANCE;
                            }
                            ResultKt.throwOnFailure(obj);
                            objShowGlassSnackbar$default2 = obj;
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    LogcatActivity$LocalLogContent$exportLauncher$1$1$1 logcatActivity$LocalLogContent$exportLauncher$1$1$1 = new LogcatActivity$LocalLogContent$exportLauncher$1$1$1(logcatActivity, this.$file, this.$uri, this.$messages$delegate, null, 1);
                    this.label = 1;
                    if (JobKt.withContext(defaultIoScheduler, logcatActivity$LocalLogContent$exportLauncher$1$1$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    String string = logcatActivity.getString(R.string.file_exported);
                    this.label = 2;
                    objShowGlassSnackbar$default2 = GlassSnackbarKt.showGlassSnackbar$default(snackbarHostState, string, 1, this, 28);
                    if (objShowGlassSnackbar$default2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    break;
                } catch (Exception e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    this.label = 3;
                    objShowGlassSnackbar$default = GlassSnackbarKt.showGlassSnackbar$default(snackbarHostState, message, 2, this, 28);
                    if (objShowGlassSnackbar$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    int i4 = LogcatActivity.$r8$clinit;
                    List list = (List) this.$messages$delegate.getValue();
                    this.label = 1;
                    if (LogcatActivity.access$writeLogTo(this.this$0, list, this.$file, this.$uri, this) == coroutineSingletons) {
                        return coroutineSingletons;
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
