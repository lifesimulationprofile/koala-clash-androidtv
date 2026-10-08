package androidx.compose.material3;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.design.compose.components.GlassSnackbarVisuals;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarHostState {
    public final MutexImpl mutex = new MutexImpl();
    public final ParcelableSnapshotMutableState currentSnackbarData$delegate = Stack.mutableStateOf$default(null);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SnackbarDataImpl {
        public final CancellableContinuationImpl continuation;
        public final GlassSnackbarVisuals visuals;

        public SnackbarDataImpl(GlassSnackbarVisuals glassSnackbarVisuals, CancellableContinuationImpl cancellableContinuationImpl) {
            this.visuals = glassSnackbarVisuals;
            this.continuation = cancellableContinuationImpl;
        }

        public final void dismiss() {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            cancellableContinuationImpl.getClass();
            if (CancellableContinuationImpl._state$volatile$FU.get(cancellableContinuationImpl) instanceof NotCompleted) {
                cancellableContinuationImpl.resumeWith(SnackbarResult.Dismissed);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SnackbarDataImpl.class != obj.getClass()) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) obj;
            return Intrinsics.areEqual(this.visuals, snackbarDataImpl.visuals) && this.continuation.equals(snackbarDataImpl.continuation);
        }

        public final int hashCode() {
            return this.continuation.hashCode() + (this.visuals.hashCode() * 31);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnackbarHostState$showSnackbar$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends ContinuationImpl {
        public GlassSnackbarVisuals L$0;
        public Mutex L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnackbarHostState.this.showSnackbar(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object showSnackbar(GlassSnackbarVisuals glassSnackbarVisuals, Continuation continuation) {
        AnonymousClass2 anonymousClass2;
        MutexImpl mutexImpl;
        Mutex mutex;
        GlassSnackbarVisuals glassSnackbarVisuals2;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object obj = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.currentSnackbarData$delegate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    anonymousClass2.L$0 = glassSnackbarVisuals;
                    mutexImpl = this.mutex;
                    anonymousClass2.L$1 = mutexImpl;
                    anonymousClass2.label = 1;
                    if (mutexImpl.lock(anonymousClass2) != coroutineSingletons) {
                    }
                    glassSnackbarVisuals2 = glassSnackbarVisuals;
                    mutex = mutexImpl;
                    return coroutineSingletons;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Mutex mutex3 = anonymousClass2.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        mutex2 = mutex3;
                        parcelableSnapshotMutableState.setValue(null);
                        ((MutexImpl) mutex2).unlock(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        parcelableSnapshotMutableState.setValue(null);
                        throw th;
                    }
                }
                Mutex mutex4 = anonymousClass2.L$1;
                GlassSnackbarVisuals glassSnackbarVisuals3 = anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex4;
                glassSnackbarVisuals2 = glassSnackbarVisuals3;
                glassSnackbarVisuals2 = glassSnackbarVisuals;
                mutex = mutexImpl;
                anonymousClass2.L$0 = glassSnackbarVisuals2;
                anonymousClass2.L$1 = mutex;
                anonymousClass2.label = 2;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(anonymousClass2));
                cancellableContinuationImpl.initCancellability();
                parcelableSnapshotMutableState.setValue(new SnackbarDataImpl(glassSnackbarVisuals2, cancellableContinuationImpl));
                Object result = cancellableContinuationImpl.getResult();
                if (result != coroutineSingletons) {
                    Mutex mutex5 = mutex;
                    obj = result;
                    mutex2 = mutex5;
                    parcelableSnapshotMutableState.setValue(null);
                    ((MutexImpl) mutex2).unlock(null);
                    return obj;
                }
                glassSnackbarVisuals2 = glassSnackbarVisuals;
                mutex = mutexImpl;
                return coroutineSingletons;
            } catch (Throwable th3) {
                th = th3;
                parcelableSnapshotMutableState.setValue(null);
                throw th;
            }
        } catch (Throwable th4) {
            ((MutexImpl) glassSnackbarVisuals).unlock(null);
            throw th4;
        }
    }
}
