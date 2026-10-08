package androidx.compose.material3;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.internal.TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import coil.network.HttpException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OutlinedTextFieldKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ Object f$12;
    public final /* synthetic */ Function1 f$13;
    public final /* synthetic */ ComposableLambdaImpl f$14;
    public final /* synthetic */ Object f$15;
    public final /* synthetic */ Object f$16;
    public final /* synthetic */ int f$17;
    public final /* synthetic */ int f$18;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ boolean f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ OutlinedTextFieldKt$$ExternalSyntheticLambda1(ComposableLambdaImpl composableLambdaImpl, LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, int i2, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequesterImpl bringIntoViewRequesterImpl, TextFieldSelectionManager textFieldSelectionManager, boolean z, Function1 function1, OffsetMapping offsetMapping, Density density) {
        this.f$14 = composableLambdaImpl;
        this.f$1 = legacyTextFieldState;
        this.f$3 = textStyle;
        this.f$17 = i;
        this.f$18 = i2;
        this.f$4 = textFieldScrollerPosition;
        this.f$5 = textFieldValue;
        this.f$6 = zslControlImpl$$ExternalSyntheticLambda0;
        this.f$7 = modifier;
        this.f$15 = modifier2;
        this.f$2 = modifier3;
        this.f$9 = modifier4;
        this.f$10 = bringIntoViewRequesterImpl;
        this.f$11 = textFieldSelectionManager;
        this.f$8 = z;
        this.f$13 = function1;
        this.f$12 = offsetMapping;
        this.f$16 = density;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                OutlinedTextFieldKt.OutlinedTextFieldLayout((Function2) this.f$1, (Function3) this.f$2, (Function2) this.f$3, (Function2) this.f$4, (Function2) this.f$5, (Function2) this.f$6, (Function2) this.f$7, this.f$8, (TextFieldLabelPosition$Attached) this.f$9, (TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) this.f$10, (TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) this.f$11, (TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) this.f$12, this.f$13, this.f$14, (Function2) this.f$15, (PaddingValues) this.f$16, (GapComposer) obj, Stack.updateChangedFlags(this.f$17 | 1), Stack.updateChangedFlags(this.f$18));
                break;
            default:
                final LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.f$1;
                final TextStyle textStyle = (TextStyle) this.f$3;
                final TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) this.f$4;
                final TextFieldValue textFieldValue = (TextFieldValue) this.f$5;
                final ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0 = (ZslControlImpl$$ExternalSyntheticLambda0) this.f$6;
                final Modifier modifier = (Modifier) this.f$7;
                final Modifier modifier2 = (Modifier) this.f$15;
                final Modifier modifier3 = (Modifier) this.f$2;
                final Modifier modifier4 = (Modifier) this.f$9;
                final BringIntoViewRequesterImpl bringIntoViewRequesterImpl = (BringIntoViewRequesterImpl) this.f$10;
                final TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.f$11;
                final OffsetMapping offsetMapping = (OffsetMapping) this.f$12;
                final Density density = (Density) this.f$16;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    final int i = this.f$17;
                    final int i2 = this.f$18;
                    final boolean z = this.f$8;
                    final Function1 function1 = this.f$13;
                    this.f$14.invoke((Object) Thread_jvmKt.rememberComposableLambda(-44346382, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            Modifier verticalScrollLayoutModifier;
                            TextFieldValue textFieldValue2 = textFieldValue;
                            long j = textFieldValue2.selection;
                            GapComposer gapComposer2 = (GapComposer) obj3;
                            int iIntValue2 = ((Integer) obj4).intValue();
                            if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                Modifier modifierThen = Modifier.Companion.$$INSTANCE.then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : ((Dp) legacyTextFieldState2.minHeightForSingleLineField$delegate.getValue()).value, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5));
                                int i3 = i;
                                int i4 = i2;
                                BasicTextKt.validateMinMaxLines(i3, i4);
                                TextStyle textStyle2 = textStyle;
                                if (i3 != 1 || i4 != Integer.MAX_VALUE) {
                                    modifierThen = modifierThen.then(new HeightInLinesElement(textStyle2, i3, i4));
                                }
                                boolean zChangedInstance = gapComposer2.changedInstance(legacyTextFieldState2);
                                Object objRememberedValue = gapComposer2.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                                    objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda0(9, legacyTextFieldState2);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                Function0 function0 = (Function0) objRememberedValue;
                                TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                Orientation orientation = (Orientation) textFieldScrollerPosition2.orientation$delegate.getValue();
                                int i5 = TextRange.$r8$clinit;
                                int iM644getMinimpl = (int) (j >> 32);
                                long j2 = textFieldScrollerPosition2.previousSelection;
                                Modifier modifier5 = modifierThen;
                                if (iM644getMinimpl == ((int) (j2 >> 32)) && (iM644getMinimpl = (int) (j & 4294967295L)) == ((int) (4294967295L & j2))) {
                                    iM644getMinimpl = TextRange.m644getMinimpl(j);
                                }
                                textFieldScrollerPosition2.previousSelection = j;
                                TransformedText transformedTextFilterWithValidation = BasicTextKt.filterWithValidation(zslControlImpl$$ExternalSyntheticLambda0, textFieldValue2.annotatedString);
                                int iOrdinal = orientation.ordinal();
                                if (iOrdinal == 0) {
                                    verticalScrollLayoutModifier = new VerticalScrollLayoutModifier(textFieldScrollerPosition2, iM644getMinimpl, transformedTextFilterWithValidation, function0);
                                } else {
                                    if (iOrdinal != 1) {
                                        throw new HttpException();
                                    }
                                    verticalScrollLayoutModifier = new HorizontalScrollLayoutModifier(textFieldScrollerPosition2, iM644getMinimpl, transformedTextFilterWithValidation, function0);
                                }
                                SimpleLayoutKt.SimpleLayout(BringIntoViewRequesterKt.bringIntoViewRequester(ClipKt.clipToBounds(modifier5).then(verticalScrollLayoutModifier).then(modifier).then(modifier2).then(new TextFieldSizeElement(textStyle2)).then(modifier3).then(modifier4), bringIntoViewRequesterImpl), Thread_jvmKt.rememberComposableLambda(1412697320, new CheckboxKt$$ExternalSyntheticLambda2(textFieldSelectionManager, legacyTextFieldState2, z, function1, textFieldValue2, offsetMapping, density, i4), gapComposer2), gapComposer2, 48);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), (Object) gapComposer, (Object) 6);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ OutlinedTextFieldKt$$ExternalSyntheticLambda1(Function2 function2, Function3 function3, Function2 function4, Function2 function5, Function2 function6, Function2 function7, Function2 function8, boolean z, TextFieldLabelPosition$Attached textFieldLabelPosition$Attached, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, Function1 function1, ComposableLambdaImpl composableLambdaImpl, Function2 function9, PaddingValues paddingValues, int i, int i2) {
        this.f$1 = function2;
        this.f$2 = function3;
        this.f$3 = function4;
        this.f$4 = function5;
        this.f$5 = function6;
        this.f$6 = function7;
        this.f$7 = function8;
        this.f$8 = z;
        this.f$9 = textFieldLabelPosition$Attached;
        this.f$10 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
        this.f$11 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1;
        this.f$12 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2;
        this.f$13 = function1;
        this.f$14 = composableLambdaImpl;
        this.f$15 = function9;
        this.f$16 = paddingValues;
        this.f$17 = i;
        this.f$18 = i2;
    }
}
