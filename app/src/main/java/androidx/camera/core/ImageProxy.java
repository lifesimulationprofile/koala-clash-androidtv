package androidx.camera.core;

import android.media.Image;
import androidx.camera.view.PreviewView;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface ImageProxy extends AutoCloseable {
    int getFormat();

    int getHeight();

    Image getImage();

    ImageInfo getImageInfo();

    PreviewView.AnonymousClass1[] getPlanes();

    int getWidth();
}
