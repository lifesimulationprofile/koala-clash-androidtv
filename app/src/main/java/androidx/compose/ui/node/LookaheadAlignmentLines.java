package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.navigation.Navigator;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LookaheadAlignmentLines {
    public final /* synthetic */ int $r8$classId;
    public final Placeable alignmentLinesOwner;
    public boolean previousUsedDuringParentLayout;
    public AlignmentLinesOwner queryOwner;
    public boolean usedByModifierLayout;
    public boolean usedByModifierMeasurement;
    public boolean usedDuringParentLayout;
    public boolean usedDuringParentMeasurement;
    public boolean dirty = true;
    public final HashMap alignmentLineMap = new HashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public LookaheadAlignmentLines(AlignmentLinesOwner alignmentLinesOwner, int i) {
        this.$r8$classId = i;
        this.alignmentLinesOwner = (Placeable) alignmentLinesOwner;
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.FunctionReferenceImpl] */
    /* JADX WARN: Type inference failed for: r3v13, types: [androidx.compose.ui.layout.Placeable, androidx.compose.ui.node.AlignmentLinesOwner] */
    public static final void access$addAlignmentLine(LookaheadAlignmentLines lookaheadAlignmentLines, AlignmentLine alignmentLine, int i, NodeCoordinator nodeCoordinator) {
        HashMap map = lookaheadAlignmentLines.alignmentLineMap;
        float f = i;
        long jFloatToRawIntBits = ((long) Float.floatToRawIntBits(f)) << 32;
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(f)) & 4294967295L;
        while (true) {
            long jM373plusMKHz9U = jFloatToRawIntBits | jFloatToRawIntBits2;
            do {
                switch (lookaheadAlignmentLines.$r8$classId) {
                    case 0:
                        long j = nodeCoordinator.getLookaheadDelegate().position;
                        jM373plusMKHz9U = Offset.m373plusMKHz9U((((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L) | (((long) Float.floatToRawIntBits((int) (j >> 32))) << 32), jM373plusMKHz9U);
                        break;
                    default:
                        OwnedLayer ownedLayer = nodeCoordinator.layer;
                        if (ownedLayer != null) {
                            jM373plusMKHz9U = ((GraphicsLayerOwnerLayer) ownedLayer).m607mapOffset8S9VItk(jM373plusMKHz9U, false);
                        }
                        jM373plusMKHz9U = IntOffsetKt.m716plusNvtHpc(jM373plusMKHz9U, nodeCoordinator.position);
                        break;
                }
                nodeCoordinator = nodeCoordinator.wrappedBy;
                if (nodeCoordinator.equals(lookaheadAlignmentLines.alignmentLinesOwner.getInnerCoordinator())) {
                    int iRound = Math.round(alignmentLine instanceof HorizontalAlignmentLine ? Float.intBitsToFloat((int) (jM373plusMKHz9U & 4294967295L)) : Float.intBitsToFloat((int) (jM373plusMKHz9U >> 32)));
                    if (map.containsKey(alignmentLine)) {
                        int iIntValue = ((Number) MapsKt__MapsKt.getValue(alignmentLine, map)).intValue();
                        HorizontalAlignmentLine horizontalAlignmentLine = AlignmentLineKt.FirstBaseline;
                        iRound = ((Number) alignmentLine.merger.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iRound))).intValue();
                    }
                    map.put(alignmentLine, Integer.valueOf(iRound));
                    return;
                }
            } while (!lookaheadAlignmentLines.getAlignmentLinesMap(nodeCoordinator).containsKey(alignmentLine));
            float positionFor = lookaheadAlignmentLines.getPositionFor(nodeCoordinator, alignmentLine);
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(positionFor);
            long jFloatToRawIntBits4 = Float.floatToRawIntBits(positionFor);
            jFloatToRawIntBits = jFloatToRawIntBits3 << 32;
            jFloatToRawIntBits2 = jFloatToRawIntBits4 & 4294967295L;
        }
    }

    public final Map getAlignmentLinesMap(NodeCoordinator nodeCoordinator) {
        switch (this.$r8$classId) {
            case 0:
                return nodeCoordinator.getLookaheadDelegate().getMeasureResult$ui().getAlignmentLines();
            default:
                return nodeCoordinator.getMeasureResult$ui().getAlignmentLines();
        }
    }

    public final int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine) {
        switch (this.$r8$classId) {
            case 0:
                return nodeCoordinator.getLookaheadDelegate().get(alignmentLine);
            default:
                return nodeCoordinator.get(alignmentLine);
        }
    }

    public final boolean getQueried$ui() {
        return this.usedDuringParentMeasurement || this.previousUsedDuringParentLayout || this.usedByModifierMeasurement || this.usedByModifierLayout;
    }

    public final boolean getRequired$ui() {
        recalculateQueryOwner();
        return this.queryOwner != null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.layout.Placeable, androidx.compose.ui.node.AlignmentLinesOwner] */
    public final void onAlignmentsChanged() {
        this.dirty = true;
        ?? r0 = this.alignmentLinesOwner;
        AlignmentLinesOwner parentAlignmentLinesOwner = r0.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null) {
            return;
        }
        if (this.usedDuringParentMeasurement) {
            parentAlignmentLinesOwner.requestMeasure();
        } else if (this.previousUsedDuringParentLayout || this.usedDuringParentLayout) {
            parentAlignmentLinesOwner.requestLayout();
        }
        if (this.usedByModifierMeasurement) {
            r0.requestMeasure();
        }
        if (this.usedByModifierLayout) {
            r0.requestLayout();
        }
        parentAlignmentLinesOwner.getAlignmentLines().onAlignmentsChanged();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.layout.Placeable, androidx.compose.ui.node.AlignmentLinesOwner] */
    public final void recalculate() {
        HashMap map = this.alignmentLineMap;
        map.clear();
        Navigator.AnonymousClass1 anonymousClass1 = new Navigator.AnonymousClass1(14, this);
        ?? r2 = this.alignmentLinesOwner;
        r2.forEachChildAlignmentLinesOwner(anonymousClass1);
        map.putAll(getAlignmentLinesMap(r2.getInnerCoordinator()));
        this.dirty = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.ui.layout.Placeable, androidx.compose.ui.node.AlignmentLinesOwner] */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.node.AlignmentLinesOwner] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final void recalculateQueryOwner() {
        AlignmentLinesOwner alignmentLinesOwner;
        LookaheadAlignmentLines alignmentLines;
        LookaheadAlignmentLines alignmentLines2;
        boolean queried$ui = getQueried$ui();
        ?? r1 = this.alignmentLinesOwner;
        ?? r2 = r1;
        if (!queried$ui) {
            AlignmentLinesOwner parentAlignmentLinesOwner = r1.getParentAlignmentLinesOwner();
            if (parentAlignmentLinesOwner == null) {
                return;
            }
            alignmentLinesOwner = parentAlignmentLinesOwner.getAlignmentLines().queryOwner;
            if (alignmentLinesOwner == null || !alignmentLinesOwner.getAlignmentLines().getQueried$ui()) {
                r2 = alignmentLinesOwner;
                AlignmentLinesOwner alignmentLinesOwner2 = this.queryOwner;
                if (alignmentLinesOwner2 == null || alignmentLinesOwner2.getAlignmentLines().getQueried$ui()) {
                    return;
                }
                AlignmentLinesOwner parentAlignmentLinesOwner2 = alignmentLinesOwner2.getParentAlignmentLinesOwner();
                if (parentAlignmentLinesOwner2 != null && (alignmentLines2 = parentAlignmentLinesOwner2.getAlignmentLines()) != null) {
                    alignmentLines2.recalculateQueryOwner();
                }
                AlignmentLinesOwner parentAlignmentLinesOwner3 = alignmentLinesOwner2.getParentAlignmentLinesOwner();
                r2 = (parentAlignmentLinesOwner3 == null || (alignmentLines = parentAlignmentLinesOwner3.getAlignmentLines()) == null) ? 0 : alignmentLines.queryOwner;
            }
        }
        r2 = alignmentLinesOwner;
        this.queryOwner = r2;
    }
}
