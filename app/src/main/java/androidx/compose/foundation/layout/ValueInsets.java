package androidx.compose.foundation.layout;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ValueInsets implements WindowInsets {
    public final String name;
    public final ParcelableSnapshotMutableState value$delegate;

    public ValueInsets(InsetsValues insetsValues, String str) {
        this.name = str;
        this.value$delegate = Stack.mutableStateOf$default(insetsValues);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ValueInsets) {
            return Intrinsics.areEqual(getValue$foundation_layout(), ((ValueInsets) obj).getValue$foundation_layout());
        }
        return false;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        return getValue$foundation_layout().bottom;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        return getValue$foundation_layout().left;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        return getValue$foundation_layout().right;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        return getValue$foundation_layout().top;
    }

    public final InsetsValues getValue$foundation_layout() {
        return (InsetsValues) this.value$delegate.getValue();
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final void setValue$foundation_layout(InsetsValues insetsValues) {
        this.value$delegate.setValue(insetsValues);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("(left=");
        sb.append(getValue$foundation_layout().left);
        sb.append(", top=");
        sb.append(getValue$foundation_layout().top);
        sb.append(", right=");
        sb.append(getValue$foundation_layout().right);
        sb.append(", bottom=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, getValue$foundation_layout().bottom, ')');
    }
}
