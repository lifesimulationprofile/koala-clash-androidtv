package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.ui.geometry.Offset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableNode$onKeyEvent$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ long $scrollAmount;
    public int label;
    public final /* synthetic */ ScrollableNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableNode$onKeyEvent$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ long $scrollAmount;
        public /* synthetic */ Object L$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Continuation continuation) {
            super(2, continuation);
            this.$scrollAmount = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scrollAmount, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ResultKt.throwOnFailure(obj);
            ScrollingLogic scrollingLogic = ((ScrollingLogic$nestedScrollScope$1) this.L$0).this$0;
            scrollingLogic.m105performScroll3eAAhYA(scrollingLogic.outerStateScope, this.$scrollAmount, 1);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollableNode$onKeyEvent$1(ScrollableNode scrollableNode, long j, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = scrollableNode;
        this.$scrollAmount = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ScrollableNode$onKeyEvent$1(this.this$0, this.$scrollAmount, continuation, 0);
            case 1:
                return new ScrollableNode$onKeyEvent$1(this.this$0, this.$scrollAmount, continuation, 1);
            case 2:
                return new ScrollableNode$onKeyEvent$1(this.this$0, this.$scrollAmount, continuation, 2);
            default:
                ScrollableNode$onKeyEvent$1 scrollableNode$onKeyEvent$1 = new ScrollableNode$onKeyEvent$1(this.this$0, continuation);
                scrollableNode$onKeyEvent$1.$scrollAmount = ((Offset) obj).packedValue;
                return scrollableNode$onKeyEvent$1;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((ScrollableNode$onKeyEvent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((ScrollableNode$onKeyEvent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((ScrollableNode$onKeyEvent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                long j = ((Offset) obj).packedValue;
                ScrollableNode$onKeyEvent$1 scrollableNode$onKeyEvent$1 = new ScrollableNode$onKeyEvent$1(this.this$0, (Continuation) obj2);
                scrollableNode$onKeyEvent$1.$scrollAmount = j;
                return scrollableNode$onKeyEvent$1.invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ScrollingLogic scrollingLogic = this.this$0.scrollingLogic;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scrollAmount, null);
                    this.label = 1;
                    Object objScroll = scrollingLogic.scroll(MutatePriority.UserInput, anonymousClass1, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objScroll == coroutineSingletons) {
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
                    ScrollingLogic scrollingLogic2 = this.this$0.scrollingLogic;
                    long j = this.$scrollAmount;
                    this.label = 1;
                    Object objM104onScrollStoppedBMRW4eQ = scrollingLogic2.m104onScrollStoppedBMRW4eQ(j, false, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objM104onScrollStoppedBMRW4eQ == coroutineSingletons2) {
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
                    ScrollingLogic scrollingLogic3 = this.this$0.scrollingLogic;
                    long j2 = this.$scrollAmount;
                    this.label = 1;
                    Object objM104onScrollStoppedBMRW4eQ2 = scrollingLogic3.m104onScrollStoppedBMRW4eQ(j2, true, this);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objM104onScrollStoppedBMRW4eQ2 == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i4 = this.label;
                if (i4 != 0) {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                long j3 = this.$scrollAmount;
                ScrollingLogic scrollingLogic4 = this.this$0.scrollingLogic;
                this.label = 1;
                Object objM96access$semanticsScrollByd4ec7I = ScrollableKt.m96access$semanticsScrollByd4ec7I(scrollingLogic4, j3, this);
                CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objM96access$semanticsScrollByd4ec7I == coroutineSingletons4 ? coroutineSingletons4 : objM96access$semanticsScrollByd4ec7I;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableNode$onKeyEvent$1(ScrollableNode scrollableNode, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 3;
        this.this$0 = scrollableNode;
    }
}
