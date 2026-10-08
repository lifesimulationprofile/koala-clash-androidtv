package kotlin.collections;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SubList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.text.MatcherMatchResult;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ReversedListReadOnly extends AbstractList {
    public final /* synthetic */ int $r8$classId;
    public final Object delegate;

    public /* synthetic */ ReversedListReadOnly(int i, Object obj) {
        this.$r8$classId = i;
        this.delegate = obj;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        switch (this.$r8$classId) {
            case 0:
                List list = (List) this.delegate;
                if (i >= 0 && i <= AppCompatHintHelper.getLastIndex(this)) {
                    return list.get(AppCompatHintHelper.getLastIndex(this) - i);
                }
                StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Element index ", " must be in range [");
                sbM.append(new IntRange(0, AppCompatHintHelper.getLastIndex(this), 1));
                sbM.append("].");
                throw new IndexOutOfBoundsException(sbM.toString());
            default:
                String strGroup = ((MatcherMatchResult) this.delegate).matcher.group(i);
                return strGroup == null ? "" : strGroup;
        }
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        switch (this.$r8$classId) {
            case 0:
                return ((List) this.delegate).size();
            default:
                return ((MatcherMatchResult) this.delegate).matcher.groupCount() + 1;
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new AnonymousClass1(this, 0);
            default:
                return super.iterator();
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator() {
        switch (this.$r8$classId) {
            case 0:
                return new AnonymousClass1(this, 0);
            default:
                return super.listIterator();
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new AnonymousClass1(this, i);
            default:
                return super.listIterator(i);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ReversedListReadOnly$listIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements ListIterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId = 0;
        public final Object delegateIterator;
        public final /* synthetic */ Object this$0;

        public AnonymousClass1(ReversedListReadOnly reversedListReadOnly, int i) {
            this.this$0 = reversedListReadOnly;
            List list = (List) reversedListReadOnly.delegate;
            if (i >= 0 && i <= reversedListReadOnly.getSize()) {
                this.delegateIterator = list.listIterator(reversedListReadOnly.getSize() - i);
                return;
            }
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Position index ", " must be in range [");
            sbM.append(new IntRange(0, reversedListReadOnly.getSize(), 1));
            sbM.append("].");
            throw new IndexOutOfBoundsException(sbM.toString());
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    throw new IllegalStateException("Cannot modify a state list through an iterator");
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    return ((ListIterator) this.delegateIterator).hasPrevious();
                default:
                    return ((Ref$IntRef) this.delegateIterator).element < ((SubList) this.this$0).size - 1;
            }
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            switch (this.$r8$classId) {
                case 0:
                    return ((ListIterator) this.delegateIterator).hasNext();
                default:
                    return ((Ref$IntRef) this.delegateIterator).element >= 0;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    return ((ListIterator) this.delegateIterator).previous();
                default:
                    Ref$IntRef ref$IntRef = (Ref$IntRef) this.delegateIterator;
                    int i = ref$IntRef.element + 1;
                    SubList subList = (SubList) this.this$0;
                    SnapshotId_jvmKt.access$validateRange(i, subList.size);
                    ref$IntRef.element = i;
                    return subList.get(i);
            }
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            switch (this.$r8$classId) {
                case 0:
                    ReversedListReadOnly reversedListReadOnly = (ReversedListReadOnly) this.this$0;
                    return AppCompatHintHelper.getLastIndex(reversedListReadOnly) - ((ListIterator) this.delegateIterator).previousIndex();
                default:
                    return ((Ref$IntRef) this.delegateIterator).element + 1;
            }
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            switch (this.$r8$classId) {
                case 0:
                    return ((ListIterator) this.delegateIterator).next();
                default:
                    Ref$IntRef ref$IntRef = (Ref$IntRef) this.delegateIterator;
                    int i = ref$IntRef.element;
                    SubList subList = (SubList) this.this$0;
                    SnapshotId_jvmKt.access$validateRange(i, subList.size);
                    ref$IntRef.element = i - 1;
                    return subList.get(i);
            }
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            switch (this.$r8$classId) {
                case 0:
                    ReversedListReadOnly reversedListReadOnly = (ReversedListReadOnly) this.this$0;
                    return AppCompatHintHelper.getLastIndex(reversedListReadOnly) - ((ListIterator) this.delegateIterator).nextIndex();
                default:
                    return ((Ref$IntRef) this.delegateIterator).element;
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    throw new IllegalStateException("Cannot modify a state list through an iterator");
            }
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    throw new IllegalStateException("Cannot modify a state list through an iterator");
            }
        }

        public AnonymousClass1(Ref$IntRef ref$IntRef, SubList subList) {
            this.delegateIterator = ref$IntRef;
            this.this$0 = subList;
        }
    }
}
