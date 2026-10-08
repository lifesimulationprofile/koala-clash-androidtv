package kotlinx.serialization.json;

import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.LinkedHashMapClassDesc;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class JsonObjectSerializer implements KSerializer {
    public static final JsonObjectSerializer INSTANCE = new JsonObjectSerializer();
    public static final JsonObjectDescriptor descriptor = JsonObjectDescriptor.INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class JsonObjectDescriptor implements SerialDescriptor {
        public static final JsonObjectDescriptor INSTANCE = new JsonObjectDescriptor();
        public static final String serialName = "kotlinx.serialization.json.JsonObject";
        public final /* synthetic */ LinkedHashMapClassDesc $$delegate_0;

        public JsonObjectDescriptor() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            JsonElementSerializer jsonElementSerializer = JsonElementSerializer.INSTANCE;
            this.$$delegate_0 = new LinkedHashMapClassDesc(StringSerializer.descriptor, JsonElementSerializer.descriptor);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List getAnnotations() {
            this.$$delegate_0.getClass();
            return EmptyList.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List getElementAnnotations(int i) {
            this.$$delegate_0.getElementAnnotations(i);
            return EmptyList.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialDescriptor getElementDescriptor(int i) {
            return this.$$delegate_0.getElementDescriptor(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int getElementIndex(String str) {
            return this.$$delegate_0.getElementIndex(str);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String getElementName(int i) {
            this.$$delegate_0.getClass();
            return String.valueOf(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int getElementsCount() {
            this.$$delegate_0.getClass();
            return 2;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialKind getKind() {
            this.$$delegate_0.getClass();
            return StructureKind.MAP.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String getSerialName() {
            return serialName;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isElementOptional(int i) {
            this.$$delegate_0.isElementOptional(i);
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isInline() {
            this.$$delegate_0.getClass();
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isNullable() {
            this.$$delegate_0.getClass();
            return false;
        }
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        JsonElementSerializersKt.asJsonDecoder(decoder);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        JsonElementSerializer jsonElementSerializer = JsonElementSerializer.INSTANCE;
        return new JsonObject((Map) new LinkedHashMapSerializer().merge(decoder));
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        JsonObject jsonObject = (JsonObject) obj;
        JsonElementSerializersKt.access$verify(encoder);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        JsonElementSerializer jsonElementSerializer = JsonElementSerializer.INSTANCE;
        LinkedHashMapClassDesc linkedHashMapClassDesc = new LinkedHashMapClassDesc(StringSerializer.descriptor, JsonElementSerializer.descriptor);
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(linkedHashMapClassDesc, jsonObject.content.size());
        int i = 0;
        for (Map.Entry entry : jsonObject.content.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i2 = i + 1;
            compositeEncoderBeginCollection.encodeSerializableElement(linkedHashMapClassDesc, i, stringSerializer, key);
            i += 2;
            compositeEncoderBeginCollection.encodeSerializableElement(linkedHashMapClassDesc, i2, jsonElementSerializer, value);
        }
        compositeEncoderBeginCollection.endStructure();
    }
}
