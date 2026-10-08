package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.LayoutNodeDrawScope$record$1;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.window.PopupLayout$Content$4;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController$handleDeepLink$2;
import androidx.navigation.Navigator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnimatedContentKt {
    public static final long UnspecifiedSize;

    static {
        long j = Integer.MIN_VALUE;
        UnspecifiedSize = (j & 4294967295L) | (j << 32);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0058  */
    /* JADX WARN: Code duplicated, block: B:35:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedContent(final Object obj, Modifier modifier, final Function1 function1, Alignment alignment, final String str, Function1 function2, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        Alignment alignment2;
        int i4;
        boolean z;
        final Modifier modifier2;
        final Function1 function3;
        final Alignment alignment3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Alignment alignment4;
        Object objRememberedValue;
        int i5;
        int i6;
        gapComposer.startRestartGroup(1501828832);
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? gapComposer.changed(obj) : gapComposer.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i3 | 48;
        if ((i & 384) == 0) {
            i7 |= gapComposer.changedInstance(function1) ? 256 : 128;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                alignment2 = alignment;
                i7 |= gapComposer.changed(alignment2) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if (gapComposer.changed(str)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i7 |= i6;
            }
            i4 = i7 | 196608;
            if ((1572864 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i4 |= i5;
            }
            if ((599187 & i4) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z)) {
                if (i8 != 0) {
                    alignment4 = Alignment.Companion.TopStart;
                } else {
                    alignment4 = alignment2;
                }
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = CrossfadeKt$Crossfade$3$1.INSTANCE$1;
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Function1 function4 = (Function1) objRememberedValue;
                Transition transitionUpdateTransition = ArcSplineKt.updateTransition(obj, str, gapComposer, (i4 & 14) | ((i4 >> 9) & 112), 0);
                int i9 = i4 & 8176;
                int i10 = i4 >> 3;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                Alignment alignment5 = alignment4;
                AnimatedContent(transitionUpdateTransition, companion, function1, alignment5, function4, composableLambdaImpl, gapComposer, i9 | (57344 & i10) | (i10 & 458752));
                modifier2 = companion;
                alignment3 = alignment5;
                function3 = function4;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                function3 = function2;
                alignment3 = alignment2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        ((Number) obj3).intValue();
                        AnimatedContentKt.AnimatedContent(obj, modifier2, function1, alignment3, str, function3, composableLambdaImpl, (GapComposer) obj2, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i7 |= 3072;
        alignment2 = alignment;
        if ((i & 24576) == 0) {
            if (gapComposer.changed(str)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i7 |= i6;
        }
        i4 = i7 | 196608;
        if ((1572864 & i) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i5 = 1048576;
            } else {
                i5 = 524288;
            }
            i4 |= i5;
        }
        if ((599187 & i4) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z)) {
            if (i8 != 0) {
                alignment4 = Alignment.Companion.TopStart;
            } else {
                alignment4 = alignment2;
            }
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = CrossfadeKt$Crossfade$3$1.INSTANCE$1;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function1 function5 = (Function1) objRememberedValue;
            Transition transitionUpdateTransition2 = ArcSplineKt.updateTransition(obj, str, gapComposer, (i4 & 14) | ((i4 >> 9) & 112), 0);
            int i11 = i4 & 8176;
            int i12 = i4 >> 3;
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Alignment alignment6 = alignment4;
            AnimatedContent(transitionUpdateTransition2, companion2, function1, alignment6, function5, composableLambdaImpl, gapComposer, i11 | (57344 & i12) | (i12 & 458752));
            modifier2 = companion2;
            alignment3 = alignment6;
            function3 = function5;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            function3 = function2;
            alignment3 = alignment2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Number) obj3).intValue();
                    AnimatedContentKt.AnimatedContent(obj, modifier2, function1, alignment3, str, function3, composableLambdaImpl, (GapComposer) obj2, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final ContentTransform togetherWith(EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl) {
        return new ContentTransform(enterTransitionImpl, exitTransitionImpl, 0.0f, new SizeTransformImpl(AnimatedContentKt$SizeTransform$1.INSTANCE));
    }

    public static final void AnimatedContent(final Transition transition, final Modifier modifier, Function1 function1, final Alignment alignment, final Function1 function2, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i) {
        int i2;
        Function1 function3;
        GapComposer gapComposer2;
        Lifecycle lifecycle;
        SnapshotStateList snapshotStateList;
        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl;
        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation;
        boolean z;
        final Function1 function4 = function1;
        gapComposer.startRestartGroup(511725103);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function4) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(alignment) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 16384 : 8192;
        }
        final ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImpl;
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl2) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            int i3 = i2 & 14;
            boolean z2 = i3 == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (z2 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, alignment);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2 = (AnimatedContentTransitionScopeImpl) objRememberedValue;
            boolean z3 = i3 == 4;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z3 || objRememberedValue2 == neverEqualPolicy) {
                Object[] objArr = {transition.transitionState.mo773getCurrentState()};
                SnapshotStateList snapshotStateList2 = new SnapshotStateList();
                snapshotStateList2.addAll(ArraysKt.toList(objArr));
                gapComposer.updateRememberedValue(snapshotStateList2);
                objRememberedValue2 = snapshotStateList2;
            }
            final SnapshotStateList snapshotStateList3 = (SnapshotStateList) objRememberedValue2;
            boolean z4 = i3 == 4;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (z4 || objRememberedValue3 == neverEqualPolicy) {
                long[] jArr = ScatterMapKt.EmptyGroup;
                objRememberedValue3 = new MutableScatterMap();
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableScatterMap mutableScatterMap = (MutableScatterMap) objRememberedValue3;
            Lifecycle lifecycle2 = transition.transitionState;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = transition.targetState$delegate;
            if (!snapshotStateList3.contains(lifecycle2.mo773getCurrentState())) {
                snapshotStateList3.clear();
                snapshotStateList3.add(lifecycle2.mo773getCurrentState());
            }
            if (Intrinsics.areEqual(lifecycle2.mo773getCurrentState(), parcelableSnapshotMutableState.getValue())) {
                if (snapshotStateList3.size() != 1 || !Intrinsics.areEqual(snapshotStateList3.get(0), lifecycle2.mo773getCurrentState())) {
                    snapshotStateList3.clear();
                    snapshotStateList3.add(lifecycle2.mo773getCurrentState());
                }
                if (mutableScatterMap._size != 1 || mutableScatterMap.containsKey(lifecycle2.mo773getCurrentState())) {
                    mutableScatterMap.clear();
                }
                animatedContentTransitionScopeImpl2.contentAlignment = alignment;
            }
            if (Intrinsics.areEqual(lifecycle2.mo773getCurrentState(), parcelableSnapshotMutableState.getValue()) || snapshotStateList3.contains(parcelableSnapshotMutableState.getValue())) {
                lifecycle = lifecycle2;
            } else {
                ListIterator listIterator = snapshotStateList3.listIterator();
                int i4 = 0;
                while (true) {
                    ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
                    lifecycle = lifecycle2;
                    if (!itr.hasNext()) {
                        i4 = -1;
                        break;
                    } else {
                        if (Intrinsics.areEqual(function2.invoke(itr.next()), function2.invoke(parcelableSnapshotMutableState.getValue()))) {
                            break;
                        }
                        i4++;
                        lifecycle2 = lifecycle;
                    }
                }
                if (i4 == -1) {
                    snapshotStateList3.add(parcelableSnapshotMutableState.getValue());
                } else {
                    snapshotStateList3.set(i4, parcelableSnapshotMutableState.getValue());
                }
            }
            if (mutableScatterMap.containsKey(parcelableSnapshotMutableState.getValue()) && mutableScatterMap.containsKey(lifecycle.mo773getCurrentState())) {
                gapComposer.startReplaceGroup(1968995539);
                gapComposer.end(false);
                function3 = function4;
            } else {
                gapComposer.startReplaceGroup(1966410449);
                mutableScatterMap.clear();
                int size = snapshotStateList3.size();
                int i5 = 0;
                while (i5 < size) {
                    final Object obj = snapshotStateList3.get(i5);
                    mutableScatterMap.set(obj, Thread_jvmKt.rememberComposableLambda(-23915175, new Function2() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            GapComposer gapComposer3 = (GapComposer) obj2;
                            int iIntValue = ((Number) obj3).intValue();
                            if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Object objRememberedValue4 = gapComposer3.rememberedValue();
                                Function1 function5 = function4;
                                final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                                NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                                if (objRememberedValue4 == neverEqualPolicy2) {
                                    objRememberedValue4 = (ContentTransform) function5.invoke(animatedContentTransitionScopeImpl3);
                                    gapComposer3.updateRememberedValue(objRememberedValue4);
                                }
                                final ContentTransform contentTransform = (ContentTransform) objRememberedValue4;
                                Transition transition2 = transition;
                                Transition.Segment segment = transition2.getSegment();
                                ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = transition2.targetState$delegate;
                                Object targetState = segment.getTargetState();
                                final Object obj4 = obj;
                                boolean zChanged = gapComposer3.changed(Intrinsics.areEqual(targetState, obj4));
                                Object objRememberedValue5 = gapComposer3.rememberedValue();
                                if (zChanged || objRememberedValue5 == neverEqualPolicy2) {
                                    objRememberedValue5 = Intrinsics.areEqual(transition2.getSegment().getTargetState(), obj4) ? ExitTransitionImpl.None : ((ContentTransform) function5.invoke(animatedContentTransitionScopeImpl3)).initialContentExit;
                                    gapComposer3.updateRememberedValue(objRememberedValue5);
                                }
                                ExitTransitionImpl exitTransitionImpl = (ExitTransitionImpl) objRememberedValue5;
                                Object objRememberedValue6 = gapComposer3.rememberedValue();
                                if (objRememberedValue6 == neverEqualPolicy2) {
                                    objRememberedValue6 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual(obj4, parcelableSnapshotMutableState2.getValue()));
                                    gapComposer3.updateRememberedValue(objRememberedValue6);
                                }
                                AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) objRememberedValue6;
                                EnterTransitionImpl enterTransitionImpl = contentTransform.targetContentEnter;
                                boolean zChangedInstance = gapComposer3.changedInstance(contentTransform);
                                Object objRememberedValue7 = gapComposer3.rememberedValue();
                                if (zChangedInstance || objRememberedValue7 == neverEqualPolicy2) {
                                    objRememberedValue7 = new Function3() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj5, Object obj6, Object obj7) {
                                            Placeable placeableMo517measureBRTryo0 = ((Measurable) obj6).mo517measureBRTryo0(((Constraints) obj7).value);
                                            return ((MeasureScope) obj5).layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new NavController$handleDeepLink$2(1, placeableMo517measureBRTryo0, contentTransform));
                                        }
                                    };
                                    gapComposer3.updateRememberedValue(objRememberedValue7);
                                }
                                Modifier modifierLayout = RulerKt.layout(Modifier.Companion.$$INSTANCE, (Function3) objRememberedValue7);
                                childData.isTarget$delegate.setValue(Boolean.valueOf(Intrinsics.areEqual(obj4, parcelableSnapshotMutableState2.getValue())));
                                Modifier modifierThen = modifierLayout.then(childData);
                                boolean zChangedInstance2 = gapComposer3.changedInstance(obj4);
                                Object objRememberedValue8 = gapComposer3.rememberedValue();
                                if (zChangedInstance2 || objRememberedValue8 == neverEqualPolicy2) {
                                    objRememberedValue8 = new Navigator.AnonymousClass1(2, obj4);
                                    gapComposer3.updateRememberedValue(objRememberedValue8);
                                }
                                Function1 function6 = (Function1) objRememberedValue8;
                                boolean zChanged2 = gapComposer3.changed(exitTransitionImpl);
                                Object objRememberedValue9 = gapComposer3.rememberedValue();
                                if (zChanged2 || objRememberedValue9 == neverEqualPolicy2) {
                                    objRememberedValue9 = new PopupLayout$Content$4(1, exitTransitionImpl);
                                    gapComposer3.updateRememberedValue(objRememberedValue9);
                                }
                                final SnapshotStateList snapshotStateList4 = snapshotStateList3;
                                final ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl2;
                                Scale.AnimatedEnterExitImpl(transition, function6, modifierThen, enterTransitionImpl, exitTransitionImpl, (Function2) objRememberedValue9, Thread_jvmKt.rememberComposableLambda(-143346359, new Function3() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

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
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj5, Object obj6, Object obj7) {
                                        AnimatedVisibilityScope animatedVisibilityScope = (AnimatedVisibilityScope) obj5;
                                        GapComposer gapComposer4 = (GapComposer) obj6;
                                        int iIntValue2 = ((Number) obj7).intValue();
                                        if ((iIntValue2 & 6) == 0) {
                                            iIntValue2 |= (iIntValue2 & 8) == 0 ? gapComposer4.changed(animatedVisibilityScope) : gapComposer4.changedInstance(animatedVisibilityScope) ? 4 : 2;
                                        }
                                        if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                            SnapshotStateList snapshotStateList5 = snapshotStateList4;
                                            boolean zChanged3 = gapComposer4.changed(snapshotStateList5);
                                            Object obj8 = obj4;
                                            boolean zChangedInstance3 = zChanged3 | gapComposer4.changedInstance(obj8);
                                            AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl4 = animatedContentTransitionScopeImpl3;
                                            boolean zChangedInstance4 = zChangedInstance3 | gapComposer4.changedInstance(animatedContentTransitionScopeImpl4);
                                            Object objRememberedValue10 = gapComposer4.rememberedValue();
                                            NeverEqualPolicy neverEqualPolicy3 = Composer$Companion.Empty;
                                            if (zChangedInstance4 || objRememberedValue10 == neverEqualPolicy3) {
                                                objRememberedValue10 = new LayoutNodeDrawScope$record$1(snapshotStateList5, obj8, animatedContentTransitionScopeImpl4, 1);
                                                gapComposer4.updateRememberedValue(objRememberedValue10);
                                            }
                                            Stack.DisposableEffect(animatedVisibilityScope, (Function1) objRememberedValue10, gapComposer4);
                                            animatedContentTransitionScopeImpl4.targetSizeMap.set(obj8, ((AnimatedVisibilityScopeImpl) animatedVisibilityScope).targetSize);
                                            Object objRememberedValue11 = gapComposer4.rememberedValue();
                                            if (objRememberedValue11 == neverEqualPolicy3) {
                                                objRememberedValue11 = new AnimatedContentScopeImpl(animatedVisibilityScope);
                                                gapComposer4.updateRememberedValue(objRememberedValue11);
                                            }
                                            composableLambdaImpl3.invoke(objRememberedValue11, obj8, (Object) gapComposer4, (Object) 0);
                                        } else {
                                            gapComposer4.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, gapComposer3), gapComposer3, 12582912);
                            } else {
                                gapComposer3.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer));
                    i5++;
                    function4 = function4;
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                function3 = function4;
                gapComposer.end(false);
            }
            boolean zChanged = gapComposer.changed(transition.getSegment()) | gapComposer.changed(animatedContentTransitionScopeImpl2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = (ContentTransform) function3.invoke(animatedContentTransitionScopeImpl2);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            ContentTransform contentTransform = (ContentTransform) objRememberedValue4;
            Transition transition2 = animatedContentTransitionScopeImpl2.transition;
            boolean zChanged2 = gapComposer.changed(animatedContentTransitionScopeImpl2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState = (MutableState) objRememberedValue5;
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(contentTransform.sizeTransform, gapComposer);
            if (Intrinsics.areEqual(transition2.transitionState.mo773getCurrentState(), transition2.targetState$delegate.getValue())) {
                mutableState.setValue(Boolean.FALSE);
            } else if (mutableStateRememberUpdatedState.getValue() != null) {
                mutableState.setValue(Boolean.TRUE);
            }
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Modifier modifier2 = Modifier.Companion.$$INSTANCE;
            if (zBooleanValue) {
                gapComposer.startReplaceGroup(1353077497);
                snapshotStateList = snapshotStateList3;
                gapComposer2 = gapComposer;
                animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl2;
                deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(animatedContentTransitionScopeImpl2.transition, ArcSplineKt.IntSizeToVector, null, gapComposer2, 0, 2);
                boolean zChanged3 = gapComposer2.changed(deferredAnimationCreateDeferredAnimation);
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChanged3 || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = ClipKt.clipToBounds(modifier2);
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                modifier2 = (Modifier) objRememberedValue6;
                gapComposer2.end(false);
            } else {
                snapshotStateList = snapshotStateList3;
                gapComposer2 = gapComposer;
                animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl2;
                gapComposer2.startReplaceGroup(1353343539);
                gapComposer2.end(false);
                deferredAnimationCreateDeferredAnimation = null;
            }
            Modifier modifierThen = modifier.then(modifier2.then(new AnimatedContentTransitionScopeImpl.SizeModifierElement(deferredAnimationCreateDeferredAnimation, mutableStateRememberUpdatedState, animatedContentTransitionScopeImpl)));
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) objRememberedValue7;
            long j = gapComposer2.compositeKeyHashCode;
            int i6 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, animatedContentMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m291initimpl(gapComposer2, Integer.valueOf(i6), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            gapComposer2.startReplaceGroup(-860173498);
            int size2 = snapshotStateList.size();
            int i7 = 0;
            while (i7 < size2) {
                SnapshotStateList snapshotStateList4 = snapshotStateList;
                Object obj2 = snapshotStateList4.get(i7);
                gapComposer2.startMovableGroup(-2026002954, function2.invoke(obj2));
                Function2 function5 = (Function2) mutableScatterMap.get(obj2);
                if (function5 == null) {
                    gapComposer2.startReplaceGroup(1618454323);
                    z = false;
                } else {
                    z = false;
                    gapComposer2.startReplaceGroup(-2026001778);
                    function5.invoke(gapComposer2, 0);
                }
                gapComposer2.end(z);
                gapComposer2.end(z);
                i7++;
                snapshotStateList = snapshotStateList4;
            }
            gapComposer2.end(false);
            gapComposer2.end(true);
        } else {
            function3 = function4;
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Function1 function6 = function3;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    ((Number) obj4).intValue();
                    AnimatedContentKt.AnimatedContent(transition, modifier, function6, alignment, function2, composableLambdaImpl, (GapComposer) obj3, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
