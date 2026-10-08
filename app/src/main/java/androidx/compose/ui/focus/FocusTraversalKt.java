package androidx.compose.ui.focus;

import androidx.camera.view.PreviewView;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsState;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsProviderModifierNode;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout$BeyondBoundsScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope$record$1;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import coil.network.HttpException;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FocusTraversalKt {
    /* JADX WARN: Code duplicated, block: B:38:0x007c A[RETURN] */
    public static final boolean backwardFocusSearch(FocusTargetNode focusTargetNode, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        int iOrdinal = focusTargetNode.getFocusState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild == null) {
                    throw new IllegalStateException("ActiveParent must have a focusedChild");
                }
                int iOrdinal2 = activeChild.getFocusState().ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        if (backwardFocusSearch(activeChild, layoutNodeDrawScope$record$1) || m356generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 2, layoutNodeDrawScope$record$1) || (activeChild.fetchFocusProperties$ui().canFocus && ((Boolean) layoutNodeDrawScope$record$1.invoke(activeChild)).booleanValue())) {
                            return true;
                        }
                        return false;
                    }
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 != 3) {
                            throw new HttpException();
                        }
                        throw new IllegalStateException("ActiveParent must have a focusedChild");
                    }
                }
                return m356generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 2, layoutNodeDrawScope$record$1);
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new HttpException();
                }
                if (!pickChildForBackwardSearch(focusTargetNode, layoutNodeDrawScope$record$1)) {
                    if (!(focusTargetNode.fetchFocusProperties$ui().canFocus ? ((Boolean) layoutNodeDrawScope$record$1.invoke(focusTargetNode)).booleanValue() : false)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return pickChildForBackwardSearch(focusTargetNode, layoutNodeDrawScope$record$1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (r11 >= r2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r10 <= r7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r9 >= r6) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (r8 <= r5) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        if (r21 != 3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        if (r21 != 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (r21 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        r1 = r11 - r19.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r21 != 4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        r1 = r19.left - r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        if (r21 != 5) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        r1 = r9 - r19.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
    
        if (r21 != 6) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
    
        r1 = r19.top - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        if (r1 >= 0.0f) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
    
        r1 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
    
        if (r21 != 3) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
    
        r11 = r11 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        if (r21 != 4) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        r11 = r2 - r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
    
        if (r21 != 5) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007c, code lost:
    
        r11 = r9 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007f, code lost:
    
        if (r21 != 6) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
    
        r11 = r6 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0087, code lost:
    
        if (r11 >= 1.0f) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
    
        r11 = 1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:
    
        if (r1 >= r11) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0095, code lost:
    
        throw new java.lang.IllegalStateException("This function should only be used for 2-D focus search");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009b, code lost:
    
        throw new java.lang.IllegalStateException("This function should only be used for 2-D focus search");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009c, code lost:
    
        return true;
     */
    /* JADX INFO: renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean m352beamBeatsI7lrPNg(androidx.compose.ui.geometry.Rect r18, androidx.compose.ui.geometry.Rect r19, androidx.compose.ui.geometry.Rect r20, int r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            boolean r4 = beamBeats_I7lrPNg$inSourceBeam(r3, r2, r0)
            float r5 = r2.top
            float r6 = r2.bottom
            float r7 = r2.left
            float r2 = r2.right
            float r8 = r0.bottom
            float r9 = r0.top
            float r10 = r0.right
            float r11 = r0.left
            r12 = 0
            if (r4 != 0) goto La3
            boolean r0 = beamBeats_I7lrPNg$inSourceBeam(r3, r1, r0)
            if (r0 != 0) goto L27
            goto La3
        L27:
            java.lang.String r4 = "This function should only be used for 2-D focus search"
            r13 = 6
            r14 = 5
            r15 = 4
            r18 = 1
            r0 = 3
            if (r3 != r0) goto L36
            int r16 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r16 < 0) goto L9c
            goto L4a
        L36:
            if (r3 != r15) goto L3d
            int r16 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r16 > 0) goto L9c
            goto L4a
        L3d:
            if (r3 != r14) goto L44
            int r16 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r16 < 0) goto L9c
            goto L4a
        L44:
            if (r3 != r13) goto L9d
            int r16 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r16 > 0) goto L9c
        L4a:
            if (r3 != r0) goto L4d
            goto L4f
        L4d:
            if (r3 != r15) goto L50
        L4f:
            return r18
        L50:
            if (r3 != r0) goto L57
            float r1 = r1.right
            float r1 = r11 - r1
            goto L69
        L57:
            if (r3 != r15) goto L5d
            float r1 = r1.left
            float r1 = r1 - r10
            goto L69
        L5d:
            if (r3 != r14) goto L64
            float r1 = r1.bottom
            float r1 = r9 - r1
            goto L69
        L64:
            if (r3 != r13) goto L96
            float r1 = r1.top
            float r1 = r1 - r8
        L69:
            r16 = 0
            int r17 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r17 >= 0) goto L71
            r1 = r16
        L71:
            if (r3 != r0) goto L75
            float r11 = r11 - r7
            goto L83
        L75:
            if (r3 != r15) goto L7a
            float r11 = r2 - r10
            goto L83
        L7a:
            if (r3 != r14) goto L7f
            float r11 = r9 - r5
            goto L83
        L7f:
            if (r3 != r13) goto L90
            float r11 = r6 - r8
        L83:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r11 = r0
        L8a:
            int r0 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r0 >= 0) goto L8f
            return r18
        L8f:
            return r12
        L90:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r4)
            throw r0
        L96:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r4)
            throw r0
        L9c:
            return r18
        L9d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r4)
            throw r0
        La3:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.m352beamBeatsI7lrPNg(androidx.compose.ui.geometry.Rect, androidx.compose.ui.geometry.Rect, androidx.compose.ui.geometry.Rect, int):boolean");
    }

    public static final boolean beamBeats_I7lrPNg$inSourceBeam(int i, Rect rect, Rect rect2) {
        if (i == 3 || i == 4) {
            return rect.bottom > rect2.top && rect.top < rect2.bottom;
        }
        if (i == 5 || i == 6) {
            return rect.right > rect2.left && rect.left < rect2.right;
        }
        throw new IllegalStateException("This function should only be used for 2-D focus search");
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z) {
        int iOrdinal = focusTargetNode.getFocusState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (!(activeChild != null ? clearFocus(activeChild, z) : true)) {
                    return false;
                }
                focusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                return true;
            }
            if (iOrdinal == 2) {
                return z;
            }
            if (iOrdinal != 3) {
                throw new HttpException();
            }
        }
        return true;
    }

    public static final void collectAccessibleChildren(FocusTargetNode focusTargetNode, MutableVector mutableVector) {
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, node);
        } else {
            mutableVector2.add(node2);
        }
        while (true) {
            int i = mutableVector2.size;
            if (i == 0) {
                return;
            }
            Modifier.Node nodeAccess$pop = (Modifier.Node) mutableVector2.removeAt(i - 1);
            if ((nodeAccess$pop.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, nodeAccess$pop);
            } else {
                while (nodeAccess$pop != null) {
                    if ((nodeAccess$pop.kindSet & 1024) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeAccess$pop;
                                if (focusTargetNode2.isAttached && !HitTestResultKt.requireLayoutNode(focusTargetNode2).isDeactivated) {
                                    if (focusTargetNode2.fetchFocusProperties$ui().canFocus) {
                                        mutableVector.add(focusTargetNode2);
                                    } else {
                                        collectAccessibleChildren(focusTargetNode2, mutableVector);
                                    }
                                }
                            } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodeAccess$pop = node3;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop != null) {
                                                mutableVector3.add(nodeAccess$pop);
                                                nodeAccess$pop = null;
                                            }
                                            mutableVector3.add(node3);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector3);
                        }
                        break;
                    }
                    nodeAccess$pop = nodeAccess$pop.child;
                }
            }
        }
    }

    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeFocusTargetNode = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode();
        if (activeFocusTargetNode == null || !activeFocusTargetNode.isAttached) {
            return null;
        }
        return activeFocusTargetNode;
    }

    /* JADX INFO: renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    public static final FocusTargetNode m353findBestCandidate4WY_MpI(MutableVector mutableVector, Rect rect, int i) {
        Rect rectTranslate;
        if (i == 3) {
            rectTranslate = rect.translate((rect.right - rect.left) + 1, 0.0f);
        } else if (i == 4) {
            rectTranslate = rect.translate(-((rect.right - rect.left) + 1), 0.0f);
        } else if (i == 5) {
            rectTranslate = rect.translate(0.0f, (rect.bottom - rect.top) + 1);
        } else {
            if (i != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            rectTranslate = rect.translate(0.0f, -((rect.bottom - rect.top) + 1));
        }
        Object[] objArr = mutableVector.content;
        int i2 = mutableVector.size;
        FocusTargetNode focusTargetNode = null;
        for (int i3 = 0; i3 < i2; i3++) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[i3];
            if (isEligibleForFocusSearch(focusTargetNode2)) {
                Rect rectFocusRect = focusRect(focusTargetNode2);
                if (m357isBetterCandidateI7lrPNg(rectFocusRect, rectTranslate, rect, i)) {
                    focusTargetNode = focusTargetNode2;
                    rectTranslate = rectFocusRect;
                }
            }
        }
        return focusTargetNode;
    }

    /* JADX INFO: renamed from: findChildCorrespondingToFocusEnter--OM-vw8, reason: not valid java name */
    public static final boolean m354findChildCorrespondingToFocusEnterOMvw8(FocusTargetNode focusTargetNode, int i, Function1 function1) {
        Rect rect;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16]);
        collectAccessibleChildren(focusTargetNode, mutableVector);
        int i2 = mutableVector.size;
        if (i2 <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (i2 == 0 ? null : mutableVector.content[0]);
            if (focusTargetNode2 != null) {
                return ((Boolean) function1.invoke(focusTargetNode2)).booleanValue();
            }
        } else {
            if (i == 7) {
                i = 4;
            }
            if (i == 4 || i == 6) {
                Rect rectFocusRect = focusRect(focusTargetNode);
                float f = rectFocusRect.left;
                float f2 = rectFocusRect.top;
                rect = new Rect(f, f2, f, f2);
            } else {
                if (i != 3 && i != 5) {
                    throw new IllegalStateException("This function should only be used for 2-D focus search");
                }
                Rect rectFocusRect2 = focusRect(focusTargetNode);
                float f3 = rectFocusRect2.right;
                float f4 = rectFocusRect2.bottom;
                rect = new Rect(f3, f4, f3, f4);
            }
            FocusTargetNode focusTargetNodeM353findBestCandidate4WY_MpI = m353findBestCandidate4WY_MpI(mutableVector, rect, i);
            if (focusTargetNodeM353findBestCandidate4WY_MpI != null) {
                return ((Boolean) function1.invoke(focusTargetNodeM353findBestCandidate4WY_MpI)).booleanValue();
            }
        }
        return false;
    }

    public static final Modifier focusProperties(Modifier modifier, Function1 function1) {
        return modifier.then(new FocusPropertiesElement(new FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0(function1)));
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        NodeCoordinator nodeCoordinator;
        if (focusTargetNode.isAttached && (nodeCoordinator = focusTargetNode.coordinator) != null) {
            LayoutCoordinates layoutCoordinatesFindRootCoordinates = RulerKt.findRootCoordinates(nodeCoordinator);
            if (!layoutCoordinatesFindRootCoordinates.isAttached()) {
                layoutCoordinatesFindRootCoordinates = null;
            }
            if (layoutCoordinatesFindRootCoordinates != null) {
                return focusTargetNode.fetchFocusRect$ui(layoutCoordinatesFindRootCoordinates);
            }
        }
        return Rect.Zero;
    }

    public static final Modifier focusRequester(Modifier modifier, FocusRequester focusRequester) {
        return modifier.then(new FocusRequesterElement(focusRequester));
    }

    public static final boolean forwardFocusSearch(FocusTargetNode focusTargetNode, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        int iOrdinal = focusTargetNode.getFocusState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild != null) {
                    return forwardFocusSearch(activeChild, layoutNodeDrawScope$record$1) || m356generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 1, layoutNodeDrawScope$record$1);
                }
                throw new IllegalStateException("ActiveParent must have a focusedChild");
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return focusTargetNode.fetchFocusProperties$ui().canFocus ? ((Boolean) layoutNodeDrawScope$record$1.invoke(focusTargetNode)).booleanValue() : pickChildForForwardSearch(focusTargetNode, layoutNodeDrawScope$record$1);
                }
                throw new HttpException();
            }
        }
        return pickChildForForwardSearch(focusTargetNode, layoutNodeDrawScope$record$1);
    }

    /* JADX INFO: renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m356generateAndSearchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        if (m363searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, i, layoutNodeDrawScope$record$1)) {
            return true;
        }
        Boolean bool = (Boolean) m361searchBeyondBoundsOMvw8(focusTargetNode, i, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1(((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode(), focusTargetNode, focusTargetNode2, i, layoutNodeDrawScope$record$1, 0));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final FocusTargetNode getActiveChild(FocusTargetNode focusTargetNode) {
        boolean z = focusTargetNode.node.isAttached;
        if (z) {
            if (!z) {
                InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
            }
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node = focusTargetNode.node;
            Modifier.Node node2 = node.child;
            if (node2 == null) {
                HitTestResultKt.access$addLayoutNodeChildren(mutableVector, node);
            } else {
                mutableVector.add(node2);
            }
            while (true) {
                int i = mutableVector.size;
                if (i == 0) {
                    break;
                }
                Modifier.Node nodeAccess$pop = (Modifier.Node) mutableVector.removeAt(i - 1);
                if ((nodeAccess$pop.aggregateChildKindSet & 1024) == 0) {
                    HitTestResultKt.access$addLayoutNodeChildren(mutableVector, nodeAccess$pop);
                } else {
                    while (nodeAccess$pop != null) {
                        if ((nodeAccess$pop.kindSet & 1024) != 0) {
                            MutableVector mutableVector2 = null;
                            while (nodeAccess$pop != null) {
                                if (nodeAccess$pop instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeAccess$pop;
                                    if (focusTargetNode2.node.isAttached) {
                                        int iOrdinal = focusTargetNode2.getFocusState().ordinal();
                                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
                                            return focusTargetNode2;
                                        }
                                        if (iOrdinal != 3) {
                                            throw new HttpException();
                                        }
                                    }
                                } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                        if ((node3.kindSet & 1024) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodeAccess$pop = node3;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodeAccess$pop != null) {
                                                    mutableVector2.add(nodeAccess$pop);
                                                    nodeAccess$pop = null;
                                                }
                                                mutableVector2.add(node3);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodeAccess$pop = HitTestResultKt.access$pop(mutableVector2);
                            }
                            break;
                        }
                        nodeAccess$pop = nodeAccess$pop.child;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    public static final boolean m357isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(i, rect, rect3)) {
            return false;
        }
        if (isBetterCandidate_I7lrPNg$isCandidate(i, rect2, rect3) && !m352beamBeatsI7lrPNg(rect3, rect, rect2, i)) {
            return !m352beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2);
        }
        return true;
    }

    public static final boolean isBetterCandidate_I7lrPNg$isCandidate(int i, Rect rect, Rect rect2) {
        if (i == 3) {
            float f = rect2.right;
            float f2 = rect2.left;
            float f3 = rect.right;
            return (f > f3 || f2 >= f3) && f2 > rect.left;
        }
        if (i == 4) {
            float f4 = rect2.left;
            float f5 = rect2.right;
            float f6 = rect.left;
            return (f4 < f6 || f5 <= f6) && f5 < rect.right;
        }
        if (i == 5) {
            float f7 = rect2.bottom;
            float f8 = rect2.top;
            float f9 = rect.bottom;
            return (f7 > f9 || f8 >= f9) && f8 > rect.top;
        }
        if (i != 6) {
            throw new IllegalStateException("This function should only be used for 2-D focus search");
        }
        float f10 = rect2.top;
        float f11 = rect2.bottom;
        float f12 = rect.top;
        return (f10 < f12 || f11 <= f12) && f11 < rect.bottom;
    }

    public static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        if (i == 3) {
            f = rect.left;
            f2 = rect2.right;
        } else if (i == 4) {
            f = rect2.left;
            f2 = rect.right;
        } else if (i == 5) {
            f = rect.top;
            f2 = rect2.bottom;
        } else {
            if (i != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            f = rect2.top;
            f2 = rect.bottom;
        }
        float f7 = f - f2;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        long j = (long) f7;
        if (i == 3 || i == 4) {
            float f8 = rect.top;
            f3 = 2;
            f4 = ((rect.bottom - f8) / f3) + f8;
            f5 = rect2.top;
            f6 = rect2.bottom;
        } else {
            if (i != 5 && i != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            float f9 = rect.left;
            f3 = 2;
            f4 = ((rect.right - f9) / f3) + f9;
            f5 = rect2.left;
            f6 = rect2.right;
        }
        long j2 = (long) (f4 - (((f6 - f5) / f3) + f5));
        return (j2 * j2) + (((long) 13) * j * j);
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator nodeCoordinator;
        LayoutNode layoutNode2;
        NodeCoordinator nodeCoordinator2 = focusTargetNode.coordinator;
        return (nodeCoordinator2 == null || (layoutNode = nodeCoordinator2.layoutNode) == null || !layoutNode.isPlaced() || (nodeCoordinator = focusTargetNode.coordinator) == null || (layoutNode2 = nodeCoordinator.layoutNode) == null || !layoutNode2.isAttached()) ? false : true;
    }

    public static final Modifier onFocusChanged(Modifier modifier, Function1 function1) {
        return modifier.then(new FocusChangedElement(function1));
    }

    /* JADX INFO: renamed from: performCustomClearFocus-Mxy_nc0, reason: not valid java name */
    public static final int m358performCustomClearFocusMxy_nc0(FocusTargetNode focusTargetNode) {
        int iOrdinal = focusTargetNode.getFocusState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild == null) {
                    throw new IllegalArgumentException("ActiveParent with no focused child");
                }
                int iM358performCustomClearFocusMxy_nc0 = m358performCustomClearFocusMxy_nc0(activeChild);
                if (iM358performCustomClearFocusMxy_nc0 == 1) {
                    iM358performCustomClearFocusMxy_nc0 = 0;
                }
                if (iM358performCustomClearFocusMxy_nc0 != 0) {
                    return iM358performCustomClearFocusMxy_nc0;
                }
                if (!focusTargetNode.isProcessingCustomExit) {
                    focusTargetNode.isProcessingCustomExit = true;
                    try {
                        FocusPropertiesImpl focusPropertiesImplFetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
                        FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner();
                        FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
                        focusPropertiesImplFetchFocusProperties$ui.onExit.getClass();
                        Unit unit = Unit.INSTANCE;
                        FocusTargetNode activeFocusTargetNode2 = focusOwnerImpl.getActiveFocusTargetNode();
                        if (activeFocusTargetNode == activeFocusTargetNode2 || activeFocusTargetNode2 == null) {
                            focusTargetNode.isProcessingCustomExit = false;
                            return 1;
                        }
                        if (FocusRequester.Redirect == FocusRequester.Cancel) {
                            focusTargetNode.isProcessingCustomExit = false;
                            return 2;
                        }
                        focusTargetNode.isProcessingCustomExit = false;
                        return 3;
                    } catch (Throwable th) {
                        focusTargetNode.isProcessingCustomExit = false;
                        throw th;
                    }
                }
            } else {
                if (iOrdinal == 2) {
                    return 2;
                }
                if (iOrdinal != 3) {
                    throw new HttpException();
                }
            }
        }
        return 1;
    }

    /* JADX INFO: renamed from: performCustomEnter-Mxy_nc0, reason: not valid java name */
    public static final int m359performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusPropertiesImpl focusPropertiesImplFetchFocusProperties$ui = focusTargetNode.fetchFocusProperties$ui();
                FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
                focusPropertiesImplFetchFocusProperties$ui.onEnter.getClass();
                Unit unit = Unit.INSTANCE;
                FocusTargetNode activeFocusTargetNode2 = focusOwnerImpl.getActiveFocusTargetNode();
                if (activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null) {
                    if (FocusRequester.Redirect == FocusRequester.Cancel) {
                        focusTargetNode.isProcessingCustomEnter = false;
                        return 2;
                    }
                    focusTargetNode.isProcessingCustomEnter = false;
                    return 3;
                }
                focusTargetNode.isProcessingCustomEnter = false;
            } catch (Throwable th) {
                focusTargetNode.isProcessingCustomEnter = false;
                throw th;
            }
        }
        return 1;
    }

    /* JADX INFO: renamed from: performCustomRequestFocus-Mxy_nc0, reason: not valid java name */
    public static final int m360performCustomRequestFocusMxy_nc0(FocusTargetNode focusTargetNode) {
        Modifier.Node node;
        NodeChain nodeChain;
        int iOrdinal = focusTargetNode.getFocusState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild != null) {
                    return m358performCustomClearFocusMxy_nc0(activeChild);
                }
                throw new IllegalArgumentException("ActiveParent with no focused child");
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new HttpException();
                }
                if (!focusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node2 = focusTargetNode.node.parent;
                LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                loop0: while (true) {
                    node = null;
                    if (layoutNodeRequireLayoutNode == null) {
                        break;
                    }
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                        while (node2 != null) {
                            if ((node2.kindSet & 1024) != 0) {
                                Modifier.Node nodeAccess$pop = node2;
                                MutableVector mutableVector = null;
                                while (nodeAccess$pop != null) {
                                    if (nodeAccess$pop instanceof FocusTargetNode) {
                                        node = nodeAccess$pop;
                                        break loop0;
                                    }
                                    if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                        int i = 0;
                                        for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                            if ((node3.kindSet & 1024) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    nodeAccess$pop = node3;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodeAccess$pop != null) {
                                                        mutableVector.add(nodeAccess$pop);
                                                        nodeAccess$pop = null;
                                                    }
                                                    mutableVector.add(node3);
                                                }
                                            }
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                                }
                            }
                            node2 = node2.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                    node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                }
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                if (focusTargetNode2 != null) {
                    int iOrdinal2 = focusTargetNode2.getFocusState().ordinal();
                    if (iOrdinal2 == 0) {
                        return m359performCustomEnterMxy_nc0(focusTargetNode2);
                    }
                    if (iOrdinal2 == 1) {
                        return m360performCustomRequestFocusMxy_nc0(focusTargetNode2);
                    }
                    if (iOrdinal2 == 2) {
                        return 2;
                    }
                    if (iOrdinal2 != 3) {
                        throw new HttpException();
                    }
                    int iM360performCustomRequestFocusMxy_nc0 = m360performCustomRequestFocusMxy_nc0(focusTargetNode2);
                    int i2 = iM360performCustomRequestFocusMxy_nc0 != 1 ? iM360performCustomRequestFocusMxy_nc0 : 0;
                    return i2 == 0 ? m359performCustomEnterMxy_nc0(focusTargetNode2) : i2;
                }
            }
        }
        return 1;
    }

    public static final boolean pickChildForBackwardSearch(FocusTargetNode focusTargetNode, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        Object[] objArr = new FocusTargetNode[16];
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.access$addLayoutNodeChildren(mutableVector, node);
        } else {
            mutableVector.add(node2);
        }
        int i = 0;
        while (true) {
            int i2 = mutableVector.size;
            if (i2 == 0) {
                break;
            }
            Modifier.Node nodeAccess$pop = (Modifier.Node) mutableVector.removeAt(i2 - 1);
            if ((nodeAccess$pop.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.access$addLayoutNodeChildren(mutableVector, nodeAccess$pop);
            } else {
                while (nodeAccess$pop != null) {
                    if ((nodeAccess$pop.kindSet & 1024) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeAccess$pop;
                                int i3 = i + 1;
                                if (objArr.length < i3) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i3, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i] = focusTargetNode2;
                                i = i3;
                            } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodeAccess$pop = node3;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop != null) {
                                                mutableVector2.add(nodeAccess$pop);
                                                nodeAccess$pop = null;
                                            }
                                            mutableVector2.add(node3);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector2);
                        }
                        break;
                    }
                    nodeAccess$pop = nodeAccess$pop.child;
                }
            }
        }
        Arrays.sort(objArr, 0, i, FocusableChildrenComparator.INSTANCE);
        int i5 = i - 1;
        if (i5 < objArr.length) {
            while (i5 >= 0) {
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr[i5];
                if (isEligibleForFocusSearch(focusTargetNode3) && backwardFocusSearch(focusTargetNode3, layoutNodeDrawScope$record$1)) {
                    return true;
                }
                i5--;
            }
        }
        return false;
    }

    public static final boolean pickChildForForwardSearch(FocusTargetNode focusTargetNode, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        Object[] objArr = new FocusTargetNode[16];
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.access$addLayoutNodeChildren(mutableVector, node);
        } else {
            mutableVector.add(node2);
        }
        int i = 0;
        while (true) {
            int i2 = mutableVector.size;
            if (i2 == 0) {
                break;
            }
            Modifier.Node nodeAccess$pop = (Modifier.Node) mutableVector.removeAt(i2 - 1);
            if ((nodeAccess$pop.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.access$addLayoutNodeChildren(mutableVector, nodeAccess$pop);
            } else {
                while (nodeAccess$pop != null) {
                    if ((nodeAccess$pop.kindSet & 1024) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeAccess$pop;
                                int i3 = i + 1;
                                if (objArr.length < i3) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i3, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i] = focusTargetNode2;
                                i = i3;
                            } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            nodeAccess$pop = node3;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop != null) {
                                                mutableVector2.add(nodeAccess$pop);
                                                nodeAccess$pop = null;
                                            }
                                            mutableVector2.add(node3);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector2);
                        }
                        break;
                    }
                    nodeAccess$pop = nodeAccess$pop.child;
                }
            }
        }
        Arrays.sort(objArr, 0, i, FocusableChildrenComparator.INSTANCE);
        for (int i5 = 0; i5 < i; i5++) {
            FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr[i5];
            if (isEligibleForFocusSearch(focusTargetNode3) && forwardFocusSearch(focusTargetNode3, layoutNodeDrawScope$record$1)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r13v51, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final Object m361searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i, Function1 function1) {
        int i2;
        int i3;
        Object objInvoke;
        Modifier.Node nodeAccess$pop;
        final LazyLayoutBeyondBoundsProviderModifierNode beyondBoundsLayoutParent;
        int iMax;
        int size;
        int i4;
        NodeChain nodeChain;
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = focusTargetNode.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            i2 = 0;
            i3 = 1;
            objInvoke = null;
            if (layoutNodeRequireLayoutNode == null) {
                nodeAccess$pop = null;
                break;
            }
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                while (node != null) {
                    if ((node.kindSet & 1024) != 0) {
                        nodeAccess$pop = node;
                        MutableVector mutableVector = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i5 = 0;
                                for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                    if ((node2.kindSet & 1024) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            nodeAccess$pop = node2;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop != null) {
                                                mutableVector.add(nodeAccess$pop);
                                                nodeAccess$pop = null;
                                            }
                                            mutableVector.add(node2);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                        }
                    }
                    node = node.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeAccess$pop;
        if ((focusTargetNode2 != null && Intrinsics.areEqual(focusTargetNode2.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) || (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) == null) {
            return null;
        }
        final int i6 = 5;
        if (i != 5) {
            i6 = 6;
            if (i != 6) {
                i6 = 3;
                if (i != 3) {
                    i6 = 4;
                    if (i != 4) {
                        if (i == 1) {
                            i6 = 2;
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("Unsupported direction for beyond bounds layout");
                            }
                            i6 = 1;
                        }
                    }
                }
            }
        }
        if (beyondBoundsLayoutParent.state.state.getLayoutInfo().totalItemsCount <= 0 || beyondBoundsLayoutParent.state.state.getLayoutInfo().visibleItemsInfo.isEmpty() || !beyondBoundsLayoutParent.isAttached) {
            return function1.invoke(LazyLayoutBeyondBoundsProviderModifierNode.emptyBeyondBoundsScope);
        }
        if (beyondBoundsLayoutParent.m151isForward4vf7U8o(i6)) {
            LazyListBeyondBoundsState lazyListBeyondBoundsState = beyondBoundsLayoutParent.state;
            iMax = Math.min(lazyListBeyondBoundsState.state.getLayoutInfo().totalItemsCount - 1, ((LazyListMeasuredItem) CollectionsKt.last(lazyListBeyondBoundsState.state.getLayoutInfo().visibleItemsInfo)).index);
        } else {
            iMax = Math.max(0, ((ParcelableSnapshotMutableIntState) beyondBoundsLayoutParent.state.state.scrollPosition.call).getIntValue());
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        PreviewView.AnonymousClass1 anonymousClass1 = beyondBoundsLayoutParent.beyondBoundsInfo;
        anonymousClass1.getClass();
        LazyLayoutBeyondBoundsInfo$Interval lazyLayoutBeyondBoundsInfo$Interval = new LazyLayoutBeyondBoundsInfo$Interval(iMax, iMax);
        ((MutableVector) anonymousClass1.this$0).add(lazyLayoutBeyondBoundsInfo$Interval);
        ref$ObjectRef.element = lazyLayoutBeyondBoundsInfo$Interval;
        LazyListState lazyListState = beyondBoundsLayoutParent.state.state;
        if (lazyListState.getLayoutInfo().visibleItemsInfo.isEmpty()) {
            i3 = 0;
        } else {
            LazyListMeasureResult layoutInfo = lazyListState.getLayoutInfo();
            int iM148getViewportSizeYbymL2g = (int) (layoutInfo.orientation == Orientation.Vertical ? layoutInfo.m148getViewportSizeYbymL2g() & 4294967295L : layoutInfo.m148getViewportSizeYbymL2g() >> 32);
            LazyListMeasureResult layoutInfo2 = lazyListState.getLayoutInfo();
            ?? r7 = layoutInfo2.visibleItemsInfo;
            if (r7.isEmpty()) {
                size = 0;
            } else {
                int size2 = r7.size();
                int i7 = 0;
                for (int i8 = 0; i8 < size2; i8++) {
                    i7 += ((LazyListMeasuredItem) r7.get(i8)).size;
                }
                size = (i7 / r7.size()) + layoutInfo2.mainAxisItemSpacing;
            }
            if (size != 0 && (i4 = iM148getViewportSizeYbymL2g / size) >= 1) {
                i3 = i4;
            }
        }
        int i9 = i3 * 2;
        int i10 = beyondBoundsLayoutParent.state.state.getLayoutInfo().totalItemsCount;
        if (i9 > i10) {
            i9 = i10;
        }
        while (objInvoke == null && beyondBoundsLayoutParent.m150hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo$Interval) ref$ObjectRef.element, i6) && i2 < i9) {
            LazyLayoutBeyondBoundsInfo$Interval lazyLayoutBeyondBoundsInfo$Interval2 = (LazyLayoutBeyondBoundsInfo$Interval) ref$ObjectRef.element;
            int i11 = lazyLayoutBeyondBoundsInfo$Interval2.start;
            int i12 = lazyLayoutBeyondBoundsInfo$Interval2.end;
            if (beyondBoundsLayoutParent.m151isForward4vf7U8o(i6)) {
                i12++;
            } else {
                i11--;
            }
            PreviewView.AnonymousClass1 anonymousClass2 = beyondBoundsLayoutParent.beyondBoundsInfo;
            anonymousClass2.getClass();
            LazyLayoutBeyondBoundsInfo$Interval lazyLayoutBeyondBoundsInfo$Interval3 = new LazyLayoutBeyondBoundsInfo$Interval(i11, i12);
            ((MutableVector) anonymousClass2.this$0).add(lazyLayoutBeyondBoundsInfo$Interval3);
            ((MutableVector) beyondBoundsLayoutParent.beyondBoundsInfo.this$0).remove((LazyLayoutBeyondBoundsInfo$Interval) ref$ObjectRef.element);
            ref$ObjectRef.element = lazyLayoutBeyondBoundsInfo$Interval3;
            i2++;
            HitTestResultKt.requireLayoutNode(beyondBoundsLayoutParent).forceRemeasure();
            objInvoke = function1.invoke(new BeyondBoundsLayout$BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsProviderModifierNode$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout$BeyondBoundsScope
                public final boolean getHasMoreContent() {
                    return beyondBoundsLayoutParent.m150hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo$Interval) ref$ObjectRef.element, i6);
                }
            });
        }
        ((MutableVector) beyondBoundsLayoutParent.beyondBoundsInfo.this$0).remove((LazyLayoutBeyondBoundsInfo$Interval) ref$ObjectRef.element);
        HitTestResultKt.requireLayoutNode(beyondBoundsLayoutParent).forceRemeasure();
        return objInvoke;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014c  */
    /* JADX WARN: Code duplicated, block: B:129:0x019e  */
    /* JADX WARN: Code duplicated, block: B:158:0x014a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x011f  */
    /* JADX WARN: Code duplicated, block: B:90:0x012e  */
    /* JADX WARN: Code duplicated, block: B:92:0x013a A[ADDED_TO_REGION, LOOP:6: B:92:0x013a->B:120:0x0187, LOOP_START, PHI: r13
      0x013a: PHI (r13v15 androidx.compose.ui.Modifier$Node) = (r13v9 androidx.compose.ui.Modifier$Node), (r13v16 androidx.compose.ui.Modifier$Node) binds: [B:91:0x0138, B:120:0x0187] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:93:0x013c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0142  */
    /* JADX WARN: Code duplicated, block: B:97:0x0146  */
    /* JADX INFO: renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m363searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        Modifier.Node node;
        Modifier.Node node2;
        LayoutNode layoutNodeRequireLayoutNode;
        NodeChain nodeChain;
        Modifier.Node nodeAccess$pop;
        MutableVector mutableVector;
        if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.");
        }
        Object[] objArr = new FocusTargetNode[16];
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node3 = focusTargetNode.node;
        Modifier.Node node4 = node3.child;
        if (node4 == null) {
            HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, node3);
        } else {
            mutableVector2.add(node4);
        }
        int i2 = 0;
        while (true) {
            int i3 = mutableVector2.size;
            node = null;
            if (i3 == 0) {
                break;
            }
            Modifier.Node nodeAccess$pop2 = (Modifier.Node) mutableVector2.removeAt(i3 - 1);
            if ((nodeAccess$pop2.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, nodeAccess$pop2);
            } else {
                while (nodeAccess$pop2 != null) {
                    if ((nodeAccess$pop2.kindSet & 1024) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodeAccess$pop2 != null) {
                            if (nodeAccess$pop2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodeAccess$pop2;
                                int i4 = i2 + 1;
                                if (objArr.length < i4) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i4, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i2] = focusTargetNode3;
                                i2 = i4;
                            } else if ((nodeAccess$pop2.kindSet & 1024) != 0 && (nodeAccess$pop2 instanceof DelegatingNode)) {
                                int i5 = 0;
                                for (Modifier.Node node5 = ((DelegatingNode) nodeAccess$pop2).delegate; node5 != null; node5 = node5.child) {
                                    if ((node5.kindSet & 1024) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            nodeAccess$pop2 = node5;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop2 != null) {
                                                mutableVector3.add(nodeAccess$pop2);
                                                nodeAccess$pop2 = null;
                                            }
                                            mutableVector3.add(node5);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector3);
                        }
                        break;
                    }
                    nodeAccess$pop2 = nodeAccess$pop2.child;
                }
            }
        }
        Arrays.sort(objArr, 0, i2, FocusableChildrenComparator.INSTANCE);
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("This function should only be used for 1-D focus search");
            }
            IntRange intRangeUntil = RangesKt.until(0, i2);
            int i6 = intRangeUntil.first;
            int i7 = intRangeUntil.last;
            if (i6 <= i7) {
                boolean z = false;
                while (true) {
                    if (z) {
                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr[i7];
                        if (isEligibleForFocusSearch(focusTargetNode4) && backwardFocusSearch(focusTargetNode4, layoutNodeDrawScope$record$1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(objArr[i7], focusTargetNode2)) {
                        z = true;
                    }
                    if (i7 == i6) {
                        break;
                    }
                    i7--;
                }
            }
            if (i != 1) {
                if (!focusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                node2 = focusTargetNode.node.parent;
                layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                loop5: while (layoutNodeRequireLayoutNode != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                        while (node2 != null) {
                            if ((node2.kindSet & 1024) != 0) {
                                nodeAccess$pop = node2;
                                mutableVector = null;
                                while (nodeAccess$pop != null) {
                                    if (nodeAccess$pop instanceof FocusTargetNode) {
                                        node = nodeAccess$pop;
                                        break loop5;
                                    }
                                    if ((nodeAccess$pop.kindSet & 1024) == 0) {
                                    }
                                    nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                                }
                            }
                            node2 = node2.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                    if (layoutNodeRequireLayoutNode != null) {
                    }
                }
                if (node != null) {
                    return ((Boolean) layoutNodeDrawScope$record$1.invoke(focusTargetNode)).booleanValue();
                }
            }
            return false;
        }
        IntRange intRangeUntil2 = RangesKt.until(0, i2);
        int i8 = intRangeUntil2.first;
        int i9 = intRangeUntil2.last;
        if (i8 <= i9) {
            boolean z2 = false;
            while (true) {
                if (z2) {
                    FocusTargetNode focusTargetNode5 = (FocusTargetNode) objArr[i8];
                    if (isEligibleForFocusSearch(focusTargetNode5) && forwardFocusSearch(focusTargetNode5, layoutNodeDrawScope$record$1)) {
                        return true;
                    }
                }
                if (Intrinsics.areEqual(objArr[i8], focusTargetNode2)) {
                    z2 = true;
                }
                if (i8 == i9) {
                    break;
                }
                i8++;
            }
        }
        if (i != 1 && focusTargetNode.fetchFocusProperties$ui().canFocus) {
            if (!focusTargetNode.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            node2 = focusTargetNode.node.parent;
            layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
            loop5: while (layoutNodeRequireLayoutNode != null) {
                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                    while (node2 != null) {
                        if ((node2.kindSet & 1024) != 0) {
                            nodeAccess$pop = node2;
                            mutableVector = null;
                            while (nodeAccess$pop != null) {
                                if (nodeAccess$pop instanceof FocusTargetNode) {
                                    node = nodeAccess$pop;
                                    break loop5;
                                }
                                if ((nodeAccess$pop.kindSet & 1024) == 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                    int i10 = 0;
                                    for (Modifier.Node node6 = ((DelegatingNode) nodeAccess$pop).delegate; node6 != null; node6 = node6.child) {
                                        if ((node6.kindSet & 1024) != 0) {
                                            i10++;
                                            if (i10 == 1) {
                                                nodeAccess$pop = node6;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodeAccess$pop != null) {
                                                    mutableVector.add(nodeAccess$pop);
                                                    nodeAccess$pop = null;
                                                }
                                                mutableVector.add(node6);
                                            }
                                        }
                                    }
                                    if (i10 == 1) {
                                    }
                                }
                                nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                            }
                        }
                        node2 = node2.parent;
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node2 = (layoutNodeRequireLayoutNode != null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
            }
            if (node != null) {
                return ((Boolean) layoutNodeDrawScope$record$1.invoke(focusTargetNode)).booleanValue();
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: twoDimensionalFocusSearch-sMXa3k8, reason: not valid java name */
    public static final Boolean m364twoDimensionalFocusSearchsMXa3k8(int i, FocusTargetNode focusTargetNode, Rect rect, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        int iOrdinal = focusTargetNode.getFocusState().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                FocusTargetNode activeChild = getActiveChild(focusTargetNode);
                if (activeChild == null) {
                    throw new IllegalStateException("ActiveParent must have a focusedChild");
                }
                int iOrdinal2 = activeChild.getFocusState().ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        Boolean boolM364twoDimensionalFocusSearchsMXa3k8 = m364twoDimensionalFocusSearchsMXa3k8(i, activeChild, rect, layoutNodeDrawScope$record$1);
                        if (!Intrinsics.areEqual(boolM364twoDimensionalFocusSearchsMXa3k8, Boolean.FALSE)) {
                            return boolM364twoDimensionalFocusSearchsMXa3k8;
                        }
                        if (rect == null) {
                            if (activeChild.getFocusState() != FocusStateImpl.ActiveParent) {
                                throw new IllegalStateException("Searching for active node in inactive hierarchy");
                            }
                            FocusTargetNode focusTargetNodeFindActiveFocusNode = findActiveFocusNode(activeChild);
                            if (focusTargetNodeFindActiveFocusNode == null) {
                                throw new IllegalStateException("ActiveParent must have a focusedChild");
                            }
                            rect = focusRect(focusTargetNodeFindActiveFocusNode);
                        }
                        return Boolean.valueOf(m355generateAndSearchChildren4C6V_qg(i, focusTargetNode, rect, layoutNodeDrawScope$record$1));
                    }
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 != 3) {
                            throw new HttpException();
                        }
                        throw new IllegalStateException("ActiveParent must have a focusedChild");
                    }
                }
                if (rect == null) {
                    rect = focusRect(activeChild);
                }
                return Boolean.valueOf(m355generateAndSearchChildren4C6V_qg(i, focusTargetNode, rect, layoutNodeDrawScope$record$1));
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new HttpException();
                }
                if (focusTargetNode.fetchFocusProperties$ui().canFocus) {
                    return (Boolean) layoutNodeDrawScope$record$1.invoke(focusTargetNode);
                }
                return rect == null ? Boolean.valueOf(m354findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i, layoutNodeDrawScope$record$1)) : Boolean.valueOf(m362searchChildren4C6V_qg(i, focusTargetNode, rect, layoutNodeDrawScope$record$1));
            }
        }
        return Boolean.valueOf(m354findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i, layoutNodeDrawScope$record$1));
    }

    /* JADX INFO: renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m355generateAndSearchChildren4C6V_qg(int i, FocusTargetNode focusTargetNode, Rect rect, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        if (m362searchChildren4C6V_qg(i, focusTargetNode, rect, layoutNodeDrawScope$record$1)) {
            return true;
        }
        Boolean bool = (Boolean) m361searchBeyondBoundsOMvw8(focusTargetNode, i, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1(((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode(), focusTargetNode, rect, i, layoutNodeDrawScope$record$1, 1));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m362searchChildren4C6V_qg(int i, FocusTargetNode focusTargetNode, Rect rect, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1) {
        FocusTargetNode focusTargetNodeM353findBestCandidate4WY_MpI;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16]);
        if (!focusTargetNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node = focusTargetNode.node;
        Modifier.Node node2 = node.child;
        if (node2 == null) {
            HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, node);
        } else {
            mutableVector2.add(node2);
        }
        while (true) {
            int i2 = mutableVector2.size;
            if (i2 == 0) {
                break;
            }
            Modifier.Node nodeAccess$pop = (Modifier.Node) mutableVector2.removeAt(i2 - 1);
            if ((nodeAccess$pop.aggregateChildKindSet & 1024) == 0) {
                HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, nodeAccess$pop);
            } else {
                while (nodeAccess$pop != null) {
                    if ((nodeAccess$pop.kindSet & 1024) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodeAccess$pop != null) {
                            if (nodeAccess$pop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodeAccess$pop;
                                if (focusTargetNode2.isAttached) {
                                    mutableVector.add(focusTargetNode2);
                                }
                            } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) nodeAccess$pop).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodeAccess$pop = node3;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop != null) {
                                                mutableVector3.add(nodeAccess$pop);
                                                nodeAccess$pop = null;
                                            }
                                            mutableVector3.add(node3);
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector3);
                        }
                        break;
                    }
                    nodeAccess$pop = nodeAccess$pop.child;
                }
            }
        }
        while (mutableVector.size != 0 && (focusTargetNodeM353findBestCandidate4WY_MpI = m353findBestCandidate4WY_MpI(mutableVector, rect, i)) != null) {
            if (focusTargetNodeM353findBestCandidate4WY_MpI.fetchFocusProperties$ui().canFocus) {
                return ((Boolean) layoutNodeDrawScope$record$1.invoke(focusTargetNodeM353findBestCandidate4WY_MpI)).booleanValue();
            }
            if (m355generateAndSearchChildren4C6V_qg(i, focusTargetNodeM353findBestCandidate4WY_MpI, rect, layoutNodeDrawScope$record$1)) {
                return true;
            }
            mutableVector.remove(focusTargetNodeM353findBestCandidate4WY_MpI);
        }
        return false;
    }
}
