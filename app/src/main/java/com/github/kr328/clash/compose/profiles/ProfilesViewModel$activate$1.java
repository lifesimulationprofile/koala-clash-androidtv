package com.github.kr328.clash.compose.profiles;

import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IProfileManager;
import com.github.kr328.clash.util.RemoteKt;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfilesViewModel$activate$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Profile $profile;
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProfilesViewModel$activate$1(Profile profile, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$profile = profile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ProfilesViewModel$activate$1 profilesViewModel$activate$1 = new ProfilesViewModel$activate$1(this.$profile, continuation, 0);
                profilesViewModel$activate$1.L$0 = obj;
                return profilesViewModel$activate$1;
            case 1:
                ProfilesViewModel$activate$1 profilesViewModel$activate$2 = new ProfilesViewModel$activate$1(this.$profile, continuation, 1);
                profilesViewModel$activate$2.L$0 = obj;
                return profilesViewModel$activate$2;
            case 2:
                ProfilesViewModel$activate$1 profilesViewModel$activate$3 = new ProfilesViewModel$activate$1(this.$profile, continuation, 2);
                profilesViewModel$activate$3.L$0 = obj;
                return profilesViewModel$activate$3;
            default:
                ProfilesViewModel$activate$1 profilesViewModel$activate$4 = new ProfilesViewModel$activate$1(this.$profile, continuation, 3);
                profilesViewModel$activate$4.L$0 = obj;
                return profilesViewModel$activate$4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((ProfilesViewModel$activate$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((ProfilesViewModel$activate$1) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((ProfilesViewModel$activate$1) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((ProfilesViewModel$activate$1) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.$r8$classId;
        Profile profile = this.$profile;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = 1;
        switch (i) {
            case 0:
                int i3 = this.label;
                try {
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ProfilesViewModel$activate$1 profilesViewModel$activate$1 = new ProfilesViewModel$activate$1(profile, null, i2);
                        this.label = 1;
                        if (RemoteKt.withProfile$default(profilesViewModel$activate$1, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Unit unit = Unit.INSTANCE;
                    break;
                } catch (Throwable unused) {
                }
                return Unit.INSTANCE;
            case 1:
                int i4 = this.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    IProfileManager iProfileManager = (IProfileManager) this.L$0;
                    this.label = 1;
                    if (iProfileManager.setActive(profile, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 2:
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    IProfileManager iProfileManager2 = (IProfileManager) this.L$0;
                    UUID uuid = profile.uuid;
                    this.label = 1;
                    if (iProfileManager2.delete(uuid, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i6 = this.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    IProfileManager iProfileManager3 = (IProfileManager) this.L$0;
                    UUID uuid2 = profile.uuid;
                    this.label = 1;
                    if (iProfileManager3.update(uuid2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
