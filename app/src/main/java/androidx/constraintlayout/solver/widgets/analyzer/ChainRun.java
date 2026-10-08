package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ChainRun extends WidgetRun {
    public int chainStyle;
    public final ArrayList widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        super(constraintWidget);
        ArrayList arrayList = new ArrayList();
        this.widgets = arrayList;
        this.orientation = i;
        ConstraintWidget constraintWidget3 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget3.getPreviousChainMember(i);
        while (true) {
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = previousChainMember;
            if (constraintWidget3 == null) {
                break;
            } else {
                previousChainMember = constraintWidget3.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget2;
        int i2 = this.orientation;
        arrayList.add(i2 == 0 ? constraintWidget2.horizontalRun : i2 == 1 ? constraintWidget2.verticalRun : null);
        ConstraintWidget nextChainMember = constraintWidget2.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            int i3 = this.orientation;
            arrayList.add(i3 == 0 ? nextChainMember.horizontalRun : i3 == 1 ? nextChainMember.verticalRun : null);
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            WidgetRun widgetRun = (WidgetRun) obj;
            int i5 = this.orientation;
            if (i5 == 0) {
                widgetRun.widget.horizontalChainRun = this;
            } else if (i5 == 1) {
                widgetRun.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.mParent).mIsRtl && arrayList.size() > 1) {
            this.widget = ((WidgetRun) arrayList.get(arrayList.size() - 1)).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.mHorizontalChainStyle : this.widget.mVerticalChainStyle;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ArrayList arrayList = this.widgets;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((WidgetRun) obj).apply();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(0)).widget;
        ConstraintWidget constraintWidget2 = ((WidgetRun) arrayList.get(size2 - 1)).widget;
        int i2 = this.orientation;
        DependencyNode dependencyNode = this.end;
        DependencyNode dependencyNode2 = this.start;
        if (i2 == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = WidgetRun.getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                WidgetRun.addTarget(dependencyNode2, target, margin);
            }
            DependencyNode target2 = WidgetRun.getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                WidgetRun.addTarget(dependencyNode, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = WidgetRun.getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                WidgetRun.addTarget(dependencyNode2, target3, margin3);
            }
            DependencyNode target4 = WidgetRun.getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                WidgetRun.addTarget(dependencyNode, target4, -margin4);
            }
        }
        dependencyNode2.updateDelegate = this;
        dependencyNode.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.widgets;
            if (i >= arrayList.size()) {
                return;
            }
            ((WidgetRun) arrayList.get(i)).applyToWidget();
            i++;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.runGroup = null;
        ArrayList arrayList = this.widgets;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((WidgetRun) obj).clear();
        }
    }

    public final ConstraintWidget getFirstVisibleWidget() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.widgets;
            if (i >= arrayList.size()) {
                return null;
            }
            ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(i)).widget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
            i++;
        }
    }

    public final ConstraintWidget getLastVisibleWidget() {
        ArrayList arrayList = this.widgets;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(size)).widget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final long getWrapDimension() {
        ArrayList arrayList = this.widgets;
        int size = arrayList.size();
        long wrapDimension = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = (WidgetRun) arrayList.get(i);
            wrapDimension = ((long) widgetRun.end.margin) + widgetRun.getWrapDimension() + wrapDimension + ((long) widgetRun.start.margin);
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        ArrayList arrayList = this.widgets;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((WidgetRun) arrayList.get(i)).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        String strConcat = "ChainRun ".concat(this.orientation == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.widgets;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            strConcat = ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(strConcat, "<") + ((WidgetRun) obj), "> ");
        }
        return strConcat;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x01bc A[PHI: r1 r26
      0x01bc: PHI (r1v57 int) = (r1v55 int), (r1v60 int) binds: [B:120:0x01ba, B:111:0x019a] A[DONT_GENERATE, DONT_INLINE]
      0x01bc: PHI (r26v1 int) = (r26v0 int), (r26v3 int) binds: [B:120:0x01ba, B:111:0x019a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:302:0x00ea A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00df  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e2 A[ADDED_TO_REGION] */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        int i;
        int i2;
        boolean z;
        float f;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int iMax;
        int i10;
        int i11;
        float f3;
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            DependencyNode dependencyNode2 = this.end;
            if (dependencyNode2.resolved) {
                ConstraintWidget constraintWidget = this.widget.mParent;
                boolean z2 = (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? false : ((ConstraintWidgetContainer) constraintWidget).mIsRtl;
                int i12 = dependencyNode2.value - dependencyNode.value;
                ArrayList arrayList = this.widgets;
                int size = arrayList.size();
                int i13 = 0;
                while (true) {
                    i = -1;
                    i2 = 8;
                    if (i13 >= size) {
                        i13 = -1;
                        break;
                    } else if (((WidgetRun) arrayList.get(i13)).widget.mVisibility != 8) {
                        break;
                    } else {
                        i13++;
                    }
                }
                int i14 = size - 1;
                for (int i15 = i14; i15 >= 0; i15--) {
                    if (((WidgetRun) arrayList.get(i15)).widget.mVisibility != 8) {
                        i = i15;
                        break;
                    }
                }
                int i16 = 0;
                while (true) {
                    if (i16 >= 2) {
                        z = z2;
                        f = 0.0f;
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                        break;
                    }
                    f = 0.0f;
                    int i17 = 0;
                    i5 = 0;
                    int i18 = 0;
                    int i19 = 0;
                    while (i17 < size) {
                        WidgetRun widgetRun = (WidgetRun) arrayList.get(i17);
                        ConstraintWidget constraintWidget2 = widgetRun.widget;
                        boolean z3 = z2;
                        if (constraintWidget2.mVisibility == i2) {
                            i10 = i16;
                        } else {
                            i19++;
                            if (i17 > 0 && i17 >= i13) {
                                i5 += widgetRun.start.margin;
                            }
                            DimensionDependency dimensionDependency = widgetRun.dimension;
                            int i20 = dimensionDependency.value;
                            i10 = i16;
                            boolean z4 = widgetRun.dimensionBehavior != 3;
                            if (z4) {
                                int i21 = this.orientation;
                                if (i21 == 0 && !constraintWidget2.horizontalRun.dimension.resolved) {
                                    return;
                                }
                                if (i21 == 1 && !constraintWidget2.verticalRun.dimension.resolved) {
                                    return;
                                }
                            } else {
                                if (widgetRun.matchConstraintsType == 1 && i10 == 0) {
                                    i11 = dimensionDependency.wrapValue;
                                    i18++;
                                } else {
                                    if (dimensionDependency.resolved) {
                                        i11 = i20;
                                    }
                                    if (z4) {
                                        i5 += i11;
                                    } else {
                                        i18++;
                                        f3 = constraintWidget2.mWeight[this.orientation];
                                        if (f3 >= 0.0f) {
                                            f += f3;
                                        }
                                    }
                                    if (i17 >= i14 && i17 < i) {
                                        i5 += -widgetRun.end.margin;
                                    }
                                }
                                z4 = true;
                                if (z4) {
                                    i18++;
                                    f3 = constraintWidget2.mWeight[this.orientation];
                                    if (f3 >= 0.0f) {
                                        f += f3;
                                    }
                                } else {
                                    i5 += i11;
                                }
                                if (i17 >= i14) {
                                }
                            }
                            i11 = i20;
                            if (z4) {
                                i18++;
                                f3 = constraintWidget2.mWeight[this.orientation];
                                if (f3 >= 0.0f) {
                                    f += f3;
                                }
                            } else {
                                i5 += i11;
                            }
                            if (i17 >= i14) {
                            }
                        }
                        i17++;
                        z2 = z3;
                        i16 = i10;
                        i2 = 8;
                    }
                    z = z2;
                    int i22 = i16;
                    if (i5 < i12 || i18 == 0) {
                        i3 = i18;
                        i4 = i19;
                        break;
                    } else {
                        i16 = i22 + 1;
                        z2 = z;
                        i2 = 8;
                    }
                }
                int i23 = dependencyNode.value;
                if (z) {
                    i23 = dependencyNode2.value;
                }
                float f4 = 0.5f;
                if (i5 > i12) {
                    i23 = z ? i23 + ((int) (((i5 - i12) / 2.0f) + 0.5f)) : i23 - ((int) (((i5 - i12) / 2.0f) + 0.5f));
                }
                if (i3 > 0) {
                    float f5 = i12 - i5;
                    int i24 = (int) ((f5 / i3) + 0.5f);
                    int i25 = 0;
                    int i26 = 0;
                    while (i25 < size) {
                        float f6 = f4;
                        WidgetRun widgetRun2 = (WidgetRun) arrayList.get(i25);
                        int i27 = i23;
                        ConstraintWidget constraintWidget3 = widgetRun2.widget;
                        int i28 = i3;
                        DimensionDependency dimensionDependency2 = widgetRun2.dimension;
                        float f7 = f5;
                        int i29 = i24;
                        if (constraintWidget3.mVisibility == 8 || widgetRun2.dimensionBehavior != 3 || dimensionDependency2.resolved) {
                            i9 = i25;
                        } else {
                            int i30 = f > 0.0f ? (int) (((constraintWidget3.mWeight[this.orientation] * f7) / f) + f6) : i29;
                            if (this.orientation == 0) {
                                int i31 = constraintWidget3.mMatchConstraintMaxWidth;
                                i9 = i25;
                                iMax = Math.max(constraintWidget3.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? Math.min(i30, dimensionDependency2.wrapValue) : i30);
                                if (i31 > 0) {
                                    iMax = Math.min(i31, iMax);
                                }
                                if (iMax != i30) {
                                    i26++;
                                    i30 = iMax;
                                }
                            } else {
                                i9 = i25;
                                int i32 = constraintWidget3.mMatchConstraintMaxHeight;
                                iMax = Math.max(constraintWidget3.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? Math.min(i30, dimensionDependency2.wrapValue) : i30);
                                if (i32 > 0) {
                                    iMax = Math.min(i32, iMax);
                                }
                                if (iMax != i30) {
                                    i26++;
                                    i30 = iMax;
                                }
                            }
                            dimensionDependency2.resolve(i30);
                        }
                        i25 = i9 + 1;
                        i23 = i27;
                        f4 = f6;
                        i3 = i28;
                        f5 = f7;
                        i24 = i29;
                    }
                    i6 = i23;
                    f2 = f4;
                    int i33 = i3;
                    if (i26 > 0) {
                        i3 = i33 - i26;
                        i5 = 0;
                        for (int i34 = 0; i34 < size; i34++) {
                            WidgetRun widgetRun3 = (WidgetRun) arrayList.get(i34);
                            if (widgetRun3.widget.mVisibility != 8) {
                                if (i34 > 0 && i34 >= i13) {
                                    i5 += widgetRun3.start.margin;
                                }
                                i5 += widgetRun3.dimension.value;
                                if (i34 < i14 && i34 < i) {
                                    i5 += -widgetRun3.end.margin;
                                }
                            }
                        }
                    } else {
                        i3 = i33;
                    }
                    i8 = 2;
                    if (this.chainStyle == 2 && i26 == 0) {
                        i7 = 0;
                        this.chainStyle = 0;
                    } else {
                        i7 = 0;
                    }
                } else {
                    i6 = i23;
                    f2 = 0.5f;
                    i7 = 0;
                    i8 = 2;
                }
                if (i5 > i12) {
                    this.chainStyle = i8;
                }
                if (i4 > 0 && i3 == 0 && i13 == i) {
                    this.chainStyle = i8;
                }
                int i35 = this.chainStyle;
                if (i35 == 1) {
                    int i36 = i4 > 1 ? (i12 - i5) / (i4 - 1) : i4 == 1 ? (i12 - i5) / 2 : i7;
                    if (i3 > 0) {
                        i36 = i7;
                    }
                    int i37 = i6;
                    for (int i38 = i7; i38 < size; i38++) {
                        WidgetRun widgetRun4 = (WidgetRun) arrayList.get(z ? size - (i38 + 1) : i38);
                        ConstraintWidget constraintWidget4 = widgetRun4.widget;
                        DependencyNode dependencyNode3 = widgetRun4.end;
                        DependencyNode dependencyNode4 = widgetRun4.start;
                        if (constraintWidget4.mVisibility == 8) {
                            dependencyNode4.resolve(i37);
                            dependencyNode3.resolve(i37);
                        } else {
                            if (i38 > 0) {
                                i37 = z ? i37 - i36 : i37 + i36;
                            }
                            if (i38 > 0 && i38 >= i13) {
                                i37 = z ? i37 - dependencyNode4.margin : i37 + dependencyNode4.margin;
                            }
                            if (z) {
                                dependencyNode3.resolve(i37);
                            } else {
                                dependencyNode4.resolve(i37);
                            }
                            DimensionDependency dimensionDependency3 = widgetRun4.dimension;
                            int i39 = dimensionDependency3.value;
                            if (widgetRun4.dimensionBehavior == 3 && widgetRun4.matchConstraintsType == 1) {
                                i39 = dimensionDependency3.wrapValue;
                            }
                            i37 = z ? i37 - i39 : i37 + i39;
                            if (z) {
                                dependencyNode4.resolve(i37);
                            } else {
                                dependencyNode3.resolve(i37);
                            }
                            widgetRun4.resolved = true;
                            if (i38 < i14 && i38 < i) {
                                i37 = z ? i37 - (-dependencyNode3.margin) : i37 + (-dependencyNode3.margin);
                            }
                        }
                    }
                    return;
                }
                if (i35 == 0) {
                    int i40 = (i12 - i5) / (i4 + 1);
                    if (i3 > 0) {
                        i40 = i7;
                    }
                    int i41 = i6;
                    for (int i42 = i7; i42 < size; i42++) {
                        WidgetRun widgetRun5 = (WidgetRun) arrayList.get(z ? size - (i42 + 1) : i42);
                        ConstraintWidget constraintWidget5 = widgetRun5.widget;
                        DependencyNode dependencyNode5 = widgetRun5.end;
                        DependencyNode dependencyNode6 = widgetRun5.start;
                        if (constraintWidget5.mVisibility == 8) {
                            dependencyNode6.resolve(i41);
                            dependencyNode5.resolve(i41);
                        } else {
                            int i43 = z ? i41 - i40 : i41 + i40;
                            if (i42 > 0 && i42 >= i13) {
                                i43 = z ? i43 - dependencyNode6.margin : i43 + dependencyNode6.margin;
                            }
                            if (z) {
                                dependencyNode5.resolve(i43);
                            } else {
                                dependencyNode6.resolve(i43);
                            }
                            DimensionDependency dimensionDependency4 = widgetRun5.dimension;
                            int iMin = dimensionDependency4.value;
                            if (widgetRun5.dimensionBehavior == 3 && widgetRun5.matchConstraintsType == 1) {
                                iMin = Math.min(iMin, dimensionDependency4.wrapValue);
                            }
                            i41 = z ? i43 - iMin : i43 + iMin;
                            if (z) {
                                dependencyNode6.resolve(i41);
                            } else {
                                dependencyNode5.resolve(i41);
                            }
                            if (i42 < i14 && i42 < i) {
                                i41 = z ? i41 - (-dependencyNode5.margin) : i41 + (-dependencyNode5.margin);
                            }
                        }
                    }
                    return;
                }
                if (i35 == 2) {
                    float f8 = this.orientation == 0 ? this.widget.mHorizontalBiasPercent : this.widget.mVerticalBiasPercent;
                    if (z) {
                        f8 = 1.0f - f8;
                    }
                    int i44 = (int) (((i12 - i5) * f8) + f2);
                    if (i44 < 0 || i3 > 0) {
                        i44 = i7;
                    }
                    int i45 = z ? i6 - i44 : i6 + i44;
                    for (int i46 = i7; i46 < size; i46++) {
                        WidgetRun widgetRun6 = (WidgetRun) arrayList.get(z ? size - (i46 + 1) : i46);
                        ConstraintWidget constraintWidget6 = widgetRun6.widget;
                        DependencyNode dependencyNode7 = widgetRun6.end;
                        DependencyNode dependencyNode8 = widgetRun6.start;
                        if (constraintWidget6.mVisibility == 8) {
                            dependencyNode8.resolve(i45);
                            dependencyNode7.resolve(i45);
                        } else {
                            if (i46 > 0 && i46 >= i13) {
                                i45 = z ? i45 - dependencyNode8.margin : i45 + dependencyNode8.margin;
                            }
                            if (z) {
                                dependencyNode7.resolve(i45);
                            } else {
                                dependencyNode8.resolve(i45);
                            }
                            DimensionDependency dimensionDependency5 = widgetRun6.dimension;
                            int i47 = dimensionDependency5.value;
                            if (widgetRun6.dimensionBehavior == 3 && widgetRun6.matchConstraintsType == 1) {
                                i47 = dimensionDependency5.wrapValue;
                            }
                            i45 = z ? i45 - i47 : i45 + i47;
                            if (z) {
                                dependencyNode8.resolve(i45);
                            } else {
                                dependencyNode7.resolve(i45);
                            }
                            if (i46 < i14 && i46 < i) {
                                i45 = z ? i45 - (-dependencyNode7.margin) : i45 + (-dependencyNode7.margin);
                            }
                        }
                    }
                }
            }
        }
    }
}
