package androidx.compose.material3;

import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MaterialThemeKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ ColorScheme f$0;
    public final /* synthetic */ Typography f$3;
    public final /* synthetic */ ComposableLambdaImpl f$4;

    public /* synthetic */ MaterialThemeKt$$ExternalSyntheticLambda2(ColorScheme colorScheme, Typography typography, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = colorScheme;
        this.f$3 = typography;
        this.f$4 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Typography typography = this.f$3;
        ColorScheme colorSchemeM245lightColorScheme_VG5OTI$default = this.f$0;
        switch (i) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    if (colorSchemeM245lightColorScheme_VG5OTI$default == null) {
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorSchemeKt.LocalTonalElevationEnabled;
                        colorSchemeM245lightColorScheme_VG5OTI$default = ColorSchemeKt.m245lightColorScheme_VG5OTI$default(0L, 0L, 0L, PaletteTokens.Primary30, 0L, 0L, 0L, PaletteTokens.Secondary30, 0L, 0L, PaletteTokens.Tertiary30, 0L, 0L, 0L, 0L, 0L, 0L, PaletteTokens.Error30, 0L, 0L, -33558793);
                    }
                    MaterialThemeKt.MaterialTheme(colorSchemeM245lightColorScheme_VG5OTI$default, MotionScheme.ExpressiveMotionSchemeImpl.INSTANCE, new Shapes(), typography == null ? new Typography(null, null, null, null, null, null, null, null, null, 32767) : typography, this.f$4, gapComposer, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                MaterialThemeKt.MaterialExpressiveTheme(colorSchemeM245lightColorScheme_VG5OTI$default, typography, this.f$4, (GapComposer) obj, Stack.updateChangedFlags(3073));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ MaterialThemeKt$$ExternalSyntheticLambda2(ColorScheme colorScheme, Typography typography, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = colorScheme;
        this.f$3 = typography;
        this.f$4 = composableLambdaImpl;
    }
}
