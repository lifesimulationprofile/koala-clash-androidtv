package com.github.kr328.clash.service.model;

import java.util.UUID;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Profile$$serializer implements GeneratedSerializer {
    public static final Profile$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Profile$$serializer profile$$serializer = new Profile$$serializer();
        INSTANCE = profile$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.service.model.Profile", profile$$serializer, 15);
        pluginGeneratedSerialDescriptor.addElement("uuid", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("source", false);
        pluginGeneratedSerialDescriptor.addElement("active", false);
        pluginGeneratedSerialDescriptor.addElement("interval", false);
        pluginGeneratedSerialDescriptor.addElement("upload", false);
        pluginGeneratedSerialDescriptor.addElement("download", false);
        pluginGeneratedSerialDescriptor.addElement("total", false);
        pluginGeneratedSerialDescriptor.addElement("expire", false);
        pluginGeneratedSerialDescriptor.addElement("updatedAt", false);
        pluginGeneratedSerialDescriptor.addElement("profileImagePath", true);
        pluginGeneratedSerialDescriptor.addElement("announce", true);
        pluginGeneratedSerialDescriptor.addElement("supportURL", true);
        pluginGeneratedSerialDescriptor.addElement("modeSwitchAllowed", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = Profile.$childSerializers;
        KSerializer kSerializer = kSerializerArr[0];
        KSerializer kSerializer2 = kSerializerArr[2];
        NullableSerializer nullableSerializer = new NullableSerializer();
        NullableSerializer nullableSerializer2 = new NullableSerializer();
        NullableSerializer nullableSerializer3 = new NullableSerializer();
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, stringSerializer, kSerializer2, stringSerializer, booleanSerializer, longSerializer, longSerializer, longSerializer, longSerializer, longSerializer, longSerializer, nullableSerializer, nullableSerializer2, nullableSerializer3, booleanSerializer};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        String str;
        String str2;
        Profile.Type type;
        boolean z;
        UUID uuid;
        String str3;
        int i;
        String str4;
        String str5;
        boolean zDecodeBooleanElement;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = Profile.$childSerializers;
        int i2 = 10;
        int i3 = 9;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            UUID uuid2 = (UUID) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            Profile.Type type2 = (Profile.Type) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 5);
            long jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 6);
            long jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 7);
            long jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 8);
            long jDecodeLongElement5 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 9);
            long jDecodeLongElement6 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 10);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, null);
            str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, null);
            uuid = uuid2;
            str5 = strDecodeStringElement2;
            str4 = strDecodeStringElement;
            z = zDecodeBooleanElement2;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 14);
            j = jDecodeLongElement6;
            j2 = jDecodeLongElement3;
            j3 = jDecodeLongElement;
            j4 = jDecodeLongElement4;
            i = 32767;
            str = str7;
            str2 = str6;
            j5 = jDecodeLongElement2;
            j6 = jDecodeLongElement5;
            type = type2;
        } else {
            int i4 = 14;
            int i5 = 2;
            boolean z2 = true;
            int i6 = 0;
            boolean zDecodeBooleanElement3 = false;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            UUID uuid3 = null;
            long jDecodeLongElement7 = 0;
            long jDecodeLongElement8 = 0;
            long jDecodeLongElement9 = 0;
            long jDecodeLongElement10 = 0;
            long jDecodeLongElement11 = 0;
            long jDecodeLongElement12 = 0;
            boolean zDecodeBooleanElement4 = false;
            Profile.Type type3 = null;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i2 = 10;
                        i3 = 9;
                        i5 = 2;
                        break;
                    case 0:
                        uuid3 = (UUID) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], uuid3);
                        i6 |= 1;
                        i4 = 14;
                        i2 = 10;
                        i3 = 9;
                        i5 = 2;
                        break;
                    case 1:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i6 |= 2;
                        i4 = 14;
                        i2 = 10;
                        break;
                    case 2:
                        type3 = (Profile.Type) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i5, kSerializerArr[i5], type3);
                        i6 |= 4;
                        i4 = 14;
                        i2 = 10;
                        break;
                    case 3:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                        i4 = 14;
                        break;
                    case 4:
                        i6 |= 16;
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i4 = 14;
                        break;
                    case 5:
                        jDecodeLongElement9 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 5);
                        i6 |= 32;
                        i4 = 14;
                        break;
                    case 6:
                        jDecodeLongElement11 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 6);
                        i6 |= 64;
                        i4 = 14;
                        break;
                    case 7:
                        jDecodeLongElement8 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 7);
                        i6 |= 128;
                        i4 = 14;
                        break;
                    case 8:
                        jDecodeLongElement10 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 8);
                        i6 |= 256;
                        i4 = 14;
                        break;
                    case 9:
                        jDecodeLongElement12 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, i3);
                        i6 |= 512;
                        i4 = 14;
                        break;
                    case 10:
                        jDecodeLongElement7 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, i2);
                        i6 |= 1024;
                        i4 = 14;
                        break;
                    case 11:
                        StringSerializer stringSerializer2 = StringSerializer.INSTANCE;
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, str9);
                        i6 |= 2048;
                        i4 = 14;
                        break;
                    case 12:
                        StringSerializer stringSerializer3 = StringSerializer.INSTANCE;
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, str8);
                        i6 |= 4096;
                        i4 = 14;
                        break;
                    case 13:
                        StringSerializer stringSerializer4 = StringSerializer.INSTANCE;
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, str10);
                        i6 |= 8192;
                        break;
                    case 14:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i4);
                        i6 |= 16384;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str8;
            str2 = str9;
            type = type3;
            z = zDecodeBooleanElement4;
            uuid = uuid3;
            str3 = str10;
            i = i6;
            str4 = strDecodeStringElement3;
            str5 = strDecodeStringElement4;
            zDecodeBooleanElement = zDecodeBooleanElement3;
            j = jDecodeLongElement7;
            j2 = jDecodeLongElement8;
            j3 = jDecodeLongElement9;
            j4 = jDecodeLongElement10;
            j5 = jDecodeLongElement11;
            j6 = jDecodeLongElement12;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Profile(i, uuid, str4, type, str5, z, j3, j5, j2, j4, j6, j, str2, str, str3, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        Profile profile = (Profile) obj;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderMo810beginStructure = encoder.mo810beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = Profile.$childSerializers;
        KSerializer kSerializer = kSerializerArr[0];
        UUID uuid = profile.uuid;
        boolean z = profile.modeSwitchAllowed;
        String str = profile.supportURL;
        String str2 = profile.announce;
        String str3 = profile.profileImagePath;
        compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 0, kSerializer, uuid);
        compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 1, profile.name);
        compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], profile.type);
        compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 3, profile.source);
        compositeEncoderMo810beginStructure.encodeBooleanElement(serialDescriptor, 4, profile.active);
        compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 5, profile.interval);
        compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 6, profile.upload);
        compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 7, profile.download);
        compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 8, profile.total);
        compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 9, profile.expire);
        compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 10, profile.updatedAt);
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || str3 != null) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            compositeEncoderMo810beginStructure.encodeNullableSerializableElement(serialDescriptor, 11, str3);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || str2 != null) {
            StringSerializer stringSerializer2 = StringSerializer.INSTANCE;
            compositeEncoderMo810beginStructure.encodeNullableSerializableElement(serialDescriptor, 12, str2);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || str != null) {
            StringSerializer stringSerializer3 = StringSerializer.INSTANCE;
            compositeEncoderMo810beginStructure.encodeNullableSerializableElement(serialDescriptor, 13, str);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !z) {
            compositeEncoderMo810beginStructure.encodeBooleanElement(serialDescriptor, 14, z);
        }
        compositeEncoderMo810beginStructure.endStructure();
    }
}
