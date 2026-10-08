package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableTransitionState extends Lifecycle {
    public final ParcelableSnapshotMutableState currentState$delegate;
    public final ParcelableSnapshotMutableState targetState$delegate;

    public MutableTransitionState(Object obj) {
        super(2);
        this.currentState$delegate = Stack.mutableStateOf$default(obj);
        this.targetState$delegate = Stack.mutableStateOf$default(obj);
    }

    @Override // androidx.lifecycle.Lifecycle
    /* JADX INFO: renamed from: getCurrentState */
    public final Object mo773getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void setCurrentState$animation_core(Object obj) {
        this.currentState$delegate.setValue(obj);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void transitionRemoved$animation_core() {
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void transitionConfigured$animation_core(Transition transition) {
    }
}
