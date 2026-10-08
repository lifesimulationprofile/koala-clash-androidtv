package kotlinx.serialization.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import dev.chrisbanes.haze.HazeStyleKt$$ExternalSyntheticLambda0;
import java.util.Arrays;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EnumSerializer implements KSerializer {
    public final /* synthetic */ int $r8$classId;
    public final Object descriptor$delegate;
    public final Object values;

    public EnumSerializer(Unit unit) {
        this.$r8$classId = 1;
        this.values = unit;
        this.descriptor$delegate = LazyKt__LazyJVMKt.lazy(2, new HazeStyleKt$$ExternalSyntheticLambda0(this));
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int iDecodeElementIndex;
        int i = this.$r8$classId;
        Object obj = this.values;
        switch (i) {
            case 0:
                Enum[] enumArr = (Enum[]) obj;
                int iDecodeEnum = decoder.decodeEnum(getDescriptor());
                if (iDecodeEnum >= 0 && iDecodeEnum < enumArr.length) {
                    return enumArr[iDecodeEnum];
                }
                throw new SerializationException(iDecodeEnum + " is not among valid " + getDescriptor().getSerialName() + " enum values, values size is " + enumArr.length);
            default:
                SerialDescriptor descriptor = getDescriptor();
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
                if (!compositeDecoderBeginStructure.decodeSequentially() && (iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor())) != -1) {
                    throw new SerializationException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unexpected index ", iDecodeElementIndex));
                }
                Unit unit = Unit.INSTANCE;
                compositeDecoderBeginStructure.endStructure(descriptor);
                return obj;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        switch (this.$r8$classId) {
            case 0:
                return (SerialDescriptor) ((SynchronizedLazyImpl) this.descriptor$delegate).getValue();
            default:
                return (SerialDescriptor) this.descriptor$delegate.getValue();
        }
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Enum r5 = (Enum) obj;
                Enum[] enumArr = (Enum[]) this.values;
                int iIndexOf = ArraysKt.indexOf(enumArr, r5);
                if (iIndexOf != -1) {
                    encoder.encodeEnum(getDescriptor(), iIndexOf);
                    return;
                }
                throw new SerializationException(r5 + " is not a valid enum " + getDescriptor().getSerialName() + ", must be one of " + Arrays.toString(enumArr));
            default:
                CompositeEncoder compositeEncoderMo810beginStructure = encoder.mo810beginStructure(getDescriptor());
                getDescriptor();
                compositeEncoderMo810beginStructure.endStructure();
                return;
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().getSerialName() + '>';
            default:
                return super.toString();
        }
    }

    public EnumSerializer(String str, Enum[] enumArr) {
        this.$r8$classId = 0;
        this.values = enumArr;
        this.descriptor$delegate = new SynchronizedLazyImpl(new EnumSerializer$$ExternalSyntheticLambda0(0, this, str));
    }
}
