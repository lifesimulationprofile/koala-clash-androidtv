package androidx.compose.ui.graphics.shadow;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidShadowContext$ShadowKey {
    public float density;
    public LayoutDirection layoutDirection;
    public Shadow shadow;
    public Shape shape;
    public long size;

    public AndroidShadowContext$ShadowKey(Shape shape, long j, LayoutDirection layoutDirection, float f, Shadow shadow) {
        this.shape = shape;
        this.size = j;
        this.layoutDirection = layoutDirection;
        this.density = f;
        this.shadow = shadow;
    }

    /* JADX INFO: renamed from: copy-eZhPAX0$default, reason: not valid java name */
    public static AndroidShadowContext$ShadowKey m496copyeZhPAX0$default(AndroidShadowContext$ShadowKey androidShadowContext$ShadowKey) {
        return new AndroidShadowContext$ShadowKey(androidShadowContext$ShadowKey.shape, androidShadowContext$ShadowKey.size, androidShadowContext$ShadowKey.layoutDirection, androidShadowContext$ShadowKey.density, androidShadowContext$ShadowKey.shadow);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidShadowContext$ShadowKey)) {
            return false;
        }
        AndroidShadowContext$ShadowKey androidShadowContext$ShadowKey = (AndroidShadowContext$ShadowKey) obj;
        return Intrinsics.areEqual(this.shape, androidShadowContext$ShadowKey.shape) && Size.m384equalsimpl0(this.size, androidShadowContext$ShadowKey.size) && this.layoutDirection == androidShadowContext$ShadowKey.layoutDirection && Float.compare(this.density, androidShadowContext$ShadowKey.density) == 0 && Intrinsics.areEqual(this.shadow, androidShadowContext$ShadowKey.shadow);
    }

    public final int hashCode() {
        int iHashCode = this.shape.hashCode() * 31;
        long j = this.size;
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.density, (this.layoutDirection.hashCode() + ((((int) (j ^ (j >>> 32))) + iHashCode) * 31)) * 31, 31);
        Shadow shadow = this.shadow;
        return iM + (shadow == null ? 0 : shadow.hashCode());
    }

    public final String toString() {
        return "ShadowKey(shape=" + this.shape + ", size=" + ((Object) Size.m390toStringimpl(this.size)) + ", layoutDirection=" + this.layoutDirection + ", density=" + this.density + ", shadow=" + this.shadow + ')';
    }
}
