package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.StateSet;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.ArraySetKt;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.core.content.res.CamUtils;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.accompanist.drawablepainter.DrawablePainter$callback$2$1;
import com.google.android.gms.tasks.zzg;
import java.io.IOException;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedStateListDrawableCompat extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int $r8$clinit = 0;
    public zzg mAnimationRunnable;
    public DrawablePainter$callback$2$1 mBlockInvalidateCallback;
    public Drawable mCurrDrawable;
    public AnimatedStateListState mDrawableContainerState;
    public long mEnterAnimationEnd;
    public long mExitAnimationEnd;
    public boolean mHasAlpha;
    public Rect mHotspotBounds;
    public Drawable mLastDrawable;
    public boolean mMutated;
    public boolean mMutated$1;
    public boolean mMutated$2;
    public AnimatedStateListState mState;
    public AnimatedStateListState mStateListState;
    public ArraysKt__ArraysJVMKt mTransition;
    public int mAlpha = 255;
    public int mCurIndex = -1;
    public int mTransitionToIndex = -1;
    public int mTransitionFromIndex = -1;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnimatableTransition extends ArraysKt__ArraysJVMKt {
        public final /* synthetic */ int $r8$classId;
        public final Animatable mA;

        public /* synthetic */ AnimatableTransition(Animatable animatable, int i) {
            this.$r8$classId = i;
            this.mA = animatable;
        }

        @Override // kotlin.collections.ArraysKt__ArraysJVMKt
        public final void start() {
            switch (this.$r8$classId) {
                case 0:
                    this.mA.start();
                    break;
                default:
                    ((AnimatedVectorDrawableCompat) this.mA).start();
                    break;
            }
        }

        @Override // kotlin.collections.ArraysKt__ArraysJVMKt
        public final void stop() {
            switch (this.$r8$classId) {
                case 0:
                    this.mA.stop();
                    break;
                default:
                    ((AnimatedVectorDrawableCompat) this.mA).stop();
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnimatedStateListState extends Drawable.ConstantState {
        public boolean mAutoMirrored;
        public boolean mCanConstantState;
        public int mChangingConfigurations;
        public boolean mCheckedConstantSize;
        public boolean mCheckedConstantState;
        public boolean mCheckedOpacity;
        public boolean mCheckedPadding;
        public boolean mCheckedStateful;
        public int mChildrenChangingConfigurations;
        public ColorFilter mColorFilter;
        public int mConstantHeight;
        public int mConstantMinimumHeight;
        public int mConstantMinimumWidth;
        public Rect mConstantPadding;
        public boolean mConstantSize;
        public int mConstantWidth;
        public int mDensity;
        public boolean mDither;
        public SparseArray mDrawableFutures;
        public Drawable[] mDrawables;
        public int mEnterFadeDuration;
        public int mExitFadeDuration;
        public boolean mHasColorFilter;
        public boolean mHasTintList;
        public boolean mHasTintMode;
        public int mLayoutDirection;
        public int mNumChildren;
        public int mOpacity;
        public final AnimatedStateListDrawableCompat mOwner;
        public Resources mSourceRes;
        public SparseArrayCompat mStateIds;
        public int[][] mStateSets;
        public ColorStateList mTintList;
        public PorterDuff.Mode mTintMode;
        public LongSparseArray mTransitions;
        public boolean mVariablePadding;

        public AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = animatedStateListDrawableCompat;
            this.mSourceRes = resources != null ? resources : animatedStateListState != null ? animatedStateListState.mSourceRes : null;
            int i = animatedStateListState != null ? animatedStateListState.mDensity : 0;
            int i2 = AnimatedStateListDrawableCompat.$r8$clinit;
            i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
            i = i == 0 ? 160 : i;
            this.mDensity = i;
            if (animatedStateListState != null) {
                this.mChangingConfigurations = animatedStateListState.mChangingConfigurations;
                this.mChildrenChangingConfigurations = animatedStateListState.mChildrenChangingConfigurations;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
                this.mVariablePadding = animatedStateListState.mVariablePadding;
                this.mConstantSize = animatedStateListState.mConstantSize;
                this.mDither = animatedStateListState.mDither;
                this.mLayoutDirection = animatedStateListState.mLayoutDirection;
                this.mEnterFadeDuration = animatedStateListState.mEnterFadeDuration;
                this.mExitFadeDuration = animatedStateListState.mExitFadeDuration;
                this.mAutoMirrored = animatedStateListState.mAutoMirrored;
                this.mColorFilter = animatedStateListState.mColorFilter;
                this.mHasColorFilter = animatedStateListState.mHasColorFilter;
                this.mTintList = animatedStateListState.mTintList;
                this.mTintMode = animatedStateListState.mTintMode;
                this.mHasTintList = animatedStateListState.mHasTintList;
                this.mHasTintMode = animatedStateListState.mHasTintMode;
                if (animatedStateListState.mDensity == i) {
                    if (animatedStateListState.mCheckedPadding) {
                        this.mConstantPadding = animatedStateListState.mConstantPadding != null ? new Rect(animatedStateListState.mConstantPadding) : null;
                        this.mCheckedPadding = true;
                    }
                    if (animatedStateListState.mCheckedConstantSize) {
                        this.mConstantWidth = animatedStateListState.mConstantWidth;
                        this.mConstantHeight = animatedStateListState.mConstantHeight;
                        this.mConstantMinimumWidth = animatedStateListState.mConstantMinimumWidth;
                        this.mConstantMinimumHeight = animatedStateListState.mConstantMinimumHeight;
                        this.mCheckedConstantSize = true;
                    }
                }
                if (animatedStateListState.mCheckedOpacity) {
                    this.mOpacity = animatedStateListState.mOpacity;
                    this.mCheckedOpacity = true;
                }
                if (animatedStateListState.mCheckedStateful) {
                    this.mCheckedStateful = true;
                }
                Drawable[] drawableArr = animatedStateListState.mDrawables;
                this.mDrawables = new Drawable[drawableArr.length];
                this.mNumChildren = animatedStateListState.mNumChildren;
                SparseArray sparseArray = animatedStateListState.mDrawableFutures;
                if (sparseArray != null) {
                    this.mDrawableFutures = sparseArray.clone();
                } else {
                    this.mDrawableFutures = new SparseArray(this.mNumChildren);
                }
                int i3 = this.mNumChildren;
                for (int i4 = 0; i4 < i3; i4++) {
                    Drawable drawable = drawableArr[i4];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.mDrawableFutures.put(i4, constantState);
                        } else {
                            this.mDrawables[i4] = drawableArr[i4];
                        }
                    }
                }
            } else {
                this.mDrawables = new Drawable[10];
                this.mNumChildren = 0;
            }
            if (animatedStateListState != null) {
                this.mStateSets = animatedStateListState.mStateSets;
            } else {
                this.mStateSets = new int[this.mDrawables.length][];
            }
            if (animatedStateListState != null) {
                this.mTransitions = animatedStateListState.mTransitions;
                this.mStateIds = animatedStateListState.mStateIds;
            } else {
                this.mTransitions = new LongSparseArray((Object) null);
                this.mStateIds = new SparseArrayCompat(0);
            }
        }

        public final int addChild(Drawable drawable) {
            int i = this.mNumChildren;
            if (i >= this.mDrawables.length) {
                int i2 = i + 10;
                Drawable[] drawableArr = new Drawable[i2];
                Drawable[] drawableArr2 = this.mDrawables;
                if (drawableArr2 != null) {
                    System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
                }
                this.mDrawables = drawableArr;
                int[][] iArr = new int[i2][];
                System.arraycopy(this.mStateSets, 0, iArr, 0, i);
                this.mStateSets = iArr;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.mOwner);
            this.mDrawables[i] = drawable;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.mDrawableFutures.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public final void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.mConstantWidth) {
                    this.mConstantWidth = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.mConstantHeight) {
                    this.mConstantHeight = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.mConstantMinimumHeight) {
                    this.mConstantMinimumHeight = minimumHeight;
                }
            }
        }

        public final void createAllFutures() {
            SparseArray sparseArray = this.mDrawableFutures;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    int iKeyAt = this.mDrawableFutures.keyAt(i);
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.mDrawableFutures.valueAt(i);
                    Drawable[] drawableArr = this.mDrawables;
                    Drawable drawableNewDrawable = constantState.newDrawable(this.mSourceRes);
                    drawableNewDrawable.setLayoutDirection(this.mLayoutDirection);
                    Drawable drawableMutate = drawableNewDrawable.mutate();
                    drawableMutate.setCallback(this.mOwner);
                    drawableArr[iKeyAt] = drawableMutate;
                }
                this.mDrawableFutures = null;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final Drawable getChild(int i) {
            int iIndexOfKey;
            Drawable drawable = this.mDrawables[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.mDrawableFutures;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable drawableNewDrawable = ((Drawable.ConstantState) this.mDrawableFutures.valueAt(iIndexOfKey)).newDrawable(this.mSourceRes);
            drawableNewDrawable.setLayoutDirection(this.mLayoutDirection);
            Drawable drawableMutate = drawableNewDrawable.mutate();
            drawableMutate.setCallback(this.mOwner);
            this.mDrawables[i] = drawableMutate;
            this.mDrawableFutures.removeAt(iIndexOfKey);
            if (this.mDrawableFutures.size() == 0) {
                this.mDrawableFutures = null;
            }
            return drawableMutate;
        }

        public final int getKeyframeIdAt(int i) {
            Object obj;
            if (i < 0) {
                return 0;
            }
            SparseArrayCompat sparseArrayCompat = this.mStateIds;
            Object obj2 = 0;
            int iBinarySearch = RuntimeHelpersKt.binarySearch(sparseArrayCompat.size, i, sparseArrayCompat.keys);
            if (iBinarySearch >= 0 && (obj = sparseArrayCompat.values[iBinarySearch]) != ArraySetKt.DELETED$1) {
                obj2 = obj;
            }
            return ((Integer) obj2).intValue();
        }

        public final int indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState(int[] iArr) {
            int[][] iArr2 = this.mStateSets;
            int i = this.mNumChildren;
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnimationDrawableTransition extends ArraysKt__ArraysJVMKt {
        public final ObjectAnimator mAnim;
        public final boolean mHasReversibleFlag;

        public AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            FrameInterpolator frameInterpolator = new FrameInterpolator();
            int numberOfFrames2 = animationDrawable.getNumberOfFrames();
            frameInterpolator.mFrames = numberOfFrames2;
            int[] iArr = frameInterpolator.mFrameTimes;
            if (iArr == null || iArr.length < numberOfFrames2) {
                frameInterpolator.mFrameTimes = new int[numberOfFrames2];
            }
            int[] iArr2 = frameInterpolator.mFrameTimes;
            int i3 = 0;
            for (int i4 = 0; i4 < numberOfFrames2; i4++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames2 - i4) - 1 : i4);
                iArr2[i4] = duration;
                i3 += duration;
            }
            frameInterpolator.mTotalDuration = i3;
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            objectAnimatorOfInt.setAutoCancel(true);
            objectAnimatorOfInt.setDuration(frameInterpolator.mTotalDuration);
            objectAnimatorOfInt.setInterpolator(frameInterpolator);
            this.mHasReversibleFlag = z2;
            this.mAnim = objectAnimatorOfInt;
        }

        @Override // kotlin.collections.ArraysKt__ArraysJVMKt
        public final boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        @Override // kotlin.collections.ArraysKt__ArraysJVMKt
        public final void reverse() {
            this.mAnim.reverse();
        }

        @Override // kotlin.collections.ArraysKt__ArraysJVMKt
        public final void start() {
            this.mAnim.start();
        }

        @Override // kotlin.collections.ArraysKt__ArraysJVMKt
        public final void stop() {
            this.mAnim.cancel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FrameInterpolator implements TimeInterpolator {
        public int[] mFrameTimes;
        public int mFrames;
        public int mTotalDuration;

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            int i = (int) ((f * this.mTotalDuration) + 0.5f);
            int i2 = this.mFrames;
            int[] iArr = this.mFrameTimes;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                if (i < i4) {
                    break;
                }
                i -= i4;
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.mTotalDuration : 0.0f);
        }
    }

    public AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        setConstantState(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context context, Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int next;
        int next2;
        Context context2 = context;
        Resources resources2 = resources;
        String name = xmlResourceParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat(null, null);
        TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources2, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
        int i = 1;
        animatedStateListDrawableCompat.setVisible(typedArrayObtainAttributes.getBoolean(1, true), true);
        AnimatedStateListState animatedStateListState = animatedStateListDrawableCompat.mState;
        animatedStateListState.mChangingConfigurations |= Compatibility$Api21Impl.getChangingConfigurations(typedArrayObtainAttributes);
        int i2 = 2;
        animatedStateListState.mVariablePadding = typedArrayObtainAttributes.getBoolean(2, animatedStateListState.mVariablePadding);
        int i3 = 3;
        animatedStateListState.mConstantSize = typedArrayObtainAttributes.getBoolean(3, animatedStateListState.mConstantSize);
        animatedStateListState.mEnterFadeDuration = typedArrayObtainAttributes.getInt(4, animatedStateListState.mEnterFadeDuration);
        animatedStateListState.mExitFadeDuration = typedArrayObtainAttributes.getInt(5, animatedStateListState.mExitFadeDuration);
        boolean z = false;
        animatedStateListDrawableCompat.setDither(typedArrayObtainAttributes.getBoolean(0, animatedStateListState.mDither));
        AnimatedStateListState animatedStateListState2 = animatedStateListDrawableCompat.mDrawableContainerState;
        if (resources2 != null) {
            animatedStateListState2.mSourceRes = resources2;
            int i4 = resources2.getDisplayMetrics().densityDpi;
            if (i4 == 0) {
                i4 = 160;
            }
            int i5 = animatedStateListState2.mDensity;
            animatedStateListState2.mDensity = i4;
            if (i5 != i4) {
                animatedStateListState2.mCheckedConstantSize = false;
                animatedStateListState2.mCheckedPadding = false;
            }
        } else {
            animatedStateListState2.getClass();
        }
        typedArrayObtainAttributes.recycle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next3 = xmlResourceParser.next();
            if (next3 == i || ((depth = xmlResourceParser.getDepth()) < depth2 && next3 == i3)) {
                break;
            }
            if (next3 == i2 && depth <= depth2) {
                if (xmlResourceParser.getName().equals("item")) {
                    TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources2, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
                    int resourceId = typedArrayObtainAttributes2.getResourceId(z ? 1 : 0, z ? 1 : 0);
                    int resourceId2 = typedArrayObtainAttributes2.getResourceId(i, -1);
                    Drawable drawable = resourceId2 > 0 ? ResourceManagerInternal.get().getDrawable(context2, resourceId2) : null;
                    typedArrayObtainAttributes2.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i6 = z ? 1 : 0;
                    for (int i7 = i6 == true ? 1 : 0; i7 < attributeCount; i7++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i7);
                        if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                            int i8 = (i6 == true ? 1 : 0) + 1;
                            if (!attributeSet.getAttributeBooleanValue(i7, z)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i6 == true ? 1 : 0] = attributeNameResource;
                            i6 = i8;
                        }
                    }
                    int[] iArrTrimStateSet = StateSet.trimStateSet(iArr, i6 == true ? 1 : 0);
                    if (drawable == null) {
                        do {
                            next2 = xmlResourceParser.next();
                        } while (next2 == 4);
                        if (next2 != 2) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        if (xmlResourceParser.getName().equals("vector")) {
                            drawable = new VectorDrawableCompat();
                            drawable.inflate(resources2, xmlResourceParser, attributeSet, theme);
                        } else {
                            drawable = Compatibility$Api21Impl.createFromXmlInner(resources, xmlResourceParser, attributeSet, theme);
                        }
                    }
                    if (drawable == null) {
                        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    AnimatedStateListState animatedStateListState3 = animatedStateListDrawableCompat.mState;
                    int iAddChild = animatedStateListState3.addChild(drawable);
                    animatedStateListState3.mStateSets[iAddChild] = iArrTrimStateSet;
                    animatedStateListState3.mStateIds.put(iAddChild, Integer.valueOf(resourceId));
                } else {
                    if (xmlResourceParser.getName().equals("transition")) {
                        TypedArray typedArrayObtainAttributes3 = CamUtils.obtainAttributes(resources2, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
                        int resourceId3 = typedArrayObtainAttributes3.getResourceId(2, -1);
                        int resourceId4 = typedArrayObtainAttributes3.getResourceId(1, -1);
                        int resourceId5 = typedArrayObtainAttributes3.getResourceId(z ? 1 : 0, -1);
                        Drawable drawable2 = resourceId5 > 0 ? ResourceManagerInternal.get().getDrawable(context2, resourceId5) : null;
                        boolean z2 = typedArrayObtainAttributes3.getBoolean(3, z);
                        typedArrayObtainAttributes3.recycle();
                        if (drawable2 == null) {
                            do {
                                next = xmlResourceParser.next();
                            } while (next == 4);
                            if (next != 2) {
                                throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                            }
                            if (xmlResourceParser.getName().equals("animated-vector")) {
                                drawable2 = new AnimatedVectorDrawableCompat(context2);
                                drawable2.inflate(resources2, xmlResourceParser, attributeSet, theme);
                            } else {
                                drawable2 = Compatibility$Api21Impl.createFromXmlInner(resources, xmlResourceParser, attributeSet, theme);
                            }
                        }
                        if (drawable2 == null) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        if (resourceId3 == -1 || resourceId4 == -1) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
                        }
                        AnimatedStateListState animatedStateListState4 = animatedStateListDrawableCompat.mState;
                        int iAddChild2 = animatedStateListState4.addChild(drawable2);
                        long j = resourceId3;
                        long j2 = resourceId4;
                        long j3 = (j << 32) | j2;
                        long j4 = z2 ? 8589934592L : 0L;
                        long j5 = iAddChild2;
                        animatedStateListState4.mTransitions.append(j3, Long.valueOf(j5 | j4));
                        if (z2) {
                            animatedStateListState4.mTransitions.append((j2 << 32) | j, Long.valueOf(j5 | 4294967296L | j4));
                        }
                        context2 = context;
                        resources2 = resources;
                        i = 1;
                        z = false;
                    } else {
                        context2 = context;
                        resources2 = resources;
                    }
                    i2 = 2;
                    i3 = 3;
                }
                i = 1;
                i2 = 2;
                i3 = 3;
            }
        }
        animatedStateListDrawableCompat.onStateChange(animatedStateListDrawableCompat.getState());
        return animatedStateListDrawableCompat;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    /* JADX WARN: Code duplicated, block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final void animate(boolean z) {
        boolean z2;
        Drawable drawable;
        long j;
        boolean z3 = true;
        this.mHasAlpha = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            long j2 = this.mEnterAnimationEnd;
            if (j2 != 0) {
                if (j2 <= jUptimeMillis) {
                    drawable2.setAlpha(this.mAlpha);
                    this.mEnterAnimationEnd = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j2 - jUptimeMillis) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
                    z2 = true;
                }
            }
            drawable = this.mLastDrawable;
            if (drawable != null) {
                j = this.mExitAnimationEnd;
                if (j == 0) {
                    if (j <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.mLastDrawable = null;
                        this.mExitAnimationEnd = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j - jUptimeMillis) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
                    }
                }
                if (z || !z3) {
                }
                scheduleSelf(this.mAnimationRunnable, jUptimeMillis + 16);
                return;
            }
            this.mExitAnimationEnd = 0L;
            z3 = z2;
            if (z) {
            }
        }
        this.mEnterAnimationEnd = 0L;
        z2 = false;
        drawable = this.mLastDrawable;
        if (drawable != null) {
            j = this.mExitAnimationEnd;
            if (j == 0) {
                if (j <= jUptimeMillis) {
                    drawable.setVisible(false, false);
                    this.mLastDrawable = null;
                    this.mExitAnimationEnd = 0L;
                } else {
                    drawable.setAlpha(((((int) ((j - jUptimeMillis) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
                }
            }
            if (z) {
            }
        }
        this.mExitAnimationEnd = 0L;
        z3 = z2;
        if (z) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        applyTheme$androidx$appcompat$graphics$drawable$DrawableContainerCompat(theme);
        onStateChange(getState());
    }

    public final void applyTheme$androidx$appcompat$graphics$drawable$DrawableContainerCompat(Resources.Theme theme) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (theme == null) {
            animatedStateListState.getClass();
            return;
        }
        animatedStateListState.createAllFutures();
        int i = animatedStateListState.mNumChildren;
        Drawable[] drawableArr = animatedStateListState.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.canApplyTheme()) {
                drawableArr[i2].applyTheme(theme);
                animatedStateListState.mChildrenChangingConfigurations |= drawableArr[i2].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            animatedStateListState.mSourceRes = resources;
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 == 0) {
                i3 = 160;
            }
            int i4 = animatedStateListState.mDensity;
            animatedStateListState.mDensity = i3;
            if (i4 != i3) {
                animatedStateListState.mCheckedConstantSize = false;
                animatedStateListState.mCheckedPadding = false;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (!animatedStateListState.mCheckedConstantState) {
            animatedStateListState.createAllFutures();
            animatedStateListState.mCheckedConstantState = true;
            int i = animatedStateListState.mNumChildren;
            Drawable[] drawableArr = animatedStateListState.mDrawables;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    animatedStateListState.mCanConstantState = true;
                    z = true;
                    break;
                }
                if (drawableArr[i2].getConstantState() == null) {
                    animatedStateListState.mCanConstantState = false;
                    z = false;
                    break;
                }
                i2++;
            }
        } else {
            z = animatedStateListState.mCanConstantState;
        }
        if (!z) {
            return null;
        }
        this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mConstantSize) {
            if (!animatedStateListState.mCheckedConstantSize) {
                animatedStateListState.computeConstantSize();
            }
            return animatedStateListState.mConstantHeight;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mConstantSize) {
            if (!animatedStateListState.mCheckedConstantSize) {
                animatedStateListState.computeConstantSize();
            }
            return animatedStateListState.mConstantWidth;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mConstantSize) {
            if (!animatedStateListState.mCheckedConstantSize) {
                animatedStateListState.computeConstantSize();
            }
            return animatedStateListState.mConstantMinimumHeight;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mConstantSize) {
            if (!animatedStateListState.mCheckedConstantSize) {
                animatedStateListState.computeConstantSize();
            }
            return animatedStateListState.mConstantMinimumWidth;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.mCurrDrawable;
        int opacity = -2;
        if (drawable != null && drawable.isVisible()) {
            AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
            if (animatedStateListState.mCheckedOpacity) {
                return animatedStateListState.mOpacity;
            }
            animatedStateListState.createAllFutures();
            int i = animatedStateListState.mNumChildren;
            Drawable[] drawableArr = animatedStateListState.mDrawables;
            opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            animatedStateListState.mOpacity = opacity;
            animatedStateListState.mCheckedOpacity = true;
        }
        return opacity;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        Rect rect2 = null;
        boolean padding = false;
        if (!animatedStateListState.mVariablePadding) {
            Rect rect3 = animatedStateListState.mConstantPadding;
            if (rect3 != null || animatedStateListState.mCheckedPadding) {
                rect2 = rect3;
            } else {
                animatedStateListState.createAllFutures();
                Rect rect4 = new Rect();
                int i = animatedStateListState.mNumChildren;
                Drawable[] drawableArr = animatedStateListState.mDrawables;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect4.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect4.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect4.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect4.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                animatedStateListState.mCheckedPadding = true;
                animatedStateListState.mConstantPadding = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                padding = true;
            }
        } else {
            Drawable drawable = this.mCurrDrawable;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.mDrawableContainerState.mAutoMirrored && getLayoutDirection() == 1) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return padding;
    }

    public final void initializeDrawableForDisplay(Drawable drawable) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new DrawablePainter$callback$2$1();
        }
        DrawablePainter$callback$2$1 drawablePainter$callback$2$1 = this.mBlockInvalidateCallback;
        drawablePainter$callback$2$1.this$0 = drawable.getCallback();
        drawable.setCallback(drawablePainter$callback$2$1);
        try {
            if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
            if (animatedStateListState.mHasColorFilter) {
                drawable.setColorFilter(animatedStateListState.mColorFilter);
            } else {
                if (animatedStateListState.mHasTintList) {
                    drawable.setTintList(animatedStateListState.mTintList);
                }
                AnimatedStateListState animatedStateListState2 = this.mDrawableContainerState;
                if (animatedStateListState2.mHasTintMode) {
                    drawable.setTintMode(animatedStateListState2.mTintMode);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.mDrawableContainerState.mDither);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
            Rect rect = this.mHotspotBounds;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            DrawablePainter$callback$2$1 drawablePainter$callback$2$2 = this.mBlockInvalidateCallback;
            Drawable.Callback callback = (Drawable.Callback) drawablePainter$callback$2$2.this$0;
            drawablePainter$callback$2$2.this$0 = null;
            drawable.setCallback(callback);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState != null) {
            animatedStateListState.mCheckedOpacity = false;
            animatedStateListState.mCheckedStateful = false;
        }
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        jumpToCurrentState$androidx$appcompat$graphics$drawable$StateListDrawableCompat();
        ArraysKt__ArraysJVMKt arraysKt__ArraysJVMKt = this.mTransition;
        if (arraysKt__ArraysJVMKt != null) {
            arraysKt__ArraysJVMKt.stop();
            this.mTransition = null;
            selectDrawable(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    public final void jumpToCurrentState$androidx$appcompat$graphics$drawable$StateListDrawableCompat() {
        boolean z;
        Drawable drawable = this.mLastDrawable;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.mLastDrawable = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0L;
            z = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.mMutated) {
            mutate$androidx$appcompat$graphics$drawable$StateListDrawableCompat();
            AnimatedStateListState animatedStateListState = this.mState;
            animatedStateListState.mTransitions = animatedStateListState.mTransitions.m22clone();
            animatedStateListState.mStateIds = animatedStateListState.mStateIds.m23clone();
            this.mMutated = true;
        }
        return this;
    }

    public final Drawable mutate$androidx$appcompat$graphics$drawable$DrawableContainerCompat() {
        if (!this.mMutated$1 && super.mutate() == this) {
            AnimatedStateListState animatedStateListState = new AnimatedStateListState(this.mState, this, null);
            animatedStateListState.mTransitions = animatedStateListState.mTransitions.m22clone();
            animatedStateListState.mStateIds = animatedStateListState.mStateIds.m23clone();
            setConstantState(animatedStateListState);
            this.mMutated$1 = true;
        }
        return this;
    }

    public final Drawable mutate$androidx$appcompat$graphics$drawable$StateListDrawableCompat() {
        if (!this.mMutated$2) {
            mutate$androidx$appcompat$graphics$drawable$DrawableContainerCompat();
            AnimatedStateListState animatedStateListState = this.mStateListState;
            animatedStateListState.mTransitions = animatedStateListState.mTransitions.m22clone();
            animatedStateListState.mStateIds = animatedStateListState.mStateIds.m23clone();
            this.mMutated$2 = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        int i2 = this.mCurIndex;
        int i3 = animatedStateListState.mNumChildren;
        Drawable[] drawableArr = animatedStateListState.mDrawables;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            Drawable drawable = drawableArr[i4];
            if (drawable != null) {
                boolean layoutDirection = drawable.setLayoutDirection(i);
                if (i4 == i2) {
                    z = layoutDirection;
                }
            }
        }
        animatedStateListState.mLayoutDirection = i;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d3  */
    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int keyframeIdAt;
        ArraysKt__ArraysJVMKt animatableTransition;
        AnimatedStateListState animatedStateListState = this.mState;
        int iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState = animatedStateListState.indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState(iArr);
        if (iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState < 0) {
            iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState = animatedStateListState.indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState(StateSet.WILD_CARD);
        }
        int i = this.mCurIndex;
        boolean z = false;
        if (iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState != i) {
            ArraysKt__ArraysJVMKt arraysKt__ArraysJVMKt = this.mTransition;
            if (arraysKt__ArraysJVMKt == null) {
                this.mTransition = null;
                this.mTransitionFromIndex = -1;
                this.mTransitionToIndex = -1;
                AnimatedStateListState animatedStateListState2 = this.mState;
                int keyframeIdAt2 = animatedStateListState2.getKeyframeIdAt(i);
                keyframeIdAt = animatedStateListState2.getKeyframeIdAt(iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState);
                if (keyframeIdAt == 0 && keyframeIdAt2 != 0) {
                    long j = ((long) keyframeIdAt) | (((long) keyframeIdAt2) << 32);
                    int iLongValue = (int) ((Long) animatedStateListState2.mTransitions.get$1(j)).longValue();
                    if (iLongValue >= 0) {
                        boolean z2 = (((Long) animatedStateListState2.mTransitions.get$1(j)).longValue() & 8589934592L) != 0;
                        selectDrawable(iLongValue);
                        Object obj = this.mCurrDrawable;
                        if (obj instanceof AnimationDrawable) {
                            animatableTransition = new AnimationDrawableTransition((AnimationDrawable) obj, (((Long) animatedStateListState2.mTransitions.get$1(j)).longValue() & 4294967296L) != 0, z2);
                        } else if (obj instanceof AnimatedVectorDrawableCompat) {
                            animatableTransition = new AnimatableTransition((AnimatedVectorDrawableCompat) obj, 1);
                        } else if (obj instanceof Animatable) {
                            animatableTransition = new AnimatableTransition((Animatable) obj, 0);
                        } else if (selectDrawable(iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState)) {
                            z = true;
                        }
                        animatableTransition.start();
                        this.mTransition = animatableTransition;
                        this.mTransitionFromIndex = i;
                        this.mTransitionToIndex = iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState;
                        z = true;
                    } else if (selectDrawable(iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState)) {
                        z = true;
                    }
                } else if (selectDrawable(iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState)) {
                    z = true;
                }
            } else {
                if (iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState != this.mTransitionToIndex) {
                    if (iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState == this.mTransitionFromIndex && arraysKt__ArraysJVMKt.canReverse()) {
                        arraysKt__ArraysJVMKt.reverse();
                        this.mTransitionToIndex = this.mTransitionFromIndex;
                        this.mTransitionFromIndex = iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState;
                    } else {
                        i = this.mTransitionToIndex;
                        arraysKt__ArraysJVMKt.stop();
                        this.mTransition = null;
                        this.mTransitionFromIndex = -1;
                        this.mTransitionToIndex = -1;
                        AnimatedStateListState animatedStateListState3 = this.mState;
                        int keyframeIdAt3 = animatedStateListState3.getKeyframeIdAt(i);
                        keyframeIdAt = animatedStateListState3.getKeyframeIdAt(iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState);
                        if (keyframeIdAt == 0) {
                            if (selectDrawable(iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState)) {
                            }
                        } else if (selectDrawable(iIndexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState)) {
                        }
                    }
                }
                z = true;
            }
        }
        Drawable drawable = this.mCurrDrawable;
        return drawable != null ? drawable.setState(iArr) | z : z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    public final boolean selectDrawable(int i) {
        if (i == this.mCurIndex) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration > 0) {
            Drawable drawable = this.mLastDrawable;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                this.mLastDrawable = drawable2;
                this.mExitAnimationEnd = ((long) this.mDrawableContainerState.mExitFadeDuration) + jUptimeMillis;
            } else {
                this.mLastDrawable = null;
                this.mExitAnimationEnd = 0L;
            }
        } else {
            Drawable drawable3 = this.mCurrDrawable;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0) {
            AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
            if (i < animatedStateListState.mNumChildren) {
                Drawable child = animatedStateListState.getChild(i);
                this.mCurrDrawable = child;
                this.mCurIndex = i;
                if (child != null) {
                    int i2 = this.mDrawableContainerState.mEnterFadeDuration;
                    if (i2 > 0) {
                        this.mEnterAnimationEnd = jUptimeMillis + ((long) i2);
                    }
                    initializeDrawableForDisplay(child);
                }
            } else {
                this.mCurrDrawable = null;
                this.mCurIndex = -1;
            }
        } else {
            this.mCurrDrawable = null;
            this.mCurIndex = -1;
        }
        if (this.mEnterAnimationEnd != 0 || this.mExitAnimationEnd != 0) {
            zzg zzgVar = this.mAnimationRunnable;
            if (zzgVar == null) {
                this.mAnimationRunnable = new zzg(1, this);
            } else {
                unscheduleSelf(zzgVar);
            }
            animate(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.mHasAlpha && this.mAlpha == i) {
            return;
        }
        this.mHasAlpha = true;
        this.mAlpha = i;
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            if (this.mEnterAnimationEnd == 0) {
                drawable.setAlpha(i);
            } else {
                animate(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mAutoMirrored != z) {
            animatedStateListState.mAutoMirrored = z;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        animatedStateListState.mHasColorFilter = true;
        if (animatedStateListState.mColorFilter != colorFilter) {
            animatedStateListState.mColorFilter = colorFilter;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public final void setConstantState(AnimatedStateListState animatedStateListState) {
        this.mDrawableContainerState = animatedStateListState;
        int i = this.mCurIndex;
        if (i >= 0) {
            Drawable child = animatedStateListState.getChild(i);
            this.mCurrDrawable = child;
            if (child != null) {
                initializeDrawableForDisplay(child);
            }
        }
        this.mLastDrawable = null;
        this.mStateListState = animatedStateListState;
        this.mState = animatedStateListState;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mDither != z) {
            animatedStateListState.mDither = z;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        animatedStateListState.mHasTintList = true;
        if (animatedStateListState.mTintList != colorStateList) {
            animatedStateListState.mTintList = colorStateList;
            this.mCurrDrawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        animatedStateListState.mHasTintMode = true;
        if (animatedStateListState.mTintMode != mode) {
            animatedStateListState.mTintMode = mode;
            this.mCurrDrawable.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible$androidx$appcompat$graphics$drawable$StateListDrawableCompat = setVisible$androidx$appcompat$graphics$drawable$StateListDrawableCompat(z, z2);
        ArraysKt__ArraysJVMKt arraysKt__ArraysJVMKt = this.mTransition;
        if (arraysKt__ArraysJVMKt != null && (visible$androidx$appcompat$graphics$drawable$StateListDrawableCompat || z2)) {
            if (z) {
                arraysKt__ArraysJVMKt.start();
                return visible$androidx$appcompat$graphics$drawable$StateListDrawableCompat;
            }
            jumpToCurrentState();
        }
        return visible$androidx$appcompat$graphics$drawable$StateListDrawableCompat;
    }

    public final boolean setVisible$androidx$appcompat$graphics$drawable$StateListDrawableCompat(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.mCurrDrawable || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
