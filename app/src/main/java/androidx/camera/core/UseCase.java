package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class UseCase {
    public AutoValue_StreamSpec mAttachedStreamSpec;
    public CameraInternal mCamera;
    public UseCaseConfig mCameraConfig;
    public UseCaseConfig mCurrentConfig;
    public UseCaseConfig mExtendedConfig;
    public CameraInternal mSecondaryCamera;
    public final Object mUseCaseConfig;
    public Rect mViewPortCropRect;
    public final HashSet mStateChangeCallbacks = new HashSet();
    public final Object mCameraLock = new Object();
    public int mState = 2;
    public Matrix mSensorToBufferTransformMatrix = new Matrix();
    public SessionConfig mAttachedSessionConfig = SessionConfig.defaultEmptySessionConfig();
    public SessionConfig mAttachedSecondarySessionConfig = SessionConfig.defaultEmptySessionConfig();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface StateChangeCallback {
        void onUseCaseActive(UseCase useCase);

        void onUseCaseInactive(UseCase useCase);

        void onUseCaseReset(UseCase useCase);

        void onUseCaseUpdated(UseCase useCase);
    }

    public UseCase(UseCaseConfig useCaseConfig) {
        this.mUseCaseConfig = useCaseConfig;
        this.mCurrentConfig = useCaseConfig;
    }

    public final void bindToCamera(CameraInternal cameraInternal, CameraInternal cameraInternal2, UseCaseConfig useCaseConfig, UseCaseConfig useCaseConfig2) {
        synchronized (this.mCameraLock) {
            this.mCamera = cameraInternal;
            this.mSecondaryCamera = cameraInternal2;
            this.mStateChangeCallbacks.add(cameraInternal);
            if (cameraInternal2 != null) {
                this.mStateChangeCallbacks.add(cameraInternal2);
            }
        }
        this.mExtendedConfig = useCaseConfig;
        this.mCameraConfig = useCaseConfig2;
        this.mCurrentConfig = mergeConfigs(cameraInternal.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        onBind();
    }

    public final CameraInternal getCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mCameraLock) {
            cameraInternal = this.mCamera;
        }
        return cameraInternal;
    }

    public final CameraControlInternal getCameraControl() {
        synchronized (this.mCameraLock) {
            try {
                CameraInternal cameraInternal = this.mCamera;
                if (cameraInternal == null) {
                    return CameraControlInternal.DEFAULT_EMPTY_INSTANCE;
                }
                return cameraInternal.getCameraControlInternal();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String getCameraId() {
        CameraInternal camera = getCamera();
        Preconditions.checkNotNull(camera, "No camera attached to use case: " + this);
        return camera.getCameraInfoInternal().getCameraId();
    }

    public abstract UseCaseConfig getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory);

    public final String getName() {
        String targetName = this.mCurrentConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(targetName);
        return targetName;
    }

    public final int getRelativeRotation(CameraInternal cameraInternal, boolean z) {
        int sensorRotationDegrees = cameraInternal.getCameraInfoInternal().getSensorRotationDegrees(((ImageOutputConfig) this.mCurrentConfig).getTargetRotation());
        return (cameraInternal.getHasTransform() || !z) ? sensorRotationDegrees : TransformUtils.within360(-sensorRotationDegrees);
    }

    public final CameraInternal getSecondaryCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mCameraLock) {
            cameraInternal = this.mSecondaryCamera;
        }
        return cameraInternal;
    }

    public Set getSupportedEffectTargets() {
        return Collections.EMPTY_SET;
    }

    public abstract UseCaseConfig.Builder getUseCaseConfigBuilder(Config config);

    public final boolean isMirroringRequired(CameraInternal cameraInternal) {
        int mirrorMode = ((ImageOutputConfig) this.mCurrentConfig).getMirrorMode();
        if (mirrorMode == -1 || mirrorMode == 0) {
            return false;
        }
        if (mirrorMode == 1) {
            return true;
        }
        if (mirrorMode == 2) {
            return cameraInternal.isFrontFacing();
        }
        throw new AssertionError(ImageAnalysis$$ExternalSyntheticLambda1.m("Unknown mirrorMode: ", mirrorMode));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.camera.core.impl.Config, java.lang.Object] */
    public final UseCaseConfig mergeConfigs(CameraInfoInternal cameraInfoInternal, UseCaseConfig useCaseConfig, UseCaseConfig useCaseConfig2) {
        MutableOptionsBundle mutableOptionsBundleCreate;
        if (useCaseConfig2 != null) {
            mutableOptionsBundleCreate = MutableOptionsBundle.from((Config) useCaseConfig2);
            mutableOptionsBundleCreate.mOptions.remove(TargetConfig.OPTION_TARGET_NAME);
        } else {
            mutableOptionsBundleCreate = MutableOptionsBundle.create();
        }
        TreeMap treeMap = mutableOptionsBundleCreate.mOptions;
        AutoValue_Config_Option autoValue_Config_Option = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
        ?? r2 = this.mUseCaseConfig;
        if (r2.containsOption(autoValue_Config_Option) || r2.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            AutoValue_Config_Option autoValue_Config_Option2 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
            if (treeMap.containsKey(autoValue_Config_Option2)) {
                treeMap.remove(autoValue_Config_Option2);
            }
        }
        AutoValue_Config_Option autoValue_Config_Option3 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (r2.containsOption(autoValue_Config_Option3)) {
            AutoValue_Config_Option autoValue_Config_Option4 = ImageOutputConfig.OPTION_MAX_RESOLUTION;
            if (treeMap.containsKey(autoValue_Config_Option4) && ((ResolutionSelector) r2.retrieveOption(autoValue_Config_Option3)).mResolutionStrategy != null) {
                treeMap.remove(autoValue_Config_Option4);
            }
        }
        Iterator it = r2.listOptions().iterator();
        while (it.hasNext()) {
            ImageAnalysis$$ExternalSyntheticLambda1.mergeOptionValue(mutableOptionsBundleCreate, mutableOptionsBundleCreate, r2, (AutoValue_Config_Option) it.next());
        }
        if (useCaseConfig != null) {
            for (AutoValue_Config_Option autoValue_Config_Option5 : useCaseConfig.listOptions()) {
                if (!autoValue_Config_Option5.id.equals(TargetConfig.OPTION_TARGET_NAME.id)) {
                    ImageAnalysis$$ExternalSyntheticLambda1.mergeOptionValue(mutableOptionsBundleCreate, mutableOptionsBundleCreate, useCaseConfig, autoValue_Config_Option5);
                }
            }
        }
        if (treeMap.containsKey(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            AutoValue_Config_Option autoValue_Config_Option6 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
            if (treeMap.containsKey(autoValue_Config_Option6)) {
                treeMap.remove(autoValue_Config_Option6);
            }
        }
        AutoValue_Config_Option autoValue_Config_Option7 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (treeMap.containsKey(autoValue_Config_Option7)) {
            ((ResolutionSelector) mutableOptionsBundleCreate.retrieveOption(autoValue_Config_Option7)).getClass();
        }
        return onMergeConfig(cameraInfoInternal, getUseCaseConfigBuilder(mutableOptionsBundleCreate));
    }

    public final void notifyActive() {
        this.mState = 1;
        notifyState();
    }

    public final void notifyReset() {
        Iterator it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            ((StateChangeCallback) it.next()).onUseCaseReset(this);
        }
    }

    public final void notifyState() {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mState);
        HashSet hashSet = this.mStateChangeCallbacks;
        if (iOrdinal == 0) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((StateChangeCallback) it.next()).onUseCaseActive(this);
            }
        } else {
            if (iOrdinal != 1) {
                return;
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ((StateChangeCallback) it2.next()).onUseCaseInactive(this);
            }
        }
    }

    public abstract UseCaseConfig onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder builder);

    public abstract AutoValue_StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config);

    public abstract AutoValue_StreamSpec onSuggestedStreamSpecUpdated(AutoValue_StreamSpec autoValue_StreamSpec, AutoValue_StreamSpec autoValue_StreamSpec2);

    public abstract void onUnbind();

    public void setSensorToBufferTransformMatrix(Matrix matrix) {
        this.mSensorToBufferTransformMatrix = new Matrix(matrix);
    }

    public void setViewPortCropRect(Rect rect) {
        this.mViewPortCropRect = rect;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.camera.core.impl.UseCaseConfig, java.lang.Object] */
    public final void unbindFromCamera(CameraInternal cameraInternal) {
        onUnbind();
        synchronized (this.mCameraLock) {
            try {
                CameraInternal cameraInternal2 = this.mCamera;
                if (cameraInternal == cameraInternal2) {
                    this.mStateChangeCallbacks.remove(cameraInternal2);
                    this.mCamera = null;
                }
                CameraInternal cameraInternal3 = this.mSecondaryCamera;
                if (cameraInternal == cameraInternal3) {
                    this.mStateChangeCallbacks.remove(cameraInternal3);
                    this.mSecondaryCamera = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mAttachedStreamSpec = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
    }

    public final void updateSessionConfig(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.mAttachedSessionConfig = (SessionConfig) list.get(0);
        if (list.size() > 1) {
            this.mAttachedSecondarySessionConfig = (SessionConfig) list.get(1);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (DeferrableSurface deferrableSurface : ((SessionConfig) it.next()).getSurfaces()) {
                if (deferrableSurface.mContainerClass == null) {
                    deferrableSurface.mContainerClass = getClass();
                }
            }
        }
    }

    public void onBind() {
    }

    public void onCameraControlReady() {
    }

    public void onStateAttached() {
    }

    public void onStateDetached() {
    }
}
