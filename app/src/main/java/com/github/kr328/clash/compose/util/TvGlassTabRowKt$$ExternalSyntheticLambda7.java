package com.github.kr328.clash.compose.util;

import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvGlassTabRowKt$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ State f$0;

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda7(State state, int i) {
        this.$r8$classId = i;
        this.f$0 = state;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                State state = this.f$0;
                reusableGraphicsLayerScope.setScaleX(((Number) state.getValue()).floatValue());
                reusableGraphicsLayerScope.setScaleY(((Number) state.getValue()).floatValue());
                break;
            case 1:
                DrawScope drawScope = (DrawScope) obj;
                long j = ((Color) this.f$0.getValue()).value;
                if (!Color.m435equalsimpl0(j, Color.Unspecified)) {
                    Modifier.CC.m315drawRectnJ9OG0$default(drawScope, j, 0L, 0.0f, 0, 126);
                }
                break;
            default:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                State state2 = this.f$0;
                reusableGraphicsLayerScope2.setScaleX(((Number) state2.getValue()).floatValue());
                reusableGraphicsLayerScope2.setScaleY(((Number) state2.getValue()).floatValue());
                break;
        }
        return Unit.INSTANCE;
    }
}
