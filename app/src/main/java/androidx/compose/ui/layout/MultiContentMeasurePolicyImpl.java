package androidx.compose.ui.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflowState;
import androidx.compose.foundation.layout.FlowMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MultiContentMeasurePolicyImpl implements MeasurePolicy {
    public final FlowMeasurePolicy measurePolicy;

    public MultiContentMeasurePolicyImpl(FlowMeasurePolicy flowMeasurePolicy) {
        this.measurePolicy = flowMeasurePolicy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiContentMeasurePolicyImpl) && Intrinsics.areEqual(this.measurePolicy, ((MultiContentMeasurePolicyImpl) obj).measurePolicy);
    }

    public final int hashCode() {
        return this.measurePolicy.hashCode();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList childrenOfVirtualChildren = HitTestResultKt.getChildrenOfVirtualChildren(intrinsicMeasureScope);
        FlowMeasurePolicy flowMeasurePolicy = this.measurePolicy;
        FlowLayoutOverflowState flowLayoutOverflowState = flowMeasurePolicy.overflow;
        List list2 = (List) CollectionsKt.getOrNull(1, childrenOfVirtualChildren);
        Measurable measurable = list2 != null ? (Measurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(2, childrenOfVirtualChildren);
        flowLayoutOverflowState.m116setOverflowMeasurableshBUhpc$foundation_layout(measurable, list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null, ConstraintsKt.Constraints$default(0, i, 0, 0, 13));
        List list4 = (List) CollectionsKt.firstOrNull(childrenOfVirtualChildren);
        if (list4 == null) {
            list4 = EmptyList.INSTANCE;
        }
        return FlowMeasurePolicy.intrinsicCrossAxisSize(list4, i, intrinsicMeasureScope.mo86roundToPx0680j_4(flowMeasurePolicy.mainAxisSpacing), intrinsicMeasureScope.mo86roundToPx0680j_4(flowMeasurePolicy.crossAxisArrangementSpacing), flowMeasurePolicy.overflow);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList childrenOfVirtualChildren = HitTestResultKt.getChildrenOfVirtualChildren(intrinsicMeasureScope);
        FlowMeasurePolicy flowMeasurePolicy = this.measurePolicy;
        FlowLayoutOverflowState flowLayoutOverflowState = flowMeasurePolicy.overflow;
        List list2 = (List) CollectionsKt.getOrNull(1, childrenOfVirtualChildren);
        Measurable measurable = list2 != null ? (Measurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(2, childrenOfVirtualChildren);
        flowLayoutOverflowState.m116setOverflowMeasurableshBUhpc$foundation_layout(measurable, list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null, ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        List list4 = (List) CollectionsKt.firstOrNull(childrenOfVirtualChildren);
        if (list4 == null) {
            list4 = EmptyList.INSTANCE;
        }
        int iMo86roundToPx0680j_4 = intrinsicMeasureScope.mo86roundToPx0680j_4(flowMeasurePolicy.mainAxisSpacing);
        int size = list4.size();
        int i2 = 0;
        int iMax = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int iMaxIntrinsicWidth = ((Measurable) list4.get(i2)).maxIntrinsicWidth(i) + iMo86roundToPx0680j_4;
            int i5 = i2 + 1;
            if (i5 - i3 == Integer.MAX_VALUE || i5 == list4.size()) {
                iMax = Math.max(iMax, (i4 + iMaxIntrinsicWidth) - iMo86roundToPx0680j_4);
                i3 = i2;
                i4 = 0;
            } else {
                i4 += iMaxIntrinsicWidth;
            }
            i2 = i5;
        }
        return iMax;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
        Measurable measurable;
        Placeable placeable;
        IntIntPair intIntPair;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        int i;
        char c;
        Measurable measurable2;
        Placeable placeableMo517measureBRTryo0;
        IntIntPair intIntPair2;
        Integer num;
        IntIntPair intIntPair3;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo2;
        int i2;
        Integer numValueOf;
        long jM21constructorimpl;
        long jM21constructorimpl2;
        Placeable placeableMo517measureBRTryo1;
        ArrayList childrenOfVirtualChildren = HitTestResultKt.getChildrenOfVirtualChildren(measureScope);
        final FlowMeasurePolicy flowMeasurePolicy = this.measurePolicy;
        final FlowLayoutOverflowState flowLayoutOverflowState = flowMeasurePolicy.overflow;
        boolean zIsEmpty = childrenOfVirtualChildren.isEmpty();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        final int i3 = 0;
        if (!zIsEmpty) {
            if (Constraints.m682getMaxHeightimpl(j) != 0) {
                List list2 = (List) CollectionsKt.first((List) childrenOfVirtualChildren);
                if (list2.isEmpty()) {
                    return measureScope.layout(0, 0, emptyMap, new BasicTextKt$$ExternalSyntheticLambda3(9));
                }
                final int i4 = 1;
                List list3 = (List) CollectionsKt.getOrNull(1, childrenOfVirtualChildren);
                Measurable measurable3 = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
                List list4 = (List) CollectionsKt.getOrNull(2, childrenOfVirtualChildren);
                Measurable measurable4 = list4 != null ? (Measurable) CollectionsKt.firstOrNull(list4) : null;
                list2.size();
                flowLayoutOverflowState.getClass();
                long jM125constructorimpl = OffsetKt.m125constructorimpl(1, j);
                long jM133toBoxConstraintsOenEA2s = OffsetKt.m133toBoxConstraintsOenEA2s(ConstraintsKt.Constraints(0, Constraints.m683getMaxWidthimpl(jM125constructorimpl), (10 & 4) != 0 ? Constraints.m684getMinHeightimpl(jM125constructorimpl) : 0, Constraints.m682getMaxHeightimpl(jM125constructorimpl)));
                if (measurable3 != null) {
                    OffsetKt.m127measureAndCacherqJ1uqs(measurable3, flowMeasurePolicy, jM133toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutOverflowState$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int measuredWidth;
                            int measuredHeight;
                            int measuredWidth2;
                            int measuredHeight2;
                            Placeable placeable2 = (Placeable) obj;
                            switch (i3) {
                                case 0:
                                    if (placeable2 != null) {
                                        flowMeasurePolicy.getClass();
                                        measuredWidth = placeable2.getMeasuredWidth();
                                        measuredHeight = placeable2.getMeasuredHeight();
                                    } else {
                                        measuredWidth = 0;
                                        measuredHeight = 0;
                                    }
                                    IntIntPair intIntPair4 = new IntIntPair(IntIntPair.m21constructorimpl(measuredWidth, measuredHeight));
                                    FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
                                    flowLayoutOverflowState2.seeMoreSize = intIntPair4;
                                    flowLayoutOverflowState2.seeMorePlaceable = placeable2;
                                    break;
                                default:
                                    if (placeable2 != null) {
                                        flowMeasurePolicy.getClass();
                                        measuredWidth2 = placeable2.getMeasuredWidth();
                                        measuredHeight2 = placeable2.getMeasuredHeight();
                                    } else {
                                        measuredWidth2 = 0;
                                        measuredHeight2 = 0;
                                    }
                                    IntIntPair intIntPair5 = new IntIntPair(IntIntPair.m21constructorimpl(measuredWidth2, measuredHeight2));
                                    FlowLayoutOverflowState flowLayoutOverflowState3 = flowLayoutOverflowState;
                                    flowLayoutOverflowState3.collapseSize = intIntPair5;
                                    flowLayoutOverflowState3.collapsePlaceable = placeable2;
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    flowLayoutOverflowState.seeMoreMeasurable = measurable3;
                }
                if (measurable4 != null) {
                    OffsetKt.m127measureAndCacherqJ1uqs(measurable4, flowMeasurePolicy, jM133toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutOverflowState$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int measuredWidth;
                            int measuredHeight;
                            int measuredWidth2;
                            int measuredHeight2;
                            Placeable placeable2 = (Placeable) obj;
                            switch (i4) {
                                case 0:
                                    if (placeable2 != null) {
                                        flowMeasurePolicy.getClass();
                                        measuredWidth = placeable2.getMeasuredWidth();
                                        measuredHeight = placeable2.getMeasuredHeight();
                                    } else {
                                        measuredWidth = 0;
                                        measuredHeight = 0;
                                    }
                                    IntIntPair intIntPair4 = new IntIntPair(IntIntPair.m21constructorimpl(measuredWidth, measuredHeight));
                                    FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
                                    flowLayoutOverflowState2.seeMoreSize = intIntPair4;
                                    flowLayoutOverflowState2.seeMorePlaceable = placeable2;
                                    break;
                                default:
                                    if (placeable2 != null) {
                                        flowMeasurePolicy.getClass();
                                        measuredWidth2 = placeable2.getMeasuredWidth();
                                        measuredHeight2 = placeable2.getMeasuredHeight();
                                    } else {
                                        measuredWidth2 = 0;
                                        measuredHeight2 = 0;
                                    }
                                    IntIntPair intIntPair5 = new IntIntPair(IntIntPair.m21constructorimpl(measuredWidth2, measuredHeight2));
                                    FlowLayoutOverflowState flowLayoutOverflowState3 = flowLayoutOverflowState;
                                    flowLayoutOverflowState3.collapseSize = intIntPair5;
                                    flowLayoutOverflowState3.collapsePlaceable = placeable2;
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    flowLayoutOverflowState.collapseMeasurable = measurable4;
                }
                Iterator it = list2.iterator();
                float f = flowMeasurePolicy.mainAxisSpacing;
                float f2 = flowMeasurePolicy.crossAxisArrangementSpacing;
                long jM125constructorimpl2 = OffsetKt.m125constructorimpl(1, j);
                FlowLayoutOverflowState flowLayoutOverflowState2 = flowMeasurePolicy.overflow;
                MutableVector mutableVector = new MutableVector(new MeasureResult[16]);
                int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(jM125constructorimpl2);
                int iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(jM125constructorimpl2);
                int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(jM125constructorimpl2);
                MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
                MutableIntObjectMap mutableIntObjectMap2 = new MutableIntObjectMap();
                ArrayList arrayList = new ArrayList();
                int iCeil = (int) Math.ceil(measureScope.mo92toPx0680j_4(f));
                int iCeil2 = (int) Math.ceil(measureScope.mo92toPx0680j_4(f2));
                long jConstraints = ConstraintsKt.Constraints(0, iM683getMaxWidthimpl, 0, iM682getMaxHeightimpl);
                long jM133toBoxConstraintsOenEA2s2 = OffsetKt.m133toBoxConstraintsOenEA2s(ConstraintsKt.Constraints(0, Constraints.m683getMaxWidthimpl(jConstraints), (10 & 4) != 0 ? Constraints.m684getMinHeightimpl(jConstraints) : 0, Constraints.m682getMaxHeightimpl(jConstraints)));
                if (it.hasNext()) {
                    try {
                        measurable = (Measurable) it.next();
                    } catch (IndexOutOfBoundsException unused) {
                        measurable = null;
                    }
                } else {
                    measurable = null;
                }
                if (measurable != null) {
                    if (OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable)) == 0.0f) {
                        OffsetKt.getRowColumnParentData(measurable);
                        placeableMo517measureBRTryo1 = measurable.mo517measureBRTryo0(jM133toBoxConstraintsOenEA2s2);
                        Unit unit = Unit.INSTANCE;
                        jM21constructorimpl2 = IntIntPair.m21constructorimpl(placeableMo517measureBRTryo1.getMeasuredWidth(), placeableMo517measureBRTryo1.getMeasuredHeight());
                    } else {
                        int iMinIntrinsicWidth = measurable.minIntrinsicWidth(Integer.MAX_VALUE);
                        jM21constructorimpl2 = IntIntPair.m21constructorimpl(iMinIntrinsicWidth, measurable.minIntrinsicHeight(iMinIntrinsicWidth));
                        placeableMo517measureBRTryo1 = null;
                    }
                    intIntPair = new IntIntPair(jM21constructorimpl2);
                    placeable = placeableMo517measureBRTryo1;
                } else {
                    it = it;
                    placeable = null;
                    intIntPair = null;
                }
                Placeable placeable2 = placeable;
                Integer numValueOf2 = intIntPair != null ? Integer.valueOf((int) (intIntPair.packedValue >> 32)) : null;
                Integer numValueOf3 = intIntPair != null ? Integer.valueOf((int) (intIntPair.packedValue & 4294967295L)) : null;
                MutableIntList mutableIntList = new MutableIntList();
                MutableIntList mutableIntList2 = new MutableIntList();
                Measurable measurable5 = measurable;
                MutableIntSet mutableIntSet = new MutableIntSet();
                FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(flowLayoutOverflowState2, jM125constructorimpl2, iCeil, iCeil2);
                IntIntPair intIntPair4 = intIntPair;
                FlowLayoutBuildingBlocks.WrapInfo wrapInfoM114getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m114getWrapInfoOpUlnko(it.hasNext(), 0, IntIntPair.m21constructorimpl(iM683getMaxWidthimpl, iM682getMaxHeightimpl), intIntPair4, 0, 0, 0, false, false);
                Integer num2 = numValueOf3;
                if (wrapInfoM114getWrapInfoOpUlnko.isLastItemInContainer) {
                    wrapInfo = wrapInfoM114getWrapInfoOpUlnko;
                    wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfo, intIntPair4 != null, -1, 0, iM683getMaxWidthimpl, 0);
                } else {
                    wrapInfo = wrapInfoM114getWrapInfoOpUlnko;
                    wrapEllipsisInfo = null;
                }
                int i5 = iM685getMinWidthimpl;
                FlowLayoutBuildingBlocks.WrapInfo wrapInfo3 = wrapInfo;
                Placeable placeable3 = placeable2;
                Measurable measurable6 = measurable5;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = iM683getMaxWidthimpl;
                int i12 = iM682getMaxHeightimpl;
                int i13 = 0;
                while (!wrapInfo3.isLastItemInContainer && measurable6 != null) {
                    int iIntValue = numValueOf2.intValue();
                    MutableIntSet mutableIntSet2 = mutableIntSet;
                    int i14 = i6 + iIntValue;
                    int iMax = Math.max(i7, num2.intValue());
                    int i15 = i11 - iIntValue;
                    int i16 = i13 + 1;
                    flowLayoutOverflowState2.getClass();
                    arrayList.add(measurable6);
                    mutableIntObjectMap2.set(i13, placeable3);
                    measurable6.getParentData();
                    int i17 = i16 - i8;
                    if (it.hasNext()) {
                        try {
                            measurable2 = (Measurable) it.next();
                        } catch (IndexOutOfBoundsException unused2) {
                            measurable2 = null;
                        }
                        measurable6 = measurable2;
                    } else {
                        measurable6 = null;
                    }
                    if (measurable6 != null) {
                        if (OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable6)) == 0.0f) {
                            OffsetKt.getRowColumnParentData(measurable6);
                            placeableMo517measureBRTryo0 = measurable6.mo517measureBRTryo0(jM133toBoxConstraintsOenEA2s2);
                            Unit unit2 = Unit.INSTANCE;
                            jM21constructorimpl = IntIntPair.m21constructorimpl(placeableMo517measureBRTryo0.getMeasuredWidth(), placeableMo517measureBRTryo0.getMeasuredHeight());
                        } else {
                            int iMinIntrinsicWidth2 = measurable6.minIntrinsicWidth(Integer.MAX_VALUE);
                            jM21constructorimpl = IntIntPair.m21constructorimpl(iMinIntrinsicWidth2, measurable6.minIntrinsicHeight(iMinIntrinsicWidth2));
                            placeableMo517measureBRTryo0 = null;
                        }
                        intIntPair2 = new IntIntPair(jM21constructorimpl);
                    } else {
                        jM133toBoxConstraintsOenEA2s2 = jM133toBoxConstraintsOenEA2s2;
                        placeableMo517measureBRTryo0 = null;
                        intIntPair2 = null;
                    }
                    Integer numValueOf4 = intIntPair2 != null ? Integer.valueOf(((int) (intIntPair2.packedValue >> 32)) + iCeil) : null;
                    Integer numValueOf5 = intIntPair2 != null ? Integer.valueOf((int) (intIntPair2.packedValue & 4294967295L)) : null;
                    boolean zHasNext = it.hasNext();
                    int i18 = i9;
                    long jM21constructorimpl3 = IntIntPair.m21constructorimpl(i15, i12);
                    if (intIntPair2 == null) {
                        num = numValueOf5;
                        intIntPair3 = null;
                    } else {
                        num = numValueOf5;
                        intIntPair3 = new IntIntPair(IntIntPair.m21constructorimpl(numValueOf4.intValue(), num.intValue()));
                    }
                    FlowLayoutBuildingBlocks.WrapInfo wrapInfoM114getWrapInfoOpUlnko2 = flowLayoutBuildingBlocks.m114getWrapInfoOpUlnko(zHasNext, i17, jM21constructorimpl3, intIntPair3, i18, i10, iMax, false, false);
                    int i19 = iMax;
                    if (wrapInfoM114getWrapInfoOpUlnko2.isLastItemInLine) {
                        int iMin = Math.min(Math.max(i5, i14), iM683getMaxWidthimpl);
                        int i20 = i10 + i19;
                        wrapInfo2 = wrapInfoM114getWrapInfoOpUlnko2;
                        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2 = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfo2, intIntPair2 != null, i18, i20, i15, i17);
                        mutableIntList2.add(i19);
                        i12 = (iM682getMaxHeightimpl - i20) - iCeil2;
                        mutableIntList.add(i16);
                        i9 = i18 + 1;
                        i10 = i20 + iCeil2;
                        i5 = iMin;
                        i2 = iM683getMaxWidthimpl;
                        i8 = i16;
                        i14 = 0;
                        wrapEllipsisInfo = wrapEllipsisInfo2;
                        numValueOf = numValueOf4 != null ? Integer.valueOf(numValueOf4.intValue() - iCeil) : null;
                        i19 = 0;
                    } else {
                        wrapInfo2 = wrapInfoM114getWrapInfoOpUlnko2;
                        i2 = i15;
                        numValueOf = numValueOf4;
                        i9 = i18;
                    }
                    i13 = i16;
                    i6 = i14;
                    wrapInfo3 = wrapInfo2;
                    mutableIntSet = mutableIntSet2;
                    placeable3 = placeableMo517measureBRTryo0;
                    numValueOf2 = numValueOf;
                    i7 = i19;
                    num2 = num;
                    i11 = i2;
                    jM133toBoxConstraintsOenEA2s2 = jM133toBoxConstraintsOenEA2s2;
                }
                MutableIntSet mutableIntSet3 = mutableIntSet;
                if (wrapEllipsisInfo != null) {
                    long j2 = wrapEllipsisInfo.ellipsisSize;
                    arrayList.add(wrapEllipsisInfo.ellipsis);
                    mutableIntObjectMap2.set(arrayList.size() - 1, wrapEllipsisInfo.placeable);
                    int i21 = mutableIntList._size - 1;
                    if (wrapEllipsisInfo.placeEllipsisOnLastContentLine) {
                        mutableIntList2.set(i21, Math.max(mutableIntList2.get(i21), (int) (j2 & 4294967295L)));
                        mutableIntList.set(i21, mutableIntList.last() + 1);
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        mutableIntList2.add((int) (j2 & 4294967295L));
                        mutableIntList.add(mutableIntList.last() + 1);
                    }
                }
                int size = arrayList.size();
                Placeable[] placeableArr = new Placeable[size];
                for (int i22 = 0; i22 < size; i22++) {
                    placeableArr[i22] = mutableIntObjectMap2.get(i22);
                }
                int i23 = mutableIntList._size;
                int[] iArr = new int[i23];
                int[] iArr2 = new int[i23];
                int[] iArr3 = mutableIntList.content;
                int iMax2 = i5;
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                while (i25 < i23) {
                    int i27 = iArr3[i25];
                    int iM682getMaxHeightimpl2 = mutableIntList2.get(i25);
                    MutableIntSet mutableIntSet4 = mutableIntSet3;
                    if (mutableIntSet4.contains(i25)) {
                        c = 65535;
                    } else {
                        c = 65535;
                        iM682getMaxHeightimpl2 = Constraints.m682getMaxHeightimpl(jConstraints) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Constraints.m682getMaxHeightimpl(jConstraints) - i26;
                    }
                    mutableIntSet3 = mutableIntSet4;
                    MeasureResult measureResultMeasure = OffsetKt.measure(flowMeasurePolicy, iMax2, Constraints.m684getMinHeightimpl(jConstraints), Constraints.m683getMaxWidthimpl(jConstraints), iM682getMaxHeightimpl2, iCeil, measureScope, arrayList, placeableArr, i24, i27, iArr, i25);
                    int width = measureResultMeasure.getWidth();
                    int height = measureResultMeasure.getHeight();
                    iArr2[i25] = height;
                    i26 += height;
                    iMax2 = Math.max(iMax2, width);
                    mutableVector.add(measureResultMeasure);
                    i25++;
                    i24 = i27;
                    iArr3 = iArr3;
                    mutableIntList2 = mutableIntList2;
                }
                if (mutableVector.size == 0) {
                    iMax2 = 0;
                    i = 0;
                } else {
                    i = i26;
                }
                Arrangement.Vertical vertical = flowMeasurePolicy.verticalArrangement;
                int iMo86roundToPx0680j_4 = ((mutableVector.size - 1) * measureScope.mo86roundToPx0680j_4(vertical.mo112getSpacingD9Ej5fM())) + i;
                int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(jM125constructorimpl2);
                int iM682getMaxHeightimpl3 = Constraints.m682getMaxHeightimpl(jM125constructorimpl2);
                if (iMo86roundToPx0680j_4 < iM684getMinHeightimpl) {
                    iMo86roundToPx0680j_4 = iM684getMinHeightimpl;
                }
                if (iMo86roundToPx0680j_4 <= iM682getMaxHeightimpl3) {
                    iM682getMaxHeightimpl3 = iMo86roundToPx0680j_4;
                }
                vertical.arrange(iM682getMaxHeightimpl3, measureScope, iArr2, iArr);
                int iM685getMinWidthimpl2 = Constraints.m685getMinWidthimpl(jM125constructorimpl2);
                int iM683getMaxWidthimpl2 = Constraints.m683getMaxWidthimpl(jM125constructorimpl2);
                if (iMax2 < iM685getMinWidthimpl2) {
                    iMax2 = iM685getMinWidthimpl2;
                }
                if (iMax2 <= iM683getMaxWidthimpl2) {
                    iM683getMaxWidthimpl2 = iMax2;
                }
                return measureScope.layout(iM683getMaxWidthimpl2, iM682getMaxHeightimpl3, emptyMap, new Recomposer$$ExternalSyntheticLambda0(7, mutableVector));
            }
            flowLayoutOverflowState.getClass();
        }
        return measureScope.layout(0, 0, emptyMap, new BasicTextKt$$ExternalSyntheticLambda3(8));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        ArrayList childrenOfVirtualChildren = HitTestResultKt.getChildrenOfVirtualChildren(intrinsicMeasureScope);
        FlowMeasurePolicy flowMeasurePolicy = this.measurePolicy;
        FlowLayoutOverflowState flowLayoutOverflowState = flowMeasurePolicy.overflow;
        List list2 = (List) CollectionsKt.getOrNull(1, childrenOfVirtualChildren);
        Measurable measurable = list2 != null ? (Measurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(2, childrenOfVirtualChildren);
        flowLayoutOverflowState.m116setOverflowMeasurableshBUhpc$foundation_layout(measurable, list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null, ConstraintsKt.Constraints$default(0, i, 0, 0, 13));
        List list4 = (List) CollectionsKt.firstOrNull(childrenOfVirtualChildren);
        if (list4 == null) {
            list4 = EmptyList.INSTANCE;
        }
        return FlowMeasurePolicy.intrinsicCrossAxisSize(list4, i, intrinsicMeasureScope.mo86roundToPx0680j_4(flowMeasurePolicy.mainAxisSpacing), intrinsicMeasureScope.mo86roundToPx0680j_4(flowMeasurePolicy.crossAxisArrangementSpacing), flowMeasurePolicy.overflow);
    }

    /* JADX WARN: Code duplicated, block: B:126:0x024c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0250 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x023d A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int[] iArr;
        int i2;
        long jM21constructorimpl;
        int i3;
        IntIntPair intIntPair;
        int i4;
        long jM21constructorimpl2;
        ArrayList childrenOfVirtualChildren = HitTestResultKt.getChildrenOfVirtualChildren(intrinsicMeasureScope);
        FlowMeasurePolicy flowMeasurePolicy = this.measurePolicy;
        FlowLayoutOverflowState flowLayoutOverflowState = flowMeasurePolicy.overflow;
        int i5 = 1;
        List list2 = (List) CollectionsKt.getOrNull(1, childrenOfVirtualChildren);
        Measurable measurable = list2 != null ? (Measurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(2, childrenOfVirtualChildren);
        int i6 = 0;
        flowLayoutOverflowState.m116setOverflowMeasurableshBUhpc$foundation_layout(measurable, list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null, ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        List list4 = (List) CollectionsKt.firstOrNull(childrenOfVirtualChildren);
        if (list4 == null) {
            list4 = EmptyList.INSTANCE;
        }
        int iMo86roundToPx0680j_4 = intrinsicMeasureScope.mo86roundToPx0680j_4(flowMeasurePolicy.mainAxisSpacing);
        int iMo86roundToPx0680j_5 = intrinsicMeasureScope.mo86roundToPx0680j_4(flowMeasurePolicy.crossAxisArrangementSpacing);
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowMeasurePolicy.overflow;
        if (list4.isEmpty()) {
            return 0;
        }
        int size = list4.size();
        int[] iArr2 = new int[size];
        int size2 = list4.size();
        int[] iArr3 = new int[size2];
        int size3 = list4.size();
        for (int i7 = 0; i7 < size3; i7++) {
            Measurable measurable2 = (Measurable) list4.get(i7);
            int iMinIntrinsicWidth = measurable2.minIntrinsicWidth(i);
            iArr2[i7] = iMinIntrinsicWidth;
            iArr3[i7] = measurable2.minIntrinsicHeight(iMinIntrinsicWidth);
        }
        int i8 = Integer.MAX_VALUE;
        if (Integer.MAX_VALUE < list4.size()) {
            flowLayoutOverflowState2.getClass();
        }
        if (Integer.MAX_VALUE >= list4.size()) {
            flowLayoutOverflowState2.getClass();
        }
        int iMin = Math.min(Integer.MAX_VALUE, list4.size());
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += iArr2[i10];
        }
        int size4 = ((list4.size() - 1) * iMo86roundToPx0680j_4) + i9;
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int i11 = iArr3[0];
        int i12 = size2 - 1;
        if (1 <= i12) {
            int i13 = 1;
            while (true) {
                int i14 = iArr3[i13];
                if (i11 < i14) {
                    i11 = i14;
                }
                if (i13 == i12) {
                    break;
                }
                i13++;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i15 = iArr2[0];
        int i16 = size - 1;
        if (1 <= i16) {
            int i17 = 1;
            while (true) {
                int i18 = iArr2[i17];
                if (i15 < i18) {
                    i15 = i18;
                }
                if (i17 == i16) {
                    break;
                }
                i17++;
            }
        }
        int i19 = size4;
        while (i15 <= i19 && i11 != i) {
            int i20 = (i15 + i19) / 2;
            if (list4.isEmpty()) {
                jM21constructorimpl2 = IntIntPair.m21constructorimpl(i6, i6);
                iArr = iArr3;
            } else {
                FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(flowLayoutOverflowState2, ConstraintsKt.Constraints(i6, i20, i6, i8), iMo86roundToPx0680j_4, iMo86roundToPx0680j_5);
                Measurable measurable3 = (Measurable) CollectionsKt.getOrNull(i6, list4);
                int i21 = measurable3 != null ? iArr3[i6] : i6;
                int i22 = measurable3 != null ? iArr2[i6] : i6;
                iArr = iArr3;
                int i23 = 0;
                int i24 = 0;
                if (flowLayoutBuildingBlocks.m114getWrapInfoOpUlnko(list4.size() > i5 ? i5 : 0, 0, IntIntPair.m21constructorimpl(i20, i8), measurable3 == null ? null : new IntIntPair(IntIntPair.m21constructorimpl(i22, i21)), 0, 0, 0, false, false).isLastItemInContainer) {
                    IntIntPair intIntPairM115ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState2.m115ellipsisSizeF35zmw$foundation_layout(0, 0, measurable3 != null);
                    jM21constructorimpl2 = IntIntPair.m21constructorimpl(intIntPairM115ellipsisSizeF35zmw$foundation_layout != null ? (int) (intIntPairM115ellipsisSizeF35zmw$foundation_layout.packedValue & 4294967295L) : 0, 0);
                } else {
                    int size5 = list4.size();
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 0;
                    int i28 = i20;
                    int i29 = 0;
                    while (true) {
                        if (i25 >= size5) {
                            list4 = list4;
                            i2 = i26;
                            break;
                        }
                        int i30 = i28 - i22;
                        i2 = i25 + 1;
                        int iMax = Math.max(i29, i21);
                        Measurable measurable4 = (Measurable) CollectionsKt.getOrNull(i2, list4);
                        i21 = measurable4 != null ? iArr[i2] : 0;
                        int i31 = measurable4 != null ? iArr2[i2] + iMo86roundToPx0680j_4 : 0;
                        boolean z = i25 + 2 < list4.size();
                        int i32 = i2 - i27;
                        long jM21constructorimpl3 = IntIntPair.m21constructorimpl(i30, Integer.MAX_VALUE);
                        if (measurable4 == null) {
                            i3 = i31;
                            intIntPair = null;
                        } else {
                            i3 = i31;
                            intIntPair = new IntIntPair(IntIntPair.m21constructorimpl(i3, i21));
                        }
                        FlowLayoutBuildingBlocks.WrapInfo wrapInfoM114getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m114getWrapInfoOpUlnko(z, i32, jM21constructorimpl3, intIntPair, i23, i24, iMax, false, false);
                        if (wrapInfoM114getWrapInfoOpUlnko.isLastItemInLine) {
                            int i33 = iMax + iMo86roundToPx0680j_5 + i24;
                            int i34 = i23;
                            FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM114getWrapInfoOpUlnko, measurable4 != null, i34, i33, i30, i32);
                            int i35 = i3 - iMo86roundToPx0680j_4;
                            i23 = i34 + 1;
                            if (wrapInfoM114getWrapInfoOpUlnko.isLastItemInContainer) {
                                if (wrapEllipsisInfo != null) {
                                    long j = wrapEllipsisInfo.ellipsisSize;
                                    if (!wrapEllipsisInfo.placeEllipsisOnLastContentLine) {
                                        i33 = ((int) (j & 4294967295L)) + iMo86roundToPx0680j_5 + i33;
                                    }
                                }
                                i24 = i33;
                                break;
                            }
                            i27 = i2;
                            i4 = i20;
                            i22 = i35;
                            i24 = i33;
                            i29 = 0;
                        } else {
                            i4 = i30;
                            i22 = i3;
                            i29 = iMax;
                        }
                        i25 = i2;
                        i26 = i25;
                        i28 = i4;
                        list4 = list4;
                    }
                    jM21constructorimpl = IntIntPair.m21constructorimpl(i24 - iMo86roundToPx0680j_5, i2);
                }
                i11 = (int) (jM21constructorimpl >> 32);
                int i36 = (int) (jM21constructorimpl & 4294967295L);
                if (i11 <= i || i36 < iMin) {
                    i15 = i20 + 1;
                    if (i15 > i19) {
                        return i15;
                    }
                } else {
                    if (i11 >= i) {
                        return i20;
                    }
                    i19 = i20 - 1;
                }
                iArr3 = iArr;
                size4 = i20;
                list4 = list4;
                i5 = 1;
                i8 = Integer.MAX_VALUE;
                i6 = 0;
            }
            jM21constructorimpl = jM21constructorimpl2;
            i11 = (int) (jM21constructorimpl >> 32);
            int i37 = (int) (jM21constructorimpl & 4294967295L);
            if (i11 <= i) {
                i15 = i20 + 1;
                if (i15 > i19) {
                    return i15;
                }
            } else {
                i15 = i20 + 1;
                if (i15 > i19) {
                    return i15;
                }
            }
            iArr3 = iArr;
            size4 = i20;
            list4 = list4;
            i5 = 1;
            i8 = Integer.MAX_VALUE;
            i6 = 0;
        }
        return size4;
    }

    public final String toString() {
        return "MultiContentMeasurePolicyImpl(measurePolicy=" + this.measurePolicy + ')';
    }
}
