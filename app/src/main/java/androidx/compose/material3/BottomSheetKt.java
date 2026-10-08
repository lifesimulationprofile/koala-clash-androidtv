package androidx.compose.material3;

import androidx.camera.core.SurfaceRequest;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableElement;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollElement;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BottomSheetKt {
    public static final float PredictiveBackMaxScaleXDistance = 48;
    public static final float PredictiveBackMaxScaleYDistance = 24;
    public static final long PredictiveBackChildTransformOrigin = BrushKt.TransformOrigin(0.5f, 0.0f);

    /* JADX INFO: renamed from: BottomSheet-jyqLk6I, reason: not valid java name */
    public static final void m241BottomSheetjyqLk6I(final Modifier modifier, final SheetState sheetState, final Function0 function0, final float f, final boolean z, final Function2 function2, final Function2 function3, final Shape shape, final long j, final long j2, final float f2, float f3, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i) {
        final float f4;
        float f5;
        Object gapComposer$$ExternalSyntheticLambda0;
        Object obj;
        Object obj2;
        gapComposer.startRestartGroup(57000307);
        int i2 = i | (gapComposer.changed(modifier) ? 4 : 2) | (gapComposer.changed(sheetState) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128) | (gapComposer.changed(f) ? 2048 : 1024) | (gapComposer.changed(z) ? 16384 : 8192) | (gapComposer.changed(true) ? 131072 : 65536) | (gapComposer.changedInstance(function2) ? 1048576 : 524288) | (gapComposer.changedInstance(function3) ? 8388608 : 4194304) | (gapComposer.changed(shape) ? 67108864 : 33554432) | (gapComposer.changed(j) ? 536870912 : 268435456);
        int i3 = (gapComposer.changed(j2) ? 4 : 2) | (gapComposer.changed(f2) ? 32 : 16) | 384 | (gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, ((306783379 & i2) == 306783378 && (i3 & 1171) == 1170) ? false : true)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                f5 = 0;
            } else {
                gapComposer.skipToGroupEnd();
                f5 = f3;
            }
            gapComposer.endDefaults();
            ProvidableCompositionLocal providableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            Object objDefaultSpatialSpec = ((MaterialTheme$Values) gapComposer.consume(providableCompositionLocal)).motionScheme.defaultSpatialSpec();
            Object objFastEffectsSpec = ((MaterialTheme$Values) gapComposer.consume(providableCompositionLocal)).motionScheme.fastEffectsSpec();
            Object objDefaultSpatialSpec2 = ((MaterialTheme$Values) gapComposer.consume(providableCompositionLocal)).motionScheme.defaultSpatialSpec();
            int i4 = (i2 & 112) ^ 48;
            boolean zChangedInstance = ((i4 > 32 && gapComposer.changed(sheetState)) || (i2 & 48) == 32) | gapComposer.changedInstance(objDefaultSpatialSpec) | gapComposer.changedInstance(objFastEffectsSpec) | gapComposer.changedInstance(objDefaultSpatialSpec2);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj3 = Composer$Companion.Empty;
            if (zChangedInstance || objRememberedValue == obj3) {
                obj = obj3;
                obj2 = sheetState;
                gapComposer$$ExternalSyntheticLambda0 = new GapComposer$$ExternalSyntheticLambda0(obj2, objDefaultSpatialSpec, objFastEffectsSpec, objDefaultSpatialSpec2, 4);
                gapComposer.updateRememberedValue(gapComposer$$ExternalSyntheticLambda0);
            } else {
                gapComposer$$ExternalSyntheticLambda0 = objRememberedValue;
                obj = obj3;
                obj2 = sheetState;
            }
            Stack.SideEffect((Function0) gapComposer$$ExternalSyntheticLambda0, gapComposer);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = ArcSplineKt.Animatable$default(0.0f);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Animatable animatable = (Animatable) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == obj) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Object obj4 = (CoroutineScope) objRememberedValue3;
            boolean zChangedInstance2 = ((i4 > 32 && gapComposer.changed(obj2)) || (r20 & 48) == 32) | gapComposer.changedInstance(obj4) | gapComposer.changedInstance(animatable) | ((r20 & 896) == 256);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == obj) {
                Object bottomSheetKt$$ExternalSyntheticLambda1 = new BottomSheetKt$$ExternalSyntheticLambda1(obj2, obj4, animatable, function0, 0);
                gapComposer.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda1);
                objRememberedValue4 = bottomSheetKt$$ExternalSyntheticLambda1;
            }
            Object obj5 = (Function0) objRememberedValue4;
            boolean zIsVisible = sheetState.isVisible();
            boolean zChangedInstance3 = gapComposer.changedInstance(animatable) | gapComposer.changed(obj5);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == obj) {
                objRememberedValue5 = new NavHostKt$NavHost$28$1(obj5, animatable, (Continuation) null, 18);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            LayoutUtilKt.PredictiveBackHandler(zIsVisible, (Function2) objRememberedValue5, gapComposer, 0);
            int i5 = r20 >> 6;
            int i6 = ((r20 << 3) & 524272) | (3670016 & i5) | (i5 & 29360128);
            int i7 = i3 << 24;
            int i8 = i6 | (234881024 & i7) | (i7 & 1879048192);
            int i9 = i2 >> 15;
            float f6 = f5;
            m242BottomSheetImpll84tTqM(((Number) animatable.getValue()).floatValue(), modifier, sheetState, function0, f, z, shape, j, j2, f2, f6, function2, function3, composableLambdaImpl, gapComposer, i8, (i9 & 896) | (i9 & 112) | 6 | (i3 & 7168));
            f4 = f6;
        } else {
            gapComposer.skipToGroupEnd();
            f4 = f3;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(sheetState, function0, f, z, function2, function3, shape, j, j2, f2, f4, composableLambdaImpl, i) { // from class: androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda2
                public final /* synthetic */ SheetState f$1;
                public final /* synthetic */ long f$10;
                public final /* synthetic */ float f$11;
                public final /* synthetic */ float f$12;
                public final /* synthetic */ ComposableLambdaImpl f$13;
                public final /* synthetic */ Function0 f$2;
                public final /* synthetic */ float f$3;
                public final /* synthetic */ boolean f$4;
                public final /* synthetic */ Function2 f$6;
                public final /* synthetic */ Function2 f$7;
                public final /* synthetic */ Shape f$8;
                public final /* synthetic */ long f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj6, Object obj7) {
                    ((Integer) obj7).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    BottomSheetKt.m241BottomSheetjyqLk6I(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, (GapComposer) obj6, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:182:0x02b1  */
    /* JADX INFO: renamed from: BottomSheetImpl-l84tTqM, reason: not valid java name */
    public static final void m242BottomSheetImpll84tTqM(final float f, final Modifier modifier, final SheetState sheetState, final Function0 function0, final float f2, final boolean z, final Shape shape, final long j, final long j2, final float f3, final float f4, final Function2 function2, final Function2 function3, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        int i4;
        Object bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
        int i5;
        Function0 function1;
        CoroutineScope coroutineScope;
        boolean z2;
        Object objRememberedValue;
        final SheetState sheetState2 = sheetState;
        gapComposer.startRestartGroup(-780255289);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(sheetState2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changed(f2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= gapComposer.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= gapComposer.changed(shape) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer.changed(j) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer.changed(j2) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer.changed(f3) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = (gapComposer.changed(f4) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer.changedInstance(function3) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (i4 & 1171) == 1170) ? false : true)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            String strM282getString2EP1pXo = LayoutUtilKt.m282getString2EP1pXo(R.string.m3c_bottom_sheet_pane_title, gapComposer);
            ViewConfiguration viewConfiguration = (ViewConfiguration) gapComposer.consume(CompositionLocalsKt.LocalViewConfiguration);
            SpringSpec springSpecDefaultSpatialSpec = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).motionScheme.defaultSpatialSpec();
            ProvidableCompositionLocal providableCompositionLocal = CompositionLocalsKt.LocalDensity;
            int i6 = i4;
            Density density = (Density) gapComposer.consume(providableCompositionLocal);
            SurfaceRequest.AnonymousClass1 anonymousClass1 = sheetState2.anchoredDraggableState;
            SurfaceRequest.AnonymousClass1 anonymousClass2 = sheetState2.anchoredDraggableState;
            int i7 = (i3 & 896) ^ 384;
            boolean z3 = (i7 > 256 && gapComposer.changed(sheetState2)) || (i3 & 384) == 256;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            boolean z4 = z3;
            Object obj = Composer$Companion.Empty;
            if (z4 || objRememberedValue2 == obj) {
                objRememberedValue2 = new BottomSheetKt$$ExternalSyntheticLambda4(sheetState2, 0);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Object obj2 = (Function1) objRememberedValue2;
            TweenSpec tweenSpec = AnchoredDraggableDefaults.SnapAnimationSpec;
            Object obj3 = (NodeChain) anonymousClass1.val$requestCancellationCompleter;
            TweenSpec tweenSpec2 = AnchoredDraggableDefaults.SnapAnimationSpec;
            Object obj4 = (Density) gapComposer.consume(providableCompositionLocal);
            boolean zChanged = gapComposer.changed(obj4) | gapComposer.changed(obj3) | gapComposer.changed(obj2) | gapComposer.changed(springSpecDefaultSpatialSpec);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == obj) {
                objRememberedValue3 = new SnapFlingBehavior(new MenuHostHelper(obj3, obj2, new BasicTextKt$$ExternalSyntheticLambda0(4, obj4), 11), springSpecDefaultSpatialSpec);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) objRememberedValue3;
            boolean zChanged2 = gapComposer.changed(snapFlingBehavior) | ((i7 > 256 && gapComposer.changed(sheetState2)) || (i3 & 384) == 256) | gapComposer.changed(viewConfiguration) | gapComposer.changed(density);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == obj) {
                i5 = i3;
                bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 = new BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1(viewConfiguration, sheetState2, density, snapFlingBehavior, function0);
                sheetState2 = sheetState2;
                function1 = function0;
                gapComposer.updateRememberedValue(bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1);
            } else {
                i5 = i3;
                bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 = objRememberedValue4;
                function1 = function0;
            }
            BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1 bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$2 = (BottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1) bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$1;
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == obj) {
                objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue5;
            boolean zChangedInstance = ((i7 > 256 && gapComposer.changed(sheetState2)) || (i5 & 384) == 256) | gapComposer.changedInstance(coroutineScope2) | ((i5 & 7168) == 2048);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == obj) {
                objRememberedValue6 = new BottomSheetKt$$ExternalSyntheticLambda5(sheetState2, coroutineScope2, function1, 0);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            final Function0 function4 = (Function0) objRememberedValue6;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier.then(new SizeElement(Float.NaN, 0.0f, f2, 0.0f, 10)), 1.0f);
            Modifier modifierThen = Modifier.Companion.$$INSTANCE;
            if (z) {
                gapComposer.startReplaceGroup(1794077610);
                if (i7 <= 256 || !gapComposer.changed(sheetState2)) {
                    coroutineScope = coroutineScope2;
                    if ((i5 & 384) != 256) {
                        z2 = false;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (z2 || objRememberedValue == obj) {
                        float f5 = SheetDefaultsKt.DragHandleVerticalPadding;
                        objRememberedValue = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(sheetState2, bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    modifierThen = modifierThen.then(new NestedScrollElement((NestedScrollConnection) objRememberedValue));
                    gapComposer.end(false);
                } else {
                    coroutineScope = coroutineScope2;
                }
                z2 = true;
                objRememberedValue = gapComposer.rememberedValue();
                if (z2) {
                    float f6 = SheetDefaultsKt.DragHandleVerticalPadding;
                    objRememberedValue = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(sheetState2, bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    float f7 = SheetDefaultsKt.DragHandleVerticalPadding;
                    objRememberedValue = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(sheetState2, bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$2);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                modifierThen = modifierThen.then(new NestedScrollElement((NestedScrollConnection) objRememberedValue));
                gapComposer.end(false);
            } else {
                coroutineScope = coroutineScope2;
                gapComposer.startReplaceGroup(1794092431);
                gapComposer.end(false);
            }
            Modifier modifierThen2 = modifierFillMaxWidth.then(modifierThen);
            boolean z5 = (i7 > 256 && gapComposer.changed(sheetState2)) || (i5 & 384) == 256;
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (z5 || objRememberedValue7 == obj) {
                objRememberedValue7 = new Updater$$ExternalSyntheticLambda0(16, sheetState2);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            Modifier modifierThen3 = LayoutUtilKt.draggableAnchors(modifierThen2, r18, (Function2) objRememberedValue7).then(new AnchoredDraggableElement((NodeChain) anonymousClass2.val$requestCancellationCompleter, z && sheetState2.getCurrentValue() != SheetValue.Hidden, Boolean.valueOf(gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection) == LayoutDirection.Rtl), bottomSheetKt$BottomSheetImpl$modalBottomSheetFlingBehavior$1$2));
            boolean zChanged3 = gapComposer.changed(strM282getString2EP1pXo);
            Object objRememberedValue8 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue8 == obj) {
                objRememberedValue8 = new IconKt$$ExternalSyntheticLambda1(strM282getString2EP1pXo, 3);
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            Modifier modifierGraphicsLayer = BrushKt.graphicsLayer(SemanticsModifierKt.semantics(modifierThen3, false, (Function1) objRememberedValue8), new BottomSheetKt$$ExternalSyntheticLambda13(sheetState2, f, 0));
            float f8 = SheetDefaultsKt.DragHandleVerticalPadding;
            final CoroutineScope coroutineScope3 = coroutineScope;
            int i8 = i5 >> 15;
            SurfaceKt.m269SurfaceT9BRK9s(BrushKt.graphicsLayer(modifierGraphicsLayer, new BottomSheetKt$$ExternalSyntheticLambda4(sheetState2, 1)), shape, j, j2, f3, f4, Thread_jvmKt.rememberComposableLambda(1483196812, new Function2() { // from class: androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda8
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    GapComposer gapComposer2 = (GapComposer) obj5;
                    int iIntValue = ((Integer) obj6).intValue();
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(SizeKt.fillMaxWidth(companion, 1.0f), (WindowInsets) function3.invoke(gapComposer2, 0));
                        final float f9 = f;
                        Modifier modifierGraphicsLayer2 = BrushKt.graphicsLayer(modifierWindowInsetsPadding, new Function1() { // from class: androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj7) {
                                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj7;
                                float f10 = f9;
                                float fCalculateSheetPredictiveBackScaleX = BottomSheetKt.calculateSheetPredictiveBackScaleX(reusableGraphicsLayerScope, f10);
                                float fCalculateSheetPredictiveBackScaleY = BottomSheetKt.calculateSheetPredictiveBackScaleY(reusableGraphicsLayerScope, f10);
                                reusableGraphicsLayerScope.setScaleY(fCalculateSheetPredictiveBackScaleY == 0.0f ? 1.0f : fCalculateSheetPredictiveBackScaleX / fCalculateSheetPredictiveBackScaleY);
                                reusableGraphicsLayerScope.m450setTransformOrigin__ExYCQ(BottomSheetKt.PredictiveBackChildTransformOrigin);
                                return Unit.INSTANCE;
                            }
                        });
                        float f10 = SheetDefaultsKt.DragHandleVerticalPadding;
                        final SheetState sheetState3 = sheetState2;
                        Modifier modifierGraphicsLayer3 = BrushKt.graphicsLayer(modifierGraphicsLayer2, new BottomSheetKt$$ExternalSyntheticLambda4(sheetState3, 2));
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j3 = gapComposer2.compositeKeyHashCode;
                        int i9 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierGraphicsLayer3);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i9), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        Function2 function5 = function2;
                        if (function5 != null) {
                            gapComposer2.startReplaceGroup(-444181086);
                            final String strM282getString2EP1pXo2 = LayoutUtilKt.m282getString2EP1pXo(R.string.m3c_bottom_sheet_collapse_description, gapComposer2);
                            final String strM282getString2EP1pXo3 = LayoutUtilKt.m282getString2EP1pXo(R.string.m3c_bottom_sheet_dismiss_description, gapComposer2);
                            final String strM282getString2EP1pXo4 = LayoutUtilKt.m282getString2EP1pXo(R.string.m3c_bottom_sheet_expand_description, gapComposer2);
                            boolean zChanged4 = gapComposer2.changed(sheetState3);
                            final Function0 function6 = function4;
                            boolean zChanged5 = zChanged4 | gapComposer2.changed(function6);
                            final CoroutineScope coroutineScope4 = coroutineScope3;
                            boolean zChangedInstance2 = zChanged5 | gapComposer2.changedInstance(coroutineScope4);
                            Object objRememberedValue9 = gapComposer2.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                            if (zChangedInstance2 || objRememberedValue9 == neverEqualPolicy) {
                                objRememberedValue9 = new BottomSheetKt$$ExternalSyntheticLambda5(sheetState3, function6, coroutineScope4);
                                gapComposer2.updateRememberedValue(objRememberedValue9);
                            }
                            Modifier modifierM51clickableoSLSa3U$default = ImageKt.m51clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue9, 15);
                            final boolean z6 = z;
                            boolean zChanged6 = gapComposer2.changed(z6) | gapComposer2.changed(sheetState3) | gapComposer2.changed(strM282getString2EP1pXo3) | gapComposer2.changed(function6) | gapComposer2.changed(strM282getString2EP1pXo4) | gapComposer2.changedInstance(coroutineScope4) | gapComposer2.changed(strM282getString2EP1pXo2);
                            Object objRememberedValue10 = gapComposer2.rememberedValue();
                            if (zChanged6 || objRememberedValue10 == neverEqualPolicy) {
                                Function1 function7 = new Function1() { // from class: androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj7) {
                                        SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj7;
                                        if (z6) {
                                            ScrimKt$$ExternalSyntheticLambda3 scrimKt$$ExternalSyntheticLambda3 = new ScrimKt$$ExternalSyntheticLambda3(1, function6);
                                            KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                                            semanticsPropertyReceiver.set(SemanticsActions.Dismiss, new AccessibilityAction(strM282getString2EP1pXo3, scrimKt$$ExternalSyntheticLambda3));
                                            SheetState sheetState4 = sheetState3;
                                            SheetValue currentValue = sheetState4.getCurrentValue();
                                            SheetValue sheetValue = SheetValue.PartiallyExpanded;
                                            CoroutineScope coroutineScope5 = coroutineScope4;
                                            if (currentValue == sheetValue) {
                                                semanticsPropertyReceiver.set(SemanticsActions.Expand, new AccessibilityAction(strM282getString2EP1pXo4, new GapComposer$$ExternalSyntheticLambda0(sheetState4, coroutineScope5, sheetState4, 5)));
                                            } else if (sheetState4.getHasPartiallyExpandedState()) {
                                                semanticsPropertyReceiver.set(SemanticsActions.Collapse, new AccessibilityAction(strM282getString2EP1pXo2, new Recomposer$$ExternalSyntheticLambda6(15, sheetState4, coroutineScope5)));
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer2.updateRememberedValue(function7);
                                objRememberedValue10 = function7;
                            }
                            SheetDefaultsKt.DragHandleWithTooltip(SemanticsModifierKt.semantics(modifierM51clickableoSLSa3U$default, true, (Function1) objRememberedValue10), function5, gapComposer2, 0);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-441815104);
                            gapComposer2.end(false);
                        }
                        composableLambdaImpl.invoke((Object) ColumnScopeInstance.INSTANCE, (Object) gapComposer2, (Object) 6);
                        gapComposer2.end(true);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (i8 & 57344) | (i8 & 112) | 12582912 | (i8 & 896) | (i8 & 7168) | (458752 & (i6 << 15)), 64);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    ((Integer) obj6).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    BottomSheetKt.m242BottomSheetImpll84tTqM(f, modifier, sheetState, function0, f2, z, shape, j, j2, f3, f4, function2, function3, composableLambdaImpl, (GapComposer) obj5, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final float calculateSheetPredictiveBackScaleX(ReusableGraphicsLayerScope reusableGraphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (reusableGraphicsLayerScope.size >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(reusableGraphicsLayerScope.getDensity() * PredictiveBackMaxScaleXDistance, fIntBitsToFloat), f) / fIntBitsToFloat);
    }

    public static final float calculateSheetPredictiveBackScaleY(ReusableGraphicsLayerScope reusableGraphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (reusableGraphicsLayerScope.size & 4294967295L));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(reusableGraphicsLayerScope.getDensity() * PredictiveBackMaxScaleYDistance, fIntBitsToFloat), f) / fIntBitsToFloat);
    }
}
