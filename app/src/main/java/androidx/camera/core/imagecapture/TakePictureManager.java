package androidx.camera.core.imagecapture;

import android.util.Log;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.core.util.Preconditions;
import coil.intercept.RealInterceptorChain;
import com.google.zxing.WriterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener {
    public Dispatcher mImagePipeline;
    public final ArrayList mIncompleteRequests;
    public final ArrayDeque mNewRequests = new ArrayDeque();
    public boolean mPaused = false;

    public TakePictureManager(LayoutSettings layoutSettings) {
        CharsKt.checkMainThread();
        this.mIncompleteRequests = new ArrayList();
    }

    public final void abortRequests() {
        CharsKt.checkMainThread();
        new WriterException("Camera is closed.", null);
        ArrayDeque arrayDeque = this.mNewRequests;
        Iterator it = arrayDeque.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        arrayDeque.clear();
        Iterator it2 = new ArrayList(this.mIncompleteRequests).iterator();
        if (it2.hasNext()) {
            it2.next().getClass();
            throw new ClassCastException();
        }
    }

    public final void issueNextRequest() {
        int maxImages;
        CharsKt.checkMainThread();
        Log.d("TakePictureManager", "Issue the next TakePictureRequest.");
        if (this.mPaused) {
            Log.d("TakePictureManager", "The class is paused.");
            return;
        }
        Dispatcher dispatcher = this.mImagePipeline;
        dispatcher.getClass();
        CharsKt.checkMainThread();
        SurfaceRequest.AnonymousClass1 anonymousClass1 = (SurfaceRequest.AnonymousClass1) dispatcher.readyAsyncCalls;
        anonymousClass1.getClass();
        CharsKt.checkMainThread();
        Preconditions.checkState("The ImageReader is not initialized.", ((RealInterceptorChain) anonymousClass1.val$requestCancellationCompleter) != null);
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) anonymousClass1.val$requestCancellationCompleter;
        synchronized (realInterceptorChain.initialRequest) {
            maxImages = ((ImageReaderProxy) realInterceptorChain.request).getMaxImages() - realInterceptorChain.index;
        }
        if (maxImages == 0) {
            Log.d("TakePictureManager", "Too many acquire images. Close image to be able to process next.");
        } else {
            if (this.mNewRequests.poll() != null) {
                throw new ClassCastException();
            }
            Log.d("TakePictureManager", "No new request.");
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public final void onImageClose(ForwardingImageProxy forwardingImageProxy) {
        HexFormatKt.mainThreadExecutor().execute(new Preview$$ExternalSyntheticLambda0(12, this));
    }
}
