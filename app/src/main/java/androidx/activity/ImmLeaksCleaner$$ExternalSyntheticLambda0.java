package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.compose.foundation.DefaultDebugIndication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.OverscrollConfiguration;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.BasicText_androidKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.foundation.text.selection.DefaultTextSelectionColors_androidKt;
import androidx.compose.foundation.text.selection.SelectionRegistrarImpl;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.material3.AlertDialogKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DefaultBasicAlertDialogOverride;
import androidx.compose.material3.DefaultSingleRowTopAppBarOverride;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MotionScheme;
import androidx.compose.material3.PrecisionPointer_androidKt;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.unit.Dp;
import java.lang.reflect.Field;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ImmLeaksCleaner$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ImmLeaksCleaner$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    declaredField3.setAccessible(true);
                    return new ImmLeaksCleaner.ValidCleaner(declaredField3, declaredField, declaredField2);
                } catch (NoSuchFieldException unused) {
                    return ImmLeaksCleaner.FailedInitialization.INSTANCE;
                }
            case 1:
                return UUID.randomUUID().toString();
            case 2:
                return Unit.INSTANCE;
            case 3:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = LocalActivityResultRegistryOwner.LocalComposition;
                return null;
            case 4:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal2 = LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner;
                return null;
            case 5:
                AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
                return Integer.valueOf(Random.defaultRandom.getImpl().nextInt(2147418112) + 65536);
            case 6:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal3 = IndicationKt.LocalIndication;
                return DefaultDebugIndication.INSTANCE;
            case 7:
                return new OverscrollConfiguration();
            case 8:
                return new ScrollState(0);
            case 9:
                float f = DragGestureDetectorKt.mouseToTouchSlopRatio;
                return Boolean.TRUE;
            case 10:
                return Unit.INSTANCE;
            case 11:
                return new LazyListState(0, 0);
            case 12:
                return new SolidColor(BrushKt.Color(1308617531));
            case 13:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = BasicText_androidKt.LocalBackgroundTextMeasurementExecutor;
                return null;
            case 14:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal4 = TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider;
                return null;
            case 15:
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                return DefaultIoScheduler.INSTANCE;
            case 16:
                return new SelectionRegistrarImpl(1L);
            case 17:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal5 = SelectionRegistrarKt.LocalSelectionRegistrar;
                return null;
            case 18:
                return DefaultTextSelectionColors_androidKt.DefaultTextSelectionColors;
            case 19:
                float f2 = AlertDialogKt.DialogMinWidth;
                return DefaultBasicAlertDialogOverride.INSTANCE;
            case 20:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal6 = AppBarKt.LocalSingleRowTopAppBarOverride;
                return DefaultSingleRowTopAppBarOverride.INSTANCE;
            case 21:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal7 = AppBarKt.LocalSingleRowTopAppBarOverride;
                return TextFieldDefaults.INSTANCE;
            case 22:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = ColorSchemeKt.LocalTonalElevationEnabled;
                return Boolean.TRUE;
            case 23:
                return Float.valueOf(1.0f);
            case 24:
                HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                return Boolean.TRUE;
            case 25:
                return new Dp(48);
            case 26:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt.LocalUsingExpressiveTheme;
                return Boolean.FALSE;
            case 27:
                return new MaterialTheme$Values(ColorSchemeKt.m245lightColorScheme_VG5OTI$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1), new Typography(null, null, null, null, null, null, null, null, null, 32767), new Shapes(), MotionScheme.StandardMotionSchemeImpl.INSTANCE);
            case 28:
                return UUID.randomUUID();
            default:
                int i = PrecisionPointer_androidKt.$r8$clinit;
                return Boolean.FALSE;
        }
    }
}
