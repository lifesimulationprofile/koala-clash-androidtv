package io.github.g00fy2.quickie;

import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QRScannerActivity$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ QRScannerActivity f$0;

    public /* synthetic */ QRScannerActivity$$ExternalSyntheticLambda0(QRScannerActivity qRScannerActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = qRScannerActivity;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        int i = this.$r8$classId;
        QRScannerActivity qRScannerActivity = this.f$0;
        switch (i) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i2 = QRScannerActivity.$r8$clinit;
                if (zBooleanValue) {
                    try {
                        ProcessCameraProvider processCameraProvider = ProcessCameraProvider.sAppInstance;
                        ChainingListenableFuture uStringsKt = UStringsKt.getInstance(qRScannerActivity);
                        uStringsKt.addListener(new Preview$$ExternalSyntheticLambda1(26, uStringsKt, qRScannerActivity), ContextCompat.getMainExecutor(qRScannerActivity));
                    } catch (Exception e) {
                        qRScannerActivity.onFailure(e);
                    }
                } else {
                    qRScannerActivity.setResult(2, null);
                    qRScannerActivity.finish();
                }
                return Unit.INSTANCE;
            case 1:
                int i3 = QRScannerActivity.$r8$clinit;
                qRScannerActivity.onFailure((Exception) obj);
                return Unit.INSTANCE;
            case 2:
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                int i4 = QRScannerActivity.$r8$clinit;
                if (!qRScannerActivity.isFinishing()) {
                    CacheStrategy cacheStrategy = qRScannerActivity.binding;
                    if (cacheStrategy == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) cacheStrategy.networkRequest).setLoading(zBooleanValue2);
                }
                return Unit.INSTANCE;
            default:
                Integer num = (Integer) obj;
                CacheStrategy cacheStrategy2 = qRScannerActivity.binding;
                if (cacheStrategy2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                QROverlayView qROverlayView = (QROverlayView) cacheStrategy2.networkRequest;
                if (num != null) {
                    z = num.intValue() == 1;
                }
                qROverlayView.setTorchState(z);
                return Unit.INSTANCE;
        }
    }
}
