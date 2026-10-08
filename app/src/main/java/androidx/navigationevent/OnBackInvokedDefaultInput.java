package androidx.navigationevent;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.compose.ui.window.Api33Impl$$ExternalSyntheticLambda0;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackInvokedDefaultInput extends NavigationEventInput {
    public boolean backInvokedCallbackRegistered;
    public final OnBackInvokedCallback onBackInvokedCallback;
    public final int onBackInvokedCallbackPriority;
    public final OnBackInvokedDispatcher onBackInvokedDispatcher;

    public OnBackInvokedDefaultInput(OnBackInvokedDispatcher onBackInvokedDispatcher, int i) {
        this.onBackInvokedDispatcher = onBackInvokedDispatcher;
        this.onBackInvokedCallbackPriority = i;
        this.onBackInvokedCallback = Build.VERSION.SDK_INT == 33 ? new Api33Impl$$ExternalSyntheticLambda0(3, this) : new OnBackAnimationCallback() { // from class: androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1
            public final void onBackCancelled() {
                OnBackInvokedDefaultInput onBackInvokedDefaultInput = this.this$0;
                Dispatcher dispatcher = onBackInvokedDefaultInput.dispatcher;
                if (dispatcher == null) {
                    throw new IllegalStateException("This input is not added to any dispatcher.");
                }
                if (!onBackInvokedDefaultInput.isPredictiveBackInProgress) {
                    dispatcher.dispatchOnStarted$navigationevent(onBackInvokedDefaultInput, null);
                }
                NavigationEventProcessor navigationEventProcessor = (NavigationEventProcessor) dispatcher.readyAsyncCalls;
                if (onBackInvokedDefaultInput.equals(navigationEventProcessor.inProgressInput) && -1 == navigationEventProcessor.inProgressDirection) {
                    NavigationEventHandler navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.inProgressHandler;
                    if (navigationEventHandlerResolveEnabledHandler == null) {
                        navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.resolveEnabledHandler(-1);
                    }
                    navigationEventProcessor.inProgressHandler = null;
                    navigationEventProcessor.inProgressDirection = 0;
                    navigationEventProcessor.inProgressInput = null;
                    if (navigationEventHandlerResolveEnabledHandler != null) {
                        navigationEventHandlerResolveEnabledHandler.onBackCancelled();
                    }
                    StateFlowImpl stateFlowImpl = navigationEventProcessor._transitionState;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, NavigationEventTransitionState.Idle.INSTANCE);
                }
                onBackInvokedDefaultInput.isPredictiveBackInProgress = false;
            }

            public final void onBackInvoked() {
                this.this$0.dispatchOnBackCompleted();
            }

            public final void onBackProgressed(BackEvent backEvent) {
                NavigationEvent NavigationEvent = NavigationEvent_androidKt.NavigationEvent(backEvent);
                OnBackInvokedDefaultInput onBackInvokedDefaultInput = this.this$0;
                Dispatcher dispatcher = onBackInvokedDefaultInput.dispatcher;
                if (dispatcher == null) {
                    throw new IllegalStateException("This input is not added to any dispatcher.");
                }
                if (onBackInvokedDefaultInput.isPredictiveBackInProgress) {
                    NavigationEventProcessor navigationEventProcessor = (NavigationEventProcessor) dispatcher.readyAsyncCalls;
                    if (onBackInvokedDefaultInput.equals(navigationEventProcessor.inProgressInput) && -1 == navigationEventProcessor.inProgressDirection) {
                        NavigationEventHandler navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.inProgressHandler;
                        if (navigationEventHandlerResolveEnabledHandler == null) {
                            navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.resolveEnabledHandler(-1);
                        }
                        if (navigationEventHandlerResolveEnabledHandler != null) {
                            navigationEventHandlerResolveEnabledHandler.onBackProgressed(NavigationEvent);
                        }
                        StateFlowImpl stateFlowImpl = navigationEventProcessor._transitionState;
                        NavigationEventTransitionState.InProgress inProgress = new NavigationEventTransitionState.InProgress(NavigationEvent);
                        stateFlowImpl.getClass();
                        stateFlowImpl.updateState(null, inProgress);
                    }
                }
            }

            public final void onBackStarted(BackEvent backEvent) {
                NavigationEvent NavigationEvent = NavigationEvent_androidKt.NavigationEvent(backEvent);
                OnBackInvokedDefaultInput onBackInvokedDefaultInput = this.this$0;
                Dispatcher dispatcher = onBackInvokedDefaultInput.dispatcher;
                if (dispatcher == null) {
                    throw new IllegalStateException("This input is not added to any dispatcher.");
                }
                if (onBackInvokedDefaultInput.isPredictiveBackInProgress) {
                    return;
                }
                dispatcher.dispatchOnStarted$navigationevent(onBackInvokedDefaultInput, NavigationEvent);
                onBackInvokedDefaultInput.isPredictiveBackInProgress = true;
            }
        };
    }

    @Override // androidx.navigationevent.NavigationEventInput
    public final void onHasEnabledHandlersChanged(boolean z) {
        if (z && !this.backInvokedCallbackRegistered) {
            this.onBackInvokedDispatcher.registerOnBackInvokedCallback(this.onBackInvokedCallbackPriority, this.onBackInvokedCallback);
            this.backInvokedCallbackRegistered = true;
        } else {
            if (z || !this.backInvokedCallbackRegistered) {
                return;
            }
            this.onBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
            this.backInvokedCallbackRegistered = false;
        }
    }
}
