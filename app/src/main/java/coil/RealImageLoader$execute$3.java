package coil;

import android.view.View;
import android.view.textclassifier.TextClassifier;
import androidx.activity.compose.ComposePredictiveBackHandler;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableNode;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.compose.foundation.gestures.NonTouchScrollingLogic;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.foundation.style.StyleOuterNode;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.internal.ripple.AndroidRippleNode;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.InputMethodSession;
import androidx.compose.ui.platform.MotionDurationScaleImpl;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.window.PopupLayout;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import com.github.kr328.clash.AccessControlActivity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoader$execute$3 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $request;
    public int label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RealImageLoader$execute$3(TextClassifier textClassifier, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 16;
        this.this$0 = textClassifier;
        this.$request = (SuspendLambda) function2;
    }

    /* JADX WARN: Type inference failed for: r1v32, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new RealImageLoader$execute$3((RealImageLoader) this.this$0, (ImageRequest) this.$request, continuation, 0);
            case 1:
                return new RealImageLoader$execute$3((ComposePredictiveBackHandler) this.$request, continuation, 1);
            case 2:
                return new RealImageLoader$execute$3((MutableInteractionSourceImpl) this.this$0, (HoverInteraction$Enter) this.$request, continuation, 2);
            case 3:
                return new RealImageLoader$execute$3((MutableInteractionSourceImpl) this.this$0, (HoverInteraction$Exit) this.$request, continuation, 3);
            case 4:
                return new RealImageLoader$execute$3((AnchoredDraggableNode) this.this$0, (DragEvent.DragStopped) this.$request, continuation, 4);
            case 5:
                RealImageLoader$execute$3 realImageLoader$execute$3 = new RealImageLoader$execute$3((MouseWheelScrollingLogic) this.$request, continuation, 5);
                realImageLoader$execute$3.this$0 = obj;
                return realImageLoader$execute$3;
            case 6:
                return new RealImageLoader$execute$3((NonTouchScrollingLogic) this.this$0, (Function2) this.$request, continuation, 6);
            case 7:
                RealImageLoader$execute$3 realImageLoader$execute$4 = new RealImageLoader$execute$3((Channel) this.$request, continuation, 7);
                realImageLoader$execute$4.this$0 = obj;
                return realImageLoader$execute$4;
            case 8:
                return new RealImageLoader$execute$3((DragEvent.DragStopped) this.this$0, (ScrollableNode) this.$request, continuation, 8);
            case 9:
                return new RealImageLoader$execute$3((Job) this.this$0, (PressGestureScopeImpl) this.$request, continuation, 9);
            case 10:
                return new RealImageLoader$execute$3((BringIntoViewResponderNode) this.this$0, (GapComposer$$ExternalSyntheticLambda0) this.$request, continuation, 10);
            case 11:
                return new RealImageLoader$execute$3((StyleOuterNode) this.this$0, (MutableInteractionSourceImpl) this.$request, continuation, 11);
            case 12:
                return new RealImageLoader$execute$3((PointerInputScope) this.this$0, (TextFieldSelectionManager) this.$request, continuation, 12);
            case 13:
                return new RealImageLoader$execute$3((AndroidLegacyPlatformTextInputServiceAdapter) this.this$0, (ContentCaptureSessionCompat) this.$request, continuation, 13);
            case 14:
                return new RealImageLoader$execute$3((Job) this.this$0, (CursorAnimationState) this.$request, continuation, 14);
            case 15:
                return new RealImageLoader$execute$3((LegacyAdaptingPlatformTextInputModifierNode) this.this$0, (NavHostKt$NavHost$29$1) this.$request, continuation, 15);
            case 16:
                return new RealImageLoader$execute$3((TextClassifier) this.this$0, (Function2) this.$request, continuation);
            case 17:
                return new RealImageLoader$execute$3((Clipboard) this.this$0, (AnnotatedString) this.$request, continuation, 17);
            case 18:
                return new RealImageLoader$execute$3((MutableInteractionSourceImpl) this.this$0, (SnapshotStateList) this.$request, continuation, 18);
            case 19:
                return new RealImageLoader$execute$3((SnackbarHostState.SnackbarDataImpl) this.this$0, (AccessibilityManager) this.$request, continuation, 19);
            case 20:
                return new RealImageLoader$execute$3((AndroidRippleNode) this.this$0, (AnimationSpec) this.$request, continuation, 20);
            case 21:
                RealImageLoader$execute$3 realImageLoader$execute$5 = new RealImageLoader$execute$3((AndroidRippleNode) this.$request, continuation, 21);
                realImageLoader$execute$5.this$0 = obj;
                return realImageLoader$execute$5;
            case 22:
                RealImageLoader$execute$3 realImageLoader$execute$6 = new RealImageLoader$execute$3((AndroidPlatformTextInputSession) this.$request, continuation, 22);
                realImageLoader$execute$6.this$0 = obj;
                return realImageLoader$execute$6;
            case 23:
                return new RealImageLoader$execute$3((StateFlow) this.this$0, (MotionDurationScaleImpl) this.$request, continuation, 23);
            case 24:
                return new RealImageLoader$execute$3((Recomposer) this.this$0, (View) this.$request, continuation, 24);
            case 25:
                return new RealImageLoader$execute$3((ComposeScrollCaptureCallback) this.this$0, (Runnable) this.$request, continuation, 25);
            case 26:
                RealImageLoader$execute$3 realImageLoader$execute$7 = new RealImageLoader$execute$3((PopupLayout) this.$request, continuation, 26);
                realImageLoader$execute$7.this$0 = obj;
                return realImageLoader$execute$7;
            case 27:
                RealImageLoader$execute$3 realImageLoader$execute$8 = new RealImageLoader$execute$3((Function2) this.$request, continuation, 27);
                realImageLoader$execute$8.this$0 = obj;
                return realImageLoader$execute$8;
            case 28:
                RealImageLoader$execute$3 realImageLoader$execute$9 = new RealImageLoader$execute$3((AsyncImagePainter) this.$request, continuation, 28);
                realImageLoader$execute$9.this$0 = obj;
                return realImageLoader$execute$9;
            default:
                return new RealImageLoader$execute$3((AccessControlActivity) this.$request, continuation, 29);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 5:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 6:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 7:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 8:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 9:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 10:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 11:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 12:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 13:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 14:
                ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 15:
                ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 16:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 17:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 18:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 19:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 20:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 21:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 22:
                ((RealImageLoader$execute$3) create((InputMethodSession) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 23:
                ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 24:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 25:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 26:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 27:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 28:
                return ((RealImageLoader$execute$3) create((ImageRequest) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((RealImageLoader$execute$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:420:0x06ac A[Catch: all -> 0x0689, TryCatch #1 {all -> 0x0689, blocks: (B:408:0x0685, B:418:0x06a2, B:420:0x06ac, B:423:0x06b9, B:415:0x0695), top: B:515:0x067b }] */
    /* JADX WARN: Code duplicated, block: B:422:0x06b8  */
    /* JADX WARN: Code duplicated, block: B:552:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v16, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v13, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v16, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v69 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:290:0x04af -> B:292:0x04b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:427:0x06dd -> B:418:0x06a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x01a1 -> B:91:0x01a4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2126
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader$execute$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoader$execute$3(Object obj, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = obj;
        this.$request = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoader$execute$3(Object obj, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$request = obj;
    }
}
