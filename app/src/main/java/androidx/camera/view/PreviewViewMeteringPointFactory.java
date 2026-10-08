package androidx.camera.view;

import android.graphics.PointF;
import android.graphics.Rect;
import androidx.camera.core.MeteringPointFactory;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PreviewViewMeteringPointFactory extends MeteringPointFactory {
    public final PreviewTransformation mPreviewTransformation;
    public Rect mSensorRect = null;

    static {
        new PointF(2.0f, 2.0f);
    }

    public PreviewViewMeteringPointFactory(PreviewTransformation previewTransformation) {
        this.mPreviewTransformation = previewTransformation;
    }
}
