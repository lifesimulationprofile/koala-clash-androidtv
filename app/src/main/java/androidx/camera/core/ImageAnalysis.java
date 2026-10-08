package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import coil.intercept.RealInterceptorChain;
import com.google.android.gms.tasks.zzu;
import io.github.g00fy2.quickie.QRCodeAnalyzer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.io.CloseableKt;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageAnalysis extends UseCase {
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    public final Object mAnalysisLock;
    public SessionConfig.CloseableErrorListener mCloseableErrorListener;
    public SurfaceRequest.AnonymousClass2 mDeferrableSurface;
    public final ImageAnalysisAbstractAnalyzer mImageAnalysisAbstractAnalyzer;
    public SessionConfig.Builder mSessionConfigBuilder;
    public QRCodeAnalyzer mSubscribedAnalyzer;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Analyzer {
        void analyze(SettableImageProxy settableImageProxy);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BackpressureStrategy {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Defaults {
        public static final ImageAnalysisConfig DEFAULT_CONFIG;

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
        static {
            Object size = new Size(640, 480);
            Object resolutionSelector = new ResolutionSelector(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY, new ResolutionStrategy(SizeUtil.RESOLUTION_VGA), null);
            Preview.Builder builder = new Preview.Builder(2);
            AutoValue_Config_Option autoValue_Config_Option = ImageOutputConfig.OPTION_DEFAULT_RESOLUTION;
            MutableOptionsBundle mutableOptionsBundle = builder.mMutableConfig;
            mutableOptionsBundle.insertOption(autoValue_Config_Option, size);
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, 1);
            mutableOptionsBundle.insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, 0);
            mutableOptionsBundle.insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            DynamicRange dynamicRange = DynamicRange.SDR;
            if (!dynamicRange.equals(dynamicRange)) {
                throw new UnsupportedOperationException("ImageAnalysis currently only supports SDR");
            }
            mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
            DEFAULT_CONFIG = new ImageAnalysisConfig(OptionsBundle.from(mutableOptionsBundle));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputImageFormat {
    }

    public ImageAnalysis(ImageAnalysisConfig imageAnalysisConfig) {
        super(imageAnalysisConfig);
        this.mAnalysisLock = new Object();
        ImageAnalysisConfig imageAnalysisConfig2 = (ImageAnalysisConfig) this.mCurrentConfig;
        if (((Integer) ((OptionsBundle) imageAnalysisConfig2.getConfig()).retrieveOption(ImageAnalysisConfig.OPTION_BACKPRESSURE_STRATEGY, 0)).intValue() == 1) {
            this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisBlockingAnalyzer();
        } else {
            this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisNonBlockingAnalyzer((Executor) imageAnalysisConfig.getConfig().retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, HexFormatKt.highPriorityExecutor()));
        }
        this.mImageAnalysisAbstractAnalyzer.mOutputImageFormat = getOutputImageFormat();
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
        ImageAnalysisConfig imageAnalysisConfig3 = (ImageAnalysisConfig) this.mCurrentConfig;
        Boolean bool = Boolean.FALSE;
        imageAnalysisConfig3.getClass();
        imageAnalysisAbstractAnalyzer.mOutputImageRotationEnabled = ((Boolean) imageAnalysisConfig3.getConfig().retrieveOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_ROTATION_ENABLED, bool)).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:41:0x010a  */
    public final SessionConfig.Builder createPipeline(ImageAnalysisConfig imageAnalysisConfig, AutoValue_StreamSpec autoValue_StreamSpec) {
        int iIntValue;
        boolean z;
        CharsKt.checkMainThread();
        Size size = autoValue_StreamSpec.resolution;
        zzu zzuVarHighPriorityExecutor = HexFormatKt.highPriorityExecutor();
        imageAnalysisConfig.getClass();
        Executor executor = (Executor) imageAnalysisConfig.getConfig().retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, zzuVarHighPriorityExecutor);
        executor.getClass();
        boolean z2 = true;
        if (((Integer) ((OptionsBundle) ((ImageAnalysisConfig) this.mCurrentConfig).getConfig()).retrieveOption(ImageAnalysisConfig.OPTION_BACKPRESSURE_STRATEGY, 0)).intValue() == 1) {
            ImageAnalysisConfig imageAnalysisConfig2 = (ImageAnalysisConfig) this.mCurrentConfig;
            imageAnalysisConfig2.getClass();
            iIntValue = ((Integer) ((OptionsBundle) imageAnalysisConfig2.getConfig()).retrieveOption(ImageAnalysisConfig.OPTION_IMAGE_QUEUE_DEPTH, 6)).intValue();
        } else {
            iIntValue = 4;
        }
        if (((OptionsBundle) imageAnalysisConfig.getConfig()).retrieveOption(ImageAnalysisConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, null) != null) {
            throw new ClassCastException();
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(CloseableKt.createIsolatedReader(size.getWidth(), size.getHeight(), this.mCurrentConfig.getInputFormat(), iIntValue));
        if (getCamera() != null) {
            CameraInternal camera = getCamera();
            ImageAnalysisConfig imageAnalysisConfig3 = (ImageAnalysisConfig) this.mCurrentConfig;
            Boolean bool = Boolean.FALSE;
            imageAnalysisConfig3.getClass();
            if (!((Boolean) imageAnalysisConfig3.getConfig().retrieveOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_ROTATION_ENABLED, bool)).booleanValue() || getRelativeRotation(camera, false) % 180 == 0) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        int height = z ? size.getHeight() : size.getWidth();
        int width = z ? size.getWidth() : size.getHeight();
        int i = getOutputImageFormat() == 2 ? 1 : 35;
        boolean z3 = this.mCurrentConfig.getInputFormat() == 35 && getOutputImageFormat() == 2;
        if (this.mCurrentConfig.getInputFormat() != 35) {
            z2 = false;
        } else if (getCamera() == null || getRelativeRotation(getCamera(), false) == 0) {
            Boolean bool2 = Boolean.TRUE;
            ImageAnalysisConfig imageAnalysisConfig4 = (ImageAnalysisConfig) this.mCurrentConfig;
            imageAnalysisConfig4.getClass();
            if (!bool2.equals((Boolean) imageAnalysisConfig4.getConfig().retrieveOption(ImageAnalysisConfig.OPTION_ONE_PIXEL_SHIFT_ENABLED, null))) {
                z2 = false;
            }
        }
        RealInterceptorChain realInterceptorChain2 = (z3 || z2) ? new RealInterceptorChain(CloseableKt.createIsolatedReader(height, width, i, realInterceptorChain.getMaxImages())) : null;
        if (realInterceptorChain2 != null) {
            ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
            synchronized (imageAnalysisAbstractAnalyzer.mAnalyzerLock) {
                imageAnalysisAbstractAnalyzer.mProcessedImageReaderProxy = realInterceptorChain2;
            }
        }
        CameraInternal camera2 = getCamera();
        if (camera2 != null) {
            this.mImageAnalysisAbstractAnalyzer.mRelativeRotation = getRelativeRotation(camera2, false);
        }
        realInterceptorChain.setOnImageAvailableListener(this.mImageAnalysisAbstractAnalyzer, executor);
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(imageAnalysisConfig, autoValue_StreamSpec.resolution);
        Config config = autoValue_StreamSpec.implementationOptions;
        if (config != null) {
            builderCreateFrom.mCaptureConfigBuilder.addImplementationOptions(config);
        }
        SurfaceRequest.AnonymousClass2 anonymousClass2 = this.mDeferrableSurface;
        if (anonymousClass2 != null) {
            anonymousClass2.close();
        }
        SurfaceRequest.AnonymousClass2 anonymousClass3 = new SurfaceRequest.AnonymousClass2(realInterceptorChain.getSurface(), size, this.mCurrentConfig.getInputFormat());
        this.mDeferrableSurface = anonymousClass3;
        Futures.nonCancellationPropagating(anonymousClass3.mTerminationFuture).addListener(new Preview$$ExternalSyntheticLambda1(11, realInterceptorChain, realInterceptorChain2), HexFormatKt.mainThreadExecutor());
        Range range = autoValue_StreamSpec.expectedFrameRateRange;
        RealInterceptorChain realInterceptorChain3 = builderCreateFrom.mCaptureConfigBuilder;
        realInterceptorChain3.getClass();
        ((MutableOptionsBundle) realInterceptorChain3.request).insertOption(CaptureConfig.OPTION_RESOLVED_FRAME_RATE, range);
        builderCreateFrom.addSurface(this.mDeferrableSurface, autoValue_StreamSpec.dynamicRange, -1);
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new Preview$$ExternalSyntheticLambda2(2, this));
        this.mCloseableErrorListener = closeableErrorListener2;
        builderCreateFrom.mErrorListener = closeableErrorListener2;
        return builderCreateFrom;
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        DEFAULT_CONFIG.getClass();
        ImageAnalysisConfig imageAnalysisConfig = Defaults.DEFAULT_CONFIG;
        imageAnalysisConfig.getClass();
        Config config = useCaseConfigFactory.getConfig(ImageAnalysis$$ExternalSyntheticLambda1.$default$getCaptureType(imageAnalysisConfig), 1);
        if (z) {
            config = ImageAnalysis$$ExternalSyntheticLambda1.mergeConfigs(config, imageAnalysisConfig);
        }
        if (config == null) {
            return null;
        }
        return new ImageAnalysisConfig(OptionsBundle.from(((Preview.Builder) getUseCaseConfigBuilder(config)).mMutableConfig));
    }

    public final int getOutputImageFormat() {
        ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) this.mCurrentConfig;
        imageAnalysisConfig.getClass();
        return ((Integer) imageAnalysisConfig.getConfig().retrieveOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_FORMAT, 1)).intValue();
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig.Builder getUseCaseConfigBuilder(Config config) {
        return new Preview.Builder(MutableOptionsBundle.from(config), 2);
    }

    @Override // androidx.camera.core.UseCase
    public final void onBind() {
        this.mImageAnalysisAbstractAnalyzer.mIsAttached = true;
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder builder) {
        ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) this.mCurrentConfig;
        imageAnalysisConfig.getClass();
        Boolean bool = (Boolean) imageAnalysisConfig.getConfig().retrieveOption(ImageAnalysisConfig.OPTION_ONE_PIXEL_SHIFT_ENABLED, null);
        boolean zContains = cameraInfoInternal.getCameraQuirks().contains(OnePixelShiftQuirk.class);
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
        if (bool != null) {
            zContains = bool.booleanValue();
        }
        imageAnalysisAbstractAnalyzer.mOnePixelShiftEnabled = zContains;
        synchronized (this.mAnalysisLock) {
        }
        return builder.getUseCaseConfig();
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
        ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) this.mCurrentConfig;
        getCameraId();
        SessionConfig.Builder builderCreatePipeline = createPipeline(imageAnalysisConfig, autoValue_StreamSpec);
        this.mSessionConfigBuilder = builderCreatePipeline;
        Object[] objArr = {builderCreatePipeline.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        return autoValue_StreamSpec;
    }

    @Override // androidx.camera.core.UseCase
    public final void onUnbind() {
        CharsKt.checkMainThread();
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
            this.mCloseableErrorListener = null;
        }
        SurfaceRequest.AnonymousClass2 anonymousClass2 = this.mDeferrableSurface;
        if (anonymousClass2 != null) {
            anonymousClass2.close();
            this.mDeferrableSurface = null;
        }
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
        imageAnalysisAbstractAnalyzer.mIsAttached = false;
        imageAnalysisAbstractAnalyzer.clearCache();
    }

    @Override // androidx.camera.core.UseCase
    public final void setSensorToBufferTransformMatrix(Matrix matrix) {
        super.setSensorToBufferTransformMatrix(matrix);
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
        synchronized (imageAnalysisAbstractAnalyzer.mAnalyzerLock) {
            imageAnalysisAbstractAnalyzer.mOriginalSensorToBufferTransformMatrix = matrix;
            imageAnalysisAbstractAnalyzer.mUpdatedSensorToBufferTransformMatrix = new Matrix(imageAnalysisAbstractAnalyzer.mOriginalSensorToBufferTransformMatrix);
        }
    }

    @Override // androidx.camera.core.UseCase
    public final void setViewPortCropRect(Rect rect) {
        this.mViewPortCropRect = rect;
        ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
        synchronized (imageAnalysisAbstractAnalyzer.mAnalyzerLock) {
            imageAnalysisAbstractAnalyzer.mOriginalViewPortCropRect = rect;
            imageAnalysisAbstractAnalyzer.mUpdatedViewPortCropRect = new Rect(imageAnalysisAbstractAnalyzer.mOriginalViewPortCropRect);
        }
    }

    public final String toString() {
        return "ImageAnalysis:".concat(getName());
    }
}
