package coil.compose;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.RealImageLoader;
import coil.request.ImageRequest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncImageState {
    public final RealImageLoader imageLoader;
    public final Object model;
    public final EqualityDelegateKt$DefaultModelEqualityDelegate$1 modelEqualityDelegate;

    public AsyncImageState(Object obj, EqualityDelegateKt$DefaultModelEqualityDelegate$1 equalityDelegateKt$DefaultModelEqualityDelegate$1, RealImageLoader realImageLoader) {
        this.model = obj;
        this.modelEqualityDelegate = equalityDelegateKt$DefaultModelEqualityDelegate$1;
        this.imageLoader = realImageLoader;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    public final boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (obj instanceof AsyncImageState) {
                AsyncImageState asyncImageState = (AsyncImageState) obj;
                Object obj2 = asyncImageState.model;
                this.modelEqualityDelegate.getClass();
                Object obj3 = this.model;
                if (obj3 == obj2) {
                    zAreEqual = true;
                } else if ((obj3 instanceof ImageRequest) && (obj2 instanceof ImageRequest)) {
                    ImageRequest imageRequest = (ImageRequest) obj3;
                    ImageRequest imageRequest2 = (ImageRequest) obj2;
                    if (Intrinsics.areEqual(imageRequest.context, imageRequest2.context) && imageRequest.data.equals(imageRequest2.data) && imageRequest.bitmapConfig == imageRequest2.bitmapConfig && Intrinsics.areEqual(imageRequest.transformations, imageRequest2.transformations) && Intrinsics.areEqual(imageRequest.headers, imageRequest2.headers) && imageRequest.allowConversionToBitmap == imageRequest2.allowConversionToBitmap && imageRequest.allowHardware == imageRequest2.allowHardware && imageRequest.allowRgb565 == imageRequest2.allowRgb565 && imageRequest.premultipliedAlpha == imageRequest2.premultipliedAlpha && imageRequest.memoryCachePolicy == imageRequest2.memoryCachePolicy && imageRequest.diskCachePolicy == imageRequest2.diskCachePolicy && imageRequest.networkCachePolicy == imageRequest2.networkCachePolicy && imageRequest.sizeResolver.equals(imageRequest2.sizeResolver) && imageRequest.scale == imageRequest2.scale && imageRequest.precision == imageRequest2.precision && imageRequest.parameters.equals(imageRequest2.parameters)) {
                        zAreEqual = true;
                    } else {
                        zAreEqual = false;
                    }
                } else {
                    zAreEqual = Intrinsics.areEqual(obj3, obj2);
                }
                if (!zAreEqual || !this.imageLoader.equals(asyncImageState.imageLoader)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode;
        this.modelEqualityDelegate.getClass();
        Object obj = this.model;
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            iHashCode = imageRequest.parameters.entries.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.precision, ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.scale, (imageRequest.sizeResolver.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.networkCachePolicy, ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.diskCachePolicy, ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.memoryCachePolicy, (((((((((((imageRequest.transformations.hashCode() + ((imageRequest.bitmapConfig.hashCode() + ((imageRequest.data.hashCode() + (imageRequest.context.hashCode() * 31)) * 923521)) * 961)) * 31) + Arrays.hashCode(imageRequest.headers.namesAndValues)) * 31) + (imageRequest.allowConversionToBitmap ? 1231 : 1237)) * 31) + (imageRequest.allowHardware ? 1231 : 1237)) * 31) + (imageRequest.allowRgb565 ? 1231 : 1237)) * 31) + (imageRequest.premultipliedAlpha ? 1231 : 1237)) * 31, 31), 31), 31)) * 31, 31), 31);
        } else {
            iHashCode = obj != null ? obj.hashCode() : 0;
        }
        return this.imageLoader.hashCode() + (iHashCode * 31);
    }
}
