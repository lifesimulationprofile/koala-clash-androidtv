package androidx.navigationevent;

import java.util.LinkedHashSet;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationEventHandler {
    public final NavigationEventInfo currentInfo;
    public Dispatcher dispatcher;
    public boolean isBackEnabled;

    public NavigationEventHandler(NavigationEventInfo navigationEventInfo, boolean z) {
        this.currentInfo = navigationEventInfo;
        this.isBackEnabled = z;
    }

    public abstract void onBackCancelled();

    public abstract void onBackCompleted();

    public abstract void onBackProgressed(NavigationEvent navigationEvent);

    public abstract void onBackStarted(NavigationEvent navigationEvent);

    public final void remove() {
        Dispatcher dispatcher = this.dispatcher;
        if (dispatcher == null || !((LinkedHashSet) dispatcher.runningAsyncCalls).remove(this)) {
            return;
        }
        NavigationEventProcessor navigationEventProcessor = (NavigationEventProcessor) dispatcher.readyAsyncCalls;
        if (equals(navigationEventProcessor.inProgressHandler)) {
            if (navigationEventProcessor.inProgressDirection == -1) {
                onBackCancelled();
            }
            navigationEventProcessor.inProgressHandler = null;
            navigationEventProcessor.inProgressDirection = 0;
            navigationEventProcessor.inProgressInput = null;
        }
        navigationEventProcessor.overlayHandlers.remove(this);
        navigationEventProcessor.defaultHandlers.remove(this);
        this.dispatcher = null;
        navigationEventProcessor.refreshEnabledHandlers();
    }

    public final void setBackEnabled(boolean z) {
        NavigationEventProcessor navigationEventProcessor;
        if (this.isBackEnabled == z) {
            return;
        }
        this.isBackEnabled = z;
        Dispatcher dispatcher = this.dispatcher;
        if (dispatcher == null || (navigationEventProcessor = (NavigationEventProcessor) dispatcher.readyAsyncCalls) == null) {
            return;
        }
        navigationEventProcessor.refreshEnabledHandlers();
    }
}
