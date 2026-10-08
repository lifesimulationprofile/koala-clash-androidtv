package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VerticalScrollableClipShape implements Shape {
    public final /* synthetic */ int $r8$classId;
    public static final VerticalScrollableClipShape INSTANCE$1 = new VerticalScrollableClipShape(1);
    public static final VerticalScrollableClipShape INSTANCE = new VerticalScrollableClipShape(0);

    public /* synthetic */ VerticalScrollableClipShape(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public final BrushKt mo60createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        switch (this.$r8$classId) {
            case 0:
                float fMo86roundToPx0680j_4 = density.mo86roundToPx0680j_4(ClipScrollableContainerKt.MaxSupportedElevation);
                return new Outline$Rectangle(new Rect(-fMo86roundToPx0680j_4, 0.0f, Float.intBitsToFloat((int) (j >> 32)) + fMo86roundToPx0680j_4, Float.intBitsToFloat((int) (j & 4294967295L))));
            default:
                float fMo86roundToPx0680j_5 = density.mo86roundToPx0680j_4(ClipScrollableContainerKt.MaxSupportedElevation);
                return new Outline$Rectangle(new Rect(0.0f, -fMo86roundToPx0680j_5, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)) + fMo86roundToPx0680j_5));
        }
    }
}
