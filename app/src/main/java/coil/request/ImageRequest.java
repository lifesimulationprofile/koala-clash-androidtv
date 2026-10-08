package coil.request;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil.size.DisplaySizeResolver;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.transition.Transition;
import coil.util.Collections;
import coil.util.Requests;
import coil.util.Utils;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageRequest {
    public final boolean allowConversionToBitmap;
    public final boolean allowHardware;
    public final boolean allowRgb565;
    public final Bitmap.Config bitmapConfig;
    public final Context context;
    public final Object data;
    public final CoroutineDispatcher decoderDispatcher;
    public final DefaultRequestOptions defaults;
    public final DefinedRequestOptions defined;
    public final int diskCachePolicy;
    public final CoroutineDispatcher fetcherDispatcher;
    public final Headers headers;
    public final CoroutineDispatcher interceptorDispatcher;
    public final Lifecycle lifecycle;
    public final int memoryCachePolicy;
    public final int networkCachePolicy;
    public final Parameters parameters;
    public final int precision;
    public final boolean premultipliedAlpha;
    public final int scale;
    public final SizeResolver sizeResolver;
    public final Tags tags;
    public final Target target;
    public final CoroutineDispatcher transformationDispatcher;
    public final List transformations;
    public final Transition.Factory transitionFactory;

    public ImageRequest(Context context, Object obj, Target target, Bitmap.Config config, int i, List list, Transition.Factory factory, Headers headers, Tags tags, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, int i5, Parameters parameters, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions) {
        this.context = context;
        this.data = obj;
        this.target = target;
        this.bitmapConfig = config;
        this.precision = i;
        this.transformations = list;
        this.transitionFactory = factory;
        this.headers = headers;
        this.tags = tags;
        this.allowConversionToBitmap = z;
        this.allowHardware = z2;
        this.allowRgb565 = z3;
        this.premultipliedAlpha = z4;
        this.memoryCachePolicy = i2;
        this.diskCachePolicy = i3;
        this.networkCachePolicy = i4;
        this.interceptorDispatcher = coroutineDispatcher;
        this.fetcherDispatcher = coroutineDispatcher2;
        this.decoderDispatcher = coroutineDispatcher3;
        this.transformationDispatcher = coroutineDispatcher4;
        this.lifecycle = lifecycle;
        this.sizeResolver = sizeResolver;
        this.scale = i5;
        this.parameters = parameters;
        this.defined = definedRequestOptions;
        this.defaults = defaultRequestOptions;
    }

    public static Builder newBuilder$default(ImageRequest imageRequest) {
        Context context = imageRequest.context;
        imageRequest.getClass();
        return new Builder(imageRequest, context);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        return Intrinsics.areEqual(this.context, imageRequest.context) && this.data.equals(imageRequest.data) && Intrinsics.areEqual(this.target, imageRequest.target) && this.bitmapConfig == imageRequest.bitmapConfig && this.precision == imageRequest.precision && Intrinsics.areEqual(this.transformations, imageRequest.transformations) && Intrinsics.areEqual(this.transitionFactory, imageRequest.transitionFactory) && Intrinsics.areEqual(this.headers, imageRequest.headers) && this.tags.equals(imageRequest.tags) && this.allowConversionToBitmap == imageRequest.allowConversionToBitmap && this.allowHardware == imageRequest.allowHardware && this.allowRgb565 == imageRequest.allowRgb565 && this.premultipliedAlpha == imageRequest.premultipliedAlpha && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.areEqual(this.interceptorDispatcher, imageRequest.interceptorDispatcher) && Intrinsics.areEqual(this.fetcherDispatcher, imageRequest.fetcherDispatcher) && Intrinsics.areEqual(this.decoderDispatcher, imageRequest.decoderDispatcher) && Intrinsics.areEqual(this.transformationDispatcher, imageRequest.transformationDispatcher) && Intrinsics.areEqual(this.lifecycle, imageRequest.lifecycle) && this.sizeResolver.equals(imageRequest.sizeResolver) && this.scale == imageRequest.scale && this.parameters.equals(imageRequest.parameters) && this.defined.equals(imageRequest.defined) && Intrinsics.areEqual(this.defaults, imageRequest.defaults);
    }

    public final int hashCode() {
        int iHashCode = (this.data.hashCode() + (this.context.hashCode() * 31)) * 31;
        Target target = this.target;
        return this.defaults.hashCode() + ((this.defined.hashCode() + ((this.parameters.entries.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.scale, (this.sizeResolver.hashCode() + ((this.lifecycle.hashCode() + ((this.transformationDispatcher.hashCode() + ((this.decoderDispatcher.hashCode() + ((this.fetcherDispatcher.hashCode() + ((this.interceptorDispatcher.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.networkCachePolicy, ImageAnalysis$$ExternalSyntheticLambda1.m(this.diskCachePolicy, ImageAnalysis$$ExternalSyntheticLambda1.m(this.memoryCachePolicy, (((((((((this.tags.tags.hashCode() + ((((this.transitionFactory.hashCode() + ((this.transformations.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.precision, (this.bitmapConfig.hashCode() + ((iHashCode + (target != null ? target.hashCode() : 0)) * 923521)) * 961, 29791)) * 31)) * 31) + Arrays.hashCode(this.headers.namesAndValues)) * 31)) * 31) + (this.allowConversionToBitmap ? 1231 : 1237)) * 31) + (this.allowHardware ? 1231 : 1237)) * 31) + (this.allowRgb565 ? 1231 : 1237)) * 31) + (this.premultipliedAlpha ? 1231 : 1237)) * 31, 31), 31), 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31)) * (-1807454463))) * 31);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder {
        public final boolean allowConversionToBitmap;
        public final Context context;
        public Object data;
        public DefaultRequestOptions defaults;
        public final Headers.Builder headers;
        public final Parameters.Builder parameters;
        public int precision;
        public final boolean premultipliedAlpha;
        public Lifecycle resolvedLifecycle;
        public int resolvedScale;
        public SizeResolver resolvedSizeResolver;
        public int scale;
        public SizeResolver sizeResolver;
        public final LinkedHashMap tags;
        public Target target;
        public final List transformations;
        public Transition.Factory transitionFactory;

        public Builder(Context context) {
            this.context = context;
            this.defaults = Requests.DEFAULT_REQUEST_OPTIONS;
            this.data = null;
            this.target = null;
            this.precision = 0;
            this.transformations = EmptyList.INSTANCE;
            this.transitionFactory = null;
            this.headers = null;
            this.tags = null;
            this.allowConversionToBitmap = true;
            this.premultipliedAlpha = true;
            this.parameters = null;
            this.sizeResolver = null;
            this.scale = 0;
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = 0;
        }

        public final ImageRequest build() {
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target = this.target;
            DefaultRequestOptions defaultRequestOptions = this.defaults;
            Bitmap.Config config = defaultRequestOptions.bitmapConfig;
            int i = this.precision;
            if (i == 0) {
                i = defaultRequestOptions.precision;
            }
            int i2 = i;
            Transition.Factory factory = this.transitionFactory;
            if (factory == null) {
                factory = defaultRequestOptions.transitionFactory;
            }
            Transition.Factory factory2 = factory;
            Headers.Builder builder = this.headers;
            Headers headersBuild = builder != null ? builder.build() : null;
            if (headersBuild == null) {
                headersBuild = Utils.EMPTY_HEADERS;
            } else {
                Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
            }
            Headers headers = headersBuild;
            LinkedHashMap linkedHashMap = this.tags;
            Tags tags = linkedHashMap != null ? new Tags(Collections.toImmutableMap(linkedHashMap)) : null;
            if (tags == null) {
                tags = Tags.EMPTY;
            }
            Tags tags2 = tags;
            DefaultRequestOptions defaultRequestOptions2 = this.defaults;
            boolean z = defaultRequestOptions2.allowHardware;
            defaultRequestOptions2.getClass();
            DefaultRequestOptions defaultRequestOptions3 = this.defaults;
            int i3 = defaultRequestOptions3.memoryCachePolicy;
            int i4 = defaultRequestOptions3.diskCachePolicy;
            int i5 = defaultRequestOptions3.networkCachePolicy;
            CoroutineDispatcher coroutineDispatcher = defaultRequestOptions3.interceptorDispatcher;
            CoroutineDispatcher coroutineDispatcher2 = defaultRequestOptions3.fetcherDispatcher;
            CoroutineDispatcher coroutineDispatcher3 = defaultRequestOptions3.decoderDispatcher;
            CoroutineDispatcher coroutineDispatcher4 = defaultRequestOptions3.transformationDispatcher;
            Lifecycle lifecycle = this.resolvedLifecycle;
            Context context = this.context;
            if (lifecycle == null) {
                Object baseContext = context;
                while (true) {
                    if (baseContext instanceof LifecycleOwner) {
                        lifecycle = ((LifecycleOwner) baseContext).getLifecycle();
                        break;
                    }
                    if (!(baseContext instanceof ContextWrapper)) {
                        lifecycle = null;
                        break;
                    }
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                }
                if (lifecycle == null) {
                    lifecycle = GlobalLifecycle.INSTANCE;
                }
            }
            Lifecycle lifecycle2 = lifecycle;
            SizeResolver displaySizeResolver = this.sizeResolver;
            if (displaySizeResolver == null && (displaySizeResolver = this.resolvedSizeResolver) == null) {
                displaySizeResolver = new DisplaySizeResolver(context);
            }
            SizeResolver sizeResolver = displaySizeResolver;
            int i6 = this.scale;
            if (i6 == 0 && (i6 = this.resolvedScale) == 0) {
                i6 = 2;
            }
            int i7 = i6;
            Parameters.Builder builder2 = this.parameters;
            Parameters parameters = builder2 != null ? new Parameters(Collections.toImmutableMap((LinkedHashMap) builder2.entries)) : null;
            if (parameters == null) {
                parameters = Parameters.EMPTY;
            }
            return new ImageRequest(context, obj2, target, config, i2, this.transformations, factory2, headers, tags2, this.allowConversionToBitmap, z, false, this.premultipliedAlpha, i3, i4, i5, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle2, sizeResolver, i7, parameters, new DefinedRequestOptions(this.sizeResolver, this.scale, this.transitionFactory, this.precision), this.defaults);
        }

        public Builder(ImageRequest imageRequest, Context context) {
            this.context = context;
            this.defaults = imageRequest.defaults;
            this.data = imageRequest.data;
            this.target = imageRequest.target;
            DefinedRequestOptions definedRequestOptions = imageRequest.defined;
            this.precision = definedRequestOptions.precision;
            this.transformations = imageRequest.transformations;
            this.transitionFactory = definedRequestOptions.transitionFactory;
            this.headers = imageRequest.headers.newBuilder();
            this.tags = new LinkedHashMap(imageRequest.tags.tags);
            this.allowConversionToBitmap = imageRequest.allowConversionToBitmap;
            this.premultipliedAlpha = imageRequest.premultipliedAlpha;
            this.parameters = new Parameters.Builder(imageRequest.parameters);
            this.sizeResolver = definedRequestOptions.sizeResolver;
            this.scale = definedRequestOptions.scale;
            if (imageRequest.context == context) {
                this.resolvedLifecycle = imageRequest.lifecycle;
                this.resolvedSizeResolver = imageRequest.sizeResolver;
                this.resolvedScale = imageRequest.scale;
            } else {
                this.resolvedLifecycle = null;
                this.resolvedSizeResolver = null;
                this.resolvedScale = 0;
            }
        }
    }
}
