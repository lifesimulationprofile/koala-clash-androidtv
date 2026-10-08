package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TooltipStateImpl$show$cancellableShow$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TooltipStateImpl$show$cancellableShow$1(Object obj, Continuation continuation, int i) {
        super(1, continuation);
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Continuation continuation = (Continuation) obj;
        switch (this.$r8$classId) {
            case 0:
                return new TooltipStateImpl$show$cancellableShow$1((TooltipStateImpl) this.this$0, continuation, 0).invokeSuspend(Unit.INSTANCE);
            case 1:
                return new TooltipStateImpl$show$cancellableShow$1((SelectionManager) this.this$0, continuation, 1).invokeSuspend(Unit.INSTANCE);
            default:
                return new TooltipStateImpl$show$cancellableShow$1((TextFieldSelectionManager) this.this$0, continuation, 2).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) this.this$0;
                    this.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(this));
                    cancellableContinuationImpl.initCancellability();
                    MutableTransitionState mutableTransitionState = tooltipStateImpl.transition;
                    mutableTransitionState.targetState$delegate.setValue(Boolean.TRUE);
                    tooltipStateImpl.job = cancellableContinuationImpl;
                    Object result = cancellableContinuationImpl.getResult();
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (result == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                SelectionManager selectionManager = (SelectionManager) this.this$0;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Pair contextTextAndSelection$foundation = selectionManager.getContextTextAndSelection$foundation();
                    if (contextTextAndSelection$foundation != null) {
                        AnnotatedString annotatedString = (AnnotatedString) contextTextAndSelection$foundation.first;
                        long j = ((TextRange) contextTextAndSelection$foundation.second).packedValue;
                        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = selectionManager.platformSelectionBehaviors;
                        if (platformSelectionBehaviorsImpl != null) {
                            this.label = 1;
                            Object objM216onShowContextMenuOrSelectionToolbarSbBc2M = platformSelectionBehaviorsImpl.m216onShowContextMenuOrSelectionToolbarSbBc2M(annotatedString, j, this);
                            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objM216onShowContextMenuOrSelectionToolbarSbBc2M != coroutineSingletons2) {
                                objM216onShowContextMenuOrSelectionToolbarSbBc2M = Unit.INSTANCE;
                            }
                            if (objM216onShowContextMenuOrSelectionToolbarSbBc2M == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        }
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.this$0;
                int i3 = this.label;
                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    textFieldSelectionManager.textToolbarShownViaProvider = true;
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (textFieldSelectionManager.updateClipboardEntry$foundation(this) == coroutineSingletons3) {
                    return coroutineSingletons3;
                }
                Pair pairAccess$getContextTextAndSelection = TextFieldSelectionManager.access$getContextTextAndSelection(textFieldSelectionManager);
                if (pairAccess$getContextTextAndSelection != null) {
                    String str = (String) pairAccess$getContextTextAndSelection.first;
                    long j2 = ((TextRange) pairAccess$getContextTextAndSelection.second).packedValue;
                    PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl2 = textFieldSelectionManager.platformSelectionBehaviors;
                    if (platformSelectionBehaviorsImpl2 != null) {
                        this.label = 2;
                        Object objM216onShowContextMenuOrSelectionToolbarSbBc2M2 = platformSelectionBehaviorsImpl2.m216onShowContextMenuOrSelectionToolbarSbBc2M(str, j2, this);
                        if (objM216onShowContextMenuOrSelectionToolbarSbBc2M2 != coroutineSingletons3) {
                            objM216onShowContextMenuOrSelectionToolbarSbBc2M2 = Unit.INSTANCE;
                        }
                        if (objM216onShowContextMenuOrSelectionToolbarSbBc2M2 == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                    }
                }
                textFieldSelectionManager.textToolbarShownViaProvider = true;
                return Unit.INSTANCE;
        }
    }
}
