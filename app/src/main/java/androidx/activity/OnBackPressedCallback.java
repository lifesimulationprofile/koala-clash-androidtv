package androidx.activity;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    public boolean isEnabled;
    public final ArrayList eventHandlers = new ArrayList();
    public final CopyOnWriteArrayList closeables = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class OnBackPressedEventHandler extends NavigationEventHandler {
        public boolean isLifecycleActive;
        public final OnBackPressedCallback onBackPressedCallback;

        public OnBackPressedEventHandler(OnBackPressedCallback onBackPressedCallback, OnBackPressedCallbackInfo onBackPressedCallbackInfo) {
            super(onBackPressedCallbackInfo, onBackPressedCallback.isEnabled);
            this.onBackPressedCallback = onBackPressedCallback;
            this.isLifecycleActive = true;
        }

        @Override // androidx.navigationevent.NavigationEventHandler
        public final void onBackCancelled() {
            this.onBackPressedCallback.handleOnBackCancelled();
        }

        @Override // androidx.navigationevent.NavigationEventHandler
        public final void onBackCompleted() {
            this.onBackPressedCallback.handleOnBackPressed();
        }

        @Override // androidx.navigationevent.NavigationEventHandler
        public final void onBackProgressed(NavigationEvent navigationEvent) {
            this.onBackPressedCallback.handleOnBackProgressed(new BackEventCompat(navigationEvent));
        }

        @Override // androidx.navigationevent.NavigationEventHandler
        public final void onBackStarted(NavigationEvent navigationEvent) {
            this.onBackPressedCallback.handleOnBackStarted(new BackEventCompat(navigationEvent));
        }

        public final void setLifecycleActive(boolean z) {
            this.isLifecycleActive = z;
            setBackEnabled(z && this.onBackPressedCallback.isEnabled);
        }
    }

    public OnBackPressedCallback(boolean z) {
        this.isEnabled = z;
    }

    public abstract void handleOnBackPressed();

    public final void remove() throws Exception {
        CopyOnWriteArrayList<AutoCloseable> copyOnWriteArrayList = this.closeables;
        for (AutoCloseable autoCloseable : copyOnWriteArrayList) {
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
            } else if (autoCloseable instanceof ExecutorService) {
                LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((ExecutorService) autoCloseable);
            } else if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
            } else if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
            } else if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else {
                if (!(autoCloseable instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) autoCloseable).release();
            }
        }
        copyOnWriteArrayList.clear();
        ArrayList arrayList = this.eventHandlers;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((OnBackPressedEventHandler) obj).remove();
        }
        arrayList.clear();
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        ArrayList arrayList = this.eventHandlers;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            OnBackPressedEventHandler onBackPressedEventHandler = (OnBackPressedEventHandler) obj;
            onBackPressedEventHandler.setBackEnabled(onBackPressedEventHandler.isLifecycleActive && z);
        }
    }

    public void handleOnBackCancelled() {
    }

    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
    }

    public void handleOnBackStarted(BackEventCompat backEventCompat) {
    }
}
