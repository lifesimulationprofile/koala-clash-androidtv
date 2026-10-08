package androidx.compose.ui.platform;

import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListInterface;
import androidx.core.os.LocaleListPlatformWrapper;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView$localeList$2 extends Lambda implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidComposeView$localeList$2(AndroidComposeView androidComposeView, int i) {
        super(0);
        this.$r8$classId = i;
        this.this$0 = androidComposeView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int actionMasked;
        int i = this.$r8$classId;
        AndroidComposeView androidComposeView = this.this$0;
        switch (i) {
            case 0:
                LocaleListCompat locales = ConfigurationCompat.getLocales(androidComposeView.getConfiguration());
                if (locales.mImpl.isEmpty()) {
                    locales = Build.VERSION.SDK_INT >= 24 ? new LocaleListCompat(new LocaleListPlatformWrapper(LocaleListCompat.Api24Impl.getDefault())) : LocaleListCompat.create(Locale.getDefault());
                }
                LocaleListInterface localeListInterface = locales.mImpl;
                int size = localeListInterface.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(new androidx.compose.ui.text.intl.Locale(localeListInterface.get(i2)));
                }
                return new LocaleList(arrayList);
            case 1:
                Boolean bool = (Boolean) androidComposeView.isAttached$delegate.getValue();
                bool.getClass();
                return bool;
            case 2:
                MotionEvent motionEvent = androidComposeView.previousMotionEvent;
                if (motionEvent != null && ((actionMasked = motionEvent.getActionMasked()) == 7 || actionMasked == 9)) {
                    androidComposeView.relayoutTime = SystemClock.uptimeMillis();
                    androidComposeView.post(androidComposeView.resendMotionEventRunnable);
                }
                return Unit.INSTANCE;
            default:
                androidComposeView.get_viewTreeOwners();
                return null;
        }
    }
}
