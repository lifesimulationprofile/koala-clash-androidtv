package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ModalBottomSheetKt$$ExternalSyntheticLambda10 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ State f$0;

    public /* synthetic */ ModalBottomSheetKt$$ExternalSyntheticLambda10(State state, int i) {
        this.$r8$classId = i;
        this.f$0 = state;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        State state = this.f$0;
        switch (i) {
            case 0:
                return Float.valueOf(((Number) state.getValue()).floatValue());
            case 1:
                return new Offset(((Offset) state.getValue()).packedValue);
            case 2:
                AnimationVector2D animationVector2D = SelectionMagnifierKt.UnspecifiedAnimationVector2D;
                return new Offset(((Offset) state.getValue()).packedValue);
            case 3:
                return Boolean.valueOf((state != null ? ((Number) state.getValue()).floatValue() : 0.0f) > 0.0f);
            case 4:
                return Boolean.valueOf((state != null ? ((Number) state.getValue()).floatValue() : 0.0f) > 0.0f);
            case 5:
                return Float.valueOf(state != null ? ((Number) state.getValue()).floatValue() : 1.0f);
            case 6:
                return Float.valueOf(state != null ? ((Number) state.getValue()).floatValue() : 0.0f);
            default:
                return Float.valueOf(state != null ? ((Number) state.getValue()).floatValue() : 0.0f);
        }
    }
}
