package androidx.camera.core.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ChainingListenableFuture extends FutureChain implements Runnable {
    public AsyncFunction mFunction;
    public ListenableFuture mInputFuture;
    public final LinkedBlockingQueue mMayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
    public final CountDownLatch mOutputCreated = new CountDownLatch(1);
    public volatile ListenableFuture mOutputFuture;

    public ChainingListenableFuture(AsyncFunction asyncFunction, ListenableFuture listenableFuture) {
        this.mFunction = asyncFunction;
        listenableFuture.getClass();
        this.mInputFuture = listenableFuture;
    }

    public static Object takeUninterruptibly(LinkedBlockingQueue linkedBlockingQueue) {
        Object objTake;
        boolean z = false;
        while (true) {
            try {
                objTake = linkedBlockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return objTake;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean z2 = false;
        if (!this.mDelegate.cancel(z)) {
            return false;
        }
        while (true) {
            try {
                this.mMayInterruptIfRunningChannel.put(Boolean.valueOf(z));
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        ListenableFuture listenableFuture = this.mInputFuture;
        if (listenableFuture != null) {
            listenableFuture.cancel(z);
        }
        ListenableFuture listenableFuture2 = this.mOutputFuture;
        if (listenableFuture2 != null) {
            listenableFuture2.cancel(z);
        }
        return true;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        if (!this.mDelegate.isDone()) {
            ListenableFuture listenableFuture = this.mInputFuture;
            if (listenableFuture != null) {
                listenableFuture.get();
            }
            this.mOutputCreated.await();
            ListenableFuture listenableFuture2 = this.mOutputFuture;
            if (listenableFuture2 != null) {
                listenableFuture2.get();
            }
        }
        return this.mDelegate.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
    
        return;
     */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.camera.core.impl.utils.futures.AsyncFunction, com.google.common.util.concurrent.ListenableFuture] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.camera.core.impl.utils.futures.AsyncFunction, com.google.common.util.concurrent.ListenableFuture] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.camera.core.impl.utils.futures.AsyncFunction, com.google.common.util.concurrent.ListenableFuture] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
            com.google.common.util.concurrent.ListenableFuture r1 = r5.mInputFuture     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38 java.util.concurrent.ExecutionException -> L49 java.util.concurrent.CancellationException -> L56
            java.lang.Object r1 = androidx.camera.core.impl.utils.futures.Futures.getUninterruptibly(r1)     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38 java.util.concurrent.ExecutionException -> L49 java.util.concurrent.CancellationException -> L56
            androidx.camera.core.impl.utils.futures.AsyncFunction r2 = r5.mFunction     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            com.google.common.util.concurrent.ListenableFuture r1 = r2.apply(r1)     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            r5.mOutputFuture = r1     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            com.google.common.util.concurrent.ListenableFuture r2 = r5.mDelegate     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            boolean r2 = r2.isCancelled()     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            if (r2 == 0) goto L3a
            java.util.concurrent.LinkedBlockingQueue r2 = r5.mMayInterruptIfRunningChannel     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            java.lang.Object r2 = takeUninterruptibly(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            r1.cancel(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            r5.mOutputFuture = r0     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
        L28:
            r5.mFunction = r0
            r5.mInputFuture = r0
            java.util.concurrent.CountDownLatch r0 = r5.mOutputCreated
            r0.countDown()
            return
        L32:
            r1 = move-exception
            goto L81
        L34:
            r1 = move-exception
            goto L5b
        L36:
            r1 = move-exception
            goto L6c
        L38:
            r1 = move-exception
            goto L74
        L3a:
            com.google.android.gms.tasks.zzi r2 = new com.google.android.gms.tasks.zzi     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            r3 = 2
            r4 = 0
            r2.<init>(r3, r5, r1, r4)     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            com.google.android.gms.tasks.zzt r3 = kotlin.text.HexFormatKt.directExecutor()     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            r1.addListener(r2, r3)     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            goto L28
        L49:
            r1 = move-exception
            java.lang.Throwable r1 = r1.getCause()     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer r2 = r5.mCompleter     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            if (r2 == 0) goto L28
            r2.setException(r1)     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            goto L28
        L56:
            r1 = 0
            r5.cancel(r1)     // Catch: java.lang.Throwable -> L32 java.lang.Error -> L34 java.lang.Exception -> L36 java.lang.reflect.UndeclaredThrowableException -> L38
            goto L28
        L5b:
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer r2 = r5.mCompleter     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L62
            r2.setException(r1)     // Catch: java.lang.Throwable -> L32
        L62:
            r5.mFunction = r0
            r5.mInputFuture = r0
            java.util.concurrent.CountDownLatch r0 = r5.mOutputCreated
            r0.countDown()
            goto L80
        L6c:
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer r2 = r5.mCompleter     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L62
            r2.setException(r1)     // Catch: java.lang.Throwable -> L32
            goto L62
        L74:
            java.lang.Throwable r1 = r1.getCause()     // Catch: java.lang.Throwable -> L32
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer r2 = r5.mCompleter     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L62
            r2.setException(r1)     // Catch: java.lang.Throwable -> L32
            goto L62
        L80:
            return
        L81:
            r5.mFunction = r0
            r5.mInputFuture = r0
            java.util.concurrent.CountDownLatch r0 = r5.mOutputCreated
            r0.countDown()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.futures.ChainingListenableFuture.run():void");
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!this.mDelegate.isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j = timeUnit2.convert(j, timeUnit);
                timeUnit = timeUnit2;
            }
            ListenableFuture listenableFuture = this.mInputFuture;
            if (listenableFuture != null) {
                long jNanoTime = System.nanoTime();
                listenableFuture.get(j, timeUnit);
                j -= Math.max(0L, System.nanoTime() - jNanoTime);
            }
            long jNanoTime2 = System.nanoTime();
            if (this.mOutputCreated.await(j, timeUnit)) {
                j -= Math.max(0L, System.nanoTime() - jNanoTime2);
                ListenableFuture listenableFuture2 = this.mOutputFuture;
                if (listenableFuture2 != null) {
                    listenableFuture2.get(j, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return this.mDelegate.get(j, timeUnit);
    }
}
