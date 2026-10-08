package androidx.camera.camera2.interop;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$$ExternalSyntheticLambda4;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.AutoValue_SurfaceRequest_TransformationInfo;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraX$$ExternalSyntheticLambda1;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda3;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.OpenGlRenderer;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.camera.view.PreviewView;
import androidx.camera.view.TextureViewImplementation;
import androidx.compose.foundation.lazy.layout.Averages;
import androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.navigation.Navigator;
import coil.intercept.RealInterceptorChain;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzw;
import com.google.common.util.concurrent.ListenableFuture;
import io.github.g00fy2.quickie.QRCodeAnalyzer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CaptureRequestOptions$Builder$$ExternalSyntheticLambda0 implements AsyncFunction, CallbackToFutureAdapter.Resolver, ImageReaderProxy.OnImageAvailableListener, SurfaceRequest.TransformationInfoListener, ShouldPauseCallback, OnCompleteListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction, androidx.arch.core.util.Function
    public ListenableFuture apply(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                CaptureSession captureSession = (CaptureSession) this.f$0;
                SurfaceRequest.AnonymousClass2 anonymousClass2 = (SurfaceRequest.AnonymousClass2) this.f$1;
                captureSession.close();
                anonymousClass2.close();
                return captureSession.release();
            default:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) this.f$0;
                ArrayList arrayList = (ArrayList) this.f$1;
                List list = (List) obj;
                Logger.d("SyncCaptureSessionBase", "[" + synchronizedCaptureSessionImpl + "] getSurface done with results: " + list);
                if (list.isEmpty()) {
                    return new ImmediateFuture$ImmediateFailedFuture(0, new IllegalArgumentException("Unable to open capture session without surfaces"));
                }
                if (!list.contains(null)) {
                    return Futures.immediateFuture(list);
                }
                return new ImmediateFuture$ImmediateFailedFuture(0, new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) arrayList.get(list.indexOf(null))));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        boolean z = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        switch (this.$r8$classId) {
            case 3:
                CameraX cameraX = (CameraX) this.f$0;
                Context context = (Context) this.f$1;
                Executor executor = cameraX.mCameraExecutor;
                executor.execute(new CameraX$$ExternalSyntheticLambda1(cameraX, context, executor, 1, completer, SystemClock.elapsedRealtime()));
                return "CameraX initInternal";
            case 4:
            case 6:
            case 8:
            default:
                TextureViewImplementation textureViewImplementation = (TextureViewImplementation) this.f$0;
                Surface surface = (Surface) this.f$1;
                Logger.d("TextureViewImpl", "Surface set on Preview.");
                textureViewImplementation.mSurfaceRequest.provideSurface(surface, HexFormatKt.directExecutor(), new CaptureNode$$ExternalSyntheticLambda3(3, completer));
                return "provideSurface[request=" + textureViewImplementation.mSurfaceRequest + " surface=" + surface + "]";
            case 5:
                SurfaceRequest surfaceRequest = (SurfaceRequest) this.f$0;
                ((AtomicReference) this.f$1).set(completer);
                return "SurfaceRequest-surface-recreation(" + surfaceRequest.hashCode() + ")";
            case 7:
                DefaultSurfaceProcessor defaultSurfaceProcessor = (DefaultSurfaceProcessor) this.f$0;
                DynamicRange dynamicRange = (DynamicRange) this.f$1;
                Map map = Collections.EMPTY_MAP;
                defaultSurfaceProcessor.executeSafely(new LiveDataObservable$$ExternalSyntheticLambda1(defaultSurfaceProcessor, dynamicRange, completer), new Camera2CameraControlImpl$$ExternalSyntheticLambda4(objArr == true ? 1 : 0));
                return "Init GlRenderer";
            case 9:
                DualSurfaceProcessor dualSurfaceProcessor = (DualSurfaceProcessor) this.f$0;
                DynamicRange dynamicRange2 = (DynamicRange) this.f$1;
                Map map2 = Collections.EMPTY_MAP;
                dualSurfaceProcessor.executeSafely$1(new LiveDataObservable$$ExternalSyntheticLambda1(dualSurfaceProcessor, dynamicRange2, completer), new Camera2CameraControlImpl$$ExternalSyntheticLambda4(objArr2 == true ? 1 : 0));
                return "Init GlRenderer";
            case 10:
                ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) this.f$0;
                CameraX cameraX2 = (CameraX) this.f$1;
                synchronized (processCameraProvider.mLock) {
                    int i = 1;
                    ChainingListenableFuture chainingListenableFutureTransformAsync = Futures.transformAsync(FutureChain.from(ImmediateFuture$ImmediateFailedFuture.NULL_FUTURE), new OnBackPressedDispatcher$$ExternalSyntheticLambda0(10, new Navigator.AnonymousClass1(i, cameraX2)), HexFormatKt.directExecutor());
                    chainingListenableFutureTransformAsync.addListener(new zzi(i, chainingListenableFutureTransformAsync, new SurfaceRequest.AnonymousClass1(19, completer, cameraX2, z)), HexFormatKt.directExecutor());
                    Unit unit = Unit.INSTANCE;
                }
                return "ProcessCameraProvider-initializeCameraX";
            case 11:
                CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) this.f$0;
                ArrayList arrayList = (ArrayList) this.f$1;
                PreviewStreamStateObserver$2 previewStreamStateObserver$2 = new PreviewStreamStateObserver$2(completer, cameraInfoInternal);
                arrayList.add(previewStreamStateObserver$2);
                cameraInfoInternal.addSessionCaptureCallback(HexFormatKt.directExecutor(), previewStreamStateObserver$2);
                return "waitForCaptureResult";
        }
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(zzw zzwVar) {
        QRCodeAnalyzer qRCodeAnalyzer = (QRCodeAnalyzer) this.f$0;
        SettableImageProxy settableImageProxy = (SettableImageProxy) this.f$1;
        qRCodeAnalyzer.onPassCompleted.invoke(Boolean.valueOf(qRCodeAnalyzer.failureOccurred));
        settableImageProxy.close();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        switch (this.$r8$classId) {
            case 4:
                RealInterceptorChain realInterceptorChain = (RealInterceptorChain) this.f$0;
                ImageReaderProxy.OnImageAvailableListener onImageAvailableListener = (ImageReaderProxy.OnImageAvailableListener) this.f$1;
                realInterceptorChain.getClass();
                onImageAvailableListener.onImageAvailable(realInterceptorChain);
                break;
            default:
                PreviewView.AnonymousClass1 anonymousClass1 = (PreviewView.AnonymousClass1) this.f$0;
                ImageReaderProxy.OnImageAvailableListener onImageAvailableListener2 = (ImageReaderProxy.OnImageAvailableListener) this.f$1;
                anonymousClass1.getClass();
                onImageAvailableListener2.onImageAvailable(anonymousClass1);
                break;
        }
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
    public void onTransformationInfoUpdate(AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo) {
        DefaultSurfaceProcessor defaultSurfaceProcessor = (DefaultSurfaceProcessor) this.f$0;
        SurfaceRequest surfaceRequest = (SurfaceRequest) this.f$1;
        defaultSurfaceProcessor.getClass();
        GLUtils.InputFormat inputFormat = (surfaceRequest.mDynamicRange.is10BitHdr() && autoValue_SurfaceRequest_TransformationInfo.hasCameraTransform) ? GLUtils.InputFormat.YUV : GLUtils.InputFormat.DEFAULT;
        OpenGlRenderer openGlRenderer = defaultSurfaceProcessor.mGlRenderer;
        GLUtils.checkInitializedOrThrow((AtomicBoolean) openGlRenderer.mInitialized, true);
        GLUtils.checkGlThreadOrThrow((Thread) openGlRenderer.mGlThread);
        if (((GLUtils.InputFormat) openGlRenderer.mCurrentInputformat) != inputFormat) {
            openGlRenderer.mCurrentInputformat = inputFormat;
            openGlRenderer.useAndConfigureProgramWithTexture(openGlRenderer.mExternalTextureId);
        }
    }

    @Override // androidx.compose.runtime.ShouldPauseCallback
    public boolean shouldPause() {
        PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl = (PrefetchHandleProvider$HandleAndRequestImpl) this.f$0;
        Averages averages = (Averages) this.f$1;
        if (!prefetchHandleProvider$HandleAndRequestImpl.pauseRequested) {
            prefetchHandleProvider$HandleAndRequestImpl.updateElapsedAndAvailableTime();
            long jCalculateAverageTime = Averages.calculateAverageTime(prefetchHandleProvider$HandleAndRequestImpl.elapsedTimeNanos, averages.resumeTimeNanos);
            averages.resumeTimeNanos = jCalculateAverageTime;
            prefetchHandleProvider$HandleAndRequestImpl.pauseRequested = !prefetchHandleProvider$HandleAndRequestImpl.shouldExecute(prefetchHandleProvider$HandleAndRequestImpl.availableTimeNanos, jCalculateAverageTime + averages.pauseTimeNanos);
        }
        return prefetchHandleProvider$HandleAndRequestImpl.pauseRequested;
    }

    public /* synthetic */ CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(ZoomControl zoomControl, CameraInfoInternal cameraInfoInternal, ArrayList arrayList) {
        this.$r8$classId = 11;
        this.f$0 = cameraInfoInternal;
        this.f$1 = arrayList;
    }

    public /* synthetic */ CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(DefaultSurfaceProcessor defaultSurfaceProcessor, DynamicRange dynamicRange) {
        this.$r8$classId = 7;
        Map map = Collections.EMPTY_MAP;
        this.f$0 = defaultSurfaceProcessor;
        this.f$1 = dynamicRange;
    }

    public /* synthetic */ CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(DualSurfaceProcessor dualSurfaceProcessor, DynamicRange dynamicRange) {
        this.$r8$classId = 9;
        Map map = Collections.EMPTY_MAP;
        this.f$0 = dualSurfaceProcessor;
        this.f$1 = dynamicRange;
    }
}
