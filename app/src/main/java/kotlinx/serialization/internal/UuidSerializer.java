package kotlinx.serialization.internal;

import kotlin.text.HexExtensionsKt;
import kotlin.uuid.Uuid;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UuidSerializer implements KSerializer {
    public static final UuidSerializer INSTANCE = new UuidSerializer();
    public static final PrimitiveSerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.uuid.Uuid", PrimitiveKind.INT.INSTANCE$8);

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        String strDecodeString = decoder.decodeString();
        int length = strDecodeString.length();
        if (length == 32) {
            long jHexToLong$default = HexExtensionsKt.hexToLong$default(0, 16, strDecodeString);
            long jHexToLong$default2 = HexExtensionsKt.hexToLong$default(16, 32, strDecodeString);
            if (jHexToLong$default != 0 || jHexToLong$default2 != 0) {
                return new Uuid(jHexToLong$default, jHexToLong$default2);
            }
        } else {
            if (length != 36) {
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                sb.append(strDecodeString.length() <= 64 ? strDecodeString : strDecodeString.substring(0, 64).concat("..."));
                sb.append("\" of length ");
                sb.append(strDecodeString.length());
                throw new IllegalArgumentException(sb.toString());
            }
            long jHexToLong$default3 = HexExtensionsKt.hexToLong$default(0, 8, strDecodeString);
            UuidKt.checkHyphenAt(strDecodeString, 8);
            long jHexToLong$default4 = HexExtensionsKt.hexToLong$default(9, 13, strDecodeString);
            UuidKt.checkHyphenAt(strDecodeString, 13);
            long jHexToLong$default5 = HexExtensionsKt.hexToLong$default(14, 18, strDecodeString);
            UuidKt.checkHyphenAt(strDecodeString, 18);
            long jHexToLong$default6 = HexExtensionsKt.hexToLong$default(19, 23, strDecodeString);
            UuidKt.checkHyphenAt(strDecodeString, 23);
            long j = (jHexToLong$default4 << 16) | (jHexToLong$default3 << 32) | jHexToLong$default5;
            long jHexToLong$default7 = HexExtensionsKt.hexToLong$default(24, 36, strDecodeString) | (jHexToLong$default6 << 48);
            if (j != 0 || jHexToLong$default7 != 0) {
                return new Uuid(j, jHexToLong$default7);
            }
        }
        return Uuid.NIL;
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        encoder.encodeString(((Uuid) obj).toString());
    }
}
