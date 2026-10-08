package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R$styleable;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    public final ArrayList disappearingFragmentChildren;
    public boolean drawDisappearingViewsFirst;
    public final ArrayList transitioningFragmentViews;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    public final void addDisappearingFragmentView(View view) {
        if (this.transitioningFragmentViews.contains(view)) {
            this.disappearingFragmentChildren.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat;
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.toWindowInsetsCompat(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.applyWindowInsetsListener;
        if (onApplyWindowInsetsListener != null) {
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(null, onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            WindowInsets windowInsets2 = windowInsetsCompat2.toWindowInsets();
            if (windowInsets2 != null) {
                WindowInsets windowInsetsOnApplyWindowInsets = ViewCompat.Api20Impl.onApplyWindowInsets(this, windowInsets2);
                if (!windowInsetsOnApplyWindowInsets.equals(windowInsets2)) {
                    windowInsetsCompat2 = WindowInsetsCompat.toWindowInsetsCompat(this, windowInsetsOnApplyWindowInsets);
                }
            }
            windowInsetsCompat = windowInsetsCompat2;
        }
        if (!windowInsetsCompat.mImpl.isConsumed()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewCompat.dispatchApplyWindowInsets(getChildAt(i), windowInsetsCompat);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.drawDisappearingViewsFirst) {
            ArrayList arrayList = this.disappearingFragmentChildren;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        if (this.drawDisappearingViewsFirst) {
            ArrayList arrayList = this.disappearingFragmentChildren;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        this.transitioningFragmentViews.remove(view);
        if (this.disappearingFragmentChildren.remove(view)) {
            this.drawDisappearingViewsFirst = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        AppCompatActivity appCompatActivity;
        Fragment fragment;
        FragmentManagerImpl childFragmentManager;
        View view = this;
        while (true) {
            appCompatActivity = null;
            if (view == null) {
                fragment = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            fragment = tag instanceof Fragment ? (Fragment) tag : null;
            if (fragment != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (fragment == null) {
            for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof AppCompatActivity) {
                    appCompatActivity = (AppCompatActivity) context;
                    break;
                }
            }
            if (appCompatActivity == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            childFragmentManager = ((FragmentActivity$HostCallbacks) appCompatActivity.mFragments.entries).mFragmentManager;
        } else {
            if (fragment.mHost == null || !fragment.mAdded) {
                throw new IllegalStateException("The Fragment " + fragment + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            childFragmentManager = fragment.getChildFragmentManager();
        }
        return (F) childFragmentManager.findFragmentById(getId());
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            }
            addDisappearingFragmentView(getChildAt(childCount));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        addDisappearingFragmentView(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            addDisappearingFragmentView(getChildAt(i4));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            addDisappearingFragmentView(getChildAt(i4));
        }
        super.removeViewsInLayout(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.drawDisappearingViewsFirst = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.applyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            this.transitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManagerImpl fragmentManagerImpl) {
        View view;
        super(context, attributeSet);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String classAttribute = attributeSet.getClassAttribute();
        int i = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(0) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentFindFragmentById = fragmentManagerImpl.findFragmentById(id);
        if (classAttribute != null && fragmentFindFragmentById == null) {
            if (id == -1) {
                throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            FragmentManager$3 fragmentFactory = fragmentManagerImpl.getFragmentFactory();
            context.getClassLoader();
            Fragment fragmentInstantiate = fragmentFactory.instantiate(classAttribute);
            fragmentInstantiate.mCalled = true;
            FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks = fragmentInstantiate.mHost;
            if ((fragmentActivity$HostCallbacks == null ? null : fragmentActivity$HostCallbacks.mActivity) != null) {
                fragmentInstantiate.mCalled = true;
            }
            BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
            backStackRecord.mReorderingAllowed = true;
            fragmentInstantiate.mContainer = this;
            backStackRecord.doAddOp(getId(), fragmentInstantiate, string, 1);
            if (!backStackRecord.mAddToBackStack) {
                FragmentManagerImpl fragmentManagerImpl2 = backStackRecord.mManager;
                if (fragmentManagerImpl2.mHost != null && !fragmentManagerImpl2.mDestroyed) {
                    fragmentManagerImpl2.ensureExecReady(true);
                    backStackRecord.generateOps(fragmentManagerImpl2.mTmpRecords, fragmentManagerImpl2.mTmpIsPop);
                    fragmentManagerImpl2.mExecutingActions = true;
                    try {
                        fragmentManagerImpl2.removeRedundantOperationsAndExecute(fragmentManagerImpl2.mTmpRecords, fragmentManagerImpl2.mTmpIsPop);
                        fragmentManagerImpl2.cleanupExec();
                        fragmentManagerImpl2.updateOnBackPressedCallbackEnabled();
                        fragmentManagerImpl2.doPendingDeferredStart();
                        ((HashMap) fragmentManagerImpl2.mFragmentStore.readyAsyncCalls).values().removeAll(Collections.singleton(null));
                    } catch (Throwable th) {
                        fragmentManagerImpl2.cleanupExec();
                        throw th;
                    }
                }
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        ArrayList activeFragmentStateManagers = fragmentManagerImpl.mFragmentStore.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
            Fragment fragment = fragmentStateManager.mFragment;
            if (fragment.mContainerId == getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = this;
                fragmentStateManager.addViewToContainer();
            }
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }
}
