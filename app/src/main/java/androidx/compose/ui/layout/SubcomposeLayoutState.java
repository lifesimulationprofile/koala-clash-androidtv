package androidx.compose.ui.layout;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import com.github.kr328.clash.log.LogcatReader$$ExternalSyntheticLambda3;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SubcomposeLayoutState {
    public LayoutNodeSubcompositionsState _state;
    public final SubcomposeLayoutState$setRoot$1 setCompositionContext;
    public final SubcomposeLayoutState$setRoot$1 setMeasurePolicy;
    public final SubcomposeLayoutState$setRoot$1 setRoot;
    public final SubcomposeSlotReusePolicy slotReusePolicy;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface PrecomposedSlotHandle {
        void dispose();

        int getPlaceablesCount();

        /* JADX INFO: renamed from: premeasure-0kLqBqw */
        void mo532premeasure0kLqBqw(int i, long j);

        void traverseDescendants(LogcatReader$$ExternalSyntheticLambda3 logcatReader$$ExternalSyntheticLambda3);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1] */
    public SubcomposeLayoutState(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.slotReusePolicy = subcomposeSlotReusePolicy;
        final int i = 0;
        this.setRoot = new Function2(this) { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            public final /* synthetic */ SubcomposeLayoutState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        LayoutNode layoutNode = (LayoutNode) obj;
                        SubcomposeLayoutState subcomposeLayoutState = this.this$0;
                        SubcomposeSlotReusePolicy subcomposeSlotReusePolicy2 = subcomposeLayoutState.slotReusePolicy;
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
                        if (layoutNodeSubcompositionsState == null) {
                            layoutNodeSubcompositionsState = new LayoutNodeSubcompositionsState(layoutNode, subcomposeSlotReusePolicy2);
                            layoutNode.subcompositionsState = layoutNodeSubcompositionsState;
                        }
                        subcomposeLayoutState._state = layoutNodeSubcompositionsState;
                        subcomposeLayoutState.getState().makeSureStateIsConsistent();
                        LayoutNodeSubcompositionsState state = subcomposeLayoutState.getState();
                        if (state.slotReusePolicy != subcomposeSlotReusePolicy2) {
                            state.slotReusePolicy = subcomposeSlotReusePolicy2;
                            state.markActiveNodesAsReused(false);
                            LayoutNode.requestRemeasure$ui$default(state.root, false, 7);
                        }
                        break;
                    case 1:
                        this.this$0.getState().compositionContext = (CompositionContext) obj2;
                        break;
                    default:
                        final Function2 function2 = (Function2) obj2;
                        final LayoutNodeSubcompositionsState state2 = this.this$0.getState();
                        ((LayoutNode) obj).setMeasurePolicy(new LayoutNode.NoIntrinsicsMeasurePolicy(state2.NoIntrinsicsMessage) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
                                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = state2;
                                LayoutNodeSubcompositionsState.Scope scope = layoutNodeSubcompositionsState2.scope;
                                scope.layoutDirection = measureScope.getLayoutDirection();
                                scope.density = measureScope.getDensity();
                                scope.fontScale = measureScope.getFontScale();
                                boolean zIsLookingAhead = measureScope.isLookingAhead();
                                Function2 function3 = function2;
                                if (zIsLookingAhead || layoutNodeSubcompositionsState2.root.lookaheadRoot == null) {
                                    layoutNodeSubcompositionsState2.currentIndex = 0;
                                    final MeasureResult measureResult = (MeasureResult) function3.invoke(scope, new Constraints(j));
                                    final int i2 = layoutNodeSubcompositionsState2.currentIndex;
                                    final int i3 = 1;
                                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Map getAlignmentLines() {
                                            switch (i3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getAlignmentLines();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getHeight() {
                                            switch (i3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getHeight();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 getRulers() {
                                            switch (i3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulers();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getWidth() {
                                            switch (i3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getWidth();
                                        }

                                        /* JADX WARN: Code duplicated, block: B:31:0x0098 A[DONT_INVERT] */
                                        /* JADX WARN: Code duplicated, block: B:32:0x009a A[LOOP:0: B:11:0x0035->B:32:0x009a, LOOP_END] */
                                        /* JADX WARN: Code duplicated, block: B:36:0x009d A[SYNTHETIC] */
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final void placeChildren() {
                                            int i4;
                                            switch (i3) {
                                                case 0:
                                                    int i5 = i2;
                                                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                                    layoutNodeSubcompositionsState3.currentApproachIndex = i5;
                                                    measureResult.placeChildren();
                                                    MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                    MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                    long[] jArr = mutableScatterMap.metadata;
                                                    int length = jArr.length - 2;
                                                    if (length >= 0) {
                                                        int i6 = 0;
                                                        while (true) {
                                                            long j2 = jArr[i6];
                                                            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i7 = 8;
                                                                int i8 = 8 - ((~(i6 - length)) >>> 31);
                                                                int i9 = 0;
                                                                while (i9 < i8) {
                                                                    if ((255 & j2) < 128) {
                                                                        int i10 = (i6 << 3) + i9;
                                                                        Object obj3 = mutableScatterMap.keys[i10];
                                                                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i10];
                                                                        int iIndexOf = mutableVector.indexOf(obj3);
                                                                        i4 = i7;
                                                                        if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                            if (iIndexOf >= 0) {
                                                                                Object[] objArr = mutableVector.content;
                                                                                Object obj4 = objArr[iIndexOf];
                                                                                objArr[iIndexOf] = RulerKt.UnspecifiedSlotId;
                                                                            }
                                                                            if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                                precomposedSlotHandle.dispose();
                                                                            }
                                                                            mutableScatterMap.removeValueAt(i10);
                                                                        }
                                                                    } else {
                                                                        i4 = i7;
                                                                    }
                                                                    j2 >>= i4;
                                                                    i9++;
                                                                    i7 = i4;
                                                                }
                                                                if (i8 == i7) {
                                                                    if (i6 != length) {
                                                                        i6++;
                                                                    }
                                                                }
                                                            } else if (i6 != length) {
                                                                i6++;
                                                            }
                                                        }
                                                    }
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    break;
                                                default:
                                                    int i11 = i2;
                                                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState4 = layoutNodeSubcompositionsState2;
                                                    layoutNodeSubcompositionsState4.currentIndex = i11;
                                                    measureResult.placeChildren();
                                                    if (layoutNodeSubcompositionsState4.root.lookaheadRoot == null) {
                                                        layoutNodeSubcompositionsState4.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState4.currentIndex);
                                                    }
                                                    break;
                                            }
                                        }
                                    };
                                }
                                layoutNodeSubcompositionsState2.currentApproachIndex = 0;
                                final MeasureResult measureResult2 = (MeasureResult) function3.invoke(layoutNodeSubcompositionsState2.approachMeasureScope, new Constraints(j));
                                final int i4 = layoutNodeSubcompositionsState2.currentApproachIndex;
                                final int i5 = 0;
                                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Map getAlignmentLines() {
                                        switch (i5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getAlignmentLines();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getHeight() {
                                        switch (i5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getHeight();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 getRulers() {
                                        switch (i5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulers();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getWidth() {
                                        switch (i5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getWidth();
                                    }

                                    /* JADX WARN: Code duplicated, block: B:31:0x0098 A[DONT_INVERT] */
                                    /* JADX WARN: Code duplicated, block: B:32:0x009a A[LOOP:0: B:11:0x0035->B:32:0x009a, LOOP_END] */
                                    /* JADX WARN: Code duplicated, block: B:36:0x009d A[SYNTHETIC] */
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final void placeChildren() {
                                        int i6;
                                        switch (i5) {
                                            case 0:
                                                int i7 = i4;
                                                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                                layoutNodeSubcompositionsState3.currentApproachIndex = i7;
                                                measureResult2.placeChildren();
                                                MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                long[] jArr = mutableScatterMap.metadata;
                                                int length = jArr.length - 2;
                                                if (length >= 0) {
                                                    int i8 = 0;
                                                    while (true) {
                                                        long j2 = jArr[i8];
                                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i9 = 8;
                                                            int i10 = 8 - ((~(i8 - length)) >>> 31);
                                                            int i11 = 0;
                                                            while (i11 < i10) {
                                                                if ((255 & j2) < 128) {
                                                                    int i12 = (i8 << 3) + i11;
                                                                    Object obj3 = mutableScatterMap.keys[i12];
                                                                    SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i12];
                                                                    int iIndexOf = mutableVector.indexOf(obj3);
                                                                    i6 = i9;
                                                                    if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                        if (iIndexOf >= 0) {
                                                                            Object[] objArr = mutableVector.content;
                                                                            Object obj4 = objArr[iIndexOf];
                                                                            objArr[iIndexOf] = RulerKt.UnspecifiedSlotId;
                                                                        }
                                                                        if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                            precomposedSlotHandle.dispose();
                                                                        }
                                                                        mutableScatterMap.removeValueAt(i12);
                                                                    }
                                                                } else {
                                                                    i6 = i9;
                                                                }
                                                                j2 >>= i6;
                                                                i11++;
                                                                i9 = i6;
                                                            }
                                                            if (i10 == i9) {
                                                                if (i8 != length) {
                                                                    i8++;
                                                                }
                                                            }
                                                        } else if (i8 != length) {
                                                            i8++;
                                                        }
                                                    }
                                                }
                                                layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                break;
                                            default:
                                                int i13 = i4;
                                                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState4 = layoutNodeSubcompositionsState2;
                                                layoutNodeSubcompositionsState4.currentIndex = i13;
                                                measureResult2.placeChildren();
                                                if (layoutNodeSubcompositionsState4.root.lookaheadRoot == null) {
                                                    layoutNodeSubcompositionsState4.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState4.currentIndex);
                                                }
                                                break;
                                        }
                                    }
                                };
                            }
                        });
                        break;
                }
                return Unit.INSTANCE;
            }
        };
        final int i2 = 1;
        this.setCompositionContext = new Function2(this) { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            public final /* synthetic */ SubcomposeLayoutState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        LayoutNode layoutNode = (LayoutNode) obj;
                        SubcomposeLayoutState subcomposeLayoutState = this.this$0;
                        SubcomposeSlotReusePolicy subcomposeSlotReusePolicy2 = subcomposeLayoutState.slotReusePolicy;
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
                        if (layoutNodeSubcompositionsState == null) {
                            layoutNodeSubcompositionsState = new LayoutNodeSubcompositionsState(layoutNode, subcomposeSlotReusePolicy2);
                            layoutNode.subcompositionsState = layoutNodeSubcompositionsState;
                        }
                        subcomposeLayoutState._state = layoutNodeSubcompositionsState;
                        subcomposeLayoutState.getState().makeSureStateIsConsistent();
                        LayoutNodeSubcompositionsState state = subcomposeLayoutState.getState();
                        if (state.slotReusePolicy != subcomposeSlotReusePolicy2) {
                            state.slotReusePolicy = subcomposeSlotReusePolicy2;
                            state.markActiveNodesAsReused(false);
                            LayoutNode.requestRemeasure$ui$default(state.root, false, 7);
                        }
                        break;
                    case 1:
                        this.this$0.getState().compositionContext = (CompositionContext) obj2;
                        break;
                    default:
                        final Function2 function2 = (Function2) obj2;
                        final LayoutNodeSubcompositionsState state2 = this.this$0.getState();
                        ((LayoutNode) obj).setMeasurePolicy(new LayoutNode.NoIntrinsicsMeasurePolicy(state2.NoIntrinsicsMessage) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
                                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = state2;
                                LayoutNodeSubcompositionsState.Scope scope = layoutNodeSubcompositionsState2.scope;
                                scope.layoutDirection = measureScope.getLayoutDirection();
                                scope.density = measureScope.getDensity();
                                scope.fontScale = measureScope.getFontScale();
                                boolean zIsLookingAhead = measureScope.isLookingAhead();
                                Function2 function3 = function2;
                                if (zIsLookingAhead || layoutNodeSubcompositionsState2.root.lookaheadRoot == null) {
                                    layoutNodeSubcompositionsState2.currentIndex = 0;
                                    final MeasureResult measureResult = (MeasureResult) function3.invoke(scope, new Constraints(j));
                                    final int i3 = layoutNodeSubcompositionsState2.currentIndex;
                                    final int i4 = 1;
                                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Map getAlignmentLines() {
                                            switch (i4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getAlignmentLines();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getHeight() {
                                            switch (i4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getHeight();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 getRulers() {
                                            switch (i4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulers();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getWidth() {
                                            switch (i4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getWidth();
                                        }

                                        /* JADX WARN: Code duplicated, block: B:31:0x0098 A[DONT_INVERT] */
                                        /* JADX WARN: Code duplicated, block: B:32:0x009a A[LOOP:0: B:11:0x0035->B:32:0x009a, LOOP_END] */
                                        /* JADX WARN: Code duplicated, block: B:36:0x009d A[SYNTHETIC] */
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final void placeChildren() {
                                            int i6;
                                            switch (i4) {
                                                case 0:
                                                    int i7 = i3;
                                                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                                    layoutNodeSubcompositionsState3.currentApproachIndex = i7;
                                                    measureResult.placeChildren();
                                                    MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                    MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                    long[] jArr = mutableScatterMap.metadata;
                                                    int length = jArr.length - 2;
                                                    if (length >= 0) {
                                                        int i8 = 0;
                                                        while (true) {
                                                            long j2 = jArr[i8];
                                                            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i9 = 8;
                                                                int i10 = 8 - ((~(i8 - length)) >>> 31);
                                                                int i11 = 0;
                                                                while (i11 < i10) {
                                                                    if ((255 & j2) < 128) {
                                                                        int i12 = (i8 << 3) + i11;
                                                                        Object obj3 = mutableScatterMap.keys[i12];
                                                                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i12];
                                                                        int iIndexOf = mutableVector.indexOf(obj3);
                                                                        i6 = i9;
                                                                        if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                            if (iIndexOf >= 0) {
                                                                                Object[] objArr = mutableVector.content;
                                                                                Object obj4 = objArr[iIndexOf];
                                                                                objArr[iIndexOf] = RulerKt.UnspecifiedSlotId;
                                                                            }
                                                                            if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                                precomposedSlotHandle.dispose();
                                                                            }
                                                                            mutableScatterMap.removeValueAt(i12);
                                                                        }
                                                                    } else {
                                                                        i6 = i9;
                                                                    }
                                                                    j2 >>= i6;
                                                                    i11++;
                                                                    i9 = i6;
                                                                }
                                                                if (i10 == i9) {
                                                                    if (i8 != length) {
                                                                        i8++;
                                                                    }
                                                                }
                                                            } else if (i8 != length) {
                                                                i8++;
                                                            }
                                                        }
                                                    }
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    break;
                                                default:
                                                    int i13 = i3;
                                                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState4 = layoutNodeSubcompositionsState2;
                                                    layoutNodeSubcompositionsState4.currentIndex = i13;
                                                    measureResult.placeChildren();
                                                    if (layoutNodeSubcompositionsState4.root.lookaheadRoot == null) {
                                                        layoutNodeSubcompositionsState4.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState4.currentIndex);
                                                    }
                                                    break;
                                            }
                                        }
                                    };
                                }
                                layoutNodeSubcompositionsState2.currentApproachIndex = 0;
                                final MeasureResult measureResult2 = (MeasureResult) function3.invoke(layoutNodeSubcompositionsState2.approachMeasureScope, new Constraints(j));
                                final int i5 = layoutNodeSubcompositionsState2.currentApproachIndex;
                                final int i6 = 0;
                                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Map getAlignmentLines() {
                                        switch (i6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getAlignmentLines();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getHeight() {
                                        switch (i6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getHeight();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 getRulers() {
                                        switch (i6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulers();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getWidth() {
                                        switch (i6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getWidth();
                                    }

                                    /* JADX WARN: Code duplicated, block: B:31:0x0098 A[DONT_INVERT] */
                                    /* JADX WARN: Code duplicated, block: B:32:0x009a A[LOOP:0: B:11:0x0035->B:32:0x009a, LOOP_END] */
                                    /* JADX WARN: Code duplicated, block: B:36:0x009d A[SYNTHETIC] */
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final void placeChildren() {
                                        int i7;
                                        switch (i6) {
                                            case 0:
                                                int i8 = i5;
                                                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                                layoutNodeSubcompositionsState3.currentApproachIndex = i8;
                                                measureResult2.placeChildren();
                                                MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                long[] jArr = mutableScatterMap.metadata;
                                                int length = jArr.length - 2;
                                                if (length >= 0) {
                                                    int i9 = 0;
                                                    while (true) {
                                                        long j2 = jArr[i9];
                                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i10 = 8;
                                                            int i11 = 8 - ((~(i9 - length)) >>> 31);
                                                            int i12 = 0;
                                                            while (i12 < i11) {
                                                                if ((255 & j2) < 128) {
                                                                    int i13 = (i9 << 3) + i12;
                                                                    Object obj3 = mutableScatterMap.keys[i13];
                                                                    SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i13];
                                                                    int iIndexOf = mutableVector.indexOf(obj3);
                                                                    i7 = i10;
                                                                    if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                        if (iIndexOf >= 0) {
                                                                            Object[] objArr = mutableVector.content;
                                                                            Object obj4 = objArr[iIndexOf];
                                                                            objArr[iIndexOf] = RulerKt.UnspecifiedSlotId;
                                                                        }
                                                                        if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                            precomposedSlotHandle.dispose();
                                                                        }
                                                                        mutableScatterMap.removeValueAt(i13);
                                                                    }
                                                                } else {
                                                                    i7 = i10;
                                                                }
                                                                j2 >>= i7;
                                                                i12++;
                                                                i10 = i7;
                                                            }
                                                            if (i11 == i10) {
                                                                if (i9 != length) {
                                                                    i9++;
                                                                }
                                                            }
                                                        } else if (i9 != length) {
                                                            i9++;
                                                        }
                                                    }
                                                }
                                                layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                break;
                                            default:
                                                int i14 = i5;
                                                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState4 = layoutNodeSubcompositionsState2;
                                                layoutNodeSubcompositionsState4.currentIndex = i14;
                                                measureResult2.placeChildren();
                                                if (layoutNodeSubcompositionsState4.root.lookaheadRoot == null) {
                                                    layoutNodeSubcompositionsState4.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState4.currentIndex);
                                                }
                                                break;
                                        }
                                    }
                                };
                            }
                        });
                        break;
                }
                return Unit.INSTANCE;
            }
        };
        final int i3 = 2;
        this.setMeasurePolicy = new Function2(this) { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            public final /* synthetic */ SubcomposeLayoutState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i3) {
                    case 0:
                        LayoutNode layoutNode = (LayoutNode) obj;
                        SubcomposeLayoutState subcomposeLayoutState = this.this$0;
                        SubcomposeSlotReusePolicy subcomposeSlotReusePolicy2 = subcomposeLayoutState.slotReusePolicy;
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
                        if (layoutNodeSubcompositionsState == null) {
                            layoutNodeSubcompositionsState = new LayoutNodeSubcompositionsState(layoutNode, subcomposeSlotReusePolicy2);
                            layoutNode.subcompositionsState = layoutNodeSubcompositionsState;
                        }
                        subcomposeLayoutState._state = layoutNodeSubcompositionsState;
                        subcomposeLayoutState.getState().makeSureStateIsConsistent();
                        LayoutNodeSubcompositionsState state = subcomposeLayoutState.getState();
                        if (state.slotReusePolicy != subcomposeSlotReusePolicy2) {
                            state.slotReusePolicy = subcomposeSlotReusePolicy2;
                            state.markActiveNodesAsReused(false);
                            LayoutNode.requestRemeasure$ui$default(state.root, false, 7);
                        }
                        break;
                    case 1:
                        this.this$0.getState().compositionContext = (CompositionContext) obj2;
                        break;
                    default:
                        final Function2 function2 = (Function2) obj2;
                        final LayoutNodeSubcompositionsState state2 = this.this$0.getState();
                        ((LayoutNode) obj).setMeasurePolicy(new LayoutNode.NoIntrinsicsMeasurePolicy(state2.NoIntrinsicsMessage) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
                                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = state2;
                                LayoutNodeSubcompositionsState.Scope scope = layoutNodeSubcompositionsState2.scope;
                                scope.layoutDirection = measureScope.getLayoutDirection();
                                scope.density = measureScope.getDensity();
                                scope.fontScale = measureScope.getFontScale();
                                boolean zIsLookingAhead = measureScope.isLookingAhead();
                                Function2 function3 = function2;
                                if (zIsLookingAhead || layoutNodeSubcompositionsState2.root.lookaheadRoot == null) {
                                    layoutNodeSubcompositionsState2.currentIndex = 0;
                                    final MeasureResult measureResult = (MeasureResult) function3.invoke(scope, new Constraints(j));
                                    final int i4 = layoutNodeSubcompositionsState2.currentIndex;
                                    final int i5 = 1;
                                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Map getAlignmentLines() {
                                            switch (i5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getAlignmentLines();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getHeight() {
                                            switch (i5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getHeight();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 getRulers() {
                                            switch (i5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulers();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getWidth() {
                                            switch (i5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getWidth();
                                        }

                                        /* JADX WARN: Code duplicated, block: B:31:0x0098 A[DONT_INVERT] */
                                        /* JADX WARN: Code duplicated, block: B:32:0x009a A[LOOP:0: B:11:0x0035->B:32:0x009a, LOOP_END] */
                                        /* JADX WARN: Code duplicated, block: B:36:0x009d A[SYNTHETIC] */
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final void placeChildren() {
                                            int i7;
                                            switch (i5) {
                                                case 0:
                                                    int i8 = i4;
                                                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                                    layoutNodeSubcompositionsState3.currentApproachIndex = i8;
                                                    measureResult.placeChildren();
                                                    MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                    MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                    long[] jArr = mutableScatterMap.metadata;
                                                    int length = jArr.length - 2;
                                                    if (length >= 0) {
                                                        int i9 = 0;
                                                        while (true) {
                                                            long j2 = jArr[i9];
                                                            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i10 = 8;
                                                                int i11 = 8 - ((~(i9 - length)) >>> 31);
                                                                int i12 = 0;
                                                                while (i12 < i11) {
                                                                    if ((255 & j2) < 128) {
                                                                        int i13 = (i9 << 3) + i12;
                                                                        Object obj3 = mutableScatterMap.keys[i13];
                                                                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i13];
                                                                        int iIndexOf = mutableVector.indexOf(obj3);
                                                                        i7 = i10;
                                                                        if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                            if (iIndexOf >= 0) {
                                                                                Object[] objArr = mutableVector.content;
                                                                                Object obj4 = objArr[iIndexOf];
                                                                                objArr[iIndexOf] = RulerKt.UnspecifiedSlotId;
                                                                            }
                                                                            if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                                precomposedSlotHandle.dispose();
                                                                            }
                                                                            mutableScatterMap.removeValueAt(i13);
                                                                        }
                                                                    } else {
                                                                        i7 = i10;
                                                                    }
                                                                    j2 >>= i7;
                                                                    i12++;
                                                                    i10 = i7;
                                                                }
                                                                if (i11 == i10) {
                                                                    if (i9 != length) {
                                                                        i9++;
                                                                    }
                                                                }
                                                            } else if (i9 != length) {
                                                                i9++;
                                                            }
                                                        }
                                                    }
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    break;
                                                default:
                                                    int i14 = i4;
                                                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState4 = layoutNodeSubcompositionsState2;
                                                    layoutNodeSubcompositionsState4.currentIndex = i14;
                                                    measureResult.placeChildren();
                                                    if (layoutNodeSubcompositionsState4.root.lookaheadRoot == null) {
                                                        layoutNodeSubcompositionsState4.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState4.currentIndex);
                                                    }
                                                    break;
                                            }
                                        }
                                    };
                                }
                                layoutNodeSubcompositionsState2.currentApproachIndex = 0;
                                final MeasureResult measureResult2 = (MeasureResult) function3.invoke(layoutNodeSubcompositionsState2.approachMeasureScope, new Constraints(j));
                                final int i6 = layoutNodeSubcompositionsState2.currentApproachIndex;
                                final int i7 = 0;
                                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Map getAlignmentLines() {
                                        switch (i7) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getAlignmentLines();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getHeight() {
                                        switch (i7) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getHeight();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 getRulers() {
                                        switch (i7) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulers();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getWidth() {
                                        switch (i7) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getWidth();
                                    }

                                    /* JADX WARN: Code duplicated, block: B:31:0x0098 A[DONT_INVERT] */
                                    /* JADX WARN: Code duplicated, block: B:32:0x009a A[LOOP:0: B:11:0x0035->B:32:0x009a, LOOP_END] */
                                    /* JADX WARN: Code duplicated, block: B:36:0x009d A[SYNTHETIC] */
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final void placeChildren() {
                                        int i8;
                                        switch (i7) {
                                            case 0:
                                                int i9 = i6;
                                                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                                layoutNodeSubcompositionsState3.currentApproachIndex = i9;
                                                measureResult2.placeChildren();
                                                MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                long[] jArr = mutableScatterMap.metadata;
                                                int length = jArr.length - 2;
                                                if (length >= 0) {
                                                    int i10 = 0;
                                                    while (true) {
                                                        long j2 = jArr[i10];
                                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i11 = 8;
                                                            int i12 = 8 - ((~(i10 - length)) >>> 31);
                                                            int i13 = 0;
                                                            while (i13 < i12) {
                                                                if ((255 & j2) < 128) {
                                                                    int i14 = (i10 << 3) + i13;
                                                                    Object obj3 = mutableScatterMap.keys[i14];
                                                                    SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i14];
                                                                    int iIndexOf = mutableVector.indexOf(obj3);
                                                                    i8 = i11;
                                                                    if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                        if (iIndexOf >= 0) {
                                                                            Object[] objArr = mutableVector.content;
                                                                            Object obj4 = objArr[iIndexOf];
                                                                            objArr[iIndexOf] = RulerKt.UnspecifiedSlotId;
                                                                        }
                                                                        if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                            precomposedSlotHandle.dispose();
                                                                        }
                                                                        mutableScatterMap.removeValueAt(i14);
                                                                    }
                                                                } else {
                                                                    i8 = i11;
                                                                }
                                                                j2 >>= i8;
                                                                i13++;
                                                                i11 = i8;
                                                            }
                                                            if (i12 == i11) {
                                                                if (i10 != length) {
                                                                    i10++;
                                                                }
                                                            }
                                                        } else if (i10 != length) {
                                                            i10++;
                                                        }
                                                    }
                                                }
                                                layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                break;
                                            default:
                                                int i15 = i6;
                                                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState4 = layoutNodeSubcompositionsState2;
                                                layoutNodeSubcompositionsState4.currentIndex = i15;
                                                measureResult2.placeChildren();
                                                if (layoutNodeSubcompositionsState4.root.lookaheadRoot == null) {
                                                    layoutNodeSubcompositionsState4.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState4.currentIndex);
                                                }
                                                break;
                                        }
                                    }
                                };
                            }
                        });
                        break;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this._state;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout");
    }
}
