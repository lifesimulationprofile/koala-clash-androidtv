package androidx.core.text;

import kotlinx.serialization.json.internal.Composer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextDirectionHeuristicsCompat {
    public static final Composer FIRSTSTRONG_LTR;
    public static final Composer FIRSTSTRONG_RTL;
    public static final Composer LTR = new Composer((FirstStrong) null, false);
    public static final Composer RTL = new Composer((FirstStrong) null, true);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FirstStrong {
        public static final FirstStrong INSTANCE = new FirstStrong();
    }

    static {
        FirstStrong firstStrong = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new Composer(firstStrong, false);
        FIRSTSTRONG_RTL = new Composer(firstStrong, true);
    }
}
