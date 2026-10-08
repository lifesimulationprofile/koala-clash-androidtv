package com.github.kr328.clash.core.model;

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
public final /* synthetic */ class Provider$$serializer implements GeneratedSerializer {
    public static final Provider$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Provider$$serializer provider$$serializer = new Provider$$serializer();
        INSTANCE = provider$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.core.model.Provider", provider$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("vehicleType", false);
        pluginGeneratedSerialDescriptor.addElement("updatedAt", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = Provider.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, kSerializerArr[1], kSerializerArr[2], LongSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int i;
        String str;
        long jDecodeLongElement;
        Provider.Type type;
        Provider.VehicleType vehicleType;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = Provider.$childSerializers;
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            Provider.Type type2 = (Provider.Type) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            vehicleType = (Provider.VehicleType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            str = strDecodeStringElement2;
            jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
            type = type2;
            i = 15;
        } else {
            long jDecodeLongElement2 = 0;
            boolean z = true;
            int i2 = 0;
            Provider.Type type3 = null;
            Provider.VehicleType vehicleType2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    type3 = (Provider.Type) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], type3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    vehicleType2 = (Provider.VehicleType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], vehicleType2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            i = i2;
            str = strDecodeStringElement;
            jDecodeLongElement = jDecodeLongElement2;
            type = type3;
            vehicleType = vehicleType2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Provider(i, str, type, vehicleType, jDecodeLongElement);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        Provider provider = (Provider) obj;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderMo810beginStructure = encoder.mo810beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = Provider.$childSerializers;
        compositeEncoderMo810beginStructure.encodeStringElement(serialDescriptor, 0, provider.name);
        compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], provider.type);
        compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], provider.vehicleType);
        compositeEncoderMo810beginStructure.encodeLongElement(serialDescriptor, 3, provider.updatedAt);
        compositeEncoderMo810beginStructure.endStructure();
    }
}
