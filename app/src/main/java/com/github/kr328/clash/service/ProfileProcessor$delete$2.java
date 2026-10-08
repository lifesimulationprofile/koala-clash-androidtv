package com.github.kr328.clash.service;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.CoroutinesRoom;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.store.ServiceStore;
import com.github.kr328.clash.service.util.BroadcastKt;
import com.google.mlkit.vision.common.internal.zza;
import java.util.List;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileProcessor$delete$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ UUID $uuid;
    public Mutex L$0;
    public Context L$1;
    public UUID L$2;
    public ServiceStore L$3;
    public boolean Z$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileProcessor$delete$2(Context context, UUID uuid, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$uuid = uuid;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProfileProcessor$delete$2(this.$context, this.$uuid, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ProfileProcessor$delete$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b4 A[Catch: all -> 0x0103, TRY_LEAVE, TryCatch #0 {all -> 0x0103, blocks: (B:37:0x0107, B:27:0x008e, B:29:0x00b4, B:23:0x005e), top: B:42:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MutexImpl mutexImpl;
        Context context;
        UUID uuid;
        Mutex mutex;
        UUID uuid2;
        ServiceStore serviceStore;
        boolean z;
        Mutex mutex2;
        Object objQueryAllUUIDs;
        UUID uuid3;
        Mutex mutex3;
        ServiceStore serviceStore2;
        Context context2;
        int i = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutexImpl = ProfileProcessor.profileLock;
                this.L$0 = mutexImpl;
                context = this.$context;
                this.L$1 = context;
                uuid = this.$uuid;
                this.L$2 = uuid;
                this.label = 1;
                if (mutexImpl.lock(this) != coroutineSingletons) {
                }
                mutex = mutexImpl;
                return coroutineSingletons;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    serviceStore2 = this.L$3;
                    uuid3 = this.L$2;
                    context2 = this.L$1;
                    mutex3 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        mutex3 = mutex3;
                        UUID uuid4 = (UUID) CollectionsKt.firstOrNull((List) obj);
                        ImageLoader$Builder imageLoader$Builder = serviceStore2.activeProfile$delegate;
                        KProperty kProperty = ServiceStore.$$delegatedProperties[0];
                        MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                        String str = (String) ((Remote$$ExternalSyntheticLambda1) imageLoader$Builder.defaults).invoke(uuid4);
                        SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                        editorEdit.putString("active_profile", str);
                        editorEdit.apply();
                        context = context2;
                        mutex = mutex3;
                        uuid2 = uuid3;
                        BroadcastKt.sendProfileChanged(context, uuid2);
                        Unit unit = Unit.INSTANCE;
                        ((MutexImpl) mutex).unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        ((MutexImpl) mutex3).unlock(null);
                        throw th;
                    }
                }
                z = this.Z$0;
                serviceStore = this.L$3;
                uuid2 = this.L$2;
                context = this.L$1;
                Mutex mutex4 = this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2 = mutex4;
                    FilesKt.deleteRecursively(FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context), uuid2.toString()));
                    FilesKt.deleteRecursively(FilesKt.resolve(FilesKt.resolve(context.getFilesDir(), "processing"), uuid2.toString()));
                    mutex = mutex2;
                    if (z) {
                        Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
                        this.L$0 = mutex2;
                        this.L$1 = context;
                        this.L$2 = uuid2;
                        this.L$3 = serviceStore;
                        this.label = 3;
                        objQueryAllUUIDs = dispatcherImportedDao.queryAllUUIDs(this);
                        if (objQueryAllUUIDs != coroutineSingletons) {
                            uuid3 = uuid2;
                            mutex3 = mutex2;
                            obj = objQueryAllUUIDs;
                            serviceStore2 = serviceStore;
                            context2 = context;
                            UUID uuid5 = (UUID) CollectionsKt.firstOrNull((List) obj);
                            ImageLoader$Builder imageLoader$Builder2 = serviceStore2.activeProfile$delegate;
                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[0];
                            MemoryCacheService memoryCacheService2 = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder2.applicationContext).entries;
                            String str2 = (String) ((Remote$$ExternalSyntheticLambda1) imageLoader$Builder2.defaults).invoke(uuid5);
                            SharedPreferences.Editor editorEdit2 = ((SharedPreferences) memoryCacheService2.imageLoader).edit();
                            editorEdit2.putString("active_profile", str2);
                            editorEdit2.apply();
                            context = context2;
                            mutex = mutex3;
                            uuid2 = uuid3;
                        }
                        mutex = mutexImpl;
                        return coroutineSingletons;
                    }
                    BroadcastKt.sendProfileChanged(context, uuid2);
                    Unit unit2 = Unit.INSTANCE;
                    ((MutexImpl) mutex).unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex3 = mutex4;
                    ((MutexImpl) mutex3).unlock(null);
                    throw th;
                }
            }
            uuid = this.L$2;
            context = this.L$1;
            Mutex mutex5 = this.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex5;
            mutex = mutexImpl;
            ServiceStore serviceStore3 = new ServiceStore(context);
            boolean zAreEqual = Intrinsics.areEqual(serviceStore3.getActiveProfile(), uuid);
            Dispatcher dispatcherImportedDao2 = DaosKt.ImportedDao();
            this.L$0 = mutex;
            this.L$1 = context;
            this.L$2 = uuid;
            this.L$3 = serviceStore3;
            this.Z$0 = zAreEqual;
            this.label = 2;
            if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new zza(1, dispatcherImportedDao2, uuid), this) != coroutineSingletons) {
                uuid2 = uuid;
                serviceStore = serviceStore3;
                z = zAreEqual;
                mutex2 = mutex;
                FilesKt.deleteRecursively(FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context), uuid2.toString()));
                FilesKt.deleteRecursively(FilesKt.resolve(FilesKt.resolve(context.getFilesDir(), "processing"), uuid2.toString()));
                mutex = mutex2;
                if (z) {
                    Dispatcher dispatcherImportedDao3 = DaosKt.ImportedDao();
                    this.L$0 = mutex2;
                    this.L$1 = context;
                    this.L$2 = uuid2;
                    this.L$3 = serviceStore;
                    this.label = 3;
                    objQueryAllUUIDs = dispatcherImportedDao3.queryAllUUIDs(this);
                    if (objQueryAllUUIDs != coroutineSingletons) {
                        uuid3 = uuid2;
                        mutex3 = mutex2;
                        obj = objQueryAllUUIDs;
                        serviceStore2 = serviceStore;
                        context2 = context;
                        UUID uuid6 = (UUID) CollectionsKt.firstOrNull((List) obj);
                        ImageLoader$Builder imageLoader$Builder3 = serviceStore2.activeProfile$delegate;
                        KProperty kProperty3 = ServiceStore.$$delegatedProperties[0];
                        MemoryCacheService memoryCacheService3 = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder3.applicationContext).entries;
                        String str3 = (String) ((Remote$$ExternalSyntheticLambda1) imageLoader$Builder3.defaults).invoke(uuid6);
                        SharedPreferences.Editor editorEdit3 = ((SharedPreferences) memoryCacheService3.imageLoader).edit();
                        editorEdit3.putString("active_profile", str3);
                        editorEdit3.apply();
                        context = context2;
                        mutex = mutex3;
                        uuid2 = uuid3;
                    }
                }
                BroadcastKt.sendProfileChanged(context, uuid2);
                Unit unit3 = Unit.INSTANCE;
                ((MutexImpl) mutex).unlock(null);
                return Unit.INSTANCE;
            }
            mutex = mutexImpl;
            return coroutineSingletons;
        } catch (Throwable th3) {
            mutex3 = mutex;
            th = th3;
            ((MutexImpl) mutex3).unlock(null);
            throw th;
        }
    }
}
