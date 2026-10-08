package com.github.kr328.clash;

import android.content.SharedPreferences;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.github.kr328.clash.remote.Remote;
import com.github.kr328.clash.service.store.ServiceStore;
import com.github.kr328.clash.util.ClashKt;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AccessControlActivity$finish$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ AccessControlActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccessControlActivity$finish$1$1(AccessControlActivity accessControlActivity, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = accessControlActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new AccessControlActivity$finish$1$1(this.this$0, continuation, 0);
            case 1:
                return new AccessControlActivity$finish$1$1(this.this$0, continuation, 1);
            case 2:
                return new AccessControlActivity$finish$1$1(this.this$0, continuation, 2);
            default:
                return new AccessControlActivity$finish$1$1(this.this$0, continuation, 3);
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
            case 2:
                break;
        }
        return ((AccessControlActivity$finish$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                AccessControlActivity accessControlActivity = this.this$0;
                SynchronizedLazyImpl synchronizedLazyImpl = accessControlActivity.srvStore$delegate;
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Set set = accessControlActivity.selected;
                    if (set == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selected");
                        throw null;
                    }
                    boolean zEquals = set.equals(((ServiceStore) synchronizedLazyImpl.getValue()).getAccessControlPackages());
                    ServiceStore serviceStore = (ServiceStore) synchronizedLazyImpl.getValue();
                    Set<String> set2 = accessControlActivity.selected;
                    if (set2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selected");
                        throw null;
                    }
                    MemoryCacheService memoryCacheService = serviceStore.accessControlPackages$delegate;
                    KProperty kProperty = ServiceStore.$$delegatedProperties[3];
                    memoryCacheService.getClass();
                    SharedPreferences.Editor editorEdit = ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) memoryCacheService.imageLoader).entries).imageLoader).edit();
                    editorEdit.putStringSet("access_control_packages", set2);
                    editorEdit.apply();
                    if (Remote.broadcasts.closed && !zEquals) {
                        ClashKt.stopClashService(accessControlActivity);
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                while (Remote.broadcasts.closed) {
                    this.label = 1;
                    Object objDelay = JobKt.delay(200L, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objDelay == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                ClashKt.startClashService(accessControlActivity);
                return Unit.INSTANCE;
            case 1:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objAccess$reloadApps = AccessControlActivity.access$reloadApps(this.this$0, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAccess$reloadApps == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 2:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objAccess$reloadApps2 = AccessControlActivity.access$reloadApps(this.this$0, this);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAccess$reloadApps2 == coroutineSingletons3) {
                        return coroutineSingletons3;
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
                    this.label = 1;
                    Object objAccess$reloadApps3 = AccessControlActivity.access$reloadApps(this.this$0, this);
                    CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAccess$reloadApps3 == coroutineSingletons4) {
                        return coroutineSingletons4;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
