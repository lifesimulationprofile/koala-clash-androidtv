package androidx.compose.runtime;

import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicProvidableCompositionLocal extends ProvidableCompositionLocal {
    public final /* synthetic */ int $r8$classId = 0;
    public final Object policy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicProvidableCompositionLocal(Function0 function0) {
        super(function0);
        NeverEqualPolicy neverEqualPolicy = NeverEqualPolicy.INSTANCE$3;
        this.policy = neverEqualPolicy;
    }

    @Override // androidx.compose.runtime.ProvidableCompositionLocal
    public final ProvidedValue defaultProvidedValue$runtime(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return new ProvidedValue(this, obj, obj == null, (SnapshotMutationPolicy) this.policy, true);
            default:
                return new ProvidedValue(this, obj, obj == null, null, true);
        }
    }

    @Override // androidx.compose.runtime.ProvidableCompositionLocal
    public ValueHolder getDefaultValueHolder$runtime() {
        switch (this.$r8$classId) {
            case 1:
                return (ComputedValueHolder) this.policy;
            default:
                return super.getDefaultValueHolder$runtime();
        }
    }

    public DynamicProvidableCompositionLocal(Function1 function1) {
        super(new ImageLoader$Builder$$ExternalSyntheticLambda2(6));
        this.policy = new ComputedValueHolder(function1);
    }
}
