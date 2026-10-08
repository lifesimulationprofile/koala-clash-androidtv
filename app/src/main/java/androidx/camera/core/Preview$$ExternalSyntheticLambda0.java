package androidx.camera.core;

import android.hardware.camera2.CameraDevice;
import android.os.Trace;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ComponentActivity;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceOutputImpl;
import androidx.camera.core.processing.SurfaceProcessorNode$Out;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.material3.internal.ripple.RippleHostView;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.contentcapture.ContentCaptureEvent;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import coil.memory.MemoryCacheService;
import coil.network.HttpException;
import coil.request.Parameters;
import fi.iki.elonen.NanoHTTPD;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ScheduledFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Preview$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Preview$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    private final void run$androidx$camera$core$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$$ExternalSyntheticLambda1() {
        ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer = (ImageAnalysisNonBlockingAnalyzer) this.f$0;
        synchronized (imageAnalysisNonBlockingAnalyzer.mLock) {
            try {
                imageAnalysisNonBlockingAnalyzer.mPostedImage = null;
                ImageProxy imageProxy = imageAnalysisNonBlockingAnalyzer.mCachedImage;
                if (imageProxy != null) {
                    imageAnalysisNonBlockingAnalyzer.mCachedImage = null;
                    imageAnalysisNonBlockingAnalyzer.onValidImageAvailable(imageProxy);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:75:0x016d  */
    /* JADX WARN: Type inference failed for: r0v109, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r0v97, types: [java.lang.Object, kotlin.Lazy] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int[] iArr;
        View viewFindFocus;
        int i = 0;
        Boolean bool = null;
        switch (this.$r8$classId) {
            case 0:
                ((Preview) this.f$0).notifyReset();
                return;
            case 1:
                ComponentActivity.ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl = (ComponentActivity.ReportFullyDrawnExecutorImpl) this.f$0;
                Runnable runnable = reportFullyDrawnExecutorImpl.currentRunnable;
                if (runnable != null) {
                    runnable.run();
                    reportFullyDrawnExecutorImpl.currentRunnable = null;
                    return;
                }
                return;
            case 2:
                super/*android.app.Dialog*/.onBackPressed();
                return;
            case 3:
                Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) this.f$0;
                camera2CameraImpl.mIsConfiguringForClose = false;
                camera2CameraImpl.mIsConfigAndCloseRequired = false;
                camera2CameraImpl.debugLog("OpenCameraConfigAndClose is done, state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(camera2CameraImpl.mState)), null);
                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(camera2CameraImpl.mState);
                if (iOrdinal == 1 || iOrdinal == 4) {
                    Preconditions.checkState(null, camera2CameraImpl.mReleasedCaptureSessions.isEmpty());
                    camera2CameraImpl.finishClose();
                    return;
                } else {
                    if (iOrdinal != 6) {
                        camera2CameraImpl.debugLog("OpenCameraConfigAndClose finished while in state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(camera2CameraImpl.mState)), null);
                        return;
                    }
                    int i2 = camera2CameraImpl.mCameraDeviceError;
                    if (i2 == 0) {
                        camera2CameraImpl.tryOpenCameraDevice(false);
                        return;
                    } else {
                        camera2CameraImpl.debugLog("OpenCameraConfigAndClose in error: ".concat(Camera2CameraImpl.getErrorMessage(i2)), null);
                        camera2CameraImpl.mStateCallback.scheduleCameraReopen();
                        return;
                    }
                }
            case 4:
                ((CameraDevice) this.f$0).close();
                return;
            case 5:
                NanoHTTPD.ServerRunnable serverRunnable = (NanoHTTPD.ServerRunnable) this.f$0;
                if (serverRunnable.hasBinded) {
                    return;
                }
                Preconditions.checkState(null, Camera2CameraImpl.this.mState == 7 || Camera2CameraImpl.this.mState == 6);
                if (((Camera2CameraImpl.StateCallback) serverRunnable.this$0).shouldActiveResume()) {
                    Camera2CameraImpl.this.tryForceOpenCameraDevice(true);
                    return;
                } else {
                    Camera2CameraImpl.this.tryOpenCameraDevice(true);
                    return;
                }
            case 6:
                CaptureSession captureSession = (CaptureSession) this.f$0;
                synchronized (captureSession.mSessionLock) {
                    if (captureSession.mCaptureConfigs.isEmpty()) {
                        return;
                    }
                    try {
                        captureSession.issueBurstCaptureRequest(captureSession.mCaptureConfigs);
                        captureSession.mCaptureConfigs.clear();
                        return;
                    } catch (Throwable th) {
                        captureSession.mCaptureConfigs.clear();
                        throw th;
                    }
                }
            case 7:
                for (SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl : (LinkedHashSet) this.f$0) {
                    synchronizedCaptureSessionImpl.getClass();
                    synchronizedCaptureSessionImpl.onClosed(synchronizedCaptureSessionImpl);
                }
                return;
            case 8:
                ((CameraManagerCompat.AvailabilityCallbackExecutorWrapper) this.f$0).mWrappedCallback.onCameraAccessPrioritiesChanged();
                return;
            case 9:
                Camera2CameraControl camera2CameraControl = (Camera2CameraControl) this.f$0;
                CallbackToFutureAdapter.Completer completer = camera2CameraControl.mCompleter;
                if (completer != null) {
                    completer.set(null);
                    camera2CameraControl.mCompleter = null;
                    return;
                }
                return;
            case 10:
                run$androidx$camera$core$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$$ExternalSyntheticLambda1();
                return;
            case 11:
                ((SurfaceRequest.AnonymousClass1) ((MetadataImageReader.AnonymousClass1) this.f$0).this$0).getClass();
                return;
            case 12:
                ((TakePictureManager) this.f$0).issueNextRequest();
                return;
            case 13:
                Camera2CameraImpl.CameraAvailability cameraAvailability = (Camera2CameraImpl.CameraAvailability) this.f$0;
                if (Camera2CameraImpl.this.mState == 4) {
                    Camera2CameraImpl.this.tryOpenCameraDevice(false);
                    return;
                }
                return;
            case 14:
                PreviewView.AnonymousClass1 anonymousClass1 = (PreviewView.AnonymousClass1) this.f$0;
                if (((Camera2CameraImpl) anonymousClass1.this$0).mState == 9) {
                    ((Camera2CameraImpl) anonymousClass1.this$0).openCaptureSession();
                    return;
                }
                return;
            case 15:
                ((CallbackToFutureAdapter.SafeFuture) this.f$0).cancel(true);
                return;
            case 16:
                ((ScheduledFuture) this.f$0).cancel(true);
                return;
            case 17:
                ((CallbackToFutureAdapter.Completer) this.f$0).set(null);
                return;
            case 18:
                ((SurfaceOutputImpl) this.f$0).close();
                return;
            case 19:
                DefaultSurfaceProcessor defaultSurfaceProcessor = (DefaultSurfaceProcessor) this.f$0;
                defaultSurfaceProcessor.mIsReleased = true;
                defaultSurfaceProcessor.checkReadyToRelease();
                return;
            case 20:
                SurfaceProcessorNode$Out surfaceProcessorNode$Out = (SurfaceProcessorNode$Out) ((MenuHostHelper) this.f$0).mProviderToLifecycleContainers;
                if (surfaceProcessorNode$Out != null) {
                    Iterator it = surfaceProcessorNode$Out.values().iterator();
                    while (it.hasNext()) {
                        ((SurfaceEdge) it.next()).close();
                    }
                    return;
                }
                return;
            case 21:
                DualSurfaceProcessor dualSurfaceProcessor = (DualSurfaceProcessor) this.f$0;
                dualSurfaceProcessor.mIsReleased = true;
                dualSurfaceProcessor.checkReadyToRelease$1();
                return;
            case 22:
                SurfaceProcessorNode$Out surfaceProcessorNode$Out2 = (SurfaceProcessorNode$Out) ((Request) this.f$0).tags;
                if (surfaceProcessorNode$Out2 != null) {
                    Iterator it2 = surfaceProcessorNode$Out2.values().iterator();
                    while (it2.hasNext()) {
                        ((SurfaceEdge) it2.next()).close();
                    }
                    return;
                }
                return;
            case 23:
                ((PreviewView$1$$ExternalSyntheticLambda2) this.f$0).onSurfaceNotInUse();
                return;
            case 24:
                ActionMode actionMode = ((AndroidTextContextMenuToolbarProvider) this.f$0).actionMode;
                if (actionMode != null) {
                    actionMode.finish();
                    return;
                }
                return;
            case 25:
                RippleHostView.setRippleState$lambda$1((RippleHostView) this.f$0);
                return;
            case 26:
                AndroidContentCaptureManager androidContentCaptureManager = (AndroidContentCaptureManager) this.f$0;
                boolean zIsEnabled$ui = androidContentCaptureManager.isEnabled$ui();
                AndroidComposeView androidComposeView = androidContentCaptureManager.view;
                if (zIsEnabled$ui) {
                    Trace.beginSection("ContentCapture:changeChecker");
                    try {
                        androidComposeView.measureAndLayout(true);
                        MutableIntObjectMap mutableIntObjectMap = androidContentCaptureManager.previousSemanticsNodes;
                        int[] iArr2 = mutableIntObjectMap.keys;
                        long[] jArr = mutableIntObjectMap.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i3 = 0;
                            while (true) {
                                long j = jArr[i3];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                                    int i5 = i;
                                    while (i5 < i4) {
                                        if ((255 & j) < 128) {
                                            int i6 = iArr2[(i3 << 3) + i5];
                                            if (!androidContentCaptureManager.getCurrentSemanticsNodes$ui().containsKey(i6)) {
                                                androidContentCaptureManager.bufferedEvents.add(new ContentCaptureEvent(i6, androidContentCaptureManager.currentSemanticsNodesSnapshotTimestampMillis, 2, null));
                                                androidContentCaptureManager.boundsUpdateChannel.mo842trySendJP2dKIU(Unit.INSTANCE);
                                            }
                                        }
                                        j >>= 8;
                                        i5++;
                                        iArr2 = iArr2;
                                    }
                                    iArr = iArr2;
                                    if (i4 == 8) {
                                    }
                                } else {
                                    iArr = iArr2;
                                }
                                if (i3 != length) {
                                    i3++;
                                    iArr2 = iArr;
                                    i = 0;
                                }
                            }
                        }
                        Trace.beginSection("ContentCapture:sendAppearEvents");
                        try {
                            androidContentCaptureManager.sendContentCaptureAppearEvents(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
                            Unit unit = Unit.INSTANCE;
                            Trace.endSection();
                            androidContentCaptureManager.checkForContentCapturePropertyChanges(androidContentCaptureManager.getCurrentSemanticsNodes$ui());
                            androidContentCaptureManager.updateSemanticsCopy();
                            androidContentCaptureManager.checkingForSemanticsChanges = false;
                            return;
                        } finally {
                            Trace.endSection();
                        }
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
                return;
            case 27:
                ((AbstractComposeView) this.f$0).attachedToWindow();
                return;
            case 28:
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) this.f$0;
                Trace.beginSection("measureAndLayout");
                try {
                    androidComposeViewAccessibilityDelegateCompat.view.measureAndLayout(true);
                    Unit unit2 = Unit.INSTANCE;
                    Trace.endSection();
                    Trace.beginSection("checkForSemanticsChanges");
                    try {
                        androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
                        Trace.endSection();
                        androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
                        return;
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    Trace.endSection();
                    throw th4;
                }
            default:
                TextInputServiceAndroid textInputServiceAndroid = (TextInputServiceAndroid) this.f$0;
                MenuHostHelper menuHostHelper = textInputServiceAndroid.inputMethodManager;
                textInputServiceAndroid.frameCallback = null;
                MutableVector mutableVector = textInputServiceAndroid.textInputCommandQueue;
                View view = textInputServiceAndroid.view;
                if (!view.isFocused() && (viewFindFocus = view.getRootView().findFocus()) != null && viewFindFocus.onCheckIsTextEditor()) {
                    mutableVector.clear();
                    return;
                }
                Object[] objArr = mutableVector.content;
                int i7 = mutableVector.size;
                Boolean boolValueOf = null;
                for (int i8 = 0; i8 < i7; i8++) {
                    TextInputServiceAndroid.TextInputCommand textInputCommand = (TextInputServiceAndroid.TextInputCommand) objArr[i8];
                    int iOrdinal2 = textInputCommand.ordinal();
                    if (iOrdinal2 != 0) {
                        if (iOrdinal2 == 1) {
                            bool = Boolean.FALSE;
                        } else {
                            if (iOrdinal2 != 2 && iOrdinal2 != 3) {
                                throw new HttpException();
                            }
                            if (!Intrinsics.areEqual(bool, Boolean.FALSE)) {
                                boolValueOf = Boolean.valueOf(textInputCommand == TextInputServiceAndroid.TextInputCommand.ShowKeyboard);
                            }
                        }
                    } else {
                        bool = Boolean.TRUE;
                    }
                    boolValueOf = bool;
                }
                mutableVector.clear();
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ((InputMethodManager) menuHostHelper.mMenuProviders.getValue()).restartInput((View) menuHostHelper.mOnInvalidateMenuCallback);
                }
                if (boolValueOf != null) {
                    if (boolValueOf.booleanValue()) {
                        ((MemoryCacheService) ((Parameters.Builder) menuHostHelper.mProviderToLifecycleContainers).entries).show();
                    } else {
                        ((MemoryCacheService) ((Parameters.Builder) menuHostHelper.mProviderToLifecycleContainers).entries).hide();
                    }
                }
                if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    ((InputMethodManager) menuHostHelper.mMenuProviders.getValue()).restartInput((View) menuHostHelper.mOnInvalidateMenuCallback);
                    return;
                }
                return;
        }
    }
}
