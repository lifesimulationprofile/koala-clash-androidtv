package androidx.camera.core.streamsharing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda6;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.UseCase;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda3;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorNode$Out;
import androidx.camera.core.processing.concurrent.AutoValue_DualOutConfig;
import androidx.camera.core.processing.concurrent.AutoValue_DualSurfaceProcessorNode_In;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.core.processing.util.AutoValue_OutConfig;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import coil.intercept.RealInterceptorChain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.text.CharsKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StreamSharing extends UseCase {
    public SurfaceEdge mCameraEdge;
    public SessionConfig.CloseableErrorListener mCloseableErrorListener;
    public final StreamSharingConfig mDefaultConfig;
    public Request mDualSharingNode;
    public final LayoutSettings mLayoutSettings;
    public SurfaceEdge mSecondaryCameraEdge;
    public final LayoutSettings mSecondaryLayoutSettings;
    public SessionConfig.Builder mSecondarySessionConfigBuilder;
    public SurfaceEdge mSecondarySharingInputEdge;
    public SessionConfig.Builder mSessionConfigBuilder;
    public SurfaceEdge mSharingInputEdge;
    public MenuHostHelper mSharingNode;
    public final VirtualCameraAdapter mVirtualCameraAdapter;

    public StreamSharing(CameraInternal cameraInternal, CameraInternal cameraInternal2, LayoutSettings layoutSettings, LayoutSettings layoutSettings2, HashSet hashSet, UseCaseConfigFactory useCaseConfigFactory) {
        super(getDefaultConfig(hashSet));
        this.mDefaultConfig = getDefaultConfig(hashSet);
        this.mLayoutSettings = layoutSettings;
        this.mSecondaryLayoutSettings = layoutSettings2;
        this.mVirtualCameraAdapter = new VirtualCameraAdapter(cameraInternal, cameraInternal2, hashSet, useCaseConfigFactory, new ZslControlImpl$$ExternalSyntheticLambda0(3));
    }

    public static ArrayList getCaptureTypes(UseCase useCase) {
        ArrayList arrayList = new ArrayList();
        if (!(useCase instanceof StreamSharing)) {
            arrayList.add(useCase.mCurrentConfig.getCaptureType());
            return arrayList;
        }
        Iterator it = ((StreamSharing) useCase).mVirtualCameraAdapter.mChildren.iterator();
        while (it.hasNext()) {
            arrayList.add(((UseCase) it.next()).mCurrentConfig.getCaptureType());
        }
        return arrayList;
    }

    public static StreamSharingConfig getDefaultConfig(HashSet hashSet) {
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        new ImageCapture.Builder(mutableOptionsBundleCreate, 3);
        mutableOptionsBundleCreate.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            if (useCase.mCurrentConfig.containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                arrayList.add(useCase.mCurrentConfig.getCaptureType());
            } else {
                Log.e("StreamSharing", "A child does not have capture type.");
            }
        }
        mutableOptionsBundleCreate.insertOption(StreamSharingConfig.OPTION_CAPTURE_TYPES, arrayList);
        mutableOptionsBundleCreate.insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, 2);
        return new StreamSharingConfig(OptionsBundle.from(mutableOptionsBundleCreate));
    }

    public final void clearPipeline$3() {
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
            this.mCloseableErrorListener = null;
        }
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        SurfaceEdge surfaceEdge2 = this.mSecondaryCameraEdge;
        if (surfaceEdge2 != null) {
            surfaceEdge2.close();
            this.mSecondaryCameraEdge = null;
        }
        SurfaceEdge surfaceEdge3 = this.mSharingInputEdge;
        if (surfaceEdge3 != null) {
            surfaceEdge3.close();
            this.mSharingInputEdge = null;
        }
        SurfaceEdge surfaceEdge4 = this.mSecondarySharingInputEdge;
        if (surfaceEdge4 != null) {
            surfaceEdge4.close();
            this.mSecondarySharingInputEdge = null;
        }
        MenuHostHelper menuHostHelper = this.mSharingNode;
        if (menuHostHelper != null) {
            ((DefaultSurfaceProcessor) menuHostHelper.mOnInvalidateMenuCallback).release();
            CharsKt.runOnMain(new Preview$$ExternalSyntheticLambda0(20, menuHostHelper));
            this.mSharingNode = null;
        }
        Request request = this.mDualSharingNode;
        if (request != null) {
            ((SurfaceProcessorInternal) request.url).release();
            CharsKt.runOnMain(new Preview$$ExternalSyntheticLambda0(22, request));
            this.mDualSharingNode = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List createPipelineAndUpdateChildrenSpecs(String str, String str2, UseCaseConfig useCaseConfig, AutoValue_StreamSpec autoValue_StreamSpec, AutoValue_StreamSpec autoValue_StreamSpec2) {
        boolean z;
        CharsKt.checkMainThread();
        VirtualCameraAdapter virtualCameraAdapter = this.mVirtualCameraAdapter;
        if (autoValue_StreamSpec2 == null) {
            createPrimaryCamera(str, str2, useCaseConfig, autoValue_StreamSpec, null);
            CameraInternal camera = getCamera();
            Objects.requireNonNull(camera);
            this.mSharingNode = new MenuHostHelper(camera, new DefaultSurfaceProcessor(autoValue_StreamSpec.dynamicRange));
            boolean z2 = this.mViewPortCropRect != null;
            SurfaceEdge surfaceEdge = this.mSharingInputEdge;
            int targetRotation = ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation();
            virtualCameraAdapter.getClass();
            HashMap map = new HashMap();
            for (UseCase useCase : virtualCameraAdapter.mChildren) {
                ResolutionsMerger resolutionsMerger = virtualCameraAdapter.mResolutionsMerger;
                CameraInternal cameraInternal = virtualCameraAdapter.mParentCamera;
                VirtualCameraAdapter virtualCameraAdapter2 = virtualCameraAdapter;
                boolean z3 = z2;
                map.put(useCase, virtualCameraAdapter2.calculateOutConfig(useCase, resolutionsMerger, cameraInternal, surfaceEdge, targetRotation, z3));
                z2 = z3;
                virtualCameraAdapter = virtualCameraAdapter2;
            }
            VirtualCameraAdapter virtualCameraAdapter3 = virtualCameraAdapter;
            MenuHostHelper menuHostHelper = this.mSharingNode;
            SurfaceEdge surfaceEdge2 = this.mSharingInputEdge;
            ArrayList arrayList = new ArrayList(map.values());
            if (surfaceEdge2 == null) {
                throw new NullPointerException("Null surfaceEdge");
            }
            menuHostHelper.getClass();
            CharsKt.checkMainThread();
            menuHostHelper.mProviderToLifecycleContainers = new SurfaceProcessorNode$Out();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                int i2 = i + 1;
                AutoValue_OutConfig autoValue_OutConfig = (AutoValue_OutConfig) obj;
                SurfaceProcessorNode$Out surfaceProcessorNode$Out = (SurfaceProcessorNode$Out) menuHostHelper.mProviderToLifecycleContainers;
                Rect rect = autoValue_OutConfig.getCropRect;
                int i3 = autoValue_OutConfig.getRotationDegrees;
                boolean z4 = autoValue_OutConfig.isMirroring;
                Matrix matrix = new Matrix(surfaceEdge2.mSensorToBufferTransform);
                RectF rectF = new RectF(rect);
                Size size2 = autoValue_OutConfig.getSize;
                RectF rectF2 = TransformUtils.NORMALIZED_RECT;
                ArrayList arrayList2 = arrayList;
                int i4 = size;
                float f = 0;
                HashMap map2 = map;
                matrix.postConcat(TransformUtils.getRectToRect(rectF, new RectF(f, f, size2.getWidth(), size2.getHeight()), i3, z4));
                Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.rotateSize(TransformUtils.rectToSize(rect), i3), false, size2));
                Rect rect2 = new Rect(0, 0, size2.getWidth(), size2.getHeight());
                Request builder = surfaceEdge2.mStreamSpec.toBuilder();
                builder.url = size2;
                surfaceProcessorNode$Out.put(autoValue_OutConfig, new SurfaceEdge(autoValue_OutConfig.getTargets, autoValue_OutConfig.getFormat, builder.m850build(), matrix, false, rect2, surfaceEdge2.mRotationDegrees - i3, -1, surfaceEdge2.mMirroring != z4));
                arrayList = arrayList2;
                size = i4;
                i = i2;
                map = map2;
            }
            HashMap map3 = map;
            ((DefaultSurfaceProcessor) menuHostHelper.mOnInvalidateMenuCallback).onInputSurface(surfaceEdge2.createSurfaceRequest((CameraInternal) menuHostHelper.mMenuProviders, true));
            for (Map.Entry entry : ((SurfaceProcessorNode$Out) menuHostHelper.mProviderToLifecycleContainers).entrySet()) {
                menuHostHelper.createAndSendSurfaceOutput(surfaceEdge2, entry);
                SurfaceEdge surfaceEdge3 = (SurfaceEdge) entry.getValue();
                LiveDataObservable$$ExternalSyntheticLambda1 liveDataObservable$$ExternalSyntheticLambda1 = new LiveDataObservable$$ExternalSyntheticLambda1(menuHostHelper, surfaceEdge2, entry, 6);
                surfaceEdge3.getClass();
                CharsKt.checkMainThread();
                surfaceEdge3.checkNotClosed();
                surfaceEdge3.mOnInvalidatedListeners.add(liveDataObservable$$ExternalSyntheticLambda1);
            }
            surfaceEdge2.mTransformationUpdatesListeners.add(new CaptureNode$$ExternalSyntheticLambda3(1, (SurfaceProcessorNode$Out) menuHostHelper.mProviderToLifecycleContainers));
            SurfaceProcessorNode$Out surfaceProcessorNode$Out2 = (SurfaceProcessorNode$Out) menuHostHelper.mProviderToLifecycleContainers;
            HashMap map4 = new HashMap();
            for (Map.Entry entry2 : map3.entrySet()) {
                map4.put((UseCase) entry2.getKey(), (SurfaceEdge) surfaceProcessorNode$Out2.get(entry2.getValue()));
            }
            virtualCameraAdapter3.setChildrenEdges(map4);
            Object[] objArr = {this.mSessionConfigBuilder.build()};
            ArrayList arrayList3 = new ArrayList(1);
            Object obj2 = objArr[0];
            Objects.requireNonNull(obj2);
            arrayList3.add(obj2);
            return Collections.unmodifiableList(arrayList3);
        }
        createPrimaryCamera(str, str2, useCaseConfig, autoValue_StreamSpec, autoValue_StreamSpec2);
        Matrix matrix2 = this.mSensorToBufferTransformMatrix;
        CameraInternal secondaryCamera = getSecondaryCamera();
        Objects.requireNonNull(secondaryCamera);
        boolean hasTransform = secondaryCamera.getHasTransform();
        Size size3 = autoValue_StreamSpec2.resolution;
        Rect rect3 = this.mViewPortCropRect;
        if (rect3 != null) {
            z = false;
        } else {
            z = false;
            rect3 = new Rect(0, 0, size3.getWidth(), size3.getHeight());
        }
        Rect rect4 = rect3;
        CameraInternal secondaryCamera2 = getSecondaryCamera();
        Objects.requireNonNull(secondaryCamera2);
        int relativeRotation = getRelativeRotation(secondaryCamera2, z);
        CameraInternal secondaryCamera3 = getSecondaryCamera();
        Objects.requireNonNull(secondaryCamera3);
        SurfaceEdge surfaceEdge4 = new SurfaceEdge(3, 34, autoValue_StreamSpec2, matrix2, hasTransform, rect4, relativeRotation, -1, isMirroringRequired(secondaryCamera3));
        this.mSecondaryCameraEdge = surfaceEdge4;
        Objects.requireNonNull(getSecondaryCamera());
        this.mSecondarySharingInputEdge = surfaceEdge4;
        SessionConfig.Builder builderCreateSessionConfigBuilder = createSessionConfigBuilder(this.mSecondaryCameraEdge, useCaseConfig, autoValue_StreamSpec2);
        this.mSecondarySessionConfigBuilder = builderCreateSessionConfigBuilder;
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new StreamSharing$$ExternalSyntheticLambda1(this, str, str2, useCaseConfig, autoValue_StreamSpec, autoValue_StreamSpec2));
        this.mCloseableErrorListener = closeableErrorListener2;
        builderCreateSessionConfigBuilder.mErrorListener = closeableErrorListener2;
        this.mDualSharingNode = new Request(getCamera(), getSecondaryCamera(), new DualSurfaceProcessor(autoValue_StreamSpec.dynamicRange, this.mLayoutSettings, this.mSecondaryLayoutSettings));
        boolean z5 = this.mViewPortCropRect != null;
        SurfaceEdge surfaceEdge5 = this.mSharingInputEdge;
        SurfaceEdge surfaceEdge6 = this.mSecondarySharingInputEdge;
        int targetRotation2 = ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation();
        virtualCameraAdapter.getClass();
        HashMap map5 = new HashMap();
        for (UseCase useCase2 : virtualCameraAdapter.mChildren) {
            AutoValue_OutConfig autoValue_OutConfigCalculateOutConfig = virtualCameraAdapter.calculateOutConfig(useCase2, virtualCameraAdapter.mResolutionsMerger, virtualCameraAdapter.mParentCamera, surfaceEdge5, targetRotation2, z5);
            ResolutionsMerger resolutionsMerger2 = virtualCameraAdapter.mSecondaryResolutionsMerger;
            CameraInternal cameraInternal2 = virtualCameraAdapter.mSecondaryParentCamera;
            Objects.requireNonNull(cameraInternal2);
            map5.put(useCase2, new AutoValue_DualOutConfig(autoValue_OutConfigCalculateOutConfig, virtualCameraAdapter.calculateOutConfig(useCase2, resolutionsMerger2, cameraInternal2, surfaceEdge6, targetRotation2, z5)));
            surfaceEdge5 = surfaceEdge5;
        }
        Request request = this.mDualSharingNode;
        AutoValue_DualSurfaceProcessorNode_In autoValue_DualSurfaceProcessorNode_In = new AutoValue_DualSurfaceProcessorNode_In(this.mSharingInputEdge, this.mSecondarySharingInputEdge, new ArrayList(map5.values()));
        request.getClass();
        SurfaceProcessorInternal surfaceProcessorInternal = (SurfaceProcessorInternal) request.url;
        CharsKt.checkMainThread();
        request.lazyCacheControl = autoValue_DualSurfaceProcessorNode_In;
        request.tags = new SurfaceProcessorNode$Out();
        AutoValue_DualSurfaceProcessorNode_In autoValue_DualSurfaceProcessorNode_In2 = (AutoValue_DualSurfaceProcessorNode_In) request.lazyCacheControl;
        SurfaceEdge surfaceEdge7 = autoValue_DualSurfaceProcessorNode_In2.primarySurfaceEdge;
        SurfaceEdge surfaceEdge8 = autoValue_DualSurfaceProcessorNode_In2.secondarySurfaceEdge;
        ArrayList arrayList4 = autoValue_DualSurfaceProcessorNode_In2.outConfigs;
        int size4 = arrayList4.size();
        int i5 = 0;
        while (i5 < size4) {
            Object obj3 = arrayList4.get(i5);
            int i6 = i5 + 1;
            AutoValue_DualOutConfig autoValue_DualOutConfig = (AutoValue_DualOutConfig) obj3;
            SurfaceProcessorNode$Out surfaceProcessorNode$Out3 = (SurfaceProcessorNode$Out) request.tags;
            AutoValue_OutConfig autoValue_OutConfig2 = autoValue_DualOutConfig.primaryOutConfig;
            Rect rect5 = autoValue_OutConfig2.getCropRect;
            int i7 = autoValue_OutConfig2.getRotationDegrees;
            boolean z6 = autoValue_OutConfig2.isMirroring;
            Matrix matrix3 = new Matrix();
            Size sizeRotateSize = TransformUtils.rotateSize(TransformUtils.rectToSize(rect5), i7);
            ArrayList arrayList5 = arrayList4;
            Size size5 = autoValue_OutConfig2.getSize;
            int i8 = size4;
            Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(sizeRotateSize, false, size5));
            HashMap map6 = map5;
            Rect rect6 = new Rect(0, 0, size5.getWidth(), size5.getHeight());
            Request builder2 = surfaceEdge7.mStreamSpec.toBuilder();
            builder2.url = size5;
            surfaceProcessorNode$Out3.put(autoValue_DualOutConfig, new SurfaceEdge(autoValue_OutConfig2.getTargets, autoValue_OutConfig2.getFormat, builder2.m850build(), matrix3, false, rect6, surfaceEdge7.mRotationDegrees - i7, -1, surfaceEdge7.mMirroring != z6));
            size4 = i8;
            i5 = i6;
            map5 = map6;
            arrayList4 = arrayList5;
        }
        HashMap map7 = map5;
        surfaceProcessorInternal.onInputSurface(surfaceEdge7.createSurfaceRequest((CameraInternal) request.method, true));
        surfaceProcessorInternal.onInputSurface(surfaceEdge8.createSurfaceRequest((CameraInternal) request.headers, false));
        CameraInternal cameraInternal3 = (CameraInternal) request.method;
        CameraInternal cameraInternal4 = (CameraInternal) request.headers;
        for (Map.Entry entry3 : ((SurfaceProcessorNode$Out) request.tags).entrySet()) {
            SurfaceEdge surfaceEdge9 = surfaceEdge7;
            SurfaceEdge surfaceEdge10 = surfaceEdge8;
            request.createAndSendSurfaceOutput(cameraInternal3, cameraInternal4, surfaceEdge9, surfaceEdge10, entry3);
            SurfaceEdge surfaceEdge11 = (SurfaceEdge) entry3.getValue();
            CameraInternal cameraInternal5 = cameraInternal4;
            CameraInternal cameraInternal6 = cameraInternal3;
            Request request2 = request;
            Camera2CameraImpl$$ExternalSyntheticLambda6 camera2CameraImpl$$ExternalSyntheticLambda6 = new Camera2CameraImpl$$ExternalSyntheticLambda6(request2, cameraInternal6, cameraInternal5, surfaceEdge9, surfaceEdge10, entry3, 3);
            request = request2;
            cameraInternal3 = cameraInternal6;
            cameraInternal4 = cameraInternal5;
            surfaceEdge11.getClass();
            CharsKt.checkMainThread();
            surfaceEdge11.checkNotClosed();
            surfaceEdge11.mOnInvalidatedListeners.add(camera2CameraImpl$$ExternalSyntheticLambda6);
            surfaceEdge7 = surfaceEdge9;
            surfaceEdge8 = surfaceEdge10;
        }
        SurfaceProcessorNode$Out surfaceProcessorNode$Out4 = (SurfaceProcessorNode$Out) request.tags;
        HashMap map8 = new HashMap();
        for (Map.Entry entry4 : map7.entrySet()) {
            map8.put((UseCase) entry4.getKey(), (SurfaceEdge) surfaceProcessorNode$Out4.get(entry4.getValue()));
        }
        virtualCameraAdapter.setChildrenEdges(map8);
        Object[] objArr2 = {this.mSessionConfigBuilder.build(), this.mSecondarySessionConfigBuilder.build()};
        ArrayList arrayList6 = new ArrayList(2);
        for (int i9 = 0; i9 < 2; i9++) {
            Object obj4 = objArr2[i9];
            Objects.requireNonNull(obj4);
            arrayList6.add(obj4);
        }
        return Collections.unmodifiableList(arrayList6);
    }

    public final void createPrimaryCamera(String str, String str2, UseCaseConfig useCaseConfig, AutoValue_StreamSpec autoValue_StreamSpec, AutoValue_StreamSpec autoValue_StreamSpec2) {
        Matrix matrix = this.mSensorToBufferTransformMatrix;
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        boolean hasTransform = camera.getHasTransform();
        Size size = autoValue_StreamSpec.resolution;
        Rect rect = this.mViewPortCropRect;
        if (rect == null) {
            rect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        CameraInternal camera2 = getCamera();
        Objects.requireNonNull(camera2);
        int relativeRotation = getRelativeRotation(camera2, false);
        CameraInternal camera3 = getCamera();
        Objects.requireNonNull(camera3);
        SurfaceEdge surfaceEdge = new SurfaceEdge(3, 34, autoValue_StreamSpec, matrix, hasTransform, rect, relativeRotation, -1, isMirroringRequired(camera3));
        this.mCameraEdge = surfaceEdge;
        Objects.requireNonNull(getCamera());
        this.mSharingInputEdge = surfaceEdge;
        SessionConfig.Builder builderCreateSessionConfigBuilder = createSessionConfigBuilder(this.mCameraEdge, useCaseConfig, autoValue_StreamSpec);
        this.mSessionConfigBuilder = builderCreateSessionConfigBuilder;
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new StreamSharing$$ExternalSyntheticLambda1(this, str, str2, useCaseConfig, autoValue_StreamSpec, autoValue_StreamSpec2));
        this.mCloseableErrorListener = closeableErrorListener2;
        builderCreateSessionConfigBuilder.mErrorListener = closeableErrorListener2;
    }

    public final SessionConfig.Builder createSessionConfigBuilder(SurfaceEdge surfaceEdge, UseCaseConfig useCaseConfig, AutoValue_StreamSpec autoValue_StreamSpec) {
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(useCaseConfig, autoValue_StreamSpec.resolution);
        RealInterceptorChain realInterceptorChain = builderCreateFrom.mCaptureConfigBuilder;
        VirtualCameraAdapter virtualCameraAdapter = this.mVirtualCameraAdapter;
        Iterator it = virtualCameraAdapter.mChildren.iterator();
        int i = -1;
        while (it.hasNext()) {
            int i2 = ((UseCase) it.next()).mCurrentConfig.getDefaultSessionConfig().mRepeatingCaptureConfig.mTemplateType;
            List list = SessionConfig.SUPPORTED_TEMPLATE_PRIORITY;
            if (list.indexOf(Integer.valueOf(i)) < list.indexOf(Integer.valueOf(i2))) {
                i = i2;
            }
        }
        if (i != -1) {
            realInterceptorChain.index = i;
        }
        Size size = autoValue_StreamSpec.resolution;
        Iterator it2 = virtualCameraAdapter.mChildren.iterator();
        while (it2.hasNext()) {
            SessionConfig sessionConfigBuild = SessionConfig.Builder.createFrom(((UseCase) it2.next()).mCurrentConfig, size).build();
            CaptureConfig captureConfig = sessionConfigBuild.mRepeatingCaptureConfig;
            realInterceptorChain.addAllCameraCaptureCallbacks(captureConfig.mCameraCaptureCallbacks);
            List<CameraCaptureCallback> list2 = sessionConfigBuild.mSingleCameraCaptureCallbacks;
            ArrayList arrayList = builderCreateFrom.mSingleCameraCaptureCallbacks;
            for (CameraCaptureCallback cameraCaptureCallback : list2) {
                realInterceptorChain.addCameraCaptureCallback(cameraCaptureCallback);
                if (!arrayList.contains(cameraCaptureCallback)) {
                    arrayList.add(cameraCaptureCallback);
                }
            }
            for (CameraCaptureSession.StateCallback stateCallback : sessionConfigBuild.mSessionStateCallbacks) {
                ArrayList arrayList2 = builderCreateFrom.mSessionStateCallbacks;
                if (!arrayList2.contains(stateCallback)) {
                    arrayList2.add(stateCallback);
                }
            }
            for (CameraDevice.StateCallback stateCallback2 : sessionConfigBuild.mDeviceStateCallbacks) {
                ArrayList arrayList3 = builderCreateFrom.mDeviceStateCallbacks;
                if (!arrayList3.contains(stateCallback2)) {
                    arrayList3.add(stateCallback2);
                }
            }
            realInterceptorChain.addImplementationOptions(captureConfig.mImplementationOptions);
        }
        surfaceEdge.getClass();
        CharsKt.checkMainThread();
        surfaceEdge.checkNotClosed();
        Preconditions.checkState("Consumer can only be linked once.", !surfaceEdge.mHasConsumer);
        surfaceEdge.mHasConsumer = true;
        builderCreateFrom.addSurface(surfaceEdge.mSettableSurface, autoValue_StreamSpec.dynamicRange, -1);
        realInterceptorChain.addCameraCaptureCallback(virtualCameraAdapter.mParentMetadataCallback);
        Config config = autoValue_StreamSpec.implementationOptions;
        if (config != null) {
            realInterceptorChain.addImplementationOptions(config);
        }
        return builderCreateFrom;
    }

    @Override // androidx.camera.core.UseCase
    public final Set getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig.Builder getUseCaseConfigBuilder(Config config) {
        return new ImageCapture.Builder(MutableOptionsBundle.from(config), 3);
    }

    @Override // androidx.camera.core.UseCase
    public final void onBind() {
        VirtualCameraAdapter virtualCameraAdapter = this.mVirtualCameraAdapter;
        for (UseCase useCase : virtualCameraAdapter.mChildren) {
            VirtualCamera virtualCamera = (VirtualCamera) virtualCameraAdapter.mChildrenVirtualCameras.get(useCase);
            Objects.requireNonNull(virtualCamera);
            useCase.bindToCamera(virtualCamera, null, null, useCase.getDefaultConfig(true, virtualCameraAdapter.mUseCaseConfigFactory));
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0173  */
    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder builder) {
        Object objRetrieveOption;
        Object mutableConfig = builder.getMutableConfig();
        VirtualCameraAdapter virtualCameraAdapter = this.mVirtualCameraAdapter;
        HashSet hashSet = virtualCameraAdapter.mChildrenConfigs;
        ResolutionsMerger resolutionsMerger = virtualCameraAdapter.mResolutionsMerger;
        List supportedResolutions = resolutionsMerger.mCameraInfo.getSupportedResolutions(34);
        HashSet<UseCaseConfig> hashSet2 = resolutionsMerger.mChildrenConfigs;
        for (UseCaseConfig useCaseConfig : hashSet2) {
            if (!useCaseConfig.isHighResolutionDisabled() && (useCaseConfig instanceof ImageOutputConfig)) {
                ((ImageOutputConfig) useCaseConfig).getResolutionSelector$1();
            }
        }
        AutoValue_Config_Option autoValue_Config_Option = ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS;
        OptionsBundle optionsBundle = (OptionsBundle) mutableConfig;
        optionsBundle.getClass();
        DynamicRange dynamicRange = null;
        try {
            objRetrieveOption = optionsBundle.retrieveOption(autoValue_Config_Option);
        } catch (IllegalArgumentException unused) {
            objRetrieveOption = null;
        }
        List list = (List) objRetrieveOption;
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    supportedResolutions = new ArrayList();
                    break;
                }
                Pair pair = (Pair) it.next();
                if (((Integer) pair.first).equals(34)) {
                    supportedResolutions = Arrays.asList((Size[]) pair.second);
                    break;
                }
            }
        }
        Rational rational = resolutionsMerger.mFallbackAspectRatio;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet3 = new HashSet();
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet3.addAll(resolutionsMerger.getSortedChildSizes((UseCaseConfig) it2.next()));
        }
        Iterator it3 = hashSet3.iterator();
        while (it3.hasNext()) {
            if (!AspectRatioUtil.hasMatchingAspectRatio(rational, (Size) it3.next())) {
                arrayList.addAll(resolutionsMerger.selectParentResolutionsByAspectRatio(resolutionsMerger.mSensorAspectRatio, supportedResolutions, false));
                break;
            }
        }
        arrayList.addAll(resolutionsMerger.selectParentResolutionsByAspectRatio(rational, supportedResolutions, false));
        arrayList.addAll(resolutionsMerger.selectOtherAspectRatioParentResolutionsWithFovPriority(supportedResolutions, false));
        if (arrayList.isEmpty()) {
            Logger.w("ResolutionsMerger", "Failed to find a parent resolution that does not result in double-cropping, this might due to camera not supporting 4:3 and 16:9resolutions or a strict ResolutionSelector settings. Starting resolution selection process with resolutions that might have a smaller FOV.");
            arrayList.addAll(resolutionsMerger.selectOtherAspectRatioParentResolutionsWithFovPriority(supportedResolutions, true));
        }
        Logger.d("ResolutionsMerger", "Parent resolutions: " + arrayList);
        MutableOptionsBundle mutableOptionsBundle = (MutableOptionsBundle) mutableConfig;
        mutableOptionsBundle.insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, arrayList);
        AutoValue_Config_Option autoValue_Config_Option2 = UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY;
        Iterator it4 = hashSet.iterator();
        int iMax = 0;
        while (it4.hasNext()) {
            iMax = Math.max(iMax, ((UseCaseConfig) it4.next()).getSurfaceOccupancyPriority());
        }
        mutableOptionsBundle.insertOption(autoValue_Config_Option2, Integer.valueOf(iMax));
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((UseCaseConfig) it5.next()).getDynamicRange());
        }
        if (!arrayList2.isEmpty()) {
            DynamicRange dynamicRange2 = (DynamicRange) arrayList2.get(0);
            Integer numValueOf = Integer.valueOf(dynamicRange2.mEncoding);
            Integer numValueOf2 = Integer.valueOf(dynamicRange2.mBitDepth);
            int i = 1;
            while (true) {
                if (i >= arrayList2.size()) {
                    dynamicRange = new DynamicRange(numValueOf.intValue(), numValueOf2.intValue());
                    break;
                }
                DynamicRange dynamicRange3 = (DynamicRange) arrayList2.get(i);
                Integer numValueOf3 = Integer.valueOf(dynamicRange3.mEncoding);
                if (numValueOf.equals(0)) {
                    numValueOf = numValueOf3;
                } else if (!numValueOf3.equals(0)) {
                    if (numValueOf.equals(2) && !numValueOf3.equals(1)) {
                        numValueOf = numValueOf3;
                    } else if ((!numValueOf3.equals(2) || numValueOf.equals(1)) && !numValueOf.equals(numValueOf3)) {
                        numValueOf = null;
                    }
                }
                Integer numValueOf4 = Integer.valueOf(dynamicRange3.mBitDepth);
                if (numValueOf2.equals(0)) {
                    numValueOf2 = numValueOf4;
                } else if (!numValueOf4.equals(0) && !numValueOf2.equals(numValueOf4)) {
                    numValueOf2 = null;
                }
                if (numValueOf == null || numValueOf2 == null) {
                    break;
                }
                i++;
            }
        }
        if (dynamicRange == null) {
            throw new IllegalArgumentException("Failed to merge child dynamic ranges, can not find a dynamic range that satisfies all children.");
        }
        mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
        for (UseCase useCase : virtualCameraAdapter.mChildren) {
            if (useCase.mCurrentConfig.getVideoStabilizationMode() != 0) {
                mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(useCase.mCurrentConfig.getVideoStabilizationMode()));
            }
            if (useCase.mCurrentConfig.getPreviewStabilizationMode() != 0) {
                mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(useCase.mCurrentConfig.getPreviewStabilizationMode()));
            }
        }
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public final void onStateAttached() {
        for (UseCase useCase : this.mVirtualCameraAdapter.mChildren) {
            useCase.onStateAttached();
            useCase.onCameraControlReady();
        }
    }

    @Override // androidx.camera.core.UseCase
    public final void onStateDetached() {
        Iterator it = this.mVirtualCameraAdapter.mChildren.iterator();
        while (it.hasNext()) {
            ((UseCase) it.next()).onStateDetached();
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
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(getCameraId(), getSecondaryCamera() == null ? null : getSecondaryCamera().getCameraInfoInternal().getCameraId(), this.mCurrentConfig, autoValue_StreamSpec, autoValue_StreamSpec2));
        notifyActive();
        return autoValue_StreamSpec;
    }

    @Override // androidx.camera.core.UseCase
    public final void onUnbind() {
        clearPipeline$3();
        VirtualCameraAdapter virtualCameraAdapter = this.mVirtualCameraAdapter;
        for (UseCase useCase : virtualCameraAdapter.mChildren) {
            VirtualCamera virtualCamera = (VirtualCamera) virtualCameraAdapter.mChildrenVirtualCameras.get(useCase);
            Objects.requireNonNull(virtualCamera);
            useCase.unbindFromCamera(virtualCamera);
        }
    }

    @Override // androidx.camera.core.UseCase
    public final UseCaseConfig getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        StreamSharingConfig streamSharingConfig = this.mDefaultConfig;
        streamSharingConfig.getClass();
        Config config = useCaseConfigFactory.getConfig(ImageAnalysis$$ExternalSyntheticLambda1.$default$getCaptureType(streamSharingConfig), 1);
        if (z) {
            config = ImageAnalysis$$ExternalSyntheticLambda1.mergeConfigs(config, streamSharingConfig.mConfig);
        }
        if (config == null) {
            return null;
        }
        return ((ImageCapture.Builder) getUseCaseConfigBuilder(config)).getUseCaseConfig();
    }
}
