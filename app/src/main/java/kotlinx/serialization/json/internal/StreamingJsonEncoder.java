package kotlinx.serialization.json.internal;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.memory.RealWeakMemoryCache;
import coil.network.HttpException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElementKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StreamingJsonEncoder implements Encoder, CompositeEncoder {
    public final Composer composer;
    public final JsonConfiguration configuration;
    public boolean forceQuoting;
    public final Json json;
    public final WriteMode mode;
    public final StreamingJsonEncoder[] modeReuseCache;
    public String polymorphicDiscriminator;
    public String polymorphicSerialName;
    public final Request serializersModule;

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode writeMode, StreamingJsonEncoder[] streamingJsonEncoderArr) {
        this.composer = composer;
        this.json = json;
        this.mode = writeMode;
        this.modeReuseCache = streamingJsonEncoderArr;
        this.serializersModule = json.serializersModule;
        this.configuration = json.configuration;
        int iOrdinal = writeMode.ordinal();
        if (streamingJsonEncoderArr != null) {
            StreamingJsonEncoder streamingJsonEncoder = streamingJsonEncoderArr[iOrdinal];
            if (streamingJsonEncoder == null && streamingJsonEncoder == this) {
                return;
            }
            streamingJsonEncoderArr[iOrdinal] = this;
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        return mo810beginStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    /* JADX INFO: renamed from: beginStructure */
    public final CompositeEncoder mo810beginStructure(SerialDescriptor serialDescriptor) {
        StreamingJsonEncoder streamingJsonEncoder;
        Json json = this.json;
        WriteMode writeModeSwitchMode = WriteModeKt.switchMode(serialDescriptor, json);
        char c = writeModeSwitchMode.begin;
        Composer composer = this.composer;
        composer.print(c);
        composer.writingFirst = true;
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            String serialName = this.polymorphicSerialName;
            if (serialName == null) {
                serialName = serialDescriptor.getSerialName();
            }
            composer.nextItem();
            encodeString(str);
            composer.print(':');
            encodeString(serialName);
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        if (this.mode == writeModeSwitchMode) {
            return this;
        }
        StreamingJsonEncoder[] streamingJsonEncoderArr = this.modeReuseCache;
        return (streamingJsonEncoderArr == null || (streamingJsonEncoder = streamingJsonEncoderArr[writeModeSwitchMode.ordinal()]) == null) ? new StreamingJsonEncoder(composer, json, writeModeSwitchMode, streamingJsonEncoderArr) : streamingJsonEncoder;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(z));
        } else {
            ((RealWeakMemoryCache) this.composer.writer).write(String.valueOf(z));
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z) {
        encodeElement(serialDescriptor, i);
        encodeBoolean(z);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) b));
        } else {
            this.composer.print(b);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, byte b) {
        encodeElement(primitiveArrayDescriptor, i);
        encodeByte(b);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
        encodeString(String.valueOf(c));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, char c) {
        encodeElement(primitiveArrayDescriptor, i);
        encodeChar(c);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double d) {
        boolean z = this.forceQuoting;
        Composer composer = this.composer;
        if (z) {
            encodeString(String.valueOf(d));
        } else {
            ((RealWeakMemoryCache) composer.writer).write(String.valueOf(d));
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw WriteModeKt.InvalidFloatingPointEncoded(Double.valueOf(d), ((RealWeakMemoryCache) composer.writer).toString());
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, double d) {
        encodeElement(primitiveArrayDescriptor, i);
        encodeDouble(d);
    }

    public final void encodeElement(SerialDescriptor serialDescriptor, int i) {
        int iOrdinal = this.mode.ordinal();
        Composer composer = this.composer;
        boolean z = true;
        if (iOrdinal == 1) {
            if (!composer.writingFirst) {
                composer.print(',');
            }
            composer.nextItem();
            return;
        }
        if (iOrdinal == 2) {
            if (composer.writingFirst) {
                this.forceQuoting = true;
                composer.nextItem();
                return;
            }
            if (i % 2 == 0) {
                composer.print(',');
                composer.nextItem();
            } else {
                composer.print(':');
                composer.space();
                z = false;
            }
            this.forceQuoting = z;
            return;
        }
        if (iOrdinal != 3) {
            if (!composer.writingFirst) {
                composer.print(',');
            }
            composer.nextItem();
            WriteModeKt.namingStrategy(serialDescriptor, this.json);
            encodeString(serialDescriptor.getElementName(i));
            composer.print(':');
            composer.space();
            return;
        }
        if (i == 0) {
            this.forceQuoting = true;
        }
        if (i == 1) {
            composer.print(',');
            composer.space();
            this.forceQuoting = false;
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        encodeString(serialDescriptor.getElementName(i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
        boolean z = this.forceQuoting;
        Composer composer = this.composer;
        if (z) {
            encodeString(String.valueOf(f));
        } else {
            ((RealWeakMemoryCache) composer.writer).write(String.valueOf(f));
        }
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw WriteModeKt.InvalidFloatingPointEncoded(Float.valueOf(f), ((RealWeakMemoryCache) composer.writer).toString());
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, float f) {
        encodeElement(primitiveArrayDescriptor, i);
        encodeFloat(f);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final Encoder encodeInline(SerialDescriptor serialDescriptor) {
        boolean zIsUnsignedNumber = StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor);
        WriteMode writeMode = this.mode;
        Json json = this.json;
        Composer composerForUnquotedLiterals = this.composer;
        if (zIsUnsignedNumber) {
            if (!(composerForUnquotedLiterals instanceof ComposerForUnsignedNumbers)) {
                composerForUnquotedLiterals = new ComposerForUnsignedNumbers((RealWeakMemoryCache) composerForUnquotedLiterals.writer, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composerForUnquotedLiterals, json, writeMode, null);
        }
        if (serialDescriptor.isInline() && serialDescriptor.equals(JsonElementKt.jsonUnquotedLiteralDescriptor)) {
            if (!(composerForUnquotedLiterals instanceof ComposerForUnquotedLiterals)) {
                composerForUnquotedLiterals = new ComposerForUnquotedLiterals((RealWeakMemoryCache) composerForUnquotedLiterals.writer, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composerForUnquotedLiterals, json, writeMode, null);
        }
        if (this.polymorphicDiscriminator != null) {
            this.polymorphicSerialName = serialDescriptor.getSerialName();
        }
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder encodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        encodeElement(primitiveArrayDescriptor, i);
        return encodeInline(primitiveArrayDescriptor.getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int i) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(i));
        } else {
            this.composer.print(i);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(int i, int i2, SerialDescriptor serialDescriptor) {
        encodeElement(serialDescriptor, i);
        encodeInt(i2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long j) {
        if (this.forceQuoting) {
            encodeString(String.valueOf(j));
        } else {
            this.composer.print(j);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j) {
        encodeElement(serialDescriptor, i);
        encodeLong(j);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeNull() {
        ((RealWeakMemoryCache) this.composer.writer).write("null");
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, Object obj) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        if (obj != null || this.configuration.explicitNulls) {
            StringSerializer stringSerializer2 = StringSerializer.INSTANCE;
            encodeElement(serialDescriptor, i);
            StringSerializer stringSerializer3 = StringSerializer.INSTANCE;
            if (obj == null) {
                encodeNull();
            } else {
                encodeSerializableValue(stringSerializer3, obj);
            }
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        encodeElement(serialDescriptor, i);
        encodeSerializableValue(kSerializer, obj);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeSerializableValue(KSerializer kSerializer, Object obj) {
        String strClassDiscriminator;
        Json json = this.json;
        int i = json.configuration.classDiscriminatorMode;
        boolean z = kSerializer instanceof PolymorphicSerializer;
        if (!z) {
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    SerialKind kind = kSerializer.getDescriptor().getKind();
                    strClassDiscriminator = (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE$1) || Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE$3)) ? WriteModeKt.classDiscriminator(kSerializer.getDescriptor(), json) : null;
                } else if (iOrdinal != 2) {
                    throw new HttpException();
                }
            }
        } else if (i != 1) {
        }
        if (!z) {
            if (strClassDiscriminator != null) {
                String serialName = kSerializer.getDescriptor().getSerialName();
                this.polymorphicDiscriminator = strClassDiscriminator;
                this.polymorphicSerialName = serialName;
            }
            kSerializer.serialize(this, obj);
            return;
        }
        PolymorphicSerializer polymorphicSerializer = (PolymorphicSerializer) kSerializer;
        if (obj != null) {
            Request serializersModule = getSerializersModule();
            polymorphicSerializer.getClass();
            serializersModule.getClass();
            throw null;
        }
        throw new IllegalArgumentException(("Value for serializer " + polymorphicSerializer.getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short s) {
        if (this.forceQuoting) {
            encodeString(String.valueOf((int) s));
        } else {
            this.composer.print(s);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, short s) {
        encodeElement(primitiveArrayDescriptor, i);
        encodeShort(s);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeString(String str) {
        this.composer.printQuoted(str);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str) {
        encodeElement(serialDescriptor, i);
        encodeString(str);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure() {
        Composer composer = this.composer;
        composer.getClass();
        composer.writingFirst = false;
        composer.print(this.mode.end);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final Request getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final boolean shouldEncodeElementDefault() {
        return false;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeNotNullMark() {
    }
}
