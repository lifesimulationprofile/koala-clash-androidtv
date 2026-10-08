package androidx.compose.foundation;

import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BorderCache {
    public AndroidImageBitmap imageBitmap = null;
    public AndroidCanvas canvas = null;
    public CanvasDrawScope canvasDrawScope = null;
    public AndroidPath borderPath = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) obj;
        return Intrinsics.areEqual(this.imageBitmap, borderCache.imageBitmap) && Intrinsics.areEqual(this.canvas, borderCache.canvas) && Intrinsics.areEqual(this.canvasDrawScope, borderCache.canvasDrawScope) && Intrinsics.areEqual(this.borderPath, borderCache.borderPath);
    }

    public final int hashCode() {
        AndroidImageBitmap androidImageBitmap = this.imageBitmap;
        int iHashCode = (androidImageBitmap == null ? 0 : androidImageBitmap.hashCode()) * 31;
        AndroidCanvas androidCanvas = this.canvas;
        int iHashCode2 = (iHashCode + (androidCanvas == null ? 0 : androidCanvas.hashCode())) * 31;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        int iHashCode3 = (iHashCode2 + (canvasDrawScope == null ? 0 : canvasDrawScope.hashCode())) * 31;
        AndroidPath androidPath = this.borderPath;
        return iHashCode3 + (androidPath != null ? androidPath.hashCode() : 0);
    }

    public final String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }
}
