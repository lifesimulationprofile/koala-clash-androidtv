package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LimitInsets implements WindowInsets {
    public final WindowInsets insets;
    public final int sides;

    public LimitInsets(WindowInsets windowInsets, int i) {
        this.insets = windowInsets;
        this.sides = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) obj;
        return Intrinsics.areEqual(this.insets, limitInsets.insets) && this.sides == limitInsets.sides;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        if ((this.sides & 32) != 0) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        if (((layoutDirection == LayoutDirection.Ltr ? 8 : 2) & this.sides) != 0) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        if (((layoutDirection == LayoutDirection.Ltr ? 4 : 1) & this.sides) != 0) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        if ((this.sides & 16) != 0) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    public final int hashCode() {
        return (this.insets.hashCode() * 31) + this.sides;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.insets);
        sb.append(" only ");
        StringBuilder sb2 = new StringBuilder("WindowInsetsSides(");
        StringBuilder sb3 = new StringBuilder();
        int i = OffsetKt.Start;
        int i2 = this.sides;
        if ((i2 & i) == i) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb3, "Start");
        }
        int i3 = OffsetKt.Left;
        if ((i2 & i3) == i3) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb3, "Left");
        }
        if ((i2 & 16) == 16) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb3, "Top");
        }
        int i4 = OffsetKt.End;
        if ((i2 & i4) == i4) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb3, "End");
        }
        int i5 = OffsetKt.Right;
        if ((i2 & i5) == i5) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb3, "Right");
        }
        if ((i2 & 32) == 32) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb3, "Bottom");
        }
        sb2.append(sb3.toString());
        sb2.append(')');
        sb.append((Object) sb2.toString());
        sb.append(')');
        return sb.toString();
    }
}
