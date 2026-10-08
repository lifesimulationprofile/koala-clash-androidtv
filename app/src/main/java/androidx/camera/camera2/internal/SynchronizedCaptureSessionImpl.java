package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseDeferrableSurface;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.Futures$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import coil.util.ImmutableHardwareBitmapService;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.TextStreamsKt;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.json.internal.Composer;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SynchronizedCaptureSessionImpl extends SynchronizedCaptureSession$StateCallback {
    public Toolbar.AnonymousClass1 mCameraCaptureSessionCompat;
    public final Http2Connection.Builder mCaptureSessionRepository;
    public CaptureSession.StateCallback mCaptureSessionStateCallback;
    public final ForceCloseDeferrableSurface mCloseSurfaceQuirk;
    public final Handler mCompatHandler;
    public ArrayList mDeferrableSurfaces;
    public final SequentialExecutor mExecutor;
    public final PreviewView.AnonymousClass1 mForceCloseSessionQuirk;
    public CallbackToFutureAdapter.Completer mOpenCaptureSessionCompleter;
    public CallbackToFutureAdapter.SafeFuture mOpenCaptureSessionFuture;
    public ListFuture mOpenSessionBlockerFuture;
    public final Composer mRequestMonitor;
    public final HandlerScheduledExecutorService mScheduledExecutorService;
    public final HandlerScheduledExecutorService mScheduledExecutorService$1;
    public final ImmutableHardwareBitmapService mSessionResetPolicy;
    public FutureChain mStartingSurface;
    public final Object mLock = new Object();
    public List mHeldDeferrableSurfaces = null;
    public boolean mClosed$1 = false;
    public boolean mOpenerDisabled = false;
    public boolean mSessionFinished = false;
    public final Object mObjectLock = new Object();
    public final AtomicBoolean mClosed = new AtomicBoolean(false);

    public SynchronizedCaptureSessionImpl(Quirks quirks, Quirks quirks2, Http2Connection.Builder builder, SequentialExecutor sequentialExecutor, HandlerScheduledExecutorService handlerScheduledExecutorService, Handler handler) {
        this.mCaptureSessionRepository = builder;
        this.mCompatHandler = handler;
        this.mExecutor = sequentialExecutor;
        this.mScheduledExecutorService$1 = handlerScheduledExecutorService;
        this.mCloseSurfaceQuirk = new ForceCloseDeferrableSurface(quirks, quirks2);
        this.mRequestMonitor = new Composer(quirks.contains(CaptureSessionStuckQuirk.class) || quirks.contains(IncorrectCaptureStateQuirk.class));
        this.mForceCloseSessionQuirk = new PreviewView.AnonymousClass1(quirks2, 12);
        this.mSessionResetPolicy = new ImmutableHardwareBitmapService(quirks2);
        this.mScheduledExecutorService = handlerScheduledExecutorService;
    }

    public final int captureBurstRequests(ArrayList arrayList, CameraBurstCaptureCallback cameraBurstCaptureCallback) {
        CameraCaptureSession.CaptureCallback captureCallbackCreateMonitorListener = this.mRequestMonitor.createMonitorListener(cameraBurstCaptureCallback);
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return ((SurfaceRequest.AnonymousClass1) this.mCameraCaptureSessionCompat.this$0).captureBurstRequests(arrayList, this.mExecutor, captureCallbackCreateMonitorListener);
    }

    public final void close() {
        if (!this.mClosed.compareAndSet(false, true)) {
            debugLog("close() has been called. Skip this invocation.");
            return;
        }
        if (this.mSessionResetPolicy.allowHardware) {
            try {
                debugLog("Call abortCaptures() before closing session.");
                Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
                ((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) this.mCameraCaptureSessionCompat.this$0).val$requestCancellationCompleter).abortCaptures();
            } catch (Exception e) {
                debugLog("Exception when calling abortCaptures()" + e);
            }
        }
        debugLog("Session call close()");
        this.mRequestMonitor.getRequestsProcessedFuture().addListener(new SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0(this, 0), this.mExecutor);
    }

    public final void createCaptureSessionCompat(CameraCaptureSession cameraCaptureSession) {
        if (this.mCameraCaptureSessionCompat == null) {
            this.mCameraCaptureSessionCompat = new Toolbar.AnonymousClass1(cameraCaptureSession, this.mCompatHandler);
        }
    }

    public final void debugLog(String str) {
        Logger.d("SyncCaptureSessionImpl", "[" + this + "] " + str);
    }

    public final void holdDeferrableSurfaces(List list) {
        synchronized (this.mLock) {
            releaseDeferrableSurfaces();
            if (!list.isEmpty()) {
                int i = 0;
                do {
                    try {
                        ((DeferrableSurface) list.get(i)).incrementUseCount();
                        i++;
                    } catch (DeferrableSurface.SurfaceClosedException e) {
                        for (int i2 = i - 1; i2 >= 0; i2--) {
                            ((DeferrableSurface) list.get(i2)).decrementUseCount();
                        }
                        throw e;
                    }
                } while (i < list.size());
            }
            this.mHeldDeferrableSurfaces = list;
        }
    }

    public final boolean isCameraCaptureSessionOpen() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mOpenCaptureSessionFuture != null;
        }
        return z;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
    public final void onActive(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onActive(synchronizedCaptureSessionImpl);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
    public final void onCaptureQueueEmpty(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onCaptureQueueEmpty(synchronizedCaptureSessionImpl);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
    public final void onClosed(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        synchronized (this.mObjectLock) {
            this.mCloseSurfaceQuirk.onSessionEnd(this.mDeferrableSurfaces);
        }
        debugLog("onClosed()");
        onClosed$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl(synchronizedCaptureSessionImpl);
    }

    public final void onClosed$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        CallbackToFutureAdapter.SafeFuture safeFuture;
        synchronized (this.mLock) {
            try {
                if (this.mClosed$1) {
                    safeFuture = null;
                } else {
                    this.mClosed$1 = true;
                    Preconditions.checkNotNull(this.mOpenCaptureSessionFuture, "Need to call openCaptureSession before using this API.");
                    safeFuture = this.mOpenCaptureSessionFuture;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        releaseDeferrableSurfaces();
        this.mRequestMonitor.stop();
        if (safeFuture != null) {
            safeFuture.delegate.addListener(new SynchronizedCaptureSessionBaseImpl$$ExternalSyntheticLambda0(this, synchronizedCaptureSessionImpl, 1), HexFormatKt.directExecutor());
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
    public final void onConfigureFailed(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        releaseDeferrableSurfaces();
        this.mRequestMonitor.stop();
        Http2Connection.Builder builder = this.mCaptureSessionRepository;
        builder.forceFinishCloseStaleSessions(this);
        synchronized (builder.socket) {
            ((LinkedHashSet) builder.sink).remove(this);
        }
        this.mCaptureSessionStateCallback.onConfigureFailed(synchronizedCaptureSessionImpl);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
    public final void onConfigured(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        debugLog("Session onConfigured()");
        PreviewView.AnonymousClass1 anonymousClass1 = this.mForceCloseSessionQuirk;
        ArrayList creatingCaptureSessions = this.mCaptureSessionRepository.getCreatingCaptureSessions();
        ArrayList captureSessions = this.mCaptureSessionRepository.getCaptureSessions();
        int i = 0;
        if (((CaptureSessionOnClosedNotCalledQuirk) anonymousClass1.this$0) != null) {
            LinkedHashSet<SynchronizedCaptureSessionImpl> linkedHashSet = new LinkedHashSet();
            int size = creatingCaptureSessions.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = creatingCaptureSessions.get(i2);
                i2++;
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = (SynchronizedCaptureSessionImpl) obj;
                if (synchronizedCaptureSessionImpl2 == synchronizedCaptureSessionImpl) {
                    break;
                } else {
                    linkedHashSet.add(synchronizedCaptureSessionImpl2);
                }
            }
            for (SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl3 : linkedHashSet) {
                synchronizedCaptureSessionImpl3.getClass();
                synchronizedCaptureSessionImpl3.onConfigureFailed(synchronizedCaptureSessionImpl3);
            }
        }
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        Http2Connection.Builder builder = this.mCaptureSessionRepository;
        synchronized (builder.socket) {
            ((LinkedHashSet) builder.connectionName).add(this);
            ((LinkedHashSet) builder.sink).remove(this);
        }
        builder.forceFinishCloseStaleSessions(this);
        this.mCaptureSessionStateCallback.onConfigured(synchronizedCaptureSessionImpl);
        if (((CaptureSessionOnClosedNotCalledQuirk) anonymousClass1.this$0) != null) {
            LinkedHashSet<SynchronizedCaptureSessionImpl> linkedHashSet2 = new LinkedHashSet();
            int size2 = captureSessions.size();
            while (i < size2) {
                Object obj2 = captureSessions.get(i);
                i++;
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl4 = (SynchronizedCaptureSessionImpl) obj2;
                if (synchronizedCaptureSessionImpl4 == synchronizedCaptureSessionImpl) {
                    break;
                } else {
                    linkedHashSet2.add(synchronizedCaptureSessionImpl4);
                }
            }
            for (SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl5 : linkedHashSet2) {
                synchronizedCaptureSessionImpl5.getClass();
                synchronizedCaptureSessionImpl5.onClosed(synchronizedCaptureSessionImpl5);
            }
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
    public final void onReady(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onReady(synchronizedCaptureSessionImpl);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
    public final void onSessionFinished(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        CallbackToFutureAdapter.SafeFuture safeFuture;
        synchronized (this.mLock) {
            try {
                if (this.mSessionFinished) {
                    safeFuture = null;
                } else {
                    this.mSessionFinished = true;
                    Preconditions.checkNotNull(this.mOpenCaptureSessionFuture, "Need to call openCaptureSession before using this API.");
                    safeFuture = this.mOpenCaptureSessionFuture;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (safeFuture != null) {
            safeFuture.delegate.addListener(new SynchronizedCaptureSessionBaseImpl$$ExternalSyntheticLambda0(this, synchronizedCaptureSessionImpl, 0), HexFormatKt.directExecutor());
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
    public final void onSurfacePrepared(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, Surface surface) {
        Objects.requireNonNull(this.mCaptureSessionStateCallback);
        this.mCaptureSessionStateCallback.onSurfacePrepared(synchronizedCaptureSessionImpl, surface);
    }

    public final ListenableFuture openCaptureSession(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        ListenableFuture listenableFutureNonCancellationPropagating;
        synchronized (this.mObjectLock) {
            try {
                ArrayList captureSessions = this.mCaptureSessionRepository.getCaptureSessions();
                ArrayList arrayList = new ArrayList();
                int size = captureSessions.size();
                int i = 0;
                while (i < size) {
                    Object obj = captureSessions.get(i);
                    i++;
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) obj;
                    arrayList.add(CallbackToFutureAdapter.getFuture(new Futures$$ExternalSyntheticLambda0(synchronizedCaptureSessionImpl.mRequestMonitor.getRequestsProcessedFuture(), synchronizedCaptureSessionImpl.mScheduledExecutorService, 1500L)));
                }
                ListFuture listFuture = new ListFuture(new ArrayList(arrayList), false, HexFormatKt.directExecutor());
                this.mOpenSessionBlockerFuture = listFuture;
                listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(Futures.transformAsync(FutureChain.from(listFuture), new SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1(this, cameraDevice, sessionConfigurationCompat, list), this.mExecutor));
            } catch (Throwable th) {
                throw th;
            }
        }
        return listenableFutureNonCancellationPropagating;
    }

    public final void releaseDeferrableSurfaces() {
        synchronized (this.mLock) {
            try {
                List list = this.mHeldDeferrableSurfaces;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((DeferrableSurface) it.next()).decrementUseCount();
                    }
                    this.mHeldDeferrableSurfaces = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int setSingleRepeatingRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraCaptureSession.CaptureCallback captureCallbackCreateMonitorListener = this.mRequestMonitor.createMonitorListener(captureCallback);
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return ((SurfaceRequest.AnonymousClass1) this.mCameraCaptureSessionCompat.this$0).setSingleRepeatingRequest(captureRequest, this.mExecutor, captureCallbackCreateMonitorListener);
    }

    public final ListenableFuture startWithDeferrableSurface(ArrayList arrayList) {
        ListenableFuture listenableFutureStartWithDeferrableSurface$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl;
        synchronized (this.mObjectLock) {
            this.mDeferrableSurfaces = arrayList;
            listenableFutureStartWithDeferrableSurface$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl = startWithDeferrableSurface$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl(arrayList);
        }
        return listenableFutureStartWithDeferrableSurface$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl;
    }

    public final ListenableFuture startWithDeferrableSurface$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl(ArrayList arrayList) {
        synchronized (this.mLock) {
            try {
                if (this.mOpenerDisabled) {
                    return new ImmediateFuture$ImmediateFailedFuture(0, new CancellationException("Opener is disabled"));
                }
                ChainingListenableFuture chainingListenableFutureTransformAsync = Futures.transformAsync(FutureChain.from(TextStreamsKt.surfaceListWithTimeout(arrayList, this.mExecutor, this.mScheduledExecutorService$1)), new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(2, this, arrayList), this.mExecutor);
                this.mStartingSurface = chainingListenableFutureTransformAsync;
                return Futures.nonCancellationPropagating(chainingListenableFutureTransformAsync);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean stop() {
        boolean zStop$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl;
        synchronized (this.mObjectLock) {
            try {
                if (isCameraCaptureSessionOpen()) {
                    this.mCloseSurfaceQuirk.onSessionEnd(this.mDeferrableSurfaces);
                } else {
                    ListFuture listFuture = this.mOpenSessionBlockerFuture;
                    if (listFuture != null) {
                        listFuture.cancel(true);
                    }
                }
                zStop$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl = stop$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zStop$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl;
    }

    public final boolean stop$androidx$camera$camera2$internal$SynchronizedCaptureSessionBaseImpl() {
        boolean z;
        FutureChain futureChain = null;
        try {
            synchronized (this.mLock) {
                try {
                    if (!this.mOpenerDisabled) {
                        FutureChain futureChain2 = this.mStartingSurface;
                        futureChain = futureChain2 != null ? futureChain2 : null;
                        this.mOpenerDisabled = true;
                    }
                    z = !isCameraCaptureSessionOpen();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (futureChain != null) {
                futureChain.cancel(true);
            }
            return z;
        } catch (Throwable th2) {
            if (futureChain != null) {
                futureChain.cancel(true);
            }
            throw th2;
        }
    }

    public final Toolbar.AnonymousClass1 toCameraCaptureSessionCompat() {
        this.mCameraCaptureSessionCompat.getClass();
        return this.mCameraCaptureSessionCompat;
    }
}
