package androidx.compose.ui.focus;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.ui.platform.AndroidComposeView;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusInvalidationManager {
    public final MutableScatterSet focusEventNodes;
    public final FocusOwnerImpl focusOwner;
    public final MutableScatterSet focusTargetNodes;
    public boolean isInvalidationScheduled;
    public final AndroidComposeView owner;

    public FocusInvalidationManager(FocusOwnerImpl focusOwnerImpl, AndroidComposeView androidComposeView) {
        this.focusOwner = focusOwnerImpl;
        this.owner = androidComposeView;
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.focusTargetNodes = new MutableScatterSet();
        this.focusEventNodes = new MutableScatterSet();
    }

    public final void scheduleInvalidation$2() {
        if (this.isInvalidationScheduled) {
            return;
        }
        FocusableNode.AnonymousClass1 anonymousClass1 = new FocusableNode.AnonymousClass1(0, this, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0, 0, 2);
        MutableObjectList mutableObjectList = this.owner.endApplyChangesListeners;
        if (mutableObjectList.indexOf(anonymousClass1) < 0) {
            mutableObjectList.add(anonymousClass1);
        }
        this.isInvalidationScheduled = true;
    }
}
