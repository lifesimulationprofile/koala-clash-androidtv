package com.github.kr328.clash;

import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.service.remote.IProfileManager;
import com.github.kr328.clash.util.RemoteKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ShareToTvActivity$onCreate$1$list$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareToTvActivity$onCreate$1$list$1$1(int i, Continuation continuation, int i2) {
        super(i, continuation);
        this.$r8$classId = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$1 = new ShareToTvActivity$onCreate$1$list$1$1(2, continuation, 0);
                shareToTvActivity$onCreate$1$list$1$1.L$0 = obj;
                return shareToTvActivity$onCreate$1$list$1$1;
            case 1:
                ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$2 = new ShareToTvActivity$onCreate$1$list$1$1(2, continuation, 1);
                shareToTvActivity$onCreate$1$list$1$2.L$0 = obj;
                return shareToTvActivity$onCreate$1$list$1$2;
            case 2:
                ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$3 = new ShareToTvActivity$onCreate$1$list$1$1(2, continuation, 2);
                shareToTvActivity$onCreate$1$list$1$3.L$0 = obj;
                return shareToTvActivity$onCreate$1$list$1$3;
            case 3:
                ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$4 = new ShareToTvActivity$onCreate$1$list$1$1(2, continuation, 3);
                shareToTvActivity$onCreate$1$list$1$4.L$0 = obj;
                return shareToTvActivity$onCreate$1$list$1$4;
            case 4:
                ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$5 = new ShareToTvActivity$onCreate$1$list$1$1(2, continuation, 4);
                shareToTvActivity$onCreate$1$list$1$5.L$0 = obj;
                return shareToTvActivity$onCreate$1$list$1$5;
            default:
                ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$6 = new ShareToTvActivity$onCreate$1$list$1$1(2, continuation, 5);
                shareToTvActivity$onCreate$1$list$1$6.L$0 = obj;
                return shareToTvActivity$onCreate$1$list$1$6;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((ShareToTvActivity$onCreate$1$list$1$1) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((ShareToTvActivity$onCreate$1$list$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((ShareToTvActivity$onCreate$1$list$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((ShareToTvActivity$onCreate$1$list$1$1) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                return ((ShareToTvActivity$onCreate$1$list$1$1) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((ShareToTvActivity$onCreate$1$list$1$1) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        int i = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i) {
            case 0:
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                IProfileManager iProfileManager = (IProfileManager) this.L$0;
                this.label = 1;
                Object objQueryAll = iProfileManager.queryAll(this);
                return objQueryAll == coroutineSingletons ? coroutineSingletons : objQueryAll;
            case 1:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (JobKt.isActive(coroutineScope.getCoroutineContext())) {
                    BasicTextKt$$ExternalSyntheticLambda3 basicTextKt$$ExternalSyntheticLambda3 = new BasicTextKt$$ExternalSyntheticLambda3(3);
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (Stack.getMonotonicFrameClock(this._context).withFrameNanos(basicTextKt$$ExternalSyntheticLambda3, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Unit.INSTANCE;
            case 2:
                int i4 = this.label;
                try {
                    if (i4 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, null, 4);
                        this.label = 1;
                        if (RemoteKt.withClash$default(recomposer$join$2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i4 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Unit unit = Unit.INSTANCE;
                    break;
                } catch (Throwable unused) {
                }
                return Unit.INSTANCE;
            case 3:
                int i5 = this.label;
                if (i5 != 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                IProfileManager iProfileManager2 = (IProfileManager) this.L$0;
                this.label = 1;
                Object objQueryActive = iProfileManager2.queryActive(this);
                return objQueryActive == coroutineSingletons ? coroutineSingletons : objQueryActive;
            case 4:
                int i6 = this.label;
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                IProfileManager iProfileManager3 = (IProfileManager) this.L$0;
                this.label = 1;
                Object objQueryAll2 = iProfileManager3.queryAll(this);
                return objQueryAll2 == coroutineSingletons ? coroutineSingletons : objQueryAll2;
            default:
                int i7 = this.label;
                if (i7 != 0) {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                IProfileManager iProfileManager4 = (IProfileManager) this.L$0;
                this.label = 1;
                Object objQueryActive2 = iProfileManager4.queryActive(this);
                return objQueryActive2 == coroutineSingletons ? coroutineSingletons : objQueryActive2;
        }
    }
}
