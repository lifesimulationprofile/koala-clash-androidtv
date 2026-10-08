package androidx.camera.core;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SingleCloseImageProxy extends ForwardingImageProxy {
    public final /* synthetic */ int $r8$classId = 0;
    public final Object mClosed;

    public SingleCloseImageProxy(ImageProxy imageProxy) {
        super(imageProxy);
        this.mClosed = new AtomicBoolean(false);
    }

    @Override // androidx.camera.core.ForwardingImageProxy, java.lang.AutoCloseable
    public void close() {
        switch (this.$r8$classId) {
            case 0:
                if (!((AtomicBoolean) this.mClosed).getAndSet(true)) {
                    super.close();
                }
                break;
            default:
                super.close();
                break;
        }
    }

    public SingleCloseImageProxy(ImageProxy imageProxy, ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
        super(imageProxy);
        this.mClosed = new WeakReference(imageAnalysisNonBlockingAnalyzer);
        addOnImageCloseListener(new SafeCloseImageReaderProxy$$ExternalSyntheticLambda1(1, this));
    }
}
