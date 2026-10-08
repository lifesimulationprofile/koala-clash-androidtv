package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SlotTableGroup implements CompositionData, Iterable, KMappedMarker {
    public final int group;
    public final SlotTable table;
    public final int version;

    public SlotTableGroup(SlotTable slotTable, int i, int i2) {
        this.table = slotTable;
        this.group = i;
        this.version = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SlotTableGroup)) {
            return false;
        }
        SlotTableGroup slotTableGroup = (SlotTableGroup) obj;
        return slotTableGroup.group == this.group && slotTableGroup.version == this.version && Intrinsics.areEqual(slotTableGroup.table, this.table);
    }

    public final int hashCode() {
        return (this.table.hashCode() * 31) + this.group;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        SlotTable slotTable = this.table;
        if (slotTable.version != this.version) {
            SlotTableKt.throwConcurrentModificationException();
        }
        int i = this.group;
        slotTable.sourceInformationOf(i);
        return new GroupIterator(slotTable, i + 1, slotTable.groups[(i * 5) + 3] + i);
    }
}
