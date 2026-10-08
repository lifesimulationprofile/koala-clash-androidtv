package androidx.camera.camera2.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.camera.camera2.internal.ExposureStateImpl;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ExposureStateImpl implements Factory, ComponentFactory {
    public static ExposureStateImpl snackbarManager;
    public final Object mLock;

    public /* synthetic */ ExposureStateImpl(Object obj) {
        this.mLock = obj;
    }

    public static ExposureStateImpl obtain(int i, int i2, int i3) {
        return new ExposureStateImpl(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, false, i3));
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(RestrictedComponentContainer restrictedComponentContainer) {
        return this.mLock;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return this.mLock;
    }

    public void pauseTimeout() {
        synchronized (this.mLock) {
        }
    }

    public ExposureStateImpl(int i) {
        switch (i) {
            case 5:
                this.mLock = new Object();
                new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager$1
                    @Override // android.os.Handler.Callback
                    public final boolean handleMessage(Message message) {
                        if (message.what != 0) {
                            return false;
                        }
                        ExposureStateImpl exposureStateImpl = this.this$0;
                        if (message.obj != null) {
                            throw new ClassCastException();
                        }
                        synchronized (exposureStateImpl.mLock) {
                            throw null;
                        }
                    }
                });
                break;
            default:
                this.mLock = new Object();
                break;
        }
    }
}
