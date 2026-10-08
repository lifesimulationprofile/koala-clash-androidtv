package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.size.Size;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Options {
    public final boolean allowInexactSize;
    public final boolean allowRgb565;
    public final ColorSpace colorSpace;
    public final Bitmap.Config config;
    public final Context context;
    public final String diskCacheKey;
    public final int diskCachePolicy;
    public final Headers headers;
    public final int memoryCachePolicy;
    public final int networkCachePolicy;
    public final Parameters parameters;
    public final boolean premultipliedAlpha;
    public final int scale;
    public final Size size;
    public final Tags tags;

    public Options(Context context, Bitmap.Config config, ColorSpace colorSpace, Size size, int i, boolean z, boolean z2, boolean z3, String str, Headers headers, Tags tags, Parameters parameters, int i2, int i3, int i4) {
        this.context = context;
        this.config = config;
        this.colorSpace = colorSpace;
        this.size = size;
        this.scale = i;
        this.allowInexactSize = z;
        this.allowRgb565 = z2;
        this.premultipliedAlpha = z3;
        this.diskCacheKey = str;
        this.headers = headers;
        this.tags = tags;
        this.parameters = parameters;
        this.memoryCachePolicy = i2;
        this.diskCachePolicy = i3;
        this.networkCachePolicy = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Options)) {
            return false;
        }
        Options options = (Options) obj;
        if (Intrinsics.areEqual(this.context, options.context) && this.config == options.config) {
            return (Build.VERSION.SDK_INT < 26 || Intrinsics.areEqual(this.colorSpace, options.colorSpace)) && Intrinsics.areEqual(this.size, options.size) && this.scale == options.scale && this.allowInexactSize == options.allowInexactSize && this.allowRgb565 == options.allowRgb565 && this.premultipliedAlpha == options.premultipliedAlpha && Intrinsics.areEqual(this.diskCacheKey, options.diskCacheKey) && Intrinsics.areEqual(this.headers, options.headers) && Intrinsics.areEqual(this.tags, options.tags) && Intrinsics.areEqual(this.parameters, options.parameters) && this.memoryCachePolicy == options.memoryCachePolicy && this.diskCachePolicy == options.diskCachePolicy && this.networkCachePolicy == options.networkCachePolicy;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.config.hashCode() + (this.context.hashCode() * 31)) * 31;
        ColorSpace colorSpace = this.colorSpace;
        int iM = (((((ImageAnalysis$$ExternalSyntheticLambda1.m(this.scale, (this.size.hashCode() + ((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31)) * 31, 31) + (this.allowInexactSize ? 1231 : 1237)) * 31) + (this.allowRgb565 ? 1231 : 1237)) * 31) + (this.premultipliedAlpha ? 1231 : 1237)) * 31;
        String str = this.diskCacheKey;
        return CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.networkCachePolicy) + ImageAnalysis$$ExternalSyntheticLambda1.m(this.diskCachePolicy, ImageAnalysis$$ExternalSyntheticLambda1.m(this.memoryCachePolicy, (this.parameters.entries.hashCode() + ((this.tags.tags.hashCode() + ((((iM + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.headers.namesAndValues)) * 31)) * 31)) * 31, 31), 31);
    }
}
