package androidx.compose.ui.platform;

import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.compose.ui.text.TextLayoutResult;
import java.text.BreakIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityIterators$WordTextSegmentIterator extends BaseMenuWrapper {
    public static AccessibilityIterators$WordTextSegmentIterator instance;
    public static AccessibilityIterators$WordTextSegmentIterator instance$1;
    public static AccessibilityIterators$WordTextSegmentIterator lineInstance;
    public final /* synthetic */ int $r8$classId;
    public Object impl;

    public /* synthetic */ AccessibilityIterators$WordTextSegmentIterator(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final int[] following(int i) {
        int lineForOffset;
        switch (this.$r8$classId) {
            case 0:
                if (getText().length() <= 0 || i >= getText().length()) {
                    return null;
                }
                if (i < 0) {
                    i = 0;
                }
                while (!isLetterOrDigit(i) && (!isLetterOrDigit(i) || (i != 0 && isLetterOrDigit(i - 1)))) {
                    BreakIterator breakIterator = (BreakIterator) this.impl;
                    if (breakIterator == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    i = breakIterator.following(i);
                    if (i == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator2 = (BreakIterator) this.impl;
                if (breakIterator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
                int iFollowing = breakIterator2.following(i);
                if (iFollowing == -1 || !isEndBoundary$1(iFollowing)) {
                    return null;
                }
                return getRange(i, iFollowing);
            case 1:
                int length = getText().length();
                if (length <= 0 || i >= length) {
                    return null;
                }
                if (i < 0) {
                    i = 0;
                }
                do {
                    BreakIterator breakIterator3 = (BreakIterator) this.impl;
                    if (breakIterator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    if (breakIterator3.isBoundary(i)) {
                        BreakIterator breakIterator4 = (BreakIterator) this.impl;
                        if (breakIterator4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("impl");
                            throw null;
                        }
                        int iFollowing2 = breakIterator4.following(i);
                        if (iFollowing2 == -1) {
                            return null;
                        }
                        return getRange(i, iFollowing2);
                    }
                    BreakIterator breakIterator5 = (BreakIterator) this.impl;
                    if (breakIterator5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    i = breakIterator5.following(i);
                } while (i != -1);
                return null;
            default:
                if (getText().length() <= 0 || i >= getText().length()) {
                    return null;
                }
                if (i < 0) {
                    TextLayoutResult textLayoutResult = (TextLayoutResult) this.impl;
                    if (textLayoutResult == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    lineForOffset = textLayoutResult.multiParagraph.getLineForOffset(0);
                } else {
                    TextLayoutResult textLayoutResult2 = (TextLayoutResult) this.impl;
                    if (textLayoutResult2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    int lineForOffset2 = textLayoutResult2.multiParagraph.getLineForOffset(i);
                    lineForOffset = getLineEdgeIndex(lineForOffset2, 2) == i ? lineForOffset2 : lineForOffset2 + 1;
                }
                TextLayoutResult textLayoutResult3 = (TextLayoutResult) this.impl;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                if (lineForOffset >= textLayoutResult3.multiParagraph.lineCount) {
                    return null;
                }
                return getRange(getLineEdgeIndex(lineForOffset, 2), getLineEdgeIndex(lineForOffset, 1) + 1);
        }
    }

    public int getLineEdgeIndex(int i, int i2) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.impl;
        if (textLayoutResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        int lineStart = textLayoutResult.getLineStart(i);
        TextLayoutResult textLayoutResult2 = (TextLayoutResult) this.impl;
        if (textLayoutResult2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        if (i2 != textLayoutResult2.getParagraphDirection(lineStart)) {
            TextLayoutResult textLayoutResult3 = (TextLayoutResult) this.impl;
            if (textLayoutResult3 != null) {
                return textLayoutResult3.getLineStart(i);
            }
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        TextLayoutResult textLayoutResult4 = (TextLayoutResult) this.impl;
        if (textLayoutResult4 != null) {
            return textLayoutResult4.multiParagraph.getLineEnd(i, false) - 1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        throw null;
    }

    public void initialize(String str) {
        switch (this.$r8$classId) {
            case 0:
                this.mContext = str;
                BreakIterator breakIterator = (BreakIterator) this.impl;
                if (breakIterator != null) {
                    breakIterator.setText(str);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
            default:
                this.mContext = str;
                BreakIterator breakIterator2 = (BreakIterator) this.impl;
                if (breakIterator2 != null) {
                    breakIterator2.setText(str);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
        }
    }

    public boolean isEndBoundary$1(int i) {
        if (i <= 0 || !isLetterOrDigit(i - 1)) {
            return false;
        }
        return i == getText().length() || !isLetterOrDigit(i);
    }

    public boolean isLetterOrDigit(int i) {
        if (i < 0 || i >= getText().length()) {
            return false;
        }
        return Character.isLetterOrDigit(getText().codePointAt(i));
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final int[] preceding(int i) {
        int lineForOffset;
        switch (this.$r8$classId) {
            case 0:
                int length = getText().length();
                if (length <= 0 || i <= 0) {
                    return null;
                }
                if (i > length) {
                    i = length;
                }
                while (i > 0 && !isLetterOrDigit(i - 1) && !isEndBoundary$1(i)) {
                    BreakIterator breakIterator = (BreakIterator) this.impl;
                    if (breakIterator == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    i = breakIterator.preceding(i);
                    if (i == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator2 = (BreakIterator) this.impl;
                if (breakIterator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
                int iPreceding = breakIterator2.preceding(i);
                if (iPreceding == -1 || !isLetterOrDigit(iPreceding)) {
                    return null;
                }
                if (iPreceding == 0 || !isLetterOrDigit(iPreceding - 1)) {
                    return getRange(iPreceding, i);
                }
                return null;
            case 1:
                int length2 = getText().length();
                if (length2 <= 0 || i <= 0) {
                    return null;
                }
                if (i > length2) {
                    i = length2;
                }
                do {
                    BreakIterator breakIterator3 = (BreakIterator) this.impl;
                    if (breakIterator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    if (breakIterator3.isBoundary(i)) {
                        BreakIterator breakIterator4 = (BreakIterator) this.impl;
                        if (breakIterator4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("impl");
                            throw null;
                        }
                        int iPreceding2 = breakIterator4.preceding(i);
                        if (iPreceding2 == -1) {
                            return null;
                        }
                        return getRange(iPreceding2, i);
                    }
                    BreakIterator breakIterator5 = (BreakIterator) this.impl;
                    if (breakIterator5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    i = breakIterator5.preceding(i);
                } while (i != -1);
                return null;
            default:
                if (getText().length() <= 0 || i <= 0) {
                    return null;
                }
                if (i > getText().length()) {
                    TextLayoutResult textLayoutResult = (TextLayoutResult) this.impl;
                    if (textLayoutResult == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    lineForOffset = textLayoutResult.multiParagraph.getLineForOffset(getText().length());
                } else {
                    TextLayoutResult textLayoutResult2 = (TextLayoutResult) this.impl;
                    if (textLayoutResult2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    int lineForOffset2 = textLayoutResult2.multiParagraph.getLineForOffset(i);
                    lineForOffset = getLineEdgeIndex(lineForOffset2, 1) + 1 == i ? lineForOffset2 : lineForOffset2 - 1;
                }
                if (lineForOffset < 0) {
                    return null;
                }
                return getRange(getLineEdgeIndex(lineForOffset, 2), getLineEdgeIndex(lineForOffset, 1) + 1);
        }
    }
}
