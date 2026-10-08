package androidx.compose.material3;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SurfaceKt {
    public static final DynamicProvidableCompositionLocal LocalAbsoluteTonalElevation = new DynamicProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(3));

    /* JADX INFO: renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m269SurfaceT9BRK9s(Modifier modifier, Shape shape, long j, long j2, float f, float f2, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i, int i2) {
        if ((i2 & 2) != 0) {
            shape = BrushKt.RectangleShape;
        }
        Shape shape2 = shape;
        long jM244contentColorForek8zF_U = (i2 & 8) != 0 ? ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer) : j2;
        float f3 = (i2 & 16) != 0 ? 0 : f;
        float f4 = (i2 & 32) != 0 ? 0 : f2;
        DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = LocalAbsoluteTonalElevation;
        float f5 = ((Dp) gapComposer.consume(dynamicProvidableCompositionLocal)).value + f3;
        Stack.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(jM244contentColorForek8zF_U)), dynamicProvidableCompositionLocal.defaultProvidedValue$runtime(new Dp(f5))}, Thread_jvmKt.rememberComposableLambda(421772006, new SurfaceKt$$ExternalSyntheticLambda0(modifier, shape2, j, f5, f4, composableLambdaImpl), gapComposer), gapComposer, 56);
    }

    /* JADX INFO: renamed from: surface-XO-JAsU, reason: not valid java name */
    public static final Modifier m270surfaceXOJAsU(float f, long j, Modifier modifier, Shape shape) {
        Shape shape2;
        Modifier modifierM417graphicsLayer_6ThJ44$default;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (f > 0.0f) {
            shape2 = shape;
            modifierM417graphicsLayer_6ThJ44$default = BrushKt.m417graphicsLayer_6ThJ44$default(companion, 0.0f, 0.0f, 0.0f, f, shape2, false, 518111);
        } else {
            shape2 = shape;
            modifierM417graphicsLayer_6ThJ44$default = companion;
        }
        return ClipKt.clip(ImageKt.m47backgroundbw27NRU(modifier.then(modifierM417graphicsLayer_6ThJ44$default).then(companion), j, shape2), shape2);
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m271surfaceColorAtElevationCLU3JFs(long j, float f, GapComposer gapComposer) {
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        boolean zBooleanValue = ((Boolean) gapComposer.consume(ColorSchemeKt.LocalTonalElevationEnabled)).booleanValue();
        long j2 = colorScheme.surface;
        if (!Color.m435equalsimpl0(j, j2) || !zBooleanValue) {
            return j;
        }
        if (Dp.m704equalsimpl0(f, 0)) {
            return j2;
        }
        float fLog = ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f;
        long j3 = colorScheme.surfaceTint;
        return BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(j3), Color.m439getGreenimpl(j3), Color.m437getBlueimpl(j3), fLog, Color.m438getColorSpaceimpl(j3)), j2);
    }
}
