package androidx.compose.animation;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1$1;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterNode$measure$1;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.ZipFilesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Scale {
    public static final void AnimatedEnterExitImpl(final Transition transition, final Function1 function1, final Modifier modifier, final EnterTransitionImpl enterTransitionImpl, final ExitTransitionImpl exitTransitionImpl, final Function2 function2, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i) {
        int i2;
        Transition transition2;
        TwoWayConverterImpl twoWayConverterImpl;
        TransitionData transitionData;
        boolean z;
        boolean z2;
        Transition.DeferredAnimation deferredAnimation;
        Transition.DeferredAnimation deferredAnimation2;
        Transition.DeferredAnimation deferredAnimation3;
        final boolean z3;
        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation;
        EnterTransitionImpl enterTransitionImpl2;
        ExitTransitionImpl exitTransitionImpl2;
        final ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImpl;
        gapComposer.startRestartGroup(1912839215);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(enterTransitionImpl) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(exitTransitionImpl) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 131072 : 65536;
        }
        int i3 = i2 | 1572864;
        if ((12582912 & i) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl2) ? 8388608 : 4194304;
        }
        int i4 = i3;
        if (gapComposer.shouldExecute(i4 & 1, (4793491 & i4) != 4793490)) {
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = transition.targetState$delegate;
            Lifecycle lifecycle = transition.transitionState;
            if (((Boolean) function1.invoke(parcelableSnapshotMutableState.getValue())).booleanValue() || ((Boolean) function1.invoke(lifecycle.mo773getCurrentState())).booleanValue() || transition.isSeeking() || transition.getHasInitialValueAnimations()) {
                gapComposer.startReplaceGroup(-232386135);
                int i5 = i4 & 14;
                int i6 = i5 | 48;
                int i7 = i6 & 14;
                int i8 = 6;
                boolean z4 = ((i7 ^ 6) > 4 && gapComposer.changed(transition)) || (i6 & 6) == 4;
                Object objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                if (z4 || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = lifecycle.mo773getCurrentState();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                if (transition.isSeeking()) {
                    objRememberedValue = lifecycle.mo773getCurrentState();
                }
                gapComposer.startReplaceGroup(1844425648);
                EnterExitState enterExitStateTargetEnterExit = targetEnterExit(transition, function1, objRememberedValue, gapComposer);
                gapComposer.end(false);
                Object value = transition.targetState$delegate.getValue();
                gapComposer.startReplaceGroup(1844425648);
                EnterExitState enterExitStateTargetEnterExit2 = targetEnterExit(transition, function1, value, gapComposer);
                gapComposer.end(false);
                int i9 = i7 | 3072;
                int i10 = (i9 & 14) ^ 6;
                boolean z5 = (i10 > 4 && gapComposer.changed(transition)) || (i9 & 6) == 4;
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (z5 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new Transition(new MutableTransitionState(enterExitStateTargetEnterExit), transition, ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), transition.label, " > EnterExitTransition"));
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                Transition transition3 = (Transition) objRememberedValue2;
                boolean zChanged = ((i10 > 4 && gapComposer.changed(transition)) || (i9 & 6) == 4) | gapComposer.changed(transition3);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(i8, transition, transition3);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Stack.DisposableEffect(transition3, (Function1) objRememberedValue3, gapComposer);
                if (transition.isSeeking()) {
                    transition3.seek(enterExitStateTargetEnterExit, enterExitStateTargetEnterExit2);
                } else {
                    transition3.updateTarget$animation_core(enterExitStateTargetEnterExit2);
                    transition3.isSeeking$delegate.setValue(Boolean.FALSE);
                }
                TwoWayConverterImpl twoWayConverterImpl2 = EnterExitTransitionKt.TransformOriginVectorConverter;
                boolean zChanged2 = gapComposer.changed(transition3);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.mutableStateOf$default(enterTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                MutableState mutableState = (MutableState) objRememberedValue4;
                Lifecycle lifecycle2 = transition3.transitionState;
                Lifecycle lifecycle3 = transition3.transitionState;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = transition3.targetState$delegate;
                Object objMo773getCurrentState = lifecycle2.mo773getCurrentState();
                Object value2 = parcelableSnapshotMutableState2.getValue();
                EnterExitState enterExitState = EnterExitState.Visible;
                if (objMo773getCurrentState == value2 && lifecycle3.mo773getCurrentState() == enterExitState) {
                    if (transition3.isSeeking()) {
                        mutableState.setValue(enterTransitionImpl);
                    } else {
                        mutableState.setValue(EnterTransitionImpl.None);
                    }
                } else if (parcelableSnapshotMutableState2.getValue() == enterExitState) {
                    mutableState.setValue(((EnterTransitionImpl) mutableState.getValue()).plus(enterTransitionImpl));
                }
                EnterTransitionImpl enterTransitionImpl3 = (EnterTransitionImpl) mutableState.getValue();
                boolean zChanged3 = gapComposer.changed(transition3);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Stack.mutableStateOf$default(exitTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                MutableState mutableState2 = (MutableState) objRememberedValue5;
                if (lifecycle3.mo773getCurrentState() == parcelableSnapshotMutableState2.getValue() && lifecycle3.mo773getCurrentState() == enterExitState) {
                    if (transition3.isSeeking()) {
                        mutableState2.setValue(exitTransitionImpl);
                    } else {
                        mutableState2.setValue(ExitTransitionImpl.None);
                    }
                } else if (parcelableSnapshotMutableState2.getValue() != enterExitState) {
                    mutableState2.setValue(((ExitTransitionImpl) mutableState2.getValue()).plus(exitTransitionImpl));
                }
                ExitTransitionImpl exitTransitionImpl3 = (ExitTransitionImpl) mutableState2.getValue();
                MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function2, gapComposer);
                Object objInvoke = function2.invoke(lifecycle3.mo773getCurrentState(), parcelableSnapshotMutableState2.getValue());
                boolean zChanged4 = gapComposer.changed(transition3) | gapComposer.changed(mutableStateRememberUpdatedState);
                Object objRememberedValue6 = gapComposer.rememberedValue();
                if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new NavHostKt$NavHost$28$1(transition3, mutableStateRememberUpdatedState, (Continuation) null);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                Function2 function3 = (Function2) objRememberedValue6;
                Object objRememberedValue7 = gapComposer.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = Stack.mutableStateOf$default(objInvoke);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                MutableState mutableState3 = (MutableState) objRememberedValue7;
                Unit unit = Unit.INSTANCE;
                boolean zChangedInstance = gapComposer.changedInstance(function3);
                Object objRememberedValue8 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue8 == neverEqualPolicy) {
                    objRememberedValue8 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, 0);
                    gapComposer.updateRememberedValue(objRememberedValue8);
                }
                Stack.LaunchedEffect(gapComposer, unit, (Function2) objRememberedValue8);
                Object objMo773getCurrentState2 = lifecycle3.mo773getCurrentState();
                EnterExitState enterExitState2 = EnterExitState.PostExit;
                if (objMo773getCurrentState2 == enterExitState2 && parcelableSnapshotMutableState2.getValue() == enterExitState2 && ((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(-229368781);
                    gapComposer.end(false);
                    composableLambdaImpl2 = composableLambdaImpl;
                    z = false;
                } else {
                    gapComposer.startReplaceGroup(-230699766);
                    boolean z6 = i5 == 4;
                    Object objRememberedValue9 = gapComposer.rememberedValue();
                    if (z6 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new AnimatedVisibilityScopeImpl(transition3);
                        gapComposer.updateRememberedValue(objRememberedValue9);
                    }
                    AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue9;
                    TwoWayConverterImpl twoWayConverterImpl3 = ArcSplineKt.IntOffsetToVector;
                    Object objRememberedValue10 = gapComposer.rememberedValue();
                    if (objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = EnterExitTransitionKt$createModifier$1$1.INSTANCE;
                        gapComposer.updateRememberedValue(objRememberedValue10);
                    }
                    final Function0 function0 = (Function0) objRememberedValue10;
                    gapComposer.startReplaceGroup(-167964673);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(-167961890);
                    gapComposer.end(false);
                    TransitionData transitionData2 = enterTransitionImpl3.data;
                    TransitionData transitionData3 = exitTransitionImpl3.data;
                    Slide slide = transitionData2.slide;
                    ChangeSize changeSize = transitionData2.changeSize;
                    boolean z7 = (slide == null && transitionData3.slide == null) ? false : true;
                    boolean z8 = (changeSize == null && transitionData3.changeSize == null) ? false : true;
                    if (z7) {
                        gapComposer.startReplaceGroup(-911488127);
                        Object objRememberedValue11 = gapComposer.rememberedValue();
                        if (objRememberedValue11 == neverEqualPolicy) {
                            objRememberedValue11 = "Built-in slide";
                            gapComposer.updateRememberedValue("Built-in slide");
                        }
                        String str = (String) objRememberedValue11;
                        z = false;
                        z2 = true;
                        transition2 = transition3;
                        transitionData = transitionData3;
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation2 = ArcSplineKt.createDeferredAnimation(transition2, twoWayConverterImpl3, str, gapComposer, 384, 0);
                        twoWayConverterImpl = twoWayConverterImpl3;
                        gapComposer.end(false);
                        deferredAnimation = deferredAnimationCreateDeferredAnimation2;
                    } else {
                        transition2 = transition3;
                        twoWayConverterImpl = twoWayConverterImpl3;
                        transitionData = transitionData3;
                        z = false;
                        z2 = true;
                        gapComposer.startReplaceGroup(-911382324);
                        gapComposer.end(false);
                        deferredAnimation = null;
                    }
                    if (z8) {
                        gapComposer.startReplaceGroup(-911290533);
                        TwoWayConverterImpl twoWayConverterImpl4 = ArcSplineKt.IntSizeToVector;
                        Object objRememberedValue12 = gapComposer.rememberedValue();
                        if (objRememberedValue12 == neverEqualPolicy) {
                            objRememberedValue12 = "Built-in shrink/expand";
                            gapComposer.updateRememberedValue("Built-in shrink/expand");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation3 = ArcSplineKt.createDeferredAnimation(transition2, twoWayConverterImpl4, (String) objRememberedValue12, gapComposer, 384, 0);
                        gapComposer.end(z);
                        deferredAnimation2 = deferredAnimationCreateDeferredAnimation3;
                    } else {
                        gapComposer.startReplaceGroup(-911179709);
                        gapComposer.end(z);
                        deferredAnimation2 = null;
                    }
                    if (z8) {
                        gapComposer.startReplaceGroup(-911106083);
                        Object objRememberedValue13 = gapComposer.rememberedValue();
                        if (objRememberedValue13 == neverEqualPolicy) {
                            objRememberedValue13 = "Built-in InterruptionHandlingOffset";
                            gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation4 = ArcSplineKt.createDeferredAnimation(transition2, twoWayConverterImpl, (String) objRememberedValue13, gapComposer, 384, 0);
                        gapComposer.end(z);
                        deferredAnimation3 = deferredAnimationCreateDeferredAnimation4;
                    } else {
                        gapComposer.startReplaceGroup(-910935677);
                        gapComposer.end(z);
                        deferredAnimation3 = null;
                    }
                    boolean z9 = !z8;
                    float[] fArr = ColorSpaces.SrgbPrimaries;
                    gapComposer.startReplaceGroup(-910130296);
                    gapComposer.end(z);
                    TwoWayConverterImpl twoWayConverterImpl5 = ArcSplineKt.FloatToVector;
                    if ((transitionData2.fade == null && transitionData.fade == null) ? z : z2) {
                        gapComposer.startReplaceGroup(-703879421);
                        Object objRememberedValue14 = gapComposer.rememberedValue();
                        if (objRememberedValue14 == neverEqualPolicy) {
                            objRememberedValue14 = "Built-in alpha";
                            gapComposer.updateRememberedValue("Built-in alpha");
                        }
                        String str2 = (String) objRememberedValue14;
                        z3 = z9;
                        deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transition2, twoWayConverterImpl5, str2, gapComposer, 384, 0);
                        gapComposer.end(z);
                    } else {
                        z3 = z9;
                        gapComposer.startReplaceGroup(-703709976);
                        gapComposer.end(z);
                        deferredAnimationCreateDeferredAnimation = null;
                    }
                    gapComposer.startReplaceGroup(-703472888);
                    gapComposer.end(z);
                    gapComposer.startReplaceGroup(-703222904);
                    gapComposer.end(z);
                    Transition.DeferredAnimation deferredAnimation4 = null;
                    boolean zChangedInstance2 = gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation) | gapComposer.changed(enterTransitionImpl3) | gapComposer.changed(exitTransitionImpl3) | gapComposer.changedInstance(null) | gapComposer.changed(transition2) | gapComposer.changedInstance(null);
                    Object objRememberedValue15 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue15 == neverEqualPolicy) {
                        enterTransitionImpl2 = enterTransitionImpl3;
                        exitTransitionImpl2 = exitTransitionImpl3;
                        objRememberedValue15 = new EnterExitTransitionKt$$ExternalSyntheticLambda0(deferredAnimationCreateDeferredAnimation, deferredAnimation4, transition2, enterTransitionImpl2, exitTransitionImpl2, deferredAnimation4);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    } else {
                        enterTransitionImpl2 = enterTransitionImpl3;
                        exitTransitionImpl2 = exitTransitionImpl3;
                    }
                    EnterExitTransitionKt$$ExternalSyntheticLambda0 enterExitTransitionKt$$ExternalSyntheticLambda0 = (EnterExitTransitionKt$$ExternalSyntheticLambda0) objRememberedValue15;
                    boolean zChanged5 = gapComposer.changed(z3) | gapComposer.changed(function0);
                    Object objRememberedValue16 = gapComposer.rememberedValue();
                    if (zChanged5 || objRememberedValue16 == neverEqualPolicy) {
                        objRememberedValue16 = new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                ((ReusableGraphicsLayerScope) obj).setClip(!z3 && ((Boolean) function0.invoke()).booleanValue());
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue16);
                    }
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierThen = BrushKt.graphicsLayer(companion, (Function1) objRememberedValue16).then(new EnterExitTransitionElement(transition2, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl2, function0, enterExitTransitionKt$$ExternalSyntheticLambda0)).then(companion);
                    gapComposer.startReplaceGroup(-7404393);
                    gapComposer.end(z);
                    Modifier modifierThen2 = modifier.then(modifierThen.then(companion));
                    Object objRememberedValue17 = gapComposer.rememberedValue();
                    if (objRememberedValue17 == neverEqualPolicy) {
                        objRememberedValue17 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        gapComposer.updateRememberedValue(objRememberedValue17);
                    }
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) objRememberedValue17;
                    long j = gapComposer.compositeKeyHashCode;
                    int i11 = (int) (j ^ (j >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierThen2);
                    ComposeUiNode.Companion.getClass();
                    Function0 function4 = ComposeUiNode.Companion.Constructor;
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(function4);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m295setimpl(gapComposer, animatedEnterExitMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m291initimpl(gapComposer, Integer.valueOf(i11), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    composableLambdaImpl2 = composableLambdaImpl;
                    composableLambdaImpl2.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i4 >> 18) & 112));
                    gapComposer.end(z2);
                    gapComposer.end(z);
                }
                gapComposer.end(z);
            } else {
                gapComposer.startReplaceGroup(-229362829);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Number) obj2).intValue();
                    Scale.AnimatedEnterExitImpl(transition, function1, modifier, enterTransitionImpl, exitTransitionImpl, function2, composableLambdaImpl2, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void AnimatedVisibility(final boolean z, Modifier modifier, final EnterTransitionImpl enterTransitionImpl, final ExitTransitionImpl exitTransitionImpl, String str, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i) {
        int i2;
        final String str2;
        gapComposer.startRestartGroup(1799879339);
        if ((i & 48) == 0) {
            i2 = (gapComposer.changed(z) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | 384;
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changed(enterTransitionImpl) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changed(exitTransitionImpl) ? 16384 : 8192;
        }
        int i4 = i3 | 196608;
        if ((1572864 & i) == 0) {
            i4 |= gapComposer.changedInstance(composableLambdaImpl) ? 1048576 : 524288;
        }
        if (gapComposer.shouldExecute(i4 & 1, (599185 & i4) != 599184)) {
            int i5 = i4 >> 3;
            Transition transitionUpdateTransition = ArcSplineKt.updateTransition(Boolean.valueOf(z), "AnimatedVisibility", gapComposer, (i5 & 14) | ((i4 >> 12) & 112), 0);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = CrossfadeKt$Crossfade$3$1.INSTANCE$2;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            AnimatedVisibilityImpl(transitionUpdateTransition, (Function1) objRememberedValue, enterTransitionImpl, exitTransitionImpl, composableLambdaImpl, gapComposer, (i4 & 57344) | (i4 & 896) | 48 | (i4 & 7168) | (i5 & 458752));
            modifier = Modifier.Companion.$$INSTANCE;
            str2 = "AnimatedVisibility";
        } else {
            gapComposer.skipToGroupEnd();
            str2 = str;
        }
        final Modifier modifier2 = modifier;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Number) obj2).intValue();
                    Scale.AnimatedVisibility(z, modifier2, enterTransitionImpl, exitTransitionImpl, str2, composableLambdaImpl, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void AnimatedVisibilityImpl(final Transition transition, final Function1 function1, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        EnterTransitionImpl enterTransitionImpl2;
        ExitTransitionImpl exitTransitionImpl2;
        ComposableLambdaImpl composableLambdaImpl2;
        gapComposer.startRestartGroup(1706321816);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i & 384;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (i3 == 0) {
            i2 |= gapComposer.changed(companion) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            enterTransitionImpl2 = enterTransitionImpl;
            i2 |= gapComposer.changed(enterTransitionImpl2) ? 2048 : 1024;
        } else {
            enterTransitionImpl2 = enterTransitionImpl;
        }
        if ((i & 24576) == 0) {
            exitTransitionImpl2 = exitTransitionImpl;
            i2 |= gapComposer.changed(exitTransitionImpl2) ? 16384 : 8192;
        } else {
            exitTransitionImpl2 = exitTransitionImpl;
        }
        if ((i & 196608) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            i2 |= gapComposer.changedInstance(composableLambdaImpl2) ? 131072 : 65536;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            int i4 = i2 & 112;
            int i5 = i2 & 14;
            boolean z = (i4 == 32) | (i5 == 4);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (z || objRememberedValue == obj) {
                objRememberedValue = new Function3() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        long j;
                        MeasureScope measureScope = (MeasureScope) obj2;
                        Placeable placeableMo517measureBRTryo0 = ((Measurable) obj3).mo517measureBRTryo0(((Constraints) obj4).value);
                        if (measureScope.isLookingAhead()) {
                            if (((Boolean) function1.invoke(transition.targetState$delegate.getValue())).booleanValue()) {
                                j = (((long) placeableMo517measureBRTryo0.width) << 32) | (((long) placeableMo517measureBRTryo0.height) & 4294967295L);
                            } else {
                                j = 0;
                            }
                        } else {
                            j = (((long) placeableMo517measureBRTryo0.width) << 32) | (((long) placeableMo517measureBRTryo0.height) & 4294967295L);
                        }
                        return measureScope.layout((int) (j >> 32), (int) (4294967295L & j), EmptyMap.INSTANCE, new PainterNode$measure$1(placeableMo517measureBRTryo0, 1));
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierLayout = RulerKt.layout(companion, (Function3) objRememberedValue);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = AnimatedContentKt$SizeTransform$1.INSTANCE$1;
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            EnterTransitionImpl enterTransitionImpl3 = enterTransitionImpl2;
            AnimatedEnterExitImpl(transition, function1, modifierLayout, enterTransitionImpl3, exitTransitionImpl2, (Function2) objRememberedValue2, composableLambdaImpl2, gapComposer, ((i2 << 6) & 29360128) | i5 | 196608 | i4 | (i2 & 7168) | (57344 & i2));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$Crossfade$1(transition, function1, enterTransitionImpl, exitTransitionImpl, composableLambdaImpl, i, 1);
        }
    }

    public static final void Crossfade(Object obj, Modifier modifier, TweenSpec tweenSpec, String str, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        Modifier modifier2;
        gapComposer.startRestartGroup(-513216493);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(obj) : gapComposer.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | 48;
        if ((i & 384) == 0) {
            i3 |= gapComposer.changedInstance(tweenSpec) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changed(str) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 16384 : 8192;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Crossfade(ArcSplineKt.updateTransition(obj, str, gapComposer, (i3 & 14) | ((i3 >> 6) & 112), 0), companion, tweenSpec, (Function1) null, composableLambdaImpl, gapComposer, i3 & 58352);
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$Crossfade$1(obj, modifier2, tweenSpec, str, composableLambdaImpl, i, 0);
        }
    }

    public static final EnterExitState targetEnterExit(Transition transition, Function1 function1, Object obj, GapComposer gapComposer) {
        gapComposer.startMovableGroup(-422486745, transition);
        boolean zIsSeeking = transition.isSeeking();
        Lifecycle lifecycle = transition.transitionState;
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.PostExit;
        EnterExitState enterExitState3 = EnterExitState.Visible;
        if (zIsSeeking) {
            gapComposer.startReplaceGroup(-212166497);
            gapComposer.end(false);
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                enterExitState = enterExitState3;
            } else if (((Boolean) function1.invoke(lifecycle.mo773getCurrentState())).booleanValue()) {
                enterExitState = enterExitState2;
            }
        } else {
            gapComposer.startReplaceGroup(-211892364);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            if (((Boolean) function1.invoke(lifecycle.mo773getCurrentState())).booleanValue()) {
                mutableState.setValue(Boolean.TRUE);
            }
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                enterExitState = enterExitState3;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = enterExitState2;
            }
            gapComposer.end(false);
        }
        gapComposer.end(false);
        return enterExitState;
    }

    public static final void Crossfade(Transition transition, Modifier modifier, TweenSpec tweenSpec, Function1 function1, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        Object obj;
        Function1 function2;
        Transition transition2 = transition;
        Lifecycle lifecycle = transition2.transitionState;
        gapComposer.startRestartGroup(-1877370462);
        int i2 = (i & 6) == 0 ? (gapComposer.changed(transition2) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            obj = tweenSpec;
            i2 |= gapComposer.changedInstance(obj) ? 256 : 128;
        } else {
            obj = tweenSpec;
        }
        int i3 = i2 | 3072;
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 16384 : 8192;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj2 = Composer$Companion.Empty;
            if (objRememberedValue == obj2) {
                objRememberedValue = CrossfadeKt$Crossfade$3$1.INSTANCE;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function1 function3 = (Function1) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            Object obj3 = objRememberedValue2;
            if (objRememberedValue2 == obj2) {
                SnapshotStateList snapshotStateList = new SnapshotStateList();
                snapshotStateList.add(lifecycle.mo773getCurrentState());
                gapComposer.updateRememberedValue(snapshotStateList);
                obj3 = snapshotStateList;
            }
            SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj3;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == obj2) {
                long[] jArr = ScatterMapKt.EmptyGroup;
                objRememberedValue3 = new MutableScatterMap();
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableScatterMap mutableScatterMap = (MutableScatterMap) objRememberedValue3;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = transition2.targetState$delegate;
            if (Intrinsics.areEqual(lifecycle.mo773getCurrentState(), parcelableSnapshotMutableState.getValue())) {
                gapComposer.startReplaceGroup(321145192);
                if (snapshotStateList2.size() == 1 && Intrinsics.areEqual(snapshotStateList2.get(0), parcelableSnapshotMutableState.getValue())) {
                    gapComposer.startReplaceGroup(321469824);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(321279546);
                    int i4 = i3 & 14;
                    int i5 = 4;
                    boolean z = i4 == 4;
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (z || objRememberedValue4 == obj2) {
                        objRememberedValue4 = new Navigator.AnonymousClass1(i5, transition2);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    CollectionsKt__MutableCollectionsKt.removeAll(snapshotStateList2, (Function1) objRememberedValue4);
                    mutableScatterMap.clear();
                    gapComposer.end(false);
                }
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(321475776);
                gapComposer.end(false);
            }
            if (!mutableScatterMap.contains(parcelableSnapshotMutableState.getValue())) {
                gapComposer.startReplaceGroup(321536443);
                ListIterator listIterator = snapshotStateList2.listIterator();
                int i6 = 0;
                while (true) {
                    ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
                    if (!itr.hasNext()) {
                        i6 = -1;
                        break;
                    } else if (Intrinsics.areEqual(function3.invoke(itr.next()), function3.invoke(parcelableSnapshotMutableState.getValue()))) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 == -1) {
                    snapshotStateList2.add(parcelableSnapshotMutableState.getValue());
                } else {
                    snapshotStateList2.set(i6, parcelableSnapshotMutableState.getValue());
                }
                mutableScatterMap.clear();
                int size = snapshotStateList2.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj4 = snapshotStateList2.get(i7);
                    mutableScatterMap.set(obj4, Thread_jvmKt.rememberComposableLambda(-934471669, new ZipFilesKt.C00461(transition2, obj, obj4, composableLambdaImpl, 1), gapComposer));
                    i7++;
                    transition2 = transition;
                    obj = tweenSpec;
                }
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(322279296);
                gapComposer.end(false);
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i8 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            Function0 function0 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(function0);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m291initimpl(gapComposer, Integer.valueOf(i8), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            gapComposer.startReplaceGroup(-1312707512);
            int size2 = snapshotStateList2.size();
            for (int i9 = 0; i9 < size2; i9++) {
                Object obj5 = snapshotStateList2.get(i9);
                gapComposer.startMovableGroup(1171574969, function3.invoke(obj5));
                Function2 function4 = (Function2) mutableScatterMap.get(obj5);
                if (function4 == null) {
                    gapComposer.startReplaceGroup(1959122128);
                } else {
                    gapComposer.startReplaceGroup(1171576145);
                    function4.invoke(gapComposer, 0);
                }
                gapComposer.end(false);
                gapComposer.end(false);
            }
            gapComposer.end(false);
            gapComposer.end(true);
            function2 = function3;
        } else {
            gapComposer.skipToGroupEnd();
            function2 = function1;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$Crossfade$1(transition, modifier, tweenSpec, function2, composableLambdaImpl, i, 2);
        }
    }
}
