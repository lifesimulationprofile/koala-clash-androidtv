package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1 implements PointerInputEventHandler {
    public final /* synthetic */ TextDragObserver $observer;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1(TextDragObserver textDragObserver, int i) {
        this.$r8$classId = i;
        this.$observer = textDragObserver;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Object objDetectDownAndDragGesturesWithObserver = BasicTextKt.detectDownAndDragGesturesWithObserver(pointerInputScope, this.$observer, continuation);
                return objDetectDownAndDragGesturesWithObserver == CoroutineSingletons.COROUTINE_SUSPENDED ? objDetectDownAndDragGesturesWithObserver : Unit.INSTANCE;
            default:
                Object objDetectDownAndDragGesturesWithObserver2 = BasicTextKt.detectDownAndDragGesturesWithObserver(pointerInputScope, this.$observer, continuation);
                return objDetectDownAndDragGesturesWithObserver2 == CoroutineSingletons.COROUTINE_SUSPENDED ? objDetectDownAndDragGesturesWithObserver2 : Unit.INSTANCE;
        }
    }
}
