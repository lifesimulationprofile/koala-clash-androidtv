package androidx.compose.ui.input.nestedscroll;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollConnection {
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    Object mo99onPostFlingRZ2iAVY(long j, long j2, Continuation continuation);

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    long mo100onPostScrollDzOQY0M(long j, long j2, int i);

    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    Object mo101onPreFlingQWom1Mo(long j, Continuation continuation);

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    long mo102onPreScrollOzD1aCk(int i, long j);
}
