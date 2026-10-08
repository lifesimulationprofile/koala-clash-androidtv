package kotlinx.serialization.descriptors;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.unit.Constraints;
import androidx.emoji2.text.flatbuffer.Table;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.MapBuilderValues;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.PrimitivesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SerialDescriptorsKt {
    public static final PrimitiveSerialDescriptor PrimitiveSerialDescriptor(String str, PrimitiveKind primitiveKind) {
        if (StringsKt.isBlank(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        Object it = ((MapBuilderValues) PrimitivesKt.BUILTIN_SERIALIZERS.values()).iterator();
        while (((Table) it).hasNext()) {
            KSerializer kSerializer = (KSerializer) ((MapBuilder.KeysItr) it).next();
            if (str.equals(kSerializer.getDescriptor().getSerialName())) {
                StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exists ");
                sbM16m.append(Reflection.getOrCreateKotlinClass(kSerializer.getClass()).getSimpleName());
                sbM16m.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                throw new IllegalArgumentException(StringsKt__IndentKt.trimIndent(sbM16m.toString()));
            }
        }
        return new PrimitiveSerialDescriptor(str, primitiveKind);
    }

    public static SerialDescriptorImpl buildSerialDescriptor$default(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr) {
        if (StringsKt.isBlank(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (serialKind.equals(StructureKind.MAP.INSTANCE$1)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
        Unit unit = Unit.INSTANCE;
        return new SerialDescriptorImpl(str, serialKind, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
    }

    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m847finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        int iM683getMaxWidthimpl = ((z || i == 2 || i == 4 || i == 5) && Constraints.m679getHasBoundedWidthimpl(j)) ? Constraints.m683getMaxWidthimpl(j) : Integer.MAX_VALUE;
        if (Constraints.m685getMinWidthimpl(j) != iM683getMaxWidthimpl) {
            iM683getMaxWidthimpl = RangesKt.coerceIn(BasicTextKt.ceilToIntPx(f), Constraints.m685getMinWidthimpl(j), iM683getMaxWidthimpl);
        }
        return Constraints.Companion.m688fitPrioritizingWidthZbe2FdA(0, iM683getMaxWidthimpl, 0, Constraints.m682getMaxHeightimpl(j));
    }
}
