package androidx.camera.core;

import android.graphics.Matrix;
import android.media.Image;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.view.PreviewView;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidImageProxy implements ImageProxy {
    public final Image mImage;
    public final AutoValue_ImmutableImageInfo mImageInfo;
    public final PreviewView.AnonymousClass1[] mPlanes;

    public AndroidImageProxy(Image image) {
        this.mImage = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.mPlanes = new PreviewView.AnonymousClass1[planes.length];
            for (int i = 0; i < planes.length; i++) {
                this.mPlanes[i] = new PreviewView.AnonymousClass1(14, planes[i]);
            }
        } else {
            this.mPlanes = new PreviewView.AnonymousClass1[0];
        }
        this.mImageInfo = new AutoValue_ImmutableImageInfo(TagBundle.EMPTY_TAGBUNDLE, image.getTimestamp(), 0, new Matrix());
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.mImage.close();
    }

    @Override // androidx.camera.core.ImageProxy
    public final int getFormat() {
        return this.mImage.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public final int getHeight() {
        return this.mImage.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    public final Image getImage() {
        return this.mImage;
    }

    @Override // androidx.camera.core.ImageProxy
    public final ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    @Override // androidx.camera.core.ImageProxy
    public final PreviewView.AnonymousClass1[] getPlanes() {
        return this.mPlanes;
    }

    @Override // androidx.camera.core.ImageProxy
    public final int getWidth() {
        return this.mImage.getWidth();
    }
}
