package androidx.compose.ui.graphics;

import android.graphics.PathMeasure;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPathMeasure {
    public final PathMeasure internalPathMeasure;

    public AndroidPathMeasure(PathMeasure pathMeasure) {
        this.internalPathMeasure = pathMeasure;
    }

    public final boolean getSegment(float f, float f2, AndroidPath androidPath) {
        if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) androidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        return this.internalPathMeasure.getSegment(f, f2, androidPath.internalPath, true);
    }
}
