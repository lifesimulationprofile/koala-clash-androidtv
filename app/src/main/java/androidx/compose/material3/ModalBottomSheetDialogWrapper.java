package androidx.compose.material3;

import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.ComponentDialog;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl;
import androidx.core.view.WindowInsetsControllerCompat$Impl23;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$Impl35;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import coil.network.HttpException;
import com.koala.clash.R;
import java.util.UUID;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetDialogWrapper extends ComponentDialog {
    public final View composeView;
    public long contentColor;
    public final ModalBottomSheetDialogLayout dialogLayout;
    public Function0 onDismissRequest;
    public ModalBottomSheetProperties properties;

    public ModalBottomSheetDialogWrapper(Function0 function0, ModalBottomSheetProperties modalBottomSheetProperties, long j, View view, LayoutDirection layoutDirection, Density density, UUID uuid) {
        super(new ContextThemeWrapper(view.getContext(), R.style.EdgeToEdgeFloatingDialogWindowTheme), 0);
        this.onDismissRequest = function0;
        this.properties = modalBottomSheetProperties;
        this.contentColor = j;
        this.composeView = view;
        float f = 8;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog has no window");
        }
        window.requestFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowCompat.setDecorFitsSystemWindows(window, false);
        ModalBottomSheetDialogLayout modalBottomSheetDialogLayout = new ModalBottomSheetDialogLayout(getContext());
        modalBottomSheetDialogLayout.setTag(R.id.compose_view_saveable_id_tag, "Dialog:" + uuid);
        modalBottomSheetDialogLayout.setClipChildren(false);
        modalBottomSheetDialogLayout.setElevation(density.mo92toPx0680j_4(f));
        modalBottomSheetDialogLayout.setOutlineProvider(new PopupLayout.AnonymousClass2(1));
        this.dialogLayout = modalBottomSheetDialogLayout;
        setContentView(modalBottomSheetDialogLayout);
        ViewModelKt.set(modalBottomSheetDialogLayout, ViewModelKt.get(view));
        ViewModelKt.set(modalBottomSheetDialogLayout, ViewModelKt.m774get(view));
        ViewTreeSavedStateRegistryOwner.set(modalBottomSheetDialogLayout, ViewTreeSavedStateRegistryOwner.get(view));
        m251updateParameters9LQNqLg(this.onDismissRequest, this.properties, this.contentColor, layoutDirection);
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (zOnTouchEvent) {
            this.onDismissRequest.invoke();
        }
        return zOnTouchEvent;
    }

    /* JADX INFO: renamed from: updateParameters-9LQNqLg, reason: not valid java name */
    public final void m251updateParameters9LQNqLg(Function0 function0, ModalBottomSheetProperties modalBottomSheetProperties, long j, LayoutDirection layoutDirection) {
        int i;
        WindowInsetsControllerCompat$Impl windowInsetsControllerCompat$Impl26;
        this.onDismissRequest = function0;
        this.properties = modalBottomSheetProperties;
        this.contentColor = j;
        modalBottomSheetProperties.getClass();
        ViewGroup.LayoutParams layoutParams = this.composeView.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        boolean z = (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(1);
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                z = true;
            } else {
                if (iOrdinal != 2) {
                    throw new HttpException();
                }
                z = false;
            }
        }
        getWindow().setFlags(z ? 8192 : -8193, 8192);
        int iOrdinal2 = layoutDirection.ordinal();
        if (iOrdinal2 == 0) {
            i = 0;
        } else {
            if (iOrdinal2 != 1) {
                throw new HttpException();
            }
            i = 1;
        }
        this.dialogLayout.setLayoutDirection(i);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(Build.VERSION.SDK_INT >= 30 ? 48 : 16);
        }
        Window window3 = getWindow();
        getWindow().getDecorView();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            windowInsetsControllerCompat$Impl26 = new WindowInsetsControllerCompat$Impl35(window3);
        } else if (i2 >= 30) {
            windowInsetsControllerCompat$Impl26 = new WindowInsetsControllerCompat$Impl30(window3);
        } else {
            windowInsetsControllerCompat$Impl26 = i2 >= 26 ? new WindowInsetsControllerCompat$Impl26(window3) : new WindowInsetsControllerCompat$Impl23(window3);
        }
        long j2 = Color.Transparent;
        windowInsetsControllerCompat$Impl26.setAppearanceLightStatusBars(!Color.m435equalsimpl0(j, j2) && ((double) BrushKt.m421luminance8_81llA(j)) <= 0.5d);
        windowInsetsControllerCompat$Impl26.setAppearanceLightNavigationBars(!Color.m435equalsimpl0(j, j2) && ((double) BrushKt.m421luminance8_81llA(j)) <= 0.5d);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
    }
}
