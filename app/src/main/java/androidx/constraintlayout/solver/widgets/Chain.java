package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Chain {
    public static final boolean[] flags = new boolean[3];

    /* JADX WARN: Code duplicated, block: B:177:0x0273  */
    /* JADX WARN: Code duplicated, block: B:194:0x02be  */
    /* JADX WARN: Code duplicated, block: B:196:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:198:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:221:0x0359  */
    /* JADX WARN: Code duplicated, block: B:223:0x0375  */
    /* JADX WARN: Code duplicated, block: B:225:0x037a  */
    /* JADX WARN: Code duplicated, block: B:229:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:240:0x040e  */
    /* JADX WARN: Code duplicated, block: B:393:0x068f  */
    /* JADX WARN: Code duplicated, block: B:394:0x0692  */
    /* JADX WARN: Code duplicated, block: B:397:0x0698  */
    /* JADX WARN: Code duplicated, block: B:398:0x069b  */
    /* JADX WARN: Code duplicated, block: B:400:0x069f  */
    /* JADX WARN: Code duplicated, block: B:402:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:405:0x06af  */
    /* JADX WARN: Code duplicated, block: B:407:0x06b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:416:0x06d1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:74:0x010e  */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        ConstraintAnchor[] constraintAnchorArr;
        float f;
        boolean z;
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        LinearSystem linearSystem2;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable2;
        int i4;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget2;
        int i5;
        ConstraintAnchor[] constraintAnchorArr2;
        int i6;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable5;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable6;
        int size;
        ArrayList arrayList;
        int i7;
        float f2;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ArrayRow arrayRowCreateRow;
        float f3;
        ConstraintAnchor constraintAnchor6;
        ConstraintWidget constraintWidget3;
        int i8;
        ConstraintWidget constraintWidget4;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        if (i == 0) {
            i2 = constraintWidgetContainer2.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer2.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer2.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer2.mVerticalChainsArray;
            i3 = 2;
        }
        int i9 = i2;
        ChainHead[] chainHeadArr2 = chainHeadArr;
        int i10 = 0;
        while (i10 < i9) {
            ChainHead chainHead = chainHeadArr2[i10];
            boolean z4 = chainHead.mDefined;
            ConstraintWidget constraintWidget5 = chainHead.mFirst;
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget5.mListAnchors;
            int i11 = 3;
            int i12 = 8;
            if (z4) {
                constraintAnchorArr = constraintAnchorArr3;
                f = 0.0f;
            } else {
                int i13 = chainHead.mOrientation;
                int i14 = i13 * 2;
                ConstraintWidget constraintWidget6 = constraintWidget5;
                ConstraintWidget constraintWidget7 = constraintWidget6;
                boolean z5 = false;
                f = 0.0f;
                while (!z5) {
                    chainHead.mWidgetsCount++;
                    ConstraintWidget[] constraintWidgetArr = constraintWidget6.mNextChainWidget;
                    ConstraintAnchor[] constraintAnchorArr4 = constraintWidget6.mListAnchors;
                    constraintWidgetArr[i13] = null;
                    constraintWidget6.mListNextMatchConstraintsWidget[i13] = null;
                    if (constraintWidget6.mVisibility != i12) {
                        constraintWidget6.getDimensionBehaviour(i13);
                        constraintAnchorArr4[i14].getMargin();
                        int i15 = i14 + 1;
                        constraintAnchorArr4[i15].getMargin();
                        constraintAnchorArr4[i14].getMargin();
                        constraintAnchorArr4[i15].getMargin();
                        if (chainHead.mFirstVisibleWidget == null) {
                            chainHead.mFirstVisibleWidget = constraintWidget6;
                        }
                        chainHead.mLastVisibleWidget = constraintWidget6;
                        int i16 = constraintWidget6.mListDimensionBehaviors[i13];
                        if (i16 == i11) {
                            int i17 = constraintWidget6.mResolvedMatchConstraintDefault[i13];
                            if (i17 == 0 || i17 == i11 || i17 == 2) {
                                chainHead.mWidgetsMatchCount++;
                                float f4 = constraintWidget6.mWeight[i13];
                                if (f4 > 0.0f) {
                                    chainHead.mTotalWeight += f4;
                                }
                                if (constraintWidget6.mVisibility != 8 && i16 == 3 && (i17 == 0 || i17 == 3)) {
                                    if (f4 < 0.0f) {
                                        chainHead.mHasUndefinedWeights = true;
                                    } else {
                                        chainHead.mHasDefinedWeights = true;
                                    }
                                    if (chainHead.mWeightedMatchConstraintsWidgets == null) {
                                        chainHead.mWeightedMatchConstraintsWidgets = new ArrayList();
                                    }
                                    chainHead.mWeightedMatchConstraintsWidgets.add(constraintWidget6);
                                }
                                if (chainHead.mFirstMatchConstraintWidget == null) {
                                    chainHead.mFirstMatchConstraintWidget = constraintWidget6;
                                }
                                ConstraintWidget constraintWidget8 = chainHead.mLastMatchConstraintWidget;
                                if (constraintWidget8 != null) {
                                    constraintWidget8.mListNextMatchConstraintsWidget[i13] = constraintWidget6;
                                }
                                chainHead.mLastMatchConstraintWidget = constraintWidget6;
                            } else {
                                i13 = i13;
                            }
                            if (i13 == 0) {
                                if (constraintWidget6.mMatchConstraintDefaultWidth == 0 && constraintWidget6.mMatchConstraintMinWidth == 0) {
                                    int i18 = constraintWidget6.mMatchConstraintMaxWidth;
                                }
                            } else if (constraintWidget6.mMatchConstraintDefaultHeight == 0 && constraintWidget6.mMatchConstraintMinHeight == 0) {
                                int i19 = constraintWidget6.mMatchConstraintMaxHeight;
                            }
                        } else {
                            i13 = i13;
                            constraintAnchorArr3 = constraintAnchorArr3;
                        }
                    } else {
                        i13 = i13;
                        constraintAnchorArr3 = constraintAnchorArr3;
                    }
                    if (constraintWidget7 != constraintWidget6) {
                        constraintWidget7.mNextChainWidget[i13] = constraintWidget6;
                    }
                    ConstraintAnchor constraintAnchor7 = constraintAnchorArr4[i14 + 1].mTarget;
                    if (constraintAnchor7 != null) {
                        constraintWidget4 = constraintAnchor7.mOwner;
                        ConstraintAnchor constraintAnchor8 = constraintWidget4.mListAnchors[i14].mTarget;
                        if (constraintAnchor8 == null || constraintAnchor8.mOwner != constraintWidget6) {
                            constraintWidget4 = null;
                        }
                    } else {
                        constraintWidget4 = null;
                    }
                    if (constraintWidget4 == null) {
                        constraintWidget4 = constraintWidget6;
                        z5 = true;
                    }
                    constraintWidget7 = constraintWidget6;
                    constraintAnchorArr3 = constraintAnchorArr3;
                    i11 = 3;
                    i12 = 8;
                    constraintWidget6 = constraintWidget4;
                    i13 = i13;
                }
                int i20 = i13;
                constraintAnchorArr = constraintAnchorArr3;
                ConstraintWidget constraintWidget9 = chainHead.mFirstVisibleWidget;
                if (constraintWidget9 != null) {
                    constraintWidget9.mListAnchors[i14].getMargin();
                }
                ConstraintWidget constraintWidget10 = chainHead.mLastVisibleWidget;
                if (constraintWidget10 != null) {
                    constraintWidget10.mListAnchors[i14 + 1].getMargin();
                }
                chainHead.mLast = constraintWidget6;
                if (i20 == 0 && chainHead.mIsRtl) {
                    chainHead.mHead = constraintWidget6;
                } else {
                    chainHead.mHead = constraintWidget5;
                }
                chainHead.mHasComplexMatchWeights = chainHead.mHasDefinedWeights && chainHead.mHasUndefinedWeights;
            }
            chainHead.mDefined = true;
            ConstraintWidget constraintWidget11 = chainHead.mLast;
            ConstraintWidget constraintWidget12 = chainHead.mFirstVisibleWidget;
            ConstraintWidget constraintWidget13 = chainHead.mLastVisibleWidget;
            ConstraintWidget constraintWidget14 = chainHead.mHead;
            float f5 = chainHead.mTotalWeight;
            int[] iArr = constraintWidgetContainer2.mListDimensionBehaviors;
            ConstraintAnchor[] constraintAnchorArr5 = constraintWidgetContainer2.mListAnchors;
            boolean z6 = iArr[i] == 2;
            if (i == 0) {
                int i21 = constraintWidget14.mHorizontalChainStyle;
                boolean z7 = i21 == 0;
                z = i21 == 1;
                z2 = i21 == 2;
                z3 = z7;
            } else {
                int i22 = constraintWidget14.mVerticalChainStyle;
                boolean z8 = i22 == 0;
                z = i22 == 1;
                z2 = i22 == 2;
                z3 = z8;
            }
            boolean z9 = false;
            while (!z9) {
                ConstraintAnchor[] constraintAnchorArr6 = constraintWidget5.mListAnchors;
                int[] iArr2 = constraintWidget5.mListDimensionBehaviors;
                ConstraintAnchor constraintAnchor9 = constraintAnchorArr6[i3];
                int i23 = z2 ? 1 : 4;
                int margin = constraintAnchor9.getMargin();
                ConstraintAnchor[] constraintAnchorArr7 = constraintAnchorArr5;
                boolean z10 = z2;
                boolean z11 = iArr2[i] == 3 && constraintWidget5.mResolvedMatchConstraintDefault[i] == 0;
                ConstraintAnchor constraintAnchor10 = constraintAnchor9.mTarget;
                if (constraintAnchor10 != null && constraintWidget5 != constraintWidget5) {
                    margin = constraintAnchor10.getMargin() + margin;
                }
                int i24 = margin;
                if (z10 && constraintWidget5 != constraintWidget5 && constraintWidget5 != constraintWidget12) {
                    i23 = 5;
                }
                ConstraintWidget constraintWidget15 = constraintWidget5;
                ConstraintAnchor constraintAnchor11 = constraintAnchor9.mTarget;
                if (constraintAnchor11 != null) {
                    if (constraintWidget5 == constraintWidget12) {
                        linearSystem.addGreaterThan(constraintAnchor9.mSolverVariable, constraintAnchor11.mSolverVariable, i24, 6);
                    } else {
                        linearSystem.addGreaterThan(constraintAnchor9.mSolverVariable, constraintAnchor11.mSolverVariable, i24, 8);
                    }
                    linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor9.mTarget.mSolverVariable, i24, (!z11 || z10) ? i23 : 5);
                } else {
                    i9 = i9;
                }
                if (z6) {
                    if (constraintWidget5.mVisibility == 8 || iArr2[i] != 3) {
                        i8 = 0;
                    } else {
                        i8 = 0;
                        linearSystem.addGreaterThan(constraintAnchorArr6[i3 + 1].mSolverVariable, constraintAnchorArr6[i3].mSolverVariable, 0, 5);
                    }
                    linearSystem.addGreaterThan(constraintAnchorArr6[i3].mSolverVariable, constraintAnchorArr7[i3].mSolverVariable, i8, 8);
                }
                ConstraintAnchor constraintAnchor12 = constraintAnchorArr6[i3 + 1].mTarget;
                if (constraintAnchor12 != null) {
                    constraintWidget3 = constraintAnchor12.mOwner;
                    ConstraintAnchor constraintAnchor13 = constraintWidget3.mListAnchors[i3].mTarget;
                    if (constraintAnchor13 == null || constraintAnchor13.mOwner != constraintWidget5) {
                        constraintWidget3 = null;
                    }
                } else {
                    constraintWidget3 = null;
                }
                if (constraintWidget3 != null) {
                    constraintWidget5 = constraintWidget3;
                } else {
                    z9 = true;
                }
                constraintWidget5 = constraintWidget15;
                constraintAnchorArr5 = constraintAnchorArr7;
                z2 = z10;
                i9 = i9;
            }
            ConstraintAnchor[] constraintAnchorArr8 = constraintAnchorArr5;
            boolean z12 = z2;
            int i25 = i9;
            if (constraintWidget13 != null) {
                int i26 = i3 + 1;
                if (constraintWidget11.mListAnchors[i26].mTarget != null) {
                    ConstraintAnchor constraintAnchor14 = constraintWidget13.mListAnchors[i26];
                    if (constraintWidget13.mListDimensionBehaviors[i] == 3 && constraintWidget13.mResolvedMatchConstraintDefault[i] == 0 && !z12) {
                        ConstraintAnchor constraintAnchor15 = constraintAnchor14.mTarget;
                        if (constraintAnchor15.mOwner == constraintWidgetContainer2) {
                            linearSystem.addEquality(constraintAnchor14.mSolverVariable, constraintAnchor15.mSolverVariable, -constraintAnchor14.getMargin(), 5);
                        } else if (z12) {
                            constraintAnchor6 = constraintAnchor14.mTarget;
                            if (constraintAnchor6.mOwner == constraintWidgetContainer2) {
                                linearSystem.addEquality(constraintAnchor14.mSolverVariable, constraintAnchor6.mSolverVariable, -constraintAnchor14.getMargin(), 4);
                            }
                        }
                    } else if (z12) {
                        constraintAnchor6 = constraintAnchor14.mTarget;
                        if (constraintAnchor6.mOwner == constraintWidgetContainer2) {
                            linearSystem.addEquality(constraintAnchor14.mSolverVariable, constraintAnchor6.mSolverVariable, -constraintAnchor14.getMargin(), 4);
                        }
                    }
                    linearSystem.addLowerThan(constraintAnchor14.mSolverVariable, constraintWidget11.mListAnchors[i26].mTarget.mSolverVariable, -constraintAnchor14.getMargin(), 6);
                }
            }
            if (z6 != 0) {
                int i27 = i3 + 1;
                SolverVariable solverVariable11 = constraintAnchorArr8[i27].mSolverVariable;
                ConstraintAnchor constraintAnchor16 = constraintWidget11.mListAnchors[i27];
                linearSystem.addGreaterThan(solverVariable11, constraintAnchor16.mSolverVariable, constraintAnchor16.getMargin(), 8);
            }
            ArrayList arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
            if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                if (chainHead.mHasUndefinedWeights && !chainHead.mHasComplexMatchWeights) {
                    f5 = chainHead.mWidgetsMatchCount;
                }
                ConstraintWidget constraintWidget16 = null;
                float f6 = f;
                int i28 = 0;
                while (i28 < size) {
                    ConstraintWidget constraintWidget17 = (ConstraintWidget) arrayList2.get(i28);
                    float[] fArr = constraintWidget17.mWeight;
                    ConstraintAnchor[] constraintAnchorArr9 = constraintWidget17.mListAnchors;
                    float f7 = fArr[i];
                    if (f7 >= f) {
                        arrayList = arrayList2;
                        i7 = size;
                        if (f7 == f) {
                            linearSystem.addEquality(constraintAnchorArr9[i3 + 1].mSolverVariable, constraintAnchorArr9[i3].mSolverVariable, 0, 8);
                            i28 = i28;
                            f2 = f;
                            f6 = f6;
                            chainHeadArr2 = chainHeadArr2;
                        } else {
                            float f8 = f6;
                            if (constraintWidget16 != null) {
                                ConstraintAnchor[] constraintAnchorArr10 = constraintWidget16.mListAnchors;
                                solverVariable7 = constraintAnchorArr10[i3].mSolverVariable;
                                int i29 = i3 + 1;
                                solverVariable8 = constraintAnchorArr10[i29].mSolverVariable;
                                solverVariable9 = constraintAnchorArr9[i3].mSolverVariable;
                                solverVariable10 = constraintAnchorArr9[i29].mSolverVariable;
                                arrayRowCreateRow = linearSystem.createRow();
                                f3 = f;
                                arrayRowCreateRow.constantValue = f3;
                                f2 = f3;
                                if (f5 != f3 || f8 == f7) {
                                    arrayRowCreateRow.variables.put(solverVariable7, 1.0f);
                                    arrayRowCreateRow.variables.put(solverVariable8, -1.0f);
                                    arrayRowCreateRow.variables.put(solverVariable10, 1.0f);
                                    arrayRowCreateRow.variables.put(solverVariable9, -1.0f);
                                } else if (f8 == f2) {
                                    arrayRowCreateRow.variables.put(solverVariable7, 1.0f);
                                    arrayRowCreateRow.variables.put(solverVariable8, -1.0f);
                                } else if (f7 == f) {
                                    arrayRowCreateRow.variables.put(solverVariable9, 1.0f);
                                    arrayRowCreateRow.variables.put(solverVariable10, -1.0f);
                                } else {
                                    float f9 = (f8 / f5) / (f7 / f5);
                                    arrayRowCreateRow.variables.put(solverVariable7, 1.0f);
                                    arrayRowCreateRow.variables.put(solverVariable8, -1.0f);
                                    arrayRowCreateRow.variables.put(solverVariable10, f9);
                                    arrayRowCreateRow.variables.put(solverVariable9, -f9);
                                }
                                linearSystem.addConstraint(arrayRowCreateRow);
                            } else {
                                i28 = i28;
                                f2 = f;
                                chainHeadArr2 = chainHeadArr2;
                            }
                            f6 = f7;
                            constraintWidget16 = constraintWidget17;
                        }
                    } else {
                        if (chainHead.mHasComplexMatchWeights) {
                            arrayList = arrayList2;
                            i7 = size;
                            linearSystem.addEquality(constraintAnchorArr9[i3 + 1].mSolverVariable, constraintAnchorArr9[i3].mSolverVariable, 0, 4);
                        } else {
                            f7 = 1.0f;
                            arrayList = arrayList2;
                            i7 = size;
                            if (f7 == f) {
                                linearSystem.addEquality(constraintAnchorArr9[i3 + 1].mSolverVariable, constraintAnchorArr9[i3].mSolverVariable, 0, 8);
                            } else {
                                float f10 = f6;
                                if (constraintWidget16 != null) {
                                    ConstraintAnchor[] constraintAnchorArr11 = constraintWidget16.mListAnchors;
                                    solverVariable7 = constraintAnchorArr11[i3].mSolverVariable;
                                    int i210 = i3 + 1;
                                    solverVariable8 = constraintAnchorArr11[i210].mSolverVariable;
                                    solverVariable9 = constraintAnchorArr9[i3].mSolverVariable;
                                    solverVariable10 = constraintAnchorArr9[i210].mSolverVariable;
                                    arrayRowCreateRow = linearSystem.createRow();
                                    f3 = f;
                                    arrayRowCreateRow.constantValue = f3;
                                    f2 = f3;
                                    if (f5 != f3) {
                                        arrayRowCreateRow.variables.put(solverVariable7, 1.0f);
                                        arrayRowCreateRow.variables.put(solverVariable8, -1.0f);
                                        arrayRowCreateRow.variables.put(solverVariable10, 1.0f);
                                        arrayRowCreateRow.variables.put(solverVariable9, -1.0f);
                                    } else {
                                        arrayRowCreateRow.variables.put(solverVariable7, 1.0f);
                                        arrayRowCreateRow.variables.put(solverVariable8, -1.0f);
                                        arrayRowCreateRow.variables.put(solverVariable10, 1.0f);
                                        arrayRowCreateRow.variables.put(solverVariable9, -1.0f);
                                    }
                                    linearSystem.addConstraint(arrayRowCreateRow);
                                } else {
                                    i28 = i28;
                                    f2 = f;
                                    chainHeadArr2 = chainHeadArr2;
                                }
                                f6 = f7;
                                constraintWidget16 = constraintWidget17;
                            }
                        }
                        i28 = i28;
                        f2 = f;
                        f6 = f6;
                        chainHeadArr2 = chainHeadArr2;
                    }
                    i28++;
                    chainHeadArr2 = chainHeadArr2;
                    arrayList2 = arrayList;
                    size = i7;
                    f = f2;
                }
            }
            ChainHead[] chainHeadArr3 = chainHeadArr2;
            if (constraintWidget12 == null || !(constraintWidget12 == constraintWidget13 || z12)) {
                constraintWidget = constraintWidget13;
                if (!z3 || constraintWidget12 == null) {
                    int i30 = 8;
                    if (z && constraintWidget12 != null) {
                        int i31 = chainHead.mWidgetsMatchCount;
                        boolean z13 = i31 > 0 && chainHead.mWidgetsCount == i31;
                        ConstraintWidget constraintWidget18 = constraintWidget12;
                        ConstraintWidget constraintWidget19 = constraintWidget18;
                        while (constraintWidget19 != null) {
                            ConstraintAnchor[] constraintAnchorArr12 = constraintWidget19.mListAnchors;
                            ConstraintWidget constraintWidget20 = constraintWidget19.mNextChainWidget[i];
                            while (constraintWidget20 != null && constraintWidget20.mVisibility == i30) {
                                constraintWidget20 = constraintWidget20.mNextChainWidget[i];
                            }
                            if (constraintWidget19 == constraintWidget12 || constraintWidget19 == constraintWidget || constraintWidget20 == null) {
                                constraintWidget18 = constraintWidget18;
                            } else {
                                if (constraintWidget20 == constraintWidget) {
                                    constraintWidget20 = null;
                                }
                                ConstraintAnchor constraintAnchor17 = constraintAnchorArr12[i3];
                                SolverVariable solverVariable12 = constraintAnchor17.mSolverVariable;
                                int i32 = i3 + 1;
                                SolverVariable solverVariable13 = constraintWidget18.mListAnchors[i32].mSolverVariable;
                                int margin2 = constraintAnchor17.getMargin();
                                int margin3 = constraintAnchorArr12[i32].getMargin();
                                if (constraintWidget20 != null) {
                                    constraintAnchor = constraintWidget20.mListAnchors[i3];
                                    solverVariable2 = constraintAnchor.mSolverVariable;
                                    ConstraintAnchor constraintAnchor18 = constraintAnchor.mTarget;
                                    solverVariable = constraintAnchor18 != null ? constraintAnchor18.mSolverVariable : null;
                                } else {
                                    ConstraintAnchor constraintAnchor19 = constraintWidget.mListAnchors[i3];
                                    SolverVariable solverVariable14 = constraintAnchor19 != null ? constraintAnchor19.mSolverVariable : null;
                                    solverVariable = constraintAnchorArr12[i32].mSolverVariable;
                                    constraintAnchor = constraintAnchor19;
                                    solverVariable2 = solverVariable14;
                                }
                                if (constraintAnchor != null) {
                                    margin3 += constraintAnchor.getMargin();
                                }
                                int margin4 = margin2 + constraintWidget18.mListAnchors[i32].getMargin();
                                int i33 = z13 ? 8 : 4;
                                if (solverVariable12 != null && solverVariable13 != null && solverVariable2 != null && solverVariable != null) {
                                    linearSystem.addCentering(solverVariable12, solverVariable13, margin4, 0.5f, solverVariable2, solverVariable, margin3, i33);
                                }
                                constraintWidget20 = constraintWidget20;
                            }
                            if (constraintWidget19.mVisibility != 8) {
                                constraintWidget18 = constraintWidget19;
                            }
                            constraintWidget19 = constraintWidget20;
                            constraintWidget18 = constraintWidget18;
                            i30 = 8;
                        }
                        linearSystem2 = linearSystem;
                        ConstraintAnchor constraintAnchor20 = constraintWidget12.mListAnchors[i3];
                        ConstraintAnchor constraintAnchor21 = constraintAnchorArr[i3].mTarget;
                        int i34 = i3 + 1;
                        ConstraintAnchor constraintAnchor22 = constraintWidget.mListAnchors[i34];
                        ConstraintAnchor constraintAnchor23 = constraintWidget11.mListAnchors[i34].mTarget;
                        if (constraintAnchor21 != null) {
                            if (constraintWidget12 != constraintWidget) {
                                linearSystem2.addEquality(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 5);
                            } else if (constraintAnchor23 != null) {
                                linearSystem2.addCentering(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 0.5f, constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, constraintAnchor22.getMargin(), 5);
                            }
                        }
                        if (constraintAnchor23 != null && constraintWidget12 != constraintWidget) {
                            linearSystem2.addEquality(constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, -constraintAnchor22.getMargin(), 5);
                        }
                    }
                    if ((z3 || z) && constraintWidget12 != null && constraintWidget12 != constraintWidget) {
                        constraintAnchorArr2 = constraintWidget12.mListAnchors;
                        ConstraintAnchor constraintAnchor24 = constraintAnchorArr2[i3];
                        i6 = i3 + 1;
                        constraintAnchor3 = constraintWidget.mListAnchors[i6];
                        constraintAnchor4 = constraintAnchor24.mTarget;
                        if (constraintAnchor4 != null) {
                            solverVariable5 = constraintAnchor4.mSolverVariable;
                        } else {
                            solverVariable5 = null;
                        }
                        constraintAnchor5 = constraintAnchor3.mTarget;
                        if (constraintAnchor5 != null) {
                            solverVariable6 = constraintAnchor5.mSolverVariable;
                        } else {
                            solverVariable6 = null;
                        }
                        if (constraintWidget11 != constraintWidget) {
                            ConstraintAnchor constraintAnchor25 = constraintWidget11.mListAnchors[i6].mTarget;
                            solverVariable6 = constraintAnchor25 != null ? constraintAnchor25.mSolverVariable : null;
                        }
                        if (constraintWidget12 == constraintWidget) {
                            constraintAnchor3 = constraintAnchorArr2[i6];
                        }
                        if (solverVariable5 == null && solverVariable6 != null) {
                            linearSystem2.addCentering(constraintAnchor24.mSolverVariable, solverVariable5, constraintAnchor24.getMargin(), 0.5f, solverVariable6, constraintAnchor3.mSolverVariable, constraintWidget.mListAnchors[i6].getMargin(), 5);
                        }
                    }
                    i10++;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    chainHeadArr2 = chainHeadArr3;
                    i9 = i25;
                } else {
                    int i35 = chainHead.mWidgetsMatchCount;
                    boolean z14 = i35 > 0 && chainHead.mWidgetsCount == i35;
                    ConstraintWidget constraintWidget21 = constraintWidget12;
                    ConstraintWidget constraintWidget22 = constraintWidget21;
                    while (constraintWidget21 != null) {
                        ConstraintAnchor[] constraintAnchorArr13 = constraintWidget21.mListAnchors;
                        ConstraintWidget constraintWidget23 = constraintWidget21.mNextChainWidget[i];
                        while (true) {
                            if (constraintWidget23 == null) {
                                i4 = 8;
                                break;
                            }
                            i4 = 8;
                            if (constraintWidget23.mVisibility != 8) {
                                break;
                            } else {
                                constraintWidget23 = constraintWidget23.mNextChainWidget[i];
                            }
                        }
                        if (constraintWidget23 != null || constraintWidget21 == constraintWidget) {
                            ConstraintAnchor constraintAnchor26 = constraintAnchorArr13[i3];
                            SolverVariable solverVariable15 = constraintAnchor26.mSolverVariable;
                            ConstraintAnchor constraintAnchor27 = constraintAnchor26.mTarget;
                            SolverVariable solverVariable16 = constraintAnchor27 != null ? constraintAnchor27.mSolverVariable : null;
                            if (constraintWidget22 != constraintWidget21) {
                                solverVariable16 = constraintWidget22.mListAnchors[i3 + 1].mSolverVariable;
                            } else if (constraintWidget21 == constraintWidget12 && constraintWidget22 == constraintWidget21) {
                                ConstraintAnchor constraintAnchor28 = constraintAnchorArr[i3].mTarget;
                                solverVariable16 = constraintAnchor28 != null ? constraintAnchor28.mSolverVariable : null;
                            }
                            int margin5 = constraintAnchor26.getMargin();
                            int i36 = i3 + 1;
                            int margin6 = constraintAnchorArr13[i36].getMargin();
                            if (constraintWidget23 != null) {
                                constraintAnchor2 = constraintWidget23.mListAnchors[i3];
                                solverVariable3 = constraintAnchor2.mSolverVariable;
                                solverVariable4 = constraintAnchorArr13[i36].mSolverVariable;
                            } else {
                                constraintAnchor2 = constraintWidget11.mListAnchors[i36].mTarget;
                                solverVariable3 = constraintAnchor2 != null ? constraintAnchor2.mSolverVariable : null;
                                solverVariable4 = constraintAnchorArr13[i36].mSolverVariable;
                            }
                            if (constraintAnchor2 != null) {
                                margin6 += constraintAnchor2.getMargin();
                            }
                            if (constraintWidget22 != null) {
                                margin5 += constraintWidget22.mListAnchors[i36].getMargin();
                            }
                            if (solverVariable15 == null || solverVariable16 == null || solverVariable3 == null || solverVariable4 == null) {
                                constraintWidget2 = constraintWidget23;
                                i5 = 8;
                            } else {
                                if (constraintWidget21 == constraintWidget12) {
                                    margin5 = constraintWidget12.mListAnchors[i3].getMargin();
                                }
                                if (constraintWidget21 == constraintWidget) {
                                    margin6 = constraintWidget.mListAnchors[i36].getMargin();
                                }
                                constraintWidget2 = constraintWidget23;
                                i5 = 8;
                                linearSystem.addCentering(solverVariable15, solverVariable16, margin5, 0.5f, solverVariable3, solverVariable4, margin6, z14 ? 8 : 5);
                            }
                        } else {
                            constraintWidget2 = constraintWidget23;
                            i5 = i4;
                        }
                        if (constraintWidget21.mVisibility != i5) {
                            constraintWidget22 = constraintWidget21;
                        }
                        constraintWidget21 = constraintWidget2;
                        constraintWidget22 = constraintWidget22;
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor29 = constraintAnchorArr[i3];
                int i37 = i3 + 1;
                ConstraintAnchor constraintAnchor30 = constraintWidget11.mListAnchors[i37];
                ConstraintAnchor constraintAnchor31 = constraintAnchor29.mTarget;
                SolverVariable solverVariable17 = constraintAnchor31 != null ? constraintAnchor31.mSolverVariable : null;
                ConstraintAnchor constraintAnchor32 = constraintAnchor30.mTarget;
                SolverVariable solverVariable18 = constraintAnchor32 != null ? constraintAnchor32.mSolverVariable : null;
                ConstraintAnchor constraintAnchor33 = constraintWidget12.mListAnchors[i3];
                ConstraintAnchor constraintAnchor34 = constraintWidget13.mListAnchors[i37];
                if (solverVariable17 == null || solverVariable18 == null) {
                    constraintWidget = constraintWidget13;
                } else {
                    SolverVariable solverVariable19 = solverVariable17;
                    constraintWidget = constraintWidget13;
                    linearSystem.addCentering(constraintAnchor33.mSolverVariable, solverVariable19, constraintAnchor33.getMargin(), i == 0 ? constraintWidget14.mHorizontalBiasPercent : constraintWidget14.mVerticalBiasPercent, solverVariable18, constraintAnchor34.mSolverVariable, constraintAnchor34.getMargin(), 7);
                }
            }
            linearSystem2 = linearSystem;
            if (z3) {
                constraintAnchorArr2 = constraintWidget12.mListAnchors;
                ConstraintAnchor constraintAnchor210 = constraintAnchorArr2[i3];
                i6 = i3 + 1;
                constraintAnchor3 = constraintWidget.mListAnchors[i6];
                constraintAnchor4 = constraintAnchor210.mTarget;
                if (constraintAnchor4 != null) {
                    solverVariable5 = constraintAnchor4.mSolverVariable;
                } else {
                    solverVariable5 = null;
                }
                constraintAnchor5 = constraintAnchor3.mTarget;
                if (constraintAnchor5 != null) {
                    solverVariable6 = constraintAnchor5.mSolverVariable;
                } else {
                    solverVariable6 = null;
                }
                if (constraintWidget11 != constraintWidget) {
                    ConstraintAnchor constraintAnchor211 = constraintWidget11.mListAnchors[i6].mTarget;
                    solverVariable6 = constraintAnchor211 != null ? constraintAnchor211.mSolverVariable : null;
                }
                if (constraintWidget12 == constraintWidget) {
                    constraintAnchor3 = constraintAnchorArr2[i6];
                }
                if (solverVariable5 == null) {
                }
            } else {
                constraintAnchorArr2 = constraintWidget12.mListAnchors;
                ConstraintAnchor constraintAnchor212 = constraintAnchorArr2[i3];
                i6 = i3 + 1;
                constraintAnchor3 = constraintWidget.mListAnchors[i6];
                constraintAnchor4 = constraintAnchor212.mTarget;
                if (constraintAnchor4 != null) {
                    solverVariable5 = constraintAnchor4.mSolverVariable;
                } else {
                    solverVariable5 = null;
                }
                constraintAnchor5 = constraintAnchor3.mTarget;
                if (constraintAnchor5 != null) {
                    solverVariable6 = constraintAnchor5.mSolverVariable;
                } else {
                    solverVariable6 = null;
                }
                if (constraintWidget11 != constraintWidget) {
                    ConstraintAnchor constraintAnchor213 = constraintWidget11.mListAnchors[i6].mTarget;
                    solverVariable6 = constraintAnchor213 != null ? constraintAnchor213.mSolverVariable : null;
                }
                if (constraintWidget12 == constraintWidget) {
                    constraintAnchor3 = constraintAnchorArr2[i6];
                }
                if (solverVariable5 == null) {
                }
            }
            i10++;
            constraintWidgetContainer2 = constraintWidgetContainer;
            chainHeadArr2 = chainHeadArr3;
            i9 = i25;
        }
    }
}
