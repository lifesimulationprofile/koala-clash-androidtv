package androidx.camera.core;

import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker;
import androidx.camera.core.imagecapture.AutoValue_CaptureNode_In;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda0;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda3;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks$NoOpCameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.ScreenFlashWrapper;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import androidx.camera.view.PreviewView;
import androidx.core.util.Preconditions;
import coil.intercept.RealInterceptorChain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.io.CloseableKt;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.json.internal.Composer;
import okhttp3.Dispatcher;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageCapture extends UseCase {
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    public final int mCaptureMode;
    public SessionConfig.CloseableErrorListener mCloseableErrorListener;
    public final int mFlashMode;
    public final LayoutSettings mImageCaptureControl;
    public Dispatcher mImagePipeline;
    public final AtomicReference mLockedFlashMode;
    public final ScreenFlashWrapper mScreenFlashWrapper;
    public SessionConfig.Builder mSessionConfigBuilder;
    public TakePictureManager mTakePictureManager;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Defaults {
        public static final ImageCaptureConfig DEFAULT_CONFIG;

        static {
            ResolutionSelector resolutionSelector = new ResolutionSelector(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY, ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY, null);
            Builder builder = new Builder(0);
            AutoValue_Config_Option autoValue_Config_Option = UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY;
            MutableOptionsBundle mutableOptionsBundle = builder.mMutableConfig;
            mutableOptionsBundle.insertOption(autoValue_Config_Option, 4);
            mutableOptionsBundle.insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, 0);
            mutableOptionsBundle.insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            mutableOptionsBundle.insertOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, 0);
            mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.SDR);
            DEFAULT_CONFIG = new ImageCaptureConfig(OptionsBundle.from(mutableOptionsBundle));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface ScreenFlash {
        void clear();
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface ScreenFlashListener {
        void onCompleted();
    }

    public ImageCapture(ImageCaptureConfig imageCaptureConfig) {
        super(imageCaptureConfig);
        this.mLockedFlashMode = new AtomicReference(null);
        this.mFlashMode = -1;
        this.mImageCaptureControl = new LayoutSettings();
        ImageCaptureConfig imageCaptureConfig2 = (ImageCaptureConfig) this.mCurrentConfig;
        AutoValue_Config_Option autoValue_Config_Option = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        imageCaptureConfig2.getClass();
        if (((OptionsBundle) imageCaptureConfig2.getConfig()).containsOption(autoValue_Config_Option)) {
            this.mCaptureMode = ((Integer) imageCaptureConfig2.getConfig().retrieveOption(autoValue_Config_Option)).intValue();
        } else {
            this.mCaptureMode = 1;
        }
        ((Integer) ((OptionsBundle) imageCaptureConfig2.getConfig()).retrieveOption(ImageCaptureConfig.OPTION_FLASH_TYPE, 0)).getClass();
        this.mScreenFlashWrapper = new ScreenFlashWrapper((ScreenFlash) ((OptionsBundle) imageCaptureConfig2.getConfig()).retrieveOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, null));
    }

    public static boolean isImageFormatSupported(int i, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) ((Pair) it.next()).first).equals(Integer.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    public final void clearPipeline(boolean z) {
        TakePictureManager takePictureManager;
        Log.d("ImageCapture", "clearPipeline");
        CharsKt.checkMainThread();
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
            this.mCloseableErrorListener = null;
        }
        Dispatcher dispatcher = this.mImagePipeline;
        if (dispatcher != null) {
            dispatcher.close();
            this.mImagePipeline = null;
        }
        if (z || (takePictureManager = this.mTakePictureManager) == null) {
            return;
        }
        takePictureManager.abortRequests();
        this.mTakePictureManager = null;
    }

    public final SessionConfig.Builder createPipeline(String str, ImageCaptureConfig imageCaptureConfig, AutoValue_StreamSpec autoValue_StreamSpec) {
        int iIntValue;
        CaptureNode$$ExternalSyntheticLambda0 captureNode$$ExternalSyntheticLambda0;
        ImageReaderProxy imageReaderProxy;
        CharsKt.checkMainThread();
        Log.d("ImageCapture", "createPipeline(cameraId: " + str + ", streamSpec: " + autoValue_StreamSpec + ")");
        Size size = autoValue_StreamSpec.resolution;
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        boolean hasTransform = camera.getHasTransform();
        boolean z = hasTransform ^ true;
        if (this.mImagePipeline != null) {
            Preconditions.checkState(null, z);
            this.mImagePipeline.close();
        }
        if (((Boolean) this.mCurrentConfig.retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.FALSE)).booleanValue()) {
            ((Toolbar.AnonymousClass1) getCamera().getExtendedConfig()).getSessionProcessor();
        }
        Dispatcher dispatcher = new Dispatcher();
        CharsKt.checkMainThread();
        dispatcher.executorServiceOrNull = imageCaptureConfig;
        Camera2CaptureOptionUnpacker camera2CaptureOptionUnpacker = (Camera2CaptureOptionUnpacker) imageCaptureConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, null);
        if (camera2CaptureOptionUnpacker == null) {
            throw new IllegalStateException("Implementation is missing option unpacker for " + ImageAnalysis$$ExternalSyntheticLambda1.$default$getTargetName(imageCaptureConfig, imageCaptureConfig.toString()));
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain();
        camera2CaptureOptionUnpacker.unpack(imageCaptureConfig, realInterceptorChain);
        realInterceptorChain.build();
        SurfaceRequest.AnonymousClass1 anonymousClass1 = new SurfaceRequest.AnonymousClass1(12, false);
        dispatcher.readyAsyncCalls = anonymousClass1;
        Executor executor = (Executor) ((OptionsBundle) imageCaptureConfig.getConfig()).retrieveOption(IoConfig.OPTION_IO_EXECUTOR, HexFormatKt.ioExecutor());
        Objects.requireNonNull(executor);
        Composer composer = new Composer(executor);
        dispatcher.runningAsyncCalls = composer;
        int inputFormat = imageCaptureConfig.getInputFormat();
        Integer num = (Integer) ((OptionsBundle) imageCaptureConfig.getConfig()).retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Integer num2 = (Integer) ((OptionsBundle) imageCaptureConfig.getConfig()).retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT, null);
            iIntValue = (num2 == null || num2.intValue() != 4101) ? 256 : 4101;
        }
        if (((OptionsBundle) imageCaptureConfig.getConfig()).retrieveOption(ImageCaptureConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, null) != null) {
            throw new ClassCastException();
        }
        Edge edge = new Edge();
        Edge edge2 = new Edge();
        AutoValue_CaptureNode_In autoValue_CaptureNode_In = new AutoValue_CaptureNode_In(size, inputFormat, iIntValue, z, edge, edge2);
        dispatcher.runningSyncCalls = autoValue_CaptureNode_In;
        int i = 1;
        Preconditions.checkState("CaptureNode does not support recreation yet.", ((AutoValue_CaptureNode_In) anonymousClass1.val$requestCancellationFuture) == null && ((RealInterceptorChain) anonymousClass1.val$requestCancellationCompleter) == null);
        anonymousClass1.val$requestCancellationFuture = autoValue_CaptureNode_In;
        MetadataImageReader.AnonymousClass1 anonymousClass2 = new MetadataImageReader.AnonymousClass1(i, anonymousClass1);
        int i2 = 2;
        if (hasTransform) {
            MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), inputFormat, 4);
            List<CameraCaptureCallback> listAsList = Arrays.asList(anonymousClass2, metadataImageReader.mCameraCaptureCallback);
            if (!listAsList.isEmpty()) {
                if (listAsList.size() == 1) {
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (CameraCaptureCallback cameraCaptureCallback : listAsList) {
                        if (!(cameraCaptureCallback instanceof CameraCaptureCallbacks$NoOpCameraCaptureCallback)) {
                            arrayList.add(cameraCaptureCallback);
                        }
                    }
                }
            }
            captureNode$$ExternalSyntheticLambda0 = new CaptureNode$$ExternalSyntheticLambda0(anonymousClass1, 0);
            imageReaderProxy = metadataImageReader;
        } else {
            PreviewView.AnonymousClass1 anonymousClass3 = new PreviewView.AnonymousClass1(16, CloseableKt.createIsolatedReader(size.getWidth(), size.getHeight(), inputFormat, 4));
            captureNode$$ExternalSyntheticLambda0 = new CaptureNode$$ExternalSyntheticLambda0(anonymousClass1, i2);
            imageReaderProxy = anonymousClass3;
        }
        Surface surface = imageReaderProxy.getSurface();
        Objects.requireNonNull(surface);
        Preconditions.checkState("The surface is already set.", autoValue_CaptureNode_In.mSurface == null);
        autoValue_CaptureNode_In.mSurface = new SurfaceRequest.AnonymousClass2(surface, size, inputFormat);
        anonymousClass1.val$requestCancellationCompleter = new RealInterceptorChain(imageReaderProxy);
        imageReaderProxy.setOnImageAvailableListener(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(7, anonymousClass1), HexFormatKt.mainThreadExecutor());
        edge.mListener = captureNode$$ExternalSyntheticLambda0;
        edge2.mListener = new CaptureNode$$ExternalSyntheticLambda3(0, anonymousClass1);
        this.mImagePipeline = dispatcher;
        if (this.mTakePictureManager == null) {
            this.mTakePictureManager = new TakePictureManager(this.mImageCaptureControl);
        }
        TakePictureManager takePictureManager = this.mTakePictureManager;
        Dispatcher dispatcher2 = this.mImagePipeline;
        takePictureManager.getClass();
        CharsKt.checkMainThread();
        takePictureManager.mImagePipeline = dispatcher2;
        dispatcher2.getClass();
        CharsKt.checkMainThread();
        SurfaceRequest.AnonymousClass1 anonymousClass4 = (SurfaceRequest.AnonymousClass1) dispatcher2.readyAsyncCalls;
        anonymousClass4.getClass();
        CharsKt.checkMainThread();
        Preconditions.checkState("The ImageReader is not initialized.", ((RealInterceptorChain) anonymousClass4.val$requestCancellationCompleter) != null);
        RealInterceptorChain realInterceptorChain2 = (RealInterceptorChain) anonymousClass4.val$requestCancellationCompleter;
        synchronized (realInterceptorChain2.initialRequest) {
            realInterceptorChain2.size = takePictureManager;
        }
        Dispatcher dispatcher3 = this.mImagePipeline;
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom((ImageCaptureConfig) dispatcher3.executorServiceOrNull, autoValue_StreamSpec.resolution);
        AutoValue_CaptureNode_In autoValue_CaptureNode_In2 = (AutoValue_CaptureNode_In) dispatcher3.runningSyncCalls;
        SurfaceRequest.AnonymousClass2 anonymousClass5 = autoValue_CaptureNode_In2.mSurface;
        Objects.requireNonNull(anonymousClass5);
        DynamicRange dynamicRange = DynamicRange.SDR;
        Request requestBuilder = AutoValue_SessionConfig_OutputConfig.builder(anonymousClass5);
        requestBuilder.lazyCacheControl = dynamicRange;
        builderCreateFrom.mOutputConfigs.add(requestBuilder.build());
        SurfaceRequest.AnonymousClass2 anonymousClass6 = autoValue_CaptureNode_In2.mPostviewSurface;
        if (anonymousClass6 != null) {
            builderCreateFrom.mPostviewOutputConfig = AutoValue_SessionConfig_OutputConfig.builder(anonymousClass6).build();
        }
        if (this.mCaptureMode == 2 && !autoValue_StreamSpec.zslDisabled) {
            getCameraControl().addZslConfig(builderCreateFrom);
        }
        Config config = autoValue_StreamSpec.implementationOptions;
        if (config != null) {
            builderCreateFrom.mCaptureConfigBuilder.addImplementationOptions(config);
        }
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new Preview$$ExternalSyntheticLambda2(3, this));
        this.mCloseableErrorListener = closeableErrorListener2;
        builderCreateFrom.mErrorListener = closeableErrorListener2;
        return builderCreateFrom;
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        DEFAULT_CONFIG.getClass();
        ImageCaptureConfig imageCaptureConfig = Defaults.DEFAULT_CONFIG;
        imageCaptureConfig.getClass();
        Config config = useCaseConfigFactory.getConfig(ImageAnalysis$$ExternalSyntheticLambda1.$default$getCaptureType(imageCaptureConfig), this.mCaptureMode);
        if (z) {
            config = ImageAnalysis$$ExternalSyntheticLambda1.mergeConfigs(config, imageCaptureConfig);
        }
        if (config == null) {
            return null;
        }
        return new ImageCaptureConfig(OptionsBundle.from(((Builder) getUseCaseConfigBuilder(config)).mMutableConfig));
    }

    public final int getFlashMode() {
        int iIntValue;
        synchronized (this.mLockedFlashMode) {
            iIntValue = this.mFlashMode;
            if (iIntValue == -1) {
                ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) this.mCurrentConfig;
                imageCaptureConfig.getClass();
                iIntValue = ((Integer) imageCaptureConfig.getConfig().retrieveOption(ImageCaptureConfig.OPTION_FLASH_MODE, 2)).intValue();
            }
        }
        return iIntValue;
    }

    @Override // androidx.camera.core.UseCase
    public final Set getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig.Builder getUseCaseConfigBuilder(Config config) {
        return new Builder(MutableOptionsBundle.from(config), 0);
    }

    @Override // androidx.camera.core.UseCase
    public final void onBind() {
        Preconditions.checkNotNull(getCamera(), "Attached camera cannot be null");
        if (getFlashMode() == 3) {
            CameraInternal camera = getCamera();
            if ((camera != null ? camera.getCameraInfo().getLensFacing() : -1) != 0) {
                throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    public final void onCameraControlReady() {
        Logger.d("ImageCapture", "onCameraControlReady");
        synchronized (this.mLockedFlashMode) {
            try {
                if (this.mLockedFlashMode.get() == null) {
                    getCameraControl().setFlashMode(getFlashMode());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        getCameraControl().setScreenFlash(this.mScreenFlashWrapper);
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder builder) {
        Object objRetrieveOption;
        Object objRetrieveOption2;
        Object objRetrieveOption3;
        if (cameraInfoInternal.getCameraQuirks().contains(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            Object mutableConfig = builder.getMutableConfig();
            AutoValue_Config_Option autoValue_Config_Option = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
            Object objRetrieveOption4 = Boolean.TRUE;
            OptionsBundle optionsBundle = (OptionsBundle) mutableConfig;
            optionsBundle.getClass();
            try {
                objRetrieveOption4 = optionsBundle.retrieveOption(autoValue_Config_Option);
            } catch (IllegalArgumentException unused) {
            }
            if (bool.equals(objRetrieveOption4)) {
                Logger.w("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                String strTruncateTag = Logger.truncateTag("ImageCapture");
                if (Logger.isLogLevelEnabled(strTruncateTag, 4)) {
                    Log.i(strTruncateTag, "Requesting software JPEG due to device quirk.");
                }
                ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.TRUE);
            }
        }
        Object mutableConfig2 = builder.getMutableConfig();
        Boolean bool2 = Boolean.TRUE;
        AutoValue_Config_Option autoValue_Config_Option2 = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Object objRetrieveOption5 = Boolean.FALSE;
        OptionsBundle optionsBundle2 = (OptionsBundle) mutableConfig2;
        optionsBundle2.getClass();
        try {
            objRetrieveOption5 = optionsBundle2.retrieveOption(autoValue_Config_Option2);
        } catch (IllegalArgumentException unused2) {
        }
        boolean zEquals = bool2.equals(objRetrieveOption5);
        Object objRetrieveOption6 = null;
        boolean z = false;
        if (zEquals) {
            if (getCamera() != null) {
                ((Toolbar.AnonymousClass1) getCamera().getExtendedConfig()).getSessionProcessor();
            }
            try {
                objRetrieveOption3 = optionsBundle2.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT);
            } catch (IllegalArgumentException unused3) {
                objRetrieveOption3 = null;
            }
            Integer num = (Integer) objRetrieveOption3;
            if (num == null || num.intValue() == 256) {
                z = true;
            } else {
                Logger.w("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z) {
                Logger.w("ImageCapture", "Unable to support software JPEG. Disabling.");
                ((MutableOptionsBundle) mutableConfig2).insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.FALSE);
            }
        }
        Object mutableConfig3 = builder.getMutableConfig();
        AutoValue_Config_Option autoValue_Config_Option3 = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
        OptionsBundle optionsBundle3 = (OptionsBundle) mutableConfig3;
        optionsBundle3.getClass();
        try {
            objRetrieveOption = optionsBundle3.retrieveOption(autoValue_Config_Option3);
        } catch (IllegalArgumentException unused4) {
            objRetrieveOption = null;
        }
        Integer num2 = (Integer) objRetrieveOption;
        if (num2 != null) {
            if (getCamera() != null) {
                ((Toolbar.AnonymousClass1) getCamera().getExtendedConfig()).getSessionProcessor();
            }
            ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, Integer.valueOf(z ? 35 : num2.intValue()));
        } else {
            Object mutableConfig4 = builder.getMutableConfig();
            AutoValue_Config_Option autoValue_Config_Option4 = ImageCaptureConfig.OPTION_OUTPUT_FORMAT;
            OptionsBundle optionsBundle4 = (OptionsBundle) mutableConfig4;
            optionsBundle4.getClass();
            try {
                objRetrieveOption2 = optionsBundle4.retrieveOption(autoValue_Config_Option4);
            } catch (IllegalArgumentException unused5) {
                objRetrieveOption2 = null;
            }
            if (Objects.equals(objRetrieveOption2, 1)) {
                ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
                ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
            } else if (z) {
                ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
            } else {
                Object mutableConfig5 = builder.getMutableConfig();
                AutoValue_Config_Option autoValue_Config_Option5 = ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS;
                OptionsBundle optionsBundle5 = (OptionsBundle) mutableConfig5;
                optionsBundle5.getClass();
                try {
                    objRetrieveOption6 = optionsBundle5.retrieveOption(autoValue_Config_Option5);
                } catch (IllegalArgumentException unused6) {
                }
                List list = (List) objRetrieveOption6;
                if (list == null) {
                    ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
                } else if (isImageFormatSupported(256, list)) {
                    ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
                } else if (isImageFormatSupported(35, list)) {
                    ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
                }
            }
        }
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public final void onStateDetached() {
        ScreenFlashWrapper screenFlashWrapper = this.mScreenFlashWrapper;
        screenFlashWrapper.completePendingScreenFlashListener();
        screenFlashWrapper.completePendingScreenFlashClear();
        TakePictureManager takePictureManager = this.mTakePictureManager;
        if (takePictureManager != null) {
            takePictureManager.abortRequests();
        }
    }

    @Override // androidx.camera.core.UseCase
    public final AutoValue_StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        Object[] objArr = {this.mSessionConfigBuilder.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        Request builder = this.mAttachedStreamSpec.toBuilder();
        builder.tags = config;
        return builder.m850build();
    }

    @Override // androidx.camera.core.UseCase
    public final AutoValue_StreamSpec onSuggestedStreamSpecUpdated(AutoValue_StreamSpec autoValue_StreamSpec, AutoValue_StreamSpec autoValue_StreamSpec2) {
        SessionConfig.Builder builderCreatePipeline = createPipeline(getCameraId(), (ImageCaptureConfig) this.mCurrentConfig, autoValue_StreamSpec);
        this.mSessionConfigBuilder = builderCreatePipeline;
        Object[] objArr = {builderCreatePipeline.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        notifyActive();
        return autoValue_StreamSpec;
    }

    @Override // androidx.camera.core.UseCase
    public final void onUnbind() {
        ScreenFlashWrapper screenFlashWrapper = this.mScreenFlashWrapper;
        screenFlashWrapper.completePendingScreenFlashListener();
        screenFlashWrapper.completePendingScreenFlashClear();
        TakePictureManager takePictureManager = this.mTakePictureManager;
        if (takePictureManager != null) {
            takePictureManager.abortRequests();
        }
        clearPipeline(false);
        getCameraControl().setScreenFlash(null);
    }

    public final String toString() {
        return "ImageCapture:".concat(getName());
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder implements ExtendableBuilder, UseCaseConfig.Builder {
        public final /* synthetic */ int $r8$classId;
        public final MutableOptionsBundle mMutableConfig;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(int i) {
            Object objRetrieveOption;
            this(MutableOptionsBundle.create(), 0);
            this.$r8$classId = i;
            switch (i) {
                case 1:
                    this.mMutableConfig = MutableOptionsBundle.create();
                    return;
                case 2:
                    MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
                    this.mMutableConfig = mutableOptionsBundleCreate;
                    Object objRetrieveOption2 = null;
                    try {
                        objRetrieveOption = mutableOptionsBundleCreate.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
                        break;
                    } catch (IllegalArgumentException unused) {
                        objRetrieveOption = null;
                    }
                    Class cls = (Class) objRetrieveOption;
                    if (cls != null && !cls.equals(CameraX.class)) {
                        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
                    }
                    MutableOptionsBundle mutableOptionsBundle = this.mMutableConfig;
                    mutableOptionsBundle.insertOption(TargetConfig.OPTION_TARGET_CLASS, CameraX.class);
                    try {
                        objRetrieveOption2 = mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
                        break;
                    } catch (IllegalArgumentException unused2) {
                    }
                    if (objRetrieveOption2 == null) {
                        mutableOptionsBundle.insertOption(TargetConfig.OPTION_TARGET_NAME, CameraX.class.getCanonicalName() + "-" + UUID.randomUUID());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            switch (this.$r8$classId) {
                case 0:
                    return this.mMutableConfig;
                case 1:
                    throw null;
                default:
                    return this.mMutableConfig;
            }
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public UseCaseConfig getUseCaseConfig() {
            switch (this.$r8$classId) {
                case 0:
                    return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
                default:
                    return new StreamSharingConfig(OptionsBundle.from(this.mMutableConfig));
            }
        }

        public void setCaptureRequestOptionWithPriority(CaptureRequest.Key key, Object obj) {
            this.mMutableConfig.insertOption(Camera2ImplConfig.createCaptureRequestOption(key), Config.OptionPriority.REQUIRED, obj);
        }

        public Builder(MutableOptionsBundle mutableOptionsBundle, int i) {
            Object objRetrieveOption;
            Object objRetrieveOption2;
            this.$r8$classId = i;
            switch (i) {
                case 3:
                    this.mMutableConfig = mutableOptionsBundle;
                    Object objRetrieveOption3 = null;
                    try {
                        objRetrieveOption = mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
                        break;
                    } catch (IllegalArgumentException unused) {
                        objRetrieveOption = null;
                    }
                    Class cls = (Class) objRetrieveOption;
                    if (cls != null && !cls.equals(StreamSharing.class)) {
                        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
                    }
                    this.mMutableConfig.insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, UseCaseConfigFactory.CaptureType.STREAM_SHARING);
                    MutableOptionsBundle mutableOptionsBundle2 = this.mMutableConfig;
                    mutableOptionsBundle2.insertOption(TargetConfig.OPTION_TARGET_CLASS, StreamSharing.class);
                    try {
                        objRetrieveOption3 = mutableOptionsBundle2.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
                        break;
                    } catch (IllegalArgumentException unused2) {
                    }
                    if (objRetrieveOption3 == null) {
                        mutableOptionsBundle2.insertOption(TargetConfig.OPTION_TARGET_NAME, StreamSharing.class.getCanonicalName() + "-" + UUID.randomUUID());
                        return;
                    }
                    return;
                default:
                    this.mMutableConfig = mutableOptionsBundle;
                    Object objRetrieveOption4 = null;
                    try {
                        objRetrieveOption2 = mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
                        break;
                    } catch (IllegalArgumentException unused3) {
                        objRetrieveOption2 = null;
                    }
                    Class cls2 = (Class) objRetrieveOption2;
                    if (cls2 != null && !cls2.equals(ImageCapture.class)) {
                        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
                    }
                    this.mMutableConfig.insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
                    MutableOptionsBundle mutableOptionsBundle3 = this.mMutableConfig;
                    mutableOptionsBundle3.insertOption(TargetConfig.OPTION_TARGET_CLASS, ImageCapture.class);
                    try {
                        objRetrieveOption4 = mutableOptionsBundle3.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
                        break;
                    } catch (IllegalArgumentException unused4) {
                    }
                    if (objRetrieveOption4 == null) {
                        this.mMutableConfig.insertOption(TargetConfig.OPTION_TARGET_NAME, ImageCapture.class.getCanonicalName() + "-" + UUID.randomUUID());
                        return;
                    }
                    return;
            }
        }
    }
}
