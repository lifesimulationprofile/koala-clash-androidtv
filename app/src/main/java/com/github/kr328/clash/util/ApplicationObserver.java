package com.github.kr328.clash.util;

import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationObserver {
    public static boolean appVisible;
    public static final LinkedHashSet _createdActivities = new LinkedHashSet();
    public static final LinkedHashSet _visibleActivities = new LinkedHashSet();
    public static Function1 visibleChanged = new Remote$$ExternalSyntheticLambda1(16);
    public static final ApplicationObserver$activityObserver$1 activityObserver = new ApplicationObserver$activityObserver$1();

    public static final void access$setAppVisible(boolean z) {
        if (appVisible != z) {
            appVisible = z;
            visibleChanged.invoke(Boolean.valueOf(z));
        }
    }
}
