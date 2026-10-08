package kotlinx.serialization.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DurationSerializer implements KSerializer {
    public static final DurationSerializer INSTANCE = new DurationSerializer();
    public static final PrimitiveSerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind.INT.INSTANCE$8);

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int i = Duration.$r8$clinit;
        String strDecodeString = decoder.decodeString();
        try {
            return new Duration(DurationKt.access$parseDuration(strDecodeString));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Invalid ISO duration string format: '", strDecodeString, "'."), e);
        }
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        long j = ((Duration) obj).rawValue;
        int i = Duration.$r8$clinit;
        StringBuilder sb = new StringBuilder();
        if (j < 0) {
            sb.append('-');
        }
        sb.append("PT");
        long jM839unaryMinusUwyO8pc = j < 0 ? Duration.m839unaryMinusUwyO8pc(j) : j;
        long jM838toLongimpl = Duration.m838toLongimpl(jM839unaryMinusUwyO8pc, DurationUnit.HOURS);
        boolean z = false;
        int iM838toLongimpl = Duration.m836isInfiniteimpl(jM839unaryMinusUwyO8pc) ? 0 : (int) (Duration.m838toLongimpl(jM839unaryMinusUwyO8pc, DurationUnit.MINUTES) % ((long) 60));
        int iM838toLongimpl2 = Duration.m836isInfiniteimpl(jM839unaryMinusUwyO8pc) ? 0 : (int) (Duration.m838toLongimpl(jM839unaryMinusUwyO8pc, DurationUnit.SECONDS) % ((long) 60));
        int iM835getNanosecondsComponentimpl = Duration.m835getNanosecondsComponentimpl(jM839unaryMinusUwyO8pc);
        if (Duration.m836isInfiniteimpl(j)) {
            jM838toLongimpl = 9999999999999L;
        }
        boolean z2 = jM838toLongimpl != 0;
        boolean z3 = (iM838toLongimpl2 == 0 && iM835getNanosecondsComponentimpl == 0) ? false : true;
        if (iM838toLongimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(jM838toLongimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(iM838toLongimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            Duration.m834appendFractionalimpl(sb, iM838toLongimpl2, iM835getNanosecondsComponentimpl, 9, "S", true);
        }
        encoder.encodeString(sb.toString());
    }
}
