package kotlinx.serialization.internal;

import kotlin.UByteArray;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UByteArraySerializer extends PrimitiveArraySerializer {
    public static final UByteArraySerializer INSTANCE = new UByteArraySerializer(UByteSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        return ((UByteArray) obj).storage.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new UByteArray(new byte[0]);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        UByteArrayBuilder uByteArrayBuilder = (UByteArrayBuilder) obj;
        byte bDecodeByte = compositeDecoder.decodeInlineElement(this.descriptor, i).decodeByte();
        uByteArrayBuilder.ensureCapacity$kotlinx_serialization_core(uByteArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        byte[] bArr = uByteArrayBuilder.buffer;
        int i2 = uByteArrayBuilder.position;
        uByteArrayBuilder.position = i2 + 1;
        bArr[i2] = bDecodeByte;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        byte[] bArr = ((UByteArray) obj).storage;
        UByteArrayBuilder uByteArrayBuilder = new UByteArrayBuilder();
        uByteArrayBuilder.buffer = bArr;
        uByteArrayBuilder.position = bArr.length;
        uByteArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return uByteArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        byte[] bArr = ((UByteArray) obj).storage;
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeInlineElement(this.descriptor, i2).encodeByte(bArr[i2]);
        }
    }
}
