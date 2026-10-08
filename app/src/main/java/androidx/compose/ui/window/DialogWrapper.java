package androidx.compose.ui.window;

import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.ComponentDialog;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentManager$1;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import coil.network.HttpException;
import com.koala.clash.R;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DialogWrapper extends ComponentDialog {
    public final View composeView;
    public final DialogLayout dialogLayout;
    public boolean isPressOutside;
    public Function0 onDismissRequest;
    public DialogProperties properties;

    /* JADX INFO: renamed from: androidx.compose.ui.window.DialogWrapper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends Lambda implements Function1 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ DialogWrapper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(DialogWrapper dialogWrapper, int i) {
            super(1);
            this.$r8$classId = i;
            this.this$0 = dialogWrapper;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    DialogWrapper dialogWrapper = this.this$0;
                    dialogWrapper.properties.getClass();
                    dialogWrapper.onDismissRequest.invoke();
                    return Unit.INSTANCE;
                default:
                    DialogWrapper dialogWrapper2 = this.this$0;
                    dialogWrapper2.show();
                    return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(13, dialogWrapper2);
            }
        }
    }

    public DialogWrapper(Function0 function0, DialogProperties dialogProperties, View view, LayoutDirection layoutDirection, Density density, UUID uuid) {
        super(new ContextThemeWrapper(view.getContext(), R.style.DialogWindowTheme), 0);
        this.onDismissRequest = function0;
        this.properties = dialogProperties;
        this.composeView = view;
        float f = 8;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog has no window");
        }
        DialogProperties dialogProperties2 = this.properties;
        Window window2 = getWindow();
        if (window2 != null) {
            WindowManager.LayoutParams attributes = window2.getAttributes();
            dialogProperties2.getClass();
            attributes.type = 2;
            window2.setAttributes(attributes);
        }
        window.requestFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        this.properties.getClass();
        WindowCompat.setDecorFitsSystemWindows(window, true);
        window.setGravity(17);
        this.properties.getClass();
        DialogLayout dialogLayout = new DialogLayout(getContext(), window);
        this.properties.getClass();
        setTitle("");
        dialogLayout.setTag(R.id.compose_view_saveable_id_tag, "Dialog:" + uuid);
        dialogLayout.setClipChildren(false);
        dialogLayout.setElevation(density.mo92toPx0680j_4(f));
        dialogLayout.setOutlineProvider(new PopupLayout.AnonymousClass2(4));
        this.dialogLayout = dialogLayout;
        View decorView = window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            _init_$disableClipping(viewGroup);
        }
        setContentView(dialogLayout);
        ViewModelKt.set(dialogLayout, ViewModelKt.get(view));
        ViewModelKt.set(dialogLayout, ViewModelKt.m774get(view));
        ViewTreeSavedStateRegistryOwner.set(dialogLayout, ViewTreeSavedStateRegistryOwner.get(view));
        updateParameters(this.onDismissRequest, this.properties, layoutDirection);
        getOnBackPressedDispatcher().addCallback(new FragmentManager$1(1, new AnonymousClass2(this, 0)), this);
    }

    public static final void _init_$disableClipping(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof DialogLayout) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                _init_$disableClipping(viewGroup2);
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.properties.getClass();
        if (!keyEvent.isTracking() || keyEvent.isCanceled() || i != 111) {
            return super.onKeyUp(i, keyEvent);
        }
        this.onDismissRequest.invoke();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0075  */
    /* JADX WARN: Code duplicated, block: B:24:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0080  */
    /* JADX WARN: Code duplicated, block: B:29:0x0083  */
    /* JADX WARN: Code duplicated, block: B:31:0x0087  */
    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        View childAt;
        int iRoundToInt;
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        this.properties.getClass();
        DialogLayout dialogLayout = this.dialogLayout;
        dialogLayout.getClass();
        if (Math.abs(motionEvent.getX()) > Float.MAX_VALUE || Math.abs(motionEvent.getY()) > Float.MAX_VALUE || (childAt = dialogLayout.getChildAt(0)) == null) {
            actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                this.isPressOutside = true;
                return true;
            }
            if (actionMasked != 1) {
                if (actionMasked == 3) {
                    this.isPressOutside = false;
                    return zOnTouchEvent;
                }
            } else if (this.isPressOutside) {
                this.onDismissRequest.invoke();
                this.isPressOutside = false;
                return true;
            }
        } else {
            int left = childAt.getLeft() + dialogLayout.getLeft();
            int width = childAt.getWidth() + left;
            int top = childAt.getTop() + dialogLayout.getTop();
            int height = childAt.getHeight() + top;
            int iRoundToInt2 = MathKt.roundToInt(motionEvent.getX());
            if (left > iRoundToInt2 || iRoundToInt2 > width || top > (iRoundToInt = MathKt.roundToInt(motionEvent.getY())) || iRoundToInt > height) {
                actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    this.isPressOutside = true;
                    return true;
                }
                if (actionMasked != 1) {
                    if (actionMasked == 3) {
                        this.isPressOutside = false;
                        return zOnTouchEvent;
                    }
                } else if (this.isPressOutside) {
                    this.onDismissRequest.invoke();
                    this.isPressOutside = false;
                    return true;
                }
            } else {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 == 0 || actionMasked2 == 1 || actionMasked2 == 3) {
                    this.isPressOutside = false;
                    return zOnTouchEvent;
                }
            }
        }
        return zOnTouchEvent;
    }

    public final void updateParameters(Function0 function0, DialogProperties dialogProperties, LayoutDirection layoutDirection) {
        int i;
        this.onDismissRequest = function0;
        this.properties = dialogProperties;
        dialogProperties.getClass();
        boolean zIsFlagSecureEnabled = AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView);
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(1);
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                zIsFlagSecureEnabled = true;
            } else {
                if (iOrdinal != 2) {
                    throw new HttpException();
                }
                zIsFlagSecureEnabled = false;
            }
        }
        getWindow().setFlags(zIsFlagSecureEnabled ? 8192 : -8193, 8192);
        int iOrdinal2 = layoutDirection.ordinal();
        if (iOrdinal2 == 0) {
            i = 0;
        } else {
            if (iOrdinal2 != 1) {
                throw new HttpException();
            }
            i = 1;
        }
        DialogLayout dialogLayout = this.dialogLayout;
        dialogLayout.setLayoutDirection(i);
        Window window = dialogLayout.window;
        boolean z = (dialogLayout.hasCalledSetLayout && true == dialogLayout.usePlatformDefaultWidth && true == dialogLayout.decorFitsSystemWindows) ? false : true;
        dialogLayout.usePlatformDefaultWidth = true;
        dialogLayout.decorFitsSystemWindows = true;
        if (z && (-2 != window.getAttributes().width || !dialogLayout.hasCalledSetLayout)) {
            window.setLayout(-2, -2);
            dialogLayout.hasCalledSetLayout = true;
        }
        setCanceledOnTouchOutside(true);
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(0);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
    }
}
