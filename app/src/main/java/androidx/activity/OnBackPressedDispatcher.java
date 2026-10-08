package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigationevent.NavigationEventInput;
import androidx.navigationevent.NavigationEventProcessor;
import java.util.LinkedHashSet;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    public final Dispatcher eventDispatcher;
    public final OnBackPressedEventInput eventInput;
    public final Runnable fallbackOnBackPressed;

    public OnBackPressedDispatcher(Runnable runnable) {
        this.fallbackOnBackPressed = runnable;
        OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(0, this);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.executorServiceOrNull = onBackPressedDispatcher$$ExternalSyntheticLambda0;
        dispatcher.readyAsyncCalls = new NavigationEventProcessor();
        new LinkedHashSet();
        dispatcher.runningAsyncCalls = new LinkedHashSet();
        dispatcher.runningSyncCalls = new LinkedHashSet();
        this.eventDispatcher = dispatcher;
        OnBackPressedEventInput onBackPressedEventInput = new OnBackPressedEventInput();
        this.eventInput = onBackPressedEventInput;
        dispatcher.addInput(onBackPressedEventInput);
    }

    public final void addCallback(OnBackPressedCallback onBackPressedCallback, LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        OnBackPressedCallback.OnBackPressedEventHandler onBackPressedEventHandler = new OnBackPressedCallback.OnBackPressedEventHandler(onBackPressedCallback, new OnBackPressedCallbackInfo(onBackPressedCallback, lifecycleOwner));
        onBackPressedCallback.eventHandlers.add(onBackPressedEventHandler);
        onBackPressedEventHandler.setLifecycleActive(false);
        Dispatcher.addHandler$default(this.eventDispatcher, onBackPressedEventHandler);
        OnBackPressedDispatcher$addCallback$lifecycleObserver$1 onBackPressedDispatcher$addCallback$lifecycleObserver$1 = new OnBackPressedDispatcher$addCallback$lifecycleObserver$1(onBackPressedEventHandler, this, lifecycle);
        lifecycle.addObserver(onBackPressedDispatcher$addCallback$lifecycleObserver$1);
        onBackPressedCallback.closeables.add(onBackPressedDispatcher$addCallback$lifecycleObserver$1);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class OnBackPressedEventInput extends NavigationEventInput {
        @Override // androidx.navigationevent.NavigationEventInput
        public final void onHasEnabledHandlersChanged(boolean z) {
        }
    }
}
