package androidx.constraintlayout.solver.widgets;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintAnchor {
    public final ConstraintWidget mOwner;
    public SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final int mType;
    public HashSet mDependents = null;
    public int mMargin = 0;
    public int mGoneMargin = -1;

    public ConstraintAnchor(ConstraintWidget constraintWidget, int i) {
        this.mOwner = constraintWidget;
        this.mType = i;
    }

    public final void connect(ConstraintAnchor constraintAnchor, int i, int i2) {
        if (constraintAnchor == null) {
            reset();
            return;
        }
        this.mTarget = constraintAnchor;
        if (constraintAnchor.mDependents == null) {
            constraintAnchor.mDependents = new HashSet();
        }
        this.mTarget.mDependents.add(this);
        if (i > 0) {
            this.mMargin = i;
        } else {
            this.mMargin = 0;
        }
        this.mGoneMargin = i2;
    }

    public final int getMargin() {
        ConstraintAnchor constraintAnchor;
        if (this.mOwner.mVisibility == 8) {
            return 0;
        }
        int i = this.mGoneMargin;
        return (i <= -1 || (constraintAnchor = this.mTarget) == null || constraintAnchor.mOwner.mVisibility != 8) ? this.mMargin : i;
    }

    public final boolean hasCenteredDependents() {
        ConstraintAnchor constraintAnchor;
        HashSet<ConstraintAnchor> hashSet = this.mDependents;
        if (hashSet == null) {
            return false;
        }
        for (ConstraintAnchor constraintAnchor2 : hashSet) {
            ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
            int i = constraintAnchor2.mType;
            switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    constraintAnchor = null;
                    break;
                case 1:
                    constraintAnchor = constraintWidget.mRight;
                    break;
                case 2:
                    constraintAnchor = constraintWidget.mBottom;
                    break;
                case 3:
                    constraintAnchor = constraintWidget.mLeft;
                    break;
                case 4:
                    constraintAnchor = constraintWidget.mTop;
                    break;
                default:
                    throw new AssertionError(Density.CC.name(i));
            }
            if (constraintAnchor.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isConnected() {
        return this.mTarget != null;
    }

    public final void reset() {
        HashSet hashSet;
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (constraintAnchor != null && (hashSet = constraintAnchor.mDependents) != null) {
            hashSet.remove(this);
        }
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
    }

    public final void resetSolverVariable() {
        SolverVariable solverVariable = this.mSolverVariable;
        if (solverVariable == null) {
            this.mSolverVariable = new SolverVariable(1);
        } else {
            solverVariable.reset();
        }
    }

    public final String toString() {
        return this.mOwner.mDebugName + ":" + Density.CC.name(this.mType);
    }
}
