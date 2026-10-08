package com.github.kr328.kaidl;

import android.os.Binder;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Parcel;
import androidx.navigation.Navigator;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.LogcatService;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SuspendTransactionKt {

    /* JADX INFO: renamed from: com.github.kr328.kaidl.SuspendTransactionKt$suspendTransact$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Ref$ObjectRef L$3;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendTransactionKt.suspendTransact(null, 0, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object suspendTransact(IBinder iBinder, int i, Parcel parcel, final Parcel parcel2, ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        NonCancellable nonCancellable;
        DiskLruCache.AnonymousClass1 anonymousClass2;
        boolean z;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 != 0) {
            if (i3 == 1) {
                ref$ObjectRef2 = anonymousClass1.L$3;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    ref$ObjectRef = ref$ObjectRef2;
                    th = th;
                    nonCancellable = NonCancellable.INSTANCE;
                    anonymousClass2 = new DiskLruCache.AnonymousClass1(ref$ObjectRef, continuation, 10);
                    anonymousClass1.L$0 = th;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.label = 3;
                    if (JobKt.withContext(nonCancellable, anonymousClass2, anonymousClass1) == coroutineSingletons) {
                        throw th;
                    }
                }
            } else {
                if (i3 != 2) {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th2;
                }
                z = anonymousClass1.Z$0;
                ResultKt.throwOnFailure(obj);
            }
            return Boolean.valueOf(z);
        }
        ResultKt.throwOnFailure(obj);
        ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = SuspendTransactionKt$suspendTransact$finalizer$1.INSTANCE;
        try {
            anonymousClass1.L$0 = iBinder;
            anonymousClass1.L$3 = ref$ObjectRef;
            anonymousClass1.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(anonymousClass1));
            cancellableContinuationImpl.initCancellability();
            Binder binder = new Binder() { // from class: com.github.kr328.kaidl.SuspendTransactionKt$suspendTransact$2$completable$1
                @Override // android.os.Binder
                public final boolean onTransact(int i4, Parcel parcel3, Parcel parcel4, int i5) throws DispatchException {
                    CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return super.onTransact(i4, parcel3, parcel4, i5);
                        }
                        cancellableContinuationImpl2.cancel(null);
                        return true;
                    }
                    int iDataAvail = parcel3.dataAvail();
                    Parcel parcel5 = parcel2;
                    parcel5.appendFrom(parcel3, 0, iDataAvail);
                    parcel5.setDataPosition(0);
                    cancellableContinuationImpl2.resumeWith(Boolean.TRUE);
                    return true;
                }
            };
            Parcel parcelObtain = Parcel.obtain();
            parcel.writeStrongBinder(binder);
            try {
                try {
                    iBinder.transact(i, parcel, parcelObtain, 0);
                    parcelObtain.readException();
                    IBinder strongBinder = parcelObtain.readStrongBinder();
                    parcelObtain.recycle();
                    IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: com.github.kr328.kaidl.SuspendTransactionKt$suspendTransact$2$link$1
                        @Override // android.os.IBinder.DeathRecipient
                        public final void binderDied() {
                            cancellableContinuationImpl.resumeWith(new Result.Failure(new DeadObjectException()));
                        }
                    };
                    ref$ObjectRef.element = new DialogHostKt$DialogHost$1$1$1(9, strongBinder, deathRecipient);
                    strongBinder.linkToDeath(deathRecipient, 0);
                    cancellableContinuationImpl.invokeOnCancellation(new Navigator.AnonymousClass1(28, strongBinder));
                } catch (Exception e) {
                    cancellableContinuationImpl.resumeWith(new Result.Failure(e));
                    parcelObtain.recycle();
                }
                Object result = cancellableContinuationImpl.getResult();
                if (result != coroutineSingletons) {
                    obj = result;
                    ref$ObjectRef2 = ref$ObjectRef;
                }
            } catch (Throwable th3) {
                parcelObtain.recycle();
                throw th3;
            }
        } catch (Throwable th4) {
            th = th4;
            nonCancellable = NonCancellable.INSTANCE;
            anonymousClass2 = new DiskLruCache.AnonymousClass1(ref$ObjectRef, continuation, 10);
            anonymousClass1.L$0 = th;
            anonymousClass1.L$3 = null;
            anonymousClass1.label = 3;
            if (JobKt.withContext(nonCancellable, anonymousClass2, anonymousClass1) == coroutineSingletons) {
                throw th;
            }
        }
        return coroutineSingletons;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        NonCancellable nonCancellable2 = NonCancellable.INSTANCE;
        DiskLruCache.AnonymousClass1 anonymousClass3 = new DiskLruCache.AnonymousClass1(ref$ObjectRef2, continuation, 10);
        anonymousClass1.L$0 = null;
        anonymousClass1.L$3 = null;
        anonymousClass1.Z$0 = zBooleanValue;
        anonymousClass1.label = 2;
        if (JobKt.withContext(nonCancellable2, anonymousClass3, anonymousClass1) != coroutineSingletons) {
            z = zBooleanValue;
            return Boolean.valueOf(z);
        }
        return coroutineSingletons;
    }

    public static final void suspendTransaction(Parcel parcel, Parcel parcel2, Function2 function2) {
        IBinder strongBinder = parcel.readStrongBinder();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = SuspendTransactionKt$suspendTransact$finalizer$1.INSTANCE$1;
        final StandaloneCoroutine standaloneCoroutineLaunch$default = JobKt.launch$default(KaidlScope.INSTANCE, null, new NavHostKt$NavHost$29$1(function2, strongBinder, ref$ObjectRef, (Continuation) null), 3);
        LogcatService.AnonymousClass1 anonymousClass1 = new LogcatService.AnonymousClass1(standaloneCoroutineLaunch$default, 1);
        IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: com.github.kr328.kaidl.SuspendTransactionKt$$ExternalSyntheticLambda0
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                standaloneCoroutineLaunch$default.cancel((CancellationException) null);
            }
        };
        ref$ObjectRef.element = new DialogHostKt$DialogHost$1$1$1(10, strongBinder, deathRecipient);
        strongBinder.linkToDeath(deathRecipient, 0);
        parcel2.writeNoException();
        parcel2.writeStrongBinder(anonymousClass1);
    }
}
