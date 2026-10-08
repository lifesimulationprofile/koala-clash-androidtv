package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.Trace;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.TranslationRequestValue;
import android.view.translation.ViewTranslationRequest;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$$ExternalSyntheticLambda4;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.collection.IntObjectMapKt;
import androidx.collection.LongSparseArray;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.retain.ForgetfulRetainedValuesStore;
import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.compose.runtime.retain.RetainedValuesStore;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex$Session;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draw.PainterNode$measure$1;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwner$dispatchKeyEvent$1;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1;
import androidx.compose.ui.focus.FocusPropertiesImpl;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidGraphicsContext;
import androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.HitPathTracker;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.InsetsListener;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OuterPlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.AndroidComposeView.RootModifierNode;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$1;
import androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$2;
import androidx.compose.ui.scrollcapture.ScrollCaptureCandidate;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.semantics.SemanticsSortKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.spatial.ThrottledCallbacks;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.android.CanvasCompatS$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi21;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi24;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi25;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi34;
import androidx.compose.ui.text.input.RecordingInputConnection;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavGraphNavigator$navigate$missingRequiredArgs$1;
import androidx.navigation.Navigator;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.memory.MemoryCacheService;
import coil.network.HttpException;
import coil.request.Parameters;
import coil.request.RequestService;
import com.google.android.gms.internal.mlkit_vision_barcode.zzss;
import com.google.android.gms.internal.mlkit_vision_barcode.zzst;
import com.google.android.gms.internal.mlkit_vision_barcode.zzto;
import com.google.android.gms.tasks.zzg;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import com.koala.clash.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.JobKt;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, RootForTest, MatrixPositionCalculator, DefaultLifecycleObserver, OutOfFrameExecutor, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnTouchModeChangeListener, FocusListener {
    public static Method addChangeCallbackMethod;
    public static final MutableObjectList composeViews = new MutableObjectList();
    public static Method dispatchOnScrollChangedMethod;
    public static Method getBooleanMethod;
    public static Camera2CameraControlImpl$$ExternalSyntheticLambda4 systemPropertiesChangedRunnable;
    public static Class systemPropertiesClass;
    public AndroidViewsHandler _androidViewsHandler;
    public final Dispatcher _autofill;
    public final AndroidAutofillManager _autofillManager;
    public final ParcelableSnapshotMutableState _composeViewContext$delegate;
    public final InputModeManagerImpl _inputModeManager;
    public TextInputServiceAndroid _legacyTextInputServiceAndroid;
    public View _rootView;
    public DelegatingSoftwareKeyboardController _softwareKeyboardController;
    public TextInputService _textInputService;
    public final ParcelableSnapshotMutableState _viewTreeOwners$delegate;
    public final LazyWindowInfo _windowInfo;
    public final AndroidAccessibilityManager accessibilityManager;
    public final AutofillTree autofillTree;
    public final CanvasHolder canvasHolder;
    public final AndroidClipboard clipboard;
    public final AndroidClipboardManager clipboardManager;
    public final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    public boolean composeViewContextIncrementedDuringInit;
    public final ParcelableSnapshotMutableState configuration$delegate;
    public AndroidContentCaptureManager contentCaptureManager;
    public CoroutineContext coroutineContext;
    public float currentFrameRate;
    public float currentFrameRateCategory;
    public final ParcelableSnapshotMutableState density$delegate;
    public final DerivedSnapshotState derivedIsAttached$delegate;
    public final MutableObjectList dirtyLayers;
    public final AndroidDragAndDropManager dragAndDropManager;
    public final MutableObjectList endApplyChangesListeners;
    public final FocusOwnerImpl focusOwner;
    public final MutableState fontFamilyResolver$delegate;
    public final Font$ResourceLoader fontLoader;
    public boolean forceUseMatrixCache;
    public LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler;
    public final View frameRateCategoryView;
    public long globalPosition;
    public final AndroidGraphicsContext graphicsContext;
    public final HapticFeedback hapticFeedBack;
    public boolean hoverExitReceived;
    public final MinimalEncoder indirectPointerNavigationGestureDetector;
    public final InsetsListener insetsListener;
    public final ParcelableSnapshotMutableState isAttached$delegate;
    public boolean isDrawingContent;
    public boolean keyboardModifiersRequireUpdate;
    public long lastDownPointerPosition;
    public long lastMatrixRecalculationAnimationTime;
    public final RequestService layerCache;
    public final ParcelableSnapshotMutableState layoutDirection$delegate;
    public final MutableIntObjectMap layoutNodes;
    public LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry lifecycleRetainedValuesStoreOwnerEntry;
    public final DerivedSnapshotState localeList$delegate;
    public final CalculateMatrixToWindow matrixToWindow;
    public final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    public final ModifierLocalManager modifierLocalManager;
    public final MotionEventAdapter motionEventAdapter;
    public boolean observationClearRequested;
    public Constraints onMeasureConstraints;
    public Function1 onReadyForComposition;
    public final ArrayDeque outOfFrameQueue;
    public final AndroidComposeView$$ExternalSyntheticLambda0 outOfFrameRunnable;
    public final AndroidComposeView$pointerIconService$1 pointerIconService;
    public final Exchange pointerInputEventProcessor;
    public MutableObjectList postponedDirtyLayers;
    public MotionEvent previousMotionEvent;
    public IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxisOverride;
    public final RectManager rectManager;
    public long relayoutTime;
    public final AndroidComposeView$localeList$2 resendMotionEventOnLayout;
    public final zzg resendMotionEventRunnable;
    public RetainedValuesStore retainedValuesStore;
    public final LayoutNode root;
    public final MemoryCacheService scrollCapture;
    public final SemanticsOwner semanticsOwner;
    public final AndroidComposeView$$ExternalSyntheticLambda0 sendHoverExitEvent;
    public final LayoutNodeDrawScope sharedDrawScope;
    public boolean showLayoutBounds;
    public final OwnerSnapshotObserver snapshotObserver;
    public final boolean superclassInitComplete;
    public final AtomicReference textInputSessionMutex;
    public final AndroidTextToolbar textToolbar;
    public final float[] tmpMatrix;
    public final int[] tmpPositionArray;
    public final AndroidViewConfiguration viewConfiguration;
    public final float[] viewToWindowMatrix;
    public final DerivedSnapshotState viewTreeOwners$delegate;
    public boolean wasMeasuredWithMultipleConstraints;
    public long windowPosition;
    public final float[] windowToViewMatrix;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class ViewTreeOwners {
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeView$getFocusedRect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends Lambda implements Function1 {
        public static final AnonymousClass1 INSTANCE;
        public static final AnonymousClass1 INSTANCE$1;
        public static final AnonymousClass1 INSTANCE$2;
        public static final AnonymousClass1 INSTANCE$3;
        public final /* synthetic */ int $r8$classId;

        static {
            int i = 1;
            INSTANCE = new AnonymousClass1(i, 0);
            INSTANCE$1 = new AnonymousClass1(i, 1);
            INSTANCE$2 = new AnonymousClass1(i, 2);
            INSTANCE$3 = new AnonymousClass1(i, 3);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, int i2) {
            super(i);
            this.$r8$classId = i2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return Boolean.TRUE;
                case 1:
                    SemanticsConfiguration config = ((SemanticsNode) obj).getConfig();
                    return Boolean.valueOf(config.props.containsKey(SemanticsProperties.LinkTestMarker));
                case 2:
                    CompositionLocalAccessorScope compositionLocalAccessorScope = (CompositionLocalAccessorScope) obj;
                    compositionLocalAccessorScope.getCurrentValue(AndroidCompositionLocals_androidKt.LocalConfiguration);
                    return ((Context) compositionLocalAccessorScope.getCurrentValue(AndroidCompositionLocals_androidKt.LocalContext)).getResources();
                default:
                    return Boolean.valueOf(InvertMatrixKt.canBeSavedToBundle(obj));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeView$textInputSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00141 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00141(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            AndroidComposeView.this.textInputSession(null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidComposeView(Context context, ComposeViewContext composeViewContext) {
        Dispatcher dispatcher;
        AndroidAutofillManager androidAutofillManager;
        LayoutDirection layoutDirection;
        super(context);
        final AndroidComposeView androidComposeView = this;
        androidComposeView._composeViewContext$delegate = Stack.mutableStateOf$default(composeViewContext);
        androidComposeView.lastDownPointerPosition = 9205357640488583168L;
        int i = 1;
        androidComposeView.superclassInitComplete = true;
        androidComposeView.sharedDrawScope = composeViewContext.sharedDrawScope;
        androidComposeView.retainedValuesStore = ForgetfulRetainedValuesStore.INSTANCE;
        androidComposeView.outOfFrameQueue = new ArrayDeque();
        int i2 = 0;
        androidComposeView.outOfFrameRunnable = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, i2);
        androidComposeView.density$delegate = new ParcelableSnapshotMutableState(AndroidDensity_androidKt.Density(context), NeverEqualPolicy.INSTANCE$1);
        androidComposeView.focusOwner = new FocusOwnerImpl(androidComposeView, androidComposeView);
        androidComposeView.coroutineContext = composeViewContext.compositionContext.getEffectCoroutineContext();
        androidComposeView.dragAndDropManager = new AndroidDragAndDropManager();
        androidComposeView._windowInfo = new LazyWindowInfo();
        androidComposeView.isAttached$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
        androidComposeView.derivedIsAttached$delegate = Stack.derivedStateOf(new AndroidComposeView$localeList$2(androidComposeView, i));
        androidComposeView.canvasHolder = composeViewContext.canvasHolder;
        androidComposeView.viewConfiguration = composeViewContext.viewConfiguration;
        androidComposeView.insetsListener = new InsetsListener();
        int i3 = 3;
        LayoutNode layoutNode = new LayoutNode(3);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(androidComposeView.getDensity());
        layoutNode.setViewConfiguration(androidComposeView.getViewConfiguration());
        layoutNode.setModifier(Modifier.CC.$default$then(new ModifierNodeElement() { // from class: androidx.compose.ui.platform.AndroidComposeView$root$1$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public final Modifier.Node create() {
                return this.this$0.new RootModifierNode();
            }

            public final boolean equals(Object obj) {
                return obj == this;
            }

            public final int hashCode() {
                return this.this$0.hashCode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public final /* bridge */ /* synthetic */ void update(Modifier.Node node) {
            }
        }, ((FocusOwnerImpl) androidComposeView.getFocusOwner()).modifier).then(androidComposeView.m599getDragAndDropManager().modifier));
        androidComposeView.root = layoutNode;
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        androidComposeView.layoutNodes = new MutableIntObjectMap();
        androidComposeView.getLayoutNodes();
        androidComposeView.rectManager = new RectManager(androidComposeView);
        androidComposeView.semanticsOwner = new SemanticsOwner(androidComposeView.getRoot(), new EmptySemanticsModifier(), androidComposeView.getLayoutNodes());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(androidComposeView);
        androidComposeView.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        androidComposeView.contentCaptureManager = new AndroidContentCaptureManager(androidComposeView, new FocusableNode.AnonymousClass1(0, androidComposeView, InvertMatrixKt.class, "getContentCaptureSessionCompat", "getContentCaptureSessionCompat(Landroid/view/View;)Landroidx/compose/ui/contentcapture/ContentCaptureSessionWrapper;", 1, 0, 3));
        androidComposeView.accessibilityManager = composeViewContext.accessibilityManager;
        androidComposeView.graphicsContext = new AndroidGraphicsContext(androidComposeView);
        androidComposeView.autofillTree = new AutofillTree();
        androidComposeView.dirtyLayers = new MutableObjectList();
        androidComposeView.motionEventAdapter = new MotionEventAdapter();
        LayoutNode root = androidComposeView.getRoot();
        Exchange exchange = new Exchange();
        exchange.call = root;
        exchange.finder = new HitPathTracker((InnerNodeCoordinator) root.nodes.innerCoordinator);
        exchange.codec = new MemoryCacheService(5);
        exchange.connection = new HitTestResult();
        androidComposeView.pointerInputEventProcessor = exchange;
        androidComposeView.configuration$delegate = Stack.mutableStateOf$default(new Configuration(context.getResources().getConfiguration()));
        androidComposeView.localeList$delegate = Stack.derivedStateOf(new AndroidComposeView$localeList$2(androidComposeView, i2));
        if (autofillSupported()) {
            AutofillTree autofillTree = androidComposeView.getAutofillTree();
            dispatcher = new Dispatcher();
            dispatcher.executorServiceOrNull = androidComposeView;
            dispatcher.readyAsyncCalls = autofillTree;
            AutofillManager autofillManagerM324m = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m324m(androidComposeView.getContext().getSystemService(AndroidAutofill$$ExternalSyntheticApiModelOutline0.m$1()));
            if (autofillManagerM324m == null) {
                throw new IllegalStateException("Autofill service could not be located.");
            }
            dispatcher.runningAsyncCalls = autofillManagerM324m;
            androidComposeView.setImportantForAutofill(1);
            ExposureStateImpl autofillId = ViewCompatShims.getAutofillId(androidComposeView);
            AutofillId autofillIdM = autofillId != null ? Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(autofillId.mLock) : null;
            if (autofillIdM == null) {
                throw Modifier.CC.m("Required value was null.");
            }
            dispatcher.runningSyncCalls = autofillIdM;
        } else {
            dispatcher = null;
        }
        androidComposeView._autofill = dispatcher;
        if (autofillSupported()) {
            AutofillManager autofillManagerM324m2 = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m324m(context.getSystemService(AndroidAutofill$$ExternalSyntheticApiModelOutline0.m$1()));
            if (autofillManagerM324m2 == null) {
                throw Modifier.CC.m("Autofill service could not be located.");
            }
            androidComposeView = this;
            androidAutofillManager = new AndroidAutofillManager(new Parameters.Builder(i3, autofillManagerM324m2), getSemanticsOwner(), this, getRectManager(), context.getPackageName());
        } else {
            androidAutofillManager = null;
        }
        androidComposeView._autofillManager = androidAutofillManager;
        androidComposeView.clipboardManager = composeViewContext.clipboardManager;
        androidComposeView.clipboard = composeViewContext.clipboard;
        androidComposeView.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(androidComposeView, i2));
        androidComposeView.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(androidComposeView.getRoot());
        long j = Integer.MAX_VALUE;
        androidComposeView.globalPosition = (j & 4294967295L) | (j << 32);
        androidComposeView.tmpPositionArray = new int[]{0, 0};
        float[] fArrM442constructorimpl$default = Matrix.m442constructorimpl$default();
        androidComposeView.tmpMatrix = fArrM442constructorimpl$default;
        androidComposeView.viewToWindowMatrix = Matrix.m442constructorimpl$default();
        androidComposeView.windowToViewMatrix = Matrix.m442constructorimpl$default();
        androidComposeView.lastMatrixRecalculationAnimationTime = -1L;
        androidComposeView.windowPosition = 9187343241974906880L;
        androidComposeView._viewTreeOwners$delegate = Stack.mutableStateOf$default(null);
        androidComposeView.viewTreeOwners$delegate = Stack.derivedStateOf(new AndroidComposeView$localeList$2(androidComposeView, i3));
        androidComposeView.textInputSessionMutex = new AtomicReference(null);
        androidComposeView.fontLoader = composeViewContext.fontLoader;
        androidComposeView.fontFamilyResolver$delegate = composeViewContext.fontFamilyResolver;
        int layoutDirection2 = context.getResources().getConfiguration().getLayoutDirection();
        int[] iArr = FocusInteropUtils_androidKt.tempCoordinates;
        LayoutDirection layoutDirection3 = LayoutDirection.Ltr;
        if (layoutDirection2 != 0) {
            layoutDirection = layoutDirection2 != 1 ? null : LayoutDirection.Rtl;
        } else {
            layoutDirection = layoutDirection3;
        }
        androidComposeView.layoutDirection$delegate = Stack.mutableStateOf$default(layoutDirection != null ? layoutDirection : layoutDirection3);
        androidComposeView.hapticFeedBack = composeViewContext.hapticFeedback;
        int i4 = 2;
        androidComposeView._inputModeManager = new InputModeManagerImpl(androidComposeView.isInTouchMode() ? 1 : 2);
        ModifierLocalManager modifierLocalManager = new ModifierLocalManager();
        new MutableVector(new BackwardsCompatNode[16]);
        new MutableVector(new ModifierLocal[16]);
        new MutableVector(new LayoutNode[16]);
        new MutableVector(new ModifierLocal[16]);
        androidComposeView.modifierLocalManager = modifierLocalManager;
        AndroidTextToolbar androidTextToolbar = new AndroidTextToolbar();
        new Handshake.AnonymousClass2(10, androidTextToolbar);
        androidComposeView.textToolbar = androidTextToolbar;
        androidComposeView.layerCache = new RequestService(8);
        androidComposeView.endApplyChangesListeners = new MutableObjectList();
        androidComposeView.resendMotionEventRunnable = new zzg(9, androidComposeView);
        androidComposeView.sendHoverExitEvent = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, i);
        AndroidComposeView$snapshotObserver$1 androidComposeView$snapshotObserver$1 = new AndroidComposeView$snapshotObserver$1(androidComposeView, i);
        final MinimalEncoder minimalEncoder = new MinimalEncoder();
        minimalEncoder.stringToEncode = androidComposeView$snapshotObserver$1;
        minimalEncoder.ecLevel = 0;
        minimalEncoder.encoders = new GestureDetector(context, new GestureDetector.OnGestureListener() { // from class: androidx.compose.ui.platform.IndirectPointerNavigationGestureDetector$gestureDetector$1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                MinimalEncoder minimalEncoder2 = minimalEncoder;
                AndroidComposeView$snapshotObserver$1 androidComposeView$snapshotObserver$2 = (AndroidComposeView$snapshotObserver$1) minimalEncoder2.stringToEncode;
                if (!minimalEncoder2.isGS1) {
                    int i5 = minimalEncoder2.ecLevel;
                    if (i5 == 1) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            ((FocusOwnerImpl) androidComposeView$snapshotObserver$2.this$0.getFocusOwner()).m346moveFocusaToIllA(f > 0.0f ? 1 : 2, false);
                            Unit unit = Unit.INSTANCE;
                            return true;
                        }
                    } else if (i5 == 2 && Math.abs(f2) > Math.abs(f)) {
                        ((FocusOwnerImpl) androidComposeView$snapshotObserver$2.this$0.getFocusOwner()).m346moveFocusaToIllA(f2 > 0.0f ? 1 : 2, false);
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }
        });
        androidComposeView.indirectPointerNavigationGestureDetector = minimalEncoder;
        androidComposeView.resendMotionEventOnLayout = new AndroidComposeView$localeList$2(androidComposeView, i4);
        int i5 = Build.VERSION.SDK_INT;
        androidComposeView.matrixToWindow = i5 < 29 ? new CalculateMatrixToWindowApi21(fArrM442constructorimpl$default) : new CalculateMatrixToWindowApi29();
        androidComposeView.addOnAttachStateChangeListener(androidComposeView.contentCaptureManager);
        androidComposeView.setWillNotDraw(false);
        androidComposeView.setFocusable(true);
        if (i5 >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(androidComposeView, 1, false);
        }
        androidComposeView.setFocusableInTouchMode(true);
        androidComposeView.setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(androidComposeView, androidComposeViewAccessibilityDelegateCompat);
        androidComposeView.setOnDragListener(androidComposeView.m599getDragAndDropManager());
        androidComposeView.getRoot().attach$ui(androidComposeView);
        if (i5 >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(androidComposeView);
        }
        if (isArrEnabled$ui()) {
            View view = new View(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
            view.setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
            androidComposeView.frameRateCategoryView = view;
            androidComposeView.addView(view, -1);
        }
        androidComposeView.scrollCapture = i5 >= 31 ? new MemoryCacheService(7) : null;
        androidComposeView.pointerIconService = new AndroidComposeView$pointerIconService$1(androidComposeView);
    }

    public static boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    public static long m585convertMeasureSpecI7RO_PI(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return (((long) 0) << 32) | ((long) size);
        }
        if (mode == 0) {
            return (((long) 0) << 32) | ((long) Integer.MAX_VALUE);
        }
        if (mode != 1073741824) {
            throw new IllegalStateException();
        }
        long j = size;
        return j | (j << 32);
    }

    public static View findViewByAccessibilityIdRootedAtCurrentView(View view, int i) throws NoSuchMethodException {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", null);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(view, null), Integer.valueOf(i))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(viewGroup.getChildAt(i2), i);
                    if (viewFindViewByAccessibilityIdRootedAtCurrentView != null) {
                        return viewFindViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
            }
        }
        return null;
    }

    private final boolean getDerivedIsAttached() {
        return ((Boolean) this.derivedIsAttached$delegate.getValue()).booleanValue();
    }

    private final TextInputServiceAndroid getLegacyTextInputServiceAndroid() {
        TextInputServiceAndroid textInputServiceAndroid = this._legacyTextInputServiceAndroid;
        if (textInputServiceAndroid != null) {
            return textInputServiceAndroid;
        }
        TextInputServiceAndroid textInputServiceAndroid2 = new TextInputServiceAndroid(getView(), this);
        this._legacyTextInputServiceAndroid = textInputServiceAndroid2;
        return textInputServiceAndroid2;
    }

    private final ComposeViewContext get_composeViewContext() {
        return (ComposeViewContext) this._composeViewContext$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeOwners get_viewTreeOwners() {
        Modifier.CC.m(this._viewTreeOwners$delegate.getValue());
        return null;
    }

    public static void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui();
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            invalidateLayers((LayoutNode) objArr[i2]);
        }
    }

    public static boolean isArrEnabled$ui() {
        return Build.VERSION.SDK_INT >= 35;
    }

    public static boolean isBadMotionEvent(MotionEvent motionEvent) {
        boolean z = (Float.floatToRawIntBits(motionEvent.getX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawY()) & Integer.MAX_VALUE) >= 2139095040;
        if (!z) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 1; i < pointerCount; i++) {
                z = (Float.floatToRawIntBits(motionEvent.getX(i)) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY(i)) & Integer.MAX_VALUE) >= 2139095040 || (Build.VERSION.SDK_INT >= 29 && !MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(motionEvent, i));
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    private final void setAttached(boolean z) {
        this.isAttached$delegate.setValue(Boolean.valueOf(z));
    }

    private void setDensity(Density density) {
        this.density$delegate.setValue(density);
    }

    private void setFontFamilyResolver(FontFamily$Resolver fontFamily$Resolver) {
        this.fontFamilyResolver$delegate.setValue(fontFamily$Resolver);
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    private final void set_composeViewContext(ComposeViewContext composeViewContext) {
        this._composeViewContext$delegate.setValue(composeViewContext);
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        FocusTargetNode focusTargetNode = ((FocusOwnerImpl) getFocusOwner()).rootFocusNode;
        if (!focusTargetNode.isAttached) {
            return;
        }
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.access$addLayoutNodeChildren(mutableVector, node);
        } else {
            mutableVector.add(node2);
        }
        while (true) {
            int i3 = mutableVector.size;
            if (i3 == 0) {
                return;
            }
            Modifier.Node node3 = (Modifier.Node) mutableVector.removeAt(i3 - 1);
            if ((node3.aggregateChildKindSet & 1024) != 0) {
                for (Modifier.Node node4 = node3; node4 != null && node4.isAttached; node4 = node4.child) {
                    if ((node4.kindSet & 1024) != 0) {
                        Modifier.Node nodeAccess$pop = node4;
                        MutableVector mutableVector2 = null;
                        while (nodeAccess$pop != null) {
                            int i4 = 0;
                            if (nodeAccess$pop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeAccess$pop;
                                if (focusTargetNode2.isAttached && focusTargetNode2.fetchFocusProperties$ui().canFocus) {
                                    super.addFocusables(arrayList, i, i2);
                                    FocusTargetNode focusTargetNode3 = ((FocusOwnerImpl) getFocusOwner()).rootFocusNode;
                                    if (focusTargetNode3.isAttached) {
                                        if (!focusTargetNode3.node.isAttached) {
                                            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
                                        }
                                        MutableVector mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                        Modifier.Node node5 = focusTargetNode3.node;
                                        Modifier.Node node6 = node5.child;
                                        if (node6 == null) {
                                            HitTestResultKt.access$addLayoutNodeChildren(mutableVector3, node5);
                                        } else {
                                            mutableVector3.add(node6);
                                        }
                                        while (true) {
                                            int i5 = mutableVector3.size;
                                            if (i5 == 0) {
                                                break;
                                            }
                                            Modifier.Node node7 = (Modifier.Node) mutableVector3.removeAt(i5 - 1);
                                            if ((node7.aggregateChildKindSet & 1024) != 0) {
                                                for (Modifier.Node node8 = node7; node8 != null && node8.isAttached; node8 = node8.child) {
                                                    if ((node8.kindSet & 1024) != 0) {
                                                        Modifier.Node nodeAccess$pop2 = node8;
                                                        MutableVector mutableVector4 = null;
                                                        while (nodeAccess$pop2 != null) {
                                                            if (nodeAccess$pop2 instanceof FocusTargetNode) {
                                                                FocusTargetNode focusTargetNode4 = (FocusTargetNode) nodeAccess$pop2;
                                                                if (focusTargetNode4.isAttached) {
                                                                    FocusPropertiesImpl focusPropertiesImplFetchFocusProperties$ui = focusTargetNode4.fetchFocusProperties$ui();
                                                                    if (focusTargetNode4.isAttached && focusPropertiesImplFetchFocusProperties$ui.canFocus) {
                                                                        return;
                                                                    }
                                                                }
                                                            } else if ((nodeAccess$pop2.kindSet & 1024) != 0 && (nodeAccess$pop2 instanceof DelegatingNode)) {
                                                                int i6 = 0;
                                                                for (Modifier.Node node9 = ((DelegatingNode) nodeAccess$pop2).delegate; node9 != null; node9 = node9.child) {
                                                                    if ((node9.kindSet & 1024) != 0) {
                                                                        i6++;
                                                                        if (i6 == 1) {
                                                                            nodeAccess$pop2 = node9;
                                                                        } else {
                                                                            if (mutableVector4 == null) {
                                                                                mutableVector4 = new MutableVector(new Modifier.Node[16]);
                                                                            }
                                                                            if (nodeAccess$pop2 != null) {
                                                                                mutableVector4.add(nodeAccess$pop2);
                                                                                nodeAccess$pop2 = null;
                                                                            }
                                                                            mutableVector4.add(node9);
                                                                        }
                                                                    }
                                                                }
                                                                if (i6 == 1) {
                                                                }
                                                            }
                                                            nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector4);
                                                        }
                                                    }
                                                }
                                            }
                                            HitTestResultKt.access$addLayoutNodeChildren(mutableVector3, node7);
                                        }
                                    }
                                    if (arrayList != null) {
                                        arrayList.remove(this);
                                        return;
                                    }
                                    return;
                                }
                            } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                for (Modifier.Node node10 = ((DelegatingNode) nodeAccess$pop).delegate; node10 != null; node10 = node10.child) {
                                    if ((node10.kindSet & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodeAccess$pop = node10;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop != null) {
                                                mutableVector2.add(nodeAccess$pop);
                                                nodeAccess$pop = null;
                                            }
                                            mutableVector2.add(node10);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector2);
                        }
                    }
                }
            }
            HitTestResultKt.access$addLayoutNodeChildren(mutableVector, node3);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        addView(view, -1);
    }

    @Override // android.view.View
    public final void autofill(SparseArray sparseArray) {
        SemanticsConfiguration semanticsConfiguration;
        Function1 function1;
        Function1 function2;
        if (autofillSupported()) {
            AndroidAutofillManager androidAutofillManager = this._autofillManager;
            if (androidAutofillManager != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    int iKeyAt = sparseArray.keyAt(i);
                    AutofillValue autofillValueM325m = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m325m(sparseArray.get(iKeyAt));
                    LayoutNode layoutNode = (LayoutNode) androidAutofillManager.semanticsOwner.nodes.get(iKeyAt);
                    if (layoutNode != null && (semanticsConfiguration = layoutNode.getSemanticsConfiguration()) != null) {
                        MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
                        Object obj = mutableScatterMap.get(SemanticsActions.OnAutofillText);
                        if (obj == null) {
                            obj = null;
                        }
                        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                        if (accessibilityAction != null && (function2 = (Function1) accessibilityAction.action) != null) {
                        }
                        Object obj2 = mutableScatterMap.get(SemanticsActions.OnFillData);
                        AccessibilityAction accessibilityAction2 = (AccessibilityAction) (obj2 != null ? obj2 : null);
                        if (accessibilityAction2 != null && (function1 = (Function1) accessibilityAction2.action) != null) {
                        }
                    }
                }
            }
            Dispatcher dispatcher = this._autofill;
            if (dispatcher != null) {
                AutofillTree autofillTree = (AutofillTree) dispatcher.readyAsyncCalls;
                if (autofillTree.children.isEmpty()) {
                    return;
                }
                int size2 = sparseArray.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    int iKeyAt2 = sparseArray.keyAt(i2);
                    AutofillValue autofillValueM325m2 = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m325m(sparseArray.get(iKeyAt2));
                    if (autofillValueM325m2.isText()) {
                        autofillValueM325m2.getTextValue().toString();
                        if (autofillTree.children.get(Integer.valueOf(iKeyAt2)) != null) {
                            throw new ClassCastException();
                        }
                    } else {
                        if (autofillValueM325m2.isDate()) {
                            throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                        }
                        if (autofillValueM325m2.isList()) {
                            throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                        }
                        if (autofillValueM325m2.isToggle()) {
                            throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.composeAccessibilityDelegate.m602canScroll0AR0LA0$ui(false, i, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.composeAccessibilityDelegate.m602canScroll0AR0LA0$ui(true, i, this.lastDownPointerPosition);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        MutableObjectList mutableObjectList = this.dirtyLayers;
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        measureAndLayout(true);
        SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
        this.isDrawingContent = true;
        Trace.beginSection("AndroidOwner:draw");
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
            Canvas canvas2 = androidCanvas.internalCanvas;
            androidCanvas.internalCanvas = canvas;
            getRoot().draw$ui(androidCanvas, null);
            canvasHolder.androidCanvas.internalCanvas = canvas2;
            if (mutableObjectList.isNotEmpty()) {
                int i = mutableObjectList._size;
                for (int i2 = 0; i2 < i; i2++) {
                    ((GraphicsLayerOwnerLayer) ((OwnedLayer) mutableObjectList.get(i2))).updateDisplayList();
                }
            }
            int i3 = ViewLayer.$r8$clinit;
            mutableObjectList.clear();
            this.isDrawingContent = false;
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            MutableObjectList mutableObjectList2 = this.postponedDirtyLayers;
            if (mutableObjectList2 != null) {
                mutableObjectList.addAll(mutableObjectList2);
                mutableObjectList2.clear();
            }
            if (isArrEnabled$ui()) {
                Api35Impl.setRequestedFrameRate(this, this.currentFrameRate);
                View view = this.frameRateCategoryView;
                if (view != null) {
                    Api35Impl.setRequestedFrameRate(view, this.currentFrameRateCategory);
                    if (!Float.isNaN(this.currentFrameRateCategory)) {
                        view.invalidate();
                        drawChild(canvas, view, getDrawingTime());
                    }
                }
                this.currentFrameRate = Float.NaN;
                this.currentFrameRateCategory = Float.NaN;
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r5v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v12 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v12 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v13 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v12 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(android.view.MotionEvent r43) {
        /*
            Method dump skipped, instruction units count: 2023
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.dispatchGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:68:0x015b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0162 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i;
        boolean z = this.hoverExitReceived;
        AndroidComposeView$$ExternalSyntheticLambda0 androidComposeView$$ExternalSyntheticLambda0 = this.sendHoverExitEvent;
        if (z) {
            removeCallbacks(androidComposeView$$ExternalSyntheticLambda0);
            androidComposeView$$ExternalSyntheticLambda0.run();
        }
        if (!isBadMotionEvent(motionEvent) && isAttachedToWindow()) {
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
            AndroidComposeView androidComposeView = androidComposeViewAccessibilityDelegateCompat.view;
            android.view.accessibility.AccessibilityManager accessibilityManager = androidComposeViewAccessibilityDelegateCompat.accessibilityManager;
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action == 7 || action == 9) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    androidComposeView.measureAndLayout(true);
                    HitTestResult hitTestResult = new HitTestResult();
                    LayoutNode root = androidComposeView.getRoot();
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(x)) << 32) | (((long) Float.floatToRawIntBits(y)) & 4294967295L);
                    NodeChain nodeChain = root.nodes;
                    NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
                    ((NodeCoordinator) nodeChain.outerCoordinator).m574hitTestqzLsGqo(NodeCoordinator.SemanticsSource, nodeCoordinator.m569fromParentPosition8S9VItk(jFloatToRawIntBits), hitTestResult, 1, true);
                    int lastIndex = AppCompatHintHelper.getLastIndex(hitTestResult);
                    while (true) {
                        if (-1 >= lastIndex) {
                            i = Integer.MIN_VALUE;
                            break;
                        }
                        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode((Modifier.Node) hitTestResult.values.get(lastIndex));
                        if (androidComposeView.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(layoutNodeRequireLayoutNode) != null) {
                            throw new ClassCastException();
                        }
                        if (layoutNodeRequireLayoutNode.nodes.m565hasH91voCI$ui(8)) {
                            int iSemanticsNodeIdToAccessibilityVirtualNodeId = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(layoutNodeRequireLayoutNode.semanticsId);
                            SemanticsNode SemanticsNode = SemanticsNodeKt.SemanticsNode(layoutNodeRequireLayoutNode, false);
                            if (SemanticsNodeKt.isImportantForAccessibility(SemanticsNode)) {
                                if (!SemanticsNode.getConfig().props.containsKey(SemanticsProperties.LinkTestMarker)) {
                                    i = iSemanticsNodeIdToAccessibilityVirtualNodeId;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                        lastIndex--;
                    }
                    androidComposeView.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(motionEvent);
                    int i2 = androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId;
                    if (i2 != i) {
                        androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId = i;
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i, 128, null, 12);
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i2, 256, null, 12);
                    }
                } else if (action == 10) {
                    int i3 = androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId;
                    if (i3 == Integer.MIN_VALUE) {
                        androidComposeView.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(motionEvent);
                    } else if (i3 != Integer.MIN_VALUE) {
                        androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId = Integer.MIN_VALUE;
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, Integer.MIN_VALUE, 128, null, 12);
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i3, 256, null, 12);
                    }
                }
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 7) {
                if (actionMasked == 10 && isInBounds(motionEvent)) {
                    if (motionEvent.getToolType(0) != 3 || motionEvent.getButtonState() == 0) {
                        MotionEvent motionEvent2 = this.previousMotionEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                        this.hoverExitReceived = true;
                        postDelayed(androidComposeView$$ExternalSyntheticLambda0, 8L);
                        return false;
                    }
                } else if ((m588handleMotionEvent8iAsVTc(motionEvent) & 1) != 0) {
                    return true;
                }
            } else if (isPositionChanged(motionEvent)) {
                if ((m588handleMotionEvent8iAsVTc(motionEvent) & 1) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isFocused()) {
            return ((FocusOwnerImpl) getFocusOwner()).m344dispatchKeyEventYhN2O0w(keyEvent, new DialogHostKt$DialogHost$1$1$1(6, this, keyEvent));
        }
        LazyWindowInfo lazyWindowInfo = getComposeViewContext().windowInfo;
        int metaState = keyEvent.getMetaState();
        lazyWindowInfo.getClass();
        WindowInfoImpl.GlobalKeyboardModifiers.setValue(new PointerKeyboardModifiers(metaState));
        return ((FocusOwnerImpl) getFocusOwner()).m344dispatchKeyEventYhN2O0w(keyEvent, FocusOwner$dispatchKeyEvent$1.INSTANCE) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        NodeChain nodeChain;
        if (isFocused()) {
            FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) getFocusOwner();
            if (focusOwnerImpl.focusInvalidationManager.isInvalidationScheduled) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            } else {
                FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusOwnerImpl.rootFocusNode);
                if (focusTargetNodeFindActiveFocusNode != null) {
                    if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node node = focusTargetNodeFindActiveFocusNode.node;
                    LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                    while (layoutNodeRequireLayoutNode != null) {
                        if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 131072) != 0) {
                            while (node != null) {
                                if ((node.kindSet & 131072) != 0) {
                                    Modifier.Node nodeAccess$pop = node;
                                    MutableVector mutableVector = null;
                                    while (nodeAccess$pop != null) {
                                        if ((nodeAccess$pop.kindSet & 131072) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                            int i = 0;
                                            for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                                if ((node2.kindSet & 131072) != 0) {
                                                    i++;
                                                    if (i == 1) {
                                                        Unit unit = Unit.INSTANCE;
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
                                }
                                node = node.parent;
                            }
                        }
                        layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                        node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                    }
                }
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideStructure(ViewStructure viewStructure) {
        if (Build.VERSION.SDK_INT < 28) {
            AndroidComposeViewAssistHelperMethodsO.INSTANCE.setClassName(viewStructure, getView());
        } else {
            super.dispatchProvideStructure(viewStructure);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Object autoClearFocusBehavior;
        FocusTargetNode activeFocusTargetNode;
        if (this.hoverExitReceived) {
            AndroidComposeView$$ExternalSyntheticLambda0 androidComposeView$$ExternalSyntheticLambda0 = this.sendHoverExitEvent;
            removeCallbacks(androidComposeView$$ExternalSyntheticLambda0);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            if (motionEvent.getActionMasked() == 0 && motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
                this.hoverExitReceived = false;
            } else {
                androidComposeView$$ExternalSyntheticLambda0.run();
            }
        }
        if (!isBadMotionEvent(motionEvent) && isAttachedToWindow() && (motionEvent.getActionMasked() != 2 || isPositionChanged(motionEvent))) {
            int iM588handleMotionEvent8iAsVTc = m588handleMotionEvent8iAsVTc(motionEvent);
            if ((iM588handleMotionEvent8iAsVTc & 2) != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            boolean z = motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5;
            boolean z2 = motionEvent.isFromSource(8194) || motionEvent.isFromSource(1048584);
            if (z && z2) {
                Object parent = getParent();
                View view = parent instanceof View ? (View) parent : null;
                if (view == null || (autoClearFocusBehavior = view.getTag(R.id.auto_clear_focus_behavior_tag)) == null) {
                    autoClearFocusBehavior = new AutoClearFocusBehavior(1);
                }
                if (autoClearFocusBehavior.equals(new AutoClearFocusBehavior(1)) && (activeFocusTargetNode = ((FocusOwnerImpl) getFocusOwner()).getActiveFocusTargetNode()) != null) {
                    NodeCoordinator nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(activeFocusTargetNode);
                    if (!RulerKt.findRootCoordinates(nodeCoordinatorRequireLayoutCoordinates).localBoundingBoxOf(nodeCoordinatorRequireLayoutCoordinates, true).m377containsk4lQ0M((((long) Float.floatToRawIntBits(motionEvent.getX())) << 32) | (((long) Float.floatToRawIntBits(motionEvent.getY())) & 4294967295L))) {
                        ((FocusOwnerImpl) getFocusOwner()).m343clearFocusI7lrPNg(8, false, true);
                    }
                }
            }
            if ((iM588handleMotionEvent8iAsVTc & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    public final View findViewByAccessibilityIdTraversal(int i) throws IllegalAccessException, InvocationTargetException {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return findViewByAccessibilityIdRootedAtCurrentView(this, i);
            }
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(i));
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        Rect rectCalculateFocusRectRelativeTo;
        if (view == null || this.measureAndLayoutDelegate.duringMeasureLayout) {
            return super.focusSearch(view, i);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), view, i);
        if (viewFindNextFocus != null && !viewFindNextFocus.equals(this)) {
            ViewParent parent = viewFindNextFocus.getParent();
            while (true) {
                if (parent == null) {
                    viewFindNextFocus = null;
                    break;
                }
                if (parent == this) {
                    break;
                }
                parent = parent.getParent();
            }
        } else {
            viewFindNextFocus = null;
            break;
        }
        if (view == this) {
            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(((FocusOwnerImpl) getFocusOwner()).rootFocusNode);
            rectCalculateFocusRectRelativeTo = focusTargetNodeFindActiveFocusNode != null ? FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode) : null;
            if (rectCalculateFocusRectRelativeTo == null) {
                rectCalculateFocusRectRelativeTo = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(view, this);
            }
        } else {
            rectCalculateFocusRectRelativeTo = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(view, this);
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
        int i2 = focusDirection != null ? focusDirection.value : 6;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (((FocusOwnerImpl) getFocusOwner()).m345focusSearchULY8qGw(i2, rectCalculateFocusRectRelativeTo, new NavGraphNavigator$navigate$missingRequiredArgs$1(ref$ObjectRef, 3)) == null) {
            return view;
        }
        Object obj = ref$ObjectRef.element;
        if (obj == null) {
            if (viewFindNextFocus == null) {
                return super.focusSearch(view, i);
            }
        } else if (viewFindNextFocus == null || i2 == 1 || i2 == 2 || FocusTraversalKt.m357isBetterCandidateI7lrPNg(FocusTraversalKt.focusRect((FocusTargetNode) obj), FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(viewFindNextFocus, this), rectCalculateFocusRectRelativeTo, i2)) {
            return this;
        }
        return viewFindNextFocus;
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, z);
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler, -1);
            requestLayout();
        }
        return this._androidViewsHandler;
    }

    public Autofill getAutofill() {
        return this._autofill;
    }

    public androidx.compose.ui.autofill.AutofillManager getAutofillManager() {
        return this._autofillManager;
    }

    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final ComposeViewContext getComposeViewContext() {
        return get_composeViewContext();
    }

    public final boolean getComposeViewContextIncrementedDuringInit$ui() {
        return this.composeViewContextIncrementedDuringInit;
    }

    public final Configuration getConfiguration() {
        return (Configuration) this.configuration$delegate.getValue();
    }

    public final AndroidContentCaptureManager getContentCaptureManager$ui() {
        return this.contentCaptureManager;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public Density getDensity() {
        return (Density) this.density$delegate.getValue();
    }

    public Rect getEmbeddedViewFocusRect() {
        if (isFocused()) {
            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(((FocusOwnerImpl) getFocusOwner()).rootFocusNode);
            if (focusTargetNodeFindActiveFocusNode != null) {
                return FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode);
            }
            return null;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(viewFindFocus, this);
        }
        return null;
    }

    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // android.view.View
    public final void getFocusedRect(android.graphics.Rect rect) {
        Rect embeddedViewFocusRect = getEmbeddedViewFocusRect();
        if (embeddedViewFocusRect != null) {
            rect.left = Math.round(embeddedViewFocusRect.left);
            rect.top = Math.round(embeddedViewFocusRect.top);
            rect.right = Math.round(embeddedViewFocusRect.right);
            rect.bottom = Math.round(embeddedViewFocusRect.bottom);
            return;
        }
        if (Intrinsics.areEqual(((FocusOwnerImpl) getFocusOwner()).m345focusSearchULY8qGw(6, null, AnonymousClass1.INSTANCE), Boolean.TRUE)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }

    public FontFamily$Resolver getFontFamilyResolver() {
        return (FontFamily$Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    public Font$ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    public final LifecycleRetainedValuesStoreOwner.FrameEndScheduler getFrameEndScheduler$ui() {
        return this.frameEndScheduler;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.relayoutNodes.isNotEmpty() || !this.outOfFrameQueue.isEmpty();
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public final InsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    @Override // android.view.View, android.view.ViewParent
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public LocaleList getLocaleList() {
        return (LocaleList) this.localeList$delegate.getValue();
    }

    public long getMeasureIteration() {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (!measureAndLayoutDelegate.duringMeasureLayout) {
            InlineClassHelperKt.throwIllegalArgumentException("measureIteration should be only used during the measure/layout pass");
        }
        return measureAndLayoutDelegate.measureIteration;
    }

    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    public Placeable.PlacementScope getPlacementScope() {
        int i = PlaceableKt.$r8$clinit;
        return new OuterPlacementScope(0, this);
    }

    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    /* JADX INFO: renamed from: getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui, reason: not valid java name */
    public final IndirectPointerEventPrimaryDirectionalMotionAxis m587getPrimaryDirectionalMotionAxisOverridedqNNBbU$ui() {
        return this.primaryDirectionalMotionAxisOverride;
    }

    public RectManager getRectManager() {
        return this.rectManager;
    }

    public RetainedValuesStore getRetainedValuesStore() {
        return this.retainedValuesStore;
    }

    public LayoutNode getRoot() {
        return this.root;
    }

    public final boolean getScrollCaptureInProgress$ui() {
        MemoryCacheService memoryCacheService;
        if (Build.VERSION.SDK_INT < 31 || (memoryCacheService = this.scrollCapture) == null) {
            return false;
        }
        return ((Boolean) ((ParcelableSnapshotMutableState) memoryCacheService.imageLoader).getValue()).booleanValue();
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    public boolean getShowLayoutBounds() {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.INSTANCE.isShowingLayoutBounds(this) : this.showLayoutBounds;
    }

    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    public SoftwareKeyboardController getSoftwareKeyboardController() {
        DelegatingSoftwareKeyboardController delegatingSoftwareKeyboardController = this._softwareKeyboardController;
        if (delegatingSoftwareKeyboardController != null) {
            return delegatingSoftwareKeyboardController;
        }
        DelegatingSoftwareKeyboardController delegatingSoftwareKeyboardController2 = new DelegatingSoftwareKeyboardController(getTextInputService());
        this._softwareKeyboardController = delegatingSoftwareKeyboardController2;
        return delegatingSoftwareKeyboardController2;
    }

    public TextInputService getTextInputService() {
        TextInputService textInputService = this._textInputService;
        if (textInputService != null) {
            return textInputService;
        }
        TextInputService textInputService2 = new TextInputService(getLegacyTextInputServiceAndroid());
        this._textInputService = textInputService2;
        return textInputService2;
    }

    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final RootForTest.UncaughtExceptionHandler getUncaughtExceptionHandler$ui() {
        return null;
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public final ViewTreeOwners getViewTreeOwners() {
        Modifier.CC.m(this.viewTreeOwners$delegate.getValue());
        return null;
    }

    public WindowInfo getWindowInfo() {
        return getComposeViewContext().windowInfo;
    }

    public final AndroidAutofillManager get_autofillManager$ui() {
        return this._autofillManager;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX INFO: renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    public final int m588handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        int actionMasked;
        MotionEvent motionEvent2;
        AndroidComposeView androidComposeView;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked2 = motionEvent.getActionMasked();
                MotionEvent motionEvent3 = this.previousMotionEvent;
                boolean z = motionEvent3 != null && motionEvent3.getToolType(0) == 3;
                Exchange exchange = this.pointerInputEventProcessor;
                if (motionEvent3 != null) {
                    try {
                        if (!((motionEvent3.getSource() == motionEvent.getSource() && motionEvent3.getToolType(0) == motionEvent.getToolType(0)) ? false : true)) {
                            motionEvent2 = motionEvent3;
                        } else if (motionEvent3.getButtonState() != 0 || (actionMasked = motionEvent3.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6) {
                            motionEvent2 = motionEvent3;
                            if (!exchange.hasFailure) {
                                ((LongSparseArray) ((MemoryCacheService) exchange.codec).imageLoader).clear();
                                ((HitPathTracker) exchange.finder).processCancel();
                            }
                        } else if (motionEvent3.getActionMasked() == 10 || !z) {
                            motionEvent2 = motionEvent3;
                        } else {
                            sendSimulatedEvent(motionEvent3, 10, motionEvent3.getEventTime(), true);
                            motionEvent2 = motionEvent3;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Trace.endSection();
                        throw th;
                    }
                } else {
                    motionEvent2 = motionEvent3;
                }
                boolean z2 = motionEvent.getToolType(0) == 3;
                if (z || !z2 || actionMasked2 == 3 || actionMasked2 == 9 || !isInBounds(motionEvent)) {
                    androidComposeView = this;
                } else {
                    androidComposeView = this;
                    androidComposeView.sendSimulatedEvent(motionEvent, 9, motionEvent.getEventTime(), true);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                MotionEvent motionEvent4 = androidComposeView.previousMotionEvent;
                if (motionEvent4 != null && motionEvent4.getAction() == 10) {
                    MotionEvent motionEvent5 = androidComposeView.previousMotionEvent;
                    int pointerId = motionEvent5 != null ? motionEvent5.getPointerId(0) : -1;
                    int action = motionEvent.getAction();
                    MotionEventAdapter motionEventAdapter = androidComposeView.motionEventAdapter;
                    if (action == 9 && motionEvent.getHistorySize() == 0) {
                        if (pointerId >= 0) {
                            motionEventAdapter.activeHoverIds.delete(pointerId);
                            motionEventAdapter.motionEventToComposePointerIdMap.delete(pointerId);
                        }
                    } else if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                        MotionEvent motionEvent6 = androidComposeView.previousMotionEvent;
                        float x = motionEvent6 != null ? motionEvent6.getX() : Float.NaN;
                        MotionEvent motionEvent7 = androidComposeView.previousMotionEvent;
                        boolean z3 = (x == motionEvent.getX() && (motionEvent7 != null ? motionEvent7.getY() : Float.NaN) == motionEvent.getY()) ? false : true;
                        MotionEvent motionEvent8 = androidComposeView.previousMotionEvent;
                        boolean z4 = (motionEvent8 != null ? motionEvent8.getEventTime() : -1L) != motionEvent.getEventTime();
                        if (z3 || z4) {
                            if (pointerId >= 0) {
                                motionEventAdapter.activeHoverIds.delete(pointerId);
                                motionEventAdapter.motionEventToComposePointerIdMap.delete(pointerId);
                            }
                            HitPathTracker hitPathTracker = (HitPathTracker) exchange.finder;
                            if (hitPathTracker.clearNodeCacheAfterDispatchedEvent) {
                                hitPathTracker.clearNodeCacheAfterDispatchedEvent = true;
                            } else {
                                hitPathTracker.root.children.clear();
                            }
                        }
                    }
                }
                androidComposeView.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int iM594sendMotionEvent8iAsVTc = m594sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                androidComposeView.forceUseMatrixCache = false;
                return iM594sendMotionEvent8iAsVTc;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            this.forceUseMatrixCache = false;
            throw th3;
        }
    }

    public final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestRemeasure(layoutNode, false);
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            invalidateLayoutNodeMeasurement((LayoutNode) objArr[i2]);
        }
    }

    public final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    public final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        return (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.previousMotionEvent) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) ? false : true;
    }

    /* JADX INFO: renamed from: localToScreen-58bKbWc, reason: not valid java name */
    public final void m589localToScreen58bKbWc(float[] fArr) {
        recalculateWindowPosition();
        Matrix.m446timesAssign58bKbWc(fArr, this.viewToWindowMatrix);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.windowPosition >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.windowPosition & 4294967295L));
        float[] fArr2 = this.tmpMatrix;
        Matrix.m445resetimpl(fArr2);
        Matrix.m447translateimpl(fArr2, fIntBitsToFloat, fIntBitsToFloat2);
        InvertMatrixKt.m613preTransformJiSxe2E(fArr, fArr2);
    }

    /* JADX INFO: renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
    public final long m590localToScreenMKHz9U(long j) {
        recalculateWindowPosition();
        long jM443mapMKHz9U = Matrix.m443mapMKHz9U(j, this.viewToWindowMatrix);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.windowPosition >> 32)) + Float.intBitsToFloat((int) (jM443mapMKHz9U >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (this.windowPosition & 4294967295L)) + Float.intBitsToFloat((int) (jM443mapMKHz9U & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public final void measureAndLayout(boolean z) {
        AndroidComposeView$localeList$2 androidComposeView$localeList$2;
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (measureAndLayoutDelegate.relayoutNodes.isNotEmpty() || ((MutableVector) measureAndLayoutDelegate.onPositionedDispatcher.systemCallbacks).size != 0) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z) {
                try {
                    androidComposeView$localeList$2 = this.resendMotionEventOnLayout;
                } finally {
                    Trace.endSection();
                }
            } else {
                androidComposeView$localeList$2 = null;
            }
            if (measureAndLayoutDelegate.measureAndLayout(androidComposeView$localeList$2)) {
                requestLayout();
            }
            measureAndLayoutDelegate.dispatchOnPositionedCallbacks(false);
            getRectManager().dispatchCallbacks();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    public final void m591measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            measureAndLayoutDelegate.m561measureAndLayout0kLqBqw(layoutNode, j);
            if (!measureAndLayoutDelegate.relayoutNodes.isNotEmpty()) {
                measureAndLayoutDelegate.dispatchOnPositionedCallbacks(false);
                getRectManager().dispatchCallbacks();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void notifyLayerIsDirty$ui(OwnedLayer ownedLayer, boolean z) {
        MutableObjectList mutableObjectList = this.dirtyLayers;
        if (!z) {
            if (this.isDrawingContent) {
                return;
            }
            mutableObjectList.remove(ownedLayer);
            MutableObjectList mutableObjectList2 = this.postponedDirtyLayers;
            if (mutableObjectList2 != null) {
                mutableObjectList2.remove(ownedLayer);
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            mutableObjectList.add(ownedLayer);
            return;
        }
        MutableObjectList mutableObjectList3 = this.postponedDirtyLayers;
        if (mutableObjectList3 == null) {
            mutableObjectList3 = new MutableObjectList();
            this.postponedDirtyLayers = mutableObjectList3;
        }
        mutableObjectList3.add(ownedLayer);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        RetainedValuesStore retainedValuesStore;
        Object obj;
        Dispatcher dispatcher;
        super.onAttachedToWindow();
        int i = 1;
        setAttached(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30) {
            setShowLayoutBounds(InvertMatrixKt.getIsShowingLayoutBounds());
        }
        this.insetsListener.onViewAttachedToWindow(this);
        int i3 = 0;
        if (i2 > 28) {
            if (systemPropertiesChangedRunnable == null) {
                Camera2CameraControlImpl$$ExternalSyntheticLambda4 camera2CameraControlImpl$$ExternalSyntheticLambda4 = new Camera2CameraControlImpl$$ExternalSyntheticLambda4(i);
                systemPropertiesChangedRunnable = camera2CameraControlImpl$$ExternalSyntheticLambda4;
                StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
                try {
                    if (systemPropertiesClass == null) {
                        systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    }
                    if (addChangeCallbackMethod == null) {
                        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
                        Class cls = systemPropertiesClass;
                        addChangeCallbackMethod = cls != null ? cls.getDeclaredMethod("addChangeCallback", Runnable.class) : null;
                    }
                    Method method = addChangeCallbackMethod;
                    if (method != null) {
                        method.invoke(null, camera2CameraControlImpl$$ExternalSyntheticLambda4);
                    }
                } catch (Throwable unused) {
                }
                StrictMode.setVmPolicy(vmPolicy);
            }
            MutableObjectList mutableObjectList = composeViews;
            synchronized (mutableObjectList) {
                mutableObjectList.add(this);
                Unit unit = Unit.INSTANCE;
            }
        }
        if (!this.composeViewContextIncrementedDuringInit) {
            getComposeViewContext().incrementViewCount$ui();
        }
        this.composeViewContextIncrementedDuringInit = false;
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().observer.start();
        if (autofillSupported() && (dispatcher = this._autofill) != null) {
            AutofillCallback autofillCallback = AutofillCallback.INSTANCE;
            autofillCallback.getClass();
            ((AutofillManager) dispatcher.runningAsyncCalls).registerCallback(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m410m((Object) autofillCallback));
        }
        LifecycleOwner lifecycleOwner = getComposeViewContext().lifecycleOwner;
        ViewModelStoreOwner viewModelStoreOwner = getComposeViewContext().viewModelStoreOwner;
        LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler = this.frameEndScheduler;
        int i4 = 2;
        if (lifecycleOwner == null || viewModelStoreOwner == null || frameEndScheduler == null) {
            retainedValuesStore = null;
        } else {
            Dispatcher dispatcher2 = new Dispatcher(viewModelStoreOwner.getViewModelStore(), new FragmentManagerViewModel.AnonymousClass1(i4), CreationExtras.Empty.INSTANCE);
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LifecycleRetainedValuesStoreOwner.class);
            String qualifiedName = orCreateKotlinClass.getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            LifecycleRetainedValuesStoreOwner lifecycleRetainedValuesStoreOwner = (LifecycleRetainedValuesStoreOwner) dispatcher2.getViewModel$lifecycle_viewmodel_release("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName), orCreateKotlinClass);
            int id = ((View) getParent()).getId();
            MutableIntObjectMap mutableIntObjectMap = lifecycleRetainedValuesStoreOwner.scopes;
            Object mutableObjectList2 = mutableIntObjectMap.get(id);
            if (mutableObjectList2 == null) {
                mutableObjectList2 = new MutableObjectList(1);
                mutableIntObjectMap.set(id, mutableObjectList2);
            }
            MutableObjectList mutableObjectList3 = (MutableObjectList) mutableObjectList2;
            Object[] objArr = mutableObjectList3.content;
            int i5 = mutableObjectList3._size;
            while (true) {
                if (i3 >= i5) {
                    obj = null;
                    break;
                }
                obj = objArr[i3];
                if (!((LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry) obj).isInUse) {
                    break;
                } else {
                    i3++;
                }
            }
            LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = (LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry) obj;
            if (retainedValuesStoreEntry == null) {
                retainedValuesStoreEntry = new LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry();
                mutableObjectList3.add(retainedValuesStoreEntry);
            }
            retainedValuesStoreEntry.isInUse = true;
            this.lifecycleRetainedValuesStoreOwnerEntry = retainedValuesStoreEntry;
            retainedValuesStore = retainedValuesStoreEntry.retainedValuesStore;
        }
        if (retainedValuesStore == null) {
            retainedValuesStore = ForgetfulRetainedValuesStore.INSTANCE;
        }
        this.retainedValuesStore = retainedValuesStore;
        Function1 function1 = this.onReadyForComposition;
        if (function1 != null) {
            function1.invoke(getComposeViewContext());
            this.onReadyForComposition = null;
        }
        Lifecycle lifecycle = getComposeViewContext().lifecycleOwner.getLifecycle();
        lifecycle.addObserver(this);
        lifecycle.addObserver(this.contentCaptureManager);
        this._inputModeManager.inputMode$delegate.setValue(new InputMode(isInTouchMode() ? 1 : 2));
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        getViewTreeObserver().addOnScrollChangedListener(this);
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(this);
        }
        AndroidAutofillManager androidAutofillManager = this._autofillManager;
        if (androidAutofillManager != null) {
            ((FocusOwnerImpl) getFocusOwner()).listeners.add(androidAutofillManager);
            getSemanticsOwner().listeners.add(androidAutofillManager);
        }
        ((FocusOwnerImpl) getFocusOwner()).listeners.add(this);
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        SessionMutex$Session sessionMutex$Session = (SessionMutex$Session) this.textInputSessionMutex.get();
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) (sessionMutex$Session != null ? sessionMutex$Session.value : null);
        if (androidPlatformTextInputSession == null) {
            return getLegacyTextInputServiceAndroid().editorHasFocus;
        }
        SessionMutex$Session sessionMutex$Session2 = (SessionMutex$Session) androidPlatformTextInputSession.methodSessionMutex.get();
        InputMethodSession inputMethodSession = (InputMethodSession) (sessionMutex$Session2 != null ? sessionMutex$Session2.value : null);
        return inputMethodSession != null && (inputMethodSession.disposed ^ true);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateConfiguration(configuration);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection nullableInputConnectionWrapperApi24;
        int i;
        SessionMutex$Session sessionMutex$Session = (SessionMutex$Session) this.textInputSessionMutex.get();
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) (sessionMutex$Session != null ? sessionMutex$Session.value : null);
        if (androidPlatformTextInputSession == null) {
            TextInputServiceAndroid legacyTextInputServiceAndroid = getLegacyTextInputServiceAndroid();
            if (legacyTextInputServiceAndroid.editorHasFocus) {
                ImeOptions imeOptions = legacyTextInputServiceAndroid.imeOptions;
                TextFieldValue textFieldValue = legacyTextInputServiceAndroid.state;
                int i2 = imeOptions.imeAction;
                boolean z = imeOptions.singleLine;
                if (i2 == 1) {
                    i = z ? 6 : 0;
                } else if (i2 == 0) {
                    i = 1;
                } else if (i2 == 2) {
                    i = 2;
                } else if (i2 == 6) {
                    i = 5;
                } else if (i2 == 5) {
                    i = 7;
                } else if (i2 == 3) {
                    i = 3;
                } else if (i2 == 4) {
                    i = 4;
                } else {
                    if (i2 != 7) {
                        throw new IllegalStateException("invalid ImeAction");
                    }
                }
                editorInfo.imeOptions = i;
                int i3 = imeOptions.keyboardType;
                int i4 = 8;
                if (i3 == 1) {
                    editorInfo.inputType = 1;
                } else if (i3 == 2) {
                    editorInfo.inputType = 1;
                    editorInfo.imeOptions = Integer.MIN_VALUE | i;
                } else if (i3 == 3) {
                    editorInfo.inputType = 2;
                } else if (i3 == 4) {
                    editorInfo.inputType = 3;
                } else if (i3 == 5) {
                    editorInfo.inputType = 17;
                } else if (i3 == 6) {
                    editorInfo.inputType = 33;
                } else if (i3 == 7) {
                    editorInfo.inputType = 129;
                } else if (i3 == 8) {
                    editorInfo.inputType = 18;
                } else {
                    if (i3 != 9) {
                        throw new IllegalStateException("Invalid Keyboard Type");
                    }
                    editorInfo.inputType = 8194;
                }
                if (!z) {
                    int i5 = editorInfo.inputType;
                    if ((i5 & 1) == 1) {
                        editorInfo.inputType = i5 | 131072;
                        if (i2 == 1) {
                            editorInfo.imeOptions |= 1073741824;
                        }
                    }
                }
                int i6 = editorInfo.inputType;
                if ((i6 & 1) == 1) {
                    int i7 = imeOptions.capitalization;
                    if (i7 == 1) {
                        editorInfo.inputType = i6 | 4096;
                    } else if (i7 == 2) {
                        editorInfo.inputType = i6 | 8192;
                    } else if (i7 == 3) {
                        editorInfo.inputType = i6 | 16384;
                    }
                    if (imeOptions.autoCorrect) {
                        editorInfo.inputType |= 32768;
                    }
                }
                long j = textFieldValue.selection;
                int i8 = TextRange.$r8$clinit;
                editorInfo.initialSelStart = (int) (j >> 32);
                editorInfo.initialSelEnd = (int) (j & 4294967295L);
                EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.annotatedString.text);
                editorInfo.imeOptions |= 33554432;
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().updateEditorInfo(editorInfo);
                }
                RecordingInputConnection recordingInputConnection = new RecordingInputConnection(legacyTextInputServiceAndroid.state, new MemoryCacheService(i4, legacyTextInputServiceAndroid), legacyTextInputServiceAndroid.imeOptions.autoCorrect);
                legacyTextInputServiceAndroid.ics.add(new WeakReference(recordingInputConnection));
                return recordingInputConnection;
            }
        } else {
            SessionMutex$Session sessionMutex$Session2 = (SessionMutex$Session) androidPlatformTextInputSession.methodSessionMutex.get();
            InputMethodSession inputMethodSession = (InputMethodSession) (sessionMutex$Session2 != null ? sessionMutex$Session2.value : null);
            if (inputMethodSession != null) {
                synchronized (inputMethodSession.lock) {
                    if (inputMethodSession.disposed) {
                        return null;
                    }
                    androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnectionCreateInputConnection = inputMethodSession.request.createInputConnection(editorInfo);
                    Navigator.AnonymousClass1 anonymousClass1 = new Navigator.AnonymousClass1(23, inputMethodSession);
                    int i9 = Build.VERSION.SDK_INT;
                    if (i9 >= 34) {
                        nullableInputConnectionWrapperApi24 = new NullableInputConnectionWrapperApi34(recordingInputConnectionCreateInputConnection, anonymousClass1);
                    } else if (i9 >= 25) {
                        nullableInputConnectionWrapperApi24 = new NullableInputConnectionWrapperApi25(recordingInputConnectionCreateInputConnection, anonymousClass1);
                    } else {
                        nullableInputConnectionWrapperApi24 = i9 >= 24 ? new NullableInputConnectionWrapperApi24(recordingInputConnectionCreateInputConnection, anonymousClass1) : new NullableInputConnectionWrapperApi21(recordingInputConnectionCreateInputConnection, anonymousClass1);
                    }
                    inputMethodSession.connections.add(new androidx.compose.ui.node.WeakReference(nullableInputConnectionWrapperApi24));
                    return nullableInputConnectionWrapperApi24;
                }
            }
        }
        return null;
    }

    @Override // android.view.View
    public final void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer consumer) {
        SemanticsNode semanticsNode;
        String strFastJoinToString$default;
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.getClass();
        for (long j : jArr) {
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidContentCaptureManager.getCurrentSemanticsNodes$ui().get((int) j);
            if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.semanticsNode) != null) {
                CanvasCompatS$$ExternalSyntheticApiModelOutline0.m654m();
                ViewTranslationRequest.Builder builderM = CanvasCompatS$$ExternalSyntheticApiModelOutline0.m(androidContentCaptureManager.view.getAutofillId(), semanticsNode.id);
                Object obj = semanticsNode.unmergedConfig.props.get(SemanticsProperties.Text);
                if (obj == null) {
                    obj = null;
                }
                List list = (List) obj;
                if (list != null && (strFastJoinToString$default = ListUtilsKt.fastJoinToString$default(list, "\n", null, 62)) != null) {
                    builderM.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(strFastJoinToString$default)));
                    consumer.accept(builderM.build());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Dispatcher dispatcher;
        super.onDetachedFromWindow();
        setAttached(false);
        this.insetsListener.onViewDetachedFromWindow(this);
        View view = this.frameRateCategoryView;
        if (isArrEnabled$ui() && view != null) {
            removeView(view);
        }
        int i = Build.VERSION.SDK_INT;
        if (i > 28) {
            MutableObjectList mutableObjectList = composeViews;
            synchronized (mutableObjectList) {
                mutableObjectList.remove(this);
                Unit unit = Unit.INSTANCE;
            }
        }
        getComposeViewContext().decrementViewCount$ui();
        SnapshotStateObserver snapshotStateObserver = getSnapshotObserver().observer;
        OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0 = snapshotStateObserver.applyUnsubscribe;
        if (onBackPressedDispatcher$$ExternalSyntheticLambda0 != null) {
            onBackPressedDispatcher$$ExternalSyntheticLambda0.dispose();
        }
        snapshotStateObserver.clear();
        Lifecycle lifecycle = getComposeViewContext().lifecycleOwner.getLifecycle();
        lifecycle.removeObserver(this.contentCaptureManager);
        lifecycle.removeObserver(this);
        if (autofillSupported() && (dispatcher = this._autofill) != null) {
            AutofillCallback autofillCallback = AutofillCallback.INSTANCE;
            autofillCallback.getClass();
            ((AutofillManager) dispatcher.runningAsyncCalls).unregisterCallback(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m410m((Object) autofillCallback));
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        getViewTreeObserver().removeOnScrollChangedListener(this);
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            retainedValuesStoreEntry.isInUse = false;
        }
        this.lifecycleRetainedValuesStoreOwnerEntry = null;
        if (i >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
        }
        AndroidAutofillManager androidAutofillManager = this._autofillManager;
        if (androidAutofillManager != null) {
            getSemanticsOwner().listeners.remove(androidAutofillManager);
            ((FocusOwnerImpl) getFocusOwner()).listeners.remove(androidAutofillManager);
        }
        RectManager rectManager = getRectManager();
        rectManager.isScreenOrWindowDirty = rectManager.throttledCallbacks.m620updateOffsetsLDcG7Xg(0L, 0L, null, 0, 0);
        getRectManager().dispatchCallbacks();
        RectManager rectManager2 = getRectManager();
        AndroidComposeView$$ExternalSyntheticLambda2 androidComposeView$$ExternalSyntheticLambda2 = rectManager2.dispatchToken;
        if (androidComposeView$$ExternalSyntheticLambda2 != null) {
            AndroidComposeView androidComposeView = rectManager2.executeDelayed;
            if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) androidComposeView$$ExternalSyntheticLambda2)) {
                androidComposeView$$ExternalSyntheticLambda2 = null;
            }
            if (androidComposeView$$ExternalSyntheticLambda2 != null) {
                androidComposeView.removeCallbacks(androidComposeView$$ExternalSyntheticLambda2);
            }
            rectManager2.dispatchToken = null;
        }
        ((FocusOwnerImpl) getFocusOwner()).listeners.remove(this);
    }

    public final void onEndApplyChanges() {
        AndroidAutofillManager androidAutofillManager;
        if (this.observationClearRequested) {
            SnapshotStateObserver snapshotStateObserver = getSnapshotObserver().observer;
            synchronized (snapshotStateObserver.observedScopeMapsLock) {
                try {
                    MutableVector mutableVector = snapshotStateObserver.observedScopeMaps;
                    int i = mutableVector.size;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        SnapshotStateObserver.ObservedScopeMap observedScopeMap = (SnapshotStateObserver.ObservedScopeMap) mutableVector.content[i3];
                        observedScopeMap.removeScopeIf();
                        if (!observedScopeMap.scopeToValues.isNotEmpty()) {
                            i2++;
                        } else if (i2 > 0) {
                            Object[] objArr = mutableVector.content;
                            objArr[i3 - i2] = objArr[i3];
                        }
                    }
                    int i4 = i - i2;
                    Arrays.fill(mutableVector.content, i4, i, (Object) null);
                    mutableVector.size = i4;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        if (autofillSupported() && (androidAutofillManager = this._autofillManager) != null) {
            MutableIntSet mutableIntSet = androidAutofillManager.currentlyDisplayedIDs;
            if (mutableIntSet._size == 0 && androidAutofillManager.pendingAutofillCommit) {
                ((AutofillManager) androidAutofillManager.platformAutofillManager.entries).commit();
                androidAutofillManager.pendingAutofillCommit = false;
            }
            if (mutableIntSet._size != 0) {
                androidAutofillManager.pendingAutofillCommit = true;
            }
        }
        while (this.endApplyChangesListeners.isNotEmpty() && this.endApplyChangesListeners.get(0) != null) {
            int i5 = this.endApplyChangesListeners._size;
            for (int i6 = 0; i6 < i5; i6++) {
                Function0 function0 = (Function0) this.endApplyChangesListeners.get(i6);
                this.endApplyChangesListeners.set(i6, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, i5);
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, android.graphics.Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z || hasFocus()) {
            return;
        }
        FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) getFocusOwner();
        FocusTraversalKt.clearFocus(focusOwnerImpl.rootFocusNode, true);
        if (focusOwnerImpl.getActiveFocusTargetNode() != null) {
            FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
            focusOwnerImpl.setActiveFocusTargetNode(null);
            if (activeFocusTargetNode != null) {
                activeFocusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.lastMatrixRecalculationAnimationTime = 0L;
        updatePositionCacheAndDispatch();
        int i = Build.VERSION.SDK_INT;
        if (32 > i || i >= 34) {
            return;
        }
        updateConfiguration(getResources().getConfiguration());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Trace.beginSection("AndroidOwner:onLayout");
        try {
            this.lastMatrixRecalculationAnimationTime = 0L;
            this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
            this.onMeasureConstraints = null;
            updatePositionCacheAndDispatch();
            if (this._androidViewsHandler != null) {
                Trace.beginSection("AndroidOwner:viewLayout");
                try {
                    getAndroidViewsHandler$ui().layout(0, 0, i3 - i, i4 - i2);
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                } finally {
                    Trace.endSection();
                }
            }
            Unit unit2 = Unit.INSTANCE;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void onLayoutChange(LayoutNode layoutNode) {
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
        androidComposeViewAccessibilityDelegateCompat.currentSemanticsNodesInvalidated = true;
        if (androidComposeViewAccessibilityDelegateCompat.isEnabled$ui()) {
            androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.currentSemanticsNodesInvalidated = true;
        if (androidContentCaptureManager.isEnabled$ui()) {
            androidContentCaptureManager.boundsUpdateChannel.mo842trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long jM585convertMeasureSpecI7RO_PI = m585convertMeasureSpecI7RO_PI(i);
            long jM585convertMeasureSpecI7RO_PI2 = m585convertMeasureSpecI7RO_PI(i2);
            long jM687fitPrioritizingHeightZbe2FdA = Constraints.Companion.m687fitPrioritizingHeightZbe2FdA((int) (jM585convertMeasureSpecI7RO_PI >>> 32), (int) (jM585convertMeasureSpecI7RO_PI & 4294967295L), (int) (jM585convertMeasureSpecI7RO_PI2 >>> 32), (int) (4294967295L & jM585convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            if (constraints == null) {
                this.onMeasureConstraints = new Constraints(jM687fitPrioritizingHeightZbe2FdA);
                this.wasMeasuredWithMultipleConstraints = false;
            } else if (!Constraints.m677equalsimpl0(constraints.value, jM687fitPrioritizingHeightZbe2FdA)) {
                this.wasMeasuredWithMultipleConstraints = true;
            }
            measureAndLayoutDelegate.m562updateRootConstraintsBRTryo0(jM687fitPrioritizingHeightZbe2FdA);
            measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().layoutDelegate.measurePassDelegate.width, getRoot().layoutDelegate.measurePassDelegate.height);
            if (this._androidViewsHandler != null) {
                Trace.beginSection("AndroidOwner:androidViewMeasure");
                try {
                    getAndroidViewsHandler$ui().measure(View.MeasureSpec.makeMeasureSpec(getRoot().layoutDelegate.measurePassDelegate.width, 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().layoutDelegate.measurePassDelegate.height, 1073741824));
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                } finally {
                    Trace.endSection();
                }
            }
            Unit unit2 = Unit.INSTANCE;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
    @Override // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        if (!autofillSupported() || viewStructure == null) {
            return;
        }
        AndroidAutofillManager androidAutofillManager = this._autofillManager;
        if (androidAutofillManager != null) {
            LayoutNode layoutNode = androidAutofillManager.semanticsOwner.rootNode;
            AutofillId autofillId = androidAutofillManager.rootAutofillId;
            String str = androidAutofillManager.packageName;
            RectManager rectManager = androidAutofillManager.rectManager;
            zzss.populate(viewStructure, layoutNode, autofillId, str, rectManager);
            Object[] objArr = ObjectListKt.EmptyArray;
            MutableObjectList mutableObjectList = new MutableObjectList(2);
            mutableObjectList.add(layoutNode);
            mutableObjectList.add(viewStructure);
            while (mutableObjectList.isNotEmpty()) {
                ViewStructure viewStructure2 = (ViewStructure) mutableObjectList.removeAt(mutableObjectList._size - 1);
                MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) ((LayoutNode) mutableObjectList.removeAt(mutableObjectList._size - 1)).getChildren$ui();
                int i2 = ((MutableVector) objectListMutableList.objectList).size;
                for (int i3 = 0; i3 < i2; i3++) {
                    LayoutNode layoutNode2 = (LayoutNode) objectListMutableList.get(i3);
                    if (!layoutNode2.isDeactivated && layoutNode2.isAttached() && layoutNode2.isPlaced()) {
                        SemanticsConfiguration semanticsConfiguration = layoutNode2.getSemanticsConfiguration();
                        if (semanticsConfiguration != null) {
                            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
                            if (mutableScatterMap.contains(SemanticsActions.OnAutofillText) || mutableScatterMap.contains(SemanticsActions.OnFillData) || mutableScatterMap.contains(SemanticsProperties.ContentType) || mutableScatterMap.contains(SemanticsProperties.ContentDataType)) {
                                ViewStructure viewStructureNewChild = viewStructure2.newChild(viewStructure2.addChildCount(1));
                                zzss.populate(viewStructureNewChild, layoutNode2, androidAutofillManager.rootAutofillId, str, rectManager);
                                mutableObjectList.add(layoutNode2);
                                mutableObjectList.add(viewStructureNewChild);
                            } else {
                                mutableObjectList.add(layoutNode2);
                                mutableObjectList.add(viewStructure2);
                            }
                        } else {
                            mutableObjectList.add(layoutNode2);
                            mutableObjectList.add(viewStructure2);
                        }
                    }
                }
            }
        }
        Dispatcher dispatcher = this._autofill;
        if (dispatcher != null) {
            AutofillTree autofillTree = (AutofillTree) dispatcher.readyAsyncCalls;
            LinkedHashMap linkedHashMap = autofillTree.children;
            LinkedHashMap linkedHashMap2 = autofillTree.children;
            if (linkedHashMap.isEmpty()) {
                return;
            }
            int iAddChildCount = viewStructure.addChildCount(linkedHashMap2.size());
            Iterator it = linkedHashMap2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                int iIntValue = ((Number) entry.getKey()).intValue();
                if (entry.getValue() != null) {
                    throw new ClassCastException();
                }
                ViewStructure viewStructureNewChild2 = viewStructure.newChild(iAddChildCount);
                viewStructureNewChild2.setAutofillId((AutofillId) dispatcher.runningSyncCalls, iIntValue);
                viewStructureNewChild2.setId(iIntValue, ((AndroidComposeView) dispatcher.executorServiceOrNull).getContext().getPackageName(), null, null);
                viewStructureNewChild2.setAutofillType(1);
                throw null;
            }
        }
    }

    public final void onRequestMeasure(LayoutNode layoutNode, boolean z, boolean z2, boolean z3) {
        LayoutNode parent$ui;
        LayoutNode parent$ui2;
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (!z) {
            if (measureAndLayoutDelegate.requestRemeasure(layoutNode, z2) && z3) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        MenuHostHelper menuHostHelper = measureAndLayoutDelegate.relayoutNodes;
        LayoutNode layoutNode2 = layoutNode.lookaheadRoot;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (layoutNode2 == null) {
            InlineClassHelperKt.throwIllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(layoutNodeLayoutDelegate.layoutState);
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal != 4) {
                    throw new HttpException();
                }
                if (!layoutNodeLayoutDelegate.lookaheadMeasurePending || z2) {
                    layoutNodeLayoutDelegate.lookaheadMeasurePending = true;
                    layoutNodeLayoutDelegate.measurePassDelegate.measurePending = true;
                    if (layoutNode.isDeactivated) {
                        return;
                    }
                    if ((Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || MeasureAndLayoutDelegate.getCanAffectParentInLookahead(layoutNode)) && ((parent$ui = layoutNode.getParent$ui()) == null || !parent$ui.layoutDelegate.lookaheadMeasurePending)) {
                        menuHostHelper.add(1, layoutNode);
                    } else if ((layoutNode.isPlaced() || MeasureAndLayoutDelegate.getCanAffectPlacedParent(layoutNode)) && ((parent$ui2 = layoutNode.getParent$ui()) == null || !parent$ui2.getMeasurePending$ui())) {
                        menuHostHelper.add(3, layoutNode);
                    }
                    if (measureAndLayoutDelegate.duringFullMeasureLayoutPass || !z3) {
                        return;
                    }
                    scheduleMeasureAndLayout(layoutNode);
                    return;
                }
                return;
            }
        }
        measureAndLayoutDelegate.postponedMeasureRequests.add(new MeasureAndLayoutDelegate.PostponedRequest(layoutNode, true, z2));
    }

    public final void onRequestRelayout(LayoutNode layoutNode, boolean z, boolean z2) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (!z) {
            measureAndLayoutDelegate.getClass();
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(layoutNodeLayoutDelegate.layoutState);
            if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                return;
            }
            if (iOrdinal != 4) {
                throw new HttpException();
            }
            LayoutNode parent$ui = layoutNode.getParent$ui();
            boolean z3 = parent$ui == null || parent$ui.isPlaced();
            if (!z2) {
                if (layoutNode.getMeasurePending$ui()) {
                    return;
                }
                if (layoutNode.getLayoutPending$ui() && layoutNode.isPlaced() == z3 && layoutNode.isPlaced() == layoutNodeLayoutDelegate.measurePassDelegate.isPlacedByParent) {
                    return;
                }
            }
            MeasurePassDelegate measurePassDelegate = layoutNodeLayoutDelegate.measurePassDelegate;
            measurePassDelegate.layoutPending = true;
            measurePassDelegate.layoutPendingForAlignment = true;
            if (!layoutNode.isDeactivated && measurePassDelegate.isPlacedByParent && z3) {
                if ((parent$ui == null || !parent$ui.getLayoutPending$ui()) && (parent$ui == null || !parent$ui.getMeasurePending$ui())) {
                    measureAndLayoutDelegate.relayoutNodes.add(4, layoutNode);
                }
                if (measureAndLayoutDelegate.duringFullMeasureLayoutPass) {
                    return;
                }
                scheduleMeasureAndLayout(null);
                return;
            }
            return;
        }
        MenuHostHelper menuHostHelper = measureAndLayoutDelegate.relayoutNodes;
        int iOrdinal2 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(layoutNodeLayoutDelegate.layoutState);
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                return;
            }
            if (iOrdinal2 != 2) {
                if (iOrdinal2 == 3) {
                    return;
                }
                if (iOrdinal2 != 4) {
                    throw new HttpException();
                }
            }
        }
        if ((layoutNodeLayoutDelegate.lookaheadMeasurePending || layoutNodeLayoutDelegate.lookaheadLayoutPending) && !z2) {
            return;
        }
        layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
        layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = true;
        MeasurePassDelegate measurePassDelegate2 = layoutNodeLayoutDelegate.measurePassDelegate;
        measurePassDelegate2.layoutPending = true;
        measurePassDelegate2.layoutPendingForAlignment = true;
        if (layoutNode.isDeactivated) {
            return;
        }
        LayoutNode parent$ui2 = layoutNode.getParent$ui();
        if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) && ((parent$ui2 == null || !parent$ui2.layoutDelegate.lookaheadMeasurePending) && (parent$ui2 == null || !parent$ui2.layoutDelegate.lookaheadLayoutPending))) {
            menuHostHelper.add(2, layoutNode);
        } else if (layoutNode.isPlaced() && ((parent$ui2 == null || !parent$ui2.getLayoutPending$ui()) && (parent$ui2 == null || !parent$ui2.getMeasurePending$ui()))) {
            menuHostHelper.add(4, layoutNode);
        }
        if (measureAndLayoutDelegate.duringFullMeasureLayoutPass) {
            return;
        }
        scheduleMeasureAndLayout(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        androidx.compose.ui.input.pointer.PointerIcon pointerIcon;
        int toolType = motionEvent.getToolType(i);
        if (motionEvent.isFromSource(8194) || !motionEvent.isFromSource(16386) || (!(toolType == 2 || toolType == 4) || (pointerIcon = ((AndroidComposeView$pointerIconService$1) getPointerIconService()).currentStylusHoverIcon) == null)) {
            return super.onResolvePointerIcon(motionEvent, i);
        }
        Context context = getContext();
        return pointerIcon instanceof AndroidPointerIconType ? PointerIcon.getSystemIcon(context, ((AndroidPointerIconType) pointerIcon).type) : PointerIcon.getSystemIcon(context, 1000);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        CancellationHandle cancellationHandleScheduleFrameEndCallback;
        if (Build.VERSION.SDK_INT < 30) {
            setShowLayoutBounds(InvertMatrixKt.getIsShowingLayoutBounds());
        }
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler = this.frameEndScheduler;
            Parameters.Builder builder = retainedValuesStoreEntry._retainedValuesStore;
            ManagedRetainedValuesStore managedRetainedValuesStore = (ManagedRetainedValuesStore) builder.entries;
            if (!managedRetainedValuesStore.isEnabled || managedRetainedValuesStore.isContentComposed) {
                return;
            }
            try {
                cancellationHandleScheduleFrameEndCallback = ((Wrapper_androidKt.AnonymousClass1) frameEndScheduler).$tmp0.scheduleFrameEndCallback(new Handshake.AnonymousClass2(12, retainedValuesStoreEntry));
            } catch (CancellationException unused) {
                ManagedRetainedValuesStore managedRetainedValuesStore2 = (ManagedRetainedValuesStore) builder.entries;
                if (!managedRetainedValuesStore2.isDisposed) {
                    if (managedRetainedValuesStore2.isContentComposed) {
                        PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                    }
                    managedRetainedValuesStore2.purgeUnusedExitedValues();
                    managedRetainedValuesStore2.isContentComposed = true;
                }
                cancellationHandleScheduleFrameEndCallback = null;
            }
            CancellationHandle cancellationHandle = retainedValuesStoreEntry.endRetainCancellationHandle;
            if (cancellationHandle != null) {
                cancellationHandle.cancel();
            }
            retainedValuesStoreEntry.endRetainCancellationHandle = cancellationHandleScheduleFrameEndCallback;
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        LayoutDirection layoutDirection;
        if (this.superclassInitComplete) {
            int[] iArr = FocusInteropUtils_androidKt.tempCoordinates;
            LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
            if (i != 0) {
                layoutDirection = i != 1 ? null : LayoutDirection.Rtl;
            } else {
                layoutDirection = layoutDirection2;
            }
            if (layoutDirection != null) {
                layoutDirection2 = layoutDirection;
            }
            setLayoutDirection(layoutDirection2);
        }
    }

    @Override // android.view.View
    public final void onScrollCaptureSearch(android.graphics.Rect rect, Point point, Consumer consumer) {
        MemoryCacheService memoryCacheService;
        if (Build.VERSION.SDK_INT >= 31 && (memoryCacheService = this.scrollCapture) != null) {
            SemanticsOwner semanticsOwner = getSemanticsOwner();
            CoroutineContext coroutineContext = getCoroutineContext();
            MutableVector mutableVector = new MutableVector(new ScrollCaptureCandidate[16]);
            zzto.visitScrollCaptureCandidates(semanticsOwner.getUnmergedRootSemanticsNode(), 0, new ScrollCapture$onScrollCaptureSearch$1(1, 8, MutableVector.class, mutableVector, "add", "add(Ljava/lang/Object;)Z"));
            Arrays.sort(mutableVector.content, 0, mutableVector.size, new SemanticsSortKt$$ExternalSyntheticLambda0(3, new Function1[]{ScrollCapture$onScrollCaptureSearch$2.INSTANCE, ScrollCapture$onScrollCaptureSearch$2.INSTANCE$2}));
            int i = mutableVector.size;
            ScrollCaptureCandidate scrollCaptureCandidate = (ScrollCaptureCandidate) (i == 0 ? null : mutableVector.content[i - 1]);
            if (scrollCaptureCandidate != null) {
                IntRect intRect = scrollCaptureCandidate.viewportBoundsInWindow;
                ComposeScrollCaptureCallback composeScrollCaptureCallback = new ComposeScrollCaptureCallback(scrollCaptureCandidate.node, intRect, JobKt.CoroutineScope(coroutineContext), memoryCacheService, this);
                NodeCoordinator nodeCoordinator = scrollCaptureCandidate.coordinates;
                Rect rectLocalBoundingBoxOf = RulerKt.findRootCoordinates(nodeCoordinator).localBoundingBoxOf(nodeCoordinator, true);
                long j = (((long) intRect.left) << 32) | (((long) intRect.top) & 4294967295L);
                ScrollCaptureTarget scrollCaptureTargetM = CanvasCompatS$$ExternalSyntheticApiModelOutline0.m(this, BrushKt.toAndroidRect(IntRectKt.roundToIntRect(rectLocalBoundingBoxOf)), new Point((int) (j >> 32), (int) (j & 4294967295L)), composeScrollCaptureCallback);
                scrollCaptureTargetM.setScrollBounds(BrushKt.toAndroidRect(intRect));
                consumer.accept(scrollCaptureTargetM);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        updatePositionCacheAndDispatch();
    }

    public final void onSemanticsChange() {
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.composeAccessibilityDelegate;
        androidComposeViewAccessibilityDelegateCompat.currentSemanticsNodesInvalidated = true;
        Handler handler = androidComposeViewAccessibilityDelegateCompat.view.getHandler();
        if (androidComposeViewAccessibilityDelegateCompat.isEnabled$ui() && !androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges && handler != null) {
            androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = true;
            handler.post(androidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker);
        }
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.currentSemanticsNodesInvalidated = true;
        Handler handler2 = androidContentCaptureManager.view.getHandler();
        if (!androidContentCaptureManager.isEnabled$ui() || androidContentCaptureManager.checkingForSemanticsChanges || handler2 == null) {
            return;
        }
        androidContentCaptureManager.checkingForSemanticsChanges = true;
        handler2.post(androidContentCaptureManager.contentCaptureChangeChecker);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry retainedValuesStoreEntry = this.lifecycleRetainedValuesStoreOwnerEntry;
        if (retainedValuesStoreEntry != null) {
            ManagedRetainedValuesStore managedRetainedValuesStore = (ManagedRetainedValuesStore) retainedValuesStoreEntry._retainedValuesStore.entries;
            if (managedRetainedValuesStore.isEnabled && !managedRetainedValuesStore.isContentComposed) {
                CancellationHandle cancellationHandle = retainedValuesStoreEntry.endRetainCancellationHandle;
                if (cancellationHandle != null) {
                    cancellationHandle.cancel();
                }
                retainedValuesStoreEntry.endRetainCancellationHandle = null;
                return;
            }
            if (managedRetainedValuesStore.isDisposed) {
                return;
            }
            if (!managedRetainedValuesStore.isContentComposed) {
                PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to leave composition twice. Is the store installed in multiple places?");
            }
            if (!managedRetainedValuesStore.keptExitedValues.isEmpty()) {
                PreconditionsKt.throwIllegalStateException("Attempted to start retaining exited values with pending exited values");
            }
            managedRetainedValuesStore.isContentComposed = false;
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public final void onTouchModeChanged(boolean z) {
        this._inputModeManager.inputMode$delegate.setValue(new InputMode(z ? 1 : 2));
    }

    @Override // android.view.View
    public final void onVirtualViewTranslationResponses(android.util.LongSparseArray longSparseArray) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.getClass();
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            zzst.doTranslation(androidContentCaptureManager, longSparseArray);
        } else {
            androidContentCaptureManager.view.post(new Preview$$ExternalSyntheticLambda1(23, androidContentCaptureManager, longSparseArray));
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        boolean isShowingLayoutBounds;
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(z);
        if (!z || Build.VERSION.SDK_INT >= 30 || getShowLayoutBounds() == (isShowingLayoutBounds = InvertMatrixKt.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateLayers(getRoot());
    }

    public final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = jCurrentAnimationTimeMillis;
            CalculateMatrixToWindow calculateMatrixToWindow = this.matrixToWindow;
            float[] fArr = this.viewToWindowMatrix;
            calculateMatrixToWindow.mo603calculateMatrixToWindowEL8BTi8(this, fArr);
            InvertMatrixKt.m611invertToJiSxe2E(fArr, this.windowToViewMatrix);
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            int[] iArr = this.tmpPositionArray;
            view.getLocationOnScreen(iArr);
            float f = iArr[0];
            float f2 = iArr[1];
            view.getLocationInWindow(iArr);
            this.windowPosition = (((long) Float.floatToRawIntBits(f - iArr[0])) << 32) | (((long) Float.floatToRawIntBits(f2 - iArr[1])) & 4294967295L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, android.graphics.Rect rect) {
        if (!isFocused()) {
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
            int i2 = focusDirection != null ? focusDirection.value : 7;
            Boolean boolM345focusSearchULY8qGw = ((FocusOwnerImpl) getFocusOwner()).m345focusSearchULY8qGw(i2, rect != null ? new Rect(rect.left, rect.top, rect.right, rect.bottom) : null, new FocusOwnerImpl$takeFocus$1(i2, 2));
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.areEqual(boolM345focusSearchULY8qGw, bool)) {
                if (!Intrinsics.areEqual(((FocusOwnerImpl) getFocusOwner()).m345focusSearchULY8qGw(i2, null, new FocusOwnerImpl$takeFocus$1(i2, 3)), bool)) {
                    if (!hasFocus()) {
                        return false;
                    }
                    if (i2 == 1 || i2 == 2) {
                        return ((FocusOwnerImpl) getFocusOwner()).m347resetFocus3ESFkO8(i2);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: requestOwnerFocus-7o62pno, reason: not valid java name */
    public final boolean m592requestOwnerFocus7o62pno() {
        if (isFocused()) {
            return true;
        }
        return super.requestFocus(130, null);
    }

    public final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (layoutNode != null) {
            while (layoutNode != null && layoutNode.getMeasuredByParent$ui() == 1) {
                if (!this.wasMeasuredWithMultipleConstraints) {
                    LayoutNode parent$ui = layoutNode.getParent$ui();
                    if (parent$ui == null) {
                        break;
                    }
                    long j = ((InnerNodeCoordinator) parent$ui.nodes.innerCoordinator).measurementConstraints;
                    if (Constraints.m681getHasFixedWidthimpl(j) && Constraints.m680getHasFixedHeightimpl(j)) {
                        break;
                    }
                }
                layoutNode = layoutNode.getParent$ui();
            }
            if (layoutNode == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
    public final long m593screenToLocalMKHz9U(long j) {
        recalculateWindowPosition();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (this.windowPosition >> 32));
        return Matrix.m443mapMKHz9U((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (this.windowPosition & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32), this.windowToViewMatrix);
    }

    /* JADX INFO: renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    public final int m594sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        Object obj;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            LazyWindowInfo lazyWindowInfo = getComposeViewContext().windowInfo;
            int metaState = motionEvent.getMetaState();
            lazyWindowInfo.getClass();
            WindowInfoImpl.GlobalKeyboardModifiers.setValue(new PointerKeyboardModifiers(metaState));
        }
        MotionEventAdapter motionEventAdapter = this.motionEventAdapter;
        RequestService requestServiceConvertToPointerInputEvent$ui = motionEventAdapter.convertToPointerInputEvent$ui(motionEvent, this);
        int actionMasked = motionEvent.getActionMasked();
        Exchange exchange = this.pointerInputEventProcessor;
        if (requestServiceConvertToPointerInputEvent$ui == null) {
            if (!exchange.hasFailure) {
                ((LongSparseArray) ((MemoryCacheService) exchange.codec).imageLoader).clear();
                ((HitPathTracker) exchange.finder).processCancel();
            }
            return 0;
        }
        List list = (List) requestServiceConvertToPointerInputEvent$ui.systemCallbacks;
        int size = list.size() - 1;
        if (size < 0) {
            obj = null;
            break;
        }
        while (true) {
            int i = size - 1;
            obj = list.get(size);
            if (((PointerInputEventData) obj).down && (actionMasked == 0 || actionMasked == 5)) {
                break;
            }
            if (i < 0) {
                obj = null;
                break;
            }
            size = i;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (pointerInputEventData != null) {
            this.lastDownPointerPosition = pointerInputEventData.position;
        }
        int iM851processBIzXfog = exchange.m851processBIzXfog(requestServiceConvertToPointerInputEvent$ui, this, isInBounds(motionEvent));
        requestServiceConvertToPointerInputEvent$ui.hardwareBitmapService = null;
        if ((actionMasked != 0 && actionMasked != 5) || (iM851processBIzXfog & 1) != 0) {
            return iM851processBIzXfog;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        motionEventAdapter.activeHoverIds.delete(pointerId);
        motionEventAdapter.motionEventToComposePointerIdMap.delete(pointerId);
        return iM851processBIzXfog;
    }

    public final void sendSimulatedEvent(MotionEvent motionEvent, int i, long j, boolean z) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (i != 9 && i != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerPropertiesArr[i2] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerCoordsArr[i3] = new MotionEvent.PointerCoords();
        }
        int i4 = 0;
        while (i4 < pointerCount) {
            int i5 = ((actionIndex < 0 || i4 < actionIndex) ? 0 : 1) + i4;
            motionEvent.getPointerProperties(i5, pointerPropertiesArr[i4]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i4];
            motionEvent.getPointerCoords(i5, pointerCoords);
            float f = pointerCoords.x;
            long jM590localToScreenMKHz9U = m590localToScreenMKHz9U((((long) Float.floatToRawIntBits(pointerCoords.y)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32));
            pointerCoords.x = Float.intBitsToFloat((int) (jM590localToScreenMKHz9U >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (jM590localToScreenMKHz9U & 4294967295L));
            i4++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j : motionEvent.getDownTime(), j, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        this.pointerInputEventProcessor.m851processBIzXfog(this.motionEventAdapter.convertToPointerInputEvent$ui(motionEventObtain, this), this, true);
        motionEventObtain.recycle();
    }

    public void setAccessibilityEventBatchIntervalMillis(long j) {
        this.composeAccessibilityDelegate.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    public final void setComposeViewContext(ComposeViewContext composeViewContext) {
        if (getCoroutineContext() != composeViewContext.compositionContext.getEffectCoroutineContext() && !((MutableObjectList.ObjectListMutableList) getRoot().getChildren$ui()).isEmpty()) {
            InlineClassHelperKt.throwIllegalArgumentException("Changing ComposeViewContext cannot change the coroutine context without disposing of the composition first.");
        }
        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            ComposeViewContext composeViewContext2 = get_composeViewContext();
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            if (composeViewContext.equals(composeViewContext2)) {
                return;
            }
            if (isAttachedToWindow()) {
                composeViewContext2.decrementViewCount$ui();
                composeViewContext.incrementViewCount$ui();
            }
            set_composeViewContext(composeViewContext);
            setCoroutineContext(composeViewContext.compositionContext.getEffectCoroutineContext());
        } catch (Throwable th) {
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final void setComposeViewContextIncrementedDuringInit$ui(boolean z) {
        this.composeViewContextIncrementedDuringInit = z;
    }

    public final void setConfiguration(Configuration configuration) {
        this.configuration$delegate.setValue(configuration);
    }

    public final void setContentCaptureManager$ui(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
    }

    public final void setFrameEndScheduler$ui(LifecycleRetainedValuesStoreOwner.FrameEndScheduler frameEndScheduler) {
        this.frameEndScheduler = frameEndScheduler;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    public final void setOnReadyForComposition(Function1 function1) {
        getDerivedIsAttached();
        if (isAttachedToWindow() || this.composeViewContextIncrementedDuringInit) {
            function1.invoke(getComposeViewContext());
        } else {
            this.onReadyForComposition = function1;
        }
    }

    /* JADX INFO: renamed from: setPrimaryDirectionalMotionAxisOverride-r2epLt8$ui, reason: not valid java name */
    public final void m595setPrimaryDirectionalMotionAxisOverrider2epLt8$ui(IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        this.primaryDirectionalMotionAxisOverride = indirectPointerEventPrimaryDirectionalMotionAxis;
    }

    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public void setUncaughtExceptionHandler(RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.measureAndLayoutDelegate.getClass();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final void textInputSession(Function2 function2, ContinuationImpl continuationImpl) {
        C00141 c00141;
        if (continuationImpl instanceof C00141) {
            c00141 = (C00141) continuationImpl;
            int i = c00141.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00141.label = i - Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuationImpl);
            }
        } else {
            c00141 = new C00141(continuationImpl);
        }
        Object obj = c00141.result;
        int i2 = c00141.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AndroidComposeView$snapshotObserver$1 androidComposeView$snapshotObserver$1 = new AndroidComposeView$snapshotObserver$1(this, 2);
            c00141.label = 1;
            if (JobKt.coroutineScope(new NavHostKt$NavHost$29$1(androidComposeView$snapshotObserver$1, this.textInputSessionMutex, function2, (Continuation) null), c00141) == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new HttpException();
    }

    public final void updateConfiguration(Configuration configuration) {
        ParcelableSnapshotMutableState parcelableSnapshotMutableState;
        Configuration configuration2 = getConfiguration();
        if (Intrinsics.areEqual(configuration2, configuration)) {
            return;
        }
        setConfiguration(new Configuration(configuration));
        if (configuration2.fontScale != configuration.fontScale || configuration2.densityDpi != configuration.densityDpi) {
            setDensity(AndroidDensity_androidKt.Density(getContext()));
        }
        if ((configuration2.diff(configuration) & (-1342235264)) == 0 || (parcelableSnapshotMutableState = this._windowInfo._containerSize) == null) {
            return;
        }
        parcelableSnapshotMutableState.setValue(InvertMatrixKt.calculateWindowSize(this));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0056  */
    public final void updatePositionCacheAndDispatch() {
        boolean z;
        int i;
        int[] iArr = this.tmpPositionArray;
        getLocationOnScreen(iArr);
        long j = this.globalPosition;
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        int i4 = iArr[0];
        if (i2 == i4 && i3 == iArr[1] && this.lastMatrixRecalculationAnimationTime >= 0) {
            z = false;
        } else {
            this.globalPosition = (4294967295L & ((long) iArr[1])) | (((long) i4) << 32);
            if (i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE) {
                z = false;
            } else {
                MutableVector mutableVector = getRoot().get_children$ui();
                Object[] objArr = mutableVector.content;
                int i5 = mutableVector.size;
                for (int i6 = 0; i6 < i5; i6++) {
                    ((LayoutNode) objArr[i6]).layoutDelegate.measurePassDelegate.requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
                }
                z = true;
            }
        }
        recalculateWindowPosition();
        View rootView = this._rootView;
        if (rootView == null) {
            rootView = getRootView();
            this._rootView = rootView;
        }
        RectManager rectManager = getRectManager();
        long j2 = this.globalPosition;
        long jM717roundk4lQ0M = IntOffsetKt.m717roundk4lQ0M(this.windowPosition);
        int width = rootView.getWidth();
        int height = rootView.getHeight();
        rectManager.getClass();
        float[] fArr = this.viewToWindowMatrix;
        if (fArr.length < 16) {
            i = 0;
        } else {
            i = (((fArr[0] == 1.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[4] == 0.0f && fArr[5] == 1.0f && fArr[6] == 0.0f && fArr[8] == 0.0f && fArr[9] == 0.0f && fArr[10] == 1.0f) ? 1 : 0) << 1) | ((fArr[12] == 0.0f && fArr[13] == 0.0f && fArr[14] == 0.0f && fArr[15] == 1.0f) ? 1 : 0);
        }
        ThrottledCallbacks throttledCallbacks = rectManager.throttledCallbacks;
        if ((i & 2) != 0) {
            fArr = null;
        }
        rectManager.isScreenOrWindowDirty = throttledCallbacks.m620updateOffsetsLDcG7Xg(j2, jM717roundk4lQ0M, fArr, width, height) || rectManager.isScreenOrWindowDirty;
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
        getRectManager().dispatchCallbacks();
    }

    public final void voteFrameRate(float f) {
        if (isArrEnabled$ui()) {
            if (f > 0.0f) {
                if (Float.isNaN(this.currentFrameRate) || f > this.currentFrameRate) {
                    this.currentFrameRate = f;
                    return;
                }
                return;
            }
            if (f < 0.0f) {
                if (Float.isNaN(this.currentFrameRateCategory) || f < this.currentFrameRateCategory) {
                    this.currentFrameRateCategory = f;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, i, layoutParams, true);
    }

    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    /* JADX INFO: renamed from: getClipboard, reason: merged with bridge method [inline-methods] */
    public AndroidClipboard m597getClipboard() {
        return this.clipboard;
    }

    /* JADX INFO: renamed from: getClipboardManager, reason: merged with bridge method [inline-methods] */
    public AndroidClipboardManager m598getClipboardManager() {
        return this.clipboardManager;
    }

    /* JADX INFO: renamed from: getDragAndDropManager, reason: merged with bridge method [inline-methods] */
    public AndroidDragAndDropManager m599getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    public MutableIntObjectMap getLayoutNodes() {
        return this.layoutNodes;
    }

    public AndroidComposeView getOutOfFrameExecutor() {
        if (isAttachedToWindow()) {
            return this;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = i;
        layoutParamsGenerateDefaultLayoutParams.height = i2;
        Unit unit = Unit.INSTANCE;
        addViewInLayout(view, -1, layoutParamsGenerateDefaultLayoutParams, true);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i, layoutParams, true);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, -1, layoutParams, true);
    }

    @Override // androidx.compose.ui.focus.FocusListener
    public final void onFocusChanged(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        NodeChain nodeChain;
        boolean z;
        NodeChain nodeChain2;
        boolean z2;
        if (focusTargetNode != null) {
            FocusTargetNode focusTargetNode3 = focusTargetNode;
            if (!focusTargetNode3.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode3.node;
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
            MutableScatterSet mutableScatterSet = null;
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode != null) {
                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 2097152) != 0) {
                    while (node != null) {
                        if ((node.kindSet & 2097152) != 0) {
                            Modifier.Node nodeAccess$pop = node;
                            MutableVector mutableVector = null;
                            while (nodeAccess$pop != null) {
                                if (nodeAccess$pop instanceof IndirectPointerInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodeAccess$pop);
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2 && (nodeAccess$pop.kindSet & 2097152) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                        if ((node2.kindSet & 2097152) != 0) {
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
                        }
                        node = node.parent;
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodeChain2 = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain2.tail;
            }
            if (arrayList == null) {
                return;
            }
            if (focusTargetNode2 != null) {
                if (!focusTargetNode2.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node3 = focusTargetNode2.node;
                LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNode2);
                MutableScatterSet mutableScatterSet2 = null;
                while (layoutNodeRequireLayoutNode2 != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 2097152) != 0) {
                        while (node3 != null) {
                            if ((node3.kindSet & 2097152) != 0) {
                                Modifier.Node nodeAccess$pop2 = node3;
                                MutableVector mutableVector2 = null;
                                while (nodeAccess$pop2 != null) {
                                    if (nodeAccess$pop2 instanceof IndirectPointerInputModifierNode) {
                                        if (mutableScatterSet2 == null) {
                                            MutableScatterSet mutableScatterSet3 = ScatterSetKt.EmptyScatterSet;
                                            mutableScatterSet2 = new MutableScatterSet();
                                        }
                                        mutableScatterSet2.add(nodeAccess$pop2);
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z && (nodeAccess$pop2.kindSet & 2097152) != 0 && (nodeAccess$pop2 instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node node4 = ((DelegatingNode) nodeAccess$pop2).delegate; node4 != null; node4 = node4.child) {
                                            if ((node4.kindSet & 2097152) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    nodeAccess$pop2 = node4;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodeAccess$pop2 != null) {
                                                        mutableVector2.add(nodeAccess$pop2);
                                                        nodeAccess$pop2 = null;
                                                    }
                                                    mutableVector2.add(node4);
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector2);
                                }
                            }
                            node3 = node3.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                    node3 = (layoutNodeRequireLayoutNode2 == null || (nodeChain = layoutNodeRequireLayoutNode2.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                }
                mutableScatterSet = mutableScatterSet2;
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                IndirectPointerInputModifierNode indirectPointerInputModifierNode = (IndirectPointerInputModifierNode) arrayList.get(i3);
                if (!(mutableScatterSet != null ? mutableScatterSet.contains(indirectPointerInputModifierNode) : false)) {
                    indirectPointerInputModifierNode.onCancelIndirectPointerInput();
                }
            }
        }
    }

    public final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        CalculateMatrixToWindow calculateMatrixToWindow = this.matrixToWindow;
        float[] fArr = this.viewToWindowMatrix;
        calculateMatrixToWindow.mo603calculateMatrixToWindowEL8BTi8(this, fArr);
        InvertMatrixKt.m611invertToJiSxe2E(fArr, this.windowToViewMatrix);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        long jM443mapMKHz9U = Matrix.m443mapMKHz9U((((long) Float.floatToRawIntBits(x)) << 32) | (((long) Float.floatToRawIntBits(y)) & 4294967295L), fArr);
        float rawX = motionEvent.getRawX() - Float.intBitsToFloat((int) (jM443mapMKHz9U >> 32));
        float rawY = motionEvent.getRawY() - Float.intBitsToFloat((int) (jM443mapMKHz9U & 4294967295L));
        this.windowPosition = (((long) Float.floatToRawIntBits(rawX)) << 32) | (((long) Float.floatToRawIntBits(rawY)) & 4294967295L);
    }

    @Deprecated
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui$annotations() {
    }

    /* JADX INFO: renamed from: getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui$annotations, reason: not valid java name */
    public static /* synthetic */ void m586getPrimaryDirectionalMotionAxisOverridedqNNBbU$ui$annotations() {
    }

    public static /* synthetic */ void getRoot$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    public static /* synthetic */ void getWindowInfo$annotations() {
    }

    public RootForTest getRootForTest() {
        return this;
    }

    public View getView() {
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RootModifierNode extends Modifier.Node implements BringIntoViewModifierNode, SemanticsModifierNode, KeyInputModifierNode, LayoutModifierNode, TraversableNode, DelegatableNode {
        public final Navigator.AnonymousClass1 rulerLambda = new Navigator.AnonymousClass1(17, this);

        public RootModifierNode() {
        }

        @Override // androidx.compose.ui.relocation.BringIntoViewModifierNode
        public final Object bringIntoView(NodeCoordinator nodeCoordinator, DialogHostKt$DialogHost$1$1$1 dialogHostKt$DialogHost$1$1$1, ContinuationImpl continuationImpl) {
            long jMo525localToRootMKHz9U = nodeCoordinator.mo525localToRootMKHz9U(0L);
            Rect rect = (Rect) dialogHostKt$DialogHost$1$1$1.invoke();
            Rect rectM381translatek4lQ0M = rect != null ? rect.m381translatek4lQ0M(jMo525localToRootMKHz9U) : null;
            if (rectM381translatek4lQ0M != null) {
                AndroidComposeView.this.requestRectangleOnScreen(new android.graphics.Rect((int) rectM381translatek4lQ0M.left, (int) rectM381translatek4lQ0M.top, (int) rectM381translatek4lQ0M.right, (int) rectM381translatek4lQ0M.bottom), false);
            }
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.ui.node.SemanticsModifierNode
        public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
            return false;
        }

        @Override // androidx.compose.ui.node.SemanticsModifierNode
        public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
            return false;
        }

        @Override // androidx.compose.ui.node.TraversableNode
        public final Object getTraverseKey() {
            return "androidx.compose.ui.layout.WindowInsetsRulers";
        }

        @Override // androidx.compose.ui.node.SemanticsModifierNode
        public final /* synthetic */ boolean isImportantForBounds() {
            return true;
        }

        @Override // androidx.compose.ui.node.LayoutModifierNode
        public final /* synthetic */ int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
            return Modifier.CC.$default$maxIntrinsicHeight(this, lookaheadCapablePlaceable, measurable, i);
        }

        @Override // androidx.compose.ui.node.LayoutModifierNode
        public final /* synthetic */ int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
            return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 2, 1, 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
        }

        @Override // androidx.compose.ui.node.LayoutModifierNode
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
            Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(j);
            return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, this.rulerLambda, new PainterNode$measure$1(placeableMo517measureBRTryo0, 5));
        }

        @Override // androidx.compose.ui.node.LayoutModifierNode
        public final /* synthetic */ int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
            return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 1, 2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
        }

        @Override // androidx.compose.ui.node.LayoutModifierNode
        public final /* synthetic */ int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
            return Modifier.CC.$default$minIntrinsicWidth(this, lookaheadCapablePlaceable, measurable, i);
        }

        @Override // androidx.compose.ui.input.key.KeyInputModifierNode
        /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
        public final boolean mo35onKeyEventZmokQxo(KeyEvent keyEvent) {
            FocusDirection focusDirection;
            int[] iArr = FocusInteropUtils_androidKt.tempCoordinates;
            long jM505getKeyZmokQxo = Key_androidKt.m505getKeyZmokQxo(keyEvent);
            Integer num = null;
            if (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.NavigatePrevious)) {
                focusDirection = new FocusDirection(2);
            } else if (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.NavigateNext)) {
                focusDirection = new FocusDirection(1);
            } else if (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.Tab)) {
                focusDirection = new FocusDirection(keyEvent.isShiftPressed() ? 2 : 1);
            } else if (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.DirectionRight)) {
                focusDirection = new FocusDirection(4);
            } else if (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.DirectionLeft)) {
                focusDirection = new FocusDirection(3);
            } else if (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.DirectionUp) || Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.PageUp)) {
                focusDirection = new FocusDirection(5);
            } else if (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.DirectionDown) || Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.PageDown)) {
                focusDirection = new FocusDirection(6);
            } else if (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.DirectionCenter) || Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.Enter) || Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.NumPadEnter)) {
                focusDirection = new FocusDirection(7);
            } else {
                focusDirection = (Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.Back) || Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.Escape)) ? new FocusDirection(8) : null;
            }
            if (focusDirection != null) {
                int i = focusDirection.value;
                if (Key_androidKt.m506getTypeZmokQxo(keyEvent) == 2) {
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    ((FocusOwnerImpl) androidComposeView.getFocusOwner()).getClass();
                    Boolean boolM345focusSearchULY8qGw = ((FocusOwnerImpl) androidComposeView.getFocusOwner()).m345focusSearchULY8qGw(i, androidComposeView.getEmbeddedViewFocusRect(), new Navigator.AnonymousClass1(16, focusDirection));
                    if (boolM345focusSearchULY8qGw != null ? boolM345focusSearchULY8qGw.booleanValue() : true) {
                        return true;
                    }
                    if (i == 1 || i == 2) {
                        if (i == 5) {
                            num = 33;
                        } else if (i == 6) {
                            num = 130;
                        } else if (i == 3) {
                            num = 17;
                        } else if (i == 4) {
                            num = 66;
                        } else if (i == 1) {
                            num = 2;
                        } else if (i == 2) {
                            num = 1;
                        }
                        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) androidComposeView.getRootView(), androidComposeView.getView(), num != null ? num.intValue() : 2);
                        if (viewFindNextFocus == null || viewFindNextFocus.equals(androidComposeView)) {
                            return ((FocusOwnerImpl) androidComposeView.getFocusOwner()).m347resetFocus3ESFkO8(i);
                        }
                    }
                }
            }
            return false;
        }

        @Override // androidx.compose.ui.input.key.KeyInputModifierNode
        /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
        public final boolean mo37onPreKeyEventZmokQxo(KeyEvent keyEvent) {
            return false;
        }

        @Override // androidx.compose.ui.node.SemanticsModifierNode
        public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
    }

    public final void setUncaughtExceptionHandler$ui(RootForTest.UncaughtExceptionHandler uncaughtExceptionHandler) {
    }
}
