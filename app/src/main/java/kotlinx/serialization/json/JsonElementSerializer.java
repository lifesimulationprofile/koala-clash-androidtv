package kotlinx.serialization.json;

import coil.network.HttpException;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import kotlin.collections.ArraysKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind$SEALED;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class JsonElementSerializer implements KSerializer {
    public static final JsonElementSerializer INSTANCE = new JsonElementSerializer();
    public static final SerialDescriptorImpl descriptor;

    static {
        SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[0];
        Remote$$ExternalSyntheticLambda1 remote$$ExternalSyntheticLambda1 = new Remote$$ExternalSyntheticLambda1(21);
        if (StringsKt.isBlank("kotlinx.serialization.json.JsonElement")) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        StructureKind.MAP map = StructureKind.MAP.INSTANCE$1;
        PolymorphicKind$SEALED polymorphicKind$SEALED = PolymorphicKind$SEALED.INSTANCE;
        if (polymorphicKind$SEALED.equals(map)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder("kotlinx.serialization.json.JsonElement");
        remote$$ExternalSyntheticLambda1.invoke(classSerialDescriptorBuilder);
        descriptor = new SerialDescriptorImpl("kotlinx.serialization.json.JsonElement", polymorphicKind$SEALED, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        return JsonElementSerializersKt.asJsonDecoder(decoder).decodeJsonElement();
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        JsonElement jsonElement = (JsonElement) obj;
        JsonElementSerializersKt.access$verify(encoder);
        if (jsonElement instanceof JsonPrimitive) {
            encoder.encodeSerializableValue(JsonPrimitiveSerializer.INSTANCE, jsonElement);
        } else if (jsonElement instanceof JsonObject) {
            encoder.encodeSerializableValue(JsonObjectSerializer.INSTANCE, jsonElement);
        } else {
            if (!(jsonElement instanceof JsonArray)) {
                throw new HttpException();
            }
            encoder.encodeSerializableValue(JsonArraySerializer.INSTANCE, jsonElement);
        }
    }
}
