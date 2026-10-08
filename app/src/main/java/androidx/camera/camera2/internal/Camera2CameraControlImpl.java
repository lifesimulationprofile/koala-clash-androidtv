package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageWriter;
import android.os.Build;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Range;
import android.util.Size;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.Camera2CameraControl$$ExternalSyntheticLambda3;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda4;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.camera.core.internal.AutoValue_ImmutableZoomState;
import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.ui.geometry.MutableRect;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.MutableLiveData;
import coil.intercept.RealInterceptorChain;
import com.google.android.gms.dynamite.zze;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.zxing.WriterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.json.internal.Composer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraControlImpl implements CameraControlInternal {
    public final PreviewView.AnonymousClass1 mAeFpsRange;
    public final FlowLayoutBuildingBlocks.WrapInfo mAutoFlashAEModeDisabler;
    public final Camera2CameraControl mCamera2CameraControl;
    public final zze mCamera2CapturePipeline;
    public final PreviewStreamStateObserver$2 mCameraCaptureCallbackSet;
    public final CameraCharacteristicsCompat mCameraCharacteristics;
    public final Toolbar.AnonymousClass1 mControlUpdateCallback;
    public long mCurrentSessionUpdateId;
    public final SequentialExecutor mExecutor;
    public final Composer mExposureControl;
    public volatile int mFlashMode;
    public final FocusMeteringControl mFocusMeteringControl;
    public volatile boolean mIsTorchOn;
    public final Object mLock = new Object();
    public final AtomicLong mNextSessionUpdateId;
    public final CameraBurstCaptureCallback mSessionCallback;
    public final SessionConfig.Builder mSessionConfigBuilder;
    public int mTemplate;
    public final TorchControl mTorchControl;
    public int mUseCount;
    public final PreviewView.AnonymousClass1 mVideoUsageControl;
    public final ZoomControl mZoomControl;
    public final ZslControlImpl mZslControl;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface CaptureResultListener {
        boolean onCaptureResult(TotalCaptureResult totalCaptureResult);
    }

    public Camera2CameraControlImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat, HandlerScheduledExecutorService handlerScheduledExecutorService, SequentialExecutor sequentialExecutor, Toolbar.AnonymousClass1 anonymousClass1, Quirks quirks) {
        SessionConfig.Builder builder = new SessionConfig.Builder();
        this.mSessionConfigBuilder = builder;
        this.mUseCount = 0;
        this.mIsTorchOn = false;
        this.mFlashMode = 2;
        this.mNextSessionUpdateId = new AtomicLong(0L);
        this.mTemplate = 1;
        this.mCurrentSessionUpdateId = 0L;
        PreviewStreamStateObserver$2 previewStreamStateObserver$2 = new PreviewStreamStateObserver$2();
        previewStreamStateObserver$2.val$completer = new HashSet();
        previewStreamStateObserver$2.val$cameraInfo = new ArrayMap();
        this.mCameraCaptureCallbackSet = previewStreamStateObserver$2;
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
        this.mControlUpdateCallback = anonymousClass1;
        this.mExecutor = sequentialExecutor;
        this.mVideoUsageControl = new PreviewView.AnonymousClass1(8);
        CameraBurstCaptureCallback cameraBurstCaptureCallback = new CameraBurstCaptureCallback(sequentialExecutor);
        this.mSessionCallback = cameraBurstCaptureCallback;
        builder.mCaptureConfigBuilder.index = this.mTemplate;
        builder.mCaptureConfigBuilder.addCameraCaptureCallback(new CaptureCallbackContainer(cameraBurstCaptureCallback));
        builder.mCaptureConfigBuilder.addCameraCaptureCallback(previewStreamStateObserver$2);
        this.mExposureControl = new Composer(this);
        this.mFocusMeteringControl = new FocusMeteringControl(this, sequentialExecutor);
        this.mZoomControl = new ZoomControl(this, cameraCharacteristicsCompat);
        this.mTorchControl = new TorchControl(this, cameraCharacteristicsCompat, sequentialExecutor);
        this.mZslControl = new ZslControlImpl(cameraCharacteristicsCompat);
        this.mAeFpsRange = new PreviewView.AnonymousClass1(quirks, 11);
        this.mAutoFlashAEModeDisabler = new FlowLayoutBuildingBlocks.WrapInfo(quirks, 1);
        this.mCamera2CameraControl = new Camera2CameraControl(this, sequentialExecutor);
        this.mCamera2CapturePipeline = new zze(this, cameraCharacteristicsCompat, quirks, sequentialExecutor, handlerScheduledExecutorService);
    }

    public static int getSupportedAeMode(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i) {
        int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (isModeInList(iArr, i)) {
            return i;
        }
        return isModeInList(iArr, 1) ? 1 : 0;
    }

    public static boolean isModeInList(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public final void addCaptureResultListener(CaptureResultListener captureResultListener) {
        ((HashSet) this.mSessionCallback.mCallbackMap).add(captureResultListener);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final void addInteropConfig(Config config) {
        Camera2CameraControl camera2CameraControl = this.mCamera2CameraControl;
        Toolbar.AnonymousClass1 anonymousClass1Build = Preview.Builder.from(config).build();
        synchronized (camera2CameraControl.mLock) {
            ImageCapture.Builder builder = camera2CameraControl.mBuilder;
            builder.getClass();
            Config.OptionPriority optionPriority = Config.OptionPriority.OPTIONAL;
            for (AutoValue_Config_Option autoValue_Config_Option : anonymousClass1Build.listOptions()) {
                builder.mMutableConfig.insertOption(autoValue_Config_Option, optionPriority, anonymousClass1Build.retrieveOption(autoValue_Config_Option));
            }
        }
        int i = 0;
        Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new Camera2CameraControl$$ExternalSyntheticLambda3(camera2CameraControl, i))).addListener(new Camera2CameraControlImpl$$ExternalSyntheticLambda4(i), HexFormatKt.directExecutor());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final void addZslConfig(SessionConfig.Builder builder) throws Exception {
        boolean zIsEmpty;
        HashMap map;
        StreamConfigurationMap streamConfigurationMap;
        int[] validOutputFormatsForInput;
        ZslControlImpl zslControlImpl = this.mZslControl;
        MenuHostHelper menuHostHelper = zslControlImpl.mImageRingBuffer;
        while (true) {
            synchronized (menuHostHelper.mMenuProviders) {
                zIsEmpty = ((ArrayDeque) menuHostHelper.mOnInvalidateMenuCallback).isEmpty();
            }
            if (zIsEmpty) {
                break;
            } else {
                ((ImageProxy) menuHostHelper.dequeue()).close();
            }
        }
        SurfaceRequest.AnonymousClass2 anonymousClass2 = zslControlImpl.mReprocessingImageDeferrableSurface;
        StreamConfigurationMap streamConfigurationMap2 = null;
        if (anonymousClass2 != null) {
            RealInterceptorChain realInterceptorChain = zslControlImpl.mReprocessingImageReader;
            if (realInterceptorChain != null) {
                Futures.nonCancellationPropagating(anonymousClass2.mTerminationFuture).addListener(new CaptureNode$$ExternalSyntheticLambda4(realInterceptorChain, 1), HexFormatKt.mainThreadExecutor());
                zslControlImpl.mReprocessingImageReader = null;
            }
            anonymousClass2.close();
            zslControlImpl.mReprocessingImageDeferrableSurface = null;
        }
        ImageWriter imageWriter = zslControlImpl.mReprocessingImageWriter;
        if (imageWriter != null) {
            imageWriter.close();
            zslControlImpl.mReprocessingImageWriter = null;
        }
        if (zslControlImpl.mIsZslDisabledByUseCaseConfig) {
            builder.mCaptureConfigBuilder.index = 1;
            return;
        }
        if (zslControlImpl.mShouldZslDisabledByQuirks) {
            builder.mCaptureConfigBuilder.index = 1;
            return;
        }
        try {
            streamConfigurationMap2 = (StreamConfigurationMap) zslControlImpl.mCameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (AssertionError e) {
            Logger.e("ZslControlImpl", "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
        }
        if (streamConfigurationMap2 == null || streamConfigurationMap2.getInputFormats() == null) {
            map = new HashMap();
        } else {
            map = new HashMap();
            for (int i : streamConfigurationMap2.getInputFormats()) {
                Size[] inputSizes = streamConfigurationMap2.getInputSizes(i);
                if (inputSizes != null) {
                    Arrays.sort(inputSizes, new CompareSizesByArea(true));
                    map.put(Integer.valueOf(i), inputSizes[0]);
                }
            }
        }
        if (zslControlImpl.mIsPrivateReprocessingSupported && !map.isEmpty() && map.containsKey(34) && (streamConfigurationMap = (StreamConfigurationMap) zslControlImpl.mCameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)) != null && (validOutputFormatsForInput = streamConfigurationMap.getValidOutputFormatsForInput(34)) != null) {
            for (int i2 : validOutputFormatsForInput) {
                if (i2 == 256) {
                    Size size = (Size) map.get(34);
                    MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), 34, 9);
                    zslControlImpl.mMetadataMatchingCaptureCallback = metadataImageReader.mCameraCaptureCallback;
                    zslControlImpl.mReprocessingImageReader = new RealInterceptorChain(metadataImageReader);
                    metadataImageReader.setOnImageAvailableListener(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(4, zslControlImpl), HexFormatKt.ioExecutor());
                    SurfaceRequest.AnonymousClass2 anonymousClass3 = new SurfaceRequest.AnonymousClass2(zslControlImpl.mReprocessingImageReader.getSurface(), new Size(zslControlImpl.mReprocessingImageReader.getWidth(), zslControlImpl.mReprocessingImageReader.getHeight()), 34);
                    zslControlImpl.mReprocessingImageDeferrableSurface = anonymousClass3;
                    RealInterceptorChain realInterceptorChain2 = zslControlImpl.mReprocessingImageReader;
                    ListenableFuture listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(anonymousClass3.mTerminationFuture);
                    Objects.requireNonNull(realInterceptorChain2);
                    listenableFutureNonCancellationPropagating.addListener(new CaptureNode$$ExternalSyntheticLambda4(realInterceptorChain2, 1), HexFormatKt.mainThreadExecutor());
                    builder.addSurface(zslControlImpl.mReprocessingImageDeferrableSurface, DynamicRange.SDR, -1);
                    MetadataImageReader.AnonymousClass1 anonymousClass1 = zslControlImpl.mMetadataMatchingCaptureCallback;
                    builder.mCaptureConfigBuilder.addCameraCaptureCallback(anonymousClass1);
                    ArrayList arrayList = builder.mSingleCameraCaptureCallbacks;
                    if (!arrayList.contains(anonymousClass1)) {
                        arrayList.add(anonymousClass1);
                    }
                    ZslControlImpl.AnonymousClass1 anonymousClass4 = new ZslControlImpl.AnonymousClass1(0, zslControlImpl);
                    ArrayList arrayList2 = builder.mSessionStateCallbacks;
                    if (!arrayList2.contains(anonymousClass4)) {
                        arrayList2.add(anonymousClass4);
                    }
                    builder.mInputConfiguration = new InputConfiguration(zslControlImpl.mReprocessingImageReader.getWidth(), zslControlImpl.mReprocessingImageReader.getHeight(), zslControlImpl.mReprocessingImageReader.getImageFormat());
                    return;
                }
            }
        }
        builder.mCaptureConfigBuilder.index = 1;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final void clearInteropConfig() {
        Camera2CameraControl camera2CameraControl = this.mCamera2CameraControl;
        synchronized (camera2CameraControl.mLock) {
            camera2CameraControl.mBuilder = new ImageCapture.Builder(1);
        }
        Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new Camera2CameraControl$$ExternalSyntheticLambda3(camera2CameraControl, 1))).addListener(new Camera2CameraControlImpl$$ExternalSyntheticLambda4(0), HexFormatKt.directExecutor());
    }

    public final void decrementUseCount() {
        synchronized (this.mLock) {
            try {
                int i = this.mUseCount;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                this.mUseCount = i - 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final ListenableFuture enableTorch(final boolean z) {
        ListenableFuture future;
        if (!isControlInUse()) {
            return new ImmediateFuture$ImmediateFailedFuture(0, new WriterException("Camera is not active."));
        }
        final TorchControl torchControl = this.mTorchControl;
        if (torchControl.mHasFlashUnit) {
            TorchControl.setLiveDataValue(torchControl.mTorchState, Integer.valueOf(z ? 1 : 0));
            future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.TorchControl$$ExternalSyntheticLambda0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                    final TorchControl torchControl2 = torchControl;
                    SequentialExecutor sequentialExecutor = torchControl2.mExecutor;
                    final boolean z2 = z;
                    sequentialExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.TorchControl$$ExternalSyntheticLambda2
                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                         */
                        @Override // java.lang.Runnable
                        public final void run() {
                            TorchControl torchControl3 = torchControl2;
                            MutableLiveData mutableLiveData = torchControl3.mTorchState;
                            boolean z3 = torchControl3.mHasFlashUnit;
                            CallbackToFutureAdapter.Completer completer2 = completer;
                            if (!z3) {
                                if (completer2 != null) {
                                    completer2.setException(new IllegalStateException("No flash unit"));
                                }
                            } else {
                                if (!torchControl3.mIsActive) {
                                    TorchControl.setLiveDataValue(mutableLiveData, 0);
                                    if (completer2 != null) {
                                        completer2.setException(new WriterException("Camera is not active."));
                                        return;
                                    }
                                    return;
                                }
                                boolean z4 = z2;
                                torchControl3.mTargetTorchEnabled = z4;
                                torchControl3.mCamera2CameraControlImpl.enableTorchInternal(z4);
                                TorchControl.setLiveDataValue(mutableLiveData, Integer.valueOf(z4 ? 1 : 0));
                                CallbackToFutureAdapter.Completer completer3 = torchControl3.mEnableTorchCompleter;
                                if (completer3 != null) {
                                    completer3.setException(new WriterException("There is a new enableTorch being set"));
                                }
                                torchControl3.mEnableTorchCompleter = completer2;
                            }
                        }
                    });
                    return "enableTorch: " + z2;
                }
            });
        } else {
            Logger.d("TorchControl", "Unable to enableTorch due to there is no flash unit.");
            future = new ImmediateFuture$ImmediateFailedFuture(0, new IllegalStateException("No flash unit"));
        }
        return Futures.nonCancellationPropagating(future);
    }

    public final void enableTorchInternal(boolean z) {
        this.mIsTorchOn = z;
        if (!z) {
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain();
            realInterceptorChain.index = this.mTemplate;
            realInterceptorChain.isPlaceholderCached = true;
            MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
            mutableOptionsBundleCreate.insertOption(Camera2ImplConfig.createCaptureRequestOption(key), Integer.valueOf(getSupportedAeMode(this.mCameraCharacteristics, 1)));
            mutableOptionsBundleCreate.insertOption(Camera2ImplConfig.createCaptureRequestOption(CaptureRequest.FLASH_MODE), 0);
            realInterceptorChain.addImplementationOptions(new Camera2ImplConfig(14, OptionsBundle.from(mutableOptionsBundleCreate)));
            submitCaptureRequestsInternal(Collections.singletonList(realInterceptorChain.build()));
        }
        updateSessionConfigSynchronous();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final Config getInteropConfig() {
        Camera2ImplConfig camera2ImplConfig;
        Camera2CameraControl camera2CameraControl = this.mCamera2CameraControl;
        synchronized (camera2CameraControl.mLock) {
            ImageCapture.Builder builder = camera2CameraControl.mBuilder;
            builder.getClass();
            camera2ImplConfig = new Camera2ImplConfig(14, OptionsBundle.from(builder.mMutableConfig));
        }
        return camera2ImplConfig;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final Rect getSensorRect() {
        Rect rect = (Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if ("robolectric".equals(Build.FINGERPRINT) && rect == null) {
            return new Rect(0, 0, 4000, 3000);
        }
        rect.getClass();
        return rect;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0036  */
    public final SessionConfig getSessionConfig() {
        int[] iArr;
        Composer composer;
        SessionConfig.Builder builder = this.mSessionConfigBuilder;
        builder.mCaptureConfigBuilder.index = this.mTemplate;
        ImageCapture.Builder builder2 = new ImageCapture.Builder(1);
        int i = 1;
        builder2.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_MODE, 1);
        FocusMeteringControl focusMeteringControl = this.mFocusMeteringControl;
        focusMeteringControl.getClass();
        int i2 = 3;
        int i3 = focusMeteringControl.mTemplate != 3 ? 4 : 3;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
        int[] iArr2 = (int[]) focusMeteringControl.mCameraControl.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr2 == null) {
            i3 = 0;
        } else if (!isModeInList(iArr2, i3)) {
            i3 = 4;
            if (!isModeInList(iArr2, 4)) {
                i3 = 1;
                if (!isModeInList(iArr2, 1)) {
                    i3 = 0;
                }
            }
        }
        builder2.setCaptureRequestOptionWithPriority(key, Integer.valueOf(i3));
        MeteringRectangle[] meteringRectangleArr = focusMeteringControl.mAfRects;
        if (meteringRectangleArr.length != 0) {
            builder2.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        MeteringRectangle[] meteringRectangleArr2 = focusMeteringControl.mAeRects;
        if (meteringRectangleArr2.length != 0) {
            builder2.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        }
        MeteringRectangle[] meteringRectangleArr3 = focusMeteringControl.mAwbRects;
        if (meteringRectangleArr3.length != 0) {
            builder2.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3);
        }
        Range range = (Range) this.mAeFpsRange.this$0;
        if (range != null) {
            builder2.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
        }
        ((ZoomControl.ZoomImpl) this.mZoomControl.mZoomImpl).addRequestOption(builder2);
        int i4 = this.mFocusMeteringControl.mIsExternalFlashAeModeEnabled ? 5 : 1;
        if (!this.mIsTorchOn) {
            int i5 = this.mFlashMode;
            if (i5 == 0) {
                FlowLayoutBuildingBlocks.WrapInfo wrapInfo = this.mAutoFlashAEModeDisabler;
                if (wrapInfo.isLastItemInLine || wrapInfo.isLastItemInContainer) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
            } else if (i5 != 1) {
                if (i5 == 2) {
                    i2 = 1;
                }
            }
            builder2.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(this.mCameraCharacteristics, i2)));
            CaptureRequest.Key key2 = CaptureRequest.CONTROL_AWB_MODE;
            iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
            if (iArr != null || (!isModeInList(iArr, 1) && !isModeInList(iArr, 1))) {
                i = 0;
            }
            builder2.setCaptureRequestOptionWithPriority(key2, Integer.valueOf(i));
            composer = this.mExposureControl;
            composer.getClass();
            CaptureRequest.Key key3 = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
            synchronized (((ExposureStateImpl) composer.writer).mLock) {
            }
            builder2.setCaptureRequestOptionWithPriority(key3, 0);
            this.mCamera2CameraControl.applyOptionsToBuilder(builder2);
            Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(14, OptionsBundle.from(builder2.mMutableConfig));
            RealInterceptorChain realInterceptorChain = builder.mCaptureConfigBuilder;
            realInterceptorChain.getClass();
            realInterceptorChain.request = MutableOptionsBundle.from((Config) camera2ImplConfig);
            ((MutableTagBundle) this.mSessionConfigBuilder.mCaptureConfigBuilder.size).mTagMap.put("CameraControlSessionUpdateId", Long.valueOf(this.mCurrentSessionUpdateId));
            return this.mSessionConfigBuilder.build();
        }
        builder2.setCaptureRequestOptionWithPriority(CaptureRequest.FLASH_MODE, 2);
        i2 = i4;
        builder2.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(this.mCameraCharacteristics, i2)));
        CaptureRequest.Key key4 = CaptureRequest.CONTROL_AWB_MODE;
        iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr != null) {
            i = 0;
        } else {
            i = 0;
        }
        builder2.setCaptureRequestOptionWithPriority(key4, Integer.valueOf(i));
        composer = this.mExposureControl;
        composer.getClass();
        CaptureRequest.Key key5 = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
        synchronized (((ExposureStateImpl) composer.writer).mLock) {
            builder2.setCaptureRequestOptionWithPriority(key5, 0);
            this.mCamera2CameraControl.applyOptionsToBuilder(builder2);
            Camera2ImplConfig camera2ImplConfig2 = new Camera2ImplConfig(14, OptionsBundle.from(builder2.mMutableConfig));
            RealInterceptorChain realInterceptorChain2 = builder.mCaptureConfigBuilder;
            realInterceptorChain2.getClass();
            realInterceptorChain2.request = MutableOptionsBundle.from((Config) camera2ImplConfig2);
            ((MutableTagBundle) this.mSessionConfigBuilder.mCaptureConfigBuilder.size).mTagMap.put("CameraControlSessionUpdateId", Long.valueOf(this.mCurrentSessionUpdateId));
            return this.mSessionConfigBuilder.build();
        }
    }

    public final boolean isControlInUse() {
        int i;
        synchronized (this.mLock) {
            i = this.mUseCount;
        }
        return i > 0;
    }

    public final void setActive(boolean z) {
        AutoValue_ImmutableZoomState autoValue_ImmutableZoomState;
        Logger.d("Camera2CameraControlImp", "setActive: isActive = " + z);
        FocusMeteringControl focusMeteringControl = this.mFocusMeteringControl;
        if (z != focusMeteringControl.mIsActive) {
            focusMeteringControl.mIsActive = z;
            if (!focusMeteringControl.mIsActive) {
                Camera2CameraControlImpl camera2CameraControlImpl = focusMeteringControl.mCameraControl;
                ((HashSet) camera2CameraControlImpl.mSessionCallback.mCallbackMap).remove(null);
                ((HashSet) camera2CameraControlImpl.mSessionCallback.mCallbackMap).remove(null);
                if (focusMeteringControl.mAfRects.length > 0 && focusMeteringControl.mIsActive) {
                    RealInterceptorChain realInterceptorChain = new RealInterceptorChain();
                    realInterceptorChain.isPlaceholderCached = true;
                    realInterceptorChain.index = focusMeteringControl.mTemplate;
                    MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
                    mutableOptionsBundleCreate.insertOption(Camera2ImplConfig.createCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER), 2);
                    realInterceptorChain.addImplementationOptions(new Camera2ImplConfig(14, OptionsBundle.from(mutableOptionsBundleCreate)));
                    focusMeteringControl.mCameraControl.submitCaptureRequestsInternal(Collections.singletonList(realInterceptorChain.build()));
                }
                MeteringRectangle[] meteringRectangleArr = FocusMeteringControl.EMPTY_RECTANGLES;
                focusMeteringControl.mAfRects = meteringRectangleArr;
                focusMeteringControl.mAeRects = meteringRectangleArr;
                focusMeteringControl.mAwbRects = meteringRectangleArr;
                camera2CameraControlImpl.updateSessionConfigSynchronous();
            }
        }
        ZoomControl zoomControl = this.mZoomControl;
        if (zoomControl.mIsActive != z) {
            zoomControl.mIsActive = z;
            if (!z) {
                synchronized (((MutableRect) zoomControl.mCurrentZoomState)) {
                    ((MutableRect) zoomControl.mCurrentZoomState).setZoomRatio();
                    MutableRect mutableRect = (MutableRect) zoomControl.mCurrentZoomState;
                    autoValue_ImmutableZoomState = new AutoValue_ImmutableZoomState(mutableRect.getZoomRatio(), mutableRect.getMaxZoomRatio(), mutableRect.getMinZoomRatio(), mutableRect.getLinearZoom());
                }
                MutableLiveData mutableLiveData = (MutableLiveData) zoomControl.mZoomStateLiveData;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    mutableLiveData.setValue(autoValue_ImmutableZoomState);
                } else {
                    mutableLiveData.postValue(autoValue_ImmutableZoomState);
                }
                ((ZoomControl.ZoomImpl) zoomControl.mZoomImpl).resetZoom();
                ((Camera2CameraControlImpl) zoomControl.mCamera2CameraControlImpl).updateSessionConfigSynchronous();
            }
        }
        TorchControl torchControl = this.mTorchControl;
        if (torchControl.mIsActive != z) {
            torchControl.mIsActive = z;
            if (!z) {
                if (torchControl.mTargetTorchEnabled) {
                    torchControl.mTargetTorchEnabled = false;
                    torchControl.mCamera2CameraControlImpl.enableTorchInternal(false);
                    TorchControl.setLiveDataValue(torchControl.mTorchState, 0);
                }
                CallbackToFutureAdapter.Completer completer = torchControl.mEnableTorchCompleter;
                if (completer != null) {
                    completer.setException(new WriterException("Camera is not active."));
                    torchControl.mEnableTorchCompleter = null;
                }
            }
        }
        this.mExposureControl.setActive(z);
        Camera2CameraControl camera2CameraControl = this.mCamera2CameraControl;
        camera2CameraControl.mExecutor.execute(new Camera2CameraImpl$$ExternalSyntheticLambda12(1, camera2CameraControl, z));
        if (z) {
            return;
        }
        ((AtomicInteger) this.mVideoUsageControl.this$0).set(0);
        Logger.d("VideoUsageControl", "resetDirectly: mVideoUsage reset!");
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final void setFlashMode(int i) {
        if (!isControlInUse()) {
            Logger.w("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.mFlashMode = i;
        Logger.d("Camera2CameraControlImp", "setFlashMode: mFlashMode = " + this.mFlashMode);
        ZslControlImpl zslControlImpl = this.mZslControl;
        if (this.mFlashMode != 1) {
            int i2 = this.mFlashMode;
        }
        zslControlImpl.getClass();
        Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(2, this)));
    }

    public final void submitCaptureRequestsInternal(List list) {
        int videoStabilizationMode;
        int previewStabilizationMode;
        CameraCaptureResult cameraCaptureResult;
        Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) this.mControlUpdateCallback.this$0;
        list.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CaptureConfig captureConfig = (CaptureConfig) it.next();
            HashSet hashSet = new HashSet();
            MutableOptionsBundle.create();
            ArrayList arrayList2 = new ArrayList();
            MutableTagBundle.create();
            hashSet.addAll(captureConfig.mSurfaces);
            MutableOptionsBundle mutableOptionsBundleFrom = MutableOptionsBundle.from((Config) captureConfig.mImplementationOptions);
            int i = captureConfig.mTemplateType;
            arrayList2.addAll(captureConfig.mCameraCaptureCallbacks);
            boolean z = captureConfig.mUseRepeatingSurface;
            TagBundle tagBundle = captureConfig.mTagBundle;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : tagBundle.mTagMap.keySet()) {
                arrayMap.put(str, tagBundle.mTagMap.get(str));
            }
            MutableTagBundle mutableTagBundle = new MutableTagBundle(arrayMap);
            CameraCaptureResult cameraCaptureResult2 = (captureConfig.mTemplateType != 5 || (cameraCaptureResult = captureConfig.mCameraCaptureResult) == null) ? null : cameraCaptureResult;
            if (Collections.unmodifiableList(captureConfig.mSurfaces).isEmpty() && captureConfig.mUseRepeatingSurface) {
                if (hashSet.isEmpty()) {
                    SurfaceRequest.AnonymousClass1 anonymousClass1 = camera2CameraImpl.mUseCaseAttachState;
                    anonymousClass1.getClass();
                    ArrayList arrayList3 = new ArrayList();
                    for (Map.Entry entry : ((LinkedHashMap) anonymousClass1.val$requestCancellationFuture).entrySet()) {
                        UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo) entry.getValue();
                        if (useCaseAttachState$UseCaseAttachInfo.mActive && useCaseAttachState$UseCaseAttachInfo.mAttached) {
                            arrayList3.add(((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mSessionConfig);
                        }
                    }
                    Iterator it2 = Collections.unmodifiableCollection(arrayList3).iterator();
                    while (it2.hasNext()) {
                        CaptureConfig captureConfig2 = ((SessionConfig) it2.next()).mRepeatingCaptureConfig;
                        List listUnmodifiableList = Collections.unmodifiableList(captureConfig2.mSurfaces);
                        if (!listUnmodifiableList.isEmpty()) {
                            if (captureConfig2.getPreviewStabilizationMode() != 0 && (previewStabilizationMode = captureConfig2.getPreviewStabilizationMode()) != 0) {
                                mutableOptionsBundleFrom.insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(previewStabilizationMode));
                            }
                            if (captureConfig2.getVideoStabilizationMode() != 0 && (videoStabilizationMode = captureConfig2.getVideoStabilizationMode()) != 0) {
                                mutableOptionsBundleFrom.insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(videoStabilizationMode));
                            }
                            Iterator it3 = listUnmodifiableList.iterator();
                            while (it3.hasNext()) {
                                hashSet.add((DeferrableSurface) it3.next());
                            }
                        }
                    }
                    if (hashSet.isEmpty()) {
                        Logger.w("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
                    }
                } else {
                    Logger.w("Camera2CameraImpl", "The capture config builder already has surface inside.");
                }
            }
            ArrayList arrayList4 = new ArrayList(hashSet);
            OptionsBundle optionsBundleFrom = OptionsBundle.from(mutableOptionsBundleFrom);
            ArrayList arrayList5 = new ArrayList(arrayList2);
            TagBundle tagBundle2 = TagBundle.EMPTY_TAGBUNDLE;
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayMap arrayMap3 = mutableTagBundle.mTagMap;
            for (String str2 : arrayMap3.keySet()) {
                arrayMap2.put(str2, arrayMap3.get(str2));
            }
            arrayList.add(new CaptureConfig(arrayList4, optionsBundleFrom, i, arrayList5, z, new TagBundle(arrayMap2), cameraCaptureResult2));
        }
        camera2CameraImpl.debugLog("Issue capture request", null);
        camera2CameraImpl.mCaptureSession.issueCaptureRequests(arrayList);
    }

    public final long updateSessionConfigSynchronous() {
        this.mCurrentSessionUpdateId = this.mNextSessionUpdateId.getAndIncrement();
        ((Camera2CameraImpl) this.mControlUpdateCallback.this$0).updateCaptureSessionConfig();
        return this.mCurrentSessionUpdateId;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
    }
}
