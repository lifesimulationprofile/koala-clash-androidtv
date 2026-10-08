package androidx.compose.foundation.lazy;

import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement$Companion;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.core.view.MenuHostHelper;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LazyListKt {
    /* JADX WARN: Code duplicated, block: B:155:0x01df  */
    /* JADX WARN: Code duplicated, block: B:175:0x0263  */
    /* JADX WARN: Code duplicated, block: B:178:0x0273  */
    /* JADX WARN: Code duplicated, block: B:181:0x0292  */
    /* JADX WARN: Code duplicated, block: B:251:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:254:0x03be  */
    /* JADX WARN: Code duplicated, block: B:256:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:258:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:270:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:272:0x0405  */
    public static final void LazyList(final Modifier modifier, LazyListState lazyListState, final PaddingValuesImpl paddingValuesImpl, final boolean z, final boolean z2, final FlingBehavior flingBehavior, final boolean z3, final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, BiasAlignment.Vertical vertical2, Arrangement.Horizontal horizontal2, final Function1 function1, GapComposer gapComposer, final int i, final int i2, final int i3) {
        int i4;
        Alignment.Horizontal horizontal3;
        int i5;
        int i6;
        LazyListState lazyListState2;
        final BiasAlignment.Vertical vertical3;
        final Arrangement.Horizontal horizontal4;
        final Alignment.Horizontal horizontal5;
        final Arrangement.Vertical vertical4;
        int i7;
        BiasAlignment.Vertical vertical5;
        Arrangement.Horizontal horizontal6;
        int i8;
        MutableState mutableStateRememberUpdatedState;
        boolean z4;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        KProperty0 kProperty0;
        boolean z5;
        Object objRememberedValue2;
        Object objRememberedValue3;
        CoroutineScope coroutineScope;
        GraphicsContext graphicsContext;
        DummyHandle dummyHandle;
        boolean zChanged;
        Object lazyListKt$rememberLazyListMeasurePolicy$1$1;
        Alignment.Horizontal horizontal7;
        int i9;
        boolean z6;
        KProperty0 kProperty1;
        Orientation orientation;
        Orientation orientation2;
        Modifier modifierLazyLayoutBeyondBoundsModifier;
        boolean zChanged2;
        Object objRememberedValue4;
        boolean z7 = z;
        gapComposer.startRestartGroup(924924659);
        if ((i & 6) == 0) {
            i4 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= gapComposer.changed(lazyListState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= gapComposer.changed(paddingValuesImpl) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= gapComposer.changed(z7) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= gapComposer.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= gapComposer.changed(flingBehavior) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= gapComposer.changed(z3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= gapComposer.changed(androidEdgeEffectOverscrollEffect) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= 33554432;
        }
        int i10 = i3 & 512;
        if (i10 != 0) {
            i4 |= 805306368;
            horizontal3 = horizontal;
        } else {
            horizontal3 = horizontal;
            if ((i & 805306368) == 0) {
                i4 |= gapComposer.changed(horizontal3) ? 536870912 : 268435456;
            }
        }
        int i11 = i3 & 1024;
        if (i11 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = i2 | (gapComposer.changed(vertical) ? 4 : 2);
        } else {
            i5 = i2;
        }
        int i12 = i3 & 2048;
        if (i12 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= gapComposer.changed(vertical2) ? 32 : 16;
        }
        int i13 = i5;
        int i14 = i3 & 4096;
        if (i14 != 0) {
            i6 = i13 | 384;
        } else if ((i2 & 384) == 0) {
            i6 = i13 | (gapComposer.changed(horizontal2) ? 256 : 128);
        } else {
            i6 = i13;
        }
        if ((i2 & 3072) == 0) {
            i6 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        int i15 = i6;
        if (gapComposer.shouldExecute(i4 & 1, ((i4 & 306783379) == 306783378 && (i15 & 1171) == 1170) ? false : true)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i7 = i4 & (-234881025);
                if (i10 != 0) {
                    horizontal3 = null;
                }
                vertical4 = i11 != 0 ? null : vertical;
                vertical5 = i12 != 0 ? null : vertical2;
                if (i14 != 0) {
                    horizontal6 = null;
                }
                gapComposer.endDefaults();
                i8 = i7 >> 3;
                int i16 = i8 & 14;
                int i17 = ((i15 >> 6) & 112) | i16;
                mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer);
                int i18 = i7;
                z4 = (((i17 & 14) ^ 6) <= 4 && gapComposer.changed(lazyListState)) || (i17 & 6) == 4;
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer$Companion.Empty;
                if (z4 || objRememberedValue == neverEqualPolicy) {
                    LazyItemScopeImpl lazyItemScopeImpl = new LazyItemScopeImpl();
                    lazyItemScopeImpl.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                    lazyItemScopeImpl.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                    NeverEqualPolicy neverEqualPolicy2 = NeverEqualPolicy.INSTANCE$1;
                    TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda0 = new TooltipKt$$ExternalSyntheticLambda0(mutableStateRememberUpdatedState, 1);
                    MenuHostHelper menuHostHelper = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    objRememberedValue = new LockFreeLinkedListNode.AnonymousClass1(0, 1, State.class, new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(tooltipKt$$ExternalSyntheticLambda0, neverEqualPolicy2), lazyListState, lazyItemScopeImpl, 2), neverEqualPolicy2), "value", "getValue()Ljava/lang/Object;");
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                kProperty0 = (KProperty0) objRememberedValue;
                int i19 = i18 >> 9;
                int i20 = i16 | (i19 & 112);
                z5 = ((((i20 & 112) ^ 48) <= 32 && gapComposer.changed(z2)) || (i20 & 48) == 32) | ((((i20 & 14) ^ 6) <= 4 && gapComposer.changed(lazyListState)) || (i20 & 6) == 4);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z5 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1(lazyListState, z2);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 = (LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1) objRememberedValue2;
                objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                coroutineScope = (CoroutineScope) objRememberedValue3;
                graphicsContext = (GraphicsContext) gapComposer.consume(CompositionLocalsKt.LocalGraphicsContext);
                dummyHandle = ((Boolean) gapComposer.consume(CompositionLocalsKt.LocalProvidableScrollCaptureInProgress)).booleanValue() ? null : StickyItemsPlacement$Companion.StickToTopPlacement;
                int i21 = i15 << 18;
                int i22 = (i18 & 65520) | (i19 & 3670016) | (i21 & 29360128) | (i21 & 234881024) | ((i15 << 27) & 1879048192);
                zChanged = ((((i22 & 3670016) ^ 1572864) <= 1048576 && gapComposer.changed(horizontal3)) || (i22 & 1572864) == 1048576) | ((((i22 & 112) ^ 48) <= 32 && gapComposer.changed(lazyListState)) || (i22 & 48) == 32) | ((((i22 & 896) ^ 384) <= 256 && gapComposer.changed(paddingValuesImpl)) || (i22 & 384) == 256) | ((((i22 & 7168) ^ 3072) <= 2048 && gapComposer.changed(z7)) || (i22 & 3072) == 2048) | ((((57344 & i22) ^ 24576) <= 16384 && gapComposer.changed(z2)) || (i22 & 24576) == 16384) | gapComposer.changed(0) | ((((i22 & 29360128) ^ 12582912) <= 8388608 && gapComposer.changed(vertical5)) || (i22 & 12582912) == 8388608) | ((((i22 & 234881024) ^ 100663296) <= 67108864 && gapComposer.changed(horizontal6)) || (i22 & 100663296) == 67108864) | ((((i22 & 1879048192) ^ 805306368) <= 536870912 && gapComposer.changed(vertical4)) || (i22 & 805306368) == 536870912) | gapComposer.changed(graphicsContext) | gapComposer.changed(dummyHandle);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (!zChanged || objRememberedValue5 == neverEqualPolicy) {
                    horizontal7 = horizontal3;
                    i9 = 4;
                    z6 = true;
                    lazyListKt$rememberLazyListMeasurePolicy$1$1 = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValuesImpl, z7, kProperty0, vertical4, horizontal6, coroutineScope, graphicsContext, dummyHandle, horizontal7, vertical5);
                    kProperty1 = kProperty0;
                    z7 = z7;
                    gapComposer.updateRememberedValue(lazyListKt$rememberLazyListMeasurePolicy$1$1);
                } else {
                    lazyListKt$rememberLazyListMeasurePolicy$1$1 = objRememberedValue5;
                    horizontal7 = horizontal3;
                    i9 = 4;
                    z6 = true;
                    kProperty1 = kProperty0;
                }
                LazyListKt$rememberLazyListMeasurePolicy$1$1 lazyListKt$rememberLazyListMeasurePolicy$1$2 = (LazyListKt$rememberLazyListMeasurePolicy$1$1) lazyListKt$rememberLazyListMeasurePolicy$1$1;
                if (z2) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                orientation2 = orientation;
                if (z3) {
                    gapComposer.startReplaceGroup(-2077147368);
                    zChanged2 = (((((i8 & 14) ^ 6) > i9 || !gapComposer.changed(lazyListState)) && (i8 & 6) != i9) ? false : z6) | gapComposer.changed(0);
                    objRememberedValue4 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new LazyListBeyondBoundsState(r3);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    modifierLazyLayoutBeyondBoundsModifier = LazyLayoutKt.lazyLayoutBeyondBoundsModifier((LazyListBeyondBoundsState) objRememberedValue4, r3.beyondBoundsInfo, z7, orientation2);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-2076718545);
                    gapComposer.end(false);
                    modifierLazyLayoutBeyondBoundsModifier = Modifier.Companion.$$INSTANCE;
                }
                lazyListState2 = r3;
                LazyLayoutKt.LazyLayout(kProperty1, ImageKt.scrollableArea$default(LazyLayoutKt.lazyLayoutSemantics(modifier.then(r3.remeasurementModifier).then(r3.awaitLayoutModifier), kProperty1, lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1, orientation2, z3, z7).then(modifierLazyLayoutBeyondBoundsModifier).then(r3.itemAnimator.modifier), r3, orientation2, androidEdgeEffectOverscrollEffect, z3, z, flingBehavior, r3.internalInteractionSource), lazyListState2.prefetchState, lazyListKt$rememberLazyListMeasurePolicy$1$2, gapComposer, 0);
                horizontal5 = horizontal7;
                vertical3 = vertical5;
                horizontal4 = horizontal6;
            } else {
                gapComposer.skipToGroupEnd();
                i7 = i4 & (-234881025);
                vertical4 = vertical;
                vertical5 = vertical2;
            }
            horizontal6 = horizontal2;
            gapComposer.endDefaults();
            i8 = i7 >> 3;
            int i110 = i8 & 14;
            int i111 = ((i15 >> 6) & 112) | i110;
            mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer);
            int i112 = i7;
            if (((i111 & 14) ^ 6) <= 4) {
            }
            objRememberedValue = gapComposer.rememberedValue();
            neverEqualPolicy = Composer$Companion.Empty;
            if (z4) {
                LazyItemScopeImpl lazyItemScopeImpl2 = new LazyItemScopeImpl();
                lazyItemScopeImpl2.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                lazyItemScopeImpl2.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                NeverEqualPolicy neverEqualPolicy3 = NeverEqualPolicy.INSTANCE$1;
                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda1 = new TooltipKt$$ExternalSyntheticLambda0(mutableStateRememberUpdatedState, 1);
                MenuHostHelper menuHostHelper2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                objRememberedValue = new LockFreeLinkedListNode.AnonymousClass1(0, 1, State.class, new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(tooltipKt$$ExternalSyntheticLambda1, neverEqualPolicy3), lazyListState, lazyItemScopeImpl2, 2), neverEqualPolicy3), "value", "getValue()Ljava/lang/Object;");
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                LazyItemScopeImpl lazyItemScopeImpl3 = new LazyItemScopeImpl();
                lazyItemScopeImpl3.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                lazyItemScopeImpl3.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                NeverEqualPolicy neverEqualPolicy4 = NeverEqualPolicy.INSTANCE$1;
                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda2 = new TooltipKt$$ExternalSyntheticLambda0(mutableStateRememberUpdatedState, 1);
                MenuHostHelper menuHostHelper3 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                objRememberedValue = new LockFreeLinkedListNode.AnonymousClass1(0, 1, State.class, new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(tooltipKt$$ExternalSyntheticLambda2, neverEqualPolicy4), lazyListState, lazyItemScopeImpl3, 2), neverEqualPolicy4), "value", "getValue()Ljava/lang/Object;");
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            kProperty0 = (KProperty0) objRememberedValue;
            int i113 = i112 >> 9;
            int i23 = i110 | (i113 & 112);
            z5 = ((((i23 & 112) ^ 48) <= 32 && gapComposer.changed(z2)) || (i23 & 48) == 32) | ((((i23 & 14) ^ 6) <= 4 && gapComposer.changed(lazyListState)) || (i23 & 6) == 4);
            objRememberedValue2 = gapComposer.rememberedValue();
            if (z5) {
                objRememberedValue2 = new LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1(lazyListState, z2);
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1(lazyListState, z2);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 lazyLayoutSemanticStateKt$LazyLayoutSemanticState$2 = (LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1) objRememberedValue2;
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            coroutineScope = (CoroutineScope) objRememberedValue3;
            graphicsContext = (GraphicsContext) gapComposer.consume(CompositionLocalsKt.LocalGraphicsContext);
            dummyHandle = ((Boolean) gapComposer.consume(CompositionLocalsKt.LocalProvidableScrollCaptureInProgress)).booleanValue() ? null : StickyItemsPlacement$Companion.StickToTopPlacement;
            int i24 = i15 << 18;
            int i25 = (i112 & 65520) | (i113 & 3670016) | (i24 & 29360128) | (i24 & 234881024) | ((i15 << 27) & 1879048192);
            zChanged = ((((i25 & 3670016) ^ 1572864) <= 1048576 && gapComposer.changed(horizontal3)) || (i25 & 1572864) == 1048576) | ((((i25 & 112) ^ 48) <= 32 && gapComposer.changed(lazyListState)) || (i25 & 48) == 32) | ((((i25 & 896) ^ 384) <= 256 && gapComposer.changed(paddingValuesImpl)) || (i25 & 384) == 256) | ((((i25 & 7168) ^ 3072) <= 2048 && gapComposer.changed(z7)) || (i25 & 3072) == 2048) | ((((57344 & i25) ^ 24576) <= 16384 && gapComposer.changed(z2)) || (i25 & 24576) == 16384) | gapComposer.changed(0) | ((((i25 & 29360128) ^ 12582912) <= 8388608 && gapComposer.changed(vertical5)) || (i25 & 12582912) == 8388608) | ((((i25 & 234881024) ^ 100663296) <= 67108864 && gapComposer.changed(horizontal6)) || (i25 & 100663296) == 67108864) | ((((i25 & 1879048192) ^ 805306368) <= 536870912 && gapComposer.changed(vertical4)) || (i25 & 805306368) == 536870912) | gapComposer.changed(graphicsContext) | gapComposer.changed(dummyHandle);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChanged) {
                horizontal7 = horizontal3;
                i9 = 4;
                z6 = true;
                lazyListKt$rememberLazyListMeasurePolicy$1$1 = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValuesImpl, z7, kProperty0, vertical4, horizontal6, coroutineScope, graphicsContext, dummyHandle, horizontal7, vertical5);
                kProperty1 = kProperty0;
                z7 = z7;
                gapComposer.updateRememberedValue(lazyListKt$rememberLazyListMeasurePolicy$1$1);
            } else {
                horizontal7 = horizontal3;
                i9 = 4;
                z6 = true;
                lazyListKt$rememberLazyListMeasurePolicy$1$1 = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValuesImpl, z7, kProperty0, vertical4, horizontal6, coroutineScope, graphicsContext, dummyHandle, horizontal7, vertical5);
                kProperty1 = kProperty0;
                z7 = z7;
                gapComposer.updateRememberedValue(lazyListKt$rememberLazyListMeasurePolicy$1$1);
            }
            LazyListKt$rememberLazyListMeasurePolicy$1$1 lazyListKt$rememberLazyListMeasurePolicy$1$3 = (LazyListKt$rememberLazyListMeasurePolicy$1$1) lazyListKt$rememberLazyListMeasurePolicy$1$1;
            if (z2) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Horizontal;
            }
            orientation2 = orientation;
            if (z3) {
                gapComposer.startReplaceGroup(-2077147368);
                zChanged2 = (((((i8 & 14) ^ 6) > i9 || !gapComposer.changed(lazyListState)) && (i8 & 6) != i9) ? false : z6) | gapComposer.changed(0);
                objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new LazyListBeyondBoundsState(r3);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new LazyListBeyondBoundsState(r3);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                modifierLazyLayoutBeyondBoundsModifier = LazyLayoutKt.lazyLayoutBeyondBoundsModifier((LazyListBeyondBoundsState) objRememberedValue4, r3.beyondBoundsInfo, z7, orientation2);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-2076718545);
                gapComposer.end(false);
                modifierLazyLayoutBeyondBoundsModifier = Modifier.Companion.$$INSTANCE;
            }
            lazyListState2 = r3;
            LazyLayoutKt.LazyLayout(kProperty1, ImageKt.scrollableArea$default(LazyLayoutKt.lazyLayoutSemantics(modifier.then(r3.remeasurementModifier).then(r3.awaitLayoutModifier), kProperty1, lazyLayoutSemanticStateKt$LazyLayoutSemanticState$2, orientation2, z3, z7).then(modifierLazyLayoutBeyondBoundsModifier).then(r3.itemAnimator.modifier), r3, orientation2, androidEdgeEffectOverscrollEffect, z3, z, flingBehavior, r3.internalInteractionSource), lazyListState2.prefetchState, lazyListKt$rememberLazyListMeasurePolicy$1$3, gapComposer, 0);
            horizontal5 = horizontal7;
            vertical3 = vertical5;
            horizontal4 = horizontal6;
        } else {
            lazyListState2 = lazyListState;
            gapComposer.skipToGroupEnd();
            vertical3 = vertical2;
            horizontal4 = horizontal2;
            horizontal5 = horizontal3;
            vertical4 = vertical;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final LazyListState lazyListState3 = lazyListState2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    LazyListKt.LazyList(modifier, lazyListState3, paddingValuesImpl, z, z2, flingBehavior, z3, androidEdgeEffectOverscrollEffect, horizontal5, vertical4, vertical3, horizontal4, function1, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final Object startUndispatchedOrReturn(ScopeCoroutine scopeCoroutine, ScopeCoroutine scopeCoroutine2, Function2 function2) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
            completedExceptionally = function2.invoke(scopeCoroutine2, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (completedExceptionally == coroutineSingletons || (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) == JobKt.COMPLETING_WAITING_CHILDREN) {
            return coroutineSingletons;
        }
        scopeCoroutine.afterCompletionUndispatched();
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
        }
        return JobKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
    }
}
