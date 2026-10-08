package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CollectionLikeSerializer extends AbstractCollectionSerializer {
    public final KSerializer elementSerializer;

    public CollectionLikeSerializer(KSerializer kSerializer) {
        this.elementSerializer = kSerializer;
    }

    public abstract void insert(int i, Object obj, Object obj2);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readAll(CompositeDecoder compositeDecoder, Object obj, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            readElement(compositeDecoder, i + i3, obj);
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        insert(i, obj, compositeDecoder.decodeSerializableElement(getDescriptor(), i, this.elementSerializer, null));
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object obj) {
        int iCollectionSize = collectionSize(obj);
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(getDescriptor(), iCollectionSize);
        Iterator itCollectionIterator = collectionIterator(obj);
        for (int i = 0; i < iCollectionSize; i++) {
            compositeEncoderBeginCollection.encodeSerializableElement(getDescriptor(), i, this.elementSerializer, itCollectionIterator.next());
        }
        compositeEncoderBeginCollection.endStructure();
    }
}
