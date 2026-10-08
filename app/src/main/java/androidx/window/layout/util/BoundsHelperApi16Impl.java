package androidx.window.layout.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import androidx.core.view.DisplayCutoutCompat$$ExternalSyntheticApiModelOutline0;
import androidx.window.core.Bounds;
import androidx.window.layout.WindowMetrics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BoundsHelperApi16Impl implements BoundsHelper, DensityCompatHelper, WindowMetricsCompatHelper {
    public static final BoundsHelperApi16Impl INSTANCE = new BoundsHelperApi16Impl(0);
    public static final BoundsHelperApi16Impl INSTANCE$1 = new BoundsHelperApi16Impl(1);
    public static final BoundsHelperApi16Impl INSTANCE$2 = new BoundsHelperApi16Impl(2);
    public static final BoundsHelperApi16Impl INSTANCE$3 = new BoundsHelperApi16Impl(3);
    public static final BoundsHelperApi16Impl INSTANCE$4 = new BoundsHelperApi16Impl(4);
    public static final BoundsHelperApi16Impl INSTANCE$5 = new BoundsHelperApi16Impl(5);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ BoundsHelperApi16Impl(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.window.layout.util.BoundsHelper
    public Rect currentWindowBounds(Activity activity) throws Exception {
        int i;
        DisplayCutout displayCutoutM = null;
        switch (this.$r8$classId) {
            case 0:
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                Rect rect = new Rect();
                int i2 = point.x;
                if (i2 == 0 || (i = point.y) == 0) {
                    defaultDisplay.getRectSize(rect);
                } else {
                    rect.right = i2;
                    rect.bottom = i;
                }
                return rect;
            case 1:
                Rect rect2 = new Rect();
                Display defaultDisplay2 = activity.getWindowManager().getDefaultDisplay();
                defaultDisplay2.getRectSize(rect2);
                if (!activity.isInMultiWindowMode()) {
                    Point point2 = new Point();
                    defaultDisplay2.getRealSize(point2);
                    Resources resources = activity.getResources();
                    int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    int i3 = rect2.bottom + dimensionPixelSize;
                    if (i3 == point2.y) {
                        rect2.bottom = i3;
                    } else {
                        int i4 = rect2.right + dimensionPixelSize;
                        if (i4 == point2.x) {
                            rect2.right = i4;
                        }
                    }
                }
                return rect2;
            case 2:
                Rect rect3 = new Rect();
                Configuration configuration = activity.getResources().getConfiguration();
                try {
                    Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(configuration);
                    if (activity.isInMultiWindowMode()) {
                        rect3.set((Rect) obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null));
                    } else {
                        rect3.set((Rect) obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null));
                    }
                    break;
                } catch (Exception e) {
                    if (!(e instanceof NoSuchFieldException) && !(e instanceof NoSuchMethodException) && !(e instanceof IllegalAccessException) && !(e instanceof InvocationTargetException)) {
                        throw e;
                    }
                    Log.w("BoundsHelper", e);
                    activity.getWindowManager().getDefaultDisplay().getRectSize(rect3);
                }
                Display defaultDisplay3 = activity.getWindowManager().getDefaultDisplay();
                Point point3 = new Point();
                defaultDisplay3.getRealSize(point3);
                if (!activity.isInMultiWindowMode()) {
                    Resources resources2 = activity.getResources();
                    int identifier2 = resources2.getIdentifier("navigation_bar_height", "dimen", "android");
                    int dimensionPixelSize2 = identifier2 > 0 ? resources2.getDimensionPixelSize(identifier2) : 0;
                    int i5 = rect3.bottom + dimensionPixelSize2;
                    if (i5 == point3.y) {
                        rect3.bottom = i5;
                    } else {
                        int i6 = rect3.right + dimensionPixelSize2;
                        if (i6 == point3.x) {
                            rect3.right = i6;
                        } else if (rect3.left == dimensionPixelSize2) {
                            rect3.left = 0;
                        }
                    }
                }
                if ((rect3.width() < point3.x || rect3.height() < point3.y) && !activity.isInMultiWindowMode()) {
                    try {
                        Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
                        constructor.setAccessible(true);
                        Object objNewInstance = constructor.newInstance(null);
                        Method declaredMethod = defaultDisplay3.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(defaultDisplay3, objNewInstance);
                        Field declaredField2 = objNewInstance.getClass().getDeclaredField("displayCutout");
                        declaredField2.setAccessible(true);
                        Object obj2 = declaredField2.get(objNewInstance);
                        if (DisplayCutoutCompat$$ExternalSyntheticApiModelOutline0.m755m(obj2)) {
                            displayCutoutM = DisplayCutoutCompat$$ExternalSyntheticApiModelOutline0.m(obj2);
                        }
                    } catch (Exception e2) {
                        if (!(e2 instanceof ClassNotFoundException) && !(e2 instanceof NoSuchMethodException) && !(e2 instanceof NoSuchFieldException) && !(e2 instanceof IllegalAccessException) && !(e2 instanceof InvocationTargetException) && !(e2 instanceof InstantiationException)) {
                            throw e2;
                        }
                        Log.w("BoundsHelper", e2);
                    }
                    if (displayCutoutM != null) {
                        if (rect3.left == displayCutoutM.getSafeInsetLeft()) {
                            rect3.left = 0;
                        }
                        if (point3.x - rect3.right == displayCutoutM.getSafeInsetRight()) {
                            rect3.right = displayCutoutM.getSafeInsetRight() + rect3.right;
                        }
                        if (rect3.top == displayCutoutM.getSafeInsetTop()) {
                            rect3.top = 0;
                        }
                        if (point3.y - rect3.bottom == displayCutoutM.getSafeInsetBottom()) {
                            rect3.bottom = displayCutoutM.getSafeInsetBottom() + rect3.bottom;
                        }
                    }
                    break;
                }
                return rect3;
            default:
                Configuration configuration2 = activity.getResources().getConfiguration();
                try {
                    Field declaredField3 = Configuration.class.getDeclaredField("windowConfiguration");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(configuration2);
                    return new Rect((Rect) obj3.getClass().getDeclaredMethod("getBounds", null).invoke(obj3, null));
                } catch (Exception e3) {
                    if (!(e3 instanceof NoSuchFieldException) && !(e3 instanceof NoSuchMethodException) && !(e3 instanceof IllegalAccessException) && !(e3 instanceof InvocationTargetException)) {
                        throw e3;
                    }
                    Log.w("BoundsHelper", e3);
                    return INSTANCE$2.currentWindowBounds(activity);
                }
        }
    }

    @Override // androidx.window.layout.util.WindowMetricsCompatHelper
    public WindowMetrics currentWindowMetrics(ContextWrapper contextWrapper, DensityCompatHelper densityCompatHelper) {
        BoundsHelper boundsHelper;
        Context baseContext = contextWrapper;
        while (true) {
            if (!(baseContext instanceof ContextWrapper)) {
                baseContext = contextWrapper;
                break;
            }
            if ((baseContext instanceof Activity) || (baseContext instanceof InputMethodService)) {
                break;
            }
            ContextWrapper contextWrapper2 = (ContextWrapper) baseContext;
            if (contextWrapper2.getBaseContext() == null) {
                break;
            }
            baseContext = contextWrapper2.getBaseContext();
        }
        if (!(baseContext instanceof Activity)) {
            if (!(baseContext instanceof InputMethodService) && !(baseContext instanceof Application)) {
                throw new IllegalArgumentException("Must provide a UiContext or Application Context");
            }
            Display defaultDisplay = ((WindowManager) contextWrapper.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            return new WindowMetrics(new Rect(0, 0, point.x, point.y), densityCompatHelper.density(contextWrapper));
        }
        Activity activity = (Activity) baseContext;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            boundsHelper = BoundsHelperApi30Impl.INSTANCE;
        } else if (i >= 29) {
            boundsHelper = INSTANCE$3;
        } else if (i >= 28) {
            boundsHelper = INSTANCE$2;
        } else {
            boundsHelper = i >= 24 ? INSTANCE$1 : INSTANCE;
        }
        return new WindowMetrics(new Bounds(boundsHelper.currentWindowBounds(activity)), densityCompatHelper.density(activity));
    }

    @Override // androidx.window.layout.util.DensityCompatHelper
    public float density(ContextWrapper contextWrapper) {
        return contextWrapper.getResources().getDisplayMetrics().density;
    }
}
