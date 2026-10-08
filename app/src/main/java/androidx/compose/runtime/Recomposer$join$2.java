package androidx.compose.runtime;

import android.content.Intent;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.core.model.ProviderList;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.service.remote.IClashManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharingCommand;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Recomposer$join$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Recomposer$join$2(int i, Continuation continuation, int i2) {
        super(i, continuation);
        this.$r8$classId = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, continuation, 0);
                recomposer$join$2.L$0 = obj;
                return recomposer$join$2;
            case 1:
                Recomposer$join$2 recomposer$join$3 = new Recomposer$join$2(2, continuation, 1);
                recomposer$join$3.L$0 = obj;
                return recomposer$join$3;
            case 2:
                Recomposer$join$2 recomposer$join$4 = new Recomposer$join$2(2, continuation, 2);
                recomposer$join$4.L$0 = obj;
                return recomposer$join$4;
            case 3:
                Recomposer$join$2 recomposer$join$5 = new Recomposer$join$2(2, continuation, 3);
                recomposer$join$5.L$0 = obj;
                return recomposer$join$5;
            case 4:
                Recomposer$join$2 recomposer$join$6 = new Recomposer$join$2(2, continuation, 4);
                recomposer$join$6.L$0 = obj;
                return recomposer$join$6;
            case 5:
                Recomposer$join$2 recomposer$join$7 = new Recomposer$join$2(2, continuation, 5);
                recomposer$join$7.L$0 = obj;
                return recomposer$join$7;
            case 6:
                Recomposer$join$2 recomposer$join$8 = new Recomposer$join$2(2, continuation, 6);
                recomposer$join$8.L$0 = obj;
                return recomposer$join$8;
            case 7:
                Recomposer$join$2 recomposer$join$9 = new Recomposer$join$2(2, continuation, 7);
                recomposer$join$9.L$0 = obj;
                return recomposer$join$9;
            case 8:
                Recomposer$join$2 recomposer$join$10 = new Recomposer$join$2(2, continuation, 8);
                recomposer$join$10.L$0 = obj;
                return recomposer$join$10;
            case 9:
                Recomposer$join$2 recomposer$join$11 = new Recomposer$join$2(2, continuation, 9);
                recomposer$join$11.L$0 = obj;
                return recomposer$join$11;
            case 10:
                Recomposer$join$2 recomposer$join$12 = new Recomposer$join$2(2, continuation, 10);
                recomposer$join$12.L$0 = obj;
                return recomposer$join$12;
            case 11:
                Recomposer$join$2 recomposer$join$13 = new Recomposer$join$2(2, continuation, 11);
                recomposer$join$13.L$0 = obj;
                return recomposer$join$13;
            case 12:
                Recomposer$join$2 recomposer$join$14 = new Recomposer$join$2(2, continuation, 12);
                recomposer$join$14.L$0 = obj;
                return recomposer$join$14;
            case 13:
                Recomposer$join$2 recomposer$join$15 = new Recomposer$join$2(2, continuation, 13);
                recomposer$join$15.L$0 = obj;
                return recomposer$join$15;
            case 14:
                Recomposer$join$2 recomposer$join$16 = new Recomposer$join$2(2, continuation, 14);
                recomposer$join$16.L$0 = obj;
                return recomposer$join$16;
            default:
                Recomposer$join$2 recomposer$join$17 = new Recomposer$join$2(2, continuation, 15);
                recomposer$join$17.L$0 = obj;
                return recomposer$join$17;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((Recomposer$join$2) create((Recomposer.State) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 5:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 6:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 7:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 8:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 9:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 10:
                return ((Recomposer$join$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 11:
                return ((Recomposer$join$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 12:
                return ((Recomposer$join$2) create((Pair) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 13:
                return ((Recomposer$join$2) create((Pair) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 14:
                return ((Recomposer$join$2) create((Intent) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((Recomposer$join$2) create((SharingCommand) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object failure;
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(((Recomposer.State) this.L$0) == Recomposer.State.ShutDown);
            case 1:
                ResultKt.throwOnFailure(obj);
                ProviderList providerListQueryProviders = ((IClashManager) this.L$0).queryProviders();
                if (providerListQueryProviders == null) {
                    List mutableList = CollectionsKt.toMutableList(providerListQueryProviders);
                    if (((ArrayList) mutableList).size() <= 1) {
                        return mutableList;
                    }
                    Collections.sort(mutableList);
                    return mutableList;
                }
                if (providerListQueryProviders.$$delegate_0.size() <= 1) {
                    return CollectionsKt.toList(providerListQueryProviders);
                }
                Object[] array = Intrinsics.Kotlin.toArray(providerListQueryProviders, new Comparable[0]);
                Comparable[] comparableArr = (Comparable[]) array;
                if (comparableArr.length > 1) {
                    Arrays.sort(comparableArr);
                }
                return Arrays.asList(array);
            case 2:
                ResultKt.throwOnFailure(obj);
                return ((IClashManager) this.L$0).queryClosedConnections();
            case 3:
                ResultKt.throwOnFailure(obj);
                return ((IClashManager) this.L$0).queryConnections();
            case 4:
                ResultKt.throwOnFailure(obj);
                ((IClashManager) this.L$0).closeAllConnections();
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure(obj);
                IClashManager iClashManager = (IClashManager) this.L$0;
                String str = (String) CollectionsKt.firstOrNull(iClashManager.queryProxyGroupNames(true));
                if (str != null) {
                    return iClashManager.queryProxyGroup(str, ProxySort.Default).now;
                }
                return null;
            case 6:
                ResultKt.throwOnFailure(obj);
                return ((IClashManager) this.L$0).queryConfigMode();
            case 7:
                ResultKt.throwOnFailure(obj);
                return ((IClashManager) this.L$0).queryTunnelState();
            case 8:
                ResultKt.throwOnFailure(obj);
                return ((IClashManager) this.L$0).queryConfigMode();
            case 9:
                ResultKt.throwOnFailure(obj);
                return ((IClashManager) this.L$0).queryTunnelState();
            case 10:
                ResultKt.throwOnFailure(obj);
                try {
                    failure = StringsKt.substringBefore$default(Bridge.INSTANCE.nativeCoreVersion(), '_');
                    break;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (failure instanceof Result.Failure) {
                    return null;
                }
                return failure;
            case 11:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(!((IClashManager) this.L$0).queryProviders().isEmpty());
            case 12:
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                Float f = (Float) pair.first;
                Float f2 = (Float) pair.second;
                if (f != null && f2 != null) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 13:
                ResultKt.throwOnFailure(obj);
                Pair pair2 = (Pair) this.L$0;
                Float f3 = (Float) pair2.first;
                Float f4 = (Float) pair2.second;
                if (f3 != null && f4 != null) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 14:
                ResultKt.throwOnFailure(obj);
                Intent intent = (Intent) this.L$0;
                String action = intent.getAction();
                String str2 = Intents.ACTION_START_CLASH;
                if (Intrinsics.areEqual(action, Intents.ACTION_PROFILE_CHANGED)) {
                    return UUID.fromString(intent.getStringExtra("uuid"));
                }
                return null;
            default:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(((SharingCommand) this.L$0) != SharingCommand.START);
        }
    }
}
