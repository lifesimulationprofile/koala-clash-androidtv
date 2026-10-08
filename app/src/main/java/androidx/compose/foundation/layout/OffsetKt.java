package androidx.compose.foundation.layout;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.SheetWindowInsets;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyImpl;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupLayout$Content$4;
import androidx.core.graphics.Insets;
import coil.compose.AsyncImageKt$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class OffsetKt {
    public static final int End = 6;
    public static final int Horizontal = 15;
    public static final int Left = 10;
    public static final int Right = 5;
    public static final int Start = 9;

    /* JADX INFO: renamed from: Left, reason: collision with other field name */
    public static final FlowRowOverflow f2Left = new FlowRowOverflow(2);

    /* JADX INFO: renamed from: Right, reason: collision with other field name */
    public static final FlowRowOverflow f3Right = new FlowRowOverflow(3);
    public static final FixedIntInsets EmptyWindowInsets = new FixedIntInsets();
    public static final BasicTextKt$$ExternalSyntheticLambda3 imeLambda = new BasicTextKt$$ExternalSyntheticLambda3(11);
    public static final BasicTextKt$$ExternalSyntheticLambda3 navigationBarsLambda = new BasicTextKt$$ExternalSyntheticLambda3(12);

    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        Object obj;
        boolean z;
        Object obj2;
        Object obj3 = Alignment.Companion.Top;
        gapComposer.startRestartGroup(-1956591841);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(horizontal) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(vertical) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(obj3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(Integer.MAX_VALUE) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(Integer.MAX_VALUE) ? 131072 : 65536;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 4793491) != 4793490)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj4 = Composer$Companion.Empty;
            if (objRememberedValue == obj4) {
                objRememberedValue = new FlowLayoutOverflowState();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
            int i4 = i3 >> 3;
            boolean zChanged = ((((i4 & 896) ^ 384) > 256 && gapComposer.changed(obj3)) || (i4 & 384) == 256) | ((((i4 & 14) ^ 6) > 4 && gapComposer.changed(horizontal)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && gapComposer.changed(vertical)) || (i4 & 48) == 32) | ((((i4 & 7168) ^ 3072) > 2048 && gapComposer.changed(Integer.MAX_VALUE)) || (i4 & 3072) == 2048) | ((((57344 & i4) ^ 24576) > 16384 && gapComposer.changed(Integer.MAX_VALUE)) || (i4 & 24576) == 16384) | gapComposer.changed(flowLayoutOverflowState);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == obj4) {
                obj = obj4;
                Object flowMeasurePolicy = new FlowMeasurePolicy(horizontal, vertical, horizontal.mo112getSpacingD9Ej5fM(), new CrossAxisAlignment$VerticalCrossAxisAlignment(), vertical.mo112getSpacingD9Ej5fM(), flowLayoutOverflowState);
                gapComposer.updateRememberedValue(flowMeasurePolicy);
                objRememberedValue2 = flowMeasurePolicy;
            } else {
                obj = obj4;
            }
            FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue2;
            boolean z2 = ((i3 & 29360128) == 8388608) | ((i3 & 458752) == 131072);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (z2 || objRememberedValue3 == obj) {
                ArrayList arrayList = new ArrayList();
                z = true;
                arrayList.add(new ComposableLambdaImpl(-1192950673, new FlowLayoutKt$$ExternalSyntheticLambda0(composableLambdaImpl, 0), true));
                CaptureSession$State$EnumUnboxingLocalUtility.ordinal(2);
                gapComposer.updateRememberedValue(arrayList);
                obj2 = arrayList;
            } else {
                z = true;
                obj2 = objRememberedValue3;
            }
            ComposableLambdaImpl composableLambdaImpl2 = new ComposableLambdaImpl(1271844412, new PopupLayout$Content$4(3, (List) obj2), z);
            boolean zChanged2 = gapComposer.changed(flowMeasurePolicy2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == obj) {
                objRememberedValue4 = new MultiContentMeasurePolicyImpl(flowMeasurePolicy2);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue4;
            long j = gapComposer.compositeKeyHashCode;
            int i5 = (int) (j ^ (j >>> 32));
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
            Stack.m295setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl2.invoke((Object) gapComposer, (Object) 0);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda1(modifier, horizontal, vertical, composableLambdaImpl, i);
        }
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValuesImpl m121PaddingValuesYgX7TsA(float f, float f2) {
        return new PaddingValuesImpl(f, f2, f, f2);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static PaddingValuesImpl m122PaddingValuesYgX7TsA$default(int i, float f) {
        if ((i & 1) != 0) {
            f = 0;
        }
        float f2 = 0;
        return new PaddingValuesImpl(f, f2, f, f2);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValuesImpl m123PaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new PaddingValuesImpl(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static PaddingValuesImpl m124PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i) {
        if ((i & 1) != 0) {
            f = 0;
        }
        if ((i & 2) != 0) {
            f2 = 0;
        }
        if ((i & 4) != 0) {
            f3 = 0;
        }
        if ((i & 8) != 0) {
            f4 = 0;
        }
        return new PaddingValuesImpl(f, f2, f3, f4);
    }

    public static final void Spacer(GapComposer gapComposer, Modifier modifier) {
        SpacerMeasurePolicy spacerMeasurePolicy = SpacerMeasurePolicy.INSTANCE;
        long j = gapComposer.compositeKeyHashCode;
        int i = (int) (j ^ (j >>> 32));
        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        gapComposer.startReusableNode();
        if (gapComposer.inserting) {
            gapComposer.createNode(layoutNode$Companion$Constructor$1);
        } else {
            gapComposer.useNode();
        }
        Stack.m295setimpl(gapComposer, spacerMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
        Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
        Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
        Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
        gapComposer.end(true);
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo119calculateRightPaddingu2uoSUM(layoutDirection) : paddingValues.mo118calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo118calculateLeftPaddingu2uoSUM(layoutDirection) : paddingValues.mo119calculateRightPaddingu2uoSUM(layoutDirection);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m125constructorimpl(int i, long j) {
        return ConstraintsKt.Constraints(i == 1 ? Constraints.m685getMinWidthimpl(j) : Constraints.m684getMinHeightimpl(j), i == 1 ? Constraints.m683getMaxWidthimpl(j) : Constraints.m682getMaxHeightimpl(j), i == 1 ? Constraints.m684getMinHeightimpl(j) : Constraints.m685getMinWidthimpl(j), i == 1 ? Constraints.m682getMaxHeightimpl(j) : Constraints.m683getMaxWidthimpl(j));
    }

    public static final Modifier consumeWindowInsets(Modifier modifier, SheetWindowInsets sheetWindowInsets) {
        return modifier.then(new UnionInsetsConsumingModifierElement(sheetWindowInsets));
    }

    public static final RowColumnParentData getRowColumnParentData(Measurable measurable) {
        Object parentData = measurable.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    public static final float getWeight(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.weight;
        }
        return 0.0f;
    }

    public static final MeasureResult measure(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8) {
        int i9;
        float f;
        int i10;
        int i11;
        int i12;
        List list2 = list;
        long j = i5;
        int i13 = i7 - i6;
        int[] iArr2 = new int[i13];
        int i14 = i6;
        int iMax = 0;
        int i15 = 0;
        int i16 = 0;
        int iMin = 0;
        float f2 = 0.0f;
        while (i14 < i7) {
            Measurable measurable = (Measurable) list2.get(i14);
            float weight = getWeight(getRowColumnParentData(measurable));
            if (weight > 0.0f) {
                f2 += weight;
                i15++;
                i10 = i14;
            } else {
                int i17 = i3 - i16;
                Placeable placeableMo517measureBRTryo0 = placeableArr[i14];
                if (placeableMo517measureBRTryo0 == null) {
                    if (i3 == Integer.MAX_VALUE) {
                        i10 = i14;
                        i11 = i15;
                        i12 = Integer.MAX_VALUE;
                    } else {
                        i10 = i14;
                        i11 = i15;
                        i12 = i17 < 0 ? 0 : i17;
                    }
                    placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(rowColumnMeasurePolicy.mo113createConstraintsxF2OJ5Q(0, i12, i4, false));
                } else {
                    i10 = i14;
                    i11 = i15;
                }
                Placeable placeable = placeableMo517measureBRTryo0;
                int iMainAxisSize = rowColumnMeasurePolicy.mainAxisSize(placeable);
                int iCrossAxisSize = rowColumnMeasurePolicy.crossAxisSize(placeable);
                iArr2[i10 - i6] = iMainAxisSize;
                int i18 = i17 - iMainAxisSize;
                if (i18 < 0) {
                    i18 = 0;
                }
                iMin = Math.min(i5, i18);
                i16 += iMainAxisSize + iMin;
                iMax = Math.max(iMax, iCrossAxisSize);
                placeableArr[i10] = placeable;
                i15 = i11;
            }
            i14 = i10 + 1;
            j = j;
        }
        long j2 = j;
        int i19 = i15;
        if (i19 == 0) {
            i16 -= iMin;
            i9 = 0;
        } else {
            long j3 = ((long) (i19 - 1)) * j2;
            long jRound = ((long) ((i3 != Integer.MAX_VALUE ? i3 : i) - i16)) - j3;
            if (jRound < 0) {
                jRound = 0;
            }
            float f3 = jRound / f2;
            for (int i20 = i6; i20 < i7; i20++) {
                jRound -= (long) Math.round(getWeight(getRowColumnParentData((Measurable) list2.get(i20))) * f3);
            }
            int i21 = i6;
            int i22 = iMax;
            int i23 = 0;
            while (i21 < i7) {
                if (placeableArr[i21] == null) {
                    Measurable measurable2 = (Measurable) list2.get(i21);
                    f = f3;
                    RowColumnParentData rowColumnParentData = getRowColumnParentData(measurable2);
                    float weight2 = getWeight(rowColumnParentData);
                    if (weight2 <= 0.0f) {
                        InlineClassHelperKt.throwIllegalStateException("All weights <= 0 should have placeables");
                    }
                    int iSignum = Long.signum(jRound);
                    long j4 = jRound - ((long) iSignum);
                    int iMax2 = Math.max(0, Math.round(weight2 * f) + iSignum);
                    Placeable placeableMo517measureBRTryo1 = measurable2.mo517measureBRTryo0(rowColumnMeasurePolicy.mo113createConstraintsxF2OJ5Q((!(rowColumnParentData != null ? rowColumnParentData.fill : true) || iMax2 == Integer.MAX_VALUE) ? 0 : iMax2, iMax2, i4, true));
                    int iMainAxisSize2 = rowColumnMeasurePolicy.mainAxisSize(placeableMo517measureBRTryo1);
                    int iCrossAxisSize2 = rowColumnMeasurePolicy.crossAxisSize(placeableMo517measureBRTryo1);
                    iArr2[i21 - i6] = iMainAxisSize2;
                    i23 += iMainAxisSize2;
                    int iMax3 = Math.max(i22, iCrossAxisSize2);
                    placeableArr[i21] = placeableMo517measureBRTryo1;
                    i22 = iMax3;
                    jRound = j4;
                } else {
                    f = f3;
                }
                i21++;
                list2 = list;
                f3 = f;
            }
            i9 = (int) (((long) i23) + j3);
            int i24 = i3 - i16;
            if (i9 < 0) {
                i9 = 0;
            }
            if (i9 > i24) {
                i9 = i24;
            }
            iMax = i22;
        }
        int i25 = i9 + i16;
        if (i25 < 0) {
            i25 = 0;
        }
        int iMax4 = Math.max(i25, i);
        int iMax5 = Math.max(iMax, Math.max(i2, 0));
        int[] iArr3 = new int[i13];
        rowColumnMeasurePolicy.populateMainAxisPositions(iMax4, measureScope, iArr2, iArr3);
        return rowColumnMeasurePolicy.placeHelper(placeableArr, measureScope, iArr3, iMax4, iMax5, iArr, i8, i6, i7);
    }

    /* JADX INFO: renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final void m127measureAndCacherqJ1uqs(Measurable measurable, FlowMeasurePolicy flowMeasurePolicy, long j, Function1 function1) {
        if (getWeight(getRowColumnParentData(measurable)) != 0.0f) {
            flowMeasurePolicy.getClass();
            measurable.minIntrinsicHeight(measurable.minIntrinsicWidth(Integer.MAX_VALUE));
            return;
        }
        getRowColumnParentData(measurable);
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(j);
        function1.invoke(placeableMo517measureBRTryo0);
        flowMeasurePolicy.getClass();
        placeableMo517measureBRTryo0.getMeasuredWidth();
        placeableMo517measureBRTryo0.getMeasuredHeight();
    }

    public static final Modifier offset(Function1 function1) {
        return new OffsetPxElement(function1);
    }

    public static final Modifier onConsumedWindowInsetsChanged(Modifier modifier, Function1 function1) {
        return modifier.then(new ConsumedInsetsModifierElement(function1));
    }

    public static final Modifier padding(Modifier modifier, PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues));
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m128padding3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new PaddingElement(f, f, f, f));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m129paddingVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new PaddingElement(f, f2, f, f2));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static Modifier m130paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = 0;
        }
        if ((i & 2) != 0) {
            f2 = 0;
        }
        return m129paddingVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m131paddingqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4));
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static Modifier m132paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i) {
        if ((i & 1) != 0) {
            f = 0;
        }
        if ((i & 2) != 0) {
            f2 = 0;
        }
        if ((i & 4) != 0) {
            f3 = 0;
        }
        if ((i & 8) != 0) {
            f4 = 0;
        }
        return m131paddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m133toBoxConstraintsOenEA2s(long j) {
        return ConstraintsKt.Constraints(Constraints.m685getMinWidthimpl(j), Constraints.m683getMaxWidthimpl(j), Constraints.m684getMinHeightimpl(j), Constraints.m682getMaxHeightimpl(j));
    }

    public static final InsetsValues toInsetsValues(Insets insets) {
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static final void valueToString_impl$lambda$0$appendPlus(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    public static final Modifier width(Modifier modifier) {
        return modifier.then(new IntrinsicWidthElement());
    }

    public static final Modifier windowInsetsPadding(Modifier modifier, WindowInsets windowInsets) {
        return modifier.then(new InsetsPaddingModifierElement(windowInsets));
    }

    public abstract int align$foundation_layout(int i, int i2, LayoutDirection layoutDirection);

    public static final Modifier windowInsetsPadding(Modifier modifier, Function1 function1) {
        return modifier.then(new SystemInsetsPaddingModifierElement(function1));
    }

    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, BiasAlignment.Vertical vertical2, int i, int i2, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i3) {
        Modifier modifier2;
        BiasAlignment.Vertical vertical3;
        int i4;
        int i5;
        gapComposer.startRestartGroup(-1303174015);
        int i6 = i3 | 6 | (gapComposer.changed(horizontal) ? 32 : 16) | (gapComposer.changed(vertical) ? 256 : 128) | 224256;
        if (gapComposer.shouldExecute(i6 & 1, (599187 & i6) != 599186)) {
            BiasAlignment.Vertical vertical4 = Alignment.Companion.Top;
            int i7 = (i6 & 896) | (i6 & 112) | 1572870 | 12807168;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            FlowRow(companion, horizontal, vertical, composableLambdaImpl, gapComposer, i7);
            modifier2 = companion;
            i5 = Integer.MAX_VALUE;
            vertical3 = vertical4;
            i4 = Integer.MAX_VALUE;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            vertical3 = vertical2;
            i4 = i;
            i5 = i2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FlowLayoutKt$$ExternalSyntheticLambda3(modifier2, horizontal, vertical, vertical3, i4, i5, composableLambdaImpl, i3);
        }
    }
}
