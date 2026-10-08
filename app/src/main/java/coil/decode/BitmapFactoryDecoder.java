package coil.decode;

import coil.request.Options;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.ForwardingSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapFactoryDecoder {
    public final Options options;
    public final Semaphore parallelismLock;
    public final ResponseBody source;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ExceptionCatchingSource extends ForwardingSource {
        public Exception exception;

        @Override // okio.Source
        public final long read(long j, Buffer buffer) throws Exception {
            try {
                return this.delegate.read(j, buffer);
            } catch (Exception e) {
                this.exception = e;
                throw e;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Factory {
        public final SemaphoreImpl parallelismLock;

        public Factory() {
            int i = SemaphoreKt.MAX_SPIN_CYCLES;
            this.parallelismLock = new SemaphoreImpl(4);
        }

        public final boolean equals(Object obj) {
            return obj instanceof Factory;
        }

        public final int hashCode() {
            return Factory.class.hashCode();
        }
    }

    /* JADX INFO: renamed from: coil.decode.BitmapFactoryDecoder$decode$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Semaphore L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BitmapFactoryDecoder.this.decode(this);
        }
    }

    public BitmapFactoryDecoder(ResponseBody responseBody, Options options, Semaphore semaphore) {
        this.source = responseBody;
        this.options = options;
        this.parallelismLock = semaphore;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object decode(ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        int andDecrement;
        Object result;
        BitmapFactoryDecoder bitmapFactoryDecoder;
        Object obj;
        Object obj2;
        Throwable th;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj3 = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj3);
                anonymousClass1.L$0 = this;
                Semaphore semaphore = this.parallelismLock;
                anonymousClass1.L$1 = semaphore;
                anonymousClass1.label = 1;
                SemaphoreAndMutexImpl semaphoreAndMutexImpl = (SemaphoreAndMutexImpl) semaphore;
                semaphoreAndMutexImpl.getClass();
                int i3 = semaphoreAndMutexImpl.permits;
                do {
                    andDecrement = SemaphoreAndMutexImpl._availablePermits$volatile$FU.getAndDecrement(semaphoreAndMutexImpl);
                } while (andDecrement > i3);
                if (andDecrement > 0) {
                    result = Unit.INSTANCE;
                } else {
                    CancellableContinuationImpl orCreateCancellableContinuation = JobKt.getOrCreateCancellableContinuation(zzga.intercepted(anonymousClass1));
                    try {
                        if (!semaphoreAndMutexImpl.addAcquireToQueue(orCreateCancellableContinuation)) {
                            while (true) {
                                int andDecrement2 = SemaphoreAndMutexImpl._availablePermits$volatile$FU.getAndDecrement(semaphoreAndMutexImpl);
                                if (andDecrement2 <= i3) {
                                    if (andDecrement2 > 0) {
                                        orCreateCancellableContinuation.resume(Unit.INSTANCE, semaphoreAndMutexImpl.onCancellationRelease);
                                        break;
                                    }
                                    if (semaphoreAndMutexImpl.addAcquireToQueue(orCreateCancellableContinuation)) {
                                        break;
                                    }
                                }
                            }
                        }
                        result = orCreateCancellableContinuation.getResult();
                        if (result != coroutineSingletons) {
                            result = Unit.INSTANCE;
                        }
                        if (result != coroutineSingletons) {
                            result = Unit.INSTANCE;
                        }
                    } catch (Throwable th2) {
                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                        throw th2;
                    }
                }
                if (result != coroutineSingletons) {
                    bitmapFactoryDecoder = this;
                    obj = semaphore;
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = (Semaphore) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj3);
                    obj2 = obj2;
                    DecodeResult decodeResult = (DecodeResult) obj3;
                    ((SemaphoreAndMutexImpl) obj2).release();
                    return decodeResult;
                } catch (Throwable th3) {
                    th = th3;
                    ((SemaphoreAndMutexImpl) obj2).release();
                    throw th;
                }
            }
            Object obj4 = anonymousClass1.L$1;
            bitmapFactoryDecoder = (BitmapFactoryDecoder) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj3);
            obj = obj4;
            BitmapFactoryDecoder$$ExternalSyntheticLambda2 bitmapFactoryDecoder$$ExternalSyntheticLambda2 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(0, bitmapFactoryDecoder);
            anonymousClass1.L$0 = obj;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            Object objWithContext = JobKt.withContext(EmptyCoroutineContext.INSTANCE, new InterruptibleKt$runInterruptible$2(bitmapFactoryDecoder$$ExternalSyntheticLambda2, null, 0), anonymousClass1);
            if (objWithContext != coroutineSingletons) {
                obj2 = obj;
                obj3 = objWithContext;
                DecodeResult decodeResult2 = (DecodeResult) obj3;
                ((SemaphoreAndMutexImpl) obj2).release();
                return decodeResult2;
            }
            return coroutineSingletons;
        } catch (Throwable th4) {
            obj2 = obj;
            th = th4;
            ((SemaphoreAndMutexImpl) obj2).release();
            throw th;
        }
    }
}
