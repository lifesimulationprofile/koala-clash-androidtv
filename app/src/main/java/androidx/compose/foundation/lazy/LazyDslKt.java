package androidx.compose.foundation.lazy;

import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LazyDslKt {
    /* JADX WARN: Code duplicated, block: B:42:0x006f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:82:0x0137  */
    /* JADX WARN: Code duplicated, block: B:85:0x014a  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    public static final void LazyColumn(final Modifier modifier, LazyListState lazyListState, final PaddingValuesImpl paddingValuesImpl, boolean z, final Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, final Function1 function1, GapComposer gapComposer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        LazyListState lazyListStateRememberLazyListState;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        final FlingBehavior flingBehavior2;
        final boolean z6;
        final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2;
        final LazyListState lazyListState2;
        final boolean z7;
        final Alignment.Horizontal horizontal2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i6;
        Alignment.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
        int i7;
        int i8;
        gapComposer.startRestartGroup(53695811);
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (gapComposer.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListStateRememberLazyListState = lazyListState;
                int i9 = gapComposer.changed(lazyListStateRememberLazyListState) ? 32 : 16;
                i3 |= i9;
            } else {
                lazyListStateRememberLazyListState = lazyListState;
            }
            i3 |= i9;
        } else {
            lazyListStateRememberLazyListState = lazyListState;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(paddingValuesImpl) ? 256 : 128;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 3072) == 0) {
                z3 = z;
                i3 |= gapComposer.changed(z3) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if (gapComposer.changed(vertical)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            i4 = 196608 | i3;
            if ((1572864 & i) == 0) {
                i4 = 720896 | i3;
            }
            i5 = 12582912 | i4;
            if ((100663296 & i) == 0) {
                i5 = 46137344 | i4;
            }
            if ((805306368 & i) == 0) {
                if (gapComposer.changedInstance(function1)) {
                    i7 = 536870912;
                } else {
                    i7 = 268435456;
                }
                i5 |= i7;
            }
            z4 = true;
            if ((306783379 & i5) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (gapComposer.shouldExecute(i5 & 1, z5)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
                        i5 &= -113;
                    }
                    if (i10 != 0) {
                        z3 = false;
                    }
                    i6 = i5 & (-238551041);
                    horizontal3 = Alignment.Companion.Start;
                    flingBehavior3 = ScrollableKt.flingBehavior(gapComposer);
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                } else {
                    gapComposer.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i5 &= -113;
                    }
                    i6 = i5 & (-238551041);
                    horizontal3 = horizontal;
                    flingBehavior3 = flingBehavior;
                    z4 = z2;
                    androidEdgeEffectOverscrollEffectRememberOverscrollEffect = androidEdgeEffectOverscrollEffect;
                }
                gapComposer.endDefaults();
                Modifier modifier3 = modifier2;
                LazyListState lazyListState3 = lazyListStateRememberLazyListState;
                boolean z8 = z3;
                boolean z9 = z4;
                LazyListKt.LazyList(modifier3, lazyListState3, paddingValuesImpl, z8, true, flingBehavior3, z9, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, horizontal3, vertical, null, null, function1, gapComposer, ((i6 << 12) & 1879048192) | (i6 & 14) | 24576 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | ((i6 >> 3) & 3670016), ((i6 >> 12) & 14) | ((i6 >> 18) & 7168), 6400);
                Alignment.Horizontal horizontal4 = horizontal3;
                z6 = z9;
                horizontal2 = horizontal4;
                lazyListState2 = lazyListState3;
                z7 = z8;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
                flingBehavior2 = flingBehavior3;
            } else {
                gapComposer.skipToGroupEnd();
                flingBehavior2 = flingBehavior;
                z6 = z2;
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                lazyListState2 = lazyListStateRememberLazyListState;
                z7 = z3;
                horizontal2 = horizontal;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        LazyDslKt.LazyColumn(modifier, lazyListState2, paddingValuesImpl, z7, vertical, horizontal2, flingBehavior2, z6, androidEdgeEffectOverscrollEffect2, function1, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 3072;
        z3 = z;
        if ((i & 24576) == 0) {
            if (gapComposer.changed(vertical)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        }
        i4 = 196608 | i3;
        if ((1572864 & i) == 0) {
            i4 = 720896 | i3;
        }
        i5 = 12582912 | i4;
        if ((100663296 & i) == 0) {
            i5 = 46137344 | i4;
        }
        if ((805306368 & i) == 0) {
            if (gapComposer.changedInstance(function1)) {
                i7 = 536870912;
            } else {
                i7 = 268435456;
            }
            i5 |= i7;
        }
        z4 = true;
        if ((306783379 & i5) != 306783378) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (gapComposer.shouldExecute(i5 & 1, z5)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
                    i5 &= -113;
                }
                if (i10 != 0) {
                    z3 = false;
                }
                i6 = i5 & (-238551041);
                horizontal3 = Alignment.Companion.Start;
                flingBehavior3 = ScrollableKt.flingBehavior(gapComposer);
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
            } else {
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
                    i5 &= -113;
                }
                if (i10 != 0) {
                    z3 = false;
                }
                i6 = i5 & (-238551041);
                horizontal3 = Alignment.Companion.Start;
                flingBehavior3 = ScrollableKt.flingBehavior(gapComposer);
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
            }
            gapComposer.endDefaults();
            Modifier modifier4 = modifier2;
            LazyListState lazyListState4 = lazyListStateRememberLazyListState;
            boolean z10 = z3;
            boolean z11 = z4;
            LazyListKt.LazyList(modifier4, lazyListState4, paddingValuesImpl, z10, true, flingBehavior3, z11, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, horizontal3, vertical, null, null, function1, gapComposer, ((i6 << 12) & 1879048192) | (i6 & 14) | 24576 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | ((i6 >> 3) & 3670016), ((i6 >> 12) & 14) | ((i6 >> 18) & 7168), 6400);
            Alignment.Horizontal horizontal5 = horizontal3;
            z6 = z11;
            horizontal2 = horizontal5;
            lazyListState2 = lazyListState4;
            z7 = z10;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
            flingBehavior2 = flingBehavior3;
        } else {
            gapComposer.skipToGroupEnd();
            flingBehavior2 = flingBehavior;
            z6 = z2;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            lazyListState2 = lazyListStateRememberLazyListState;
            z7 = z3;
            horizontal2 = horizontal;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    LazyDslKt.LazyColumn(modifier, lazyListState2, paddingValuesImpl, z7, vertical, horizontal2, flingBehavior2, z6, androidEdgeEffectOverscrollEffect2, function1, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void LazyRow(final Modifier modifier, LazyListState lazyListState, final PaddingValuesImpl paddingValuesImpl, final Arrangement.Horizontal horizontal, BiasAlignment.Vertical vertical, FlingBehavior flingBehavior, boolean z, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, final Function1 function1, GapComposer gapComposer, final int i) {
        final LazyListState lazyListState2;
        final BiasAlignment.Vertical vertical2;
        final FlingBehavior flingBehavior2;
        final boolean z2;
        final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2;
        LazyListState lazyListStateRememberLazyListState;
        FlingBehavior flingBehavior3;
        int i2;
        BiasAlignment.Vertical vertical3;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
        boolean z3;
        gapComposer.startRestartGroup(-1884325601);
        int i3 = i | 46861328 | (gapComposer.changedInstance(function1) ? 536870912 : 268435456);
        if (gapComposer.shouldExecute(i3 & 1, (306783379 & i3) != 306783378)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
                BiasAlignment.Vertical vertical4 = Alignment.Companion.Top;
                flingBehavior3 = ScrollableKt.flingBehavior(gapComposer);
                i2 = i3 & (-238551153);
                vertical3 = vertical4;
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(gapComposer);
                z3 = true;
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-238551153);
                lazyListStateRememberLazyListState = lazyListState;
                vertical3 = vertical;
                flingBehavior3 = flingBehavior;
                z3 = z;
                androidEdgeEffectOverscrollEffectRememberOverscrollEffect = androidEdgeEffectOverscrollEffect;
            }
            gapComposer.endDefaults();
            LazyListKt.LazyList(modifier, lazyListStateRememberLazyListState, paddingValuesImpl, false, false, flingBehavior3, z3, androidEdgeEffectOverscrollEffectRememberOverscrollEffect, null, null, vertical3, horizontal, function1, gapComposer, 1600902, 432 | ((i2 >> 18) & 7168), 1792);
            lazyListState2 = lazyListStateRememberLazyListState;
            z2 = z3;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffectRememberOverscrollEffect;
            vertical2 = vertical3;
            flingBehavior2 = flingBehavior3;
        } else {
            gapComposer.skipToGroupEnd();
            lazyListState2 = lazyListState;
            vertical2 = vertical;
            flingBehavior2 = flingBehavior;
            z2 = z;
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(lazyListState2, paddingValuesImpl, horizontal, vertical2, flingBehavior2, z2, androidEdgeEffectOverscrollEffect2, function1, i) { // from class: androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda1
                public final /* synthetic */ LazyListState f$1;
                public final /* synthetic */ PaddingValuesImpl f$2;
                public final /* synthetic */ Arrangement.Horizontal f$4;
                public final /* synthetic */ BiasAlignment.Vertical f$5;
                public final /* synthetic */ FlingBehavior f$6;
                public final /* synthetic */ boolean f$7;
                public final /* synthetic */ AndroidEdgeEffectOverscrollEffect f$8;
                public final /* synthetic */ Function1 f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(24967);
                    LazyDslKt.LazyRow(this.f$0, this.f$1, this.f$2, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
