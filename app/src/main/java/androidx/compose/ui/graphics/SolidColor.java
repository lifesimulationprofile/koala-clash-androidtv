package androidx.compose.ui.graphics;

import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SolidColor extends Brush implements Interpolatable {
    public final long value;

    public SolidColor(long j) {
        this.value = j;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo411applyToPq9zytI(float f, long j, AndroidPaint androidPaint) {
        androidPaint.setAlpha(1.0f);
        long jColor = this.value;
        if (f != 1.0f) {
            jColor = BrushKt.Color(Color.m440getRedimpl(jColor), Color.m439getGreenimpl(jColor), Color.m437getBlueimpl(jColor), Color.m436getAlphaimpl(jColor) * f, Color.m438getColorSpaceimpl(jColor));
        }
        androidPaint.m404setColor8_81llA(jColor);
        if (androidPaint.internalShader != null) {
            androidPaint.setShader(null);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SolidColor) {
            return Color.m435equalsimpl0(this.value, ((SolidColor) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m831hashCodeimpl(this.value);
    }

    @Override // androidx.compose.ui.graphics.Interpolatable
    public final Object lerp(Object obj, float f) {
        if (obj == null) {
            obj = new SolidColor(Color.Transparent);
        }
        if (!(obj instanceof SolidColor)) {
            return null;
        }
        return new SolidColor(BrushKt.m419lerpjxsXWHM(this.value, ((SolidColor) obj).value, f));
    }

    public final String toString() {
        return "SolidColor(value=" + ((Object) Color.m441toStringimpl(this.value)) + ')';
    }
}
