package okio;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.CamcorderProfile;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.CamcorderProfileHelper;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.LinearGradient;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.PlatformTypefaces;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import com.github.kr328.clash.common.compat.IntentsKt;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.common.util.IntentKt;
import com.github.kr328.clash.service.ProfileReceiver;
import com.github.kr328.clash.service.ProfileReceiver$Companion$reset$1;
import com.github.kr328.clash.service.data.Imported;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.zze;
import com.google.android.gms.internal.mlkit_common.zzru;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import com.google.mlkit.vision.barcode.internal.zzi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class AsyncTimeout extends Timeout {
    public static final long IDLE_TIMEOUT_MILLIS;
    public static final long IDLE_TIMEOUT_NANOS;
    public static final Condition condition;
    public static AsyncTimeout head;
    public static final ReentrantLock lock;
    public AsyncTimeout next;
    public int state;
    public long timeoutAt;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Watchdog extends Thread {
        public final /* synthetic */ int $r8$classId = 0;

        public /* synthetic */ Watchdog(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    break;
                default:
                    Process.setThreadPriority(19);
                    synchronized (this) {
                        while (true) {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                                return;
                            }
                        }
                    }
                    break;
            }
            while (true) {
                try {
                    ReentrantLock reentrantLock = AsyncTimeout.lock;
                    ReentrantLock reentrantLock2 = AsyncTimeout.lock;
                    reentrantLock2.lock();
                    try {
                        AsyncTimeout asyncTimeoutAwaitTimeout = Companion.awaitTimeout();
                        if (asyncTimeoutAwaitTimeout == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                        Unit unit = Unit.INSTANCE;
                        reentrantLock2.unlock();
                        if (asyncTimeoutAwaitTimeout != null) {
                            asyncTimeoutAwaitTimeout.timedOut();
                        }
                    } finally {
                        reentrantLock2.unlock();
                    }
                } catch (InterruptedException unused2) {
                }
            }
        }

        public /* synthetic */ Watchdog(ThreadGroup threadGroup, String str) {
            super(threadGroup, str);
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        condition = reentrantLock.newCondition();
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void enter() {
        long j = this.timeoutNanos;
        boolean z = this.hasDeadline;
        if (j != 0 || z) {
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = 1;
                Companion.access$insertIntoQueue(this, j, z);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            int i = this.state;
            this.state = 0;
            if (i != 1) {
                boolean z = i == 2;
                reentrantLock.unlock();
                return z;
            }
            AsyncTimeout asyncTimeout = head;
            while (asyncTimeout != null) {
                AsyncTimeout asyncTimeout2 = asyncTimeout.next;
                if (asyncTimeout2 == this) {
                    asyncTimeout.next = this.next;
                    this.next = null;
                    reentrantLock.unlock();
                    return false;
                }
                asyncTimeout = asyncTimeout2;
            }
            throw new IllegalStateException("node was not found in the queue");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void timedOut() {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion implements CamcorderProfileHelper, Function, PlatformTypefaces, CreationExtras.Key, ProfileInstaller$DiagnosticsCallback, Clock, DynamiteModule.VersionPolicy, ComponentFactory {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ Companion(int i) {
            this.$r8$classId = i;
        }

        public static final void access$insertIntoQueue(AsyncTimeout asyncTimeout, long j, boolean z) {
            AsyncTimeout asyncTimeout2;
            ReentrantLock reentrantLock = AsyncTimeout.lock;
            if (AsyncTimeout.head == null) {
                AsyncTimeout.head = new AsyncTimeout();
                Watchdog watchdog = new Watchdog("Okio Watchdog");
                watchdog.setDaemon(true);
                watchdog.start();
            }
            long jNanoTime = System.nanoTime();
            if (j != 0 && z) {
                asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
            } else if (j != 0) {
                asyncTimeout.timeoutAt = j + jNanoTime;
            } else {
                if (!z) {
                    throw new AssertionError();
                }
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            }
            long j2 = asyncTimeout.timeoutAt - jNanoTime;
            AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
            while (true) {
                asyncTimeout2 = asyncTimeout3.next;
                if (asyncTimeout2 == null || j2 < asyncTimeout2.timeoutAt - jNanoTime) {
                    break;
                } else {
                    asyncTimeout3 = asyncTimeout2;
                }
            }
            asyncTimeout.next = asyncTimeout2;
            asyncTimeout3.next = asyncTimeout;
            if (asyncTimeout3 == AsyncTimeout.head) {
                AsyncTimeout.condition.signal();
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0015  */
        public static final Object access$reset(ContinuationImpl continuationImpl) {
            ProfileReceiver$Companion$reset$1 profileReceiver$Companion$reset$1;
            MutexImpl mutexImpl;
            Companion companion = ProfileReceiver.Companion;
            if (continuationImpl instanceof ProfileReceiver$Companion$reset$1) {
                profileReceiver$Companion$reset$1 = (ProfileReceiver$Companion$reset$1) continuationImpl;
                int i = profileReceiver$Companion$reset$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    profileReceiver$Companion$reset$1.label = i - Integer.MIN_VALUE;
                } else {
                    profileReceiver$Companion$reset$1 = new ProfileReceiver$Companion$reset$1(continuationImpl);
                }
            } else {
                profileReceiver$Companion$reset$1 = new ProfileReceiver$Companion$reset$1(continuationImpl);
            }
            Object obj = profileReceiver$Companion$reset$1.result;
            int i2 = profileReceiver$Companion$reset$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                MutexImpl mutexImpl2 = ProfileReceiver.lock;
                profileReceiver$Companion$reset$1.L$0 = mutexImpl2;
                profileReceiver$Companion$reset$1.label = 1;
                Object objLock = mutexImpl2.lock(profileReceiver$Companion$reset$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objLock == coroutineSingletons) {
                    return coroutineSingletons;
                }
                mutexImpl = mutexImpl2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutexImpl = profileReceiver$Companion$reset$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                ProfileReceiver.initialized = false;
                return Unit.INSTANCE;
            } finally {
                mutexImpl.unlock(null);
            }
        }

        public static AsyncTimeout awaitTimeout() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head.next;
            if (asyncTimeout == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.condition.await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                if (AsyncTimeout.head.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jNanoTime2 = asyncTimeout.timeoutAt - System.nanoTime();
            if (jNanoTime2 > 0) {
                AsyncTimeout.condition.await(jNanoTime2, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout.head.next = asyncTimeout.next;
            asyncTimeout.next = null;
            asyncTimeout.state = 2;
            return asyncTimeout;
        }

        /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
        public static Typeface m854createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
            if (i == 0 && Intrinsics.areEqual(fontWeight, FontWeight.Normal) && (str == null || str.length() == 0)) {
                return Typeface.DEFAULT;
            }
            return Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), fontWeight.weight, i == 1);
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static LinearGradient m855horizontalGradient8A3gB4$default(Pair[] pairArr) {
            Pair[] pairArr2 = (Pair[]) Arrays.copyOf(pairArr, pairArr.length);
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L);
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L);
            ArrayList arrayList = new ArrayList(pairArr2.length);
            for (Pair pair : pairArr2) {
                arrayList.add(new Color(((Color) pair.second).value));
            }
            ArrayList arrayList2 = new ArrayList(pairArr2.length);
            for (Pair pair2 : pairArr2) {
                arrayList2.add(Float.valueOf(((Number) pair2.first).floatValue()));
            }
            return new LinearGradient(arrayList, arrayList2, jFloatToRawIntBits, jFloatToRawIntBits2, 0);
        }

        public static PendingIntent pendingIntentOf(Context context, Imported imported) {
            Intent component = new Intent(Intents.ACTION_PROFILE_REQUEST_UPDATE).setComponent(ComponentsKt.getComponentName(Reflection.getOrCreateKotlinClass(ProfileReceiver.class)));
            IntentKt.setUUID(component, imported.uuid);
            return PendingIntent.getBroadcast(context, 0, component, IntentsKt.pendingIntentFlags$default());
        }

        public static void scheduleNext(Context context, Imported imported) {
            long j = imported.interval;
            PendingIntent pendingIntentPendingIntentOf = pendingIntentOf(context, imported);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            if (alarmManager != null) {
                alarmManager.cancel(pendingIntentPendingIntentOf);
            }
            if (j < TimeUnit.MINUTES.toMillis(15L)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLastModified = FilesKt.resolve(FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context), imported.uuid.toString()), "config.yaml").lastModified();
            if (jLastModified < 0) {
                return;
            }
            long j2 = j - (jCurrentTimeMillis - jLastModified);
            long j3 = j2 >= 0 ? j2 : 0L;
            AlarmManager alarmManager2 = (AlarmManager) context.getSystemService(AlarmManager.class);
            if (alarmManager2 != null) {
                alarmManager2.set(1, jCurrentTimeMillis + j3, pendingIntentPendingIntentOf);
            }
        }

        @Override // com.google.firebase.components.ComponentFactory
        public Object create(RestrictedComponentContainer restrictedComponentContainer) {
            switch (this.$r8$classId) {
                case 17:
                    return new MlKitThreadPool();
                case 18:
                    synchronized (UnsignedKt.class) {
                        byte b = (byte) (((byte) 1) | 2);
                        try {
                            if (b != 3) {
                                StringBuilder sb = new StringBuilder();
                                if ((b & 1) == 0) {
                                    sb.append(" enableFirelog");
                                }
                                if ((b & 2) == 0) {
                                    sb.append(" firelogEventType");
                                }
                                throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
                            }
                            UnsignedKt.zza(new zzru());
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return new zze(1);
                default:
                    return new zzi((MlKitContext) restrictedComponentContainer.get(MlKitContext.class));
            }
        }

        @Override // androidx.compose.ui.text.font.PlatformTypefaces
        /* JADX INFO: renamed from: createDefault-FO1MlWM */
        public Typeface mo657createDefaultFO1MlWM(FontWeight fontWeight, int i) {
            return m854createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
        }

        @Override // androidx.compose.ui.text.font.PlatformTypefaces
        /* JADX INFO: renamed from: createNamed-RetOiIg */
        public Typeface mo658createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
            return m854createAndroidTypefaceApi28RetOiIg(genericFontFamily.name, fontWeight, i);
        }

        @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
        public CamcorderProfile get(int i, int i2) {
            return CamcorderProfile.get(i, i2);
        }

        @Override // com.google.android.datatransport.runtime.time.Clock
        public long getTime() {
            return SystemClock.elapsedRealtime();
        }

        @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
        public boolean hasProfile(int i, int i2) {
            return CamcorderProfile.hasProfile(i, i2);
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onDiagnosticReceived() {
            Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onResultReceived(int i, Object obj) {
            String str;
            switch (i) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i == 6 || i == 7 || i == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00a5 A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:14:0x0034, B:44:0x00c3, B:39:0x009f, B:41:0x00a5, B:47:0x00cb, B:48:0x00d6, B:50:0x00dc, B:52:0x00e9, B:53:0x00ed, B:55:0x00f4, B:56:0x0102, B:46:0x00c7, B:21:0x0048, B:38:0x0092), top: B:62:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:47:0x00cb A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:14:0x0034, B:44:0x00c3, B:39:0x009f, B:41:0x00a5, B:47:0x00cb, B:48:0x00d6, B:50:0x00dc, B:52:0x00e9, B:53:0x00ed, B:55:0x00f4, B:56:0x0102, B:46:0x00c7, B:21:0x0048, B:38:0x0092), top: B:62:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x00dc A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:14:0x0034, B:44:0x00c3, B:39:0x009f, B:41:0x00a5, B:47:0x00cb, B:48:0x00d6, B:50:0x00dc, B:52:0x00e9, B:53:0x00ed, B:55:0x00f4, B:56:0x0102, B:46:0x00c7, B:21:0x0048, B:38:0x0092), top: B:62:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x00f4 A[Catch: all -> 0x0039, LOOP:1: B:54:0x00f2->B:55:0x00f4, LOOP_END, TryCatch #1 {all -> 0x0039, blocks: (B:14:0x0034, B:44:0x00c3, B:39:0x009f, B:41:0x00a5, B:47:0x00cb, B:48:0x00d6, B:50:0x00dc, B:52:0x00e9, B:53:0x00ed, B:55:0x00f4, B:56:0x0102, B:46:0x00c7, B:21:0x0048, B:38:0x0092), top: B:62:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x00e9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:67:0x00d6 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00c0, code lost:
        
            if (r11 == r6) goto L43;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v7, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00c0 -> B:44:0x00c3). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object rescheduleAll(android.content.Context r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Companion.rescheduleAll(android.content.Context, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
        public ViewUtils.RelativePadding selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
            ViewUtils.RelativePadding relativePadding = new ViewUtils.RelativePadding();
            int iZzb = iVersions.zzb(context, str, true);
            relativePadding.end = iZzb;
            if (iZzb != 0) {
                relativePadding.bottom = 1;
                return relativePadding;
            }
            int iZza = iVersions.zza(context, str);
            relativePadding.start = iZza;
            if (iZza != 0) {
                relativePadding.bottom = -1;
            }
            return relativePadding;
        }

        @Override // androidx.arch.core.util.Function
        public Object apply(Object obj) {
            return obj;
        }
    }
}
