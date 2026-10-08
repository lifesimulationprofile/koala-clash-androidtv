package androidx.navigation.compose;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.DragGestureNode;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.lifecycle.Lifecycle;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostKt$NavHost$28$1 extends SuspendLambda implements Function2 {
    public Object $currentBackStack$delegate;
    public final /* synthetic */ Object $progress$delegate;
    public final /* synthetic */ int $r8$classId;
    public Object $transitionState;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$28$1(AppCompatActivity appCompatActivity, MutableState mutableState, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$transitionState = appCompatActivity;
        this.$progress$delegate = mutableState;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0091  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dc A[Catch: all -> 0x0023, Exception -> 0x0026, Merged into TryCatch #0 {all -> 0x0023, Exception -> 0x0026, blocks: (B:9:0x001e, B:60:0x0132, B:62:0x0138, B:63:0x0140, B:18:0x0039, B:46:0x00cd, B:47:0x00d6, B:49:0x00dc, B:53:0x010c, B:55:0x0110, B:56:0x0117, B:21:0x0046, B:42:0x00aa, B:24:0x004e, B:35:0x008d, B:38:0x0092, B:25:0x0052, B:31:0x0074, B:28:0x0064), top: B:69:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0110 A[Catch: all -> 0x0023, Exception -> 0x0026, Merged into TryCatch #0 {all -> 0x0023, Exception -> 0x0026, blocks: (B:9:0x001e, B:60:0x0132, B:62:0x0138, B:63:0x0140, B:18:0x0039, B:46:0x00cd, B:47:0x00d6, B:49:0x00dc, B:53:0x010c, B:55:0x0110, B:56:0x0117, B:21:0x0046, B:42:0x00aa, B:24:0x004e, B:35:0x008d, B:38:0x0092, B:25:0x0052, B:31:0x0074, B:28:0x0064), top: B:69:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0126, code lost:
    
        if (com.github.kr328.clash.compose.proxy.ProxyViewModel.access$reloadAllGroups(r0, r13) == r10) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object invokeSuspend$com$github$kr328$clash$compose$proxy$ProxyViewModel$load$1(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$28$1.invokeSuspend$com$github$kr328$clash$compose$proxy$ProxyViewModel$load$1(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    /* JADX WARN: Type inference failed for: r1v15, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new NavHostKt$NavHost$28$1((SeekableTransitionState) this.$transitionState, (MutableState) this.$currentBackStack$delegate, (ParcelableSnapshotMutableFloatState) this.$progress$delegate, continuation, 0);
            case 1:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$1 = new NavHostKt$NavHost$28$1((Transition) this.$progress$delegate, (MutableState) this.$currentBackStack$delegate, continuation);
                navHostKt$NavHost$28$1.$transitionState = obj;
                return navHostKt$NavHost$28$1;
            case 2:
                return new NavHostKt$NavHost$28$1((Lifecycle) this.$progress$delegate, continuation, 2);
            case 3:
                return new NavHostKt$NavHost$28$1((MutableInteractionSourceImpl) this.$transitionState, (PressInteraction.Cancel) this.$currentBackStack$delegate, (DisposableHandle) this.$progress$delegate, continuation, 3);
            case 4:
                return new NavHostKt$NavHost$28$1((MutableInteractionSourceImpl) this.$transitionState, (Interaction) this.$currentBackStack$delegate, (DisposableHandle) this.$progress$delegate, continuation, 4);
            case 5:
                return new NavHostKt$NavHost$28$1((Function2) this.$transitionState, this.$currentBackStack$delegate, (CoroutineScope) this.$progress$delegate, continuation, 5);
            case 6:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$2 = new NavHostKt$NavHost$28$1((Function0) this.$currentBackStack$delegate, (Function2) this.$progress$delegate, continuation, 6);
                navHostKt$NavHost$28$2.$transitionState = obj;
                return navHostKt$NavHost$28$2;
            case 7:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$3 = new NavHostKt$NavHost$28$1((NodeChain) this.$progress$delegate, continuation, (Function3) this.$currentBackStack$delegate);
                navHostKt$NavHost$28$3.$transitionState = obj;
                return navHostKt$NavHost$28$3;
            case 8:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$4 = new NavHostKt$NavHost$28$1((Function4) this.$currentBackStack$delegate, (NodeChain) this.$progress$delegate, continuation, 8);
                navHostKt$NavHost$28$4.$transitionState = obj;
                return navHostKt$NavHost$28$4;
            case 9:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$5 = new NavHostKt$NavHost$28$1((DefaultScrollableState) this.$currentBackStack$delegate, (Function2) this.$progress$delegate, continuation, 9);
                navHostKt$NavHost$28$5.$transitionState = obj;
                return navHostKt$NavHost$28$5;
            case 10:
                return new NavHostKt$NavHost$28$1((DefaultScrollableState) this.$transitionState, (MutatePriority) this.$currentBackStack$delegate, (Function2) this.$progress$delegate, continuation, 10);
            case 11:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$6 = new NavHostKt$NavHost$28$1((DragGestureNode.AnonymousClass1) this.$currentBackStack$delegate, (ScrollingLogic) this.$progress$delegate, continuation, 11);
                navHostKt$NavHost$28$6.$transitionState = obj;
                return navHostKt$NavHost$28$6;
            case 12:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$7 = new NavHostKt$NavHost$28$1((ScrollingLogic) this.$currentBackStack$delegate, (Function2) this.$progress$delegate, continuation, 12);
                navHostKt$NavHost$28$7.$transitionState = obj;
                return navHostKt$NavHost$28$7;
            case 13:
                return new NavHostKt$NavHost$28$1((TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1) this.$transitionState, (PressGestureScopeImpl) this.$currentBackStack$delegate, (PointerInputChange) this.$progress$delegate, continuation, 13);
            case 14:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$8 = new NavHostKt$NavHost$28$1((Job) this.$currentBackStack$delegate, (Function2) this.$progress$delegate, continuation);
                navHostKt$NavHost$28$8.$transitionState = obj;
                return navHostKt$NavHost$28$8;
            case 15:
                return new NavHostKt$NavHost$28$1((BringIntoViewResponderNode) this.$transitionState, (NodeCoordinator) this.$currentBackStack$delegate, (DialogHostKt$DialogHost$1$1$1) this.$progress$delegate, continuation, 15);
            case 16:
                return new NavHostKt$NavHost$28$1((TextContextMenuToolbarHandlerNode) this.$currentBackStack$delegate, (TextContextMenuProvider) this.$progress$delegate, continuation, 16);
            case 17:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$9 = new NavHostKt$NavHost$28$1((State) this.$currentBackStack$delegate, (Animatable) this.$progress$delegate, continuation, 17);
                navHostKt$NavHost$28$9.$transitionState = obj;
                return navHostKt$NavHost$28$9;
            case 18:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$10 = new NavHostKt$NavHost$28$1((Function0) this.$currentBackStack$delegate, (Animatable) this.$progress$delegate, continuation, 18);
                navHostKt$NavHost$28$10.$transitionState = obj;
                return navHostKt$NavHost$28$10;
            case 19:
                return new NavHostKt$NavHost$28$1((MutableStateFlow) this.$currentBackStack$delegate, (TooltipStateImpl) this.$progress$delegate, continuation, 19);
            case 20:
                return new NavHostKt$NavHost$28$1((FocusStateImpl) this.$transitionState, (MutableState) this.$currentBackStack$delegate, (TooltipStateImpl) this.$progress$delegate, continuation, 20);
            case 21:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$11 = new NavHostKt$NavHost$28$1((Recomposer$runRecomposeAndApplyChanges$2) this.$currentBackStack$delegate, (BroadcastFrameClock) this.$progress$delegate, continuation, 21);
                navHostKt$NavHost$28$11.$transitionState = obj;
                return navHostKt$NavHost$28$11;
            case 22:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$12 = new NavHostKt$NavHost$28$1((CoroutineContext) this.$currentBackStack$delegate, (Flow) this.$progress$delegate, continuation, 22);
                navHostKt$NavHost$28$12.$transitionState = obj;
                return navHostKt$NavHost$28$12;
            case 23:
                return new NavHostKt$NavHost$28$1((BufferedChannel) this.$progress$delegate, continuation, 23);
            case 24:
                return new NavHostKt$NavHost$28$1((CoroutineContext) this.$transitionState, (Flow) this.$currentBackStack$delegate, (ProduceStateScopeImpl) this.$progress$delegate, continuation, 24);
            case 25:
                return new NavHostKt$NavHost$28$1((AppCompatActivity) this.$transitionState, (MutableState) this.$progress$delegate, continuation, 25);
            case 26:
                return new NavHostKt$NavHost$28$1((AppCompatActivity) this.$transitionState, (MutableState) this.$progress$delegate, continuation, 26);
            case 27:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$13 = new NavHostKt$NavHost$28$1((ProcessGroup) this.$progress$delegate, continuation, 27);
                navHostKt$NavHost$28$13.$currentBackStack$delegate = obj;
                return navHostKt$NavHost$28$13;
            case 28:
                return new NavHostKt$NavHost$28$1((ProxyViewModel) this.$progress$delegate, continuation, 28);
            default:
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$14 = new NavHostKt$NavHost$28$1((ProxyViewModel) this.$currentBackStack$delegate, (String) this.$progress$delegate, continuation, 29);
                navHostKt$NavHost$28$14.$transitionState = obj;
                return navHostKt$NavHost$28$14;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((NavHostKt$NavHost$28$1) create((ProduceStateScopeImpl) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 5:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 6:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 7:
                return ((NavHostKt$NavHost$28$1) create((DefaultDraggableAnchors) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 8:
                return ((NavHostKt$NavHost$28$1) create((Pair) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 9:
                return ((NavHostKt$NavHost$28$1) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 10:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 11:
                return ((NavHostKt$NavHost$28$1) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 12:
                return ((NavHostKt$NavHost$28$1) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 13:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 14:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 15:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 16:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 17:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 18:
                return ((NavHostKt$NavHost$28$1) create((Flow) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 19:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 20:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 21:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 22:
                return ((NavHostKt$NavHost$28$1) create((ProduceStateScopeImpl) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 23:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 24:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 25:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 26:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 27:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 28:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((NavHostKt$NavHost$28$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0209  */
    /* JADX WARN: Code duplicated, block: B:112:0x0212 A[Catch: all -> 0x01e5, TryCatch #5 {all -> 0x01e5, blocks: (B:99:0x01df, B:110:0x020a, B:112:0x0212, B:113:0x021f, B:120:0x022f, B:107:0x01fd, B:122:0x0232, B:124:0x0237, B:125:0x0238, B:126:0x0239, B:106:0x01f8, B:114:0x0220, B:116:0x0226), top: B:527:0x01d3, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0226 A[Catch: all -> 0x0236, TRY_LEAVE, TryCatch #6 {, blocks: (B:114:0x0220, B:116:0x0226), top: B:528:0x0220, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0232 A[Catch: all -> 0x01e5, TryCatch #5 {all -> 0x01e5, blocks: (B:99:0x01df, B:110:0x020a, B:112:0x0212, B:113:0x021f, B:120:0x022f, B:107:0x01fd, B:122:0x0232, B:124:0x0237, B:125:0x0238, B:126:0x0239, B:106:0x01f8, B:114:0x0220, B:116:0x0226), top: B:527:0x01d3, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:270:0x0489  */
    /* JADX WARN: Code duplicated, block: B:528:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:116:0x0226, B:119:0x022e], limit reached: 535 */
    /* JADX WARN: Type inference failed for: r0v83, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v107 */
    /* JADX WARN: Type inference failed for: r2v108 */
    /* JADX WARN: Type inference failed for: r2v25, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    /* JADX WARN: Type inference failed for: r2v47, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r2v70, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v72, types: [kotlinx.coroutines.channels.BufferedChannel] */
    /* JADX WARN: Type inference failed for: r2v73, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v74, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0207 -> B:110:0x020a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0059 -> B:13:0x0036). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00af -> B:40:0x00b2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 2434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$28$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$28$1(Transition transition, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 1;
        this.$progress$delegate = transition;
        this.$currentBackStack$delegate = mutableState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$28$1(NodeChain nodeChain, Continuation continuation, Function3 function3) {
        super(2, continuation);
        this.$r8$classId = 7;
        this.$currentBackStack$delegate = (SuspendLambda) function3;
        this.$progress$delegate = nodeChain;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$28$1(Object obj, Object obj2, Object obj3, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$transitionState = obj;
        this.$currentBackStack$delegate = obj2;
        this.$progress$delegate = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$28$1(Object obj, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$currentBackStack$delegate = obj;
        this.$progress$delegate = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$28$1(Object obj, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$progress$delegate = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$28$1(Job job, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 14;
        this.$currentBackStack$delegate = job;
        this.$progress$delegate = (SuspendLambda) function2;
    }
}
