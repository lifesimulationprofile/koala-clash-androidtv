package androidx.compose.animation;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentKt$SizeTransform$1 extends Lambda implements Function2 {
    public static final AnimatedContentKt$SizeTransform$1 INSTANCE;
    public static final AnimatedContentKt$SizeTransform$1 INSTANCE$1;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 2;
        INSTANCE = new AnimatedContentKt$SizeTransform$1(i, 0);
        INSTANCE$1 = new AnimatedContentKt$SizeTransform$1(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnimatedContentKt$SizeTransform$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                long j = ((IntSize) obj).packedValue;
                long j2 = ((IntSize) obj2).packedValue;
                long j3 = 1;
                return ArcSplineKt.spring$default(0.0f, 400.0f, new IntSize((j3 & 4294967295L) | (j3 << 32)), 1);
            default:
                EnterExitState enterExitState = (EnterExitState) obj2;
                return Boolean.valueOf(((EnterExitState) obj) == enterExitState && enterExitState == EnterExitState.PostExit);
        }
    }
}
