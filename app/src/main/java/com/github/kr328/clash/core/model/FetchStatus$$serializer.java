package com.github.kr328.clash.core.model;

import java.util.List;
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

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FetchStatus$$serializer implements GeneratedSerializer {
    public static final FetchStatus$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        FetchStatus$$serializer fetchStatus$$serializer = new FetchStatus$$serializer();
        INSTANCE = fetchStatus$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.core.model.FetchStatus", fetchStatus$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("action", false);
        pluginGeneratedSerialDescriptor.addElement("args", false);
        pluginGeneratedSerialDescriptor.addElement("progress", false);
        pluginGeneratedSerialDescriptor.addElement("max", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = FetchStatus.$childSerializers;
        KSerializer kSerializer = kSerializerArr[0];
        KSerializer kSerializer2 = kSerializerArr[1];
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, kSerializer2, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int iDecodeIntElement;
        int i;
        int i2;
        FetchStatus.Action action;
        List list;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = FetchStatus.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            FetchStatus.Action action2 = (FetchStatus.Action) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
            list = list2;
            action = action2;
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 3);
            i = iDecodeIntElement2;
            i2 = 15;
        } else {
            boolean z = true;
            int iDecodeIntElement3 = 0;
            int i3 = 0;
            FetchStatus.Action action3 = null;
            List list3 = null;
            int iDecodeIntElement4 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    action3 = (FetchStatus.Action) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], action3);
                    i3 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list3);
                    i3 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                    i3 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 3);
                    i3 |= 8;
                }
            }
            iDecodeIntElement = iDecodeIntElement3;
            i = iDecodeIntElement4;
            i2 = i3;
            action = action3;
            list = list3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new FetchStatus(i2, action, list, i, iDecodeIntElement);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        FetchStatus fetchStatus = (FetchStatus) obj;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderMo810beginStructure = encoder.mo810beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = FetchStatus.$childSerializers;
        compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], fetchStatus.action);
        compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], fetchStatus.args);
        compositeEncoderMo810beginStructure.encodeIntElement(2, fetchStatus.progress, serialDescriptor);
        compositeEncoderMo810beginStructure.encodeIntElement(3, fetchStatus.max, serialDescriptor);
        compositeEncoderMo810beginStructure.endStructure();
    }
}
