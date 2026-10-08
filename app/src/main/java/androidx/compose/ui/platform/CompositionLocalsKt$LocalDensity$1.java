package androidx.compose.ui.platform;

import android.os.Looper;
import android.view.Choreographer;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.core.os.HandlerCompat;
import com.github.kr328.clash.UpdateChecker$check$2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionLocalsKt$LocalDensity$1 extends Lambda implements Function0 {
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$1;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$10;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$11;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$12;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$13;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$14;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$15;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$16;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$17;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$18;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$19;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$2;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$20;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$21;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$22;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$23;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$24;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$25;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$26;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$27;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$28;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$29;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$3;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$4;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$5;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$6;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$7;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$8;
    public static final CompositionLocalsKt$LocalDensity$1 INSTANCE$9;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 0;
        INSTANCE$1 = new CompositionLocalsKt$LocalDensity$1(i, 1);
        INSTANCE$2 = new CompositionLocalsKt$LocalDensity$1(i, 2);
        INSTANCE$3 = new CompositionLocalsKt$LocalDensity$1(i, 3);
        INSTANCE$4 = new CompositionLocalsKt$LocalDensity$1(i, 4);
        INSTANCE$5 = new CompositionLocalsKt$LocalDensity$1(i, 5);
        INSTANCE$6 = new CompositionLocalsKt$LocalDensity$1(i, 6);
        INSTANCE$7 = new CompositionLocalsKt$LocalDensity$1(i, 7);
        INSTANCE$8 = new CompositionLocalsKt$LocalDensity$1(i, 8);
        INSTANCE$9 = new CompositionLocalsKt$LocalDensity$1(i, 9);
        INSTANCE$10 = new CompositionLocalsKt$LocalDensity$1(i, 10);
        INSTANCE$11 = new CompositionLocalsKt$LocalDensity$1(i, 11);
        INSTANCE$12 = new CompositionLocalsKt$LocalDensity$1(i, 12);
        INSTANCE$13 = new CompositionLocalsKt$LocalDensity$1(i, 13);
        INSTANCE = new CompositionLocalsKt$LocalDensity$1(i, 0);
        INSTANCE$14 = new CompositionLocalsKt$LocalDensity$1(i, 14);
        INSTANCE$15 = new CompositionLocalsKt$LocalDensity$1(i, 15);
        INSTANCE$16 = new CompositionLocalsKt$LocalDensity$1(i, 16);
        INSTANCE$17 = new CompositionLocalsKt$LocalDensity$1(i, 17);
        INSTANCE$18 = new CompositionLocalsKt$LocalDensity$1(i, 18);
        INSTANCE$19 = new CompositionLocalsKt$LocalDensity$1(i, 19);
        INSTANCE$20 = new CompositionLocalsKt$LocalDensity$1(i, 20);
        INSTANCE$21 = new CompositionLocalsKt$LocalDensity$1(i, 21);
        INSTANCE$22 = new CompositionLocalsKt$LocalDensity$1(i, 22);
        INSTANCE$23 = new CompositionLocalsKt$LocalDensity$1(i, 23);
        INSTANCE$24 = new CompositionLocalsKt$LocalDensity$1(i, 24);
        INSTANCE$25 = new CompositionLocalsKt$LocalDensity$1(i, 25);
        INSTANCE$26 = new CompositionLocalsKt$LocalDensity$1(i, 26);
        INSTANCE$27 = new CompositionLocalsKt$LocalDensity$1(i, 27);
        INSTANCE$28 = new CompositionLocalsKt$LocalDensity$1(i, 28);
        INSTANCE$29 = new CompositionLocalsKt$LocalDensity$1(i, 29);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompositionLocalsKt$LocalDensity$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Choreographer choreographer;
        Continuation continuation = null;
        switch (this.$r8$classId) {
            case 0:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalDensity");
                throw null;
            case 1:
                AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalConfiguration");
                throw null;
            case 2:
                AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalContext");
                throw null;
            case 3:
                AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalImageVectorCache");
                throw null;
            case 4:
                AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalResourceIdCache");
                throw null;
            case 5:
                AndroidCompositionLocals_androidKt.access$noLocalProvidedFor("LocalView");
                throw null;
            case 6:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    choreographer = Choreographer.getInstance();
                } else {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    int i = 2;
                    choreographer = (Choreographer) JobKt.runBlocking(MainDispatcherLoader.dispatcher, new UpdateChecker$check$2(i, continuation, i));
                }
                AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, HandlerCompat.createAsync(Looper.getMainLooper()));
                return CameraIdUtil.plus(androidUiDispatcher, androidUiDispatcher.frameClock);
            case 7:
            case 8:
                return null;
            case 9:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalAutofillManager");
                throw null;
            case 10:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalAutofillTree");
                throw null;
            case 11:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalClipboard");
                throw null;
            case 12:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalClipboardManager");
                throw null;
            case 13:
                return Boolean.TRUE;
            case 14:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalFocusManager");
                throw null;
            case 15:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalFontFamilyResolver");
                throw null;
            case 16:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalFontLoader");
                throw null;
            case 17:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalGraphicsContext");
                throw null;
            case 18:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalHapticFeedback");
                throw null;
            case 19:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalInputManager");
                throw null;
            case 20:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalLayoutDirection");
                throw null;
            case 21:
                return null;
            case 22:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalProvidableLocaleList");
                throw null;
            case 23:
                return Boolean.FALSE;
            case 24:
            case 25:
                return null;
            case 26:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalTextToolbar");
                throw null;
            case 27:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalUriHandler");
                throw null;
            case 28:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalViewConfiguration");
                throw null;
            default:
                CompositionLocalsKt.access$noLocalProvidedFor("LocalWindowInfo");
                throw null;
        }
    }
}
