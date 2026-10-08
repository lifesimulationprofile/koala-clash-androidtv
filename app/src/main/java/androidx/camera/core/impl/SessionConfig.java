package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.util.ArrayMap;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks$NoOpSessionCaptureCallback;
import androidx.camera.camera2.internal.CameraCaptureSessionStateCallbacks$NoOpSessionStateCallback;
import androidx.camera.camera2.internal.CameraDeviceStateCallbacks$NoOpDeviceStateCallback;
import androidx.camera.camera2.internal.CaptureCallbackContainer;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.camera2.internal.compat.workaround.PreviewPixelHDRnet;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.Preview$$ExternalSyntheticLambda2;
import androidx.compose.ui.semantics.SemanticsSortKt$$ExternalSyntheticLambda0;
import coil.intercept.RealInterceptorChain;
import coil.util.ImmutableHardwareBitmapService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SessionConfig {
    public static final List SUPPORTED_TEMPLATE_PRIORITY = Arrays.asList(1, 5, 3);
    public final List mDeviceStateCallbacks;
    public final ErrorListener mErrorListener;
    public final InputConfiguration mInputConfiguration;
    public final ArrayList mOutputConfigs;
    public final AutoValue_SessionConfig_OutputConfig mPostviewOutputConfig;
    public final CaptureConfig mRepeatingCaptureConfig;
    public final List mSessionStateCallbacks;
    public final List mSingleCameraCaptureCallbacks;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class BaseBuilder {
        public CloseableErrorListener mErrorListener;
        public InputConfiguration mInputConfiguration;
        public AutoValue_SessionConfig_OutputConfig mPostviewOutputConfig;
        public final LinkedHashSet mOutputConfigs = new LinkedHashSet();
        public final RealInterceptorChain mCaptureConfigBuilder = new RealInterceptorChain();
        public final ArrayList mDeviceStateCallbacks = new ArrayList();
        public final ArrayList mSessionStateCallbacks = new ArrayList();
        public final ArrayList mSingleCameraCaptureCallbacks = new ArrayList();
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder extends BaseBuilder {
        public static Builder createFrom(UseCaseConfig useCaseConfig, Size size) {
            if (useCaseConfig.getSessionOptionUnpacker() == null) {
                throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.getTargetName(useCaseConfig.toString()));
            }
            Builder builder = new Builder();
            SessionConfig defaultSessionConfig$1 = useCaseConfig.getDefaultSessionConfig$1();
            OptionsBundle optionsBundle = OptionsBundle.EMPTY_BUNDLE;
            int i = SessionConfig.defaultEmptySessionConfig().mRepeatingCaptureConfig.mTemplateType;
            if (defaultSessionConfig$1 != null) {
                i = defaultSessionConfig$1.mRepeatingCaptureConfig.mTemplateType;
                for (CameraDevice.StateCallback stateCallback : defaultSessionConfig$1.mDeviceStateCallbacks) {
                    ArrayList arrayList = builder.mDeviceStateCallbacks;
                    if (!arrayList.contains(stateCallback)) {
                        arrayList.add(stateCallback);
                    }
                }
                for (CameraCaptureSession.StateCallback stateCallback2 : defaultSessionConfig$1.mSessionStateCallbacks) {
                    ArrayList arrayList2 = builder.mSessionStateCallbacks;
                    if (!arrayList2.contains(stateCallback2)) {
                        arrayList2.add(stateCallback2);
                    }
                }
                builder.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(defaultSessionConfig$1.mRepeatingCaptureConfig.mCameraCaptureCallbacks);
                optionsBundle = defaultSessionConfig$1.mRepeatingCaptureConfig.mImplementationOptions;
            }
            RealInterceptorChain realInterceptorChain = builder.mCaptureConfigBuilder;
            realInterceptorChain.getClass();
            realInterceptorChain.request = MutableOptionsBundle.from((Config) optionsBundle);
            if (useCaseConfig instanceof PreviewConfig) {
                Rational rational = PreviewPixelHDRnet.ASPECT_RATIO_16_9;
                if (((PreviewPixelHDRnetQuirk) DeviceQuirks.sQuirks.get(PreviewPixelHDRnetQuirk.class)) != null && !PreviewPixelHDRnet.ASPECT_RATIO_16_9.equals(new Rational(size.getWidth(), size.getHeight()))) {
                    MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
                    mutableOptionsBundleCreate.insertOption(Camera2ImplConfig.createCaptureRequestOption(CaptureRequest.TONEMAP_MODE), 2);
                    builder.mCaptureConfigBuilder.addImplementationOptions(new Camera2ImplConfig(14, OptionsBundle.from(mutableOptionsBundleCreate)));
                }
            }
            builder.mCaptureConfigBuilder.index = ((Integer) useCaseConfig.retrieveOption(Camera2ImplConfig.TEMPLATE_TYPE_OPTION, Integer.valueOf(i))).intValue();
            CameraDevice.StateCallback stateCallback3 = (CameraDevice.StateCallback) useCaseConfig.retrieveOption(Camera2ImplConfig.DEVICE_STATE_CALLBACK_OPTION, new CameraDeviceStateCallbacks$NoOpDeviceStateCallback());
            ArrayList arrayList3 = builder.mDeviceStateCallbacks;
            if (!arrayList3.contains(stateCallback3)) {
                arrayList3.add(stateCallback3);
            }
            CameraCaptureSession.StateCallback stateCallback4 = (CameraCaptureSession.StateCallback) useCaseConfig.retrieveOption(Camera2ImplConfig.SESSION_STATE_CALLBACK_OPTION, new CameraCaptureSessionStateCallbacks$NoOpSessionStateCallback());
            ArrayList arrayList4 = builder.mSessionStateCallbacks;
            if (!arrayList4.contains(stateCallback4)) {
                arrayList4.add(stateCallback4);
            }
            CaptureCallbackContainer captureCallbackContainer = new CaptureCallbackContainer((CameraCaptureSession.CaptureCallback) useCaseConfig.retrieveOption(Camera2ImplConfig.SESSION_CAPTURE_CALLBACK_OPTION, new Camera2CaptureCallbacks$NoOpSessionCaptureCallback()));
            builder.mCaptureConfigBuilder.addCameraCaptureCallback(captureCallbackContainer);
            ArrayList arrayList5 = builder.mSingleCameraCaptureCallbacks;
            if (!arrayList5.contains(captureCallbackContainer)) {
                arrayList5.add(captureCallbackContainer);
            }
            int videoStabilizationMode = useCaseConfig.getVideoStabilizationMode();
            if (videoStabilizationMode != 0) {
                RealInterceptorChain realInterceptorChain2 = builder.mCaptureConfigBuilder;
                realInterceptorChain2.getClass();
                if (videoStabilizationMode != 0) {
                    ((MutableOptionsBundle) realInterceptorChain2.request).insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(videoStabilizationMode));
                }
            }
            int previewStabilizationMode = useCaseConfig.getPreviewStabilizationMode();
            if (previewStabilizationMode != 0) {
                RealInterceptorChain realInterceptorChain3 = builder.mCaptureConfigBuilder;
                realInterceptorChain3.getClass();
                if (previewStabilizationMode != 0) {
                    ((MutableOptionsBundle) realInterceptorChain3.request).insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(previewStabilizationMode));
                }
            }
            MutableOptionsBundle mutableOptionsBundleCreate2 = MutableOptionsBundle.create();
            AutoValue_Config_Option autoValue_Config_Option = Camera2ImplConfig.SESSION_PHYSICAL_CAMERA_ID_OPTION;
            mutableOptionsBundleCreate2.insertOption(autoValue_Config_Option, (String) useCaseConfig.retrieveOption(autoValue_Config_Option, null));
            AutoValue_Config_Option autoValue_Config_Option2 = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
            Long l = (Long) useCaseConfig.retrieveOption(autoValue_Config_Option2, -1L);
            l.getClass();
            mutableOptionsBundleCreate2.insertOption(autoValue_Config_Option2, l);
            builder.mCaptureConfigBuilder.addImplementationOptions(mutableOptionsBundleCreate2);
            builder.mCaptureConfigBuilder.addImplementationOptions(Preview.Builder.from(useCaseConfig).build());
            return builder;
        }

        public final void addImplementationOptions(Config config) {
            this.mCaptureConfigBuilder.addImplementationOptions(config);
        }

        public final void addSurface(DeferrableSurface deferrableSurface, DynamicRange dynamicRange, int i) {
            Request requestBuilder = AutoValue_SessionConfig_OutputConfig.builder(deferrableSurface);
            if (dynamicRange == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            requestBuilder.lazyCacheControl = dynamicRange;
            requestBuilder.headers = Integer.valueOf(i);
            this.mOutputConfigs.add(requestBuilder.build());
            ((HashSet) this.mCaptureConfigBuilder.initialRequest).add(deferrableSurface);
        }

        public final SessionConfig build() {
            return new SessionConfig(new ArrayList(this.mOutputConfigs), new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), this.mCaptureConfigBuilder.build(), this.mErrorListener, this.mInputConfiguration, this.mPostviewOutputConfig);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CloseableErrorListener implements ErrorListener {
        public final ErrorListener mErrorListener;
        public final AtomicBoolean mIsClosed = new AtomicBoolean(false);

        public CloseableErrorListener(ErrorListener errorListener) {
            this.mErrorListener = errorListener;
        }

        public final void close() {
            this.mIsClosed.set(true);
        }

        @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
        public final void onError(SessionConfig sessionConfig) {
            if (this.mIsClosed.get()) {
                return;
            }
            this.mErrorListener.onError(sessionConfig);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface ErrorListener {
        void onError(SessionConfig sessionConfig);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ValidatingBuilder extends BaseBuilder {
        public final ImmutableHardwareBitmapService mSurfaceSorter = new ImmutableHardwareBitmapService(4);
        public boolean mValid = true;
        public boolean mTemplateSet = false;
        public final ArrayList mErrorListeners = new ArrayList();

        public final void add(SessionConfig sessionConfig) {
            Object objRetrieveOption;
            CaptureConfig captureConfig = sessionConfig.mRepeatingCaptureConfig;
            int i = captureConfig.mTemplateType;
            OptionsBundle optionsBundle = captureConfig.mImplementationOptions;
            RealInterceptorChain realInterceptorChain = this.mCaptureConfigBuilder;
            if (i != -1) {
                this.mTemplateSet = true;
                int i2 = realInterceptorChain.index;
                List list = SessionConfig.SUPPORTED_TEMPLATE_PRIORITY;
                if (list.indexOf(Integer.valueOf(i)) < list.indexOf(Integer.valueOf(i2))) {
                    i = i2;
                }
                realInterceptorChain.index = i;
            }
            AutoValue_Config_Option autoValue_Config_Option = CaptureConfig.OPTION_RESOLVED_FRAME_RATE;
            Object objRetrieveOption2 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            try {
                objRetrieveOption2 = optionsBundle.retrieveOption(autoValue_Config_Option);
            } catch (IllegalArgumentException unused) {
            }
            Range range = (Range) objRetrieveOption2;
            Objects.requireNonNull(range);
            Range range2 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            if (!range.equals(range2)) {
                MutableOptionsBundle mutableOptionsBundle = (MutableOptionsBundle) realInterceptorChain.request;
                AutoValue_Config_Option autoValue_Config_Option2 = CaptureConfig.OPTION_RESOLVED_FRAME_RATE;
                mutableOptionsBundle.getClass();
                try {
                    objRetrieveOption = mutableOptionsBundle.retrieveOption(autoValue_Config_Option2);
                } catch (IllegalArgumentException unused2) {
                    objRetrieveOption = range2;
                }
                if (((Range) objRetrieveOption).equals(range2)) {
                    ((MutableOptionsBundle) realInterceptorChain.request).insertOption(CaptureConfig.OPTION_RESOLVED_FRAME_RATE, range);
                } else {
                    MutableOptionsBundle mutableOptionsBundle2 = (MutableOptionsBundle) realInterceptorChain.request;
                    AutoValue_Config_Option autoValue_Config_Option3 = CaptureConfig.OPTION_RESOLVED_FRAME_RATE;
                    Object objRetrieveOption3 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                    mutableOptionsBundle2.getClass();
                    try {
                        objRetrieveOption3 = mutableOptionsBundle2.retrieveOption(autoValue_Config_Option3);
                    } catch (IllegalArgumentException unused3) {
                    }
                    if (!((Range) objRetrieveOption3).equals(range)) {
                        this.mValid = false;
                        Logger.d("ValidatingBuilder", "Different ExpectedFrameRateRange values");
                    }
                }
            }
            int previewStabilizationMode = captureConfig.getPreviewStabilizationMode();
            if (previewStabilizationMode != 0) {
                realInterceptorChain.getClass();
                if (previewStabilizationMode != 0) {
                    ((MutableOptionsBundle) realInterceptorChain.request).insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(previewStabilizationMode));
                }
            }
            int videoStabilizationMode = captureConfig.getVideoStabilizationMode();
            if (videoStabilizationMode != 0) {
                realInterceptorChain.getClass();
                if (videoStabilizationMode != 0) {
                    ((MutableOptionsBundle) realInterceptorChain.request).insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(videoStabilizationMode));
                }
            }
            TagBundle tagBundle = captureConfig.mTagBundle;
            MutableTagBundle mutableTagBundle = (MutableTagBundle) realInterceptorChain.size;
            HashSet hashSet = (HashSet) realInterceptorChain.initialRequest;
            mutableTagBundle.mTagMap.putAll((Map) tagBundle.mTagMap);
            this.mDeviceStateCallbacks.addAll(sessionConfig.mDeviceStateCallbacks);
            this.mSessionStateCallbacks.addAll(sessionConfig.mSessionStateCallbacks);
            realInterceptorChain.addAllCameraCaptureCallbacks(captureConfig.mCameraCaptureCallbacks);
            this.mSingleCameraCaptureCallbacks.addAll(sessionConfig.mSingleCameraCaptureCallbacks);
            ErrorListener errorListener = sessionConfig.mErrorListener;
            if (errorListener != null) {
                this.mErrorListeners.add(errorListener);
            }
            InputConfiguration inputConfiguration = sessionConfig.mInputConfiguration;
            if (inputConfiguration != null) {
                this.mInputConfiguration = inputConfiguration;
            }
            ArrayList arrayList = sessionConfig.mOutputConfigs;
            LinkedHashSet<AutoValue_SessionConfig_OutputConfig> linkedHashSet = this.mOutputConfigs;
            linkedHashSet.addAll(arrayList);
            hashSet.addAll(Collections.unmodifiableList(captureConfig.mSurfaces));
            ArrayList arrayList2 = new ArrayList();
            for (AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig : linkedHashSet) {
                arrayList2.add(autoValue_SessionConfig_OutputConfig.surface);
                Iterator it = autoValue_SessionConfig_OutputConfig.sharedSurfaces.iterator();
                while (it.hasNext()) {
                    arrayList2.add((DeferrableSurface) it.next());
                }
            }
            if (!arrayList2.containsAll(hashSet)) {
                Logger.d("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.mValid = false;
            }
            AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig2 = sessionConfig.mPostviewOutputConfig;
            if (autoValue_SessionConfig_OutputConfig2 != null) {
                AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig3 = this.mPostviewOutputConfig;
                if (autoValue_SessionConfig_OutputConfig3 == autoValue_SessionConfig_OutputConfig2 || autoValue_SessionConfig_OutputConfig3 == null) {
                    this.mPostviewOutputConfig = autoValue_SessionConfig_OutputConfig2;
                } else {
                    Logger.d("ValidatingBuilder", "Invalid configuration due to that two different postview output configs are set");
                    this.mValid = false;
                }
            }
            realInterceptorChain.addImplementationOptions(optionsBundle);
        }

        public final SessionConfig build() {
            if (!this.mValid) {
                throw new IllegalArgumentException("Unsupported session configuration combination");
            }
            ArrayList arrayList = new ArrayList(this.mOutputConfigs);
            ImmutableHardwareBitmapService immutableHardwareBitmapService = this.mSurfaceSorter;
            if (immutableHardwareBitmapService.allowHardware) {
                Collections.sort(arrayList, new SemanticsSortKt$$ExternalSyntheticLambda0(1, immutableHardwareBitmapService));
            }
            return new SessionConfig(arrayList, new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), this.mCaptureConfigBuilder.build(), !this.mErrorListeners.isEmpty() ? new Preview$$ExternalSyntheticLambda2(4, this) : null, this.mInputConfiguration, this.mPostviewOutputConfig);
        }
    }

    public SessionConfig(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, CaptureConfig captureConfig, ErrorListener errorListener, InputConfiguration inputConfiguration, AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig) {
        this.mOutputConfigs = arrayList;
        this.mDeviceStateCallbacks = Collections.unmodifiableList(arrayList2);
        this.mSessionStateCallbacks = Collections.unmodifiableList(arrayList3);
        this.mSingleCameraCaptureCallbacks = Collections.unmodifiableList(arrayList4);
        this.mErrorListener = errorListener;
        this.mRepeatingCaptureConfig = captureConfig;
        this.mInputConfiguration = inputConfiguration;
        this.mPostviewOutputConfig = autoValue_SessionConfig_OutputConfig;
    }

    public static SessionConfig defaultEmptySessionConfig() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(0);
        ArrayList arrayList3 = new ArrayList(0);
        ArrayList arrayList4 = new ArrayList(0);
        HashSet hashSet = new HashSet();
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        ArrayList arrayList5 = new ArrayList();
        MutableTagBundle mutableTagBundleCreate = MutableTagBundle.create();
        ArrayList arrayList6 = new ArrayList(hashSet);
        OptionsBundle optionsBundleFrom = OptionsBundle.from(mutableOptionsBundleCreate);
        ArrayList arrayList7 = new ArrayList(arrayList5);
        TagBundle tagBundle = TagBundle.EMPTY_TAGBUNDLE;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = mutableTagBundleCreate.mTagMap;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        return new SessionConfig(arrayList, arrayList2, arrayList3, arrayList4, new CaptureConfig(arrayList6, optionsBundleFrom, -1, arrayList7, false, new TagBundle(arrayMap), null), null, null, null);
    }

    public final List getSurfaces() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.mOutputConfigs;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig = (AutoValue_SessionConfig_OutputConfig) obj;
            arrayList.add(autoValue_SessionConfig_OutputConfig.surface);
            Iterator it = autoValue_SessionConfig_OutputConfig.sharedSurfaces.iterator();
            while (it.hasNext()) {
                arrayList.add((DeferrableSurface) it.next());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
