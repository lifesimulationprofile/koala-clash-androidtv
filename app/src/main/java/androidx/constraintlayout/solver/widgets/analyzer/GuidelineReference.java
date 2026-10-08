package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GuidelineReference extends WidgetRun {
    public final void addDependency(DependencyNode dependencyNode) {
        DependencyNode dependencyNode2 = this.start;
        dependencyNode2.dependencies.add(dependencyNode);
        dependencyNode.targets.add(dependencyNode2);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget = this.widget;
        Guideline guideline = (Guideline) constraintWidget;
        int i = guideline.mRelativeBegin;
        int i2 = guideline.mRelativeEnd;
        int i3 = guideline.mOrientation;
        DependencyNode dependencyNode = this.start;
        if (i3 == 1) {
            if (i != -1) {
                dependencyNode.targets.add(constraintWidget.mParent.horizontalRun.start);
                this.widget.mParent.horizontalRun.start.dependencies.add(dependencyNode);
                dependencyNode.margin = i;
            } else if (i2 != -1) {
                dependencyNode.targets.add(constraintWidget.mParent.horizontalRun.end);
                this.widget.mParent.horizontalRun.end.dependencies.add(dependencyNode);
                dependencyNode.margin = -i2;
            } else {
                dependencyNode.delegateToWidgetRun = true;
                dependencyNode.targets.add(constraintWidget.mParent.horizontalRun.end);
                this.widget.mParent.horizontalRun.end.dependencies.add(dependencyNode);
            }
            addDependency(this.widget.horizontalRun.start);
            addDependency(this.widget.horizontalRun.end);
            return;
        }
        if (i != -1) {
            dependencyNode.targets.add(constraintWidget.mParent.verticalRun.start);
            this.widget.mParent.verticalRun.start.dependencies.add(dependencyNode);
            dependencyNode.margin = i;
        } else if (i2 != -1) {
            dependencyNode.targets.add(constraintWidget.mParent.verticalRun.end);
            this.widget.mParent.verticalRun.end.dependencies.add(dependencyNode);
            dependencyNode.margin = -i2;
        } else {
            dependencyNode.delegateToWidgetRun = true;
            dependencyNode.targets.add(constraintWidget.mParent.verticalRun.end);
            this.widget.mParent.verticalRun.end.dependencies.add(dependencyNode);
        }
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        ConstraintWidget constraintWidget = this.widget;
        int i = ((Guideline) constraintWidget).mOrientation;
        DependencyNode dependencyNode = this.start;
        if (i == 1) {
            constraintWidget.mX = dependencyNode.value;
        } else {
            constraintWidget.mY = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve && !dependencyNode.resolved) {
            dependencyNode.resolve((int) ((((DependencyNode) dependencyNode.targets.get(0)).value * ((Guideline) this.widget).mRelativePercent) + 0.5f));
        }
    }
}
