package com.github.kr328.clash.compose.proxy;

import android.content.SharedPreferences;
import androidx.compose.runtime.Recomposer$join$2;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.util.RemoteKt;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyViewModel$reload$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public TunnelState.Mode L$0;
    public int label;
    public final /* synthetic */ ProxyViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProxyViewModel$reload$1(ProxyViewModel proxyViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = proxyViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ProxyViewModel$reload$1(this.this$0, continuation);
            default:
                return new ProxyViewModel$reload$1(this.L$0, this.this$0, continuation);
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
        return ((ProxyViewModel$reload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b8 A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:25:0x005f, B:31:0x006f, B:63:0x00f8, B:65:0x0104, B:67:0x010f, B:69:0x0115, B:70:0x0119, B:72:0x011f, B:76:0x014f, B:78:0x0153, B:79:0x015a, B:80:0x015d, B:32:0x0074, B:57:0x00d0, B:59:0x00e2, B:60:0x00e8, B:35:0x007a, B:45:0x00ad, B:48:0x00b2, B:50:0x00b8, B:51:0x00bb, B:53:0x00c1, B:54:0x00c4, B:36:0x007e, B:42:0x0096, B:39:0x0085), top: B:89:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c1 A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:25:0x005f, B:31:0x006f, B:63:0x00f8, B:65:0x0104, B:67:0x010f, B:69:0x0115, B:70:0x0119, B:72:0x011f, B:76:0x014f, B:78:0x0153, B:79:0x015a, B:80:0x015d, B:32:0x0074, B:57:0x00d0, B:59:0x00e2, B:60:0x00e8, B:35:0x007a, B:45:0x00ad, B:48:0x00b2, B:50:0x00b8, B:51:0x00bb, B:53:0x00c1, B:54:0x00c4, B:36:0x007e, B:42:0x0096, B:39:0x0085), top: B:89:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e2 A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:25:0x005f, B:31:0x006f, B:63:0x00f8, B:65:0x0104, B:67:0x010f, B:69:0x0115, B:70:0x0119, B:72:0x011f, B:76:0x014f, B:78:0x0153, B:79:0x015a, B:80:0x015d, B:32:0x0074, B:57:0x00d0, B:59:0x00e2, B:60:0x00e8, B:35:0x007a, B:45:0x00ad, B:48:0x00b2, B:50:0x00b8, B:51:0x00bb, B:53:0x00c1, B:54:0x00c4, B:36:0x007e, B:42:0x0096, B:39:0x0085), top: B:89:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:65:0x0104 A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:25:0x005f, B:31:0x006f, B:63:0x00f8, B:65:0x0104, B:67:0x010f, B:69:0x0115, B:70:0x0119, B:72:0x011f, B:76:0x014f, B:78:0x0153, B:79:0x015a, B:80:0x015d, B:32:0x0074, B:57:0x00d0, B:59:0x00e2, B:60:0x00e8, B:35:0x007a, B:45:0x00ad, B:48:0x00b2, B:50:0x00b8, B:51:0x00bb, B:53:0x00c1, B:54:0x00c4, B:36:0x007e, B:42:0x0096, B:39:0x0085), top: B:89:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x010f A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:25:0x005f, B:31:0x006f, B:63:0x00f8, B:65:0x0104, B:67:0x010f, B:69:0x0115, B:70:0x0119, B:72:0x011f, B:76:0x014f, B:78:0x0153, B:79:0x015a, B:80:0x015d, B:32:0x0074, B:57:0x00d0, B:59:0x00e2, B:60:0x00e8, B:35:0x007a, B:45:0x00ad, B:48:0x00b2, B:50:0x00b8, B:51:0x00bb, B:53:0x00c1, B:54:0x00c4, B:36:0x007e, B:42:0x0096, B:39:0x0085), top: B:89:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0115 A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:25:0x005f, B:31:0x006f, B:63:0x00f8, B:65:0x0104, B:67:0x010f, B:69:0x0115, B:70:0x0119, B:72:0x011f, B:76:0x014f, B:78:0x0153, B:79:0x015a, B:80:0x015d, B:32:0x0074, B:57:0x00d0, B:59:0x00e2, B:60:0x00e8, B:35:0x007a, B:45:0x00ad, B:48:0x00b2, B:50:0x00b8, B:51:0x00bb, B:53:0x00c1, B:54:0x00c4, B:36:0x007e, B:42:0x0096, B:39:0x0085), top: B:89:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x011f A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:25:0x005f, B:31:0x006f, B:63:0x00f8, B:65:0x0104, B:67:0x010f, B:69:0x0115, B:70:0x0119, B:72:0x011f, B:76:0x014f, B:78:0x0153, B:79:0x015a, B:80:0x015d, B:32:0x0074, B:57:0x00d0, B:59:0x00e2, B:60:0x00e8, B:35:0x007a, B:45:0x00ad, B:48:0x00b2, B:50:0x00b8, B:51:0x00bb, B:53:0x00c1, B:54:0x00c4, B:36:0x007e, B:42:0x0096, B:39:0x0085), top: B:89:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0153 A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:25:0x005f, B:31:0x006f, B:63:0x00f8, B:65:0x0104, B:67:0x010f, B:69:0x0115, B:70:0x0119, B:72:0x011f, B:76:0x014f, B:78:0x0153, B:79:0x015a, B:80:0x015d, B:32:0x0074, B:57:0x00d0, B:59:0x00e2, B:60:0x00e8, B:35:0x007a, B:45:0x00ad, B:48:0x00b2, B:50:0x00b8, B:51:0x00bb, B:53:0x00c1, B:54:0x00c4, B:36:0x007e, B:42:0x0096, B:39:0x0085), top: B:89:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x014e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TunnelState.Mode mode;
        TunnelState.Mode mode2;
        Boolean bool;
        List list;
        String str;
        Iterator it;
        Object next;
        String str2;
        ImageLoader$Builder imageLoader$Builder;
        switch (this.$r8$classId) {
            case 0:
                ProxyViewModel proxyViewModel = this.this$0;
                StateFlowImpl stateFlowImpl = proxyViewModel._selectedGroup;
                StateFlowImpl stateFlowImpl2 = proxyViewModel._groupNames;
                StateFlowImpl stateFlowImpl3 = proxyViewModel._modeSwitchAllowed;
                StateFlowImpl stateFlowImpl4 = proxyViewModel._configMode;
                StateFlowImpl stateFlowImpl5 = proxyViewModel._currentMode;
                int i = this.label;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                try {
                    if (i != 0) {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else if (i == 2) {
                            mode = this.L$0;
                            ResultKt.throwOnFailure(obj);
                            mode2 = (TunnelState.Mode) obj;
                            if (mode2 == null) {
                                mode2 = mode;
                            }
                            if (stateFlowImpl5.getValue() != mode) {
                                stateFlowImpl5.setValue(mode);
                            }
                            if (stateFlowImpl4.getValue() != mode2) {
                                stateFlowImpl4.setValue(mode2);
                            }
                            this.L$0 = null;
                            this.label = 3;
                            obj = ProxyViewModel.access$queryModeSwitchAllowed(proxyViewModel, this);
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            bool = (Boolean) obj;
                            if (((Boolean) stateFlowImpl3.getValue()).booleanValue() != bool.booleanValue()) {
                                stateFlowImpl3.getClass();
                                stateFlowImpl3.updateState(null, bool);
                            }
                            ProxyViewModel$load$1$names$1 proxyViewModel$load$1$names$1 = new ProxyViewModel$load$1$names$1(proxyViewModel, null, 1);
                            this.label = 4;
                            obj = RemoteKt.withClash$default(proxyViewModel$load$1$names$1, this);
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            list = (List) obj;
                            if (!Intrinsics.areEqual(list, stateFlowImpl2.getValue())) {
                                stateFlowImpl2.setValue(list);
                                str = (String) stateFlowImpl.getValue();
                                if (str != null) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            imageLoader$Builder = proxyViewModel.uiStore.proxyLastGroup$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[7];
                                        } else {
                                            next = null;
                                        }
                                        str2 = (String) next;
                                        if (str2 == null) {
                                            str2 = (String) CollectionsKt.firstOrNull(list);
                                        }
                                        stateFlowImpl.setValue(str2);
                                    } while (!Intrinsics.areEqual((String) next, ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries).imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options)));
                                    str2 = (String) next;
                                    if (str2 == null) {
                                        str2 = (String) CollectionsKt.firstOrNull(list);
                                    }
                                    stateFlowImpl.setValue(str2);
                                } else {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            imageLoader$Builder = proxyViewModel.uiStore.proxyLastGroup$delegate;
                                            KProperty kProperty2 = UiStore.$$delegatedProperties[7];
                                        } else {
                                            next = null;
                                        }
                                        str2 = (String) next;
                                        if (str2 == null) {
                                            str2 = (String) CollectionsKt.firstOrNull(list);
                                        }
                                        stateFlowImpl.setValue(str2);
                                    } while (!Intrinsics.areEqual((String) next, ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries).imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options)));
                                    str2 = (String) next;
                                    if (str2 == null) {
                                        str2 = (String) CollectionsKt.firstOrNull(list);
                                    }
                                    stateFlowImpl.setValue(str2);
                                }
                            }
                            this.label = 5;
                            if (ProxyViewModel.access$reloadAllGroups(proxyViewModel, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            bool = (Boolean) obj;
                            if (((Boolean) stateFlowImpl3.getValue()).booleanValue() != bool.booleanValue()) {
                                stateFlowImpl3.getClass();
                                stateFlowImpl3.updateState(null, bool);
                            }
                            ProxyViewModel$load$1$names$1 proxyViewModel$load$1$names$2 = new ProxyViewModel$load$1$names$1(proxyViewModel, null, 1);
                            this.label = 4;
                            obj = RemoteKt.withClash$default(proxyViewModel$load$1$names$2, this);
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            list = (List) obj;
                            if (!Intrinsics.areEqual(list, stateFlowImpl2.getValue())) {
                                stateFlowImpl2.setValue(list);
                                str = (String) stateFlowImpl.getValue();
                                if (str != null) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            imageLoader$Builder = proxyViewModel.uiStore.proxyLastGroup$delegate;
                                            KProperty kProperty3 = UiStore.$$delegatedProperties[7];
                                        } else {
                                            next = null;
                                        }
                                        str2 = (String) next;
                                        if (str2 == null) {
                                            str2 = (String) CollectionsKt.firstOrNull(list);
                                        }
                                        stateFlowImpl.setValue(str2);
                                    } while (!Intrinsics.areEqual((String) next, ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries).imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options)));
                                    str2 = (String) next;
                                    if (str2 == null) {
                                        str2 = (String) CollectionsKt.firstOrNull(list);
                                    }
                                    stateFlowImpl.setValue(str2);
                                } else {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            imageLoader$Builder = proxyViewModel.uiStore.proxyLastGroup$delegate;
                                            KProperty kProperty4 = UiStore.$$delegatedProperties[7];
                                        } else {
                                            next = null;
                                        }
                                        str2 = (String) next;
                                        if (str2 == null) {
                                            str2 = (String) CollectionsKt.firstOrNull(list);
                                        }
                                        stateFlowImpl.setValue(str2);
                                    } while (!Intrinsics.areEqual((String) next, ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries).imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options)));
                                    str2 = (String) next;
                                    if (str2 == null) {
                                        str2 = (String) CollectionsKt.firstOrNull(list);
                                    }
                                    stateFlowImpl.setValue(str2);
                                }
                            }
                            this.label = 5;
                            if (ProxyViewModel.access$reloadAllGroups(proxyViewModel, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else if (i == 4) {
                            ResultKt.throwOnFailure(obj);
                            list = (List) obj;
                            if (!Intrinsics.areEqual(list, stateFlowImpl2.getValue())) {
                                stateFlowImpl2.setValue(list);
                                str = (String) stateFlowImpl.getValue();
                                if (str != null || !list.contains(str)) {
                                    it = list.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            imageLoader$Builder = proxyViewModel.uiStore.proxyLastGroup$delegate;
                                            KProperty kProperty5 = UiStore.$$delegatedProperties[7];
                                        } else {
                                            next = null;
                                        }
                                        str2 = (String) next;
                                        if (str2 == null) {
                                            str2 = (String) CollectionsKt.firstOrNull(list);
                                        }
                                        stateFlowImpl.setValue(str2);
                                    } while (!Intrinsics.areEqual((String) next, ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries).imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options)));
                                    str2 = (String) next;
                                    if (str2 == null) {
                                        str2 = (String) CollectionsKt.firstOrNull(list);
                                    }
                                    stateFlowImpl.setValue(str2);
                                }
                            }
                            this.label = 5;
                            if (ProxyViewModel.access$reloadAllGroups(proxyViewModel, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, null, 9);
                    this.label = 1;
                    obj = RemoteKt.withClash$default(recomposer$join$2, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    mode = ((TunnelState) obj).mode;
                    Recomposer$join$2 recomposer$join$3 = new Recomposer$join$2(2, null, 8);
                    this.L$0 = mode;
                    this.label = 2;
                    obj = RemoteKt.withClash$default(recomposer$join$3, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    mode2 = (TunnelState.Mode) obj;
                    if (mode2 == null) {
                        mode2 = mode;
                    }
                    if (stateFlowImpl5.getValue() != mode) {
                        stateFlowImpl5.setValue(mode);
                    }
                    if (stateFlowImpl4.getValue() != mode2) {
                        stateFlowImpl4.setValue(mode2);
                    }
                    this.L$0 = null;
                    this.label = 3;
                    obj = ProxyViewModel.access$queryModeSwitchAllowed(proxyViewModel, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    bool = (Boolean) obj;
                    if (((Boolean) stateFlowImpl3.getValue()).booleanValue() != bool.booleanValue()) {
                        stateFlowImpl3.getClass();
                        stateFlowImpl3.updateState(null, bool);
                    }
                    ProxyViewModel$load$1$names$1 proxyViewModel$load$1$names$3 = new ProxyViewModel$load$1$names$1(proxyViewModel, null, 1);
                    this.label = 4;
                    obj = RemoteKt.withClash$default(proxyViewModel$load$1$names$3, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    list = (List) obj;
                    if (!Intrinsics.areEqual(list, stateFlowImpl2.getValue())) {
                        stateFlowImpl2.setValue(list);
                        str = (String) stateFlowImpl.getValue();
                        if (str != null) {
                            it = list.iterator();
                            do {
                                if (it.hasNext()) {
                                    next = it.next();
                                    imageLoader$Builder = proxyViewModel.uiStore.proxyLastGroup$delegate;
                                    KProperty kProperty6 = UiStore.$$delegatedProperties[7];
                                } else {
                                    next = null;
                                }
                                str2 = (String) next;
                                if (str2 == null) {
                                    str2 = (String) CollectionsKt.firstOrNull(list);
                                }
                                stateFlowImpl.setValue(str2);
                            } while (!Intrinsics.areEqual((String) next, ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries).imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options)));
                            str2 = (String) next;
                            if (str2 == null) {
                                str2 = (String) CollectionsKt.firstOrNull(list);
                            }
                            stateFlowImpl.setValue(str2);
                        } else {
                            it = list.iterator();
                            do {
                                if (it.hasNext()) {
                                    next = it.next();
                                    imageLoader$Builder = proxyViewModel.uiStore.proxyLastGroup$delegate;
                                    KProperty kProperty7 = UiStore.$$delegatedProperties[7];
                                } else {
                                    next = null;
                                }
                                str2 = (String) next;
                                if (str2 == null) {
                                    str2 = (String) CollectionsKt.firstOrNull(list);
                                }
                                stateFlowImpl.setValue(str2);
                            } while (!Intrinsics.areEqual((String) next, ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries).imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options)));
                            str2 = (String) next;
                            if (str2 == null) {
                                str2 = (String) CollectionsKt.firstOrNull(list);
                            }
                            stateFlowImpl.setValue(str2);
                        }
                    }
                    this.label = 5;
                    if (ProxyViewModel.access$reloadAllGroups(proxyViewModel, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (Exception e) {
                    StateFlowImpl stateFlowImpl6 = proxyViewModel._error;
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    stateFlowImpl6.getClass();
                    stateFlowImpl6.updateState(null, message);
                }
                return Unit.INSTANCE;
            default:
                TunnelState.Mode mode3 = this.L$0;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Continuation continuation = null;
                    if (mode3 == this.this$0._configMode.getValue()) {
                        mode3 = null;
                    }
                    InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(mode3, continuation, 6);
                    this.label = 1;
                    Object objWithClash$default = RemoteKt.withClash$default(interruptibleKt$runInterruptible$2, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWithClash$default == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProxyViewModel$reload$1(TunnelState.Mode mode, ProxyViewModel proxyViewModel, Continuation continuation) {
        super(2, continuation);
        this.L$0 = mode;
        this.this$0 = proxyViewModel;
    }
}
