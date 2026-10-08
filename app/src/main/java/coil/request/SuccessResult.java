package coil.request;

import android.graphics.drawable.Drawable;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.memory.MemoryCache$Key;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SuccessResult extends ImageResult {
    public final int dataSource;
    public final String diskCacheKey;
    public final Drawable drawable;
    public final boolean isPlaceholderCached;
    public final boolean isSampled;
    public final MemoryCache$Key memoryCacheKey;
    public final ImageRequest request;

    public SuccessResult(Drawable drawable, ImageRequest imageRequest, int i, MemoryCache$Key memoryCache$Key, String str, boolean z, boolean z2) {
        this.drawable = drawable;
        this.request = imageRequest;
        this.dataSource = i;
        this.memoryCacheKey = memoryCache$Key;
        this.diskCacheKey = str;
        this.isSampled = z;
        this.isPlaceholderCached = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.areEqual(this.drawable, successResult.drawable) && Intrinsics.areEqual(this.request, successResult.request) && this.dataSource == successResult.dataSource && Intrinsics.areEqual(this.memoryCacheKey, successResult.memoryCacheKey) && Intrinsics.areEqual(this.diskCacheKey, successResult.diskCacheKey) && this.isSampled == successResult.isSampled && this.isPlaceholderCached == successResult.isPlaceholderCached;
    }

    @Override // coil.request.ImageResult
    public final Drawable getDrawable() {
        return this.drawable;
    }

    @Override // coil.request.ImageResult
    public final ImageRequest getRequest() {
        return this.request;
    }

    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.dataSource, (this.request.hashCode() + (this.drawable.hashCode() * 31)) * 31, 31);
        MemoryCache$Key memoryCache$Key = this.memoryCacheKey;
        int iHashCode = (iM + (memoryCache$Key != null ? memoryCache$Key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + (this.isSampled ? 1231 : 1237)) * 31) + (this.isPlaceholderCached ? 1231 : 1237);
    }
}
