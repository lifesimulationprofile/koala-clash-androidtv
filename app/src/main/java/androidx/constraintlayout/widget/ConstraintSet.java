package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.constraintlayout.motion.utils.Easing;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintSet {
    public static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    public static final SparseIntArray mapToConstant;
    public final HashMap mSavedAttributes = new HashMap();
    public final boolean mForceId = true;
    public final HashMap mConstraints = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Constraint {
        public final Layout layout;
        public HashMap mCustomConstraints;
        public int mViewId;
        public final Motion motion;
        public final PropertySet propertySet;
        public final Transform transform;

        public Constraint() {
            PropertySet propertySet = new PropertySet();
            propertySet.visibility = 0;
            propertySet.mVisibilityMode = 0;
            propertySet.alpha = 1.0f;
            propertySet.mProgress = Float.NaN;
            this.propertySet = propertySet;
            Motion motion = new Motion();
            motion.mAnimateRelativeTo = -1;
            motion.mPathMotionArc = -1;
            motion.mMotionStagger = Float.NaN;
            motion.mPathRotate = Float.NaN;
            this.motion = motion;
            Layout layout = new Layout();
            layout.mIsGuideline = false;
            layout.guideBegin = -1;
            layout.guideEnd = -1;
            layout.guidePercent = -1.0f;
            layout.leftToLeft = -1;
            layout.leftToRight = -1;
            layout.rightToLeft = -1;
            layout.rightToRight = -1;
            layout.topToTop = -1;
            layout.topToBottom = -1;
            layout.bottomToTop = -1;
            layout.bottomToBottom = -1;
            layout.baselineToBaseline = -1;
            layout.startToEnd = -1;
            layout.startToStart = -1;
            layout.endToStart = -1;
            layout.endToEnd = -1;
            layout.horizontalBias = 0.5f;
            layout.verticalBias = 0.5f;
            layout.dimensionRatio = null;
            layout.circleConstraint = -1;
            layout.circleRadius = 0;
            layout.circleAngle = 0.0f;
            layout.editorAbsoluteX = -1;
            layout.editorAbsoluteY = -1;
            layout.orientation = -1;
            layout.leftMargin = -1;
            layout.rightMargin = -1;
            layout.topMargin = -1;
            layout.bottomMargin = -1;
            layout.endMargin = -1;
            layout.startMargin = -1;
            layout.goneLeftMargin = -1;
            layout.goneTopMargin = -1;
            layout.goneRightMargin = -1;
            layout.goneBottomMargin = -1;
            layout.goneEndMargin = -1;
            layout.goneStartMargin = -1;
            layout.verticalWeight = -1.0f;
            layout.horizontalWeight = -1.0f;
            layout.horizontalChainStyle = 0;
            layout.verticalChainStyle = 0;
            layout.widthDefault = 0;
            layout.heightDefault = 0;
            layout.widthMax = -1;
            layout.heightMax = -1;
            layout.widthMin = -1;
            layout.heightMin = -1;
            layout.widthPercent = 1.0f;
            layout.heightPercent = 1.0f;
            layout.mBarrierDirection = -1;
            layout.mBarrierMargin = 0;
            layout.mHelperType = -1;
            layout.constrainedWidth = false;
            layout.constrainedHeight = false;
            layout.mBarrierAllowsGoneWidgets = true;
            this.layout = layout;
            Transform transform = new Transform();
            transform.rotation = 0.0f;
            transform.rotationX = 0.0f;
            transform.rotationY = 0.0f;
            transform.scaleX = 1.0f;
            transform.scaleY = 1.0f;
            transform.transformPivotX = Float.NaN;
            transform.transformPivotY = Float.NaN;
            transform.translationX = 0.0f;
            transform.translationY = 0.0f;
            transform.translationZ = 0.0f;
            transform.applyElevation = false;
            transform.elevation = 0.0f;
            this.transform = transform;
            this.mCustomConstraints = new HashMap();
        }

        public final void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.layout;
            layoutParams.leftToLeft = layout.leftToLeft;
            layoutParams.leftToRight = layout.leftToRight;
            layoutParams.rightToLeft = layout.rightToLeft;
            layoutParams.rightToRight = layout.rightToRight;
            layoutParams.topToTop = layout.topToTop;
            layoutParams.topToBottom = layout.topToBottom;
            layoutParams.bottomToTop = layout.bottomToTop;
            layoutParams.bottomToBottom = layout.bottomToBottom;
            layoutParams.baselineToBaseline = layout.baselineToBaseline;
            layoutParams.startToEnd = layout.startToEnd;
            layoutParams.startToStart = layout.startToStart;
            layoutParams.endToStart = layout.endToStart;
            layoutParams.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
            layoutParams.goneStartMargin = layout.goneStartMargin;
            layoutParams.goneEndMargin = layout.goneEndMargin;
            layoutParams.goneTopMargin = layout.goneTopMargin;
            layoutParams.goneBottomMargin = layout.goneBottomMargin;
            layoutParams.horizontalBias = layout.horizontalBias;
            layoutParams.verticalBias = layout.verticalBias;
            layoutParams.circleConstraint = layout.circleConstraint;
            layoutParams.circleRadius = layout.circleRadius;
            layoutParams.circleAngle = layout.circleAngle;
            layoutParams.dimensionRatio = layout.dimensionRatio;
            layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            layoutParams.verticalWeight = layout.verticalWeight;
            layoutParams.horizontalWeight = layout.horizontalWeight;
            layoutParams.verticalChainStyle = layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            layoutParams.constrainedWidth = layout.constrainedWidth;
            layoutParams.constrainedHeight = layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout.widthMax;
            layoutParams.matchConstraintMaxHeight = layout.heightMax;
            layoutParams.matchConstraintMinWidth = layout.widthMin;
            layoutParams.matchConstraintMinHeight = layout.heightMin;
            layoutParams.matchConstraintPercentWidth = layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout.heightPercent;
            layoutParams.orientation = layout.orientation;
            layoutParams.guidePercent = layout.guidePercent;
            layoutParams.guideBegin = layout.guideBegin;
            layoutParams.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.setMarginStart(layout.startMargin);
            layoutParams.setMarginEnd(layout.endMargin);
            layoutParams.validate();
        }

        public final Object clone() {
            Constraint constraint = new Constraint();
            Layout layout = constraint.layout;
            layout.getClass();
            Layout layout2 = this.layout;
            layout.mIsGuideline = layout2.mIsGuideline;
            layout.mWidth = layout2.mWidth;
            layout.mHeight = layout2.mHeight;
            layout.guideBegin = layout2.guideBegin;
            layout.guideEnd = layout2.guideEnd;
            layout.guidePercent = layout2.guidePercent;
            layout.leftToLeft = layout2.leftToLeft;
            layout.leftToRight = layout2.leftToRight;
            layout.rightToLeft = layout2.rightToLeft;
            layout.rightToRight = layout2.rightToRight;
            layout.topToTop = layout2.topToTop;
            layout.topToBottom = layout2.topToBottom;
            layout.bottomToTop = layout2.bottomToTop;
            layout.bottomToBottom = layout2.bottomToBottom;
            layout.baselineToBaseline = layout2.baselineToBaseline;
            layout.startToEnd = layout2.startToEnd;
            layout.startToStart = layout2.startToStart;
            layout.endToStart = layout2.endToStart;
            layout.endToEnd = layout2.endToEnd;
            layout.horizontalBias = layout2.horizontalBias;
            layout.verticalBias = layout2.verticalBias;
            layout.dimensionRatio = layout2.dimensionRatio;
            layout.circleConstraint = layout2.circleConstraint;
            layout.circleRadius = layout2.circleRadius;
            layout.circleAngle = layout2.circleAngle;
            layout.editorAbsoluteX = layout2.editorAbsoluteX;
            layout.editorAbsoluteY = layout2.editorAbsoluteY;
            layout.orientation = layout2.orientation;
            layout.leftMargin = layout2.leftMargin;
            layout.rightMargin = layout2.rightMargin;
            layout.topMargin = layout2.topMargin;
            layout.bottomMargin = layout2.bottomMargin;
            layout.endMargin = layout2.endMargin;
            layout.startMargin = layout2.startMargin;
            layout.goneLeftMargin = layout2.goneLeftMargin;
            layout.goneTopMargin = layout2.goneTopMargin;
            layout.goneRightMargin = layout2.goneRightMargin;
            layout.goneBottomMargin = layout2.goneBottomMargin;
            layout.goneEndMargin = layout2.goneEndMargin;
            layout.goneStartMargin = layout2.goneStartMargin;
            layout.verticalWeight = layout2.verticalWeight;
            layout.horizontalWeight = layout2.horizontalWeight;
            layout.horizontalChainStyle = layout2.horizontalChainStyle;
            layout.verticalChainStyle = layout2.verticalChainStyle;
            layout.widthDefault = layout2.widthDefault;
            layout.heightDefault = layout2.heightDefault;
            layout.widthMax = layout2.widthMax;
            layout.heightMax = layout2.heightMax;
            layout.widthMin = layout2.widthMin;
            layout.heightMin = layout2.heightMin;
            layout.widthPercent = layout2.widthPercent;
            layout.heightPercent = layout2.heightPercent;
            layout.mBarrierDirection = layout2.mBarrierDirection;
            layout.mBarrierMargin = layout2.mBarrierMargin;
            layout.mHelperType = layout2.mHelperType;
            layout.mConstraintTag = layout2.mConstraintTag;
            int[] iArr = layout2.mReferenceIds;
            if (iArr != null) {
                layout.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            } else {
                layout.mReferenceIds = null;
            }
            layout.mReferenceIdString = layout2.mReferenceIdString;
            layout.constrainedWidth = layout2.constrainedWidth;
            layout.constrainedHeight = layout2.constrainedHeight;
            layout.mBarrierAllowsGoneWidgets = layout2.mBarrierAllowsGoneWidgets;
            Motion motion = constraint.motion;
            motion.getClass();
            Motion motion2 = this.motion;
            motion2.getClass();
            motion.mAnimateRelativeTo = motion2.mAnimateRelativeTo;
            motion.mPathMotionArc = motion2.mPathMotionArc;
            motion.mPathRotate = motion2.mPathRotate;
            motion.mMotionStagger = motion2.mMotionStagger;
            PropertySet propertySet = this.propertySet;
            int i = propertySet.visibility;
            PropertySet propertySet2 = constraint.propertySet;
            propertySet2.visibility = i;
            propertySet2.alpha = propertySet.alpha;
            propertySet2.mProgress = propertySet.mProgress;
            propertySet2.mVisibilityMode = propertySet.mVisibilityMode;
            Transform transform = constraint.transform;
            transform.getClass();
            Transform transform2 = this.transform;
            transform2.getClass();
            transform.rotation = transform2.rotation;
            transform.rotationX = transform2.rotationX;
            transform.rotationY = transform2.rotationY;
            transform.scaleX = transform2.scaleX;
            transform.scaleY = transform2.scaleY;
            transform.transformPivotX = transform2.transformPivotX;
            transform.transformPivotY = transform2.transformPivotY;
            transform.translationX = transform2.translationX;
            transform.translationY = transform2.translationY;
            transform.translationZ = transform2.translationZ;
            transform.applyElevation = transform2.applyElevation;
            transform.elevation = transform2.elevation;
            constraint.mViewId = this.mViewId;
            return constraint;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Layout {
        public static final SparseIntArray mapToConstant;
        public int baselineToBaseline;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endMargin;
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
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mBarrierMargin;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType;
        public boolean mIsGuideline;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(38, 24);
            sparseIntArray.append(39, 25);
            sparseIntArray.append(41, 28);
            sparseIntArray.append(42, 29);
            sparseIntArray.append(47, 35);
            sparseIntArray.append(46, 34);
            sparseIntArray.append(20, 4);
            sparseIntArray.append(19, 3);
            sparseIntArray.append(17, 1);
            sparseIntArray.append(55, 6);
            sparseIntArray.append(56, 7);
            sparseIntArray.append(27, 17);
            sparseIntArray.append(28, 18);
            sparseIntArray.append(29, 19);
            sparseIntArray.append(0, 26);
            sparseIntArray.append(43, 31);
            sparseIntArray.append(44, 32);
            sparseIntArray.append(26, 10);
            sparseIntArray.append(25, 9);
            sparseIntArray.append(59, 13);
            sparseIntArray.append(62, 16);
            sparseIntArray.append(60, 14);
            sparseIntArray.append(57, 11);
            sparseIntArray.append(61, 15);
            sparseIntArray.append(58, 12);
            sparseIntArray.append(50, 38);
            sparseIntArray.append(36, 37);
            sparseIntArray.append(35, 39);
            sparseIntArray.append(49, 40);
            sparseIntArray.append(34, 20);
            sparseIntArray.append(48, 36);
            sparseIntArray.append(24, 5);
            sparseIntArray.append(37, 76);
            sparseIntArray.append(45, 76);
            sparseIntArray.append(40, 76);
            sparseIntArray.append(18, 76);
            sparseIntArray.append(16, 76);
            sparseIntArray.append(3, 23);
            sparseIntArray.append(5, 27);
            sparseIntArray.append(7, 30);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(4, 33);
            sparseIntArray.append(6, 2);
            sparseIntArray.append(1, 22);
            sparseIntArray.append(2, 21);
            sparseIntArray.append(21, 61);
            sparseIntArray.append(23, 62);
            sparseIntArray.append(22, 63);
            sparseIntArray.append(54, 69);
            sparseIntArray.append(33, 70);
            sparseIntArray.append(12, 71);
            sparseIntArray.append(10, 72);
            sparseIntArray.append(11, 73);
            sparseIntArray.append(13, 74);
            sparseIntArray.append(9, 75);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                SparseIntArray sparseIntArray = mapToConstant;
                int i2 = sparseIntArray.get(index);
                if (i2 == 80) {
                    this.constrainedWidth = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            this.baselineToBaseline = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.baselineToBaseline);
                            break;
                        case 2:
                            this.bottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                            break;
                        case 3:
                            this.bottomToBottom = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.bottomToBottom);
                            break;
                        case 4:
                            this.bottomToTop = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.bottomToTop);
                            break;
                        case 5:
                            this.dimensionRatio = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.editorAbsoluteX = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                            break;
                        case 7:
                            this.editorAbsoluteY = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                            break;
                        case 8:
                            this.endMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                            break;
                        case 9:
                            this.endToEnd = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.endToEnd);
                            break;
                        case 10:
                            this.endToStart = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.endToStart);
                            break;
                        case 11:
                            this.goneBottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                            break;
                        case 12:
                            this.goneEndMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                            break;
                        case 13:
                            this.goneLeftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                            break;
                        case 14:
                            this.goneRightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                            break;
                        case 15:
                            this.goneStartMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                            break;
                        case 16:
                            this.goneTopMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                            break;
                        case 17:
                            this.guideBegin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                            break;
                        case 18:
                            this.guideEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                            break;
                        case 19:
                            this.guidePercent = typedArrayObtainStyledAttributes.getFloat(index, this.guidePercent);
                            break;
                        case 20:
                            this.horizontalBias = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalBias);
                            break;
                        case 21:
                            this.mHeight = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                            break;
                        case 22:
                            this.mWidth = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                            break;
                        case 23:
                            this.leftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                            break;
                        case 24:
                            this.leftToLeft = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.leftToLeft);
                            break;
                        case 25:
                            this.leftToRight = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.leftToRight);
                            break;
                        case 26:
                            this.orientation = typedArrayObtainStyledAttributes.getInt(index, this.orientation);
                            break;
                        case 27:
                            this.rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                            break;
                        case 28:
                            this.rightToLeft = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.rightToLeft);
                            break;
                        case 29:
                            this.rightToRight = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.rightToRight);
                            break;
                        case 30:
                            this.startMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                            break;
                        case 31:
                            this.startToEnd = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.startToEnd);
                            break;
                        case 32:
                            this.startToStart = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.startToStart);
                            break;
                        case 33:
                            this.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                            break;
                        case 34:
                            this.topToBottom = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.topToBottom);
                            break;
                        case 35:
                            this.topToTop = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.topToTop);
                            break;
                        case 36:
                            this.verticalBias = typedArrayObtainStyledAttributes.getFloat(index, this.verticalBias);
                            break;
                        case 37:
                            this.horizontalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalWeight);
                            break;
                        case 38:
                            this.verticalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.verticalWeight);
                            break;
                        case 39:
                            this.horizontalChainStyle = typedArrayObtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                            break;
                        case 40:
                            this.verticalChainStyle = typedArrayObtainStyledAttributes.getInt(index, this.verticalChainStyle);
                            break;
                        default:
                            switch (i2) {
                                case 54:
                                    this.widthDefault = typedArrayObtainStyledAttributes.getInt(index, this.widthDefault);
                                    break;
                                case 55:
                                    this.heightDefault = typedArrayObtainStyledAttributes.getInt(index, this.heightDefault);
                                    break;
                                case 56:
                                    this.widthMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                    break;
                                case 57:
                                    this.heightMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                    break;
                                case 58:
                                    this.widthMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                    break;
                                case 59:
                                    this.heightMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                    break;
                                default:
                                    switch (i2) {
                                        case 61:
                                            this.circleConstraint = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.circleConstraint);
                                            break;
                                        case 62:
                                            this.circleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                            break;
                                        case 63:
                                            this.circleAngle = typedArrayObtainStyledAttributes.getFloat(index, this.circleAngle);
                                            break;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.widthPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.heightPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.mBarrierDirection = typedArrayObtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                    break;
                                                case 73:
                                                    this.mBarrierMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                    break;
                                                case 74:
                                                    this.mReferenceIdString = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.mBarrierAllowsGoneWidgets = typedArrayObtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                    break;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                    break;
                                                case 77:
                                                    this.mConstraintTag = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    this.constrainedHeight = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Motion {
        public static final SparseIntArray mapToConstant;
        public int mAnimateRelativeTo;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(2, 1);
            sparseIntArray.append(4, 2);
            sparseIntArray.append(5, 3);
            sparseIntArray.append(1, 4);
            sparseIntArray.append(0, 5);
            sparseIntArray.append(3, 6);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = typedArrayObtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = typedArrayObtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            String str = Easing.NAMED_EASING[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mMotionStagger = typedArrayObtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class PropertySet {
        public float alpha;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.alpha = typedArrayObtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == 0) {
                    int i2 = typedArrayObtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = i2;
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[i2];
                } else if (index == 4) {
                    this.mVisibilityMode = typedArrayObtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == 3) {
                    this.mProgress = typedArrayObtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Transform {
        public static final SparseIntArray mapToConstant;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(6, 1);
            sparseIntArray.append(7, 2);
            sparseIntArray.append(8, 3);
            sparseIntArray.append(4, 4);
            sparseIntArray.append(5, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(1, 7);
            sparseIntArray.append(2, 8);
            sparseIntArray.append(3, 9);
            sparseIntArray.append(9, 10);
            sparseIntArray.append(10, 11);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = typedArrayObtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = typedArrayObtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = typedArrayObtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = typedArrayObtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = typedArrayObtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = typedArrayObtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = typedArrayObtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = typedArrayObtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = typedArrayObtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = typedArrayObtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = typedArrayObtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(76, 25);
        sparseIntArray.append(77, 26);
        sparseIntArray.append(79, 29);
        sparseIntArray.append(80, 30);
        sparseIntArray.append(86, 36);
        sparseIntArray.append(85, 35);
        sparseIntArray.append(58, 4);
        sparseIntArray.append(57, 3);
        sparseIntArray.append(55, 1);
        sparseIntArray.append(94, 6);
        sparseIntArray.append(95, 7);
        sparseIntArray.append(65, 17);
        sparseIntArray.append(66, 18);
        sparseIntArray.append(67, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(81, 32);
        sparseIntArray.append(82, 33);
        sparseIntArray.append(64, 10);
        sparseIntArray.append(63, 9);
        sparseIntArray.append(98, 13);
        sparseIntArray.append(101, 16);
        sparseIntArray.append(99, 14);
        sparseIntArray.append(96, 11);
        sparseIntArray.append(100, 15);
        sparseIntArray.append(97, 12);
        sparseIntArray.append(89, 40);
        sparseIntArray.append(74, 39);
        sparseIntArray.append(73, 41);
        sparseIntArray.append(88, 42);
        sparseIntArray.append(72, 20);
        sparseIntArray.append(87, 37);
        sparseIntArray.append(62, 5);
        sparseIntArray.append(75, 82);
        sparseIntArray.append(84, 82);
        sparseIntArray.append(78, 82);
        sparseIntArray.append(56, 82);
        sparseIntArray.append(54, 82);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(90, 54);
        sparseIntArray.append(68, 55);
        sparseIntArray.append(91, 56);
        sparseIntArray.append(69, 57);
        sparseIntArray.append(92, 58);
        sparseIntArray.append(70, 59);
        sparseIntArray.append(59, 61);
        sparseIntArray.append(61, 62);
        sparseIntArray.append(60, 63);
        sparseIntArray.append(27, 64);
        sparseIntArray.append(106, 65);
        sparseIntArray.append(33, 66);
        sparseIntArray.append(107, 67);
        sparseIntArray.append(103, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(102, 68);
        sparseIntArray.append(93, 69);
        sparseIntArray.append(71, 70);
        sparseIntArray.append(31, 71);
        sparseIntArray.append(29, 72);
        sparseIntArray.append(30, 73);
        sparseIntArray.append(32, 74);
        sparseIntArray.append(28, 75);
        sparseIntArray.append(104, 76);
        sparseIntArray.append(83, 77);
        sparseIntArray.append(108, 78);
        sparseIntArray.append(53, 80);
        sparseIntArray.append(52, 81);
    }

    public static int[] convertReferenceString(Barrier barrier, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = R$id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) strTrim)) {
                    HashMap map = constraintLayout.mDesignIds;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.mDesignIds.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public static Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Constraint);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            Motion motion = constraint.motion;
            Transform transform = constraint.transform;
            Layout layout = constraint.layout;
            if (index != 1 && 23 != index && 24 != index) {
                motion.getClass();
                layout.getClass();
                transform.getClass();
            }
            SparseIntArray sparseIntArray = mapToConstant;
            int i2 = sparseIntArray.get(index);
            PropertySet propertySet = constraint.propertySet;
            switch (i2) {
                case 1:
                    layout.baselineToBaseline = lookupID(typedArrayObtainStyledAttributes, index, layout.baselineToBaseline);
                    break;
                case 2:
                    layout.bottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.bottomMargin);
                    break;
                case 3:
                    layout.bottomToBottom = lookupID(typedArrayObtainStyledAttributes, index, layout.bottomToBottom);
                    break;
                case 4:
                    layout.bottomToTop = lookupID(typedArrayObtainStyledAttributes, index, layout.bottomToTop);
                    break;
                case 5:
                    layout.dimensionRatio = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    layout.editorAbsoluteX = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layout.editorAbsoluteX);
                    break;
                case 7:
                    layout.editorAbsoluteY = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layout.editorAbsoluteY);
                    break;
                case 8:
                    layout.endMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.endMargin);
                    break;
                case 9:
                    layout.endToEnd = lookupID(typedArrayObtainStyledAttributes, index, layout.endToEnd);
                    break;
                case 10:
                    layout.endToStart = lookupID(typedArrayObtainStyledAttributes, index, layout.endToStart);
                    break;
                case 11:
                    layout.goneBottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.goneBottomMargin);
                    break;
                case 12:
                    layout.goneEndMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.goneEndMargin);
                    break;
                case 13:
                    layout.goneLeftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.goneLeftMargin);
                    break;
                case 14:
                    layout.goneRightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.goneRightMargin);
                    break;
                case 15:
                    layout.goneStartMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.goneStartMargin);
                    break;
                case 16:
                    layout.goneTopMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.goneTopMargin);
                    break;
                case 17:
                    layout.guideBegin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layout.guideBegin);
                    break;
                case 18:
                    layout.guideEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layout.guideEnd);
                    break;
                case 19:
                    layout.guidePercent = typedArrayObtainStyledAttributes.getFloat(index, layout.guidePercent);
                    break;
                case 20:
                    layout.horizontalBias = typedArrayObtainStyledAttributes.getFloat(index, layout.horizontalBias);
                    break;
                case 21:
                    layout.mHeight = typedArrayObtainStyledAttributes.getLayoutDimension(index, layout.mHeight);
                    break;
                case 22:
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, propertySet.visibility);
                    propertySet.visibility = i3;
                    propertySet.visibility = VISIBILITY_FLAGS[i3];
                    break;
                case 23:
                    layout.mWidth = typedArrayObtainStyledAttributes.getLayoutDimension(index, layout.mWidth);
                    break;
                case 24:
                    layout.leftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.leftMargin);
                    break;
                case 25:
                    layout.leftToLeft = lookupID(typedArrayObtainStyledAttributes, index, layout.leftToLeft);
                    break;
                case 26:
                    layout.leftToRight = lookupID(typedArrayObtainStyledAttributes, index, layout.leftToRight);
                    break;
                case 27:
                    layout.orientation = typedArrayObtainStyledAttributes.getInt(index, layout.orientation);
                    break;
                case 28:
                    layout.rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.rightMargin);
                    break;
                case 29:
                    layout.rightToLeft = lookupID(typedArrayObtainStyledAttributes, index, layout.rightToLeft);
                    break;
                case 30:
                    layout.rightToRight = lookupID(typedArrayObtainStyledAttributes, index, layout.rightToRight);
                    break;
                case 31:
                    layout.startMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.startMargin);
                    break;
                case 32:
                    layout.startToEnd = lookupID(typedArrayObtainStyledAttributes, index, layout.startToEnd);
                    break;
                case 33:
                    layout.startToStart = lookupID(typedArrayObtainStyledAttributes, index, layout.startToStart);
                    break;
                case 34:
                    layout.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.topMargin);
                    break;
                case 35:
                    layout.topToBottom = lookupID(typedArrayObtainStyledAttributes, index, layout.topToBottom);
                    break;
                case 36:
                    layout.topToTop = lookupID(typedArrayObtainStyledAttributes, index, layout.topToTop);
                    break;
                case 37:
                    layout.verticalBias = typedArrayObtainStyledAttributes.getFloat(index, layout.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = typedArrayObtainStyledAttributes.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    layout.horizontalWeight = typedArrayObtainStyledAttributes.getFloat(index, layout.horizontalWeight);
                    break;
                case 40:
                    layout.verticalWeight = typedArrayObtainStyledAttributes.getFloat(index, layout.verticalWeight);
                    break;
                case 41:
                    layout.horizontalChainStyle = typedArrayObtainStyledAttributes.getInt(index, layout.horizontalChainStyle);
                    break;
                case 42:
                    layout.verticalChainStyle = typedArrayObtainStyledAttributes.getInt(index, layout.verticalChainStyle);
                    break;
                case 43:
                    propertySet.alpha = typedArrayObtainStyledAttributes.getFloat(index, propertySet.alpha);
                    break;
                case 44:
                    transform.applyElevation = true;
                    transform.elevation = typedArrayObtainStyledAttributes.getDimension(index, transform.elevation);
                    break;
                case 45:
                    transform.rotationX = typedArrayObtainStyledAttributes.getFloat(index, transform.rotationX);
                    break;
                case 46:
                    transform.rotationY = typedArrayObtainStyledAttributes.getFloat(index, transform.rotationY);
                    break;
                case 47:
                    transform.scaleX = typedArrayObtainStyledAttributes.getFloat(index, transform.scaleX);
                    break;
                case 48:
                    transform.scaleY = typedArrayObtainStyledAttributes.getFloat(index, transform.scaleY);
                    break;
                case 49:
                    transform.transformPivotX = typedArrayObtainStyledAttributes.getDimension(index, transform.transformPivotX);
                    break;
                case 50:
                    transform.transformPivotY = typedArrayObtainStyledAttributes.getDimension(index, transform.transformPivotY);
                    break;
                case 51:
                    transform.translationX = typedArrayObtainStyledAttributes.getDimension(index, transform.translationX);
                    break;
                case 52:
                    transform.translationY = typedArrayObtainStyledAttributes.getDimension(index, transform.translationY);
                    break;
                case 53:
                    transform.translationZ = typedArrayObtainStyledAttributes.getDimension(index, transform.translationZ);
                    break;
                case 54:
                    layout.widthDefault = typedArrayObtainStyledAttributes.getInt(index, layout.widthDefault);
                    break;
                case 55:
                    layout.heightDefault = typedArrayObtainStyledAttributes.getInt(index, layout.heightDefault);
                    break;
                case 56:
                    layout.widthMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.widthMax);
                    break;
                case 57:
                    layout.heightMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.heightMax);
                    break;
                case 58:
                    layout.widthMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.widthMin);
                    break;
                case 59:
                    layout.heightMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.heightMin);
                    break;
                case 60:
                    transform.rotation = typedArrayObtainStyledAttributes.getFloat(index, transform.rotation);
                    break;
                case 61:
                    layout.circleConstraint = lookupID(typedArrayObtainStyledAttributes, index, layout.circleConstraint);
                    break;
                case 62:
                    layout.circleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.circleRadius);
                    break;
                case 63:
                    layout.circleAngle = typedArrayObtainStyledAttributes.getFloat(index, layout.circleAngle);
                    break;
                case 64:
                    motion.mAnimateRelativeTo = lookupID(typedArrayObtainStyledAttributes, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        motion.getClass();
                    } else {
                        String str = Easing.NAMED_EASING[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        motion.getClass();
                    }
                    break;
                case 66:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    motion.getClass();
                    break;
                case 67:
                    motion.mPathRotate = typedArrayObtainStyledAttributes.getFloat(index, motion.mPathRotate);
                    break;
                case 68:
                    propertySet.mProgress = typedArrayObtainStyledAttributes.getFloat(index, propertySet.mProgress);
                    break;
                case 69:
                    layout.widthPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    layout.heightPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    layout.mBarrierDirection = typedArrayObtainStyledAttributes.getInt(index, layout.mBarrierDirection);
                    break;
                case 73:
                    layout.mBarrierMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.mBarrierMargin);
                    break;
                case 74:
                    layout.mReferenceIdString = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 75:
                    layout.mBarrierAllowsGoneWidgets = typedArrayObtainStyledAttributes.getBoolean(index, layout.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    motion.mPathMotionArc = typedArrayObtainStyledAttributes.getInt(index, motion.mPathMotionArc);
                    break;
                case 77:
                    layout.mConstraintTag = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 78:
                    propertySet.mVisibilityMode = typedArrayObtainStyledAttributes.getInt(index, propertySet.mVisibilityMode);
                    break;
                case 79:
                    motion.mMotionStagger = typedArrayObtainStyledAttributes.getFloat(index, motion.mMotionStagger);
                    break;
                case 80:
                    layout.constrainedWidth = typedArrayObtainStyledAttributes.getBoolean(index, layout.constrainedWidth);
                    break;
                case 81:
                    layout.constrainedHeight = typedArrayObtainStyledAttributes.getBoolean(index, layout.constrainedHeight);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    public static int lookupID(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    public final void applyToInternal(ConstraintLayout constraintLayout) {
        int i;
        HashSet hashSet;
        int i2;
        int i3;
        String resourceEntryName;
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = constraintSet.mConstraints;
        HashSet<Integer> hashSet2 = new HashSet(map.keySet());
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = constraintLayout.getChildAt(i4);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (constraintSet.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map.containsKey(Integer.valueOf(id))) {
                        hashSet2.remove(Integer.valueOf(id));
                        Constraint constraint = (Constraint) map.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            constraint.layout.mHelperType = 1;
                        }
                        Layout layout = constraint.layout;
                        PropertySet propertySet = constraint.propertySet;
                        Transform transform = constraint.transform;
                        int i5 = layout.mHelperType;
                        if (i5 != -1 && i5 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(layout.mBarrierDirection);
                            barrier.setMargin(layout.mBarrierMargin);
                            barrier.setAllowsGoneWidget(layout.mBarrierAllowsGoneWidgets);
                            int[] iArr = layout.mReferenceIds;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = layout.mReferenceIdString;
                                if (str != null) {
                                    int[] iArrConvertReferenceString = convertReferenceString(barrier, str);
                                    layout.mReferenceIds = iArrConvertReferenceString;
                                    barrier.setReferencedIds(iArrConvertReferenceString);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.validate();
                        constraint.applyTo(layoutParams);
                        HashMap map2 = constraint.mCustomConstraints;
                        Class<?> cls = childAt.getClass();
                        for (String str2 : map2.keySet()) {
                            ConstraintAttribute constraintAttribute = (ConstraintAttribute) map2.get(str2);
                            int i6 = childCount;
                            String strM = CaptureSession$State$EnumUnboxingLocalUtility.m("set", str2);
                            HashSet hashSet3 = hashSet2;
                            try {
                                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(constraintAttribute.mType);
                                Class<?> cls2 = Integer.TYPE;
                                Class<?> cls3 = Float.TYPE;
                                switch (iOrdinal) {
                                    case 0:
                                        i3 = i4;
                                        cls.getMethod(strM, cls2).invoke(childAt, Integer.valueOf(constraintAttribute.mIntegerValue));
                                        break;
                                    case 1:
                                        i3 = i4;
                                        cls.getMethod(strM, cls3).invoke(childAt, Float.valueOf(constraintAttribute.mFloatValue));
                                        break;
                                    case 2:
                                        i3 = i4;
                                        cls.getMethod(strM, cls2).invoke(childAt, Integer.valueOf(constraintAttribute.mColorValue));
                                        break;
                                    case 3:
                                        i3 = i4;
                                        Method method = cls.getMethod(strM, Drawable.class);
                                        ColorDrawable colorDrawable = new ColorDrawable();
                                        colorDrawable.setColor(constraintAttribute.mColorValue);
                                        method.invoke(childAt, colorDrawable);
                                        break;
                                    case 4:
                                        i3 = i4;
                                        cls.getMethod(strM, CharSequence.class).invoke(childAt, constraintAttribute.mStringValue);
                                        break;
                                    case 5:
                                        i3 = i4;
                                        cls.getMethod(strM, Boolean.TYPE).invoke(childAt, Boolean.valueOf(constraintAttribute.mBooleanValue));
                                        break;
                                    case 6:
                                        i3 = i4;
                                        try {
                                            cls.getMethod(strM, cls3).invoke(childAt, Float.valueOf(constraintAttribute.mFloatValue));
                                        } catch (IllegalAccessException e) {
                                            e = e;
                                            StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m(" Custom Attribute \"", str2, "\" not found on ");
                                            sbM16m.append(cls.getName());
                                            Log.e("TransitionLayout", sbM16m.toString());
                                            e.printStackTrace();
                                        } catch (NoSuchMethodException e2) {
                                            e = e2;
                                            Log.e("TransitionLayout", e.getMessage());
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + strM);
                                        } catch (InvocationTargetException e3) {
                                            e = e3;
                                            StringBuilder sbM16m2 = ImageAnalysis$$ExternalSyntheticLambda1.m16m(" Custom Attribute \"", str2, "\" not found on ");
                                            sbM16m2.append(cls.getName());
                                            Log.e("TransitionLayout", sbM16m2.toString());
                                            e.printStackTrace();
                                        }
                                        break;
                                    default:
                                        i3 = i4;
                                        break;
                                }
                            } catch (IllegalAccessException e4) {
                                e = e4;
                                i3 = i4;
                            } catch (NoSuchMethodException e5) {
                                e = e5;
                                i3 = i4;
                            } catch (InvocationTargetException e6) {
                                e = e6;
                                i3 = i4;
                            }
                            childCount = i6;
                            hashSet2 = hashSet3;
                            i4 = i3;
                        }
                        i = childCount;
                        hashSet = hashSet2;
                        i2 = i4;
                        childAt.setLayoutParams(layoutParams);
                        if (propertySet.mVisibilityMode == 0) {
                            childAt.setVisibility(propertySet.visibility);
                        }
                        childAt.setAlpha(propertySet.alpha);
                        childAt.setRotation(transform.rotation);
                        childAt.setRotationX(transform.rotationX);
                        childAt.setRotationY(transform.rotationY);
                        childAt.setScaleX(transform.scaleX);
                        childAt.setScaleY(transform.scaleY);
                        if (!Float.isNaN(transform.transformPivotX)) {
                            childAt.setPivotX(transform.transformPivotX);
                        }
                        if (!Float.isNaN(transform.transformPivotY)) {
                            childAt.setPivotY(transform.transformPivotY);
                        }
                        childAt.setTranslationX(transform.translationX);
                        childAt.setTranslationY(transform.translationY);
                        childAt.setTranslationZ(transform.translationZ);
                        if (transform.applyElevation) {
                            childAt.setElevation(transform.elevation);
                        }
                    } else {
                        i = childCount;
                        hashSet = hashSet2;
                        i2 = i4;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i4 = i2 + 1;
                constraintSet = this;
                childCount = i;
                hashSet2 = hashSet;
            }
            i = childCount;
            hashSet = hashSet2;
            i2 = i4;
            i4 = i2 + 1;
            constraintSet = this;
            childCount = i;
            hashSet2 = hashSet;
        }
        for (Integer num : hashSet2) {
            Constraint constraint2 = (Constraint) map.get(num);
            Layout layout2 = constraint2.layout;
            int i7 = layout2.mHelperType;
            if (i7 != -1 && i7 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = layout2.mReferenceIds;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = layout2.mReferenceIdString;
                    if (str3 != null) {
                        int[] iArrConvertReferenceString2 = convertReferenceString(barrier2, str3);
                        layout2.mReferenceIds = iArrConvertReferenceString2;
                        barrier2.setReferencedIds(iArrConvertReferenceString2);
                    }
                }
                barrier2.setType(layout2.mBarrierDirection);
                barrier2.setMargin(layout2.mBarrierMargin);
                ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = ConstraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                constraint2.applyTo(layoutParamsGenerateDefaultLayoutParams);
                constraintLayout.addView(barrier2, layoutParamsGenerateDefaultLayoutParams);
            }
            if (layout2.mIsGuideline) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams2 = ConstraintLayout.generateDefaultLayoutParams();
                constraint2.applyTo(layoutParamsGenerateDefaultLayoutParams2);
                constraintLayout.addView(guideline, layoutParamsGenerateDefaultLayoutParams2);
            }
        }
    }

    public final void clone(ConstraintLayout constraintLayout) {
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = constraintSet.mConstraints;
        map.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (constraintSet.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) map.get(Integer.valueOf(id));
            HashMap map2 = new HashMap();
            Class<?> cls = childAt.getClass();
            HashMap map3 = constraintSet.mSavedAttributes;
            for (String str : map3.keySet()) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) map3.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        map2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                    } else {
                        map2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }
            constraint.mCustomConstraints = map2;
            PropertySet propertySet = constraint.propertySet;
            Layout layout = constraint.layout;
            Transform transform = constraint.transform;
            constraint.mViewId = id;
            layout.leftToLeft = layoutParams.leftToLeft;
            layout.leftToRight = layoutParams.leftToRight;
            layout.rightToLeft = layoutParams.rightToLeft;
            layout.rightToRight = layoutParams.rightToRight;
            layout.topToTop = layoutParams.topToTop;
            layout.topToBottom = layoutParams.topToBottom;
            layout.bottomToTop = layoutParams.bottomToTop;
            layout.bottomToBottom = layoutParams.bottomToBottom;
            layout.baselineToBaseline = layoutParams.baselineToBaseline;
            layout.startToEnd = layoutParams.startToEnd;
            layout.startToStart = layoutParams.startToStart;
            layout.endToStart = layoutParams.endToStart;
            layout.endToEnd = layoutParams.endToEnd;
            layout.horizontalBias = layoutParams.horizontalBias;
            layout.verticalBias = layoutParams.verticalBias;
            layout.dimensionRatio = layoutParams.dimensionRatio;
            layout.circleConstraint = layoutParams.circleConstraint;
            layout.circleRadius = layoutParams.circleRadius;
            layout.circleAngle = layoutParams.circleAngle;
            layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout.orientation = layoutParams.orientation;
            layout.guidePercent = layoutParams.guidePercent;
            layout.guideBegin = layoutParams.guideBegin;
            layout.guideEnd = layoutParams.guideEnd;
            layout.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.verticalWeight = layoutParams.verticalWeight;
            layout.horizontalWeight = layoutParams.horizontalWeight;
            layout.verticalChainStyle = layoutParams.verticalChainStyle;
            layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout.constrainedWidth = layoutParams.constrainedWidth;
            layout.constrainedHeight = layoutParams.constrainedHeight;
            layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout.widthMax = layoutParams.matchConstraintMaxWidth;
            layout.heightMax = layoutParams.matchConstraintMaxHeight;
            layout.widthMin = layoutParams.matchConstraintMinWidth;
            layout.heightMin = layoutParams.matchConstraintMinHeight;
            layout.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout.mConstraintTag = layoutParams.constraintTag;
            layout.goneTopMargin = layoutParams.goneTopMargin;
            layout.goneBottomMargin = layoutParams.goneBottomMargin;
            layout.goneLeftMargin = layoutParams.goneLeftMargin;
            layout.goneRightMargin = layoutParams.goneRightMargin;
            layout.goneStartMargin = layoutParams.goneStartMargin;
            layout.goneEndMargin = layoutParams.goneEndMargin;
            layout.endMargin = layoutParams.getMarginEnd();
            layout.startMargin = layoutParams.getMarginStart();
            propertySet.visibility = childAt.getVisibility();
            propertySet.alpha = childAt.getAlpha();
            transform.rotation = childAt.getRotation();
            transform.rotationX = childAt.getRotationX();
            transform.rotationY = childAt.getRotationY();
            transform.scaleX = childAt.getScaleX();
            transform.scaleY = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                transform.transformPivotX = pivotX;
                transform.transformPivotY = pivotY;
            }
            transform.translationX = childAt.getTranslationX();
            transform.translationY = childAt.getTranslationY();
            transform.translationZ = childAt.getTranslationZ();
            if (transform.applyElevation) {
                transform.elevation = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                layout.mBarrierAllowsGoneWidgets = barrier.mBarrier.mAllowsGoneWidget;
                layout.mReferenceIds = barrier.getReferencedIds();
                layout.mBarrierDirection = barrier.getType();
                layout.mBarrierMargin = barrier.getMargin();
            }
            i++;
            constraintSet = this;
        }
    }

    public final void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint constraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        constraintFillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(constraintFillFromAttributeList.mViewId), constraintFillFromAttributeList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }
}
