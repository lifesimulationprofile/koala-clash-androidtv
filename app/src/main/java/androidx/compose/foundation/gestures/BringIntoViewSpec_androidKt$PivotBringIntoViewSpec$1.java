package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SpringSpec;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1 implements BringIntoViewSpec {
    public final /* synthetic */ int $r8$classId;

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public final float calculateScrollDistance(float f, float f2, float f3) {
        switch (this.$r8$classId) {
            case 0:
                float fAbs = Math.abs((f2 + f) - f);
                float f4 = (0.3f * f3) - (0.0f * fAbs);
                float f5 = f3 - f4;
                if ((fAbs <= f3) && f5 < fAbs) {
                    f4 = f3 - fAbs;
                }
                return f - f4;
            default:
                BringIntoViewSpec.Companion.getClass();
                float f6 = f2 + f;
                if ((f >= 0.0f && f6 <= f3) || (f < 0.0f && f6 > f3)) {
                    return 0.0f;
                }
                float f7 = f6 - f3;
                return Math.abs(f) < Math.abs(f7) ? f : f7;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public final SpringSpec getScrollAnimationSpec() {
        switch (this.$r8$classId) {
        }
        BringIntoViewSpec.Companion.getClass();
        return BringIntoViewSpec.Companion.DefaultScrollAnimationSpec;
    }
}
