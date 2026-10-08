package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationResult {
    public final AnimationState currentAnimationState;
    public final Float remainingOffset;

    public AnimationResult(Float f, AnimationState animationState) {
        this.remainingOffset = f;
        this.currentAnimationState = animationState;
    }
}
