package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.WindowDecorActionBar.ActionModeImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper$Api23Impl;
import androidx.appcompat.view.WindowCallbackWrapper$Api24Impl;
import androidx.appcompat.view.WindowCallbackWrapper$Api26Impl;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.camera.core.SurfaceRequest;
import androidx.collection.SimpleArrayMap;
import androidx.compose.ui.window.Api33Impl$$ExternalSyntheticLambda0;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.NavUtils;
import androidx.core.content.PermissionChecker;
import androidx.core.graphics.Insets;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListInterface;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public WindowDecorActionBar mActionBar;
    public AnonymousClass3 mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    public int mActivityHandlesConfigFlags;
    public boolean mActivityHandlesConfigFlagsChecked;
    public final Object mAppCompatCallback;
    public AppCompatViewInflater mAppCompatViewInflater;
    public AppCompatWindowCallback mAppCompatWindowCallback;
    public AutoTimeNightModeManager mAutoBatteryNightModeManager;
    public AutoTimeNightModeManager mAutoTimeNightModeManager;
    public OnBackInvokedCallback mBackCallback;
    public boolean mBaseContextAttached;
    public boolean mClosingActionMenu;
    public final Context mContext;
    public boolean mCreated;
    public DecorContentParent mDecorContentParent;
    public boolean mDestroyed;
    public OnBackInvokedDispatcher mDispatcher;
    public Configuration mEffectiveConfiguration;
    public boolean mEnableDefaultActionBarUp;
    public boolean mFeatureIndeterminateProgress;
    public boolean mFeatureProgress;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    public boolean mIsFloating;
    public final int mLocalNightMode;
    public boolean mLongPressBackDown;
    public SupportMenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    public AnonymousClass5 mPanelMenuPresenterCallback;
    public PanelFeatureState[] mPanels;
    public PanelFeatureState mPreparedPanel;
    public AnonymousClass2 mShowActionModePopup;
    public View mStatusGuard;
    public ViewGroup mSubDecor;
    public boolean mSubDecorInstalled;
    public Rect mTempRect1;
    public Rect mTempRect2;
    public int mThemeResId;
    public CharSequence mTitle;
    public TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;
    public static final SimpleArrayMap sLocalNightModes = new SimpleArrayMap(0);
    public static final int[] sWindowBackgroundStyleable = {R.attr.windowBackground};
    public static final boolean sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
    public ViewPropertyAnimatorCompat mFadeAnim = null;
    public final boolean mHandleNativeActionModes = true;
    public final AnonymousClass2 mInvalidatePanelMenuRunnable = new AnonymousClass2(this, 0);

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public /* synthetic */ AnonymousClass2(AppCompatDelegateImpl appCompatDelegateImpl, int i) {
            this.$r8$classId = i;
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup viewGroup;
            switch (this.$r8$classId) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(0);
                    }
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 4096) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(108);
                    }
                    appCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
                    appCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
                    break;
                default:
                    AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
                    appCompatDelegateImpl2.mActionModePopup.showAtLocation(appCompatDelegateImpl2.mActionModeView, 55, 0, 0);
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl2.mFadeAnim;
                    if (viewPropertyAnimatorCompat != null) {
                        viewPropertyAnimatorCompat.cancel();
                    }
                    if (appCompatDelegateImpl2.mSubDecorInstalled && (viewGroup = appCompatDelegateImpl2.mSubDecor) != null && viewGroup.isLaidOut()) {
                        appCompatDelegateImpl2.mActionModeView.setAlpha(0.0f);
                        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(appCompatDelegateImpl2.mActionModeView);
                        viewPropertyAnimatorCompatAnimate.alpha(1.0f);
                        appCompatDelegateImpl2.mFadeAnim = viewPropertyAnimatorCompatAnimate;
                        viewPropertyAnimatorCompatAnimate.setListener(new AnonymousClass7(1, this));
                    } else {
                        appCompatDelegateImpl2.mActionModeView.setAlpha(1.0f);
                        appCompatDelegateImpl2.mActionModeView.setVisibility(0);
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 implements OnApplyWindowInsetsListener, MenuPresenter.Callback {
        public /* synthetic */ AnonymousClass3() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i;
            int i2;
            boolean z;
            WindowInsetsCompat windowInsetsCompatBuild;
            WindowInsetsCompat.BuilderImpl builderImpl29;
            boolean z2;
            boolean z3;
            boolean z4;
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            Context context = appCompatDelegateImpl.mContext;
            int systemWindowInsetTop2 = windowInsetsCompat.getSystemWindowInsetTop();
            ActionBarContextView actionBarContextView = appCompatDelegateImpl.mActionModeView;
            if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                i = 8;
                i2 = 0;
                z = false;
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.mActionModeView.getLayoutParams();
                if (appCompatDelegateImpl.mActionModeView.isShown()) {
                    if (appCompatDelegateImpl.mTempRect1 == null) {
                        appCompatDelegateImpl.mTempRect1 = new Rect();
                        appCompatDelegateImpl.mTempRect2 = new Rect();
                    }
                    Rect rect = appCompatDelegateImpl.mTempRect1;
                    Rect rect2 = appCompatDelegateImpl.mTempRect2;
                    rect.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
                    if (Build.VERSION.SDK_INT >= 29) {
                        boolean z5 = ViewUtils.sInitComputeFitSystemWindowsMethod;
                        ViewUtils.Api29Impl.computeFitSystemWindows(viewGroup, rect, rect2);
                        z3 = true;
                    } else {
                        if (!ViewUtils.sInitComputeFitSystemWindowsMethod) {
                            ViewUtils.sInitComputeFitSystemWindowsMethod = true;
                            try {
                                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                                ViewUtils.sComputeFitSystemWindowsMethod = declaredMethod;
                                if (!declaredMethod.isAccessible()) {
                                    ViewUtils.sComputeFitSystemWindowsMethod.setAccessible(true);
                                }
                            } catch (NoSuchMethodException unused) {
                                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                            }
                        }
                        Method method = ViewUtils.sComputeFitSystemWindowsMethod;
                        if (method != null) {
                            try {
                                Object[] objArr = new Object[2];
                                objArr[0] = rect;
                                z3 = true;
                                try {
                                    objArr[1] = rect2;
                                    method.invoke(viewGroup, objArr);
                                } catch (Exception e) {
                                    e = e;
                                    Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                z3 = true;
                            }
                        } else {
                            z3 = true;
                        }
                    }
                    int i3 = rect.top;
                    int i4 = rect.left;
                    int i5 = rect.right;
                    ViewGroup viewGroup2 = appCompatDelegateImpl.mSubDecor;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(viewGroup2);
                    int systemWindowInsetLeft = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetLeft();
                    int systemWindowInsetRight = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetRight();
                    if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                        z4 = false;
                    } else {
                        marginLayoutParams.topMargin = i3;
                        marginLayoutParams.leftMargin = i4;
                        marginLayoutParams.rightMargin = i5;
                        z4 = z3;
                    }
                    if (i3 <= 0 || appCompatDelegateImpl.mStatusGuard != null) {
                        i = 8;
                        View view2 = appCompatDelegateImpl.mStatusGuard;
                        if (view2 != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                            int i6 = marginLayoutParams2.height;
                            int i7 = marginLayoutParams.topMargin;
                            if (i6 != i7 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                                marginLayoutParams2.height = i7;
                                marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                                marginLayoutParams2.rightMargin = systemWindowInsetRight;
                                appCompatDelegateImpl.mStatusGuard.setLayoutParams(marginLayoutParams2);
                            }
                        }
                    } else {
                        View view3 = new View(context);
                        appCompatDelegateImpl.mStatusGuard = view3;
                        i = 8;
                        view3.setVisibility(8);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                        layoutParams.leftMargin = systemWindowInsetLeft;
                        layoutParams.rightMargin = systemWindowInsetRight;
                        appCompatDelegateImpl.mSubDecor.addView(appCompatDelegateImpl.mStatusGuard, -1, layoutParams);
                    }
                    View view4 = appCompatDelegateImpl.mStatusGuard;
                    boolean z6 = view4 != null ? z3 : false;
                    if (z6 && view4.getVisibility() != 0) {
                        View view5 = appCompatDelegateImpl.mStatusGuard;
                        view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? context.getColor(com.koala.clash.R.color.abc_decor_view_status_guard_light) : context.getColor(com.koala.clash.R.color.abc_decor_view_status_guard));
                    }
                    if (!appCompatDelegateImpl.mOverlayActionMode && z6) {
                        systemWindowInsetTop2 = 0;
                    }
                    z2 = z4;
                    z = z6;
                    i2 = 0;
                } else {
                    z2 = true;
                    i = 8;
                    i2 = 0;
                    if (marginLayoutParams.topMargin != 0) {
                        marginLayoutParams.topMargin = 0;
                        z = false;
                    } else {
                        z = false;
                        z2 = false;
                    }
                }
                if (z2) {
                    appCompatDelegateImpl.mActionModeView.setLayoutParams(marginLayoutParams);
                }
            }
            View view6 = appCompatDelegateImpl.mStatusGuard;
            if (view6 != null) {
                if (z) {
                    i = i2;
                }
                view6.setVisibility(i);
            }
            if (systemWindowInsetTop != systemWindowInsetTop2) {
                int systemWindowInsetLeft2 = windowInsetsCompat.getSystemWindowInsetLeft();
                int systemWindowInsetRight2 = windowInsetsCompat.getSystemWindowInsetRight();
                int systemWindowInsetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= 34) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl34(windowInsetsCompat);
                } else if (i8 >= 30) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat);
                } else {
                    builderImpl29 = i8 >= 29 ? new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat) : new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat);
                }
                builderImpl29.setSystemWindowInsets(Insets.of(systemWindowInsetLeft2, systemWindowInsetTop2, systemWindowInsetRight2, systemWindowInsetBottom));
                windowInsetsCompatBuild = builderImpl29.build();
            } else {
                windowInsetsCompatBuild = windowInsetsCompat;
            }
            WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
            WindowInsets windowInsets = windowInsetsCompatBuild.toWindowInsets();
            if (windowInsets == null) {
                return windowInsetsCompatBuild;
            }
            WindowInsets windowInsetsOnApplyWindowInsets = ViewCompat.Api20Impl.onApplyWindowInsets(view, windowInsets);
            return !windowInsetsOnApplyWindowInsets.equals(windowInsets) ? WindowInsetsCompat.toWindowInsetsCompat(view, windowInsetsOnApplyWindowInsets) : windowInsetsCompatBuild;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.checkCloseActionMenu(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback callback = AppCompatDelegateImpl.this.mWindow.getCallback();
            if (callback == null) {
                return true;
            }
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass5 implements ContentFrameLayout.OnAttachListener, MenuPresenter.Callback {
        public /* synthetic */ AnonymousClass5() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            PanelFeatureState panelFeatureState;
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            int i = 0;
            boolean z2 = rootMenu != menuBuilder;
            if (z2) {
                menuBuilder = rootMenu;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImpl.mPanels;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            while (true) {
                if (i < length) {
                    panelFeatureState = panelFeatureStateArr[i];
                    if (panelFeatureState != null && panelFeatureState.menu == menuBuilder) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                if (!z2) {
                    appCompatDelegateImpl.closePanel(panelFeatureState, z);
                } else {
                    appCompatDelegateImpl.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, rootMenu);
                    appCompatDelegateImpl.closePanel(panelFeatureState, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback callback;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.mHasActionBar || (callback = appCompatDelegateImpl.mWindow.getCallback()) == null || appCompatDelegateImpl.mDestroyed) {
                return true;
            }
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass7 extends ViewPropertyAnimatorListenerAdapter {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass7(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            int i = this.$r8$classId;
            Object obj = this.this$0;
            switch (i) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) obj;
                    appCompatDelegateImpl.mActionModeView.setAlpha(1.0f);
                    appCompatDelegateImpl.mFadeAnim.setListener(null);
                    appCompatDelegateImpl.mFadeAnim = null;
                    break;
                case 1:
                    AppCompatDelegateImpl appCompatDelegateImpl2 = ((AnonymousClass2) obj).this$0;
                    appCompatDelegateImpl2.mActionModeView.setAlpha(1.0f);
                    appCompatDelegateImpl2.mFadeAnim.setListener(null);
                    appCompatDelegateImpl2.mFadeAnim = null;
                    break;
                default:
                    AppCompatDelegateImpl appCompatDelegateImpl3 = (AppCompatDelegateImpl) ((SurfaceRequest.AnonymousClass1) obj).val$requestCancellationFuture;
                    appCompatDelegateImpl3.mActionModeView.setVisibility(8);
                    PopupWindow popupWindow = appCompatDelegateImpl3.mActionModePopup;
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    } else if (appCompatDelegateImpl3.mActionModeView.getParent() instanceof View) {
                        View view = (View) appCompatDelegateImpl3.mActionModeView.getParent();
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets(view);
                    }
                    appCompatDelegateImpl3.mActionModeView.killMode();
                    appCompatDelegateImpl3.mFadeAnim.setListener(null);
                    appCompatDelegateImpl3.mFadeAnim = null;
                    ViewGroup viewGroup = appCompatDelegateImpl3.mSubDecor;
                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
                    break;
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart() {
            int i = this.$r8$classId;
            Object obj = this.this$0;
            switch (i) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) obj;
                    appCompatDelegateImpl.mActionModeView.setVisibility(0);
                    if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                        View view = (View) appCompatDelegateImpl.mActionModeView.getParent();
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets(view);
                    }
                    break;
                case 1:
                    ((AnonymousClass2) obj).this$0.mActionModeView.setVisibility(0);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Api21Impl {
        public static boolean isPowerSaveMode(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Api24Impl {
        public static void generateConfigDelta_locale(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        public static LocaleListCompat getLocales(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }

        public static void setDefaultLocales(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.mImpl.toLanguageTags()));
        }

        public static void setLocales(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.mImpl.toLanguageTags()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Api33Impl {
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback registerOnBackPressedCallback(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0 = new Api33Impl$$ExternalSyntheticLambda0(1, appCompatDelegateImpl);
            ComponentDialog$$ExternalSyntheticApiModelOutline0.m4m(obj).registerOnBackInvokedCallback(1000000, api33Impl$$ExternalSyntheticLambda0);
            return api33Impl$$ExternalSyntheticLambda0;
        }

        public static void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
            ComponentDialog$$ExternalSyntheticApiModelOutline0.m4m(obj).unregisterOnBackInvokedCallback(ComponentDialog$$ExternalSyntheticApiModelOutline0.m3m(obj2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AppCompatWindowCallback implements Window.Callback {
        public boolean mDispatchKeyEventBypassEnabled;
        public boolean mOnContentChangedBypassEnabled;
        public boolean mOnPanelClosedBypassEnabled;
        public final Window.Callback mWrapped;

        public AppCompatWindowCallback(Window.Callback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("Window callback may not be null");
            }
            this.mWrapped = callback;
        }

        public final void bypassOnContentChanged(Window.Callback callback) {
            try {
                this.mOnContentChangedBypassEnabled = true;
                callback.onContentChanged();
            } finally {
                this.mOnContentChangedBypassEnabled = false;
            }
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchGenericMotionEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean z = this.mDispatchKeyEventBypassEnabled;
            Window.Callback callback = this.mWrapped;
            if (z) {
                return callback.dispatchKeyEvent(keyEvent);
            }
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || callback.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x003b  */
        /* JADX WARN: Code duplicated, block: B:18:0x003d  */
        /* JADX WARN: Code duplicated, block: B:25:0x0052  */
        /* JADX WARN: Code duplicated, block: B:27:0x0056  */
        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            PanelFeatureState panelFeatureState;
            boolean z;
            boolean zPerformPanelShortcut;
            MenuBuilder menuBuilder;
            boolean zPerformShortcut;
            if (!this.mWrapped.dispatchKeyShortcutEvent(keyEvent)) {
                int keyCode = keyEvent.getKeyCode();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.initWindowDecorActionBar();
                WindowDecorActionBar windowDecorActionBar = appCompatDelegateImpl.mActionBar;
                if (windowDecorActionBar == null) {
                    panelFeatureState = appCompatDelegateImpl.mPreparedPanel;
                    if (panelFeatureState == null && appCompatDelegateImpl.performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent)) {
                        PanelFeatureState panelFeatureState2 = appCompatDelegateImpl.mPreparedPanel;
                        if (panelFeatureState2 != null) {
                            panelFeatureState2.isHandled = true;
                        }
                    } else {
                        if (appCompatDelegateImpl.mPreparedPanel == null) {
                            PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(0);
                            appCompatDelegateImpl.preparePanel(panelState, keyEvent);
                            zPerformPanelShortcut = appCompatDelegateImpl.performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent);
                            panelState.isPrepared = false;
                            if (zPerformPanelShortcut) {
                            }
                        }
                        z = false;
                    }
                    z = true;
                } else {
                    WindowDecorActionBar.ActionModeImpl actionModeImpl = windowDecorActionBar.mActionMode;
                    if (actionModeImpl == null || (menuBuilder = actionModeImpl.mMenu) == null) {
                        zPerformShortcut = false;
                    } else {
                        menuBuilder.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
                        zPerformShortcut = menuBuilder.performShortcut(keyCode, keyEvent, 0);
                    }
                    if (zPerformShortcut) {
                        z = true;
                    } else {
                        panelFeatureState = appCompatDelegateImpl.mPreparedPanel;
                        if (panelFeatureState == null) {
                            if (appCompatDelegateImpl.mPreparedPanel == null) {
                                PanelFeatureState panelState2 = appCompatDelegateImpl.getPanelState(0);
                                appCompatDelegateImpl.preparePanel(panelState2, keyEvent);
                                zPerformPanelShortcut = appCompatDelegateImpl.performPanelShortcut(panelState2, keyEvent.getKeyCode(), keyEvent);
                                panelState2.isPrepared = false;
                                if (zPerformPanelShortcut) {
                                    z = true;
                                }
                            }
                            z = false;
                        } else {
                            if (appCompatDelegateImpl.mPreparedPanel == null) {
                                PanelFeatureState panelState3 = appCompatDelegateImpl.getPanelState(0);
                                appCompatDelegateImpl.preparePanel(panelState3, keyEvent);
                                zPerformPanelShortcut = appCompatDelegateImpl.performPanelShortcut(panelState3, keyEvent.getKeyCode(), keyEvent);
                                panelState3.isPrepared = false;
                                if (zPerformPanelShortcut) {
                                    z = true;
                                }
                            }
                            z = false;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return this.mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchTrackballEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(android.view.ActionMode actionMode) {
            this.mWrapped.onActionModeFinished(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(android.view.ActionMode actionMode) {
            this.mWrapped.onActionModeStarted(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.mWrapped.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled) {
                this.mWrapped.onContentChanged();
            }
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return this.mWrapped.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int i) {
            return this.mWrapped.onCreatePanelView(i);
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.mWrapped.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return this.mWrapped.onMenuItemSelected(i, menuItem);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int i, Menu menu) {
            onMenuOpened$androidx$appcompat$view$WindowCallbackWrapper(i, menu);
            if (i == 108) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.initWindowDecorActionBar();
                WindowDecorActionBar windowDecorActionBar = appCompatDelegateImpl.mActionBar;
                if (windowDecorActionBar != null) {
                    ArrayList arrayList = windowDecorActionBar.mMenuVisibilityListeners;
                    if (true != windowDecorActionBar.mLastMenuVisibility) {
                        windowDecorActionBar.mLastMenuVisibility = true;
                        if (arrayList.size() > 0) {
                            arrayList.get(0).getClass();
                            throw new ClassCastException();
                        }
                    }
                }
            }
            return true;
        }

        public final boolean onMenuOpened$androidx$appcompat$view$WindowCallbackWrapper(int i, Menu menu) {
            return this.mWrapped.onMenuOpened(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int i, Menu menu) {
            if (this.mOnPanelClosedBypassEnabled) {
                this.mWrapped.onPanelClosed(i, menu);
                return;
            }
            onPanelClosed$androidx$appcompat$view$WindowCallbackWrapper(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i != 108) {
                if (i == 0) {
                    PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(i);
                    if (panelState.isOpen) {
                        appCompatDelegateImpl.closePanel(panelState, false);
                        return;
                    }
                    return;
                }
                return;
            }
            appCompatDelegateImpl.initWindowDecorActionBar();
            WindowDecorActionBar windowDecorActionBar = appCompatDelegateImpl.mActionBar;
            if (windowDecorActionBar != null) {
                ArrayList arrayList = windowDecorActionBar.mMenuVisibilityListeners;
                if (windowDecorActionBar.mLastMenuVisibility) {
                    windowDecorActionBar.mLastMenuVisibility = false;
                    if (arrayList.size() <= 0) {
                        return;
                    }
                    arrayList.get(0).getClass();
                    throw new ClassCastException();
                }
            }
        }

        public final void onPanelClosed$androidx$appcompat$view$WindowCallbackWrapper(int i, Menu menu) {
            this.mWrapped.onPanelClosed(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPointerCaptureChanged(boolean z) {
            WindowCallbackWrapper$Api26Impl.onPointerCaptureChanged(this.mWrapped, z);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = true;
            }
            boolean zOnPreparePanel = this.mWrapped.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = false;
            }
            return zOnPreparePanel;
        }

        @Override // android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.getPanelState(0).menu;
            if (menuBuilder != null) {
                onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(list, menuBuilder, i);
            } else {
                onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(list, menu, i);
            }
        }

        public final void onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(List list, Menu menu, int i) {
            WindowCallbackWrapper$Api24Impl.onProvideKeyboardShortcuts(this.mWrapped, list, menu, i);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent searchEvent) {
            return WindowCallbackWrapper$Api23Impl.onSearchRequested(this.mWrapped, searchEvent);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            this.mWrapped.onWindowAttributesChanged(layoutParams);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean z) {
            this.mWrapped.onWindowFocusChanged(z);
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
            return null;
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.mWrapped.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
            ViewGroup viewGroup;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.mHandleNativeActionModes || i != 0) {
                return WindowCallbackWrapper$Api23Impl.onWindowStartingActionMode(this.mWrapped, callback, i);
            }
            Context context = appCompatDelegateImpl.mContext;
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.readyAsyncCalls = context;
            dispatcher.executorServiceOrNull = callback;
            dispatcher.runningAsyncCalls = new ArrayList();
            int i2 = 0;
            dispatcher.runningSyncCalls = new SimpleArrayMap(0);
            ActionMode actionMode = appCompatDelegateImpl.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
            }
            int i3 = 1;
            SurfaceRequest.AnonymousClass1 anonymousClass1 = new SurfaceRequest.AnonymousClass1(i3, appCompatDelegateImpl, dispatcher);
            appCompatDelegateImpl.initWindowDecorActionBar();
            WindowDecorActionBar windowDecorActionBar = appCompatDelegateImpl.mActionBar;
            if (windowDecorActionBar != null) {
                WindowDecorActionBar.ActionModeImpl actionModeImpl = windowDecorActionBar.mActionMode;
                if (actionModeImpl != null) {
                    actionModeImpl.finish();
                }
                windowDecorActionBar.mOverlayLayout.setHideOnContentScrollEnabled(false);
                windowDecorActionBar.mContextView.killMode();
                WindowDecorActionBar.ActionModeImpl actionModeImpl2 = windowDecorActionBar.new ActionModeImpl(windowDecorActionBar.mContextView.getContext(), anonymousClass1);
                MenuBuilder menuBuilder = actionModeImpl2.mMenu;
                menuBuilder.stopDispatchingItemsChanged();
                try {
                    boolean zOnCreateActionMode = ((Dispatcher) actionModeImpl2.mCallback.val$requestCancellationCompleter).onCreateActionMode(actionModeImpl2, menuBuilder);
                    menuBuilder.startDispatchingItemsChanged();
                    if (zOnCreateActionMode) {
                        windowDecorActionBar.mActionMode = actionModeImpl2;
                        actionModeImpl2.invalidate();
                        windowDecorActionBar.mContextView.initForMode(actionModeImpl2);
                        windowDecorActionBar.animateToMode(true);
                    } else {
                        actionModeImpl2 = null;
                    }
                    appCompatDelegateImpl.mActionMode = actionModeImpl2;
                } catch (Throwable th) {
                    menuBuilder.startDispatchingItemsChanged();
                    throw th;
                }
            }
            if (appCompatDelegateImpl.mActionMode == null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.mFadeAnim;
                if (viewPropertyAnimatorCompat != null) {
                    viewPropertyAnimatorCompat.cancel();
                }
                ActionMode actionMode2 = appCompatDelegateImpl.mActionMode;
                if (actionMode2 != null) {
                    actionMode2.finish();
                }
                if (appCompatDelegateImpl.mActionModeView == null) {
                    if (appCompatDelegateImpl.mIsFloating) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.koala.clash.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(themeNewTheme);
                            context = contextThemeWrapper;
                        }
                        appCompatDelegateImpl.mActionModeView = new ActionBarContextView(context, null);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, com.koala.clash.R.attr.actionModePopupWindowStyle);
                        appCompatDelegateImpl.mActionModePopup = popupWindow;
                        popupWindow.setWindowLayoutType(2);
                        appCompatDelegateImpl.mActionModePopup.setContentView(appCompatDelegateImpl.mActionModeView);
                        appCompatDelegateImpl.mActionModePopup.setWidth(-1);
                        context.getTheme().resolveAttribute(com.koala.clash.R.attr.actionBarSize, typedValue, true);
                        appCompatDelegateImpl.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        appCompatDelegateImpl.mActionModePopup.setHeight(-2);
                        appCompatDelegateImpl.mShowActionModePopup = new AnonymousClass2(appCompatDelegateImpl, i3);
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) appCompatDelegateImpl.mSubDecor.findViewById(com.koala.clash.R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            appCompatDelegateImpl.initWindowDecorActionBar();
                            WindowDecorActionBar windowDecorActionBar2 = appCompatDelegateImpl.mActionBar;
                            Context themedContext = windowDecorActionBar2 != null ? windowDecorActionBar2.getThemedContext() : null;
                            if (themedContext != null) {
                                context = themedContext;
                            }
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                            appCompatDelegateImpl.mActionModeView = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (appCompatDelegateImpl.mActionModeView != null) {
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = appCompatDelegateImpl.mFadeAnim;
                    if (viewPropertyAnimatorCompat2 != null) {
                        viewPropertyAnimatorCompat2.cancel();
                    }
                    appCompatDelegateImpl.mActionModeView.killMode();
                    Context context2 = appCompatDelegateImpl.mActionModeView.getContext();
                    ActionBarContextView actionBarContextView = appCompatDelegateImpl.mActionModeView;
                    StandaloneActionMode standaloneActionMode = new StandaloneActionMode();
                    standaloneActionMode.mContext = context2;
                    standaloneActionMode.mContextView = actionBarContextView;
                    standaloneActionMode.mCallback = anonymousClass1;
                    MenuBuilder menuBuilder2 = new MenuBuilder(actionBarContextView.getContext());
                    menuBuilder2.mDefaultShowAsAction = 1;
                    standaloneActionMode.mMenu = menuBuilder2;
                    menuBuilder2.mCallback = standaloneActionMode;
                    if (dispatcher.onCreateActionMode(standaloneActionMode, menuBuilder2)) {
                        standaloneActionMode.invalidate();
                        appCompatDelegateImpl.mActionModeView.initForMode(standaloneActionMode);
                        appCompatDelegateImpl.mActionMode = standaloneActionMode;
                        if (appCompatDelegateImpl.mSubDecorInstalled && (viewGroup = appCompatDelegateImpl.mSubDecor) != null && viewGroup.isLaidOut()) {
                            appCompatDelegateImpl.mActionModeView.setAlpha(0.0f);
                            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
                            viewPropertyAnimatorCompatAnimate.alpha(1.0f);
                            appCompatDelegateImpl.mFadeAnim = viewPropertyAnimatorCompatAnimate;
                            viewPropertyAnimatorCompatAnimate.setListener(new AnonymousClass7(i2, appCompatDelegateImpl));
                        } else {
                            appCompatDelegateImpl.mActionModeView.setAlpha(1.0f);
                            appCompatDelegateImpl.mActionModeView.setVisibility(0);
                            if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                                View view = (View) appCompatDelegateImpl.mActionModeView.getParent();
                                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                ViewCompat.Api20Impl.requestApplyInsets(view);
                            }
                        }
                        if (appCompatDelegateImpl.mActionModePopup != null) {
                            appCompatDelegateImpl.mWindow.getDecorView().post(appCompatDelegateImpl.mShowActionModePopup);
                        }
                    } else {
                        appCompatDelegateImpl.mActionMode = null;
                    }
                }
                appCompatDelegateImpl.updateBackInvokedCallbackState();
                appCompatDelegateImpl.mActionMode = appCompatDelegateImpl.mActionMode;
            }
            appCompatDelegateImpl.updateBackInvokedCallbackState();
            ActionMode actionMode3 = appCompatDelegateImpl.mActionMode;
            if (actionMode3 != null) {
                return dispatcher.getActionModeWrapper(actionMode3);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(ContextThemeWrapper contextThemeWrapper) {
            super(contextThemeWrapper, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.closePanel(appCompatDelegateImpl.getPanelState(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(AbstractList.Companion.getDrawable(getContext(), i));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class PanelFeatureState {
        public int background;
        public View createdPanelView;
        public ListMenuDecorView decorView;
        public int featureId;
        public Bundle frozenActionViewState;
        public int gravity;
        public boolean isHandled;
        public boolean isOpen;
        public boolean isPrepared;
        public ListMenuPresenter listMenuPresenter;
        public ContextThemeWrapper listPresenterContext;
        public MenuBuilder menu;
        public boolean refreshDecorView;
        public boolean refreshMenuContent;
        public View shownPanelView;
        public int windowAnimations;
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity appCompatActivity = null;
        this.mLocalNightMode = -100;
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof AppCompatActivity)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    appCompatActivity = (AppCompatActivity) context;
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.mLocalNightMode = ((AppCompatDelegateImpl) appCompatActivity.getDelegate()).mLocalNightMode;
            }
        }
        if (this.mLocalNightMode == -100) {
            String name = this.mHost.getClass().getName();
            SimpleArrayMap simpleArrayMap = sLocalNightModes;
            Integer num = (Integer) simpleArrayMap.get(name);
            if (num != null) {
                this.mLocalNightMode = num.intValue();
                simpleArrayMap.remove(this.mHost.getClass().getName());
            }
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    public static LocaleListCompat calculateApplicationLocales(Context context) {
        LocaleListCompat localeListCompat;
        LocaleListCompat localeListCompatForLanguageTags;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (localeListCompat = AppCompatDelegate.sRequestedAppLocales) == null) {
            return null;
        }
        LocaleListInterface localeListInterface = localeListCompat.mImpl;
        LocaleListCompat configurationLocales = getConfigurationLocales(context.getApplicationContext().getResources().getConfiguration());
        int i2 = 0;
        if (i < 24) {
            localeListCompatForLanguageTags = localeListInterface.isEmpty() ? LocaleListCompat.sEmptyLocaleList : LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(localeListInterface.get(0)));
        } else if (localeListInterface.isEmpty()) {
            localeListCompatForLanguageTags = LocaleListCompat.sEmptyLocaleList;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i2 < configurationLocales.mImpl.size() + localeListInterface.size()) {
                Locale locale = i2 < localeListInterface.size() ? localeListInterface.get(i2) : configurationLocales.mImpl.get(i2 - localeListInterface.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i2++;
            }
            localeListCompatForLanguageTags = LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return localeListCompatForLanguageTags.mImpl.isEmpty() ? configurationLocales : localeListCompatForLanguageTags;
    }

    public static Configuration createOverrideAppConfiguration(Context context, int i, LocaleListCompat localeListCompat, Configuration configuration, boolean z) {
        int i2;
        if (i == 1) {
            i2 = 16;
        } else if (i != 2) {
            i2 = z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i2 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (localeListCompat != null) {
            LocaleListInterface localeListInterface = localeListCompat.mImpl;
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.setLocales(configuration2, localeListCompat);
                return configuration2;
            }
            configuration2.setLocale(localeListInterface.get(0));
            configuration2.setLayoutDirection(localeListInterface.get(0));
        }
        return configuration2;
    }

    public static LocaleListCompat getConfigurationLocales(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.getLocales(configuration) : LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(configuration.locale));
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0100  */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean applyApplicationSpecificConfig(boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        Object obj;
        int i2;
        if (this.mDestroyed) {
            return false;
        }
        int i3 = this.mLocalNightMode;
        if (i3 == -100) {
            i3 = AppCompatDelegate.sDefaultNightMode;
        }
        Context context = this.mContext;
        int iMapNightMode = mapNightMode(context, i3);
        int i4 = Build.VERSION.SDK_INT;
        Object obj2 = null;
        LocaleListCompat localeListCompatCalculateApplicationLocales = i4 < 33 ? calculateApplicationLocales(context) : null;
        if (!z2 && localeListCompatCalculateApplicationLocales != null) {
            localeListCompatCalculateApplicationLocales = getConfigurationLocales(context.getResources().getConfiguration());
        }
        Configuration configurationCreateOverrideAppConfiguration = createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false);
        boolean z6 = this.mActivityHandlesConfigFlagsChecked;
        Object obj3 = this.mHost;
        if (z6 || !(obj3 instanceof Activity)) {
            this.mActivityHandlesConfigFlagsChecked = true;
            i = this.mActivityHandlesConfigFlags;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i = 0;
            } else {
                if (i4 >= 29) {
                    i2 = 269221888;
                } else {
                    i2 = i4 >= 24 ? 786432 : 0;
                }
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj3.getClass()), i2);
                    if (activityInfo != null) {
                        this.mActivityHandlesConfigFlags = activityInfo.configChanges;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                    this.mActivityHandlesConfigFlags = 0;
                }
                this.mActivityHandlesConfigFlagsChecked = true;
                i = this.mActivityHandlesConfigFlags;
            }
        }
        Configuration configuration = this.mEffectiveConfiguration;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i5 = configuration.uiMode & 48;
        int i6 = configurationCreateOverrideAppConfiguration.uiMode & 48;
        LocaleListCompat configurationLocales = getConfigurationLocales(configuration);
        LocaleListCompat configurationLocales2 = localeListCompatCalculateApplicationLocales == null ? null : getConfigurationLocales(configurationCreateOverrideAppConfiguration);
        int i7 = i5 != i6 ? 512 : 0;
        if (configurationLocales2 != null && !configurationLocales.equals(configurationLocales2)) {
            i7 |= 8196;
        }
        if (((~i) & i7) != 0 && z && this.mBaseContextAttached && ((sCanReturnDifferentContext || this.mCreated) && (obj3 instanceof Activity))) {
            Activity activity = (Activity) obj3;
            if (activity.isChild()) {
                z3 = false;
            } else {
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= 31 && (i7 & 8192) != 0) {
                    activity.getWindow().getDecorView().setLayoutDirection(configurationCreateOverrideAppConfiguration.getLayoutDirection());
                }
                if (i8 >= 28) {
                    activity.recreate();
                } else {
                    new Handler(activity.getMainLooper()).post(new ActivityCompat$$ExternalSyntheticLambda0(0, activity));
                }
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z3 || i7 == 0) {
            z4 = z3;
        } else {
            boolean z7 = (i & i7) == i7;
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i6;
            if (configurationLocales2 != null) {
                LocaleListInterface localeListInterface = configurationLocales2.mImpl;
                if (Build.VERSION.SDK_INT >= 24) {
                    Api24Impl.setLocales(configuration2, configurationLocales2);
                } else {
                    configuration2.setLocale(localeListInterface.get(0));
                    configuration2.setLayoutDirection(localeListInterface.get(0));
                }
            }
            resources.updateConfiguration(configuration2, null);
            int i9 = Build.VERSION.SDK_INT;
            if (i9 < 26 && i9 < 28) {
                if (i9 >= 24) {
                    if (!UnsignedKt.sResourcesImplFieldFetched) {
                        try {
                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                            UnsignedKt.sResourcesImplField = declaredField;
                            declaredField.setAccessible(true);
                        } catch (NoSuchFieldException e2) {
                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
                        }
                        UnsignedKt.sResourcesImplFieldFetched = true;
                    }
                    Field field = UnsignedKt.sResourcesImplField;
                    if (field != null) {
                        try {
                            obj = field.get(resources);
                        } catch (IllegalAccessException e3) {
                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                            obj = null;
                        }
                        if (obj != null) {
                            if (!UnsignedKt.sDrawableCacheFieldFetched) {
                                try {
                                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                    UnsignedKt.sDrawableCacheField = declaredField2;
                                    declaredField2.setAccessible(true);
                                } catch (NoSuchFieldException e4) {
                                    Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                                }
                                UnsignedKt.sDrawableCacheFieldFetched = true;
                            }
                            Field field2 = UnsignedKt.sDrawableCacheField;
                            if (field2 != null) {
                                try {
                                    obj2 = field2.get(obj);
                                } catch (IllegalAccessException e5) {
                                    Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                                }
                            }
                            if (obj2 != null) {
                                UnsignedKt.flushThemedResourcesCache(obj2);
                            }
                        }
                    }
                } else {
                    if (!UnsignedKt.sDrawableCacheFieldFetched) {
                        try {
                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                            UnsignedKt.sDrawableCacheField = declaredField3;
                            declaredField3.setAccessible(true);
                        } catch (NoSuchFieldException e6) {
                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e6);
                        }
                        UnsignedKt.sDrawableCacheFieldFetched = true;
                    }
                    Field field3 = UnsignedKt.sDrawableCacheField;
                    if (field3 != null) {
                        try {
                            obj2 = field3.get(resources);
                        } catch (IllegalAccessException e7) {
                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e7);
                        }
                    }
                    if (obj2 != null) {
                        UnsignedKt.flushThemedResourcesCache(obj2);
                    }
                }
            }
            int i10 = this.mThemeResId;
            if (i10 != 0) {
                context.setTheme(i10);
                z5 = true;
                context.getTheme().applyStyle(this.mThemeResId, true);
            } else {
                z5 = true;
            }
            if (z7 && (obj3 instanceof Activity)) {
                Activity activity2 = (Activity) obj3;
                if (activity2 instanceof LifecycleOwner) {
                    if (((LifecycleOwner) activity2).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                        activity2.onConfigurationChanged(configuration2);
                    }
                } else if (this.mCreated && !this.mDestroyed) {
                    activity2.onConfigurationChanged(configuration2);
                }
            }
            z4 = z5;
        }
        if (configurationLocales2 != null) {
            LocaleListCompat configurationLocales3 = getConfigurationLocales(context.getResources().getConfiguration());
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.setDefaultLocales(configurationLocales3);
            } else {
                Locale.setDefault(configurationLocales3.mImpl.get(0));
            }
        }
        if (i3 == 0) {
            getAutoTimeNightModeManager(context).setup();
        } else {
            AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoTimeNightModeManager;
            if (autoTimeNightModeManager != null) {
                autoTimeNightModeManager.cleanup();
            }
        }
        if (i3 == 3) {
            if (this.mAutoBatteryNightModeManager == null) {
                this.mAutoBatteryNightModeManager = new AutoTimeNightModeManager(context);
            }
            this.mAutoBatteryNightModeManager.setup();
        } else {
            AutoTimeNightModeManager autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
            if (autoTimeNightModeManager2 != null) {
                autoTimeNightModeManager2.cleanup();
            }
        }
        return z4;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    public final void attachToWindow(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.mWindow != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
        this.mAppCompatWindowCallback = appCompatWindowCallback;
        window.setCallback(appCompatWindowCallback);
        Context context = this.mContext;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, sWindowBackgroundStyleable);
        if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = null;
        } else {
            AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
            synchronized (appCompatDrawableManager) {
                drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
            }
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.mWindow = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.mDispatcher) != null) {
            return;
        }
        Object obj = this.mHost;
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.mBackCallback) != null) {
            Api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
            this.mBackCallback = null;
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.mDispatcher = Api33Impl.getOnBackInvokedDispatcher(activity);
            } else {
                this.mDispatcher = null;
            }
        } else {
            this.mDispatcher = null;
        }
        updateBackInvokedCallbackState();
    }

    public final void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menuBuilder = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mDestroyed) {
            AppCompatWindowCallback appCompatWindowCallback = this.mAppCompatWindowCallback;
            Window.Callback callback = this.mWindow.getCallback();
            appCompatWindowCallback.getClass();
            try {
                appCompatWindowCallback.mOnPanelClosedBypassEnabled = true;
                callback.onPanelClosed(i, menuBuilder);
            } finally {
                appCompatWindowCallback.mOnPanelClosedBypassEnabled = false;
            }
        }
    }

    public final void checkCloseActionMenu(MenuBuilder menuBuilder) {
        ActionMenuPresenter actionMenuPresenter;
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.mDecorContentParent;
        actionBarOverlayLayout.pullChildren();
        ActionMenuView actionMenuView = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar.mMenuView;
        if (actionMenuView != null && (actionMenuPresenter = actionMenuView.mPresenter) != null) {
            actionMenuPresenter.hideOverflowMenu();
            ActionMenuPresenter.OverflowPopup overflowPopup = actionMenuPresenter.mActionButtonPopup;
            if (overflowPopup != null && overflowPopup.isShowing()) {
                overflowPopup.mPopup.dismiss();
            }
        }
        Window.Callback callback = this.mWindow.getCallback();
        if (callback != null && !this.mDestroyed) {
            callback.onPanelClosed(108, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public final void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        ListMenuDecorView listMenuDecorView;
        DecorContentParent decorContentParent;
        ActionMenuPresenter actionMenuPresenter;
        if (z && panelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent;
            actionBarOverlayLayout.pullChildren();
            ActionMenuView actionMenuView = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar.mMenuView;
            if (actionMenuView != null && (actionMenuPresenter = actionMenuView.mPresenter) != null && actionMenuPresenter.isOverflowMenuShowing()) {
                checkCloseActionMenu(panelFeatureState.menu);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && (listMenuDecorView = panelFeatureState.decorView) != null) {
            windowManager.removeView(listMenuDecorView);
            if (z) {
                callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
        if (panelFeatureState.featureId == 0) {
            updateBackInvokedCallbackState();
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0147  */
    /* JADX WARN: Code duplicated, block: B:104:0x014e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:78:0x0105  */
    /* JADX WARN: Code duplicated, block: B:80:0x0109  */
    /* JADX WARN: Code duplicated, block: B:91:0x0123  */
    /* JADX WARN: Code duplicated, block: B:95:0x012d  */
    /* JADX WARN: Code duplicated, block: B:97:0x013b  */
    /* JADX WARN: Code duplicated, block: B:99:0x013f  */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView;
        int keyCode;
        PanelFeatureState panelState;
        DecorContentParent decorContentParent;
        Context context;
        boolean z;
        boolean z2;
        boolean zPreparePanel;
        AudioManager audioManager;
        Toolbar toolbar;
        ActionMenuView actionMenuView;
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuPresenter actionMenuPresenter2;
        ActionMenuPresenter actionMenuPresenter3;
        PanelFeatureState panelState2;
        Object obj = this.mHost;
        if ((!(obj instanceof KeyEventDispatcher.Component) && !(obj instanceof AlertDialog)) || (decorView = this.mWindow.getDecorView()) == null || !KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            if (keyEvent.getKeyCode() == 82) {
                AppCompatWindowCallback appCompatWindowCallback = this.mAppCompatWindowCallback;
                Window.Callback callback = this.mWindow.getCallback();
                appCompatWindowCallback.getClass();
                try {
                    appCompatWindowCallback.mDispatchKeyEventBypassEnabled = true;
                    boolean zDispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                    appCompatWindowCallback.mDispatchKeyEventBypassEnabled = false;
                    if (!zDispatchKeyEvent) {
                        keyCode = keyEvent.getKeyCode();
                        if (keyEvent.getAction() == 0) {
                            if (keyCode != 4) {
                                this.mLongPressBackDown = (keyEvent.getFlags() & 128) != 0;
                                return false;
                            }
                            if (keyCode == 82) {
                                if (keyEvent.getRepeatCount() == 0) {
                                    panelState2 = getPanelState(0);
                                    if (!panelState2.isOpen) {
                                        preparePanel(panelState2, keyEvent);
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        if (keyCode != 4) {
                            if (keyCode == 82) {
                                if (this.mActionMode == null) {
                                    panelState = getPanelState(0);
                                    decorContentParent = this.mDecorContentParent;
                                    context = this.mContext;
                                    if (decorContentParent != null) {
                                        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent;
                                        actionBarOverlayLayout.pullChildren();
                                        toolbar = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar;
                                        if (toolbar.getVisibility() == 0 || (actionMenuView = toolbar.mMenuView) == null || !actionMenuView.mReserveOverflow || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                                            z = panelState.isOpen;
                                            if (!z || panelState.isHandled) {
                                                closePanel(panelState, true);
                                                z2 = z;
                                            } else {
                                                if (panelState.isPrepared) {
                                                    if (panelState.refreshMenuContent) {
                                                        panelState.isPrepared = false;
                                                        zPreparePanel = preparePanel(panelState, keyEvent);
                                                    } else {
                                                        zPreparePanel = true;
                                                    }
                                                    if (zPreparePanel) {
                                                        openPanel(panelState, keyEvent);
                                                        z2 = true;
                                                    }
                                                }
                                                z2 = false;
                                            }
                                        } else {
                                            ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.mDecorContentParent;
                                            actionBarOverlayLayout2.pullChildren();
                                            ActionMenuView actionMenuView2 = ((ToolbarWidgetWrapper) actionBarOverlayLayout2.mDecorToolbar).mToolbar.mMenuView;
                                            if (actionMenuView2 == null || (actionMenuPresenter2 = actionMenuView2.mPresenter) == null || !actionMenuPresenter2.isOverflowMenuShowing()) {
                                                if (!this.mDestroyed && preparePanel(panelState, keyEvent)) {
                                                    ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.mDecorContentParent;
                                                    actionBarOverlayLayout3.pullChildren();
                                                    ActionMenuView actionMenuView3 = ((ToolbarWidgetWrapper) actionBarOverlayLayout3.mDecorToolbar).mToolbar.mMenuView;
                                                    if (actionMenuView3 != null && (actionMenuPresenter = actionMenuView3.mPresenter) != null && actionMenuPresenter.showOverflowMenu()) {
                                                        z2 = true;
                                                    }
                                                }
                                                z2 = false;
                                            } else {
                                                ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.mDecorContentParent;
                                                actionBarOverlayLayout4.pullChildren();
                                                ActionMenuView actionMenuView4 = ((ToolbarWidgetWrapper) actionBarOverlayLayout4.mDecorToolbar).mToolbar.mMenuView;
                                                if (actionMenuView4 == null || (actionMenuPresenter3 = actionMenuView4.mPresenter) == null || !actionMenuPresenter3.hideOverflowMenu()) {
                                                    z2 = false;
                                                } else {
                                                    z2 = true;
                                                }
                                            }
                                        }
                                    } else {
                                        z = panelState.isOpen;
                                        if (z) {
                                        }
                                        closePanel(panelState, true);
                                        z2 = z;
                                    }
                                    if (z2) {
                                        audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                                        if (audioManager != null) {
                                            audioManager.playSoundEffect(0);
                                            return true;
                                        }
                                        Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        if (onBackPressed()) {
                            return false;
                        }
                    }
                } catch (Throwable th) {
                    appCompatWindowCallback.mDispatchKeyEventBypassEnabled = false;
                    throw th;
                }
            } else {
                keyCode = keyEvent.getKeyCode();
                if (keyEvent.getAction() == 0) {
                    if (keyCode != 4) {
                        this.mLongPressBackDown = (keyEvent.getFlags() & 128) != 0;
                        return false;
                    }
                    if (keyCode == 82) {
                        if (keyEvent.getRepeatCount() == 0) {
                            panelState2 = getPanelState(0);
                            if (!panelState2.isOpen) {
                                preparePanel(panelState2, keyEvent);
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if (keyCode != 4) {
                    if (keyCode == 82) {
                        if (this.mActionMode == null) {
                            panelState = getPanelState(0);
                            decorContentParent = this.mDecorContentParent;
                            context = this.mContext;
                            if (decorContentParent != null) {
                                ActionBarOverlayLayout actionBarOverlayLayout5 = (ActionBarOverlayLayout) decorContentParent;
                                actionBarOverlayLayout5.pullChildren();
                                toolbar = ((ToolbarWidgetWrapper) actionBarOverlayLayout5.mDecorToolbar).mToolbar;
                                if (toolbar.getVisibility() == 0) {
                                    z = panelState.isOpen;
                                    if (z) {
                                    }
                                    closePanel(panelState, true);
                                    z2 = z;
                                } else {
                                    z = panelState.isOpen;
                                    if (z) {
                                    }
                                    closePanel(panelState, true);
                                    z2 = z;
                                }
                            } else {
                                z = panelState.isOpen;
                                if (z) {
                                }
                                closePanel(panelState, true);
                                z2 = z;
                            }
                            if (z2) {
                                audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                                if (audioManager != null) {
                                    audioManager.playSoundEffect(0);
                                    return true;
                                }
                                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if (onBackPressed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState = getPanelState(i);
        if (panelState.menu != null) {
            Bundle bundle = new Bundle();
            panelState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState.frozenActionViewState = bundle;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((i == 108 || i == 0) && this.mDecorContentParent != null) {
            PanelFeatureState panelState2 = getPanelState(0);
            panelState2.isPrepared = false;
            preparePanel(panelState2, null);
        }
    }

    public final void ensureSubDecor() {
        ViewGroup viewGroup;
        if (this.mSubDecorInstalled) {
            return;
        }
        Context context = this.mContext;
        int[] iArr = R$styleable.AppCompatTheme;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            requestWindowFeature(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            requestWindowFeature(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            requestWindowFeature(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            requestWindowFeature(10);
        }
        this.mIsFloating = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.mWindowNoTitle) {
            viewGroup = this.mOverlayActionMode ? (ViewGroup) layoutInflaterFrom.inflate(com.koala.clash.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.koala.clash.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.mIsFloating) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.koala.clash.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.mOverlayActionBar = false;
            this.mHasActionBar = false;
        } else if (this.mHasActionBar) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.koala.clash.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(context, typedValue.resourceId) : context).inflate(com.koala.clash.R.layout.abc_screen_toolbar, (ViewGroup) null);
            DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(com.koala.clash.R.id.decor_content_parent);
            this.mDecorContentParent = decorContentParent;
            decorContentParent.setWindowCallback(this.mWindow.getCallback());
            if (this.mOverlayActionBar) {
                ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(109);
            }
            if (this.mFeatureProgress) {
                ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(2);
            }
            if (this.mFeatureIndeterminateProgress) {
                ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        }
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(viewGroup, anonymousClass3);
        if (this.mDecorContentParent == null) {
            this.mTitleView = (TextView) viewGroup.findViewById(com.koala.clash.R.id.title);
        }
        boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.koala.clash.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.mWindow.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new AnonymousClass5());
        this.mSubDecor = viewGroup;
        Object obj = this.mHost;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.mTitle;
        if (!TextUtils.isEmpty(title)) {
            DecorContentParent decorContentParent2 = this.mDecorContentParent;
            if (decorContentParent2 != null) {
                decorContentParent2.setWindowTitle(title);
            } else {
                WindowDecorActionBar windowDecorActionBar = this.mActionBar;
                if (windowDecorActionBar != null) {
                    ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) windowDecorActionBar.mDecorToolbar;
                    if (!toolbarWidgetWrapper.mTitleSet) {
                        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
                        toolbarWidgetWrapper.mTitle = title;
                        if ((toolbarWidgetWrapper.mDisplayOpts & 8) != 0) {
                            toolbar.setTitle(title);
                            if (toolbarWidgetWrapper.mTitleSet) {
                                ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), title);
                            }
                        }
                    }
                } else {
                    TextView textView = this.mTitleView;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.mSubDecor.findViewById(R.id.content);
        View decorView = this.mWindow.getDecorView();
        contentFrameLayout2.mDecorPadding.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.mSubDecorInstalled = true;
        PanelFeatureState panelState = getPanelState(0);
        if (this.mDestroyed || panelState.menu != null) {
            return;
        }
        invalidatePanelMenu(108);
    }

    public final void ensureWindow() {
        if (this.mWindow == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.mWindow == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final BaseMenuWrapper getAutoTimeNightModeManager(Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            if (MenuHostHelper.sInstance == null) {
                Context applicationContext = context.getApplicationContext();
                MenuHostHelper.sInstance = new MenuHostHelper(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(MenuHostHelper.sInstance);
        }
        return this.mAutoTimeNightModeManager;
    }

    public final PanelFeatureState getPanelState(int i) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState();
        panelFeatureState2.featureId = i;
        panelFeatureState2.refreshDecorView = false;
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity) obj, this.mOverlayActionBar);
            } else if (obj instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog) obj);
            }
            WindowDecorActionBar windowDecorActionBar = this.mActionBar;
            if (windowDecorActionBar != null) {
                windowDecorActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void installViewFactory() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted) {
            return;
        }
        View decorView = this.mWindow.getDecorView();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        decorView.postOnAnimation(this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
    }

    public final int mapNightMode(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.mAutoBatteryNightModeManager == null) {
                            this.mAutoBatteryNightModeManager = new AutoTimeNightModeManager(context);
                        }
                        return this.mAutoBatteryNightModeManager.getApplyableNightMode();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return getAutoTimeNightModeManager(context).getApplyableNightMode();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean onBackPressed() {
        DecorToolbar decorToolbar;
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter;
        boolean z = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState panelState = getPanelState(0);
        if (!panelState.isOpen) {
            ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
                return true;
            }
            initWindowDecorActionBar();
            WindowDecorActionBar windowDecorActionBar = this.mActionBar;
            if (windowDecorActionBar == null || (decorToolbar = windowDecorActionBar.mDecorToolbar) == null || (expandedActionViewMenuPresenter = ((ToolbarWidgetWrapper) decorToolbar).mToolbar.mExpandedMenuPresenter) == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) {
                return false;
            }
            Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter2 = ((ToolbarWidgetWrapper) decorToolbar).mToolbar.mExpandedMenuPresenter;
            MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter2 == null ? null : expandedActionViewMenuPresenter2.mCurrentExpandedItem;
            if (menuItemImpl != null) {
                menuItemImpl.collapseActionView();
            }
        } else if (!z) {
            closePanel(panelState, true);
            return true;
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onCreate() {
        String parentActivityName;
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false, true);
        ensureWindow();
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    parentActivityName = NavUtils.getParentActivityName(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                parentActivityName = null;
            }
            if (parentActivityName != null) {
                WindowDecorActionBar windowDecorActionBar = this.mActionBar;
                if (windowDecorActionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    windowDecorActionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
                AppCompatDelegate.sActivityDelegates.add(new WeakReference(this));
            }
        }
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View appCompatRatingBar;
        View view2 = null;
        if (this.mAppCompatViewInflater == null) {
            int[] iArr = R$styleable.AppCompatTheme;
            Context context2 = this.mContext;
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = typedArrayObtainStyledAttributes.getString(116);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.mAppCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.mAppCompatViewInflater = (AppCompatViewInflater) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.mAppCompatViewInflater = new AppCompatViewInflater();
                }
            }
        }
        AppCompatViewInflater appCompatViewInflater = this.mAppCompatViewInflater;
        int i = VectorEnabledTintResources.$r8$clinit;
        appCompatViewInflater.getClass();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.View, 0, 0);
        byte b = 4;
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes2.recycle();
        Context contextThemeWrapper = (resourceId == 0 || ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).mThemeResource == resourceId)) ? context : new ContextThemeWrapper(context, resourceId);
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                b = !str.equals("RatingBar") ? (byte) -1 : (byte) 0;
                break;
            case -1455429095:
                b = !str.equals("CheckedTextView") ? (byte) -1 : (byte) 1;
                break;
            case -1346021293:
                b = !str.equals("MultiAutoCompleteTextView") ? (byte) -1 : (byte) 2;
                break;
            case -938935918:
                b = !str.equals("TextView") ? (byte) -1 : (byte) 3;
                break;
            case -937446323:
                if (!str.equals("ImageButton")) {
                    b = -1;
                }
                break;
            case -658531749:
                b = !str.equals("SeekBar") ? (byte) -1 : (byte) 5;
                break;
            case -339785223:
                b = !str.equals("Spinner") ? (byte) -1 : (byte) 6;
                break;
            case 776382189:
                b = !str.equals("RadioButton") ? (byte) -1 : (byte) 7;
                break;
            case 799298502:
                b = !str.equals("ToggleButton") ? (byte) -1 : (byte) 8;
                break;
            case 1125864064:
                b = !str.equals("ImageView") ? (byte) -1 : (byte) 9;
                break;
            case 1413872058:
                b = !str.equals("AutoCompleteTextView") ? (byte) -1 : (byte) 10;
                break;
            case 1601505219:
                b = !str.equals("CheckBox") ? (byte) -1 : (byte) 11;
                break;
            case 1666676343:
                b = !str.equals("EditText") ? (byte) -1 : (byte) 12;
                break;
            case 2001146706:
                b = !str.equals("Button") ? (byte) -1 : (byte) 13;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                appCompatRatingBar = new AppCompatRatingBar(contextThemeWrapper, attributeSet);
                break;
            case 1:
                appCompatRatingBar = new AppCompatCheckedTextView(contextThemeWrapper, attributeSet);
                break;
            case 2:
                appCompatRatingBar = new AppCompatMultiAutoCompleteTextView(contextThemeWrapper, attributeSet);
                break;
            case 3:
                appCompatRatingBar = appCompatViewInflater.createTextView(contextThemeWrapper, attributeSet);
                break;
            case 4:
                appCompatRatingBar = new AppCompatImageButton(contextThemeWrapper, attributeSet, com.koala.clash.R.attr.imageButtonStyle);
                break;
            case 5:
                appCompatRatingBar = new AppCompatSeekBar(contextThemeWrapper, attributeSet);
                break;
            case 6:
                appCompatRatingBar = new AppCompatSpinner(contextThemeWrapper, attributeSet);
                break;
            case 7:
                appCompatRatingBar = appCompatViewInflater.createRadioButton(contextThemeWrapper, attributeSet);
                break;
            case 8:
                appCompatRatingBar = new AppCompatToggleButton(contextThemeWrapper, attributeSet);
                break;
            case 9:
                appCompatRatingBar = new AppCompatImageView(contextThemeWrapper, attributeSet);
                break;
            case 10:
                appCompatRatingBar = appCompatViewInflater.createAutoCompleteTextView(contextThemeWrapper, attributeSet);
                break;
            case 11:
                appCompatRatingBar = appCompatViewInflater.createCheckBox(contextThemeWrapper, attributeSet);
                break;
            case 12:
                appCompatRatingBar = new AppCompatEditText(contextThemeWrapper, attributeSet);
                break;
            case 13:
                appCompatRatingBar = appCompatViewInflater.createButton(contextThemeWrapper, attributeSet);
                break;
            default:
                appCompatRatingBar = null;
                break;
        }
        if (appCompatRatingBar != null || context == contextThemeWrapper) {
            view2 = appCompatRatingBar;
        } else {
            Object[] objArr = appCompatViewInflater.mConstructorArgs;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = contextThemeWrapper;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = AppCompatViewInflater.sClassPrefixList;
                        if (i2 < 3) {
                            View viewCreateViewByPrefix = appCompatViewInflater.createViewByPrefix(contextThemeWrapper, str, strArr[i2]);
                            if (viewCreateViewByPrefix != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = viewCreateViewByPrefix;
                            } else {
                                i2++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View viewCreateViewByPrefix2 = appCompatViewInflater.createViewByPrefix(contextThemeWrapper, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = viewCreateViewByPrefix2;
                }
            } catch (Exception unused) {
                objArr[0] = view2;
                objArr[1] = view2;
            } catch (Throwable th2) {
                objArr[0] = view2;
                objArr[1] = view2;
                throw th2;
            }
        }
        if (view2 != null) {
            Context context3 = view2.getContext();
            if ((context3 instanceof ContextWrapper) && view2.hasOnClickListeners()) {
                TypedArray typedArrayObtainStyledAttributes3 = context3.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sOnClickAttrs);
                String string2 = typedArrayObtainStyledAttributes3.getString(0);
                if (string2 != null) {
                    view2.setOnClickListener(new AppCompatViewInflater.DeclaredOnClickListener(view2, string2));
                }
                typedArrayObtainStyledAttributes3.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes4 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sAccessibilityHeading);
                if (typedArrayObtainStyledAttributes4.hasValue(0)) {
                    boolean z = typedArrayObtainStyledAttributes4.getBoolean(0, false);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    new ViewCompat.AnonymousClass1(com.koala.clash.R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).set(view2, Boolean.valueOf(z));
                }
                typedArrayObtainStyledAttributes4.recycle();
                TypedArray typedArrayObtainStyledAttributes5 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sAccessibilityPaneTitle);
                if (typedArrayObtainStyledAttributes5.hasValue(0)) {
                    ViewCompat.setAccessibilityPaneTitle(view2, typedArrayObtainStyledAttributes5.getString(0));
                }
                typedArrayObtainStyledAttributes5.recycle();
                TypedArray typedArrayObtainStyledAttributes6 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sScreenReaderFocusable);
                if (typedArrayObtainStyledAttributes6.hasValue(0)) {
                    boolean z2 = typedArrayObtainStyledAttributes6.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    new ViewCompat.AnonymousClass1(com.koala.clash.R.id.tag_screen_reader_focusable, Boolean.class, 0, 28, 0).set(view2, Boolean.valueOf(z2));
                }
                typedArrayObtainStyledAttributes6.recycle();
            }
        }
        return view2;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onDestroy() {
        if (this.mHost instanceof Activity) {
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
            }
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mDestroyed = true;
        if (this.mLocalNightMode != -100) {
            Object obj = this.mHost;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
            } else {
                sLocalNightModes.remove(this.mHost.getClass().getName());
            }
        } else {
            sLocalNightModes.remove(this.mHost.getClass().getName());
        }
        AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoTimeNightModeManager;
        if (autoTimeNightModeManager != null) {
            autoTimeNightModeManager.cleanup();
        }
        AutoTimeNightModeManager autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (autoTimeNightModeManager2 != null) {
            autoTimeNightModeManager2.cleanup();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002a  */
    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState panelFeatureState;
        Window.Callback callback = this.mWindow.getCallback();
        if (callback != null && !this.mDestroyed) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            PanelFeatureState[] panelFeatureStateArr = this.mPanels;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            for (int i = 0; i < length; i++) {
                panelFeatureState = panelFeatureStateArr[i];
                if (panelFeatureState != null && panelFeatureState.menu == rootMenu) {
                    if (panelFeatureState != null) {
                        return callback.onMenuItemSelected(panelFeatureState.featureId, menuItem);
                    }
                }
            }
            panelFeatureState = null;
            if (panelFeatureState != null) {
                return callback.onMenuItemSelected(panelFeatureState.featureId, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r6.isOverflowMenuShowing() != false) goto L20;
     */
    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMenuModeChange(androidx.appcompat.view.menu.MenuBuilder r6) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onMenuModeChange(androidx.appcompat.view.menu.MenuBuilder):void");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0175, code lost:
    
        if (r2.mAdapter.getCount() > 0) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void openPanel(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.openPanel(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public final boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.menu) != null) {
            return menuBuilder.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00da  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:79:0x0113  */
    public final boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        Resources.Theme themeNewTheme;
        DecorContentParent decorContentParent3;
        DecorContentParent decorContentParent4;
        if (!this.mDestroyed) {
            boolean z = panelFeatureState.isPrepared;
            int i = panelFeatureState.featureId;
            if (z) {
                return true;
            }
            PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
            if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
                closePanel(panelFeatureState2, false);
            }
            Window.Callback callback = this.mWindow.getCallback();
            if (callback != null) {
                panelFeatureState.createdPanelView = callback.onCreatePanelView(i);
            }
            boolean z2 = i == 0 || i == 108;
            if (z2 && (decorContentParent4 = this.mDecorContentParent) != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent4;
                actionBarOverlayLayout.pullChildren();
                ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mMenuPrepared = true;
            }
            if (panelFeatureState.createdPanelView == null) {
                MenuBuilder menuBuilder2 = panelFeatureState.menu;
                if (menuBuilder2 == null || panelFeatureState.refreshMenuContent) {
                    if (menuBuilder2 == null) {
                        Context context = this.mContext;
                        if ((i == 0 || i == 108) && this.mDecorContentParent != null) {
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme theme = context.getTheme();
                            theme.resolveAttribute(com.koala.clash.R.attr.actionBarTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                                themeNewTheme.resolveAttribute(com.koala.clash.R.attr.actionBarWidgetTheme, typedValue, true);
                            } else {
                                theme.resolveAttribute(com.koala.clash.R.attr.actionBarWidgetTheme, typedValue, true);
                                themeNewTheme = null;
                            }
                            if (typedValue.resourceId != 0) {
                                if (themeNewTheme == null) {
                                    themeNewTheme = context.getResources().newTheme();
                                    themeNewTheme.setTo(theme);
                                }
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                            }
                            if (themeNewTheme != null) {
                                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                                contextThemeWrapper.getTheme().setTo(themeNewTheme);
                                context = contextThemeWrapper;
                            }
                        }
                        MenuBuilder menuBuilder3 = new MenuBuilder(context);
                        menuBuilder3.mCallback = this;
                        MenuBuilder menuBuilder4 = panelFeatureState.menu;
                        if (menuBuilder3 != menuBuilder4) {
                            if (menuBuilder4 != null) {
                                menuBuilder4.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                            }
                            panelFeatureState.menu = menuBuilder3;
                            ListMenuPresenter listMenuPresenter = panelFeatureState.listMenuPresenter;
                            if (listMenuPresenter != null) {
                                menuBuilder3.addMenuPresenter(listMenuPresenter, menuBuilder3.mContext);
                            }
                        }
                        if (panelFeatureState.menu != null) {
                            if (z2 && (decorContentParent2 = this.mDecorContentParent) != null) {
                                if (this.mActionMenuPresenterCallback == null) {
                                    this.mActionMenuPresenterCallback = new AnonymousClass3();
                                }
                                ((ActionBarOverlayLayout) decorContentParent2).setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                            }
                            panelFeatureState.menu.stopDispatchingItemsChanged();
                            if (callback.onCreatePanelMenu(i, panelFeatureState.menu)) {
                                panelFeatureState.refreshMenuContent = false;
                            } else {
                                menuBuilder = panelFeatureState.menu;
                                if (menuBuilder != null) {
                                    if (menuBuilder != null) {
                                        menuBuilder.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                                    }
                                    panelFeatureState.menu = null;
                                }
                                if (z2 && (decorContentParent = this.mDecorContentParent) != null) {
                                    ((ActionBarOverlayLayout) decorContentParent).setMenu(null, this.mActionMenuPresenterCallback);
                                }
                            }
                        }
                    } else {
                        if (z2) {
                            if (this.mActionMenuPresenterCallback == null) {
                                this.mActionMenuPresenterCallback = new AnonymousClass3();
                            }
                            ((ActionBarOverlayLayout) decorContentParent2).setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                        }
                        panelFeatureState.menu.stopDispatchingItemsChanged();
                        if (callback.onCreatePanelMenu(i, panelFeatureState.menu)) {
                            menuBuilder = panelFeatureState.menu;
                            if (menuBuilder != null) {
                                if (menuBuilder != null) {
                                    menuBuilder.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                                }
                                panelFeatureState.menu = null;
                            }
                            if (z2) {
                                ((ActionBarOverlayLayout) decorContentParent).setMenu(null, this.mActionMenuPresenterCallback);
                            }
                        } else {
                            panelFeatureState.refreshMenuContent = false;
                        }
                    }
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                Bundle bundle = panelFeatureState.frozenActionViewState;
                if (bundle != null) {
                    panelFeatureState.menu.restoreActionViewStates(bundle);
                    panelFeatureState.frozenActionViewState = null;
                }
                if (!callback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                    if (z2 && (decorContentParent3 = this.mDecorContentParent) != null) {
                        ((ActionBarOverlayLayout) decorContentParent3).setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    panelFeatureState.menu.startDispatchingItemsChanged();
                    return false;
                }
                panelFeatureState.menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
                panelFeatureState.menu.startDispatchingItemsChanged();
            }
            panelFeatureState.isPrepared = true;
            panelFeatureState.isHandled = false;
            this.mPreparedPanel = panelFeatureState;
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.mWindowNoTitle && i == 108) {
            return false;
        }
        if (this.mHasActionBar && i == 1) {
            this.mHasActionBar = false;
        }
        if (i == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        }
        if (i == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        }
        if (i == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        }
        if (i == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        }
        if (i == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        }
        if (i != 109) {
            return this.mWindow.requestFeature(i);
        }
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        WindowDecorActionBar windowDecorActionBar = this.mActionBar;
        if (windowDecorActionBar == null) {
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) windowDecorActionBar.mDecorToolbar;
        if (toolbarWidgetWrapper.mTitleSet) {
            return;
        }
        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
        toolbarWidgetWrapper.mTitle = charSequence;
        if ((toolbarWidgetWrapper.mDisplayOpts & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (toolbarWidgetWrapper.mTitleSet) {
                ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void updateBackInvokedCallbackState() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.mDispatcher != null && (getPanelState(0).isOpen || this.mActionMode != null)) {
                z = true;
            }
            if (z && this.mBackCallback == null) {
                this.mBackCallback = Api33Impl.registerOnBackPressedCallback(this.mDispatcher, this);
            } else {
                if (z || (onBackInvokedCallback = this.mBackCallback) == null) {
                    return;
                }
                Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, onBackInvokedCallback);
                this.mBackCallback = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AutoTimeNightModeManager extends BaseMenuWrapper {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object mTwilightManager;

        public AutoTimeNightModeManager(MenuHostHelper menuHostHelper) {
            super(AppCompatDelegateImpl.this);
            this.mTwilightManager = menuHostHelper;
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final IntentFilter createIntentFilterForBroadcastReceiver() {
            switch (this.$r8$classId) {
                case 0:
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.TIME_SET");
                    intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                    intentFilter.addAction("android.intent.action.TIME_TICK");
                    return intentFilter;
                default:
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                    return intentFilter2;
            }
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final int getApplyableNightMode() {
            Location location;
            boolean z;
            long j;
            Location lastKnownLocation;
            switch (this.$r8$classId) {
                case 0:
                    MenuHostHelper menuHostHelper = (MenuHostHelper) this.mTwilightManager;
                    TwilightManager$TwilightState twilightManager$TwilightState = (TwilightManager$TwilightState) menuHostHelper.mProviderToLifecycleContainers;
                    LocationManager locationManager = (LocationManager) menuHostHelper.mMenuProviders;
                    if (twilightManager$TwilightState.nextUpdate <= System.currentTimeMillis()) {
                        Context context = (Context) menuHostHelper.mOnInvalidateMenuCallback;
                        Location lastKnownLocation2 = null;
                        if (PermissionChecker.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                            try {
                                lastKnownLocation = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                            } catch (Exception e) {
                                Log.d("TwilightManager", "Failed to get last known location", e);
                            }
                            location = lastKnownLocation;
                        } else {
                            location = null;
                        }
                        if (PermissionChecker.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            try {
                                if (locationManager.isProviderEnabled("gps")) {
                                    lastKnownLocation2 = locationManager.getLastKnownLocation("gps");
                                }
                            } catch (Exception e2) {
                                Log.d("TwilightManager", "Failed to get last known location", e2);
                            }
                        }
                        if (lastKnownLocation2 == null || location == null ? lastKnownLocation2 != null : lastKnownLocation2.getTime() > location.getTime()) {
                            location = lastKnownLocation2;
                        }
                        z = false;
                        if (location != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (TwilightCalculator.sInstance == null) {
                                TwilightCalculator.sInstance = new TwilightCalculator();
                            }
                            TwilightCalculator twilightCalculator = TwilightCalculator.sInstance;
                            twilightCalculator.calculateTwilight(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis - 86400000);
                            twilightCalculator.calculateTwilight(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis);
                            z = twilightCalculator.state == 1;
                            long j2 = twilightCalculator.sunrise;
                            long j3 = twilightCalculator.sunset;
                            twilightCalculator.calculateTwilight(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis + 86400000);
                            long j4 = twilightCalculator.sunrise;
                            if (j2 == -1 || j3 == -1) {
                                j = jCurrentTimeMillis + 43200000;
                            } else {
                                if (jCurrentTimeMillis > j3) {
                                    j2 = j4;
                                } else if (jCurrentTimeMillis > j2) {
                                    j2 = j3;
                                }
                                j = j2 + 60000;
                            }
                            twilightManager$TwilightState.isNight = z;
                            twilightManager$TwilightState.nextUpdate = j;
                        } else {
                            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                            int i = Calendar.getInstance().get(11);
                            if (i < 6 || i >= 22) {
                                z = true;
                            }
                        }
                        break;
                    } else {
                        z = twilightManager$TwilightState.isNight;
                    }
                    return z ? 2 : 1;
                default:
                    return Api21Impl.isPowerSaveMode((PowerManager) this.mTwilightManager) ? 2 : 1;
            }
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final void onChange() {
            switch (this.$r8$classId) {
                case 0:
                    AppCompatDelegateImpl.this.applyApplicationSpecificConfig(true, true);
                    break;
                default:
                    AppCompatDelegateImpl.this.applyApplicationSpecificConfig(true, true);
                    break;
            }
        }

        public AutoTimeNightModeManager(Context context) {
            super(AppCompatDelegateImpl.this);
            this.mTwilightManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
