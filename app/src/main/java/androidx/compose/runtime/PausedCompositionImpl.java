package androidx.compose.runtime;

import android.os.Trace;
import androidx.collection.MutableScatterSet;
import androidx.collection.MutableSetWrapper;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.core.view.MenuHostHelper;
import coil.network.HttpException;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PausedCompositionImpl {
    public final MenuHostHelper applier;
    public final GapComposer composer;
    public final CompositionImpl composition;
    public final Function2 content;
    public final CompositionContext context;
    public final Object lock;
    public final MenuHostHelper pausableApplier;
    public final zzky rememberManager;
    public final boolean reusable;
    public final AtomicReference state = new AtomicReference(PausedCompositionState.InitialPending);
    public long owningThread = Thread_jvmKt.currentThreadId();
    public MutableScatterSet invalidScopes = ScatterSetKt.EmptyScatterSet;

    public PausedCompositionImpl(CompositionImpl compositionImpl, CompositionContext compositionContext, GapComposer gapComposer, MutableSetWrapper mutableSetWrapper, Function2 function2, boolean z, MenuHostHelper menuHostHelper, Object obj) {
        this.composition = compositionImpl;
        this.context = compositionContext;
        this.composer = gapComposer;
        this.content = function2;
        this.reusable = z;
        this.applier = menuHostHelper;
        this.lock = obj;
        zzky zzkyVar = new zzky();
        zzkyVar.prepare(mutableSetWrapper, gapComposer.getErrorContext$runtime());
        this.rememberManager = zzkyVar;
        this.pausableApplier = new MenuHostHelper(menuHostHelper.mProviderToLifecycleContainers);
    }

    public final void apply() throws Exception {
        AtomicReference atomicReference = this.state;
        try {
            switch (((PausedCompositionState) atomicReference.get()).ordinal()) {
                case 0:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception");
                case 1:
                    throw new IllegalStateException("The paused composition has been cancelled");
                case 2:
                case 3:
                case 4:
                    throw new IllegalStateException("The paused composition has not completed yet");
                case 5:
                    applyChanges();
                    PausedCompositionState pausedCompositionState = PausedCompositionState.ApplyPending;
                    PausedCompositionState pausedCompositionState2 = PausedCompositionState.Applied;
                    while (!atomicReference.compareAndSet(pausedCompositionState, pausedCompositionState2)) {
                        if (atomicReference.get() != pausedCompositionState) {
                            PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState + " to: " + pausedCompositionState2 + '.');
                            return;
                        }
                    }
                    return;
                case 6:
                    throw new IllegalStateException("The paused composition has already been applied");
                default:
                    throw new HttpException();
            }
        } catch (Exception e) {
            atomicReference.set(PausedCompositionState.Invalid);
            throw e;
        }
    }

    public final void applyChanges() {
        Trace.beginSection("PausedComposition:applyChanges");
        try {
            synchronized (this.lock) {
                try {
                    this.pausableApplier.playTo(this.applier, this.rememberManager);
                    this.rememberManager.dispatchRememberObservers();
                    this.rememberManager.dispatchSideEffects();
                    this.rememberManager.dispatchAbandons();
                    this.composition.pendingPausedComposition = null;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    this.rememberManager.dispatchAbandons();
                    this.composition.pendingPausedComposition = null;
                    throw th;
                }
            }
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public final boolean isComplete() {
        return ((PausedCompositionState) this.state.get()).compareTo(PausedCompositionState.ApplyPending) >= 0;
    }

    public final void markComplete() {
        PausedCompositionState pausedCompositionState;
        PausedCompositionState pausedCompositionState2;
        boolean z;
        while (true) {
            AtomicReference atomicReference = this.state;
            pausedCompositionState = PausedCompositionState.RecomposePending;
            pausedCompositionState2 = PausedCompositionState.ApplyPending;
            if (atomicReference.compareAndSet(pausedCompositionState, pausedCompositionState2)) {
                z = true;
                break;
            } else if (atomicReference.get() != pausedCompositionState) {
                z = false;
                break;
            }
        }
        if (z) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState + " to: " + pausedCompositionState2 + '.');
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0082 A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:3:0x0004, B:6:0x001d, B:7:0x0022, B:10:0x0026, B:11:0x002d, B:12:0x002e, B:13:0x0035, B:14:0x0036, B:15:0x0040, B:16:0x0041, B:22:0x0069, B:24:0x0079, B:25:0x007b, B:31:0x00a3, B:33:0x00ab, B:28:0x0082, B:30:0x0088, B:35:0x00b1, B:36:0x00b3, B:38:0x00b9, B:41:0x00c0, B:42:0x00db, B:19:0x0048, B:21:0x004e, B:46:0x00e3, B:49:0x00f2, B:50:0x00f5, B:51:0x00f7, B:57:0x011f, B:59:0x0127, B:54:0x00fe, B:56:0x0104, B:64:0x0132, B:65:0x0135, B:66:0x0136, B:67:0x013d, B:68:0x013e, B:69:0x0145, B:23:0x006b, B:47:0x00e8), top: B:74:0x0004, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ab A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:3:0x0004, B:6:0x001d, B:7:0x0022, B:10:0x0026, B:11:0x002d, B:12:0x002e, B:13:0x0035, B:14:0x0036, B:15:0x0040, B:16:0x0041, B:22:0x0069, B:24:0x0079, B:25:0x007b, B:31:0x00a3, B:33:0x00ab, B:28:0x0082, B:30:0x0088, B:35:0x00b1, B:36:0x00b3, B:38:0x00b9, B:41:0x00c0, B:42:0x00db, B:19:0x0048, B:21:0x004e, B:46:0x00e3, B:49:0x00f2, B:50:0x00f5, B:51:0x00f7, B:57:0x011f, B:59:0x0127, B:54:0x00fe, B:56:0x0104, B:64:0x0132, B:65:0x0135, B:66:0x0136, B:67:0x013d, B:68:0x013e, B:69:0x0145, B:23:0x006b, B:47:0x00e8), top: B:74:0x0004, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0127 A[Catch: Exception -> 0x0023, TRY_LEAVE, TryCatch #1 {Exception -> 0x0023, blocks: (B:3:0x0004, B:6:0x001d, B:7:0x0022, B:10:0x0026, B:11:0x002d, B:12:0x002e, B:13:0x0035, B:14:0x0036, B:15:0x0040, B:16:0x0041, B:22:0x0069, B:24:0x0079, B:25:0x007b, B:31:0x00a3, B:33:0x00ab, B:28:0x0082, B:30:0x0088, B:35:0x00b1, B:36:0x00b3, B:38:0x00b9, B:41:0x00c0, B:42:0x00db, B:19:0x0048, B:21:0x004e, B:46:0x00e3, B:49:0x00f2, B:50:0x00f5, B:51:0x00f7, B:57:0x011f, B:59:0x0127, B:54:0x00fe, B:56:0x0104, B:64:0x0132, B:65:0x0135, B:66:0x0136, B:67:0x013d, B:68:0x013e, B:69:0x0145, B:23:0x006b, B:47:0x00e8), top: B:74:0x0004, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:? A[LOOP:1: B:25:0x007b->B:82:?, LOOP_END, SYNTHETIC] */
    public final boolean resume(ShouldPauseCallback shouldPauseCallback) throws Exception {
        long j;
        PausedCompositionState pausedCompositionState = PausedCompositionState.Recomposing;
        AtomicReference atomicReference = this.state;
        try {
            int iOrdinal = ((PausedCompositionState) atomicReference.get()).ordinal();
            CompositionImpl compositionImpl = this.composition;
            CompositionContext compositionContext = this.context;
            PausedCompositionState pausedCompositionState2 = PausedCompositionState.RecomposePending;
            switch (iOrdinal) {
                case 0:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception");
                case 1:
                    throw new IllegalStateException("The paused composition has been cancelled");
                case 2:
                    GapComposer gapComposer = this.composer;
                    boolean z = this.reusable;
                    if (z) {
                        gapComposer.reusingGroup = 0;
                        gapComposer.reusing = true;
                    }
                    try {
                        this.invalidScopes = compositionContext.composeInitialPaused$runtime(compositionImpl, shouldPauseCallback, this.content);
                        if (z) {
                            gapComposer.endReuseFromRoot$runtime();
                        }
                        PausedCompositionState pausedCompositionState3 = PausedCompositionState.InitialPending;
                        while (!atomicReference.compareAndSet(pausedCompositionState3, pausedCompositionState2)) {
                            if (atomicReference.get() != pausedCompositionState3) {
                                PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState3 + " to: " + pausedCompositionState2 + '.');
                                if (this.invalidScopes.isEmpty()) {
                                    markComplete();
                                }
                                return isComplete();
                            }
                        }
                        if (this.invalidScopes.isEmpty()) {
                            markComplete();
                        }
                        return isComplete();
                    } catch (Throwable th) {
                        if (z) {
                            gapComposer.endReuseFromRoot$runtime();
                        }
                        throw th;
                    }
                case 3:
                    try {
                        while (!atomicReference.compareAndSet(pausedCompositionState2, pausedCompositionState)) {
                            if (atomicReference.get() != pausedCompositionState2) {
                                PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState2 + " to: " + pausedCompositionState + '.');
                                j = this.owningThread;
                                this.owningThread = Thread_jvmKt.currentThreadId();
                                this.invalidScopes = compositionContext.recomposePaused$runtime(compositionImpl, shouldPauseCallback, this.invalidScopes);
                                this.owningThread = j;
                                while (!atomicReference.compareAndSet(pausedCompositionState, pausedCompositionState2)) {
                                    if (atomicReference.get() != pausedCompositionState) {
                                        PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState + " to: " + pausedCompositionState2 + '.');
                                        if (this.invalidScopes.isEmpty()) {
                                            markComplete();
                                        }
                                        return isComplete();
                                    }
                                }
                                if (this.invalidScopes.isEmpty()) {
                                    markComplete();
                                }
                                return isComplete();
                            }
                        }
                        this.owningThread = Thread_jvmKt.currentThreadId();
                        this.invalidScopes = compositionContext.recomposePaused$runtime(compositionImpl, shouldPauseCallback, this.invalidScopes);
                        this.owningThread = j;
                        while (!atomicReference.compareAndSet(pausedCompositionState, pausedCompositionState2)) {
                            if (atomicReference.get() != pausedCompositionState) {
                                PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState + " to: " + pausedCompositionState2 + '.');
                                if (this.invalidScopes.isEmpty()) {
                                    markComplete();
                                }
                                return isComplete();
                            }
                        }
                        if (this.invalidScopes.isEmpty()) {
                            markComplete();
                        }
                        return isComplete();
                    } catch (Throwable th2) {
                        this.owningThread = j;
                        while (!atomicReference.compareAndSet(pausedCompositionState, pausedCompositionState2)) {
                            if (atomicReference.get() != pausedCompositionState) {
                                PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState + " to: " + pausedCompositionState2 + '.');
                                throw th2;
                            }
                        }
                        throw th2;
                    }
                    j = this.owningThread;
                case 4:
                    ComposerKt.composeRuntimeError("Recursive call to resume()");
                    throw new HttpException();
                case 5:
                    throw new IllegalStateException("Pausable composition is complete and apply() should be applied");
                case 6:
                    throw new IllegalStateException("The paused composition has been applied");
                default:
                    throw new HttpException();
            }
        } catch (Exception e) {
            atomicReference.set(PausedCompositionState.Invalid);
            throw e;
        }
    }
}
