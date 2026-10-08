package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CaptureSessionRepository$1 extends CameraDevice.StateCallback {
    public final /* synthetic */ int $r8$classId;
    public final Object this$0;

    public CaptureSessionRepository$1(Http2Connection.Builder builder) {
        this.$r8$classId = 0;
        this.this$0 = builder;
    }

    public void cameraClosed() {
        ArrayList sessionsInOrder;
        synchronized (((Http2Connection.Builder) this.this$0).socket) {
            sessionsInOrder = ((Http2Connection.Builder) this.this$0).getSessionsInOrder();
            ((LinkedHashSet) ((Http2Connection.Builder) this.this$0).sink).clear();
            ((LinkedHashSet) ((Http2Connection.Builder) this.this$0).connectionName).clear();
            ((LinkedHashSet) ((Http2Connection.Builder) this.this$0).source).clear();
        }
        int size = sessionsInOrder.size();
        int i = 0;
        while (i < size) {
            Object obj = sessionsInOrder.get(i);
            i++;
            SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) obj;
            synchronizedCaptureSessionImpl.releaseDeferrableSurfaces();
            synchronizedCaptureSessionImpl.mRequestMonitor.stop();
        }
    }

    public void forceOnClosedCaptureSessions() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (((Http2Connection.Builder) this.this$0).socket) {
            linkedHashSet.addAll((LinkedHashSet) ((Http2Connection.Builder) this.this$0).sink);
            linkedHashSet.addAll((LinkedHashSet) ((Http2Connection.Builder) this.this$0).connectionName);
        }
        ((SequentialExecutor) ((Http2Connection.Builder) this.this$0).taskRunner).execute(new Preview$$ExternalSyntheticLambda0(7, linkedHashSet));
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        switch (this.$r8$classId) {
            case 0:
                forceOnClosedCaptureSessions();
                cameraClosed();
                break;
            default:
                ArrayList arrayList = (ArrayList) this.this$0;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onClosed(cameraDevice);
                }
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        switch (this.$r8$classId) {
            case 0:
                forceOnClosedCaptureSessions();
                cameraClosed();
                break;
            default:
                ArrayList arrayList = (ArrayList) this.this$0;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onDisconnected(cameraDevice);
                }
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        switch (this.$r8$classId) {
            case 0:
                forceOnClosedCaptureSessions();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                synchronized (((Http2Connection.Builder) this.this$0).socket) {
                    linkedHashSet.addAll((LinkedHashSet) ((Http2Connection.Builder) this.this$0).sink);
                    linkedHashSet.addAll((LinkedHashSet) ((Http2Connection.Builder) this.this$0).connectionName);
                    break;
                }
                ((SequentialExecutor) ((Http2Connection.Builder) this.this$0).taskRunner).execute(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(i, 2, linkedHashSet));
                cameraClosed();
                return;
            default:
                ArrayList arrayList = (ArrayList) this.this$0;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((CameraDevice.StateCallback) obj).onError(cameraDevice, i);
                }
                return;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        switch (this.$r8$classId) {
            case 0:
                break;
            default:
                ArrayList arrayList = (ArrayList) this.this$0;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onOpened(cameraDevice);
                }
                break;
        }
    }

    public CaptureSessionRepository$1(ArrayList arrayList) {
        this.$r8$classId = 1;
        this.this$0 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback) obj;
            if (!(stateCallback instanceof CameraDeviceStateCallbacks$NoOpDeviceStateCallback)) {
                ((ArrayList) this.this$0).add(stateCallback);
            }
        }
    }

    private final void onOpened$androidx$camera$camera2$internal$CaptureSessionRepository$1(CameraDevice cameraDevice) {
    }
}
