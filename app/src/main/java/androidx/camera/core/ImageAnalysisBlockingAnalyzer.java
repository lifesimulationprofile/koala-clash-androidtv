package androidx.camera.core;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.impl.ImageReaderProxy;
import com.google.android.gms.tasks.zzi;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageAnalysisBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final ImageProxy acquireImage(ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireNextImage();
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final void onValidImageAvailable(ImageProxy imageProxy) throws Throwable {
        ListenableFuture listenableFutureAnalyzeImage = analyzeImage(imageProxy);
        Toolbar.AnonymousClass1 anonymousClass1 = new Toolbar.AnonymousClass1(15, imageProxy);
        listenableFutureAnalyzeImage.addListener(new zzi(1, listenableFutureAnalyzeImage, anonymousClass1), HexFormatKt.directExecutor());
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final void clearCache() {
    }
}
