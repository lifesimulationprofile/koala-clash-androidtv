package androidx.compose.ui.node;

import androidx.compose.ui.graphics.TransformOrigin;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LayerPositionalProperties {
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public long transformOrigin;
    public float translationX;
    public float translationY;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float cameraDistance = 8.0f;

    public LayerPositionalProperties() {
        int i = TransformOrigin.$r8$clinit;
        this.transformOrigin = TransformOrigin.Center;
    }
}
