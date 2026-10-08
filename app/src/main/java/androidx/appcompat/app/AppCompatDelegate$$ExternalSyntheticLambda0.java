package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.app.NavUtils;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListPlatformWrapper;
import androidx.profileinstaller.Encoding;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegate$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ AppCompatDelegate$$ExternalSyntheticLambda0(Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008e  */
    @Override // java.lang.Runnable
    public final void run() {
        LocaleListCompat localeListCompat;
        Object systemService;
        Context context;
        switch (this.$r8$classId) {
            case 0:
                int i = Build.VERSION.SDK_INT;
                if (i >= 33) {
                    Context context2 = this.f$0;
                    ComponentName componentName = new ComponentName(context2, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context2.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (i >= 33) {
                            ArraySet arraySet = AppCompatDelegate.sActivityDelegates;
                            arraySet.getClass();
                            ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
                            while (true) {
                                if (keyIterator.hasNext()) {
                                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) keyIterator.next()).get();
                                    if (appCompatDelegate != null && (context = ((AppCompatDelegateImpl) appCompatDelegate).mContext) != null) {
                                        systemService = context.getSystemService("locale");
                                    }
                                } else {
                                    systemService = null;
                                }
                            }
                            if (systemService != null) {
                                localeListCompat = new LocaleListCompat(new LocaleListPlatformWrapper(AppCompatDelegate.Api33Impl.localeManagerGetApplicationLocales(systemService)));
                            } else {
                                localeListCompat = LocaleListCompat.sEmptyLocaleList;
                            }
                        } else {
                            localeListCompat = AppCompatDelegate.sRequestedAppLocales;
                            if (localeListCompat == null) {
                                localeListCompat = LocaleListCompat.sEmptyLocaleList;
                            }
                        }
                        if (localeListCompat.mImpl.isEmpty()) {
                            String locales = NavUtils.readLocales(context2);
                            Object systemService2 = context2.getSystemService("locale");
                            if (systemService2 != null) {
                                AppCompatDelegate.Api33Impl.localeManagerSetApplicationLocales(systemService2, AppCompatDelegate.Api24Impl.localeListForLanguageTags(locales));
                            }
                        }
                        context2.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    }
                }
                AppCompatDelegate.sIsFrameworkSyncChecked = true;
                break;
            case 1:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new AppCompatDelegate$$ExternalSyntheticLambda0(this.f$0, 2));
                break;
            default:
                Encoding.writeProfile(this.f$0, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), Encoding.EMPTY_DIAGNOSTICS, false);
                break;
        }
    }
}
