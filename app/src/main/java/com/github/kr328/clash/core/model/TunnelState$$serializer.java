package com.github.kr328.clash.core.model;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TunnelState$$serializer implements GeneratedSerializer {
    public static final TunnelState$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TunnelState$$serializer tunnelState$$serializer = new TunnelState$$serializer();
        INSTANCE = tunnelState$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.core.model.TunnelState", tunnelState$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("mode", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{TunnelState$Mode$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        TunnelState.Mode mode;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        TunnelState.Mode mode2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            mode = (TunnelState.Mode) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, TunnelState$Mode$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    mode2 = (TunnelState.Mode) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, TunnelState$Mode$$serializer.INSTANCE, mode2);
                    i2 = 1;
                }
            }
            mode = mode2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new TunnelState(i, mode);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderMo810beginStructure = encoder.mo810beginStructure(serialDescriptor);
        compositeEncoderMo810beginStructure.encodeSerializableElement(serialDescriptor, 0, TunnelState$Mode$$serializer.INSTANCE, ((TunnelState) obj).mode);
        compositeEncoderMo810beginStructure.endStructure();
    }
}
