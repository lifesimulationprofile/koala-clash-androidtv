package androidx.compose.foundation.layout;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RowColumnParentData {
    public float weight = 0.0f;
    public boolean fill = true;
    public CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) obj;
        return Float.compare(this.weight, rowColumnParentData.weight) == 0 && this.fill == rowColumnParentData.fill && Intrinsics.areEqual(this.crossAxisAlignment, rowColumnParentData.crossAxisAlignment);
    }

    public final int hashCode() {
        int iFloatToIntBits = ((Float.floatToIntBits(this.weight) * 31) + (this.fill ? 1231 : 1237)) * 31;
        CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment$HorizontalCrossAxisAlignment = this.crossAxisAlignment;
        return (iFloatToIntBits + (crossAxisAlignment$HorizontalCrossAxisAlignment == null ? 0 : crossAxisAlignment$HorizontalCrossAxisAlignment.horizontal.hashCode())) * 31;
    }

    public final String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ", flowLayoutData=null)";
    }
}
