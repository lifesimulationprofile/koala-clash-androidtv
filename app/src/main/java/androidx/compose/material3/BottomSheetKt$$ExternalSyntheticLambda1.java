package androidx.compose.material3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.runtime.MutableState;
import com.github.kr328.clash.ApkDownloader;
import com.github.kr328.clash.ProvidersActivity;
import com.github.kr328.clash.UpdateInfo;
import com.github.kr328.clash.compose.ProviderItemState;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$5$1$1;
import com.github.kr328.clash.core.model.Provider;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                SheetState sheetState = (SheetState) this.f$0;
                CoroutineScope coroutineScope = (CoroutineScope) this.f$1;
                Animatable animatable = (Animatable) this.f$2;
                Function0 function0 = (Function0) this.f$3;
                Continuation continuation = null;
                if (sheetState.getCurrentValue() == SheetValue.Expanded && sheetState.getHasPartiallyExpandedState()) {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 1), 3);
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(animatable, continuation, 0), 3);
                } else {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 2), 3).invokeOnCompletion(new BottomSheetKt$$ExternalSyntheticLambda3(sheetState, function0, 0));
                }
                break;
            case 1:
                Float f = (Float) this.f$0;
                InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) this.f$1;
                Float f2 = (Float) this.f$2;
                InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) this.f$3;
                if (!f.equals(transitionAnimationState.initialValue) || !f2.equals(transitionAnimationState.targetValue)) {
                    transitionAnimationState.initialValue = f;
                    transitionAnimationState.targetValue = f2;
                    transitionAnimationState.animation = new TargetBasedAnimation(infiniteRepeatableSpec, ArcSplineKt.FloatToVector, f, f2, null);
                    transitionAnimationState.this$0.refreshChildNeeded$delegate.setValue(Boolean.TRUE);
                    transitionAnimationState.isFinished = false;
                    transitionAnimationState.startOnTheNextFrame = true;
                }
                break;
            case 2:
                MutableState mutableState = (MutableState) this.f$0;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.f$1;
                SnackbarHostState snackbarHostState = (SnackbarHostState) this.f$2;
                ProvidersActivity providersActivity = (ProvidersActivity) this.f$3;
                for (ProviderItemState providerItemState : (List) mutableState.getValue()) {
                    if (!providerItemState.updating) {
                        Provider provider = providerItemState.provider;
                        if (provider.vehicleType != Provider.VehicleType.Inline) {
                            ProvidersActivity.AnonymousClass1.invoke$updateOne(coroutineScope2, mutableState, snackbarHostState, providersActivity, provider);
                        }
                    }
                }
                break;
            default:
                Context context = (Context) this.f$0;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.f$1;
                MutableState mutableState2 = (MutableState) this.f$2;
                SnackbarHostState snackbarHostState2 = (SnackbarHostState) this.f$3;
                UpdateInfo updateInfo = (UpdateInfo) mutableState2.getValue();
                Continuation continuation2 = null;
                mutableState2.setValue(null);
                String str = updateInfo.apkDownloadUrl;
                if (str != null) {
                    ApkDownloader.downloadAndInstall(context, str, updateInfo.versionName);
                    JobKt.launch$default(coroutineScope3, null, new SettingsScreenKt$SettingsScreen$5$1$1(snackbarHostState2, context, continuation2, 0), 3);
                } else {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(updateInfo.htmlUrl)));
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
