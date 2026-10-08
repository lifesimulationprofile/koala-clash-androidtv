package com.github.kr328.clash;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import coil.RealImageLoader$execute$3;
import com.github.kr328.clash.common.compat.TvKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import com.github.kr328.clash.design.model.AppInfoSort;
import com.github.kr328.clash.design.store.UiStore;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import com.google.android.gms.tasks.zzr;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AccessControlActivity extends AppCompatActivity implements CoroutineScope {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final StateFlowImpl reverseFlow;
    public Set selected;
    public final StateFlowImpl systemAppsFlow;
    public final /* synthetic */ ContextScope $$delegate_0 = JobKt.MainScope();
    public final SynchronizedLazyImpl uiStore$delegate = new SynchronizedLazyImpl(new AccessControlActivity$$ExternalSyntheticLambda0(this, 0));
    public final SynchronizedLazyImpl srvStore$delegate = new SynchronizedLazyImpl(new AccessControlActivity$$ExternalSyntheticLambda0(this, 1));
    public final StateFlowImpl appsFlow = FlowKt.MutableStateFlow(EmptyList.INSTANCE);
    public final StateFlowImpl selectionVersion = FlowKt.MutableStateFlow(0);
    public final StateFlowImpl sortFlow = FlowKt.MutableStateFlow(AppInfoSort.Label);

    /* JADX INFO: renamed from: com.github.kr328.clash.AccessControlActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Function2 {
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ AccessControlActivity this$0;

        public /* synthetic */ AnonymousClass2(AccessControlActivity accessControlActivity, boolean z, int i) {
            this.$r8$classId = i;
            this.this$0 = accessControlActivity;
            this.$isTv = z;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(825127647, new AnonymousClass2(this.this$0, this.$isTv, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        AccessControlActivity accessControlActivity = this.this$0;
                        MutableState mutableStateCollectAsState = Stack.collectAsState(accessControlActivity.appsFlow, gapComposer2, 0);
                        MutableState mutableStateCollectAsState2 = Stack.collectAsState(accessControlActivity.sortFlow, gapComposer2, 0);
                        MutableState mutableStateCollectAsState3 = Stack.collectAsState(accessControlActivity.reverseFlow, gapComposer2, 0);
                        MutableState mutableStateCollectAsState4 = Stack.collectAsState(accessControlActivity.systemAppsFlow, gapComposer2, 0);
                        int iIntValue = ((Number) Stack.collectAsState(accessControlActivity.selectionVersion, gapComposer2, 0).getValue()).intValue();
                        gapComposer2.startReplaceGroup(54631154);
                        boolean zChanged = gapComposer2.changed(iIntValue);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            Set set = accessControlActivity.selected;
                            objRememberedValue = set != null ? CollectionsKt.toSet(set) : EmptySet.INSTANCE;
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        Set set2 = (Set) objRememberedValue;
                        gapComposer2.end(false);
                        List list = (List) mutableStateCollectAsState.getValue();
                        gapComposer2.startReplaceGroup(54639986);
                        boolean zChangedInstance = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new AccessControlActivity$onCreate$2$1$$ExternalSyntheticLambda0(accessControlActivity, 0);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function1 = (Function1) objRememberedValue2;
                        gapComposer2.end(false);
                        AppInfoSort appInfoSort = (AppInfoSort) mutableStateCollectAsState2.getValue();
                        boolean zBooleanValue = ((Boolean) mutableStateCollectAsState3.getValue()).booleanValue();
                        boolean zBooleanValue2 = ((Boolean) mutableStateCollectAsState4.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(54653049);
                        boolean zChangedInstance2 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new AccessControlActivity$onCreate$2$1$$ExternalSyntheticLambda0(accessControlActivity, 1);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        Function1 function2 = (Function1) objRememberedValue3;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(54660456);
                        boolean zChangedInstance3 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new AccessControlActivity$onCreate$2$1$$ExternalSyntheticLambda0(accessControlActivity, 2);
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function3 = (Function1) objRememberedValue4;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(54668548);
                        boolean zChangedInstance4 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new AccessControlActivity$onCreate$2$1$$ExternalSyntheticLambda0(accessControlActivity, 3);
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        Function1 function4 = (Function1) objRememberedValue5;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(54676261);
                        boolean zChangedInstance5 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new AccessControlActivity$$ExternalSyntheticLambda0(accessControlActivity, 2);
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        Function0 function0 = (Function0) objRememberedValue6;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(54686927);
                        boolean zChangedInstance6 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                        if (zChangedInstance6 || objRememberedValue7 == neverEqualPolicy) {
                            objRememberedValue7 = new AccessControlActivity$$ExternalSyntheticLambda0(accessControlActivity, 3);
                            gapComposer2.updateRememberedValue(objRememberedValue7);
                        }
                        Function0 function5 = (Function0) objRememberedValue7;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(54695190);
                        boolean zChangedInstance7 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue8 == neverEqualPolicy) {
                            objRememberedValue8 = new AccessControlActivity$$ExternalSyntheticLambda0(accessControlActivity, 4);
                            gapComposer2.updateRememberedValue(objRememberedValue8);
                        }
                        Function0 function6 = (Function0) objRememberedValue8;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(54709782);
                        boolean zChangedInstance8 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        if (zChangedInstance8 || objRememberedValue9 == neverEqualPolicy) {
                            objRememberedValue9 = new AccessControlActivity$$ExternalSyntheticLambda0(accessControlActivity, 5);
                            gapComposer2.updateRememberedValue(objRememberedValue9);
                        }
                        Function0 function7 = (Function0) objRememberedValue9;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(54734965);
                        boolean zChangedInstance9 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue10 = gapComposer2.rememberedValue();
                        if (zChangedInstance9 || objRememberedValue10 == neverEqualPolicy) {
                            objRememberedValue10 = new AccessControlActivity$$ExternalSyntheticLambda0(accessControlActivity, 6);
                            gapComposer2.updateRememberedValue(objRememberedValue10);
                        }
                        Function0 function8 = (Function0) objRememberedValue10;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(54749958);
                        boolean zChangedInstance10 = gapComposer2.changedInstance(accessControlActivity);
                        Object objRememberedValue11 = gapComposer2.rememberedValue();
                        if (zChangedInstance10 || objRememberedValue11 == neverEqualPolicy) {
                            objRememberedValue11 = new AccessControlActivity$$ExternalSyntheticLambda0(accessControlActivity, 7);
                            gapComposer2.updateRememberedValue(objRememberedValue11);
                        }
                        gapComposer2.end(false);
                        int i = 2;
                        zzjb.AccessControlScreen(list, set2, function1, appInfoSort, zBooleanValue, zBooleanValue2, function2, function3, function4, function0, function5, function6, function7, function8, (Function0) objRememberedValue11, null, this.$isTv, gapComposer2, 0);
                        Unit unit = Unit.INSTANCE;
                        gapComposer2.startReplaceGroup(54753274);
                        Object objRememberedValue12 = gapComposer2.rememberedValue();
                        if (objRememberedValue12 == neverEqualPolicy) {
                            objRememberedValue12 = new UpdateChecker$check$2(i, null, 3);
                            gapComposer2.updateRememberedValue(objRememberedValue12);
                        }
                        gapComposer2.end(false);
                        Stack.LaunchedEffect(gapComposer2, unit, (Function2) objRememberedValue12);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public AccessControlActivity() {
        Boolean bool = Boolean.FALSE;
        this.reverseFlow = FlowKt.MutableStateFlow(bool);
        this.systemAppsFlow = FlowKt.MutableStateFlow(bool);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$reloadApps(AccessControlActivity accessControlActivity, ContinuationImpl continuationImpl) throws Throwable {
        AccessControlActivity$reloadApps$1 accessControlActivity$reloadApps$1;
        if (continuationImpl instanceof AccessControlActivity$reloadApps$1) {
            accessControlActivity$reloadApps$1 = (AccessControlActivity$reloadApps$1) continuationImpl;
            int i = accessControlActivity$reloadApps$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                accessControlActivity$reloadApps$1.label = i - Integer.MIN_VALUE;
            } else {
                accessControlActivity$reloadApps$1 = new AccessControlActivity$reloadApps$1(accessControlActivity, continuationImpl);
            }
        } else {
            accessControlActivity$reloadApps$1 = new AccessControlActivity$reloadApps$1(accessControlActivity, continuationImpl);
        }
        Object objWithContext = accessControlActivity$reloadApps$1.result;
        int i2 = accessControlActivity$reloadApps$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            AccessControlActivity$finish$1$2 accessControlActivity$finish$1$2 = new AccessControlActivity$finish$1$2(accessControlActivity, null, 2);
            accessControlActivity$reloadApps$1.L$0 = accessControlActivity;
            accessControlActivity$reloadApps$1.label = 1;
            objWithContext = JobKt.withContext(defaultIoScheduler, accessControlActivity$finish$1$2, accessControlActivity$reloadApps$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            accessControlActivity = accessControlActivity$reloadApps$1.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        accessControlActivity.appsFlow.setValue((List) objWithContext);
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    public final void finish() {
        if (this.selected == null) {
            super.finish();
        } else {
            JobKt.launch$default(this, null, new RealImageLoader$execute$3(this, (Continuation) null, 29), 3);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    public final UiStore getUiStore() {
        return (UiStore) this.uiStore$delegate.getValue();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Dispatcher dispatcher = getUiStore().accessControlSort$delegate;
        KProperty[] kPropertyArr = UiStore.$$delegatedProperties;
        KProperty kProperty = kPropertyArr[8];
        AppInfoSort appInfoSort = (AppInfoSort) dispatcher.getValue();
        StateFlowImpl stateFlowImpl = this.sortFlow;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, appInfoSort);
        zzr zzrVar = getUiStore().accessControlReverse$delegate;
        KProperty kProperty2 = kPropertyArr[9];
        Boolean bool = (Boolean) zzrVar.getValue();
        StateFlowImpl stateFlowImpl2 = this.reverseFlow;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, bool);
        zzr zzrVar2 = getUiStore().accessControlSystemApp$delegate;
        KProperty kProperty3 = kPropertyArr[10];
        Boolean bool2 = (Boolean) zzrVar2.getValue();
        StateFlowImpl stateFlowImpl3 = this.systemAppsFlow;
        stateFlowImpl3.getClass();
        stateFlowImpl3.updateState(null, bool2);
        JobKt.launch$default(this, null, new FilesActivity$showError$1(this, null, 1), 3);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(-632857495, new AnonymousClass2(this, TvKt.isTvDevice(this), 0), true));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public final void onDestroy() {
        JobKt.cancel(this, (CancellationException) null);
        super.onDestroy();
    }
}
