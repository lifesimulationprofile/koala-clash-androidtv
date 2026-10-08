package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Size;
import android.view.ActionMode;
import android.view.Surface;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.foundation.text.contextmenu.internal.FloatingTextActionModeCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.MenuHostHelper;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.lifecycle.MutableLiveData;
import com.github.kr328.clash.remote.StatusClient;
import com.google.android.gms.internal.mlkit_vision_common.zzap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.Composer;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LiveDataObservable$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ LiveDataObservable$$ExternalSyntheticLambda1(DefaultSurfaceProcessor defaultSurfaceProcessor, DynamicRange dynamicRange, CallbackToFutureAdapter.Completer completer) {
        this.$r8$classId = 5;
        Map map = Collections.EMPTY_MAP;
        this.f$0 = defaultSurfaceProcessor;
        this.f$1 = dynamicRange;
        this.f$2 = completer;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                SurfaceRequest.AnonymousClass1 anonymousClass1 = (SurfaceRequest.AnonymousClass1) this.f$0;
                LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = (LiveDataObservable$LiveDataObserverAdapter) this.f$1;
                LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter2 = (LiveDataObservable$LiveDataObserverAdapter) this.f$2;
                MutableLiveData mutableLiveData = (MutableLiveData) anonymousClass1.val$requestCancellationCompleter;
                if (liveDataObservable$LiveDataObserverAdapter != null) {
                    mutableLiveData.removeObserver(liveDataObservable$LiveDataObserverAdapter);
                }
                mutableLiveData.observeForever(liveDataObservable$LiveDataObserverAdapter2);
                return;
            case 1:
                Camera2CameraControlImpl camera2CameraControlImpl = (Camera2CameraControlImpl) this.f$0;
                Executor executor = (Executor) this.f$1;
                CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback) this.f$2;
                PreviewStreamStateObserver$2 previewStreamStateObserver$2 = camera2CameraControlImpl.mCameraCaptureCallbackSet;
                ((HashSet) previewStreamStateObserver$2.val$completer).add(cameraCaptureCallback);
                ((ArrayMap) previewStreamStateObserver$2.val$cameraInfo).put(cameraCaptureCallback, executor);
                return;
            case 2:
                ((CameraCaptureSessionCompat$StateCallbackExecutorWrapper) this.f$0).mWrappedCallback.onSurfacePrepared((CameraCaptureSession) this.f$1, (Surface) this.f$2);
                return;
            case 3:
                Composer composer = (Composer) this.f$0;
                CameraBurstCaptureCallback cameraBurstCaptureCallback = (CameraBurstCaptureCallback) this.f$1;
                ListenableFuture listenableFuture = (ListenableFuture) this.f$2;
                composer.getClass();
                Log.d("RequestMonitor", "RequestListener " + cameraBurstCaptureCallback + " done " + composer);
                ((List) composer.writer).remove(listenableFuture);
                return;
            case 4:
                DefaultSurfaceProcessor defaultSurfaceProcessor = (DefaultSurfaceProcessor) this.f$0;
                Runnable runnable = (Runnable) this.f$1;
                Runnable runnable2 = (Runnable) this.f$2;
                if (defaultSurfaceProcessor.mIsReleased) {
                    runnable.run();
                    return;
                } else {
                    runnable2.run();
                    return;
                }
            case 5:
                DefaultSurfaceProcessor defaultSurfaceProcessor2 = (DefaultSurfaceProcessor) this.f$0;
                DynamicRange dynamicRange = (DynamicRange) this.f$1;
                Map map = Collections.EMPTY_MAP;
                CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.f$2;
                try {
                    defaultSurfaceProcessor2.mGlRenderer.init(dynamicRange);
                    completer.set(null);
                    return;
                } catch (RuntimeException e) {
                    completer.setException(e);
                    return;
                }
            case 6:
                ((MenuHostHelper) this.f$0).createAndSendSurfaceOutput((SurfaceEdge) this.f$1, (Map.Entry) this.f$2);
                return;
            case 7:
                DualSurfaceProcessor dualSurfaceProcessor = (DualSurfaceProcessor) this.f$0;
                DynamicRange dynamicRange2 = (DynamicRange) this.f$1;
                Map map2 = Collections.EMPTY_MAP;
                CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) this.f$2;
                try {
                    dualSurfaceProcessor.mGlRenderer.init(dynamicRange2);
                    completer2.set(null);
                    return;
                } catch (RuntimeException e2) {
                    completer2.setException(e2);
                    return;
                }
            case 8:
                DualSurfaceProcessor dualSurfaceProcessor2 = (DualSurfaceProcessor) this.f$0;
                Runnable runnable3 = (Runnable) this.f$1;
                Runnable runnable4 = (Runnable) this.f$2;
                if (dualSurfaceProcessor2.mIsReleased) {
                    runnable3.run();
                    return;
                } else {
                    runnable4.run();
                    return;
                }
            case 9:
                SurfaceViewImplementation surfaceViewImplementation = (SurfaceViewImplementation) this.f$0;
                SurfaceRequest surfaceRequest = (SurfaceRequest) this.f$1;
                PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2 = (PreviewView$1$$ExternalSyntheticLambda2) this.f$2;
                SurfaceViewImplementation.SurfaceRequestCallback surfaceRequestCallback = surfaceViewImplementation.mSurfaceRequestCallback;
                surfaceRequestCallback.cancelPreviousRequest();
                if (surfaceRequestCallback.mNeedToInvalidate) {
                    surfaceRequestCallback.mNeedToInvalidate = false;
                    surfaceRequest.willNotProvideSurface();
                    surfaceRequest.mSurfaceRecreationCompleter.set(null);
                    return;
                }
                surfaceRequestCallback.mSurfaceRequest = surfaceRequest;
                surfaceRequestCallback.mOnSurfaceNotInUseListener = previewView$1$$ExternalSyntheticLambda2;
                Size size = surfaceRequest.mResolution;
                surfaceRequestCallback.mTargetSize = size;
                surfaceRequestCallback.mWasSurfaceProvided = false;
                if (surfaceRequestCallback.tryToComplete()) {
                    return;
                }
                Logger.d("SurfaceViewImpl", "Wait for new Surface creation.");
                surfaceRequestCallback.this$0.mSurfaceView.getHolder().setFixedSize(size.getWidth(), size.getHeight());
                return;
            case 10:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = (AndroidTextContextMenuToolbarProvider) this.f$0;
                AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl textActionModeCallbackImpl = (AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl) this.f$1;
                AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl textContextMenuSessionImpl = (AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl) this.f$2;
                ActionMode actionModeStartActionMode = androidTextContextMenuToolbarProvider.view.startActionMode(new FloatingTextActionModeCallback(textActionModeCallbackImpl), 1);
                Intrinsics.areEqual(androidTextContextMenuToolbarProvider.actionMode, actionModeStartActionMode);
                if (actionModeStartActionMode == null) {
                    textContextMenuSessionImpl.close();
                    return;
                }
                return;
            default:
                StatusClient statusClient = (StatusClient) this.f$0;
                final zzap zzapVar = (zzap) this.f$1;
                final ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f$2;
                try {
                    FontRequestEmojiCompatConfig fontRequestEmojiCompatConfigCreate = DefaultEmojiCompatConfig.create(statusClient.context);
                    if (fontRequestEmojiCompatConfigCreate == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) ((EmojiCompat.MetadataRepoLoader) fontRequestEmojiCompatConfigCreate.mMetadataLoader);
                    synchronized (fontRequestMetadataLoader.mLock) {
                        fontRequestMetadataLoader.mExecutor = threadPoolExecutor;
                        break;
                    }
                    ((EmojiCompat.MetadataRepoLoader) fontRequestEmojiCompatConfigCreate.mMetadataLoader).load(new zzap() { // from class: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1
                        @Override // com.google.android.gms.internal.mlkit_vision_common.zzap
                        public final void onFailed(Throwable th) {
                            ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                            try {
                                zzapVar.onFailed(th);
                            } finally {
                                threadPoolExecutor2.shutdown();
                            }
                        }

                        @Override // com.google.android.gms.internal.mlkit_vision_common.zzap
                        public final void onLoaded(Dispatcher dispatcher) {
                            ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                            try {
                                zzapVar.onLoaded(dispatcher);
                            } finally {
                                threadPoolExecutor2.shutdown();
                            }
                        }
                    });
                    return;
                } catch (Throwable th) {
                    zzapVar.onFailed(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
        }
    }

    public /* synthetic */ LiveDataObservable$$ExternalSyntheticLambda1(DualSurfaceProcessor dualSurfaceProcessor, DynamicRange dynamicRange, CallbackToFutureAdapter.Completer completer) {
        this.$r8$classId = 7;
        Map map = Collections.EMPTY_MAP;
        this.f$0 = dualSurfaceProcessor;
        this.f$1 = dynamicRange;
        this.f$2 = completer;
    }

    public /* synthetic */ LiveDataObservable$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
