package androidx.compose.material3.internal.ripple;

import android.R;
import android.app.PendingIntent;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RippleHostView extends View {
    public static final int[] PressedState = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] RestingState = new int[0];
    public Boolean bounded;
    public Long lastRippleStateChangeTimeMillis;
    public BasicTextKt$$ExternalSyntheticLambda0 onInvalidateRipple;
    public Preview$$ExternalSyntheticLambda0 resetRippleRunnable;
    public UnprojectedRipple ripple;

    private final void setRippleState(boolean z) throws Throwable {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l = this.lastRippleStateChangeTimeMillis;
        long jLongValue = jCurrentAnimationTimeMillis - (l != null ? l.longValue() : 0L);
        if (z || jLongValue >= 5) {
            int[] iArr = z ? PressedState : RestingState;
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(iArr);
            }
        } else {
            Preview$$ExternalSyntheticLambda0 preview$$ExternalSyntheticLambda0 = new Preview$$ExternalSyntheticLambda0(25, this);
            this.resetRippleRunnable = preview$$ExternalSyntheticLambda0;
            postDelayed(preview$$ExternalSyntheticLambda0, 50L);
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRippleState$lambda$1(RippleHostView rippleHostView) {
        UnprojectedRipple unprojectedRipple = rippleHostView.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.setState(RestingState);
        }
        rippleHostView.resetRippleRunnable = null;
    }

    /* JADX INFO: renamed from: addRipple-KOepWvA, reason: not valid java name */
    public final void m286addRippleKOepWvA(PressInteraction.Press press, boolean z, long j, int i, long j2, float f, BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda0) throws Throwable {
        if (this.ripple == null || !Boolean.valueOf(z).equals(this.bounded)) {
            UnprojectedRipple unprojectedRipple = new UnprojectedRipple(z);
            setBackground(unprojectedRipple);
            this.ripple = unprojectedRipple;
            this.bounded = Boolean.valueOf(z);
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        this.onInvalidateRipple = basicTextKt$$ExternalSyntheticLambda0;
        m287setRipplePropertiesbiQXAtU(j, i, j2, f);
        if (z) {
            unprojectedRipple2.setHotspot(Float.intBitsToFloat((int) (press.pressPosition >> 32)), Float.intBitsToFloat((int) (press.pressPosition & 4294967295L)));
        } else {
            unprojectedRipple2.setHotspot(unprojectedRipple2.getBounds().centerX(), unprojectedRipple2.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void disposeRipple() throws Throwable {
        this.onInvalidateRipple = null;
        Preview$$ExternalSyntheticLambda0 preview$$ExternalSyntheticLambda0 = this.resetRippleRunnable;
        if (preview$$ExternalSyntheticLambda0 != null) {
            removeCallbacks(preview$$ExternalSyntheticLambda0);
            this.resetRippleRunnable.run();
        } else {
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(RestingState);
            }
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        if (unprojectedRipple2 == null) {
            return;
        }
        unprojectedRipple2.setVisible(false, false);
        unscheduleDrawable(unprojectedRipple2);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) throws Throwable {
        if (isAttachedToWindow()) {
            super.draw(canvas);
        } else {
            disposeRipple();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) throws PendingIntent.CanceledException {
        BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda0 = this.onInvalidateRipple;
        if (basicTextKt$$ExternalSyntheticLambda0 != null) {
            basicTextKt$$ExternalSyntheticLambda0.invoke();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final void removeRipple() throws Throwable {
        setRippleState(false);
    }

    /* JADX INFO: renamed from: setRippleProperties-biQXAtU, reason: not valid java name */
    public final void m287setRipplePropertiesbiQXAtU(long j, int i, long j2, float f) {
        UnprojectedRipple unprojectedRipple = this.ripple;
        if (unprojectedRipple == null) {
            return;
        }
        if (unprojectedRipple.getRadius() != i) {
            unprojectedRipple.setRadius(i);
        }
        if (Build.VERSION.SDK_INT < 28) {
            f *= 2;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        long jColor = BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), f, Color.m438getColorSpaceimpl(j2));
        Color color = unprojectedRipple.rippleColor;
        if (!(color == null ? false : Color.m435equalsimpl0(color.value, jColor))) {
            unprojectedRipple.rippleColor = new Color(jColor);
            unprojectedRipple.setColor(ColorStateList.valueOf(BrushKt.m426toArgb8_81llA(jColor)));
        }
        Rect rect = new Rect(0, 0, MathKt.roundToInt(Float.intBitsToFloat((int) (j >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (j & 4294967295L))));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        unprojectedRipple.setBounds(rect);
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
