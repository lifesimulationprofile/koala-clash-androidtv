package com.github.kr328.clash.compose.newprofile;

import com.github.kr328.clash.PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IProfileManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NewProfileViewModel$importFromFile$1$uuid$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $name;
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewProfileViewModel$importFromFile$1$uuid$1(String str, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$name = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                NewProfileViewModel$importFromFile$1$uuid$1 newProfileViewModel$importFromFile$1$uuid$1 = new NewProfileViewModel$importFromFile$1$uuid$1(this.$name, continuation, 0);
                newProfileViewModel$importFromFile$1$uuid$1.L$0 = obj;
                return newProfileViewModel$importFromFile$1$uuid$1;
            default:
                NewProfileViewModel$importFromFile$1$uuid$1 newProfileViewModel$importFromFile$1$uuid$2 = new NewProfileViewModel$importFromFile$1$uuid$1(this.$name, continuation, 1);
                newProfileViewModel$importFromFile$1$uuid$2.L$0 = obj;
                return newProfileViewModel$importFromFile$1$uuid$2;
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
        return ((NewProfileViewModel$importFromFile$1$uuid$1) create(iProfileManager, continuation)).invokeSuspend(Unit.INSTANCE);
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
                PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0 propertiesActivity$commit$4$1$$ExternalSyntheticLambda0 = new PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0();
                this.label = 1;
                Object objMo811import = iProfileManager.mo811import(Profile.Type.File, this.$name, "", 0L, propertiesActivity$commit$4$1$$ExternalSyntheticLambda0, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objMo811import == coroutineSingletons ? coroutineSingletons : objMo811import;
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
                PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0 propertiesActivity$commit$4$1$$ExternalSyntheticLambda1 = new PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0();
                this.label = 1;
                Object objMo811import2 = iProfileManager2.mo811import(Profile.Type.File, this.$name, "", 0L, propertiesActivity$commit$4$1$$ExternalSyntheticLambda1, this);
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objMo811import2 == coroutineSingletons2 ? coroutineSingletons2 : objMo811import2;
        }
    }
}
