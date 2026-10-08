package androidx.compose.ui.window;

import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.layer.ViewLayer;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import coil.network.HttpException;
import com.koala.clash.R;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PopupLayout extends AbstractComposeView {
    public Api33Impl$$ExternalSyntheticLambda0 backCallback;
    public final DerivedSnapshotState canCalculatePosition$delegate;
    public final View composeView;
    public final ParcelableSnapshotMutableState content$delegate;
    public final boolean isNested;
    public final int[] locationOnScreen;
    public Function0 onDismissRequest;
    public final WindowManager.LayoutParams params;
    public IntRect parentBounds;
    public final ParcelableSnapshotMutableState parentLayoutCoordinates$delegate;
    public LayoutDirection parentLayoutDirection;
    public final ParcelableSnapshotMutableState popupContentSize$delegate;
    public final PopupLayoutHelperImpl popupLayoutHelper;
    public PopupPositionProvider positionProvider;
    public final Rect previousWindowVisibleFrame;
    public PopupProperties properties;
    public boolean shouldCreateCompositionOnAttachedToWindow;
    public final SnapshotStateObserver snapshotStateObserver;
    public String testTag;
    public final WindowManager windowManager;

    /* JADX INFO: renamed from: androidx.compose.ui.window.PopupLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends ViewOutlineProvider {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass2(int i) {
            this.$r8$classId = i;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            Outline outline2;
            switch (this.$r8$classId) {
                case 0:
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                    outline.setAlpha(0.0f);
                    return;
                case 1:
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                    outline.setAlpha(0.0f);
                    return;
                case 2:
                    if (!(view instanceof ViewLayer) || (outline2 = ((ViewLayer) view).layerOutline) == null) {
                        return;
                    }
                    outline.set(outline2);
                    return;
                case 3:
                    Modifier.CC.m(view);
                    throw null;
                default:
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                    outline.setAlpha(0.0f);
                    return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupLayout(Function0 function0, PopupProperties popupProperties, String str, View view, Density density, PopupPositionProvider popupPositionProvider, UUID uuid, boolean z) {
        super(view.getContext());
        int i = Build.VERSION.SDK_INT;
        PopupLayoutHelperImpl popupLayoutHelperImpl30 = i >= 30 ? new PopupLayoutHelperImpl30() : i >= 29 ? new PopupLayoutHelperImpl29() : new PopupLayoutHelperImpl();
        this.onDismissRequest = function0;
        this.properties = popupProperties;
        this.testTag = str;
        this.composeView = view;
        this.isNested = z;
        this.popupLayoutHelper = popupLayoutHelperImpl30;
        this.windowManager = (WindowManager) view.getContext().getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        PopupProperties popupProperties2 = this.properties;
        boolean zIsFlagSecureEnabled = AndroidPopup_androidKt.isFlagSecureEnabled(view);
        boolean z2 = popupProperties2.inheritSecurePolicy;
        int i2 = popupProperties2.flags;
        if (z2 && zIsFlagSecureEnabled) {
            i2 |= 8192;
        } else if (z2 && !zIsFlagSecureEnabled) {
            i2 &= -8193;
        }
        layoutParams.flags = i2;
        layoutParams.type = this.properties.windowType;
        layoutParams.token = view.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(view.getContext().getResources().getString(R.string.default_popup_window_title));
        this.params = layoutParams;
        this.positionProvider = popupPositionProvider;
        this.parentLayoutDirection = LayoutDirection.Ltr;
        this.popupContentSize$delegate = Stack.mutableStateOf$default(null);
        this.parentLayoutCoordinates$delegate = Stack.mutableStateOf$default(null);
        this.canCalculatePosition$delegate = Stack.derivedStateOf(new Handshake.AnonymousClass2(16, this));
        this.previousWindowVisibleFrame = new Rect();
        this.snapshotStateObserver = new SnapshotStateObserver(new AndroidPopup_androidKt$Popup$7$1(this, 2));
        setId(android.R.id.content);
        ViewModelKt.set(this, ViewModelKt.get(view));
        ViewModelKt.set(this, ViewModelKt.m774get(view));
        ViewTreeSavedStateRegistryOwner.set(this, ViewTreeSavedStateRegistryOwner.get(view));
        setTag(R.id.compose_view_saveable_id_tag, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(density.mo92toPx0680j_4((float) 8));
        setOutlineProvider(new AnonymousClass2(0));
        this.content$delegate = Stack.mutableStateOf$default(ComposableSingletons$AndroidPopup_androidKt.f10lambda$1131826196);
        this.locationOnScreen = new int[2];
    }

    private final Function2 getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final IntRect getDisplayBounds() {
        int i = this.properties.flags & 512;
        View view = this.composeView;
        PopupLayoutHelperImpl popupLayoutHelperImpl = this.popupLayoutHelper;
        Rect rect = this.previousWindowVisibleFrame;
        if (i == 0) {
            popupLayoutHelperImpl.getClass();
            view.getWindowVisibleDisplayFrame(rect);
        } else {
            popupLayoutHelperImpl.getWindowBounds(view, rect);
        }
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getParentLayoutCoordinates() {
        return (LayoutCoordinates) this.parentLayoutCoordinates$delegate.getValue();
    }

    private final void setContent(Function2 function2) {
        this.content$delegate.setValue(function2);
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.parentLayoutCoordinates$delegate.setValue(layoutCoordinates);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content$1(int i, GapComposer gapComposer) {
        gapComposer.startRestartGroup(-857613600);
        int i2 = (gapComposer.changedInstance(this) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            getContent().invoke(gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PopupLayout$Content$4(i, 0, this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.properties.dismissOnBackPress) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 111) {
            KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
            if (keyDispatcherState == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            }
            if (keyEvent.getAction() == 1 && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                Function0 function0 = this.onDismissRequest;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    public final WindowManager.LayoutParams getParams$ui() {
        return this.params;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m740getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public /* bridge */ /* synthetic */ View getViewRoot() {
        return null;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnLayout$ui(boolean z, int i, int i2, int i3, int i4) {
        super.internalOnLayout$ui(z, i, i2, i3, i4);
        this.properties.getClass();
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        WindowManager.LayoutParams layoutParams = this.params;
        layoutParams.width = measuredWidth;
        layoutParams.height = childAt.getMeasuredHeight();
        this.popupLayoutHelper.getClass();
        this.windowManager.updateViewLayout(this, layoutParams);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnMeasure$ui(int i, int i2) {
        this.properties.getClass();
        IntRect displayBounds = getDisplayBounds();
        super.internalOnMeasure$ui(View.MeasureSpec.makeMeasureSpec(displayBounds.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayBounds.getHeight(), Integer.MIN_VALUE));
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotStateObserver.start();
        if (!this.properties.dismissOnBackPress || Build.VERSION.SDK_INT < 33) {
            return;
        }
        if (this.backCallback == null) {
            this.backCallback = new Api33Impl$$ExternalSyntheticLambda0(0, this.onDismissRequest);
        }
        Api33Impl.maybeRegisterBackCallback(this, this.backCallback);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SnapshotStateObserver snapshotStateObserver = this.snapshotStateObserver;
        OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0 = snapshotStateObserver.applyUnsubscribe;
        if (onBackPressedDispatcher$$ExternalSyntheticLambda0 != null) {
            onBackPressedDispatcher$$ExternalSyntheticLambda0.dispose();
        }
        snapshotStateObserver.clear();
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.maybeUnregisterBackCallback(this, this.backCallback);
        }
        this.backCallback = null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.properties.dismissOnClickOutside) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent != null && motionEvent.getAction() == 0 && (motionEvent.getX() < 0.0f || motionEvent.getX() >= getWidth() || motionEvent.getY() < 0.0f || motionEvent.getY() >= getHeight())) {
            Function0 function0 = this.onDismissRequest;
            if (function0 != null) {
                function0.invoke();
                return true;
            }
        } else {
            if (motionEvent == null || motionEvent.getAction() != 4) {
                return super.onTouchEvent(motionEvent);
            }
            Function0 function1 = this.onDismissRequest;
            if (function1 != null) {
                function1.invoke();
            }
        }
        return true;
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        this.parentLayoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m741setPopupContentSizefhxjrPA(IntSize intSize) {
        this.popupContentSize$delegate.setValue(intSize);
    }

    public final void setPositionProvider(PopupPositionProvider popupPositionProvider) {
        this.positionProvider = popupPositionProvider;
    }

    public final void setTestTag(String str) {
        this.testTag = str;
    }

    public final void updateParameters(Function0 function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
        int i;
        this.onDismissRequest = function0;
        this.testTag = str;
        if (!Intrinsics.areEqual(this.properties, popupProperties)) {
            popupProperties.getClass();
            this.properties = popupProperties;
            boolean zIsFlagSecureEnabled = AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView);
            boolean z = popupProperties.inheritSecurePolicy;
            int i2 = popupProperties.flags;
            if (z && zIsFlagSecureEnabled) {
                i2 |= 8192;
            } else if (z && !zIsFlagSecureEnabled) {
                i2 &= -8193;
            }
            WindowManager.LayoutParams layoutParams = this.params;
            layoutParams.flags = i2;
            this.popupLayoutHelper.getClass();
            this.windowManager.updateViewLayout(this, layoutParams);
        }
        int iOrdinal = layoutDirection.ordinal();
        if (iOrdinal != 0) {
            i = 1;
            if (iOrdinal != 1) {
                throw new HttpException();
            }
        } else {
            i = 0;
        }
        super.setLayoutDirection(i);
    }

    public final void updateParentBounds$ui() {
        LayoutCoordinates parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            if (!parentLayoutCoordinates.isAttached()) {
                parentLayoutCoordinates = null;
            }
            if (parentLayoutCoordinates == null) {
                return;
            }
            long jMo522getSizeYbymL2g = parentLayoutCoordinates.mo522getSizeYbymL2g();
            long jMo526localToScreenMKHz9U = this.isNested ? parentLayoutCoordinates.mo526localToScreenMKHz9U(0L) : parentLayoutCoordinates.mo527localToWindowMKHz9U(0L);
            IntRect intRectM719IntRectVbeCjmY = IntRectKt.m719IntRectVbeCjmY((((long) Math.round(Float.intBitsToFloat((int) (jMo526localToScreenMKHz9U >> 32)))) << 32) | (4294967295L & ((long) Math.round(Float.intBitsToFloat((int) (jMo526localToScreenMKHz9U & 4294967295L))))), jMo522getSizeYbymL2g);
            if (intRectM719IntRectVbeCjmY.equals(this.parentBounds)) {
                return;
            }
            this.parentBounds = intRectM719IntRectVbeCjmY;
            updatePosition();
        }
    }

    public final void updateParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        setParentLayoutCoordinates(layoutCoordinates);
        updateParentBounds$ui();
    }

    public final void updatePosition() {
        IntSize intSizeM740getPopupContentSizebOM6tXw;
        final IntRect intRect = this.parentBounds;
        if (intRect == null || (intSizeM740getPopupContentSizebOM6tXw = m740getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        final long j = intSizeM740getPopupContentSizebOM6tXw.packedValue;
        IntRect displayBounds = getDisplayBounds();
        final long height = (((long) displayBounds.getHeight()) & 4294967295L) | (((long) displayBounds.getWidth()) << 32);
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = 0L;
        this.snapshotStateObserver.observeReads(this, AndroidPopup_androidKt$Popup$5$1$1.INSTANCE$5, new Function0() { // from class: androidx.compose.ui.window.PopupLayout.updatePosition.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PopupLayout popupLayout = this;
                ref$LongRef.element = popupLayout.getPositionProvider().mo10calculatePositionllwVHH4(intRect, height, popupLayout.getParentLayoutDirection(), j);
                return Unit.INSTANCE;
            }
        });
        long j2 = ref$LongRef.element;
        WindowManager.LayoutParams layoutParams = this.params;
        layoutParams.x = (int) (j2 >> 32);
        layoutParams.y = (int) (j2 & 4294967295L);
        boolean z = this.properties.excludeFromSystemGesture;
        PopupLayoutHelperImpl popupLayoutHelperImpl = this.popupLayoutHelper;
        if (z) {
            popupLayoutHelperImpl.setGestureExclusionRects(this, (int) (height >> 32), (int) (height & 4294967295L));
        }
        popupLayoutHelperImpl.getClass();
        this.windowManager.updateViewLayout(this, layoutParams);
    }

    public final void setContent(CompositionContext compositionContext, Function2 function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public static /* synthetic */ void getParams$ui$annotations() {
    }

    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
    }
}
