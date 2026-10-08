package androidx.constraintlayout.solver.widgets;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Barrier extends ConstraintWidget {
    public boolean mAllowsGoneWidget;
    public int mBarrierType;
    public int mMargin;
    public ConstraintWidget[] mWidgets;
    public int mWidgetsCount;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void addToSolver(LinearSystem linearSystem) {
        boolean z;
        int i;
        int i2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor = this.mLeft;
        constraintAnchorArr[0] = constraintAnchor;
        int i3 = 2;
        ConstraintAnchor constraintAnchor2 = this.mTop;
        constraintAnchorArr[2] = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = this.mRight;
        constraintAnchorArr[1] = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        constraintAnchorArr[3] = constraintAnchor4;
        for (ConstraintAnchor constraintAnchor5 : constraintAnchorArr) {
            constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
        }
        int i4 = this.mBarrierType;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr[i4];
        int i5 = 0;
        while (true) {
            if (i5 >= this.mWidgetsCount) {
                z = false;
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i5];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && constraintWidget.mListDimensionBehaviors[0] == 3 && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || ((i2 == 2 || i2 == 3) && constraintWidget.mListDimensionBehaviors[1] == 3 && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z = true;
                break;
            }
            i5++;
        }
        boolean z2 = constraintAnchor.hasCenteredDependents() || constraintAnchor3.hasCenteredDependents();
        boolean z3 = constraintAnchor2.hasCenteredDependents() || constraintAnchor4.hasCenteredDependents();
        int i6 = !(!z && (((i = this.mBarrierType) == 0 && z2) || ((i == 2 && z3) || ((i == 1 && z2) || (i == 3 && z3))))) ? 4 : 5;
        int i7 = 0;
        while (i7 < this.mWidgetsCount) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i7];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                int i8 = this.mBarrierType;
                ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[i8];
                constraintAnchor7.mSolverVariable = solverVariableCreateObjectVariable;
                ConstraintAnchor constraintAnchor8 = constraintAnchor7.mTarget;
                int i9 = (constraintAnchor8 == null || constraintAnchor8.mOwner != this) ? 0 : constraintAnchor7.mMargin;
                if (i8 == 0 || i8 == i3) {
                    SolverVariable solverVariable = constraintAnchor6.mSolverVariable;
                    int i10 = this.mMargin - i9;
                    ArrayRow arrayRowCreateRow = linearSystem.createRow();
                    SolverVariable solverVariableCreateSlackVariable = linearSystem.createSlackVariable();
                    solverVariableCreateSlackVariable.strength = 0;
                    arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariableCreateObjectVariable, solverVariableCreateSlackVariable, i10);
                    linearSystem.addConstraint(arrayRowCreateRow);
                } else {
                    SolverVariable solverVariable2 = constraintAnchor6.mSolverVariable;
                    int i11 = this.mMargin + i9;
                    ArrayRow arrayRowCreateRow2 = linearSystem.createRow();
                    SolverVariable solverVariableCreateSlackVariable2 = linearSystem.createSlackVariable();
                    solverVariableCreateSlackVariable2.strength = 0;
                    arrayRowCreateRow2.createRowGreaterThan(solverVariable2, solverVariableCreateObjectVariable, solverVariableCreateSlackVariable2, i11);
                    linearSystem.addConstraint(arrayRowCreateRow2);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin + i9, i6);
            }
            i7++;
            i3 = 2;
        }
        int i12 = this.mBarrierType;
        if (i12 == 0) {
            linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor.mSolverVariable, 0, 8);
            linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            return;
        }
        if (i12 == 1) {
            linearSystem.addEquality(constraintAnchor.mSolverVariable, constraintAnchor3.mSolverVariable, 0, 8);
            linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (i12 == 2) {
            linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor2.mSolverVariable, 0, 8);
            linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else if (i12 == 3) {
            linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor4.mSolverVariable, 0, 8);
            linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final String toString() {
        String strM = ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("[Barrier] "), this.mDebugName, " {");
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, ", ");
            }
            strM = strM + constraintWidget.mDebugName;
        }
        return ImageAnalysis$$ExternalSyntheticLambda1.m(strM, "}");
    }
}
