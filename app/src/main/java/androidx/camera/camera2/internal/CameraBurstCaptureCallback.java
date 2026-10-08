package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.view.TextureViewImplementation$$ExternalSyntheticLambda2;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraBurstCaptureCallback extends CameraCaptureSession.CaptureCallback {
    public final /* synthetic */ int $r8$classId;
    public final Object mCallbackMap;
    public Object mCaptureSequenceCallback;

    public CameraBurstCaptureCallback(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 3:
                this.mCallbackMap = CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(5, this));
                break;
            default:
                this.mCaptureSequenceCallback = null;
                this.mCallbackMap = new HashMap();
                break;
        }
    }

    public void addCamera2Callbacks(CaptureRequest captureRequest, List list) {
        HashMap map = (HashMap) this.mCallbackMap;
        List list2 = (List) map.get(captureRequest);
        if (list2 == null) {
            map.put(captureRequest, list);
            return;
        }
        ArrayList arrayList = new ArrayList(list2.size() + list.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        map.put(captureRequest, arrayList);
    }

    public void completeFuture() {
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.mCaptureSequenceCallback;
        if (completer != null) {
            completer.set(null);
            this.mCaptureSequenceCallback = null;
        }
    }

    public List getCallbacks(CaptureRequest captureRequest) {
        List list = (List) ((HashMap) this.mCallbackMap).get(captureRequest);
        return list != null ? list : Collections.EMPTY_LIST;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final Surface surface, final long j) {
        switch (this.$r8$classId) {
            case 0:
                Iterator it = getCallbacks(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                }
                break;
            case 1:
            default:
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                break;
            case 2:
                ((SequentialExecutor) this.mCaptureSequenceCallback).execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) this.f$0.mCallbackMap).onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                    }
                });
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        switch (this.$r8$classId) {
            case 0:
                Iterator it = getCallbacks(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
                break;
            case 1:
                ((SequentialExecutor) this.mCaptureSequenceCallback).execute(new Preview$$ExternalSyntheticLambda1(5, this, totalCaptureResult));
                break;
            case 2:
                ((SequentialExecutor) this.mCaptureSequenceCallback).execute(new TextureViewImplementation$$ExternalSyntheticLambda2(this, cameraCaptureSession, captureRequest, totalCaptureResult, 1));
                break;
            default:
                completeFuture();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        switch (this.$r8$classId) {
            case 0:
                Iterator it = getCallbacks(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
                break;
            case 1:
            default:
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                break;
            case 2:
                ((SequentialExecutor) this.mCaptureSequenceCallback).execute(new TextureViewImplementation$$ExternalSyntheticLambda2(this, cameraCaptureSession, captureRequest, captureFailure, 3));
                break;
            case 3:
                completeFuture();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        switch (this.$r8$classId) {
            case 0:
                Iterator it = getCallbacks(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
                break;
            case 1:
            default:
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                break;
            case 2:
                ((SequentialExecutor) this.mCaptureSequenceCallback).execute(new TextureViewImplementation$$ExternalSyntheticLambda2(this, cameraCaptureSession, captureRequest, captureResult, 2));
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
        switch (this.$r8$classId) {
            case 0:
                Iterator it = ((HashMap) this.mCallbackMap).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    while (it2.hasNext()) {
                        ((CameraCaptureSession.CaptureCallback) it2.next()).onCaptureSequenceAborted(cameraCaptureSession, i);
                    }
                }
                CaptureSession$$ExternalSyntheticLambda4 captureSession$$ExternalSyntheticLambda4 = (CaptureSession$$ExternalSyntheticLambda4) this.mCaptureSequenceCallback;
                if (captureSession$$ExternalSyntheticLambda4 != null) {
                    captureSession$$ExternalSyntheticLambda4.onCaptureSequenceCompletedOrAborted();
                }
                break;
            case 1:
            default:
                super.onCaptureSequenceAborted(cameraCaptureSession, i);
                break;
            case 2:
                ((SequentialExecutor) this.mCaptureSequenceCallback).execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, cameraCaptureSession, i, 5));
                break;
            case 3:
                completeFuture();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(final CameraCaptureSession cameraCaptureSession, final int i, final long j) {
        switch (this.$r8$classId) {
            case 0:
                Iterator it = ((HashMap) this.mCallbackMap).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    while (it2.hasNext()) {
                        ((CameraCaptureSession.CaptureCallback) it2.next()).onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                    }
                }
                CaptureSession$$ExternalSyntheticLambda4 captureSession$$ExternalSyntheticLambda4 = (CaptureSession$$ExternalSyntheticLambda4) this.mCaptureSequenceCallback;
                if (captureSession$$ExternalSyntheticLambda4 != null) {
                    captureSession$$ExternalSyntheticLambda4.onCaptureSequenceCompletedOrAborted();
                }
                break;
            case 1:
            default:
                super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                break;
            case 2:
                ((SequentialExecutor) this.mCaptureSequenceCallback).execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) this.f$0.mCallbackMap).onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                    }
                });
                break;
            case 3:
                completeFuture();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final long j, final long j2) {
        switch (this.$r8$classId) {
            case 0:
                Iterator it = getCallbacks(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                }
                break;
            case 1:
            default:
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                break;
            case 2:
                ((SequentialExecutor) this.mCaptureSequenceCallback).execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) this.f$0.mCallbackMap).onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                    }
                });
                break;
            case 3:
                completeFuture();
                break;
        }
    }

    public CameraBurstCaptureCallback(SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
        this.$r8$classId = 2;
        this.mCaptureSequenceCallback = sequentialExecutor;
        this.mCallbackMap = captureCallback;
    }

    public CameraBurstCaptureCallback(SequentialExecutor sequentialExecutor) {
        this.$r8$classId = 1;
        this.mCallbackMap = new HashSet();
        this.mCaptureSequenceCallback = sequentialExecutor;
    }
}
