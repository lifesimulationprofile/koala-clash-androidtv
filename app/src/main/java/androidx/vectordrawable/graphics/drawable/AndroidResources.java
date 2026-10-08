package androidx.vectordrawable.graphics.drawable;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import androidx.core.content.res.CamUtils;
import androidx.core.graphics.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidResources {
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_GROUP = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_PATH = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH = {R.attr.name, R.attr.pathData, R.attr.fillType};
    public static final int[] STYLEABLE_ANIMATED_VECTOR_DRAWABLE = {R.attr.drawable};
    public static final int[] STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET = {R.attr.name, R.attr.animation};
    public static final int[] STYLEABLE_ANIMATOR = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};
    public static final int[] STYLEABLE_ANIMATOR_SET = {R.attr.ordering};
    public static final int[] STYLEABLE_PROPERTY_VALUES_HOLDER = {R.attr.valueFrom, R.attr.valueTo, R.attr.valueType, R.attr.propertyName};
    public static final int[] STYLEABLE_KEYFRAME = {R.attr.value, R.attr.interpolator, R.attr.valueType, R.attr.fraction};
    public static final int[] STYLEABLE_PROPERTY_ANIMATOR = {R.attr.propertyName, R.attr.pathData, R.attr.propertyXName, R.attr.propertyYName};

    /* JADX WARN: Code duplicated, block: B:198:0x037b  */
    public static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) throws XmlPullParserException, IOException {
        int i2;
        PropertyValuesHolder[] propertyValuesHolderArr;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        PropertyValuesHolder pvh;
        int size;
        int i7;
        Keyframe keyframeOfFloat;
        Animator animator;
        Animator animatorLoadAnimator;
        int depth = xmlPullParser.getDepth();
        Animator animator2 = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i8 = 3;
            int i9 = 0;
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                break;
            }
            int i10 = 1;
            if (next == 1) {
                break;
            }
            int i11 = 2;
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    loadAnimator(context, resources, theme, attributeSet, objectAnimator, xmlPullParser);
                    animatorLoadAnimator = objectAnimator;
                } else {
                    if (name.equals("animator")) {
                        animatorLoadAnimator = loadAnimator(context, resources, theme, attributeSet, null, xmlPullParser);
                    } else {
                        Resources resources2 = resources;
                        Resources.Theme theme2 = theme;
                        if (name.equals("set")) {
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources2, theme2, attributeSet, STYLEABLE_ANIMATOR_SET);
                            createAnimatorFromXml(context, resources2, theme2, r12, attributeSet, animatorSet2, xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "ordering") != null ? typedArrayObtainAttributes.getInt(0, 0) : 0);
                            animator = animatorSet2;
                            typedArrayObtainAttributes.recycle();
                            i2 = depth;
                            animator2 = animator;
                        } else {
                            String str2 = "propertyValuesHolder";
                            if (!name.equals("propertyValuesHolder")) {
                                throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                            }
                            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
                            ArrayList arrayList2 = null;
                            while (true) {
                                int eventType = xmlPullParser.getEventType();
                                if (eventType == i8 || eventType == i10) {
                                    break;
                                }
                                if (eventType != i11) {
                                    xmlPullParser.next();
                                } else {
                                    if (xmlPullParser.getName().equals(str2)) {
                                        TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources2, theme2, attributeSetAsAttributeSet, STYLEABLE_PROPERTY_VALUES_HOLDER);
                                        String namedString = CamUtils.getNamedString(typedArrayObtainAttributes2, xmlPullParser, "propertyName", i8);
                                        int i12 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null ? typedArrayObtainAttributes2.getInt(i11, 4) : 4;
                                        int i13 = i12;
                                        ArrayList arrayList3 = null;
                                        while (true) {
                                            int next2 = xmlPullParser.next();
                                            i4 = depth;
                                            if (next2 == 3 || next2 == 1) {
                                                break;
                                            }
                                            if (xmlPullParser.getName().equals("keyframe")) {
                                                int[] iArr = STYLEABLE_KEYFRAME;
                                                if (i13 == 4) {
                                                    TypedArray typedArrayObtainAttributes3 = CamUtils.obtainAttributes(resources2, theme2, Xml.asAttributeSet(xmlPullParser), iArr);
                                                    TypedValue typedValuePeekValue = !CamUtils.hasAttribute(xmlPullParser, "value") ? null : typedArrayObtainAttributes3.peekValue(0);
                                                    int i14 = (typedValuePeekValue == null || !isColorType(typedValuePeekValue.type)) ? 0 : 3;
                                                    typedArrayObtainAttributes3.recycle();
                                                    i13 = i14;
                                                }
                                                TypedArray typedArrayObtainAttributes4 = CamUtils.obtainAttributes(resources2, theme2, Xml.asAttributeSet(xmlPullParser), iArr);
                                                float f = CamUtils.hasAttribute(xmlPullParser, "fraction") ? typedArrayObtainAttributes4.getFloat(3, -1.0f) : -1.0f;
                                                TypedValue typedValuePeekValue2 = !CamUtils.hasAttribute(xmlPullParser, "value") ? null : typedArrayObtainAttributes4.peekValue(0);
                                                boolean z = typedValuePeekValue2 != null;
                                                int i15 = i13 == 4 ? (z && isColorType(typedValuePeekValue2.type)) ? 3 : 0 : i13;
                                                if (!z) {
                                                    keyframeOfFloat = i15 == 0 ? Keyframe.ofFloat(f) : Keyframe.ofInt(f);
                                                } else if (i15 == 0) {
                                                    keyframeOfFloat = Keyframe.ofFloat(f, xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "value") != null ? typedArrayObtainAttributes4.getFloat(0, 0.0f) : 0.0f);
                                                } else if (i15 == 1 || i15 == 3) {
                                                    keyframeOfFloat = Keyframe.ofInt(f, xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "value") != null ? typedArrayObtainAttributes4.getInt(0, 0) : 0);
                                                } else {
                                                    keyframeOfFloat = null;
                                                }
                                                int resourceId = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? typedArrayObtainAttributes4.getResourceId(1, 0) : 0;
                                                if (resourceId > 0) {
                                                    keyframeOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                                }
                                                typedArrayObtainAttributes4.recycle();
                                                if (keyframeOfFloat != null) {
                                                    if (arrayList3 == null) {
                                                        arrayList3 = new ArrayList();
                                                    }
                                                    arrayList3.add(keyframeOfFloat);
                                                }
                                                xmlPullParser.next();
                                            }
                                            resources2 = resources;
                                            theme2 = theme;
                                            depth = i4;
                                            str2 = str2;
                                        }
                                        str = str2;
                                        if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                            i6 = 3;
                                            pvh = null;
                                        } else {
                                            Keyframe keyframe = (Keyframe) arrayList3.get(0);
                                            Keyframe keyframe2 = (Keyframe) arrayList3.get(size - 1);
                                            float fraction = keyframe2.getFraction();
                                            int i16 = size;
                                            Class cls = Integer.TYPE;
                                            Class cls2 = Float.TYPE;
                                            if (fraction < 1.0f) {
                                                if (fraction < 0.0f) {
                                                    keyframe2.setFraction(1.0f);
                                                } else {
                                                    arrayList3.add(arrayList3.size(), keyframe2.getType() == cls2 ? Keyframe.ofFloat(1.0f) : keyframe2.getType() == cls ? Keyframe.ofInt(1.0f) : Keyframe.ofObject(1.0f));
                                                    i16++;
                                                }
                                            }
                                            float fraction2 = keyframe.getFraction();
                                            if (fraction2 != 0.0f) {
                                                if (fraction2 < 0.0f) {
                                                    keyframe.setFraction(0.0f);
                                                } else {
                                                    arrayList3.add(0, keyframe.getType() == cls2 ? Keyframe.ofFloat(0.0f) : keyframe.getType() == cls ? Keyframe.ofInt(0.0f) : Keyframe.ofObject(0.0f));
                                                    i16++;
                                                }
                                            }
                                            int i17 = i16;
                                            Keyframe[] keyframeArr = new Keyframe[i17];
                                            arrayList3.toArray(keyframeArr);
                                            int i18 = 0;
                                            while (i18 < i17) {
                                                Keyframe keyframe3 = keyframeArr[i18];
                                                if (keyframe3.getFraction() >= 0.0f) {
                                                    i7 = i17;
                                                } else if (i18 == 0) {
                                                    keyframe3.setFraction(0.0f);
                                                    i7 = i17;
                                                } else {
                                                    int i19 = i17 - 1;
                                                    if (i18 == i19) {
                                                        keyframe3.setFraction(1.0f);
                                                        i7 = i17;
                                                    } else {
                                                        int i20 = i18;
                                                        for (int i21 = i18 + 1; i21 < i19 && keyframeArr[i21].getFraction() < 0.0f; i21++) {
                                                            i20 = i21;
                                                        }
                                                        float fraction3 = (keyframeArr[i20 + 1].getFraction() - keyframeArr[i18 - 1].getFraction()) / ((i20 - i18) + 2);
                                                        int i22 = i18;
                                                        while (i22 <= i20) {
                                                            float f2 = fraction3;
                                                            keyframeArr[i22].setFraction(keyframeArr[i22 - 1].getFraction() + f2);
                                                            i22++;
                                                            i17 = i17;
                                                            fraction3 = f2;
                                                        }
                                                        i7 = i17;
                                                    }
                                                }
                                                i18++;
                                                i17 = i7;
                                            }
                                            pvh = PropertyValuesHolder.ofKeyframe(namedString, keyframeArr);
                                            i6 = 3;
                                            if (i13 == 3) {
                                                pvh.setEvaluator(ArgbEvaluator.sInstance);
                                            }
                                        }
                                        i5 = 0;
                                        i3 = 1;
                                        if (pvh == null) {
                                            pvh = getPVH(typedArrayObtainAttributes2, i12, 0, 1, namedString);
                                        }
                                        if (pvh != null) {
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(pvh);
                                        }
                                        typedArrayObtainAttributes2.recycle();
                                    } else {
                                        i3 = i10;
                                        i4 = depth;
                                        i5 = i9;
                                        str = str2;
                                        i6 = i8;
                                    }
                                    xmlPullParser.next();
                                    resources2 = resources;
                                    i9 = i5;
                                    i10 = i3;
                                    i8 = i6;
                                    i11 = i11;
                                    attributeSetAsAttributeSet = attributeSetAsAttributeSet;
                                    depth = i4;
                                    str2 = str;
                                    theme2 = theme;
                                }
                            }
                            int i23 = i10;
                            i2 = depth;
                            int i24 = i9;
                            if (arrayList2 != null) {
                                int size2 = arrayList2.size();
                                propertyValuesHolderArr = new PropertyValuesHolder[size2];
                                for (int i25 = i24; i25 < size2; i25++) {
                                    propertyValuesHolderArr[i25] = (PropertyValuesHolder) arrayList2.get(i25);
                                }
                            } else {
                                propertyValuesHolderArr = null;
                            }
                            if (propertyValuesHolderArr != null && (animator2 instanceof ValueAnimator)) {
                                ((ValueAnimator) animator2).setValues(propertyValuesHolderArr);
                            }
                            i9 = i23;
                            animator2 = animator2;
                        }
                    }
                    if (animatorSet != null && i9 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animator2);
                    }
                    depth = i2;
                }
                animator = animatorLoadAnimator;
                i2 = depth;
                animator2 = animator;
                if (animatorSet != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(animator2);
                }
                depth = i2;
            }
        }
        int i26 = 0;
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            int size3 = arrayList.size();
            int i27 = 0;
            while (i26 < size3) {
                Object obj = arrayList.get(i26);
                i26++;
                animatorArr[i27] = (Animator) obj;
                i27++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
                return animator2;
            }
            animatorSet.playSequentially(animatorArr);
        }
        return animator2;
    }

    public static PropertyValuesHolder getPVH(TypedArray typedArray, int i, int i2, int i3, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && isColorType(i4)) || (z2 && isColorType(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser.PathDataNode[] pathDataNodeArrCreateNodesFromPathData = PathParser.createNodesFromPathData(string);
            PathParser.PathDataNode[] pathDataNodeArrCreateNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (pathDataNodeArrCreateNodesFromPathData != null || pathDataNodeArrCreateNodesFromPathData2 != null) {
                if (pathDataNodeArrCreateNodesFromPathData != null) {
                    AnimatorInflaterCompat$PathDataEvaluator animatorInflaterCompat$PathDataEvaluator = new AnimatorInflaterCompat$PathDataEvaluator();
                    if (pathDataNodeArrCreateNodesFromPathData2 == null) {
                        return PropertyValuesHolder.ofObject(str, animatorInflaterCompat$PathDataEvaluator, pathDataNodeArrCreateNodesFromPathData);
                    }
                    if (PathParser.canMorph(pathDataNodeArrCreateNodesFromPathData, pathDataNodeArrCreateNodesFromPathData2)) {
                        return PropertyValuesHolder.ofObject(str, animatorInflaterCompat$PathDataEvaluator, pathDataNodeArrCreateNodesFromPathData, pathDataNodeArrCreateNodesFromPathData2);
                    }
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                if (pathDataNodeArrCreateNodesFromPathData2 != null) {
                    return PropertyValuesHolder.ofObject(str, new AnimatorInflaterCompat$PathDataEvaluator(), pathDataNodeArrCreateNodesFromPathData2);
                }
            }
            return null;
        }
        ArgbEvaluator argbEvaluator = i == 3 ? ArgbEvaluator.sInstance : null;
        if (z3) {
            if (z) {
                float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (z2) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, 0.0f);
            } else {
                color2 = isColorType(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, 0.0f);
                } else {
                    color3 = isColorType(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, 0.0f);
            } else {
                color = isColorType(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt != null && argbEvaluator != null) {
            propertyValuesHolderOfInt.setEvaluator(argbEvaluator);
        }
        return propertyValuesHolderOfInt;
    }

    public static boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }

    public static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlPullParser xmlPullParser) {
        int i;
        ValueAnimator valueAnimator;
        TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSet, STYLEABLE_ANIMATOR);
        TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources, theme, attributeSet, STYLEABLE_PROPERTY_ANIMATOR);
        ValueAnimator valueAnimator2 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        long j = CamUtils.hasAttribute(xmlPullParser, "duration") ? typedArrayObtainAttributes.getInt(1, 300) : 300;
        long j2 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "startOffset") != null ? typedArrayObtainAttributes.getInt(2, 0) : 0;
        int i2 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null ? typedArrayObtainAttributes.getInt(7, 4) : 4;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueFrom") != null && xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueTo") != null) {
            if (i2 == 4) {
                TypedValue typedValuePeekValue = typedArrayObtainAttributes.peekValue(5);
                boolean z = typedValuePeekValue != null;
                int i3 = z ? typedValuePeekValue.type : 0;
                TypedValue typedValuePeekValue2 = typedArrayObtainAttributes.peekValue(6);
                boolean z2 = typedValuePeekValue2 != null;
                i2 = ((z && isColorType(i3)) || (z2 && isColorType(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder pvh = getPVH(typedArrayObtainAttributes, i2, 5, 6, "");
            if (pvh != null) {
                valueAnimator2.setValues(pvh);
            }
        }
        valueAnimator2.setDuration(j);
        valueAnimator2.setStartDelay(j2);
        valueAnimator2.setRepeatCount(xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatCount") != null ? typedArrayObtainAttributes.getInt(3, 0) : 0);
        valueAnimator2.setRepeatMode(xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatMode") != null ? typedArrayObtainAttributes.getInt(4, 1) : 1);
        if (typedArrayObtainAttributes2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator2;
            String namedString = CamUtils.getNamedString(typedArrayObtainAttributes2, xmlPullParser, "pathData", 1);
            if (namedString != null) {
                String namedString2 = CamUtils.getNamedString(typedArrayObtainAttributes2, xmlPullParser, "propertyXName", 2);
                String namedString3 = CamUtils.getNamedString(typedArrayObtainAttributes2, xmlPullParser, "propertyYName", 3);
                if (i2 != 2) {
                }
                if (namedString2 == null && namedString3 == null) {
                    throw new InflateException(typedArrayObtainAttributes2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path path = new Path();
                try {
                    PathParser.PathDataNode.nodesToPath(PathParser.createNodesFromPathData(namedString), path);
                    PathMeasure pathMeasure = new PathMeasure(path, false);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Float.valueOf(0.0f));
                    float length = 0.0f;
                    do {
                        length += pathMeasure.getLength();
                        arrayList.add(Float.valueOf(length));
                    } while (pathMeasure.nextContour());
                    PathMeasure pathMeasure2 = new PathMeasure(path, false);
                    int iMin = Math.min(100, ((int) (length / 0.5f)) + 1);
                    float[] fArr = new float[iMin];
                    float[] fArr2 = new float[iMin];
                    float[] fArr3 = new float[2];
                    float f = length / (iMin - 1);
                    int i4 = 0;
                    float f2 = 0.0f;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= iMin) {
                            break;
                        }
                        int i6 = iMin;
                        pathMeasure2.getPosTan(f2 - ((Float) arrayList.get(i4)).floatValue(), fArr3, null);
                        fArr[i5] = fArr3[0];
                        fArr2[i5] = fArr3[1];
                        int i7 = i4 + 1;
                        f2 += f;
                        if (i7 < arrayList.size() && f2 > ((Float) arrayList.get(i7)).floatValue()) {
                            pathMeasure2.nextContour();
                            i4 = i7;
                        }
                        i5++;
                        iMin = i6;
                    }
                    PropertyValuesHolder propertyValuesHolderOfFloat = namedString2 != null ? PropertyValuesHolder.ofFloat(namedString2, fArr) : null;
                    PropertyValuesHolder propertyValuesHolderOfFloat2 = namedString3 != null ? PropertyValuesHolder.ofFloat(namedString3, fArr2) : null;
                    if (propertyValuesHolderOfFloat == null) {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat2);
                    } else if (propertyValuesHolderOfFloat2 == null) {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat);
                    } else {
                        objectAnimator2.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                    }
                    i = 0;
                } catch (RuntimeException e) {
                    throw new RuntimeException("Error in parsing ".concat(namedString), e);
                }
            } else {
                i = 0;
                objectAnimator2.setPropertyName(CamUtils.getNamedString(typedArrayObtainAttributes2, xmlPullParser, "propertyName", 0));
            }
        } else {
            i = 0;
        }
        int resourceId = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? typedArrayObtainAttributes.getResourceId(i, i) : i;
        if (resourceId > 0) {
            valueAnimator = valueAnimator2;
            valueAnimator.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        } else {
            valueAnimator = valueAnimator2;
        }
        typedArrayObtainAttributes.recycle();
        if (typedArrayObtainAttributes2 != null) {
            typedArrayObtainAttributes2.recycle();
        }
        return valueAnimator;
    }
}
