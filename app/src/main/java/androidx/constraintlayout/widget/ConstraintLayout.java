package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.core.view.MenuHostHelper;
import coil.request.RequestService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import okhttp3.internal.http2.Huffman;
import okio.FileMetadata;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public final SparseArray mChildrenByIds;
    public final ArrayList mConstraintHelpers;
    public RequestService mConstraintLayoutSpec;
    public ConstraintSet mConstraintSet;
    public int mConstraintSetId;
    public HashMap mDesignIds;
    public boolean mDirtyHierarchy;
    public final ConstraintWidgetContainer mLayoutWidget;
    public int mMaxHeight;
    public int mMaxWidth;
    public final Measurer mMeasurer;
    public int mMinHeight;
    public int mMinWidth;
    public int mOptimizationLevel;
    public final SparseArray mTempMapIdToWidget;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int baselineToBaseline;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        public int dimensionRatioSide;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public boolean horizontalDimensionFixed;
        public float horizontalWeight;
        public boolean isGuideline;
        public boolean isHelper;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        public boolean needsBaseline;
        public int orientation;
        public int resolveGoneLeftMargin;
        public int resolveGoneRightMargin;
        public int resolvedGuideBegin;
        public int resolvedGuideEnd;
        public float resolvedGuidePercent;
        public float resolvedHorizontalBias;
        public int resolvedLeftToLeft;
        public int resolvedLeftToRight;
        public int resolvedRightToLeft;
        public int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public boolean verticalDimensionFixed;
        public float verticalWeight;
        public ConstraintWidget widget;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public abstract class Table {
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(63, 8);
                sparseIntArray.append(64, 9);
                sparseIntArray.append(66, 10);
                sparseIntArray.append(67, 11);
                sparseIntArray.append(73, 12);
                sparseIntArray.append(72, 13);
                sparseIntArray.append(45, 14);
                sparseIntArray.append(44, 15);
                sparseIntArray.append(42, 16);
                sparseIntArray.append(46, 2);
                sparseIntArray.append(48, 3);
                sparseIntArray.append(47, 4);
                sparseIntArray.append(81, 49);
                sparseIntArray.append(82, 50);
                sparseIntArray.append(52, 5);
                sparseIntArray.append(53, 6);
                sparseIntArray.append(54, 7);
                sparseIntArray.append(0, 1);
                sparseIntArray.append(68, 17);
                sparseIntArray.append(69, 18);
                sparseIntArray.append(51, 19);
                sparseIntArray.append(50, 20);
                sparseIntArray.append(85, 21);
                sparseIntArray.append(88, 22);
                sparseIntArray.append(86, 23);
                sparseIntArray.append(83, 24);
                sparseIntArray.append(87, 25);
                sparseIntArray.append(84, 26);
                sparseIntArray.append(59, 29);
                sparseIntArray.append(74, 30);
                sparseIntArray.append(49, 44);
                sparseIntArray.append(61, 45);
                sparseIntArray.append(76, 46);
                sparseIntArray.append(60, 47);
                sparseIntArray.append(75, 48);
                sparseIntArray.append(40, 27);
                sparseIntArray.append(39, 28);
                sparseIntArray.append(77, 31);
                sparseIntArray.append(55, 32);
                sparseIntArray.append(79, 33);
                sparseIntArray.append(78, 34);
                sparseIntArray.append(80, 35);
                sparseIntArray.append(57, 36);
                sparseIntArray.append(56, 37);
                sparseIntArray.append(58, 38);
                sparseIntArray.append(62, 39);
                sparseIntArray.append(71, 40);
                sparseIntArray.append(65, 41);
                sparseIntArray.append(43, 42);
                sparseIntArray.append(41, 43);
                sparseIntArray.append(70, 51);
            }
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0048  */
        /* JADX WARN: Code duplicated, block: B:20:0x004f  */
        /* JADX WARN: Code duplicated, block: B:23:0x0056  */
        /* JADX WARN: Code duplicated, block: B:26:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x0062  */
        /* JADX WARN: Code duplicated, block: B:36:0x0074  */
        /* JADX WARN: Code duplicated, block: B:37:0x007c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:38:0x007e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0085 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:40:0x0087  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public final void resolveLayoutDirection(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i7 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i);
            boolean z = false;
            boolean z2 = 1 == getLayoutDirection();
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float f = this.horizontalBias;
            this.resolvedHorizontalBias = f;
            int i8 = this.guideBegin;
            this.resolvedGuideBegin = i8;
            int i9 = this.guideEnd;
            this.resolvedGuideEnd = i9;
            float f2 = this.guidePercent;
            this.resolvedGuidePercent = f2;
            if (z2) {
                int i10 = this.startToEnd;
                if (i10 != -1) {
                    this.resolvedRightToLeft = i10;
                } else {
                    int i11 = this.startToStart;
                    if (i11 != -1) {
                        this.resolvedRightToRight = i11;
                    } else {
                        i2 = this.endToStart;
                        if (i2 != -1) {
                            this.resolvedLeftToRight = i2;
                            z = true;
                        }
                        i3 = this.endToEnd;
                        if (i3 != -1) {
                            this.resolvedLeftToLeft = i3;
                            z = true;
                        }
                        i4 = this.goneStartMargin;
                        if (i4 != -1) {
                            this.resolveGoneRightMargin = i4;
                        }
                        i5 = this.goneEndMargin;
                        if (i5 != -1) {
                            this.resolveGoneLeftMargin = i5;
                        }
                        if (z) {
                            this.resolvedHorizontalBias = 1.0f - f;
                        }
                        if (this.isGuideline && this.orientation == 1) {
                            if (f2 != -1.0f) {
                                this.resolvedGuidePercent = 1.0f - f2;
                                this.resolvedGuideBegin = -1;
                                this.resolvedGuideEnd = -1;
                            } else if (i8 != -1) {
                                this.resolvedGuideEnd = i8;
                                this.resolvedGuideBegin = -1;
                                this.resolvedGuidePercent = -1.0f;
                            } else if (i9 != -1) {
                                this.resolvedGuideBegin = i9;
                                this.resolvedGuideEnd = -1;
                                this.resolvedGuidePercent = -1.0f;
                            }
                        }
                    }
                }
                z = true;
                i2 = this.endToStart;
                if (i2 != -1) {
                    this.resolvedLeftToRight = i2;
                    z = true;
                }
                i3 = this.endToEnd;
                if (i3 != -1) {
                    this.resolvedLeftToLeft = i3;
                    z = true;
                }
                i4 = this.goneStartMargin;
                if (i4 != -1) {
                    this.resolveGoneRightMargin = i4;
                }
                i5 = this.goneEndMargin;
                if (i5 != -1) {
                    this.resolveGoneLeftMargin = i5;
                }
                if (z) {
                    this.resolvedHorizontalBias = 1.0f - f;
                }
                if (this.isGuideline) {
                    if (f2 != -1.0f) {
                        this.resolvedGuidePercent = 1.0f - f2;
                        this.resolvedGuideBegin = -1;
                        this.resolvedGuideEnd = -1;
                    } else if (i8 != -1) {
                        this.resolvedGuideEnd = i8;
                        this.resolvedGuideBegin = -1;
                        this.resolvedGuidePercent = -1.0f;
                    } else if (i9 != -1) {
                        this.resolvedGuideBegin = i9;
                        this.resolvedGuideEnd = -1;
                        this.resolvedGuidePercent = -1.0f;
                    }
                }
            } else {
                int i12 = this.startToEnd;
                if (i12 != -1) {
                    this.resolvedLeftToRight = i12;
                }
                int i13 = this.startToStart;
                if (i13 != -1) {
                    this.resolvedLeftToLeft = i13;
                }
                int i14 = this.endToStart;
                if (i14 != -1) {
                    this.resolvedRightToLeft = i14;
                }
                int i15 = this.endToEnd;
                if (i15 != -1) {
                    this.resolvedRightToRight = i15;
                }
                int i16 = this.goneStartMargin;
                if (i16 != -1) {
                    this.resolveGoneLeftMargin = i16;
                }
                int i17 = this.goneEndMargin;
                if (i17 != -1) {
                    this.resolveGoneRightMargin = i17;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                int i18 = this.rightToLeft;
                if (i18 != -1) {
                    this.resolvedRightToLeft = i18;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                    }
                } else {
                    int i19 = this.rightToRight;
                    if (i19 != -1) {
                        this.resolvedRightToRight = i19;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                        }
                    }
                }
                int i20 = this.leftToLeft;
                if (i20 != -1) {
                    this.resolvedLeftToLeft = i20;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                    return;
                }
                int i21 = this.leftToRight;
                if (i21 != -1) {
                    this.resolvedLeftToRight = i21;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                }
            }
        }

        public final void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.horizontalDimensionFixed = false;
                if (i == 0 && this.matchConstraintDefaultWidth == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.verticalDimensionFixed = false;
                if (i2 == 0 && this.matchConstraintDefaultHeight == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent == -1.0f && this.guideBegin == -1 && this.guideEnd == -1) {
                return;
            }
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (!(this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
            }
            ((androidx.constraintlayout.solver.widgets.Guideline) this.widget).setOrientation(this.orientation);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Measurer {
        public final ConstraintLayout layout;
        public int layoutHeightSpec;
        public int layoutWidthSpec;
        public int paddingBottom;
        public int paddingHeight;
        public int paddingTop;
        public int paddingWidth;

        public Measurer(ConstraintLayout constraintLayout) {
            this.layout = constraintLayout;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0175  */
        /* JADX WARN: Code duplicated, block: B:104:0x017d  */
        /* JADX WARN: Code duplicated, block: B:106:0x0181  */
        /* JADX WARN: Code duplicated, block: B:109:0x018b  */
        /* JADX WARN: Code duplicated, block: B:112:0x019b A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:121:0x01af  */
        /* JADX WARN: Code duplicated, block: B:123:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:124:0x01c7  */
        /* JADX WARN: Code duplicated, block: B:126:0x01cf  */
        /* JADX WARN: Code duplicated, block: B:127:0x01d6  */
        /* JADX WARN: Code duplicated, block: B:130:0x01e0  */
        /* JADX WARN: Code duplicated, block: B:131:0x01e5  */
        /* JADX WARN: Code duplicated, block: B:134:0x01ea  */
        /* JADX WARN: Code duplicated, block: B:137:0x01f2  */
        /* JADX WARN: Code duplicated, block: B:138:0x01f7  */
        /* JADX WARN: Code duplicated, block: B:141:0x01fc  */
        /* JADX WARN: Code duplicated, block: B:144:0x0204 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:146:0x020d A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:147:0x020f A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:150:0x0219 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:151:0x021b  */
        /* JADX WARN: Code duplicated, block: B:153:0x021f  */
        /* JADX WARN: Code duplicated, block: B:155:0x0225  */
        /* JADX WARN: Code duplicated, block: B:158:0x023c  */
        /* JADX WARN: Code duplicated, block: B:159:0x023f  */
        /* JADX WARN: Code duplicated, block: B:162:0x0245  */
        /* JADX WARN: Code duplicated, block: B:166:0x024d  */
        /* JADX WARN: Code duplicated, block: B:169:0x0255  */
        /* JADX WARN: Code duplicated, block: B:171:0x0259  */
        /* JADX WARN: Code duplicated, block: B:46:0x00c4 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:47:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:49:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:51:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:52:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:54:0x00d7  */
        /* JADX WARN: Code duplicated, block: B:55:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:57:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:59:0x00f5  */
        /* JADX WARN: Code duplicated, block: B:61:0x0102  */
        /* JADX WARN: Code duplicated, block: B:62:0x0104  */
        /* JADX WARN: Code duplicated, block: B:65:0x010c  */
        /* JADX WARN: Code duplicated, block: B:66:0x010e  */
        /* JADX WARN: Code duplicated, block: B:72:0x011f  */
        /* JADX WARN: Code duplicated, block: B:74:0x0123 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:76:0x0126  */
        /* JADX WARN: Code duplicated, block: B:80:0x0139  */
        /* JADX WARN: Code duplicated, block: B:81:0x0148  */
        /* JADX WARN: Code duplicated, block: B:83:0x0155  */
        /* JADX WARN: Code duplicated, block: B:84:0x0157  */
        /* JADX WARN: Code duplicated, block: B:86:0x015b  */
        /* JADX WARN: Code duplicated, block: B:87:0x015d  */
        /* JADX WARN: Code duplicated, block: B:90:0x0162 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:93:0x0168  */
        /* JADX WARN: Code duplicated, block: B:95:0x016b A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:98:0x0171  */
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure$Measure basicMeasure$Measure) {
            int iMakeMeasureSpec;
            boolean z;
            int iOrdinal;
            int i;
            int iMakeMeasureSpec2;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            LayoutParams layoutParams;
            int measuredWidth;
            int measuredHeight;
            int baseline;
            int i2;
            int measuredWidth2;
            int i3;
            int i4;
            int measuredHeight2;
            int i5;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            int i6;
            int childMeasureSpec;
            ConstraintAnchor constraintAnchor = constraintWidget.mRight;
            ConstraintAnchor constraintAnchor2 = constraintWidget.mLeft;
            int[] iArr = constraintWidget.wrapMeasure;
            if (constraintWidget.mVisibility == 8) {
                basicMeasure$Measure.measuredWidth = 0;
                basicMeasure$Measure.measuredHeight = 0;
                basicMeasure$Measure.measuredBaseline = 0;
                return;
            }
            int i7 = basicMeasure$Measure.horizontalBehavior;
            int i8 = basicMeasure$Measure.verticalBehavior;
            int i9 = basicMeasure$Measure.horizontalDimension;
            int i10 = basicMeasure$Measure.verticalDimension;
            int i11 = this.paddingTop + this.paddingBottom;
            int i12 = this.paddingWidth;
            View view = constraintWidget.mCompanionWidget;
            int iOrdinal2 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i7);
            int i13 = 2;
            if (iOrdinal2 != 0) {
                if (iOrdinal2 == 1) {
                    i13 = 2;
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i12, -2);
                    iArr[2] = -2;
                } else {
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 != 3) {
                            i13 = 2;
                            z = false;
                            iMakeMeasureSpec = 0;
                        } else {
                            int i14 = this.layoutWidthSpec;
                            int i15 = constraintAnchor2 != null ? constraintAnchor2.mMargin : 0;
                            if (constraintAnchor != null) {
                                i15 += constraintAnchor.mMargin;
                            }
                            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i14, i12 + i15, -1);
                            iArr[i13] = -1;
                        }
                        iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i8);
                        if (iOrdinal == 0) {
                            i = 3;
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                            iArr[3] = i10;
                            z2 = false;
                        } else if (iOrdinal == 1) {
                            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i11, -2);
                            i = 3;
                            iArr[3] = -2;
                            iMakeMeasureSpec2 = childMeasureSpec2;
                            z2 = true;
                        } else if (iOrdinal == i13) {
                            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i11, -2);
                            if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            iArr[3] = 0;
                            if (basicMeasure$Measure.useCurrentDimensions) {
                                if (z11 || iArr[2] == 0 || iArr[1] == constraintWidget.getHeight()) {
                                    z12 = false;
                                } else {
                                    z12 = true;
                                }
                                if (z11 || z12) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                            } else {
                                z2 = true;
                            }
                            i = 3;
                        } else if (iOrdinal != 3) {
                            i = 3;
                            z2 = false;
                            iMakeMeasureSpec2 = 0;
                        } else {
                            int i16 = this.layoutHeightSpec;
                            if (constraintAnchor2 != null) {
                                i6 = constraintWidget.mTop.mMargin;
                            } else {
                                i6 = 0;
                            }
                            if (constraintAnchor != null) {
                                i6 += constraintWidget.mBottom.mMargin;
                            }
                            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i16, i11 + i6, -1);
                            iArr[3] = -1;
                            z2 = false;
                            i = 3;
                        }
                        if (i7 == i) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (i8 == i) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (i8 != 4 || i8 == 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (i7 != 4 || i7 == 1) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z3 || constraintWidget.mDimensionRatio <= 0.0f) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (z4 || constraintWidget.mDimensionRatio <= 0.0f) {
                            z8 = false;
                        } else {
                            z8 = true;
                        }
                        layoutParams = (LayoutParams) view.getLayoutParams();
                        if (basicMeasure$Measure.useCurrentDimensions && z3 && constraintWidget.mMatchConstraintDefaultWidth == 0 && z4 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                            measuredWidth2 = 0;
                            measuredHeight2 = 0;
                            baseline = 0;
                        } else {
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                            if (z) {
                                iArr[0] = measuredWidth;
                                iArr[2] = measuredHeight;
                            } else {
                                iArr[0] = 0;
                                iArr[2] = 0;
                            }
                            if (z2) {
                                iArr[1] = measuredHeight;
                                iArr[3] = measuredWidth;
                            } else {
                                iArr[1] = 0;
                                iArr[3] = 0;
                            }
                            i2 = constraintWidget.mMatchConstraintMinWidth;
                            if (i2 > 0) {
                                measuredWidth2 = Math.max(i2, measuredWidth);
                            } else {
                                measuredWidth2 = measuredWidth;
                            }
                            i3 = constraintWidget.mMatchConstraintMaxWidth;
                            if (i3 > 0) {
                                measuredWidth2 = Math.min(i3, measuredWidth2);
                            }
                            i4 = constraintWidget.mMatchConstraintMinHeight;
                            if (i4 > 0) {
                                measuredHeight2 = Math.max(i4, measuredHeight);
                            } else {
                                measuredHeight2 = measuredHeight;
                            }
                            i5 = constraintWidget.mMatchConstraintMaxHeight;
                            if (i5 > 0) {
                                measuredHeight2 = Math.min(i5, measuredHeight2);
                            }
                            if (!z7 && z5) {
                                measuredWidth2 = (int) ((measuredHeight2 * constraintWidget.mDimensionRatio) + 0.5f);
                            } else if (z8 && z6) {
                                measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                            }
                            if (measuredWidth == measuredWidth2 || measuredHeight != measuredHeight2) {
                                if (measuredWidth != measuredWidth2) {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                                }
                                if (measuredHeight != measuredHeight2) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                                }
                                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                measuredWidth2 = view.getMeasuredWidth();
                                measuredHeight2 = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                            }
                        }
                        if (baseline != -1) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (measuredWidth2 == basicMeasure$Measure.horizontalDimension || measuredHeight2 != basicMeasure$Measure.verticalDimension) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        basicMeasure$Measure.measuredNeedsSolverPass = z10;
                        if (layoutParams.needsBaseline) {
                            z9 = true;
                        }
                        if (z9 && baseline != -1 && constraintWidget.mBaselineDistance != baseline) {
                            basicMeasure$Measure.measuredNeedsSolverPass = true;
                        }
                        basicMeasure$Measure.measuredWidth = measuredWidth2;
                        basicMeasure$Measure.measuredHeight = measuredHeight2;
                        basicMeasure$Measure.measuredHasBaseline = z9;
                        basicMeasure$Measure.measuredBaseline = baseline;
                    }
                    i13 = 2;
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i12, -2);
                    boolean z13 = constraintWidget.mMatchConstraintDefaultWidth == 1;
                    iArr[2] = 0;
                    if (basicMeasure$Measure.useCurrentDimensions) {
                        boolean z14 = (!z13 || iArr[3] == 0 || iArr[0] == constraintWidget.getWidth()) ? false : true;
                        if (!z13 || z14) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                        }
                    }
                }
                iMakeMeasureSpec = childMeasureSpec;
                z = true;
                iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i8);
                if (iOrdinal == 0) {
                    i = 3;
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                    iArr[3] = i10;
                    z2 = false;
                } else if (iOrdinal == 1) {
                    int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i11, -2);
                    i = 3;
                    iArr[3] = -2;
                    iMakeMeasureSpec2 = childMeasureSpec3;
                    z2 = true;
                } else if (iOrdinal == i13) {
                    iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i11, -2);
                    if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    iArr[3] = 0;
                    if (basicMeasure$Measure.useCurrentDimensions) {
                        z2 = true;
                    } else {
                        if (z11) {
                            z12 = false;
                        } else {
                            z12 = false;
                        }
                        if (z11) {
                        }
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                        z2 = false;
                    }
                    i = 3;
                } else if (iOrdinal != 3) {
                    i = 3;
                    z2 = false;
                    iMakeMeasureSpec2 = 0;
                } else {
                    int i17 = this.layoutHeightSpec;
                    if (constraintAnchor2 != null) {
                        i6 = constraintWidget.mTop.mMargin;
                    } else {
                        i6 = 0;
                    }
                    if (constraintAnchor != null) {
                        i6 += constraintWidget.mBottom.mMargin;
                    }
                    iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i17, i11 + i6, -1);
                    iArr[3] = -1;
                    z2 = false;
                    i = 3;
                }
                if (i7 == i) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (i8 == i) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (i8 != 4) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (i7 != 4) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (z3) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                if (z4) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                layoutParams = (LayoutParams) view.getLayoutParams();
                if (basicMeasure$Measure.useCurrentDimensions) {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    if (z) {
                        iArr[0] = measuredWidth;
                        iArr[2] = measuredHeight;
                    } else {
                        iArr[0] = 0;
                        iArr[2] = 0;
                    }
                    if (z2) {
                        iArr[1] = measuredHeight;
                        iArr[3] = measuredWidth;
                    } else {
                        iArr[1] = 0;
                        iArr[3] = 0;
                    }
                    i2 = constraintWidget.mMatchConstraintMinWidth;
                    if (i2 > 0) {
                        measuredWidth2 = Math.max(i2, measuredWidth);
                    } else {
                        measuredWidth2 = measuredWidth;
                    }
                    i3 = constraintWidget.mMatchConstraintMaxWidth;
                    if (i3 > 0) {
                        measuredWidth2 = Math.min(i3, measuredWidth2);
                    }
                    i4 = constraintWidget.mMatchConstraintMinHeight;
                    if (i4 > 0) {
                        measuredHeight2 = Math.max(i4, measuredHeight);
                    } else {
                        measuredHeight2 = measuredHeight;
                    }
                    i5 = constraintWidget.mMatchConstraintMaxHeight;
                    if (i5 > 0) {
                        measuredHeight2 = Math.min(i5, measuredHeight2);
                    }
                    if (!z7) {
                        if (z8) {
                            measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                        }
                    } else if (z8) {
                        measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                    }
                    if (measuredWidth == measuredWidth2) {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    if (z) {
                        iArr[0] = measuredWidth;
                        iArr[2] = measuredHeight;
                    } else {
                        iArr[0] = 0;
                        iArr[2] = 0;
                    }
                    if (z2) {
                        iArr[1] = measuredHeight;
                        iArr[3] = measuredWidth;
                    } else {
                        iArr[1] = 0;
                        iArr[3] = 0;
                    }
                    i2 = constraintWidget.mMatchConstraintMinWidth;
                    if (i2 > 0) {
                        measuredWidth2 = Math.max(i2, measuredWidth);
                    } else {
                        measuredWidth2 = measuredWidth;
                    }
                    i3 = constraintWidget.mMatchConstraintMaxWidth;
                    if (i3 > 0) {
                        measuredWidth2 = Math.min(i3, measuredWidth2);
                    }
                    i4 = constraintWidget.mMatchConstraintMinHeight;
                    if (i4 > 0) {
                        measuredHeight2 = Math.max(i4, measuredHeight);
                    } else {
                        measuredHeight2 = measuredHeight;
                    }
                    i5 = constraintWidget.mMatchConstraintMaxHeight;
                    if (i5 > 0) {
                        measuredHeight2 = Math.min(i5, measuredHeight2);
                    }
                    if (!z7) {
                        if (z8) {
                            measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                        }
                    } else if (z8) {
                        measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                    }
                    if (measuredWidth == measuredWidth2) {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    } else {
                        if (measuredWidth != measuredWidth2) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                        }
                        if (measuredHeight != measuredHeight2) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                        }
                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                        measuredWidth2 = view.getMeasuredWidth();
                        measuredHeight2 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                }
                if (baseline != -1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (measuredWidth2 == basicMeasure$Measure.horizontalDimension) {
                    z10 = true;
                } else {
                    z10 = true;
                }
                basicMeasure$Measure.measuredNeedsSolverPass = z10;
                if (layoutParams.needsBaseline) {
                    z9 = true;
                }
                if (z9) {
                    basicMeasure$Measure.measuredNeedsSolverPass = true;
                }
                basicMeasure$Measure.measuredWidth = measuredWidth2;
                basicMeasure$Measure.measuredHeight = measuredHeight2;
                basicMeasure$Measure.measuredHasBaseline = z9;
                basicMeasure$Measure.measuredBaseline = baseline;
            }
            i13 = 2;
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
            iArr[2] = i9;
            iMakeMeasureSpec = iMakeMeasureSpec3;
            z = false;
            iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i8);
            if (iOrdinal == 0) {
                i = 3;
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                iArr[3] = i10;
                z2 = false;
            } else if (iOrdinal == 1) {
                int childMeasureSpec4 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i11, -2);
                i = 3;
                iArr[3] = -2;
                iMakeMeasureSpec2 = childMeasureSpec4;
                z2 = true;
            } else if (iOrdinal == i13) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i11, -2);
                if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                iArr[3] = 0;
                if (basicMeasure$Measure.useCurrentDimensions) {
                    z2 = true;
                } else {
                    if (z11) {
                        z12 = false;
                    } else {
                        z12 = false;
                    }
                    if (z11) {
                    }
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                    z2 = false;
                }
                i = 3;
            } else if (iOrdinal != 3) {
                i = 3;
                z2 = false;
                iMakeMeasureSpec2 = 0;
            } else {
                int i18 = this.layoutHeightSpec;
                if (constraintAnchor2 != null) {
                    i6 = constraintWidget.mTop.mMargin;
                } else {
                    i6 = 0;
                }
                if (constraintAnchor != null) {
                    i6 += constraintWidget.mBottom.mMargin;
                }
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i18, i11 + i6, -1);
                iArr[3] = -1;
                z2 = false;
                i = 3;
            }
            if (i7 == i) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (i8 == i) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (i8 != 4) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (i7 != 4) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (z3) {
                z7 = false;
            } else {
                z7 = false;
            }
            if (z4) {
                z8 = false;
            } else {
                z8 = false;
            }
            layoutParams = (LayoutParams) view.getLayoutParams();
            if (basicMeasure$Measure.useCurrentDimensions) {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                if (z) {
                    iArr[0] = measuredWidth;
                    iArr[2] = measuredHeight;
                } else {
                    iArr[0] = 0;
                    iArr[2] = 0;
                }
                if (z2) {
                    iArr[1] = measuredHeight;
                    iArr[3] = measuredWidth;
                } else {
                    iArr[1] = 0;
                    iArr[3] = 0;
                }
                i2 = constraintWidget.mMatchConstraintMinWidth;
                if (i2 > 0) {
                    measuredWidth2 = Math.max(i2, measuredWidth);
                } else {
                    measuredWidth2 = measuredWidth;
                }
                i3 = constraintWidget.mMatchConstraintMaxWidth;
                if (i3 > 0) {
                    measuredWidth2 = Math.min(i3, measuredWidth2);
                }
                i4 = constraintWidget.mMatchConstraintMinHeight;
                if (i4 > 0) {
                    measuredHeight2 = Math.max(i4, measuredHeight);
                } else {
                    measuredHeight2 = measuredHeight;
                }
                i5 = constraintWidget.mMatchConstraintMaxHeight;
                if (i5 > 0) {
                    measuredHeight2 = Math.min(i5, measuredHeight2);
                }
                if (!z7) {
                    if (z8) {
                        measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                    }
                } else if (z8) {
                    measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                }
                if (measuredWidth == measuredWidth2) {
                    if (measuredWidth != measuredWidth2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                } else {
                    if (measuredWidth != measuredWidth2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                if (z) {
                    iArr[0] = measuredWidth;
                    iArr[2] = measuredHeight;
                } else {
                    iArr[0] = 0;
                    iArr[2] = 0;
                }
                if (z2) {
                    iArr[1] = measuredHeight;
                    iArr[3] = measuredWidth;
                } else {
                    iArr[1] = 0;
                    iArr[3] = 0;
                }
                i2 = constraintWidget.mMatchConstraintMinWidth;
                if (i2 > 0) {
                    measuredWidth2 = Math.max(i2, measuredWidth);
                } else {
                    measuredWidth2 = measuredWidth;
                }
                i3 = constraintWidget.mMatchConstraintMaxWidth;
                if (i3 > 0) {
                    measuredWidth2 = Math.min(i3, measuredWidth2);
                }
                i4 = constraintWidget.mMatchConstraintMinHeight;
                if (i4 > 0) {
                    measuredHeight2 = Math.max(i4, measuredHeight);
                } else {
                    measuredHeight2 = measuredHeight;
                }
                i5 = constraintWidget.mMatchConstraintMaxHeight;
                if (i5 > 0) {
                    measuredHeight2 = Math.min(i5, measuredHeight2);
                }
                if (!z7) {
                    if (z8) {
                        measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                    }
                } else if (z8) {
                    measuredHeight2 = (int) ((measuredWidth2 / constraintWidget.mDimensionRatio) + 0.5f);
                }
                if (measuredWidth == measuredWidth2) {
                    if (measuredWidth != measuredWidth2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                } else {
                    if (measuredWidth != measuredWidth2) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                    }
                    if (measuredHeight != measuredHeight2) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
            }
            if (baseline != -1) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (measuredWidth2 == basicMeasure$Measure.horizontalDimension) {
                z10 = true;
            } else {
                z10 = true;
            }
            basicMeasure$Measure.measuredNeedsSolverPass = z10;
            if (layoutParams.needsBaseline) {
                z9 = true;
            }
            if (z9) {
                basicMeasure$Measure.measuredNeedsSolverPass = true;
            }
            basicMeasure$Measure.measuredWidth = measuredWidth2;
            basicMeasure$Measure.measuredHeight = measuredHeight2;
            basicMeasure$Measure.measuredHasBaseline = z9;
            basicMeasure$Measure.measuredBaseline = baseline;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 263;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this);
        init(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((ConstraintHelper) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        int i8 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + i8;
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.mDirtyHierarchy = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        int i;
        Context context = getContext();
        LayoutParams layoutParams = new LayoutParams(context, attributeSet);
        layoutParams.guideBegin = -1;
        layoutParams.guideEnd = -1;
        layoutParams.guidePercent = -1.0f;
        layoutParams.leftToLeft = -1;
        layoutParams.leftToRight = -1;
        layoutParams.rightToLeft = -1;
        layoutParams.rightToRight = -1;
        layoutParams.topToTop = -1;
        layoutParams.topToBottom = -1;
        layoutParams.bottomToTop = -1;
        layoutParams.bottomToBottom = -1;
        layoutParams.baselineToBaseline = -1;
        layoutParams.circleConstraint = -1;
        layoutParams.circleRadius = 0;
        layoutParams.circleAngle = 0.0f;
        layoutParams.startToEnd = -1;
        layoutParams.startToStart = -1;
        layoutParams.endToStart = -1;
        layoutParams.endToEnd = -1;
        layoutParams.goneLeftMargin = -1;
        layoutParams.goneTopMargin = -1;
        layoutParams.goneRightMargin = -1;
        layoutParams.goneBottomMargin = -1;
        layoutParams.goneStartMargin = -1;
        layoutParams.goneEndMargin = -1;
        layoutParams.horizontalBias = 0.5f;
        layoutParams.verticalBias = 0.5f;
        layoutParams.dimensionRatio = null;
        layoutParams.dimensionRatioSide = 1;
        layoutParams.horizontalWeight = -1.0f;
        layoutParams.verticalWeight = -1.0f;
        layoutParams.horizontalChainStyle = 0;
        layoutParams.verticalChainStyle = 0;
        layoutParams.matchConstraintDefaultWidth = 0;
        layoutParams.matchConstraintDefaultHeight = 0;
        layoutParams.matchConstraintMinWidth = 0;
        layoutParams.matchConstraintMinHeight = 0;
        layoutParams.matchConstraintMaxWidth = 0;
        layoutParams.matchConstraintMaxHeight = 0;
        layoutParams.matchConstraintPercentWidth = 1.0f;
        layoutParams.matchConstraintPercentHeight = 1.0f;
        layoutParams.editorAbsoluteX = -1;
        layoutParams.editorAbsoluteY = -1;
        layoutParams.orientation = -1;
        layoutParams.constrainedWidth = false;
        layoutParams.constrainedHeight = false;
        layoutParams.constraintTag = null;
        layoutParams.horizontalDimensionFixed = true;
        layoutParams.verticalDimensionFixed = true;
        layoutParams.needsBaseline = false;
        layoutParams.isGuideline = false;
        layoutParams.isHelper = false;
        layoutParams.resolvedLeftToLeft = -1;
        layoutParams.resolvedLeftToRight = -1;
        layoutParams.resolvedRightToLeft = -1;
        layoutParams.resolvedRightToRight = -1;
        layoutParams.resolveGoneLeftMargin = -1;
        layoutParams.resolveGoneRightMargin = -1;
        layoutParams.resolvedHorizontalBias = 0.5f;
        layoutParams.widget = new ConstraintWidget();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            int i3 = LayoutParams.Table.map.get(index);
            switch (i3) {
                case 1:
                    layoutParams.orientation = typedArrayObtainStyledAttributes.getInt(index, layoutParams.orientation);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.circleConstraint);
                    layoutParams.circleConstraint = resourceId;
                    if (resourceId == -1) {
                        layoutParams.circleConstraint = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    layoutParams.circleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.circleRadius);
                    break;
                case 4:
                    float f = typedArrayObtainStyledAttributes.getFloat(index, layoutParams.circleAngle) % 360.0f;
                    layoutParams.circleAngle = f;
                    if (f < 0.0f) {
                        layoutParams.circleAngle = (360.0f - f) % 360.0f;
                    }
                    break;
                case 5:
                    layoutParams.guideBegin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layoutParams.guideBegin);
                    break;
                case 6:
                    layoutParams.guideEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layoutParams.guideEnd);
                    break;
                case 7:
                    layoutParams.guidePercent = typedArrayObtainStyledAttributes.getFloat(index, layoutParams.guidePercent);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.leftToLeft);
                    layoutParams.leftToLeft = resourceId2;
                    if (resourceId2 == -1) {
                        layoutParams.leftToLeft = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.leftToRight);
                    layoutParams.leftToRight = resourceId3;
                    if (resourceId3 == -1) {
                        layoutParams.leftToRight = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.rightToLeft);
                    layoutParams.rightToLeft = resourceId4;
                    if (resourceId4 == -1) {
                        layoutParams.rightToLeft = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.rightToRight);
                    layoutParams.rightToRight = resourceId5;
                    if (resourceId5 == -1) {
                        layoutParams.rightToRight = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.topToTop);
                    layoutParams.topToTop = resourceId6;
                    if (resourceId6 == -1) {
                        layoutParams.topToTop = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.topToBottom);
                    layoutParams.topToBottom = resourceId7;
                    if (resourceId7 == -1) {
                        layoutParams.topToBottom = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.bottomToTop);
                    layoutParams.bottomToTop = resourceId8;
                    if (resourceId8 == -1) {
                        layoutParams.bottomToTop = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.bottomToBottom);
                    layoutParams.bottomToBottom = resourceId9;
                    if (resourceId9 == -1) {
                        layoutParams.bottomToBottom = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.baselineToBaseline);
                    layoutParams.baselineToBaseline = resourceId10;
                    if (resourceId10 == -1) {
                        layoutParams.baselineToBaseline = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.startToEnd);
                    layoutParams.startToEnd = resourceId11;
                    if (resourceId11 == -1) {
                        layoutParams.startToEnd = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.startToStart);
                    layoutParams.startToStart = resourceId12;
                    if (resourceId12 == -1) {
                        layoutParams.startToStart = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.endToStart);
                    layoutParams.endToStart = resourceId13;
                    if (resourceId13 == -1) {
                        layoutParams.endToStart = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, layoutParams.endToEnd);
                    layoutParams.endToEnd = resourceId14;
                    if (resourceId14 == -1) {
                        layoutParams.endToEnd = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    layoutParams.goneLeftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.goneLeftMargin);
                    break;
                case 22:
                    layoutParams.goneTopMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.goneTopMargin);
                    break;
                case 23:
                    layoutParams.goneRightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.goneRightMargin);
                    break;
                case 24:
                    layoutParams.goneBottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.goneBottomMargin);
                    break;
                case 25:
                    layoutParams.goneStartMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.goneStartMargin);
                    break;
                case 26:
                    layoutParams.goneEndMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.goneEndMargin);
                    break;
                case 27:
                    layoutParams.constrainedWidth = typedArrayObtainStyledAttributes.getBoolean(index, layoutParams.constrainedWidth);
                    break;
                case 28:
                    layoutParams.constrainedHeight = typedArrayObtainStyledAttributes.getBoolean(index, layoutParams.constrainedHeight);
                    break;
                case 29:
                    layoutParams.horizontalBias = typedArrayObtainStyledAttributes.getFloat(index, layoutParams.horizontalBias);
                    break;
                case 30:
                    layoutParams.verticalBias = typedArrayObtainStyledAttributes.getFloat(index, layoutParams.verticalBias);
                    break;
                case 31:
                    int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    layoutParams.matchConstraintDefaultWidth = i4;
                    if (i4 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                    }
                    break;
                case 32:
                    int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    layoutParams.matchConstraintDefaultHeight = i5;
                    if (i5 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                    }
                    break;
                case 33:
                    try {
                        layoutParams.matchConstraintMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.matchConstraintMinWidth);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, layoutParams.matchConstraintMinWidth) == -2) {
                            layoutParams.matchConstraintMinWidth = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        layoutParams.matchConstraintMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.matchConstraintMaxWidth);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, layoutParams.matchConstraintMaxWidth) == -2) {
                            layoutParams.matchConstraintMaxWidth = -2;
                        }
                    }
                    break;
                case 35:
                    layoutParams.matchConstraintPercentWidth = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, layoutParams.matchConstraintPercentWidth));
                    layoutParams.matchConstraintDefaultWidth = 2;
                    break;
                case 36:
                    try {
                        layoutParams.matchConstraintMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.matchConstraintMinHeight);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, layoutParams.matchConstraintMinHeight) == -2) {
                            layoutParams.matchConstraintMinHeight = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        layoutParams.matchConstraintMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layoutParams.matchConstraintMaxHeight);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, layoutParams.matchConstraintMaxHeight) == -2) {
                            layoutParams.matchConstraintMaxHeight = -2;
                        }
                    }
                    break;
                case 38:
                    layoutParams.matchConstraintPercentHeight = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, layoutParams.matchConstraintPercentHeight));
                    layoutParams.matchConstraintDefaultHeight = 2;
                    break;
                default:
                    switch (i3) {
                        case 44:
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            layoutParams.dimensionRatio = string;
                            layoutParams.dimensionRatioSide = -1;
                            if (string != null) {
                                int length = string.length();
                                int iIndexOf = layoutParams.dimensionRatio.indexOf(44);
                                if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                    i = 0;
                                } else {
                                    String strSubstring = layoutParams.dimensionRatio.substring(0, iIndexOf);
                                    if (strSubstring.equalsIgnoreCase("W")) {
                                        layoutParams.dimensionRatioSide = 0;
                                    } else if (strSubstring.equalsIgnoreCase("H")) {
                                        layoutParams.dimensionRatioSide = 1;
                                    }
                                    i = iIndexOf + 1;
                                }
                                int iIndexOf2 = layoutParams.dimensionRatio.indexOf(58);
                                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                    String strSubstring2 = layoutParams.dimensionRatio.substring(i);
                                    if (strSubstring2.length() > 0) {
                                        Float.parseFloat(strSubstring2);
                                    }
                                } else {
                                    String strSubstring3 = layoutParams.dimensionRatio.substring(i, iIndexOf2);
                                    String strSubstring4 = layoutParams.dimensionRatio.substring(iIndexOf2 + 1);
                                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                        try {
                                            float f2 = Float.parseFloat(strSubstring3);
                                            float f3 = Float.parseFloat(strSubstring4);
                                            if (f2 > 0.0f && f3 > 0.0f) {
                                                if (layoutParams.dimensionRatioSide == 1) {
                                                    Math.abs(f3 / f2);
                                                } else {
                                                    Math.abs(f2 / f3);
                                                }
                                            }
                                        } catch (NumberFormatException unused5) {
                                        }
                                    }
                                }
                            }
                            break;
                        case 45:
                            layoutParams.horizontalWeight = typedArrayObtainStyledAttributes.getFloat(index, layoutParams.horizontalWeight);
                            break;
                        case 46:
                            layoutParams.verticalWeight = typedArrayObtainStyledAttributes.getFloat(index, layoutParams.verticalWeight);
                            break;
                        case 47:
                            layoutParams.horizontalChainStyle = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            layoutParams.verticalChainStyle = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            layoutParams.editorAbsoluteX = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layoutParams.editorAbsoluteX);
                            break;
                        case 50:
                            layoutParams.editorAbsoluteY = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layoutParams.editorAbsoluteY);
                            break;
                        case 51:
                            layoutParams.constraintTag = typedArrayObtainStyledAttributes.getString(index);
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        layoutParams.validate();
        return layoutParams;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.mOptimizationLevel;
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    public final void init(AttributeSet attributeSet, int i) {
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.mCompanionWidget = this;
        Measurer measurer = this.mMeasurer;
        constraintWidgetContainer.mMeasurer = measurer;
        constraintWidgetContainer.mDependencyGraph.lastModifiedAtMillis = measurer;
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == 9) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == 10) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == 7) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == 8) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == 89) {
                    this.mOptimizationLevel = typedArrayObtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == 38) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == 18) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        int i3 = this.mOptimizationLevel;
        constraintWidgetContainer.mOptimizationLevel = i3;
        LinearSystem.OPTIMIZED_ENGINE = (i3 & 256) == 256;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if (childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || zIsInEditMode) {
                int x = constraintWidget.getX();
                int y = constraintWidget.getY();
                childAt.layout(x, y, constraintWidget.getWidth() + x, constraintWidget.getHeight() + y);
            }
        }
        ArrayList arrayList = this.mConstraintHelpers;
        int size = arrayList.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((ConstraintHelper) arrayList.get(i6)).getClass();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:179:0x0366  */
    /* JADX WARN: Code duplicated, block: B:181:0x0370  */
    /* JADX WARN: Code duplicated, block: B:182:0x037d  */
    /* JADX WARN: Code duplicated, block: B:183:0x0380  */
    /* JADX WARN: Code duplicated, block: B:190:0x039c  */
    /* JADX WARN: Code duplicated, block: B:192:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:193:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:195:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:202:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:204:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:206:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:208:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:213:0x0417  */
    /* JADX WARN: Code duplicated, block: B:215:0x0427 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:219:0x0461  */
    /* JADX WARN: Code duplicated, block: B:222:0x0466  */
    /* JADX WARN: Code duplicated, block: B:225:0x046e  */
    /* JADX WARN: Code duplicated, block: B:299:0x0596  */
    /* JADX WARN: Code duplicated, block: B:365:0x0714 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:366:0x0716  */
    /* JADX WARN: Code duplicated, block: B:368:0x071a  */
    /* JADX WARN: Code duplicated, block: B:369:0x071f  */
    /* JADX WARN: Code duplicated, block: B:370:0x072b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:371:0x072d  */
    /* JADX WARN: Code duplicated, block: B:373:0x073a  */
    /* JADX WARN: Code duplicated, block: B:375:0x073f  */
    /* JADX WARN: Code duplicated, block: B:377:0x0742  */
    /* JADX WARN: Code duplicated, block: B:378:0x0749  */
    /* JADX WARN: Code duplicated, block: B:381:0x0755  */
    /* JADX WARN: Code duplicated, block: B:383:0x075b  */
    /* JADX WARN: Code duplicated, block: B:389:0x0790  */
    /* JADX WARN: Code duplicated, block: B:390:0x0793  */
    /* JADX WARN: Code duplicated, block: B:393:0x079b  */
    /* JADX WARN: Code duplicated, block: B:394:0x079e  */
    /* JADX WARN: Code duplicated, block: B:397:0x07c4  */
    /* JADX WARN: Code duplicated, block: B:398:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:400:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:403:0x07d2  */
    /* JADX WARN: Code duplicated, block: B:404:0x07d4  */
    /* JADX WARN: Code duplicated, block: B:407:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:409:0x07dc  */
    /* JADX WARN: Code duplicated, block: B:411:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:413:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:416:0x0801  */
    /* JADX WARN: Code duplicated, block: B:417:0x0803  */
    /* JADX WARN: Code duplicated, block: B:419:0x0806 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:423:0x0812  */
    /* JADX WARN: Code duplicated, block: B:427:0x081b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:429:0x0822  */
    /* JADX WARN: Code duplicated, block: B:439:0x083f A[PHI: r11 r12
      0x083f: PHI (r11v5 boolean) = (r11v4 boolean), (r11v21 boolean) binds: [B:406:0x07d7, B:714:0x083f] A[DONT_GENERATE, DONT_INLINE]
      0x083f: PHI (r12v4 int) = (r12v3 int), (r12v48 int) binds: [B:406:0x07d7, B:714:0x083f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:441:0x0847 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:442:0x0849 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:447:0x0852  */
    /* JADX WARN: Code duplicated, block: B:449:0x0867  */
    /* JADX WARN: Code duplicated, block: B:451:0x086d  */
    /* JADX WARN: Code duplicated, block: B:454:0x0876  */
    /* JADX WARN: Code duplicated, block: B:458:0x0883 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:500:0x097b  */
    /* JADX WARN: Code duplicated, block: B:502:0x0993  */
    /* JADX WARN: Code duplicated, block: B:504:0x0996  */
    /* JADX WARN: Code duplicated, block: B:508:0x09b1  */
    /* JADX WARN: Code duplicated, block: B:516:0x09cd  */
    /* JADX WARN: Code duplicated, block: B:538:0x0a0b  */
    /* JADX WARN: Code duplicated, block: B:540:0x0a1d  */
    /* JADX WARN: Code duplicated, block: B:542:0x0a26 A[LOOP:21: B:541:0x0a24->B:542:0x0a26, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:544:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:547:0x0a83  */
    /* JADX WARN: Code duplicated, block: B:548:0x0a8a  */
    /* JADX WARN: Code duplicated, block: B:550:0x0a8e  */
    /* JADX WARN: Code duplicated, block: B:552:0x0a98 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:553:0x0a9a  */
    /* JADX WARN: Code duplicated, block: B:554:0x0a9c  */
    /* JADX WARN: Code duplicated, block: B:556:0x0a9f  */
    /* JADX WARN: Code duplicated, block: B:557:0x0aa1  */
    /* JADX WARN: Code duplicated, block: B:559:0x0aa6  */
    /* JADX WARN: Code duplicated, block: B:561:0x0ab4  */
    /* JADX WARN: Code duplicated, block: B:563:0x0ab7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:564:0x0ab9  */
    /* JADX WARN: Code duplicated, block: B:566:0x0ac4  */
    /* JADX WARN: Code duplicated, block: B:568:0x0ad0  */
    /* JADX WARN: Code duplicated, block: B:569:0x0ad2  */
    /* JADX WARN: Code duplicated, block: B:576:0x0af0  */
    /* JADX WARN: Code duplicated, block: B:582:0x0afb  */
    /* JADX WARN: Code duplicated, block: B:586:0x0b0d A[LOOP:14: B:585:0x0b0b->B:586:0x0b0d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:589:0x0b19  */
    /* JADX WARN: Code duplicated, block: B:591:0x0b1c A[LOOP:15: B:590:0x0b1a->B:591:0x0b1c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:594:0x0b34  */
    /* JADX WARN: Code duplicated, block: B:596:0x0b39  */
    /* JADX WARN: Code duplicated, block: B:598:0x0b42  */
    /* JADX WARN: Code duplicated, block: B:600:0x0b46  */
    /* JADX WARN: Code duplicated, block: B:603:0x0b4c  */
    /* JADX WARN: Code duplicated, block: B:604:0x0b4e  */
    /* JADX WARN: Code duplicated, block: B:607:0x0b68 A[LOOP:16: B:606:0x0b66->B:607:0x0b68, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:611:0x0b7c  */
    /* JADX WARN: Code duplicated, block: B:613:0x0b80  */
    /* JADX WARN: Code duplicated, block: B:615:0x0b8a  */
    /* JADX WARN: Code duplicated, block: B:616:0x0b8d  */
    /* JADX WARN: Code duplicated, block: B:622:0x0b9b  */
    /* JADX WARN: Code duplicated, block: B:626:0x0bab A[PHI: r18
      0x0bab: PHI (r18v10 int) = (r18v8 int), (r18v8 int), (r18v11 int) binds: [B:620:0x0b98, B:625:0x0ba9, B:615:0x0b8a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:629:0x0bde  */
    /* JADX WARN: Code duplicated, block: B:631:0x0be3  */
    /* JADX WARN: Code duplicated, block: B:634:0x0c02  */
    /* JADX WARN: Code duplicated, block: B:636:0x0c05  */
    /* JADX WARN: Code duplicated, block: B:638:0x0c08  */
    /* JADX WARN: Code duplicated, block: B:640:0x0c0d  */
    /* JADX WARN: Code duplicated, block: B:643:0x0c2c  */
    /* JADX WARN: Code duplicated, block: B:645:0x0c2f  */
    /* JADX WARN: Code duplicated, block: B:648:0x0c34  */
    /* JADX WARN: Code duplicated, block: B:654:0x0c56  */
    /* JADX WARN: Code duplicated, block: B:655:0x0c5b  */
    /* JADX WARN: Code duplicated, block: B:658:0x0c6b  */
    /* JADX WARN: Code duplicated, block: B:660:0x0c74  */
    /* JADX WARN: Code duplicated, block: B:661:0x0c79  */
    /* JADX WARN: Code duplicated, block: B:664:0x0c80  */
    /* JADX WARN: Code duplicated, block: B:665:0x0c85  */
    /* JADX WARN: Code duplicated, block: B:667:0x0c88  */
    /* JADX WARN: Code duplicated, block: B:670:0x0c92  */
    /* JADX WARN: Code duplicated, block: B:671:0x0c94  */
    /* JADX WARN: Code duplicated, block: B:675:0x0ccf  */
    /* JADX WARN: Code duplicated, block: B:677:0x0cd2  */
    /* JADX WARN: Code duplicated, block: B:714:0x083f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:0x09fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:751:0x0c39 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int iMax;
        int i5;
        int i6;
        int iMax2;
        int i7;
        int width;
        int[] iArr;
        char c;
        int i8;
        int i9;
        ConstraintWidgetContainer constraintWidgetContainer;
        ArrayList arrayList;
        Measurer measurer;
        int size;
        int width2;
        int height;
        boolean z;
        int[] iArr2;
        boolean z2;
        boolean z3;
        int i10;
        int i11;
        ConstraintWidgetContainer constraintWidgetContainer2;
        ArrayList arrayList2;
        Measurer measurer2;
        int i12;
        int i13;
        int i14;
        boolean zDirectMeasureWithOrientation;
        int i15;
        int size2;
        int i16;
        int i17;
        boolean z4;
        int[] iArr3;
        boolean z5;
        boolean z6;
        int i18;
        ArrayList arrayList3;
        int iMax3;
        int iMax4;
        int i19;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean zMeasure;
        int i20;
        ConstraintWidget constraintWidget;
        int i21;
        int width3;
        int height2;
        boolean z10;
        int i22;
        boolean z11;
        int width4;
        Measurer measurer3;
        int height3;
        int size3;
        Measurer measurer4;
        int i23;
        ConstraintLayout constraintLayout;
        int childCount;
        ArrayList arrayList4;
        int i24;
        int size4;
        int i25;
        ConstraintWidget constraintWidget2;
        int dimensionBehaviour;
        boolean z12;
        boolean z13;
        int iMin;
        int iMin2;
        int iMin3;
        int iMin4;
        int i26;
        ConstraintWidgetContainer constraintWidgetContainer3;
        int i27;
        int i28;
        ArrayList arrayList5;
        int size5;
        int i29;
        boolean z14;
        boolean z15;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        boolean z16;
        int size6;
        int i35;
        int size7;
        int i36;
        boolean z17;
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        int i37;
        boolean z18;
        ConstraintWidget constraintWidget3;
        int[] iArr4;
        int i38;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        int i39;
        int i40;
        int i41;
        int i42;
        ConstraintWidget constraintWidget4;
        int i43;
        ConstraintWidget constraintWidget5;
        int i44;
        ConstraintWidget constraintWidget6;
        int i45;
        int i46;
        int i47;
        ConstraintWidget constraintWidget7;
        float f;
        int i48;
        int i49;
        int i50;
        ConstraintWidget constraintWidget8;
        ConstraintWidget constraintWidget9;
        int i51;
        SparseArray sparseArray;
        float f2;
        ConstraintWidget constraintWidget10;
        ConstraintWidget constraintWidget11;
        ConstraintWidget constraintWidget12;
        ConstraintWidget constraintWidget13;
        int i52;
        int i53;
        int i54;
        int i55;
        float fAbs;
        int i56;
        ArrayList arrayList6;
        int i57;
        int i58;
        ArrayList arrayList7;
        int i59;
        ConstraintWidget constraintWidget14;
        int i60 = 1;
        int i61 = 0;
        boolean z23 = (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
        ConstraintWidgetContainer constraintWidgetContainer4 = this.mLayoutWidget;
        constraintWidgetContainer4.mIsRtl = z23;
        MenuHostHelper menuHostHelper = constraintWidgetContainer4.mBasicMeasureSolver;
        FileMetadata fileMetadata = constraintWidgetContainer4.mDependencyGraph;
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            int childCount2 = getChildCount();
            i3 = 4194304;
            int i62 = 0;
            while (true) {
                if (i62 >= childCount2) {
                    z21 = false;
                    break;
                } else {
                    if (getChildAt(i62).isLayoutRequested()) {
                        z21 = true;
                        break;
                    }
                    i62++;
                }
            }
            if (z21) {
                boolean zIsInEditMode = isInEditMode();
                int childCount3 = getChildCount();
                for (int i63 = 0; i63 < childCount3; i63++) {
                    ConstraintWidget viewWidget = getViewWidget(getChildAt(i63));
                    if (viewWidget != null) {
                        viewWidget.reset();
                    }
                }
                SparseArray sparseArray2 = this.mChildrenByIds;
                if (zIsInEditMode) {
                    int i64 = 0;
                    while (i64 < childCount3) {
                        View childAt = getChildAt(i64);
                        try {
                            i59 = i60;
                            try {
                                String resourceName = getResources().getResourceName(childAt.getId());
                                Integer numValueOf = Integer.valueOf(childAt.getId());
                                if ((resourceName != null ? i59 : i61) != 0) {
                                    if (this.mDesignIds == null) {
                                        this.mDesignIds = new HashMap();
                                    }
                                    int iIndexOf = resourceName.indexOf("/");
                                    this.mDesignIds.put(iIndexOf != -1 ? resourceName.substring(iIndexOf + 1) : resourceName, numValueOf);
                                }
                                int iIndexOf2 = resourceName.indexOf(47);
                                if (iIndexOf2 != -1) {
                                    resourceName = resourceName.substring(iIndexOf2 + 1);
                                }
                                int id = childAt.getId();
                                if (id != 0) {
                                    View viewFindViewById = (View) sparseArray2.get(id);
                                    if (viewFindViewById == null && (viewFindViewById = findViewById(id)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
                                        onViewAdded(viewFindViewById);
                                    }
                                    constraintWidget14 = viewFindViewById == this ? constraintWidgetContainer4 : viewFindViewById == null ? null : ((LayoutParams) viewFindViewById.getLayoutParams()).widget;
                                }
                                constraintWidget14.mDebugName = resourceName;
                            } catch (Resources.NotFoundException unused) {
                            }
                        } catch (Resources.NotFoundException unused2) {
                            i59 = i60;
                        }
                        i64++;
                        i60 = i59;
                        i61 = 0;
                    }
                }
                int i65 = i60;
                if (this.mConstraintSetId != -1) {
                    for (int i66 = 0; i66 < childCount3; i66++) {
                        getChildAt(i66).getId();
                    }
                }
                ConstraintSet constraintSet = this.mConstraintSet;
                if (constraintSet != null) {
                    constraintSet.applyToInternal(this);
                }
                constraintWidgetContainer4.mChildren.clear();
                ArrayList arrayList8 = this.mConstraintHelpers;
                int size8 = arrayList8.size();
                if (size8 > 0) {
                    int i67 = 0;
                    while (i67 < size8) {
                        ConstraintHelper constraintHelper = (ConstraintHelper) arrayList8.get(i67);
                        HashMap map = constraintHelper.mMap;
                        if (constraintHelper.isInEditMode()) {
                            constraintHelper.setIds(constraintHelper.mReferenceIds);
                        }
                        androidx.constraintlayout.solver.widgets.Barrier barrier = constraintHelper.mHelperWidget;
                        if (barrier == null) {
                            arrayList6 = arrayList8;
                            i57 = size8;
                        } else {
                            barrier.mWidgetsCount = 0;
                            Arrays.fill(barrier.mWidgets, (Object) null);
                            int i68 = 0;
                            while (i68 < constraintHelper.mCount) {
                                int i69 = constraintHelper.mIds[i68];
                                View view = (View) sparseArray2.get(i69);
                                if (view == null) {
                                    String str = (String) map.get(Integer.valueOf(i69));
                                    i58 = i68;
                                    int iFindId = constraintHelper.findId(this, str);
                                    arrayList7 = arrayList8;
                                    if (iFindId != 0) {
                                        constraintHelper.mIds[i58] = iFindId;
                                        map.put(Integer.valueOf(iFindId), str);
                                        view = (View) sparseArray2.get(iFindId);
                                    }
                                } else {
                                    i58 = i68;
                                    arrayList7 = arrayList8;
                                }
                                View view2 = view;
                                if (view2 != null) {
                                    androidx.constraintlayout.solver.widgets.Barrier barrier2 = constraintHelper.mHelperWidget;
                                    ConstraintWidget viewWidget2 = getViewWidget(view2);
                                    barrier2.getClass();
                                    if (viewWidget2 != barrier2 && viewWidget2 != null) {
                                        int i70 = barrier2.mWidgetsCount + 1;
                                        ConstraintWidget[] constraintWidgetArr = barrier2.mWidgets;
                                        if (i70 > constraintWidgetArr.length) {
                                            barrier2.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
                                        }
                                        ConstraintWidget[] constraintWidgetArr2 = barrier2.mWidgets;
                                        int i71 = barrier2.mWidgetsCount;
                                        constraintWidgetArr2[i71] = viewWidget2;
                                        barrier2.mWidgetsCount = i71 + 1;
                                    }
                                }
                                i68 = i58 + 1;
                                arrayList8 = arrayList7;
                                size8 = size8;
                            }
                            arrayList6 = arrayList8;
                            i57 = size8;
                            constraintHelper.mHelperWidget.getClass();
                        }
                        i67++;
                        z21 = z21;
                        arrayList8 = arrayList6;
                        size8 = i57;
                    }
                }
                z22 = z21;
                for (int i72 = 0; i72 < childCount3; i72++) {
                    getChildAt(i72);
                }
                SparseArray sparseArray3 = this.mTempMapIdToWidget;
                sparseArray3.clear();
                sparseArray3.put(0, constraintWidgetContainer4);
                sparseArray3.put(getId(), constraintWidgetContainer4);
                for (int i73 = 0; i73 < childCount3; i73++) {
                    View childAt2 = getChildAt(i73);
                    sparseArray3.put(childAt2.getId(), getViewWidget(childAt2));
                }
                int i74 = 0;
                while (i74 < childCount3) {
                    View childAt3 = getChildAt(i74);
                    ConstraintWidget viewWidget3 = getViewWidget(childAt3);
                    if (viewWidget3 == null) {
                        i40 = childCount3;
                    } else {
                        LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                        constraintWidgetContainer4.mChildren.add(viewWidget3);
                        ConstraintWidget constraintWidget15 = viewWidget3.mParent;
                        if (constraintWidget15 != null) {
                            ((ConstraintWidgetContainer) constraintWidget15).mChildren.remove(viewWidget3);
                            viewWidget3.mParent = null;
                        }
                        viewWidget3.mParent = constraintWidgetContainer4;
                        layoutParams.validate();
                        viewWidget3.mVisibility = childAt3.getVisibility();
                        viewWidget3.mCompanionWidget = childAt3;
                        i40 = childCount3;
                        if (childAt3 instanceof ConstraintHelper) {
                            boolean z24 = constraintWidgetContainer4.mIsRtl;
                            Barrier barrier3 = (Barrier) ((ConstraintHelper) childAt3);
                            int i75 = barrier3.mIndicatedType;
                            barrier3.mResolvedType = i75;
                            if (z24) {
                                if (i75 == 5) {
                                    barrier3.mResolvedType = i65;
                                } else if (i75 == 6) {
                                    barrier3.mResolvedType = 0;
                                }
                            } else if (i75 == 5) {
                                barrier3.mResolvedType = 0;
                            } else if (i75 == 6) {
                                barrier3.mResolvedType = 1;
                            }
                            if (viewWidget3 instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                ((androidx.constraintlayout.solver.widgets.Barrier) viewWidget3).mBarrierType = barrier3.mResolvedType;
                            }
                        }
                        if (layoutParams.isGuideline) {
                            androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) viewWidget3;
                            int i76 = layoutParams.resolvedGuideBegin;
                            int i77 = layoutParams.resolvedGuideEnd;
                            float f3 = layoutParams.resolvedGuidePercent;
                            if (f3 != -1.0f) {
                                if (f3 > -1.0f) {
                                    guideline.mRelativePercent = f3;
                                    guideline.mRelativeBegin = -1;
                                    guideline.mRelativeEnd = -1;
                                }
                            } else if (i76 != -1) {
                                if (i76 > -1) {
                                    guideline.mRelativePercent = -1.0f;
                                    guideline.mRelativeBegin = i76;
                                    guideline.mRelativeEnd = -1;
                                }
                            } else if (i77 != -1 && i77 > -1) {
                                guideline.mRelativePercent = -1.0f;
                                guideline.mRelativeBegin = -1;
                                guideline.mRelativeEnd = i77;
                            }
                        } else {
                            int i78 = layoutParams.resolvedLeftToLeft;
                            int i79 = layoutParams.resolvedLeftToRight;
                            int i80 = layoutParams.resolvedRightToLeft;
                            int i81 = layoutParams.resolvedRightToRight;
                            i74 = i74;
                            int i82 = layoutParams.resolveGoneLeftMargin;
                            int i83 = layoutParams.resolveGoneRightMargin;
                            float f4 = layoutParams.resolvedHorizontalBias;
                            zIsInEditMode = zIsInEditMode;
                            int i84 = layoutParams.circleConstraint;
                            if (i84 != -1) {
                                ConstraintWidget constraintWidget16 = (ConstraintWidget) sparseArray3.get(i84);
                                if (constraintWidget16 != null) {
                                    float f5 = layoutParams.circleAngle;
                                    viewWidget3.immediateConnect(7, 7, layoutParams.circleRadius, 0, constraintWidget16);
                                    constraintWidget9 = viewWidget3;
                                    constraintWidget9.mCircleConstraintAngle = f5;
                                } else {
                                    constraintWidget9 = viewWidget3;
                                }
                                layoutParams = layoutParams;
                                i41 = -1;
                                f = 0.0f;
                                sparseArray = sparseArray2;
                            } else {
                                i41 = -1;
                                if (i78 != -1) {
                                    ConstraintWidget constraintWidget17 = (ConstraintWidget) sparseArray3.get(i78);
                                    if (constraintWidget17 != null) {
                                        i42 = 2;
                                        viewWidget3.immediateConnect(2, 2, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i82, constraintWidget17);
                                    } else {
                                        i42 = 2;
                                    }
                                } else {
                                    i42 = 2;
                                    if (i79 != -1 && (constraintWidget4 = (ConstraintWidget) sparseArray3.get(i79)) != null) {
                                        i43 = i80;
                                        viewWidget3.immediateConnect(2, 4, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i82, constraintWidget4);
                                        constraintWidget5 = viewWidget3;
                                        i44 = 4;
                                    }
                                    if (i43 != -1) {
                                        constraintWidget13 = (ConstraintWidget) sparseArray3.get(i43);
                                        if (constraintWidget13 != null) {
                                            constraintWidget5.immediateConnect(i44, i42, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i83, constraintWidget13);
                                        }
                                    } else if (i81 != -1 && (constraintWidget6 = (ConstraintWidget) sparseArray3.get(i81)) != null) {
                                        constraintWidget5.immediateConnect(i44, i44, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i83, constraintWidget6);
                                    }
                                    i45 = layoutParams.topToTop;
                                    if (i45 != -1) {
                                        constraintWidget12 = (ConstraintWidget) sparseArray3.get(i45);
                                        if (constraintWidget12 != null) {
                                            i46 = 3;
                                            constraintWidget5.immediateConnect(3, 3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin, constraintWidget12);
                                        } else {
                                            i46 = 3;
                                        }
                                    } else {
                                        i46 = 3;
                                        i47 = layoutParams.topToBottom;
                                        if (i47 == -1 && (constraintWidget7 = (ConstraintWidget) sparseArray3.get(i47)) != null) {
                                            f = 0.0f;
                                            constraintWidget5.immediateConnect(3, 5, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin, constraintWidget7);
                                            i48 = 5;
                                        }
                                        i49 = layoutParams.bottomToTop;
                                        if (i49 != -1) {
                                            constraintWidget11 = (ConstraintWidget) sparseArray3.get(i49);
                                            if (constraintWidget11 != null) {
                                                constraintWidget5.immediateConnect(i48, i46, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin, constraintWidget11);
                                            }
                                        } else {
                                            i50 = layoutParams.bottomToBottom;
                                            if (i50 == -1 && (constraintWidget8 = (ConstraintWidget) sparseArray3.get(i50)) != null) {
                                                constraintWidget9 = constraintWidget5;
                                                constraintWidget9.immediateConnect(i48, i48, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin, constraintWidget8);
                                            }
                                            i51 = layoutParams.baselineToBaseline;
                                            sparseArray = sparseArray2;
                                            if (i51 != -1) {
                                                View view3 = (View) sparseArray.get(i51);
                                                constraintWidget10 = (ConstraintWidget) sparseArray3.get(layoutParams.baselineToBaseline);
                                                if (constraintWidget10 == null && view3 != null && (view3.getLayoutParams() instanceof LayoutParams)) {
                                                    LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                                                    layoutParams.needsBaseline = true;
                                                    layoutParams2.needsBaseline = true;
                                                    constraintWidget9.getAnchor(6).connect(constraintWidget10.getAnchor(6), 0, -1);
                                                    constraintWidget9.hasBaseline = true;
                                                    layoutParams2.widget.hasBaseline = true;
                                                    constraintWidget9.getAnchor(3).reset();
                                                    constraintWidget9.getAnchor(5).reset();
                                                }
                                            }
                                            if (f4 >= f) {
                                                constraintWidget9.mHorizontalBiasPercent = f4;
                                            }
                                            f2 = layoutParams.verticalBias;
                                            if (f2 >= f) {
                                                constraintWidget9.mVerticalBiasPercent = f2;
                                            }
                                        }
                                        constraintWidget9 = constraintWidget5;
                                        i51 = layoutParams.baselineToBaseline;
                                        sparseArray = sparseArray2;
                                        if (i51 != -1) {
                                            View view4 = (View) sparseArray.get(i51);
                                            constraintWidget10 = (ConstraintWidget) sparseArray3.get(layoutParams.baselineToBaseline);
                                            if (constraintWidget10 == null) {
                                            }
                                        }
                                        if (f4 >= f) {
                                            constraintWidget9.mHorizontalBiasPercent = f4;
                                        }
                                        f2 = layoutParams.verticalBias;
                                        if (f2 >= f) {
                                            constraintWidget9.mVerticalBiasPercent = f2;
                                        }
                                    }
                                    i48 = 5;
                                    f = 0.0f;
                                    i49 = layoutParams.bottomToTop;
                                    if (i49 != -1) {
                                        constraintWidget11 = (ConstraintWidget) sparseArray3.get(i49);
                                        if (constraintWidget11 != null) {
                                            constraintWidget5.immediateConnect(i48, i46, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin, constraintWidget11);
                                        }
                                    } else {
                                        i50 = layoutParams.bottomToBottom;
                                        if (i50 == -1) {
                                        }
                                        i51 = layoutParams.baselineToBaseline;
                                        sparseArray = sparseArray2;
                                        if (i51 != -1) {
                                            View view5 = (View) sparseArray.get(i51);
                                            constraintWidget10 = (ConstraintWidget) sparseArray3.get(layoutParams.baselineToBaseline);
                                            if (constraintWidget10 == null) {
                                            }
                                        }
                                        if (f4 >= f) {
                                            constraintWidget9.mHorizontalBiasPercent = f4;
                                        }
                                        f2 = layoutParams.verticalBias;
                                        if (f2 >= f) {
                                            constraintWidget9.mVerticalBiasPercent = f2;
                                        }
                                    }
                                    constraintWidget9 = constraintWidget5;
                                    i51 = layoutParams.baselineToBaseline;
                                    sparseArray = sparseArray2;
                                    if (i51 != -1) {
                                        View view6 = (View) sparseArray.get(i51);
                                        constraintWidget10 = (ConstraintWidget) sparseArray3.get(layoutParams.baselineToBaseline);
                                        if (constraintWidget10 == null) {
                                        }
                                    }
                                    if (f4 >= f) {
                                        constraintWidget9.mHorizontalBiasPercent = f4;
                                    }
                                    f2 = layoutParams.verticalBias;
                                    if (f2 >= f) {
                                        constraintWidget9.mVerticalBiasPercent = f2;
                                    }
                                }
                                constraintWidget5 = viewWidget3;
                                i43 = i80;
                                i44 = 4;
                                if (i43 != -1) {
                                    constraintWidget13 = (ConstraintWidget) sparseArray3.get(i43);
                                    if (constraintWidget13 != null) {
                                        constraintWidget5.immediateConnect(i44, i42, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i83, constraintWidget13);
                                    }
                                } else if (i81 != -1) {
                                    constraintWidget5.immediateConnect(i44, i44, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i83, constraintWidget6);
                                }
                                i45 = layoutParams.topToTop;
                                if (i45 != -1) {
                                    constraintWidget12 = (ConstraintWidget) sparseArray3.get(i45);
                                    if (constraintWidget12 != null) {
                                        i46 = 3;
                                        constraintWidget5.immediateConnect(3, 3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin, constraintWidget12);
                                    } else {
                                        i46 = 3;
                                    }
                                } else {
                                    i46 = 3;
                                    i47 = layoutParams.topToBottom;
                                    if (i47 == -1) {
                                    }
                                    i49 = layoutParams.bottomToTop;
                                    if (i49 != -1) {
                                        constraintWidget11 = (ConstraintWidget) sparseArray3.get(i49);
                                        if (constraintWidget11 != null) {
                                            constraintWidget5.immediateConnect(i48, i46, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin, constraintWidget11);
                                        }
                                    } else {
                                        i50 = layoutParams.bottomToBottom;
                                        if (i50 == -1) {
                                        }
                                        i51 = layoutParams.baselineToBaseline;
                                        sparseArray = sparseArray2;
                                        if (i51 != -1) {
                                            View view7 = (View) sparseArray.get(i51);
                                            constraintWidget10 = (ConstraintWidget) sparseArray3.get(layoutParams.baselineToBaseline);
                                            if (constraintWidget10 == null) {
                                            }
                                        }
                                        if (f4 >= f) {
                                            constraintWidget9.mHorizontalBiasPercent = f4;
                                        }
                                        f2 = layoutParams.verticalBias;
                                        if (f2 >= f) {
                                            constraintWidget9.mVerticalBiasPercent = f2;
                                        }
                                    }
                                    constraintWidget9 = constraintWidget5;
                                    i51 = layoutParams.baselineToBaseline;
                                    sparseArray = sparseArray2;
                                    if (i51 != -1) {
                                        View view8 = (View) sparseArray.get(i51);
                                        constraintWidget10 = (ConstraintWidget) sparseArray3.get(layoutParams.baselineToBaseline);
                                        if (constraintWidget10 == null) {
                                        }
                                    }
                                    if (f4 >= f) {
                                        constraintWidget9.mHorizontalBiasPercent = f4;
                                    }
                                    f2 = layoutParams.verticalBias;
                                    if (f2 >= f) {
                                        constraintWidget9.mVerticalBiasPercent = f2;
                                    }
                                }
                                i48 = 5;
                                f = 0.0f;
                                i49 = layoutParams.bottomToTop;
                                if (i49 != -1) {
                                    constraintWidget11 = (ConstraintWidget) sparseArray3.get(i49);
                                    if (constraintWidget11 != null) {
                                        constraintWidget5.immediateConnect(i48, i46, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin, constraintWidget11);
                                    }
                                } else {
                                    i50 = layoutParams.bottomToBottom;
                                    if (i50 == -1) {
                                    }
                                    i51 = layoutParams.baselineToBaseline;
                                    sparseArray = sparseArray2;
                                    if (i51 != -1) {
                                        View view9 = (View) sparseArray.get(i51);
                                        constraintWidget10 = (ConstraintWidget) sparseArray3.get(layoutParams.baselineToBaseline);
                                        if (constraintWidget10 == null) {
                                        }
                                    }
                                    if (f4 >= f) {
                                        constraintWidget9.mHorizontalBiasPercent = f4;
                                    }
                                    f2 = layoutParams.verticalBias;
                                    if (f2 >= f) {
                                        constraintWidget9.mVerticalBiasPercent = f2;
                                    }
                                }
                                constraintWidget9 = constraintWidget5;
                                i51 = layoutParams.baselineToBaseline;
                                sparseArray = sparseArray2;
                                if (i51 != -1) {
                                    View view10 = (View) sparseArray.get(i51);
                                    constraintWidget10 = (ConstraintWidget) sparseArray3.get(layoutParams.baselineToBaseline);
                                    if (constraintWidget10 == null) {
                                    }
                                }
                                if (f4 >= f) {
                                    constraintWidget9.mHorizontalBiasPercent = f4;
                                }
                                f2 = layoutParams.verticalBias;
                                if (f2 >= f) {
                                    constraintWidget9.mVerticalBiasPercent = f2;
                                }
                            }
                            if (zIsInEditMode && ((i56 = layoutParams.editorAbsoluteX) != i41 || layoutParams.editorAbsoluteY != i41)) {
                                int i85 = layoutParams.editorAbsoluteY;
                                constraintWidget9.mX = i56;
                                constraintWidget9.mY = i85;
                            }
                            if (layoutParams.horizontalDimensionFixed) {
                                i52 = 3;
                                i53 = 4;
                                constraintWidget9.setHorizontalDimensionBehaviour(1);
                                constraintWidget9.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
                                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                                    constraintWidget9.setHorizontalDimensionBehaviour(2);
                                }
                            } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == i41) {
                                if (layoutParams.constrainedWidth) {
                                    i52 = 3;
                                    constraintWidget9.setHorizontalDimensionBehaviour(3);
                                    i53 = 4;
                                } else {
                                    i52 = 3;
                                    i53 = 4;
                                    constraintWidget9.setHorizontalDimensionBehaviour(4);
                                }
                                constraintWidget9.getAnchor(2).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                                constraintWidget9.getAnchor(4).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                            } else {
                                i52 = 3;
                                i53 = 4;
                                constraintWidget9.setHorizontalDimensionBehaviour(3);
                                constraintWidget9.setWidth(0);
                            }
                            if (layoutParams.verticalDimensionFixed) {
                                constraintWidget9.setVerticalDimensionBehaviour(1);
                                constraintWidget9.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
                                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                                    constraintWidget9.setVerticalDimensionBehaviour(2);
                                }
                            } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == i41) {
                                if (layoutParams.constrainedHeight) {
                                    constraintWidget9.setVerticalDimensionBehaviour(i52);
                                } else {
                                    constraintWidget9.setVerticalDimensionBehaviour(i53);
                                }
                                constraintWidget9.getAnchor(3).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                                constraintWidget9.getAnchor(5).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            } else {
                                constraintWidget9.setVerticalDimensionBehaviour(i52);
                                constraintWidget9.setHeight(0);
                            }
                            String str2 = layoutParams.dimensionRatio;
                            if (str2 == null || str2.length() == 0) {
                                constraintWidget9.mDimensionRatio = f;
                            } else {
                                int length = str2.length();
                                int iIndexOf3 = str2.indexOf(44);
                                if (iIndexOf3 <= 0 || iIndexOf3 >= length - 1) {
                                    i54 = -1;
                                    i55 = 0;
                                } else {
                                    String strSubstring = str2.substring(0, iIndexOf3);
                                    i54 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                                    i55 = iIndexOf3 + 1;
                                }
                                int iIndexOf4 = str2.indexOf(58);
                                if (iIndexOf4 < 0 || iIndexOf4 >= length - 1) {
                                    String strSubstring2 = str2.substring(i55);
                                    if (strSubstring2.length() > 0) {
                                        fAbs = Float.parseFloat(strSubstring2);
                                    } else {
                                        fAbs = f;
                                    }
                                } else {
                                    String strSubstring3 = str2.substring(i55, iIndexOf4);
                                    String strSubstring4 = str2.substring(iIndexOf4 + 1);
                                    if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                                        fAbs = f;
                                    } else {
                                        try {
                                            float f6 = Float.parseFloat(strSubstring3);
                                            float f7 = Float.parseFloat(strSubstring4);
                                            if (f6 <= f || f7 <= f) {
                                                fAbs = f;
                                            } else {
                                                fAbs = i54 == 1 ? Math.abs(f7 / f6) : Math.abs(f6 / f7);
                                            }
                                        } catch (NumberFormatException unused3) {
                                        }
                                    }
                                }
                                if (fAbs > f) {
                                    constraintWidget9.mDimensionRatio = fAbs;
                                    constraintWidget9.mDimensionRatioSide = i54;
                                }
                            }
                            float f8 = layoutParams.horizontalWeight;
                            float[] fArr = constraintWidget9.mWeight;
                            fArr[0] = f8;
                            fArr[1] = layoutParams.verticalWeight;
                            constraintWidget9.mHorizontalChainStyle = layoutParams.horizontalChainStyle;
                            constraintWidget9.mVerticalChainStyle = layoutParams.verticalChainStyle;
                            int i86 = layoutParams.matchConstraintDefaultWidth;
                            int i87 = layoutParams.matchConstraintMinWidth;
                            int i88 = layoutParams.matchConstraintMaxWidth;
                            float f9 = layoutParams.matchConstraintPercentWidth;
                            constraintWidget9.mMatchConstraintDefaultWidth = i86;
                            constraintWidget9.mMatchConstraintMinWidth = i87;
                            if (i88 == Integer.MAX_VALUE) {
                                i88 = 0;
                            }
                            constraintWidget9.mMatchConstraintMaxWidth = i88;
                            constraintWidget9.mMatchConstraintPercentWidth = f9;
                            if (f9 > 0.0f && f9 < 1.0f && i86 == 0) {
                                constraintWidget9.mMatchConstraintDefaultWidth = 2;
                            }
                            int i89 = layoutParams.matchConstraintDefaultHeight;
                            int i90 = layoutParams.matchConstraintMinHeight;
                            int i91 = layoutParams.matchConstraintMaxHeight;
                            float f10 = layoutParams.matchConstraintPercentHeight;
                            constraintWidget9.mMatchConstraintDefaultHeight = i89;
                            constraintWidget9.mMatchConstraintMinHeight = i90;
                            if (i91 == Integer.MAX_VALUE) {
                                i91 = 0;
                            }
                            constraintWidget9.mMatchConstraintMaxHeight = i91;
                            constraintWidget9.mMatchConstraintPercentHeight = f10;
                            if (f10 > 0.0f && f10 < 1.0f && i89 == 0) {
                                constraintWidget9.mMatchConstraintDefaultHeight = 2;
                            }
                        }
                        i74++;
                        sparseArray2 = sparseArray;
                        childCount3 = i40;
                        zIsInEditMode = zIsInEditMode;
                        i65 = 1;
                    }
                    sparseArray = sparseArray2;
                    i74++;
                    sparseArray2 = sparseArray;
                    childCount3 = i40;
                    zIsInEditMode = zIsInEditMode;
                    i65 = 1;
                }
            } else {
                z22 = z21;
            }
            if (z22) {
                ArrayList arrayList9 = (ArrayList) menuHostHelper.mOnInvalidateMenuCallback;
                arrayList9.clear();
                int size9 = constraintWidgetContainer4.mChildren.size();
                for (int i92 = 0; i92 < size9; i92++) {
                    ConstraintWidget constraintWidget18 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i92);
                    int[] iArr5 = constraintWidget18.mListDimensionBehaviors;
                    int i93 = iArr5[0];
                    if (i93 == 3 || i93 == 4 || (i39 = iArr5[1]) == 3 || i39 == 4) {
                        arrayList9.add(constraintWidget18);
                    }
                }
                fileMetadata.isRegularFile = true;
            }
        } else {
            i3 = 4194304;
        }
        int i94 = this.mOptimizationLevel;
        int mode = View.MeasureSpec.getMode(i);
        int size10 = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size11 = View.MeasureSpec.getSize(i2);
        int iMax5 = Math.max(0, getPaddingTop());
        int iMax6 = Math.max(0, getPaddingBottom());
        int i95 = iMax5 + iMax6;
        int paddingWidth = getPaddingWidth();
        Measurer measurer5 = this.mMeasurer;
        measurer5.paddingTop = iMax5;
        measurer5.paddingBottom = iMax6;
        measurer5.paddingWidth = paddingWidth;
        measurer5.paddingHeight = i95;
        measurer5.layoutWidthSpec = i;
        measurer5.layoutHeightSpec = i2;
        int iMax7 = Math.max(0, getPaddingStart());
        int iMax8 = Math.max(0, getPaddingEnd());
        if (iMax7 <= 0 && iMax8 <= 0) {
            iMax7 = Math.max(0, getPaddingLeft());
        } else if ((getContext().getApplicationInfo().flags & i3) != 0 && 1 == getLayoutDirection()) {
            iMax7 = iMax8;
        }
        int i96 = size10 - paddingWidth;
        int i97 = size11 - i95;
        int i98 = measurer5.paddingHeight;
        int i99 = measurer5.paddingWidth;
        int childCount4 = getChildCount();
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    i4 = i99;
                    i5 = Integer.MIN_VALUE;
                    i6 = 1;
                    iMax = 0;
                } else {
                    i4 = i99;
                    i5 = Integer.MIN_VALUE;
                    iMax = Math.min(this.mMaxWidth - i99, i96);
                    i6 = 1;
                }
            } else if (childCount4 == 0) {
                i4 = i99;
                iMax = Math.max(0, this.mMinWidth);
            } else {
                i4 = i99;
                iMax = 0;
            }
            if (mode2 != i5) {
                if (mode2 != 0) {
                    if (childCount4 == 0) {
                        iMax2 = Math.max(0, this.mMinHeight);
                    } else {
                        iMax2 = 0;
                    }
                    i7 = 2;
                } else if (mode2 != 1073741824) {
                    measurer5 = measurer5;
                    i7 = 1;
                    iMax2 = 0;
                } else {
                    iMax2 = Math.min(this.mMaxHeight - i98, i97);
                    measurer5 = measurer5;
                    i7 = 1;
                }
                width = constraintWidgetContainer4.getWidth();
                iArr = constraintWidgetContainer4.mMaxDimension;
                if (iMax == width || iMax2 != constraintWidgetContainer4.getHeight()) {
                    fileMetadata.isDirectory = true;
                    c = 1;
                } else {
                    c = 1;
                }
                constraintWidgetContainer4.mX = 0;
                constraintWidgetContainer4.mY = 0;
                iArr[0] = this.mMaxWidth - i4;
                iArr[c] = this.mMaxHeight - i98;
                constraintWidgetContainer4.mMinWidth = 0;
                constraintWidgetContainer4.mMinHeight = 0;
                constraintWidgetContainer4.setHorizontalDimensionBehaviour(i6);
                constraintWidgetContainer4.setWidth(iMax);
                constraintWidgetContainer4.setVerticalDimensionBehaviour(i7);
                constraintWidgetContainer4.setHeight(iMax2);
                i8 = this.mMinWidth - i4;
                if (i8 < 0) {
                    constraintWidgetContainer4.mMinWidth = 0;
                } else {
                    constraintWidgetContainer4.mMinWidth = i8;
                }
                i9 = this.mMinHeight - i98;
                if (i9 < 0) {
                    constraintWidgetContainer4.mMinHeight = 0;
                } else {
                    constraintWidgetContainer4.mMinHeight = i9;
                }
                constraintWidgetContainer4.mPaddingLeft = iMax7;
                constraintWidgetContainer4.mPaddingTop = iMax5;
                constraintWidgetContainer = (ConstraintWidgetContainer) menuHostHelper.mProviderToLifecycleContainers;
                arrayList = (ArrayList) menuHostHelper.mOnInvalidateMenuCallback;
                measurer = constraintWidgetContainer4.mMeasurer;
                size = constraintWidgetContainer4.mChildren.size();
                width2 = constraintWidgetContainer4.getWidth();
                height = constraintWidgetContainer4.getHeight();
                if ((i94 & 128) == 128) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    iArr2 = iArr;
                    if ((i94 & 64) == 64) {
                        z2 = false;
                    }
                    if (z2) {
                        i37 = 0;
                        while (true) {
                            if (i37 < size) {
                                z18 = z2;
                                constraintWidget3 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i37);
                                i10 = size;
                                iArr4 = constraintWidget3.mListDimensionBehaviors;
                                i38 = i37;
                                if (iArr4[0] == 3) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (iArr4[1] == 3) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                if (!z19 && z20) {
                                    boolean z25 = constraintWidget3.mDimensionRatio > 0.0f;
                                    if ((constraintWidget3.isInHorizontalChain() || !z25) && !((constraintWidget3.isInVerticalChain() && z25) || constraintWidget3.isInHorizontalChain() || constraintWidget3.isInVerticalChain())) {
                                        i37 = i38 + 1;
                                        z2 = z18;
                                        size = i10;
                                    } else {
                                        i11 = 1073741824;
                                        z3 = false;
                                    }
                                }
                                if (constraintWidget3.isInHorizontalChain()) {
                                    i37 = i38 + 1;
                                    z2 = z18;
                                    size = i10;
                                } else {
                                    i37 = i38 + 1;
                                    z2 = z18;
                                    size = i10;
                                }
                                i11 = 1073741824;
                                z3 = false;
                            } else {
                                z3 = z2;
                                i10 = size;
                                i11 = 1073741824;
                            }
                        }
                    } else {
                        z3 = z2;
                        i10 = size;
                        i11 = 1073741824;
                    }
                    if (z3 && ((mode != i11 && mode2 == i11) || z)) {
                        iMin3 = Math.min(iArr2[0], i96);
                        iMin4 = Math.min(iArr2[1], i97);
                        i26 = 1073741824;
                        if (mode == 1073741824) {
                            if (constraintWidgetContainer4.getWidth() != iMin3) {
                                constraintWidgetContainer4.setWidth(iMin3);
                                fileMetadata.isRegularFile = true;
                            }
                            i26 = 1073741824;
                        }
                        if (mode2 == i26 && constraintWidgetContainer4.getHeight() != iMin4) {
                            constraintWidgetContainer4.setHeight(iMin4);
                            fileMetadata.isRegularFile = true;
                        }
                        if (mode == i26 || mode2 != i26) {
                            constraintWidgetContainer2 = constraintWidgetContainer;
                            arrayList2 = arrayList;
                            measurer2 = measurer;
                            i12 = width2;
                            i13 = height;
                            constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                            if (fileMetadata.isRegularFile) {
                                arrayList5 = constraintWidgetContainer3.mChildren;
                                size5 = arrayList5.size();
                                i29 = 0;
                                while (i29 < size5) {
                                    Object obj = arrayList5.get(i29);
                                    i29++;
                                    ConstraintWidget constraintWidget19 = (ConstraintWidget) obj;
                                    constraintWidget19.measured = false;
                                    HorizontalWidgetRun horizontalWidgetRun = constraintWidget19.horizontalRun;
                                    horizontalWidgetRun.dimension.resolved = false;
                                    horizontalWidgetRun.resolved = false;
                                    horizontalWidgetRun.reset();
                                    VerticalWidgetRun verticalWidgetRun = constraintWidget19.verticalRun;
                                    verticalWidgetRun.dimension.resolved = false;
                                    verticalWidgetRun.resolved = false;
                                    verticalWidgetRun.reset();
                                }
                                i27 = 0;
                                constraintWidgetContainer3.measured = false;
                                HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer3.horizontalRun;
                                horizontalWidgetRun2.dimension.resolved = false;
                                horizontalWidgetRun2.resolved = false;
                                horizontalWidgetRun2.reset();
                                VerticalWidgetRun verticalWidgetRun2 = constraintWidgetContainer3.verticalRun;
                                verticalWidgetRun2.dimension.resolved = false;
                                verticalWidgetRun2.resolved = false;
                                verticalWidgetRun2.reset();
                                fileMetadata.buildGraph();
                            } else {
                                i27 = 0;
                            }
                            fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                            constraintWidgetContainer3.mX = i27;
                            constraintWidgetContainer3.mY = i27;
                            constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                            constraintWidgetContainer3.verticalRun.start.resolve(i27);
                            i28 = 1073741824;
                            if (mode == 1073741824) {
                                zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                                i14 = 1;
                            } else {
                                i14 = 0;
                                zDirectMeasureWithOrientation = true;
                            }
                            if (mode2 == 1073741824) {
                                zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                                i14++;
                            }
                        } else {
                            ArrayList arrayList10 = (ArrayList) fileMetadata.createdAtMillis;
                            ConstraintWidgetContainer constraintWidgetContainer5 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                            if (fileMetadata.isRegularFile || fileMetadata.isDirectory) {
                                ArrayList arrayList11 = constraintWidgetContainer5.mChildren;
                                int size12 = arrayList11.size();
                                int i100 = 0;
                                while (i100 < size12) {
                                    Object obj2 = arrayList11.get(i100);
                                    int i101 = i100 + 1;
                                    ConstraintWidget constraintWidget20 = (ConstraintWidget) obj2;
                                    constraintWidget20.measured = false;
                                    constraintWidget20.horizontalRun.reset();
                                    constraintWidget20.verticalRun.reset();
                                    arrayList11 = arrayList11;
                                    i100 = i101;
                                }
                                i30 = 0;
                                constraintWidgetContainer5.measured = false;
                                constraintWidgetContainer5.horizontalRun.reset();
                                constraintWidgetContainer5.verticalRun.reset();
                                fileMetadata.isDirectory = false;
                            } else {
                                i30 = 0;
                            }
                            fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                            constraintWidgetContainer5.mX = i30;
                            int[] iArr6 = constraintWidgetContainer5.mListDimensionBehaviors;
                            VerticalWidgetRun verticalWidgetRun3 = constraintWidgetContainer5.verticalRun;
                            HorizontalWidgetRun horizontalWidgetRun3 = constraintWidgetContainer5.horizontalRun;
                            constraintWidgetContainer5.mY = i30;
                            measurer2 = measurer;
                            int dimensionBehaviour2 = constraintWidgetContainer5.getDimensionBehaviour(i30);
                            arrayList2 = arrayList;
                            int dimensionBehaviour3 = constraintWidgetContainer5.getDimensionBehaviour(1);
                            if (fileMetadata.isRegularFile) {
                                fileMetadata.buildGraph();
                            }
                            int x = constraintWidgetContainer5.getX();
                            constraintWidgetContainer2 = constraintWidgetContainer;
                            int y = constraintWidgetContainer5.getY();
                            i12 = width2;
                            DependencyNode dependencyNode = horizontalWidgetRun3.start;
                            i13 = height;
                            DimensionDependency dimensionDependency = horizontalWidgetRun3.dimension;
                            dependencyNode.resolve(x);
                            DependencyNode dependencyNode2 = verticalWidgetRun3.start;
                            DimensionDependency dimensionDependency2 = verticalWidgetRun3.dimension;
                            dependencyNode2.resolve(y);
                            fileMetadata.measureWidgets();
                            if (dimensionBehaviour2 == 2 || dimensionBehaviour3 == 2) {
                                if (z) {
                                    int size13 = arrayList10.size();
                                    i31 = y;
                                    int i102 = 0;
                                    while (i102 < size13) {
                                        Object obj3 = arrayList10.get(i102);
                                        i102++;
                                        if (!((WidgetRun) obj3).supportsWrapComputation()) {
                                            z = false;
                                            break;
                                        }
                                    }
                                } else {
                                    i31 = y;
                                }
                                if (z && dimensionBehaviour2 == 2) {
                                    constraintWidgetContainer5.setHorizontalDimensionBehaviour(1);
                                    constraintWidgetContainer5.setWidth(fileMetadata.computeWrap(constraintWidgetContainer5, 0));
                                    dimensionDependency.resolve(constraintWidgetContainer5.getWidth());
                                }
                                if (z && dimensionBehaviour3 == 2) {
                                    i32 = 1;
                                    constraintWidgetContainer5.setVerticalDimensionBehaviour(1);
                                    constraintWidgetContainer5.setHeight(fileMetadata.computeWrap(constraintWidgetContainer5, 1));
                                    dimensionDependency2.resolve(constraintWidgetContainer5.getHeight());
                                }
                                i33 = iArr6[0];
                                if (i33 != i32 || i33 == 4) {
                                    int width5 = constraintWidgetContainer5.getWidth() + x;
                                    horizontalWidgetRun3.end.resolve(width5);
                                    dimensionDependency.resolve(width5 - x);
                                    fileMetadata.measureWidgets();
                                    i34 = iArr6[1];
                                    if (i34 != 1 || i34 == 4) {
                                        int height4 = constraintWidgetContainer5.getHeight() + i31;
                                        verticalWidgetRun3.end.resolve(height4);
                                        dimensionDependency2.resolve(height4 - i31);
                                    }
                                    fileMetadata.measureWidgets();
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                size6 = arrayList10.size();
                                i35 = 0;
                                while (i35 < size6) {
                                    Object obj4 = arrayList10.get(i35);
                                    i35++;
                                    widgetRun2 = (WidgetRun) obj4;
                                    if (widgetRun2.widget == constraintWidgetContainer5 || widgetRun2.resolved) {
                                        widgetRun2.applyToWidget();
                                    }
                                }
                                size7 = arrayList10.size();
                                i36 = 0;
                                while (true) {
                                    if (i36 < size7) {
                                        z17 = true;
                                        break;
                                    }
                                    Object obj5 = arrayList10.get(i36);
                                    i36++;
                                    widgetRun = (WidgetRun) obj5;
                                    if (!z16 || widgetRun.widget != constraintWidgetContainer5) {
                                        if (widgetRun.start.resolved || ((!widgetRun.end.resolved && !(widgetRun instanceof GuidelineReference)) || (!widgetRun.dimension.resolved && !(widgetRun instanceof ChainRun) && !(widgetRun instanceof GuidelineReference)))) {
                                            z17 = false;
                                            break;
                                        }
                                    }
                                }
                                constraintWidgetContainer5.setHorizontalDimensionBehaviour(dimensionBehaviour2);
                                constraintWidgetContainer5.setVerticalDimensionBehaviour(dimensionBehaviour3);
                                zDirectMeasureWithOrientation = z17;
                                i14 = 2;
                                i28 = 1073741824;
                            } else {
                                i31 = y;
                            }
                            i32 = 1;
                            i33 = iArr6[0];
                            if (i33 != i32) {
                                int width6 = constraintWidgetContainer5.getWidth() + x;
                                horizontalWidgetRun3.end.resolve(width6);
                                dimensionDependency.resolve(width6 - x);
                                fileMetadata.measureWidgets();
                                i34 = iArr6[1];
                                if (i34 != 1) {
                                    int height5 = constraintWidgetContainer5.getHeight() + i31;
                                    verticalWidgetRun3.end.resolve(height5);
                                    dimensionDependency2.resolve(height5 - i31);
                                } else {
                                    int height6 = constraintWidgetContainer5.getHeight() + i31;
                                    verticalWidgetRun3.end.resolve(height6);
                                    dimensionDependency2.resolve(height6 - i31);
                                }
                                fileMetadata.measureWidgets();
                                z16 = true;
                            } else {
                                int width7 = constraintWidgetContainer5.getWidth() + x;
                                horizontalWidgetRun3.end.resolve(width7);
                                dimensionDependency.resolve(width7 - x);
                                fileMetadata.measureWidgets();
                                i34 = iArr6[1];
                                if (i34 != 1) {
                                    int height7 = constraintWidgetContainer5.getHeight() + i31;
                                    verticalWidgetRun3.end.resolve(height7);
                                    dimensionDependency2.resolve(height7 - i31);
                                } else {
                                    int height8 = constraintWidgetContainer5.getHeight() + i31;
                                    verticalWidgetRun3.end.resolve(height8);
                                    dimensionDependency2.resolve(height8 - i31);
                                }
                                fileMetadata.measureWidgets();
                                z16 = true;
                            }
                            size6 = arrayList10.size();
                            i35 = 0;
                            while (i35 < size6) {
                                Object obj6 = arrayList10.get(i35);
                                i35++;
                                widgetRun2 = (WidgetRun) obj6;
                                if (widgetRun2.widget == constraintWidgetContainer5) {
                                }
                                widgetRun2.applyToWidget();
                            }
                            size7 = arrayList10.size();
                            i36 = 0;
                            while (true) {
                                if (i36 < size7) {
                                    z17 = true;
                                    break;
                                }
                                Object obj7 = arrayList10.get(i36);
                                i36++;
                                widgetRun = (WidgetRun) obj7;
                                if (!z16) {
                                }
                                if (widgetRun.start.resolved) {
                                }
                                z17 = false;
                                break;
                            }
                            constraintWidgetContainer5.setHorizontalDimensionBehaviour(dimensionBehaviour2);
                            constraintWidgetContainer5.setVerticalDimensionBehaviour(dimensionBehaviour3);
                            zDirectMeasureWithOrientation = z17;
                            i14 = 2;
                            i28 = 1073741824;
                        }
                        if (zDirectMeasureWithOrientation) {
                            if (mode == i28) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (mode2 == i28) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            constraintWidgetContainer4.updateFromRuns(z14, z15);
                        }
                    } else {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        arrayList2 = arrayList;
                        measurer2 = measurer;
                        i12 = width2;
                        i13 = height;
                        i14 = 0;
                        zDirectMeasureWithOrientation = false;
                    }
                    if (zDirectMeasureWithOrientation || i14 != 2) {
                        if (i10 > 0) {
                            size3 = constraintWidgetContainer4.mChildren.size();
                            measurer4 = constraintWidgetContainer4.mMeasurer;
                            for (i23 = 0; i23 < size3; i23++) {
                                constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                                if ((constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) && (!constraintWidget2.horizontalRun.dimension.resolved || !constraintWidget2.verticalRun.dimension.resolved)) {
                                    dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                                    int dimensionBehaviour4 = constraintWidget2.getDimensionBehaviour(1);
                                    if (dimensionBehaviour == 3 || constraintWidget2.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour4 != 3 || constraintWidget2.mMatchConstraintDefaultHeight == 1) {
                                        menuHostHelper.measure(measurer4, constraintWidget2, false);
                                    }
                                }
                            }
                            constraintLayout = measurer4.layout;
                            childCount = constraintLayout.getChildCount();
                            arrayList4 = constraintLayout.mConstraintHelpers;
                            for (i24 = 0; i24 < childCount; i24++) {
                                constraintLayout.getChildAt(i24);
                            }
                            size4 = arrayList4.size();
                            if (size4 > 0) {
                                for (i25 = 0; i25 < size4; i25++) {
                                    ((ConstraintHelper) arrayList4.get(i25)).getClass();
                                }
                            }
                        }
                        i15 = constraintWidgetContainer4.mOptimizationLevel;
                        size2 = arrayList2.size();
                        i16 = i12;
                        i17 = i13;
                        if (i10 > 0) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        }
                        if (size2 > 0) {
                            iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                            if (iArr3[0] == 2) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (iArr3[1] == 2) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            ConstraintWidgetContainer constraintWidgetContainer6 = constraintWidgetContainer2;
                            int iMax9 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer6.mMinWidth);
                            int iMax10 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer6.mMinHeight);
                            for (i18 = 0; i18 < size2; i18++) {
                            }
                            arrayList3 = arrayList2;
                            iMax3 = iMax9;
                            iMax4 = iMax10;
                            i19 = 0;
                            z7 = false;
                            while (i19 < 2) {
                                zMeasure = z7;
                                i20 = 0;
                                while (i20 < size2) {
                                    constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                                    if ((constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                                        i21 = size2;
                                        if (constraintWidget.mVisibility == 8 && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                                            width3 = constraintWidget.getWidth();
                                            height2 = constraintWidget.getHeight();
                                            z10 = z6;
                                            int i103 = constraintWidget.mBaselineDistance;
                                            Measurer measurer6 = measurer2;
                                            i22 = i19;
                                            z11 = z5;
                                            zMeasure |= menuHostHelper.measure(measurer6, constraintWidget, true);
                                            width4 = constraintWidget.getWidth();
                                            measurer3 = measurer6;
                                            height3 = constraintWidget.getHeight();
                                            if (width4 != width3) {
                                                constraintWidget.setWidth(width4);
                                                if (!z11 && constraintWidget.getX() + constraintWidget.mWidth > iMax3) {
                                                    iMax3 = Math.max(iMax3, constraintWidget.getAnchor(4).getMargin() + constraintWidget.getX() + constraintWidget.mWidth);
                                                }
                                                zMeasure = true;
                                            }
                                            if (height3 != height2) {
                                                constraintWidget.setHeight(height3);
                                                if (!z10 && constraintWidget.getY() + constraintWidget.mHeight > iMax4) {
                                                    iMax4 = Math.max(iMax4, constraintWidget.getAnchor(5).getMargin() + constraintWidget.getY() + constraintWidget.mHeight);
                                                }
                                                zMeasure = true;
                                            }
                                            if (!constraintWidget.hasBaseline && i103 != constraintWidget.mBaselineDistance) {
                                                zMeasure = true;
                                            }
                                        }
                                        i20++;
                                        size2 = i21;
                                        i19 = i22;
                                        z6 = z10;
                                        z5 = z11;
                                        measurer2 = measurer3;
                                    } else {
                                        i21 = size2;
                                    }
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                    i20++;
                                    size2 = i21;
                                    i19 = i22;
                                    z6 = z10;
                                    z5 = z11;
                                    measurer2 = measurer3;
                                }
                                int i104 = size2;
                                boolean z26 = z6;
                                boolean z27 = z5;
                                Measurer measurer7 = measurer2;
                                int i105 = i19;
                                if (zMeasure) {
                                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                    z7 = false;
                                } else {
                                    z7 = zMeasure;
                                }
                                i19 = i105 + 1;
                                size2 = i104;
                                z6 = z26;
                                z5 = z27;
                                measurer2 = measurer7;
                            }
                            if (z7) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                if (constraintWidgetContainer4.getWidth() < iMax3) {
                                    constraintWidgetContainer4.setWidth(iMax3);
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                if (constraintWidgetContainer4.getHeight() < iMax4) {
                                    constraintWidgetContainer4.setHeight(iMax4);
                                    z9 = true;
                                } else {
                                    z9 = z8;
                                }
                                if (z9) {
                                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                }
                            }
                        }
                        constraintWidgetContainer4.mOptimizationLevel = i15;
                        if ((i15 & 256) == 256) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        LinearSystem.OPTIMIZED_ENGINE = z4;
                    }
                    int width8 = constraintWidgetContainer4.getWidth();
                    int height9 = constraintWidgetContainer4.getHeight();
                    z12 = constraintWidgetContainer4.mWidthMeasuredTooSmall;
                    z13 = constraintWidgetContainer4.mHeightMeasuredTooSmall;
                    Measurer measurer8 = measurer5;
                    int i106 = measurer8.paddingHeight;
                    int iResolveSizeAndState = View.resolveSizeAndState(width8 + measurer8.paddingWidth, i, 0);
                    int iResolveSizeAndState2 = View.resolveSizeAndState(height9 + i106, i2, 0) & 16777215;
                    iMin = Math.min(this.mMaxWidth, iResolveSizeAndState & 16777215);
                    iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState2);
                    if (z12) {
                        iMin |= 16777216;
                    }
                    if (z13) {
                        iMin2 |= 16777216;
                    }
                    setMeasuredDimension(iMin, iMin2);
                }
                iArr2 = iArr;
                z2 = true;
                if (z2) {
                    i37 = 0;
                    while (true) {
                        if (i37 < size) {
                            z18 = z2;
                            constraintWidget3 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i37);
                            i10 = size;
                            iArr4 = constraintWidget3.mListDimensionBehaviors;
                            i38 = i37;
                            if (iArr4[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr4[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (!z19) {
                            }
                            if (constraintWidget3.isInHorizontalChain()) {
                                i37 = i38 + 1;
                                z2 = z18;
                                size = i10;
                            } else {
                                i37 = i38 + 1;
                                z2 = z18;
                                size = i10;
                            }
                            i11 = 1073741824;
                            z3 = false;
                        } else {
                            z3 = z2;
                            i10 = size;
                            i11 = 1073741824;
                        }
                    }
                } else {
                    z3 = z2;
                    i10 = size;
                    i11 = 1073741824;
                }
                if (z3 && ((mode != i11 && mode2 == i11) || z)) {
                    iMin3 = Math.min(iArr2[0], i96);
                    iMin4 = Math.min(iArr2[1], i97);
                    i26 = 1073741824;
                    if (mode == 1073741824) {
                        if (constraintWidgetContainer4.getWidth() != iMin3) {
                            constraintWidgetContainer4.setWidth(iMin3);
                            fileMetadata.isRegularFile = true;
                        }
                        i26 = 1073741824;
                    }
                    if (mode2 == i26) {
                        constraintWidgetContainer4.setHeight(iMin4);
                        fileMetadata.isRegularFile = true;
                    }
                    if (mode == i26) {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        arrayList2 = arrayList;
                        measurer2 = measurer;
                        i12 = width2;
                        i13 = height;
                        constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                        if (fileMetadata.isRegularFile) {
                            arrayList5 = constraintWidgetContainer3.mChildren;
                            size5 = arrayList5.size();
                            i29 = 0;
                            while (i29 < size5) {
                                Object obj8 = arrayList5.get(i29);
                                i29++;
                                ConstraintWidget constraintWidget110 = (ConstraintWidget) obj8;
                                constraintWidget110.measured = false;
                                HorizontalWidgetRun horizontalWidgetRun4 = constraintWidget110.horizontalRun;
                                horizontalWidgetRun4.dimension.resolved = false;
                                horizontalWidgetRun4.resolved = false;
                                horizontalWidgetRun4.reset();
                                VerticalWidgetRun verticalWidgetRun4 = constraintWidget110.verticalRun;
                                verticalWidgetRun4.dimension.resolved = false;
                                verticalWidgetRun4.resolved = false;
                                verticalWidgetRun4.reset();
                            }
                            i27 = 0;
                            constraintWidgetContainer3.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun5 = constraintWidgetContainer3.horizontalRun;
                            horizontalWidgetRun5.dimension.resolved = false;
                            horizontalWidgetRun5.resolved = false;
                            horizontalWidgetRun5.reset();
                            VerticalWidgetRun verticalWidgetRun5 = constraintWidgetContainer3.verticalRun;
                            verticalWidgetRun5.dimension.resolved = false;
                            verticalWidgetRun5.resolved = false;
                            verticalWidgetRun5.reset();
                            fileMetadata.buildGraph();
                        } else {
                            i27 = 0;
                        }
                        fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                        constraintWidgetContainer3.mX = i27;
                        constraintWidgetContainer3.mY = i27;
                        constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                        constraintWidgetContainer3.verticalRun.start.resolve(i27);
                        i28 = 1073741824;
                        if (mode == 1073741824) {
                            zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zDirectMeasureWithOrientation = true;
                        }
                        if (mode2 == 1073741824) {
                            zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                            i14++;
                        }
                    } else {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        arrayList2 = arrayList;
                        measurer2 = measurer;
                        i12 = width2;
                        i13 = height;
                        constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                        if (fileMetadata.isRegularFile) {
                            arrayList5 = constraintWidgetContainer3.mChildren;
                            size5 = arrayList5.size();
                            i29 = 0;
                            while (i29 < size5) {
                                Object obj9 = arrayList5.get(i29);
                                i29++;
                                ConstraintWidget constraintWidget111 = (ConstraintWidget) obj9;
                                constraintWidget111.measured = false;
                                HorizontalWidgetRun horizontalWidgetRun6 = constraintWidget111.horizontalRun;
                                horizontalWidgetRun6.dimension.resolved = false;
                                horizontalWidgetRun6.resolved = false;
                                horizontalWidgetRun6.reset();
                                VerticalWidgetRun verticalWidgetRun6 = constraintWidget111.verticalRun;
                                verticalWidgetRun6.dimension.resolved = false;
                                verticalWidgetRun6.resolved = false;
                                verticalWidgetRun6.reset();
                            }
                            i27 = 0;
                            constraintWidgetContainer3.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun7 = constraintWidgetContainer3.horizontalRun;
                            horizontalWidgetRun7.dimension.resolved = false;
                            horizontalWidgetRun7.resolved = false;
                            horizontalWidgetRun7.reset();
                            VerticalWidgetRun verticalWidgetRun7 = constraintWidgetContainer3.verticalRun;
                            verticalWidgetRun7.dimension.resolved = false;
                            verticalWidgetRun7.resolved = false;
                            verticalWidgetRun7.reset();
                            fileMetadata.buildGraph();
                        } else {
                            i27 = 0;
                        }
                        fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                        constraintWidgetContainer3.mX = i27;
                        constraintWidgetContainer3.mY = i27;
                        constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                        constraintWidgetContainer3.verticalRun.start.resolve(i27);
                        i28 = 1073741824;
                        if (mode == 1073741824) {
                            zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zDirectMeasureWithOrientation = true;
                        }
                        if (mode2 == 1073741824) {
                            zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                            i14++;
                        }
                    }
                    if (zDirectMeasureWithOrientation) {
                        if (mode == i28) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i28) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        constraintWidgetContainer4.updateFromRuns(z14, z15);
                    }
                } else {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    i14 = 0;
                    zDirectMeasureWithOrientation = false;
                }
                if (zDirectMeasureWithOrientation) {
                    if (i10 > 0) {
                        size3 = constraintWidgetContainer4.mChildren.size();
                        measurer4 = constraintWidgetContainer4.mMeasurer;
                        while (i23 < size3) {
                            constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                            if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                                dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                                int dimensionBehaviour5 = constraintWidget2.getDimensionBehaviour(1);
                                if (dimensionBehaviour == 3) {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                } else {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                }
                            }
                        }
                        constraintLayout = measurer4.layout;
                        childCount = constraintLayout.getChildCount();
                        arrayList4 = constraintLayout.mConstraintHelpers;
                        while (i24 < childCount) {
                            constraintLayout.getChildAt(i24);
                        }
                        size4 = arrayList4.size();
                        if (size4 > 0) {
                            while (i25 < size4) {
                                ((ConstraintHelper) arrayList4.get(i25)).getClass();
                            }
                        }
                    }
                    i15 = constraintWidgetContainer4.mOptimizationLevel;
                    size2 = arrayList2.size();
                    i16 = i12;
                    i17 = i13;
                    if (i10 > 0) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    }
                    if (size2 > 0) {
                        iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                        if (iArr3[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr3[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        ConstraintWidgetContainer constraintWidgetContainer7 = constraintWidgetContainer2;
                        int iMax11 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer7.mMinWidth);
                        int iMax12 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer7.mMinHeight);
                        while (i18 < size2) {
                        }
                        arrayList3 = arrayList2;
                        iMax3 = iMax11;
                        iMax4 = iMax12;
                        i19 = 0;
                        z7 = false;
                        while (i19 < 2) {
                            zMeasure = z7;
                            i20 = 0;
                            while (i20 < size2) {
                                constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                                if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                    i21 = size2;
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    i21 = size2;
                                    if (constraintWidget.mVisibility == 8) {
                                        z10 = z6;
                                        z11 = z5;
                                        measurer3 = measurer2;
                                        i22 = i19;
                                    } else {
                                        width3 = constraintWidget.getWidth();
                                        height2 = constraintWidget.getHeight();
                                        z10 = z6;
                                        int i107 = constraintWidget.mBaselineDistance;
                                        Measurer measurer9 = measurer2;
                                        i22 = i19;
                                        z11 = z5;
                                        zMeasure |= menuHostHelper.measure(measurer9, constraintWidget, true);
                                        width4 = constraintWidget.getWidth();
                                        measurer3 = measurer9;
                                        height3 = constraintWidget.getHeight();
                                        if (width4 != width3) {
                                            constraintWidget.setWidth(width4);
                                            if (!z11) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (height3 != height2) {
                                            constraintWidget.setHeight(height3);
                                            if (!z10) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (!constraintWidget.hasBaseline) {
                                        }
                                    }
                                }
                                i20++;
                                size2 = i21;
                                i19 = i22;
                                z6 = z10;
                                z5 = z11;
                                measurer2 = measurer3;
                            }
                            int i108 = size2;
                            boolean z28 = z6;
                            boolean z29 = z5;
                            Measurer measurer10 = measurer2;
                            int i109 = i19;
                            if (zMeasure) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                z7 = false;
                            } else {
                                z7 = zMeasure;
                            }
                            i19 = i109 + 1;
                            size2 = i108;
                            z6 = z28;
                            z5 = z29;
                            measurer2 = measurer10;
                        }
                        if (z7) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            if (constraintWidgetContainer4.getWidth() < iMax3) {
                                constraintWidgetContainer4.setWidth(iMax3);
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (constraintWidgetContainer4.getHeight() < iMax4) {
                                constraintWidgetContainer4.setHeight(iMax4);
                                z9 = true;
                            } else {
                                z9 = z8;
                            }
                            if (z9) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            }
                        }
                    }
                    constraintWidgetContainer4.mOptimizationLevel = i15;
                    if ((i15 & 256) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    LinearSystem.OPTIMIZED_ENGINE = z4;
                } else {
                    if (i10 > 0) {
                        size3 = constraintWidgetContainer4.mChildren.size();
                        measurer4 = constraintWidgetContainer4.mMeasurer;
                        while (i23 < size3) {
                            constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                            if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                                dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                                int dimensionBehaviour6 = constraintWidget2.getDimensionBehaviour(1);
                                if (dimensionBehaviour == 3) {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                } else {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                }
                            }
                        }
                        constraintLayout = measurer4.layout;
                        childCount = constraintLayout.getChildCount();
                        arrayList4 = constraintLayout.mConstraintHelpers;
                        while (i24 < childCount) {
                            constraintLayout.getChildAt(i24);
                        }
                        size4 = arrayList4.size();
                        if (size4 > 0) {
                            while (i25 < size4) {
                                ((ConstraintHelper) arrayList4.get(i25)).getClass();
                            }
                        }
                    }
                    i15 = constraintWidgetContainer4.mOptimizationLevel;
                    size2 = arrayList2.size();
                    i16 = i12;
                    i17 = i13;
                    if (i10 > 0) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    }
                    if (size2 > 0) {
                        iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                        if (iArr3[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr3[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        ConstraintWidgetContainer constraintWidgetContainer8 = constraintWidgetContainer2;
                        int iMax13 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer8.mMinWidth);
                        int iMax14 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer8.mMinHeight);
                        while (i18 < size2) {
                        }
                        arrayList3 = arrayList2;
                        iMax3 = iMax13;
                        iMax4 = iMax14;
                        i19 = 0;
                        z7 = false;
                        while (i19 < 2) {
                            zMeasure = z7;
                            i20 = 0;
                            while (i20 < size2) {
                                constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                                if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                    i21 = size2;
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    i21 = size2;
                                    if (constraintWidget.mVisibility == 8) {
                                        z10 = z6;
                                        z11 = z5;
                                        measurer3 = measurer2;
                                        i22 = i19;
                                    } else {
                                        width3 = constraintWidget.getWidth();
                                        height2 = constraintWidget.getHeight();
                                        z10 = z6;
                                        int i1010 = constraintWidget.mBaselineDistance;
                                        Measurer measurer11 = measurer2;
                                        i22 = i19;
                                        z11 = z5;
                                        zMeasure |= menuHostHelper.measure(measurer11, constraintWidget, true);
                                        width4 = constraintWidget.getWidth();
                                        measurer3 = measurer11;
                                        height3 = constraintWidget.getHeight();
                                        if (width4 != width3) {
                                            constraintWidget.setWidth(width4);
                                            if (!z11) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (height3 != height2) {
                                            constraintWidget.setHeight(height3);
                                            if (!z10) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (!constraintWidget.hasBaseline) {
                                        }
                                    }
                                }
                                i20++;
                                size2 = i21;
                                i19 = i22;
                                z6 = z10;
                                z5 = z11;
                                measurer2 = measurer3;
                            }
                            int i1011 = size2;
                            boolean z210 = z6;
                            boolean z211 = z5;
                            Measurer measurer12 = measurer2;
                            int i1012 = i19;
                            if (zMeasure) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                z7 = false;
                            } else {
                                z7 = zMeasure;
                            }
                            i19 = i1012 + 1;
                            size2 = i1011;
                            z6 = z210;
                            z5 = z211;
                            measurer2 = measurer12;
                        }
                        if (z7) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            if (constraintWidgetContainer4.getWidth() < iMax3) {
                                constraintWidgetContainer4.setWidth(iMax3);
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (constraintWidgetContainer4.getHeight() < iMax4) {
                                constraintWidgetContainer4.setHeight(iMax4);
                                z9 = true;
                            } else {
                                z9 = z8;
                            }
                            if (z9) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            }
                        }
                    }
                    constraintWidgetContainer4.mOptimizationLevel = i15;
                    if ((i15 & 256) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    LinearSystem.OPTIMIZED_ENGINE = z4;
                }
                int width9 = constraintWidgetContainer4.getWidth();
                int height10 = constraintWidgetContainer4.getHeight();
                z12 = constraintWidgetContainer4.mWidthMeasuredTooSmall;
                z13 = constraintWidgetContainer4.mHeightMeasuredTooSmall;
                Measurer measurer13 = measurer5;
                int i1013 = measurer13.paddingHeight;
                int iResolveSizeAndState3 = View.resolveSizeAndState(width9 + measurer13.paddingWidth, i, 0);
                int iResolveSizeAndState4 = View.resolveSizeAndState(height10 + i1013, i2, 0) & 16777215;
                iMin = Math.min(this.mMaxWidth, iResolveSizeAndState3 & 16777215);
                iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState4);
                if (z12) {
                    iMin |= 16777216;
                }
                if (z13) {
                    iMin2 |= 16777216;
                }
                setMeasuredDimension(iMin, iMin2);
            }
            if (childCount4 == 0) {
                iMax2 = Math.max(0, this.mMinHeight);
            } else {
                iMax2 = i97;
            }
            i7 = 2;
            width = constraintWidgetContainer4.getWidth();
            iArr = constraintWidgetContainer4.mMaxDimension;
            if (iMax == width) {
                fileMetadata.isDirectory = true;
                c = 1;
            } else {
                fileMetadata.isDirectory = true;
                c = 1;
            }
            constraintWidgetContainer4.mX = 0;
            constraintWidgetContainer4.mY = 0;
            iArr[0] = this.mMaxWidth - i4;
            iArr[c] = this.mMaxHeight - i98;
            constraintWidgetContainer4.mMinWidth = 0;
            constraintWidgetContainer4.mMinHeight = 0;
            constraintWidgetContainer4.setHorizontalDimensionBehaviour(i6);
            constraintWidgetContainer4.setWidth(iMax);
            constraintWidgetContainer4.setVerticalDimensionBehaviour(i7);
            constraintWidgetContainer4.setHeight(iMax2);
            i8 = this.mMinWidth - i4;
            if (i8 < 0) {
                constraintWidgetContainer4.mMinWidth = 0;
            } else {
                constraintWidgetContainer4.mMinWidth = i8;
            }
            i9 = this.mMinHeight - i98;
            if (i9 < 0) {
                constraintWidgetContainer4.mMinHeight = 0;
            } else {
                constraintWidgetContainer4.mMinHeight = i9;
            }
            constraintWidgetContainer4.mPaddingLeft = iMax7;
            constraintWidgetContainer4.mPaddingTop = iMax5;
            constraintWidgetContainer = (ConstraintWidgetContainer) menuHostHelper.mProviderToLifecycleContainers;
            arrayList = (ArrayList) menuHostHelper.mOnInvalidateMenuCallback;
            measurer = constraintWidgetContainer4.mMeasurer;
            size = constraintWidgetContainer4.mChildren.size();
            width2 = constraintWidgetContainer4.getWidth();
            height = constraintWidgetContainer4.getHeight();
            if ((i94 & 128) == 128) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                iArr2 = iArr;
                if ((i94 & 64) == 64) {
                    z2 = false;
                }
                if (z2) {
                    i37 = 0;
                    while (true) {
                        if (i37 < size) {
                            z18 = z2;
                            constraintWidget3 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i37);
                            i10 = size;
                            iArr4 = constraintWidget3.mListDimensionBehaviors;
                            i38 = i37;
                            if (iArr4[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr4[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (!z19) {
                            }
                            if (constraintWidget3.isInHorizontalChain()) {
                                i37 = i38 + 1;
                                z2 = z18;
                                size = i10;
                            } else {
                                i37 = i38 + 1;
                                z2 = z18;
                                size = i10;
                            }
                            i11 = 1073741824;
                            z3 = false;
                        } else {
                            z3 = z2;
                            i10 = size;
                            i11 = 1073741824;
                        }
                    }
                } else {
                    z3 = z2;
                    i10 = size;
                    i11 = 1073741824;
                }
                if (z3 && ((mode != i11 && mode2 == i11) || z)) {
                    iMin3 = Math.min(iArr2[0], i96);
                    iMin4 = Math.min(iArr2[1], i97);
                    i26 = 1073741824;
                    if (mode == 1073741824) {
                        if (constraintWidgetContainer4.getWidth() != iMin3) {
                            constraintWidgetContainer4.setWidth(iMin3);
                            fileMetadata.isRegularFile = true;
                        }
                        i26 = 1073741824;
                    }
                    if (mode2 == i26) {
                        constraintWidgetContainer4.setHeight(iMin4);
                        fileMetadata.isRegularFile = true;
                    }
                    if (mode == i26) {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        arrayList2 = arrayList;
                        measurer2 = measurer;
                        i12 = width2;
                        i13 = height;
                        constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                        if (fileMetadata.isRegularFile) {
                            arrayList5 = constraintWidgetContainer3.mChildren;
                            size5 = arrayList5.size();
                            i29 = 0;
                            while (i29 < size5) {
                                Object obj10 = arrayList5.get(i29);
                                i29++;
                                ConstraintWidget constraintWidget112 = (ConstraintWidget) obj10;
                                constraintWidget112.measured = false;
                                HorizontalWidgetRun horizontalWidgetRun8 = constraintWidget112.horizontalRun;
                                horizontalWidgetRun8.dimension.resolved = false;
                                horizontalWidgetRun8.resolved = false;
                                horizontalWidgetRun8.reset();
                                VerticalWidgetRun verticalWidgetRun8 = constraintWidget112.verticalRun;
                                verticalWidgetRun8.dimension.resolved = false;
                                verticalWidgetRun8.resolved = false;
                                verticalWidgetRun8.reset();
                            }
                            i27 = 0;
                            constraintWidgetContainer3.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun9 = constraintWidgetContainer3.horizontalRun;
                            horizontalWidgetRun9.dimension.resolved = false;
                            horizontalWidgetRun9.resolved = false;
                            horizontalWidgetRun9.reset();
                            VerticalWidgetRun verticalWidgetRun9 = constraintWidgetContainer3.verticalRun;
                            verticalWidgetRun9.dimension.resolved = false;
                            verticalWidgetRun9.resolved = false;
                            verticalWidgetRun9.reset();
                            fileMetadata.buildGraph();
                        } else {
                            i27 = 0;
                        }
                        fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                        constraintWidgetContainer3.mX = i27;
                        constraintWidgetContainer3.mY = i27;
                        constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                        constraintWidgetContainer3.verticalRun.start.resolve(i27);
                        i28 = 1073741824;
                        if (mode == 1073741824) {
                            zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zDirectMeasureWithOrientation = true;
                        }
                        if (mode2 == 1073741824) {
                            zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                            i14++;
                        }
                    } else {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        arrayList2 = arrayList;
                        measurer2 = measurer;
                        i12 = width2;
                        i13 = height;
                        constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                        if (fileMetadata.isRegularFile) {
                            arrayList5 = constraintWidgetContainer3.mChildren;
                            size5 = arrayList5.size();
                            i29 = 0;
                            while (i29 < size5) {
                                Object obj11 = arrayList5.get(i29);
                                i29++;
                                ConstraintWidget constraintWidget113 = (ConstraintWidget) obj11;
                                constraintWidget113.measured = false;
                                HorizontalWidgetRun horizontalWidgetRun10 = constraintWidget113.horizontalRun;
                                horizontalWidgetRun10.dimension.resolved = false;
                                horizontalWidgetRun10.resolved = false;
                                horizontalWidgetRun10.reset();
                                VerticalWidgetRun verticalWidgetRun10 = constraintWidget113.verticalRun;
                                verticalWidgetRun10.dimension.resolved = false;
                                verticalWidgetRun10.resolved = false;
                                verticalWidgetRun10.reset();
                            }
                            i27 = 0;
                            constraintWidgetContainer3.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun11 = constraintWidgetContainer3.horizontalRun;
                            horizontalWidgetRun11.dimension.resolved = false;
                            horizontalWidgetRun11.resolved = false;
                            horizontalWidgetRun11.reset();
                            VerticalWidgetRun verticalWidgetRun11 = constraintWidgetContainer3.verticalRun;
                            verticalWidgetRun11.dimension.resolved = false;
                            verticalWidgetRun11.resolved = false;
                            verticalWidgetRun11.reset();
                            fileMetadata.buildGraph();
                        } else {
                            i27 = 0;
                        }
                        fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                        constraintWidgetContainer3.mX = i27;
                        constraintWidgetContainer3.mY = i27;
                        constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                        constraintWidgetContainer3.verticalRun.start.resolve(i27);
                        i28 = 1073741824;
                        if (mode == 1073741824) {
                            zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zDirectMeasureWithOrientation = true;
                        }
                        if (mode2 == 1073741824) {
                            zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                            i14++;
                        }
                    }
                    if (zDirectMeasureWithOrientation) {
                        if (mode == i28) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i28) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        constraintWidgetContainer4.updateFromRuns(z14, z15);
                    }
                } else {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    i14 = 0;
                    zDirectMeasureWithOrientation = false;
                }
                if (zDirectMeasureWithOrientation) {
                    if (i10 > 0) {
                        size3 = constraintWidgetContainer4.mChildren.size();
                        measurer4 = constraintWidgetContainer4.mMeasurer;
                        while (i23 < size3) {
                            constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                            if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                                dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                                int dimensionBehaviour7 = constraintWidget2.getDimensionBehaviour(1);
                                if (dimensionBehaviour == 3) {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                } else {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                }
                            }
                        }
                        constraintLayout = measurer4.layout;
                        childCount = constraintLayout.getChildCount();
                        arrayList4 = constraintLayout.mConstraintHelpers;
                        while (i24 < childCount) {
                            constraintLayout.getChildAt(i24);
                        }
                        size4 = arrayList4.size();
                        if (size4 > 0) {
                            while (i25 < size4) {
                                ((ConstraintHelper) arrayList4.get(i25)).getClass();
                            }
                        }
                    }
                    i15 = constraintWidgetContainer4.mOptimizationLevel;
                    size2 = arrayList2.size();
                    i16 = i12;
                    i17 = i13;
                    if (i10 > 0) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    }
                    if (size2 > 0) {
                        iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                        if (iArr3[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr3[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        ConstraintWidgetContainer constraintWidgetContainer9 = constraintWidgetContainer2;
                        int iMax15 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer9.mMinWidth);
                        int iMax16 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer9.mMinHeight);
                        while (i18 < size2) {
                        }
                        arrayList3 = arrayList2;
                        iMax3 = iMax15;
                        iMax4 = iMax16;
                        i19 = 0;
                        z7 = false;
                        while (i19 < 2) {
                            zMeasure = z7;
                            i20 = 0;
                            while (i20 < size2) {
                                constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                                if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                    i21 = size2;
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    i21 = size2;
                                    if (constraintWidget.mVisibility == 8) {
                                        z10 = z6;
                                        z11 = z5;
                                        measurer3 = measurer2;
                                        i22 = i19;
                                    } else {
                                        width3 = constraintWidget.getWidth();
                                        height2 = constraintWidget.getHeight();
                                        z10 = z6;
                                        int i1014 = constraintWidget.mBaselineDistance;
                                        Measurer measurer14 = measurer2;
                                        i22 = i19;
                                        z11 = z5;
                                        zMeasure |= menuHostHelper.measure(measurer14, constraintWidget, true);
                                        width4 = constraintWidget.getWidth();
                                        measurer3 = measurer14;
                                        height3 = constraintWidget.getHeight();
                                        if (width4 != width3) {
                                            constraintWidget.setWidth(width4);
                                            if (!z11) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (height3 != height2) {
                                            constraintWidget.setHeight(height3);
                                            if (!z10) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (!constraintWidget.hasBaseline) {
                                        }
                                    }
                                }
                                i20++;
                                size2 = i21;
                                i19 = i22;
                                z6 = z10;
                                z5 = z11;
                                measurer2 = measurer3;
                            }
                            int i1015 = size2;
                            boolean z212 = z6;
                            boolean z213 = z5;
                            Measurer measurer15 = measurer2;
                            int i1016 = i19;
                            if (zMeasure) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                z7 = false;
                            } else {
                                z7 = zMeasure;
                            }
                            i19 = i1016 + 1;
                            size2 = i1015;
                            z6 = z212;
                            z5 = z213;
                            measurer2 = measurer15;
                        }
                        if (z7) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            if (constraintWidgetContainer4.getWidth() < iMax3) {
                                constraintWidgetContainer4.setWidth(iMax3);
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (constraintWidgetContainer4.getHeight() < iMax4) {
                                constraintWidgetContainer4.setHeight(iMax4);
                                z9 = true;
                            } else {
                                z9 = z8;
                            }
                            if (z9) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            }
                        }
                    }
                    constraintWidgetContainer4.mOptimizationLevel = i15;
                    if ((i15 & 256) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    LinearSystem.OPTIMIZED_ENGINE = z4;
                } else {
                    if (i10 > 0) {
                        size3 = constraintWidgetContainer4.mChildren.size();
                        measurer4 = constraintWidgetContainer4.mMeasurer;
                        while (i23 < size3) {
                            constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                            if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                                dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                                int dimensionBehaviour8 = constraintWidget2.getDimensionBehaviour(1);
                                if (dimensionBehaviour == 3) {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                } else {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                }
                            }
                        }
                        constraintLayout = measurer4.layout;
                        childCount = constraintLayout.getChildCount();
                        arrayList4 = constraintLayout.mConstraintHelpers;
                        while (i24 < childCount) {
                            constraintLayout.getChildAt(i24);
                        }
                        size4 = arrayList4.size();
                        if (size4 > 0) {
                            while (i25 < size4) {
                                ((ConstraintHelper) arrayList4.get(i25)).getClass();
                            }
                        }
                    }
                    i15 = constraintWidgetContainer4.mOptimizationLevel;
                    size2 = arrayList2.size();
                    i16 = i12;
                    i17 = i13;
                    if (i10 > 0) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    }
                    if (size2 > 0) {
                        iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                        if (iArr3[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr3[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        ConstraintWidgetContainer constraintWidgetContainer10 = constraintWidgetContainer2;
                        int iMax17 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer10.mMinWidth);
                        int iMax18 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer10.mMinHeight);
                        while (i18 < size2) {
                        }
                        arrayList3 = arrayList2;
                        iMax3 = iMax17;
                        iMax4 = iMax18;
                        i19 = 0;
                        z7 = false;
                        while (i19 < 2) {
                            zMeasure = z7;
                            i20 = 0;
                            while (i20 < size2) {
                                constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                                if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                    i21 = size2;
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    i21 = size2;
                                    if (constraintWidget.mVisibility == 8) {
                                        z10 = z6;
                                        z11 = z5;
                                        measurer3 = measurer2;
                                        i22 = i19;
                                    } else {
                                        width3 = constraintWidget.getWidth();
                                        height2 = constraintWidget.getHeight();
                                        z10 = z6;
                                        int i1017 = constraintWidget.mBaselineDistance;
                                        Measurer measurer16 = measurer2;
                                        i22 = i19;
                                        z11 = z5;
                                        zMeasure |= menuHostHelper.measure(measurer16, constraintWidget, true);
                                        width4 = constraintWidget.getWidth();
                                        measurer3 = measurer16;
                                        height3 = constraintWidget.getHeight();
                                        if (width4 != width3) {
                                            constraintWidget.setWidth(width4);
                                            if (!z11) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (height3 != height2) {
                                            constraintWidget.setHeight(height3);
                                            if (!z10) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (!constraintWidget.hasBaseline) {
                                        }
                                    }
                                }
                                i20++;
                                size2 = i21;
                                i19 = i22;
                                z6 = z10;
                                z5 = z11;
                                measurer2 = measurer3;
                            }
                            int i1018 = size2;
                            boolean z214 = z6;
                            boolean z215 = z5;
                            Measurer measurer17 = measurer2;
                            int i1019 = i19;
                            if (zMeasure) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                z7 = false;
                            } else {
                                z7 = zMeasure;
                            }
                            i19 = i1019 + 1;
                            size2 = i1018;
                            z6 = z214;
                            z5 = z215;
                            measurer2 = measurer17;
                        }
                        if (z7) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            if (constraintWidgetContainer4.getWidth() < iMax3) {
                                constraintWidgetContainer4.setWidth(iMax3);
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (constraintWidgetContainer4.getHeight() < iMax4) {
                                constraintWidgetContainer4.setHeight(iMax4);
                                z9 = true;
                            } else {
                                z9 = z8;
                            }
                            if (z9) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            }
                        }
                    }
                    constraintWidgetContainer4.mOptimizationLevel = i15;
                    if ((i15 & 256) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    LinearSystem.OPTIMIZED_ENGINE = z4;
                }
                int width10 = constraintWidgetContainer4.getWidth();
                int height11 = constraintWidgetContainer4.getHeight();
                z12 = constraintWidgetContainer4.mWidthMeasuredTooSmall;
                z13 = constraintWidgetContainer4.mHeightMeasuredTooSmall;
                Measurer measurer18 = measurer5;
                int i10110 = measurer18.paddingHeight;
                int iResolveSizeAndState5 = View.resolveSizeAndState(width10 + measurer18.paddingWidth, i, 0);
                int iResolveSizeAndState6 = View.resolveSizeAndState(height11 + i10110, i2, 0) & 16777215;
                iMin = Math.min(this.mMaxWidth, iResolveSizeAndState5 & 16777215);
                iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState6);
                if (z12) {
                    iMin |= 16777216;
                }
                if (z13) {
                    iMin2 |= 16777216;
                }
                setMeasuredDimension(iMin, iMin2);
            }
            iArr2 = iArr;
            z2 = true;
            if (z2) {
                i37 = 0;
                while (true) {
                    if (i37 < size) {
                        z18 = z2;
                        constraintWidget3 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i37);
                        i10 = size;
                        iArr4 = constraintWidget3.mListDimensionBehaviors;
                        i38 = i37;
                        if (iArr4[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr4[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (!z19) {
                        }
                        if (constraintWidget3.isInHorizontalChain()) {
                            i37 = i38 + 1;
                            z2 = z18;
                            size = i10;
                        } else {
                            i37 = i38 + 1;
                            z2 = z18;
                            size = i10;
                        }
                        i11 = 1073741824;
                        z3 = false;
                    } else {
                        z3 = z2;
                        i10 = size;
                        i11 = 1073741824;
                    }
                }
            } else {
                z3 = z2;
                i10 = size;
                i11 = 1073741824;
            }
            if (z3 && ((mode != i11 && mode2 == i11) || z)) {
                iMin3 = Math.min(iArr2[0], i96);
                iMin4 = Math.min(iArr2[1], i97);
                i26 = 1073741824;
                if (mode == 1073741824) {
                    if (constraintWidgetContainer4.getWidth() != iMin3) {
                        constraintWidgetContainer4.setWidth(iMin3);
                        fileMetadata.isRegularFile = true;
                    }
                    i26 = 1073741824;
                }
                if (mode2 == i26) {
                    constraintWidgetContainer4.setHeight(iMin4);
                    fileMetadata.isRegularFile = true;
                }
                if (mode == i26) {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                    if (fileMetadata.isRegularFile) {
                        arrayList5 = constraintWidgetContainer3.mChildren;
                        size5 = arrayList5.size();
                        i29 = 0;
                        while (i29 < size5) {
                            Object obj12 = arrayList5.get(i29);
                            i29++;
                            ConstraintWidget constraintWidget114 = (ConstraintWidget) obj12;
                            constraintWidget114.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun12 = constraintWidget114.horizontalRun;
                            horizontalWidgetRun12.dimension.resolved = false;
                            horizontalWidgetRun12.resolved = false;
                            horizontalWidgetRun12.reset();
                            VerticalWidgetRun verticalWidgetRun12 = constraintWidget114.verticalRun;
                            verticalWidgetRun12.dimension.resolved = false;
                            verticalWidgetRun12.resolved = false;
                            verticalWidgetRun12.reset();
                        }
                        i27 = 0;
                        constraintWidgetContainer3.measured = false;
                        HorizontalWidgetRun horizontalWidgetRun13 = constraintWidgetContainer3.horizontalRun;
                        horizontalWidgetRun13.dimension.resolved = false;
                        horizontalWidgetRun13.resolved = false;
                        horizontalWidgetRun13.reset();
                        VerticalWidgetRun verticalWidgetRun13 = constraintWidgetContainer3.verticalRun;
                        verticalWidgetRun13.dimension.resolved = false;
                        verticalWidgetRun13.resolved = false;
                        verticalWidgetRun13.reset();
                        fileMetadata.buildGraph();
                    } else {
                        i27 = 0;
                    }
                    fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                    constraintWidgetContainer3.mX = i27;
                    constraintWidgetContainer3.mY = i27;
                    constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                    constraintWidgetContainer3.verticalRun.start.resolve(i27);
                    i28 = 1073741824;
                    if (mode == 1073741824) {
                        zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zDirectMeasureWithOrientation = true;
                    }
                    if (mode2 == 1073741824) {
                        zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                        i14++;
                    }
                } else {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                    if (fileMetadata.isRegularFile) {
                        arrayList5 = constraintWidgetContainer3.mChildren;
                        size5 = arrayList5.size();
                        i29 = 0;
                        while (i29 < size5) {
                            Object obj13 = arrayList5.get(i29);
                            i29++;
                            ConstraintWidget constraintWidget115 = (ConstraintWidget) obj13;
                            constraintWidget115.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun14 = constraintWidget115.horizontalRun;
                            horizontalWidgetRun14.dimension.resolved = false;
                            horizontalWidgetRun14.resolved = false;
                            horizontalWidgetRun14.reset();
                            VerticalWidgetRun verticalWidgetRun14 = constraintWidget115.verticalRun;
                            verticalWidgetRun14.dimension.resolved = false;
                            verticalWidgetRun14.resolved = false;
                            verticalWidgetRun14.reset();
                        }
                        i27 = 0;
                        constraintWidgetContainer3.measured = false;
                        HorizontalWidgetRun horizontalWidgetRun15 = constraintWidgetContainer3.horizontalRun;
                        horizontalWidgetRun15.dimension.resolved = false;
                        horizontalWidgetRun15.resolved = false;
                        horizontalWidgetRun15.reset();
                        VerticalWidgetRun verticalWidgetRun15 = constraintWidgetContainer3.verticalRun;
                        verticalWidgetRun15.dimension.resolved = false;
                        verticalWidgetRun15.resolved = false;
                        verticalWidgetRun15.reset();
                        fileMetadata.buildGraph();
                    } else {
                        i27 = 0;
                    }
                    fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                    constraintWidgetContainer3.mX = i27;
                    constraintWidgetContainer3.mY = i27;
                    constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                    constraintWidgetContainer3.verticalRun.start.resolve(i27);
                    i28 = 1073741824;
                    if (mode == 1073741824) {
                        zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zDirectMeasureWithOrientation = true;
                    }
                    if (mode2 == 1073741824) {
                        zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                        i14++;
                    }
                }
                if (zDirectMeasureWithOrientation) {
                    if (mode == i28) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i28) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    constraintWidgetContainer4.updateFromRuns(z14, z15);
                }
            } else {
                constraintWidgetContainer2 = constraintWidgetContainer;
                arrayList2 = arrayList;
                measurer2 = measurer;
                i12 = width2;
                i13 = height;
                i14 = 0;
                zDirectMeasureWithOrientation = false;
            }
            if (zDirectMeasureWithOrientation) {
                if (i10 > 0) {
                    size3 = constraintWidgetContainer4.mChildren.size();
                    measurer4 = constraintWidgetContainer4.mMeasurer;
                    while (i23 < size3) {
                        constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                        if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                            dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                            int dimensionBehaviour9 = constraintWidget2.getDimensionBehaviour(1);
                            if (dimensionBehaviour == 3) {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            } else {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            }
                        }
                    }
                    constraintLayout = measurer4.layout;
                    childCount = constraintLayout.getChildCount();
                    arrayList4 = constraintLayout.mConstraintHelpers;
                    while (i24 < childCount) {
                        constraintLayout.getChildAt(i24);
                    }
                    size4 = arrayList4.size();
                    if (size4 > 0) {
                        while (i25 < size4) {
                            ((ConstraintHelper) arrayList4.get(i25)).getClass();
                        }
                    }
                }
                i15 = constraintWidgetContainer4.mOptimizationLevel;
                size2 = arrayList2.size();
                i16 = i12;
                i17 = i13;
                if (i10 > 0) {
                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                }
                if (size2 > 0) {
                    iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                    if (iArr3[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr3[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ConstraintWidgetContainer constraintWidgetContainer11 = constraintWidgetContainer2;
                    int iMax19 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer11.mMinWidth);
                    int iMax110 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer11.mMinHeight);
                    while (i18 < size2) {
                    }
                    arrayList3 = arrayList2;
                    iMax3 = iMax19;
                    iMax4 = iMax110;
                    i19 = 0;
                    z7 = false;
                    while (i19 < 2) {
                        zMeasure = z7;
                        i20 = 0;
                        while (i20 < size2) {
                            constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                i21 = size2;
                                z10 = z6;
                                z11 = z5;
                                measurer3 = measurer2;
                                i22 = i19;
                            } else {
                                i21 = size2;
                                if (constraintWidget.mVisibility == 8) {
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    width3 = constraintWidget.getWidth();
                                    height2 = constraintWidget.getHeight();
                                    z10 = z6;
                                    int i10111 = constraintWidget.mBaselineDistance;
                                    Measurer measurer19 = measurer2;
                                    i22 = i19;
                                    z11 = z5;
                                    zMeasure |= menuHostHelper.measure(measurer19, constraintWidget, true);
                                    width4 = constraintWidget.getWidth();
                                    measurer3 = measurer19;
                                    height3 = constraintWidget.getHeight();
                                    if (width4 != width3) {
                                        constraintWidget.setWidth(width4);
                                        if (!z11) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (height3 != height2) {
                                        constraintWidget.setHeight(height3);
                                        if (!z10) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (!constraintWidget.hasBaseline) {
                                    }
                                }
                            }
                            i20++;
                            size2 = i21;
                            i19 = i22;
                            z6 = z10;
                            z5 = z11;
                            measurer2 = measurer3;
                        }
                        int i10112 = size2;
                        boolean z216 = z6;
                        boolean z217 = z5;
                        Measurer measurer110 = measurer2;
                        int i10113 = i19;
                        if (zMeasure) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            z7 = false;
                        } else {
                            z7 = zMeasure;
                        }
                        i19 = i10113 + 1;
                        size2 = i10112;
                        z6 = z216;
                        z5 = z217;
                        measurer2 = measurer110;
                    }
                    if (z7) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        if (constraintWidgetContainer4.getWidth() < iMax3) {
                            constraintWidgetContainer4.setWidth(iMax3);
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (constraintWidgetContainer4.getHeight() < iMax4) {
                            constraintWidgetContainer4.setHeight(iMax4);
                            z9 = true;
                        } else {
                            z9 = z8;
                        }
                        if (z9) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        }
                    }
                }
                constraintWidgetContainer4.mOptimizationLevel = i15;
                if ((i15 & 256) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                LinearSystem.OPTIMIZED_ENGINE = z4;
            } else {
                if (i10 > 0) {
                    size3 = constraintWidgetContainer4.mChildren.size();
                    measurer4 = constraintWidgetContainer4.mMeasurer;
                    while (i23 < size3) {
                        constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                        if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                            dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                            int dimensionBehaviour10 = constraintWidget2.getDimensionBehaviour(1);
                            if (dimensionBehaviour == 3) {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            } else {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            }
                        }
                    }
                    constraintLayout = measurer4.layout;
                    childCount = constraintLayout.getChildCount();
                    arrayList4 = constraintLayout.mConstraintHelpers;
                    while (i24 < childCount) {
                        constraintLayout.getChildAt(i24);
                    }
                    size4 = arrayList4.size();
                    if (size4 > 0) {
                        while (i25 < size4) {
                            ((ConstraintHelper) arrayList4.get(i25)).getClass();
                        }
                    }
                }
                i15 = constraintWidgetContainer4.mOptimizationLevel;
                size2 = arrayList2.size();
                i16 = i12;
                i17 = i13;
                if (i10 > 0) {
                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                }
                if (size2 > 0) {
                    iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                    if (iArr3[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr3[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ConstraintWidgetContainer constraintWidgetContainer12 = constraintWidgetContainer2;
                    int iMax111 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer12.mMinWidth);
                    int iMax112 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer12.mMinHeight);
                    while (i18 < size2) {
                    }
                    arrayList3 = arrayList2;
                    iMax3 = iMax111;
                    iMax4 = iMax112;
                    i19 = 0;
                    z7 = false;
                    while (i19 < 2) {
                        zMeasure = z7;
                        i20 = 0;
                        while (i20 < size2) {
                            constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                i21 = size2;
                                z10 = z6;
                                z11 = z5;
                                measurer3 = measurer2;
                                i22 = i19;
                            } else {
                                i21 = size2;
                                if (constraintWidget.mVisibility == 8) {
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    width3 = constraintWidget.getWidth();
                                    height2 = constraintWidget.getHeight();
                                    z10 = z6;
                                    int i10114 = constraintWidget.mBaselineDistance;
                                    Measurer measurer111 = measurer2;
                                    i22 = i19;
                                    z11 = z5;
                                    zMeasure |= menuHostHelper.measure(measurer111, constraintWidget, true);
                                    width4 = constraintWidget.getWidth();
                                    measurer3 = measurer111;
                                    height3 = constraintWidget.getHeight();
                                    if (width4 != width3) {
                                        constraintWidget.setWidth(width4);
                                        if (!z11) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (height3 != height2) {
                                        constraintWidget.setHeight(height3);
                                        if (!z10) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (!constraintWidget.hasBaseline) {
                                    }
                                }
                            }
                            i20++;
                            size2 = i21;
                            i19 = i22;
                            z6 = z10;
                            z5 = z11;
                            measurer2 = measurer3;
                        }
                        int i10115 = size2;
                        boolean z218 = z6;
                        boolean z219 = z5;
                        Measurer measurer112 = measurer2;
                        int i10116 = i19;
                        if (zMeasure) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            z7 = false;
                        } else {
                            z7 = zMeasure;
                        }
                        i19 = i10116 + 1;
                        size2 = i10115;
                        z6 = z218;
                        z5 = z219;
                        measurer2 = measurer112;
                    }
                    if (z7) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        if (constraintWidgetContainer4.getWidth() < iMax3) {
                            constraintWidgetContainer4.setWidth(iMax3);
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (constraintWidgetContainer4.getHeight() < iMax4) {
                            constraintWidgetContainer4.setHeight(iMax4);
                            z9 = true;
                        } else {
                            z9 = z8;
                        }
                        if (z9) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        }
                    }
                }
                constraintWidgetContainer4.mOptimizationLevel = i15;
                if ((i15 & 256) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                LinearSystem.OPTIMIZED_ENGINE = z4;
            }
            int width11 = constraintWidgetContainer4.getWidth();
            int height12 = constraintWidgetContainer4.getHeight();
            z12 = constraintWidgetContainer4.mWidthMeasuredTooSmall;
            z13 = constraintWidgetContainer4.mHeightMeasuredTooSmall;
            Measurer measurer113 = measurer5;
            int i10117 = measurer113.paddingHeight;
            int iResolveSizeAndState7 = View.resolveSizeAndState(width11 + measurer113.paddingWidth, i, 0);
            int iResolveSizeAndState8 = View.resolveSizeAndState(height12 + i10117, i2, 0) & 16777215;
            iMin = Math.min(this.mMaxWidth, iResolveSizeAndState7 & 16777215);
            iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState8);
            if (z12) {
                iMin |= 16777216;
            }
            if (z13) {
                iMin2 |= 16777216;
            }
            setMeasuredDimension(iMin, iMin2);
        }
        i4 = i99;
        iMax = childCount4 == 0 ? Math.max(0, this.mMinWidth) : i96;
        i5 = Integer.MIN_VALUE;
        i6 = 2;
        if (mode2 != i5) {
            if (mode2 != 0) {
                if (childCount4 == 0) {
                    iMax2 = Math.max(0, this.mMinHeight);
                } else {
                    iMax2 = 0;
                }
                i7 = 2;
            } else if (mode2 != 1073741824) {
                measurer5 = measurer5;
                i7 = 1;
                iMax2 = 0;
            } else {
                iMax2 = Math.min(this.mMaxHeight - i98, i97);
                measurer5 = measurer5;
                i7 = 1;
            }
            width = constraintWidgetContainer4.getWidth();
            iArr = constraintWidgetContainer4.mMaxDimension;
            if (iMax == width) {
                fileMetadata.isDirectory = true;
                c = 1;
            } else {
                fileMetadata.isDirectory = true;
                c = 1;
            }
            constraintWidgetContainer4.mX = 0;
            constraintWidgetContainer4.mY = 0;
            iArr[0] = this.mMaxWidth - i4;
            iArr[c] = this.mMaxHeight - i98;
            constraintWidgetContainer4.mMinWidth = 0;
            constraintWidgetContainer4.mMinHeight = 0;
            constraintWidgetContainer4.setHorizontalDimensionBehaviour(i6);
            constraintWidgetContainer4.setWidth(iMax);
            constraintWidgetContainer4.setVerticalDimensionBehaviour(i7);
            constraintWidgetContainer4.setHeight(iMax2);
            i8 = this.mMinWidth - i4;
            if (i8 < 0) {
                constraintWidgetContainer4.mMinWidth = 0;
            } else {
                constraintWidgetContainer4.mMinWidth = i8;
            }
            i9 = this.mMinHeight - i98;
            if (i9 < 0) {
                constraintWidgetContainer4.mMinHeight = 0;
            } else {
                constraintWidgetContainer4.mMinHeight = i9;
            }
            constraintWidgetContainer4.mPaddingLeft = iMax7;
            constraintWidgetContainer4.mPaddingTop = iMax5;
            constraintWidgetContainer = (ConstraintWidgetContainer) menuHostHelper.mProviderToLifecycleContainers;
            arrayList = (ArrayList) menuHostHelper.mOnInvalidateMenuCallback;
            measurer = constraintWidgetContainer4.mMeasurer;
            size = constraintWidgetContainer4.mChildren.size();
            width2 = constraintWidgetContainer4.getWidth();
            height = constraintWidgetContainer4.getHeight();
            if ((i94 & 128) == 128) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                iArr2 = iArr;
                if ((i94 & 64) == 64) {
                    z2 = false;
                }
                if (z2) {
                    i37 = 0;
                    while (true) {
                        if (i37 < size) {
                            z18 = z2;
                            constraintWidget3 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i37);
                            i10 = size;
                            iArr4 = constraintWidget3.mListDimensionBehaviors;
                            i38 = i37;
                            if (iArr4[0] == 3) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            if (iArr4[1] == 3) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (!z19) {
                            }
                            if (constraintWidget3.isInHorizontalChain()) {
                                i37 = i38 + 1;
                                z2 = z18;
                                size = i10;
                            } else {
                                i37 = i38 + 1;
                                z2 = z18;
                                size = i10;
                            }
                            i11 = 1073741824;
                            z3 = false;
                        } else {
                            z3 = z2;
                            i10 = size;
                            i11 = 1073741824;
                        }
                    }
                } else {
                    z3 = z2;
                    i10 = size;
                    i11 = 1073741824;
                }
                if (z3 && ((mode != i11 && mode2 == i11) || z)) {
                    iMin3 = Math.min(iArr2[0], i96);
                    iMin4 = Math.min(iArr2[1], i97);
                    i26 = 1073741824;
                    if (mode == 1073741824) {
                        if (constraintWidgetContainer4.getWidth() != iMin3) {
                            constraintWidgetContainer4.setWidth(iMin3);
                            fileMetadata.isRegularFile = true;
                        }
                        i26 = 1073741824;
                    }
                    if (mode2 == i26) {
                        constraintWidgetContainer4.setHeight(iMin4);
                        fileMetadata.isRegularFile = true;
                    }
                    if (mode == i26) {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        arrayList2 = arrayList;
                        measurer2 = measurer;
                        i12 = width2;
                        i13 = height;
                        constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                        if (fileMetadata.isRegularFile) {
                            arrayList5 = constraintWidgetContainer3.mChildren;
                            size5 = arrayList5.size();
                            i29 = 0;
                            while (i29 < size5) {
                                Object obj14 = arrayList5.get(i29);
                                i29++;
                                ConstraintWidget constraintWidget116 = (ConstraintWidget) obj14;
                                constraintWidget116.measured = false;
                                HorizontalWidgetRun horizontalWidgetRun16 = constraintWidget116.horizontalRun;
                                horizontalWidgetRun16.dimension.resolved = false;
                                horizontalWidgetRun16.resolved = false;
                                horizontalWidgetRun16.reset();
                                VerticalWidgetRun verticalWidgetRun16 = constraintWidget116.verticalRun;
                                verticalWidgetRun16.dimension.resolved = false;
                                verticalWidgetRun16.resolved = false;
                                verticalWidgetRun16.reset();
                            }
                            i27 = 0;
                            constraintWidgetContainer3.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun17 = constraintWidgetContainer3.horizontalRun;
                            horizontalWidgetRun17.dimension.resolved = false;
                            horizontalWidgetRun17.resolved = false;
                            horizontalWidgetRun17.reset();
                            VerticalWidgetRun verticalWidgetRun17 = constraintWidgetContainer3.verticalRun;
                            verticalWidgetRun17.dimension.resolved = false;
                            verticalWidgetRun17.resolved = false;
                            verticalWidgetRun17.reset();
                            fileMetadata.buildGraph();
                        } else {
                            i27 = 0;
                        }
                        fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                        constraintWidgetContainer3.mX = i27;
                        constraintWidgetContainer3.mY = i27;
                        constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                        constraintWidgetContainer3.verticalRun.start.resolve(i27);
                        i28 = 1073741824;
                        if (mode == 1073741824) {
                            zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zDirectMeasureWithOrientation = true;
                        }
                        if (mode2 == 1073741824) {
                            zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                            i14++;
                        }
                    } else {
                        constraintWidgetContainer2 = constraintWidgetContainer;
                        arrayList2 = arrayList;
                        measurer2 = measurer;
                        i12 = width2;
                        i13 = height;
                        constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                        if (fileMetadata.isRegularFile) {
                            arrayList5 = constraintWidgetContainer3.mChildren;
                            size5 = arrayList5.size();
                            i29 = 0;
                            while (i29 < size5) {
                                Object obj15 = arrayList5.get(i29);
                                i29++;
                                ConstraintWidget constraintWidget117 = (ConstraintWidget) obj15;
                                constraintWidget117.measured = false;
                                HorizontalWidgetRun horizontalWidgetRun18 = constraintWidget117.horizontalRun;
                                horizontalWidgetRun18.dimension.resolved = false;
                                horizontalWidgetRun18.resolved = false;
                                horizontalWidgetRun18.reset();
                                VerticalWidgetRun verticalWidgetRun18 = constraintWidget117.verticalRun;
                                verticalWidgetRun18.dimension.resolved = false;
                                verticalWidgetRun18.resolved = false;
                                verticalWidgetRun18.reset();
                            }
                            i27 = 0;
                            constraintWidgetContainer3.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun19 = constraintWidgetContainer3.horizontalRun;
                            horizontalWidgetRun19.dimension.resolved = false;
                            horizontalWidgetRun19.resolved = false;
                            horizontalWidgetRun19.reset();
                            VerticalWidgetRun verticalWidgetRun19 = constraintWidgetContainer3.verticalRun;
                            verticalWidgetRun19.dimension.resolved = false;
                            verticalWidgetRun19.resolved = false;
                            verticalWidgetRun19.reset();
                            fileMetadata.buildGraph();
                        } else {
                            i27 = 0;
                        }
                        fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                        constraintWidgetContainer3.mX = i27;
                        constraintWidgetContainer3.mY = i27;
                        constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                        constraintWidgetContainer3.verticalRun.start.resolve(i27);
                        i28 = 1073741824;
                        if (mode == 1073741824) {
                            zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                            i14 = 1;
                        } else {
                            i14 = 0;
                            zDirectMeasureWithOrientation = true;
                        }
                        if (mode2 == 1073741824) {
                            zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                            i14++;
                        }
                    }
                    if (zDirectMeasureWithOrientation) {
                        if (mode == i28) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (mode2 == i28) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        constraintWidgetContainer4.updateFromRuns(z14, z15);
                    }
                } else {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    i14 = 0;
                    zDirectMeasureWithOrientation = false;
                }
                if (zDirectMeasureWithOrientation) {
                    if (i10 > 0) {
                        size3 = constraintWidgetContainer4.mChildren.size();
                        measurer4 = constraintWidgetContainer4.mMeasurer;
                        while (i23 < size3) {
                            constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                            if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                                dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                                int dimensionBehaviour11 = constraintWidget2.getDimensionBehaviour(1);
                                if (dimensionBehaviour == 3) {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                } else {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                }
                            }
                        }
                        constraintLayout = measurer4.layout;
                        childCount = constraintLayout.getChildCount();
                        arrayList4 = constraintLayout.mConstraintHelpers;
                        while (i24 < childCount) {
                            constraintLayout.getChildAt(i24);
                        }
                        size4 = arrayList4.size();
                        if (size4 > 0) {
                            while (i25 < size4) {
                                ((ConstraintHelper) arrayList4.get(i25)).getClass();
                            }
                        }
                    }
                    i15 = constraintWidgetContainer4.mOptimizationLevel;
                    size2 = arrayList2.size();
                    i16 = i12;
                    i17 = i13;
                    if (i10 > 0) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    }
                    if (size2 > 0) {
                        iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                        if (iArr3[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr3[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        ConstraintWidgetContainer constraintWidgetContainer13 = constraintWidgetContainer2;
                        int iMax113 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer13.mMinWidth);
                        int iMax114 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer13.mMinHeight);
                        while (i18 < size2) {
                        }
                        arrayList3 = arrayList2;
                        iMax3 = iMax113;
                        iMax4 = iMax114;
                        i19 = 0;
                        z7 = false;
                        while (i19 < 2) {
                            zMeasure = z7;
                            i20 = 0;
                            while (i20 < size2) {
                                constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                                if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                    i21 = size2;
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    i21 = size2;
                                    if (constraintWidget.mVisibility == 8) {
                                        z10 = z6;
                                        z11 = z5;
                                        measurer3 = measurer2;
                                        i22 = i19;
                                    } else {
                                        width3 = constraintWidget.getWidth();
                                        height2 = constraintWidget.getHeight();
                                        z10 = z6;
                                        int i10118 = constraintWidget.mBaselineDistance;
                                        Measurer measurer114 = measurer2;
                                        i22 = i19;
                                        z11 = z5;
                                        zMeasure |= menuHostHelper.measure(measurer114, constraintWidget, true);
                                        width4 = constraintWidget.getWidth();
                                        measurer3 = measurer114;
                                        height3 = constraintWidget.getHeight();
                                        if (width4 != width3) {
                                            constraintWidget.setWidth(width4);
                                            if (!z11) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (height3 != height2) {
                                            constraintWidget.setHeight(height3);
                                            if (!z10) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (!constraintWidget.hasBaseline) {
                                        }
                                    }
                                }
                                i20++;
                                size2 = i21;
                                i19 = i22;
                                z6 = z10;
                                z5 = z11;
                                measurer2 = measurer3;
                            }
                            int i10119 = size2;
                            boolean z2110 = z6;
                            boolean z2111 = z5;
                            Measurer measurer115 = measurer2;
                            int i101110 = i19;
                            if (zMeasure) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                z7 = false;
                            } else {
                                z7 = zMeasure;
                            }
                            i19 = i101110 + 1;
                            size2 = i10119;
                            z6 = z2110;
                            z5 = z2111;
                            measurer2 = measurer115;
                        }
                        if (z7) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            if (constraintWidgetContainer4.getWidth() < iMax3) {
                                constraintWidgetContainer4.setWidth(iMax3);
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (constraintWidgetContainer4.getHeight() < iMax4) {
                                constraintWidgetContainer4.setHeight(iMax4);
                                z9 = true;
                            } else {
                                z9 = z8;
                            }
                            if (z9) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            }
                        }
                    }
                    constraintWidgetContainer4.mOptimizationLevel = i15;
                    if ((i15 & 256) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    LinearSystem.OPTIMIZED_ENGINE = z4;
                } else {
                    if (i10 > 0) {
                        size3 = constraintWidgetContainer4.mChildren.size();
                        measurer4 = constraintWidgetContainer4.mMeasurer;
                        while (i23 < size3) {
                            constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                            if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                                dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                                int dimensionBehaviour12 = constraintWidget2.getDimensionBehaviour(1);
                                if (dimensionBehaviour == 3) {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                } else {
                                    menuHostHelper.measure(measurer4, constraintWidget2, false);
                                }
                            }
                        }
                        constraintLayout = measurer4.layout;
                        childCount = constraintLayout.getChildCount();
                        arrayList4 = constraintLayout.mConstraintHelpers;
                        while (i24 < childCount) {
                            constraintLayout.getChildAt(i24);
                        }
                        size4 = arrayList4.size();
                        if (size4 > 0) {
                            while (i25 < size4) {
                                ((ConstraintHelper) arrayList4.get(i25)).getClass();
                            }
                        }
                    }
                    i15 = constraintWidgetContainer4.mOptimizationLevel;
                    size2 = arrayList2.size();
                    i16 = i12;
                    i17 = i13;
                    if (i10 > 0) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    }
                    if (size2 > 0) {
                        iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                        if (iArr3[0] == 2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (iArr3[1] == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        ConstraintWidgetContainer constraintWidgetContainer14 = constraintWidgetContainer2;
                        int iMax115 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer14.mMinWidth);
                        int iMax116 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer14.mMinHeight);
                        while (i18 < size2) {
                        }
                        arrayList3 = arrayList2;
                        iMax3 = iMax115;
                        iMax4 = iMax116;
                        i19 = 0;
                        z7 = false;
                        while (i19 < 2) {
                            zMeasure = z7;
                            i20 = 0;
                            while (i20 < size2) {
                                constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                                if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                    i21 = size2;
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    i21 = size2;
                                    if (constraintWidget.mVisibility == 8) {
                                        z10 = z6;
                                        z11 = z5;
                                        measurer3 = measurer2;
                                        i22 = i19;
                                    } else {
                                        width3 = constraintWidget.getWidth();
                                        height2 = constraintWidget.getHeight();
                                        z10 = z6;
                                        int i101111 = constraintWidget.mBaselineDistance;
                                        Measurer measurer116 = measurer2;
                                        i22 = i19;
                                        z11 = z5;
                                        zMeasure |= menuHostHelper.measure(measurer116, constraintWidget, true);
                                        width4 = constraintWidget.getWidth();
                                        measurer3 = measurer116;
                                        height3 = constraintWidget.getHeight();
                                        if (width4 != width3) {
                                            constraintWidget.setWidth(width4);
                                            if (!z11) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (height3 != height2) {
                                            constraintWidget.setHeight(height3);
                                            if (!z10) {
                                            }
                                            zMeasure = true;
                                        }
                                        if (!constraintWidget.hasBaseline) {
                                        }
                                    }
                                }
                                i20++;
                                size2 = i21;
                                i19 = i22;
                                z6 = z10;
                                z5 = z11;
                                measurer2 = measurer3;
                            }
                            int i101112 = size2;
                            boolean z2112 = z6;
                            boolean z2113 = z5;
                            Measurer measurer117 = measurer2;
                            int i101113 = i19;
                            if (zMeasure) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                                z7 = false;
                            } else {
                                z7 = zMeasure;
                            }
                            i19 = i101113 + 1;
                            size2 = i101112;
                            z6 = z2112;
                            z5 = z2113;
                            measurer2 = measurer117;
                        }
                        if (z7) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            if (constraintWidgetContainer4.getWidth() < iMax3) {
                                constraintWidgetContainer4.setWidth(iMax3);
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (constraintWidgetContainer4.getHeight() < iMax4) {
                                constraintWidgetContainer4.setHeight(iMax4);
                                z9 = true;
                            } else {
                                z9 = z8;
                            }
                            if (z9) {
                                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            }
                        }
                    }
                    constraintWidgetContainer4.mOptimizationLevel = i15;
                    if ((i15 & 256) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    LinearSystem.OPTIMIZED_ENGINE = z4;
                }
                int width12 = constraintWidgetContainer4.getWidth();
                int height13 = constraintWidgetContainer4.getHeight();
                z12 = constraintWidgetContainer4.mWidthMeasuredTooSmall;
                z13 = constraintWidgetContainer4.mHeightMeasuredTooSmall;
                Measurer measurer118 = measurer5;
                int i101114 = measurer118.paddingHeight;
                int iResolveSizeAndState9 = View.resolveSizeAndState(width12 + measurer118.paddingWidth, i, 0);
                int iResolveSizeAndState10 = View.resolveSizeAndState(height13 + i101114, i2, 0) & 16777215;
                iMin = Math.min(this.mMaxWidth, iResolveSizeAndState9 & 16777215);
                iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState10);
                if (z12) {
                    iMin |= 16777216;
                }
                if (z13) {
                    iMin2 |= 16777216;
                }
                setMeasuredDimension(iMin, iMin2);
            }
            iArr2 = iArr;
            z2 = true;
            if (z2) {
                i37 = 0;
                while (true) {
                    if (i37 < size) {
                        z18 = z2;
                        constraintWidget3 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i37);
                        i10 = size;
                        iArr4 = constraintWidget3.mListDimensionBehaviors;
                        i38 = i37;
                        if (iArr4[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr4[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (!z19) {
                        }
                        if (constraintWidget3.isInHorizontalChain()) {
                            i37 = i38 + 1;
                            z2 = z18;
                            size = i10;
                        } else {
                            i37 = i38 + 1;
                            z2 = z18;
                            size = i10;
                        }
                        i11 = 1073741824;
                        z3 = false;
                    } else {
                        z3 = z2;
                        i10 = size;
                        i11 = 1073741824;
                    }
                }
            } else {
                z3 = z2;
                i10 = size;
                i11 = 1073741824;
            }
            if (z3 && ((mode != i11 && mode2 == i11) || z)) {
                iMin3 = Math.min(iArr2[0], i96);
                iMin4 = Math.min(iArr2[1], i97);
                i26 = 1073741824;
                if (mode == 1073741824) {
                    if (constraintWidgetContainer4.getWidth() != iMin3) {
                        constraintWidgetContainer4.setWidth(iMin3);
                        fileMetadata.isRegularFile = true;
                    }
                    i26 = 1073741824;
                }
                if (mode2 == i26) {
                    constraintWidgetContainer4.setHeight(iMin4);
                    fileMetadata.isRegularFile = true;
                }
                if (mode == i26) {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                    if (fileMetadata.isRegularFile) {
                        arrayList5 = constraintWidgetContainer3.mChildren;
                        size5 = arrayList5.size();
                        i29 = 0;
                        while (i29 < size5) {
                            Object obj16 = arrayList5.get(i29);
                            i29++;
                            ConstraintWidget constraintWidget118 = (ConstraintWidget) obj16;
                            constraintWidget118.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun110 = constraintWidget118.horizontalRun;
                            horizontalWidgetRun110.dimension.resolved = false;
                            horizontalWidgetRun110.resolved = false;
                            horizontalWidgetRun110.reset();
                            VerticalWidgetRun verticalWidgetRun110 = constraintWidget118.verticalRun;
                            verticalWidgetRun110.dimension.resolved = false;
                            verticalWidgetRun110.resolved = false;
                            verticalWidgetRun110.reset();
                        }
                        i27 = 0;
                        constraintWidgetContainer3.measured = false;
                        HorizontalWidgetRun horizontalWidgetRun111 = constraintWidgetContainer3.horizontalRun;
                        horizontalWidgetRun111.dimension.resolved = false;
                        horizontalWidgetRun111.resolved = false;
                        horizontalWidgetRun111.reset();
                        VerticalWidgetRun verticalWidgetRun111 = constraintWidgetContainer3.verticalRun;
                        verticalWidgetRun111.dimension.resolved = false;
                        verticalWidgetRun111.resolved = false;
                        verticalWidgetRun111.reset();
                        fileMetadata.buildGraph();
                    } else {
                        i27 = 0;
                    }
                    fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                    constraintWidgetContainer3.mX = i27;
                    constraintWidgetContainer3.mY = i27;
                    constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                    constraintWidgetContainer3.verticalRun.start.resolve(i27);
                    i28 = 1073741824;
                    if (mode == 1073741824) {
                        zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zDirectMeasureWithOrientation = true;
                    }
                    if (mode2 == 1073741824) {
                        zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                        i14++;
                    }
                } else {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                    if (fileMetadata.isRegularFile) {
                        arrayList5 = constraintWidgetContainer3.mChildren;
                        size5 = arrayList5.size();
                        i29 = 0;
                        while (i29 < size5) {
                            Object obj17 = arrayList5.get(i29);
                            i29++;
                            ConstraintWidget constraintWidget119 = (ConstraintWidget) obj17;
                            constraintWidget119.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun112 = constraintWidget119.horizontalRun;
                            horizontalWidgetRun112.dimension.resolved = false;
                            horizontalWidgetRun112.resolved = false;
                            horizontalWidgetRun112.reset();
                            VerticalWidgetRun verticalWidgetRun112 = constraintWidget119.verticalRun;
                            verticalWidgetRun112.dimension.resolved = false;
                            verticalWidgetRun112.resolved = false;
                            verticalWidgetRun112.reset();
                        }
                        i27 = 0;
                        constraintWidgetContainer3.measured = false;
                        HorizontalWidgetRun horizontalWidgetRun113 = constraintWidgetContainer3.horizontalRun;
                        horizontalWidgetRun113.dimension.resolved = false;
                        horizontalWidgetRun113.resolved = false;
                        horizontalWidgetRun113.reset();
                        VerticalWidgetRun verticalWidgetRun113 = constraintWidgetContainer3.verticalRun;
                        verticalWidgetRun113.dimension.resolved = false;
                        verticalWidgetRun113.resolved = false;
                        verticalWidgetRun113.reset();
                        fileMetadata.buildGraph();
                    } else {
                        i27 = 0;
                    }
                    fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                    constraintWidgetContainer3.mX = i27;
                    constraintWidgetContainer3.mY = i27;
                    constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                    constraintWidgetContainer3.verticalRun.start.resolve(i27);
                    i28 = 1073741824;
                    if (mode == 1073741824) {
                        zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zDirectMeasureWithOrientation = true;
                    }
                    if (mode2 == 1073741824) {
                        zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                        i14++;
                    }
                }
                if (zDirectMeasureWithOrientation) {
                    if (mode == i28) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i28) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    constraintWidgetContainer4.updateFromRuns(z14, z15);
                }
            } else {
                constraintWidgetContainer2 = constraintWidgetContainer;
                arrayList2 = arrayList;
                measurer2 = measurer;
                i12 = width2;
                i13 = height;
                i14 = 0;
                zDirectMeasureWithOrientation = false;
            }
            if (zDirectMeasureWithOrientation) {
                if (i10 > 0) {
                    size3 = constraintWidgetContainer4.mChildren.size();
                    measurer4 = constraintWidgetContainer4.mMeasurer;
                    while (i23 < size3) {
                        constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                        if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                            dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                            int dimensionBehaviour13 = constraintWidget2.getDimensionBehaviour(1);
                            if (dimensionBehaviour == 3) {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            } else {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            }
                        }
                    }
                    constraintLayout = measurer4.layout;
                    childCount = constraintLayout.getChildCount();
                    arrayList4 = constraintLayout.mConstraintHelpers;
                    while (i24 < childCount) {
                        constraintLayout.getChildAt(i24);
                    }
                    size4 = arrayList4.size();
                    if (size4 > 0) {
                        while (i25 < size4) {
                            ((ConstraintHelper) arrayList4.get(i25)).getClass();
                        }
                    }
                }
                i15 = constraintWidgetContainer4.mOptimizationLevel;
                size2 = arrayList2.size();
                i16 = i12;
                i17 = i13;
                if (i10 > 0) {
                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                }
                if (size2 > 0) {
                    iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                    if (iArr3[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr3[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ConstraintWidgetContainer constraintWidgetContainer15 = constraintWidgetContainer2;
                    int iMax117 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer15.mMinWidth);
                    int iMax118 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer15.mMinHeight);
                    while (i18 < size2) {
                    }
                    arrayList3 = arrayList2;
                    iMax3 = iMax117;
                    iMax4 = iMax118;
                    i19 = 0;
                    z7 = false;
                    while (i19 < 2) {
                        zMeasure = z7;
                        i20 = 0;
                        while (i20 < size2) {
                            constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                i21 = size2;
                                z10 = z6;
                                z11 = z5;
                                measurer3 = measurer2;
                                i22 = i19;
                            } else {
                                i21 = size2;
                                if (constraintWidget.mVisibility == 8) {
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    width3 = constraintWidget.getWidth();
                                    height2 = constraintWidget.getHeight();
                                    z10 = z6;
                                    int i101115 = constraintWidget.mBaselineDistance;
                                    Measurer measurer119 = measurer2;
                                    i22 = i19;
                                    z11 = z5;
                                    zMeasure |= menuHostHelper.measure(measurer119, constraintWidget, true);
                                    width4 = constraintWidget.getWidth();
                                    measurer3 = measurer119;
                                    height3 = constraintWidget.getHeight();
                                    if (width4 != width3) {
                                        constraintWidget.setWidth(width4);
                                        if (!z11) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (height3 != height2) {
                                        constraintWidget.setHeight(height3);
                                        if (!z10) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (!constraintWidget.hasBaseline) {
                                    }
                                }
                            }
                            i20++;
                            size2 = i21;
                            i19 = i22;
                            z6 = z10;
                            z5 = z11;
                            measurer2 = measurer3;
                        }
                        int i101116 = size2;
                        boolean z2114 = z6;
                        boolean z2115 = z5;
                        Measurer measurer1110 = measurer2;
                        int i101117 = i19;
                        if (zMeasure) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            z7 = false;
                        } else {
                            z7 = zMeasure;
                        }
                        i19 = i101117 + 1;
                        size2 = i101116;
                        z6 = z2114;
                        z5 = z2115;
                        measurer2 = measurer1110;
                    }
                    if (z7) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        if (constraintWidgetContainer4.getWidth() < iMax3) {
                            constraintWidgetContainer4.setWidth(iMax3);
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (constraintWidgetContainer4.getHeight() < iMax4) {
                            constraintWidgetContainer4.setHeight(iMax4);
                            z9 = true;
                        } else {
                            z9 = z8;
                        }
                        if (z9) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        }
                    }
                }
                constraintWidgetContainer4.mOptimizationLevel = i15;
                if ((i15 & 256) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                LinearSystem.OPTIMIZED_ENGINE = z4;
            } else {
                if (i10 > 0) {
                    size3 = constraintWidgetContainer4.mChildren.size();
                    measurer4 = constraintWidgetContainer4.mMeasurer;
                    while (i23 < size3) {
                        constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                        if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                            dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                            int dimensionBehaviour14 = constraintWidget2.getDimensionBehaviour(1);
                            if (dimensionBehaviour == 3) {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            } else {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            }
                        }
                    }
                    constraintLayout = measurer4.layout;
                    childCount = constraintLayout.getChildCount();
                    arrayList4 = constraintLayout.mConstraintHelpers;
                    while (i24 < childCount) {
                        constraintLayout.getChildAt(i24);
                    }
                    size4 = arrayList4.size();
                    if (size4 > 0) {
                        while (i25 < size4) {
                            ((ConstraintHelper) arrayList4.get(i25)).getClass();
                        }
                    }
                }
                i15 = constraintWidgetContainer4.mOptimizationLevel;
                size2 = arrayList2.size();
                i16 = i12;
                i17 = i13;
                if (i10 > 0) {
                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                }
                if (size2 > 0) {
                    iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                    if (iArr3[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr3[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ConstraintWidgetContainer constraintWidgetContainer16 = constraintWidgetContainer2;
                    int iMax119 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer16.mMinWidth);
                    int iMax1110 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer16.mMinHeight);
                    while (i18 < size2) {
                    }
                    arrayList3 = arrayList2;
                    iMax3 = iMax119;
                    iMax4 = iMax1110;
                    i19 = 0;
                    z7 = false;
                    while (i19 < 2) {
                        zMeasure = z7;
                        i20 = 0;
                        while (i20 < size2) {
                            constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                i21 = size2;
                                z10 = z6;
                                z11 = z5;
                                measurer3 = measurer2;
                                i22 = i19;
                            } else {
                                i21 = size2;
                                if (constraintWidget.mVisibility == 8) {
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    width3 = constraintWidget.getWidth();
                                    height2 = constraintWidget.getHeight();
                                    z10 = z6;
                                    int i101118 = constraintWidget.mBaselineDistance;
                                    Measurer measurer1111 = measurer2;
                                    i22 = i19;
                                    z11 = z5;
                                    zMeasure |= menuHostHelper.measure(measurer1111, constraintWidget, true);
                                    width4 = constraintWidget.getWidth();
                                    measurer3 = measurer1111;
                                    height3 = constraintWidget.getHeight();
                                    if (width4 != width3) {
                                        constraintWidget.setWidth(width4);
                                        if (!z11) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (height3 != height2) {
                                        constraintWidget.setHeight(height3);
                                        if (!z10) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (!constraintWidget.hasBaseline) {
                                    }
                                }
                            }
                            i20++;
                            size2 = i21;
                            i19 = i22;
                            z6 = z10;
                            z5 = z11;
                            measurer2 = measurer3;
                        }
                        int i101119 = size2;
                        boolean z2116 = z6;
                        boolean z2117 = z5;
                        Measurer measurer1112 = measurer2;
                        int i1011110 = i19;
                        if (zMeasure) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            z7 = false;
                        } else {
                            z7 = zMeasure;
                        }
                        i19 = i1011110 + 1;
                        size2 = i101119;
                        z6 = z2116;
                        z5 = z2117;
                        measurer2 = measurer1112;
                    }
                    if (z7) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        if (constraintWidgetContainer4.getWidth() < iMax3) {
                            constraintWidgetContainer4.setWidth(iMax3);
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (constraintWidgetContainer4.getHeight() < iMax4) {
                            constraintWidgetContainer4.setHeight(iMax4);
                            z9 = true;
                        } else {
                            z9 = z8;
                        }
                        if (z9) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        }
                    }
                }
                constraintWidgetContainer4.mOptimizationLevel = i15;
                if ((i15 & 256) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                LinearSystem.OPTIMIZED_ENGINE = z4;
            }
            int width13 = constraintWidgetContainer4.getWidth();
            int height14 = constraintWidgetContainer4.getHeight();
            z12 = constraintWidgetContainer4.mWidthMeasuredTooSmall;
            z13 = constraintWidgetContainer4.mHeightMeasuredTooSmall;
            Measurer measurer1113 = measurer5;
            int i1011111 = measurer1113.paddingHeight;
            int iResolveSizeAndState11 = View.resolveSizeAndState(width13 + measurer1113.paddingWidth, i, 0);
            int iResolveSizeAndState12 = View.resolveSizeAndState(height14 + i1011111, i2, 0) & 16777215;
            iMin = Math.min(this.mMaxWidth, iResolveSizeAndState11 & 16777215);
            iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState12);
            if (z12) {
                iMin |= 16777216;
            }
            if (z13) {
                iMin2 |= 16777216;
            }
            setMeasuredDimension(iMin, iMin2);
        }
        if (childCount4 == 0) {
            iMax2 = Math.max(0, this.mMinHeight);
        } else {
            iMax2 = i97;
        }
        i7 = 2;
        width = constraintWidgetContainer4.getWidth();
        iArr = constraintWidgetContainer4.mMaxDimension;
        if (iMax == width) {
            fileMetadata.isDirectory = true;
            c = 1;
        } else {
            fileMetadata.isDirectory = true;
            c = 1;
        }
        constraintWidgetContainer4.mX = 0;
        constraintWidgetContainer4.mY = 0;
        iArr[0] = this.mMaxWidth - i4;
        iArr[c] = this.mMaxHeight - i98;
        constraintWidgetContainer4.mMinWidth = 0;
        constraintWidgetContainer4.mMinHeight = 0;
        constraintWidgetContainer4.setHorizontalDimensionBehaviour(i6);
        constraintWidgetContainer4.setWidth(iMax);
        constraintWidgetContainer4.setVerticalDimensionBehaviour(i7);
        constraintWidgetContainer4.setHeight(iMax2);
        i8 = this.mMinWidth - i4;
        if (i8 < 0) {
            constraintWidgetContainer4.mMinWidth = 0;
        } else {
            constraintWidgetContainer4.mMinWidth = i8;
        }
        i9 = this.mMinHeight - i98;
        if (i9 < 0) {
            constraintWidgetContainer4.mMinHeight = 0;
        } else {
            constraintWidgetContainer4.mMinHeight = i9;
        }
        constraintWidgetContainer4.mPaddingLeft = iMax7;
        constraintWidgetContainer4.mPaddingTop = iMax5;
        constraintWidgetContainer = (ConstraintWidgetContainer) menuHostHelper.mProviderToLifecycleContainers;
        arrayList = (ArrayList) menuHostHelper.mOnInvalidateMenuCallback;
        measurer = constraintWidgetContainer4.mMeasurer;
        size = constraintWidgetContainer4.mChildren.size();
        width2 = constraintWidgetContainer4.getWidth();
        height = constraintWidgetContainer4.getHeight();
        if ((i94 & 128) == 128) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            iArr2 = iArr;
            if ((i94 & 64) == 64) {
                z2 = false;
            }
            if (z2) {
                i37 = 0;
                while (true) {
                    if (i37 < size) {
                        z18 = z2;
                        constraintWidget3 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i37);
                        i10 = size;
                        iArr4 = constraintWidget3.mListDimensionBehaviors;
                        i38 = i37;
                        if (iArr4[0] == 3) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (iArr4[1] == 3) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (!z19) {
                        }
                        if (constraintWidget3.isInHorizontalChain()) {
                            i37 = i38 + 1;
                            z2 = z18;
                            size = i10;
                        } else {
                            i37 = i38 + 1;
                            z2 = z18;
                            size = i10;
                        }
                        i11 = 1073741824;
                        z3 = false;
                    } else {
                        z3 = z2;
                        i10 = size;
                        i11 = 1073741824;
                    }
                }
            } else {
                z3 = z2;
                i10 = size;
                i11 = 1073741824;
            }
            if (z3 && ((mode != i11 && mode2 == i11) || z)) {
                iMin3 = Math.min(iArr2[0], i96);
                iMin4 = Math.min(iArr2[1], i97);
                i26 = 1073741824;
                if (mode == 1073741824) {
                    if (constraintWidgetContainer4.getWidth() != iMin3) {
                        constraintWidgetContainer4.setWidth(iMin3);
                        fileMetadata.isRegularFile = true;
                    }
                    i26 = 1073741824;
                }
                if (mode2 == i26) {
                    constraintWidgetContainer4.setHeight(iMin4);
                    fileMetadata.isRegularFile = true;
                }
                if (mode == i26) {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                    if (fileMetadata.isRegularFile) {
                        arrayList5 = constraintWidgetContainer3.mChildren;
                        size5 = arrayList5.size();
                        i29 = 0;
                        while (i29 < size5) {
                            Object obj18 = arrayList5.get(i29);
                            i29++;
                            ConstraintWidget constraintWidget1110 = (ConstraintWidget) obj18;
                            constraintWidget1110.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun114 = constraintWidget1110.horizontalRun;
                            horizontalWidgetRun114.dimension.resolved = false;
                            horizontalWidgetRun114.resolved = false;
                            horizontalWidgetRun114.reset();
                            VerticalWidgetRun verticalWidgetRun114 = constraintWidget1110.verticalRun;
                            verticalWidgetRun114.dimension.resolved = false;
                            verticalWidgetRun114.resolved = false;
                            verticalWidgetRun114.reset();
                        }
                        i27 = 0;
                        constraintWidgetContainer3.measured = false;
                        HorizontalWidgetRun horizontalWidgetRun115 = constraintWidgetContainer3.horizontalRun;
                        horizontalWidgetRun115.dimension.resolved = false;
                        horizontalWidgetRun115.resolved = false;
                        horizontalWidgetRun115.reset();
                        VerticalWidgetRun verticalWidgetRun115 = constraintWidgetContainer3.verticalRun;
                        verticalWidgetRun115.dimension.resolved = false;
                        verticalWidgetRun115.resolved = false;
                        verticalWidgetRun115.reset();
                        fileMetadata.buildGraph();
                    } else {
                        i27 = 0;
                    }
                    fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                    constraintWidgetContainer3.mX = i27;
                    constraintWidgetContainer3.mY = i27;
                    constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                    constraintWidgetContainer3.verticalRun.start.resolve(i27);
                    i28 = 1073741824;
                    if (mode == 1073741824) {
                        zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zDirectMeasureWithOrientation = true;
                    }
                    if (mode2 == 1073741824) {
                        zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                        i14++;
                    }
                } else {
                    constraintWidgetContainer2 = constraintWidgetContainer;
                    arrayList2 = arrayList;
                    measurer2 = measurer;
                    i12 = width2;
                    i13 = height;
                    constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                    if (fileMetadata.isRegularFile) {
                        arrayList5 = constraintWidgetContainer3.mChildren;
                        size5 = arrayList5.size();
                        i29 = 0;
                        while (i29 < size5) {
                            Object obj19 = arrayList5.get(i29);
                            i29++;
                            ConstraintWidget constraintWidget1111 = (ConstraintWidget) obj19;
                            constraintWidget1111.measured = false;
                            HorizontalWidgetRun horizontalWidgetRun116 = constraintWidget1111.horizontalRun;
                            horizontalWidgetRun116.dimension.resolved = false;
                            horizontalWidgetRun116.resolved = false;
                            horizontalWidgetRun116.reset();
                            VerticalWidgetRun verticalWidgetRun116 = constraintWidget1111.verticalRun;
                            verticalWidgetRun116.dimension.resolved = false;
                            verticalWidgetRun116.resolved = false;
                            verticalWidgetRun116.reset();
                        }
                        i27 = 0;
                        constraintWidgetContainer3.measured = false;
                        HorizontalWidgetRun horizontalWidgetRun117 = constraintWidgetContainer3.horizontalRun;
                        horizontalWidgetRun117.dimension.resolved = false;
                        horizontalWidgetRun117.resolved = false;
                        horizontalWidgetRun117.reset();
                        VerticalWidgetRun verticalWidgetRun117 = constraintWidgetContainer3.verticalRun;
                        verticalWidgetRun117.dimension.resolved = false;
                        verticalWidgetRun117.resolved = false;
                        verticalWidgetRun117.reset();
                        fileMetadata.buildGraph();
                    } else {
                        i27 = 0;
                    }
                    fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                    constraintWidgetContainer3.mX = i27;
                    constraintWidgetContainer3.mY = i27;
                    constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                    constraintWidgetContainer3.verticalRun.start.resolve(i27);
                    i28 = 1073741824;
                    if (mode == 1073741824) {
                        zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                        i14 = 1;
                    } else {
                        i14 = 0;
                        zDirectMeasureWithOrientation = true;
                    }
                    if (mode2 == 1073741824) {
                        zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                        i14++;
                    }
                }
                if (zDirectMeasureWithOrientation) {
                    if (mode == i28) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (mode2 == i28) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    constraintWidgetContainer4.updateFromRuns(z14, z15);
                }
            } else {
                constraintWidgetContainer2 = constraintWidgetContainer;
                arrayList2 = arrayList;
                measurer2 = measurer;
                i12 = width2;
                i13 = height;
                i14 = 0;
                zDirectMeasureWithOrientation = false;
            }
            if (zDirectMeasureWithOrientation) {
                if (i10 > 0) {
                    size3 = constraintWidgetContainer4.mChildren.size();
                    measurer4 = constraintWidgetContainer4.mMeasurer;
                    while (i23 < size3) {
                        constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                        if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                            dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                            int dimensionBehaviour15 = constraintWidget2.getDimensionBehaviour(1);
                            if (dimensionBehaviour == 3) {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            } else {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            }
                        }
                    }
                    constraintLayout = measurer4.layout;
                    childCount = constraintLayout.getChildCount();
                    arrayList4 = constraintLayout.mConstraintHelpers;
                    while (i24 < childCount) {
                        constraintLayout.getChildAt(i24);
                    }
                    size4 = arrayList4.size();
                    if (size4 > 0) {
                        while (i25 < size4) {
                            ((ConstraintHelper) arrayList4.get(i25)).getClass();
                        }
                    }
                }
                i15 = constraintWidgetContainer4.mOptimizationLevel;
                size2 = arrayList2.size();
                i16 = i12;
                i17 = i13;
                if (i10 > 0) {
                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                }
                if (size2 > 0) {
                    iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                    if (iArr3[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr3[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ConstraintWidgetContainer constraintWidgetContainer17 = constraintWidgetContainer2;
                    int iMax1111 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer17.mMinWidth);
                    int iMax1112 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer17.mMinHeight);
                    while (i18 < size2) {
                    }
                    arrayList3 = arrayList2;
                    iMax3 = iMax1111;
                    iMax4 = iMax1112;
                    i19 = 0;
                    z7 = false;
                    while (i19 < 2) {
                        zMeasure = z7;
                        i20 = 0;
                        while (i20 < size2) {
                            constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                i21 = size2;
                                z10 = z6;
                                z11 = z5;
                                measurer3 = measurer2;
                                i22 = i19;
                            } else {
                                i21 = size2;
                                if (constraintWidget.mVisibility == 8) {
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    width3 = constraintWidget.getWidth();
                                    height2 = constraintWidget.getHeight();
                                    z10 = z6;
                                    int i1011112 = constraintWidget.mBaselineDistance;
                                    Measurer measurer1114 = measurer2;
                                    i22 = i19;
                                    z11 = z5;
                                    zMeasure |= menuHostHelper.measure(measurer1114, constraintWidget, true);
                                    width4 = constraintWidget.getWidth();
                                    measurer3 = measurer1114;
                                    height3 = constraintWidget.getHeight();
                                    if (width4 != width3) {
                                        constraintWidget.setWidth(width4);
                                        if (!z11) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (height3 != height2) {
                                        constraintWidget.setHeight(height3);
                                        if (!z10) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (!constraintWidget.hasBaseline) {
                                    }
                                }
                            }
                            i20++;
                            size2 = i21;
                            i19 = i22;
                            z6 = z10;
                            z5 = z11;
                            measurer2 = measurer3;
                        }
                        int i1011113 = size2;
                        boolean z2118 = z6;
                        boolean z2119 = z5;
                        Measurer measurer1115 = measurer2;
                        int i1011114 = i19;
                        if (zMeasure) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            z7 = false;
                        } else {
                            z7 = zMeasure;
                        }
                        i19 = i1011114 + 1;
                        size2 = i1011113;
                        z6 = z2118;
                        z5 = z2119;
                        measurer2 = measurer1115;
                    }
                    if (z7) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        if (constraintWidgetContainer4.getWidth() < iMax3) {
                            constraintWidgetContainer4.setWidth(iMax3);
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (constraintWidgetContainer4.getHeight() < iMax4) {
                            constraintWidgetContainer4.setHeight(iMax4);
                            z9 = true;
                        } else {
                            z9 = z8;
                        }
                        if (z9) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        }
                    }
                }
                constraintWidgetContainer4.mOptimizationLevel = i15;
                if ((i15 & 256) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                LinearSystem.OPTIMIZED_ENGINE = z4;
            } else {
                if (i10 > 0) {
                    size3 = constraintWidgetContainer4.mChildren.size();
                    measurer4 = constraintWidgetContainer4.mMeasurer;
                    while (i23 < size3) {
                        constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                        if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                            dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                            int dimensionBehaviour16 = constraintWidget2.getDimensionBehaviour(1);
                            if (dimensionBehaviour == 3) {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            } else {
                                menuHostHelper.measure(measurer4, constraintWidget2, false);
                            }
                        }
                    }
                    constraintLayout = measurer4.layout;
                    childCount = constraintLayout.getChildCount();
                    arrayList4 = constraintLayout.mConstraintHelpers;
                    while (i24 < childCount) {
                        constraintLayout.getChildAt(i24);
                    }
                    size4 = arrayList4.size();
                    if (size4 > 0) {
                        while (i25 < size4) {
                            ((ConstraintHelper) arrayList4.get(i25)).getClass();
                        }
                    }
                }
                i15 = constraintWidgetContainer4.mOptimizationLevel;
                size2 = arrayList2.size();
                i16 = i12;
                i17 = i13;
                if (i10 > 0) {
                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                }
                if (size2 > 0) {
                    iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                    if (iArr3[0] == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (iArr3[1] == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ConstraintWidgetContainer constraintWidgetContainer18 = constraintWidgetContainer2;
                    int iMax1113 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer18.mMinWidth);
                    int iMax1114 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer18.mMinHeight);
                    while (i18 < size2) {
                    }
                    arrayList3 = arrayList2;
                    iMax3 = iMax1113;
                    iMax4 = iMax1114;
                    i19 = 0;
                    z7 = false;
                    while (i19 < 2) {
                        zMeasure = z7;
                        i20 = 0;
                        while (i20 < size2) {
                            constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                                i21 = size2;
                                z10 = z6;
                                z11 = z5;
                                measurer3 = measurer2;
                                i22 = i19;
                            } else {
                                i21 = size2;
                                if (constraintWidget.mVisibility == 8) {
                                    z10 = z6;
                                    z11 = z5;
                                    measurer3 = measurer2;
                                    i22 = i19;
                                } else {
                                    width3 = constraintWidget.getWidth();
                                    height2 = constraintWidget.getHeight();
                                    z10 = z6;
                                    int i1011115 = constraintWidget.mBaselineDistance;
                                    Measurer measurer1116 = measurer2;
                                    i22 = i19;
                                    z11 = z5;
                                    zMeasure |= menuHostHelper.measure(measurer1116, constraintWidget, true);
                                    width4 = constraintWidget.getWidth();
                                    measurer3 = measurer1116;
                                    height3 = constraintWidget.getHeight();
                                    if (width4 != width3) {
                                        constraintWidget.setWidth(width4);
                                        if (!z11) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (height3 != height2) {
                                        constraintWidget.setHeight(height3);
                                        if (!z10) {
                                        }
                                        zMeasure = true;
                                    }
                                    if (!constraintWidget.hasBaseline) {
                                    }
                                }
                            }
                            i20++;
                            size2 = i21;
                            i19 = i22;
                            z6 = z10;
                            z5 = z11;
                            measurer2 = measurer3;
                        }
                        int i1011116 = size2;
                        boolean z21110 = z6;
                        boolean z21111 = z5;
                        Measurer measurer1117 = measurer2;
                        int i1011117 = i19;
                        if (zMeasure) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                            z7 = false;
                        } else {
                            z7 = zMeasure;
                        }
                        i19 = i1011117 + 1;
                        size2 = i1011116;
                        z6 = z21110;
                        z5 = z21111;
                        measurer2 = measurer1117;
                    }
                    if (z7) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        if (constraintWidgetContainer4.getWidth() < iMax3) {
                            constraintWidgetContainer4.setWidth(iMax3);
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (constraintWidgetContainer4.getHeight() < iMax4) {
                            constraintWidgetContainer4.setHeight(iMax4);
                            z9 = true;
                        } else {
                            z9 = z8;
                        }
                        if (z9) {
                            menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        }
                    }
                }
                constraintWidgetContainer4.mOptimizationLevel = i15;
                if ((i15 & 256) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                LinearSystem.OPTIMIZED_ENGINE = z4;
            }
            int width14 = constraintWidgetContainer4.getWidth();
            int height15 = constraintWidgetContainer4.getHeight();
            z12 = constraintWidgetContainer4.mWidthMeasuredTooSmall;
            z13 = constraintWidgetContainer4.mHeightMeasuredTooSmall;
            Measurer measurer1118 = measurer5;
            int i1011118 = measurer1118.paddingHeight;
            int iResolveSizeAndState13 = View.resolveSizeAndState(width14 + measurer1118.paddingWidth, i, 0);
            int iResolveSizeAndState14 = View.resolveSizeAndState(height15 + i1011118, i2, 0) & 16777215;
            iMin = Math.min(this.mMaxWidth, iResolveSizeAndState13 & 16777215);
            iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState14);
            if (z12) {
                iMin |= 16777216;
            }
            if (z13) {
                iMin2 |= 16777216;
            }
            setMeasuredDimension(iMin, iMin2);
        }
        iArr2 = iArr;
        z2 = true;
        if (z2) {
            i37 = 0;
            while (true) {
                if (i37 < size) {
                    z18 = z2;
                    constraintWidget3 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i37);
                    i10 = size;
                    iArr4 = constraintWidget3.mListDimensionBehaviors;
                    i38 = i37;
                    if (iArr4[0] == 3) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (iArr4[1] == 3) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    if (!z19) {
                    }
                    if (constraintWidget3.isInHorizontalChain()) {
                        i37 = i38 + 1;
                        z2 = z18;
                        size = i10;
                    } else {
                        i37 = i38 + 1;
                        z2 = z18;
                        size = i10;
                    }
                    i11 = 1073741824;
                    z3 = false;
                } else {
                    z3 = z2;
                    i10 = size;
                    i11 = 1073741824;
                }
            }
        } else {
            z3 = z2;
            i10 = size;
            i11 = 1073741824;
        }
        if (z3 && ((mode != i11 && mode2 == i11) || z)) {
            iMin3 = Math.min(iArr2[0], i96);
            iMin4 = Math.min(iArr2[1], i97);
            i26 = 1073741824;
            if (mode == 1073741824) {
                if (constraintWidgetContainer4.getWidth() != iMin3) {
                    constraintWidgetContainer4.setWidth(iMin3);
                    fileMetadata.isRegularFile = true;
                }
                i26 = 1073741824;
            }
            if (mode2 == i26) {
                constraintWidgetContainer4.setHeight(iMin4);
                fileMetadata.isRegularFile = true;
            }
            if (mode == i26) {
                constraintWidgetContainer2 = constraintWidgetContainer;
                arrayList2 = arrayList;
                measurer2 = measurer;
                i12 = width2;
                i13 = height;
                constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                if (fileMetadata.isRegularFile) {
                    arrayList5 = constraintWidgetContainer3.mChildren;
                    size5 = arrayList5.size();
                    i29 = 0;
                    while (i29 < size5) {
                        Object obj110 = arrayList5.get(i29);
                        i29++;
                        ConstraintWidget constraintWidget1112 = (ConstraintWidget) obj110;
                        constraintWidget1112.measured = false;
                        HorizontalWidgetRun horizontalWidgetRun118 = constraintWidget1112.horizontalRun;
                        horizontalWidgetRun118.dimension.resolved = false;
                        horizontalWidgetRun118.resolved = false;
                        horizontalWidgetRun118.reset();
                        VerticalWidgetRun verticalWidgetRun118 = constraintWidget1112.verticalRun;
                        verticalWidgetRun118.dimension.resolved = false;
                        verticalWidgetRun118.resolved = false;
                        verticalWidgetRun118.reset();
                    }
                    i27 = 0;
                    constraintWidgetContainer3.measured = false;
                    HorizontalWidgetRun horizontalWidgetRun119 = constraintWidgetContainer3.horizontalRun;
                    horizontalWidgetRun119.dimension.resolved = false;
                    horizontalWidgetRun119.resolved = false;
                    horizontalWidgetRun119.reset();
                    VerticalWidgetRun verticalWidgetRun119 = constraintWidgetContainer3.verticalRun;
                    verticalWidgetRun119.dimension.resolved = false;
                    verticalWidgetRun119.resolved = false;
                    verticalWidgetRun119.reset();
                    fileMetadata.buildGraph();
                } else {
                    i27 = 0;
                }
                fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                constraintWidgetContainer3.mX = i27;
                constraintWidgetContainer3.mY = i27;
                constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                constraintWidgetContainer3.verticalRun.start.resolve(i27);
                i28 = 1073741824;
                if (mode == 1073741824) {
                    zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zDirectMeasureWithOrientation = true;
                }
                if (mode2 == 1073741824) {
                    zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                    i14++;
                }
            } else {
                constraintWidgetContainer2 = constraintWidgetContainer;
                arrayList2 = arrayList;
                measurer2 = measurer;
                i12 = width2;
                i13 = height;
                constraintWidgetContainer3 = (ConstraintWidgetContainer) fileMetadata.symlinkTarget;
                if (fileMetadata.isRegularFile) {
                    arrayList5 = constraintWidgetContainer3.mChildren;
                    size5 = arrayList5.size();
                    i29 = 0;
                    while (i29 < size5) {
                        Object obj111 = arrayList5.get(i29);
                        i29++;
                        ConstraintWidget constraintWidget1113 = (ConstraintWidget) obj111;
                        constraintWidget1113.measured = false;
                        HorizontalWidgetRun horizontalWidgetRun1110 = constraintWidget1113.horizontalRun;
                        horizontalWidgetRun1110.dimension.resolved = false;
                        horizontalWidgetRun1110.resolved = false;
                        horizontalWidgetRun1110.reset();
                        VerticalWidgetRun verticalWidgetRun1110 = constraintWidget1113.verticalRun;
                        verticalWidgetRun1110.dimension.resolved = false;
                        verticalWidgetRun1110.resolved = false;
                        verticalWidgetRun1110.reset();
                    }
                    i27 = 0;
                    constraintWidgetContainer3.measured = false;
                    HorizontalWidgetRun horizontalWidgetRun1111 = constraintWidgetContainer3.horizontalRun;
                    horizontalWidgetRun1111.dimension.resolved = false;
                    horizontalWidgetRun1111.resolved = false;
                    horizontalWidgetRun1111.reset();
                    VerticalWidgetRun verticalWidgetRun1111 = constraintWidgetContainer3.verticalRun;
                    verticalWidgetRun1111.dimension.resolved = false;
                    verticalWidgetRun1111.resolved = false;
                    verticalWidgetRun1111.reset();
                    fileMetadata.buildGraph();
                } else {
                    i27 = 0;
                }
                fileMetadata.basicMeasureWidgets((ConstraintWidgetContainer) fileMetadata.size);
                constraintWidgetContainer3.mX = i27;
                constraintWidgetContainer3.mY = i27;
                constraintWidgetContainer3.horizontalRun.start.resolve(i27);
                constraintWidgetContainer3.verticalRun.start.resolve(i27);
                i28 = 1073741824;
                if (mode == 1073741824) {
                    zDirectMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(i27, z);
                    i14 = 1;
                } else {
                    i14 = 0;
                    zDirectMeasureWithOrientation = true;
                }
                if (mode2 == 1073741824) {
                    zDirectMeasureWithOrientation &= constraintWidgetContainer4.directMeasureWithOrientation(1, z);
                    i14++;
                }
            }
            if (zDirectMeasureWithOrientation) {
                if (mode == i28) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (mode2 == i28) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                constraintWidgetContainer4.updateFromRuns(z14, z15);
            }
        } else {
            constraintWidgetContainer2 = constraintWidgetContainer;
            arrayList2 = arrayList;
            measurer2 = measurer;
            i12 = width2;
            i13 = height;
            i14 = 0;
            zDirectMeasureWithOrientation = false;
        }
        if (zDirectMeasureWithOrientation) {
            if (i10 > 0) {
                size3 = constraintWidgetContainer4.mChildren.size();
                measurer4 = constraintWidgetContainer4.mMeasurer;
                while (i23 < size3) {
                    constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                    if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                        dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                        int dimensionBehaviour17 = constraintWidget2.getDimensionBehaviour(1);
                        if (dimensionBehaviour == 3) {
                            menuHostHelper.measure(measurer4, constraintWidget2, false);
                        } else {
                            menuHostHelper.measure(measurer4, constraintWidget2, false);
                        }
                    }
                }
                constraintLayout = measurer4.layout;
                childCount = constraintLayout.getChildCount();
                arrayList4 = constraintLayout.mConstraintHelpers;
                while (i24 < childCount) {
                    constraintLayout.getChildAt(i24);
                }
                size4 = arrayList4.size();
                if (size4 > 0) {
                    while (i25 < size4) {
                        ((ConstraintHelper) arrayList4.get(i25)).getClass();
                    }
                }
            }
            i15 = constraintWidgetContainer4.mOptimizationLevel;
            size2 = arrayList2.size();
            i16 = i12;
            i17 = i13;
            if (i10 > 0) {
                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
            }
            if (size2 > 0) {
                iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                if (iArr3[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr3[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                ConstraintWidgetContainer constraintWidgetContainer19 = constraintWidgetContainer2;
                int iMax1115 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer19.mMinWidth);
                int iMax1116 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer19.mMinHeight);
                while (i18 < size2) {
                }
                arrayList3 = arrayList2;
                iMax3 = iMax1115;
                iMax4 = iMax1116;
                i19 = 0;
                z7 = false;
                while (i19 < 2) {
                    zMeasure = z7;
                    i20 = 0;
                    while (i20 < size2) {
                        constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                            i21 = size2;
                            z10 = z6;
                            z11 = z5;
                            measurer3 = measurer2;
                            i22 = i19;
                        } else {
                            i21 = size2;
                            if (constraintWidget.mVisibility == 8) {
                                z10 = z6;
                                z11 = z5;
                                measurer3 = measurer2;
                                i22 = i19;
                            } else {
                                width3 = constraintWidget.getWidth();
                                height2 = constraintWidget.getHeight();
                                z10 = z6;
                                int i1011119 = constraintWidget.mBaselineDistance;
                                Measurer measurer1119 = measurer2;
                                i22 = i19;
                                z11 = z5;
                                zMeasure |= menuHostHelper.measure(measurer1119, constraintWidget, true);
                                width4 = constraintWidget.getWidth();
                                measurer3 = measurer1119;
                                height3 = constraintWidget.getHeight();
                                if (width4 != width3) {
                                    constraintWidget.setWidth(width4);
                                    if (!z11) {
                                    }
                                    zMeasure = true;
                                }
                                if (height3 != height2) {
                                    constraintWidget.setHeight(height3);
                                    if (!z10) {
                                    }
                                    zMeasure = true;
                                }
                                if (!constraintWidget.hasBaseline) {
                                }
                            }
                        }
                        i20++;
                        size2 = i21;
                        i19 = i22;
                        z6 = z10;
                        z5 = z11;
                        measurer2 = measurer3;
                    }
                    int i10111110 = size2;
                    boolean z21112 = z6;
                    boolean z21113 = z5;
                    Measurer measurer11110 = measurer2;
                    int i10111111 = i19;
                    if (zMeasure) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        z7 = false;
                    } else {
                        z7 = zMeasure;
                    }
                    i19 = i10111111 + 1;
                    size2 = i10111110;
                    z6 = z21112;
                    z5 = z21113;
                    measurer2 = measurer11110;
                }
                if (z7) {
                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    if (constraintWidgetContainer4.getWidth() < iMax3) {
                        constraintWidgetContainer4.setWidth(iMax3);
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (constraintWidgetContainer4.getHeight() < iMax4) {
                        constraintWidgetContainer4.setHeight(iMax4);
                        z9 = true;
                    } else {
                        z9 = z8;
                    }
                    if (z9) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    }
                }
            }
            constraintWidgetContainer4.mOptimizationLevel = i15;
            if ((i15 & 256) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            LinearSystem.OPTIMIZED_ENGINE = z4;
        } else {
            if (i10 > 0) {
                size3 = constraintWidgetContainer4.mChildren.size();
                measurer4 = constraintWidgetContainer4.mMeasurer;
                while (i23 < size3) {
                    constraintWidget2 = (ConstraintWidget) constraintWidgetContainer4.mChildren.get(i23);
                    if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.Guideline) {
                        dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                        int dimensionBehaviour18 = constraintWidget2.getDimensionBehaviour(1);
                        if (dimensionBehaviour == 3) {
                            menuHostHelper.measure(measurer4, constraintWidget2, false);
                        } else {
                            menuHostHelper.measure(measurer4, constraintWidget2, false);
                        }
                    }
                }
                constraintLayout = measurer4.layout;
                childCount = constraintLayout.getChildCount();
                arrayList4 = constraintLayout.mConstraintHelpers;
                while (i24 < childCount) {
                    constraintLayout.getChildAt(i24);
                }
                size4 = arrayList4.size();
                if (size4 > 0) {
                    while (i25 < size4) {
                        ((ConstraintHelper) arrayList4.get(i25)).getClass();
                    }
                }
            }
            i15 = constraintWidgetContainer4.mOptimizationLevel;
            size2 = arrayList2.size();
            i16 = i12;
            i17 = i13;
            if (i10 > 0) {
                menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
            }
            if (size2 > 0) {
                iArr3 = constraintWidgetContainer4.mListDimensionBehaviors;
                if (iArr3[0] == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iArr3[1] == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                ConstraintWidgetContainer constraintWidgetContainer110 = constraintWidgetContainer2;
                int iMax1117 = Math.max(constraintWidgetContainer4.getWidth(), constraintWidgetContainer110.mMinWidth);
                int iMax1118 = Math.max(constraintWidgetContainer4.getHeight(), constraintWidgetContainer110.mMinHeight);
                while (i18 < size2) {
                }
                arrayList3 = arrayList2;
                iMax3 = iMax1117;
                iMax4 = iMax1118;
                i19 = 0;
                z7 = false;
                while (i19 < 2) {
                    zMeasure = z7;
                    i20 = 0;
                    while (i20 < size2) {
                        constraintWidget = (ConstraintWidget) arrayList3.get(i20);
                        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                            i21 = size2;
                            z10 = z6;
                            z11 = z5;
                            measurer3 = measurer2;
                            i22 = i19;
                        } else {
                            i21 = size2;
                            if (constraintWidget.mVisibility == 8) {
                                z10 = z6;
                                z11 = z5;
                                measurer3 = measurer2;
                                i22 = i19;
                            } else {
                                width3 = constraintWidget.getWidth();
                                height2 = constraintWidget.getHeight();
                                z10 = z6;
                                int i10111112 = constraintWidget.mBaselineDistance;
                                Measurer measurer11111 = measurer2;
                                i22 = i19;
                                z11 = z5;
                                zMeasure |= menuHostHelper.measure(measurer11111, constraintWidget, true);
                                width4 = constraintWidget.getWidth();
                                measurer3 = measurer11111;
                                height3 = constraintWidget.getHeight();
                                if (width4 != width3) {
                                    constraintWidget.setWidth(width4);
                                    if (!z11) {
                                    }
                                    zMeasure = true;
                                }
                                if (height3 != height2) {
                                    constraintWidget.setHeight(height3);
                                    if (!z10) {
                                    }
                                    zMeasure = true;
                                }
                                if (!constraintWidget.hasBaseline) {
                                }
                            }
                        }
                        i20++;
                        size2 = i21;
                        i19 = i22;
                        z6 = z10;
                        z5 = z11;
                        measurer2 = measurer3;
                    }
                    int i10111113 = size2;
                    boolean z21114 = z6;
                    boolean z21115 = z5;
                    Measurer measurer11112 = measurer2;
                    int i10111114 = i19;
                    if (zMeasure) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                        z7 = false;
                    } else {
                        z7 = zMeasure;
                    }
                    i19 = i10111114 + 1;
                    size2 = i10111113;
                    z6 = z21114;
                    z5 = z21115;
                    measurer2 = measurer11112;
                }
                if (z7) {
                    menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    if (constraintWidgetContainer4.getWidth() < iMax3) {
                        constraintWidgetContainer4.setWidth(iMax3);
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (constraintWidgetContainer4.getHeight() < iMax4) {
                        constraintWidgetContainer4.setHeight(iMax4);
                        z9 = true;
                    } else {
                        z9 = z8;
                    }
                    if (z9) {
                        menuHostHelper.solveLinearSystem(constraintWidgetContainer4, i16, i17);
                    }
                }
            }
            constraintWidgetContainer4.mOptimizationLevel = i15;
            if ((i15 & 256) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            LinearSystem.OPTIMIZED_ENGINE = z4;
        }
        int width15 = constraintWidgetContainer4.getWidth();
        int height16 = constraintWidgetContainer4.getHeight();
        z12 = constraintWidgetContainer4.mWidthMeasuredTooSmall;
        z13 = constraintWidgetContainer4.mHeightMeasuredTooSmall;
        Measurer measurer11113 = measurer5;
        int i10111115 = measurer11113.paddingHeight;
        int iResolveSizeAndState15 = View.resolveSizeAndState(width15 + measurer11113.paddingWidth, i, 0);
        int iResolveSizeAndState16 = View.resolveSizeAndState(height16 + i10111115, i2, 0) & 16777215;
        iMin = Math.min(this.mMaxWidth, iResolveSizeAndState15 & 16777215);
        iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState16);
        if (z12) {
            iMin |= 16777216;
        }
        if (z13) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            androidx.constraintlayout.solver.widgets.Guideline guideline = new androidx.constraintlayout.solver.widgets.Guideline();
            layoutParams.widget = guideline;
            layoutParams.isGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            ArrayList arrayList = this.mConstraintHelpers;
            if (!arrayList.contains(constraintHelper)) {
                arrayList.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.mChildren.remove(viewWidget);
        viewWidget.mParent = null;
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008d A[Catch: IOException -> 0x0054, XmlPullParserException -> 0x0056, TryCatch #2 {IOException -> 0x0054, XmlPullParserException -> 0x0056, blocks: (B:3:0x0022, B:36:0x00a7, B:10:0x0031, B:11:0x0039, B:34:0x008d, B:13:0x003d, B:15:0x0045, B:17:0x004c, B:22:0x0058, B:25:0x0061, B:28:0x006a, B:30:0x0072, B:31:0x0081, B:33:0x0089, B:35:0x00a4), top: B:42:0x0022 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x008d, please report this as an issue */
    public final void parseLayoutDescription(int i) {
        final Context context = getContext();
        RequestService requestService = new RequestService(12, false);
        requestService.systemCallbacks = new SparseArray();
        requestService.hardwareBitmapService = new SparseArray();
        final XmlResourceParser xml = context.getResources().getXml(i);
        try {
            Huffman.Node node = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                requestService.parseConstraintSet(context, xml);
                            } else {
                                Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                node = new Huffman.Node(context, xml);
                                ((SparseArray) requestService.systemCallbacks).put(node.symbol, node);
                            } else {
                                Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            }
                            break;
                        case 1382829617:
                            if (!name.equals("StateSet")) {
                                Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            }
                            break;
                        case 1657696882:
                            if (!name.equals("layoutDescription")) {
                                Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                Object obj = new Object(context, xml) { // from class: androidx.constraintlayout.widget.ConstraintLayoutStates$Variant
                                    public final int mConstraintID;
                                    public final float mMaxHeight;
                                    public final float mMaxWidth;
                                    public final float mMinHeight;
                                    public final float mMinWidth;

                                    {
                                        this.mMinWidth = Float.NaN;
                                        this.mMinHeight = Float.NaN;
                                        this.mMaxWidth = Float.NaN;
                                        this.mMaxHeight = Float.NaN;
                                        this.mConstraintID = -1;
                                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xml), R$styleable.Variant);
                                        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                                        for (int i2 = 0; i2 < indexCount; i2++) {
                                            int index = typedArrayObtainStyledAttributes.getIndex(i2);
                                            if (index == 0) {
                                                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                                                this.mConstraintID = resourceId;
                                                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                                                context.getResources().getResourceName(resourceId);
                                                if ("layout".equals(resourceTypeName)) {
                                                    new ConstraintSet().clone((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                                                }
                                            } else if (index == 1) {
                                                this.mMaxHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxHeight);
                                            } else if (index == 2) {
                                                this.mMinHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMinHeight);
                                            } else if (index == 3) {
                                                this.mMaxWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxWidth);
                                            } else if (index == 4) {
                                                this.mMinWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMinWidth);
                                            } else {
                                                Log.v("ConstraintLayoutStates", "Unknown tag");
                                            }
                                        }
                                        typedArrayObtainStyledAttributes.recycle();
                                    }
                                };
                                if (node != null) {
                                    ((ArrayList) node.children).add(obj);
                                }
                            } else {
                                Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            }
                            break;
                        default:
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
        this.mConstraintLayoutSpec = requestService;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.mDirtyHierarchy = true;
        super.requestLayout();
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id = getId();
        SparseArray sparseArray = this.mChildrenByIds;
        sparseArray.remove(id);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        RequestService requestService = this.mConstraintLayoutSpec;
        if (requestService != null) {
            requestService.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        this.mLayoutWidget.mOptimizationLevel = i;
        LinearSystem.OPTIMIZED_ENGINE = (i & 256) == 256;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public static LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.guideBegin = -1;
        layoutParams.guideEnd = -1;
        layoutParams.guidePercent = -1.0f;
        layoutParams.leftToLeft = -1;
        layoutParams.leftToRight = -1;
        layoutParams.rightToLeft = -1;
        layoutParams.rightToRight = -1;
        layoutParams.topToTop = -1;
        layoutParams.topToBottom = -1;
        layoutParams.bottomToTop = -1;
        layoutParams.bottomToBottom = -1;
        layoutParams.baselineToBaseline = -1;
        layoutParams.circleConstraint = -1;
        layoutParams.circleRadius = 0;
        layoutParams.circleAngle = 0.0f;
        layoutParams.startToEnd = -1;
        layoutParams.startToStart = -1;
        layoutParams.endToStart = -1;
        layoutParams.endToEnd = -1;
        layoutParams.goneLeftMargin = -1;
        layoutParams.goneTopMargin = -1;
        layoutParams.goneRightMargin = -1;
        layoutParams.goneBottomMargin = -1;
        layoutParams.goneStartMargin = -1;
        layoutParams.goneEndMargin = -1;
        layoutParams.horizontalBias = 0.5f;
        layoutParams.verticalBias = 0.5f;
        layoutParams.dimensionRatio = null;
        layoutParams.dimensionRatioSide = 1;
        layoutParams.horizontalWeight = -1.0f;
        layoutParams.verticalWeight = -1.0f;
        layoutParams.horizontalChainStyle = 0;
        layoutParams.verticalChainStyle = 0;
        layoutParams.matchConstraintDefaultWidth = 0;
        layoutParams.matchConstraintDefaultHeight = 0;
        layoutParams.matchConstraintMinWidth = 0;
        layoutParams.matchConstraintMinHeight = 0;
        layoutParams.matchConstraintMaxWidth = 0;
        layoutParams.matchConstraintMaxHeight = 0;
        layoutParams.matchConstraintPercentWidth = 1.0f;
        layoutParams.matchConstraintPercentHeight = 1.0f;
        layoutParams.editorAbsoluteX = -1;
        layoutParams.editorAbsoluteY = -1;
        layoutParams.orientation = -1;
        layoutParams.constrainedWidth = false;
        layoutParams.constrainedHeight = false;
        layoutParams.constraintTag = null;
        layoutParams.horizontalDimensionFixed = true;
        layoutParams.verticalDimensionFixed = true;
        layoutParams.needsBaseline = false;
        layoutParams.isGuideline = false;
        layoutParams.isHelper = false;
        layoutParams.resolvedLeftToLeft = -1;
        layoutParams.resolvedLeftToRight = -1;
        layoutParams.resolvedRightToLeft = -1;
        layoutParams.resolvedRightToRight = -1;
        layoutParams.resolveGoneLeftMargin = -1;
        layoutParams.resolveGoneRightMargin = -1;
        layoutParams.resolvedHorizontalBias = 0.5f;
        layoutParams.widget = new ConstraintWidget();
        return layoutParams;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 263;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this);
        init(attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        layoutParams2.guideBegin = -1;
        layoutParams2.guideEnd = -1;
        layoutParams2.guidePercent = -1.0f;
        layoutParams2.leftToLeft = -1;
        layoutParams2.leftToRight = -1;
        layoutParams2.rightToLeft = -1;
        layoutParams2.rightToRight = -1;
        layoutParams2.topToTop = -1;
        layoutParams2.topToBottom = -1;
        layoutParams2.bottomToTop = -1;
        layoutParams2.bottomToBottom = -1;
        layoutParams2.baselineToBaseline = -1;
        layoutParams2.circleConstraint = -1;
        layoutParams2.circleRadius = 0;
        layoutParams2.circleAngle = 0.0f;
        layoutParams2.startToEnd = -1;
        layoutParams2.startToStart = -1;
        layoutParams2.endToStart = -1;
        layoutParams2.endToEnd = -1;
        layoutParams2.goneLeftMargin = -1;
        layoutParams2.goneTopMargin = -1;
        layoutParams2.goneRightMargin = -1;
        layoutParams2.goneBottomMargin = -1;
        layoutParams2.goneStartMargin = -1;
        layoutParams2.goneEndMargin = -1;
        layoutParams2.horizontalBias = 0.5f;
        layoutParams2.verticalBias = 0.5f;
        layoutParams2.dimensionRatio = null;
        layoutParams2.dimensionRatioSide = 1;
        layoutParams2.horizontalWeight = -1.0f;
        layoutParams2.verticalWeight = -1.0f;
        layoutParams2.horizontalChainStyle = 0;
        layoutParams2.verticalChainStyle = 0;
        layoutParams2.matchConstraintDefaultWidth = 0;
        layoutParams2.matchConstraintDefaultHeight = 0;
        layoutParams2.matchConstraintMinWidth = 0;
        layoutParams2.matchConstraintMinHeight = 0;
        layoutParams2.matchConstraintMaxWidth = 0;
        layoutParams2.matchConstraintMaxHeight = 0;
        layoutParams2.matchConstraintPercentWidth = 1.0f;
        layoutParams2.matchConstraintPercentHeight = 1.0f;
        layoutParams2.editorAbsoluteX = -1;
        layoutParams2.editorAbsoluteY = -1;
        layoutParams2.orientation = -1;
        layoutParams2.constrainedWidth = false;
        layoutParams2.constrainedHeight = false;
        layoutParams2.constraintTag = null;
        layoutParams2.horizontalDimensionFixed = true;
        layoutParams2.verticalDimensionFixed = true;
        layoutParams2.needsBaseline = false;
        layoutParams2.isGuideline = false;
        layoutParams2.isHelper = false;
        layoutParams2.resolvedLeftToLeft = -1;
        layoutParams2.resolvedLeftToRight = -1;
        layoutParams2.resolvedRightToLeft = -1;
        layoutParams2.resolvedRightToRight = -1;
        layoutParams2.resolveGoneLeftMargin = -1;
        layoutParams2.resolveGoneRightMargin = -1;
        layoutParams2.resolvedHorizontalBias = 0.5f;
        layoutParams2.widget = new ConstraintWidget();
        return layoutParams2;
    }
}
