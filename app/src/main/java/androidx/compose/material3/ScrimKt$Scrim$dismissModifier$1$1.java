package androidx.compose.material3;

import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode;
import androidx.compose.foundation.text.handwriting.StylusHandwritingNode;
import androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.coroutines.JobSupport$children$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrimKt$Scrim$dismissModifier$1$1 implements PointerInputEventHandler {
    public final /* synthetic */ Object $onClick;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ScrimKt$Scrim$dismissModifier$1$1(int i, Object obj) {
        this.$r8$classId = i;
        this.$onClick = obj;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, new AppBarKt$$ExternalSyntheticLambda4(4, (Function0) this.$onClick), continuation);
                return objDetectTapGestures$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objDetectTapGestures$default : Unit.INSTANCE;
            case 1:
                Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new BasicTooltipKt$handleGestures$1.AnonymousClass1.C00021.C00031((AndroidEdgeEffectOverscrollEffect) this.$onClick, null, 1), continuation);
                return objAwaitEachGesture == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitEachGesture : Unit.INSTANCE;
            case 2:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.$onClick;
                Object objAwaitSelectionGestures = SimpleLayoutKt.awaitSelectionGestures(pointerInputScope, textFieldSelectionManager.mouseSelectionObserver, textFieldSelectionManager.touchSelectionObserver, continuation);
                return objAwaitSelectionGestures == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitSelectionGestures : Unit.INSTANCE;
            case 3:
                Object objAwaitEachGesture2 = ScrollableKt.awaitEachGesture(pointerInputScope, new SelectionGesturesKt$updateSelectionTouchMode$1$1(new JobKt__JobKt$invokeOnCompletion$1(1, (TextContextMenuGestureNode) this.$onClick, TextContextMenuGestureNode.class, "tryShowContextMenu", "tryShowContextMenu-k-4lQ0M(J)V", 0, 0, 3), null, 1), continuation);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAwaitEachGesture2 != coroutineSingletons) {
                    objAwaitEachGesture2 = Unit.INSTANCE;
                }
                return objAwaitEachGesture2 == coroutineSingletons ? objAwaitEachGesture2 : Unit.INSTANCE;
            case 4:
                Object objAwaitEachGesture3 = ScrollableKt.awaitEachGesture(pointerInputScope, new JobSupport$children$1((StylusHandwritingNode) this.$onClick, (Continuation) null, 1), continuation);
                return objAwaitEachGesture3 == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitEachGesture3 : Unit.INSTANCE;
            default:
                Object objAwaitPointerEventScope = ((SuspendingPointerInputModifierNodeImpl) pointerInputScope).awaitPointerEventScope(new SelectionGesturesKt$updateSelectionTouchMode$1$1((Function1) this.$onClick, null, 0), continuation);
                return objAwaitPointerEventScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitPointerEventScope : Unit.INSTANCE;
        }
    }
}
