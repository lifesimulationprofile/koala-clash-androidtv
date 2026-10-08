package androidx.activity;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.ZslControlImpl;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceOutputImpl;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.TextureViewImplementation;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$2;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.memory.MemoryCacheService;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.util.concurrent.ListenableFuture;
import io.github.g00fy2.quickie.QRScannerActivity;
import io.github.g00fy2.quickie.QRScannerActivity$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OnBackPressedDispatcher$$ExternalSyntheticLambda0 implements ActivityResultCallback, CallbackToFutureAdapter.Resolver, ImageReaderProxy.OnImageAvailableListener, AsyncFunction, Function, OnSuccessListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ OnBackPressedDispatcher$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction, androidx.arch.core.util.Function
    public ListenableFuture apply(Object obj) {
        return (ListenableFuture) ((Navigator.AnonymousClass1) this.f$0).invoke(obj);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.$r8$classId) {
            case 2:
                Camera2CameraControlImpl camera2CameraControlImpl = (Camera2CameraControlImpl) this.f$0;
                camera2CameraControlImpl.mExecutor.execute(new Preview$$ExternalSyntheticLambda1(4, camera2CameraControlImpl, completer));
                return "updateSessionConfigAsync";
            case 5:
                CameraBurstCaptureCallback cameraBurstCaptureCallback = (CameraBurstCaptureCallback) this.f$0;
                cameraBurstCaptureCallback.mCaptureSequenceCallback = completer;
                return "RequestCompleteListener[" + cameraBurstCaptureCallback + "]";
            case 8:
                SurfaceEdge.SettableSurface settableSurface = (SurfaceEdge.SettableSurface) this.f$0;
                settableSurface.mCompleter = completer;
                return "SettableFuture hashCode: " + settableSurface.hashCode();
            case 9:
                ((SurfaceOutputImpl) this.f$0).mCloseFutureCompleter = completer;
                return "SurfaceOutputImpl close future complete";
            default:
                ((TextureViewImplementation) this.f$0).mNextFrameCompleter.set(completer);
                return "textureViewImpl_waitForNextFrame";
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Iterable, java.lang.Object] */
    public void dispose() {
        Function2 function2 = (Function2) this.f$0;
        synchronized (SnapshotKt.lock) {
            ?? r2 = SnapshotKt.applyObservers;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r2, 10));
            boolean z = false;
            for (Object obj : r2) {
                boolean z2 = true;
                if (!z && Intrinsics.areEqual(obj, function2)) {
                    z = true;
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(obj);
                }
            }
            SnapshotKt.applyObservers = arrayList;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 1:
                ((Function1) ((MutableState) obj2).getValue()).invoke(obj);
                break;
            default:
                int i2 = QRScannerActivity.$r8$clinit;
                ((QRScannerActivity$$ExternalSyntheticLambda0) obj2).invoke((Boolean) obj);
                break;
        }
    }

    public boolean onCommitContent(MemoryCacheService memoryCacheService, int i, Bundle bundle) {
        ContentInfoCompat.BuilderCompat memoryCacheService2;
        AppCompatEditText appCompatEditText = (AppCompatEditText) this.f$0;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((InputContentInfoCompat$InputContentInfoCompatImpl) memoryCacheService.imageLoader).requestPermission();
                Parcelable parcelable = (Parcelable) ((InputContentInfoCompat$InputContentInfoCompatImpl) memoryCacheService.imageLoader).getInputContentInfo();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        InputContentInfoCompat$InputContentInfoCompatImpl inputContentInfoCompat$InputContentInfoCompatImpl = (InputContentInfoCompat$InputContentInfoCompatImpl) memoryCacheService.imageLoader;
        ClipData clipData = new ClipData(inputContentInfoCompat$InputContentInfoCompatImpl.getDescription(), new ClipData.Item(inputContentInfoCompat$InputContentInfoCompatImpl.getContentUri()));
        if (i2 >= 31) {
            memoryCacheService2 = new MemoryCacheService(clipData, 2);
        } else {
            ContentInfoCompat.CompatImpl compatImpl = new ContentInfoCompat.CompatImpl();
            compatImpl.mClip = clipData;
            compatImpl.mSource = 2;
            memoryCacheService2 = compatImpl;
        }
        memoryCacheService2.setLinkUri(inputContentInfoCompat$InputContentInfoCompatImpl.getLinkUri());
        memoryCacheService2.setExtras(bundle);
        return ViewCompat.performReceiveContent(appCompatEditText, memoryCacheService2.build()) == null;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(ImageReaderProxy imageReaderProxy) throws Exception {
        switch (this.$r8$classId) {
            case 4:
                ZslControlImpl zslControlImpl = (ZslControlImpl) this.f$0;
                zslControlImpl.getClass();
                try {
                    ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
                    if (imageProxyAcquireLatestImage != null) {
                        zslControlImpl.mImageRingBuffer.enqueue(imageProxyAcquireLatestImage);
                        return;
                    }
                    return;
                } catch (IllegalStateException e) {
                    Logger.e("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e.getMessage());
                    return;
                }
            case 5:
            default:
                ((SurfaceRequest.AnonymousClass1) this.f$0).getClass();
                try {
                    ImageProxy imageProxyAcquireLatestImage2 = imageReaderProxy.acquireLatestImage();
                    if (imageProxyAcquireLatestImage2 != null) {
                        CharsKt.checkMainThread();
                        Logger.w("CaptureNode", "Discarding ImageProxy which was inadvertently acquired: " + imageProxyAcquireLatestImage2);
                        imageProxyAcquireLatestImage2.close();
                        return;
                    }
                    return;
                } catch (IllegalStateException unused) {
                    return;
                }
            case 6:
                MetadataImageReader metadataImageReader = (MetadataImageReader) this.f$0;
                synchronized (metadataImageReader.mLock) {
                    metadataImageReader.mUnAcquiredAvailableImageCount++;
                    break;
                }
                metadataImageReader.imageIncoming(imageReaderProxy);
                return;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((DiskLruCache$$ExternalSyntheticLambda0) this.f$0).invoke(obj);
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        return (ProcessCameraProvider) ((NavHostControllerKt$NavControllerSaver$2) this.f$0).invoke(obj);
    }
}
