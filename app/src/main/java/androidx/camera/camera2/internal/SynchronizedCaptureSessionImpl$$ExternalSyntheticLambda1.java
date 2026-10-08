package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.android.gms.tasks.zzi;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1 implements CallbackToFutureAdapter.Resolver, AsyncFunction {
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ SessionConfigurationCompat f$2;
    public final /* synthetic */ List f$3;

    public /* synthetic */ SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        this.f$0 = synchronizedCaptureSessionImpl;
        this.f$1 = cameraDevice;
        this.f$2 = sessionConfigurationCompat;
        this.f$3 = list;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction, androidx.arch.core.util.Function
    public ListenableFuture apply(Object obj) {
        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.f$0;
        CameraDevice cameraDevice = (CameraDevice) this.f$1;
        SessionConfigurationCompat sessionConfigurationCompat = this.f$2;
        List list = this.f$3;
        if (synchronizedCaptureSessionImpl.mSessionResetPolicy.allowHardware) {
            ArrayList captureSessions = synchronizedCaptureSessionImpl.mCaptureSessionRepository.getCaptureSessions();
            int size = captureSessions.size();
            int i = 0;
            while (i < size) {
                Object obj2 = captureSessions.get(i);
                i++;
                ((SynchronizedCaptureSessionImpl) obj2).close();
            }
        }
        synchronizedCaptureSessionImpl.debugLog("start openCaptureSession");
        synchronized (synchronizedCaptureSessionImpl.mLock) {
            try {
                if (synchronizedCaptureSessionImpl.mOpenerDisabled) {
                    return new ImmediateFuture$ImmediateFailedFuture(0, new CancellationException("Opener is disabled"));
                }
                synchronizedCaptureSessionImpl.mCaptureSessionRepository.onCreateCaptureSession(synchronizedCaptureSessionImpl);
                CallbackToFutureAdapter.SafeFuture future = CallbackToFutureAdapter.getFuture(new SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1(synchronizedCaptureSessionImpl, list, new Toolbar.AnonymousClass1(cameraDevice, synchronizedCaptureSessionImpl.mCompatHandler), sessionConfigurationCompat));
                synchronizedCaptureSessionImpl.mOpenCaptureSessionFuture = future;
                Toolbar.AnonymousClass1 anonymousClass1 = new Toolbar.AnonymousClass1(6, synchronizedCaptureSessionImpl);
                future.addListener(new zzi(1, future, anonymousClass1), HexFormatKt.directExecutor());
                return Futures.nonCancellationPropagating(synchronizedCaptureSessionImpl.mOpenCaptureSessionFuture);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        String str;
        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.f$0;
        List list = this.f$3;
        Toolbar.AnonymousClass1 anonymousClass1 = (Toolbar.AnonymousClass1) this.f$1;
        SessionConfigurationCompat sessionConfigurationCompat = this.f$2;
        synchronized (synchronizedCaptureSessionImpl.mLock) {
            synchronizedCaptureSessionImpl.holdDeferrableSurfaces(list);
            Preconditions.checkState("The openCaptureSessionCompleter can only set once!", synchronizedCaptureSessionImpl.mOpenCaptureSessionCompleter == null);
            synchronizedCaptureSessionImpl.mOpenCaptureSessionCompleter = completer;
            ((SurfaceRequest.AnonymousClass1) anonymousClass1.this$0).createCaptureSession(sessionConfigurationCompat);
            str = "openCaptureSession[session=" + synchronizedCaptureSessionImpl + "]";
        }
        return str;
    }

    public /* synthetic */ SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, List list, Toolbar.AnonymousClass1 anonymousClass1, SessionConfigurationCompat sessionConfigurationCompat) {
        this.f$0 = synchronizedCaptureSessionImpl;
        this.f$3 = list;
        this.f$1 = anonymousClass1;
        this.f$2 = sessionConfigurationCompat;
    }
}
