package com.github.kr328.clash.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppCrashedScreenKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.AppCrashedScreenKt$AppCrashedScreen$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Function3 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ String $logs;
        public final /* synthetic */ int $r8$classId = 0;

        public AnonymousClass2(AppColors appColors, String str) {
            this.$colors = appColors;
            this.$logs = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            boolean z;
            GapComposer gapComposer;
            switch (this.$r8$classId) {
                case 0:
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        AppColors appColors = this.$colors;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.verticalScroll$default(OffsetKt.m132paddingqDBjuR0$default(ImageKt.m47backgroundbw27NRU(fillElement, appColors.appBackground, BrushKt.RectangleShape), 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo117calculateBottomPaddingD9Ej5fM(), 5), ImageKt.rememberScrollState(gapComposer2)), 16, 12);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
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
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        SimpleLayoutKt.SelectionContainer(null, Thread_jvmKt.rememberComposableLambda(187884915, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(appColors, this.$logs, 1), gapComposer2), gapComposer2, 48);
                        gapComposer2.end(true);
                    }
                    break;
                default:
                    Function2 function2 = (Function2) obj;
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    int iIntValue2 = ((Number) obj3).intValue();
                    if ((iIntValue2 & 6) == 0) {
                        iIntValue2 |= gapComposer3.changedInstance(function2) ? 4 : 2;
                    }
                    int i2 = iIntValue2;
                    if ((i2 & 19) == 18 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j2 = gapComposer3.compositeKeyHashCode;
                        int i3 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, Modifier.Companion.$$INSTANCE);
                        ComposeUiNode.Companion.getClass();
                        Function0 function0 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(function0);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer3, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                        gapComposer3.startReplaceGroup(-45903421);
                        if (this.$logs.length() == 0) {
                            z = false;
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_paste_link, gapComposer3), null, this.$colors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Medium, 0L, 0, 0L, 16777209), gapComposer3, 0, 12582912, 131066);
                            gapComposer = gapComposer3;
                        } else {
                            z = false;
                            gapComposer = gapComposer3;
                        }
                        gapComposer.end(z);
                        function2.invoke(gapComposer, Integer.valueOf(i2 & 14));
                        gapComposer.end(true);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public AnonymousClass2(String str, AppColors appColors) {
            this.$logs = str;
            this.$colors = appColors;
        }
    }

    public static final void AppCrashedScreen(String str, Function0 function0, Modifier modifier, GapComposer gapComposer, int i) {
        Modifier modifier2;
        gapComposer.startRestartGroup(2035849581);
        if (((i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | 384) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(48584497, new LogsScreenKt.AnonymousClass2(appColors, function0, 2), gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(769254076, new AnonymousClass2(appColors, str), gapComposer), gapComposer, 805306416, 444);
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(str, function0, modifier2, i, 5);
        }
    }
}
