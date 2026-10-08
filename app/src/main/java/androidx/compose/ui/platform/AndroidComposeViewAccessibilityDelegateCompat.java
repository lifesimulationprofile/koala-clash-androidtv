package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.collection.ArraySet;
import androidx.collection.IntIntMapKt;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsSortKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.navigation.Navigator;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import coil.network.HttpException;
import coil.request.Parameters;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat implements View.OnAttachStateChangeListener, android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener, android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener {
    public static final MutableIntList AccessibilityActionsResourceIds;
    public final String ExtraDataTestTraversalAfterVal;
    public final String ExtraDataTestTraversalBeforeVal;
    public List _enabledServices;
    public int accessibilityCursorPosition;
    public int accessibilityFocusedVirtualViewId;
    public final android.view.accessibility.AccessibilityManager accessibilityManager;
    public final SparseArrayCompat actionIdToLabel;
    public final BufferedChannel boundsUpdateChannel;
    public boolean checkingForSemanticsChanges;
    public MutableIntObjectMap currentSemanticsNodes;
    public boolean currentSemanticsNodesInvalidated;
    public AccessibilityNodeInfoCompat currentlyAccessibilityFocusedANI;
    public AccessibilityNodeInfoCompat currentlyFocusedANI;
    public final MutableIntIntMap drawingOrder;
    public int focusedVirtualViewId;
    public final MutableIntIntMap idToAfterMap;
    public final MutableIntIntMap idToBeforeMap;
    public final SparseArrayCompat labelToActionId;
    public final ExploreByTouchHelper.MyNodeProvider nodeProvider;
    public final MutableIntSet paneDisplayed;
    public final MutableIntObjectMap pendingHorizontalScrollEvents;
    public PendingTextTraversedEvent pendingTextTraversedEvent;
    public final MutableIntObjectMap pendingVerticalScrollEvents;
    public final MutableIntObjectMap previousSemanticsNodes;
    public SemanticsNodeCopy previousSemanticsRoot;
    public Integer previousTraversedNode;
    public final AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1 scheduleScrollEventIfNeededLambda;
    public final ArrayList scrollObservationScopes;
    public final Preview$$ExternalSyntheticLambda0 semanticsChangeChecker;
    public boolean sendingFocusAffectingEvent;
    public final ArraySet subtreeChangedLayoutNodes;
    public final MenuHostHelper urlSpanCache;
    public final AndroidComposeView view;
    public int hoveredVirtualViewId = Integer.MIN_VALUE;
    public final AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1 onSendAccessibilityEvent = new AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1(this, 0);
    public long SendRecurringAccessibilityEventsIntervalMillis = 100;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class PendingTextTraversedEvent {
        public final int action;
        public final int fromIndex;
        public final int granularity;
        public final SemanticsNode node;
        public final int toIndex;
        public final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }
    }

    static {
        int[] iArr = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        MutableIntList mutableIntList = IntListKt.EmptyIntList;
        MutableIntList mutableIntList2 = new MutableIntList(32);
        int i = mutableIntList2._size;
        if (i < 0) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
            throw null;
        }
        int i2 = i + 32;
        mutableIntList2.ensureCapacity(i2);
        int[] iArr2 = mutableIntList2.content;
        int i3 = mutableIntList2._size;
        if (i != i3) {
            ArraysKt.copyInto(i2, i, i3, iArr2, iArr2);
        }
        ArraysKt.copyInto$default(i, 0, 12, iArr, iArr2);
        mutableIntList2._size += 32;
        AccessibilityActionsResourceIds = mutableIntList2;
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) androidComposeView.getContext().getSystemService("accessibility");
        new Handler(Looper.getMainLooper());
        int i = 1;
        this.nodeProvider = new ExploreByTouchHelper.MyNodeProvider(this, i);
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap();
        this.pendingVerticalScrollEvents = new MutableIntObjectMap();
        this.actionIdToLabel = new SparseArrayCompat(0);
        this.labelToActionId = new SparseArrayCompat(0);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet(0);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, 0, 6);
        this.currentSemanticsNodesInvalidated = true;
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        this.currentSemanticsNodes = mutableIntObjectMap;
        this.paneDisplayed = new MutableIntSet();
        this.idToBeforeMap = new MutableIntIntMap();
        this.idToAfterMap = new MutableIntIntMap();
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new MenuHostHelper(27);
        this.previousSemanticsNodes = new MutableIntObjectMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), mutableIntObjectMap);
        int i2 = IntIntMapKt.$r8$clinit;
        this.drawingOrder = new MutableIntIntMap();
        androidComposeView.addOnAttachStateChangeListener(this);
        this.semanticsChangeChecker = new Preview$$ExternalSyntheticLambda0(28, this);
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1(this, i);
    }

    public static String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode != null) {
            SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
            if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                return ListUtilsKt.fastJoinToString$default((List) semanticsConfiguration.get(semanticsPropertyKey), ",", null, 62);
            }
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.EditableText;
            if (mutableScatterMap.containsKey(semanticsPropertyKey2)) {
                Object obj = mutableScatterMap.get(semanticsPropertyKey2);
                if (obj == null) {
                    obj = null;
                }
                AnnotatedString annotatedString2 = (AnnotatedString) obj;
                if (annotatedString2 != null) {
                    return annotatedString2.text;
                }
            } else {
                Object obj2 = mutableScatterMap.get(SemanticsProperties.Text);
                if (obj2 == null) {
                    obj2 = null;
                }
                List list = (List) obj2;
                if (list != null && (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) != null) {
                    return annotatedString.text;
                }
            }
        }
        return null;
    }

    public static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        Function0 function0 = scrollAxisRange.value;
        if (f >= 0.0f || ((Number) function0.invoke()).floatValue() <= 0.0f) {
            return f > 0.0f && ((Number) function0.invoke()).floatValue() < ((Number) scrollAxisRange.maxValue.invoke()).floatValue();
        }
        return true;
    }

    public static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        Function0 function0 = scrollAxisRange.value;
        boolean z = scrollAxisRange.reverseScrolling;
        if (((Number) function0.invoke()).floatValue() <= 0.0f || z) {
            return ((Number) function0.invoke()).floatValue() < ((Number) scrollAxisRange.maxValue.invoke()).floatValue() && z;
        }
        return true;
    }

    public static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        Function0 function0 = scrollAxisRange.value;
        boolean z = scrollAxisRange.reverseScrolling;
        if (((Number) function0.invoke()).floatValue() >= ((Number) scrollAxisRange.maxValue.invoke()).floatValue() || z) {
            return ((Number) function0.invoke()).floatValue() > 0.0f && z;
        }
        return true;
    }

    public static /* synthetic */ void sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, int i3) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, null);
    }

    public static Rect toAndroidRect(BrushKt brushKt, float f, float f2) {
        if (!(brushKt instanceof Outline$Rectangle) && !(brushKt instanceof Outline$Rounded)) {
            return null;
        }
        androidx.compose.ui.geometry.Rect bounds = brushKt.getBounds();
        return new Rect((int) (bounds.left + f), (int) (bounds.top + f2), (int) (bounds.right + f), (int) (bounds.bottom + f2));
    }

    public static float[] toCornerArray(BrushKt brushKt) {
        if (!(brushKt instanceof Outline$Rounded)) {
            return null;
        }
        RoundRect roundRect = ((Outline$Rounded) brushKt).roundRect;
        long j = roundRect.bottomLeftCornerRadius;
        long j2 = roundRect.bottomRightCornerRadius;
        long j3 = roundRect.topRightCornerRadius;
        long j4 = roundRect.topLeftCornerRadius;
        return new float[]{Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L))};
    }

    public static Region toRegion(BrushKt brushKt, float f, float f2) {
        if (!(brushKt instanceof Outline$Generic)) {
            return null;
        }
        Outline$Generic outline$Generic = (Outline$Generic) brushKt;
        androidx.compose.ui.geometry.Rect rectTranslate = outline$Generic.getBounds().translate(f, f2);
        Region region = new Region(new Rect((int) (rectTranslate.left + 0.0f), (int) (rectTranslate.top + 0.0f), (int) (rectTranslate.right + 0.0f), (int) (rectTranslate.bottom + 0.0f)));
        Region region2 = new Region();
        AndroidPath androidPath = outline$Generic.path;
        if (!(androidPath instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        Path path = androidPath.internalPath;
        path.offset(f, f2);
        region2.setPath(path, region);
        return region2;
    }

    public static CharSequence trimToSize(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            int i = 100000;
            if (charSequence.length() > 100000) {
                if (Character.isHighSurrogate(charSequence.charAt(99999)) && Character.isLowSurrogate(charSequence.charAt(100000))) {
                    i = 99999;
                }
                return charSequence.subSequence(0, i);
            }
        }
        return charSequence;
    }

    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        SemanticsNode semanticsNode;
        RectF rectF;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) getCurrentSemanticsNodes().get(i);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.semanticsNode) == null) {
            return;
        }
        LayoutNode layoutNode = semanticsNode.layoutNode;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (Intrinsics.areEqual(str, this.ExtraDataTestTraversalBeforeVal)) {
            int orDefault = this.idToBeforeMap.getOrDefault(i, -1);
            if (orDefault != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, orDefault);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, this.ExtraDataTestTraversalAfterVal)) {
            int orDefault2 = this.idToAfterMap.getOrDefault(i, -1);
            if (orDefault2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, orDefault2);
                return;
            }
            return;
        }
        boolean zContainsKey = mutableScatterMap.containsKey(SemanticsActions.GetTextLayoutResult);
        AndroidComposeView androidComposeView = this.view;
        boolean z = false;
        if (zContainsKey && bundle != null && Intrinsics.areEqual(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            int i2 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int i3 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (i3 > 0 && i2 >= 0) {
                if (i2 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                    TextLayoutResult textLayoutResult = InvertMatrixKt.getTextLayoutResult(semanticsConfiguration);
                    if (textLayoutResult == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    int i4 = 0;
                    while (i4 < i3) {
                        int i5 = i2 + i4;
                        if (i5 >= textLayoutResult.layoutInput.text.text.length()) {
                            arrayList.add(z);
                            androidComposeView = androidComposeView;
                        } else {
                            androidx.compose.ui.geometry.Rect boundingBox = textLayoutResult.getBoundingBox(i5);
                            NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode.findCoordinatorToGetBounds$ui();
                            long jMo525localToRootMKHz9U = 0;
                            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                                if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                                    nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
                                }
                                if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                                    jMo525localToRootMKHz9U = nodeCoordinatorFindCoordinatorToGetBounds$ui.mo525localToRootMKHz9U(0L);
                                }
                            }
                            androidx.compose.ui.geometry.Rect rectM381translatek4lQ0M = boundingBox.m381translatek4lQ0M(jMo525localToRootMKHz9U);
                            androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                            androidx.compose.ui.geometry.Rect rectIntersect = rectM381translatek4lQ0M.overlaps(boundsInRoot) ? rectM381translatek4lQ0M.intersect(boundsInRoot) : null;
                            if (rectIntersect != null) {
                                long jM590localToScreenMKHz9U = androidComposeView.m590localToScreenMKHz9U((((long) Float.floatToRawIntBits(rectIntersect.top)) & 4294967295L) | (((long) Float.floatToRawIntBits(rectIntersect.left)) << 32));
                                long jM590localToScreenMKHz9U2 = androidComposeView.m590localToScreenMKHz9U((((long) Float.floatToRawIntBits(rectIntersect.right)) << 32) | (((long) Float.floatToRawIntBits(rectIntersect.bottom)) & 4294967295L));
                                int i6 = (int) (jM590localToScreenMKHz9U >> 32);
                                int i7 = (int) (jM590localToScreenMKHz9U2 >> 32);
                                float fMin = Math.min(Float.intBitsToFloat(i6), Float.intBitsToFloat(i7));
                                int i8 = (int) (jM590localToScreenMKHz9U & 4294967295L);
                                int i9 = (int) (jM590localToScreenMKHz9U2 & 4294967295L);
                                rectF = new RectF(fMin, Math.min(Float.intBitsToFloat(i8), Float.intBitsToFloat(i9)), Math.max(Float.intBitsToFloat(i6), Float.intBitsToFloat(i7)), Math.max(Float.intBitsToFloat(i8), Float.intBitsToFloat(i9)));
                            } else {
                                rectF = null;
                            }
                            arrayList.add(rectF);
                        }
                        i4++;
                        androidComposeView = androidComposeView;
                        z = false;
                    }
                    accessibilityNodeInfo.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                    return;
                }
            }
            Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
            return;
        }
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TestTag;
        if (mutableScatterMap.containsKey(semanticsPropertyKey) && bundle != null && Intrinsics.areEqual(str, "androidx.compose.ui.semantics.testTag")) {
            Object obj = mutableScatterMap.get(semanticsPropertyKey);
            String str2 = (String) (obj == null ? null : obj);
            if (str2 != null) {
                accessibilityNodeInfo.getExtras().putCharSequence(str, str2);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.id")) {
            accessibilityNodeInfo.getExtras().putInt(str, semanticsNode.id);
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.shapeType")) {
            Object obj2 = mutableScatterMap.get(SemanticsProperties.Shape);
            Shape shape = (Shape) (obj2 == null ? null : obj2);
            if (shape != null) {
                Rect rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                androidx.compose.ui.geometry.Rect shapeBounds = getShapeBounds(semanticsNode, rect, shape);
                float f = shapeBounds.top;
                float f2 = shapeBounds.left;
                BrushKt brushKtMo60createOutlinePq9zytI = shape.mo60createOutlinePq9zytI(shapeBounds.m379getSizeNHjbRc(), layoutNode.layoutDirection, androidComposeView.getDensity());
                if (brushKtMo60createOutlinePq9zytI instanceof Outline$Rectangle) {
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 0);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", toAndroidRect(brushKtMo60createOutlinePq9zytI, f2, f));
                    return;
                } else if (brushKtMo60createOutlinePq9zytI instanceof Outline$Rounded) {
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 1);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", toAndroidRect(brushKtMo60createOutlinePq9zytI, f2, f));
                    accessibilityNodeInfo.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", toCornerArray(brushKtMo60createOutlinePq9zytI));
                    return;
                } else {
                    if (!(brushKtMo60createOutlinePq9zytI instanceof Outline$Generic)) {
                        throw new HttpException();
                    }
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 2);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", toRegion(brushKtMo60createOutlinePq9zytI, f2, f));
                    return;
                }
            }
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.shapeRect")) {
            Object obj3 = mutableScatterMap.get(SemanticsProperties.Shape);
            Shape shape2 = (Shape) (obj3 == null ? null : obj3);
            if (shape2 != null) {
                Rect rect2 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect2);
                androidx.compose.ui.geometry.Rect shapeBounds2 = getShapeBounds(semanticsNode, rect2, shape2);
                Rect androidRect = toAndroidRect(shape2.mo60createOutlinePq9zytI(shapeBounds2.m379getSizeNHjbRc(), layoutNode.layoutDirection, androidComposeView.getDensity()), shapeBounds2.left, shapeBounds2.top);
                if (androidRect != null) {
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", androidRect);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.shapeCorners")) {
            Object obj4 = mutableScatterMap.get(SemanticsProperties.Shape);
            Shape shape3 = (Shape) (obj4 == null ? null : obj4);
            if (shape3 != null) {
                Rect rect3 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect3);
                float[] cornerArray = toCornerArray(shape3.mo60createOutlinePq9zytI(getShapeBounds(semanticsNode, rect3, shape3).m379getSizeNHjbRc(), layoutNode.layoutDirection, androidComposeView.getDensity()));
                if (cornerArray != null) {
                    accessibilityNodeInfo.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", cornerArray);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.shapeRegion")) {
            Object obj5 = mutableScatterMap.get(SemanticsProperties.Shape);
            Shape shape4 = (Shape) (obj5 == null ? null : obj5);
            if (shape4 != null) {
                Rect rect4 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect4);
                androidx.compose.ui.geometry.Rect shapeBounds3 = getShapeBounds(semanticsNode, rect4, shape4);
                Region region = toRegion(shape4.mo60createOutlinePq9zytI(shapeBounds3.m379getSizeNHjbRc(), layoutNode.layoutDirection, androidComposeView.getDensity()), shapeBounds3.left, shapeBounds3.top);
                if (region != null) {
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", region);
                }
            }
        }
    }

    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds) {
        IntRect intRect = semanticsNodeWithAdjustedBounds.adjustedBounds;
        return toBoundsInScreen(intRect.left, intRect.top, intRect.right, intRect.bottom);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005d, B:28:0x006f, B:30:0x0077, B:32:0x0080, B:34:0x0086, B:35:0x0095, B:37:0x009d, B:20:0x0047, B:23:0x004e), top: B:56:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0080 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005d, B:28:0x006f, B:30:0x0077, B:32:0x0080, B:34:0x0086, B:35:0x0095, B:37:0x009d, B:20:0x0047, B:23:0x004e), top: B:56:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0086 A[Catch: all -> 0x0037, LOOP:0: B:33:0x0084->B:34:0x0086, LOOP_END, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005d, B:28:0x006f, B:30:0x0077, B:32:0x0080, B:34:0x0086, B:35:0x0095, B:37:0x009d, B:20:0x0047, B:23:0x004e), top: B:56:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009d A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005d, B:28:0x006f, B:30:0x0077, B:32:0x0080, B:34:0x0086, B:35:0x0095, B:37:0x009d, B:20:0x0047, B:23:0x004e), top: B:56:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:47:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:52:0x0101  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f8, code lost:
    
        if (kotlinx.coroutines.JobKt.delay(r4, r2) == r7) goto L50;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00f8 -> B:51:0x00fb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object boundsUpdatesEventLoop$ui(kotlin.coroutines.jvm.internal.ContinuationImpl r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop$ui(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:58:0x010c  */
    /* JADX INFO: renamed from: canScroll-0AR0LA0$ui, reason: not valid java name */
    public final boolean m602canScroll0AR0LA0$ui(boolean z, int i, long j) {
        SemanticsPropertyKey semanticsPropertyKey;
        int i2;
        if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return false;
        }
        IntObjectMap currentSemanticsNodes = getCurrentSemanticsNodes();
        if (Offset.m369equalsimpl0(j, 9205357640488583168L) || (((9223372034707292159L & j) + 36028792732385279L) & (-9223372034707292160L)) != 0) {
            return false;
        }
        if (z) {
            semanticsPropertyKey = SemanticsProperties.VerticalScrollAxisRange;
        } else {
            if (z) {
                throw new HttpException();
            }
            semanticsPropertyKey = SemanticsProperties.HorizontalScrollAxisRange;
        }
        Object[] objArr = currentSemanticsNodes.values;
        long[] jArr = currentSemanticsNodes.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            long j2 = jArr[i3];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((j2 & 255) < 128) {
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) objArr[(i3 << 3) + i6];
                        IntRect intRect = semanticsNodeWithAdjustedBounds.adjustedBounds;
                        i2 = i4;
                        float f = intRect.left;
                        float f2 = intRect.top;
                        float f3 = intRect.right;
                        float f4 = intRect.bottom;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
                        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
                        if ((fIntBitsToFloat2 < f4) & (fIntBitsToFloat >= f) & (fIntBitsToFloat < f3) & (fIntBitsToFloat2 >= f2)) {
                            Object obj = semanticsNodeWithAdjustedBounds.semanticsNode.unmergedConfig.props.get(semanticsPropertyKey);
                            if (obj == null) {
                                obj = null;
                            }
                            ScrollAxisRange scrollAxisRange = (ScrollAxisRange) obj;
                            if (scrollAxisRange != null) {
                                Function0 function0 = scrollAxisRange.value;
                                boolean z3 = scrollAxisRange.reverseScrolling;
                                int i7 = z3 ? -i : i;
                                if (i == 0 && z3) {
                                    i7 = -1;
                                }
                                if (i7 < 0) {
                                    if (((Number) function0.invoke()).floatValue() > 0.0f) {
                                        z2 = true;
                                    }
                                } else if (((Number) function0.invoke()).floatValue() < ((Number) scrollAxisRange.maxValue.invoke()).floatValue()) {
                                    z2 = true;
                                }
                            }
                        }
                    } else {
                        i2 = i4;
                    }
                    j2 >>= i2;
                    i6++;
                    i4 = i2;
                }
                if (i5 != i4) {
                    return z2;
                }
            }
            if (i3 == length) {
                return z2;
            }
            i3++;
        }
    }

    public final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public final AccessibilityEvent createEvent(int i, int i2) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        AndroidComposeView androidComposeView = this.view;
        accessibilityEventObtain.setPackageName(androidComposeView.getContext().getPackageName());
        accessibilityEventObtain.setSource(androidComposeView, i);
        if (isEnabled$ui() && (semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) getCurrentSemanticsNodes().get(i)) != null) {
            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.semanticsNode;
            accessibilityEventObtain.setPassword(semanticsNode.unmergedConfig.props.containsKey(SemanticsProperties.Password));
            Object obj = semanticsNode.unmergedConfig.props.get(SemanticsProperties.IsSensitiveData);
            if (obj == null) {
                obj = null;
            }
            boolean zAreEqual = Intrinsics.areEqual(obj, Boolean.TRUE);
            if (Build.VERSION.SDK_INT >= 34) {
                TextViewCompat.Api34Impl.setAccessibilityDataSensitive(accessibilityEventObtain, zAreEqual);
            }
        }
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent createTextSelectionChangedEvent(int i, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(i, 8192);
        if (num != null) {
            accessibilityEventCreateEvent.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventCreateEvent.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventCreateEvent.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            accessibilityEventCreateEvent.getText().add(charSequence);
        }
        return accessibilityEventCreateEvent;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final Parameters.Builder getAccessibilityNodeProvider(View view) {
        return this.nodeProvider;
    }

    public final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        SemanticsConfiguration semanticsConfiguration2 = semanticsNode.unmergedConfig;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        if (!semanticsConfiguration.props.containsKey(SemanticsProperties.ContentDescription)) {
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.TextSelectionRange;
            if (semanticsConfiguration2.props.containsKey(semanticsPropertyKey2)) {
                return (int) (((TextRange) semanticsConfiguration2.get(semanticsPropertyKey2)).packedValue & 4294967295L);
            }
        }
        return this.accessibilityCursorPosition;
    }

    public final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        SemanticsConfiguration semanticsConfiguration2 = semanticsNode.unmergedConfig;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        if (!semanticsConfiguration.props.containsKey(SemanticsProperties.ContentDescription)) {
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.TextSelectionRange;
            if (semanticsConfiguration2.props.containsKey(semanticsPropertyKey2)) {
                return (int) (((TextRange) semanticsConfiguration2.get(semanticsPropertyKey2)).packedValue >> 32);
            }
        }
        return this.accessibilityCursorPosition;
    }

    public final IntObjectMap getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            AndroidComposeView androidComposeView = this.view;
            this.currentSemanticsNodes = SemanticsNodeKt.getAllUncoveredSemanticsNodesToIntObjectMap(androidComposeView.getSemanticsOwner(), AndroidComposeView.AnonymousClass1.INSTANCE$1);
            if (isEnabled$ui()) {
                MutableIntObjectMap mutableIntObjectMap = this.currentSemanticsNodes;
                Resources resources = androidComposeView.getContext().getResources();
                MutableIntIntMap mutableIntIntMap = this.idToBeforeMap;
                mutableIntIntMap.clear();
                MutableIntIntMap mutableIntIntMap2 = this.idToAfterMap;
                mutableIntIntMap2.clear();
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) mutableIntObjectMap.get(-1);
                SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.semanticsNode : null;
                ArrayList arrayListSubtreeSortedByGeometryGrouping = SemanticsSortKt.subtreeSortedByGeometryGrouping(semanticsNode, new Navigator.AnonymousClass1(18, mutableIntObjectMap), new Navigator.AnonymousClass1(19, resources), Collections.singletonList(semanticsNode));
                int lastIndex = AppCompatHintHelper.getLastIndex(arrayListSubtreeSortedByGeometryGrouping);
                int i = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        int i2 = ((SemanticsNode) arrayListSubtreeSortedByGeometryGrouping.get(i - 1)).id;
                        int i3 = ((SemanticsNode) arrayListSubtreeSortedByGeometryGrouping.get(i)).id;
                        mutableIntIntMap.set(i2, i3);
                        mutableIntIntMap2.set(i3, i2);
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return this.currentSemanticsNodes;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0075 A[LOOP:0: B:4:0x0016->B:36:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0078 A[EDGE_INSN: B:47:0x0078->B:37:0x0078 BREAK  A[LOOP:0: B:4:0x0016->B:36:0x0075], SYNTHETIC] */
    public final androidx.compose.ui.geometry.Rect getShapeBounds(SemanticsNode semanticsNode, Rect rect, Shape shape) {
        AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1 androidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1 = new AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1(shape);
        LayoutNode layoutNode = semanticsNode.layoutNode;
        Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
        DelegatableNode delegatableNode = null;
        if ((node.aggregateChildKindSet & 8) != 0) {
            loop0: while (node != null) {
                if ((node.kindSet & 8) == 0) {
                    if ((node.aggregateChildKindSet & 8) != 0) {
                        break;
                        break;
                    }
                    node = node.child;
                } else {
                    Modifier.Node nodeAccess$pop = node;
                    MutableVector mutableVector = null;
                    while (nodeAccess$pop != null) {
                        if (nodeAccess$pop instanceof SemanticsModifierNode) {
                            ((SemanticsModifierNode) nodeAccess$pop).applySemantics(androidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1);
                            if (androidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1.hasMatchedShape) {
                                delegatableNode = nodeAccess$pop;
                                break loop0;
                            }
                        } else if ((nodeAccess$pop.kindSet & 8) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                if ((node2.kindSet & 8) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodeAccess$pop = node2;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (nodeAccess$pop != null) {
                                            mutableVector.add(nodeAccess$pop);
                                            nodeAccess$pop = null;
                                        }
                                        mutableVector.add(node2);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                    if ((node.aggregateChildKindSet & 8) != 0) {
                        break;
                    }
                    node = node.child;
                }
            }
        }
        DelegatableNode delegatableNode2 = (SemanticsModifierNode) delegatableNode;
        if (delegatableNode2 == null || !((Modifier.Node) delegatableNode2).node.isAttached) {
            return RulerKt.boundsInWindow((NodeCoordinator) layoutNode.nodes.outerCoordinator, false);
        }
        NodeCoordinator nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(delegatableNode2);
        androidx.compose.ui.geometry.Rect rectLocalBoundingBoxOf = RulerKt.findRootCoordinates(nodeCoordinatorRequireLayoutCoordinates).localBoundingBoxOf(nodeCoordinatorRequireLayoutCoordinates, false);
        Rect boundsInScreen = toBoundsInScreen(rectLocalBoundingBoxOf.left, rectLocalBoundingBoxOf.top, rectLocalBoundingBoxOf.right, rectLocalBoundingBoxOf.bottom);
        float f = boundsInScreen.left - rect.left;
        float f2 = boundsInScreen.top - rect.top;
        return new androidx.compose.ui.geometry.Rect(f, f2, boundsInScreen.width() + f, boundsInScreen.height() + f2);
    }

    public final boolean isEnabled$ui() {
        android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (!accessibilityManager.isEnabled()) {
            return false;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this._enabledServices;
        if (enabledAccessibilityServiceList == null) {
            enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1);
            this._enabledServices = enabledAccessibilityServiceList;
        }
        return !enabledAccessibilityServiceList.isEmpty();
    }

    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo842trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        this._enabledServices = null;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this._enabledServices = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager.isEnabled()) {
            this._enabledServices = null;
        }
        accessibilityManager.addAccessibilityStateChangeListener(this);
        accessibilityManager.addTouchExplorationStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.view.getHandler().removeCallbacks(this.semanticsChangeChecker);
        android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager;
        accessibilityManager.removeAccessibilityStateChangeListener(this);
        accessibilityManager.removeTouchExplorationStateChangeListener(this);
    }

    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i) {
        if (i == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().id) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0088 A[LOOP:1: B:15:0x004c->B:28:0x0088, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x008b A[EDGE_INSN: B:44:0x008b->B:29:0x008b BREAK  A[LOOP:1: B:15:0x004c->B:28:0x0088], SYNTHETIC] */
    public final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        int[] iArr = IntSetKt.EmptyIntArray;
        MutableIntSet mutableIntSet = new MutableIntSet();
        List children$ui$default = SemanticsNode.getChildren$ui$default(4, semanticsNode);
        LayoutNode layoutNode = semanticsNode.layoutNode;
        int size = children$ui$default.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) children$ui$default.get(i);
            IntObjectMap currentSemanticsNodes = getCurrentSemanticsNodes();
            int i2 = semanticsNode2.id;
            if (currentSemanticsNodes.containsKey(i2)) {
                if (!semanticsNodeCopy.children.contains(i2)) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                    return;
                }
                mutableIntSet.add(i2);
            }
        }
        MutableIntSet mutableIntSet2 = semanticsNodeCopy.children;
        int[] iArr2 = mutableIntSet2.elements;
        long[] jArr = mutableIntSet2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i3 != length) {
                        break;
                        break;
                    }
                    i3++;
                } else {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128 && !mutableIntSet.contains(iArr2[(i3 << 3) + i5])) {
                            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                            return;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    } else if (i3 != length) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        List children$ui$default2 = SemanticsNode.getChildren$ui$default(4, semanticsNode);
        int size2 = children$ui$default2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            SemanticsNode semanticsNode3 = (SemanticsNode) children$ui$default2.get(i6);
            SemanticsNodeCopy semanticsNodeCopy2 = (SemanticsNodeCopy) this.previousSemanticsNodes.get(semanticsNode3.id);
            if (semanticsNodeCopy2 != null && getCurrentSemanticsNodes().containsKey(semanticsNode3.id)) {
                sendAccessibilitySemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    public final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (!isEnabled$ui()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return ((Boolean) this.onSendAccessibilityEvent.invoke(accessibilityEvent)).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    public final boolean sendEventForVirtualView(int i, int i2, Integer num, List list) {
        if (i == Integer.MIN_VALUE || !isEnabled$ui()) {
            return false;
        }
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(i, i2);
        if (num != null) {
            accessibilityEventCreateEvent.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventCreateEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(list, ",", null, 62));
        }
        return sendEvent(accessibilityEventCreateEvent);
    }

    public final void sendPaneChangeEvents(int i, int i2, String str) {
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i), 32);
        accessibilityEventCreateEvent.setContentChangeTypes(i2);
        if (str != null) {
            accessibilityEventCreateEvent.getText().add(str);
        }
        sendEvent(accessibilityEventCreateEvent);
    }

    public final void sendPendingTextTraversedAtGranularityEvent(int i) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            SemanticsNode semanticsNode = pendingTextTraversedEvent.node;
            if (i != semanticsNode.id) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.traverseTime <= 1000) {
                AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.id), 131072);
                accessibilityEventCreateEvent.setFromIndex(pendingTextTraversedEvent.fromIndex);
                accessibilityEventCreateEvent.setToIndex(pendingTextTraversedEvent.toIndex);
                accessibilityEventCreateEvent.setAction(pendingTextTraversedEvent.action);
                accessibilityEventCreateEvent.setMovementGranularity(pendingTextTraversedEvent.granularity);
                accessibilityEventCreateEvent.getText().add(getIterableTextForAccessibility(semanticsNode));
                sendEvent(accessibilityEventCreateEvent);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0246  */
    /* JADX WARN: Code duplicated, block: B:102:0x024a  */
    /* JADX WARN: Code duplicated, block: B:104:0x0251  */
    /* JADX WARN: Code duplicated, block: B:106:0x025e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0271  */
    /* JADX WARN: Code duplicated, block: B:111:0x029b  */
    /* JADX WARN: Code duplicated, block: B:113:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:114:0x02be  */
    /* JADX WARN: Code duplicated, block: B:116:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:118:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:120:0x02db  */
    /* JADX WARN: Code duplicated, block: B:124:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:127:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:131:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:134:0x0301  */
    /* JADX WARN: Code duplicated, block: B:136:0x0305  */
    /* JADX WARN: Code duplicated, block: B:140:0x030e  */
    /* JADX WARN: Code duplicated, block: B:143:0x031b A[LOOP:4: B:138:0x030a->B:143:0x031b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:148:0x0329  */
    /* JADX WARN: Code duplicated, block: B:151:0x033d A[LOOP:5: B:146:0x0325->B:151:0x033d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:155:0x035c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x0363  */
    /* JADX WARN: Code duplicated, block: B:160:0x0367 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:163:0x036d  */
    /* JADX WARN: Code duplicated, block: B:165:0x0370 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:168:0x0397  */
    /* JADX WARN: Code duplicated, block: B:171:0x03b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:174:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:178:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:179:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:181:0x040d  */
    /* JADX WARN: Code duplicated, block: B:183:0x0413  */
    /* JADX WARN: Code duplicated, block: B:186:0x0419  */
    /* JADX WARN: Code duplicated, block: B:191:0x045b  */
    /* JADX WARN: Code duplicated, block: B:193:0x0465  */
    /* JADX WARN: Code duplicated, block: B:195:0x046d  */
    /* JADX WARN: Code duplicated, block: B:243:0x053c  */
    /* JADX WARN: Code duplicated, block: B:245:0x0540  */
    /* JADX WARN: Code duplicated, block: B:250:0x0555  */
    /* JADX WARN: Code duplicated, block: B:253:0x0567 A[LOOP:6: B:249:0x0553->B:253:0x0567, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:257:0x0572  */
    /* JADX WARN: Code duplicated, block: B:260:0x0580  */
    /* JADX WARN: Code duplicated, block: B:264:0x058f  */
    /* JADX WARN: Code duplicated, block: B:291:0x067a  */
    /* JADX WARN: Code duplicated, block: B:313:0x0322 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:314:0x0324 A[EDGE_INSN: B:314:0x0324->B:145:0x0324 BREAK  A[LOOP:4: B:138:0x030a->B:143:0x031b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:315:0x0340 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:316:0x0342 A[EDGE_INSN: B:316:0x0342->B:153:0x0342 BREAK  A[LOOP:5: B:146:0x0325->B:151:0x033d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:317:0x056a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:318:0x055f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x011b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0121  */
    /* JADX WARN: Code duplicated, block: B:53:0x013d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0145  */
    /* JADX WARN: Code duplicated, block: B:57:0x014f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0155  */
    /* JADX WARN: Code duplicated, block: B:61:0x015f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0170  */
    /* JADX WARN: Code duplicated, block: B:64:0x017a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0191  */
    /* JADX WARN: Code duplicated, block: B:67:0x0199  */
    /* JADX WARN: Code duplicated, block: B:68:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:70:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:75:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x01de  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:90:0x0216  */
    /* JADX WARN: Code duplicated, block: B:93:0x0224  */
    /* JADX WARN: Code duplicated, block: B:96:0x0237  */
    /* JADX WARN: Code duplicated, block: B:99:0x023e  */
    public final void sendSemanticsPropertyChangeEvents(IntObjectMap intObjectMap) {
        Integer num;
        ArrayList arrayList;
        int[] iArr;
        long[] jArr;
        int i;
        int i2;
        int i3;
        Integer num2;
        ArrayList arrayList2;
        int[] iArr2;
        long[] jArr2;
        int i4;
        int i5;
        int i6;
        int i7;
        SemanticsNode semanticsNode;
        int i8;
        SemanticsConfiguration semanticsConfiguration;
        int i9;
        int i10;
        int i11;
        int i12;
        SemanticsConfiguration semanticsConfiguration2;
        LayoutNode layoutNode;
        int i13;
        int i14;
        int i15;
        ScrollObservationScope scrollObservationScope;
        boolean z;
        Object obj;
        int i16;
        SemanticsPropertyKey semanticsPropertyKey;
        Object obj2;
        String str;
        Integer num3;
        SemanticsPropertyKey semanticsPropertyKey2;
        int size;
        int i17;
        ScrollObservationScope scrollObservationScope2;
        Object obj3;
        Object obj4;
        boolean z2;
        Function function;
        boolean z3;
        int i18;
        Object obj5;
        AnnotatedString annotatedString;
        String str2;
        Object obj6;
        AnnotatedString annotatedString2;
        Object obj7;
        CharSequence charSequence;
        CharSequence charSequenceTrimToSize;
        int length;
        int length2;
        int i19;
        Integer num4;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean zContainsKey;
        boolean z4;
        boolean z5;
        AccessibilityEvent accessibilityEventCreateTextSelectionChangedEvent;
        Object obj8;
        Role role;
        boolean z6;
        Object obj9;
        Object obj10;
        AccessibilityEvent accessibilityEventCreateEvent;
        Object obj11;
        String strFastJoinToString$default;
        Object obj12;
        List list;
        String strFastJoinToString$default2;
        String str3;
        boolean zContainsKey2;
        int i24;
        Object obj13;
        IntObjectMap intObjectMap2 = intObjectMap;
        Integer num5 = 64;
        ArrayList arrayList3 = this.scrollObservationScopes;
        ArrayList arrayList4 = new ArrayList(arrayList3);
        arrayList3.clear();
        int[] iArr3 = intObjectMap2.keys;
        long[] jArr3 = intObjectMap2.metadata;
        int i25 = 2;
        int length3 = jArr3.length - 2;
        int i26 = 0;
        Integer num6 = 0;
        if (length3 < 0) {
            return;
        }
        int i27 = 0;
        while (true) {
            long j = jArr3[i27];
            int i28 = i25;
            int i29 = length3;
            int i30 = 7;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i31 = 8;
                int i32 = 8 - ((~(i27 - i29)) >>> 31);
                long j2 = j;
                int i33 = i26;
                while (i33 < i32) {
                    if ((j2 & 255) < 128) {
                        int i34 = iArr3[(i27 << 3) + i33];
                        SemanticsNodeCopy semanticsNodeCopy = (SemanticsNodeCopy) this.previousSemanticsNodes.get(i34);
                        if (semanticsNodeCopy == null) {
                            i3 = i33;
                            num2 = num5;
                            arrayList2 = arrayList4;
                            iArr2 = iArr3;
                            jArr2 = jArr3;
                            i4 = i31;
                            i5 = i32;
                            i6 = i26;
                            i7 = i27;
                        } else {
                            SemanticsConfiguration semanticsConfiguration3 = semanticsNodeCopy.unmergedConfig;
                            MutableScatterMap mutableScatterMap = semanticsConfiguration3.props;
                            int i35 = i30;
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) intObjectMap2.get(i34);
                            int i36 = i31;
                            SemanticsNode semanticsNode2 = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.semanticsNode : null;
                            if (semanticsNode2 == null) {
                                throw Modifier.CC.m("no value for specified key");
                            }
                            LayoutNode layoutNode2 = semanticsNode2.layoutNode;
                            SemanticsConfiguration semanticsConfiguration4 = semanticsNode2.unmergedConfig;
                            iArr2 = iArr3;
                            int i37 = semanticsNode2.id;
                            jArr2 = jArr3;
                            MutableScatterMap mutableScatterMap2 = semanticsConfiguration4.props;
                            i7 = i27;
                            Object[] objArr = mutableScatterMap2.keys;
                            Object[] objArr2 = mutableScatterMap2.values;
                            long[] jArr4 = mutableScatterMap2.metadata;
                            i3 = i33;
                            int length4 = jArr4.length - 2;
                            if (length4 >= 0) {
                                semanticsConfiguration = semanticsConfiguration3;
                                SemanticsConfiguration semanticsConfiguration5 = semanticsConfiguration4;
                                int i38 = 0;
                                i10 = 0;
                                while (true) {
                                    long j3 = jArr4[i38];
                                    LayoutNode layoutNode3 = layoutNode2;
                                    i5 = i32;
                                    if ((((~j3) << i35) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i39 = 8 - ((~(i38 - length4)) >>> 31);
                                        long j4 = j3;
                                        int i40 = 0;
                                        while (i40 < i39) {
                                            if ((j4 & 255) < 128) {
                                                int i41 = (i38 << 3) + i40;
                                                Object obj14 = objArr[i41];
                                                Object obj15 = objArr2[i41];
                                                Object obj16 = (SemanticsPropertyKey) obj14;
                                                int i42 = length4;
                                                SemanticsPropertyKey semanticsPropertyKey3 = SemanticsProperties.HorizontalScrollAxisRange;
                                                if (Intrinsics.areEqual(obj16, semanticsPropertyKey3)) {
                                                    i14 = i40;
                                                } else {
                                                    i14 = i40;
                                                    if (!Intrinsics.areEqual(obj16, SemanticsProperties.VerticalScrollAxisRange)) {
                                                        z = false;
                                                    }
                                                    if (z) {
                                                        obj = SemanticsProperties.PaneTitle;
                                                        if (Intrinsics.areEqual(obj16, obj)) {
                                                            str3 = (String) obj15;
                                                            zContainsKey2 = mutableScatterMap.containsKey(obj);
                                                            i24 = i36;
                                                            if (zContainsKey2) {
                                                                sendPaneChangeEvents(i34, i24, str3);
                                                            }
                                                            Unit unit = Unit.INSTANCE;
                                                        } else {
                                                            i16 = i36;
                                                            if (Intrinsics.areEqual(obj16, SemanticsProperties.StateDescription)) {
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, i16);
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, i16);
                                                            } else if (Intrinsics.areEqual(obj16, SemanticsProperties.ToggleableState)) {
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 8192, 8);
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                            } else if (Intrinsics.areEqual(obj16, SemanticsProperties.Error)) {
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 3072, 8);
                                                            } else if (Intrinsics.areEqual(obj16, SemanticsProperties.ProgressBarRangeInfo)) {
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, 8);
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                            } else {
                                                                semanticsPropertyKey = SemanticsProperties.Selected;
                                                                arrayList4 = arrayList4;
                                                                if (Intrinsics.areEqual(obj16, semanticsPropertyKey)) {
                                                                    obj8 = mutableScatterMap2.get(SemanticsProperties.Role);
                                                                    if (obj8 == null) {
                                                                        obj8 = null;
                                                                    }
                                                                    role = (Role) obj8;
                                                                    if (role == null && role.value == 4) {
                                                                        z6 = true;
                                                                    } else {
                                                                        z6 = false;
                                                                    }
                                                                    if (z6) {
                                                                        obj10 = mutableScatterMap2.get(semanticsPropertyKey);
                                                                        if (obj10 == null) {
                                                                            obj10 = null;
                                                                        }
                                                                        if (Intrinsics.areEqual(obj10, Boolean.TRUE)) {
                                                                            accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 4);
                                                                            SemanticsConfiguration semanticsConfiguration6 = semanticsConfiguration5;
                                                                            layoutNode3 = layoutNode3;
                                                                            SemanticsNode semanticsNode3 = new SemanticsNode(semanticsNode2.outerSemanticsNode, true, layoutNode3, semanticsConfiguration6);
                                                                            obj11 = semanticsNode3.getConfig().props.get(SemanticsProperties.ContentDescription);
                                                                            if (obj11 == null) {
                                                                                obj11 = null;
                                                                            }
                                                                            List list2 = (List) obj11;
                                                                            strFastJoinToString$default = list2 != null ? ListUtilsKt.fastJoinToString$default(list2, ",", null, 62) : null;
                                                                            obj12 = semanticsNode3.getConfig().props.get(SemanticsProperties.Text);
                                                                            if (obj12 == null) {
                                                                                obj12 = null;
                                                                            }
                                                                            list = (List) obj12;
                                                                            semanticsConfiguration5 = semanticsConfiguration6;
                                                                            if (list != null) {
                                                                                obj9 = null;
                                                                                strFastJoinToString$default2 = ListUtilsKt.fastJoinToString$default(list, ",", null, 62);
                                                                            } else {
                                                                                obj9 = null;
                                                                                strFastJoinToString$default2 = null;
                                                                            }
                                                                            if (strFastJoinToString$default != null) {
                                                                                accessibilityEventCreateEvent.setContentDescription(strFastJoinToString$default);
                                                                                Unit unit2 = Unit.INSTANCE;
                                                                            }
                                                                            if (strFastJoinToString$default2 != null) {
                                                                                accessibilityEventCreateEvent.getText().add(strFastJoinToString$default2);
                                                                            }
                                                                            sendEvent(accessibilityEventCreateEvent);
                                                                        } else {
                                                                            semanticsConfiguration5 = semanticsConfiguration5;
                                                                            layoutNode3 = layoutNode3;
                                                                            obj9 = null;
                                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                        }
                                                                    } else {
                                                                        semanticsConfiguration5 = semanticsConfiguration5;
                                                                        layoutNode3 = layoutNode3;
                                                                        obj9 = null;
                                                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, 8);
                                                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                    }
                                                                } else {
                                                                    semanticsConfiguration5 = semanticsConfiguration5;
                                                                    layoutNode3 = layoutNode3;
                                                                    semanticsNode2 = semanticsNode2;
                                                                    if (Intrinsics.areEqual(obj16, SemanticsProperties.ContentDescription)) {
                                                                        sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 4, (List) obj15);
                                                                    } else {
                                                                        obj2 = SemanticsProperties.EditableText;
                                                                        str = "";
                                                                        if (Intrinsics.areEqual(obj16, obj2)) {
                                                                            if (mutableScatterMap2.containsKey(SemanticsActions.SetText)) {
                                                                                obj6 = mutableScatterMap.get(obj2);
                                                                                if (obj6 == null) {
                                                                                    obj6 = null;
                                                                                }
                                                                                annotatedString2 = (AnnotatedString) obj6;
                                                                                if (annotatedString2 == null) {
                                                                                    annotatedString2 = "";
                                                                                }
                                                                                obj7 = mutableScatterMap2.get(obj2);
                                                                                if (obj7 == null) {
                                                                                    obj7 = null;
                                                                                }
                                                                                charSequence = (AnnotatedString) obj7;
                                                                                if (charSequence == null) {
                                                                                    charSequence = "";
                                                                                }
                                                                                charSequenceTrimToSize = trimToSize(charSequence);
                                                                                length = annotatedString2.length();
                                                                                length2 = charSequence.length();
                                                                                if (length > length2) {
                                                                                    i19 = length2;
                                                                                } else {
                                                                                    i19 = length;
                                                                                }
                                                                                num4 = num6;
                                                                                i20 = 0;
                                                                                while (true) {
                                                                                    i21 = length;
                                                                                    if (i20 < i19) {
                                                                                        num5 = num5;
                                                                                        break;
                                                                                    }
                                                                                    num5 = num5;
                                                                                    if (annotatedString2.charAt(i20) != charSequence.charAt(i20)) {
                                                                                        break;
                                                                                    }
                                                                                    i20++;
                                                                                    length = i21;
                                                                                    num5 = num5;
                                                                                }
                                                                                i22 = 0;
                                                                                while (true) {
                                                                                    if (i22 < i19 - i20) {
                                                                                        i23 = i22;
                                                                                        break;
                                                                                    }
                                                                                    i23 = i22;
                                                                                    if (annotatedString2.charAt((i21 - 1) - i22) != charSequence.charAt((length2 - 1) - i23)) {
                                                                                        break;
                                                                                    } else {
                                                                                        i22 = i23 + 1;
                                                                                    }
                                                                                }
                                                                                int i43 = (i21 - i23) - i20;
                                                                                int i44 = (length2 - i23) - i20;
                                                                                Object obj17 = SemanticsProperties.Password;
                                                                                boolean zContainsKey3 = mutableScatterMap.containsKey(obj17);
                                                                                boolean zContainsKey4 = mutableScatterMap2.containsKey(obj17);
                                                                                zContainsKey = mutableScatterMap.containsKey(SemanticsProperties.EditableText);
                                                                                if (zContainsKey || zContainsKey3 || !zContainsKey4) {
                                                                                    z4 = false;
                                                                                } else {
                                                                                    z4 = true;
                                                                                }
                                                                                if (zContainsKey || !zContainsKey3 || zContainsKey4) {
                                                                                    z5 = false;
                                                                                } else {
                                                                                    z5 = true;
                                                                                }
                                                                                if (!z4 || z5) {
                                                                                    num3 = num4;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), num3, num4, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                                } else {
                                                                                    AccessibilityEvent accessibilityEventCreateEvent2 = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 16);
                                                                                    accessibilityEventCreateEvent2.setFromIndex(i20);
                                                                                    accessibilityEventCreateEvent2.setRemovedCount(i43);
                                                                                    accessibilityEventCreateEvent2.setAddedCount(i44);
                                                                                    accessibilityEventCreateEvent2.setBeforeText(annotatedString2);
                                                                                    accessibilityEventCreateEvent2.getText().add(charSequenceTrimToSize);
                                                                                    accessibilityEventCreateTextSelectionChangedEvent = accessibilityEventCreateEvent2;
                                                                                    num3 = num4;
                                                                                }
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setClassName("android.widget.EditText");
                                                                                sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                if (z4 || z5) {
                                                                                    long j5 = ((TextRange) semanticsConfiguration5.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j5 >> 32));
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j5 & 4294967295L));
                                                                                    sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                }
                                                                                Unit unit3 = Unit.INSTANCE;
                                                                            } else {
                                                                                num3 = num6;
                                                                                i34 = i34;
                                                                                num5 = num5;
                                                                                semanticsConfiguration5 = semanticsConfiguration5;
                                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, Integer.valueOf(i28), 8);
                                                                            }
                                                                            i15 = i42;
                                                                        } else {
                                                                            num3 = num6;
                                                                            i34 = i34;
                                                                            num5 = num5;
                                                                            semanticsConfiguration5 = semanticsConfiguration5;
                                                                            i15 = i42;
                                                                            semanticsPropertyKey2 = SemanticsProperties.TextSelectionRange;
                                                                            if (Intrinsics.areEqual(obj16, semanticsPropertyKey2)) {
                                                                                obj5 = mutableScatterMap2.get(obj2);
                                                                                if (obj5 == null) {
                                                                                    obj5 = null;
                                                                                }
                                                                                annotatedString = (AnnotatedString) obj5;
                                                                                if (annotatedString != null && (str2 = annotatedString.text) != null) {
                                                                                    str = str2;
                                                                                }
                                                                                long j6 = ((TextRange) semanticsConfiguration5.get(semanticsPropertyKey2)).packedValue;
                                                                                sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), Integer.valueOf((int) (j6 >> 32)), Integer.valueOf((int) (j6 & 4294967295L)), Integer.valueOf(str.length()), trimToSize(str)));
                                                                                sendPendingTextTraversedAtGranularityEvent(i37);
                                                                                Unit unit4 = Unit.INSTANCE;
                                                                            } else {
                                                                                i35 = i35;
                                                                                num6 = num3;
                                                                                if (!Intrinsics.areEqual(obj16, semanticsPropertyKey3) || Intrinsics.areEqual(obj16, SemanticsProperties.VerticalScrollAxisRange)) {
                                                                                    notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                    size = arrayList3.size();
                                                                                    i17 = 0;
                                                                                    while (true) {
                                                                                        if (i17 >= size) {
                                                                                            scrollObservationScope2 = null;
                                                                                            break;
                                                                                        } else {
                                                                                            if (((ScrollObservationScope) arrayList3.get(i17)).semanticsNodeId == i34) {
                                                                                                scrollObservationScope2 = (ScrollObservationScope) arrayList3.get(i17);
                                                                                                break;
                                                                                            }
                                                                                            i17++;
                                                                                        }
                                                                                    }
                                                                                    obj3 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                                    if (obj3 == null) {
                                                                                        obj3 = null;
                                                                                    }
                                                                                    scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj3;
                                                                                    obj4 = mutableScatterMap2.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                    if (obj4 == null) {
                                                                                        obj4 = null;
                                                                                    }
                                                                                    scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj4;
                                                                                    if (scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                        this.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, this.scheduleScrollEventIfNeededLambda, new DialogHostKt$DialogHost$1$1$1(i35, scrollObservationScope2, this));
                                                                                    }
                                                                                    Unit unit5 = Unit.INSTANCE;
                                                                                } else if (Intrinsics.areEqual(obj16, SemanticsProperties.Focused)) {
                                                                                    if (((Boolean) obj15).booleanValue()) {
                                                                                        i18 = 8;
                                                                                        sendEvent(createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i37), 8));
                                                                                    } else {
                                                                                        i18 = 8;
                                                                                    }
                                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i37), 2048, num6, i18);
                                                                                } else {
                                                                                    SemanticsPropertyKey semanticsPropertyKey4 = SemanticsActions.CustomActions;
                                                                                    if (Intrinsics.areEqual(obj16, semanticsPropertyKey4)) {
                                                                                        List list3 = (List) semanticsConfiguration5.get(semanticsPropertyKey4);
                                                                                        Object obj18 = mutableScatterMap.get(semanticsPropertyKey4);
                                                                                        if (obj18 == null) {
                                                                                            obj18 = null;
                                                                                        }
                                                                                        List list4 = (List) obj18;
                                                                                        if (list4 != null) {
                                                                                            MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
                                                                                            MutableScatterSet mutableScatterSet2 = new MutableScatterSet();
                                                                                            if (list3.size() > 0) {
                                                                                                list3.get(0).getClass();
                                                                                                throw new ClassCastException();
                                                                                            }
                                                                                            MutableScatterSet mutableScatterSet3 = new MutableScatterSet();
                                                                                            if (list4.size() > 0) {
                                                                                                list4.get(0).getClass();
                                                                                                throw new ClassCastException();
                                                                                            }
                                                                                            i10 = !mutableScatterSet2.equals(mutableScatterSet3) ? 1 : 0;
                                                                                            z3 = false;
                                                                                        } else {
                                                                                            z3 = false;
                                                                                            if (!list3.isEmpty()) {
                                                                                                i10 = 1;
                                                                                            }
                                                                                        }
                                                                                        Unit unit6 = Unit.INSTANCE;
                                                                                    } else {
                                                                                        if (obj15 instanceof AccessibilityAction) {
                                                                                            AccessibilityAction accessibilityAction = (AccessibilityAction) obj15;
                                                                                            Object obj19 = mutableScatterMap.get(obj16);
                                                                                            if (obj19 == null) {
                                                                                                obj19 = null;
                                                                                            }
                                                                                            if (accessibilityAction != obj19) {
                                                                                                if (obj19 instanceof AccessibilityAction) {
                                                                                                    String str4 = accessibilityAction.label;
                                                                                                    AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj19;
                                                                                                    Function function2 = accessibilityAction2.action;
                                                                                                    z2 = Intrinsics.areEqual(str4, accessibilityAction2.label) && ((function = accessibilityAction.action) != null || function2 == null) && (function == null || function2 != null);
                                                                                                }
                                                                                            }
                                                                                            if (z2) {
                                                                                                i10 = 0;
                                                                                            } else {
                                                                                                i10 = 1;
                                                                                            }
                                                                                        } else {
                                                                                            i10 = 1;
                                                                                        }
                                                                                        Unit unit7 = Unit.INSTANCE;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        num6 = num3;
                                                                    }
                                                                }
                                                                i35 = i35;
                                                                semanticsConfiguration5 = semanticsConfiguration5;
                                                                i15 = i42;
                                                            }
                                                        }
                                                        i15 = i42;
                                                    } else {
                                                        obj13 = mutableScatterMap.get(obj16);
                                                        if (obj13 == null) {
                                                            obj13 = null;
                                                        }
                                                        if (!Intrinsics.areEqual(obj15, obj13)) {
                                                            obj = SemanticsProperties.PaneTitle;
                                                            if (Intrinsics.areEqual(obj16, obj)) {
                                                                str3 = (String) obj15;
                                                                zContainsKey2 = mutableScatterMap.containsKey(obj);
                                                                i24 = i36;
                                                                if (zContainsKey2) {
                                                                    sendPaneChangeEvents(i34, i24, str3);
                                                                }
                                                                Unit unit8 = Unit.INSTANCE;
                                                            } else {
                                                                i16 = i36;
                                                                if (Intrinsics.areEqual(obj16, SemanticsProperties.StateDescription)) {
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, i16);
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, i16);
                                                                } else if (Intrinsics.areEqual(obj16, SemanticsProperties.ToggleableState)) {
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 8192, 8);
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                } else if (Intrinsics.areEqual(obj16, SemanticsProperties.Error)) {
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 3072, 8);
                                                                } else if (Intrinsics.areEqual(obj16, SemanticsProperties.ProgressBarRangeInfo)) {
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, 8);
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                } else {
                                                                    semanticsPropertyKey = SemanticsProperties.Selected;
                                                                    arrayList4 = arrayList4;
                                                                    if (Intrinsics.areEqual(obj16, semanticsPropertyKey)) {
                                                                        obj8 = mutableScatterMap2.get(SemanticsProperties.Role);
                                                                        if (obj8 == null) {
                                                                            obj8 = null;
                                                                        }
                                                                        role = (Role) obj8;
                                                                        if (role == null) {
                                                                            z6 = false;
                                                                        } else {
                                                                            z6 = true;
                                                                        }
                                                                        if (z6) {
                                                                            obj10 = mutableScatterMap2.get(semanticsPropertyKey);
                                                                            if (obj10 == null) {
                                                                                obj10 = null;
                                                                            }
                                                                            if (Intrinsics.areEqual(obj10, Boolean.TRUE)) {
                                                                                accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 4);
                                                                                SemanticsConfiguration semanticsConfiguration7 = semanticsConfiguration5;
                                                                                layoutNode3 = layoutNode3;
                                                                                SemanticsNode semanticsNode4 = new SemanticsNode(semanticsNode2.outerSemanticsNode, true, layoutNode3, semanticsConfiguration7);
                                                                                obj11 = semanticsNode4.getConfig().props.get(SemanticsProperties.ContentDescription);
                                                                                if (obj11 == null) {
                                                                                    obj11 = null;
                                                                                }
                                                                                List list5 = (List) obj11;
                                                                                if (list5 != null) {
                                                                                }
                                                                                obj12 = semanticsNode4.getConfig().props.get(SemanticsProperties.Text);
                                                                                if (obj12 == null) {
                                                                                    obj12 = null;
                                                                                }
                                                                                list = (List) obj12;
                                                                                semanticsConfiguration5 = semanticsConfiguration7;
                                                                                if (list != null) {
                                                                                    obj9 = null;
                                                                                    strFastJoinToString$default2 = ListUtilsKt.fastJoinToString$default(list, ",", null, 62);
                                                                                } else {
                                                                                    obj9 = null;
                                                                                    strFastJoinToString$default2 = null;
                                                                                }
                                                                                if (strFastJoinToString$default != null) {
                                                                                    accessibilityEventCreateEvent.setContentDescription(strFastJoinToString$default);
                                                                                    Unit unit9 = Unit.INSTANCE;
                                                                                }
                                                                                if (strFastJoinToString$default2 != null) {
                                                                                    accessibilityEventCreateEvent.getText().add(strFastJoinToString$default2);
                                                                                }
                                                                                sendEvent(accessibilityEventCreateEvent);
                                                                            } else {
                                                                                semanticsConfiguration5 = semanticsConfiguration5;
                                                                                layoutNode3 = layoutNode3;
                                                                                obj9 = null;
                                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                            }
                                                                        } else {
                                                                            semanticsConfiguration5 = semanticsConfiguration5;
                                                                            layoutNode3 = layoutNode3;
                                                                            obj9 = null;
                                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, 8);
                                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                        }
                                                                    } else {
                                                                        semanticsConfiguration5 = semanticsConfiguration5;
                                                                        layoutNode3 = layoutNode3;
                                                                        semanticsNode2 = semanticsNode2;
                                                                        if (Intrinsics.areEqual(obj16, SemanticsProperties.ContentDescription)) {
                                                                            sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 4, (List) obj15);
                                                                        } else {
                                                                            obj2 = SemanticsProperties.EditableText;
                                                                            str = "";
                                                                            if (Intrinsics.areEqual(obj16, obj2)) {
                                                                                if (mutableScatterMap2.containsKey(SemanticsActions.SetText)) {
                                                                                    obj6 = mutableScatterMap.get(obj2);
                                                                                    if (obj6 == null) {
                                                                                        obj6 = null;
                                                                                    }
                                                                                    annotatedString2 = (AnnotatedString) obj6;
                                                                                    if (annotatedString2 == null) {
                                                                                        annotatedString2 = "";
                                                                                    }
                                                                                    obj7 = mutableScatterMap2.get(obj2);
                                                                                    if (obj7 == null) {
                                                                                        obj7 = null;
                                                                                    }
                                                                                    charSequence = (AnnotatedString) obj7;
                                                                                    if (charSequence == null) {
                                                                                        charSequence = "";
                                                                                    }
                                                                                    charSequenceTrimToSize = trimToSize(charSequence);
                                                                                    length = annotatedString2.length();
                                                                                    length2 = charSequence.length();
                                                                                    if (length > length2) {
                                                                                        i19 = length2;
                                                                                    } else {
                                                                                        i19 = length;
                                                                                    }
                                                                                    num4 = num6;
                                                                                    i20 = 0;
                                                                                    while (true) {
                                                                                        i21 = length;
                                                                                        if (i20 < i19) {
                                                                                            num5 = num5;
                                                                                            break;
                                                                                        }
                                                                                        num5 = num5;
                                                                                        if (annotatedString2.charAt(i20) != charSequence.charAt(i20)) {
                                                                                            break;
                                                                                            break;
                                                                                        } else {
                                                                                            i20++;
                                                                                            length = i21;
                                                                                            num5 = num5;
                                                                                        }
                                                                                    }
                                                                                    i22 = 0;
                                                                                    while (true) {
                                                                                        if (i22 < i19 - i20) {
                                                                                            i23 = i22;
                                                                                            break;
                                                                                        }
                                                                                        i23 = i22;
                                                                                        if (annotatedString2.charAt((i21 - 1) - i22) != charSequence.charAt((length2 - 1) - i23)) {
                                                                                            break;
                                                                                            break;
                                                                                        }
                                                                                        i22 = i23 + 1;
                                                                                    }
                                                                                    int i45 = (i21 - i23) - i20;
                                                                                    int i46 = (length2 - i23) - i20;
                                                                                    Object obj110 = SemanticsProperties.Password;
                                                                                    boolean zContainsKey5 = mutableScatterMap.containsKey(obj110);
                                                                                    boolean zContainsKey6 = mutableScatterMap2.containsKey(obj110);
                                                                                    zContainsKey = mutableScatterMap.containsKey(SemanticsProperties.EditableText);
                                                                                    if (zContainsKey) {
                                                                                        z4 = false;
                                                                                    } else {
                                                                                        z4 = false;
                                                                                    }
                                                                                    if (zContainsKey) {
                                                                                        z5 = false;
                                                                                    } else {
                                                                                        z5 = false;
                                                                                    }
                                                                                    if (z4) {
                                                                                        num3 = num4;
                                                                                        accessibilityEventCreateTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), num3, num4, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                                    } else {
                                                                                        num3 = num4;
                                                                                        accessibilityEventCreateTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), num3, num4, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                                    }
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setClassName("android.widget.EditText");
                                                                                    sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                    if (z4) {
                                                                                        long j7 = ((TextRange) semanticsConfiguration5.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                        accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j7 >> 32));
                                                                                        accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j7 & 4294967295L));
                                                                                        sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                    } else {
                                                                                        long j8 = ((TextRange) semanticsConfiguration5.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                        accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j8 >> 32));
                                                                                        accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j8 & 4294967295L));
                                                                                        sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                    }
                                                                                    Unit unit10 = Unit.INSTANCE;
                                                                                } else {
                                                                                    num3 = num6;
                                                                                    i34 = i34;
                                                                                    num5 = num5;
                                                                                    semanticsConfiguration5 = semanticsConfiguration5;
                                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, Integer.valueOf(i28), 8);
                                                                                }
                                                                                i15 = i42;
                                                                            } else {
                                                                                num3 = num6;
                                                                                i34 = i34;
                                                                                num5 = num5;
                                                                                semanticsConfiguration5 = semanticsConfiguration5;
                                                                                i15 = i42;
                                                                                semanticsPropertyKey2 = SemanticsProperties.TextSelectionRange;
                                                                                if (Intrinsics.areEqual(obj16, semanticsPropertyKey2)) {
                                                                                    obj5 = mutableScatterMap2.get(obj2);
                                                                                    if (obj5 == null) {
                                                                                        obj5 = null;
                                                                                    }
                                                                                    annotatedString = (AnnotatedString) obj5;
                                                                                    if (annotatedString != null) {
                                                                                        str = str2;
                                                                                    }
                                                                                    long j9 = ((TextRange) semanticsConfiguration5.get(semanticsPropertyKey2)).packedValue;
                                                                                    sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), Integer.valueOf((int) (j9 >> 32)), Integer.valueOf((int) (j9 & 4294967295L)), Integer.valueOf(str.length()), trimToSize(str)));
                                                                                    sendPendingTextTraversedAtGranularityEvent(i37);
                                                                                    Unit unit11 = Unit.INSTANCE;
                                                                                } else {
                                                                                    i35 = i35;
                                                                                    num6 = num3;
                                                                                    if (Intrinsics.areEqual(obj16, semanticsPropertyKey3)) {
                                                                                        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                        size = arrayList3.size();
                                                                                        i17 = 0;
                                                                                        while (true) {
                                                                                            if (i17 >= size) {
                                                                                                scrollObservationScope2 = null;
                                                                                                break;
                                                                                            } else {
                                                                                                if (((ScrollObservationScope) arrayList3.get(i17)).semanticsNodeId == i34) {
                                                                                                    scrollObservationScope2 = (ScrollObservationScope) arrayList3.get(i17);
                                                                                                    break;
                                                                                                }
                                                                                                i17++;
                                                                                            }
                                                                                        }
                                                                                        obj3 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                                        if (obj3 == null) {
                                                                                            obj3 = null;
                                                                                        }
                                                                                        scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj3;
                                                                                        obj4 = mutableScatterMap2.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                        if (obj4 == null) {
                                                                                            obj4 = null;
                                                                                        }
                                                                                        scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj4;
                                                                                        if (scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                            this.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, this.scheduleScrollEventIfNeededLambda, new DialogHostKt$DialogHost$1$1$1(i35, scrollObservationScope2, this));
                                                                                        }
                                                                                        Unit unit12 = Unit.INSTANCE;
                                                                                    } else {
                                                                                        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                        size = arrayList3.size();
                                                                                        i17 = 0;
                                                                                        while (true) {
                                                                                            if (i17 >= size) {
                                                                                                scrollObservationScope2 = null;
                                                                                                break;
                                                                                            } else {
                                                                                                if (((ScrollObservationScope) arrayList3.get(i17)).semanticsNodeId == i34) {
                                                                                                    scrollObservationScope2 = (ScrollObservationScope) arrayList3.get(i17);
                                                                                                    break;
                                                                                                }
                                                                                                i17++;
                                                                                            }
                                                                                        }
                                                                                        obj3 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                                        if (obj3 == null) {
                                                                                            obj3 = null;
                                                                                        }
                                                                                        scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj3;
                                                                                        obj4 = mutableScatterMap2.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                        if (obj4 == null) {
                                                                                            obj4 = null;
                                                                                        }
                                                                                        scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj4;
                                                                                        if (scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                            this.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, this.scheduleScrollEventIfNeededLambda, new DialogHostKt$DialogHost$1$1$1(i35, scrollObservationScope2, this));
                                                                                        }
                                                                                        Unit unit13 = Unit.INSTANCE;
                                                                                    }
                                                                                }
                                                                            }
                                                                            num6 = num3;
                                                                        }
                                                                    }
                                                                    i35 = i35;
                                                                    semanticsConfiguration5 = semanticsConfiguration5;
                                                                    i15 = i42;
                                                                }
                                                            }
                                                        }
                                                        i15 = i42;
                                                    }
                                                    j4 >>= 8;
                                                    i35 = i35;
                                                    i36 = 8;
                                                    i34 = i34;
                                                    layoutNode3 = layoutNode3;
                                                    semanticsNode2 = semanticsNode2;
                                                    i38 = i38;
                                                    i40 = i14 + 1;
                                                    length4 = i15;
                                                    semanticsConfiguration5 = semanticsConfiguration5;
                                                    arrayList4 = arrayList4;
                                                    num5 = num5;
                                                }
                                                int size2 = arrayList4.size();
                                                int i47 = 0;
                                                while (true) {
                                                    if (i47 >= size2) {
                                                        scrollObservationScope = null;
                                                        break;
                                                    }
                                                    int i48 = size2;
                                                    if (((ScrollObservationScope) arrayList4.get(i47)).semanticsNodeId == i34) {
                                                        scrollObservationScope = (ScrollObservationScope) arrayList4.get(i47);
                                                        break;
                                                    } else {
                                                        i47++;
                                                        size2 = i48;
                                                    }
                                                }
                                                if (scrollObservationScope != null) {
                                                    z = false;
                                                } else {
                                                    scrollObservationScope = new ScrollObservationScope(i34, arrayList3);
                                                    z = true;
                                                }
                                                arrayList3.add(scrollObservationScope);
                                                if (z) {
                                                    obj = SemanticsProperties.PaneTitle;
                                                    if (Intrinsics.areEqual(obj16, obj)) {
                                                        str3 = (String) obj15;
                                                        zContainsKey2 = mutableScatterMap.containsKey(obj);
                                                        i24 = i36;
                                                        if (zContainsKey2) {
                                                            sendPaneChangeEvents(i34, i24, str3);
                                                        }
                                                        Unit unit14 = Unit.INSTANCE;
                                                    } else {
                                                        i16 = i36;
                                                        if (Intrinsics.areEqual(obj16, SemanticsProperties.StateDescription)) {
                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, i16);
                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, i16);
                                                        } else if (Intrinsics.areEqual(obj16, SemanticsProperties.ToggleableState)) {
                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 8192, 8);
                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                        } else if (Intrinsics.areEqual(obj16, SemanticsProperties.Error)) {
                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 3072, 8);
                                                        } else if (Intrinsics.areEqual(obj16, SemanticsProperties.ProgressBarRangeInfo)) {
                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, 8);
                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                        } else {
                                                            semanticsPropertyKey = SemanticsProperties.Selected;
                                                            arrayList4 = arrayList4;
                                                            if (Intrinsics.areEqual(obj16, semanticsPropertyKey)) {
                                                                obj8 = mutableScatterMap2.get(SemanticsProperties.Role);
                                                                if (obj8 == null) {
                                                                    obj8 = null;
                                                                }
                                                                role = (Role) obj8;
                                                                if (role == null) {
                                                                    z6 = false;
                                                                } else {
                                                                    z6 = true;
                                                                }
                                                                if (z6) {
                                                                    obj10 = mutableScatterMap2.get(semanticsPropertyKey);
                                                                    if (obj10 == null) {
                                                                        obj10 = null;
                                                                    }
                                                                    if (Intrinsics.areEqual(obj10, Boolean.TRUE)) {
                                                                        accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 4);
                                                                        SemanticsConfiguration semanticsConfiguration8 = semanticsConfiguration5;
                                                                        layoutNode3 = layoutNode3;
                                                                        SemanticsNode semanticsNode5 = new SemanticsNode(semanticsNode2.outerSemanticsNode, true, layoutNode3, semanticsConfiguration8);
                                                                        obj11 = semanticsNode5.getConfig().props.get(SemanticsProperties.ContentDescription);
                                                                        if (obj11 == null) {
                                                                            obj11 = null;
                                                                        }
                                                                        List list6 = (List) obj11;
                                                                        if (list6 != null) {
                                                                        }
                                                                        obj12 = semanticsNode5.getConfig().props.get(SemanticsProperties.Text);
                                                                        if (obj12 == null) {
                                                                            obj12 = null;
                                                                        }
                                                                        list = (List) obj12;
                                                                        semanticsConfiguration5 = semanticsConfiguration8;
                                                                        if (list != null) {
                                                                            obj9 = null;
                                                                            strFastJoinToString$default2 = ListUtilsKt.fastJoinToString$default(list, ",", null, 62);
                                                                        } else {
                                                                            obj9 = null;
                                                                            strFastJoinToString$default2 = null;
                                                                        }
                                                                        if (strFastJoinToString$default != null) {
                                                                            accessibilityEventCreateEvent.setContentDescription(strFastJoinToString$default);
                                                                            Unit unit15 = Unit.INSTANCE;
                                                                        }
                                                                        if (strFastJoinToString$default2 != null) {
                                                                            accessibilityEventCreateEvent.getText().add(strFastJoinToString$default2);
                                                                        }
                                                                        sendEvent(accessibilityEventCreateEvent);
                                                                    } else {
                                                                        semanticsConfiguration5 = semanticsConfiguration5;
                                                                        layoutNode3 = layoutNode3;
                                                                        obj9 = null;
                                                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                    }
                                                                } else {
                                                                    semanticsConfiguration5 = semanticsConfiguration5;
                                                                    layoutNode3 = layoutNode3;
                                                                    obj9 = null;
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, 8);
                                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                }
                                                            } else {
                                                                semanticsConfiguration5 = semanticsConfiguration5;
                                                                layoutNode3 = layoutNode3;
                                                                semanticsNode2 = semanticsNode2;
                                                                if (Intrinsics.areEqual(obj16, SemanticsProperties.ContentDescription)) {
                                                                    sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 4, (List) obj15);
                                                                } else {
                                                                    obj2 = SemanticsProperties.EditableText;
                                                                    str = "";
                                                                    if (Intrinsics.areEqual(obj16, obj2)) {
                                                                        if (mutableScatterMap2.containsKey(SemanticsActions.SetText)) {
                                                                            obj6 = mutableScatterMap.get(obj2);
                                                                            if (obj6 == null) {
                                                                                obj6 = null;
                                                                            }
                                                                            annotatedString2 = (AnnotatedString) obj6;
                                                                            if (annotatedString2 == null) {
                                                                                annotatedString2 = "";
                                                                            }
                                                                            obj7 = mutableScatterMap2.get(obj2);
                                                                            if (obj7 == null) {
                                                                                obj7 = null;
                                                                            }
                                                                            charSequence = (AnnotatedString) obj7;
                                                                            if (charSequence == null) {
                                                                                charSequence = "";
                                                                            }
                                                                            charSequenceTrimToSize = trimToSize(charSequence);
                                                                            length = annotatedString2.length();
                                                                            length2 = charSequence.length();
                                                                            if (length > length2) {
                                                                                i19 = length2;
                                                                            } else {
                                                                                i19 = length;
                                                                            }
                                                                            num4 = num6;
                                                                            i20 = 0;
                                                                            while (true) {
                                                                                i21 = length;
                                                                                if (i20 < i19) {
                                                                                    num5 = num5;
                                                                                    break;
                                                                                }
                                                                                num5 = num5;
                                                                                if (annotatedString2.charAt(i20) != charSequence.charAt(i20)) {
                                                                                    break;
                                                                                    break;
                                                                                } else {
                                                                                    i20++;
                                                                                    length = i21;
                                                                                    num5 = num5;
                                                                                }
                                                                            }
                                                                            i22 = 0;
                                                                            while (true) {
                                                                                if (i22 < i19 - i20) {
                                                                                    i23 = i22;
                                                                                    break;
                                                                                }
                                                                                i23 = i22;
                                                                                if (annotatedString2.charAt((i21 - 1) - i22) != charSequence.charAt((length2 - 1) - i23)) {
                                                                                    break;
                                                                                    break;
                                                                                }
                                                                                i22 = i23 + 1;
                                                                            }
                                                                            int i49 = (i21 - i23) - i20;
                                                                            int i410 = (length2 - i23) - i20;
                                                                            Object obj111 = SemanticsProperties.Password;
                                                                            boolean zContainsKey7 = mutableScatterMap.containsKey(obj111);
                                                                            boolean zContainsKey8 = mutableScatterMap2.containsKey(obj111);
                                                                            zContainsKey = mutableScatterMap.containsKey(SemanticsProperties.EditableText);
                                                                            if (zContainsKey) {
                                                                                z4 = false;
                                                                            } else {
                                                                                z4 = false;
                                                                            }
                                                                            if (zContainsKey) {
                                                                                z5 = false;
                                                                            } else {
                                                                                z5 = false;
                                                                            }
                                                                            if (z4) {
                                                                                num3 = num4;
                                                                                accessibilityEventCreateTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), num3, num4, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                            } else {
                                                                                num3 = num4;
                                                                                accessibilityEventCreateTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), num3, num4, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                            }
                                                                            accessibilityEventCreateTextSelectionChangedEvent.setClassName("android.widget.EditText");
                                                                            sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                            if (z4) {
                                                                                long j10 = ((TextRange) semanticsConfiguration5.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j10 >> 32));
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j10 & 4294967295L));
                                                                                sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                            } else {
                                                                                long j11 = ((TextRange) semanticsConfiguration5.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j11 >> 32));
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j11 & 4294967295L));
                                                                                sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                            }
                                                                            Unit unit16 = Unit.INSTANCE;
                                                                        } else {
                                                                            num3 = num6;
                                                                            i34 = i34;
                                                                            num5 = num5;
                                                                            semanticsConfiguration5 = semanticsConfiguration5;
                                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, Integer.valueOf(i28), 8);
                                                                        }
                                                                        i15 = i42;
                                                                    } else {
                                                                        num3 = num6;
                                                                        i34 = i34;
                                                                        num5 = num5;
                                                                        semanticsConfiguration5 = semanticsConfiguration5;
                                                                        i15 = i42;
                                                                        semanticsPropertyKey2 = SemanticsProperties.TextSelectionRange;
                                                                        if (Intrinsics.areEqual(obj16, semanticsPropertyKey2)) {
                                                                            obj5 = mutableScatterMap2.get(obj2);
                                                                            if (obj5 == null) {
                                                                                obj5 = null;
                                                                            }
                                                                            annotatedString = (AnnotatedString) obj5;
                                                                            if (annotatedString != null) {
                                                                                str = str2;
                                                                            }
                                                                            long j12 = ((TextRange) semanticsConfiguration5.get(semanticsPropertyKey2)).packedValue;
                                                                            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), Integer.valueOf((int) (j12 >> 32)), Integer.valueOf((int) (j12 & 4294967295L)), Integer.valueOf(str.length()), trimToSize(str)));
                                                                            sendPendingTextTraversedAtGranularityEvent(i37);
                                                                            Unit unit17 = Unit.INSTANCE;
                                                                        } else {
                                                                            i35 = i35;
                                                                            num6 = num3;
                                                                            if (Intrinsics.areEqual(obj16, semanticsPropertyKey3)) {
                                                                                notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                size = arrayList3.size();
                                                                                i17 = 0;
                                                                                while (true) {
                                                                                    if (i17 >= size) {
                                                                                        scrollObservationScope2 = null;
                                                                                        break;
                                                                                    } else {
                                                                                        if (((ScrollObservationScope) arrayList3.get(i17)).semanticsNodeId == i34) {
                                                                                            scrollObservationScope2 = (ScrollObservationScope) arrayList3.get(i17);
                                                                                            break;
                                                                                        }
                                                                                        i17++;
                                                                                    }
                                                                                }
                                                                                obj3 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                                if (obj3 == null) {
                                                                                    obj3 = null;
                                                                                }
                                                                                scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj3;
                                                                                obj4 = mutableScatterMap2.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                if (obj4 == null) {
                                                                                    obj4 = null;
                                                                                }
                                                                                scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj4;
                                                                                if (scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                    this.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, this.scheduleScrollEventIfNeededLambda, new DialogHostKt$DialogHost$1$1$1(i35, scrollObservationScope2, this));
                                                                                }
                                                                                Unit unit18 = Unit.INSTANCE;
                                                                            } else {
                                                                                notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                size = arrayList3.size();
                                                                                i17 = 0;
                                                                                while (true) {
                                                                                    if (i17 >= size) {
                                                                                        scrollObservationScope2 = null;
                                                                                        break;
                                                                                    } else {
                                                                                        if (((ScrollObservationScope) arrayList3.get(i17)).semanticsNodeId == i34) {
                                                                                            scrollObservationScope2 = (ScrollObservationScope) arrayList3.get(i17);
                                                                                            break;
                                                                                        }
                                                                                        i17++;
                                                                                    }
                                                                                }
                                                                                obj3 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                                if (obj3 == null) {
                                                                                    obj3 = null;
                                                                                }
                                                                                scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj3;
                                                                                obj4 = mutableScatterMap2.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                if (obj4 == null) {
                                                                                    obj4 = null;
                                                                                }
                                                                                scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj4;
                                                                                if (scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                    this.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, this.scheduleScrollEventIfNeededLambda, new DialogHostKt$DialogHost$1$1$1(i35, scrollObservationScope2, this));
                                                                                }
                                                                                Unit unit19 = Unit.INSTANCE;
                                                                            }
                                                                        }
                                                                    }
                                                                    num6 = num3;
                                                                }
                                                            }
                                                            i35 = i35;
                                                            semanticsConfiguration5 = semanticsConfiguration5;
                                                            i15 = i42;
                                                        }
                                                    }
                                                    i15 = i42;
                                                } else {
                                                    obj13 = mutableScatterMap.get(obj16);
                                                    if (obj13 == null) {
                                                        obj13 = null;
                                                    }
                                                    if (!Intrinsics.areEqual(obj15, obj13)) {
                                                        obj = SemanticsProperties.PaneTitle;
                                                        if (Intrinsics.areEqual(obj16, obj)) {
                                                            str3 = (String) obj15;
                                                            zContainsKey2 = mutableScatterMap.containsKey(obj);
                                                            i24 = i36;
                                                            if (zContainsKey2) {
                                                                sendPaneChangeEvents(i34, i24, str3);
                                                            }
                                                            Unit unit110 = Unit.INSTANCE;
                                                        } else {
                                                            i16 = i36;
                                                            if (Intrinsics.areEqual(obj16, SemanticsProperties.StateDescription)) {
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, i16);
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, i16);
                                                            } else if (Intrinsics.areEqual(obj16, SemanticsProperties.ToggleableState)) {
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 8192, 8);
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                            } else if (Intrinsics.areEqual(obj16, SemanticsProperties.Error)) {
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 3072, 8);
                                                            } else if (Intrinsics.areEqual(obj16, SemanticsProperties.ProgressBarRangeInfo)) {
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, 8);
                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                            } else {
                                                                semanticsPropertyKey = SemanticsProperties.Selected;
                                                                arrayList4 = arrayList4;
                                                                if (Intrinsics.areEqual(obj16, semanticsPropertyKey)) {
                                                                    obj8 = mutableScatterMap2.get(SemanticsProperties.Role);
                                                                    if (obj8 == null) {
                                                                        obj8 = null;
                                                                    }
                                                                    role = (Role) obj8;
                                                                    if (role == null) {
                                                                        z6 = false;
                                                                    } else {
                                                                        z6 = true;
                                                                    }
                                                                    if (z6) {
                                                                        obj10 = mutableScatterMap2.get(semanticsPropertyKey);
                                                                        if (obj10 == null) {
                                                                            obj10 = null;
                                                                        }
                                                                        if (Intrinsics.areEqual(obj10, Boolean.TRUE)) {
                                                                            accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 4);
                                                                            SemanticsConfiguration semanticsConfiguration9 = semanticsConfiguration5;
                                                                            layoutNode3 = layoutNode3;
                                                                            SemanticsNode semanticsNode6 = new SemanticsNode(semanticsNode2.outerSemanticsNode, true, layoutNode3, semanticsConfiguration9);
                                                                            obj11 = semanticsNode6.getConfig().props.get(SemanticsProperties.ContentDescription);
                                                                            if (obj11 == null) {
                                                                                obj11 = null;
                                                                            }
                                                                            List list7 = (List) obj11;
                                                                            if (list7 != null) {
                                                                            }
                                                                            obj12 = semanticsNode6.getConfig().props.get(SemanticsProperties.Text);
                                                                            if (obj12 == null) {
                                                                                obj12 = null;
                                                                            }
                                                                            list = (List) obj12;
                                                                            semanticsConfiguration5 = semanticsConfiguration9;
                                                                            if (list != null) {
                                                                                obj9 = null;
                                                                                strFastJoinToString$default2 = ListUtilsKt.fastJoinToString$default(list, ",", null, 62);
                                                                            } else {
                                                                                obj9 = null;
                                                                                strFastJoinToString$default2 = null;
                                                                            }
                                                                            if (strFastJoinToString$default != null) {
                                                                                accessibilityEventCreateEvent.setContentDescription(strFastJoinToString$default);
                                                                                Unit unit111 = Unit.INSTANCE;
                                                                            }
                                                                            if (strFastJoinToString$default2 != null) {
                                                                                accessibilityEventCreateEvent.getText().add(strFastJoinToString$default2);
                                                                            }
                                                                            sendEvent(accessibilityEventCreateEvent);
                                                                        } else {
                                                                            semanticsConfiguration5 = semanticsConfiguration5;
                                                                            layoutNode3 = layoutNode3;
                                                                            obj9 = null;
                                                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                        }
                                                                    } else {
                                                                        semanticsConfiguration5 = semanticsConfiguration5;
                                                                        layoutNode3 = layoutNode3;
                                                                        obj9 = null;
                                                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num5, 8);
                                                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, num6, 8);
                                                                    }
                                                                } else {
                                                                    semanticsConfiguration5 = semanticsConfiguration5;
                                                                    layoutNode3 = layoutNode3;
                                                                    semanticsNode2 = semanticsNode2;
                                                                    if (Intrinsics.areEqual(obj16, SemanticsProperties.ContentDescription)) {
                                                                        sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, 4, (List) obj15);
                                                                    } else {
                                                                        obj2 = SemanticsProperties.EditableText;
                                                                        str = "";
                                                                        if (Intrinsics.areEqual(obj16, obj2)) {
                                                                            if (mutableScatterMap2.containsKey(SemanticsActions.SetText)) {
                                                                                obj6 = mutableScatterMap.get(obj2);
                                                                                if (obj6 == null) {
                                                                                    obj6 = null;
                                                                                }
                                                                                annotatedString2 = (AnnotatedString) obj6;
                                                                                if (annotatedString2 == null) {
                                                                                    annotatedString2 = "";
                                                                                }
                                                                                obj7 = mutableScatterMap2.get(obj2);
                                                                                if (obj7 == null) {
                                                                                    obj7 = null;
                                                                                }
                                                                                charSequence = (AnnotatedString) obj7;
                                                                                if (charSequence == null) {
                                                                                    charSequence = "";
                                                                                }
                                                                                charSequenceTrimToSize = trimToSize(charSequence);
                                                                                length = annotatedString2.length();
                                                                                length2 = charSequence.length();
                                                                                if (length > length2) {
                                                                                    i19 = length2;
                                                                                } else {
                                                                                    i19 = length;
                                                                                }
                                                                                num4 = num6;
                                                                                i20 = 0;
                                                                                while (true) {
                                                                                    i21 = length;
                                                                                    if (i20 < i19) {
                                                                                        num5 = num5;
                                                                                        break;
                                                                                    }
                                                                                    num5 = num5;
                                                                                    if (annotatedString2.charAt(i20) != charSequence.charAt(i20)) {
                                                                                        break;
                                                                                        break;
                                                                                    } else {
                                                                                        i20++;
                                                                                        length = i21;
                                                                                        num5 = num5;
                                                                                    }
                                                                                }
                                                                                i22 = 0;
                                                                                while (true) {
                                                                                    if (i22 < i19 - i20) {
                                                                                        i23 = i22;
                                                                                        break;
                                                                                    }
                                                                                    i23 = i22;
                                                                                    if (annotatedString2.charAt((i21 - 1) - i22) != charSequence.charAt((length2 - 1) - i23)) {
                                                                                        break;
                                                                                        break;
                                                                                    }
                                                                                    i22 = i23 + 1;
                                                                                }
                                                                                int i411 = (i21 - i23) - i20;
                                                                                int i412 = (length2 - i23) - i20;
                                                                                Object obj112 = SemanticsProperties.Password;
                                                                                boolean zContainsKey9 = mutableScatterMap.containsKey(obj112);
                                                                                boolean zContainsKey10 = mutableScatterMap2.containsKey(obj112);
                                                                                zContainsKey = mutableScatterMap.containsKey(SemanticsProperties.EditableText);
                                                                                if (zContainsKey) {
                                                                                    z4 = false;
                                                                                } else {
                                                                                    z4 = false;
                                                                                }
                                                                                if (zContainsKey) {
                                                                                    z5 = false;
                                                                                } else {
                                                                                    z5 = false;
                                                                                }
                                                                                if (z4) {
                                                                                    num3 = num4;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), num3, num4, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                                } else {
                                                                                    num3 = num4;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), num3, num4, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                                }
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setClassName("android.widget.EditText");
                                                                                sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                if (z4) {
                                                                                    long j13 = ((TextRange) semanticsConfiguration5.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j13 >> 32));
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j13 & 4294967295L));
                                                                                    sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                } else {
                                                                                    long j14 = ((TextRange) semanticsConfiguration5.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j14 >> 32));
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j14 & 4294967295L));
                                                                                    sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                }
                                                                                Unit unit112 = Unit.INSTANCE;
                                                                            } else {
                                                                                num3 = num6;
                                                                                i34 = i34;
                                                                                num5 = num5;
                                                                                semanticsConfiguration5 = semanticsConfiguration5;
                                                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i34), 2048, Integer.valueOf(i28), 8);
                                                                            }
                                                                            i15 = i42;
                                                                        } else {
                                                                            num3 = num6;
                                                                            i34 = i34;
                                                                            num5 = num5;
                                                                            semanticsConfiguration5 = semanticsConfiguration5;
                                                                            i15 = i42;
                                                                            semanticsPropertyKey2 = SemanticsProperties.TextSelectionRange;
                                                                            if (Intrinsics.areEqual(obj16, semanticsPropertyKey2)) {
                                                                                obj5 = mutableScatterMap2.get(obj2);
                                                                                if (obj5 == null) {
                                                                                    obj5 = null;
                                                                                }
                                                                                annotatedString = (AnnotatedString) obj5;
                                                                                if (annotatedString != null) {
                                                                                    str = str2;
                                                                                }
                                                                                long j15 = ((TextRange) semanticsConfiguration5.get(semanticsPropertyKey2)).packedValue;
                                                                                sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i34), Integer.valueOf((int) (j15 >> 32)), Integer.valueOf((int) (j15 & 4294967295L)), Integer.valueOf(str.length()), trimToSize(str)));
                                                                                sendPendingTextTraversedAtGranularityEvent(i37);
                                                                                Unit unit113 = Unit.INSTANCE;
                                                                            } else {
                                                                                i35 = i35;
                                                                                num6 = num3;
                                                                                if (Intrinsics.areEqual(obj16, semanticsPropertyKey3)) {
                                                                                    notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                    size = arrayList3.size();
                                                                                    i17 = 0;
                                                                                    while (true) {
                                                                                        if (i17 >= size) {
                                                                                            scrollObservationScope2 = null;
                                                                                            break;
                                                                                        } else {
                                                                                            if (((ScrollObservationScope) arrayList3.get(i17)).semanticsNodeId == i34) {
                                                                                                scrollObservationScope2 = (ScrollObservationScope) arrayList3.get(i17);
                                                                                                break;
                                                                                            }
                                                                                            i17++;
                                                                                        }
                                                                                    }
                                                                                    obj3 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                                    if (obj3 == null) {
                                                                                        obj3 = null;
                                                                                    }
                                                                                    scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj3;
                                                                                    obj4 = mutableScatterMap2.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                    if (obj4 == null) {
                                                                                        obj4 = null;
                                                                                    }
                                                                                    scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj4;
                                                                                    if (scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                        this.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, this.scheduleScrollEventIfNeededLambda, new DialogHostKt$DialogHost$1$1$1(i35, scrollObservationScope2, this));
                                                                                    }
                                                                                    Unit unit114 = Unit.INSTANCE;
                                                                                } else {
                                                                                    notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                    size = arrayList3.size();
                                                                                    i17 = 0;
                                                                                    while (true) {
                                                                                        if (i17 >= size) {
                                                                                            scrollObservationScope2 = null;
                                                                                            break;
                                                                                        } else {
                                                                                            if (((ScrollObservationScope) arrayList3.get(i17)).semanticsNodeId == i34) {
                                                                                                scrollObservationScope2 = (ScrollObservationScope) arrayList3.get(i17);
                                                                                                break;
                                                                                            }
                                                                                            i17++;
                                                                                        }
                                                                                    }
                                                                                    obj3 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                                    if (obj3 == null) {
                                                                                        obj3 = null;
                                                                                    }
                                                                                    scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj3;
                                                                                    obj4 = mutableScatterMap2.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                    if (obj4 == null) {
                                                                                        obj4 = null;
                                                                                    }
                                                                                    scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj4;
                                                                                    if (scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                        this.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, this.scheduleScrollEventIfNeededLambda, new DialogHostKt$DialogHost$1$1$1(i35, scrollObservationScope2, this));
                                                                                    }
                                                                                    Unit unit115 = Unit.INSTANCE;
                                                                                }
                                                                            }
                                                                        }
                                                                        num6 = num3;
                                                                    }
                                                                }
                                                                i35 = i35;
                                                                semanticsConfiguration5 = semanticsConfiguration5;
                                                                i15 = i42;
                                                            }
                                                        }
                                                    }
                                                    i15 = i42;
                                                }
                                                j4 >>= 8;
                                                i35 = i35;
                                                i36 = 8;
                                                i34 = i34;
                                                layoutNode3 = layoutNode3;
                                                semanticsNode2 = semanticsNode2;
                                                i38 = i38;
                                                i40 = i14 + 1;
                                                length4 = i15;
                                                semanticsConfiguration5 = semanticsConfiguration5;
                                                arrayList4 = arrayList4;
                                                num5 = num5;
                                            } else {
                                                i14 = i40;
                                                i38 = i38;
                                                i15 = length4;
                                            }
                                            i35 = i35;
                                            j4 >>= 8;
                                            i35 = i35;
                                            i36 = 8;
                                            i34 = i34;
                                            layoutNode3 = layoutNode3;
                                            semanticsNode2 = semanticsNode2;
                                            i38 = i38;
                                            i40 = i14 + 1;
                                            length4 = i15;
                                            semanticsConfiguration5 = semanticsConfiguration5;
                                            arrayList4 = arrayList4;
                                            num5 = num5;
                                        }
                                        i8 = i34;
                                        num2 = num5;
                                        arrayList2 = arrayList4;
                                        i12 = i38;
                                        semanticsConfiguration2 = semanticsConfiguration5;
                                        layoutNode = layoutNode3;
                                        i6 = 0;
                                        i9 = 1;
                                        semanticsNode = semanticsNode2;
                                        i13 = length4;
                                        i30 = i35;
                                        if (i39 != i36) {
                                            break;
                                        }
                                    } else {
                                        i8 = i34;
                                        num2 = num5;
                                        arrayList2 = arrayList4;
                                        i12 = i38;
                                        semanticsConfiguration2 = semanticsConfiguration5;
                                        layoutNode = layoutNode3;
                                        i6 = 0;
                                        i9 = 1;
                                        semanticsNode = semanticsNode2;
                                        i13 = length4;
                                        i30 = i35;
                                    }
                                    int i50 = i12;
                                    if (i50 == i13) {
                                        break;
                                    }
                                    i35 = i30;
                                    i34 = i8;
                                    layoutNode2 = layoutNode;
                                    semanticsNode2 = semanticsNode;
                                    i32 = i5;
                                    i36 = 8;
                                    i38 = i50 + 1;
                                    length4 = i13;
                                    semanticsConfiguration5 = semanticsConfiguration2;
                                    arrayList4 = arrayList2;
                                    num5 = num2;
                                }
                            } else {
                                semanticsNode = semanticsNode2;
                                i8 = i34;
                                semanticsConfiguration = semanticsConfiguration3;
                                num2 = num5;
                                arrayList2 = arrayList4;
                                i5 = i32;
                                i30 = i35;
                                i6 = 0;
                                i9 = 1;
                                i10 = 0;
                            }
                            if (i10 == 0) {
                                Iterator it = semanticsConfiguration.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        i11 = i6;
                                        break;
                                    } else {
                                        if (!semanticsNode.getConfig().props.containsKey((SemanticsPropertyKey) ((Map.Entry) it.next()).getKey())) {
                                            i11 = i9;
                                            break;
                                        }
                                    }
                                }
                                i10 = i11;
                            }
                            if (i10 != 0) {
                                int iSemanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(i8);
                                i4 = 8;
                                sendEventForVirtualView$default(this, iSemanticsNodeIdToAccessibilityVirtualNodeId, 2048, num6, 8);
                            } else {
                                i4 = 8;
                            }
                        }
                    } else {
                        i3 = i33;
                        num2 = num5;
                        arrayList2 = arrayList4;
                        iArr2 = iArr3;
                        jArr2 = jArr3;
                        i4 = i31;
                        i5 = i32;
                        i6 = i26;
                        i7 = i27;
                    }
                    j2 >>= i4;
                    i33 = i3 + 1;
                    i31 = i4;
                    i26 = i6;
                    iArr3 = iArr2;
                    jArr3 = jArr2;
                    i27 = i7;
                    i32 = i5;
                    arrayList4 = arrayList2;
                    num5 = num2;
                    intObjectMap2 = intObjectMap;
                }
                num = num5;
                arrayList = arrayList4;
                iArr = iArr3;
                jArr = jArr3;
                i = i26;
                int i51 = i27;
                if (i32 != i31) {
                    return;
                } else {
                    i2 = i51;
                }
            } else {
                num = num5;
                arrayList = arrayList4;
                iArr = iArr3;
                jArr = jArr3;
                i = i26;
                i2 = i27;
            }
            if (i2 == i29) {
                return;
            }
            i27 = i2 + 1;
            intObjectMap2 = intObjectMap;
            length3 = i29;
            i25 = i28;
            i26 = i;
            iArr3 = iArr;
            jArr3 = jArr;
            arrayList4 = arrayList;
            num5 = num;
        }
    }

    public final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet mutableIntSet) {
        SemanticsConfiguration semanticsConfiguration;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(layoutNode)) {
            LayoutNode layoutNode2 = null;
            if (!layoutNode.nodes.m565hasH91voCI$ui(8)) {
                layoutNode = layoutNode.getParent$ui();
                while (true) {
                    if (layoutNode == null) {
                        layoutNode = null;
                        break;
                    } else if (layoutNode.nodes.m565hasH91voCI$ui(8)) {
                        break;
                    } else {
                        layoutNode = layoutNode.getParent$ui();
                    }
                }
            }
            if (layoutNode == null || (semanticsConfiguration = layoutNode.getSemanticsConfiguration()) == null) {
                return;
            }
            if (!semanticsConfiguration.isMergingSemanticsOfDescendants) {
                for (LayoutNode parent$ui = layoutNode.getParent$ui(); parent$ui != null; parent$ui = parent$ui.getParent$ui()) {
                    SemanticsConfiguration semanticsConfiguration2 = parent$ui.getSemanticsConfiguration();
                    if (semanticsConfiguration2 != null && semanticsConfiguration2.isMergingSemanticsOfDescendants) {
                        layoutNode2 = parent$ui;
                        break;
                    }
                }
                if (layoutNode2 != null) {
                    layoutNode = layoutNode2;
                }
            }
            int i = layoutNode.semanticsId;
            if (mutableIntSet.add(i)) {
                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i), 2048, 1, 8);
            }
        }
    }

    public final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int i = layoutNode.semanticsId;
            ScrollAxisRange scrollAxisRange = (ScrollAxisRange) this.pendingHorizontalScrollEvents.get(i);
            ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) this.pendingVerticalScrollEvents.get(i);
            if (scrollAxisRange == null && scrollAxisRange2 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventCreateEvent = createEvent(i, 4096);
            if (scrollAxisRange != null) {
                accessibilityEventCreateEvent.setScrollX((int) ((Number) scrollAxisRange.value.invoke()).floatValue());
                accessibilityEventCreateEvent.setMaxScrollX((int) ((Number) scrollAxisRange.maxValue.invoke()).floatValue());
            }
            if (scrollAxisRange2 != null) {
                accessibilityEventCreateEvent.setScrollY((int) ((Number) scrollAxisRange2.value.invoke()).floatValue());
                accessibilityEventCreateEvent.setMaxScrollY((int) ((Number) scrollAxisRange2.maxValue.invoke()).floatValue());
            }
            sendEvent(accessibilityEventCreateEvent);
        }
    }

    public final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i, int i2, boolean z) {
        String iterableTextForAccessibility;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        int i3 = semanticsNode.id;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsActions.SetSelection;
        if (semanticsConfiguration.props.containsKey(semanticsPropertyKey) && InvertMatrixKt.access$enabled(semanticsNode)) {
            Function3 function3 = (Function3) ((AccessibilityAction) semanticsNode.unmergedConfig.get(semanticsPropertyKey)).action;
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
            }
        } else if ((i != i2 || i2 != this.accessibilityCursorPosition) && (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) != null) {
            if (i < 0 || i != i2 || i2 > iterableTextForAccessibility.length()) {
                i = -1;
            }
            this.accessibilityCursorPosition = i;
            boolean z2 = iterableTextForAccessibility.length() > 0;
            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i3), z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z2 ? Integer.valueOf(iterableTextForAccessibility.length()) : null, iterableTextForAccessibility));
            sendPendingTextTraversedAtGranularityEvent(i3);
            return true;
        }
        return false;
    }

    public final Rect toBoundsInScreen(float f, float f2, float f3, float f4) {
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
        AndroidComposeView androidComposeView = this.view;
        long jM590localToScreenMKHz9U = androidComposeView.m590localToScreenMKHz9U(jFloatToRawIntBits);
        long jM590localToScreenMKHz9U2 = androidComposeView.m590localToScreenMKHz9U((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
        int i = (int) (jM590localToScreenMKHz9U >> 32);
        int i2 = (int) (jM590localToScreenMKHz9U2 >> 32);
        int i3 = (int) (jM590localToScreenMKHz9U & 4294967295L);
        int i4 = (int) (jM590localToScreenMKHz9U2 & 4294967295L);
        return new Rect((int) Math.floor(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.floor(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0064  */
    /* JADX WARN: Code duplicated, block: B:20:0x006f  */
    /* JADX WARN: Code duplicated, block: B:23:0x007c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateSemanticsNodesCopyAndPanes() {
        long j;
        long j2;
        long j3;
        char c;
        long[] jArr;
        long[] jArr2;
        long j4;
        int i;
        int iNumberOfTrailingZeros;
        char c2;
        SemanticsNodeCopy semanticsNodeCopy;
        MutableIntSet mutableIntSet = new MutableIntSet();
        MutableIntSet mutableIntSet2 = this.paneDisplayed;
        int[] iArr = mutableIntSet2.elements;
        long[] jArr3 = mutableIntSet2.metadata;
        int length = jArr3.length - 2;
        MutableIntObjectMap mutableIntObjectMap = this.previousSemanticsNodes;
        int i2 = 8;
        if (length >= 0) {
            int i3 = 0;
            j = 128;
            j2 = 255;
            while (true) {
                long j5 = jArr3[i3];
                char c3 = 7;
                j3 = -9187201950435737472L;
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j5 & 255) < 128) {
                            int i6 = iArr[(i3 << 3) + i5];
                            c2 = c3;
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) getCurrentSemanticsNodes().get(i6);
                            Object obj = null;
                            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.semanticsNode : null;
                            if (semanticsNode != null) {
                                if (!semanticsNode.unmergedConfig.props.containsKey(SemanticsProperties.PaneTitle)) {
                                    mutableIntSet.add(i6);
                                    semanticsNodeCopy = (SemanticsNodeCopy) mutableIntObjectMap.get(i6);
                                    if (semanticsNodeCopy != null) {
                                        Object obj2 = semanticsNodeCopy.unmergedConfig.props.get(SemanticsProperties.PaneTitle);
                                        obj = (String) (obj2 != null ? obj2 : null);
                                    }
                                    sendPaneChangeEvents(i6, 32, obj);
                                }
                            } else {
                                mutableIntSet.add(i6);
                                semanticsNodeCopy = (SemanticsNodeCopy) mutableIntObjectMap.get(i6);
                                if (semanticsNodeCopy != null) {
                                    Object obj3 = semanticsNodeCopy.unmergedConfig.props.get(SemanticsProperties.PaneTitle);
                                    obj = (String) (obj3 != null ? obj3 : null);
                                }
                                sendPaneChangeEvents(i6, 32, obj);
                            }
                        } else {
                            c2 = c3;
                        }
                        j5 >>= 8;
                        i5++;
                        c3 = c2;
                    }
                    c = c3;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    c = 7;
                }
                if (i3 == length) {
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            j = 128;
            j2 = 255;
            j3 = -9187201950435737472L;
            c = 7;
        }
        int[] iArr2 = mutableIntSet.elements;
        long[] jArr4 = mutableIntSet.metadata;
        int length2 = jArr4.length - 2;
        if (length2 >= 0) {
            int i7 = 0;
            while (true) {
                long j6 = jArr4[i7];
                if ((((~j6) << c) & j6 & j3) != j3) {
                    int i8 = 8 - ((~(i7 - length2)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j6 & j2) < j) {
                            int i10 = iArr2[(i7 << 3) + i9];
                            int i11 = (-862048943) * i10;
                            int i12 = i11 ^ (i11 << 16);
                            int i13 = i12 & 127;
                            int i14 = mutableIntSet2._capacity;
                            int i15 = (i12 >>> 7) & i14;
                            i = i2;
                            int i16 = 0;
                            while (true) {
                                long[] jArr5 = mutableIntSet2.metadata;
                                int i17 = i15 >> 3;
                                jArr2 = jArr4;
                                int i18 = (i15 & 7) << 3;
                                j4 = j6;
                                long j7 = (jArr5[i17] >>> i18) | ((jArr5[i17 + 1] << (64 - i18)) & ((-i18) >> 63));
                                int i19 = i14;
                                long j8 = (((long) i13) * 72340172838076673L) ^ j7;
                                long j9 = (j8 - 72340172838076673L) & (~j8) & j3;
                                while (j9 != 0) {
                                    iNumberOfTrailingZeros = (i15 + (Long.numberOfTrailingZeros(j9) >> 3)) & i19;
                                    int i20 = i19;
                                    if (mutableIntSet2.elements[iNumberOfTrailingZeros] == i10) {
                                        break;
                                    }
                                    j9 &= j9 - 1;
                                    i19 = i20;
                                }
                                int i21 = i19;
                                if ((j7 & ((~j7) << 6) & j3) != 0) {
                                    iNumberOfTrailingZeros = -1;
                                    break;
                                }
                                i16 += 8;
                                i15 = (i15 + i16) & i21;
                                jArr4 = jArr2;
                                i14 = i21;
                                j6 = j4;
                            }
                            int i22 = iNumberOfTrailingZeros;
                            if (i22 >= 0) {
                                mutableIntSet2.removeElementAt(i22);
                            }
                        } else {
                            jArr2 = jArr4;
                            j4 = j6;
                            i = i2;
                        }
                        j6 = j4 >> i;
                        i9++;
                        i2 = i;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i8 != i2) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i7 == length2) {
                    break;
                }
                i7++;
                jArr4 = jArr;
                i2 = 8;
            }
        }
        mutableIntObjectMap.clear();
        IntObjectMap currentSemanticsNodes = getCurrentSemanticsNodes();
        int[] iArr3 = currentSemanticsNodes.keys;
        Object[] objArr = currentSemanticsNodes.values;
        long[] jArr6 = currentSemanticsNodes.metadata;
        int length3 = jArr6.length - 2;
        if (length3 >= 0) {
            int i23 = 0;
            while (true) {
                long j10 = jArr6[i23];
                if ((((~j10) << c) & j10 & j3) != j3) {
                    int i24 = 8 - ((~(i23 - length3)) >>> 31);
                    for (int i25 = 0; i25 < i24; i25++) {
                        if ((j10 & j2) < j) {
                            int i26 = (i23 << 3) + i25;
                            int i27 = iArr3[i26];
                            SemanticsNode semanticsNode2 = ((SemanticsNodeWithAdjustedBounds) objArr[i26]).semanticsNode;
                            SemanticsConfiguration semanticsConfiguration = semanticsNode2.unmergedConfig;
                            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.PaneTitle;
                            if (semanticsConfiguration.props.containsKey(semanticsPropertyKey) && mutableIntSet2.add(i27)) {
                                sendPaneChangeEvents(i27, 16, (String) semanticsNode2.unmergedConfig.get(semanticsPropertyKey));
                            }
                            mutableIntObjectMap.set(i27, new SemanticsNodeCopy(semanticsNode2, getCurrentSemanticsNodes()));
                        }
                        j10 >>= 8;
                    }
                    if (i24 != 8) {
                        break;
                    }
                }
                if (i23 == length3) {
                    break;
                } else {
                    i23++;
                }
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }
}
