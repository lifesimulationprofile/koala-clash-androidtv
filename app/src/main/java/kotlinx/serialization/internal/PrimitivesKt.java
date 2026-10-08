package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.uuid.Uuid;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PrimitivesKt {
    public static final MapBuilder BUILTIN_SERIALIZERS;

    static {
        MapBuilder mapBuilder = new MapBuilder(8);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Character.TYPE), CharSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(char[].class), CharArraySerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Double.TYPE), DoubleSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(double[].class), DoubleArraySerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Float.TYPE), FloatSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(float[].class), FloatArraySerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Long.TYPE), LongSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(long[].class), LongArraySerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(ULong.class), ULongSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Integer.TYPE), IntSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(int[].class), IntArraySerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(UInt.class), UIntSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Short.TYPE), ShortSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(short[].class), ShortArraySerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(UShort.class), UShortSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Byte.TYPE), ByteSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(byte[].class), ByteArraySerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(UByte.class), UByteSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Boolean.TYPE), BooleanSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(boolean[].class), BooleanArraySerializer.INSTANCE);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        Unit unit = Unit.INSTANCE;
        mapBuilder.put(orCreateKotlinClass, UnitSerializer.INSTANCE);
        mapBuilder.put(Reflection.getOrCreateKotlinClass(Void.class), NothingSerializer.INSTANCE);
        try {
            ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Duration.class);
            int i = Duration.$r8$clinit;
            mapBuilder.put(orCreateKotlinClass2, DurationSerializer.INSTANCE);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            mapBuilder.put(Reflection.getOrCreateKotlinClass(ULongArray.class), ULongArraySerializer.INSTANCE);
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            mapBuilder.put(Reflection.getOrCreateKotlinClass(UIntArray.class), UIntArraySerializer.INSTANCE);
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            mapBuilder.put(Reflection.getOrCreateKotlinClass(UShortArray.class), UShortArraySerializer.INSTANCE);
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            mapBuilder.put(Reflection.getOrCreateKotlinClass(UByteArray.class), UByteArraySerializer.INSTANCE);
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            mapBuilder.put(Reflection.getOrCreateKotlinClass(Uuid.class), UuidSerializer.INSTANCE);
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        BUILTIN_SERIALIZERS = MapsKt__MapsKt.build(mapBuilder);
    }
}
