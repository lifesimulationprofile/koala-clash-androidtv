package com.github.kr328.clash.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.google.android.gms.internal.mlkit_vision_common.zzjm;
import dev.chrisbanes.haze.HazeState;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProvidersScreenKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Function f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Modifier f$4;

    public /* synthetic */ ProvidersScreenKt$$ExternalSyntheticLambda0(Modifier modifier, MutableState mutableState, ComposableLambdaImpl composableLambdaImpl, BasicTextContextMenuProvider basicTextContextMenuProvider, Function0 function0) {
        this.f$4 = modifier;
        this.f$0 = mutableState;
        this.f$1 = composableLambdaImpl;
        this.f$3 = basicTextContextMenuProvider;
        this.f$2 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                ProvidersScreenKt.ProvidersScreen((List) this.f$0, (Function1) this.f$1, (Function0) this.f$2, (Function0) this.f$3, this.f$4, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 1:
                MutableState mutableState = (MutableState) this.f$0;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
                BasicTextContextMenuProvider basicTextContextMenuProvider = (BasicTextContextMenuProvider) this.f$3;
                Function0 function0 = (Function0) this.f$2;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 4);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(this.f$4, (Function1) objRememberedValue);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    long j = gapComposer.compositeKeyHashCode;
                    int i = (int) (j ^ (j >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierOnGloballyPositioned);
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
                    Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    composableLambdaImpl.invoke((Object) gapComposer, (Object) 0);
                    basicTextContextMenuProvider.ContextMenu(function0, gapComposer, 6);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                zzjm.LiquidGlassNavBar((List) this.f$0, (String) this.f$2, (Function1) this.f$1, this.f$4, (HazeState) this.f$3, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ProvidersScreenKt$$ExternalSyntheticLambda0(List list, String str, Function1 function1, Modifier modifier, HazeState hazeState, int i) {
        this.f$0 = list;
        this.f$2 = str;
        this.f$1 = function1;
        this.f$4 = modifier;
        this.f$3 = hazeState;
    }

    public /* synthetic */ ProvidersScreenKt$$ExternalSyntheticLambda0(List list, Function1 function1, Function0 function0, Function0 function2, Modifier modifier, int i) {
        this.f$0 = list;
        this.f$1 = function1;
        this.f$2 = function0;
        this.f$3 = function2;
        this.f$4 = modifier;
    }
}
