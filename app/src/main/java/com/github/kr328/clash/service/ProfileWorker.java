package com.github.kr328.clash.service;

import android.app.NotificationChannel;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.compose.foundation.MutatorMutex$mutateWith$2;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.common.compat.ServicesKt;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.util.IntentKt;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.util.BroadcastKt;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import okhttp3.Dispatcher;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileWorker extends BaseService {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final ArrayList jobs = new ArrayList();

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileWorker$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public int label;
        public final /* synthetic */ ProfileWorker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(ProfileWorker profileWorker, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.this$0 = profileWorker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1(this.this$0, continuation, 0);
                default:
                    return new AnonymousClass1(this.this$0, continuation, 1);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Job job;
            int i = this.$r8$classId;
            ProfileWorker profileWorker = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (i) {
                case 0:
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        long millis = TimeUnit.SECONDS.toMillis(10L);
                        this.label = 1;
                        if (JobKt.delay(millis, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i2 != 1 && i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    do {
                        ArrayList arrayList = profileWorker.jobs;
                        job = (Job) (arrayList.isEmpty() ? null : arrayList.remove(0));
                        if (job == null) {
                            profileWorker.stopSelf();
                            return Unit.INSTANCE;
                        }
                        this.label = 2;
                    } while (job.join(this) != coroutineSingletons);
                    return coroutineSingletons;
                default:
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i3 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    AsyncTimeout.Companion companion = ProfileReceiver.Companion;
                    int i4 = ProfileWorker.$r8$clinit;
                    this.label = 1;
                    if (companion.rescheduleAll(profileWorker, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    long millis2 = TimeUnit.SECONDS.toMillis(30L);
                    this.label = 2;
                    if (JobKt.delay(millis2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x009e  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$run(ProfileWorker profileWorker, UUID uuid, ContinuationImpl continuationImpl) throws Throwable {
        ProfileWorker$run$1 profileWorker$run$1;
        ProfileWorker profileWorker2;
        Imported imported;
        String message;
        String message2;
        if (continuationImpl instanceof ProfileWorker$run$1) {
            profileWorker$run$1 = (ProfileWorker$run$1) continuationImpl;
            int i = profileWorker$run$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                profileWorker$run$1.label = i - Integer.MIN_VALUE;
            } else {
                profileWorker$run$1 = new ProfileWorker$run$1(profileWorker, continuationImpl);
            }
        } else {
            profileWorker$run$1 = new ProfileWorker$run$1(profileWorker, continuationImpl);
        }
        Object objQueryByUUID = profileWorker$run$1.result;
        int i2 = profileWorker$run$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objQueryByUUID);
            Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
            profileWorker$run$1.L$0 = profileWorker;
            profileWorker$run$1.label = 1;
            objQueryByUUID = dispatcherImportedDao.queryByUUID(uuid, profileWorker$run$1);
            if (objQueryByUUID != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            imported = profileWorker$run$1.L$1;
            profileWorker2 = profileWorker$run$1.L$0;
            try {
                ResultKt.throwOnFailure(objQueryByUUID);
                profileWorker2.completed(imported.uuid);
                AsyncTimeout.Companion companion = ProfileReceiver.Companion;
                AsyncTimeout.Companion.scheduleNext(profileWorker2, imported);
            } catch (HwidLimitException e) {
                e = e;
                message2 = e.getMessage();
                if (message2 == null) {
                    message2 = "HWID_LIMIT";
                }
                UUID uuid2 = imported.uuid;
                profileWorker2.getClass();
                BroadcastKt.sendBroadcastSelf(profileWorker2, new Intent(Intents.ACTION_PROFILE_UPDATE_FAILED).putExtra("uuid", uuid2.toString()).putExtra("fail_reason", message2));
            } catch (Exception e2) {
                e = e2;
                message = e.getMessage();
                if (message == null) {
                    message = "Unknown";
                }
                UUID uuid3 = imported.uuid;
                profileWorker2.getClass();
                BroadcastKt.sendBroadcastSelf(profileWorker2, new Intent(Intents.ACTION_PROFILE_UPDATE_FAILED).putExtra("uuid", uuid3.toString()).putExtra("fail_reason", message));
            }
            return Unit.INSTANCE;
        }
        profileWorker = profileWorker$run$1.L$0;
        ResultKt.throwOnFailure(objQueryByUUID);
        Imported imported2 = (Imported) objQueryByUUID;
        if (imported2 == null) {
            return Unit.INSTANCE;
        }
        try {
            ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
            UUID uuid4 = imported2.uuid;
            profileWorker$run$1.L$0 = profileWorker;
            profileWorker$run$1.L$1 = imported2;
            profileWorker$run$1.label = 2;
            Object objWithContext = JobKt.withContext(NonCancellable.INSTANCE, new MutatorMutex$mutateWith$2(profileWorker, uuid4, null), profileWorker$run$1);
            if (objWithContext != coroutineSingletons) {
                objWithContext = Unit.INSTANCE;
            }
            if (objWithContext != coroutineSingletons) {
                profileWorker2 = profileWorker;
                imported = imported2;
                profileWorker2.completed(imported.uuid);
                AsyncTimeout.Companion companion2 = ProfileReceiver.Companion;
                AsyncTimeout.Companion.scheduleNext(profileWorker2, imported);
                return Unit.INSTANCE;
            }
            return coroutineSingletons;
        } catch (HwidLimitException e3) {
            e = e3;
            profileWorker2 = profileWorker;
            imported = imported2;
            message2 = e.getMessage();
            if (message2 == null) {
                message2 = "HWID_LIMIT";
            }
            UUID uuid5 = imported.uuid;
            profileWorker2.getClass();
            BroadcastKt.sendBroadcastSelf(profileWorker2, new Intent(Intents.ACTION_PROFILE_UPDATE_FAILED).putExtra("uuid", uuid5.toString()).putExtra("fail_reason", message2));
        } catch (Exception e4) {
            e = e4;
            profileWorker2 = profileWorker;
            imported = imported2;
            message = e.getMessage();
            if (message == null) {
                message = "Unknown";
            }
            UUID uuid6 = imported.uuid;
            profileWorker2.getClass();
            BroadcastKt.sendBroadcastSelf(profileWorker2, new Intent(Intents.ACTION_PROFILE_UPDATE_FAILED).putExtra("uuid", uuid6.toString()).putExtra("fail_reason", message));
        }
    }

    public final void completed(UUID uuid) {
        BroadcastKt.sendBroadcastSelf(this, new Intent(Intents.ACTION_PROFILE_UPDATE_COMPLETED).putExtra("uuid", uuid.toString()));
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        NotificationChannel notificationChannel;
        super.onCreate();
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(this);
        NotificationChannelCompat notificationChannelCompat = new NotificationChannelCompat("profile_service_channel", 1);
        notificationChannelCompat.mName = getString(R.string.profile_service_status);
        List<NotificationChannelCompat> listSingletonList = Collections.singletonList(notificationChannelCompat);
        if (Build.VERSION.SDK_INT >= 26 && !listSingletonList.isEmpty()) {
            ArrayList arrayList = new ArrayList(listSingletonList.size());
            for (NotificationChannelCompat notificationChannelCompat2 : listSingletonList) {
                if (Build.VERSION.SDK_INT < 26) {
                    notificationChannelCompat2.getClass();
                    notificationChannel = null;
                } else {
                    String str = notificationChannelCompat2.mId;
                    NotificationChannel notificationChannelCreateNotificationChannel = NotificationChannelCompat.Api26Impl.createNotificationChannel(notificationChannelCompat2.mImportance, notificationChannelCompat2.mName, str);
                    NotificationChannelCompat.Api26Impl.setDescription(notificationChannelCreateNotificationChannel);
                    NotificationChannelCompat.Api26Impl.setGroup(notificationChannelCreateNotificationChannel);
                    NotificationChannelCompat.Api26Impl.setShowBadge(notificationChannelCreateNotificationChannel);
                    NotificationChannelCompat.Api26Impl.setSound(notificationChannelCreateNotificationChannel, notificationChannelCompat2.mSound, notificationChannelCompat2.mAudioAttributes);
                    NotificationChannelCompat.Api26Impl.enableLights(notificationChannelCreateNotificationChannel);
                    NotificationChannelCompat.Api26Impl.setLightColor(notificationChannelCreateNotificationChannel);
                    NotificationChannelCompat.Api26Impl.setVibrationPattern(notificationChannelCreateNotificationChannel);
                    NotificationChannelCompat.Api26Impl.enableVibration(notificationChannelCreateNotificationChannel);
                    notificationChannel = notificationChannelCreateNotificationChannel;
                }
                arrayList.add(notificationChannel);
            }
            NotificationChannelCompat.Api26Impl.createNotificationChannels(notificationManagerCompat.mNotificationManager, arrayList);
        }
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, "profile_service_channel");
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(getString(R.string.profile_updater));
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(getString(R.string.running));
        notificationCompat$Builder.mColor = getColor(R.color.color_clash);
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_logo_service;
        notificationCompat$Builder.setFlag(2);
        notificationCompat$Builder.setFlag(8);
        notificationCompat$Builder.mFgsDeferBehavior = 2;
        ServicesKt.startForegroundCompat(this, R.id.nf_profile_worker, notificationCompat$Builder.build());
        JobKt.launch$default(this, null, new AnonymousClass1(this, null, 0), 3);
    }

    @Override // com.github.kr328.clash.service.BaseService, android.app.Service
    public final void onDestroy() {
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Continuation continuation = null;
        String action = intent != null ? intent.getAction() : null;
        boolean zAreEqual = Intrinsics.areEqual(action, Intents.ACTION_PROFILE_REQUEST_UPDATE);
        ArrayList arrayList = this.jobs;
        if (!zAreEqual) {
            if (!Intrinsics.areEqual(action, Intents.ACTION_PROFILE_SCHEDULE_UPDATES)) {
                return 2;
            }
            arrayList.add(JobKt.launch$default(this, null, new AnonymousClass1(this, continuation, 1), 3));
            return 2;
        }
        UUID uuid = IntentKt.getUuid(intent);
        if (uuid == null) {
            return 2;
        }
        arrayList.add(JobKt.launch$default(this, null, new FilesActivity$showError$1(this, uuid, continuation, 13), 3));
        return 2;
    }
}
