package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Recomposer$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Recomposer f$0;

    public /* synthetic */ Recomposer$$ExternalSyntheticLambda1(Recomposer recomposer, int i) {
        this.$r8$classId = i;
        this.f$0 = recomposer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.onNewFrameAwaiter();
                break;
            default:
                this.f$0.onNewFrameAwaiter();
                break;
        }
        return Unit.INSTANCE;
    }
}
