package androidx.compose.ui.spatial;

import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.ui.unit.IntOffset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RelativeLayoutBounds {
    public final long bottomRight;
    public final AwaitFirstLayoutModifier.Node node;
    public final long screenOffset;
    public final long topLeft;
    public final float[] viewToWindowMatrix;
    public final long windowOffset;
    public final long windowSize;

    public RelativeLayoutBounds(long j, long j2, long j3, long j4, long j5, float[] fArr, AwaitFirstLayoutModifier.Node node) {
        this.topLeft = j;
        this.bottomRight = j2;
        this.windowOffset = j3;
        this.screenOffset = j4;
        this.windowSize = j5;
        this.viewToWindowMatrix = fArr;
        this.node = node;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004e  */
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this != obj) {
            if (obj != null && RelativeLayoutBounds.class == obj.getClass()) {
                RelativeLayoutBounds relativeLayoutBounds = (RelativeLayoutBounds) obj;
                if (this.topLeft == relativeLayoutBounds.topLeft && this.bottomRight == relativeLayoutBounds.bottomRight && this.windowSize == relativeLayoutBounds.windowSize && IntOffset.m712equalsimpl0(this.windowOffset, relativeLayoutBounds.windowOffset) && IntOffset.m712equalsimpl0(this.screenOffset, relativeLayoutBounds.screenOffset)) {
                    float[] fArr = relativeLayoutBounds.viewToWindowMatrix;
                    float[] fArr2 = this.viewToWindowMatrix;
                    if (fArr2 == null) {
                        if (fArr == null) {
                            zEquals = true;
                        } else {
                            zEquals = false;
                        }
                    } else if (fArr == null) {
                        zEquals = false;
                    } else {
                        zEquals = fArr2.equals(fArr);
                    }
                    if (zEquals && this.node.equals(relativeLayoutBounds.node)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.topLeft;
        long j2 = this.bottomRight;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.windowSize;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.windowOffset;
        int i3 = (((int) (j4 ^ (j4 >>> 32))) + i2) * 31;
        long j5 = this.screenOffset;
        int i4 = (((int) (j5 ^ (j5 >>> 32))) + i3) * 31;
        float[] fArr = this.viewToWindowMatrix;
        return this.node.hashCode() + ((i4 + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31);
    }
}
