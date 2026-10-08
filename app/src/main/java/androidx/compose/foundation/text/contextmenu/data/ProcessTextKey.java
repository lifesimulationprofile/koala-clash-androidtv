package androidx.compose.foundation.text.contextmenu.data;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessTextKey {
    public final int id;

    public ProcessTextKey(int i) {
        this.id = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ProcessTextKey) {
            return this.id == ((ProcessTextKey) obj).id;
        }
        return false;
    }

    public final int hashCode() {
        return this.id;
    }
}
