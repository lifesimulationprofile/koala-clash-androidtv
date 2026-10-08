package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface RowColumnMeasurePolicy {
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    long mo113createConstraintsxF2OJ5Q(int i, int i2, int i3, boolean z);

    int crossAxisSize(Placeable placeable);

    int mainAxisSize(Placeable placeable);

    MeasureResult placeHelper(Placeable[] placeableArr, MeasureScope measureScope, int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5);

    void populateMainAxisPositions(int i, MeasureScope measureScope, int[] iArr, int[] iArr2);
}
