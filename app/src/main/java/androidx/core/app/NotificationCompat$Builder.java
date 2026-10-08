package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$Builder {
    public final boolean mAllowSystemGeneratedContextualActions;
    public String mChannelId;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public final Context mContext;
    public Bundle mExtras;
    public final Notification mNotification;
    public final ArrayList mPeople;
    public int mPriority;
    public RequestService mStyle;
    public CharSequence mSubText;
    public final ArrayList mActions = new ArrayList();
    public final ArrayList mPersonList = new ArrayList();
    public final ArrayList mInvisibleActions = new ArrayList();
    public boolean mShowWhen = true;
    public boolean mLocalOnly = false;
    public int mColor = 0;
    public int mFgsDeferBehavior = 0;

    public NotificationCompat$Builder(Context context, String str) {
        Notification notification = new Notification();
        this.mNotification = notification;
        this.mContext = context;
        this.mChannelId = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList();
        this.mAllowSystemGeneratedContextualActions = true;
    }

    public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.content.res.Resources, com.github.kr328.clash.MainApplication] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Notification build() {
        ArrayList arrayList;
        Notification notificationBuild;
        Bundle bundle;
        int i;
        int i2;
        ArrayList arrayList2;
        int i3;
        new ArrayList();
        Bundle bundle2 = new Bundle();
        int i4 = Build.VERSION.SDK_INT;
        Context context = this.mContext;
        Notification.Builder builderCreateBuilder = i4 >= 26 ? NotificationChannelCompat.Api26Impl.createBuilder(context, this.mChannelId) : new Notification.Builder(context);
        Notification notification = this.mNotification;
        ?? r7 = 0;
        builderCreateBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(this.mContentTitle).setContentText(this.mContentText).setContentInfo(null).setContentIntent(this.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        builderCreateBuilder.setLargeIcon((Icon) null);
        builderCreateBuilder.setSubText(this.mSubText).setUsesChronometer(false).setPriority(this.mPriority);
        ArrayList arrayList3 = this.mActions;
        int size = arrayList3.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList3.get(i5);
            i5++;
            NotificationCompat$Action notificationCompat$Action = (NotificationCompat$Action) obj;
            int i6 = Build.VERSION.SDK_INT;
            if (notificationCompat$Action.mIcon == null && (i3 = notificationCompat$Action.icon) != 0) {
                notificationCompat$Action.mIcon = IconCompat.createWithResource(r7, "", i3);
            }
            IconCompat iconCompat = notificationCompat$Action.mIcon;
            boolean z = notificationCompat$Action.mAllowGeneratedReplies;
            Bundle bundle3 = notificationCompat$Action.mExtras;
            Notification.Action.Builder builder = new Notification.Action.Builder(iconCompat != 0 ? iconCompat.toIcon(r7) : r7, notificationCompat$Action.title, notificationCompat$Action.actionIntent);
            Bundle bundle4 = bundle3 != null ? new Bundle(bundle3) : new Bundle();
            bundle4.putBoolean("android.support.allowGeneratedReplies", z);
            if (i6 >= 24) {
                NotificationCompatBuilder$Api24Impl.setAllowGeneratedReplies(builder, z);
            }
            bundle4.putInt("android.support.action.semanticAction", 0);
            if (i6 >= 28) {
                NotificationCompatBuilder$Api28Impl.setSemanticAction(builder);
            }
            if (i6 >= 29) {
                AppOpsManagerCompat$Api29Impl.setContextual(builder);
            }
            if (i6 >= 31) {
                NotificationCompatBuilder$Api31Impl.setAuthenticationRequired(builder);
            }
            bundle4.putBoolean("android.support.action.showsUserInterface", notificationCompat$Action.mShowsUserInterface);
            builder.addExtras(bundle4);
            builderCreateBuilder.addAction(builder.build());
            r7 = 0;
        }
        Bundle bundle5 = this.mExtras;
        if (bundle5 != null) {
            bundle2.putAll(bundle5);
        }
        int i7 = Build.VERSION.SDK_INT;
        builderCreateBuilder.setShowWhen(this.mShowWhen);
        builderCreateBuilder.setLocalOnly(this.mLocalOnly);
        builderCreateBuilder.setGroup(null);
        builderCreateBuilder.setSortKey(null);
        builderCreateBuilder.setGroupSummary(false);
        builderCreateBuilder.setCategory(null);
        builderCreateBuilder.setColor(this.mColor);
        builderCreateBuilder.setVisibility(0);
        builderCreateBuilder.setPublicVersion(null);
        builderCreateBuilder.setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList4 = this.mPeople;
        ArrayList arrayList5 = this.mPersonList;
        if (i7 < 28) {
            if (arrayList5 == null) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(arrayList5.size());
                Iterator it = arrayList5.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
            }
            if (arrayList2 != null) {
                if (arrayList4 == null) {
                    arrayList4 = arrayList2;
                } else {
                    ArraySet arraySet = new ArraySet(arrayList4.size() + arrayList2.size());
                    arraySet.addAll(arrayList2);
                    arraySet.addAll(arrayList4);
                    arrayList4 = new ArrayList(arraySet);
                }
            }
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            int size2 = arrayList4.size();
            int i8 = 0;
            while (i8 < size2) {
                Object obj2 = arrayList4.get(i8);
                i8++;
                builderCreateBuilder.addPerson((String) obj2);
            }
        }
        ArrayList arrayList6 = this.mInvisibleActions;
        if (arrayList6.size() > 0) {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            Bundle bundle6 = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (bundle6 == null) {
                bundle6 = new Bundle();
            }
            Bundle bundle7 = new Bundle(bundle6);
            Bundle bundle8 = new Bundle();
            int i9 = 0;
            while (i9 < arrayList6.size()) {
                String string = Integer.toString(i9);
                NotificationCompat$Action notificationCompat$Action2 = (NotificationCompat$Action) arrayList6.get(i9);
                Bundle bundle9 = new Bundle();
                if (notificationCompat$Action2.mIcon == null && (i2 = notificationCompat$Action2.icon) != 0) {
                    notificationCompat$Action2.mIcon = IconCompat.createWithResource(null, "", i2);
                }
                IconCompat iconCompat2 = notificationCompat$Action2.mIcon;
                Bundle bundle10 = notificationCompat$Action2.mExtras;
                ArrayList arrayList7 = arrayList5;
                bundle9.putInt("icon", iconCompat2 != null ? iconCompat2.getResId() : 0);
                bundle9.putCharSequence("title", notificationCompat$Action2.title);
                bundle9.putParcelable("actionIntent", notificationCompat$Action2.actionIntent);
                Bundle bundle11 = bundle10 != null ? new Bundle(bundle10) : new Bundle();
                bundle11.putBoolean("android.support.allowGeneratedReplies", notificationCompat$Action2.mAllowGeneratedReplies);
                bundle9.putBundle("extras", bundle11);
                bundle9.putParcelableArray("remoteInputs", null);
                bundle9.putBoolean("showsUserInterface", notificationCompat$Action2.mShowsUserInterface);
                bundle9.putInt("semanticAction", 0);
                bundle8.putBundle(string, bundle9);
                i9++;
                arrayList6 = arrayList6;
                arrayList5 = arrayList7;
            }
            arrayList = arrayList5;
            bundle6.putBundle("invisible_actions", bundle8);
            bundle7.putBundle("invisible_actions", bundle8);
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle6);
            bundle2.putBundle("android.car.EXTENSIONS", bundle7);
        } else {
            arrayList = arrayList5;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            builderCreateBuilder.setExtras(this.mExtras);
            NotificationCompatBuilder$Api24Impl.setRemoteInputHistory(builderCreateBuilder);
        }
        if (i10 >= 26) {
            NotificationChannelCompat.Api26Impl.setBadgeIconType(builderCreateBuilder);
            NotificationChannelCompat.Api26Impl.setSettingsText(builderCreateBuilder);
            NotificationChannelCompat.Api26Impl.setShortcutId(builderCreateBuilder);
            NotificationChannelCompat.Api26Impl.setTimeoutAfter(builderCreateBuilder);
            NotificationChannelCompat.Api26Impl.setGroupAlertBehavior(builderCreateBuilder);
            if (!TextUtils.isEmpty(this.mChannelId)) {
                builderCreateBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i10 >= 28) {
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                it2.next().getClass();
                throw new ClassCastException();
            }
        }
        if (i10 >= 29) {
            AppOpsManagerCompat$Api29Impl.setAllowSystemGeneratedContextualActions(builderCreateBuilder, this.mAllowSystemGeneratedContextualActions);
            AppOpsManagerCompat$Api29Impl.setBubbleMetadata(builderCreateBuilder);
        }
        if (i10 >= 31 && (i = this.mFgsDeferBehavior) != 0) {
            NotificationCompatBuilder$Api31Impl.setForegroundServiceBehavior(builderCreateBuilder, i);
        }
        RequestService requestService = this.mStyle;
        if (requestService != null) {
            new Notification.BigTextStyle(builderCreateBuilder).setBigContentTitle(null).bigText((CharSequence) requestService.hardwareBitmapService);
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26 && i11 < 24) {
            builderCreateBuilder.setExtras(bundle2);
            notificationBuild = builderCreateBuilder.build();
        } else {
            notificationBuild = builderCreateBuilder.build();
        }
        if (requestService != null) {
            this.mStyle.getClass();
        }
        if (requestService != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        return notificationBuild;
    }

    public final void setFlag(int i) {
        Notification notification = this.mNotification;
        notification.flags = i | notification.flags;
    }

    public final void setStyle(RequestService requestService) {
        if (this.mStyle != requestService) {
            this.mStyle = requestService;
            if (((NotificationCompat$Builder) requestService.systemCallbacks) != this) {
                requestService.systemCallbacks = this;
                setStyle(requestService);
            }
        }
    }
}
