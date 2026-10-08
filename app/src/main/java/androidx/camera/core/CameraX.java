package androidx.camera.core;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraX {
    public static final Object MIN_LOG_LEVEL_LOCK = new Object();
    public static final SparseArray sMinLogLevelReferenceCountMap = new SparseArray();
    public final Executor mCameraExecutor;
    public Camera2CameraFactory mCameraFactory;
    public final CameraXConfig mCameraXConfig;
    public Camera2UseCaseConfigFactory mDefaultConfigFactory;
    public final CallbackToFutureAdapter.SafeFuture mInitInternalFuture;
    public final RetryPolicy mRetryPolicy;
    public final Handler mSchedulerHandler;
    public SurfaceRequest.AnonymousClass1 mSurfaceManager;
    public final SurfaceRequest.AnonymousClass1 mCameraRepository = new SurfaceRequest.AnonymousClass1(13);
    public final Object mInitializeLock = new Object();
    public int mInitState = 1;

    /* JADX WARN: Code restructure failed: missing block: B:106:0x01e2, code lost:
    
        r0 = r1;
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CameraX(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraX.<init>(android.content.Context):void");
    }

    public static void increaseMinLogLevelReference(Integer num) {
        synchronized (MIN_LOG_LEVEL_LOCK) {
            try {
                if (num == null) {
                    return;
                }
                Preconditions.checkArgumentInRange(num.intValue(), 3, 6, "minLogLevel");
                SparseArray sparseArray = sMinLogLevelReferenceCountMap;
                sparseArray.put(num.intValue(), Integer.valueOf(sparseArray.get(num.intValue()) != null ? 1 + ((Integer) sparseArray.get(num.intValue())).intValue() : 1));
                if (sparseArray.size() == 0 || sparseArray.get(3) != null) {
                    Logger.sMinLogLevel = 3;
                } else if (sparseArray.get(4) != null) {
                    Logger.sMinLogLevel = 4;
                } else if (sparseArray.get(5) != null) {
                    Logger.sMinLogLevel = 5;
                } else if (sparseArray.get(6) != null) {
                    Logger.sMinLogLevel = 6;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final CallbackToFutureAdapter.SafeFuture initInternal(Context context) {
        CallbackToFutureAdapter.SafeFuture future;
        synchronized (this.mInitializeLock) {
            boolean z = true;
            if (this.mInitState != 1) {
                z = false;
            }
            Preconditions.checkState("CameraX.initInternal() should only be called once per instance", z);
            this.mInitState = 2;
            future = CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(3, this, context));
        }
        return future;
    }

    public final void setStateToInitialized() {
        synchronized (this.mInitializeLock) {
            this.mInitState = 4;
        }
    }
}
