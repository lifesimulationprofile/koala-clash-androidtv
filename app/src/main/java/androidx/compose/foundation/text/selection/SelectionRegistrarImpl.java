package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.lazy.LazyListIntervalContent$$ExternalSyntheticLambda2;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.semantics.SemanticsSortKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionRegistrarImpl {
    public static final RequestService Saver = new RequestService(2, new SaversKt$$ExternalSyntheticLambda0(5), new SaversKt$$ExternalSyntheticLambda10(5));
    public final MutableLongObjectMap _selectableMap;
    public final ArrayList _selectables = new ArrayList();
    public SelectionManager$$ExternalSyntheticLambda1 afterSelectableUnsubscribe;
    public final AtomicLong incrementId;
    public SelectionManager$$ExternalSyntheticLambda1 onPositionChangeCallback;
    public SelectionManager$$ExternalSyntheticLambda1 onSelectableChangeCallback;
    public SelectionManager$$ExternalSyntheticLambda8 onSelectionUpdateCallback;
    public SelectionManager$$ExternalSyntheticLambda0 onSelectionUpdateEndCallback;
    public LazyListIntervalContent$$ExternalSyntheticLambda2 onSelectionUpdateStartCallback;
    public boolean sorted;
    public final ParcelableSnapshotMutableState subselections$delegate;

    public SelectionRegistrarImpl(long j) {
        MutableLongObjectMap mutableLongObjectMap = LongObjectMapKt.EmptyLongObjectMap;
        this._selectableMap = new MutableLongObjectMap();
        this.incrementId = new AtomicLong(j);
        this.subselections$delegate = Stack.mutableStateOf$default(LongObjectMapKt.EmptyLongObjectMap);
    }

    public final MutableLongObjectMap getSubselections() {
        return (MutableLongObjectMap) this.subselections$delegate.getValue();
    }

    /* JADX INFO: renamed from: notifySelectionUpdate-njBpvok, reason: not valid java name */
    public final boolean m222notifySelectionUpdatenjBpvok(LayoutCoordinates layoutCoordinates, long j, long j2, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0, boolean z) {
        SelectionManager$$ExternalSyntheticLambda8 selectionManager$$ExternalSyntheticLambda8 = this.onSelectionUpdateCallback;
        if (selectionManager$$ExternalSyntheticLambda8 == null) {
            return true;
        }
        SelectionManager selectionManager = selectionManager$$ExternalSyntheticLambda8.f$0;
        long jM219convertToContainerCoordinatesR5De75A = selectionManager.m219convertToContainerCoordinatesR5De75A(layoutCoordinates, j);
        long jM219convertToContainerCoordinatesR5De75A2 = selectionManager.m219convertToContainerCoordinatesR5De75A(layoutCoordinates, j2);
        selectionManager.setInTouchMode(z);
        return selectionManager.m220updateSelectionjyLRC_s$foundation(jM219convertToContainerCoordinatesR5De75A, jM219convertToContainerCoordinatesR5De75A2, false, selectionAdjustment$Companion$$ExternalSyntheticLambda0);
    }

    public final ArrayList sort(LayoutCoordinates layoutCoordinates) {
        boolean z = this.sorted;
        ArrayList arrayList = this._selectables;
        if (!z) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new SemanticsSortKt$$ExternalSyntheticLambda0(2, new Updater$$ExternalSyntheticLambda0(15, layoutCoordinates)));
            this.sorted = true;
        }
        return arrayList;
    }

    public final void unsubscribe(MultiWidgetSelectionDelegate multiWidgetSelectionDelegate) {
        long j = multiWidgetSelectionDelegate.selectableId;
        MutableLongObjectMap mutableLongObjectMap = this._selectableMap;
        if (mutableLongObjectMap.containsKey(j)) {
            this._selectables.remove(multiWidgetSelectionDelegate);
            long j2 = multiWidgetSelectionDelegate.selectableId;
            mutableLongObjectMap.remove(j2);
            SelectionManager$$ExternalSyntheticLambda1 selectionManager$$ExternalSyntheticLambda1 = this.afterSelectableUnsubscribe;
            if (selectionManager$$ExternalSyntheticLambda1 != null) {
                selectionManager$$ExternalSyntheticLambda1.invoke(Long.valueOf(j2));
            }
        }
    }
}
