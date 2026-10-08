package coil.intercept;

import android.content.Context;
import android.util.ArrayMap;
import android.view.Surface;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SafeCloseImageReaderProxy$$ExternalSyntheticLambda1;
import androidx.camera.core.SingleCloseImageProxy;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.TagBundle;
import coil.EventListener$Companion$NONE$1;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.size.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealInterceptorChain implements ImageReaderProxy {
    public Object eventListener;
    public int index;
    public final Object initialRequest;
    public final Object interceptors;
    public boolean isPlaceholderCached;
    public Object request;
    public Object size;

    /* JADX INFO: renamed from: coil.intercept.RealInterceptorChain$proceed$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public RealInterceptorChain L$0;
        public EngineInterceptor L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealInterceptorChain.this.proceed(null, this);
        }
    }

    public RealInterceptorChain(ImageRequest imageRequest, List list, int i, ImageRequest imageRequest2, Size size, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1, boolean z) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i;
        this.request = imageRequest2;
        this.size = size;
        this.eventListener = eventListener$Companion$NONE$1;
        this.isPlaceholderCached = z;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        SingleCloseImageProxy singleCloseImageProxy;
        synchronized (this.initialRequest) {
            ImageProxy imageProxyAcquireLatestImage = ((ImageReaderProxy) this.request).acquireLatestImage();
            if (imageProxyAcquireLatestImage != null) {
                this.index++;
                singleCloseImageProxy = new SingleCloseImageProxy(imageProxyAcquireLatestImage);
                singleCloseImageProxy.addOnImageCloseListener((SafeCloseImageReaderProxy$$ExternalSyntheticLambda1) this.eventListener);
            } else {
                singleCloseImageProxy = null;
            }
        }
        return singleCloseImageProxy;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        SingleCloseImageProxy singleCloseImageProxy;
        synchronized (this.initialRequest) {
            ImageProxy imageProxyAcquireNextImage = ((ImageReaderProxy) this.request).acquireNextImage();
            if (imageProxyAcquireNextImage != null) {
                this.index++;
                singleCloseImageProxy = new SingleCloseImageProxy(imageProxyAcquireNextImage);
                singleCloseImageProxy.addOnImageCloseListener((SafeCloseImageReaderProxy$$ExternalSyntheticLambda1) this.eventListener);
            } else {
                singleCloseImageProxy = null;
            }
        }
        return singleCloseImageProxy;
    }

    public void addAllCameraCaptureCallbacks(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addCameraCaptureCallback((CameraCaptureCallback) it.next());
        }
    }

    public void addCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        ArrayList arrayList = (ArrayList) this.interceptors;
        if (arrayList.contains(cameraCaptureCallback)) {
            return;
        }
        arrayList.add(cameraCaptureCallback);
    }

    public void addImplementationOptions(Config config) {
        for (AutoValue_Config_Option autoValue_Config_Option : config.listOptions()) {
            MutableOptionsBundle mutableOptionsBundle = (MutableOptionsBundle) this.request;
            mutableOptionsBundle.getClass();
            try {
                mutableOptionsBundle.retrieveOption(autoValue_Config_Option);
            } catch (IllegalArgumentException unused) {
            }
            ((MutableOptionsBundle) this.request).insertOption(autoValue_Config_Option, config.getOptionPriority(autoValue_Config_Option), config.retrieveOption(autoValue_Config_Option));
        }
    }

    public CaptureConfig build() {
        ArrayList arrayList = new ArrayList((HashSet) this.initialRequest);
        OptionsBundle optionsBundleFrom = OptionsBundle.from((MutableOptionsBundle) this.request);
        int i = this.index;
        ArrayList arrayList2 = new ArrayList((ArrayList) this.interceptors);
        boolean z = this.isPlaceholderCached;
        MutableTagBundle mutableTagBundle = (MutableTagBundle) this.size;
        TagBundle tagBundle = TagBundle.EMPTY_TAGBUNDLE;
        ArrayMap arrayMap = new ArrayMap();
        for (String str : mutableTagBundle.mTagMap.keySet()) {
            arrayMap.put(str, mutableTagBundle.mTagMap.get(str));
        }
        return new CaptureConfig(arrayList, optionsBundleFrom, i, arrayList2, z, new TagBundle(arrayMap), (CameraCaptureResult) this.eventListener);
    }

    public void checkRequest(ImageRequest imageRequest, EngineInterceptor engineInterceptor) {
        Context context = imageRequest.context;
        ImageRequest imageRequest2 = (ImageRequest) this.initialRequest;
        if (context != imageRequest2.context) {
            throw new IllegalStateException(("Interceptor '" + engineInterceptor + "' cannot modify the request's context.").toString());
        }
        if (imageRequest.data == NullRequestData.INSTANCE) {
            throw new IllegalStateException(("Interceptor '" + engineInterceptor + "' cannot set the request's data to null.").toString());
        }
        if (imageRequest.target != imageRequest2.target) {
            throw new IllegalStateException(("Interceptor '" + engineInterceptor + "' cannot modify the request's target.").toString());
        }
        if (imageRequest.lifecycle != imageRequest2.lifecycle) {
            throw new IllegalStateException(("Interceptor '" + engineInterceptor + "' cannot modify the request's lifecycle.").toString());
        }
        if (imageRequest.sizeResolver == imageRequest2.sizeResolver) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + engineInterceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.initialRequest) {
            ((ImageReaderProxy) this.request).clearOnImageAvailableListener();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.initialRequest) {
            try {
                Surface surface = (Surface) this.interceptors;
                if (surface != null) {
                    surface.release();
                }
                ((ImageReaderProxy) this.request).close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.initialRequest) {
            height = ((ImageReaderProxy) this.request).getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.initialRequest) {
            imageFormat = ((ImageReaderProxy) this.request).getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.initialRequest) {
            maxImages = ((ImageReaderProxy) this.request).getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Surface surface;
        synchronized (this.initialRequest) {
            surface = ((ImageReaderProxy) this.request).getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.initialRequest) {
            width = ((ImageReaderProxy) this.request).getWidth();
        }
        return width;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public Object proceed(ImageRequest imageRequest, ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        EngineInterceptor engineInterceptor;
        RealInterceptorChain realInterceptorChain;
        List list = (List) this.interceptors;
        int i = this.index;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (i > 0) {
                checkRequest(imageRequest, (EngineInterceptor) list.get(i - 1));
            }
            EngineInterceptor engineInterceptor2 = (EngineInterceptor) list.get(i);
            RealInterceptorChain realInterceptorChain2 = new RealInterceptorChain((ImageRequest) this.initialRequest, (List) this.interceptors, i + 1, imageRequest, (Size) this.size, (EventListener$Companion$NONE$1) this.eventListener, this.isPlaceholderCached);
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = engineInterceptor2;
            anonymousClass1.label = 1;
            Object objIntercept = engineInterceptor2.intercept(realInterceptorChain2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objIntercept == coroutineSingletons) {
                return coroutineSingletons;
            }
            obj = objIntercept;
            engineInterceptor = engineInterceptor2;
            realInterceptorChain = this;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            engineInterceptor = anonymousClass1.L$1;
            realInterceptorChain = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ImageResult imageResult = (ImageResult) obj;
        realInterceptorChain.checkRequest(imageResult.getRequest(), engineInterceptor);
        return imageResult;
    }

    public void safeClose() {
        synchronized (this.initialRequest) {
            try {
                this.isPlaceholderCached = true;
                ((ImageReaderProxy) this.request).clearOnImageAvailableListener();
                if (this.index == 0) {
                    close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        synchronized (this.initialRequest) {
            ((ImageReaderProxy) this.request).setOnImageAvailableListener(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(4, this, onImageAvailableListener), executor);
        }
    }

    public RealInterceptorChain(ImageReaderProxy imageReaderProxy) {
        this.initialRequest = new Object();
        this.index = 0;
        this.isPlaceholderCached = false;
        this.eventListener = new SafeCloseImageReaderProxy$$ExternalSyntheticLambda1(0, this);
        this.request = imageReaderProxy;
        this.interceptors = imageReaderProxy.getSurface();
    }

    public RealInterceptorChain() {
        this.initialRequest = new HashSet();
        this.request = MutableOptionsBundle.create();
        this.index = -1;
        this.interceptors = new ArrayList();
        this.isPlaceholderCached = false;
        this.size = MutableTagBundle.create();
    }

    public RealInterceptorChain(CaptureConfig captureConfig) {
        HashSet hashSet = new HashSet();
        this.initialRequest = hashSet;
        this.request = MutableOptionsBundle.create();
        this.index = -1;
        ArrayList arrayList = new ArrayList();
        this.interceptors = arrayList;
        this.isPlaceholderCached = false;
        this.size = MutableTagBundle.create();
        hashSet.addAll(captureConfig.mSurfaces);
        this.request = MutableOptionsBundle.from((Config) captureConfig.mImplementationOptions);
        this.index = captureConfig.mTemplateType;
        arrayList.addAll(captureConfig.mCameraCaptureCallbacks);
        this.isPlaceholderCached = captureConfig.mUseRepeatingSurface;
        TagBundle tagBundle = captureConfig.mTagBundle;
        ArrayMap arrayMap = new ArrayMap();
        for (String str : tagBundle.mTagMap.keySet()) {
            arrayMap.put(str, tagBundle.mTagMap.get(str));
        }
        this.size = new MutableTagBundle(arrayMap);
    }
}
