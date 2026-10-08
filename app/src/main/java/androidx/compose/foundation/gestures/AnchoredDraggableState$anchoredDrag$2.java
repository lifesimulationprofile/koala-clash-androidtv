package androidx.compose.foundation.gestures;

import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.View;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3;
import androidx.compose.foundation.text.contextmenu.internal.FloatingTextActionModeCallback;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.node.NodeChain;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableState$anchoredDrag$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnchoredDraggableState$anchoredDrag$2(TextContextMenuProvider textContextMenuProvider, Object obj, Continuation continuation, int i) {
        super(1, continuation);
        this.$r8$classId = i;
        this.this$0 = textContextMenuProvider;
        this.$block = obj;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Continuation continuation = (Continuation) obj;
        switch (this.$r8$classId) {
            case 0:
                return new AnchoredDraggableState$anchoredDrag$2((NodeChain) this.this$0, continuation, (SuspendLambda) this.$block).invokeSuspend(Unit.INSTANCE);
            case 1:
                return new AnchoredDraggableState$anchoredDrag$2((AndroidTextContextMenuToolbarProvider) this.this$0, (TextContextMenuDataProvider) this.$block, continuation, 1).invokeSuspend(Unit.INSTANCE);
            default:
                return new AnchoredDraggableState$anchoredDrag$2((BasicTextContextMenuProvider) this.this$0, (BasicTextContextMenuProvider.SessionImpl) this.$block, continuation, 2).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl textActionModeCallbackImpl;
        switch (this.$r8$classId) {
            case 0:
                NodeChain nodeChain = (NodeChain) this.this$0;
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnchoredDraggableState$$ExternalSyntheticLambda1 anchoredDraggableState$$ExternalSyntheticLambda1 = new AnchoredDraggableState$$ExternalSyntheticLambda1(nodeChain, 1);
                    NavHostKt$NavHost$28$1 navHostKt$NavHost$28$1 = new NavHostKt$NavHost$28$1(nodeChain, (Continuation) null, (Function3) this.$block);
                    this.label = 1;
                    Object objAccess$restartable = ScrollableKt.access$restartable(anchoredDraggableState$$ExternalSyntheticLambda1, navHostKt$NavHost$28$1, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAccess$restartable == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                DefaultDraggableAnchors anchors = nodeChain.getAnchors();
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) nodeChain.head;
                Object objClosestAnchor = anchors.closestAnchor(parcelableSnapshotMutableFloatState.getFloatValue());
                if (objClosestAnchor != null) {
                    if (Math.abs(parcelableSnapshotMutableFloatState.getFloatValue() - nodeChain.getAnchors().positionOf(objClosestAnchor)) < 0.5f && ((Boolean) ((Function1) nodeChain.layoutNode).invoke(objClosestAnchor)).booleanValue()) {
                        ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).setValue(objClosestAnchor);
                        nodeChain.setCurrentValue(objClosestAnchor);
                    }
                }
                return Unit.INSTANCE;
            case 1:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = (AndroidTextContextMenuToolbarProvider) this.this$0;
                SnapshotStateObserver snapshotStateObserver = androidTextContextMenuToolbarProvider.snapshotStateObserver;
                View view = androidTextContextMenuToolbarProvider.view;
                int i2 = this.label;
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl textContextMenuSessionImpl = new AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl();
                        TextContextMenuDataProvider textContextMenuDataProvider = (TextContextMenuDataProvider) this.$block;
                        AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl textActionModeCallbackImpl2 = new AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl(textContextMenuSessionImpl, new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(androidTextContextMenuToolbarProvider, textContextMenuDataProvider, 0), new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(androidTextContextMenuToolbarProvider, textContextMenuDataProvider, 1), view);
                        Function1 function1 = androidTextContextMenuToolbarProvider.callbackInjector;
                        if (function1 != null && (textActionModeCallbackImpl = (AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl) function1.invoke(textActionModeCallbackImpl2)) != null) {
                            textActionModeCallbackImpl2 = textActionModeCallbackImpl;
                        }
                        Looper looperMyLooper = Looper.myLooper();
                        Handler handler = view.getHandler();
                        if (looperMyLooper != (handler != null ? handler.getLooper() : null)) {
                            LiveDataObservable$$ExternalSyntheticLambda1 liveDataObservable$$ExternalSyntheticLambda1 = androidTextContextMenuToolbarProvider.startActionModeRunnable;
                            if (liveDataObservable$$ExternalSyntheticLambda1 == null) {
                                liveDataObservable$$ExternalSyntheticLambda1 = new LiveDataObservable$$ExternalSyntheticLambda1(androidTextContextMenuToolbarProvider, textActionModeCallbackImpl2, textContextMenuSessionImpl, 10);
                                androidTextContextMenuToolbarProvider.startActionModeRunnable = liveDataObservable$$ExternalSyntheticLambda1;
                            }
                            view.post(liveDataObservable$$ExternalSyntheticLambda1);
                        } else {
                            ActionMode actionModeStartActionMode = view.startActionMode(new FloatingTextActionModeCallback(textActionModeCallbackImpl2), 1);
                            if (actionModeStartActionMode == null) {
                                return Unit.INSTANCE;
                            }
                            androidTextContextMenuToolbarProvider.actionMode = actionModeStartActionMode;
                        }
                        this.label = 1;
                        Object objReceive = textContextMenuSessionImpl.channel.receive(this);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objReceive != coroutineSingletons2) {
                            objReceive = Unit.INSTANCE;
                        }
                        if (objReceive == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    snapshotStateObserver.clear();
                    Looper looperMyLooper2 = Looper.myLooper();
                    Handler handler2 = view.getHandler();
                    if (looperMyLooper2 != (handler2 != null ? handler2.getLooper() : null)) {
                        Runnable preview$$ExternalSyntheticLambda0 = androidTextContextMenuToolbarProvider.finishActionModeRunnable;
                        if (preview$$ExternalSyntheticLambda0 == null) {
                            preview$$ExternalSyntheticLambda0 = new Preview$$ExternalSyntheticLambda0(24, androidTextContextMenuToolbarProvider);
                            androidTextContextMenuToolbarProvider.finishActionModeRunnable = preview$$ExternalSyntheticLambda0;
                        }
                        view.post(preview$$ExternalSyntheticLambda0);
                    } else {
                        ActionMode actionMode = androidTextContextMenuToolbarProvider.actionMode;
                        if (actionMode != null) {
                            actionMode.finish();
                        }
                    }
                    LiveDataObservable$$ExternalSyntheticLambda1 liveDataObservable$$ExternalSyntheticLambda2 = androidTextContextMenuToolbarProvider.startActionModeRunnable;
                    if (liveDataObservable$$ExternalSyntheticLambda2 != null) {
                        view.removeCallbacks(liveDataObservable$$ExternalSyntheticLambda2);
                    }
                    androidTextContextMenuToolbarProvider.actionMode = null;
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    snapshotStateObserver.clear();
                    Looper looperMyLooper3 = Looper.myLooper();
                    Handler handler3 = view.getHandler();
                    if (looperMyLooper3 != (handler3 != null ? handler3.getLooper() : null)) {
                        Runnable preview$$ExternalSyntheticLambda1 = androidTextContextMenuToolbarProvider.finishActionModeRunnable;
                        if (preview$$ExternalSyntheticLambda1 == null) {
                            preview$$ExternalSyntheticLambda1 = new Preview$$ExternalSyntheticLambda0(24, androidTextContextMenuToolbarProvider);
                            androidTextContextMenuToolbarProvider.finishActionModeRunnable = preview$$ExternalSyntheticLambda1;
                        }
                        view.post(preview$$ExternalSyntheticLambda1);
                    } else {
                        ActionMode actionMode2 = androidTextContextMenuToolbarProvider.actionMode;
                        if (actionMode2 != null) {
                            actionMode2.finish();
                        }
                    }
                    LiveDataObservable$$ExternalSyntheticLambda1 liveDataObservable$$ExternalSyntheticLambda3 = androidTextContextMenuToolbarProvider.startActionModeRunnable;
                    if (liveDataObservable$$ExternalSyntheticLambda3 != null) {
                        view.removeCallbacks(liveDataObservable$$ExternalSyntheticLambda3);
                    }
                    androidTextContextMenuToolbarProvider.actionMode = null;
                    throw th;
                }
            default:
                BasicTextContextMenuProvider.SessionImpl sessionImpl = (BasicTextContextMenuProvider.SessionImpl) this.$block;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = ((BasicTextContextMenuProvider) this.this$0).session$delegate;
                int i3 = this.label;
                try {
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcelableSnapshotMutableState.setValue(sessionImpl);
                        this.label = 1;
                        Object objReceive2 = sessionImpl.channel.receive(this);
                        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objReceive2 != coroutineSingletons3) {
                            objReceive2 = Unit.INSTANCE;
                        }
                        if (objReceive2 == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    parcelableSnapshotMutableState.setValue(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    parcelableSnapshotMutableState.setValue(null);
                    throw th2;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState$anchoredDrag$2(NodeChain nodeChain, Continuation continuation, Function3 function3) {
        super(1, continuation);
        this.$r8$classId = 0;
        this.this$0 = nodeChain;
        this.$block = (SuspendLambda) function3;
    }
}
