package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.semantics.AppendedSemanticsElement;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.unit.IntRect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidMenu_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ AndroidMenu_androidKt$$ExternalSyntheticLambda0(MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = mutableState;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d6  */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        float fMin;
        int i = this.$r8$classId;
        MutableState mutableState = this.f$0;
        switch (i) {
            case 0:
                IntRect intRect = (IntRect) obj;
                IntRect intRect2 = (IntRect) obj2;
                float f = MenuKt.MenuVerticalMargin;
                int i2 = intRect2.left;
                int i3 = intRect2.bottom;
                int i4 = intRect2.right;
                int i5 = intRect2.top;
                int i6 = intRect.right;
                int i7 = intRect.top;
                int i8 = intRect.bottom;
                int i9 = intRect.left;
                float fMin2 = 1.0f;
                if (i2 >= i6) {
                    fMin = 0.0f;
                } else if (i4 <= i9) {
                    fMin = 1.0f;
                } else if (intRect2.getWidth() == 0) {
                    fMin = 0.0f;
                } else {
                    fMin = (((Math.min(intRect.right, i4) + Math.max(i9, i2)) / 2) - i2) / intRect2.getWidth();
                }
                if (i5 >= i8) {
                    fMin2 = 0.0f;
                } else if (i3 > i7) {
                    if (intRect2.getHeight() == 0) {
                        fMin2 = 0.0f;
                    } else {
                        fMin2 = (((Math.min(i8, i3) + Math.max(i7, i5)) / 2) - i5) / intRect2.getHeight();
                    }
                }
                mutableState.setValue(new TransformOrigin(BrushKt.TransformOrigin(fMin, fMin2)));
                break;
            default:
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new SaversKt$$ExternalSyntheticLambda10(11);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    AppendedSemanticsElement appendedSemanticsElement = new AppendedSemanticsElement((Function1) objRememberedValue, false);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    long j = gapComposer.compositeKeyHashCode;
                    int i10 = (int) (j ^ (j >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, appendedSemanticsElement);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m295setimpl(gapComposer, Integer.valueOf(i10), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    ((Function2) mutableState.getValue()).invoke(gapComposer, 0);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
