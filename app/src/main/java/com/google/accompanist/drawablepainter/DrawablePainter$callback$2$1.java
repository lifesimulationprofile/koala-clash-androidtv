package com.google.accompanist.drawablepainter;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DrawablePainter$callback$2$1 implements Drawable.Callback {
    public final /* synthetic */ int $r8$classId;
    public Object this$0;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.$r8$classId) {
            case 0:
                DrawablePainter drawablePainter = (DrawablePainter) this.this$0;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = drawablePainter.drawInvalidateTick$delegate;
                parcelableSnapshotMutableState.setValue(Integer.valueOf(((Number) parcelableSnapshotMutableState.getValue()).intValue() + 1));
                Drawable drawable2 = drawablePainter.drawable;
                Object obj = DrawablePainterKt.MAIN_HANDLER$delegate;
                drawablePainter.drawableIntrinsicSize$delegate.setValue(new Size((drawable2.getIntrinsicWidth() < 0 || drawable2.getIntrinsicHeight() < 0) ? 9205357640488583168L : SizeKt.Size(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight())));
                break;
            case 1:
                break;
            default:
                ((AnimatedVectorDrawableCompat) this.this$0).invalidateSelf();
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlin.Lazy] */
    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        switch (this.$r8$classId) {
            case 0:
                ((Handler) DrawablePainterKt.MAIN_HANDLER$delegate.getValue()).postAtTime(runnable, j);
                break;
            case 1:
                Drawable.Callback callback = (Drawable.Callback) this.this$0;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j);
                }
                break;
            default:
                ((AnimatedVectorDrawableCompat) this.this$0).scheduleSelf(runnable, j);
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlin.Lazy] */
    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                ((Handler) DrawablePainterKt.MAIN_HANDLER$delegate.getValue()).removeCallbacks(runnable);
                break;
            case 1:
                Drawable.Callback callback = (Drawable.Callback) this.this$0;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                }
                break;
            default:
                ((AnimatedVectorDrawableCompat) this.this$0).unscheduleSelf(runnable);
                break;
        }
    }

    public /* synthetic */ DrawablePainter$callback$2$1(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    private final void invalidateDrawable$androidx$appcompat$graphics$drawable$DrawableContainerCompat$BlockInvalidateCallback(Drawable drawable) {
    }
}
