package androidx.camera.camera2.internal;

import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.processing.SurfaceEdge;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda6(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
        this.f$5 = obj6;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) this.f$0;
                String str = (String) this.f$1;
                SessionConfig sessionConfig = (SessionConfig) this.f$2;
                UseCaseConfig useCaseConfig = (UseCaseConfig) this.f$3;
                AutoValue_StreamSpec autoValue_StreamSpec = (AutoValue_StreamSpec) this.f$4;
                List list = (List) this.f$5;
                camera2CameraImpl.getClass();
                camera2CameraImpl.debugLog("Use case " + str + " UPDATED", null);
                camera2CameraImpl.mUseCaseAttachState.updateUseCase(str, sessionConfig, useCaseConfig, autoValue_StreamSpec, list);
                camera2CameraImpl.updateCaptureSessionConfig();
                break;
            case 1:
                Camera2CameraImpl camera2CameraImpl2 = (Camera2CameraImpl) this.f$0;
                String str2 = (String) this.f$1;
                SessionConfig sessionConfig2 = (SessionConfig) this.f$2;
                UseCaseConfig useCaseConfig2 = (UseCaseConfig) this.f$3;
                AutoValue_StreamSpec autoValue_StreamSpec2 = (AutoValue_StreamSpec) this.f$4;
                List list2 = (List) this.f$5;
                camera2CameraImpl2.debugLog("Use case " + str2 + " RESET", null);
                camera2CameraImpl2.mUseCaseAttachState.updateUseCase(str2, sessionConfig2, useCaseConfig2, autoValue_StreamSpec2, list2);
                camera2CameraImpl2.addOrRemoveMeteringRepeatingUseCase();
                camera2CameraImpl2.resetCaptureSession();
                camera2CameraImpl2.updateCaptureSessionConfig();
                if (camera2CameraImpl2.mState == 9) {
                    camera2CameraImpl2.openCaptureSession();
                }
                break;
            case 2:
                Camera2CameraImpl camera2CameraImpl3 = (Camera2CameraImpl) this.f$0;
                String str3 = (String) this.f$1;
                SessionConfig sessionConfig3 = (SessionConfig) this.f$2;
                UseCaseConfig useCaseConfig3 = (UseCaseConfig) this.f$3;
                AutoValue_StreamSpec autoValue_StreamSpec3 = (AutoValue_StreamSpec) this.f$4;
                List list3 = (List) this.f$5;
                camera2CameraImpl3.debugLog("Use case " + str3 + " ACTIVE", null);
                LinkedHashMap linkedHashMap = (LinkedHashMap) camera2CameraImpl3.mUseCaseAttachState.val$requestCancellationFuture;
                UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(str3);
                if (useCaseAttachState$UseCaseAttachInfo == null) {
                    useCaseAttachState$UseCaseAttachInfo = new UseCaseAttachState$UseCaseAttachInfo(sessionConfig3, useCaseConfig3, autoValue_StreamSpec3, list3);
                    linkedHashMap.put(str3, useCaseAttachState$UseCaseAttachInfo);
                }
                useCaseAttachState$UseCaseAttachInfo.mActive = true;
                camera2CameraImpl3.mUseCaseAttachState.updateUseCase(str3, sessionConfig3, useCaseConfig3, autoValue_StreamSpec3, list3);
                camera2CameraImpl3.updateCaptureSessionConfig();
                break;
            default:
                ((Request) this.f$0).createAndSendSurfaceOutput((CameraInternal) this.f$1, (CameraInternal) this.f$2, (SurfaceEdge) this.f$3, (SurfaceEdge) this.f$4, (Map.Entry) this.f$5);
                break;
        }
    }
}
