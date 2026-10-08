package androidx.compose.material3;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.UnionInsets;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppBarKt {
    public static final DynamicProvidableCompositionLocal LocalSingleRowTopAppBarOverride = new DynamicProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(20));
    public static final float TopAppBarHorizontalPadding;
    public static final float TopAppBarTitleInset;

    static {
        Stack.compositionLocalOf$default(new ImmLeaksCleaner$$ExternalSyntheticLambda0(21));
        new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        float f = 4;
        TopAppBarHorizontalPadding = f;
        TopAppBarTitleInset = 16 - f;
    }

    /* JADX INFO: renamed from: SingleRowTopAppBar-TCVpFMg, reason: not valid java name */
    public static final void m237SingleRowTopAppBarTCVpFMg(final Modifier modifier, final ComposableLambdaImpl composableLambdaImpl, final TextStyle textStyle, final TextStyle textStyle2, final Function2 function2, final Function3 function3, final float f, final PaddingValues paddingValues, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        TextStyle textStyle3;
        TextStyle textStyle4;
        int i4;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        gapComposer.startRestartGroup(703932376);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            textStyle3 = textStyle;
            i3 |= gapComposer.changed(textStyle3) ? 256 : 128;
        } else {
            textStyle3 = textStyle;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changedInstance(null) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            textStyle4 = textStyle2;
            i3 |= gapComposer.changed(textStyle4) ? 16384 : 8192;
        } else {
            textStyle4 = textStyle2;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer.changed(horizontal) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= gapComposer.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer.changed(paddingValues) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer.changed(windowInsets) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(topAppBarColors) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer.changed((Object) null) ? 256 : 128;
        }
        int i5 = i4;
        if (gapComposer.shouldExecute(i3 & 1, ((306783379 & i3) == 306783378 && (i5 & 147) == 146) ? false : true)) {
            ((DefaultSingleRowTopAppBarOverride) gapComposer.consume(LocalSingleRowTopAppBarOverride)).SingleRowTopAppBar(new SingleRowTopAppBarOverrideScope(modifier, composableLambdaImpl, textStyle3, textStyle4, function2, function3, f, paddingValues, windowInsets, topAppBarColors), gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    AppBarKt.m237SingleRowTopAppBarTCVpFMg(modifier, composableLambdaImpl, textStyle, textStyle2, function2, function3, f, paddingValues, windowInsets, topAppBarColors, (GapComposer) obj, Stack.updateChangedFlags(i | 1), Stack.updateChangedFlags(i2));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:44:0x008c  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:64:0x0120  */
    /* JADX WARN: Code duplicated, block: B:67:0x0131  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: TopAppBar-gNPyAyM, reason: not valid java name */
    public static final void m238TopAppBargNPyAyM(final ComposableLambdaImpl composableLambdaImpl, Modifier modifier, Function2 function2, Function3 function3, float f, WindowInsets windowInsets, final TopAppBarColors topAppBarColors, PaddingValues paddingValues, GapComposer gapComposer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        Function2 function4;
        int i4;
        Function3 function5;
        int i5;
        int i6;
        int i7;
        boolean z;
        final WindowInsets windowInsets2;
        final PaddingValues paddingValues2;
        final Function2 function6;
        final Function3 function7;
        final float f2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier3;
        int i8;
        float f3;
        WindowInsets limitInsets;
        Function2 function8;
        Function3 function9;
        PaddingValues paddingValues3;
        float f4;
        gapComposer.startRestartGroup(660588393);
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 = i | 48;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            i3 = (gapComposer.changed(modifier2) ? 32 : 16) | i;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                function4 = function2;
                i3 |= gapComposer.changedInstance(function4) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function5 = function3;
                    if (gapComposer.changedInstance(function5)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                int i11 = i3 | 90112;
                if (gapComposer.changed(topAppBarColors)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i7 = i11 | i6 | 113246208;
                if ((38347923 & i7) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i7 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i10 != 0) {
                            function4 = ScrimKt.lambda$2094288676;
                        }
                        if (i4 != 0) {
                            function5 = ScrimKt.f5lambda$1342205566;
                        }
                        float f5 = TopAppBarDefaults.TopAppBarExpandedHeight;
                        WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                        i8 = i7 & (-458753);
                        f3 = f5;
                        limitInsets = new LimitInsets(new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout), 16 | OffsetKt.Horizontal);
                        function8 = function4;
                        function9 = function5;
                        paddingValues3 = TopAppBarDefaults.ContentPadding;
                    } else {
                        gapComposer.skipToGroupEnd();
                        f3 = f;
                        limitInsets = windowInsets;
                        i8 = i7 & (-458753);
                        modifier3 = modifier2;
                        function8 = function4;
                        function9 = function5;
                        paddingValues3 = paddingValues;
                    }
                    gapComposer.endDefaults();
                    float f6 = AppBarSmallTokens.ContainerHeight;
                    TextStyle value = TypographyKt.getValue(13, gapComposer);
                    TextStyle textStyle = TextStyle.Default;
                    if (!Dp.m704equalsimpl0(f3, Float.NaN) || Dp.m704equalsimpl0(f3, Float.POSITIVE_INFINITY)) {
                        f4 = TopAppBarDefaults.TopAppBarExpandedHeight;
                    } else {
                        f4 = f3;
                    }
                    int i12 = i8 << 12;
                    m237SingleRowTopAppBarTCVpFMg(modifier3, composableLambdaImpl, value, textStyle, function8, function9, f4, paddingValues3, limitInsets, topAppBarColors, gapComposer, ((i8 >> 3) & 14) | 224304 | (3670016 & i12) | (i12 & 29360128) | 805306368, (i8 >> 15) & 1022);
                    modifier2 = modifier3;
                    function6 = function8;
                    function7 = function9;
                    windowInsets2 = limitInsets;
                    f2 = f3;
                    paddingValues2 = paddingValues3;
                } else {
                    gapComposer.skipToGroupEnd();
                    windowInsets2 = windowInsets;
                    paddingValues2 = paddingValues;
                    function6 = function4;
                    function7 = function5;
                    f2 = f;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            AppBarKt.m238TopAppBargNPyAyM(composableLambdaImpl, modifier2, function6, function7, f2, windowInsets2, topAppBarColors, paddingValues2, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i3 |= 3072;
            function5 = function3;
            int i13 = i3 | 90112;
            if (gapComposer.changed(topAppBarColors)) {
                i6 = 1048576;
            } else {
                i6 = 524288;
            }
            i7 = i13 | i6 | 113246208;
            if ((38347923 & i7) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i7 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        function4 = ScrimKt.lambda$2094288676;
                    }
                    if (i4 != 0) {
                        function5 = ScrimKt.f5lambda$1342205566;
                    }
                    float f7 = TopAppBarDefaults.TopAppBarExpandedHeight;
                    WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
                    i8 = i7 & (-458753);
                    f3 = f7;
                    limitInsets = new LimitInsets(new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout), 16 | OffsetKt.Horizontal);
                    function8 = function4;
                    function9 = function5;
                    paddingValues3 = TopAppBarDefaults.ContentPadding;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        function4 = ScrimKt.lambda$2094288676;
                    }
                    if (i4 != 0) {
                        function5 = ScrimKt.f5lambda$1342205566;
                    }
                    float f8 = TopAppBarDefaults.TopAppBarExpandedHeight;
                    WeakHashMap weakHashMap3 = WindowInsetsHolder.viewMap;
                    i8 = i7 & (-458753);
                    f3 = f8;
                    limitInsets = new LimitInsets(new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout), 16 | OffsetKt.Horizontal);
                    function8 = function4;
                    function9 = function5;
                    paddingValues3 = TopAppBarDefaults.ContentPadding;
                }
                gapComposer.endDefaults();
                float f9 = AppBarSmallTokens.ContainerHeight;
                TextStyle value2 = TypographyKt.getValue(13, gapComposer);
                TextStyle textStyle2 = TextStyle.Default;
                if (Dp.m704equalsimpl0(f3, Float.NaN)) {
                    f4 = TopAppBarDefaults.TopAppBarExpandedHeight;
                } else {
                    f4 = TopAppBarDefaults.TopAppBarExpandedHeight;
                }
                int i14 = i8 << 12;
                m237SingleRowTopAppBarTCVpFMg(modifier3, composableLambdaImpl, value2, textStyle2, function8, function9, f4, paddingValues3, limitInsets, topAppBarColors, gapComposer, ((i8 >> 3) & 14) | 224304 | (3670016 & i14) | (i14 & 29360128) | 805306368, (i8 >> 15) & 1022);
                modifier2 = modifier3;
                function6 = function8;
                function7 = function9;
                windowInsets2 = limitInsets;
                f2 = f3;
                paddingValues2 = paddingValues3;
            } else {
                gapComposer.skipToGroupEnd();
                windowInsets2 = windowInsets;
                paddingValues2 = paddingValues;
                function6 = function4;
                function7 = function5;
                f2 = f;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        AppBarKt.m238TopAppBargNPyAyM(composableLambdaImpl, modifier2, function6, function7, f2, windowInsets2, topAppBarColors, paddingValues2, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 384;
        function4 = function2;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function5 = function3;
                if (gapComposer.changedInstance(function5)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            int i15 = i3 | 90112;
            if (gapComposer.changed(topAppBarColors)) {
                i6 = 1048576;
            } else {
                i6 = 524288;
            }
            i7 = i15 | i6 | 113246208;
            if ((38347923 & i7) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i7 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        function4 = ScrimKt.lambda$2094288676;
                    }
                    if (i4 != 0) {
                        function5 = ScrimKt.f5lambda$1342205566;
                    }
                    float f10 = TopAppBarDefaults.TopAppBarExpandedHeight;
                    WeakHashMap weakHashMap4 = WindowInsetsHolder.viewMap;
                    i8 = i7 & (-458753);
                    f3 = f10;
                    limitInsets = new LimitInsets(new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout), 16 | OffsetKt.Horizontal);
                    function8 = function4;
                    function9 = function5;
                    paddingValues3 = TopAppBarDefaults.ContentPadding;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        function4 = ScrimKt.lambda$2094288676;
                    }
                    if (i4 != 0) {
                        function5 = ScrimKt.f5lambda$1342205566;
                    }
                    float f11 = TopAppBarDefaults.TopAppBarExpandedHeight;
                    WeakHashMap weakHashMap5 = WindowInsetsHolder.viewMap;
                    i8 = i7 & (-458753);
                    f3 = f11;
                    limitInsets = new LimitInsets(new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout), 16 | OffsetKt.Horizontal);
                    function8 = function4;
                    function9 = function5;
                    paddingValues3 = TopAppBarDefaults.ContentPadding;
                }
                gapComposer.endDefaults();
                float f12 = AppBarSmallTokens.ContainerHeight;
                TextStyle value3 = TypographyKt.getValue(13, gapComposer);
                TextStyle textStyle3 = TextStyle.Default;
                if (Dp.m704equalsimpl0(f3, Float.NaN)) {
                    f4 = TopAppBarDefaults.TopAppBarExpandedHeight;
                } else {
                    f4 = TopAppBarDefaults.TopAppBarExpandedHeight;
                }
                int i16 = i8 << 12;
                m237SingleRowTopAppBarTCVpFMg(modifier3, composableLambdaImpl, value3, textStyle3, function8, function9, f4, paddingValues3, limitInsets, topAppBarColors, gapComposer, ((i8 >> 3) & 14) | 224304 | (3670016 & i16) | (i16 & 29360128) | 805306368, (i8 >> 15) & 1022);
                modifier2 = modifier3;
                function6 = function8;
                function7 = function9;
                windowInsets2 = limitInsets;
                f2 = f3;
                paddingValues2 = paddingValues3;
            } else {
                gapComposer.skipToGroupEnd();
                windowInsets2 = windowInsets;
                paddingValues2 = paddingValues;
                function6 = function4;
                function7 = function5;
                f2 = f;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        AppBarKt.m238TopAppBargNPyAyM(composableLambdaImpl, modifier2, function6, function7, f2, windowInsets2, topAppBarColors, paddingValues2, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 3072;
        function5 = function3;
        int i17 = i3 | 90112;
        if (gapComposer.changed(topAppBarColors)) {
            i6 = 1048576;
        } else {
            i6 = 524288;
        }
        i7 = i17 | i6 | 113246208;
        if ((38347923 & i7) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i7 & 1, z)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    function4 = ScrimKt.lambda$2094288676;
                }
                if (i4 != 0) {
                    function5 = ScrimKt.f5lambda$1342205566;
                }
                float f13 = TopAppBarDefaults.TopAppBarExpandedHeight;
                WeakHashMap weakHashMap6 = WindowInsetsHolder.viewMap;
                i8 = i7 & (-458753);
                f3 = f13;
                limitInsets = new LimitInsets(new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout), 16 | OffsetKt.Horizontal);
                function8 = function4;
                function9 = function5;
                paddingValues3 = TopAppBarDefaults.ContentPadding;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    function4 = ScrimKt.lambda$2094288676;
                }
                if (i4 != 0) {
                    function5 = ScrimKt.f5lambda$1342205566;
                }
                float f14 = TopAppBarDefaults.TopAppBarExpandedHeight;
                WeakHashMap weakHashMap7 = WindowInsetsHolder.viewMap;
                i8 = i7 & (-458753);
                f3 = f14;
                limitInsets = new LimitInsets(new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout), 16 | OffsetKt.Horizontal);
                function8 = function4;
                function9 = function5;
                paddingValues3 = TopAppBarDefaults.ContentPadding;
            }
            gapComposer.endDefaults();
            float f15 = AppBarSmallTokens.ContainerHeight;
            TextStyle value4 = TypographyKt.getValue(13, gapComposer);
            TextStyle textStyle4 = TextStyle.Default;
            if (Dp.m704equalsimpl0(f3, Float.NaN)) {
                f4 = TopAppBarDefaults.TopAppBarExpandedHeight;
            } else {
                f4 = TopAppBarDefaults.TopAppBarExpandedHeight;
            }
            int i18 = i8 << 12;
            m237SingleRowTopAppBarTCVpFMg(modifier3, composableLambdaImpl, value4, textStyle4, function8, function9, f4, paddingValues3, limitInsets, topAppBarColors, gapComposer, ((i8 >> 3) & 14) | 224304 | (3670016 & i18) | (i18 & 29360128) | 805306368, (i8 >> 15) & 1022);
            modifier2 = modifier3;
            function6 = function8;
            function7 = function9;
            windowInsets2 = limitInsets;
            f2 = f3;
            paddingValues2 = paddingValues3;
        } else {
            gapComposer.skipToGroupEnd();
            windowInsets2 = windowInsets;
            paddingValues2 = paddingValues;
            function6 = function4;
            function7 = function5;
            f2 = f;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    AppBarKt.m238TopAppBargNPyAyM(composableLambdaImpl, modifier2, function6, function7, f2, windowInsets2, topAppBarColors, paddingValues2, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: TopAppBarLayout-_5F1rQI, reason: not valid java name */
    public static final void m239TopAppBarLayout_5F1rQI(final Modifier modifier, final FloatProducer floatProducer, final long j, final long j2, final long j3, long j4, final ComposableLambdaImpl composableLambdaImpl, final TextStyle textStyle, final TextStyle textStyle2, final Function0 function0, final Arrangement.Vertical vertical, final Function2 function2, ComposableLambdaImpl composableLambdaImpl2, final float f, final PaddingValues paddingValues, GapComposer gapComposer, final int i) {
        ComposableLambdaImpl composableLambdaImpl3;
        final long j5 = j4;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        gapComposer.startRestartGroup(239553141);
        int i2 = i | (gapComposer.changed(modifier) ? 4 : 2) | (gapComposer.changed(floatProducer) ? 32 : 16) | (gapComposer.changed(j) ? 256 : 128) | (gapComposer.changed(j2) ? 2048 : 1024) | (gapComposer.changed(j3) ? 16384 : 8192) | (gapComposer.changed(j5) ? 131072 : 65536) | (gapComposer.changedInstance(composableLambdaImpl) ? 1048576 : 524288) | (gapComposer.changed(textStyle) ? 8388608 : 4194304) | (gapComposer.changedInstance(null) ? 67108864 : 33554432) | (gapComposer.changed(textStyle2) ? 536870912 : 268435456);
        int i3 = 1600566 | (gapComposer.changed(horizontal) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 131072 : 65536) | (gapComposer.changed(f) ? 8388608 : 4194304) | (gapComposer.changed(paddingValues) ? 67108864 : 33554432);
        if (gapComposer.shouldExecute(i2 & 1, ((i2 & 306783379) == 306783378 && (38347923 & i3) == 38347922) ? false : true)) {
            boolean z = ((i2 & 112) == 32) | ((i3 & 896) == 256) | ((29360128 & i3) == 8388608);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TopAppBarMeasurePolicy(floatProducer, vertical, f, paddingValues);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            TopAppBarMeasurePolicy topAppBarMeasurePolicy = (TopAppBarMeasurePolicy) objRememberedValue;
            long j6 = gapComposer.compositeKeyHashCode;
            int i4 = (int) (j6 ^ (j6 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer, topAppBarMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i4);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierLayoutId = RulerKt.layoutId(companion, "navigationIcon");
            float f2 = TopAppBarHorizontalPadding;
            Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(modifierLayoutId, f2, 0.0f, 0.0f, 0.0f, 14);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            long j7 = gapComposer.compositeKeyHashCode;
            int i5 = (int) (j7 ^ (j7 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM132paddingqDBjuR0$default);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i5, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = ContentColorKt.LocalContentColor;
            Stack.CompositionLocalProvider(dynamicProvidableCompositionLocal.defaultProvidedValue$runtime(new Color(j)), function2, gapComposer, ((i3 >> 12) & 112) | 8);
            gapComposer.end(true);
            gapComposer.startReplaceGroup(408520308);
            Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(RulerKt.layoutId(companion, "title"), f2, 0.0f, 2);
            gapComposer.startReplaceGroup(-402451802);
            gapComposer.end(false);
            Modifier modifierThen = modifierM130paddingVpY3zN4$default.then(companion);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AppBarKt$$ExternalSyntheticLambda4(0, function0);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierGraphicsLayer = BrushKt.graphicsLayer(modifierThen, (Function1) objRememberedValue2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            long j8 = gapComposer.compositeKeyHashCode;
            int i6 = (int) (j8 ^ (j8 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, modifierGraphicsLayer);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            LayoutUtilKt.m281ProvideContentColorTextStyle3JVO9M(j2, textStyle, composableLambdaImpl, gapComposer, ((i2 >> 9) & 14) | ((i2 >> 18) & 112) | ((i2 >> 12) & 896));
            gapComposer.end(true);
            gapComposer.end(false);
            Modifier modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(RulerKt.layoutId(companion, "actionIcons"), 0.0f, 0.0f, f2, 0.0f, 11);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            long j9 = gapComposer.compositeKeyHashCode;
            int i7 = (int) (j9 ^ (j9 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM132paddingqDBjuR0$default2);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy3, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i7, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$4);
            j5 = j4;
            ProvidedValue providedValueDefaultProvidedValue$runtime = dynamicProvidableCompositionLocal.defaultProvidedValue$runtime(new Color(j5));
            composableLambdaImpl3 = composableLambdaImpl2;
            Stack.CompositionLocalProvider(providedValueDefaultProvidedValue$runtime, composableLambdaImpl3, gapComposer, 56);
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            composableLambdaImpl3 = composableLambdaImpl2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final ComposableLambdaImpl composableLambdaImpl4 = composableLambdaImpl3;
            recomposeScopeImplEndRestartGroup.block = new Function2(floatProducer, j, j2, j3, j5, composableLambdaImpl, textStyle, textStyle2, function0, vertical, function2, composableLambdaImpl4, f, paddingValues, i) { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda5
                public final /* synthetic */ FloatProducer f$1;
                public final /* synthetic */ Function0 f$10;
                public final /* synthetic */ Arrangement.Vertical f$11;
                public final /* synthetic */ Function2 f$15;
                public final /* synthetic */ ComposableLambdaImpl f$16;
                public final /* synthetic */ float f$17;
                public final /* synthetic */ PaddingValues f$18;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ long f$3;
                public final /* synthetic */ long f$4;
                public final /* synthetic */ long f$5;
                public final /* synthetic */ ComposableLambdaImpl f$6;
                public final /* synthetic */ TextStyle f$7;
                public final /* synthetic */ TextStyle f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    AppBarKt.m239TopAppBarLayout_5F1rQI(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$9, this.f$10, this.f$11, this.f$15, this.f$16, this.f$17, this.f$18, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
