package com.github.kr328.clash.core.model;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.GeneratedSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TunnelState$Mode$$serializer implements GeneratedSerializer {
    public static final TunnelState$Mode$$serializer INSTANCE = new TunnelState$Mode$$serializer();
    private static final SerialDescriptor descriptor;

    static {
        EnumDescriptor enumDescriptor = new EnumDescriptor("com.github.kr328.clash.core.model.TunnelState.Mode", 4);
        enumDescriptor.addElement("direct", false);
        enumDescriptor.addElement("global", false);
        enumDescriptor.addElement("rule", false);
        enumDescriptor.addElement("script", false);
        descriptor = enumDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[0];
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        return TunnelState.Mode.values()[decoder.decodeEnum(descriptor)];
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        encoder.encodeEnum(descriptor, ((TunnelState.Mode) obj).ordinal());
    }
}
