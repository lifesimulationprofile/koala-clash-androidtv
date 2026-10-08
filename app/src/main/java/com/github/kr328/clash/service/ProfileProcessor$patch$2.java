package com.github.kr328.clash.service;

import android.content.Context;
import android.util.Log;
import androidx.room.CoroutinesRoom;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.data.ImportedDao_Impl$4;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IFetchObserver;
import com.github.kr328.clash.service.util.BroadcastKt;
import com.github.kr328.clash.service.util.DatabaseKt;
import com.github.kr328.clash.service.util.FilesKt;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileProcessor$patch$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ IFetchObserver $callback;
    public Context $context;
    public final /* synthetic */ long $interval;
    public final /* synthetic */ String $name;
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ String $source;
    public Object $uuid;
    public long J$0;
    public Mutex L$0;
    public UUID L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public Object L$7;
    public MutexImpl L$8;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileProcessor$patch$2(String str, Profile.Type type, String str2, long j, Context context, IFetchObserver iFetchObserver, Continuation continuation) {
        super(2, continuation);
        this.$name = str;
        this.L$6 = type;
        this.$source = str2;
        this.$interval = j;
        this.L$7 = context;
        this.$callback = iFetchObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ProfileProcessor$patch$2((UUID) this.$uuid, this.$name, this.$source, this.$interval, this.$context, this.$callback, continuation);
            default:
                return new ProfileProcessor$patch$2(this.$name, (Profile.Type) this.L$6, this.$source, this.$interval, (Context) this.L$7, this.$callback, continuation);
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
        return ((ProfileProcessor$patch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0379 A[Catch: all -> 0x04e8, TRY_LEAVE, TryCatch #8 {all -> 0x04e8, blocks: (B:125:0x0374, B:127:0x0379, B:179:0x04eb, B:180:0x0501), top: B:197:0x0374 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:138:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:141:0x0412 A[Catch: all -> 0x0417, TryCatch #16 {all -> 0x0417, blocks: (B:139:0x03fd, B:141:0x0412, B:145:0x041b), top: B:207:0x03fd }] */
    /* JADX WARN: Code duplicated, block: B:148:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:172:0x04de A[Catch: all -> 0x02bd, TryCatch #18 {all -> 0x02bd, blocks: (B:101:0x02ab, B:107:0x02db, B:170:0x04d8, B:172:0x04de, B:173:0x04e0, B:174:0x04e3), top: B:187:0x025b }] */
    /* JADX WARN: Code duplicated, block: B:179:0x04eb A[Catch: all -> 0x04e8, TRY_ENTER, TryCatch #8 {all -> 0x04e8, blocks: (B:125:0x0374, B:127:0x0379, B:179:0x04eb, B:180:0x0501), top: B:197:0x0374 }] */
    /* JADX WARN: Code duplicated, block: B:215:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x014f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0151  */
    /* JADX WARN: Code duplicated, block: B:46:0x017b  */
    /* JADX WARN: Code duplicated, block: B:49:0x019a A[Catch: all -> 0x01a8, TryCatch #9 {all -> 0x01a8, blocks: (B:47:0x0181, B:49:0x019a, B:61:0x01b5, B:63:0x01b9, B:64:0x01c3), top: B:198:0x0181 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:52:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:54:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:55:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x01b5 A[Catch: all -> 0x01a8, TryCatch #9 {all -> 0x01a8, blocks: (B:47:0x0181, B:49:0x019a, B:61:0x01b5, B:63:0x01b9, B:64:0x01c3), top: B:198:0x0181 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x021f  */
    /* JADX WARN: Instruction removed from duplicated block: B:179:0x04eb, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v20, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v21, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r14v11, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r4v33, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ?? r14;
        Throwable th;
        UUID uuid;
        Mutex mutex;
        Context context;
        ?? r12;
        Object objQueryByUUID;
        ?? r15;
        String str;
        UUID uuid2;
        Context context2;
        ?? r13;
        Imported imported;
        File fileResolve;
        File file;
        Imported imported2;
        Imported imported3;
        Context context3;
        ?? r2;
        Object objAccess$resolve;
        Context context4;
        String str2;
        String str3;
        ?? r3;
        ProfileProcessor.ProfileMeta profileMeta;
        MutexImpl mutexImpl;
        ?? r21;
        ?? r4;
        long j;
        ?? r16;
        Imported imported4;
        Context context5;
        UUID uuid3;
        Mutex mutex2;
        byte[] bArr;
        byte[] bArr2;
        Dispatcher dispatcherImportedDao;
        Imported importedCopy$default;
        byte[] bArr3;
        ?? r6;
        Object objGenerateProfileUUID;
        UUID uuid4;
        IFetchObserver iFetchObserver;
        ?? r5;
        Context context6;
        File fileResolve2;
        Profile.Type type;
        Context context7;
        File file2;
        Object objAccess$resolve2;
        Context context8;
        Profile.Type type2;
        long j2;
        UUID uuid5;
        String str4;
        ?? r17;
        ?? r7;
        ProfileProcessor.ProfileMeta profileMeta2;
        MutexImpl mutexImpl2;
        ?? r20;
        Profile.Type type3;
        ?? r18;
        UUID uuid6;
        long millis;
        ProfileProcessor.ProfileMeta profileMeta3;
        ?? r8;
        Mutex mutex3;
        String str5;
        String str6;
        Dispatcher dispatcherImportedDao2;
        Imported imported5;
        Context context9;
        Context context10;
        UUID uuid7;
        Long l;
        Object obj2;
        ?? r9;
        int i = this.$r8$classId;
        IFetchObserver iFetchObserver2 = this.$callback;
        ?? r10 = "call to 'resume' before 'invoke' with coroutine";
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r11 = 3;
        String str7 = this.$name;
        ?? r19 = this.$source;
        long j3 = this.$interval;
        switch (i) {
            case 0:
                String str8 = "Profile patch: announce '";
                int i2 = this.label;
                try {
                    try {
                        try {
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj);
                                MutexImpl mutexImpl3 = ProfileProcessor.processLock;
                                uuid = (UUID) this.$uuid;
                                Context context11 = this.$context;
                                this.L$0 = mutexImpl3;
                                this.L$1 = uuid;
                                this.L$2 = str7;
                                this.L$3 = r19;
                                this.L$4 = context11;
                                this.L$5 = iFetchObserver2;
                                this.J$0 = j3;
                                this.label = 1;
                                if (mutexImpl3.lock(this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                mutex = mutexImpl3;
                                context = context11;
                                r12 = r19;
                            } else if (i2 == 1) {
                                j3 = this.J$0;
                                iFetchObserver2 = (IFetchObserver) this.L$5;
                                context = (Context) this.L$4;
                                String str9 = (String) this.L$3;
                                str7 = (String) this.L$2;
                                uuid = this.L$1;
                                mutex = this.L$0;
                                ResultKt.throwOnFailure(obj);
                                r12 = str9;
                            } else {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        if (i2 != 4) {
                                            if (i2 != 5) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            bArr3 = (byte[]) this.L$5;
                                            mutex2 = (Mutex) this.L$4;
                                            context5 = (Context) this.L$2;
                                            uuid3 = this.L$1;
                                            Mutex mutex4 = this.L$0;
                                            try {
                                                ResultKt.throwOnFailure(obj);
                                                mutex2 = mutex2;
                                                r6 = mutex4;
                                                FilesKt.writeProfileLogo(context5, uuid3, bArr3);
                                                BroadcastKt.sendProfileChanged(context5, uuid3);
                                                Unit unit = Unit.INSTANCE;
                                                ((MutexImpl) mutex2).unlock(null);
                                                ((MutexImpl) r6).unlock(null);
                                                return Unit.INSTANCE;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                ((MutexImpl) mutex2).unlock(null);
                                                throw th;
                                            }
                                        }
                                        long j4 = this.J$0;
                                        MutexImpl mutexImpl4 = this.L$8;
                                        ProfileProcessor.ProfileMeta profileMeta4 = (ProfileProcessor.ProfileMeta) this.L$7;
                                        Imported imported6 = (Imported) this.L$6;
                                        File file3 = (File) this.L$5;
                                        Context context12 = (Context) this.L$4;
                                        String str10 = (String) this.L$3;
                                        str2 = (String) this.L$2;
                                        UUID uuid8 = this.L$1;
                                        Mutex mutex5 = this.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        j = j4;
                                        mutex2 = mutexImpl4;
                                        r4 = file3;
                                        context5 = context12;
                                        r21 = str10;
                                        imported4 = imported6;
                                        str8 = "Profile patch: announce '";
                                        profileMeta = profileMeta4;
                                        uuid3 = uuid8;
                                        r16 = mutex5;
                                        String str11 = str2;
                                        try {
                                            ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
                                            ProfileProcessor.access$commitFiles(r4, kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context5), uuid3.toString()));
                                            bArr = profileMeta.profileImage;
                                            if (bArr == null) {
                                                bArr = imported4.profileImage;
                                            }
                                            bArr2 = bArr;
                                            Log.d("KoalaClash", str8 + imported4.announce + "' -> '" + profileMeta.announce + "', supportURL '" + imported4.supportURL + "' -> '" + profileMeta.supportURL + "'", null);
                                            dispatcherImportedDao = DaosKt.ImportedDao();
                                            importedCopy$default = Imported.copy$default(imported4, str11, r21, j, profileMeta.upload, profileMeta.download, profileMeta.total, profileMeta.expire, System.currentTimeMillis(), profileMeta.announce, profileMeta.supportURL, bArr2, profileMeta.modeSwitchAllowed, 517);
                                            this.L$0 = r16;
                                            this.L$1 = uuid3;
                                            this.L$2 = context5;
                                            this.L$3 = r4;
                                            this.L$4 = mutex2;
                                            this.L$5 = bArr2;
                                            this.L$6 = null;
                                            this.L$7 = null;
                                            this.L$8 = null;
                                            this.label = 5;
                                            if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao, importedCopy$default, 1), this) == coroutineSingletons) {
                                                return coroutineSingletons;
                                            }
                                            bArr3 = bArr2;
                                            r6 = r16;
                                            mutex2 = mutex2;
                                            FilesKt.writeProfileLogo(context5, uuid3, bArr3);
                                            BroadcastKt.sendProfileChanged(context5, uuid3);
                                            Unit unit2 = Unit.INSTANCE;
                                            ((MutexImpl) mutex2).unlock(null);
                                            ((MutexImpl) r6).unlock(null);
                                            return Unit.INSTANCE;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            ((MutexImpl) mutex2).unlock(null);
                                            throw th;
                                        }
                                    }
                                    long j5 = this.J$0;
                                    imported3 = (Imported) this.L$6;
                                    File file4 = (File) this.L$5;
                                    context4 = (Context) this.L$4;
                                    String str12 = (String) this.L$3;
                                    String str13 = (String) this.L$2;
                                    uuid2 = this.L$1;
                                    Mutex mutex6 = this.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        str2 = str13;
                                        r15 = mutex6;
                                        j3 = j5;
                                        r3 = str12;
                                        objAccess$resolve = obj;
                                        r11 = file4;
                                        try {
                                            try {
                                                profileMeta = (ProfileProcessor.ProfileMeta) objAccess$resolve;
                                                mutexImpl = ProfileProcessor.profileLock;
                                                this.L$0 = r15;
                                                this.L$1 = uuid2;
                                                this.L$2 = str2;
                                                this.L$3 = r3;
                                                this.L$4 = context4;
                                                this.L$5 = r11;
                                                this.L$6 = imported3;
                                                this.L$7 = profileMeta;
                                                this.L$8 = mutexImpl;
                                                this.J$0 = j3;
                                                this.label = 4;
                                                if (mutexImpl.lock(this) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                                r21 = r3;
                                                r4 = r11;
                                                j = j3;
                                                r16 = r15;
                                                imported4 = imported3;
                                                context5 = context4;
                                                uuid3 = uuid2;
                                                mutex2 = mutexImpl;
                                                String str14 = str2;
                                                ProfileProcessor profileProcessor2 = ProfileProcessor.INSTANCE;
                                                ProfileProcessor.access$commitFiles(r4, kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context5), uuid3.toString()));
                                                bArr = profileMeta.profileImage;
                                                if (bArr == null) {
                                                    bArr = imported4.profileImage;
                                                }
                                                bArr2 = bArr;
                                                Log.d("KoalaClash", str8 + imported4.announce + "' -> '" + profileMeta.announce + "', supportURL '" + imported4.supportURL + "' -> '" + profileMeta.supportURL + "'", null);
                                                dispatcherImportedDao = DaosKt.ImportedDao();
                                                importedCopy$default = Imported.copy$default(imported4, str14, r21, j, profileMeta.upload, profileMeta.download, profileMeta.total, profileMeta.expire, System.currentTimeMillis(), profileMeta.announce, profileMeta.supportURL, bArr2, profileMeta.modeSwitchAllowed, 517);
                                                this.L$0 = r16;
                                                this.L$1 = uuid3;
                                                this.L$2 = context5;
                                                this.L$3 = r4;
                                                this.L$4 = mutex2;
                                                this.L$5 = bArr2;
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.L$8 = null;
                                                this.label = 5;
                                                if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao, importedCopy$default, 1), this) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                                bArr3 = bArr2;
                                                r6 = r16;
                                                mutex2 = mutex2;
                                                FilesKt.writeProfileLogo(context5, uuid3, bArr3);
                                                BroadcastKt.sendProfileChanged(context5, uuid3);
                                                Unit unit3 = Unit.INSTANCE;
                                                ((MutexImpl) mutex2).unlock(null);
                                                ((MutexImpl) r6).unlock(null);
                                                return Unit.INSTANCE;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                r14 = r15;
                                                kotlin.io.FilesKt.deleteRecursively(r11);
                                                throw th;
                                            }
                                        } catch (HwidLimitException e) {
                                            e = e;
                                            str3 = e.supportURL;
                                            if (str3 == null) {
                                                str3 = imported3.supportURL;
                                            }
                                            throw new HwidLimitException(str3);
                                        }
                                    } catch (HwidLimitException e2) {
                                        e = e2;
                                        str3 = e.supportURL;
                                        if (str3 == null) {
                                            str3 = imported3.supportURL;
                                        }
                                        throw new HwidLimitException(str3);
                                    }
                                }
                                long j6 = this.J$0;
                                IFetchObserver iFetchObserver3 = (IFetchObserver) this.L$5;
                                context2 = (Context) this.L$4;
                                String str15 = (String) this.L$3;
                                String str16 = (String) this.L$2;
                                UUID uuid9 = this.L$1;
                                r14 = this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    str = str16;
                                    r15 = r14;
                                    r13 = str15;
                                    uuid2 = uuid9;
                                    j3 = j6;
                                    iFetchObserver2 = iFetchObserver3;
                                    objQueryByUUID = obj;
                                    try {
                                        imported = (Imported) objQueryByUUID;
                                        if (imported != null) {
                                            throw new IllegalArgumentException("profile " + uuid2 + " not found");
                                        }
                                        ProfileProcessor profileProcessor3 = ProfileProcessor.INSTANCE;
                                        ProfileProcessor.access$enforceFieldsValid(str, imported.type, r13, j3);
                                        fileResolve = kotlin.io.FilesKt.resolve(kotlin.io.FilesKt.resolve(context2.getFilesDir(), "processing"), uuid2.toString());
                                        kotlin.io.FilesKt.deleteRecursively(fileResolve);
                                        fileResolve.mkdirs();
                                        kotlin.io.FilesKt.copyRecursively$default(kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context2), uuid2.toString()), fileResolve, 4);
                                        try {
                                            Profile.Type type4 = imported.type;
                                            this.L$0 = r15;
                                            this.L$1 = uuid2;
                                            this.L$2 = str;
                                            this.L$3 = r13;
                                            this.L$4 = context2;
                                            this.L$5 = fileResolve;
                                            this.L$6 = imported;
                                            this.J$0 = j3;
                                            this.label = 3;
                                            context3 = context2;
                                            imported2 = imported;
                                            file = fileResolve;
                                            IFetchObserver iFetchObserver4 = iFetchObserver2;
                                            r2 = r13;
                                            try {
                                                objAccess$resolve = ProfileProcessor.access$resolve(context3, type4, r2, file, iFetchObserver4, this);
                                                if (objAccess$resolve == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                                context4 = context3;
                                                str2 = str;
                                                r11 = file;
                                                imported3 = imported2;
                                                r3 = r2;
                                                r15 = r15;
                                                profileMeta = (ProfileProcessor.ProfileMeta) objAccess$resolve;
                                                mutexImpl = ProfileProcessor.profileLock;
                                                this.L$0 = r15;
                                                this.L$1 = uuid2;
                                                this.L$2 = str2;
                                                this.L$3 = r3;
                                                this.L$4 = context4;
                                                this.L$5 = r11;
                                                this.L$6 = imported3;
                                                this.L$7 = profileMeta;
                                                this.L$8 = mutexImpl;
                                                this.J$0 = j3;
                                                this.label = 4;
                                                if (mutexImpl.lock(this) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                                r21 = r3;
                                                r4 = r11;
                                                j = j3;
                                                r16 = r15;
                                                imported4 = imported3;
                                                context5 = context4;
                                                uuid3 = uuid2;
                                                mutex2 = mutexImpl;
                                                String str17 = str2;
                                                ProfileProcessor profileProcessor4 = ProfileProcessor.INSTANCE;
                                                ProfileProcessor.access$commitFiles(r4, kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context5), uuid3.toString()));
                                                bArr = profileMeta.profileImage;
                                                if (bArr == null) {
                                                    bArr = imported4.profileImage;
                                                }
                                                bArr2 = bArr;
                                                Log.d("KoalaClash", str8 + imported4.announce + "' -> '" + profileMeta.announce + "', supportURL '" + imported4.supportURL + "' -> '" + profileMeta.supportURL + "'", null);
                                                dispatcherImportedDao = DaosKt.ImportedDao();
                                                importedCopy$default = Imported.copy$default(imported4, str17, r21, j, profileMeta.upload, profileMeta.download, profileMeta.total, profileMeta.expire, System.currentTimeMillis(), profileMeta.announce, profileMeta.supportURL, bArr2, profileMeta.modeSwitchAllowed, 517);
                                                this.L$0 = r16;
                                                this.L$1 = uuid3;
                                                this.L$2 = context5;
                                                this.L$3 = r4;
                                                this.L$4 = mutex2;
                                                this.L$5 = bArr2;
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.L$8 = null;
                                                this.label = 5;
                                                if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao, importedCopy$default, 1), this) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                                bArr3 = bArr2;
                                                r6 = r16;
                                                mutex2 = mutex2;
                                                FilesKt.writeProfileLogo(context5, uuid3, bArr3);
                                                BroadcastKt.sendProfileChanged(context5, uuid3);
                                                Unit unit4 = Unit.INSTANCE;
                                                ((MutexImpl) mutex2).unlock(null);
                                                ((MutexImpl) r6).unlock(null);
                                                return Unit.INSTANCE;
                                            } catch (HwidLimitException e3) {
                                                e = e3;
                                                imported3 = imported2;
                                                str3 = e.supportURL;
                                                if (str3 == null) {
                                                    str3 = imported3.supportURL;
                                                }
                                                throw new HwidLimitException(str3);
                                            } catch (Throwable th5) {
                                                th = th5;
                                                r11 = file;
                                                r14 = r15;
                                                kotlin.io.FilesKt.deleteRecursively(r11);
                                                throw th;
                                            }
                                        } catch (HwidLimitException e4) {
                                            e = e4;
                                            imported2 = imported;
                                            file = fileResolve;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            file = fileResolve;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        r14 = r15;
                                        ((MutexImpl) r14).unlock(null);
                                        throw th;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    ((MutexImpl) r14).unlock(null);
                                    throw th;
                                }
                            }
                            Dispatcher dispatcherImportedDao3 = DaosKt.ImportedDao();
                            this.L$0 = mutex;
                            this.L$1 = uuid;
                            this.L$2 = str7;
                            this.L$3 = r12;
                            this.L$4 = context;
                            this.L$5 = iFetchObserver2;
                            this.J$0 = j3;
                            this.label = 2;
                            objQueryByUUID = dispatcherImportedDao3.queryByUUID(uuid, this);
                            if (objQueryByUUID == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            r15 = mutex;
                            str = str7;
                            uuid2 = uuid;
                            context2 = context;
                            r13 = r12;
                            imported = (Imported) objQueryByUUID;
                            if (imported != null) {
                                throw new IllegalArgumentException("profile " + uuid2 + " not found");
                            }
                            ProfileProcessor profileProcessor5 = ProfileProcessor.INSTANCE;
                            ProfileProcessor.access$enforceFieldsValid(str, imported.type, r13, j3);
                            fileResolve = kotlin.io.FilesKt.resolve(kotlin.io.FilesKt.resolve(context2.getFilesDir(), "processing"), uuid2.toString());
                            kotlin.io.FilesKt.deleteRecursively(fileResolve);
                            fileResolve.mkdirs();
                            kotlin.io.FilesKt.copyRecursively$default(kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context2), uuid2.toString()), fileResolve, 4);
                            Profile.Type type5 = imported.type;
                            this.L$0 = r15;
                            this.L$1 = uuid2;
                            this.L$2 = str;
                            this.L$3 = r13;
                            this.L$4 = context2;
                            this.L$5 = fileResolve;
                            this.L$6 = imported;
                            this.J$0 = j3;
                            this.label = 3;
                            context3 = context2;
                            imported2 = imported;
                            file = fileResolve;
                            IFetchObserver iFetchObserver5 = iFetchObserver2;
                            r2 = r13;
                            objAccess$resolve = ProfileProcessor.access$resolve(context3, type5, r2, file, iFetchObserver5, this);
                            if (objAccess$resolve == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            context4 = context3;
                            str2 = str;
                            r11 = file;
                            imported3 = imported2;
                            r3 = r2;
                            r15 = r15;
                            profileMeta = (ProfileProcessor.ProfileMeta) objAccess$resolve;
                            mutexImpl = ProfileProcessor.profileLock;
                            this.L$0 = r15;
                            this.L$1 = uuid2;
                            this.L$2 = str2;
                            this.L$3 = r3;
                            this.L$4 = context4;
                            this.L$5 = r11;
                            this.L$6 = imported3;
                            this.L$7 = profileMeta;
                            this.L$8 = mutexImpl;
                            this.J$0 = j3;
                            this.label = 4;
                            if (mutexImpl.lock(this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            r21 = r3;
                            r4 = r11;
                            j = j3;
                            r16 = r15;
                            imported4 = imported3;
                            context5 = context4;
                            uuid3 = uuid2;
                            mutex2 = mutexImpl;
                            String str18 = str2;
                            ProfileProcessor profileProcessor6 = ProfileProcessor.INSTANCE;
                            ProfileProcessor.access$commitFiles(r4, kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context5), uuid3.toString()));
                            bArr = profileMeta.profileImage;
                            if (bArr == null) {
                                bArr = imported4.profileImage;
                            }
                            bArr2 = bArr;
                            Log.d("KoalaClash", str8 + imported4.announce + "' -> '" + profileMeta.announce + "', supportURL '" + imported4.supportURL + "' -> '" + profileMeta.supportURL + "'", null);
                            dispatcherImportedDao = DaosKt.ImportedDao();
                            importedCopy$default = Imported.copy$default(imported4, str18, r21, j, profileMeta.upload, profileMeta.download, profileMeta.total, profileMeta.expire, System.currentTimeMillis(), profileMeta.announce, profileMeta.supportURL, bArr2, profileMeta.modeSwitchAllowed, 517);
                            this.L$0 = r16;
                            this.L$1 = uuid3;
                            this.L$2 = context5;
                            this.L$3 = r4;
                            this.L$4 = mutex2;
                            this.L$5 = bArr2;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.label = 5;
                            if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao, importedCopy$default, 1), this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            bArr3 = bArr2;
                            r6 = r16;
                            mutex2 = mutex2;
                            FilesKt.writeProfileLogo(context5, uuid3, bArr3);
                            BroadcastKt.sendProfileChanged(context5, uuid3);
                            Unit unit5 = Unit.INSTANCE;
                            ((MutexImpl) mutex2).unlock(null);
                            ((MutexImpl) r6).unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th9) {
                            th = th9;
                            r14 = mutex;
                            ((MutexImpl) r14).unlock(null);
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        r11 = iFetchObserver2;
                        r14 = coroutineSingletons;
                    }
                } catch (Throwable th11) {
                    th = th11;
                }
                break;
            default:
                Profile.Type type6 = (Profile.Type) this.L$6;
                int i3 = this.label;
                try {
                    try {
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            ProfileProcessor profileProcessor7 = ProfileProcessor.INSTANCE;
                            ProfileProcessor.access$enforceFieldsValid(str7, type6, r19, j3);
                            this.label = 1;
                            objGenerateProfileUUID = DatabaseKt.generateProfileUUID(this);
                            if (objGenerateProfileUUID != coroutineSingletons) {
                            }
                            obj2 = coroutineSingletons;
                            return obj2;
                        }
                        if (i3 != 1) {
                            if (i3 == 2) {
                                j3 = this.J$0;
                                str7 = (String) this.L$5;
                                IFetchObserver iFetchObserver6 = (IFetchObserver) this.L$4;
                                String str19 = (String) this.L$3;
                                type6 = (Profile.Type) this.L$2;
                                context6 = this.$context;
                                Mutex mutex7 = this.L$0;
                                uuid4 = this.L$1;
                                ResultKt.throwOnFailure(obj);
                                iFetchObserver = iFetchObserver6;
                                r5 = str19;
                                r19 = mutex7;
                                try {
                                    fileResolve2 = kotlin.io.FilesKt.resolve(kotlin.io.FilesKt.resolve(context6.getFilesDir(), "processing"), uuid4.toString());
                                    kotlin.io.FilesKt.deleteRecursively(fileResolve2);
                                    fileResolve2.mkdirs();
                                    kotlin.io.FilesKt.resolve(fileResolve2, "config.yaml").createNewFile();
                                    kotlin.io.FilesKt.resolve(fileResolve2, "providers").mkdir();
                                    try {
                                        ProfileProcessor profileProcessor8 = ProfileProcessor.INSTANCE;
                                        this.L$1 = uuid4;
                                        this.L$0 = r19;
                                        this.$context = context6;
                                        this.L$2 = type6;
                                        this.L$3 = r5;
                                        this.L$4 = str7;
                                        this.L$5 = fileResolve2;
                                        this.J$0 = j3;
                                        this.label = 3;
                                        type = type6;
                                        context7 = context6;
                                        file2 = fileResolve2;
                                        objAccess$resolve2 = ProfileProcessor.access$resolve(context7, type, r5, file2, iFetchObserver, this);
                                        if (objAccess$resolve2 == coroutineSingletons) {
                                            obj2 = coroutineSingletons;
                                        } else {
                                            context8 = context7;
                                            String str20 = str7;
                                            type2 = type;
                                            j2 = j3;
                                            uuid5 = uuid4;
                                            str4 = str20;
                                            r7 = r5;
                                            r17 = r19;
                                            profileMeta2 = (ProfileProcessor.ProfileMeta) objAccess$resolve2;
                                            mutexImpl2 = ProfileProcessor.profileLock;
                                            this.L$1 = uuid5;
                                            this.L$0 = r17;
                                            this.$context = context8;
                                            this.L$2 = type2;
                                            this.L$3 = r7;
                                            this.L$4 = str4;
                                            this.L$5 = profileMeta2;
                                            this.$uuid = file2;
                                            this.L$8 = mutexImpl2;
                                            this.J$0 = j2;
                                            this.label = 4;
                                            obj2 = coroutineSingletons;
                                            if (mutexImpl2.lock(this) != coroutineSingletons) {
                                                r20 = r7;
                                                type3 = type2;
                                                r18 = r17;
                                                uuid6 = uuid5;
                                                millis = j2;
                                                profileMeta3 = profileMeta2;
                                                r8 = r18;
                                                ProfileProcessor profileProcessor9 = ProfileProcessor.INSTANCE;
                                                ProfileProcessor.access$commitFiles(file2, kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context8), uuid6.toString()));
                                                long jCurrentTimeMillis = System.currentTimeMillis();
                                                str5 = profileMeta3.title;
                                                if (str5 == null) {
                                                    str6 = str4;
                                                } else {
                                                    if (!StringsKt.isBlank(str5)) {
                                                        str5 = null;
                                                    }
                                                    if (str5 == null) {
                                                        str6 = str4;
                                                    } else {
                                                        str6 = str5;
                                                    }
                                                }
                                                if (millis == 0) {
                                                    millis = TimeUnit.SECONDS.toMillis(l.longValue());
                                                }
                                                long j7 = millis;
                                                dispatcherImportedDao2 = DaosKt.ImportedDao();
                                                context9 = context8;
                                                imported5 = new Imported(uuid6, str6, type3, r20, j7, profileMeta3.upload, profileMeta3.download, profileMeta3.total, profileMeta3.expire, jCurrentTimeMillis, jCurrentTimeMillis, profileMeta3.announce, profileMeta3.supportURL, profileMeta3.profileImage, profileMeta3.modeSwitchAllowed);
                                                this.L$1 = uuid6;
                                                this.L$0 = r8;
                                                this.$context = context9;
                                                this.L$2 = profileMeta3;
                                                this.L$3 = file2;
                                                this.L$4 = mutexImpl2;
                                                this.L$5 = null;
                                                this.$uuid = null;
                                                this.L$8 = null;
                                                this.label = 5;
                                                obj2 = coroutineSingletons;
                                                if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao2, imported5, 0), this) != coroutineSingletons) {
                                                    context10 = context9;
                                                    uuid7 = uuid6;
                                                    mutex3 = mutexImpl2;
                                                    r9 = r8;
                                                    FilesKt.writeProfileLogo(context10, uuid7, profileMeta3.profileImage);
                                                    BroadcastKt.sendProfileChanged(context10, uuid7);
                                                    Unit unit6 = Unit.INSTANCE;
                                                    ((MutexImpl) mutex3).unlock(null);
                                                    ((MutexImpl) r9).unlock(null);
                                                    obj2 = uuid7;
                                                }
                                            }
                                        }
                                        obj2 = coroutineSingletons;
                                        return obj2;
                                    } catch (Throwable th12) {
                                        th = th12;
                                        r10 = fileResolve2;
                                        kotlin.io.FilesKt.deleteRecursively(r10);
                                        throw th;
                                    }
                                } catch (Throwable th13) {
                                    ((MutexImpl) r19).unlock(null);
                                    throw th13;
                                }
                            }
                            if (i3 == 3) {
                                j2 = this.J$0;
                                file2 = (File) this.L$5;
                                String str21 = (String) this.L$4;
                                String str22 = (String) this.L$3;
                                Profile.Type type7 = (Profile.Type) this.L$2;
                                context8 = this.$context;
                                Mutex mutex8 = this.L$0;
                                UUID uuid10 = this.L$1;
                                ResultKt.throwOnFailure(obj);
                                uuid5 = uuid10;
                                type2 = type7;
                                str4 = str21;
                                r7 = str22;
                                objAccess$resolve2 = obj;
                                r17 = mutex8;
                                profileMeta2 = (ProfileProcessor.ProfileMeta) objAccess$resolve2;
                                mutexImpl2 = ProfileProcessor.profileLock;
                                this.L$1 = uuid5;
                                this.L$0 = r17;
                                this.$context = context8;
                                this.L$2 = type2;
                                this.L$3 = r7;
                                this.L$4 = str4;
                                this.L$5 = profileMeta2;
                                this.$uuid = file2;
                                this.L$8 = mutexImpl2;
                                this.J$0 = j2;
                                this.label = 4;
                                obj2 = coroutineSingletons;
                                if (mutexImpl2.lock(this) != coroutineSingletons) {
                                    r20 = r7;
                                    type3 = type2;
                                    r18 = r17;
                                    uuid6 = uuid5;
                                    millis = j2;
                                    profileMeta3 = profileMeta2;
                                    r8 = r18;
                                    ProfileProcessor profileProcessor10 = ProfileProcessor.INSTANCE;
                                    ProfileProcessor.access$commitFiles(file2, kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context8), uuid6.toString()));
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    str5 = profileMeta3.title;
                                    if (str5 == null) {
                                        str6 = str4;
                                    } else {
                                        if (!StringsKt.isBlank(str5)) {
                                            str5 = null;
                                        }
                                        if (str5 == null) {
                                            str6 = str4;
                                        } else {
                                            str6 = str5;
                                        }
                                    }
                                    if (millis == 0) {
                                        millis = TimeUnit.SECONDS.toMillis(l.longValue());
                                    }
                                    long j8 = millis;
                                    dispatcherImportedDao2 = DaosKt.ImportedDao();
                                    context9 = context8;
                                    imported5 = new Imported(uuid6, str6, type3, r20, j8, profileMeta3.upload, profileMeta3.download, profileMeta3.total, profileMeta3.expire, jCurrentTimeMillis2, jCurrentTimeMillis2, profileMeta3.announce, profileMeta3.supportURL, profileMeta3.profileImage, profileMeta3.modeSwitchAllowed);
                                    this.L$1 = uuid6;
                                    this.L$0 = r8;
                                    this.$context = context9;
                                    this.L$2 = profileMeta3;
                                    this.L$3 = file2;
                                    this.L$4 = mutexImpl2;
                                    this.L$5 = null;
                                    this.$uuid = null;
                                    this.L$8 = null;
                                    this.label = 5;
                                    obj2 = coroutineSingletons;
                                    if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao2, imported5, 0), this) != coroutineSingletons) {
                                        context10 = context9;
                                        uuid7 = uuid6;
                                        mutex3 = mutexImpl2;
                                        r9 = r8;
                                        FilesKt.writeProfileLogo(context10, uuid7, profileMeta3.profileImage);
                                        BroadcastKt.sendProfileChanged(context10, uuid7);
                                        Unit unit7 = Unit.INSTANCE;
                                        ((MutexImpl) mutex3).unlock(null);
                                        ((MutexImpl) r9).unlock(null);
                                        obj2 = uuid7;
                                    }
                                }
                                obj2 = coroutineSingletons;
                                return obj2;
                            }
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex3 = (Mutex) this.L$4;
                                profileMeta3 = (ProfileProcessor.ProfileMeta) this.L$2;
                                context10 = this.$context;
                                Mutex mutex9 = this.L$0;
                                UUID uuid11 = this.L$1;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    r9 = mutex9;
                                    uuid7 = uuid11;
                                    FilesKt.writeProfileLogo(context10, uuid7, profileMeta3.profileImage);
                                    BroadcastKt.sendProfileChanged(context10, uuid7);
                                    Unit unit8 = Unit.INSTANCE;
                                    ((MutexImpl) mutex3).unlock(null);
                                    ((MutexImpl) r9).unlock(null);
                                    obj2 = uuid7;
                                    obj2 = coroutineSingletons;
                                    return obj2;
                                } catch (Throwable th14) {
                                    th = th14;
                                    ((MutexImpl) mutex3).unlock(null);
                                    throw th;
                                }
                            }
                            j2 = this.J$0;
                            MutexImpl mutexImpl5 = this.L$8;
                            file2 = (File) this.$uuid;
                            profileMeta2 = (ProfileProcessor.ProfileMeta) this.L$5;
                            str4 = (String) this.L$4;
                            String str23 = (String) this.L$3;
                            Profile.Type type8 = (Profile.Type) this.L$2;
                            Context context13 = this.$context;
                            Mutex mutex10 = this.L$0;
                            uuid5 = this.L$1;
                            ResultKt.throwOnFailure(obj);
                            mutexImpl2 = mutexImpl5;
                            r20 = str23;
                            type3 = type8;
                            context8 = context13;
                            r18 = mutex10;
                            uuid6 = uuid5;
                            millis = j2;
                            profileMeta3 = profileMeta2;
                            r8 = r18;
                            try {
                                ProfileProcessor profileProcessor11 = ProfileProcessor.INSTANCE;
                                ProfileProcessor.access$commitFiles(file2, kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context8), uuid6.toString()));
                                long jCurrentTimeMillis3 = System.currentTimeMillis();
                                str5 = profileMeta3.title;
                                if (str5 == null) {
                                    str6 = str4;
                                } else {
                                    if (!StringsKt.isBlank(str5)) {
                                        str5 = null;
                                    }
                                    if (str5 == null) {
                                        str6 = str4;
                                    } else {
                                        str6 = str5;
                                    }
                                }
                                if (millis == 0 && (l = profileMeta3.intervalSeconds) != null) {
                                    millis = TimeUnit.SECONDS.toMillis(l.longValue());
                                }
                                long j9 = millis;
                                dispatcherImportedDao2 = DaosKt.ImportedDao();
                                context9 = context8;
                                imported5 = new Imported(uuid6, str6, type3, r20, j9, profileMeta3.upload, profileMeta3.download, profileMeta3.total, profileMeta3.expire, jCurrentTimeMillis3, jCurrentTimeMillis3, profileMeta3.announce, profileMeta3.supportURL, profileMeta3.profileImage, profileMeta3.modeSwitchAllowed);
                                this.L$1 = uuid6;
                                this.L$0 = r8;
                                this.$context = context9;
                                this.L$2 = profileMeta3;
                                this.L$3 = file2;
                                this.L$4 = mutexImpl2;
                                this.L$5 = null;
                                this.$uuid = null;
                                this.L$8 = null;
                                this.label = 5;
                                obj2 = coroutineSingletons;
                                if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao2, imported5, 0), this) != coroutineSingletons) {
                                    context10 = context9;
                                    uuid7 = uuid6;
                                    mutex3 = mutexImpl2;
                                    r9 = r8;
                                    FilesKt.writeProfileLogo(context10, uuid7, profileMeta3.profileImage);
                                    BroadcastKt.sendProfileChanged(context10, uuid7);
                                    Unit unit9 = Unit.INSTANCE;
                                    ((MutexImpl) mutex3).unlock(null);
                                    ((MutexImpl) r9).unlock(null);
                                    obj2 = uuid7;
                                }
                                obj2 = coroutineSingletons;
                                return obj2;
                            } catch (Throwable th15) {
                                th = th15;
                                mutex3 = mutexImpl2;
                                ((MutexImpl) mutex3).unlock(null);
                                throw th;
                            }
                        }
                        ResultKt.throwOnFailure(obj);
                        objGenerateProfileUUID = obj;
                        obj2 = coroutineSingletons;
                        uuid4 = (UUID) objGenerateProfileUUID;
                        MutexImpl mutexImpl6 = ProfileProcessor.processLock;
                        Context context14 = (Context) this.L$7;
                        this.L$1 = uuid4;
                        this.L$0 = mutexImpl6;
                        this.$context = context14;
                        this.L$2 = type6;
                        this.L$3 = r19;
                        this.L$4 = iFetchObserver2;
                        this.L$5 = str7;
                        this.J$0 = j3;
                        this.label = 2;
                        obj2 = coroutineSingletons;
                        if (mutexImpl6.lock(this) != coroutineSingletons) {
                            iFetchObserver = iFetchObserver2;
                            r5 = r19;
                            r19 = mutexImpl6;
                            context6 = context14;
                            fileResolve2 = kotlin.io.FilesKt.resolve(kotlin.io.FilesKt.resolve(context6.getFilesDir(), "processing"), uuid4.toString());
                            kotlin.io.FilesKt.deleteRecursively(fileResolve2);
                            fileResolve2.mkdirs();
                            kotlin.io.FilesKt.resolve(fileResolve2, "config.yaml").createNewFile();
                            kotlin.io.FilesKt.resolve(fileResolve2, "providers").mkdir();
                            ProfileProcessor profileProcessor12 = ProfileProcessor.INSTANCE;
                            this.L$1 = uuid4;
                            this.L$0 = r19;
                            this.$context = context6;
                            this.L$2 = type6;
                            this.L$3 = r5;
                            this.L$4 = str7;
                            this.L$5 = fileResolve2;
                            this.J$0 = j3;
                            this.label = 3;
                            type = type6;
                            context7 = context6;
                            file2 = fileResolve2;
                            objAccess$resolve2 = ProfileProcessor.access$resolve(context7, type, r5, file2, iFetchObserver, this);
                            if (objAccess$resolve2 == coroutineSingletons) {
                                obj2 = coroutineSingletons;
                            } else {
                                context8 = context7;
                                String str24 = str7;
                                type2 = type;
                                j2 = j3;
                                uuid5 = uuid4;
                                str4 = str24;
                                r7 = r5;
                                r17 = r19;
                                profileMeta2 = (ProfileProcessor.ProfileMeta) objAccess$resolve2;
                                mutexImpl2 = ProfileProcessor.profileLock;
                                this.L$1 = uuid5;
                                this.L$0 = r17;
                                this.$context = context8;
                                this.L$2 = type2;
                                this.L$3 = r7;
                                this.L$4 = str4;
                                this.L$5 = profileMeta2;
                                this.$uuid = file2;
                                this.L$8 = mutexImpl2;
                                this.J$0 = j2;
                                this.label = 4;
                                obj2 = coroutineSingletons;
                                if (mutexImpl2.lock(this) != coroutineSingletons) {
                                    r20 = r7;
                                    type3 = type2;
                                    r18 = r17;
                                    uuid6 = uuid5;
                                    millis = j2;
                                    profileMeta3 = profileMeta2;
                                    r8 = r18;
                                    ProfileProcessor profileProcessor13 = ProfileProcessor.INSTANCE;
                                    ProfileProcessor.access$commitFiles(file2, kotlin.io.FilesKt.resolve(FilesKt.getImportedDir(context8), uuid6.toString()));
                                    long jCurrentTimeMillis4 = System.currentTimeMillis();
                                    str5 = profileMeta3.title;
                                    if (str5 == null) {
                                        str6 = str4;
                                    } else {
                                        if (!StringsKt.isBlank(str5)) {
                                            str5 = null;
                                        }
                                        if (str5 == null) {
                                            str6 = str4;
                                        } else {
                                            str6 = str5;
                                        }
                                    }
                                    if (millis == 0) {
                                        millis = TimeUnit.SECONDS.toMillis(l.longValue());
                                    }
                                    long j10 = millis;
                                    dispatcherImportedDao2 = DaosKt.ImportedDao();
                                    context9 = context8;
                                    imported5 = new Imported(uuid6, str6, type3, r20, j10, profileMeta3.upload, profileMeta3.download, profileMeta3.total, profileMeta3.expire, jCurrentTimeMillis4, jCurrentTimeMillis4, profileMeta3.announce, profileMeta3.supportURL, profileMeta3.profileImage, profileMeta3.modeSwitchAllowed);
                                    this.L$1 = uuid6;
                                    this.L$0 = r8;
                                    this.$context = context9;
                                    this.L$2 = profileMeta3;
                                    this.L$3 = file2;
                                    this.L$4 = mutexImpl2;
                                    this.L$5 = null;
                                    this.$uuid = null;
                                    this.L$8 = null;
                                    this.label = 5;
                                    obj2 = coroutineSingletons;
                                    if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao2, imported5, 0), this) != coroutineSingletons) {
                                        context10 = context9;
                                        uuid7 = uuid6;
                                        mutex3 = mutexImpl2;
                                        r9 = r8;
                                        FilesKt.writeProfileLogo(context10, uuid7, profileMeta3.profileImage);
                                        BroadcastKt.sendProfileChanged(context10, uuid7);
                                        Unit unit10 = Unit.INSTANCE;
                                        ((MutexImpl) mutex3).unlock(null);
                                        ((MutexImpl) r9).unlock(null);
                                        obj2 = uuid7;
                                    }
                                }
                            }
                        }
                        obj2 = coroutineSingletons;
                        return obj2;
                    } catch (Throwable th16) {
                        th = th16;
                        r10 = iFetchObserver2;
                        r19 = 2;
                    }
                } catch (Throwable th17) {
                    th = th17;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileProcessor$patch$2(UUID uuid, String str, String str2, long j, Context context, IFetchObserver iFetchObserver, Continuation continuation) {
        super(2, continuation);
        this.$uuid = uuid;
        this.$name = str;
        this.$source = str2;
        this.$interval = j;
        this.$context = context;
        this.$callback = iFetchObserver;
    }
}
