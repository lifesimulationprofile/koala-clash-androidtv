package okio;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.BaselineDimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference;
import androidx.constraintlayout.solver.widgets.analyzer.HelperReferences;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.RunGroup;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FileMetadata {
    public final /* synthetic */ int $r8$classId = 1;
    public Serializable createdAtMillis;
    public Object extras;
    public boolean isDirectory;
    public boolean isRegularFile;
    public Object lastAccessedAtMillis;
    public Object lastModifiedAtMillis;
    public Object size;
    public Object symlinkTarget;

    public /* synthetic */ FileMetadata() {
    }

    public void applyGroup(DependencyNode dependencyNode, int i, ArrayList arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.run;
        RunGroup runGroup2 = widgetRun.runGroup;
        DependencyNode dependencyNode2 = widgetRun.end;
        DependencyNode dependencyNode3 = widgetRun.start;
        if (runGroup2 == null) {
            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.symlinkTarget;
            if (widgetRun == constraintWidgetContainer.horizontalRun || widgetRun == constraintWidgetContainer.verticalRun) {
                return;
            }
            if (runGroup == null) {
                runGroup = new RunGroup();
                runGroup.firstRun = null;
                runGroup.runs = new ArrayList();
                runGroup.firstRun = widgetRun;
                arrayList.add(runGroup);
            }
            widgetRun.runGroup = runGroup;
            runGroup.runs.add(widgetRun);
            ArrayList arrayList2 = dependencyNode3.dependencies;
            int size = arrayList2.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                Dependency dependency = (Dependency) obj;
                if (dependency instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency, i, arrayList, runGroup);
                }
            }
            ArrayList arrayList3 = dependencyNode2.dependencies;
            int size2 = arrayList3.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList3.get(i4);
                i4++;
                Dependency dependency2 = (Dependency) obj2;
                if (dependency2 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency2, i, arrayList, runGroup);
                }
            }
            if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                ArrayList arrayList4 = ((VerticalWidgetRun) widgetRun).baseline.dependencies;
                int size3 = arrayList4.size();
                int i5 = 0;
                while (i5 < size3) {
                    Object obj3 = arrayList4.get(i5);
                    i5++;
                    Dependency dependency3 = (Dependency) obj3;
                    if (dependency3 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency3, i, arrayList, runGroup);
                    }
                }
            }
            ArrayList arrayList5 = dependencyNode3.targets;
            int size4 = arrayList5.size();
            int i6 = 0;
            while (i6 < size4) {
                Object obj4 = arrayList5.get(i6);
                i6++;
                applyGroup((DependencyNode) obj4, i, arrayList, runGroup);
            }
            ArrayList arrayList6 = dependencyNode2.targets;
            int size5 = arrayList6.size();
            int i7 = 0;
            while (i7 < size5) {
                Object obj5 = arrayList6.get(i7);
                i7++;
                applyGroup((DependencyNode) obj5, i, arrayList, runGroup);
            }
            if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                ArrayList arrayList7 = ((VerticalWidgetRun) widgetRun).baseline.targets;
                int size6 = arrayList7.size();
                while (i2 < size6) {
                    Object obj6 = arrayList7.get(i2);
                    i2++;
                    applyGroup((DependencyNode) obj6, i, arrayList, runGroup);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x019f  */
    /* JADX WARN: Code duplicated, block: B:103:0x01a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:106:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:135:0x026a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x026e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:149:0x02af  */
    /* JADX WARN: Code duplicated, block: B:150:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:156:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:157:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00db A[PHI: r13
      0x00db: PHI (r13v6 int) = (r13v5 int), (r13v12 int) binds: [B:68:0x00d4, B:62:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:82:0x0129  */
    /* JADX WARN: Code duplicated, block: B:84:0x012d  */
    /* JADX WARN: Code duplicated, block: B:85:0x013d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0140  */
    /* JADX WARN: Code duplicated, block: B:89:0x0144  */
    /* JADX WARN: Code duplicated, block: B:96:0x0175  */
    /* JADX WARN: Code duplicated, block: B:98:0x017f  */
    public void basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        int i;
        int i2;
        int width;
        int height;
        int i3;
        int height2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList = constraintWidgetContainer.mChildren;
        int[] iArr = constraintWidgetContainer.mListDimensionBehaviors;
        int size = arrayList.size();
        char c = 0;
        int i14 = 0;
        while (i14 < size) {
            Object obj = arrayList.get(i14);
            i14++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            int[] iArr2 = constraintWidget.mListDimensionBehaviors;
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
            ConstraintAnchor constraintAnchor = constraintWidget.mBottom;
            ConstraintAnchor constraintAnchor2 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor3 = constraintWidget.mRight;
            ConstraintAnchor constraintAnchor4 = constraintWidget.mLeft;
            VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
            HorizontalWidgetRun horizontalWidgetRun = constraintWidget.horizontalRun;
            int i15 = iArr2[c];
            c = c;
            int i16 = iArr2[1];
            if (constraintWidget.mVisibility == 8) {
                constraintWidget.measured = true;
            } else {
                float f = constraintWidget.mMatchConstraintPercentWidth;
                if (f < 1.0f && i15 == 3) {
                    constraintWidget.mMatchConstraintDefaultWidth = 2;
                }
                float f2 = constraintWidget.mMatchConstraintPercentHeight;
                if (f2 < 1.0f && i16 == 3) {
                    constraintWidget.mMatchConstraintDefaultHeight = 2;
                }
                if (constraintWidget.mDimensionRatio > 0.0f) {
                    if (i15 == 3) {
                        i13 = 2;
                        if (i16 == 2 || i16 == 1) {
                            i = 3;
                            constraintWidget.mMatchConstraintDefaultWidth = 3;
                        } else {
                            i = 3;
                        }
                    } else {
                        i = 3;
                        i13 = 2;
                    }
                    if (i16 == i && (i15 == i13 || i15 == 1)) {
                        constraintWidget.mMatchConstraintDefaultHeight = i;
                    } else if (i15 == i && i16 == i) {
                        if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            constraintWidget.mMatchConstraintDefaultWidth = i;
                        }
                        if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                            constraintWidget.mMatchConstraintDefaultHeight = i;
                        }
                    }
                } else {
                    i = 3;
                }
                if (i15 == i && constraintWidget.mMatchConstraintDefaultWidth == 1 && (constraintAnchor4.mTarget == null || constraintAnchor3.mTarget == null)) {
                    i15 = 2;
                }
                if (i16 == 3 && constraintWidget.mMatchConstraintDefaultHeight == 1 && (constraintAnchor2.mTarget == null || constraintAnchor.mTarget == null)) {
                    i16 = 2;
                }
                horizontalWidgetRun.dimensionBehavior = i15;
                DimensionDependency dimensionDependency = horizontalWidgetRun.dimension;
                int i17 = constraintWidget.mMatchConstraintDefaultWidth;
                horizontalWidgetRun.matchConstraintsType = i17;
                verticalWidgetRun.dimensionBehavior = i16;
                DimensionDependency dimensionDependency2 = verticalWidgetRun.dimension;
                ArrayList arrayList2 = arrayList;
                int i18 = constraintWidget.mMatchConstraintDefaultHeight;
                verticalWidgetRun.matchConstraintsType = i18;
                if (i15 == 4 || i15 == 1) {
                    if (i16 == 4) {
                        i2 = 1;
                    } else if (i16 != 1) {
                        i4 = 2;
                        if (i16 == 2) {
                            i2 = 1;
                        } else {
                            if (i15 != 3) {
                                i5 = i16;
                                i6 = 1;
                            } else if (i16 == i4 && i16 != 1) {
                                i5 = i16;
                                i6 = 1;
                                i7 = 3;
                                i4 = i4;
                                if (i5 == i7 || !(i15 == i4 || i15 == i6)) {
                                    i8 = i4;
                                } else if (i18 == i7) {
                                    if (i15 == i4) {
                                        measure(i4, 0, i4, 0, constraintWidget);
                                    }
                                    int width2 = constraintWidget.getWidth();
                                    float f3 = constraintWidget.mDimensionRatio;
                                    if (constraintWidget.mDimensionRatioSide == -1) {
                                        f3 = 1.0f / f3;
                                    }
                                    measure(i6, width2, i6, (int) ((width2 * f3) + 0.5f), constraintWidget);
                                    dimensionDependency.resolve(constraintWidget.getWidth());
                                    dimensionDependency2.resolve(constraintWidget.getHeight());
                                    constraintWidget.measured = true;
                                } else {
                                    i8 = i4;
                                    if (i18 == 1) {
                                        measure(i15, 0, i8, 0, constraintWidget);
                                        dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                    } else {
                                        int i19 = i15;
                                        if (i18 == 2) {
                                            int i20 = iArr[1];
                                            if (i20 == i6 || i20 == 4) {
                                                measure(i19, constraintWidget.getWidth(), i6, (int) ((constraintWidgetContainer.getHeight() * f2) + 0.5f), constraintWidget);
                                                dimensionDependency.resolve(constraintWidget.getWidth());
                                                dimensionDependency2.resolve(constraintWidget.getHeight());
                                                constraintWidget.measured = true;
                                            } else {
                                                i15 = i19;
                                                i7 = 3;
                                            }
                                        } else {
                                            i15 = i19;
                                            if (constraintAnchorArr[2].mTarget == null || constraintAnchorArr[3].mTarget == null) {
                                                measure(i8, 0, i5, 0, constraintWidget);
                                                dimensionDependency.resolve(constraintWidget.getWidth());
                                                dimensionDependency2.resolve(constraintWidget.getHeight());
                                                constraintWidget.measured = true;
                                            } else {
                                                i5 = i5;
                                                i9 = 1;
                                                i7 = 3;
                                                if (i15 == i7 && i5 == i7) {
                                                    if (i17 != i9 || i18 == i9) {
                                                        measure(i8, 0, i8, 0, constraintWidget);
                                                        dimensionDependency.wrapValue = constraintWidget.getWidth();
                                                        dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                                    } else if (i18 == 2 && i17 == 2 && (((i10 = iArr[c]) == i6 || i10 == i6) && ((i11 = iArr[i9]) == i6 || i11 == i6))) {
                                                        measure(i6, (int) ((constraintWidgetContainer.getWidth() * f) + 0.5f), i6, (int) ((constraintWidgetContainer.getHeight() * f2) + 0.5f), constraintWidget);
                                                        dimensionDependency.resolve(constraintWidget.getWidth());
                                                        dimensionDependency2.resolve(constraintWidget.getHeight());
                                                        constraintWidget.measured = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                i9 = 1;
                                if (i15 == i7) {
                                    if (i17 != i9) {
                                        measure(i8, 0, i8, 0, constraintWidget);
                                        dimensionDependency.wrapValue = constraintWidget.getWidth();
                                        dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                    } else {
                                        measure(i8, 0, i8, 0, constraintWidget);
                                        dimensionDependency.wrapValue = constraintWidget.getWidth();
                                        dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                    }
                                }
                            } else if (i17 == 3) {
                                if (i16 == i4) {
                                    measure(i4, 0, i4, 0, constraintWidget);
                                }
                                int height3 = constraintWidget.getHeight();
                                measure(1, (int) ((height3 * constraintWidget.mDimensionRatio) + 0.5f), 1, height3, constraintWidget);
                                dimensionDependency.resolve(constraintWidget.getWidth());
                                dimensionDependency2.resolve(constraintWidget.getHeight());
                                constraintWidget.measured = true;
                            } else if (i17 == 1) {
                                measure(i4, 0, i16, 0, constraintWidget);
                                dimensionDependency.wrapValue = constraintWidget.getWidth();
                            } else if (i17 == 2) {
                                i12 = iArr[c];
                                if (i12 != 1 || i12 == 4) {
                                    measure(1, (int) ((constraintWidgetContainer.getWidth() * f) + 0.5f), i16, constraintWidget.getHeight(), constraintWidget);
                                    dimensionDependency.resolve(constraintWidget.getWidth());
                                    dimensionDependency2.resolve(constraintWidget.getHeight());
                                    constraintWidget.measured = true;
                                } else {
                                    i5 = i16;
                                    i6 = 1;
                                }
                            } else {
                                i5 = i16;
                                i6 = 1;
                                if (constraintAnchorArr[c].mTarget != null || constraintAnchorArr[1].mTarget == null) {
                                    measure(i4, 0, i5, 0, constraintWidget);
                                    dimensionDependency.resolve(constraintWidget.getWidth());
                                    dimensionDependency2.resolve(constraintWidget.getHeight());
                                    constraintWidget.measured = true;
                                }
                            }
                            i7 = 3;
                            if (i5 == i7) {
                                i8 = i4;
                                i9 = 1;
                                if (i15 == i7) {
                                    if (i17 != i9) {
                                        measure(i8, 0, i8, 0, constraintWidget);
                                        dimensionDependency.wrapValue = constraintWidget.getWidth();
                                        dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                    } else {
                                        measure(i8, 0, i8, 0, constraintWidget);
                                        dimensionDependency.wrapValue = constraintWidget.getWidth();
                                        dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                    }
                                }
                            } else {
                                i8 = i4;
                                i9 = 1;
                                if (i15 == i7) {
                                    if (i17 != i9) {
                                        measure(i8, 0, i8, 0, constraintWidget);
                                        dimensionDependency.wrapValue = constraintWidget.getWidth();
                                        dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                    } else {
                                        measure(i8, 0, i8, 0, constraintWidget);
                                        dimensionDependency.wrapValue = constraintWidget.getWidth();
                                        dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                    }
                                }
                            }
                        }
                    } else {
                        i2 = 1;
                    }
                    width = constraintWidget.getWidth();
                    if (i15 == 4) {
                        width = (constraintWidgetContainer.getWidth() - constraintAnchor4.mMargin) - constraintAnchor3.mMargin;
                        i15 = i2;
                    }
                    height = constraintWidget.getHeight();
                    if (i16 == 4) {
                        i3 = i2;
                        height2 = (constraintWidgetContainer.getHeight() - constraintAnchor2.mMargin) - constraintAnchor.mMargin;
                    } else {
                        i3 = i16;
                        height2 = height;
                    }
                    measure(i15, width, i3, height2, constraintWidget);
                    dimensionDependency.resolve(constraintWidget.getWidth());
                    dimensionDependency2.resolve(constraintWidget.getHeight());
                    constraintWidget.measured = true;
                } else {
                    i4 = 2;
                    if (i15 == 2) {
                        if (i16 == 4) {
                            i2 = 1;
                        } else if (i16 != 1) {
                            i4 = 2;
                            if (i16 == 2) {
                                i2 = 1;
                            } else {
                                if (i15 != 3) {
                                    if (i16 == i4) {
                                    }
                                    if (i17 == 3) {
                                        if (i16 == i4) {
                                            measure(i4, 0, i4, 0, constraintWidget);
                                        }
                                        int height4 = constraintWidget.getHeight();
                                        measure(1, (int) ((height4 * constraintWidget.mDimensionRatio) + 0.5f), 1, height4, constraintWidget);
                                        dimensionDependency.resolve(constraintWidget.getWidth());
                                        dimensionDependency2.resolve(constraintWidget.getHeight());
                                        constraintWidget.measured = true;
                                    } else if (i17 == 1) {
                                        measure(i4, 0, i16, 0, constraintWidget);
                                        dimensionDependency.wrapValue = constraintWidget.getWidth();
                                    } else if (i17 == 2) {
                                        i12 = iArr[c];
                                        if (i12 != 1) {
                                        }
                                        measure(1, (int) ((constraintWidgetContainer.getWidth() * f) + 0.5f), i16, constraintWidget.getHeight(), constraintWidget);
                                        dimensionDependency.resolve(constraintWidget.getWidth());
                                        dimensionDependency2.resolve(constraintWidget.getHeight());
                                        constraintWidget.measured = true;
                                    } else {
                                        i5 = i16;
                                        i6 = 1;
                                        if (constraintAnchorArr[c].mTarget != null) {
                                        }
                                        measure(i4, 0, i5, 0, constraintWidget);
                                        dimensionDependency.resolve(constraintWidget.getWidth());
                                        dimensionDependency2.resolve(constraintWidget.getHeight());
                                        constraintWidget.measured = true;
                                    }
                                } else {
                                    i5 = i16;
                                    i6 = 1;
                                }
                                i7 = 3;
                                if (i5 == i7) {
                                    i8 = i4;
                                    i9 = 1;
                                    if (i15 == i7) {
                                        if (i17 != i9) {
                                            measure(i8, 0, i8, 0, constraintWidget);
                                            dimensionDependency.wrapValue = constraintWidget.getWidth();
                                            dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                        } else {
                                            measure(i8, 0, i8, 0, constraintWidget);
                                            dimensionDependency.wrapValue = constraintWidget.getWidth();
                                            dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                        }
                                    }
                                } else {
                                    i8 = i4;
                                    i9 = 1;
                                    if (i15 == i7) {
                                        if (i17 != i9) {
                                            measure(i8, 0, i8, 0, constraintWidget);
                                            dimensionDependency.wrapValue = constraintWidget.getWidth();
                                            dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                        } else {
                                            measure(i8, 0, i8, 0, constraintWidget);
                                            dimensionDependency.wrapValue = constraintWidget.getWidth();
                                            dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                        }
                                    }
                                }
                            }
                        } else {
                            i2 = 1;
                        }
                        width = constraintWidget.getWidth();
                        if (i15 == 4) {
                            width = (constraintWidgetContainer.getWidth() - constraintAnchor4.mMargin) - constraintAnchor3.mMargin;
                            i15 = i2;
                        }
                        height = constraintWidget.getHeight();
                        if (i16 == 4) {
                            i3 = i2;
                            height2 = (constraintWidgetContainer.getHeight() - constraintAnchor2.mMargin) - constraintAnchor.mMargin;
                        } else {
                            i3 = i16;
                            height2 = height;
                        }
                        measure(i15, width, i3, height2, constraintWidget);
                        dimensionDependency.resolve(constraintWidget.getWidth());
                        dimensionDependency2.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                    } else {
                        if (i15 != 3) {
                            if (i16 == i4) {
                            }
                            if (i17 == 3) {
                                if (i16 == i4) {
                                    measure(i4, 0, i4, 0, constraintWidget);
                                }
                                int height5 = constraintWidget.getHeight();
                                measure(1, (int) ((height5 * constraintWidget.mDimensionRatio) + 0.5f), 1, height5, constraintWidget);
                                dimensionDependency.resolve(constraintWidget.getWidth());
                                dimensionDependency2.resolve(constraintWidget.getHeight());
                                constraintWidget.measured = true;
                            } else if (i17 == 1) {
                                measure(i4, 0, i16, 0, constraintWidget);
                                dimensionDependency.wrapValue = constraintWidget.getWidth();
                            } else if (i17 == 2) {
                                i12 = iArr[c];
                                if (i12 != 1) {
                                }
                                measure(1, (int) ((constraintWidgetContainer.getWidth() * f) + 0.5f), i16, constraintWidget.getHeight(), constraintWidget);
                                dimensionDependency.resolve(constraintWidget.getWidth());
                                dimensionDependency2.resolve(constraintWidget.getHeight());
                                constraintWidget.measured = true;
                            } else {
                                i5 = i16;
                                i6 = 1;
                                if (constraintAnchorArr[c].mTarget != null) {
                                }
                                measure(i4, 0, i5, 0, constraintWidget);
                                dimensionDependency.resolve(constraintWidget.getWidth());
                                dimensionDependency2.resolve(constraintWidget.getHeight());
                                constraintWidget.measured = true;
                            }
                        } else {
                            i5 = i16;
                            i6 = 1;
                        }
                        i7 = 3;
                        if (i5 == i7) {
                            i8 = i4;
                            i9 = 1;
                            if (i15 == i7) {
                                if (i17 != i9) {
                                    measure(i8, 0, i8, 0, constraintWidget);
                                    dimensionDependency.wrapValue = constraintWidget.getWidth();
                                    dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                } else {
                                    measure(i8, 0, i8, 0, constraintWidget);
                                    dimensionDependency.wrapValue = constraintWidget.getWidth();
                                    dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                }
                            }
                        } else {
                            i8 = i4;
                            i9 = 1;
                            if (i15 == i7) {
                                if (i17 != i9) {
                                    measure(i8, 0, i8, 0, constraintWidget);
                                    dimensionDependency.wrapValue = constraintWidget.getWidth();
                                    dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                } else {
                                    measure(i8, 0, i8, 0, constraintWidget);
                                    dimensionDependency.wrapValue = constraintWidget.getWidth();
                                    dimensionDependency2.wrapValue = constraintWidget.getHeight();
                                }
                            }
                        }
                    }
                }
                arrayList = arrayList2;
            }
        }
    }

    public void buildGraph() {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.symlinkTarget;
        ArrayList arrayList = (ArrayList) this.extras;
        ArrayList arrayList2 = (ArrayList) this.createdAtMillis;
        arrayList2.clear();
        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) this.size;
        constraintWidgetContainer2.horizontalRun.clear();
        VerticalWidgetRun verticalWidgetRun = constraintWidgetContainer2.verticalRun;
        verticalWidgetRun.clear();
        arrayList2.add(constraintWidgetContainer2.horizontalRun);
        arrayList2.add(verticalWidgetRun);
        ArrayList arrayList3 = constraintWidgetContainer2.mChildren;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            if (constraintWidget instanceof Guideline) {
                GuidelineReference guidelineReference = new GuidelineReference(constraintWidget);
                constraintWidget.horizontalRun.clear();
                constraintWidget.verticalRun.clear();
                guidelineReference.orientation = ((Guideline) constraintWidget).mOrientation;
                arrayList2.add(guidelineReference);
            } else {
                if (constraintWidget.isInHorizontalChain()) {
                    if (constraintWidget.horizontalChainRun == null) {
                        constraintWidget.horizontalChainRun = new ChainRun(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.horizontalChainRun);
                } else {
                    arrayList2.add(constraintWidget.horizontalRun);
                }
                if (constraintWidget.isInVerticalChain()) {
                    if (constraintWidget.verticalChainRun == null) {
                        constraintWidget.verticalChainRun = new ChainRun(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.verticalChainRun);
                } else {
                    arrayList2.add(constraintWidget.verticalRun);
                }
                if (constraintWidget instanceof Barrier) {
                    arrayList2.add(new HelperReferences(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            ((WidgetRun) obj2).clear();
        }
        int size3 = arrayList2.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            WidgetRun widgetRun = (WidgetRun) obj3;
            if (widgetRun.widget != constraintWidgetContainer2) {
                widgetRun.apply();
            }
        }
        arrayList.clear();
        findGroup(constraintWidgetContainer.horizontalRun, 0, arrayList);
        findGroup(constraintWidgetContainer.verticalRun, 1, arrayList);
        this.isRegularFile = false;
    }

    public int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        ArrayList arrayList;
        int i2;
        long wrapDimension;
        float f;
        long j;
        ArrayList arrayList2 = (ArrayList) this.extras;
        int size = arrayList2.size();
        long j2 = 0;
        int i3 = 0;
        long jMax = 0;
        while (i3 < size) {
            WidgetRun widgetRun = ((RunGroup) arrayList2.get(i3)).firstRun;
            if (!(widgetRun instanceof ChainRun) ? !(i != 0 ? (widgetRun instanceof VerticalWidgetRun) : (widgetRun instanceof HorizontalWidgetRun)) : ((ChainRun) widgetRun).orientation != i) {
                DependencyNode dependencyNode = (i == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).start;
                DependencyNode dependencyNode2 = (i == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).end;
                DependencyNode dependencyNode3 = widgetRun.start;
                DependencyNode dependencyNode4 = widgetRun.end;
                boolean zContains = dependencyNode3.targets.contains(dependencyNode);
                boolean zContains2 = dependencyNode4.targets.contains(dependencyNode2);
                long wrapDimension2 = widgetRun.getWrapDimension();
                if (zContains && zContains2) {
                    long jTraverseStart = RunGroup.traverseStart(dependencyNode3, j2);
                    long jTraverseEnd = RunGroup.traverseEnd(dependencyNode4, j2);
                    long j3 = jTraverseStart - wrapDimension2;
                    int i4 = dependencyNode4.margin;
                    arrayList = arrayList2;
                    i2 = size;
                    if (j3 >= (-i4)) {
                        j3 += (long) i4;
                    }
                    long j4 = dependencyNode3.margin;
                    long j5 = ((-jTraverseEnd) - wrapDimension2) - j4;
                    if (j5 >= j4) {
                        j5 -= j4;
                    }
                    ConstraintWidget constraintWidget = widgetRun.widget;
                    if (i == 0) {
                        f = constraintWidget.mHorizontalBiasPercent;
                    } else if (i == 1) {
                        f = constraintWidget.mVerticalBiasPercent;
                    } else {
                        constraintWidget.getClass();
                        f = -1.0f;
                    }
                    if (f > 0.0f) {
                        j = (long) ((j3 / (1.0f - f)) + (j5 / f));
                    } else {
                        j = 0;
                    }
                    float f2 = j;
                    wrapDimension = (((long) dependencyNode3.margin) + ((((long) ((f2 * f) + 0.5f)) + wrapDimension2) + ((long) ImageAnalysis$$ExternalSyntheticLambda1.m(1.0f, f, f2, 0.5f)))) - ((long) dependencyNode4.margin);
                } else {
                    arrayList = arrayList2;
                    i2 = size;
                    if (zContains) {
                        wrapDimension = Math.max(RunGroup.traverseStart(dependencyNode3, dependencyNode3.margin), ((long) dependencyNode3.margin) + wrapDimension2);
                    } else if (zContains2) {
                        wrapDimension = Math.max(-RunGroup.traverseEnd(dependencyNode4, dependencyNode4.margin), ((long) (-dependencyNode4.margin)) + wrapDimension2);
                    } else {
                        wrapDimension = (widgetRun.getWrapDimension() + ((long) dependencyNode3.margin)) - ((long) dependencyNode4.margin);
                    }
                }
            } else {
                arrayList = arrayList2;
                i2 = size;
                wrapDimension = j2;
            }
            jMax = Math.max(jMax, wrapDimension);
            i3++;
            arrayList2 = arrayList;
            size = i2;
            j2 = 0;
        }
        return (int) jMax;
    }

    public void findGroup(WidgetRun widgetRun, int i, ArrayList arrayList) {
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        ArrayList arrayList2 = dependencyNode.dependencies;
        int size = arrayList2.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            Dependency dependency = (Dependency) obj;
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i, arrayList, null);
            }
        }
        ArrayList arrayList3 = dependencyNode2.dependencies;
        int size2 = arrayList3.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj2 = arrayList3.get(i4);
            i4++;
            Dependency dependency2 = (Dependency) obj2;
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i, arrayList, null);
            }
        }
        if (i == 1) {
            ArrayList arrayList4 = ((VerticalWidgetRun) widgetRun).baseline.dependencies;
            int size3 = arrayList4.size();
            while (i2 < size3) {
                Object obj3 = arrayList4.get(i2);
                i2++;
                Dependency dependency3 = (Dependency) obj3;
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i, arrayList, null);
                }
            }
        }
    }

    public void measure(int i, int i2, int i3, int i4, ConstraintWidget constraintWidget) {
        BasicMeasure$Measure basicMeasure$Measure = (BasicMeasure$Measure) this.lastAccessedAtMillis;
        basicMeasure$Measure.horizontalBehavior = i;
        basicMeasure$Measure.verticalBehavior = i3;
        basicMeasure$Measure.horizontalDimension = i2;
        basicMeasure$Measure.verticalDimension = i4;
        ((ConstraintLayout.Measurer) this.lastModifiedAtMillis).measure(constraintWidget, basicMeasure$Measure);
        constraintWidget.setWidth(basicMeasure$Measure.measuredWidth);
        constraintWidget.setHeight(basicMeasure$Measure.measuredHeight);
        constraintWidget.hasBaseline = basicMeasure$Measure.measuredHasBaseline;
        int i5 = basicMeasure$Measure.measuredBaseline;
        constraintWidget.mBaselineDistance = i5;
        constraintWidget.hasBaseline = i5 > 0;
    }

    public void measureWidgets() {
        BaselineDimensionDependency baselineDimensionDependency;
        FileMetadata fileMetadata = this;
        ArrayList arrayList = ((ConstraintWidgetContainer) fileMetadata.symlinkTarget).mChildren;
        int size = arrayList.size();
        char c = 0;
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayList.get(i);
            boolean z = constraintWidget.measured;
            HorizontalWidgetRun horizontalWidgetRun = constraintWidget.horizontalRun;
            VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
            if (!z) {
                int[] iArr = constraintWidget.mListDimensionBehaviors;
                int i3 = iArr[c];
                int i4 = iArr[1];
                int i5 = constraintWidget.mMatchConstraintDefaultWidth;
                int i6 = constraintWidget.mMatchConstraintDefaultHeight;
                char c2 = (i3 == 2 || (i3 == 3 && i5 == 1)) ? (char) 1 : c;
                char c3 = (i4 == 2 || (i4 == 3 && i6 == 1)) ? (char) 1 : c;
                DimensionDependency dimensionDependency = horizontalWidgetRun.dimension;
                DimensionDependency dimensionDependency2 = horizontalWidgetRun.dimension;
                boolean z2 = dimensionDependency.resolved;
                DimensionDependency dimensionDependency3 = verticalWidgetRun.dimension;
                DimensionDependency dimensionDependency4 = verticalWidgetRun.dimension;
                boolean z3 = dimensionDependency3.resolved;
                char c4 = c2;
                if (z2 && z3) {
                    fileMetadata.measure(1, dimensionDependency.value, 1, dimensionDependency3.value, constraintWidget);
                    constraintWidget.measured = true;
                } else if (z2 && c3 != 0) {
                    measure(1, dimensionDependency.value, 2, dimensionDependency3.value, constraintWidget);
                    if (i4 == 3) {
                        dimensionDependency4.wrapValue = constraintWidget.getHeight();
                    } else {
                        dimensionDependency4.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                    }
                } else if (z3 && c4 != 0) {
                    measure(2, dimensionDependency.value, 1, dimensionDependency3.value, constraintWidget);
                    if (i3 == 3) {
                        dimensionDependency2.wrapValue = constraintWidget.getWidth();
                    } else {
                        dimensionDependency2.resolve(constraintWidget.getWidth());
                        constraintWidget.measured = true;
                    }
                }
                if (constraintWidget.measured && (baselineDimensionDependency = verticalWidgetRun.baselineDimension) != null) {
                    baselineDimensionDependency.resolve(constraintWidget.mBaselineDistance);
                }
                c = 0;
                fileMetadata = this;
            }
            i = i2;
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                Map map = (Map) this.extras;
                Long l = (Long) this.lastAccessedAtMillis;
                Long l2 = (Long) this.lastModifiedAtMillis;
                Long l3 = (Long) this.createdAtMillis;
                Long l4 = (Long) this.size;
                ArrayList arrayList = new ArrayList();
                if (this.isRegularFile) {
                    arrayList.add("isRegularFile");
                }
                if (this.isDirectory) {
                    arrayList.add("isDirectory");
                }
                if (l4 != null) {
                    arrayList.add("byteCount=" + l4);
                }
                if (l3 != null) {
                    arrayList.add("createdAt=" + l3);
                }
                if (l2 != null) {
                    arrayList.add("lastModifiedAt=" + l2);
                }
                if (l != null) {
                    arrayList.add("lastAccessedAt=" + l);
                }
                if (!map.isEmpty()) {
                    arrayList.add("extras=" + map);
                }
                return CollectionsKt.joinToString$default(arrayList, ", ", "FileMetadata(", ")", null, 56);
            default:
                return super.toString();
        }
    }

    public FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map) {
        this.isRegularFile = z;
        this.isDirectory = z2;
        this.symlinkTarget = path;
        this.size = l;
        this.createdAtMillis = l2;
        this.lastModifiedAtMillis = l3;
        this.lastAccessedAtMillis = l4;
        this.extras = MapsKt__MapsKt.toMap(map);
    }

    public /* synthetic */ FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4) {
        this(z, z2, path, l, l2, l3, l4, EmptyMap.INSTANCE);
    }
}
