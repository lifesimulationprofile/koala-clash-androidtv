package androidx.constraintlayout.solver.widgets;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Guideline extends ConstraintWidget {
    public float mRelativePercent = -1.0f;
    public int mRelativeBegin = -1;
    public int mRelativeEnd = -1;
    public ConstraintAnchor mAnchor = this.mTop;
    public int mOrientation = 0;

    public Guideline() {
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int i = 0; i < length; i++) {
            this.mListAnchors[i] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void addToSolver(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.mParent;
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(2);
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(4);
        ConstraintWidget constraintWidget = this.mParent;
        boolean z = constraintWidget != null && constraintWidget.mListDimensionBehaviors[0] == 2;
        if (this.mOrientation == 0) {
            anchor = constraintWidgetContainer.getAnchor(3);
            anchor2 = constraintWidgetContainer.getAnchor(5);
            ConstraintWidget constraintWidget2 = this.mParent;
            z = constraintWidget2 != null && constraintWidget2.mListDimensionBehaviors[1] == 2;
        }
        if (this.mRelativeBegin != -1) {
            SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mAnchor);
            linearSystem.addEquality(solverVariableCreateObjectVariable, linearSystem.createObjectVariable(anchor), this.mRelativeBegin, 8);
            if (z) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), solverVariableCreateObjectVariable, 0, 5);
                return;
            }
            return;
        }
        if (this.mRelativeEnd != -1) {
            SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mAnchor);
            SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(anchor2);
            linearSystem.addEquality(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable3, -this.mRelativeEnd, 8);
            if (z) {
                linearSystem.addGreaterThan(solverVariableCreateObjectVariable2, linearSystem.createObjectVariable(anchor), 0, 5);
                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, 0, 5);
                return;
            }
            return;
        }
        if (this.mRelativePercent != -1.0f) {
            SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mAnchor);
            SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(anchor2);
            float f = this.mRelativePercent;
            ArrayRow arrayRowCreateRow = linearSystem.createRow();
            arrayRowCreateRow.variables.put(solverVariableCreateObjectVariable4, -1.0f);
            arrayRowCreateRow.variables.put(solverVariableCreateObjectVariable5, f);
            linearSystem.addConstraint(arrayRowCreateRow);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final ConstraintAnchor getAnchor(int i) {
        switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.mOrientation == 1) {
                    return this.mAnchor;
                }
                break;
            case 2:
            case 4:
                if (this.mOrientation == 0) {
                    return this.mAnchor;
                }
                break;
        }
        throw new AssertionError(Density.CC.name(i));
    }

    public final void setOrientation(int i) {
        if (this.mOrientation == i) {
            return;
        }
        this.mOrientation = i;
        ArrayList arrayList = this.mAnchors;
        arrayList.clear();
        if (this.mOrientation == 1) {
            this.mAnchor = this.mLeft;
        } else {
            this.mAnchor = this.mTop;
        }
        arrayList.add(this.mAnchor);
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        int length = constraintAnchorArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            constraintAnchorArr[i2] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public final void updateFromSolver(LinearSystem linearSystem) {
        if (this.mParent == null) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.mAnchor;
        linearSystem.getClass();
        int objectVariableValue = LinearSystem.getObjectVariableValue(constraintAnchor);
        if (this.mOrientation == 1) {
            this.mX = objectVariableValue;
            this.mY = 0;
            setHeight(this.mParent.getHeight());
            setWidth(0);
            return;
        }
        this.mX = 0;
        this.mY = objectVariableValue;
        setWidth(this.mParent.getWidth());
        setHeight(0);
    }
}
