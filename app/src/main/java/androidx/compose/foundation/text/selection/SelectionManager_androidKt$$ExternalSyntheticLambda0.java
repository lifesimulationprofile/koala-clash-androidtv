package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionManager_androidKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ SelectionManager_androidKt$$ExternalSyntheticLambda0(Function0 function0, Function0 function1, int i) {
        this.$r8$classId = i;
        this.f$0 = function0;
        this.f$1 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TextContextMenuSession textContextMenuSession = (TextContextMenuSession) obj;
        switch (this.$r8$classId) {
            case 0:
                this.f$0.invoke();
                Function0 function0 = this.f$1;
                if (function0 != null ? ((Boolean) function0.invoke()).booleanValue() : true) {
                    textContextMenuSession.close();
                }
                break;
            default:
                this.f$0.invoke();
                Function0 function1 = this.f$1;
                if (function1 != null ? ((Boolean) function1.invoke()).booleanValue() : true) {
                    textContextMenuSession.close();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
