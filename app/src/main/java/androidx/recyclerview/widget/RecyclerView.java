package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.CircularArray;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.TraceCompat;
import androidx.core.util.Pools$SimplePool;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MenuItemCompat$Api26Impl;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.emoji2.text.EmojiCompat;
import androidx.navigation.NavOptions;
import androidx.recyclerview.R$styleable;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import coil.network.EmptyNetworkObserver;
import coil.request.Parameters;
import coil.request.RequestService;
import com.google.android.gms.tasks.zzg;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import okhttp3.Request;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup {
    public static final Class[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    public static final ViewDragHelper.AnonymousClass1 sQuinticInterpolator;
    public RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    public final AccessibilityManager mAccessibilityManager;
    public Adapter mAdapter;
    public final Request mAdapterHelper;
    public EdgeEffect mBottomGlow;
    public final ImageLoader$Builder mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    public int mDispatchScrollCounter;
    public int mEatenAccessibilityChangeFlags;
    public EdgeEffectFactory mEdgeEffectFactory;
    public boolean mFirstLayoutComplete;
    public GapWorker mGapWorker;
    public boolean mHasFixedSize;
    public boolean mIgnoreMotionEventTillDown;
    public int mInitialTouchX;
    public int mInitialTouchY;
    public int mInterceptRequestLayoutDepth;
    public FastScroller mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public ItemAnimator mItemAnimator;
    public final AnonymousClass5 mItemAnimatorListener;
    public final zzg mItemAnimatorRunner;
    public final ArrayList mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    public int mLastAutoMeasureNonExactMeasuredHeight;
    public int mLastAutoMeasureNonExactMeasuredWidth;
    public boolean mLastAutoMeasureSkippedDueToExact;
    public int mLastTouchX;
    public int mLastTouchY;
    public LayoutManager mLayout;
    public int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    public EdgeEffect mLeftGlow;
    public final int mMaxFlingVelocity;
    public final int mMinFlingVelocity;
    public final int[] mMinMaxLayoutPositions;
    public final int[] mNestedOffsets;
    public final EmptyNetworkObserver mObserver;
    public OnFlingListener mOnFlingListener;
    public final ArrayList mOnItemTouchListeners;
    public final ArrayList mPendingAccessibilityImportanceChange;
    public SavedState mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public final CircularArray mPrefetchRegistry;
    public boolean mPreserveFocusAfterLayout;
    public final Recycler mRecycler;
    public final ArrayList mRecyclerListeners;
    public final int[] mReusableIntPair;
    public EdgeEffect mRightGlow;
    public final float mScaledHorizontalScrollFactor;
    public final float mScaledVerticalScrollFactor;
    public OnScrollListener mScrollListener;
    public ArrayList mScrollListeners;
    public final int[] mScrollOffset;
    public int mScrollPointerId;
    public int mScrollState;
    public NestedScrollingChildHelper mScrollingChildHelper;
    public final State mState;
    public final Rect mTempRect;
    public final Rect mTempRect2;
    public final RectF mTempRectF;
    public EdgeEffect mTopGlow;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public final ViewFlinger mViewFlinger;
    public final AnonymousClass4 mViewInfoProcessCallback;
    public final RequestService mViewInfoStore;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass4 {
        public /* synthetic */ AnonymousClass4() {
        }

        public void dispatchUpdate(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
            int i = adapterHelper$UpdateOp.cmd;
            RecyclerView recyclerView = RecyclerView.this;
            if (i == 1) {
                recyclerView.mLayout.onItemsAdded(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
                return;
            }
            if (i == 2) {
                recyclerView.mLayout.onItemsRemoved(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            } else if (i == 4) {
                recyclerView.mLayout.onItemsUpdated(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            } else {
                if (i != 8) {
                    return;
                }
                recyclerView.mLayout.onItemsMoved(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            }
        }

        public ViewHolder findViewHolder(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
            ViewHolder viewHolder = null;
            for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.mPosition == i) {
                    if (!((ArrayList) recyclerView.mChildHelper.options).contains(childViewHolderInt.itemView)) {
                        viewHolder = childViewHolderInt;
                        break;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
            if (viewHolder != null) {
                if (!((ArrayList) recyclerView.mChildHelper.options).contains(viewHolder.itemView)) {
                    return viewHolder;
                }
            }
            return null;
        }

        public void markViewHoldersUpdated(int i, int i2) {
            int i3;
            int i4;
            RecyclerView recyclerView = RecyclerView.this;
            int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
            int i5 = i2 + i;
            for (int i6 = 0; i6 < unfilteredChildCount; i6++) {
                View unfilteredChildAt = recyclerView.mChildHelper.getUnfilteredChildAt(i6);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(unfilteredChildAt);
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i && i4 < i5) {
                    childViewHolderInt.addFlags(2);
                    childViewHolderInt.addFlags(1024);
                    ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
                }
            }
            Recycler recycler = recyclerView.mRecycler;
            ArrayList arrayList = recycler.mCachedViews;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
                if (viewHolder != null && (i3 = viewHolder.mPosition) >= i && i3 < i5) {
                    viewHolder.addFlags(2);
                    recycler.recycleCachedViewAt(size);
                }
            }
            recyclerView.mItemsChanged = true;
        }

        public void offsetPositionsForAdd(int i, int i2) {
            RecyclerView recyclerView = RecyclerView.this;
            int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
            for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i3));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.offsetPosition(i2, false);
                    recyclerView.mState.mStructureChanged = true;
                }
            }
            ArrayList arrayList = recyclerView.mRecycler.mCachedViews;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewHolder viewHolder = (ViewHolder) arrayList.get(i4);
                if (viewHolder != null && viewHolder.mPosition >= i) {
                    viewHolder.offsetPosition(i2, false);
                }
            }
            recyclerView.requestLayout();
            recyclerView.mItemsAddedOrRemoved = true;
        }

        public void offsetPositionsForMove(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            RecyclerView recyclerView = RecyclerView.this;
            int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
            int i10 = -1;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            for (int i11 = 0; i11 < unfilteredChildCount; i11++) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i11));
                if (childViewHolderInt != null && (i9 = childViewHolderInt.mPosition) >= i4 && i9 <= i3) {
                    if (i9 == i) {
                        childViewHolderInt.offsetPosition(i2 - i, false);
                    } else {
                        childViewHolderInt.offsetPosition(i5, false);
                    }
                    recyclerView.mState.mStructureChanged = true;
                }
            }
            ArrayList arrayList = recyclerView.mRecycler.mCachedViews;
            if (i < i2) {
                i7 = i;
                i6 = i2;
            } else {
                i6 = i;
                i7 = i2;
                i10 = 1;
            }
            int size = arrayList.size();
            for (int i12 = 0; i12 < size; i12++) {
                ViewHolder viewHolder = (ViewHolder) arrayList.get(i12);
                if (viewHolder != null && (i8 = viewHolder.mPosition) >= i7 && i8 <= i6) {
                    if (i8 == i) {
                        viewHolder.offsetPosition(i2 - i, false);
                    } else {
                        viewHolder.offsetPosition(i10, false);
                    }
                }
            }
            recyclerView.requestLayout();
            recyclerView.mItemsAddedOrRemoved = true;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0020  */
        public void processAppeared(ViewHolder viewHolder, NavOptions.Builder builder, NavOptions.Builder builder2) {
            boolean zAnimateMove;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.getClass();
            viewHolder.setIsRecyclable(false);
            DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) recyclerView.mItemAnimator;
            if (builder != null) {
                defaultItemAnimator.getClass();
                int i = builder.enterAnim;
                int i2 = builder2.enterAnim;
                if (i == i2 && builder.exitAnim == builder2.exitAnim) {
                    defaultItemAnimator.resetAnimation(viewHolder);
                    viewHolder.itemView.setAlpha(0.0f);
                    defaultItemAnimator.mPendingAdditions.add(viewHolder);
                    zAnimateMove = true;
                } else {
                    zAnimateMove = defaultItemAnimator.animateMove(viewHolder, i, builder.exitAnim, i2, builder2.exitAnim);
                }
            } else {
                defaultItemAnimator.resetAnimation(viewHolder);
                viewHolder.itemView.setAlpha(0.0f);
                defaultItemAnimator.mPendingAdditions.add(viewHolder);
                zAnimateMove = true;
            }
            if (zAnimateMove) {
                recyclerView.postAnimationRunner();
            }
        }

        public void processDisappeared(ViewHolder viewHolder, NavOptions.Builder builder, NavOptions.Builder builder2) {
            boolean zAnimateMove;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mRecycler.unscrapView(viewHolder);
            recyclerView.addAnimatingView(viewHolder);
            viewHolder.setIsRecyclable(false);
            DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) recyclerView.mItemAnimator;
            defaultItemAnimator.getClass();
            int i = builder.enterAnim;
            int i2 = builder.exitAnim;
            View view = viewHolder.itemView;
            int left = builder2 == null ? view.getLeft() : builder2.enterAnim;
            int top = builder2 == null ? view.getTop() : builder2.exitAnim;
            if (viewHolder.isRemoved() || (i == left && i2 == top)) {
                defaultItemAnimator.resetAnimation(viewHolder);
                defaultItemAnimator.mPendingRemovals.add(viewHolder);
                zAnimateMove = true;
            } else {
                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                zAnimateMove = defaultItemAnimator.animateMove(viewHolder, i, i2, left, top);
            }
            if (zAnimateMove) {
                recyclerView.postAnimationRunner();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass5 {
        public /* synthetic */ AnonymousClass5() {
        }

        public void removeViewAt(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            View childAt = recyclerView.getChildAt(i);
            if (childAt != null) {
                RecyclerView.getChildViewHolderInt(childAt);
                childAt.clearAnimation();
            }
            recyclerView.removeViewAt(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Adapter {
        public final AdapterDataObservable mObservable = new AdapterDataObservable();
        public boolean mHasStableIds = false;
        public final int mStateRestorationPolicy = 1;

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public abstract void onBindViewHolder(ViewHolder viewHolder, int i);

        public abstract ViewHolder onCreateViewHolder(ViewGroup viewGroup);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AdapterDataObservable extends Observable {
        public final boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface ChildDrawingOrderCallback {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class EdgeEffectFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class ItemAnimator {
        public long mAddDuration;
        public long mChangeDuration;
        public ArrayList mFinishedListeners;
        public AnonymousClass5 mListener;
        public long mMoveDuration;
        public long mRemoveDuration;

        public static void buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            RecyclerView recyclerView;
            int i = viewHolder.mFlags;
            if (viewHolder.isInvalid() || (i & 4) != 0 || (recyclerView = viewHolder.mOwnerRecyclerView) == null) {
                return;
            }
            recyclerView.getAdapterPositionInRecyclerView(viewHolder);
        }

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, NavOptions.Builder builder, NavOptions.Builder builder2);

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            AnonymousClass5 anonymousClass5 = this.mListener;
            if (anonymousClass5 != null) {
                RecyclerView recyclerView = RecyclerView.this;
                boolean z = true;
                viewHolder.setIsRecyclable(true);
                View view = viewHolder.itemView;
                if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                    viewHolder.mShadowedHolder = null;
                }
                viewHolder.mShadowingHolder = null;
                if ((viewHolder.mFlags & 16) != 0) {
                    return;
                }
                Recycler recycler = recyclerView.mRecycler;
                recyclerView.startInterceptRequestLayout();
                ImageLoader$Builder imageLoader$Builder = recyclerView.mChildHelper;
                HeadersReader headersReader = (HeadersReader) imageLoader$Builder.defaults;
                AnonymousClass5 anonymousClass6 = (AnonymousClass5) imageLoader$Builder.applicationContext;
                int iIndexOfChild = RecyclerView.this.indexOfChild(view);
                if (iIndexOfChild == -1) {
                    imageLoader$Builder.unhideViewInternal(view);
                } else if (headersReader.get(iIndexOfChild)) {
                    headersReader.remove(iIndexOfChild);
                    imageLoader$Builder.unhideViewInternal(view);
                    anonymousClass6.removeViewAt(iIndexOfChild);
                } else {
                    z = false;
                }
                if (z) {
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                    recycler.unscrapView(childViewHolderInt);
                    recycler.recycleViewHolderInternal(childViewHolderInt);
                }
                recyclerView.stopInterceptRequestLayout(!z);
                if (z || !viewHolder.isTmpDetached()) {
                    return;
                }
                recyclerView.removeDetachedView(view, false);
            }
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class LayoutManager {
        public ImageLoader$Builder mChildHelper;
        public int mHeight;
        public int mHeightMode;
        public final RequestService mHorizontalBoundCheck;
        public boolean mIsAttachedToWindow;
        public final boolean mItemPrefetchEnabled;
        public final boolean mMeasurementCacheEnabled;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        public boolean mRequestedSimpleAnimations;
        public LinearSmoothScroller mSmoothScroller;
        public final RequestService mVerticalBoundCheck;
        public int mWidth;
        public int mWidthMode;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public LayoutManager() {
            MemoryCacheService memoryCacheService = new MemoryCacheService(17, this);
            Parameters.Builder builder = new Parameters.Builder(24, this);
            this.mHorizontalBoundCheck = new RequestService(memoryCacheService);
            this.mVerticalBoundCheck = new RequestService(builder);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001a  */
        /* JADX WARN: Code duplicated, block: B:14:0x0022  */
        /* JADX WARN: Code duplicated, block: B:5:0x0010  */
        public static int getChildMeasureSpec(boolean z, int i, int i2, int i3, int i4) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i2 = 1073741824;
                } else if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                    i2 = 0;
                    i4 = 0;
                } else {
                    i4 = iMax;
                }
            } else if (i4 >= 0) {
                i2 = 1073741824;
            } else if (i4 == -1) {
                i4 = iMax;
            } else if (i4 != -2) {
                i2 = 0;
                i4 = 0;
            } else if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                i4 = iMax;
                i2 = Integer.MIN_VALUE;
            } else {
                i4 = iMax;
                i2 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public static void getDecoratedBoundsWithMargins(View view, Rect rect) {
            int[] iArr = RecyclerView.NESTED_SCROLLING_ATTRS;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect2 = layoutParams.mDecorInsets;
            rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public static int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).mViewHolder.getLayoutPosition();
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, i2);
            properties.orientation = typedArrayObtainStyledAttributes.getInt(0, 1);
            properties.spanCount = typedArrayObtainStyledAttributes.getInt(10, 1);
            properties.reverseLayout = typedArrayObtainStyledAttributes.getBoolean(9, false);
            properties.stackFromEnd = typedArrayObtainStyledAttributes.getBoolean(11, false);
            typedArrayObtainStyledAttributes.recycle();
            return properties;
        }

        public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public static void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public final void addViewInt(View view, int i, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.mRecyclerView.mViewInfoStore.systemCallbacks;
                ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = (ViewInfoStore$InfoRecord) simpleArrayMap.get(childViewHolderInt);
                if (viewInfoStore$InfoRecordObtain == null) {
                    viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
                    simpleArrayMap.put(childViewHolderInt, viewInfoStore$InfoRecordObtain);
                }
                viewInfoStore$InfoRecordObtain.flags |= 1;
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.mScrapContainer.unscrapView(childViewHolderInt);
                } else {
                    childViewHolderInt.mFlags &= -33;
                }
                this.mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
            } else {
                if (view.getParent() == this.mRecyclerView) {
                    ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
                    HeadersReader headersReader = (HeadersReader) imageLoader$Builder.defaults;
                    int iIndexOfChild = RecyclerView.this.indexOfChild(view);
                    int iCountOnesBefore = (iIndexOfChild == -1 || headersReader.get(iIndexOfChild)) ? -1 : iIndexOfChild - headersReader.countOnesBefore(iIndexOfChild);
                    if (i == -1) {
                        i = this.mChildHelper.getChildCount();
                    }
                    if (iCountOnesBefore == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                    }
                    if (iCountOnesBefore != i) {
                        LayoutManager layoutManager = this.mRecyclerView.mLayout;
                        View childAt = layoutManager.getChildAt(iCountOnesBefore);
                        if (childAt == null) {
                            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iCountOnesBefore + layoutManager.mRecyclerView.toString());
                        }
                        layoutManager.getChildAt(iCountOnesBefore);
                        layoutManager.mChildHelper.detachViewFromParent(iCountOnesBefore);
                        LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                        ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(childAt);
                        if (childViewHolderInt2.isRemoved()) {
                            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) layoutManager.mRecyclerView.mViewInfoStore.systemCallbacks;
                            ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain2 = (ViewInfoStore$InfoRecord) simpleArrayMap2.get(childViewHolderInt2);
                            if (viewInfoStore$InfoRecordObtain2 == null) {
                                viewInfoStore$InfoRecordObtain2 = ViewInfoStore$InfoRecord.obtain();
                                simpleArrayMap2.put(childViewHolderInt2, viewInfoStore$InfoRecordObtain2);
                            }
                            viewInfoStore$InfoRecordObtain2.flags = 1 | viewInfoStore$InfoRecordObtain2.flags;
                        } else {
                            layoutManager.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt2);
                        }
                        layoutManager.mChildHelper.attachViewToParent(childAt, i, layoutParams2, childViewHolderInt2.isRemoved());
                    }
                } else {
                    this.mChildHelper.addView(view, i, false);
                    layoutParams.mInsetsDirty = true;
                    LinearSmoothScroller linearSmoothScroller = this.mSmoothScroller;
                    if (linearSmoothScroller != null && linearSmoothScroller.mRunning) {
                        linearSmoothScroller.mRecyclerView.getClass();
                        ViewHolder childViewHolderInt3 = RecyclerView.getChildViewHolderInt(view);
                        if ((childViewHolderInt3 != null ? childViewHolderInt3.getLayoutPosition() : -1) == linearSmoothScroller.mTargetPosition) {
                            linearSmoothScroller.mTargetView = view;
                        }
                    }
                }
            }
            if (layoutParams.mPendingInvalidate) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public abstract void assertNotInLayoutOrScroll(String str);

        public abstract boolean canScrollHorizontally();

        public abstract boolean canScrollVertically();

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public abstract void collectAdjacentPrefetchPositions(int i, int i2, State state, CircularArray circularArray);

        public abstract int computeHorizontalScrollExtent(State state);

        public abstract int computeHorizontalScrollOffset(State state);

        public abstract int computeHorizontalScrollRange(State state);

        public abstract int computeVerticalScrollExtent(State state);

        public abstract int computeVerticalScrollOffset(State state);

        public abstract int computeVerticalScrollRange(State state);

        public final void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (!childViewHolderInt.shouldIgnore()) {
                    if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.mHasStableIds) {
                        getChildAt(childCount);
                        this.mChildHelper.detachViewFromParent(childCount);
                        recycler.scrapView(childAt);
                        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
                    } else {
                        removeViewAt(childCount);
                        recycler.recycleViewHolderInternal(childViewHolderInt);
                    }
                }
            }
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.mInPreLayout || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public final View getChildAt(int i) {
            ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
            if (imageLoader$Builder != null) {
                return imageLoader$Builder.getChildAt(i);
            }
            return null;
        }

        public final int getChildCount() {
            ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
            if (imageLoader$Builder != null) {
                return imageLoader$Builder.getChildCount();
            }
            return 0;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public final int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public final int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public final int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public final int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public final void getTransformedBoundingBox(View view, Rect rect) {
            Matrix matrix;
            Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public abstract boolean isAutoMeasureEnabled();

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                int childCount = recyclerView.mChildHelper.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.mChildHelper.getChildAt(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                int childCount = recyclerView.mChildHelper.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.mChildHelper.getChildAt(i2).offsetTopAndBottom(i);
                }
            }
        }

        public abstract void onDetachedFromWindow(RecyclerView recyclerView);

        public abstract View onFocusSearchFailed(View view, int i, Recycler recycler, State state);

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            Recycler recycler = recyclerView.mRecycler;
            State state = recyclerView.mState;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            Adapter adapter = this.mRecyclerView.mAdapter;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public abstract void onLayoutChildren(Recycler recycler, State state);

        public abstract void onLayoutCompleted(State state);

        public abstract void onRestoreInstanceState(Parcelable parcelable);

        public abstract Parcelable onSaveInstanceState();

        public final void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    View childAt = getChildAt(childCount);
                    removeViewAt(childCount);
                    recycler.recycleView(childAt);
                }
            }
        }

        public final void removeAndRecycleScrapInt(Recycler recycler) {
            ArrayList arrayList = recycler.mAttachedScrap;
            int size = arrayList.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((ViewHolder) arrayList.get(i)).itemView;
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.mFlags &= -33;
                    recycler.recycleViewHolderInternal(childViewHolderInt2);
                }
            }
            arrayList.clear();
            ArrayList arrayList2 = recycler.mChangedScrap;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public final void removeAndRecycleView(View view, Recycler recycler) {
            ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
            AnonymousClass5 anonymousClass5 = (AnonymousClass5) imageLoader$Builder.applicationContext;
            int iIndexOfChild = RecyclerView.this.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (((HeadersReader) imageLoader$Builder.defaults).remove(iIndexOfChild)) {
                    imageLoader$Builder.unhideViewInternal(view);
                }
                anonymousClass5.removeViewAt(iIndexOfChild);
            }
            recycler.recycleView(view);
        }

        public final void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
                int offset = imageLoader$Builder.getOffset(i);
                AnonymousClass5 anonymousClass5 = (AnonymousClass5) imageLoader$Builder.applicationContext;
                View childAt = RecyclerView.this.getChildAt(offset);
                if (childAt == null) {
                    return;
                }
                if (((HeadersReader) imageLoader$Builder.defaults).remove(offset)) {
                    imageLoader$Builder.unhideViewInternal(childAt);
                }
                anonymousClass5.removeViewAt(offset);
            }
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:35:0x00be  */
        public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = this.mWidth - getPaddingRight();
            int paddingBottom = this.mHeight - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - paddingLeft;
            int iMin = Math.min(0, i);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - paddingRight;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - paddingBottom);
            RecyclerView recyclerView2 = this.mRecyclerView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (recyclerView2.getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            int[] iArr = {iMax, iMin2};
            int i4 = iArr[0];
            int i5 = iArr[1];
            if (z2) {
                View focusedChild = recyclerView.getFocusedChild();
                if (focusedChild != null) {
                    int paddingLeft2 = getPaddingLeft();
                    int paddingTop2 = getPaddingTop();
                    int paddingRight2 = this.mWidth - getPaddingRight();
                    int paddingBottom2 = this.mHeight - getPaddingBottom();
                    Rect rect2 = this.mRecyclerView.mTempRect;
                    getDecoratedBoundsWithMargins(focusedChild, rect2);
                    if (rect2.left - i4 < paddingRight2 && rect2.right - i4 > paddingLeft2 && rect2.top - i5 < paddingBottom2 && rect2.bottom - i5 > paddingTop2) {
                        if (i4 == 0) {
                        }
                        if (z) {
                            recyclerView.scrollBy(i4, i5);
                            return true;
                        }
                        recyclerView.smoothScrollBy$1(i4, i5, false);
                        return true;
                    }
                }
            } else if (i4 == 0 || i5 != 0) {
                if (z) {
                    recyclerView.scrollBy(i4, i5);
                    return true;
                }
                recyclerView.smoothScrollBy$1(i4, i5, false);
                return true;
            }
            return false;
        }

        public final void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int scrollHorizontallyBy(int i, Recycler recycler, State state);

        public abstract void scrollToPosition(int i);

        public abstract int scrollVerticallyBy(int i, Recycler recycler, State state);

        public final void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0) {
                int[] iArr = RecyclerView.NESTED_SCROLLING_ATTRS;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 == 0) {
                int[] iArr2 = RecyclerView.NESTED_SCROLLING_ATTRS;
            }
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            int paddingRight = getPaddingRight() + getPaddingLeft() + rect.width();
            int paddingBottom = getPaddingBottom() + getPaddingTop() + rect.height();
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            this.mRecyclerView.setMeasuredDimension(chooseSize(i, paddingRight, recyclerView.getMinimumWidth()), chooseSize(i2, paddingBottom, this.mRecyclerView.getMinimumHeight()));
        }

        public final void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i6) {
                    i6 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i5) {
                    i5 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i6, i4, i3, i5);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public final void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public final boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public final boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public abstract void smoothScrollToPosition(RecyclerView recyclerView, int i);

        public final void startSmoothScroll(LinearSmoothScroller linearSmoothScroller) {
            LinearSmoothScroller linearSmoothScroller2 = this.mSmoothScroller;
            if (linearSmoothScroller2 != null && linearSmoothScroller != linearSmoothScroller2 && linearSmoothScroller2.mRunning) {
                linearSmoothScroller2.stop();
            }
            this.mSmoothScroller = linearSmoothScroller;
            RecyclerView recyclerView = this.mRecyclerView;
            ViewFlinger viewFlinger = recyclerView.mViewFlinger;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.mOverScroller.abortAnimation();
            if (linearSmoothScroller.mStarted) {
                Log.w("RecyclerView", "An instance of " + linearSmoothScroller.getClass().getSimpleName() + " was started more than once. Each instance of" + linearSmoothScroller.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            linearSmoothScroller.mRecyclerView = recyclerView;
            linearSmoothScroller.mLayoutManager = this;
            int i = linearSmoothScroller.mTargetPosition;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.mTargetPosition = i;
            linearSmoothScroller.mRunning = true;
            linearSmoothScroller.mPendingInitialRun = true;
            linearSmoothScroller.mTargetView = recyclerView.mLayout.findViewByPosition(i);
            linearSmoothScroller.mRecyclerView.mViewFlinger.postOnAnimation();
            linearSmoothScroller.mStarted = true;
        }

        public abstract boolean supportsPredictiveItemAnimations();

        public final void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved()) {
                return;
            }
            ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
            if (((ArrayList) imageLoader$Builder.options).contains(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void onAdapterChanged() {
        }

        public void onItemsChanged() {
        }

        public void onScrollStateChanged(int i) {
        }

        public void collectInitialPrefetchPositions(int i, CircularArray circularArray) {
        }

        public void onItemsAdded(int i, int i2) {
        }

        public void onItemsMoved(int i, int i2) {
        }

        public void onItemsRemoved(int i, int i2) {
        }

        public void onItemsUpdated(int i, int i2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class OnFlingListener {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RecycledViewPool {
        public int mAttachCount;
        public SparseArray mScrap;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class ScrapData {
            public final ArrayList mScrapHeap = new ArrayList();
            public final int mMaxScrap = 5;
            public long mCreateRunningAverageNs = 0;
            public long mBindRunningAverageNs = 0;
        }

        public final ScrapData getScrapDataForType(int i) {
            SparseArray sparseArray = this.mScrap;
            ScrapData scrapData = (ScrapData) sparseArray.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            sparseArray.put(i, scrapData2);
            return scrapData2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Recycler {
        public final ArrayList mAttachedScrap;
        public final ArrayList mCachedViews;
        public ArrayList mChangedScrap;
        public RecycledViewPool mRecyclerPool;
        public int mRequestedCacheMax;
        public final List mUnmodifiableAttachedScrap;
        public int mViewCacheMax;

        public Recycler() {
            ArrayList arrayList = new ArrayList();
            this.mAttachedScrap = arrayList;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(arrayList);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        public final void addViewHolderToRecycledViewPool(ViewHolder viewHolder, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = recyclerView.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                RecyclerViewAccessibilityDelegate.ItemDelegate itemDelegate = recyclerViewAccessibilityDelegate.mItemDelegate;
                ViewCompat.setAccessibilityDelegate(view, itemDelegate != null ? (AccessibilityDelegateCompat) itemDelegate.mOriginalItemDelegates.remove(view) : null);
            }
            if (z) {
                ArrayList arrayList = recyclerView.mRecyclerListeners;
                if (arrayList.size() > 0) {
                    arrayList.get(0).getClass();
                    throw new ClassCastException();
                }
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
                }
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            RecycledViewPool recycledViewPool = getRecycledViewPool();
            recycledViewPool.getClass();
            int i = viewHolder.mItemViewType;
            ArrayList arrayList2 = recycledViewPool.getScrapDataForType(i).mScrapHeap;
            if (((RecycledViewPool.ScrapData) recycledViewPool.mScrap.get(i)).mMaxScrap <= arrayList2.size()) {
                return;
            }
            viewHolder.resetInternal();
            arrayList2.add(viewHolder);
        }

        public final int convertPreLayoutPositionToPostLayout(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i >= 0 && i < recyclerView.mState.getItemCount()) {
                return !recyclerView.mState.mInPreLayout ? i : recyclerView.mAdapterHelper.findPositionOffset(i, 0);
            }
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "invalid position ", ". State item count is ");
            sbM.append(recyclerView.mState.getItemCount());
            sbM.append(recyclerView.exceptionLabel());
            throw new IndexOutOfBoundsException(sbM.toString());
        }

        public final RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                RecycledViewPool recycledViewPool = new RecycledViewPool();
                recycledViewPool.mScrap = new SparseArray();
                recycledViewPool.mAttachCount = 0;
                this.mRecyclerPool = recycledViewPool;
            }
            return this.mRecyclerPool;
        }

        public final void recycleAndClearCachedViews() {
            ArrayList arrayList = this.mCachedViews;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            arrayList.clear();
            int[] iArr = RecyclerView.NESTED_SCROLLING_ATTRS;
            CircularArray circularArray = RecyclerView.this.mPrefetchRegistry;
            int[] iArr2 = (int[]) circularArray.elements;
            if (iArr2 != null) {
                Arrays.fill(iArr2, -1);
            }
            circularArray.capacityBitmask = 0;
        }

        public final void recycleCachedViewAt(int i) {
            ArrayList arrayList = this.mCachedViews;
            addViewHolderToRecycledViewPool((ViewHolder) arrayList.get(i), true);
            arrayList.remove(i);
        }

        public final void recycleView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            boolean zIsTmpDetached = childViewHolderInt.isTmpDetached();
            RecyclerView recyclerView = RecyclerView.this;
            if (zIsTmpDetached) {
                recyclerView.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.mScrapContainer.unscrapView(childViewHolderInt);
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.mFlags &= -33;
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (recyclerView.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            recyclerView.mItemAnimator.endAnimation(childViewHolderInt);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0032  */
        /* JADX WARN: Code duplicated, block: B:40:0x0078  */
        /* JADX WARN: Code duplicated, block: B:42:0x0086  */
        /* JADX WARN: Code duplicated, block: B:44:0x008d  */
        /* JADX WARN: Code duplicated, block: B:47:0x0098 A[LOOP:2: B:43:0x008b->B:47:0x0098, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:74:0x009b A[EDGE_INSN: B:74:0x009b->B:48:0x009b BREAK  A[LOOP:1: B:39:0x0076->B:46:0x0095], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:75:0x009b A[EDGE_INSN: B:75:0x009b->B:48:0x009b BREAK  A[LOOP:1: B:39:0x0076->B:46:0x0095, LOOP_LABEL: LOOP:1: B:39:0x0076->B:46:0x0095], SYNTHETIC] */
        public final void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z;
            boolean z2;
            int i;
            int i2;
            int i3;
            int i4;
            RecyclerView recyclerView = RecyclerView.this;
            CircularArray circularArray = recyclerView.mPrefetchRegistry;
            boolean zIsScrap = viewHolder.isScrap();
            View view = viewHolder.itemView;
            boolean z3 = false;
            boolean z4 = true;
            if (zIsScrap || view.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.isScrap());
                sb.append(" isAttached:");
                sb.append(view.getParent() != null);
                sb.append(recyclerView.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (viewHolder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + recyclerView.exceptionLabel());
            }
            if (viewHolder.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + recyclerView.exceptionLabel());
            }
            if ((viewHolder.mFlags & 16) == 0) {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (view.hasTransientState()) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (viewHolder.isRecyclable()) {
                if (this.mViewCacheMax <= 0 || (viewHolder.mFlags & 526) != 0) {
                    z2 = false;
                } else {
                    ArrayList arrayList = this.mCachedViews;
                    int size = arrayList.size();
                    if (size >= this.mViewCacheMax && size > 0) {
                        recycleCachedViewAt(0);
                        size--;
                    }
                    int[] iArr = RecyclerView.NESTED_SCROLLING_ATTRS;
                    if (size > 0) {
                        int i5 = viewHolder.mPosition;
                        if (((int[]) circularArray.elements) != null) {
                            int i6 = circularArray.capacityBitmask * 2;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    i = size - 1;
                                    loop1: while (i >= 0) {
                                        i2 = ((ViewHolder) arrayList.get(i)).mPosition;
                                        if (((int[]) circularArray.elements) != null) {
                                            break;
                                        }
                                        i3 = circularArray.capacityBitmask * 2;
                                        i4 = 0;
                                        while (true) {
                                            if (i4 < i3) {
                                                break loop1;
                                            } else if (((int[]) circularArray.elements)[i4] == i2) {
                                                break;
                                            } else {
                                                i4 += 2;
                                            }
                                        }
                                        i--;
                                    }
                                    size = i + 1;
                                } else if (((int[]) circularArray.elements)[i7] != i5) {
                                    i7 += 2;
                                }
                            }
                        } else {
                            i = size - 1;
                            loop1: while (i >= 0) {
                                i2 = ((ViewHolder) arrayList.get(i)).mPosition;
                                if (((int[]) circularArray.elements) != null) {
                                    break;
                                    break;
                                }
                                i3 = circularArray.capacityBitmask * 2;
                                i4 = 0;
                                while (true) {
                                    if (i4 < i3) {
                                        break loop1;
                                        break loop1;
                                    } else if (((int[]) circularArray.elements)[i4] == i2) {
                                        break;
                                    } else {
                                        i4 += 2;
                                    }
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                    }
                    arrayList.add(size, viewHolder);
                    z2 = true;
                }
                if (z2) {
                    z4 = false;
                } else {
                    addViewHolderToRecycledViewPool(viewHolder, true);
                }
                z3 = z2;
            } else {
                z4 = false;
            }
            recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
            if (z3 || z4 || !z) {
                return;
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
        }

        public final void scrapView(View view) {
            ItemAnimator itemAnimator;
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            int i = childViewHolderInt.mFlags & 12;
            RecyclerView recyclerView = RecyclerView.this;
            if (i == 0 && childViewHolderInt.isUpdated() && (itemAnimator = recyclerView.mItemAnimator) != null) {
                DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
                if (childViewHolderInt.getUnmodifiedPayloads().isEmpty() && defaultItemAnimator.mSupportsChangeAnimations && !childViewHolderInt.isInvalid()) {
                    if (this.mChangedScrap == null) {
                        this.mChangedScrap = new ArrayList();
                    }
                    childViewHolderInt.mScrapContainer = this;
                    childViewHolderInt.mInChangeScrap = true;
                    this.mChangedScrap.add(childViewHolderInt);
                    return;
                }
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !recyclerView.mAdapter.mHasStableIds) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + recyclerView.exceptionLabel());
            }
            childViewHolderInt.mScrapContainer = this;
            childViewHolderInt.mInChangeScrap = false;
            this.mAttachedScrap.add(childViewHolderInt);
        }

        /* JADX WARN: Code duplicated, block: B:110:0x01d5  */
        /* JADX WARN: Code duplicated, block: B:111:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:178:0x0327 A[EDGE_INSN: B:178:0x0327->B:179:0x0328 BREAK  A[LOOP:3: B:173:0x030f->B:177:0x0324]] */
        /* JADX WARN: Code duplicated, block: B:244:0x043d  */
        /* JADX WARN: Code duplicated, block: B:246:0x0452  */
        /* JADX WARN: Code duplicated, block: B:252:0x046c  */
        /* JADX WARN: Code duplicated, block: B:253:0x046f  */
        /* JADX WARN: Code duplicated, block: B:255:0x0472  */
        /* JADX WARN: Code duplicated, block: B:257:0x0478  */
        /* JADX WARN: Code duplicated, block: B:261:0x0497  */
        /* JADX WARN: Code duplicated, block: B:263:0x049b  */
        /* JADX WARN: Code duplicated, block: B:266:0x04ac  */
        /* JADX WARN: Code duplicated, block: B:271:0x04cb  */
        /* JADX WARN: Code duplicated, block: B:277:0x04e0  */
        /* JADX WARN: Code duplicated, block: B:279:0x04e3  */
        /* JADX WARN: Code duplicated, block: B:281:0x04ec  */
        /* JADX WARN: Code duplicated, block: B:285:0x04f4  */
        /* JADX WARN: Code duplicated, block: B:287:0x04f8  */
        /* JADX WARN: Code duplicated, block: B:288:0x04fa  */
        /* JADX WARN: Code duplicated, block: B:290:0x04fd  */
        /* JADX WARN: Code duplicated, block: B:293:0x0504  */
        /* JADX WARN: Code duplicated, block: B:295:0x0508  */
        /* JADX WARN: Code duplicated, block: B:296:0x050e  */
        /* JADX WARN: Code duplicated, block: B:301:0x0521  */
        /* JADX WARN: Code duplicated, block: B:304:0x0526  */
        /* JADX WARN: Code duplicated, block: B:308:0x052f  */
        /* JADX WARN: Code duplicated, block: B:309:0x0539  */
        /* JADX WARN: Code duplicated, block: B:311:0x053f  */
        /* JADX WARN: Code duplicated, block: B:312:0x0549  */
        /* JADX WARN: Code duplicated, block: B:317:0x0553  */
        /* JADX WARN: Code duplicated, block: B:35:0x007b A[EDGE_INSN: B:35:0x007b->B:36:0x007c BREAK  A[LOOP:0: B:14:0x0023->B:20:0x003d]] */
        public final ViewHolder tryGetViewHolderForPositionByDeadline(int i, long j) {
            boolean z;
            ViewHolder viewHolderOnCreateViewHolder;
            boolean z2;
            long j2;
            long j3;
            int iFindPositionOffset;
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            int i2;
            Adapter adapter;
            boolean z3;
            long nanoTime;
            long j4;
            AccessibilityManager accessibilityManager;
            boolean z4;
            boolean z5;
            boolean z6;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate;
            RecyclerViewAccessibilityDelegate.ItemDelegate itemDelegate;
            boolean z7;
            View.AccessibilityDelegate accessibilityDelegateInternal;
            ArrayList arrayList;
            ViewGroup.LayoutParams layoutParams;
            long j5;
            ViewGroup.LayoutParams layoutParams2;
            LayoutParams layoutParams3;
            ViewHolder viewHolder;
            int i3;
            View view;
            Adapter adapter2;
            boolean z8;
            int size;
            int iFindPositionOffset2;
            RecyclerView recyclerView = RecyclerView.this;
            State state = recyclerView.mState;
            if (i < 0 || i >= state.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + state.getItemCount() + recyclerView.exceptionLabel());
            }
            if (state.mInPreLayout) {
                ArrayList arrayList2 = this.mChangedScrap;
                if (arrayList2 != null && (size = arrayList2.size()) != 0) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            if (recyclerView.mAdapter.mHasStableIds && (iFindPositionOffset2 = recyclerView.mAdapterHelper.findPositionOffset(i, 0)) > 0 && iFindPositionOffset2 < recyclerView.mAdapter.getItemCount()) {
                                long itemId = recyclerView.mAdapter.getItemId(iFindPositionOffset2);
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= size) {
                                        viewHolderOnCreateViewHolder = null;
                                        break;
                                    }
                                    ViewHolder viewHolder2 = (ViewHolder) this.mChangedScrap.get(i5);
                                    if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.mItemId == itemId) {
                                        viewHolder2.addFlags(32);
                                        viewHolderOnCreateViewHolder = viewHolder2;
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                viewHolderOnCreateViewHolder = null;
                                break;
                            }
                        } else {
                            viewHolderOnCreateViewHolder = (ViewHolder) this.mChangedScrap.get(i4);
                            if (!viewHolderOnCreateViewHolder.wasReturnedFromScrap() && viewHolderOnCreateViewHolder.getLayoutPosition() == i) {
                                viewHolderOnCreateViewHolder.addFlags(32);
                                break;
                            }
                            i4++;
                        }
                    }
                } else {
                    viewHolderOnCreateViewHolder = null;
                    break;
                }
                z = viewHolderOnCreateViewHolder != null;
            } else {
                z = false;
                viewHolderOnCreateViewHolder = null;
            }
            ArrayList arrayList3 = this.mAttachedScrap;
            ArrayList arrayList4 = this.mCachedViews;
            if (viewHolderOnCreateViewHolder == null) {
                int size2 = arrayList3.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        ArrayList arrayList5 = (ArrayList) recyclerView.mChildHelper.options;
                        int size3 = arrayList5.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size3) {
                                z2 = true;
                                view = null;
                                break;
                            }
                            view = (View) arrayList5.get(i7);
                            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                            z2 = true;
                            if (childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved()) {
                                break;
                            }
                            i7++;
                        }
                        if (view == null) {
                            int size4 = arrayList4.size();
                            int i8 = 0;
                            while (true) {
                                if (i8 >= size4) {
                                    viewHolderOnCreateViewHolder = null;
                                    break;
                                }
                                ViewHolder viewHolder3 = (ViewHolder) arrayList4.get(i8);
                                if (!viewHolder3.isInvalid() && viewHolder3.getLayoutPosition() == i && !viewHolder3.isAttachedToTransitionOverlay()) {
                                    arrayList4.remove(i8);
                                    viewHolderOnCreateViewHolder = viewHolder3;
                                    break;
                                }
                                i8++;
                            }
                        } else {
                            ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                            ImageLoader$Builder imageLoader$Builder = recyclerView.mChildHelper;
                            HeadersReader headersReader = (HeadersReader) imageLoader$Builder.defaults;
                            int iIndexOfChild = RecyclerView.this.indexOfChild(view);
                            if (iIndexOfChild < 0) {
                                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                            }
                            if (!headersReader.get(iIndexOfChild)) {
                                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                            }
                            headersReader.clear(iIndexOfChild);
                            imageLoader$Builder.unhideViewInternal(view);
                            ImageLoader$Builder imageLoader$Builder2 = recyclerView.mChildHelper;
                            HeadersReader headersReader2 = (HeadersReader) imageLoader$Builder2.defaults;
                            int iIndexOfChild2 = RecyclerView.this.indexOfChild(view);
                            int iCountOnesBefore = (iIndexOfChild2 == -1 || headersReader2.get(iIndexOfChild2)) ? -1 : iIndexOfChild2 - headersReader2.countOnesBefore(iIndexOfChild2);
                            if (iCountOnesBefore == -1) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt2 + recyclerView.exceptionLabel());
                            }
                            recyclerView.mChildHelper.detachViewFromParent(iCountOnesBefore);
                            scrapView(view);
                            childViewHolderInt2.addFlags(8224);
                            viewHolderOnCreateViewHolder = childViewHolderInt2;
                            break;
                        }
                    } else {
                        ViewHolder viewHolder4 = (ViewHolder) arrayList3.get(i6);
                        if (!viewHolder4.wasReturnedFromScrap() && viewHolder4.getLayoutPosition() == i && !viewHolder4.isInvalid() && (state.mInPreLayout || !viewHolder4.isRemoved())) {
                            viewHolder4.addFlags(32);
                            viewHolderOnCreateViewHolder = viewHolder4;
                            z2 = true;
                            break;
                        }
                        i6++;
                    }
                }
                if (viewHolderOnCreateViewHolder != null) {
                    if (viewHolderOnCreateViewHolder.isRemoved()) {
                        z8 = state.mInPreLayout;
                    } else {
                        int i9 = viewHolderOnCreateViewHolder.mPosition;
                        if (i9 < 0 || i9 >= recyclerView.mAdapter.getItemCount()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolderOnCreateViewHolder + recyclerView.exceptionLabel());
                        }
                        if (state.mInPreLayout) {
                            adapter2 = recyclerView.mAdapter;
                            if (adapter2.mHasStableIds) {
                            }
                            z8 = z2;
                        } else {
                            recyclerView.mAdapter.getClass();
                            if (viewHolderOnCreateViewHolder.mItemViewType != 0) {
                                z8 = false;
                            } else {
                                adapter2 = recyclerView.mAdapter;
                                if (adapter2.mHasStableIds || viewHolderOnCreateViewHolder.mItemId == adapter2.getItemId(viewHolderOnCreateViewHolder.mPosition)) {
                                    z8 = z2;
                                } else {
                                    z8 = false;
                                }
                            }
                        }
                    }
                    if (z8) {
                        z = z2;
                    } else {
                        viewHolderOnCreateViewHolder.addFlags(4);
                        if (viewHolderOnCreateViewHolder.isScrap()) {
                            recyclerView.removeDetachedView(viewHolderOnCreateViewHolder.itemView, false);
                            viewHolderOnCreateViewHolder.mScrapContainer.unscrapView(viewHolderOnCreateViewHolder);
                        } else if (viewHolderOnCreateViewHolder.wasReturnedFromScrap()) {
                            viewHolderOnCreateViewHolder.mFlags &= -33;
                        }
                        recycleViewHolderInternal(viewHolderOnCreateViewHolder);
                        viewHolderOnCreateViewHolder = null;
                    }
                }
            } else {
                z2 = true;
            }
            if (viewHolderOnCreateViewHolder == null) {
                int iFindPositionOffset3 = recyclerView.mAdapterHelper.findPositionOffset(i, 0);
                if (iFindPositionOffset3 >= 0) {
                    j2 = 3;
                    if (iFindPositionOffset3 < recyclerView.mAdapter.getItemCount()) {
                        recyclerView.mAdapter.getClass();
                        Adapter adapter3 = recyclerView.mAdapter;
                        if (adapter3.mHasStableIds) {
                            long itemId2 = adapter3.getItemId(iFindPositionOffset3);
                            int size5 = arrayList3.size() - 1;
                            while (true) {
                                if (size5 < 0) {
                                    i3 = iFindPositionOffset3;
                                    j3 = 4;
                                    int size6 = arrayList4.size() - 1;
                                    while (true) {
                                        if (size6 >= 0) {
                                            ViewHolder viewHolder5 = (ViewHolder) arrayList4.get(size6);
                                            if (viewHolder5.mItemId != itemId2 || viewHolder5.isAttachedToTransitionOverlay()) {
                                                size6--;
                                            } else {
                                                if (viewHolder5.mItemViewType == 0) {
                                                    arrayList4.remove(size6);
                                                    viewHolderOnCreateViewHolder = viewHolder5;
                                                    break;
                                                }
                                                recycleCachedViewAt(size6);
                                            }
                                        }
                                        viewHolderOnCreateViewHolder = null;
                                        break;
                                    }
                                }
                                j3 = 4;
                                ViewHolder viewHolder6 = (ViewHolder) arrayList3.get(size5);
                                i3 = iFindPositionOffset3;
                                long j6 = viewHolder6.mItemId;
                                View view2 = viewHolder6.itemView;
                                if (j6 == itemId2 && !viewHolder6.wasReturnedFromScrap()) {
                                    if (viewHolder6.mItemViewType == 0) {
                                        viewHolder6.addFlags(32);
                                        if (viewHolder6.isRemoved() && !state.mInPreLayout) {
                                            viewHolder6.mFlags = (viewHolder6.mFlags & (-15)) | 2;
                                        }
                                        viewHolderOnCreateViewHolder = viewHolder6;
                                        break;
                                    }
                                    arrayList3.remove(size5);
                                    recyclerView.removeDetachedView(view2, false);
                                    ViewHolder childViewHolderInt3 = RecyclerView.getChildViewHolderInt(view2);
                                    childViewHolderInt3.mScrapContainer = null;
                                    childViewHolderInt3.mInChangeScrap = false;
                                    childViewHolderInt3.mFlags &= -33;
                                    recycleViewHolderInternal(childViewHolderInt3);
                                }
                                size5--;
                                iFindPositionOffset3 = i3;
                            }
                            if (viewHolderOnCreateViewHolder != null) {
                                viewHolderOnCreateViewHolder.mPosition = i3;
                                z = z2;
                            }
                        } else {
                            j3 = 4;
                        }
                        if (viewHolderOnCreateViewHolder == null) {
                            RecycledViewPool.ScrapData scrapData = (RecycledViewPool.ScrapData) getRecycledViewPool().mScrap.get(0);
                            if (scrapData == null) {
                                viewHolder = null;
                                break;
                            }
                            ArrayList arrayList6 = scrapData.mScrapHeap;
                            if (!arrayList6.isEmpty()) {
                                int size7 = arrayList6.size() - 1;
                                while (true) {
                                    if (size7 < 0) {
                                        viewHolder = null;
                                        break;
                                    }
                                    if (!((ViewHolder) arrayList6.get(size7)).isAttachedToTransitionOverlay()) {
                                        viewHolder = (ViewHolder) arrayList6.remove(size7);
                                        break;
                                    }
                                    size7--;
                                }
                            } else {
                                viewHolder = null;
                                break;
                            }
                            if (viewHolder != null) {
                                viewHolder.resetInternal();
                                int[] iArr = RecyclerView.NESTED_SCROLLING_ATTRS;
                            }
                            viewHolderOnCreateViewHolder = viewHolder;
                        }
                        if (viewHolderOnCreateViewHolder == null) {
                            long nanoTime2 = recyclerView.getNanoTime();
                            if (j != Long.MAX_VALUE) {
                                long j7 = this.mRecyclerPool.getScrapDataForType(0).mCreateRunningAverageNs;
                                if (!((j7 == 0 || j7 + nanoTime2 < j) ? z2 : false)) {
                                    return null;
                                }
                            }
                            Adapter adapter4 = recyclerView.mAdapter;
                            adapter4.getClass();
                            try {
                                int i10 = TraceCompat.$r8$clinit;
                                Trace.beginSection("RV CreateView");
                                viewHolderOnCreateViewHolder = adapter4.onCreateViewHolder(recyclerView);
                                View view3 = viewHolderOnCreateViewHolder.itemView;
                                if (view3.getParent() != null) {
                                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                                }
                                viewHolderOnCreateViewHolder.mItemViewType = 0;
                                Trace.endSection();
                                int[] iArr2 = RecyclerView.NESTED_SCROLLING_ATTRS;
                                RecyclerView recyclerViewFindNestedRecyclerView = RecyclerView.findNestedRecyclerView(view3);
                                if (recyclerViewFindNestedRecyclerView != null) {
                                    viewHolderOnCreateViewHolder.mNestedRecyclerView = new WeakReference(recyclerViewFindNestedRecyclerView);
                                }
                                long nanoTime3 = recyclerView.getNanoTime() - nanoTime2;
                                RecycledViewPool.ScrapData scrapDataForType = this.mRecyclerPool.getScrapDataForType(0);
                                long j8 = scrapDataForType.mCreateRunningAverageNs;
                                if (j8 != 0) {
                                    nanoTime3 = (nanoTime3 / j3) + ((j8 / j3) * 3);
                                }
                                scrapDataForType.mCreateRunningAverageNs = nanoTime3;
                            } catch (Throwable th) {
                                int i11 = TraceCompat.$r8$clinit;
                                Trace.endSection();
                                throw th;
                            }
                        }
                    }
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iFindPositionOffset3 + ").state:" + state.getItemCount() + recyclerView.exceptionLabel());
            }
            j2 = 3;
            j3 = 4;
            View view4 = viewHolderOnCreateViewHolder.itemView;
            if (z && !state.mInPreLayout) {
                int i12 = viewHolderOnCreateViewHolder.mFlags;
                if ((i12 & 8192) != 0 ? z2 : false) {
                    viewHolderOnCreateViewHolder.mFlags = i12 & (-8193);
                    if (state.mRunSimpleAnimations) {
                        ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolderOnCreateViewHolder);
                        ItemAnimator itemAnimator = recyclerView.mItemAnimator;
                        viewHolderOnCreateViewHolder.getUnmodifiedPayloads();
                        itemAnimator.getClass();
                        NavOptions.Builder builder = new NavOptions.Builder();
                        builder.setFrom(viewHolderOnCreateViewHolder);
                        recyclerView.recordAnimationInfoIfBouncedHiddenView(viewHolderOnCreateViewHolder, builder);
                    }
                }
            }
            if (!state.mInPreLayout || !viewHolderOnCreateViewHolder.isBound()) {
                if (viewHolderOnCreateViewHolder.isBound()) {
                    if (((viewHolderOnCreateViewHolder.mFlags & 2) != 0 ? z2 : false) || viewHolderOnCreateViewHolder.isInvalid()) {
                        iFindPositionOffset = recyclerView.mAdapterHelper.findPositionOffset(i, 0);
                        accessibilityDelegateCompat = null;
                        viewHolderOnCreateViewHolder.mBindingAdapter = null;
                        viewHolderOnCreateViewHolder.mOwnerRecyclerView = recyclerView;
                        i2 = viewHolderOnCreateViewHolder.mItemViewType;
                        long nanoTime4 = recyclerView.getNanoTime();
                        if (j != Long.MAX_VALUE) {
                            j5 = this.mRecyclerPool.getScrapDataForType(i2).mBindRunningAverageNs;
                            if (j5 != 0) {
                            }
                        }
                        adapter = recyclerView.mAdapter;
                        adapter.getClass();
                        if (viewHolderOnCreateViewHolder.mBindingAdapter == null) {
                            z3 = z2;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            viewHolderOnCreateViewHolder.mPosition = iFindPositionOffset;
                            if (adapter.mHasStableIds) {
                                viewHolderOnCreateViewHolder.mItemId = adapter.getItemId(iFindPositionOffset);
                            }
                            viewHolderOnCreateViewHolder.mFlags = (viewHolderOnCreateViewHolder.mFlags & (-520)) | 1;
                            int i13 = TraceCompat.$r8$clinit;
                            Trace.beginSection("RV OnBindView");
                        }
                        viewHolderOnCreateViewHolder.mBindingAdapter = adapter;
                        viewHolderOnCreateViewHolder.getUnmodifiedPayloads();
                        adapter.onBindViewHolder(viewHolderOnCreateViewHolder, iFindPositionOffset);
                        if (z3) {
                            arrayList = viewHolderOnCreateViewHolder.mPayloads;
                            if (arrayList != null) {
                                arrayList.clear();
                            }
                            viewHolderOnCreateViewHolder.mFlags &= -1025;
                            layoutParams = view4.getLayoutParams();
                            if (layoutParams instanceof LayoutParams) {
                                ((LayoutParams) layoutParams).mInsetsDirty = z2;
                            }
                            int i14 = TraceCompat.$r8$clinit;
                            Trace.endSection();
                        }
                        nanoTime = recyclerView.getNanoTime() - nanoTime4;
                        RecycledViewPool.ScrapData scrapDataForType2 = this.mRecyclerPool.getScrapDataForType(viewHolderOnCreateViewHolder.mItemViewType);
                        j4 = scrapDataForType2.mBindRunningAverageNs;
                        if (j4 != 0) {
                            nanoTime = (nanoTime / j3) + ((j4 / j3) * j2);
                        }
                        scrapDataForType2.mBindRunningAverageNs = nanoTime;
                        accessibilityManager = recyclerView.mAccessibilityManager;
                        if (accessibilityManager == null) {
                            z4 = false;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            z5 = true;
                            if (view4.getImportantForAccessibility() == 0) {
                                view4.setImportantForAccessibility(1);
                            }
                            recyclerViewAccessibilityDelegate = recyclerView.mAccessibilityDelegate;
                            if (recyclerViewAccessibilityDelegate != null) {
                                itemDelegate = recyclerViewAccessibilityDelegate.mItemDelegate;
                                if (itemDelegate != null) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                if (z7) {
                                    accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(view4);
                                    if (accessibilityDelegateInternal != null) {
                                        if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
                                            accessibilityDelegateCompat = ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
                                        } else {
                                            accessibilityDelegateCompat = new AccessibilityDelegateCompat(accessibilityDelegateInternal);
                                        }
                                    }
                                    if (accessibilityDelegateCompat != null) {
                                        itemDelegate.mOriginalItemDelegates.put(view4, accessibilityDelegateCompat);
                                    }
                                }
                                ViewCompat.setAccessibilityDelegate(view4, itemDelegate);
                            }
                        } else {
                            z5 = true;
                        }
                        if (state.mInPreLayout) {
                            viewHolderOnCreateViewHolder.mPreLayoutPosition = i;
                        }
                        z6 = z5;
                    }
                } else {
                    iFindPositionOffset = recyclerView.mAdapterHelper.findPositionOffset(i, 0);
                    accessibilityDelegateCompat = null;
                    viewHolderOnCreateViewHolder.mBindingAdapter = null;
                    viewHolderOnCreateViewHolder.mOwnerRecyclerView = recyclerView;
                    i2 = viewHolderOnCreateViewHolder.mItemViewType;
                    long nanoTime5 = recyclerView.getNanoTime();
                    if (j != Long.MAX_VALUE) {
                        j5 = this.mRecyclerPool.getScrapDataForType(i2).mBindRunningAverageNs;
                        if (j5 != 0 || j5 + nanoTime5 < j) {
                        }
                    }
                    adapter = recyclerView.mAdapter;
                    adapter.getClass();
                    if (viewHolderOnCreateViewHolder.mBindingAdapter == null) {
                        z3 = z2;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        viewHolderOnCreateViewHolder.mPosition = iFindPositionOffset;
                        if (adapter.mHasStableIds) {
                            viewHolderOnCreateViewHolder.mItemId = adapter.getItemId(iFindPositionOffset);
                        }
                        viewHolderOnCreateViewHolder.mFlags = (viewHolderOnCreateViewHolder.mFlags & (-520)) | 1;
                        int i15 = TraceCompat.$r8$clinit;
                        Trace.beginSection("RV OnBindView");
                    }
                    viewHolderOnCreateViewHolder.mBindingAdapter = adapter;
                    viewHolderOnCreateViewHolder.getUnmodifiedPayloads();
                    adapter.onBindViewHolder(viewHolderOnCreateViewHolder, iFindPositionOffset);
                    if (z3) {
                        arrayList = viewHolderOnCreateViewHolder.mPayloads;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        viewHolderOnCreateViewHolder.mFlags &= -1025;
                        layoutParams = view4.getLayoutParams();
                        if (layoutParams instanceof LayoutParams) {
                            ((LayoutParams) layoutParams).mInsetsDirty = z2;
                        }
                        int i16 = TraceCompat.$r8$clinit;
                        Trace.endSection();
                    }
                    nanoTime = recyclerView.getNanoTime() - nanoTime5;
                    RecycledViewPool.ScrapData scrapDataForType3 = this.mRecyclerPool.getScrapDataForType(viewHolderOnCreateViewHolder.mItemViewType);
                    j4 = scrapDataForType3.mBindRunningAverageNs;
                    if (j4 != 0) {
                        nanoTime = (nanoTime / j3) + ((j4 / j3) * j2);
                    }
                    scrapDataForType3.mBindRunningAverageNs = nanoTime;
                    accessibilityManager = recyclerView.mAccessibilityManager;
                    if (accessibilityManager == null && accessibilityManager.isEnabled()) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        z5 = true;
                        if (view4.getImportantForAccessibility() == 0) {
                            view4.setImportantForAccessibility(1);
                        }
                        recyclerViewAccessibilityDelegate = recyclerView.mAccessibilityDelegate;
                        if (recyclerViewAccessibilityDelegate != null) {
                            itemDelegate = recyclerViewAccessibilityDelegate.mItemDelegate;
                            if (itemDelegate != null) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(view4);
                                if (accessibilityDelegateInternal != null) {
                                    if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
                                        accessibilityDelegateCompat = ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
                                    } else {
                                        accessibilityDelegateCompat = new AccessibilityDelegateCompat(accessibilityDelegateInternal);
                                    }
                                }
                                if (accessibilityDelegateCompat != null && accessibilityDelegateCompat != itemDelegate) {
                                    itemDelegate.mOriginalItemDelegates.put(view4, accessibilityDelegateCompat);
                                }
                            }
                            ViewCompat.setAccessibilityDelegate(view4, itemDelegate);
                        }
                    } else {
                        z5 = true;
                    }
                    if (state.mInPreLayout) {
                        viewHolderOnCreateViewHolder.mPreLayoutPosition = i;
                    }
                    z6 = z5;
                }
                layoutParams2 = view4.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams3 = (LayoutParams) recyclerView.generateDefaultLayoutParams();
                    view4.setLayoutParams(layoutParams3);
                } else if (recyclerView.checkLayoutParams(layoutParams2)) {
                    layoutParams3 = (LayoutParams) layoutParams2;
                } else {
                    layoutParams3 = (LayoutParams) recyclerView.generateLayoutParams(layoutParams2);
                    view4.setLayoutParams(layoutParams3);
                }
                layoutParams3.mViewHolder = viewHolderOnCreateViewHolder;
                if (z || !z6) {
                    z5 = false;
                }
                layoutParams3.mPendingInvalidate = z5;
                return viewHolderOnCreateViewHolder;
            }
            viewHolderOnCreateViewHolder.mPreLayoutPosition = i;
            z6 = false;
            z5 = z2;
            layoutParams2 = view4.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams3 = (LayoutParams) recyclerView.generateDefaultLayoutParams();
                view4.setLayoutParams(layoutParams3);
            } else if (recyclerView.checkLayoutParams(layoutParams2)) {
                layoutParams3 = (LayoutParams) recyclerView.generateLayoutParams(layoutParams2);
                view4.setLayoutParams(layoutParams3);
            } else {
                layoutParams3 = (LayoutParams) layoutParams2;
            }
            layoutParams3.mViewHolder = viewHolderOnCreateViewHolder;
            if (z) {
                z5 = false;
            } else {
                z5 = false;
            }
            layoutParams3.mPendingInvalidate = z5;
            return viewHolderOnCreateViewHolder;
        }

        public final void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.mFlags &= -33;
        }

        public final void updateViewCacheSize() {
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            this.mViewCacheMax = this.mRequestedCacheMax + (layoutManager != null ? layoutManager.mPrefetchMaxCountObserved : 0);
            ArrayList arrayList = this.mCachedViews;
            for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface RecyclerListener {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(5);
        public Parcelable mLayoutState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.mLayoutState, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class State {
        public int mDeletedInvisibleItemCountSincePreviousLayout;
        public long mFocusedItemId;
        public int mFocusedItemPosition;
        public int mFocusedSubChildId;
        public boolean mInPreLayout;
        public boolean mIsMeasuring;
        public int mItemCount;
        public int mLayoutStep;
        public int mPreviousLayoutItemCount;
        public boolean mRunPredictiveAnimations;
        public boolean mRunSimpleAnimations;
        public boolean mStructureChanged;
        public int mTargetPosition;
        public boolean mTrackOldChangeHolders;

        public final void assertLayoutStep(int i) {
            if ((this.mLayoutStep & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public final int getItemCount() {
            return this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=null, mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class ViewCacheExtension {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ViewFlinger implements Runnable {
        public boolean mEatRunOnAnimationRequest;
        public Interpolator mInterpolator;
        public int mLastFlingX;
        public int mLastFlingY;
        public OverScroller mOverScroller;
        public boolean mReSchedulePostAnimationCallback;

        public ViewFlinger() {
            ViewDragHelper.AnonymousClass1 anonymousClass1 = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = anonymousClass1;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), anonymousClass1);
        }

        public final void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            recyclerView.postOnAnimation(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            RecyclerView recyclerView = RecyclerView.this;
            int[] iArr = recyclerView.mReusableIntPair;
            if (recyclerView.mLayout == null) {
                recyclerView.removeCallbacks(this);
                this.mOverScroller.abortAnimation();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.mLastFlingX;
                int i7 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                int[] iArr2 = recyclerView.mReusableIntPair;
                iArr2[0] = 0;
                iArr2[1] = 0;
                if (recyclerView.dispatchNestedPreScroll(i6, i7, 1, iArr2, null)) {
                    i = i6 - iArr[0];
                    i2 = i7 - iArr[1];
                } else {
                    i = i6;
                    i2 = i7;
                }
                if (recyclerView.getOverScrollMode() != 2) {
                    recyclerView.considerReleasingGlowsOnScroll(i, i2);
                }
                if (recyclerView.mAdapter != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    recyclerView.scrollStep(i, i2, iArr);
                    i3 = iArr[0];
                    i4 = iArr[1];
                    i -= i3;
                    i2 -= i4;
                    LinearSmoothScroller linearSmoothScroller = recyclerView.mLayout.mSmoothScroller;
                    if (linearSmoothScroller != null && !linearSmoothScroller.mPendingInitialRun && linearSmoothScroller.mRunning) {
                        int itemCount = recyclerView.mState.getItemCount();
                        if (itemCount == 0) {
                            linearSmoothScroller.stop();
                        } else if (linearSmoothScroller.mTargetPosition >= itemCount) {
                            linearSmoothScroller.mTargetPosition = itemCount - 1;
                            linearSmoothScroller.onAnimation(i3, i4);
                        } else {
                            linearSmoothScroller.onAnimation(i3, i4);
                        }
                    }
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                if (!recyclerView.mItemDecorations.isEmpty()) {
                    recyclerView.invalidate();
                }
                int[] iArr3 = recyclerView.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView.dispatchNestedScroll(i3, i4, i, i2, null, 1, iArr3);
                int i8 = i - iArr[0];
                int i9 = i2 - iArr[1];
                if (i3 != 0 || i4 != 0) {
                    recyclerView.dispatchOnScrolled(i3, i4);
                }
                if (!recyclerView.awakenScrollBars()) {
                    recyclerView.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i8 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i9 != 0));
                LinearSmoothScroller linearSmoothScroller2 = recyclerView.mLayout.mSmoothScroller;
                if ((linearSmoothScroller2 == null || !linearSmoothScroller2.mPendingInitialRun) && z) {
                    if (recyclerView.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i8 < 0) {
                            i5 = -currVelocity;
                        } else {
                            i5 = i8 > 0 ? currVelocity : 0;
                        }
                        if (i9 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i9 <= 0) {
                            currVelocity = 0;
                        }
                        if (i5 < 0) {
                            recyclerView.ensureLeftGlow();
                            if (recyclerView.mLeftGlow.isFinished()) {
                                recyclerView.mLeftGlow.onAbsorb(-i5);
                            }
                        } else if (i5 > 0) {
                            recyclerView.ensureRightGlow();
                            if (recyclerView.mRightGlow.isFinished()) {
                                recyclerView.mRightGlow.onAbsorb(i5);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView.ensureTopGlow();
                            if (recyclerView.mTopGlow.isFinished()) {
                                recyclerView.mTopGlow.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView.ensureBottomGlow();
                            if (recyclerView.mBottomGlow.isFinished()) {
                                recyclerView.mBottomGlow.onAbsorb(currVelocity);
                            }
                        }
                        if (i5 != 0 || currVelocity != 0) {
                            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            recyclerView.postInvalidateOnAnimation();
                        }
                    }
                    CircularArray circularArray = recyclerView.mPrefetchRegistry;
                    int[] iArr4 = (int[]) circularArray.elements;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    circularArray.capacityBitmask = 0;
                } else {
                    postOnAnimation();
                    GapWorker gapWorker = recyclerView.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView, i3, i4);
                    }
                }
            }
            LinearSmoothScroller linearSmoothScroller3 = recyclerView.mLayout.mSmoothScroller;
            if (linearSmoothScroller3 != null && linearSmoothScroller3.mPendingInitialRun) {
                linearSmoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (!this.mReSchedulePostAnimationCallback) {
                recyclerView.setScrollState(0);
                recyclerView.stopNestedScroll(1);
            } else {
                recyclerView.removeCallbacks(this);
                WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                recyclerView.postOnAnimation(this);
            }
        }

        public final void smoothScrollBy(int i, int i2, int i3, Interpolator interpolator) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i3 == Integer.MIN_VALUE) {
                int iAbs = Math.abs(i);
                int iAbs2 = Math.abs(i2);
                boolean z = iAbs > iAbs2;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                if (!z) {
                    iAbs = iAbs2;
                }
                i3 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(recyclerView.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            recyclerView.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i, i2, i4);
            postOnAnimation();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class ViewHolder {
        public static final List FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        public final View itemView;
        public Adapter mBindingAdapter;
        public int mFlags;
        public WeakReference mNestedRecyclerView;
        public RecyclerView mOwnerRecyclerView;
        public int mPosition = -1;
        public int mOldPosition = -1;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public int mPreLayoutPosition = -1;
        public ViewHolder mShadowedHolder = null;
        public ViewHolder mShadowingHolder = null;
        public final ArrayList mPayloads = null;
        public final List mUnmodifiedPayloads = null;
        public int mIsRecyclableCount = 0;
        public Recycler mScrapContainer = null;
        public boolean mInChangeScrap = false;
        public int mWasImportantForAccessibilityBeforeHidden = 0;
        public int mPendingAccessibilityState = -1;

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        public final void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final List getUnmodifiedPayloads() {
            ArrayList arrayList;
            return ((this.mFlags & 1024) != 0 || (arrayList = this.mPayloads) == null || arrayList.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        public final boolean isAttachedToTransitionOverlay() {
            View view = this.itemView;
            return (view.getParent() == null || view.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public final boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public final boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) != 0) {
                return false;
            }
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return !this.itemView.hasTransientState();
        }

        public final boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public final boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public final boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public final boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public final void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            View view = this.itemView;
            if (view.getLayoutParams() != null) {
                ((LayoutParams) view.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public final void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            ArrayList arrayList = this.mPayloads;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.mFlags &= -1025;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && i2 == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if ((this.mFlags & 2) != 0) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if ((this.mFlags & 512) != 0 || isInvalid()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    static {
        Class cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new ViewDragHelper.AnonymousClass1(1);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.koala.clash.R.attr.recyclerViewStyle);
    }

    public static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        WeakReference weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == viewHolder.itemView) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    public final void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            this.mChildHelper.addView(view, -1, true);
            return;
        }
        ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
        int iIndexOfChild = RecyclerView.this.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            ((HeadersReader) imageLoader$Builder.defaults).set(iIndexOfChild);
            imageLoader$Builder.hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.getClass();
        }
        super.addFocusables(arrayList, i, i2);
    }

    public final void addItemDecoration(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.mItemDecorations;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(itemDecoration);
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public final void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public final void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public final void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.mOldPosition = -1;
                childViewHolderInt.mPreLayoutPosition = -1;
            }
        }
        Recycler recycler = this.mRecycler;
        ArrayList arrayList = recycler.mAttachedScrap;
        ArrayList arrayList2 = recycler.mCachedViews;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            ViewHolder viewHolder = (ViewHolder) arrayList2.get(i2);
            viewHolder.mOldPosition = -1;
            viewHolder.mPreLayoutPosition = -1;
        }
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ViewHolder viewHolder2 = (ViewHolder) arrayList.get(i3);
            viewHolder2.mOldPosition = -1;
            viewHolder2.mPreLayoutPosition = -1;
        }
        ArrayList arrayList3 = recycler.mChangedScrap;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ViewHolder viewHolder3 = (ViewHolder) recycler.mChangedScrap.get(i4);
                viewHolder3.mOldPosition = -1;
                viewHolder3.mPreLayoutPosition = -1;
            }
        }
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public final void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            postInvalidateOnAnimation();
        }
    }

    public final void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            int i = TraceCompat.$r8$clinit;
            Trace.beginSection("RV FullInvalidate");
            dispatchLayout();
            Trace.endSection();
            return;
        }
        Request request = this.mAdapterHelper;
        if (request.hasPendingUpdates()) {
            request.getClass();
            if (request.hasPendingUpdates()) {
                int i2 = TraceCompat.$r8$clinit;
                Trace.beginSection("RV FullInvalidate");
                dispatchLayout();
                Trace.endSection();
            }
        }
    }

    public final void defaultOnMeasure(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        setMeasuredDimension(LayoutManager.chooseSize(i, paddingRight, getMinimumWidth()), LayoutManager.chooseSize(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Code duplicated, block: B:166:0x0358  */
    /* JADX WARN: Code duplicated, block: B:185:0x039e  */
    /* JADX WARN: Code duplicated, block: B:187:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:193:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:195:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:197:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:200:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:203:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:206:0x03dd A[LOOP:4: B:199:0x03ca->B:206:0x03dd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:209:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:212:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:215:0x03fb A[LOOP:5: B:208:0x03e8->B:215:0x03fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:217:0x0400  */
    /* JADX WARN: Code duplicated, block: B:247:0x03e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x03e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:0x03db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:0x03fe A[EDGE_INSN: B:251:0x03fe->B:216:0x03fe BREAK  A[LOOP:5: B:208:0x03e8->B:215:0x03fb], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:0x03f9 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void dispatchLayout() {
        boolean z;
        long j;
        ViewHolder viewHolder;
        int i;
        int itemCount;
        int i2;
        int iMin;
        ViewHolder viewHolderFindViewHolderForAdapterPosition;
        View view;
        ViewHolder viewHolderFindViewHolderForAdapterPosition2;
        View view2;
        int i3;
        View viewFindViewById;
        View view3;
        boolean z2;
        NavOptions.Builder builder;
        ?? r3;
        boolean zAnimateMove;
        boolean z3;
        if (this.mAdapter == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        State state = this.mState;
        boolean z4 = false;
        state.mIsMeasuring = false;
        boolean z5 = true;
        boolean z6 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (state.mLayoutStep == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            Request request = this.mAdapterHelper;
            if ((((ArrayList) request.headers).isEmpty() || ((ArrayList) request.method).isEmpty()) && !z6 && this.mLayout.mWidth == getWidth() && this.mLayout.mHeight == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            }
        }
        state.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        state.mLayoutStep = 1;
        boolean z7 = state.mRunSimpleAnimations;
        Recycler recycler = this.mRecycler;
        RequestService requestService = this.mViewInfoStore;
        if (z7) {
            int childCount = this.mChildHelper.getChildCount() - 1;
            while (childCount >= 0) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (childViewHolderInt.shouldIgnore()) {
                    z3 = z5;
                } else {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    this.mItemAnimator.getClass();
                    NavOptions.Builder builder2 = new NavOptions.Builder();
                    builder2.setFrom(childViewHolderInt);
                    LongSparseArray longSparseArray = (LongSparseArray) requestService.hardwareBitmapService;
                    SimpleArrayMap simpleArrayMap = (SimpleArrayMap) requestService.systemCallbacks;
                    ViewHolder viewHolder2 = (ViewHolder) longSparseArray.get(changedHolderKey);
                    if (viewHolder2 == null || viewHolder2.shouldIgnore()) {
                        z3 = z5;
                        requestService.addToPostLayout(childViewHolderInt, builder2);
                    } else {
                        z3 = z5;
                        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) simpleArrayMap.get(viewHolder2);
                        boolean z8 = (viewInfoStore$InfoRecord == null || (viewInfoStore$InfoRecord.flags & 1) == 0) ? false : z3;
                        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord2 = (ViewInfoStore$InfoRecord) simpleArrayMap.get(childViewHolderInt);
                        boolean z9 = (viewInfoStore$InfoRecord2 == null || (viewInfoStore$InfoRecord2.flags & 1) == 0) ? false : z3;
                        if (z8 && viewHolder2 == childViewHolderInt) {
                            requestService.addToPostLayout(childViewHolderInt, builder2);
                        } else {
                            NavOptions.Builder builderPopFromLayoutStep = requestService.popFromLayoutStep(viewHolder2, 4);
                            requestService.addToPostLayout(childViewHolderInt, builder2);
                            NavOptions.Builder builderPopFromLayoutStep2 = requestService.popFromLayoutStep(childViewHolderInt, 8);
                            if (builderPopFromLayoutStep == null) {
                                int childCount2 = this.mChildHelper.getChildCount();
                                for (int i4 = 0; i4 < childCount2; i4++) {
                                    ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i4));
                                    if (childViewHolderInt2 != childViewHolderInt && getChangedHolderKey(childViewHolderInt2) == changedHolderKey) {
                                        Adapter adapter = this.mAdapter;
                                        if (adapter == null || !adapter.mHasStableIds) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt2 + " \n View Holder 2:" + childViewHolderInt + exceptionLabel());
                                        }
                                        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt2 + " \n View Holder 2:" + childViewHolderInt + exceptionLabel());
                                    }
                                }
                                Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + childViewHolderInt + exceptionLabel());
                            } else {
                                viewHolder2.setIsRecyclable(false);
                                if (z8) {
                                    addAnimatingView(viewHolder2);
                                }
                                if (viewHolder2 != childViewHolderInt) {
                                    if (z9) {
                                        addAnimatingView(childViewHolderInt);
                                    }
                                    viewHolder2.mShadowedHolder = childViewHolderInt;
                                    addAnimatingView(viewHolder2);
                                    recycler.unscrapView(viewHolder2);
                                    childViewHolderInt.setIsRecyclable(false);
                                    childViewHolderInt.mShadowingHolder = viewHolder2;
                                }
                                if (this.mItemAnimator.animateChange(viewHolder2, childViewHolderInt, builderPopFromLayoutStep, builderPopFromLayoutStep2)) {
                                    postAnimationRunner();
                                }
                            }
                        }
                    }
                }
                childCount--;
                z5 = z3;
            }
            z = z5;
            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) requestService.systemCallbacks;
            int i5 = simpleArrayMap2.size - 1;
            while (i5 >= 0) {
                ViewHolder viewHolder3 = (ViewHolder) simpleArrayMap2.keyAt(i5);
                ViewInfoStore$InfoRecord viewInfoStore$InfoRecord3 = (ViewInfoStore$InfoRecord) simpleArrayMap2.removeAt(i5);
                int i6 = viewInfoStore$InfoRecord3.flags;
                int i7 = i6 & 3;
                AnonymousClass4 anonymousClass4 = this.mViewInfoProcessCallback;
                if (i7 == 3) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.removeAndRecycleView(viewHolder3.itemView, recyclerView.mRecycler);
                    r3 = z4;
                } else if ((i6 & 1) != 0) {
                    NavOptions.Builder builder3 = viewInfoStore$InfoRecord3.preInfo;
                    if (builder3 == null) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.mLayout.removeAndRecycleView(viewHolder3.itemView, recyclerView2.mRecycler);
                        r3 = z4;
                    } else {
                        anonymousClass4.processDisappeared(viewHolder3, builder3, viewInfoStore$InfoRecord3.postInfo);
                        r3 = z4;
                    }
                } else if ((i6 & 14) == 14) {
                    anonymousClass4.processAppeared(viewHolder3, viewInfoStore$InfoRecord3.preInfo, viewInfoStore$InfoRecord3.postInfo);
                    r3 = z4;
                } else {
                    if ((i6 & 12) == 12) {
                        NavOptions.Builder builder4 = viewInfoStore$InfoRecord3.preInfo;
                        NavOptions.Builder builder5 = viewInfoStore$InfoRecord3.postInfo;
                        anonymousClass4.getClass();
                        viewHolder3.setIsRecyclable(z4);
                        RecyclerView recyclerView3 = RecyclerView.this;
                        if (!recyclerView3.mDataSetHasChangedAfterLayout) {
                            DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) recyclerView3.mItemAnimator;
                            defaultItemAnimator.getClass();
                            int i8 = builder4.enterAnim;
                            int i9 = builder5.enterAnim;
                            if (i8 == i9 && builder4.exitAnim == builder5.exitAnim) {
                                defaultItemAnimator.dispatchAnimationFinished(viewHolder3);
                                zAnimateMove = false;
                            } else {
                                zAnimateMove = defaultItemAnimator.animateMove(viewHolder3, i8, builder4.exitAnim, i9, builder5.exitAnim);
                            }
                            if (zAnimateMove) {
                                recyclerView3.postAnimationRunner();
                            }
                        } else if (recyclerView3.mItemAnimator.animateChange(viewHolder3, viewHolder3, builder4, builder5)) {
                            recyclerView3.postAnimationRunner();
                        }
                        r3 = 0;
                    } else {
                        if ((i6 & 4) != 0) {
                            builder = null;
                            anonymousClass4.processDisappeared(viewHolder3, viewInfoStore$InfoRecord3.preInfo, null);
                        } else {
                            builder = null;
                            if ((i6 & 8) != 0) {
                                anonymousClass4.processAppeared(viewHolder3, viewInfoStore$InfoRecord3.preInfo, viewInfoStore$InfoRecord3.postInfo);
                            }
                        }
                        r3 = 0;
                    }
                    viewInfoStore$InfoRecord3.flags = r3;
                    viewInfoStore$InfoRecord3.preInfo = builder;
                    viewInfoStore$InfoRecord3.postInfo = builder;
                    ViewInfoStore$InfoRecord.sPool.release(viewInfoStore$InfoRecord3);
                    i5--;
                    z4 = false;
                }
                builder = null;
                viewInfoStore$InfoRecord3.flags = r3;
                viewInfoStore$InfoRecord3.preInfo = builder;
                viewInfoStore$InfoRecord3.postInfo = builder;
                ViewInfoStore$InfoRecord.sPool.release(viewInfoStore$InfoRecord3);
                i5--;
                z4 = false;
            }
        } else {
            z = true;
        }
        View view4 = null;
        this.mLayout.removeAndRecycleScrapInt(recycler);
        state.mPreviousLayoutItemCount = state.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        state.mRunSimpleAnimations = false;
        state.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList arrayList = recycler.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            recycler.updateViewCacheSize();
        }
        this.mLayout.onLayoutCompleted(state);
        boolean z10 = z;
        onExitLayoutOrScroll(z10);
        stopInterceptRequestLayout(false);
        ((SimpleArrayMap) requestService.systemCallbacks).clear();
        ((LongSparseArray) requestService.hardwareBitmapService).clear();
        int[] iArr = this.mMinMaxLayoutPositions;
        int i10 = iArr[0];
        int i11 = iArr[z10 ? 1 : 0];
        findMinMaxChildLayoutPositions(iArr);
        if ((iArr[0] == i10 && iArr[z10 ? 1 : 0] == i11) ? false : true) {
            dispatchOnScrolled(0, 0);
        }
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (isFocused()) {
                j = state.mFocusedItemId;
                if (j == -1) {
                    viewHolder = null;
                } else {
                    viewHolder = null;
                }
                if (viewHolder != null) {
                    view3 = viewHolder.itemView;
                    if (!((ArrayList) this.mChildHelper.options).contains(view3)) {
                        if (this.mChildHelper.getChildCount() > 0) {
                            int i12 = state.mFocusedItemPosition;
                            if (i12 != -1) {
                            }
                            itemCount = state.getItemCount();
                            i2 = i;
                            while (true) {
                                if (i2 < itemCount) {
                                    viewHolderFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
                                    if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                                        view2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
                                        if (view2.hasFocusable()) {
                                            view4 = view2;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                for (iMin = Math.min(itemCount, i) - 1; iMin >= 0; iMin--) {
                                    viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                    if (viewHolderFindViewHolderForAdapterPosition == null) {
                                        break;
                                        break;
                                    }
                                    view = viewHolderFindViewHolderForAdapterPosition.itemView;
                                    if (view.hasFocusable()) {
                                        view4 = view;
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (this.mChildHelper.getChildCount() > 0) {
                        int i13 = state.mFocusedItemPosition;
                        if (i13 != -1) {
                        }
                        itemCount = state.getItemCount();
                        i2 = i;
                        while (true) {
                            if (i2 < itemCount) {
                                viewHolderFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
                                if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                                    view2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
                                    if (view2.hasFocusable()) {
                                        view4 = view2;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                            while (iMin >= 0) {
                                viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                if (viewHolderFindViewHolderForAdapterPosition == null) {
                                    break;
                                    break;
                                }
                                view = viewHolderFindViewHolderForAdapterPosition.itemView;
                                if (view.hasFocusable()) {
                                    view4 = view;
                                    break;
                                }
                            }
                        }
                    }
                } else if (this.mChildHelper.getChildCount() > 0) {
                    int i14 = state.mFocusedItemPosition;
                    if (i14 != -1) {
                    }
                    itemCount = state.getItemCount();
                    i2 = i;
                    while (true) {
                        if (i2 < itemCount) {
                            viewHolderFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
                            if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                                view2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
                                if (view2.hasFocusable()) {
                                    view4 = view2;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        while (iMin >= 0) {
                            viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                            if (viewHolderFindViewHolderForAdapterPosition == null) {
                                break;
                                break;
                            }
                            view = viewHolderFindViewHolderForAdapterPosition.itemView;
                            if (view.hasFocusable()) {
                                view4 = view;
                                break;
                            }
                        }
                    }
                }
                if (view4 != null) {
                    i3 = state.mFocusedSubChildId;
                    if (i3 != -1) {
                        view4 = viewFindViewById;
                    }
                    view4.requestFocus();
                }
            } else if (((ArrayList) this.mChildHelper.options).contains(getFocusedChild())) {
                j = state.mFocusedItemId;
                if (j == -1 && (z2 = this.mAdapter.mHasStableIds) && z2) {
                    int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
                    viewHolder = null;
                    for (int i15 = 0; i15 < unfilteredChildCount; i15++) {
                        ViewHolder childViewHolderInt3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i15));
                        if (childViewHolderInt3 != null && !childViewHolderInt3.isRemoved() && childViewHolderInt3.mItemId == j) {
                            if (!((ArrayList) this.mChildHelper.options).contains(childViewHolderInt3.itemView)) {
                                viewHolder = childViewHolderInt3;
                                break;
                            }
                            viewHolder = childViewHolderInt3;
                        }
                    }
                } else {
                    viewHolder = null;
                }
                if (viewHolder != null) {
                    view3 = viewHolder.itemView;
                    if (!((ArrayList) this.mChildHelper.options).contains(view3) && view3.hasFocusable()) {
                        view4 = view3;
                    } else if (this.mChildHelper.getChildCount() > 0) {
                        int i16 = state.mFocusedItemPosition;
                        i = i16 != -1 ? i16 : 0;
                        itemCount = state.getItemCount();
                        i2 = i;
                        while (true) {
                            if (i2 < itemCount) {
                                viewHolderFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
                                if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                                    view2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
                                    if (view2.hasFocusable()) {
                                        view4 = view2;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                            while (iMin >= 0) {
                                viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                if (viewHolderFindViewHolderForAdapterPosition == null) {
                                    break;
                                }
                                view = viewHolderFindViewHolderForAdapterPosition.itemView;
                                if (view.hasFocusable()) {
                                    view4 = view;
                                    break;
                                }
                            }
                        }
                    }
                } else if (this.mChildHelper.getChildCount() > 0) {
                    int i17 = state.mFocusedItemPosition;
                    if (i17 != -1) {
                    }
                    itemCount = state.getItemCount();
                    i2 = i;
                    while (true) {
                        if (i2 < itemCount) {
                            viewHolderFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
                            if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                                view2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
                                if (view2.hasFocusable()) {
                                    view4 = view2;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        while (iMin >= 0) {
                            viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                            if (viewHolderFindViewHolderForAdapterPosition == null) {
                                break;
                                break;
                            }
                            view = viewHolderFindViewHolderForAdapterPosition.itemView;
                            if (view.hasFocusable()) {
                                view4 = view;
                                break;
                            }
                        }
                    }
                }
                if (view4 != null) {
                    i3 = state.mFocusedSubChildId;
                    if (i3 != -1 && (viewFindViewById = view4.findViewById(i3)) != null && viewFindViewById.isFocusable()) {
                        view4 = viewFindViewById;
                    }
                    view4.requestFocus();
                }
            }
        }
        state.mFocusedItemId = -1L;
        state.mFocusedItemPosition = -1;
        state.mFocusedSubChildId = -1;
    }

    /* JADX WARN: Code duplicated, block: B:254:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:347:0x0240 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:47:0x010c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0110  */
    /* JADX WARN: Code duplicated, block: B:50:0x0118  */
    /* JADX WARN: Code duplicated, block: B:52:0x011d  */
    public final void dispatchLayoutStep1() {
        LongSparseArray longSparseArray;
        SimpleArrayMap simpleArrayMap;
        int adapterPositionInRecyclerView;
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord;
        LongSparseArray longSparseArray2;
        SimpleArrayMap simpleArrayMap2;
        View viewFindContainingItemView;
        boolean z;
        boolean z2;
        boolean z3;
        byte b;
        boolean z4;
        boolean z5;
        AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp;
        int i;
        int i2;
        int i3;
        AdapterHelper$UpdateOp adapterHelper$UpdateOp;
        State state = this.mState;
        state.assertLayoutStep(1);
        fillRemainingScrollValues(state);
        state.mIsMeasuring = false;
        startInterceptRequestLayout();
        RequestService requestService = this.mViewInfoStore;
        SimpleArrayMap simpleArrayMap3 = (SimpleArrayMap) requestService.systemCallbacks;
        SimpleArrayMap simpleArrayMap4 = (SimpleArrayMap) requestService.systemCallbacks;
        simpleArrayMap3.clear();
        LongSparseArray longSparseArray3 = (LongSparseArray) requestService.hardwareBitmapService;
        longSparseArray3.clear();
        onEnterLayoutOrScroll();
        if (this.mDataSetHasChangedAfterLayout) {
            Request request = this.mAdapterHelper;
            request.recycleUpdateOpsAndClearList((ArrayList) request.method);
            request.recycleUpdateOpsAndClearList((ArrayList) request.headers);
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged();
            }
        }
        if (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) {
            longSparseArray = longSparseArray3;
            simpleArrayMap = simpleArrayMap4;
            this.mAdapterHelper.consumeUpdatesInOnePass();
        } else {
            Request request2 = this.mAdapterHelper;
            Pools$SimplePool pools$SimplePool = (Pools$SimplePool) request2.url;
            AnonymousClass4 anonymousClass4 = (AnonymousClass4) request2.tags;
            Parameters.Builder builder = (Parameters.Builder) request2.lazyCacheControl;
            ArrayList arrayList = (ArrayList) request2.method;
            builder.getClass();
            while (true) {
                int size = arrayList.size() - 1;
                boolean z6 = false;
                while (true) {
                    if (size < 0) {
                        size = -1;
                        break;
                    }
                    if (((AdapterHelper$UpdateOp) arrayList.get(size)).cmd == 8) {
                        if (z6) {
                            break;
                        }
                    } else {
                        z6 = true;
                    }
                    size--;
                }
                if (size == -1) {
                    break;
                }
                int i4 = size + 1;
                Request request3 = (Request) builder.entries;
                Pools$SimplePool pools$SimplePool2 = (Pools$SimplePool) request3.url;
                AdapterHelper$UpdateOp adapterHelper$UpdateOp2 = (AdapterHelper$UpdateOp) arrayList.get(size);
                AdapterHelper$UpdateOp adapterHelper$UpdateOp3 = (AdapterHelper$UpdateOp) arrayList.get(i4);
                Parameters.Builder builder2 = builder;
                int i5 = adapterHelper$UpdateOp3.cmd;
                if (i5 != 1) {
                    AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp2 = null;
                    if (i5 == 2) {
                        longSparseArray3 = longSparseArray3;
                        simpleArrayMap4 = simpleArrayMap4;
                        int i6 = adapterHelper$UpdateOp2.positionStart;
                        int i7 = adapterHelper$UpdateOp2.itemCount;
                        if (i6 < i7) {
                            if (adapterHelper$UpdateOp3.positionStart == i6 && adapterHelper$UpdateOp3.itemCount == i7 - i6) {
                                z4 = false;
                                z5 = true;
                            } else {
                                z4 = false;
                                z5 = false;
                            }
                        } else if (adapterHelper$UpdateOp3.positionStart == i7 + 1 && adapterHelper$UpdateOp3.itemCount == i6 - i7) {
                            z4 = true;
                            z5 = true;
                        } else {
                            z4 = true;
                            z5 = false;
                        }
                        int i8 = adapterHelper$UpdateOp3.positionStart;
                        if (i7 < i8) {
                            adapterHelper$UpdateOp3.positionStart = i8 - 1;
                        } else {
                            int i9 = adapterHelper$UpdateOp3.itemCount;
                            if (i7 < i8 + i9) {
                                adapterHelper$UpdateOp3.itemCount = i9 - 1;
                                adapterHelper$UpdateOp2.cmd = 2;
                                adapterHelper$UpdateOp2.itemCount = 1;
                                if (adapterHelper$UpdateOp3.itemCount == 0) {
                                    arrayList.remove(i4);
                                    pools$SimplePool2.release(adapterHelper$UpdateOp3);
                                }
                            }
                        }
                        int i10 = adapterHelper$UpdateOp2.positionStart;
                        int i11 = adapterHelper$UpdateOp3.positionStart;
                        if (i10 <= i11) {
                            adapterHelper$UpdateOp3.positionStart = i11 + 1;
                        } else {
                            int i12 = i11 + adapterHelper$UpdateOp3.itemCount;
                            if (i10 < i12) {
                                adapterHelper$UpdateOpObtainUpdateOp2 = request3.obtainUpdateOp(2, i10 + 1, i12 - i10);
                                adapterHelper$UpdateOp3.itemCount = adapterHelper$UpdateOp2.positionStart - adapterHelper$UpdateOp3.positionStart;
                            }
                        }
                        AdapterHelper$UpdateOp adapterHelper$UpdateOp4 = adapterHelper$UpdateOpObtainUpdateOp2;
                        if (z5) {
                            arrayList.set(size, adapterHelper$UpdateOp3);
                            arrayList.remove(i4);
                            pools$SimplePool2.release(adapterHelper$UpdateOp2);
                        } else {
                            if (z4) {
                                if (adapterHelper$UpdateOp4 != null) {
                                    int i13 = adapterHelper$UpdateOp2.positionStart;
                                    if (i13 > adapterHelper$UpdateOp4.positionStart) {
                                        adapterHelper$UpdateOp2.positionStart = i13 - adapterHelper$UpdateOp4.itemCount;
                                    }
                                    int i14 = adapterHelper$UpdateOp2.itemCount;
                                    if (i14 > adapterHelper$UpdateOp4.positionStart) {
                                        adapterHelper$UpdateOp2.itemCount = i14 - adapterHelper$UpdateOp4.itemCount;
                                    }
                                }
                                int i15 = adapterHelper$UpdateOp2.positionStart;
                                if (i15 > adapterHelper$UpdateOp3.positionStart) {
                                    adapterHelper$UpdateOp2.positionStart = i15 - adapterHelper$UpdateOp3.itemCount;
                                }
                                int i16 = adapterHelper$UpdateOp2.itemCount;
                                if (i16 > adapterHelper$UpdateOp3.positionStart) {
                                    adapterHelper$UpdateOp2.itemCount = i16 - adapterHelper$UpdateOp3.itemCount;
                                }
                            } else {
                                if (adapterHelper$UpdateOp4 != null) {
                                    int i17 = adapterHelper$UpdateOp2.positionStart;
                                    if (i17 >= adapterHelper$UpdateOp4.positionStart) {
                                        adapterHelper$UpdateOp2.positionStart = i17 - adapterHelper$UpdateOp4.itemCount;
                                    }
                                    int i18 = adapterHelper$UpdateOp2.itemCount;
                                    if (i18 >= adapterHelper$UpdateOp4.positionStart) {
                                        adapterHelper$UpdateOp2.itemCount = i18 - adapterHelper$UpdateOp4.itemCount;
                                    }
                                }
                                int i19 = adapterHelper$UpdateOp2.positionStart;
                                if (i19 >= adapterHelper$UpdateOp3.positionStart) {
                                    adapterHelper$UpdateOp2.positionStart = i19 - adapterHelper$UpdateOp3.itemCount;
                                }
                                int i20 = adapterHelper$UpdateOp2.itemCount;
                                if (i20 >= adapterHelper$UpdateOp3.positionStart) {
                                    adapterHelper$UpdateOp2.itemCount = i20 - adapterHelper$UpdateOp3.itemCount;
                                }
                            }
                            arrayList.set(size, adapterHelper$UpdateOp3);
                            if (adapterHelper$UpdateOp2.positionStart != adapterHelper$UpdateOp2.itemCount) {
                                arrayList.set(i4, adapterHelper$UpdateOp2);
                            } else {
                                arrayList.remove(i4);
                            }
                            if (adapterHelper$UpdateOp4 != null) {
                                arrayList.add(size, adapterHelper$UpdateOp4);
                            }
                        }
                    } else if (i5 != 4) {
                        longSparseArray3 = longSparseArray3;
                        simpleArrayMap4 = simpleArrayMap4;
                    } else {
                        int i21 = adapterHelper$UpdateOp2.itemCount;
                        int i22 = adapterHelper$UpdateOp3.positionStart;
                        if (i21 < i22) {
                            adapterHelper$UpdateOp3.positionStart = i22 - 1;
                        } else {
                            int i23 = adapterHelper$UpdateOp3.itemCount;
                            if (i21 < i22 + i23) {
                                adapterHelper$UpdateOp3.itemCount = i23 - 1;
                                adapterHelper$UpdateOpObtainUpdateOp = request3.obtainUpdateOp(4, adapterHelper$UpdateOp2.positionStart, 1);
                            }
                            i = adapterHelper$UpdateOp2.positionStart;
                            i2 = adapterHelper$UpdateOp3.positionStart;
                            if (i <= i2) {
                                adapterHelper$UpdateOp3.positionStart = i2 + 1;
                            } else {
                                i3 = i2 + adapterHelper$UpdateOp3.itemCount;
                                if (i < i3) {
                                    int i24 = i3 - i;
                                    adapterHelper$UpdateOpObtainUpdateOp2 = request3.obtainUpdateOp(4, i + 1, i24);
                                    adapterHelper$UpdateOp3.itemCount -= i24;
                                }
                                adapterHelper$UpdateOp = adapterHelper$UpdateOpObtainUpdateOp2;
                                arrayList.set(i4, adapterHelper$UpdateOp2);
                                if (adapterHelper$UpdateOp3.itemCount > 0) {
                                    arrayList.set(size, adapterHelper$UpdateOp3);
                                } else {
                                    arrayList.remove(size);
                                    pools$SimplePool2.release(adapterHelper$UpdateOp3);
                                }
                                if (adapterHelper$UpdateOpObtainUpdateOp != null) {
                                    arrayList.add(size, adapterHelper$UpdateOpObtainUpdateOp);
                                }
                                if (adapterHelper$UpdateOp != null) {
                                    arrayList.add(size, adapterHelper$UpdateOp);
                                }
                            }
                            adapterHelper$UpdateOp = adapterHelper$UpdateOpObtainUpdateOp2;
                            arrayList.set(i4, adapterHelper$UpdateOp2);
                            if (adapterHelper$UpdateOp3.itemCount > 0) {
                                arrayList.set(size, adapterHelper$UpdateOp3);
                            } else {
                                arrayList.remove(size);
                                pools$SimplePool2.release(adapterHelper$UpdateOp3);
                            }
                            if (adapterHelper$UpdateOpObtainUpdateOp != null) {
                                arrayList.add(size, adapterHelper$UpdateOpObtainUpdateOp);
                            }
                            if (adapterHelper$UpdateOp != null) {
                                arrayList.add(size, adapterHelper$UpdateOp);
                            }
                        }
                        adapterHelper$UpdateOpObtainUpdateOp = null;
                        i = adapterHelper$UpdateOp2.positionStart;
                        i2 = adapterHelper$UpdateOp3.positionStart;
                        if (i <= i2) {
                            adapterHelper$UpdateOp3.positionStart = i2 + 1;
                        } else {
                            i3 = i2 + adapterHelper$UpdateOp3.itemCount;
                            if (i < i3) {
                                int i25 = i3 - i;
                                adapterHelper$UpdateOpObtainUpdateOp2 = request3.obtainUpdateOp(4, i + 1, i25);
                                adapterHelper$UpdateOp3.itemCount -= i25;
                            }
                            adapterHelper$UpdateOp = adapterHelper$UpdateOpObtainUpdateOp2;
                            arrayList.set(i4, adapterHelper$UpdateOp2);
                            if (adapterHelper$UpdateOp3.itemCount > 0) {
                                arrayList.set(size, adapterHelper$UpdateOp3);
                            } else {
                                arrayList.remove(size);
                                pools$SimplePool2.release(adapterHelper$UpdateOp3);
                            }
                            if (adapterHelper$UpdateOpObtainUpdateOp != null) {
                                arrayList.add(size, adapterHelper$UpdateOpObtainUpdateOp);
                            }
                            if (adapterHelper$UpdateOp != null) {
                                arrayList.add(size, adapterHelper$UpdateOp);
                            }
                        }
                        adapterHelper$UpdateOp = adapterHelper$UpdateOpObtainUpdateOp2;
                        arrayList.set(i4, adapterHelper$UpdateOp2);
                        if (adapterHelper$UpdateOp3.itemCount > 0) {
                            arrayList.set(size, adapterHelper$UpdateOp3);
                        } else {
                            arrayList.remove(size);
                            pools$SimplePool2.release(adapterHelper$UpdateOp3);
                        }
                        if (adapterHelper$UpdateOpObtainUpdateOp != null) {
                            arrayList.add(size, adapterHelper$UpdateOpObtainUpdateOp);
                        }
                        if (adapterHelper$UpdateOp != null) {
                            arrayList.add(size, adapterHelper$UpdateOp);
                        }
                    }
                } else {
                    longSparseArray3 = longSparseArray3;
                    simpleArrayMap4 = simpleArrayMap4;
                    int i26 = adapterHelper$UpdateOp2.itemCount;
                    int i27 = adapterHelper$UpdateOp3.positionStart;
                    int i28 = i26 < i27 ? -1 : 0;
                    int i29 = adapterHelper$UpdateOp2.positionStart;
                    if (i29 < i27) {
                        i28++;
                    }
                    if (i27 <= i29) {
                        adapterHelper$UpdateOp2.positionStart = i29 + adapterHelper$UpdateOp3.itemCount;
                    }
                    int i30 = adapterHelper$UpdateOp3.positionStart;
                    if (i30 <= i26) {
                        adapterHelper$UpdateOp2.itemCount = i26 + adapterHelper$UpdateOp3.itemCount;
                    }
                    adapterHelper$UpdateOp3.positionStart = i30 + i28;
                    arrayList.set(size, adapterHelper$UpdateOp3);
                    arrayList.set(i4, adapterHelper$UpdateOp2);
                }
                builder = builder2;
                longSparseArray3 = longSparseArray3;
                simpleArrayMap4 = simpleArrayMap4;
            }
            longSparseArray = longSparseArray3;
            simpleArrayMap = simpleArrayMap4;
            int size2 = arrayList.size();
            for (int i31 = 0; i31 < size2; i31++) {
                AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp3 = (AdapterHelper$UpdateOp) arrayList.get(i31);
                int i32 = adapterHelper$UpdateOpObtainUpdateOp3.cmd;
                if (i32 == 1) {
                    request2.postponeAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp3);
                } else if (i32 == 2) {
                    int i33 = adapterHelper$UpdateOpObtainUpdateOp3.positionStart;
                    int i34 = adapterHelper$UpdateOpObtainUpdateOp3.itemCount + i33;
                    int i35 = i33;
                    int i36 = 0;
                    byte b2 = -1;
                    while (i35 < i34) {
                        if (anonymousClass4.findViewHolder(i35) != null || request2.canFindInPreLayout(i35)) {
                            if (b2 == 0) {
                                request2.dispatchAndUpdateViewHolders(request2.obtainUpdateOp(2, i33, i36));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z3 = z2;
                            b = 1;
                        } else {
                            if (b2 == 1) {
                                request2.postponeAndUpdateViewHolders(request2.obtainUpdateOp(2, i33, i36));
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b = 0;
                        }
                        if (z3) {
                            i35 -= i36;
                            i34 -= i36;
                            i36 = 1;
                        } else {
                            i36++;
                        }
                        i35++;
                        b2 = b;
                    }
                    if (i36 != adapterHelper$UpdateOpObtainUpdateOp3.itemCount) {
                        pools$SimplePool.release(adapterHelper$UpdateOpObtainUpdateOp3);
                        adapterHelper$UpdateOpObtainUpdateOp3 = request2.obtainUpdateOp(2, i33, i36);
                    }
                    if (b2 == 0) {
                        request2.dispatchAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp3);
                    } else {
                        request2.postponeAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp3);
                    }
                } else if (i32 == 4) {
                    int i37 = adapterHelper$UpdateOpObtainUpdateOp3.positionStart;
                    int i38 = adapterHelper$UpdateOpObtainUpdateOp3.itemCount + i37;
                    int i39 = i37;
                    int i40 = 0;
                    byte b3 = -1;
                    while (i37 < i38) {
                        if (anonymousClass4.findViewHolder(i37) != null || request2.canFindInPreLayout(i37)) {
                            if (b3 == 0) {
                                request2.dispatchAndUpdateViewHolders(request2.obtainUpdateOp(4, i39, i40));
                                i39 = i37;
                                i40 = 0;
                            }
                            b3 = 1;
                        } else {
                            if (b3 == 1) {
                                request2.postponeAndUpdateViewHolders(request2.obtainUpdateOp(4, i39, i40));
                                i39 = i37;
                                i40 = 0;
                            }
                            b3 = 0;
                        }
                        i40++;
                        i37++;
                    }
                    if (i40 != adapterHelper$UpdateOpObtainUpdateOp3.itemCount) {
                        pools$SimplePool.release(adapterHelper$UpdateOpObtainUpdateOp3);
                        adapterHelper$UpdateOpObtainUpdateOp3 = request2.obtainUpdateOp(4, i39, i40);
                    }
                    if (b3 == 0) {
                        request2.dispatchAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp3);
                    } else {
                        request2.postponeAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp3);
                    }
                } else if (i32 == 8) {
                    request2.postponeAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp3);
                }
            }
            arrayList.clear();
        }
        boolean z7 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        boolean z8 = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z = this.mDataSetHasChangedAfterLayout) || z7 || this.mLayout.mRequestedSimpleAnimations) && (!z || this.mAdapter.mHasStableIds);
        State state2 = this.mState;
        state2.mRunSimpleAnimations = z8;
        state2.mRunPredictiveAnimations = z8 && z7 && !this.mDataSetHasChangedAfterLayout && this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
        ViewHolder childViewHolder = null;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        if (focusedChild != null && (viewFindContainingItemView = findContainingItemView(focusedChild)) != null) {
            childViewHolder = getChildViewHolder(viewFindContainingItemView);
        }
        if (childViewHolder == null) {
            state.mFocusedItemId = -1L;
            state.mFocusedItemPosition = -1;
            state.mFocusedSubChildId = -1;
        } else {
            state.mFocusedItemId = this.mAdapter.mHasStableIds ? childViewHolder.mItemId : -1L;
            if (this.mDataSetHasChangedAfterLayout) {
                adapterPositionInRecyclerView = -1;
            } else if (childViewHolder.isRemoved()) {
                adapterPositionInRecyclerView = childViewHolder.mOldPosition;
            } else {
                RecyclerView recyclerView = childViewHolder.mOwnerRecyclerView;
                if (recyclerView == null) {
                    adapterPositionInRecyclerView = -1;
                } else {
                    adapterPositionInRecyclerView = recyclerView.getAdapterPositionInRecyclerView(childViewHolder);
                }
            }
            state.mFocusedItemPosition = adapterPositionInRecyclerView;
            View focusedChild2 = childViewHolder.itemView;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            state.mFocusedSubChildId = id;
        }
        state.mTrackOldChangeHolders = state.mRunSimpleAnimations && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state.mInPreLayout = state.mRunPredictiveAnimations;
        state.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (state.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            int i41 = 0;
            while (i41 < childCount) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i41));
                if (childViewHolderInt.shouldIgnore() || (childViewHolderInt.isInvalid() && !this.mAdapter.mHasStableIds)) {
                    longSparseArray2 = longSparseArray;
                    simpleArrayMap2 = simpleArrayMap;
                } else {
                    ItemAnimator itemAnimator = this.mItemAnimator;
                    ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    itemAnimator.getClass();
                    NavOptions.Builder builder3 = new NavOptions.Builder();
                    builder3.setFrom(childViewHolderInt);
                    simpleArrayMap2 = simpleArrayMap;
                    ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = (ViewInfoStore$InfoRecord) simpleArrayMap2.get(childViewHolderInt);
                    if (viewInfoStore$InfoRecordObtain == null) {
                        viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
                        simpleArrayMap2.put(childViewHolderInt, viewInfoStore$InfoRecordObtain);
                    }
                    viewInfoStore$InfoRecordObtain.preInfo = builder3;
                    viewInfoStore$InfoRecordObtain.flags |= 4;
                    if (!state.mTrackOldChangeHolders || !childViewHolderInt.isUpdated() || childViewHolderInt.isRemoved() || childViewHolderInt.shouldIgnore() || childViewHolderInt.isInvalid()) {
                        longSparseArray2 = longSparseArray;
                    } else {
                        longSparseArray2 = longSparseArray;
                        longSparseArray2.put(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
                i41++;
                longSparseArray = longSparseArray2;
                simpleArrayMap = simpleArrayMap2;
            }
        }
        SimpleArrayMap simpleArrayMap5 = simpleArrayMap;
        if (state.mRunPredictiveAnimations) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i42 = 0; i42 < unfilteredChildCount; i42++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i42));
                if (!childViewHolderInt2.shouldIgnore() && childViewHolderInt2.mOldPosition == -1) {
                    childViewHolderInt2.mOldPosition = childViewHolderInt2.mPosition;
                }
            }
            boolean z9 = state.mStructureChanged;
            state.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state);
            state.mStructureChanged = z9;
            for (int i43 = 0; i43 < this.mChildHelper.getChildCount(); i43++) {
                ViewHolder childViewHolderInt3 = getChildViewHolderInt(this.mChildHelper.getChildAt(i43));
                if (!childViewHolderInt3.shouldIgnore() && ((viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) simpleArrayMap5.get(childViewHolderInt3)) == null || (viewInfoStore$InfoRecord.flags & 4) == 0)) {
                    ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt3);
                    boolean z10 = (childViewHolderInt3.mFlags & 8192) != 0;
                    ItemAnimator itemAnimator2 = this.mItemAnimator;
                    childViewHolderInt3.getUnmodifiedPayloads();
                    itemAnimator2.getClass();
                    NavOptions.Builder builder4 = new NavOptions.Builder();
                    builder4.setFrom(childViewHolderInt3);
                    if (z10) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt3, builder4);
                    } else {
                        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain2 = (ViewInfoStore$InfoRecord) simpleArrayMap5.get(childViewHolderInt3);
                        if (viewInfoStore$InfoRecordObtain2 == null) {
                            viewInfoStore$InfoRecordObtain2 = ViewInfoStore$InfoRecord.obtain();
                            simpleArrayMap5.put(childViewHolderInt3, viewInfoStore$InfoRecordObtain2);
                        }
                        viewInfoStore$InfoRecordObtain2.flags |= 2;
                        viewInfoStore$InfoRecordObtain2.preInfo = builder4;
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll(true);
        stopInterceptRequestLayout(false);
        state.mLayoutStep = 2;
    }

    public final void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        state.mItemCount = this.mAdapter.getItemCount();
        state.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null) {
            Adapter adapter = this.mAdapter;
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(adapter.mStateRestorationPolicy);
            if (iOrdinal == 1 ? adapter.getItemCount() > 0 : iOrdinal != 2) {
                Parcelable parcelable = this.mPendingSavedState.mLayoutState;
                if (parcelable != null) {
                    this.mLayout.onRestoreInstanceState(parcelable);
                }
                this.mPendingSavedState = null;
            }
        }
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        state.mStructureChanged = false;
        state.mRunSimpleAnimations = state.mRunSimpleAnimations && this.mItemAnimator != null;
        state.mLayoutStep = 4;
        onExitLayoutOrScroll(true);
        stopInterceptRequestLayout(false);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScrollInternal(i, i2, i3, i4, iArr, 0, null);
    }

    public final void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        ArrayList arrayList = this.mScrollListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.mScrollListeners.get(size)).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        ArrayList arrayList = this.mItemDecorations;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            ((ItemDecoration) arrayList.get(i)).onDrawOver(canvas);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.mItemAnimator == null || arrayList.size() <= 0 || !this.mItemAnimator.isRunning()) ? z : true) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public final void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mBottomGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mLeftGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mRightGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mTopGlow = edgeEffect;
        if (this.mClipToPadding) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() != 2) {
            state.getClass();
            return;
        }
        OverScroller overScroller = this.mViewFlinger.mOverScroller;
        overScroller.getFinalX();
        overScroller.getCurrX();
        state.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0061 A[SYNTHETIC] */
    public final boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.mOnItemTouchListeners;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FastScroller fastScroller = (FastScroller) arrayList.get(i);
            int i2 = fastScroller.mState;
            if (i2 == 1) {
                boolean zIsPointInsideVerticalThumb = fastScroller.isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
                boolean zIsPointInsideHorizontalThumb = fastScroller.isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
                if (motionEvent.getAction() == 0 && (zIsPointInsideVerticalThumb || zIsPointInsideHorizontalThumb)) {
                    if (zIsPointInsideHorizontalThumb) {
                        fastScroller.mDragState = 1;
                        fastScroller.mHorizontalDragX = (int) motionEvent.getX();
                    } else if (zIsPointInsideVerticalThumb) {
                        fastScroller.mDragState = 2;
                        fastScroller.mVerticalDragY = (int) motionEvent.getY();
                    }
                    fastScroller.setState(2);
                    if (action != 3) {
                        this.mInterceptingOnItemTouchListener = fastScroller;
                        return true;
                    }
                }
            } else if (i2 != 2) {
                continue;
            } else if (action != 3) {
                this.mInterceptingOnItemTouchListener = fastScroller;
                return true;
            }
        }
        return false;
    }

    public final void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public final ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i) {
                if (!((ArrayList) this.mChildHelper.options).contains(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    /* JADX WARN: Code duplicated, block: B:118:0x016b  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:138:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        View viewOnFocusSearchFailed;
        int i2;
        byte b;
        boolean z;
        this.mLayout.getClass();
        boolean z2 = true;
        boolean z3 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        State state = this.mState;
        Recycler recycler = this.mRecycler;
        if (z3 && (i == 2 || i == 1)) {
            if (this.mLayout.canScrollVertically()) {
                if (focusFinder.findNextFocus(this, view, i == 2 ? 130 : 33) == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                RecyclerView recyclerView = this.mLayout.mRecyclerView;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                z = focusFinder.findNextFocus(this, view, (recyclerView.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17) == null;
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) != null) {
                    startInterceptRequestLayout();
                    this.mLayout.onFocusSearchFailed(view, i, recycler, state);
                    stopInterceptRequestLayout(false);
                }
                return null;
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i);
            if (viewOnFocusSearchFailed == null) {
            }
            if (viewOnFocusSearchFailed != null) {
                z2 = false;
            } else {
                z2 = false;
            }
            if (z2) {
                return viewOnFocusSearchFailed;
            }
            return super.focusSearch(view, i);
        }
        View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
        if (viewFindNextFocus == null && z3) {
            consumePendingUpdateOperations();
            if (findContainingItemView(view) != null) {
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i, recycler, state);
                stopInterceptRequestLayout(false);
            }
            return null;
        }
        viewOnFocusSearchFailed = viewFindNextFocus;
        if (viewOnFocusSearchFailed == null && !viewOnFocusSearchFailed.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i);
            }
            requestChildOnScreen(viewOnFocusSearchFailed, null);
            return view;
        }
        if (viewOnFocusSearchFailed != null || viewOnFocusSearchFailed == this || viewOnFocusSearchFailed == view) {
            z2 = false;
        } else if (findContainingItemView(viewOnFocusSearchFailed) == null) {
            z2 = false;
        } else if (view != null && findContainingItemView(view) != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            Rect rect = this.mTempRect;
            rect.set(0, 0, width, height);
            int width2 = viewOnFocusSearchFailed.getWidth();
            int height2 = viewOnFocusSearchFailed.getHeight();
            Rect rect2 = this.mTempRect2;
            rect2.set(0, 0, width2, height2);
            offsetDescendantRectToMyCoords(view, rect);
            offsetDescendantRectToMyCoords(viewOnFocusSearchFailed, rect2);
            RecyclerView recyclerView2 = this.mLayout.mRecyclerView;
            WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
            int i3 = recyclerView2.getLayoutDirection() == 1 ? -1 : 1;
            int i4 = rect.left;
            int i5 = rect2.left;
            if ((i4 < i5 || rect.right <= i5) && rect.right < rect2.right) {
                i2 = 1;
            } else {
                int i6 = rect.right;
                int i7 = rect2.right;
                i2 = ((i6 > i7 || i4 >= i7) && i4 > i5) ? -1 : 0;
            }
            int i8 = rect.top;
            int i9 = rect2.top;
            if ((i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom) {
                b = 1;
            } else {
                int i10 = rect.bottom;
                int i11 = rect2.bottom;
                b = ((i10 > i11 || i8 >= i11) && i8 > i9) ? (byte) -1 : (byte) 0;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 17) {
                        if (i != 33) {
                            if (i != 66) {
                                if (i != 130) {
                                    throw new IllegalArgumentException("Invalid direction: " + i + exceptionLabel());
                                }
                                if (b <= 0) {
                                    z2 = false;
                                }
                            } else if (i2 <= 0) {
                                z2 = false;
                            }
                        } else if (b >= 0) {
                            z2 = false;
                        }
                    } else if (i2 >= 0) {
                        z2 = false;
                    }
                } else if (b <= 0 && (b != 0 || i2 * i3 <= 0)) {
                    z2 = false;
                }
            } else if (b >= 0 && (b != 0 || i2 * i3 >= 0)) {
                z2 = false;
            }
        }
        if (z2) {
            return viewOnFocusSearchFailed;
        }
        return super.focusSearch(view, i);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public final int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if ((viewHolder.mFlags & 524) == 0 && viewHolder.isBound()) {
            int i = viewHolder.mPosition;
            ArrayList arrayList = (ArrayList) this.mAdapterHelper.method;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) arrayList.get(i2);
                int i3 = adapterHelper$UpdateOp.cmd;
                if (i3 != 1) {
                    if (i3 == 2) {
                        int i4 = adapterHelper$UpdateOp.positionStart;
                        if (i4 <= i) {
                            int i5 = adapterHelper$UpdateOp.itemCount;
                            if (i4 + i5 <= i) {
                                i -= i5;
                            }
                        } else {
                            continue;
                        }
                    } else if (i3 == 8) {
                        int i6 = adapterHelper$UpdateOp.positionStart;
                        if (i6 == i) {
                            i = adapterHelper$UpdateOp.itemCount;
                        } else {
                            if (i6 < i) {
                                i--;
                            }
                            if (adapterHelper$UpdateOp.itemCount <= i) {
                                i++;
                            }
                        }
                    }
                } else if (adapterHelper$UpdateOp.positionStart <= i) {
                    i += adapterHelper$UpdateOp.itemCount;
                }
            }
            return i;
        }
        return -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return super.getBaseline();
        }
        layoutManager.getClass();
        return -1;
    }

    public final long getChangedHolderKey(ViewHolder viewHolder) {
        return this.mAdapter.mHasStableIds ? viewHolder.mItemId : viewHolder.mPosition;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    public final ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public final Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z = layoutParams.mInsetsDirty;
        Rect rect = layoutParams.mDecorInsets;
        if (!z || (this.mState.mInPreLayout && (layoutParams.mViewHolder.isUpdated() || layoutParams.mViewHolder.isInvalid()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.mItemDecorations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Rect rect2 = this.mTempRect;
            rect2.set(0, 0, 0, 0);
            ((ItemDecoration) arrayList.get(i)).getClass();
            ((LayoutParams) view.getLayoutParams()).mViewHolder.getClass();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent(0);
    }

    public final boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates();
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public final boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().mIsNestedScrollingEnabled;
    }

    public final void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i);
        awakenScrollBars();
    }

    public final void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }
        ArrayList arrayList = this.mRecycler.mCachedViews;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutParams layoutParams = (LayoutParams) ((ViewHolder) arrayList.get(i2)).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
        }
    }

    public final void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i5 = childViewHolderInt.mPosition;
                State state = this.mState;
                if (i5 >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    state.mStructureChanged = true;
                } else if (i5 >= i) {
                    childViewHolderInt.addFlags(8);
                    childViewHolderInt.offsetPosition(-i2, z);
                    childViewHolderInt.mPosition = i - 1;
                    state.mStructureChanged = true;
                }
            }
        }
        Recycler recycler = this.mRecycler;
        ArrayList arrayList = recycler.mCachedViews;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
            if (viewHolder != null) {
                int i6 = viewHolder.mPosition;
                if (i6 >= i3) {
                    viewHolder.offsetPosition(-i2, z);
                } else if (i6 >= i) {
                    viewHolder.addFlags(8);
                    recycler.recycleCachedViewAt(size);
                }
            }
        }
        requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.mIsAttachedToWindow = true;
        }
        this.mPostedAnimatorRunner = false;
        ThreadLocal threadLocal = GapWorker.sGapWorker;
        GapWorker gapWorker = (GapWorker) threadLocal.get();
        this.mGapWorker = gapWorker;
        if (gapWorker == null) {
            GapWorker gapWorker2 = new GapWorker();
            gapWorker2.mRecyclerViews = new ArrayList();
            gapWorker2.mTasks = new ArrayList();
            this.mGapWorker = gapWorker2;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            Display display = getDisplay();
            if (isInEditMode() || display == null) {
                refreshRate = 60.0f;
            } else {
                refreshRate = display.getRefreshRate();
                if (refreshRate < 30.0f) {
                    refreshRate = 60.0f;
                }
            }
            GapWorker gapWorker3 = this.mGapWorker;
            gapWorker3.mFrameIntervalNs = (long) (1.0E9f / refreshRate);
            threadLocal.set(gapWorker3);
        }
        this.mGapWorker.mRecyclerViews.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        LinearSmoothScroller linearSmoothScroller;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        setScrollState(0);
        ViewFlinger viewFlinger = this.mViewFlinger;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.mOverScroller.abortAnimation();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && (linearSmoothScroller = layoutManager.mSmoothScroller) != null) {
            linearSmoothScroller.stop();
        }
        this.mIsAttached = false;
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null) {
            layoutManager2.mIsAttachedToWindow = false;
            layoutManager2.onDetachedFromWindow(this);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
        while (ViewInfoStore$InfoRecord.sPool.acquire() != null) {
        }
        GapWorker gapWorker = this.mGapWorker;
        if (gapWorker != null) {
            gapWorker.mRecyclerViews.remove(this);
            this.mGapWorker = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.mItemDecorations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((ItemDecoration) arrayList.get(i)).onDraw(this);
        }
    }

    public final void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public final void onExitLayoutOrScroll(boolean z) {
        int i;
        AccessibilityManager accessibilityManager;
        int i2 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i2;
        if (i2 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                int i3 = this.mEatenAccessibilityChangeFlags;
                this.mEatenAccessibilityChangeFlags = 0;
                if (i3 != 0 && (accessibilityManager = this.mAccessibilityManager) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i3);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.mPendingAccessibilityImportanceChange;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
                    if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i = viewHolder.mPendingAccessibilityState) != -1) {
                        View view = viewHolder.itemView;
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        view.setImportantForAccessibility(i);
                        viewHolder.mPendingAccessibilityState = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0064  */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.mLayout.canScrollHorizontally() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.mLayout.canScrollVertically()) {
                    f = -axisValue2;
                } else if (this.mLayout.canScrollHorizontally()) {
                    axisValue = axisValue2;
                    f = 0.0f;
                } else {
                    f = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f = 0.0f;
                axisValue = 0.0f;
            }
            if (f != 0.0f || axisValue != 0.0f) {
                int i = (int) (axisValue * this.mScaledHorizontalScrollFactor);
                int i2 = (int) (f * this.mScaledVerticalScrollFactor);
                LayoutManager layoutManager = this.mLayout;
                if (layoutManager == null) {
                    Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                    return false;
                }
                if (!this.mLayoutSuppressed) {
                    int[] iArr = this.mReusableIntPair;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
                    boolean zCanScrollVertically = this.mLayout.canScrollVertically();
                    getScrollingChildHelper().startNestedScroll(zCanScrollVertically ? (zCanScrollHorizontally ? 1 : 0) | 2 : zCanScrollHorizontally ? 1 : 0, 1);
                    if (dispatchNestedPreScroll(zCanScrollHorizontally ? i : 0, zCanScrollVertically ? i2 : 0, 1, this.mReusableIntPair, this.mScrollOffset)) {
                        i -= iArr[0];
                        i2 -= iArr[1];
                    }
                    scrollByInternal(zCanScrollHorizontally ? i : 0, zCanScrollVertically ? i2 : 0, motionEvent, 1);
                    GapWorker gapWorker = this.mGapWorker;
                    if (gapWorker != null && (i != 0 || i2 != 0)) {
                        gapWorker.postFromTraversal(this, i, i2);
                    }
                    stopNestedScroll(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.mLayoutSuppressed) {
            this.mInterceptingOnItemTouchListener = null;
            if (findInterceptingOnItemTouchListener(motionEvent)) {
                resetScroll();
                setScrollState(0);
                return true;
            }
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
                boolean zCanScrollVertically = this.mLayout.canScrollVertically();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = false;
                    }
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = x;
                    this.mInitialTouchX = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = y;
                    this.mInitialTouchY = y;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        stopNestedScroll(1);
                    }
                    int[] iArr = this.mNestedOffsets;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i = zCanScrollHorizontally;
                    if (zCanScrollVertically) {
                        i = (zCanScrollHorizontally ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().startNestedScroll(i, 0);
                } else if (actionMasked == 1) {
                    this.mVelocityTracker.clear();
                    stopNestedScroll(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (iFindPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i2 = x2 - this.mInitialTouchX;
                        int i3 = y2 - this.mInitialTouchY;
                        if (!zCanScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                            z = false;
                        } else {
                            this.mLastTouchX = x2;
                            z = true;
                        }
                        if (zCanScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                            this.mLastTouchY = y2;
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    resetScroll();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.mLastTouchX = x3;
                    this.mInitialTouchX = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.mLastTouchY = y3;
                    this.mInitialTouchY = y3;
                } else if (actionMasked == 6) {
                    onPointerUp(motionEvent);
                }
                if (this.mScrollState == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = TraceCompat.$r8$clinit;
        Trace.beginSection("RV OnLayout");
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean zIsAutoMeasureEnabled = layoutManager.isAutoMeasureEnabled();
        boolean z = false;
        State state = this.mState;
        if (!zIsAutoMeasureEnabled) {
            if (this.mHasFixedSize) {
                this.mLayout.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            if (state.mRunPredictiveAnimations) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                state.mItemCount = adapter.getItemCount();
            } else {
                state.mItemCount = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.mRecyclerView.defaultOnMeasure(i, i2);
            stopInterceptRequestLayout(false);
            state.mInPreLayout = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.mLayout.mRecyclerView.defaultOnMeasure(i, i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z = true;
        }
        this.mLastAutoMeasureSkippedDueToExact = z;
        if (z || this.mAdapter == null) {
            return;
        }
        if (state.mLayoutStep == 1) {
            dispatchLayoutStep1();
        }
        this.mLayout.setMeasureSpecs(i, i2);
        state.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(i, i2);
        if (this.mLayout.shouldMeasureTwice()) {
            this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            state.mIsMeasuring = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i, i2);
        }
        this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
        this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
    }

    public final void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.mSuperState);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.mLayoutState = savedState2.mLayoutState;
            return savedState;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            savedState.mLayoutState = layoutManager.onSaveInstanceState();
            return savedState;
        }
        savedState.mLayoutState = null;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    /* JADX WARN: Code duplicated, block: B:198:0x035f  */
    /* JADX WARN: Code duplicated, block: B:267:0x0432  */
    /* JADX WARN: Code duplicated, block: B:269:0x0436 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:270:0x0438  */
    /* JADX WARN: Code duplicated, block: B:273:0x0467  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f8 A[PHI: r1
      0x01f8: PHI (r1v53 int) = (r1v38 int), (r1v57 int) binds: [B:90:0x01e1, B:94:0x01f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v26 */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zFindInterceptingOnItemTouchListener;
        int i;
        int i2;
        ViewFlinger viewFlinger;
        RecyclerView recyclerView;
        Interpolator interpolator;
        ViewDragHelper.AnonymousClass1 anonymousClass1;
        int minFlingVelocity;
        boolean z;
        LinearSmoothScroller linearSmoothScroller;
        EmojiCompat.Config horizontalHelper;
        int position;
        PointF pointFComputeScrollVectorForPosition;
        int i3;
        int i4;
        boolean z2;
        if (!this.mLayoutSuppressed && !this.mIgnoreMotionEventTillDown) {
            FastScroller fastScroller = this.mInterceptingOnItemTouchListener;
            if (fastScroller == null) {
                zFindInterceptingOnItemTouchListener = motionEvent.getAction() == 0 ? false : findInterceptingOnItemTouchListener(motionEvent);
            } else {
                int i5 = fastScroller.mMargin;
                if (fastScroller.mState != 0) {
                    if (motionEvent.getAction() == 0) {
                        boolean zIsPointInsideVerticalThumb = fastScroller.isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
                        boolean zIsPointInsideHorizontalThumb = fastScroller.isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
                        if (zIsPointInsideVerticalThumb || zIsPointInsideHorizontalThumb) {
                            if (zIsPointInsideHorizontalThumb) {
                                fastScroller.mDragState = 1;
                                fastScroller.mHorizontalDragX = (int) motionEvent.getX();
                            } else if (zIsPointInsideVerticalThumb) {
                                fastScroller.mDragState = 2;
                                fastScroller.mVerticalDragY = (int) motionEvent.getY();
                            }
                            fastScroller.setState(2);
                        }
                    } else if (motionEvent.getAction() == 1 && fastScroller.mState == 2) {
                        fastScroller.mVerticalDragY = 0.0f;
                        fastScroller.mHorizontalDragX = 0.0f;
                        fastScroller.setState(1);
                        fastScroller.mDragState = 0;
                    } else if (motionEvent.getAction() == 2 && fastScroller.mState == 2) {
                        fastScroller.show();
                        if (fastScroller.mDragState == 1) {
                            float x = motionEvent.getX();
                            int[] iArr = fastScroller.mHorizontalRange;
                            iArr[0] = i5;
                            int i6 = fastScroller.mRecyclerViewWidth - i5;
                            iArr[1] = i6;
                            float fMax = Math.max(i5, Math.min(i6, x));
                            if (Math.abs(fastScroller.mHorizontalThumbCenterX - fMax) >= 2.0f) {
                                int iScrollTo = FastScroller.scrollTo(fastScroller.mHorizontalDragX, fMax, iArr, fastScroller.mRecyclerView.computeHorizontalScrollRange(), fastScroller.mRecyclerView.computeHorizontalScrollOffset(), fastScroller.mRecyclerViewWidth);
                                if (iScrollTo != 0) {
                                    fastScroller.mRecyclerView.scrollBy(iScrollTo, 0);
                                }
                                fastScroller.mHorizontalDragX = fMax;
                            }
                        }
                        if (fastScroller.mDragState == 2) {
                            float y = motionEvent.getY();
                            int[] iArr2 = fastScroller.mVerticalRange;
                            iArr2[0] = i5;
                            int i7 = fastScroller.mRecyclerViewHeight - i5;
                            iArr2[1] = i7;
                            float fMax2 = Math.max(i5, Math.min(i7, y));
                            if (Math.abs(fastScroller.mVerticalThumbCenterY - fMax2) >= 2.0f) {
                                int iScrollTo2 = FastScroller.scrollTo(fastScroller.mVerticalDragY, fMax2, iArr2, fastScroller.mRecyclerView.computeVerticalScrollRange(), fastScroller.mRecyclerView.computeVerticalScrollOffset(), fastScroller.mRecyclerViewHeight);
                                if (iScrollTo2 != 0) {
                                    fastScroller.mRecyclerView.scrollBy(0, iScrollTo2);
                                }
                                fastScroller.mVerticalDragY = fMax2;
                            }
                        }
                    }
                }
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.mInterceptingOnItemTouchListener = null;
                }
                zFindInterceptingOnItemTouchListener = true;
            }
            if (zFindInterceptingOnItemTouchListener) {
                resetScroll();
                setScrollState(0);
                return true;
            }
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
                boolean zCanScrollVertically = this.mLayout.canScrollVertically();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                int[] iArr3 = this.mNestedOffsets;
                if (actionMasked == 0) {
                    iArr3[1] = 0;
                    iArr3[0] = 0;
                }
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.offsetLocation(iArr3[0], iArr3[1]);
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        this.mVelocityTracker.addMovement(motionEventObtain);
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        int i8 = this.mMaxFlingVelocity;
                        velocityTracker.computeCurrentVelocity(1000, i8);
                        float f = zCanScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                        float f2 = zCanScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                        if (f == 0.0f && f2 == 0.0f) {
                            i4 = 0;
                        } else {
                            int i9 = (int) f;
                            int i10 = (int) f2;
                            LayoutManager layoutManager2 = this.mLayout;
                            if (layoutManager2 == null) {
                                Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                            } else if (!this.mLayoutSuppressed) {
                                int iCanScrollHorizontally = layoutManager2.canScrollHorizontally();
                                boolean zCanScrollVertically2 = this.mLayout.canScrollVertically();
                                int i11 = this.mMinFlingVelocity;
                                if (iCanScrollHorizontally == 0 || Math.abs(i9) < i11) {
                                    i9 = 0;
                                }
                                if (!zCanScrollVertically2 || Math.abs(i10) < i11) {
                                    i10 = 0;
                                }
                                if (i9 != 0 || i10 != 0) {
                                    float f3 = i9;
                                    float f4 = i10;
                                    if (!dispatchNestedPreFling(f3, f4)) {
                                        boolean z3 = iCanScrollHorizontally != 0 || zCanScrollVertically2;
                                        dispatchNestedFling(f3, f4, z3);
                                        OnFlingListener onFlingListener = this.mOnFlingListener;
                                        if (onFlingListener != null) {
                                            final PagerSnapHelper pagerSnapHelper = (PagerSnapHelper) onFlingListener;
                                            LayoutManager layoutManager3 = pagerSnapHelper.mRecyclerView.getLayoutManager();
                                            if (layoutManager3 == 0 || pagerSnapHelper.mRecyclerView.getAdapter() == null || ((Math.abs(i10) <= (minFlingVelocity = pagerSnapHelper.mRecyclerView.getMinFlingVelocity()) && Math.abs(i9) <= minFlingVelocity) || !((z = layoutManager3 instanceof RecyclerView$SmoothScroller$ScrollVectorProvider)))) {
                                                i2 = 1;
                                                if (z3) {
                                                    if (zCanScrollVertically2) {
                                                        iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
                                                    }
                                                    getScrollingChildHelper().startNestedScroll(iCanScrollHorizontally, i2);
                                                    int i12 = -i8;
                                                    int iMax = Math.max(i12, Math.min(i9, i8));
                                                    int iMax2 = Math.max(i12, Math.min(i10, i8));
                                                    viewFlinger = this.mViewFlinger;
                                                    recyclerView = RecyclerView.this;
                                                    recyclerView.setScrollState(2);
                                                    viewFlinger.mLastFlingY = 0;
                                                    viewFlinger.mLastFlingX = 0;
                                                    interpolator = viewFlinger.mInterpolator;
                                                    anonymousClass1 = sQuinticInterpolator;
                                                    if (interpolator != anonymousClass1) {
                                                        viewFlinger.mInterpolator = anonymousClass1;
                                                        viewFlinger.mOverScroller = new OverScroller(recyclerView.getContext(), anonymousClass1);
                                                    }
                                                    viewFlinger.mOverScroller.fling(0, 0, iMax, iMax2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                                    viewFlinger.postOnAnimation();
                                                }
                                            } else {
                                                if (z) {
                                                    final Context context = pagerSnapHelper.mRecyclerView.getContext();
                                                    linearSmoothScroller = new LinearSmoothScroller(context) { // from class: androidx.recyclerview.widget.PagerSnapHelper.1
                                                        @Override // androidx.recyclerview.widget.LinearSmoothScroller
                                                        public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                                                            return 100.0f / displayMetrics.densityDpi;
                                                        }

                                                        @Override // androidx.recyclerview.widget.LinearSmoothScroller
                                                        public final int calculateTimeForScrolling(int i13) {
                                                            return Math.min(100, super.calculateTimeForScrolling(i13));
                                                        }

                                                        @Override // androidx.recyclerview.widget.LinearSmoothScroller
                                                        public final void onTargetFound(View view, RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action) {
                                                            PagerSnapHelper pagerSnapHelper2 = PagerSnapHelper.this;
                                                            int[] iArrCalculateDistanceToFinalSnap = pagerSnapHelper2.calculateDistanceToFinalSnap(pagerSnapHelper2.mRecyclerView.getLayoutManager(), view);
                                                            int i13 = iArrCalculateDistanceToFinalSnap[0];
                                                            int i14 = iArrCalculateDistanceToFinalSnap[1];
                                                            int iCeil = (int) Math.ceil(((double) calculateTimeForScrolling(Math.max(Math.abs(i13), Math.abs(i14)))) / 0.3356d);
                                                            if (iCeil > 0) {
                                                                recyclerView$SmoothScroller$Action.mDx = i13;
                                                                recyclerView$SmoothScroller$Action.mDy = i14;
                                                                recyclerView$SmoothScroller$Action.mDuration = iCeil;
                                                                recyclerView$SmoothScroller$Action.mInterpolator = this.mDecelerateInterpolator;
                                                                recyclerView$SmoothScroller$Action.mChanged = true;
                                                            }
                                                        }
                                                    };
                                                } else {
                                                    linearSmoothScroller = null;
                                                }
                                                if (linearSmoothScroller == null) {
                                                    i2 = 1;
                                                } else {
                                                    RecyclerView recyclerView2 = layoutManager3.mRecyclerView;
                                                    Adapter adapter = recyclerView2 != null ? recyclerView2.getAdapter() : null;
                                                    int itemCount = adapter != null ? adapter.getItemCount() : 0;
                                                    if (itemCount != 0) {
                                                        if (layoutManager3.canScrollVertically()) {
                                                            horizontalHelper = pagerSnapHelper.getVerticalHelper(layoutManager3);
                                                        } else {
                                                            horizontalHelper = layoutManager3.canScrollHorizontally() ? pagerSnapHelper.getHorizontalHelper(layoutManager3) : null;
                                                        }
                                                        if (horizontalHelper == null) {
                                                            i2 = 1;
                                                        } else {
                                                            int childCount = layoutManager3.getChildCount();
                                                            i2 = 1;
                                                            int i13 = Integer.MIN_VALUE;
                                                            int i14 = 0;
                                                            View view = null;
                                                            int i15 = Integer.MAX_VALUE;
                                                            View view2 = null;
                                                            while (i14 < childCount) {
                                                                int i16 = childCount;
                                                                View childAt = layoutManager3.getChildAt(i14);
                                                                if (childAt == null) {
                                                                    i3 = i14;
                                                                } else {
                                                                    i3 = i14;
                                                                    int iDistanceToCenter = PagerSnapHelper.distanceToCenter(childAt, horizontalHelper);
                                                                    if (iDistanceToCenter <= 0 && iDistanceToCenter > i13) {
                                                                        view = childAt;
                                                                        i13 = iDistanceToCenter;
                                                                    }
                                                                    if (iDistanceToCenter >= 0 && iDistanceToCenter < i15) {
                                                                        view2 = childAt;
                                                                        i15 = iDistanceToCenter;
                                                                    }
                                                                }
                                                                i14 = i3 + 1;
                                                                childCount = i16;
                                                            }
                                                            boolean z4 = !layoutManager3.canScrollHorizontally() ? i10 <= 0 : i9 <= 0;
                                                            if (z4 && view2 != null) {
                                                                position = LayoutManager.getPosition(view2);
                                                            } else if (z4 || view == null) {
                                                                if (z4) {
                                                                    view2 = view;
                                                                }
                                                                if (view2 != null) {
                                                                    int position2 = LayoutManager.getPosition(view2);
                                                                    RecyclerView recyclerView3 = layoutManager3.mRecyclerView;
                                                                    Adapter adapter2 = recyclerView3 != null ? recyclerView3.getAdapter() : null;
                                                                    position = ((z && (pointFComputeScrollVectorForPosition = ((RecyclerView$SmoothScroller$ScrollVectorProvider) layoutManager3).computeScrollVectorForPosition((adapter2 != null ? adapter2.getItemCount() : 0) + (-1))) != null && ((pointFComputeScrollVectorForPosition.x > r5 ? 1 : (pointFComputeScrollVectorForPosition.x == r5 ? 0 : -1)) < 0 || (pointFComputeScrollVectorForPosition.y > 0 ? 1 : (pointFComputeScrollVectorForPosition.y == 0 ? 0 : -1)) < 0)) == z4 ? -1 : 1) + position2;
                                                                    if (position < 0 || position >= itemCount) {
                                                                    }
                                                                }
                                                            } else {
                                                                position = LayoutManager.getPosition(view);
                                                            }
                                                        }
                                                        position = -1;
                                                    } else {
                                                        i2 = 1;
                                                        position = -1;
                                                    }
                                                    if (position != -1) {
                                                        linearSmoothScroller.mTargetPosition = position;
                                                        layoutManager3.startSmoothScroll(linearSmoothScroller);
                                                    }
                                                }
                                                if (z3) {
                                                    if (zCanScrollVertically2) {
                                                        iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
                                                    }
                                                    getScrollingChildHelper().startNestedScroll(iCanScrollHorizontally, i2);
                                                    int i17 = -i8;
                                                    int iMax3 = Math.max(i17, Math.min(i9, i8));
                                                    int iMax4 = Math.max(i17, Math.min(i10, i8));
                                                    viewFlinger = this.mViewFlinger;
                                                    recyclerView = RecyclerView.this;
                                                    recyclerView.setScrollState(2);
                                                    viewFlinger.mLastFlingY = 0;
                                                    viewFlinger.mLastFlingX = 0;
                                                    interpolator = viewFlinger.mInterpolator;
                                                    anonymousClass1 = sQuinticInterpolator;
                                                    if (interpolator != anonymousClass1) {
                                                        viewFlinger.mInterpolator = anonymousClass1;
                                                        viewFlinger.mOverScroller = new OverScroller(recyclerView.getContext(), anonymousClass1);
                                                    }
                                                    viewFlinger.mOverScroller.fling(0, 0, iMax3, iMax4, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                                    viewFlinger.postOnAnimation();
                                                }
                                            }
                                        } else {
                                            i2 = 1;
                                            if (z3) {
                                                if (zCanScrollVertically2) {
                                                    iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
                                                }
                                                getScrollingChildHelper().startNestedScroll(iCanScrollHorizontally, i2);
                                                int i18 = -i8;
                                                int iMax5 = Math.max(i18, Math.min(i9, i8));
                                                int iMax6 = Math.max(i18, Math.min(i10, i8));
                                                viewFlinger = this.mViewFlinger;
                                                recyclerView = RecyclerView.this;
                                                recyclerView.setScrollState(2);
                                                viewFlinger.mLastFlingY = 0;
                                                viewFlinger.mLastFlingX = 0;
                                                interpolator = viewFlinger.mInterpolator;
                                                anonymousClass1 = sQuinticInterpolator;
                                                if (interpolator != anonymousClass1) {
                                                    viewFlinger.mInterpolator = anonymousClass1;
                                                    viewFlinger.mOverScroller = new OverScroller(recyclerView.getContext(), anonymousClass1);
                                                }
                                                viewFlinger.mOverScroller.fling(0, 0, iMax5, iMax6, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                                viewFlinger.postOnAnimation();
                                            }
                                        }
                                        resetScroll();
                                    }
                                }
                            }
                            i4 = 0;
                        }
                        setScrollState(i4);
                        resetScroll();
                    } else if (actionMasked == 2) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                        if (iFindPointerIndex < 0) {
                            Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                            return false;
                        }
                        int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                        int iMax7 = this.mLastTouchX - x2;
                        int iMax8 = this.mLastTouchY - y2;
                        if (this.mScrollState != 1) {
                            if (zCanScrollHorizontally) {
                                iMax7 = iMax7 > 0 ? Math.max(0, iMax7 - this.mTouchSlop) : Math.min(0, iMax7 + this.mTouchSlop);
                                if (iMax7 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            if (zCanScrollVertically) {
                                iMax8 = iMax8 > 0 ? Math.max(0, iMax8 - this.mTouchSlop) : Math.min(0, iMax8 + this.mTouchSlop);
                                if (iMax8 != 0) {
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        int i19 = iMax7;
                        int i20 = iMax8;
                        if (this.mScrollState == 1) {
                            int[] iArr4 = this.mReusableIntPair;
                            iArr4[0] = 0;
                            iArr4[1] = 0;
                            boolean zDispatchNestedPreScroll = dispatchNestedPreScroll(zCanScrollHorizontally ? i19 : 0, zCanScrollVertically ? i20 : 0, 0, iArr4, this.mScrollOffset);
                            int[] iArr5 = this.mScrollOffset;
                            if (zDispatchNestedPreScroll) {
                                i19 -= iArr4[0];
                                i20 -= iArr4[1];
                                iArr3[0] = iArr3[0] + iArr5[0];
                                iArr3[1] = iArr3[1] + iArr5[1];
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            int i21 = i20;
                            this.mLastTouchX = x2 - iArr5[0];
                            this.mLastTouchY = y2 - iArr5[1];
                            if (scrollByInternal(zCanScrollHorizontally ? i19 : 0, zCanScrollVertically ? i21 : 0, motionEvent, 0)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            GapWorker gapWorker = this.mGapWorker;
                            if (gapWorker != null && (i19 != 0 || i21 != 0)) {
                                gapWorker.postFromTraversal(this, i19, i21);
                            }
                        }
                    } else if (actionMasked == 3) {
                        resetScroll();
                        setScrollState(0);
                    } else if (actionMasked == 5) {
                        this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                        int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                        this.mLastTouchX = x3;
                        this.mInitialTouchX = x3;
                        int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                        this.mLastTouchY = y3;
                        this.mInitialTouchY = y3;
                    } else if (actionMasked == 6) {
                        onPointerUp(motionEvent);
                    }
                    motionEventObtain.recycle();
                    return true;
                }
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x4 = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x4;
                this.mInitialTouchX = x4;
                int y4 = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y4;
                this.mInitialTouchY = y4;
                if (zCanScrollVertically) {
                    i = zCanScrollHorizontally;
                    i = (zCanScrollHorizontally ? 1 : 0) | 2;
                }
                i = zCanScrollHorizontally;
                getScrollingChildHelper().startNestedScroll(i, 0);
                this.mVelocityTracker.addMovement(motionEventObtain);
                motionEventObtain.recycle();
                return true;
            }
        }
        return false;
    }

    public final void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        postOnAnimation(this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    public final void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, NavOptions.Builder builder) {
        viewHolder.mFlags &= -8193;
        boolean z = this.mState.mTrackOldChangeHolders;
        RequestService requestService = this.mViewInfoStore;
        if (z && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            ((LongSparseArray) requestService.hardwareBitmapService).put(getChangedHolderKey(viewHolder), viewHolder);
        }
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) requestService.systemCallbacks;
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = (ViewInfoStore$InfoRecord) simpleArrayMap.get(viewHolder);
        if (viewInfoStore$InfoRecordObtain == null) {
            viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
            simpleArrayMap.put(viewHolder, viewInfoStore$InfoRecordObtain);
        }
        viewInfoStore$InfoRecordObtain.preInfo = builder;
        viewInfoStore$InfoRecordObtain.flags |= 4;
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.mFlags &= -257;
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        getChildViewHolderInt(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        LinearSmoothScroller linearSmoothScroller = this.mLayout.mSmoothScroller;
        if ((linearSmoothScroller == null || !linearSmoothScroller.mRunning) && !isComputingLayout() && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public final void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.mTempRect;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect2 = layoutParams2.mDecorInsets;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.mOnItemTouchListeners;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((FastScroller) arrayList.get(i)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public final void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i = 0;
            }
            if (!zCanScrollVertically) {
                i2 = 0;
            }
            scrollByInternal(i, i2, null, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc A[DONT_INVERT, PHI: r7
      0x00fc: PHI (r7v10 boolean) = (r7v8 boolean), (r7v11 boolean) binds: [B:34:0x00e3, B:32:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:41:0x0106  */
    public final boolean scrollByInternal(int i, int i2, MotionEvent motionEvent, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        consumePendingUpdateOperations();
        Adapter adapter = this.mAdapter;
        int[] iArr = this.mReusableIntPair;
        if (adapter != null) {
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i, i2, iArr);
            i4 = iArr[0];
            i5 = iArr[1];
            i6 = i - i4;
            i7 = i2 - i5;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        dispatchNestedScroll(i4, i5, i6, i7, this.mScrollOffset, i3, iArr);
        int i8 = iArr[0];
        int i9 = i6 - i8;
        int i10 = iArr[1];
        int i11 = i7 - i10;
        boolean z3 = (i8 == 0 && i10 == 0) ? false : true;
        int i12 = this.mLastTouchX;
        int[] iArr2 = this.mScrollOffset;
        int i13 = iArr2[0];
        this.mLastTouchX = i12 - i13;
        int i14 = this.mLastTouchY;
        int i15 = iArr2[1];
        this.mLastTouchY = i14 - i15;
        int[] iArr3 = this.mNestedOffsets;
        iArr3[0] = iArr3[0] + i13;
        iArr3[1] = iArr3[1] + i15;
        if (getOverScrollMode() != 2) {
            if (motionEvent == null || (motionEvent.getSource() & 8194) == 8194) {
                z = true;
            } else {
                float x = motionEvent.getX();
                float f = i9;
                float y = motionEvent.getY();
                float f2 = i11;
                if (f < 0.0f) {
                    ensureLeftGlow();
                    z = true;
                    EdgeEffectCompat.Api21Impl.onPull(this.mLeftGlow, (-f) / getWidth(), 1.0f - (y / getHeight()));
                } else {
                    z = true;
                    if (f > 0.0f) {
                        ensureRightGlow();
                        EdgeEffectCompat.Api21Impl.onPull(this.mRightGlow, f / getWidth(), y / getHeight());
                    } else {
                        z2 = false;
                    }
                    if (f2 < 0.0f) {
                        ensureTopGlow();
                        EdgeEffectCompat.Api21Impl.onPull(this.mTopGlow, (-f2) / getHeight(), x / getWidth());
                    } else if (f2 > 0.0f) {
                        ensureBottomGlow();
                        EdgeEffectCompat.Api21Impl.onPull(this.mBottomGlow, f2 / getHeight(), 1.0f - (x / getWidth()));
                    } else if (z2 || f != 0.0f || f2 != 0.0f) {
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        postInvalidateOnAnimation();
                    }
                    z2 = z;
                    if (z2) {
                        WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        postInvalidateOnAnimation();
                    } else {
                        WeakHashMap weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                        postInvalidateOnAnimation();
                    }
                }
                z2 = z;
                if (f2 < 0.0f) {
                    ensureTopGlow();
                    EdgeEffectCompat.Api21Impl.onPull(this.mTopGlow, (-f2) / getHeight(), x / getWidth());
                } else if (f2 > 0.0f) {
                    ensureBottomGlow();
                    EdgeEffectCompat.Api21Impl.onPull(this.mBottomGlow, f2 / getHeight(), 1.0f - (x / getWidth()));
                } else if (z2) {
                    WeakHashMap weakHashMap4 = ViewCompat.sViewPropertyAnimatorMap;
                    postInvalidateOnAnimation();
                } else {
                    WeakHashMap weakHashMap5 = ViewCompat.sViewPropertyAnimatorMap;
                    postInvalidateOnAnimation();
                }
                z2 = z;
                if (z2) {
                    WeakHashMap weakHashMap6 = ViewCompat.sViewPropertyAnimatorMap;
                    postInvalidateOnAnimation();
                } else {
                    WeakHashMap weakHashMap7 = ViewCompat.sViewPropertyAnimatorMap;
                    postInvalidateOnAnimation();
                }
            }
            considerReleasingGlowsOnScroll(i, i2);
        } else {
            z = true;
        }
        if (i4 != 0 || i5 != 0) {
            dispatchOnScrolled(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z3 && i4 == 0 && i5 == 0) {
            return false;
        }
        return z;
    }

    public final void scrollStep(int i, int i2, int[] iArr) {
        ViewHolder viewHolder;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        int i3 = TraceCompat.$r8$clinit;
        Trace.beginSection("RV Scroll");
        State state = this.mState;
        fillRemainingScrollValues(state);
        Recycler recycler = this.mRecycler;
        int iScrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, recycler, state) : 0;
        int iScrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, recycler, state) : 0;
        Trace.endSection();
        ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
        int childCount = imageLoader$Builder.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = imageLoader$Builder.getChildAt(i4);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder != null && (viewHolder = childViewHolder.mShadowingHolder) != null) {
                View view = viewHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        onExitLayoutOrScroll(true);
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public final void scrollToPosition(int i) {
        LinearSmoothScroller linearSmoothScroller;
        if (this.mLayoutSuppressed) {
            return;
        }
        setScrollState(0);
        ViewFlinger viewFlinger = this.mViewFlinger;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.mOverScroller.abortAnimation();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && (linearSmoothScroller = layoutManager.mSmoothScroller) != null) {
            linearSmoothScroller.stop();
        }
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager2.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        Adapter adapter2 = this.mAdapter;
        EmptyNetworkObserver emptyNetworkObserver = this.mObserver;
        if (adapter2 != null) {
            adapter2.mObservable.unregisterObserver(emptyNetworkObserver);
            this.mAdapter.getClass();
        }
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        Recycler recycler = this.mRecycler;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(recycler);
            this.mLayout.removeAndRecycleScrapInt(recycler);
        }
        recycler.mAttachedScrap.clear();
        recycler.recycleAndClearCachedViews();
        Request request = this.mAdapterHelper;
        request.recycleUpdateOpsAndClearList((ArrayList) request.method);
        request.recycleUpdateOpsAndClearList((ArrayList) request.headers);
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.mObservable.registerObserver(emptyNetworkObserver);
        }
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null) {
            layoutManager2.onAdapterChanged();
        }
        Adapter adapter4 = this.mAdapter;
        recycler.mAttachedScrap.clear();
        recycler.recycleAndClearCachedViews();
        RecycledViewPool recycledViewPool = recycler.getRecycledViewPool();
        if (adapter3 != null) {
            recycledViewPool.mAttachCount--;
        }
        if (recycledViewPool.mAttachCount == 0) {
            SparseArray sparseArray = recycledViewPool.mScrap;
            for (int i = 0; i < sparseArray.size(); i++) {
                ((RecycledViewPool.ScrapData) sparseArray.valueAt(i)).mScrapHeap.clear();
            }
        }
        if (adapter4 != null) {
            recycledViewPool.mAttachCount++;
        }
        this.mState.mStructureChanged = true;
        this.mDispatchItemsChangedEvent |= false;
        this.mDataSetHasChangedAfterLayout = true;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        Recycler recycler2 = this.mRecycler;
        ArrayList arrayList = recycler2.mCachedViews;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i3);
            if (viewHolder != null) {
                viewHolder.addFlags(6);
                viewHolder.addFlags(1024);
            }
        }
        Adapter adapter5 = RecyclerView.this.mAdapter;
        if (adapter5 == null || !adapter5.mHasStableIds) {
            recycler2.recycleAndClearCachedViews();
        }
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            this.mBottomGlow = null;
            this.mTopGlow = null;
            this.mRightGlow = null;
            this.mLeftGlow = null;
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        edgeEffectFactory.getClass();
        this.mEdgeEffectFactory = edgeEffectFactory;
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.mListener = null;
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.mListener = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i) {
        Recycler recycler = this.mRecycler;
        recycler.mRequestedCacheMax = i;
        recycler.updateViewCacheSize();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        LinearSmoothScroller linearSmoothScroller;
        if (layoutManager == this.mLayout) {
            return;
        }
        setScrollState(0);
        ViewFlinger viewFlinger = this.mViewFlinger;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.mOverScroller.abortAnimation();
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null && (linearSmoothScroller = layoutManager2.mSmoothScroller) != null) {
            linearSmoothScroller.stop();
        }
        LayoutManager layoutManager3 = this.mLayout;
        Recycler recycler = this.mRecycler;
        if (layoutManager3 != null) {
            ItemAnimator itemAnimator = this.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(recycler);
            this.mLayout.removeAndRecycleScrapInt(recycler);
            recycler.mAttachedScrap.clear();
            recycler.recycleAndClearCachedViews();
            if (this.mIsAttached) {
                LayoutManager layoutManager4 = this.mLayout;
                layoutManager4.mIsAttachedToWindow = false;
                layoutManager4.onDetachedFromWindow(this);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            recycler.mAttachedScrap.clear();
            recycler.recycleAndClearCachedViews();
        }
        ImageLoader$Builder imageLoader$Builder = this.mChildHelper;
        RecyclerView recyclerView = RecyclerView.this;
        ((HeadersReader) imageLoader$Builder.defaults).reset();
        ArrayList arrayList = (ArrayList) imageLoader$Builder.options;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ViewHolder childViewHolderInt = getChildViewHolderInt((View) arrayList.get(size));
            if (childViewHolderInt != null) {
                int i = childViewHolderInt.mWasImportantForAccessibilityBeforeHidden;
                if (recyclerView.isComputingLayout()) {
                    childViewHolderInt.mPendingAccessibilityState = i;
                    recyclerView.mPendingAccessibilityImportanceChange.add(childViewHolderInt);
                } else {
                    View view = childViewHolderInt.itemView;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    view.setImportantForAccessibility(i);
                }
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = 0;
            }
            arrayList.remove(size);
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            getChildViewHolderInt(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.mLayout = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
            }
            layoutManager.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.mIsAttachedToWindow = true;
            }
        }
        recycler.updateViewCacheSize();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.mIsNestedScrollingEnabled) {
            ViewGroup viewGroup = scrollingChildHelper.mView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.stopNestedScroll(viewGroup);
        }
        scrollingChildHelper.mIsNestedScrollingEnabled = z;
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        Recycler recycler = this.mRecycler;
        RecycledViewPool recycledViewPool2 = recycler.mRecyclerPool;
        if (recycledViewPool2 != null) {
            recycledViewPool2.mAttachCount--;
        }
        recycler.mRecyclerPool = recycledViewPool;
        if (recycledViewPool == null || RecyclerView.this.getAdapter() == null) {
            return;
        }
        recycler.mRecyclerPool.mAttachCount++;
    }

    public void setScrollState(int i) {
        LinearSmoothScroller linearSmoothScroller;
        if (i == this.mScrollState) {
            return;
        }
        this.mScrollState = i;
        if (i != 2) {
            ViewFlinger viewFlinger = this.mViewFlinger;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.mOverScroller.abortAnimation();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null && (linearSmoothScroller = layoutManager.mSmoothScroller) != null) {
                linearSmoothScroller.stop();
            }
        }
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null) {
            layoutManager2.onScrollStateChanged(i);
        }
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        ArrayList arrayList = this.mScrollListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.mScrollListeners.get(size)).onScrollStateChanged(this, i);
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.getClass();
    }

    public final void smoothScrollBy$1(int i, int i2, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!layoutManager.canScrollHorizontally()) {
            i = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (z) {
            int i3 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i3 |= 2;
            }
            getScrollingChildHelper().startNestedScroll(i3, 1);
        }
        this.mViewFlinger.smoothScrollBy(i, i2, Integer.MIN_VALUE, null);
    }

    public final void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i, 0);
    }

    public final void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        LinearSmoothScroller linearSmoothScroller;
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            setScrollState(0);
            ViewFlinger viewFlinger = this.mViewFlinger;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.mOverScroller.abortAnimation();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null || (linearSmoothScroller = layoutManager.mSmoothScroller) == null) {
                return;
            }
            linearSmoothScroller.stop();
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        float legacyScrollFactor;
        TypedArray typedArray;
        int i2;
        Constructor constructor;
        super(context, attributeSet, i);
        this.mObserver = new EmptyNetworkObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new RequestService(24);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        Object[] objArr = null;
        defaultItemAnimator.mListener = null;
        defaultItemAnimator.mFinishedListeners = new ArrayList();
        defaultItemAnimator.mAddDuration = 120L;
        defaultItemAnimator.mRemoveDuration = 120L;
        defaultItemAnimator.mMoveDuration = 250L;
        defaultItemAnimator.mChangeDuration = 250L;
        defaultItemAnimator.mSupportsChangeAnimations = true;
        defaultItemAnimator.mPendingRemovals = new ArrayList();
        defaultItemAnimator.mPendingAdditions = new ArrayList();
        defaultItemAnimator.mPendingMoves = new ArrayList();
        defaultItemAnimator.mPendingChanges = new ArrayList();
        defaultItemAnimator.mAdditionsList = new ArrayList();
        defaultItemAnimator.mMovesList = new ArrayList();
        defaultItemAnimator.mChangesList = new ArrayList();
        defaultItemAnimator.mAddAnimations = new ArrayList();
        defaultItemAnimator.mMoveAnimations = new ArrayList();
        defaultItemAnimator.mRemoveAnimations = new ArrayList();
        defaultItemAnimator.mChangeAnimations = new ArrayList();
        this.mItemAnimator = defaultItemAnimator;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = new CircularArray(3);
        State state = new State();
        state.mTargetPosition = -1;
        state.mPreviousLayoutItemCount = 0;
        state.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        state.mLayoutStep = 1;
        state.mItemCount = 0;
        state.mStructureChanged = false;
        state.mInPreLayout = false;
        state.mTrackOldChangeHolders = false;
        state.mIsMeasuring = false;
        state.mRunSimpleAnimations = false;
        state.mRunPredictiveAnimations = false;
        this.mState = state;
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        this.mItemAnimatorListener = anonymousClass5;
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new zzg(16, this);
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new AnonymousClass4();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
            legacyScrollFactor = MenuItemCompat$Api26Impl.getScaledHorizontalScrollFactor(viewConfiguration);
        } else {
            legacyScrollFactor = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
        }
        this.mScaledHorizontalScrollFactor = legacyScrollFactor;
        this.mScaledVerticalScrollFactor = i3 >= 26 ? MenuItemCompat$Api26Impl.getScaledVerticalScrollFactor(viewConfiguration) : ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.mListener = anonymousClass5;
        this.mAdapterHelper = new Request(new AnonymousClass4());
        this.mChildHelper = new ImageLoader$Builder(new AnonymousClass5());
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if ((i3 >= 26 ? ViewCompat.Api26Impl.getImportantForAutofill(this) : 0) == 0 && i3 >= 26) {
            ViewCompat.Api26Impl.setImportantForAutofill(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = R$styleable.RecyclerView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
            }
            Resources resources = getContext().getResources();
            typedArray = typedArrayObtainStyledAttributes;
            i2 = 4;
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.koala.clash.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.koala.clash.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.koala.clash.R.dimen.fastscroll_margin));
        } else {
            typedArray = typedArrayObtainStyledAttributes;
            i2 = 4;
        }
        typedArray.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(LayoutManager.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        Object[] objArr2 = new Object[i2];
                        objArr2[0] = context;
                        objArr2[r11] = attributeSet;
                        objArr2[2] = Integer.valueOf(i);
                        objArr2[3] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                }
            }
        }
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i, 0);
        boolean z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z);
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, i3, iArr, iArr2);
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public final void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final Rect mDecorInsets;
        public boolean mInsetsDirty;
        public boolean mPendingInvalidate;
        public ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class ItemDecoration {
        public void onDraw(RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas) {
        }
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class OnScrollListener {
        public abstract void onScrolled(RecyclerView recyclerView, int i, int i2);

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }
    }
}
