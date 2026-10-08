package androidx.activity;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporter {
    public final Object lock = new Object();
    public final ArrayList onReportCallbacks = new ArrayList();
    public boolean reportedFullyDrawn;

    public FullyDrawnReporter(ComponentActivity$$ExternalSyntheticLambda2 componentActivity$$ExternalSyntheticLambda2) {
    }
}
