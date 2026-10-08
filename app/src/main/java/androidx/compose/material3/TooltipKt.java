package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.Lifecycle;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TooltipKt {
    public static final PaddingValuesImpl PlainTooltipContentPadding;
    public static final float SpacingBetweenTooltipAndAnchor;
    public static final float TooltipMinHeight = 24;
    public static final float TooltipMinWidth = 40;

    static {
        float f = 4;
        SpacingBetweenTooltipAndAnchor = f;
        float f2 = 8;
        PlainTooltipContentPadding = new PaddingValuesImpl(f2, f, f2, f);
    }

    /* JADX INFO: renamed from: PlainTooltip-gv3ox5I, reason: not valid java name */
    public static final void m277PlainTooltipgv3ox5I(final TooltipScopeImpl tooltipScopeImpl, Modifier modifier, float f, Shape shape, long j, long j2, float f2, float f3, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i) {
        int i2;
        Modifier modifier2;
        final float f4;
        final Shape shape2;
        final long j3;
        final long j4;
        final float f5;
        final float f6;
        final float f7;
        final long value;
        int i3;
        long j5;
        float f8;
        float f9;
        Shape shape3;
        gapComposer.startRestartGroup(-343758958);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(tooltipScopeImpl) : gapComposer.changedInstance(tooltipScopeImpl) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i4 = i2 | 3504;
        if ((i & 24576) == 0) {
            i4 = i2 | 11696;
        }
        if ((196608 & i) == 0) {
            i4 |= 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= 524288;
        }
        int i5 = 113246208 | i4;
        if ((805306368 & i) == 0) {
            i5 |= gapComposer.changedInstance(composableLambdaImpl) ? 536870912 : 268435456;
        }
        if (gapComposer.shouldExecute(i5 & 1, (306783379 & i5) != 306783378)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                f7 = TooltipDefaults.plainTooltipMaxWidth;
                Shape value2 = ShapesKt.getValue(5, gapComposer);
                value = ColorSchemeKt.getValue(4, gapComposer);
                long value3 = ColorSchemeKt.getValue(6, gapComposer);
                i3 = i5 & (-4186113);
                modifier2 = Modifier.Companion.$$INSTANCE;
                j5 = value3;
                f8 = 0;
                f9 = 0;
                shape3 = value2;
            } else {
                gapComposer.skipToGroupEnd();
                i3 = i5 & (-4186113);
                modifier2 = modifier;
                f7 = f;
                shape3 = shape;
                value = j;
                j5 = j2;
                f8 = f2;
                f9 = f3;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(-1719869687);
            gapComposer.end(false);
            int i6 = i3 >> 9;
            SurfaceKt.m269SurfaceT9BRK9s(modifier2, shape3, j5, 0L, f8, f9, Thread_jvmKt.rememberComposableLambda(-1573998995, new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Modifier modifierPadding = OffsetKt.padding(SizeKt.m143sizeInqDBjuR0$default(Modifier.Companion.$$INSTANCE, TooltipKt.TooltipMinWidth, f7, 8), TooltipKt.PlainTooltipContentPadding);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j6 = gapComposer2.compositeKeyHashCode;
                        int i7 = (int) (j6 ^ (j6 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPadding);
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
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i7), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        Stack.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(value)), TextKt.LocalTextStyle.defaultProvidedValue$runtime(TypographyKt.getValue(3, gapComposer2))}, composableLambdaImpl, gapComposer2, 8);
                        gapComposer2.end(true);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (57344 & i6) | 12582912 | (i6 & 458752), 72);
            f4 = f7;
            j3 = value;
            shape2 = shape3;
            j4 = j5;
            f5 = f8;
            f6 = f9;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            f4 = f;
            shape2 = shape;
            j3 = j;
            j4 = j2;
            f5 = f2;
            f6 = f3;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    TooltipKt.m277PlainTooltipgv3ox5I(tooltipScopeImpl, modifier3, f4, shape2, j3, j4, f5, f6, composableLambdaImpl, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:105:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:108:0x020e  */
    /* JADX WARN: Code duplicated, block: B:110:0x021b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0222  */
    /* JADX WARN: Code duplicated, block: B:117:0x022a  */
    /* JADX WARN: Code duplicated, block: B:125:0x024a  */
    /* JADX WARN: Code duplicated, block: B:128:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x026b  */
    /* JADX WARN: Code duplicated, block: B:133:0x027f  */
    /* JADX WARN: Code duplicated, block: B:137:0x029f  */
    /* JADX WARN: Code duplicated, block: B:141:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:143:0x031d  */
    /* JADX WARN: Code duplicated, block: B:146:0x0329  */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:69:0x0120  */
    /* JADX WARN: Code duplicated, block: B:75:0x0134  */
    /* JADX WARN: Code duplicated, block: B:77:0x013a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0143  */
    /* JADX WARN: Code duplicated, block: B:87:0x0162  */
    /* JADX WARN: Code duplicated, block: B:90:0x0182  */
    /* JADX WARN: Code duplicated, block: B:92:0x0186  */
    /* JADX WARN: Code duplicated, block: B:96:0x019d  */
    /* JADX WARN: Code duplicated, block: B:99:0x01bb  */
    public static final void TooltipBox(PopupPositionProvider popupPositionProvider, ComposableLambdaImpl composableLambdaImpl, TooltipStateImpl tooltipStateImpl, Modifier modifier, boolean z, Function2 function2, GapComposer gapComposer, int i, int i2) {
        int i3;
        ComposableLambdaImpl composableLambdaImpl2;
        Modifier modifier2;
        int i4;
        boolean z2;
        boolean z3;
        Modifier modifier3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        Transition transitionRememberTransition;
        Object objRememberedValue;
        Object obj;
        MutableState mutableState;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final MutableState mutableState2;
        Object objRememberedValue4;
        FiniteAnimationSpec finiteAnimationSpecValue;
        boolean zIsSeeking;
        Lifecycle lifecycle;
        Object objMo773getCurrentState;
        boolean zBooleanValue;
        float f;
        boolean zChanged;
        Object objRememberedValue5;
        boolean zBooleanValue2;
        float f2;
        boolean zChanged2;
        Object objRememberedValue6;
        Object obj2;
        boolean z4;
        Object objMo773getCurrentState2;
        boolean zBooleanValue3;
        float f3;
        boolean zChanged3;
        Object objRememberedValue7;
        boolean zChanged4;
        Object objRememberedValue8;
        boolean zChanged5;
        Snapshot currentThreadSnapshot;
        Function1 readObserver;
        Snapshot snapshotMakeCurrentNonObservable;
        boolean zChanged6;
        Snapshot currentThreadSnapshot2;
        Function1 readObserver2;
        Snapshot snapshotMakeCurrentNonObservable2;
        int i5;
        gapComposer.startRestartGroup(-293753984);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            i3 |= gapComposer.changedInstance(composableLambdaImpl2) ? 32 : 16;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? gapComposer.changed(tooltipStateImpl) : gapComposer.changedInstance(tooltipStateImpl) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i3 | 14376960;
            if ((100663296 & i) == 0) {
                if (gapComposer.changedInstance(function2)) {
                    i5 = 67108864;
                } else {
                    i5 = 33554432;
                }
                i4 |= i5;
            }
            if ((38347923 & i4) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z2)) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                transitionRememberTransition = ArcSplineKt.rememberTransition(tooltipStateImpl.transition, "tooltip transition", gapComposer, 48);
                objRememberedValue = gapComposer.rememberedValue();
                obj = Composer$Companion.Empty;
                if (objRememberedValue == obj) {
                    objRememberedValue = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == obj) {
                    new TooltipKt$$ExternalSyntheticLambda0(mutableState, 0);
                    objRememberedValue2 = new TooltipScopeImpl();
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                final TooltipScopeImpl tooltipScopeImpl = (TooltipScopeImpl) objRememberedValue2;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-23901870, new TextKt$$ExternalSyntheticLambda2(18, mutableState, function2), gapComposer);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == obj) {
                    objRememberedValue3 = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == obj) {
                    objRememberedValue4 = Stack.derivedStateOf(new TooltipKt$$ExternalSyntheticLambda2(mutableState, mutableState2, 0));
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                final State state = (State) objRememberedValue4;
                finiteAnimationSpecValue = ScrimKt.value(2, gapComposer);
                FiniteAnimationSpec finiteAnimationSpecValue2 = ScrimKt.value(5, gapComposer);
                TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
                zIsSeeking = transitionRememberTransition.isSeeking();
                lifecycle = transitionRememberTransition.transitionState;
                if (zIsSeeking) {
                    finiteAnimationSpecValue = finiteAnimationSpecValue;
                    gapComposer.startReplaceGroup(1666827533);
                    gapComposer.end(false);
                    objMo773getCurrentState = lifecycle.mo773getCurrentState();
                } else {
                    gapComposer.startReplaceGroup(1666573488);
                    zChanged6 = gapComposer.changed(transitionRememberTransition);
                    objMo773getCurrentState = gapComposer.rememberedValue();
                    if (zChanged6 || objMo773getCurrentState == obj) {
                        currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot2 != null) {
                            readObserver2 = currentThreadSnapshot2.getReadObserver();
                        } else {
                            readObserver2 = null;
                        }
                        snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
                        try {
                            Object objMo773getCurrentState3 = lifecycle.mo773getCurrentState();
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            gapComposer.updateRememberedValue(objMo773getCurrentState3);
                            objMo773getCurrentState = objMo773getCurrentState3;
                        } catch (Throwable th) {
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            throw th;
                        }
                    }
                    gapComposer.end(false);
                }
                zBooleanValue = ((Boolean) objMo773getCurrentState).booleanValue();
                gapComposer.startReplaceGroup(838300572);
                if (zBooleanValue) {
                    f = 1.0f;
                } else {
                    f = 0.8f;
                }
                gapComposer.end(false);
                Float fValueOf = Float.valueOf(f);
                zChanged = gapComposer.changed(transitionRememberTransition);
                objRememberedValue5 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue5 == obj) {
                    objRememberedValue5 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 0));
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                zBooleanValue2 = ((Boolean) ((State) objRememberedValue5).getValue()).booleanValue();
                gapComposer.startReplaceGroup(838300572);
                if (zBooleanValue2) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.8f;
                }
                gapComposer.end(false);
                Float fValueOf2 = Float.valueOf(f2);
                zChanged2 = gapComposer.changed(transitionRememberTransition);
                objRememberedValue6 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue6 == obj) {
                    objRememberedValue6 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 11));
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                gapComposer.startReplaceGroup(-1664496585);
                gapComposer.end(false);
                final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf, fValueOf2, finiteAnimationSpecValue, twoWayConverterImpl, gapComposer, 196608);
                if (transitionRememberTransition.isSeeking()) {
                    obj2 = obj;
                    z4 = false;
                    gapComposer.startReplaceGroup(1666827533);
                    gapComposer.end(false);
                    objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
                } else {
                    gapComposer.startReplaceGroup(1666573488);
                    zChanged5 = gapComposer.changed(transitionRememberTransition);
                    objMo773getCurrentState2 = gapComposer.rememberedValue();
                    try {
                        if (zChanged5) {
                            obj2 = obj;
                        } else {
                            obj2 = obj;
                            if (objMo773getCurrentState2 == obj2) {
                            }
                            gapComposer.end(false);
                            z4 = false;
                        }
                        Object objMo773getCurrentState4 = lifecycle.mo773getCurrentState();
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        gapComposer.updateRememberedValue(objMo773getCurrentState4);
                        objMo773getCurrentState2 = objMo773getCurrentState4;
                        gapComposer.end(false);
                        z4 = false;
                    } catch (Throwable th2) {
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th2;
                    }
                    currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                }
                zBooleanValue3 = ((Boolean) objMo773getCurrentState2).booleanValue();
                gapComposer.startReplaceGroup(-1903393104);
                if (zBooleanValue3) {
                    f3 = 1.0f;
                } else {
                    f3 = 0.0f;
                }
                gapComposer.end(z4);
                Float fValueOf3 = Float.valueOf(f3);
                zChanged3 = gapComposer.changed(transitionRememberTransition);
                objRememberedValue7 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue7 == obj2) {
                    objRememberedValue7 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 12));
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                boolean zBooleanValue4 = ((Boolean) ((State) objRememberedValue7).getValue()).booleanValue();
                gapComposer.startReplaceGroup(-1903393104);
                float f4 = zBooleanValue4 ? 1.0f : 0.0f;
                gapComposer.end(z4);
                Float fValueOf4 = Float.valueOf(f4);
                zChanged4 = gapComposer.changed(transitionRememberTransition);
                objRememberedValue8 = gapComposer.rememberedValue();
                if (zChanged4 || objRememberedValue8 == obj2) {
                    objRememberedValue8 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 13));
                    gapComposer.updateRememberedValue(objRememberedValue8);
                }
                gapComposer.startReplaceGroup(-111222965);
                gapComposer.end(z4);
                final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf3, fValueOf4, finiteAnimationSpecValue2, twoWayConverterImpl, gapComposer, 196608);
                final ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl2;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(-527401546, new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda3
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
                    public final Object invoke(Object obj3, Object obj4) {
                        GapComposer gapComposer2 = (GapComposer) obj3;
                        int iIntValue = ((Integer) obj4).intValue();
                        boolean z5 = (iIntValue & 3) != 2;
                        MenuHostHelper menuHostHelper = gapComposer2.applier;
                        if (gapComposer2.shouldExecute(iIntValue & 1, z5)) {
                            Object objRememberedValue9 = gapComposer2.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                            if (objRememberedValue9 == neverEqualPolicy) {
                                objRememberedValue9 = new TooltipKt$$ExternalSyntheticLambda7(mutableState2, 7);
                                gapComposer2.updateRememberedValue(objRememberedValue9);
                            }
                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                            Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(companion, (Function1) objRememberedValue9);
                            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                            long j = gapComposer2.compositeKeyHashCode;
                            int i7 = (int) (j ^ (j >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierOnGloballyPositioned);
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer2.useNode();
                            }
                            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                            Integer numValueOf = Integer.valueOf(i7);
                            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                            gapComposer2.startMovableGroup(-1350495383, Integer.valueOf(((Number) state.getValue()).intValue()));
                            State state2 = transitionAnimationStateCreateTransitionAnimation;
                            boolean zChanged7 = gapComposer2.changed(state2);
                            State state3 = transitionAnimationStateCreateTransitionAnimation2;
                            boolean zChanged8 = zChanged7 | gapComposer2.changed(state3);
                            Object objRememberedValue10 = gapComposer2.rememberedValue();
                            if (zChanged8 || objRememberedValue10 == neverEqualPolicy) {
                                objRememberedValue10 = new TooltipKt$$ExternalSyntheticLambda9(state2, state3, 0);
                                gapComposer2.updateRememberedValue(objRememberedValue10);
                            }
                            Modifier modifierGraphicsLayer = BrushKt.graphicsLayer(companion, (Function1) objRememberedValue10);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                            long j2 = gapComposer2.compositeKeyHashCode;
                            int i8 = (int) (j2 ^ (j2 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierGraphicsLayer);
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                            Modifier.CC.m(i8, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                            composableLambdaImpl3.invoke((Object) tooltipScopeImpl, (Object) gapComposer2, (Object) 6);
                            gapComposer2.end(true);
                            gapComposer2.end(false);
                            gapComposer2.end(true);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer);
                int i7 = (i4 & 14) | 100663344 | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (i4 & 29360128);
                Modifier modifier5 = modifier4;
                LayoutUtilKt.BasicTooltipBox(popupPositionProvider, composableLambdaImplRememberComposableLambda2, tooltipStateImpl, modifier5, composableLambdaImplRememberComposableLambda, gapComposer, i7);
                modifier3 = modifier5;
                z3 = true;
            } else {
                gapComposer.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda4(popupPositionProvider, composableLambdaImpl, tooltipStateImpl, modifier3, z3, function2, i, i2);
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i3 | 14376960;
        if ((100663296 & i) == 0) {
            if (gapComposer.changedInstance(function2)) {
                i5 = 67108864;
            } else {
                i5 = 33554432;
            }
            i4 |= i5;
        }
        if ((38347923 & i4) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z2)) {
            if (i6 != 0) {
                modifier4 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            transitionRememberTransition = ArcSplineKt.rememberTransition(tooltipStateImpl.transition, "tooltip transition", gapComposer, 48);
            objRememberedValue = gapComposer.rememberedValue();
            obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                new TooltipKt$$ExternalSyntheticLambda0(mutableState, 0);
                objRememberedValue2 = new TooltipScopeImpl();
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            final TooltipScopeImpl tooltipScopeImpl2 = (TooltipScopeImpl) objRememberedValue2;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Thread_jvmKt.rememberComposableLambda(-23901870, new TextKt$$ExternalSyntheticLambda2(18, mutableState, function2), gapComposer);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == obj) {
                objRememberedValue3 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            mutableState2 = (MutableState) objRememberedValue3;
            objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == obj) {
                objRememberedValue4 = Stack.derivedStateOf(new TooltipKt$$ExternalSyntheticLambda2(mutableState, mutableState2, 0));
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            final State state2 = (State) objRememberedValue4;
            finiteAnimationSpecValue = ScrimKt.value(2, gapComposer);
            FiniteAnimationSpec finiteAnimationSpecValue3 = ScrimKt.value(5, gapComposer);
            TwoWayConverterImpl twoWayConverterImpl2 = ArcSplineKt.FloatToVector;
            zIsSeeking = transitionRememberTransition.isSeeking();
            lifecycle = transitionRememberTransition.transitionState;
            if (zIsSeeking) {
                gapComposer.startReplaceGroup(1666573488);
                zChanged6 = gapComposer.changed(transitionRememberTransition);
                objMo773getCurrentState = gapComposer.rememberedValue();
                if (zChanged6) {
                    currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
                    Object objMo773getCurrentState5 = lifecycle.mo773getCurrentState();
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(objMo773getCurrentState5);
                    objMo773getCurrentState = objMo773getCurrentState5;
                } else {
                    currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
                    Object objMo773getCurrentState6 = lifecycle.mo773getCurrentState();
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(objMo773getCurrentState6);
                    objMo773getCurrentState = objMo773getCurrentState6;
                }
                gapComposer.end(false);
            } else {
                finiteAnimationSpecValue = finiteAnimationSpecValue;
                gapComposer.startReplaceGroup(1666827533);
                gapComposer.end(false);
                objMo773getCurrentState = lifecycle.mo773getCurrentState();
            }
            zBooleanValue = ((Boolean) objMo773getCurrentState).booleanValue();
            gapComposer.startReplaceGroup(838300572);
            if (zBooleanValue) {
                f = 1.0f;
            } else {
                f = 0.8f;
            }
            gapComposer.end(false);
            Float fValueOf5 = Float.valueOf(f);
            zChanged = gapComposer.changed(transitionRememberTransition);
            objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged) {
                objRememberedValue5 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 0));
                gapComposer.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 0));
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            zBooleanValue2 = ((Boolean) ((State) objRememberedValue5).getValue()).booleanValue();
            gapComposer.startReplaceGroup(838300572);
            if (zBooleanValue2) {
                f2 = 1.0f;
            } else {
                f2 = 0.8f;
            }
            gapComposer.end(false);
            Float fValueOf6 = Float.valueOf(f2);
            zChanged2 = gapComposer.changed(transitionRememberTransition);
            objRememberedValue6 = gapComposer.rememberedValue();
            if (zChanged2) {
                objRememberedValue6 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 11));
                gapComposer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 11));
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            gapComposer.startReplaceGroup(-1664496585);
            gapComposer.end(false);
            final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf5, fValueOf6, finiteAnimationSpecValue, twoWayConverterImpl2, gapComposer, 196608);
            if (transitionRememberTransition.isSeeking()) {
                gapComposer.startReplaceGroup(1666573488);
                zChanged5 = gapComposer.changed(transitionRememberTransition);
                objMo773getCurrentState2 = gapComposer.rememberedValue();
                if (zChanged5) {
                    obj2 = obj;
                    if (objMo773getCurrentState2 == obj2) {
                    }
                    gapComposer.end(false);
                    z4 = false;
                } else {
                    obj2 = obj;
                }
                currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                Object objMo773getCurrentState7 = lifecycle.mo773getCurrentState();
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                gapComposer.updateRememberedValue(objMo773getCurrentState7);
                objMo773getCurrentState2 = objMo773getCurrentState7;
                gapComposer.end(false);
                z4 = false;
            } else {
                obj2 = obj;
                z4 = false;
                gapComposer.startReplaceGroup(1666827533);
                gapComposer.end(false);
                objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
            }
            zBooleanValue3 = ((Boolean) objMo773getCurrentState2).booleanValue();
            gapComposer.startReplaceGroup(-1903393104);
            if (zBooleanValue3) {
                f3 = 1.0f;
            } else {
                f3 = 0.0f;
            }
            gapComposer.end(z4);
            Float fValueOf7 = Float.valueOf(f3);
            zChanged3 = gapComposer.changed(transitionRememberTransition);
            objRememberedValue7 = gapComposer.rememberedValue();
            if (zChanged3) {
                objRememberedValue7 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 12));
                gapComposer.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 12));
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            boolean zBooleanValue5 = ((Boolean) ((State) objRememberedValue7).getValue()).booleanValue();
            gapComposer.startReplaceGroup(-1903393104);
            if (zBooleanValue5) {
            }
            gapComposer.end(z4);
            Float fValueOf8 = Float.valueOf(f4);
            zChanged4 = gapComposer.changed(transitionRememberTransition);
            objRememberedValue8 = gapComposer.rememberedValue();
            if (zChanged4) {
                objRememberedValue8 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 13));
                gapComposer.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, 13));
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            gapComposer.startReplaceGroup(-111222965);
            gapComposer.end(z4);
            final Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation4 = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf7, fValueOf8, finiteAnimationSpecValue3, twoWayConverterImpl2, gapComposer, 196608);
            final ComposableLambdaImpl composableLambdaImpl4 = composableLambdaImpl2;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Thread_jvmKt.rememberComposableLambda(-527401546, new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda3
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
                public final Object invoke(Object obj3, Object obj4) {
                    GapComposer gapComposer2 = (GapComposer) obj3;
                    int iIntValue = ((Integer) obj4).intValue();
                    boolean z5 = (iIntValue & 3) != 2;
                    MenuHostHelper menuHostHelper = gapComposer2.applier;
                    if (gapComposer2.shouldExecute(iIntValue & 1, z5)) {
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue9 == neverEqualPolicy) {
                            objRememberedValue9 = new TooltipKt$$ExternalSyntheticLambda7(mutableState2, 7);
                            gapComposer2.updateRememberedValue(objRememberedValue9);
                        }
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(companion, (Function1) objRememberedValue9);
                        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i8 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierOnGloballyPositioned);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i8);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        gapComposer2.startMovableGroup(-1350495383, Integer.valueOf(((Number) state2.getValue()).intValue()));
                        State state3 = transitionAnimationStateCreateTransitionAnimation3;
                        boolean zChanged7 = gapComposer2.changed(state3);
                        State state4 = transitionAnimationStateCreateTransitionAnimation4;
                        boolean zChanged8 = zChanged7 | gapComposer2.changed(state4);
                        Object objRememberedValue10 = gapComposer2.rememberedValue();
                        if (zChanged8 || objRememberedValue10 == neverEqualPolicy) {
                            objRememberedValue10 = new TooltipKt$$ExternalSyntheticLambda9(state3, state4, 0);
                            gapComposer2.updateRememberedValue(objRememberedValue10);
                        }
                        Modifier modifierGraphicsLayer = BrushKt.graphicsLayer(companion, (Function1) objRememberedValue10);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        long j2 = gapComposer2.compositeKeyHashCode;
                        int i9 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierGraphicsLayer);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i9, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        composableLambdaImpl4.invoke((Object) tooltipScopeImpl2, (Object) gapComposer2, (Object) 6);
                        gapComposer2.end(true);
                        gapComposer2.end(false);
                        gapComposer2.end(true);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer);
            int i8 = (i4 & 14) | 100663344 | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (i4 & 29360128);
            Modifier modifier6 = modifier4;
            LayoutUtilKt.BasicTooltipBox(popupPositionProvider, composableLambdaImplRememberComposableLambda4, tooltipStateImpl, modifier6, composableLambdaImplRememberComposableLambda3, gapComposer, i8);
            modifier3 = modifier6;
            z3 = true;
        } else {
            gapComposer.skipToGroupEnd();
            z3 = z;
            modifier3 = modifier2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda4(popupPositionProvider, composableLambdaImpl, tooltipStateImpl, modifier3, z3, function2, i, i2);
        }
    }

    public static final TooltipStateImpl rememberTooltipState(GapComposer gapComposer) {
        MutatorMutex mutatorMutex = BasicTooltipDefaults.GlobalMutatorMutex;
        boolean zChanged = gapComposer.changed(false) | gapComposer.changed(mutatorMutex);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new TooltipStateImpl(mutatorMutex);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (TooltipStateImpl) objRememberedValue;
    }
}
