package coil.fetch;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.decode.FileImageSource;
import coil.request.Options;
import coil.util.Utils;
import java.io.File;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FileFetcher implements Fetcher {
    public final File data;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Factory implements Fetcher.Factory {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ Factory(int i) {
            this.$r8$classId = i;
        }

        @Override // coil.fetch.Fetcher.Factory
        public final Fetcher create(Object obj, Options options) {
            switch (this.$r8$classId) {
                case 0:
                    return new FileFetcher((File) obj);
                case 1:
                    Uri uri = (Uri) obj;
                    if (Utils.isAssetUri(uri)) {
                        return new AssetUriFetcher(uri, options, 0);
                    }
                    return null;
                case 2:
                    return new BitmapFetcher((Bitmap) obj, options, 0);
                case 3:
                    return new BitmapFetcher((ByteBuffer) obj, options, 1);
                case 4:
                    Uri uri2 = (Uri) obj;
                    if (Intrinsics.areEqual(uri2.getScheme(), "content")) {
                        return new AssetUriFetcher(uri2, options, 1);
                    }
                    return null;
                case 5:
                    return new BitmapFetcher((Drawable) obj, options, 2);
                default:
                    Uri uri3 = (Uri) obj;
                    if (Intrinsics.areEqual(uri3.getScheme(), "android.resource")) {
                        return new AssetUriFetcher(uri3, options, 2);
                    }
                    return null;
            }
        }
    }

    public FileFetcher(File file) {
        this.data = file;
    }

    @Override // coil.fetch.Fetcher
    public final Object fetch(Continuation continuation) {
        String str = Path.DIRECTORY_SEPARATOR;
        File file = this.data;
        return new SourceResult(new FileImageSource(Path.Companion.get$default(file), FileSystem.SYSTEM, null, null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast(file.getName(), '.', "")), 3);
    }
}
