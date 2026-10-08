package com.github.kr328.clash.compose.proxy;

import com.github.kr328.clash.LogcatActivity$writeLogTo$2$1;
import com.github.kr328.clash.PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IClashManager;
import com.github.kr328.clash.service.remote.IProfileManager;
import com.github.kr328.clash.util.RemoteKt;
import java.util.Set;
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
public final class ProxyViewModel$testProxy$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $group;
    public final /* synthetic */ String $proxyName;
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ ProxyViewModel this$0;

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.proxy.ProxyViewModel$testProxy$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ String $group;
        public final /* synthetic */ String $proxyName;
        public final /* synthetic */ int $r8$classId;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(String str, String str2, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.$group = str;
            this.$proxyName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$group, this.$proxyName, continuation, 0);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 1:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(this.$group, this.$proxyName, continuation, 1);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                default:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(this.$group, this.$proxyName, continuation, 2);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    return ((AnonymousClass2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 1:
                    return ((AnonymousClass2) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                default:
                    return ((AnonymousClass2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        IClashManager iClashManager = (IClashManager) this.L$0;
                        this.label = 1;
                        Object objHealthCheckProxy = iClashManager.healthCheckProxy(this.$group, this.$proxyName, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objHealthCheckProxy == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                case 1:
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
                    PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0 propertiesActivity$commit$4$1$$ExternalSyntheticLambda0 = new PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0();
                    this.label = 1;
                    Object objMo811import = iProfileManager.mo811import(Profile.Type.Url, this.$group, this.$proxyName, 0L, propertiesActivity$commit$4$1$$ExternalSyntheticLambda0, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    return objMo811import == coroutineSingletons2 ? coroutineSingletons2 : objMo811import;
                default:
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        IClashManager iClashManager2 = (IClashManager) this.L$0;
                        this.label = 1;
                        Object objHealthCheckProxy2 = iClashManager2.healthCheckProxy(this.$group, this.$proxyName, this);
                        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objHealthCheckProxy2 == coroutineSingletons3) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProxyViewModel$testProxy$1(ProxyViewModel proxyViewModel, String str, String str2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = proxyViewModel;
        this.$group = str;
        this.$proxyName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ProxyViewModel$testProxy$1(this.this$0, this.$group, this.$proxyName, continuation, 0);
            case 1:
                return new ProxyViewModel$testProxy$1(this.this$0, this.$group, this.$proxyName, continuation, 1);
            default:
                return new ProxyViewModel$testProxy$1(this.this$0, this.$group, this.$proxyName, continuation, 2);
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
        return ((ProxyViewModel$testProxy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        Object value2;
        Object value3;
        StateFlowImpl stateFlowImpl;
        Object value4;
        StateFlowImpl stateFlowImpl2;
        Object value5;
        Object value6;
        Object value7;
        Object value8;
        Object value9;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                String str = this.$group;
                String str2 = this.$proxyName;
                ProxyViewModel proxyViewModel = this.this$0;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                try {
                    if (i != 0) {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        stateFlowImpl = proxyViewModel._testedProxies;
                        do {
                            value4 = stateFlowImpl.getValue();
                            break;
                        } while (!stateFlowImpl.compareAndSet(value4, SetsKt.plus((Set) value4, str2)));
                        stateFlowImpl2 = proxyViewModel._testingProxies;
                        do {
                            value5 = stateFlowImpl2.getValue();
                        } while (!stateFlowImpl2.compareAndSet(value5, SetsKt.minus((Set) value5, str2)));
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    StateFlowImpl stateFlowImpl3 = proxyViewModel._testingProxies;
                    do {
                        value3 = stateFlowImpl3.getValue();
                    } while (!stateFlowImpl3.compareAndSet(value3, SetsKt.plus((Set) value3, str2)));
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, str2, null, 0);
                    this.label = 1;
                    if (RemoteKt.withClash$default(anonymousClass2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    this.label = 2;
                    if (ProxyViewModel.access$reloadGroup(proxyViewModel, str, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    stateFlowImpl = proxyViewModel._testedProxies;
                    do {
                        value4 = stateFlowImpl.getValue();
                        break;
                    } while (!stateFlowImpl.compareAndSet(value4, SetsKt.plus((Set) value4, str2)));
                    stateFlowImpl2 = proxyViewModel._testingProxies;
                    do {
                        value5 = stateFlowImpl2.getValue();
                    } while (!stateFlowImpl2.compareAndSet(value5, SetsKt.minus((Set) value5, str2)));
                } catch (Exception unused) {
                    StateFlowImpl stateFlowImpl4 = proxyViewModel._testingProxies;
                    do {
                        value2 = stateFlowImpl4.getValue();
                    } while (!stateFlowImpl4.compareAndSet(value2, SetsKt.minus((Set) value2, str2)));
                } catch (Throwable th) {
                    StateFlowImpl stateFlowImpl5 = proxyViewModel._testingProxies;
                    do {
                        value = stateFlowImpl5.getValue();
                    } while (!stateFlowImpl5.compareAndSet(value, SetsKt.minus((Set) value, str2)));
                    throw th;
                }
                return Unit.INSTANCE;
            case 1:
                int i2 = this.label;
                String str3 = this.$group;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i2 != 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$1 = new LogcatActivity$writeLogTo$2$1(str3, this.$proxyName, null, 7);
                this.label = 1;
                if (RemoteKt.withClash$default(logcatActivity$writeLogTo$2$1, this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                this.label = 2;
                if (ProxyViewModel.access$reloadGroup(this.this$0, str3, this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                ProxyViewModel proxyViewModel2 = this.this$0;
                String str4 = this.$proxyName;
                try {
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        AnonymousClass2 anonymousClass3 = new AnonymousClass2(this.$group, str4, null, 2);
                        this.label = 1;
                        Object objWithClash$default = RemoteKt.withClash$default(anonymousClass3, this);
                        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objWithClash$default == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    StateFlowImpl stateFlowImpl6 = proxyViewModel2._testedProxies;
                    do {
                        value8 = stateFlowImpl6.getValue();
                        break;
                    } while (!stateFlowImpl6.compareAndSet(value8, SetsKt.plus((Set) value8, str4)));
                    StateFlowImpl stateFlowImpl7 = proxyViewModel2._testingProxies;
                    do {
                        value9 = stateFlowImpl7.getValue();
                    } while (!stateFlowImpl7.compareAndSet(value9, SetsKt.minus((Set) value9, str4)));
                } catch (Exception unused2) {
                    StateFlowImpl stateFlowImpl8 = proxyViewModel2._testingProxies;
                    do {
                        value7 = stateFlowImpl8.getValue();
                    } while (!stateFlowImpl8.compareAndSet(value7, SetsKt.minus((Set) value7, str4)));
                } catch (Throwable th2) {
                    StateFlowImpl stateFlowImpl9 = proxyViewModel2._testingProxies;
                    do {
                        value6 = stateFlowImpl9.getValue();
                    } while (!stateFlowImpl9.compareAndSet(value6, SetsKt.minus((Set) value6, str4)));
                    throw th2;
                }
                return Unit.INSTANCE;
        }
    }
}
