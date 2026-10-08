package coil.request;

import android.graphics.Bitmap;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.util.Utils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultRequestOptions {
    public final boolean allowHardware;
    public final Bitmap.Config bitmapConfig;
    public final CoroutineDispatcher decoderDispatcher;
    public final int diskCachePolicy;
    public final CoroutineDispatcher fetcherDispatcher;
    public final CoroutineDispatcher interceptorDispatcher;
    public final int memoryCachePolicy;
    public final int networkCachePolicy;
    public final int precision;
    public final CoroutineDispatcher transformationDispatcher;
    public final NoneTransition.Factory transitionFactory;

    public DefaultRequestOptions() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        HandlerContext handlerContext = ((HandlerContext) MainDispatcherLoader.dispatcher).immediate;
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        Bitmap.Config config = Utils.DEFAULT_BITMAP_CONFIG;
        this.interceptorDispatcher = handlerContext;
        this.fetcherDispatcher = defaultIoScheduler;
        this.decoderDispatcher = defaultIoScheduler;
        this.transformationDispatcher = defaultIoScheduler;
        this.transitionFactory = Transition.Factory.NONE;
        this.precision = 3;
        this.bitmapConfig = config;
        this.allowHardware = true;
        this.memoryCachePolicy = 1;
        this.diskCachePolicy = 1;
        this.networkCachePolicy = 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultRequestOptions)) {
            return false;
        }
        DefaultRequestOptions defaultRequestOptions = (DefaultRequestOptions) obj;
        return Intrinsics.areEqual(this.interceptorDispatcher, defaultRequestOptions.interceptorDispatcher) && Intrinsics.areEqual(this.fetcherDispatcher, defaultRequestOptions.fetcherDispatcher) && Intrinsics.areEqual(this.decoderDispatcher, defaultRequestOptions.decoderDispatcher) && Intrinsics.areEqual(this.transformationDispatcher, defaultRequestOptions.transformationDispatcher) && Intrinsics.areEqual(this.transitionFactory, defaultRequestOptions.transitionFactory) && this.precision == defaultRequestOptions.precision && this.bitmapConfig == defaultRequestOptions.bitmapConfig && this.allowHardware == defaultRequestOptions.allowHardware && this.memoryCachePolicy == defaultRequestOptions.memoryCachePolicy && this.diskCachePolicy == defaultRequestOptions.diskCachePolicy && this.networkCachePolicy == defaultRequestOptions.networkCachePolicy;
    }

    public final int hashCode() {
        int iHashCode = (this.transformationDispatcher.hashCode() + ((this.decoderDispatcher.hashCode() + ((this.fetcherDispatcher.hashCode() + (this.interceptorDispatcher.hashCode() * 31)) * 31)) * 31)) * 31;
        this.transitionFactory.getClass();
        return CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.networkCachePolicy) + ImageAnalysis$$ExternalSyntheticLambda1.m(this.diskCachePolicy, ImageAnalysis$$ExternalSyntheticLambda1.m(this.memoryCachePolicy, (((((this.bitmapConfig.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.precision, (NoneTransition.Factory.class.hashCode() + iHashCode) * 31, 31)) * 31) + (this.allowHardware ? 1231 : 1237)) * 31) + 1237) * 923521, 31), 31);
    }
}
