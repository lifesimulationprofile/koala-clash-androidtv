package androidx.compose.ui.layout;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface MeasurePolicy {
    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i);

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i);
}
