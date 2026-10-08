package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.view.Surface;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat$DynamicRangeProfilesCompatImpl;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.SurfaceUtil;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import coil.intercept.RealInterceptorChain;
import coil.util.ImmutableHardwareBitmapService;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import com.google.android.gms.tasks.zzi;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.builders.ListBuilderKt;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.json.internal.Composer;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CaptureSession {
    public final boolean mCanUseMultiResolutionImageReader;
    public final Toolbar.AnonymousClass1 mDynamicRangesCompat;
    public CallbackToFutureAdapter.Completer mReleaseCompleter;
    public CallbackToFutureAdapter.SafeFuture mReleaseFuture;
    public final Composer mRequestMonitor;
    public SessionConfig mSessionConfig;
    public SynchronizedCaptureSessionImpl mSessionOpener;
    public int mState;
    public SynchronizedCaptureSessionImpl mSynchronizedCaptureSession;
    public final FlowLayoutBuildingBlocks.WrapInfo mTemplateParamsOverride;
    public final Object mSessionLock = new Object();
    public final ArrayList mCaptureConfigs = new ArrayList();
    public final HashMap mConfiguredSurfaceMap = new HashMap();
    public List mConfiguredDeferrableSurfaces = Collections.EMPTY_LIST;
    public HashMap mStreamUseCaseMap = new HashMap();
    public final ImmutableHardwareBitmapService mStillCaptureFlow = new ImmutableHardwareBitmapService(2);
    public final ImmutableHardwareBitmapService mTorchStateReset = new ImmutableHardwareBitmapService(3);
    public final StateCallback mCaptureSessionStateCallback = new StateCallback(this);

    public CaptureSession(Toolbar.AnonymousClass1 anonymousClass1, Quirks quirks, boolean z) {
        this.mState = 1;
        this.mState = 2;
        this.mDynamicRangesCompat = anonymousClass1;
        this.mRequestMonitor = new Composer(quirks.contains(CaptureNoResponseQuirk.class));
        this.mTemplateParamsOverride = new FlowLayoutBuildingBlocks.WrapInfo(quirks, 2);
        this.mCanUseMultiResolutionImageReader = z;
    }

    public static AnonymousClass2 createCamera2CaptureCallback(List list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        CameraCaptureSession.CaptureCallback anonymousClass2;
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback) it.next();
            if (cameraCaptureCallback == null) {
                anonymousClass2 = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                zzga.toCaptureCallback(cameraCaptureCallback, arrayList2);
                anonymousClass2 = arrayList2.size() == 1 ? (CameraCaptureSession.CaptureCallback) arrayList2.get(0) : new AnonymousClass2(arrayList2);
            }
            arrayList.add(anonymousClass2);
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return new AnonymousClass2(arrayList);
    }

    public static HashMap createMultiResolutionOutputConfigurationCompats(HashMap map, HashMap map2) {
        HashMap map3 = new HashMap();
        for (Integer num : map.keySet()) {
            num.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) map.get(num)).iterator();
            if (it.hasNext()) {
                SurfaceUtil.getSurfaceInfo((Surface) map2.get(((AutoValue_SessionConfig_OutputConfig) it.next()).surface));
                CaptureSession$$ExternalSyntheticApiModelOutline0.m15m();
                throw null;
            }
            Logger.e("CaptureSession", "Skips to create instances for multi-resolution output. imageFormat: 0, streamInfos size: " + arrayList.size());
        }
        return map3;
    }

    public static HashMap groupMrirOutputConfigs(ArrayList arrayList) {
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig = (AutoValue_SessionConfig_OutputConfig) obj;
            int i2 = autoValue_SessionConfig_OutputConfig.surfaceGroupId;
            if (i2 > 0 && autoValue_SessionConfig_OutputConfig.sharedSurfaces.isEmpty()) {
                List arrayList2 = (List) map.get(Integer.valueOf(i2));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(Integer.valueOf(i2), arrayList2);
                }
                arrayList2.add(autoValue_SessionConfig_OutputConfig);
            }
        }
        HashMap map2 = new HashMap();
        for (Integer num : map.keySet()) {
            num.getClass();
            if (((List) map.get(num)).size() >= 2) {
                map2.put(num, (List) map.get(num));
            }
        }
        return map2;
    }

    public final void close() {
        synchronized (this.mSessionLock) {
            try {
                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mState);
                if (iOrdinal == 0) {
                    throw new IllegalStateException("close() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                }
                if (iOrdinal == 1) {
                    this.mState = 8;
                } else if (iOrdinal == 2) {
                    Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                    this.mSessionOpener.stop();
                    this.mState = 8;
                } else if (iOrdinal == 3 || iOrdinal == 4) {
                    Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                    this.mSessionOpener.stop();
                    this.mState = 6;
                    this.mRequestMonitor.stop();
                    this.mSessionConfig = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finishClose() {
        if (this.mState == 8) {
            Logger.d("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.mState = 8;
        this.mSynchronizedCaptureSession = null;
        CallbackToFutureAdapter.Completer completer = this.mReleaseCompleter;
        if (completer != null) {
            completer.set(null);
            this.mReleaseCompleter = null;
        }
    }

    public final List getCaptureConfigs() {
        List listUnmodifiableList;
        synchronized (this.mSessionLock) {
            listUnmodifiableList = Collections.unmodifiableList(this.mCaptureConfigs);
        }
        return listUnmodifiableList;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0096  */
    public final OutputConfigurationCompat getOutputConfigurationCompat(AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig, HashMap map, String str) {
        long jLongValue;
        DeferrableSurface deferrableSurface = autoValue_SessionConfig_OutputConfig.surface;
        List list = autoValue_SessionConfig_OutputConfig.sharedSurfaces;
        Surface surface = (Surface) map.get(deferrableSurface);
        Preconditions.checkNotNull(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        OutputConfigurationCompat outputConfigurationCompat = new OutputConfigurationCompat(autoValue_SessionConfig_OutputConfig.surfaceGroupId, surface);
        OutputConfigurationCompatBaseImpl outputConfigurationCompatBaseImpl = outputConfigurationCompat.mImpl;
        if (str != null) {
            outputConfigurationCompatBaseImpl.setPhysicalCameraId(str);
        } else {
            outputConfigurationCompatBaseImpl.setPhysicalCameraId(null);
        }
        int i = autoValue_SessionConfig_OutputConfig.mirrorMode;
        if (i == 0) {
            outputConfigurationCompatBaseImpl.setMirrorMode(1);
        } else if (i == 1) {
            outputConfigurationCompatBaseImpl.setMirrorMode(2);
        }
        if (!list.isEmpty()) {
            outputConfigurationCompatBaseImpl.enableSurfaceSharing();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Surface surface2 = (Surface) map.get((DeferrableSurface) it.next());
                Preconditions.checkNotNull(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                outputConfigurationCompatBaseImpl.addSurface(surface2);
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            Toolbar.AnonymousClass1 anonymousClass1 = this.mDynamicRangesCompat;
            anonymousClass1.getClass();
            Preconditions.checkState("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", i2 >= 33);
            DynamicRangeProfiles dynamicRangeProfilesUnwrap = ((DynamicRangesCompat$DynamicRangeProfilesCompatImpl) anonymousClass1.this$0).unwrap();
            if (dynamicRangeProfilesUnwrap == null) {
                jLongValue = 1;
            } else {
                DynamicRange dynamicRange = autoValue_SessionConfig_OutputConfig.dynamicRange;
                Long lDynamicRangeToFirstSupportedProfile = DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(dynamicRange, dynamicRangeProfilesUnwrap);
                if (lDynamicRangeToFirstSupportedProfile == null) {
                    Logger.e("CaptureSession", "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + dynamicRange);
                    jLongValue = 1;
                } else {
                    jLongValue = lDynamicRangeToFirstSupportedProfile.longValue();
                }
            }
        } else {
            jLongValue = 1;
        }
        outputConfigurationCompatBaseImpl.setDynamicRangeProfile(jLongValue);
        return outputConfigurationCompat;
    }

    public final boolean isInOpenState() {
        boolean z;
        synchronized (this.mSessionLock) {
            int i = this.mState;
            z = i == 5 || i == 4;
        }
        return z;
    }

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
    public final void issueBurstCaptureRequest(ArrayList arrayList) {
        CameraCaptureResult cameraCaptureResult;
        synchronized (this.mSessionLock) {
            try {
                if (this.mState != 5) {
                    Logger.d("CaptureSession", "Skipping issueBurstCaptureRequest due to session closed");
                    return;
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                try {
                    CameraBurstCaptureCallback cameraBurstCaptureCallback = new CameraBurstCaptureCallback(0);
                    ArrayList arrayList2 = new ArrayList();
                    Logger.d("CaptureSession", "Issuing capture request.");
                    int size = arrayList.size();
                    boolean z = false;
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        CaptureConfig captureConfig = (CaptureConfig) obj;
                        if (!Collections.unmodifiableList(captureConfig.mSurfaces).isEmpty()) {
                            Iterator it = Collections.unmodifiableList(captureConfig.mSurfaces).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    if (captureConfig.mTemplateType == 2) {
                                        z = true;
                                    }
                                    RealInterceptorChain realInterceptorChain = new RealInterceptorChain(captureConfig);
                                    if (captureConfig.mTemplateType == 5 && (cameraCaptureResult = captureConfig.mCameraCaptureResult) != null) {
                                        realInterceptorChain.eventListener = cameraCaptureResult;
                                    }
                                    SessionConfig sessionConfig = this.mSessionConfig;
                                    if (sessionConfig != null) {
                                        realInterceptorChain.addImplementationOptions(sessionConfig.mRepeatingCaptureConfig.mImplementationOptions);
                                    }
                                    realInterceptorChain.addImplementationOptions(captureConfig.mImplementationOptions);
                                    CaptureConfig captureConfigBuild = realInterceptorChain.build();
                                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.mSynchronizedCaptureSession;
                                    synchronizedCaptureSessionImpl.mCameraCaptureSessionCompat.getClass();
                                    CaptureRequest captureRequestBuild = ListBuilderKt.build(captureConfigBuild, ((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.mCameraCaptureSessionCompat.this$0).val$requestCancellationCompleter).getDevice(), this.mConfiguredSurfaceMap, false, this.mTemplateParamsOverride);
                                    if (captureRequestBuild != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        Iterator it2 = captureConfig.mCameraCaptureCallbacks.iterator();
                                        while (it2.hasNext()) {
                                            zzga.toCaptureCallback((CameraCaptureCallback) it2.next(), arrayList3);
                                        }
                                        cameraBurstCaptureCallback.addCamera2Callbacks(captureRequestBuild, arrayList3);
                                        arrayList2.add(captureRequestBuild);
                                        break;
                                    }
                                    Logger.d("CaptureSession", "Skipping issuing request without surface.");
                                    return;
                                }
                                DeferrableSurface deferrableSurface = (DeferrableSurface) it.next();
                                if (!this.mConfiguredSurfaceMap.containsKey(deferrableSurface)) {
                                    Logger.d("CaptureSession", "Skipping capture request with invalid surface: " + deferrableSurface);
                                    break;
                                }
                            }
                        } else {
                            Logger.d("CaptureSession", "Skipping issuing empty capture request.");
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        Logger.d("CaptureSession", "Skipping issuing burst request due to no valid request elements");
                        return;
                    }
                    if (this.mStillCaptureFlow.shouldStopRepeatingBeforeCapture(arrayList2, z)) {
                        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = this.mSynchronizedCaptureSession;
                        Preconditions.checkNotNull(synchronizedCaptureSessionImpl2.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
                        ((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl2.mCameraCaptureSessionCompat.this$0).val$requestCancellationCompleter).stopRepeating();
                        cameraBurstCaptureCallback.mCaptureSequenceCallback = new CaptureSession$$ExternalSyntheticLambda4(this);
                    }
                    if (this.mTorchStateReset.isTorchResetRequired(arrayList2, z)) {
                        cameraBurstCaptureCallback.addCamera2Callbacks((CaptureRequest) arrayList2.get(arrayList2.size() - 1), Collections.singletonList(new AnonymousClass2(this)));
                    }
                    this.mSynchronizedCaptureSession.captureBurstRequests(arrayList2, cameraBurstCaptureCallback);
                } catch (CameraAccessException e) {
                    Logger.e("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void issueCaptureRequests(List list) {
        synchronized (this.mSessionLock) {
            try {
                switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mState)) {
                    case 0:
                        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                    case 1:
                    case 2:
                    case 3:
                        this.mCaptureConfigs.addAll(list);
                        break;
                    case 4:
                        this.mCaptureConfigs.addAll(list);
                        this.mRequestMonitor.getRequestsProcessedFuture().addListener(new Preview$$ExternalSyntheticLambda0(6, this), HexFormatKt.directExecutor());
                        break;
                    case 5:
                    case 6:
                    case 7:
                        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void issueRepeatingCaptureRequests(SessionConfig sessionConfig) {
        synchronized (this.mSessionLock) {
            try {
                if (sessionConfig == null) {
                    Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                    return;
                }
                if (this.mState != 5) {
                    Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests due to session closed");
                    return;
                }
                CaptureConfig captureConfig = sessionConfig.mRepeatingCaptureConfig;
                if (Collections.unmodifiableList(captureConfig.mSurfaces).isEmpty()) {
                    Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                    try {
                        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.mSynchronizedCaptureSession;
                        Preconditions.checkNotNull(synchronizedCaptureSessionImpl.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
                        ((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.mCameraCaptureSessionCompat.this$0).val$requestCancellationCompleter).stopRepeating();
                    } catch (CameraAccessException e) {
                        Logger.e("CaptureSession", "Unable to access camera: " + e.getMessage());
                        Thread.dumpStack();
                    }
                    return;
                }
                try {
                    Logger.d("CaptureSession", "Issuing request for session.");
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = this.mSynchronizedCaptureSession;
                    synchronizedCaptureSessionImpl2.mCameraCaptureSessionCompat.getClass();
                    CaptureRequest captureRequestBuild = ListBuilderKt.build(captureConfig, ((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl2.mCameraCaptureSessionCompat.this$0).val$requestCancellationCompleter).getDevice(), this.mConfiguredSurfaceMap, true, this.mTemplateParamsOverride);
                    if (captureRequestBuild == null) {
                        Logger.d("CaptureSession", "Skipping issuing empty request for session.");
                        return;
                    } else {
                        this.mSynchronizedCaptureSession.setSingleRepeatingRequest(captureRequestBuild, this.mRequestMonitor.createMonitorListener(createCamera2CaptureCallback(captureConfig.mCameraCaptureCallbacks, new CameraCaptureSession.CaptureCallback[0])));
                        return;
                    }
                } catch (CameraAccessException e2) {
                    Logger.e("CaptureSession", "Unable to access camera: " + e2.getMessage());
                    Thread.dumpStack();
                    return;
                }
                throw th;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ListenableFuture open(SessionConfig sessionConfig, CameraDevice cameraDevice, SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        synchronized (this.mSessionLock) {
            try {
                if (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mState) != 1) {
                    Logger.e("CaptureSession", "Open not allowed in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                    return new ImmediateFuture$ImmediateFailedFuture(0, new IllegalStateException("open() should not allow the state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState))));
                }
                this.mState = 3;
                ArrayList arrayList = new ArrayList(sessionConfig.getSurfaces());
                this.mConfiguredDeferrableSurfaces = arrayList;
                this.mSessionOpener = synchronizedCaptureSessionImpl;
                ChainingListenableFuture chainingListenableFutureTransformAsync = Futures.transformAsync(FutureChain.from(synchronizedCaptureSessionImpl.startWithDeferrableSurface(arrayList)), new PreviewView$1$$ExternalSyntheticLambda2(this, sessionConfig, cameraDevice), this.mSessionOpener.mExecutor);
                PreviewView.AnonymousClass1 anonymousClass1 = new PreviewView.AnonymousClass1(7, this);
                chainingListenableFutureTransformAsync.addListener(new zzi(1, chainingListenableFutureTransformAsync, anonymousClass1), this.mSessionOpener.mExecutor);
                return Futures.nonCancellationPropagating(chainingListenableFutureTransformAsync);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ListenableFuture release() {
        synchronized (this.mSessionLock) {
            try {
                switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mState)) {
                    case 0:
                        throw new IllegalStateException("release() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                    case 2:
                        Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                        this.mSessionOpener.stop();
                    case 1:
                        this.mState = 8;
                        return ImmediateFuture$ImmediateFailedFuture.NULL_FUTURE;
                    case 4:
                    case 5:
                        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.mSynchronizedCaptureSession;
                        if (synchronizedCaptureSessionImpl != null) {
                            synchronizedCaptureSessionImpl.close();
                            break;
                        }
                    case 3:
                        this.mState = 7;
                        this.mRequestMonitor.stop();
                        Preconditions.checkNotNull(this.mSessionOpener, "The Opener shouldn't null in state:".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                        if (this.mSessionOpener.stop()) {
                            finishClose();
                            return ImmediateFuture$ImmediateFailedFuture.NULL_FUTURE;
                        }
                    case 6:
                        if (this.mReleaseFuture == null) {
                            this.mReleaseFuture = CallbackToFutureAdapter.getFuture(new CaptureSession$$ExternalSyntheticLambda4(this));
                        }
                        return this.mReleaseFuture;
                    default:
                        return ImmediateFuture$ImmediateFailedFuture.NULL_FUTURE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setSessionConfig(SessionConfig sessionConfig) {
        synchronized (this.mSessionLock) {
            try {
                switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mState)) {
                    case 0:
                        throw new IllegalStateException("setSessionConfig() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(this.mState)));
                    case 1:
                    case 2:
                    case 3:
                        this.mSessionConfig = sessionConfig;
                        break;
                    case 4:
                        this.mSessionConfig = sessionConfig;
                        if (sessionConfig == null) {
                            return;
                        }
                        if (!this.mConfiguredSurfaceMap.keySet().containsAll(sessionConfig.getSurfaces())) {
                            Logger.e("CaptureSession", "Does not have the proper configured lists");
                            return;
                        } else {
                            Logger.d("CaptureSession", "Attempting to submit CaptureRequest after setting");
                            issueRepeatingCaptureRequests(this.mSessionConfig);
                        }
                        break;
                    case 5:
                    case 6:
                    case 7:
                        throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.CaptureSession$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends CameraCaptureSession.CaptureCallback {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;

        public AnonymousClass2(CameraCaptureCallback cameraCaptureCallback) {
            this.$r8$classId = 2;
            if (cameraCaptureCallback == null) {
                throw new NullPointerException("cameraCaptureCallback is null");
            }
            this.this$0 = cameraCaptureCallback;
        }

        public static int getCaptureConfigId(CaptureRequest captureRequest) {
            Integer num;
            if ((captureRequest.getTag() instanceof TagBundle) && (num = (Integer) ((TagBundle) captureRequest.getTag()).mTagMap.get("CAPTURE_CONFIG_ID_KEY")) != null) {
                return num.intValue();
            }
            return -1;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        ((CameraCaptureSession.CaptureCallback) arrayList.get(i)).onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                    }
                    break;
                default:
                    super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            TagBundle tagBundle;
            switch (this.$r8$classId) {
                case 0:
                    synchronized (((CaptureSession) this.this$0).mSessionLock) {
                        try {
                            SessionConfig sessionConfig = ((CaptureSession) this.this$0).mSessionConfig;
                            if (sessionConfig == null) {
                                return;
                            }
                            CaptureConfig captureConfig = sessionConfig.mRepeatingCaptureConfig;
                            Logger.d("CaptureSession", "Submit FLASH_MODE_OFF request");
                            CaptureSession captureSession = (CaptureSession) this.this$0;
                            captureSession.mTorchStateReset.getClass();
                            captureSession.issueCaptureRequests(Collections.singletonList(ImmutableHardwareBitmapService.createTorchResetRequest(captureConfig)));
                            return;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.CaptureCallback) obj).onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                    }
                    return;
                default:
                    super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                    Object tag = captureRequest.getTag();
                    if (tag != null) {
                        Preconditions.checkArgument("The tagBundle object from the CaptureResult is not a TagBundle object.", tag instanceof TagBundle);
                        tagBundle = (TagBundle) tag;
                    } else {
                        tagBundle = TagBundle.EMPTY_TAGBUNDLE;
                    }
                    ((CameraCaptureCallback) this.this$0).onCaptureCompleted(getCaptureConfigId(captureRequest), new SurfaceRequest.AnonymousClass1(2, tagBundle, totalCaptureResult, false));
                    return;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.CaptureCallback) obj).onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                    }
                    break;
                case 2:
                    super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                    ((CameraCaptureCallback) this.this$0).onCaptureFailed(getCaptureConfigId(captureRequest), new Path.Companion());
                    break;
                default:
                    super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.CaptureCallback) obj).onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                    }
                    break;
                default:
                    super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((CameraCaptureSession.CaptureCallback) obj).onCaptureSequenceAborted(cameraCaptureSession, i);
                    }
                    break;
                default:
                    super.onCaptureSequenceAborted(cameraCaptureSession, i);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((CameraCaptureSession.CaptureCallback) obj).onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                    }
                    break;
                default:
                    super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.CaptureCallback) obj).onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                    }
                    break;
                case 2:
                    super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                    ((CameraCaptureCallback) this.this$0).onCaptureStarted(getCaptureConfigId(captureRequest));
                    break;
                default:
                    super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                    break;
            }
        }

        public AnonymousClass2(List list) {
            this.$r8$classId = 1;
            this.this$0 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback) it.next();
                if (!(captureCallback instanceof Camera2CaptureCallbacks$NoOpSessionCaptureCallback)) {
                    ((ArrayList) this.this$0).add(captureCallback);
                }
            }
        }

        public AnonymousClass2(CaptureSession captureSession) {
            this.$r8$classId = 0;
            this.this$0 = captureSession;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class StateCallback extends SynchronizedCaptureSession$StateCallback {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;

        public StateCallback(int i, List list) {
            this.$r8$classId = i;
            switch (i) {
                case 2:
                    ArrayList arrayList = new ArrayList();
                    this.this$0 = arrayList;
                    arrayList.addAll(list);
                    break;
                default:
                    this.this$0 = list.isEmpty() ? new CameraCaptureSessionStateCallbacks$NoOpSessionStateCallback() : list.size() == 1 ? (CameraCaptureSession.StateCallback) list.get(0) : new ZslControlImpl.AnonymousClass1(list);
                    break;
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
        public void onActive(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            switch (this.$r8$classId) {
                case 1:
                    ((CameraCaptureSession.StateCallback) this.this$0).onActive((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.toCameraCaptureSessionCompat().this$0).val$requestCancellationCompleter);
                    break;
                case 2:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((SynchronizedCaptureSession$StateCallback) obj).onActive(synchronizedCaptureSessionImpl);
                    }
                    break;
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
        public void onCaptureQueueEmpty(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            switch (this.$r8$classId) {
                case 1:
                    ((CameraCaptureSession.StateCallback) this.this$0).onCaptureQueueEmpty((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.toCameraCaptureSessionCompat().this$0).val$requestCancellationCompleter);
                    break;
                case 2:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((SynchronizedCaptureSession$StateCallback) obj).onCaptureQueueEmpty(synchronizedCaptureSessionImpl);
                    }
                    break;
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
        public void onClosed(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            switch (this.$r8$classId) {
                case 1:
                    ((CameraCaptureSession.StateCallback) this.this$0).onClosed((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.toCameraCaptureSessionCompat().this$0).val$requestCancellationCompleter);
                    break;
                case 2:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((SynchronizedCaptureSession$StateCallback) obj).onClosed(synchronizedCaptureSessionImpl);
                    }
                    break;
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
        public final void onConfigureFailed(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            switch (this.$r8$classId) {
                case 0:
                    synchronized (((CaptureSession) this.this$0).mSessionLock) {
                        try {
                            switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(((CaptureSession) this.this$0).mState)) {
                                case 0:
                                case 1:
                                case 2:
                                case 4:
                                    throw new IllegalStateException("onConfigureFailed() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(((CaptureSession) this.this$0).mState)));
                                case 3:
                                case 5:
                                case 6:
                                    ((CaptureSession) this.this$0).finishClose();
                                    break;
                                case 7:
                                    Logger.d("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                                    break;
                            }
                            Logger.e("CaptureSession", "CameraCaptureSession.onConfigureFailed() ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(((CaptureSession) this.this$0).mState)));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                case 1:
                    ((CameraCaptureSession.StateCallback) this.this$0).onConfigureFailed((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.toCameraCaptureSessionCompat().this$0).val$requestCancellationCompleter);
                    return;
                default:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((SynchronizedCaptureSession$StateCallback) obj).onConfigureFailed(synchronizedCaptureSessionImpl);
                    }
                    return;
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
        public final void onConfigured(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            switch (this.$r8$classId) {
                case 0:
                    synchronized (((CaptureSession) this.this$0).mSessionLock) {
                        try {
                            switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(((CaptureSession) this.this$0).mState)) {
                                case 0:
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                    throw new IllegalStateException("onConfigured() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(((CaptureSession) this.this$0).mState)));
                                case 3:
                                    CaptureSession captureSession = (CaptureSession) this.this$0;
                                    captureSession.mState = 5;
                                    captureSession.mSynchronizedCaptureSession = synchronizedCaptureSessionImpl;
                                    Logger.d("CaptureSession", "Attempting to send capture request onConfigured");
                                    CaptureSession captureSession2 = (CaptureSession) this.this$0;
                                    captureSession2.issueRepeatingCaptureRequests(captureSession2.mSessionConfig);
                                    CaptureSession captureSession3 = (CaptureSession) this.this$0;
                                    captureSession3.mRequestMonitor.getRequestsProcessedFuture().addListener(new Preview$$ExternalSyntheticLambda0(6, captureSession3), HexFormatKt.directExecutor());
                                    break;
                                case 5:
                                    ((CaptureSession) this.this$0).mSynchronizedCaptureSession = synchronizedCaptureSessionImpl;
                                    break;
                                case 6:
                                    synchronizedCaptureSessionImpl.close();
                                    break;
                            }
                            Logger.d("CaptureSession", "CameraCaptureSession.onConfigured() mState=".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(((CaptureSession) this.this$0).mState)));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                case 1:
                    ((CameraCaptureSession.StateCallback) this.this$0).onConfigured((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.toCameraCaptureSessionCompat().this$0).val$requestCancellationCompleter);
                    return;
                default:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((SynchronizedCaptureSession$StateCallback) obj).onConfigured(synchronizedCaptureSessionImpl);
                    }
                    return;
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
        public final void onReady(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            switch (this.$r8$classId) {
                case 0:
                    synchronized (((CaptureSession) this.this$0).mSessionLock) {
                        try {
                            if (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(((CaptureSession) this.this$0).mState) == 0) {
                                throw new IllegalStateException("onReady() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(((CaptureSession) this.this$0).mState)));
                            }
                            Logger.d("CaptureSession", "CameraCaptureSession.onReady() ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(((CaptureSession) this.this$0).mState)));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                case 1:
                    ((CameraCaptureSession.StateCallback) this.this$0).onReady((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.toCameraCaptureSessionCompat().this$0).val$requestCancellationCompleter);
                    return;
                default:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((SynchronizedCaptureSession$StateCallback) obj).onReady(synchronizedCaptureSessionImpl);
                    }
                    return;
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
        public final void onSessionFinished(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            switch (this.$r8$classId) {
                case 0:
                    synchronized (((CaptureSession) this.this$0).mSessionLock) {
                        try {
                            if (((CaptureSession) this.this$0).mState == 1) {
                                throw new IllegalStateException("onSessionFinished() should not be possible in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(((CaptureSession) this.this$0).mState)));
                            }
                            Logger.d("CaptureSession", "onSessionFinished()");
                            ((CaptureSession) this.this$0).finishClose();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                case 1:
                    return;
                default:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((SynchronizedCaptureSession$StateCallback) obj).onSessionFinished(synchronizedCaptureSessionImpl);
                    }
                    return;
            }
        }

        @Override // androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback
        public void onSurfacePrepared(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, Surface surface) {
            switch (this.$r8$classId) {
                case 1:
                    ((CameraCaptureSession.StateCallback) this.this$0).onSurfacePrepared((CameraCaptureSession) ((SurfaceRequest.AnonymousClass1) synchronizedCaptureSessionImpl.toCameraCaptureSessionCompat().this$0).val$requestCancellationCompleter, surface);
                    break;
                case 2:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((SynchronizedCaptureSession$StateCallback) obj).onSurfacePrepared(synchronizedCaptureSessionImpl, surface);
                    }
                    break;
            }
        }

        public StateCallback(CaptureSession captureSession) {
            this.$r8$classId = 0;
            this.this$0 = captureSession;
        }

        private final void onSessionFinished$androidx$camera$camera2$internal$SynchronizedCaptureSessionStateCallbacks$Adapter(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        }
    }
}
