package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.SupportedSurfaceCombination;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.Camera;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.AutoValue_AttachedSurfaceInfo;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_Identifier;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.AutoValue_SurfaceConfig;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.RestrictedCameraControl;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import androidx.room.DatabaseConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.collections.EmptyList;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraUseCaseAdapter implements Camera {
    public final RestrictedCameraControl mAdapterCameraControl;
    public final RestrictedCameraInfo mAdapterCameraInfo;
    public final RestrictedCameraInfo mAdapterSecondaryCameraInfo;
    public final Toolbar.AnonymousClass1 mCameraConfig;
    public final DatabaseConfiguration mCameraCoordinator;
    public final SurfaceRequest.AnonymousClass1 mCameraDeviceSurfaceManager;
    public final CameraInternal mCameraInternal;
    public final AutoValue_CameraUseCaseAdapter_CameraId mId;
    public final LayoutSettings mLayoutSettings;
    public UseCase mPlaceholderForExtensions;
    public final CameraInternal mSecondaryCameraInternal;
    public final LayoutSettings mSecondaryLayoutSettings;
    public StreamSharing mStreamSharing;
    public final UseCaseConfigFactory mUseCaseConfigFactory;
    public final ArrayList mAppUseCases = new ArrayList();
    public final ArrayList mCameraUseCases = new ArrayList();
    public List mEffects = Collections.EMPTY_LIST;
    public final Object mLock = new Object();
    public boolean mAttached = true;
    public Config mInteropConfig = null;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CameraException extends Exception {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ConfigPair {
        public UseCaseConfig mCameraConfig;
        public UseCaseConfig mExtendedConfig;
    }

    public CameraUseCaseAdapter(CameraInternal cameraInternal, CameraInternal cameraInternal2, RestrictedCameraInfo restrictedCameraInfo, RestrictedCameraInfo restrictedCameraInfo2, DatabaseConfiguration databaseConfiguration, SurfaceRequest.AnonymousClass1 anonymousClass1, Camera2UseCaseConfigFactory camera2UseCaseConfigFactory) {
        this.mCameraInternal = cameraInternal;
        this.mSecondaryCameraInternal = cameraInternal2;
        LayoutSettings layoutSettings = LayoutSettings.DEFAULT;
        this.mLayoutSettings = layoutSettings;
        this.mSecondaryLayoutSettings = layoutSettings;
        this.mCameraCoordinator = databaseConfiguration;
        this.mCameraDeviceSurfaceManager = anonymousClass1;
        this.mUseCaseConfigFactory = camera2UseCaseConfigFactory;
        Toolbar.AnonymousClass1 anonymousClass2 = restrictedCameraInfo.mCameraConfig;
        this.mCameraConfig = anonymousClass2;
        anonymousClass2.getSessionProcessor();
        this.mAdapterCameraControl = new RestrictedCameraControl(cameraInternal.getCameraControlInternal());
        this.mAdapterCameraInfo = restrictedCameraInfo;
        this.mAdapterSecondaryCameraInfo = restrictedCameraInfo2;
        this.mId = generateCameraId(restrictedCameraInfo, restrictedCameraInfo2);
    }

    public static Matrix calculateSensorToBufferTransformMatrix(Rect rect, Size size) {
        Preconditions.checkArgument("Cannot compute viewport crop rects zero sized sensor rect.", rect.width() > 0 && rect.height() > 0);
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    public static ImageCapture createExtraImageCapture() {
        Object objRetrieveOption;
        Object objRetrieveOption2;
        Object objRetrieveOption3;
        ImageCapture.Builder builder = new ImageCapture.Builder(0);
        AutoValue_Config_Option autoValue_Config_Option = TargetConfig.OPTION_TARGET_NAME;
        MutableOptionsBundle mutableOptionsBundle = builder.mMutableConfig;
        mutableOptionsBundle.insertOption(autoValue_Config_Option, "ImageCapture-Extra");
        AutoValue_Config_Option autoValue_Config_Option2 = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
        mutableOptionsBundle.getClass();
        Object objRetrieveOption4 = null;
        try {
            objRetrieveOption = mutableOptionsBundle.retrieveOption(autoValue_Config_Option2);
        } catch (IllegalArgumentException unused) {
            objRetrieveOption = null;
        }
        Integer num = (Integer) objRetrieveOption;
        if (num != null) {
            mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, num);
        } else {
            ImageCapture.Defaults defaults = ImageCapture.DEFAULT_CONFIG;
            try {
                objRetrieveOption2 = mutableOptionsBundle.retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT);
            } catch (IllegalArgumentException unused2) {
                objRetrieveOption2 = null;
            }
            if (Objects.equals(objRetrieveOption2, 1)) {
                mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
                mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
            } else {
                mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
            }
        }
        ImageCaptureConfig imageCaptureConfig = new ImageCaptureConfig(OptionsBundle.from(mutableOptionsBundle));
        ImageOutputConfig.CC.validateConfig(imageCaptureConfig);
        ImageCapture imageCapture = new ImageCapture(imageCaptureConfig);
        try {
            objRetrieveOption3 = mutableOptionsBundle.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
        } catch (IllegalArgumentException unused3) {
            objRetrieveOption3 = null;
        }
        Size size = (Size) objRetrieveOption3;
        if (size != null) {
            new Rational(size.getWidth(), size.getHeight());
        }
        AutoValue_Config_Option autoValue_Config_Option3 = IoConfig.OPTION_IO_EXECUTOR;
        Object objIoExecutor = HexFormatKt.ioExecutor();
        try {
            objIoExecutor = mutableOptionsBundle.retrieveOption(autoValue_Config_Option3);
        } catch (IllegalArgumentException unused4) {
        }
        Preconditions.checkNotNull((Executor) objIoExecutor, "The IO executor can't be null");
        AutoValue_Config_Option autoValue_Config_Option4 = ImageCaptureConfig.OPTION_FLASH_MODE;
        if (mutableOptionsBundle.mOptions.containsKey(autoValue_Config_Option4)) {
            Integer num2 = (Integer) mutableOptionsBundle.retrieveOption(autoValue_Config_Option4);
            if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                throw new IllegalArgumentException("The flash mode is not allowed to set: " + num2);
            }
            if (num2.intValue() == 3) {
                try {
                    objRetrieveOption4 = mutableOptionsBundle.retrieveOption(ImageCaptureConfig.OPTION_SCREEN_FLASH);
                } catch (IllegalArgumentException unused5) {
                }
                if (objRetrieveOption4 == null) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
                }
            }
        }
        return imageCapture;
    }

    public static AutoValue_CameraUseCaseAdapter_CameraId generateCameraId(RestrictedCameraInfo restrictedCameraInfo, RestrictedCameraInfo restrictedCameraInfo2) {
        StringBuilder sb = new StringBuilder();
        sb.append(restrictedCameraInfo.mCameraInfoInternal.getCameraId());
        sb.append(restrictedCameraInfo2 == null ? "" : restrictedCameraInfo2.mCameraInfoInternal.getCameraId());
        return new AutoValue_CameraUseCaseAdapter_CameraId(sb.toString(), (AutoValue_Identifier) restrictedCameraInfo.mCameraConfig.this$0);
    }

    public static HashMap getConfigs(ArrayList arrayList, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        UseCaseConfig defaultConfig;
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            UseCase useCase = (UseCase) obj;
            if (useCase instanceof StreamSharing) {
                StreamSharing streamSharing = (StreamSharing) useCase;
                PreviewConfig previewConfig = new PreviewConfig(OptionsBundle.from(new Preview.Builder(0).mMutableConfig));
                ImageOutputConfig.CC.validateConfig(previewConfig);
                Preview preview = new Preview(previewConfig);
                preview.mSurfaceProviderExecutor = Preview.DEFAULT_SURFACE_PROVIDER_EXECUTOR;
                UseCaseConfig defaultConfig2 = preview.getDefaultConfig(false, useCaseConfigFactory);
                if (defaultConfig2 == null) {
                    defaultConfig = null;
                } else {
                    MutableOptionsBundle mutableOptionsBundleFrom = MutableOptionsBundle.from((Config) defaultConfig2);
                    mutableOptionsBundleFrom.mOptions.remove(TargetConfig.OPTION_TARGET_CLASS);
                    defaultConfig = ((ImageCapture.Builder) streamSharing.getUseCaseConfigBuilder(mutableOptionsBundleFrom)).getUseCaseConfig();
                }
            } else {
                defaultConfig = useCase.getDefaultConfig(false, useCaseConfigFactory);
            }
            UseCaseConfig defaultConfig3 = useCase.getDefaultConfig(true, useCaseConfigFactory2);
            ConfigPair configPair = new ConfigPair();
            configPair.mExtendedConfig = defaultConfig;
            configPair.mCameraConfig = defaultConfig3;
            map.put(useCase, configPair);
        }
        return map;
    }

    public static boolean hasImplementationOptionChanged(AutoValue_StreamSpec autoValue_StreamSpec, SessionConfig sessionConfig) {
        Config config = autoValue_StreamSpec.implementationOptions;
        OptionsBundle optionsBundle = sessionConfig.mRepeatingCaptureConfig.mImplementationOptions;
        if (config.listOptions().size() != sessionConfig.mRepeatingCaptureConfig.mImplementationOptions.listOptions().size()) {
            return true;
        }
        for (AutoValue_Config_Option autoValue_Config_Option : config.listOptions()) {
            if (!optionsBundle.mOptions.containsKey(autoValue_Config_Option) || !Objects.equals(optionsBundle.retrieveOption(autoValue_Config_Option), config.retrieveOption(autoValue_Config_Option))) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList setEffectsOnUseCases(List list, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(list);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((UseCase) obj).getClass();
            Iterator it = list.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
        return arrayList2;
    }

    public final void addUseCases(List list) {
        synchronized (this.mLock) {
            try {
                this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
                CameraInternal cameraInternal = this.mSecondaryCameraInternal;
                if (cameraInternal != null) {
                    cameraInternal.setExtendedConfig(this.mCameraConfig);
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
                linkedHashSet.addAll(list);
                try {
                    updateUseCases(linkedHashSet, this.mSecondaryCameraInternal != null);
                } catch (IllegalArgumentException e) {
                    throw new CameraException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void attachUseCases() {
        synchronized (this.mLock) {
            try {
                if (!this.mAttached) {
                    if (!this.mCameraUseCases.isEmpty()) {
                        this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
                        CameraInternal cameraInternal = this.mSecondaryCameraInternal;
                        if (cameraInternal != null) {
                            cameraInternal.setExtendedConfig(this.mCameraConfig);
                        }
                    }
                    this.mCameraInternal.attachUseCases(this.mCameraUseCases);
                    CameraInternal cameraInternal2 = this.mSecondaryCameraInternal;
                    if (cameraInternal2 != null) {
                        cameraInternal2.attachUseCases(this.mCameraUseCases);
                    }
                    restoreInteropConfig();
                    ArrayList arrayList = this.mCameraUseCases;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((UseCase) obj).notifyState();
                    }
                    this.mAttached = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00af  */
    public final UseCase calculatePlaceholderForExtensions(LinkedHashSet linkedHashSet, StreamSharing streamSharing) {
        UseCase useCaseCreateExtraImageCapture;
        synchronized (this.mLock) {
            try {
                ArrayList arrayList = new ArrayList(linkedHashSet);
                if (streamSharing != null) {
                    arrayList.add(streamSharing);
                    arrayList.removeAll(streamSharing.mVirtualCameraAdapter.mChildren);
                }
                if (isCoexistingPreviewImageCaptureRequired()) {
                    int size = arrayList.size();
                    boolean z = false;
                    boolean z2 = false;
                    boolean z3 = false;
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        UseCase useCase = (UseCase) obj;
                        if ((useCase instanceof Preview) || (useCase instanceof StreamSharing)) {
                            z3 = true;
                        } else if (useCase instanceof ImageCapture) {
                            z2 = true;
                        }
                    }
                    if (!z2 || z3) {
                        int size2 = arrayList.size();
                        boolean z4 = false;
                        int i2 = 0;
                        while (i2 < size2) {
                            Object obj2 = arrayList.get(i2);
                            i2++;
                            UseCase useCase2 = (UseCase) obj2;
                            if ((useCase2 instanceof Preview) || (useCase2 instanceof StreamSharing)) {
                                z = true;
                            } else if (useCase2 instanceof ImageCapture) {
                                z4 = true;
                            }
                        }
                        if (!z || z4) {
                            useCaseCreateExtraImageCapture = null;
                        } else {
                            UseCase useCase3 = this.mPlaceholderForExtensions;
                            useCaseCreateExtraImageCapture = useCase3 instanceof ImageCapture ? useCase3 : createExtraImageCapture();
                        }
                    } else {
                        UseCase useCase4 = this.mPlaceholderForExtensions;
                        if (useCase4 instanceof Preview) {
                            useCaseCreateExtraImageCapture = useCase4;
                        } else {
                            Preview.Builder builder = new Preview.Builder(0);
                            builder.mMutableConfig.insertOption(TargetConfig.OPTION_TARGET_NAME, "Preview-Extra");
                            PreviewConfig previewConfig = new PreviewConfig(OptionsBundle.from(builder.mMutableConfig));
                            ImageOutputConfig.CC.validateConfig(previewConfig);
                            Preview preview = new Preview(previewConfig);
                            preview.mSurfaceProviderExecutor = Preview.DEFAULT_SURFACE_PROVIDER_EXECUTOR;
                            preview.setSurfaceProvider(new ZslControlImpl$$ExternalSyntheticLambda0(2));
                            useCaseCreateExtraImageCapture = preview;
                        }
                    }
                } else {
                    useCaseCreateExtraImageCapture = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return useCaseCreateExtraImageCapture;
    }

    public final HashMap calculateSuggestedStreamSpecs(int i, CameraInfoInternal cameraInfoInternal, ArrayList arrayList, ArrayList arrayList2, HashMap map) {
        SurfaceRequest.AnonymousClass1 anonymousClass1;
        Rect sensorRect;
        int size;
        int i2;
        boolean z;
        ArrayList arrayList3 = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        int size2 = arrayList2.size();
        int i3 = 0;
        while (true) {
            anonymousClass1 = this.mCameraDeviceSurfaceManager;
            Size size3 = null;
            if (i3 >= size2) {
                break;
            }
            Object obj = arrayList2.get(i3);
            i3++;
            UseCase useCase = (UseCase) obj;
            int inputFormat = useCase.mCurrentConfig.getInputFormat();
            AutoValue_StreamSpec autoValue_StreamSpec = useCase.mAttachedStreamSpec;
            Size size4 = autoValue_StreamSpec != null ? autoValue_StreamSpec.resolution : null;
            SupportedSurfaceCombination supportedSurfaceCombination = (SupportedSurfaceCombination) ((HashMap) anonymousClass1.val$requestCancellationCompleter).get(cameraId);
            AutoValue_SurfaceConfig autoValue_SurfaceConfigTransformSurfaceConfig = supportedSurfaceCombination != null ? AutoValue_SurfaceConfig.transformSurfaceConfig(i, inputFormat, size4, supportedSurfaceCombination.getUpdatedSurfaceSizeDefinitionByFormat(inputFormat)) : null;
            int inputFormat2 = useCase.mCurrentConfig.getInputFormat();
            AutoValue_StreamSpec autoValue_StreamSpec2 = useCase.mAttachedStreamSpec;
            if (autoValue_StreamSpec2 != null) {
                size3 = autoValue_StreamSpec2.resolution;
            }
            autoValue_StreamSpec2.getClass();
            AutoValue_AttachedSurfaceInfo autoValue_AttachedSurfaceInfo = new AutoValue_AttachedSurfaceInfo(autoValue_SurfaceConfigTransformSurfaceConfig, inputFormat2, size3, autoValue_StreamSpec2.dynamicRange, StreamSharing.getCaptureTypes(useCase), useCase.mAttachedStreamSpec.implementationOptions, useCase.mCurrentConfig.getTargetFrameRate());
            arrayList3.add(autoValue_AttachedSurfaceInfo);
            map3.put(autoValue_AttachedSurfaceInfo, useCase);
            map2.put(useCase, useCase.mAttachedStreamSpec);
        }
        if (!arrayList.isEmpty()) {
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            try {
                sensorRect = this.mCameraInternal.getCameraControlInternal().getSensorRect();
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    UseCase useCase2 = (UseCase) obj2;
                    if (useCase2 != null) {
                        if (useCase2.mCurrentConfig.containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                            if (useCase2.mCurrentConfig.getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) {
                                z = true;
                                break;
                            }
                        } else {
                            Log.e("CameraUseCaseAdapter", useCase2 + " UseCase does not have capture type.");
                        }
                    }
                }
            } catch (NullPointerException unused) {
                sensorRect = null;
            }
            SupportedOutputSizesSorter supportedOutputSizesSorter = new SupportedOutputSizesSorter(cameraInfoInternal, sensorRect != null ? TransformUtils.rectToSize(sensorRect) : null);
            int size5 = arrayList.size();
            boolean z2 = false;
            int i4 = 0;
            while (i4 < size5) {
                Object obj3 = arrayList.get(i4);
                i4++;
                UseCase useCase3 = (UseCase) obj3;
                ConfigPair configPair = (ConfigPair) map.get(useCase3);
                ArrayList arrayList4 = arrayList3;
                UseCaseConfig useCaseConfigMergeConfigs = useCase3.mergeConfigs(cameraInfoInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                map4.put(useCaseConfigMergeConfigs, useCase3);
                map5.put(useCaseConfigMergeConfigs, supportedOutputSizesSorter.getSortedSupportedOutputSizes(useCaseConfigMergeConfigs));
                UseCaseConfig useCaseConfig = useCase3.mCurrentConfig;
                if (useCaseConfig instanceof PreviewConfig) {
                    z2 = ((Integer) ((PreviewConfig) useCaseConfig).retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0)).intValue() == 2;
                }
                arrayList3 = arrayList4;
            }
            ArrayList arrayList5 = arrayList3;
            size = arrayList.size();
            i2 = 0;
            anonymousClass1.getClass();
            Preconditions.checkArgument("No new use cases to be bound.", !map5.isEmpty());
            SupportedSurfaceCombination supportedSurfaceCombination2 = (SupportedSurfaceCombination) ((HashMap) anonymousClass1.val$requestCancellationCompleter).get(cameraId);
            if (supportedSurfaceCombination2 == null) {
                throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m("No such camera id in supported combination list: ", cameraId));
            }
            Pair suggestedStreamSpecifications = supportedSurfaceCombination2.getSuggestedStreamSpecifications(i, arrayList5, map5, z2, z);
            for (Map.Entry entry : map4.entrySet()) {
                map2.put((UseCase) entry.getValue(), (AutoValue_StreamSpec) ((Map) suggestedStreamSpecifications.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) suggestedStreamSpecifications.second).entrySet()) {
                if (map3.containsKey(entry2.getKey())) {
                    map2.put((UseCase) map3.get(entry2.getKey()), (AutoValue_StreamSpec) entry2.getValue());
                }
            }
        }
        return map2;
    }

    public final void checkUnsupportedFeatureCombinationAndThrow(LinkedHashSet linkedHashSet) {
        boolean z;
        hasExtension();
        synchronized (this.mLock) {
            try {
                if (!this.mEffects.isEmpty()) {
                    Iterator it = linkedHashSet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        UseCase useCase = (UseCase) it.next();
                        if (useCase instanceof ImageCapture) {
                            UseCaseConfig useCaseConfig = useCase.mCurrentConfig;
                            AutoValue_Config_Option autoValue_Config_Option = ImageCaptureConfig.OPTION_OUTPUT_FORMAT;
                            if (useCaseConfig.containsOption(autoValue_Config_Option)) {
                                Integer num = (Integer) useCaseConfig.retrieveOption(autoValue_Config_Option);
                                num.getClass();
                                z = true;
                                if (num.intValue() == 1) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    if (z) {
                        throw new IllegalArgumentException("Ultra HDR image capture does not support for use with CameraEffect.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final StreamSharing createOrReuseStreamSharing(LinkedHashSet linkedHashSet, boolean z) {
        boolean z2;
        synchronized (this.mLock) {
            try {
                HashSet<UseCase> streamSharingChildren = getStreamSharingChildren(linkedHashSet, z);
                if (streamSharingChildren.size() < 2) {
                    hasExtension();
                    return null;
                }
                StreamSharing streamSharing = this.mStreamSharing;
                if (streamSharing != null && streamSharing.mVirtualCameraAdapter.mChildren.equals(streamSharingChildren)) {
                    StreamSharing streamSharing2 = this.mStreamSharing;
                    Objects.requireNonNull(streamSharing2);
                    return streamSharing2;
                }
                int[] iArr = {1, 2, 4};
                HashSet hashSet = new HashSet();
                for (UseCase useCase : streamSharingChildren) {
                    for (int i = 0; i < 3; i++) {
                        int i2 = iArr[i];
                        Iterator it = useCase.getSupportedEffectTargets().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            int iIntValue = ((Integer) it.next()).intValue();
                            if ((i2 & iIntValue) == iIntValue) {
                                z2 = true;
                                break;
                            }
                        }
                        if (z2) {
                            if (hashSet.contains(Integer.valueOf(i2))) {
                                return null;
                            }
                            hashSet.add(Integer.valueOf(i2));
                        }
                    }
                }
                return new StreamSharing(this.mCameraInternal, this.mSecondaryCameraInternal, this.mLayoutSettings, this.mSecondaryLayoutSettings, streamSharingChildren, this.mUseCaseConfigFactory);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void detachUseCases() {
        synchronized (this.mLock) {
            try {
                if (this.mAttached) {
                    this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                    CameraInternal cameraInternal = this.mSecondaryCameraInternal;
                    if (cameraInternal != null) {
                        cameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                    }
                    cacheInteropConfig();
                    this.mAttached = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.Camera
    public final CameraInfoInternal getCameraInfo() {
        return this.mAdapterCameraInfo;
    }

    public final int getCameraMode$1() {
        synchronized (this.mLock) {
            try {
                return this.mCameraCoordinator.journalMode == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final HashSet getStreamSharingChildren(LinkedHashSet linkedHashSet, boolean z) {
        int i;
        HashSet hashSet = new HashSet();
        synchronized (this.mLock) {
            Iterator it = this.mEffects.iterator();
            if (it.hasNext()) {
                if (it.next() == null) {
                    throw null;
                }
                throw new ClassCastException();
            }
            i = z ? 3 : 0;
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            UseCase useCase = (UseCase) it2.next();
            Preconditions.checkArgument("Only support one level of sharing for now.", !(useCase instanceof StreamSharing));
            Iterator it3 = useCase.getSupportedEffectTargets().iterator();
            while (it3.hasNext()) {
                int iIntValue = ((Integer) it3.next()).intValue();
                if ((i & iIntValue) == iIntValue) {
                    hashSet.add(useCase);
                    break;
                }
            }
        }
        return hashSet;
    }

    public final List getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mAppUseCases);
        }
        return arrayList;
    }

    public final void hasExtension() {
        synchronized (this.mLock) {
            this.mCameraConfig.getSessionProcessor();
        }
    }

    public final boolean isCoexistingPreviewImageCaptureRequired() {
        boolean z;
        synchronized (this.mLock) {
            Toolbar.AnonymousClass1 anonymousClass1 = this.mCameraConfig;
            anonymousClass1.getClass();
            z = ((Integer) ((OptionsBundle) anonymousClass1.getConfig()).retrieveOption(CameraConfig.OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, 0)).intValue() == 1;
        }
        return z;
    }

    public final void removeUseCases(ArrayList arrayList) {
        synchronized (this.mLock) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.removeAll(arrayList);
            updateUseCases(linkedHashSet, this.mSecondaryCameraInternal != null);
        }
    }

    public final void restoreInteropConfig() {
        synchronized (this.mLock) {
            try {
                if (this.mInteropConfig != null) {
                    this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setEffects() {
        EmptyList emptyList = EmptyList.INSTANCE;
        synchronized (this.mLock) {
            this.mEffects = emptyList;
        }
    }

    public final void setViewPort() {
        synchronized (this.mLock) {
        }
    }

    public final void updateUseCases(LinkedHashSet linkedHashSet, boolean z) {
        int i;
        AutoValue_StreamSpec autoValue_StreamSpec;
        Config config;
        synchronized (this.mLock) {
            try {
                checkUnsupportedFeatureCombinationAndThrow(linkedHashSet);
                if (!z) {
                    hasExtension();
                }
                StreamSharing streamSharingCreateOrReuseStreamSharing = createOrReuseStreamSharing(linkedHashSet, z);
                UseCase useCaseCalculatePlaceholderForExtensions = calculatePlaceholderForExtensions(linkedHashSet, streamSharingCreateOrReuseStreamSharing);
                ArrayList arrayList = new ArrayList(linkedHashSet);
                if (useCaseCalculatePlaceholderForExtensions != null) {
                    arrayList.add(useCaseCalculatePlaceholderForExtensions);
                }
                if (streamSharingCreateOrReuseStreamSharing != null) {
                    arrayList.add(streamSharingCreateOrReuseStreamSharing);
                    arrayList.removeAll(streamSharingCreateOrReuseStreamSharing.mVirtualCameraAdapter.mChildren);
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                arrayList2.removeAll(this.mCameraUseCases);
                ArrayList arrayList3 = new ArrayList(arrayList);
                arrayList3.retainAll(this.mCameraUseCases);
                ArrayList arrayList4 = new ArrayList(this.mCameraUseCases);
                arrayList4.removeAll(arrayList);
                Toolbar.AnonymousClass1 anonymousClass1 = this.mCameraConfig;
                anonymousClass1.getClass();
                HashMap configs = getConfigs(arrayList2, (UseCaseConfigFactory) ((OptionsBundle) anonymousClass1.getConfig()).retrieveOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, UseCaseConfigFactory.EMPTY_INSTANCE), this.mUseCaseConfigFactory);
                Map mapCalculateSuggestedStreamSpecs = Collections.EMPTY_MAP;
                try {
                    HashMap mapCalculateSuggestedStreamSpecs2 = calculateSuggestedStreamSpecs(getCameraMode$1(), this.mCameraInternal.getCameraInfoInternal(), arrayList2, arrayList3, configs);
                    if (this.mSecondaryCameraInternal != null) {
                        int cameraMode$1 = getCameraMode$1();
                        CameraInternal cameraInternal = this.mSecondaryCameraInternal;
                        Objects.requireNonNull(cameraInternal);
                        mapCalculateSuggestedStreamSpecs = calculateSuggestedStreamSpecs(cameraMode$1, cameraInternal.getCameraInfoInternal(), arrayList2, arrayList3, configs);
                    }
                    updateViewPortAndSensorToBufferMatrix(mapCalculateSuggestedStreamSpecs2, arrayList);
                    ArrayList effectsOnUseCases = setEffectsOnUseCases(this.mEffects, arrayList);
                    ArrayList arrayList5 = new ArrayList(linkedHashSet);
                    arrayList5.removeAll(arrayList);
                    ArrayList effectsOnUseCases2 = setEffectsOnUseCases(effectsOnUseCases, arrayList5);
                    if (effectsOnUseCases2.size() > 0) {
                        Logger.w("CameraUseCaseAdapter", "Unused effects: " + effectsOnUseCases2);
                    }
                    int size = arrayList4.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList4.get(i2);
                        i2++;
                        ((UseCase) obj).unbindFromCamera(this.mCameraInternal);
                    }
                    this.mCameraInternal.detachUseCases(arrayList4);
                    if (this.mSecondaryCameraInternal != null) {
                        int size2 = arrayList4.size();
                        int i3 = 0;
                        while (i3 < size2) {
                            Object obj2 = arrayList4.get(i3);
                            i3++;
                            CameraInternal cameraInternal2 = this.mSecondaryCameraInternal;
                            Objects.requireNonNull(cameraInternal2);
                            ((UseCase) obj2).unbindFromCamera(cameraInternal2);
                        }
                        CameraInternal cameraInternal3 = this.mSecondaryCameraInternal;
                        Objects.requireNonNull(cameraInternal3);
                        cameraInternal3.detachUseCases(arrayList4);
                    }
                    if (arrayList4.isEmpty()) {
                        int size3 = arrayList3.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            Object obj3 = arrayList3.get(i4);
                            i4++;
                            UseCase useCase = (UseCase) obj3;
                            if (!mapCalculateSuggestedStreamSpecs2.containsKey(useCase) || (config = (autoValue_StreamSpec = (AutoValue_StreamSpec) mapCalculateSuggestedStreamSpecs2.get(useCase)).implementationOptions) == null) {
                                i = size3;
                            } else {
                                i = size3;
                                if (hasImplementationOptionChanged(autoValue_StreamSpec, useCase.mAttachedSessionConfig)) {
                                    useCase.mAttachedStreamSpec = useCase.onSuggestedStreamSpecImplementationOptionsUpdated(config);
                                    if (this.mAttached) {
                                        this.mCameraInternal.onUseCaseUpdated(useCase);
                                        CameraInternal cameraInternal4 = this.mSecondaryCameraInternal;
                                        if (cameraInternal4 != null) {
                                            cameraInternal4.onUseCaseUpdated(useCase);
                                        }
                                    }
                                }
                            }
                            size3 = i;
                        }
                    }
                    int i5 = 0;
                    for (int size4 = arrayList2.size(); i5 < size4; size4 = size4) {
                        Object obj4 = arrayList2.get(i5);
                        i5++;
                        UseCase useCase2 = (UseCase) obj4;
                        ConfigPair configPair = (ConfigPair) configs.get(useCase2);
                        Objects.requireNonNull(configPair);
                        CameraInternal cameraInternal5 = this.mSecondaryCameraInternal;
                        if (cameraInternal5 != null) {
                            useCase2.bindToCamera(this.mCameraInternal, cameraInternal5, configPair.mExtendedConfig, configPair.mCameraConfig);
                            AutoValue_StreamSpec autoValue_StreamSpec2 = (AutoValue_StreamSpec) mapCalculateSuggestedStreamSpecs2.get(useCase2);
                            autoValue_StreamSpec2.getClass();
                            useCase2.mAttachedStreamSpec = useCase2.onSuggestedStreamSpecUpdated(autoValue_StreamSpec2, (AutoValue_StreamSpec) mapCalculateSuggestedStreamSpecs.get(useCase2));
                        } else {
                            useCase2.bindToCamera(this.mCameraInternal, null, configPair.mExtendedConfig, configPair.mCameraConfig);
                            AutoValue_StreamSpec autoValue_StreamSpec3 = (AutoValue_StreamSpec) mapCalculateSuggestedStreamSpecs2.get(useCase2);
                            autoValue_StreamSpec3.getClass();
                            useCase2.mAttachedStreamSpec = useCase2.onSuggestedStreamSpecUpdated(autoValue_StreamSpec3, null);
                        }
                    }
                    if (this.mAttached) {
                        this.mCameraInternal.attachUseCases(arrayList2);
                        CameraInternal cameraInternal6 = this.mSecondaryCameraInternal;
                        if (cameraInternal6 != null) {
                            cameraInternal6.attachUseCases(arrayList2);
                        }
                    }
                    int size5 = arrayList2.size();
                    int i6 = 0;
                    while (i6 < size5) {
                        Object obj5 = arrayList2.get(i6);
                        i6++;
                        ((UseCase) obj5).notifyState();
                    }
                    this.mAppUseCases.clear();
                    this.mAppUseCases.addAll(linkedHashSet);
                    this.mCameraUseCases.clear();
                    this.mCameraUseCases.addAll(arrayList);
                    this.mPlaceholderForExtensions = useCaseCalculatePlaceholderForExtensions;
                    this.mStreamSharing = streamSharingCreateOrReuseStreamSharing;
                } catch (IllegalArgumentException e) {
                    if (!z) {
                        hasExtension();
                        if (this.mCameraCoordinator.journalMode != 2) {
                            updateUseCases(linkedHashSet, true);
                            return;
                        }
                    }
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void updateViewPortAndSensorToBufferMatrix(HashMap map, ArrayList arrayList) {
        synchronized (this.mLock) {
            try {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    UseCase useCase = (UseCase) obj;
                    Rect sensorRect = this.mCameraInternal.getCameraControlInternal().getSensorRect();
                    AutoValue_StreamSpec autoValue_StreamSpec = (AutoValue_StreamSpec) map.get(useCase);
                    autoValue_StreamSpec.getClass();
                    useCase.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(sensorRect, autoValue_StreamSpec.resolution));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
