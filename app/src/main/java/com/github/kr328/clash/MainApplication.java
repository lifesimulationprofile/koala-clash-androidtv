package com.github.kr328.clash;

import android.app.ActivityThread;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.compose.ui.window.Api33Impl;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.disk.DiskLruCache;
import coil.network.HttpException;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.design.compose.theme.ThemeState;
import com.github.kr328.clash.design.model.DarkMode;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.remote.Remote;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import com.github.kr328.clash.remote.Remote$launch$2;
import com.github.kr328.clash.service.util.BroadcastKt;
import com.github.kr328.clash.util.ApplicationObserver;
import com.google.android.gms.tasks.zzr;
import com.google.mlkit.common.sdkinternal.zzm;
import com.koala.clash.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MainApplication extends Application {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Object uiStore$delegate = LazyKt__LazyJVMKt.lazy(3, new BitmapFactoryDecoder$$ExternalSyntheticLambda2(9, this));

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static void applyDarkMode(DarkMode darkMode) {
            int i;
            ThemeState.state$delegate.setValue(darkMode);
            int iOrdinal = darkMode.ordinal();
            if (iOrdinal == 0) {
                i = -1;
            } else if (iOrdinal == 1) {
                i = 1;
            } else {
                if (iOrdinal != 2) {
                    throw new HttpException();
                }
                i = 2;
            }
            zzm zzmVar = AppCompatDelegate.sSerialExecutorForLocalesStorage;
            if (i != -1 && i != 0 && i != 1 && i != 2) {
                Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
                return;
            }
            if (AppCompatDelegate.sDefaultNightMode != i) {
                AppCompatDelegate.sDefaultNightMode = i;
                synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                    try {
                        ArraySet arraySet = AppCompatDelegate.sActivityDelegates;
                        arraySet.getClass();
                        ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
                        while (keyIterator.hasNext()) {
                            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) keyIterator.next()).get();
                            if (appCompatDelegate != null) {
                                ((AppCompatDelegateImpl) appCompatDelegate).applyApplicationSpecificConfig(true, true);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Global.INSTANCE.getClass();
        Global.application_ = this;
    }

    public final void finalize() {
        Global global = Global.INSTANCE;
        global.getClass();
        JobKt.cancel(global, (CancellationException) null);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, kotlin.Lazy] */
    @Override // android.app.Application
    public final void onCreate() throws IOException {
        String packageName;
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            packageName = Application.getProcessName();
        } else {
            try {
                packageName = ActivityThread.currentProcessName();
            } catch (Throwable th) {
                Log.w("KoalaClash", "Resolve process name: " + th, null);
                packageName = getPackageName();
            }
        }
        FilesKt.resolve(getFilesDir(), "clash").mkdirs();
        int i = 0;
        long j = getPackageManager().getPackageInfo(getPackageName(), 0).lastUpdateTime;
        File file = new File(FilesKt.resolve(getFilesDir(), "clash"), "geoip.metadb");
        if (file.exists() && file.lastModified() < j) {
            file.delete();
        }
        if (!file.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.copyTo$default(getAssets().open("geoip.metadb"), fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(fileOutputStream, th2);
                    throw th3;
                }
            }
        }
        File file2 = new File(FilesKt.resolve(getFilesDir(), "clash"), "geosite.dat");
        if (file2.exists() && file2.lastModified() < j) {
            file2.delete();
        }
        if (!file2.exists()) {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                ByteStreamsKt.copyTo$default(getAssets().open("geosite.dat"), fileOutputStream2);
                fileOutputStream2.close();
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.closeFinally(fileOutputStream2, th4);
                    throw th5;
                }
            }
        }
        File file3 = new File(FilesKt.resolve(getFilesDir(), "clash"), "ASN.mmdb");
        if (file3.exists() && file3.lastModified() < j) {
            file3.delete();
        }
        if (!file3.exists()) {
            FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
            try {
                ByteStreamsKt.copyTo$default(getAssets().open("ASN.mmdb"), fileOutputStream3);
                fileOutputStream3.close();
            } catch (Throwable th6) {
                try {
                    throw th6;
                } catch (Throwable th7) {
                    CloseableKt.closeFinally(fileOutputStream3, th6);
                    throw th7;
                }
            }
        }
        Log.d("KoalaClash", "Process " + packageName + " started", null);
        if (!packageName.equals(getPackageName())) {
            BroadcastKt.sendBroadcastSelf(this, new Intent(Intents.ACTION_SERVICE_RECREATED));
            return;
        }
        ?? r0 = this.uiStore$delegate;
        Dispatcher dispatcher = ((UiStore) r0.getValue()).darkMode$delegate;
        KProperty[] kPropertyArr = UiStore.$$delegatedProperties;
        KProperty kProperty = kPropertyArr[1];
        Companion.applyDarkMode((DarkMode) dispatcher.getValue());
        DiskLruCache.Editor editor = Remote.broadcasts;
        LinkedHashSet linkedHashSet = ApplicationObserver._createdActivities;
        Global global = Global.INSTANCE;
        global.getClass();
        Global.getApplication$1().registerActivityLifecycleCallbacks(ApplicationObserver.activityObserver);
        ApplicationObserver.visibleChanged = new Remote$$ExternalSyntheticLambda1(i);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        JobKt.launch$default(global, DefaultIoScheduler.INSTANCE, new Remote$launch$2(2, null, i), 2);
        zzr zzrVar = ((UiStore) r0.getValue()).hideAppIcon$delegate;
        KProperty kProperty2 = kPropertyArr[2];
        if (((Boolean) zzrVar.getValue()).booleanValue()) {
            ShortcutManagerCompat.removeAllDynamicShortcuts(this);
            return;
        }
        PorterDuff.Mode mode = IconCompat.DEFAULT_TINT_MODE;
        IconCompat iconCompatCreateWithResource = IconCompat.createWithResource(getResources(), getPackageName(), R.mipmap.ic_launcher);
        ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
        shortcutInfoCompat.mContext = this;
        shortcutInfoCompat.mId = "toggle_clash";
        shortcutInfoCompat.mLabel = getString(R.string.shortcut_toggle_short);
        shortcutInfoCompat.mLongLabel = getString(R.string.shortcut_toggle_long);
        shortcutInfoCompat.mIcon = iconCompatCreateWithResource;
        shortcutInfoCompat.mIntents = new Intent[]{new Intent(Intents.ACTION_TOGGLE_CLASH).setClassName(this, ExternalControlActivity.class.getName()).addFlags(276889600)};
        shortcutInfoCompat.mRank = 0;
        if (TextUtils.isEmpty(shortcutInfoCompat.mLabel)) {
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }
        Intent[] intentArr = shortcutInfoCompat.mIntents;
        if (intentArr == null || intentArr.length == 0) {
            throw new IllegalArgumentException("Shortcut must have an intent");
        }
        ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
        shortcutInfoCompat2.mContext = this;
        shortcutInfoCompat2.mId = "start_clash";
        shortcutInfoCompat2.mLabel = getString(R.string.shortcut_start_short);
        shortcutInfoCompat2.mLongLabel = getString(R.string.shortcut_start_long);
        shortcutInfoCompat2.mIcon = iconCompatCreateWithResource;
        shortcutInfoCompat2.mIntents = new Intent[]{new Intent(Intents.ACTION_START_CLASH).setClassName(this, ExternalControlActivity.class.getName()).addFlags(276889600)};
        shortcutInfoCompat2.mRank = 1;
        if (TextUtils.isEmpty(shortcutInfoCompat2.mLabel)) {
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }
        Intent[] intentArr2 = shortcutInfoCompat2.mIntents;
        if (intentArr2 == null || intentArr2.length == 0) {
            throw new IllegalArgumentException("Shortcut must have an intent");
        }
        ShortcutInfoCompat shortcutInfoCompat3 = new ShortcutInfoCompat();
        shortcutInfoCompat3.mContext = this;
        shortcutInfoCompat3.mId = "stop_clash";
        shortcutInfoCompat3.mLabel = getString(R.string.shortcut_stop_short);
        shortcutInfoCompat3.mLongLabel = getString(R.string.shortcut_stop_long);
        shortcutInfoCompat3.mIcon = iconCompatCreateWithResource;
        shortcutInfoCompat3.mIntents = new Intent[]{new Intent(Intents.ACTION_STOP_CLASH).setClassName(this, ExternalControlActivity.class.getName()).addFlags(276889600)};
        shortcutInfoCompat3.mRank = 2;
        if (TextUtils.isEmpty(shortcutInfoCompat3.mLabel)) {
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }
        Intent[] intentArr3 = shortcutInfoCompat3.mIntents;
        if (intentArr3 == null || intentArr3.length == 0) {
            throw new IllegalArgumentException("Shortcut must have an intent");
        }
        List<ShortcutInfoCompat> listListOf = AppCompatHintHelper.listOf(shortcutInfoCompat, shortcutInfoCompat2, shortcutInfoCompat3);
        if (Build.VERSION.SDK_INT <= 32) {
            ArrayList arrayList = new ArrayList(listListOf);
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                ((ShortcutInfoCompat) it.next()).getClass();
            }
            listListOf = arrayList;
        }
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList2 = new ArrayList(listListOf.size());
            for (ShortcutInfoCompat shortcutInfoCompat4 : listListOf) {
                shortcutInfoCompat4.getClass();
                ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0.m742m();
                ShortcutInfo.Builder intents = ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfoCompat4.mContext, shortcutInfoCompat4.mId).setShortLabel(shortcutInfoCompat4.mLabel).setIntents(shortcutInfoCompat4.mIntents);
                IconCompat iconCompat = shortcutInfoCompat4.mIcon;
                if (iconCompat != null) {
                    intents.setIcon(iconCompat.toIcon(shortcutInfoCompat4.mContext));
                }
                if (!TextUtils.isEmpty(shortcutInfoCompat4.mLongLabel)) {
                    intents.setLongLabel(shortcutInfoCompat4.mLongLabel);
                }
                if (!TextUtils.isEmpty(null)) {
                    intents.setDisabledMessage(null);
                }
                intents.setRank(shortcutInfoCompat4.mRank);
                PersistableBundle persistableBundle = shortcutInfoCompat4.mExtras;
                if (persistableBundle != null) {
                    intents.setExtras(persistableBundle);
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 29) {
                    intents.setLongLived(false);
                } else {
                    if (shortcutInfoCompat4.mExtras == null) {
                        shortcutInfoCompat4.mExtras = new PersistableBundle();
                    }
                    shortcutInfoCompat4.mExtras.putBoolean("extraLongLived", false);
                    intents.setExtras(shortcutInfoCompat4.mExtras);
                }
                if (i2 >= 33) {
                    Api33Impl.setExcludedFromSurfaces(intents);
                }
                arrayList2.add(intents.build());
            }
            if (!ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0.m(getSystemService(ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0.m())).setDynamicShortcuts(arrayList2)) {
                return;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(this).getClass();
        ShortcutManagerCompat.getShortcutInfoSaverInstance(this).getClass();
        Iterator it2 = ((ArrayList) ShortcutManagerCompat.getShortcutInfoListeners(this)).iterator();
        if (it2.hasNext()) {
            it2.next().getClass();
            throw new ClassCastException();
        }
    }
}
