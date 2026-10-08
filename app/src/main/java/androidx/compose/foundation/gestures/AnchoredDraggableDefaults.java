package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnchoredDraggableDefaults {
    public static final TweenSpec SnapAnimationSpec = ArcSplineKt.tween$default(0, 7, null);
    public static final BorderKt$$ExternalSyntheticLambda1 PositionalThreshold = new BorderKt$$ExternalSyntheticLambda1(26);
    public static final DecayAnimationSpecImpl DecayAnimationSpec = ArcSplineKt.exponentialDecay$default();
}
