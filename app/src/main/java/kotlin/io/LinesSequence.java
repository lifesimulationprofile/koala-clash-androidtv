package kotlin.io;

import androidx.camera.core.impl.utils.MatrixExt;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.UIntArray;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LinesSequence implements Sequence {
    public final /* synthetic */ int $r8$classId;
    public final Object reader;

    /* JADX INFO: renamed from: kotlin.io.LinesSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public boolean done;
        public String nextValue;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() throws IOException {
            if (this.nextValue == null && !this.done) {
                String line = ((BufferedReader) LinesSequence.this.reader).readLine();
                this.nextValue = line;
                if (line == null) {
                    this.done = true;
                }
            }
            return this.nextValue != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextValue;
            this.nextValue = null;
            return str;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ LinesSequence(int i, Object obj) {
        this.$r8$classId = i;
        this.reader = obj;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.coroutines.jvm.internal.RestrictedSuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new AnonymousClass1();
            case 1:
                return new UIntArray.Iterator(6, (Object[]) this.reader);
            case 2:
                return ((Iterable) this.reader).iterator();
            case 3:
                return MatrixExt.iterator((RestrictedSuspendLambda) this.reader);
            default:
                return (Iterator) this.reader;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinesSequence(Function2 function2) {
        this.$r8$classId = 3;
        this.reader = (RestrictedSuspendLambda) function2;
    }
}
