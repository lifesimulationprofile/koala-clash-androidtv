package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HelperReferences extends WidgetRun {
    public final void addDependency$1(DependencyNode dependencyNode) {
        DependencyNode dependencyNode2 = this.start;
        dependencyNode2.dependencies.add(dependencyNode);
        dependencyNode.targets.add(dependencyNode2);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget instanceof Barrier) {
            DependencyNode dependencyNode = this.start;
            dependencyNode.delegateToWidgetRun = true;
            ArrayList arrayList = dependencyNode.targets;
            Barrier barrier = (Barrier) constraintWidget;
            int i = barrier.mBarrierType;
            boolean z = barrier.mAllowsGoneWidget;
            int i2 = 0;
            if (i == 0) {
                dependencyNode.type = 4;
                while (i2 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget2 = barrier.mWidgets[i2];
                    if (z || constraintWidget2.mVisibility != 8) {
                        DependencyNode dependencyNode2 = constraintWidget2.horizontalRun.start;
                        dependencyNode2.dependencies.add(dependencyNode);
                        arrayList.add(dependencyNode2);
                    }
                    i2++;
                }
                addDependency$1(this.widget.horizontalRun.start);
                addDependency$1(this.widget.horizontalRun.end);
                return;
            }
            if (i == 1) {
                dependencyNode.type = 5;
                while (i2 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget3 = barrier.mWidgets[i2];
                    if (z || constraintWidget3.mVisibility != 8) {
                        DependencyNode dependencyNode3 = constraintWidget3.horizontalRun.end;
                        dependencyNode3.dependencies.add(dependencyNode);
                        arrayList.add(dependencyNode3);
                    }
                    i2++;
                }
                addDependency$1(this.widget.horizontalRun.start);
                addDependency$1(this.widget.horizontalRun.end);
                return;
            }
            if (i == 2) {
                dependencyNode.type = 6;
                while (i2 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = barrier.mWidgets[i2];
                    if (z || constraintWidget4.mVisibility != 8) {
                        DependencyNode dependencyNode4 = constraintWidget4.verticalRun.start;
                        dependencyNode4.dependencies.add(dependencyNode);
                        arrayList.add(dependencyNode4);
                    }
                    i2++;
                }
                addDependency$1(this.widget.verticalRun.start);
                addDependency$1(this.widget.verticalRun.end);
                return;
            }
            if (i != 3) {
                return;
            }
            dependencyNode.type = 7;
            while (i2 < barrier.mWidgetsCount) {
                ConstraintWidget constraintWidget5 = barrier.mWidgets[i2];
                if (z || constraintWidget5.mVisibility != 8) {
                    DependencyNode dependencyNode5 = constraintWidget5.verticalRun.end;
                    dependencyNode5.dependencies.add(dependencyNode);
                    arrayList.add(dependencyNode5);
                }
                i2++;
            }
            addDependency$1(this.widget.verticalRun.start);
            addDependency$1(this.widget.verticalRun.end);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget instanceof Barrier) {
            int i = ((Barrier) constraintWidget).mBarrierType;
            DependencyNode dependencyNode = this.start;
            if (i == 0 || i == 1) {
                constraintWidget.mX = dependencyNode.value;
            } else {
                constraintWidget.mY = dependencyNode.value;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.widget;
        int i = barrier.mBarrierType;
        DependencyNode dependencyNode = this.start;
        ArrayList arrayList = dependencyNode.targets;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            int i5 = ((DependencyNode) obj).value;
            if (i3 == -1 || i5 < i3) {
                i3 = i5;
            }
            if (i2 < i5) {
                i2 = i5;
            }
        }
        if (i == 0 || i == 2) {
            dependencyNode.resolve(i3 + barrier.mMargin);
        } else {
            dependencyNode.resolve(i2 + barrier.mMargin);
        }
    }
}
