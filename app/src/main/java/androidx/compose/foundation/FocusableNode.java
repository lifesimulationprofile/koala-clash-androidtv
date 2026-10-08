package androidx.compose.foundation;

import android.os.Build;
import android.view.View;
import android.view.contentcapture.ContentCaptureSession;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.collection.MutableScatterSet;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusInvalidationManager;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import androidx.tracing.TraceApi29Impl;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.core.model.Proxy;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeEffectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusableNode extends DelegatingNode implements SemanticsModifierNode, GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, TraversableNode {
    public static final GestureNode.TraverseKey TraverseKey = new GestureNode.TraverseKey();
    public final FocusTargetNode focusTargetNode;
    public FocusInteraction$Focus focusedInteraction;
    public NodeCoordinator globalLayoutCoordinates;
    public MutableInteractionSourceImpl interactionSource;
    public final Function1 onFocusChange;
    public LazyLayoutPinnableItem pinnedHandle;

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableNode$applySemantics$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0 {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, Object obj, Class cls, String str, String str2, int i2, int i3, int i4) {
            super(i, obj, cls, str, str2, i2, i3);
            this.$r8$classId = i4;
        }

        /* JADX WARN: Code duplicated, block: B:145:0x0253 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:73:0x018c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:74:0x018e A[LOOP:2: B:63:0x0154->B:74:0x018e, LOOP_END] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v16, types: [kotlin.collections.EmptyList] */
        /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Iterable, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v21, types: [java.util.ArrayList] */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            NodeChain nodeChain;
            ContentCaptureSession contentCaptureSession;
            ?? arrayList;
            List list;
            switch (this.$r8$classId) {
                case 0:
                    return Boolean.valueOf(((FocusableNode) this.receiver).focusTargetNode.m351requestFocus3ESFkO8(7));
                case 1:
                    return ((TextContextMenuDataProvider) this.receiver).data();
                case 2:
                    FocusInvalidationManager focusInvalidationManager = (FocusInvalidationManager) this.receiver;
                    MutableScatterSet mutableScatterSet = focusInvalidationManager.focusTargetNodes;
                    MutableScatterSet mutableScatterSet2 = focusInvalidationManager.focusEventNodes;
                    FocusOwnerImpl focusOwnerImpl = focusInvalidationManager.focusOwner;
                    FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
                    FocusStateImpl focusStateImpl = FocusStateImpl.Inactive;
                    if (activeFocusTargetNode == null) {
                        Object[] objArr = mutableScatterSet2.elements;
                        long[] jArr = mutableScatterSet2.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                long j = jArr[i];
                                int i2 = 8;
                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i3 = 8 - ((~(i - length)) >>> 31);
                                    int i4 = 0;
                                    while (i4 < i3) {
                                        if ((j & 255) < 128) {
                                            ((FocusEventModifierNode) objArr[(i << 3) + i4]).onFocusEvent(focusStateImpl);
                                        }
                                        j >>= i2;
                                        i4++;
                                        i2 = i2;
                                    }
                                    if (i3 == i2) {
                                        if (i != length) {
                                            i++;
                                        }
                                    }
                                } else if (i != length) {
                                    i++;
                                }
                            }
                        }
                    } else if (activeFocusTargetNode.isAttached) {
                        if (mutableScatterSet.contains(activeFocusTargetNode)) {
                            activeFocusTargetNode.invalidateFocus$ui();
                        }
                        FocusStateImpl focusState = activeFocusTargetNode.getFocusState();
                        if (!activeFocusTargetNode.node.isAttached) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }
                        Modifier.Node node = activeFocusTargetNode.node;
                        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(activeFocusTargetNode);
                        int i5 = 0;
                        while (layoutNodeRequireLayoutNode != null) {
                            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 5120) != 0) {
                                while (node != null) {
                                    int i6 = node.kindSet;
                                    if ((i6 & 5120) != 0) {
                                        if ((i6 & 1024) != 0) {
                                            i5++;
                                        }
                                        if ((node instanceof FocusEventModifierNode) && mutableScatterSet2.contains(node)) {
                                            if (i5 <= 1) {
                                                ((FocusEventModifierNode) node).onFocusEvent(focusState);
                                            } else {
                                                ((FocusEventModifierNode) node).onFocusEvent(FocusStateImpl.ActiveParent);
                                            }
                                            mutableScatterSet2.remove(node);
                                        }
                                    }
                                    node = node.parent;
                                }
                            }
                            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                            node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                        }
                        Object[] objArr2 = mutableScatterSet2.elements;
                        long[] jArr2 = mutableScatterSet2.metadata;
                        int length2 = jArr2.length - 2;
                        if (length2 >= 0) {
                            int i7 = 0;
                            while (true) {
                                long j2 = jArr2[i7];
                                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i8 = 8 - ((~(i7 - length2)) >>> 31);
                                    for (int i9 = 0; i9 < i8; i9++) {
                                        if ((j2 & 255) < 128) {
                                            ((FocusEventModifierNode) objArr2[(i7 << 3) + i9]).onFocusEvent(focusStateImpl);
                                        }
                                        j2 >>= 8;
                                    }
                                    if (i8 == 8) {
                                    }
                                }
                                if (i7 != length2) {
                                    i7++;
                                }
                            }
                        }
                    }
                    if (focusOwnerImpl.getActiveFocusTargetNode() == null || focusOwnerImpl.rootFocusNode.getFocusState() == focusStateImpl) {
                        focusOwnerImpl.clearOwnerFocus();
                    }
                    mutableScatterSet.clear();
                    mutableScatterSet2.clear();
                    focusInvalidationManager.isInvalidationScheduled = false;
                    return Unit.INSTANCE;
                case 3:
                    View view = (View) this.receiver;
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30) {
                        WindowCompat.Api30Impl.setImportantForContentCapture(view);
                    }
                    if (i10 < 29 || (contentCaptureSession = TraceApi29Impl.getContentCaptureSession(view)) == null) {
                        return null;
                    }
                    return new ContentCaptureSessionCompat(contentCaptureSession, view);
                case 4:
                    NewProfileViewModel newProfileViewModel = (NewProfileViewModel) this.receiver;
                    String string = StringsKt.trim((String) newProfileViewModel._link.getValue()).toString();
                    if (string.length() != 0) {
                        if (!NewProfileViewModel.isValidUrl(string)) {
                            newProfileViewModel._error.setValue(newProfileViewModel.app.getString(R.string.invalid_url));
                        } else if (!((Boolean) newProfileViewModel._isLoading.getValue()).booleanValue()) {
                            JobKt.launch$default(ViewModelKt.getViewModelScope(newProfileViewModel), null, new ThumbNode.AnonymousClass1(newProfileViewModel, (Continuation) null, 21), 3);
                        }
                    }
                    return Unit.INSTANCE;
                case 5:
                    ProxyViewModel proxyViewModel = (ProxyViewModel) this.receiver;
                    String str = (String) proxyViewModel._selectedGroup.getValue();
                    if (str != null) {
                        ProxyGroup proxyGroup = (ProxyGroup) ((Map) proxyViewModel._groups.getValue()).get(str);
                        if (proxyGroup == null || (list = proxyGroup.proxies) == null) {
                            arrayList = EmptyList.INSTANCE;
                        } else {
                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Proxy) it.next()).name);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj : arrayList) {
                                if (!((Set) proxyViewModel._testingProxies.getValue()).contains((String) obj)) {
                                    arrayList2.add(obj);
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                JobKt.launch$default(ViewModelKt.getViewModelScope(proxyViewModel), null, new ChannelFlow.AnonymousClass2(proxyViewModel, str, arrayList2, null, 1), 3);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 6:
                    ProxyViewModel proxyViewModel2 = (ProxyViewModel) this.receiver;
                    proxyViewModel2.getClass();
                    JobKt.launch$default(ViewModelKt.getViewModelScope(proxyViewModel2), null, new NavHostKt$NavHost$28$1(proxyViewModel2, (Continuation) null, 28), 3);
                    return Unit.INSTANCE;
                default:
                    ((HazeEffectNode) this.receiver).updateEffect();
                    return Unit.INSTANCE;
            }
        }
    }

    public FocusableNode(MutableInteractionSourceImpl mutableInteractionSourceImpl, int i, JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.onFocusChange = jobKt__JobKt$invokeOnCompletion$1;
        FocusTargetNode focusTargetNode = new FocusTargetNode(i, new FocusableNode$focusTargetNode$1(2, this, FocusableNode.class, "onFocusStateChange", "onFocusStateChange(Landroidx/compose/ui/focus/FocusState;Landroidx/compose/ui/focus/FocusState;)V", 0, 0, 0), 10);
        delegate(focusTargetNode);
        this.focusTargetNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        boolean zIsFocused = this.focusTargetNode.getFocusState().isFocused();
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.Focused;
        KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[4];
        semanticsPropertyReceiver.set(semanticsPropertyKey, Boolean.valueOf(zIsFocused));
        semanticsPropertyReceiver.set(SemanticsActions.RequestFocus, new AccessibilityAction(null, new AnonymousClass1(0, this, FocusableNode.class, "requestFocus", "requestFocus()Z", 0, 0, 0)));
    }

    public final void emitWithFallback(MutableInteractionSourceImpl mutableInteractionSourceImpl, Interaction interaction) {
        if (!this.isAttached) {
            mutableInteractionSourceImpl.tryEmit(interaction);
            return;
        }
        Job job = (Job) ((ContextScope) getCoroutineScope()).coroutineContext.get(Job.Key.$$INSTANCE);
        JobKt.launch$default(getCoroutineScope(), null, new NavHostKt$NavHost$28$1(mutableInteractionSourceImpl, interaction, job != null ? job.invokeOnCompletion(new BackHandlerKt$$ExternalSyntheticLambda2(14, mutableInteractionSourceImpl, interaction)) : null, null, 4), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return TraverseKey;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.globalLayoutCoordinates = nodeCoordinator;
        if (this.focusTargetNode.getFocusState().isFocused()) {
            boolean z = nodeCoordinator.getTail().isAttached;
            GestureNode.TraverseKey traverseKey = FocusedBoundsObserverNode.TraverseKey;
            if (!z) {
                if (this.isAttached) {
                    HitTestResultKt.findNearestAncestor(this, traverseKey);
                }
            } else {
                NodeCoordinator nodeCoordinator2 = this.globalLayoutCoordinates;
                if (nodeCoordinator2 != null && nodeCoordinator2.getTail().isAttached && this.isAttached) {
                    HitTestResultKt.findNearestAncestor(this, traverseKey);
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.observeReads(this, new Recomposer$$ExternalSyntheticLambda6(5, ref$ObjectRef, this));
        LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) ref$ObjectRef.element;
        if (this.focusTargetNode.getFocusState().isFocused()) {
            LazyLayoutPinnableItem lazyLayoutPinnableItem2 = this.pinnedHandle;
            if (lazyLayoutPinnableItem2 != null) {
                lazyLayoutPinnableItem2.release();
            }
            if (lazyLayoutPinnableItem != null) {
                lazyLayoutPinnableItem.pin();
            } else {
                lazyLayoutPinnableItem = null;
            }
            this.pinnedHandle = lazyLayoutPinnableItem;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        LazyLayoutPinnableItem lazyLayoutPinnableItem = this.pinnedHandle;
        if (lazyLayoutPinnableItem != null) {
            lazyLayoutPinnableItem.release();
        }
        this.pinnedHandle = null;
    }

    public final void update(MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        FocusInteraction$Focus focusInteraction$Focus;
        if (Intrinsics.areEqual(this.interactionSource, mutableInteractionSourceImpl)) {
            return;
        }
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.interactionSource;
        if (mutableInteractionSourceImpl2 != null && (focusInteraction$Focus = this.focusedInteraction) != null) {
            mutableInteractionSourceImpl2.tryEmit(new FocusInteraction$Unfocus(focusInteraction$Focus));
        }
        this.focusedInteraction = null;
        this.interactionSource = mutableInteractionSourceImpl;
    }
}
