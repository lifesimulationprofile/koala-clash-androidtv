package androidx.compose.material3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialTheme$Values {
    public final ColorScheme colorScheme;
    public final MotionScheme motionScheme;
    public final Shapes shapes;
    public final Typography typography;

    public MaterialTheme$Values(ColorScheme colorScheme, Typography typography, Shapes shapes, MotionScheme motionScheme) {
        this.colorScheme = colorScheme;
        this.typography = typography;
        this.shapes = shapes;
        this.motionScheme = motionScheme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MaterialTheme$Values.class != obj.getClass()) {
            return false;
        }
        MaterialTheme$Values materialTheme$Values = (MaterialTheme$Values) obj;
        return Intrinsics.areEqual(this.colorScheme, materialTheme$Values.colorScheme) && Intrinsics.areEqual(this.typography, materialTheme$Values.typography) && Intrinsics.areEqual(this.shapes, materialTheme$Values.shapes) && Intrinsics.areEqual(this.motionScheme, materialTheme$Values.motionScheme);
    }

    public final int hashCode() {
        return this.motionScheme.hashCode() + ((this.shapes.hashCode() + ((this.typography.hashCode() + (this.colorScheme.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Values(colorScheme=" + this.colorScheme + ", typography=" + this.typography + ", shapes=" + this.shapes + ", motionScheme=" + this.motionScheme + ')';
    }
}
