package dev.chrisbanes.haze;

import androidx.collection.LruCache;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonLiteralSerializer;
import kotlinx.serialization.json.JsonNullSerializer;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.json.JsonPrimitiveSerializer;
import okhttp3.OkHttpClient;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HazeStyleKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ HazeStyleKt$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                float f = HazeDefaults.blurRadius;
                long j = Color.Unspecified;
                return new HazeStyle(j, new HazeTint(j != 16 ? BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), Color.m436getAlphaimpl(j) * 0.7f, Color.m438getColorSpaceimpl(j)) : j), HazeDefaults.blurRadius, 16);
            case 1:
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder.connectTimeout = Util.checkDuration();
                builder.readTimeout = Util.checkDuration();
                return new OkHttpClient(builder);
            case 2:
                return new HazeArea();
            case 3:
                return new LruCache(50);
            case 4:
                StructureKind.MAP map = StructureKind.MAP.INSTANCE$3;
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[0];
                if (StringsKt.isBlank("kotlin.Unit")) {
                    throw new IllegalArgumentException("Blank serial names are prohibited");
                }
                if (map.equals(StructureKind.MAP.INSTANCE$1)) {
                    throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
                }
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder("kotlin.Unit");
                Unit unit = Unit.INSTANCE;
                return new SerialDescriptorImpl("kotlin.Unit", map, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
            case 5:
                return JsonPrimitiveSerializer.descriptor;
            case 6:
                return JsonNullSerializer.descriptor;
            case 7:
                return JsonLiteralSerializer.descriptor;
            case 8:
                return JsonObjectSerializer.descriptor;
            default:
                return JsonArraySerializer.descriptor;
        }
    }

    public /* synthetic */ HazeStyleKt$$ExternalSyntheticLambda0(EnumSerializer enumSerializer) {
        this.$r8$classId = 4;
    }
}
