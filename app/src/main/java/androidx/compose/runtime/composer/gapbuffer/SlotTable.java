package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.tooling.CompositionData;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SlotTable implements CompositionData, Iterable, KMappedMarker {
    public MutableIntObjectMap calledByMap;
    public int groupsSize;
    public int readers;
    public int slotsSize;
    public HashMap sourceInformationMap;
    public int version;
    public boolean writer;
    public int[] groups = new int[0];
    public Object[] slots = new Object[0];
    public final Object lock = new Object();
    public ArrayList anchors = new ArrayList();

    public final int anchorIndex(GapAnchor gapAnchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }
        if (!gapAnchor.getValid()) {
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }
        return gapAnchor.location;
    }

    public final void collectSourceInformation() {
        this.sourceInformationMap = new HashMap();
    }

    public final void disposeUnusedMovableContent(zzky zzkyVar) {
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            slotWriterOpenWriter.forAllDataInRememberOrder(slotWriterOpenWriter.currentGroup, new Updater$$ExternalSyntheticLambda0(20, zzkyVar));
            slotWriterOpenWriter.removeGroup();
            Unit unit = Unit.INSTANCE;
            boolean z = true;
        } finally {
            slotWriterOpenWriter.close(false);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.readers++;
        return new SlotReader(this);
    }

    public final SlotWriter openWriter() {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (this.readers > 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(GapAnchor gapAnchor) {
        int iSearch;
        return gapAnchor.getValid() && (iSearch = SlotTableKt.search(this.anchors, gapAnchor.location, this.groupsSize)) >= 0 && Intrinsics.areEqual(this.anchors.get(iSearch), gapAnchor);
    }

    public final GapGroupSourceInformation sourceInformationOf(int i) {
        int i2;
        ArrayList arrayList;
        int iSearch;
        HashMap map = this.sourceInformationMap;
        if (map != null) {
            if (this.writer) {
                ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
            }
            GapAnchor gapAnchor = (i < 0 || i >= (i2 = this.groupsSize) || (iSearch = SlotTableKt.search((arrayList = this.anchors), i, i2)) < 0) ? null : (GapAnchor) arrayList.get(iSearch);
            if (gapAnchor != null) {
                return (GapGroupSourceInformation) map.get(gapAnchor);
            }
        }
        return null;
    }
}
