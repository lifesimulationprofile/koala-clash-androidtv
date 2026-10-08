package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MenuHostHelper;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.Dispatcher;
import okio.FileMetadata;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintWidgetContainer extends ConstraintWidget {
    public final FileMetadata mDependencyGraph;
    public boolean mHeightMeasuredTooSmall;
    public ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mIsRtl;
    public ConstraintLayout.Measurer mMeasurer;
    public int mOptimizationLevel;
    public int mPaddingLeft;
    public int mPaddingTop;
    public final LinearSystem mSystem;
    public ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mWidthMeasuredTooSmall;
    public ArrayList mChildren = new ArrayList();
    public final MenuHostHelper mBasicMeasureSolver = new MenuHostHelper(this);

    public ConstraintWidgetContainer() {
        FileMetadata fileMetadata = new FileMetadata();
        fileMetadata.isRegularFile = true;
        fileMetadata.isDirectory = true;
        fileMetadata.createdAtMillis = new ArrayList();
        new ArrayList();
        fileMetadata.lastModifiedAtMillis = null;
        fileMetadata.lastAccessedAtMillis = new BasicMeasure$Measure();
        fileMetadata.extras = new ArrayList();
        fileMetadata.symlinkTarget = this;
        fileMetadata.size = this;
        this.mDependencyGraph = fileMetadata;
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mOptimizationLevel = 263;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
    }

    public final void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            int i2 = this.mHorizontalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
            if (i2 >= chainHeadArr.length) {
                this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            ChainHead[] chainHeadArr2 = this.mHorizontalChainsArray;
            int i3 = this.mHorizontalChainsSize;
            chainHeadArr2[i3] = new ChainHead(constraintWidget, 0, this.mIsRtl);
            this.mHorizontalChainsSize = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.mVerticalChainsSize + 1;
            ChainHead[] chainHeadArr3 = this.mVerticalChainsArray;
            if (i4 >= chainHeadArr3.length) {
                this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr3, chainHeadArr3.length * 2);
            }
            ChainHead[] chainHeadArr4 = this.mVerticalChainsArray;
            int i5 = this.mVerticalChainsSize;
            chainHeadArr4[i5] = new ChainHead(constraintWidget, 1, this.mIsRtl);
            this.mVerticalChainsSize = i5 + 1;
        }
    }

    public final void addChildrenToSolver(LinearSystem linearSystem) {
        int i;
        int i2;
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        char c = 0;
        int i3 = 0;
        boolean z = false;
        while (true) {
            i = 1;
            if (i3 >= size) {
                break;
            }
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i3);
            boolean[] zArr = constraintWidget.mIsInBarrier;
            zArr[0] = false;
            zArr[1] = false;
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
            i3++;
        }
        if (z) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.mChildren.get(i4);
                if (constraintWidget2 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget2;
                    for (int i5 = 0; i5 < barrier.mWidgetsCount; i5++) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[i5];
                        int i6 = barrier.mBarrierType;
                        if (i6 == 0 || i6 == 1) {
                            constraintWidget3.mIsInBarrier[0] = true;
                        } else if (i6 == 2 || i6 == 3) {
                            constraintWidget3.mIsInBarrier[1] = true;
                        }
                    }
                }
            }
        }
        for (int i7 = 0; i7 < size; i7++) {
            ConstraintWidget constraintWidget4 = (ConstraintWidget) this.mChildren.get(i7);
            constraintWidget4.getClass();
            if (constraintWidget4 instanceof Guideline) {
                constraintWidget4.addToSolver(linearSystem);
            }
        }
        int i8 = 0;
        while (i8 < size) {
            ConstraintWidget constraintWidget5 = (ConstraintWidget) this.mChildren.get(i8);
            if (constraintWidget5 instanceof ConstraintWidgetContainer) {
                int[] iArr = constraintWidget5.mListDimensionBehaviors;
                int i9 = iArr[c];
                int i10 = iArr[i];
                if (i9 == 2) {
                    constraintWidget5.setHorizontalDimensionBehaviour(i);
                }
                if (i10 == 2) {
                    constraintWidget5.setVerticalDimensionBehaviour(i);
                }
                constraintWidget5.addToSolver(linearSystem);
                if (i9 == 2) {
                    constraintWidget5.setHorizontalDimensionBehaviour(i9);
                }
                if (i10 == 2) {
                    constraintWidget5.setVerticalDimensionBehaviour(i10);
                }
                i2 = i;
            } else {
                constraintWidget5.mHorizontalResolution = -1;
                ConstraintAnchor constraintAnchor = constraintWidget5.mBaseline;
                int[] iArr2 = constraintWidget5.mListDimensionBehaviors;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.mBottom;
                ConstraintAnchor constraintAnchor3 = constraintWidget5.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget5.mRight;
                ConstraintAnchor constraintAnchor5 = constraintWidget5.mLeft;
                constraintWidget5.mVerticalResolution = -1;
                int[] iArr3 = this.mListDimensionBehaviors;
                i2 = i;
                if (iArr3[c] != 2 && iArr2[c] == 4) {
                    int i11 = constraintAnchor5.mMargin;
                    int width = getWidth() - constraintAnchor4.mMargin;
                    constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
                    constraintAnchor4.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor4);
                    linearSystem.addEquality(constraintAnchor5.mSolverVariable, i11);
                    linearSystem.addEquality(constraintAnchor4.mSolverVariable, width);
                    constraintWidget5.mHorizontalResolution = 2;
                    constraintWidget5.mX = i11;
                    int i12 = width - i11;
                    constraintWidget5.mWidth = i12;
                    int i13 = constraintWidget5.mMinWidth;
                    if (i12 < i13) {
                        constraintWidget5.mWidth = i13;
                    }
                }
                if (iArr3[i2] != 2 && iArr2[i2] == 4) {
                    int i14 = constraintAnchor3.mMargin;
                    int height = getHeight() - constraintAnchor2.mMargin;
                    constraintAnchor3.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor3);
                    constraintAnchor2.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor2);
                    linearSystem.addEquality(constraintAnchor3.mSolverVariable, i14);
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, height);
                    if (constraintWidget5.mBaselineDistance > 0 || constraintWidget5.mVisibility == 8) {
                        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
                        constraintAnchor.mSolverVariable = solverVariableCreateObjectVariable;
                        linearSystem.addEquality(solverVariableCreateObjectVariable, constraintWidget5.mBaselineDistance + i14);
                    }
                    constraintWidget5.mVerticalResolution = 2;
                    constraintWidget5.mY = i14;
                    int i15 = height - i14;
                    constraintWidget5.mHeight = i15;
                    int i16 = constraintWidget5.mMinHeight;
                    if (i15 < i16) {
                        constraintWidget5.mHeight = i16;
                    }
                }
                if (!(constraintWidget5 instanceof Guideline)) {
                    constraintWidget5.addToSolver(linearSystem);
                }
            }
            i8++;
            i = i2;
            c = 0;
        }
        int i17 = i;
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, i17);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean directMeasureWithOrientation(int i, boolean z) {
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        FileMetadata fileMetadata = this.mDependencyGraph;
        ArrayList arrayList = (ArrayList) fileMetadata.createdAtMillis;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
        int i4 = 0;
        int dimensionBehaviour = constraintWidgetContainer.getDimensionBehaviour(0);
        int[] iArr = constraintWidgetContainer.mListDimensionBehaviors;
        VerticalWidgetRun verticalWidgetRun = constraintWidgetContainer.verticalRun;
        HorizontalWidgetRun horizontalWidgetRun = constraintWidgetContainer.horizontalRun;
        int dimensionBehaviour2 = constraintWidgetContainer.getDimensionBehaviour(1);
        int x = constraintWidgetContainer.getX();
        int y = constraintWidgetContainer.getY();
        if (z && (dimensionBehaviour == 2 || dimensionBehaviour2 == 2)) {
            int size = arrayList.size();
            while (true) {
                if (i4 >= size) {
                    z4 = z;
                    break;
                }
                Object obj = arrayList.get(i4);
                i4++;
                WidgetRun widgetRun = (WidgetRun) obj;
                if (widgetRun.orientation == i && !widgetRun.supportsWrapComputation()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && dimensionBehaviour == 2) {
                    constraintWidgetContainer.setHorizontalDimensionBehaviour(1);
                    constraintWidgetContainer.setWidth(fileMetadata.computeWrap(constraintWidgetContainer, 0));
                    horizontalWidgetRun.dimension.resolve(constraintWidgetContainer.getWidth());
                }
            } else if (z4 && dimensionBehaviour2 == 2) {
                constraintWidgetContainer.setVerticalDimensionBehaviour(1);
                constraintWidgetContainer.setHeight(fileMetadata.computeWrap(constraintWidgetContainer, 1));
                verticalWidgetRun.dimension.resolve(constraintWidgetContainer.getHeight());
            }
        }
        if (i == 0) {
            i2 = 0;
            int i5 = iArr[0];
            if (i5 == 1 || i5 == 4) {
                int width = constraintWidgetContainer.getWidth() + x;
                horizontalWidgetRun.end.resolve(width);
                horizontalWidgetRun.dimension.resolve(width - x);
                z2 = true;
                i3 = 1;
            } else {
                z2 = true;
                i3 = i2;
            }
        } else {
            z2 = true;
            i2 = 0;
            int i6 = iArr[1];
            if (i6 == 1 || i6 == 4) {
                int height = constraintWidgetContainer.getHeight() + y;
                verticalWidgetRun.end.resolve(height);
                verticalWidgetRun.dimension.resolve(height - y);
                i3 = 1;
            } else {
                i3 = i2;
            }
        }
        fileMetadata.measureWidgets();
        int size2 = arrayList.size();
        int i7 = i2;
        while (i7 < size2) {
            Object obj2 = arrayList.get(i7);
            i7++;
            WidgetRun widgetRun2 = (WidgetRun) obj2;
            if (widgetRun2.orientation == i && (widgetRun2.widget != constraintWidgetContainer || widgetRun2.resolved)) {
                widgetRun2.applyToWidget();
            }
        }
        int size3 = arrayList.size();
        int i8 = i2;
        while (i8 < size3) {
            Object obj3 = arrayList.get(i8);
            i8++;
            WidgetRun widgetRun3 = (WidgetRun) obj3;
            if (widgetRun3.orientation == i && (i3 != 0 || widgetRun3.widget != constraintWidgetContainer)) {
                if (!widgetRun3.start.resolved || !widgetRun3.end.resolved || (!(widgetRun3 instanceof ChainRun) && !widgetRun3.dimension.resolved)) {
                    z3 = i2;
                    constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    return z3;
                }
            }
        }
        z3 = z2;
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z3;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:60:0x0107 A[LOOP:3: B:59:0x0105->B:60:0x0107, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x0115  */
    /* JADX WARN: Code duplicated, block: B:63:0x011c A[LOOP:5: B:62:0x011a->B:63:0x011c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:82:0x018e  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:96:0x01db  */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v44 */
    public final void layout() {
        boolean z;
        boolean z2;
        boolean[] zArr;
        int i;
        boolean z3;
        int iMax;
        boolean z4;
        boolean z5;
        int iMax2;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        ?? r2;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int size;
        int i2;
        boolean z15;
        boolean z16 = false;
        this.mX = 0;
        this.mY = 0;
        int iMax3 = Math.max(0, getWidth());
        int iMax4 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int i3 = this.mOptimizationLevel;
        boolean z17 = true;
        boolean z18 = (i3 & 64) == 64 || (i3 & 128) == 128;
        LinearSystem linearSystem = this.mSystem;
        linearSystem.getClass();
        linearSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel != 0 && z18) {
            linearSystem.newgraphOptimizer = true;
        }
        int[] iArr = this.mListDimensionBehaviors;
        int i4 = iArr[1];
        int i5 = iArr[0];
        ArrayList arrayList = this.mChildren;
        int i6 = 2;
        boolean z19 = i5 == 2 || i4 == 2;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        int size2 = arrayList.size();
        for (int i7 = 0; i7 < size2; i7++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i7);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ((ConstraintWidgetContainer) constraintWidget).layout();
            }
        }
        int i8 = 0;
        boolean z20 = false;
        boolean z21 = true;
        while (z21) {
            boolean z22 = z17;
            int i9 = i8 + 1;
            try {
                linearSystem.reset();
                this.mHorizontalChainsSize = z16 ? 1 : 0;
                this.mVerticalChainsSize = z16 ? 1 : 0;
                createObjectVariables(linearSystem);
                int i10 = z16 ? 1 : 0;
                while (i10 < size2) {
                    z = z16;
                    try {
                        ((ConstraintWidget) this.mChildren.get(i10)).createObjectVariables(linearSystem);
                        i10++;
                        z16 = z ? 1 : 0;
                    } catch (Exception e) {
                        e = e;
                        z15 = z21;
                        e.printStackTrace();
                        System.out.println("EXCEPTION : " + e);
                        z2 = z15;
                        zArr = Chain.flags;
                        if (z2) {
                            zArr[i6] = z;
                            updateFromSolver(linearSystem);
                            size = this.mChildren.size();
                            for (i2 = z ? 1 : 0; i2 < size; i2++) {
                                ((ConstraintWidget) this.mChildren.get(i2)).updateFromSolver(linearSystem);
                            }
                        } else {
                            updateFromSolver(linearSystem);
                            for (i = z ? 1 : 0; i < size2; i++) {
                                ((ConstraintWidget) this.mChildren.get(i)).updateFromSolver(linearSystem);
                            }
                        }
                        if (z19) {
                            z3 = z ? 1 : 0;
                        } else {
                            z3 = z ? 1 : 0;
                        }
                        z3 = z14;
                        z3 = z14;
                        iMax = Math.max(this.mMinWidth, getWidth());
                        z5 = z3;
                        z4 = z20;
                        if (iMax > getWidth()) {
                            setWidth(iMax);
                            iArr[z ? 1 : 0] = z22 ? 1 : 0;
                            boolean z23 = z22 ? 1 : 0;
                            z4 = z23 ? 1 : 0;
                            z5 = z23;
                        }
                        iMax2 = Math.max(this.mMinHeight, getHeight());
                        z7 = z5;
                        z6 = z4;
                        if (iMax2 > getHeight()) {
                            setHeight(iMax2);
                            iArr[z22 ? 1 : 0] = z22 ? 1 : 0;
                            z13 = z22 ? 1 : 0;
                            z6 = z13 ? 1 : 0;
                        }
                        if (z6) {
                            z7 = z13;
                            i6 = 2;
                            z9 = z7;
                            z8 = z6;
                        } else {
                            if (iArr[z ? 1 : 0] == 2) {
                                z7 = z13;
                                r2 = z22 ? 1 : 0;
                                z12 = z7;
                                z11 = z6;
                            } else {
                                z7 = z13;
                                r2 = z22 ? 1 : 0;
                                z12 = z7;
                                z11 = z6;
                            }
                            i6 = 2;
                            z9 = z12;
                            z9 = z12;
                            z8 = z11;
                            z8 = z11;
                            if (iArr[r2] != 2) {
                            }
                            i8 = i9;
                            z16 = z ? 1 : 0;
                            iArr = iArr;
                            z17 = true;
                            z21 = z10;
                            z20 = z8;
                        }
                        z9 = z12;
                        z8 = z11;
                        z10 = z9;
                        i8 = i9;
                        z16 = z ? 1 : 0;
                        iArr = iArr;
                        z17 = true;
                        z21 = z10;
                        z20 = z8;
                    }
                }
                z = z16;
                addChildrenToSolver(linearSystem);
                try {
                    PriorityGoalRow priorityGoalRow = linearSystem.mGoal;
                    if (linearSystem.newgraphOptimizer) {
                        int i11 = z ? 1 : 0;
                        while (true) {
                            if (i11 >= linearSystem.mNumRows) {
                                for (int i12 = z ? 1 : 0; i12 < linearSystem.mNumRows; i12++) {
                                    ArrayRow arrayRow = linearSystem.mRows[i12];
                                    arrayRow.variable.computedValue = arrayRow.constantValue;
                                }
                                break;
                            }
                            if (!linearSystem.mRows[i11].isSimpleDefinition) {
                                linearSystem.minimizeGoal(priorityGoalRow);
                                break;
                            }
                            i11++;
                        }
                    } else {
                        linearSystem.minimizeGoal(priorityGoalRow);
                    }
                    z2 = z22 ? 1 : 0;
                } catch (Exception e2) {
                    e = e2;
                    z15 = z22 ? 1 : 0;
                    e.printStackTrace();
                    System.out.println("EXCEPTION : " + e);
                    z2 = z15;
                }
            } catch (Exception e3) {
                e = e3;
                z = z16 ? 1 : 0;
                z15 = z21;
            }
            zArr = Chain.flags;
            if (z2) {
                zArr[i6] = z;
                updateFromSolver(linearSystem);
                size = this.mChildren.size();
                while (i2 < size) {
                    ((ConstraintWidget) this.mChildren.get(i2)).updateFromSolver(linearSystem);
                }
            } else {
                updateFromSolver(linearSystem);
                while (i < size2) {
                    ((ConstraintWidget) this.mChildren.get(i)).updateFromSolver(linearSystem);
                }
            }
            if (z19 || i9 >= 8 || !zArr[i6]) {
                z3 = z ? 1 : 0;
            } else {
                int i13 = z ? 1 : 0;
                int iMax5 = i13;
                int iMax6 = iMax5;
                while (i13 < size2) {
                    ConstraintWidget constraintWidget2 = (ConstraintWidget) this.mChildren.get(i13);
                    iMax5 = Math.max(iMax5, constraintWidget2.getWidth() + constraintWidget2.mX);
                    iMax6 = Math.max(iMax6, constraintWidget2.getHeight() + constraintWidget2.mY);
                    i13++;
                }
                int iMax7 = Math.max(this.mMinWidth, iMax5);
                int iMax8 = Math.max(this.mMinHeight, iMax6);
                int i14 = i6;
                if (i5 != i14 || getWidth() >= iMax7) {
                    z3 = z ? 1 : 0;
                    z20 = z20;
                } else {
                    setWidth(iMax7);
                    iArr[z ? 1 : 0] = i14;
                    z14 = z22 ? 1 : 0;
                    z20 = z14 ? 1 : 0;
                }
                if (i4 == i14 && getHeight() < iMax8) {
                    z3 = z14;
                    setHeight(iMax8);
                    iArr[z22 ? 1 : 0] = i14;
                    z3 = z22 ? 1 : 0;
                    z20 = z3 ? 1 : 0;
                }
            }
            z3 = z14;
            z3 = z14;
            iMax = Math.max(this.mMinWidth, getWidth());
            z5 = z3;
            z4 = z20;
            if (iMax > getWidth()) {
                setWidth(iMax);
                iArr[z ? 1 : 0] = z22 ? 1 : 0;
                boolean z24 = z22 ? 1 : 0;
                z4 = z24 ? 1 : 0;
                z5 = z24;
            }
            iMax2 = Math.max(this.mMinHeight, getHeight());
            z7 = z5;
            z6 = z4;
            if (iMax2 > getHeight()) {
                setHeight(iMax2);
                iArr[z22 ? 1 : 0] = z22 ? 1 : 0;
                z13 = z22 ? 1 : 0;
                z6 = z13 ? 1 : 0;
            }
            if (z6) {
                if (iArr[z ? 1 : 0] == 2 || iMax3 <= 0 || getWidth() <= iMax3) {
                    z7 = z13;
                    r2 = z22 ? 1 : 0;
                    z12 = z7;
                    z11 = z6;
                } else {
                    boolean z25 = z22 ? 1 : 0;
                    this.mWidthMeasuredTooSmall = z25;
                    iArr[z ? 1 : 0] = z25 ? 1 : 0;
                    setWidth(iMax3);
                    boolean z26 = z25 ? 1 : 0;
                    z11 = z26 ? 1 : 0;
                    z12 = z26;
                    r2 = z25;
                }
                i6 = 2;
                z9 = z12;
                z9 = z12;
                z8 = z11;
                z8 = z11;
                if (iArr[r2] != 2 && iMax4 > 0 && getHeight() > iMax4) {
                    z9 = z12;
                    z8 = z11;
                    this.mHeightMeasuredTooSmall = r2;
                    iArr[r2] = r2;
                    setHeight(iMax4);
                    z10 = true;
                    z8 = true;
                }
                i8 = i9;
                z16 = z ? 1 : 0;
                iArr = iArr;
                z17 = true;
                z21 = z10;
                z20 = z8;
            } else {
                z7 = z13;
                i6 = 2;
                z9 = z7;
                z8 = z6;
            }
            z9 = z12;
            z8 = z11;
            z10 = z9;
            i8 = i9;
            z16 = z ? 1 : 0;
            iArr = iArr;
            z17 = true;
            z21 = z10;
            z20 = z8;
        }
        boolean z27 = z16 ? 1 : 0;
        int[] iArr2 = iArr;
        this.mChildren = arrayList;
        if (z20) {
            iArr2[z27 ? 1 : 0] = i5;
            iArr2[1] = i4;
        }
        resetSolverVariables(linearSystem.mCache);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void resetSolverVariables(Dispatcher dispatcher) {
        super.resetSolverVariables(dispatcher);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetSolverVariables(dispatcher);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void updateFromRuns(boolean z, boolean z2) {
        super.updateFromRuns(z, z2);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).updateFromRuns(z, z2);
        }
    }
}
