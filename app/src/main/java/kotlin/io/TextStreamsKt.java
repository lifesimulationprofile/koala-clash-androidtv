package kotlin.io;

import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.Futures$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextStreamsKt {
    public static final ArrayList readLines(InputStreamReader inputStreamReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 8192);
        try {
            Iterator it = new ConstrainedOnceSequence(new LinesSequence(0, bufferedReader)).iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
                Unit unit = Unit.INSTANCE;
            }
            Unit unit2 = Unit.INSTANCE;
            bufferedReader.close();
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static CallbackToFutureAdapter.SafeFuture surfaceListWithTimeout(ArrayList arrayList, SequentialExecutor sequentialExecutor, HandlerScheduledExecutorService handlerScheduledExecutorService) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(Futures.nonCancellationPropagating(((DeferrableSurface) obj).getSurface()));
        }
        return CallbackToFutureAdapter.getFuture(new PreviewView$1$$ExternalSyntheticLambda2(CallbackToFutureAdapter.getFuture(new Futures$$ExternalSyntheticLambda0(new ListFuture(new ArrayList(arrayList2), false, HexFormatKt.directExecutor()), handlerScheduledExecutorService, 5000L)), sequentialExecutor, arrayList));
    }
}
