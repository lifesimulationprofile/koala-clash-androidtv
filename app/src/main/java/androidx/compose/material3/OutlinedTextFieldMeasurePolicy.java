package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import coil.network.HttpException;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 affixAlpha;
    public final float horizontalIconPadding;
    public final TextFieldLabelPosition$Attached labelPosition;
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 labelProgress;
    public final Function1 onLabelMeasured;
    public final PaddingValues paddingValues;
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 placeholderAlpha;
    public final boolean singleLine;

    public OutlinedTextFieldMeasurePolicy(Function1 function1, boolean z, TextFieldLabelPosition$Attached textFieldLabelPosition$Attached, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, PaddingValues paddingValues, float f) {
        this.onLabelMeasured = function1;
        this.singleLine = z;
        this.labelPosition = textFieldLabelPosition$Attached;
        this.labelProgress = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
        this.placeholderAlpha = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1;
        this.affixAlpha = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2;
        this.paddingValues = paddingValues;
        this.horizontalIconPadding = f;
    }

    public static final int place$calculateVerticalPosition(int i, OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy, int i2, int i3, Placeable placeable, Placeable placeable2) {
        if (outlinedTextFieldMeasurePolicy.singleLine) {
            i3 = Math.round((1 + 0.0f) * ((i2 - placeable2.height) / 2.0f));
        }
        return Math.max(i + i3, (placeable != null ? placeable.height : 0) / 2);
    }

    /* JADX INFO: renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public final int m254calculateHeightmKXJcVc(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, float f) {
        int[] iArr = {i7, i3, i4, MathHelpersKt.lerp(f, i6, 0)};
        for (int i9 = 0; i9 < 4; i9++) {
            i5 = Math.max(i5, iArr[i9]);
        }
        PaddingValues paddingValues = this.paddingValues;
        float fMo92toPx0680j_4 = intrinsicMeasureScope.mo92toPx0680j_4(paddingValues.mo120calculateTopPaddingD9Ej5fM());
        return ConstraintsKt.m691constrainHeightK40F9xA(Math.max(i, Math.max(i2, MathKt.roundToInt(MathHelpersKt.lerp(fMo92toPx0680j_4, Math.max(fMo92toPx0680j_4, i6 / 2.0f), f) + i5 + intrinsicMeasureScope.mo92toPx0680j_4(paddingValues.mo117calculateBottomPaddingD9Ej5fM())))) + i8, j);
    }

    /* JADX INFO: renamed from: calculateWidth-IzADHW4, reason: not valid java name */
    public final int m255calculateWidthIzADHW4(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, float f) {
        int i8 = i3 + i4;
        int iMax = Math.max(i5 + i8, Math.max(i7 + i8, MathHelpersKt.lerp(f, i6, 0))) + i + i2;
        PaddingValues paddingValues = this.paddingValues;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return ConstraintsKt.m692constrainWidthK40F9xA(Math.max(iMax, MathKt.roundToInt((i6 + intrinsicMeasureScope.mo92toPx0680j_4(paddingValues.mo119calculateRightPaddingu2uoSUM(layoutDirection) + paddingValues.mo118calculateLeftPaddingu2uoSUM(layoutDirection))) * f)), j);
    }

    public final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i, Function2 function2) {
        Object obj;
        int iSubtractConstraintSafely;
        int iIntValue;
        Object obj2;
        int iIntValue2;
        Object obj3;
        Object obj4;
        int iIntValue3;
        Object obj5;
        int iIntValue4;
        Object obj6;
        Object obj7;
        OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = this;
        float fInvoke = outlinedTextFieldMeasurePolicy.labelProgress.invoke();
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj), "Leading")) {
                break;
            }
            i2++;
        }
        Measurable measurable = (Measurable) obj;
        if (measurable != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(i, measurable.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = ((Number) function2.invoke(measurable, Integer.valueOf(i))).intValue();
        } else {
            iSubtractConstraintSafely = i;
            iIntValue = 0;
        }
        int size2 = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i3);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj2), "Trailing")) {
                break;
            }
            i3++;
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, measurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = ((Number) function2.invoke(measurable2, Integer.valueOf(i))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i4);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj3), "Label")) {
                break;
            }
            i4++;
        }
        Object obj8 = (Measurable) obj3;
        int iIntValue5 = obj8 != null ? ((Number) function2.invoke(obj8, Integer.valueOf(MathHelpersKt.lerp(fInvoke, iSubtractConstraintSafely, i)))).intValue() : 0;
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
        if (measurable3 != null) {
            iIntValue3 = ((Number) function2.invoke(measurable3, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, measurable3.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue3 = 0;
        }
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
        if (measurable4 != null) {
            iIntValue4 = ((Number) function2.invoke(measurable4, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, measurable4.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue4 = 0;
        }
        int size6 = list.size();
        int i7 = 0;
        while (i7 < size6) {
            Object obj9 = list.get(i7);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj9), "TextField")) {
                int iIntValue6 = ((Number) function2.invoke(obj9, Integer.valueOf(iSubtractConstraintSafely))).intValue();
                int size7 = list.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size7) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list.get(i8);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj6), "Hint")) {
                        break;
                    }
                    i8++;
                }
                Object obj10 = (Measurable) obj6;
                int iIntValue7 = obj10 != null ? ((Number) function2.invoke(obj10, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
                int size8 = list.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list.get(i9);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj7), "Supporting")) {
                        break;
                    }
                    i9++;
                }
                Object obj11 = (Measurable) obj7;
                return outlinedTextFieldMeasurePolicy.m254calculateHeightmKXJcVc(intrinsicMeasureScope, iIntValue, iIntValue2, iIntValue3, iIntValue4, iIntValue6, iIntValue5, iIntValue7, obj11 != null ? ((Number) function2.invoke(obj11, Integer.valueOf(i))).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), fInvoke);
            }
            i7++;
            iIntValue4 = iIntValue4;
            outlinedTextFieldMeasurePolicy = this;
            iIntValue3 = iIntValue3;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new HttpException();
    }

    public final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i, Function2 function2) {
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
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj4), "Leading")) {
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
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj5), "Prefix")) {
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
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId((Measurable) obj6), "Suffix")) {
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
                return m255calculateWidthIzADHW4(intrinsicMeasureScope, iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue, iIntValue2, measurable6 != null ? ((Number) function2.invoke(measurable6, Integer.valueOf(i))).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), this.labelProgress.invoke());
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new HttpException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new SaversKt$$ExternalSyntheticLambda0(16));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new SaversKt$$ExternalSyntheticLambda0(15));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v17 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final androidx.compose.ui.layout.MeasureResult mo24measure3p2s80s(androidx.compose.ui.layout.MeasureScope r44, java.util.List r45, long r46) {
        /*
            Method dump skipped, instruction units count: 1134
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.mo24measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new SaversKt$$ExternalSyntheticLambda0(14));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new SaversKt$$ExternalSyntheticLambda0(17));
    }
}
