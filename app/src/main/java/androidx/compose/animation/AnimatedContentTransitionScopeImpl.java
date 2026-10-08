package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl implements Transition.Segment {
    public Alignment contentAlignment;
    public final ParcelableSnapshotMutableState measuredSize$delegate = Stack.mutableStateOf$default(new IntSize(0));
    public final MutableScatterMap targetSizeMap;
    public final Transition transition;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ChildData implements Modifier.Element {
        public final ParcelableSnapshotMutableState isTarget$delegate;

        public ChildData(boolean z) {
            this.isTarget$delegate = Stack.mutableStateOf$default(Boolean.valueOf(z));
        }

        @Override // androidx.compose.ui.Modifier
        public final boolean all(Function1 function1) {
            return ((Boolean) function1.invoke(this)).booleanValue();
        }

        @Override // androidx.compose.ui.Modifier
        public final Object foldIn(Object obj, Function2 function2) {
            return function2.invoke(obj, this);
        }

        @Override // androidx.compose.ui.Modifier
        public final /* synthetic */ Modifier then(Modifier modifier) {
            return Modifier.CC.$default$then(this, modifier);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    final class SizeModifierElement<S> extends ModifierNodeElement {
        public final AnimatedContentTransitionScopeImpl scope;
        public final Transition.DeferredAnimation sizeAnimation;
        public final MutableState sizeTransform;

        public SizeModifierElement(Transition.DeferredAnimation deferredAnimation, MutableState mutableState, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            this.sizeAnimation = deferredAnimation;
            this.sizeTransform = mutableState;
            this.scope = animatedContentTransitionScopeImpl;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final Modifier.Node create() {
            SizeModifierNode sizeModifierNode = new SizeModifierNode();
            sizeModifierNode.sizeAnimation = this.sizeAnimation;
            sizeModifierNode.sizeTransform = this.sizeTransform;
            sizeModifierNode.scope = this.scope;
            sizeModifierNode.lastSize = AnimatedContentKt.UnspecifiedSize;
            return sizeModifierNode;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SizeModifierElement)) {
                return false;
            }
            SizeModifierElement sizeModifierElement = (SizeModifierElement) obj;
            return Intrinsics.areEqual(sizeModifierElement.sizeAnimation, this.sizeAnimation) && sizeModifierElement.sizeTransform.equals(this.sizeTransform);
        }

        public final int hashCode() {
            int iHashCode = this.scope.hashCode() * 31;
            Transition.DeferredAnimation deferredAnimation = this.sizeAnimation;
            return this.sizeTransform.hashCode() + ((iHashCode + (deferredAnimation != null ? deferredAnimation.hashCode() : 0)) * 31);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final void update(Modifier.Node node) {
            SizeModifierNode sizeModifierNode = (SizeModifierNode) node;
            sizeModifierNode.sizeAnimation = this.sizeAnimation;
            sizeModifierNode.sizeTransform = this.sizeTransform;
            sizeModifierNode.scope = this.scope;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SizeModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
        public long lastSize;
        public AnimatedContentTransitionScopeImpl scope;
        public Transition.DeferredAnimation sizeAnimation;
        public MutableState sizeTransform;

        @Override // androidx.compose.ui.node.LayoutModifierNode
        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
            final long j2;
            final Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(j);
            if (measureScope.isLookingAhead()) {
                j2 = (((long) placeableMo517measureBRTryo0.width) << 32) | (((long) placeableMo517measureBRTryo0.height) & 4294967295L);
            } else {
                Transition.DeferredAnimation deferredAnimation = this.sizeAnimation;
                if (deferredAnimation == null) {
                    j2 = (((long) placeableMo517measureBRTryo0.width) << 32) | (((long) placeableMo517measureBRTryo0.height) & 4294967295L);
                    this.lastSize = j2;
                } else {
                    final long j3 = (((long) placeableMo517measureBRTryo0.height) & 4294967295L) | (((long) placeableMo517measureBRTryo0.width) << 32);
                    final int i = 0;
                    final int i2 = 1;
                    Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate = deferredAnimation.animate(new Function1(this) { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$size$1
                        public final /* synthetic */ AnimatedContentTransitionScopeImpl.SizeModifierNode this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.this$0 = this;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            long j4;
                            FiniteAnimationSpec finiteAnimationSpec;
                            long j5;
                            switch (i) {
                                case 0:
                                    Transition.Segment segment = (Transition.Segment) obj;
                                    Object initialState = segment.getInitialState();
                                    AnimatedContentTransitionScopeImpl.SizeModifierNode sizeModifierNode = this.this$0;
                                    if (Intrinsics.areEqual(initialState, sizeModifierNode.scope.getInitialState())) {
                                        j4 = IntSize.m720equalsimpl0(sizeModifierNode.lastSize, AnimatedContentKt.UnspecifiedSize) ? j3 : sizeModifierNode.lastSize;
                                    } else {
                                        State state = (State) sizeModifierNode.scope.targetSizeMap.get(segment.getInitialState());
                                        j4 = state != null ? ((IntSize) state.getValue()).packedValue : 0L;
                                    }
                                    State state2 = (State) sizeModifierNode.scope.targetSizeMap.get(segment.getTargetState());
                                    long j6 = state2 != null ? ((IntSize) state2.getValue()).packedValue : 0L;
                                    SizeTransformImpl sizeTransformImpl = (SizeTransformImpl) sizeModifierNode.sizeTransform.getValue();
                                    return (sizeTransformImpl == null || (finiteAnimationSpec = (FiniteAnimationSpec) sizeTransformImpl.sizeAnimationSpec.invoke(new IntSize(j4), new IntSize(j6))) == null) ? ArcSplineKt.spring$default(0.0f, 400.0f, null, 5) : finiteAnimationSpec;
                                default:
                                    AnimatedContentTransitionScopeImpl.SizeModifierNode sizeModifierNode2 = this.this$0;
                                    if (Intrinsics.areEqual(obj, sizeModifierNode2.scope.getInitialState())) {
                                        j5 = IntSize.m720equalsimpl0(sizeModifierNode2.lastSize, AnimatedContentKt.UnspecifiedSize) ? j3 : sizeModifierNode2.lastSize;
                                    } else {
                                        State state3 = (State) sizeModifierNode2.scope.targetSizeMap.get(obj);
                                        j5 = state3 != null ? ((IntSize) state3.getValue()).packedValue : 0L;
                                    }
                                    return new IntSize(j5);
                            }
                        }
                    }, new Function1(this) { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$size$1
                        public final /* synthetic */ AnimatedContentTransitionScopeImpl.SizeModifierNode this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.this$0 = this;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            long j4;
                            FiniteAnimationSpec finiteAnimationSpec;
                            long j5;
                            switch (i2) {
                                case 0:
                                    Transition.Segment segment = (Transition.Segment) obj;
                                    Object initialState = segment.getInitialState();
                                    AnimatedContentTransitionScopeImpl.SizeModifierNode sizeModifierNode = this.this$0;
                                    if (Intrinsics.areEqual(initialState, sizeModifierNode.scope.getInitialState())) {
                                        j4 = IntSize.m720equalsimpl0(sizeModifierNode.lastSize, AnimatedContentKt.UnspecifiedSize) ? j3 : sizeModifierNode.lastSize;
                                    } else {
                                        State state = (State) sizeModifierNode.scope.targetSizeMap.get(segment.getInitialState());
                                        j4 = state != null ? ((IntSize) state.getValue()).packedValue : 0L;
                                    }
                                    State state2 = (State) sizeModifierNode.scope.targetSizeMap.get(segment.getTargetState());
                                    long j6 = state2 != null ? ((IntSize) state2.getValue()).packedValue : 0L;
                                    SizeTransformImpl sizeTransformImpl = (SizeTransformImpl) sizeModifierNode.sizeTransform.getValue();
                                    return (sizeTransformImpl == null || (finiteAnimationSpec = (FiniteAnimationSpec) sizeTransformImpl.sizeAnimationSpec.invoke(new IntSize(j4), new IntSize(j6))) == null) ? ArcSplineKt.spring$default(0.0f, 400.0f, null, 5) : finiteAnimationSpec;
                                default:
                                    AnimatedContentTransitionScopeImpl.SizeModifierNode sizeModifierNode2 = this.this$0;
                                    if (Intrinsics.areEqual(obj, sizeModifierNode2.scope.getInitialState())) {
                                        j5 = IntSize.m720equalsimpl0(sizeModifierNode2.lastSize, AnimatedContentKt.UnspecifiedSize) ? j3 : sizeModifierNode2.lastSize;
                                    } else {
                                        State state3 = (State) sizeModifierNode2.scope.targetSizeMap.get(obj);
                                        j5 = state3 != null ? ((IntSize) state3.getValue()).packedValue : 0L;
                                    }
                                    return new IntSize(j5);
                            }
                        }
                    });
                    this.scope.getClass();
                    j2 = ((IntSize) deferredAnimationDataAnimate.getValue()).packedValue;
                    this.lastSize = ((IntSize) deferredAnimationDataAnimate.getValue()).packedValue;
                }
            }
            return measureScope.layout((int) (j2 >> 32), (int) (4294967295L & j2), EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Alignment alignment = this.this$0.scope.contentAlignment;
                    Placeable placeable = placeableMo517measureBRTryo0;
                    Placeable.PlacementScope.m536place70tqf50$default((Placeable.PlacementScope) obj, placeable, alignment.mo305alignKFBX0sM((((long) placeable.height) & 4294967295L) | (((long) placeable.width) << 32), j2, LayoutDirection.Ltr));
                    return Unit.INSTANCE;
                }
            });
        }

        @Override // androidx.compose.ui.Modifier.Node
        public final void onReset() {
            this.lastSize = AnimatedContentKt.UnspecifiedSize;
        }
    }

    public AnimatedContentTransitionScopeImpl(Transition transition, Alignment alignment) {
        this.transition = transition;
        this.contentAlignment = alignment;
        long[] jArr = ScatterMapKt.EmptyGroup;
        this.targetSizeMap = new MutableScatterMap();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final Object getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final Object getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final boolean isTransitioningTo(Enum r2, Enum r3) {
        return r2.equals(getInitialState()) && r3.equals(getTargetState());
    }
}
