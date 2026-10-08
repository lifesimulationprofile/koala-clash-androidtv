package androidx.compose.material3.internal;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.TextStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldImplKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ TextStyle f$1;
    public final /* synthetic */ Function2 f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda2(long j, TextStyle textStyle, Function2 function2, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = j;
        this.f$1 = textStyle;
        this.f$2 = function2;
        this.f$3 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                TextFieldImplKt.m283Decoration3JVO9M(this.f$0, this.f$1, this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
            default:
                ((Integer) obj2).intValue();
                LayoutUtilKt.m281ProvideContentColorTextStyle3JVO9M(this.f$0, this.f$1, this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
        }
        return Unit.INSTANCE;
    }
}
