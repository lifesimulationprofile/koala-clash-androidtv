package com.github.kr328.clash;

import com.github.kr328.clash.service.remote.IProfileManager;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FilesActivity$Content$1$1$profile$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ UUID $uuidObj;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilesActivity$Content$1$1$profile$1(UUID uuid, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$uuidObj = uuid;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                FilesActivity$Content$1$1$profile$1 filesActivity$Content$1$1$profile$1 = new FilesActivity$Content$1$1$profile$1(this.$uuidObj, continuation, 0);
                filesActivity$Content$1$1$profile$1.L$0 = obj;
                return filesActivity$Content$1$1$profile$1;
            default:
                FilesActivity$Content$1$1$profile$1 filesActivity$Content$1$1$profile$2 = new FilesActivity$Content$1$1$profile$1(this.$uuidObj, continuation, 1);
                filesActivity$Content$1$1$profile$2.L$0 = obj;
                return filesActivity$Content$1$1$profile$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        IProfileManager iProfileManager = (IProfileManager) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((FilesActivity$Content$1$1$profile$1) create(iProfileManager, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                IProfileManager iProfileManager = (IProfileManager) this.L$0;
                this.label = 1;
                Object objQueryByUUID = iProfileManager.queryByUUID(this.$uuidObj, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objQueryByUUID == coroutineSingletons ? coroutineSingletons : objQueryByUUID;
            default:
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                IProfileManager iProfileManager2 = (IProfileManager) this.L$0;
                this.label = 1;
                Object objQueryByUUID2 = iProfileManager2.queryByUUID(this.$uuidObj, this);
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objQueryByUUID2 == coroutineSingletons2 ? coroutineSingletons2 : objQueryByUUID2;
        }
    }
}
