package androidx.compose.ui.geometry;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableRect {
    public final /* synthetic */ int $r8$classId;
    public float bottom;
    public float left;
    public float right;
    public float top;

    public MutableRect(float f, float f2) {
        this.$r8$classId = 1;
        this.top = f;
        this.right = f2;
    }

    public float getLinearZoom() {
        return this.bottom;
    }

    public float getMaxZoomRatio() {
        return this.top;
    }

    public float getMinZoomRatio() {
        return this.right;
    }

    public float getZoomRatio() {
        return this.left;
    }

    public void intersect(float f, float f2, float f3, float f4) {
        this.left = Math.max(f, this.left);
        this.top = Math.max(f2, this.top);
        this.right = Math.min(f3, this.right);
        this.bottom = Math.min(f4, this.bottom);
    }

    public boolean isEmpty() {
        return (this.left >= this.right) | (this.top >= this.bottom);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    public void setZoomRatio() {
        float f = this.right;
        float f2 = this.top;
        float f3 = 1.0f;
        if (1.0f > f2 || 1.0f < f) {
            throw new IllegalArgumentException("Requested zoomRatio 1.0 is not within valid range [" + f + " , " + f2 + "]");
        }
        this.left = 1.0f;
        if (f2 == f) {
            f3 = 0.0f;
        } else if (1.0f != f2) {
            if (1.0f == f) {
                f3 = 0.0f;
            } else {
                float f4 = 1.0f / f;
                f3 = (1.0f - f4) / ((1.0f / f2) - f4);
            }
        }
        this.bottom = f3;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "MutableRect(" + GeometryUtilsKt.toStringAsFixed(this.left) + ", " + GeometryUtilsKt.toStringAsFixed(this.top) + ", " + GeometryUtilsKt.toStringAsFixed(this.right) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom) + ')';
            default:
                return super.toString();
        }
    }

    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public void m367translatek4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        this.left += fIntBitsToFloat;
        this.top += fIntBitsToFloat2;
        this.right += fIntBitsToFloat;
        this.bottom += fIntBitsToFloat2;
    }

    public MutableRect() {
        this.$r8$classId = 0;
        this.left = 0.0f;
        this.top = 0.0f;
        this.right = 0.0f;
        this.bottom = 0.0f;
    }
}
