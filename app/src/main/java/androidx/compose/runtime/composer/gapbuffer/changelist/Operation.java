package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.collection.CircularArray;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.GapRememberObserverHolder;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PausedCompositionRemembers;
import coil.network.HttpException;
import coil.request.RequestService;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsh;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import okhttp3.internal.http2.Huffman;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Operation {
    public final int ints;
    public final int objects;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AdvanceSlotsBy extends Operation {
        public static final AdvanceSlotsBy INSTANCE = new AdvanceSlotsBy(1, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            slotWriter.advanceBy(circularArray.getInt(0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AppendValue extends Operation {
        public static final AppendValue INSTANCE = new AppendValue(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            GapAnchor gapAnchor = (GapAnchor) circularArray.m20getObjectPtLUHM(0);
            Object objM20getObjectPtLUHM = circularArray.m20getObjectPtLUHM(1);
            if (objM20getObjectPtLUHM instanceof RememberObserverHolder) {
                zzkyVar.remembering((RememberObserverHolder) objM20getObjectPtLUHM);
            }
            if (slotWriter.insertCount != 0) {
                ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
            }
            int i = slotWriter.currentSlot;
            int i2 = slotWriter.currentSlotEnd;
            int iAnchorIndex = slotWriter.anchorIndex(gapAnchor);
            int iDataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(iAnchorIndex + 1));
            slotWriter.currentSlot = iDataIndex;
            slotWriter.currentSlotEnd = iDataIndex;
            slotWriter.insertSlots(1, iAnchorIndex);
            if (i >= iDataIndex) {
                i++;
                i2++;
            }
            slotWriter.slots[iDataIndex] = objM20getObjectPtLUHM;
            slotWriter.currentSlot = i;
            slotWriter.currentSlotEnd = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ApplyChangeList extends Operation {
        public static final ApplyChangeList INSTANCE = new ApplyChangeList(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            IntRef intRef = (IntRef) circularArray.m20getObjectPtLUHM(1);
            int i = intRef != null ? intRef.element : 0;
            ChangeList changeList = (ChangeList) circularArray.m20getObjectPtLUHM(0);
            if (i > 0) {
                applier = new Huffman.Node(applier, i);
            }
            changeList.executeAndFlushAllPendingChanges(applier, slotWriter, zzkyVar, operationErrorContext != null ? new RequestService(1, operationErrorContext, slotWriter) : null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CopyNodesToNewAnchorLocation extends Operation {
        public static final CopyNodesToNewAnchorLocation INSTANCE = new CopyNodesToNewAnchorLocation(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            int i = ((IntRef) circularArray.m20getObjectPtLUHM(0)).element;
            List list = (List) circularArray.m20getObjectPtLUHM(1);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = list.get(i2);
                int i3 = i + i2;
                applier.insertBottomUp(i3, obj);
                applier.insertTopDown(i3, obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CopySlotTableToAnchorLocation extends Operation {
        public static final CopySlotTableToAnchorLocation INSTANCE = new CopySlotTableToAnchorLocation(0, 4, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) circularArray.m20getObjectPtLUHM(2);
            CompositionContext compositionContext = (CompositionContext) circularArray.m20getObjectPtLUHM(1);
            compositionContext.movableContentStateResolve$runtime(movableContentStateReference);
            ComposerKt.composeRuntimeError("Could not resolve state for movable content");
            throw new HttpException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DeactivateCurrentGroup extends Operation {
        public static final DeactivateCurrentGroup INSTANCE;

        static {
            int i = 0;
            INSTANCE = new DeactivateCurrentGroup(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            slotWriter.forAllDataInRememberOrder(slotWriter.currentGroup, new TextKt$$ExternalSyntheticLambda2(20, zzkyVar, slotWriter));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DetermineMovableContentNodeIndex extends Operation {
        public static final DetermineMovableContentNodeIndex INSTANCE = new DetermineMovableContentNodeIndex(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            int i;
            IntRef intRef = (IntRef) circularArray.m20getObjectPtLUHM(0);
            int iAnchorIndex = slotWriter.anchorIndex((GapAnchor) circularArray.m20getObjectPtLUHM(1));
            if (slotWriter.currentGroup >= iAnchorIndex) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            zzsh.positionToParentOf(slotWriter, applier, iAnchorIndex);
            int i2 = slotWriter.currentGroup;
            int iParent = slotWriter.parent;
            while (iParent >= 0 && !slotWriter.isNode(iParent)) {
                iParent = slotWriter.parent(slotWriter.groups, iParent);
            }
            int iGroupSize = iParent + 1;
            int iSkipGroup = 0;
            while (iGroupSize < i2) {
                if (slotWriter.indexInGroup(i2, iGroupSize)) {
                    if (slotWriter.isNode(iGroupSize)) {
                        iSkipGroup = 0;
                    }
                    iGroupSize++;
                } else {
                    iSkipGroup += slotWriter.isNode(iGroupSize) ? 1 : slotWriter.groups[(slotWriter.groupIndexToAddress(iGroupSize) * 5) + 1] & 67108863;
                    iGroupSize += slotWriter.groupSize(iGroupSize);
                }
            }
            while (true) {
                i = slotWriter.currentGroup;
                if (i >= iAnchorIndex) {
                    break;
                }
                if (slotWriter.indexInGroup(iAnchorIndex, i)) {
                    int i3 = slotWriter.currentGroup;
                    if (i3 < slotWriter.currentGroupEnd && (slotWriter.groups[(slotWriter.groupIndexToAddress(i3) * 5) + 1] & 1073741824) != 0) {
                        applier.down(slotWriter.node(slotWriter.currentGroup));
                        iSkipGroup = 0;
                    }
                    slotWriter.startGroup();
                } else {
                    iSkipGroup += slotWriter.skipGroup();
                }
            }
            if (i != iAnchorIndex) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            intRef.element = iSkipGroup;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Downs extends Operation {
        public static final Downs INSTANCE;

        static {
            int i = 1;
            INSTANCE = new Downs(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            for (Object obj : (Object[]) circularArray.m20getObjectPtLUHM(0)) {
                applier.down(obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class EndCompositionScope extends Operation {
        public static final EndCompositionScope INSTANCE = new EndCompositionScope(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            ((Function1) circularArray.m20getObjectPtLUHM(0)).invoke((Composition) circularArray.m20getObjectPtLUHM(1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class EndCurrentGroup extends Operation {
        public static final EndCurrentGroup INSTANCE;

        static {
            int i = 0;
            INSTANCE = new EndCurrentGroup(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            slotWriter.endGroup();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class EndMovableContentPlacement extends Operation {
        public static final EndMovableContentPlacement INSTANCE;

        static {
            int i = 0;
            INSTANCE = new EndMovableContentPlacement(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            zzsh.positionToParentOf(slotWriter, applier, 0);
            slotWriter.endGroup();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class EndResumingScope extends Operation {
        public static final EndResumingScope INSTANCE;

        static {
            int i = 1;
            INSTANCE = new EndResumingScope(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            MutableVector mutableVector;
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) circularArray.m20getObjectPtLUHM(0);
            MutableScatterMap mutableScatterMap = (MutableScatterMap) zzkyVar.zzi;
            if (mutableScatterMap == null || ((PausedCompositionRemembers) mutableScatterMap.get(recomposeScopeImpl)) == null) {
                return;
            }
            ArrayList arrayList = (ArrayList) zzkyVar.zzj;
            if (arrayList != null && (mutableVector = (MutableVector) arrayList.remove(arrayList.size() - 1)) != null) {
                zzkyVar.zzf = mutableVector;
            }
            mutableScatterMap.remove(recomposeScopeImpl);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class EnsureGroupStarted extends Operation {
        public static final EnsureGroupStarted INSTANCE;

        static {
            int i = 1;
            INSTANCE = new EnsureGroupStarted(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            GapAnchor gapAnchor = (GapAnchor) circularArray.m20getObjectPtLUHM(0);
            gapAnchor.getClass();
            slotWriter.ensureStarted(slotWriter.anchorIndex(gapAnchor));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class EnsureRootGroupStarted extends Operation {
        public static final EnsureRootGroupStarted INSTANCE;

        static {
            int i = 0;
            INSTANCE = new EnsureRootGroupStarted(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            slotWriter.ensureStarted(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class InsertSlots extends Operation {
        public static final InsertSlots INSTANCE = new InsertSlots(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            SlotTable slotTable = (SlotTable) circularArray.m20getObjectPtLUHM(1);
            GapAnchor gapAnchor = (GapAnchor) circularArray.m20getObjectPtLUHM(0);
            slotWriter.beginInsert();
            gapAnchor.getClass();
            slotWriter.moveFrom(slotTable, slotTable.anchorIndex(gapAnchor));
            slotWriter.endInsert();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class InsertSlotsWithFixups extends Operation {
        public static final InsertSlotsWithFixups INSTANCE = new InsertSlotsWithFixups(0, 3, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            RequestService requestService;
            int i = 1;
            SlotTable slotTable = (SlotTable) circularArray.m20getObjectPtLUHM(1);
            GapAnchor gapAnchor = (GapAnchor) circularArray.m20getObjectPtLUHM(0);
            FixupList fixupList = (FixupList) circularArray.m20getObjectPtLUHM(2);
            SlotWriter slotWriterOpenWriter = slotTable.openWriter();
            if (operationErrorContext != null) {
                try {
                    requestService = new RequestService(i, operationErrorContext, slotWriter);
                } catch (Throwable th) {
                    slotWriterOpenWriter.close(false);
                    throw th;
                }
            } else {
                requestService = null;
            }
            if (!fixupList.pendingOperations.isEmpty()) {
                ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
            }
            fixupList.operations.executeAndFlushAllPendingOperations(applier, slotWriterOpenWriter, zzkyVar, requestService);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close(true);
            slotWriter.beginInsert();
            gapAnchor.getClass();
            slotWriter.moveFrom(slotTable, slotTable.anchorIndex(gapAnchor));
            slotWriter.endInsert();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class MoveCurrentGroup extends Operation {
        public static final MoveCurrentGroup INSTANCE = new MoveCurrentGroup(1, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            GapAnchor gapAnchor;
            int iAnchorIndex;
            int i = circularArray.getInt(0);
            if (slotWriter.insertCount != 0) {
                ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
            }
            if (i < 0) {
                ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
            }
            if (i == 0) {
                return;
            }
            int i2 = slotWriter.currentGroup;
            int i3 = slotWriter.parent;
            int i4 = slotWriter.currentGroupEnd;
            int i5 = i2;
            while (i > 0) {
                i5 += slotWriter.groups[(slotWriter.groupIndexToAddress(i5) * 5) + 3];
                if (i5 > i4) {
                    ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
                }
                i--;
            }
            int i6 = slotWriter.groups[(slotWriter.groupIndexToAddress(i5) * 5) + 3];
            int iDataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(slotWriter.currentGroup));
            int iDataIndex2 = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i5));
            int i7 = i5 + i6;
            int iDataIndex3 = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i7));
            int i8 = iDataIndex3 - iDataIndex2;
            slotWriter.insertSlots(i8, Math.max(slotWriter.currentGroup - 1, 0));
            slotWriter.insertGroups(i6);
            int[] iArr = slotWriter.groups;
            int iGroupIndexToAddress = slotWriter.groupIndexToAddress(i7) * 5;
            ArraysKt.copyInto(slotWriter.groupIndexToAddress(i2) * 5, iGroupIndexToAddress, (i6 * 5) + iGroupIndexToAddress, iArr, iArr);
            if (i8 > 0) {
                Object[] objArr = slotWriter.slots;
                int iDataIndexToDataAddress = slotWriter.dataIndexToDataAddress(iDataIndex2 + i8);
                System.arraycopy(objArr, iDataIndexToDataAddress, objArr, iDataIndex, slotWriter.dataIndexToDataAddress(iDataIndex3 + i8) - iDataIndexToDataAddress);
            }
            int i9 = iDataIndex2 + i8;
            int i10 = i9 - iDataIndex;
            int i11 = slotWriter.slotsGapStart;
            int i12 = slotWriter.slotsGapLen;
            int length = slotWriter.slots.length;
            int i13 = slotWriter.slotsGapOwner;
            int i14 = i2 + i6;
            int i15 = i2;
            while (i15 < i14) {
                int iGroupIndexToAddress2 = slotWriter.groupIndexToAddress(i15);
                int i16 = i10;
                int[] iArr2 = iArr;
                iArr2[(iGroupIndexToAddress2 * 5) + 4] = SlotWriter.dataIndexToDataAnchor(SlotWriter.dataIndexToDataAnchor(slotWriter.dataIndex(iArr, iGroupIndexToAddress2) - i16, i13 < iGroupIndexToAddress2 ? 0 : i11, i12, length), slotWriter.slotsGapStart, slotWriter.slotsGapLen, slotWriter.slots.length);
                i15++;
                i10 = i16;
                iArr = iArr2;
                i11 = i11;
            }
            int i17 = i7 + i6;
            int size$runtime = slotWriter.getSize$runtime();
            int iAccess$locationOf = SlotTableKt.access$locationOf(slotWriter.anchors, i7, size$runtime);
            ArrayList arrayList = new ArrayList();
            if (iAccess$locationOf >= 0) {
                while (iAccess$locationOf < slotWriter.anchors.size() && (iAnchorIndex = slotWriter.anchorIndex((gapAnchor = (GapAnchor) slotWriter.anchors.get(iAccess$locationOf)))) >= i7 && iAnchorIndex < i17) {
                    arrayList.add(gapAnchor);
                }
            }
            int i18 = i2 - i7;
            int size = arrayList.size();
            for (int i19 = 0; i19 < size; i19++) {
                GapAnchor gapAnchor2 = (GapAnchor) arrayList.get(i19);
                int iAnchorIndex2 = slotWriter.anchorIndex(gapAnchor2) + i18;
                if (iAnchorIndex2 >= slotWriter.groupGapStart) {
                    gapAnchor2.location = -(size$runtime - iAnchorIndex2);
                } else {
                    gapAnchor2.location = iAnchorIndex2;
                }
                slotWriter.anchors.add(SlotTableKt.access$locationOf(slotWriter.anchors, iAnchorIndex2, size$runtime), gapAnchor2);
            }
            if (slotWriter.removeGroups(i7, i6)) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            slotWriter.fixParentAnchorsFor(i3, slotWriter.currentGroupEnd, i2);
            if (i8 > 0) {
                slotWriter.removeSlots(i9, i8, i7 - 1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class MoveNode extends Operation {
        public static final MoveNode INSTANCE = new MoveNode(3, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            applier.move(circularArray.getInt(0), circularArray.getInt(1), circularArray.getInt(2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Remember extends Operation {
        public static final Remember INSTANCE;

        static {
            int i = 1;
            INSTANCE = new Remember(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            zzkyVar.remembering((RememberObserverHolder) circularArray.m20getObjectPtLUHM(0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RememberPausingScope extends Operation {
        public static final RememberPausingScope INSTANCE;

        static {
            int i = 1;
            INSTANCE = new RememberPausingScope(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) circularArray.m20getObjectPtLUHM(0);
            Set set = (Set) zzkyVar.zza;
            if (set == null) {
                return;
            }
            PausedCompositionRemembers pausedCompositionRemembers = new PausedCompositionRemembers(set);
            MutableScatterMap mutableScatterMap = (MutableScatterMap) zzkyVar.zzi;
            if (mutableScatterMap == null) {
                long[] jArr = ScatterMapKt.EmptyGroup;
                mutableScatterMap = new MutableScatterMap();
                zzkyVar.zzi = mutableScatterMap;
            }
            mutableScatterMap.set(recomposeScopeImpl, pausedCompositionRemembers);
            ((MutableVector) zzkyVar.zzf).add(new GapRememberObserverHolder(pausedCompositionRemembers, -1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RemoveCurrentGroup extends Operation {
        public static final RemoveCurrentGroup INSTANCE;

        static {
            int i = 0;
            INSTANCE = new RemoveCurrentGroup(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            slotWriter.forAllDataInRememberOrder(slotWriter.currentGroup, new Updater$$ExternalSyntheticLambda0(20, zzkyVar));
            slotWriter.removeGroup();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RemoveNode extends Operation {
        public static final RemoveNode INSTANCE;

        static {
            int i = 2;
            INSTANCE = new RemoveNode(i, 0, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            applier.remove(circularArray.getInt(0), circularArray.getInt(1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ResetSlots extends Operation {
        public static final ResetSlots INSTANCE;

        static {
            int i = 0;
            INSTANCE = new ResetSlots(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            if (slotWriter.insertCount != 0) {
                ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
            }
            slotWriter.recalculateMarks();
            slotWriter.currentGroup = 0;
            slotWriter.currentGroupEnd = slotWriter.getCapacity() - slotWriter.groupGapLen;
            slotWriter.currentSlot = 0;
            slotWriter.currentSlotEnd = 0;
            slotWriter.nodeCount = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SideEffect extends Operation {
        public static final SideEffect INSTANCE;

        static {
            int i = 1;
            INSTANCE = new SideEffect(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            ((MutableVector) zzkyVar.zzg).add((Function0) circularArray.m20getObjectPtLUHM(0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SkipToEndOfCurrentGroup extends Operation {
        public static final SkipToEndOfCurrentGroup INSTANCE;

        static {
            int i = 0;
            INSTANCE = new SkipToEndOfCurrentGroup(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            slotWriter.skipToGroupEnd();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class StartResumingScope extends Operation {
        public static final StartResumingScope INSTANCE;

        static {
            int i = 1;
            INSTANCE = new StartResumingScope(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) circularArray.m20getObjectPtLUHM(0);
            MutableScatterMap mutableScatterMap = (MutableScatterMap) zzkyVar.zzi;
            PausedCompositionRemembers pausedCompositionRemembers = mutableScatterMap != null ? (PausedCompositionRemembers) mutableScatterMap.get(recomposeScopeImpl) : null;
            if (pausedCompositionRemembers != null) {
                ArrayList arrayList = (ArrayList) zzkyVar.zzj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    zzkyVar.zzj = arrayList;
                }
                arrayList.add((MutableVector) zzkyVar.zzf);
                zzkyVar.zzf = pausedCompositionRemembers.pausedRemembers;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TrimParentValues extends Operation {
        public static final TrimParentValues INSTANCE = new TrimParentValues(1, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            int i = circularArray.getInt(0);
            int i2 = slotWriter.parent;
            int iSlotIndex = slotWriter.slotIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i2));
            int iDataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i2 + 1));
            for (int iMax = Math.max(iSlotIndex, iDataIndex - i); iMax < iDataIndex; iMax++) {
                Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(iMax)];
                if (obj instanceof RememberObserverHolder) {
                    zzkyVar.forgetting((RememberObserverHolder) obj);
                } else if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            if (i <= 0) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            int i3 = slotWriter.parent;
            int iSlotIndex2 = slotWriter.slotIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i3));
            int iDataIndex2 = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i3 + 1)) - i;
            if (iDataIndex2 < iSlotIndex2) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            slotWriter.removeSlots(iDataIndex2, i, i3);
            int i4 = slotWriter.currentSlot;
            if (i4 >= iSlotIndex2) {
                slotWriter.currentSlot = i4 - i;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class UpdateAuxData extends Operation {
        public static final UpdateAuxData INSTANCE;

        static {
            int i = 1;
            INSTANCE = new UpdateAuxData(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            slotWriter.updateAux(circularArray.m20getObjectPtLUHM(0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class UpdateNode extends Operation {
        public static final UpdateNode INSTANCE = new UpdateNode(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            applier.apply(circularArray.m20getObjectPtLUHM(0), (Function2) circularArray.m20getObjectPtLUHM(1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class UpdateValue extends Operation {
        public static final UpdateValue INSTANCE;
        public static final UpdateValue INSTANCE$1;
        public static final UpdateValue INSTANCE$2;
        public static final UpdateValue INSTANCE$3;
        public final /* synthetic */ int $r8$classId;

        static {
            int i = 1;
            INSTANCE$1 = new UpdateValue(i, 2, 1);
            int i2 = 1;
            INSTANCE$2 = new UpdateValue(i2, i2, 2);
            INSTANCE$3 = new UpdateValue(i, 2, 3);
            int i3 = 1;
            INSTANCE = new UpdateValue(i3, i3, 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UpdateValue(int i, int i2, int i3) {
            super(i, i2);
            this.$r8$classId = i3;
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            switch (this.$r8$classId) {
                case 0:
                    Object objM20getObjectPtLUHM = circularArray.m20getObjectPtLUHM(0);
                    int i = circularArray.getInt(0);
                    if (objM20getObjectPtLUHM instanceof RememberObserverHolder) {
                        zzkyVar.remembering((RememberObserverHolder) objM20getObjectPtLUHM);
                    }
                    Object obj = slotWriter.set(slotWriter.currentGroup, i, objM20getObjectPtLUHM);
                    if (obj instanceof RememberObserverHolder) {
                        zzkyVar.forgetting((RememberObserverHolder) obj);
                    } else if (obj instanceof RecomposeScopeImpl) {
                        ((RecomposeScopeImpl) obj).release();
                    }
                    break;
                case 1:
                    Object objInvoke = ((Function0) circularArray.m20getObjectPtLUHM(0)).invoke();
                    GapAnchor gapAnchor = (GapAnchor) circularArray.m20getObjectPtLUHM(1);
                    int i2 = circularArray.getInt(0);
                    gapAnchor.getClass();
                    slotWriter.updateNodeOfGroup(slotWriter.anchorIndex(gapAnchor), objInvoke);
                    applier.insertTopDown(i2, objInvoke);
                    applier.down(objInvoke);
                    break;
                case 2:
                    GapAnchor gapAnchor2 = (GapAnchor) circularArray.m20getObjectPtLUHM(0);
                    int i3 = circularArray.getInt(0);
                    applier.up();
                    gapAnchor2.getClass();
                    applier.insertBottomUp(i3, slotWriter.node(slotWriter.anchorIndex(gapAnchor2)));
                    break;
                default:
                    Object objM20getObjectPtLUHM2 = circularArray.m20getObjectPtLUHM(0);
                    GapAnchor gapAnchor3 = (GapAnchor) circularArray.m20getObjectPtLUHM(1);
                    int i4 = circularArray.getInt(0);
                    if (objM20getObjectPtLUHM2 instanceof RememberObserverHolder) {
                        zzkyVar.remembering((RememberObserverHolder) objM20getObjectPtLUHM2);
                    }
                    Object obj2 = slotWriter.set(slotWriter.anchorIndex(gapAnchor3), i4, objM20getObjectPtLUHM2);
                    if (obj2 instanceof RememberObserverHolder) {
                        zzkyVar.forgetting((RememberObserverHolder) obj2);
                    } else if (obj2 instanceof RecomposeScopeImpl) {
                        ((RecomposeScopeImpl) obj2).release();
                    }
                    break;
            }
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public GapAnchor getGroupAnchor(CircularArray circularArray) {
            switch (this.$r8$classId) {
                case 1:
                    return (GapAnchor) circularArray.m20getObjectPtLUHM(1);
                case 2:
                    return (GapAnchor) circularArray.m20getObjectPtLUHM(0);
                default:
                    return super.getGroupAnchor(circularArray);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Ups extends Operation {
        public static final Ups INSTANCE = new Ups(1, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            int i = circularArray.getInt(0);
            for (int i2 = 0; i2 < i; i2++) {
                applier.up();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class UseCurrentNode extends Operation {
        public static final UseCurrentNode INSTANCE;

        static {
            int i = 0;
            INSTANCE = new UseCurrentNode(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
            applier.reuse();
        }
    }

    public Operation(int i, int i2) {
        this.ints = i;
        this.objects = i2;
    }

    public abstract void execute(CircularArray circularArray, Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext);

    public GapAnchor getGroupAnchor(CircularArray circularArray) {
        return null;
    }

    public final String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        return simpleName == null ? "" : simpleName;
    }

    public /* synthetic */ Operation(int i, int i2, int i3) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
