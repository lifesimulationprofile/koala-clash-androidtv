package androidx.compose.foundation.style;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableStyleState {
    public final MutableInteractionSourceImpl interactionSource;
    public final SnapshotStateMap customStates = new SnapshotStateMap();
    public final ParcelableSnapshotMutableIntState predefinedState$delegate = new ParcelableSnapshotMutableIntState(16);

    public MutableStyleState(MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        this.interactionSource = mutableInteractionSourceImpl;
    }

    public final void setFocused(boolean z) {
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.predefinedState$delegate;
        parcelableSnapshotMutableIntState.setIntValue((z ? 4 : 0) | (parcelableSnapshotMutableIntState.getIntValue() & (-5)));
    }

    public final void setHovered(boolean z) {
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.predefinedState$delegate;
        parcelableSnapshotMutableIntState.setIntValue((z ? 2 : 0) | (parcelableSnapshotMutableIntState.getIntValue() & (-3)));
    }

    public final void setPressed(boolean z) {
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.predefinedState$delegate;
        parcelableSnapshotMutableIntState.setIntValue((z ? 1 : 0) | (parcelableSnapshotMutableIntState.getIntValue() & (-2)));
    }
}
