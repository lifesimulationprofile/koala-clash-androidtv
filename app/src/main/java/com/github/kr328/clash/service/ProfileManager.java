package com.github.kr328.clash.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.compose.material3.ThumbNode;
import coil.RealImageLoader$executeMain$result$1;
import com.github.kr328.clash.FilesActivity$Content$1$1;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IFetchObserver;
import com.github.kr328.clash.service.remote.IProfileManager;
import com.github.kr328.clash.service.store.ServiceStore;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileManager implements IProfileManager, CoroutineScope {
    public final /* synthetic */ ContextScope $$delegate_0;
    public final RemoteService context;
    public final ServiceStore store;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$delete$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public ProfileManager L$0;
        public UUID L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.delete(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$import$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00271 extends ContinuationImpl {
        public ProfileManager L$0;
        public UUID L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00271(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.mo811import(null, null, null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$patch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00281 extends ContinuationImpl {
        public ProfileManager L$0;
        public UUID L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00281(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.patch(null, null, null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$queryActive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00291 extends ContinuationImpl {
        public ProfileManager L$0;
        public UUID L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00291(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.queryActive(this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$queryAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00301 extends ContinuationImpl {
        public ProfileManager L$0;
        public Collection L$1;
        public Iterator L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00301(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.queryAll(this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$resolveProfile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00311 extends ContinuationImpl {
        public ProfileManager L$0;
        public UUID L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00311(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.resolveProfile(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$update$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00321 extends ContinuationImpl {
        public ProfileManager L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00321(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.update(null, this);
        }
    }

    public ProfileManager(RemoteService remoteService) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.$$delegate_0 = JobKt.CoroutineScope(DefaultIoScheduler.INSTANCE);
        this.context = remoteService;
        this.store = new ServiceStore(remoteService);
        JobKt.launch$default(this, null, new ThumbNode.AnonymousClass1(this, (Continuation) null, 23), 3);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object clone(UUID uuid, Continuation continuation) {
        ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
        return JobKt.withContext(NonCancellable.INSTANCE, new FilesActivity$Content$1$1(this.context, uuid, (Continuation) null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
    
        if (r7 == r4) goto L30;
     */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object delete(java.util.UUID r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.github.kr328.clash.service.ProfileManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.github.kr328.clash.service.ProfileManager$delete$1 r0 = (com.github.kr328.clash.service.ProfileManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L13:
            com.github.kr328.clash.service.ProfileManager$delete$1 r0 = new com.github.kr328.clash.service.ProfileManager$delete$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r8 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r8
            r0.<init>(r8)
        L1a:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L88
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.util.UUID r7 = r0.L$1
            com.github.kr328.clash.service.ProfileManager r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L51
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            okhttp3.Dispatcher r8 = com.github.kr328.clash.service.data.DaosKt.ImportedDao()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = r8.queryByUUID(r7, r0)
            if (r8 != r4) goto L50
            goto L87
        L50:
            r1 = r6
        L51:
            com.github.kr328.clash.service.data.Imported r8 = (com.github.kr328.clash.service.data.Imported) r8
            if (r8 == 0) goto L6a
            okio.AsyncTimeout$Companion r3 = com.github.kr328.clash.service.ProfileReceiver.Companion
            com.github.kr328.clash.service.RemoteService r3 = r1.context
            android.app.PendingIntent r8 = okio.AsyncTimeout.Companion.pendingIntentOf(r3, r8)
            java.lang.Class<android.app.AlarmManager> r5 = android.app.AlarmManager.class
            java.lang.Object r3 = r3.getSystemService(r5)
            android.app.AlarmManager r3 = (android.app.AlarmManager) r3
            if (r3 == 0) goto L6a
            r3.cancel(r8)
        L6a:
            com.github.kr328.clash.service.ProfileProcessor r8 = com.github.kr328.clash.service.ProfileProcessor.INSTANCE
            com.github.kr328.clash.service.RemoteService r8 = r1.context
            r1 = 0
            r0.L$0 = r1
            r0.L$1 = r1
            r0.label = r2
            kotlinx.coroutines.NonCancellable r2 = kotlinx.coroutines.NonCancellable.INSTANCE
            com.github.kr328.clash.service.ProfileProcessor$delete$2 r3 = new com.github.kr328.clash.service.ProfileProcessor$delete$2
            r3.<init>(r8, r7, r1)
            java.lang.Object r7 = kotlinx.coroutines.JobKt.withContext(r2, r3, r0)
            if (r7 != r4) goto L83
            goto L85
        L83:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L85:
            if (r7 != r4) goto L88
        L87:
            return r4
        L88:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.ProfileManager.delete(java.util.UUID, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    /* JADX INFO: renamed from: import, reason: not valid java name */
    public final Object mo811import(Profile.Type type, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) throws Throwable {
        C00271 c00271;
        ProfileManager profileManager;
        UUID uuid;
        Object objQueryByUUID;
        UUID uuid2;
        ProfileManager profileManager2;
        Imported imported;
        if (continuation instanceof C00271) {
            c00271 = (C00271) continuation;
            int i = c00271.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00271.label = i - Integer.MIN_VALUE;
            } else {
                c00271 = new C00271((ContinuationImpl) continuation);
            }
        } else {
            c00271 = new C00271((ContinuationImpl) continuation);
        }
        Object objWithContext = c00271.result;
        int i2 = c00271.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
            c00271.L$0 = this;
            c00271.label = 1;
            objWithContext = JobKt.withContext(NonCancellable.INSTANCE, new ProfileProcessor$patch$2(str, type, str2, j, this.context, iFetchObserver, (Continuation) null), c00271);
            if (objWithContext != coroutineSingletons) {
                profileManager = this;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            profileManager = c00271.L$0;
            ResultKt.throwOnFailure(objWithContext);
        } else {
            if (i2 == 2) {
                UUID uuid3 = c00271.L$1;
                ProfileManager profileManager3 = c00271.L$0;
                ResultKt.throwOnFailure(objWithContext);
                uuid = uuid3;
                profileManager = profileManager3;
                Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
                c00271.L$0 = profileManager;
                c00271.L$1 = uuid;
                c00271.label = 3;
                objQueryByUUID = dispatcherImportedDao.queryByUUID(uuid, c00271);
                if (objQueryByUUID != coroutineSingletons) {
                    ProfileManager profileManager4 = profileManager;
                    uuid2 = uuid;
                    objWithContext = objQueryByUUID;
                    profileManager2 = profileManager4;
                }
                return coroutineSingletons;
            }
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uuid2 = c00271.L$1;
            profileManager2 = c00271.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        imported = (Imported) objWithContext;
        if (imported != null) {
            AsyncTimeout.Companion companion = ProfileReceiver.Companion;
            AsyncTimeout.Companion.scheduleNext(profileManager2.context, imported);
        }
        return uuid2;
        uuid = (UUID) objWithContext;
        ProfileProcessor profileProcessor2 = ProfileProcessor.INSTANCE;
        RemoteService remoteService = profileManager.context;
        c00271.L$0 = profileManager;
        c00271.L$1 = uuid;
        c00271.label = 2;
        Object objWithContext2 = JobKt.withContext(NonCancellable.INSTANCE, new RealImageLoader$executeMain$result$1(remoteService, uuid, (Continuation) null), c00271);
        if (objWithContext2 != coroutineSingletons) {
            objWithContext2 = Unit.INSTANCE;
        }
        if (objWithContext2 != coroutineSingletons) {
            Dispatcher dispatcherImportedDao2 = DaosKt.ImportedDao();
            c00271.L$0 = profileManager;
            c00271.L$1 = uuid;
            c00271.label = 3;
            objQueryByUUID = dispatcherImportedDao2.queryByUUID(uuid, c00271);
            if (objQueryByUUID != coroutineSingletons) {
                ProfileManager profileManager5 = profileManager;
                uuid2 = uuid;
                objWithContext = objQueryByUUID;
                profileManager2 = profileManager5;
                imported = (Imported) objWithContext;
                if (imported != null) {
                    AsyncTimeout.Companion companion2 = ProfileReceiver.Companion;
                    AsyncTimeout.Companion.scheduleNext(profileManager2.context, imported);
                }
                return uuid2;
            }
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0087  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object patch(UUID uuid, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) throws Throwable {
        C00281 c00281;
        UUID uuid2;
        ProfileManager profileManager;
        ProfileManager profileManager2;
        Imported imported;
        if (continuation instanceof C00281) {
            c00281 = (C00281) continuation;
            int i = c00281.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00281.label = i - Integer.MIN_VALUE;
            } else {
                c00281 = new C00281((ContinuationImpl) continuation);
            }
        } else {
            c00281 = new C00281((ContinuationImpl) continuation);
        }
        Object objQueryByUUID = c00281.result;
        int i2 = c00281.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objQueryByUUID);
            ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
            c00281.L$0 = this;
            c00281.L$1 = uuid;
            c00281.label = 1;
            Object objWithContext = JobKt.withContext(NonCancellable.INSTANCE, new ProfileProcessor$patch$2(uuid, str, str2, j, this.context, iFetchObserver, (Continuation) null), c00281);
            if (objWithContext != coroutineSingletons) {
                objWithContext = Unit.INSTANCE;
            }
            if (objWithContext != coroutineSingletons) {
                uuid2 = uuid;
                profileManager = this;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            uuid2 = c00281.L$1;
            profileManager = c00281.L$0;
            ResultKt.throwOnFailure(objQueryByUUID);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            profileManager2 = c00281.L$0;
            ResultKt.throwOnFailure(objQueryByUUID);
        }
        imported = (Imported) objQueryByUUID;
        if (imported != null) {
            AsyncTimeout.Companion companion = ProfileReceiver.Companion;
            AsyncTimeout.Companion.scheduleNext(profileManager2.context, imported);
        }
        return Unit.INSTANCE;
        Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
        c00281.L$0 = profileManager;
        c00281.L$1 = null;
        c00281.label = 2;
        objQueryByUUID = dispatcherImportedDao.queryByUUID(uuid2, c00281);
        if (objQueryByUUID != coroutineSingletons) {
            profileManager2 = profileManager;
            imported = (Imported) objQueryByUUID;
            if (imported != null) {
                AsyncTimeout.Companion companion2 = ProfileReceiver.Companion;
                AsyncTimeout.Companion.scheduleNext(profileManager2.context, imported);
            }
            return Unit.INSTANCE;
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryActive(Continuation continuation) throws IOException {
        C00291 c00291;
        UUID activeProfile;
        ProfileManager profileManager;
        if (continuation instanceof C00291) {
            c00291 = (C00291) continuation;
            int i = c00291.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00291.label = i - Integer.MIN_VALUE;
            } else {
                c00291 = new C00291((ContinuationImpl) continuation);
            }
        } else {
            c00291 = new C00291((ContinuationImpl) continuation);
        }
        Object objExists = c00291.result;
        int i2 = c00291.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExists);
            activeProfile = this.store.getActiveProfile();
            if (activeProfile != null) {
                Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
                c00291.L$0 = this;
                c00291.L$1 = activeProfile;
                c00291.label = 1;
                objExists = dispatcherImportedDao.exists(activeProfile, c00291);
                if (objExists != coroutineSingletons) {
                    profileManager = this;
                }
            }
            return null;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objExists);
            return objExists;
        }
        activeProfile = c00291.L$1;
        profileManager = c00291.L$0;
        ResultKt.throwOnFailure(objExists);
        if (((Boolean) objExists).booleanValue()) {
            c00291.L$0 = null;
            c00291.L$1 = null;
            c00291.label = 2;
            Object objResolveProfile = profileManager.resolveProfile(activeProfile, c00291);
            return objResolveProfile == coroutineSingletons ? coroutineSingletons : objResolveProfile;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        if (r8 == r4) goto L25;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007d -> B:26:0x0080). Please report as a decompilation issue!!! */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryAll(kotlin.coroutines.Continuation r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.github.kr328.clash.service.ProfileManager.C00301
            if (r0 == 0) goto L13
            r0 = r8
            com.github.kr328.clash.service.ProfileManager$queryAll$1 r0 = (com.github.kr328.clash.service.ProfileManager.C00301) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L13:
            com.github.kr328.clash.service.ProfileManager$queryAll$1 r0 = new com.github.kr328.clash.service.ProfileManager$queryAll$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r8 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r8
            r0.<init>(r8)
        L1a:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L42
            if (r1 == r3) goto L3c
            if (r1 != r2) goto L34
            java.util.Iterator r1 = r0.L$2
            java.util.Collection r3 = r0.L$1
            java.util.Collection r3 = (java.util.Collection) r3
            com.github.kr328.clash.service.ProfileManager r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L80
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3c:
            com.github.kr328.clash.service.ProfileManager r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            okhttp3.Dispatcher r8 = com.github.kr328.clash.service.data.DaosKt.ImportedDao()
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.queryAllUUIDs(r0)
            if (r8 != r4) goto L54
            goto L7f
        L54:
            r1 = r7
        L55:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r8 = r8.iterator()
            r5 = r1
            r1 = r8
        L62:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L88
            java.lang.Object r8 = r1.next()
            java.util.UUID r8 = (java.util.UUID) r8
            r0.L$0 = r5
            r6 = r3
            java.util.Collection r6 = (java.util.Collection) r6
            r0.L$1 = r6
            r0.L$2 = r1
            r0.label = r2
            java.lang.Object r8 = r5.resolveProfile(r8, r0)
            if (r8 != r4) goto L80
        L7f:
            return r4
        L80:
            com.github.kr328.clash.service.model.Profile r8 = (com.github.kr328.clash.service.model.Profile) r8
            if (r8 == 0) goto L62
            r3.add(r8)
            goto L62
        L88:
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.ProfileManager.queryAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryByUUID(UUID uuid, Continuation continuation) {
        return resolveProfile(uuid, (ContinuationImpl) continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object resolveProfile(UUID uuid, ContinuationImpl continuationImpl) throws IOException {
        C00311 c00311;
        ProfileManager profileManager;
        Long lValueOf;
        long jLongValue;
        byte[] bArr;
        UUID uuid2 = uuid;
        if (continuationImpl instanceof C00311) {
            c00311 = (C00311) continuationImpl;
            int i = c00311.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00311.label = i - Integer.MIN_VALUE;
            } else {
                c00311 = new C00311(continuationImpl);
            }
        } else {
            c00311 = new C00311(continuationImpl);
        }
        Object objQueryByUUID = c00311.result;
        int i2 = c00311.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objQueryByUUID);
            Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
            c00311.L$0 = this;
            c00311.L$1 = uuid2;
            c00311.label = 1;
            objQueryByUUID = dispatcherImportedDao.queryByUUID(uuid2, c00311);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objQueryByUUID == coroutineSingletons) {
                return coroutineSingletons;
            }
            profileManager = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uuid2 = c00311.L$1;
            profileManager = c00311.L$0;
            ResultKt.throwOnFailure(objQueryByUUID);
        }
        Imported imported = (Imported) objQueryByUUID;
        if (imported == null) {
            return null;
        }
        ServiceStore serviceStore = profileManager.store;
        RemoteService remoteService = profileManager.context;
        UUID activeProfile = serviceStore.getActiveProfile();
        Long l = new Long(imported.updatedAt);
        if (l.longValue() <= 0) {
            l = null;
        }
        if (l != null) {
            jLongValue = l.longValue();
        } else {
            Iterator it = new FileTreeWalk(1, 0, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(remoteService), uuid2.toString()), null).iterator();
            if (it.hasNext()) {
                lValueOf = Long.valueOf(((File) it.next()).lastModified());
                while (it.hasNext()) {
                    Long lValueOf2 = Long.valueOf(((File) it.next()).lastModified());
                    if (lValueOf.compareTo(lValueOf2) < 0) {
                        lValueOf = lValueOf2;
                    }
                }
            } else {
                lValueOf = null;
            }
            jLongValue = lValueOf != null ? lValueOf.longValue() : -1L;
        }
        long j = jLongValue;
        File fileResolve = FilesKt.resolve(FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(remoteService), uuid2.toString()), "profile-logo");
        if (!fileResolve.isFile() && (bArr = imported.profileImage) != null) {
            com.github.kr328.clash.service.util.FilesKt.writeProfileLogo(remoteService, uuid2, bArr);
        }
        if (!fileResolve.isFile()) {
            fileResolve = null;
        }
        String absolutePath = fileResolve != null ? fileResolve.getAbsolutePath() : null;
        UUID uuid3 = imported.uuid;
        return new Profile(uuid3, imported.name, imported.type, imported.source, activeProfile != null && Intrinsics.areEqual(uuid3, activeProfile), imported.interval, imported.upload, imported.download, imported.total, imported.expire, j, absolutePath, imported.announce, imported.supportURL, imported.modeSwitchAllowed);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object setActive(Profile profile, Continuation continuation) throws Throwable {
        ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
        Object objWithContext = JobKt.withContext(NonCancellable.INSTANCE, new RealImageLoader$executeMain$result$1(this.context, profile.uuid, (Continuation) null), (ContinuationImpl) continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objWithContext != coroutineSingletons) {
            objWithContext = Unit.INSTANCE;
        }
        return objWithContext == coroutineSingletons ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object update(UUID uuid, Continuation continuation) throws PendingIntent.CanceledException {
        C00321 c00321;
        ProfileManager profileManager;
        if (continuation instanceof C00321) {
            c00321 = (C00321) continuation;
            int i = c00321.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00321.label = i - Integer.MIN_VALUE;
            } else {
                c00321 = new C00321((ContinuationImpl) continuation);
            }
        } else {
            c00321 = new C00321((ContinuationImpl) continuation);
        }
        Object objQueryByUUID = c00321.result;
        int i2 = c00321.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objQueryByUUID);
            Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
            c00321.L$0 = this;
            c00321.label = 1;
            objQueryByUUID = dispatcherImportedDao.queryByUUID(uuid, c00321);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objQueryByUUID == coroutineSingletons) {
                return coroutineSingletons;
            }
            profileManager = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            profileManager = c00321.L$0;
            ResultKt.throwOnFailure(objQueryByUUID);
        }
        Imported imported = (Imported) objQueryByUUID;
        if (imported != null) {
            AsyncTimeout.Companion companion = ProfileReceiver.Companion;
            RemoteService remoteService = profileManager.context;
            PendingIntent pendingIntentPendingIntentOf = AsyncTimeout.Companion.pendingIntentOf(remoteService, imported);
            AlarmManager alarmManager = (AlarmManager) remoteService.getSystemService(AlarmManager.class);
            if (alarmManager != null) {
                alarmManager.cancel(pendingIntentPendingIntentOf);
            }
            pendingIntentPendingIntentOf.send(remoteService, 0, (Intent) null);
        }
        return Unit.INSTANCE;
    }
}
