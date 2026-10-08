package androidx.camera.core.impl;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StateObservable$ObserverWrapper implements Runnable {
    public static final Object NOT_SET = new Object();
    public final Executor mExecutor;
    public final Observable.Observer mObserver;
    public final AtomicReference mStateRef;
    public final AtomicBoolean mActive = new AtomicBoolean(true);
    public Object mLastState = NOT_SET;
    public int mLatestSignalledVersion = -1;
    public boolean mWrapperUpdating = false;

    public StateObservable$ObserverWrapper(AtomicReference atomicReference, Executor executor, Observable.Observer observer) {
        this.mStateRef = atomicReference;
        this.mExecutor = executor;
        this.mObserver = observer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this) {
            try {
                if (!this.mActive.get()) {
                    this.mWrapperUpdating = false;
                    return;
                }
                Object obj = this.mStateRef.get();
                int i = this.mLatestSignalledVersion;
                while (true) {
                    if (!Objects.equals(this.mLastState, obj)) {
                        this.mLastState = obj;
                        if (obj instanceof AutoValue_StateObservable_ErrorWrapper) {
                            this.mObserver.onError(null);
                        } else {
                            this.mObserver.onNewData(obj);
                        }
                    }
                    synchronized (this) {
                        try {
                            if (i == this.mLatestSignalledVersion || !this.mActive.get()) {
                                break;
                                break;
                            } else {
                                obj = this.mStateRef.get();
                                i = this.mLatestSignalledVersion;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                this.mWrapperUpdating = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void update(int i) {
        synchronized (this) {
            try {
                if (this.mActive.get()) {
                    if (i <= this.mLatestSignalledVersion) {
                        return;
                    }
                    this.mLatestSignalledVersion = i;
                    if (this.mWrapperUpdating) {
                        return;
                    }
                    this.mWrapperUpdating = true;
                    try {
                        this.mExecutor.execute(this);
                    } catch (Throwable unused) {
                        synchronized (this) {
                            this.mWrapperUpdating = false;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
