package com.github.kr328.clash.core.model;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.GeneratedSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LogMessage$Level$$serializer implements GeneratedSerializer {
    public static final LogMessage$Level$$serializer INSTANCE = new LogMessage$Level$$serializer();
    private static final SerialDescriptor descriptor;

    static {
        EnumDescriptor enumDescriptor = new EnumDescriptor("com.github.kr328.clash.core.model.LogMessage.Level", 6);
        enumDescriptor.addElement("debug", false);
        enumDescriptor.addElement("info", false);
        enumDescriptor.addElement("warning", false);
        enumDescriptor.addElement("error", false);
        enumDescriptor.addElement("silent", false);
        enumDescriptor.addElement("unknown", false);
        descriptor = enumDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[0];
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        return LogMessage.Level.values()[decoder.decodeEnum(descriptor)];
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        encoder.encodeEnum(descriptor, ((LogMessage.Level) obj).ordinal());
    }
}
