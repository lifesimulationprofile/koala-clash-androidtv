package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProvidableCompositionLocal {
    public final LazyValueHolder defaultValueHolder;

    public ProvidableCompositionLocal(Function0 function0) {
        this.defaultValueHolder = new LazyValueHolder(function0);
    }

    public abstract ProvidedValue defaultProvidedValue$runtime(Object obj);

    public ValueHolder getDefaultValueHolder$runtime() {
        return this.defaultValueHolder;
    }

    public final ValueHolder updatedStateOf$runtime(ProvidedValue providedValue, ValueHolder valueHolder) {
        DynamicValueHolder dynamicValueHolder;
        ValueHolder valueHolder2 = null;
        valueHolder2 = null;
        valueHolder2 = null;
        valueHolder2 = null;
        valueHolder2 = null;
        valueHolder2 = null;
        if (valueHolder instanceof DynamicValueHolder) {
            if (providedValue.isDynamic) {
                dynamicValueHolder = (DynamicValueHolder) valueHolder;
                dynamicValueHolder.state.setValue(providedValue.getEffectiveValue$runtime());
            }
        } else if (valueHolder instanceof StaticValueHolder) {
            if ((providedValue.explicitNull || providedValue.providedValue != null) && !providedValue.isDynamic) {
                StaticValueHolder staticValueHolder = (StaticValueHolder) valueHolder;
                if (Intrinsics.areEqual(providedValue.getEffectiveValue$runtime(), staticValueHolder.value)) {
                    valueHolder2 = staticValueHolder;
                }
            }
        } else if (valueHolder instanceof ComputedValueHolder) {
            providedValue.getClass();
        }
        if (valueHolder2 != null) {
            valueHolder2 = dynamicValueHolder;
            return valueHolder2;
        }
        if (!providedValue.isDynamic) {
            valueHolder2 = dynamicValueHolder;
            return new StaticValueHolder(providedValue.getEffectiveValue$runtime());
        }
        Object obj = providedValue.providedValue;
        SnapshotMutationPolicy snapshotMutationPolicy = (SnapshotMutationPolicy) providedValue.mutationPolicy;
        if (snapshotMutationPolicy == null) {
            valueHolder2 = dynamicValueHolder;
            snapshotMutationPolicy = NeverEqualPolicy.INSTANCE$3;
        }
        valueHolder2 = dynamicValueHolder;
        return new DynamicValueHolder(new ParcelableSnapshotMutableState(obj, snapshotMutationPolicy));
    }
}
