package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.PopupPositionProvider;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$10;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Modifier f$3;
    public final /* synthetic */ boolean f$6;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ int f$9;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda4(PopupPositionProvider popupPositionProvider, ComposableLambdaImpl composableLambdaImpl, TooltipStateImpl tooltipStateImpl, Modifier modifier, boolean z, Function2 function2, int i, int i2) {
        this.f$0 = popupPositionProvider;
        this.f$1 = composableLambdaImpl;
        this.f$2 = tooltipStateImpl;
        this.f$3 = modifier;
        this.f$6 = z;
        this.f$8 = function2;
        this.f$9 = i;
        this.f$10 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                TooltipKt.TooltipBox((PopupPositionProvider) this.f$0, (ComposableLambdaImpl) this.f$1, (TooltipStateImpl) this.f$2, this.f$3, this.f$6, (Function2) this.f$8, (GapComposer) obj, Stack.updateChangedFlags(this.f$9 | 1), this.f$10);
                break;
            case 1:
                ((Integer) obj2).getClass();
                ScrimKt.IconButton((Function0) this.f$0, this.f$3, this.f$6, (IconButtonColors) this.f$2, (Shape) this.f$8, (ComposableLambdaImpl) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(this.f$9 | 1), this.f$10);
                break;
            default:
                ((Integer) obj2).getClass();
                zzjb.AppList((List) this.f$0, (Set) this.f$1, (Function1) this.f$2, (PaddingValuesImpl) this.f$8, this.f$3, this.f$6, (GapComposer) obj, Stack.updateChangedFlags(this.f$9 | 1), this.f$10);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda4(List list, Set set, Function1 function1, PaddingValuesImpl paddingValuesImpl, Modifier modifier, boolean z, int i, int i2) {
        this.f$0 = list;
        this.f$1 = set;
        this.f$2 = function1;
        this.f$8 = paddingValuesImpl;
        this.f$3 = modifier;
        this.f$6 = z;
        this.f$9 = i;
        this.f$10 = i2;
    }

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda4(Function0 function0, Modifier modifier, boolean z, IconButtonColors iconButtonColors, Shape shape, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$0 = function0;
        this.f$3 = modifier;
        this.f$6 = z;
        this.f$2 = iconButtonColors;
        this.f$8 = shape;
        this.f$1 = composableLambdaImpl;
        this.f$9 = i;
        this.f$10 = i2;
    }
}
