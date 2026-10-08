package coil.compose;

import android.os.SystemClock;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import coil.request.Parameters;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadePainter extends Painter {
    public final ContentScale contentScale;
    public final int durationMillis;
    public final Painter end;
    public final boolean fadeStart;
    public boolean isDone;
    public Painter start;
    public final ParcelableSnapshotMutableIntState invalidateTick$delegate = new ParcelableSnapshotMutableIntState(0);
    public long startTimeMillis = -1;
    public final ParcelableSnapshotMutableFloatState maxAlpha$delegate = new ParcelableSnapshotMutableFloatState(1.0f);
    public final ParcelableSnapshotMutableState colorFilter$delegate = Stack.mutableStateOf$default(null);

    public CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, int i, boolean z) {
        this.start = painter;
        this.end = painter2;
        this.contentScale = contentScale;
        this.durationMillis = i;
        this.fadeStart = z;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyAlpha(float f) {
        this.maxAlpha$delegate.setFloatValue(f);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter$delegate.setValue(blendModeColorFilter);
    }

    public final void drawPainter(LayoutNodeDrawScope layoutNodeDrawScope, Painter painter, float f) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        if (painter == null || f <= 0.0f) {
            return;
        }
        long jMo474getSizeNHjbRc = layoutNodeDrawScope.mo474getSizeNHjbRc();
        long jMo492getIntrinsicSizeNHjbRc = painter.mo492getIntrinsicSizeNHjbRc();
        long jM539timesUQTWf7w = (jMo492getIntrinsicSizeNHjbRc == 9205357640488583168L || Size.m388isEmptyimpl(jMo492getIntrinsicSizeNHjbRc) || jMo474getSizeNHjbRc == 9205357640488583168L || Size.m388isEmptyimpl(jMo474getSizeNHjbRc)) ? jMo474getSizeNHjbRc : RulerKt.m539timesUQTWf7w(jMo492getIntrinsicSizeNHjbRc, this.contentScale.mo516computeScaleFactorH7hwNQA(jMo492getIntrinsicSizeNHjbRc, jMo474getSizeNHjbRc));
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.colorFilter$delegate;
        if (jMo474getSizeNHjbRc == 9205357640488583168L || Size.m388isEmptyimpl(jMo474getSizeNHjbRc)) {
            painter.m495drawx_KDEd0(layoutNodeDrawScope, jM539timesUQTWf7w, f, (BlendModeColorFilter) parcelableSnapshotMutableState.getValue());
            return;
        }
        long j = jM539timesUQTWf7w;
        float f2 = 2;
        float fM387getWidthimpl = (Size.m387getWidthimpl(jMo474getSizeNHjbRc) - Size.m387getWidthimpl(j)) / f2;
        float fM385getHeightimpl = (Size.m385getHeightimpl(jMo474getSizeNHjbRc) - Size.m385getHeightimpl(j)) / f2;
        ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).inset(fM387getWidthimpl, fM385getHeightimpl, fM387getWidthimpl, fM385getHeightimpl);
        painter.m495drawx_KDEd0(layoutNodeDrawScope, j, f, (BlendModeColorFilter) parcelableSnapshotMutableState.getValue());
        float f3 = -fM387getWidthimpl;
        float f4 = -fM385getHeightimpl;
        ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).inset(f3, f4, f3, f4);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo492getIntrinsicSizeNHjbRc() {
        Painter painter = this.start;
        long jMo492getIntrinsicSizeNHjbRc = painter != null ? painter.mo492getIntrinsicSizeNHjbRc() : 0L;
        Painter painter2 = this.end;
        long jMo492getIntrinsicSizeNHjbRc2 = painter2 != null ? painter2.mo492getIntrinsicSizeNHjbRc() : 0L;
        boolean z = jMo492getIntrinsicSizeNHjbRc != 9205357640488583168L;
        boolean z2 = jMo492getIntrinsicSizeNHjbRc2 != 9205357640488583168L;
        if (z && z2) {
            return SizeKt.Size(Math.max(Size.m387getWidthimpl(jMo492getIntrinsicSizeNHjbRc), Size.m387getWidthimpl(jMo492getIntrinsicSizeNHjbRc2)), Math.max(Size.m385getHeightimpl(jMo492getIntrinsicSizeNHjbRc), Size.m385getHeightimpl(jMo492getIntrinsicSizeNHjbRc2)));
        }
        return 9205357640488583168L;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean z = this.isDone;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.maxAlpha$delegate;
        Painter painter = this.end;
        if (z) {
            drawPainter(layoutNodeDrawScope, painter, parcelableSnapshotMutableFloatState.getFloatValue());
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.startTimeMillis == -1) {
            this.startTimeMillis = jUptimeMillis;
        }
        float f = (jUptimeMillis - this.startTimeMillis) / this.durationMillis;
        float floatValue = parcelableSnapshotMutableFloatState.getFloatValue() * RangesKt.coerceIn(f, 0.0f, 1.0f);
        float floatValue2 = this.fadeStart ? parcelableSnapshotMutableFloatState.getFloatValue() - floatValue : parcelableSnapshotMutableFloatState.getFloatValue();
        this.isDone = f >= 1.0f;
        drawPainter(layoutNodeDrawScope, this.start, floatValue2);
        drawPainter(layoutNodeDrawScope, painter, floatValue);
        if (this.isDone) {
            this.start = null;
        } else {
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.invalidateTick$delegate;
            parcelableSnapshotMutableIntState.setIntValue(parcelableSnapshotMutableIntState.getIntValue() + 1);
        }
    }
}
