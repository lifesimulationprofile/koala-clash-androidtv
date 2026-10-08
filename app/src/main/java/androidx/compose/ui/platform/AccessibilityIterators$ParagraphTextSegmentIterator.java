package androidx.compose.ui.platform;

import androidx.appcompat.view.menu.BaseMenuWrapper;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityIterators$ParagraphTextSegmentIterator extends BaseMenuWrapper {
    public static AccessibilityIterators$ParagraphTextSegmentIterator instance;

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final int[] following(int i) {
        int length = getText().length();
        if (length <= 0 || i >= length) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < length && getText().charAt(i) == '\n' && (getText().charAt(i) == '\n' || (i != 0 && getText().charAt(i - 1) != '\n'))) {
            i++;
        }
        if (i >= length) {
            return null;
        }
        int i2 = i + 1;
        while (i2 < length && !isEndBoundary(i2)) {
            i2++;
        }
        return getRange(i, i2);
    }

    public final boolean isEndBoundary(int i) {
        if (i <= 0 || getText().charAt(i - 1) == '\n') {
            return false;
        }
        return i == getText().length() || getText().charAt(i) == '\n';
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final int[] preceding(int i) {
        int length = getText().length();
        if (length <= 0 || i <= 0) {
            return null;
        }
        if (i > length) {
            i = length;
        }
        while (i > 0 && getText().charAt(i - 1) == '\n' && !isEndBoundary(i)) {
            i--;
        }
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        while (i2 > 0 && (getText().charAt(i2) == '\n' || (i2 != 0 && getText().charAt(i2 - 1) != '\n'))) {
            i2--;
        }
        return getRange(i2, i);
    }
}
