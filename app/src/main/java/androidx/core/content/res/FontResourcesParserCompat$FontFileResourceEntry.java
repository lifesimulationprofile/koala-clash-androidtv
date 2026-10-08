package androidx.core.content.res;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FontResourcesParserCompat$FontFileResourceEntry {
    public final String mFileName;
    public final boolean mItalic;
    public final int mResourceId;
    public final int mTtcIndex;
    public final String mVariationSettings;
    public final int mWeight;

    public FontResourcesParserCompat$FontFileResourceEntry(String str, int i, boolean z, String str2, int i2, int i3) {
        this.mFileName = str;
        this.mWeight = i;
        this.mItalic = z;
        this.mVariationSettings = str2;
        this.mTtcIndex = i2;
        this.mResourceId = i3;
    }
}
