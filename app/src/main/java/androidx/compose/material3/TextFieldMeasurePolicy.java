package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import coil.network.HttpException;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldMeasurePolicy implements MeasurePolicy {
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 affixAlpha;
    public final TextFieldLabelPosition$Attached labelPosition;
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 labelProgress;
    public final float minimizedLabelHalfHeight;
    public final PaddingValues paddingValues;
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 placeholderAlpha;
    public final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, TextFieldLabelPosition$Attached textFieldLabelPosition$Attached, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, PaddingValues paddingValues, float f) {
        this.singleLine = z;
        this.labelPosition = textFieldLabelPosition$Attached;
        this.labelProgress = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
        this.placeholderAlpha = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1;
        this.affixAlpha = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2;
        this.paddingValues = paddingValues;
        this.minimizedLabelHalfHeight = f;
    }

    public static int intrinsicWidth(List list, int i, Function2 function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj7 = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj7), "TextField")) {
                int iIntValue = ((Number) function2.invoke(obj7, Integer.valueOf(i))).intValue();
                int size2 = list.size();
                int i3 = 0;
                while (true) {
                    obj = null;
                    if (i3 >= size2) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj2), "Label")) {
                        break;
                    }
                    i3++;
                }
                Measurable measurable = (Measurable) obj2;
                int iIntValue2 = measurable != null ? ((Number) function2.invoke(measurable, Integer.valueOf(i))).intValue() : 0;
                int size3 = list.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size3) {
                        obj3 = null;
                        break;
                    }
                    obj3 = list.get(i4);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj3), "Trailing")) {
                        break;
                    }
                    i4++;
                }
                Measurable measurable2 = (Measurable) obj3;
                int iIntValue3 = measurable2 != null ? ((Number) function2.invoke(measurable2, Integer.valueOf(i))).intValue() : 0;
                int size4 = list.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size4) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list.get(i5);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj4), "Prefix")) {
                        break;
                    }
                    i5++;
                }
                Measurable measurable3 = (Measurable) obj4;
                int iIntValue4 = measurable3 != null ? ((Number) function2.invoke(measurable3, Integer.valueOf(i))).intValue() : 0;
                int size5 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size5) {
                        obj5 = null;
                        break;
                    }
                    obj5 = list.get(i6);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj5), "Suffix")) {
                        break;
                    }
                    i6++;
                }
                Measurable measurable4 = (Measurable) obj5;
                int iIntValue5 = measurable4 != null ? ((Number) function2.invoke(measurable4, Integer.valueOf(i))).intValue() : 0;
                int size6 = list.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size6) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list.get(i7);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj6), "Leading")) {
                        break;
                    }
                    i7++;
                }
                Measurable measurable5 = (Measurable) obj6;
                int iIntValue6 = measurable5 != null ? ((Number) function2.invoke(measurable5, Integer.valueOf(i))).intValue() : 0;
                int size7 = list.size();
                for (int i8 = 0; i8 < size7; i8++) {
                    Object obj8 = list.get(i8);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj8), "Hint")) {
                        obj = obj8;
                        break;
                    }
                }
                Measurable measurable6 = (Measurable) obj;
                int i9 = iIntValue4 + iIntValue5;
                return ConstraintsKt.m692constrainWidthK40F9xA(Math.max(iIntValue + i9, Math.max((measurable6 != null ? ((Number) function2.invoke(measurable6, Integer.valueOf(i))).intValue() : 0) + i9, iIntValue2)) + iIntValue6 + iIntValue3, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15));
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new HttpException();
    }

    public static final int placeWithoutLabel$calculateVerticalPosition(TextFieldMeasurePolicy textFieldMeasurePolicy, int i, int i2, Placeable placeable) {
        if (!textFieldMeasurePolicy.singleLine) {
            return i2;
        }
        return Math.round((1 + 0.0f) * ((i - placeable.height) / 2.0f));
    }

    /* JADX INFO: renamed from: calculateHeight-mKXJcVc$1, reason: not valid java name */
    public final int m274calculateHeightmKXJcVc$1(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, float f) {
        PaddingValues paddingValues = this.paddingValues;
        int iMo86roundToPx0680j_4 = intrinsicMeasureScope.mo86roundToPx0680j_4(paddingValues.mo117calculateBottomPaddingD9Ej5fM() + paddingValues.mo120calculateTopPaddingD9Ej5fM());
        int[] iArr = {i7, i5, i6, MathHelpersKt.lerp(f, i2, 0)};
        for (int i9 = 0; i9 < 4; i9++) {
            i = Math.max(i, iArr[i9]);
        }
        return ConstraintsKt.m691constrainHeightK40F9xA(Math.max(i3, Math.max(i4, iMo86roundToPx0680j_4 + (i2 > 0 ? Math.max(intrinsicMeasureScope.mo86roundToPx0680j_4(this.minimizedLabelHalfHeight * 2), MathHelpersKt.lerp(MotionTokens.EasingEmphasizedAccelerateCubicBezier.transform(f), 0, i2)) : 0) + i)) + i8, j);
    }

    public final int intrinsicHeight$1(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i, Function2 function2) {
        Object obj;
        int i2;
        int iIntValue;
        int iSubtractConstraintSafely;
        Object obj2;
        int iIntValue2;
        Object obj3;
        Object obj4;
        int i3;
        Object obj5;
        int i4;
        Object obj6;
        Object obj7;
        int size = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i5);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj), "Leading")) {
                break;
            }
            i5++;
        }
        Measurable measurable = (Measurable) obj;
        if (measurable != null) {
            i2 = i;
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(i2, measurable.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = ((Number) function2.invoke(measurable, Integer.valueOf(i2))).intValue();
        } else {
            i2 = i;
            iIntValue = 0;
            iSubtractConstraintSafely = i2;
        }
        int size2 = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i6);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj2), "Trailing")) {
                break;
            }
            i6++;
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, measurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = ((Number) function2.invoke(measurable2, Integer.valueOf(i2))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i7);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj3), "Label")) {
                break;
            }
            i7++;
        }
        Object obj8 = (Measurable) obj3;
        int iIntValue3 = obj8 != null ? ((Number) function2.invoke(obj8, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
        int size4 = list.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i8);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj4), "Prefix")) {
                break;
            }
            i8++;
        }
        Measurable measurable3 = (Measurable) obj4;
        if (measurable3 != null) {
            int iIntValue4 = ((Number) function2.invoke(measurable3, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, measurable3.maxIntrinsicWidth(Integer.MAX_VALUE));
            i3 = iIntValue4;
        } else {
            i3 = 0;
        }
        int size5 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size5) {
                obj5 = null;
                break;
            }
            obj5 = list.get(i9);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj5), "Suffix")) {
                break;
            }
            i9++;
        }
        Measurable measurable4 = (Measurable) obj5;
        if (measurable4 != null) {
            int iIntValue5 = ((Number) function2.invoke(measurable4, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, measurable4.maxIntrinsicWidth(Integer.MAX_VALUE));
            i4 = iIntValue5;
        } else {
            i4 = 0;
        }
        int size6 = list.size();
        for (int i10 = 0; i10 < size6; i10++) {
            Object obj9 = list.get(i10);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj9), "TextField")) {
                int iIntValue6 = ((Number) function2.invoke(obj9, Integer.valueOf(iSubtractConstraintSafely))).intValue();
                int size7 = list.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size7) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list.get(i11);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj6), "Hint")) {
                        break;
                    }
                    i11++;
                }
                Object obj10 = (Measurable) obj6;
                int iIntValue7 = obj10 != null ? ((Number) function2.invoke(obj10, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
                int size8 = list.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list.get(i12);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj7), "Supporting")) {
                        break;
                    }
                    i12++;
                }
                Object obj11 = (Measurable) obj7;
                return m274calculateHeightmKXJcVc$1(intrinsicMeasureScope, iIntValue6, iIntValue3, iIntValue, iIntValue2, i3, i4, iIntValue7, obj11 != null ? ((Number) function2.invoke(obj11, Integer.valueOf(i2))).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), this.labelProgress.invoke());
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new HttpException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicHeight$1(intrinsicMeasureScope, list, i, new SaversKt$$ExternalSyntheticLambda0(22));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicWidth(list, i, new SaversKt$$ExternalSyntheticLambda0(20));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo24measure3p2s80s(final MeasureScope measureScope, List list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        int i;
        Object obj6;
        Object obj7;
        Placeable placeable;
        int i2;
        float f;
        int i3;
        int i4;
        float fInvoke = this.labelProgress.invoke();
        PaddingValues paddingValues = this.paddingValues;
        final int iMo86roundToPx0680j_4 = measureScope.mo86roundToPx0680j_4(paddingValues.mo120calculateTopPaddingD9Ej5fM());
        int iMo86roundToPx0680j_5 = measureScope.mo86roundToPx0680j_4(paddingValues.mo117calculateBottomPaddingD9Ej5fM());
        long jM676copyZbe2FdA$default = Constraints.m676copyZbe2FdA$default(j, 0, 0, 0, 0, 10);
        int size = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i5);
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj), "Leading")) {
                break;
            }
            i5++;
        }
        Measurable measurable = (Measurable) obj;
        Placeable placeableMo517measureBRTryo0 = measurable != null ? measurable.mo517measureBRTryo0(jM676copyZbe2FdA$default) : null;
        int i6 = placeableMo517measureBRTryo0 != null ? placeableMo517measureBRTryo0.width : 0;
        int iMax = Math.max(0, placeableMo517measureBRTryo0 != null ? placeableMo517measureBRTryo0.height : 0);
        int size2 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i7);
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj2), "Trailing")) {
                break;
            }
            i7++;
        }
        Measurable measurable2 = (Measurable) obj2;
        Placeable placeableMo517measureBRTryo1 = measurable2 != null ? measurable2.mo517measureBRTryo0(ConstraintsKt.m694offsetNN6EwU$default(-i6, 0, 2, jM676copyZbe2FdA$default)) : null;
        int i8 = i6 + (placeableMo517measureBRTryo1 != null ? placeableMo517measureBRTryo1.width : 0);
        int iMax2 = Math.max(iMax, placeableMo517measureBRTryo1 != null ? placeableMo517measureBRTryo1.height : 0);
        int size3 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i9);
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj3), "Prefix")) {
                break;
            }
            i9++;
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable placeableMo517measureBRTryo2 = measurable3 != null ? measurable3.mo517measureBRTryo0(ConstraintsKt.m694offsetNN6EwU$default(-i8, 0, 2, jM676copyZbe2FdA$default)) : null;
        int i10 = (placeableMo517measureBRTryo2 != null ? placeableMo517measureBRTryo2.width : 0) + i8;
        int iMax3 = Math.max(iMax2, placeableMo517measureBRTryo2 != null ? placeableMo517measureBRTryo2.height : 0);
        int size4 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i11);
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj4), "Suffix")) {
                break;
            }
            i11++;
        }
        Measurable measurable4 = (Measurable) obj4;
        Placeable placeableMo517measureBRTryo3 = measurable4 != null ? measurable4.mo517measureBRTryo0(ConstraintsKt.m694offsetNN6EwU$default(-i10, 0, 2, jM676copyZbe2FdA$default)) : null;
        int i12 = i10 + (placeableMo517measureBRTryo3 != null ? placeableMo517measureBRTryo3.width : 0);
        int iMax4 = Math.max(iMax3, placeableMo517measureBRTryo3 != null ? placeableMo517measureBRTryo3.height : 0);
        int size5 = list.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size5) {
                obj5 = null;
                break;
            }
            obj5 = list.get(i13);
            int i14 = size5;
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj5), "Label")) {
                break;
            }
            i13++;
            size5 = i14;
        }
        Measurable measurable5 = (Measurable) obj5;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        int i15 = -i12;
        ref$ObjectRef.element = measurable5 != null ? measurable5.mo517measureBRTryo0(ConstraintsKt.m693offsetNN6EwU(i15, -iMo86roundToPx0680j_5, jM676copyZbe2FdA$default)) : null;
        int size6 = list.size();
        int i16 = 0;
        while (true) {
            if (i16 >= size6) {
                i = iMo86roundToPx0680j_5;
                obj6 = null;
                break;
            }
            obj6 = list.get(i16);
            i = iMo86roundToPx0680j_5;
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj6), "Supporting")) {
                break;
            }
            i16++;
            iMo86roundToPx0680j_5 = i;
        }
        Measurable measurable6 = (Measurable) obj6;
        int iMinIntrinsicHeight = measurable6 != null ? measurable6.minIntrinsicHeight(Constraints.m685getMinWidthimpl(j)) : 0;
        Placeable placeable2 = (Placeable) ref$ObjectRef.element;
        int i17 = iMo86roundToPx0680j_4 + (placeable2 != null ? placeable2.height : 0);
        long jM693offsetNN6EwU = ConstraintsKt.m693offsetNN6EwU(i15, ((-i17) - i) - iMinIntrinsicHeight, Constraints.m676copyZbe2FdA$default(j, 0, 0, 0, 0, 11));
        int size7 = list.size();
        int i18 = 0;
        while (i18 < size7) {
            int i19 = i17;
            Measurable measurable7 = (Measurable) list.get(i18);
            int i20 = size7;
            float f2 = fInvoke;
            if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable7), "TextField")) {
                final Placeable placeableMo517measureBRTryo4 = measurable7.mo517measureBRTryo0(jM693offsetNN6EwU);
                long jM676copyZbe2FdA$default2 = Constraints.m676copyZbe2FdA$default(jM693offsetNN6EwU, 0, 0, 0, 0, 14);
                int size8 = list.size();
                int i21 = 0;
                while (true) {
                    if (i21 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list.get(i21);
                    int i22 = size8;
                    int i23 = i21;
                    if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj7), "Hint")) {
                        break;
                    }
                    i21 = i23 + 1;
                    size8 = i22;
                }
                Measurable measurable8 = (Measurable) obj7;
                Placeable placeableMo517measureBRTryo5 = measurable8 != null ? measurable8.mo517measureBRTryo0(jM676copyZbe2FdA$default2) : null;
                int iMax5 = Math.max(iMax4, Math.max(placeableMo517measureBRTryo4.height, placeableMo517measureBRTryo5 != null ? placeableMo517measureBRTryo5.height : 0) + i19 + i);
                int i24 = placeableMo517measureBRTryo0 != null ? placeableMo517measureBRTryo0.width : 0;
                int i25 = placeableMo517measureBRTryo1 != null ? placeableMo517measureBRTryo1.width : 0;
                int i26 = placeableMo517measureBRTryo2 != null ? placeableMo517measureBRTryo2.width : 0;
                int i27 = placeableMo517measureBRTryo3 != null ? placeableMo517measureBRTryo3.width : 0;
                int i28 = i25;
                int i29 = placeableMo517measureBRTryo4.width;
                Placeable placeable3 = (Placeable) ref$ObjectRef.element;
                int i30 = i26 + i27;
                final int iM692constrainWidthK40F9xA = ConstraintsKt.m692constrainWidthK40F9xA(Math.max(i29 + i30, Math.max((placeableMo517measureBRTryo5 != null ? placeableMo517measureBRTryo5.width : 0) + i30, placeable3 != null ? placeable3.width : 0)) + i24 + i28, j);
                Placeable placeableMo517measureBRTryo6 = measurable6 != null ? measurable6.mo517measureBRTryo0(Constraints.m676copyZbe2FdA$default(ConstraintsKt.m694offsetNN6EwU$default(0, -iMax5, 1, jM676copyZbe2FdA$default), 0, iM692constrainWidthK40F9xA, 0, 0, 9)) : null;
                int i31 = placeableMo517measureBRTryo6 != null ? placeableMo517measureBRTryo6.height : 0;
                int i32 = placeableMo517measureBRTryo4.height;
                Placeable placeable4 = (Placeable) ref$ObjectRef.element;
                int i33 = placeable4 != null ? placeable4.height : 0;
                int i34 = placeableMo517measureBRTryo0 != null ? placeableMo517measureBRTryo0.height : 0;
                int i35 = placeableMo517measureBRTryo1 != null ? placeableMo517measureBRTryo1.height : 0;
                int i36 = placeableMo517measureBRTryo2 != null ? placeableMo517measureBRTryo2.height : 0;
                final Placeable placeable5 = placeableMo517measureBRTryo1;
                int i37 = placeableMo517measureBRTryo3 != null ? placeableMo517measureBRTryo3.height : 0;
                if (placeableMo517measureBRTryo5 != null) {
                    i2 = placeableMo517measureBRTryo5.height;
                    placeable = placeableMo517measureBRTryo0;
                } else {
                    placeable = placeableMo517measureBRTryo0;
                    i2 = 0;
                }
                if (placeableMo517measureBRTryo6 != null) {
                    f = f2;
                    i3 = placeableMo517measureBRTryo6.height;
                    i4 = 0;
                } else {
                    f = f2;
                    i3 = 0;
                    i4 = 0;
                }
                final int iM274calculateHeightmKXJcVc$1 = m274calculateHeightmKXJcVc$1(measureScope, i32, i33, i34, i35, i36, i37, i2, i3, j, f);
                final int i38 = iM274calculateHeightmKXJcVc$1 - i31;
                int size9 = list.size();
                for (int i39 = i4; i39 < size9; i39++) {
                    Measurable measurable9 = (Measurable) list.get(i39);
                    if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable9), "Container")) {
                        final Placeable placeableMo517measureBRTryo7 = measurable9.mo517measureBRTryo0(ConstraintsKt.Constraints(iM692constrainWidthK40F9xA != 2147483647 ? iM692constrainWidthK40F9xA : i4, iM692constrainWidthK40F9xA, i38 != Integer.MAX_VALUE ? i38 : i4, i38));
                        final Placeable placeable6 = placeable;
                        final Placeable placeable7 = placeableMo517measureBRTryo2;
                        final Placeable placeable8 = placeableMo517measureBRTryo5;
                        final Placeable placeable9 = placeableMo517measureBRTryo6;
                        final float f3 = f;
                        final Placeable placeable10 = placeableMo517measureBRTryo3;
                        return measureScope.layout(iM692constrainWidthK40F9xA, iM274calculateHeightmKXJcVc$1, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$$ExternalSyntheticLambda2
                            /* JADX WARN: Code duplicated, block: B:20:0x00a9  */
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj8) {
                                int i40;
                                int iM695$default$roundToPx0680j_4;
                                int i41;
                                Placeable placeable11;
                                int i42;
                                TextFieldMeasurePolicy textFieldMeasurePolicy = this;
                                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 = textFieldMeasurePolicy.affixAlpha;
                                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1 = textFieldMeasurePolicy.placeholderAlpha;
                                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj8;
                                Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                                Object obj9 = ref$ObjectRef2.element;
                                int i43 = iM692constrainWidthK40F9xA;
                                int i44 = iM274calculateHeightmKXJcVc$1;
                                Placeable placeable12 = placeableMo517measureBRTryo4;
                                Placeable placeable13 = placeable8;
                                Placeable placeable14 = placeable6;
                                Placeable placeable15 = placeable5;
                                Placeable placeable16 = placeable7;
                                Placeable placeable17 = placeable10;
                                Placeable placeable18 = placeableMo517measureBRTryo7;
                                Placeable placeable19 = placeable9;
                                if (obj9 != null) {
                                    boolean z = textFieldMeasurePolicy.singleLine;
                                    int i45 = iMo86roundToPx0680j_4;
                                    if (z) {
                                        iM695$default$roundToPx0680j_4 = Math.round((1 + 0.0f) * ((i38 - ((Placeable) obj9).height) / 2.0f));
                                    } else {
                                        float f4 = textFieldMeasurePolicy.minimizedLabelHalfHeight;
                                        placementScope.getClass();
                                        iM695$default$roundToPx0680j_4 = Density.CC.m695$default$roundToPx0680j_4(placementScope, f4) + i45;
                                    }
                                    Placeable placeable20 = (Placeable) ref$ObjectRef2.element;
                                    int i46 = placeable20.height + i45;
                                    LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                                    TextFieldLabelPosition$Attached textFieldLabelPosition$Attached = textFieldMeasurePolicy.labelPosition;
                                    Placeable.PlacementScope.place$default(placementScope, placeable18, 0, 0);
                                    int i47 = i44 - (placeable19 != null ? placeable19.height : 0);
                                    if (placeable14 != null) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable14, 0, Math.round((1 + 0.0f) * ((i47 - placeable14.height) / 2.0f)));
                                    }
                                    float f5 = f3;
                                    int iLerp = MathHelpersKt.lerp(f5, iM695$default$roundToPx0680j_4, i45);
                                    if (layoutDirection == LayoutDirection.Ltr) {
                                        if (placeable14 != null) {
                                            i41 = placeable14.width;
                                        } else {
                                            i41 = 0;
                                        }
                                    } else if (placeable15 != null) {
                                        i41 = placeable15.width;
                                    } else {
                                        i41 = 0;
                                    }
                                    float f6 = TextFieldImplKt.TextFieldPadding;
                                    Placeable.PlacementScope.place$default(placementScope, placeable20, MathHelpersKt.lerp(f5, textFieldLabelPosition$Attached.expandedAlignment.align(placeable20.width, (i43 - (placeable14 != null ? placeable14.width : 0)) - (placeable15 != null ? placeable15.width : 0), layoutDirection) + i41, ((BiasAlignment.Horizontal) TextFieldImplKt.getMinimizedAlignment(textFieldLabelPosition$Attached)).align(placeable20.width, (i43 - (placeable14 != null ? placeable14.width : 0)) - (placeable15 != null ? placeable15.width : 0), layoutDirection) + i41), iLerp);
                                    if (placeable16 != null) {
                                        placeable11 = placeable16;
                                        i42 = i46;
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable11, placeable14 != null ? placeable14.width : 0, i42, new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, 0), 4);
                                    } else {
                                        placeable11 = placeable16;
                                        i42 = i46;
                                    }
                                    int i48 = (placeable14 != null ? placeable14.width : 0) + (placeable11 != null ? placeable11.width : 0);
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable12, i48, i42);
                                    if (placeable13 != null) {
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable13, i48, i42, new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, 5), 4);
                                    }
                                    if (placeable17 != null) {
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable17, (i43 - (placeable15 != null ? placeable15.width : 0)) - placeable17.width, i42, new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, 6), 4);
                                    }
                                    if (placeable15 != null) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable15, i43 - placeable15.width, Math.round((1 + 0.0f) * ((i47 - placeable15.height) / 2.0f)));
                                    }
                                    if (placeable19 != 0) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable19, 0, i47);
                                    }
                                } else {
                                    float density = placementScope.getDensity();
                                    Placeable.PlacementScope.m536place70tqf50$default(placementScope, placeable18, 0L);
                                    int i49 = i44 - (placeable19 != null ? placeable19.height : 0);
                                    int iRoundToInt = MathKt.roundToInt(textFieldMeasurePolicy.paddingValues.mo120calculateTopPaddingD9Ej5fM() * density);
                                    if (placeable14 != null) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable14, 0, Math.round((1 + 0.0f) * ((i49 - placeable14.height) / 2.0f)));
                                    }
                                    if (placeable16 != null) {
                                        i40 = iRoundToInt;
                                        placementScope = placementScope;
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable16, placeable14 != null ? placeable14.width : 0, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(textFieldMeasurePolicy, i49, iRoundToInt, placeable16), new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, 7), 4);
                                    } else {
                                        i40 = iRoundToInt;
                                    }
                                    int i50 = (placeable14 != null ? placeable14.width : 0) + (placeable16 != null ? placeable16.width : 0);
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable12, i50, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(textFieldMeasurePolicy, i49, i40, placeable12));
                                    if (placeable13 != null) {
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable13, i50, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(textFieldMeasurePolicy, i49, i40, placeable13), new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, 8), 4);
                                    }
                                    if (placeable17 != null) {
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable17, (i43 - (placeable15 != null ? placeable15.width : 0)) - placeable17.width, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(textFieldMeasurePolicy, i49, i40, placeable17), new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, 4), 4);
                                    }
                                    if (placeable15 != null) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable15, i43 - placeable15.width, Math.round((1 + 0.0f) * ((i49 - placeable15.height) / 2.0f)));
                                    }
                                    if (r0 != 0) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable19, 0, i49);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new HttpException();
            }
            fInvoke = f2;
            i18++;
            size7 = i20;
            i17 = i19;
            jM693offsetNN6EwU = jM693offsetNN6EwU;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new HttpException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicHeight$1(intrinsicMeasureScope, list, i, new SaversKt$$ExternalSyntheticLambda0(21));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicWidth(list, i, new SaversKt$$ExternalSyntheticLambda0(19));
    }
}
