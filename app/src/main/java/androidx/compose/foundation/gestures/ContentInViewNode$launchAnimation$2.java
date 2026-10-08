package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ UpdatableAnimationState $animationState;
    public final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
    public final /* synthetic */ long $viewportAdjustmentForReverseScroll;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ContentInViewNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $animationJob;
        public final /* synthetic */ Object $animationState;
        public final /* synthetic */ Object $bringIntoViewSpec;
        public final /* synthetic */ int $r8$classId = 0;
        public final /* synthetic */ long $viewportAdjustmentForReverseScroll;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, long j, Job job, Continuation continuation) {
            super(2, continuation);
            this.$animationState = updatableAnimationState;
            this.this$0 = contentInViewNode;
            this.$bringIntoViewSpec = bringIntoViewSpec;
            this.$viewportAdjustmentForReverseScroll = j;
            this.$animationJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1((UpdatableAnimationState) this.$animationState, (ContentInViewNode) this.this$0, (BringIntoViewSpec) this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll, (Job) this.$animationJob, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                default:
                    return new AnonymousClass1((PlatformSelectionBehaviorsImpl) this.L$0, (String) this.$animationState, this.$viewportAdjustmentForReverseScroll, (TextRange) this.this$0, (TextFieldSelectionManager) this.$bringIntoViewSpec, (OffsetMapping) this.$animationJob, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    return ((AnonymousClass1) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                default:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0042  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            switch (this.$r8$classId) {
                case 0:
                    BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) this.$bringIntoViewSpec;
                    ContentInViewNode contentInViewNode = (ContentInViewNode) this.this$0;
                    UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) this.$animationState;
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) this.L$0;
                        updatableAnimationState.value = ContentInViewNode.m62access$calculateScrollDeltaI_oMVgE(contentInViewNode, bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll);
                        LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1(contentInViewNode, updatableAnimationState, (Job) this.$animationJob, scrollingLogic$nestedScrollScope$1);
                        GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0 = new GapComposer$$ExternalSyntheticLambda0(contentInViewNode, updatableAnimationState, bringIntoViewSpec, 1);
                        this.label = 1;
                        Object objAnimateToZero = updatableAnimationState.animateToZero(lifecycleEffectKt$$ExternalSyntheticLambda1, gapComposer$$ExternalSyntheticLambda0, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAnimateToZero == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                default:
                    OffsetMapping offsetMapping = (OffsetMapping) this.$animationJob;
                    String str = (String) this.$animationState;
                    TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.$bringIntoViewSpec;
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) this.L$0;
                        this.label = 1;
                        platformSelectionBehaviorsImpl.getClass();
                        if (str.length() == 0) {
                            obj = null;
                        } else {
                            long j = this.$viewportAdjustmentForReverseScroll;
                            if (TextRange.m641getCollapsedimpl(j)) {
                                obj = null;
                            } else {
                                obj = JobKt.withContext(platformSelectionBehaviorsImpl.coroutineContext, new NavHostKt$NavHost$29$1(platformSelectionBehaviorsImpl, new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(j, platformSelectionBehaviorsImpl, str, null), (Continuation) null), this);
                            }
                        }
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    TextRange textRange = (TextRange) obj;
                    if (textRange == null) {
                        return Unit.INSTANCE;
                    }
                    long j2 = textRange.packedValue;
                    long jTextRange = ParagraphKt.TextRange(offsetMapping.transformedToOriginal((int) (j2 >> 32)), offsetMapping.transformedToOriginal((int) (j2 & 4294967295L)));
                    if (!TextRange.m639equalsimpl(jTextRange, (TextRange) this.this$0) && Intrinsics.areEqual(textFieldSelectionManager.getValue$foundation().annotatedString.text, str) && offsetMapping == textFieldSelectionManager.offsetMapping) {
                        textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m229createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation().annotatedString, jTextRange));
                        textFieldSelectionManager.latestSelection = new TextRange(jTextRange);
                    }
                    return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, String str, long j, TextRange textRange, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping, Continuation continuation) {
            super(2, continuation);
            this.L$0 = platformSelectionBehaviorsImpl;
            this.$animationState = str;
            this.$viewportAdjustmentForReverseScroll = j;
            this.this$0 = textRange;
            this.$bringIntoViewSpec = textFieldSelectionManager;
            this.$animationJob = offsetMapping;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = contentInViewNode;
        this.$animationState = updatableAnimationState;
        this.$bringIntoViewSpec = bringIntoViewSpec;
        this.$viewportAdjustmentForReverseScroll = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.this$0, this.$animationState, this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll, continuation);
        contentInViewNode$launchAnimation$2.L$0 = obj;
        return contentInViewNode$launchAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ContentInViewNode$launchAnimation$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ContentInViewNode contentInViewNode = this.this$0;
        Toolbar.AnonymousClass1 anonymousClass1 = contentInViewNode.bringIntoViewRequests;
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                    contentInViewNode.isAnimationRunning = true;
                    ScrollingLogic scrollingLogic = contentInViewNode.scrollingLogic;
                    MutatePriority mutatePriority = MutatePriority.Default;
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$animationState, contentInViewNode, this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll, job, null);
                    this.label = 1;
                    Object objScroll = scrollingLogic.scroll(mutatePriority, anonymousClass2, this);
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
                anonymousClass1.resumeAndRemoveAll();
                contentInViewNode.isAnimationRunning = false;
                anonymousClass1.cancelAndRemoveAll(null);
                contentInViewNode.trackingFocusedChild = false;
                return Unit.INSTANCE;
            } catch (CancellationException e) {
                throw e;
            }
        } catch (Throwable th) {
            contentInViewNode.isAnimationRunning = false;
            anonymousClass1.cancelAndRemoveAll(null);
            contentInViewNode.trackingFocusedChild = false;
            throw th;
        }
    }
}
