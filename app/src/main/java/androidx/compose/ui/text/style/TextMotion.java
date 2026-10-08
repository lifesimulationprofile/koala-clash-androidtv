package androidx.compose.ui.text.style;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextMotion {
    public final int linearity;
    public final boolean subpixelTextPositioning;
    public static final TextMotion Static = new TextMotion(2, false);
    public static final TextMotion Animated = new TextMotion(1, true);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Linearity {
        public final int value;

        public final boolean equals(Object obj) {
            if (obj instanceof Linearity) {
                return this.value == ((Linearity) obj).value;
            }
            return false;
        }

        public final int hashCode() {
            return this.value;
        }

        public final String toString() {
            int i = this.value;
            if (i == 1) {
                return "Linearity.Linear";
            }
            if (i == 2) {
                return "Linearity.FontHinting";
            }
            return i == 3 ? "Linearity.None" : "Invalid";
        }
    }

    public TextMotion(int i, boolean z) {
        this.linearity = i;
        this.subpixelTextPositioning = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMotion)) {
            return false;
        }
        TextMotion textMotion = (TextMotion) obj;
        return this.linearity == textMotion.linearity && this.subpixelTextPositioning == textMotion.subpixelTextPositioning;
    }

    public final int hashCode() {
        return (this.linearity * 31) + (this.subpixelTextPositioning ? 1231 : 1237);
    }

    public final String toString() {
        if (equals(Static)) {
            return "TextMotion.Static";
        }
        return equals(Animated) ? "TextMotion.Animated" : "Invalid";
    }
}
