package coil.compose;

import kotlin.Function;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AsyncImagePainter$onRemembered$1$1$3 implements FlowCollector, FunctionAdapter {
    public final /* synthetic */ AsyncImagePainter $tmp0;

    public AsyncImagePainter$onRemembered$1$1$3(AsyncImagePainter asyncImagePainter) {
        this.$tmp0 = asyncImagePainter;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.$tmp0.updateState((AsyncImagePainter.State) obj);
        return Unit.INSTANCE;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
            return getFunctionDelegate().equals(((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return new AdaptedFunctionReference(2, 4, AsyncImagePainter.class, this.$tmp0, "updateState", "updateState(Lcoil/compose/AsyncImagePainter$State;)V");
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
