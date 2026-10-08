package com.github.kr328.clash.service.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.kaidl.SuspendTransactionKt;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IProfileManagerDelegate extends Binder implements IProfileManager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final /* synthetic */ IProfileManager $$delegate_0;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerDelegate$onTransact$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ IFetchObserver $callback;
        public final /* synthetic */ long $interval;
        public final /* synthetic */ String $name;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ String $source;
        public final /* synthetic */ Object $type;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ IProfileManagerDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(IProfileManagerDelegate iProfileManagerDelegate, Object obj, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.this$0 = iProfileManagerDelegate;
            this.$type = obj;
            this.$name = str;
            this.$source = str2;
            this.$interval = j;
            this.$callback = iFetchObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (Profile.Type) this.$type, this.$name, this.$source, this.$interval, this.$callback, continuation, 0);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                default:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.this$0, (UUID) this.$type, this.$name, this.$source, this.$interval, this.$callback, continuation, 1);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Parcel parcel = (Parcel) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return ((AnonymousClass1) create(parcel, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Parcel parcel;
            Parcel parcel2;
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel = (Parcel) this.L$0;
                        Profile.Type type = (Profile.Type) this.$type;
                        this.L$0 = parcel;
                        this.label = 1;
                        obj = this.this$0.$$delegate_0.mo811import(type, this.$name, this.$source, this.$interval, this.$callback, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    parcel.writeNoException();
                    parcel.writeSerializable((UUID) obj);
                    return Unit.INSTANCE;
                default:
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel2 = (Parcel) this.L$0;
                        UUID uuid = (UUID) this.$type;
                        this.L$0 = parcel2;
                        this.label = 1;
                        Object objPatch = this.this$0.$$delegate_0.patch(uuid, this.$name, this.$source, this.$interval, this.$callback, this);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objPatch == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel2 = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    parcel2.writeNoException();
                    return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerDelegate$onTransact$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ UUID $uuid;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ IProfileManagerDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(IProfileManagerDelegate iProfileManagerDelegate, UUID uuid, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.this$0 = iProfileManagerDelegate;
            this.$uuid = uuid;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$uuid, continuation, 0);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                case 1:
                    AnonymousClass3 anonymousClass4 = new AnonymousClass3(this.this$0, this.$uuid, continuation, 1);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
                case 2:
                    AnonymousClass3 anonymousClass5 = new AnonymousClass3(this.this$0, this.$uuid, continuation, 2);
                    anonymousClass5.L$0 = obj;
                    return anonymousClass5;
                default:
                    AnonymousClass3 anonymousClass6 = new AnonymousClass3(this.this$0, this.$uuid, continuation, 3);
                    anonymousClass6.L$0 = obj;
                    return anonymousClass6;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Parcel parcel = (Parcel) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
            return ((AnonymousClass3) create(parcel, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Parcel parcel;
            Parcel parcel2;
            Parcel parcel3;
            Parcel parcel4;
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel = (Parcel) this.L$0;
                        this.L$0 = parcel;
                        this.label = 1;
                        Object objUpdate = this.this$0.$$delegate_0.update(this.$uuid, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objUpdate == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    parcel.writeNoException();
                    return Unit.INSTANCE;
                case 1:
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel2 = (Parcel) this.L$0;
                        this.L$0 = parcel2;
                        this.label = 1;
                        obj = this.this$0.$$delegate_0.clone(this.$uuid, this);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel2 = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    parcel2.writeNoException();
                    parcel2.writeSerializable((UUID) obj);
                    return Unit.INSTANCE;
                case 2:
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel3 = (Parcel) this.L$0;
                        this.L$0 = parcel3;
                        this.label = 1;
                        Object objDelete = this.this$0.$$delegate_0.delete(this.$uuid, this);
                        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objDelete == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel3 = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    parcel3.writeNoException();
                    return Unit.INSTANCE;
                default:
                    int i4 = this.label;
                    if (i4 == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel4 = (Parcel) this.L$0;
                        this.L$0 = parcel4;
                        this.label = 1;
                        obj = this.this$0.$$delegate_0.queryByUUID(this.$uuid, this);
                        CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons4) {
                            return coroutineSingletons4;
                        }
                    } else {
                        if (i4 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel4 = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Profile profile = (Profile) obj;
                    parcel4.writeNoException();
                    if (profile != null) {
                        parcel4.writeInt(1);
                        profile.writeToParcel(parcel4, 0);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerDelegate$onTransact$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass7 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ IProfileManagerDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass7(IProfileManagerDelegate iProfileManagerDelegate, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.this$0 = iProfileManagerDelegate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass7 anonymousClass7 = new AnonymousClass7(this.this$0, continuation, 0);
                    anonymousClass7.L$0 = obj;
                    return anonymousClass7;
                default:
                    AnonymousClass7 anonymousClass8 = new AnonymousClass7(this.this$0, continuation, 1);
                    anonymousClass8.L$0 = obj;
                    return anonymousClass8;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Parcel parcel = (Parcel) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return ((AnonymousClass7) create(parcel, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Parcel parcel;
            Parcel parcel2;
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel = (Parcel) this.L$0;
                        this.L$0 = parcel;
                        this.label = 1;
                        obj = this.this$0.$$delegate_0.queryAll(this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    List list = (List) obj;
                    parcel.writeNoException();
                    parcel.writeInt(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Profile) it.next()).writeToParcel(parcel, 0);
                    }
                    return Unit.INSTANCE;
                default:
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel2 = (Parcel) this.L$0;
                        this.L$0 = parcel2;
                        this.label = 1;
                        obj = this.this$0.$$delegate_0.queryActive(this);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel2 = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Profile profile = (Profile) obj;
                    parcel2.writeNoException();
                    if (profile != null) {
                        parcel2.writeInt(1);
                        profile.writeToParcel(parcel2, 0);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    public IProfileManagerDelegate(IProfileManager iProfileManager) {
        this.$$delegate_0 = iProfileManager;
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object clone(UUID uuid, Continuation continuation) {
        return this.$$delegate_0.clone(uuid, continuation);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object delete(UUID uuid, Continuation continuation) {
        return this.$$delegate_0.delete(uuid, continuation);
    }

    @Override // android.os.Binder, android.os.IBinder
    public final String getInterfaceDescriptor() {
        return "com.github.kr328.clash.service.remote.IProfileManager";
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    /* JADX INFO: renamed from: import */
    public final Object mo811import(Profile.Type type, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) {
        return this.$$delegate_0.mo811import(type, str, str2, j, iFetchObserver, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.github.kr328.clash.service.remote.IFetchObserver] */
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        ?? iFetchObserverProxy = 0;
        IFetchObserver iFetchObserverProxy2 = null;
        if (i == 1) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
            Profile.Type type = Profile.Type.values()[parcel.readInt()];
            String string = parcel.readString();
            String string2 = parcel.readString();
            long j = parcel.readLong();
            if (parcel.readInt() != 0) {
                IBinder strongBinder = parcel.readStrongBinder();
                Reflection.getOrCreateKotlinClass(IFetchObserver.class);
                iFetchObserverProxy2 = strongBinder instanceof IFetchObserver ? (IFetchObserver) strongBinder : new IFetchObserverProxy(strongBinder);
            }
            SuspendTransactionKt.suspendTransaction(parcel, parcel2, new AnonymousClass1(this, type, string, string2, j, iFetchObserverProxy2, null, 0));
            return true;
        }
        if (i == 2) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
            UUID uuid = (UUID) parcel.readSerializable();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            long j2 = parcel.readLong();
            if (parcel.readInt() != 0) {
                IBinder strongBinder2 = parcel.readStrongBinder();
                Reflection.getOrCreateKotlinClass(IFetchObserver.class);
                iFetchObserverProxy = strongBinder2 instanceof IFetchObserver ? (IFetchObserver) strongBinder2 : new IFetchObserverProxy(strongBinder2);
            }
            SuspendTransactionKt.suspendTransaction(parcel, parcel2, new AnonymousClass1(this, uuid, string3, string4, j2, iFetchObserverProxy, null, 1));
            return true;
        }
        if (i == 3) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
            SuspendTransactionKt.suspendTransaction(parcel, parcel2, new AnonymousClass3(this, (UUID) parcel.readSerializable(), iFetchObserverProxy, 0));
            return true;
        }
        if (i == 4) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
            SuspendTransactionKt.suspendTransaction(parcel, parcel2, new AnonymousClass3(this, (UUID) parcel.readSerializable(), iFetchObserverProxy, 1));
            return true;
        }
        if (i == 5) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
            SuspendTransactionKt.suspendTransaction(parcel, parcel2, new AnonymousClass3(this, (UUID) parcel.readSerializable(), iFetchObserverProxy, 2));
            return true;
        }
        if (i == 6) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
            SuspendTransactionKt.suspendTransaction(parcel, parcel2, new AnonymousClass3(this, (UUID) parcel.readSerializable(), iFetchObserverProxy, 3));
            return true;
        }
        if (i == 7) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
            SuspendTransactionKt.suspendTransaction(parcel, parcel2, new AnonymousClass7(this, iFetchObserverProxy, 0));
            return true;
        }
        if (i == 8) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
            SuspendTransactionKt.suspendTransaction(parcel, parcel2, new AnonymousClass7(this, iFetchObserverProxy, 1));
            return true;
        }
        if (i != 9) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        parcel.enforceInterface("com.github.kr328.clash.service.remote.IProfileManager");
        SuspendTransactionKt.suspendTransaction(parcel, parcel2, new ChannelFlow.AnonymousClass2(this, Profile.CREATOR.createFromParcel(parcel), iFetchObserverProxy, 6));
        return true;
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object patch(UUID uuid, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) {
        return this.$$delegate_0.patch(uuid, str, str2, j, iFetchObserver, continuation);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryActive(Continuation continuation) {
        return this.$$delegate_0.queryActive(continuation);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryAll(Continuation continuation) {
        return this.$$delegate_0.queryAll(continuation);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryByUUID(UUID uuid, Continuation continuation) {
        return this.$$delegate_0.queryByUUID(uuid, continuation);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object setActive(Profile profile, Continuation continuation) {
        return this.$$delegate_0.setActive(profile, continuation);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object update(UUID uuid, Continuation continuation) {
        return this.$$delegate_0.update(uuid, continuation);
    }
}
