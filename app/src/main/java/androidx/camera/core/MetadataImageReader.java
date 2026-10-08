package androidx.camera.core;

import android.media.ImageReader;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.streamsharing.VirtualCameraAdapter;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.core.util.Preconditions;
import com.google.android.gms.tasks.zzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MetadataImageReader implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    public final ArrayList mAcquiredImageProxies;
    public final AnonymousClass1 mCameraCaptureCallback;
    public boolean mClosed;
    public Executor mExecutor;
    public int mImageProxiesIndex;
    public final zzr mImageReaderProxy;
    public ImageReaderProxy.OnImageAvailableListener mListener;
    public final Object mLock;
    public final ArrayList mMatchedImageProxies;
    public final LongSparseArray mPendingImageInfos;
    public final LongSparseArray mPendingImages;
    public final OnBackPressedDispatcher$$ExternalSyntheticLambda0 mTransformedListener;
    public int mUnAcquiredAvailableImageCount;

    /* JADX INFO: renamed from: androidx.camera.core.MetadataImageReader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends CameraCaptureCallback {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(int i, CameraCaptureResult cameraCaptureResult) {
            switch (this.$r8$classId) {
                case 0:
                    MetadataImageReader metadataImageReader = (MetadataImageReader) this.this$0;
                    synchronized (metadataImageReader.mLock) {
                        try {
                            if (metadataImageReader.mClosed) {
                                return;
                            }
                            metadataImageReader.mPendingImageInfos.put(cameraCaptureResult.getTimestamp(), new CameraCaptureResultImageInfo(cameraCaptureResult));
                            metadataImageReader.matchImages();
                            return;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                case 1:
                default:
                    return;
                case 2:
                    Iterator it = ((VirtualCameraAdapter) this.this$0).mChildren.iterator();
                    while (it.hasNext()) {
                        SessionConfig sessionConfig = ((UseCase) it.next()).mAttachedSessionConfig;
                        Iterator it2 = sessionConfig.mRepeatingCaptureConfig.mCameraCaptureCallbacks.iterator();
                        while (it2.hasNext()) {
                            ((CameraCaptureCallback) it2.next()).onCaptureCompleted(i, new VirtualCameraCaptureResult(cameraCaptureResult, sessionConfig.mRepeatingCaptureConfig.mTagBundle, -1L));
                        }
                    }
                    return;
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureStarted(int i) {
            switch (this.$r8$classId) {
                case 1:
                    HexFormatKt.mainThreadExecutor().execute(new Preview$$ExternalSyntheticLambda0(11, this));
                    break;
            }
        }
    }

    public MetadataImageReader(int i, int i2, int i3, int i4) {
        zzr zzrVar = new zzr(ImageReader.newInstance(i, i2, i3, i4));
        this.mLock = new Object();
        this.mCameraCaptureCallback = new AnonymousClass1(0, this);
        this.mUnAcquiredAvailableImageCount = 0;
        this.mTransformedListener = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(6, this);
        this.mClosed = false;
        this.mPendingImageInfos = new LongSparseArray();
        this.mPendingImages = new LongSparseArray();
        this.mAcquiredImageProxies = new ArrayList();
        this.mImageReaderProxy = zzrVar;
        this.mImageProxiesIndex = 0;
        this.mMatchedImageProxies = new ArrayList(getMaxImages());
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final ImageProxy acquireLatestImage() {
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (int i2 = 0; i2 < this.mMatchedImageProxies.size() - 1; i2++) {
                    if (!this.mAcquiredImageProxies.contains(this.mMatchedImageProxies.get(i2))) {
                        arrayList.add((ImageProxy) this.mMatchedImageProxies.get(i2));
                    }
                }
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((ImageProxy) obj).close();
                }
                int size2 = this.mMatchedImageProxies.size();
                ArrayList arrayList2 = this.mMatchedImageProxies;
                this.mImageProxiesIndex = size2;
                ImageProxy imageProxy = (ImageProxy) arrayList2.get(size2 - 1);
                this.mAcquiredImageProxies.add(imageProxy);
                return imageProxy;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final ImageProxy acquireNextImage() {
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = this.mMatchedImageProxies;
                int i = this.mImageProxiesIndex;
                this.mImageProxiesIndex = i + 1;
                ImageProxy imageProxy = (ImageProxy) arrayList.get(i);
                this.mAcquiredImageProxies.add(imageProxy);
                return imageProxy;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mImageReaderProxy.clearOnImageAvailableListener();
            this.mListener = null;
            this.mExecutor = null;
            this.mUnAcquiredAvailableImageCount = 0;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final void close() {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.mMatchedImageProxies);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((ImageProxy) obj).close();
                }
                this.mMatchedImageProxies.clear();
                this.mImageReaderProxy.close();
                this.mClosed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void dequeImageProxy(ForwardingImageProxy forwardingImageProxy) {
        synchronized (this.mLock) {
            try {
                int iIndexOf = this.mMatchedImageProxies.indexOf(forwardingImageProxy);
                if (iIndexOf >= 0) {
                    this.mMatchedImageProxies.remove(iIndexOf);
                    int i = this.mImageProxiesIndex;
                    if (iIndexOf <= i) {
                        this.mImageProxiesIndex = i - 1;
                    }
                }
                this.mAcquiredImageProxies.remove(forwardingImageProxy);
                if (this.mUnAcquiredAvailableImageCount > 0) {
                    imageIncoming(this.mImageReaderProxy);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void enqueueImageProxy(SettableImageProxy settableImageProxy) {
        ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
        Executor executor;
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.size() < getMaxImages()) {
                    settableImageProxy.addOnImageCloseListener(this);
                    this.mMatchedImageProxies.add(settableImageProxy);
                    onImageAvailableListener = this.mListener;
                    executor = this.mExecutor;
                } else {
                    Logger.d("TAG", "Maximum image number reached.");
                    settableImageProxy.close();
                    onImageAvailableListener = null;
                    executor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (onImageAvailableListener != null) {
            if (executor != null) {
                executor.execute(new Preview$$ExternalSyntheticLambda1(12, this, onImageAvailableListener));
            } else {
                onImageAvailableListener.onImageAvailable(this);
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mImageReaderProxy.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mImageReaderProxy.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReaderProxy.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mImageReaderProxy.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mImageReaderProxy.getWidth();
        }
        return width;
    }

    public final void imageIncoming(ImageReaderProxy imageReaderProxy) {
        ImageProxy imageProxyAcquireNextImage;
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    return;
                }
                int size = this.mPendingImages.size() + this.mMatchedImageProxies.size();
                if (size >= imageReaderProxy.getMaxImages()) {
                    Logger.d("MetadataImageReader", "Skip to acquire the next image because the acquired image count has reached the max images count.");
                    return;
                }
                do {
                    try {
                        imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
                        if (imageProxyAcquireNextImage != null) {
                            this.mUnAcquiredAvailableImageCount--;
                            size++;
                            this.mPendingImages.put(imageProxyAcquireNextImage.getImageInfo().getTimestamp(), imageProxyAcquireNextImage);
                            matchImages();
                        }
                    } catch (IllegalStateException e) {
                        String strTruncateTag = Logger.truncateTag("MetadataImageReader");
                        if (Logger.isLogLevelEnabled(strTruncateTag, 3)) {
                            Log.d(strTruncateTag, "Failed to acquire next image.", e);
                        }
                        imageProxyAcquireNextImage = null;
                    }
                    if (imageProxyAcquireNextImage == null || this.mUnAcquiredAvailableImageCount <= 0) {
                        break;
                    }
                } while (size < imageReaderProxy.getMaxImages());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void matchImages() {
        synchronized (this.mLock) {
            try {
                for (int size = this.mPendingImageInfos.size() - 1; size >= 0; size--) {
                    ImageInfo imageInfo = (ImageInfo) this.mPendingImageInfos.valueAt(size);
                    long timestamp = imageInfo.getTimestamp();
                    ImageProxy imageProxy = (ImageProxy) this.mPendingImages.get(timestamp);
                    if (imageProxy != null) {
                        this.mPendingImages.remove(timestamp);
                        this.mPendingImageInfos.removeAt(size);
                        enqueueImageProxy(new SettableImageProxy(imageProxy, null, imageInfo));
                    }
                }
                removeStaleData();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public final void onImageClose(ForwardingImageProxy forwardingImageProxy) {
        synchronized (this.mLock) {
            dequeImageProxy(forwardingImageProxy);
        }
    }

    public final void removeStaleData() {
        synchronized (this.mLock) {
            try {
                if (this.mPendingImages.size() != 0 && this.mPendingImageInfos.size() != 0) {
                    long jKeyAt = this.mPendingImages.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.mPendingImageInfos.keyAt(0);
                    Preconditions.checkArgument(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.mPendingImages.size() - 1; size >= 0; size--) {
                            if (this.mPendingImages.keyAt(size) < jKeyAt2) {
                                ((ImageProxy) this.mPendingImages.valueAt(size)).close();
                                this.mPendingImages.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.mPendingImageInfos.size() - 1; size2 >= 0; size2--) {
                            if (this.mPendingImageInfos.keyAt(size2) < jKeyAt) {
                                this.mPendingImageInfos.removeAt(size2);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public final void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        synchronized (this.mLock) {
            onImageAvailableListener.getClass();
            this.mListener = onImageAvailableListener;
            executor.getClass();
            this.mExecutor = executor;
            this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, executor);
        }
    }
}
