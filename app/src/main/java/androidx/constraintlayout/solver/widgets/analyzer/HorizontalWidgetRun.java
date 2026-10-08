package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HorizontalWidgetRun extends WidgetRun {
    public static final int[] tempDimensions = new int[2];

    public static void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5 = this.widget;
        boolean z = constraintWidget5.measured;
        DimensionDependency dimensionDependency = this.dimension;
        if (z) {
            dimensionDependency.resolve(constraintWidget5.getWidth());
        }
        boolean z2 = dimensionDependency.resolved;
        ArrayList arrayList = dimensionDependency.dependencies;
        ArrayList arrayList2 = dimensionDependency.targets;
        DependencyNode dependencyNode = this.end;
        DependencyNode dependencyNode2 = this.start;
        if (!z2) {
            ConstraintWidget constraintWidget6 = this.widget;
            int i = constraintWidget6.mListDimensionBehaviors[0];
            this.dimensionBehavior = i;
            if (i != 3) {
                if (i == 4 && (((constraintWidget4 = constraintWidget6.mParent) != null && constraintWidget4.mListDimensionBehaviors[0] == 1) || constraintWidget4.mListDimensionBehaviors[0] == 4)) {
                    int width = constraintWidget4.getWidth();
                    HorizontalWidgetRun horizontalWidgetRun = constraintWidget4.horizontalRun;
                    int margin = (width - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    WidgetRun.addTarget(dependencyNode2, horizontalWidgetRun.start, this.widget.mLeft.getMargin());
                    WidgetRun.addTarget(dependencyNode, horizontalWidgetRun.end, -this.widget.mRight.getMargin());
                    dimensionDependency.resolve(margin);
                    return;
                }
                if (i == 1) {
                    dimensionDependency.resolve(constraintWidget6.getWidth());
                }
            }
        } else if (this.dimensionBehavior == 4 && (((constraintWidget2 = (constraintWidget = this.widget).mParent) != null && constraintWidget2.mListDimensionBehaviors[0] == 1) || constraintWidget2.mListDimensionBehaviors[0] == 4)) {
            WidgetRun.addTarget(dependencyNode2, constraintWidget2.horizontalRun.start, constraintWidget.mLeft.getMargin());
            WidgetRun.addTarget(dependencyNode, constraintWidget2.horizontalRun.end, -this.widget.mRight.getMargin());
            return;
        }
        if (dimensionDependency.resolved) {
            ConstraintWidget constraintWidget7 = this.widget;
            if (constraintWidget7.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[1].mTarget != null) {
                    if (constraintWidget7.isInHorizontalChain()) {
                        dependencyNode2.margin = this.widget.mListAnchors[0].getMargin();
                        dependencyNode.margin = -this.widget.mListAnchors[1].getMargin();
                        return;
                    }
                    DependencyNode target = WidgetRun.getTarget(this.widget.mListAnchors[0]);
                    if (target != null) {
                        WidgetRun.addTarget(dependencyNode2, target, this.widget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target2 = WidgetRun.getTarget(this.widget.mListAnchors[1]);
                    if (target2 != null) {
                        WidgetRun.addTarget(dependencyNode, target2, -this.widget.mListAnchors[1].getMargin());
                    }
                    dependencyNode2.delegateToWidgetRun = true;
                    dependencyNode.delegateToWidgetRun = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = WidgetRun.getTarget(constraintAnchor);
                    if (target3 != null) {
                        WidgetRun.addTarget(dependencyNode2, target3, this.widget.mListAnchors[0].getMargin());
                        WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.mTarget != null) {
                    DependencyNode target4 = WidgetRun.getTarget(constraintAnchor3);
                    if (target4 != null) {
                        WidgetRun.addTarget(dependencyNode, target4, -this.widget.mListAnchors[1].getMargin());
                        WidgetRun.addTarget(dependencyNode2, dependencyNode, -dimensionDependency.value);
                        return;
                    }
                    return;
                }
                if ((constraintWidget7 instanceof Barrier) || constraintWidget7.mParent == null || constraintWidget7.getAnchor(7).mTarget != null) {
                    return;
                }
                ConstraintWidget constraintWidget8 = this.widget;
                WidgetRun.addTarget(dependencyNode2, constraintWidget8.mParent.horizontalRun.start, constraintWidget8.getX());
                WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                return;
            }
        }
        if (this.dimensionBehavior == 3) {
            ConstraintWidget constraintWidget9 = this.widget;
            int i2 = constraintWidget9.mMatchConstraintDefaultWidth;
            VerticalWidgetRun verticalWidgetRun = constraintWidget9.verticalRun;
            if (i2 == 2) {
                ConstraintWidget constraintWidget10 = constraintWidget9.mParent;
                if (constraintWidget10 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidget10.verticalRun.dimension;
                    arrayList2.add(dimensionDependency2);
                    dimensionDependency2.dependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                }
            } else if (i2 == 3) {
                if (constraintWidget9.mMatchConstraintDefaultHeight == 3) {
                    dependencyNode2.updateDelegate = this;
                    dependencyNode.updateDelegate = this;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    dimensionDependency.updateDelegate = this;
                    if (constraintWidget9.isInVerticalChain()) {
                        arrayList2.add(this.widget.verticalRun.dimension);
                        this.widget.verticalRun.dimension.dependencies.add(dimensionDependency);
                        VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                        verticalWidgetRun2.dimension.updateDelegate = this;
                        arrayList2.add(verticalWidgetRun2.start);
                        arrayList2.add(this.widget.verticalRun.end);
                        this.widget.verticalRun.start.dependencies.add(dimensionDependency);
                        this.widget.verticalRun.end.dependencies.add(dimensionDependency);
                    } else if (this.widget.isInHorizontalChain()) {
                        this.widget.verticalRun.dimension.targets.add(dimensionDependency);
                        arrayList.add(this.widget.verticalRun.dimension);
                    } else {
                        this.widget.verticalRun.dimension.targets.add(dimensionDependency);
                    }
                } else {
                    DimensionDependency dimensionDependency3 = verticalWidgetRun.dimension;
                    arrayList2.add(dimensionDependency3);
                    dimensionDependency3.dependencies.add(dimensionDependency);
                    this.widget.verticalRun.start.dependencies.add(dimensionDependency);
                    this.widget.verticalRun.end.dependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                    dependencyNode2.targets.add(dimensionDependency);
                    dependencyNode.targets.add(dimensionDependency);
                }
            }
        }
        ConstraintWidget constraintWidget11 = this.widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget11.mListAnchors;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].mTarget != null) {
            if (constraintWidget11.isInHorizontalChain()) {
                dependencyNode2.margin = this.widget.mListAnchors[0].getMargin();
                dependencyNode.margin = -this.widget.mListAnchors[1].getMargin();
                return;
            }
            DependencyNode target5 = WidgetRun.getTarget(this.widget.mListAnchors[0]);
            DependencyNode target6 = WidgetRun.getTarget(this.widget.mListAnchors[1]);
            target5.addDependency(this);
            target6.addDependency(this);
            this.mRunType = 4;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode target7 = WidgetRun.getTarget(constraintAnchor4);
            if (target7 != null) {
                WidgetRun.addTarget(dependencyNode2, target7, this.widget.mListAnchors[0].getMargin());
                addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.mTarget != null) {
            DependencyNode target8 = WidgetRun.getTarget(constraintAnchor6);
            if (target8 != null) {
                WidgetRun.addTarget(dependencyNode, target8, -this.widget.mListAnchors[1].getMargin());
                addTarget(dependencyNode2, dependencyNode, -1, dimensionDependency);
                return;
            }
            return;
        }
        if ((constraintWidget11 instanceof Barrier) || (constraintWidget3 = constraintWidget11.mParent) == null) {
            return;
        }
        WidgetRun.addTarget(dependencyNode2, constraintWidget3.horizontalRun.start, constraintWidget11.getX());
        addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.mX = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    public final void reset() {
        this.resolved = false;
        DependencyNode dependencyNode = this.start;
        dependencyNode.clear();
        dependencyNode.resolved = false;
        DependencyNode dependencyNode2 = this.end;
        dependencyNode2.clear();
        dependencyNode2.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        return this.dimensionBehavior != 3 || this.widget.mMatchConstraintDefaultWidth == 0;
    }

    public final String toString() {
        return "HorizontalRun " + this.widget.mDebugName;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0262  */
    /* JADX WARN: Code duplicated, block: B:118:0x0272  */
    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        float f;
        int limitedDimension;
        int i;
        int limitedDimension2;
        float f2;
        float f3;
        float f4;
        int i2;
        if (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mRunType) == 3) {
            ConstraintWidget constraintWidget = this.widget;
            updateRunCenter(constraintWidget.mLeft, constraintWidget.mRight, 0);
            return;
        }
        DimensionDependency dimensionDependency = this.dimension;
        boolean z = dimensionDependency.resolved;
        DependencyNode dependencyNode = this.start;
        DependencyNode dependencyNode2 = this.end;
        if (z || this.dimensionBehavior != 3) {
            f = 0.5f;
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i3 = constraintWidget2.mMatchConstraintDefaultWidth;
            VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
            if (i3 == 2) {
                f = 0.5f;
                ConstraintWidget constraintWidget3 = constraintWidget2.mParent;
                if (constraintWidget3 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidget3.horizontalRun.dimension;
                    if (dimensionDependency2.resolved) {
                        dimensionDependency.resolve((int) ((dimensionDependency2.value * constraintWidget2.mMatchConstraintPercentWidth) + 0.5f));
                    }
                }
            } else if (i3 == 3) {
                int i4 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i4 == 0 || i4 == 3) {
                    DependencyNode dependencyNode3 = verticalWidgetRun.start;
                    DependencyNode dependencyNode4 = verticalWidgetRun.end;
                    boolean z2 = constraintWidget2.mLeft.mTarget != null;
                    boolean z3 = constraintWidget2.mTop.mTarget != null;
                    boolean z4 = constraintWidget2.mRight.mTarget != null;
                    boolean z5 = constraintWidget2.mBottom.mTarget != null;
                    f = 0.5f;
                    int i5 = constraintWidget2.mDimensionRatioSide;
                    if (z2 && z3 && z4 && z5) {
                        float f5 = constraintWidget2.mDimensionRatio;
                        boolean z6 = dependencyNode3.resolved;
                        ArrayList arrayList = dependencyNode3.targets;
                        int[] iArr = tempDimensions;
                        if (z6 && dependencyNode4.resolved) {
                            if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                computeInsetRatio(iArr, ((DependencyNode) dependencyNode.targets.get(0)).value + dependencyNode.margin, ((DependencyNode) dependencyNode2.targets.get(0)).value - dependencyNode2.margin, dependencyNode3.value + dependencyNode3.margin, dependencyNode4.value - dependencyNode4.margin, f5, i5);
                                dimensionDependency.resolve(iArr[0]);
                                this.widget.verticalRun.dimension.resolve(iArr[1]);
                                return;
                            }
                            return;
                        }
                        if (dependencyNode.resolved && dependencyNode2.resolved) {
                            if (!dependencyNode3.readyToSolve || !dependencyNode4.readyToSolve) {
                                return;
                            }
                            computeInsetRatio(iArr, dependencyNode.value + dependencyNode.margin, dependencyNode2.value - dependencyNode2.margin, ((DependencyNode) arrayList.get(0)).value + dependencyNode3.margin, ((DependencyNode) dependencyNode4.targets.get(0)).value - dependencyNode4.margin, f5, i5);
                            dimensionDependency.resolve(iArr[0]);
                            this.widget.verticalRun.dimension.resolve(iArr[1]);
                        }
                        if (!dependencyNode.readyToSolve || !dependencyNode2.readyToSolve || !dependencyNode3.readyToSolve || !dependencyNode4.readyToSolve) {
                            return;
                        }
                        computeInsetRatio(iArr, ((DependencyNode) dependencyNode.targets.get(0)).value + dependencyNode.margin, ((DependencyNode) dependencyNode2.targets.get(0)).value - dependencyNode2.margin, ((DependencyNode) arrayList.get(0)).value + dependencyNode3.margin, ((DependencyNode) dependencyNode4.targets.get(0)).value - dependencyNode4.margin, f5, i5);
                        dimensionDependency.resolve(iArr[0]);
                        this.widget.verticalRun.dimension.resolve(iArr[1]);
                    } else if (z2 && z4) {
                        if (!dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                            return;
                        }
                        float f6 = constraintWidget2.mDimensionRatio;
                        int i6 = ((DependencyNode) dependencyNode.targets.get(0)).value + dependencyNode.margin;
                        int i7 = ((DependencyNode) dependencyNode2.targets.get(0)).value - dependencyNode2.margin;
                        if (i5 == -1 || i5 == 0) {
                            int limitedDimension3 = getLimitedDimension(i7 - i6, 0);
                            int i8 = (int) ((limitedDimension3 * f6) + 0.5f);
                            int limitedDimension4 = getLimitedDimension(i8, 1);
                            if (i8 != limitedDimension4) {
                                limitedDimension3 = (int) ((limitedDimension4 / f6) + 0.5f);
                            }
                            dimensionDependency.resolve(limitedDimension3);
                            this.widget.verticalRun.dimension.resolve(limitedDimension4);
                        } else if (i5 == 1) {
                            int limitedDimension5 = getLimitedDimension(i7 - i6, 0);
                            int i9 = (int) ((limitedDimension5 / f6) + 0.5f);
                            int limitedDimension6 = getLimitedDimension(i9, 1);
                            if (i9 != limitedDimension6) {
                                limitedDimension5 = (int) ((limitedDimension6 * f6) + 0.5f);
                            }
                            dimensionDependency.resolve(limitedDimension5);
                            this.widget.verticalRun.dimension.resolve(limitedDimension6);
                        }
                    } else if (z3 && z5) {
                        if (!dependencyNode3.readyToSolve || !dependencyNode4.readyToSolve) {
                            return;
                        }
                        float f7 = constraintWidget2.mDimensionRatio;
                        int i10 = ((DependencyNode) dependencyNode3.targets.get(0)).value + dependencyNode3.margin;
                        int i11 = ((DependencyNode) dependencyNode4.targets.get(0)).value - dependencyNode4.margin;
                        if (i5 == -1) {
                            limitedDimension = getLimitedDimension(i11 - i10, 1);
                            i = (int) ((limitedDimension / f7) + 0.5f);
                            limitedDimension2 = getLimitedDimension(i, 0);
                            if (i != limitedDimension2) {
                                limitedDimension = (int) ((limitedDimension2 * f7) + 0.5f);
                            }
                            dimensionDependency.resolve(limitedDimension2);
                            this.widget.verticalRun.dimension.resolve(limitedDimension);
                        } else if (i5 == 0) {
                            int limitedDimension7 = getLimitedDimension(i11 - i10, 1);
                            int i12 = (int) ((limitedDimension7 * f7) + 0.5f);
                            int limitedDimension8 = getLimitedDimension(i12, 0);
                            if (i12 != limitedDimension8) {
                                limitedDimension7 = (int) ((limitedDimension8 / f7) + 0.5f);
                            }
                            dimensionDependency.resolve(limitedDimension8);
                            this.widget.verticalRun.dimension.resolve(limitedDimension7);
                        } else if (i5 == 1) {
                            limitedDimension = getLimitedDimension(i11 - i10, 1);
                            i = (int) ((limitedDimension / f7) + 0.5f);
                            limitedDimension2 = getLimitedDimension(i, 0);
                            if (i != limitedDimension2) {
                                limitedDimension = (int) ((limitedDimension2 * f7) + 0.5f);
                            }
                            dimensionDependency.resolve(limitedDimension2);
                            this.widget.verticalRun.dimension.resolve(limitedDimension);
                        }
                    }
                } else {
                    int i13 = constraintWidget2.mDimensionRatioSide;
                    if (i13 != -1) {
                        if (i13 == 0) {
                            f4 = verticalWidgetRun.dimension.value / constraintWidget2.mDimensionRatio;
                            i2 = (int) (f4 + 0.5f);
                        } else if (i13 != 1) {
                            i2 = 0;
                        } else {
                            f2 = verticalWidgetRun.dimension.value;
                            f3 = constraintWidget2.mDimensionRatio;
                        }
                        dimensionDependency.resolve(i2);
                        f = 0.5f;
                    } else {
                        f2 = verticalWidgetRun.dimension.value;
                        f3 = constraintWidget2.mDimensionRatio;
                    }
                    f4 = f2 * f3;
                    i2 = (int) (f4 + 0.5f);
                    dimensionDependency.resolve(i2);
                    f = 0.5f;
                }
            } else {
                f = 0.5f;
            }
        }
        boolean z7 = dependencyNode.readyToSolve;
        ArrayList arrayList2 = dependencyNode.targets;
        if (z7) {
            boolean z8 = dependencyNode2.readyToSolve;
            ArrayList arrayList3 = dependencyNode2.targets;
            if (z8) {
                if (dependencyNode.resolved && dependencyNode2.resolved && dimensionDependency.resolved) {
                    return;
                }
                if (!dimensionDependency.resolved && this.dimensionBehavior == 3) {
                    ConstraintWidget constraintWidget4 = this.widget;
                    if (constraintWidget4.mMatchConstraintDefaultWidth == 0 && !constraintWidget4.isInHorizontalChain()) {
                        DependencyNode dependencyNode5 = (DependencyNode) arrayList2.get(0);
                        DependencyNode dependencyNode6 = (DependencyNode) arrayList3.get(0);
                        int i14 = dependencyNode5.value + dependencyNode.margin;
                        int i15 = dependencyNode6.value + dependencyNode2.margin;
                        dependencyNode.resolve(i14);
                        dependencyNode2.resolve(i15);
                        dimensionDependency.resolve(i15 - i14);
                        return;
                    }
                }
                if (!dimensionDependency.resolved && this.dimensionBehavior == 3 && this.matchConstraintsType == 1 && arrayList2.size() > 0 && arrayList3.size() > 0) {
                    int iMin = Math.min((((DependencyNode) arrayList3.get(0)).value + dependencyNode2.margin) - (((DependencyNode) arrayList2.get(0)).value + dependencyNode.margin), dimensionDependency.wrapValue);
                    ConstraintWidget constraintWidget5 = this.widget;
                    int i16 = constraintWidget5.mMatchConstraintMaxWidth;
                    int iMax = Math.max(constraintWidget5.mMatchConstraintMinWidth, iMin);
                    if (i16 > 0) {
                        iMax = Math.min(i16, iMax);
                    }
                    dimensionDependency.resolve(iMax);
                }
                if (dimensionDependency.resolved) {
                    DependencyNode dependencyNode7 = (DependencyNode) arrayList2.get(0);
                    DependencyNode dependencyNode8 = (DependencyNode) arrayList3.get(0);
                    int i17 = dependencyNode7.value;
                    int i18 = dependencyNode.margin + i17;
                    int i19 = dependencyNode8.value;
                    int i20 = dependencyNode2.margin + i19;
                    float f8 = this.widget.mHorizontalBiasPercent;
                    if (dependencyNode7 == dependencyNode8) {
                        f8 = f;
                    } else {
                        i17 = i18;
                        i19 = i20;
                    }
                    dependencyNode.resolve((int) ((((i19 - i17) - dimensionDependency.value) * f8) + i17 + f));
                    dependencyNode2.resolve(dependencyNode.value + dimensionDependency.value);
                }
            }
        }
    }
}
