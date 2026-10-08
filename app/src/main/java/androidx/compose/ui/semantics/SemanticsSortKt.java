package androidx.compose.ui.semantics;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.Navigator;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsSortKt {
    public static final SemanticsPropertyKey.AnonymousClass1 UnmergedConfigComparator;
    public static final Comparator[] semanticComparators;

    static {
        Comparator[] comparatorArr = new Comparator[2];
        int i = 0;
        while (i < 2) {
            comparatorArr[i] = new MaterialButtonToggleGroup.AnonymousClass1(4, new MaterialButtonToggleGroup.AnonymousClass1(i == 0 ? LtrBoundsComparator.INSTANCE$1 : LtrBoundsComparator.INSTANCE));
            i++;
        }
        semanticComparators = comparatorArr;
        UnmergedConfigComparator = SemanticsPropertyKey.AnonymousClass1.INSTANCE$20;
    }

    public static final void geometryDepthFirstSearch(SemanticsNode semanticsNode, ArrayList arrayList, Navigator.AnonymousClass1 anonymousClass1, Navigator.AnonymousClass1 anonymousClass2, MutableIntObjectMap mutableIntObjectMap) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        Object obj = semanticsConfiguration.props.get(SemanticsProperties.IsTraversalGroup);
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if ((zBooleanValue || ((Boolean) anonymousClass2.invoke(semanticsNode)).booleanValue()) && ((Boolean) anonymousClass1.invoke(semanticsNode)).booleanValue()) {
            arrayList.add(semanticsNode);
        }
        if (zBooleanValue) {
            mutableIntObjectMap.set(semanticsNode.id, subtreeSortedByGeometryGrouping(semanticsNode, anonymousClass1, anonymousClass2, SemanticsNode.getChildren$ui$default(7, semanticsNode)));
            return;
        }
        List children$ui$default = SemanticsNode.getChildren$ui$default(7, semanticsNode);
        int size = children$ui$default.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch((SemanticsNode) children$ui$default.get(i), arrayList, anonymousClass1, anonymousClass2, mutableIntObjectMap);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d0  */
    public static final ArrayList subtreeSortedByGeometryGrouping(SemanticsNode semanticsNode, Navigator.AnonymousClass1 anonymousClass1, Navigator.AnonymousClass1 anonymousClass2, List list) {
        int i;
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        MutableIntObjectMap mutableIntObjectMap2 = new MutableIntObjectMap();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            geometryDepthFirstSearch((SemanticsNode) list.get(i2), arrayList, anonymousClass1, anonymousClass2, mutableIntObjectMap2);
        }
        char c = semanticsNode.layoutNode.layoutDirection == LayoutDirection.Rtl ? (char) 1 : (char) 0;
        ArrayList arrayList2 = new ArrayList(arrayList.size() / 2);
        int lastIndex = AppCompatHintHelper.getLastIndex(arrayList);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                SemanticsNode semanticsNode2 = (SemanticsNode) arrayList.get(i3);
                if (i3 == 0) {
                    i = 0;
                    Rect boundsInWindow = semanticsNode2.getBoundsInWindow();
                    SemanticsNode[] semanticsNodeArr = new SemanticsNode[1];
                    semanticsNodeArr[i] = semanticsNode2;
                    arrayList2.add(new Pair(boundsInWindow, AppCompatHintHelper.mutableListOf(semanticsNodeArr)));
                    break;
                }
                float f = semanticsNode2.getBoundsInWindow().top;
                float f2 = semanticsNode2.getBoundsInWindow().bottom;
                boolean z = f >= f2;
                int lastIndex2 = AppCompatHintHelper.getLastIndex(arrayList2);
                if (lastIndex2 >= 0) {
                    int i4 = 0;
                    while (true) {
                        Rect rect = (Rect) ((Pair) arrayList2.get(i4)).first;
                        i = 0;
                        float f3 = rect.top;
                        float f4 = rect.bottom;
                        boolean z2 = f3 >= f4;
                        if (!z && !z2 && Math.max(f, f3) < Math.min(f2, f4)) {
                            arrayList2.set(i4, new Pair(new Rect(Math.max(rect.left, 0.0f), Math.max(rect.top, f), Math.min(rect.right, Float.POSITIVE_INFINITY), Math.min(f4, f2)), ((Pair) arrayList2.get(i4)).second));
                            ((List) ((Pair) arrayList2.get(i4)).second).add(semanticsNode2);
                            break;
                        }
                        if (i4 != lastIndex2) {
                            i4++;
                        }
                    }
                } else {
                    i = 0;
                }
                Rect boundsInWindow2 = semanticsNode2.getBoundsInWindow();
                SemanticsNode[] semanticsNodeArr2 = new SemanticsNode[1];
                semanticsNodeArr2[i] = semanticsNode2;
                arrayList2.add(new Pair(boundsInWindow2, AppCompatHintHelper.mutableListOf(semanticsNodeArr2)));
                break;
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        } else {
            i = 0;
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, LtrBoundsComparator.INSTANCE$2);
        ArrayList arrayList3 = new ArrayList();
        Comparator comparator = semanticComparators[c ^ 1];
        int size2 = arrayList2.size();
        for (int i5 = i; i5 < size2; i5++) {
            Pair pair = (Pair) arrayList2.get(i5);
            CollectionsKt__MutableCollectionsJVMKt.sortWith((List) pair.second, comparator);
            arrayList3.addAll((Collection) pair.second);
        }
        int i6 = i;
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList3, new SemanticsSortKt$$ExternalSyntheticLambda0(i6, UnmergedConfigComparator));
        int size3 = i6;
        while (size3 <= AppCompatHintHelper.getLastIndex(arrayList3)) {
            List list2 = (List) mutableIntObjectMap2.get(((SemanticsNode) arrayList3.get(size3)).id);
            if (list2 != null) {
                if (((Boolean) anonymousClass2.invoke(arrayList3.get(size3))).booleanValue()) {
                    size3++;
                } else {
                    arrayList3.remove(size3);
                }
                arrayList3.addAll(size3, list2);
                size3 += list2.size();
            } else {
                size3++;
            }
        }
        return arrayList3;
    }
}
