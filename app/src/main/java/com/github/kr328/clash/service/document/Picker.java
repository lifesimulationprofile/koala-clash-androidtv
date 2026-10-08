package com.github.kr328.clash.service.document;

import android.content.Context;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.model.Profile;
import com.koala.clash.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.FilesKt;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Picker {
    public final Context context;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.document.Picker$list$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public Picker L$0;
        public Path L$1;
        public Object L$2;
        public Object L$3;
        public Collection L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Picker.this.list(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.document.Picker$pick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00331 extends ContinuationImpl {
        public Picker L$0;
        public Path L$1;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00331(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Picker.this.pick(null, false, this);
        }
    }

    public Picker(Context context) {
        this.context = context;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x017f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0185  */
    /* JADX WARN: Code duplicated, block: B:68:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.github.kr328.clash.service.document.Path$Scope, java.util.UUID] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ed -> B:35:0x00ee). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x013f -> B:47:0x0144). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x01a9 -> B:69:0x01aa). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object list(com.github.kr328.clash.service.document.Path r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.document.Picker.list(com.github.kr328.clash.service.document.Path, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object pick(Path path, boolean z, ContinuationImpl continuationImpl) {
        C00331 c00331;
        boolean z2;
        Picker picker;
        Path path2 = path;
        if (continuationImpl instanceof C00331) {
            c00331 = (C00331) continuationImpl;
            int i = c00331.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00331.label = i - Integer.MIN_VALUE;
            } else {
                c00331 = new C00331(continuationImpl);
            }
        } else {
            c00331 = new C00331(continuationImpl);
        }
        Object objQueryByUUID = c00331.result;
        int i2 = c00331.label;
        Flag flag = Flag.Virtual;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objQueryByUUID);
            if (path2.uuid == null) {
                return new VirtualDocument("", this.context.getString(R.string.clash_meta_for_android), Collections.singleton(flag));
            }
            Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
            UUID uuid = path2.uuid;
            c00331.L$0 = this;
            c00331.L$1 = path2;
            z2 = z;
            c00331.Z$0 = z2;
            c00331.label = 1;
            objQueryByUUID = dispatcherImportedDao.queryByUUID(uuid, c00331);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objQueryByUUID == coroutineSingletons) {
                return coroutineSingletons;
            }
            picker = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z3 = c00331.Z$0;
            Path path3 = c00331.L$1;
            picker = c00331.L$0;
            ResultKt.throwOnFailure(objQueryByUUID);
            z2 = z3;
            path2 = path3;
        }
        Imported imported = (Imported) objQueryByUUID;
        if (imported == null) {
            throw new FileNotFoundException("profile not found");
        }
        Profile.Type type = imported.type;
        Context context = picker.context;
        File fileResolve = FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context), imported.uuid.toString());
        Path.Scope scope = path2.scope;
        if (scope == null) {
            if (z2) {
                throw new IllegalArgumentException("invalid open mode");
            }
            return new VirtualDocument(path2.uuid.toString(), imported.name, Collections.singleton(flag));
        }
        List list = path2.relative;
        Flag flag2 = Flag.Writable;
        if (list != null) {
            if (scope == Path.Scope.Providers) {
                return new FileDocument(FilesKt.resolve(FilesKt.resolve(fileResolve, "providers"), CollectionsKt.joinToString$default(path2.relative, "/", null, null, null, 62)), ArraysKt.toSet(new Flag[]{flag2, Flag.Deletable}), null, null);
            }
            throw new FileNotFoundException("invalid path");
        }
        if (scope != Path.Scope.Configuration) {
            return new FileDocument(FilesKt.resolve(fileResolve, "providers"), Collections.singleton(flag), "providers", context.getString(R.string.provider_files));
        }
        if (!z2 || type == Profile.Type.File) {
            return new FileDocument(FilesKt.resolve(fileResolve, "config.yaml"), type == Profile.Type.Url ? EmptySet.INSTANCE : Collections.singleton(flag2), "config.yaml", context.getString(R.string.configuration_yaml));
        }
        throw new IllegalArgumentException("invalid open mode");
    }
}
