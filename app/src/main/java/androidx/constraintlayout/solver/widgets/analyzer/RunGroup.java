package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RunGroup {
    public WidgetRun firstRun;
    public ArrayList runs;

    public static long traverseEnd(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.run;
        ArrayList arrayList = dependencyNode.dependencies;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = arrayList.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = (Dependency) arrayList.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    jMin = Math.min(jMin, traverseEnd(dependencyNode2, ((long) dependencyNode2.margin) + j));
                }
            }
        }
        DependencyNode dependencyNode3 = widgetRun.end;
        DependencyNode dependencyNode4 = widgetRun.start;
        if (dependencyNode != dependencyNode3) {
            return jMin;
        }
        long wrapDimension = j - widgetRun.getWrapDimension();
        return Math.min(Math.min(jMin, traverseEnd(dependencyNode4, wrapDimension)), wrapDimension - ((long) dependencyNode4.margin));
    }

    public static long traverseStart(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.run;
        ArrayList arrayList = dependencyNode.dependencies;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = arrayList.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = (Dependency) arrayList.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    jMax = Math.max(jMax, traverseStart(dependencyNode2, ((long) dependencyNode2.margin) + j));
                }
            }
        }
        DependencyNode dependencyNode3 = widgetRun.start;
        DependencyNode dependencyNode4 = widgetRun.end;
        if (dependencyNode != dependencyNode3) {
            return jMax;
        }
        long wrapDimension = widgetRun.getWrapDimension() + j;
        return Math.max(Math.max(jMax, traverseStart(dependencyNode4, wrapDimension)), wrapDimension - ((long) dependencyNode4.margin));
    }
}
