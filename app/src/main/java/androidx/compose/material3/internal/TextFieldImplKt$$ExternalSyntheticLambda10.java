package androidx.compose.material3.internal;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldLabelPosition$Attached;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import com.google.android.gms.internal.mlkit_vision_common.zzjf;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldImplKt$$ExternalSyntheticLambda10 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Function f$3;

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda10(MutableState mutableState, TextFieldLabelPosition$Attached textFieldLabelPosition$Attached, PaddingValues paddingValues, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = mutableState;
        this.f$1 = textFieldLabelPosition$Attached;
        this.f$2 = paddingValues;
        this.f$3 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Function function = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (i) {
            case 0:
                MutableState mutableState = (MutableState) obj5;
                TextFieldLabelPosition$Attached textFieldLabelPosition$Attached = (TextFieldLabelPosition$Attached) obj4;
                PaddingValues paddingValues = (PaddingValues) obj3;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) function;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Modifier modifierLayoutId = RulerKt.layoutId(Modifier.Companion.$$INSTANCE, "Container");
                    TextFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1 textFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1 = new TextFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1(mutableState, MutableState.class, "value", "getValue()Ljava/lang/Object;", 0);
                    Alignment.Horizontal minimizedAlignment = TextFieldImplKt.getMinimizedAlignment(textFieldLabelPosition$Attached);
                    float f = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                    Modifier modifierDrawWithContent = ClipKt.drawWithContent(modifierLayoutId, new LifecycleEffectKt$$ExternalSyntheticLambda1(textFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1, paddingValues, minimizedAlignment, 12));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    long j = gapComposer.compositeKeyHashCode;
                    int i2 = (int) (j ^ (j >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierDrawWithContent);
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
                    Stack.m295setimpl(gapComposer, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    composableLambdaImpl.invoke((Object) gapComposer, (Object) 0);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                Modifier modifier = (Modifier) obj4;
                MutableState mutableState2 = (MutableState) obj5;
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) function;
                BasicTextContextMenuProvider basicTextContextMenuProvider = (BasicTextContextMenuProvider) obj3;
                GapComposer gapComposer2 = (GapComposer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new TooltipKt$$ExternalSyntheticLambda7(mutableState2, 5);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(modifier, (Function1) objRememberedValue);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    long j2 = gapComposer2.compositeKeyHashCode;
                    int i3 = (int) (j2 ^ (j2 >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierOnGloballyPositioned);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(layoutNode$Companion$Constructor$2);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                    composableLambdaImpl2.invoke((Object) gapComposer2, (Object) 0);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda0(mutableState2, 6);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    basicTextContextMenuProvider.ContextMenu((Function0) objRememberedValue2, gapComposer2, 6);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                zzjf.ShareToTvScreen((StateFlow) obj5, (StateFlow) obj4, (Function1) obj3, (Function0) function, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda10(Modifier modifier, MutableState mutableState, ComposableLambdaImpl composableLambdaImpl, BasicTextContextMenuProvider basicTextContextMenuProvider) {
        this.f$1 = modifier;
        this.f$0 = mutableState;
        this.f$3 = composableLambdaImpl;
        this.f$2 = basicTextContextMenuProvider;
    }

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda10(StateFlow stateFlow, StateFlow stateFlow2, Function1 function1, Function0 function0, int i) {
        this.f$0 = stateFlow;
        this.f$1 = stateFlow2;
        this.f$2 = function1;
        this.f$3 = function0;
    }
}
