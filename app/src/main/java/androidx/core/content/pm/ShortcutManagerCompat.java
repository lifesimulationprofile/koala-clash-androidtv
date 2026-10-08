package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import com.google.mlkit.vision.barcode.common.Barcode;
import io.github.g00fy2.quickie.content.CalendarDateTimeParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShortcutManagerCompat {
    public static volatile ArrayList sShortcutInfoChangeListeners;
    public static volatile ShortcutInfoCompatSaver$NoopImpl sShortcutInfoCompatSaver;

    public static List getShortcutInfoListeners(Context context) {
        Bundle bundle;
        String string;
        if (sShortcutInfoChangeListeners == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            intent.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString("androidx.core.content.pm.shortcut_listener_impl")) != null) {
                    try {
                        if (Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context) != null) {
                            throw new ClassCastException();
                        }
                        arrayList.add(null);
                    } catch (Exception unused) {
                        continue;
                    }
                }
            }
            if (sShortcutInfoChangeListeners == null) {
                sShortcutInfoChangeListeners = arrayList;
            }
        }
        return sShortcutInfoChangeListeners;
    }

    public static ShortcutInfoCompatSaver$NoopImpl getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver == null) {
            try {
                sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver$NoopImpl) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            } catch (Exception unused) {
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver$NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }

    public static void removeAllDynamicShortcuts(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0.m(context.getSystemService(ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0.m())).removeAllDynamicShortcuts();
        }
        getShortcutInfoSaverInstance(context).getClass();
        Iterator it = ((ArrayList) getShortcutInfoListeners(context)).iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public static final CalendarDateTimeParcelable toParcelableCalendarEvent(Barcode.CalendarDateTime calendarDateTime) {
        return new CalendarDateTimeParcelable(calendarDateTime != null ? calendarDateTime.zzc : -1, calendarDateTime != null ? calendarDateTime.zzd : -1, calendarDateTime != null ? calendarDateTime.zze : -1, calendarDateTime != null ? calendarDateTime.zzb : -1, calendarDateTime != null ? calendarDateTime.zzf : -1, calendarDateTime != null ? calendarDateTime.zza : -1, calendarDateTime != null ? calendarDateTime.zzg : false);
    }
}
