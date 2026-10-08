package kotlin.sequences;

import androidx.camera.core.impl.utils.MatrixExt;
import androidx.collection.MutableOrderedSetWrapper;
import androidx.collection.MutableOrderedSetWrapper$iterator$1$iterator$1;
import androidx.collection.MutableSetWrapper;
import androidx.collection.MutableSetWrapper$iterator$1$iterator$1;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Function;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GeneratorSequence implements Sequence {
    public final /* synthetic */ int $r8$classId;
    public final Object getInitialValue;
    public final Function getNextValue;

    public /* synthetic */ GeneratorSequence(Object obj, Function1 function1, int i) {
        this.$r8$classId = i;
        this.getInitialValue = obj;
        this.getNextValue = function1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new AnonymousClass1(this);
            case 1:
                return new FileTreeWalk.FileTreeWalkIterator(this);
            case 2:
                return new FileTreeWalk.FileTreeWalkIterator(this, (byte) 0);
            default:
                return new TransformingSequence$iterator$1(this);
        }
    }

    /* JADX INFO: renamed from: kotlin.sequences.GeneratorSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class AnonymousClass1 implements Iterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId;
        public Object nextItem;
        public int nextState;
        public final Object this$0;

        public AnonymousClass1(Object obj, Map map) {
            this.$r8$classId = 3;
            this.nextItem = obj;
            this.this$0 = map;
        }

        public void calcNext$1() {
            GeneratorSequence generatorSequence = (GeneratorSequence) this.this$0;
            Object objInvoke = this.nextState == -2 ? ((Function0) generatorSequence.getInitialValue).invoke() : ((Function1) generatorSequence.getNextValue).invoke(this.nextItem);
            this.nextItem = objInvoke;
            this.nextState = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    if (this.nextState < 0) {
                        calcNext$1();
                    }
                    return this.nextState == 1;
                case 1:
                    return ((SequenceBuilderIterator) this.nextItem).hasNext();
                case 2:
                    return ((SequenceBuilderIterator) this.nextItem).hasNext();
                default:
                    return this.nextState < ((Map) this.this$0).size();
            }
        }

        @Override // java.util.Iterator
        public Object next() {
            switch (this.$r8$classId) {
                case 0:
                    if (this.nextState < 0) {
                        calcNext$1();
                    }
                    if (this.nextState == 0) {
                        throw new NoSuchElementException();
                    }
                    Object obj = this.nextItem;
                    this.nextState = -1;
                    return obj;
                case 1:
                    return ((SequenceBuilderIterator) this.nextItem).next();
                case 2:
                    return ((SequenceBuilderIterator) this.nextItem).next();
                default:
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object obj2 = this.nextItem;
                    this.nextState++;
                    Object obj3 = ((Map) this.this$0).get(obj2);
                    if (obj3 != null) {
                        this.nextItem = ((Links) obj3).next;
                        return obj2;
                    }
                    throw new ConcurrentModificationException("Hash code of an element (" + obj2 + ") has changed after it was added to the persistent set.");
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 1:
                    int i = this.nextState;
                    if (i != -1) {
                        ((MutableOrderedSetWrapper) this.this$0).parent.removeElementAt(i);
                        this.nextState = -1;
                        return;
                    }
                    return;
                case 2:
                    int i2 = this.nextState;
                    if (i2 != -1) {
                        ((MutableSetWrapper) this.this$0).parent.removeElementAt(i2);
                        this.nextState = -1;
                        return;
                    }
                    return;
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        public AnonymousClass1(GeneratorSequence generatorSequence) {
            this.$r8$classId = 0;
            this.this$0 = generatorSequence;
            this.nextState = -2;
        }

        public AnonymousClass1(MutableSetWrapper mutableSetWrapper) {
            this.$r8$classId = 2;
            this.this$0 = mutableSetWrapper;
            this.nextState = -1;
            this.nextItem = MatrixExt.iterator(new MutableSetWrapper$iterator$1$iterator$1(mutableSetWrapper, this, null));
        }

        public AnonymousClass1(MutableOrderedSetWrapper mutableOrderedSetWrapper) {
            this.$r8$classId = 1;
            this.this$0 = mutableOrderedSetWrapper;
            this.nextState = -1;
            this.nextItem = MatrixExt.iterator(new MutableOrderedSetWrapper$iterator$1$iterator$1(mutableOrderedSetWrapper, this, null));
        }
    }

    public GeneratorSequence(FilteringSequence filteringSequence, Function1 function1) {
        this.$r8$classId = 1;
        int i = SequencesKt___SequencesKt$flatMap$2.$r8$clinit;
        this.getInitialValue = filteringSequence;
        this.getNextValue = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GeneratorSequence(Sequence sequence, Function1 function1) {
        this.$r8$classId = 2;
        this.getInitialValue = sequence;
        this.getNextValue = (Lambda) function1;
    }
}
