package androidx.activity.compose;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import io.github.g00fy2.quickie.content.QRContent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackHandlerKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ BackHandlerKt$$ExternalSyntheticLambda3(int i, int i2, Object obj, boolean z) {
        this.$r8$classId = i2;
        this.f$0 = z;
        this.f$1 = obj;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(this.f$2 | 1);
                BackHandlerKt.BackHandler(this.f$0, (Function0) this.f$1, (GapComposer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(this.f$2 | 1);
                QRContent.PredictiveBackHandler(this.f$0, (Function2) this.f$1, (GapComposer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(this.f$2 | 1);
                HomeScreenKt.ConnectionTimer(this.f$0, (Long) this.f$1, (GapComposer) obj, iUpdateChangedFlags3);
                break;
        }
        return Unit.INSTANCE;
    }
}
