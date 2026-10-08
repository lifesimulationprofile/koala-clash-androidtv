package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DeferrableSurface {
    public CallbackToFutureAdapter.Completer mCloseCompleter;
    public final CallbackToFutureAdapter.SafeFuture mCloseFuture;
    public Class mContainerClass;
    public final Size mPrescribedSize;
    public final int mPrescribedStreamFormat;
    public CallbackToFutureAdapter.Completer mTerminationCompleter;
    public final CallbackToFutureAdapter.SafeFuture mTerminationFuture;
    public static final Size SIZE_UNDEFINED = new Size(0, 0);
    public static final boolean DEBUG = Logger.isDebugEnabled("DeferrableSurface");
    public static final AtomicInteger USED_COUNT = new AtomicInteger(0);
    public static final AtomicInteger TOTAL_COUNT = new AtomicInteger(0);
    public final Object mLock = new Object();
    public int mUseCount = 0;
    public boolean mClosed = false;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SurfaceClosedException extends Exception {
        public final DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(String str, DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }
    }

    public DeferrableSurface(Size size, int i) {
        this.mPrescribedSize = size;
        this.mPrescribedStreamFormat = i;
        final int i2 = 0;
        CallbackToFutureAdapter.SafeFuture future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: androidx.camera.core.impl.DeferrableSurface$$ExternalSyntheticLambda0
            public final /* synthetic */ DeferrableSurface f$0;

            {
                this.f$0 = this;
            }

            private final Object attachCompleter$androidx$camera$core$impl$DeferrableSurface$$ExternalSyntheticLambda0(CallbackToFutureAdapter.Completer completer) {
                DeferrableSurface deferrableSurface = this.f$0;
                synchronized (deferrableSurface.mLock) {
                    deferrableSurface.mTerminationCompleter = completer;
                }
                return "DeferrableSurface-termination(" + deferrableSurface + ")";
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                switch (i2) {
                    case 0:
                        return attachCompleter$androidx$camera$core$impl$DeferrableSurface$$ExternalSyntheticLambda0(completer);
                    default:
                        DeferrableSurface deferrableSurface = this.f$0;
                        synchronized (deferrableSurface.mLock) {
                            deferrableSurface.mCloseCompleter = completer;
                            break;
                        }
                        return "DeferrableSurface-close(" + deferrableSurface + ")";
                }
            }
        });
        this.mTerminationFuture = future;
        final int i3 = 1;
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: androidx.camera.core.impl.DeferrableSurface$$ExternalSyntheticLambda0
            public final /* synthetic */ DeferrableSurface f$0;

            {
                this.f$0 = this;
            }

            private final Object attachCompleter$androidx$camera$core$impl$DeferrableSurface$$ExternalSyntheticLambda0(CallbackToFutureAdapter.Completer completer) {
                DeferrableSurface deferrableSurface = this.f$0;
                synchronized (deferrableSurface.mLock) {
                    deferrableSurface.mTerminationCompleter = completer;
                }
                return "DeferrableSurface-termination(" + deferrableSurface + ")";
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                switch (i3) {
                    case 0:
                        return attachCompleter$androidx$camera$core$impl$DeferrableSurface$$ExternalSyntheticLambda0(completer);
                    default:
                        DeferrableSurface deferrableSurface = this.f$0;
                        synchronized (deferrableSurface.mLock) {
                            deferrableSurface.mCloseCompleter = completer;
                            break;
                        }
                        return "DeferrableSurface-close(" + deferrableSurface + ")";
                }
            }
        });
        if (Logger.isDebugEnabled("DeferrableSurface")) {
            printGlobalDebugCounts(TOTAL_COUNT.incrementAndGet(), USED_COUNT.get(), "Surface created");
            future.delegate.addListener(new Preview$$ExternalSyntheticLambda1(13, this, Log.getStackTraceString(new Exception())), HexFormatKt.directExecutor());
        }
    }

    public void close() {
        CallbackToFutureAdapter.Completer completer;
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    completer = null;
                } else {
                    this.mClosed = true;
                    this.mCloseCompleter.set(null);
                    if (this.mUseCount == 0) {
                        completer = this.mTerminationCompleter;
                        this.mTerminationCompleter = null;
                    } else {
                        completer = null;
                    }
                    if (Logger.isDebugEnabled("DeferrableSurface")) {
                        Logger.d("DeferrableSurface", "surface closed,  useCount=" + this.mUseCount + " closed=true " + this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    public final void decrementUseCount() {
        CallbackToFutureAdapter.Completer completer;
        synchronized (this.mLock) {
            try {
                int i = this.mUseCount;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                int i2 = i - 1;
                this.mUseCount = i2;
                if (i2 == 0 && this.mClosed) {
                    completer = this.mTerminationCompleter;
                    this.mTerminationCompleter = null;
                } else {
                    completer = null;
                }
                if (Logger.isDebugEnabled("DeferrableSurface")) {
                    Logger.d("DeferrableSurface", "use count-1,  useCount=" + this.mUseCount + " closed=" + this.mClosed + " " + this);
                    if (this.mUseCount == 0) {
                        printGlobalDebugCounts(TOTAL_COUNT.get(), USED_COUNT.decrementAndGet(), "Surface no longer in use");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    public final ListenableFuture getSurface() {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return new ImmediateFuture$ImmediateFailedFuture(0, new SurfaceClosedException("DeferrableSurface already closed.", this));
                }
                return provideSurface();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void incrementUseCount() {
        synchronized (this.mLock) {
            try {
                int i = this.mUseCount;
                if (i == 0 && this.mClosed) {
                    throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
                this.mUseCount = i + 1;
                if (Logger.isDebugEnabled("DeferrableSurface")) {
                    if (this.mUseCount == 1) {
                        printGlobalDebugCounts(TOTAL_COUNT.get(), USED_COUNT.incrementAndGet(), "New surface in use");
                    }
                    Logger.d("DeferrableSurface", "use count+1, useCount=" + this.mUseCount + " " + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void printGlobalDebugCounts(int i, int i2, String str) {
        if (!DEBUG && Logger.isDebugEnabled("DeferrableSurface")) {
            Logger.d("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        Logger.d("DeferrableSurface", str + "[total_surfaces=" + i + ", used_surfaces=" + i2 + "](" + this + "}");
    }

    public abstract ListenableFuture provideSurface();
}
