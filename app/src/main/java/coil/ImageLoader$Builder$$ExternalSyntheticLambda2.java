package coil;

import android.app.Activity;
import android.content.Intent;
import androidx.compose.material3.RippleDefaults;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.Typography;
import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.retain.ForgetfulRetainedValuesStore;
import androidx.compose.runtime.retain.LocalRetainedValuesStoreKt;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import coil.network.HttpException;
import com.github.kr328.clash.AppCrashedActivity;
import com.github.kr328.clash.LogcatActivity;
import com.github.kr328.clash.PropertiesActivity;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.core.model.LogMessage$Level$$serializer;
import com.github.kr328.clash.core.model.TunnelState$Mode$$serializer;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.util.ApplicationObserver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ImageLoader$Builder$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ImageLoader$Builder$$ExternalSyntheticLambda2(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return new OkHttpClient(new OkHttpClient.Builder());
            case 1:
                return RippleDefaults.ThemeConfiguration;
            case 2:
                return new Shapes();
            case 3:
                return new Dp(0);
            case 4:
                return TypographyTokensKt.DefaultTextStyle;
            case 5:
                return new Typography(null, null, null, null, null, null, null, null, null, 32767);
            case 6:
                ComposerKt.composeRuntimeError("Unexpected call to default provider");
                throw new HttpException();
            case 7:
                throw new IllegalStateException("CompositionLocal LocalHostDefaultProvider not present");
            case 8:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalRetainedValuesStoreKt.LocalRetainedValuesStore;
                return ForgetfulRetainedValuesStore.INSTANCE;
            case 9:
                return new SaveableStateHolderImpl(new LinkedHashMap());
            case 10:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = SaveableStateRegistryKt.LocalSaveableStateRegistry;
                return null;
            case 11:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = CompositionErrorContextKt.LocalCompositionErrorContext;
                return null;
            case 12:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = InspectionTablesKt.LocalInspectionTables;
                return null;
            case 13:
                return SpanStyleKt.DefaultColorForegroundStyle;
            case 14:
                throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present");
            case 15:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = LocalViewModelStoreOwner.LocalViewModelStoreOwner;
                return null;
            case 16:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal2 = LocalNavigationEventDispatcherOwner.LocalNavigationEventDispatcherOwner;
                return null;
            case 17:
                throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present");
            case 18:
                return null;
            case 19:
                int i = LogcatActivity.$r8$clinit;
                return Unit.INSTANCE;
            case 20:
                int i2 = LogcatActivity.$r8$clinit;
                return Unit.INSTANCE;
            case 21:
                int i3 = LogcatActivity.$r8$clinit;
                return Unit.INSTANCE;
            case 22:
                int i4 = PropertiesActivity.$r8$clinit;
                return Boolean.FALSE;
            case 23:
                return Unit.INSTANCE;
            case 24:
                return Unit.INSTANCE;
            case 25:
                return LogMessage$Level$$serializer.INSTANCE;
            case 26:
                return TunnelState$Mode$$serializer.INSTANCE;
            case 27:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal3 = GlassSnackbarKt.LocalGlassSnackbarHost;
                return null;
            case 28:
                throw new IllegalStateException("AppColors not provided. Wrap content in AppTheme.");
            default:
                Iterator it = ApplicationObserver._createdActivities.iterator();
                while (it.hasNext()) {
                    ((Activity) it.next()).finish();
                }
                Intent intentAddFlags = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(AppCrashedActivity.class)).addFlags(268435456);
                Global.INSTANCE.getClass();
                Global.getApplication$1().startActivity(intentAddFlags);
                return Unit.INSTANCE;
        }
    }
}
