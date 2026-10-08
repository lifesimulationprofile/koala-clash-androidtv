package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import coil.intercept.EngineInterceptor;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BasicTextContextMenuProvider implements TextContextMenuProvider {
    public final ComposableLambdaImpl contextMenuBlock;
    public final MutatorMutex mutatorMutex = new MutatorMutex();
    public final ParcelableSnapshotMutableState session$delegate = Stack.mutableStateOf$default(null);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SessionImpl implements TextContextMenuSession {
        public final BufferedChannel channel = ChannelKt.Channel$default(0, 0, 7);
        public final TextContextMenuDataProvider dataProvider;

        public SessionImpl(TextContextMenuDataProvider textContextMenuDataProvider) {
            this.dataProvider = textContextMenuDataProvider;
        }

        @Override // androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession
        public final void close() {
            this.channel.mo842trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    public BasicTextContextMenuProvider(ComposableLambdaImpl composableLambdaImpl) {
        this.contextMenuBlock = composableLambdaImpl;
    }

    public final void ContextMenu(final Function0 function0, GapComposer gapComposer, final int i) {
        final Function0 function1;
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(723898654);
        int i2 = (gapComposer.changed(this) ? 32 : 16) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            SessionImpl sessionImpl = (SessionImpl) this.session$delegate.getValue();
            if (sessionImpl == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final int i3 = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2(this, function0, i, i3) { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider$$ExternalSyntheticLambda0
                        public final /* synthetic */ int $r8$classId;
                        public final /* synthetic */ BasicTextContextMenuProvider f$0;
                        public final /* synthetic */ Function0 f$1;

                        {
                            this.$r8$classId = i3;
                            this.f$0 = this;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            int i4 = this.$r8$classId;
                            GapComposer gapComposer3 = (GapComposer) obj;
                            ((Integer) obj2).getClass();
                            switch (i4) {
                                case 0:
                                    this.f$0.ContextMenu(this.f$1, gapComposer3, Stack.updateChangedFlags(7));
                                    break;
                                default:
                                    this.f$0.ContextMenu(this.f$1, gapComposer3, Stack.updateChangedFlags(7));
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    return;
                }
                return;
            }
            function1 = function0;
            gapComposer2 = gapComposer;
            this.contextMenuBlock.invoke((Object) sessionImpl, (Object) sessionImpl.dataProvider, (Object) function1, (Object) gapComposer2, (Object) 384);
        } else {
            function1 = function0;
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final int i4 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(this, function1, i, i4) { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider$$ExternalSyntheticLambda0
                public final /* synthetic */ int $r8$classId;
                public final /* synthetic */ BasicTextContextMenuProvider f$0;
                public final /* synthetic */ Function0 f$1;

                {
                    this.$r8$classId = i4;
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int i5 = this.$r8$classId;
                    GapComposer gapComposer3 = (GapComposer) obj;
                    ((Integer) obj2).getClass();
                    switch (i5) {
                        case 0:
                            this.f$0.ContextMenu(this.f$1, gapComposer3, Stack.updateChangedFlags(7));
                            break;
                        default:
                            this.f$0.ContextMenu(this.f$1, gapComposer3, Stack.updateChangedFlags(7));
                            break;
                    }
                    return Unit.INSTANCE;
                }
            };
        }
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider
    public final Object showTextContextMenu(TextContextMenuDataProvider textContextMenuDataProvider, SuspendLambda suspendLambda) {
        AnchoredDraggableState$anchoredDrag$2 anchoredDraggableState$anchoredDrag$2 = new AnchoredDraggableState$anchoredDrag$2(this, new SessionImpl(textContextMenuDataProvider), null, 2);
        MutatorMutex mutatorMutex = this.mutatorMutex;
        mutatorMutex.getClass();
        Object objCoroutineScope = JobKt.coroutineScope(new EngineInterceptor.AnonymousClass2(MutatePriority.Default, mutatorMutex, anchoredDraggableState$anchoredDrag$2, null), suspendLambda);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }
}
