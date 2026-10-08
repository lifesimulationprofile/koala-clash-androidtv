package androidx.core.content.res;

import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ResourcesCompat$FontCallback$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(int i, int i2, Object obj) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((CamUtils) this.f$0).onFontRetrievalFailed(this.f$1);
                return;
            case 1:
                ((CameraCaptureCallback) this.f$0).onCaptureCancelled(this.f$1);
                return;
            case 2:
                LinkedHashSet<SynchronizedCaptureSessionImpl> linkedHashSet = (LinkedHashSet) this.f$0;
                int i = this.f$1;
                for (SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl : linkedHashSet) {
                    if (i == 5) {
                        synchronized (synchronizedCaptureSessionImpl.mObjectLock) {
                            try {
                                if (synchronizedCaptureSessionImpl.isCameraCaptureSessionOpen() && synchronizedCaptureSessionImpl.mDeferrableSurfaces != null) {
                                    synchronizedCaptureSessionImpl.debugLog("Close DeferrableSurfaces for CameraDevice error.");
                                    ArrayList arrayList = synchronizedCaptureSessionImpl.mDeferrableSurfaces;
                                    int size = arrayList.size();
                                    int i2 = 0;
                                    while (i2 < size) {
                                        Object obj = arrayList.get(i2);
                                        i2++;
                                        ((DeferrableSurface) obj).close();
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        synchronizedCaptureSessionImpl.getClass();
                    }
                }
                return;
            default:
                ((IntConsumer) this.f$0).accept(this.f$1);
                return;
        }
    }
}
