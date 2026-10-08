package androidx.compose.ui.text;

import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnnotatedString implements CharSequence {
    public final List annotations;
    public final ArrayList paragraphStylesOrNull;
    public final ArrayList spanStylesOrNull;
    public final String text;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Annotation {
    }

    static {
        RequestService requestService = SaversKt.AnnotationRangeListSaver;
    }

    public AnnotatedString(List list, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.annotations = list;
        this.text = str;
        if (list != null) {
            int size = list.size();
            arrayList = null;
            arrayList2 = null;
            for (int i = 0; i < size; i++) {
                Range range = (Range) list.get(i);
                Object obj = range.item;
                if (obj instanceof SpanStyle) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(range);
                } else if (obj instanceof ParagraphStyle) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(range);
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        this.spanStylesOrNull = arrayList;
        this.paragraphStylesOrNull = arrayList2;
        List listSortedWith = arrayList2 != null ? CollectionsKt.sortedWith(arrayList2, new AnnotatedString$special$$inlined$sortedBy$1(0)) : null;
        if (listSortedWith == null || listSortedWith.isEmpty()) {
            return;
        }
        int i2 = ((Range) CollectionsKt.first(listSortedWith)).end;
        MutableIntList mutableIntList = IntListKt.EmptyIntList;
        MutableIntList mutableIntList2 = new MutableIntList(1);
        mutableIntList2.add(i2);
        int size2 = listSortedWith.size();
        for (int i3 = 1; i3 < size2; i3++) {
            Range range2 = (Range) listSortedWith.get(i3);
            while (mutableIntList2._size != 0) {
                int iLast = mutableIntList2.last();
                int i4 = range2.start;
                int i5 = range2.end;
                if (i4 < iLast) {
                    if (i5 > iLast) {
                        InlineClassHelperKt.throwIllegalArgumentException("Paragraph overlap not allowed, end " + i5 + " should be less than or equal to " + iLast);
                        break;
                    }
                    break;
                }
                mutableIntList2.removeAt(mutableIntList2._size - 1);
            }
            mutableIntList2.add(range2.end);
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.text.charAt(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        return Intrinsics.areEqual(this.text, annotatedString.text) && Intrinsics.areEqual(this.annotations, annotatedString.annotations);
    }

    public final int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        List list = this.annotations;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.text.length();
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.text;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0099  */
    @Override // java.lang.CharSequence
    public final AnnotatedString subSequence(int i, int i2) {
        ArrayList arrayList;
        if (!(i <= i2)) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + i + ") should be less or equal to end (" + i2 + ')');
        }
        String str = this.text;
        if (i == 0 && i2 == str.length()) {
            return this;
        }
        String strSubstring = str.substring(i, i2);
        AnnotatedString annotatedString = AnnotatedStringKt.EmptyAnnotatedString;
        if (i > i2) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + i + ") should be less than or equal to end (" + i2 + ')');
        }
        List list = this.annotations;
        if (list == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Range range = (Range) list.get(i3);
                int i4 = range.start;
                int i5 = range.end;
                if (AnnotatedStringKt.intersect(i, i2, i4, i5)) {
                    arrayList.add(new Range(range.item, Math.max(i, range.start) - i, Math.min(i2, i5) - i, range.tag));
                }
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
        }
        return new AnnotatedString(arrayList, strSubstring);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder implements Appendable {
        public final ArrayList annotations;
        public final StringBuilder text;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class MutableRange {
            public final int end;
            public final Object item;
            public final int start;
            public final String tag;

            public MutableRange(Object obj, int i, int i2, String str) {
                this.item = obj;
                this.start = i;
                this.end = i2;
                this.tag = str;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) obj;
                return Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag);
            }

            public final int hashCode() {
                Object obj = this.item;
                return this.tag.hashCode() + ((((((obj == null ? 0 : obj.hashCode()) * 31) + this.start) * 31) + this.end) * 31);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("MutableRange(item=");
                sb.append(this.item);
                sb.append(", start=");
                sb.append(this.start);
                sb.append(", end=");
                sb.append(this.end);
                sb.append(", tag=");
                return Modifier.CC.m(sb, this.tag, ')');
            }
        }

        public Builder() {
            this.text = new StringBuilder(16);
            new ArrayList();
            this.annotations = new ArrayList();
            new ArrayList();
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            if (charSequence instanceof AnnotatedString) {
                append((AnnotatedString) charSequence);
                return this;
            }
            this.text.append(charSequence);
            return this;
        }

        public final AnnotatedString toAnnotatedString() {
            StringBuilder sb = this.text;
            String string = sb.toString();
            ArrayList arrayList = this.annotations;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                MutableRange mutableRange = (MutableRange) arrayList.get(i);
                int length = sb.length();
                int i2 = mutableRange.end;
                if (i2 != Integer.MIN_VALUE) {
                    length = i2;
                }
                if (length == Integer.MIN_VALUE) {
                    InlineClassHelperKt.throwIllegalStateException("Item.end should be set first");
                }
                arrayList2.add(new Range(mutableRange.item, mutableRange.start, length, mutableRange.tag));
            }
            return new AnnotatedString(string, arrayList2);
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i, int i2) {
            if (charSequence instanceof AnnotatedString) {
                append((AnnotatedString) charSequence, i, i2);
                return this;
            }
            this.text.append(charSequence, i, i2);
            return this;
        }

        public Builder(AnnotatedString annotatedString) {
            this();
            append(annotatedString);
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c) {
            this.text.append(c);
            return this;
        }

        public final void append(AnnotatedString annotatedString) {
            StringBuilder sb = this.text;
            int length = sb.length();
            sb.append(annotatedString.text);
            List list = annotatedString.annotations;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Range range = (Range) list.get(i);
                    this.annotations.add(new MutableRange(range.item, range.start + length, range.end + length, range.tag));
                }
            }
        }

        public final void append(AnnotatedString annotatedString, int i, int i2) {
            StringBuilder sb = this.text;
            int length = sb.length();
            sb.append((CharSequence) annotatedString.text, i, i2);
            List localAnnotations = AnnotatedStringKt.getLocalAnnotations(annotatedString, i, i2, null);
            if (localAnnotations != null) {
                int size = localAnnotations.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Range range = (Range) localAnnotations.get(i3);
                    this.annotations.add(new MutableRange(range.item, range.start + length, range.end + length, range.tag));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Range {
        public final int end;
        public final Object item;
        public final int start;
        public final String tag;

        public Range(Object obj, int i, int i2, String str) {
            this.item = obj;
            this.start = i;
            this.end = i2;
            this.tag = str;
            if (i <= i2) {
                return;
            }
            InlineClassHelperKt.throwIllegalArgumentException("Reversed range is not supported");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            return Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag);
        }

        public final int hashCode() {
            Object obj = this.item;
            return this.tag.hashCode() + ((((((obj == null ? 0 : obj.hashCode()) * 31) + this.start) * 31) + this.end) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Range(item=");
            sb.append(this.item);
            sb.append(", start=");
            sb.append(this.start);
            sb.append(", end=");
            sb.append(this.end);
            sb.append(", tag=");
            return Modifier.CC.m(sb, this.tag, ')');
        }

        public Range(int i, int i2, Object obj) {
            this(obj, i, i2, "");
        }
    }

    public /* synthetic */ AnnotatedString(String str) {
        this(str, EmptyList.INSTANCE);
    }

    public AnnotatedString(String str, List list) {
        this(list.isEmpty() ? null : list, str);
    }
}
