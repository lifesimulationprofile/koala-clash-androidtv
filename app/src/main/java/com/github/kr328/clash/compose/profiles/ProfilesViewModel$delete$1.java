package com.github.kr328.clash.compose.profiles;

import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.util.RemoteKt;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfilesViewModel$delete$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Profile $profile;
    public final /* synthetic */ int $r8$classId = 0;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ProfilesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfilesViewModel$delete$1(ProfilesViewModel profilesViewModel, Profile profile, Continuation continuation) {
        super(2, continuation);
        this.this$0 = profilesViewModel;
        this.$profile = profile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ProfilesViewModel$delete$1 profilesViewModel$delete$1 = new ProfilesViewModel$delete$1(this.this$0, this.$profile, continuation);
                profilesViewModel$delete$1.L$0 = obj;
                return profilesViewModel$delete$1;
            default:
                ProfilesViewModel$delete$1 profilesViewModel$delete$2 = new ProfilesViewModel$delete$1(this.$profile, this.this$0, continuation);
                profilesViewModel$delete$2.L$0 = obj;
                return profilesViewModel$delete$2;
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
        return ((ProfilesViewModel$delete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object failure;
        Object value;
        int i = this.$r8$classId;
        ProfilesViewModel profilesViewModel = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Profile profile = this.$profile;
        switch (i) {
            case 0:
                int i2 = this.label;
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ProfilesViewModel$activate$1 profilesViewModel$activate$1 = new ProfilesViewModel$activate$1(profile, null, 2);
                        this.label = 1;
                        if (RemoteKt.withProfile$default(profilesViewModel$activate$1, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Unit unit = Unit.INSTANCE;
                    break;
                } catch (Throwable unused) {
                }
                profilesViewModel.refreshProfiles();
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                try {
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ProfilesViewModel$activate$1 profilesViewModel$activate$2 = new ProfilesViewModel$activate$1(profile, null, 3);
                        this.label = 1;
                        if (RemoteKt.withProfile$default(profilesViewModel$activate$2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    failure = Unit.INSTANCE;
                    break;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (Result.m830exceptionOrNullimpl(failure) != null) {
                    StateFlowImpl stateFlowImpl = profilesViewModel._updatingProfiles;
                    do {
                        value = stateFlowImpl.getValue();
                    } while (!stateFlowImpl.compareAndSet(value, SetsKt.minus((Set) value, profile.uuid)));
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfilesViewModel$delete$1(Profile profile, ProfilesViewModel profilesViewModel, Continuation continuation) {
        super(2, continuation);
        this.$profile = profile;
        this.this$0 = profilesViewModel;
    }
}
