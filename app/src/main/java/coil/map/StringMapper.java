package coil.map;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import coil.request.Options;
import coil.util.Utils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StringMapper {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ StringMapper(int i) {
        this.$r8$classId = i;
    }

    public final Object map(Object obj, Options options) throws PackageManager.NameNotFoundException {
        String scheme;
        String authority;
        switch (this.$r8$classId) {
            case 0:
                return Uri.parse((String) obj);
            case 1:
                return ByteBuffer.wrap((byte[]) obj);
            case 2:
                Uri uri = (Uri) obj;
                if (!Utils.isAssetUri(uri) && ((scheme = uri.getScheme()) == null || scheme.equals("file"))) {
                    String path = uri.getPath();
                    if (path == null) {
                        path = "";
                    }
                    if (path.length() > 0 && CharsKt.equals(path.charAt(0), '/', false) && ((String) CollectionsKt.firstOrNull(uri.getPathSegments())) != null) {
                        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
                            return new File(uri.toString());
                        }
                        String path2 = uri.getPath();
                        if (path2 != null) {
                            return new File(path2);
                        }
                    }
                }
                return null;
            case 3:
                return ((HttpUrl) obj).url;
            case 4:
                int iIntValue = ((Number) obj).intValue();
                Context context = options.context;
                try {
                    if (context.getResources().getResourceEntryName(iIntValue) != null) {
                        return Uri.parse("android.resource://" + context.getPackageName() + '/' + iIntValue);
                    }
                } catch (Resources.NotFoundException unused) {
                }
                return null;
            default:
                Uri uri2 = (Uri) obj;
                if (!Intrinsics.areEqual(uri2.getScheme(), "android.resource") || (authority = uri2.getAuthority()) == null || StringsKt.isBlank(authority) || uri2.getPathSegments().size() != 2) {
                    return null;
                }
                String authority2 = uri2.getAuthority();
                if (authority2 == null) {
                    authority2 = "";
                }
                Resources resourcesForApplication = options.context.getPackageManager().getResourcesForApplication(authority2);
                List<String> pathSegments = uri2.getPathSegments();
                int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority2);
                if (identifier == 0) {
                    throw new IllegalStateException(("Invalid android.resource URI: " + uri2).toString());
                }
                return Uri.parse("android.resource://" + authority2 + '/' + identifier);
        }
    }
}
