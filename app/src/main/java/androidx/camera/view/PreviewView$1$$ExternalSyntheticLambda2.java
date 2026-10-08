package androidx.camera.view;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.ZslControlImpl;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.AutoValue_SurfaceRequest_TransformationInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.android.gms.tasks.zzi;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.builders.ListBuilderKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PreviewView$1$$ExternalSyntheticLambda2 implements AsyncFunction, CallbackToFutureAdapter.Resolver, SurfaceRequest.TransformationInfoListener {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ PreviewView$1$$ExternalSyntheticLambda2(PreviewView.AnonymousClass1 anonymousClass1, CameraInternal cameraInternal, SurfaceRequest surfaceRequest) {
        this.f$0 = anonymousClass1;
        this.f$2 = cameraInternal;
        this.f$1 = surfaceRequest;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x014b A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:4:0x0019, B:11:0x002b, B:12:0x003f, B:17:0x0048, B:18:0x004e, B:20:0x0054, B:21:0x006a, B:22:0x00cb, B:24:0x00d1, B:25:0x00e6, B:27:0x00f6, B:29:0x00fa, B:30:0x0106, B:32:0x0123, B:34:0x0135, B:36:0x013d, B:40:0x014b, B:42:0x015d), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x015d A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:4:0x0019, B:11:0x002b, B:12:0x003f, B:17:0x0048, B:18:0x004e, B:20:0x0054, B:21:0x006a, B:22:0x00cb, B:24:0x00d1, B:25:0x00e6, B:27:0x00f6, B:29:0x00fa, B:30:0x0106, B:32:0x0123, B:34:0x0135, B:36:0x013d, B:40:0x014b, B:42:0x015d), top: B:80:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0176  */
    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction, androidx.arch.core.util.Function
    public ListenableFuture apply(Object obj) throws Throwable {
        Object obj2;
        InputConfiguration inputConfiguration;
        int i;
        OutputConfigurationCompat outputConfigurationCompat;
        String str;
        CaptureSession captureSession = (CaptureSession) this.f$0;
        SessionConfig sessionConfig = (SessionConfig) this.f$1;
        CameraDevice cameraDevice = (CameraDevice) this.f$2;
        List list = (List) obj;
        Object obj3 = captureSession.mSessionLock;
        synchronized (obj3) {
            try {
                try {
                    int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(captureSession.mState);
                    if (iOrdinal != 0 && iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            captureSession.mConfiguredSurfaceMap.clear();
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                captureSession.mConfiguredSurfaceMap.put((DeferrableSurface) captureSession.mConfiguredDeferrableSurfaces.get(i2), (Surface) list.get(i2));
                            }
                            captureSession.mState = 4;
                            Logger.d("CaptureSession", "Opening capture session.");
                            CaptureSession.StateCallback stateCallback = new CaptureSession.StateCallback(2, Arrays.asList(captureSession.mCaptureSessionStateCallback, new CaptureSession.StateCallback(1, sessionConfig.mSessionStateCallbacks)));
                            CaptureConfig captureConfig = sessionConfig.mRepeatingCaptureConfig;
                            Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(14, captureConfig.mImplementationOptions);
                            HashSet hashSet = new HashSet();
                            MutableOptionsBundle.create();
                            ArrayList arrayList = new ArrayList();
                            MutableTagBundle.create();
                            hashSet.addAll(captureConfig.mSurfaces);
                            MutableOptionsBundle mutableOptionsBundleFrom = MutableOptionsBundle.from((Config) captureConfig.mImplementationOptions);
                            int i3 = captureConfig.mTemplateType;
                            arrayList.addAll(captureConfig.mCameraCaptureCallbacks);
                            boolean z = captureConfig.mUseRepeatingSurface;
                            TagBundle tagBundle = captureConfig.mTagBundle;
                            ArrayMap arrayMap = new ArrayMap();
                            for (String str2 : tagBundle.mTagMap.keySet()) {
                                arrayMap.put(str2, tagBundle.mTagMap.get(str2));
                            }
                            MutableTagBundle mutableTagBundle = new MutableTagBundle(arrayMap);
                            HashMap map = new HashMap();
                            if (captureSession.mCanUseMultiResolutionImageReader && Build.VERSION.SDK_INT >= 35) {
                                map = CaptureSession.createMultiResolutionOutputConfigurationCompats(CaptureSession.groupMrirOutputConfigs(sessionConfig.mOutputConfigs), captureSession.mConfiguredSurfaceMap);
                            }
                            ArrayList arrayList2 = new ArrayList();
                            String str3 = (String) ((Config) camera2ImplConfig.this$0).retrieveOption(Camera2ImplConfig.SESSION_PHYSICAL_CAMERA_ID_OPTION, null);
                            ArrayList arrayList3 = sessionConfig.mOutputConfigs;
                            int size = arrayList3.size();
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj4 = arrayList3.get(i4);
                                int i5 = i4 + 1;
                                int i6 = size;
                                AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig = (AutoValue_SessionConfig_OutputConfig) obj4;
                                if (captureSession.mCanUseMultiResolutionImageReader) {
                                    i = i3;
                                    outputConfigurationCompat = Build.VERSION.SDK_INT >= 35 ? (OutputConfigurationCompat) map.get(autoValue_SessionConfig_OutputConfig) : null;
                                    if (outputConfigurationCompat == null) {
                                        outputConfigurationCompat = captureSession.getOutputConfigurationCompat(autoValue_SessionConfig_OutputConfig, captureSession.mConfiguredSurfaceMap, str3);
                                        str = str3;
                                        if (captureSession.mStreamUseCaseMap.containsKey(autoValue_SessionConfig_OutputConfig.surface)) {
                                            outputConfigurationCompat.mImpl.setStreamUseCase(((Long) captureSession.mStreamUseCaseMap.get(autoValue_SessionConfig_OutputConfig.surface)).longValue());
                                        }
                                        arrayList2.add(outputConfigurationCompat);
                                        obj3 = obj3;
                                        map = map;
                                        i4 = i5;
                                        size = i6;
                                        i3 = i;
                                        str3 = str;
                                    } else {
                                        str = str3;
                                    }
                                    arrayList2.add(outputConfigurationCompat);
                                    obj3 = obj3;
                                    map = map;
                                    i4 = i5;
                                    size = i6;
                                    i3 = i;
                                    str3 = str;
                                } else {
                                    i = i3;
                                }
                                if (outputConfigurationCompat == null) {
                                    outputConfigurationCompat = captureSession.getOutputConfigurationCompat(autoValue_SessionConfig_OutputConfig, captureSession.mConfiguredSurfaceMap, str3);
                                    str = str3;
                                    if (captureSession.mStreamUseCaseMap.containsKey(autoValue_SessionConfig_OutputConfig.surface)) {
                                        outputConfigurationCompat.mImpl.setStreamUseCase(((Long) captureSession.mStreamUseCaseMap.get(autoValue_SessionConfig_OutputConfig.surface)).longValue());
                                    }
                                    arrayList2.add(outputConfigurationCompat);
                                    obj3 = obj3;
                                    map = map;
                                    i4 = i5;
                                    size = i6;
                                    i3 = i;
                                    str3 = str;
                                } else {
                                    str = str3;
                                }
                                arrayList2.add(outputConfigurationCompat);
                                obj3 = obj3;
                                map = map;
                                i4 = i5;
                                size = i6;
                                i3 = i;
                                str3 = str;
                            }
                            obj2 = obj3;
                            int i7 = i3;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = new ArrayList();
                            int size2 = arrayList2.size();
                            int i8 = 0;
                            while (i8 < size2) {
                                Object obj5 = arrayList2.get(i8);
                                i8++;
                                OutputConfigurationCompat outputConfigurationCompat2 = (OutputConfigurationCompat) obj5;
                                if (!arrayList4.contains(outputConfigurationCompat2.mImpl.getSurface())) {
                                    arrayList4.add(outputConfigurationCompat2.mImpl.getSurface());
                                    arrayList5.add(outputConfigurationCompat2);
                                }
                            }
                            SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = captureSession.mSessionOpener;
                            synchronizedCaptureSessionImpl.mCaptureSessionStateCallback = stateCallback;
                            SessionConfigurationCompat sessionConfigurationCompat = new SessionConfigurationCompat(arrayList5, synchronizedCaptureSessionImpl.mExecutor, new ZslControlImpl.AnonymousClass1(2, synchronizedCaptureSessionImpl));
                            if (sessionConfig.mRepeatingCaptureConfig.mTemplateType == 5 && (inputConfiguration = sessionConfig.mInputConfiguration) != null) {
                                sessionConfigurationCompat.mImpl.setInputConfiguration(InputConfigurationCompat.wrap(inputConfiguration));
                            }
                            try {
                                ArrayList arrayList6 = new ArrayList(hashSet);
                                OptionsBundle optionsBundleFrom = OptionsBundle.from(mutableOptionsBundleFrom);
                                ArrayList arrayList7 = new ArrayList(arrayList);
                                TagBundle tagBundle2 = TagBundle.EMPTY_TAGBUNDLE;
                                ArrayMap arrayMap2 = new ArrayMap();
                                for (String str4 : mutableTagBundle.mTagMap.keySet()) {
                                    arrayMap2.put(str4, mutableTagBundle.mTagMap.get(str4));
                                }
                                CaptureRequest captureRequestBuildWithoutTarget = ListBuilderKt.buildWithoutTarget(new CaptureConfig(arrayList6, optionsBundleFrom, i7, arrayList7, z, new TagBundle(arrayMap2), null), cameraDevice, captureSession.mTemplateParamsOverride);
                                if (captureRequestBuildWithoutTarget != null) {
                                    sessionConfigurationCompat.mImpl.setSessionParameters(captureRequestBuildWithoutTarget);
                                }
                                ListenableFuture listenableFutureOpenCaptureSession = captureSession.mSessionOpener.openCaptureSession(cameraDevice, sessionConfigurationCompat, captureSession.mConfiguredDeferrableSurfaces);
                                return listenableFutureOpenCaptureSession;
                            } catch (CameraAccessException e) {
                                return new ImmediateFuture$ImmediateFailedFuture(0, e);
                            }
                        }
                        if (iOrdinal != 4) {
                            return new ImmediateFuture$ImmediateFailedFuture(0, new CancellationException("openCaptureSession() not execute in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(captureSession.mState))));
                        }
                    }
                    return new ImmediateFuture$ImmediateFailedFuture(0, new IllegalStateException("openCaptureSession() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(captureSession.mState))));
                } catch (Throwable th) {
                    th = th;
                    obj2 = obj3;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        CallbackToFutureAdapter.SafeFuture safeFuture = (CallbackToFutureAdapter.SafeFuture) this.f$0;
        SequentialExecutor sequentialExecutor = (SequentialExecutor) this.f$1;
        ArrayList arrayList = (ArrayList) this.f$2;
        Preview$$ExternalSyntheticLambda0 preview$$ExternalSyntheticLambda0 = new Preview$$ExternalSyntheticLambda0(15, safeFuture);
        ResolvableFuture resolvableFuture = completer.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(preview$$ExternalSyntheticLambda0, sequentialExecutor);
        }
        safeFuture.addListener(new zzi(1, safeFuture, new PreviewView.AnonymousClass1(17, completer)), sequentialExecutor);
        return "surfaceList[" + arrayList + "]";
    }

    public void onSurfaceNotInUse() {
        PreviewView.AnonymousClass1 anonymousClass1 = (PreviewView.AnonymousClass1) this.f$0;
        ZoomControl zoomControl = (ZoomControl) this.f$1;
        CameraInternal cameraInternal = (CameraInternal) this.f$2;
        AtomicReference atomicReference = ((PreviewView) anonymousClass1.this$0).mActiveStreamStateObserver;
        do {
            if (atomicReference.compareAndSet(zoomControl, null)) {
                zoomControl.updatePreviewStreamState(PreviewView.StreamState.IDLE);
                break;
            }
        } while (atomicReference.get() == zoomControl);
        FutureChain futureChain = (FutureChain) zoomControl.mCaptureResultListener;
        if (futureChain != null) {
            futureChain.cancel(false);
            zoomControl.mCaptureResultListener = null;
        }
        cameraInternal.getCameraState().removeObserver(zoomControl);
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
    public void onTransformationInfoUpdate(AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo) {
        PreviewViewImplementation previewViewImplementation;
        PreviewView.AnonymousClass1 anonymousClass1 = (PreviewView.AnonymousClass1) this.f$0;
        CameraInternal cameraInternal = (CameraInternal) this.f$2;
        SurfaceRequest surfaceRequest = (SurfaceRequest) this.f$1;
        PreviewView previewView = (PreviewView) anonymousClass1.this$0;
        Logger.d("PreviewView", "Preview transformation info updated. " + autoValue_SurfaceRequest_TransformationInfo);
        boolean z = cameraInternal.getCameraInfoInternal().getLensFacing() == 0;
        PreviewTransformation previewTransformation = previewView.mPreviewTransform;
        Size size = surfaceRequest.mResolution;
        previewTransformation.getClass();
        Logger.d("PreviewTransform", "Transformation info set: " + autoValue_SurfaceRequest_TransformationInfo + " " + size + " " + z);
        previewTransformation.mSurfaceCropRect = autoValue_SurfaceRequest_TransformationInfo.getCropRect;
        previewTransformation.mPreviewRotationDegrees = autoValue_SurfaceRequest_TransformationInfo.getRotationDegrees;
        int i = autoValue_SurfaceRequest_TransformationInfo.getTargetRotation;
        previewTransformation.mTargetRotation = i;
        previewTransformation.mResolution = size;
        previewTransformation.mIsFrontCamera = z;
        previewTransformation.mHasCameraTransform = autoValue_SurfaceRequest_TransformationInfo.hasCameraTransform;
        previewTransformation.mSensorToBufferTransform = autoValue_SurfaceRequest_TransformationInfo.getSensorToBufferTransform;
        if (i == -1 || ((previewViewImplementation = previewView.mImplementation) != null && (previewViewImplementation instanceof SurfaceViewImplementation))) {
            previewView.mUseDisplayRotation = true;
        } else {
            previewView.mUseDisplayRotation = false;
        }
        previewView.redrawPreview();
    }

    public /* synthetic */ PreviewView$1$$ExternalSyntheticLambda2(Object obj, Object obj2, Object obj3) {
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
