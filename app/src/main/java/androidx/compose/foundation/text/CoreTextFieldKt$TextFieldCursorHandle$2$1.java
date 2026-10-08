package androidx.compose.foundation.text;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import coil.RealImageLoader$execute$3;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt$TextFieldCursorHandle$2$1 implements PointerInputEventHandler {
    public final /* synthetic */ Object $manager;
    public final /* synthetic */ Object $observer;
    public final /* synthetic */ int $r8$classId;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ TextFieldSelectionManager $manager;
        public final /* synthetic */ TextDragObserver $observer;
        public final /* synthetic */ PointerInputScope $this_pointerInput;
        public /* synthetic */ Object L$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class C00001 extends SuspendLambda implements Function2 {
            public final /* synthetic */ TextDragObserver $observer;
            public final /* synthetic */ int $r8$classId;
            public final /* synthetic */ PointerInputScope $this_pointerInput;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C00001(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation, int i) {
                super(2, continuation);
                this.$r8$classId = i;
                this.$this_pointerInput = pointerInputScope;
                this.$observer = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                switch (this.$r8$classId) {
                    case 0:
                        return new C00001(this.$this_pointerInput, this.$observer, continuation, 0);
                    case 1:
                        return new C00001(this.$this_pointerInput, this.$observer, continuation, 1);
                    default:
                        return new C00001(this.$this_pointerInput, this.$observer, continuation, 2);
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
                return ((C00001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i = this.$r8$classId;
                TextDragObserver textDragObserver = this.$observer;
                PointerInputScope pointerInputScope = this.$this_pointerInput;
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                int i2 = 1;
                switch (i) {
                    case 0:
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (BasicTextKt.detectDownAndDragGesturesWithObserver(pointerInputScope, textDragObserver, this) == obj2) {
                                return obj2;
                            }
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        int i4 = this.label;
                        if (i4 == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new ForEachGestureKt$awaitEachGesture$2(textDragObserver, (Continuation) null, 3), this);
                            if (objAwaitEachGesture != obj2) {
                                objAwaitEachGesture = Unit.INSTANCE;
                            }
                            if (objAwaitEachGesture == obj2) {
                                return obj2;
                            }
                        } else {
                            if (i4 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    default:
                        int i5 = this.label;
                        if (i5 == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            LongPressTextDragObserverKt$$ExternalSyntheticLambda0 longPressTextDragObserverKt$$ExternalSyntheticLambda0 = new LongPressTextDragObserverKt$$ExternalSyntheticLambda0(textDragObserver, 0);
                            LongPressTextDragObserverKt$$ExternalSyntheticLambda1 longPressTextDragObserverKt$$ExternalSyntheticLambda1 = new LongPressTextDragObserverKt$$ExternalSyntheticLambda1(textDragObserver, 0);
                            LongPressTextDragObserverKt$$ExternalSyntheticLambda1 longPressTextDragObserverKt$$ExternalSyntheticLambda2 = new LongPressTextDragObserverKt$$ExternalSyntheticLambda1(textDragObserver, 1);
                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = new Updater$$ExternalSyntheticLambda0(9, textDragObserver);
                            float f = DragGestureDetectorKt.mouseToTouchSlopRatio;
                            Object objAwaitEachGesture2 = ScrollableKt.awaitEachGesture(pointerInputScope, new TapGestureDetectorKt$detectTapAndPress$2$1(new ImmLeaksCleaner$$ExternalSyntheticLambda0(9), new SheetDefaultsKt$$ExternalSyntheticLambda5(i2, longPressTextDragObserverKt$$ExternalSyntheticLambda0), updater$$ExternalSyntheticLambda0, longPressTextDragObserverKt$$ExternalSyntheticLambda2, new Recomposer$$ExternalSyntheticLambda0(4, longPressTextDragObserverKt$$ExternalSyntheticLambda1), (Continuation) null), this);
                            if (objAwaitEachGesture2 != obj2) {
                                objAwaitEachGesture2 = Unit.INSTANCE;
                            }
                            if (objAwaitEachGesture2 != obj2) {
                                objAwaitEachGesture2 = Unit.INSTANCE;
                            }
                            if (objAwaitEachGesture2 != obj2) {
                                objAwaitEachGesture2 = Unit.INSTANCE;
                            }
                            if (objAwaitEachGesture2 == obj2) {
                                return obj2;
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, TextFieldSelectionManager textFieldSelectionManager, Continuation continuation) {
            super(2, continuation);
            this.$this_pointerInput = pointerInputScope;
            this.$observer = textDragObserver;
            this.$manager = textFieldSelectionManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$observer, this.$manager, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PointerInputScope pointerInputScope = this.$this_pointerInput;
            Continuation continuation = null;
            JobKt.launch$default(coroutineScope, null, new C00001(pointerInputScope, this.$observer, continuation, 0), 1);
            JobKt.launch$default(coroutineScope, null, new RealImageLoader$execute$3(pointerInputScope, this.$manager, continuation, 12), 1);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ CoreTextFieldKt$TextFieldCursorHandle$2$1(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.$observer = obj;
        this.$manager = obj2;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Object objCoroutineScope = JobKt.coroutineScope(new AnonymousClass1(pointerInputScope, (TextDragObserver) this.$observer, (TextFieldSelectionManager) this.$manager, null), continuation);
                return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
            default:
                Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new ForEachGestureKt$awaitEachGesture$2((SelectionManager) this.$observer, (SelectionManager$$ExternalSyntheticLambda0) this.$manager, null, 4), continuation);
                return objAwaitEachGesture == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitEachGesture : Unit.INSTANCE;
        }
    }
}
