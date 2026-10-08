package androidx.compose.foundation.text.selection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface MouseSelectionObserver {
    /* JADX INFO: renamed from: onDrag-3MmeM6k */
    boolean mo207onDrag3MmeM6k(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0);

    void onDragDone();

    /* JADX INFO: renamed from: onExtend-k-4lQ0M */
    boolean mo208onExtendk4lQ0M(long j);

    /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M */
    boolean mo209onExtendDragk4lQ0M(long j);

    /* JADX INFO: renamed from: onStart-9KIMszo */
    boolean mo210onStart9KIMszo(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0, int i);
}
