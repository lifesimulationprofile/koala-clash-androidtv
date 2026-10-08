package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import coil.util.Lifecycles$awaitStarted$2$1;
import com.github.kr328.clash.remote.StatusClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer {
    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig = new FontRequestEmojiCompatConfig(new StatusClient(context));
        fontRequestEmojiCompatConfig.mMetadataLoadStrategy = 1;
        if (EmojiCompat.sInstance == null) {
            synchronized (EmojiCompat.INSTANCE_LOCK) {
                try {
                    if (EmojiCompat.sInstance == null) {
                        EmojiCompat.sInstance = new EmojiCompat(fontRequestEmojiCompatConfig);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        delayUntilFirstResume(context);
        return Boolean.TRUE;
    }

    public final void delayUntilFirstResume(Context context) {
        Object objDoInitialize;
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        appInitializer.getClass();
        synchronized (AppInitializer.sLock) {
            try {
                objDoInitialize = appInitializer.mInitialized.get(ProcessLifecycleInitializer.class);
                if (objDoInitialize == null) {
                    objDoInitialize = appInitializer.doInitialize(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Lifecycle lifecycle = ((LifecycleOwner) objDoInitialize).getLifecycle();
        lifecycle.addObserver(new Lifecycles$awaitStarted$2$1(this, lifecycle));
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
