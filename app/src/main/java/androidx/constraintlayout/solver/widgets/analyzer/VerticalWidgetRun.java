package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    public BaselineDimensionDependency baselineDimension;

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        DependencyNode dependencyNode = this.baseline;
        ConstraintWidget constraintWidget5 = this.widget;
        boolean z = constraintWidget5.measured;
        DimensionDependency dimensionDependency = this.dimension;
        if (z) {
            dimensionDependency.resolve(constraintWidget5.getHeight());
        }
        boolean z2 = dimensionDependency.resolved;
        ArrayList arrayList = dimensionDependency.dependencies;
        ArrayList arrayList2 = dimensionDependency.targets;
        DependencyNode dependencyNode2 = this.end;
        DependencyNode dependencyNode3 = this.start;
        if (!z2) {
            ConstraintWidget constraintWidget6 = this.widget;
            this.dimensionBehavior = constraintWidget6.mListDimensionBehaviors[1];
            if (constraintWidget6.hasBaseline) {
                this.baselineDimension = new BaselineDimensionDependency(this);
            }
            int i = this.dimensionBehavior;
            if (i != 3) {
                if (i == 4 && (constraintWidget4 = this.widget.mParent) != null) {
                    VerticalWidgetRun verticalWidgetRun = constraintWidget4.verticalRun;
                    if (constraintWidget4.mListDimensionBehaviors[1] == 1) {
                        int height = (constraintWidget4.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
                        WidgetRun.addTarget(dependencyNode3, verticalWidgetRun.start, this.widget.mTop.getMargin());
                        WidgetRun.addTarget(dependencyNode2, verticalWidgetRun.end, -this.widget.mBottom.getMargin());
                        dimensionDependency.resolve(height);
                        return;
                    }
                }
                if (i == 1) {
                    dimensionDependency.resolve(this.widget.getHeight());
                }
            }
        } else if (this.dimensionBehavior == 4 && (constraintWidget2 = (constraintWidget = this.widget).mParent) != null) {
            VerticalWidgetRun verticalWidgetRun2 = constraintWidget2.verticalRun;
            if (constraintWidget2.mListDimensionBehaviors[1] == 1) {
                WidgetRun.addTarget(dependencyNode3, verticalWidgetRun2.start, constraintWidget.mTop.getMargin());
                WidgetRun.addTarget(dependencyNode2, verticalWidgetRun2.end, -this.widget.mBottom.getMargin());
                return;
            }
        }
        boolean z3 = dimensionDependency.resolved;
        if (z3) {
            ConstraintWidget constraintWidget7 = this.widget;
            if (constraintWidget7.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget7.isInVerticalChain()) {
                        dependencyNode3.margin = this.widget.mListAnchors[2].getMargin();
                        dependencyNode2.margin = -this.widget.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target = WidgetRun.getTarget(this.widget.mListAnchors[2]);
                        if (target != null) {
                            WidgetRun.addTarget(dependencyNode3, target, this.widget.mListAnchors[2].getMargin());
                        }
                        DependencyNode target2 = WidgetRun.getTarget(this.widget.mListAnchors[3]);
                        if (target2 != null) {
                            WidgetRun.addTarget(dependencyNode2, target2, -this.widget.mListAnchors[3].getMargin());
                        }
                        dependencyNode3.delegateToWidgetRun = true;
                        dependencyNode2.delegateToWidgetRun = true;
                    }
                    ConstraintWidget constraintWidget8 = this.widget;
                    if (constraintWidget8.hasBaseline) {
                        WidgetRun.addTarget(dependencyNode, dependencyNode3, constraintWidget8.mBaselineDistance);
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = WidgetRun.getTarget(constraintAnchor);
                    if (target3 != null) {
                        WidgetRun.addTarget(dependencyNode3, target3, this.widget.mListAnchors[2].getMargin());
                        WidgetRun.addTarget(dependencyNode2, dependencyNode3, dimensionDependency.value);
                        ConstraintWidget constraintWidget9 = this.widget;
                        if (constraintWidget9.hasBaseline) {
                            WidgetRun.addTarget(dependencyNode, dependencyNode3, constraintWidget9.mBaselineDistance);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.mTarget != null) {
                    DependencyNode target4 = WidgetRun.getTarget(constraintAnchor3);
                    if (target4 != null) {
                        WidgetRun.addTarget(dependencyNode2, target4, -this.widget.mListAnchors[3].getMargin());
                        WidgetRun.addTarget(dependencyNode3, dependencyNode2, -dimensionDependency.value);
                    }
                    ConstraintWidget constraintWidget10 = this.widget;
                    if (constraintWidget10.hasBaseline) {
                        WidgetRun.addTarget(dependencyNode, dependencyNode3, constraintWidget10.mBaselineDistance);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.mTarget != null) {
                    DependencyNode target5 = WidgetRun.getTarget(constraintAnchor4);
                    if (target5 != null) {
                        WidgetRun.addTarget(dependencyNode, target5, 0);
                        WidgetRun.addTarget(dependencyNode3, dependencyNode, -this.widget.mBaselineDistance);
                        WidgetRun.addTarget(dependencyNode2, dependencyNode3, dimensionDependency.value);
                        return;
                    }
                    return;
                }
                if ((constraintWidget7 instanceof Barrier) || constraintWidget7.mParent == null || constraintWidget7.getAnchor(7).mTarget != null) {
                    return;
                }
                ConstraintWidget constraintWidget11 = this.widget;
                WidgetRun.addTarget(dependencyNode3, constraintWidget11.mParent.verticalRun.start, constraintWidget11.getY());
                WidgetRun.addTarget(dependencyNode2, dependencyNode3, dimensionDependency.value);
                ConstraintWidget constraintWidget12 = this.widget;
                if (constraintWidget12.hasBaseline) {
                    WidgetRun.addTarget(dependencyNode, dependencyNode3, constraintWidget12.mBaselineDistance);
                    return;
                }
                return;
            }
        }
        if (z3 || this.dimensionBehavior != 3) {
            dimensionDependency.addDependency(this);
        } else {
            ConstraintWidget constraintWidget13 = this.widget;
            int i2 = constraintWidget13.mMatchConstraintDefaultHeight;
            if (i2 == 2) {
                ConstraintWidget constraintWidget14 = constraintWidget13.mParent;
                if (constraintWidget14 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidget14.verticalRun.dimension;
                    arrayList2.add(dimensionDependency2);
                    dimensionDependency2.dependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode3);
                    arrayList.add(dependencyNode2);
                }
            } else if (i2 == 3 && !constraintWidget13.isInVerticalChain()) {
                ConstraintWidget constraintWidget15 = this.widget;
                if (constraintWidget15.mMatchConstraintDefaultWidth != 3) {
                    DimensionDependency dimensionDependency3 = constraintWidget15.horizontalRun.dimension;
                    arrayList2.add(dimensionDependency3);
                    dimensionDependency3.dependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode3);
                    arrayList.add(dependencyNode2);
                }
            }
        }
        ConstraintWidget constraintWidget16 = this.widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget16.mListAnchors;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget16.isInVerticalChain()) {
                dependencyNode3.margin = this.widget.mListAnchors[2].getMargin();
                dependencyNode2.margin = -this.widget.mListAnchors[3].getMargin();
            } else {
                DependencyNode target6 = WidgetRun.getTarget(this.widget.mListAnchors[2]);
                DependencyNode target7 = WidgetRun.getTarget(this.widget.mListAnchors[3]);
                target6.addDependency(this);
                target7.addDependency(this);
                this.mRunType = 4;
            }
            if (this.widget.hasBaseline) {
                addTarget(dependencyNode, dependencyNode3, 1, this.baselineDimension);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode target8 = WidgetRun.getTarget(constraintAnchor5);
            if (target8 != null) {
                WidgetRun.addTarget(dependencyNode3, target8, this.widget.mListAnchors[2].getMargin());
                addTarget(dependencyNode2, dependencyNode3, 1, dimensionDependency);
                if (this.widget.hasBaseline) {
                    addTarget(dependencyNode, dependencyNode3, 1, this.baselineDimension);
                }
                if (this.dimensionBehavior == 3) {
                    ConstraintWidget constraintWidget17 = this.widget;
                    if (constraintWidget17.mDimensionRatio > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun = constraintWidget17.horizontalRun;
                        if (horizontalWidgetRun.dimensionBehavior == 3) {
                            horizontalWidgetRun.dimension.dependencies.add(dimensionDependency);
                            arrayList2.add(this.widget.horizontalRun.dimension);
                            dimensionDependency.updateDelegate = this;
                        }
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.mTarget != null) {
                DependencyNode target9 = WidgetRun.getTarget(constraintAnchor7);
                if (target9 != null) {
                    WidgetRun.addTarget(dependencyNode2, target9, -this.widget.mListAnchors[3].getMargin());
                    addTarget(dependencyNode3, dependencyNode2, -1, dimensionDependency);
                    if (this.widget.hasBaseline) {
                        addTarget(dependencyNode, dependencyNode3, 1, this.baselineDimension);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.mTarget != null) {
                    DependencyNode target10 = WidgetRun.getTarget(constraintAnchor8);
                    if (target10 != null) {
                        WidgetRun.addTarget(dependencyNode, target10, 0);
                        addTarget(dependencyNode3, dependencyNode, -1, this.baselineDimension);
                        addTarget(dependencyNode2, dependencyNode3, 1, dimensionDependency);
                    }
                } else if (!(constraintWidget16 instanceof Barrier) && (constraintWidget3 = constraintWidget16.mParent) != null) {
                    WidgetRun.addTarget(dependencyNode3, constraintWidget3.verticalRun.start, constraintWidget16.getY());
                    addTarget(dependencyNode2, dependencyNode3, 1, dimensionDependency);
                    if (this.widget.hasBaseline) {
                        addTarget(dependencyNode, dependencyNode3, 1, this.baselineDimension);
                    }
                    if (this.dimensionBehavior == 3) {
                        ConstraintWidget constraintWidget18 = this.widget;
                        if (constraintWidget18.mDimensionRatio > 0.0f) {
                            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidget18.horizontalRun;
                            if (horizontalWidgetRun2.dimensionBehavior == 3) {
                                horizontalWidgetRun2.dimension.dependencies.add(dimensionDependency);
                                arrayList2.add(this.widget.horizontalRun.dimension);
                                dimensionDependency.updateDelegate = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            dimensionDependency.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.mY = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
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
        DependencyNode dependencyNode3 = this.baseline;
        dependencyNode3.clear();
        dependencyNode3.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        return this.dimensionBehavior != 3 || this.widget.mMatchConstraintDefaultHeight == 0;
    }

    public final String toString() {
        return "VerticalRun " + this.widget.mDebugName;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        float f;
        float f2;
        float f3;
        int i;
        if (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.mRunType) == 3) {
            ConstraintWidget constraintWidget = this.widget;
            updateRunCenter(constraintWidget.mTop, constraintWidget.mBottom, 1);
            return;
        }
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.readyToSolve && !dimensionDependency.resolved && this.dimensionBehavior == 3) {
            ConstraintWidget constraintWidget2 = this.widget;
            int i2 = constraintWidget2.mMatchConstraintDefaultHeight;
            if (i2 == 2) {
                ConstraintWidget constraintWidget3 = constraintWidget2.mParent;
                if (constraintWidget3 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidget3.verticalRun.dimension;
                    if (dimensionDependency2.resolved) {
                        dimensionDependency.resolve((int) ((dimensionDependency2.value * constraintWidget2.mMatchConstraintPercentHeight) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                DimensionDependency dimensionDependency3 = constraintWidget2.horizontalRun.dimension;
                if (dimensionDependency3.resolved) {
                    int i3 = constraintWidget2.mDimensionRatioSide;
                    if (i3 != -1) {
                        if (i3 == 0) {
                            f3 = dimensionDependency3.value * constraintWidget2.mDimensionRatio;
                            i = (int) (f3 + 0.5f);
                        } else if (i3 != 1) {
                            i = 0;
                        } else {
                            f = dimensionDependency3.value;
                            f2 = constraintWidget2.mDimensionRatio;
                        }
                        dimensionDependency.resolve(i);
                    } else {
                        f = dimensionDependency3.value;
                        f2 = constraintWidget2.mDimensionRatio;
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    dimensionDependency.resolve(i);
                }
            }
        }
        DependencyNode dependencyNode = this.start;
        boolean z = dependencyNode.readyToSolve;
        ArrayList arrayList = dependencyNode.targets;
        if (z) {
            DependencyNode dependencyNode2 = this.end;
            boolean z2 = dependencyNode2.readyToSolve;
            ArrayList arrayList2 = dependencyNode2.targets;
            if (z2) {
                if (dependencyNode.resolved && dependencyNode2.resolved && dimensionDependency.resolved) {
                    return;
                }
                if (!dimensionDependency.resolved && this.dimensionBehavior == 3) {
                    ConstraintWidget constraintWidget4 = this.widget;
                    if (constraintWidget4.mMatchConstraintDefaultWidth == 0 && !constraintWidget4.isInVerticalChain()) {
                        DependencyNode dependencyNode3 = (DependencyNode) arrayList.get(0);
                        DependencyNode dependencyNode4 = (DependencyNode) arrayList2.get(0);
                        int i4 = dependencyNode3.value + dependencyNode.margin;
                        int i5 = dependencyNode4.value + dependencyNode2.margin;
                        dependencyNode.resolve(i4);
                        dependencyNode2.resolve(i5);
                        dimensionDependency.resolve(i5 - i4);
                        return;
                    }
                }
                if (!dimensionDependency.resolved && this.dimensionBehavior == 3 && this.matchConstraintsType == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    DependencyNode dependencyNode5 = (DependencyNode) arrayList.get(0);
                    int i6 = (((DependencyNode) arrayList2.get(0)).value + dependencyNode2.margin) - (dependencyNode5.value + dependencyNode.margin);
                    int i7 = dimensionDependency.wrapValue;
                    if (i6 < i7) {
                        dimensionDependency.resolve(i6);
                    } else {
                        dimensionDependency.resolve(i7);
                    }
                }
                if (dimensionDependency.resolved && arrayList.size() > 0 && arrayList2.size() > 0) {
                    DependencyNode dependencyNode6 = (DependencyNode) arrayList.get(0);
                    DependencyNode dependencyNode7 = (DependencyNode) arrayList2.get(0);
                    int i8 = dependencyNode6.value;
                    int i9 = dependencyNode.margin + i8;
                    int i10 = dependencyNode7.value;
                    int i11 = dependencyNode2.margin + i10;
                    float f4 = this.widget.mVerticalBiasPercent;
                    if (dependencyNode6 == dependencyNode7) {
                        f4 = 0.5f;
                    } else {
                        i8 = i9;
                        i10 = i11;
                    }
                    dependencyNode.resolve((int) ((((i10 - i8) - dimensionDependency.value) * f4) + i8 + 0.5f));
                    dependencyNode2.resolve(dependencyNode.value + dimensionDependency.value);
                }
            }
        }
    }
}
