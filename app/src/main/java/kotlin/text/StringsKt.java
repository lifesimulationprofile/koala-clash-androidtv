package kotlin.text;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IndexingIterable;
import kotlin.io.FileTreeWalk;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
public abstract class StringsKt extends StringsKt__StringsJVMKt {
    public static boolean contains(CharSequence charSequence, String str, boolean z) {
        if (ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) str)) {
            if (indexOf$default(charSequence, str, 0, z, 2) >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt(charSequence, str, 0, charSequence.length(), z, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean contains$default(CharSequence charSequence, char c) {
        return indexOf$default(charSequence, c, 0, 2) >= 0;
    }

    public static String drop(String str, int i) {
        if (i < 0) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(i);
    }

    public static boolean endsWith$default(CharSequence charSequence, String str) {
        return charSequence instanceof String ? ((String) charSequence).endsWith(str) : regionMatchesImpl(charSequence, charSequence.length() - str.length(), str, 0, str.length(), false);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        return (z || !(charSequence instanceof String)) ? indexOf$StringsKt__StringsKt(charSequence, str, i, charSequence.length(), z, false) : ((String) charSequence).indexOf(str, i);
    }

    public static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        CharSequence charSequence3 = charSequence2;
        int i3 = i;
        int i4 = i2;
        if (z2) {
            int lastIndex = getLastIndex(charSequence);
            if (i3 > lastIndex) {
                i3 = lastIndex;
            }
            if (i4 < 0) {
                i4 = 0;
            }
            intProgression = new IntProgression(i3, i4, -1);
        } else {
            if (i3 < 0) {
                i3 = 0;
            }
            int length = charSequence.length();
            if (i4 > length) {
                i4 = length;
            }
            intProgression = new IntRange(i3, i4, 1);
        }
        boolean z3 = charSequence instanceof String;
        int i5 = intProgression.step;
        int i6 = intProgression.last;
        int i7 = intProgression.first;
        if (z3 && (charSequence3 instanceof String)) {
            if ((i5 > 0 && i7 <= i6) || (i5 < 0 && i6 <= i7)) {
                int i8 = i7;
                while (true) {
                    String str = (String) charSequence3;
                    String str2 = (String) charSequence;
                    int length2 = str.length();
                    if (!(!z ? str.regionMatches(0, str2, i8, length2) : str.regionMatches(z, 0, str2, i8, length2))) {
                        if (i8 == i6) {
                            break;
                        }
                        i8 += i5;
                    } else {
                        return i8;
                    }
                }
            }
        } else if ((i5 > 0 && i7 <= i6) || (i5 < 0 && i6 <= i7)) {
            int i9 = i7;
            while (!regionMatchesImpl(charSequence3, 0, charSequence, i9, charSequence3.length(), z)) {
                if (i9 != i6) {
                    i9 += i5;
                    charSequence3 = charSequence2;
                }
            }
            return i9;
        }
        return -1;
    }

    public static int indexOf$default(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return !(charSequence instanceof String) ? indexOfAny(charSequence, new char[]{c}, i, false) : ((String) charSequence).indexOf(c, i);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        if (i < 0) {
            i = 0;
        }
        int lastIndex = getLastIndex(charSequence);
        if (i > lastIndex) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (CharsKt.equals(c, cCharAt, z)) {
                    return i;
                }
            }
            if (i == lastIndex) {
                return -1;
            }
            i++;
        }
    }

    public static boolean isBlank(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (!CharsKt.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static char last(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            return charSequence.charAt(getLastIndex(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static int lastIndexOf$default(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        char[] cArr = {c};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(cArr[0], i);
        }
        int lastIndex = getLastIndex(charSequence);
        if (i > lastIndex) {
            i = lastIndex;
        }
        while (-1 < i) {
            if (CharsKt.equals(cArr[0], charSequence.charAt(i), false)) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static List lines(CharSequence charSequence) {
        LinesIterator linesIterator = new LinesIterator(charSequence);
        if (!linesIterator.hasNext()) {
            return EmptyList.INSTANCE;
        }
        Object next = linesIterator.next();
        if (!linesIterator.hasNext()) {
            return Collections.singletonList(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (linesIterator.hasNext()) {
            arrayList.add(linesIterator.next());
        }
        return arrayList;
    }

    public static String padStart(String str, int i) {
        CharSequence charSequenceSubSequence;
        if (i < 0) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Desired length ", " is less than zero."));
        }
        if (i <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - str.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String removePrefix(String str, String str2) {
        return StringsKt__StringsJVMKt.startsWith(str, str2, false) ? str.substring(str2.length()) : str;
    }

    public static StringBuilder replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Limit must be non-negative, but was ", i).toString());
        }
    }

    public static final List split$StringsKt__StringsKt(int i, CharSequence charSequence, String str) {
        requireNonNegativeLimit(i);
        int iIndexOf = indexOf(charSequence, str, 0, false);
        if (iIndexOf == -1 || i == 1) {
            return Collections.singletonList(charSequence.toString());
        }
        boolean z = i > 0;
        int i2 = 10;
        if (z && i <= 10) {
            i2 = i;
        }
        ArrayList arrayList = new ArrayList(i2);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z && arrayList.size() == i - 1) {
                break;
            }
            iIndexOf = indexOf(charSequence, str, length, false);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List split$default(CharSequence charSequence, String[] strArr, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return split$StringsKt__StringsKt(i, charSequence, str);
            }
        }
        requireNonNegativeLimit(i);
        IndexingIterable indexingIterable = new IndexingIterable(1, new FileTreeWalk(i, 1, charSequence, new StringsKt__StringsKt$$ExternalSyntheticLambda0(0, Arrays.asList(strArr))));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(indexingIterable, 10));
        Iterator it = indexingIterable.iterator();
        while (true) {
            DelimitedRangesSequence$iterator$1 delimitedRangesSequence$iterator$1 = (DelimitedRangesSequence$iterator$1) it;
            if (!delimitedRangesSequence$iterator$1.hasNext()) {
                return arrayList;
            }
            IntRange intRange = (IntRange) delimitedRangesSequence$iterator$1.next();
            arrayList.add(charSequence.subSequence(intRange.first, intRange.last + 1).toString());
        }
    }

    public static String substringAfter$default(String str, String str2) {
        int iIndexOf$default = indexOf$default(str, str2, 0, false, 6);
        return iIndexOf$default == -1 ? str : str.substring(str2.length() + iIndexOf$default, str.length());
    }

    public static String substringAfterLast(String str, char c, String str2) {
        int iLastIndexOf$default = lastIndexOf$default(str, c, 0, 6);
        return iLastIndexOf$default == -1 ? str2 : str.substring(iLastIndexOf$default + 1, str.length());
    }

    public static String substringBefore$default(String str, char c) {
        int iIndexOf$default = indexOf$default(str, c, 0, 6);
        return iIndexOf$default == -1 ? str : str.substring(0, iIndexOf$default);
    }

    public static String take(String str, int i) {
        if (i < 0) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(0, i);
    }

    public static CharSequence trim(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zIsWhitespace = CharsKt.isWhitespace(str.charAt(!z ? i : length));
            if (z) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static int lastIndexOf$default(int i, String str, String str2) {
        int lastIndex = (i & 2) != 0 ? getLastIndex(str) : 0;
        if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) str)) {
            return indexOf$StringsKt__StringsKt(str, str2, lastIndex, 0, false, true);
        }
        return str.lastIndexOf(str2, lastIndex);
    }

    public static List split$default(String str, char[] cArr) {
        int i = 0;
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(0, str, String.valueOf(cArr[0]));
        }
        requireNonNegativeLimit(0);
        IndexingIterable indexingIterable = new IndexingIterable(1, new FileTreeWalk(i, 1, str, new StringsKt__StringsKt$$ExternalSyntheticLambda0(3, cArr)));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(indexingIterable, 10));
        Iterator it = indexingIterable.iterator();
        while (true) {
            DelimitedRangesSequence$iterator$1 delimitedRangesSequence$iterator$1 = (DelimitedRangesSequence$iterator$1) it;
            if (!delimitedRangesSequence$iterator$1.hasNext()) {
                return arrayList;
            }
            IntRange intRange = (IntRange) delimitedRangesSequence$iterator$1.next();
            arrayList.add(str.subSequence(intRange.first, intRange.last + 1).toString());
        }
    }
}
