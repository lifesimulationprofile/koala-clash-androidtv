package com.github.kr328.clash.core.model;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ConnectionInfo$$serializer implements GeneratedSerializer {
    public static final ConnectionInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ConnectionInfo$$serializer connectionInfo$$serializer = new ConnectionInfo$$serializer();
        INSTANCE = connectionInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.core.model.ConnectionInfo", connectionInfo$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("metadata", false);
        pluginGeneratedSerialDescriptor.addElement("upload", true);
        pluginGeneratedSerialDescriptor.addElement("download", true);
        pluginGeneratedSerialDescriptor.addElement("start", true);
        pluginGeneratedSerialDescriptor.addElement("chains", true);
        pluginGeneratedSerialDescriptor.addElement("providerChains", true);
        pluginGeneratedSerialDescriptor.addElement("rule", true);
        pluginGeneratedSerialDescriptor.addElement("rulePayload", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = ConnectionInfo.$childSerializers;
        KSerializer kSerializer = kSerializerArr[5];
        KSerializer kSerializer2 = kSerializerArr[6];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, ConnectionMetadata$$serializer.INSTANCE, longSerializer, longSerializer, stringSerializer, kSerializer, kSerializer2, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int i;
        List list;
        List list2;
        String strDecodeStringElement;
        String str;
        ConnectionMetadata connectionMetadata;
        String str2;
        String strDecodeStringElement2;
        long j;
        long j2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = ConnectionInfo.$childSerializers;
        int i2 = 7;
        int i3 = 3;
        String strDecodeStringElement3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            ConnectionMetadata connectionMetadata2 = (ConnectionMetadata) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ConnectionMetadata$$serializer.INSTANCE, null);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
            long jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
            List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            str = strDecodeStringElement4;
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
            str2 = strDecodeStringElement5;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 8);
            list2 = list3;
            i = 511;
            connectionMetadata = connectionMetadata2;
            j = jDecodeLongElement;
            j2 = jDecodeLongElement2;
        } else {
            boolean z = true;
            int i4 = 0;
            List list4 = null;
            List list5 = null;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            long jDecodeLongElement3 = 0;
            long jDecodeLongElement4 = 0;
            String strDecodeStringElement8 = null;
            ConnectionMetadata connectionMetadata3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                        break;
                    case 0:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i4 |= 1;
                        i2 = 7;
                        i3 = 3;
                        break;
                    case 1:
                        connectionMetadata3 = (ConnectionMetadata) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ConnectionMetadata$$serializer.INSTANCE, connectionMetadata3);
                        i4 |= 2;
                        i2 = 7;
                        i3 = 3;
                        break;
                    case 2:
                        jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, i3);
                        i4 |= 8;
                        break;
                    case 4:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list5);
                        i4 |= 32;
                        break;
                    case 6:
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], list4);
                        i4 |= 64;
                        break;
                    case 7:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, i2);
                        i4 |= 128;
                        break;
                    case 8:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 8);
                        i4 |= 256;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i4;
            list = list4;
            list2 = list5;
            strDecodeStringElement = strDecodeStringElement3;
            str = strDecodeStringElement8;
            connectionMetadata = connectionMetadata3;
            str2 = strDecodeStringElement6;
            strDecodeStringElement2 = strDecodeStringElement7;
            j = jDecodeLongElement3;
            j2 = jDecodeLongElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ConnectionInfo(i, str, connectionMetadata, j, j2, str2, list2, list, strDecodeStringElement2, strDecodeStringElement);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        ConnectionInfo connectionInfo = (ConnectionInfo) obj;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderMo810beginStructure = encoder.mo810beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = ConnectionInfo.$childSerializers;
        String str = connectionInfo.id;
        String str2 = connectionInfo.rulePayload;
        String str3 = connectionInfo.rule;
        List list = connectionInfo.providerChains;
        List list2 = connectionInfo.chains;
        String str4 = connectionInfo.start;
        long j = connectionInfo.download;
        long j2 = connectionInfo.upload;
        compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 1, ConnectionMetadata$$serializer.INSTANCE, connectionInfo.metadata);
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || j2 != 0) {
            compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 2, j2);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || j != 0) {
            compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 3, j);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str4, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 4, str4);
        }
        boolean zShouldEncodeElementDefault = compositeEncoderMo810beginStructure.shouldEncodeElementDefault();
        EmptyList emptyList = EmptyList.INSTANCE;
        if (zShouldEncodeElementDefault || !Intrinsics.areEqual(list2, emptyList)) {
            compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list2);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(list, emptyList)) {
            compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], list);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str3, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 7, str3);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(str2, "")) {
            compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 8, str2);
        }
        compositeEncoderMo810beginStructure.endStructure();
    }
}
