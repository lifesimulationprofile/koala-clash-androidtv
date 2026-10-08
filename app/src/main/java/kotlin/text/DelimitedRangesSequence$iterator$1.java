package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DelimitedRangesSequence$iterator$1 implements Iterator, KMappedMarker {
    public int counter;
    public int currentStartIndex;
    public IntRange nextItem;
    public int nextSearchIndex;
    public int nextState = -1;
    public final /* synthetic */ FileTreeWalk this$0;

    public DelimitedRangesSequence$iterator$1(FileTreeWalk fileTreeWalk) {
        this.this$0 = fileTreeWalk;
        int iCoerceIn = RangesKt.coerceIn(0, 0, ((CharSequence) fileTreeWalk.start).length());
        this.currentStartIndex = iCoerceIn;
        this.nextSearchIndex = iCoerceIn;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    /* JADX WARN: Code duplicated, block: B:12:0x0024 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:18:0x007d  */
    public final void calcNext$3() {
        Pair pair;
        int i = this.nextSearchIndex;
        if (i < 0) {
            this.nextState = 0;
            this.nextItem = null;
            return;
        }
        FileTreeWalk fileTreeWalk = this.this$0;
        int i2 = fileTreeWalk.direction;
        if (i2 > 0) {
            int i3 = this.counter + 1;
            this.counter = i3;
            if (i3 >= i2) {
                this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex((CharSequence) fileTreeWalk.start), 1);
                this.nextSearchIndex = -1;
            } else if (i > ((CharSequence) fileTreeWalk.start).length() && (pair = (Pair) fileTreeWalk.onFail.invoke((CharSequence) fileTreeWalk.start, Integer.valueOf(this.nextSearchIndex))) != null) {
                int iIntValue = ((Number) pair.first).intValue();
                int iIntValue2 = ((Number) pair.second).intValue();
                this.nextItem = RangesKt.until(this.currentStartIndex, iIntValue);
                int i4 = iIntValue + iIntValue2;
                this.currentStartIndex = i4;
                this.nextSearchIndex = i4 + (iIntValue2 == 0 ? 1 : 0);
            } else {
                this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex((CharSequence) fileTreeWalk.start), 1);
                this.nextSearchIndex = -1;
            }
        } else if (i > ((CharSequence) fileTreeWalk.start).length()) {
            this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex((CharSequence) fileTreeWalk.start), 1);
            this.nextSearchIndex = -1;
        } else {
            int iIntValue3 = ((Number) pair.first).intValue();
            int iIntValue4 = ((Number) pair.second).intValue();
            this.nextItem = RangesKt.until(this.currentStartIndex, iIntValue3);
            int i5 = iIntValue3 + iIntValue4;
            this.currentStartIndex = i5;
            this.nextSearchIndex = i5 + (iIntValue4 == 0 ? 1 : 0);
        }
        this.nextState = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextState == -1) {
            calcNext$3();
        }
        return this.nextState == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.nextState == -1) {
            calcNext$3();
        }
        if (this.nextState == 0) {
            throw new NoSuchElementException();
        }
        IntRange intRange = this.nextItem;
        this.nextItem = null;
        this.nextState = -1;
        return intRange;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
