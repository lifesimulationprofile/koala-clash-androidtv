package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ Shape f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ float f$3;
    public final /* synthetic */ float f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ SurfaceKt$$ExternalSyntheticLambda0(BottomSheetDefaults bottomSheetDefaults, Modifier modifier, float f, float f2, Shape shape, long j, int i) {
        this.f$6 = bottomSheetDefaults;
        this.f$0 = modifier;
        this.f$3 = f;
        this.f$5 = f2;
        this.f$1 = shape;
        this.f$2 = j;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$6;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Modifier modifierM270surfaceXOJAsU = SurfaceKt.m270surfaceXOJAsU(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(this.f$5), SurfaceKt.m271surfaceColorAtElevationCLU3JFs(this.f$2, this.f$3, gapComposer), this.f$0, this.f$1);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SaversKt$$ExternalSyntheticLambda10(14);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM270surfaceXOJAsU, false, (Function1) objRememberedValue);
                    Unit unit = Unit.INSTANCE;
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = SurfaceKt$Surface$1$3$1.INSTANCE;
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics, unit, (PointerInputEventHandler) objRememberedValue2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    long j = gapComposer.compositeKeyHashCode;
                    int i = (int) (j ^ (j >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierPointerInput);
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
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                ((BottomSheetDefaults) this.f$6).m240DragHandlelgZ2HuY(this.f$0, this.f$3, this.f$5, this.f$1, this.f$2, (GapComposer) obj, Stack.updateChangedFlags(196609));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ SurfaceKt$$ExternalSyntheticLambda0(Modifier modifier, Shape shape, long j, float f, float f2, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = modifier;
        this.f$1 = shape;
        this.f$2 = j;
        this.f$3 = f;
        this.f$5 = f2;
        this.f$6 = composableLambdaImpl;
    }
}
