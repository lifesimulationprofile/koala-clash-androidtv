package coil.network;

import android.graphics.Bitmap;
import coil.util.Utils;
import java.io.EOFException;
import java.util.regex.Pattern;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Response;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CacheResponse {
    public final Object cacheControl$delegate;
    public final Object contentType$delegate;
    public final boolean isTls;
    public final long receivedResponseAtMillis;
    public final Headers responseHeaders;
    public final long sentRequestAtMillis;

    public CacheResponse(RealBufferedSource realBufferedSource) throws EOFException {
        final int i = 0;
        this.cacheControl$delegate = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: coil.network.CacheResponse$$ExternalSyntheticLambda0
            public final /* synthetic */ CacheResponse f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                CacheResponse cacheResponse = this.f$0;
                switch (i2) {
                    case 0:
                        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
                        return CacheControl.Companion.parse(cacheResponse.responseHeaders);
                    default:
                        String str = cacheResponse.responseHeaders.get("Content-Type");
                        if (str == null) {
                            return null;
                        }
                        Pattern pattern = MediaType.TYPE_SUBTYPE;
                        try {
                            return MediaType.Companion.get(str);
                        } catch (IllegalArgumentException unused) {
                            return null;
                        }
                }
            }
        });
        final char c = 1 == true ? 1 : 0;
        this.contentType$delegate = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: coil.network.CacheResponse$$ExternalSyntheticLambda0
            public final /* synthetic */ CacheResponse f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = c;
                CacheResponse cacheResponse = this.f$0;
                switch (i2) {
                    case 0:
                        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
                        return CacheControl.Companion.parse(cacheResponse.responseHeaders);
                    default:
                        String str = cacheResponse.responseHeaders.get("Content-Type");
                        if (str == null) {
                            return null;
                        }
                        Pattern pattern = MediaType.TYPE_SUBTYPE;
                        try {
                            return MediaType.Companion.get(str);
                        } catch (IllegalArgumentException unused) {
                            return null;
                        }
                }
            }
        });
        this.sentRequestAtMillis = Long.parseLong(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
        this.receivedResponseAtMillis = Long.parseLong(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
        this.isTls = Integer.parseInt(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE)) > 0;
        int i2 = Integer.parseInt(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
        Headers.Builder builder = new Headers.Builder(0);
        for (int i3 = 0; i3 < i2; i3++) {
            String utf8LineStrict = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
            int iIndexOf$default = StringsKt.indexOf$default(utf8LineStrict, ':', 0, 6);
            if (iIndexOf$default == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(utf8LineStrict).toString());
            }
            builder.addUnsafeNonAscii(StringsKt.trim(utf8LineStrict.substring(0, iIndexOf$default)).toString(), utf8LineStrict.substring(iIndexOf$default + 1));
        }
        this.responseHeaders = builder.build();
    }

    public final void writeTo(RealBufferedSink realBufferedSink) {
        realBufferedSink.writeDecimalLong(this.sentRequestAtMillis);
        realBufferedSink.writeByte(10);
        realBufferedSink.writeDecimalLong(this.receivedResponseAtMillis);
        realBufferedSink.writeByte(10);
        realBufferedSink.writeDecimalLong(this.isTls ? 1L : 0L);
        realBufferedSink.writeByte(10);
        Headers headers = this.responseHeaders;
        realBufferedSink.writeDecimalLong(headers.size());
        realBufferedSink.writeByte(10);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            realBufferedSink.writeUtf8(headers.name(i));
            realBufferedSink.writeUtf8(": ");
            realBufferedSink.writeUtf8(headers.value(i));
            realBufferedSink.writeByte(10);
        }
    }

    public CacheResponse(Response response) {
        final int i = 0;
        this.cacheControl$delegate = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: coil.network.CacheResponse$$ExternalSyntheticLambda0
            public final /* synthetic */ CacheResponse f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                CacheResponse cacheResponse = this.f$0;
                switch (i2) {
                    case 0:
                        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
                        return CacheControl.Companion.parse(cacheResponse.responseHeaders);
                    default:
                        String str = cacheResponse.responseHeaders.get("Content-Type");
                        if (str == null) {
                            return null;
                        }
                        Pattern pattern = MediaType.TYPE_SUBTYPE;
                        try {
                            return MediaType.Companion.get(str);
                        } catch (IllegalArgumentException unused) {
                            return null;
                        }
                }
            }
        });
        final int i2 = 1;
        this.contentType$delegate = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: coil.network.CacheResponse$$ExternalSyntheticLambda0
            public final /* synthetic */ CacheResponse f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i3 = i2;
                CacheResponse cacheResponse = this.f$0;
                switch (i3) {
                    case 0:
                        CacheControl cacheControl = CacheControl.FORCE_NETWORK;
                        return CacheControl.Companion.parse(cacheResponse.responseHeaders);
                    default:
                        String str = cacheResponse.responseHeaders.get("Content-Type");
                        if (str == null) {
                            return null;
                        }
                        Pattern pattern = MediaType.TYPE_SUBTYPE;
                        try {
                            return MediaType.Companion.get(str);
                        } catch (IllegalArgumentException unused) {
                            return null;
                        }
                }
            }
        });
        this.sentRequestAtMillis = response.sentRequestAtMillis;
        this.receivedResponseAtMillis = response.receivedResponseAtMillis;
        this.isTls = response.handshake != null;
        this.responseHeaders = response.headers;
    }
}
