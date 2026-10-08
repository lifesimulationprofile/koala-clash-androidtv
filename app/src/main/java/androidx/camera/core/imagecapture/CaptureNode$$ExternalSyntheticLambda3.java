package androidx.camera.core.imagecapture;

import androidx.camera.core.AutoValue_SurfaceRequest_Result;
import androidx.camera.core.AutoValue_SurfaceRequest_TransformationInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceEdge$$ExternalSyntheticLambda3;
import androidx.camera.core.processing.util.AutoValue_OutConfig;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import java.util.Map;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CaptureNode$$ExternalSyntheticLambda3 implements Consumer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ CaptureNode$$ExternalSyntheticLambda3(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((SurfaceRequest.AnonymousClass1) this.f$0).getClass();
                CharsKt.checkMainThread();
                break;
            case 1:
                AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo = (AutoValue_SurfaceRequest_TransformationInfo) obj;
                for (Map.Entry entry : ((Map) this.f$0).entrySet()) {
                    int i = autoValue_SurfaceRequest_TransformationInfo.getRotationDegrees - ((AutoValue_OutConfig) entry.getKey()).getRotationDegrees;
                    if (((AutoValue_OutConfig) entry.getKey()).isMirroring) {
                        i = -i;
                    }
                    int iWithin360 = TransformUtils.within360(i);
                    SurfaceEdge surfaceEdge = (SurfaceEdge) entry.getValue();
                    surfaceEdge.getClass();
                    CharsKt.runOnMain(new SurfaceEdge$$ExternalSyntheticLambda3(surfaceEdge, iWithin360, -1));
                }
                break;
            case 2:
                PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2 = (PreviewView$1$$ExternalSyntheticLambda2) this.f$0;
                Logger.d("SurfaceViewImpl", "Safe to release surface.");
                if (previewView$1$$ExternalSyntheticLambda2 != null) {
                    previewView$1$$ExternalSyntheticLambda2.onSurfaceNotInUse();
                }
                break;
            default:
                ((CallbackToFutureAdapter.Completer) this.f$0).set((AutoValue_SurfaceRequest_Result) obj);
                break;
        }
    }
}
