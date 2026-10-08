package androidx.compose.runtime;

import android.app.RemoteAction;
import android.content.Context;
import android.graphics.RectF;
import android.view.textclassifier.TextClassification;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.SurfaceRequest;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionRegistrarImpl;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.AlertDialogKt;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ModalBottomSheetDialogLayout;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.SingleRowTopAppBarOverrideScope;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.semantics.AppendedSemanticsElement;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import coil.network.HttpException;
import com.github.kr328.clash.compose.PropertiesScreenKt;
import com.github.kr328.clash.compose.settings.SettingsEntry;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzje;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.koala.clash.R;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Updater$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Updater$$ExternalSyntheticLambda0(int i, int i2, Object obj) {
        this.$r8$classId = i2;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0079 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x007b A[Catch: all -> 0x006e, LOOP:0: B:11:0x0036->B:28:0x007b, LOOP_END, TryCatch #0 {all -> 0x006e, blocks: (B:4:0x0011, B:6:0x0021, B:8:0x0028, B:11:0x0036, B:13:0x0046, B:15:0x0052, B:17:0x005b, B:19:0x0064, B:24:0x0070, B:25:0x0073, B:28:0x007b, B:38:0x00a0, B:29:0x007e, B:30:0x0084, B:32:0x008a, B:34:0x0092, B:37:0x009c), top: B:48:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a0 A[EDGE_INSN: B:51:0x00a0->B:38:0x00a0 BREAK  A[LOOP:0: B:11:0x0036->B:28:0x007b], SYNTHETIC] */
    private final Object invoke$androidx$compose$runtime$Recomposer$recompositionRunner$2$$ExternalSyntheticLambda0(Object obj, Object obj2) {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        Recomposer recomposer = (Recomposer) this.f$0;
        Set set = (Set) obj;
        synchronized (recomposer.stateLock) {
            try {
                if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                    MutableScatterSet mutableScatterSet = recomposer.snapshotInvalidations;
                    if (set instanceof ScatterSetWrapper) {
                        MutableScatterSet mutableScatterSet2 = ((ScatterSetWrapper) set).set;
                        Object[] objArr = mutableScatterSet2.elements;
                        long[] jArr = mutableScatterSet2.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                long j = jArr[i];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                    if (i != length) {
                                        break;
                                        break;
                                    }
                                    i++;
                                } else {
                                    int i2 = 8 - ((~(i - length)) >>> 31);
                                    for (int i3 = 0; i3 < i2; i3++) {
                                        if ((255 & j) < 128) {
                                            Object obj3 = objArr[(i << 3) + i3];
                                            if (!(obj3 instanceof StateObjectImpl) || ((StateObjectImpl) obj3).m303isReadInh_f27i8$runtime(1)) {
                                                mutableScatterSet.add(obj3);
                                            }
                                        }
                                        j >>= 8;
                                    }
                                    if (i2 != 8) {
                                        break;
                                    }
                                    if (i != length) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                        }
                    } else {
                        for (Object obj4 : set) {
                            if (!(obj4 instanceof StateObjectImpl) || ((StateObjectImpl) obj4).m303isReadInh_f27i8$runtime(1)) {
                                mutableScatterSet.add(obj4);
                            }
                        }
                    }
                    cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                } else {
                    cancellableContinuationDeriveStateLocked = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            ((CancellableContinuationImpl) cancellableContinuationDeriveStateLocked).resumeWith(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x006a A[Catch: all -> 0x0022, LOOP:0: B:14:0x002f->B:26:0x006a, LOOP_END, TryCatch #0 {all -> 0x0022, blocks: (B:4:0x0011, B:6:0x0015, B:8:0x001f, B:28:0x006e, B:11:0x0024, B:14:0x002f, B:16:0x003f, B:18:0x004b, B:20:0x0054, B:22:0x005f, B:23:0x0062, B:26:0x006a), top: B:36:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x006d A[EDGE_INSN: B:27:0x006d->B:28:0x006e BREAK  A[LOOP:0: B:14:0x002f->B:26:0x006a]] */
    /* JADX WARN: Code duplicated, block: B:40:0x006d A[SYNTHETIC] */
    private final Object invoke$androidx$compose$runtime$SingleSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        SendChannel sendChannel;
        SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager = (SingleSubscriptionSnapshotFlowManager) this.f$0;
        Set set = (Set) obj;
        synchronized (singleSubscriptionSnapshotFlowManager.internalScopeRef) {
            try {
                MutableScatterSet mutableScatterSet = singleSubscriptionSnapshotFlowManager.watchSet;
                if (mutableScatterSet != null) {
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length < 0) {
                        sendChannel = null;
                        break;
                    }
                    int i = 0;
                    loop0: while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128 && set.contains(objArr[(i << 3) + i3])) {
                                    sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
                                    break loop0;
                                }
                                j >>= 8;
                            }
                            if (i2 == 8) {
                                if (i == length) {
                                    i++;
                                }
                            }
                            sendChannel = null;
                            break;
                        }
                        if (i == length) {
                            sendChannel = null;
                            break;
                        }
                        i++;
                    }
                } else {
                    if (!CollectionsKt.contains(set, singleSubscriptionSnapshotFlowManager.soleWatchedObject)) {
                        sendChannel = null;
                        break;
                    }
                    sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (sendChannel != null) {
            sendChannel.mo842trySendJP2dKIU(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:158:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:159:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:243:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0191 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x0193 A[Catch: all -> 0x0189, LOOP:4: B:66:0x0160->B:78:0x0193, LOOP_END, TryCatch #0 {all -> 0x0189, blocks: (B:44:0x00f1, B:47:0x0110, B:49:0x011d, B:51:0x0127, B:53:0x012d, B:55:0x013b, B:61:0x014a, B:63:0x0155, B:66:0x0160, B:68:0x016c, B:70:0x0176, B:72:0x017c, B:75:0x018b, B:78:0x0193, B:79:0x0196), top: B:230:0x00f1 }] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long j;
        char c;
        long jFloatToRawIntBits;
        long jMo523localPositionOfR5De75A;
        long jFloatToRawIntBits2;
        long j2;
        long j3;
        long j4;
        Collection collectionPlus;
        boolean zOverlaps;
        int i = 2;
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                ((Function1) this.f$0).invoke(obj);
                return Unit.INSTANCE;
            case 1:
                ((Integer) obj2).getClass();
                ((InfiniteTransition) this.f$0).run$animation_core(Stack.updateChangedFlags(1), (GapComposer) obj);
                return Unit.INSTANCE;
            case 2:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) this.f$0;
                float fFloatValue = ((Float) obj2).floatValue();
                ((PointerInputChange) obj).consume();
                ref$FloatRef.element = fFloatValue;
                return Unit.INSTANCE;
            case 3:
                ScrollableNode scrollableNode = (ScrollableNode) this.f$0;
                JobKt.launch$default(scrollableNode.getCoroutineScope(), null, new ScrollableNode$setScrollSemanticsActions$1$1(scrollableNode, ((Float) obj).floatValue(), ((Float) obj2).floatValue(), null), 3);
                return Boolean.TRUE;
            case 4:
                return new IntOffset((((long) ((BiasAlignment.Horizontal) this.f$0).align(0, (int) (((IntSize) obj).packedValue >> 32), (LayoutDirection) obj2)) << 32) | (((long) 0) & 4294967295L));
            case 5:
                return new IntOffset((((long) 0) << 32) | (((long) ((BiasAlignment.Vertical) this.f$0).align(0, (int) (((IntSize) obj).packedValue & 4294967295L))) & 4294967295L));
            case 6:
                return new IntOffset(((BiasAlignment) this.f$0).mo305alignKFBX0sM(0L, ((IntSize) obj).packedValue, (LayoutDirection) obj2));
            case 7:
                Long l = (Long) obj2;
                if (SelectionRegistrarKt.hasSelection((SelectionRegistrarImpl) this.f$0, l.longValue())) {
                    return l;
                }
                return null;
            case 8:
                ((Integer) obj2).getClass();
                BasicTextKt.TextFieldCursorHandle((TextFieldSelectionManager) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 9:
                ((TextDragObserver) this.f$0).mo175onDragk4lQ0M(((Offset) obj2).packedValue);
                return Unit.INSTANCE;
            case 10:
                TextContextMenuItem textContextMenuItem = (TextContextMenuItem) this.f$0;
                GapComposer gapComposer = (GapComposer) obj;
                ((Integer) obj2).getClass();
                gapComposer.startReplaceGroup(666084174);
                String str = textContextMenuItem.label;
                gapComposer.end(false);
                return str;
            case 11:
                TextClassification textClassification = (TextClassification) this.f$0;
                GapComposer gapComposer2 = (GapComposer) obj;
                ((Integer) obj2).getClass();
                gapComposer2.startReplaceGroup(950061013);
                String strValueOf = String.valueOf(textClassification.getLabel());
                gapComposer2.end(false);
                return strValueOf;
            case 12:
                RemoteAction remoteAction = (RemoteAction) this.f$0;
                GapComposer gapComposer3 = (GapComposer) obj;
                ((Integer) obj2).getClass();
                gapComposer3.startReplaceGroup(-1376593684);
                String string = remoteAction.getTitle().toString();
                gapComposer3.end(false);
                return string;
            case 13:
                Ref$LongRef ref$LongRef = (Ref$LongRef) this.f$0;
                ((PointerInputChange) obj).consume();
                ref$LongRef.element = ((Offset) obj2).packedValue;
                return Unit.INSTANCE;
            case 14:
                SelectionManager selectionManager = (SelectionManager) this.f$0;
                TextContextMenuBuilderScope textContextMenuBuilderScope = (TextContextMenuBuilderScope) obj;
                Context context = (Context) obj2;
                Pair contextTextAndSelection$foundation = selectionManager.getContextTextAndSelection$foundation();
                PlatformSelectionBehaviors_androidKt.m217addPlatformTextContextMenuItems71BSaZU(textContextMenuBuilderScope, context, false, contextTextAndSelection$foundation != null ? (AnnotatedString) contextTextAndSelection$foundation.first : null, contextTextAndSelection$foundation != null ? (TextRange) contextTextAndSelection$foundation.second : null, selectionManager.platformSelectionBehaviors, new BlurEffectKt$$ExternalSyntheticLambda1(i, selectionManager, context));
                return Unit.INSTANCE;
            case 15:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.f$0;
                LayoutCoordinates layoutCoordinates2 = ((MultiWidgetSelectionDelegate) obj).getLayoutCoordinates();
                LayoutCoordinates layoutCoordinates3 = ((MultiWidgetSelectionDelegate) obj2).getLayoutCoordinates();
                long jMo523localPositionOfR5De75A2 = 0;
                if (layoutCoordinates2 != null) {
                    jMo523localPositionOfR5De75A = layoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates2, 0L);
                    j = 4294967295L;
                    c = ' ';
                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo523localPositionOfR5De75A & 4294967295L)) + ((int) (layoutCoordinates2.mo522getSizeYbymL2g() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo523localPositionOfR5De75A >> 32)) + ((int) (layoutCoordinates2.mo522getSizeYbymL2g() >> 32)))) << 32);
                } else {
                    j = 4294967295L;
                    c = ' ';
                    jFloatToRawIntBits = 0;
                    jMo523localPositionOfR5De75A = 0;
                }
                if (layoutCoordinates3 != null) {
                    jMo523localPositionOfR5De75A2 = layoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates3, 0L);
                    jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo523localPositionOfR5De75A2 & j)) + ((int) (layoutCoordinates3.mo522getSizeYbymL2g() & j)))) & j) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo523localPositionOfR5De75A2 >> c)) + ((int) (layoutCoordinates3.mo522getSizeYbymL2g() >> c)))) << c);
                } else {
                    jFloatToRawIntBits2 = 0;
                }
                int i2 = (int) (jFloatToRawIntBits & j);
                int i3 = (int) (jMo523localPositionOfR5De75A & j);
                float fIntBitsToFloat = Float.intBitsToFloat(i2) - Float.intBitsToFloat(i3);
                int i4 = (int) (jFloatToRawIntBits >> c);
                int i5 = (int) (jMo523localPositionOfR5De75A >> c);
                float fIntBitsToFloat2 = Float.intBitsToFloat(i4) - Float.intBitsToFloat(i5);
                int i6 = (int) (jFloatToRawIntBits2 & j);
                int i7 = (int) (jMo523localPositionOfR5De75A2 & j);
                float fIntBitsToFloat3 = Float.intBitsToFloat(i6) - Float.intBitsToFloat(i7);
                int i8 = (int) (jFloatToRawIntBits2 >> c);
                int i9 = (int) (jMo523localPositionOfR5De75A2 >> c);
                float fIntBitsToFloat4 = Float.intBitsToFloat(i8) - Float.intBitsToFloat(i9);
                float fMax = Math.max(0.0f, Math.min(Float.intBitsToFloat(i2), Float.intBitsToFloat(i6)) - Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i7)));
                float fMax2 = Math.max(0.0f, Math.min(Float.intBitsToFloat(i4), Float.intBitsToFloat(i8)) - Math.max(Float.intBitsToFloat(i5), Float.intBitsToFloat(i9)));
                boolean z2 = fMax >= fIntBitsToFloat * 0.5f || fMax >= fIntBitsToFloat3 * 0.5f;
                if (fMax2 < fIntBitsToFloat2 * 0.5f && fMax2 < fIntBitsToFloat4 * 0.5f) {
                    z = true;
                }
                return Integer.valueOf((z2 && z) ? ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(Float.intBitsToFloat(i5)), Float.valueOf(Float.intBitsToFloat(i9))) : ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(Float.intBitsToFloat(i3)), Float.valueOf(Float.intBitsToFloat(i7))));
            case 16:
                SheetState sheetState = (SheetState) this.f$0;
                IntSize intSize = (IntSize) obj;
                SheetValue sheetValue = SheetValue.PartiallyExpanded;
                SheetValue sheetValue2 = SheetValue.Expanded;
                float fM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(((Constraints) obj2).value);
                SurfaceRequest.AnonymousClass1 anonymousClass1 = new SurfaceRequest.AnonymousClass1(22);
                SheetValue sheetValue3 = SheetValue.Hidden;
                anonymousClass1.at(sheetValue3, fM682getMaxHeightimpl);
                if (((int) (intSize.packedValue & 4294967295L)) > fM682getMaxHeightimpl / 2 && !sheetState.skipPartiallyExpanded) {
                    anonymousClass1.at(sheetValue, fM682getMaxHeightimpl / 2.0f);
                }
                int i10 = (int) (4294967295L & intSize.packedValue);
                if (i10 != 0) {
                    anonymousClass1.at(sheetValue2, Math.max(0.0f, fM682getMaxHeightimpl - i10));
                }
                Unit unit = Unit.INSTANCE;
                ArrayList arrayList = (ArrayList) anonymousClass1.val$requestCancellationCompleter;
                float[] fArr = (float[]) anonymousClass1.val$requestCancellationFuture;
                int size = arrayList.size();
                ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(size, fArr.length);
                DefaultDraggableAnchors defaultDraggableAnchors = new DefaultDraggableAnchors(arrayList, Arrays.copyOfRange(fArr, 0, size));
                int iOrdinal = ((SheetValue) ((DerivedSnapshotState) sheetState.anchoredDraggableState.val$requestCancellationFuture).getValue()).ordinal();
                if (iOrdinal == 0) {
                    sheetValue = sheetValue3;
                } else if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        throw new HttpException();
                    }
                    if (!defaultDraggableAnchors.hasPositionFor(sheetValue)) {
                        if (defaultDraggableAnchors.hasPositionFor(sheetValue2)) {
                            sheetValue = sheetValue2;
                        } else {
                            sheetValue = sheetValue3;
                        }
                    }
                } else if (defaultDraggableAnchors.hasPositionFor(sheetValue2)) {
                    sheetValue = sheetValue2;
                } else {
                    sheetValue = sheetValue3;
                }
                return new Pair(defaultDraggableAnchors, sheetValue);
            case 17:
                Dispatcher dispatcher = (Dispatcher) this.f$0;
                GapComposer gapComposer4 = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    String strM282getString2EP1pXo = LayoutUtilKt.m282getString2EP1pXo(R.string.m3c_dialog, gapComposer4);
                    Modifier modifierM143sizeInqDBjuR0$default = SizeKt.m143sizeInqDBjuR0$default((Modifier) dispatcher.readyAsyncCalls, AlertDialogKt.DialogMinWidth, AlertDialogKt.DialogMaxWidth, 10);
                    boolean zChanged = gapComposer4.changed(strM282getString2EP1pXo);
                    Object objRememberedValue = gapComposer4.rememberedValue();
                    if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new IconKt$$ExternalSyntheticLambda1(strM282getString2EP1pXo, 4);
                        gapComposer4.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierThen = modifierM143sizeInqDBjuR0$default.then(new AppendedSemanticsElement((Function1) objRememberedValue, false));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    long j5 = gapComposer4.compositeKeyHashCode;
                    int i11 = (int) (j5 ^ (j5 >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer4, modifierThen);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m295setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m295setimpl(gapComposer4, Integer.valueOf(i11), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer4, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    ((ComposableLambdaImpl) dispatcher.runningSyncCalls).invoke((Object) gapComposer4, (Object) 0);
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 18:
                SingleRowTopAppBarOverrideScope singleRowTopAppBarOverrideScope = (SingleRowTopAppBarOverrideScope) this.f$0;
                GapComposer gapComposer5 = (GapComposer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    FlowRowOverflow flowRowOverflow = Arrangement.End;
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Function3 function3 = singleRowTopAppBarOverrideScope.actions;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer5, 54);
                    long j6 = gapComposer5.compositeKeyHashCode;
                    int i12 = (int) (j6 ^ (j6 >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer5, companion);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(layoutNode$Companion$Constructor$2);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m295setimpl(gapComposer5, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer5, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m295setimpl(gapComposer5, Integer.valueOf(i12), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer5, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer5, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                    function3.invoke(RowScopeInstance.INSTANCE, gapComposer5, 6);
                    gapComposer5.end(true);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 19:
                ((Integer) obj2).getClass();
                ((ModalBottomSheetDialogLayout) this.f$0).Content$1(Stack.updateChangedFlags(1), (GapComposer) obj);
                return Unit.INSTANCE;
            case 20:
                zzky zzkyVar = (zzky) this.f$0;
                ((Integer) obj).getClass();
                if (obj2 instanceof ComposeNodeLifecycleCallback) {
                    ComposeNodeLifecycleCallback composeNodeLifecycleCallback = (ComposeNodeLifecycleCallback) obj2;
                    MutableScatterSet mutableScatterSet = (MutableScatterSet) zzkyVar.zzh;
                    if (mutableScatterSet == null) {
                        MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                        mutableScatterSet = new MutableScatterSet();
                        zzkyVar.zzh = mutableScatterSet;
                    }
                    mutableScatterSet.plusAssign(composeNodeLifecycleCallback);
                    ((MutableVector) zzkyVar.zze).add(composeNodeLifecycleCallback);
                }
                if (obj2 instanceof RememberObserverHolder) {
                    zzkyVar.forgetting((RememberObserverHolder) obj2);
                }
                if (obj2 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj2).release();
                }
                return Unit.INSTANCE;
            case 21:
                GapComposer gapComposer6 = (GapComposer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                if (gapComposer6.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    throw null;
                }
                gapComposer6.skipToGroupEnd();
                return Unit.INSTANCE;
            case 22:
                MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager = (MultiSubscriptionSnapshotFlowManager) this.f$0;
                Set set = (Set) obj;
                synchronized (multiSubscriptionSnapshotFlowManager.internalScopeRef) {
                    try {
                        MutableScatterMap mutableScatterMap = multiSubscriptionSnapshotFlowManager.subscriptions;
                        BlurEffectKt$$ExternalSyntheticLambda1 blurEffectKt$$ExternalSyntheticLambda1 = new BlurEffectKt$$ExternalSyntheticLambda1(7, set, multiSubscriptionSnapshotFlowManager);
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, blurEffectKt$$ExternalSyntheticLambda1);
                        Object[] objArr = mutableScatterMap.keys;
                        long[] jArr = mutableScatterMap.metadata;
                        int length = jArr.length - 2;
                        long j7 = -9187201950435737472L;
                        if (length >= 0) {
                            int i13 = 0;
                            j3 = 128;
                            while (true) {
                                long j8 = jArr[i13];
                                j4 = 255;
                                if ((((~j8) << 7) & j8 & j7) != j7) {
                                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                                    int i15 = 0;
                                    while (i15 < i14) {
                                        if ((j8 & 255) < 128) {
                                            blurEffectKt$$ExternalSyntheticLambda1.invoke(objArr[(i13 << 3) + i15]);
                                        }
                                        j8 >>= 8;
                                        i15++;
                                        j7 = j7;
                                    }
                                    j2 = j7;
                                    if (i14 == 8) {
                                    }
                                } else {
                                    j2 = j7;
                                }
                                if (i13 != length) {
                                    i13++;
                                    j7 = j2;
                                }
                            }
                        } else {
                            j2 = -9187201950435737472L;
                            j3 = 128;
                            j4 = 255;
                        }
                        MutableScatterSet mutableScatterSet3 = multiSubscriptionSnapshotFlowManager.toNotify;
                        Object[] objArr2 = mutableScatterSet3.elements;
                        long[] jArr2 = mutableScatterSet3.metadata;
                        int length2 = jArr2.length - 2;
                        if (length2 >= 0) {
                            int i16 = 0;
                            while (true) {
                                long j9 = jArr2[i16];
                                if ((((~j9) << 7) & j9 & j2) != j2) {
                                    int i17 = 8 - ((~(i16 - length2)) >>> 31);
                                    for (int i18 = 0; i18 < i17; i18++) {
                                        if ((j9 & j4) < j3) {
                                            ((SendChannel) objArr2[(i16 << 3) + i18]).mo842trySendJP2dKIU(Unit.INSTANCE);
                                        }
                                        j9 >>= 8;
                                    }
                                    if (i17 == 8) {
                                        if (i16 != length2) {
                                            i16++;
                                        }
                                    }
                                } else if (i16 != length2) {
                                    i16++;
                                }
                            }
                        }
                        multiSubscriptionSnapshotFlowManager.toNotify.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return Unit.INSTANCE;
            case 23:
                return invoke$androidx$compose$runtime$Recomposer$recompositionRunner$2$$ExternalSyntheticLambda0(obj, obj2);
            case 24:
                return invoke$androidx$compose$runtime$SingleSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1(obj, obj2);
            case 25:
                SnapshotStateObserver snapshotStateObserver = (SnapshotStateObserver) this.f$0;
                Collection collection = (Set) obj;
                AtomicReference atomicReference = snapshotStateObserver.pendingChanges;
                while (true) {
                    Object obj3 = atomicReference.get();
                    if (obj3 == null) {
                        collectionPlus = collection;
                    } else if (obj3 instanceof Set) {
                        collectionPlus = AppCompatHintHelper.listOf(obj3, collection);
                    } else {
                        if (!(obj3 instanceof List)) {
                            ComposerKt.composeRuntimeError("Unexpected notification");
                            throw new HttpException();
                        }
                        collectionPlus = CollectionsKt.plus((Collection) obj3, Collections.singletonList(collection));
                    }
                    do {
                        if (atomicReference.compareAndSet(obj3, collectionPlus)) {
                            if (snapshotStateObserver.drainChanges()) {
                                snapshotStateObserver.onChangedExecutor.invoke(new BasicTextKt$$ExternalSyntheticLambda0(26, snapshotStateObserver));
                            }
                            return Unit.INSTANCE;
                        }
                    } while (atomicReference.get() == obj3);
                }
                break;
            case 26:
                ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0 = (ZslControlImpl$$ExternalSyntheticLambda0) this.f$0;
                Rect composeRect = BrushKt.toComposeRect((RectF) obj);
                Rect composeRect2 = BrushKt.toComposeRect((RectF) obj2);
                switch (zslControlImpl$$ExternalSyntheticLambda0.$r8$classId) {
                    case 18:
                        zOverlaps = composeRect.overlaps(composeRect2);
                        break;
                    default:
                        zOverlaps = composeRect2.m377containsk4lQ0M(composeRect.m378getCenterF1C5BW0());
                        break;
                }
                return Boolean.valueOf(zOverlaps);
            case 27:
                ((Integer) obj2).getClass();
                PropertiesScreenKt.ProfileHero((Profile) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 28:
                ((Integer) obj2).getClass();
                PropertiesScreenKt.TypeChip((Profile.Type) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            default:
                ((Integer) obj2).getClass();
                zzje.SettingsRow((SettingsEntry) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ Updater$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }
}
