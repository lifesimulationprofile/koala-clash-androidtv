package kotlinx.serialization.json;

import androidx.compose.ui.graphics.vector.ImageVector;
import coil.network.HttpException;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind$SEALED;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.modules.ContextualProvider;
import kotlinx.serialization.modules.SerializersModuleKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class JsonKt {
    public static ImageVector _label;

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object, java.util.Map] */
    public static JsonImpl Json$default(Function1 function1) {
        Json.Default r0 = Json.Default;
        JsonBuilder jsonBuilder = new JsonBuilder();
        JsonConfiguration jsonConfiguration = r0.configuration;
        boolean z = jsonConfiguration.explicitNulls;
        jsonBuilder.ignoreUnknownKeys = jsonConfiguration.ignoreUnknownKeys;
        String str = jsonConfiguration.prettyPrintIndent;
        String str2 = jsonConfiguration.classDiscriminator;
        int i = jsonConfiguration.classDiscriminatorMode;
        boolean z2 = jsonConfiguration.useAlternativeNames;
        Request request = r0.serializersModule;
        function1.invoke(jsonBuilder);
        if (!Intrinsics.areEqual(str, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        JsonImpl jsonImpl = new JsonImpl(new JsonConfiguration(jsonBuilder.ignoreUnknownKeys, z, str, str2, z2, i), request);
        if (!Intrinsics.areEqual(request, SerializersModuleKt.EmptySerializersModule)) {
            for (Map.Entry entry : request.url.entrySet()) {
                ContextualProvider contextualProvider = (ContextualProvider) entry.getValue();
                if (!(contextualProvider instanceof ContextualProvider.Argless) && !(contextualProvider instanceof ContextualProvider.WithTypeArguments)) {
                    throw new HttpException();
                }
            }
            for (Map.Entry entry2 : request.method.entrySet()) {
                for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                    KClass kClass = (KClass) entry3.getKey();
                    SerialDescriptor descriptor = ((KSerializer) entry3.getValue()).getDescriptor();
                    SerialKind kind = descriptor.getKind();
                    if ((kind instanceof PolymorphicKind$SEALED) || Intrinsics.areEqual(kind, SerialKind.CONTEXTUAL.INSTANCE)) {
                        throw new IllegalArgumentException("Serializer for " + ((ClassReference) kClass).getSimpleName() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
                    }
                    if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE$2) || Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE) || (kind instanceof PrimitiveKind) || (kind instanceof SerialKind.ENUM)) {
                        throw new IllegalArgumentException("Serializer for " + ((ClassReference) kClass).getSimpleName() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
                    }
                    int elementsCount = descriptor.getElementsCount();
                    for (int i2 = 0; i2 < elementsCount; i2++) {
                        String elementName = descriptor.getElementName(i2);
                        if (Intrinsics.areEqual(elementName, str2)) {
                            throw new IllegalArgumentException("Polymorphic serializer for " + kClass + " has property '" + elementName + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
                        }
                    }
                }
            }
            for (Map.Entry entry4 : request.headers.entrySet()) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, (Function1) entry4.getValue());
            }
            for (Map.Entry entry5 : request.lazyCacheControl.entrySet()) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, (Function1) entry5.getValue());
            }
        }
        return jsonImpl;
    }
}
