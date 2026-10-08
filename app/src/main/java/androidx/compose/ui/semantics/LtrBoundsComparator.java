package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import java.util.Comparator;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LtrBoundsComparator implements Comparator {
    public static final LtrBoundsComparator INSTANCE = new LtrBoundsComparator(0);
    public static final LtrBoundsComparator INSTANCE$1 = new LtrBoundsComparator(1);
    public static final LtrBoundsComparator INSTANCE$2 = new LtrBoundsComparator(2);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ LtrBoundsComparator(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Rect boundsInWindow = ((SemanticsNode) obj).getBoundsInWindow();
                Rect boundsInWindow2 = ((SemanticsNode) obj2).getBoundsInWindow();
                int iCompare = Float.compare(boundsInWindow.left, boundsInWindow2.left);
                if (iCompare != 0) {
                    return iCompare;
                }
                int iCompare2 = Float.compare(boundsInWindow.top, boundsInWindow2.top);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                int iCompare3 = Float.compare(boundsInWindow.bottom, boundsInWindow2.bottom);
                return iCompare3 != 0 ? iCompare3 : Float.compare(boundsInWindow.right, boundsInWindow2.right);
            case 1:
                Rect boundsInWindow3 = ((SemanticsNode) obj).getBoundsInWindow();
                Rect boundsInWindow4 = ((SemanticsNode) obj2).getBoundsInWindow();
                int iCompare4 = Float.compare(boundsInWindow4.right, boundsInWindow3.right);
                if (iCompare4 != 0) {
                    return iCompare4;
                }
                int iCompare5 = Float.compare(boundsInWindow3.top, boundsInWindow4.top);
                if (iCompare5 != 0) {
                    return iCompare5;
                }
                int iCompare6 = Float.compare(boundsInWindow3.bottom, boundsInWindow4.bottom);
                return iCompare6 != 0 ? iCompare6 : Float.compare(boundsInWindow4.left, boundsInWindow3.left);
            default:
                Pair pair = (Pair) obj;
                Pair pair2 = (Pair) obj2;
                int iCompare7 = Float.compare(((Rect) pair.first).top, ((Rect) pair2.first).top);
                return iCompare7 != 0 ? iCompare7 : Float.compare(((Rect) pair.first).bottom, ((Rect) pair2.first).bottom);
        }
    }
}
