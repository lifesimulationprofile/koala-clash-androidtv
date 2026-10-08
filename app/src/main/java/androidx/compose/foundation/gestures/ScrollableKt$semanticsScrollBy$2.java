package androidx.compose.foundation.gestures;

import android.view.textclassifier.TextClassifier;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.geometry.Offset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableKt$semanticsScrollBy$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ long $offset;
    public final /* synthetic */ Object $previousValue;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $this_semanticsScrollBy;
    public Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$semanticsScrollBy$2(long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, CharSequence charSequence, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 4;
        this.$this_semanticsScrollBy = platformSelectionBehaviorsImpl;
        this.$previousValue = charSequence;
        this.$offset = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2((ScrollingLogic) this.$this_semanticsScrollBy, this.$offset, (Ref$FloatRef) this.$previousValue, continuation, 0);
                scrollableKt$semanticsScrollBy$2.L$0 = obj;
                return scrollableKt$semanticsScrollBy$2;
            case 1:
                return new ScrollableKt$semanticsScrollBy$2((Job) this.$this_semanticsScrollBy, this.$offset, (MutableInteractionSourceImpl) this.$previousValue, continuation, 1);
            case 2:
                return new ScrollableKt$semanticsScrollBy$2((MutableState) this.$this_semanticsScrollBy, this.$offset, (MutableInteractionSourceImpl) this.$previousValue, continuation, 2);
            case 3:
                return new ScrollableKt$semanticsScrollBy$2((TextContextMenuGestureNode) this.L$0, this.$offset, (TextContextMenuProvider) this.$this_semanticsScrollBy, (TextContextMenuGestureNode.ClickTextContextMenuDataProvider) this.$previousValue, continuation);
            default:
                ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$3 = new ScrollableKt$semanticsScrollBy$2(this.$offset, (PlatformSelectionBehaviorsImpl) this.$this_semanticsScrollBy, (CharSequence) this.$previousValue, continuation);
                scrollableKt$semanticsScrollBy$3.L$0 = obj;
                return scrollableKt$semanticsScrollBy$3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((ScrollableKt$semanticsScrollBy$2) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((ScrollableKt$semanticsScrollBy$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((ScrollableKt$semanticsScrollBy$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((ScrollableKt$semanticsScrollBy$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((ScrollableKt$semanticsScrollBy$2) create(AndroidAutofill$$ExternalSyntheticApiModelOutline0.m328m(obj), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v24, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PressInteraction.Release release;
        MutableState mutableState;
        PressInteraction.Press press;
        PressInteraction.Press press2;
        switch (this.$r8$classId) {
            case 0:
                ScrollingLogic scrollingLogic = (ScrollingLogic) this.$this_semanticsScrollBy;
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) this.L$0;
                    float fM107toFloatk4lQ0M = scrollingLogic.m107toFloatk4lQ0M(this.$offset);
                    MenuKt$$ExternalSyntheticLambda1 menuKt$$ExternalSyntheticLambda1 = new MenuKt$$ExternalSyntheticLambda1((Ref$FloatRef) this.$previousValue, scrollingLogic, scrollingLogic$nestedScrollScope$1, 1);
                    this.label = 1;
                    Object objAnimate = ArcSplineKt.animate(0.0f, fM107toFloatk4lQ0M, 0.0f, ArcSplineKt.spring$default(0.0f, 0.0f, null, 7), menuKt$$ExternalSyntheticLambda1, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAnimate == coroutineSingletons) {
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
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) this.$previousValue;
                int i2 = this.label;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i2 != 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else if (i2 == 2) {
                        release = (PressInteraction.Release) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = null;
                        this.label = 3;
                        if (mutableInteractionSourceImpl.emit(release, this) == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                Job job = (Job) this.$this_semanticsScrollBy;
                this.label = 1;
                if (job.join(this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                PressInteraction.Press press3 = new PressInteraction.Press(this.$offset);
                release = new PressInteraction.Release(press3);
                this.L$0 = release;
                this.label = 2;
                if (mutableInteractionSourceImpl.emit(press3, this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                this.L$0 = null;
                this.label = 3;
                if (mutableInteractionSourceImpl.emit(release, this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                return Unit.INSTANCE;
            case 2:
                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) this.$previousValue;
                MutableState mutableState2 = (MutableState) this.$this_semanticsScrollBy;
                int i3 = this.label;
                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i3 != 0) {
                    if (i3 == 1) {
                        mutableState = (MutableState) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        press2 = (PressInteraction.Press) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    press = press2;
                    mutableState2.setValue(press);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                PressInteraction.Press press4 = (PressInteraction.Press) mutableState2.getValue();
                if (press4 != null) {
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press4);
                    if (mutableInteractionSourceImpl2 != null) {
                        this.L$0 = mutableState2;
                        this.label = 1;
                        if (mutableInteractionSourceImpl2.emit(cancel, this) == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                    }
                    mutableState = mutableState2;
                } else {
                    press = new PressInteraction.Press(this.$offset);
                    if (mutableInteractionSourceImpl2 != null) {
                        this.L$0 = press;
                        this.label = 2;
                        if (mutableInteractionSourceImpl2.emit(press, this) == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                        press2 = press;
                        press = press2;
                    }
                }
                mutableState2.setValue(press);
                return Unit.INSTANCE;
                mutableState.setValue(null);
                press = new PressInteraction.Press(this.$offset);
                if (mutableInteractionSourceImpl2 != null) {
                    this.L$0 = press;
                    this.label = 2;
                    if (mutableInteractionSourceImpl2.emit(press, this) == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                    press2 = press;
                    press = press2;
                }
                mutableState2.setValue(press);
                return Unit.INSTANCE;
            case 3:
                int i4 = this.label;
                CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i4 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                ?? r10 = ((TextContextMenuGestureNode) this.L$0).onPreShowContextMenu;
                if (r10 != 0) {
                    Offset offset = new Offset(this.$offset);
                    this.label = 1;
                    if (r10.invoke(offset, this) == coroutineSingletons4) {
                        return coroutineSingletons4;
                    }
                }
                TextContextMenuProvider textContextMenuProvider = (TextContextMenuProvider) this.$this_semanticsScrollBy;
                TextContextMenuGestureNode.ClickTextContextMenuDataProvider clickTextContextMenuDataProvider = (TextContextMenuGestureNode.ClickTextContextMenuDataProvider) this.$previousValue;
                this.label = 2;
                if (textContextMenuProvider.showTextContextMenu(clickTextContextMenuDataProvider, this) == coroutineSingletons4) {
                    return coroutineSingletons4;
                }
                return Unit.INSTANCE;
            default:
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextClassifier textClassifierM328m = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m328m(this.L$0);
                    PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) this.$this_semanticsScrollBy;
                    CharSequence charSequence = (CharSequence) this.$previousValue;
                    this.label = 1;
                    Object objM215access$classifyTextM8tDOmk = PlatformSelectionBehaviorsImpl.m215access$classifyTextM8tDOmk(platformSelectionBehaviorsImpl, charSequence, this.$offset, textClassifierM328m, this);
                    CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objM215access$classifyTextM8tDOmk == coroutineSingletons5) {
                        return coroutineSingletons5;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$semanticsScrollBy$2(TextContextMenuGestureNode textContextMenuGestureNode, long j, TextContextMenuProvider textContextMenuProvider, TextContextMenuGestureNode.ClickTextContextMenuDataProvider clickTextContextMenuDataProvider, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 3;
        this.L$0 = textContextMenuGestureNode;
        this.$offset = j;
        this.$this_semanticsScrollBy = textContextMenuProvider;
        this.$previousValue = clickTextContextMenuDataProvider;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollableKt$semanticsScrollBy$2(Object obj, long j, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$this_semanticsScrollBy = obj;
        this.$offset = j;
        this.$previousValue = obj2;
    }
}
