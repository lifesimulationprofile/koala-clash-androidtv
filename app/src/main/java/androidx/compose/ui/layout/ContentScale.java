package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface ContentScale {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public static final ContentScale$Companion$Fit$1 Crop = new ContentScale$Companion$Fit$1(2);
        public static final ContentScale$Companion$Fit$1 Fit = new ContentScale$Companion$Fit$1(0);
        public static final ContentScale$Companion$Fit$1 Inside = new ContentScale$Companion$Fit$1(3);
        public static final FixedScale None = new FixedScale();
    }

    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo516computeScaleFactorH7hwNQA(long j, long j2);
}
