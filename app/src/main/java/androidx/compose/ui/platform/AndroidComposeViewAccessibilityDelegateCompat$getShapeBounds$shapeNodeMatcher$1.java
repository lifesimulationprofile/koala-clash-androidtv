package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1 implements SemanticsPropertyReceiver {
    public final /* synthetic */ Shape $shape;
    public boolean hasMatchedShape;

    public AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1(Shape shape) {
        this.$shape = shape;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final void set(SemanticsPropertyKey semanticsPropertyKey, Object obj) {
        if (obj == this.$shape) {
            this.hasMatchedShape = true;
        }
    }
}
