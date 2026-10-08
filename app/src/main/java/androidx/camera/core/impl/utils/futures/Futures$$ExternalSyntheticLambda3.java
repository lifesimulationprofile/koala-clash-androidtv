package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.gms.tasks.zzt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Futures$$ExternalSyntheticLambda3 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ListenableFuture f$0;

    public /* synthetic */ Futures$$ExternalSyntheticLambda3(ListenableFuture listenableFuture, int i) {
        this.$r8$classId = i;
        this.f$0 = listenableFuture;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.$r8$classId) {
            case 0:
                Preview$$ExternalSyntheticLambda0 preview$$ExternalSyntheticLambda0 = new Preview$$ExternalSyntheticLambda0(17, completer);
                zzt zztVarDirectExecutor = HexFormatKt.directExecutor();
                ListenableFuture listenableFuture = this.f$0;
                listenableFuture.addListener(preview$$ExternalSyntheticLambda0, zztVarDirectExecutor);
                return "transformVoidFuture [" + listenableFuture + "]";
            default:
                zzt zztVarDirectExecutor2 = HexFormatKt.directExecutor();
                ListenableFuture listenableFuture2 = this.f$0;
                Futures.propagateTransform(false, listenableFuture2, completer, zztVarDirectExecutor2);
                return "nonCancellationPropagating[" + listenableFuture2 + "]";
        }
    }
}
