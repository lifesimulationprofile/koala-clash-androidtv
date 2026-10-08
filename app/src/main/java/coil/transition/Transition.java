package coil.transition;

import coil.compose.AsyncImagePainterKt$fakeTransitionTarget$1;
import coil.request.ImageResult;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface Transition {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Factory {
        public static final NoneTransition.Factory NONE = new NoneTransition.Factory();

        Transition create(AsyncImagePainterKt$fakeTransitionTarget$1 asyncImagePainterKt$fakeTransitionTarget$1, ImageResult imageResult);
    }

    void transition();
}
