package androidx.core.app;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.os.HandlerCompat;
import com.koala.clash.R;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$Action {
    public final PendingIntent actionIntent;
    public final int icon;
    public final boolean mAllowGeneratedReplies;
    public final Bundle mExtras;
    public IconCompat mIcon;
    public final boolean mShowsUserInterface;
    public final CharSequence title;

    public NotificationCompat$Action(String str, PendingIntent pendingIntent) {
        IconCompat iconCompatCreateWithResource = IconCompat.createWithResource(null, "", R.drawable.common_full_open_on_phone);
        Bundle bundle = new Bundle();
        this.mShowsUserInterface = true;
        this.mIcon = iconCompatCreateWithResource;
        int iIntValue = iconCompatCreateWithResource.mType;
        if (iIntValue == -1) {
            int i = Build.VERSION.SDK_INT;
            Object obj = iconCompatCreateWithResource.mObj1;
            if (i >= 28) {
                iIntValue = HandlerCompat.Api28Impl.getType(obj);
            } else {
                try {
                    iIntValue = ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
                } catch (IllegalAccessException e) {
                    Log.e("IconCompat", "Unable to get icon type " + obj, e);
                    iIntValue = -1;
                } catch (NoSuchMethodException e2) {
                    Log.e("IconCompat", "Unable to get icon type " + obj, e2);
                    iIntValue = -1;
                } catch (InvocationTargetException e3) {
                    Log.e("IconCompat", "Unable to get icon type " + obj, e3);
                    iIntValue = -1;
                }
            }
        }
        if (iIntValue == 2) {
            this.icon = iconCompatCreateWithResource.getResId();
        }
        this.title = NotificationCompat$Builder.limitCharSequenceLength(str);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle;
        this.mAllowGeneratedReplies = true;
        this.mShowsUserInterface = true;
    }
}
