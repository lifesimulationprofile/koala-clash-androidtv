package kotlinx.serialization.json.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.PolymorphicKind$SEALED;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.EnumSerializer$$ExternalSyntheticLambda0;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    public boolean forceNull;
    public final SerialDescriptor polyDescriptor;
    public int position;
    public final JsonObject value;

    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, int i) {
        this(json, jsonObject, (i & 4) != 0 ? null : str, (SerialDescriptor) null);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        SerialDescriptor serialDescriptor2 = this.polyDescriptor;
        if (serialDescriptor != serialDescriptor2) {
            return super.beginStructure(serialDescriptor);
        }
        JsonElement jsonElementCurrentObject = currentObject();
        String serialName = serialDescriptor2.getSerialName();
        if (jsonElementCurrentObject instanceof JsonObject) {
            return new JsonTreeDecoder(this.json, (JsonObject) jsonElementCurrentObject, this.polymorphicDiscriminator, serialDescriptor2);
        }
        throw WriteModeKt.JsonDecodingException(-1, jsonElementCurrentObject.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack());
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement currentElement(String str) {
        return (JsonElement) MapsKt__MapsKt.getValue(str, getValue());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        while (this.position < serialDescriptor.getElementsCount()) {
            int i = this.position;
            this.position = i + 1;
            String tag = getTag(serialDescriptor, i);
            int i2 = this.position - 1;
            this.forceNull = false;
            if (!getValue().containsKey(tag)) {
                boolean z = (this.json.configuration.explicitNulls || serialDescriptor.isElementOptional(i2) || !serialDescriptor.getElementDescriptor(i2).isNullable()) ? false : true;
                this.forceNull = z;
                if (z) {
                }
            }
            this.configuration.getClass();
            return i2;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public String elementName(SerialDescriptor serialDescriptor, int i) {
        Json json = this.json;
        WriteModeKt.namingStrategy(serialDescriptor, json);
        String elementName = serialDescriptor.getElementName(i);
        if (this.configuration.useAlternativeNames && !getValue().content.keySet().contains(elementName)) {
            ConnectionPool connectionPool = json._schemaCache;
            EnumSerializer$$ExternalSyntheticLambda0 enumSerializer$$ExternalSyntheticLambda0 = new EnumSerializer$$ExternalSyntheticLambda0(1, serialDescriptor, json);
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) connectionPool.delegate;
            Map map = (Map) concurrentHashMap.get(serialDescriptor);
            Object obj = null;
            JsonPath$Tombstone jsonPath$Tombstone = WriteModeKt.JsonDeserializationNamesKey;
            Object objInvoke = map != null ? map.get(jsonPath$Tombstone) : null;
            if (objInvoke == null) {
                objInvoke = null;
            }
            if (objInvoke == null) {
                objInvoke = enumSerializer$$ExternalSyntheticLambda0.invoke();
                Object concurrentHashMap2 = concurrentHashMap.get(serialDescriptor);
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap(2);
                    concurrentHashMap.put(serialDescriptor, concurrentHashMap2);
                }
                ((Map) concurrentHashMap2).put(jsonPath$Tombstone, objInvoke);
            }
            Map map2 = (Map) objInvoke;
            for (Object obj2 : getValue().content.keySet()) {
                Integer num = (Integer) map2.get((String) obj2);
                if (num != null && num.intValue() == i) {
                    obj = obj2;
                    break;
                }
            }
            String str = (String) obj;
            if (str != null) {
                return str;
            }
        }
        return elementName;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor serialDescriptor) {
        Set setPlus;
        JsonConfiguration jsonConfiguration = this.configuration;
        if (jsonConfiguration.ignoreUnknownKeys || (serialDescriptor.getKind() instanceof PolymorphicKind$SEALED)) {
            return;
        }
        Json json = this.json;
        WriteModeKt.namingStrategy(serialDescriptor, json);
        if (jsonConfiguration.useAlternativeNames) {
            Set setCachedSerialNames = Platform_commonKt.cachedSerialNames(serialDescriptor);
            Map map = (Map) ((ConcurrentHashMap) json._schemaCache.delegate).get(serialDescriptor);
            Object obj = map != null ? map.get(WriteModeKt.JsonDeserializationNamesKey) : null;
            if (obj == null) {
                obj = null;
            }
            Map map2 = (Map) obj;
            Set setKeySet = map2 != null ? map2.keySet() : null;
            if (setKeySet == null) {
                setKeySet = EmptySet.INSTANCE;
            }
            setPlus = SetsKt.plus(setCachedSerialNames, (Iterable) setKeySet);
        } else {
            setPlus = Platform_commonKt.cachedSerialNames(serialDescriptor);
        }
        for (String str : getValue().content.keySet()) {
            if (!setPlus.contains(str) && !Intrinsics.areEqual(str, this.polymorphicDiscriminator)) {
                String string = getValue().toString();
                StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Encountered an unknown key '", str, "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: ");
                sbM16m.append((Object) WriteModeKt.minify(string, -1));
                throw WriteModeKt.JsonDecodingException(sbM16m.toString(), -1);
            }
        }
    }

    public JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor) {
        super(json, str);
        this.value = jsonObject;
        this.polyDescriptor = serialDescriptor;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonObject getValue() {
        return this.value;
    }
}
