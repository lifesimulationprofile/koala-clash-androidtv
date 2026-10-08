package androidx.compose.material3;

import android.graphics.PathMeasure;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.AndroidPath_androidKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CheckDrawingCache {
    public final AndroidPath checkPath;
    public final AndroidPathMeasure pathMeasure;
    public final AndroidPath pathToDraw;

    public CheckDrawingCache() {
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        AndroidPathMeasure androidPathMeasure = new AndroidPathMeasure(new PathMeasure());
        AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
        this.checkPath = androidPathPath;
        this.pathMeasure = androidPathMeasure;
        this.pathToDraw = androidPathPath2;
    }
}
