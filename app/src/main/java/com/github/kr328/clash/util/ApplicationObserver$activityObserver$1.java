package com.github.kr328.clash.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationObserver$activityObserver$1 implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        ApplicationObserver._createdActivities.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityDestroyed(Activity activity) {
        ApplicationObserver._createdActivities.remove(activity);
        LinkedHashSet linkedHashSet = ApplicationObserver._visibleActivities;
        linkedHashSet.remove(activity);
        ApplicationObserver.access$setAppVisible(!linkedHashSet.isEmpty());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        ApplicationObserver._visibleActivities.add(activity);
        ApplicationObserver.access$setAppVisible(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        LinkedHashSet linkedHashSet = ApplicationObserver._visibleActivities;
        linkedHashSet.remove(activity);
        ApplicationObserver.access$setAppVisible(!linkedHashSet.isEmpty());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
