package coil.request;

import android.animation.Animator;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySetKt;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DepthSortedSetKt$DepthComparator$1;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditingBuffer;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleKt;
import androidx.core.os.CancellationSignal;
import androidx.core.provider.CallbackWrapper$2;
import androidx.core.provider.FontRequestWorker;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.UnprecomputeTextOnModificationSpannable;
import androidx.emoji2.viewsintegration.EmojiEditableFactory;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.lifecycle.LegacySavedStateHandleController$OnRecreation;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavOptions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import androidx.recyclerview.widget.ViewBoundsCheck$BoundFlags;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;
import androidx.recyclerview.widget.ViewInfoStore$InfoRecord;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil.RealImageLoader;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.memory.MemoryCache$Key;
import coil.memory.MemoryCache$Value;
import coil.memory.RealStrongMemoryCache$InternalValue;
import coil.memory.RealStrongMemoryCache$cache$1;
import coil.memory.RealWeakMemoryCache;
import coil.memory.StrongMemoryCache;
import coil.network.EmptyNetworkObserver;
import coil.size.Dimension;
import coil.size.Size;
import coil.util.Bitmaps;
import coil.util.HardwareBitmapService;
import coil.util.HardwareBitmaps;
import coil.util.ImmutableHardwareBitmapService;
import coil.util.Requests;
import coil.util.SingletonDiskCache;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.github.kr328.clash.core.bridge.ClashException;
import com.github.kr328.clash.core.bridge.FetchCallback;
import com.github.kr328.clash.core.bridge.TunInterface;
import com.github.kr328.clash.core.model.FetchStatus;
import com.github.kr328.clash.core.util.NetKt;
import com.github.kr328.clash.log.LogcatCache;
import com.github.kr328.clash.service.clash.module.TunModule$attach$2;
import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzso;
import com.google.android.gms.tasks.zzi;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.serialization.json.Json;
import okio.AsyncTimeout;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RequestService implements OperationErrorContext, Saver, SegmentFinder, EmojiProcessor$EmojiProcessCallback, CancellationSignal.OnCancelListener, StrongMemoryCache, TunInterface, FetchCallback {
    public final /* synthetic */ int $r8$classId;
    public Object hardwareBitmapService;
    public Object systemCallbacks;

    public /* synthetic */ RequestService(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.systemCallbacks = obj;
        this.hardwareBitmapService = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static void dispatchHierarchy(LayoutNode layoutNode) {
        if (layoutNode.globallyPositionedObservers > 0) {
            if (layoutNode.layoutDelegate.layoutState == 5 && !layoutNode.getLayoutPending$ui() && !layoutNode.getMeasurePending$ui() && !layoutNode.isDeactivated && layoutNode.isPlaced()) {
                Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
                if ((node.aggregateChildKindSet & 256) != 0) {
                    while (node != null) {
                        if ((node.kindSet & 256) != 0) {
                            ?? Access$pop = node;
                            ?? mutableVector = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof GlobalPositionAwareModifierNode) {
                                    GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) Access$pop;
                                    globalPositionAwareModifierNode.onGloballyPositioned(HitTestResultKt.m547requireCoordinator64DMado(globalPositionAwareModifierNode, 256));
                                } else if ((Access$pop.kindSet & 256) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                                    int i = 0;
                                    Access$pop = Access$pop;
                                    mutableVector = mutableVector;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 256) != 0) {
                                            i++;
                                            if (i == 1) {
                                                mutableVector = mutableVector;
                                                Access$pop = node2;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector.add(node2);
                                            }
                                        }
                                        node2 = node2.child;
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Access$pop = HitTestResultKt.access$pop(mutableVector);
                            }
                        }
                        if ((node.aggregateChildKindSet & 256) == 0) {
                            break;
                        } else {
                            node = node.child;
                        }
                    }
                }
            }
            layoutNode.needsOnGloballyPositionedDispatch = false;
            MutableVector mutableVector2 = layoutNode.get_children$ui();
            Object[] objArr = mutableVector2.content;
            int i2 = mutableVector2.size;
            for (int i3 = 0; i3 < i2; i3++) {
                dispatchHierarchy((LayoutNode) objArr[i3]);
            }
        }
    }

    public static ErrorResult errorResult(ImageRequest imageRequest, Throwable th) {
        if (th instanceof NullRequestDataException) {
            imageRequest.getClass();
            DefaultRequestOptions defaultRequestOptions = imageRequest.defaults;
            defaultRequestOptions.getClass();
            DefaultRequestOptions defaultRequestOptions2 = Requests.DEFAULT_REQUEST_OPTIONS;
            defaultRequestOptions.getClass();
        } else {
            imageRequest.defaults.getClass();
            DefaultRequestOptions defaultRequestOptions3 = Requests.DEFAULT_REQUEST_OPTIONS;
        }
        return new ErrorResult(null, imageRequest, th);
    }

    public static int getSpanGroupIndex(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i3++;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = 1;
            }
        }
        return i3 + 1 > i2 ? i4 + 1 : i4;
    }

    /* JADX INFO: renamed from: activeHoverEvent-0FcD4WY, reason: not valid java name */
    public boolean m793activeHoverEvent0FcD4WY(long j) {
        Object obj;
        List list = (List) ((RequestService) this.hardwareBitmapService).systemCallbacks;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list.get(i);
            if (PointerId.m510equalsimpl0(((PointerInputEventData) obj).id, j)) {
                break;
            }
            i++;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (pointerInputEventData != null) {
            return pointerInputEventData.activeHover;
        }
        return false;
    }

    public void addToPostLayout(RecyclerView.ViewHolder viewHolder, NavOptions.Builder builder) {
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.systemCallbacks;
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = (ViewInfoStore$InfoRecord) simpleArrayMap.get(viewHolder);
        if (viewInfoStore$InfoRecordObtain == null) {
            viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
            simpleArrayMap.put(viewHolder, viewInfoStore$InfoRecordObtain);
        }
        viewInfoStore$InfoRecordObtain.postInfo = builder;
        viewInfoStore$InfoRecordObtain.flags |= 8;
    }

    public TextFieldValue apply(List list) {
        EditCommand editCommand;
        Exception e;
        try {
            int size = list.size();
            int i = 0;
            editCommand = null;
            while (i < size) {
                try {
                    EditCommand editCommand2 = (EditCommand) list.get(i);
                    try {
                        editCommand2.applyTo((EditingBuffer) this.hardwareBitmapService);
                        i++;
                        editCommand = editCommand2;
                    } catch (Exception e2) {
                        e = e2;
                        editCommand = editCommand2;
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder("Error while applying EditCommand batch to buffer (length=");
                        sb2.append(((EditingBuffer) this.hardwareBitmapService).gapBuffer.getLength());
                        sb2.append(", composition=");
                        sb2.append(((EditingBuffer) this.hardwareBitmapService).m659getCompositionMzsxiRA$ui_text());
                        sb2.append(", selection=");
                        EditingBuffer editingBuffer = (EditingBuffer) this.hardwareBitmapService;
                        sb2.append((Object) TextRange.m646toStringimpl(ParagraphKt.TextRange(editingBuffer.selectionStart, editingBuffer.selectionEnd)));
                        sb2.append("):");
                        sb.append(sb2.toString());
                        sb.append('\n');
                        CollectionsKt.joinTo$default(list, sb, "\n", new DiskLruCache$$ExternalSyntheticLambda0(4, editCommand, this), 60);
                        throw new RuntimeException(sb.toString(), e);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            EditingBuffer editingBuffer2 = (EditingBuffer) this.hardwareBitmapService;
            editingBuffer2.getClass();
            AnnotatedString annotatedString = new AnnotatedString(editingBuffer2.gapBuffer.toString());
            EditingBuffer editingBuffer3 = (EditingBuffer) this.hardwareBitmapService;
            long jTextRange = ParagraphKt.TextRange(editingBuffer3.selectionStart, editingBuffer3.selectionEnd);
            TextRange textRange = TextRange.m645getReversedimpl(((TextFieldValue) this.systemCallbacks).selection) ? null : new TextRange(jTextRange);
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString, textRange != null ? textRange.packedValue : ParagraphKt.TextRange(TextRange.m643getMaximpl(jTextRange), TextRange.m644getMinimpl(jTextRange)), ((EditingBuffer) this.hardwareBitmapService).m659getCompositionMzsxiRA$ui_text());
            this.systemCallbacks = textFieldValue;
            return textFieldValue;
        } catch (Exception e4) {
            editCommand = null;
            e = e4;
        }
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public List buildStackTrace(Integer num) {
        List listBuildStackTrace = ((OperationErrorContext) this.systemCallbacks).buildStackTrace(null);
        SlotWriter slotWriter = (SlotWriter) this.hardwareBitmapService;
        int i = slotWriter.parent;
        return i < 0 ? listBuildStackTrace : CollectionsKt.plus((Collection) zzso.buildTrace(slotWriter, num, i, Integer.valueOf(slotWriter.parent(slotWriter.groups, i))), listBuildStackTrace);
    }

    public void clear() {
        int[] iArr = (int[]) this.systemCallbacks;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.hardwareBitmapService = null;
    }

    @Override // com.github.kr328.clash.core.bridge.FetchCallback
    public void complete(String str) {
        CompletableDeferredImpl completableDeferredImpl = (CompletableDeferredImpl) this.hardwareBitmapService;
        if (str != null) {
            completableDeferredImpl.completeExceptionally(new ClashException(str));
        } else {
            completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
        }
    }

    public Bundle consumeRestoredStateForKey(String str) {
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.systemCallbacks;
        if (!savedStateRegistryImpl.isRestored) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle = savedStateRegistryImpl.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundleM775getSavedStateimpl = bundle.containsKey(str) ? SavedStateReader.m775getSavedStateimpl(str, bundle) : null;
        bundle.remove(str);
        if (bundle.isEmpty()) {
            savedStateRegistryImpl.restoredState = null;
        }
        return bundleM775getSavedStateimpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatch() {
        Object[] objArr;
        MutableVector mutableVector = (MutableVector) this.systemCallbacks;
        Arrays.sort(mutableVector.content, 0, mutableVector.size, DepthSortedSetKt$DepthComparator$1.INSTANCE);
        int i = mutableVector.size;
        LayoutNode[] layoutNodeArr = (LayoutNode[]) this.hardwareBitmapService;
        if (layoutNodeArr == null || layoutNodeArr.length < i) {
            objArr = layoutNodeArr;
            objArr = new LayoutNode[Math.max(16, i)];
        }
        objArr = layoutNodeArr;
        this.hardwareBitmapService = null;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = mutableVector.content[i2];
        }
        mutableVector.clear();
        while (true) {
            i--;
            if (-1 >= i) {
                this.hardwareBitmapService = objArr;
                return;
            }
            LayoutNode layoutNode = objArr[i];
            if (layoutNode.needsOnGloballyPositionedDispatch) {
                dispatchHierarchy(layoutNode);
            }
            objArr[i] = 0;
        }
    }

    public void dispatchOnFragmentActivityCreated(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentAttached(boolean z) {
        FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.hardwareBitmapService;
        AppCompatActivity appCompatActivity = fragmentManagerImpl.mHost.mContext;
        Fragment fragment = fragmentManagerImpl.mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentAttached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentCreated(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentDestroyed(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentDestroyed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentDetached(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentDetached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPaused(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPaused(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPreAttached(boolean z) {
        FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.hardwareBitmapService;
        AppCompatActivity appCompatActivity = fragmentManagerImpl.mHost.mContext;
        Fragment fragment = fragmentManagerImpl.mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPreAttached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPreCreated(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPreCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentResumed(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentResumed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentSaveInstanceState(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentSaveInstanceState(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentStarted(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentStarted(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentStopped(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentStopped(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentViewCreated(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentViewDestroyed(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.hardwareBitmapService).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.systemCallbacks).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void ensureSize(int i) {
        int[] iArr = (int[]) this.systemCallbacks;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.systemCallbacks = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.systemCallbacks = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.systemCallbacks;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public View findOneViewWithinBoundFlags(int i, int i2, int i3, int i4) {
        ViewBoundsCheck$BoundFlags viewBoundsCheck$BoundFlags = (ViewBoundsCheck$BoundFlags) this.hardwareBitmapService;
        ViewBoundsCheck$Callback viewBoundsCheck$Callback = (ViewBoundsCheck$Callback) this.systemCallbacks;
        int parentStart = viewBoundsCheck$Callback.getParentStart();
        int parentEnd = viewBoundsCheck$Callback.getParentEnd();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = viewBoundsCheck$Callback.getChildAt(i);
            int childStart = viewBoundsCheck$Callback.getChildStart(childAt);
            int childEnd = viewBoundsCheck$Callback.getChildEnd(childAt);
            viewBoundsCheck$BoundFlags.mRvStart = parentStart;
            viewBoundsCheck$BoundFlags.mRvEnd = parentEnd;
            viewBoundsCheck$BoundFlags.mChildStart = childStart;
            viewBoundsCheck$BoundFlags.mChildEnd = childEnd;
            if (i3 != 0) {
                viewBoundsCheck$BoundFlags.mBoundFlags = i3;
                if (viewBoundsCheck$BoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                viewBoundsCheck$BoundFlags.mBoundFlags = i4;
                if (viewBoundsCheck$BoundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            i += i5;
        }
        return view;
    }

    @Override // coil.memory.StrongMemoryCache
    public MemoryCache$Value get(MemoryCache$Key memoryCache$Key) {
        RealStrongMemoryCache$InternalValue realStrongMemoryCache$InternalValue = (RealStrongMemoryCache$InternalValue) ((RealStrongMemoryCache$cache$1) this.hardwareBitmapService).get(memoryCache$Key);
        if (realStrongMemoryCache$InternalValue != null) {
            return new MemoryCache$Value(realStrongMemoryCache$InternalValue.bitmap, realStrongMemoryCache$InternalValue.extras);
        }
        return null;
    }

    public MeasurePolicy getMeasurePolicyState() {
        return (MeasurePolicy) ((ParcelableSnapshotMutableState) this.hardwareBitmapService).getValue();
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public Object getResult() {
        return (UnprecomputeTextOnModificationSpannable) this.systemCallbacks;
    }

    public SavedStateRegistry$SavedStateProvider getSavedStateProvider(String str) {
        SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider;
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.systemCallbacks;
        synchronized (savedStateRegistryImpl.lock) {
            Iterator it = savedStateRegistryImpl.keyToProviders.entrySet().iterator();
            do {
                savedStateRegistry$SavedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str2 = (String) entry.getKey();
                SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider2 = (SavedStateRegistry$SavedStateProvider) entry.getValue();
                if (Intrinsics.areEqual(str2, str)) {
                    savedStateRegistry$SavedStateProvider = savedStateRegistry$SavedStateProvider2;
                }
            } while (savedStateRegistry$SavedStateProvider == null);
        }
        return savedStateRegistry$SavedStateProvider;
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public boolean getSourceInformationEnabled() {
        return ((OperationErrorContext) this.systemCallbacks).getSourceInformationEnabled();
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.mCache & 4) > 0) {
            return true;
        }
        if (((UnprecomputeTextOnModificationSpannable) this.systemCallbacks) == null) {
            this.systemCallbacks = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((AsyncTimeout.Companion) this.hardwareBitmapService).getClass();
        ((UnprecomputeTextOnModificationSpannable) this.systemCallbacks).setSpan(new TypefaceEmojiSpan(typefaceEmojiRasterizer), i, i2, 33);
        return true;
    }

    public void invalidateSpanIndexCache() {
        ((SparseIntArray) this.systemCallbacks).clear();
    }

    public boolean isViewWithinBoundFlags(View view) {
        ViewBoundsCheck$BoundFlags viewBoundsCheck$BoundFlags = (ViewBoundsCheck$BoundFlags) this.hardwareBitmapService;
        ViewBoundsCheck$Callback viewBoundsCheck$Callback = (ViewBoundsCheck$Callback) this.systemCallbacks;
        int parentStart = viewBoundsCheck$Callback.getParentStart();
        int parentEnd = viewBoundsCheck$Callback.getParentEnd();
        int childStart = viewBoundsCheck$Callback.getChildStart(view);
        int childEnd = viewBoundsCheck$Callback.getChildEnd(view);
        viewBoundsCheck$BoundFlags.mRvStart = parentStart;
        viewBoundsCheck$BoundFlags.mRvEnd = parentEnd;
        viewBoundsCheck$BoundFlags.mChildStart = childStart;
        viewBoundsCheck$BoundFlags.mChildEnd = childEnd;
        viewBoundsCheck$BoundFlags.mBoundFlags = 24579;
        return viewBoundsCheck$BoundFlags.boundsMatch();
    }

    @Override // com.github.kr328.clash.core.bridge.TunInterface
    public void markSocket(int i) {
        ((JobKt__JobKt$invokeOnCompletion$1) this.systemCallbacks).invoke(Integer.valueOf(i));
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int i) {
        do {
            i = ((LogcatCache) this.hardwareBitmapService).nextBoundary(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.systemCallbacks).charAt(i - 1)));
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int i) {
        CharSequence charSequence = (CharSequence) this.systemCallbacks;
        do {
            i = ((LogcatCache) this.hardwareBitmapService).nextBoundary(i);
            if (i == -1 || i == charSequence.length()) {
                return -1;
            }
        } while (Character.isWhitespace(charSequence.charAt(i)));
        return i;
    }

    public void offsetForAddition(int i, int i2) {
        int[] iArr = (int[]) this.systemCallbacks;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        ensureSize(i3);
        int[] iArr2 = (int[]) this.systemCallbacks;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill((int[]) this.systemCallbacks, i, i3, -1);
        ArrayList arrayList = (ArrayList) this.hardwareBitmapService;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.hardwareBitmapService).get(size);
            int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (i4 >= i) {
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = i4 + i2;
            }
        }
    }

    public void offsetForRemoval(int i, int i2) {
        int[] iArr = (int[]) this.systemCallbacks;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        ensureSize(i3);
        int[] iArr2 = (int[]) this.systemCallbacks;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = (int[]) this.systemCallbacks;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.hardwareBitmapService;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.hardwareBitmapService).get(size);
            int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (i4 >= i) {
                if (i4 < i3) {
                    ((ArrayList) this.hardwareBitmapService).remove(size);
                } else {
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = i4 - i2;
                }
            }
        }
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        ((Animator) this.systemCallbacks).end();
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Animator from operation " + ((SpecialEffectsController$FragmentStateManagerOperation) this.hardwareBitmapService) + " has been canceled.");
        }
    }

    public void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        zabk zabkVar = (zabk) this.hardwareBitmapService;
        Parameters.Builder builder = (Parameters.Builder) this.systemCallbacks;
        int i = typefaceResult.mResult;
        if (i != 0) {
            zabkVar.execute(new CallbackWrapper$2(i, 0, builder));
        } else {
            zabkVar.execute(new zzi(6, builder, typefaceResult.mTypeface));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public Options options(ImageRequest imageRequest, Size size) {
        List list = imageRequest.transformations;
        Bitmap.Config config = imageRequest.bitmapConfig;
        if (!list.isEmpty() && !ArraysKt.contains(Utils.VALID_TRANSFORMATION_CONFIGS, config)) {
            config = Bitmap.Config.ARGB_8888;
        } else if (Bitmaps.isHardware(config)) {
            if (!Bitmaps.isHardware(config) || imageRequest.allowHardware) {
                if (!((HardwareBitmapService) this.hardwareBitmapService).allowHardwareMainThread(size)) {
                }
            }
            config = Bitmap.Config.ARGB_8888;
        }
        Dimension dimension = size.width;
        Dimension.Undefined undefined = Dimension.Undefined.INSTANCE;
        return new Options(imageRequest.context, config, null, size, (dimension.equals(undefined) || size.height.equals(undefined)) ? 2 : imageRequest.scale, Requests.getAllowInexactSize(imageRequest), imageRequest.allowRgb565 && imageRequest.transformations.isEmpty() && config != Bitmap.Config.ALPHA_8, imageRequest.premultipliedAlpha, null, imageRequest.headers, imageRequest.tags, imageRequest.parameters, imageRequest.memoryCachePolicy, imageRequest.diskCachePolicy, imageRequest.networkCachePolicy);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void parseConstraintSet(Context context, XmlResourceParser xmlResourceParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("id".equals(xmlResourceParser.getAttributeName(i))) {
                String attributeValue = xmlResourceParser.getAttributeValue(i);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                try {
                    int eventType = xmlResourceParser.getEventType();
                    ConstraintSet.Constraint constraintFillFromAttributeList = null;
                    while (eventType != 1) {
                        if (eventType == 0) {
                            xmlResourceParser.getName();
                        } else if (eventType == 2) {
                            String name = xmlResourceParser.getName();
                            switch (name.hashCode()) {
                                case -2025855158:
                                    if (name.equals("Layout")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        constraintFillFromAttributeList.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    } else {
                                        continue;
                                    }
                                    break;
                                case -1984451626:
                                    if (name.equals("Motion")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        constraintFillFromAttributeList.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    } else {
                                        continue;
                                    }
                                    break;
                                case -1269513683:
                                    if (name.equals("PropertySet")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        constraintFillFromAttributeList.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    } else {
                                        continue;
                                    }
                                    break;
                                case -1238332596:
                                    if (name.equals("Transform")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        constraintFillFromAttributeList.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    } else {
                                        continue;
                                    }
                                    break;
                                case -71750448:
                                    if (name.equals("Guideline")) {
                                        constraintFillFromAttributeList = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                        constraintFillFromAttributeList.layout.mIsGuideline = true;
                                    }
                                    break;
                                case 1331510167:
                                    if (name.equals("Barrier")) {
                                        constraintFillFromAttributeList = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                        constraintFillFromAttributeList.layout.mHelperType = 1;
                                    }
                                    break;
                                case 1791837707:
                                    if (name.equals("CustomAttribute")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        ConstraintAttribute.parse(context, xmlResourceParser, constraintFillFromAttributeList.mCustomConstraints);
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 1803088381:
                                    if (name.equals("Constraint")) {
                                        constraintFillFromAttributeList = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    }
                                    break;
                            }
                        } else if (eventType != 3) {
                            continue;
                        } else {
                            String name2 = xmlResourceParser.getName();
                            if ("ConstraintSet".equals(name2)) {
                                ((SparseArray) this.hardwareBitmapService).put(identifier, constraintSet);
                                return;
                            } else if (name2.equalsIgnoreCase("Constraint")) {
                                constraintSet.mConstraints.put(Integer.valueOf(constraintFillFromAttributeList.mViewId), constraintFillFromAttributeList);
                                constraintFillFromAttributeList = null;
                            }
                        }
                        eventType = xmlResourceParser.next();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e2) {
                    e2.printStackTrace();
                }
                ((SparseArray) this.hardwareBitmapService).put(identifier, constraintSet);
                return;
            }
        }
    }

    public void performAttach() {
        ((SavedStateRegistryImpl) this.systemCallbacks).performAttach();
    }

    public void performRestore(Bundle bundle) {
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.systemCallbacks;
        SavedStateRegistryOwner savedStateRegistryOwner = savedStateRegistryImpl.owner;
        if (!savedStateRegistryImpl.attached) {
            savedStateRegistryImpl.performAttach();
        }
        if (savedStateRegistryOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + savedStateRegistryOwner.getLifecycle().getCurrentState()).toString());
        }
        if (savedStateRegistryImpl.isRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundleM775getSavedStateimpl = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            bundleM775getSavedStateimpl = SavedStateReader.m775getSavedStateimpl("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
        }
        savedStateRegistryImpl.restoredState = bundleM775getSavedStateimpl;
        savedStateRegistryImpl.isRestored = true;
    }

    public void performSave(Bundle bundle) {
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.systemCallbacks;
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle2 = savedStateRegistryImpl.restoredState;
        if (bundle2 != null) {
            bundleBundleOf.putAll(bundle2);
        }
        synchronized (savedStateRegistryImpl.lock) {
            try {
                for (Map.Entry entry : savedStateRegistryImpl.keyToProviders.entrySet()) {
                    bundleBundleOf.putBundle((String) entry.getKey(), ((SavedStateRegistry$SavedStateProvider) entry.getValue()).saveState());
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bundleBundleOf.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundleBundleOf);
    }

    public NavOptions.Builder popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int i) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord;
        NavOptions.Builder builder;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.systemCallbacks;
        int iIndexOfKey = simpleArrayMap.indexOfKey(viewHolder);
        if (iIndexOfKey >= 0 && (viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) simpleArrayMap.valueAt(iIndexOfKey)) != null) {
            int i2 = viewInfoStore$InfoRecord.flags;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                viewInfoStore$InfoRecord.flags = i3;
                if (i == 4) {
                    builder = viewInfoStore$InfoRecord.preInfo;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    builder = viewInfoStore$InfoRecord.postInfo;
                }
                if ((i3 & 12) == 0) {
                    simpleArrayMap.removeAt(iIndexOfKey);
                    viewInfoStore$InfoRecord.flags = 0;
                    viewInfoStore$InfoRecord.preInfo = null;
                    viewInfoStore$InfoRecord.postInfo = null;
                    ViewInfoStore$InfoRecord.sPool.release(viewInfoStore$InfoRecord);
                }
                return builder;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int i) {
        do {
            i = ((LogcatCache) this.hardwareBitmapService).prevBoundary(i);
            if (i == -1 || i == 0) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.systemCallbacks).charAt(i - 1)));
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int i) {
        do {
            i = ((LogcatCache) this.hardwareBitmapService).prevBoundary(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.systemCallbacks).charAt(i)));
        return i;
    }

    @Override // com.github.kr328.clash.core.bridge.TunInterface
    public int querySocketUid(int i, String str, String str2) {
        return ((Number) ((TunModule$attach$2) this.hardwareBitmapService).invoke(Integer.valueOf(i), NetKt.parseInetSocketAddress(str), NetKt.parseInetSocketAddress(str2))).intValue();
    }

    public void registerSavedStateProvider(String str, SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider) {
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.systemCallbacks;
        synchronized (savedStateRegistryImpl.lock) {
            if (savedStateRegistryImpl.keyToProviders.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            savedStateRegistryImpl.keyToProviders.put(str, savedStateRegistry$SavedStateProvider);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void removeFromDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) ((SimpleArrayMap) this.systemCallbacks).get(viewHolder);
        if (viewInfoStore$InfoRecord == null) {
            return;
        }
        viewInfoStore$InfoRecord.flags &= -2;
    }

    public void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        LongSparseArray longSparseArray = (LongSparseArray) this.hardwareBitmapService;
        for (int size = longSparseArray.size() - 1; size >= 0; size--) {
            if (viewHolder == longSparseArray.valueAt(size)) {
                Object[] objArr = longSparseArray.values;
                Object obj = objArr[size];
                Object obj2 = ArraySetKt.DELETED;
                if (obj == obj2) {
                    break;
                }
                objArr[size] = obj2;
                longSparseArray.garbage = true;
                break;
            }
        }
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) ((SimpleArrayMap) this.systemCallbacks).remove(viewHolder);
        if (viewInfoStore$InfoRecord != null) {
            viewInfoStore$InfoRecord.flags = 0;
            viewInfoStore$InfoRecord.preInfo = null;
            viewInfoStore$InfoRecord.postInfo = null;
            ViewInfoStore$InfoRecord.sPool.release(viewInfoStore$InfoRecord);
        }
    }

    @Override // com.github.kr328.clash.core.bridge.FetchCallback
    public void report(String str) {
        ((Function1) this.systemCallbacks).invoke(Json.Default.decodeFromString(str, FetchStatus.CREATOR.serializer()));
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public Object restore(Object obj) {
        return ((Function1) this.hardwareBitmapService).invoke(obj);
    }

    public void runOnNextRecreation() {
        if (!((SavedStateRegistryImpl) this.systemCallbacks).isAllowingSavingState) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        AppCompatActivity.AnonymousClass1 anonymousClass1 = (AppCompatActivity.AnonymousClass1) this.hardwareBitmapService;
        if (anonymousClass1 == null) {
            anonymousClass1 = new AppCompatActivity.AnonymousClass1(this);
        }
        this.hardwareBitmapService = anonymousClass1;
        try {
            LegacySavedStateHandleController$OnRecreation.class.getDeclaredConstructor(null);
            AppCompatActivity.AnonymousClass1 anonymousClass2 = (AppCompatActivity.AnonymousClass1) this.hardwareBitmapService;
            if (anonymousClass2 != null) {
                ((LinkedHashSet) anonymousClass2.this$0).add(LegacySavedStateHandleController$OnRecreation.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + LegacySavedStateHandleController$OnRecreation.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public Object save(SaveableHolder saveableHolder, Object obj) {
        return ((Function2) this.systemCallbacks).invoke(saveableHolder, obj);
    }

    @Override // coil.memory.StrongMemoryCache
    public void set(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map) {
        int i;
        int allocationByteCountCompat = Bitmaps.getAllocationByteCountCompat(bitmap);
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) this.hardwareBitmapService;
        synchronized (realStrongMemoryCache$cache$1.lock) {
            i = realStrongMemoryCache$cache$1.maxSize;
        }
        if (allocationByteCountCompat <= i) {
            ((RealStrongMemoryCache$cache$1) this.hardwareBitmapService).put(memoryCache$Key, new RealStrongMemoryCache$InternalValue(bitmap, map, allocationByteCountCompat));
        } else {
            ((RealStrongMemoryCache$cache$1) this.hardwareBitmapService).remove(memoryCache$Key);
            ((RealWeakMemoryCache) this.systemCallbacks).set(memoryCache$Key, bitmap, map, allocationByteCountCompat);
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 15:
                return "Bounds{lower=" + ((Insets) this.systemCallbacks) + " upper=" + ((Insets) this.hardwareBitmapService) + "}";
            default:
                return super.toString();
        }
    }

    @Override // coil.memory.StrongMemoryCache
    public void trimMemory(int i) {
        int i2;
        if (i >= 40) {
            ((RealStrongMemoryCache$cache$1) this.hardwareBitmapService).trimToSize(-1);
            return;
        }
        if (10 > i || i >= 20) {
            return;
        }
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) this.hardwareBitmapService;
        synchronized (realStrongMemoryCache$cache$1.lock) {
            i2 = realStrongMemoryCache$cache$1.size;
        }
        realStrongMemoryCache$cache$1.trimToSize(i2 / 2);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003d  */
    public Options updateOptionsOnWorkerThread(Options options) {
        boolean z;
        boolean z2;
        Bitmap.Config config = options.config;
        int i = options.networkCachePolicy;
        boolean z3 = true;
        if (!Bitmaps.isHardware(config) || ((HardwareBitmapService) this.hardwareBitmapService).allowHardwareWorkerThread()) {
            z = false;
        } else {
            config = Bitmap.Config.ARGB_8888;
            z = true;
        }
        Bitmap.Config config2 = config;
        if (Density.CC.getReadEnabled(options.networkCachePolicy)) {
            SystemCallbacks systemCallbacks = (SystemCallbacks) this.systemCallbacks;
            synchronized (systemCallbacks) {
                systemCallbacks.registerNetworkObserver();
                z2 = systemCallbacks._isOnline;
            }
            if (z2) {
                z3 = z;
            } else {
                i = 4;
            }
        } else {
            z3 = z;
        }
        return z3 ? new Options(options.context, config2, options.colorSpace, options.size, options.scale, options.allowInexactSize, options.allowRgb565, options.premultipliedAlpha, options.diskCacheKey, options.headers, options.tags, options.parameters, options.memoryCachePolicy, options.diskCachePolicy, i) : options;
    }

    public /* synthetic */ RequestService(int i, boolean z) {
        this.$r8$classId = i;
    }

    public RequestService(RealImageLoader realImageLoader, SystemCallbacks systemCallbacks) {
        Object immutableHardwareBitmapService;
        this.$r8$classId = 0;
        this.systemCallbacks = systemCallbacks;
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            boolean z = HardwareBitmaps.IS_DEVICE_BLOCKED;
        } else {
            if (!HardwareBitmaps.IS_DEVICE_BLOCKED) {
                if (i != 26 && i != 27) {
                    immutableHardwareBitmapService = new ImmutableHardwareBitmapService(true);
                } else {
                    immutableHardwareBitmapService = new SingletonDiskCache();
                }
            }
            this.hardwareBitmapService = immutableHardwareBitmapService;
        }
        immutableHardwareBitmapService = new ImmutableHardwareBitmapService(false);
        this.hardwareBitmapService = immutableHardwareBitmapService;
    }

    public RequestService(SavedStateRegistryImpl savedStateRegistryImpl, int i) {
        this.$r8$classId = i;
        switch (i) {
            case 26:
                this.systemCallbacks = savedStateRegistryImpl;
                this.hardwareBitmapService = new RequestService(savedStateRegistryImpl, 25);
                break;
            default:
                this.systemCallbacks = savedStateRegistryImpl;
                break;
        }
    }

    public RequestService(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 8:
                this.systemCallbacks = new MutableVector(new Reference[16]);
                this.hardwareBitmapService = new ReferenceQueue();
                break;
            case 10:
                this.systemCallbacks = new EmptyNetworkObserver();
                this.hardwareBitmapService = new LruCache(16);
                break;
            case 21:
                this.systemCallbacks = new SparseIntArray();
                this.hardwareBitmapService = new SparseIntArray();
                break;
            case 24:
                this.systemCallbacks = new SimpleArrayMap(0);
                this.hardwareBitmapService = new LongSparseArray((Object) null);
                break;
            default:
                this.systemCallbacks = new MutableVector(new LayoutNode[16]);
                break;
        }
    }

    public RequestService(LayoutNode layoutNode, MeasurePolicy measurePolicy) {
        this.$r8$classId = 5;
        this.systemCallbacks = layoutNode;
        this.hardwareBitmapService = Stack.mutableStateOf$default(measurePolicy);
    }

    public RequestService(FragmentManagerImpl fragmentManagerImpl) {
        this.$r8$classId = 20;
        this.systemCallbacks = new CopyOnWriteArrayList();
        this.hardwareBitmapService = fragmentManagerImpl;
    }

    public RequestService(final int i, RealWeakMemoryCache realWeakMemoryCache) {
        this.$r8$classId = 27;
        this.systemCallbacks = realWeakMemoryCache;
        this.hardwareBitmapService = new LruCache(i) { // from class: coil.memory.RealStrongMemoryCache$cache$1
            @Override // androidx.collection.LruCache
            public final void entryRemoved(Object obj, Object obj2, Object obj3) {
                RealStrongMemoryCache$InternalValue realStrongMemoryCache$InternalValue = (RealStrongMemoryCache$InternalValue) obj2;
                ((RealWeakMemoryCache) this.systemCallbacks).set((MemoryCache$Key) obj, realStrongMemoryCache$InternalValue.bitmap, realStrongMemoryCache$InternalValue.extras, realStrongMemoryCache$InternalValue.size);
            }

            @Override // androidx.collection.LruCache
            public final int sizeOf(Object obj, Object obj2) {
                return ((RealStrongMemoryCache$InternalValue) obj2).size;
            }
        };
    }

    public RequestService(ViewBoundsCheck$Callback viewBoundsCheck$Callback) {
        this.$r8$classId = 23;
        this.systemCallbacks = viewBoundsCheck$Callback;
        ViewBoundsCheck$BoundFlags viewBoundsCheck$BoundFlags = new ViewBoundsCheck$BoundFlags();
        viewBoundsCheck$BoundFlags.mBoundFlags = 0;
        this.hardwareBitmapService = viewBoundsCheck$BoundFlags;
    }

    public RequestService(Animation animation) {
        this.$r8$classId = 19;
        this.systemCallbacks = animation;
        this.hardwareBitmapService = null;
    }

    public RequestService(Animator animator) {
        this.$r8$classId = 19;
        this.systemCallbacks = null;
        this.hardwareBitmapService = animator;
    }

    public RequestService(WindowInsetsAnimation.Bounds bounds) {
        this.$r8$classId = 15;
        this.systemCallbacks = Insets.toCompatInsets(bounds.getLowerBound());
        this.hardwareBitmapService = Insets.toCompatInsets(bounds.getUpperBound());
    }

    public RequestService(EditText editText) {
        this.$r8$classId = 17;
        this.systemCallbacks = editText;
        EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
        this.hardwareBitmapService = emojiTextWatcher;
        editText.addTextChangedListener(emojiTextWatcher);
        if (EmojiEditableFactory.sInstance == null) {
            synchronized (EmojiEditableFactory.INSTANCE_LOCK) {
                try {
                    if (EmojiEditableFactory.sInstance == null) {
                        EmojiEditableFactory emojiEditableFactory = new EmojiEditableFactory();
                        try {
                            EmojiEditableFactory.sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        EmojiEditableFactory.sInstance = emojiEditableFactory;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        editText.setEditableFactory(EmojiEditableFactory.sInstance);
    }
}
