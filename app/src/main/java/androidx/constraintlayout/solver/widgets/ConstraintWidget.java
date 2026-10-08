package androidx.constraintlayout.solver.widgets;

import android.view.View;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import java.util.ArrayList;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public final HorizontalWidgetRun horizontalRun;
    public final boolean[] isTerminalWidget;
    public final ArrayList mAnchors;
    public final ConstraintAnchor mBaseline;
    public int mBaselineDistance;
    public final ConstraintAnchor mBottom;
    public final ConstraintAnchor mCenter;
    public final ConstraintAnchor mCenterX;
    public final ConstraintAnchor mCenterY;
    public float mCircleConstraintAngle;
    public View mCompanionWidget;
    public String mDebugName;
    public float mDimensionRatio;
    public int mDimensionRatioSide;
    public int mHeight;
    public float mHorizontalBiasPercent;
    public int mHorizontalChainStyle;
    public int mHorizontalResolution;
    public final boolean[] mIsInBarrier;
    public final ConstraintAnchor mLeft;
    public final ConstraintAnchor[] mListAnchors;
    public final int[] mListDimensionBehaviors;
    public final ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    public final int[] mMaxDimension;
    public int mMinHeight;
    public int mMinWidth;
    public final ConstraintWidget[] mNextChainWidget;
    public ConstraintWidget mParent;
    public float mResolvedDimensionRatio;
    public int mResolvedDimensionRatioSide;
    public final int[] mResolvedMatchConstraintDefault;
    public final ConstraintAnchor mRight;
    public final ConstraintAnchor mTop;
    public float mVerticalBiasPercent;
    public int mVerticalChainStyle;
    public int mVerticalResolution;
    public int mVisibility;
    public final float[] mWeight;
    public int mWidth;
    public int mX;
    public int mY;
    public boolean measured = false;
    public ChainRun verticalChainRun;
    public final VerticalWidgetRun verticalRun;
    public final int[] wrapMeasure;

    public ConstraintWidget() {
        HorizontalWidgetRun horizontalWidgetRun = new HorizontalWidgetRun(this);
        horizontalWidgetRun.start.type = 4;
        horizontalWidgetRun.end.type = 5;
        horizontalWidgetRun.orientation = 0;
        this.horizontalRun = horizontalWidgetRun;
        VerticalWidgetRun verticalWidgetRun = new VerticalWidgetRun(this);
        DependencyNode dependencyNode = new DependencyNode(verticalWidgetRun);
        verticalWidgetRun.baseline = dependencyNode;
        verticalWidgetRun.baselineDimension = null;
        verticalWidgetRun.start.type = 6;
        verticalWidgetRun.end.type = 7;
        dependencyNode.type = 8;
        verticalWidgetRun.orientation = 1;
        this.verticalRun = verticalWidgetRun;
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, 2);
        this.mLeft = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = new ConstraintAnchor(this, 3);
        this.mTop = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = new ConstraintAnchor(this, 4);
        this.mRight = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = new ConstraintAnchor(this, 5);
        this.mBottom = constraintAnchor4;
        ConstraintAnchor constraintAnchor5 = new ConstraintAnchor(this, 6);
        this.mBaseline = constraintAnchor5;
        ConstraintAnchor constraintAnchor6 = new ConstraintAnchor(this, 8);
        this.mCenterX = constraintAnchor6;
        ConstraintAnchor constraintAnchor7 = new ConstraintAnchor(this, 9);
        this.mCenterY = constraintAnchor7;
        ConstraintAnchor constraintAnchor8 = new ConstraintAnchor(this, 7);
        this.mCenter = constraintAnchor8;
        this.mListAnchors = new ConstraintAnchor[]{constraintAnchor, constraintAnchor3, constraintAnchor2, constraintAnchor4, constraintAnchor5, constraintAnchor8};
        ArrayList arrayList = new ArrayList();
        this.mAnchors = arrayList;
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new int[]{1, 1};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        arrayList.add(constraintAnchor);
        arrayList.add(constraintAnchor2);
        arrayList.add(constraintAnchor3);
        arrayList.add(constraintAnchor4);
        arrayList.add(constraintAnchor6);
        arrayList.add(constraintAnchor7);
        arrayList.add(constraintAnchor8);
        arrayList.add(constraintAnchor5);
    }

    /* JADX WARN: Code duplicated, block: B:190:0x02da  */
    /* JADX WARN: Code duplicated, block: B:195:0x02e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:199:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:203:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:205:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:208:0x031a  */
    /* JADX WARN: Code duplicated, block: B:210:0x0322  */
    /* JADX WARN: Code duplicated, block: B:212:0x0326  */
    /* JADX WARN: Code duplicated, block: B:224:0x0372  */
    /* JADX WARN: Code duplicated, block: B:225:0x0379  */
    /* JADX WARN: Code duplicated, block: B:228:0x037f  */
    /* JADX WARN: Code duplicated, block: B:230:0x038a  */
    /* JADX WARN: Code duplicated, block: B:232:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:235:0x0406  */
    /* JADX WARN: Code duplicated, block: B:247:0x0443  */
    /* JADX WARN: Code duplicated, block: B:250:0x0453  */
    /* JADX WARN: Code duplicated, block: B:253:0x0457  */
    /* JADX WARN: Code duplicated, block: B:255:0x045b  */
    /* JADX WARN: Code duplicated, block: B:258:0x0461  */
    /* JADX WARN: Code duplicated, block: B:260:0x0464  */
    /* JADX WARN: Code duplicated, block: B:262:0x0468  */
    /* JADX WARN: Code duplicated, block: B:267:0x0472  */
    /* JADX WARN: Code duplicated, block: B:270:0x0478  */
    /* JADX WARN: Code duplicated, block: B:271:0x047f  */
    /* JADX WARN: Code duplicated, block: B:274:0x0485  */
    /* JADX WARN: Code duplicated, block: B:277:0x048f  */
    /* JADX WARN: Code duplicated, block: B:279:0x0493  */
    /* JADX WARN: Code duplicated, block: B:281:0x049c  */
    /* JADX WARN: Code duplicated, block: B:283:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:285:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:287:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:289:0x0500  */
    /* JADX WARN: Code duplicated, block: B:291:0x0506  */
    /* JADX WARN: Code duplicated, block: B:293:0x050d  */
    /* JADX WARN: Code duplicated, block: B:294:0x0536  */
    /* JADX WARN: Code duplicated, block: B:297:0x0564  */
    /* JADX WARN: Code duplicated, block: B:303:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public void addToSolver(LinearSystem linearSystem) {
        HorizontalWidgetRun horizontalWidgetRun;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        SolverVariable solverVariable;
        char c;
        HorizontalWidgetRun horizontalWidgetRun2;
        int i;
        int i2;
        boolean z5;
        boolean z6;
        boolean z7;
        ConstraintAnchor constraintAnchor;
        boolean z8;
        boolean z9;
        boolean z10;
        int i3;
        HorizontalWidgetRun horizontalWidgetRun3;
        int[] iArr;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        boolean z11;
        boolean z12;
        boolean z13;
        VerticalWidgetRun verticalWidgetRun;
        DependencyNode dependencyNode;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        int i4;
        int i5;
        int i6;
        int i7;
        SolverVariable solverVariable8;
        int i8;
        boolean z14;
        ConstraintWidget constraintWidget;
        SolverVariable solverVariableCreateObjectVariable;
        int i9;
        Object obj;
        boolean z15;
        int i10;
        DependencyNode dependencyNode2;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariableCreateObjectVariable2;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariableCreateObjectVariable3;
        int i11;
        boolean zIsInHorizontalChain;
        int i12;
        boolean zIsInVerticalChain;
        LinearSystem linearSystem2 = linearSystem;
        ConstraintAnchor constraintAnchor2 = this.mLeft;
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem2.createObjectVariable(constraintAnchor2);
        ConstraintAnchor constraintAnchor3 = this.mRight;
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem2.createObjectVariable(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = this.mTop;
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem2.createObjectVariable(constraintAnchor4);
        ConstraintAnchor constraintAnchor5 = this.mBottom;
        SolverVariable solverVariableCreateObjectVariable7 = linearSystem2.createObjectVariable(constraintAnchor5);
        ConstraintAnchor constraintAnchor6 = this.mBaseline;
        SolverVariable solverVariableCreateObjectVariable8 = linearSystem2.createObjectVariable(constraintAnchor6);
        HorizontalWidgetRun horizontalWidgetRun4 = this.horizontalRun;
        DependencyNode dependencyNode3 = horizontalWidgetRun4.start;
        DependencyNode dependencyNode4 = horizontalWidgetRun4.end;
        boolean z16 = dependencyNode3.resolved;
        boolean[] zArr = this.isTerminalWidget;
        VerticalWidgetRun verticalWidgetRun2 = this.verticalRun;
        if (z16 && dependencyNode4.resolved) {
            DependencyNode dependencyNode5 = verticalWidgetRun2.start;
            horizontalWidgetRun = horizontalWidgetRun4;
            DependencyNode dependencyNode6 = verticalWidgetRun2.end;
            if (dependencyNode5.resolved && dependencyNode6.resolved) {
                linearSystem2.addEquality(solverVariableCreateObjectVariable4, dependencyNode3.value);
                linearSystem2.addEquality(solverVariableCreateObjectVariable5, dependencyNode4.value);
                linearSystem2.addEquality(solverVariableCreateObjectVariable6, verticalWidgetRun2.start.value);
                linearSystem2.addEquality(solverVariableCreateObjectVariable7, dependencyNode6.value);
                linearSystem2.addEquality(solverVariableCreateObjectVariable8, verticalWidgetRun2.baseline.value);
                ConstraintWidget constraintWidget4 = this.mParent;
                if (constraintWidget4 != null) {
                    int[] iArr2 = constraintWidget4.mListDimensionBehaviors;
                    boolean z17 = iArr2[0] == 2;
                    boolean z18 = iArr2[1] == 2;
                    if (z17 && zArr[0] && !isInHorizontalChain()) {
                        linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable5, 0, 8);
                    }
                    if (z18 && zArr[1] && !isInVerticalChain()) {
                        linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable7, 0, 8);
                        return;
                    }
                    return;
                }
                return;
            }
        } else {
            horizontalWidgetRun = horizontalWidgetRun4;
        }
        ConstraintWidget constraintWidget5 = this.mParent;
        if (constraintWidget5 != null) {
            int[] iArr3 = constraintWidget5.mListDimensionBehaviors;
            z2 = iArr3[0] == 2;
            boolean z19 = iArr3[1] == 2;
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                zIsInHorizontalChain = true;
                i12 = 1;
            } else {
                zIsInHorizontalChain = isInHorizontalChain();
                i12 = 1;
            }
            if (isChainHead(i12)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, i12);
                zIsInVerticalChain = true;
            } else {
                zIsInVerticalChain = isInVerticalChain();
            }
            if (zIsInHorizontalChain == 0 && z2) {
                z4 = zIsInVerticalChain;
                if (this.mVisibility != 8 && constraintAnchor2.mTarget == null && constraintAnchor3.mTarget == null) {
                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable5, 0, 1);
                }
            } else {
                z4 = zIsInVerticalChain;
            }
            if (!z4 && z19 && this.mVisibility != 8 && constraintAnchor4.mTarget == null && constraintAnchor5.mTarget == null && constraintAnchor6 == null) {
                linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable7, 0, 1);
            }
            z = z19;
            z3 = zIsInHorizontalChain;
        } else {
            constraintAnchor2 = constraintAnchor2;
            solverVariableCreateObjectVariable6 = solverVariableCreateObjectVariable6;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i13 = this.mWidth;
        int i14 = this.mMinWidth;
        if (i13 >= i14) {
            i14 = i13;
        }
        int i15 = this.mHeight;
        boolean z20 = z;
        int i16 = this.mMinHeight;
        int i17 = i15 < i16 ? i16 : i15;
        int[] iArr4 = this.mListDimensionBehaviors;
        int i18 = iArr4[0];
        boolean z21 = i18 != 3;
        int i19 = iArr4[1];
        boolean z22 = i19 != 3;
        int i20 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = i20;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i21 = this.mMatchConstraintDefaultWidth;
        int i22 = this.mMatchConstraintDefaultHeight;
        if (f > 0.0f) {
            solverVariable = solverVariableCreateObjectVariable7;
            if (this.mVisibility != 8) {
                c = 3;
                i = (i18 == 3 && i21 == 0) ? 3 : i21;
                int i23 = (i19 == 3 && i22 == 0) ? 3 : i22;
                if (i18 != 3 || i19 != 3 || i != 3 || i23 != 3) {
                    if (i18 == 3 && i == 3) {
                        this.mResolvedDimensionRatioSide = 0;
                        int i24 = (int) (f * i15);
                        c = 3;
                        i14 = i24;
                        horizontalWidgetRun2 = horizontalWidgetRun;
                        if (i19 != 3) {
                            i = 4;
                            z5 = false;
                        }
                        i2 = i23;
                        int[] iArr5 = this.mResolvedMatchConstraintDefault;
                        iArr5[0] = i;
                        iArr5[1] = i2;
                        z6 = !z5 && ((i11 = this.mResolvedDimensionRatioSide) == 0 || i11 == -1);
                        if (iArr4[0] == 2 || !(this instanceof ConstraintWidgetContainer)) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (z7) {
                            i14 = 0;
                        }
                        constraintAnchor = this.mCenter;
                        z8 = !constraintAnchor.isConnected();
                        boolean[] zArr2 = this.mIsInBarrier;
                        z9 = zArr2[0];
                        z10 = zArr2[1];
                        i3 = this.mHorizontalResolution;
                        horizontalWidgetRun3 = horizontalWidgetRun2;
                        iArr = this.mMaxDimension;
                        if (i3 != 2) {
                            dependencyNode2 = horizontalWidgetRun3.start;
                            if (dependencyNode2.resolved || !dependencyNode4.resolved) {
                                constraintWidget2 = this.mParent;
                                if (constraintWidget2 != null) {
                                    solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                                } else {
                                    solverVariableCreateObjectVariable2 = null;
                                }
                                constraintWidget3 = this.mParent;
                                if (constraintWidget3 != null) {
                                    solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                                } else {
                                    solverVariableCreateObjectVariable3 = null;
                                }
                                z11 = z2;
                                boolean z23 = z6;
                                z12 = z4;
                                z13 = z20;
                                solverVariable3 = solverVariableCreateObjectVariable5;
                                solverVariable2 = solverVariableCreateObjectVariable4;
                                solverVariable4 = solverVariableCreateObjectVariable8;
                                linearSystem2 = linearSystem;
                                applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z23, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                                verticalWidgetRun = verticalWidgetRun2;
                            } else {
                                linearSystem2.addEquality(solverVariableCreateObjectVariable4, dependencyNode2.value);
                                linearSystem2.addEquality(solverVariableCreateObjectVariable5, dependencyNode4.value);
                                if (this.mParent != null && z2 && zArr[0] && !isInHorizontalChain()) {
                                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable5, 0, 8);
                                }
                                solverVariable2 = solverVariableCreateObjectVariable4;
                                solverVariable3 = solverVariableCreateObjectVariable5;
                                solverVariable4 = solverVariableCreateObjectVariable8;
                                z11 = z2;
                                z12 = z4;
                                z13 = z20;
                                verticalWidgetRun = verticalWidgetRun2;
                            }
                        } else {
                            solverVariable2 = solverVariableCreateObjectVariable4;
                            solverVariable3 = solverVariableCreateObjectVariable5;
                            solverVariable4 = solverVariableCreateObjectVariable8;
                            z11 = z2;
                            z12 = z4;
                            z13 = z20;
                            verticalWidgetRun = verticalWidgetRun2;
                        }
                        dependencyNode = verticalWidgetRun.start;
                        DependencyNode dependencyNode7 = verticalWidgetRun.end;
                        if (dependencyNode.resolved || !dependencyNode7.resolved) {
                            solverVariable5 = solverVariableCreateObjectVariable6;
                            solverVariable6 = solverVariable;
                            solverVariable7 = solverVariable4;
                            i4 = 1;
                            i5 = 8;
                            i6 = 0;
                            i7 = 1;
                        } else {
                            solverVariable5 = solverVariableCreateObjectVariable6;
                            linearSystem2.addEquality(solverVariable5, dependencyNode.value);
                            int i25 = dependencyNode7.value;
                            solverVariable6 = solverVariable;
                            linearSystem2.addEquality(solverVariable6, i25);
                            solverVariable7 = solverVariable4;
                            linearSystem2.addEquality(solverVariable7, verticalWidgetRun.baseline.value);
                            ConstraintWidget constraintWidget6 = this.mParent;
                            if (constraintWidget6 == null || z12 || !z13) {
                                i4 = 1;
                            } else {
                                i4 = 1;
                                if (zArr[1]) {
                                    i5 = 8;
                                    i6 = 0;
                                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget6.mBottom), solverVariable6, 0, 8);
                                }
                                i7 = i6;
                            }
                            i5 = 8;
                            i6 = 0;
                            i7 = i6;
                        }
                        if (this.mVerticalResolution == 2) {
                            i7 = i6;
                        }
                        if (i7 != 0) {
                            if (iArr4[i4] == 2 || !(this instanceof ConstraintWidgetContainer)) {
                                i8 = i6;
                            } else {
                                i8 = i4;
                            }
                            if (i8 != 0) {
                                i17 = i6;
                            }
                            if (z5 || !((i10 = this.mResolvedDimensionRatioSide) == i4 || i10 == -1)) {
                                z14 = i6;
                            } else {
                                z14 = i4;
                            }
                            constraintWidget = this.mParent;
                            if (constraintWidget != null) {
                                solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(constraintWidget.mBottom);
                            } else {
                                solverVariableCreateObjectVariable = null;
                            }
                            ConstraintWidget constraintWidget7 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable9 = constraintWidget7 != null ? linearSystem2.createObjectVariable(constraintWidget7.mTop) : null;
                            i9 = this.mBaselineDistance;
                            if (i9 <= 0 || this.mVisibility == i5) {
                                z15 = z8;
                                linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                                obj = constraintAnchor6.mTarget;
                                if (obj != null) {
                                    linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                                    if (z13) {
                                        linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                                    }
                                    z15 = i6;
                                } else if (this.mVisibility == i5) {
                                    z15 = z8;
                                    linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                                    z15 = z8;
                                }
                            }
                            z15 = z8;
                            z15 = z8;
                            solverVariable8 = solverVariable5;
                            linearSystem2 = linearSystem;
                            applyConstraints(linearSystem2, false, z13, z11, r24[i4], solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable, iArr4[i4], i8, this.mTop, this.mBottom, this.mY, i17, this.mMinHeight, iArr[i4], this.mVerticalBiasPercent, z14, z12, z3, z10, i2, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z15);
                        } else {
                            solverVariable8 = solverVariable5;
                        }
                        if (z5) {
                            if (this.mResolvedDimensionRatioSide == 1) {
                                float f2 = this.mResolvedDimensionRatio;
                                ArrayRow arrayRowCreateRow = linearSystem2.createRow();
                                arrayRowCreateRow.variables.put(solverVariable6, -1.0f);
                                arrayRowCreateRow.variables.put(solverVariable8, 1.0f);
                                arrayRowCreateRow.variables.put(solverVariable3, f2);
                                arrayRowCreateRow.variables.put(solverVariable2, -f2);
                                linearSystem2.addConstraint(arrayRowCreateRow);
                            } else {
                                float f3 = this.mResolvedDimensionRatio;
                                ArrayRow arrayRowCreateRow2 = linearSystem2.createRow();
                                arrayRowCreateRow2.variables.put(solverVariable3, -1.0f);
                                arrayRowCreateRow2.variables.put(solverVariable2, 1.0f);
                                arrayRowCreateRow2.variables.put(solverVariable6, f3);
                                arrayRowCreateRow2.variables.put(solverVariable8, -f3);
                                linearSystem2.addConstraint(arrayRowCreateRow2);
                            }
                        }
                        if (constraintAnchor.isConnected()) {
                            ConstraintWidget constraintWidget8 = constraintAnchor.mTarget.mOwner;
                            float radians = (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f);
                            int margin = constraintAnchor.getMargin();
                            SolverVariable solverVariableCreateObjectVariable10 = linearSystem2.createObjectVariable(getAnchor(2));
                            SolverVariable solverVariableCreateObjectVariable11 = linearSystem2.createObjectVariable(getAnchor(3));
                            SolverVariable solverVariableCreateObjectVariable12 = linearSystem2.createObjectVariable(getAnchor(4));
                            SolverVariable solverVariableCreateObjectVariable13 = linearSystem2.createObjectVariable(getAnchor(5));
                            SolverVariable solverVariableCreateObjectVariable14 = linearSystem2.createObjectVariable(constraintWidget8.getAnchor(2));
                            SolverVariable solverVariableCreateObjectVariable15 = linearSystem2.createObjectVariable(constraintWidget8.getAnchor(3));
                            SolverVariable solverVariableCreateObjectVariable16 = linearSystem2.createObjectVariable(constraintWidget8.getAnchor(4));
                            SolverVariable solverVariableCreateObjectVariable17 = linearSystem2.createObjectVariable(constraintWidget8.getAnchor(5));
                            ArrayRow arrayRowCreateRow3 = linearSystem2.createRow();
                            double d = radians;
                            double dSin = Math.sin(d);
                            double d2 = margin;
                            arrayRowCreateRow3.variables.put(solverVariableCreateObjectVariable15, 0.5f);
                            arrayRowCreateRow3.variables.put(solverVariableCreateObjectVariable17, 0.5f);
                            arrayRowCreateRow3.variables.put(solverVariableCreateObjectVariable11, -0.5f);
                            arrayRowCreateRow3.variables.put(solverVariableCreateObjectVariable13, -0.5f);
                            arrayRowCreateRow3.constantValue = -((float) (dSin * d2));
                            linearSystem2.addConstraint(arrayRowCreateRow3);
                            ArrayRow arrayRowCreateRow4 = linearSystem2.createRow();
                            float fCos = (float) (Math.cos(d) * d2);
                            arrayRowCreateRow4.variables.put(solverVariableCreateObjectVariable14, 0.5f);
                            arrayRowCreateRow4.variables.put(solverVariableCreateObjectVariable16, 0.5f);
                            arrayRowCreateRow4.variables.put(solverVariableCreateObjectVariable10, -0.5f);
                            arrayRowCreateRow4.variables.put(solverVariableCreateObjectVariable12, -0.5f);
                            arrayRowCreateRow4.constantValue = -fCos;
                            linearSystem2.addConstraint(arrayRowCreateRow4);
                        }
                    }
                    if (i19 == 3 && i23 == 3) {
                        this.mResolvedDimensionRatioSide = 1;
                        if (i20 == -1) {
                            this.mResolvedDimensionRatio = 1.0f / f;
                        }
                        i17 = (int) (this.mResolvedDimensionRatio * i13);
                        horizontalWidgetRun2 = horizontalWidgetRun;
                        if (i18 != 3) {
                            i2 = 4;
                        }
                    }
                    z5 = true;
                    i2 = i23;
                    int[] iArr6 = this.mResolvedMatchConstraintDefault;
                    iArr6[0] = i;
                    iArr6[1] = i2;
                    if (z5) {
                    }
                    if (iArr4[0] == 2) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        i14 = 0;
                    }
                    constraintAnchor = this.mCenter;
                    z8 = !constraintAnchor.isConnected();
                    boolean[] zArr3 = this.mIsInBarrier;
                    z9 = zArr3[0];
                    z10 = zArr3[1];
                    i3 = this.mHorizontalResolution;
                    horizontalWidgetRun3 = horizontalWidgetRun2;
                    iArr = this.mMaxDimension;
                    if (i3 != 2) {
                        dependencyNode2 = horizontalWidgetRun3.start;
                        if (dependencyNode2.resolved) {
                            constraintWidget2 = this.mParent;
                            if (constraintWidget2 != null) {
                                solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                            } else {
                                solverVariableCreateObjectVariable2 = null;
                            }
                            constraintWidget3 = this.mParent;
                            if (constraintWidget3 != null) {
                                solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                            } else {
                                solverVariableCreateObjectVariable3 = null;
                            }
                            z11 = z2;
                            boolean z24 = z6;
                            z12 = z4;
                            z13 = z20;
                            solverVariable3 = solverVariableCreateObjectVariable5;
                            solverVariable2 = solverVariableCreateObjectVariable4;
                            solverVariable4 = solverVariableCreateObjectVariable8;
                            linearSystem2 = linearSystem;
                            applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z24, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                            verticalWidgetRun = verticalWidgetRun2;
                        } else {
                            constraintWidget2 = this.mParent;
                            if (constraintWidget2 != null) {
                                solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                            } else {
                                solverVariableCreateObjectVariable2 = null;
                            }
                            constraintWidget3 = this.mParent;
                            if (constraintWidget3 != null) {
                                solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                            } else {
                                solverVariableCreateObjectVariable3 = null;
                            }
                            z11 = z2;
                            boolean z25 = z6;
                            z12 = z4;
                            z13 = z20;
                            solverVariable3 = solverVariableCreateObjectVariable5;
                            solverVariable2 = solverVariableCreateObjectVariable4;
                            solverVariable4 = solverVariableCreateObjectVariable8;
                            linearSystem2 = linearSystem;
                            applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z25, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                            verticalWidgetRun = verticalWidgetRun2;
                        }
                    } else {
                        solverVariable2 = solverVariableCreateObjectVariable4;
                        solverVariable3 = solverVariableCreateObjectVariable5;
                        solverVariable4 = solverVariableCreateObjectVariable8;
                        z11 = z2;
                        z12 = z4;
                        z13 = z20;
                        verticalWidgetRun = verticalWidgetRun2;
                    }
                    dependencyNode = verticalWidgetRun.start;
                    DependencyNode dependencyNode8 = verticalWidgetRun.end;
                    if (dependencyNode.resolved) {
                        solverVariable5 = solverVariableCreateObjectVariable6;
                        solverVariable6 = solverVariable;
                        solverVariable7 = solverVariable4;
                        i4 = 1;
                        i5 = 8;
                        i6 = 0;
                        i7 = 1;
                    } else {
                        solverVariable5 = solverVariableCreateObjectVariable6;
                        solverVariable6 = solverVariable;
                        solverVariable7 = solverVariable4;
                        i4 = 1;
                        i5 = 8;
                        i6 = 0;
                        i7 = 1;
                    }
                    if (this.mVerticalResolution == 2) {
                        i7 = i6;
                    }
                    if (i7 != 0) {
                        if (iArr4[i4] == 2) {
                            i8 = i6;
                        } else {
                            i8 = i6;
                        }
                        if (i8 != 0) {
                            i17 = i6;
                        }
                        if (z5) {
                            z14 = i6;
                        } else {
                            z14 = i6;
                        }
                        constraintWidget = this.mParent;
                        if (constraintWidget != null) {
                            solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(constraintWidget.mBottom);
                        } else {
                            solverVariableCreateObjectVariable = null;
                        }
                        ConstraintWidget constraintWidget9 = this.mParent;
                        if (constraintWidget9 != null) {
                        }
                        i9 = this.mBaselineDistance;
                        if (i9 <= 0) {
                            z15 = z8;
                            linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                            obj = constraintAnchor6.mTarget;
                            if (obj != null) {
                                linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                                if (z13) {
                                    linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                                }
                                z15 = i6;
                            } else if (this.mVisibility == i5) {
                                z15 = z8;
                                linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                                z15 = z8;
                            }
                        } else {
                            z15 = z8;
                            linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                            obj = constraintAnchor6.mTarget;
                            if (obj != null) {
                                linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                                if (z13) {
                                    linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                                }
                                z15 = i6;
                            } else if (this.mVisibility == i5) {
                                z15 = z8;
                                linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                                z15 = z8;
                            }
                        }
                        z15 = z8;
                        z15 = z8;
                        solverVariable8 = solverVariable5;
                        linearSystem2 = linearSystem;
                        applyConstraints(linearSystem2, false, z13, z11, r24[i4], solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable, iArr4[i4], i8, this.mTop, this.mBottom, this.mY, i17, this.mMinHeight, iArr[i4], this.mVerticalBiasPercent, z14, z12, z3, z10, i2, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z15);
                    } else {
                        solverVariable8 = solverVariable5;
                    }
                    if (z5) {
                        if (this.mResolvedDimensionRatioSide == 1) {
                            float f4 = this.mResolvedDimensionRatio;
                            ArrayRow arrayRowCreateRow5 = linearSystem2.createRow();
                            arrayRowCreateRow5.variables.put(solverVariable6, -1.0f);
                            arrayRowCreateRow5.variables.put(solverVariable8, 1.0f);
                            arrayRowCreateRow5.variables.put(solverVariable3, f4);
                            arrayRowCreateRow5.variables.put(solverVariable2, -f4);
                            linearSystem2.addConstraint(arrayRowCreateRow5);
                        } else {
                            float f5 = this.mResolvedDimensionRatio;
                            ArrayRow arrayRowCreateRow6 = linearSystem2.createRow();
                            arrayRowCreateRow6.variables.put(solverVariable3, -1.0f);
                            arrayRowCreateRow6.variables.put(solverVariable2, 1.0f);
                            arrayRowCreateRow6.variables.put(solverVariable6, f5);
                            arrayRowCreateRow6.variables.put(solverVariable8, -f5);
                            linearSystem2.addConstraint(arrayRowCreateRow6);
                        }
                    }
                    if (constraintAnchor.isConnected()) {
                        ConstraintWidget constraintWidget10 = constraintAnchor.mTarget.mOwner;
                        float radians2 = (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f);
                        int margin2 = constraintAnchor.getMargin();
                        SolverVariable solverVariableCreateObjectVariable18 = linearSystem2.createObjectVariable(getAnchor(2));
                        SolverVariable solverVariableCreateObjectVariable19 = linearSystem2.createObjectVariable(getAnchor(3));
                        SolverVariable solverVariableCreateObjectVariable110 = linearSystem2.createObjectVariable(getAnchor(4));
                        SolverVariable solverVariableCreateObjectVariable111 = linearSystem2.createObjectVariable(getAnchor(5));
                        SolverVariable solverVariableCreateObjectVariable112 = linearSystem2.createObjectVariable(constraintWidget10.getAnchor(2));
                        SolverVariable solverVariableCreateObjectVariable113 = linearSystem2.createObjectVariable(constraintWidget10.getAnchor(3));
                        SolverVariable solverVariableCreateObjectVariable114 = linearSystem2.createObjectVariable(constraintWidget10.getAnchor(4));
                        SolverVariable solverVariableCreateObjectVariable115 = linearSystem2.createObjectVariable(constraintWidget10.getAnchor(5));
                        ArrayRow arrayRowCreateRow7 = linearSystem2.createRow();
                        double d3 = radians2;
                        double dSin2 = Math.sin(d3);
                        double d4 = margin2;
                        arrayRowCreateRow7.variables.put(solverVariableCreateObjectVariable113, 0.5f);
                        arrayRowCreateRow7.variables.put(solverVariableCreateObjectVariable115, 0.5f);
                        arrayRowCreateRow7.variables.put(solverVariableCreateObjectVariable19, -0.5f);
                        arrayRowCreateRow7.variables.put(solverVariableCreateObjectVariable111, -0.5f);
                        arrayRowCreateRow7.constantValue = -((float) (dSin2 * d4));
                        linearSystem2.addConstraint(arrayRowCreateRow7);
                        ArrayRow arrayRowCreateRow8 = linearSystem2.createRow();
                        float fCos2 = (float) (Math.cos(d3) * d4);
                        arrayRowCreateRow8.variables.put(solverVariableCreateObjectVariable112, 0.5f);
                        arrayRowCreateRow8.variables.put(solverVariableCreateObjectVariable114, 0.5f);
                        arrayRowCreateRow8.variables.put(solverVariableCreateObjectVariable18, -0.5f);
                        arrayRowCreateRow8.variables.put(solverVariableCreateObjectVariable110, -0.5f);
                        arrayRowCreateRow8.constantValue = -fCos2;
                        linearSystem2.addConstraint(arrayRowCreateRow8);
                    }
                }
                if (i20 == -1) {
                    if (z21 && !z22) {
                        this.mResolvedDimensionRatioSide = 0;
                    } else if (!z21 && z22) {
                        this.mResolvedDimensionRatioSide = 1;
                        if (i20 == -1) {
                            this.mResolvedDimensionRatio = 1.0f / f;
                        }
                    }
                }
                if (this.mResolvedDimensionRatioSide == 0 && (!constraintAnchor4.isConnected() || !constraintAnchor5.isConnected())) {
                    this.mResolvedDimensionRatioSide = 1;
                } else if (this.mResolvedDimensionRatioSide == 1 && (!constraintAnchor2.isConnected() || !constraintAnchor3.isConnected())) {
                    this.mResolvedDimensionRatioSide = 0;
                }
                if (this.mResolvedDimensionRatioSide == -1 && (!constraintAnchor4.isConnected() || !constraintAnchor5.isConnected() || !constraintAnchor2.isConnected() || !constraintAnchor3.isConnected())) {
                    if (constraintAnchor4.isConnected() && constraintAnchor5.isConnected()) {
                        this.mResolvedDimensionRatioSide = 0;
                    } else if (constraintAnchor2.isConnected() && constraintAnchor3.isConnected()) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                        this.mResolvedDimensionRatioSide = 1;
                    }
                }
                if (this.mResolvedDimensionRatioSide == -1) {
                    int i26 = this.mMatchConstraintMinWidth;
                    if (i26 > 0 && this.mMatchConstraintMinHeight == 0) {
                        this.mResolvedDimensionRatioSide = 0;
                    } else if (i26 == 0 && this.mMatchConstraintMinHeight > 0) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                        this.mResolvedDimensionRatioSide = 1;
                    }
                }
                c = 3;
                horizontalWidgetRun2 = horizontalWidgetRun;
                z5 = true;
                i2 = i23;
                int[] iArr7 = this.mResolvedMatchConstraintDefault;
                iArr7[0] = i;
                iArr7[1] = i2;
                if (z5) {
                }
                if (iArr4[0] == 2) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                if (z7) {
                    i14 = 0;
                }
                constraintAnchor = this.mCenter;
                z8 = !constraintAnchor.isConnected();
                boolean[] zArr4 = this.mIsInBarrier;
                z9 = zArr4[0];
                z10 = zArr4[1];
                i3 = this.mHorizontalResolution;
                horizontalWidgetRun3 = horizontalWidgetRun2;
                iArr = this.mMaxDimension;
                if (i3 != 2) {
                    dependencyNode2 = horizontalWidgetRun3.start;
                    if (dependencyNode2.resolved) {
                        constraintWidget2 = this.mParent;
                        if (constraintWidget2 != null) {
                            solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                        } else {
                            solverVariableCreateObjectVariable2 = null;
                        }
                        constraintWidget3 = this.mParent;
                        if (constraintWidget3 != null) {
                            solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                        } else {
                            solverVariableCreateObjectVariable3 = null;
                        }
                        z11 = z2;
                        boolean z26 = z6;
                        z12 = z4;
                        z13 = z20;
                        solverVariable3 = solverVariableCreateObjectVariable5;
                        solverVariable2 = solverVariableCreateObjectVariable4;
                        solverVariable4 = solverVariableCreateObjectVariable8;
                        linearSystem2 = linearSystem;
                        applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z26, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                        verticalWidgetRun = verticalWidgetRun2;
                    } else {
                        constraintWidget2 = this.mParent;
                        if (constraintWidget2 != null) {
                            solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                        } else {
                            solverVariableCreateObjectVariable2 = null;
                        }
                        constraintWidget3 = this.mParent;
                        if (constraintWidget3 != null) {
                            solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                        } else {
                            solverVariableCreateObjectVariable3 = null;
                        }
                        z11 = z2;
                        boolean z27 = z6;
                        z12 = z4;
                        z13 = z20;
                        solverVariable3 = solverVariableCreateObjectVariable5;
                        solverVariable2 = solverVariableCreateObjectVariable4;
                        solverVariable4 = solverVariableCreateObjectVariable8;
                        linearSystem2 = linearSystem;
                        applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z27, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                        verticalWidgetRun = verticalWidgetRun2;
                    }
                } else {
                    solverVariable2 = solverVariableCreateObjectVariable4;
                    solverVariable3 = solverVariableCreateObjectVariable5;
                    solverVariable4 = solverVariableCreateObjectVariable8;
                    z11 = z2;
                    z12 = z4;
                    z13 = z20;
                    verticalWidgetRun = verticalWidgetRun2;
                }
                dependencyNode = verticalWidgetRun.start;
                DependencyNode dependencyNode9 = verticalWidgetRun.end;
                if (dependencyNode.resolved) {
                    solverVariable5 = solverVariableCreateObjectVariable6;
                    solverVariable6 = solverVariable;
                    solverVariable7 = solverVariable4;
                    i4 = 1;
                    i5 = 8;
                    i6 = 0;
                    i7 = 1;
                } else {
                    solverVariable5 = solverVariableCreateObjectVariable6;
                    solverVariable6 = solverVariable;
                    solverVariable7 = solverVariable4;
                    i4 = 1;
                    i5 = 8;
                    i6 = 0;
                    i7 = 1;
                }
                if (this.mVerticalResolution == 2) {
                    i7 = i6;
                }
                if (i7 != 0) {
                    if (iArr4[i4] == 2) {
                        i8 = i6;
                    } else {
                        i8 = i6;
                    }
                    if (i8 != 0) {
                        i17 = i6;
                    }
                    if (z5) {
                        z14 = i6;
                    } else {
                        z14 = i6;
                    }
                    constraintWidget = this.mParent;
                    if (constraintWidget != null) {
                        solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(constraintWidget.mBottom);
                    } else {
                        solverVariableCreateObjectVariable = null;
                    }
                    ConstraintWidget constraintWidget11 = this.mParent;
                    if (constraintWidget11 != null) {
                    }
                    i9 = this.mBaselineDistance;
                    if (i9 <= 0) {
                        z15 = z8;
                        linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                        obj = constraintAnchor6.mTarget;
                        if (obj != null) {
                            linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                            if (z13) {
                                linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                            }
                            z15 = i6;
                        } else if (this.mVisibility == i5) {
                            z15 = z8;
                            linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                            z15 = z8;
                        }
                    } else {
                        z15 = z8;
                        linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                        obj = constraintAnchor6.mTarget;
                        if (obj != null) {
                            linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                            if (z13) {
                                linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                            }
                            z15 = i6;
                        } else if (this.mVisibility == i5) {
                            z15 = z8;
                            linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                            z15 = z8;
                        }
                    }
                    z15 = z8;
                    z15 = z8;
                    solverVariable8 = solverVariable5;
                    linearSystem2 = linearSystem;
                    applyConstraints(linearSystem2, false, z13, z11, r24[i4], solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable, iArr4[i4], i8, this.mTop, this.mBottom, this.mY, i17, this.mMinHeight, iArr[i4], this.mVerticalBiasPercent, z14, z12, z3, z10, i2, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z15);
                } else {
                    solverVariable8 = solverVariable5;
                }
                if (z5) {
                    if (this.mResolvedDimensionRatioSide == 1) {
                        float f6 = this.mResolvedDimensionRatio;
                        ArrayRow arrayRowCreateRow9 = linearSystem2.createRow();
                        arrayRowCreateRow9.variables.put(solverVariable6, -1.0f);
                        arrayRowCreateRow9.variables.put(solverVariable8, 1.0f);
                        arrayRowCreateRow9.variables.put(solverVariable3, f6);
                        arrayRowCreateRow9.variables.put(solverVariable2, -f6);
                        linearSystem2.addConstraint(arrayRowCreateRow9);
                    } else {
                        float f7 = this.mResolvedDimensionRatio;
                        ArrayRow arrayRowCreateRow10 = linearSystem2.createRow();
                        arrayRowCreateRow10.variables.put(solverVariable3, -1.0f);
                        arrayRowCreateRow10.variables.put(solverVariable2, 1.0f);
                        arrayRowCreateRow10.variables.put(solverVariable6, f7);
                        arrayRowCreateRow10.variables.put(solverVariable8, -f7);
                        linearSystem2.addConstraint(arrayRowCreateRow10);
                    }
                }
                if (constraintAnchor.isConnected()) {
                    ConstraintWidget constraintWidget12 = constraintAnchor.mTarget.mOwner;
                    float radians3 = (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f);
                    int margin3 = constraintAnchor.getMargin();
                    SolverVariable solverVariableCreateObjectVariable116 = linearSystem2.createObjectVariable(getAnchor(2));
                    SolverVariable solverVariableCreateObjectVariable117 = linearSystem2.createObjectVariable(getAnchor(3));
                    SolverVariable solverVariableCreateObjectVariable118 = linearSystem2.createObjectVariable(getAnchor(4));
                    SolverVariable solverVariableCreateObjectVariable119 = linearSystem2.createObjectVariable(getAnchor(5));
                    SolverVariable solverVariableCreateObjectVariable1110 = linearSystem2.createObjectVariable(constraintWidget12.getAnchor(2));
                    SolverVariable solverVariableCreateObjectVariable1111 = linearSystem2.createObjectVariable(constraintWidget12.getAnchor(3));
                    SolverVariable solverVariableCreateObjectVariable1112 = linearSystem2.createObjectVariable(constraintWidget12.getAnchor(4));
                    SolverVariable solverVariableCreateObjectVariable1113 = linearSystem2.createObjectVariable(constraintWidget12.getAnchor(5));
                    ArrayRow arrayRowCreateRow11 = linearSystem2.createRow();
                    double d5 = radians3;
                    double dSin3 = Math.sin(d5);
                    double d6 = margin3;
                    arrayRowCreateRow11.variables.put(solverVariableCreateObjectVariable1111, 0.5f);
                    arrayRowCreateRow11.variables.put(solverVariableCreateObjectVariable1113, 0.5f);
                    arrayRowCreateRow11.variables.put(solverVariableCreateObjectVariable117, -0.5f);
                    arrayRowCreateRow11.variables.put(solverVariableCreateObjectVariable119, -0.5f);
                    arrayRowCreateRow11.constantValue = -((float) (dSin3 * d6));
                    linearSystem2.addConstraint(arrayRowCreateRow11);
                    ArrayRow arrayRowCreateRow12 = linearSystem2.createRow();
                    float fCos3 = (float) (Math.cos(d5) * d6);
                    arrayRowCreateRow12.variables.put(solverVariableCreateObjectVariable1110, 0.5f);
                    arrayRowCreateRow12.variables.put(solverVariableCreateObjectVariable1112, 0.5f);
                    arrayRowCreateRow12.variables.put(solverVariableCreateObjectVariable116, -0.5f);
                    arrayRowCreateRow12.variables.put(solverVariableCreateObjectVariable118, -0.5f);
                    arrayRowCreateRow12.constantValue = -fCos3;
                    linearSystem2.addConstraint(arrayRowCreateRow12);
                }
            }
            z5 = false;
            int[] iArr8 = this.mResolvedMatchConstraintDefault;
            iArr8[0] = i;
            iArr8[1] = i2;
            if (z5) {
            }
            if (iArr4[0] == 2) {
                z7 = false;
            } else {
                z7 = false;
            }
            if (z7) {
                i14 = 0;
            }
            constraintAnchor = this.mCenter;
            z8 = !constraintAnchor.isConnected();
            boolean[] zArr5 = this.mIsInBarrier;
            z9 = zArr5[0];
            z10 = zArr5[1];
            i3 = this.mHorizontalResolution;
            horizontalWidgetRun3 = horizontalWidgetRun2;
            iArr = this.mMaxDimension;
            if (i3 != 2) {
                dependencyNode2 = horizontalWidgetRun3.start;
                if (dependencyNode2.resolved) {
                    constraintWidget2 = this.mParent;
                    if (constraintWidget2 != null) {
                        solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                    } else {
                        solverVariableCreateObjectVariable2 = null;
                    }
                    constraintWidget3 = this.mParent;
                    if (constraintWidget3 != null) {
                        solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                    } else {
                        solverVariableCreateObjectVariable3 = null;
                    }
                    z11 = z2;
                    boolean z28 = z6;
                    z12 = z4;
                    z13 = z20;
                    solverVariable3 = solverVariableCreateObjectVariable5;
                    solverVariable2 = solverVariableCreateObjectVariable4;
                    solverVariable4 = solverVariableCreateObjectVariable8;
                    linearSystem2 = linearSystem;
                    applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z28, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                    verticalWidgetRun = verticalWidgetRun2;
                } else {
                    constraintWidget2 = this.mParent;
                    if (constraintWidget2 != null) {
                        solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                    } else {
                        solverVariableCreateObjectVariable2 = null;
                    }
                    constraintWidget3 = this.mParent;
                    if (constraintWidget3 != null) {
                        solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                    } else {
                        solverVariableCreateObjectVariable3 = null;
                    }
                    z11 = z2;
                    boolean z29 = z6;
                    z12 = z4;
                    z13 = z20;
                    solverVariable3 = solverVariableCreateObjectVariable5;
                    solverVariable2 = solverVariableCreateObjectVariable4;
                    solverVariable4 = solverVariableCreateObjectVariable8;
                    linearSystem2 = linearSystem;
                    applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z29, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                    verticalWidgetRun = verticalWidgetRun2;
                }
            } else {
                solverVariable2 = solverVariableCreateObjectVariable4;
                solverVariable3 = solverVariableCreateObjectVariable5;
                solverVariable4 = solverVariableCreateObjectVariable8;
                z11 = z2;
                z12 = z4;
                z13 = z20;
                verticalWidgetRun = verticalWidgetRun2;
            }
            dependencyNode = verticalWidgetRun.start;
            DependencyNode dependencyNode10 = verticalWidgetRun.end;
            if (dependencyNode.resolved) {
                solverVariable5 = solverVariableCreateObjectVariable6;
                solverVariable6 = solverVariable;
                solverVariable7 = solverVariable4;
                i4 = 1;
                i5 = 8;
                i6 = 0;
                i7 = 1;
            } else {
                solverVariable5 = solverVariableCreateObjectVariable6;
                solverVariable6 = solverVariable;
                solverVariable7 = solverVariable4;
                i4 = 1;
                i5 = 8;
                i6 = 0;
                i7 = 1;
            }
            if (this.mVerticalResolution == 2) {
                i7 = i6;
            }
            if (i7 != 0) {
                if (iArr4[i4] == 2) {
                    i8 = i6;
                } else {
                    i8 = i6;
                }
                if (i8 != 0) {
                    i17 = i6;
                }
                if (z5) {
                    z14 = i6;
                } else {
                    z14 = i6;
                }
                constraintWidget = this.mParent;
                if (constraintWidget != null) {
                    solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(constraintWidget.mBottom);
                } else {
                    solverVariableCreateObjectVariable = null;
                }
                ConstraintWidget constraintWidget13 = this.mParent;
                if (constraintWidget13 != null) {
                }
                i9 = this.mBaselineDistance;
                if (i9 <= 0) {
                    z15 = z8;
                    linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                    obj = constraintAnchor6.mTarget;
                    if (obj != null) {
                        linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                        if (z13) {
                            linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                        }
                        z15 = i6;
                    } else if (this.mVisibility == i5) {
                        z15 = z8;
                        linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                        z15 = z8;
                    }
                } else {
                    z15 = z8;
                    linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                    obj = constraintAnchor6.mTarget;
                    if (obj != null) {
                        linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                        if (z13) {
                            linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                        }
                        z15 = i6;
                    } else if (this.mVisibility == i5) {
                        z15 = z8;
                        linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                        z15 = z8;
                    }
                }
                z15 = z8;
                z15 = z8;
                solverVariable8 = solverVariable5;
                linearSystem2 = linearSystem;
                applyConstraints(linearSystem2, false, z13, z11, r24[i4], solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable, iArr4[i4], i8, this.mTop, this.mBottom, this.mY, i17, this.mMinHeight, iArr[i4], this.mVerticalBiasPercent, z14, z12, z3, z10, i2, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z15);
            } else {
                solverVariable8 = solverVariable5;
            }
            if (z5) {
                if (this.mResolvedDimensionRatioSide == 1) {
                    float f8 = this.mResolvedDimensionRatio;
                    ArrayRow arrayRowCreateRow13 = linearSystem2.createRow();
                    arrayRowCreateRow13.variables.put(solverVariable6, -1.0f);
                    arrayRowCreateRow13.variables.put(solverVariable8, 1.0f);
                    arrayRowCreateRow13.variables.put(solverVariable3, f8);
                    arrayRowCreateRow13.variables.put(solverVariable2, -f8);
                    linearSystem2.addConstraint(arrayRowCreateRow13);
                } else {
                    float f9 = this.mResolvedDimensionRatio;
                    ArrayRow arrayRowCreateRow14 = linearSystem2.createRow();
                    arrayRowCreateRow14.variables.put(solverVariable3, -1.0f);
                    arrayRowCreateRow14.variables.put(solverVariable2, 1.0f);
                    arrayRowCreateRow14.variables.put(solverVariable6, f9);
                    arrayRowCreateRow14.variables.put(solverVariable8, -f9);
                    linearSystem2.addConstraint(arrayRowCreateRow14);
                }
            }
            if (constraintAnchor.isConnected()) {
                ConstraintWidget constraintWidget14 = constraintAnchor.mTarget.mOwner;
                float radians4 = (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f);
                int margin4 = constraintAnchor.getMargin();
                SolverVariable solverVariableCreateObjectVariable1114 = linearSystem2.createObjectVariable(getAnchor(2));
                SolverVariable solverVariableCreateObjectVariable1115 = linearSystem2.createObjectVariable(getAnchor(3));
                SolverVariable solverVariableCreateObjectVariable1116 = linearSystem2.createObjectVariable(getAnchor(4));
                SolverVariable solverVariableCreateObjectVariable1117 = linearSystem2.createObjectVariable(getAnchor(5));
                SolverVariable solverVariableCreateObjectVariable1118 = linearSystem2.createObjectVariable(constraintWidget14.getAnchor(2));
                SolverVariable solverVariableCreateObjectVariable1119 = linearSystem2.createObjectVariable(constraintWidget14.getAnchor(3));
                SolverVariable solverVariableCreateObjectVariable11110 = linearSystem2.createObjectVariable(constraintWidget14.getAnchor(4));
                SolverVariable solverVariableCreateObjectVariable11111 = linearSystem2.createObjectVariable(constraintWidget14.getAnchor(5));
                ArrayRow arrayRowCreateRow15 = linearSystem2.createRow();
                double d7 = radians4;
                double dSin4 = Math.sin(d7);
                double d8 = margin4;
                arrayRowCreateRow15.variables.put(solverVariableCreateObjectVariable1119, 0.5f);
                arrayRowCreateRow15.variables.put(solverVariableCreateObjectVariable11111, 0.5f);
                arrayRowCreateRow15.variables.put(solverVariableCreateObjectVariable1115, -0.5f);
                arrayRowCreateRow15.variables.put(solverVariableCreateObjectVariable1117, -0.5f);
                arrayRowCreateRow15.constantValue = -((float) (dSin4 * d8));
                linearSystem2.addConstraint(arrayRowCreateRow15);
                ArrayRow arrayRowCreateRow16 = linearSystem2.createRow();
                float fCos4 = (float) (Math.cos(d7) * d8);
                arrayRowCreateRow16.variables.put(solverVariableCreateObjectVariable1118, 0.5f);
                arrayRowCreateRow16.variables.put(solverVariableCreateObjectVariable11110, 0.5f);
                arrayRowCreateRow16.variables.put(solverVariableCreateObjectVariable1114, -0.5f);
                arrayRowCreateRow16.variables.put(solverVariableCreateObjectVariable1116, -0.5f);
                arrayRowCreateRow16.constantValue = -fCos4;
                linearSystem2.addConstraint(arrayRowCreateRow16);
            }
        }
        solverVariable = solverVariableCreateObjectVariable7;
        verticalWidgetRun2 = verticalWidgetRun2;
        c = 3;
        horizontalWidgetRun2 = horizontalWidgetRun;
        i = i21;
        i2 = i22;
        z5 = false;
        int[] iArr9 = this.mResolvedMatchConstraintDefault;
        iArr9[0] = i;
        iArr9[1] = i2;
        if (z5) {
        }
        if (iArr4[0] == 2) {
            z7 = false;
        } else {
            z7 = false;
        }
        if (z7) {
            i14 = 0;
        }
        constraintAnchor = this.mCenter;
        z8 = !constraintAnchor.isConnected();
        boolean[] zArr6 = this.mIsInBarrier;
        z9 = zArr6[0];
        z10 = zArr6[1];
        i3 = this.mHorizontalResolution;
        horizontalWidgetRun3 = horizontalWidgetRun2;
        iArr = this.mMaxDimension;
        if (i3 != 2) {
            dependencyNode2 = horizontalWidgetRun3.start;
            if (dependencyNode2.resolved) {
                constraintWidget2 = this.mParent;
                if (constraintWidget2 != null) {
                    solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                } else {
                    solverVariableCreateObjectVariable2 = null;
                }
                constraintWidget3 = this.mParent;
                if (constraintWidget3 != null) {
                    solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                } else {
                    solverVariableCreateObjectVariable3 = null;
                }
                z11 = z2;
                boolean z210 = z6;
                z12 = z4;
                z13 = z20;
                solverVariable3 = solverVariableCreateObjectVariable5;
                solverVariable2 = solverVariableCreateObjectVariable4;
                solverVariable4 = solverVariableCreateObjectVariable8;
                linearSystem2 = linearSystem;
                applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z210, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                verticalWidgetRun = verticalWidgetRun2;
            } else {
                constraintWidget2 = this.mParent;
                if (constraintWidget2 != null) {
                    solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                } else {
                    solverVariableCreateObjectVariable2 = null;
                }
                constraintWidget3 = this.mParent;
                if (constraintWidget3 != null) {
                    solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                } else {
                    solverVariableCreateObjectVariable3 = null;
                }
                z11 = z2;
                boolean z211 = z6;
                z12 = z4;
                z13 = z20;
                solverVariable3 = solverVariableCreateObjectVariable5;
                solverVariable2 = solverVariableCreateObjectVariable4;
                solverVariable4 = solverVariableCreateObjectVariable8;
                linearSystem2 = linearSystem;
                applyConstraints(linearSystem2, true, z11, z13, zArr[0], solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, iArr4[0], z7, this.mLeft, this.mRight, this.mX, i14, this.mMinWidth, iArr[0], this.mHorizontalBiasPercent, z211, z3, z12, z9, i, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z8);
                verticalWidgetRun = verticalWidgetRun2;
            }
        } else {
            solverVariable2 = solverVariableCreateObjectVariable4;
            solverVariable3 = solverVariableCreateObjectVariable5;
            solverVariable4 = solverVariableCreateObjectVariable8;
            z11 = z2;
            z12 = z4;
            z13 = z20;
            verticalWidgetRun = verticalWidgetRun2;
        }
        dependencyNode = verticalWidgetRun.start;
        DependencyNode dependencyNode11 = verticalWidgetRun.end;
        if (dependencyNode.resolved) {
            solverVariable5 = solverVariableCreateObjectVariable6;
            solverVariable6 = solverVariable;
            solverVariable7 = solverVariable4;
            i4 = 1;
            i5 = 8;
            i6 = 0;
            i7 = 1;
        } else {
            solverVariable5 = solverVariableCreateObjectVariable6;
            solverVariable6 = solverVariable;
            solverVariable7 = solverVariable4;
            i4 = 1;
            i5 = 8;
            i6 = 0;
            i7 = 1;
        }
        if (this.mVerticalResolution == 2) {
            i7 = i6;
        }
        if (i7 != 0) {
            if (iArr4[i4] == 2) {
                i8 = i6;
            } else {
                i8 = i6;
            }
            if (i8 != 0) {
                i17 = i6;
            }
            if (z5) {
                z14 = i6;
            } else {
                z14 = i6;
            }
            constraintWidget = this.mParent;
            if (constraintWidget != null) {
                solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(constraintWidget.mBottom);
            } else {
                solverVariableCreateObjectVariable = null;
            }
            ConstraintWidget constraintWidget15 = this.mParent;
            if (constraintWidget15 != null) {
            }
            i9 = this.mBaselineDistance;
            if (i9 <= 0) {
                z15 = z8;
                linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                obj = constraintAnchor6.mTarget;
                if (obj != null) {
                    linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                    if (z13) {
                        linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                    }
                    z15 = i6;
                } else if (this.mVisibility == i5) {
                    z15 = z8;
                    linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                    z15 = z8;
                }
            } else {
                z15 = z8;
                linearSystem2.addEquality(solverVariable7, solverVariable5, i9, i5);
                obj = constraintAnchor6.mTarget;
                if (obj != null) {
                    linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(obj), i6, i5);
                    if (z13) {
                        linearSystem2.addGreaterThan(solverVariableCreateObjectVariable, linearSystem2.createObjectVariable(constraintAnchor5), i6, 5);
                    }
                    z15 = i6;
                } else if (this.mVisibility == i5) {
                    z15 = z8;
                    linearSystem2.addEquality(solverVariable7, solverVariable5, i6, i5);
                    z15 = z8;
                }
            }
            z15 = z8;
            z15 = z8;
            solverVariable8 = solverVariable5;
            linearSystem2 = linearSystem;
            applyConstraints(linearSystem2, false, z13, z11, r24[i4], solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable, iArr4[i4], i8, this.mTop, this.mBottom, this.mY, i17, this.mMinHeight, iArr[i4], this.mVerticalBiasPercent, z14, z12, z3, z10, i2, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z15);
        } else {
            solverVariable8 = solverVariable5;
        }
        if (z5) {
            if (this.mResolvedDimensionRatioSide == 1) {
                float f10 = this.mResolvedDimensionRatio;
                ArrayRow arrayRowCreateRow17 = linearSystem2.createRow();
                arrayRowCreateRow17.variables.put(solverVariable6, -1.0f);
                arrayRowCreateRow17.variables.put(solverVariable8, 1.0f);
                arrayRowCreateRow17.variables.put(solverVariable3, f10);
                arrayRowCreateRow17.variables.put(solverVariable2, -f10);
                linearSystem2.addConstraint(arrayRowCreateRow17);
            } else {
                float f11 = this.mResolvedDimensionRatio;
                ArrayRow arrayRowCreateRow18 = linearSystem2.createRow();
                arrayRowCreateRow18.variables.put(solverVariable3, -1.0f);
                arrayRowCreateRow18.variables.put(solverVariable2, 1.0f);
                arrayRowCreateRow18.variables.put(solverVariable6, f11);
                arrayRowCreateRow18.variables.put(solverVariable8, -f11);
                linearSystem2.addConstraint(arrayRowCreateRow18);
            }
        }
        if (constraintAnchor.isConnected()) {
            ConstraintWidget constraintWidget16 = constraintAnchor.mTarget.mOwner;
            float radians5 = (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f);
            int margin5 = constraintAnchor.getMargin();
            SolverVariable solverVariableCreateObjectVariable11112 = linearSystem2.createObjectVariable(getAnchor(2));
            SolverVariable solverVariableCreateObjectVariable11113 = linearSystem2.createObjectVariable(getAnchor(3));
            SolverVariable solverVariableCreateObjectVariable11114 = linearSystem2.createObjectVariable(getAnchor(4));
            SolverVariable solverVariableCreateObjectVariable11115 = linearSystem2.createObjectVariable(getAnchor(5));
            SolverVariable solverVariableCreateObjectVariable11116 = linearSystem2.createObjectVariable(constraintWidget16.getAnchor(2));
            SolverVariable solverVariableCreateObjectVariable11117 = linearSystem2.createObjectVariable(constraintWidget16.getAnchor(3));
            SolverVariable solverVariableCreateObjectVariable11118 = linearSystem2.createObjectVariable(constraintWidget16.getAnchor(4));
            SolverVariable solverVariableCreateObjectVariable11119 = linearSystem2.createObjectVariable(constraintWidget16.getAnchor(5));
            ArrayRow arrayRowCreateRow19 = linearSystem2.createRow();
            double d9 = radians5;
            double dSin5 = Math.sin(d9);
            double d10 = margin5;
            arrayRowCreateRow19.variables.put(solverVariableCreateObjectVariable11117, 0.5f);
            arrayRowCreateRow19.variables.put(solverVariableCreateObjectVariable11119, 0.5f);
            arrayRowCreateRow19.variables.put(solverVariableCreateObjectVariable11113, -0.5f);
            arrayRowCreateRow19.variables.put(solverVariableCreateObjectVariable11115, -0.5f);
            arrayRowCreateRow19.constantValue = -((float) (dSin5 * d10));
            linearSystem2.addConstraint(arrayRowCreateRow19);
            ArrayRow arrayRowCreateRow110 = linearSystem2.createRow();
            float fCos5 = (float) (Math.cos(d9) * d10);
            arrayRowCreateRow110.variables.put(solverVariableCreateObjectVariable11116, 0.5f);
            arrayRowCreateRow110.variables.put(solverVariableCreateObjectVariable11118, 0.5f);
            arrayRowCreateRow110.variables.put(solverVariableCreateObjectVariable11112, -0.5f);
            arrayRowCreateRow110.variables.put(solverVariableCreateObjectVariable11114, -0.5f);
            arrayRowCreateRow110.constantValue = -fCos5;
            linearSystem2.addConstraint(arrayRowCreateRow110);
        }
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    /* JADX WARN: Code duplicated, block: B:170:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:172:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:174:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:176:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:180:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:181:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:189:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:198:0x0322  */
    /* JADX WARN: Code duplicated, block: B:200:0x032a  */
    /* JADX WARN: Code duplicated, block: B:211:0x033f  */
    /* JADX WARN: Code duplicated, block: B:216:0x0349  */
    /* JADX WARN: Code duplicated, block: B:218:0x034d  */
    /* JADX WARN: Code duplicated, block: B:219:0x034f  */
    /* JADX WARN: Code duplicated, block: B:222:0x0357  */
    /* JADX WARN: Code duplicated, block: B:228:0x0365 A[PHI: r4
      0x0365: PHI (r4v25 int) = (r4v24 int), (r4v29 int), (r4v29 int), (r4v29 int) binds: [B:221:0x0355, B:223:0x035b, B:224:0x035d, B:226:0x0361] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:231:0x0377 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:232:0x0379  */
    /* JADX WARN: Code duplicated, block: B:233:0x037e  */
    /* JADX WARN: Code duplicated, block: B:235:0x0381  */
    /* JADX WARN: Code duplicated, block: B:244:0x0399  */
    /* JADX WARN: Code duplicated, block: B:255:0x03b8 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:257:0x03c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:276:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:284:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x017b A[ADDED_TO_REGION] */
    public final void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, int i3, int i4, int i5, float f, boolean z6, boolean z7, boolean z8, boolean z9, int i6, int i7, int i8, int i9, float f2, boolean z10) {
        boolean z11;
        int iMin;
        int i10;
        int i11;
        boolean z12;
        SolverVariable solverVariableCreateObjectVariable;
        SolverVariable solverVariableCreateObjectVariable2;
        char c;
        boolean z13;
        ConstraintAnchor constraintAnchor3;
        SolverVariable solverVariable3;
        boolean z14;
        boolean z15;
        boolean z16;
        int i12;
        boolean z17;
        int i13;
        boolean z18;
        boolean z19;
        ConstraintWidget constraintWidget;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i14;
        int iMin2;
        int i15;
        boolean z20;
        int margin;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z21;
        boolean z22;
        int i22;
        LinearSystem linearSystem2 = linearSystem;
        int i23 = i8;
        int i24 = i9;
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem2.createObjectVariable(constraintAnchor);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem2.createObjectVariable(constraintAnchor2);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem2.createObjectVariable(constraintAnchor.mTarget);
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem2.createObjectVariable(constraintAnchor2.mTarget);
        boolean zIsConnected = constraintAnchor.isConnected();
        boolean zIsConnected2 = constraintAnchor2.isConnected();
        boolean zIsConnected3 = this.mCenter.isConnected();
        int i25 = zIsConnected2 ? (zIsConnected ? 1 : 0) + 1 : zIsConnected ? 1 : 0;
        if (zIsConnected3) {
            i25++;
        }
        int i26 = i25;
        int i27 = z6 ? 3 : i6;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        boolean z23 = (iOrdinal == 0 || iOrdinal == 1 || iOrdinal != 2 || i27 == 4) ? false : true;
        if (this.mVisibility == 8) {
            iMin = 0;
            z11 = false;
        } else {
            z11 = z23;
            iMin = i3;
        }
        if (z10) {
            if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                linearSystem2.addEquality(solverVariableCreateObjectVariable3, i2);
            } else if (zIsConnected && !zIsConnected2) {
                i10 = 8;
                linearSystem2.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
            }
            i10 = 8;
        } else {
            i10 = 8;
        }
        if (z11 != 0) {
            if (i26 == 2 || z6 || !(i27 == 1 || i27 == 0)) {
                if (i23 == -2) {
                    i23 = iMin;
                }
                if (i24 == -2) {
                    i24 = iMin;
                }
                if (iMin > 0 && i27 != 1) {
                    iMin = 0;
                }
                if (i23 > 0) {
                    linearSystem2.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i23, 8);
                    iMin = Math.max(iMin, i23);
                }
                if (i24 > 0) {
                    if (!z2 || i27 != 1) {
                        linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i24, 8);
                    }
                    iMin = Math.min(iMin, i24);
                }
                if (i27 == 1) {
                    if (z2) {
                        linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                    } else if (z7) {
                        linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                        linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                    } else {
                        linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                        linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                    }
                } else if (i27 == 2) {
                    int i28 = constraintAnchor.mType;
                    if (i28 == 3 || i28 == 5) {
                        solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(this.mParent.getAnchor(3));
                        solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(this.mParent.getAnchor(5));
                    } else {
                        solverVariableCreateObjectVariable = linearSystem2.createObjectVariable(this.mParent.getAnchor(2));
                        solverVariableCreateObjectVariable2 = linearSystem2.createObjectVariable(this.mParent.getAnchor(4));
                    }
                    ArrayRow arrayRowCreateRow = linearSystem2.createRow();
                    arrayRowCreateRow.variables.put(solverVariableCreateObjectVariable4, -1.0f);
                    arrayRowCreateRow.variables.put(solverVariableCreateObjectVariable3, 1.0f);
                    arrayRowCreateRow.variables.put(solverVariableCreateObjectVariable2, f2);
                    arrayRowCreateRow.variables.put(solverVariableCreateObjectVariable, -f2);
                    linearSystem2.addConstraint(arrayRowCreateRow);
                    i11 = i23;
                } else {
                    i11 = i23;
                    z12 = z11;
                    z4 = true;
                }
                if (z10 || z7) {
                    c = 2;
                    if (i26 >= c && z2 && z4) {
                        linearSystem2.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 8);
                        ConstraintAnchor constraintAnchor4 = this.mBaseline;
                        boolean z24 = z || constraintAnchor4.mTarget == null;
                        if (z || (constraintAnchor3 = constraintAnchor4.mTarget) == null) {
                            z13 = z24;
                        } else {
                            ConstraintWidget constraintWidget2 = constraintAnchor3.mOwner;
                            if (constraintWidget2.mDimensionRatio != 0.0f) {
                                int[] iArr = constraintWidget2.mListDimensionBehaviors;
                                if (iArr[0] == 3 && iArr[1] == 3) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                            } else {
                                z13 = false;
                            }
                        }
                        if (z13) {
                            linearSystem2.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, 0, 8);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ((zIsConnected || zIsConnected2 || zIsConnected3) && (!zIsConnected || zIsConnected2)) {
                    if (zIsConnected || !zIsConnected2) {
                        solverVariable3 = solverVariableCreateObjectVariable6;
                        if (zIsConnected && zIsConnected2) {
                            ConstraintWidget constraintWidget3 = constraintAnchor.mTarget.mOwner;
                            ConstraintWidget constraintWidget4 = constraintAnchor2.mTarget.mOwner;
                            z14 = z4;
                            ConstraintWidget constraintWidget5 = this.mParent;
                            int i29 = 6;
                            if (z12) {
                                if (i27 == 0) {
                                    if (i24 == 0 && i11 == 0) {
                                        i21 = 8;
                                        z21 = false;
                                        z22 = true;
                                        i22 = 8;
                                    } else {
                                        i21 = 5;
                                        z21 = true;
                                        z22 = false;
                                        i22 = 5;
                                    }
                                    if ((constraintWidget3 instanceof Barrier) || (constraintWidget4 instanceof Barrier)) {
                                        z16 = z21;
                                        i13 = i22;
                                        z15 = false;
                                        i27 = i27;
                                        i29 = 6;
                                        z17 = z22;
                                        i12 = 4;
                                    } else {
                                        i13 = i22;
                                        z15 = false;
                                        z17 = z22;
                                        i12 = i21;
                                        z16 = z21;
                                        i27 = i27;
                                        i29 = 6;
                                    }
                                } else {
                                    if (i27 == 1) {
                                        i27 = i27;
                                        i29 = 6;
                                        z15 = true;
                                        z16 = true;
                                        i12 = 4;
                                        z17 = false;
                                    } else if (i27 == 3) {
                                        i27 = i27;
                                        if (this.mResolvedDimensionRatioSide == -1) {
                                            if (z8) {
                                                i29 = z2 ? 5 : 4;
                                            } else {
                                                i29 = 8;
                                            }
                                            z15 = true;
                                            z16 = true;
                                            i12 = 5;
                                            z17 = true;
                                        } else {
                                            if (z6) {
                                                if (i7 == 2 || i7 == 1) {
                                                    i19 = 4;
                                                    i20 = 5;
                                                } else {
                                                    i19 = 5;
                                                    i20 = 8;
                                                }
                                                i12 = i19;
                                                i13 = i20;
                                                z15 = true;
                                                z16 = true;
                                            } else {
                                                if (i24 > 0) {
                                                    z15 = true;
                                                    z16 = true;
                                                    i12 = 5;
                                                } else if (i24 != 0 || i11 != 0) {
                                                    z15 = true;
                                                    z16 = true;
                                                    i12 = 4;
                                                } else if (z8) {
                                                    i13 = (constraintWidget3 == constraintWidget5 || constraintWidget4 == constraintWidget5) ? 5 : 4;
                                                    z15 = true;
                                                    z16 = true;
                                                    i12 = 4;
                                                } else {
                                                    z15 = true;
                                                    z16 = true;
                                                    i12 = 8;
                                                }
                                                z17 = true;
                                                i13 = 5;
                                            }
                                            z17 = true;
                                        }
                                    } else {
                                        z15 = false;
                                        z16 = false;
                                    }
                                    i13 = 8;
                                }
                                if (z15 || solverVariableCreateObjectVariable5 != solverVariable3 || constraintWidget3 == constraintWidget5) {
                                    z18 = z15;
                                    z19 = true;
                                } else {
                                    z18 = false;
                                    z19 = false;
                                }
                                if (z16) {
                                    if (this.mVisibility == 8) {
                                        i29 = 4;
                                    }
                                    solverVariable4 = solverVariableCreateObjectVariable3;
                                    solverVariable5 = solverVariableCreateObjectVariable4;
                                    int i30 = i29;
                                    solverVariable6 = solverVariableCreateObjectVariable5;
                                    i14 = 8;
                                    constraintWidget = constraintWidget3;
                                    linearSystem2 = linearSystem;
                                    linearSystem2.addCentering(solverVariable4, solverVariable6, constraintAnchor.getMargin(), f, solverVariable3, solverVariable5, constraintAnchor2.getMargin(), i30);
                                } else {
                                    constraintWidget = constraintWidget3;
                                    solverVariable4 = solverVariableCreateObjectVariable3;
                                    solverVariable5 = solverVariableCreateObjectVariable4;
                                    solverVariable6 = solverVariableCreateObjectVariable5;
                                    i14 = 8;
                                    linearSystem2 = linearSystem;
                                }
                                if (this.mVisibility == i14) {
                                    return;
                                }
                                if (z18) {
                                    if (z2 || solverVariable6 == solverVariable3 || z12 || !((constraintWidget instanceof Barrier) || (constraintWidget4 instanceof Barrier))) {
                                        i18 = i13;
                                    } else {
                                        i18 = 6;
                                    }
                                    linearSystem2.addGreaterThan(solverVariable4, solverVariable6, constraintAnchor.getMargin(), i18);
                                    linearSystem2.addLowerThan(solverVariable5, solverVariable3, -constraintAnchor2.getMargin(), i18);
                                    i13 = i18;
                                }
                                if (z2 || !z9 || (constraintWidget instanceof Barrier) || (constraintWidget4 instanceof Barrier)) {
                                    iMin2 = i12;
                                    i15 = i13;
                                    z20 = z19;
                                } else {
                                    iMin2 = 6;
                                    i15 = 6;
                                    z20 = true;
                                }
                                if (z20) {
                                    if (z17 && (!z8 || z3)) {
                                        if (constraintWidget != constraintWidget5 && constraintWidget4 != constraintWidget5) {
                                            i29 = iMin2;
                                        }
                                        if ((constraintWidget instanceof Guideline) || (constraintWidget4 instanceof Guideline)) {
                                            i29 = 5;
                                        }
                                        if ((constraintWidget instanceof Barrier) || (constraintWidget4 instanceof Barrier)) {
                                            i29 = 5;
                                        }
                                        if (z8) {
                                            i17 = 5;
                                        } else {
                                            i17 = i29;
                                        }
                                        iMin2 = Math.max(i17, iMin2);
                                    }
                                    if (z2) {
                                        iMin2 = Math.min(i15, iMin2);
                                        if (z6 || z8 || !(constraintWidget == constraintWidget5 || constraintWidget4 == constraintWidget5)) {
                                            i16 = iMin2;
                                        } else {
                                            i16 = 4;
                                        }
                                    } else {
                                        i16 = iMin2;
                                    }
                                    linearSystem2.addEquality(solverVariable4, solverVariable6, constraintAnchor.getMargin(), i16);
                                    linearSystem2.addEquality(solverVariable5, solverVariable3, -constraintAnchor2.getMargin(), i16);
                                }
                                if (z2) {
                                    if (solverVariable == solverVariable6) {
                                        margin = constraintAnchor.getMargin();
                                    } else {
                                        margin = 0;
                                    }
                                    if (solverVariable6 != solverVariable) {
                                        linearSystem2.addGreaterThan(solverVariable4, solverVariable, margin, 5);
                                    }
                                }
                                if (z2 && z12 != 0 && i4 == 0 && i11 == 0) {
                                    if (z12 == 0 && i27 == 3) {
                                        linearSystem2.addGreaterThan(solverVariable5, solverVariable4, 0, 8);
                                    } else {
                                        linearSystem2.addGreaterThan(solverVariable5, solverVariable4, 0, 5);
                                    }
                                }
                            } else {
                                z15 = true;
                                z16 = true;
                            }
                            i12 = 4;
                            z17 = false;
                            i13 = 5;
                            if (z15) {
                                z18 = z15;
                                z19 = true;
                            } else {
                                z18 = z15;
                                z19 = true;
                            }
                            if (z16) {
                                if (this.mVisibility == 8) {
                                    i29 = 4;
                                }
                                solverVariable4 = solverVariableCreateObjectVariable3;
                                solverVariable5 = solverVariableCreateObjectVariable4;
                                int i31 = i29;
                                solverVariable6 = solverVariableCreateObjectVariable5;
                                i14 = 8;
                                constraintWidget = constraintWidget3;
                                linearSystem2 = linearSystem;
                                linearSystem2.addCentering(solverVariable4, solverVariable6, constraintAnchor.getMargin(), f, solverVariable3, solverVariable5, constraintAnchor2.getMargin(), i31);
                            } else {
                                constraintWidget = constraintWidget3;
                                solverVariable4 = solverVariableCreateObjectVariable3;
                                solverVariable5 = solverVariableCreateObjectVariable4;
                                solverVariable6 = solverVariableCreateObjectVariable5;
                                i14 = 8;
                                linearSystem2 = linearSystem;
                            }
                            if (this.mVisibility == i14) {
                                return;
                            }
                            if (z18) {
                                if (z2) {
                                    i18 = i13;
                                } else {
                                    i18 = i13;
                                }
                                linearSystem2.addGreaterThan(solverVariable4, solverVariable6, constraintAnchor.getMargin(), i18);
                                linearSystem2.addLowerThan(solverVariable5, solverVariable3, -constraintAnchor2.getMargin(), i18);
                                i13 = i18;
                            }
                            if (z2) {
                                iMin2 = i12;
                                i15 = i13;
                                z20 = z19;
                            } else {
                                iMin2 = i12;
                                i15 = i13;
                                z20 = z19;
                            }
                            if (z20) {
                                if (z17) {
                                    if (constraintWidget != constraintWidget5) {
                                        i29 = iMin2;
                                    }
                                    if (constraintWidget instanceof Guideline) {
                                        i29 = 5;
                                    } else {
                                        i29 = 5;
                                    }
                                    if (constraintWidget instanceof Barrier) {
                                        i29 = 5;
                                    } else {
                                        i29 = 5;
                                    }
                                    if (z8) {
                                        i17 = 5;
                                    } else {
                                        i17 = i29;
                                    }
                                    iMin2 = Math.max(i17, iMin2);
                                }
                                if (z2) {
                                    iMin2 = Math.min(i15, iMin2);
                                    if (z6) {
                                        i16 = iMin2;
                                    } else {
                                        i16 = iMin2;
                                    }
                                } else {
                                    i16 = iMin2;
                                }
                                linearSystem2.addEquality(solverVariable4, solverVariable6, constraintAnchor.getMargin(), i16);
                                linearSystem2.addEquality(solverVariable5, solverVariable3, -constraintAnchor2.getMargin(), i16);
                            }
                            if (z2) {
                                if (solverVariable == solverVariable6) {
                                    margin = constraintAnchor.getMargin();
                                } else {
                                    margin = 0;
                                }
                                if (solverVariable6 != solverVariable) {
                                    linearSystem2.addGreaterThan(solverVariable4, solverVariable, margin, 5);
                                }
                            }
                            if (z2) {
                                if (z12 == 0) {
                                    linearSystem2.addGreaterThan(solverVariable5, solverVariable4, 0, 5);
                                } else {
                                    linearSystem2.addGreaterThan(solverVariable5, solverVariable4, 0, 5);
                                }
                            }
                        }
                    } else {
                        solverVariable3 = solverVariableCreateObjectVariable6;
                        linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariable3, -constraintAnchor2.getMargin(), 8);
                        if (z2) {
                            linearSystem2.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 5);
                        }
                    }
                    solverVariable5 = solverVariableCreateObjectVariable4;
                    z14 = z4;
                } else {
                    solverVariable5 = solverVariableCreateObjectVariable4;
                    z14 = z4;
                    solverVariable3 = solverVariableCreateObjectVariable6;
                }
                if (z2 && z14) {
                    int margin2 = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
                    if (solverVariable3 != solverVariable2) {
                        linearSystem2.addGreaterThan(solverVariable2, solverVariable5, margin2, 5);
                        return;
                    }
                    return;
                }
                return;
            }
            int iMax = Math.max(i23, iMin);
            if (i24 > 0) {
                iMax = Math.min(i24, iMax);
            }
            linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMax, 8);
            i11 = i23;
            z12 = false;
            if (z10) {
                c = 2;
            } else {
                c = 2;
            }
            if (i26 >= c) {
            }
        }
        if (z5) {
            linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 3);
            if (i4 > 0) {
                linearSystem2.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i4, i10);
            }
            if (i5 < Integer.MAX_VALUE) {
                linearSystem2.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i5, i10);
            }
        } else {
            linearSystem2.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, i10);
        }
        z4 = z4;
        z12 = z11;
        i11 = i23;
        if (z10) {
            c = 2;
        } else {
            c = 2;
        }
        if (i26 >= c) {
        }
    }

    public final void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public ConstraintAnchor getAnchor(int i) {
        switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) {
            case 0:
                return null;
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            default:
                throw new AssertionError(Density.CC.name(i));
        }
    }

    public final int getDimensionBehaviour(int i) {
        int[] iArr = this.mListDimensionBehaviors;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public final ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public final ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public final int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public final int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mX : ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public final int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mY : ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public final void immediateConnect(int i, int i2, int i3, int i4, ConstraintWidget constraintWidget) {
        getAnchor(i).connect(constraintWidget.getAnchor(i2), i3, i4);
    }

    public final boolean isChainHead(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return (constraintAnchor4 == null || constraintAnchor4.mTarget == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i2 + 1]).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) ? false : true;
    }

    public final boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public final boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        int[] iArr = this.mListDimensionBehaviors;
        iArr[0] = 1;
        iArr[1] = 1;
        this.mCompanionWidget = null;
        this.mVisibility = 0;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr2 = this.mMaxDimension;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void resetSolverVariables(Dispatcher dispatcher) {
        this.mLeft.resetSolverVariable();
        this.mTop.resetSolverVariable();
        this.mRight.resetSolverVariable();
        this.mBottom.resetSolverVariable();
        this.mBaseline.resetSolverVariable();
        this.mCenter.resetSolverVariable();
        this.mCenterX.resetSolverVariable();
        this.mCenterY.resetSolverVariable();
    }

    public final void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public final void setHorizontalDimensionBehaviour(int i) {
        this.mListDimensionBehaviors[0] = i;
    }

    public final void setVerticalDimensionBehaviour(int i) {
        this.mListDimensionBehaviors[1] = i;
    }

    public final void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.mDebugName != null ? ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("id: "), this.mDebugName, " ") : "");
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.mHeight, ")");
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        boolean z3 = z & horizontalWidgetRun.resolved;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        boolean z4 = z2 & verticalWidgetRun.resolved;
        int i3 = horizontalWidgetRun.start.value;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.mX = i3;
        }
        if (z4) {
            this.mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        int[] iArr = this.mListDimensionBehaviors;
        if (z3) {
            if (iArr[0] == 1 && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (z4) {
            if (iArr[1] == 1 && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int i;
        int i2;
        linearSystem.getClass();
        int objectVariableValue = LinearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = LinearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = LinearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = LinearSystem.getObjectVariableValue(this.mBottom);
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        DependencyNode dependencyNode = horizontalWidgetRun.start;
        if (dependencyNode.resolved) {
            DependencyNode dependencyNode2 = horizontalWidgetRun.end;
            if (dependencyNode2.resolved) {
                objectVariableValue = dependencyNode.value;
                objectVariableValue3 = dependencyNode2.value;
            }
        }
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        DependencyNode dependencyNode3 = verticalWidgetRun.start;
        if (dependencyNode3.resolved) {
            DependencyNode dependencyNode4 = verticalWidgetRun.end;
            if (dependencyNode4.resolved) {
                objectVariableValue2 = dependencyNode3.value;
                objectVariableValue4 = dependencyNode4.value;
            }
        }
        int i3 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i3 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
            objectVariableValue4 = 0;
        }
        int i4 = objectVariableValue3 - objectVariableValue;
        int i5 = objectVariableValue4 - objectVariableValue2;
        this.mX = objectVariableValue;
        this.mY = objectVariableValue2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        int[] iArr = this.mListDimensionBehaviors;
        if (iArr[0] == 1 && i4 < (i2 = this.mWidth)) {
            i4 = i2;
        }
        if (iArr[1] == 1 && i5 < (i = this.mHeight)) {
            i5 = i;
        }
        this.mWidth = i4;
        this.mHeight = i5;
        int i6 = this.mMinHeight;
        if (i5 < i6) {
            this.mHeight = i6;
        }
        int i7 = this.mMinWidth;
        if (i4 < i7) {
            this.mWidth = i7;
        }
    }
}
