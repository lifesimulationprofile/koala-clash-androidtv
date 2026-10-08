package androidx.navigationevent;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationEventInput {
    public Dispatcher dispatcher;
    public boolean isPredictiveBackInProgress;

    public final void dispatchOnBackCompleted() {
        Dispatcher dispatcher = this.dispatcher;
        if (dispatcher == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!this.isPredictiveBackInProgress) {
            dispatcher.dispatchOnStarted$navigationevent(this, null);
        }
        NavigationEventProcessor navigationEventProcessor = (NavigationEventProcessor) dispatcher.readyAsyncCalls;
        OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0 = (OnBackPressedDispatcher$$ExternalSyntheticLambda0) dispatcher.executorServiceOrNull;
        if (equals(navigationEventProcessor.inProgressInput) && -1 == navigationEventProcessor.inProgressDirection) {
            NavigationEventHandler navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.inProgressHandler;
            if (navigationEventHandlerResolveEnabledHandler == null) {
                navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.resolveEnabledHandler(-1);
            }
            navigationEventProcessor.inProgressHandler = null;
            navigationEventProcessor.inProgressDirection = 0;
            navigationEventProcessor.inProgressInput = null;
            if (navigationEventHandlerResolveEnabledHandler == null) {
                ((OnBackPressedDispatcher) onBackPressedDispatcher$$ExternalSyntheticLambda0.f$0).fallbackOnBackPressed.run();
            } else {
                navigationEventHandlerResolveEnabledHandler.onBackCompleted();
            }
            StateFlowImpl stateFlowImpl = navigationEventProcessor._transitionState;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, NavigationEventTransitionState.Idle.INSTANCE);
        }
        this.isPredictiveBackInProgress = false;
    }

    public void onHasEnabledHandlersChanged(boolean z) {
    }
}
