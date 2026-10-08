package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DrawingDelegate {
    public DrawableWithAnimatedVisibilityChange drawable;
    public LinearProgressIndicatorSpec spec;

    public final void validateSpecAndAdjustCanvas(Canvas canvas, float f) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        this.spec.validateSpec();
        LinearDrawingDelegate linearDrawingDelegate = (LinearDrawingDelegate) this;
        Rect clipBounds = canvas.getClipBounds();
        linearDrawingDelegate.trackLength = clipBounds.width();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = linearDrawingDelegate.spec;
        float f2 = linearProgressIndicatorSpec.trackThickness;
        canvas.translate((clipBounds.width() / 2.0f) + clipBounds.left, Math.max(0.0f, (clipBounds.height() - linearProgressIndicatorSpec.trackThickness) / 2.0f) + (clipBounds.height() / 2.0f) + clipBounds.top);
        if (linearProgressIndicatorSpec.drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        ObjectAnimator objectAnimator3 = linearDrawingDelegate.drawable.showAnimator;
        if ((objectAnimator3 != null && objectAnimator3.isRunning() && linearProgressIndicatorSpec.showAnimationBehavior == 1) || ((objectAnimator = linearDrawingDelegate.drawable.hideAnimator) != null && objectAnimator.isRunning() && linearProgressIndicatorSpec.hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        ObjectAnimator objectAnimator4 = linearDrawingDelegate.drawable.showAnimator;
        if ((objectAnimator4 != null && objectAnimator4.isRunning()) || ((objectAnimator2 = linearDrawingDelegate.drawable.hideAnimator) != null && objectAnimator2.isRunning())) {
            canvas.translate(0.0f, ((f - 1.0f) * linearProgressIndicatorSpec.trackThickness) / 2.0f);
        }
        float f3 = linearDrawingDelegate.trackLength;
        canvas.clipRect((-f3) / 2.0f, (-f2) / 2.0f, f3 / 2.0f, f2 / 2.0f);
        linearDrawingDelegate.displayedTrackThickness = linearProgressIndicatorSpec.trackThickness * f;
        linearDrawingDelegate.displayedCornerRadius = linearProgressIndicatorSpec.trackCornerRadius * f;
    }
}
