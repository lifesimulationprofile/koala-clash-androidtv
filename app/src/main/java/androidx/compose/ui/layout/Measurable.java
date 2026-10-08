package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface Measurable {
    Object getParentData();

    int maxIntrinsicHeight(int i);

    int maxIntrinsicWidth(int i);

    /* JADX INFO: renamed from: measure-BRTryo0 */
    Placeable mo517measureBRTryo0(long j);

    int minIntrinsicHeight(int i);

    int minIntrinsicWidth(int i);
}
