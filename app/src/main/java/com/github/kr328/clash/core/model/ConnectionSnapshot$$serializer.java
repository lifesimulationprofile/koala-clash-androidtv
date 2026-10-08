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

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ConnectionSnapshot$$serializer implements GeneratedSerializer {
    public static final ConnectionSnapshot$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ConnectionSnapshot$$serializer connectionSnapshot$$serializer = new ConnectionSnapshot$$serializer();
        INSTANCE = connectionSnapshot$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.core.model.ConnectionSnapshot", connectionSnapshot$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("downloadTotal", true);
        pluginGeneratedSerialDescriptor.addElement("uploadTotal", true);
        pluginGeneratedSerialDescriptor.addElement("connections", true);
        pluginGeneratedSerialDescriptor.addElement("memory", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer kSerializer = ConnectionSnapshot.$childSerializers[2];
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{longSerializer, longSerializer, kSerializer, longSerializer};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int i;
        List list;
        long jDecodeLongElement;
        long j;
        long j2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = ConnectionSnapshot.$childSerializers;
        List list2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            long jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
            long jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
            i = 15;
            j = jDecodeLongElement3;
            j2 = jDecodeLongElement2;
        } else {
            long jDecodeLongElement4 = 0;
            boolean z = true;
            int i2 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement6 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement5 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], list2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            i = i2;
            list = list2;
            jDecodeLongElement = jDecodeLongElement4;
            j = jDecodeLongElement5;
            j2 = jDecodeLongElement6;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ConnectionSnapshot(i, j2, j, list, jDecodeLongElement);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        ConnectionSnapshot connectionSnapshot = (ConnectionSnapshot) obj;
        long j = connectionSnapshot.memory;
        List list = connectionSnapshot.connections;
        long j2 = connectionSnapshot.uploadTotal;
        long j3 = connectionSnapshot.downloadTotal;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderMo810beginStructure = encoder.mo810beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = ConnectionSnapshot.$childSerializers;
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || j3 != 0) {
            compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 0, j3);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || j2 != 0) {
            compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 1, j2);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], list);
        }
        if (compositeEncoderMo810beginStructure.shouldEncodeElementDefault() || j != 0) {
            compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 3, j);
        }
        compositeEncoderMo810beginStructure.endStructure();
    }
}
