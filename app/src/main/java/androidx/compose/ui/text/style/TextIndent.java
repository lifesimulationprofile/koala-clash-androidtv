package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextIndent {
    public static final TextIndent None = new TextIndent(TextUnitKt.getSp(0), TextUnitKt.getSp(0));
    public final long firstLine;
    public final long restLine;

    public TextIndent(long j, long j2) {
        this.firstLine = j;
        this.restLine = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        return TextUnit.m725equalsimpl0(this.firstLine, textIndent.firstLine) && TextUnit.m725equalsimpl0(this.restLine, textIndent.restLine);
    }

    public final int hashCode() {
        return TextUnit.m728hashCodeimpl(this.restLine) + (TextUnit.m728hashCodeimpl(this.firstLine) * 31);
    }

    public final String toString() {
        return "TextIndent(firstLine=" + ((Object) TextUnit.m729toStringimpl(this.firstLine)) + ", restLine=" + ((Object) TextUnit.m729toStringimpl(this.restLine)) + ')';
    }
}
