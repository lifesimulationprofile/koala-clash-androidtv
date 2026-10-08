package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceEdge$$ExternalSyntheticLambda3;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import coil.intercept.RealInterceptorChain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Preview extends UseCase {
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    public static final HandlerScheduledExecutorService DEFAULT_SURFACE_PROVIDER_EXECUTOR = HexFormatKt.mainThreadExecutor();
    public SurfaceEdge mCameraEdge;
    public SessionConfig.CloseableErrorListener mCloseableErrorListener;
    public SurfaceRequest mCurrentSurfaceRequest;
    public SessionConfig.Builder mSessionConfigBuilder;
    public SurfaceRequest.AnonymousClass2 mSessionDeferrableSurface;
    public SurfaceProvider mSurfaceProvider;
    public Executor mSurfaceProviderExecutor;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Defaults {
        public static final PreviewConfig DEFAULT_CONFIG;

        static {
            ResolutionSelector resolutionSelector = new ResolutionSelector(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY, ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY, null);
            Builder builder = new Builder(0);
            AutoValue_Config_Option autoValue_Config_Option = UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY;
            MutableOptionsBundle mutableOptionsBundle = builder.mMutableConfig;
            mutableOptionsBundle.insertOption(autoValue_Config_Option, 2);
            mutableOptionsBundle.insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, 0);
            mutableOptionsBundle.insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
            DEFAULT_CONFIG = new PreviewConfig(OptionsBundle.from(mutableOptionsBundle));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface SurfaceProvider {
        void onSurfaceRequested(SurfaceRequest surfaceRequest);
    }

    public final void clearPipeline$2() {
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
            this.mCloseableErrorListener = null;
        }
        SurfaceRequest.AnonymousClass2 anonymousClass2 = this.mSessionDeferrableSurface;
        if (anonymousClass2 != null) {
            anonymousClass2.close();
            this.mSessionDeferrableSurface = null;
        }
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        this.mCurrentSurfaceRequest = null;
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        DEFAULT_CONFIG.getClass();
        PreviewConfig previewConfig = Defaults.DEFAULT_CONFIG;
        previewConfig.getClass();
        Config config = useCaseConfigFactory.getConfig(ImageAnalysis$$ExternalSyntheticLambda1.$default$getCaptureType(previewConfig), 1);
        if (z) {
            config = ImageAnalysis$$ExternalSyntheticLambda1.mergeConfigs(config, previewConfig);
        }
        if (config == null) {
            return null;
        }
        return new PreviewConfig(OptionsBundle.from(((Builder) getUseCaseConfigBuilder(config)).mMutableConfig));
    }

    @Override // androidx.camera.core.UseCase
    public final Set getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig.Builder getUseCaseConfigBuilder(Config config) {
        return new Builder(MutableOptionsBundle.from(config), 0);
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder builder) {
        ((MutableOptionsBundle) builder.getMutableConfig()).insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
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
        updateConfigAndOutput((PreviewConfig) this.mCurrentConfig, autoValue_StreamSpec);
        return autoValue_StreamSpec;
    }

    @Override // androidx.camera.core.UseCase
    public final void onUnbind() {
        clearPipeline$2();
    }

    public final void setSurfaceProvider(SurfaceProvider surfaceProvider) {
        CharsKt.checkMainThread();
        if (surfaceProvider == null) {
            this.mSurfaceProvider = null;
            this.mState = 2;
            notifyState();
            return;
        }
        this.mSurfaceProvider = surfaceProvider;
        this.mSurfaceProviderExecutor = DEFAULT_SURFACE_PROVIDER_EXECUTOR;
        AutoValue_StreamSpec autoValue_StreamSpec = this.mAttachedStreamSpec;
        if ((autoValue_StreamSpec != null ? autoValue_StreamSpec.resolution : null) != null) {
            updateConfigAndOutput((PreviewConfig) this.mCurrentConfig, autoValue_StreamSpec);
            notifyReset();
        }
        notifyActive();
    }

    @Override // androidx.camera.core.UseCase
    public final void setViewPortCropRect(Rect rect) {
        this.mViewPortCropRect = rect;
        CameraInternal camera = getCamera();
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (camera == null || surfaceEdge == null) {
            return;
        }
        CharsKt.runOnMain(new SurfaceEdge$$ExternalSyntheticLambda3(surfaceEdge, getRelativeRotation(camera, isMirroringRequired(camera)), ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation()));
    }

    public final String toString() {
        return "Preview:".concat(getName());
    }

    public final void updateConfigAndOutput(PreviewConfig previewConfig, AutoValue_StreamSpec autoValue_StreamSpec) {
        CharsKt.checkMainThread();
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        clearPipeline$2();
        int i = 0;
        Preconditions.checkState(null, this.mCameraEdge == null);
        Matrix matrix = this.mSensorToBufferTransformMatrix;
        boolean hasTransform = camera.getHasTransform();
        Size size = autoValue_StreamSpec.resolution;
        Rect rect = this.mViewPortCropRect;
        if (rect == null) {
            rect = size != null ? new Rect(0, 0, size.getWidth(), size.getHeight()) : null;
        }
        Objects.requireNonNull(rect);
        SurfaceEdge surfaceEdge = new SurfaceEdge(1, 34, autoValue_StreamSpec, matrix, hasTransform, rect, getRelativeRotation(camera, isMirroringRequired(camera)), ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation(), camera.getHasTransform() && isMirroringRequired(camera));
        this.mCameraEdge = surfaceEdge;
        Preview$$ExternalSyntheticLambda0 preview$$ExternalSyntheticLambda0 = new Preview$$ExternalSyntheticLambda0(i, this);
        CharsKt.checkMainThread();
        surfaceEdge.checkNotClosed();
        surfaceEdge.mOnInvalidatedListeners.add(preview$$ExternalSyntheticLambda0);
        SurfaceRequest surfaceRequestCreateSurfaceRequest = this.mCameraEdge.createSurfaceRequest(camera, true);
        this.mCurrentSurfaceRequest = surfaceRequestCreateSurfaceRequest;
        this.mSessionDeferrableSurface = surfaceRequestCreateSurfaceRequest.mInternalDeferrableSurface;
        if (this.mSurfaceProvider != null) {
            CameraInternal camera2 = getCamera();
            SurfaceEdge surfaceEdge2 = this.mCameraEdge;
            if (camera2 != null && surfaceEdge2 != null) {
                CharsKt.runOnMain(new SurfaceEdge$$ExternalSyntheticLambda3(surfaceEdge2, getRelativeRotation(camera2, isMirroringRequired(camera2)), ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation()));
            }
            SurfaceProvider surfaceProvider = this.mSurfaceProvider;
            surfaceProvider.getClass();
            SurfaceRequest surfaceRequest = this.mCurrentSurfaceRequest;
            surfaceRequest.getClass();
            this.mSurfaceProviderExecutor.execute(new Preview$$ExternalSyntheticLambda1(i, surfaceProvider, surfaceRequest));
        }
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(previewConfig, autoValue_StreamSpec.resolution);
        RealInterceptorChain realInterceptorChain = builderCreateFrom.mCaptureConfigBuilder;
        Range range = autoValue_StreamSpec.expectedFrameRateRange;
        realInterceptorChain.getClass();
        ((MutableOptionsBundle) realInterceptorChain.request).insertOption(CaptureConfig.OPTION_RESOLVED_FRAME_RATE, range);
        int iIntValue = ((Integer) previewConfig.retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0)).intValue();
        if (iIntValue != 0) {
            realInterceptorChain.getClass();
            if (iIntValue != 0) {
                ((MutableOptionsBundle) realInterceptorChain.request).insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(iIntValue));
            }
        }
        Config config = autoValue_StreamSpec.implementationOptions;
        if (config != null) {
            realInterceptorChain.addImplementationOptions(config);
        }
        if (this.mSurfaceProvider != null) {
            builderCreateFrom.addSurface(this.mSessionDeferrableSurface, autoValue_StreamSpec.dynamicRange, ((ImageOutputConfig) this.mCurrentConfig).getMirrorMode());
        }
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new Preview$$ExternalSyntheticLambda2(i, this));
        this.mCloseableErrorListener = closeableErrorListener2;
        builderCreateFrom.mErrorListener = closeableErrorListener2;
        this.mSessionConfigBuilder = builderCreateFrom;
        Object[] objArr = {builderCreateFrom.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder implements ExtendableBuilder, UseCaseConfig.Builder {
        public final /* synthetic */ int $r8$classId;
        public final MutableOptionsBundle mMutableConfig;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(int i) {
            this(MutableOptionsBundle.create(), 0);
            this.$r8$classId = i;
            switch (i) {
                case 1:
                    this.mMutableConfig = MutableOptionsBundle.create();
                    break;
                case 2:
                    this(MutableOptionsBundle.create(), 2);
                    break;
                default:
                    break;
            }
        }

        public static Builder from(Config config) {
            Builder builder = new Builder(1);
            config.findOptions(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(0, builder, config));
            return builder;
        }

        public Toolbar.AnonymousClass1 build() {
            return new Toolbar.AnonymousClass1(14, OptionsBundle.from(this.mMutableConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public final MutableConfig getMutableConfig() {
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
                    return new PreviewConfig(OptionsBundle.from(this.mMutableConfig));
                default:
                    return new ImageAnalysisConfig(OptionsBundle.from(this.mMutableConfig));
            }
        }

        public Builder(MutableOptionsBundle mutableOptionsBundle, int i) {
            Object objRetrieveOption;
            Object objRetrieveOption2;
            this.$r8$classId = i;
            switch (i) {
                case 2:
                    this.mMutableConfig = mutableOptionsBundle;
                    Object objRetrieveOption3 = null;
                    try {
                        objRetrieveOption = mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
                        break;
                    } catch (IllegalArgumentException unused) {
                        objRetrieveOption = null;
                    }
                    Class cls = (Class) objRetrieveOption;
                    if (cls != null && !cls.equals(ImageAnalysis.class)) {
                        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
                    }
                    this.mMutableConfig.insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
                    MutableOptionsBundle mutableOptionsBundle2 = this.mMutableConfig;
                    mutableOptionsBundle2.insertOption(TargetConfig.OPTION_TARGET_CLASS, ImageAnalysis.class);
                    try {
                        objRetrieveOption3 = mutableOptionsBundle2.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
                        break;
                    } catch (IllegalArgumentException unused2) {
                    }
                    if (objRetrieveOption3 == null) {
                        mutableOptionsBundle2.insertOption(TargetConfig.OPTION_TARGET_NAME, ImageAnalysis.class.getCanonicalName() + "-" + UUID.randomUUID());
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
                    if (cls2 != null && !cls2.equals(Preview.class)) {
                        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
                    }
                    this.mMutableConfig.insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, UseCaseConfigFactory.CaptureType.PREVIEW);
                    MutableOptionsBundle mutableOptionsBundle3 = this.mMutableConfig;
                    mutableOptionsBundle3.insertOption(TargetConfig.OPTION_TARGET_CLASS, Preview.class);
                    try {
                        objRetrieveOption4 = mutableOptionsBundle3.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
                        break;
                    } catch (IllegalArgumentException unused4) {
                    }
                    if (objRetrieveOption4 == null) {
                        this.mMutableConfig.insertOption(TargetConfig.OPTION_TARGET_NAME, Preview.class.getCanonicalName() + "-" + UUID.randomUUID());
                    }
                    Object objRetrieveOption5 = -1;
                    try {
                        objRetrieveOption5 = mutableOptionsBundle.retrieveOption(ImageOutputConfig.OPTION_MIRROR_MODE);
                        break;
                    } catch (IllegalArgumentException unused5) {
                    }
                    if (((Integer) objRetrieveOption5).intValue() == -1) {
                        mutableOptionsBundle.insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, 2);
                        return;
                    }
                    return;
            }
        }
    }
}
