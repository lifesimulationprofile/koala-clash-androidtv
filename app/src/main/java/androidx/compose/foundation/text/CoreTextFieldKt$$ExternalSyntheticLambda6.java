package androidx.compose.foundation.text;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ int f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ KeyboardActions f$12;
    public final /* synthetic */ boolean f$13;
    public final /* synthetic */ ComposableLambdaImpl f$15;
    public final /* synthetic */ int f$17;
    public final /* synthetic */ int f$18;
    public final /* synthetic */ Modifier f$2;
    public final /* synthetic */ TextStyle f$3;
    public final /* synthetic */ ZslControlImpl$$ExternalSyntheticLambda0 f$4;
    public final /* synthetic */ Function1 f$5;
    public final /* synthetic */ MutableInteractionSourceImpl f$6;
    public final /* synthetic */ SolidColor f$7;
    public final /* synthetic */ boolean f$8;
    public final /* synthetic */ int f$9;

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda6(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, TextStyle textStyle, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0, Function1 function2, MutableInteractionSourceImpl mutableInteractionSourceImpl, SolidColor solidColor, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, ComposableLambdaImpl composableLambdaImpl, int i3, int i4) {
        this.f$0 = textFieldValue;
        this.f$1 = function1;
        this.f$2 = modifier;
        this.f$3 = textStyle;
        this.f$4 = zslControlImpl$$ExternalSyntheticLambda0;
        this.f$5 = function2;
        this.f$6 = mutableInteractionSourceImpl;
        this.f$7 = solidColor;
        this.f$8 = z;
        this.f$9 = i;
        this.f$10 = i2;
        this.f$11 = imeOptions;
        this.f$12 = keyboardActions;
        this.f$13 = z2;
        this.f$15 = composableLambdaImpl;
        this.f$17 = i3;
        this.f$18 = i4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(this.f$17 | 1);
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(this.f$18);
                BasicTextKt.CoreTextField((TextFieldValue) this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, (ImeOptions) this.f$11, this.f$12, this.f$13, this.f$15, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(this.f$17 | 1);
                BasicTextFieldKt.BasicTextField((String) this.f$0, this.f$1, this.f$2, this.f$8, this.f$3, (KeyboardOptions) this.f$11, this.f$12, this.f$13, this.f$9, this.f$10, this.f$4, this.f$5, this.f$6, this.f$7, this.f$15, (GapComposer) obj, iUpdateChangedFlags3, this.f$18);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda6(String str, Function1 function1, Modifier modifier, boolean z, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z2, int i, int i2, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0, Function1 function2, MutableInteractionSourceImpl mutableInteractionSourceImpl, SolidColor solidColor, ComposableLambdaImpl composableLambdaImpl, int i3, int i4) {
        this.f$0 = str;
        this.f$1 = function1;
        this.f$2 = modifier;
        this.f$8 = z;
        this.f$3 = textStyle;
        this.f$11 = keyboardOptions;
        this.f$12 = keyboardActions;
        this.f$13 = z2;
        this.f$9 = i;
        this.f$10 = i2;
        this.f$4 = zslControlImpl$$ExternalSyntheticLambda0;
        this.f$5 = function2;
        this.f$6 = mutableInteractionSourceImpl;
        this.f$7 = solidColor;
        this.f$15 = composableLambdaImpl;
        this.f$17 = i3;
        this.f$18 = i4;
    }
}
