package androidx.camera.core;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda14;
import androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda6;
import androidx.camera.camera2.internal.MeteringRepeatingSession$MeteringRepeatingConfig;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import kotlin.text.CharsKt;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Preview$$ExternalSyntheticLambda2 implements SessionConfig.ErrorListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Preview$$ExternalSyntheticLambda2(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
    public final void onError(SessionConfig sessionConfig) {
        int i = this.$r8$classId;
        int i2 = 0;
        Object obj = this.f$0;
        int i3 = 1;
        switch (i) {
            case 0:
                Preview preview = (Preview) obj;
                if (preview.getCamera() == null) {
                    return;
                }
                preview.updateConfigAndOutput((PreviewConfig) preview.mCurrentConfig, preview.mAttachedStreamSpec);
                preview.notifyReset();
                return;
            case 1:
                Http2Connection.Builder builder = (Http2Connection.Builder) obj;
                builder.socket = builder.createSessionConfig();
                Camera2CameraImpl$$ExternalSyntheticLambda14 camera2CameraImpl$$ExternalSyntheticLambda14 = (Camera2CameraImpl$$ExternalSyntheticLambda14) builder.sink;
                if (camera2CameraImpl$$ExternalSyntheticLambda14 != null) {
                    Camera2CameraImpl camera2CameraImpl = camera2CameraImpl$$ExternalSyntheticLambda14.f$0;
                    try {
                        if (((Boolean) CallbackToFutureAdapter.getFuture(new Camera2CameraImpl$$ExternalSyntheticLambda14(camera2CameraImpl, i3)).delegate.get()).booleanValue()) {
                            Http2Connection.Builder builder2 = camera2CameraImpl.mMeteringRepeatingSession;
                            camera2CameraImpl.mExecutor.execute(new Camera2CameraImpl$$ExternalSyntheticLambda6(camera2CameraImpl, Camera2CameraImpl.getMeteringRepeatingId(builder2), (SessionConfig) builder2.socket, (MeteringRepeatingSession$MeteringRepeatingConfig) builder2.connectionName, null, Collections.singletonList(UseCaseConfigFactory.CaptureType.METERING_REPEATING), 1));
                            return;
                        }
                        return;
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e);
                    }
                }
                return;
            case 2:
                ImageAnalysis imageAnalysis = (ImageAnalysis) obj;
                if (imageAnalysis.getCamera() == null) {
                    return;
                }
                CharsKt.checkMainThread();
                SessionConfig.CloseableErrorListener closeableErrorListener = imageAnalysis.mCloseableErrorListener;
                if (closeableErrorListener != null) {
                    closeableErrorListener.close();
                    imageAnalysis.mCloseableErrorListener = null;
                }
                SurfaceRequest.AnonymousClass2 anonymousClass2 = imageAnalysis.mDeferrableSurface;
                if (anonymousClass2 != null) {
                    anonymousClass2.close();
                    imageAnalysis.mDeferrableSurface = null;
                }
                imageAnalysis.mImageAnalysisAbstractAnalyzer.clearCache();
                imageAnalysis.getCameraId();
                ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) imageAnalysis.mCurrentConfig;
                AutoValue_StreamSpec autoValue_StreamSpec = imageAnalysis.mAttachedStreamSpec;
                autoValue_StreamSpec.getClass();
                SessionConfig.Builder builderCreatePipeline = imageAnalysis.createPipeline(imageAnalysisConfig, autoValue_StreamSpec);
                imageAnalysis.mSessionConfigBuilder = builderCreatePipeline;
                Object[] objArr = {builderCreatePipeline.build()};
                ArrayList arrayList = new ArrayList(1);
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                arrayList.add(obj2);
                imageAnalysis.updateSessionConfig(Collections.unmodifiableList(arrayList));
                imageAnalysis.notifyReset();
                return;
            case 3:
                ImageCapture imageCapture = (ImageCapture) obj;
                if (imageCapture.getCamera() == null) {
                    return;
                }
                TakePictureManager takePictureManager = imageCapture.mTakePictureManager;
                takePictureManager.getClass();
                CharsKt.checkMainThread();
                takePictureManager.mPaused = true;
                imageCapture.clearPipeline(true);
                String cameraId = imageCapture.getCameraId();
                ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) imageCapture.mCurrentConfig;
                AutoValue_StreamSpec autoValue_StreamSpec2 = imageCapture.mAttachedStreamSpec;
                autoValue_StreamSpec2.getClass();
                SessionConfig.Builder builderCreatePipeline2 = imageCapture.createPipeline(cameraId, imageCaptureConfig, autoValue_StreamSpec2);
                imageCapture.mSessionConfigBuilder = builderCreatePipeline2;
                Object[] objArr2 = {builderCreatePipeline2.build()};
                ArrayList arrayList2 = new ArrayList(1);
                Object obj3 = objArr2[0];
                Objects.requireNonNull(obj3);
                arrayList2.add(obj3);
                imageCapture.updateSessionConfig(Collections.unmodifiableList(arrayList2));
                imageCapture.notifyReset();
                TakePictureManager takePictureManager2 = imageCapture.mTakePictureManager;
                takePictureManager2.getClass();
                CharsKt.checkMainThread();
                takePictureManager2.mPaused = false;
                takePictureManager2.issueNextRequest();
                return;
            default:
                ArrayList arrayList3 = ((SessionConfig.ValidatingBuilder) obj).mErrorListeners;
                int size = arrayList3.size();
                while (i2 < size) {
                    Object obj4 = arrayList3.get(i2);
                    i2++;
                    ((SessionConfig.ErrorListener) obj4).onError(sessionConfig);
                }
                return;
        }
    }
}
