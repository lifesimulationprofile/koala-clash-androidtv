package androidx.activity.compose.internal;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedCallbackInfo;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.fragment.app.FragmentManager$1;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BackHandlerDispatcherCompat {
    public final Dispatcher navigationEventDispatcher;
    public final OnBackPressedDispatcher onBackPressedDispatcher;

    public BackHandlerDispatcherCompat(Dispatcher dispatcher, OnBackPressedDispatcher onBackPressedDispatcher) {
        this.navigationEventDispatcher = dispatcher;
        this.onBackPressedDispatcher = onBackPressedDispatcher;
        if ((dispatcher == null ? onBackPressedDispatcher : dispatcher) == null) {
            throw new IllegalArgumentException("At least one dispatcher (NavigationEventDispatcher or OnBackPressedDispatcher) must be non-null.");
        }
    }

    public final void addHandler(BaseMenuWrapper baseMenuWrapper) {
        Dispatcher dispatcher = this.navigationEventDispatcher;
        if (dispatcher != null) {
            Dispatcher.addHandler$default(dispatcher, (BackHandlerCompat$navigationEventHandler$1) baseMenuWrapper.mMenuItems);
            return;
        }
        OnBackPressedDispatcher onBackPressedDispatcher = this.onBackPressedDispatcher;
        if (onBackPressedDispatcher == null) {
            throw new IllegalStateException("Unreachable");
        }
        FragmentManager$1 fragmentManager$1 = (FragmentManager$1) baseMenuWrapper.mContext;
        OnBackPressedCallback.OnBackPressedEventHandler onBackPressedEventHandler = new OnBackPressedCallback.OnBackPressedEventHandler(fragmentManager$1, new OnBackPressedCallbackInfo(fragmentManager$1, null));
        fragmentManager$1.eventHandlers.add(onBackPressedEventHandler);
        Dispatcher.addHandler$default(onBackPressedDispatcher.eventDispatcher, onBackPressedEventHandler);
    }

    public final void removeHandler(BaseMenuWrapper baseMenuWrapper) throws Exception {
        if (this.navigationEventDispatcher != null) {
            ((BackHandlerCompat$navigationEventHandler$1) baseMenuWrapper.mMenuItems).remove();
        } else {
            if (this.onBackPressedDispatcher == null) {
                throw new IllegalStateException("Unreachable");
            }
            ((FragmentManager$1) baseMenuWrapper.mContext).remove();
        }
    }
}
