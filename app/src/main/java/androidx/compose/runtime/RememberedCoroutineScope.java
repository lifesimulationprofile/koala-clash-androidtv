package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RememberedCoroutineScope implements CoroutineScope, RememberObserver {
    public static final CancelledCoroutineContext CancelledCoroutineContext = new CancelledCoroutineContext();
    public volatile CoroutineContext _coroutineContext;
    public final RememberedCoroutineScope lock = this;
    public final CoroutineContext parentContext;

    public RememberedCoroutineScope(CoroutineContext coroutineContext) {
        this.parentContext = coroutineContext;
    }

    public final void cancelIfCreated() {
        synchronized (this.lock) {
            try {
                CoroutineContext coroutineContext = this._coroutineContext;
                if (coroutineContext == null) {
                    this._coroutineContext = CancelledCoroutineContext;
                } else {
                    JobKt.cancel(coroutineContext, new ForgottenCoroutineScopeException(0));
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        CoroutineContext coroutineContextPlus;
        CoroutineContext coroutineContext = this._coroutineContext;
        if (coroutineContext != null && coroutineContext != CancelledCoroutineContext) {
            return coroutineContext;
        }
        CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) this.parentContext.get(CompositionErrorContextImpl.Key);
        CoroutineContext rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 = compositionErrorContextImpl != null ? new RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(compositionErrorContextImpl, this) : EmptyCoroutineContext.INSTANCE;
        synchronized (this.lock) {
            try {
                coroutineContextPlus = this._coroutineContext;
                if (coroutineContextPlus == null) {
                    CoroutineContext coroutineContext2 = this.parentContext;
                    coroutineContextPlus = coroutineContext2.plus(new JobImpl((Job) coroutineContext2.get(Job.Key.$$INSTANCE))).plus(EmptyCoroutineContext.INSTANCE).plus(rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1);
                } else if (coroutineContextPlus == CancelledCoroutineContext) {
                    CoroutineContext coroutineContext3 = this.parentContext;
                    JobImpl jobImpl = new JobImpl((Job) coroutineContext3.get(Job.Key.$$INSTANCE));
                    jobImpl.cancelImpl$kotlinx_coroutines_core(new ForgottenCoroutineScopeException(0));
                    coroutineContextPlus = coroutineContext3.plus(jobImpl).plus(EmptyCoroutineContext.INSTANCE).plus(rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1);
                }
                this._coroutineContext = coroutineContextPlus;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return coroutineContextPlus;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        cancelIfCreated();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        cancelIfCreated();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
    }
}
