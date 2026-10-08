package com.github.kr328.clash.compose.proxy;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import com.github.kr328.clash.ShareToTvActivity$onCreate$1$list$1$1;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.util.RemoteKt;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.EmptySet;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.ClassReference;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyViewModel extends AndroidViewModel {
    public final StateFlowImpl _configMode;
    public final StateFlowImpl _currentMode;
    public final StateFlowImpl _error;
    public final StateFlowImpl _groupNames;
    public final StateFlowImpl _groups;
    public final StateFlowImpl _isLoading;
    public final StateFlowImpl _isTesting;
    public final StateFlowImpl _modeSwitchAllowed;
    public final StateFlowImpl _proxySort;
    public final StateFlowImpl _selectedGroup;
    public final StateFlowImpl _testedProxies;
    public final StateFlowImpl _testingProxies;
    public final ReadonlyStateFlow configMode;
    public final ReadonlyStateFlow currentMode;
    public final ReadonlyStateFlow error;
    public final MutexImpl groupLoadLock;
    public final ReadonlyStateFlow groupNames;
    public final ReadonlyStateFlow groups;
    public final ReadonlyStateFlow isLoading;
    public final ReadonlyStateFlow isTesting;
    public final ReadonlyStateFlow modeSwitchAllowed;
    public final ReadonlyStateFlow proxySort;
    public final ReadonlyStateFlow selectedGroup;
    public final ReadonlyStateFlow testedProxies;
    public final ReadonlyStateFlow testingProxies;
    public final UiStore uiStore;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Factory implements ViewModelProvider$Factory {
        public final /* synthetic */ int $r8$classId;
        public final Application application;

        public /* synthetic */ Factory(Application application, int i) {
            this.$r8$classId = i;
            this.application = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final /* synthetic */ ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
            int i = this.$r8$classId;
            return create(classReference.getJClass(), mutableCreationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final ViewModel create(Class cls) {
            switch (this.$r8$classId) {
                case 0:
                    return new ProxyViewModel(this.application);
                default:
                    return new NewProfileViewModel(this.application);
            }
        }
    }

    public ProxyViewModel(Application application) {
        super(application);
        UiStore uiStore = new UiStore(application);
        this.uiStore = uiStore;
        this.groupLoadLock = new MutexImpl();
        StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this._groupNames = stateFlowImplMutableStateFlow;
        this.groupNames = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = FlowKt.MutableStateFlow(EmptyMap.INSTANCE);
        this._groups = stateFlowImplMutableStateFlow2;
        this.groups = FlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = FlowKt.MutableStateFlow(null);
        this._selectedGroup = stateFlowImplMutableStateFlow3;
        this.selectedGroup = FlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        StateFlowImpl stateFlowImplMutableStateFlow4 = FlowKt.MutableStateFlow(null);
        this._currentMode = stateFlowImplMutableStateFlow4;
        this.currentMode = FlowKt.asStateFlow(stateFlowImplMutableStateFlow4);
        StateFlowImpl stateFlowImplMutableStateFlow5 = FlowKt.MutableStateFlow(null);
        this._configMode = stateFlowImplMutableStateFlow5;
        this.configMode = FlowKt.asStateFlow(stateFlowImplMutableStateFlow5);
        Boolean bool = Boolean.TRUE;
        StateFlowImpl stateFlowImplMutableStateFlow6 = FlowKt.MutableStateFlow(bool);
        this._modeSwitchAllowed = stateFlowImplMutableStateFlow6;
        this.modeSwitchAllowed = FlowKt.asStateFlow(stateFlowImplMutableStateFlow6);
        KProperty kProperty = UiStore.$$delegatedProperties[6];
        StateFlowImpl stateFlowImplMutableStateFlow7 = FlowKt.MutableStateFlow((ProxySort) uiStore.proxySort$delegate.getValue());
        this._proxySort = stateFlowImplMutableStateFlow7;
        this.proxySort = FlowKt.asStateFlow(stateFlowImplMutableStateFlow7);
        StateFlowImpl stateFlowImplMutableStateFlow8 = FlowKt.MutableStateFlow(bool);
        this._isLoading = stateFlowImplMutableStateFlow8;
        this.isLoading = FlowKt.asStateFlow(stateFlowImplMutableStateFlow8);
        StateFlowImpl stateFlowImplMutableStateFlow9 = FlowKt.MutableStateFlow(Boolean.FALSE);
        this._isTesting = stateFlowImplMutableStateFlow9;
        this.isTesting = FlowKt.asStateFlow(stateFlowImplMutableStateFlow9);
        EmptySet emptySet = EmptySet.INSTANCE;
        StateFlowImpl stateFlowImplMutableStateFlow10 = FlowKt.MutableStateFlow(emptySet);
        this._testingProxies = stateFlowImplMutableStateFlow10;
        this.testingProxies = FlowKt.asStateFlow(stateFlowImplMutableStateFlow10);
        StateFlowImpl stateFlowImplMutableStateFlow11 = FlowKt.MutableStateFlow(emptySet);
        this._testedProxies = stateFlowImplMutableStateFlow11;
        this.testedProxies = FlowKt.asStateFlow(stateFlowImplMutableStateFlow11);
        StateFlowImpl stateFlowImplMutableStateFlow12 = FlowKt.MutableStateFlow(null);
        this._error = stateFlowImplMutableStateFlow12;
        this.error = FlowKt.asStateFlow(stateFlowImplMutableStateFlow12);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$queryModeSwitchAllowed(ProxyViewModel proxyViewModel, ContinuationImpl continuationImpl) {
        ProxyViewModel$queryModeSwitchAllowed$1 proxyViewModel$queryModeSwitchAllowed$1;
        Object failure;
        if (continuationImpl instanceof ProxyViewModel$queryModeSwitchAllowed$1) {
            proxyViewModel$queryModeSwitchAllowed$1 = (ProxyViewModel$queryModeSwitchAllowed$1) continuationImpl;
            int i = proxyViewModel$queryModeSwitchAllowed$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                proxyViewModel$queryModeSwitchAllowed$1.label = i - Integer.MIN_VALUE;
            } else {
                proxyViewModel$queryModeSwitchAllowed$1 = new ProxyViewModel$queryModeSwitchAllowed$1(proxyViewModel, continuationImpl);
            }
        } else {
            proxyViewModel$queryModeSwitchAllowed$1 = new ProxyViewModel$queryModeSwitchAllowed$1(proxyViewModel, continuationImpl);
        }
        Object objWithProfile$default = proxyViewModel$queryModeSwitchAllowed$1.result;
        int i2 = proxyViewModel$queryModeSwitchAllowed$1.label;
        boolean z = false;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithProfile$default);
                ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$1 = new ShareToTvActivity$onCreate$1$list$1$1(2, z ? 1 : 0, 5);
                proxyViewModel$queryModeSwitchAllowed$1.label = 1;
                objWithProfile$default = RemoteKt.withProfile$default(shareToTvActivity$onCreate$1$list$1$1, proxyViewModel$queryModeSwitchAllowed$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithProfile$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithProfile$default);
            }
            failure = (Profile) objWithProfile$default;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        Profile profile = (Profile) (failure instanceof Result.Failure ? null : failure);
        return Boolean.valueOf(profile != null ? profile.modeSwitchAllowed : true);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0097 A[Catch: all -> 0x00d8, TRY_LEAVE, TryCatch #0 {all -> 0x00d8, blocks: (B:41:0x00c6, B:45:0x00d2, B:29:0x0091, B:31:0x0097, B:40:0x00c0, B:48:0x00db, B:44:0x00cd), top: B:54:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cd A[Catch: all -> 0x00d8, TryCatch #0 {all -> 0x00d8, blocks: (B:41:0x00c6, B:45:0x00d2, B:29:0x0091, B:31:0x0097, B:40:0x00c0, B:48:0x00db, B:44:0x00cd), top: B:54:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00ba -> B:36:0x00bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c0 -> B:41:0x00c6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object access$reloadAllGroups(com.github.kr328.clash.compose.proxy.ProxyViewModel r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.compose.proxy.ProxyViewModel.access$reloadAllGroups(com.github.kr328.clash.compose.proxy.ProxyViewModel, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object access$reloadGroup(ProxyViewModel proxyViewModel, String str, ContinuationImpl continuationImpl) {
        ProxyViewModel$reloadGroup$1 proxyViewModel$reloadGroup$1;
        Object failure;
        Object value;
        Map mapSingletonMap;
        proxyViewModel.getClass();
        if (continuationImpl instanceof ProxyViewModel$reloadGroup$1) {
            proxyViewModel$reloadGroup$1 = (ProxyViewModel$reloadGroup$1) continuationImpl;
            int i = proxyViewModel$reloadGroup$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                proxyViewModel$reloadGroup$1.label = i - Integer.MIN_VALUE;
            } else {
                proxyViewModel$reloadGroup$1 = new ProxyViewModel$reloadGroup$1(proxyViewModel, continuationImpl);
            }
        } else {
            proxyViewModel$reloadGroup$1 = new ProxyViewModel$reloadGroup$1(proxyViewModel, continuationImpl);
        }
        Object objWithClash$default = proxyViewModel$reloadGroup$1.result;
        int i2 = proxyViewModel$reloadGroup$1.label;
        boolean z = false;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithClash$default);
                ProxyViewModel$reloadGroup$group$1$1 proxyViewModel$reloadGroup$group$1$1 = new ProxyViewModel$reloadGroup$group$1$1(str, (ProxySort) proxyViewModel._proxySort.getValue(), z ? 1 : 0, 0);
                proxyViewModel$reloadGroup$1.L$0 = proxyViewModel;
                proxyViewModel$reloadGroup$1.L$1 = str;
                proxyViewModel$reloadGroup$1.label = 1;
                objWithClash$default = RemoteKt.withClash$default(proxyViewModel$reloadGroup$group$1$1, proxyViewModel$reloadGroup$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithClash$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = proxyViewModel$reloadGroup$1.L$1;
                proxyViewModel = proxyViewModel$reloadGroup$1.L$0;
                ResultKt.throwOnFailure(objWithClash$default);
            }
            failure = (ProxyGroup) objWithClash$default;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        ProxyGroup proxyGroup = (ProxyGroup) (failure instanceof Result.Failure ? null : failure);
        if (proxyGroup == null) {
            return Unit.INSTANCE;
        }
        StateFlowImpl stateFlowImpl = proxyViewModel._groups;
        do {
            value = stateFlowImpl.getValue();
            Map map = (Map) value;
            if (map.isEmpty()) {
                mapSingletonMap = Collections.singletonMap(str, proxyGroup);
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap(map);
                linkedHashMap.put(str, proxyGroup);
                mapSingletonMap = linkedHashMap;
            }
        } while (!stateFlowImpl.compareAndSet(value, mapSingletonMap));
        return Unit.INSTANCE;
    }
}
