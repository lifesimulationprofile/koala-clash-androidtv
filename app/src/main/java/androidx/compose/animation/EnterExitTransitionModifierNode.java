package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.draw.PainterNode$measure$1;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeDrawScope$record$1;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import coil.network.HttpException;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    public Alignment currentAlignment;
    public EnterTransitionImpl enter;
    public ExitTransitionImpl exit;
    public EnterExitTransitionKt$$ExternalSyntheticLambda0 graphicsLayerBlock;
    public Function0 isEnabled;
    public long lookaheadSize = AnimationModifierKt.InvalidSize;
    public Transition.DeferredAnimation offsetAnimation;
    public Transition.DeferredAnimation sizeAnimation;
    public final EnterExitTransitionModifierNode$slideSpec$1 sizeTransitionSpec;
    public Transition.DeferredAnimation slideAnimation;
    public final EnterExitTransitionModifierNode$slideSpec$1 slideSpec;
    public Transition transition;

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1] */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1] */
    public EnterExitTransitionModifierNode(Transition transition, Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition.DeferredAnimation deferredAnimation3, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, Function0 function0, EnterExitTransitionKt$$ExternalSyntheticLambda0 enterExitTransitionKt$$ExternalSyntheticLambda0) {
        this.transition = transition;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransitionImpl;
        this.exit = exitTransitionImpl;
        this.isEnabled = function0;
        this.graphicsLayerBlock = enterExitTransitionKt$$ExternalSyntheticLambda0;
        ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
        final int i = 1;
        this.sizeTransitionSpec = new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1
            public final /* synthetic */ EnterExitTransitionModifierNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                switch (i) {
                    case 0:
                        Transition.Segment segment = (Transition.Segment) obj;
                        EnterExitState enterExitState = EnterExitState.PreEnter;
                        EnterExitState enterExitState2 = EnterExitState.Visible;
                        boolean zIsTransitioningTo = segment.isTransitioningTo(enterExitState, enterExitState2);
                        EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.this$0;
                        if (zIsTransitioningTo) {
                            Slide slide = enterExitTransitionModifierNode.enter.data.slide;
                            return slide != null ? slide.animationSpec : EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                        }
                        if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                            return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                        }
                        Slide slide2 = enterExitTransitionModifierNode.exit.data.slide;
                        return slide2 != null ? slide2.animationSpec : EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                    default:
                        Transition.Segment segment2 = (Transition.Segment) obj;
                        EnterExitState enterExitState3 = EnterExitState.PreEnter;
                        EnterExitState enterExitState4 = EnterExitState.Visible;
                        boolean zIsTransitioningTo2 = segment2.isTransitioningTo(enterExitState3, enterExitState4);
                        Object obj2 = null;
                        EnterExitTransitionModifierNode enterExitTransitionModifierNode2 = this.this$0;
                        if (zIsTransitioningTo2) {
                            ChangeSize changeSize = enterExitTransitionModifierNode2.enter.data.changeSize;
                            if (changeSize != null) {
                                obj2 = changeSize.animationSpec;
                            }
                        } else if (segment2.isTransitioningTo(enterExitState4, EnterExitState.PostExit)) {
                            ChangeSize changeSize2 = enterExitTransitionModifierNode2.exit.data.changeSize;
                            if (changeSize2 != null) {
                                obj2 = changeSize2.animationSpec;
                            }
                        } else {
                            obj2 = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                        }
                        return obj2 == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : obj2;
                }
            }
        };
        final int i2 = 0;
        this.slideSpec = new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1
            public final /* synthetic */ EnterExitTransitionModifierNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                switch (i2) {
                    case 0:
                        Transition.Segment segment = (Transition.Segment) obj;
                        EnterExitState enterExitState = EnterExitState.PreEnter;
                        EnterExitState enterExitState2 = EnterExitState.Visible;
                        boolean zIsTransitioningTo = segment.isTransitioningTo(enterExitState, enterExitState2);
                        EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.this$0;
                        if (zIsTransitioningTo) {
                            Slide slide = enterExitTransitionModifierNode.enter.data.slide;
                            return slide != null ? slide.animationSpec : EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                        }
                        if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                            return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                        }
                        Slide slide2 = enterExitTransitionModifierNode.exit.data.slide;
                        return slide2 != null ? slide2.animationSpec : EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                    default:
                        Transition.Segment segment2 = (Transition.Segment) obj;
                        EnterExitState enterExitState3 = EnterExitState.PreEnter;
                        EnterExitState enterExitState4 = EnterExitState.Visible;
                        boolean zIsTransitioningTo2 = segment2.isTransitioningTo(enterExitState3, enterExitState4);
                        Object obj2 = null;
                        EnterExitTransitionModifierNode enterExitTransitionModifierNode2 = this.this$0;
                        if (zIsTransitioningTo2) {
                            ChangeSize changeSize = enterExitTransitionModifierNode2.enter.data.changeSize;
                            if (changeSize != null) {
                                obj2 = changeSize.animationSpec;
                            }
                        } else if (segment2.isTransitioningTo(enterExitState4, EnterExitState.PostExit)) {
                            ChangeSize changeSize2 = enterExitTransitionModifierNode2.exit.data.changeSize;
                            if (changeSize2 != null) {
                                obj2 = changeSize2.animationSpec;
                            }
                        } else {
                            obj2 = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                        }
                        return obj2 == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : obj2;
                }
            }
        };
    }

    public final Alignment getAlignment() {
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            ChangeSize changeSize = this.enter.data.changeSize;
            if (changeSize != null) {
                return changeSize.alignment;
            }
            ChangeSize changeSize2 = this.exit.data.changeSize;
            if (changeSize2 != null) {
                return changeSize2.alignment;
            }
            return null;
        }
        ChangeSize changeSize3 = this.exit.data.changeSize;
        if (changeSize3 != null) {
            return changeSize3.alignment;
        }
        ChangeSize changeSize4 = this.enter.data.changeSize;
        if (changeSize4 != null) {
            return changeSize4.alignment;
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate;
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate2;
        long j2;
        long j3;
        long j4;
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate3 = null;
        if (this.transition.transitionState.mo773getCurrentState() == this.transition.targetState$delegate.getValue()) {
            this.currentAlignment = null;
        } else if (this.currentAlignment == null) {
            Alignment alignment = getAlignment();
            if (alignment == null) {
                alignment = Alignment.Companion.TopStart;
            }
            this.currentAlignment = alignment;
        }
        boolean zIsLookingAhead = measureScope.isLookingAhead();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (zIsLookingAhead) {
            Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(j);
            long j5 = (((long) placeableMo517measureBRTryo0.width) << 32) | (((long) placeableMo517measureBRTryo0.height) & 4294967295L);
            this.lookaheadSize = j5;
            return measureScope.layout((int) (j5 >> 32), (int) (4294967295L & j5), emptyMap, new PainterNode$measure$1(placeableMo517measureBRTryo0, 2));
        }
        if (!((Boolean) this.isEnabled.invoke()).booleanValue()) {
            Placeable placeableMo517measureBRTryo1 = measurable.mo517measureBRTryo0(j);
            return measureScope.layout(placeableMo517measureBRTryo1.width, placeableMo517measureBRTryo1.height, emptyMap, new PainterNode$measure$1(placeableMo517measureBRTryo1, 3));
        }
        EnterExitTransitionKt$$ExternalSyntheticLambda0 enterExitTransitionKt$$ExternalSyntheticLambda0 = this.graphicsLayerBlock;
        Transition.DeferredAnimation deferredAnimation = enterExitTransitionKt$$ExternalSyntheticLambda0.f$0;
        Transition.DeferredAnimation deferredAnimation2 = enterExitTransitionKt$$ExternalSyntheticLambda0.f$1;
        Transition transition = enterExitTransitionKt$$ExternalSyntheticLambda0.f$2;
        final EnterTransitionImpl enterTransitionImpl = enterExitTransitionKt$$ExternalSyntheticLambda0.f$3;
        final ExitTransitionImpl exitTransitionImpl = enterExitTransitionKt$$ExternalSyntheticLambda0.f$4;
        Transition.DeferredAnimation deferredAnimation3 = enterExitTransitionKt$$ExternalSyntheticLambda0.f$5;
        if (deferredAnimation != null) {
            final int i = 0;
            final int i2 = 1;
            deferredAnimationDataAnimate = deferredAnimation.animate(new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Code duplicated, block: B:32:0x0060  */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FiniteAnimationSpec finiteAnimationSpec;
                    FiniteAnimationSpec finiteAnimationSpec2;
                    switch (i) {
                        case 0:
                            Transition.Segment segment = (Transition.Segment) obj;
                            EnterExitState enterExitState = EnterExitState.PreEnter;
                            EnterExitState enterExitState2 = EnterExitState.Visible;
                            if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                                Fade fade = enterTransitionImpl.data.fade;
                                return (fade == null || (finiteAnimationSpec2 = fade.animationSpec) == null) ? EnterExitTransitionKt.DefaultAlphaAndScaleSpring : finiteAnimationSpec2;
                            }
                            if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            Fade fade2 = exitTransitionImpl.data.fade;
                            return (fade2 == null || (finiteAnimationSpec = fade2.animationSpec) == null) ? EnterExitTransitionKt.DefaultAlphaAndScaleSpring : finiteAnimationSpec;
                        case 1:
                            int iOrdinal = ((EnterExitState) obj).ordinal();
                            float f = 0.0f;
                            if (iOrdinal != 0) {
                                if (iOrdinal == 1) {
                                    f = 1.0f;
                                } else {
                                    if (iOrdinal != 2) {
                                        throw new HttpException();
                                    }
                                    if (exitTransitionImpl.data.fade == null) {
                                        f = 1.0f;
                                    }
                                }
                            } else if (enterTransitionImpl.data.fade == null) {
                                f = 1.0f;
                            }
                            return Float.valueOf(f);
                        case 2:
                            Transition.Segment segment2 = (Transition.Segment) obj;
                            EnterExitState enterExitState3 = EnterExitState.PreEnter;
                            EnterExitState enterExitState4 = EnterExitState.Visible;
                            if (segment2.isTransitioningTo(enterExitState3, enterExitState4)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            if (!segment2.isTransitioningTo(enterExitState4, EnterExitState.PostExit)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            TransitionData transitionData = exitTransitionImpl.data;
                            return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        default:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            if (iOrdinal2 != 0 && iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    throw new HttpException();
                                }
                                TransitionData transitionData2 = exitTransitionImpl.data;
                            }
                            return Float.valueOf(1.0f);
                    }
                }
            }, new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Code duplicated, block: B:32:0x0060  */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FiniteAnimationSpec finiteAnimationSpec;
                    FiniteAnimationSpec finiteAnimationSpec2;
                    switch (i2) {
                        case 0:
                            Transition.Segment segment = (Transition.Segment) obj;
                            EnterExitState enterExitState = EnterExitState.PreEnter;
                            EnterExitState enterExitState2 = EnterExitState.Visible;
                            if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                                Fade fade = enterTransitionImpl.data.fade;
                                return (fade == null || (finiteAnimationSpec2 = fade.animationSpec) == null) ? EnterExitTransitionKt.DefaultAlphaAndScaleSpring : finiteAnimationSpec2;
                            }
                            if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            Fade fade2 = exitTransitionImpl.data.fade;
                            return (fade2 == null || (finiteAnimationSpec = fade2.animationSpec) == null) ? EnterExitTransitionKt.DefaultAlphaAndScaleSpring : finiteAnimationSpec;
                        case 1:
                            int iOrdinal = ((EnterExitState) obj).ordinal();
                            float f = 0.0f;
                            if (iOrdinal != 0) {
                                if (iOrdinal == 1) {
                                    f = 1.0f;
                                } else {
                                    if (iOrdinal != 2) {
                                        throw new HttpException();
                                    }
                                    if (exitTransitionImpl.data.fade == null) {
                                        f = 1.0f;
                                    }
                                }
                            } else if (enterTransitionImpl.data.fade == null) {
                                f = 1.0f;
                            }
                            return Float.valueOf(f);
                        case 2:
                            Transition.Segment segment2 = (Transition.Segment) obj;
                            EnterExitState enterExitState3 = EnterExitState.PreEnter;
                            EnterExitState enterExitState4 = EnterExitState.Visible;
                            if (segment2.isTransitioningTo(enterExitState3, enterExitState4)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            if (!segment2.isTransitioningTo(enterExitState4, EnterExitState.PostExit)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            TransitionData transitionData = exitTransitionImpl.data;
                            return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        default:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            if (iOrdinal2 != 0 && iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    throw new HttpException();
                                }
                                TransitionData transitionData2 = exitTransitionImpl.data;
                            }
                            return Float.valueOf(1.0f);
                    }
                }
            });
        } else {
            deferredAnimationDataAnimate = null;
        }
        if (deferredAnimation2 != null) {
            final int i3 = 2;
            final int i4 = 3;
            deferredAnimationDataAnimate2 = deferredAnimation2.animate(new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Code duplicated, block: B:32:0x0060  */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FiniteAnimationSpec finiteAnimationSpec;
                    FiniteAnimationSpec finiteAnimationSpec2;
                    switch (i3) {
                        case 0:
                            Transition.Segment segment = (Transition.Segment) obj;
                            EnterExitState enterExitState = EnterExitState.PreEnter;
                            EnterExitState enterExitState2 = EnterExitState.Visible;
                            if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                                Fade fade = enterTransitionImpl.data.fade;
                                return (fade == null || (finiteAnimationSpec2 = fade.animationSpec) == null) ? EnterExitTransitionKt.DefaultAlphaAndScaleSpring : finiteAnimationSpec2;
                            }
                            if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            Fade fade2 = exitTransitionImpl.data.fade;
                            return (fade2 == null || (finiteAnimationSpec = fade2.animationSpec) == null) ? EnterExitTransitionKt.DefaultAlphaAndScaleSpring : finiteAnimationSpec;
                        case 1:
                            int iOrdinal = ((EnterExitState) obj).ordinal();
                            float f = 0.0f;
                            if (iOrdinal != 0) {
                                if (iOrdinal == 1) {
                                    f = 1.0f;
                                } else {
                                    if (iOrdinal != 2) {
                                        throw new HttpException();
                                    }
                                    if (exitTransitionImpl.data.fade == null) {
                                        f = 1.0f;
                                    }
                                }
                            } else if (enterTransitionImpl.data.fade == null) {
                                f = 1.0f;
                            }
                            return Float.valueOf(f);
                        case 2:
                            Transition.Segment segment2 = (Transition.Segment) obj;
                            EnterExitState enterExitState3 = EnterExitState.PreEnter;
                            EnterExitState enterExitState4 = EnterExitState.Visible;
                            if (segment2.isTransitioningTo(enterExitState3, enterExitState4)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            if (!segment2.isTransitioningTo(enterExitState4, EnterExitState.PostExit)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            TransitionData transitionData = exitTransitionImpl.data;
                            return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        default:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            if (iOrdinal2 != 0 && iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    throw new HttpException();
                                }
                                TransitionData transitionData2 = exitTransitionImpl.data;
                            }
                            return Float.valueOf(1.0f);
                    }
                }
            }, new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Code duplicated, block: B:32:0x0060  */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    FiniteAnimationSpec finiteAnimationSpec;
                    FiniteAnimationSpec finiteAnimationSpec2;
                    switch (i4) {
                        case 0:
                            Transition.Segment segment = (Transition.Segment) obj;
                            EnterExitState enterExitState = EnterExitState.PreEnter;
                            EnterExitState enterExitState2 = EnterExitState.Visible;
                            if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                                Fade fade = enterTransitionImpl.data.fade;
                                return (fade == null || (finiteAnimationSpec2 = fade.animationSpec) == null) ? EnterExitTransitionKt.DefaultAlphaAndScaleSpring : finiteAnimationSpec2;
                            }
                            if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            Fade fade2 = exitTransitionImpl.data.fade;
                            return (fade2 == null || (finiteAnimationSpec = fade2.animationSpec) == null) ? EnterExitTransitionKt.DefaultAlphaAndScaleSpring : finiteAnimationSpec;
                        case 1:
                            int iOrdinal = ((EnterExitState) obj).ordinal();
                            float f = 0.0f;
                            if (iOrdinal != 0) {
                                if (iOrdinal == 1) {
                                    f = 1.0f;
                                } else {
                                    if (iOrdinal != 2) {
                                        throw new HttpException();
                                    }
                                    if (exitTransitionImpl.data.fade == null) {
                                        f = 1.0f;
                                    }
                                }
                            } else if (enterTransitionImpl.data.fade == null) {
                                f = 1.0f;
                            }
                            return Float.valueOf(f);
                        case 2:
                            Transition.Segment segment2 = (Transition.Segment) obj;
                            EnterExitState enterExitState3 = EnterExitState.PreEnter;
                            EnterExitState enterExitState4 = EnterExitState.Visible;
                            if (segment2.isTransitioningTo(enterExitState3, enterExitState4)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            if (!segment2.isTransitioningTo(enterExitState4, EnterExitState.PostExit)) {
                                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            }
                            TransitionData transitionData = exitTransitionImpl.data;
                            return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        default:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            if (iOrdinal2 != 0 && iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    throw new HttpException();
                                }
                                TransitionData transitionData2 = exitTransitionImpl.data;
                            }
                            return Float.valueOf(1.0f);
                    }
                }
            });
        } else {
            deferredAnimationDataAnimate2 = null;
        }
        if (transition.transitionState.mo773getCurrentState() == EnterExitState.PreEnter) {
            TransitionData transitionData = exitTransitionImpl.data;
        } else {
            TransitionData transitionData2 = exitTransitionImpl.data;
        }
        final LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1 = new LayoutNodeDrawScope$record$1(deferredAnimationDataAnimate, deferredAnimationDataAnimate2, deferredAnimation3 != null ? deferredAnimation3.animate(CrossfadeKt$Crossfade$3$1.INSTANCE$6, new LayoutNodeDrawScope$record$1(deferredAnimationDataAnimate3, enterTransitionImpl, exitTransitionImpl, 3)) : null, 2);
        final Placeable placeableMo517measureBRTryo2 = measurable.mo517measureBRTryo0(j);
        long j6 = (((long) placeableMo517measureBRTryo2.height) & 4294967295L) | (((long) placeableMo517measureBRTryo2.width) << 32);
        final long j7 = !IntSize.m720equalsimpl0(this.lookaheadSize, AnimationModifierKt.InvalidSize) ? this.lookaheadSize : j6;
        Transition.DeferredAnimation deferredAnimation4 = this.sizeAnimation;
        if (deferredAnimation4 != null) {
            final int i5 = 0;
            deferredAnimationDataAnimate3 = deferredAnimation4.animate(this.sizeTransitionSpec, new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$animSize$1
                public final /* synthetic */ EnterExitTransitionModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
                /* JADX WARN: Type inference failed for: r0v15, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v14, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v24, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r1v15, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long jM713minusqkQi6aY;
                    int iOrdinal;
                    switch (i5) {
                        case 0:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.this$0;
                            long j8 = j7;
                            if (iOrdinal2 == 0) {
                                ChangeSize changeSize = enterExitTransitionModifierNode.enter.data.changeSize;
                                if (changeSize != null) {
                                    j8 = ((IntSize) changeSize.size.invoke(new IntSize(j8))).packedValue;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    throw new HttpException();
                                }
                                ChangeSize changeSize2 = enterExitTransitionModifierNode.exit.data.changeSize;
                                if (changeSize2 != null) {
                                    j8 = ((IntSize) changeSize2.size.invoke(new IntSize(j8))).packedValue;
                                }
                            }
                            return new IntSize(j8);
                        case 1:
                            EnterExitState enterExitState = (EnterExitState) obj;
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode2 = this.this$0;
                            if (enterExitTransitionModifierNode2.currentAlignment == null || enterExitTransitionModifierNode2.getAlignment() == null || Intrinsics.areEqual(enterExitTransitionModifierNode2.currentAlignment, enterExitTransitionModifierNode2.getAlignment()) || (iOrdinal = enterExitState.ordinal()) == 0 || iOrdinal == 1) {
                                jM713minusqkQi6aY = 0;
                            } else {
                                if (iOrdinal != 2) {
                                    throw new HttpException();
                                }
                                ChangeSize changeSize3 = enterExitTransitionModifierNode2.exit.data.changeSize;
                                if (changeSize3 != null) {
                                    ?? r11 = changeSize3.size;
                                    long j9 = j7;
                                    long j10 = ((IntSize) r11.invoke(new IntSize(j9))).packedValue;
                                    BiasAlignment biasAlignment = (BiasAlignment) enterExitTransitionModifierNode2.getAlignment();
                                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                                    jM713minusqkQi6aY = IntOffset.m713minusqkQi6aY(biasAlignment.mo305alignKFBX0sM(j9, j10, layoutDirection), enterExitTransitionModifierNode2.currentAlignment.mo305alignKFBX0sM(j9, j10, layoutDirection));
                                } else {
                                    jM713minusqkQi6aY = 0;
                                }
                            }
                            return new IntOffset(jM713minusqkQi6aY);
                        default:
                            EnterExitState enterExitState2 = (EnterExitState) obj;
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode3 = this.this$0;
                            Slide slide = enterExitTransitionModifierNode3.enter.data.slide;
                            long j11 = j7;
                            long j12 = 0;
                            long j13 = slide != null ? ((IntOffset) slide.slideOffset.invoke(new IntSize(j11))).packedValue : 0L;
                            Slide slide2 = enterExitTransitionModifierNode3.exit.data.slide;
                            long j14 = slide2 != null ? ((IntOffset) slide2.slideOffset.invoke(new IntSize(j11))).packedValue : 0L;
                            int iOrdinal3 = enterExitState2.ordinal();
                            if (iOrdinal3 == 0) {
                                j12 = j13;
                            } else if (iOrdinal3 != 1) {
                                if (iOrdinal3 != 2) {
                                    throw new HttpException();
                                }
                                j12 = j14;
                            }
                            return new IntOffset(j12);
                    }
                }
            });
        }
        if (deferredAnimationDataAnimate3 != null) {
            j6 = ((IntSize) deferredAnimationDataAnimate3.getValue()).packedValue;
        }
        long jM689constrain4WqzIAM = ConstraintsKt.m689constrain4WqzIAM(j, j6);
        Transition.DeferredAnimation deferredAnimation5 = this.offsetAnimation;
        long jMo305alignKFBX0sM = 0;
        if (deferredAnimation5 != null) {
            final int i6 = 1;
            j2 = ((IntOffset) deferredAnimation5.animate(CrossfadeKt$Crossfade$3$1.INSTANCE$7, new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$animSize$1
                public final /* synthetic */ EnterExitTransitionModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
                /* JADX WARN: Type inference failed for: r0v15, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v14, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v24, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r1v15, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long jM713minusqkQi6aY;
                    int iOrdinal;
                    switch (i6) {
                        case 0:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.this$0;
                            long j8 = j7;
                            if (iOrdinal2 == 0) {
                                ChangeSize changeSize = enterExitTransitionModifierNode.enter.data.changeSize;
                                if (changeSize != null) {
                                    j8 = ((IntSize) changeSize.size.invoke(new IntSize(j8))).packedValue;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    throw new HttpException();
                                }
                                ChangeSize changeSize2 = enterExitTransitionModifierNode.exit.data.changeSize;
                                if (changeSize2 != null) {
                                    j8 = ((IntSize) changeSize2.size.invoke(new IntSize(j8))).packedValue;
                                }
                            }
                            return new IntSize(j8);
                        case 1:
                            EnterExitState enterExitState = (EnterExitState) obj;
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode2 = this.this$0;
                            if (enterExitTransitionModifierNode2.currentAlignment == null || enterExitTransitionModifierNode2.getAlignment() == null || Intrinsics.areEqual(enterExitTransitionModifierNode2.currentAlignment, enterExitTransitionModifierNode2.getAlignment()) || (iOrdinal = enterExitState.ordinal()) == 0 || iOrdinal == 1) {
                                jM713minusqkQi6aY = 0;
                            } else {
                                if (iOrdinal != 2) {
                                    throw new HttpException();
                                }
                                ChangeSize changeSize3 = enterExitTransitionModifierNode2.exit.data.changeSize;
                                if (changeSize3 != null) {
                                    ?? r11 = changeSize3.size;
                                    long j9 = j7;
                                    long j10 = ((IntSize) r11.invoke(new IntSize(j9))).packedValue;
                                    BiasAlignment biasAlignment = (BiasAlignment) enterExitTransitionModifierNode2.getAlignment();
                                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                                    jM713minusqkQi6aY = IntOffset.m713minusqkQi6aY(biasAlignment.mo305alignKFBX0sM(j9, j10, layoutDirection), enterExitTransitionModifierNode2.currentAlignment.mo305alignKFBX0sM(j9, j10, layoutDirection));
                                } else {
                                    jM713minusqkQi6aY = 0;
                                }
                            }
                            return new IntOffset(jM713minusqkQi6aY);
                        default:
                            EnterExitState enterExitState2 = (EnterExitState) obj;
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode3 = this.this$0;
                            Slide slide = enterExitTransitionModifierNode3.enter.data.slide;
                            long j11 = j7;
                            long j12 = 0;
                            long j13 = slide != null ? ((IntOffset) slide.slideOffset.invoke(new IntSize(j11))).packedValue : 0L;
                            Slide slide2 = enterExitTransitionModifierNode3.exit.data.slide;
                            long j14 = slide2 != null ? ((IntOffset) slide2.slideOffset.invoke(new IntSize(j11))).packedValue : 0L;
                            int iOrdinal3 = enterExitState2.ordinal();
                            if (iOrdinal3 == 0) {
                                j12 = j13;
                            } else if (iOrdinal3 != 1) {
                                if (iOrdinal3 != 2) {
                                    throw new HttpException();
                                }
                                j12 = j14;
                            }
                            return new IntOffset(j12);
                    }
                }
            }).getValue()).packedValue;
        } else {
            j2 = 0;
        }
        Transition.DeferredAnimation deferredAnimation6 = this.slideAnimation;
        if (deferredAnimation6 != null) {
            final int i7 = 2;
            j3 = ((IntOffset) deferredAnimation6.animate(this.slideSpec, new Function1(this) { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$animSize$1
                public final /* synthetic */ EnterExitTransitionModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
                /* JADX WARN: Type inference failed for: r0v15, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v14, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v24, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r1v15, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long jM713minusqkQi6aY;
                    int iOrdinal;
                    switch (i7) {
                        case 0:
                            int iOrdinal2 = ((EnterExitState) obj).ordinal();
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode = this.this$0;
                            long j8 = j7;
                            if (iOrdinal2 == 0) {
                                ChangeSize changeSize = enterExitTransitionModifierNode.enter.data.changeSize;
                                if (changeSize != null) {
                                    j8 = ((IntSize) changeSize.size.invoke(new IntSize(j8))).packedValue;
                                }
                            } else if (iOrdinal2 != 1) {
                                if (iOrdinal2 != 2) {
                                    throw new HttpException();
                                }
                                ChangeSize changeSize2 = enterExitTransitionModifierNode.exit.data.changeSize;
                                if (changeSize2 != null) {
                                    j8 = ((IntSize) changeSize2.size.invoke(new IntSize(j8))).packedValue;
                                }
                            }
                            return new IntSize(j8);
                        case 1:
                            EnterExitState enterExitState = (EnterExitState) obj;
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode2 = this.this$0;
                            if (enterExitTransitionModifierNode2.currentAlignment == null || enterExitTransitionModifierNode2.getAlignment() == null || Intrinsics.areEqual(enterExitTransitionModifierNode2.currentAlignment, enterExitTransitionModifierNode2.getAlignment()) || (iOrdinal = enterExitState.ordinal()) == 0 || iOrdinal == 1) {
                                jM713minusqkQi6aY = 0;
                            } else {
                                if (iOrdinal != 2) {
                                    throw new HttpException();
                                }
                                ChangeSize changeSize3 = enterExitTransitionModifierNode2.exit.data.changeSize;
                                if (changeSize3 != null) {
                                    ?? r11 = changeSize3.size;
                                    long j9 = j7;
                                    long j10 = ((IntSize) r11.invoke(new IntSize(j9))).packedValue;
                                    BiasAlignment biasAlignment = (BiasAlignment) enterExitTransitionModifierNode2.getAlignment();
                                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                                    jM713minusqkQi6aY = IntOffset.m713minusqkQi6aY(biasAlignment.mo305alignKFBX0sM(j9, j10, layoutDirection), enterExitTransitionModifierNode2.currentAlignment.mo305alignKFBX0sM(j9, j10, layoutDirection));
                                } else {
                                    jM713minusqkQi6aY = 0;
                                }
                            }
                            return new IntOffset(jM713minusqkQi6aY);
                        default:
                            EnterExitState enterExitState2 = (EnterExitState) obj;
                            EnterExitTransitionModifierNode enterExitTransitionModifierNode3 = this.this$0;
                            Slide slide = enterExitTransitionModifierNode3.enter.data.slide;
                            long j11 = j7;
                            long j12 = 0;
                            long j13 = slide != null ? ((IntOffset) slide.slideOffset.invoke(new IntSize(j11))).packedValue : 0L;
                            Slide slide2 = enterExitTransitionModifierNode3.exit.data.slide;
                            long j14 = slide2 != null ? ((IntOffset) slide2.slideOffset.invoke(new IntSize(j11))).packedValue : 0L;
                            int iOrdinal3 = enterExitState2.ordinal();
                            if (iOrdinal3 == 0) {
                                j12 = j13;
                            } else if (iOrdinal3 != 1) {
                                if (iOrdinal3 != 2) {
                                    throw new HttpException();
                                }
                                j12 = j14;
                            }
                            return new IntOffset(j12);
                    }
                }
            }).getValue()).packedValue;
        } else {
            j3 = 0;
        }
        Alignment alignment2 = this.currentAlignment;
        if (alignment2 != null) {
            long j8 = j7;
            j4 = j3;
            jMo305alignKFBX0sM = alignment2.mo305alignKFBX0sM(j8, jM689constrain4WqzIAM, LayoutDirection.Ltr);
        } else {
            j4 = j3;
        }
        final long jM714plusqkQi6aY = IntOffset.m714plusqkQi6aY(jMo305alignKFBX0sM, j4);
        final long j9 = j2;
        return measureScope.layout((int) (jM689constrain4WqzIAM >> 32), (int) (jM689constrain4WqzIAM & 4294967295L), emptyMap, new Function1() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                long j10 = jM714plusqkQi6aY;
                long j11 = j9;
                placementScope.getClass();
                long j12 = (((long) (((int) (j10 >> 32)) + ((int) (j11 >> 32)))) << 32) | (((long) (((int) (j10 & 4294967295L)) + ((int) (j11 & 4294967295L)))) & 4294967295L);
                Placeable placeable = placeableMo517measureBRTryo2;
                Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j12, placeable.apparentToRealOffset), 0.0f, layoutNodeDrawScope$record$1);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.lookaheadSize = AnimationModifierKt.InvalidSize;
    }
}
