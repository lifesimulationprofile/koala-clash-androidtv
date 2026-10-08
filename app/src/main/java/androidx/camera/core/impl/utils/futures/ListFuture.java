package androidx.camera.core.impl.utils.futures;

import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.gms.tasks.zzg;
import com.google.android.gms.tasks.zzt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ListFuture implements ListenableFuture {
    public final boolean mAllMustSucceed;
    public ArrayList mFutures;
    public final AtomicInteger mRemaining;
    public final ListenableFuture mResult = CallbackToFutureAdapter.getFuture(new PreviewView.AnonymousClass1(19, this));
    public CallbackToFutureAdapter.Completer mResultNotifier;
    public ArrayList mValues;

    public ListFuture(ArrayList arrayList, boolean z, zzt zztVar) {
        this.mFutures = arrayList;
        this.mValues = new ArrayList(arrayList.size());
        this.mAllMustSucceed = z;
        this.mRemaining = new AtomicInteger(arrayList.size());
        addListener(new zzg(8, this), HexFormatKt.directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList(this.mValues));
            return;
        }
        for (int i = 0; i < this.mFutures.size(); i++) {
            this.mValues.add(null);
        }
        ArrayList arrayList2 = this.mFutures;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            ListenableFuture listenableFuture = (ListenableFuture) arrayList2.get(i2);
            listenableFuture.addListener(new AppCompatTextHelper.AnonymousClass2(this, i2, listenableFuture), zztVar);
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        ArrayList arrayList = this.mFutures;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((ListenableFuture) obj).cancel(z);
            }
        }
        return this.mResult.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return (List) this.mResult.get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.mResult.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        ArrayList arrayList = this.mFutures;
        ListenableFuture listenableFuture = this.mResult;
        if (arrayList != null && !listenableFuture.isDone()) {
            int size = arrayList.size();
            int i = 0;
            loop0: while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ListenableFuture listenableFuture2 = (ListenableFuture) obj;
                while (!listenableFuture2.isDone()) {
                    try {
                        listenableFuture2.get();
                    } catch (Error e) {
                        throw e;
                    } catch (InterruptedException e2) {
                        throw e2;
                    } catch (Throwable unused) {
                        if (this.mAllMustSucceed) {
                            return (List) listenableFuture.get();
                        }
                    }
                }
            }
        }
        return (List) listenableFuture.get();
    }
}
