package coil.compose;

import android.content.pm.PackageInfo;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.ChangeSize;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.Fade;
import androidx.compose.animation.Scale;
import androidx.compose.animation.Slide;
import androidx.compose.animation.TransitionData;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.lazy.LazyListState$$ExternalSyntheticLambda3;
import androidx.compose.ui.text.style.TextMotion;
import androidx.navigation.Navigator;
import androidx.window.layout.WindowMetricsCalculator;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.compose.ProviderItemState;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.core.model.Proxy;
import com.github.kr328.clash.design.compose.components.ControlButtonState;
import com.github.kr328.clash.design.model.AppInfo;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.service.model.Profile;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AsyncImagePainter$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ AsyncImagePainter$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x01d9  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        switch (this.$r8$classId) {
            case 0:
                return (AsyncImagePainter.State) obj;
            case 1:
                return new TextMotion.Linearity(((Integer) obj).intValue());
            case 2:
                return (WindowMetricsCalculator) obj;
            case 3:
                return Unit.INSTANCE;
            case 4:
                return Boolean.valueOf(((PackageInfo) obj).applicationInfo != null);
            case 5:
                PackageInfo packageInfo = (PackageInfo) obj;
                String[] strArr = packageInfo.requestedPermissions;
                return Boolean.valueOf((strArr != null && ArraysKt.contains(strArr, "android.permission.INTERNET")) || packageInfo.applicationInfo.uid < 10000);
            case 6:
                int i = FilesActivity.$r8$clinit;
                return Unit.INSTANCE;
            case 7:
                return ((File) obj).id;
            case 8:
                return Boolean.valueOf(!StringsKt.isBlank((String) obj));
            case 9:
                String str = (String) obj;
                return Boolean.valueOf(StringsKt__StringsJVMKt.startsWith(str, "https://", true) || StringsKt__StringsJVMKt.startsWith(str, "http://", true));
            case 10:
                String str2 = (String) obj;
                if (str2.length() != 0) {
                    Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull(str2);
                    z = (longOrNull != null ? longOrNull.longValue() : 0L) >= 15;
                }
                return Boolean.valueOf(z);
            case 11:
                Provider provider = ((ProviderItemState) obj).provider;
                return ImageAnalysis$$ExternalSyntheticLambda1.m(provider.type.name(), "/", provider.name);
            case 12:
                ((JsonBuilder) obj).ignoreUnknownKeys = true;
                return Unit.INSTANCE;
            case 13:
                return ((ConnectionInfo) obj).id;
            case 14:
                return CaptureSession$State$EnumUnboxingLocalUtility.m("closed_", ((ConnectionInfo) obj).id);
            case 15:
                return ((ProcessGroup) obj).process;
            case 16:
                return ((AnimatedContentTransitionScopeImpl) obj).getTargetState() != null ? AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(new AsyncImagePainter$$ExternalSyntheticLambda0(17)).plus(EnterExitTransitionKt.fadeIn$default(null, 3)), EnterExitTransitionKt.slideOutHorizontally$default(new AsyncImagePainter$$ExternalSyntheticLambda0(18)).plus(EnterExitTransitionKt.fadeOut$default(null, 3))) : AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(new AsyncImagePainter$$ExternalSyntheticLambda0(19)).plus(EnterExitTransitionKt.fadeIn$default(null, 3)), EnterExitTransitionKt.slideOutHorizontally$default(new AsyncImagePainter$$ExternalSyntheticLambda0(20)).plus(EnterExitTransitionKt.fadeOut$default(null, 3)));
            case 17:
                return Integer.valueOf(((Integer) obj).intValue() / 3);
            case 18:
                return Integer.valueOf((-((Integer) obj).intValue()) / 3);
            case 19:
                return Integer.valueOf((-((Integer) obj).intValue()) / 3);
            case 20:
                return Integer.valueOf(((Integer) obj).intValue() / 3);
            case 21:
                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) obj;
                int i2 = ((ControlButtonState) animatedContentTransitionScopeImpl.getTargetState()).ordinal() > ((ControlButtonState) animatedContentTransitionScopeImpl.getInitialState()).ordinal() ? 1 : -1;
                return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(300, 6, null), 2).plus(new EnterTransitionImpl(new TransitionData((Fade) null, new Slide(new Navigator.AnonymousClass1(6, new LazyListState$$ExternalSyntheticLambda3(i2, 1)), ArcSplineKt.tween$default(300, 6, null)), (ChangeSize) null, (Scale) null, (LinkedHashMap) null, 125))), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(300, 6, null), 2).plus(new ExitTransitionImpl(new TransitionData((Fade) null, new Slide(new Navigator.AnonymousClass1(7, new LazyListState$$ExternalSyntheticLambda3(i2, 2)), ArcSplineKt.tween$default(300, 6, null)), (ChangeSize) null, (Scale) (0 == true ? 1 : 0), (LinkedHashMap) null, 125))));
            case 22:
                ((Boolean) obj).booleanValue();
                return Unit.INSTANCE;
            case 23:
                return ((Profile) obj).uuid.toString();
            case 24:
                return (String) obj;
            case 25:
                return ((Proxy) obj).name;
            case 26:
                return ((AppInfo) obj).packageName;
            case 27:
                return ((Profile) obj).uuid;
            case 28:
                Pair pair = (Pair) obj;
                return pair.first + ":" + pair.second;
            default:
                return StringsKt.trim((String) obj).toString();
        }
    }
}
