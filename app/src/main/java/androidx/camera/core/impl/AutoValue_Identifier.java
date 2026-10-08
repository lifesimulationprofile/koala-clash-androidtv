package androidx.camera.core.impl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_Identifier {
    public final Object value;

    public AutoValue_Identifier(Object obj) {
        this.value = obj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_Identifier) {
            return this.value.equals(((AutoValue_Identifier) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "Identifier{value=" + this.value + "}";
    }
}
