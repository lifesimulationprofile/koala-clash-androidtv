package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScope$CC;
import androidx.compose.foundation.lazy.LazyListIntervalContent$$ExternalSyntheticLambda2;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import coil.memory.RealWeakMemoryCache;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionManager {
    public LayoutCoordinates containerLayoutCoordinates;
    public CoroutineScope coroutineScope;
    public HapticFeedback hapticFeedBack;
    public boolean isLongPressOrClickSelection;
    public Function1 onCopyHandler;
    public PlatformSelectionBehaviorsImpl platformSelectionBehaviors;
    public Offset previousPosition;
    public SelectionLayout previousSelectionLayout;
    public final SelectionRegistrarImpl selectionRegistrar;
    public boolean showToolbar;
    public final ParcelableSnapshotMutableState _selection = Stack.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState _isInTouchMode = Stack.mutableStateOf$default(Boolean.TRUE);
    public Function1 onSelectionChange = new SelectionManager$$ExternalSyntheticLambda1(this, 7);
    public final RealWeakMemoryCache toolbarRequester = new RealWeakMemoryCache(4);
    public final FocusRequester focusRequester = new FocusRequester();
    public final ParcelableSnapshotMutableState hasFocus$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public final DerivedSnapshotState derivedContentRect$delegate = Stack.derivedStateOf(new SelectionManager$$ExternalSyntheticLambda0(this, 3));
    public final ParcelableSnapshotMutableState positionChangeState$delegate = new ParcelableSnapshotMutableState(Unit.INSTANCE, NeverEqualPolicy.INSTANCE);
    public final ParcelableSnapshotMutableState dragBeginPosition$delegate = Stack.mutableStateOf$default(new Offset(0));
    public final ParcelableSnapshotMutableState dragTotalDistance$delegate = Stack.mutableStateOf$default(new Offset(0));
    public final ParcelableSnapshotMutableState startHandlePosition$delegate = Stack.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState endHandlePosition$delegate = Stack.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState draggingHandle$delegate = Stack.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState currentDragPosition$delegate = Stack.mutableStateOf$default(null);

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        this.selectionRegistrar = selectionRegistrarImpl;
        selectionRegistrarImpl.onPositionChangeCallback = new SelectionManager$$ExternalSyntheticLambda1(this, 8);
        selectionRegistrarImpl.onSelectionUpdateStartCallback = new LazyListIntervalContent$$ExternalSyntheticLambda2(1, this);
        selectionRegistrarImpl.onSelectionUpdateCallback = new SelectionManager$$ExternalSyntheticLambda8(this);
        selectionRegistrarImpl.onSelectionUpdateEndCallback = new SelectionManager$$ExternalSyntheticLambda0(this, 4);
        selectionRegistrarImpl.onSelectableChangeCallback = new SelectionManager$$ExternalSyntheticLambda1(this, 2);
        selectionRegistrarImpl.afterSelectableUnsubscribe = new SelectionManager$$ExternalSyntheticLambda1(this, 3);
    }

    /* JADX INFO: renamed from: convertToContainerCoordinates-R5De75A, reason: not valid java name */
    public final long m219convertToContainerCoordinatesR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return 9205357640488583168L;
        }
        return requireContainerCoordinates$foundation().mo523localPositionOfR5De75A(layoutCoordinates, j);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0011  */
    public final void copy$foundation() {
        AnnotatedString annotatedString;
        Function1 function1;
        int iNextIndex;
        if (getSelection() != null) {
            SelectionRegistrarImpl selectionRegistrarImpl = this.selectionRegistrar;
            if (selectionRegistrarImpl.getSubselections()._size == 0) {
                annotatedString = null;
            } else {
                AnnotatedString.Builder builder = new AnnotatedString.Builder();
                ArrayList arrayListSort = selectionRegistrarImpl.sort(requireContainerCoordinates$foundation());
                ListIterator listIterator = arrayListSort.listIterator(arrayListSort.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        iNextIndex = -1;
                        break;
                    }
                    Selection selection = (Selection) selectionRegistrarImpl.getSubselections().get(((MultiWidgetSelectionDelegate) listIterator.previous()).selectableId);
                    if (selection != null && selection.start.offset != selection.end.offset) {
                        iNextIndex = listIterator.nextIndex();
                        break;
                    }
                }
                if (iNextIndex != -1) {
                    int size = arrayListSort.size();
                    int i = 0;
                    while (i < size) {
                        MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = (MultiWidgetSelectionDelegate) arrayListSort.get(i);
                        Selection selection2 = (Selection) selectionRegistrarImpl.getSubselections().get(multiWidgetSelectionDelegate.selectableId);
                        if (selection2 != null) {
                            AnnotatedString text = multiWidgetSelectionDelegate.getText();
                            long jTextRange = ParagraphKt.TextRange(selection2.start.offset, selection2.end.offset);
                            boolean z = i >= iNextIndex;
                            builder.append(text, TextRange.m644getMinimpl(jTextRange), TextRange.m643getMaximpl(jTextRange));
                            if (!z) {
                                builder.text.append('\n');
                            }
                        }
                        i++;
                    }
                }
                annotatedString = builder.toAnnotatedString();
            }
        } else {
            annotatedString = null;
        }
        if (annotatedString != null) {
            AnnotatedString annotatedString2 = annotatedString.text.length() > 0 ? annotatedString : null;
            if (annotatedString2 == null || (function1 = this.onCopyHandler) == null) {
                return;
            }
            function1.invoke(annotatedString2);
        }
    }

    public final MultiWidgetSelectionDelegate getAnchorSelectable$foundation(Selection.AnchorInfo anchorInfo) {
        return (MultiWidgetSelectionDelegate) this.selectionRegistrar._selectableMap.get(anchorInfo.selectableId);
    }

    public final Pair getContextTextAndSelection$foundation() {
        int iNextIndex;
        int iM644getMinimpl;
        int length;
        if (getSelection() == null) {
            return null;
        }
        SelectionRegistrarImpl selectionRegistrarImpl = this.selectionRegistrar;
        if (selectionRegistrarImpl._selectables.isEmpty()) {
            return null;
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder();
        ArrayList arrayListSort = selectionRegistrarImpl.sort(requireContainerCoordinates$foundation());
        ListIterator listIterator = arrayListSort.listIterator(arrayListSort.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            Selection selection = (Selection) selectionRegistrarImpl.getSubselections().get(((MultiWidgetSelectionDelegate) listIterator.previous()).selectableId);
            if (selection != null && selection.start.offset != selection.end.offset) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (iNextIndex != -1) {
            int size = arrayListSort.size();
            int i = 0;
            iM644getMinimpl = -1;
            length = -1;
            int i2 = 0;
            while (i2 < size) {
                MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = (MultiWidgetSelectionDelegate) arrayListSort.get(i2);
                Selection selection2 = (Selection) selectionRegistrarImpl.getSubselections().get(multiWidgetSelectionDelegate.selectableId);
                if (selection2 != null) {
                    AnnotatedString text = multiWidgetSelectionDelegate.getText();
                    long jTextRange = ParagraphKt.TextRange(selection2.start.offset, selection2.end.offset);
                    int i3 = i2 >= iNextIndex ? 1 : i;
                    if (iM644getMinimpl == -1) {
                        iM644getMinimpl = TextRange.m644getMinimpl(jTextRange);
                        builder.append(text, i, TextRange.m644getMinimpl(jTextRange));
                    }
                    builder.append(text, TextRange.m644getMinimpl(jTextRange), TextRange.m643getMaximpl(jTextRange));
                    StringBuilder sb = builder.text;
                    if (i3 == 0) {
                        sb.append('\n');
                    } else {
                        length = sb.length();
                        builder.append(text, TextRange.m643getMaximpl(jTextRange), text.text.length());
                    }
                }
                i2++;
                i = 0;
            }
        } else {
            iM644getMinimpl = -1;
            length = -1;
        }
        AnnotatedString annotatedString = builder.toAnnotatedString();
        if (iM644getMinimpl == -1 || length == -1) {
            return null;
        }
        return new Pair(annotatedString, new TextRange(ParagraphKt.TextRange(iM644getMinimpl, length)));
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    public final Selection getSelection() {
        return (Selection) this._selection.getValue();
    }

    public final boolean isInTouchMode() {
        return ((Boolean) this._isInTouchMode.getValue()).booleanValue();
    }

    public final boolean isNonEmptySelection$foundation() {
        Selection selection = getSelection();
        if (selection != null) {
            Selection.AnchorInfo anchorInfo = selection.end;
            Selection.AnchorInfo anchorInfo2 = selection.start;
            if (!Intrinsics.areEqual(anchorInfo2, anchorInfo)) {
                if (anchorInfo2.selectableId == anchorInfo.selectableId) {
                    return true;
                }
                LayoutCoordinates layoutCoordinatesRequireContainerCoordinates$foundation = requireContainerCoordinates$foundation();
                SelectionRegistrarImpl selectionRegistrarImpl = this.selectionRegistrar;
                ArrayList arrayListSort = selectionRegistrarImpl.sort(layoutCoordinatesRequireContainerCoordinates$foundation);
                int size = arrayListSort.size();
                for (int i = 0; i < size; i++) {
                    Selection selection2 = (Selection) selectionRegistrarImpl.getSubselections().get(((MultiWidgetSelectionDelegate) arrayListSort.get(i)).selectableId);
                    if (selection2 != null && selection2.start.offset != selection2.end.offset) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void onRelease() {
        HapticFeedback hapticFeedback;
        this.selectionRegistrar.subselections$delegate.setValue(LongObjectMapKt.EmptyLongObjectMap);
        this.showToolbar = false;
        updateSelectionToolbar();
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            if (!isInTouchMode() || (hapticFeedback = this.hapticFeedBack) == null) {
                return;
            }
            ((PlatformHapticFeedback) hapticFeedback).m503performHapticFeedbackCdsT49E(9);
        }
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (layoutCoordinates == null) {
            throw LazyItemScope$CC.m("null coordinates");
        }
        if (!layoutCoordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("unattached coordinates");
        }
        return layoutCoordinates;
    }

    public final void setInTouchMode(boolean z) {
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this._isInTouchMode;
        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() != z) {
            parcelableSnapshotMutableState.setValue(Boolean.valueOf(z));
            updateSelectionToolbar();
        }
    }

    public final void setSelection(Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a6  */
    public final void updateHandleOffsets() {
        long j;
        Offset offset;
        long jM214getHandlePositiondBAh8RU;
        Offset offset2;
        Selection.AnchorInfo anchorInfo;
        Selection.AnchorInfo anchorInfo2;
        Selection selection = getSelection();
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        Offset offset3 = null;
        MultiWidgetSelectionDelegate anchorSelectable$foundation = (selection == null || (anchorInfo2 = selection.start) == null) ? null : getAnchorSelectable$foundation(anchorInfo2);
        MultiWidgetSelectionDelegate anchorSelectable$foundation2 = (selection == null || (anchorInfo = selection.end) == null) ? null : getAnchorSelectable$foundation(anchorInfo);
        LayoutCoordinates layoutCoordinates2 = anchorSelectable$foundation != null ? anchorSelectable$foundation.getLayoutCoordinates() : null;
        LayoutCoordinates layoutCoordinates3 = anchorSelectable$foundation2 != null ? anchorSelectable$foundation2.getLayoutCoordinates() : null;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.endHandlePosition$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.startHandlePosition$delegate;
        if (selection == null || layoutCoordinates == null || !layoutCoordinates.isAttached() || (layoutCoordinates2 == null && layoutCoordinates3 == null)) {
            parcelableSnapshotMutableState2.setValue(null);
            parcelableSnapshotMutableState.setValue(null);
            return;
        }
        Rect rectVisibleBounds = SimpleLayoutKt.visibleBounds(layoutCoordinates);
        if (layoutCoordinates2 != null) {
            j = 9205357640488583168L;
            long jM214getHandlePositiondBAh8RU2 = anchorSelectable$foundation.m214getHandlePositiondBAh8RU(selection, true);
            if ((jM214getHandlePositiondBAh8RU2 & 9223372034707292159L) != 9205357640488583168L) {
                long jMo523localPositionOfR5De75A = layoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates2, jM214getHandlePositiondBAh8RU2);
                offset = new Offset(jMo523localPositionOfR5De75A);
                if (getDraggingHandle() != Handle.SelectionStart && !SimpleLayoutKt.m224containsInclusiveUv8p0NA(rectVisibleBounds, jMo523localPositionOfR5De75A)) {
                }
            }
            parcelableSnapshotMutableState2.setValue(offset);
            if (layoutCoordinates3 != null) {
                jM214getHandlePositiondBAh8RU = anchorSelectable$foundation2.m214getHandlePositiondBAh8RU(selection, false);
                if ((jM214getHandlePositiondBAh8RU & 9223372034707292159L) != j) {
                    long jMo523localPositionOfR5De75A2 = layoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates3, jM214getHandlePositiondBAh8RU);
                    offset2 = new Offset(jMo523localPositionOfR5De75A2);
                    if (getDraggingHandle() != Handle.SelectionEnd || SimpleLayoutKt.m224containsInclusiveUv8p0NA(rectVisibleBounds, jMo523localPositionOfR5De75A2)) {
                        offset3 = offset2;
                    }
                }
            }
            parcelableSnapshotMutableState.setValue(offset3);
        }
        j = 9205357640488583168L;
        offset = null;
        parcelableSnapshotMutableState2.setValue(offset);
        if (layoutCoordinates3 != null) {
            jM214getHandlePositiondBAh8RU = anchorSelectable$foundation2.m214getHandlePositiondBAh8RU(selection, false);
            if ((jM214getHandlePositiondBAh8RU & 9223372034707292159L) != j) {
                long jMo523localPositionOfR5De75A3 = layoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates3, jM214getHandlePositiondBAh8RU);
                offset2 = new Offset(jMo523localPositionOfR5De75A3);
                if (getDraggingHandle() != Handle.SelectionEnd) {
                    offset3 = offset2;
                } else {
                    offset3 = offset2;
                }
            }
        }
        parcelableSnapshotMutableState.setValue(offset3);
    }

    /* JADX INFO: renamed from: updateSelection-jyLRC_s$foundation, reason: not valid java name */
    public final boolean m220updateSelectionjyLRC_s$foundation(long j, long j2, boolean z, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
        ArrayList arrayList;
        SelectionLayout singleSelectionLayout;
        SelectionRegistrarImpl selectionRegistrarImpl;
        TextLayoutResult textLayoutResult;
        long j3;
        int i;
        int i2;
        SelectionLayoutBuilder selectionLayoutBuilder;
        long j4;
        int iAppendSelectableInfo_Parwq6A$otherDirection;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        SelectionLayoutBuilder selectionLayoutBuilder2;
        int i9;
        int iM226getOffsetForPosition3MmeM6k;
        int i10;
        Selection.AnchorInfo anchorInfo;
        char c;
        TextLayoutResult textLayoutResult2;
        Selection.AnchorInfo anchorInfo2;
        this.draggingHandle$delegate.setValue(z ? Handle.SelectionStart : Handle.SelectionEnd);
        this.currentDragPosition$delegate.setValue(new Offset(j));
        LayoutCoordinates layoutCoordinatesRequireContainerCoordinates$foundation = requireContainerCoordinates$foundation();
        SelectionRegistrarImpl selectionRegistrarImpl2 = this.selectionRegistrar;
        ArrayList arrayListSort = selectionRegistrarImpl2.sort(layoutCoordinatesRequireContainerCoordinates$foundation);
        int i11 = LongIntMapKt.$r8$clinit;
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(6);
        int size = arrayListSort.size();
        for (int i12 = 0; i12 < size; i12++) {
            mutableLongIntMap.set(i12, ((MultiWidgetSelectionDelegate) arrayListSort.get(i12)).selectableId);
        }
        long j5 = 9223372034707292159L;
        SelectionLayoutBuilder selectionLayoutBuilder3 = new SelectionLayoutBuilder(j, j2, layoutCoordinatesRequireContainerCoordinates$foundation, z, (j2 & 9223372034707292159L) == 9205357640488583168L ? null : getSelection(), new MaterialButtonToggleGroup.AnonymousClass1(2, mutableLongIntMap));
        int size2 = arrayListSort.size();
        int i13 = 0;
        while (true) {
            arrayList = selectionLayoutBuilder3.infoList;
            if (i13 >= size2) {
                break;
            }
            MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = (MultiWidgetSelectionDelegate) arrayListSort.get(i13);
            LayoutCoordinates layoutCoordinates = multiWidgetSelectionDelegate.getLayoutCoordinates();
            if (layoutCoordinates == null || (textLayoutResult = (TextLayoutResult) multiWidgetSelectionDelegate.layoutResultCallback.invoke()) == null) {
                selectionRegistrarImpl2 = selectionRegistrarImpl2;
                i = size2;
                i2 = i13;
                arrayListSort = arrayListSort;
                j3 = j5;
                selectionLayoutBuilder2 = selectionLayoutBuilder3;
            } else {
                j3 = j5;
                long jMo523localPositionOfR5De75A = selectionLayoutBuilder3.containerCoordinates.mo523localPositionOfR5De75A(layoutCoordinates, 0L);
                long jM372minusMKHz9U = Offset.m372minusMKHz9U(selectionLayoutBuilder3.currentPosition, jMo523localPositionOfR5De75A);
                long j6 = selectionLayoutBuilder3.previousHandlePosition;
                long jM372minusMKHz9U2 = (j6 & j3) == 9205357640488583168L ? 9205357640488583168L : Offset.m372minusMKHz9U(j6, jMo523localPositionOfR5De75A);
                long j7 = multiWidgetSelectionDelegate.selectableId;
                TextLayoutResult textLayoutResult3 = textLayoutResult;
                long j8 = textLayoutResult3.size;
                i = size2;
                i2 = i13;
                float f = (int) (j8 >> 32);
                float f2 = (int) (j8 & 4294967295L);
                int i14 = (int) (jM372minusMKHz9U >> 32);
                int i15 = Float.intBitsToFloat(i14) < 0.0f ? 1 : Float.intBitsToFloat(i14) > f ? 3 : 2;
                int i16 = (int) (jM372minusMKHz9U & 4294967295L);
                int i17 = Float.intBitsToFloat(i16) < 0 ? 1 : Float.intBitsToFloat(i16) > f2 ? 3 : 2;
                boolean z2 = selectionLayoutBuilder3.isStartHandle;
                Selection selection = selectionLayoutBuilder3.previousSelection;
                if (z2) {
                    selectionLayoutBuilder = selectionLayoutBuilder3;
                    j4 = j7;
                    iAppendSelectableInfo_Parwq6A$otherDirection = SimpleLayoutKt.appendSelectableInfo_Parwq6A$otherDirection(i15, i17, selectionLayoutBuilder, j4, selection != null ? selection.end : null);
                    i7 = iAppendSelectableInfo_Parwq6A$otherDirection;
                    i3 = i15;
                    i5 = i3;
                    i4 = i17;
                    i8 = i4;
                    i6 = i7;
                } else {
                    selectionLayoutBuilder = selectionLayoutBuilder3;
                    j4 = j7;
                    iAppendSelectableInfo_Parwq6A$otherDirection = SimpleLayoutKt.appendSelectableInfo_Parwq6A$otherDirection(i15, i17, selectionLayoutBuilder, j4, selection != null ? selection.start : null);
                    i3 = i15;
                    i4 = i17;
                    i5 = iAppendSelectableInfo_Parwq6A$otherDirection;
                    i6 = i3;
                    i7 = i4;
                    i8 = i5;
                }
                selectionLayoutBuilder2 = selectionLayoutBuilder;
                int iResolve2dDirection = SimpleLayoutKt.resolve2dDirection(i3, i4);
                if (iResolve2dDirection == 2 || iResolve2dDirection != iAppendSelectableInfo_Parwq6A$otherDirection) {
                    int length = textLayoutResult3.layoutInput.text.text.length();
                    MaterialButtonToggleGroup.AnonymousClass1 anonymousClass1 = selectionLayoutBuilder2.selectableIdOrderingComparator;
                    if (z2) {
                        iM226getOffsetForPosition3MmeM6k = SimpleLayoutKt.m226getOffsetForPosition3MmeM6k(jM372minusMKHz9U, textLayoutResult3);
                        if (selection == null || (anchorInfo2 = selection.end) == null) {
                            textLayoutResult2 = textLayoutResult3;
                            length = iM226getOffsetForPosition3MmeM6k;
                        } else {
                            textLayoutResult2 = textLayoutResult3;
                            int iCompare = anonymousClass1.compare(Long.valueOf(anchorInfo2.selectableId), Long.valueOf(j4));
                            if (iCompare < 0) {
                                length = 0;
                            } else if (iCompare <= 0) {
                                length = anchorInfo2.offset;
                            }
                        }
                        i10 = length;
                        textLayoutResult3 = textLayoutResult2;
                    } else {
                        int iM226getOffsetForPosition3MmeM6k2 = SimpleLayoutKt.m226getOffsetForPosition3MmeM6k(jM372minusMKHz9U, textLayoutResult3);
                        if (selection == null || (anchorInfo = selection.start) == null) {
                            i9 = iM226getOffsetForPosition3MmeM6k2;
                            iM226getOffsetForPosition3MmeM6k = i9;
                        } else {
                            i9 = iM226getOffsetForPosition3MmeM6k2;
                            int iCompare2 = anonymousClass1.compare(Long.valueOf(anchorInfo.selectableId), Long.valueOf(j4));
                            if (iCompare2 < 0) {
                                length = 0;
                            } else if (iCompare2 <= 0) {
                                length = anchorInfo.offset;
                            }
                            iM226getOffsetForPosition3MmeM6k = length;
                        }
                        i10 = i9;
                    }
                    int iM226getOffsetForPosition3MmeM6k3 = (jM372minusMKHz9U2 & j3) == 9205357640488583168L ? -1 : SimpleLayoutKt.m226getOffsetForPosition3MmeM6k(jM372minusMKHz9U2, textLayoutResult3);
                    c = 2;
                    int i18 = selectionLayoutBuilder2.currentSlot + 2;
                    selectionLayoutBuilder2.currentSlot = i18;
                    long j9 = j4;
                    SelectableInfo selectableInfo = new SelectableInfo(j9, i18, iM226getOffsetForPosition3MmeM6k, i10, iM226getOffsetForPosition3MmeM6k3, textLayoutResult3);
                    selectionLayoutBuilder2.startSlot = selectionLayoutBuilder2.updateSlot(selectionLayoutBuilder2.startSlot, i5, i8);
                    selectionLayoutBuilder2.endSlot = selectionLayoutBuilder2.updateSlot(selectionLayoutBuilder2.endSlot, i6, i7);
                    selectionLayoutBuilder2.selectableIdToInfoListIndex.set(arrayList.size(), j9);
                    arrayList.add(selectableInfo);
                }
                i13 = i2 + 1;
                size2 = i;
                selectionLayoutBuilder3 = selectionLayoutBuilder2;
                j5 = j3;
                arrayListSort = arrayListSort;
                selectionRegistrarImpl2 = selectionRegistrarImpl2;
            }
            c = 2;
            i13 = i2 + 1;
            size2 = i;
            selectionLayoutBuilder3 = selectionLayoutBuilder2;
            j5 = j3;
            arrayListSort = arrayListSort;
            selectionRegistrarImpl2 = selectionRegistrarImpl2;
        }
        SelectionRegistrarImpl selectionRegistrarImpl3 = selectionRegistrarImpl2;
        SelectionLayoutBuilder selectionLayoutBuilder4 = selectionLayoutBuilder3;
        int i19 = selectionLayoutBuilder4.currentSlot + 1;
        int size3 = arrayList.size();
        if (size3 == 0) {
            singleSelectionLayout = null;
        } else if (size3 != 1) {
            int i20 = selectionLayoutBuilder4.startSlot;
            int i21 = i20 == -1 ? i19 : i20;
            int i22 = selectionLayoutBuilder4.endSlot;
            singleSelectionLayout = new MultiSelectionLayout(selectionLayoutBuilder4.selectableIdToInfoListIndex, arrayList, i21, i22 == -1 ? i19 : i22, selectionLayoutBuilder4.isStartHandle, selectionLayoutBuilder4.previousSelection);
        } else {
            SelectableInfo selectableInfo2 = (SelectableInfo) CollectionsKt.single(arrayList);
            int i23 = selectionLayoutBuilder4.startSlot;
            int i24 = i23 == -1 ? i19 : i23;
            int i25 = selectionLayoutBuilder4.endSlot;
            singleSelectionLayout = new SingleSelectionLayout(selectionLayoutBuilder4.isStartHandle, i24, i25 == -1 ? i19 : i25, selectionLayoutBuilder4.previousSelection, selectableInfo2);
        }
        if (singleSelectionLayout == null || !singleSelectionLayout.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return false;
        }
        Selection selectionAdjust = selectionAdjustment$Companion$$ExternalSyntheticLambda0.adjust(singleSelectionLayout);
        if (!Intrinsics.areEqual(selectionAdjust, getSelection())) {
            if (isInTouchMode()) {
                selectionRegistrarImpl = selectionRegistrarImpl3;
                ArrayList arrayList2 = selectionRegistrarImpl._selectables;
                int size4 = arrayList2.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    if (((MultiWidgetSelectionDelegate) arrayList2.get(i26)).getText().text.length() > 0) {
                        HapticFeedback hapticFeedback = this.hapticFeedBack;
                        if (hapticFeedback == null) {
                            break;
                        }
                        ((PlatformHapticFeedback) hapticFeedback).m503performHapticFeedbackCdsT49E(9);
                        break;
                    }
                }
            } else {
                selectionRegistrarImpl = selectionRegistrarImpl3;
            }
            selectionRegistrarImpl.subselections$delegate.setValue(singleSelectionLayout.createSubSelections(selectionAdjust));
            this.onSelectionChange.invoke(selectionAdjust);
            this.isLongPressOrClickSelection = false;
        }
        this.previousSelectionLayout = singleSelectionLayout;
        return true;
    }

    public final void updateSelectionToolbar() {
        StandaloneCoroutine standaloneCoroutine;
        if (((Boolean) this.hasFocus$delegate.getValue()).booleanValue()) {
            boolean z = this.showToolbar;
            RealWeakMemoryCache realWeakMemoryCache = this.toolbarRequester;
            if (z && isInTouchMode()) {
                if (((Rect) this.derivedContentRect$delegate.getValue()) == null) {
                    return;
                }
                realWeakMemoryCache.show();
            } else {
                TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode = (TextContextMenuToolbarHandlerNode) realWeakMemoryCache.cache;
                if (textContextMenuToolbarHandlerNode == null || (standaloneCoroutine = textContextMenuToolbarHandlerNode.textToolbarJob) == null) {
                    return;
                }
                standaloneCoroutine.cancel((CancellationException) null);
                textContextMenuToolbarHandlerNode.textToolbarJob = null;
            }
        }
    }
}
