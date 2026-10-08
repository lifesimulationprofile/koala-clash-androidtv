package androidx.compose.material3;

import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.UnionInsets;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.RulerKt;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ScaffoldKt {
    public static final float FabSpacing = 16;

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:70:0x010d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x010f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0128 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:75:0x012a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0169  */
    /* JADX WARN: Code duplicated, block: B:80:0x017e  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    public static final void m261ScaffoldTvnljyQ(Modifier modifier, Function2 function2, Function2 function3, Function2 function4, Function2 function5, int i, final long j, long j2, WindowInsets windowInsets, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        Function2 function6;
        int i5;
        Function2 function7;
        int i6;
        int i7;
        Function2 function8;
        int i8;
        int i9;
        int i10;
        boolean z;
        final Function2 function9;
        final int i11;
        final WindowInsets windowInsets2;
        final Modifier modifier3;
        final Function2 function10;
        final Function2 function11;
        final Function2 function12;
        final long j3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function13;
        int i12;
        int i13;
        WindowInsets unionInsets;
        Function2 function14;
        Modifier modifier4;
        long j4;
        Function2 function15;
        Function2 function16;
        boolean zChanged;
        Object objRememberedValue;
        MutableWindowInsets mutableWindowInsets;
        boolean zChanged2;
        Object objRememberedValue2;
        gapComposer.startRestartGroup(-1211482744);
        int i14 = i3 & 1;
        if (i14 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            i4 = (gapComposer.changed(modifier2) ? 4 : 2) | i2;
        }
        int i15 = i3 & 2;
        if (i15 == 0) {
            if ((i2 & 48) == 0) {
                function6 = function2;
                i4 |= gapComposer.changedInstance(function6) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & 384) == 0) {
                    function7 = function3;
                    if (gapComposer.changedInstance(function7)) {
                        i6 = 256;
                    } else {
                        i6 = 128;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 8;
                if (i7 != 0) {
                    if ((i2 & 3072) == 0) {
                        function8 = function4;
                        if (gapComposer.changedInstance(function8)) {
                            i8 = 2048;
                        } else {
                            i8 = 1024;
                        }
                        i4 |= i8;
                    }
                    int i16 = i4 | 221184;
                    if (gapComposer.changed(j)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i10 = i16 | i9 | 37748736;
                    if ((306783379 & i10) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (gapComposer.shouldExecute(i10 & 1, z)) {
                        gapComposer.startDefaults();
                        if ((i2 & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            if (i15 != 0) {
                                function6 = ScrimKt.f7lambda$39202156;
                            }
                            if (i5 != 0) {
                                function7 = ScrimKt.lambda$1582488484;
                            }
                            if (i7 != 0) {
                                function8 = ScrimKt.lambda$414328099;
                            }
                            ComposableLambdaImpl composableLambdaImpl2 = ScrimKt.f6lambda$1514016380;
                            long jM244contentColorForek8zF_U = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                            function13 = composableLambdaImpl2;
                            i12 = 2;
                            i13 = i10 & (-264241153);
                            unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                            function14 = function8;
                            modifier4 = modifier2;
                            j4 = jM244contentColorForek8zF_U;
                            function15 = function7;
                            function16 = function6;
                        } else {
                            gapComposer.skipToGroupEnd();
                            function13 = function5;
                            i12 = i;
                            i13 = i10 & (-264241153);
                            function14 = function8;
                            unionInsets = windowInsets;
                            modifier4 = modifier2;
                            j4 = j2;
                            function16 = function6;
                            function15 = function7;
                        }
                        gapComposer.endDefaults();
                        zChanged = gapComposer.changed(unionInsets);
                        objRememberedValue = gapComposer.rememberedValue();
                        Object obj = Composer$Companion.Empty;
                        if (zChanged || objRememberedValue == obj) {
                            objRememberedValue = new MutableWindowInsets(unionInsets);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                        zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == obj) {
                            objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        SurfaceKt.m269SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j, j4, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(848889571, new ScaffoldKt$$ExternalSyntheticLambda1(i12, function16, composableLambdaImpl, function14, function13, mutableWindowInsets, function15), gapComposer), gapComposer, ((i13 >> 12) & 896) | 12582912, 114);
                        j3 = j4;
                        modifier3 = modifier4;
                        windowInsets2 = unionInsets;
                        i11 = i12;
                        function10 = function16;
                        function12 = function14;
                        function9 = function13;
                        function11 = function15;
                    } else {
                        gapComposer.skipToGroupEnd();
                        function9 = function5;
                        i11 = i;
                        windowInsets2 = windowInsets;
                        modifier3 = modifier2;
                        function10 = function6;
                        function11 = function7;
                        function12 = function8;
                        j3 = j2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                ((Integer) obj3).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                                ScaffoldKt.m261ScaffoldTvnljyQ(modifier3, function10, function11, function12, function9, i11, j, j3, windowInsets2, composableLambdaImpl, (GapComposer) obj2, iUpdateChangedFlags, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i4 |= 3072;
                function8 = function4;
                int i17 = i4 | 221184;
                if (gapComposer.changed(j)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i10 = i17 | i9 | 37748736;
                if ((306783379 & i10) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i10 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i15 != 0) {
                            function6 = ScrimKt.f7lambda$39202156;
                        }
                        if (i5 != 0) {
                            function7 = ScrimKt.lambda$1582488484;
                        }
                        if (i7 != 0) {
                            function8 = ScrimKt.lambda$414328099;
                        }
                        ComposableLambdaImpl composableLambdaImpl3 = ScrimKt.f6lambda$1514016380;
                        long jM244contentColorForek8zF_U2 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                        WeakHashMap weakHashMap2 = WindowInsetsHolder.viewMap;
                        function13 = composableLambdaImpl3;
                        i12 = 2;
                        i13 = i10 & (-264241153);
                        unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                        function14 = function8;
                        modifier4 = modifier2;
                        j4 = jM244contentColorForek8zF_U2;
                        function15 = function7;
                        function16 = function6;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i15 != 0) {
                            function6 = ScrimKt.f7lambda$39202156;
                        }
                        if (i5 != 0) {
                            function7 = ScrimKt.lambda$1582488484;
                        }
                        if (i7 != 0) {
                            function8 = ScrimKt.lambda$414328099;
                        }
                        ComposableLambdaImpl composableLambdaImpl4 = ScrimKt.f6lambda$1514016380;
                        long jM244contentColorForek8zF_U3 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                        WeakHashMap weakHashMap3 = WindowInsetsHolder.viewMap;
                        function13 = composableLambdaImpl4;
                        i12 = 2;
                        i13 = i10 & (-264241153);
                        unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                        function14 = function8;
                        modifier4 = modifier2;
                        j4 = jM244contentColorForek8zF_U3;
                        function15 = function7;
                        function16 = function6;
                    }
                    gapComposer.endDefaults();
                    zChanged = gapComposer.changed(unionInsets);
                    objRememberedValue = gapComposer.rememberedValue();
                    Object obj2 = Composer$Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SurfaceKt.m269SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j, j4, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(848889571, new ScaffoldKt$$ExternalSyntheticLambda1(i12, function16, composableLambdaImpl, function14, function13, mutableWindowInsets, function15), gapComposer), gapComposer, ((i13 >> 12) & 896) | 12582912, 114);
                    j3 = j4;
                    modifier3 = modifier4;
                    windowInsets2 = unionInsets;
                    i11 = i12;
                    function10 = function16;
                    function12 = function14;
                    function9 = function13;
                    function11 = function15;
                } else {
                    gapComposer.skipToGroupEnd();
                    function9 = function5;
                    i11 = i;
                    windowInsets2 = windowInsets;
                    modifier3 = modifier2;
                    function10 = function6;
                    function11 = function7;
                    function12 = function8;
                    j3 = j2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            ((Integer) obj4).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            ScaffoldKt.m261ScaffoldTvnljyQ(modifier3, function10, function11, function12, function9, i11, j, j3, windowInsets2, composableLambdaImpl, (GapComposer) obj3, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 384;
            function7 = function3;
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    function8 = function4;
                    if (gapComposer.changedInstance(function8)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i4 |= i8;
                }
                int i18 = i4 | 221184;
                if (gapComposer.changed(j)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i10 = i18 | i9 | 37748736;
                if ((306783379 & i10) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i10 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i15 != 0) {
                            function6 = ScrimKt.f7lambda$39202156;
                        }
                        if (i5 != 0) {
                            function7 = ScrimKt.lambda$1582488484;
                        }
                        if (i7 != 0) {
                            function8 = ScrimKt.lambda$414328099;
                        }
                        ComposableLambdaImpl composableLambdaImpl5 = ScrimKt.f6lambda$1514016380;
                        long jM244contentColorForek8zF_U4 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                        WeakHashMap weakHashMap4 = WindowInsetsHolder.viewMap;
                        function13 = composableLambdaImpl5;
                        i12 = 2;
                        i13 = i10 & (-264241153);
                        unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                        function14 = function8;
                        modifier4 = modifier2;
                        j4 = jM244contentColorForek8zF_U4;
                        function15 = function7;
                        function16 = function6;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i15 != 0) {
                            function6 = ScrimKt.f7lambda$39202156;
                        }
                        if (i5 != 0) {
                            function7 = ScrimKt.lambda$1582488484;
                        }
                        if (i7 != 0) {
                            function8 = ScrimKt.lambda$414328099;
                        }
                        ComposableLambdaImpl composableLambdaImpl6 = ScrimKt.f6lambda$1514016380;
                        long jM244contentColorForek8zF_U5 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                        WeakHashMap weakHashMap5 = WindowInsetsHolder.viewMap;
                        function13 = composableLambdaImpl6;
                        i12 = 2;
                        i13 = i10 & (-264241153);
                        unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                        function14 = function8;
                        modifier4 = modifier2;
                        j4 = jM244contentColorForek8zF_U5;
                        function15 = function7;
                        function16 = function6;
                    }
                    gapComposer.endDefaults();
                    zChanged = gapComposer.changed(unionInsets);
                    objRememberedValue = gapComposer.rememberedValue();
                    Object obj3 = Composer$Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SurfaceKt.m269SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j, j4, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(848889571, new ScaffoldKt$$ExternalSyntheticLambda1(i12, function16, composableLambdaImpl, function14, function13, mutableWindowInsets, function15), gapComposer), gapComposer, ((i13 >> 12) & 896) | 12582912, 114);
                    j3 = j4;
                    modifier3 = modifier4;
                    windowInsets2 = unionInsets;
                    i11 = i12;
                    function10 = function16;
                    function12 = function14;
                    function9 = function13;
                    function11 = function15;
                } else {
                    gapComposer.skipToGroupEnd();
                    function9 = function5;
                    i11 = i;
                    windowInsets2 = windowInsets;
                    modifier3 = modifier2;
                    function10 = function6;
                    function11 = function7;
                    function12 = function8;
                    j3 = j2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj4, Object obj5) {
                            ((Integer) obj5).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            ScaffoldKt.m261ScaffoldTvnljyQ(modifier3, function10, function11, function12, function9, i11, j, j3, windowInsets2, composableLambdaImpl, (GapComposer) obj4, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 3072;
            function8 = function4;
            int i19 = i4 | 221184;
            if (gapComposer.changed(j)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i10 = i19 | i9 | 37748736;
            if ((306783379 & i10) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i10 & 1, z)) {
                gapComposer.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i15 != 0) {
                        function6 = ScrimKt.f7lambda$39202156;
                    }
                    if (i5 != 0) {
                        function7 = ScrimKt.lambda$1582488484;
                    }
                    if (i7 != 0) {
                        function8 = ScrimKt.lambda$414328099;
                    }
                    ComposableLambdaImpl composableLambdaImpl7 = ScrimKt.f6lambda$1514016380;
                    long jM244contentColorForek8zF_U6 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                    WeakHashMap weakHashMap6 = WindowInsetsHolder.viewMap;
                    function13 = composableLambdaImpl7;
                    i12 = 2;
                    i13 = i10 & (-264241153);
                    unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                    function14 = function8;
                    modifier4 = modifier2;
                    j4 = jM244contentColorForek8zF_U6;
                    function15 = function7;
                    function16 = function6;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i15 != 0) {
                        function6 = ScrimKt.f7lambda$39202156;
                    }
                    if (i5 != 0) {
                        function7 = ScrimKt.lambda$1582488484;
                    }
                    if (i7 != 0) {
                        function8 = ScrimKt.lambda$414328099;
                    }
                    ComposableLambdaImpl composableLambdaImpl8 = ScrimKt.f6lambda$1514016380;
                    long jM244contentColorForek8zF_U7 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                    WeakHashMap weakHashMap7 = WindowInsetsHolder.viewMap;
                    function13 = composableLambdaImpl8;
                    i12 = 2;
                    i13 = i10 & (-264241153);
                    unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                    function14 = function8;
                    modifier4 = modifier2;
                    j4 = jM244contentColorForek8zF_U7;
                    function15 = function7;
                    function16 = function6;
                }
                gapComposer.endDefaults();
                zChanged = gapComposer.changed(unionInsets);
                objRememberedValue = gapComposer.rememberedValue();
                Object obj4 = Composer$Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                SurfaceKt.m269SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j, j4, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(848889571, new ScaffoldKt$$ExternalSyntheticLambda1(i12, function16, composableLambdaImpl, function14, function13, mutableWindowInsets, function15), gapComposer), gapComposer, ((i13 >> 12) & 896) | 12582912, 114);
                j3 = j4;
                modifier3 = modifier4;
                windowInsets2 = unionInsets;
                i11 = i12;
                function10 = function16;
                function12 = function14;
                function9 = function13;
                function11 = function15;
            } else {
                gapComposer.skipToGroupEnd();
                function9 = function5;
                i11 = i;
                windowInsets2 = windowInsets;
                modifier3 = modifier2;
                function10 = function6;
                function11 = function7;
                function12 = function8;
                j3 = j2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj5, Object obj6) {
                        ((Integer) obj6).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        ScaffoldKt.m261ScaffoldTvnljyQ(modifier3, function10, function11, function12, function9, i11, j, j3, windowInsets2, composableLambdaImpl, (GapComposer) obj5, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 48;
        function6 = function2;
        i5 = i3 & 4;
        if (i5 != 0) {
            if ((i2 & 384) == 0) {
                function7 = function3;
                if (gapComposer.changedInstance(function7)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i4 |= i6;
            }
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    function8 = function4;
                    if (gapComposer.changedInstance(function8)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i4 |= i8;
                }
                int i110 = i4 | 221184;
                if (gapComposer.changed(j)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i10 = i110 | i9 | 37748736;
                if ((306783379 & i10) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i10 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i15 != 0) {
                            function6 = ScrimKt.f7lambda$39202156;
                        }
                        if (i5 != 0) {
                            function7 = ScrimKt.lambda$1582488484;
                        }
                        if (i7 != 0) {
                            function8 = ScrimKt.lambda$414328099;
                        }
                        ComposableLambdaImpl composableLambdaImpl9 = ScrimKt.f6lambda$1514016380;
                        long jM244contentColorForek8zF_U8 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                        WeakHashMap weakHashMap8 = WindowInsetsHolder.viewMap;
                        function13 = composableLambdaImpl9;
                        i12 = 2;
                        i13 = i10 & (-264241153);
                        unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                        function14 = function8;
                        modifier4 = modifier2;
                        j4 = jM244contentColorForek8zF_U8;
                        function15 = function7;
                        function16 = function6;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i15 != 0) {
                            function6 = ScrimKt.f7lambda$39202156;
                        }
                        if (i5 != 0) {
                            function7 = ScrimKt.lambda$1582488484;
                        }
                        if (i7 != 0) {
                            function8 = ScrimKt.lambda$414328099;
                        }
                        ComposableLambdaImpl composableLambdaImpl10 = ScrimKt.f6lambda$1514016380;
                        long jM244contentColorForek8zF_U9 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                        WeakHashMap weakHashMap9 = WindowInsetsHolder.viewMap;
                        function13 = composableLambdaImpl10;
                        i12 = 2;
                        i13 = i10 & (-264241153);
                        unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                        function14 = function8;
                        modifier4 = modifier2;
                        j4 = jM244contentColorForek8zF_U9;
                        function15 = function7;
                        function16 = function6;
                    }
                    gapComposer.endDefaults();
                    zChanged = gapComposer.changed(unionInsets);
                    objRememberedValue = gapComposer.rememberedValue();
                    Object obj5 = Composer$Companion.Empty;
                    if (zChanged) {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SurfaceKt.m269SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j, j4, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(848889571, new ScaffoldKt$$ExternalSyntheticLambda1(i12, function16, composableLambdaImpl, function14, function13, mutableWindowInsets, function15), gapComposer), gapComposer, ((i13 >> 12) & 896) | 12582912, 114);
                    j3 = j4;
                    modifier3 = modifier4;
                    windowInsets2 = unionInsets;
                    i11 = i12;
                    function10 = function16;
                    function12 = function14;
                    function9 = function13;
                    function11 = function15;
                } else {
                    gapComposer.skipToGroupEnd();
                    function9 = function5;
                    i11 = i;
                    windowInsets2 = windowInsets;
                    modifier3 = modifier2;
                    function10 = function6;
                    function11 = function7;
                    function12 = function8;
                    j3 = j2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj6, Object obj7) {
                            ((Integer) obj7).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                            ScaffoldKt.m261ScaffoldTvnljyQ(modifier3, function10, function11, function12, function9, i11, j, j3, windowInsets2, composableLambdaImpl, (GapComposer) obj6, iUpdateChangedFlags, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 3072;
            function8 = function4;
            int i111 = i4 | 221184;
            if (gapComposer.changed(j)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i10 = i111 | i9 | 37748736;
            if ((306783379 & i10) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i10 & 1, z)) {
                gapComposer.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i15 != 0) {
                        function6 = ScrimKt.f7lambda$39202156;
                    }
                    if (i5 != 0) {
                        function7 = ScrimKt.lambda$1582488484;
                    }
                    if (i7 != 0) {
                        function8 = ScrimKt.lambda$414328099;
                    }
                    ComposableLambdaImpl composableLambdaImpl11 = ScrimKt.f6lambda$1514016380;
                    long jM244contentColorForek8zF_U10 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                    WeakHashMap weakHashMap10 = WindowInsetsHolder.viewMap;
                    function13 = composableLambdaImpl11;
                    i12 = 2;
                    i13 = i10 & (-264241153);
                    unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                    function14 = function8;
                    modifier4 = modifier2;
                    j4 = jM244contentColorForek8zF_U10;
                    function15 = function7;
                    function16 = function6;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i15 != 0) {
                        function6 = ScrimKt.f7lambda$39202156;
                    }
                    if (i5 != 0) {
                        function7 = ScrimKt.lambda$1582488484;
                    }
                    if (i7 != 0) {
                        function8 = ScrimKt.lambda$414328099;
                    }
                    ComposableLambdaImpl composableLambdaImpl12 = ScrimKt.f6lambda$1514016380;
                    long jM244contentColorForek8zF_U11 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                    WeakHashMap weakHashMap11 = WindowInsetsHolder.viewMap;
                    function13 = composableLambdaImpl12;
                    i12 = 2;
                    i13 = i10 & (-264241153);
                    unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                    function14 = function8;
                    modifier4 = modifier2;
                    j4 = jM244contentColorForek8zF_U11;
                    function15 = function7;
                    function16 = function6;
                }
                gapComposer.endDefaults();
                zChanged = gapComposer.changed(unionInsets);
                objRememberedValue = gapComposer.rememberedValue();
                Object obj6 = Composer$Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                SurfaceKt.m269SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j, j4, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(848889571, new ScaffoldKt$$ExternalSyntheticLambda1(i12, function16, composableLambdaImpl, function14, function13, mutableWindowInsets, function15), gapComposer), gapComposer, ((i13 >> 12) & 896) | 12582912, 114);
                j3 = j4;
                modifier3 = modifier4;
                windowInsets2 = unionInsets;
                i11 = i12;
                function10 = function16;
                function12 = function14;
                function9 = function13;
                function11 = function15;
            } else {
                gapComposer.skipToGroupEnd();
                function9 = function5;
                i11 = i;
                windowInsets2 = windowInsets;
                modifier3 = modifier2;
                function10 = function6;
                function11 = function7;
                function12 = function8;
                j3 = j2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj7, Object obj8) {
                        ((Integer) obj8).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        ScaffoldKt.m261ScaffoldTvnljyQ(modifier3, function10, function11, function12, function9, i11, j, j3, windowInsets2, composableLambdaImpl, (GapComposer) obj7, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 384;
        function7 = function3;
        i7 = i3 & 8;
        if (i7 != 0) {
            if ((i2 & 3072) == 0) {
                function8 = function4;
                if (gapComposer.changedInstance(function8)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i4 |= i8;
            }
            int i112 = i4 | 221184;
            if (gapComposer.changed(j)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i10 = i112 | i9 | 37748736;
            if ((306783379 & i10) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i10 & 1, z)) {
                gapComposer.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i15 != 0) {
                        function6 = ScrimKt.f7lambda$39202156;
                    }
                    if (i5 != 0) {
                        function7 = ScrimKt.lambda$1582488484;
                    }
                    if (i7 != 0) {
                        function8 = ScrimKt.lambda$414328099;
                    }
                    ComposableLambdaImpl composableLambdaImpl13 = ScrimKt.f6lambda$1514016380;
                    long jM244contentColorForek8zF_U12 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                    WeakHashMap weakHashMap12 = WindowInsetsHolder.viewMap;
                    function13 = composableLambdaImpl13;
                    i12 = 2;
                    i13 = i10 & (-264241153);
                    unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                    function14 = function8;
                    modifier4 = modifier2;
                    j4 = jM244contentColorForek8zF_U12;
                    function15 = function7;
                    function16 = function6;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i15 != 0) {
                        function6 = ScrimKt.f7lambda$39202156;
                    }
                    if (i5 != 0) {
                        function7 = ScrimKt.lambda$1582488484;
                    }
                    if (i7 != 0) {
                        function8 = ScrimKt.lambda$414328099;
                    }
                    ComposableLambdaImpl composableLambdaImpl14 = ScrimKt.f6lambda$1514016380;
                    long jM244contentColorForek8zF_U13 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                    WeakHashMap weakHashMap13 = WindowInsetsHolder.viewMap;
                    function13 = composableLambdaImpl14;
                    i12 = 2;
                    i13 = i10 & (-264241153);
                    unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                    function14 = function8;
                    modifier4 = modifier2;
                    j4 = jM244contentColorForek8zF_U13;
                    function15 = function7;
                    function16 = function6;
                }
                gapComposer.endDefaults();
                zChanged = gapComposer.changed(unionInsets);
                objRememberedValue = gapComposer.rememberedValue();
                Object obj7 = Composer$Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                SurfaceKt.m269SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j, j4, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(848889571, new ScaffoldKt$$ExternalSyntheticLambda1(i12, function16, composableLambdaImpl, function14, function13, mutableWindowInsets, function15), gapComposer), gapComposer, ((i13 >> 12) & 896) | 12582912, 114);
                j3 = j4;
                modifier3 = modifier4;
                windowInsets2 = unionInsets;
                i11 = i12;
                function10 = function16;
                function12 = function14;
                function9 = function13;
                function11 = function15;
            } else {
                gapComposer.skipToGroupEnd();
                function9 = function5;
                i11 = i;
                windowInsets2 = windowInsets;
                modifier3 = modifier2;
                function10 = function6;
                function11 = function7;
                function12 = function8;
                j3 = j2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        ((Integer) obj9).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                        ScaffoldKt.m261ScaffoldTvnljyQ(modifier3, function10, function11, function12, function9, i11, j, j3, windowInsets2, composableLambdaImpl, (GapComposer) obj8, iUpdateChangedFlags, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 3072;
        function8 = function4;
        int i113 = i4 | 221184;
        if (gapComposer.changed(j)) {
            i9 = 1048576;
        } else {
            i9 = 524288;
        }
        i10 = i113 | i9 | 37748736;
        if ((306783379 & i10) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i10 & 1, z)) {
            gapComposer.startDefaults();
            if ((i2 & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i15 != 0) {
                    function6 = ScrimKt.f7lambda$39202156;
                }
                if (i5 != 0) {
                    function7 = ScrimKt.lambda$1582488484;
                }
                if (i7 != 0) {
                    function8 = ScrimKt.lambda$414328099;
                }
                ComposableLambdaImpl composableLambdaImpl15 = ScrimKt.f6lambda$1514016380;
                long jM244contentColorForek8zF_U14 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                WeakHashMap weakHashMap14 = WindowInsetsHolder.viewMap;
                function13 = composableLambdaImpl15;
                i12 = 2;
                i13 = i10 & (-264241153);
                unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                function14 = function8;
                modifier4 = modifier2;
                j4 = jM244contentColorForek8zF_U14;
                function15 = function7;
                function16 = function6;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i15 != 0) {
                    function6 = ScrimKt.f7lambda$39202156;
                }
                if (i5 != 0) {
                    function7 = ScrimKt.lambda$1582488484;
                }
                if (i7 != 0) {
                    function8 = ScrimKt.lambda$414328099;
                }
                ComposableLambdaImpl composableLambdaImpl16 = ScrimKt.f6lambda$1514016380;
                long jM244contentColorForek8zF_U15 = ColorSchemeKt.m244contentColorForek8zF_U(j, gapComposer);
                WeakHashMap weakHashMap15 = WindowInsetsHolder.viewMap;
                function13 = composableLambdaImpl16;
                i12 = 2;
                i13 = i10 & (-264241153);
                unionInsets = new UnionInsets(FlowRowOverflow.current(gapComposer).systemBars, FlowRowOverflow.current(gapComposer).displayCutout);
                function14 = function8;
                modifier4 = modifier2;
                j4 = jM244contentColorForek8zF_U15;
                function15 = function7;
                function16 = function6;
            }
            gapComposer.endDefaults();
            zChanged = gapComposer.changed(unionInsets);
            objRememberedValue = gapComposer.rememberedValue();
            Object obj8 = Composer$Companion.Empty;
            if (zChanged) {
                objRememberedValue = new MutableWindowInsets(unionInsets);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new MutableWindowInsets(unionInsets);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
            zChanged2 = gapComposer.changed(mutableWindowInsets) | gapComposer.changed(unionInsets);
            objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged2) {
                objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(3, mutableWindowInsets, unionInsets);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            SurfaceKt.m269SurfaceT9BRK9s(OffsetKt.onConsumedWindowInsetsChanged(modifier4, (Function1) objRememberedValue2), null, j, j4, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(848889571, new ScaffoldKt$$ExternalSyntheticLambda1(i12, function16, composableLambdaImpl, function14, function13, mutableWindowInsets, function15), gapComposer), gapComposer, ((i13 >> 12) & 896) | 12582912, 114);
            j3 = j4;
            modifier3 = modifier4;
            windowInsets2 = unionInsets;
            i11 = i12;
            function10 = function16;
            function12 = function14;
            function9 = function13;
            function11 = function15;
        } else {
            gapComposer.skipToGroupEnd();
            function9 = function5;
            i11 = i;
            windowInsets2 = windowInsets;
            modifier3 = modifier2;
            function10 = function6;
            function11 = function7;
            function12 = function8;
            j3 = j2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj9, Object obj10) {
                    ((Integer) obj10).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                    ScaffoldKt.m261ScaffoldTvnljyQ(modifier3, function10, function11, function12, function9, i11, j, j3, windowInsets2, composableLambdaImpl, (GapComposer) obj9, iUpdateChangedFlags, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m262ScaffoldLayoutFMILGgc(int i, Function2 function2, ComposableLambdaImpl composableLambdaImpl, Function2 function3, Function2 function4, WindowInsets windowInsets, Function2 function5, GapComposer gapComposer, int i2) {
        gapComposer.startRestartGroup(-280287501);
        int i3 = i2 | (gapComposer.changed(i) ? 4 : 2) | (gapComposer.changedInstance(function2) ? 32 : 16) | (gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128) | (gapComposer.changedInstance(function3) ? 2048 : 1024) | (gapComposer.changedInstance(function4) ? 16384 : 8192) | (gapComposer.changed(windowInsets) ? 131072 : 65536) | (gapComposer.changedInstance(function5) ? 1048576 : 524288);
        if (gapComposer.shouldExecute(i3 & 1, (599187 & i3) != 599186)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = new ScaffoldKt$ScaffoldLayout$contentPadding$1$1();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) objRememberedValue;
            boolean z = (i3 & 112) == 32;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z || objRememberedValue2 == obj) {
                objRememberedValue2 = new ComposableLambdaImpl(605195056, new ScaffoldKt$$ExternalSyntheticLambda3(0, function2), true);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Function2 function6 = (Function2) objRememberedValue2;
            boolean z2 = (i3 & 7168) == 2048;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (z2 || objRememberedValue3 == obj) {
                objRememberedValue3 = new ComposableLambdaImpl(418899191, new ScaffoldKt$$ExternalSyntheticLambda3(3, function3), true);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Function2 function7 = (Function2) objRememberedValue3;
            boolean z3 = (57344 & i3) == 16384;
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (z3 || objRememberedValue4 == obj) {
                objRememberedValue4 = new ComposableLambdaImpl(338600263, new ScaffoldKt$$ExternalSyntheticLambda3(4, function4), true);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Function2 function8 = (Function2) objRememberedValue4;
            boolean z4 = (i3 & 896) == 256;
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (z4 || objRememberedValue5 == obj) {
                objRememberedValue5 = new ComposableLambdaImpl(-1776388365, new TextKt$$ExternalSyntheticLambda2(composableLambdaImpl, scaffoldKt$ScaffoldLayout$contentPadding$1$1, 15), true);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Function2 function9 = (Function2) objRememberedValue5;
            boolean z5 = (i3 & 3670016) == 1048576;
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (z5 || objRememberedValue6 == obj) {
                objRememberedValue6 = new ComposableLambdaImpl(-1731662488, new ScaffoldKt$$ExternalSyntheticLambda3(5, function5), true);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Function2 function10 = (Function2) objRememberedValue6;
            boolean zChanged = ((i3 & 458752) == 131072) | gapComposer.changed(function6) | gapComposer.changed(function7) | gapComposer.changed(function8) | ((i3 & 14) == 4) | gapComposer.changed(function10) | gapComposer.changed(function9);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue7 == obj) {
                Object scaffoldKt$$ExternalSyntheticLambda8 = new ScaffoldKt$$ExternalSyntheticLambda8(windowInsets, function6, function7, function8, i, function10, scaffoldKt$ScaffoldLayout$contentPadding$1$1, function9);
                gapComposer.updateRememberedValue(scaffoldKt$$ExternalSyntheticLambda8);
                objRememberedValue7 = scaffoldKt$$ExternalSyntheticLambda8;
            }
            RulerKt.SubcomposeLayout(null, (Function2) objRememberedValue7, gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ScaffoldKt$$ExternalSyntheticLambda1(i, function2, composableLambdaImpl, function3, function4, windowInsets, function5, i2);
        }
    }
}
