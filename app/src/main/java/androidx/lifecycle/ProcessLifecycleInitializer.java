package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Initializer {
    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        if (!AppInitializer.getInstance(context).mDiscovered.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!LifecycleDispatcher.initialized.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new LifecycleDispatcher.DispatcherActivityCallback());
        }
        final ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.newInstance;
        processLifecycleOwner.getClass();
        processLifecycleOwner.handler = new Handler();
        processLifecycleOwner.registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1
            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    int i = ReportFragment.$r8$clinit;
                    ((ReportFragment) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag")).processListener = processLifecycleOwner.initializationListener;
                }
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner processLifecycleOwner2 = processLifecycleOwner;
                int i = processLifecycleOwner2.resumedCounter - 1;
                processLifecycleOwner2.resumedCounter = i;
                if (i == 0) {
                    processLifecycleOwner2.handler.postDelayed(processLifecycleOwner2.delayedPauseRunnable, 700L);
                }
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [androidx.lifecycle.ProcessLifecycleOwner$attach$1$onActivityPreCreated$1] */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPreCreated(Activity activity, Bundle bundle) {
                final ProcessLifecycleOwner processLifecycleOwner2 = processLifecycleOwner;
                ProcessLifecycleOwner.Api29Impl.registerActivityLifecycleCallbacks(activity, new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1$onActivityPreCreated$1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostResumed(Activity activity2) {
                        processLifecycleOwner2.activityResumed$lifecycle_process_release();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostStarted(Activity activity2) {
                        ProcessLifecycleOwner processLifecycleOwner3 = processLifecycleOwner2;
                        int i = processLifecycleOwner3.startedCounter + 1;
                        processLifecycleOwner3.startedCounter = i;
                        if (i == 1 && processLifecycleOwner3.stopSent) {
                            processLifecycleOwner3.registry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                            processLifecycleOwner3.stopSent = false;
                        }
                    }
                });
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner processLifecycleOwner2 = processLifecycleOwner;
                int i = processLifecycleOwner2.startedCounter - 1;
                processLifecycleOwner2.startedCounter = i;
                if (i == 0 && processLifecycleOwner2.pauseSent) {
                    processLifecycleOwner2.registry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                    processLifecycleOwner2.stopSent = true;
                }
            }
        });
        return processLifecycleOwner;
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return EmptyList.INSTANCE;
    }
}
