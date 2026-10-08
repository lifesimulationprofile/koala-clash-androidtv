package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeViewContext$callback$1 implements ComponentCallbacks2, ViewTreeObserver.OnWindowFocusChangeListener {
    public final /* synthetic */ ComposeViewContext this$0;

    public ComposeViewContext$callback$1(ComposeViewContext composeViewContext) {
        this.this$0 = composeViewContext;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.this$0.onConfigurationChanged$ui(configuration);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        ComposeViewContext composeViewContext = this.this$0;
        composeViewContext.imageVectorCache.map.clear();
        composeViewContext.resourceIdCache.clear();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        ComposeViewContext composeViewContext = this.this$0;
        composeViewContext.imageVectorCache.map.clear();
        composeViewContext.resourceIdCache.clear();
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        this.this$0.windowInfo.isWindowFocused$delegate.setValue(Boolean.valueOf(z));
    }
}
