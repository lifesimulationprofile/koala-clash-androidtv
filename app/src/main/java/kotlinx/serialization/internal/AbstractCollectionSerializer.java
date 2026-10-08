package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractCollectionSerializer implements KSerializer {
    public abstract Object builder();

    public abstract int builderSize(Object obj);

    public abstract void checkCapacity(int i, Object obj);

    public abstract Iterator collectionIterator(Object obj);

    public abstract int collectionSize(Object obj);

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return merge(decoder);
    }

    public final Object merge(Decoder decoder) {
        Object objBuilder = builder();
        int iBuilderSize = builderSize(objBuilder);
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(getDescriptor());
        if (!compositeDecoderBeginStructure.decodeSequentially()) {
            while (true) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    break;
                }
                readElement(compositeDecoderBeginStructure, iDecodeElementIndex + iBuilderSize, objBuilder);
            }
        } else {
            getDescriptor();
            int iDecodeCollectionSize = compositeDecoderBeginStructure.decodeCollectionSize();
            checkCapacity(iDecodeCollectionSize, objBuilder);
            readAll(compositeDecoderBeginStructure, objBuilder, iBuilderSize, iDecodeCollectionSize);
        }
        compositeDecoderBeginStructure.endStructure(getDescriptor());
        return toResult(objBuilder);
    }

    public abstract void readAll(CompositeDecoder compositeDecoder, Object obj, int i, int i2);

    public abstract void readElement(CompositeDecoder compositeDecoder, int i, Object obj);

    public abstract Object toBuilder(Object obj);

    public abstract Object toResult(Object obj);
}
