package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import com.koala.clash.R;
import java.util.Collection;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Wrapper_androidKt {
    public static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.Wrapper_androidKt$setContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final /* synthetic */ class AnonymousClass1 implements LifecycleRetainedValuesStoreOwner.FrameEndScheduler, FunctionAdapter {
        public final /* synthetic */ CompositionContext $tmp0;

        public AnonymousClass1(CompositionContext compositionContext) {
            this.$tmp0 = compositionContext;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof LifecycleRetainedValuesStoreOwner.FrameEndScheduler) && (obj instanceof FunctionAdapter)) {
                return getFunctionDelegate().equals(((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.$tmp0, CompositionContext.class, "scheduleFrameEndCallback", "scheduleFrameEndCallback(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/CancellationHandle;", 0, 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0094  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.Collection] */
    public static final WrappedComposition setContent(AbstractComposeView abstractComposeView, ComposeViewContext composeViewContext, ComposableLambdaImpl composableLambdaImpl) {
        AndroidComposeView androidComposeView;
        WrappedComposition wrappedComposition;
        Object[] objArr = 0;
        if (GlobalSnapshotManager.started.compareAndSet(false, true)) {
            BufferedChannel bufferedChannelChannel$default = ChannelKt.Channel$default(1, 0, 6);
            JobKt.launch$default(JobKt.CoroutineScope((CoroutineContext) AndroidUiDispatcher.Main$delegate.getValue()), null, new NavHostKt$NavHost$28$1((Object) bufferedChannelChannel$default, (Continuation) (objArr == true ? 1 : 0), 23), 3);
            Navigator.AnonymousClass1 anonymousClass1 = new Navigator.AnonymousClass1(21, bufferedChannelChannel$default);
            synchronized (SnapshotKt.lock) {
                SnapshotKt.globalWriteObservers = CollectionsKt.plus((Collection) SnapshotKt.globalWriteObservers, anonymousClass1);
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        }
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
            if (androidComposeView != null) {
                androidComposeView.setComposeViewContext(composeViewContext);
            }
            if (androidComposeView == null) {
                androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), composeViewContext);
                abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
            }
            androidComposeView.setComposeViewContext(composeViewContext);
            if (abstractComposeView.getComposeViewContext$ui() != null) {
                composeViewContext.incrementViewCount$ui();
                androidComposeView.setComposeViewContextIncrementedDuringInit$ui(true);
            }
            Object tag = androidComposeView.getTag(R.id.wrapped_composition_tag);
            wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
            if (wrappedComposition == null) {
                wrappedComposition = new WrappedComposition(androidComposeView, new CompositionImpl(composeViewContext.compositionContext, new MenuHostHelper(androidComposeView.getRoot())));
                androidComposeView.setTag(R.id.wrapped_composition_tag, wrappedComposition);
            }
            wrappedComposition.setContent(composableLambdaImpl);
            androidComposeView.setFrameEndScheduler$ui(new AnonymousClass1(composeViewContext.compositionContext));
            return wrappedComposition;
        }
        abstractComposeView.removeAllViews();
        androidComposeView = null;
        if (androidComposeView == null) {
            androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), composeViewContext);
            abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
        }
        androidComposeView.setComposeViewContext(composeViewContext);
        if (abstractComposeView.getComposeViewContext$ui() != null) {
            composeViewContext.incrementViewCount$ui();
            androidComposeView.setComposeViewContextIncrementedDuringInit$ui(true);
        }
        Object tag2 = androidComposeView.getTag(R.id.wrapped_composition_tag);
        if (tag2 instanceof WrappedComposition) {
        }
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, new CompositionImpl(composeViewContext.compositionContext, new MenuHostHelper(androidComposeView.getRoot())));
            androidComposeView.setTag(R.id.wrapped_composition_tag, wrappedComposition);
        }
        wrappedComposition.setContent(composableLambdaImpl);
        androidComposeView.setFrameEndScheduler$ui(new AnonymousClass1(composeViewContext.compositionContext));
        return wrappedComposition;
    }
}
