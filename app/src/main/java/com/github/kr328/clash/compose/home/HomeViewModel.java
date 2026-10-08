package com.github.kr328.clash.compose.home;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.design.compose.components.ControlButtonState;
import com.github.kr328.clash.remote.Remote;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel extends AndroidViewModel {
    public final StateFlowImpl _activeProfile;
    public final StateFlowImpl _currentProxy;
    public final StateFlowImpl _loaded;
    public final StateFlowImpl _tunnelStartedAt;
    public final StateFlowImpl _tunnelState;
    public final ReadonlyStateFlow activeProfile;
    public final ReadonlyStateFlow currentProxy;
    public final ReadonlyStateFlow loaded;
    public final HomeViewModel$observer$1 observer;
    public StandaloneCoroutine proxyTickerJob;
    public StandaloneCoroutine transitionWatchdog;
    public final ReadonlyStateFlow tunnelStartedAt;
    public final ReadonlyStateFlow tunnelState;

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.home.HomeViewModel$startProxyTicker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public int I$0;
        public /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = HomeViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0038 A[PHI: r1 r6
          0x0038: PHI (r1v7 int) = (r1v1 int), (r1v4 int), (r1v9 int) binds: [B:14:0x002f, B:35:0x0082, B:6:0x0011] A[DONT_GENERATE, DONT_INLINE]
          0x0038: PHI (r6v4 kotlinx.coroutines.CoroutineScope) = 
          (r6v0 kotlinx.coroutines.CoroutineScope)
          (r6v2 kotlinx.coroutines.CoroutineScope)
          (r6v8 kotlinx.coroutines.CoroutineScope)
         binds: [B:14:0x002f, B:35:0x0082, B:6:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:17:0x003e A[Catch: all -> 0x002d, TRY_ENTER, TryCatch #0 {all -> 0x002d, blocks: (B:17:0x003e, B:20:0x0051, B:10:0x0029), top: B:39:0x0029 }] */
        /* JADX WARN: Code duplicated, block: B:19:0x0050  */
        /* JADX WARN: Code duplicated, block: B:20:0x0051 A[Catch: all -> 0x002d, PHI: r1 r6 r10
          0x0051: PHI (r1v6 int) = (r1v7 int), (r1v8 int) binds: [B:18:0x004e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE]
          0x0051: PHI (r6v3 kotlinx.coroutines.CoroutineScope) = (r6v4 kotlinx.coroutines.CoroutineScope), (r6v6 kotlinx.coroutines.CoroutineScope) binds: [B:18:0x004e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE]
          0x0051: PHI (r10v10 java.lang.Object) = (r10v15 java.lang.Object), (r10v0 java.lang.Object) binds: [B:18:0x004e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x002d, blocks: (B:17:0x003e, B:20:0x0051, B:10:0x0029), top: B:39:0x0029 }] */
        /* JADX WARN: Code duplicated, block: B:25:0x005f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0064  */
        /* JADX WARN: Code duplicated, block: B:29:0x006c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:30:0x006e  */
        /* JADX WARN: Code duplicated, block: B:32:0x0073  */
        /* JADX WARN: Code duplicated, block: B:33:0x0076  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0082 -> B:15:0x0038). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                com.github.kr328.clash.compose.home.HomeViewModel r0 = com.github.kr328.clash.compose.home.HomeViewModel.this
                kotlinx.coroutines.flow.StateFlowImpl r0 = r0._currentProxy
                int r1 = r9.label
                r2 = 2
                r3 = 1
                r4 = 0
                kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                int r1 = r9.I$0
                java.lang.Object r6 = r9.L$0
                kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
                kotlin.ResultKt.throwOnFailure(r10)
                goto L38
            L1b:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L23:
                int r1 = r9.I$0
                java.lang.Object r6 = r9.L$0
                kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L2d
                goto L51
            L2d:
                r10 = move-exception
                goto L54
            L2f:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
                r1 = 0
                r6 = r10
            L38:
                boolean r10 = kotlinx.coroutines.JobKt.isActive(r6)
                if (r10 == 0) goto L85
                androidx.compose.runtime.Recomposer$join$2 r10 = new androidx.compose.runtime.Recomposer$join$2     // Catch: java.lang.Throwable -> L2d
                r7 = 5
                r10.<init>(r2, r4, r7)     // Catch: java.lang.Throwable -> L2d
                r9.L$0 = r6     // Catch: java.lang.Throwable -> L2d
                r9.I$0 = r1     // Catch: java.lang.Throwable -> L2d
                r9.label = r3     // Catch: java.lang.Throwable -> L2d
                java.lang.Object r10 = com.github.kr328.clash.util.RemoteKt.withClash$default(r10, r9)     // Catch: java.lang.Throwable -> L2d
                if (r10 != r5) goto L51
                goto L84
            L51:
                java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L2d
                goto L5a
            L54:
                kotlin.Result$Failure r7 = new kotlin.Result$Failure
                r7.<init>(r10)
                r10 = r7
            L5a:
                boolean r7 = r10 instanceof kotlin.Result.Failure
                if (r7 == 0) goto L60
                r10 = r4
            L60:
                java.lang.String r10 = (java.lang.String) r10
                if (r10 == 0) goto L6c
                r0.getClass()
                r0.updateState(r4, r10)
                r1 = r3
                goto L71
            L6c:
                if (r1 == 0) goto L71
                r0.setValue(r4)
            L71:
                if (r1 == 0) goto L76
                r7 = 1500(0x5dc, double:7.41E-321)
                goto L78
            L76:
                r7 = 120(0x78, double:5.93E-322)
            L78:
                r9.L$0 = r6
                r9.I$0 = r1
                r9.label = r2
                java.lang.Object r10 = kotlinx.coroutines.JobKt.delay(r7, r9)
                if (r10 != r5) goto L38
            L84:
                return r5
            L85:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.compose.home.HomeViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public HomeViewModel(Application application) {
        super(application);
        DiskLruCache.Editor editor = Remote.broadcasts;
        StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow(editor.closed ? ControlButtonState.Connected : ControlButtonState.Disconnected);
        this._tunnelState = stateFlowImplMutableStateFlow;
        this.tunnelState = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = FlowKt.MutableStateFlow(null);
        this._activeProfile = stateFlowImplMutableStateFlow2;
        this.activeProfile = FlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = FlowKt.MutableStateFlow(Boolean.FALSE);
        this._loaded = stateFlowImplMutableStateFlow3;
        this.loaded = FlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        StateFlowImpl stateFlowImplMutableStateFlow4 = FlowKt.MutableStateFlow(null);
        this._currentProxy = stateFlowImplMutableStateFlow4;
        this.currentProxy = FlowKt.asStateFlow(stateFlowImplMutableStateFlow4);
        StateFlowImpl stateFlowImplMutableStateFlow5 = FlowKt.MutableStateFlow(null);
        this._tunnelStartedAt = stateFlowImplMutableStateFlow5;
        this.tunnelStartedAt = FlowKt.asStateFlow(stateFlowImplMutableStateFlow5);
        HomeViewModel$observer$1 homeViewModel$observer$1 = new HomeViewModel$observer$1(0, this);
        this.observer = homeViewModel$observer$1;
        editor.addObserver(homeViewModel$observer$1);
        refreshActiveProfile();
        if (editor.closed) {
            stateFlowImplMutableStateFlow5.updateState(null, Long.valueOf(System.currentTimeMillis()));
            startProxyTicker();
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        Remote.broadcasts.removeObserver(this.observer);
        StandaloneCoroutine standaloneCoroutine = this.proxyTickerJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        this.proxyTickerJob = null;
        StandaloneCoroutine standaloneCoroutine2 = this.transitionWatchdog;
        if (standaloneCoroutine2 != null) {
            standaloneCoroutine2.cancel((CancellationException) null);
        }
    }

    public final void refreshActiveProfile() {
        JobKt.launch$default(ViewModelKt.getViewModelScope(this), null, new FilesActivity$showError$1(this, null, 7), 3);
    }

    public final void startProxyTicker() {
        StandaloneCoroutine standaloneCoroutine = this.proxyTickerJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        this.proxyTickerJob = JobKt.launch$default(ViewModelKt.getViewModelScope(this), JobKt.SupervisorJob$default(), new AnonymousClass1(null), 2);
    }
}
