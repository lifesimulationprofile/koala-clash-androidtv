package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.JobKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.JsonElementMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FocusableNode$focusTargetNode$1 extends FunctionReferenceImpl implements Function2 {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusableNode$focusTargetNode$1(int i, Object obj, Class cls, String str, String str2, int i2, int i3, int i4) {
        super(i, obj, cls, str, str2, i2, i3);
        this.$r8$classId = i4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean zIsFocused;
        switch (this.$r8$classId) {
            case 0:
                FocusStateImpl focusStateImpl = (FocusStateImpl) obj;
                FocusStateImpl focusStateImpl2 = (FocusStateImpl) obj2;
                FocusableNode focusableNode = (FocusableNode) this.receiver;
                if (focusableNode.isAttached && (zIsFocused = focusStateImpl2.isFocused()) != focusStateImpl.isFocused()) {
                    Function1 function1 = focusableNode.onFocusChange;
                    if (function1 != null) {
                        function1.invoke(Boolean.valueOf(zIsFocused));
                    }
                    GestureNode.TraverseKey traverseKey = FocusedBoundsObserverNode.TraverseKey;
                    Continuation continuation = null;
                    if (zIsFocused) {
                        JobKt.launch$default(focusableNode.getCoroutineScope(), null, new ThumbNode.AnonymousClass1(focusableNode, continuation, 3), 3);
                        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        HitTestResultKt.observeReads(focusableNode, new Recomposer$$ExternalSyntheticLambda6(5, ref$ObjectRef, focusableNode));
                        LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) ref$ObjectRef.element;
                        if (lazyLayoutPinnableItem != null) {
                            lazyLayoutPinnableItem.pin();
                        } else {
                            lazyLayoutPinnableItem = null;
                        }
                        focusableNode.pinnedHandle = lazyLayoutPinnableItem;
                        NodeCoordinator nodeCoordinator = focusableNode.globalLayoutCoordinates;
                        if (nodeCoordinator != null && nodeCoordinator.getTail().isAttached && focusableNode.isAttached) {
                            HitTestResultKt.findNearestAncestor(focusableNode, traverseKey);
                        }
                    } else {
                        LazyLayoutPinnableItem lazyLayoutPinnableItem2 = focusableNode.pinnedHandle;
                        if (lazyLayoutPinnableItem2 != null) {
                            lazyLayoutPinnableItem2.release();
                        }
                        focusableNode.pinnedHandle = null;
                        if (focusableNode.isAttached) {
                            HitTestResultKt.findNearestAncestor(focusableNode, traverseKey);
                        }
                    }
                    HitTestResultKt.invalidateSemantics(focusableNode);
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = focusableNode.interactionSource;
                    if (mutableInteractionSourceImpl != null) {
                        if (zIsFocused) {
                            FocusInteraction$Focus focusInteraction$Focus = focusableNode.focusedInteraction;
                            if (focusInteraction$Focus != null) {
                                focusableNode.emitWithFallback(mutableInteractionSourceImpl, new FocusInteraction$Unfocus(focusInteraction$Focus));
                                focusableNode.focusedInteraction = null;
                            }
                            FocusInteraction$Focus focusInteraction$Focus2 = new FocusInteraction$Focus();
                            focusableNode.emitWithFallback(mutableInteractionSourceImpl, focusInteraction$Focus2);
                            focusableNode.focusedInteraction = focusInteraction$Focus2;
                        } else {
                            FocusInteraction$Focus focusInteraction$Focus3 = focusableNode.focusedInteraction;
                            if (focusInteraction$Focus3 != null) {
                                focusableNode.emitWithFallback(mutableInteractionSourceImpl, new FocusInteraction$Unfocus(focusInteraction$Focus3));
                                focusableNode.focusedInteraction = null;
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            default:
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                int iIntValue = ((Number) obj2).intValue();
                JsonElementMarker jsonElementMarker = (JsonElementMarker) this.receiver;
                jsonElementMarker.getClass();
                boolean z = !serialDescriptor.isElementOptional(iIntValue) && serialDescriptor.getElementDescriptor(iIntValue).isNullable();
                jsonElementMarker.isUnmarkedNull = z;
                return Boolean.valueOf(z);
        }
    }
}
