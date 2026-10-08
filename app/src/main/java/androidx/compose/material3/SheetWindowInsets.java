package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SheetWindowInsets implements WindowInsets {
    public final SheetState state;

    public SheetWindowInsets(SheetState sheetState) {
        this.state = sheetState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SheetWindowInsets)) {
            return false;
        }
        return Intrinsics.areEqual(this.state, ((SheetWindowInsets) obj).state);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        int i;
        float floatValue = ((ParcelableSnapshotMutableFloatState) ((NodeChain) this.state.anchoredDraggableState.val$requestCancellationCompleter).head).getFloatValue();
        if (!Float.isNaN(floatValue) && (i = (int) floatValue) >= 0) {
            return i;
        }
        return 0;
    }

    public final int hashCode() {
        return this.state.hashCode();
    }
}
