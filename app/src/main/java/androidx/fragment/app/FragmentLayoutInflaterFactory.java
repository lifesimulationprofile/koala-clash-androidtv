package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Recomposer;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentReuseViolation;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    public final FragmentManagerImpl mFragmentManager;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentLayoutInflaterFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        public final /* synthetic */ int $r8$classId = 1;
        public final /* synthetic */ Object this$0;
        public final /* synthetic */ Object val$fragmentStateManager;

        public AnonymousClass1(FragmentLayoutInflaterFactory fragmentLayoutInflaterFactory, FragmentStateManager fragmentStateManager) {
            this.this$0 = fragmentLayoutInflaterFactory;
            this.val$fragmentStateManager = fragmentStateManager;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            switch (this.$r8$classId) {
                case 0:
                    FragmentStateManager fragmentStateManager = (FragmentStateManager) this.val$fragmentStateManager;
                    Fragment fragment = fragmentStateManager.mFragment;
                    fragmentStateManager.moveToExpectedState();
                    DefaultSpecialEffectsController.getOrCreateController((ViewGroup) fragment.mView.getParent(), ((FragmentLayoutInflaterFactory) this.this$0).mFragmentManager.getSpecialEffectsControllerFactory()).forceCompleteAllOperations();
                    break;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            switch (this.$r8$classId) {
                case 0:
                    break;
                default:
                    ((View) this.val$fragmentStateManager).removeOnAttachStateChangeListener(this);
                    ((Recomposer) this.this$0).cancel();
                    break;
            }
        }

        public AnonymousClass1(View view, Recomposer recomposer) {
            this.val$fragmentStateManager = view;
            this.this$0 = recomposer;
        }

        private final void onViewAttachedToWindow$androidx$compose$ui$platform$WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1(View view) {
        }

        private final void onViewDetachedFromWindow$androidx$fragment$app$FragmentLayoutInflaterFactory$1(View view) {
        }
    }

    public FragmentLayoutInflaterFactory(FragmentManagerImpl fragmentManagerImpl) {
        this.mFragmentManager = fragmentManagerImpl;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        Fragment fragment;
        FragmentStateManager fragmentStateManagerCreateOrGetFragmentStateManager;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        FragmentManagerImpl fragmentManagerImpl = this.mFragmentManager;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, fragmentManagerImpl);
        }
        Fragment fragment2 = null;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = Fragment.class.isAssignableFrom(FragmentManager$3.loadClass(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment fragmentFindFragmentById = resourceId != -1 ? fragmentManagerImpl.findFragmentById(resourceId) : null;
                    if (fragmentFindFragmentById == null && string != null) {
                        Dispatcher dispatcher = fragmentManagerImpl.mFragmentStore;
                        ArrayList arrayList = (ArrayList) dispatcher.executorServiceOrNull;
                        int size = arrayList.size() - 1;
                        while (true) {
                            if (size < 0) {
                                fragment = fragment2;
                                Iterator it = ((HashMap) dispatcher.readyAsyncCalls).values().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        fragmentFindFragmentById = fragment;
                                        break;
                                    }
                                    FragmentStateManager fragmentStateManager = (FragmentStateManager) it.next();
                                    if (fragmentStateManager != null) {
                                        fragmentFindFragmentById = fragmentStateManager.mFragment;
                                        if (string.equals(fragmentFindFragmentById.mTag)) {
                                            break;
                                        }
                                    }
                                }
                            } else {
                                Fragment fragment3 = (Fragment) arrayList.get(size);
                                fragment = fragment2;
                                if (fragment3 != null && string.equals(fragment3.mTag)) {
                                    fragmentFindFragmentById = fragment3;
                                    break;
                                }
                                size--;
                                fragment2 = fragment;
                            }
                        }
                    } else {
                        fragment = null;
                    }
                    if (fragmentFindFragmentById == null && id != -1) {
                        fragmentFindFragmentById = fragmentManagerImpl.findFragmentById(id);
                    }
                    if (fragmentFindFragmentById == null) {
                        FragmentManager$3 fragmentFactory = fragmentManagerImpl.getFragmentFactory();
                        context.getClassLoader();
                        fragmentFindFragmentById = fragmentFactory.instantiate(attributeValue);
                        fragmentFindFragmentById.mFromLayout = true;
                        fragmentFindFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
                        fragmentFindFragmentById.mContainerId = id;
                        fragmentFindFragmentById.mTag = string;
                        fragmentFindFragmentById.mInLayout = true;
                        fragmentFindFragmentById.mFragmentManager = fragmentManagerImpl;
                        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks = fragmentManagerImpl.mHost;
                        fragmentFindFragmentById.mHost = fragmentActivity$HostCallbacks;
                        AppCompatActivity appCompatActivity = fragmentActivity$HostCallbacks.mContext;
                        fragmentFindFragmentById.mCalled = true;
                        if ((fragmentActivity$HostCallbacks == null ? fragment : fragmentActivity$HostCallbacks.mActivity) != null) {
                            fragmentFindFragmentById.mCalled = true;
                        }
                        fragmentStateManagerCreateOrGetFragmentStateManager = fragmentManagerImpl.addFragment(fragmentFindFragmentById);
                        if (FragmentManagerImpl.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Fragment " + fragmentFindFragmentById + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (fragmentFindFragmentById.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        fragmentFindFragmentById.mInLayout = true;
                        fragmentFindFragmentById.mFragmentManager = fragmentManagerImpl;
                        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks2 = fragmentManagerImpl.mHost;
                        fragmentFindFragmentById.mHost = fragmentActivity$HostCallbacks2;
                        AppCompatActivity appCompatActivity2 = fragmentActivity$HostCallbacks2.mContext;
                        fragmentFindFragmentById.mCalled = true;
                        if ((fragmentActivity$HostCallbacks2 == null ? fragment : fragmentActivity$HostCallbacks2.mActivity) != null) {
                            fragmentFindFragmentById.mCalled = true;
                        }
                        fragmentStateManagerCreateOrGetFragmentStateManager = fragmentManagerImpl.createOrGetFragmentStateManager(fragmentFindFragmentById);
                        if (FragmentManagerImpl.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + fragmentFindFragmentById + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
                    FragmentStrictMode.logIfDebuggingEnabled(new FragmentReuseViolation(fragmentFindFragmentById, "Attempting to use <fragment> tag to add fragment " + fragmentFindFragmentById + " to container " + viewGroup));
                    FragmentStrictMode.getNearestPolicy(fragmentFindFragmentById).getClass();
                    fragmentFindFragmentById.mContainer = viewGroup;
                    fragmentStateManagerCreateOrGetFragmentStateManager.moveToExpectedState();
                    fragmentStateManagerCreateOrGetFragmentStateManager.ensureInflatedView();
                    View view2 = fragmentFindFragmentById.mView;
                    if (view2 == null) {
                        throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragmentFindFragmentById.mView.getTag() == null) {
                        fragmentFindFragmentById.mView.setTag(string);
                    }
                    fragmentFindFragmentById.mView.addOnAttachStateChangeListener(new AnonymousClass1(this, fragmentStateManagerCreateOrGetFragmentStateManager));
                    return fragmentFindFragmentById.mView;
                }
            }
        }
        return null;
    }
}
