package androidx.compose.animation.core;

import com.github.kr328.clash.ShareToTvActivity$onCreate$1$list$1$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InfiniteTransition$run$1$1$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CoroutineScope f$0;

    public /* synthetic */ InfiniteTransition$run$1$1$$ExternalSyntheticLambda1(CoroutineScope coroutineScope, int i) {
        this.$r8$classId = i;
        this.f$0 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return Float.valueOf(ArcSplineKt.getDurationScale(this.f$0.getCoroutineContext()));
            default:
                JobKt.launch$default(this.f$0, null, new ShareToTvActivity$onCreate$1$list$1$1(2, null, 2), 3);
                return Unit.INSTANCE;
        }
    }
}
