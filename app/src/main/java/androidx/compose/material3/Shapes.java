package androidx.compose.material3;

import androidx.compose.foundation.shape.RoundedCornerShape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Shapes {
    public final RoundedCornerShape extraExtraLarge;
    public final RoundedCornerShape extraLarge;
    public final RoundedCornerShape extraLargeIncreased;
    public final RoundedCornerShape extraSmall;
    public final RoundedCornerShape large;
    public final RoundedCornerShape largeIncreased;
    public final RoundedCornerShape medium;
    public final RoundedCornerShape small;

    public Shapes() {
        RoundedCornerShape roundedCornerShape = ShapeDefaults.ExtraSmall;
        RoundedCornerShape roundedCornerShape2 = ShapeDefaults.Small;
        RoundedCornerShape roundedCornerShape3 = ShapeDefaults.Medium;
        RoundedCornerShape roundedCornerShape4 = ShapeDefaults.Large;
        RoundedCornerShape roundedCornerShape5 = ShapeDefaults.ExtraLarge;
        RoundedCornerShape roundedCornerShape6 = ShapeDefaults.LargeIncreased;
        RoundedCornerShape roundedCornerShape7 = ShapeDefaults.ExtraLargeIncreased;
        RoundedCornerShape roundedCornerShape8 = ShapeDefaults.ExtraExtraLarge;
        this.extraSmall = roundedCornerShape;
        this.small = roundedCornerShape2;
        this.medium = roundedCornerShape3;
        this.large = roundedCornerShape4;
        this.extraLarge = roundedCornerShape5;
        this.largeIncreased = roundedCornerShape6;
        this.extraLargeIncreased = roundedCornerShape7;
        this.extraExtraLarge = roundedCornerShape8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) obj;
        return Intrinsics.areEqual(this.extraSmall, shapes.extraSmall) && Intrinsics.areEqual(this.small, shapes.small) && Intrinsics.areEqual(this.medium, shapes.medium) && Intrinsics.areEqual(this.large, shapes.large) && Intrinsics.areEqual(this.extraLarge, shapes.extraLarge) && Intrinsics.areEqual(this.largeIncreased, shapes.largeIncreased) && Intrinsics.areEqual(this.extraLargeIncreased, shapes.extraLargeIncreased) && Intrinsics.areEqual(this.extraExtraLarge, shapes.extraExtraLarge);
    }

    public final int hashCode() {
        return this.extraExtraLarge.hashCode() + ((this.extraLargeIncreased.hashCode() + ((this.largeIncreased.hashCode() + ((this.extraLarge.hashCode() + ((this.large.hashCode() + ((this.medium.hashCode() + ((this.small.hashCode() + (this.extraSmall.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Shapes(extraSmall=" + this.extraSmall + ", small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ", largeIncreased=" + this.largeIncreased + ", extraLarge=" + this.extraLarge + ", extralargeIncreased=" + this.extraLargeIncreased + ", extraExtraLarge=" + this.extraExtraLarge + ')';
    }
}
