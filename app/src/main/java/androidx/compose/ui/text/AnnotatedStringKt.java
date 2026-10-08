package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotatedStringKt {
    public static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("");

    public static final List getLocalAnnotations(AnnotatedString annotatedString, int i, int i2, SaversKt$$ExternalSyntheticLambda10 saversKt$$ExternalSyntheticLambda10) {
        List list;
        if (i == i2 || (list = annotatedString.annotations) == null) {
            return null;
        }
        if (i != 0 || i2 < annotatedString.text.length()) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                AnnotatedString.Range range = (AnnotatedString.Range) list.get(i3);
                if ((saversKt$$ExternalSyntheticLambda10 != null ? ((Boolean) saversKt$$ExternalSyntheticLambda10.invoke(range.item)).booleanValue() : true) && intersect(i, i2, range.start, range.end)) {
                    arrayList.add(new AnnotatedString.Range((AnnotatedString.Annotation) range.item, RangesKt.coerceIn(range.start, i, i2) - i, RangesKt.coerceIn(range.end, i, i2) - i, range.tag));
                }
            }
            return arrayList;
        }
        if (saversKt$$ExternalSyntheticLambda10 == null) {
            return list;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Object obj = list.get(i4);
            if (((Boolean) saversKt$$ExternalSyntheticLambda10.invoke(((AnnotatedString.Range) obj).item)).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final boolean intersect(int i, int i2, int i3, int i4) {
        return ((i < i4) & (i3 < i2)) | (((i == i2) | (i3 == i4)) & (i == i3));
    }
}
