package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ State f$0;
    public final /* synthetic */ State f$1;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda9(State state, State state2, int i) {
        this.$r8$classId = i;
        this.f$0 = state;
        this.f$1 = state2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                State state = this.f$0;
                reusableGraphicsLayerScope.setScaleX(((Number) state.getValue()).floatValue());
                reusableGraphicsLayerScope.setScaleY(((Number) state.getValue()).floatValue());
                reusableGraphicsLayerScope.setAlpha(((Number) this.f$1.getValue()).floatValue());
                break;
            default:
                DrawScope drawScope = (DrawScope) obj;
                float fMo92toPx0680j_4 = drawScope.mo92toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                State state2 = this.f$0;
                float f = 2;
                float f2 = fMo92toPx0680j_4 / f;
                Modifier.CC.m308drawCircleVaOC9Bg$default(drawScope, ((Color) state2.getValue()).value, drawScope.mo92toPx0680j_4(RadioButtonTokens.IconSize / f) - f2, 0L, new Stroke(fMo92toPx0680j_4, 0.0f, 0, 0, 30), 108);
                State state3 = this.f$1;
                if (Dp.m703compareTo0680j_4(((Dp) state3.getValue()).value, 0) > 0) {
                    Modifier.CC.m308drawCircleVaOC9Bg$default(drawScope, ((Color) state2.getValue()).value, drawScope.mo92toPx0680j_4(((Dp) state3.getValue()).value) - f2, 0L, Fill.INSTANCE, 108);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
