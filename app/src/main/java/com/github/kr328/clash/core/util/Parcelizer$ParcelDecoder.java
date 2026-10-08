package com.github.kr328.clash.core.util;

import android.os.Parcel;
import java.util.HashMap;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Parcelizer$ParcelDecoder implements Decoder, CompositeDecoder, Encoder, CompositeEncoder {
    public final /* synthetic */ int $r8$classId;
    public final Parcel parcel;
    public final Request serializersModule;

    public Parcelizer$ParcelDecoder(Parcel parcel, int i) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.parcel = parcel;
                this.serializersModule = new Request(new HashMap(), new HashMap(), new HashMap(), new HashMap(), new HashMap(), 16);
                break;
            default:
                this.parcel = parcel;
                this.serializersModule = new Request(new HashMap(), new HashMap(), new HashMap(), new HashMap(), new HashMap(), 16);
                break;
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        encodeInt(i);
        return this;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return this.parcel.readByte() != 0;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i) {
        return decodeBoolean();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        return this.parcel.readByte();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public byte decodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return this.parcel.readByte();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        return (char) this.parcel.readInt();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public char decodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeChar();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize() {
        return this.parcel.readInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        return this.parcel.readDouble();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public double decodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return this.parcel.readDouble();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        return this.parcel.readInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor serialDescriptor) {
        return this.parcel.readInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        return this.parcel.readFloat();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public float decodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return this.parcel.readFloat();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        return this.parcel.readInt();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeIntElement(SerialDescriptor serialDescriptor, int i) {
        return this.parcel.readInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return this.parcel.readLong();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public long decodeLongElement(SerialDescriptor serialDescriptor, int i) {
        return this.parcel.readLong();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return decodeBoolean();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Object decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, String str) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        StringSerializer stringSerializer2 = StringSerializer.INSTANCE;
        if (decodeBoolean()) {
            return decodeString();
        }
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeSequentially() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        return kSerializer.deserialize(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Object decodeSerializableValue(KSerializer kSerializer) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return decodeString();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        return (short) this.parcel.readInt();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public short decodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeShort();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        return this.parcel.readString();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public String decodeStringElement(SerialDescriptor serialDescriptor, int i) {
        return this.parcel.readString();
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        encodeByte(z ? (byte) 1 : (byte) 0);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z) {
        encodeByte(z ? (byte) 1 : (byte) 0);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        this.parcel.writeByte(b);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, byte b) {
        encodeByte(b);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        encodeInt(c);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, char c) {
        encodeInt(c);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        this.parcel.writeDouble(d);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, double d) {
        encodeDouble(d);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        encodeInt(i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        this.parcel.writeFloat(f);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, float f) {
        encodeFloat(f);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        this.parcel.writeInt(i);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeIntElement(int i, int i2, SerialDescriptor serialDescriptor) {
        encodeInt(i2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        this.parcel.writeLong(j);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j) {
        encodeLong(j);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
        encodeByte((byte) 1);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        encodeByte((byte) 0);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, Object obj) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        if (obj == null) {
            encodeNull();
        } else {
            encodeNotNullMark();
            encodeSerializableValue(stringSerializer, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        kSerializer.serialize(this, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeSerializableValue(KSerializer kSerializer, Object obj) {
        kSerializer.serialize(this, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        encodeInt(s);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, short s) {
        encodeInt(s);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeString(String str) {
        this.parcel.writeString(str);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str) {
        encodeString(str);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor serialDescriptor) {
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder, kotlinx.serialization.encoding.Encoder
    public final Request getSerializersModule() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    /* JADX INFO: renamed from: beginStructure, reason: collision with other method in class */
    public CompositeEncoder mo810beginStructure(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void endStructure() {
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Decoder decodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public Encoder encodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return this;
    }
}
