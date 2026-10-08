package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.platform.AndroidComposeView$snapshotObserver$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OwnerSnapshotObserver {
    public final SnapshotStateObserver observer;
    public final OwnerSnapshotObserver$onCommitAffectingLayout$1 onCommitAffectingLookaheadMeasure = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$9;
    public final OwnerSnapshotObserver$onCommitAffectingLayout$1 onCommitAffectingMeasure = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$10;
    public final OwnerSnapshotObserver$onCommitAffectingLayout$1 onCommitAffectingSemantics = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$11;
    public final OwnerSnapshotObserver$onCommitAffectingLayout$1 onCommitAffectingLayout = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE;
    public final OwnerSnapshotObserver$onCommitAffectingLayout$1 onCommitAffectingLayoutModifier = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$6;
    public final OwnerSnapshotObserver$onCommitAffectingLayout$1 onCommitAffectingLayoutModifierInLookahead = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$7;
    public final OwnerSnapshotObserver$onCommitAffectingLayout$1 onCommitAffectingLookahead = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$8;

    public OwnerSnapshotObserver(AndroidComposeView$snapshotObserver$1 androidComposeView$snapshotObserver$1) {
        this.observer = new SnapshotStateObserver(androidComposeView$snapshotObserver$1);
    }
}
