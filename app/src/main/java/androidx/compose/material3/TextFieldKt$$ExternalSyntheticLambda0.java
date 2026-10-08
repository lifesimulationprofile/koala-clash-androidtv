package androidx.compose.material3;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 f$0;

    public /* synthetic */ TextFieldKt$$ExternalSyntheticLambda0(TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, int i) {
        this.$r8$classId = i;
        this.f$0 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return new Dp(MathHelpersKt.lerp(TextFieldImplKt.MinTextLineHeight, TextFieldImplKt.MinFocusedLabelLineHeight, this.f$0.invoke()));
    }
}
