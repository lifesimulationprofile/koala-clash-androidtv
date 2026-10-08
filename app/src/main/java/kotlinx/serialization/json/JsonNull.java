package kotlinx.serialization.json;

import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class JsonNull extends JsonPrimitive {
    public static final JsonNull INSTANCE = new JsonNull();

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String getContent() {
        return "null";
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final boolean isString() {
        return false;
    }

    public final KSerializer serializer() {
        return JsonNullSerializer.INSTANCE;
    }
}
