package kotlinx.serialization.internal;

import androidx.compose.ui.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonElementSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LinkedHashMapSerializer extends AbstractCollectionSerializer {
    public final LinkedHashMapClassDesc descriptor;

    public LinkedHashMapSerializer() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        JsonElementSerializer jsonElementSerializer = JsonElementSerializer.INSTANCE;
        this.descriptor = new LinkedHashMapClassDesc(StringSerializer.descriptor, JsonElementSerializer.descriptor);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object builder() {
        return new LinkedHashMap();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int builderSize(Object obj) {
        return ((LinkedHashMap) obj).size() * 2;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final /* bridge */ /* synthetic */ void checkCapacity(int i, Object obj) {
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator collectionIterator(Object obj) {
        return ((Map) obj).entrySet().iterator();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        throw null;
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readAll(CompositeDecoder compositeDecoder, Object obj, int i, int i2) {
        Map map = (Map) obj;
        if (i2 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, i2 * 2), 2);
        int i3 = intProgressionStep.first;
        int i4 = intProgressionStep.last;
        int i5 = intProgressionStep.step;
        if ((i5 <= 0 || i3 > i4) && (i5 >= 0 || i4 > i3)) {
            return;
        }
        while (true) {
            readElement(compositeDecoder, i + i3, map, false);
            if (i3 == i4) {
                return;
            } else {
                i3 += i5;
            }
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final /* bridge */ /* synthetic */ void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        readElement(compositeDecoder, i, (Map) obj, true);
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        int size = ((Map) obj).size();
        LinkedHashMapClassDesc linkedHashMapClassDesc = this.descriptor;
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(linkedHashMapClassDesc, size);
        Iterator itCollectionIterator = collectionIterator(obj);
        int i = 0;
        while (itCollectionIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) itCollectionIterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i2 = i + 1;
            compositeEncoderBeginCollection.encodeSerializableElement(linkedHashMapClassDesc, i, StringSerializer.INSTANCE, key);
            i += 2;
            compositeEncoderBeginCollection.encodeSerializableElement(linkedHashMapClassDesc, i2, JsonElementSerializer.INSTANCE, value);
        }
        compositeEncoderBeginCollection.endStructure();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        return new LinkedHashMap((Map) null);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toResult(Object obj) {
        return (LinkedHashMap) obj;
    }

    public final void readElement(CompositeDecoder compositeDecoder, int i, Map map, boolean z) {
        int iDecodeElementIndex;
        JsonElementSerializer jsonElementSerializer = JsonElementSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        LinkedHashMapClassDesc linkedHashMapClassDesc = this.descriptor;
        Object objDecodeSerializableElement = compositeDecoder.decodeSerializableElement(linkedHashMapClassDesc, i, stringSerializer, null);
        if (z) {
            iDecodeElementIndex = compositeDecoder.decodeElementIndex(linkedHashMapClassDesc);
            if (iDecodeElementIndex != i + 1) {
                throw new IllegalArgumentException(Modifier.CC.m(i, iDecodeElementIndex, "Value must follow key in a map, index for key: ", ", returned index for value: ").toString());
            }
        } else {
            iDecodeElementIndex = i + 1;
        }
        map.put(objDecodeSerializableElement, (!map.containsKey(objDecodeSerializableElement) || (JsonElementSerializer.descriptor.kind instanceof PrimitiveKind)) ? compositeDecoder.decodeSerializableElement(linkedHashMapClassDesc, iDecodeElementIndex, jsonElementSerializer, null) : compositeDecoder.decodeSerializableElement(linkedHashMapClassDesc, iDecodeElementIndex, jsonElementSerializer, MapsKt__MapsKt.getValue(objDecodeSerializableElement, map)));
    }
}
