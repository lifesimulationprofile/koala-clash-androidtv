package dev.chrisbanes.haze;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HazeState {
    public final SnapshotStateList _areas = new SnapshotStateList();
    public final ParcelableSnapshotMutableState blurEnabled$delegate;

    public HazeState(boolean z) {
        this.blurEnabled$delegate = Stack.mutableStateOf$default(Boolean.valueOf(z));
    }
}
