package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    public int dimensionBehavior;
    public int matchConstraintsType;
    public RunGroup runGroup;
    public ConstraintWidget widget;
    public final DimensionDependency dimension = new DimensionDependency(this);
    public int orientation = 0;
    public boolean resolved = false;
    public final DependencyNode start = new DependencyNode(this);
    public final DependencyNode end = new DependencyNode(this);
    public int mRunType = 1;

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    public static void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public static DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        HorizontalWidgetRun horizontalWidgetRun = constraintWidget.horizontalRun;
        VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(constraintAnchor2.mType);
        if (iOrdinal == 1) {
            return horizontalWidgetRun.start;
        }
        if (iOrdinal == 2) {
            return verticalWidgetRun.start;
        }
        if (iOrdinal == 3) {
            return horizontalWidgetRun.end;
        }
        if (iOrdinal == 4) {
            return verticalWidgetRun.end;
        }
        if (iOrdinal != 5) {
            return null;
        }
        return verticalWidgetRun.baseline;
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i, int i2) {
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i3 = constraintWidget.mMatchConstraintMaxWidth;
            int iMax = Math.max(constraintWidget.mMatchConstraintMinWidth, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i4 = constraintWidget2.mMatchConstraintMaxHeight;
            int iMax2 = Math.max(constraintWidget2.mMatchConstraintMinHeight, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            return dimensionDependency.value;
        }
        return 0L;
    }

    public abstract boolean supportsWrapComputation();

    public final void updateRunCenter(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = constraintAnchor.getMargin() + target.value;
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i2 = margin2 - margin;
            DimensionDependency dimensionDependency = this.dimension;
            if (!dimensionDependency.resolved && this.dimensionBehavior == 3) {
                int i3 = this.matchConstraintsType;
                if (i3 == 0) {
                    dimensionDependency.resolve(getLimitedDimension(i2, i));
                } else if (i3 == 1) {
                    dimensionDependency.resolve(Math.min(getLimitedDimension(dimensionDependency.wrapValue, i), i2));
                } else if (i3 == 2) {
                    ConstraintWidget constraintWidget = this.widget;
                    ConstraintWidget constraintWidget2 = constraintWidget.mParent;
                    if (constraintWidget2 != null) {
                        DimensionDependency dimensionDependency2 = (i == 0 ? constraintWidget2.horizontalRun : constraintWidget2.verticalRun).dimension;
                        if (dimensionDependency2.resolved) {
                            dimensionDependency.resolve(getLimitedDimension((int) ((dimensionDependency2.value * (i == 0 ? constraintWidget.mMatchConstraintPercentWidth : constraintWidget.mMatchConstraintPercentHeight)) + 0.5f), i));
                        }
                    }
                } else if (i3 == 3) {
                    ConstraintWidget constraintWidget3 = this.widget;
                    WidgetRun widgetRun = constraintWidget3.horizontalRun;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                    if (widgetRun.dimensionBehavior != 3 || widgetRun.matchConstraintsType != 3 || verticalWidgetRun.dimensionBehavior != 3 || verticalWidgetRun.matchConstraintsType != 3) {
                        if (i == 0) {
                            widgetRun = verticalWidgetRun;
                        }
                        DimensionDependency dimensionDependency3 = widgetRun.dimension;
                        if (dimensionDependency3.resolved) {
                            float f = constraintWidget3.mDimensionRatio;
                            dimensionDependency.resolve(i == 1 ? (int) ((dimensionDependency3.value / f) + 0.5f) : (int) ((f * dimensionDependency3.value) + 0.5f));
                        }
                    }
                }
            }
            if (dimensionDependency.resolved) {
                int i4 = dimensionDependency.value;
                DependencyNode dependencyNode = this.end;
                DependencyNode dependencyNode2 = this.start;
                if (i4 == i2) {
                    dependencyNode2.resolve(margin);
                    dependencyNode.resolve(margin2);
                    return;
                }
                ConstraintWidget constraintWidget4 = this.widget;
                float f2 = i == 0 ? constraintWidget4.mHorizontalBiasPercent : constraintWidget4.mVerticalBiasPercent;
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    f2 = 0.5f;
                }
                dependencyNode2.resolve((int) ((((margin2 - margin) - i4) * f2) + margin + 0.5f));
                dependencyNode.resolve(dependencyNode2.value + dimensionDependency.value);
            }
        }
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public static DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(constraintAnchor2.mType);
        if (iOrdinal == 1 || iOrdinal == 2) {
            return widgetRun.start;
        }
        if (iOrdinal == 3 || iOrdinal == 4) {
            return widgetRun.end;
        }
        return null;
    }
}
