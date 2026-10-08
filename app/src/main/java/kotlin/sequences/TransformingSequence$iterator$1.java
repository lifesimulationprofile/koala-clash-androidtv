package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TransformingSequence$iterator$1 implements Iterator, KMappedMarker {
    public final Iterator iterator;
    public final /* synthetic */ GeneratorSequence this$0;

    public TransformingSequence$iterator$1(GeneratorSequence generatorSequence) {
        this.this$0 = generatorSequence;
        this.iterator = ((Sequence) generatorSequence.getInitialValue).iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((Function1) this.this$0.getNextValue).invoke(this.iterator.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
