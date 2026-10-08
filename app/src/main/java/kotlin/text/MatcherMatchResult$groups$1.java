package kotlin.text;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapKeysIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeKeysIterator;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.collections.AbstractCollection;
import kotlin.io.LinesSequence;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.TransformingSequence$iterator$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection {
    public final /* synthetic */ int $r8$classId;
    public final Object this$0;

    public /* synthetic */ MatcherMatchResult$groups$1(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                if (obj == null ? true : obj instanceof MatchGroup) {
                    return super.contains((MatchGroup) obj);
                }
                return false;
            default:
                return ((PersistentHashMap) this.this$0).containsValue(obj);
        }
    }

    public MatchGroup get(int i) {
        Matcher matcher = ((MatcherMatchResult) this.this$0).matcher;
        IntRange intRangeUntil = RangesKt.until(matcher.start(i), matcher.end(i));
        if (intRangeUntil.first >= 0) {
            return new MatchGroup(matcher.group(i), intRangeUntil);
        }
        return null;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        switch (this.$r8$classId) {
            case 0:
                return ((MatcherMatchResult) this.this$0).matcher.groupCount() + 1;
            default:
                PersistentHashMap persistentHashMap = (PersistentHashMap) this.this$0;
                persistentHashMap.getClass();
                return persistentHashMap.size;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.$r8$classId) {
            case 0:
                return false;
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new TransformingSequence$iterator$1(new GeneratorSequence(new LinesSequence(2, new IntRange(0, size() - 1, 1)), new DiskLruCache$$ExternalSyntheticLambda0(20, this), 3));
            default:
                TrieNode trieNode = ((PersistentHashMap) this.this$0).node;
                TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
                for (int i = 0; i < 8; i++) {
                    trieNodeBaseIteratorArr[i] = new TrieNodeKeysIterator(2);
                }
                return new PersistentHashMapKeysIterator(trieNode, trieNodeBaseIteratorArr);
        }
    }
}
