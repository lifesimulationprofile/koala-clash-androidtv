package coil.request;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ErrorResult extends ImageResult {
    public final Drawable drawable;
    public final ImageRequest request;
    public final Throwable throwable;

    public ErrorResult(Drawable drawable, ImageRequest imageRequest, Throwable th) {
        this.drawable = drawable;
        this.request = imageRequest;
        this.throwable = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.areEqual(this.drawable, errorResult.drawable) && Intrinsics.areEqual(this.request, errorResult.request) && Intrinsics.areEqual(this.throwable, errorResult.throwable);
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
        Drawable drawable = this.drawable;
        return this.throwable.hashCode() + ((this.request.hashCode() + ((drawable != null ? drawable.hashCode() : 0) * 31)) * 31);
    }
}
