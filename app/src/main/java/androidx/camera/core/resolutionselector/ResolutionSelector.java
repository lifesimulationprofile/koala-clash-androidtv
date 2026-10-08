package androidx.camera.core.resolutionselector;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ResolutionSelector {
    public final AspectRatioStrategy mAspectRatioStrategy;
    public final ResolutionStrategy mResolutionStrategy;

    public ResolutionSelector(AspectRatioStrategy aspectRatioStrategy, ResolutionStrategy resolutionStrategy, ImageAnalysis$$ExternalSyntheticLambda1 imageAnalysis$$ExternalSyntheticLambda1) {
        this.mAspectRatioStrategy = aspectRatioStrategy;
        this.mResolutionStrategy = resolutionStrategy;
    }
}
