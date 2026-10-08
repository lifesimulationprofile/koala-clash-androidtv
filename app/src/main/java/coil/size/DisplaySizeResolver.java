package coil.size;

import android.content.Context;
import android.util.DisplayMetrics;
import coil.RealImageLoader$executeMain$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DisplaySizeResolver implements SizeResolver {
    public final Context context;

    public DisplaySizeResolver(Context context) {
        this.context = context;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DisplaySizeResolver) {
            return Intrinsics.areEqual(this.context, ((DisplaySizeResolver) obj).context);
        }
        return false;
    }

    public final int hashCode() {
        return this.context.hashCode();
    }

    @Override // coil.size.SizeResolver
    public final Object size(RealImageLoader$executeMain$1 realImageLoader$executeMain$1) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        Dimension.Pixels pixels = new Dimension.Pixels(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new Size(pixels, pixels);
    }
}
