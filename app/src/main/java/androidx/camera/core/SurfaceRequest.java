package androidx.camera.core;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.util.Range;
import android.util.Size;
import android.view.Menu;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.activity.compose.BackHandlerKt;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.SupportedSurfaceCombination;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceEdge$$ExternalSyntheticLambda0;
import androidx.camera.core.processing.SurfaceOutputImpl;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.view.TextureViewImplementation;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.SimpleArrayMap;
import androidx.collection.Values;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.internal.MaterialAnchoredDraggableState$anchoredDrag$3;
import androidx.compose.material3.internal.MaterialAnchoredDraggableState$anchoredDrag$4;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.NodeChain;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.emoji2.text.EmojiProcessor$MarkExclusionCallback;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzt;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.zxing.WriterException;
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
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__AppendableKt;
import okhttp3.Dispatcher;
import okhttp3.Request;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceRequest {
    public final CameraInternal mCamera;
    public final DynamicRange mDynamicRange;
    public final AnonymousClass2 mInternalDeferrableSurface;
    public final boolean mIsPrimary;
    public final Object mLock = new Object();
    public final CallbackToFutureAdapter.Completer mRequestCancellationCompleter;
    public final Size mResolution;
    public final CallbackToFutureAdapter.SafeFuture mSessionStatusFuture;
    public final CallbackToFutureAdapter.Completer mSurfaceCompleter;
    public final CallbackToFutureAdapter.SafeFuture mSurfaceFuture;
    public final CallbackToFutureAdapter.Completer mSurfaceRecreationCompleter;
    public AutoValue_SurfaceRequest_TransformationInfo mTransformationInfo;
    public Executor mTransformationInfoExecutor;
    public TransformationInfoListener mTransformationInfoListener;

    /* JADX INFO: renamed from: androidx.camera.core.SurfaceRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class AnonymousClass1 implements CameraCaptureResult, FutureCallback, Observable, SubcomposeSlotReusePolicy, CancellationHandle {
        public final /* synthetic */ int $r8$classId;
        public Object val$requestCancellationCompleter;
        public Object val$requestCancellationFuture;

        public /* synthetic */ AnonymousClass1(int i, Object obj, Object obj2) {
            this.$r8$classId = i;
            this.val$requestCancellationFuture = obj;
            this.val$requestCancellationCompleter = obj2;
        }

        public static void checkPreconditions(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) {
            cameraDevice.getClass();
            SessionConfigurationCompat.SessionConfigurationCompatImpl sessionConfigurationCompatImpl = sessionConfigurationCompat.mImpl;
            sessionConfigurationCompatImpl.getStateCallback().getClass();
            List outputConfigurations = sessionConfigurationCompatImpl.getOutputConfigurations();
            if (outputConfigurations == null) {
                throw new IllegalArgumentException("Invalid output configurations");
            }
            if (sessionConfigurationCompatImpl.getExecutor() == null) {
                throw new IllegalArgumentException("Invalid executor");
            }
            String id = cameraDevice.getId();
            Iterator it = outputConfigurations.iterator();
            while (it.hasNext()) {
                String physicalCameraId = ((OutputConfigurationCompat) it.next()).mImpl.getPhysicalCameraId();
                if (physicalCameraId != null && !physicalCameraId.isEmpty()) {
                    Logger.w("CameraDeviceCompat", "Camera " + id + ": Camera doesn't support physicalCameraId " + physicalCameraId + ". Ignoring.");
                }
            }
        }

        public static ArrayList unpackSurfaces(List list) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((OutputConfigurationCompat) it.next()).mImpl.getSurface());
            }
            return arrayList;
        }

        @Override // androidx.camera.core.impl.Observable
        public void addObserver(Executor executor, Observable.Observer observer) {
            synchronized (((HashMap) this.val$requestCancellationFuture)) {
                LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = (LiveDataObservable$LiveDataObserverAdapter) ((HashMap) this.val$requestCancellationFuture).get(observer);
                if (liveDataObservable$LiveDataObserverAdapter != null) {
                    liveDataObservable$LiveDataObserverAdapter.mActive.set(false);
                }
                LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter2 = new LiveDataObservable$LiveDataObserverAdapter(executor, (ZoomControl) observer);
                ((HashMap) this.val$requestCancellationFuture).put(observer, liveDataObservable$LiveDataObserverAdapter2);
                HexFormatKt.mainThreadExecutor().execute(new LiveDataObservable$$ExternalSyntheticLambda1(this, liveDataObservable$LiveDataObserverAdapter, liveDataObservable$LiveDataObserverAdapter2, 0));
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public Object anchoredDrag$material3(FlingBehavior flingBehavior, float f, ContinuationImpl continuationImpl) {
            MaterialAnchoredDraggableState$anchoredDrag$3 materialAnchoredDraggableState$anchoredDrag$3;
            Ref$FloatRef ref$FloatRef;
            if (continuationImpl instanceof MaterialAnchoredDraggableState$anchoredDrag$3) {
                materialAnchoredDraggableState$anchoredDrag$3 = (MaterialAnchoredDraggableState$anchoredDrag$3) continuationImpl;
                int i = materialAnchoredDraggableState$anchoredDrag$3.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    materialAnchoredDraggableState$anchoredDrag$3.label = i - Integer.MIN_VALUE;
                } else {
                    materialAnchoredDraggableState$anchoredDrag$3 = new MaterialAnchoredDraggableState$anchoredDrag$3(this, continuationImpl);
                }
            } else {
                materialAnchoredDraggableState$anchoredDrag$3 = new MaterialAnchoredDraggableState$anchoredDrag$3(this, continuationImpl);
            }
            Object obj = materialAnchoredDraggableState$anchoredDrag$3.result;
            int i2 = materialAnchoredDraggableState$anchoredDrag$3.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                NodeChain nodeChain = (NodeChain) this.val$requestCancellationCompleter;
                MaterialAnchoredDraggableState$anchoredDrag$4 materialAnchoredDraggableState$anchoredDrag$4 = new MaterialAnchoredDraggableState$anchoredDrag$4(ref$FloatRef2, flingBehavior, this, f, null);
                materialAnchoredDraggableState$anchoredDrag$3.L$0 = ref$FloatRef2;
                materialAnchoredDraggableState$anchoredDrag$3.label = 1;
                Object objAnchoredDrag$default = NodeChain.anchoredDrag$default(nodeChain, materialAnchoredDraggableState$anchoredDrag$4, materialAnchoredDraggableState$anchoredDrag$3);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAnchoredDrag$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
                ref$FloatRef = ref$FloatRef2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$FloatRef = materialAnchoredDraggableState$anchoredDrag$3.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return new Float(ref$FloatRef.element);
        }

        @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
        public boolean areCompatible(Object obj, Object obj2) {
            LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) this.val$requestCancellationCompleter;
            return Intrinsics.areEqual(lazyLayoutItemContentFactory.getContentType(obj), lazyLayoutItemContentFactory.getContentType(obj2));
        }

        public void at(SheetValue sheetValue, float f) {
            ArrayList arrayList = (ArrayList) this.val$requestCancellationCompleter;
            arrayList.add(sheetValue);
            if (((float[]) this.val$requestCancellationFuture).length < arrayList.size()) {
                this.val$requestCancellationFuture = Arrays.copyOf((float[]) this.val$requestCancellationFuture, arrayList.size() + 2);
            }
            ((float[]) this.val$requestCancellationFuture)[arrayList.size() - 1] = f;
        }

        @Override // androidx.compose.runtime.CancellationHandle
        public void cancel() {
            switch (this.$r8$classId) {
                case 3:
                    MenuHostHelper menuHostHelper = (MenuHostHelper) this.val$requestCancellationCompleter;
                    if (menuHostHelper != null) {
                        ((AtomicBoolean) menuHostHelper.mMenuProviders).set(true);
                        ((ScheduledFuture) menuHostHelper.mOnInvalidateMenuCallback).cancel(true);
                    }
                    this.val$requestCancellationCompleter = null;
                    break;
                default:
                    if (!((AtomicInt) this.val$requestCancellationFuture).compareAndSet(1, 1)) {
                        ((GapComposer$$ExternalSyntheticLambda0) this.val$requestCancellationCompleter).invoke();
                    }
                    break;
            }
        }

        public int captureBurstRequests(ArrayList arrayList, SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
            return ((CameraCaptureSession) this.val$requestCancellationCompleter).captureBurst(arrayList, new CameraBurstCaptureCallback(sequentialExecutor, captureCallback), ((CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21) this.val$requestCancellationFuture).mCompatHandler);
        }

        public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
            CameraDevice cameraDevice = (CameraDevice) this.val$requestCancellationCompleter;
            checkPreconditions(cameraDevice, sessionConfigurationCompat);
            SessionConfigurationCompat.SessionConfigurationCompatImpl sessionConfigurationCompatImpl = sessionConfigurationCompat.mImpl;
            CameraCaptureSessionCompat$StateCallbackExecutorWrapper cameraCaptureSessionCompat$StateCallbackExecutorWrapper = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper(sessionConfigurationCompatImpl.getExecutor(), sessionConfigurationCompatImpl.getStateCallback());
            ArrayList arrayListUnpackSurfaces = unpackSurfaces(sessionConfigurationCompatImpl.getOutputConfigurations());
            CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 = (CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21) this.val$requestCancellationFuture;
            cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21.getClass();
            Handler handler = cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21.mCompatHandler;
            InputConfigurationCompat inputConfiguration = sessionConfigurationCompatImpl.getInputConfiguration();
            try {
                if (inputConfiguration != null) {
                    InputConfiguration inputConfiguration2 = inputConfiguration.mImpl.mObject;
                    inputConfiguration2.getClass();
                    cameraDevice.createReprocessableCaptureSession(inputConfiguration2, arrayListUnpackSurfaces, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
                } else {
                    if (sessionConfigurationCompatImpl.getSessionType() == 1) {
                        cameraDevice.createConstrainedHighSpeedCaptureSession(arrayListUnpackSurfaces, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
                        return;
                    }
                    try {
                        cameraDevice.createCaptureSession(arrayListUnpackSurfaces, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
                    } catch (CameraAccessException e) {
                        throw new CameraAccessExceptionCompat(e);
                    }
                }
            } catch (CameraAccessException e2) {
                throw new CameraAccessExceptionCompat(e2);
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData$AeState getAeState() {
            Integer num = (Integer) ((CaptureResult) this.val$requestCancellationFuture).get(CaptureResult.CONTROL_AE_STATE);
            CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState = CameraCaptureMetaData$AeState.UNKNOWN;
            if (num == null) {
                return cameraCaptureMetaData$AeState;
            }
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                return CameraCaptureMetaData$AeState.INACTIVE;
            }
            if (iIntValue != 1) {
                if (iIntValue == 2) {
                    return CameraCaptureMetaData$AeState.CONVERGED;
                }
                if (iIntValue == 3) {
                    return CameraCaptureMetaData$AeState.LOCKED;
                }
                if (iIntValue == 4) {
                    return CameraCaptureMetaData$AeState.FLASH_REQUIRED;
                }
                if (iIntValue != 5) {
                    Logger.e("C2CameraCaptureResult", "Undefined ae state: " + num);
                    return cameraCaptureMetaData$AeState;
                }
            }
            return CameraCaptureMetaData$AeState.SEARCHING;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData$AfState getAfState() {
            Integer num = (Integer) ((CaptureResult) this.val$requestCancellationFuture).get(CaptureResult.CONTROL_AF_STATE);
            CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState = CameraCaptureMetaData$AfState.UNKNOWN;
            if (num == null) {
                return cameraCaptureMetaData$AfState;
            }
            switch (num.intValue()) {
                case 0:
                    return CameraCaptureMetaData$AfState.INACTIVE;
                case 1:
                case 3:
                    return CameraCaptureMetaData$AfState.SCANNING;
                case 2:
                    return CameraCaptureMetaData$AfState.PASSIVE_FOCUSED;
                case 4:
                    return CameraCaptureMetaData$AfState.LOCKED_FOCUSED;
                case 5:
                    return CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED;
                case 6:
                    return CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED;
                default:
                    Logger.e("C2CameraCaptureResult", "Undefined af state: " + num);
                    return cameraCaptureMetaData$AfState;
            }
        }

        public SessionConfig.ValidatingBuilder getAttachedBuilder() {
            SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : ((LinkedHashMap) this.val$requestCancellationFuture).entrySet()) {
                UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo) entry.getValue();
                if (useCaseAttachState$UseCaseAttachInfo.mAttached) {
                    validatingBuilder.add(useCaseAttachState$UseCaseAttachInfo.mSessionConfig);
                    arrayList.add((String) entry.getKey());
                }
            }
            Logger.d("UseCaseAttachState", "All use case: " + arrayList + " for camera: " + ((String) this.val$requestCancellationCompleter));
            return validatingBuilder;
        }

        public Collection getAttachedSessionConfigs() {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : ((LinkedHashMap) this.val$requestCancellationFuture).entrySet()) {
                if (((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mAttached) {
                    arrayList.add(((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mSessionConfig);
                }
            }
            return Collections.unmodifiableCollection(arrayList);
        }

        public Collection getAttachedUseCaseConfigs() {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : ((LinkedHashMap) this.val$requestCancellationFuture).entrySet()) {
                if (((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mAttached) {
                    arrayList.add(((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mUseCaseConfig);
                }
            }
            return Collections.unmodifiableCollection(arrayList);
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData$AwbState getAwbState() {
            Integer num = (Integer) ((CaptureResult) this.val$requestCancellationFuture).get(CaptureResult.CONTROL_AWB_STATE);
            CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState = CameraCaptureMetaData$AwbState.UNKNOWN;
            if (num == null) {
                return cameraCaptureMetaData$AwbState;
            }
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                return CameraCaptureMetaData$AwbState.INACTIVE;
            }
            if (iIntValue == 1) {
                return CameraCaptureMetaData$AwbState.METERING;
            }
            if (iIntValue == 2) {
                return CameraCaptureMetaData$AwbState.CONVERGED;
            }
            if (iIntValue == 3) {
                return CameraCaptureMetaData$AwbState.LOCKED;
            }
            Logger.e("C2CameraCaptureResult", "Undefined awb state: " + num);
            return cameraCaptureMetaData$AwbState;
        }

        public CameraCharacteristics getCameraCharacteristics(String str) throws CameraAccessExceptionCompat {
            try {
                return ((CameraManager) this.val$requestCancellationCompleter).getCameraCharacteristics(str);
            } catch (CameraAccessException e) {
                throw new CameraAccessExceptionCompat(e);
            }
        }

        public LinkedHashSet getCameras() {
            LinkedHashSet linkedHashSet;
            synchronized (this.val$requestCancellationCompleter) {
                linkedHashSet = new LinkedHashSet(((LinkedHashMap) this.val$requestCancellationFuture).values());
            }
            return linkedHashSet;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CaptureResult getCaptureResult() {
            return (CaptureResult) this.val$requestCancellationFuture;
        }

        public Set getConcurrentCameraIds() {
            return Collections.EMPTY_SET;
        }

        @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
        public void getSlotsToRetain(Values values) {
            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.val$requestCancellationFuture;
            mutableObjectIntMap.clear();
            MutableOrderedScatterSet mutableOrderedScatterSet = (MutableOrderedScatterSet) values.parent;
            Object[] objArr = mutableOrderedScatterSet.elements;
            long[] jArr = mutableOrderedScatterSet.nodes;
            int i = mutableOrderedScatterSet.tail;
            while (i != Integer.MAX_VALUE) {
                int i2 = (int) ((jArr[i] >> 31) & 2147483647L);
                Object obj = objArr[i];
                Object contentType = ((LazyLayoutItemContentFactory) this.val$requestCancellationCompleter).getContentType(obj);
                int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(contentType);
                int i3 = iFindKeyIndex >= 0 ? mutableObjectIntMap.values[iFindKeyIndex] : 0;
                if (i3 == 7) {
                    values.remove(obj);
                } else {
                    mutableObjectIntMap.set(i3 + 1, contentType);
                }
                i = i2;
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public TagBundle getTagBundle() {
            return (TagBundle) this.val$requestCancellationCompleter;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public long getTimestamp() {
            Long l = (Long) ((CaptureResult) this.val$requestCancellationFuture).get(CaptureResult.SENSOR_TIMESTAMP);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }

        public void init(Camera2CameraFactory camera2CameraFactory) {
            synchronized (this.val$requestCancellationCompleter) {
                try {
                    camera2CameraFactory.getClass();
                    for (String str : new LinkedHashSet(camera2CameraFactory.mAvailableCameraIds)) {
                        Logger.d("CameraRepository", "Added camera: " + str);
                        ((LinkedHashMap) this.val$requestCancellationFuture).put(str, camera2CameraFactory.getCamera(str));
                    }
                } catch (CameraUnavailableException e) {
                    throw new InitializationException(e);
                }
            }
        }

        public boolean isUseCaseAttached(String str) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.val$requestCancellationFuture;
            if (linkedHashMap.containsKey(str)) {
                return ((UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(str)).mAttached;
            }
            return false;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            Dispatcher dispatcher = (Dispatcher) this.val$requestCancellationCompleter;
            ((android.view.ActionMode.Callback) dispatcher.executorServiceOrNull).onDestroyActionMode(dispatcher.getActionModeWrapper(actionMode));
            AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) this.val$requestCancellationFuture;
            if (appCompatDelegateImpl.mActionModePopup != null) {
                appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(appCompatDelegateImpl.mShowActionModePopup);
            }
            if (appCompatDelegateImpl.mActionModeView != null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.mFadeAnim;
                if (viewPropertyAnimatorCompat != null) {
                    viewPropertyAnimatorCompat.cancel();
                }
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
                viewPropertyAnimatorCompatAnimate.alpha(0.0f);
                appCompatDelegateImpl.mFadeAnim = viewPropertyAnimatorCompatAnimate;
                viewPropertyAnimatorCompatAnimate.setListener(new AppCompatDelegateImpl.AnonymousClass7(2, this));
            }
            appCompatDelegateImpl.mActionMode = null;
            ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
            appCompatDelegateImpl.updateBackInvokedCallbackState();
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onFailure(Throwable th) {
            switch (this.$r8$classId) {
                case 0:
                    if (th instanceof RequestCancelledException) {
                        Preconditions.checkState(null, ((CallbackToFutureAdapter.SafeFuture) this.val$requestCancellationFuture).cancel(false));
                        return;
                    } else {
                        Preconditions.checkState(null, ((CallbackToFutureAdapter.Completer) this.val$requestCancellationCompleter).set(null));
                        return;
                    }
                case 6:
                    throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
                case 11:
                    Preconditions.checkState("Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th, th instanceof RequestCancelledException);
                    ((Consumer) this.val$requestCancellationCompleter).accept(new AutoValue_SurfaceRequest_Result(1, (Surface) this.val$requestCancellationFuture));
                    return;
                case 16:
                    int i = ((SurfaceEdge) this.val$requestCancellationCompleter).mTargets;
                    if (i == 2 && (th instanceof CancellationException)) {
                        Logger.d("SurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                        return;
                    }
                    Logger.w("SurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + StringsKt__AppendableKt.getHumanReadableName(i), th);
                    return;
                case 17:
                    int i2 = ((SurfaceEdge) this.val$requestCancellationCompleter).mTargets;
                    if (i2 == 2 && (th instanceof CancellationException)) {
                        Logger.d("DualSurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                        return;
                    }
                    Logger.w("DualSurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + StringsKt__AppendableKt.getHumanReadableName(i2), th);
                    return;
                case 19:
                    ((CallbackToFutureAdapter.Completer) this.val$requestCancellationCompleter).setException(th);
                    return;
                default:
                    throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
            }
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewGroup viewGroup = ((AppCompatDelegateImpl) this.val$requestCancellationFuture).mSubDecor;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
            Dispatcher dispatcher = (Dispatcher) this.val$requestCancellationCompleter;
            android.view.ActionMode.Callback callback = (android.view.ActionMode.Callback) dispatcher.executorServiceOrNull;
            SupportActionModeWrapper actionModeWrapper = dispatcher.getActionModeWrapper(actionMode);
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) dispatcher.runningSyncCalls;
            Menu menuWrapperICS = (Menu) simpleArrayMap.get(menu);
            if (menuWrapperICS == null) {
                menuWrapperICS = new MenuWrapperICS((Context) dispatcher.readyAsyncCalls, (MenuBuilder) menu);
                simpleArrayMap.put(menu, menuWrapperICS);
            }
            return callback.onPrepareActionMode(actionModeWrapper, menuWrapperICS);
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onSuccess(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    Preconditions.checkState(null, ((CallbackToFutureAdapter.Completer) this.val$requestCancellationCompleter).set(null));
                    break;
                case 6:
                    ((Surface) this.val$requestCancellationCompleter).release();
                    ((SurfaceTexture) this.val$requestCancellationFuture).release();
                    break;
                case 11:
                    ((Consumer) this.val$requestCancellationCompleter).accept(new AutoValue_SurfaceRequest_Result(0, (Surface) this.val$requestCancellationFuture));
                    break;
                case 16:
                    SurfaceOutputImpl surfaceOutputImpl = (SurfaceOutputImpl) obj;
                    surfaceOutputImpl.getClass();
                    ((DefaultSurfaceProcessor) ((MenuHostHelper) this.val$requestCancellationFuture).mOnInvalidateMenuCallback).onOutputSurface(surfaceOutputImpl);
                    break;
                case 17:
                    SurfaceOutputImpl surfaceOutputImpl2 = (SurfaceOutputImpl) obj;
                    surfaceOutputImpl2.getClass();
                    ((SurfaceProcessorInternal) ((Request) this.val$requestCancellationFuture).url).onOutputSurface(surfaceOutputImpl2);
                    break;
                case 19:
                    ((CallbackToFutureAdapter.Completer) this.val$requestCancellationCompleter).set((CameraX) this.val$requestCancellationFuture);
                    break;
                default:
                    Preconditions.checkState("Unexpected result from SurfaceRequest. Surface was provided twice.", ((AutoValue_SurfaceRequest_Result) obj).resultCode != 3);
                    Logger.d("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                    ((SurfaceTexture) this.val$requestCancellationCompleter).release();
                    TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
                    if (textureViewImplementation.mDetachedSurfaceTexture != null) {
                        textureViewImplementation.mDetachedSurfaceTexture = null;
                    }
                    break;
            }
        }

        public void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) {
            executor.getClass();
            stateCallback.getClass();
            try {
                ((CameraManager) this.val$requestCancellationCompleter).openCamera(str, new Camera2CameraImpl.AnonymousClass2(executor, stateCallback), ((CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21) this.val$requestCancellationFuture).mCompatHandler);
            } catch (CameraAccessException e) {
                throw new CameraAccessExceptionCompat(e);
            }
        }

        public void registerAvailabilityCallback(SequentialExecutor sequentialExecutor, Camera2CameraImpl.CameraAvailability cameraAvailability) {
            CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper;
            CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 = (CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21) this.val$requestCancellationFuture;
            synchronized (cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap) {
                try {
                    availabilityCallbackExecutorWrapper = (CameraManagerCompat.AvailabilityCallbackExecutorWrapper) cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap.get(cameraAvailability);
                    if (availabilityCallbackExecutorWrapper == null) {
                        availabilityCallbackExecutorWrapper = new CameraManagerCompat.AvailabilityCallbackExecutorWrapper(sequentialExecutor, cameraAvailability);
                        cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap.put(cameraAvailability, availabilityCallbackExecutorWrapper);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ((CameraManager) this.val$requestCancellationCompleter).registerAvailabilityCallback(availabilityCallbackExecutorWrapper, cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mCompatHandler);
        }

        @Override // androidx.camera.core.impl.Observable
        public void removeObserver(Observable.Observer observer) {
            synchronized (((HashMap) this.val$requestCancellationFuture)) {
                try {
                    LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = (LiveDataObservable$LiveDataObserverAdapter) ((HashMap) this.val$requestCancellationFuture).remove(observer);
                    if (liveDataObservable$LiveDataObserverAdapter != null) {
                        liveDataObservable$LiveDataObserverAdapter.mActive.set(false);
                        HexFormatKt.mainThreadExecutor().execute(new Preview$$ExternalSyntheticLambda1(14, this, liveDataObservable$LiveDataObserverAdapter));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public int setSingleRepeatingRequest(CaptureRequest captureRequest, SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
            return ((CameraCaptureSession) this.val$requestCancellationCompleter).setRepeatingRequest(captureRequest, new CameraBurstCaptureCallback(sequentialExecutor, captureCallback), ((CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21) this.val$requestCancellationFuture).mCompatHandler);
        }

        public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
            CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper;
            if (availabilityCallback != null) {
                CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 = (CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21) this.val$requestCancellationFuture;
                synchronized (cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap) {
                    availabilityCallbackExecutorWrapper = (CameraManagerCompat.AvailabilityCallbackExecutorWrapper) cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap.remove(availabilityCallback);
                }
            } else {
                availabilityCallbackExecutorWrapper = null;
            }
            if (availabilityCallbackExecutorWrapper != null) {
                availabilityCallbackExecutorWrapper.setDisabled();
            }
            ((CameraManager) this.val$requestCancellationCompleter).unregisterAvailabilityCallback(availabilityCallbackExecutorWrapper);
        }

        public void updateState(CameraInternal.State state, AutoValue_CameraState_StateError autoValue_CameraState_StateError) {
            AutoValue_CameraState autoValue_CameraState;
            switch (state.ordinal()) {
                case 0:
                case 2:
                    autoValue_CameraState = new AutoValue_CameraState(5, autoValue_CameraState_StateError);
                    break;
                case 1:
                case 4:
                    autoValue_CameraState = new AutoValue_CameraState(4, autoValue_CameraState_StateError);
                    break;
                case 3:
                    CameraStateRegistry cameraStateRegistry = (CameraStateRegistry) this.val$requestCancellationCompleter;
                    synchronized (cameraStateRegistry.mLock) {
                        Iterator it = cameraStateRegistry.mCameraStates.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                autoValue_CameraState = new AutoValue_CameraState(1, null);
                            } else if (((CameraStateRegistry.CameraRegistration) ((Map.Entry) it.next()).getValue()).mState == CameraInternal.State.CLOSING) {
                                autoValue_CameraState = new AutoValue_CameraState(2, null);
                            }
                        }
                    }
                    break;
                case 5:
                    autoValue_CameraState = new AutoValue_CameraState(2, autoValue_CameraState_StateError);
                    break;
                case 6:
                case 7:
                    autoValue_CameraState = new AutoValue_CameraState(3, autoValue_CameraState_StateError);
                    break;
                default:
                    throw new IllegalStateException("Unknown internal camera state: " + state);
            }
            Logger.d("CameraStateMachine", "New public camera state " + autoValue_CameraState + " from " + state + " and " + autoValue_CameraState_StateError);
            if (Objects.equals((AutoValue_CameraState) ((MutableLiveData) this.val$requestCancellationFuture).getValue(), autoValue_CameraState)) {
                return;
            }
            Logger.d("CameraStateMachine", "Publishing new public camera state " + autoValue_CameraState);
            ((MutableLiveData) this.val$requestCancellationFuture).postValue(autoValue_CameraState);
        }

        public void updateUseCase(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, AutoValue_StreamSpec autoValue_StreamSpec, List list) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.val$requestCancellationFuture;
            if (linkedHashMap.containsKey(str)) {
                UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = new UseCaseAttachState$UseCaseAttachInfo(sessionConfig, useCaseConfig, autoValue_StreamSpec, list);
                UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo2 = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(str);
                useCaseAttachState$UseCaseAttachInfo.mAttached = useCaseAttachState$UseCaseAttachInfo2.mAttached;
                useCaseAttachState$UseCaseAttachInfo.mActive = useCaseAttachState$UseCaseAttachInfo2.mActive;
                linkedHashMap.put(str, useCaseAttachState$UseCaseAttachInfo);
            }
        }

        public /* synthetic */ AnonymousClass1(int i, Object obj, Object obj2, boolean z) {
            this.$r8$classId = i;
            this.val$requestCancellationCompleter = obj;
            this.val$requestCancellationFuture = obj2;
        }

        public /* synthetic */ AnonymousClass1(int i, boolean z) {
            this.$r8$classId = i;
        }

        public AnonymousClass1(CameraCaptureSession cameraCaptureSession, CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21 cameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21) {
            this.$r8$classId = 7;
            cameraCaptureSession.getClass();
            this.val$requestCancellationCompleter = cameraCaptureSession;
            this.val$requestCancellationFuture = cameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21;
        }

        public AnonymousClass1(GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0) {
            this.$r8$classId = 29;
            this.val$requestCancellationCompleter = gapComposer$$ExternalSyntheticLambda0;
            this.val$requestCancellationFuture = new AtomicInt(0);
        }

        public AnonymousClass1(CameraDevice cameraDevice, CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21) {
            this.$r8$classId = 8;
            cameraDevice.getClass();
            this.val$requestCancellationCompleter = cameraDevice;
            this.val$requestCancellationFuture = cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21;
        }

        public AnonymousClass1(CameraStateRegistry cameraStateRegistry) {
            this.$r8$classId = 5;
            this.val$requestCancellationCompleter = cameraStateRegistry;
            MutableLiveData mutableLiveData = new MutableLiveData();
            this.val$requestCancellationFuture = mutableLiveData;
            mutableLiveData.postValue(new AutoValue_CameraState(5, null));
        }

        public AnonymousClass1(int i) {
            this.$r8$classId = i;
            switch (i) {
                case 14:
                    this.val$requestCancellationCompleter = new MutableLiveData();
                    this.val$requestCancellationFuture = new HashMap();
                    break;
                case 21:
                    this.val$requestCancellationCompleter = new VelocityTracker1D(0);
                    this.val$requestCancellationFuture = new VelocityTracker1D(0);
                    break;
                case 22:
                    this.val$requestCancellationCompleter = new ArrayList();
                    float[] fArr = new float[5];
                    for (int i2 = 0; i2 < 5; i2++) {
                        fArr[i2] = Float.NaN;
                    }
                    this.val$requestCancellationFuture = fArr;
                    break;
                case 27:
                    this.val$requestCancellationCompleter = new LinkedHashMap();
                    this.val$requestCancellationFuture = new LinkedHashMap();
                    break;
                case 28:
                    this.val$requestCancellationCompleter = new MutableScatterMap();
                    this.val$requestCancellationFuture = new MutableScatterMap();
                    break;
                default:
                    this.val$requestCancellationCompleter = new Object();
                    this.val$requestCancellationFuture = new LinkedHashMap();
                    new HashSet();
                    break;
            }
        }

        public AnonymousClass1(Context context, CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21) {
            this.$r8$classId = 9;
            this.val$requestCancellationCompleter = (CameraManager) context.getSystemService("camera");
            this.val$requestCancellationFuture = cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21;
        }

        public AnonymousClass1(String str, int i) {
            this.$r8$classId = i;
            switch (i) {
                case 15:
                    this.val$requestCancellationFuture = new LinkedHashMap();
                    this.val$requestCancellationCompleter = str;
                    break;
                default:
                    this.val$requestCancellationCompleter = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.sQuirks.get(ExtraSupportedOutputSizeQuirk.class);
                    this.val$requestCancellationFuture = new EmojiProcessor$MarkExclusionCallback(str);
                    break;
            }
        }

        public AnonymousClass1(SheetValue sheetValue, Function1 function1) {
            this.$r8$classId = 26;
            ArcSplineKt.spring$default(0.0f, 0.0f, null, 7);
            ArcSplineKt.exponentialDecay$default();
            this.val$requestCancellationCompleter = new NodeChain(sheetValue, function1);
            this.val$requestCancellationFuture = Stack.derivedStateOf(new BasicTextKt$$ExternalSyntheticLambda0(21, this));
        }

        public AnonymousClass1(Context context, Object obj, LinkedHashSet linkedHashSet) {
            CameraManagerCompat cameraManagerCompatFrom;
            this.$r8$classId = 4;
            AsyncTimeout.Companion companion = new AsyncTimeout.Companion(2);
            this.val$requestCancellationCompleter = new HashMap();
            this.val$requestCancellationFuture = companion;
            if (obj instanceof CameraManagerCompat) {
                cameraManagerCompatFrom = (CameraManagerCompat) obj;
            } else {
                cameraManagerCompatFrom = CameraManagerCompat.from(context, BackHandlerKt.getInstance());
            }
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                ((HashMap) this.val$requestCancellationCompleter).put(str, new SupportedSurfaceCombination(context, str, cameraManagerCompatFrom, (AsyncTimeout.Companion) this.val$requestCancellationFuture));
            }
        }

        public AnonymousClass1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory) {
            this.$r8$classId = 23;
            this.val$requestCancellationCompleter = lazyLayoutItemContentFactory;
            MutableObjectIntMap mutableObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
            this.val$requestCancellationFuture = new MutableObjectIntMap();
        }

        public AnonymousClass1(Camera2CameraImpl camera2CameraImpl) {
            this.$r8$classId = 3;
            this.val$requestCancellationFuture = camera2CameraImpl;
            this.val$requestCancellationCompleter = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RequestCancelledException extends RuntimeException {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface TransformationInfoListener {
        void onTransformationInfoUpdate(AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo);
    }

    static {
        Range range = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    }

    public SurfaceRequest(Size size, CameraInternal cameraInternal, boolean z, DynamicRange dynamicRange, SurfaceEdge$$ExternalSyntheticLambda0 surfaceEdge$$ExternalSyntheticLambda0) {
        this.mResolution = size;
        this.mCamera = cameraInternal;
        this.mIsPrimary = z;
        this.mDynamicRange = dynamicRange;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        final int i = 0;
        CallbackToFutureAdapter.SafeFuture future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                switch (i) {
                    case 0:
                        atomicReference.set(completer);
                        return str + "-cancellation";
                    case 1:
                        atomicReference.set(completer);
                        return str + "-status";
                    default:
                        atomicReference.set(completer);
                        return str + "-Surface";
                }
            }
        });
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) atomicReference.get();
        completer.getClass();
        this.mRequestCancellationCompleter = completer;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        final int i2 = 1;
        CallbackToFutureAdapter.SafeFuture future2 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer2) {
                switch (i2) {
                    case 0:
                        atomicReference2.set(completer2);
                        return str + "-cancellation";
                    case 1:
                        atomicReference2.set(completer2);
                        return str + "-status";
                    default:
                        atomicReference2.set(completer2);
                        return str + "-Surface";
                }
            }
        });
        this.mSessionStatusFuture = future2;
        future2.addListener(new zzi(1, future2, new AnonymousClass1(0, completer, future, false)), HexFormatKt.directExecutor());
        CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) atomicReference2.get();
        completer2.getClass();
        final AtomicReference atomicReference3 = new AtomicReference(null);
        final int i3 = 2;
        CallbackToFutureAdapter.SafeFuture future3 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer3) {
                switch (i3) {
                    case 0:
                        atomicReference3.set(completer3);
                        return str + "-cancellation";
                    case 1:
                        atomicReference3.set(completer3);
                        return str + "-status";
                    default:
                        atomicReference3.set(completer3);
                        return str + "-Surface";
                }
            }
        });
        this.mSurfaceFuture = future3;
        CallbackToFutureAdapter.Completer completer3 = (CallbackToFutureAdapter.Completer) atomicReference3.get();
        completer3.getClass();
        this.mSurfaceCompleter = completer3;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, size);
        this.mInternalDeferrableSurface = anonymousClass2;
        ListenableFuture listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(anonymousClass2.mTerminationFuture);
        future3.addListener(new zzi(1, future3, new MenuHostHelper(listenableFutureNonCancellationPropagating, completer2, str, 6)), HexFormatKt.directExecutor());
        listenableFutureNonCancellationPropagating.addListener(new SurfaceRequest$$ExternalSyntheticLambda4(this, 0), HexFormatKt.directExecutor());
        zzt zztVarDirectExecutor = HexFormatKt.directExecutor();
        AtomicReference atomicReference4 = new AtomicReference(null);
        CallbackToFutureAdapter.SafeFuture future4 = CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(5, this, atomicReference4));
        future4.addListener(new zzi(1, future4, new Toolbar.AnonymousClass1(16, surfaceEdge$$ExternalSyntheticLambda0)), zztVarDirectExecutor);
        CallbackToFutureAdapter.Completer completer4 = (CallbackToFutureAdapter.Completer) atomicReference4.get();
        completer4.getClass();
        this.mSurfaceRecreationCompleter = completer4;
    }

    public final void provideSurface(final Surface surface, Executor executor, final Consumer consumer) {
        if (!this.mSurfaceCompleter.set(surface)) {
            CallbackToFutureAdapter.SafeFuture safeFuture = this.mSurfaceFuture;
            if (!safeFuture.isCancelled()) {
                Preconditions.checkState(null, safeFuture.delegate.isDone());
                try {
                    safeFuture.get();
                    final int i = 0;
                    executor.execute(new Runnable() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i) {
                                case 0:
                                    consumer.accept(new AutoValue_SurfaceRequest_Result(3, surface));
                                    break;
                                default:
                                    consumer.accept(new AutoValue_SurfaceRequest_Result(4, surface));
                                    break;
                            }
                        }
                    });
                    return;
                } catch (InterruptedException | ExecutionException unused) {
                    final int i2 = 1;
                    executor.execute(new Runnable() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i2) {
                                case 0:
                                    consumer.accept(new AutoValue_SurfaceRequest_Result(3, surface));
                                    break;
                                default:
                                    consumer.accept(new AutoValue_SurfaceRequest_Result(4, surface));
                                    break;
                            }
                        }
                    });
                    return;
                }
            }
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(11, consumer, surface, false);
        CallbackToFutureAdapter.SafeFuture safeFuture2 = this.mSessionStatusFuture;
        safeFuture2.addListener(new zzi(1, safeFuture2, anonymousClass1), executor);
    }

    public final void setTransformationInfoListener(Executor executor, TransformationInfoListener transformationInfoListener) {
        AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo;
        synchronized (this.mLock) {
            this.mTransformationInfoListener = transformationInfoListener;
            this.mTransformationInfoExecutor = executor;
            autoValue_SurfaceRequest_TransformationInfo = this.mTransformationInfo;
        }
        if (autoValue_SurfaceRequest_TransformationInfo != null) {
            executor.execute(new SurfaceRequest$$ExternalSyntheticLambda0(transformationInfoListener, autoValue_SurfaceRequest_TransformationInfo, 1));
        }
    }

    public final void willNotProvideSurface() {
        this.mSurfaceCompleter.setException(new WriterException("Surface request will not complete."));
    }

    /* JADX INFO: renamed from: androidx.camera.core.SurfaceRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends DeferrableSurface {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object this$0;

        public AnonymousClass2(Surface surface, Size size, int i) {
            super(size, i);
            this.this$0 = surface;
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public final ListenableFuture provideSurface() {
            switch (this.$r8$classId) {
                case 0:
                    return ((SurfaceRequest) this.this$0).mSurfaceFuture;
                default:
                    return Futures.immediateFuture((Surface) this.this$0);
            }
        }

        public AnonymousClass2(Surface surface) {
            super(DeferrableSurface.SIZE_UNDEFINED, 0);
            this.this$0 = surface;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SurfaceRequest surfaceRequest, Size size) {
            super(size, 34);
            this.this$0 = surfaceRequest;
        }
    }
}
