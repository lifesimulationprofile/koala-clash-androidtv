package androidx.compose.foundation.text;

import androidx.compose.foundation.lazy.LazyItemScope$CC;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HeightInLinesNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ HeightInLinesNode f$0;

    public /* synthetic */ HeightInLinesNode$$ExternalSyntheticLambda0(HeightInLinesNode heightInLinesNode, int i) {
        this.$r8$classId = i;
        this.f$0 = heightInLinesNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                if (this.f$0.fontResolutionState != null) {
                    return Unit.INSTANCE;
                }
                throw LazyItemScope$CC.m("Font resolution state is not set.");
            default:
                if (this.f$0.fontResolutionState != null) {
                    return Unit.INSTANCE;
                }
                throw LazyItemScope$CC.m("Font resolution state is not set.");
        }
    }
}
