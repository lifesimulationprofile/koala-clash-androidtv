package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.media.ImageWriter;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import coil.intercept.RealInterceptorChain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ZslControlImpl {
    public final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    public final MenuHostHelper mImageRingBuffer;
    public final boolean mIsPrivateReprocessingSupported;
    public boolean mIsZslDisabledByUseCaseConfig = false;
    public MetadataImageReader.AnonymousClass1 mMetadataMatchingCaptureCallback;
    public SurfaceRequest.AnonymousClass2 mReprocessingImageDeferrableSurface;
    public RealInterceptorChain mReprocessingImageReader;
    public ImageWriter mReprocessingImageWriter;
    public final boolean mShouldZslDisabledByQuirks;

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.ZslControlImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends CameraCaptureSession.StateCallback {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(CameraCaptureSession cameraCaptureSession) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.StateCallback) obj).onActive(cameraCaptureSession);
                    }
                    break;
                case 2:
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) this.this$0;
                    synchronizedCaptureSessionImpl.createCaptureSessionCompat(cameraCaptureSession);
                    synchronizedCaptureSessionImpl.onActive(synchronizedCaptureSessionImpl);
                    break;
                default:
                    super.onActive(cameraCaptureSession);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.StateCallback) obj).onCaptureQueueEmpty(cameraCaptureSession);
                    }
                    break;
                case 2:
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) this.this$0;
                    synchronizedCaptureSessionImpl.createCaptureSessionCompat(cameraCaptureSession);
                    synchronizedCaptureSessionImpl.onCaptureQueueEmpty(synchronizedCaptureSessionImpl);
                    break;
                default:
                    super.onCaptureQueueEmpty(cameraCaptureSession);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.StateCallback) obj).onClosed(cameraCaptureSession);
                    }
                    break;
                case 2:
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) this.this$0;
                    synchronizedCaptureSessionImpl.createCaptureSessionCompat(cameraCaptureSession);
                    synchronizedCaptureSessionImpl.onClosed(synchronizedCaptureSessionImpl);
                    break;
                default:
                    super.onClosed(cameraCaptureSession);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            CallbackToFutureAdapter.Completer completer;
            switch (this.$r8$classId) {
                case 0:
                    return;
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.StateCallback) obj).onConfigureFailed(cameraCaptureSession);
                    }
                    return;
                default:
                    try {
                        ((SynchronizedCaptureSessionImpl) this.this$0).createCaptureSessionCompat(cameraCaptureSession);
                        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) this.this$0;
                        synchronizedCaptureSessionImpl.onConfigureFailed(synchronizedCaptureSessionImpl);
                        synchronized (((SynchronizedCaptureSessionImpl) this.this$0).mLock) {
                            Preconditions.checkNotNull(((SynchronizedCaptureSessionImpl) this.this$0).mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                            SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = (SynchronizedCaptureSessionImpl) this.this$0;
                            completer = synchronizedCaptureSessionImpl2.mOpenCaptureSessionCompleter;
                            synchronizedCaptureSessionImpl2.mOpenCaptureSessionCompleter = null;
                            break;
                        }
                        return;
                    } finally {
                        synchronized (((SynchronizedCaptureSessionImpl) this.this$0).mLock) {
                            Preconditions.checkNotNull(((SynchronizedCaptureSessionImpl) this.this$0).mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                            SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl3 = (SynchronizedCaptureSessionImpl) this.this$0;
                            completer = synchronizedCaptureSessionImpl3.mOpenCaptureSessionCompleter;
                            synchronizedCaptureSessionImpl3.mOpenCaptureSessionCompleter = null;
                            completer.setException(new IllegalStateException("onConfigureFailed"));
                        }
                    }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
            CallbackToFutureAdapter.Completer completer;
            switch (this.$r8$classId) {
                case 0:
                    Surface inputSurface = cameraCaptureSession.getInputSurface();
                    if (inputSurface != null) {
                        ((ZslControlImpl) this.this$0).mReprocessingImageWriter = ImageWriter.newInstance(inputSurface, 1);
                        return;
                    }
                    return;
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.StateCallback) obj).onConfigured(cameraCaptureSession);
                    }
                    return;
                default:
                    try {
                        ((SynchronizedCaptureSessionImpl) this.this$0).createCaptureSessionCompat(cameraCaptureSession);
                        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) this.this$0;
                        synchronizedCaptureSessionImpl.onConfigured(synchronizedCaptureSessionImpl);
                        synchronized (((SynchronizedCaptureSessionImpl) this.this$0).mLock) {
                            Preconditions.checkNotNull(((SynchronizedCaptureSessionImpl) this.this$0).mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                            SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = (SynchronizedCaptureSessionImpl) this.this$0;
                            completer = synchronizedCaptureSessionImpl2.mOpenCaptureSessionCompleter;
                            synchronizedCaptureSessionImpl2.mOpenCaptureSessionCompleter = null;
                            break;
                        }
                        return;
                    } finally {
                        synchronized (((SynchronizedCaptureSessionImpl) this.this$0).mLock) {
                            Preconditions.checkNotNull(((SynchronizedCaptureSessionImpl) this.this$0).mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                            SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl3 = (SynchronizedCaptureSessionImpl) this.this$0;
                            completer = synchronizedCaptureSessionImpl3.mOpenCaptureSessionCompleter;
                            synchronizedCaptureSessionImpl3.mOpenCaptureSessionCompleter = null;
                            completer.set(null);
                        }
                    }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(CameraCaptureSession cameraCaptureSession) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.StateCallback) obj).onReady(cameraCaptureSession);
                    }
                    break;
                case 2:
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) this.this$0;
                    synchronizedCaptureSessionImpl.createCaptureSessionCompat(cameraCaptureSession);
                    synchronizedCaptureSessionImpl.onReady(synchronizedCaptureSessionImpl);
                    break;
                default:
                    super.onReady(cameraCaptureSession);
                    break;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
            switch (this.$r8$classId) {
                case 1:
                    ArrayList arrayList = (ArrayList) this.this$0;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraCaptureSession.StateCallback) obj).onSurfacePrepared(cameraCaptureSession, surface);
                    }
                    break;
                case 2:
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) this.this$0;
                    synchronizedCaptureSessionImpl.createCaptureSessionCompat(cameraCaptureSession);
                    synchronizedCaptureSessionImpl.onSurfacePrepared(synchronizedCaptureSessionImpl, surface);
                    break;
                default:
                    super.onSurfacePrepared(cameraCaptureSession, surface);
                    break;
            }
        }

        public AnonymousClass1(List list) {
            this.$r8$classId = 1;
            this.this$0 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback) it.next();
                if (!(stateCallback instanceof CameraCaptureSessionStateCallbacks$NoOpSessionStateCallback)) {
                    ((ArrayList) this.this$0).add(stateCallback);
                }
            }
        }

        private final void onConfigureFailed$androidx$camera$camera2$internal$ZslControlImpl$1(CameraCaptureSession cameraCaptureSession) {
        }
    }

    public ZslControlImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z;
        this.mIsPrivateReprocessingSupported = false;
        this.mShouldZslDisabledByQuirks = false;
        this.mCameraCharacteristicsCompat = cameraCharacteristicsCompat;
        int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr == null) {
            z = false;
            break;
        }
        int length = iArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else {
                if (iArr[i] == 4) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.mIsPrivateReprocessingSupported = z;
        this.mShouldZslDisabledByQuirks = DeviceQuirks.sQuirks.get(ZslDisablerQuirk.class) != null;
        this.mImageRingBuffer = new MenuHostHelper(new ZslControlImpl$$ExternalSyntheticLambda0(0));
    }
}
