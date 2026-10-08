package androidx.compose.runtime.tooling;

import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapAnchorKt;
import androidx.compose.runtime.composer.gapbuffer.GapGroupSourceInformation;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ReaderTraceBuilder extends Lifecycle {
    public final /* synthetic */ int $r8$classId;
    public final Object reader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReaderTraceBuilder(int i, Object obj) {
        super(4);
        this.$r8$classId = i;
        this.reader = obj;
    }

    @Override // androidx.lifecycle.Lifecycle
    public final int groupKeyOf(GapAnchor gapAnchor) {
        switch (this.$r8$classId) {
            case 0:
                SlotReader slotReader = (SlotReader) this.reader;
                return slotReader.groupKey(slotReader.table.anchorIndex(GapAnchorKt.asGapAnchor(gapAnchor)));
            default:
                SlotWriter slotWriter = (SlotWriter) this.reader;
                return slotWriter.groupKey(slotWriter.anchorIndex(GapAnchorKt.asGapAnchor(gapAnchor)));
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final GapGroupSourceInformation sourceInformationOf(GapAnchor gapAnchor) {
        switch (this.$r8$classId) {
            case 0:
                SlotTable slotTable = ((SlotReader) this.reader).table;
                slotTable.sourceInformationOf(slotTable.anchorIndex(GapAnchorKt.asGapAnchor(gapAnchor)));
                break;
            default:
                SlotWriter slotWriter = (SlotWriter) this.reader;
                slotWriter.sourceInformationOf$runtime(slotWriter.anchorIndex(GapAnchorKt.asGapAnchor(gapAnchor)));
                break;
        }
        return null;
    }
}
