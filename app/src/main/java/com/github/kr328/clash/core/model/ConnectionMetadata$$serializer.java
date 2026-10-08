package com.github.kr328.clash.core.model;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ConnectionMetadata$$serializer implements GeneratedSerializer {
    public static final ConnectionMetadata$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ConnectionMetadata$$serializer connectionMetadata$$serializer = new ConnectionMetadata$$serializer();
        INSTANCE = connectionMetadata$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.core.model.ConnectionMetadata", connectionMetadata$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("network", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("sourceIP", true);
        pluginGeneratedSerialDescriptor.addElement("destinationIP", true);
        pluginGeneratedSerialDescriptor.addElement("sourcePort", true);
        pluginGeneratedSerialDescriptor.addElement("destinationPort", true);
        pluginGeneratedSerialDescriptor.addElement("host", true);
        pluginGeneratedSerialDescriptor.addElement("process", true);
        pluginGeneratedSerialDescriptor.addElement("processPath", true);
        pluginGeneratedSerialDescriptor.addElement("uid", true);
        pluginGeneratedSerialDescriptor.addElement("remoteDestination", true);
        pluginGeneratedSerialDescriptor.addElement("sniffHost", true);
        pluginGeneratedSerialDescriptor.addElement("inboundName", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, IntSerializer.INSTANCE, stringSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 0;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
            String strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
            String strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 6);
            String strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
            String strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 8);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 9);
            String strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 10);
            String strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 11);
            i2 = 8191;
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 12);
            str = strDecodeStringElement12;
            str2 = strDecodeStringElement11;
            i = iDecodeIntElement;
            str3 = strDecodeStringElement9;
            str4 = strDecodeStringElement8;
            str5 = strDecodeStringElement7;
            str6 = strDecodeStringElement5;
            str7 = strDecodeStringElement10;
            str8 = strDecodeStringElement6;
            str9 = strDecodeStringElement4;
            str10 = strDecodeStringElement3;
        } else {
            strDecodeStringElement = null;
            String strDecodeStringElement13 = null;
            String strDecodeStringElement14 = null;
            String strDecodeStringElement15 = null;
            String strDecodeStringElement16 = null;
            String strDecodeStringElement17 = null;
            String strDecodeStringElement18 = null;
            String strDecodeStringElement19 = null;
            String strDecodeStringElement20 = null;
            String strDecodeStringElement21 = null;
            String strDecodeStringElement22 = null;
            String strDecodeStringElement23 = null;
            boolean z = true;
            int iDecodeIntElement2 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        i2 |= 1;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        continue;
                    case 1:
                        strDecodeStringElement23 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                        continue;
                    case 2:
                        strDecodeStringElement22 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        strDecodeStringElement19 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i2 |= 8;
                        break;
                    case 4:
                        strDecodeStringElement21 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                        i2 |= 16;
                        break;
                    case 5:
                        strDecodeStringElement18 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
                        i2 |= 32;
                        break;
                    case 6:
                        strDecodeStringElement17 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 6);
                        i2 |= 64;
                        break;
                    case 7:
                        strDecodeStringElement16 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
                        i2 |= 128;
                        break;
                    case 8:
                        strDecodeStringElement20 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 8);
                        i2 |= 256;
                        break;
                    case 9:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 9);
                        i2 |= 512;
                        break;
                    case 10:
                        strDecodeStringElement15 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 10);
                        i2 |= 1024;
                        break;
                    case 11:
                        strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 11);
                        i2 |= 2048;
                        break;
                    case 12:
                        strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 12);
                        i2 |= 4096;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            strDecodeStringElement2 = strDecodeStringElement13;
            str = strDecodeStringElement14;
            str2 = strDecodeStringElement15;
            i = iDecodeIntElement2;
            str3 = strDecodeStringElement16;
            str4 = strDecodeStringElement17;
            str5 = strDecodeStringElement18;
            str6 = strDecodeStringElement19;
            str7 = strDecodeStringElement20;
            str8 = strDecodeStringElement21;
            str9 = strDecodeStringElement22;
            str10 = strDecodeStringElement23;
        }
        String str11 = strDecodeStringElement;
        int i3 = i2;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ConnectionMetadata(i3, str11, str10, str9, str6, str8, str5, str4, str3, str7, i, str2, str, strDecodeStringElement2);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        String str;
        ConnectionMetadata connectionMetadata = (ConnectionMetadata) obj;
        String str2 = connectionMetadata.inboundName;
        String str3 = connectionMetadata.sniffHost;
        String str4 = connectionMetadata.remoteDestination;
        int i = connectionMetadata.uid;
        String str5 = connectionMetadata.processPath;
        String str6 = connectionMetadata.process;
        String str7 = connectionMetadata.host;
        String str8 = connectionMetadata.destinationPort;
        String str9 = connectionMetadata.sourcePort;
        String str10 = connectionMetadata.destinationIP;
        String str11 = connectionMetadata.sourceIP;
        String str12 = connectionMetadata.type;
        String str13 = connectionMetadata.network;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderMo810beginStructure = encoder.mo810beginStructure(serialDescriptor);
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str13, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 0, str13);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str12, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 1, str12);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str11, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 2, str11);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str10, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 3, str10);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str9, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 4, str9);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str8, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 5, str8);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str7, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 6, str7);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str6, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 7, str6);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str5, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 8, str5);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || i != 0) {
            compositeEncoderMo810beginStructure.encodeIntElement(9, i, serialDescriptor);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str4, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 10, str4);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str3, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 11, str3);
        }
        if (!compositeEncoderMo810beginStructure.shouldEncodeElementDefault()) {
            str = str2;
            if (!Intrinsics.areEqual(str, "")) {
            }
            compositeEncoderMo810beginStructure.endStructure();
        }
        str = str2;
        compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 12, str);
        compositeEncoderMo810beginStructure.endStructure();
    }
}
