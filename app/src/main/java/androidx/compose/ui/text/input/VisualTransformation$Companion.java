package androidx.compose.ui.text.input;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VisualTransformation$Companion implements OffsetMapping {
    public static final ZslControlImpl$$ExternalSyntheticLambda0 None = new ZslControlImpl$$ExternalSyntheticLambda0(20);

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int originalToTransformed(int i) {
        return i;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int transformedToOriginal(int i) {
        return i;
    }
}
