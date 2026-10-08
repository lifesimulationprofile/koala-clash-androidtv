package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface BringIntoViewSpec {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final SpringSpec DefaultScrollAnimationSpec = ArcSplineKt.spring$default(0.0f, 0.0f, null, 7);
        public static final BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1 DefaultBringIntoViewSpec = new BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1(1);
    }

    float calculateScrollDistance(float f, float f2, float f3);

    SpringSpec getScrollAnimationSpec();
}
