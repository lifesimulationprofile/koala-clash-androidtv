package androidx.compose.material3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarHostKt$$ExternalSyntheticLambda6 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SnackbarHostState.SnackbarDataImpl f$0;

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda6(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, int i) {
        this.$r8$classId = i;
        this.f$0 = snackbarDataImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.dismiss();
                return Boolean.TRUE;
            default:
                this.f$0.dismiss();
                return Unit.INSTANCE;
        }
    }
}
