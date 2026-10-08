package okhttp3.internal.http2;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Header {
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    public static final ByteString PSEUDO_PREFIX = ByteString.Companion.encodeUtf8(":");
    public static final ByteString RESPONSE_STATUS = ByteString.Companion.encodeUtf8(":status");
    public static final ByteString TARGET_METHOD = ByteString.Companion.encodeUtf8(":method");
    public static final ByteString TARGET_PATH = ByteString.Companion.encodeUtf8(":path");
    public static final ByteString TARGET_SCHEME = ByteString.Companion.encodeUtf8(":scheme");
    public static final ByteString TARGET_AUTHORITY = ByteString.Companion.encodeUtf8(":authority");

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString2.getSize$okio() + byteString.getSize$okio() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.areEqual(this.name, header.name) && Intrinsics.areEqual(this.value, header.value);
    }

    public final int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    public Header(String str, String str2) {
        ByteString byteString = new ByteString(str.getBytes(Charsets.UTF_8));
        byteString.utf8 = str;
        ByteString byteString2 = new ByteString(str2.getBytes(Charsets.UTF_8));
        byteString2.utf8 = str2;
        this(byteString, byteString2);
    }

    public Header(ByteString byteString, String str) {
        ByteString byteString2 = new ByteString(str.getBytes(Charsets.UTF_8));
        byteString2.utf8 = str;
        this(byteString, byteString2);
    }
}
