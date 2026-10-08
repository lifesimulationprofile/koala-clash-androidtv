package kotlinx.serialization.modules;

import kotlin.collections.EmptyMap;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SerializersModuleKt {
    public static final Request EmptySerializersModule;

    static {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        EmptySerializersModule = new Request(emptyMap, emptyMap, emptyMap, emptyMap, emptyMap, 16);
    }
}
