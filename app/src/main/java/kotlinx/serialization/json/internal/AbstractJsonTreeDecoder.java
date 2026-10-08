package kotlinx.serialization.json.internal;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.room.DatabaseConfiguration;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PolymorphicKind$SEALED;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractJsonTreeDecoder implements JsonDecoder, Decoder, CompositeDecoder {
    public final JsonConfiguration configuration;
    public boolean flag;
    public final Json json;
    public final String polymorphicDiscriminator;
    public final ArrayList tagStack = new ArrayList();

    public AbstractJsonTreeDecoder(Json json, String str) {
        this.json = json;
        this.polymorphicDiscriminator = str;
        this.configuration = json.configuration;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        JsonElement jsonElementCurrentObject = currentObject();
        SerialKind kind = serialDescriptor.getKind();
        boolean zAreEqual = Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE$2);
        Json json = this.json;
        if (zAreEqual || (kind instanceof PolymorphicKind$SEALED)) {
            String serialName = serialDescriptor.getSerialName();
            if (jsonElementCurrentObject instanceof JsonArray) {
                return new JsonTreeListDecoder(json, (JsonArray) jsonElementCurrentObject);
            }
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentObject.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack());
        }
        if (!Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            String serialName2 = serialDescriptor.getSerialName();
            if (jsonElementCurrentObject instanceof JsonObject) {
                return new JsonTreeDecoder(json, (JsonObject) jsonElementCurrentObject, this.polymorphicDiscriminator, 8);
            }
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentObject.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName2 + " at element: " + renderTagStack());
        }
        SerialDescriptor serialDescriptorCarrierDescriptor = WriteModeKt.carrierDescriptor(serialDescriptor.getElementDescriptor(0), json.serializersModule);
        SerialKind kind2 = serialDescriptorCarrierDescriptor.getKind();
        if (!(kind2 instanceof PrimitiveKind) && !Intrinsics.areEqual(kind2, SerialKind.ENUM.INSTANCE)) {
            throw WriteModeKt.InvalidKeyKindException(serialDescriptorCarrierDescriptor);
        }
        String serialName3 = serialDescriptor.getSerialName();
        if (jsonElementCurrentObject instanceof JsonObject) {
            return new JsonTreeMapDecoder(json, (JsonObject) jsonElementCurrentObject);
        }
        throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentObject.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName3 + " at element: " + renderTagStack());
    }

    public abstract JsonElement currentElement(String str);

    public final JsonElement currentObject() {
        JsonElement jsonElementCurrentElement;
        String str = (String) CollectionsKt.lastOrNull(this.tagStack);
        return (str == null || (jsonElementCurrentElement = currentElement(str)) == null) ? getValue() : jsonElementCurrentElement;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedBoolean(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return decodeTaggedByte(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeTaggedByte(getTag(primitiveArrayDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return decodeTaggedChar(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeTaggedChar(getTag(primitiveArrayDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeCollectionSize() {
        return -1;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return decodeTaggedDouble(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeTaggedDouble(getTag(primitiveArrayDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor serialDescriptor) {
        String str = (String) popTag();
        JsonElement jsonElementCurrentElement = currentElement(str);
        String serialName = serialDescriptor.getSerialName();
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            return WriteModeKt.getJsonNameIndexOrThrow(serialDescriptor, this.json, ((JsonPrimitive) jsonElementCurrentElement).getContent(), "");
        }
        throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack(str));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return decodeTaggedFloat(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeTaggedFloat(getTag(primitiveArrayDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Decoder decodeInline(SerialDescriptor serialDescriptor) {
        if (CollectionsKt.lastOrNull(this.tagStack) != null) {
            return decodeTaggedInline(popTag(), serialDescriptor);
        }
        return new JsonPrimitiveDecoder(this.json, getValue(), this.polymorphicDiscriminator).decodeInline(serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder decodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeTaggedInline(getTag(primitiveArrayDescriptor, i), primitiveArrayDescriptor.getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return decodeTaggedInt(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedInt(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement decodeJsonElement() {
        return currentObject();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return decodeTaggedLong(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedLong(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, String str) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        String tag = getTag(serialDescriptor, i);
        StringSerializer stringSerializer2 = StringSerializer.INSTANCE;
        this.tagStack.add(tag);
        StringSerializer stringSerializer3 = StringSerializer.INSTANCE;
        StringSerializer stringSerializer4 = StringSerializer.INSTANCE;
        Object objDecodeSerializableValue = decodeNotNullMark() ? decodeSerializableValue(stringSerializer3) : null;
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return objDecodeSerializableValue;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeSequentially() {
        return false;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        this.tagStack.add(getTag(serialDescriptor, i));
        Object objDecodeSerializableValue = decodeSerializableValue(kSerializer);
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return objDecodeSerializableValue;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Object decodeSerializableValue(KSerializer kSerializer) {
        if (!(kSerializer instanceof PolymorphicSerializer)) {
            return kSerializer.deserialize(this);
        }
        Json json = this.json;
        JsonConfiguration jsonConfiguration = json.configuration;
        PolymorphicSerializer polymorphicSerializer = (PolymorphicSerializer) kSerializer;
        String strClassDiscriminator = WriteModeKt.classDiscriminator(polymorphicSerializer.getDescriptor(), json);
        JsonElement jsonElementCurrentObject = currentObject();
        String serialName = polymorphicSerializer.getDescriptor().getSerialName();
        if (!(jsonElementCurrentObject instanceof JsonObject)) {
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentObject.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack());
        }
        JsonObject jsonObject = (JsonObject) jsonElementCurrentObject;
        JsonElement jsonElement = (JsonElement) jsonObject.get(strClassDiscriminator);
        String content = null;
        if (jsonElement != null) {
            JsonPrimitive jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement);
            if (!(jsonPrimitive instanceof JsonNull)) {
                content = jsonPrimitive.getContent();
            }
        }
        try {
            KSerializer kSerializerFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((PolymorphicSerializer) kSerializer, this, content);
            return new JsonTreeDecoder(json, jsonObject, strClassDiscriminator, kSerializerFindPolymorphicSerializer.getDescriptor()).decodeSerializableValue(kSerializerFindPolymorphicSerializer);
        } catch (SerializationException e) {
            throw WriteModeKt.JsonDecodingException(-1, jsonObject.toString(), e.getMessage());
        }
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return decodeTaggedShort(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeTaggedShort(getTag(primitiveArrayDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return decodeTaggedString(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String decodeStringElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedString(getTag(serialDescriptor, i));
    }

    public final boolean decodeTaggedBoolean(Object obj) {
        Boolean bool;
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of boolean at element: " + renderTagStack(str));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            String content = jsonPrimitive.getContent();
            String[] strArr = StringOpsKt.ESCAPE_STRINGS;
            if (content.equalsIgnoreCase("true")) {
                bool = Boolean.TRUE;
            } else {
                bool = content.equalsIgnoreCase("false") ? Boolean.FALSE : null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            unparsedPrimitive(jsonPrimitive, "boolean", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "boolean", str);
            throw null;
        }
    }

    public final byte decodeTaggedByte(Object obj) {
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of byte at element: " + renderTagStack(str));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            int i = JsonElementKt.getInt(jsonPrimitive);
            Byte bValueOf = (-128 > i || i > 127) ? null : Byte.valueOf((byte) i);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            unparsedPrimitive(jsonPrimitive, "byte", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "byte", str);
            throw null;
        }
    }

    public final char decodeTaggedChar(Object obj) {
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of char at element: " + renderTagStack(str));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            String content = jsonPrimitive.getContent();
            int length = content.length();
            if (length == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            }
            if (length == 1) {
                return content.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "char", str);
            throw null;
        }
    }

    public final double decodeTaggedDouble(Object obj) {
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of double at element: " + renderTagStack(str));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            double d = Double.parseDouble(jsonPrimitive.getContent());
            JsonConfiguration jsonConfiguration = this.json.configuration;
            if (Double.isInfinite(d) || Double.isNaN(d)) {
                throw WriteModeKt.InvalidFloatingPointDecoded(Double.valueOf(d), str, currentObject().toString());
            }
            return d;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "double", str);
            throw null;
        }
    }

    public final float decodeTaggedFloat(Object obj) {
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of float at element: " + renderTagStack(str));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            float f = Float.parseFloat(jsonPrimitive.getContent());
            JsonConfiguration jsonConfiguration = this.json.configuration;
            if (Float.isInfinite(f) || Float.isNaN(f)) {
                throw WriteModeKt.InvalidFloatingPointDecoded(Float.valueOf(f), str, currentObject().toString());
            }
            return f;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "float", str);
            throw null;
        }
    }

    public final Decoder decodeTaggedInline(Object obj, SerialDescriptor serialDescriptor) {
        String str = (String) obj;
        if (!StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            this.tagStack.add(str);
            return this;
        }
        JsonElement jsonElementCurrentElement = currentElement(str);
        String serialName = serialDescriptor.getSerialName();
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            String content = ((JsonPrimitive) jsonElementCurrentElement).getContent();
            Json json = this.json;
            JsonConfiguration jsonConfiguration = json.configuration;
            return new JsonDecoderForUnsignedTypes(new DatabaseConfiguration(content), json);
        }
        throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack(str));
    }

    public final int decodeTaggedInt(Object obj) {
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
            try {
                return JsonElementKt.getInt(jsonPrimitive);
            } catch (IllegalArgumentException unused) {
                unparsedPrimitive(jsonPrimitive, "int", str);
                throw null;
            }
        }
        throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of int at element: " + renderTagStack(str));
    }

    public final long decodeTaggedLong(Object obj) {
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
            try {
                InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
                try {
                    return new DatabaseConfiguration(jsonPrimitive.getContent()).consumeNumericLiteral();
                } catch (JsonDecodingException e) {
                    throw new NumberFormatException(e.getMessage());
                }
            } catch (IllegalArgumentException unused) {
                unparsedPrimitive(jsonPrimitive, "long", str);
                throw null;
            }
        }
        throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of long at element: " + renderTagStack(str));
    }

    public final short decodeTaggedShort(Object obj) {
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of short at element: " + renderTagStack(str));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            int i = JsonElementKt.getInt(jsonPrimitive);
            Short shValueOf = (-32768 > i || i > 32767) ? null : Short.valueOf((short) i);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            unparsedPrimitive(jsonPrimitive, "short", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "short", str);
            throw null;
        }
    }

    public final String decodeTaggedString(Object obj) {
        String str = (String) obj;
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of string at element: " + renderTagStack(str));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        if (!(jsonPrimitive instanceof JsonLiteral)) {
            StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Expected string value for a non-null key '", str, "', got null literal instead at element: ");
            sbM16m.append(renderTagStack(str));
            throw WriteModeKt.JsonDecodingException(-1, currentObject().toString(), sbM16m.toString());
        }
        JsonLiteral jsonLiteral = (JsonLiteral) jsonPrimitive;
        if (jsonLiteral.isString) {
            return jsonLiteral.content;
        }
        JsonConfiguration jsonConfiguration = this.json.configuration;
        StringBuilder sbM16m2 = ImageAnalysis$$ExternalSyntheticLambda1.m16m("String literal for key '", str, "' should be quoted at element: ");
        sbM16m2.append(renderTagStack(str));
        sbM16m2.append(".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.");
        throw WriteModeKt.JsonDecodingException(-1, currentObject().toString(), sbM16m2.toString());
    }

    public String elementName(SerialDescriptor serialDescriptor, int i) {
        return serialDescriptor.getElementName(i);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder, kotlinx.serialization.encoding.Encoder
    public final Request getSerializersModule() {
        return this.json.serializersModule;
    }

    public final String getTag(SerialDescriptor serialDescriptor, int i) {
        String strElementName = elementName(serialDescriptor, i);
        return strElementName;
    }

    public abstract JsonElement getValue();

    public final Object popTag() {
        ArrayList arrayList = this.tagStack;
        Object objRemove = arrayList.remove(AppCompatHintHelper.getLastIndex(arrayList));
        this.flag = true;
        return objRemove;
    }

    public final String renderTagStack(String str) {
        return renderTagStack() + '.' + str;
    }

    public final void unparsedPrimitive(JsonPrimitive jsonPrimitive, String str, String str2) {
        throw WriteModeKt.JsonDecodingException(-1, currentObject().toString(), "Failed to parse literal '" + jsonPrimitive + "' as " + (StringsKt__StringsJVMKt.startsWith(str, "i", false) ? "an " : "a ").concat(str) + " value at element: " + renderTagStack(str2));
    }

    public final String renderTagStack() {
        ArrayList arrayList = this.tagStack;
        return arrayList.isEmpty() ? "$" : CollectionsKt.joinToString$default(arrayList, ".", "$.", null, null, 60);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor serialDescriptor) {
    }
}
