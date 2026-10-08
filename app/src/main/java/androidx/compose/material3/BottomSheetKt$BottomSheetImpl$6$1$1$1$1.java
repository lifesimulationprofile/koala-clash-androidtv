package androidx.compose.material3;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetKt$BottomSheetImpl$6$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SheetState $state;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomSheetKt$BottomSheetImpl$6$1$1$1$1(SheetState sheetState, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$state = sheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 0);
            case 1:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 1);
            case 2:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 2);
            case 3:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 3);
            case 4:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 4);
            case 5:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 5);
            case 6:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 6);
            case 7:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 7);
            case 8:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 8);
            case 9:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 9);
            case 10:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 10);
            case 11:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 11);
            case 12:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 12);
            case 13:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 13);
            default:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(this.$state, continuation, 14);
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
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
        }
        return ((BottomSheetKt$BottomSheetImpl$6$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objExpand = this.$state.expand(this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objExpand == coroutineSingletons) {
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
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objPartialExpand = this.$state.partialExpand(this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objPartialExpand == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 2:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objHide = this.$state.hide(this);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHide == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 3:
                int i4 = this.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objShow = this.$state.show(this);
                    CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objShow == coroutineSingletons4) {
                        return coroutineSingletons4;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 4:
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objExpand2 = this.$state.expand(this);
                    CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objExpand2 == coroutineSingletons5) {
                        return coroutineSingletons5;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 5:
                int i6 = this.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objPartialExpand2 = this.$state.partialExpand(this);
                    CoroutineSingletons coroutineSingletons6 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objPartialExpand2 == coroutineSingletons6) {
                        return coroutineSingletons6;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 6:
                int i7 = this.label;
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objHide2 = this.$state.hide(this);
                    CoroutineSingletons coroutineSingletons7 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHide2 == coroutineSingletons7) {
                        return coroutineSingletons7;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 7:
                int i8 = this.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objShow2 = this.$state.show(this);
                    CoroutineSingletons coroutineSingletons8 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objShow2 == coroutineSingletons8) {
                        return coroutineSingletons8;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 8:
                int i9 = this.label;
                if (i9 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objHide3 = this.$state.hide(this);
                    CoroutineSingletons coroutineSingletons9 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHide3 == coroutineSingletons9) {
                        return coroutineSingletons9;
                    }
                } else {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 9:
                int i10 = this.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objPartialExpand3 = this.$state.partialExpand(this);
                    CoroutineSingletons coroutineSingletons10 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objPartialExpand3 == coroutineSingletons10) {
                        return coroutineSingletons10;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 10:
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objHide4 = this.$state.hide(this);
                    CoroutineSingletons coroutineSingletons11 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHide4 == coroutineSingletons11) {
                        return coroutineSingletons11;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 11:
                int i12 = this.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objHide5 = this.$state.hide(this);
                    CoroutineSingletons coroutineSingletons12 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHide5 == coroutineSingletons12) {
                        return coroutineSingletons12;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 12:
                int i13 = this.label;
                if (i13 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objHide6 = this.$state.hide(this);
                    CoroutineSingletons coroutineSingletons13 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHide6 == coroutineSingletons13) {
                        return coroutineSingletons13;
                    }
                } else {
                    if (i13 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 13:
                int i14 = this.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objHide7 = this.$state.hide(this);
                    CoroutineSingletons coroutineSingletons14 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHide7 == coroutineSingletons14) {
                        return coroutineSingletons14;
                    }
                } else {
                    if (i14 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i15 = this.label;
                if (i15 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objHide8 = this.$state.hide(this);
                    CoroutineSingletons coroutineSingletons15 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHide8 == coroutineSingletons15) {
                        return coroutineSingletons15;
                    }
                } else {
                    if (i15 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
