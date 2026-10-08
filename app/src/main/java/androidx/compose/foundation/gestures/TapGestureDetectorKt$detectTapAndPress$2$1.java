package androidx.compose.foundation.gestures;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.text.LongPressTextDragObserverKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TapGestureDetectorKt$detectTapAndPress$2$1 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Object $$this$coroutineScope;
    public final /* synthetic */ Function $onPress;
    public final /* synthetic */ Function $onTap;
    public final /* synthetic */ Object $pressScope;
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$detectTapAndPress$2$1(ImmLeaksCleaner$$ExternalSyntheticLambda0 immLeaksCleaner$$ExternalSyntheticLambda0, SheetDefaultsKt$$ExternalSyntheticLambda5 sheetDefaultsKt$$ExternalSyntheticLambda5, Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0, LongPressTextDragObserverKt$$ExternalSyntheticLambda1 longPressTextDragObserverKt$$ExternalSyntheticLambda1, Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 1;
        this.L$1 = immLeaksCleaner$$ExternalSyntheticLambda0;
        this.$$this$coroutineScope = sheetDefaultsKt$$ExternalSyntheticLambda5;
        this.$onPress = updater$$ExternalSyntheticLambda0;
        this.$onTap = longPressTextDragObserverKt$$ExternalSyntheticLambda1;
        this.$pressScope = recomposer$$ExternalSyntheticLambda0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                TapGestureDetectorKt$detectTapAndPress$2$1 tapGestureDetectorKt$detectTapAndPress$2$1 = new TapGestureDetectorKt$detectTapAndPress$2$1((CoroutineScope) this.$$this$coroutineScope, (TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1) this.$onPress, (TooltipKt$$ExternalSyntheticLambda7) this.$onTap, (PressGestureScopeImpl) this.$pressScope, continuation, 0);
                tapGestureDetectorKt$detectTapAndPress$2$1.L$0 = obj;
                return tapGestureDetectorKt$detectTapAndPress$2$1;
            case 1:
                TapGestureDetectorKt$detectTapAndPress$2$1 tapGestureDetectorKt$detectTapAndPress$2$2 = new TapGestureDetectorKt$detectTapAndPress$2$1((ImmLeaksCleaner$$ExternalSyntheticLambda0) this.L$1, (SheetDefaultsKt$$ExternalSyntheticLambda5) this.$$this$coroutineScope, (Updater$$ExternalSyntheticLambda0) this.$onPress, (LongPressTextDragObserverKt$$ExternalSyntheticLambda1) this.$onTap, (Recomposer$$ExternalSyntheticLambda0) this.$pressScope, continuation);
                tapGestureDetectorKt$detectTapAndPress$2$2.L$0 = obj;
                return tapGestureDetectorKt$detectTapAndPress$2$2;
            default:
                TapGestureDetectorKt$detectTapAndPress$2$1 tapGestureDetectorKt$detectTapAndPress$2$3 = new TapGestureDetectorKt$detectTapAndPress$2$1((BasicTextKt$$ExternalSyntheticLambda3) this.$$this$coroutineScope, (TextKt$$ExternalSyntheticLambda2) this.$onPress, (GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0) this.$onTap, (ImmLeaksCleaner$$ExternalSyntheticLambda0) this.$pressScope, continuation, 2);
                tapGestureDetectorKt$detectTapAndPress$2$3.L$0 = obj;
                return tapGestureDetectorKt$detectTapAndPress$2$3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((TapGestureDetectorKt$detectTapAndPress$2$1) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x0183  */
    /* JADX WARN: Code duplicated, block: B:68:0x018c  */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine;
        Job jobLaunch$default;
        Object objAwaitFirstDown$default;
        Object objWaitForUpOrCancellation;
        PointerInputChange pointerInputChange;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2;
        Object objAwaitFirstDown;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine3;
        Object objAwaitFirstDown$default2;
        Object objM69awaitHorizontalPointerSlopOrCancellationgDDlDlE;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine4;
        Ref$FloatRef ref$FloatRef;
        PointerInputChange pointerInputChange2;
        Object objM73horizontalDragjO51t88;
        int i = this.$r8$classId;
        Object obj2 = this.$pressScope;
        Object obj3 = this.$$this$coroutineScope;
        Function function = this.$onTap;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Function function2 = this.$onPress;
        switch (i) {
            case 0:
                CoroutineScope coroutineScope = (CoroutineScope) obj3;
                PressGestureScopeImpl pressGestureScopeImpl = (PressGestureScopeImpl) obj2;
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        jobLaunch$default = (StandaloneCoroutine) this.L$1;
                        pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objAwaitFirstDown$default = obj;
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        jobLaunch$default = (Job) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objWaitForUpOrCancellation = obj;
                    }
                    pointerInputChange = (PointerInputChange) objWaitForUpOrCancellation;
                    if (pointerInputChange == null) {
                        TapGestureDetectorKt.launchAwaitingReset$default(coroutineScope, jobLaunch$default, new TapGestureDetectorKt.AnonymousClass3(pressGestureScopeImpl, null, 1));
                    } else {
                        pointerInputChange.consume();
                        TapGestureDetectorKt.launchAwaitingReset$default(coroutineScope, jobLaunch$default, new TapGestureDetectorKt.AnonymousClass3(pressGestureScopeImpl, null, 2));
                        ((TooltipKt$$ExternalSyntheticLambda7) function).invoke(new Offset(pointerInputChange.position));
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                jobLaunch$default = JobKt.launch$default(coroutineScope, null, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl, null, 1), 1);
                this.L$0 = pointerEventHandlerCoroutine;
                this.L$1 = jobLaunch$default;
                this.label = 1;
                objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine, this, 3);
                if (objAwaitFirstDown$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) objAwaitFirstDown$default;
                pointerInputChange3.consume();
                TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1 anonymousClass1 = (TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1) function2;
                if (anonymousClass1 != TapGestureDetectorKt.NoPressGesture) {
                    TapGestureDetectorKt.launchAwaitingReset$default(coroutineScope, jobLaunch$default, new NavHostKt$NavHost$28$1(anonymousClass1, pressGestureScopeImpl, pointerInputChange3, null, 13));
                }
                this.L$0 = jobLaunch$default;
                this.L$1 = null;
                this.label = 2;
                objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation(pointerEventHandlerCoroutine, PointerEventPass.Main, this);
                if (objWaitForUpOrCancellation == coroutineSingletons) {
                    return coroutineSingletons;
                }
                pointerInputChange = (PointerInputChange) objWaitForUpOrCancellation;
                if (pointerInputChange == null) {
                    TapGestureDetectorKt.launchAwaitingReset$default(coroutineScope, jobLaunch$default, new TapGestureDetectorKt.AnonymousClass3(pressGestureScopeImpl, null, 1));
                } else {
                    pointerInputChange.consume();
                    TapGestureDetectorKt.launchAwaitingReset$default(coroutineScope, jobLaunch$default, new TapGestureDetectorKt.AnonymousClass3(pressGestureScopeImpl, null, 2));
                    ((TooltipKt$$ExternalSyntheticLambda7) function).invoke(new Offset(pointerInputChange.position));
                }
                return Unit.INSTANCE;
            case 1:
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        pointerEventHandlerCoroutine2 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objAwaitFirstDown = obj;
                    } else {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                pointerEventHandlerCoroutine2 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                this.L$0 = pointerEventHandlerCoroutine2;
                this.label = 1;
                objAwaitFirstDown = TapGestureDetectorKt.awaitFirstDown(pointerEventHandlerCoroutine2, false, PointerEventPass.Initial, this);
                if (objAwaitFirstDown == coroutineSingletons) {
                    return coroutineSingletons;
                }
                this.L$0 = null;
                this.label = 2;
                if (DragGestureDetectorKt.processDragGesture(pointerEventHandlerCoroutine2, (PointerInputChange) objAwaitFirstDown, (ImmLeaksCleaner$$ExternalSyntheticLambda0) this.L$1, (SheetDefaultsKt$$ExternalSyntheticLambda5) obj3, (Updater$$ExternalSyntheticLambda0) function2, (LongPressTextDragObserverKt$$ExternalSyntheticLambda1) function, (Recomposer$$ExternalSyntheticLambda0) obj2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return Unit.INSTANCE;
            default:
                TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = (TextKt$$ExternalSyntheticLambda2) function2;
                int i4 = this.label;
                if (i4 != 0) {
                    if (i4 == 1) {
                        pointerEventHandlerCoroutine3 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objAwaitFirstDown$default2 = obj;
                    } else {
                        if (i4 == 2) {
                            ref$FloatRef = (Ref$FloatRef) this.L$1;
                            SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine5 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine5;
                            objM69awaitHorizontalPointerSlopOrCancellationgDDlDlE = obj;
                            pointerInputChange2 = (PointerInputChange) objM69awaitHorizontalPointerSlopOrCancellationgDDlDlE;
                            if (pointerInputChange2 != null) {
                                Unit unit = Unit.INSTANCE;
                                textKt$$ExternalSyntheticLambda2.invoke(pointerInputChange2, new Float(ref$FloatRef.element));
                                long j = pointerInputChange2.id;
                                Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(5, textKt$$ExternalSyntheticLambda2);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 3;
                                objM73horizontalDragjO51t88 = DragGestureDetectorKt.m73horizontalDragjO51t88(pointerEventHandlerCoroutine4, j, recomposer$$ExternalSyntheticLambda0, this);
                                if (objM73horizontalDragjO51t88 == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        if (i4 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objM73horizontalDragjO51t88 = obj;
                    }
                    if (((Boolean) objM73horizontalDragjO51t88).booleanValue()) {
                        ((GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0) function).invoke();
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                pointerEventHandlerCoroutine3 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                this.L$0 = pointerEventHandlerCoroutine3;
                this.label = 1;
                objAwaitFirstDown$default2 = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine3, this, 2);
                if (objAwaitFirstDown$default2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                PointerInputChange pointerInputChange4 = (PointerInputChange) objAwaitFirstDown$default2;
                Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                long j2 = pointerInputChange4.id;
                int i5 = pointerInputChange4.type;
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = new Updater$$ExternalSyntheticLambda0(2, ref$FloatRef2);
                this.L$0 = pointerEventHandlerCoroutine3;
                this.L$1 = ref$FloatRef2;
                this.label = 2;
                objM69awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorKt.m69awaitHorizontalPointerSlopOrCancellationgDDlDlE(pointerEventHandlerCoroutine3, j2, i5, updater$$ExternalSyntheticLambda0, this);
                if (objM69awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutineSingletons) {
                    return coroutineSingletons;
                }
                pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                ref$FloatRef = ref$FloatRef2;
                pointerInputChange2 = (PointerInputChange) objM69awaitHorizontalPointerSlopOrCancellationgDDlDlE;
                if (pointerInputChange2 != null) {
                    Unit unit3 = Unit.INSTANCE;
                    textKt$$ExternalSyntheticLambda2.invoke(pointerInputChange2, new Float(ref$FloatRef.element));
                    long j3 = pointerInputChange2.id;
                    Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda1 = new Recomposer$$ExternalSyntheticLambda0(5, textKt$$ExternalSyntheticLambda2);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    objM73horizontalDragjO51t88 = DragGestureDetectorKt.m73horizontalDragjO51t88(pointerEventHandlerCoroutine4, j3, recomposer$$ExternalSyntheticLambda1, this);
                    if (objM73horizontalDragjO51t88 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (((Boolean) objM73horizontalDragjO51t88).booleanValue()) {
                        ((GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0) function).invoke();
                    } else {
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TapGestureDetectorKt$detectTapAndPress$2$1(Object obj, Function function, Function function2, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$$this$coroutineScope = obj;
        this.$onPress = function;
        this.$onTap = function2;
        this.$pressScope = obj2;
    }
}
