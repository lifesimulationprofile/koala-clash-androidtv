package androidx.compose.material3;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import coil.network.HttpException;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarMeasurePolicy implements MeasurePolicy {
    public final PaddingValues contentPadding;
    public final float height;
    public final FloatProducer scrolledOffset;
    public final Arrangement.Vertical titleVerticalArrangement;

    public TopAppBarMeasurePolicy(FloatProducer floatProducer, Arrangement.Vertical vertical, float f, PaddingValues paddingValues) {
        this.scrolledOffset = floatProducer;
        this.titleVerticalArrangement = vertical;
        this.height = f;
        this.contentPadding = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer num;
        int iMo86roundToPx0680j_4 = intrinsicMeasureScope.mo86roundToPx0680j_4(this.height);
        if (list.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf = Integer.valueOf(((Measurable) list.get(0)).maxIntrinsicHeight(i));
            int lastIndex = AppCompatHintHelper.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Measurable) list.get(i2)).maxIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            num = numValueOf;
        }
        return Math.max(iMo86roundToPx0680j_4, num != null ? num.intValue() : 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int size = list.size();
        int iMaxIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMaxIntrinsicWidth += ((Measurable) list.get(i2)).maxIntrinsicWidth(i);
        }
        return iMaxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, final long j) {
        int iM683getMaxWidthimpl;
        int i;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable = (Measurable) list.get(i2);
            if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable), "navigationIcon")) {
                final Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(Constraints.m676copyZbe2FdA$default(j, 0, 0, 0, 0, 14));
                int size2 = list.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable2 = (Measurable) list.get(i3);
                    if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable2), "actionIcons")) {
                        final Placeable placeableMo517measureBRTryo1 = measurable2.mo517measureBRTryo0(Constraints.m676copyZbe2FdA$default(j, 0, 0, 0, 0, 14));
                        LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                        PaddingValues paddingValues = this.contentPadding;
                        float fCalculateStartPadding = OffsetKt.calculateStartPadding(paddingValues, layoutDirection);
                        float fCalculateEndPadding = OffsetKt.calculateEndPadding(paddingValues, measureScope.getLayoutDirection());
                        int iMax = Math.max(measureScope.mo86roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeableMo517measureBRTryo0.width);
                        if (Constraints.m683getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                            iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
                        } else {
                            int iM683getMaxWidthimpl2 = (((Constraints.m683getMaxWidthimpl(j) - iMax) - placeableMo517measureBRTryo1.width) - measureScope.mo86roundToPx0680j_4(fCalculateStartPadding)) - measureScope.mo86roundToPx0680j_4(fCalculateEndPadding);
                            iM683getMaxWidthimpl = iM683getMaxWidthimpl2 < 0 ? 0 : iM683getMaxWidthimpl2;
                        }
                        int i4 = iM683getMaxWidthimpl;
                        int size3 = list.size();
                        int i5 = 0;
                        while (i5 < size3) {
                            Measurable measurable3 = (Measurable) list.get(i5);
                            if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable3), "title")) {
                                final Placeable placeableMo517measureBRTryo2 = measurable3.mo517measureBRTryo0(Constraints.m676copyZbe2FdA$default(j, 0, i4, 0, 0, 12));
                                HorizontalAlignmentLine horizontalAlignmentLine = AlignmentLineKt.LastBaseline;
                                final int i6 = placeableMo517measureBRTryo2.get(horizontalAlignmentLine) != Integer.MIN_VALUE ? placeableMo517measureBRTryo2.get(horizontalAlignmentLine) : 0;
                                float fInvoke = this.scrolledOffset.invoke();
                                int iRoundToInt = Float.isNaN(fInvoke) ? 0 : MathKt.roundToInt(fInvoke);
                                final int iMax2 = Math.max(measureScope.mo86roundToPx0680j_4(this.height), placeableMo517measureBRTryo2.height) + measureScope.mo86roundToPx0680j_4(paddingValues.mo120calculateTopPaddingD9Ej5fM()) + measureScope.mo86roundToPx0680j_4(paddingValues.mo117calculateBottomPaddingD9Ej5fM());
                                if (Constraints.m682getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                                    i = iMax2;
                                } else {
                                    int i7 = iRoundToInt + iMax2;
                                    i = i7 >= 0 ? i7 : 0;
                                }
                                int iMo86roundToPx0680j_4 = measureScope.mo86roundToPx0680j_4(paddingValues.mo120calculateTopPaddingD9Ej5fM());
                                int iMo86roundToPx0680j_5 = measureScope.mo86roundToPx0680j_4(paddingValues.mo117calculateBottomPaddingD9Ej5fM());
                                final int iMo86roundToPx0680j_6 = measureScope.mo86roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValues, measureScope.getLayoutDirection()));
                                final int iMo86roundToPx0680j_7 = measureScope.mo86roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValues, measureScope.getLayoutDirection()));
                                final int i8 = (iMo86roundToPx0680j_4 + i) - iMo86roundToPx0680j_5;
                                return measureScope.layout(Constraints.m683getMaxWidthimpl(j), i, EmptyMap.INSTANCE, new Function1(iMo86roundToPx0680j_6, i8, placeableMo517measureBRTryo2, placeableMo517measureBRTryo1, j, iMo86roundToPx0680j_7, this, i6, iMax2) { // from class: androidx.compose.material3.TopAppBarMeasurePolicy$$ExternalSyntheticLambda0
                                    public final /* synthetic */ int f$1;
                                    public final /* synthetic */ int f$2;
                                    public final /* synthetic */ Placeable f$3;
                                    public final /* synthetic */ Placeable f$4;
                                    public final /* synthetic */ long f$5;
                                    public final /* synthetic */ int f$6;
                                    public final /* synthetic */ TopAppBarMeasurePolicy f$7;

                                    /* JADX WARN: Code duplicated, block: B:11:0x0060  */
                                    /* JADX WARN: Code duplicated, block: B:12:0x0067  */
                                    /* JADX WARN: Code duplicated, block: B:14:0x006f  */
                                    /* JADX WARN: Code duplicated, block: B:15:0x0074  */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        int iM683getMaxWidthimpl3;
                                        Arrangement.Vertical vertical;
                                        int i9;
                                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                                        Placeable placeable = this.f$0;
                                        int i10 = placeable.height;
                                        int i11 = this.f$2;
                                        int i12 = this.f$1;
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i12, (i11 - i10) / 2);
                                        int iMax3 = Math.max(Density.CC.m695$default$roundToPx0680j_4(placementScope, AppBarKt.TopAppBarTitleInset), placeable.width);
                                        Placeable placeable2 = this.f$4;
                                        int i13 = placeable2.width;
                                        Placeable placeable3 = this.f$3;
                                        int i14 = placeable3.width;
                                        long j2 = this.f$5;
                                        int iRound = Math.round((1 - 1.0f) * ((Constraints.m683getMaxWidthimpl(j2) - i14) / 2.0f));
                                        if (iRound >= iMax3) {
                                            if (placeable3.width + iRound > Constraints.m683getMaxWidthimpl(j2) - i13) {
                                                iM683getMaxWidthimpl3 = (Constraints.m683getMaxWidthimpl(j2) - i13) - (placeable3.width + iRound);
                                            }
                                            vertical = this.f$7.titleVerticalArrangement;
                                            if (Intrinsics.areEqual(vertical, Arrangement.Center)) {
                                                i9 = (i11 - placeable3.height) / 2;
                                            } else if (Intrinsics.areEqual(vertical, Arrangement.Bottom)) {
                                                i9 = i11 - placeable3.height;
                                            } else {
                                                i9 = 0;
                                            }
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iRound, i9);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (Constraints.m683getMaxWidthimpl(j2) - placeable2.width) - this.f$6, (i11 - placeable2.height) / 2);
                                            return Unit.INSTANCE;
                                        }
                                        iM683getMaxWidthimpl3 = iMax3 - iRound;
                                        iRound += iM683getMaxWidthimpl3 + i12;
                                        vertical = this.f$7.titleVerticalArrangement;
                                        if (Intrinsics.areEqual(vertical, Arrangement.Center)) {
                                            i9 = (i11 - placeable3.height) / 2;
                                        } else if (Intrinsics.areEqual(vertical, Arrangement.Bottom)) {
                                            i9 = i11 - placeable3.height;
                                        } else {
                                            i9 = 0;
                                        }
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iRound, i9);
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (Constraints.m683getMaxWidthimpl(j2) - placeable2.width) - this.f$6, (i11 - placeable2.height) / 2);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            i5++;
                            this = this;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new HttpException();
                    }
                    i3++;
                    this = this;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new HttpException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new HttpException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer num;
        int iMo86roundToPx0680j_4 = intrinsicMeasureScope.mo86roundToPx0680j_4(this.height);
        if (list.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf = Integer.valueOf(((Measurable) list.get(0)).minIntrinsicHeight(i));
            int lastIndex = AppCompatHintHelper.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Measurable) list.get(i2)).minIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            num = numValueOf;
        }
        return Math.max(iMo86roundToPx0680j_4, num != null ? num.intValue() : 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int size = list.size();
        int iMinIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMinIntrinsicWidth += ((Measurable) list.get(i2)).minIntrinsicWidth(i);
        }
        return iMinIntrinsicWidth;
    }
}
