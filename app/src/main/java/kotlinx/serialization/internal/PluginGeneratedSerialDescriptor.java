package kotlinx.serialization.internal;

import androidx.compose.ui.Modifier;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    public final Object _hashCode$delegate;
    public int added = -1;
    public final Object childSerializers$delegate;
    public final int elementsCount;
    public final boolean[] elementsOptionality;
    public final GeneratedSerializer generatedSerializer;
    public Object indices;
    public final String[] names;
    public final List[] propertiesAnnotations;
    public final String serialName;
    public final Object typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i) {
        this.serialName = str;
        this.generatedSerializer = generatedSerializer;
        this.elementsCount = i;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int i3 = this.elementsCount;
        this.propertiesAnnotations = new List[i3];
        this.elementsOptionality = new boolean[i3];
        this.indices = EmptyMap.INSTANCE;
        final int i4 = 0;
        this.childSerializers$delegate = LazyKt__LazyJVMKt.lazy(2, new Function0(this) { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda1
            public final /* synthetic */ PluginGeneratedSerialDescriptor f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i4) {
                    case 0:
                        GeneratedSerializer generatedSerializer2 = this.f$0.generatedSerializer;
                        return generatedSerializer2 != null ? generatedSerializer2.childSerializers() : Platform_commonKt.EMPTY_SERIALIZER_ARRAY;
                    case 1:
                        return Platform_commonKt.compactArray(this.f$0.generatedSerializer != null ? new ArrayList(0) : null);
                    default:
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f$0;
                        return Integer.valueOf(Platform_commonKt.hashCodeImpl(pluginGeneratedSerialDescriptor, (SerialDescriptor[]) pluginGeneratedSerialDescriptor.typeParameterDescriptors$delegate.getValue()));
                }
            }
        });
        final int i5 = 1;
        this.typeParameterDescriptors$delegate = LazyKt__LazyJVMKt.lazy(2, new Function0(this) { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda1
            public final /* synthetic */ PluginGeneratedSerialDescriptor f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i5) {
                    case 0:
                        GeneratedSerializer generatedSerializer2 = this.f$0.generatedSerializer;
                        return generatedSerializer2 != null ? generatedSerializer2.childSerializers() : Platform_commonKt.EMPTY_SERIALIZER_ARRAY;
                    case 1:
                        return Platform_commonKt.compactArray(this.f$0.generatedSerializer != null ? new ArrayList(0) : null);
                    default:
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f$0;
                        return Integer.valueOf(Platform_commonKt.hashCodeImpl(pluginGeneratedSerialDescriptor, (SerialDescriptor[]) pluginGeneratedSerialDescriptor.typeParameterDescriptors$delegate.getValue()));
                }
            }
        });
        final int i6 = 2;
        this._hashCode$delegate = LazyKt__LazyJVMKt.lazy(2, new Function0(this) { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda1
            public final /* synthetic */ PluginGeneratedSerialDescriptor f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i6) {
                    case 0:
                        GeneratedSerializer generatedSerializer2 = this.f$0.generatedSerializer;
                        return generatedSerializer2 != null ? generatedSerializer2.childSerializers() : Platform_commonKt.EMPTY_SERIALIZER_ARRAY;
                    case 1:
                        return Platform_commonKt.compactArray(this.f$0.generatedSerializer != null ? new ArrayList(0) : null);
                    default:
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f$0;
                        return Integer.valueOf(Platform_commonKt.hashCodeImpl(pluginGeneratedSerialDescriptor, (SerialDescriptor[]) pluginGeneratedSerialDescriptor.typeParameterDescriptors$delegate.getValue()));
                }
            }
        });
    }

    public final void addElement(String str, boolean z) {
        int i = this.added + 1;
        this.added = i;
        String[] strArr = this.names;
        strArr[i] = str;
        this.elementsOptionality[i] = z;
        this.propertiesAnnotations[i] = null;
        if (i == this.elementsCount - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                map.put(strArr[i2], Integer.valueOf(i2));
            }
            this.indices = map;
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlin.Lazy] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual(this.serialName, serialDescriptor.getSerialName()) && Arrays.equals((SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue(), (SerialDescriptor[]) ((PluginGeneratedSerialDescriptor) obj).typeParameterDescriptors$delegate.getValue())) {
                int elementsCount = serialDescriptor.getElementsCount();
                int i = this.elementsCount;
                if (i == elementsCount) {
                    for (int i2 = 0; i2 < i; i2++) {
                        if (Intrinsics.areEqual(getElementDescriptor(i2).getSerialName(), serialDescriptor.getElementDescriptor(i2).getSerialName()) && Intrinsics.areEqual(getElementDescriptor(i2).getKind(), serialDescriptor.getElementDescriptor(i2).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return EmptyList.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getElementAnnotations(int i) {
        List list = this.propertiesAnnotations[i];
        return list == null ? EmptyList.INSTANCE : list;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int i) {
        return ((KSerializer[]) this.childSerializers$delegate.getValue())[i].getDescriptor();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String str) {
        Integer num = (Integer) this.indices.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int i) {
        return this.names[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return StructureKind.MAP.INSTANCE$1;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // kotlinx.serialization.internal.CachedNames
    public final Set getSerialNames() {
        return this.indices.keySet();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    public int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int i) {
        return this.elementsOptionality[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isNullable() {
        return false;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, this.elementsCount), ", ", Modifier.CC.m(new StringBuilder(), this.serialName, '('), ")", new DiskLruCache$$ExternalSyntheticLambda0(23, this), 24);
    }
}
