package kotlinx.serialization.internal;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CharArraySerializer extends PrimitiveArraySerializer {
    public static final CharArraySerializer INSTANCE = new CharArraySerializer(CharSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        return ((char[]) obj).length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new char[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        CharArrayBuilder charArrayBuilder = (CharArrayBuilder) obj;
        char cDecodeCharElement = compositeDecoder.decodeCharElement(this.descriptor, i);
        charArrayBuilder.ensureCapacity$kotlinx_serialization_core(charArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        char[] cArr = charArrayBuilder.buffer;
        int i2 = charArrayBuilder.position;
        charArrayBuilder.position = i2 + 1;
        cArr[i2] = cDecodeCharElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        char[] cArr = (char[]) obj;
        CharArrayBuilder charArrayBuilder = new CharArrayBuilder();
        charArrayBuilder.buffer = cArr;
        charArrayBuilder.position = cArr.length;
        charArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return charArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        char[] cArr = (char[]) obj;
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeCharElement(this.descriptor, i2, cArr[i2]);
        }
    }
}
