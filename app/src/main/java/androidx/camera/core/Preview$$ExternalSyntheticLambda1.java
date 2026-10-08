package androidx.camera.core;

import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.hardware.camera2.TotalCaptureResult;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import android.util.Size;
import android.view.Surface;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda13;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter;
import androidx.camera.core.impl.LiveDataObservable$Result;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter$$ExternalSyntheticLambda1;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.OpenGlRenderer;
import androidx.camera.core.processing.SurfaceOutputImpl;
import androidx.camera.core.processing.concurrent.DualOpenGlRenderer;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.camera.view.TextureViewImplementation;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.platform.WrappedComposition;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.res.CamUtils;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.tracing.Trace;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.intercept.RealInterceptorChain;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import com.google.android.gms.internal.mlkit_vision_barcode.zzst;
import com.google.android.gms.tasks.zzr;
import com.google.mlkit.common.sdkinternal.zzm;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import io.github.g00fy2.quickie.QRCodeAnalyzer;
import io.github.g00fy2.quickie.QROverlayView;
import io.github.g00fy2.quickie.QRScannerActivity;
import io.github.g00fy2.quickie.QRScannerActivity$$ExternalSyntheticLambda0;
import io.github.g00fy2.quickie.QRScannerActivity$sam$androidx_lifecycle_Observer$0;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.android.HandlerContext;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Preview$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Preview$$ExternalSyntheticLambda1(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    private final void run$io$github$g00fy2$quickie$QRScannerActivity$$ExternalSyntheticLambda1() {
        ChainingListenableFuture chainingListenableFuture = (ChainingListenableFuture) this.f$0;
        QRScannerActivity qRScannerActivity = (QRScannerActivity) this.f$1;
        int i = QRScannerActivity.$r8$clinit;
        try {
            ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) chainingListenableFuture.get();
            PreviewConfig previewConfig = new PreviewConfig(OptionsBundle.from(new Preview.Builder(0).mMutableConfig));
            ImageOutputConfig.CC.validateConfig(previewConfig);
            Preview preview = new Preview(previewConfig);
            preview.mSurfaceProviderExecutor = Preview.DEFAULT_SURFACE_PROVIDER_EXECUTOR;
            CacheStrategy cacheStrategy = qRScannerActivity.binding;
            if (cacheStrategy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            preview.setSurfaceProvider(((PreviewView) cacheStrategy.cacheResponse).getSurfaceProvider());
            int i2 = 2;
            Preview.Builder builder = new Preview.Builder(2);
            builder.mMutableConfig.insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, new ResolutionSelector(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY, new ResolutionStrategy(new Size(1280, 720)), null));
            ImageAnalysisConfig imageAnalysisConfig = new ImageAnalysisConfig(OptionsBundle.from(builder.mMutableConfig));
            ImageOutputConfig.CC.validateConfig(imageAnalysisConfig);
            ImageAnalysis imageAnalysis = new ImageAnalysis(imageAnalysisConfig);
            ExecutorService executorService = qRScannerActivity.analysisExecutor;
            if (executorService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analysisExecutor");
                throw null;
            }
            QRCodeAnalyzer qRCodeAnalyzer = new QRCodeAnalyzer(qRScannerActivity.barcodeFormats, new BlurEffectKt$$ExternalSyntheticLambda1(13, imageAnalysis, qRScannerActivity), new QRScannerActivity$$ExternalSyntheticLambda0(qRScannerActivity, 1), new QRScannerActivity$$ExternalSyntheticLambda0(qRScannerActivity, i2));
            synchronized (imageAnalysis.mAnalysisLock) {
                try {
                    imageAnalysis.mImageAnalysisAbstractAnalyzer.setAnalyzer(executorService, new ImageAnalysis$$ExternalSyntheticLambda0(qRCodeAnalyzer));
                    if (imageAnalysis.mSubscribedAnalyzer == null) {
                        imageAnalysis.notifyActive();
                    }
                    imageAnalysis.mSubscribedAnalyzer = qRCodeAnalyzer;
                } catch (Throwable th) {
                    throw th;
                }
            }
            processCameraProvider.getClass();
            Trace.beginSection("CX:unbindAll");
            try {
                CharsKt.checkMainThread();
                ProcessCameraProvider.access$setCameraOperatingMode(processCameraProvider, 0);
                processCameraProvider.mLifecycleCameraRepository.unbindAll();
                Unit unit = Unit.INSTANCE;
                android.os.Trace.endSection();
                try {
                    LifecycleCamera lifecycleCameraBindToLifecycle = processCameraProvider.bindToLifecycle(qRScannerActivity, qRScannerActivity.useFrontCamera ? CameraSelector.DEFAULT_FRONT_CAMERA : CameraSelector.DEFAULT_BACK_CAMERA, preview, imageAnalysis);
                    CacheStrategy cacheStrategy2 = qRScannerActivity.binding;
                    if (cacheStrategy2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) cacheStrategy2.networkRequest).setVisibility(0);
                    CacheStrategy cacheStrategy3 = qRScannerActivity.binding;
                    if (cacheStrategy3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) cacheStrategy3.networkRequest).setCloseVisibilityAndOnClick(qRScannerActivity.showCloseButton, new BitmapFactoryDecoder$$ExternalSyntheticLambda2(17, qRScannerActivity));
                    if (!qRScannerActivity.showTorchToggle || !lifecycleCameraBindToLifecycle.mCameraUseCaseAdapter.mAdapterCameraInfo.mCameraInfo.hasFlashUnit()) {
                        CacheStrategy cacheStrategy4 = qRScannerActivity.binding;
                        if (cacheStrategy4 != null) {
                            ((QROverlayView) cacheStrategy4.networkRequest).setTorchVisibilityAndOnClick(new Remote$$ExternalSyntheticLambda1(19), false);
                            return;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            throw null;
                        }
                    }
                    CacheStrategy cacheStrategy5 = qRScannerActivity.binding;
                    if (cacheStrategy5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) cacheStrategy5.networkRequest).setTorchVisibilityAndOnClick(new DiskLruCache$$ExternalSyntheticLambda0(16, lifecycleCameraBindToLifecycle), true);
                    lifecycleCameraBindToLifecycle.mCameraUseCaseAdapter.mAdapterCameraInfo.mCameraInfo.getTorchState().observe(qRScannerActivity, new QRScannerActivity$sam$androidx_lifecycle_Observer$0(new QRScannerActivity$$ExternalSyntheticLambda0(qRScannerActivity, 3)));
                } catch (Exception e) {
                    CacheStrategy cacheStrategy6 = qRScannerActivity.binding;
                    if (cacheStrategy6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) cacheStrategy6.networkRequest).setVisibility(4);
                    qRScannerActivity.onFailure(e);
                }
            } catch (Throwable th2) {
                android.os.Trace.endSection();
                throw th2;
            }
        } catch (Exception e2) {
            qRScannerActivity.onFailure(e2);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 2;
        int i2 = 1;
        switch (this.$r8$classId) {
            case 0:
                ((Preview.SurfaceProvider) this.f$0).onSurfaceRequested((SurfaceRequest) this.f$1);
                return;
            case 1:
                AppCompatActivity appCompatActivity = (AppCompatActivity) this.f$0;
                appCompatActivity.lifecycleRegistry.addObserver(new ComponentActivity$$ExternalSyntheticLambda13((OnBackPressedDispatcher) this.f$1, appCompatActivity));
                return;
            case 2:
                zzm zzmVar = (zzm) this.f$0;
                Runnable runnable = (Runnable) this.f$1;
                zzmVar.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    zzmVar.scheduleNext();
                }
            case 3:
                Camera2CameraControlImpl camera2CameraControlImpl = (Camera2CameraControlImpl) this.f$0;
                CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback) this.f$1;
                PreviewStreamStateObserver$2 previewStreamStateObserver$2 = camera2CameraControlImpl.mCameraCaptureCallbackSet;
                ((HashSet) previewStreamStateObserver$2.val$completer).remove(cameraCaptureCallback);
                ((ArrayMap) previewStreamStateObserver$2.val$cameraInfo).remove(cameraCaptureCallback);
                return;
            case 4:
                final Camera2CameraControlImpl camera2CameraControlImpl2 = (Camera2CameraControlImpl) this.f$0;
                CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.f$1;
                final long jUpdateSessionConfigSynchronous = camera2CameraControlImpl2.updateSessionConfigSynchronous();
                Futures.propagateTransform(true, CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.Camera2CameraControlImpl$$ExternalSyntheticLambda0
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer2) {
                        final long j = jUpdateSessionConfigSynchronous;
                        camera2CameraControlImpl2.addCaptureResultListener(new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.Camera2CameraControlImpl$$ExternalSyntheticLambda2
                            /* JADX WARN: Code duplicated, block: B:13:0x002e  */
                            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
                            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                                boolean z;
                                Long l;
                                if (totalCaptureResult.getRequest() == null) {
                                    z = false;
                                } else {
                                    Object tag = totalCaptureResult.getRequest().getTag();
                                    if (!(tag instanceof TagBundle) || (l = (Long) ((TagBundle) tag).mTagMap.get("CameraControlSessionUpdateId")) == null || l.longValue() < j) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    return false;
                                }
                                completer2.set(null);
                                return true;
                            }
                        });
                        return "waitForSessionUpdateId:" + j;
                    }
                }), completer, HexFormatKt.directExecutor());
                return;
            case 5:
                CameraBurstCaptureCallback cameraBurstCaptureCallback = (CameraBurstCaptureCallback) this.f$0;
                TotalCaptureResult totalCaptureResult = (TotalCaptureResult) this.f$1;
                HashSet hashSet = new HashSet();
                HashSet<Camera2CameraControlImpl.CaptureResultListener> hashSet2 = (HashSet) cameraBurstCaptureCallback.mCallbackMap;
                for (Camera2CameraControlImpl.CaptureResultListener captureResultListener : hashSet2) {
                    if (captureResultListener.onCaptureResult(totalCaptureResult)) {
                        hashSet.add(captureResultListener);
                    }
                }
                if (hashSet.isEmpty()) {
                    return;
                }
                hashSet2.removeAll(hashSet);
                return;
            case 6:
                Surface surface = (Surface) this.f$0;
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.f$1;
                surface.release();
                surfaceTexture.release();
                return;
            case 7:
                Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) this.f$0;
                CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) this.f$1;
                Http2Connection.Builder builder = camera2CameraImpl.mMeteringRepeatingSession;
                if (builder == null) {
                    completer2.set(Boolean.FALSE);
                    return;
                } else {
                    completer2.set(Boolean.valueOf(camera2CameraImpl.mUseCaseAttachState.isUseCaseAttached(Camera2CameraImpl.getMeteringRepeatingId(builder))));
                    return;
                }
            case 8:
                Camera2CameraImpl camera2CameraImpl2 = (Camera2CameraImpl) this.f$0;
                String str = (String) this.f$1;
                camera2CameraImpl2.debugLog("Use case " + str + " INACTIVE", null);
                LinkedHashMap linkedHashMap = (LinkedHashMap) camera2CameraImpl2.mUseCaseAttachState.val$requestCancellationFuture;
                if (linkedHashMap.containsKey(str)) {
                    UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(str);
                    useCaseAttachState$UseCaseAttachInfo.mActive = false;
                    if (!useCaseAttachState$UseCaseAttachInfo.mAttached) {
                        linkedHashMap.remove(str);
                    }
                }
                camera2CameraImpl2.updateCaptureSessionConfig();
                return;
            case 9:
                ((SessionConfig.ErrorListener) this.f$0).onError((SessionConfig) this.f$1);
                return;
            case 10:
                zzr zzrVar = (zzr) this.f$0;
                ImageReaderProxy.OnImageAvailableListener onImageAvailableListener = (ImageReaderProxy.OnImageAvailableListener) this.f$1;
                zzrVar.getClass();
                onImageAvailableListener.onImageAvailable(zzrVar);
                return;
            case 11:
                RealInterceptorChain realInterceptorChain = (RealInterceptorChain) this.f$0;
                RealInterceptorChain realInterceptorChain2 = (RealInterceptorChain) this.f$1;
                realInterceptorChain.safeClose();
                if (realInterceptorChain2 != null) {
                    realInterceptorChain2.safeClose();
                    return;
                }
                return;
            case 12:
                MetadataImageReader metadataImageReader = (MetadataImageReader) this.f$0;
                ImageReaderProxy.OnImageAvailableListener onImageAvailableListener2 = (ImageReaderProxy.OnImageAvailableListener) this.f$1;
                metadataImageReader.getClass();
                onImageAvailableListener2.onImageAvailable(metadataImageReader);
                return;
            case 13:
                DeferrableSurface deferrableSurface = (DeferrableSurface) this.f$0;
                String str2 = (String) this.f$1;
                try {
                    deferrableSurface.mTerminationFuture.get();
                    deferrableSurface.printGlobalDebugCounts(DeferrableSurface.TOTAL_COUNT.decrementAndGet(), DeferrableSurface.USED_COUNT.get(), "Surface terminated");
                    return;
                } catch (Exception e) {
                    Logger.e("DeferrableSurface", "Unexpected surface termination for " + deferrableSurface + "\nStack Trace:\n" + str2);
                    synchronized (deferrableSurface.mLock) {
                        try {
                            throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", deferrableSurface, Boolean.valueOf(deferrableSurface.mClosed), Integer.valueOf(deferrableSurface.mUseCount)), e);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            case 14:
                ((MutableLiveData) ((SurfaceRequest.AnonymousClass1) this.f$0).val$requestCancellationCompleter).removeObserver((LiveDataObservable$LiveDataObserverAdapter) this.f$1);
                return;
            case 15:
                LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = (LiveDataObservable$LiveDataObserverAdapter) this.f$0;
                LiveDataObservable$Result liveDataObservable$Result = (LiveDataObservable$Result) this.f$1;
                if (liveDataObservable$LiveDataObserverAdapter.mActive.get()) {
                    liveDataObservable$Result.getClass();
                    liveDataObservable$LiveDataObserverAdapter.mObserver.onNewData(liveDataObservable$Result.mValue);
                    return;
                }
                return;
            case 16:
                DefaultSurfaceProcessor defaultSurfaceProcessor = (DefaultSurfaceProcessor) this.f$0;
                SurfaceOutputImpl surfaceOutputImpl = (SurfaceOutputImpl) this.f$1;
                Surface surface2 = surfaceOutputImpl.getSurface(defaultSurfaceProcessor.mGlExecutor, new CameraUseCaseAdapter$$ExternalSyntheticLambda1(i2, defaultSurfaceProcessor, surfaceOutputImpl));
                defaultSurfaceProcessor.mGlRenderer.registerOutputSurface(surface2);
                defaultSurfaceProcessor.mOutputSurfaces.put(surfaceOutputImpl, surface2);
                return;
            case 17:
                final DefaultSurfaceProcessor defaultSurfaceProcessor2 = (DefaultSurfaceProcessor) this.f$0;
                final SurfaceRequest surfaceRequest = (SurfaceRequest) this.f$1;
                defaultSurfaceProcessor2.mInputSurfaceCount++;
                OpenGlRenderer openGlRenderer = defaultSurfaceProcessor2.mGlRenderer;
                GLUtils.checkInitializedOrThrow((AtomicBoolean) openGlRenderer.mInitialized, true);
                GLUtils.checkGlThreadOrThrow((Thread) openGlRenderer.mGlThread);
                final SurfaceTexture surfaceTexture2 = new SurfaceTexture(openGlRenderer.mExternalTextureId);
                Size size = surfaceRequest.mResolution;
                surfaceTexture2.setDefaultBufferSize(size.getWidth(), size.getHeight());
                final Surface surface3 = new Surface(surfaceTexture2);
                HandlerScheduledExecutorService handlerScheduledExecutorService = defaultSurfaceProcessor2.mGlExecutor;
                surfaceRequest.setTransformationInfoListener(handlerScheduledExecutorService, new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(8, defaultSurfaceProcessor2, surfaceRequest));
                surfaceRequest.provideSurface(surface3, handlerScheduledExecutorService, new Consumer() { // from class: androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda8
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        DefaultSurfaceProcessor defaultSurfaceProcessor3 = defaultSurfaceProcessor2;
                        SurfaceRequest surfaceRequest2 = surfaceRequest;
                        SurfaceTexture surfaceTexture3 = surfaceTexture2;
                        Surface surface4 = surface3;
                        defaultSurfaceProcessor3.getClass();
                        synchronized (surfaceRequest2.mLock) {
                            surfaceRequest2.mTransformationInfoListener = null;
                            surfaceRequest2.mTransformationInfoExecutor = null;
                        }
                        surfaceTexture3.setOnFrameAvailableListener(null);
                        surfaceTexture3.release();
                        surface4.release();
                        defaultSurfaceProcessor3.mInputSurfaceCount--;
                        defaultSurfaceProcessor3.checkReadyToRelease();
                    }
                });
                surfaceTexture2.setOnFrameAvailableListener(defaultSurfaceProcessor2, defaultSurfaceProcessor2.mGlHandler);
                return;
            case 18:
                ((Consumer) ((AtomicReference) this.f$1).get()).accept(new AutoValue_SurfaceOutput_Event((SurfaceOutputImpl) this.f$0));
                return;
            case 19:
                final DualSurfaceProcessor dualSurfaceProcessor = (DualSurfaceProcessor) this.f$0;
                SurfaceRequest surfaceRequest2 = (SurfaceRequest) this.f$1;
                dualSurfaceProcessor.mInputSurfaceCount++;
                DualOpenGlRenderer dualOpenGlRenderer = dualSurfaceProcessor.mGlRenderer;
                boolean z = surfaceRequest2.mIsPrimary;
                Size size2 = surfaceRequest2.mResolution;
                GLUtils.checkInitializedOrThrow((AtomicBoolean) dualOpenGlRenderer.mInitialized, true);
                GLUtils.checkGlThreadOrThrow((Thread) dualOpenGlRenderer.mGlThread);
                final SurfaceTexture surfaceTexture3 = new SurfaceTexture(z ? dualOpenGlRenderer.mPrimaryExternalTextureId : dualOpenGlRenderer.mSecondaryExternalTextureId);
                surfaceTexture3.setDefaultBufferSize(size2.getWidth(), size2.getHeight());
                final Surface surface4 = new Surface(surfaceTexture3);
                surfaceRequest2.provideSurface(surface4, dualSurfaceProcessor.mGlExecutor, new Consumer() { // from class: androidx.camera.core.processing.concurrent.DualSurfaceProcessor$$ExternalSyntheticLambda7
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        DualSurfaceProcessor dualSurfaceProcessor2 = dualSurfaceProcessor;
                        dualSurfaceProcessor2.getClass();
                        SurfaceTexture surfaceTexture4 = surfaceTexture3;
                        surfaceTexture4.setOnFrameAvailableListener(null);
                        surfaceTexture4.release();
                        surface4.release();
                        dualSurfaceProcessor2.mInputSurfaceCount--;
                        dualSurfaceProcessor2.checkReadyToRelease$1();
                    }
                });
                if (z) {
                    dualSurfaceProcessor.mPrimarySurfaceTexture = surfaceTexture3;
                    return;
                } else {
                    dualSurfaceProcessor.mSecondarySurfaceTexture = surfaceTexture3;
                    surfaceTexture3.setOnFrameAvailableListener(dualSurfaceProcessor, dualSurfaceProcessor.mGlHandler);
                    return;
                }
            case 20:
                DualSurfaceProcessor dualSurfaceProcessor2 = (DualSurfaceProcessor) this.f$0;
                SurfaceOutputImpl surfaceOutputImpl2 = (SurfaceOutputImpl) this.f$1;
                Surface surface5 = surfaceOutputImpl2.getSurface(dualSurfaceProcessor2.mGlExecutor, new CameraUseCaseAdapter$$ExternalSyntheticLambda1(i, dualSurfaceProcessor2, surfaceOutputImpl2));
                dualSurfaceProcessor2.mGlRenderer.registerOutputSurface(surface5);
                dualSurfaceProcessor2.mOutputSurfaces.put(surfaceOutputImpl2, surface5);
                return;
            case 21:
                ((PreviewView) ((PreviewView.AnonymousClass1) this.f$0).this$0).mSurfaceProvider.onSurfaceRequested((SurfaceRequest) this.f$1);
                return;
            case 22:
                TextureViewImplementation textureViewImplementation = (TextureViewImplementation) this.f$0;
                SurfaceRequest surfaceRequest3 = (SurfaceRequest) this.f$1;
                SurfaceRequest surfaceRequest4 = textureViewImplementation.mSurfaceRequest;
                if (surfaceRequest4 != null && surfaceRequest4 == surfaceRequest3) {
                    textureViewImplementation.mSurfaceRequest = null;
                    textureViewImplementation.mSurfaceReleaseFuture = null;
                }
                PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2 = textureViewImplementation.mOnSurfaceNotInUseListener;
                if (previewView$1$$ExternalSyntheticLambda2 != null) {
                    previewView$1$$ExternalSyntheticLambda2.onSurfaceNotInUse();
                    textureViewImplementation.mOnSurfaceNotInUseListener = null;
                    return;
                }
                return;
            case 23:
                zzst.doTranslation((AndroidContentCaptureManager) this.f$0, (LongSparseArray) this.f$1);
                return;
            case 24:
                WrappedComposition wrappedComposition = (WrappedComposition) this.f$0;
                Lifecycle lifecycle = (Lifecycle) this.f$1;
                if (wrappedComposition.disposed) {
                    return;
                }
                wrappedComposition.addedToLifecycle = lifecycle;
                lifecycle.addObserver(wrappedComposition);
                return;
            case 25:
                ((CamUtils) this.f$0).onFontRetrieved((Typeface) this.f$1);
                return;
            case 26:
                run$io$github$g00fy2$quickie$QRScannerActivity$$ExternalSyntheticLambda1();
                return;
            default:
                ((CancellableContinuationImpl) this.f$0).resumeUndispatched((HandlerContext) this.f$1, Unit.INSTANCE);
                return;
        }
    }
}
