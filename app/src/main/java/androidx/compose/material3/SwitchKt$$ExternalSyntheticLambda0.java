package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SwitchKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ SwitchKt$$ExternalSyntheticLambda0(boolean z, Function function, Modifier modifier, boolean z2, Object obj, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = z;
        this.f$1 = function;
        this.f$2 = modifier;
        this.f$4 = z2;
        this.f$5 = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                SwitchKt.Switch(this.f$0, (Function1) this.f$1, (Modifier) this.f$2, this.f$4, (SwitchColors) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                CheckboxKt.Checkbox(this.f$0, (Function1) this.f$1, (Modifier) this.f$2, this.f$4, (CheckboxColors) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 2:
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) this.f$1;
                TextFieldColors textFieldColors = (TextFieldColors) this.f$2;
                Shape shape = (Shape) this.f$5;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    OutlinedTextFieldDefaults.INSTANCE.m253Container4EFweAY(this.f$0, this.f$4, mutableInteractionSourceImpl, null, textFieldColors, shape, 0.0f, 0.0f, gapComposer, 100663296, 200);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                RadioButtonKt.RadioButton(this.f$0, (Function0) this.f$1, (Modifier) this.f$2, this.f$4, (RadioButtonColors) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ SwitchKt$$ExternalSyntheticLambda0(boolean z, boolean z2, MutableInteractionSourceImpl mutableInteractionSourceImpl, TextFieldColors textFieldColors, Shape shape) {
        this.$r8$classId = 2;
        this.f$0 = z;
        this.f$4 = z2;
        this.f$1 = mutableInteractionSourceImpl;
        this.f$2 = textFieldColors;
        this.f$5 = shape;
    }
}
