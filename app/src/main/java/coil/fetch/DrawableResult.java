package coil.fetch;

import android.graphics.drawable.Drawable;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DrawableResult extends FetchResult {
    public final int dataSource;
    public final Drawable drawable;
    public final boolean isSampled;

    public DrawableResult(Drawable drawable, boolean z, int i) {
        this.drawable = drawable;
        this.isSampled = z;
        this.dataSource = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableResult)) {
            return false;
        }
        DrawableResult drawableResult = (DrawableResult) obj;
        return Intrinsics.areEqual(this.drawable, drawableResult.drawable) && this.isSampled == drawableResult.isSampled && this.dataSource == drawableResult.dataSource;
    }

    public final int hashCode() {
        return CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.dataSource) + (((this.drawable.hashCode() * 31) + (this.isSampled ? 1231 : 1237)) * 31);
    }
}
