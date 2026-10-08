package kotlinx.serialization.json.internal;

import androidx.compose.foundation.FocusableNode$focusTargetNode$1;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomOpenHelper;
import coil.memory.RealWeakMemoryCache;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.ElementMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    public final JsonConfiguration configuration;
    public int currentIndex = -1;
    public Symbol discriminatorHolder;
    public final JsonElementMarker elementMarker;
    public final Json json;
    public final DatabaseConfiguration lexer;
    public final WriteMode mode;
    public final Request serializersModule;

    public StreamingJsonDecoder(Json json, WriteMode writeMode, DatabaseConfiguration databaseConfiguration, SerialDescriptor serialDescriptor, Symbol symbol) {
        this.json = json;
        this.mode = writeMode;
        this.lexer = databaseConfiguration;
        this.serializersModule = json.serializersModule;
        this.discriminatorHolder = symbol;
        JsonConfiguration jsonConfiguration = json.configuration;
        this.configuration = jsonConfiguration;
        this.elementMarker = jsonConfiguration.explicitNulls ? null : new JsonElementMarker(serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        Json json = this.json;
        WriteMode writeModeSwitchMode = WriteModeKt.switchMode(serialDescriptor, json);
        DatabaseConfiguration databaseConfiguration = this.lexer;
        RoomOpenHelper roomOpenHelper = (RoomOpenHelper) databaseConfiguration.context;
        int i = roomOpenHelper.version + 1;
        roomOpenHelper.version = i;
        Object[] objArr = (Object[]) roomOpenHelper.mConfiguration;
        if (i == objArr.length) {
            int i2 = i * 2;
            roomOpenHelper.mConfiguration = Arrays.copyOf(objArr, i2);
            roomOpenHelper.mDelegate = Arrays.copyOf((int[]) roomOpenHelper.mDelegate, i2);
        }
        ((Object[]) roomOpenHelper.mConfiguration)[i] = serialDescriptor;
        databaseConfiguration.consumeNextToken(writeModeSwitchMode.begin);
        if (databaseConfiguration.peekNextToken() == 4) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        int iOrdinal = writeModeSwitchMode.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
            return new StreamingJsonDecoder(json, writeModeSwitchMode, databaseConfiguration, serialDescriptor, this.discriminatorHolder);
        }
        return (this.mode == writeModeSwitchMode && json.configuration.explicitNulls) ? this : new StreamingJsonDecoder(json, writeModeSwitchMode, databaseConfiguration, serialDescriptor, this.discriminatorHolder);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        boolean z;
        boolean z2;
        DatabaseConfiguration databaseConfiguration = this.lexer;
        int iSkipWhitespaces = databaseConfiguration.skipWhitespaces();
        String str = (String) databaseConfiguration.autoMigrationSpecs;
        if (iSkipWhitespaces == str.length()) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iSkipWhitespaces) == '\"') {
            iSkipWhitespaces++;
            z = true;
        } else {
            z = false;
        }
        int iPrefetchOrEof = databaseConfiguration.prefetchOrEof(iSkipWhitespaces);
        if (iPrefetchOrEof >= str.length() || iPrefetchOrEof == -1) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "EOF", 0, null, 6);
            throw null;
        }
        int i = iPrefetchOrEof + 1;
        int iCharAt = str.charAt(iPrefetchOrEof) | ' ';
        if (iCharAt == 102) {
            databaseConfiguration.consumeBooleanLiteral("alse", i);
            z2 = false;
        } else {
            if (iCharAt != 116) {
                DatabaseConfiguration.fail$default(databaseConfiguration, "Expected valid boolean literal prefix, but had '" + databaseConfiguration.consumeStringLenient() + '\'', 0, null, 6);
                throw null;
            }
            databaseConfiguration.consumeBooleanLiteral("rue", i);
            z2 = true;
        }
        if (!z) {
            return z2;
        }
        if (databaseConfiguration.journalMode == str.length()) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(databaseConfiguration.journalMode) == '\"') {
            databaseConfiguration.journalMode++;
            return z2;
        }
        DatabaseConfiguration.fail$default(databaseConfiguration, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        long jConsumeNumericLiteral = databaseConfiguration.consumeNumericLiteral();
        byte b = (byte) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == b) {
            return b;
        }
        DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse byte for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        String strConsumeStringLenient = databaseConfiguration.consumeStringLenient();
        if (strConsumeStringLenient.length() == 1) {
            return strConsumeStringLenient.charAt(0);
        }
        DatabaseConfiguration.fail$default(databaseConfiguration, "Expected single char, but got '" + strConsumeStringLenient + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        String strConsumeStringLenient = databaseConfiguration.consumeStringLenient();
        try {
            double d = Double.parseDouble(strConsumeStringLenient);
            if (!Double.isInfinite(d) && !Double.isNaN(d)) {
                return d;
            }
            DatabaseConfiguration.fail$default(databaseConfiguration, "Unexpected special floating-point value " + Double.valueOf(d) + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
            throw null;
        } catch (IllegalArgumentException unused) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse type 'double' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x020e A[EDGE_INSN: B:120:0x020e->B:121:0x020f BREAK  A[LOOP:0: B:48:0x0091->B:99:0x0199]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeElementIndex(SerialDescriptor serialDescriptor) {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        RoomOpenHelper roomOpenHelper = (RoomOpenHelper) databaseConfiguration.context;
        String str = (String) databaseConfiguration.autoMigrationSpecs;
        WriteMode writeMode = this.mode;
        int iOrdinal = writeMode.ordinal();
        char c = ':';
        int i = 0;
        zTryConsumeComma = false;
        boolean zTryConsumeComma = false;
        int i2 = -1;
        if (iOrdinal == 0) {
            boolean zTryConsumeComma2 = databaseConfiguration.tryConsumeComma();
            while (true) {
                boolean zCanConsumeValue = databaseConfiguration.canConsumeValue();
                JsonElementMarker jsonElementMarker = this.elementMarker;
                if (zCanConsumeValue) {
                    String strConsumeKeyString = databaseConfiguration.consumeKeyString();
                    databaseConfiguration.consumeNextToken(c);
                    int jsonNameIndex = WriteModeKt.getJsonNameIndex(serialDescriptor, this.json, strConsumeKeyString);
                    if (jsonNameIndex != -3) {
                        if (jsonElementMarker != null) {
                            ElementMarker elementMarker = jsonElementMarker.origin;
                            if (jsonNameIndex < 64) {
                                elementMarker.lowerMarks |= 1 << jsonNameIndex;
                            } else {
                                int i3 = (jsonNameIndex >>> 6) - 1;
                                long[] jArr = elementMarker.highMarksArray;
                                jArr[i3] = jArr[i3] | (1 << (jsonNameIndex & 63));
                            }
                        }
                        i2 = jsonNameIndex;
                        break;
                    }
                    if (!this.configuration.ignoreUnknownKeys) {
                        Symbol symbol = this.discriminatorHolder;
                        if (symbol == null || !Intrinsics.areEqual(symbol.symbol, strConsumeKeyString)) {
                            databaseConfiguration.fail(StringsKt.lastIndexOf$default(6, str.subSequence(0, databaseConfiguration.journalMode).toString(), strConsumeKeyString), "Encountered an unknown key '" + strConsumeKeyString + '\'', "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
                            throw null;
                        }
                        symbol.symbol = null;
                    }
                    ArrayList arrayList = new ArrayList();
                    byte bPeekNextToken = databaseConfiguration.peekNextToken();
                    if (bPeekNextToken == 8 || bPeekNextToken == 6) {
                        while (true) {
                            byte bPeekNextToken2 = databaseConfiguration.peekNextToken();
                            if (bPeekNextToken2 == 1) {
                                databaseConfiguration.consumeKeyString();
                            } else {
                                if (bPeekNextToken2 == 8 || bPeekNextToken2 == 6) {
                                    arrayList.add(Byte.valueOf(bPeekNextToken2));
                                } else if (bPeekNextToken2 == 9) {
                                    if (((Number) CollectionsKt.last(arrayList)).byteValue() != 8) {
                                        throw WriteModeKt.JsonDecodingException(databaseConfiguration.journalMode, str, "found ] instead of } at path: " + roomOpenHelper);
                                    }
                                    CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                                } else if (bPeekNextToken2 == 7) {
                                    if (((Number) CollectionsKt.last(arrayList)).byteValue() != 6) {
                                        throw WriteModeKt.JsonDecodingException(databaseConfiguration.journalMode, str, "found } instead of ] at path: " + roomOpenHelper);
                                    }
                                    CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                                } else if (bPeekNextToken2 == 10) {
                                    DatabaseConfiguration.fail$default(databaseConfiguration, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6);
                                    throw null;
                                }
                                databaseConfiguration.consumeNextToken();
                                if (arrayList.size() == 0) {
                                    break;
                                }
                            }
                        }
                    } else {
                        databaseConfiguration.consumeStringLenient();
                    }
                    zTryConsumeComma2 = databaseConfiguration.tryConsumeComma();
                    c = ':';
                } else if (!zTryConsumeComma2) {
                    if (jsonElementMarker == null) {
                        i2 = -1;
                        break;
                    }
                    ElementMarker elementMarker2 = jsonElementMarker.origin;
                    FocusableNode$focusTargetNode$1 focusableNode$focusTargetNode$1 = elementMarker2.readIfAbsent;
                    SerialDescriptor serialDescriptor2 = elementMarker2.descriptor;
                    int elementsCount = serialDescriptor2.getElementsCount();
                    while (true) {
                        long j = elementMarker2.lowerMarks;
                        long j2 = -1;
                        if (j == -1) {
                            if (elementsCount <= 64) {
                                i2 = -1;
                                break;
                            }
                            long[] jArr2 = elementMarker2.highMarksArray;
                            int length = jArr2.length;
                            loop3: while (true) {
                                if (i >= length) {
                                    i2 = -1;
                                    break;
                                }
                                int i4 = i + 1;
                                int i5 = i4 * 64;
                                long j3 = jArr2[i];
                                while (true) {
                                    if (j3 != j2) {
                                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j3);
                                        j3 |= 1 << iNumberOfTrailingZeros;
                                        i2 = iNumberOfTrailingZeros + i5;
                                        if (((Boolean) focusableNode$focusTargetNode$1.invoke(serialDescriptor2, Integer.valueOf(i2))).booleanValue()) {
                                            jArr2[i] = j3;
                                            break;
                                        }
                                        j2 = -1;
                                    } else {
                                        jArr2[i] = j3;
                                        i = i4;
                                        j2 = -1;
                                    }
                                }
                            }
                        } else {
                            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j);
                            elementMarker2.lowerMarks |= 1 << iNumberOfTrailingZeros2;
                            if (((Boolean) focusableNode$focusTargetNode$1.invoke(serialDescriptor2, Integer.valueOf(iNumberOfTrailingZeros2))).booleanValue()) {
                                i2 = iNumberOfTrailingZeros2;
                                break;
                            }
                        }
                    }
                } else {
                    WriteModeKt.invalidTrailingComma$default(databaseConfiguration);
                    throw null;
                }
            }
        } else if (iOrdinal != 2) {
            boolean zTryConsumeComma3 = databaseConfiguration.tryConsumeComma();
            if (databaseConfiguration.canConsumeValue()) {
                int i6 = this.currentIndex;
                if (i6 != -1 && !zTryConsumeComma3) {
                    DatabaseConfiguration.fail$default(databaseConfiguration, "Expected end of the array or comma", 0, null, 6);
                    throw null;
                }
                i2 = i6 + 1;
                this.currentIndex = i2;
            } else if (zTryConsumeComma3) {
                WriteModeKt.invalidTrailingComma(databaseConfiguration, "array");
                throw null;
            }
        } else {
            int i7 = this.currentIndex;
            Object[] objArr = i7 % 2 != 0;
            if (objArr != true) {
                databaseConfiguration.consumeNextToken(':');
            } else if (i7 != -1) {
                zTryConsumeComma = databaseConfiguration.tryConsumeComma();
            }
            if (databaseConfiguration.canConsumeValue()) {
                if (objArr != false) {
                    if (this.currentIndex == -1) {
                        int i8 = databaseConfiguration.journalMode;
                        if (zTryConsumeComma) {
                            DatabaseConfiguration.fail$default(databaseConfiguration, "Unexpected leading comma", i8, null, 4);
                            throw null;
                        }
                    } else {
                        int i9 = databaseConfiguration.journalMode;
                        if (!zTryConsumeComma) {
                            DatabaseConfiguration.fail$default(databaseConfiguration, "Expected comma after the key-value pair", i9, null, 4);
                            throw null;
                        }
                    }
                }
                i2 = this.currentIndex + 1;
                this.currentIndex = i2;
            } else if (zTryConsumeComma) {
                WriteModeKt.invalidTrailingComma$default(databaseConfiguration);
                throw null;
            }
        }
        if (writeMode != WriteMode.MAP) {
            ((int[]) roomOpenHelper.mDelegate)[roomOpenHelper.version] = i2;
        }
        return i2;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor serialDescriptor) {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        return WriteModeKt.getJsonNameIndexOrThrow(serialDescriptor, this.json, databaseConfiguration.consumeString(), " at path ".concat(((RoomOpenHelper) databaseConfiguration.context).getPath()));
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        String strConsumeStringLenient = databaseConfiguration.consumeStringLenient();
        try {
            float f = Float.parseFloat(strConsumeStringLenient);
            if (!Float.isInfinite(f) && !Float.isNaN(f)) {
                return f;
            }
            DatabaseConfiguration.fail$default(databaseConfiguration, "Unexpected special floating-point value " + Float.valueOf(f) + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
            throw null;
        } catch (IllegalArgumentException unused) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse type 'float' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final Decoder decodeInline(SerialDescriptor serialDescriptor) {
        return StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor) ? new JsonDecoderForUnsignedTypes(this.lexer, this.json) : this;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        long jConsumeNumericLiteral = databaseConfiguration.consumeNumericLiteral();
        int i = (int) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == i) {
            return i;
        }
        DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse int for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement decodeJsonElement() {
        return new RealWeakMemoryCache(this.json.configuration, this.lexer).read();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeNotNullMark() {
        JsonElementMarker jsonElementMarker = this.elementMarker;
        if (!(jsonElementMarker != null ? jsonElementMarker.isUnmarkedNull : false)) {
            DatabaseConfiguration databaseConfiguration = this.lexer;
            int iPrefetchOrEof = databaseConfiguration.prefetchOrEof(databaseConfiguration.skipWhitespaces());
            String str = (String) databaseConfiguration.autoMigrationSpecs;
            int length = str.length() - iPrefetchOrEof;
            boolean z = false;
            if (length >= 4 && iPrefetchOrEof != -1) {
                for (int i = 0; i < 4; i++) {
                    if ("null".charAt(i) == str.charAt(iPrefetchOrEof + i)) {
                    }
                }
                if (length <= 4 || WriteModeKt.charToTokenClass(str.charAt(iPrefetchOrEof + 4)) != 0) {
                    z = true;
                    databaseConfiguration.journalMode = iPrefetchOrEof + 4;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        RoomOpenHelper roomOpenHelper = (RoomOpenHelper) this.lexer.context;
        boolean z = this.mode == WriteMode.MAP && (i & 1) == 0;
        if (z) {
            int[] iArr = (int[]) roomOpenHelper.mDelegate;
            int i2 = roomOpenHelper.version;
            if (iArr[i2] == -2) {
                ((Object[]) roomOpenHelper.mConfiguration)[i2] = JsonPath$Tombstone.INSTANCE;
            }
        }
        Object objDecodeSerializableValue = decodeSerializableValue(kSerializer);
        if (z) {
            int[] iArr2 = (int[]) roomOpenHelper.mDelegate;
            int i3 = roomOpenHelper.version;
            if (iArr2[i3] != -2) {
                int i4 = i3 + 1;
                roomOpenHelper.version = i4;
                Object[] objArr = (Object[]) roomOpenHelper.mConfiguration;
                if (i4 == objArr.length) {
                    int i5 = i4 * 2;
                    roomOpenHelper.mConfiguration = Arrays.copyOf(objArr, i5);
                    roomOpenHelper.mDelegate = Arrays.copyOf((int[]) roomOpenHelper.mDelegate, i5);
                }
            }
            Object[] objArr2 = (Object[]) roomOpenHelper.mConfiguration;
            int i6 = roomOpenHelper.version;
            objArr2[i6] = objDecodeSerializableValue;
            ((int[]) roomOpenHelper.mDelegate)[i6] = -2;
        }
        return objDecodeSerializableValue;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0126  */
    /* JADX WARN: Code duplicated, block: B:44:0x0127  */
    /* JADX WARN: Instruction removed from duplicated block: B:44:0x0127, please report this as an issue */
    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final Object decodeSerializableValue(KSerializer kSerializer) {
        Json json = this.json;
        DatabaseConfiguration databaseConfiguration = this.lexer;
        RoomOpenHelper roomOpenHelper = (RoomOpenHelper) databaseConfiguration.context;
        try {
            if (!(kSerializer instanceof PolymorphicSerializer)) {
                return kSerializer.deserialize(this);
            }
            String strClassDiscriminator = WriteModeKt.classDiscriminator(((PolymorphicSerializer) kSerializer).getDescriptor(), json);
            String strPeekLeadingMatchingValue = databaseConfiguration.peekLeadingMatchingValue(strClassDiscriminator);
            String content = null;
            if (strPeekLeadingMatchingValue != null) {
                try {
                    KSerializer kSerializerFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((PolymorphicSerializer) kSerializer, this, strPeekLeadingMatchingValue);
                    Symbol symbol = new Symbol();
                    symbol.symbol = strClassDiscriminator;
                    this.discriminatorHolder = symbol;
                    return kSerializerFindPolymorphicSerializer.deserialize(this);
                } catch (SerializationException e) {
                    String strSubstringBefore$default = StringsKt.substringBefore$default(e.getMessage(), '\n');
                    if (StringsKt.endsWith$default(strSubstringBefore$default, ".")) {
                        strSubstringBefore$default = strSubstringBefore$default.substring(0, strSubstringBefore$default.length() - ".".length());
                    }
                    String message = e.getMessage();
                    String strSubstring = "";
                    int iIndexOf$default = StringsKt.indexOf$default(message, '\n', 0, 6);
                    if (iIndexOf$default != -1) {
                        strSubstring = message.substring(iIndexOf$default + 1, message.length());
                    }
                    DatabaseConfiguration.fail$default(databaseConfiguration, strSubstringBefore$default, 0, strSubstring, 2);
                    throw null;
                }
            }
            String strClassDiscriminator2 = WriteModeKt.classDiscriminator(((PolymorphicSerializer) kSerializer).getDescriptor(), json);
            JsonElement jsonElementDecodeJsonElement = decodeJsonElement();
            String serialName = ((PolymorphicSerializer) kSerializer).getDescriptor().getSerialName();
            if (!(jsonElementDecodeJsonElement instanceof JsonObject)) {
                throw WriteModeKt.JsonDecodingException(-1, jsonElementDecodeJsonElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + roomOpenHelper.getPath());
            }
            JsonObject jsonObject = (JsonObject) jsonElementDecodeJsonElement;
            JsonElement jsonElement = (JsonElement) jsonObject.get(strClassDiscriminator2);
            if (jsonElement != null) {
                JsonPrimitive jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement);
                if (!(jsonPrimitive instanceof JsonNull)) {
                    content = jsonPrimitive.getContent();
                }
            }
            try {
                KSerializer kSerializerFindPolymorphicSerializer2 = PolymorphicSerializerKt.findPolymorphicSerializer((PolymorphicSerializer) kSerializer, this, content);
                return new JsonTreeDecoder(json, jsonObject, strClassDiscriminator2, kSerializerFindPolymorphicSerializer2.getDescriptor()).decodeSerializableValue(kSerializerFindPolymorphicSerializer2);
            } catch (SerializationException e2) {
                throw WriteModeKt.JsonDecodingException(-1, jsonObject.toString(), e2.getMessage());
            }
            if (StringsKt.contains(e.getMessage(), "at path", false)) {
                throw e;
            }
            throw new MissingFieldException(e.missingFields, e.getMessage() + " at path: " + roomOpenHelper.getPath(), e);
        } catch (MissingFieldException e3) {
            if (StringsKt.contains(e3.getMessage(), "at path", false)) {
                throw e3;
            }
            throw new MissingFieldException(e3.missingFields, e3.getMessage() + " at path: " + roomOpenHelper.getPath(), e3);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        DatabaseConfiguration databaseConfiguration = this.lexer;
        long jConsumeNumericLiteral = databaseConfiguration.consumeNumericLiteral();
        short s = (short) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == s) {
            return s;
        }
        DatabaseConfiguration.fail$default(databaseConfiguration, "Failed to parse short for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return this.lexer.consumeString();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final void endStructure(SerialDescriptor serialDescriptor) {
        if (this.json.configuration.ignoreUnknownKeys && serialDescriptor.getElementsCount() == 0) {
            while (decodeElementIndex(serialDescriptor) != -1) {
            }
        }
        DatabaseConfiguration databaseConfiguration = this.lexer;
        if (databaseConfiguration.tryConsumeComma()) {
            WriteModeKt.invalidTrailingComma(databaseConfiguration, "");
            throw null;
        }
        databaseConfiguration.consumeNextToken(this.mode.end);
        RoomOpenHelper roomOpenHelper = (RoomOpenHelper) databaseConfiguration.context;
        int i = roomOpenHelper.version;
        int[] iArr = (int[]) roomOpenHelper.mDelegate;
        if (iArr[i] == -2) {
            iArr[i] = -1;
            roomOpenHelper.version = i - 1;
        }
        int i2 = roomOpenHelper.version;
        if (i2 != -1) {
            roomOpenHelper.version = i2 - 1;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder, kotlinx.serialization.encoding.Encoder
    public final Request getSerializersModule() {
        return this.serializersModule;
    }
}
