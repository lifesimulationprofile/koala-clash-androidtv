package androidx.compose.ui.layout;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class WindowWindowInsetsAnimationValues {
    public final RectRulersImpl source;
    public final RectRulersImpl target;
    public final ParcelableSnapshotMutableState isVisible$delegate = Stack.mutableStateOf$default(Boolean.TRUE);
    public final ParcelableSnapshotMutableState isAnimating$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public final ParcelableSnapshotMutableFloatState fraction$delegate = new ParcelableSnapshotMutableFloatState(0.0f);
    public final ParcelableSnapshotMutableLongState durationMillis$delegate = new ParcelableSnapshotMutableLongState(0);
    public final ParcelableSnapshotMutableFloatState alpha$delegate = new ParcelableSnapshotMutableFloatState(1.0f);
    public long current = -1;
    public long maximum = -1;
    public long sourceValueInsets = -1;
    public long targetValueInsets = -1;

    public WindowWindowInsetsAnimationValues(String str) {
        this.source = new RectRulersImpl(str.concat(" source"));
        this.target = new RectRulersImpl(str.concat(" target"));
    }
}
