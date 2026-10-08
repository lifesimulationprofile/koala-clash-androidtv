package coil.util;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.network.HttpException;
import coil.size.Dimension;
import java.io.Closeable;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;

/* JADX INFO: renamed from: coil.util.-Utils, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Utils {
    public static final Bitmap.Config DEFAULT_BITMAP_CONFIG;
    public static final Headers EMPTY_HEADERS;
    public static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS;

    static {
        int i = Build.VERSION.SDK_INT;
        VALID_TRANSFORMATION_CONFIGS = i >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        DEFAULT_BITMAP_CONFIG = i >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
        EMPTY_HEADERS = new Headers((String[]) new ArrayList(20).toArray(new String[0]));
    }

    public static final void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final String getMimeTypeFromUrl(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        int iLastIndexOf$default = StringsKt.lastIndexOf$default(str, '#', 0, 6);
        if (iLastIndexOf$default != -1) {
            str = str.substring(0, iLastIndexOf$default);
        }
        int iLastIndexOf$default2 = StringsKt.lastIndexOf$default(str, '?', 0, 6);
        if (iLastIndexOf$default2 != -1) {
            str = str.substring(0, iLastIndexOf$default2);
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast(str, '/', str), '.', ""));
    }

    public static final boolean isAssetUri(Uri uri) {
        return Intrinsics.areEqual(uri.getScheme(), "file") && Intrinsics.areEqual((String) CollectionsKt.firstOrNull(uri.getPathSegments()), "android_asset");
    }

    public static final int toPx(Dimension dimension, int i) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            return Integer.MIN_VALUE;
        }
        if (iOrdinal == 1) {
            return Integer.MAX_VALUE;
        }
        throw new HttpException();
    }
}
