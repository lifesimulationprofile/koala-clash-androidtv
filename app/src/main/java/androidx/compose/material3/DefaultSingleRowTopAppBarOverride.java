package androidx.compose.material3;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Center$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapPending$keyMap$2;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.text.TextStyle;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda7;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultSingleRowTopAppBarOverride {
    public static final DefaultSingleRowTopAppBarOverride INSTANCE = new DefaultSingleRowTopAppBarOverride();

    public final void SingleRowTopAppBar(final SingleRowTopAppBarOverrideScope singleRowTopAppBarOverrideScope, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        float f = singleRowTopAppBarOverrideScope.expandedHeight;
        gapComposer2.startRestartGroup(2137486921);
        int i2 = i | (gapComposer2.changed(singleRowTopAppBarOverrideScope) ? 4 : 2);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            TopAppBarColors topAppBarColors = singleRowTopAppBarOverrideScope.colors;
            if (Float.isNaN(f) || (Float.floatToRawIntBits(f) & Integer.MAX_VALUE) >= 2139095040) {
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite");
            }
            boolean zChanged = gapComposer2.changed(topAppBarColors) | gapComposer2.changed((Object) null);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.derivedStateOf(new GapPending$keyMap$2(1, singleRowTopAppBarOverrideScope));
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            State stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(((Color) ((State) objRememberedValue).getValue()).value, ScrimKt.value(4, gapComposer2), null, gapComposer2, 0, 12);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-1658896622, new Updater$$ExternalSyntheticLambda0(18, singleRowTopAppBarOverrideScope), gapComposer2);
            gapComposer2.startReplaceGroup(690075377);
            gapComposer2.end(false);
            Modifier modifier = singleRowTopAppBarOverrideScope.modifier;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierThen = modifier.then(companion);
            boolean zChanged2 = gapComposer2.changed(stateM26animateColorAsStateeuL9pac);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TvGlassTabRowKt$$ExternalSyntheticLambda7(stateM26animateColorAsStateeuL9pac, 1);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierDrawBehind = ClipKt.drawBehind(modifierThen, (Function1) objRememberedValue2);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new SaversKt$$ExternalSyntheticLambda10(8);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierDrawBehind, false, (Function1) objRememberedValue3);
            Unit unit = Unit.INSTANCE;
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = SurfaceKt$Surface$1$3$1.INSTANCE$1;
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics, unit, (PointerInputEventHandler) objRememberedValue4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPointerInput);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Modifier modifierClipToBounds = ClipKt.clipToBounds(OffsetKt.windowInsetsPadding(companion, singleRowTopAppBarOverrideScope.windowInsets));
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = AppBarKt.LocalSingleRowTopAppBarOverride;
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (z || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new FloatProducer() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda3
                    @Override // androidx.compose.material3.internal.FloatProducer
                    public final float invoke() {
                        singleRowTopAppBarOverrideScope.getClass();
                        return 0.0f;
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            FloatProducer floatProducer = (FloatProducer) objRememberedValue5;
            long j2 = topAppBarColors.navigationIconContentColor;
            long j3 = topAppBarColors.titleContentColor;
            long j4 = topAppBarColors.actionIconContentColor;
            long j5 = topAppBarColors.subtitleContentColor;
            ComposableLambdaImpl composableLambdaImpl = singleRowTopAppBarOverrideScope.title;
            TextStyle textStyle = singleRowTopAppBarOverrideScope.titleTextStyle;
            TextStyle textStyle2 = singleRowTopAppBarOverrideScope.subtitleTextStyle;
            Arrangement$Center$1 arrangement$Center$1 = Arrangement.Center;
            Function2 function2 = singleRowTopAppBarOverrideScope.navigationIcon;
            float f2 = singleRowTopAppBarOverrideScope.expandedHeight;
            PaddingValues paddingValues = singleRowTopAppBarOverrideScope.contentPadding;
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new ImmLeaksCleaner$$ExternalSyntheticLambda0(23);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            AppBarKt.m239TopAppBarLayout_5F1rQI(modifierClipToBounds, floatProducer, j2, j3, j5, j4, composableLambdaImpl, textStyle, textStyle2, (Function0) objRememberedValue6, arrangement$Center$1, function2, composableLambdaImplRememberComposableLambda, f2, paddingValues, gapComposer2, 0);
            gapComposer2 = gapComposer2;
            gapComposer2.end(true);
        } else {
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 14, this, singleRowTopAppBarOverrideScope);
        }
    }
}
