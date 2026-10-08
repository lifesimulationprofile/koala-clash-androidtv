package androidx.compose.material3;

import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.window.PopupPositionProvider;
import com.github.kr328.clash.compose.PropertiesScreenKt;
import com.github.kr328.clash.design.compose.components.ControlButtonState;
import com.google.android.gms.internal.mlkit_vision_common.zzjk;
import dev.chrisbanes.haze.HazeState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CheckboxKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ int $r8$classId = 2;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ int f$6;

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(Modifier modifier, Function0 function0, boolean z, Shape shape, IconButtonColors iconButtonColors, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$2 = modifier;
        this.f$1 = function0;
        this.f$0 = z;
        this.f$3 = shape;
        this.f$4 = iconButtonColors;
        this.f$5 = composableLambdaImpl;
        this.f$6 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                CheckboxKt.CheckboxImpl(this.f$0, (ToggleableState) this.f$1, (Modifier) this.f$2, (CheckboxColors) this.f$3, (Stroke) this.f$4, (Stroke) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(this.f$6 | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                ContextMenuUiKt.ContextMenuItem((String) this.f$1, this.f$0, (ContextMenuColors) this.f$3, (Modifier) this.f$2, (Function3) this.f$4, (Function0) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(this.f$6 | 1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                ScrimKt.IconButtonImpl((Modifier) this.f$2, (Function0) this.f$1, this.f$0, (Shape) this.f$3, (IconButtonColors) this.f$4, (ComposableLambdaImpl) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(this.f$6 | 1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                LayoutUtilKt.TooltipPopup((PopupPositionProvider) this.f$1, (TooltipStateImpl) this.f$2, (CoroutineScope) this.f$3, this.f$0, (MutableState) this.f$4, (ComposableLambdaImpl) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(this.f$6 | 1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                PropertiesScreenKt.FieldRow((ImageVector) this.f$1, (String) this.f$2, (String) this.f$3, (String) this.f$4, this.f$0, (Function0) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(this.f$6 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                zzjk.ControlButton((ControlButtonState) this.f$1, (Function0) this.f$3, (Function0) this.f$4, (Modifier) this.f$2, (HazeState) this.f$5, this.f$0, (GapComposer) obj, Stack.updateChangedFlags(this.f$6 | 1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(ImageVector imageVector, String str, String str2, String str3, boolean z, Function0 function0, int i) {
        this.f$1 = imageVector;
        this.f$2 = str;
        this.f$3 = str2;
        this.f$4 = str3;
        this.f$0 = z;
        this.f$5 = function0;
        this.f$6 = i;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(PopupPositionProvider popupPositionProvider, TooltipStateImpl tooltipStateImpl, CoroutineScope coroutineScope, boolean z, MutableState mutableState, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$1 = popupPositionProvider;
        this.f$2 = tooltipStateImpl;
        this.f$3 = coroutineScope;
        this.f$0 = z;
        this.f$4 = mutableState;
        this.f$5 = composableLambdaImpl;
        this.f$6 = i;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(ControlButtonState controlButtonState, Function0 function0, Function0 function1, Modifier modifier, HazeState hazeState, boolean z, int i) {
        this.f$1 = controlButtonState;
        this.f$3 = function0;
        this.f$4 = function1;
        this.f$2 = modifier;
        this.f$5 = hazeState;
        this.f$0 = z;
        this.f$6 = i;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(String str, boolean z, ContextMenuColors contextMenuColors, Modifier modifier, Function3 function3, Function0 function0, int i) {
        this.f$1 = str;
        this.f$0 = z;
        this.f$3 = contextMenuColors;
        this.f$2 = modifier;
        this.f$4 = function3;
        this.f$5 = function0;
        this.f$6 = i;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda4(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Stroke stroke, Stroke stroke2, int i) {
        this.f$0 = z;
        this.f$1 = toggleableState;
        this.f$2 = modifier;
        this.f$3 = checkboxColors;
        this.f$4 = stroke;
        this.f$5 = stroke2;
        this.f$6 = i;
    }
}
