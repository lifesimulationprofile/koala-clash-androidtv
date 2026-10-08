package androidx.compose.foundation.text;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.core.view.WindowInsetsControllerCompat$Impl;
import androidx.core.view.WindowInsetsControllerCompat$Impl23;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$Impl35;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticLambda12 implements Function0 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda12(View view, boolean z) {
        this.f$1 = view;
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        MutableSharedFlow stylusHandwritingTrigger;
        Window window;
        WindowInsetsControllerCompat$Impl windowInsetsControllerCompat$Impl26;
        switch (this.$r8$classId) {
            case 0:
                AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter = (AndroidLegacyPlatformTextInputServiceAdapter) this.f$1;
                if (this.f$0 && (stylusHandwritingTrigger = androidLegacyPlatformTextInputServiceAdapter.getStylusHandwritingTrigger()) != null) {
                    ((SharedFlowImpl) stylusHandwritingTrigger).tryEmit(Unit.INSTANCE);
                }
                break;
            default:
                Context context = ((View) this.f$1).getContext();
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null && (window = activity.getWindow()) != null) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 35) {
                        windowInsetsControllerCompat$Impl26 = new WindowInsetsControllerCompat$Impl35(window);
                    } else if (i >= 30) {
                        windowInsetsControllerCompat$Impl26 = new WindowInsetsControllerCompat$Impl30(window);
                    } else {
                        windowInsetsControllerCompat$Impl26 = i >= 26 ? new WindowInsetsControllerCompat$Impl26(window) : new WindowInsetsControllerCompat$Impl23(window);
                    }
                    boolean z = !this.f$0;
                    windowInsetsControllerCompat$Impl26.setAppearanceLightStatusBars(z);
                    windowInsetsControllerCompat$Impl26.setAppearanceLightNavigationBars(z);
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda12(boolean z, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter) {
        this.f$0 = z;
        this.f$1 = androidLegacyPlatformTextInputServiceAdapter;
    }
}
