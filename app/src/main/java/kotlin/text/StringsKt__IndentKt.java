package kotlin.text;

import androidx.appcompat.widget.AppCompatHintHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public static String trimIndent(String str) {
        Comparable comparable;
        List listLines = StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            String str2 = (String) obj2;
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!CharsKt.isWhitespace(str2.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            comparable = (Comparable) it.next();
            while (it.hasNext()) {
                Comparable comparable2 = (Comparable) it.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listLines.size();
        int lastIndex = AppCompatHintHelper.getLastIndex(listLines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listLines) {
            int i3 = i + 1;
            if (i < 0) {
                AppCompatHintHelper.throwIndexOverflow();
                throw null;
            }
            String str3 = (String) obj3;
            String strDrop = ((i == 0 || i == lastIndex) && StringsKt.isBlank(str3)) ? null : StringsKt.drop(str3, iIntValue);
            if (strDrop != null) {
                arrayList3.add(strDrop);
            }
            i = i3;
        }
        StringBuilder sb = new StringBuilder(length3);
        CollectionsKt.joinTo$default(arrayList3, sb, "\n", null, 124);
        return sb.toString();
    }

    public static String trimMargin$default(String str) {
        if (StringsKt.isBlank("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List listLines = StringsKt.lines(str);
        int length = str.length();
        listLines.size();
        int lastIndex = AppCompatHintHelper.getLastIndex(listLines);
        ArrayList arrayList = new ArrayList();
        Iterator it = listLines.iterator();
        int i = 0;
        while (true) {
            String strSubstring = null;
            if (!it.hasNext()) {
                StringBuilder sb = new StringBuilder(length);
                CollectionsKt.joinTo$default(arrayList, sb, "\n", null, 124);
                return sb.toString();
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                AppCompatHintHelper.throwIndexOverflow();
                throw null;
            }
            String str2 = (String) next;
            if ((i != 0 && i != lastIndex) || !StringsKt.isBlank(str2)) {
                int length2 = str2.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    if (!CharsKt.isWhitespace(str2.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
                if (i3 != -1 && str2.startsWith("|", i3)) {
                    strSubstring = str2.substring("|".length() + i3);
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i = i2;
        }
    }
}
