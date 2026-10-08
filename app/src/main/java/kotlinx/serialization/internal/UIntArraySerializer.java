package kotlinx.serialization.internal;

import kotlin.UIntArray;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UIntArraySerializer extends PrimitiveArraySerializer {
    public static final UIntArraySerializer INSTANCE = new UIntArraySerializer(UIntSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        return ((UIntArray) obj).storage.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new UIntArray(new int[0]);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        UIntArrayBuilder uIntArrayBuilder = (UIntArrayBuilder) obj;
        int iDecodeInt = compositeDecoder.decodeInlineElement(this.descriptor, i).decodeInt();
        uIntArrayBuilder.ensureCapacity$kotlinx_serialization_core(uIntArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        int[] iArr = uIntArrayBuilder.buffer;
        int i2 = uIntArrayBuilder.position;
        uIntArrayBuilder.position = i2 + 1;
        iArr[i2] = iDecodeInt;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        int[] iArr = ((UIntArray) obj).storage;
        UIntArrayBuilder uIntArrayBuilder = new UIntArrayBuilder();
        uIntArrayBuilder.buffer = iArr;
        uIntArrayBuilder.position = iArr.length;
        uIntArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return uIntArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        int[] iArr = ((UIntArray) obj).storage;
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeInlineElement(this.descriptor, i2).encodeInt(iArr[i2]);
        }
    }
}
