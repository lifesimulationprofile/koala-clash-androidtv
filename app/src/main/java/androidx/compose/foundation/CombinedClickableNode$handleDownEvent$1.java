package androidx.compose.foundation;

import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CombinedClickableNode$handleDownEvent$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ CombinedClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CombinedClickableNode$handleDownEvent$1(CombinedClickableNode combinedClickableNode, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = combinedClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new CombinedClickableNode$handleDownEvent$1(this.this$0, continuation, 0);
            case 1:
                return new CombinedClickableNode$handleDownEvent$1(this.this$0, continuation, 1);
            default:
                return new CombinedClickableNode$handleDownEvent$1(this.this$0, continuation, 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((CombinedClickableNode$handleDownEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                CombinedClickableNode combinedClickableNode = this.this$0;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long longPressTimeoutMillis = ((ViewConfiguration) HitTestResultKt.currentValueOf(combinedClickableNode, CompositionLocalsKt.LocalViewConfiguration)).getLongPressTimeoutMillis();
                    this.label = 1;
                    Object objDelay = JobKt.delay(longPressTimeoutMillis, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objDelay == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Function0 function0 = combinedClickableNode.onLongClick;
                if (function0 != null) {
                    function0.invoke();
                }
                if (combinedClickableNode.hapticFeedbackEnabled) {
                    ((PlatformHapticFeedback) ((HapticFeedback) HitTestResultKt.currentValueOf(combinedClickableNode, CompositionLocalsKt.LocalHapticFeedback))).m503performHapticFeedbackCdsT49E(0);
                }
                combinedClickableNode.longPressTriggered = true;
                StandaloneCoroutine standaloneCoroutine = combinedClickableNode.tapJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel((CancellationException) null);
                }
                combinedClickableNode.tapJob = null;
                combinedClickableNode.longPressJob = null;
                return Unit.INSTANCE;
            case 1:
                int i2 = this.label;
                CombinedClickableNode combinedClickableNode2 = this.this$0;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    long longPressTimeoutMillis2 = ((ViewConfiguration) HitTestResultKt.currentValueOf(combinedClickableNode2, CompositionLocalsKt.LocalViewConfiguration)).getLongPressTimeoutMillis();
                    this.label = 1;
                    Object objDelay2 = JobKt.delay(longPressTimeoutMillis2, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objDelay2 == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Function0 function1 = combinedClickableNode2.onLongClick;
                if (function1 != null) {
                    function1.invoke();
                }
                if (combinedClickableNode2.hapticFeedbackEnabled) {
                    ((PlatformHapticFeedback) ((HapticFeedback) HitTestResultKt.currentValueOf(combinedClickableNode2, CompositionLocalsKt.LocalHapticFeedback))).m503performHapticFeedbackCdsT49E(0);
                }
                combinedClickableNode2.indirectLongPressTriggered = true;
                StandaloneCoroutine standaloneCoroutine2 = combinedClickableNode2.indirectTapJob;
                if (standaloneCoroutine2 != null) {
                    standaloneCoroutine2.cancel((CancellationException) null);
                }
                combinedClickableNode2.indirectTapJob = null;
                combinedClickableNode2.indirectLongPressJob = null;
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                CombinedClickableNode combinedClickableNode3 = this.this$0;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    long longPressTimeoutMillis3 = ((ViewConfiguration) HitTestResultKt.currentValueOf(combinedClickableNode3, CompositionLocalsKt.LocalViewConfiguration)).getLongPressTimeoutMillis();
                    this.label = 1;
                    Object objDelay3 = JobKt.delay(longPressTimeoutMillis3, this);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objDelay3 == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Function0 function2 = combinedClickableNode3.onLongClick;
                if (function2 != null) {
                    function2.invoke();
                }
                return Unit.INSTANCE;
        }
    }
}
