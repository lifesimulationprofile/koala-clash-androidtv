package androidx.compose.foundation.text.selection;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionManager$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SelectionManager f$0;

    public /* synthetic */ SelectionManager$$ExternalSyntheticLambda0(SelectionManager selectionManager, int i) {
        this.$r8$classId = i;
        this.f$0 = selectionManager;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x026f  */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LayoutCoordinates layoutCoordinates;
        List list;
        Rect rect;
        List list2;
        int i;
        int[] iArr;
        int i2;
        MultiWidgetSelectionDelegate multiWidgetSelectionDelegate;
        boolean z;
        long j;
        int iNextIndex;
        CoroutineScope coroutineScope;
        Selection selection;
        int i3 = this.$r8$classId;
        boolean z2 = false;
        int i4 = 1;
        SelectionManager selectionManager = this.f$0;
        switch (i3) {
            case 0:
                selectionManager.onRelease();
                return Unit.INSTANCE;
            case 1:
                Offset offset = (Offset) selectionManager.endHandlePosition$delegate.getValue();
                return new Offset(offset != null ? offset.packedValue : 9205357640488583168L);
            case 2:
                Offset offset2 = (Offset) selectionManager.startHandlePosition$delegate.getValue();
                return new Offset(offset2 != null ? offset2.packedValue : 9205357640488583168L);
            case 3:
                SelectionRegistrarImpl selectionRegistrarImpl = selectionManager.selectionRegistrar;
                selectionManager.positionChangeState$delegate.getValue();
                Unit unit = Unit.INSTANCE;
                if (selectionManager.getSelection() != null && (layoutCoordinates = selectionManager.containerLayoutCoordinates) != null && layoutCoordinates.isAttached()) {
                    ArrayList arrayListSort = selectionRegistrarImpl.sort(selectionManager.requireContainerCoordinates$foundation());
                    ArrayList arrayList = new ArrayList(arrayListSort.size());
                    int size = arrayListSort.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        MultiWidgetSelectionDelegate multiWidgetSelectionDelegate2 = (MultiWidgetSelectionDelegate) arrayListSort.get(i5);
                        Selection selection2 = (Selection) selectionRegistrarImpl.getSubselections().get(multiWidgetSelectionDelegate2.selectableId);
                        Pair pair = selection2 != null ? new Pair(multiWidgetSelectionDelegate2, selection2) : null;
                        if (pair != null) {
                            arrayList.add(pair);
                        }
                    }
                    int size2 = arrayList.size();
                    List listListOf = arrayList;
                    listListOf = arrayList;
                    if (size2 != 0 && size2 != 1) {
                        listListOf = AppCompatHintHelper.listOf(CollectionsKt.first((List) arrayList), CollectionsKt.last(arrayList));
                    }
                    if (!listListOf.isEmpty()) {
                        boolean zIsEmpty = listListOf.isEmpty();
                        Rect rect2 = SimpleLayoutKt.invertedInfiniteRect;
                        if (zIsEmpty) {
                            rect = rect2;
                        } else {
                            int size3 = listListOf.size();
                            int i6 = 0;
                            float fMin = Float.POSITIVE_INFINITY;
                            float fMin2 = Float.POSITIVE_INFINITY;
                            float fMax = Float.NEGATIVE_INFINITY;
                            float fMax2 = Float.NEGATIVE_INFINITY;
                            while (i6 < size3) {
                                Pair pair2 = (Pair) list.get(i6);
                                MultiWidgetSelectionDelegate multiWidgetSelectionDelegate3 = (MultiWidgetSelectionDelegate) pair2.first;
                                Selection selection3 = (Selection) pair2.second;
                                int i7 = selection3.start.offset;
                                int i8 = selection3.end.offset;
                                if (i7 != i8) {
                                    boolean z3 = z2;
                                    LayoutCoordinates layoutCoordinates2 = multiWidgetSelectionDelegate3.getLayoutCoordinates();
                                    if (layoutCoordinates2 == null) {
                                        list = listListOf;
                                        list = listListOf;
                                        list2 = list;
                                    } else {
                                        int iMin = Math.min(i7, i8);
                                        int iMax = Math.max(i7, i8) - i4;
                                        if (iMin == iMax) {
                                            list = listListOf;
                                            iArr = new int[i4];
                                            iArr[z3 ? 1 : 0] = iMin;
                                            i = i4;
                                        } else {
                                            list = listListOf;
                                            i = i4;
                                            int[] iArr2 = new int[2];
                                            iArr2[z3 ? 1 : 0] = iMin;
                                            iArr2[i] = iMax;
                                            iArr = iArr2;
                                        }
                                        int length = iArr.length;
                                        int[] iArr3 = iArr;
                                        int i9 = z3 ? 1 : 0;
                                        float fMin3 = Float.POSITIVE_INFINITY;
                                        float fMax3 = Float.NEGATIVE_INFINITY;
                                        float fMax4 = Float.NEGATIVE_INFINITY;
                                        float fMin4 = Float.POSITIVE_INFINITY;
                                        List list3 = list;
                                        while (i9 < length) {
                                            int i10 = length;
                                            int i11 = iArr3[i9];
                                            List list4 = list3;
                                            TextLayoutResult textLayoutResult = (TextLayoutResult) multiWidgetSelectionDelegate3.layoutResultCallback.invoke();
                                            Rect boundingBox = Rect.Zero;
                                            if (textLayoutResult == null) {
                                                i2 = i9;
                                                multiWidgetSelectionDelegate = multiWidgetSelectionDelegate3;
                                            } else {
                                                i2 = i9;
                                                int length2 = textLayoutResult.layoutInput.text.text.length();
                                                multiWidgetSelectionDelegate = multiWidgetSelectionDelegate3;
                                                if (length2 >= i) {
                                                    z = z3;
                                                    boundingBox = textLayoutResult.getBoundingBox(RangesKt.coerceIn(i11, z ? 1 : 0, length2 - 1));
                                                }
                                                Rect rect3 = boundingBox;
                                                fMin4 = Math.min(fMin4, rect3.left);
                                                fMin3 = Math.min(fMin3, rect3.top);
                                                fMax3 = Math.max(fMax3, rect3.right);
                                                fMax4 = Math.max(fMax4, rect3.bottom);
                                                i9 = i2 + 1;
                                                z3 = z;
                                                length = i10;
                                                list3 = list4;
                                                multiWidgetSelectionDelegate3 = multiWidgetSelectionDelegate;
                                                i = 1;
                                            }
                                            z = z3;
                                            Rect rect4 = boundingBox;
                                            fMin4 = Math.min(fMin4, rect4.left);
                                            fMin3 = Math.min(fMin3, rect4.top);
                                            fMax3 = Math.max(fMax3, rect4.right);
                                            fMax4 = Math.max(fMax4, rect4.bottom);
                                            i9 = i2 + 1;
                                            z3 = z;
                                            length = i10;
                                            list3 = list4;
                                            multiWidgetSelectionDelegate3 = multiWidgetSelectionDelegate;
                                            i = 1;
                                        }
                                        list2 = list3;
                                        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fMin4)) << 32) | (((long) Float.floatToRawIntBits(fMin3)) & 4294967295L);
                                        long jFloatToRawIntBits2 = Float.floatToRawIntBits(fMax3);
                                        long jFloatToRawIntBits3 = ((long) Float.floatToRawIntBits(fMax4)) & 4294967295L;
                                        long jMo523localPositionOfR5De75A = layoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates2, jFloatToRawIntBits);
                                        long jMo523localPositionOfR5De75A2 = layoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates2, jFloatToRawIntBits3 | (jFloatToRawIntBits2 << 32));
                                        fMin = Math.min(fMin, Float.intBitsToFloat((int) (jMo523localPositionOfR5De75A >> 32)));
                                        fMin2 = Math.min(fMin2, Float.intBitsToFloat((int) (jMo523localPositionOfR5De75A & 4294967295L)));
                                        fMax = Math.max(fMax, Float.intBitsToFloat((int) (jMo523localPositionOfR5De75A2 >> 32)));
                                        fMax2 = Math.max(fMax2, Float.intBitsToFloat((int) (jMo523localPositionOfR5De75A2 & 4294967295L)));
                                    }
                                } else {
                                    list = listListOf;
                                    list = listListOf;
                                    list2 = list;
                                }
                                i6++;
                                size3 = size3;
                                list = list2;
                                z2 = false;
                                i4 = 1;
                            }
                            list = listListOf;
                            rect = new Rect(fMin, fMin2, fMax, fMax2);
                        }
                        if (!rect.equals(rect2)) {
                            Rect rectIntersect = SimpleLayoutKt.visibleBounds(layoutCoordinates).intersect(rect);
                            if (rectIntersect.right - rectIntersect.left >= 0.0f && rectIntersect.bottom - rectIntersect.top >= 0.0f) {
                                Rect rectM381translatek4lQ0M = rectIntersect.m381translatek4lQ0M(layoutCoordinates.mo525localToRootMKHz9U(0L));
                                return Rect.copy$default(rectM381translatek4lQ0M, 0.0f, 0.0f, (SelectionHandlesKt.HandleHeight * 4) + rectM381translatek4lQ0M.bottom, 7);
                            }
                        }
                    }
                }
                return null;
            case 4:
                SelectionManager selectionManager2 = this.f$0;
                selectionManager2.showToolbar = true;
                selectionManager2.updateSelectionToolbar();
                selectionManager2.draggingHandle$delegate.setValue(null);
                selectionManager2.currentDragPosition$delegate.setValue(null);
                if (selectionManager2.isLongPressOrClickSelection && selectionManager2.isNonEmptySelection$foundation()) {
                    Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    Ref$LongRef ref$LongRef = new Ref$LongRef();
                    SelectionRegistrarImpl selectionRegistrarImpl2 = selectionManager2.selectionRegistrar;
                    ArrayList arrayListSort2 = selectionRegistrarImpl2.sort(selectionManager2.requireContainerCoordinates$foundation());
                    ListIterator listIterator = arrayListSort2.listIterator(arrayListSort2.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            j = 0;
                            Selection selection4 = (Selection) selectionRegistrarImpl2.getSubselections().get(((MultiWidgetSelectionDelegate) listIterator.previous()).selectableId);
                            if (selection4 != null && selection4.start.offset != selection4.end.offset) {
                                iNextIndex = listIterator.nextIndex();
                            }
                        } else {
                            j = 0;
                            iNextIndex = -1;
                        }
                    }
                    if (iNextIndex != -1) {
                        int size4 = arrayListSort2.size();
                        int i12 = 0;
                        while (i12 < size4) {
                            MultiWidgetSelectionDelegate multiWidgetSelectionDelegate4 = (MultiWidgetSelectionDelegate) arrayListSort2.get(i12);
                            Selection selection5 = (Selection) selectionRegistrarImpl2.getSubselections().get(multiWidgetSelectionDelegate4.selectableId);
                            if (selection5 != null) {
                                AnnotatedString text = multiWidgetSelectionDelegate4.getText();
                                long jTextRange = ParagraphKt.TextRange(selection5.start.offset, selection5.end.offset);
                                i4 = i12 < iNextIndex ? 0 : 1;
                                long j2 = multiWidgetSelectionDelegate4.selectableId;
                                if (i4 != 0) {
                                    ref$ObjectRef.element = text;
                                    ref$ObjectRef2.element = new TextRange(jTextRange);
                                    ref$LongRef.element = j2;
                                }
                            } else {
                                i12++;
                            }
                        }
                    }
                    Object obj = ref$ObjectRef.element;
                    if (obj != null && ref$ObjectRef2.element != null && ref$LongRef.element != j && ((CharSequence) obj).length() > 0 && (coroutineScope = selectionManager2.coroutineScope) != null) {
                        JobKt.launch$default(coroutineScope, null, new NavHostKt$NavHost$29$1(selectionManager2, ref$ObjectRef, ref$ObjectRef2, ref$LongRef, null, 6), 3);
                    }
                }
                selectionManager2.isLongPressOrClickSelection = false;
                return Unit.INSTANCE;
            case 5:
                selectionManager.copy$foundation();
                if (selectionManager.isInTouchMode()) {
                    selectionManager.onRelease();
                }
                return Unit.INSTANCE;
            case 6:
                return Boolean.valueOf((selectionManager.showToolbar && selectionManager.isInTouchMode()) ? false : true);
            default:
                SelectionRegistrarImpl selectionRegistrarImpl3 = selectionManager.selectionRegistrar;
                ArrayList arrayListSort3 = selectionRegistrarImpl3.sort(selectionManager.requireContainerCoordinates$foundation());
                if (!arrayListSort3.isEmpty()) {
                    MutableLongObjectMap mutableLongObjectMap = LongObjectMapKt.EmptyLongObjectMap;
                    MutableLongObjectMap mutableLongObjectMap2 = new MutableLongObjectMap();
                    int i13 = 0;
                    Selection selection6 = null;
                    Selection selection7 = null;
                    for (int size5 = arrayListSort3.size(); i13 < size5; size5 = size5) {
                        MultiWidgetSelectionDelegate multiWidgetSelectionDelegate5 = (MultiWidgetSelectionDelegate) arrayListSort3.get(i13);
                        long j3 = multiWidgetSelectionDelegate5.selectableId;
                        TextLayoutResult textLayoutResult2 = (TextLayoutResult) multiWidgetSelectionDelegate5.layoutResultCallback.invoke();
                        if (textLayoutResult2 == null) {
                            selection = null;
                        } else {
                            int length3 = textLayoutResult2.layoutInput.text.text.length();
                            selection = new Selection(new Selection.AnchorInfo(textLayoutResult2.getBidiRunDirection(0), 0, j3), new Selection.AnchorInfo(textLayoutResult2.getBidiRunDirection(Math.max(length3 - 1, 0)), length3, j3), false);
                        }
                        if (selection != null) {
                            if (selection6 == null) {
                                selection6 = selection;
                            }
                            long j4 = multiWidgetSelectionDelegate5.selectableId;
                            int iFindAbsoluteInsertIndex = mutableLongObjectMap2.findAbsoluteInsertIndex(j4);
                            Object[] objArr = mutableLongObjectMap2.values;
                            Object obj2 = objArr[iFindAbsoluteInsertIndex];
                            mutableLongObjectMap2.keys[iFindAbsoluteInsertIndex] = j4;
                            objArr[iFindAbsoluteInsertIndex] = selection;
                            selection7 = selection;
                        }
                        i13++;
                        arrayListSort3 = arrayListSort3;
                    }
                    if (mutableLongObjectMap2._size != 0) {
                        if (selection6 != selection7) {
                            selection6 = new Selection(selection6.start, selection7.end, false);
                        }
                        selectionRegistrarImpl3.subselections$delegate.setValue(mutableLongObjectMap2);
                        selectionManager.onSelectionChange.invoke(selection6);
                        selectionManager.previousSelectionLayout = null;
                    }
                }
                return Unit.INSTANCE;
        }
    }
}
