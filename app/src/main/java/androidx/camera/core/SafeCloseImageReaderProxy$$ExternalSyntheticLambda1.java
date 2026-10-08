package androidx.camera.core;

import coil.intercept.RealInterceptorChain;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SafeCloseImageReaderProxy$$ExternalSyntheticLambda1 implements ForwardingImageProxy.OnImageCloseListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SafeCloseImageReaderProxy$$ExternalSyntheticLambda1(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public final void onImageClose(ForwardingImageProxy forwardingImageProxy) {
        ForwardingImageProxy.OnImageCloseListener onImageCloseListener;
        switch (this.$r8$classId) {
            case 0:
                RealInterceptorChain realInterceptorChain = (RealInterceptorChain) this.f$0;
                synchronized (realInterceptorChain.initialRequest) {
                    try {
                        int i = realInterceptorChain.index - 1;
                        realInterceptorChain.index = i;
                        if (realInterceptorChain.isPlaceholderCached && i == 0) {
                            realInterceptorChain.close();
                        }
                        onImageCloseListener = (ForwardingImageProxy.OnImageCloseListener) realInterceptorChain.size;
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (onImageCloseListener != null) {
                    onImageCloseListener.onImageClose(forwardingImageProxy);
                    return;
                }
                return;
            default:
                ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer = (ImageAnalysisNonBlockingAnalyzer) ((WeakReference) ((SingleCloseImageProxy) this.f$0).mClosed).get();
                if (imageAnalysisNonBlockingAnalyzer != null) {
                    imageAnalysisNonBlockingAnalyzer.mBackgroundExecutor.execute(new Preview$$ExternalSyntheticLambda0(10, imageAnalysisNonBlockingAnalyzer));
                    return;
                }
                return;
        }
    }
}
