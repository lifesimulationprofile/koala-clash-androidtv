package kotlinx.serialization.internal;

import androidx.compose.ui.Modifier;
import kotlin.SynchronizedLazyImpl;
import kotlin.UIntArray;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexingIterable;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    public final SynchronizedLazyImpl elementDescriptors$delegate;
    public final SerialKind.ENUM kind;

    public EnumDescriptor(String str, int i) {
        super(str, null, i);
        this.kind = SerialKind.ENUM.INSTANCE;
        this.elementDescriptors$delegate = new SynchronizedLazyImpl(new EnumDescriptor$$ExternalSyntheticLambda0(i, str, this));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        return serialDescriptor.getKind() == SerialKind.ENUM.INSTANCE && Intrinsics.areEqual(this.serialName, serialDescriptor.getSerialName()) && Intrinsics.areEqual(Platform_commonKt.cachedSerialNames(this), Platform_commonKt.cachedSerialNames(serialDescriptor));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int i) {
        return ((SerialDescriptor[]) this.elementDescriptors$delegate.getValue())[i];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final int hashCode() {
        int iHashCode = this.serialName.hashCode();
        UIntArray.Iterator iterator = new UIntArray.Iterator(this);
        int iHashCode2 = 1;
        while (iterator.hasNext()) {
            int i = iHashCode2 * 31;
            String str = (String) iterator.next();
            iHashCode2 = i + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final String toString() {
        return CollectionsKt.joinToString$default(new IndexingIterable(2, this), ", ", Modifier.CC.m(new StringBuilder(), this.serialName, '('), ")", null, 56);
    }
}
