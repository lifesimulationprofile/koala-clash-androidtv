package com.google.accompanist.drawablepainter;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import coil.network.HttpException;
import kotlin.SynchronizedLazyImpl;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DrawablePainter extends Painter implements RememberObserver {
    public final SynchronizedLazyImpl callback$delegate;
    public final ParcelableSnapshotMutableState drawInvalidateTick$delegate = Stack.mutableStateOf$default(0);
    public final Drawable drawable;
    public final ParcelableSnapshotMutableState drawableIntrinsicSize$delegate;

    public DrawablePainter(Drawable drawable) {
        this.drawable = drawable;
        Object obj = DrawablePainterKt.MAIN_HANDLER$delegate;
        this.drawableIntrinsicSize$delegate = Stack.mutableStateOf$default(new Size((drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) ? 9205357640488583168L : SizeKt.Size(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight())));
        this.callback$delegate = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(22, this));
        if (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyAlpha(float f) {
        this.drawable.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(f * 255), 0, 255));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.drawable.setColorFilter(blendModeColorFilter != null ? blendModeColorFilter.nativeColorFilter : null);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyLayoutDirection(LayoutDirection layoutDirection) {
        int i;
        int iOrdinal = layoutDirection.ordinal();
        if (iOrdinal != 0) {
            i = 1;
            if (iOrdinal != 1) {
                throw new HttpException();
            }
        } else {
            i = 0;
        }
        this.drawable.setLayoutDirection(i);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo492getIntrinsicSizeNHjbRc() {
        return ((Size) this.drawableIntrinsicSize$delegate.getValue()).packedValue;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        onForgotten();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        Canvas canvas = layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas();
        ((Number) this.drawInvalidateTick$delegate.getValue()).intValue();
        int iRoundToInt = MathKt.roundToInt(Size.m387getWidthimpl(layoutNodeDrawScope.mo474getSizeNHjbRc()));
        int iRoundToInt2 = MathKt.roundToInt(Size.m385getHeightimpl(layoutNodeDrawScope.mo474getSizeNHjbRc()));
        Drawable drawable = this.drawable;
        drawable.setBounds(0, 0, iRoundToInt, iRoundToInt2);
        try {
            canvas.save();
            android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
            drawable.draw(((AndroidCanvas) canvas).internalCanvas);
        } finally {
            canvas.restore();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        Drawable drawable = this.drawable;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        drawable.setVisible(false, false);
        drawable.setCallback(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        Drawable.Callback callback = (Drawable.Callback) this.callback$delegate.getValue();
        Drawable drawable = this.drawable;
        drawable.setCallback(callback);
        drawable.setVisible(true, true);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}
