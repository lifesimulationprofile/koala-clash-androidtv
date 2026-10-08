package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationResult {
    public final int endReason;
    public final AnimationState endState;

    public AnimationResult(AnimationState animationState, int i) {
        this.endState = animationState;
        this.endReason = i;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AnimationResult(endReason=");
        int i = this.endReason;
        if (i != 1) {
            str = i != 2 ? "null" : "Finished";
        } else {
            str = "BoundReached";
        }
        sb.append(str);
        sb.append(", endState=");
        sb.append(this.endState);
        sb.append(')');
        return sb.toString();
    }
}
