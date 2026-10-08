package androidx.compose.ui.platform;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.inputmethodservice.InputMethodService;
import android.os.Binder;
import android.os.Build;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityWithConverter;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.viewtree.ViewTree;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.WindowMetricsCalculatorCompat;
import androidx.window.layout.util.BoundsHelperApi16Impl;
import androidx.window.layout.util.BoundsHelperApi30Impl;
import androidx.window.layout.util.DensityCompatHelperApi34Impl;
import androidx.window.layout.util.WindowMetricsCompatHelper;
import coil.network.HttpException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class InvertMatrixKt implements ViewCompositionStrategy {
    public static final Class[] AcceptableClasses = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final boolean access$enabled(SemanticsNode semanticsNode) {
        return !semanticsNode.getConfig().props.containsKey(SemanticsProperties.Disabled);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x0046 A[SYNTHETIC] */
    public static final boolean access$excludeLineAndPageGranularities(SemanticsNode semanticsNode) {
        LayoutNode parent$ui;
        SemanticsConfiguration semanticsConfiguration;
        boolean zAreEqual;
        SemanticsConfiguration semanticsConfiguration2;
        if (!semanticsNode.unmergedConfig.props.containsKey(SemanticsProperties.EditableText)) {
            parent$ui = semanticsNode.layoutNode.getParent$ui();
            while (true) {
                if (parent$ui == null) {
                    parent$ui = null;
                    break;
                }
                semanticsConfiguration2 = parent$ui.getSemanticsConfiguration();
                if (semanticsConfiguration2 == null) {
                }
                parent$ui = parent$ui.getParent$ui();
            }
            if (parent$ui != null) {
                semanticsConfiguration = parent$ui.getSemanticsConfiguration();
                if (semanticsConfiguration != null) {
                    Object obj = semanticsConfiguration.props.get(SemanticsProperties.Focused);
                    zAreEqual = Intrinsics.areEqual(obj != null ? obj : null, Boolean.TRUE);
                } else {
                    zAreEqual = false;
                }
                if (!zAreEqual) {
                }
            }
            return false;
        }
        Object obj2 = semanticsNode.unmergedConfig.props.get(SemanticsProperties.Focused);
        if (obj2 == null) {
            obj2 = null;
        }
        if (Intrinsics.areEqual(obj2, Boolean.TRUE)) {
            parent$ui = semanticsNode.layoutNode.getParent$ui();
            while (true) {
                if (parent$ui == null) {
                    parent$ui = null;
                    break;
                }
                semanticsConfiguration2 = parent$ui.getSemanticsConfiguration();
                if (semanticsConfiguration2 == null && semanticsConfiguration2.isMergingSemanticsOfDescendants) {
                    if (semanticsConfiguration2.props.containsKey(SemanticsProperties.EditableText)) {
                        break;
                    }
                }
                parent$ui = parent$ui.getParent$ui();
            }
            if (parent$ui != null) {
                semanticsConfiguration = parent$ui.getSemanticsConfiguration();
                if (semanticsConfiguration != null) {
                    Object obj3 = semanticsConfiguration.props.get(SemanticsProperties.Focused);
                    zAreEqual = Intrinsics.areEqual(obj3 != null ? obj3 : null, Boolean.TRUE);
                } else {
                    zAreEqual = false;
                }
                if (!zAreEqual) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean access$isScreenReaderFocusable(SemanticsNode semanticsNode, Resources resources) {
        Object obj = semanticsNode.unmergedConfig.props.get(SemanticsProperties.ContentDescription);
        if (obj == null) {
            obj = null;
        }
        List list = (List) obj;
        return !SemanticsNodeKt.isHidden(semanticsNode) && (semanticsNode.unmergedConfig.isMergingSemanticsOfDescendants || (semanticsNode.isUnmergedLeafNode$ui() && ((list != null ? (String) CollectionsKt.firstOrNull(list) : null) != null || getInfoText(semanticsNode) != null || getInfoStateDescriptionOrNull(semanticsNode, resources) != null || getInfoIsCheckable(semanticsNode))));
    }

    public static final void addPageActions(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
        Object obj = semanticsConfiguration.props.get(SemanticsProperties.Role);
        if (obj == null) {
            obj = null;
        }
        Role role = (Role) obj;
        if (access$enabled(semanticsNode)) {
            if (role != null && role.value == 8) {
                return;
            }
            Object obj2 = mutableScatterMap.get(SemanticsActions.PageUp);
            if (obj2 == null) {
                obj2 = null;
            }
            AccessibilityAction accessibilityAction = (AccessibilityAction) obj2;
            if (accessibilityAction != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction.label, R.id.accessibilityActionPageUp));
            }
            Object obj3 = mutableScatterMap.get(SemanticsActions.PageDown);
            if (obj3 == null) {
                obj3 = null;
            }
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj3;
            if (accessibilityAction2 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction2.label, R.id.accessibilityActionPageDown));
            }
            Object obj4 = mutableScatterMap.get(SemanticsActions.PageLeft);
            if (obj4 == null) {
                obj4 = null;
            }
            AccessibilityAction accessibilityAction3 = (AccessibilityAction) obj4;
            if (accessibilityAction3 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction3.label, R.id.accessibilityActionPageLeft));
            }
            Object obj5 = mutableScatterMap.get(SemanticsActions.PageRight);
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) (obj5 != null ? obj5 : null);
            if (accessibilityAction4 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction4.label, R.id.accessibilityActionPageRight));
            }
        }
    }

    public static final void addSetProgressAction(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (access$enabled(semanticsNode)) {
            SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
            Object obj = semanticsConfiguration.props.get(SemanticsActions.SetProgress);
            if (obj == null) {
                obj = null;
            }
            AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
            if (accessibilityAction != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction.label, R.id.accessibilityActionSetProgress));
            }
        }
    }

    public static final DerivedSize calculateWindowSize(View view) {
        WindowMetricsCompatHelper windowMetricsCompatHelper;
        Context context = view.getContext();
        Context baseContext = context;
        while (true) {
            if (baseContext instanceof ContextWrapper) {
                if ((baseContext instanceof Activity) || (baseContext instanceof InputMethodService) || (baseContext instanceof Application)) {
                    break;
                }
                ContextWrapper contextWrapper = (ContextWrapper) baseContext;
                if (contextWrapper.getBaseContext() != null) {
                    baseContext = contextWrapper.getBaseContext();
                }
            }
            baseContext = null;
            break;
        }
        if (baseContext == null) {
            Configuration configuration = context.getResources().getConfiguration();
            DensityWithConverter densityWithConverterDensity = AndroidDensity_androidKt.Density(context);
            long jM706DpSizeYgX7TsA = DpKt.m706DpSizeYgX7TsA(configuration.screenWidthDp, configuration.screenHeightDp);
            return new DerivedSize(IntSizeKt.m723toIntSizeuvyYCjk(Density.CC.m699$default$toSizeXkaWNTQ(jM706DpSizeYgX7TsA, densityWithConverterDensity)), jM706DpSizeYgX7TsA);
        }
        WindowMetricsCalculator.Companion.getClass();
        WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.Companion.$$INSTANCE;
        WindowMetricsCalculatorCompat windowMetricsCalculatorCompat = WindowMetricsCalculator.Companion.windowMetricsCalculatorCompat;
        ContextWrapper contextWrapper2 = (ContextWrapper) baseContext;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            windowMetricsCompatHelper = DensityCompatHelperApi34Impl.INSTANCE$1;
        } else {
            windowMetricsCompatHelper = i >= 30 ? BoundsHelperApi30Impl.INSTANCE$1 : BoundsHelperApi16Impl.INSTANCE$5;
        }
        WindowMetrics windowMetricsCurrentWindowMetrics = windowMetricsCompatHelper.currentWindowMetrics(contextWrapper2, windowMetricsCalculatorCompat.densityCompatHelper);
        long jWidth = (((long) windowMetricsCurrentWindowMetrics.getBounds().width()) << 32) | (((long) windowMetricsCurrentWindowMetrics.getBounds().height()) & 4294967295L);
        return new DerivedSize(jWidth, Density.CC.m697$default$toDpSizekrfVVM(IntSizeKt.m724toSizeozmzZPI(jWidth), AndroidDensity_androidKt.Density(baseContext)));
    }

    public static final boolean canBeSavedToBundle(Object obj) {
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE || snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE$3 || snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE$1) {
                Object value = snapshotMutableState.getValue();
                if (value == null) {
                    return true;
                }
                return canBeSavedToBundle(value);
            }
        } else {
            if ((obj instanceof Function) && (obj instanceof Serializable)) {
                return false;
            }
            for (int i = 0; i < 7; i++) {
                if (AcceptableClasses[i].isInstance(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    public static final float m610dotp89u6pk(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = i * 4;
        return (fArr[i3 + 3] * fArr2[12 + i2]) + (fArr[i3 + 2] * fArr2[8 + i2]) + (fArr[i3 + 1] * fArr2[4 + i2]) + (fArr[i3] * fArr2[i2]);
    }

    public static final int findDepthToTag(View view, int i) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        Object obj = null;
        while (view != null) {
            Object tag = view.getTag(i);
            if (tag != null) {
                if (obj != null) {
                    if (!tag.equals(obj)) {
                        break;
                    }
                } else {
                    obj = tag;
                }
                i3 = i2;
            }
            i2++;
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return i3;
    }

    public static final View findViewTreeComposeViewRoot(View view) {
        if (!view.isAttachedToWindow()) {
            return view;
        }
        int iMin = Math.min(findDepthToTag(view, com.koala.clash.R.id.view_tree_lifecycle_owner), findDepthToTag(view, com.koala.clash.R.id.view_tree_saved_state_registry_owner));
        View view2 = view;
        int i = 0;
        View view3 = view2;
        while (view != null) {
            if (i == iMin) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return view2;
                }
            } else if (getComposeViewContext(view) == null) {
                i++;
                Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
                View view4 = view2;
                view2 = view;
                view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
                view3 = view4;
            }
            return view;
        }
        return view3;
    }

    public static final ComposeViewContext getComposeViewContext(View view) {
        Object tag = view.getTag(com.koala.clash.R.id.androidx_compose_ui_view_compose_view_context);
        WeakReference weakReference = tag instanceof WeakReference ? (WeakReference) tag : null;
        if (weakReference != null) {
            return (ComposeViewContext) weakReference.get();
        }
        return null;
    }

    public static final boolean getInfoIsCheckable(SemanticsNode semanticsNode) {
        Object obj = semanticsNode.unmergedConfig.props.get(SemanticsProperties.ToggleableState);
        if (obj == null) {
            obj = null;
        }
        ToggleableState toggleableState = (ToggleableState) obj;
        MutableScatterMap mutableScatterMap = semanticsNode.unmergedConfig.props;
        Object obj2 = mutableScatterMap.get(SemanticsProperties.Role);
        if (obj2 == null) {
            obj2 = null;
        }
        Role role = (Role) obj2;
        boolean z = toggleableState != null;
        Object obj3 = mutableScatterMap.get(SemanticsProperties.Selected);
        if (((Boolean) (obj3 != null ? obj3 : null)) == null || (role != null && role.value == 4)) {
            return z;
        }
        return true;
    }

    public static final String getInfoStateDescriptionOrNull(SemanticsNode semanticsNode, Resources resources) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        SemanticsConfiguration semanticsConfiguration2 = semanticsNode.unmergedConfig;
        Object string = semanticsConfiguration.props.get(SemanticsProperties.StateDescription);
        String string2 = null;
        if (string == null) {
            string = null;
        }
        MutableScatterMap mutableScatterMap = semanticsConfiguration2.props;
        Object obj = mutableScatterMap.get(SemanticsProperties.ToggleableState);
        if (obj == null) {
            obj = null;
        }
        ToggleableState toggleableState = (ToggleableState) obj;
        Object obj2 = mutableScatterMap.get(SemanticsProperties.Role);
        if (obj2 == null) {
            obj2 = null;
        }
        Role role = (Role) obj2;
        if (toggleableState != null) {
            int iOrdinal = toggleableState.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        throw new HttpException();
                    }
                    if (string == null) {
                        string = resources.getString(com.koala.clash.R.string.indeterminate);
                    }
                } else if (role != null && role.value == 2 && string == null) {
                    string = resources.getString(com.koala.clash.R.string.state_off);
                }
            } else if (role != null && role.value == 2 && string == null) {
                string = resources.getString(com.koala.clash.R.string.state_on);
            }
        }
        Object obj3 = mutableScatterMap.get(SemanticsProperties.Selected);
        if (obj3 == null) {
            obj3 = null;
        }
        Boolean bool = (Boolean) obj3;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if ((role == null || role.value != 4) && string == null) {
                string = zBooleanValue ? resources.getString(com.koala.clash.R.string.selected) : resources.getString(com.koala.clash.R.string.not_selected);
            }
        }
        Object obj4 = mutableScatterMap.get(SemanticsProperties.ProgressBarRangeInfo);
        if (obj4 == null) {
            obj4 = null;
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) obj4;
        if (progressBarRangeInfo != null) {
            if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                if (string == null) {
                    string = resources.getString(com.koala.clash.R.string.template_percent, 0);
                }
            } else if (string == null) {
                string = resources.getString(com.koala.clash.R.string.in_progress);
            }
        }
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.EditableText;
        if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
            MutableScatterMap mutableScatterMap2 = new SemanticsNode(semanticsNode.outerSemanticsNode, true, semanticsNode.layoutNode, semanticsConfiguration2).getConfig().props;
            Object obj5 = mutableScatterMap2.get(SemanticsProperties.ContentDescription);
            if (obj5 == null) {
                obj5 = null;
            }
            Collection collection = (Collection) obj5;
            if (collection == null || collection.isEmpty()) {
                Object obj6 = mutableScatterMap2.get(SemanticsProperties.Text);
                if (obj6 == null) {
                    obj6 = null;
                }
                Collection collection2 = (Collection) obj6;
                if (collection2 == null || collection2.isEmpty()) {
                    Object obj7 = mutableScatterMap2.get(semanticsPropertyKey);
                    if (obj7 == null) {
                        obj7 = null;
                    }
                    CharSequence charSequence = (CharSequence) obj7;
                    if (charSequence == null || charSequence.length() == 0) {
                        string2 = resources.getString(com.koala.clash.R.string.state_empty);
                    }
                }
            }
            string = string2;
        }
        return (String) string;
    }

    public static final AnnotatedString getInfoText(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        AnnotatedString annotatedString = (AnnotatedString) SemanticsNodeKt.getOrNull(semanticsConfiguration, SemanticsProperties.EditableText);
        List list = (List) SemanticsNodeKt.getOrNull(semanticsNode.unmergedConfig, SemanticsProperties.Text);
        return annotatedString == null ? list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null : annotatedString;
    }

    public static boolean getIsShowingLayoutBounds() {
        try {
            if (AndroidComposeView.systemPropertiesClass == null) {
                AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
            }
            if (AndroidComposeView.getBooleanMethod == null) {
                Class cls = AndroidComposeView.systemPropertiesClass;
                AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
            }
            Method method = AndroidComposeView.getBooleanMethod;
            Object objInvoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
            return Intrinsics.areEqual(objInvoke instanceof Boolean ? (Boolean) objInvoke : null, Boolean.TRUE);
        } catch (Exception unused) {
            return false;
        }
    }

    public static final TextLayoutResult getTextLayoutResult(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        Object obj = semanticsConfiguration.props.get(SemanticsActions.GetTextLayoutResult);
        if (obj == null) {
            obj = null;
        }
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.action) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (TextLayoutResult) arrayList.get(0);
    }

    /* JADX INFO: renamed from: invertTo-JiSxe2E, reason: not valid java name */
    public static final boolean m611invertToJiSxe2E(float[] fArr, float[] fArr2) {
        if (fArr.length < 16 || fArr2.length < 16) {
            return false;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        float f10 = fArr[9];
        float f11 = fArr[10];
        float f12 = fArr[11];
        float f13 = fArr[12];
        float f14 = fArr[13];
        float f15 = fArr[14];
        float f16 = fArr[15];
        float f17 = (f * f6) - (f2 * f5);
        float f18 = (f * f7) - (f3 * f5);
        float f19 = (f * f8) - (f4 * f5);
        float f20 = (f2 * f7) - (f3 * f6);
        float f21 = (f2 * f8) - (f4 * f6);
        float f22 = (f3 * f8) - (f4 * f7);
        float f23 = (f9 * f14) - (f10 * f13);
        float f24 = (f9 * f15) - (f11 * f13);
        float f25 = (f9 * f16) - (f12 * f13);
        float f26 = (f10 * f15) - (f11 * f14);
        float f27 = (f10 * f16) - (f12 * f14);
        float f28 = (f11 * f16) - (f12 * f15);
        float f29 = (f22 * f23) + (((f20 * f25) + ((f19 * f26) + ((f17 * f28) - (f18 * f27)))) - (f21 * f24));
        if (f29 != 0.0f) {
            float f30 = 1.0f / f29;
            fArr2[0] = ((f8 * f26) + ((f6 * f28) - (f7 * f27))) * f30;
            fArr2[1] = (((f3 * f27) + ((-f2) * f28)) - (f4 * f26)) * f30;
            fArr2[2] = ((f16 * f20) + ((f14 * f22) - (f15 * f21))) * f30;
            fArr2[3] = (((f11 * f21) + ((-f10) * f22)) - (f12 * f20)) * f30;
            float f31 = -f5;
            fArr2[4] = (((f7 * f25) + (f31 * f28)) - (f8 * f24)) * f30;
            fArr2[5] = ((f4 * f24) + ((f28 * f) - (f3 * f25))) * f30;
            float f32 = -f13;
            fArr2[6] = (((f15 * f19) + (f32 * f22)) - (f16 * f18)) * f30;
            fArr2[7] = ((f12 * f18) + ((f22 * f9) - (f11 * f19))) * f30;
            fArr2[8] = ((f8 * f23) + ((f5 * f27) - (f6 * f25))) * f30;
            fArr2[9] = (((f25 * f2) + ((-f) * f27)) - (f4 * f23)) * f30;
            fArr2[10] = ((f16 * f17) + ((f13 * f21) - (f14 * f19))) * f30;
            fArr2[11] = (((f19 * f10) + ((-f9) * f21)) - (f12 * f17)) * f30;
            fArr2[12] = (((f6 * f24) + (f31 * f26)) - (f7 * f23)) * f30;
            fArr2[13] = ((f3 * f23) + ((f * f26) - (f2 * f24))) * f30;
            fArr2[14] = (((f14 * f18) + (f32 * f20)) - (f15 * f17)) * f30;
            fArr2[15] = ((f11 * f17) + ((f9 * f20) - (f10 * f18))) * f30;
        }
        return !(f29 == 0.0f);
    }

    public static final boolean isInPath(float f, float f2, AndroidPath androidPath) {
        Rect rect = new Rect(f - 0.005f, f2 - 0.005f, f + 0.005f, f2 + 0.005f);
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        Modifier.CC.addRect$default(androidPathPath, rect);
        AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
        androidPathPath2.m409opN5in7k0(androidPath, androidPathPath, 1);
        boolean zIsEmpty = androidPathPath2.internalPath.isEmpty();
        androidPathPath2.reset();
        androidPathPath.reset();
        return !zIsEmpty;
    }

    /* JADX INFO: renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    public static final boolean m612isWithinEllipseVE1yxkc(float f, float f2, float f3, float f4, long j) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return ((f6 * f6) / (fIntBitsToFloat2 * fIntBitsToFloat2)) + ((f5 * f5) / (fIntBitsToFloat * fIntBitsToFloat)) <= 1.0f;
    }

    /* JADX INFO: renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m613preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float fM610dotp89u6pk = m610dotp89u6pk(fArr2, 0, fArr, 0);
        float fM610dotp89u6pk2 = m610dotp89u6pk(fArr2, 0, fArr, 1);
        float fM610dotp89u6pk3 = m610dotp89u6pk(fArr2, 0, fArr, 2);
        float fM610dotp89u6pk4 = m610dotp89u6pk(fArr2, 0, fArr, 3);
        float fM610dotp89u6pk5 = m610dotp89u6pk(fArr2, 1, fArr, 0);
        float fM610dotp89u6pk6 = m610dotp89u6pk(fArr2, 1, fArr, 1);
        float fM610dotp89u6pk7 = m610dotp89u6pk(fArr2, 1, fArr, 2);
        float fM610dotp89u6pk8 = m610dotp89u6pk(fArr2, 1, fArr, 3);
        float fM610dotp89u6pk9 = m610dotp89u6pk(fArr2, 2, fArr, 0);
        float fM610dotp89u6pk10 = m610dotp89u6pk(fArr2, 2, fArr, 1);
        float fM610dotp89u6pk11 = m610dotp89u6pk(fArr2, 2, fArr, 2);
        float fM610dotp89u6pk12 = m610dotp89u6pk(fArr2, 2, fArr, 3);
        float fM610dotp89u6pk13 = m610dotp89u6pk(fArr2, 3, fArr, 0);
        float fM610dotp89u6pk14 = m610dotp89u6pk(fArr2, 3, fArr, 1);
        float fM610dotp89u6pk15 = m610dotp89u6pk(fArr2, 3, fArr, 2);
        float fM610dotp89u6pk16 = m610dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = fM610dotp89u6pk;
        fArr[1] = fM610dotp89u6pk2;
        fArr[2] = fM610dotp89u6pk3;
        fArr[3] = fM610dotp89u6pk4;
        fArr[4] = fM610dotp89u6pk5;
        fArr[5] = fM610dotp89u6pk6;
        fArr[6] = fM610dotp89u6pk7;
        fArr[7] = fM610dotp89u6pk8;
        fArr[8] = fM610dotp89u6pk9;
        fArr[9] = fM610dotp89u6pk10;
        fArr[10] = fM610dotp89u6pk11;
        fArr[11] = fM610dotp89u6pk12;
        fArr[12] = fM610dotp89u6pk13;
        fArr[13] = fM610dotp89u6pk14;
        fArr[14] = fM610dotp89u6pk15;
        fArr[15] = fM610dotp89u6pk16;
    }

    public static final void semanticsIdToView(AndroidViewsHandler androidViewsHandler, int i) {
        Object next;
        Iterator<T> it = androidViewsHandler.getLayoutNodeToHolder().entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((LayoutNode) ((Map.Entry) next).getKey()).semanticsId != i);
        Map.Entry entry = (Map.Entry) next;
        if (entry != null && entry.getValue() != null) {
            throw new ClassCastException();
        }
    }

    public static final String simpleIdentityToString(Object obj) {
        return (obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName()) + '@' + String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
    }

    /* JADX INFO: renamed from: toLegacyClassName-V4PA4sw, reason: not valid java name */
    public static final String m614toLegacyClassNameV4PA4sw(int i) {
        if (i == 0) {
            return "android.widget.Button";
        }
        if (i == 1) {
            return "android.widget.CheckBox";
        }
        if (i == 3) {
            return "android.widget.RadioButton";
        }
        if (i == 5) {
            return "android.widget.ImageView";
        }
        if (i == 6) {
            return "android.widget.Spinner";
        }
        if (i == 7) {
            return "android.widget.NumberPicker";
        }
        return null;
    }
}
