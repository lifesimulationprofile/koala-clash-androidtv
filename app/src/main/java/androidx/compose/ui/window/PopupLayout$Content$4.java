package androidx.compose.ui.window;

import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.semantics.AppendedSemanticsElement;
import androidx.navigation.compose.DialogHostKt;
import androidx.navigation.compose.DialogNavigator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PopupLayout$Content$4 extends Lambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $tmp0_rcvr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PopupLayout$Content$4(int i, int i2, Object obj) {
        super(2);
        this.$r8$classId = i2;
        this.$tmp0_rcvr = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Number) obj2).intValue();
                ((PopupLayout) this.$tmp0_rcvr).Content$1(Stack.updateChangedFlags(1), (GapComposer) obj);
                return Unit.INSTANCE;
            case 1:
                EnterExitState enterExitState = (EnterExitState) obj;
                EnterExitState enterExitState2 = (EnterExitState) obj2;
                EnterExitState enterExitState3 = EnterExitState.PostExit;
                return Boolean.valueOf(enterExitState == enterExitState3 && enterExitState2 == enterExitState3 && !((ExitTransitionImpl) this.$tmp0_rcvr).data.hold);
            case 2:
                Modifier modifier = (Modifier) obj;
                Modifier modifierMaterializeImpl = (Modifier.Element) obj2;
                GapComposer gapComposer = (GapComposer) this.$tmp0_rcvr;
                if (modifierMaterializeImpl instanceof ComposedModifier) {
                    Function3 function3 = ((ComposedModifier) modifierMaterializeImpl).factory;
                    TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, function3);
                    modifierMaterializeImpl = AbsoluteAlignment.materializeImpl(gapComposer, (Modifier) function3.invoke(Modifier.Companion.$$INSTANCE, gapComposer, 0));
                }
                return modifier.then(modifierMaterializeImpl);
            case 3:
                GapComposer gapComposer2 = (GapComposer) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    List list = (List) this.$tmp0_rcvr;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        Function2 function2 = (Function2) list.get(i);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i2 = (int) (j ^ (j >>> 32));
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.VirtualConstructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
                        function2.invoke(gapComposer2, 0);
                        gapComposer2.end(true);
                    }
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 4:
                GapComposer gapComposer3 = (GapComposer) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    ((AbstractComposeView) this.$tmp0_rcvr).Content$1(0, gapComposer3);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 5:
                ((Number) obj2).intValue();
                ((ComposeView) this.$tmp0_rcvr).Content$1(Stack.updateChangedFlags(1), (GapComposer) obj);
                return Unit.INSTANCE;
            case 6:
                GapComposer gapComposer4 = (GapComposer) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                if (gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    Object objRememberedValue = gapComposer4.rememberedValue();
                    if (objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = AndroidPopup_androidKt$Popup$5$1$1.INSTANCE$1;
                        gapComposer4.updateRememberedValue(objRememberedValue);
                    }
                    AndroidDialog_androidKt.access$DialogLayout(new AppendedSemanticsElement((Function1) objRememberedValue, false), (Function2) ((MutableState) this.$tmp0_rcvr).getValue(), gapComposer4, 0);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 7:
                ((Number) obj2).intValue();
                ((DialogLayout) this.$tmp0_rcvr).Content$1(Stack.updateChangedFlags(1), (GapComposer) obj);
                return Unit.INSTANCE;
            default:
                ((Number) obj2).intValue();
                DialogHostKt.DialogHost((DialogNavigator) this.$tmp0_rcvr, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PopupLayout$Content$4(int i, Object obj) {
        super(2);
        this.$r8$classId = i;
        this.$tmp0_rcvr = obj;
    }
}
