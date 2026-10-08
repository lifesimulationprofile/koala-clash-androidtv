package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.camera2.internal.compat.workaround.SupportedRepeatingSurfaceSize;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.AutoValue_CameraState_StateError;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.AutoValue_AttachedSurfaceInfo;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.AutoValue_SurfaceConfig;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.LiveDataObservable$Result;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.Futures$$ExternalSyntheticLambda3;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.core.VectorizedInfiniteRepeatableSpec;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.MutableLiveData;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import androidx.room.DatabaseConfiguration;
import androidx.tracing.Trace;
import coil.network.EmptyNetworkObserver;
import com.google.android.gms.tasks.zzi;
import com.google.common.util.concurrent.ListenableFuture;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.text.HexFormatKt;
import okhttp3.Request;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraImpl implements CameraInternal {
    public final CameraAvailability mCameraAvailability;
    public Toolbar.AnonymousClass1 mCameraConfig;
    public final Camera2CameraControlImpl mCameraControlInternal;
    public final DatabaseConfiguration mCameraCoordinator;
    public CameraDevice mCameraDevice;
    public int mCameraDeviceError;
    public final Camera2CameraInfoImpl mCameraInfoInternal;
    public final CameraManagerCompat mCameraManager;
    public final SurfaceRequest.AnonymousClass1 mCameraStateMachine;
    public final CameraStateRegistry mCameraStateRegistry;
    public CaptureSession mCaptureSession;
    public final Http2Connection.Builder mCaptureSessionOpenerBuilder;
    public final Http2Connection.Builder mCaptureSessionRepository;
    public final boolean mCloseCameraBeforeCreateNewSessionQuirk;
    public final boolean mConfigAndCloseQuirk;
    public final DisplayInfoManager mDisplayInfoManager;
    public final Toolbar.AnonymousClass1 mDynamicRangesCompat;
    public final SurfaceRequest.AnonymousClass1 mErrorTimeoutReopenScheduler;
    public final SequentialExecutor mExecutor;
    public boolean mIsActiveResumingMode;
    public boolean mIsConfigAndCloseRequired;
    public boolean mIsConfiguringForClose;
    public boolean mIsPrimary;
    public final Object mLock;
    public Http2Connection.Builder mMeteringRepeatingSession;
    public final HashSet mNotifyStateAttachedSet;
    public final SurfaceRequest.AnonymousClass1 mObservableState;
    public final LinkedHashMap mReleasedCaptureSessions;
    public final HandlerScheduledExecutorService mScheduledExecutorService;
    public volatile int mState = 3;
    public final StateCallback mStateCallback;
    public final SupportedSurfaceCombination mSupportedSurfaceCombination;
    public int mTraceStateErrorCount;
    public final SurfaceRequest.AnonymousClass1 mUseCaseAttachState;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CameraAvailability extends CameraManager.AvailabilityCallback {
        public boolean mCameraAvailable = true;
        public final String mCameraId;

        public CameraAvailability(String str) {
            this.mCameraId = str;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAvailable(String str) throws Throwable {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = true;
                if (Camera2CameraImpl.this.mState == 4) {
                    Camera2CameraImpl.this.tryOpenCameraDevice(false);
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraUnavailable(String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class StateCallback extends CameraDevice.StateCallback {
        public final VectorizedInfiniteRepeatableSpec mCameraReopenMonitor;
        public final SequentialExecutor mExecutor;
        public ScheduledFuture mScheduledReopenHandle;
        public NanoHTTPD.ServerRunnable mScheduledReopenRunnable;
        public final HandlerScheduledExecutorService mScheduler;

        public StateCallback(SequentialExecutor sequentialExecutor, HandlerScheduledExecutorService handlerScheduledExecutorService, long j) {
            this.mExecutor = sequentialExecutor;
            this.mScheduler = handlerScheduledExecutorService;
            this.mCameraReopenMonitor = new VectorizedInfiniteRepeatableSpec(this, j);
        }

        public final boolean cancelScheduledReopen() {
            if (this.mScheduledReopenHandle == null) {
                return false;
            }
            Camera2CameraImpl.this.debugLog("Cancelling scheduled re-open: " + this.mScheduledReopenRunnable, null);
            this.mScheduledReopenRunnable.hasBinded = true;
            this.mScheduledReopenRunnable = null;
            this.mScheduledReopenHandle.cancel(false);
            this.mScheduledReopenHandle = null;
            return true;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice cameraDevice) throws Throwable {
            Camera2CameraImpl.this.debugLog("CameraDevice.onClosed()", null);
            Preconditions.checkState("Unexpected onClose callback on camera device: " + cameraDevice, Camera2CameraImpl.this.mCameraDevice == null);
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(Camera2CameraImpl.this.mState);
            if (iOrdinal == 1 || iOrdinal == 4) {
                Preconditions.checkState(null, Camera2CameraImpl.this.mReleasedCaptureSessions.isEmpty());
                Camera2CameraImpl.this.configAndCloseIfNeeded();
            } else {
                if (iOrdinal != 5 && iOrdinal != 6) {
                    throw new IllegalStateException("Camera closed while in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(Camera2CameraImpl.this.mState)));
                }
                Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                int i = camera2CameraImpl.mCameraDeviceError;
                if (i == 0) {
                    camera2CameraImpl.tryOpenCameraDevice(false);
                } else {
                    camera2CameraImpl.debugLog("Camera closed due to error: ".concat(Camera2CameraImpl.getErrorMessage(i)), null);
                    scheduleCameraReopen();
                }
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice cameraDevice) throws Throwable {
            Camera2CameraImpl.this.debugLog("CameraDevice.onDisconnected()", null);
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice cameraDevice, int i) throws Throwable {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = i;
            SurfaceRequest.AnonymousClass1 anonymousClass1 = camera2CameraImpl.mErrorTimeoutReopenScheduler;
            ((Camera2CameraImpl) anonymousClass1.val$requestCancellationFuture).debugLog("Camera receive onErrorCallback", null);
            anonymousClass1.cancel();
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(Camera2CameraImpl.this.mState);
            if (iOrdinal != 1) {
                switch (iOrdinal) {
                    case 4:
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        String id = cameraDevice.getId();
                        String errorMessage = Camera2CameraImpl.getErrorMessage(i);
                        String strName = CaptureSession$State$EnumUnboxingLocalUtility.name(Camera2CameraImpl.this.mState);
                        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("CameraDevice.onError(): ", id, " failed with ", errorMessage, " while in ");
                        sbM.append(strName);
                        sbM.append(" state. Will attempt recovering from error.");
                        Logger.d("Camera2CameraImpl", sbM.toString());
                        Preconditions.checkState("Attempt to handle open error from non open state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(Camera2CameraImpl.this.mState)), Camera2CameraImpl.this.mState == 8 || Camera2CameraImpl.this.mState == 9 || Camera2CameraImpl.this.mState == 10 || Camera2CameraImpl.this.mState == 7 || Camera2CameraImpl.this.mState == 6);
                        int i2 = 3;
                        if (i != 1 && i != 2 && i != 4) {
                            Logger.e("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.getErrorMessage(i) + " closing camera.");
                            Camera2CameraImpl.this.setState(5, new AutoValue_CameraState_StateError(i == 3 ? 5 : 6, null), true);
                            Camera2CameraImpl.this.closeCamera();
                            return;
                        }
                        Logger.d("Camera2CameraImpl", "Attempt to reopen camera[" + cameraDevice.getId() + "] after error[" + Camera2CameraImpl.getErrorMessage(i) + "]");
                        Camera2CameraImpl camera2CameraImpl2 = Camera2CameraImpl.this;
                        Preconditions.checkState("Can only reopen camera device after error if the camera device is actually in an error state.", camera2CameraImpl2.mCameraDeviceError != 0);
                        if (i == 1) {
                            i2 = 2;
                        } else if (i == 2) {
                            i2 = 1;
                        }
                        camera2CameraImpl2.setState(7, new AutoValue_CameraState_StateError(i2, null), true);
                        camera2CameraImpl2.closeCamera();
                        return;
                    default:
                        throw new IllegalStateException("onError() should not be possible from state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(Camera2CameraImpl.this.mState)));
                }
            }
            String id2 = cameraDevice.getId();
            String errorMessage2 = Camera2CameraImpl.getErrorMessage(i);
            String strName2 = CaptureSession$State$EnumUnboxingLocalUtility.name(Camera2CameraImpl.this.mState);
            StringBuilder sbM2 = CaptureSession$State$EnumUnboxingLocalUtility.m("CameraDevice.onError(): ", id2, " failed with ", errorMessage2, " while in ");
            sbM2.append(strName2);
            sbM2.append(" state. Will finish closing camera.");
            Logger.e("Camera2CameraImpl", sbM2.toString());
            Camera2CameraImpl.this.closeCamera();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice cameraDevice) throws Throwable {
            Camera2CameraImpl.this.debugLog("CameraDevice.onOpened()", null);
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = 0;
            this.mCameraReopenMonitor.initialOffsetNanos = -1L;
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(camera2CameraImpl.mState);
            if (iOrdinal == 1 || iOrdinal == 4) {
                Preconditions.checkState(null, Camera2CameraImpl.this.mReleasedCaptureSessions.isEmpty());
                Camera2CameraImpl.this.mCameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            } else {
                if (iOrdinal != 5 && iOrdinal != 6 && iOrdinal != 7) {
                    throw new IllegalStateException("onOpened() should not be possible from state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(Camera2CameraImpl.this.mState)));
                }
                Camera2CameraImpl.this.setState(9);
                CameraStateRegistry cameraStateRegistry = Camera2CameraImpl.this.mCameraStateRegistry;
                String id = cameraDevice.getId();
                Camera2CameraImpl camera2CameraImpl2 = Camera2CameraImpl.this;
                if (cameraStateRegistry.tryOpenCaptureSession(id, camera2CameraImpl2.mCameraCoordinator.getPairedConcurrentCameraId(camera2CameraImpl2.mCameraDevice.getId()))) {
                    Camera2CameraImpl.this.openCaptureSession();
                }
            }
        }

        public final void scheduleCameraReopen() throws Throwable {
            Preconditions.checkState(null, this.mScheduledReopenRunnable == null);
            Preconditions.checkState(null, this.mScheduledReopenHandle == null);
            VectorizedInfiniteRepeatableSpec vectorizedInfiniteRepeatableSpec = this.mCameraReopenMonitor;
            vectorizedInfiniteRepeatableSpec.getClass();
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (vectorizedInfiniteRepeatableSpec.initialOffsetNanos == -1) {
                vectorizedInfiniteRepeatableSpec.initialOffsetNanos = jUptimeMillis;
            }
            long j = jUptimeMillis - vectorizedInfiniteRepeatableSpec.initialOffsetNanos;
            long reopenLimitMs = vectorizedInfiniteRepeatableSpec.getReopenLimitMs();
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            if (j >= reopenLimitMs) {
                vectorizedInfiniteRepeatableSpec.initialOffsetNanos = -1L;
                Logger.e("Camera2CameraImpl", "Camera reopening attempted for " + vectorizedInfiniteRepeatableSpec.getReopenLimitMs() + "ms without success.");
                camera2CameraImpl.setState(4, null, false);
                return;
            }
            this.mScheduledReopenRunnable = new NanoHTTPD.ServerRunnable(this, this.mExecutor);
            camera2CameraImpl.debugLog("Attempting camera re-open in " + vectorizedInfiniteRepeatableSpec.getReopenDelayMs() + "ms: " + this.mScheduledReopenRunnable + " activeResuming = " + camera2CameraImpl.mIsActiveResumingMode, null);
            this.mScheduledReopenHandle = this.mScheduler.schedule(this.mScheduledReopenRunnable, (long) vectorizedInfiniteRepeatableSpec.getReopenDelayMs(), TimeUnit.MILLISECONDS);
        }

        public final boolean shouldActiveResume() {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            if (!camera2CameraImpl.mIsActiveResumingMode) {
                return false;
            }
            int i = camera2CameraImpl.mCameraDeviceError;
            return i == 1 || i == 2;
        }
    }

    public Camera2CameraImpl(Context context, CameraManagerCompat cameraManagerCompat, String str, Camera2CameraInfoImpl camera2CameraInfoImpl, DatabaseConfiguration databaseConfiguration, CameraStateRegistry cameraStateRegistry, Executor executor, Handler handler, DisplayInfoManager displayInfoManager, long j) throws CameraUnavailableException {
        SurfaceRequest.AnonymousClass1 anonymousClass1 = new SurfaceRequest.AnonymousClass1(14);
        this.mObservableState = anonymousClass1;
        this.mCameraDeviceError = 0;
        new AtomicInteger(0);
        this.mReleasedCaptureSessions = new LinkedHashMap();
        this.mTraceStateErrorCount = 0;
        this.mIsConfigAndCloseRequired = false;
        this.mIsConfiguringForClose = false;
        this.mIsPrimary = true;
        this.mNotifyStateAttachedSet = new HashSet();
        this.mCameraConfig = CameraConfigs.DEFAULT_CAMERA_CONFIG;
        this.mLock = new Object();
        this.mIsActiveResumingMode = false;
        this.mErrorTimeoutReopenScheduler = new SurfaceRequest.AnonymousClass1(this);
        this.mCameraManager = cameraManagerCompat;
        this.mCameraCoordinator = databaseConfiguration;
        this.mCameraStateRegistry = cameraStateRegistry;
        HandlerScheduledExecutorService handlerScheduledExecutorService = new HandlerScheduledExecutorService(handler);
        this.mScheduledExecutorService = handlerScheduledExecutorService;
        SequentialExecutor sequentialExecutor = new SequentialExecutor(executor);
        this.mExecutor = sequentialExecutor;
        this.mStateCallback = new StateCallback(sequentialExecutor, handlerScheduledExecutorService, j);
        this.mUseCaseAttachState = new SurfaceRequest.AnonymousClass1(str, 15);
        ((MutableLiveData) anonymousClass1.val$requestCancellationCompleter).postValue(new LiveDataObservable$Result(CameraInternal.State.CLOSED));
        SurfaceRequest.AnonymousClass1 anonymousClass2 = new SurfaceRequest.AnonymousClass1(cameraStateRegistry);
        this.mCameraStateMachine = anonymousClass2;
        Http2Connection.Builder builder = new Http2Connection.Builder();
        builder.socket = new Object();
        builder.connectionName = new LinkedHashSet();
        builder.source = new LinkedHashSet();
        builder.sink = new LinkedHashSet();
        builder.listener = new CaptureSessionRepository$1(builder);
        builder.taskRunner = sequentialExecutor;
        this.mCaptureSessionRepository = builder;
        this.mDisplayInfoManager = displayInfoManager;
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str);
            Camera2CameraControlImpl camera2CameraControlImpl = new Camera2CameraControlImpl(cameraCharacteristicsCompat, handlerScheduledExecutorService, sequentialExecutor, new Toolbar.AnonymousClass1(4, this), camera2CameraInfoImpl.mCameraQuirks);
            this.mCameraControlInternal = camera2CameraControlImpl;
            this.mCameraInfoInternal = camera2CameraInfoImpl;
            camera2CameraInfoImpl.linkWithCameraControl(camera2CameraControlImpl);
            camera2CameraInfoImpl.mCameraStateLiveData.redirectTo((MutableLiveData) anonymousClass2.val$requestCancellationFuture);
            this.mDynamicRangesCompat = Toolbar.AnonymousClass1.fromCameraCharacteristics(cameraCharacteristicsCompat);
            this.mCaptureSession = newCaptureSession();
            this.mCaptureSessionOpenerBuilder = new Http2Connection.Builder(sequentialExecutor, handlerScheduledExecutorService, handler, builder, camera2CameraInfoImpl.mCameraQuirks, DeviceQuirks.sQuirks);
            this.mCloseCameraBeforeCreateNewSessionQuirk = camera2CameraInfoImpl.mCameraQuirks.contains(LegacyCameraOutputConfigNullPointerQuirk.class);
            this.mConfigAndCloseQuirk = camera2CameraInfoImpl.mCameraQuirks.contains(LegacyCameraSurfaceCleanupQuirk.class);
            CameraAvailability cameraAvailability = new CameraAvailability(str);
            this.mCameraAvailability = cameraAvailability;
            PreviewView.AnonymousClass1 anonymousClass3 = new PreviewView.AnonymousClass1(6, this);
            synchronized (cameraStateRegistry.mLock) {
                Preconditions.checkState("Camera is already registered: " + this, !cameraStateRegistry.mCameraStates.containsKey(this));
                cameraStateRegistry.mCameraStates.put(this, new CameraStateRegistry.CameraRegistration(sequentialExecutor, anonymousClass3, cameraAvailability));
            }
            cameraManagerCompat.mImpl.registerAvailabilityCallback(sequentialExecutor, cameraAvailability);
            this.mSupportedSurfaceCombination = new SupportedSurfaceCombination(context, str, cameraManagerCompat, new EmptyNetworkObserver());
        } catch (CameraAccessExceptionCompat e) {
            throw new CameraUnavailableException(e);
        }
    }

    public static String getErrorMessage(int i) {
        if (i == 0) {
            return "ERROR_NONE";
        }
        if (i == 1) {
            return "ERROR_CAMERA_IN_USE";
        }
        if (i == 2) {
            return "ERROR_MAX_CAMERAS_IN_USE";
        }
        if (i == 3) {
            return "ERROR_CAMERA_DISABLED";
        }
        if (i != 4) {
            return i != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE";
        }
        return "ERROR_CAMERA_DEVICE";
    }

    public static String getMeteringRepeatingId(Http2Connection.Builder builder) {
        StringBuilder sb = new StringBuilder("MeteringRepeating");
        builder.getClass();
        sb.append(builder.hashCode());
        return sb.toString();
    }

    public static String getUseCaseId(UseCase useCase) {
        return useCase.getName() + useCase.hashCode();
    }

    public final void addOrRemoveMeteringRepeatingUseCase() {
        int i;
        Size size;
        SurfaceRequest.AnonymousClass1 anonymousClass1 = this.mUseCaseAttachState;
        SessionConfig sessionConfigBuild = anonymousClass1.getAttachedBuilder().build();
        CaptureConfig captureConfig = sessionConfigBuild.mRepeatingCaptureConfig;
        int size2 = Collections.unmodifiableList(captureConfig.mSurfaces).size();
        int size3 = sessionConfigBuild.getSurfaces().size();
        if (sessionConfigBuild.getSurfaces().isEmpty()) {
            return;
        }
        if (!Collections.unmodifiableList(captureConfig.mSurfaces).isEmpty()) {
            if (size3 == 1 && size2 == 1) {
                removeMeteringRepeating();
                return;
            }
            if (size2 >= 2) {
                removeMeteringRepeating();
                return;
            }
            if (this.mMeteringRepeatingSession != null && !isSurfaceCombinationWithMeteringRepeatingSupported()) {
                removeMeteringRepeating();
                return;
            }
            Logger.d("Camera2CameraImpl", "No need to remove a previous mMeteringRepeating, SessionConfig Surfaces: " + size3 + ", CaptureConfig Surfaces: " + size2);
            return;
        }
        if (this.mMeteringRepeatingSession == null) {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCameraInfoInternal.mCameraCharacteristicsCompat;
            Camera2CameraImpl$$ExternalSyntheticLambda14 camera2CameraImpl$$ExternalSyntheticLambda14 = new Camera2CameraImpl$$ExternalSyntheticLambda14(this, 0);
            Http2Connection.Builder builder = new Http2Connection.Builder();
            SupportedRepeatingSurfaceSize supportedRepeatingSurfaceSize = new SupportedRepeatingSurfaceSize();
            Size size4 = null;
            builder.listener = null;
            builder.connectionName = new UseCaseConfig() { // from class: androidx.camera.camera2.internal.MeteringRepeatingSession$MeteringRepeatingConfig
                public final MutableOptionsBundle mConfig;

                {
                    MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
                    mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, new Camera2SessionOptionUnpacker());
                    mutableOptionsBundleCreate.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
                    mutableOptionsBundleCreate.insertOption(TargetConfig.OPTION_TARGET_CLASS, Http2Connection.Builder.class);
                    mutableOptionsBundleCreate.insertOption(TargetConfig.OPTION_TARGET_NAME, Http2Connection.Builder.class.getCanonicalName() + "-" + UUID.randomUUID());
                    this.mConfig = mutableOptionsBundleCreate;
                }

                @Override // androidx.camera.core.impl.Config
                public final boolean containsOption(AutoValue_Config_Option autoValue_Config_Option) {
                    return this.mConfig.mOptions.containsKey(autoValue_Config_Option);
                }

                @Override // androidx.camera.core.impl.Config
                public final void findOptions(CaptureRequestOptions$Builder$$ExternalSyntheticLambda0 captureRequestOptions$Builder$$ExternalSyntheticLambda0) {
                    this.mConfig.findOptions(captureRequestOptions$Builder$$ExternalSyntheticLambda0);
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final UseCaseConfigFactory.CaptureType getCaptureType() {
                    return UseCaseConfigFactory.CaptureType.METERING_REPEATING;
                }

                @Override // androidx.camera.core.impl.ReadableConfig
                public final Config getConfig() {
                    return this.mConfig;
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final CaptureConfig getDefaultCaptureConfig() {
                    return (CaptureConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, null);
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final SessionConfig getDefaultSessionConfig() {
                    return (SessionConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final SessionConfig getDefaultSessionConfig$1() {
                    return (SessionConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, null);
                }

                @Override // androidx.camera.core.impl.ImageInputConfig
                public final /* synthetic */ DynamicRange getDynamicRange() {
                    return ImageAnalysis$$ExternalSyntheticLambda1.$default$getDynamicRange(this);
                }

                @Override // androidx.camera.core.impl.ImageInputConfig
                public final int getInputFormat() {
                    return ((Integer) retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
                }

                @Override // androidx.camera.core.impl.Config
                public final Config.OptionPriority getOptionPriority(AutoValue_Config_Option autoValue_Config_Option) {
                    return this.mConfig.getOptionPriority(autoValue_Config_Option);
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final /* synthetic */ int getPreviewStabilizationMode() {
                    return ((Integer) retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0)).intValue();
                }

                @Override // androidx.camera.core.impl.Config
                public final Set getPriorities(AutoValue_Config_Option autoValue_Config_Option) {
                    return this.mConfig.getPriorities(autoValue_Config_Option);
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final Camera2SessionOptionUnpacker getSessionOptionUnpacker() {
                    return (Camera2SessionOptionUnpacker) retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, null);
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final /* synthetic */ int getSurfaceOccupancyPriority() {
                    return ((Integer) retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, 0)).intValue();
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final Range getTargetFrameRate() {
                    return (Range) retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, null);
                }

                @Override // androidx.camera.core.internal.TargetConfig
                public final /* synthetic */ String getTargetName() {
                    return ImageAnalysis$$ExternalSyntheticLambda1.$default$getTargetName(this);
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final /* synthetic */ int getVideoStabilizationMode() {
                    return ((Integer) retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0)).intValue();
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final /* synthetic */ boolean isHighResolutionDisabled() {
                    return ((Boolean) retrieveOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.FALSE)).booleanValue();
                }

                @Override // androidx.camera.core.impl.UseCaseConfig
                public final /* synthetic */ boolean isZslDisabled() {
                    return ((Boolean) retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.FALSE)).booleanValue();
                }

                @Override // androidx.camera.core.impl.Config
                public final Set listOptions() {
                    return this.mConfig.listOptions();
                }

                @Override // androidx.camera.core.impl.Config
                public final Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option, Object obj) {
                    MutableOptionsBundle mutableOptionsBundle = this.mConfig;
                    mutableOptionsBundle.getClass();
                    try {
                        return mutableOptionsBundle.retrieveOption(autoValue_Config_Option);
                    } catch (IllegalArgumentException unused) {
                        return obj;
                    }
                }

                @Override // androidx.camera.core.impl.Config
                public final Object retrieveOptionWithPriority(AutoValue_Config_Option autoValue_Config_Option, Config.OptionPriority optionPriority) {
                    return this.mConfig.retrieveOptionWithPriority(autoValue_Config_Option, optionPriority);
                }

                @Override // androidx.camera.core.internal.TargetConfig
                public final /* synthetic */ String getTargetName(String str) {
                    return ImageAnalysis$$ExternalSyntheticLambda1.$default$getTargetName(this, str);
                }

                @Override // androidx.camera.core.impl.Config
                public final Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option) {
                    return this.mConfig.retrieveOption(autoValue_Config_Option);
                }
            };
            builder.sink = camera2CameraImpl$$ExternalSyntheticLambda14;
            Size[] outputSizes = cameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputSizes(34);
            int i2 = 0;
            if (outputSizes != null) {
                if (supportedRepeatingSurfaceSize.mQuirk != null && "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL)) {
                    ArrayList arrayList = new ArrayList();
                    for (Size size5 : outputSizes) {
                        if (SupportedRepeatingSurfaceSize.SIZE_COMPARATOR.compare(size5, SupportedRepeatingSurfaceSize.MINI_PREVIEW_SIZE_HUAWEI_MATE_9) >= 0) {
                            arrayList.add(size5);
                        }
                    }
                    outputSizes = (Size[]) arrayList.toArray(new Size[0]);
                }
                List listAsList = Arrays.asList(outputSizes);
                Collections.sort(listAsList, new LayoutNode$$ExternalSyntheticLambda0(1));
                Size previewSize = this.mDisplayInfoManager.getPreviewSize();
                long jMin = Math.min(((long) previewSize.getWidth()) * ((long) previewSize.getHeight()), 307200L);
                int length = outputSizes.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        Size size6 = outputSizes[i3];
                        Size size7 = size4;
                        long j = jMin;
                        long width = ((long) size6.getWidth()) * ((long) size6.getHeight());
                        if (width == j) {
                            size = size6;
                            break;
                        }
                        if (width <= j) {
                            i3++;
                            size4 = size6;
                            jMin = j;
                            i2 = 0;
                        } else {
                            if (size7 != null) {
                                size = size7;
                                break;
                            }
                            i = 0;
                        }
                    } else {
                        i = i2;
                    }
                    size = (Size) listAsList.get(i);
                    break;
                }
            } else {
                Logger.e("MeteringRepeating", "Can not get output size list.");
                size = new Size(0, 0);
            }
            builder.source = size;
            Logger.d("MeteringRepeating", "MeteringSession SurfaceTexture size: " + size);
            builder.socket = builder.createSessionConfig();
            this.mMeteringRepeatingSession = builder;
        }
        if (!isSurfaceCombinationWithMeteringRepeatingSupported()) {
            Logger.e("Camera2CameraImpl", "Failed to add a repeating surface, CameraControl and ImageCapture may encounter issues due to the absence of repeating surface. Please add a UseCase (Preview or ImageAnalysis) that can provide a repeating surface for CameraControl and ImageCapture to function properly.");
            return;
        }
        Http2Connection.Builder builder2 = this.mMeteringRepeatingSession;
        if (builder2 != null) {
            String meteringRepeatingId = getMeteringRepeatingId(builder2);
            Http2Connection.Builder builder3 = this.mMeteringRepeatingSession;
            SessionConfig sessionConfig = (SessionConfig) builder3.socket;
            MeteringRepeatingSession$MeteringRepeatingConfig meteringRepeatingSession$MeteringRepeatingConfig = (MeteringRepeatingSession$MeteringRepeatingConfig) builder3.connectionName;
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
            List listSingletonList = Collections.singletonList(captureType);
            LinkedHashMap linkedHashMap = (LinkedHashMap) anonymousClass1.val$requestCancellationFuture;
            UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(meteringRepeatingId);
            if (useCaseAttachState$UseCaseAttachInfo == null) {
                useCaseAttachState$UseCaseAttachInfo = new UseCaseAttachState$UseCaseAttachInfo(sessionConfig, meteringRepeatingSession$MeteringRepeatingConfig, null, listSingletonList);
                linkedHashMap.put(meteringRepeatingId, useCaseAttachState$UseCaseAttachInfo);
            }
            useCaseAttachState$UseCaseAttachInfo.mAttached = true;
            anonymousClass1.updateUseCase(meteringRepeatingId, sessionConfig, meteringRepeatingSession$MeteringRepeatingConfig, null, listSingletonList);
            Http2Connection.Builder builder4 = this.mMeteringRepeatingSession;
            SessionConfig sessionConfig2 = (SessionConfig) builder4.socket;
            MeteringRepeatingSession$MeteringRepeatingConfig meteringRepeatingSession$MeteringRepeatingConfig2 = (MeteringRepeatingSession$MeteringRepeatingConfig) builder4.connectionName;
            List listSingletonList2 = Collections.singletonList(captureType);
            LinkedHashMap linkedHashMap2 = (LinkedHashMap) anonymousClass1.val$requestCancellationFuture;
            UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo2 = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap2.get(meteringRepeatingId);
            if (useCaseAttachState$UseCaseAttachInfo2 == null) {
                useCaseAttachState$UseCaseAttachInfo2 = new UseCaseAttachState$UseCaseAttachInfo(sessionConfig2, meteringRepeatingSession$MeteringRepeatingConfig2, null, listSingletonList2);
                linkedHashMap2.put(meteringRepeatingId, useCaseAttachState$UseCaseAttachInfo2);
            }
            useCaseAttachState$UseCaseAttachInfo2.mActive = true;
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final void attachUseCases(ArrayList arrayList) {
        Camera2CameraControlImpl camera2CameraControlImpl = this.mCameraControlInternal;
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return;
        }
        synchronized (camera2CameraControlImpl.mLock) {
            camera2CameraControlImpl.mUseCount++;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        HashSet hashSet = this.mNotifyStateAttachedSet;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            UseCase useCase = (UseCase) obj;
            String useCaseId = getUseCaseId(useCase);
            if (!hashSet.contains(useCaseId)) {
                hashSet.add(useCaseId);
                useCase.onStateAttached();
                useCase.onCameraControlReady();
            }
        }
        try {
            this.mExecutor.execute(new Camera2CameraImpl$$ExternalSyntheticLambda5(this, new ArrayList(toUseCaseInfos(arrayList2)), 0));
        } catch (RejectedExecutionException e) {
            debugLog("Unable to attach use cases.", e);
            camera2CameraControlImpl.decrementUseCount();
        }
    }

    public final void closeCamera() throws Throwable {
        ArrayList arrayList;
        int i = 0;
        Preconditions.checkState("closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(this.mState) + " (error: " + getErrorMessage(this.mCameraDeviceError) + ")", this.mState == 5 || this.mState == 2 || (this.mState == 7 && this.mCameraDeviceError != 0));
        resetCaptureSession();
        CaptureSession captureSession = this.mCaptureSession;
        synchronized (captureSession.mSessionLock) {
            try {
                if (captureSession.mCaptureConfigs.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(captureSession.mCaptureConfigs);
                    captureSession.mCaptureConfigs.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                CaptureConfig captureConfig = (CaptureConfig) obj;
                for (CameraCaptureCallback cameraCaptureCallback : captureConfig.mCameraCaptureCallbacks) {
                    Object obj2 = captureConfig.mTagBundle.mTagMap.get("CAPTURE_CONFIG_ID_KEY");
                    cameraCaptureCallback.onCaptureCancelled(obj2 == null ? -1 : ((Integer) obj2).intValue());
                }
            }
        }
    }

    public final void configAndCloseIfNeeded() throws Throwable {
        Preconditions.checkState(null, this.mState == 2 || this.mState == 5);
        Preconditions.checkState(null, this.mReleasedCaptureSessions.isEmpty());
        if (!this.mIsConfigAndCloseRequired) {
            finishClose();
            return;
        }
        if (this.mIsConfiguringForClose) {
            debugLog("Ignored since configAndClose is processing", null);
            return;
        }
        if (!this.mCameraAvailability.mCameraAvailable) {
            this.mIsConfigAndCloseRequired = false;
            finishClose();
            debugLog("Ignore configAndClose and finish the close flow directly since camera is unavailable.", null);
        } else {
            debugLog("Open camera to configAndClose", null);
            CallbackToFutureAdapter.SafeFuture future = CallbackToFutureAdapter.getFuture(new Camera2CameraImpl$$ExternalSyntheticLambda14(this, 2));
            this.mIsConfiguringForClose = true;
            future.delegate.addListener(new Preview$$ExternalSyntheticLambda0(3, this), this.mExecutor);
        }
    }

    public final CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().mDeviceStateCallbacks);
        arrayList.add((CaptureSessionRepository$1) this.mCaptureSessionRepository.listener);
        arrayList.add(this.mStateCallback);
        return ComparisonsKt__ComparisonsKt.createComboCallback(arrayList);
    }

    public final void debugLog(String str, Throwable th) {
        String str2 = "{" + toString() + "} " + str;
        String strTruncateTag = Logger.truncateTag("Camera2CameraImpl");
        if (Logger.isLogLevelEnabled(strTruncateTag, 3)) {
            Log.d(strTruncateTag, str2, th);
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final void detachUseCases(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList(toUseCaseInfos(arrayList2));
        ArrayList arrayList4 = new ArrayList(arrayList2);
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            UseCase useCase = (UseCase) obj;
            String useCaseId = getUseCaseId(useCase);
            HashSet hashSet = this.mNotifyStateAttachedSet;
            if (hashSet.contains(useCaseId)) {
                useCase.onStateDetached();
                hashSet.remove(useCaseId);
            }
        }
        this.mExecutor.execute(new Camera2CameraImpl$$ExternalSyntheticLambda5(this, arrayList3, 1));
    }

    public final void finishClose() throws Throwable {
        Preconditions.checkState(null, this.mState == 2 || this.mState == 5);
        Preconditions.checkState(null, this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState == 5) {
            setState(3);
            return;
        }
        this.mCameraManager.mImpl.unregisterAvailabilityCallback(this.mCameraAvailability);
        setState(1);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final CameraInfoInternal getCameraInfo() {
        return getCameraInfoInternal();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final Observable getCameraState() {
        return this.mObservableState;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final CameraConfig getExtendedConfig() {
        return this.mCameraConfig;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ boolean getHasTransform() {
        return true;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final boolean isFrontFacing() {
        return ((Camera2CameraInfoImpl) getCameraInfo()).getLensFacing() == 0;
    }

    public final boolean isSurfaceCombinationWithMeteringRepeatingSupported() {
        int i;
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                i = this.mCameraCoordinator.journalMode == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        SurfaceRequest.AnonymousClass1 anonymousClass1 = this.mUseCaseAttachState;
        anonymousClass1.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) anonymousClass1.val$requestCancellationFuture).entrySet()) {
            if (((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mAttached) {
                arrayList2.add((UseCaseAttachState$UseCaseAttachInfo) entry.getValue());
            }
        }
        for (UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo : Collections.unmodifiableCollection(arrayList2)) {
            List list = useCaseAttachState$UseCaseAttachInfo.mCaptureTypes;
            if (list == null || list.get(0) != UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                if (useCaseAttachState$UseCaseAttachInfo.mStreamSpec == null || useCaseAttachState$UseCaseAttachInfo.mCaptureTypes == null) {
                    Logger.w("Camera2CameraImpl", "Invalid stream spec or capture types in " + useCaseAttachState$UseCaseAttachInfo);
                    return false;
                }
                SessionConfig sessionConfig = useCaseAttachState$UseCaseAttachInfo.mSessionConfig;
                UseCaseConfig useCaseConfig = useCaseAttachState$UseCaseAttachInfo.mUseCaseConfig;
                for (DeferrableSurface deferrableSurface : sessionConfig.getSurfaces()) {
                    SupportedSurfaceCombination supportedSurfaceCombination = this.mSupportedSurfaceCombination;
                    int inputFormat = useCaseConfig.getInputFormat();
                    AutoValue_SurfaceConfig autoValue_SurfaceConfigTransformSurfaceConfig = AutoValue_SurfaceConfig.transformSurfaceConfig(i, inputFormat, deferrableSurface.mPrescribedSize, supportedSurfaceCombination.getUpdatedSurfaceSizeDefinitionByFormat(inputFormat));
                    int inputFormat2 = useCaseConfig.getInputFormat();
                    Size size = deferrableSurface.mPrescribedSize;
                    AutoValue_StreamSpec autoValue_StreamSpec = useCaseAttachState$UseCaseAttachInfo.mStreamSpec;
                    arrayList.add(new AutoValue_AttachedSurfaceInfo(autoValue_SurfaceConfigTransformSurfaceConfig, inputFormat2, size, autoValue_StreamSpec.dynamicRange, useCaseAttachState$UseCaseAttachInfo.mCaptureTypes, autoValue_StreamSpec.implementationOptions, useCaseConfig.getTargetFrameRate()));
                }
            }
        }
        this.mMeteringRepeatingSession.getClass();
        HashMap map = new HashMap();
        Http2Connection.Builder builder = this.mMeteringRepeatingSession;
        map.put((MeteringRepeatingSession$MeteringRepeatingConfig) builder.connectionName, Collections.singletonList((Size) builder.source));
        try {
            this.mSupportedSurfaceCombination.getSuggestedStreamSpecifications(i, arrayList, map, false, false);
            debugLog("Surface combination with metering repeating supported!", null);
            return true;
        } catch (IllegalArgumentException e) {
            debugLog("Surface combination with metering repeating  not supported!", e);
            return false;
        }
    }

    public final CaptureSession newCaptureSession() {
        CaptureSession captureSession;
        synchronized (this.mLock) {
            captureSession = new CaptureSession(this.mDynamicRangesCompat, this.mCameraInfoInternal.mCameraQuirks, false);
        }
        return captureSession;
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseActive(UseCase useCase) {
        this.mExecutor.execute(new Camera2CameraImpl$$ExternalSyntheticLambda6(this, getUseCaseId(useCase), this.mIsPrimary ? useCase.mAttachedSessionConfig : useCase.mAttachedSecondarySessionConfig, useCase.mCurrentConfig, useCase.mAttachedStreamSpec, useCase.getCamera() == null ? null : StreamSharing.getCaptureTypes(useCase), 2));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseInactive(UseCase useCase) {
        this.mExecutor.execute(new Preview$$ExternalSyntheticLambda1(8, this, getUseCaseId(useCase)));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseReset(UseCase useCase) {
        this.mExecutor.execute(new Camera2CameraImpl$$ExternalSyntheticLambda6(this, getUseCaseId(useCase), this.mIsPrimary ? useCase.mAttachedSessionConfig : useCase.mAttachedSecondarySessionConfig, useCase.mCurrentConfig, useCase.mAttachedStreamSpec, useCase.getCamera() == null ? null : StreamSharing.getCaptureTypes(useCase), 1));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseUpdated(UseCase useCase) {
        this.mExecutor.execute(new Camera2CameraImpl$$ExternalSyntheticLambda6(this, getUseCaseId(useCase), this.mIsPrimary ? useCase.mAttachedSessionConfig : useCase.mAttachedSecondarySessionConfig, useCase.mCurrentConfig, useCase.mAttachedStreamSpec, useCase.getCamera() == null ? null : StreamSharing.getCaptureTypes(useCase), 0));
    }

    public final void openCameraDevice(boolean z) throws Throwable {
        if (!z) {
            this.mStateCallback.mCameraReopenMonitor.initialOffsetNanos = -1L;
        }
        this.mStateCallback.cancelScheduledReopen();
        this.mErrorTimeoutReopenScheduler.cancel();
        debugLog("Opening camera.", null);
        setState(8);
        try {
            this.mCameraManager.mImpl.openCamera(this.mCameraInfoInternal.mCameraId, this.mExecutor, createDeviceStateCallback());
        } catch (CameraAccessExceptionCompat e) {
            debugLog("Unable to open camera due to " + e.getMessage(), null);
            if (e.mReason == 10001) {
                setState(3, new AutoValue_CameraState_StateError(7, e), true);
                return;
            }
            SurfaceRequest.AnonymousClass1 anonymousClass1 = this.mErrorTimeoutReopenScheduler;
            if (((Camera2CameraImpl) anonymousClass1.val$requestCancellationFuture).mState != 8) {
                ((Camera2CameraImpl) anonymousClass1.val$requestCancellationFuture).debugLog("Don't need the onError timeout handler.", null);
                return;
            }
            ((Camera2CameraImpl) anonymousClass1.val$requestCancellationFuture).debugLog("Camera waiting for onError.", null);
            anonymousClass1.cancel();
            anonymousClass1.val$requestCancellationCompleter = new MenuHostHelper(anonymousClass1);
        } catch (SecurityException e2) {
            debugLog("Unable to open camera due to " + e2.getMessage(), null);
            setState(7);
            this.mStateCallback.scheduleCameraReopen();
        }
    }

    public final void openCaptureSession() {
        int i = 1;
        Preconditions.checkState(null, this.mState == 9);
        SessionConfig.ValidatingBuilder attachedBuilder = this.mUseCaseAttachState.getAttachedBuilder();
        if (!attachedBuilder.mTemplateSet || !attachedBuilder.mValid) {
            debugLog("Unable to create capture session due to conflicting configurations", null);
            return;
        }
        if (!this.mCameraStateRegistry.tryOpenCaptureSession(this.mCameraDevice.getId(), this.mCameraCoordinator.getPairedConcurrentCameraId(this.mCameraDevice.getId()))) {
            debugLog("Unable to create capture session in camera operating mode = " + this.mCameraCoordinator.journalMode, null);
            return;
        }
        HashMap map = new HashMap();
        Collection<SessionConfig> attachedSessionConfigs = this.mUseCaseAttachState.getAttachedSessionConfigs();
        Collection attachedUseCaseConfigs = this.mUseCaseAttachState.getAttachedUseCaseConfigs();
        AutoValue_Config_Option autoValue_Config_Option = StreamUseCaseUtil.STREAM_USE_CASE_STREAM_SPEC_OPTION;
        ArrayList arrayList = new ArrayList(attachedUseCaseConfigs);
        for (SessionConfig sessionConfig : attachedSessionConfigs) {
            if (sessionConfig.mRepeatingCaptureConfig.mImplementationOptions.mOptions.containsKey(autoValue_Config_Option) && sessionConfig.getSurfaces().size() != 1) {
                Logger.e("StreamUseCaseUtil", String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", Integer.valueOf(sessionConfig.getSurfaces().size())));
                break;
            }
            if (sessionConfig.mRepeatingCaptureConfig.mImplementationOptions.mOptions.containsKey(autoValue_Config_Option)) {
                int i2 = 0;
                for (SessionConfig sessionConfig2 : attachedSessionConfigs) {
                    if (((UseCaseConfig) arrayList.get(i2)).getCaptureType() == UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                        Preconditions.checkState("MeteringRepeating should contain a surface", !sessionConfig2.getSurfaces().isEmpty());
                        map.put((DeferrableSurface) sessionConfig2.getSurfaces().get(0), 1L);
                    } else if (sessionConfig2.mRepeatingCaptureConfig.mImplementationOptions.mOptions.containsKey(autoValue_Config_Option) && !sessionConfig2.getSurfaces().isEmpty()) {
                        map.put((DeferrableSurface) sessionConfig2.getSurfaces().get(0), (Long) sessionConfig2.mRepeatingCaptureConfig.mImplementationOptions.retrieveOption(autoValue_Config_Option));
                    }
                    i2++;
                }
                break;
            }
        }
        CaptureSession captureSession = this.mCaptureSession;
        synchronized (captureSession.mSessionLock) {
            captureSession.mStreamUseCaseMap = map;
        }
        CaptureSession captureSession2 = this.mCaptureSession;
        SessionConfig sessionConfigBuild = attachedBuilder.build();
        CameraDevice cameraDevice = this.mCameraDevice;
        cameraDevice.getClass();
        Http2Connection.Builder builder = this.mCaptureSessionOpenerBuilder;
        ListenableFuture listenableFutureOpen = captureSession2.open(sessionConfigBuild, cameraDevice, new SynchronizedCaptureSessionImpl((Quirks) builder.sink, (Quirks) builder.listener, (Http2Connection.Builder) builder.source, (SequentialExecutor) builder.taskRunner, (HandlerScheduledExecutorService) builder.socket, (Handler) builder.connectionName));
        listenableFutureOpen.addListener(new zzi(i, listenableFutureOpen, new AnonymousClass3(this, captureSession2, i)), this.mExecutor);
    }

    public final void removeMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            StringBuilder sb = new StringBuilder("MeteringRepeating");
            this.mMeteringRepeatingSession.getClass();
            sb.append(this.mMeteringRepeatingSession.hashCode());
            String string = sb.toString();
            SurfaceRequest.AnonymousClass1 anonymousClass1 = this.mUseCaseAttachState;
            LinkedHashMap linkedHashMap = (LinkedHashMap) anonymousClass1.val$requestCancellationFuture;
            if (linkedHashMap.containsKey(string)) {
                UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(string);
                useCaseAttachState$UseCaseAttachInfo.mAttached = false;
                if (!useCaseAttachState$UseCaseAttachInfo.mActive) {
                    linkedHashMap.remove(string);
                }
            }
            StringBuilder sb2 = new StringBuilder("MeteringRepeating");
            this.mMeteringRepeatingSession.getClass();
            sb2.append(this.mMeteringRepeatingSession.hashCode());
            String string2 = sb2.toString();
            LinkedHashMap linkedHashMap2 = (LinkedHashMap) anonymousClass1.val$requestCancellationFuture;
            if (linkedHashMap2.containsKey(string2)) {
                UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo2 = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap2.get(string2);
                useCaseAttachState$UseCaseAttachInfo2.mActive = false;
                if (!useCaseAttachState$UseCaseAttachInfo2.mAttached) {
                    linkedHashMap2.remove(string2);
                }
            }
            Http2Connection.Builder builder = this.mMeteringRepeatingSession;
            builder.getClass();
            Logger.d("MeteringRepeating", "MeteringRepeating clear!");
            SurfaceRequest.AnonymousClass2 anonymousClass2 = (SurfaceRequest.AnonymousClass2) builder.taskRunner;
            if (anonymousClass2 != null) {
                anonymousClass2.close();
            }
            builder.taskRunner = null;
            this.mMeteringRepeatingSession = null;
        }
    }

    public final void resetCaptureSession() throws Throwable {
        SessionConfig sessionConfig;
        Preconditions.checkState(null, this.mCaptureSession != null);
        debugLog("Resetting Capture Session", null);
        CaptureSession captureSession = this.mCaptureSession;
        synchronized (captureSession.mSessionLock) {
            sessionConfig = captureSession.mSessionConfig;
        }
        List captureConfigs = captureSession.getCaptureConfigs();
        CaptureSession captureSessionNewCaptureSession = newCaptureSession();
        this.mCaptureSession = captureSessionNewCaptureSession;
        captureSessionNewCaptureSession.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(captureConfigs);
        if (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mState) != 8) {
            debugLog("Skipping Capture Session state check due to current camera state: " + CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(this.mState) + " and previous session status: " + captureSession.isInOpenState(), null);
        } else if (this.mCloseCameraBeforeCreateNewSessionQuirk && captureSession.isInOpenState()) {
            debugLog("Close camera before creating new session", null);
            setState(6);
        }
        if (this.mConfigAndCloseQuirk && captureSession.isInOpenState()) {
            debugLog("ConfigAndClose is required when close the camera.", null);
            this.mIsConfigAndCloseRequired = true;
        }
        captureSession.close();
        ListenableFuture listenableFutureRelease = captureSession.release();
        debugLog("Releasing session in state ".concat(CaptureSession$State$EnumUnboxingLocalUtility.name(this.mState)), null);
        this.mReleasedCaptureSessions.put(captureSession, listenableFutureRelease);
        listenableFutureRelease.addListener(new zzi(1, listenableFutureRelease, new AnonymousClass3(this, captureSession, 0)), HexFormatKt.directExecutor());
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final void setActiveResumingMode(boolean z) {
        this.mExecutor.execute(new Camera2CameraImpl$$ExternalSyntheticLambda12(0, this, z));
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final void setExtendedConfig(Toolbar.AnonymousClass1 anonymousClass1) {
        if (anonymousClass1 == null) {
            anonymousClass1 = CameraConfigs.DEFAULT_CAMERA_CONFIG;
        }
        anonymousClass1.getSessionProcessor();
        this.mCameraConfig = anonymousClass1;
        synchronized (this.mLock) {
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final void setPrimary(boolean z) {
        this.mIsPrimary = z;
    }

    public final void setState(int i) throws Throwable {
        setState(i, null, true);
    }

    public final String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.mCameraInfoInternal.mCameraId);
    }

    public final ArrayList toUseCaseInfos(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            UseCase useCase = (UseCase) obj;
            boolean z = this.mIsPrimary;
            String useCaseId = getUseCaseId(useCase);
            Class<?> cls = useCase.getClass();
            SessionConfig sessionConfig = z ? useCase.mAttachedSessionConfig : useCase.mAttachedSecondarySessionConfig;
            UseCaseConfig useCaseConfig = useCase.mCurrentConfig;
            AutoValue_StreamSpec autoValue_StreamSpec = useCase.mAttachedStreamSpec;
            arrayList2.add(new AutoValue_Camera2CameraImpl_UseCaseInfo(useCaseId, cls, sessionConfig, useCaseConfig, autoValue_StreamSpec != null ? autoValue_StreamSpec.resolution : null, autoValue_StreamSpec, useCase.getCamera() != null ? StreamSharing.getCaptureTypes(useCase) : null));
        }
        return arrayList2;
    }

    public final void tryAttachUseCases(ArrayList arrayList) throws Throwable {
        boolean z;
        UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo;
        Size size;
        boolean zIsEmpty = this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty();
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        Rational rational = null;
        int i = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            AutoValue_Camera2CameraImpl_UseCaseInfo autoValue_Camera2CameraImpl_UseCaseInfo = (AutoValue_Camera2CameraImpl_UseCaseInfo) obj;
            if (!this.mUseCaseAttachState.isUseCaseAttached(autoValue_Camera2CameraImpl_UseCaseInfo.useCaseId)) {
                SurfaceRequest.AnonymousClass1 anonymousClass1 = this.mUseCaseAttachState;
                String str = autoValue_Camera2CameraImpl_UseCaseInfo.useCaseId;
                SessionConfig sessionConfig = autoValue_Camera2CameraImpl_UseCaseInfo.sessionConfig;
                UseCaseConfig useCaseConfig = autoValue_Camera2CameraImpl_UseCaseInfo.useCaseConfig;
                AutoValue_StreamSpec autoValue_StreamSpec = autoValue_Camera2CameraImpl_UseCaseInfo.streamSpec;
                List list = autoValue_Camera2CameraImpl_UseCaseInfo.captureTypes;
                LinkedHashMap linkedHashMap = (LinkedHashMap) anonymousClass1.val$requestCancellationFuture;
                UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo2 = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(str);
                if (useCaseAttachState$UseCaseAttachInfo2 == null) {
                    useCaseAttachState$UseCaseAttachInfo = new UseCaseAttachState$UseCaseAttachInfo(sessionConfig, useCaseConfig, autoValue_StreamSpec, list);
                    linkedHashMap.put(str, useCaseAttachState$UseCaseAttachInfo);
                } else {
                    useCaseAttachState$UseCaseAttachInfo = useCaseAttachState$UseCaseAttachInfo2;
                }
                useCaseAttachState$UseCaseAttachInfo.mAttached = true;
                anonymousClass1.updateUseCase(str, sessionConfig, useCaseConfig, autoValue_StreamSpec, list);
                arrayList2.add(autoValue_Camera2CameraImpl_UseCaseInfo.useCaseId);
                if (autoValue_Camera2CameraImpl_UseCaseInfo.useCaseType == Preview.class && (size = autoValue_Camera2CameraImpl_UseCaseInfo.surfaceResolution) != null) {
                    rational = new Rational(size.getWidth(), size.getHeight());
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        debugLog("Use cases [" + TextUtils.join(", ", arrayList2) + "] now ATTACHED", null);
        if (zIsEmpty) {
            z = true;
            this.mCameraControlInternal.setActive(true);
            Camera2CameraControlImpl camera2CameraControlImpl = this.mCameraControlInternal;
            synchronized (camera2CameraControlImpl.mLock) {
                camera2CameraControlImpl.mUseCount++;
            }
        } else {
            z = true;
        }
        addOrRemoveMeteringRepeatingUseCase();
        updateZslDisabledByUseCaseConfigStatus();
        updateCaptureSessionConfig();
        resetCaptureSession();
        if (this.mState == 9) {
            openCaptureSession();
        } else {
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mState);
            if (iOrdinal == 2 || iOrdinal == 3) {
                tryForceOpenCameraDevice(false);
            } else if (iOrdinal != 4) {
                debugLog("open() ignored due to being in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(this.mState)), null);
            } else {
                setState(7);
                if (!this.mReleasedCaptureSessions.isEmpty() && !this.mIsConfiguringForClose && this.mCameraDeviceError == 0) {
                    Preconditions.checkState("Camera Device should be open if session close is not complete", this.mCameraDevice != null ? z : false);
                    setState(9);
                    openCaptureSession();
                }
            }
        }
        if (rational != null) {
            this.mCameraControlInternal.mFocusMeteringControl.getClass();
        }
    }

    public final void tryForceOpenCameraDevice(boolean z) throws Throwable {
        debugLog("Attempting to force open the camera.", null);
        if (this.mCameraStateRegistry.tryOpenCamera(this)) {
            openCameraDevice(z);
        } else {
            debugLog("No cameras available. Waiting for available camera before opening camera.", null);
            setState(4);
        }
    }

    public final void tryOpenCameraDevice(boolean z) throws Throwable {
        debugLog("Attempting to open the camera.", null);
        if (this.mCameraAvailability.mCameraAvailable && this.mCameraStateRegistry.tryOpenCamera(this)) {
            openCameraDevice(z);
        } else {
            debugLog("No cameras available. Waiting for available camera before opening camera.", null);
            setState(4);
        }
    }

    public final void updateCaptureSessionConfig() {
        SurfaceRequest.AnonymousClass1 anonymousClass1 = this.mUseCaseAttachState;
        anonymousClass1.getClass();
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) anonymousClass1.val$requestCancellationFuture).entrySet()) {
            UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo) entry.getValue();
            if (useCaseAttachState$UseCaseAttachInfo.mActive && useCaseAttachState$UseCaseAttachInfo.mAttached) {
                String str = (String) entry.getKey();
                validatingBuilder.add(useCaseAttachState$UseCaseAttachInfo.mSessionConfig);
                arrayList.add(str);
            }
        }
        Logger.d("UseCaseAttachState", "Active and attached use case: " + arrayList + " for camera: " + ((String) anonymousClass1.val$requestCancellationCompleter));
        boolean z = validatingBuilder.mTemplateSet;
        Camera2CameraControlImpl camera2CameraControlImpl = this.mCameraControlInternal;
        if (!z || !validatingBuilder.mValid) {
            camera2CameraControlImpl.mTemplate = 1;
            camera2CameraControlImpl.mFocusMeteringControl.mTemplate = 1;
            camera2CameraControlImpl.mCamera2CapturePipeline.getClass();
            this.mCaptureSession.setSessionConfig(camera2CameraControlImpl.getSessionConfig());
            return;
        }
        int i = validatingBuilder.build().mRepeatingCaptureConfig.mTemplateType;
        camera2CameraControlImpl.mTemplate = i;
        camera2CameraControlImpl.mFocusMeteringControl.mTemplate = i;
        camera2CameraControlImpl.mCamera2CapturePipeline.getClass();
        validatingBuilder.add(camera2CameraControlImpl.getSessionConfig());
        this.mCaptureSession.setSessionConfig(validatingBuilder.build());
    }

    public final void updateZslDisabledByUseCaseConfigStatus() {
        Iterator it = this.mUseCaseAttachState.getAttachedUseCaseConfigs().iterator();
        boolean zIsZslDisabled = false;
        while (it.hasNext()) {
            zIsZslDisabled |= ((UseCaseConfig) it.next()).isZslDisabled();
        }
        this.mCameraControlInternal.mZslControl.mIsZslDisabledByUseCaseConfig = zIsZslDisabled;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x010a  */
    public final void setState(int i, AutoValue_CameraState_StateError autoValue_CameraState_StateError, boolean z) throws Throwable {
        CameraInternal.State state;
        CameraInternal.State state2;
        CameraStateRegistry.CameraRegistration cameraRegistration;
        HashMap map = null;
        debugLog("Transitioning camera internal state: " + CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(this.mState) + " --> " + CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(i), null);
        if (Trace.isEnabled()) {
            Trace.setCounter("CX:C2State[" + this + "]", CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i));
            if (autoValue_CameraState_StateError != null) {
                this.mTraceStateErrorCount++;
            }
            if (this.mTraceStateErrorCount > 0) {
                Trace.setCounter("CX:C2StateErrorCode[" + this + "]", autoValue_CameraState_StateError != null ? autoValue_CameraState_StateError.code : 0);
            }
        }
        this.mState = i;
        switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) {
            case 0:
                state = CameraInternal.State.RELEASED;
                break;
            case 1:
                state = CameraInternal.State.RELEASING;
                break;
            case 2:
                state = CameraInternal.State.CLOSED;
                break;
            case 3:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case 4:
            case 5:
                state = CameraInternal.State.CLOSING;
                break;
            case 6:
            case 7:
                state = CameraInternal.State.OPENING;
                break;
            case 8:
                state = CameraInternal.State.OPEN;
                break;
            case 9:
                state = CameraInternal.State.CONFIGURED;
                break;
            default:
                throw new IllegalStateException("Unknown state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(i)));
        }
        CameraStateRegistry cameraStateRegistry = this.mCameraStateRegistry;
        synchronized (cameraStateRegistry.mLock) {
            try {
                int i2 = cameraStateRegistry.mAvailableCameras;
                if (state == CameraInternal.State.RELEASED) {
                    CameraStateRegistry.CameraRegistration cameraRegistration2 = (CameraStateRegistry.CameraRegistration) cameraStateRegistry.mCameraStates.remove(this);
                    if (cameraRegistration2 != null) {
                        cameraStateRegistry.recalculateAvailableCameras();
                        state2 = cameraRegistration2.mState;
                    } else {
                        state2 = null;
                    }
                } else {
                    CameraStateRegistry.CameraRegistration cameraRegistration3 = (CameraStateRegistry.CameraRegistration) cameraStateRegistry.mCameraStates.get(this);
                    Preconditions.checkNotNull(cameraRegistration3, "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()");
                    CameraInternal.State state3 = cameraRegistration3.mState;
                    cameraRegistration3.mState = state;
                    CameraInternal.State state4 = CameraInternal.State.OPENING;
                    if (state == state4) {
                        Preconditions.checkState("Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()", state.mHoldsCameraSlot || state3 == state4);
                    }
                    if (state3 != state) {
                        CameraStateRegistry.traceState(this, state);
                        cameraStateRegistry.recalculateAvailableCameras();
                    }
                    state2 = state3;
                }
                if (state2 != state) {
                    if (cameraStateRegistry.mCameraCoordinator.journalMode == 2 && state == CameraInternal.State.CONFIGURED) {
                        String pairedConcurrentCameraId = cameraStateRegistry.mCameraCoordinator.getPairedConcurrentCameraId(getCameraInfoInternal().getCameraId());
                        if (pairedConcurrentCameraId != null) {
                            cameraRegistration = cameraStateRegistry.getCameraRegistration(pairedConcurrentCameraId);
                        } else {
                            cameraRegistration = null;
                        }
                    } else {
                        cameraRegistration = null;
                    }
                    if (i2 < 1 && cameraStateRegistry.mAvailableCameras > 0) {
                        map = new HashMap();
                        for (Map.Entry entry : cameraStateRegistry.mCameraStates.entrySet()) {
                            if (((CameraStateRegistry.CameraRegistration) entry.getValue()).mState == CameraInternal.State.PENDING_OPEN) {
                                map.put((Camera) entry.getKey(), (CameraStateRegistry.CameraRegistration) entry.getValue());
                            }
                        }
                    } else if (state == CameraInternal.State.PENDING_OPEN && cameraStateRegistry.mAvailableCameras > 0) {
                        map = new HashMap();
                        map.put(this, (CameraStateRegistry.CameraRegistration) cameraStateRegistry.mCameraStates.get(this));
                    }
                    if (map != null && !z) {
                        map.remove(this);
                    }
                    if (map != null) {
                        for (CameraStateRegistry.CameraRegistration cameraRegistration4 : map.values()) {
                            cameraRegistration4.getClass();
                            try {
                                cameraRegistration4.mNotifyExecutor.execute(new Preview$$ExternalSyntheticLambda0(13, cameraRegistration4.mOnOpenAvailableListener));
                            } catch (RejectedExecutionException e) {
                                Logger.e("CameraStateRegistry", "Unable to notify camera to open.", e);
                            }
                        }
                    }
                    if (cameraRegistration != null) {
                        try {
                            cameraRegistration.mNotifyExecutor.execute(new Preview$$ExternalSyntheticLambda0(14, cameraRegistration.mOnConfigureAvailableListener));
                        } catch (RejectedExecutionException e2) {
                            Logger.e("CameraStateRegistry", "Unable to notify camera to configure.", e2);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ((MutableLiveData) this.mObservableState.val$requestCancellationCompleter).postValue(new LiveDataObservable$Result(state));
        this.mCameraStateMachine.updateState(state, autoValue_CameraState_StateError);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.Camera2CameraImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends CameraDevice.StateCallback {
        public final /* synthetic */ int $r8$classId = 0;
        public final Object this$0;
        public final Object val$completer;

        public AnonymousClass2(Executor executor, CameraDevice.StateCallback stateCallback) {
            this.this$0 = executor;
            this.val$completer = stateCallback;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice cameraDevice) {
            switch (this.$r8$classId) {
                case 0:
                    ((Camera2CameraImpl) this.this$0).debugLog("openCameraConfigAndClose camera closed", null);
                    ((CallbackToFutureAdapter.Completer) this.val$completer).set(null);
                    break;
                default:
                    ((Executor) this.this$0).execute(new CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraDevice, 0));
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice cameraDevice) {
            switch (this.$r8$classId) {
                case 0:
                    ((Camera2CameraImpl) this.this$0).debugLog("openCameraConfigAndClose camera disconnected", null);
                    ((CallbackToFutureAdapter.Completer) this.val$completer).set(null);
                    break;
                default:
                    ((Executor) this.this$0).execute(new CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraDevice, 1));
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice cameraDevice, int i) {
            switch (this.$r8$classId) {
                case 0:
                    ((Camera2CameraImpl) this.this$0).debugLog("openCameraConfigAndClose camera error " + i, null);
                    ((CallbackToFutureAdapter.Completer) this.val$completer).set(null);
                    break;
                default:
                    ((Executor) this.this$0).execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, cameraDevice, i, 6));
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice cameraDevice) {
            int i = this.$r8$classId;
            Object obj = this.this$0;
            switch (i) {
                case 0:
                    Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) obj;
                    SequentialExecutor sequentialExecutor = camera2CameraImpl.mExecutor;
                    camera2CameraImpl.debugLog("openCameraConfigAndClose camera opened", null);
                    CaptureSession captureSession = new CaptureSession(camera2CameraImpl.mDynamicRangesCompat, new Quirks(Collections.EMPTY_LIST), false);
                    SurfaceTexture surfaceTexture = new SurfaceTexture(0);
                    surfaceTexture.setDefaultBufferSize(640, 480);
                    Surface surface = new Surface(surfaceTexture);
                    SurfaceRequest.AnonymousClass2 anonymousClass2 = new SurfaceRequest.AnonymousClass2(surface);
                    Futures.nonCancellationPropagating(anonymousClass2.mTerminationFuture).addListener(new Preview$$ExternalSyntheticLambda1(6, surface, surfaceTexture), HexFormatKt.directExecutor());
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    HashSet hashSet = new HashSet();
                    MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
                    ArrayList arrayList = new ArrayList();
                    MutableTagBundle mutableTagBundleCreate = MutableTagBundle.create();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    Request requestBuilder = AutoValue_SessionConfig_OutputConfig.builder(anonymousClass2);
                    requestBuilder.lazyCacheControl = DynamicRange.SDR;
                    linkedHashSet.add(requestBuilder.build());
                    camera2CameraImpl.debugLog("Start configAndClose.", null);
                    ArrayList arrayList5 = new ArrayList(linkedHashSet);
                    ArrayList arrayList6 = new ArrayList(arrayList2);
                    ArrayList arrayList7 = new ArrayList(arrayList3);
                    ArrayList arrayList8 = new ArrayList(arrayList4);
                    ArrayList arrayList9 = new ArrayList(hashSet);
                    OptionsBundle optionsBundleFrom = OptionsBundle.from(mutableOptionsBundleCreate);
                    ArrayList arrayList10 = new ArrayList(arrayList);
                    TagBundle tagBundle = TagBundle.EMPTY_TAGBUNDLE;
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = mutableTagBundleCreate.mTagMap;
                    for (String str : arrayMap2.keySet()) {
                        arrayMap.put(str, arrayMap2.get(str));
                    }
                    SessionConfig sessionConfig = new SessionConfig(arrayList5, arrayList6, arrayList7, arrayList8, new CaptureConfig(arrayList9, optionsBundleFrom, 1, arrayList10, false, new TagBundle(arrayMap), null), null, null, null);
                    Http2Connection.Builder builder = camera2CameraImpl.mCaptureSessionOpenerBuilder;
                    ChainingListenableFuture chainingListenableFutureTransformAsync = Futures.transformAsync(FutureChain.from(CallbackToFutureAdapter.getFuture(new Futures$$ExternalSyntheticLambda3(captureSession.open(sessionConfig, cameraDevice, new SynchronizedCaptureSessionImpl((Quirks) builder.sink, (Quirks) builder.listener, (Http2Connection.Builder) builder.source, (SequentialExecutor) builder.taskRunner, (HandlerScheduledExecutorService) builder.socket, (Handler) builder.connectionName)), 0))), new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(1, captureSession, anonymousClass2), sequentialExecutor);
                    Objects.requireNonNull(cameraDevice);
                    chainingListenableFutureTransformAsync.addListener(new Preview$$ExternalSyntheticLambda0(4, cameraDevice), sequentialExecutor);
                    break;
                default:
                    ((Executor) obj).execute(new CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(this, cameraDevice, 2));
                    break;
            }
        }

        public AnonymousClass2(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter.Completer completer) {
            this.this$0 = camera2CameraImpl;
            this.val$completer = completer;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.Camera2CameraImpl$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 implements FutureCallback {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Camera2CameraImpl this$0;
        public final /* synthetic */ CaptureSession val$captureSession;

        public /* synthetic */ AnonymousClass3(Camera2CameraImpl camera2CameraImpl, CaptureSession captureSession, int i) {
            this.$r8$classId = i;
            this.this$0 = camera2CameraImpl;
            this.val$captureSession = captureSession;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0033  */
        /* JADX WARN: Code duplicated, block: B:15:0x003d  */
        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public final void onFailure(Throwable th) throws Throwable {
            Camera2CameraImpl camera2CameraImpl;
            HandlerScheduledExecutorService handlerScheduledExecutorServiceMainThreadExecutor;
            SessionConfig.ErrorListener errorListener;
            switch (this.$r8$classId) {
                case 0:
                    break;
                default:
                    SessionConfig sessionConfig = null;
                    if (th instanceof DeferrableSurface.SurfaceClosedException) {
                        Camera2CameraImpl camera2CameraImpl2 = this.this$0;
                        DeferrableSurface deferrableSurface = ((DeferrableSurface.SurfaceClosedException) th).mDeferrableSurface;
                        for (SessionConfig sessionConfig2 : camera2CameraImpl2.mUseCaseAttachState.getAttachedSessionConfigs()) {
                            if (sessionConfig2.getSurfaces().contains(deferrableSurface)) {
                                sessionConfig = sessionConfig2;
                                if (sessionConfig != null) {
                                    camera2CameraImpl = this.this$0;
                                    handlerScheduledExecutorServiceMainThreadExecutor = HexFormatKt.mainThreadExecutor();
                                    errorListener = sessionConfig.mErrorListener;
                                    if (errorListener != null) {
                                        camera2CameraImpl.debugLog("Posting surface closed", new Throwable());
                                        handlerScheduledExecutorServiceMainThreadExecutor.execute(new Preview$$ExternalSyntheticLambda1(9, errorListener, sessionConfig));
                                    }
                                }
                                break;
                            }
                        }
                        if (sessionConfig != null) {
                            camera2CameraImpl = this.this$0;
                            handlerScheduledExecutorServiceMainThreadExecutor = HexFormatKt.mainThreadExecutor();
                            errorListener = sessionConfig.mErrorListener;
                            if (errorListener != null) {
                                camera2CameraImpl.debugLog("Posting surface closed", new Throwable());
                                handlerScheduledExecutorServiceMainThreadExecutor.execute(new Preview$$ExternalSyntheticLambda1(9, errorListener, sessionConfig));
                            }
                        }
                    } else if (th instanceof CancellationException) {
                        this.this$0.debugLog("Unable to configure camera cancelled", null);
                    } else {
                        if (this.this$0.mState == 9) {
                            this.this$0.setState(9, new AutoValue_CameraState_StateError(4, th), true);
                        }
                        Logger.e("Camera2CameraImpl", "Unable to configure camera " + this.this$0, th);
                        Camera2CameraImpl camera2CameraImpl3 = this.this$0;
                        if (camera2CameraImpl3.mCaptureSession == this.val$captureSession) {
                            camera2CameraImpl3.resetCaptureSession();
                        }
                    }
                    break;
            }
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public final void onSuccess(Object obj) throws Throwable {
            switch (this.$r8$classId) {
                case 0:
                    this.this$0.mReleasedCaptureSessions.remove(this.val$captureSession);
                    int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.this$0.mState);
                    if (iOrdinal != 1 && iOrdinal != 4) {
                        if (iOrdinal == 5 || (iOrdinal == 6 && this.this$0.mCameraDeviceError != 0)) {
                            this.this$0.debugLog("Camera reopen required. Checking if the current camera can be closed safely.", null);
                        }
                    }
                    if (this.this$0.mReleasedCaptureSessions.isEmpty()) {
                        Camera2CameraImpl camera2CameraImpl = this.this$0;
                        if (camera2CameraImpl.mCameraDevice != null) {
                            camera2CameraImpl.debugLog("closing camera", null);
                            this.this$0.mCameraDevice.close();
                            this.this$0.mCameraDevice = null;
                        }
                    }
                    break;
                default:
                    Camera2CameraImpl camera2CameraImpl2 = this.this$0;
                    if (camera2CameraImpl2.mCameraCoordinator.journalMode == 2 && camera2CameraImpl2.mState == 9) {
                        this.this$0.setState(10);
                        break;
                    }
                    break;
            }
        }

        private final void onFailure$androidx$camera$camera2$internal$Camera2CameraImpl$3(Throwable th) {
        }
    }
}
