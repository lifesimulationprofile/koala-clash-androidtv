package androidx.camera.core.resolutionselector;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ResolutionStrategy {
    public static final ResolutionStrategy HIGHEST_AVAILABLE_STRATEGY;
    public Size mBoundSize;
    public int mFallbackRule = 1;

    static {
        ResolutionStrategy resolutionStrategy = new ResolutionStrategy();
        resolutionStrategy.mBoundSize = null;
        resolutionStrategy.mFallbackRule = 0;
        HIGHEST_AVAILABLE_STRATEGY = resolutionStrategy;
    }

    public ResolutionStrategy(Size size) {
        this.mBoundSize = size;
    }
}
