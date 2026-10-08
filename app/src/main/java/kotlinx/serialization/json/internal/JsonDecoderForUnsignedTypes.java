package kotlinx.serialization.json.internal;

import androidx.room.DatabaseConfiguration;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {
    public final DatabaseConfiguration lexer;
    public final Request serializersModule;

    public JsonDecoderForUnsignedTypes(DatabaseConfiguration databaseConfiguration, Json json) {
        this.lexer = databaseConfiguration;
        this.serializersModule = json.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        UByte uByte;
        DatabaseConfiguration databaseConfiguration = this.lexer;
        String strConsumeStringLenient = databaseConfiguration.consumeStringLenient();
        try {
            UInt uIntOrNull = UStringsKt.toUIntOrNull(strConsumeStringLenient);
            if (uIntOrNull != null) {
                int i = uIntOrNull.data;
                uByte = Integer.compare(Integer.MIN_VALUE ^ i, -2147483393) > 0 ? null : new UByte((byte) i);
            }
            if (uByte != null) {
                return uByte.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse type 'UByte' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeElementIndex(SerialDescriptor serialDescriptor) {
        throw new IllegalStateException("unsupported");
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        String strConsumeStringLenient = databaseConfiguration.consumeStringLenient();
        try {
            UInt uIntOrNull = UStringsKt.toUIntOrNull(strConsumeStringLenient);
            if (uIntOrNull != null) {
                return uIntOrNull.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse type 'UInt' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        String strConsumeStringLenient = databaseConfiguration.consumeStringLenient();
        try {
            ULong uLongOrNull = UStringsKt.toULongOrNull(strConsumeStringLenient);
            if (uLongOrNull != null) {
                return uLongOrNull.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse type 'ULong' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        UShort uShort;
        DatabaseConfiguration databaseConfiguration = this.lexer;
        String strConsumeStringLenient = databaseConfiguration.consumeStringLenient();
        try {
            UInt uIntOrNull = UStringsKt.toUIntOrNull(strConsumeStringLenient);
            if (uIntOrNull != null) {
                int i = uIntOrNull.data;
                uShort = Integer.compare(Integer.MIN_VALUE ^ i, -2147418113) > 0 ? null : new UShort((short) i);
            }
            if (uShort != null) {
                return uShort.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse type 'UShort' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder, kotlinx.serialization.encoding.Encoder
    public final Request getSerializersModule() {
        return this.serializersModule;
    }
}
