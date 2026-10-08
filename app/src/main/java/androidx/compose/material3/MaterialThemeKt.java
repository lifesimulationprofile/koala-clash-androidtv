package androidx.compose.material3;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class MaterialThemeKt {
    public static final StaticProvidableCompositionLocal LocalUsingExpressiveTheme = new StaticProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(26));
    public static final StaticProvidableCompositionLocal _localMaterialTheme = new StaticProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(27));

    public static final void MaterialExpressiveTheme(ColorScheme colorScheme, Typography typography, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        ComposableLambdaImpl composableLambdaImpl2;
        GapComposer gapComposer2;
        ColorScheme colorScheme2;
        Typography typography2;
        gapComposer.startRestartGroup(1317329884);
        int i2 = (gapComposer.changed(colorScheme) ? 4 : 2) | i | 432 | (gapComposer.changedInstance(composableLambdaImpl) ? 16384 : 8192);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalUsingExpressiveTheme;
            if (((Boolean) gapComposer.consume(staticProvidableCompositionLocal)).booleanValue()) {
                gapComposer.startReplaceGroup(1458663246);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = _localMaterialTheme;
                if (colorScheme == null) {
                    gapComposer.startReplaceGroup(-1061323065);
                    ColorScheme colorScheme3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme;
                    gapComposer.end(false);
                    colorScheme2 = colorScheme3;
                } else {
                    gapComposer.startReplaceGroup(-1061323964);
                    gapComposer.end(false);
                    colorScheme2 = colorScheme;
                }
                gapComposer.startReplaceGroup(-1061320824);
                MotionScheme motionScheme = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).motionScheme;
                gapComposer.end(false);
                if (typography == null) {
                    gapComposer.startReplaceGroup(-1061318682);
                    Typography typography3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography;
                    gapComposer.end(false);
                    typography2 = typography3;
                } else {
                    gapComposer.startReplaceGroup(-1061319550);
                    gapComposer.end(false);
                    typography2 = typography;
                }
                gapComposer.startReplaceGroup(-1061316862);
                Shapes shapes = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).shapes;
                gapComposer.end(false);
                composableLambdaImpl2 = composableLambdaImpl;
                gapComposer2 = gapComposer;
                MaterialTheme(colorScheme2, motionScheme, shapes, typography2, composableLambdaImpl2, gapComposer2, i2 & 57344);
                gapComposer2.end(false);
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
                gapComposer2 = gapComposer;
                gapComposer2.startReplaceGroup(1458990389);
                Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(Boolean.TRUE), Thread_jvmKt.rememberComposableLambda(1535649272, new MaterialThemeKt$$ExternalSyntheticLambda2(colorScheme, typography, composableLambdaImpl2), gapComposer2), gapComposer2, 56);
                gapComposer2.end(false);
            }
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MaterialThemeKt$$ExternalSyntheticLambda2(colorScheme, typography, composableLambdaImpl2, i);
        }
    }

    public static final void MaterialTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(904511636);
        int i3 = (gapComposer.changed(colorScheme) ? 4 : 2) | i | (gapComposer.changed(motionScheme) ? 32 : 16) | (gapComposer.changed(shapes) ? 256 : 128) | (gapComposer.changed(typography) ? 2048 : 1024);
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 16384 : 8192;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            MaterialTheme$Values materialTheme$Values = new MaterialTheme$Values(colorScheme, typography, shapes, motionScheme);
            RippleNodeFactory rippleNodeFactoryM260rippleOu1YvPQ$default = RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, null, false, 255);
            long j = colorScheme.primary;
            boolean zChanged = gapComposer.changed(j);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                i2 = 0;
                objRememberedValue = new TextSelectionColors(j, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.4f, Color.m438getColorSpaceimpl(j)));
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                i2 = 0;
            }
            ProvidedValue providedValueDefaultProvidedValue$runtime = _localMaterialTheme.defaultProvidedValue$runtime(materialTheme$Values);
            ProvidedValue providedValueDefaultProvidedValue$runtime2 = IndicationKt.LocalIndication.defaultProvidedValue$runtime(rippleNodeFactoryM260rippleOu1YvPQ$default);
            ProvidedValue providedValueDefaultProvidedValue$runtime3 = TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime((TextSelectionColors) objRememberedValue);
            ProvidedValue[] providedValueArr = new ProvidedValue[3];
            providedValueArr[i2] = providedValueDefaultProvidedValue$runtime;
            providedValueArr[1] = providedValueDefaultProvidedValue$runtime2;
            providedValueArr[2] = providedValueDefaultProvidedValue$runtime3;
            Stack.CompositionLocalProvider(providedValueArr, Thread_jvmKt.rememberComposableLambda(-1750539308, new MaterialThemeKt$$ExternalSyntheticLambda4(typography, composableLambdaImpl, i2), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MaterialThemeKt$$ExternalSyntheticLambda5(colorScheme, motionScheme, shapes, typography, composableLambdaImpl, i, 0);
        }
    }
}
