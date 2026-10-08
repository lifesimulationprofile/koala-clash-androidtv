package androidx.compose.ui.text.font;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GenericFontFamily extends SystemFontFamily {
    public final String fontFamilyName;
    public final String name;

    public GenericFontFamily(String str, String str2) {
        this.name = str;
        this.fontFamilyName = str2;
    }

    public final String toString() {
        return this.fontFamilyName;
    }
}
