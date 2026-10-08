package androidx.dynamicanimation.animation;

import androidx.collection.SimpleArrayMap;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationHandler {
    public static final ThreadLocal sAnimatorHandler = new ThreadLocal();
    public ImageLoader$Builder mProvider;
    public final SimpleArrayMap mDelayedCallbackStartTime = new SimpleArrayMap(0);
    public final ArrayList mAnimationCallbacks = new ArrayList();
    public final MemoryCacheService mCallbackDispatcher = new MemoryCacheService(14, this);
    public boolean mListDirty = false;
}
