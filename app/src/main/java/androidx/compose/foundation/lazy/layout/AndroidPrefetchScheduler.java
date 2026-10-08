package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.appcompat.app.TwilightManager$TwilightState;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPrefetchScheduler implements PrefetchScheduler, View.OnAttachStateChangeListener, Runnable, Choreographer.FrameCallback {
    public static long frameIntervalNs;
    public long frameStartTimeNanos;
    public boolean isActive;
    public boolean prefetchScheduled;
    public final View view;
    public final PriorityQueue prefetchRequests = new PriorityQueue(11, new LayoutNode$$ExternalSyntheticLambda0(3));
    public final Choreographer choreographer = Choreographer.getInstance();
    public final TwilightManager$TwilightState scope = new TwilightManager$TwilightState();

    /* JADX WARN: Code duplicated, block: B:10:0x0040  */
    public AndroidPrefetchScheduler(View view) {
        float refreshRate;
        this.view = view;
        if (frameIntervalNs == 0) {
            Display display = view.getDisplay();
            if (!view.isInEditMode() && display != null) {
                refreshRate = display.getRefreshRate();
                refreshRate = refreshRate < 30.0f ? 60.0f : refreshRate;
            }
            frameIntervalNs = (long) (1000000000 / refreshRate);
        }
        view.addOnAttachStateChangeListener(this);
        if (view.isAttachedToWindow()) {
            this.isActive = true;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        if (this.isActive) {
            this.frameStartTimeNanos = j;
            this.view.post(this);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.isActive = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        PriorityQueue priorityQueue = this.prefetchRequests;
        if (!priorityQueue.isEmpty() && this.prefetchScheduled && this.isActive) {
            View view = this.view;
            if (view.getWindowVisibility() == 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(view.getDrawingTime());
                boolean z = System.nanoTime() > (((long) 2) * frameIntervalNs) + nanos;
                TwilightManager$TwilightState twilightManager$TwilightState = this.scope;
                twilightManager$TwilightState.isNight = z;
                twilightManager$TwilightState.nextUpdate = Math.max(this.frameStartTimeNanos, nanos) + frameIntervalNs;
                boolean zRunRequest = false;
                while (!priorityQueue.isEmpty() && !zRunRequest) {
                    if (twilightManager$TwilightState.isNight) {
                        Trace.beginSection("compose:lazy:prefetch:idle_frame");
                        try {
                            zRunRequest = runRequest();
                            Trace.endSection();
                        } catch (Throwable th) {
                            Trace.endSection();
                            throw th;
                        }
                    } else {
                        zRunRequest = runRequest();
                    }
                }
                if (zRunRequest) {
                    this.choreographer.postFrameCallback(this);
                } else {
                    this.prefetchScheduled = false;
                }
                AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", 0L);
                return;
            }
        }
        this.prefetchScheduled = false;
    }

    public final boolean runRequest() {
        TwilightManager$TwilightState twilightManager$TwilightState = this.scope;
        long jAvailableTimeNanos = twilightManager$TwilightState.availableTimeNanos();
        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", jAvailableTimeNanos);
        boolean z = true;
        if (jAvailableTimeNanos > 0) {
            PriorityQueue priorityQueue = this.prefetchRequests;
            if (!((PriorityTask) priorityQueue.peek()).request.execute(twilightManager$TwilightState)) {
                priorityQueue.poll();
                z = false;
            }
            twilightManager$TwilightState.isNight = false;
        }
        return z;
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public final void schedulePrefetch(PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl) {
        this.prefetchRequests.add(new PriorityTask(1, prefetchHandleProvider$HandleAndRequestImpl));
        if (this.prefetchScheduled) {
            return;
        }
        this.prefetchScheduled = true;
        this.view.post(this);
    }
}
