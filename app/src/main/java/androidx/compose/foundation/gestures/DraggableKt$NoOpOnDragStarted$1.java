package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt$NoOpOnDragStarted$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DraggableKt$NoOpOnDragStarted$1(int i, Continuation continuation, int i2) {
        super(i, continuation);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.$r8$classId) {
            case 0:
                long j = ((Offset) obj2).packedValue;
                new DraggableKt$NoOpOnDragStarted$1(3, (Continuation) obj3, 0);
                Unit unit = Unit.INSTANCE;
                ResultKt.throwOnFailure(unit);
                return unit;
            case 1:
                ((Number) obj2).floatValue();
                new DraggableKt$NoOpOnDragStarted$1(3, (Continuation) obj3, 1);
                Unit unit2 = Unit.INSTANCE;
                ResultKt.throwOnFailure(unit2);
                return unit2;
            default:
                long j2 = ((Offset) obj2).packedValue;
                new DraggableKt$NoOpOnDragStarted$1(3, (Continuation) obj3, 2);
                Unit unit3 = Unit.INSTANCE;
                ResultKt.throwOnFailure(unit3);
                return unit3;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                break;
        }
        return Unit.INSTANCE;
    }
}
