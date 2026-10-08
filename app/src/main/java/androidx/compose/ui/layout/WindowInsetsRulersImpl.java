package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsRulersImpl implements WindowInsetsRulers {
    public final RectRulersImpl current;
    public final RectRulersImpl maximum;
    public final String name;

    public WindowInsetsRulersImpl(String str) {
        this.name = str;
        this.current = new RectRulersImpl(str);
        this.maximum = new RectRulersImpl(str.concat(" maximum"));
    }

    public final String toString() {
        return this.name;
    }
}
